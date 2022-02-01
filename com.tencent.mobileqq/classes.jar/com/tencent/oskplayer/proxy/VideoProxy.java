package com.tencent.oskplayer.proxy;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.oskplayer.PlayerConfig;
import com.tencent.oskplayer.cache.Cache;
import com.tencent.oskplayer.cache.CacheListener;
import com.tencent.oskplayer.cache.LeastRecentlyUsedCacheEvictor;
import com.tencent.oskplayer.cache.SimpleCache;
import com.tencent.oskplayer.datasource.DataSource;
import com.tencent.oskplayer.datasource.DataSpec;
import com.tencent.oskplayer.datasource.DefaultHttpDataSource;
import com.tencent.oskplayer.datasource.DownloadListener;
import com.tencent.oskplayer.datasource.HttpDataSource.InterruptConnectServerException;
import com.tencent.oskplayer.datasource.HttpDataSource.InterruptReadException;
import com.tencent.oskplayer.datasource.HttpHeader;
import com.tencent.oskplayer.datasource.IllegalDataSpecException;
import com.tencent.oskplayer.datasource.VideoDownloadListener;
import com.tencent.oskplayer.report.IVideoReporter;
import com.tencent.oskplayer.support.util.OskFile;
import com.tencent.oskplayer.util.HttpParser;
import com.tencent.oskplayer.util.PlayerUtils;
import com.tencent.oskplayer.util.SecretUtils;
import com.tencent.oskplayer.util.StorageUtil;
import com.tencent.oskplayer.util.ThreadUtils;
import com.tencent.oskplayer.util.ThreadUtils.FlexibleSizeExecutor;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class VideoProxy
{
  public static final String LOG_TAG_PREFIX = "VideoProxy/";
  private static final String MTYPE = "qzone_video_player";
  public static final String PARAM_DATASOURCE_TYPE = "dataSourceType";
  public static final String PARAM_ENABLE_CACHE = "enableCache";
  private static final String PARAM_EXTRAHEADER = "eh";
  private static final String PARAM_MTYPE = "mType";
  public static final String PARAM_PREPERRED_CONTENT_TYPE = "preferredContentType";
  private static final String PARAM_PRIORITY = "p";
  private static final String PARAM_TOKEN = "t";
  public static final String PARAM_URL = "v";
  public static final String PARAM_UUID = "uuid";
  private static AtomicInteger PLAY_LIST_ID = new AtomicInteger(10000);
  private static final String PROXY_HOST = "0.0.0.0";
  public static final String PROXY_SERVER = "http://127.0.0.1";
  private static final String TAG = "VideoProxy";
  private static final String TAG_SEP = "/";
  private static final String USER_AGENT = "com.qzone.player-v20150909";
  public static final String VALUE_CACHE_ENABLED = "1";
  public static final String VALUE_CACHE_NOT_ENABLED = "0";
  public static final String VALUE_CACHE_PLACEHOLDER = "[VALUE_CACHE_PLACEHOLDER]";
  public static final String VALUE_CACHE_PLACEHOLDER_REG = "\\[VALUE_CACHE_PLACEHOLDER\\]";
  public static final String VALUE_CONTENT_TYPE_VIDEO_M3U8 = "application/vnd.apple.mpegurl";
  public static final String VALUE_CONTENT_TYPE_VIDEO_MP4 = "video/mp4";
  public static final String VALUE_CONTENT_TYPE_VIDEO_MPEG_TS = "video/MP2T";
  public static final String VALUE_DATASOURCE_DEFAULT = "1";
  public static final String VALUE_DATASOURCE_TENCENT = "0";
  public static final String VALUE_DATASOURCE_UNKNOWN = "-1";
  public static final int VALUE_PRIORITY_NOT_SPECIFIED = -1;
  public static final int VALUE_PRIORITY_PLAY = 90;
  public static final int VALUE_PRIORITY_PRELOAD = 10;
  private static AtomicInteger VIDEO_UUID = new AtomicInteger(10000);
  public static final int _UNKNOWN = -1;
  private static final int sExtraHeaderCollectionMax = 100;
  public final int PROXY_EXCEPTION_COUNT_MAX = 3;
  private Cache cache;
  private Map<String, VideoProxy.CacheReadListener> cacheReadListenerMap = new HashMap();
  private final ExecutorService executorService;
  private ConcurrentHashMap<String, HttpRetryLogic> httpRetryLogicMap = new ConcurrentHashMap(8, 0.75F, 2);
  private Map<String, VideoProxy.HttpErrorListener> httpUrlErrorListenerMap = new HashMap();
  private boolean isCacheProviderLocal = PlayerConfig.g().isCacheProviderLocal();
  private boolean isPauseTcStorageIO = false;
  private boolean isSecretEnable = true;
  private volatile boolean isShutdown;
  private Map<String, CacheListener> mCacheListenerMap = new ConcurrentHashMap();
  private Map<String, LivePlayListInfo> mErrorLivePlayListInfo = new ConcurrentHashMap();
  private Set<HttpHeader> mExtraHeaderCollection = Collections.newSetFromMap(Collections.synchronizedMap(new LinkedHashMap(5, 0.75F)));
  private Map<String, LivePlayListInfo> mLivePlayListInfo = new ConcurrentHashMap();
  private Map<String, PlayListInfo> mPlayListInfo = new ConcurrentHashMap();
  public int mProxyExceptionCount = 0;
  private int mRecvDataTreshold = 1000;
  private int serverPort;
  private ServerSocket serverSocket;
  private ITcDataSourceUtils tcDataSourceUtils;
  private Map<String, VideoProxy.HttpErrorListener> uuidErrorListenerMap = new HashMap();
  private Set<String> videoDownloadHashSet = Collections.synchronizedSet(new HashSet());
  private final VideoRequestManager videoRequestManager;
  private Thread waitConnectionThread;
  
  public VideoProxy()
  {
    Object localObject;
    if (this.isCacheProviderLocal)
    {
      localObject = PlayerConfig.g().getCacheDir();
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        this.cache = null;
        PlayerUtils.log(4, "VideoProxy", "cache provider is local ");
      }
    }
    for (;;)
    {
      PlayerUtils.log(4, "VideoProxy", "cache dir is:" + PlayerConfig.g().getCacheDir());
      this.videoRequestManager = new VideoRequestManager();
      this.executorService = new ThreadUtils.FlexibleSizeExecutor(PlayerConfig.g().getCoreClientCount(), PlayerConfig.g().getMaxClientCount(), 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
      try
      {
        localObject = InetAddress.getByName("0.0.0.0");
        this.serverSocket = new ServerSocket(PlayerUtils.findFreePort(5), PlayerConfig.g().getMaxClientCount(), (InetAddress)localObject);
        this.serverPort = this.serverSocket.getLocalPort();
        localObject = new CountDownLatch(1);
        this.waitConnectionThread = new Thread(new VideoProxy.WaitRequestRunnable(this, (CountDownLatch)localObject), "video_proxy_wait_for_connection_thread");
        this.waitConnectionThread.start();
        ((CountDownLatch)localObject).await();
        PlayerUtils.log(4, "VideoProxy", "proxy start success");
        return;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        long l;
        LeastRecentlyUsedCacheEvictor localLeastRecentlyUsedCacheEvictor;
        this.executorService.shutdown();
        PlayerUtils.log(6, "VideoProxy", "proxy start failed " + PlayerUtils.getPrintableStackTrace(localIllegalStateException));
        return;
      }
      catch (IOException localIOException)
      {
        this.executorService.shutdown();
        PlayerUtils.log(6, "VideoProxy", "proxy start failed " + PlayerUtils.getPrintableStackTrace(localIOException));
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        this.executorService.shutdown();
        PlayerUtils.log(6, "VideoProxy", "proxy start failed " + PlayerUtils.getPrintableStackTrace(localInterruptedException));
      }
      l = Math.min(StorageUtil.getDirAvailableSpace((String)localObject), PlayerConfig.g().getCacheMaxBytes());
      PlayerUtils.log(4, "VideoProxy", "cache availableSpace=" + l);
      localLeastRecentlyUsedCacheEvictor = new LeastRecentlyUsedCacheEvictor(l);
      ThreadUtils.submitTask(new VideoProxy.1(this, (String)localObject, l, localLeastRecentlyUsedCacheEvictor), "VideoProxy");
      this.cache = new SimpleCache(new File((String)localObject), localLeastRecentlyUsedCacheEvictor);
      break;
      PlayerUtils.log(4, "VideoProxy", "cache provider is tc");
    }
  }
  
  private void cancelPreloadRequestsSync(String paramString, VideoRequest paramVideoRequest)
  {
    Object localObject = getIdleVideoRequest(getPreloadVideoRequestByVideoKey(paramString));
    paramVideoRequest = "VideoProxy/" + paramVideoRequest.getSeqNum();
    if (((ArrayList)localObject).size() > 0)
    {
      CountDownLatch localCountDownLatch = new CountDownLatch(((ArrayList)localObject).size());
      PlayerUtils.log(5, paramVideoRequest, "start auto cancel preload requests, request count " + localCountDownLatch.getCount());
      VideoProxy.2 local2 = new VideoProxy.2(this, localCountDownLatch);
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((VideoRequest)((Iterator)localObject).next()).cancel(local2);
      }
      long l = 2000;
      try
      {
        localCountDownLatch.await(l, TimeUnit.MILLISECONDS);
        if (getPreloadVideoRequestByVideoKey(paramString).size() == 0)
        {
          PlayerUtils.log(5, paramVideoRequest, "auto cancel preload requests success");
          return;
        }
        PlayerUtils.log(5, paramVideoRequest, "auto cancel preload requests timeout, max wait time is " + 2000 + " seconds");
        return;
      }
      catch (InterruptedException paramString)
      {
        PlayerUtils.log(5, paramVideoRequest, "auto cancel preload requests interrupted " + paramString.toString());
      }
    }
  }
  
  /* Error */
  private File generateLocalPlaylistFile(DataSource paramDataSource, DataSpec paramDataSpec, String paramString, VideoRequest paramVideoRequest)
  {
    // Byte code:
    //   0: new 250	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   7: ldc 8
    //   9: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12: aload 4
    //   14: invokevirtual 427	com/tencent/oskplayer/proxy/VideoRequest:getSeqNum	()I
    //   17: invokevirtual 430	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   20: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   23: astore 21
    //   25: iconst_0
    //   26: istore 10
    //   28: invokestatic 176	com/tencent/oskplayer/PlayerConfig:g	()Lcom/tencent/oskplayer/PlayerConfig;
    //   31: invokevirtual 481	com/tencent/oskplayer/PlayerConfig:getTempDir	()Ljava/lang/String;
    //   34: astore 16
    //   36: aload 16
    //   38: ifnonnull +15 -> 53
    //   41: bipush 6
    //   43: aload 21
    //   45: ldc_w 483
    //   48: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   51: aconst_null
    //   52: areturn
    //   53: new 376	java/io/File
    //   56: dup
    //   57: aload 16
    //   59: invokespecial 379	java/io/File:<init>	(Ljava/lang/String;)V
    //   62: astore 15
    //   64: new 376	java/io/File
    //   67: dup
    //   68: new 250	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   75: aload 16
    //   77: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: getstatic 486	java/io/File:separator	Ljava/lang/String;
    //   83: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: invokestatic 491	java/lang/System:currentTimeMillis	()J
    //   89: getstatic 146	com/tencent/oskplayer/proxy/VideoProxy:PLAY_LIST_ID	Ljava/util/concurrent/atomic/AtomicInteger;
    //   92: invokevirtual 494	java/util/concurrent/atomic/AtomicInteger:incrementAndGet	()I
    //   95: i2l
    //   96: ladd
    //   97: invokevirtual 356	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   100: ldc_w 496
    //   103: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   109: invokespecial 379	java/io/File:<init>	(Ljava/lang/String;)V
    //   112: astore 22
    //   114: aload 15
    //   116: invokevirtual 499	java/io/File:exists	()Z
    //   119: ifne +9 -> 128
    //   122: aload 15
    //   124: invokevirtual 502	java/io/File:mkdirs	()Z
    //   127: pop
    //   128: iconst_4
    //   129: aload 21
    //   131: new 250	java/lang/StringBuilder
    //   134: dup
    //   135: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   138: ldc_w 504
    //   141: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: aload 22
    //   146: invokevirtual 507	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   149: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   152: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   155: aload 4
    //   157: invokevirtual 510	com/tencent/oskplayer/proxy/VideoRequest:getPrority	()I
    //   160: bipush 10
    //   162: if_icmpne +2929 -> 3091
    //   165: iconst_1
    //   166: istore 5
    //   168: aload 4
    //   170: invokevirtual 513	com/tencent/oskplayer/proxy/VideoRequest:getUuid	()Ljava/lang/String;
    //   173: astore 23
    //   175: aload 4
    //   177: invokevirtual 510	com/tencent/oskplayer/proxy/VideoRequest:getPrority	()I
    //   180: bipush 10
    //   182: if_icmpne +2915 -> 3097
    //   185: iconst_1
    //   186: istore 12
    //   188: iconst_4
    //   189: aload 21
    //   191: new 250	java/lang/StringBuilder
    //   194: dup
    //   195: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   198: ldc_w 515
    //   201: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: iload 12
    //   206: invokevirtual 430	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   209: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   212: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   215: aload 4
    //   217: aload 4
    //   219: invokevirtual 518	com/tencent/oskplayer/proxy/VideoRequest:getContentFormatFlag	()I
    //   222: iconst_5
    //   223: ior
    //   224: invokevirtual 521	com/tencent/oskplayer/proxy/VideoRequest:setContentFormatFlag	(I)V
    //   227: ldc_w 523
    //   230: bipush 34
    //   232: invokestatic 529	java/util/regex/Pattern:compile	(Ljava/lang/String;I)Ljava/util/regex/Pattern;
    //   235: astore 24
    //   237: aload_1
    //   238: aload_2
    //   239: invokeinterface 535 2 0
    //   244: pop2
    //   245: new 537	java/io/BufferedReader
    //   248: dup
    //   249: new 539	com/tencent/oskplayer/datasource/DataSourceReader
    //   252: dup
    //   253: aload_1
    //   254: ldc_w 541
    //   257: invokespecial 544	com/tencent/oskplayer/datasource/DataSourceReader:<init>	(Lcom/tencent/oskplayer/datasource/DataSource;Ljava/lang/String;)V
    //   260: invokespecial 547	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   263: astore_2
    //   264: new 549	java/io/FileOutputStream
    //   267: dup
    //   268: aload 22
    //   270: invokespecial 552	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   273: astore 15
    //   275: aload_2
    //   276: astore 16
    //   278: aload 15
    //   280: astore 17
    //   282: new 250	java/lang/StringBuilder
    //   285: dup
    //   286: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   289: astore 25
    //   291: aload_2
    //   292: astore 16
    //   294: aload 15
    //   296: astore 17
    //   298: iconst_4
    //   299: aload 21
    //   301: ldc_w 554
    //   304: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   307: aconst_null
    //   308: astore 19
    //   310: iconst_m1
    //   311: istore 6
    //   313: iconst_m1
    //   314: istore 7
    //   316: iconst_1
    //   317: istore 8
    //   319: iload 5
    //   321: istore 9
    //   323: iload 10
    //   325: istore 5
    //   327: aload_2
    //   328: astore 16
    //   330: aload 15
    //   332: astore 17
    //   334: invokestatic 557	java/lang/Thread:interrupted	()Z
    //   337: ifne +2766 -> 3103
    //   340: iconst_1
    //   341: istore 10
    //   343: iload 10
    //   345: ifeq +1372 -> 1717
    //   348: aload_2
    //   349: astore 16
    //   351: aload 15
    //   353: astore 17
    //   355: aload 4
    //   357: invokevirtual 560	com/tencent/oskplayer/proxy/VideoRequest:shouldCancel	()Z
    //   360: ifne +1357 -> 1717
    //   363: aload_2
    //   364: astore 16
    //   366: aload 15
    //   368: astore 17
    //   370: aload_2
    //   371: invokevirtual 563	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   374: astore 26
    //   376: aload 26
    //   378: ifnull +1339 -> 1717
    //   381: aload_2
    //   382: astore 16
    //   384: aload 15
    //   386: astore 17
    //   388: iconst_4
    //   389: aload 21
    //   391: aload 26
    //   393: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   396: aload_2
    //   397: astore 16
    //   399: aload 15
    //   401: astore 17
    //   403: aload 26
    //   405: ldc_w 565
    //   408: invokevirtual 571	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   411: ifeq +951 -> 1362
    //   414: aload 19
    //   416: astore 18
    //   418: aload_2
    //   419: astore 16
    //   421: aload 15
    //   423: astore 17
    //   425: aload 26
    //   427: invokevirtual 574	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   430: ldc_w 576
    //   433: invokevirtual 580	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   436: ifeq +70 -> 506
    //   439: aload 19
    //   441: astore 18
    //   443: aload_2
    //   444: astore 16
    //   446: aload 15
    //   448: astore 17
    //   450: aload_0
    //   451: getfield 168	com/tencent/oskplayer/proxy/VideoProxy:mPlayListInfo	Ljava/util/Map;
    //   454: aload 23
    //   456: invokeinterface 585 2 0
    //   461: ifne +45 -> 506
    //   464: aload_2
    //   465: astore 16
    //   467: aload 15
    //   469: astore 17
    //   471: new 432	java/util/ArrayList
    //   474: dup
    //   475: invokespecial 586	java/util/ArrayList:<init>	()V
    //   478: astore 18
    //   480: aload_2
    //   481: astore 16
    //   483: aload 15
    //   485: astore 17
    //   487: aload_0
    //   488: getfield 168	com/tencent/oskplayer/proxy/VideoProxy:mPlayListInfo	Ljava/util/Map;
    //   491: aload 23
    //   493: new 588	com/tencent/oskplayer/proxy/PlayListInfo
    //   496: dup
    //   497: invokespecial 589	com/tencent/oskplayer/proxy/PlayListInfo:<init>	()V
    //   500: invokeinterface 593 3 0
    //   505: pop
    //   506: aload_2
    //   507: astore 16
    //   509: aload 15
    //   511: astore 17
    //   513: aload 26
    //   515: invokevirtual 574	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   518: ldc_w 595
    //   521: invokevirtual 571	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   524: ifeq +29 -> 553
    //   527: iconst_1
    //   528: istore 9
    //   530: iconst_0
    //   531: istore 8
    //   533: aload_2
    //   534: astore 16
    //   536: aload 15
    //   538: astore 17
    //   540: aload 4
    //   542: aload 4
    //   544: invokevirtual 518	com/tencent/oskplayer/proxy/VideoRequest:getContentFormatFlag	()I
    //   547: bipush 251
    //   549: iand
    //   550: invokevirtual 521	com/tencent/oskplayer/proxy/VideoRequest:setContentFormatFlag	(I)V
    //   553: aload_2
    //   554: astore 16
    //   556: aload 15
    //   558: astore 17
    //   560: aload 26
    //   562: invokevirtual 574	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   565: ldc_w 597
    //   568: invokevirtual 571	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   571: ifeq +17 -> 588
    //   574: aload_2
    //   575: astore 16
    //   577: aload 15
    //   579: astore 17
    //   581: aload 26
    //   583: invokestatic 601	com/tencent/oskplayer/util/PlayerUtils:parseM3u8Number	(Ljava/lang/String;)I
    //   586: istore 7
    //   588: iload 6
    //   590: istore 10
    //   592: aload_2
    //   593: astore 16
    //   595: aload 15
    //   597: astore 17
    //   599: aload 26
    //   601: invokevirtual 574	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   604: ldc_w 603
    //   607: invokevirtual 571	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   610: ifeq +17 -> 627
    //   613: aload_2
    //   614: astore 16
    //   616: aload 15
    //   618: astore 17
    //   620: aload 26
    //   622: invokestatic 601	com/tencent/oskplayer/util/PlayerUtils:parseM3u8Number	(Ljava/lang/String;)I
    //   625: istore 10
    //   627: iload 9
    //   629: istore 11
    //   631: iload 8
    //   633: istore 6
    //   635: aload_2
    //   636: astore 16
    //   638: aload 15
    //   640: astore 17
    //   642: aload 26
    //   644: invokevirtual 574	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   647: ldc_w 605
    //   650: invokevirtual 571	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   653: ifeq +61 -> 714
    //   656: iload 9
    //   658: istore 11
    //   660: iload 8
    //   662: istore 6
    //   664: aload_2
    //   665: astore 16
    //   667: aload 15
    //   669: astore 17
    //   671: aload 26
    //   673: invokestatic 609	com/tencent/oskplayer/util/PlayerUtils:parseM3u8Option	(Ljava/lang/String;)Ljava/lang/String;
    //   676: invokevirtual 574	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   679: ldc_w 611
    //   682: invokevirtual 580	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   685: ifeq +29 -> 714
    //   688: iconst_1
    //   689: istore 11
    //   691: iconst_0
    //   692: istore 6
    //   694: aload_2
    //   695: astore 16
    //   697: aload 15
    //   699: astore 17
    //   701: aload 4
    //   703: aload 4
    //   705: invokevirtual 518	com/tencent/oskplayer/proxy/VideoRequest:getContentFormatFlag	()I
    //   708: bipush 251
    //   710: iand
    //   711: invokevirtual 521	com/tencent/oskplayer/proxy/VideoRequest:setContentFormatFlag	(I)V
    //   714: aload_2
    //   715: astore 16
    //   717: aload 15
    //   719: astore 17
    //   721: aload 26
    //   723: invokevirtual 574	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   726: ldc_w 613
    //   729: invokevirtual 571	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   732: ifeq +596 -> 1328
    //   735: aload_2
    //   736: astore 16
    //   738: aload 15
    //   740: astore 17
    //   742: aload 24
    //   744: aload 26
    //   746: invokevirtual 617	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   749: astore_1
    //   750: aload_2
    //   751: astore 16
    //   753: aload 15
    //   755: astore 17
    //   757: aload_1
    //   758: invokevirtual 622	java/util/regex/Matcher:matches	()Z
    //   761: ifeq +451 -> 1212
    //   764: aload_2
    //   765: astore 16
    //   767: aload 15
    //   769: astore 17
    //   771: aload_1
    //   772: invokevirtual 625	java/util/regex/Matcher:groupCount	()I
    //   775: ifle +437 -> 1212
    //   778: aload_2
    //   779: astore 16
    //   781: aload 15
    //   783: astore 17
    //   785: aload_1
    //   786: iconst_1
    //   787: invokevirtual 627	java/util/regex/Matcher:start	(I)I
    //   790: istore 8
    //   792: aload_2
    //   793: astore 16
    //   795: aload 15
    //   797: astore 17
    //   799: aload_1
    //   800: iconst_1
    //   801: invokevirtual 630	java/util/regex/Matcher:end	(I)I
    //   804: istore 9
    //   806: aload_2
    //   807: astore 16
    //   809: aload 15
    //   811: astore 17
    //   813: aload 26
    //   815: iconst_0
    //   816: iload 8
    //   818: invokevirtual 634	java/lang/String:substring	(II)Ljava/lang/String;
    //   821: astore 20
    //   823: aload_2
    //   824: astore 16
    //   826: aload 15
    //   828: astore 17
    //   830: aload 26
    //   832: iload 8
    //   834: iload 9
    //   836: invokevirtual 634	java/lang/String:substring	(II)Ljava/lang/String;
    //   839: astore_1
    //   840: aload_2
    //   841: astore 16
    //   843: aload 15
    //   845: astore 17
    //   847: aload 26
    //   849: iload 9
    //   851: invokevirtual 637	java/lang/String:substring	(I)Ljava/lang/String;
    //   854: astore 27
    //   856: aload_2
    //   857: astore 16
    //   859: aload 15
    //   861: astore 17
    //   863: aload_0
    //   864: aload_3
    //   865: aload_1
    //   866: invokestatic 641	com/tencent/oskplayer/util/PlayerUtils:getAbsoluteUrl	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   869: iconst_0
    //   870: iconst_0
    //   871: aload 4
    //   873: invokevirtual 644	com/tencent/oskplayer/proxy/VideoRequest:getDataSourceType	()Ljava/lang/String;
    //   876: ldc_w 646
    //   879: bipush 90
    //   881: aload 4
    //   883: invokevirtual 650	com/tencent/oskplayer/proxy/VideoRequest:getExtraHeader	()Lcom/tencent/oskplayer/datasource/HttpHeader;
    //   886: invokevirtual 654	com/tencent/oskplayer/proxy/VideoProxy:getUrl	(Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;ILcom/tencent/oskplayer/datasource/HttpHeader;)Ljava/lang/String;
    //   889: astore 19
    //   891: aload 19
    //   893: astore_1
    //   894: aload_2
    //   895: astore 16
    //   897: aload 15
    //   899: astore 17
    //   901: aload 4
    //   903: invokevirtual 513	com/tencent/oskplayer/proxy/VideoRequest:getUuid	()Ljava/lang/String;
    //   906: ifnull +68 -> 974
    //   909: aload_2
    //   910: astore 16
    //   912: aload 15
    //   914: astore 17
    //   916: new 250	java/lang/StringBuilder
    //   919: dup
    //   920: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   923: aload 19
    //   925: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   928: ldc_w 656
    //   931: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   934: aload 4
    //   936: invokevirtual 513	com/tencent/oskplayer/proxy/VideoRequest:getUuid	()Ljava/lang/String;
    //   939: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   942: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   945: astore_1
    //   946: aload_2
    //   947: astore 16
    //   949: aload 15
    //   951: astore 17
    //   953: new 250	java/lang/StringBuilder
    //   956: dup
    //   957: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   960: aload_1
    //   961: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   964: ldc_w 658
    //   967: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   970: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   973: astore_1
    //   974: aload_2
    //   975: astore 16
    //   977: aload 15
    //   979: astore 17
    //   981: aload 25
    //   983: aload 20
    //   985: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   988: aload_1
    //   989: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   992: aload 27
    //   994: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   997: ldc_w 660
    //   1000: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1003: pop
    //   1004: goto +2057 -> 3061
    //   1007: aload_2
    //   1008: astore 16
    //   1010: aload 15
    //   1012: astore 17
    //   1014: aload 26
    //   1016: ldc_w 565
    //   1019: invokevirtual 571	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1022: ifne +2036 -> 3058
    //   1025: aload_2
    //   1026: astore 16
    //   1028: aload 15
    //   1030: astore 17
    //   1032: aload 26
    //   1034: ldc_w 662
    //   1037: invokevirtual 665	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1040: ifne +21 -> 1061
    //   1043: aload_2
    //   1044: astore 16
    //   1046: aload 15
    //   1048: astore 17
    //   1050: aload 26
    //   1052: ldc_w 667
    //   1055: invokevirtual 665	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1058: ifeq +2000 -> 3058
    //   1061: aload 18
    //   1063: ifnull +2011 -> 3074
    //   1066: iload 5
    //   1068: iload 12
    //   1070: if_icmpge +2004 -> 3074
    //   1073: aload_2
    //   1074: astore 16
    //   1076: aload 15
    //   1078: astore 17
    //   1080: aload_1
    //   1081: invokestatic 238	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1084: ifne +1990 -> 3074
    //   1087: aload_2
    //   1088: astore 16
    //   1090: aload 15
    //   1092: astore 17
    //   1094: aload_0
    //   1095: aload_1
    //   1096: iconst_1
    //   1097: iconst_1
    //   1098: aload 4
    //   1100: invokevirtual 644	com/tencent/oskplayer/proxy/VideoRequest:getDataSourceType	()Ljava/lang/String;
    //   1103: ldc 76
    //   1105: bipush 10
    //   1107: aload 4
    //   1109: invokevirtual 650	com/tencent/oskplayer/proxy/VideoRequest:getExtraHeader	()Lcom/tencent/oskplayer/datasource/HttpHeader;
    //   1112: invokevirtual 654	com/tencent/oskplayer/proxy/VideoProxy:getUrl	(Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;ILcom/tencent/oskplayer/datasource/HttpHeader;)Ljava/lang/String;
    //   1115: astore 19
    //   1117: aload_2
    //   1118: astore 16
    //   1120: aload 15
    //   1122: astore 17
    //   1124: iconst_4
    //   1125: aload 21
    //   1127: new 250	java/lang/StringBuilder
    //   1130: dup
    //   1131: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   1134: ldc_w 669
    //   1137: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1140: aload 19
    //   1142: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1145: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1148: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   1151: aload_2
    //   1152: astore 16
    //   1154: aload 15
    //   1156: astore 17
    //   1158: new 671	com/tencent/oskplayer/proxy/VideoProxy$PreloadInfo
    //   1161: dup
    //   1162: invokespecial 672	com/tencent/oskplayer/proxy/VideoProxy$PreloadInfo:<init>	()V
    //   1165: astore 20
    //   1167: aload_2
    //   1168: astore 16
    //   1170: aload 15
    //   1172: astore 17
    //   1174: aload 20
    //   1176: aload 19
    //   1178: putfield 675	com/tencent/oskplayer/proxy/VideoProxy$PreloadInfo:localUrl	Ljava/lang/String;
    //   1181: aload_2
    //   1182: astore 16
    //   1184: aload 15
    //   1186: astore 17
    //   1188: aload 20
    //   1190: aload_1
    //   1191: putfield 678	com/tencent/oskplayer/proxy/VideoProxy$PreloadInfo:originalUrl	Ljava/lang/String;
    //   1194: aload_2
    //   1195: astore 16
    //   1197: aload 15
    //   1199: astore 17
    //   1201: aload 18
    //   1203: aload 20
    //   1205: invokevirtual 681	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1208: pop
    //   1209: goto +1865 -> 3074
    //   1212: aload_2
    //   1213: astore 16
    //   1215: aload 15
    //   1217: astore 17
    //   1219: aload 25
    //   1221: aload 26
    //   1223: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1226: ldc_w 660
    //   1229: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1232: pop
    //   1233: goto +1828 -> 3061
    //   1236: astore_3
    //   1237: aload 15
    //   1239: astore_1
    //   1240: aload 4
    //   1242: invokevirtual 560	com/tencent/oskplayer/proxy/VideoRequest:shouldCancel	()Z
    //   1245: ifeq +1501 -> 2746
    //   1248: aload 4
    //   1250: invokevirtual 684	com/tencent/oskplayer/proxy/VideoRequest:enterCancelProceedState	()V
    //   1253: aload_2
    //   1254: ifnull +7 -> 1261
    //   1257: aload_2
    //   1258: invokevirtual 687	java/io/BufferedReader:close	()V
    //   1261: aload_1
    //   1262: ifnull +7 -> 1269
    //   1265: aload_1
    //   1266: invokevirtual 690	java/io/OutputStream:close	()V
    //   1269: aload 22
    //   1271: ifnull -1220 -> 51
    //   1274: aload 22
    //   1276: invokevirtual 499	java/io/File:exists	()Z
    //   1279: ifeq -1228 -> 51
    //   1282: aload 22
    //   1284: invokevirtual 693	java/io/File:isFile	()Z
    //   1287: ifeq -1236 -> 51
    //   1290: aload 22
    //   1292: invokevirtual 696	java/io/File:delete	()Z
    //   1295: pop
    //   1296: iconst_4
    //   1297: aload 21
    //   1299: new 250	java/lang/StringBuilder
    //   1302: dup
    //   1303: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   1306: ldc_w 698
    //   1309: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1312: aload 22
    //   1314: invokevirtual 699	java/io/File:toString	()Ljava/lang/String;
    //   1317: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1320: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1323: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   1326: aconst_null
    //   1327: areturn
    //   1328: aload_2
    //   1329: astore 16
    //   1331: aload 15
    //   1333: astore 17
    //   1335: aload 25
    //   1337: aload 26
    //   1339: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1342: ldc_w 660
    //   1345: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1348: pop
    //   1349: aconst_null
    //   1350: astore_1
    //   1351: iload 11
    //   1353: istore 9
    //   1355: iload 6
    //   1357: istore 8
    //   1359: goto -352 -> 1007
    //   1362: aload_2
    //   1363: astore 16
    //   1365: aload 15
    //   1367: astore 17
    //   1369: aload 26
    //   1371: ldc_w 662
    //   1374: invokevirtual 665	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1377: ifne +21 -> 1398
    //   1380: aload_2
    //   1381: astore 16
    //   1383: aload 15
    //   1385: astore 17
    //   1387: aload 26
    //   1389: ldc_w 667
    //   1392: invokevirtual 665	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1395: ifeq +288 -> 1683
    //   1398: aload_2
    //   1399: astore 16
    //   1401: aload 15
    //   1403: astore 17
    //   1405: aload 26
    //   1407: ldc_w 701
    //   1410: invokevirtual 571	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1413: ifne +270 -> 1683
    //   1416: aload_2
    //   1417: astore 16
    //   1419: aload 15
    //   1421: astore 17
    //   1423: aload_3
    //   1424: aload 26
    //   1426: invokestatic 641	com/tencent/oskplayer/util/PlayerUtils:getAbsoluteUrl	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1429: astore 18
    //   1431: aload_2
    //   1432: astore 16
    //   1434: aload 15
    //   1436: astore 17
    //   1438: aload_0
    //   1439: aload 18
    //   1441: iconst_0
    //   1442: iconst_0
    //   1443: aload 4
    //   1445: invokevirtual 644	com/tencent/oskplayer/proxy/VideoRequest:getDataSourceType	()Ljava/lang/String;
    //   1448: ldc 76
    //   1450: bipush 90
    //   1452: aload 4
    //   1454: invokevirtual 650	com/tencent/oskplayer/proxy/VideoRequest:getExtraHeader	()Lcom/tencent/oskplayer/datasource/HttpHeader;
    //   1457: invokevirtual 654	com/tencent/oskplayer/proxy/VideoProxy:getUrl	(Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;ILcom/tencent/oskplayer/datasource/HttpHeader;)Ljava/lang/String;
    //   1460: astore 20
    //   1462: aload 20
    //   1464: astore_1
    //   1465: aload_2
    //   1466: astore 16
    //   1468: aload 15
    //   1470: astore 17
    //   1472: aload 4
    //   1474: invokevirtual 513	com/tencent/oskplayer/proxy/VideoRequest:getUuid	()Ljava/lang/String;
    //   1477: ifnull +68 -> 1545
    //   1480: aload_2
    //   1481: astore 16
    //   1483: aload 15
    //   1485: astore 17
    //   1487: new 250	java/lang/StringBuilder
    //   1490: dup
    //   1491: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   1494: aload 20
    //   1496: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1499: ldc_w 656
    //   1502: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1505: aload 4
    //   1507: invokevirtual 513	com/tencent/oskplayer/proxy/VideoRequest:getUuid	()Ljava/lang/String;
    //   1510: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1513: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1516: astore_1
    //   1517: aload_2
    //   1518: astore 16
    //   1520: aload 15
    //   1522: astore 17
    //   1524: new 250	java/lang/StringBuilder
    //   1527: dup
    //   1528: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   1531: aload_1
    //   1532: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1535: ldc_w 703
    //   1538: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1541: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1544: astore_1
    //   1545: aload_2
    //   1546: astore 16
    //   1548: aload 15
    //   1550: astore 17
    //   1552: aload 25
    //   1554: aload_1
    //   1555: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1558: ldc_w 660
    //   1561: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1564: pop
    //   1565: aload 18
    //   1567: astore_1
    //   1568: aload 19
    //   1570: astore 18
    //   1572: iload 6
    //   1574: istore 10
    //   1576: goto -569 -> 1007
    //   1579: astore_1
    //   1580: aload 15
    //   1582: astore_3
    //   1583: aload_2
    //   1584: astore 16
    //   1586: aload_3
    //   1587: astore 17
    //   1589: aload 4
    //   1591: invokevirtual 560	com/tencent/oskplayer/proxy/VideoRequest:shouldCancel	()Z
    //   1594: ifeq +1235 -> 2829
    //   1597: aload_2
    //   1598: astore 16
    //   1600: aload_3
    //   1601: astore 17
    //   1603: aload 4
    //   1605: invokevirtual 684	com/tencent/oskplayer/proxy/VideoRequest:enterCancelProceedState	()V
    //   1608: aload_2
    //   1609: ifnull +7 -> 1616
    //   1612: aload_2
    //   1613: invokevirtual 687	java/io/BufferedReader:close	()V
    //   1616: aload_3
    //   1617: ifnull +7 -> 1624
    //   1620: aload_3
    //   1621: invokevirtual 690	java/io/OutputStream:close	()V
    //   1624: aload 22
    //   1626: ifnull -1575 -> 51
    //   1629: aload 22
    //   1631: invokevirtual 499	java/io/File:exists	()Z
    //   1634: ifeq -1583 -> 51
    //   1637: aload 22
    //   1639: invokevirtual 693	java/io/File:isFile	()Z
    //   1642: ifeq -1591 -> 51
    //   1645: aload 22
    //   1647: invokevirtual 696	java/io/File:delete	()Z
    //   1650: pop
    //   1651: iconst_4
    //   1652: aload 21
    //   1654: new 250	java/lang/StringBuilder
    //   1657: dup
    //   1658: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   1661: ldc_w 698
    //   1664: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1667: aload 22
    //   1669: invokevirtual 699	java/io/File:toString	()Ljava/lang/String;
    //   1672: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1675: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1678: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   1681: aconst_null
    //   1682: areturn
    //   1683: aload_2
    //   1684: astore 16
    //   1686: aload 15
    //   1688: astore 17
    //   1690: aload 25
    //   1692: aload 26
    //   1694: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1697: ldc_w 660
    //   1700: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1703: pop
    //   1704: aconst_null
    //   1705: astore_1
    //   1706: aload 19
    //   1708: astore 18
    //   1710: iload 6
    //   1712: istore 10
    //   1714: goto -707 -> 1007
    //   1717: aload_2
    //   1718: astore 16
    //   1720: aload 15
    //   1722: astore 17
    //   1724: aload 4
    //   1726: invokevirtual 560	com/tencent/oskplayer/proxy/VideoRequest:shouldCancel	()Z
    //   1729: ifeq +111 -> 1840
    //   1732: aload_2
    //   1733: astore 16
    //   1735: aload 15
    //   1737: astore 17
    //   1739: new 476	com/tencent/oskplayer/proxy/LivePlayListException
    //   1742: dup
    //   1743: ldc_w 705
    //   1746: invokespecial 706	com/tencent/oskplayer/proxy/LivePlayListException:<init>	(Ljava/lang/String;)V
    //   1749: athrow
    //   1750: astore_1
    //   1751: iconst_0
    //   1752: istore 5
    //   1754: aload 17
    //   1756: astore_3
    //   1757: aload 16
    //   1759: astore_2
    //   1760: aload_2
    //   1761: ifnull +7 -> 1768
    //   1764: aload_2
    //   1765: invokevirtual 687	java/io/BufferedReader:close	()V
    //   1768: aload_3
    //   1769: ifnull +7 -> 1776
    //   1772: aload_3
    //   1773: invokevirtual 690	java/io/OutputStream:close	()V
    //   1776: iload 5
    //   1778: ifeq +60 -> 1838
    //   1781: aload 22
    //   1783: ifnull +55 -> 1838
    //   1786: aload 22
    //   1788: invokevirtual 499	java/io/File:exists	()Z
    //   1791: ifeq +47 -> 1838
    //   1794: aload 22
    //   1796: invokevirtual 693	java/io/File:isFile	()Z
    //   1799: ifeq +39 -> 1838
    //   1802: aload 22
    //   1804: invokevirtual 696	java/io/File:delete	()Z
    //   1807: pop
    //   1808: iconst_4
    //   1809: aload 21
    //   1811: new 250	java/lang/StringBuilder
    //   1814: dup
    //   1815: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   1818: ldc_w 698
    //   1821: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1824: aload 22
    //   1826: invokevirtual 699	java/io/File:toString	()Ljava/lang/String;
    //   1829: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1832: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1835: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   1838: aload_1
    //   1839: athrow
    //   1840: aload 19
    //   1842: ifnull +50 -> 1892
    //   1845: aload_2
    //   1846: astore 16
    //   1848: aload 15
    //   1850: astore 17
    //   1852: invokestatic 176	com/tencent/oskplayer/PlayerConfig:g	()Lcom/tencent/oskplayer/PlayerConfig;
    //   1855: invokevirtual 709	com/tencent/oskplayer/PlayerConfig:isEnableProxy	()Z
    //   1858: ifeq +34 -> 1892
    //   1861: aload_2
    //   1862: astore 16
    //   1864: aload 15
    //   1866: astore 17
    //   1868: aload 4
    //   1870: invokevirtual 560	com/tencent/oskplayer/proxy/VideoRequest:shouldCancel	()Z
    //   1873: ifne +19 -> 1892
    //   1876: aload_2
    //   1877: astore 16
    //   1879: aload 15
    //   1881: astore 17
    //   1883: aload_0
    //   1884: aload 19
    //   1886: ldc_w 711
    //   1889: invokespecial 715	com/tencent/oskplayer/proxy/VideoProxy:preloadMediasAsync	(Ljava/util/ArrayList;Ljava/lang/String;)V
    //   1892: iload 8
    //   1894: ifeq +251 -> 2145
    //   1897: aload_2
    //   1898: astore 16
    //   1900: aload 15
    //   1902: astore 17
    //   1904: aload 4
    //   1906: invokevirtual 513	com/tencent/oskplayer/proxy/VideoRequest:getUuid	()Ljava/lang/String;
    //   1909: astore_1
    //   1910: aload_2
    //   1911: astore 16
    //   1913: aload 15
    //   1915: astore 17
    //   1917: aload_0
    //   1918: getfield 166	com/tencent/oskplayer/proxy/VideoProxy:mLivePlayListInfo	Ljava/util/Map;
    //   1921: aload_1
    //   1922: invokeinterface 585 2 0
    //   1927: ifne +28 -> 1955
    //   1930: aload_2
    //   1931: astore 16
    //   1933: aload 15
    //   1935: astore 17
    //   1937: aload_0
    //   1938: getfield 166	com/tencent/oskplayer/proxy/VideoProxy:mLivePlayListInfo	Ljava/util/Map;
    //   1941: aload_1
    //   1942: new 717	com/tencent/oskplayer/proxy/LivePlayListInfo
    //   1945: dup
    //   1946: invokespecial 718	com/tencent/oskplayer/proxy/LivePlayListInfo:<init>	()V
    //   1949: invokeinterface 593 3 0
    //   1954: pop
    //   1955: aload_2
    //   1956: astore 16
    //   1958: aload 15
    //   1960: astore 17
    //   1962: aload_0
    //   1963: getfield 166	com/tencent/oskplayer/proxy/VideoProxy:mLivePlayListInfo	Ljava/util/Map;
    //   1966: aload_1
    //   1967: invokeinterface 722 2 0
    //   1972: checkcast 717	com/tencent/oskplayer/proxy/LivePlayListInfo
    //   1975: astore_1
    //   1976: iload 7
    //   1978: iconst_m1
    //   1979: if_icmpne +21 -> 2000
    //   1982: aload_2
    //   1983: astore 16
    //   1985: aload 15
    //   1987: astore 17
    //   1989: new 476	com/tencent/oskplayer/proxy/LivePlayListException
    //   1992: dup
    //   1993: ldc_w 724
    //   1996: invokespecial 706	com/tencent/oskplayer/proxy/LivePlayListException:<init>	(Ljava/lang/String;)V
    //   1999: athrow
    //   2000: iload 6
    //   2002: iconst_m1
    //   2003: if_icmpne +21 -> 2024
    //   2006: aload_2
    //   2007: astore 16
    //   2009: aload 15
    //   2011: astore 17
    //   2013: new 476	com/tencent/oskplayer/proxy/LivePlayListException
    //   2016: dup
    //   2017: ldc_w 726
    //   2020: invokespecial 706	com/tencent/oskplayer/proxy/LivePlayListException:<init>	(Ljava/lang/String;)V
    //   2023: athrow
    //   2024: aload_2
    //   2025: astore 16
    //   2027: aload 15
    //   2029: astore 17
    //   2031: aload_1
    //   2032: getfield 729	com/tencent/oskplayer/proxy/LivePlayListInfo:mMaxMediaSequence	I
    //   2035: iconst_m1
    //   2036: if_icmpne +345 -> 2381
    //   2039: aload_2
    //   2040: astore 16
    //   2042: aload 15
    //   2044: astore 17
    //   2046: aload_0
    //   2047: getfield 170	com/tencent/oskplayer/proxy/VideoProxy:mErrorLivePlayListInfo	Ljava/util/Map;
    //   2050: aload_3
    //   2051: invokeinterface 722 2 0
    //   2056: ifnull +28 -> 2084
    //   2059: aload_2
    //   2060: astore 16
    //   2062: aload 15
    //   2064: astore 17
    //   2066: aload_0
    //   2067: getfield 170	com/tencent/oskplayer/proxy/VideoProxy:mErrorLivePlayListInfo	Ljava/util/Map;
    //   2070: aload_3
    //   2071: invokeinterface 722 2 0
    //   2076: checkcast 717	com/tencent/oskplayer/proxy/LivePlayListInfo
    //   2079: getfield 729	com/tencent/oskplayer/proxy/LivePlayListInfo:mMaxMediaSequence	I
    //   2082: istore 5
    //   2084: aload_2
    //   2085: astore 16
    //   2087: aload 15
    //   2089: astore 17
    //   2091: iconst_3
    //   2092: aload 21
    //   2094: new 250	java/lang/StringBuilder
    //   2097: dup
    //   2098: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   2101: ldc_w 731
    //   2104: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2107: iload 7
    //   2109: invokevirtual 430	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2112: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2115: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2118: aload_2
    //   2119: astore 16
    //   2121: aload 15
    //   2123: astore 17
    //   2125: aload_1
    //   2126: iload 7
    //   2128: putfield 729	com/tencent/oskplayer/proxy/LivePlayListInfo:mMaxMediaSequence	I
    //   2131: aload_2
    //   2132: astore 16
    //   2134: aload 15
    //   2136: astore 17
    //   2138: aload_1
    //   2139: invokestatic 491	java/lang/System:currentTimeMillis	()J
    //   2142: putfield 735	com/tencent/oskplayer/proxy/LivePlayListInfo:mUpdateMediaSequenceTimestamp	J
    //   2145: aload_2
    //   2146: astore 16
    //   2148: aload 15
    //   2150: astore 17
    //   2152: iconst_4
    //   2153: aload 21
    //   2155: ldc_w 737
    //   2158: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2161: aload_2
    //   2162: astore 16
    //   2164: aload 15
    //   2166: astore 17
    //   2168: aload 25
    //   2170: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2173: astore_3
    //   2174: iload 9
    //   2176: ifeq +422 -> 2598
    //   2179: aload_2
    //   2180: astore 16
    //   2182: aload 15
    //   2184: astore 17
    //   2186: invokestatic 176	com/tencent/oskplayer/PlayerConfig:g	()Lcom/tencent/oskplayer/PlayerConfig;
    //   2189: invokevirtual 740	com/tencent/oskplayer/PlayerConfig:isEnableHLSCache	()Z
    //   2192: ifeq +406 -> 2598
    //   2195: ldc 58
    //   2197: astore_1
    //   2198: aload_2
    //   2199: astore 16
    //   2201: aload 15
    //   2203: astore 17
    //   2205: aload_3
    //   2206: ldc 67
    //   2208: aload_1
    //   2209: invokevirtual 743	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   2212: astore_1
    //   2213: aload_2
    //   2214: astore 16
    //   2216: aload 15
    //   2218: astore 17
    //   2220: iconst_4
    //   2221: aload 21
    //   2223: ldc_w 745
    //   2226: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2229: aload_2
    //   2230: astore 16
    //   2232: aload 15
    //   2234: astore 17
    //   2236: iconst_4
    //   2237: aload 21
    //   2239: aload_1
    //   2240: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2243: aload_2
    //   2244: astore 16
    //   2246: aload 15
    //   2248: astore 17
    //   2250: iconst_4
    //   2251: aload 21
    //   2253: ldc_w 747
    //   2256: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2259: aload_2
    //   2260: astore 16
    //   2262: aload 15
    //   2264: astore 17
    //   2266: aload 15
    //   2268: aload_1
    //   2269: invokevirtual 751	java/lang/String:getBytes	()[B
    //   2272: invokevirtual 755	java/io/OutputStream:write	([B)V
    //   2275: aload_2
    //   2276: ifnull +776 -> 3052
    //   2279: aload_2
    //   2280: invokevirtual 687	java/io/BufferedReader:close	()V
    //   2283: iconst_0
    //   2284: istore 5
    //   2286: iload 5
    //   2288: istore 6
    //   2290: aload 15
    //   2292: ifnull +12 -> 2304
    //   2295: aload 15
    //   2297: invokevirtual 690	java/io/OutputStream:close	()V
    //   2300: iload 5
    //   2302: istore 6
    //   2304: iload 10
    //   2306: ifne +618 -> 2924
    //   2309: aload 4
    //   2311: invokevirtual 560	com/tencent/oskplayer/proxy/VideoRequest:shouldCancel	()Z
    //   2314: ifeq +8 -> 2322
    //   2317: aload 4
    //   2319: invokevirtual 684	com/tencent/oskplayer/proxy/VideoRequest:enterCancelProceedState	()V
    //   2322: aload 22
    //   2324: ifnull +55 -> 2379
    //   2327: aload 22
    //   2329: invokevirtual 499	java/io/File:exists	()Z
    //   2332: ifeq +47 -> 2379
    //   2335: aload 22
    //   2337: invokevirtual 693	java/io/File:isFile	()Z
    //   2340: ifeq +39 -> 2379
    //   2343: aload 22
    //   2345: invokevirtual 696	java/io/File:delete	()Z
    //   2348: pop
    //   2349: iconst_4
    //   2350: aload 21
    //   2352: new 250	java/lang/StringBuilder
    //   2355: dup
    //   2356: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   2359: ldc_w 698
    //   2362: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2365: aload 22
    //   2367: invokevirtual 699	java/io/File:toString	()Ljava/lang/String;
    //   2370: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2373: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2376: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2379: aconst_null
    //   2380: areturn
    //   2381: aload_2
    //   2382: astore 16
    //   2384: aload 15
    //   2386: astore 17
    //   2388: iload 7
    //   2390: aload_1
    //   2391: getfield 729	com/tencent/oskplayer/proxy/LivePlayListInfo:mMaxMediaSequence	I
    //   2394: if_icmpge +62 -> 2456
    //   2397: aload_2
    //   2398: astore 16
    //   2400: aload 15
    //   2402: astore 17
    //   2404: new 476	com/tencent/oskplayer/proxy/LivePlayListException
    //   2407: dup
    //   2408: new 250	java/lang/StringBuilder
    //   2411: dup
    //   2412: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   2415: ldc_w 757
    //   2418: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2421: aload_1
    //   2422: getfield 729	com/tencent/oskplayer/proxy/LivePlayListInfo:mMaxMediaSequence	I
    //   2425: invokevirtual 430	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2428: ldc_w 759
    //   2431: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2434: iload 7
    //   2436: invokevirtual 430	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2439: ldc_w 761
    //   2442: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2445: aload_3
    //   2446: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2449: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2452: invokespecial 706	com/tencent/oskplayer/proxy/LivePlayListException:<init>	(Ljava/lang/String;)V
    //   2455: athrow
    //   2456: aload_2
    //   2457: astore 16
    //   2459: aload 15
    //   2461: astore 17
    //   2463: iload 7
    //   2465: aload_1
    //   2466: getfield 729	com/tencent/oskplayer/proxy/LivePlayListInfo:mMaxMediaSequence	I
    //   2469: if_icmpne +99 -> 2568
    //   2472: aload_2
    //   2473: astore 16
    //   2475: aload 15
    //   2477: astore 17
    //   2479: invokestatic 491	java/lang/System:currentTimeMillis	()J
    //   2482: aload_1
    //   2483: getfield 735	com/tencent/oskplayer/proxy/LivePlayListInfo:mUpdateMediaSequenceTimestamp	J
    //   2486: lsub
    //   2487: lstore 13
    //   2489: lload 13
    //   2491: iload 6
    //   2493: sipush 1000
    //   2496: imul
    //   2497: i2l
    //   2498: lcmp
    //   2499: ifle -354 -> 2145
    //   2502: aload_2
    //   2503: astore 16
    //   2505: aload 15
    //   2507: astore 17
    //   2509: aload_0
    //   2510: getfield 170	com/tencent/oskplayer/proxy/VideoProxy:mErrorLivePlayListInfo	Ljava/util/Map;
    //   2513: aload_3
    //   2514: aload_1
    //   2515: invokeinterface 593 3 0
    //   2520: pop
    //   2521: aload_2
    //   2522: astore 16
    //   2524: aload 15
    //   2526: astore 17
    //   2528: new 476	com/tencent/oskplayer/proxy/LivePlayListException
    //   2531: dup
    //   2532: new 250	java/lang/StringBuilder
    //   2535: dup
    //   2536: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   2539: ldc_w 763
    //   2542: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2545: lload 13
    //   2547: invokevirtual 356	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2550: ldc_w 765
    //   2553: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2556: iload 6
    //   2558: invokevirtual 430	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2561: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2564: invokespecial 706	com/tencent/oskplayer/proxy/LivePlayListException:<init>	(Ljava/lang/String;)V
    //   2567: athrow
    //   2568: aload_2
    //   2569: astore 16
    //   2571: aload 15
    //   2573: astore 17
    //   2575: aload_1
    //   2576: iload 7
    //   2578: putfield 729	com/tencent/oskplayer/proxy/LivePlayListInfo:mMaxMediaSequence	I
    //   2581: aload_2
    //   2582: astore 16
    //   2584: aload 15
    //   2586: astore 17
    //   2588: aload_1
    //   2589: invokestatic 491	java/lang/System:currentTimeMillis	()J
    //   2592: putfield 735	com/tencent/oskplayer/proxy/LivePlayListInfo:mUpdateMediaSequenceTimestamp	J
    //   2595: goto -450 -> 2145
    //   2598: ldc 61
    //   2600: astore_1
    //   2601: goto -403 -> 2198
    //   2604: astore_1
    //   2605: bipush 6
    //   2607: aload 21
    //   2609: new 250	java/lang/StringBuilder
    //   2612: dup
    //   2613: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   2616: ldc_w 767
    //   2619: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2622: aload_1
    //   2623: invokestatic 395	com/tencent/oskplayer/util/PlayerUtils:getPrintableStackTrace	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   2626: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2629: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2632: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2635: iconst_1
    //   2636: istore 5
    //   2638: goto -352 -> 2286
    //   2641: astore_1
    //   2642: bipush 6
    //   2644: aload 21
    //   2646: new 250	java/lang/StringBuilder
    //   2649: dup
    //   2650: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   2653: ldc_w 769
    //   2656: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2659: aload_1
    //   2660: invokestatic 395	com/tencent/oskplayer/util/PlayerUtils:getPrintableStackTrace	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   2663: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2666: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2669: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2672: iconst_1
    //   2673: istore 6
    //   2675: goto -371 -> 2304
    //   2678: astore_2
    //   2679: bipush 6
    //   2681: aload 21
    //   2683: new 250	java/lang/StringBuilder
    //   2686: dup
    //   2687: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   2690: ldc_w 767
    //   2693: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2696: aload_2
    //   2697: invokestatic 395	com/tencent/oskplayer/util/PlayerUtils:getPrintableStackTrace	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   2700: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2703: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2706: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2709: goto -1448 -> 1261
    //   2712: astore_1
    //   2713: bipush 6
    //   2715: aload 21
    //   2717: new 250	java/lang/StringBuilder
    //   2720: dup
    //   2721: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   2724: ldc_w 769
    //   2727: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2730: aload_1
    //   2731: invokestatic 395	com/tencent/oskplayer/util/PlayerUtils:getPrintableStackTrace	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   2734: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2737: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2740: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2743: goto -1474 -> 1269
    //   2746: aload_3
    //   2747: athrow
    //   2748: astore 4
    //   2750: aload_1
    //   2751: astore_3
    //   2752: iconst_1
    //   2753: istore 5
    //   2755: aload 4
    //   2757: astore_1
    //   2758: goto -998 -> 1760
    //   2761: astore_1
    //   2762: bipush 6
    //   2764: aload 21
    //   2766: new 250	java/lang/StringBuilder
    //   2769: dup
    //   2770: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   2773: ldc_w 767
    //   2776: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2779: aload_1
    //   2780: invokestatic 395	com/tencent/oskplayer/util/PlayerUtils:getPrintableStackTrace	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   2783: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2786: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2789: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2792: goto -1176 -> 1616
    //   2795: astore_1
    //   2796: bipush 6
    //   2798: aload 21
    //   2800: new 250	java/lang/StringBuilder
    //   2803: dup
    //   2804: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   2807: ldc_w 769
    //   2810: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2813: aload_1
    //   2814: invokestatic 395	com/tencent/oskplayer/util/PlayerUtils:getPrintableStackTrace	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   2817: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2820: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2823: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2826: goto -1202 -> 1624
    //   2829: iconst_1
    //   2830: istore 5
    //   2832: bipush 6
    //   2834: aload 21
    //   2836: aload_1
    //   2837: invokestatic 395	com/tencent/oskplayer/util/PlayerUtils:getPrintableStackTrace	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   2840: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2843: new 476	com/tencent/oskplayer/proxy/LivePlayListException
    //   2846: dup
    //   2847: aload_1
    //   2848: invokespecial 772	com/tencent/oskplayer/proxy/LivePlayListException:<init>	(Ljava/lang/Throwable;)V
    //   2851: athrow
    //   2852: astore_1
    //   2853: goto -1093 -> 1760
    //   2856: astore_2
    //   2857: bipush 6
    //   2859: aload 21
    //   2861: new 250	java/lang/StringBuilder
    //   2864: dup
    //   2865: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   2868: ldc_w 767
    //   2871: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2874: aload_2
    //   2875: invokestatic 395	com/tencent/oskplayer/util/PlayerUtils:getPrintableStackTrace	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   2878: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2881: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2884: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2887: goto -1119 -> 1768
    //   2890: astore_2
    //   2891: bipush 6
    //   2893: aload 21
    //   2895: new 250	java/lang/StringBuilder
    //   2898: dup
    //   2899: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   2902: ldc_w 769
    //   2905: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2908: aload_2
    //   2909: invokestatic 395	com/tencent/oskplayer/util/PlayerUtils:getPrintableStackTrace	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   2912: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2915: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2918: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2921: goto -1145 -> 1776
    //   2924: iload 6
    //   2926: ifeq +62 -> 2988
    //   2929: aload 22
    //   2931: ifnull +55 -> 2986
    //   2934: aload 22
    //   2936: invokevirtual 499	java/io/File:exists	()Z
    //   2939: ifeq +47 -> 2986
    //   2942: aload 22
    //   2944: invokevirtual 693	java/io/File:isFile	()Z
    //   2947: ifeq +39 -> 2986
    //   2950: aload 22
    //   2952: invokevirtual 696	java/io/File:delete	()Z
    //   2955: pop
    //   2956: iconst_4
    //   2957: aload 21
    //   2959: new 250	java/lang/StringBuilder
    //   2962: dup
    //   2963: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   2966: ldc_w 698
    //   2969: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2972: aload 22
    //   2974: invokevirtual 699	java/io/File:toString	()Ljava/lang/String;
    //   2977: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2980: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2983: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2986: aconst_null
    //   2987: areturn
    //   2988: aload 22
    //   2990: areturn
    //   2991: astore_1
    //   2992: aconst_null
    //   2993: astore_2
    //   2994: aconst_null
    //   2995: astore_3
    //   2996: iconst_0
    //   2997: istore 5
    //   2999: goto -1239 -> 1760
    //   3002: astore_1
    //   3003: aconst_null
    //   3004: astore_3
    //   3005: iconst_0
    //   3006: istore 5
    //   3008: goto -1248 -> 1760
    //   3011: astore 4
    //   3013: aload_1
    //   3014: astore_3
    //   3015: iconst_0
    //   3016: istore 5
    //   3018: aload 4
    //   3020: astore_1
    //   3021: goto -1261 -> 1760
    //   3024: astore_1
    //   3025: aconst_null
    //   3026: astore_2
    //   3027: aconst_null
    //   3028: astore_3
    //   3029: goto -1446 -> 1583
    //   3032: astore_1
    //   3033: aconst_null
    //   3034: astore_3
    //   3035: goto -1452 -> 1583
    //   3038: astore_3
    //   3039: aconst_null
    //   3040: astore_2
    //   3041: aconst_null
    //   3042: astore_1
    //   3043: goto -1803 -> 1240
    //   3046: astore_3
    //   3047: aconst_null
    //   3048: astore_1
    //   3049: goto -1809 -> 1240
    //   3052: iconst_0
    //   3053: istore 5
    //   3055: goto -769 -> 2286
    //   3058: goto +22 -> 3080
    //   3061: aconst_null
    //   3062: astore_1
    //   3063: iload 11
    //   3065: istore 9
    //   3067: iload 6
    //   3069: istore 8
    //   3071: goto -2064 -> 1007
    //   3074: iload 5
    //   3076: iconst_1
    //   3077: iadd
    //   3078: istore 5
    //   3080: aload 18
    //   3082: astore 19
    //   3084: iload 10
    //   3086: istore 6
    //   3088: goto -2761 -> 327
    //   3091: iconst_0
    //   3092: istore 5
    //   3094: goto -2926 -> 168
    //   3097: iconst_3
    //   3098: istore 12
    //   3100: goto -2912 -> 188
    //   3103: iconst_0
    //   3104: istore 10
    //   3106: goto -2763 -> 343
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3109	0	this	VideoProxy
    //   0	3109	1	paramDataSource	DataSource
    //   0	3109	2	paramDataSpec	DataSpec
    //   0	3109	3	paramString	String
    //   0	3109	4	paramVideoRequest	VideoRequest
    //   166	2927	5	i	int
    //   311	2776	6	j	int
    //   314	2263	7	k	int
    //   317	2753	8	m	int
    //   321	2745	9	n	int
    //   26	3079	10	i1	int
    //   629	2435	11	i2	int
    //   186	2913	12	i3	int
    //   2487	59	13	l	long
    //   62	2523	15	localObject1	Object
    //   34	2549	16	localObject2	Object
    //   280	2307	17	localObject3	Object
    //   416	2665	18	localObject4	Object
    //   308	2775	19	localObject5	Object
    //   821	674	20	localObject6	Object
    //   23	2935	21	str1	String
    //   112	2877	22	localFile	File
    //   173	319	23	str2	String
    //   235	508	24	localPattern	java.util.regex.Pattern
    //   289	1880	25	localStringBuilder	java.lang.StringBuilder
    //   374	1319	26	str3	String
    //   854	139	27	str4	String
    // Exception table:
    //   from	to	target	type
    //   282	291	1236	com/tencent/oskplayer/proxy/LivePlayListException
    //   298	307	1236	com/tencent/oskplayer/proxy/LivePlayListException
    //   334	340	1236	com/tencent/oskplayer/proxy/LivePlayListException
    //   355	363	1236	com/tencent/oskplayer/proxy/LivePlayListException
    //   370	376	1236	com/tencent/oskplayer/proxy/LivePlayListException
    //   388	396	1236	com/tencent/oskplayer/proxy/LivePlayListException
    //   403	414	1236	com/tencent/oskplayer/proxy/LivePlayListException
    //   425	439	1236	com/tencent/oskplayer/proxy/LivePlayListException
    //   450	464	1236	com/tencent/oskplayer/proxy/LivePlayListException
    //   471	480	1236	com/tencent/oskplayer/proxy/LivePlayListException
    //   487	506	1236	com/tencent/oskplayer/proxy/LivePlayListException
    //   513	527	1236	com/tencent/oskplayer/proxy/LivePlayListException
    //   540	553	1236	com/tencent/oskplayer/proxy/LivePlayListException
    //   560	574	1236	com/tencent/oskplayer/proxy/LivePlayListException
    //   581	588	1236	com/tencent/oskplayer/proxy/LivePlayListException
    //   599	613	1236	com/tencent/oskplayer/proxy/LivePlayListException
    //   620	627	1236	com/tencent/oskplayer/proxy/LivePlayListException
    //   642	656	1236	com/tencent/oskplayer/proxy/LivePlayListException
    //   671	688	1236	com/tencent/oskplayer/proxy/LivePlayListException
    //   701	714	1236	com/tencent/oskplayer/proxy/LivePlayListException
    //   721	735	1236	com/tencent/oskplayer/proxy/LivePlayListException
    //   742	750	1236	com/tencent/oskplayer/proxy/LivePlayListException
    //   757	764	1236	com/tencent/oskplayer/proxy/LivePlayListException
    //   771	778	1236	com/tencent/oskplayer/proxy/LivePlayListException
    //   785	792	1236	com/tencent/oskplayer/proxy/LivePlayListException
    //   799	806	1236	com/tencent/oskplayer/proxy/LivePlayListException
    //   813	823	1236	com/tencent/oskplayer/proxy/LivePlayListException
    //   830	840	1236	com/tencent/oskplayer/proxy/LivePlayListException
    //   847	856	1236	com/tencent/oskplayer/proxy/LivePlayListException
    //   863	891	1236	com/tencent/oskplayer/proxy/LivePlayListException
    //   901	909	1236	com/tencent/oskplayer/proxy/LivePlayListException
    //   916	946	1236	com/tencent/oskplayer/proxy/LivePlayListException
    //   953	974	1236	com/tencent/oskplayer/proxy/LivePlayListException
    //   981	1004	1236	com/tencent/oskplayer/proxy/LivePlayListException
    //   1014	1025	1236	com/tencent/oskplayer/proxy/LivePlayListException
    //   1032	1043	1236	com/tencent/oskplayer/proxy/LivePlayListException
    //   1050	1061	1236	com/tencent/oskplayer/proxy/LivePlayListException
    //   1080	1087	1236	com/tencent/oskplayer/proxy/LivePlayListException
    //   1094	1117	1236	com/tencent/oskplayer/proxy/LivePlayListException
    //   1124	1151	1236	com/tencent/oskplayer/proxy/LivePlayListException
    //   1158	1167	1236	com/tencent/oskplayer/proxy/LivePlayListException
    //   1174	1181	1236	com/tencent/oskplayer/proxy/LivePlayListException
    //   1188	1194	1236	com/tencent/oskplayer/proxy/LivePlayListException
    //   1201	1209	1236	com/tencent/oskplayer/proxy/LivePlayListException
    //   1219	1233	1236	com/tencent/oskplayer/proxy/LivePlayListException
    //   1335	1349	1236	com/tencent/oskplayer/proxy/LivePlayListException
    //   1369	1380	1236	com/tencent/oskplayer/proxy/LivePlayListException
    //   1387	1398	1236	com/tencent/oskplayer/proxy/LivePlayListException
    //   1405	1416	1236	com/tencent/oskplayer/proxy/LivePlayListException
    //   1423	1431	1236	com/tencent/oskplayer/proxy/LivePlayListException
    //   1438	1462	1236	com/tencent/oskplayer/proxy/LivePlayListException
    //   1472	1480	1236	com/tencent/oskplayer/proxy/LivePlayListException
    //   1487	1517	1236	com/tencent/oskplayer/proxy/LivePlayListException
    //   1524	1545	1236	com/tencent/oskplayer/proxy/LivePlayListException
    //   1552	1565	1236	com/tencent/oskplayer/proxy/LivePlayListException
    //   1690	1704	1236	com/tencent/oskplayer/proxy/LivePlayListException
    //   1724	1732	1236	com/tencent/oskplayer/proxy/LivePlayListException
    //   1739	1750	1236	com/tencent/oskplayer/proxy/LivePlayListException
    //   1852	1861	1236	com/tencent/oskplayer/proxy/LivePlayListException
    //   1868	1876	1236	com/tencent/oskplayer/proxy/LivePlayListException
    //   1883	1892	1236	com/tencent/oskplayer/proxy/LivePlayListException
    //   1904	1910	1236	com/tencent/oskplayer/proxy/LivePlayListException
    //   1917	1930	1236	com/tencent/oskplayer/proxy/LivePlayListException
    //   1937	1955	1236	com/tencent/oskplayer/proxy/LivePlayListException
    //   1962	1976	1236	com/tencent/oskplayer/proxy/LivePlayListException
    //   1989	2000	1236	com/tencent/oskplayer/proxy/LivePlayListException
    //   2013	2024	1236	com/tencent/oskplayer/proxy/LivePlayListException
    //   2031	2039	1236	com/tencent/oskplayer/proxy/LivePlayListException
    //   2046	2059	1236	com/tencent/oskplayer/proxy/LivePlayListException
    //   2066	2084	1236	com/tencent/oskplayer/proxy/LivePlayListException
    //   2091	2118	1236	com/tencent/oskplayer/proxy/LivePlayListException
    //   2125	2131	1236	com/tencent/oskplayer/proxy/LivePlayListException
    //   2138	2145	1236	com/tencent/oskplayer/proxy/LivePlayListException
    //   2152	2161	1236	com/tencent/oskplayer/proxy/LivePlayListException
    //   2168	2174	1236	com/tencent/oskplayer/proxy/LivePlayListException
    //   2186	2195	1236	com/tencent/oskplayer/proxy/LivePlayListException
    //   2205	2213	1236	com/tencent/oskplayer/proxy/LivePlayListException
    //   2220	2229	1236	com/tencent/oskplayer/proxy/LivePlayListException
    //   2236	2243	1236	com/tencent/oskplayer/proxy/LivePlayListException
    //   2250	2259	1236	com/tencent/oskplayer/proxy/LivePlayListException
    //   2266	2275	1236	com/tencent/oskplayer/proxy/LivePlayListException
    //   2388	2397	1236	com/tencent/oskplayer/proxy/LivePlayListException
    //   2404	2456	1236	com/tencent/oskplayer/proxy/LivePlayListException
    //   2463	2472	1236	com/tencent/oskplayer/proxy/LivePlayListException
    //   2479	2489	1236	com/tencent/oskplayer/proxy/LivePlayListException
    //   2509	2521	1236	com/tencent/oskplayer/proxy/LivePlayListException
    //   2528	2568	1236	com/tencent/oskplayer/proxy/LivePlayListException
    //   2575	2581	1236	com/tencent/oskplayer/proxy/LivePlayListException
    //   2588	2595	1236	com/tencent/oskplayer/proxy/LivePlayListException
    //   282	291	1579	java/lang/Exception
    //   298	307	1579	java/lang/Exception
    //   334	340	1579	java/lang/Exception
    //   355	363	1579	java/lang/Exception
    //   370	376	1579	java/lang/Exception
    //   388	396	1579	java/lang/Exception
    //   403	414	1579	java/lang/Exception
    //   425	439	1579	java/lang/Exception
    //   450	464	1579	java/lang/Exception
    //   471	480	1579	java/lang/Exception
    //   487	506	1579	java/lang/Exception
    //   513	527	1579	java/lang/Exception
    //   540	553	1579	java/lang/Exception
    //   560	574	1579	java/lang/Exception
    //   581	588	1579	java/lang/Exception
    //   599	613	1579	java/lang/Exception
    //   620	627	1579	java/lang/Exception
    //   642	656	1579	java/lang/Exception
    //   671	688	1579	java/lang/Exception
    //   701	714	1579	java/lang/Exception
    //   721	735	1579	java/lang/Exception
    //   742	750	1579	java/lang/Exception
    //   757	764	1579	java/lang/Exception
    //   771	778	1579	java/lang/Exception
    //   785	792	1579	java/lang/Exception
    //   799	806	1579	java/lang/Exception
    //   813	823	1579	java/lang/Exception
    //   830	840	1579	java/lang/Exception
    //   847	856	1579	java/lang/Exception
    //   863	891	1579	java/lang/Exception
    //   901	909	1579	java/lang/Exception
    //   916	946	1579	java/lang/Exception
    //   953	974	1579	java/lang/Exception
    //   981	1004	1579	java/lang/Exception
    //   1014	1025	1579	java/lang/Exception
    //   1032	1043	1579	java/lang/Exception
    //   1050	1061	1579	java/lang/Exception
    //   1080	1087	1579	java/lang/Exception
    //   1094	1117	1579	java/lang/Exception
    //   1124	1151	1579	java/lang/Exception
    //   1158	1167	1579	java/lang/Exception
    //   1174	1181	1579	java/lang/Exception
    //   1188	1194	1579	java/lang/Exception
    //   1201	1209	1579	java/lang/Exception
    //   1219	1233	1579	java/lang/Exception
    //   1335	1349	1579	java/lang/Exception
    //   1369	1380	1579	java/lang/Exception
    //   1387	1398	1579	java/lang/Exception
    //   1405	1416	1579	java/lang/Exception
    //   1423	1431	1579	java/lang/Exception
    //   1438	1462	1579	java/lang/Exception
    //   1472	1480	1579	java/lang/Exception
    //   1487	1517	1579	java/lang/Exception
    //   1524	1545	1579	java/lang/Exception
    //   1552	1565	1579	java/lang/Exception
    //   1690	1704	1579	java/lang/Exception
    //   1724	1732	1579	java/lang/Exception
    //   1739	1750	1579	java/lang/Exception
    //   1852	1861	1579	java/lang/Exception
    //   1868	1876	1579	java/lang/Exception
    //   1883	1892	1579	java/lang/Exception
    //   1904	1910	1579	java/lang/Exception
    //   1917	1930	1579	java/lang/Exception
    //   1937	1955	1579	java/lang/Exception
    //   1962	1976	1579	java/lang/Exception
    //   1989	2000	1579	java/lang/Exception
    //   2013	2024	1579	java/lang/Exception
    //   2031	2039	1579	java/lang/Exception
    //   2046	2059	1579	java/lang/Exception
    //   2066	2084	1579	java/lang/Exception
    //   2091	2118	1579	java/lang/Exception
    //   2125	2131	1579	java/lang/Exception
    //   2138	2145	1579	java/lang/Exception
    //   2152	2161	1579	java/lang/Exception
    //   2168	2174	1579	java/lang/Exception
    //   2186	2195	1579	java/lang/Exception
    //   2205	2213	1579	java/lang/Exception
    //   2220	2229	1579	java/lang/Exception
    //   2236	2243	1579	java/lang/Exception
    //   2250	2259	1579	java/lang/Exception
    //   2266	2275	1579	java/lang/Exception
    //   2388	2397	1579	java/lang/Exception
    //   2404	2456	1579	java/lang/Exception
    //   2463	2472	1579	java/lang/Exception
    //   2479	2489	1579	java/lang/Exception
    //   2509	2521	1579	java/lang/Exception
    //   2528	2568	1579	java/lang/Exception
    //   2575	2581	1579	java/lang/Exception
    //   2588	2595	1579	java/lang/Exception
    //   282	291	1750	finally
    //   298	307	1750	finally
    //   334	340	1750	finally
    //   355	363	1750	finally
    //   370	376	1750	finally
    //   388	396	1750	finally
    //   403	414	1750	finally
    //   425	439	1750	finally
    //   450	464	1750	finally
    //   471	480	1750	finally
    //   487	506	1750	finally
    //   513	527	1750	finally
    //   540	553	1750	finally
    //   560	574	1750	finally
    //   581	588	1750	finally
    //   599	613	1750	finally
    //   620	627	1750	finally
    //   642	656	1750	finally
    //   671	688	1750	finally
    //   701	714	1750	finally
    //   721	735	1750	finally
    //   742	750	1750	finally
    //   757	764	1750	finally
    //   771	778	1750	finally
    //   785	792	1750	finally
    //   799	806	1750	finally
    //   813	823	1750	finally
    //   830	840	1750	finally
    //   847	856	1750	finally
    //   863	891	1750	finally
    //   901	909	1750	finally
    //   916	946	1750	finally
    //   953	974	1750	finally
    //   981	1004	1750	finally
    //   1014	1025	1750	finally
    //   1032	1043	1750	finally
    //   1050	1061	1750	finally
    //   1080	1087	1750	finally
    //   1094	1117	1750	finally
    //   1124	1151	1750	finally
    //   1158	1167	1750	finally
    //   1174	1181	1750	finally
    //   1188	1194	1750	finally
    //   1201	1209	1750	finally
    //   1219	1233	1750	finally
    //   1335	1349	1750	finally
    //   1369	1380	1750	finally
    //   1387	1398	1750	finally
    //   1405	1416	1750	finally
    //   1423	1431	1750	finally
    //   1438	1462	1750	finally
    //   1472	1480	1750	finally
    //   1487	1517	1750	finally
    //   1524	1545	1750	finally
    //   1552	1565	1750	finally
    //   1589	1597	1750	finally
    //   1603	1608	1750	finally
    //   1690	1704	1750	finally
    //   1724	1732	1750	finally
    //   1739	1750	1750	finally
    //   1852	1861	1750	finally
    //   1868	1876	1750	finally
    //   1883	1892	1750	finally
    //   1904	1910	1750	finally
    //   1917	1930	1750	finally
    //   1937	1955	1750	finally
    //   1962	1976	1750	finally
    //   1989	2000	1750	finally
    //   2013	2024	1750	finally
    //   2031	2039	1750	finally
    //   2046	2059	1750	finally
    //   2066	2084	1750	finally
    //   2091	2118	1750	finally
    //   2125	2131	1750	finally
    //   2138	2145	1750	finally
    //   2152	2161	1750	finally
    //   2168	2174	1750	finally
    //   2186	2195	1750	finally
    //   2205	2213	1750	finally
    //   2220	2229	1750	finally
    //   2236	2243	1750	finally
    //   2250	2259	1750	finally
    //   2266	2275	1750	finally
    //   2388	2397	1750	finally
    //   2404	2456	1750	finally
    //   2463	2472	1750	finally
    //   2479	2489	1750	finally
    //   2509	2521	1750	finally
    //   2528	2568	1750	finally
    //   2575	2581	1750	finally
    //   2588	2595	1750	finally
    //   2279	2283	2604	java/io/IOException
    //   2295	2300	2641	java/io/IOException
    //   1257	1261	2678	java/io/IOException
    //   1265	1269	2712	java/io/IOException
    //   2746	2748	2748	finally
    //   1612	1616	2761	java/io/IOException
    //   1620	1624	2795	java/io/IOException
    //   2832	2852	2852	finally
    //   1764	1768	2856	java/io/IOException
    //   1772	1776	2890	java/io/IOException
    //   237	264	2991	finally
    //   264	275	3002	finally
    //   1240	1253	3011	finally
    //   237	264	3024	java/lang/Exception
    //   264	275	3032	java/lang/Exception
    //   237	264	3038	com/tencent/oskplayer/proxy/LivePlayListException
    //   264	275	3046	com/tencent/oskplayer/proxy/LivePlayListException
  }
  
  private HttpHeader getExtraHeaderById(int paramInt)
  {
    Iterator localIterator = this.mExtraHeaderCollection.iterator();
    while (localIterator.hasNext())
    {
      HttpHeader localHttpHeader = (HttpHeader)localIterator.next();
      if (paramInt == localHttpHeader.getId()) {
        return localHttpHeader;
      }
    }
    return null;
  }
  
  private int getFakeHttpStatus(Throwable paramThrowable)
  {
    if (paramThrowable.toString().toLowerCase().contains("unexpected end of stream")) {
      return 6;
    }
    if ((paramThrowable.getCause() != null) && ((paramThrowable.getCause() instanceof SocketTimeoutException))) {
      return 14;
    }
    return 7;
  }
  
  private ArrayList<VideoRequest> getIdleVideoRequest(ArrayList<VideoRequest> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      VideoRequest localVideoRequest = (VideoRequest)paramArrayList.next();
      if (localVideoRequest.isIdle()) {
        localArrayList.add(localVideoRequest);
      }
    }
    return localArrayList;
  }
  
  private ArrayList<VideoRequest> getPreloadVideoRequestByVideoKey(String paramString)
  {
    return this.videoRequestManager.getVideoRequestByVideoKey(paramString, 10);
  }
  
  public static String getSourceUrl(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      PlayerUtils.log(6, "VideoProxy", "getSourceUrl: httpUrl is empty");
    }
    while (!paramString.contains("http://127.0.0.1")) {
      return paramString;
    }
    try
    {
      String str = Uri.parse(paramString).getQueryParameter("v");
      return str;
    }
    catch (Exception localException)
    {
      PlayerUtils.log(6, "VideoProxy", "getSourceUrl: Exception=" + localException);
    }
    return paramString;
  }
  
  private VideoProxy.DataSourceOpenResult openDataSource(DataSource paramDataSource, DataSpec paramDataSpec, String paramString1, String paramString2, VideoRequest paramVideoRequest, Socket paramSocket, String paramString3, long paramLong1, long paramLong2, long paramLong3)
  {
    VideoProxy.DataSourceOpenResult localDataSourceOpenResult = new VideoProxy.DataSourceOpenResult(this, null);
    localDataSourceOpenResult.retCode = paramLong1;
    PlayerUtils.log(4, paramString2, "dataSpec=" + paramDataSpec.toString());
    if (!PlayerUtils.isHLSStream(paramString1)) {
      paramDataSource.open(paramDataSpec);
    }
    int j;
    for (;;)
    {
      return localDataSourceOpenResult;
      try
      {
        localDataSourceOpenResult.localPlayListFile = generateLocalPlaylistFile(paramDataSource, paramDataSpec, paramString1, paramVideoRequest);
        if (localDataSourceOpenResult.localPlayListFile == null) {
          break label522;
        }
        PlayerUtils.log(4, paramString2, "localPlaylist generate success " + localDataSourceOpenResult.localPlayListFile.toString());
        paramDataSource = new VideoProxy.3(this);
        paramDataSource.open(new DataSpec(Uri.fromFile(localDataSourceOpenResult.localPlayListFile), paramDataSpec.absoluteStreamPosition, paramDataSpec.position, paramDataSpec.length, paramDataSpec.key, paramDataSpec.flags, paramDataSpec.uuid, paramDataSpec.priority));
        if (paramDataSource != null) {
          localDataSourceOpenResult.dataSource = paramDataSource;
        }
      }
      catch (LivePlayListException paramDataSource)
      {
        j = 0;
        PlayerUtils.log(6, "VideoProxy/" + paramVideoRequest.getSeqNum(), "livePlayListException " + paramDataSource);
        if (paramDataSource.getCause() == null) {
          break label504;
        }
      }
    }
    int i = j;
    if (!(paramDataSource.getCause() instanceof HttpDataSource.InterruptConnectServerException))
    {
      if (!(paramDataSource.getCause() instanceof HttpDataSource.InterruptReadException)) {
        break label497;
      }
      i = j;
    }
    for (;;)
    {
      if ((paramVideoRequest.getPrority() == 90) && (i != 0))
      {
        localDataSourceOpenResult.retCode = PlayerUtils.getDownloadRetCode(i, paramLong2);
        paramDataSource = (VideoProxy.HttpErrorListener)this.httpUrlErrorListenerMap.get(paramString3);
        paramDataSpec = (VideoProxy.HttpErrorListener)this.uuidErrorListenerMap.get(paramVideoRequest.getUuid());
        if (paramDataSource != null) {
          paramDataSource.onHttpError(paramVideoRequest.getUuid(), paramString1, i, null, new HashMap(), (int)(System.currentTimeMillis() - paramLong3), localDataSourceOpenResult.retCode, paramLong2);
        }
        if (paramDataSpec != null) {
          paramDataSpec.onHttpError(paramVideoRequest.getUuid(), paramString1, i, null, new HashMap(), (int)(System.currentTimeMillis() - paramLong3), localDataSourceOpenResult.retCode, paramLong2);
        }
      }
      try
      {
        paramSocket.close();
        this.videoRequestManager.removeRequest(paramVideoRequest);
        if (paramVideoRequest.isCancelProcceed())
        {
          paramVideoRequest.setStoppedReason(256);
          PlayerUtils.log(4, paramString2, paramVideoRequest + " is interrupted");
          paramVideoRequest.enterCancelSuccessState();
        }
        for (;;)
        {
          paramVideoRequest.setIsStopped(true);
          localDataSourceOpenResult.isHandled = true;
          return localDataSourceOpenResult;
          label497:
          i = 17;
          break;
          label504:
          i = 16;
          break;
          paramVideoRequest.setStoppedReason(257);
        }
        label522:
        if (paramVideoRequest.getPrority() == 90)
        {
          PlayerUtils.getDownloadRetCode(18, paramLong2);
          paramDataSource = (VideoProxy.HttpErrorListener)this.httpUrlErrorListenerMap.get(paramString3);
          paramDataSpec = (VideoProxy.HttpErrorListener)this.uuidErrorListenerMap.get(paramVideoRequest.getUuid());
          if (paramDataSource != null) {
            paramDataSource.onHttpError(paramVideoRequest.getUuid(), paramString1, 18, null, new HashMap(), (int)(System.currentTimeMillis() - paramLong3), localDataSourceOpenResult.retCode, paramLong2);
          }
          if (paramDataSpec != null) {
            paramDataSpec.onHttpError(paramVideoRequest.getUuid(), paramString1, 18, null, new HashMap(), (int)(System.currentTimeMillis() - paramLong3), localDataSourceOpenResult.retCode, paramLong2);
          }
        }
        PlayerUtils.log(4, paramString2, "localPlaylist generate fail, see previous logs");
      }
      catch (IOException paramDataSource)
      {
        try
        {
          paramSocket.close();
          label668:
          this.videoRequestManager.removeRequest(paramVideoRequest);
          if (paramVideoRequest.isCancelProcceed())
          {
            paramVideoRequest.setStoppedReason(256);
            PlayerUtils.log(4, paramString2, paramVideoRequest + " is interrupted");
            paramVideoRequest.enterCancelSuccessState();
          }
          for (;;)
          {
            paramVideoRequest.setIsStopped(true);
            localDataSourceOpenResult.isHandled = true;
            return localDataSourceOpenResult;
            paramVideoRequest.setStoppedReason(257);
          }
          paramDataSource = paramDataSource;
        }
        catch (IOException paramDataSource)
        {
          break label668;
        }
      }
    }
  }
  
  private void preloadMediasAsync(ArrayList<VideoProxy.PreloadInfo> paramArrayList, int paramInt, long paramLong, PreloadListener paramPreloadListener, String paramString)
  {
    ArrayList localArrayList;
    if (TextUtils.isEmpty(paramString))
    {
      paramString = "preloadMediasAsync";
      localArrayList = new ArrayList();
      paramArrayList = paramArrayList.iterator();
    }
    for (;;)
    {
      label27:
      if (!paramArrayList.hasNext()) {
        break label258;
      }
      VideoProxy.PreloadInfo localPreloadInfo = (VideoProxy.PreloadInfo)paramArrayList.next();
      int i = 1;
      if (paramLong == -1L) {
        if (!isCached(localPreloadInfo.originalUrl)) {
          i = 1;
        }
      }
      for (;;)
      {
        if (i == 0) {
          break label198;
        }
        localArrayList.add(new VideoProxy.4(this, localPreloadInfo, paramLong, paramPreloadListener, paramString));
        break label27;
        break;
        i = 0;
        continue;
        if (paramLong > 0L)
        {
          long l = paramLong - this.cache.getCachedBytesFromStart(PlayerUtils.parseVideoKey(localPreloadInfo.originalUrl));
          PlayerUtils.log(3, paramString, "remainingBytes2Cache " + l + ",url=" + localPreloadInfo.originalUrl);
          if (l > 0L) {
            i = 1;
          } else {
            i = 0;
          }
        }
      }
      label198:
      if (paramPreloadListener != null) {
        paramPreloadListener.onFinish(localPreloadInfo.originalUrl);
      }
      PlayerUtils.log(4, paramString, "url " + localPreloadInfo.originalUrl + " already cached, cacheMaxBytes=" + paramLong);
    }
    label258:
    if (localArrayList.size() > 0) {
      ThreadUtils.executePriorityTask(localArrayList, paramInt);
    }
  }
  
  private void preloadMediasAsync(ArrayList<VideoProxy.PreloadInfo> paramArrayList, String paramString)
  {
    preloadMediasAsync(paramArrayList, 2, -1L, null, paramString);
  }
  
  private void processSocket(Socket paramSocket, VideoRequest paramVideoRequest)
  {
    String str1 = "VideoProxy/" + paramVideoRequest.getSeqNum();
    String str2 = str1 + "/";
    PlayerUtils.log(3, str1, "process socket");
    Object localObject1;
    Object localObject3;
    Object localObject4;
    String str3;
    Object localObject2;
    String str4;
    String str5;
    String str6;
    String str7;
    String str8;
    String str9;
    Object localObject5;
    try
    {
      localObject1 = paramSocket.getInputStream();
      if (localObject1 == null)
      {
        PlayerUtils.log(6, str1, "socket inputstream is null");
        return;
      }
      localObject3 = PlayerConfig.g().getOnConnectionChangeListener();
      if (localObject3 != null) {
        ((VideoProxy.OnConnectionChangeListener)localObject3).onConnectionChange(true, (InputStream)localObject1, null);
      }
      localObject4 = new HttpParser((InputStream)localObject1, str2);
      str3 = ((HttpParser)localObject4).getRequestMethod();
      localObject2 = ((HttpParser)localObject4).getParam("v");
      str4 = ((HttpParser)localObject4).getParam("p");
      str5 = ((HttpParser)localObject4).getParam("uuid");
      str6 = ((HttpParser)localObject4).getParam("enableCache");
      str7 = ((HttpParser)localObject4).getParam("dataSourceType");
      str8 = ((HttpParser)localObject4).getParam("preferredContentType");
      str9 = ((HttpParser)localObject4).getParam("t");
      localObject5 = ((HttpParser)localObject4).getParam("eh");
      if (localObject2 != null) {
        break label466;
      }
      PlayerUtils.log(6, str1, "invalid request detected, sourceUrl is null");
      return;
    }
    catch (Exception paramSocket)
    {
      this.mProxyExceptionCount += 1;
      PlayerUtils.log(5, str1, "mProxyExceptionCount " + this.mProxyExceptionCount);
      localObject1 = PlayerUtils.getPrintableStackTrace(paramSocket);
      if (PlayerConfig.g().getVideoReporter() == null) {
        break label429;
      }
    }
    long l1 = -99999L;
    if ((paramSocket instanceof ProxyException)) {
      l1 = -99999L + ((ProxyException)paramSocket).getErrCode();
    }
    for (;;)
    {
      long l2 = PlayerUtils.getDownloadRetCode(4L, l1);
      long l3 = PlayerUtils.getDownloadResponseCode(l2, l1);
      if (!UuidPlayIdMap.isUuidDeleted(paramVideoRequest.getUuid()))
      {
        localObject2 = new HashMap();
        ((HashMap)localObject2).put("responseCode", Long.valueOf(l3));
        ((HashMap)localObject2).put("subRetCode", Long.valueOf(l1));
        ((HashMap)localObject2).put("message", "(" + l3 + "," + l1 + ")," + paramSocket.toString());
        PlayerConfig.g().getVideoReporter().downloadResult(paramVideoRequest.getUuid(), l2, (Map)localObject2);
      }
      label429:
      PlayerUtils.log(6, str1, "unexpected proxy err " + paramSocket.getMessage() + (String)localObject1, paramSocket);
      return;
      label466:
      int j = -1;
      int i = j;
      if (!TextUtils.isEmpty((CharSequence)localObject5))
      {
        boolean bool = TextUtils.isDigitsOnly((CharSequence)localObject5);
        i = j;
        if (!bool) {}
      }
      try
      {
        i = Integer.parseInt((String)localObject5, 10);
        if (i != -1)
        {
          localObject5 = getExtraHeaderById(i);
          if (localObject5 == null) {
            PlayerUtils.log(6, str1, "ehid=" + i + " is invalid");
          }
        }
        else
        {
          localObject5 = ((HttpParser)localObject4).getRawHeaders();
          PlayerUtils.log(4, str1, PlayerUtils.removeLineBreaks("mediaplayer request header:" + (String)localObject5, null));
          localObject4 = paramSocket.getOutputStream();
          if (localObject4 != null) {
            break label658;
          }
          PlayerUtils.log(6, str1, "socket outputstream is null");
          return;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          PlayerUtils.log(6, str1, "invalid extraHeaderId " + (String)localObject5);
          i = j;
          continue;
          paramVideoRequest.setExtraHeader((HttpHeader)localObject5);
        }
        label658:
        if (localObject3 != null) {
          ((VideoProxy.OnConnectionChangeListener)localObject3).onConnectionChange(true, null, (OutputStream)localObject4);
        }
        localObject3 = HttpParser.getRangeOffset((String)localObject5);
        paramVideoRequest.setRequestMethod(str3);
        paramVideoRequest.setSourceUrl((String)localObject2);
        paramVideoRequest.setRangeStart(localObject3[0]);
        paramVideoRequest.setRangeEnd(localObject3[1]);
        paramVideoRequest.setUuid(str5);
        if ((!TextUtils.isEmpty(str6)) && (str6.equals("1")))
        {
          paramVideoRequest.setCacheEnabled(true);
          paramVideoRequest.setDataSourceType(str7);
          paramVideoRequest.setPreferredContentType(str8);
          paramVideoRequest.setLogTag(str2);
          if (!TextUtils.isEmpty(str4)) {
            break label884;
          }
          paramVideoRequest.setPrority(-1);
        }
        for (;;)
        {
          if (paramVideoRequest.getPrority() == -1) {
            PlayerUtils.log(5, str1, "videoRequest " + paramVideoRequest + " priority is not specified");
          }
          PlayerUtils.log(4, str1, "dump videoRequest=" + paramVideoRequest);
          cancelPreloadRequestsSync(paramVideoRequest.getVideoKey(), paramVideoRequest);
          if ((!this.isSecretEnable) || (!PlayerConfig.g().isEnableProxySecret())) {
            break label1017;
          }
          if (str9 != null) {
            break label936;
          }
          PlayerUtils.log(6, str1, "invalid request detected, token is null");
          return;
          paramVideoRequest.setCacheEnabled(false);
          break;
          label884:
          if (str4.equals(String.valueOf(90))) {
            paramVideoRequest.setPrority(90);
          } else if (str4.equals(String.valueOf(10))) {
            paramVideoRequest.setPrority(10);
          } else {
            paramVideoRequest.setPrority(-1);
          }
        }
        try
        {
          label936:
          str2 = SecretUtils.decode("des", SecretUtils.getRandomNum(), str9);
          str3 = PlayerUtils.parseVideoKey((String)localObject2);
          if ((str2 == null) || (!str2.equals(str3)))
          {
            PlayerUtils.log(6, str1, "invalid request detected, key is illegal");
            throw new ProxyException("token required", 100);
          }
        }
        catch (Throwable paramSocket)
        {
          PlayerUtils.log(5, str1, "decode token error");
          throw new ProxyException("parse token err", 101);
        }
        label1017:
        this.videoRequestManager.addRequest((String)localObject2, paramVideoRequest);
        writeResponse(paramSocket, (String)localObject2, (OutputStream)localObject4, paramVideoRequest, (InputStream)localObject1);
        return;
      }
      if ((paramSocket instanceof IllegalDataSpecException)) {
        l1 = -99999L + 200L;
      } else if ((paramSocket instanceof ArrayIndexOutOfBoundsException)) {
        l1 = -99999L + 300L;
      }
    }
  }
  
  private void sendUrlRequestSync(String paramString1, long paramLong, PreloadListener paramPreloadListener, String paramString2)
  {
    localDefaultHttpDataSource = new DefaultHttpDataSource("com.qzone.player-v20150909", null, null);
    str = "VideoProxy/sendUrlRequest/" + paramString2;
    paramString2 = new byte[512];
    PlayerUtils.log(4, str, "sendUrlRequest start url=" + paramString1);
    if (paramPreloadListener != null) {}
    try
    {
      paramPreloadListener.onStart(paramString1);
      localDefaultHttpDataSource.open(new DataSpec(Uri.parse(paramString1), 0L, 0L, -1L, null, 0, null));
      l2 = localDefaultHttpDataSource.getTotalLength();
      l1 = 0L;
    }
    catch (Exception paramString2)
    {
      for (;;)
      {
        try
        {
          long l4;
          PlayerUtils.log(4, str, "sendUrlRequest finish, totalReadBytes=" + paramLong);
          try
          {
            localDefaultHttpDataSource.close();
            l1 = paramLong;
            l3 = l2;
            if (paramPreloadListener != null)
            {
              paramPreloadListener.onFinish(paramString1);
              l3 = l2;
              l1 = paramLong;
            }
            PlayerUtils.log(4, str, "sendUrlRequest totalLength=" + l3 + ", totalReadBytes=" + l1);
            return;
          }
          catch (Exception paramString2)
          {
            PlayerUtils.log(4, str, "sendUrlRequest closeException" + paramString2);
            continue;
          }
          paramString2 = paramString2;
          l2 = -1L;
          paramLong = 0L;
        }
        catch (Exception paramString2)
        {
          long l2;
          long l3;
          continue;
        }
        PlayerUtils.log(4, str, "sendUrlRequest exit with message" + paramString2.getMessage());
        try
        {
          localDefaultHttpDataSource.close();
          l1 = paramLong;
          l3 = l2;
          if (paramPreloadListener == null) {
            continue;
          }
          paramPreloadListener.onFinish(paramString1);
          l1 = paramLong;
          l3 = l2;
        }
        catch (Exception paramString2)
        {
          PlayerUtils.log(4, str, "sendUrlRequest closeException" + paramString2);
        }
      }
    }
    finally
    {
      try
      {
        localDefaultHttpDataSource.close();
        if (paramPreloadListener == null) {
          break label476;
        }
        paramPreloadListener.onFinish(paramString1);
        throw paramString2;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          PlayerUtils.log(4, str, "sendUrlRequest closeException" + localException);
        }
      }
    }
    l3 = l1;
  }
  
  /* Error */
  private void waitForRequest()
  {
    // Byte code:
    //   0: iconst_3
    //   1: ldc 49
    //   3: ldc_w 1222
    //   6: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   9: invokestatic 1226	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   12: invokevirtual 1229	java/lang/Thread:isInterrupted	()Z
    //   15: ifne +164 -> 179
    //   18: aload_0
    //   19: getfield 305	com/tencent/oskplayer/proxy/VideoProxy:serverSocket	Ljava/net/ServerSocket;
    //   22: invokevirtual 1233	java/net/ServerSocket:accept	()Ljava/net/Socket;
    //   25: astore_3
    //   26: new 312	java/util/concurrent/CountDownLatch
    //   29: dup
    //   30: iconst_1
    //   31: invokespecial 313	java/util/concurrent/CountDownLatch:<init>	(I)V
    //   34: astore_2
    //   35: new 1235	com/tencent/oskplayer/proxy/VideoProxy$SocketHandler
    //   38: dup
    //   39: aload_0
    //   40: aload_3
    //   41: aload_2
    //   42: invokespecial 1238	com/tencent/oskplayer/proxy/VideoProxy$SocketHandler:<init>	(Lcom/tencent/oskplayer/proxy/VideoProxy;Ljava/net/Socket;Ljava/util/concurrent/CountDownLatch;)V
    //   45: astore_3
    //   46: invokestatic 176	com/tencent/oskplayer/PlayerConfig:g	()Lcom/tencent/oskplayer/PlayerConfig;
    //   49: invokevirtual 1241	com/tencent/oskplayer/PlayerConfig:isDebugVersion	()Z
    //   52: ifeq +16 -> 68
    //   55: iconst_3
    //   56: ldc 49
    //   58: aload_0
    //   59: getfield 265	com/tencent/oskplayer/proxy/VideoProxy:videoRequestManager	Lcom/tencent/oskplayer/proxy/VideoRequestManager;
    //   62: invokevirtual 1242	com/tencent/oskplayer/proxy/VideoRequestManager:toString	()Ljava/lang/String;
    //   65: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   68: iconst_4
    //   69: ldc 49
    //   71: aload_0
    //   72: getfield 288	com/tencent/oskplayer/proxy/VideoProxy:executorService	Ljava/util/concurrent/ExecutorService;
    //   75: invokevirtual 1243	java/lang/Object:toString	()Ljava/lang/String;
    //   78: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   81: aload_0
    //   82: getfield 288	com/tencent/oskplayer/proxy/VideoProxy:executorService	Ljava/util/concurrent/ExecutorService;
    //   85: aload_3
    //   86: invokeinterface 1247 2 0
    //   91: astore 4
    //   93: aload_0
    //   94: getfield 288	com/tencent/oskplayer/proxy/VideoProxy:executorService	Ljava/util/concurrent/ExecutorService;
    //   97: checkcast 267	com/tencent/oskplayer/util/ThreadUtils$FlexibleSizeExecutor
    //   100: invokevirtual 1250	com/tencent/oskplayer/util/ThreadUtils$FlexibleSizeExecutor:getPendingTaskCount	()I
    //   103: istore_1
    //   104: aload_0
    //   105: getfield 288	com/tencent/oskplayer/proxy/VideoProxy:executorService	Ljava/util/concurrent/ExecutorService;
    //   108: checkcast 1252	java/util/concurrent/ThreadPoolExecutor
    //   111: iload_1
    //   112: iconst_2
    //   113: iadd
    //   114: invokevirtual 1255	java/util/concurrent/ThreadPoolExecutor:setCorePoolSize	(I)V
    //   117: aload_3
    //   118: aload 4
    //   120: invokevirtual 1259	com/tencent/oskplayer/proxy/VideoProxy$SocketHandler:setTask	(Ljava/util/concurrent/Future;)V
    //   123: aload_2
    //   124: invokevirtual 1262	java/util/concurrent/CountDownLatch:countDown	()V
    //   127: goto -118 -> 9
    //   130: astore_2
    //   131: aload_0
    //   132: getfield 305	com/tencent/oskplayer/proxy/VideoProxy:serverSocket	Ljava/net/ServerSocket;
    //   135: invokevirtual 1265	java/net/ServerSocket:isClosed	()Z
    //   138: ifeq +70 -> 208
    //   141: iconst_3
    //   142: ldc 49
    //   144: ldc_w 1267
    //   147: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   150: iconst_3
    //   151: ldc 49
    //   153: ldc_w 1269
    //   156: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   159: aload_0
    //   160: getfield 288	com/tencent/oskplayer/proxy/VideoProxy:executorService	Ljava/util/concurrent/ExecutorService;
    //   163: invokeinterface 1273 1 0
    //   168: pop
    //   169: iconst_3
    //   170: ldc 49
    //   172: ldc_w 1275
    //   175: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   178: return
    //   179: iconst_3
    //   180: ldc 49
    //   182: ldc_w 1269
    //   185: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   188: aload_0
    //   189: getfield 288	com/tencent/oskplayer/proxy/VideoProxy:executorService	Ljava/util/concurrent/ExecutorService;
    //   192: invokeinterface 1273 1 0
    //   197: pop
    //   198: iconst_3
    //   199: ldc 49
    //   201: ldc_w 1275
    //   204: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   207: return
    //   208: bipush 6
    //   210: ldc 49
    //   212: new 250	java/lang/StringBuilder
    //   215: dup
    //   216: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   219: ldc_w 1277
    //   222: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: aload_2
    //   226: invokestatic 395	com/tencent/oskplayer/util/PlayerUtils:getPrintableStackTrace	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   229: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   235: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   238: goto -88 -> 150
    //   241: astore_2
    //   242: iconst_3
    //   243: ldc 49
    //   245: ldc_w 1269
    //   248: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   251: aload_0
    //   252: getfield 288	com/tencent/oskplayer/proxy/VideoProxy:executorService	Ljava/util/concurrent/ExecutorService;
    //   255: invokeinterface 1273 1 0
    //   260: pop
    //   261: iconst_3
    //   262: ldc 49
    //   264: ldc_w 1275
    //   267: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   270: aload_2
    //   271: athrow
    //   272: astore_2
    //   273: bipush 6
    //   275: ldc 49
    //   277: new 250	java/lang/StringBuilder
    //   280: dup
    //   281: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   284: ldc_w 1277
    //   287: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: aload_2
    //   291: invokestatic 395	com/tencent/oskplayer/util/PlayerUtils:getPrintableStackTrace	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   294: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   300: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   303: iconst_3
    //   304: ldc 49
    //   306: ldc_w 1269
    //   309: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   312: aload_0
    //   313: getfield 288	com/tencent/oskplayer/proxy/VideoProxy:executorService	Ljava/util/concurrent/ExecutorService;
    //   316: invokeinterface 1273 1 0
    //   321: pop
    //   322: iconst_3
    //   323: ldc 49
    //   325: ldc_w 1275
    //   328: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   331: return
    //   332: astore_2
    //   333: bipush 6
    //   335: ldc 49
    //   337: new 250	java/lang/StringBuilder
    //   340: dup
    //   341: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   344: ldc_w 1279
    //   347: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: aload_2
    //   351: invokestatic 395	com/tencent/oskplayer/util/PlayerUtils:getPrintableStackTrace	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   354: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   357: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   360: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   363: iconst_3
    //   364: ldc 49
    //   366: ldc_w 1269
    //   369: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   372: aload_0
    //   373: getfield 288	com/tencent/oskplayer/proxy/VideoProxy:executorService	Ljava/util/concurrent/ExecutorService;
    //   376: invokeinterface 1273 1 0
    //   381: pop
    //   382: iconst_3
    //   383: ldc 49
    //   385: ldc_w 1275
    //   388: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   391: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	392	0	this	VideoProxy
    //   103	11	1	i	int
    //   34	90	2	localCountDownLatch	CountDownLatch
    //   130	96	2	localSocketException	java.net.SocketException
    //   241	30	2	localObject1	Object
    //   272	19	2	localIOException	IOException
    //   332	19	2	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   25	93	3	localObject2	Object
    //   91	28	4	localFuture	Future
    // Exception table:
    //   from	to	target	type
    //   9	68	130	java/net/SocketException
    //   68	127	130	java/net/SocketException
    //   9	68	241	finally
    //   68	127	241	finally
    //   131	150	241	finally
    //   208	238	241	finally
    //   273	303	241	finally
    //   333	363	241	finally
    //   9	68	272	java/io/IOException
    //   68	127	272	java/io/IOException
    //   9	68	332	java/lang/OutOfMemoryError
    //   68	127	332	java/lang/OutOfMemoryError
  }
  
  /* Error */
  private void writeResponse(Socket paramSocket, String paramString, OutputStream paramOutputStream, VideoRequest paramVideoRequest, InputStream paramInputStream)
  {
    // Byte code:
    //   0: aload 4
    //   2: invokevirtual 1282	com/tencent/oskplayer/proxy/VideoRequest:getRangeEnd	()J
    //   5: lstore 26
    //   7: aload 4
    //   9: invokevirtual 1285	com/tencent/oskplayer/proxy/VideoRequest:getRangeStart	()J
    //   12: lstore 22
    //   14: aload 4
    //   16: invokevirtual 1133	com/tencent/oskplayer/proxy/VideoRequest:getVideoKey	()Ljava/lang/String;
    //   19: astore 39
    //   21: aload 4
    //   23: invokevirtual 644	com/tencent/oskplayer/proxy/VideoRequest:getDataSourceType	()Ljava/lang/String;
    //   26: astore 32
    //   28: invokestatic 176	com/tencent/oskplayer/PlayerConfig:g	()Lcom/tencent/oskplayer/PlayerConfig;
    //   31: invokevirtual 1289	com/tencent/oskplayer/PlayerConfig:getDataSourceBuilder	()Lcom/tencent/oskplayer/proxy/DataSourceBuilder;
    //   34: astore 31
    //   36: aload_0
    //   37: getfield 219	com/tencent/oskplayer/proxy/VideoProxy:httpRetryLogicMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   40: aload 39
    //   42: invokevirtual 1290	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   45: checkcast 1292	com/tencent/oskplayer/proxy/HttpRetryLogic
    //   48: astore 34
    //   50: new 250	java/lang/StringBuilder
    //   53: dup
    //   54: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   57: ldc 8
    //   59: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: aload 4
    //   64: invokevirtual 427	com/tencent/oskplayer/proxy/VideoRequest:getSeqNum	()I
    //   67: invokevirtual 430	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   70: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: astore 38
    //   75: new 250	java/lang/StringBuilder
    //   78: dup
    //   79: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   82: aload 38
    //   84: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: ldc 52
    //   89: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: astore 33
    //   97: aload 31
    //   99: ifnonnull +5785 -> 5884
    //   102: aload_0
    //   103: getfield 1294	com/tencent/oskplayer/proxy/VideoProxy:tcDataSourceUtils	Lcom/tencent/oskplayer/proxy/ITcDataSourceUtils;
    //   106: ifnull +186 -> 292
    //   109: aload 32
    //   111: ldc 61
    //   113: invokestatic 1297	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   116: ifne +13 -> 129
    //   119: aload 32
    //   121: ldc 81
    //   123: invokestatic 1297	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   126: ifeq +166 -> 292
    //   129: aload_0
    //   130: getfield 1294	com/tencent/oskplayer/proxy/VideoProxy:tcDataSourceUtils	Lcom/tencent/oskplayer/proxy/ITcDataSourceUtils;
    //   133: invokeinterface 1302 1 0
    //   138: ifeq +154 -> 292
    //   141: aload_0
    //   142: getfield 1294	com/tencent/oskplayer/proxy/VideoProxy:tcDataSourceUtils	Lcom/tencent/oskplayer/proxy/ITcDataSourceUtils;
    //   145: aload_2
    //   146: invokeinterface 1305 2 0
    //   151: ifne +141 -> 292
    //   154: aload_0
    //   155: getfield 181	com/tencent/oskplayer/proxy/VideoProxy:isCacheProviderLocal	Z
    //   158: ifeq +85 -> 243
    //   161: aload_0
    //   162: getfield 1294	com/tencent/oskplayer/proxy/VideoProxy:tcDataSourceUtils	Lcom/tencent/oskplayer/proxy/ITcDataSourceUtils;
    //   165: aload_0
    //   166: getfield 240	com/tencent/oskplayer/proxy/VideoProxy:cache	Lcom/tencent/oskplayer/cache/Cache;
    //   169: aload 34
    //   171: aload 4
    //   173: invokeinterface 1308 4 0
    //   178: astore 32
    //   180: aload 32
    //   182: astore 31
    //   184: aload_0
    //   185: getfield 157	com/tencent/oskplayer/proxy/VideoProxy:isPauseTcStorageIO	Z
    //   188: ifne +22 -> 210
    //   191: aload_0
    //   192: getfield 1294	com/tencent/oskplayer/proxy/VideoProxy:tcDataSourceUtils	Lcom/tencent/oskplayer/proxy/ITcDataSourceUtils;
    //   195: invokeinterface 1311 1 0
    //   200: pop
    //   201: aload_0
    //   202: iconst_1
    //   203: putfield 157	com/tencent/oskplayer/proxy/VideoProxy:isPauseTcStorageIO	Z
    //   206: aload 32
    //   208: astore 31
    //   210: aload 31
    //   212: ifnull +100 -> 312
    //   215: aload 31
    //   217: aload_2
    //   218: aload 33
    //   220: invokeinterface 1317 3 0
    //   225: astore 31
    //   227: aload 31
    //   229: ifnonnull +118 -> 347
    //   232: bipush 6
    //   234: aload 38
    //   236: ldc_w 1319
    //   239: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   242: return
    //   243: aload_0
    //   244: getfield 1294	com/tencent/oskplayer/proxy/VideoProxy:tcDataSourceUtils	Lcom/tencent/oskplayer/proxy/ITcDataSourceUtils;
    //   247: aconst_null
    //   248: aload 34
    //   250: aload 4
    //   252: invokeinterface 1308 4 0
    //   257: astore 32
    //   259: aload 32
    //   261: astore 31
    //   263: aload_0
    //   264: getfield 157	com/tencent/oskplayer/proxy/VideoProxy:isPauseTcStorageIO	Z
    //   267: ifeq -57 -> 210
    //   270: aload_0
    //   271: getfield 1294	com/tencent/oskplayer/proxy/VideoProxy:tcDataSourceUtils	Lcom/tencent/oskplayer/proxy/ITcDataSourceUtils;
    //   274: invokeinterface 1322 1 0
    //   279: pop
    //   280: aload_0
    //   281: iconst_0
    //   282: putfield 157	com/tencent/oskplayer/proxy/VideoProxy:isPauseTcStorageIO	Z
    //   285: aload 32
    //   287: astore 31
    //   289: goto -79 -> 210
    //   292: new 1324	com/tencent/oskplayer/datasource/DefaultDataSourceBuilder
    //   295: dup
    //   296: aload_0
    //   297: getfield 240	com/tencent/oskplayer/proxy/VideoProxy:cache	Lcom/tencent/oskplayer/cache/Cache;
    //   300: aload 34
    //   302: aload 4
    //   304: invokespecial 1327	com/tencent/oskplayer/datasource/DefaultDataSourceBuilder:<init>	(Lcom/tencent/oskplayer/cache/Cache;Lcom/tencent/oskplayer/proxy/HttpRetryLogic;Lcom/tencent/oskplayer/proxy/VideoRequest;)V
    //   307: astore 31
    //   309: goto -99 -> 210
    //   312: new 1181	com/tencent/oskplayer/datasource/DefaultHttpDataSource
    //   315: dup
    //   316: ldc 55
    //   318: new 1329	com/tencent/oskplayer/util/PassOnVideoType
    //   321: dup
    //   322: invokespecial 1330	com/tencent/oskplayer/util/PassOnVideoType:<init>	()V
    //   325: aload 4
    //   327: invokevirtual 1334	com/tencent/oskplayer/proxy/VideoRequest:getContentTypeFixer	()Lcom/tencent/oskplayer/util/Fixer;
    //   330: invokespecial 1184	com/tencent/oskplayer/datasource/DefaultHttpDataSource:<init>	(Ljava/lang/String;Lcom/tencent/oskplayer/util/Predicate;Lcom/tencent/oskplayer/util/Fixer;)V
    //   333: astore 31
    //   335: aload 31
    //   337: aload 33
    //   339: invokeinterface 1335 2 0
    //   344: goto -117 -> 227
    //   347: iconst_0
    //   348: istore 7
    //   350: ldc_w 1336
    //   353: newarray byte
    //   355: astore 35
    //   357: getstatic 1342	com/tencent/oskplayer/proxy/FileType:UNKNOWN	Lcom/tencent/oskplayer/proxy/FileType;
    //   360: astore 32
    //   362: ldc2_w 929
    //   365: lstore 16
    //   367: lload 16
    //   369: lstore 14
    //   371: lload 26
    //   373: ldc2_w 929
    //   376: lcmp
    //   377: ifeq +25 -> 402
    //   380: lload 16
    //   382: lstore 14
    //   384: lload 26
    //   386: ldc2_w 1343
    //   389: lcmp
    //   390: ifeq +12 -> 402
    //   393: lload 26
    //   395: lload 22
    //   397: lsub
    //   398: lconst_1
    //   399: ladd
    //   400: lstore 14
    //   402: aload_2
    //   403: invokestatic 817	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   406: astore 33
    //   408: lload 22
    //   410: ldc2_w 929
    //   413: lcmp
    //   414: ifne +363 -> 777
    //   417: lconst_0
    //   418: lstore 16
    //   420: lload 22
    //   422: ldc2_w 929
    //   425: lcmp
    //   426: ifne +358 -> 784
    //   429: lconst_0
    //   430: lstore 18
    //   432: new 836	com/tencent/oskplayer/datasource/DataSpec
    //   435: dup
    //   436: aload 33
    //   438: lload 16
    //   440: lload 18
    //   442: lload 14
    //   444: aload 39
    //   446: iconst_0
    //   447: aload 4
    //   449: invokevirtual 513	com/tencent/oskplayer/proxy/VideoRequest:getUuid	()Ljava/lang/String;
    //   452: aload 4
    //   454: invokevirtual 510	com/tencent/oskplayer/proxy/VideoRequest:getPrority	()I
    //   457: invokespecial 879	com/tencent/oskplayer/datasource/DataSpec:<init>	(Landroid/net/Uri;JJJLjava/lang/String;ILjava/lang/String;I)V
    //   460: astore 36
    //   462: new 1346	java/io/BufferedOutputStream
    //   465: dup
    //   466: aload_3
    //   467: invokespecial 1349	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   470: astore 40
    //   472: invokestatic 491	java/lang/System:currentTimeMillis	()J
    //   475: lstore 28
    //   477: ldc2_w 1005
    //   480: lstore 24
    //   482: new 1351	com/tencent/oskplayer/util/VideoSpeedReport$ReportPoint
    //   485: dup
    //   486: ldc_w 1353
    //   489: iconst_0
    //   490: new 250	java/lang/StringBuilder
    //   493: dup
    //   494: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   497: ldc_w 1355
    //   500: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   503: lload 22
    //   505: invokevirtual 356	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   508: ldc_w 1038
    //   511: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   514: lload 26
    //   516: invokevirtual 356	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   519: ldc_w 1357
    //   522: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   525: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   528: invokespecial 1360	com/tencent/oskplayer/util/VideoSpeedReport$ReportPoint:<init>	(Ljava/lang/String;ZLjava/lang/String;)V
    //   531: astore 37
    //   533: ldc_w 1362
    //   536: aload 37
    //   538: invokestatic 1368	com/tencent/oskplayer/util/VideoSpeedReport$ReportType:addToVideoReportType	(Ljava/lang/String;Lcom/tencent/oskplayer/util/VideoSpeedReport$ReportPoint;)V
    //   541: invokestatic 1373	com/tencent/oskplayer/util/VideoSpeedReport:g	()Lcom/tencent/oskplayer/util/VideoSpeedReport;
    //   544: aload 37
    //   546: invokevirtual 1376	com/tencent/oskplayer/util/VideoSpeedReport:start	(Lcom/tencent/oskplayer/util/VideoSpeedReport$ReportPoint;)V
    //   549: aload_0
    //   550: aload 31
    //   552: aload 36
    //   554: aload_2
    //   555: aload 38
    //   557: aload 4
    //   559: aload_1
    //   560: aload 39
    //   562: lconst_0
    //   563: ldc2_w 1005
    //   566: lload 28
    //   568: invokespecial 1378	com/tencent/oskplayer/proxy/VideoProxy:openDataSource	(Lcom/tencent/oskplayer/datasource/DataSource;Lcom/tencent/oskplayer/datasource/DataSpec;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/oskplayer/proxy/VideoRequest;Ljava/net/Socket;Ljava/lang/String;JJJ)Lcom/tencent/oskplayer/proxy/VideoProxy$DataSourceOpenResult;
    //   571: astore 33
    //   573: aload 33
    //   575: getfield 832	com/tencent/oskplayer/proxy/VideoProxy$DataSourceOpenResult:retCode	J
    //   578: lstore 14
    //   580: aload 33
    //   582: getfield 846	com/tencent/oskplayer/proxy/VideoProxy$DataSourceOpenResult:localPlayListFile	Ljava/io/File;
    //   585: astore 34
    //   587: aload 33
    //   589: getfield 924	com/tencent/oskplayer/proxy/VideoProxy$DataSourceOpenResult:isHandled	Z
    //   592: istore 30
    //   594: iload 30
    //   596: ifeq +208 -> 804
    //   599: iconst_4
    //   600: aload 38
    //   602: new 250	java/lang/StringBuilder
    //   605: dup
    //   606: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   609: ldc_w 1380
    //   612: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   615: iconst_0
    //   616: invokevirtual 430	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   619: ldc_w 1382
    //   622: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   625: lload 22
    //   627: invokevirtual 356	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   630: ldc_w 1384
    //   633: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   636: lload 26
    //   638: invokevirtual 356	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   641: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   644: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   647: aload 31
    //   649: invokeinterface 1208 1 0
    //   654: iconst_0
    //   655: ifne +7 -> 662
    //   658: aload_1
    //   659: invokevirtual 902	java/net/Socket:close	()V
    //   662: aload 34
    //   664: ifnull +91 -> 755
    //   667: aload 34
    //   669: invokevirtual 693	java/io/File:isFile	()Z
    //   672: ifeq +83 -> 755
    //   675: aload 34
    //   677: invokevirtual 499	java/io/File:exists	()Z
    //   680: ifeq +75 -> 755
    //   683: aload 34
    //   685: invokevirtual 696	java/io/File:delete	()Z
    //   688: istore 30
    //   690: iconst_4
    //   691: aload 38
    //   693: new 250	java/lang/StringBuilder
    //   696: dup
    //   697: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   700: ldc_w 698
    //   703: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   706: aload 34
    //   708: invokevirtual 699	java/io/File:toString	()Ljava/lang/String;
    //   711: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   714: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   717: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   720: iload 30
    //   722: ifne +33 -> 755
    //   725: iconst_5
    //   726: aload 38
    //   728: new 250	java/lang/StringBuilder
    //   731: dup
    //   732: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   735: ldc_w 1386
    //   738: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   741: aload 34
    //   743: invokevirtual 699	java/io/File:toString	()Ljava/lang/String;
    //   746: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   749: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   752: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   755: invokestatic 176	com/tencent/oskplayer/PlayerConfig:g	()Lcom/tencent/oskplayer/PlayerConfig;
    //   758: invokevirtual 979	com/tencent/oskplayer/PlayerConfig:getOnConnectionChangeListener	()Lcom/tencent/oskplayer/proxy/VideoProxy$OnConnectionChangeListener;
    //   761: astore_1
    //   762: aload_1
    //   763: ifnull -521 -> 242
    //   766: aload_1
    //   767: iconst_0
    //   768: aload 5
    //   770: aload_3
    //   771: invokeinterface 985 4 0
    //   776: return
    //   777: lload 22
    //   779: lstore 16
    //   781: goto -361 -> 420
    //   784: lload 22
    //   786: lstore 18
    //   788: goto -356 -> 432
    //   791: astore_2
    //   792: iconst_5
    //   793: aload 38
    //   795: ldc_w 1388
    //   798: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   801: goto -147 -> 654
    //   804: aload 33
    //   806: getfield 883	com/tencent/oskplayer/proxy/VideoProxy$DataSourceOpenResult:dataSource	Lcom/tencent/oskplayer/datasource/DataSource;
    //   809: ifnull +970 -> 1779
    //   812: aload 33
    //   814: getfield 883	com/tencent/oskplayer/proxy/VideoProxy$DataSourceOpenResult:dataSource	Lcom/tencent/oskplayer/datasource/DataSource;
    //   817: astore 33
    //   819: aload 33
    //   821: astore 31
    //   823: aload 31
    //   825: invokeinterface 1197 1 0
    //   830: lstore 16
    //   832: aload 31
    //   834: invokeinterface 1392 1 0
    //   839: astore 33
    //   841: aload 4
    //   843: lload 16
    //   845: aload 33
    //   847: invokevirtual 1396	com/tencent/oskplayer/proxy/VideoRequest:updateInfo	(JLcom/tencent/oskplayer/proxy/FileType;)V
    //   850: aload 33
    //   852: invokevirtual 1397	com/tencent/oskplayer/proxy/FileType:toString	()Ljava/lang/String;
    //   855: astore 32
    //   857: aload_2
    //   858: invokestatic 840	com/tencent/oskplayer/util/PlayerUtils:isHLSStream	(Ljava/lang/String;)Z
    //   861: ifne +1022 -> 1883
    //   864: iconst_1
    //   865: istore 30
    //   867: lload 22
    //   869: lload 26
    //   871: lload 16
    //   873: aload 32
    //   875: iload 30
    //   877: invokestatic 1401	com/tencent/oskplayer/util/HttpParser:newResponseHeader	(JJJLjava/lang/String;Z)Ljava/lang/String;
    //   880: astore 32
    //   882: aload 33
    //   884: getstatic 1342	com/tencent/oskplayer/proxy/FileType:UNKNOWN	Lcom/tencent/oskplayer/proxy/FileType;
    //   887: invokevirtual 1402	com/tencent/oskplayer/proxy/FileType:equals	(Ljava/lang/Object;)Z
    //   890: ifeq +13 -> 903
    //   893: bipush 6
    //   895: aload 38
    //   897: ldc_w 1404
    //   900: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   903: iconst_4
    //   904: aload 38
    //   906: new 250	java/lang/StringBuilder
    //   909: dup
    //   910: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   913: ldc_w 1406
    //   916: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   919: lload 16
    //   921: invokevirtual 356	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   924: ldc_w 1408
    //   927: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   930: aload 32
    //   932: aconst_null
    //   933: invokestatic 1078	com/tencent/oskplayer/util/PlayerUtils:removeLineBreaks	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   936: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   939: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   942: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   945: aload 40
    //   947: aload 32
    //   949: ldc_w 541
    //   952: invokevirtual 1411	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   955: invokevirtual 755	java/io/OutputStream:write	([B)V
    //   958: aload 40
    //   960: invokevirtual 1414	java/io/OutputStream:flush	()V
    //   963: invokestatic 1373	com/tencent/oskplayer/util/VideoSpeedReport:g	()Lcom/tencent/oskplayer/util/VideoSpeedReport;
    //   966: aload 37
    //   968: invokevirtual 1416	com/tencent/oskplayer/util/VideoSpeedReport:end	(Lcom/tencent/oskplayer/util/VideoSpeedReport$ReportPoint;)V
    //   971: invokestatic 491	java/lang/System:currentTimeMillis	()J
    //   974: lstore 18
    //   976: iconst_1
    //   977: istore 6
    //   979: iconst_0
    //   980: istore 7
    //   982: iload 6
    //   984: istore 8
    //   986: iload 7
    //   988: istore 9
    //   990: iload 6
    //   992: istore 11
    //   994: iload 7
    //   996: istore 10
    //   998: iload 7
    //   1000: istore 12
    //   1002: invokestatic 557	java/lang/Thread:interrupted	()Z
    //   1005: ifne +884 -> 1889
    //   1008: iconst_1
    //   1009: istore 6
    //   1011: iload 6
    //   1013: ifeq +100 -> 1113
    //   1016: iload 6
    //   1018: istore 8
    //   1020: iload 7
    //   1022: istore 9
    //   1024: iload 6
    //   1026: istore 11
    //   1028: iload 7
    //   1030: istore 10
    //   1032: iload 7
    //   1034: istore 12
    //   1036: aload 4
    //   1038: invokevirtual 560	com/tencent/oskplayer/proxy/VideoRequest:shouldCancel	()Z
    //   1041: ifne +72 -> 1113
    //   1044: iload 6
    //   1046: istore 8
    //   1048: iload 7
    //   1050: istore 9
    //   1052: iload 6
    //   1054: istore 11
    //   1056: iload 7
    //   1058: istore 10
    //   1060: iload 7
    //   1062: istore 12
    //   1064: aload 31
    //   1066: aload 35
    //   1068: iconst_0
    //   1069: aload 35
    //   1071: arraylength
    //   1072: invokeinterface 1201 4 0
    //   1077: istore 13
    //   1079: iload 13
    //   1081: iconst_m1
    //   1082: if_icmpeq +31 -> 1113
    //   1085: iload 6
    //   1087: istore 8
    //   1089: iload 7
    //   1091: istore 9
    //   1093: iload 6
    //   1095: istore 11
    //   1097: iload 7
    //   1099: istore 10
    //   1101: iload 7
    //   1103: istore 12
    //   1105: aload 4
    //   1107: invokevirtual 1419	com/tencent/oskplayer/proxy/VideoRequest:isHeadRequest	()Z
    //   1110: ifeq +785 -> 1895
    //   1113: iload 6
    //   1115: ifne +78 -> 1193
    //   1118: iload 6
    //   1120: istore 8
    //   1122: iload 7
    //   1124: istore 9
    //   1126: iload 6
    //   1128: istore 11
    //   1130: iload 7
    //   1132: istore 10
    //   1134: iload 7
    //   1136: istore 12
    //   1138: aload 4
    //   1140: sipush 256
    //   1143: invokevirtual 912	com/tencent/oskplayer/proxy/VideoRequest:setStoppedReason	(I)V
    //   1146: iload 6
    //   1148: istore 8
    //   1150: iload 7
    //   1152: istore 9
    //   1154: iload 6
    //   1156: istore 11
    //   1158: iload 7
    //   1160: istore 10
    //   1162: iload 7
    //   1164: istore 12
    //   1166: iconst_4
    //   1167: aload 38
    //   1169: new 250	java/lang/StringBuilder
    //   1172: dup
    //   1173: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   1176: aload 4
    //   1178: invokevirtual 507	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1181: ldc_w 914
    //   1184: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1187: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1190: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   1193: iload 6
    //   1195: istore 8
    //   1197: iload 7
    //   1199: istore 9
    //   1201: iload 6
    //   1203: istore 11
    //   1205: iload 7
    //   1207: istore 10
    //   1209: iload 7
    //   1211: istore 12
    //   1213: aload 4
    //   1215: invokevirtual 560	com/tencent/oskplayer/proxy/VideoRequest:shouldCancel	()Z
    //   1218: ifeq +28 -> 1246
    //   1221: iload 6
    //   1223: istore 8
    //   1225: iload 7
    //   1227: istore 9
    //   1229: iload 6
    //   1231: istore 11
    //   1233: iload 7
    //   1235: istore 10
    //   1237: iload 7
    //   1239: istore 12
    //   1241: aload 4
    //   1243: invokevirtual 684	com/tencent/oskplayer/proxy/VideoRequest:enterCancelProceedState	()V
    //   1246: iload 6
    //   1248: istore 8
    //   1250: iload 7
    //   1252: istore 9
    //   1254: iload 6
    //   1256: istore 11
    //   1258: iload 7
    //   1260: istore 10
    //   1262: iload 7
    //   1264: istore 12
    //   1266: aload 40
    //   1268: invokevirtual 1414	java/io/OutputStream:flush	()V
    //   1271: iload 6
    //   1273: istore 8
    //   1275: iload 7
    //   1277: istore 9
    //   1279: iload 6
    //   1281: istore 11
    //   1283: iload 7
    //   1285: istore 10
    //   1287: iload 7
    //   1289: istore 12
    //   1291: aload 40
    //   1293: invokevirtual 690	java/io/OutputStream:close	()V
    //   1296: iconst_4
    //   1297: aload 38
    //   1299: new 250	java/lang/StringBuilder
    //   1302: dup
    //   1303: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   1306: ldc_w 1380
    //   1309: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1312: iload 7
    //   1314: invokevirtual 430	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1317: ldc_w 1382
    //   1320: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1323: lload 22
    //   1325: invokevirtual 356	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1328: ldc_w 1384
    //   1331: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1334: lload 26
    //   1336: invokevirtual 356	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1339: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1342: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   1345: aload 31
    //   1347: invokeinterface 1208 1 0
    //   1352: iconst_0
    //   1353: ifne +7 -> 1360
    //   1356: aload_1
    //   1357: invokevirtual 902	java/net/Socket:close	()V
    //   1360: aload 34
    //   1362: ifnull +91 -> 1453
    //   1365: aload 34
    //   1367: invokevirtual 693	java/io/File:isFile	()Z
    //   1370: ifeq +83 -> 1453
    //   1373: aload 34
    //   1375: invokevirtual 499	java/io/File:exists	()Z
    //   1378: ifeq +75 -> 1453
    //   1381: aload 34
    //   1383: invokevirtual 696	java/io/File:delete	()Z
    //   1386: istore 30
    //   1388: iconst_4
    //   1389: aload 38
    //   1391: new 250	java/lang/StringBuilder
    //   1394: dup
    //   1395: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   1398: ldc_w 698
    //   1401: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1404: aload 34
    //   1406: invokevirtual 699	java/io/File:toString	()Ljava/lang/String;
    //   1409: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1412: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1415: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   1418: iload 30
    //   1420: ifne +33 -> 1453
    //   1423: iconst_5
    //   1424: aload 38
    //   1426: new 250	java/lang/StringBuilder
    //   1429: dup
    //   1430: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   1433: ldc_w 1386
    //   1436: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1439: aload 34
    //   1441: invokevirtual 699	java/io/File:toString	()Ljava/lang/String;
    //   1444: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1447: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1450: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   1453: invokestatic 176	com/tencent/oskplayer/PlayerConfig:g	()Lcom/tencent/oskplayer/PlayerConfig;
    //   1456: invokevirtual 979	com/tencent/oskplayer/PlayerConfig:getOnConnectionChangeListener	()Lcom/tencent/oskplayer/proxy/VideoProxy$OnConnectionChangeListener;
    //   1459: astore_1
    //   1460: aload_1
    //   1461: ifnull +13 -> 1474
    //   1464: aload_1
    //   1465: iconst_0
    //   1466: aload 5
    //   1468: aload_3
    //   1469: invokeinterface 985 4 0
    //   1474: ldc2_w 1005
    //   1477: lstore 16
    //   1479: aconst_null
    //   1480: astore_3
    //   1481: aload 31
    //   1483: astore_1
    //   1484: aload_0
    //   1485: getfield 265	com/tencent/oskplayer/proxy/VideoProxy:videoRequestManager	Lcom/tencent/oskplayer/proxy/VideoRequestManager;
    //   1488: aload 4
    //   1490: invokevirtual 906	com/tencent/oskplayer/proxy/VideoRequestManager:removeRequest	(Lcom/tencent/oskplayer/proxy/VideoRequest;)V
    //   1493: aload 4
    //   1495: invokevirtual 909	com/tencent/oskplayer/proxy/VideoRequest:isCancelProcceed	()Z
    //   1498: ifeq +3327 -> 4825
    //   1501: aload 4
    //   1503: invokevirtual 917	com/tencent/oskplayer/proxy/VideoRequest:enterCancelSuccessState	()V
    //   1506: aload 4
    //   1508: iconst_1
    //   1509: invokevirtual 921	com/tencent/oskplayer/proxy/VideoRequest:setIsStopped	(Z)V
    //   1512: aload 4
    //   1514: invokevirtual 513	com/tencent/oskplayer/proxy/VideoRequest:getUuid	()Ljava/lang/String;
    //   1517: astore 5
    //   1519: invokestatic 176	com/tencent/oskplayer/PlayerConfig:g	()Lcom/tencent/oskplayer/PlayerConfig;
    //   1522: invokevirtual 1004	com/tencent/oskplayer/PlayerConfig:getVideoReporter	()Lcom/tencent/oskplayer/report/IVideoReporter;
    //   1525: ifnull +93 -> 1618
    //   1528: lload 14
    //   1530: lload 16
    //   1532: invokestatic 1016	com/tencent/oskplayer/util/PlayerUtils:getDownloadResponseCode	(JJ)J
    //   1535: lstore 18
    //   1537: aload 5
    //   1539: invokestatic 1021	com/tencent/oskplayer/proxy/UuidPlayIdMap:isUuidDeleted	(Ljava/lang/String;)Z
    //   1542: ifne +76 -> 1618
    //   1545: new 207	java/util/HashMap
    //   1548: dup
    //   1549: invokespecial 208	java/util/HashMap:<init>	()V
    //   1552: astore 31
    //   1554: aload 31
    //   1556: ldc_w 1034
    //   1559: new 250	java/lang/StringBuilder
    //   1562: dup
    //   1563: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   1566: ldc_w 1036
    //   1569: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1572: lload 18
    //   1574: invokevirtual 356	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1577: ldc_w 1038
    //   1580: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1583: lload 16
    //   1585: invokevirtual 356	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1588: ldc_w 1421
    //   1591: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1594: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1597: invokevirtual 1030	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1600: pop
    //   1601: invokestatic 176	com/tencent/oskplayer/PlayerConfig:g	()Lcom/tencent/oskplayer/PlayerConfig;
    //   1604: invokevirtual 1004	com/tencent/oskplayer/PlayerConfig:getVideoReporter	()Lcom/tencent/oskplayer/report/IVideoReporter;
    //   1607: aload 5
    //   1609: lload 14
    //   1611: aload 31
    //   1613: invokeinterface 1047 5 0
    //   1618: aload_0
    //   1619: getfield 212	com/tencent/oskplayer/proxy/VideoProxy:httpUrlErrorListenerMap	Ljava/util/Map;
    //   1622: aload 39
    //   1624: invokeinterface 722 2 0
    //   1629: checkcast 895	com/tencent/oskplayer/proxy/VideoProxy$HttpErrorListener
    //   1632: astore 32
    //   1634: aload_0
    //   1635: getfield 214	com/tencent/oskplayer/proxy/VideoProxy:uuidErrorListenerMap	Ljava/util/Map;
    //   1638: aload 4
    //   1640: invokevirtual 513	com/tencent/oskplayer/proxy/VideoRequest:getUuid	()Ljava/lang/String;
    //   1643: invokeinterface 722 2 0
    //   1648: checkcast 895	com/tencent/oskplayer/proxy/VideoProxy$HttpErrorListener
    //   1651: astore 5
    //   1653: new 207	java/util/HashMap
    //   1656: dup
    //   1657: invokespecial 208	java/util/HashMap:<init>	()V
    //   1660: astore 31
    //   1662: aload 31
    //   1664: ldc_w 1422
    //   1667: aload 4
    //   1669: invokevirtual 510	com/tencent/oskplayer/proxy/VideoRequest:getPrority	()I
    //   1672: invokestatic 1425	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1675: invokevirtual 1030	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1678: pop
    //   1679: aload_3
    //   1680: instanceof 1427
    //   1683: ifeq +3157 -> 4840
    //   1686: aload_3
    //   1687: checkcast 1427	com/tencent/oskplayer/datasource/HttpDataSource$InvalidResponseCodeException
    //   1690: astore_1
    //   1691: aload 32
    //   1693: ifnull +37 -> 1730
    //   1696: aload 32
    //   1698: aload 4
    //   1700: invokevirtual 513	com/tencent/oskplayer/proxy/VideoRequest:getUuid	()Ljava/lang/String;
    //   1703: aload_2
    //   1704: aload_1
    //   1705: getfield 1429	com/tencent/oskplayer/datasource/HttpDataSource$InvalidResponseCodeException:responseCode	I
    //   1708: aload 31
    //   1710: aload_1
    //   1711: getfield 1432	com/tencent/oskplayer/datasource/HttpDataSource$InvalidResponseCodeException:headerFields	Ljava/util/Map;
    //   1714: invokestatic 491	java/lang/System:currentTimeMillis	()J
    //   1717: lload 28
    //   1719: lsub
    //   1720: l2i
    //   1721: lload 14
    //   1723: lload 16
    //   1725: invokeinterface 899 11 0
    //   1730: aload 5
    //   1732: ifnull +37 -> 1769
    //   1735: aload 5
    //   1737: aload 4
    //   1739: invokevirtual 513	com/tencent/oskplayer/proxy/VideoRequest:getUuid	()Ljava/lang/String;
    //   1742: aload_2
    //   1743: aload_1
    //   1744: getfield 1429	com/tencent/oskplayer/datasource/HttpDataSource$InvalidResponseCodeException:responseCode	I
    //   1747: aload 31
    //   1749: aload_1
    //   1750: getfield 1432	com/tencent/oskplayer/datasource/HttpDataSource$InvalidResponseCodeException:headerFields	Ljava/util/Map;
    //   1753: invokestatic 491	java/lang/System:currentTimeMillis	()J
    //   1756: lload 28
    //   1758: lsub
    //   1759: l2i
    //   1760: lload 14
    //   1762: lload 16
    //   1764: invokeinterface 899 11 0
    //   1769: iconst_4
    //   1770: aload 38
    //   1772: ldc_w 1434
    //   1775: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   1778: return
    //   1779: aload 31
    //   1781: instanceof 1436
    //   1784: ifeq +96 -> 1880
    //   1787: aload 31
    //   1789: checkcast 1436	com/tencent/oskplayer/cache/CacheDataSource
    //   1792: invokevirtual 1440	com/tencent/oskplayer/cache/CacheDataSource:getUpstreamDataSource	()Lcom/tencent/oskplayer/datasource/DataSource;
    //   1795: astore 33
    //   1797: aload 33
    //   1799: instanceof 1442
    //   1802: ifeq +50 -> 1852
    //   1805: aload 33
    //   1807: checkcast 1442	com/tencent/oskplayer/datasource/HttpDataSource
    //   1810: invokeinterface 1445 1 0
    //   1815: astore 33
    //   1817: aload 33
    //   1819: ifnull +4068 -> 5887
    //   1822: iconst_4
    //   1823: aload 38
    //   1825: new 250	java/lang/StringBuilder
    //   1828: dup
    //   1829: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   1832: ldc_w 1447
    //   1835: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1838: aload 33
    //   1840: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1843: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1846: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   1849: goto +4038 -> 5887
    //   1852: bipush 6
    //   1854: aload 38
    //   1856: new 250	java/lang/StringBuilder
    //   1859: dup
    //   1860: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   1863: ldc_w 1449
    //   1866: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1869: aload 33
    //   1871: invokevirtual 507	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1874: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1877: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   1880: goto -1057 -> 823
    //   1883: iconst_0
    //   1884: istore 30
    //   1886: goto -1019 -> 867
    //   1889: iconst_0
    //   1890: istore 6
    //   1892: goto -881 -> 1011
    //   1895: iload 6
    //   1897: istore 8
    //   1899: iload 7
    //   1901: istore 9
    //   1903: iload 6
    //   1905: istore 11
    //   1907: iload 7
    //   1909: istore 10
    //   1911: iload 7
    //   1913: istore 12
    //   1915: invokestatic 491	java/lang/System:currentTimeMillis	()J
    //   1918: lload 18
    //   1920: lsub
    //   1921: lstore 18
    //   1923: iload 6
    //   1925: istore 8
    //   1927: iload 7
    //   1929: istore 9
    //   1931: iload 6
    //   1933: istore 11
    //   1935: iload 7
    //   1937: istore 10
    //   1939: iload 7
    //   1941: istore 12
    //   1943: lload 18
    //   1945: aload_0
    //   1946: getfield 183	com/tencent/oskplayer/proxy/VideoProxy:mRecvDataTreshold	I
    //   1949: i2l
    //   1950: lcmp
    //   1951: ifle +56 -> 2007
    //   1954: iload 6
    //   1956: istore 8
    //   1958: iload 7
    //   1960: istore 9
    //   1962: iload 6
    //   1964: istore 11
    //   1966: iload 7
    //   1968: istore 10
    //   1970: iload 7
    //   1972: istore 12
    //   1974: iconst_5
    //   1975: aload 38
    //   1977: new 250	java/lang/StringBuilder
    //   1980: dup
    //   1981: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   1984: ldc_w 1451
    //   1987: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1990: lload 18
    //   1992: invokevirtual 356	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1995: ldc_w 1453
    //   1998: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2001: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2004: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2007: iload 6
    //   2009: istore 8
    //   2011: iload 7
    //   2013: istore 9
    //   2015: iload 6
    //   2017: istore 11
    //   2019: iload 7
    //   2021: istore 10
    //   2023: iload 7
    //   2025: istore 12
    //   2027: invokestatic 491	java/lang/System:currentTimeMillis	()J
    //   2030: lstore 18
    //   2032: iload 7
    //   2034: ifne +982 -> 3016
    //   2037: lload 22
    //   2039: lconst_0
    //   2040: lcmp
    //   2041: ifne +975 -> 3016
    //   2044: aconst_null
    //   2045: astore 32
    //   2047: iload 6
    //   2049: istore 8
    //   2051: iload 7
    //   2053: istore 9
    //   2055: iload 6
    //   2057: istore 11
    //   2059: iload 7
    //   2061: istore 10
    //   2063: iload 7
    //   2065: istore 12
    //   2067: aload 31
    //   2069: instanceof 1436
    //   2072: ifeq +879 -> 2951
    //   2075: iload 6
    //   2077: istore 8
    //   2079: iload 7
    //   2081: istore 9
    //   2083: iload 6
    //   2085: istore 11
    //   2087: iload 7
    //   2089: istore 10
    //   2091: iload 7
    //   2093: istore 12
    //   2095: aload 31
    //   2097: checkcast 1436	com/tencent/oskplayer/cache/CacheDataSource
    //   2100: invokevirtual 1440	com/tencent/oskplayer/cache/CacheDataSource:getUpstreamDataSource	()Lcom/tencent/oskplayer/datasource/DataSource;
    //   2103: astore 32
    //   2105: aload 32
    //   2107: ifnull +909 -> 3016
    //   2110: iload 6
    //   2112: istore 8
    //   2114: iload 7
    //   2116: istore 9
    //   2118: iload 6
    //   2120: istore 11
    //   2122: iload 7
    //   2124: istore 10
    //   2126: iload 7
    //   2128: istore 12
    //   2130: aload 32
    //   2132: instanceof 1442
    //   2135: ifeq +881 -> 3016
    //   2138: iload 6
    //   2140: istore 8
    //   2142: iload 7
    //   2144: istore 9
    //   2146: iload 6
    //   2148: istore 11
    //   2150: iload 7
    //   2152: istore 10
    //   2154: iload 7
    //   2156: istore 12
    //   2158: aload 32
    //   2160: checkcast 1442	com/tencent/oskplayer/datasource/HttpDataSource
    //   2163: invokeinterface 1457 1 0
    //   2168: astore 32
    //   2170: aload 32
    //   2172: ifnull +814 -> 2986
    //   2175: iload 6
    //   2177: istore 8
    //   2179: iload 7
    //   2181: istore 9
    //   2183: iload 6
    //   2185: istore 11
    //   2187: iload 7
    //   2189: istore 10
    //   2191: iload 7
    //   2193: istore 12
    //   2195: aload 32
    //   2197: aload 35
    //   2199: invokeinterface 1463 2 0
    //   2204: ifne +812 -> 3016
    //   2207: iload 6
    //   2209: istore 8
    //   2211: iload 7
    //   2213: istore 9
    //   2215: iload 6
    //   2217: istore 11
    //   2219: iload 7
    //   2221: istore 10
    //   2223: iload 7
    //   2225: istore 12
    //   2227: new 1465	com/tencent/oskplayer/datasource/HttpDataSource$InvalidContentException
    //   2230: dup
    //   2231: ldc_w 1467
    //   2234: aload 36
    //   2236: invokespecial 1470	com/tencent/oskplayer/datasource/HttpDataSource$InvalidContentException:<init>	(Ljava/lang/String;Lcom/tencent/oskplayer/datasource/DataSpec;)V
    //   2239: athrow
    //   2240: astore 35
    //   2242: iload 9
    //   2244: istore 7
    //   2246: iload 8
    //   2248: istore 6
    //   2250: aload 31
    //   2252: astore 32
    //   2254: aload 35
    //   2256: astore 31
    //   2258: aload 31
    //   2260: astore 36
    //   2262: aload 31
    //   2264: instanceof 1427
    //   2267: ifeq +1327 -> 3594
    //   2270: aload 31
    //   2272: astore 36
    //   2274: aload 31
    //   2276: checkcast 1427	com/tencent/oskplayer/datasource/HttpDataSource$InvalidResponseCodeException
    //   2279: astore 41
    //   2281: aload 31
    //   2283: astore 37
    //   2285: lload 14
    //   2287: lstore 18
    //   2289: lload 24
    //   2291: lstore 20
    //   2293: aload 31
    //   2295: astore 36
    //   2297: aload 4
    //   2299: invokevirtual 510	com/tencent/oskplayer/proxy/VideoRequest:getPrority	()I
    //   2302: bipush 90
    //   2304: if_icmpne +434 -> 2738
    //   2307: aload 31
    //   2309: astore 35
    //   2311: aload 31
    //   2313: astore 36
    //   2315: aload 41
    //   2317: getfield 1429	com/tencent/oskplayer/datasource/HttpDataSource$InvalidResponseCodeException:responseCode	I
    //   2320: sipush 416
    //   2323: if_icmpne +312 -> 2635
    //   2326: ldc2_w 929
    //   2329: lstore 20
    //   2331: aload 31
    //   2333: astore 36
    //   2335: aload_0
    //   2336: getfield 265	com/tencent/oskplayer/proxy/VideoProxy:videoRequestManager	Lcom/tencent/oskplayer/proxy/VideoRequestManager;
    //   2339: aload 39
    //   2341: iconst_m1
    //   2342: invokevirtual 807	com/tencent/oskplayer/proxy/VideoRequestManager:getVideoRequestByVideoKey	(Ljava/lang/String;I)Ljava/util/ArrayList;
    //   2345: invokevirtual 447	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   2348: astore 35
    //   2350: aload 33
    //   2352: astore 37
    //   2354: lload 20
    //   2356: lstore 18
    //   2358: aload 31
    //   2360: astore 36
    //   2362: aload 35
    //   2364: invokeinterface 452 1 0
    //   2369: ifeq +71 -> 2440
    //   2372: aload 31
    //   2374: astore 36
    //   2376: aload 35
    //   2378: invokeinterface 456 1 0
    //   2383: checkcast 424	com/tencent/oskplayer/proxy/VideoRequest
    //   2386: astore 37
    //   2388: aload 31
    //   2390: astore 36
    //   2392: aload 37
    //   2394: aload 4
    //   2396: invokevirtual 1471	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   2399: ifne -49 -> 2350
    //   2402: aload 31
    //   2404: astore 36
    //   2406: aload 37
    //   2408: invokevirtual 1472	com/tencent/oskplayer/proxy/VideoRequest:getTotalLength	()J
    //   2411: ldc2_w 929
    //   2414: lcmp
    //   2415: ifeq -65 -> 2350
    //   2418: aload 31
    //   2420: astore 36
    //   2422: aload 37
    //   2424: invokevirtual 1472	com/tencent/oskplayer/proxy/VideoRequest:getTotalLength	()J
    //   2427: lstore 18
    //   2429: aload 31
    //   2431: astore 36
    //   2433: aload 37
    //   2435: invokevirtual 1473	com/tencent/oskplayer/proxy/VideoRequest:getFileType	()Lcom/tencent/oskplayer/proxy/FileType;
    //   2438: astore 37
    //   2440: aload 31
    //   2442: astore 35
    //   2444: lload 18
    //   2446: ldc2_w 929
    //   2449: lcmp
    //   2450: ifeq +185 -> 2635
    //   2453: aload 31
    //   2455: astore 35
    //   2457: lload 18
    //   2459: lload 22
    //   2461: lcmp
    //   2462: ifne +173 -> 2635
    //   2465: aload 31
    //   2467: astore 35
    //   2469: lload 26
    //   2471: ldc2_w 1343
    //   2474: lcmp
    //   2475: ifne +160 -> 2635
    //   2478: aload 31
    //   2480: astore 36
    //   2482: aload 37
    //   2484: invokevirtual 1397	com/tencent/oskplayer/proxy/FileType:toString	()Ljava/lang/String;
    //   2487: astore 33
    //   2489: aload 31
    //   2491: astore 36
    //   2493: aload_2
    //   2494: invokestatic 840	com/tencent/oskplayer/util/PlayerUtils:isHLSStream	(Ljava/lang/String;)Z
    //   2497: ifne +877 -> 3374
    //   2500: iconst_1
    //   2501: istore 30
    //   2503: aload 31
    //   2505: astore 36
    //   2507: lload 22
    //   2509: lload 26
    //   2511: lload 18
    //   2513: aload 33
    //   2515: iload 30
    //   2517: invokestatic 1401	com/tencent/oskplayer/util/HttpParser:newResponseHeader	(JJJLjava/lang/String;Z)Ljava/lang/String;
    //   2520: astore 33
    //   2522: aload 31
    //   2524: astore 36
    //   2526: aload 37
    //   2528: getstatic 1342	com/tencent/oskplayer/proxy/FileType:UNKNOWN	Lcom/tencent/oskplayer/proxy/FileType;
    //   2531: invokevirtual 1402	com/tencent/oskplayer/proxy/FileType:equals	(Ljava/lang/Object;)Z
    //   2534: ifeq +17 -> 2551
    //   2537: aload 31
    //   2539: astore 36
    //   2541: bipush 6
    //   2543: aload 38
    //   2545: ldc_w 1404
    //   2548: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2551: aload 31
    //   2553: astore 36
    //   2555: iconst_4
    //   2556: aload 38
    //   2558: new 250	java/lang/StringBuilder
    //   2561: dup
    //   2562: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   2565: ldc_w 1406
    //   2568: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2571: lload 16
    //   2573: invokevirtual 356	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2576: ldc_w 1408
    //   2579: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2582: aload 33
    //   2584: aconst_null
    //   2585: invokestatic 1078	com/tencent/oskplayer/util/PlayerUtils:removeLineBreaks	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   2588: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2591: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2594: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2597: aload 31
    //   2599: astore 36
    //   2601: aload 40
    //   2603: aload 33
    //   2605: ldc_w 541
    //   2608: invokevirtual 1411	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   2611: invokevirtual 755	java/io/OutputStream:write	([B)V
    //   2614: aload 31
    //   2616: astore 36
    //   2618: aload 40
    //   2620: invokevirtual 1414	java/io/OutputStream:flush	()V
    //   2623: aload 31
    //   2625: astore 36
    //   2627: aload 40
    //   2629: invokevirtual 690	java/io/OutputStream:close	()V
    //   2632: aconst_null
    //   2633: astore 35
    //   2635: aload 35
    //   2637: astore 37
    //   2639: lload 14
    //   2641: lstore 18
    //   2643: lload 24
    //   2645: lstore 20
    //   2647: aload 35
    //   2649: ifnull +89 -> 2738
    //   2652: aload 35
    //   2654: astore 36
    //   2656: iconst_4
    //   2657: aload 38
    //   2659: new 250	java/lang/StringBuilder
    //   2662: dup
    //   2663: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   2666: ldc_w 1475
    //   2669: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2672: aload 4
    //   2674: invokevirtual 1477	com/tencent/oskplayer/proxy/VideoRequest:getSourceUrl	()Ljava/lang/String;
    //   2677: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2680: ldc_w 1479
    //   2683: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2686: aload 41
    //   2688: getfield 1432	com/tencent/oskplayer/datasource/HttpDataSource$InvalidResponseCodeException:headerFields	Ljava/util/Map;
    //   2691: invokestatic 1483	com/tencent/oskplayer/util/HttpParser:getHeaders	(Ljava/util/Map;)Ljava/lang/String;
    //   2694: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2697: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2700: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2703: aload 35
    //   2705: astore 36
    //   2707: aload 41
    //   2709: getfield 1432	com/tencent/oskplayer/datasource/HttpDataSource$InvalidResponseCodeException:headerFields	Ljava/util/Map;
    //   2712: invokestatic 1487	com/tencent/oskplayer/util/PlayerUtils:getSubErrorCode	(Ljava/util/Map;)J
    //   2715: lstore 20
    //   2717: aload 35
    //   2719: astore 36
    //   2721: aload 41
    //   2723: getfield 1429	com/tencent/oskplayer/datasource/HttpDataSource$InvalidResponseCodeException:responseCode	I
    //   2726: i2l
    //   2727: lload 20
    //   2729: invokestatic 893	com/tencent/oskplayer/util/PlayerUtils:getDownloadRetCode	(JJ)J
    //   2732: lstore 18
    //   2734: aload 35
    //   2736: astore 37
    //   2738: lload 20
    //   2740: lstore 16
    //   2742: aload 37
    //   2744: astore 31
    //   2746: lload 18
    //   2748: lstore 14
    //   2750: aload 4
    //   2752: invokevirtual 560	com/tencent/oskplayer/proxy/VideoRequest:shouldCancel	()Z
    //   2755: ifeq +8 -> 2763
    //   2758: aload 4
    //   2760: invokevirtual 684	com/tencent/oskplayer/proxy/VideoRequest:enterCancelProceedState	()V
    //   2763: iconst_4
    //   2764: aload 38
    //   2766: new 250	java/lang/StringBuilder
    //   2769: dup
    //   2770: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   2773: ldc_w 1380
    //   2776: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2779: iload 7
    //   2781: invokevirtual 430	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2784: ldc_w 1382
    //   2787: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2790: lload 22
    //   2792: invokevirtual 356	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2795: ldc_w 1384
    //   2798: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2801: lload 26
    //   2803: invokevirtual 356	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2806: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2809: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2812: aload 32
    //   2814: invokeinterface 1208 1 0
    //   2819: aload 31
    //   2821: ifnonnull +7 -> 2828
    //   2824: aload_1
    //   2825: invokevirtual 902	java/net/Socket:close	()V
    //   2828: aload 34
    //   2830: ifnull +91 -> 2921
    //   2833: aload 34
    //   2835: invokevirtual 693	java/io/File:isFile	()Z
    //   2838: ifeq +83 -> 2921
    //   2841: aload 34
    //   2843: invokevirtual 499	java/io/File:exists	()Z
    //   2846: ifeq +75 -> 2921
    //   2849: aload 34
    //   2851: invokevirtual 696	java/io/File:delete	()Z
    //   2854: istore 30
    //   2856: iconst_4
    //   2857: aload 38
    //   2859: new 250	java/lang/StringBuilder
    //   2862: dup
    //   2863: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   2866: ldc_w 698
    //   2869: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2872: aload 34
    //   2874: invokevirtual 699	java/io/File:toString	()Ljava/lang/String;
    //   2877: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2880: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2883: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2886: iload 30
    //   2888: ifne +33 -> 2921
    //   2891: iconst_5
    //   2892: aload 38
    //   2894: new 250	java/lang/StringBuilder
    //   2897: dup
    //   2898: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   2901: ldc_w 1386
    //   2904: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2907: aload 34
    //   2909: invokevirtual 699	java/io/File:toString	()Ljava/lang/String;
    //   2912: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2915: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2918: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2921: invokestatic 176	com/tencent/oskplayer/PlayerConfig:g	()Lcom/tencent/oskplayer/PlayerConfig;
    //   2924: invokevirtual 979	com/tencent/oskplayer/PlayerConfig:getOnConnectionChangeListener	()Lcom/tencent/oskplayer/proxy/VideoProxy$OnConnectionChangeListener;
    //   2927: astore_1
    //   2928: aload_1
    //   2929: ifnull +13 -> 2942
    //   2932: aload_1
    //   2933: iconst_0
    //   2934: aload 5
    //   2936: aload_3
    //   2937: invokeinterface 985 4 0
    //   2942: aload 32
    //   2944: astore_1
    //   2945: aload 31
    //   2947: astore_3
    //   2948: goto -1464 -> 1484
    //   2951: iload 6
    //   2953: istore 8
    //   2955: iload 7
    //   2957: istore 9
    //   2959: iload 6
    //   2961: istore 11
    //   2963: iload 7
    //   2965: istore 10
    //   2967: iload 7
    //   2969: istore 12
    //   2971: aload 31
    //   2973: instanceof 1442
    //   2976: ifeq -871 -> 2105
    //   2979: aload 31
    //   2981: astore 32
    //   2983: goto -878 -> 2105
    //   2986: iload 6
    //   2988: istore 8
    //   2990: iload 7
    //   2992: istore 9
    //   2994: iload 6
    //   2996: istore 11
    //   2998: iload 7
    //   3000: istore 10
    //   3002: iload 7
    //   3004: istore 12
    //   3006: bipush 6
    //   3008: aload 38
    //   3010: ldc_w 1489
    //   3013: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   3016: iload 6
    //   3018: istore 8
    //   3020: iload 7
    //   3022: istore 9
    //   3024: iload 6
    //   3026: istore 11
    //   3028: iload 7
    //   3030: istore 10
    //   3032: iload 7
    //   3034: istore 12
    //   3036: aload 40
    //   3038: aload 35
    //   3040: iconst_0
    //   3041: iload 13
    //   3043: invokevirtual 1492	java/io/OutputStream:write	([BII)V
    //   3046: iload 7
    //   3048: iload 13
    //   3050: iadd
    //   3051: istore 7
    //   3053: iload 6
    //   3055: istore 8
    //   3057: iload 7
    //   3059: istore 9
    //   3061: iload 6
    //   3063: istore 11
    //   3065: iload 7
    //   3067: istore 10
    //   3069: iload 7
    //   3071: istore 12
    //   3073: aload 4
    //   3075: iload 13
    //   3077: invokevirtual 1495	com/tencent/oskplayer/proxy/VideoRequest:updateSentBytes	(I)V
    //   3080: iload 6
    //   3082: istore 8
    //   3084: iload 7
    //   3086: istore 9
    //   3088: iload 6
    //   3090: istore 11
    //   3092: iload 7
    //   3094: istore 10
    //   3096: iload 7
    //   3098: istore 12
    //   3100: aload 4
    //   3102: iload 7
    //   3104: invokevirtual 1498	com/tencent/oskplayer/proxy/VideoRequest:setDownloadedBytes	(I)V
    //   3107: goto -2125 -> 982
    //   3110: astore 32
    //   3112: iload 11
    //   3114: istore 6
    //   3116: iload 10
    //   3118: istore 7
    //   3120: aload 34
    //   3122: astore 33
    //   3124: iconst_4
    //   3125: aload 38
    //   3127: new 250	java/lang/StringBuilder
    //   3130: dup
    //   3131: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   3134: ldc_w 1500
    //   3137: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3140: aload 32
    //   3142: invokestatic 395	com/tencent/oskplayer/util/PlayerUtils:getPrintableStackTrace	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   3145: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3148: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3151: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   3154: aload 4
    //   3156: invokevirtual 560	com/tencent/oskplayer/proxy/VideoRequest:shouldCancel	()Z
    //   3159: ifeq +8 -> 3167
    //   3162: aload 4
    //   3164: invokevirtual 684	com/tencent/oskplayer/proxy/VideoRequest:enterCancelProceedState	()V
    //   3167: iconst_4
    //   3168: aload 38
    //   3170: new 250	java/lang/StringBuilder
    //   3173: dup
    //   3174: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   3177: ldc_w 1380
    //   3180: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3183: iload 7
    //   3185: invokevirtual 430	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3188: ldc_w 1382
    //   3191: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3194: lload 22
    //   3196: invokevirtual 356	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3199: ldc_w 1384
    //   3202: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3205: lload 26
    //   3207: invokevirtual 356	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3210: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3213: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   3216: aload 31
    //   3218: invokeinterface 1208 1 0
    //   3223: aload 32
    //   3225: ifnonnull +7 -> 3232
    //   3228: aload_1
    //   3229: invokevirtual 902	java/net/Socket:close	()V
    //   3232: aload 33
    //   3234: ifnull +91 -> 3325
    //   3237: aload 33
    //   3239: invokevirtual 693	java/io/File:isFile	()Z
    //   3242: ifeq +83 -> 3325
    //   3245: aload 33
    //   3247: invokevirtual 499	java/io/File:exists	()Z
    //   3250: ifeq +75 -> 3325
    //   3253: aload 33
    //   3255: invokevirtual 696	java/io/File:delete	()Z
    //   3258: istore 30
    //   3260: iconst_4
    //   3261: aload 38
    //   3263: new 250	java/lang/StringBuilder
    //   3266: dup
    //   3267: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   3270: ldc_w 698
    //   3273: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3276: aload 33
    //   3278: invokevirtual 699	java/io/File:toString	()Ljava/lang/String;
    //   3281: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3284: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3287: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   3290: iload 30
    //   3292: ifne +33 -> 3325
    //   3295: iconst_5
    //   3296: aload 38
    //   3298: new 250	java/lang/StringBuilder
    //   3301: dup
    //   3302: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   3305: ldc_w 1386
    //   3308: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3311: aload 33
    //   3313: invokevirtual 699	java/io/File:toString	()Ljava/lang/String;
    //   3316: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3319: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3322: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   3325: invokestatic 176	com/tencent/oskplayer/PlayerConfig:g	()Lcom/tencent/oskplayer/PlayerConfig;
    //   3328: invokevirtual 979	com/tencent/oskplayer/PlayerConfig:getOnConnectionChangeListener	()Lcom/tencent/oskplayer/proxy/VideoProxy$OnConnectionChangeListener;
    //   3331: astore_1
    //   3332: aload_1
    //   3333: ifnull +13 -> 3346
    //   3336: aload_1
    //   3337: iconst_0
    //   3338: aload 5
    //   3340: aload_3
    //   3341: invokeinterface 985 4 0
    //   3346: aload 31
    //   3348: astore_1
    //   3349: ldc2_w 1005
    //   3352: lstore 16
    //   3354: aload 32
    //   3356: astore_3
    //   3357: goto -1873 -> 1484
    //   3360: astore 32
    //   3362: iconst_5
    //   3363: aload 38
    //   3365: ldc_w 1388
    //   3368: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   3371: goto -2019 -> 1352
    //   3374: iconst_0
    //   3375: istore 30
    //   3377: goto -874 -> 2503
    //   3380: astore 33
    //   3382: aload 31
    //   3384: astore 36
    //   3386: iconst_4
    //   3387: aload 38
    //   3389: ldc_w 1502
    //   3392: aload 33
    //   3394: invokestatic 1055	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   3397: aload 31
    //   3399: astore 35
    //   3401: goto -766 -> 2635
    //   3404: astore_2
    //   3405: aload 34
    //   3407: astore 33
    //   3409: aload 36
    //   3411: astore 4
    //   3413: iconst_4
    //   3414: aload 38
    //   3416: new 250	java/lang/StringBuilder
    //   3419: dup
    //   3420: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   3423: ldc_w 1380
    //   3426: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3429: iload 7
    //   3431: invokevirtual 430	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3434: ldc_w 1382
    //   3437: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3440: lload 22
    //   3442: invokevirtual 356	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3445: ldc_w 1384
    //   3448: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3451: lload 26
    //   3453: invokevirtual 356	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3456: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3459: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   3462: aload 32
    //   3464: invokeinterface 1208 1 0
    //   3469: aload 4
    //   3471: ifnonnull +7 -> 3478
    //   3474: aload_1
    //   3475: invokevirtual 902	java/net/Socket:close	()V
    //   3478: aload 33
    //   3480: ifnull +91 -> 3571
    //   3483: aload 33
    //   3485: invokevirtual 693	java/io/File:isFile	()Z
    //   3488: ifeq +83 -> 3571
    //   3491: aload 33
    //   3493: invokevirtual 499	java/io/File:exists	()Z
    //   3496: ifeq +75 -> 3571
    //   3499: aload 33
    //   3501: invokevirtual 696	java/io/File:delete	()Z
    //   3504: istore 30
    //   3506: iconst_4
    //   3507: aload 38
    //   3509: new 250	java/lang/StringBuilder
    //   3512: dup
    //   3513: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   3516: ldc_w 698
    //   3519: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3522: aload 33
    //   3524: invokevirtual 699	java/io/File:toString	()Ljava/lang/String;
    //   3527: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3530: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3533: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   3536: iload 30
    //   3538: ifne +33 -> 3571
    //   3541: iconst_5
    //   3542: aload 38
    //   3544: new 250	java/lang/StringBuilder
    //   3547: dup
    //   3548: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   3551: ldc_w 1386
    //   3554: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3557: aload 33
    //   3559: invokevirtual 699	java/io/File:toString	()Ljava/lang/String;
    //   3562: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3565: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3568: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   3571: invokestatic 176	com/tencent/oskplayer/PlayerConfig:g	()Lcom/tencent/oskplayer/PlayerConfig;
    //   3574: invokevirtual 979	com/tencent/oskplayer/PlayerConfig:getOnConnectionChangeListener	()Lcom/tencent/oskplayer/proxy/VideoProxy$OnConnectionChangeListener;
    //   3577: astore_1
    //   3578: aload_1
    //   3579: ifnull +13 -> 3592
    //   3582: aload_1
    //   3583: iconst_0
    //   3584: aload 5
    //   3586: aload_3
    //   3587: invokeinterface 985 4 0
    //   3592: aload_2
    //   3593: athrow
    //   3594: aload 31
    //   3596: astore 36
    //   3598: aload 31
    //   3600: instanceof 1504
    //   3603: ifeq +114 -> 3717
    //   3606: aload 31
    //   3608: astore 36
    //   3610: aload 31
    //   3612: checkcast 1504	com/tencent/oskplayer/datasource/HttpDataSource$InvalidContentTypeException
    //   3615: astore 33
    //   3617: aload 31
    //   3619: astore 36
    //   3621: lload 24
    //   3623: lstore 16
    //   3625: aload 4
    //   3627: invokevirtual 510	com/tencent/oskplayer/proxy/VideoRequest:getPrority	()I
    //   3630: bipush 90
    //   3632: if_icmpne +2258 -> 5890
    //   3635: aload 31
    //   3637: astore 36
    //   3639: iconst_4
    //   3640: aload 38
    //   3642: new 250	java/lang/StringBuilder
    //   3645: dup
    //   3646: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   3649: ldc_w 1475
    //   3652: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3655: aload 4
    //   3657: invokevirtual 1477	com/tencent/oskplayer/proxy/VideoRequest:getSourceUrl	()Ljava/lang/String;
    //   3660: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3663: ldc_w 1506
    //   3666: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3669: aload 33
    //   3671: getfield 1507	com/tencent/oskplayer/datasource/HttpDataSource$InvalidContentTypeException:headerFields	Ljava/util/Map;
    //   3674: invokestatic 1483	com/tencent/oskplayer/util/HttpParser:getHeaders	(Ljava/util/Map;)Ljava/lang/String;
    //   3677: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3680: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3683: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   3686: aload 31
    //   3688: astore 36
    //   3690: aload 33
    //   3692: getfield 1507	com/tencent/oskplayer/datasource/HttpDataSource$InvalidContentTypeException:headerFields	Ljava/util/Map;
    //   3695: invokestatic 1487	com/tencent/oskplayer/util/PlayerUtils:getSubErrorCode	(Ljava/util/Map;)J
    //   3698: lstore 16
    //   3700: aload 31
    //   3702: astore 36
    //   3704: ldc2_w 1508
    //   3707: lload 16
    //   3709: invokestatic 893	com/tencent/oskplayer/util/PlayerUtils:getDownloadRetCode	(JJ)J
    //   3712: lstore 14
    //   3714: goto +2176 -> 5890
    //   3717: aload 31
    //   3719: astore 36
    //   3721: aload 31
    //   3723: instanceof 1465
    //   3726: ifeq +80 -> 3806
    //   3729: aload 31
    //   3731: astore 36
    //   3733: aload 4
    //   3735: invokevirtual 510	com/tencent/oskplayer/proxy/VideoRequest:getPrority	()I
    //   3738: bipush 90
    //   3740: if_icmpne +1035 -> 4775
    //   3743: aload 31
    //   3745: astore 36
    //   3747: iconst_4
    //   3748: aload 38
    //   3750: new 250	java/lang/StringBuilder
    //   3753: dup
    //   3754: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   3757: ldc_w 1475
    //   3760: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3763: aload 4
    //   3765: invokevirtual 1477	com/tencent/oskplayer/proxy/VideoRequest:getSourceUrl	()Ljava/lang/String;
    //   3768: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3771: ldc_w 1511
    //   3774: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3777: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3780: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   3783: aload 31
    //   3785: astore 36
    //   3787: ldc2_w 1512
    //   3790: ldc2_w 1005
    //   3793: invokestatic 893	com/tencent/oskplayer/util/PlayerUtils:getDownloadRetCode	(JJ)J
    //   3796: lstore 14
    //   3798: ldc2_w 1005
    //   3801: lstore 16
    //   3803: goto -1053 -> 2750
    //   3806: aload 31
    //   3808: astore 36
    //   3810: aload 31
    //   3812: instanceof 1515
    //   3815: ifeq +80 -> 3895
    //   3818: aload 31
    //   3820: astore 36
    //   3822: aload 4
    //   3824: invokevirtual 510	com/tencent/oskplayer/proxy/VideoRequest:getPrority	()I
    //   3827: bipush 90
    //   3829: if_icmpne +946 -> 4775
    //   3832: aload 31
    //   3834: astore 36
    //   3836: iconst_4
    //   3837: aload 38
    //   3839: new 250	java/lang/StringBuilder
    //   3842: dup
    //   3843: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   3846: ldc_w 1475
    //   3849: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3852: aload 4
    //   3854: invokevirtual 1477	com/tencent/oskplayer/proxy/VideoRequest:getSourceUrl	()Ljava/lang/String;
    //   3857: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3860: ldc_w 1517
    //   3863: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3866: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3869: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   3872: aload 31
    //   3874: astore 36
    //   3876: ldc2_w 1518
    //   3879: ldc2_w 1005
    //   3882: invokestatic 893	com/tencent/oskplayer/util/PlayerUtils:getDownloadRetCode	(JJ)J
    //   3885: lstore 14
    //   3887: ldc2_w 1005
    //   3890: lstore 16
    //   3892: goto -1142 -> 2750
    //   3895: aload 31
    //   3897: astore 36
    //   3899: aload 31
    //   3901: instanceof 888
    //   3904: ifeq +57 -> 3961
    //   3907: aload 31
    //   3909: astore 36
    //   3911: aload 4
    //   3913: sipush 256
    //   3916: invokevirtual 912	com/tencent/oskplayer/proxy/VideoRequest:setStoppedReason	(I)V
    //   3919: aload 31
    //   3921: astore 36
    //   3923: iconst_5
    //   3924: aload 38
    //   3926: new 250	java/lang/StringBuilder
    //   3929: dup
    //   3930: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   3933: aload 4
    //   3935: invokevirtual 507	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3938: ldc_w 1521
    //   3941: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3944: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3947: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   3950: iconst_0
    //   3951: istore 6
    //   3953: ldc2_w 1005
    //   3956: lstore 16
    //   3958: goto -1208 -> 2750
    //   3961: aload 31
    //   3963: astore 36
    //   3965: aload 31
    //   3967: instanceof 890
    //   3970: ifeq +57 -> 4027
    //   3973: aload 31
    //   3975: astore 36
    //   3977: aload 4
    //   3979: sipush 256
    //   3982: invokevirtual 912	com/tencent/oskplayer/proxy/VideoRequest:setStoppedReason	(I)V
    //   3985: aload 31
    //   3987: astore 36
    //   3989: iconst_5
    //   3990: aload 38
    //   3992: new 250	java/lang/StringBuilder
    //   3995: dup
    //   3996: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   3999: aload 4
    //   4001: invokevirtual 507	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4004: ldc_w 1523
    //   4007: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4010: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4013: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   4016: iconst_0
    //   4017: istore 6
    //   4019: ldc2_w 1005
    //   4022: lstore 16
    //   4024: goto -1274 -> 2750
    //   4027: aload 31
    //   4029: astore 36
    //   4031: aload 31
    //   4033: instanceof 1525
    //   4036: ifeq +255 -> 4291
    //   4039: aload 31
    //   4041: astore 36
    //   4043: iconst_5
    //   4044: aload 38
    //   4046: new 250	java/lang/StringBuilder
    //   4049: dup
    //   4050: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   4053: ldc_w 1475
    //   4056: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4059: aload 4
    //   4061: invokevirtual 507	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4064: ldc_w 1527
    //   4067: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4070: aload 31
    //   4072: invokestatic 395	com/tencent/oskplayer/util/PlayerUtils:getPrintableStackTrace	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   4075: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4078: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4081: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   4084: aload 31
    //   4086: astore 36
    //   4088: aload 4
    //   4090: invokevirtual 510	com/tencent/oskplayer/proxy/VideoRequest:getPrority	()I
    //   4093: bipush 90
    //   4095: if_icmpne +680 -> 4775
    //   4098: aload 31
    //   4100: astore 36
    //   4102: aload 32
    //   4104: instanceof 1436
    //   4107: ifeq +139 -> 4246
    //   4110: aload 31
    //   4112: astore 36
    //   4114: aload 32
    //   4116: checkcast 1436	com/tencent/oskplayer/cache/CacheDataSource
    //   4119: invokevirtual 1440	com/tencent/oskplayer/cache/CacheDataSource:getUpstreamDataSource	()Lcom/tencent/oskplayer/datasource/DataSource;
    //   4122: astore 33
    //   4124: aload 31
    //   4126: astore 36
    //   4128: aload 33
    //   4130: instanceof 1181
    //   4133: ifeq +97 -> 4230
    //   4136: aload 31
    //   4138: astore 36
    //   4140: aload 33
    //   4142: checkcast 1181	com/tencent/oskplayer/datasource/DefaultHttpDataSource
    //   4145: invokevirtual 1531	com/tencent/oskplayer/datasource/DefaultHttpDataSource:getDataSpec	()Lcom/tencent/oskplayer/datasource/DataSpec;
    //   4148: astore 33
    //   4150: aload 33
    //   4152: ifnull +1726 -> 5878
    //   4155: aload 31
    //   4157: astore 36
    //   4159: aload 33
    //   4161: getfield 1535	com/tencent/oskplayer/datasource/DataSpec:uri	Landroid/net/Uri;
    //   4164: astore 33
    //   4166: aload 33
    //   4168: ifnull +1710 -> 5878
    //   4171: aload 31
    //   4173: astore 36
    //   4175: aload 33
    //   4177: invokevirtual 1538	android/net/Uri:getHost	()Ljava/lang/String;
    //   4180: ifnull +1698 -> 5878
    //   4183: aload 31
    //   4185: astore 36
    //   4187: aload 33
    //   4189: invokevirtual 1538	android/net/Uri:getHost	()Ljava/lang/String;
    //   4192: ldc_w 1540
    //   4195: invokevirtual 580	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4198: ifeq +1680 -> 5878
    //   4201: iconst_1
    //   4202: istore 8
    //   4204: goto +1689 -> 5893
    //   4207: aload 31
    //   4209: astore 36
    //   4211: iload 8
    //   4213: i2l
    //   4214: ldc2_w 1005
    //   4217: invokestatic 893	com/tencent/oskplayer/util/PlayerUtils:getDownloadRetCode	(JJ)J
    //   4220: lstore 14
    //   4222: ldc2_w 1005
    //   4225: lstore 16
    //   4227: goto -1477 -> 2750
    //   4230: aload 31
    //   4232: astore 36
    //   4234: iconst_4
    //   4235: aload 38
    //   4237: ldc_w 1542
    //   4240: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   4243: goto +1662 -> 5905
    //   4246: aload 31
    //   4248: astore 36
    //   4250: aload 32
    //   4252: instanceof 1181
    //   4255: ifeq +1650 -> 5905
    //   4258: aload 31
    //   4260: astore 36
    //   4262: aload 32
    //   4264: checkcast 1181	com/tencent/oskplayer/datasource/DefaultHttpDataSource
    //   4267: invokevirtual 1531	com/tencent/oskplayer/datasource/DefaultHttpDataSource:getDataSpec	()Lcom/tencent/oskplayer/datasource/DataSpec;
    //   4270: astore 33
    //   4272: goto -122 -> 4150
    //   4275: aload 31
    //   4277: astore 36
    //   4279: invokestatic 1545	com/tencent/oskplayer/util/PlayerUtils:isNetworkAvailable	()Z
    //   4282: ifeq +1629 -> 5911
    //   4285: iconst_5
    //   4286: istore 8
    //   4288: goto -81 -> 4207
    //   4291: aload 31
    //   4293: astore 36
    //   4295: aload 31
    //   4297: instanceof 1547
    //   4300: ifeq +89 -> 4389
    //   4303: aload 31
    //   4305: astore 36
    //   4307: iconst_5
    //   4308: aload 38
    //   4310: new 250	java/lang/StringBuilder
    //   4313: dup
    //   4314: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   4317: ldc_w 1475
    //   4320: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4323: aload 4
    //   4325: invokevirtual 507	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4328: ldc_w 1549
    //   4331: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4334: aload 31
    //   4336: invokestatic 395	com/tencent/oskplayer/util/PlayerUtils:getPrintableStackTrace	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   4339: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4342: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4345: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   4348: aload 31
    //   4350: astore 36
    //   4352: aload 4
    //   4354: invokevirtual 510	com/tencent/oskplayer/proxy/VideoRequest:getPrority	()I
    //   4357: bipush 90
    //   4359: if_icmpne +416 -> 4775
    //   4362: aload 31
    //   4364: astore 36
    //   4366: aload_0
    //   4367: aload 31
    //   4369: invokespecial 1551	com/tencent/oskplayer/proxy/VideoProxy:getFakeHttpStatus	(Ljava/lang/Throwable;)I
    //   4372: i2l
    //   4373: ldc2_w 1005
    //   4376: invokestatic 893	com/tencent/oskplayer/util/PlayerUtils:getDownloadRetCode	(JJ)J
    //   4379: lstore 14
    //   4381: ldc2_w 1005
    //   4384: lstore 16
    //   4386: goto -1636 -> 2750
    //   4389: aload 31
    //   4391: astore 36
    //   4393: aload 32
    //   4395: instanceof 1553
    //   4398: ifeq +52 -> 4450
    //   4401: aload 31
    //   4403: astore 36
    //   4405: aload 31
    //   4407: instanceof 1555
    //   4410: ifeq +40 -> 4450
    //   4413: aload 31
    //   4415: astore 36
    //   4417: aload 4
    //   4419: invokevirtual 510	com/tencent/oskplayer/proxy/VideoRequest:getPrority	()I
    //   4422: bipush 90
    //   4424: if_icmpne +351 -> 4775
    //   4427: aload 31
    //   4429: astore 36
    //   4431: ldc2_w 1556
    //   4434: ldc2_w 1005
    //   4437: invokestatic 893	com/tencent/oskplayer/util/PlayerUtils:getDownloadRetCode	(JJ)J
    //   4440: lstore 14
    //   4442: ldc2_w 1005
    //   4445: lstore 16
    //   4447: goto -1697 -> 2750
    //   4450: aload 31
    //   4452: astore 36
    //   4454: aload 31
    //   4456: instanceof 1559
    //   4459: ifeq +83 -> 4542
    //   4462: aload 31
    //   4464: astore 36
    //   4466: iconst_5
    //   4467: aload 38
    //   4469: new 250	java/lang/StringBuilder
    //   4472: dup
    //   4473: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   4476: ldc_w 1475
    //   4479: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4482: aload 4
    //   4484: invokevirtual 507	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4487: ldc_w 1561
    //   4490: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4493: aload 31
    //   4495: invokestatic 395	com/tencent/oskplayer/util/PlayerUtils:getPrintableStackTrace	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   4498: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4501: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4504: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   4507: aload 31
    //   4509: astore 36
    //   4511: aload 4
    //   4513: invokevirtual 510	com/tencent/oskplayer/proxy/VideoRequest:getPrority	()I
    //   4516: bipush 90
    //   4518: if_icmpne +257 -> 4775
    //   4521: aload 31
    //   4523: astore 36
    //   4525: lconst_1
    //   4526: ldc2_w 1005
    //   4529: invokestatic 893	com/tencent/oskplayer/util/PlayerUtils:getDownloadRetCode	(JJ)J
    //   4532: lstore 14
    //   4534: ldc2_w 1005
    //   4537: lstore 16
    //   4539: goto -1789 -> 2750
    //   4542: aload 31
    //   4544: astore 36
    //   4546: aload 31
    //   4548: instanceof 1563
    //   4551: ifeq +57 -> 4608
    //   4554: aload 31
    //   4556: astore 36
    //   4558: aload 4
    //   4560: sipush 256
    //   4563: invokevirtual 912	com/tencent/oskplayer/proxy/VideoRequest:setStoppedReason	(I)V
    //   4566: aload 31
    //   4568: astore 36
    //   4570: iconst_4
    //   4571: aload 38
    //   4573: new 250	java/lang/StringBuilder
    //   4576: dup
    //   4577: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   4580: aload 4
    //   4582: invokevirtual 507	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4585: ldc_w 914
    //   4588: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4591: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4594: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   4597: iconst_0
    //   4598: istore 6
    //   4600: ldc2_w 1005
    //   4603: lstore 16
    //   4605: goto -1855 -> 2750
    //   4608: aload 31
    //   4610: astore 36
    //   4612: aload_0
    //   4613: getfield 1565	com/tencent/oskplayer/proxy/VideoProxy:isShutdown	Z
    //   4616: ifeq +24 -> 4640
    //   4619: aload 31
    //   4621: astore 36
    //   4623: iconst_5
    //   4624: aload 38
    //   4626: ldc_w 1567
    //   4629: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   4632: ldc2_w 1005
    //   4635: lstore 16
    //   4637: goto -1887 -> 2750
    //   4640: aload 31
    //   4642: astore 36
    //   4644: aload 31
    //   4646: invokevirtual 1052	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   4649: ldc_w 1569
    //   4652: invokevirtual 1571	java/lang/String:matches	(Ljava/lang/String;)Z
    //   4655: ifeq +24 -> 4679
    //   4658: aload 31
    //   4660: astore 36
    //   4662: iconst_5
    //   4663: aload 38
    //   4665: ldc_w 1573
    //   4668: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   4671: ldc2_w 1005
    //   4674: lstore 16
    //   4676: goto -1926 -> 2750
    //   4679: aload 31
    //   4681: astore 36
    //   4683: aload 31
    //   4685: invokevirtual 1041	java/lang/Exception:toString	()Ljava/lang/String;
    //   4688: ldc_w 1575
    //   4691: invokevirtual 665	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   4694: ifeq +24 -> 4718
    //   4697: aload 31
    //   4699: astore 36
    //   4701: iconst_5
    //   4702: aload 38
    //   4704: ldc_w 1577
    //   4707: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   4710: ldc2_w 1005
    //   4713: lstore 16
    //   4715: goto -1965 -> 2750
    //   4718: aload 31
    //   4720: astore 36
    //   4722: iconst_5
    //   4723: aload 38
    //   4725: new 250	java/lang/StringBuilder
    //   4728: dup
    //   4729: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   4732: aload 4
    //   4734: invokevirtual 507	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4737: ldc_w 1579
    //   4740: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4743: aload 31
    //   4745: invokestatic 395	com/tencent/oskplayer/util/PlayerUtils:getPrintableStackTrace	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   4748: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4751: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4754: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   4757: aload 31
    //   4759: astore 36
    //   4761: aload 4
    //   4763: invokevirtual 510	com/tencent/oskplayer/proxy/VideoRequest:getPrority	()I
    //   4766: istore 8
    //   4768: iload 8
    //   4770: bipush 90
    //   4772: if_icmpne +3 -> 4775
    //   4775: ldc2_w 1005
    //   4778: lstore 16
    //   4780: goto -2030 -> 2750
    //   4783: astore 33
    //   4785: iconst_5
    //   4786: aload 38
    //   4788: ldc_w 1388
    //   4791: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   4794: goto -1975 -> 2819
    //   4797: astore 34
    //   4799: iconst_5
    //   4800: aload 38
    //   4802: ldc_w 1388
    //   4805: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   4808: goto -1585 -> 3223
    //   4811: astore 31
    //   4813: iconst_5
    //   4814: aload 38
    //   4816: ldc_w 1388
    //   4819: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   4822: goto -1353 -> 3469
    //   4825: iload 6
    //   4827: ifeq -3321 -> 1506
    //   4830: aload 4
    //   4832: bipush 16
    //   4834: invokevirtual 912	com/tencent/oskplayer/proxy/VideoRequest:setStoppedReason	(I)V
    //   4837: goto -3331 -> 1506
    //   4840: aload_3
    //   4841: instanceof 1504
    //   4844: ifeq +83 -> 4927
    //   4847: aload_3
    //   4848: checkcast 1504	com/tencent/oskplayer/datasource/HttpDataSource$InvalidContentTypeException
    //   4851: astore_1
    //   4852: aload 32
    //   4854: ifnull +34 -> 4888
    //   4857: aload 32
    //   4859: aload 4
    //   4861: invokevirtual 513	com/tencent/oskplayer/proxy/VideoRequest:getUuid	()Ljava/lang/String;
    //   4864: aload_2
    //   4865: iconst_3
    //   4866: aload 31
    //   4868: aload_1
    //   4869: getfield 1507	com/tencent/oskplayer/datasource/HttpDataSource$InvalidContentTypeException:headerFields	Ljava/util/Map;
    //   4872: invokestatic 491	java/lang/System:currentTimeMillis	()J
    //   4875: lload 28
    //   4877: lsub
    //   4878: l2i
    //   4879: lload 14
    //   4881: lload 16
    //   4883: invokeinterface 899 11 0
    //   4888: aload 5
    //   4890: ifnull -3121 -> 1769
    //   4893: aload 5
    //   4895: aload 4
    //   4897: invokevirtual 513	com/tencent/oskplayer/proxy/VideoRequest:getUuid	()Ljava/lang/String;
    //   4900: aload_2
    //   4901: iconst_3
    //   4902: aload 31
    //   4904: aload_1
    //   4905: getfield 1507	com/tencent/oskplayer/datasource/HttpDataSource$InvalidContentTypeException:headerFields	Ljava/util/Map;
    //   4908: invokestatic 491	java/lang/System:currentTimeMillis	()J
    //   4911: lload 28
    //   4913: lsub
    //   4914: l2i
    //   4915: lload 14
    //   4917: lload 16
    //   4919: invokeinterface 899 11 0
    //   4924: goto -3155 -> 1769
    //   4927: aload_3
    //   4928: instanceof 1465
    //   4931: ifeq +99 -> 5030
    //   4934: aload_0
    //   4935: getfield 212	com/tencent/oskplayer/proxy/VideoProxy:httpUrlErrorListenerMap	Ljava/util/Map;
    //   4938: aload 39
    //   4940: invokeinterface 722 2 0
    //   4945: checkcast 895	com/tencent/oskplayer/proxy/VideoProxy$HttpErrorListener
    //   4948: astore_1
    //   4949: aload_1
    //   4950: ifnull +37 -> 4987
    //   4953: aload_1
    //   4954: aload 4
    //   4956: invokevirtual 513	com/tencent/oskplayer/proxy/VideoRequest:getUuid	()Ljava/lang/String;
    //   4959: aload_2
    //   4960: bipush 10
    //   4962: aload 31
    //   4964: new 207	java/util/HashMap
    //   4967: dup
    //   4968: invokespecial 208	java/util/HashMap:<init>	()V
    //   4971: invokestatic 491	java/lang/System:currentTimeMillis	()J
    //   4974: lload 28
    //   4976: lsub
    //   4977: l2i
    //   4978: lload 14
    //   4980: lload 16
    //   4982: invokeinterface 899 11 0
    //   4987: aload 5
    //   4989: ifnull -3220 -> 1769
    //   4992: aload 5
    //   4994: aload 4
    //   4996: invokevirtual 513	com/tencent/oskplayer/proxy/VideoRequest:getUuid	()Ljava/lang/String;
    //   4999: aload_2
    //   5000: bipush 10
    //   5002: aload 31
    //   5004: new 207	java/util/HashMap
    //   5007: dup
    //   5008: invokespecial 208	java/util/HashMap:<init>	()V
    //   5011: invokestatic 491	java/lang/System:currentTimeMillis	()J
    //   5014: lload 28
    //   5016: lsub
    //   5017: l2i
    //   5018: lload 14
    //   5020: lload 16
    //   5022: invokeinterface 899 11 0
    //   5027: goto -3258 -> 1769
    //   5030: aload_3
    //   5031: instanceof 1515
    //   5034: ifeq +86 -> 5120
    //   5037: aload 32
    //   5039: ifnull +38 -> 5077
    //   5042: aload 32
    //   5044: aload 4
    //   5046: invokevirtual 513	com/tencent/oskplayer/proxy/VideoRequest:getUuid	()Ljava/lang/String;
    //   5049: aload_2
    //   5050: bipush 12
    //   5052: aload 31
    //   5054: new 207	java/util/HashMap
    //   5057: dup
    //   5058: invokespecial 208	java/util/HashMap:<init>	()V
    //   5061: invokestatic 491	java/lang/System:currentTimeMillis	()J
    //   5064: lload 28
    //   5066: lsub
    //   5067: l2i
    //   5068: lload 14
    //   5070: lload 16
    //   5072: invokeinterface 899 11 0
    //   5077: aload 5
    //   5079: ifnull -3310 -> 1769
    //   5082: aload 5
    //   5084: aload 4
    //   5086: invokevirtual 513	com/tencent/oskplayer/proxy/VideoRequest:getUuid	()Ljava/lang/String;
    //   5089: aload_2
    //   5090: bipush 12
    //   5092: aload 31
    //   5094: new 207	java/util/HashMap
    //   5097: dup
    //   5098: invokespecial 208	java/util/HashMap:<init>	()V
    //   5101: invokestatic 491	java/lang/System:currentTimeMillis	()J
    //   5104: lload 28
    //   5106: lsub
    //   5107: l2i
    //   5108: lload 14
    //   5110: lload 16
    //   5112: invokeinterface 899 11 0
    //   5117: goto -3348 -> 1769
    //   5120: aload_3
    //   5121: instanceof 888
    //   5124: ifne -3355 -> 1769
    //   5127: aload_3
    //   5128: instanceof 890
    //   5131: ifne -3362 -> 1769
    //   5134: aload_3
    //   5135: instanceof 1525
    //   5138: ifeq +122 -> 5260
    //   5141: aload 32
    //   5143: ifnull +49 -> 5192
    //   5146: aload 4
    //   5148: invokevirtual 513	com/tencent/oskplayer/proxy/VideoRequest:getUuid	()Ljava/lang/String;
    //   5151: astore_1
    //   5152: invokestatic 1545	com/tencent/oskplayer/util/PlayerUtils:isNetworkAvailable	()Z
    //   5155: ifeq +91 -> 5246
    //   5158: iconst_5
    //   5159: istore 6
    //   5161: aload 32
    //   5163: aload_1
    //   5164: aload_2
    //   5165: iload 6
    //   5167: aload 31
    //   5169: new 207	java/util/HashMap
    //   5172: dup
    //   5173: invokespecial 208	java/util/HashMap:<init>	()V
    //   5176: invokestatic 491	java/lang/System:currentTimeMillis	()J
    //   5179: lload 28
    //   5181: lsub
    //   5182: l2i
    //   5183: lload 14
    //   5185: lload 16
    //   5187: invokeinterface 899 11 0
    //   5192: aload 5
    //   5194: ifnull -3425 -> 1769
    //   5197: aload 4
    //   5199: invokevirtual 513	com/tencent/oskplayer/proxy/VideoRequest:getUuid	()Ljava/lang/String;
    //   5202: astore_1
    //   5203: invokestatic 1545	com/tencent/oskplayer/util/PlayerUtils:isNetworkAvailable	()Z
    //   5206: ifeq +47 -> 5253
    //   5209: iconst_5
    //   5210: istore 6
    //   5212: aload 5
    //   5214: aload_1
    //   5215: aload_2
    //   5216: iload 6
    //   5218: aload 31
    //   5220: new 207	java/util/HashMap
    //   5223: dup
    //   5224: invokespecial 208	java/util/HashMap:<init>	()V
    //   5227: invokestatic 491	java/lang/System:currentTimeMillis	()J
    //   5230: lload 28
    //   5232: lsub
    //   5233: l2i
    //   5234: lload 14
    //   5236: lload 16
    //   5238: invokeinterface 899 11 0
    //   5243: goto -3474 -> 1769
    //   5246: bipush 9
    //   5248: istore 6
    //   5250: goto -89 -> 5161
    //   5253: bipush 9
    //   5255: istore 6
    //   5257: goto -45 -> 5212
    //   5260: aload_3
    //   5261: instanceof 1547
    //   5264: ifeq +92 -> 5356
    //   5267: aload 32
    //   5269: ifnull +41 -> 5310
    //   5272: aload 32
    //   5274: aload 4
    //   5276: invokevirtual 513	com/tencent/oskplayer/proxy/VideoRequest:getUuid	()Ljava/lang/String;
    //   5279: aload_2
    //   5280: aload_0
    //   5281: aload_3
    //   5282: invokespecial 1551	com/tencent/oskplayer/proxy/VideoProxy:getFakeHttpStatus	(Ljava/lang/Throwable;)I
    //   5285: aload 31
    //   5287: new 207	java/util/HashMap
    //   5290: dup
    //   5291: invokespecial 208	java/util/HashMap:<init>	()V
    //   5294: invokestatic 491	java/lang/System:currentTimeMillis	()J
    //   5297: lload 28
    //   5299: lsub
    //   5300: l2i
    //   5301: lload 14
    //   5303: lload 16
    //   5305: invokeinterface 899 11 0
    //   5310: aload 5
    //   5312: ifnull -3543 -> 1769
    //   5315: aload 5
    //   5317: aload 4
    //   5319: invokevirtual 513	com/tencent/oskplayer/proxy/VideoRequest:getUuid	()Ljava/lang/String;
    //   5322: aload_2
    //   5323: aload_0
    //   5324: aload_3
    //   5325: invokespecial 1551	com/tencent/oskplayer/proxy/VideoProxy:getFakeHttpStatus	(Ljava/lang/Throwable;)I
    //   5328: aload 31
    //   5330: new 207	java/util/HashMap
    //   5333: dup
    //   5334: invokespecial 208	java/util/HashMap:<init>	()V
    //   5337: invokestatic 491	java/lang/System:currentTimeMillis	()J
    //   5340: lload 28
    //   5342: lsub
    //   5343: l2i
    //   5344: lload 14
    //   5346: lload 16
    //   5348: invokeinterface 899 11 0
    //   5353: goto -3584 -> 1769
    //   5356: aload_1
    //   5357: instanceof 1553
    //   5360: ifeq +95 -> 5455
    //   5363: aload_3
    //   5364: instanceof 1555
    //   5367: ifeq +88 -> 5455
    //   5370: aload 31
    //   5372: ldc_w 1581
    //   5375: ldc_w 1583
    //   5378: invokevirtual 1030	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   5381: pop
    //   5382: aload 32
    //   5384: ifnull +33 -> 5417
    //   5387: aload 32
    //   5389: aload 4
    //   5391: invokevirtual 513	com/tencent/oskplayer/proxy/VideoRequest:getUuid	()Ljava/lang/String;
    //   5394: aload_2
    //   5395: sipush 1404
    //   5398: aload 31
    //   5400: aconst_null
    //   5401: invokestatic 491	java/lang/System:currentTimeMillis	()J
    //   5404: lload 28
    //   5406: lsub
    //   5407: l2i
    //   5408: lload 14
    //   5410: lload 16
    //   5412: invokeinterface 899 11 0
    //   5417: aload 5
    //   5419: ifnull -3650 -> 1769
    //   5422: aload 5
    //   5424: aload 4
    //   5426: invokevirtual 513	com/tencent/oskplayer/proxy/VideoRequest:getUuid	()Ljava/lang/String;
    //   5429: aload_2
    //   5430: sipush 1404
    //   5433: aload 31
    //   5435: aconst_null
    //   5436: invokestatic 491	java/lang/System:currentTimeMillis	()J
    //   5439: lload 28
    //   5441: lsub
    //   5442: l2i
    //   5443: lload 14
    //   5445: lload 16
    //   5447: invokeinterface 899 11 0
    //   5452: goto -3683 -> 1769
    //   5455: aload_3
    //   5456: instanceof 1559
    //   5459: ifeq -3690 -> 1769
    //   5462: aload 32
    //   5464: ifnull +37 -> 5501
    //   5467: aload 32
    //   5469: aload 4
    //   5471: invokevirtual 513	com/tencent/oskplayer/proxy/VideoRequest:getUuid	()Ljava/lang/String;
    //   5474: aload_2
    //   5475: iconst_1
    //   5476: aload 31
    //   5478: new 207	java/util/HashMap
    //   5481: dup
    //   5482: invokespecial 208	java/util/HashMap:<init>	()V
    //   5485: invokestatic 491	java/lang/System:currentTimeMillis	()J
    //   5488: lload 28
    //   5490: lsub
    //   5491: l2i
    //   5492: lload 14
    //   5494: lload 16
    //   5496: invokeinterface 899 11 0
    //   5501: aload 5
    //   5503: ifnull -3734 -> 1769
    //   5506: aload 5
    //   5508: aload 4
    //   5510: invokevirtual 513	com/tencent/oskplayer/proxy/VideoRequest:getUuid	()Ljava/lang/String;
    //   5513: aload_2
    //   5514: iconst_1
    //   5515: aload 31
    //   5517: new 207	java/util/HashMap
    //   5520: dup
    //   5521: invokespecial 208	java/util/HashMap:<init>	()V
    //   5524: invokestatic 491	java/lang/System:currentTimeMillis	()J
    //   5527: lload 28
    //   5529: lsub
    //   5530: l2i
    //   5531: lload 14
    //   5533: lload 16
    //   5535: invokeinterface 899 11 0
    //   5540: goto -3771 -> 1769
    //   5543: astore_1
    //   5544: goto -4882 -> 662
    //   5547: astore_1
    //   5548: goto -4188 -> 1360
    //   5551: astore_1
    //   5552: goto -2724 -> 2828
    //   5555: astore_1
    //   5556: goto -2324 -> 3232
    //   5559: astore_1
    //   5560: goto -2082 -> 3478
    //   5563: astore_2
    //   5564: aconst_null
    //   5565: astore 33
    //   5567: aconst_null
    //   5568: astore 4
    //   5570: iconst_0
    //   5571: istore 7
    //   5573: aload 31
    //   5575: astore 32
    //   5577: goto -2164 -> 3413
    //   5580: astore_2
    //   5581: aconst_null
    //   5582: astore 4
    //   5584: iconst_0
    //   5585: istore 7
    //   5587: aload 31
    //   5589: astore 32
    //   5591: aload 34
    //   5593: astore 33
    //   5595: goto -2182 -> 3413
    //   5598: astore_2
    //   5599: aconst_null
    //   5600: astore 4
    //   5602: iconst_0
    //   5603: istore 7
    //   5605: aload 31
    //   5607: astore 32
    //   5609: aload 34
    //   5611: astore 33
    //   5613: goto -2200 -> 3413
    //   5616: astore_2
    //   5617: aconst_null
    //   5618: astore 4
    //   5620: iload 12
    //   5622: istore 7
    //   5624: aload 31
    //   5626: astore 32
    //   5628: aload 34
    //   5630: astore 33
    //   5632: goto -2219 -> 3413
    //   5635: astore_2
    //   5636: aload 31
    //   5638: astore 4
    //   5640: aload 34
    //   5642: astore 33
    //   5644: goto -2231 -> 3413
    //   5647: astore_2
    //   5648: aconst_null
    //   5649: astore 4
    //   5651: aload 31
    //   5653: astore 32
    //   5655: goto -2242 -> 3413
    //   5658: astore 32
    //   5660: aconst_null
    //   5661: astore 33
    //   5663: lconst_0
    //   5664: lstore 14
    //   5666: iconst_1
    //   5667: istore 6
    //   5669: goto -2545 -> 3124
    //   5672: astore 32
    //   5674: aconst_null
    //   5675: astore 33
    //   5677: iconst_1
    //   5678: istore 6
    //   5680: goto -2556 -> 3124
    //   5683: astore 32
    //   5685: iconst_1
    //   5686: istore 6
    //   5688: aload 34
    //   5690: astore 33
    //   5692: goto -2568 -> 3124
    //   5695: astore 32
    //   5697: iconst_1
    //   5698: istore 6
    //   5700: aload 34
    //   5702: astore 33
    //   5704: goto -2580 -> 3124
    //   5707: astore 36
    //   5709: aconst_null
    //   5710: astore 35
    //   5712: lconst_0
    //   5713: lstore 14
    //   5715: iconst_1
    //   5716: istore 6
    //   5718: aload 31
    //   5720: astore 34
    //   5722: ldc2_w 929
    //   5725: lstore 16
    //   5727: iconst_0
    //   5728: istore 7
    //   5730: aload 32
    //   5732: astore 33
    //   5734: aload 36
    //   5736: astore 31
    //   5738: aload 34
    //   5740: astore 32
    //   5742: aload 35
    //   5744: astore 34
    //   5746: goto -3488 -> 2258
    //   5749: astore 35
    //   5751: aconst_null
    //   5752: astore 34
    //   5754: iconst_1
    //   5755: istore 6
    //   5757: aload 32
    //   5759: astore 33
    //   5761: aload 31
    //   5763: astore 32
    //   5765: iconst_0
    //   5766: istore 7
    //   5768: ldc2_w 929
    //   5771: lstore 16
    //   5773: aload 35
    //   5775: astore 31
    //   5777: goto -3519 -> 2258
    //   5780: astore 35
    //   5782: iconst_1
    //   5783: istore 6
    //   5785: aload 32
    //   5787: astore 33
    //   5789: aload 31
    //   5791: astore 32
    //   5793: iconst_0
    //   5794: istore 7
    //   5796: ldc2_w 929
    //   5799: lstore 16
    //   5801: aload 35
    //   5803: astore 31
    //   5805: goto -3547 -> 2258
    //   5808: astore 35
    //   5810: iconst_1
    //   5811: istore 6
    //   5813: aload 32
    //   5815: astore 33
    //   5817: iconst_0
    //   5818: istore 7
    //   5820: aload 31
    //   5822: astore 32
    //   5824: ldc2_w 929
    //   5827: lstore 16
    //   5829: aload 35
    //   5831: astore 31
    //   5833: goto -3575 -> 2258
    //   5836: astore 35
    //   5838: iconst_1
    //   5839: istore 6
    //   5841: aload 32
    //   5843: astore 33
    //   5845: iconst_0
    //   5846: istore 7
    //   5848: aload 31
    //   5850: astore 32
    //   5852: aload 35
    //   5854: astore 31
    //   5856: goto -3598 -> 2258
    //   5859: astore 35
    //   5861: iconst_0
    //   5862: istore 7
    //   5864: aload 31
    //   5866: astore 32
    //   5868: iconst_1
    //   5869: istore 6
    //   5871: aload 35
    //   5873: astore 31
    //   5875: goto -3617 -> 2258
    //   5878: iconst_0
    //   5879: istore 8
    //   5881: goto +12 -> 5893
    //   5884: goto -5674 -> 210
    //   5887: goto -5064 -> 823
    //   5890: goto -3140 -> 2750
    //   5893: iload 8
    //   5895: ifeq -1620 -> 4275
    //   5898: bipush 13
    //   5900: istore 8
    //   5902: goto -1695 -> 4207
    //   5905: aconst_null
    //   5906: astore 33
    //   5908: goto -1758 -> 4150
    //   5911: bipush 9
    //   5913: istore 8
    //   5915: goto -1708 -> 4207
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	5918	0	this	VideoProxy
    //   0	5918	1	paramSocket	Socket
    //   0	5918	2	paramString	String
    //   0	5918	3	paramOutputStream	OutputStream
    //   0	5918	4	paramVideoRequest	VideoRequest
    //   0	5918	5	paramInputStream	InputStream
    //   977	4893	6	i	int
    //   348	5515	7	j	int
    //   984	4930	8	k	int
    //   988	2099	9	m	int
    //   996	2121	10	n	int
    //   992	2121	11	i1	int
    //   1000	4621	12	i2	int
    //   1077	1999	13	i3	int
    //   369	5345	14	l1	long
    //   365	5463	16	l2	long
    //   430	2317	18	l3	long
    //   2291	448	20	l4	long
    //   12	3429	22	l5	long
    //   480	3142	24	l6	long
    //   5	3447	26	l7	long
    //   475	5053	28	l8	long
    //   592	2945	30	bool	boolean
    //   34	4724	31	localObject1	Object
    //   4811	908	31	localIOException1	IOException
    //   5736	138	31	localObject2	Object
    //   26	2956	32	localObject3	Object
    //   3110	245	32	localException1	Exception
    //   3360	2108	32	localIOException2	IOException
    //   5575	79	32	localObject4	Object
    //   5658	1	32	localException2	Exception
    //   5672	1	32	localException3	Exception
    //   5683	1	32	localException4	Exception
    //   5695	36	32	localException5	Exception
    //   5740	127	32	localObject5	Object
    //   95	3217	33	localObject6	Object
    //   3380	13	33	localException6	Exception
    //   3407	864	33	localObject7	Object
    //   4783	1	33	localIOException3	IOException
    //   5565	342	33	localObject8	Object
    //   48	3358	34	localObject9	Object
    //   4797	904	34	localIOException4	IOException
    //   5720	33	34	localObject10	Object
    //   355	1843	35	arrayOfByte	byte[]
    //   2240	15	35	localIOException5	IOException
    //   2309	3434	35	localObject11	Object
    //   5749	25	35	localIOException6	IOException
    //   5780	22	35	localIOException7	IOException
    //   5808	22	35	localIOException8	IOException
    //   5836	17	35	localIOException9	IOException
    //   5859	13	35	localIOException10	IOException
    //   460	4300	36	localObject12	Object
    //   5707	28	36	localIOException11	IOException
    //   531	2212	37	localObject13	Object
    //   73	4742	38	str1	String
    //   19	4920	39	str2	String
    //   470	2567	40	localBufferedOutputStream	java.io.BufferedOutputStream
    //   2279	443	41	localInvalidResponseCodeException	com.tencent.oskplayer.datasource.HttpDataSource.InvalidResponseCodeException
    // Exception table:
    //   from	to	target	type
    //   647	654	791	java/io/IOException
    //   1002	1008	2240	java/io/IOException
    //   1036	1044	2240	java/io/IOException
    //   1064	1079	2240	java/io/IOException
    //   1105	1113	2240	java/io/IOException
    //   1138	1146	2240	java/io/IOException
    //   1166	1193	2240	java/io/IOException
    //   1213	1221	2240	java/io/IOException
    //   1241	1246	2240	java/io/IOException
    //   1266	1271	2240	java/io/IOException
    //   1291	1296	2240	java/io/IOException
    //   1915	1923	2240	java/io/IOException
    //   1943	1954	2240	java/io/IOException
    //   1974	2007	2240	java/io/IOException
    //   2027	2032	2240	java/io/IOException
    //   2067	2075	2240	java/io/IOException
    //   2095	2105	2240	java/io/IOException
    //   2130	2138	2240	java/io/IOException
    //   2158	2170	2240	java/io/IOException
    //   2195	2207	2240	java/io/IOException
    //   2227	2240	2240	java/io/IOException
    //   2971	2979	2240	java/io/IOException
    //   3006	3016	2240	java/io/IOException
    //   3036	3046	2240	java/io/IOException
    //   3073	3080	2240	java/io/IOException
    //   3100	3107	2240	java/io/IOException
    //   1002	1008	3110	java/lang/Exception
    //   1036	1044	3110	java/lang/Exception
    //   1064	1079	3110	java/lang/Exception
    //   1105	1113	3110	java/lang/Exception
    //   1138	1146	3110	java/lang/Exception
    //   1166	1193	3110	java/lang/Exception
    //   1213	1221	3110	java/lang/Exception
    //   1241	1246	3110	java/lang/Exception
    //   1266	1271	3110	java/lang/Exception
    //   1291	1296	3110	java/lang/Exception
    //   1915	1923	3110	java/lang/Exception
    //   1943	1954	3110	java/lang/Exception
    //   1974	2007	3110	java/lang/Exception
    //   2027	2032	3110	java/lang/Exception
    //   2067	2075	3110	java/lang/Exception
    //   2095	2105	3110	java/lang/Exception
    //   2130	2138	3110	java/lang/Exception
    //   2158	2170	3110	java/lang/Exception
    //   2195	2207	3110	java/lang/Exception
    //   2227	2240	3110	java/lang/Exception
    //   2971	2979	3110	java/lang/Exception
    //   3006	3016	3110	java/lang/Exception
    //   3036	3046	3110	java/lang/Exception
    //   3073	3080	3110	java/lang/Exception
    //   3100	3107	3110	java/lang/Exception
    //   1345	1352	3360	java/io/IOException
    //   2601	2614	3380	java/lang/Exception
    //   2618	2623	3380	java/lang/Exception
    //   2627	2632	3380	java/lang/Exception
    //   2262	2270	3404	finally
    //   2274	2281	3404	finally
    //   2297	2307	3404	finally
    //   2315	2326	3404	finally
    //   2335	2350	3404	finally
    //   2362	2372	3404	finally
    //   2376	2388	3404	finally
    //   2392	2402	3404	finally
    //   2406	2418	3404	finally
    //   2422	2429	3404	finally
    //   2433	2440	3404	finally
    //   2482	2489	3404	finally
    //   2493	2500	3404	finally
    //   2507	2522	3404	finally
    //   2526	2537	3404	finally
    //   2541	2551	3404	finally
    //   2555	2597	3404	finally
    //   2601	2614	3404	finally
    //   2618	2623	3404	finally
    //   2627	2632	3404	finally
    //   2656	2703	3404	finally
    //   2707	2717	3404	finally
    //   2721	2734	3404	finally
    //   3386	3397	3404	finally
    //   3598	3606	3404	finally
    //   3610	3617	3404	finally
    //   3625	3635	3404	finally
    //   3639	3686	3404	finally
    //   3690	3700	3404	finally
    //   3704	3714	3404	finally
    //   3721	3729	3404	finally
    //   3733	3743	3404	finally
    //   3747	3783	3404	finally
    //   3787	3798	3404	finally
    //   3810	3818	3404	finally
    //   3822	3832	3404	finally
    //   3836	3872	3404	finally
    //   3876	3887	3404	finally
    //   3899	3907	3404	finally
    //   3911	3919	3404	finally
    //   3923	3950	3404	finally
    //   3965	3973	3404	finally
    //   3977	3985	3404	finally
    //   3989	4016	3404	finally
    //   4031	4039	3404	finally
    //   4043	4084	3404	finally
    //   4088	4098	3404	finally
    //   4102	4110	3404	finally
    //   4114	4124	3404	finally
    //   4128	4136	3404	finally
    //   4140	4150	3404	finally
    //   4159	4166	3404	finally
    //   4175	4183	3404	finally
    //   4187	4201	3404	finally
    //   4211	4222	3404	finally
    //   4234	4243	3404	finally
    //   4250	4258	3404	finally
    //   4262	4272	3404	finally
    //   4279	4285	3404	finally
    //   4295	4303	3404	finally
    //   4307	4348	3404	finally
    //   4352	4362	3404	finally
    //   4366	4381	3404	finally
    //   4393	4401	3404	finally
    //   4405	4413	3404	finally
    //   4417	4427	3404	finally
    //   4431	4442	3404	finally
    //   4454	4462	3404	finally
    //   4466	4507	3404	finally
    //   4511	4521	3404	finally
    //   4525	4534	3404	finally
    //   4546	4554	3404	finally
    //   4558	4566	3404	finally
    //   4570	4597	3404	finally
    //   4612	4619	3404	finally
    //   4623	4632	3404	finally
    //   4644	4658	3404	finally
    //   4662	4671	3404	finally
    //   4683	4697	3404	finally
    //   4701	4710	3404	finally
    //   4722	4757	3404	finally
    //   4761	4768	3404	finally
    //   2812	2819	4783	java/io/IOException
    //   3216	3223	4797	java/io/IOException
    //   3462	3469	4811	java/io/IOException
    //   658	662	5543	java/io/IOException
    //   1356	1360	5547	java/io/IOException
    //   2824	2828	5551	java/io/IOException
    //   3228	3232	5555	java/io/IOException
    //   3474	3478	5559	java/io/IOException
    //   549	580	5563	finally
    //   580	587	5563	finally
    //   587	594	5580	finally
    //   804	819	5580	finally
    //   1779	1817	5580	finally
    //   1822	1849	5580	finally
    //   1852	1880	5580	finally
    //   823	832	5598	finally
    //   832	841	5598	finally
    //   841	864	5598	finally
    //   867	903	5598	finally
    //   903	976	5598	finally
    //   1002	1008	5616	finally
    //   1036	1044	5616	finally
    //   1064	1079	5616	finally
    //   1105	1113	5616	finally
    //   1138	1146	5616	finally
    //   1166	1193	5616	finally
    //   1213	1221	5616	finally
    //   1241	1246	5616	finally
    //   1266	1271	5616	finally
    //   1291	1296	5616	finally
    //   1915	1923	5616	finally
    //   1943	1954	5616	finally
    //   1974	2007	5616	finally
    //   2027	2032	5616	finally
    //   2067	2075	5616	finally
    //   2095	2105	5616	finally
    //   2130	2138	5616	finally
    //   2158	2170	5616	finally
    //   2195	2207	5616	finally
    //   2227	2240	5616	finally
    //   2971	2979	5616	finally
    //   3006	3016	5616	finally
    //   3036	3046	5616	finally
    //   3073	3080	5616	finally
    //   3100	3107	5616	finally
    //   2750	2763	5635	finally
    //   3124	3167	5647	finally
    //   549	580	5658	java/lang/Exception
    //   580	587	5672	java/lang/Exception
    //   587	594	5683	java/lang/Exception
    //   804	819	5683	java/lang/Exception
    //   1779	1817	5683	java/lang/Exception
    //   1822	1849	5683	java/lang/Exception
    //   1852	1880	5683	java/lang/Exception
    //   823	832	5695	java/lang/Exception
    //   832	841	5695	java/lang/Exception
    //   841	864	5695	java/lang/Exception
    //   867	903	5695	java/lang/Exception
    //   903	976	5695	java/lang/Exception
    //   549	580	5707	java/io/IOException
    //   580	587	5749	java/io/IOException
    //   587	594	5780	java/io/IOException
    //   804	819	5780	java/io/IOException
    //   1779	1817	5780	java/io/IOException
    //   1822	1849	5780	java/io/IOException
    //   1852	1880	5780	java/io/IOException
    //   823	832	5808	java/io/IOException
    //   832	841	5836	java/io/IOException
    //   841	864	5859	java/io/IOException
    //   867	903	5859	java/io/IOException
    //   903	976	5859	java/io/IOException
  }
  
  /* Error */
  public void addCacheReadListener(String paramString, VideoProxy.CacheReadListener paramCacheReadListener)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 238	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: istore_3
    //   7: iload_3
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_1
    //   15: invokestatic 941	com/tencent/oskplayer/util/PlayerUtils:parseVideoKey	(Ljava/lang/String;)Ljava/lang/String;
    //   18: astore_1
    //   19: aload_0
    //   20: getfield 210	com/tencent/oskplayer/proxy/VideoProxy:cacheReadListenerMap	Ljava/util/Map;
    //   23: aload_1
    //   24: aload_2
    //   25: invokeinterface 593 3 0
    //   30: pop
    //   31: goto -20 -> 11
    //   34: astore_1
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_1
    //   38: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	39	0	this	VideoProxy
    //   0	39	1	paramString	String
    //   0	39	2	paramCacheReadListener	VideoProxy.CacheReadListener
    //   6	2	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	7	34	finally
    //   14	31	34	finally
  }
  
  /* Error */
  public void addHttpErrorListener(String paramString, VideoProxy.HttpErrorListener paramHttpErrorListener)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 238	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: istore_3
    //   7: iload_3
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_1
    //   15: invokestatic 941	com/tencent/oskplayer/util/PlayerUtils:parseVideoKey	(Ljava/lang/String;)Ljava/lang/String;
    //   18: astore_1
    //   19: aload_0
    //   20: getfield 212	com/tencent/oskplayer/proxy/VideoProxy:httpUrlErrorListenerMap	Ljava/util/Map;
    //   23: aload_1
    //   24: aload_2
    //   25: invokeinterface 593 3 0
    //   30: pop
    //   31: goto -20 -> 11
    //   34: astore_1
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_1
    //   38: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	39	0	this	VideoProxy
    //   0	39	1	paramString	String
    //   0	39	2	paramHttpErrorListener	VideoProxy.HttpErrorListener
    //   6	2	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	7	34	finally
    //   14	31	34	finally
  }
  
  public void addHttpRetryLogic(String paramString, HttpRetryLogic paramHttpRetryLogic)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramString = PlayerUtils.parseVideoKey(paramString);
    if ((paramString != null) && (paramHttpRetryLogic != null))
    {
      this.httpRetryLogicMap.put(paramString, paramHttpRetryLogic);
      return;
    }
    PlayerUtils.log(3, "VideoProxy", "add http retry logic is null");
  }
  
  /* Error */
  public void addUuidErrorListener(String paramString, VideoProxy.HttpErrorListener paramHttpErrorListener)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 238	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: istore_3
    //   7: iload_3
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 214	com/tencent/oskplayer/proxy/VideoProxy:uuidErrorListenerMap	Ljava/util/Map;
    //   18: aload_1
    //   19: aload_2
    //   20: invokeinterface 593 3 0
    //   25: pop
    //   26: goto -15 -> 11
    //   29: astore_1
    //   30: aload_0
    //   31: monitorexit
    //   32: aload_1
    //   33: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	34	0	this	VideoProxy
    //   0	34	1	paramString	String
    //   0	34	2	paramHttpErrorListener	VideoProxy.HttpErrorListener
    //   6	2	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	7	29	finally
    //   14	26	29	finally
  }
  
  @Deprecated
  public void cancelAllAsync()
  {
    PlayerUtils.log(4, "VideoProxy", "cancelAllAsync is not supported any more!");
  }
  
  public void cancelAllPreloadAsync(boolean paramBoolean)
  {
    if (this.tcDataSourceUtils != null) {
      this.tcDataSourceUtils.stopAllPreload();
    }
    if (this.videoRequestManager != null) {
      this.videoRequestManager.cancelAllPreloadRequestAsync(paramBoolean);
    }
  }
  
  @Deprecated
  public void cancelAsync(String paramString)
  {
    PlayerUtils.log(4, "VideoProxy", "cancelAsync is not supported any more!");
  }
  
  @Deprecated
  public void cancelAsync(String paramString, boolean paramBoolean)
  {
    PlayerUtils.log(4, "VideoProxy", "cancelAsync is not supported any more!");
  }
  
  public void clearCache()
  {
    if (this.tcDataSourceUtils != null) {
      this.tcDataSourceUtils.cleanStorage();
    }
    if (this.cache != null) {
      this.cache.removeAll();
    }
  }
  
  public void clearCacheByUrl(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      if (this.tcDataSourceUtils != null) {
        this.tcDataSourceUtils.deleteFileOnDisk(paramString);
      }
    } while (this.cache == null);
    paramString = PlayerUtils.parseVideoKey(paramString);
    this.cache.removeByKey(paramString);
  }
  
  /* Error */
  public String downloadVideoSync(String paramString, VideoDownloadListener paramVideoDownloadListener, boolean paramBoolean, HttpHeader paramHttpHeader)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 238	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +10 -> 14
    //   7: aload_1
    //   8: invokestatic 1632	android/webkit/URLUtil:isNetworkUrl	(Ljava/lang/String;)Z
    //   11: ifne +17 -> 28
    //   14: aload_2
    //   15: ifnull +11 -> 26
    //   18: aload_2
    //   19: aload_1
    //   20: aload_1
    //   21: invokeinterface 1638 3 0
    //   26: aload_1
    //   27: areturn
    //   28: aload_1
    //   29: invokestatic 840	com/tencent/oskplayer/util/PlayerUtils:isHLSStream	(Ljava/lang/String;)Z
    //   32: ifeq +18 -> 50
    //   35: aload_2
    //   36: ifnull +12 -> 48
    //   39: aload_2
    //   40: aload_1
    //   41: bipush 251
    //   43: invokeinterface 1641 3 0
    //   48: aconst_null
    //   49: areturn
    //   50: aload_1
    //   51: invokestatic 941	com/tencent/oskplayer/util/PlayerUtils:parseVideoKey	(Ljava/lang/String;)Ljava/lang/String;
    //   54: astore 9
    //   56: aload_0
    //   57: aload_1
    //   58: iconst_1
    //   59: iconst_1
    //   60: ldc 58
    //   62: ldc 73
    //   64: bipush 90
    //   66: aload 4
    //   68: invokevirtual 654	com/tencent/oskplayer/proxy/VideoProxy:getUrl	(Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;ILcom/tencent/oskplayer/datasource/HttpHeader;)Ljava/lang/String;
    //   71: astore 4
    //   73: aload_2
    //   74: ifnull +10 -> 84
    //   77: aload_2
    //   78: aload_1
    //   79: invokeinterface 1642 2 0
    //   84: new 1181	com/tencent/oskplayer/datasource/DefaultHttpDataSource
    //   87: dup
    //   88: ldc 55
    //   90: aconst_null
    //   91: aconst_null
    //   92: invokespecial 1184	com/tencent/oskplayer/datasource/DefaultHttpDataSource:<init>	(Ljava/lang/String;Lcom/tencent/oskplayer/util/Predicate;Lcom/tencent/oskplayer/util/Fixer;)V
    //   95: astore 12
    //   97: sipush 8192
    //   100: newarray byte
    //   102: astore 10
    //   104: new 836	com/tencent/oskplayer/datasource/DataSpec
    //   107: dup
    //   108: aload 4
    //   110: invokestatic 817	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   113: lconst_0
    //   114: lconst_0
    //   115: ldc2_w 929
    //   118: aload 9
    //   120: iconst_0
    //   121: aconst_null
    //   122: invokespecial 1194	com/tencent/oskplayer/datasource/DataSpec:<init>	(Landroid/net/Uri;JJJLjava/lang/String;ILjava/lang/String;)V
    //   125: astore 11
    //   127: aload_1
    //   128: aconst_null
    //   129: invokestatic 1648	com/tencent/oskplayer/cache/FileDataSink:getLocalFile	(Ljava/lang/String;Ljava/io/File;)Ljava/lang/String;
    //   132: astore 4
    //   134: aload 4
    //   136: invokestatic 238	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   139: ifne +73 -> 212
    //   142: iload_3
    //   143: ifne +69 -> 212
    //   146: aload_2
    //   147: ifnull +12 -> 159
    //   150: aload_2
    //   151: aload_1
    //   152: aload 4
    //   154: invokeinterface 1638 3 0
    //   159: aload 12
    //   161: invokeinterface 1208 1 0
    //   166: iconst_0
    //   167: ifeq +11 -> 178
    //   170: new 1650	java/lang/NullPointerException
    //   173: dup
    //   174: invokespecial 1651	java/lang/NullPointerException:<init>	()V
    //   177: athrow
    //   178: aload_0
    //   179: getfield 228	com/tencent/oskplayer/proxy/VideoProxy:videoDownloadHashSet	Ljava/util/Set;
    //   182: aload 11
    //   184: getfield 868	com/tencent/oskplayer/datasource/DataSpec:key	Ljava/lang/String;
    //   187: invokeinterface 1654 2 0
    //   192: pop
    //   193: aload 4
    //   195: areturn
    //   196: astore_1
    //   197: aload_1
    //   198: invokevirtual 1657	java/lang/Exception:printStackTrace	()V
    //   201: goto -35 -> 166
    //   204: astore_1
    //   205: aload_1
    //   206: invokevirtual 1657	java/lang/Exception:printStackTrace	()V
    //   209: goto -31 -> 178
    //   212: aload_0
    //   213: getfield 228	com/tencent/oskplayer/proxy/VideoProxy:videoDownloadHashSet	Ljava/util/Set;
    //   216: aload 11
    //   218: getfield 868	com/tencent/oskplayer/datasource/DataSpec:key	Ljava/lang/String;
    //   221: invokeinterface 1659 2 0
    //   226: ifeq +66 -> 292
    //   229: aload_2
    //   230: ifnull +10 -> 240
    //   233: aload_2
    //   234: aload_1
    //   235: invokeinterface 1662 2 0
    //   240: aload 12
    //   242: invokeinterface 1208 1 0
    //   247: iconst_0
    //   248: ifeq +11 -> 259
    //   251: new 1650	java/lang/NullPointerException
    //   254: dup
    //   255: invokespecial 1651	java/lang/NullPointerException:<init>	()V
    //   258: athrow
    //   259: aload_0
    //   260: getfield 228	com/tencent/oskplayer/proxy/VideoProxy:videoDownloadHashSet	Ljava/util/Set;
    //   263: aload 11
    //   265: getfield 868	com/tencent/oskplayer/datasource/DataSpec:key	Ljava/lang/String;
    //   268: invokeinterface 1654 2 0
    //   273: pop
    //   274: aconst_null
    //   275: areturn
    //   276: astore_1
    //   277: aload_1
    //   278: invokevirtual 1657	java/lang/Exception:printStackTrace	()V
    //   281: goto -34 -> 247
    //   284: astore_1
    //   285: aload_1
    //   286: invokevirtual 1657	java/lang/Exception:printStackTrace	()V
    //   289: goto -30 -> 259
    //   292: aload_0
    //   293: getfield 228	com/tencent/oskplayer/proxy/VideoProxy:videoDownloadHashSet	Ljava/util/Set;
    //   296: aload 11
    //   298: getfield 868	com/tencent/oskplayer/datasource/DataSpec:key	Ljava/lang/String;
    //   301: invokeinterface 1663 2 0
    //   306: pop
    //   307: aload 12
    //   309: aload 11
    //   311: invokeinterface 535 2 0
    //   316: lstore 5
    //   318: new 1644	com/tencent/oskplayer/cache/FileDataSink
    //   321: dup
    //   322: aload_1
    //   323: aconst_null
    //   324: invokespecial 1666	com/tencent/oskplayer/cache/FileDataSink:<init>	(Ljava/lang/String;Ljava/io/File;)V
    //   327: astore 4
    //   329: aload 4
    //   331: astore 9
    //   333: aload 4
    //   335: ldc_w 1668
    //   338: invokevirtual 1669	com/tencent/oskplayer/cache/FileDataSink:setLogTag	(Ljava/lang/String;)V
    //   341: aload 4
    //   343: astore 9
    //   345: aload 4
    //   347: aload 11
    //   349: lload 5
    //   351: aload 12
    //   353: invokeinterface 1392 1 0
    //   358: invokevirtual 1672	com/tencent/oskplayer/cache/FileDataSink:open	(Lcom/tencent/oskplayer/datasource/DataSpec;JLcom/tencent/oskplayer/proxy/FileType;)Lcom/tencent/oskplayer/datasource/DataSink;
    //   361: pop
    //   362: iconst_1
    //   363: istore_3
    //   364: lconst_0
    //   365: lstore 5
    //   367: iload_3
    //   368: ifeq +83 -> 451
    //   371: aload 4
    //   373: astore 9
    //   375: aload 12
    //   377: aload 10
    //   379: iconst_0
    //   380: aload 10
    //   382: arraylength
    //   383: invokeinterface 1201 4 0
    //   388: i2l
    //   389: lstore 7
    //   391: lload 7
    //   393: ldc2_w 929
    //   396: lcmp
    //   397: ifeq +54 -> 451
    //   400: aload 4
    //   402: astore 9
    //   404: aload 4
    //   406: aload 10
    //   408: iconst_0
    //   409: lload 7
    //   411: l2i
    //   412: invokevirtual 1673	com/tencent/oskplayer/cache/FileDataSink:write	([BII)V
    //   415: lload 5
    //   417: lload 7
    //   419: ladd
    //   420: lstore 5
    //   422: aload_2
    //   423: ifnull +743 -> 1166
    //   426: aload 4
    //   428: astore 9
    //   430: aload_2
    //   431: aload_1
    //   432: aload 4
    //   434: invokevirtual 1676	com/tencent/oskplayer/cache/FileDataSink:getBytesWritten	()J
    //   437: aload 4
    //   439: invokevirtual 1679	com/tencent/oskplayer/cache/FileDataSink:getBytesTotal	()J
    //   442: invokeinterface 1683 6 0
    //   447: istore_3
    //   448: goto -81 -> 367
    //   451: aload 4
    //   453: astore 9
    //   455: aload 4
    //   457: invokevirtual 1684	com/tencent/oskplayer/cache/FileDataSink:close	()V
    //   460: iload_3
    //   461: ifeq +154 -> 615
    //   464: aload 4
    //   466: astore 9
    //   468: aload 4
    //   470: invokevirtual 1688	com/tencent/oskplayer/cache/FileDataSink:getFile	()Ljava/io/File;
    //   473: ifnull +91 -> 564
    //   476: aload_2
    //   477: ifnull +22 -> 499
    //   480: aload 4
    //   482: astore 9
    //   484: aload_2
    //   485: aload_1
    //   486: aload 4
    //   488: invokevirtual 1688	com/tencent/oskplayer/cache/FileDataSink:getFile	()Ljava/io/File;
    //   491: invokevirtual 1691	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   494: invokeinterface 1638 3 0
    //   499: aload 4
    //   501: astore 9
    //   503: aload 4
    //   505: invokevirtual 1688	com/tencent/oskplayer/cache/FileDataSink:getFile	()Ljava/io/File;
    //   508: invokevirtual 1691	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   511: astore 10
    //   513: aload 12
    //   515: invokeinterface 1208 1 0
    //   520: aload 4
    //   522: ifnull +8 -> 530
    //   525: aload 4
    //   527: invokevirtual 1684	com/tencent/oskplayer/cache/FileDataSink:close	()V
    //   530: aload_0
    //   531: getfield 228	com/tencent/oskplayer/proxy/VideoProxy:videoDownloadHashSet	Ljava/util/Set;
    //   534: aload 11
    //   536: getfield 868	com/tencent/oskplayer/datasource/DataSpec:key	Ljava/lang/String;
    //   539: invokeinterface 1654 2 0
    //   544: pop
    //   545: aload 10
    //   547: areturn
    //   548: astore_1
    //   549: aload_1
    //   550: invokevirtual 1657	java/lang/Exception:printStackTrace	()V
    //   553: goto -33 -> 520
    //   556: astore_1
    //   557: aload_1
    //   558: invokevirtual 1657	java/lang/Exception:printStackTrace	()V
    //   561: goto -31 -> 530
    //   564: aload_2
    //   565: ifnull +16 -> 581
    //   568: aload 4
    //   570: astore 9
    //   572: aload_2
    //   573: aload_1
    //   574: bipush 250
    //   576: invokeinterface 1641 3 0
    //   581: aload 12
    //   583: invokeinterface 1208 1 0
    //   588: aload 4
    //   590: ifnull +8 -> 598
    //   593: aload 4
    //   595: invokevirtual 1684	com/tencent/oskplayer/cache/FileDataSink:close	()V
    //   598: aload_0
    //   599: getfield 228	com/tencent/oskplayer/proxy/VideoProxy:videoDownloadHashSet	Ljava/util/Set;
    //   602: aload 11
    //   604: getfield 868	com/tencent/oskplayer/datasource/DataSpec:key	Ljava/lang/String;
    //   607: invokeinterface 1654 2 0
    //   612: pop
    //   613: aconst_null
    //   614: areturn
    //   615: aload 4
    //   617: astore 9
    //   619: aload_2
    //   620: aload_1
    //   621: invokeinterface 1662 2 0
    //   626: goto -45 -> 581
    //   629: astore 9
    //   631: invokestatic 1696	com/tencent/oskplayer/support/log/Logger:g	()Lcom/tencent/oskplayer/support/log/ILogger;
    //   634: ldc_w 1698
    //   637: new 250	java/lang/StringBuilder
    //   640: dup
    //   641: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   644: ldc_w 1700
    //   647: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   650: aload_1
    //   651: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   654: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   657: aload 9
    //   659: invokeinterface 1706 4 0
    //   664: pop
    //   665: aload_2
    //   666: ifnull +11 -> 677
    //   669: aload_2
    //   670: aload_1
    //   671: iconst_m1
    //   672: invokeinterface 1641 3 0
    //   677: aload 12
    //   679: invokeinterface 1208 1 0
    //   684: aload 4
    //   686: ifnull +8 -> 694
    //   689: aload 4
    //   691: invokevirtual 1684	com/tencent/oskplayer/cache/FileDataSink:close	()V
    //   694: aload_0
    //   695: getfield 228	com/tencent/oskplayer/proxy/VideoProxy:videoDownloadHashSet	Ljava/util/Set;
    //   698: aload 11
    //   700: getfield 868	com/tencent/oskplayer/datasource/DataSpec:key	Ljava/lang/String;
    //   703: invokeinterface 1654 2 0
    //   708: pop
    //   709: goto -96 -> 613
    //   712: astore_1
    //   713: aload_1
    //   714: invokevirtual 1657	java/lang/Exception:printStackTrace	()V
    //   717: goto -129 -> 588
    //   720: astore_1
    //   721: aload_1
    //   722: invokevirtual 1657	java/lang/Exception:printStackTrace	()V
    //   725: goto -127 -> 598
    //   728: astore_1
    //   729: aload_1
    //   730: invokevirtual 1657	java/lang/Exception:printStackTrace	()V
    //   733: goto -49 -> 684
    //   736: astore_1
    //   737: aload_1
    //   738: invokevirtual 1657	java/lang/Exception:printStackTrace	()V
    //   741: goto -47 -> 694
    //   744: astore 10
    //   746: aconst_null
    //   747: astore 4
    //   749: aload 4
    //   751: astore 9
    //   753: invokestatic 1696	com/tencent/oskplayer/support/log/Logger:g	()Lcom/tencent/oskplayer/support/log/ILogger;
    //   756: ldc_w 1698
    //   759: new 250	java/lang/StringBuilder
    //   762: dup
    //   763: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   766: ldc_w 1708
    //   769: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   772: aload_1
    //   773: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   776: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   779: aload 10
    //   781: invokeinterface 1706 4 0
    //   786: pop
    //   787: aload_2
    //   788: ifnull +16 -> 804
    //   791: aload 4
    //   793: astore 9
    //   795: aload_2
    //   796: aload_1
    //   797: bipush 254
    //   799: invokeinterface 1641 3 0
    //   804: aload 12
    //   806: invokeinterface 1208 1 0
    //   811: aload 4
    //   813: ifnull +8 -> 821
    //   816: aload 4
    //   818: invokevirtual 1684	com/tencent/oskplayer/cache/FileDataSink:close	()V
    //   821: aload_0
    //   822: getfield 228	com/tencent/oskplayer/proxy/VideoProxy:videoDownloadHashSet	Ljava/util/Set;
    //   825: aload 11
    //   827: getfield 868	com/tencent/oskplayer/datasource/DataSpec:key	Ljava/lang/String;
    //   830: invokeinterface 1654 2 0
    //   835: pop
    //   836: goto -223 -> 613
    //   839: astore_1
    //   840: aload_1
    //   841: invokevirtual 1657	java/lang/Exception:printStackTrace	()V
    //   844: goto -33 -> 811
    //   847: astore_1
    //   848: aload_1
    //   849: invokevirtual 1657	java/lang/Exception:printStackTrace	()V
    //   852: goto -31 -> 821
    //   855: astore 10
    //   857: aconst_null
    //   858: astore 4
    //   860: aload 4
    //   862: astore 9
    //   864: invokestatic 1696	com/tencent/oskplayer/support/log/Logger:g	()Lcom/tencent/oskplayer/support/log/ILogger;
    //   867: ldc_w 1698
    //   870: new 250	java/lang/StringBuilder
    //   873: dup
    //   874: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   877: ldc_w 1710
    //   880: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   883: aload_1
    //   884: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   887: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   890: aload 10
    //   892: invokeinterface 1706 4 0
    //   897: pop
    //   898: aload_2
    //   899: ifnull +16 -> 915
    //   902: aload 4
    //   904: astore 9
    //   906: aload_2
    //   907: aload_1
    //   908: bipush 253
    //   910: invokeinterface 1641 3 0
    //   915: aload 12
    //   917: invokeinterface 1208 1 0
    //   922: aload 4
    //   924: ifnull +8 -> 932
    //   927: aload 4
    //   929: invokevirtual 1684	com/tencent/oskplayer/cache/FileDataSink:close	()V
    //   932: aload_0
    //   933: getfield 228	com/tencent/oskplayer/proxy/VideoProxy:videoDownloadHashSet	Ljava/util/Set;
    //   936: aload 11
    //   938: getfield 868	com/tencent/oskplayer/datasource/DataSpec:key	Ljava/lang/String;
    //   941: invokeinterface 1654 2 0
    //   946: pop
    //   947: goto -334 -> 613
    //   950: astore_1
    //   951: aload_1
    //   952: invokevirtual 1657	java/lang/Exception:printStackTrace	()V
    //   955: goto -33 -> 922
    //   958: astore_1
    //   959: aload_1
    //   960: invokevirtual 1657	java/lang/Exception:printStackTrace	()V
    //   963: goto -31 -> 932
    //   966: astore 10
    //   968: aconst_null
    //   969: astore 4
    //   971: aload 4
    //   973: astore 9
    //   975: invokestatic 1696	com/tencent/oskplayer/support/log/Logger:g	()Lcom/tencent/oskplayer/support/log/ILogger;
    //   978: ldc_w 1698
    //   981: new 250	java/lang/StringBuilder
    //   984: dup
    //   985: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   988: ldc_w 1712
    //   991: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   994: aload_1
    //   995: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   998: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1001: aload 10
    //   1003: invokeinterface 1715 4 0
    //   1008: pop
    //   1009: aload_2
    //   1010: ifnull +16 -> 1026
    //   1013: aload 4
    //   1015: astore 9
    //   1017: aload_2
    //   1018: aload_1
    //   1019: bipush 252
    //   1021: invokeinterface 1641 3 0
    //   1026: aload 12
    //   1028: invokeinterface 1208 1 0
    //   1033: aload 4
    //   1035: ifnull +8 -> 1043
    //   1038: aload 4
    //   1040: invokevirtual 1684	com/tencent/oskplayer/cache/FileDataSink:close	()V
    //   1043: aload_0
    //   1044: getfield 228	com/tencent/oskplayer/proxy/VideoProxy:videoDownloadHashSet	Ljava/util/Set;
    //   1047: aload 11
    //   1049: getfield 868	com/tencent/oskplayer/datasource/DataSpec:key	Ljava/lang/String;
    //   1052: invokeinterface 1654 2 0
    //   1057: pop
    //   1058: goto -445 -> 613
    //   1061: astore_1
    //   1062: aload_1
    //   1063: invokevirtual 1657	java/lang/Exception:printStackTrace	()V
    //   1066: goto -33 -> 1033
    //   1069: astore_1
    //   1070: aload_1
    //   1071: invokevirtual 1657	java/lang/Exception:printStackTrace	()V
    //   1074: goto -31 -> 1043
    //   1077: astore_1
    //   1078: aconst_null
    //   1079: astore 9
    //   1081: aload 12
    //   1083: invokeinterface 1208 1 0
    //   1088: aload 9
    //   1090: ifnull +8 -> 1098
    //   1093: aload 9
    //   1095: invokevirtual 1684	com/tencent/oskplayer/cache/FileDataSink:close	()V
    //   1098: aload_0
    //   1099: getfield 228	com/tencent/oskplayer/proxy/VideoProxy:videoDownloadHashSet	Ljava/util/Set;
    //   1102: aload 11
    //   1104: getfield 868	com/tencent/oskplayer/datasource/DataSpec:key	Ljava/lang/String;
    //   1107: invokeinterface 1654 2 0
    //   1112: pop
    //   1113: aload_1
    //   1114: athrow
    //   1115: astore_2
    //   1116: aload_2
    //   1117: invokevirtual 1657	java/lang/Exception:printStackTrace	()V
    //   1120: goto -32 -> 1088
    //   1123: astore_2
    //   1124: aload_2
    //   1125: invokevirtual 1657	java/lang/Exception:printStackTrace	()V
    //   1128: goto -30 -> 1098
    //   1131: astore_1
    //   1132: goto -51 -> 1081
    //   1135: astore_1
    //   1136: aload 4
    //   1138: astore 9
    //   1140: goto -59 -> 1081
    //   1143: astore 10
    //   1145: goto -174 -> 971
    //   1148: astore 10
    //   1150: goto -290 -> 860
    //   1153: astore 10
    //   1155: goto -406 -> 749
    //   1158: astore 9
    //   1160: aconst_null
    //   1161: astore 4
    //   1163: goto -532 -> 631
    //   1166: goto -799 -> 367
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1169	0	this	VideoProxy
    //   0	1169	1	paramString	String
    //   0	1169	2	paramVideoDownloadListener	VideoDownloadListener
    //   0	1169	3	paramBoolean	boolean
    //   0	1169	4	paramHttpHeader	HttpHeader
    //   316	105	5	l1	long
    //   389	29	7	l2	long
    //   54	564	9	localObject1	Object
    //   629	29	9	localHttpDataSourceException1	com.tencent.oskplayer.datasource.HttpDataSource.HttpDataSourceException
    //   751	388	9	localHttpHeader	HttpHeader
    //   1158	1	9	localHttpDataSourceException2	com.tencent.oskplayer.datasource.HttpDataSource.HttpDataSourceException
    //   102	444	10	localObject2	Object
    //   744	36	10	localCacheDataSinkException1	com.tencent.oskplayer.cache.CacheDataSink.CacheDataSinkException
    //   855	36	10	localIOException1	IOException
    //   966	36	10	localException1	Exception
    //   1143	1	10	localException2	Exception
    //   1148	1	10	localIOException2	IOException
    //   1153	1	10	localCacheDataSinkException2	com.tencent.oskplayer.cache.CacheDataSink.CacheDataSinkException
    //   125	978	11	localDataSpec	DataSpec
    //   95	987	12	localDefaultHttpDataSource	DefaultHttpDataSource
    // Exception table:
    //   from	to	target	type
    //   159	166	196	java/lang/Exception
    //   170	178	204	java/lang/Exception
    //   240	247	276	java/lang/Exception
    //   251	259	284	java/lang/Exception
    //   513	520	548	java/lang/Exception
    //   525	530	556	java/lang/Exception
    //   333	341	629	com/tencent/oskplayer/datasource/HttpDataSource$HttpDataSourceException
    //   345	362	629	com/tencent/oskplayer/datasource/HttpDataSource$HttpDataSourceException
    //   375	391	629	com/tencent/oskplayer/datasource/HttpDataSource$HttpDataSourceException
    //   404	415	629	com/tencent/oskplayer/datasource/HttpDataSource$HttpDataSourceException
    //   430	448	629	com/tencent/oskplayer/datasource/HttpDataSource$HttpDataSourceException
    //   455	460	629	com/tencent/oskplayer/datasource/HttpDataSource$HttpDataSourceException
    //   468	476	629	com/tencent/oskplayer/datasource/HttpDataSource$HttpDataSourceException
    //   484	499	629	com/tencent/oskplayer/datasource/HttpDataSource$HttpDataSourceException
    //   503	513	629	com/tencent/oskplayer/datasource/HttpDataSource$HttpDataSourceException
    //   572	581	629	com/tencent/oskplayer/datasource/HttpDataSource$HttpDataSourceException
    //   619	626	629	com/tencent/oskplayer/datasource/HttpDataSource$HttpDataSourceException
    //   581	588	712	java/lang/Exception
    //   593	598	720	java/lang/Exception
    //   677	684	728	java/lang/Exception
    //   689	694	736	java/lang/Exception
    //   127	142	744	com/tencent/oskplayer/cache/CacheDataSink$CacheDataSinkException
    //   150	159	744	com/tencent/oskplayer/cache/CacheDataSink$CacheDataSinkException
    //   212	229	744	com/tencent/oskplayer/cache/CacheDataSink$CacheDataSinkException
    //   233	240	744	com/tencent/oskplayer/cache/CacheDataSink$CacheDataSinkException
    //   292	329	744	com/tencent/oskplayer/cache/CacheDataSink$CacheDataSinkException
    //   804	811	839	java/lang/Exception
    //   816	821	847	java/lang/Exception
    //   127	142	855	java/io/IOException
    //   150	159	855	java/io/IOException
    //   212	229	855	java/io/IOException
    //   233	240	855	java/io/IOException
    //   292	329	855	java/io/IOException
    //   915	922	950	java/lang/Exception
    //   927	932	958	java/lang/Exception
    //   127	142	966	java/lang/Exception
    //   150	159	966	java/lang/Exception
    //   212	229	966	java/lang/Exception
    //   233	240	966	java/lang/Exception
    //   292	329	966	java/lang/Exception
    //   1026	1033	1061	java/lang/Exception
    //   1038	1043	1069	java/lang/Exception
    //   127	142	1077	finally
    //   150	159	1077	finally
    //   212	229	1077	finally
    //   233	240	1077	finally
    //   292	329	1077	finally
    //   1081	1088	1115	java/lang/Exception
    //   1093	1098	1123	java/lang/Exception
    //   333	341	1131	finally
    //   345	362	1131	finally
    //   375	391	1131	finally
    //   404	415	1131	finally
    //   430	448	1131	finally
    //   455	460	1131	finally
    //   468	476	1131	finally
    //   484	499	1131	finally
    //   503	513	1131	finally
    //   572	581	1131	finally
    //   619	626	1131	finally
    //   753	787	1131	finally
    //   795	804	1131	finally
    //   864	898	1131	finally
    //   906	915	1131	finally
    //   975	1009	1131	finally
    //   1017	1026	1131	finally
    //   631	665	1135	finally
    //   669	677	1135	finally
    //   333	341	1143	java/lang/Exception
    //   345	362	1143	java/lang/Exception
    //   375	391	1143	java/lang/Exception
    //   404	415	1143	java/lang/Exception
    //   430	448	1143	java/lang/Exception
    //   455	460	1143	java/lang/Exception
    //   468	476	1143	java/lang/Exception
    //   484	499	1143	java/lang/Exception
    //   503	513	1143	java/lang/Exception
    //   572	581	1143	java/lang/Exception
    //   619	626	1143	java/lang/Exception
    //   333	341	1148	java/io/IOException
    //   345	362	1148	java/io/IOException
    //   375	391	1148	java/io/IOException
    //   404	415	1148	java/io/IOException
    //   430	448	1148	java/io/IOException
    //   455	460	1148	java/io/IOException
    //   468	476	1148	java/io/IOException
    //   484	499	1148	java/io/IOException
    //   503	513	1148	java/io/IOException
    //   572	581	1148	java/io/IOException
    //   619	626	1148	java/io/IOException
    //   333	341	1153	com/tencent/oskplayer/cache/CacheDataSink$CacheDataSinkException
    //   345	362	1153	com/tencent/oskplayer/cache/CacheDataSink$CacheDataSinkException
    //   375	391	1153	com/tencent/oskplayer/cache/CacheDataSink$CacheDataSinkException
    //   404	415	1153	com/tencent/oskplayer/cache/CacheDataSink$CacheDataSinkException
    //   430	448	1153	com/tencent/oskplayer/cache/CacheDataSink$CacheDataSinkException
    //   455	460	1153	com/tencent/oskplayer/cache/CacheDataSink$CacheDataSinkException
    //   468	476	1153	com/tencent/oskplayer/cache/CacheDataSink$CacheDataSinkException
    //   484	499	1153	com/tencent/oskplayer/cache/CacheDataSink$CacheDataSinkException
    //   503	513	1153	com/tencent/oskplayer/cache/CacheDataSink$CacheDataSinkException
    //   572	581	1153	com/tencent/oskplayer/cache/CacheDataSink$CacheDataSinkException
    //   619	626	1153	com/tencent/oskplayer/cache/CacheDataSink$CacheDataSinkException
    //   127	142	1158	com/tencent/oskplayer/datasource/HttpDataSource$HttpDataSourceException
    //   150	159	1158	com/tencent/oskplayer/datasource/HttpDataSource$HttpDataSourceException
    //   212	229	1158	com/tencent/oskplayer/datasource/HttpDataSource$HttpDataSourceException
    //   233	240	1158	com/tencent/oskplayer/datasource/HttpDataSource$HttpDataSourceException
    //   292	329	1158	com/tencent/oskplayer/datasource/HttpDataSource$HttpDataSourceException
  }
  
  public void downloadVideosAsync(List<String> paramList, int paramInt, boolean paramBoolean, VideoDownloadListener paramVideoDownloadListener, HttpHeader paramHttpHeader)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(new VideoProxy.6(this, (String)paramList.next(), paramVideoDownloadListener, paramBoolean, paramHttpHeader));
    }
    if (localArrayList.size() > 0) {
      ThreadUtils.executePriorityTask(localArrayList, paramInt);
    }
  }
  
  public long getCachedBytesFromEnd(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.cache == null)) {
      return 0L;
    }
    paramString = PlayerUtils.parseVideoKey(paramString);
    return this.cache.getCachedBytesFromEnd(paramString);
  }
  
  public long getCachedBytesFromStart(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.cache == null)) {
      return 0L;
    }
    paramString = PlayerUtils.parseVideoKey(paramString);
    return this.cache.getCachedBytesFromStart(paramString);
  }
  
  public double getCachedSizeRate(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((this.cache == null) || (!this.isCacheProviderLocal)) {
      return 0.0D;
    }
    paramString = PlayerUtils.parseVideoKey(paramString);
    return this.cache.getCachedSizeRate(paramString);
  }
  
  public String getLocalServerPrefix()
  {
    return "http://127.0.0.1:" + this.serverPort;
  }
  
  public long getTotalLength(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((this.cache == null) || (!this.isCacheProviderLocal)) {
      return -1L;
    }
    paramString = PlayerUtils.parseVideoKey(paramString);
    return this.cache.getTotalLength(paramString);
  }
  
  public long getUnCachedSize(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((this.cache == null) || (!this.isCacheProviderLocal)) {
      return -1L;
    }
    paramString = PlayerUtils.parseVideoKey(paramString);
    return this.cache.getRemainUnCachedBytes(paramString);
  }
  
  public String getUrl(String paramString)
  {
    return getUrl(paramString, null);
  }
  
  public String getUrl(String paramString, HttpHeader paramHttpHeader)
  {
    return getUrl(paramString, paramHttpHeader, PlayerConfig.g().getDefaultDataSourceType());
  }
  
  public String getUrl(String paramString1, HttpHeader paramHttpHeader, String paramString2)
  {
    return getUrl(paramString1, true, true, paramString2, "video/mp4", 90, paramHttpHeader);
  }
  
  public String getUrl(String paramString1, boolean paramBoolean1, boolean paramBoolean2, String paramString2, String paramString3, int paramInt, HttpHeader paramHttpHeader)
  {
    Object localObject = null;
    if ((!PlayerConfig.g().isEnableProxy()) || (this.mProxyExceptionCount > 3) || (this.executorService.isShutdown()) || (this.executorService.isTerminated())) {
      paramString2 = PlayerUtils.wrapFileScheme(paramString1);
    }
    String str1;
    boolean bool;
    String str2;
    label173:
    label229:
    do
    {
      return paramString2;
      str1 = paramString1;
      bool = paramBoolean2;
      if (!URLUtil.isHttpUrl(paramString1))
      {
        str1 = paramString1;
        bool = paramBoolean2;
        if (!URLUtil.isHttpsUrl(paramString1))
        {
          str1 = PlayerUtils.wrapFileScheme(paramString1);
          if (!PlayerUtils.isAssetsUri(str1)) {
            break label173;
          }
          bool = false;
        }
      }
      for (;;)
      {
        str2 = paramString2;
        if (PlayerUtils.isHLSStream(str1))
        {
          str2 = "1";
          paramString3 = "application/vnd.apple.mpegurl";
          bool = false;
        }
        paramString1 = "";
        try
        {
          paramString2 = URLEncoder.encode(str1, "UTF-8");
          paramString1 = paramString2;
        }
        catch (UnsupportedEncodingException paramString2)
        {
          for (;;)
          {
            PlayerUtils.log(6, "VideoProxy", "invalid url " + PlayerUtils.getPrintableStackTrace(paramString2));
          }
          paramString2 = str1;
        }
        if (!TextUtils.isEmpty(paramString1)) {
          break label229;
        }
        PlayerUtils.log(6, "VideoProxy", "url is empty " + paramString1);
        return str1;
        if (!PlayerUtils.isRawResourceUri(str1)) {
          break;
        }
        bool = false;
        str1 = paramString1;
      }
      return str1;
    } while (this.executorService.isShutdown());
    if (paramBoolean1) {}
    label866:
    for (String str3 = "u" + String.valueOf(VIDEO_UUID.getAndIncrement());; str3 = null)
    {
      paramString2 = OskFile.getFileExtension(PlayerUtils.getUrlFileName(str1));
      if (TextUtils.isEmpty(paramString2)) {}
      for (paramString2 = "";; paramString2 = "media." + paramString2)
      {
        paramString2 = getLocalServerPrefix() + "/" + paramString2 + "?" + "v" + "=" + paramString1 + "&" + "mType" + "=" + "qzone_video_player";
        paramString1 = paramString2;
        if (bool) {
          paramString1 = paramString2 + "&enableCache=1";
        }
        if ((paramInt != 90) && (paramInt != 10))
        {
          paramString2 = paramString1;
          if (paramInt != -1) {}
        }
        else
        {
          paramString2 = paramString1 + "&p=" + paramInt;
        }
        if ((!TextUtils.equals(str2, "1")) && (!TextUtils.equals(str2, "0")))
        {
          paramString1 = paramString2;
          if (!TextUtils.equals(str2, "-1")) {}
        }
        else
        {
          paramString1 = paramString2 + "&dataSourceType=" + str2;
        }
        paramString2 = paramString1;
        if (!TextUtils.isEmpty(paramString3)) {}
        try
        {
          paramString2 = URLEncoder.encode(paramString3, "UTF-8");
          paramString3 = paramString2;
        }
        catch (UnsupportedEncodingException paramString2)
        {
          for (;;)
          {
            PlayerUtils.log(6, "VideoProxy", "unable to encode contentType " + paramString3);
            paramString3 = localObject;
          }
        }
        paramString2 = paramString1;
        if (!TextUtils.isEmpty(paramString3)) {
          paramString2 = paramString1 + "&preferredContentType=" + paramString3;
        }
        paramString1 = paramString2;
        if (str3 != null) {
          paramString1 = paramString2 + "&uuid=" + str3;
        }
        if ((!this.isSecretEnable) || (!PlayerConfig.g().isEnableProxySecret())) {
          break label866;
        }
        try
        {
          paramString2 = paramString1 + "&t=" + SecretUtils.encode("des", SecretUtils.getRandomNum(), PlayerUtils.parseVideoKey(str1));
          paramString1 = paramString2;
          paramString2 = paramString1;
          if (paramHttpHeader != null)
          {
            this.mExtraHeaderCollection.add(paramHttpHeader);
            if (this.mExtraHeaderCollection.size() > 100) {
              this.mExtraHeaderCollection.remove(this.mExtraHeaderCollection.iterator().next());
            }
            paramInt = paramHttpHeader.getId();
            paramString2 = paramString1 + "&eh=" + paramInt;
          }
          return paramString2;
        }
        catch (Exception paramString2)
        {
          PlayerUtils.log(6, "VideoProxy", "encode failed = " + PlayerUtils.getPrintableStackTrace(paramString2));
          this.isSecretEnable = false;
        }
      }
    }
  }
  
  public List<String> getUrl(List<String> paramList)
  {
    return getUrl(paramList, null);
  }
  
  public List<String> getUrl(List<String> paramList, List<HttpHeader> paramList1)
  {
    String str2 = "u" + String.valueOf(VIDEO_UUID.getAndIncrement());
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      Iterator localIterator = paramList.iterator();
      int i = 0;
      if (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        String str3 = PlayerConfig.g().getDefaultDataSourceType();
        if (paramList1 != null) {}
        for (paramList = (HttpHeader)paramList1.get(i);; paramList = null)
        {
          str1 = getUrl(str1, false, true, str3, "video/mp4", 90, paramList);
          paramList = str1;
          if (URLUtil.isHttpUrl(str1))
          {
            paramList = str1;
            if (!TextUtils.isEmpty(str1))
            {
              paramList = str1;
              if (str1.startsWith("http://127.0.0.1")) {
                paramList = str1 + "&uuid=" + str2;
              }
            }
          }
          localArrayList.add(paramList);
          i += 1;
          break;
        }
      }
    }
    return localArrayList;
  }
  
  public VideoRequestManager getVideoRequestManager()
  {
    return this.videoRequestManager;
  }
  
  public boolean isCached(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return false;
      if ((this.tcDataSourceUtils != null) && (!this.isCacheProviderLocal)) {
        return this.tcDataSourceUtils.isClipCompleteOnDisk(paramString, 1);
      }
    } while ((this.cache == null) || (!this.isCacheProviderLocal));
    paramString = PlayerUtils.parseVideoKey(paramString);
    return this.cache.isCached(paramString);
  }
  
  public Future<?> preloadAsync(String paramString, long paramLong1, long paramLong2, int paramInt, boolean paramBoolean1, boolean paramBoolean2, HttpHeader paramHttpHeader, DownloadListener paramDownloadListener)
  {
    return ThreadUtils.submitTask(new VideoProxy.5(this, paramString, paramLong1, paramLong2, paramInt, paramBoolean1, paramBoolean2, paramHttpHeader, paramDownloadListener), "preloadAsync");
  }
  
  void preloadMedia(List<String> paramList, int paramInt, long paramLong, PreloadListener paramPreloadListener)
  {
    preloadMedia(paramList, paramInt, paramLong, paramPreloadListener, null);
  }
  
  void preloadMedia(List<String> paramList, int paramInt, long paramLong, PreloadListener paramPreloadListener, HttpHeader paramHttpHeader)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      if ((!TextUtils.isEmpty(str)) && (URLUtil.isNetworkUrl(str)))
      {
        VideoProxy.PreloadInfo localPreloadInfo = new VideoProxy.PreloadInfo();
        localPreloadInfo.originalUrl = str;
        localPreloadInfo.localUrl = getUrl(str, true, true, "-1", "video/mp4", 10, paramHttpHeader);
        localArrayList.add(localPreloadInfo);
        PlayerUtils.log(4, "preloadMedia", "preload wz localUrl " + localPreloadInfo.localUrl);
      }
    }
    preloadMediasAsync(localArrayList, paramInt, paramLong, paramPreloadListener, "preloadMedia");
  }
  
  /* Error */
  public boolean preloadSync(String paramString, long paramLong1, long paramLong2, int paramInt, boolean paramBoolean1, boolean paramBoolean2, HttpHeader paramHttpHeader, DownloadListener paramDownloadListener)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 238	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +10 -> 14
    //   7: aload_1
    //   8: invokestatic 1632	android/webkit/URLUtil:isNetworkUrl	(Ljava/lang/String;)Z
    //   11: ifne +5 -> 16
    //   14: iconst_0
    //   15: ireturn
    //   16: aload_0
    //   17: getfield 1294	com/tencent/oskplayer/proxy/VideoProxy:tcDataSourceUtils	Lcom/tencent/oskplayer/proxy/ITcDataSourceUtils;
    //   20: ifnull +29 -> 49
    //   23: aload_0
    //   24: getfield 181	com/tencent/oskplayer/proxy/VideoProxy:isCacheProviderLocal	Z
    //   27: ifne +22 -> 49
    //   30: aload_0
    //   31: getfield 1294	com/tencent/oskplayer/proxy/VideoProxy:tcDataSourceUtils	Lcom/tencent/oskplayer/proxy/ITcDataSourceUtils;
    //   34: aload_1
    //   35: lconst_0
    //   36: iconst_0
    //   37: iconst_1
    //   38: bipush 15
    //   40: ldc_w 1772
    //   43: invokeinterface 1868 8 0
    //   48: ireturn
    //   49: invokestatic 176	com/tencent/oskplayer/PlayerConfig:g	()Lcom/tencent/oskplayer/PlayerConfig;
    //   52: invokevirtual 709	com/tencent/oskplayer/PlayerConfig:isEnableProxy	()Z
    //   55: ifne +14 -> 69
    //   58: iconst_4
    //   59: ldc 49
    //   61: ldc_w 1870
    //   64: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   67: iconst_0
    //   68: ireturn
    //   69: aload_1
    //   70: invokestatic 941	com/tencent/oskplayer/util/PlayerUtils:parseVideoKey	(Ljava/lang/String;)Ljava/lang/String;
    //   73: astore 25
    //   75: aload_0
    //   76: aload_1
    //   77: iconst_1
    //   78: iconst_1
    //   79: ldc 81
    //   81: ldc 73
    //   83: bipush 10
    //   85: aload 9
    //   87: invokevirtual 654	com/tencent/oskplayer/proxy/VideoProxy:getUrl	(Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;ILcom/tencent/oskplayer/datasource/HttpHeader;)Ljava/lang/String;
    //   90: astore 26
    //   92: aload 26
    //   94: invokestatic 1873	com/tencent/oskplayer/util/PlayerUtils:getVideoUuidFromVideoUrl	(Ljava/lang/String;)Ljava/lang/String;
    //   97: astore 24
    //   99: aload 10
    //   101: ifnull +11 -> 112
    //   104: aload 10
    //   106: aload_1
    //   107: invokeinterface 1876 2 0
    //   112: iload 7
    //   114: ifeq +2491 -> 2605
    //   117: lconst_0
    //   118: lstore 22
    //   120: aload 26
    //   122: ifnull +2483 -> 2605
    //   125: new 1181	com/tencent/oskplayer/datasource/DefaultHttpDataSource
    //   128: dup
    //   129: ldc 55
    //   131: aconst_null
    //   132: aconst_null
    //   133: invokespecial 1184	com/tencent/oskplayer/datasource/DefaultHttpDataSource:<init>	(Ljava/lang/String;Lcom/tencent/oskplayer/util/Predicate;Lcom/tencent/oskplayer/util/Fixer;)V
    //   136: astore 27
    //   138: sipush 512
    //   141: newarray byte
    //   143: astore 9
    //   145: lload 22
    //   147: lstore 16
    //   149: lload_2
    //   150: lstore 14
    //   152: aload 27
    //   154: new 836	com/tencent/oskplayer/datasource/DataSpec
    //   157: dup
    //   158: aload 26
    //   160: invokestatic 817	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   163: lconst_0
    //   164: lconst_0
    //   165: ldc2_w 929
    //   168: aconst_null
    //   169: iconst_0
    //   170: aconst_null
    //   171: invokespecial 1194	com/tencent/oskplayer/datasource/DataSpec:<init>	(Landroid/net/Uri;JJJLjava/lang/String;ILjava/lang/String;)V
    //   174: invokeinterface 535 2 0
    //   179: pop2
    //   180: lload 22
    //   182: lstore 16
    //   184: lload_2
    //   185: lstore 14
    //   187: aload 27
    //   189: invokeinterface 1197 1 0
    //   194: lstore 12
    //   196: lload 4
    //   198: ldc2_w 1877
    //   201: lcmp
    //   202: ifle +246 -> 448
    //   205: lload 22
    //   207: lstore 16
    //   209: lload_2
    //   210: lstore 14
    //   212: lload_2
    //   213: lstore 20
    //   215: lload_2
    //   216: lstore 18
    //   218: ldc2_w 1879
    //   221: lload 12
    //   223: lmul
    //   224: lload 4
    //   226: ldiv
    //   227: l2i
    //   228: sipush 1000
    //   231: imul
    //   232: istore 11
    //   234: lload 22
    //   236: lstore 16
    //   238: lload_2
    //   239: lstore 14
    //   241: lload_2
    //   242: lstore 20
    //   244: lload_2
    //   245: lstore 18
    //   247: iload 6
    //   249: sipush 1000
    //   252: idiv
    //   253: iload 11
    //   255: imul
    //   256: bipush 8
    //   258: idiv
    //   259: istore 6
    //   261: lload 22
    //   263: lstore 16
    //   265: lload_2
    //   266: lstore 14
    //   268: lload_2
    //   269: lstore 20
    //   271: lload_2
    //   272: lstore 18
    //   274: ldc2_w 1881
    //   277: lload 4
    //   279: ldc2_w 1883
    //   282: ldiv
    //   283: lmul
    //   284: lstore 4
    //   286: lload 22
    //   288: lstore 16
    //   290: lload_2
    //   291: lstore 14
    //   293: lload_2
    //   294: lstore 20
    //   296: lload_2
    //   297: lstore 18
    //   299: lload_2
    //   300: iload 6
    //   302: i2l
    //   303: lload 4
    //   305: ladd
    //   306: invokestatic 351	java/lang/Math:min	(JJ)J
    //   309: lstore_2
    //   310: lload 22
    //   312: lstore 16
    //   314: lload_2
    //   315: lstore 14
    //   317: lload_2
    //   318: lstore 20
    //   320: lload_2
    //   321: lstore 18
    //   323: iconst_4
    //   324: ldc 49
    //   326: new 250	java/lang/StringBuilder
    //   329: dup
    //   330: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   333: ldc_w 1886
    //   336: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: iload 11
    //   341: invokevirtual 430	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   344: ldc_w 950
    //   347: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: aload_1
    //   351: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   354: ldc_w 1888
    //   357: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: lload 4
    //   362: invokevirtual 356	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   365: ldc_w 1890
    //   368: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: iload 6
    //   373: invokevirtual 430	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   376: ldc_w 1892
    //   379: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   382: lload_2
    //   383: invokevirtual 356	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   386: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   389: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   392: lconst_0
    //   393: lstore 4
    //   395: lload 4
    //   397: lload_2
    //   398: lcmp
    //   399: ifge +104 -> 503
    //   402: lload 4
    //   404: lstore 16
    //   406: lload_2
    //   407: lstore 14
    //   409: aload 27
    //   411: aload 9
    //   413: iconst_0
    //   414: aload 9
    //   416: arraylength
    //   417: invokeinterface 1201 4 0
    //   422: istore 6
    //   424: iload 6
    //   426: i2l
    //   427: lstore 14
    //   429: lload 14
    //   431: ldc2_w 929
    //   434: lcmp
    //   435: ifeq +68 -> 503
    //   438: lload 4
    //   440: lload 14
    //   442: ladd
    //   443: lstore 4
    //   445: goto -50 -> 395
    //   448: lload 22
    //   450: lstore 16
    //   452: lload_2
    //   453: lstore 14
    //   455: lload_2
    //   456: lstore 20
    //   458: lload_2
    //   459: lstore 18
    //   461: iconst_4
    //   462: ldc 49
    //   464: new 250	java/lang/StringBuilder
    //   467: dup
    //   468: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   471: ldc_w 1894
    //   474: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   477: aload_1
    //   478: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   481: ldc_w 1896
    //   484: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   487: lload_2
    //   488: invokevirtual 356	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   491: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   494: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   497: lconst_0
    //   498: lstore 4
    //   500: goto -105 -> 395
    //   503: iconst_3
    //   504: ldc 49
    //   506: new 250	java/lang/StringBuilder
    //   509: dup
    //   510: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   513: ldc_w 1898
    //   516: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   519: lload 4
    //   521: invokevirtual 356	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   524: ldc_w 1900
    //   527: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   530: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   533: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   536: aload 27
    //   538: invokeinterface 1208 1 0
    //   543: iconst_4
    //   544: ldc 49
    //   546: ldc_w 1902
    //   549: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   552: iconst_4
    //   553: ldc 49
    //   555: new 250	java/lang/StringBuilder
    //   558: dup
    //   559: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   562: ldc_w 1904
    //   565: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   568: aload_1
    //   569: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   572: ldc_w 1896
    //   575: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   578: lload_2
    //   579: invokevirtual 356	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   582: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   585: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   588: lload 12
    //   590: lstore 4
    //   592: iload 8
    //   594: ifeq +1291 -> 1885
    //   597: invokestatic 491	java/lang/System:currentTimeMillis	()J
    //   600: lstore 16
    //   602: lconst_0
    //   603: lstore 12
    //   605: aload 26
    //   607: ifnull +1278 -> 1885
    //   610: new 1181	com/tencent/oskplayer/datasource/DefaultHttpDataSource
    //   613: dup
    //   614: ldc 55
    //   616: aconst_null
    //   617: aconst_null
    //   618: invokespecial 1184	com/tencent/oskplayer/datasource/DefaultHttpDataSource:<init>	(Ljava/lang/String;Lcom/tencent/oskplayer/util/Predicate;Lcom/tencent/oskplayer/util/Fixer;)V
    //   621: astore 27
    //   623: sipush 512
    //   626: newarray byte
    //   628: astore 9
    //   630: lload 4
    //   632: lstore 14
    //   634: lload 4
    //   636: ldc2_w 929
    //   639: lcmp
    //   640: ifne +59 -> 699
    //   643: lload 12
    //   645: lstore 4
    //   647: aload 27
    //   649: new 836	com/tencent/oskplayer/datasource/DataSpec
    //   652: dup
    //   653: aload 26
    //   655: invokestatic 817	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   658: lconst_0
    //   659: lconst_0
    //   660: ldc2_w 929
    //   663: aconst_null
    //   664: iconst_0
    //   665: aconst_null
    //   666: invokespecial 1194	com/tencent/oskplayer/datasource/DataSpec:<init>	(Landroid/net/Uri;JJJLjava/lang/String;ILjava/lang/String;)V
    //   669: invokeinterface 535 2 0
    //   674: pop2
    //   675: lload 12
    //   677: lstore 4
    //   679: aload 27
    //   681: invokeinterface 1197 1 0
    //   686: lstore 14
    //   688: lload 12
    //   690: lstore 4
    //   692: aload 27
    //   694: invokeinterface 1208 1 0
    //   699: ldc_w 1905
    //   702: lload 14
    //   704: l2f
    //   705: fmul
    //   706: f2l
    //   707: lstore 18
    //   709: lload 14
    //   711: lload_2
    //   712: lsub
    //   713: lstore_2
    //   714: lload 12
    //   716: lstore 4
    //   718: lload_2
    //   719: lload 18
    //   721: invokestatic 1908	java/lang/Math:max	(JJ)J
    //   724: lstore 14
    //   726: lload 12
    //   728: lstore 4
    //   730: iconst_4
    //   731: ldc 49
    //   733: new 250	java/lang/StringBuilder
    //   736: dup
    //   737: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   740: ldc_w 1910
    //   743: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   746: lload 18
    //   748: invokevirtual 356	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   751: ldc_w 950
    //   754: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   757: aload_1
    //   758: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   761: ldc_w 1912
    //   764: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   767: lload_2
    //   768: invokevirtual 356	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   771: ldc_w 1914
    //   774: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   777: lload 14
    //   779: invokevirtual 356	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   782: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   785: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   788: lload 12
    //   790: lstore 4
    //   792: aload 27
    //   794: new 836	com/tencent/oskplayer/datasource/DataSpec
    //   797: dup
    //   798: aload 26
    //   800: invokestatic 817	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   803: lload 14
    //   805: lload 14
    //   807: ldc2_w 929
    //   810: aconst_null
    //   811: iconst_0
    //   812: aconst_null
    //   813: invokespecial 1194	com/tencent/oskplayer/datasource/DataSpec:<init>	(Landroid/net/Uri;JJJLjava/lang/String;ILjava/lang/String;)V
    //   816: invokeinterface 535 2 0
    //   821: pop2
    //   822: lconst_0
    //   823: lstore_2
    //   824: lload_2
    //   825: lstore 4
    //   827: aload 27
    //   829: aload 9
    //   831: iconst_0
    //   832: aload 9
    //   834: arraylength
    //   835: invokeinterface 1201 4 0
    //   840: istore 6
    //   842: iload 6
    //   844: i2l
    //   845: lstore 4
    //   847: lload 4
    //   849: ldc2_w 929
    //   852: lcmp
    //   853: ifeq +906 -> 1759
    //   856: lload_2
    //   857: lload 4
    //   859: ladd
    //   860: lstore_2
    //   861: goto -37 -> 824
    //   864: astore 9
    //   866: iconst_4
    //   867: ldc 49
    //   869: new 250	java/lang/StringBuilder
    //   872: dup
    //   873: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   876: ldc_w 1916
    //   879: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   882: aload 9
    //   884: invokevirtual 507	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   887: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   890: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   893: aload 10
    //   895: ifnull +13 -> 908
    //   898: aload 10
    //   900: aload_1
    //   901: bipush 151
    //   903: invokeinterface 1917 3 0
    //   908: lload 12
    //   910: lstore 4
    //   912: goto -320 -> 592
    //   915: astore 9
    //   917: lconst_0
    //   918: lstore 4
    //   920: ldc2_w 929
    //   923: lstore 12
    //   925: lload 4
    //   927: lstore 16
    //   929: lload_2
    //   930: lstore 14
    //   932: aload 9
    //   934: invokevirtual 1918	com/tencent/oskplayer/datasource/HttpDataSource$HttpDataSourceException:getCause	()Ljava/lang/Throwable;
    //   937: instanceof 1920
    //   940: ifeq +363 -> 1303
    //   943: lload 4
    //   945: lstore 16
    //   947: lload_2
    //   948: lstore 14
    //   950: aload 9
    //   952: invokevirtual 1921	com/tencent/oskplayer/datasource/HttpDataSource$HttpDataSourceException:getMessage	()Ljava/lang/String;
    //   955: ifnull +175 -> 1130
    //   958: lload 4
    //   960: lstore 16
    //   962: lload_2
    //   963: lstore 14
    //   965: aload 9
    //   967: invokevirtual 1921	com/tencent/oskplayer/datasource/HttpDataSource$HttpDataSourceException:getMessage	()Ljava/lang/String;
    //   970: invokevirtual 790	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   973: ldc_w 792
    //   976: invokevirtual 665	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   979: ifeq +151 -> 1130
    //   982: lload 4
    //   984: lstore 16
    //   986: lload_2
    //   987: lstore 14
    //   989: iconst_4
    //   990: ldc 49
    //   992: new 250	java/lang/StringBuilder
    //   995: dup
    //   996: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   999: ldc_w 1923
    //   1002: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1005: lload 4
    //   1007: invokevirtual 356	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1010: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1013: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   1016: aload 10
    //   1018: ifnull +20 -> 1038
    //   1021: lload 4
    //   1023: lstore 16
    //   1025: lload_2
    //   1026: lstore 14
    //   1028: aload 10
    //   1030: aload_1
    //   1031: bipush 155
    //   1033: invokeinterface 1917 3 0
    //   1038: iconst_3
    //   1039: ldc 49
    //   1041: new 250	java/lang/StringBuilder
    //   1044: dup
    //   1045: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   1048: ldc_w 1898
    //   1051: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1054: lload 4
    //   1056: invokevirtual 356	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1059: ldc_w 1900
    //   1062: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1065: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1068: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   1071: aload 27
    //   1073: invokeinterface 1208 1 0
    //   1078: iconst_4
    //   1079: ldc 49
    //   1081: ldc_w 1902
    //   1084: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   1087: iconst_4
    //   1088: ldc 49
    //   1090: new 250	java/lang/StringBuilder
    //   1093: dup
    //   1094: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   1097: ldc_w 1904
    //   1100: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1103: aload_1
    //   1104: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1107: ldc_w 1896
    //   1110: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1113: lload_2
    //   1114: invokevirtual 356	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1117: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1120: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   1123: lload 12
    //   1125: lstore 4
    //   1127: goto -535 -> 592
    //   1130: lload 4
    //   1132: lstore 16
    //   1134: lload_2
    //   1135: lstore 14
    //   1137: iconst_5
    //   1138: ldc 49
    //   1140: new 250	java/lang/StringBuilder
    //   1143: dup
    //   1144: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   1147: ldc_w 1925
    //   1150: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1153: lload_2
    //   1154: invokevirtual 356	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1157: ldc_w 1927
    //   1160: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1163: aload_1
    //   1164: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1167: ldc_w 1929
    //   1170: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1173: aload 9
    //   1175: invokestatic 395	com/tencent/oskplayer/util/PlayerUtils:getPrintableStackTrace	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1178: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1181: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1184: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   1187: aload 10
    //   1189: ifnull -151 -> 1038
    //   1192: lload 4
    //   1194: lstore 16
    //   1196: lload_2
    //   1197: lstore 14
    //   1199: aload 10
    //   1201: aload_1
    //   1202: bipush 154
    //   1204: invokeinterface 1917 3 0
    //   1209: goto -171 -> 1038
    //   1212: astore 9
    //   1214: iconst_3
    //   1215: ldc 49
    //   1217: new 250	java/lang/StringBuilder
    //   1220: dup
    //   1221: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   1224: ldc_w 1898
    //   1227: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1230: lload 16
    //   1232: invokevirtual 356	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1235: ldc_w 1900
    //   1238: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1241: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1244: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   1247: aload 27
    //   1249: invokeinterface 1208 1 0
    //   1254: iconst_4
    //   1255: ldc 49
    //   1257: ldc_w 1902
    //   1260: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   1263: iconst_4
    //   1264: ldc 49
    //   1266: new 250	java/lang/StringBuilder
    //   1269: dup
    //   1270: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   1273: ldc_w 1904
    //   1276: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1279: aload_1
    //   1280: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1283: ldc_w 1896
    //   1286: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1289: lload 14
    //   1291: invokevirtual 356	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1294: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1297: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   1300: aload 9
    //   1302: athrow
    //   1303: lload 4
    //   1305: lstore 16
    //   1307: lload_2
    //   1308: lstore 14
    //   1310: iconst_5
    //   1311: ldc 49
    //   1313: new 250	java/lang/StringBuilder
    //   1316: dup
    //   1317: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   1320: ldc_w 1925
    //   1323: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1326: lload_2
    //   1327: invokevirtual 356	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1330: ldc_w 1927
    //   1333: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1336: aload_1
    //   1337: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1340: ldc_w 1931
    //   1343: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1346: aload 9
    //   1348: invokestatic 395	com/tencent/oskplayer/util/PlayerUtils:getPrintableStackTrace	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1351: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1354: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1357: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   1360: aload 10
    //   1362: ifnull -324 -> 1038
    //   1365: lload 4
    //   1367: lstore 16
    //   1369: lload_2
    //   1370: lstore 14
    //   1372: aload 10
    //   1374: aload_1
    //   1375: bipush 153
    //   1377: invokeinterface 1917 3 0
    //   1382: goto -344 -> 1038
    //   1385: astore 9
    //   1387: iconst_4
    //   1388: ldc 49
    //   1390: new 250	java/lang/StringBuilder
    //   1393: dup
    //   1394: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   1397: ldc_w 1916
    //   1400: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1403: aload 9
    //   1405: invokevirtual 507	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1408: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1411: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   1414: aload 10
    //   1416: ifnull +13 -> 1429
    //   1419: aload 10
    //   1421: aload_1
    //   1422: bipush 151
    //   1424: invokeinterface 1917 3 0
    //   1429: lload 12
    //   1431: lstore 4
    //   1433: goto -841 -> 592
    //   1436: astore 9
    //   1438: ldc2_w 929
    //   1441: lstore 12
    //   1443: lload 22
    //   1445: lstore 4
    //   1447: lload 4
    //   1449: lstore 16
    //   1451: lload_2
    //   1452: lstore 14
    //   1454: iconst_5
    //   1455: ldc 49
    //   1457: new 250	java/lang/StringBuilder
    //   1460: dup
    //   1461: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   1464: ldc_w 1925
    //   1467: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1470: lload_2
    //   1471: invokevirtual 356	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1474: ldc_w 1927
    //   1477: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1480: aload_1
    //   1481: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1484: ldc_w 1933
    //   1487: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1490: aload 9
    //   1492: invokestatic 395	com/tencent/oskplayer/util/PlayerUtils:getPrintableStackTrace	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1495: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1498: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1501: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   1504: lload 4
    //   1506: lstore 16
    //   1508: lload_2
    //   1509: lstore 14
    //   1511: iconst_4
    //   1512: ldc 49
    //   1514: new 250	java/lang/StringBuilder
    //   1517: dup
    //   1518: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   1521: ldc_w 1894
    //   1524: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1527: aload_1
    //   1528: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1531: ldc_w 1896
    //   1534: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1537: lload_2
    //   1538: invokevirtual 356	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1541: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1544: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   1547: aload 10
    //   1549: ifnull +20 -> 1569
    //   1552: lload 4
    //   1554: lstore 16
    //   1556: lload_2
    //   1557: lstore 14
    //   1559: aload 10
    //   1561: aload_1
    //   1562: bipush 152
    //   1564: invokeinterface 1917 3 0
    //   1569: iconst_3
    //   1570: ldc 49
    //   1572: new 250	java/lang/StringBuilder
    //   1575: dup
    //   1576: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   1579: ldc_w 1898
    //   1582: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1585: lload 4
    //   1587: invokevirtual 356	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1590: ldc_w 1900
    //   1593: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1596: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1599: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   1602: aload 27
    //   1604: invokeinterface 1208 1 0
    //   1609: iconst_4
    //   1610: ldc 49
    //   1612: ldc_w 1902
    //   1615: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   1618: iconst_4
    //   1619: ldc 49
    //   1621: new 250	java/lang/StringBuilder
    //   1624: dup
    //   1625: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   1628: ldc_w 1904
    //   1631: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1634: aload_1
    //   1635: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1638: ldc_w 1896
    //   1641: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1644: lload_2
    //   1645: invokevirtual 356	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1648: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1651: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   1654: lload 12
    //   1656: lstore 4
    //   1658: goto -1066 -> 592
    //   1661: astore 9
    //   1663: iconst_4
    //   1664: ldc 49
    //   1666: new 250	java/lang/StringBuilder
    //   1669: dup
    //   1670: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   1673: ldc_w 1916
    //   1676: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1679: aload 9
    //   1681: invokevirtual 507	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1684: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1687: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   1690: aload 10
    //   1692: ifnull +13 -> 1705
    //   1695: aload 10
    //   1697: aload_1
    //   1698: bipush 151
    //   1700: invokeinterface 1917 3 0
    //   1705: lload 12
    //   1707: lstore 4
    //   1709: goto -1117 -> 592
    //   1712: astore 24
    //   1714: iconst_4
    //   1715: ldc 49
    //   1717: new 250	java/lang/StringBuilder
    //   1720: dup
    //   1721: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   1724: ldc_w 1916
    //   1727: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1730: aload 24
    //   1732: invokevirtual 507	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1735: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1738: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   1741: aload 10
    //   1743: ifnull -443 -> 1300
    //   1746: aload 10
    //   1748: aload_1
    //   1749: bipush 151
    //   1751: invokeinterface 1917 3 0
    //   1756: goto -456 -> 1300
    //   1759: lload_2
    //   1760: lstore 4
    //   1762: invokestatic 491	java/lang/System:currentTimeMillis	()J
    //   1765: lstore 12
    //   1767: lload_2
    //   1768: lstore 4
    //   1770: aload_0
    //   1771: getfield 164	com/tencent/oskplayer/proxy/VideoProxy:mCacheListenerMap	Ljava/util/Map;
    //   1774: aload 25
    //   1776: invokeinterface 585 2 0
    //   1781: ifeq +56 -> 1837
    //   1784: lload_2
    //   1785: lstore 4
    //   1787: aload_0
    //   1788: getfield 164	com/tencent/oskplayer/proxy/VideoProxy:mCacheListenerMap	Ljava/util/Map;
    //   1791: aload 25
    //   1793: invokeinterface 722 2 0
    //   1798: checkcast 1935	com/tencent/oskplayer/cache/CacheListener
    //   1801: astore 9
    //   1803: aload 9
    //   1805: ifnull +32 -> 1837
    //   1808: lload_2
    //   1809: lstore 4
    //   1811: aload 9
    //   1813: lload 12
    //   1815: lload 16
    //   1817: lsub
    //   1818: l2i
    //   1819: invokevirtual 1938	com/tencent/oskplayer/cache/CacheListener:setFileLastModified	(I)V
    //   1822: lload_2
    //   1823: lstore 4
    //   1825: aload_0
    //   1826: getfield 164	com/tencent/oskplayer/proxy/VideoProxy:mCacheListenerMap	Ljava/util/Map;
    //   1829: aload 25
    //   1831: invokeinterface 1940 2 0
    //   1836: pop
    //   1837: iconst_3
    //   1838: ldc 49
    //   1840: new 250	java/lang/StringBuilder
    //   1843: dup
    //   1844: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   1847: ldc_w 1942
    //   1850: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1853: lload_2
    //   1854: invokevirtual 356	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1857: ldc_w 1900
    //   1860: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1863: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1866: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   1869: aload 27
    //   1871: invokeinterface 1208 1 0
    //   1876: iconst_4
    //   1877: ldc 49
    //   1879: ldc_w 1944
    //   1882: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   1885: aload_0
    //   1886: getfield 1294	com/tencent/oskplayer/proxy/VideoProxy:tcDataSourceUtils	Lcom/tencent/oskplayer/proxy/ITcDataSourceUtils;
    //   1889: ifnull +14 -> 1903
    //   1892: aload_0
    //   1893: getfield 1294	com/tencent/oskplayer/proxy/VideoProxy:tcDataSourceUtils	Lcom/tencent/oskplayer/proxy/ITcDataSourceUtils;
    //   1896: aload 24
    //   1898: invokeinterface 1947 2 0
    //   1903: aload 10
    //   1905: ifnull +11 -> 1916
    //   1908: aload 10
    //   1910: aload_1
    //   1911: invokeinterface 1950 2 0
    //   1916: iconst_1
    //   1917: ireturn
    //   1918: astore 9
    //   1920: iconst_4
    //   1921: ldc 49
    //   1923: new 250	java/lang/StringBuilder
    //   1926: dup
    //   1927: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   1930: ldc_w 1952
    //   1933: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1936: aload 9
    //   1938: invokevirtual 507	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1941: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1944: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   1947: aload 10
    //   1949: ifnull -64 -> 1885
    //   1952: aload 10
    //   1954: aload_1
    //   1955: bipush 151
    //   1957: invokeinterface 1917 3 0
    //   1962: goto -77 -> 1885
    //   1965: astore 9
    //   1967: lconst_0
    //   1968: lstore_2
    //   1969: lload_2
    //   1970: lstore 4
    //   1972: aload 9
    //   1974: invokevirtual 1918	com/tencent/oskplayer/datasource/HttpDataSource$HttpDataSourceException:getCause	()Ljava/lang/Throwable;
    //   1977: instanceof 1920
    //   1980: ifeq +297 -> 2277
    //   1983: lload_2
    //   1984: lstore 4
    //   1986: aload 9
    //   1988: invokevirtual 1921	com/tencent/oskplayer/datasource/HttpDataSource$HttpDataSourceException:getMessage	()Ljava/lang/String;
    //   1991: ifnull +168 -> 2159
    //   1994: lload_2
    //   1995: lstore 4
    //   1997: aload 9
    //   1999: invokevirtual 1921	com/tencent/oskplayer/datasource/HttpDataSource$HttpDataSourceException:getMessage	()Ljava/lang/String;
    //   2002: invokevirtual 790	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   2005: ldc_w 792
    //   2008: invokevirtual 665	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   2011: ifeq +148 -> 2159
    //   2014: lload_2
    //   2015: lstore 4
    //   2017: iconst_4
    //   2018: ldc 49
    //   2020: new 250	java/lang/StringBuilder
    //   2023: dup
    //   2024: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   2027: ldc_w 1954
    //   2030: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2033: lload_2
    //   2034: invokevirtual 356	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2037: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2040: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2043: aload 10
    //   2045: ifnull +16 -> 2061
    //   2048: lload_2
    //   2049: lstore 4
    //   2051: aload 10
    //   2053: aload_1
    //   2054: bipush 155
    //   2056: invokeinterface 1917 3 0
    //   2061: iconst_3
    //   2062: ldc 49
    //   2064: new 250	java/lang/StringBuilder
    //   2067: dup
    //   2068: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   2071: ldc_w 1942
    //   2074: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2077: lload_2
    //   2078: invokevirtual 356	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2081: ldc_w 1900
    //   2084: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2087: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2090: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2093: aload 27
    //   2095: invokeinterface 1208 1 0
    //   2100: iconst_4
    //   2101: ldc 49
    //   2103: ldc_w 1944
    //   2106: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2109: goto -224 -> 1885
    //   2112: astore 9
    //   2114: iconst_4
    //   2115: ldc 49
    //   2117: new 250	java/lang/StringBuilder
    //   2120: dup
    //   2121: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   2124: ldc_w 1952
    //   2127: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2130: aload 9
    //   2132: invokevirtual 507	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2135: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2138: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2141: aload 10
    //   2143: ifnull -258 -> 1885
    //   2146: aload 10
    //   2148: aload_1
    //   2149: bipush 151
    //   2151: invokeinterface 1917 3 0
    //   2156: goto -271 -> 1885
    //   2159: lload_2
    //   2160: lstore 4
    //   2162: iconst_5
    //   2163: ldc 49
    //   2165: new 250	java/lang/StringBuilder
    //   2168: dup
    //   2169: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   2172: ldc_w 1956
    //   2175: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2178: aload_1
    //   2179: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2182: ldc_w 1929
    //   2185: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2188: aload 9
    //   2190: invokestatic 395	com/tencent/oskplayer/util/PlayerUtils:getPrintableStackTrace	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   2193: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2196: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2199: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2202: aload 10
    //   2204: ifnull -143 -> 2061
    //   2207: lload_2
    //   2208: lstore 4
    //   2210: aload 10
    //   2212: aload_1
    //   2213: bipush 154
    //   2215: invokeinterface 1917 3 0
    //   2220: goto -159 -> 2061
    //   2223: astore 9
    //   2225: iconst_3
    //   2226: ldc 49
    //   2228: new 250	java/lang/StringBuilder
    //   2231: dup
    //   2232: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   2235: ldc_w 1942
    //   2238: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2241: lload 4
    //   2243: invokevirtual 356	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2246: ldc_w 1900
    //   2249: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2252: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2255: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2258: aload 27
    //   2260: invokeinterface 1208 1 0
    //   2265: iconst_4
    //   2266: ldc 49
    //   2268: ldc_w 1944
    //   2271: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2274: aload 9
    //   2276: athrow
    //   2277: lload_2
    //   2278: lstore 4
    //   2280: iconst_5
    //   2281: ldc 49
    //   2283: new 250	java/lang/StringBuilder
    //   2286: dup
    //   2287: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   2290: ldc_w 1956
    //   2293: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2296: aload_1
    //   2297: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2300: ldc_w 1929
    //   2303: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2306: aload 9
    //   2308: invokestatic 395	com/tencent/oskplayer/util/PlayerUtils:getPrintableStackTrace	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   2311: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2314: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2317: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2320: aload 10
    //   2322: ifnull -261 -> 2061
    //   2325: lload_2
    //   2326: lstore 4
    //   2328: aload 10
    //   2330: aload_1
    //   2331: bipush 153
    //   2333: invokeinterface 1917 3 0
    //   2338: goto -277 -> 2061
    //   2341: astore 9
    //   2343: lload 12
    //   2345: lstore_2
    //   2346: lload_2
    //   2347: lstore 4
    //   2349: iconst_5
    //   2350: ldc 49
    //   2352: new 250	java/lang/StringBuilder
    //   2355: dup
    //   2356: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   2359: ldc_w 1956
    //   2362: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2365: aload_1
    //   2366: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2369: ldc_w 1929
    //   2372: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2375: aload 9
    //   2377: invokestatic 395	com/tencent/oskplayer/util/PlayerUtils:getPrintableStackTrace	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   2380: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2383: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2386: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2389: aload 10
    //   2391: ifnull +16 -> 2407
    //   2394: lload_2
    //   2395: lstore 4
    //   2397: aload 10
    //   2399: aload_1
    //   2400: bipush 152
    //   2402: invokeinterface 1917 3 0
    //   2407: iconst_3
    //   2408: ldc 49
    //   2410: new 250	java/lang/StringBuilder
    //   2413: dup
    //   2414: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   2417: ldc_w 1942
    //   2420: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2423: lload_2
    //   2424: invokevirtual 356	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2427: ldc_w 1900
    //   2430: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2433: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2436: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2439: aload 27
    //   2441: invokeinterface 1208 1 0
    //   2446: iconst_4
    //   2447: ldc 49
    //   2449: ldc_w 1944
    //   2452: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2455: goto -570 -> 1885
    //   2458: astore 9
    //   2460: iconst_4
    //   2461: ldc 49
    //   2463: new 250	java/lang/StringBuilder
    //   2466: dup
    //   2467: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   2470: ldc_w 1952
    //   2473: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2476: aload 9
    //   2478: invokevirtual 507	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2481: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2484: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2487: aload 10
    //   2489: ifnull -604 -> 1885
    //   2492: aload 10
    //   2494: aload_1
    //   2495: bipush 151
    //   2497: invokeinterface 1917 3 0
    //   2502: goto -617 -> 1885
    //   2505: astore 24
    //   2507: iconst_4
    //   2508: ldc 49
    //   2510: new 250	java/lang/StringBuilder
    //   2513: dup
    //   2514: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   2517: ldc_w 1952
    //   2520: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2523: aload 24
    //   2525: invokevirtual 507	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2528: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2531: invokestatic 248	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2534: aload 10
    //   2536: ifnull -262 -> 2274
    //   2539: aload 10
    //   2541: aload_1
    //   2542: bipush 151
    //   2544: invokeinterface 1917 3 0
    //   2549: goto -275 -> 2274
    //   2552: astore 9
    //   2554: goto -329 -> 2225
    //   2557: astore 9
    //   2559: goto -213 -> 2346
    //   2562: astore 9
    //   2564: goto -595 -> 1969
    //   2567: astore 9
    //   2569: goto -1355 -> 1214
    //   2572: astore 9
    //   2574: lload 22
    //   2576: lstore 4
    //   2578: lload 20
    //   2580: lstore_2
    //   2581: goto -1134 -> 1447
    //   2584: astore 9
    //   2586: goto -1139 -> 1447
    //   2589: astore 9
    //   2591: lconst_0
    //   2592: lstore 4
    //   2594: lload 18
    //   2596: lstore_2
    //   2597: goto -1672 -> 925
    //   2600: astore 9
    //   2602: goto -1677 -> 925
    //   2605: ldc2_w 929
    //   2608: lstore 4
    //   2610: goto -2018 -> 592
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2613	0	this	VideoProxy
    //   0	2613	1	paramString	String
    //   0	2613	2	paramLong1	long
    //   0	2613	4	paramLong2	long
    //   0	2613	6	paramInt	int
    //   0	2613	7	paramBoolean1	boolean
    //   0	2613	8	paramBoolean2	boolean
    //   0	2613	9	paramHttpHeader	HttpHeader
    //   0	2613	10	paramDownloadListener	DownloadListener
    //   232	108	11	i	int
    //   194	2150	12	l1	long
    //   150	1408	14	l2	long
    //   147	1669	16	l3	long
    //   216	2379	18	l4	long
    //   213	2366	20	l5	long
    //   118	2457	22	l6	long
    //   97	1	24	str1	String
    //   1712	185	24	localException1	Exception
    //   2505	19	24	localException2	Exception
    //   73	1757	25	str2	String
    //   90	709	26	str3	String
    //   136	2304	27	localDefaultHttpDataSource	DefaultHttpDataSource
    // Exception table:
    //   from	to	target	type
    //   503	588	864	java/lang/Exception
    //   152	180	915	com/tencent/oskplayer/datasource/HttpDataSource$HttpDataSourceException
    //   187	196	915	com/tencent/oskplayer/datasource/HttpDataSource$HttpDataSourceException
    //   409	424	1212	finally
    //   932	943	1212	finally
    //   950	958	1212	finally
    //   965	982	1212	finally
    //   989	1016	1212	finally
    //   1028	1038	1212	finally
    //   1137	1187	1212	finally
    //   1199	1209	1212	finally
    //   1310	1360	1212	finally
    //   1372	1382	1212	finally
    //   1038	1123	1385	java/lang/Exception
    //   152	180	1436	java/io/IOException
    //   187	196	1436	java/io/IOException
    //   1569	1654	1661	java/lang/Exception
    //   1214	1300	1712	java/lang/Exception
    //   1837	1885	1918	java/lang/Exception
    //   647	675	1965	com/tencent/oskplayer/datasource/HttpDataSource$HttpDataSourceException
    //   679	688	1965	com/tencent/oskplayer/datasource/HttpDataSource$HttpDataSourceException
    //   692	699	1965	com/tencent/oskplayer/datasource/HttpDataSource$HttpDataSourceException
    //   718	726	1965	com/tencent/oskplayer/datasource/HttpDataSource$HttpDataSourceException
    //   730	788	1965	com/tencent/oskplayer/datasource/HttpDataSource$HttpDataSourceException
    //   792	822	1965	com/tencent/oskplayer/datasource/HttpDataSource$HttpDataSourceException
    //   2061	2109	2112	java/lang/Exception
    //   827	842	2223	finally
    //   1762	1767	2223	finally
    //   1770	1784	2223	finally
    //   1787	1803	2223	finally
    //   1811	1822	2223	finally
    //   1825	1837	2223	finally
    //   1972	1983	2223	finally
    //   1986	1994	2223	finally
    //   1997	2014	2223	finally
    //   2017	2043	2223	finally
    //   2051	2061	2223	finally
    //   2162	2202	2223	finally
    //   2210	2220	2223	finally
    //   2280	2320	2223	finally
    //   2328	2338	2223	finally
    //   647	675	2341	java/io/IOException
    //   679	688	2341	java/io/IOException
    //   692	699	2341	java/io/IOException
    //   718	726	2341	java/io/IOException
    //   730	788	2341	java/io/IOException
    //   792	822	2341	java/io/IOException
    //   2407	2455	2458	java/lang/Exception
    //   2225	2274	2505	java/lang/Exception
    //   647	675	2552	finally
    //   679	688	2552	finally
    //   692	699	2552	finally
    //   718	726	2552	finally
    //   730	788	2552	finally
    //   792	822	2552	finally
    //   2349	2389	2552	finally
    //   2397	2407	2552	finally
    //   827	842	2557	java/io/IOException
    //   1762	1767	2557	java/io/IOException
    //   1770	1784	2557	java/io/IOException
    //   1787	1803	2557	java/io/IOException
    //   1811	1822	2557	java/io/IOException
    //   1825	1837	2557	java/io/IOException
    //   827	842	2562	com/tencent/oskplayer/datasource/HttpDataSource$HttpDataSourceException
    //   1762	1767	2562	com/tencent/oskplayer/datasource/HttpDataSource$HttpDataSourceException
    //   1770	1784	2562	com/tencent/oskplayer/datasource/HttpDataSource$HttpDataSourceException
    //   1787	1803	2562	com/tencent/oskplayer/datasource/HttpDataSource$HttpDataSourceException
    //   1811	1822	2562	com/tencent/oskplayer/datasource/HttpDataSource$HttpDataSourceException
    //   1825	1837	2562	com/tencent/oskplayer/datasource/HttpDataSource$HttpDataSourceException
    //   152	180	2567	finally
    //   187	196	2567	finally
    //   218	234	2567	finally
    //   247	261	2567	finally
    //   274	286	2567	finally
    //   299	310	2567	finally
    //   323	392	2567	finally
    //   461	497	2567	finally
    //   1454	1504	2567	finally
    //   1511	1547	2567	finally
    //   1559	1569	2567	finally
    //   218	234	2572	java/io/IOException
    //   247	261	2572	java/io/IOException
    //   274	286	2572	java/io/IOException
    //   299	310	2572	java/io/IOException
    //   323	392	2572	java/io/IOException
    //   461	497	2572	java/io/IOException
    //   409	424	2584	java/io/IOException
    //   218	234	2589	com/tencent/oskplayer/datasource/HttpDataSource$HttpDataSourceException
    //   247	261	2589	com/tencent/oskplayer/datasource/HttpDataSource$HttpDataSourceException
    //   274	286	2589	com/tencent/oskplayer/datasource/HttpDataSource$HttpDataSourceException
    //   299	310	2589	com/tencent/oskplayer/datasource/HttpDataSource$HttpDataSourceException
    //   323	392	2589	com/tencent/oskplayer/datasource/HttpDataSource$HttpDataSourceException
    //   461	497	2589	com/tencent/oskplayer/datasource/HttpDataSource$HttpDataSourceException
    //   409	424	2600	com/tencent/oskplayer/datasource/HttpDataSource$HttpDataSourceException
  }
  
  public int probeContentFlag(String paramString)
  {
    String str = getUrl(paramString, true, true, "-1", "video/mp4", 10, null);
    paramString = PlayerUtils.getVideoUuidFromVideoUrl(str);
    DefaultHttpDataSource localDefaultHttpDataSource = new DefaultHttpDataSource("com.qzone.player-v20150909", null, null);
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    paramString = new VideoProxy.ProbeContentRequestListener(this, paramString, localCountDownLatch);
    this.videoRequestManager.addRequestListener(paramString);
    try
    {
      localDefaultHttpDataSource.open(new DataSpec(Uri.parse(str), 0L, 0L, -1L, null, 0, null), "HEAD");
      localDefaultHttpDataSource.close();
      localCountDownLatch.await(5L, TimeUnit.SECONDS);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        this.videoRequestManager.removeRequestListener(paramString);
      }
    }
    finally
    {
      this.videoRequestManager.removeRequestListener(paramString);
    }
    return ((VideoProxy.ProbeContentRequestListener)paramString).mFlags;
  }
  
  /* Error */
  public void removeCacheReadListener(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 238	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_1
    //   15: invokestatic 941	com/tencent/oskplayer/util/PlayerUtils:parseVideoKey	(Ljava/lang/String;)Ljava/lang/String;
    //   18: astore_1
    //   19: aload_0
    //   20: getfield 210	com/tencent/oskplayer/proxy/VideoProxy:cacheReadListenerMap	Ljava/util/Map;
    //   23: aload_1
    //   24: invokeinterface 1940 2 0
    //   29: pop
    //   30: goto -19 -> 11
    //   33: astore_1
    //   34: aload_0
    //   35: monitorexit
    //   36: aload_1
    //   37: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	38	0	this	VideoProxy
    //   0	38	1	paramString	String
    //   6	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	7	33	finally
    //   14	30	33	finally
  }
  
  /* Error */
  public void removeHttpErrorListener(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 238	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_1
    //   15: invokestatic 941	com/tencent/oskplayer/util/PlayerUtils:parseVideoKey	(Ljava/lang/String;)Ljava/lang/String;
    //   18: astore_1
    //   19: aload_0
    //   20: getfield 212	com/tencent/oskplayer/proxy/VideoProxy:httpUrlErrorListenerMap	Ljava/util/Map;
    //   23: aload_1
    //   24: invokeinterface 1940 2 0
    //   29: pop
    //   30: goto -19 -> 11
    //   33: astore_1
    //   34: aload_0
    //   35: monitorexit
    //   36: aload_1
    //   37: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	38	0	this	VideoProxy
    //   0	38	1	paramString	String
    //   6	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	7	33	finally
    //   14	30	33	finally
  }
  
  public void removeHttpRetryLogic(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramString = PlayerUtils.parseVideoKey(paramString);
    this.httpRetryLogicMap.remove(paramString);
  }
  
  /* Error */
  public void removeUuidErrorListener(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 238	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 214	com/tencent/oskplayer/proxy/VideoProxy:uuidErrorListenerMap	Ljava/util/Map;
    //   18: aload_1
    //   19: invokeinterface 1940 2 0
    //   24: pop
    //   25: goto -14 -> 11
    //   28: astore_1
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_1
    //   32: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	this	VideoProxy
    //   0	33	1	paramString	String
    //   6	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	7	28	finally
    //   14	25	28	finally
  }
  
  public void setDataSourceBuilder(ITcDataSourceUtils paramITcDataSourceUtils)
  {
    try
    {
      this.tcDataSourceUtils = paramITcDataSourceUtils;
      return;
    }
    finally
    {
      paramITcDataSourceUtils = finally;
      throw paramITcDataSourceUtils;
    }
  }
  
  public void shutdown()
  {
    this.isShutdown = true;
    PlayerUtils.log(3, "VideoProxy", "shutting down proxy server");
    this.waitConnectionThread.interrupt();
    try
    {
      PlayerUtils.log(3, "VideoProxy", "close server socket");
      this.serverSocket.close();
      this.executorService.shutdownNow();
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        PlayerUtils.log(6, "VideoProxy", "error when close proxy server " + localIOException.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.oskplayer.proxy.VideoProxy
 * JD-Core Version:    0.7.0.1
 */