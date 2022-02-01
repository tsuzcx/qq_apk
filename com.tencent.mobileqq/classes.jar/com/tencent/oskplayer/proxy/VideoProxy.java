package com.tencent.oskplayer.proxy;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.oskplayer.PlayerConfig;
import com.tencent.oskplayer.cache.Cache;
import com.tencent.oskplayer.cache.CacheEvictor;
import com.tencent.oskplayer.cache.CacheListener;
import com.tencent.oskplayer.cache.LeastRecentlyUsedCacheEvictor;
import com.tencent.oskplayer.cache.SimpleCache;
import com.tencent.oskplayer.datasource.DownloadListener;
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
import java.util.List<Ljava.lang.String;>;
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
    Object localObject2;
    if (this.isCacheProviderLocal)
    {
      localObject1 = PlayerConfig.g().getCacheDir();
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        this.cache = null;
      }
      else
      {
        long l = Math.min(StorageUtil.getDirAvailableSpace((String)localObject1), PlayerConfig.g().getCacheMaxBytes());
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("cache availableSpace=");
        ((StringBuilder)localObject2).append(l);
        PlayerUtils.log(4, "VideoProxy", ((StringBuilder)localObject2).toString());
        localObject2 = new LeastRecentlyUsedCacheEvictor(l);
        ThreadUtils.submitTask(new VideoProxy.1(this, (String)localObject1, l, (CacheEvictor)localObject2), "VideoProxy");
        this.cache = new SimpleCache(new File((String)localObject1), (CacheEvictor)localObject2);
      }
      PlayerUtils.log(4, "VideoProxy", "cache provider is local ");
    }
    else
    {
      PlayerUtils.log(4, "VideoProxy", "cache provider is tc");
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("cache dir is:");
    ((StringBuilder)localObject1).append(PlayerConfig.g().getCacheDir());
    PlayerUtils.log(4, "VideoProxy", ((StringBuilder)localObject1).toString());
    this.videoRequestManager = new VideoRequestManager();
    this.executorService = new ThreadUtils.FlexibleSizeExecutor(PlayerConfig.g().getCoreClientCount(), PlayerConfig.g().getMaxClientCount(), 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
    try
    {
      localObject1 = InetAddress.getByName("0.0.0.0");
      this.serverSocket = new ServerSocket(PlayerUtils.findFreePort(5), PlayerConfig.g().getMaxClientCount(), (InetAddress)localObject1);
      this.serverPort = this.serverSocket.getLocalPort();
      localObject1 = new CountDownLatch(1);
      this.waitConnectionThread = new Thread(new VideoProxy.WaitRequestRunnable(this, (CountDownLatch)localObject1), "video_proxy_wait_for_connection_thread");
      this.waitConnectionThread.start();
      ((CountDownLatch)localObject1).await();
      PlayerUtils.log(4, "VideoProxy", "proxy start success");
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      this.executorService.shutdown();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("proxy start failed ");
      ((StringBuilder)localObject2).append(PlayerUtils.getPrintableStackTrace(localInterruptedException));
      PlayerUtils.log(6, "VideoProxy", ((StringBuilder)localObject2).toString());
      return;
    }
    catch (IOException localIOException)
    {
      this.executorService.shutdown();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("proxy start failed ");
      ((StringBuilder)localObject2).append(PlayerUtils.getPrintableStackTrace(localIOException));
      PlayerUtils.log(6, "VideoProxy", ((StringBuilder)localObject2).toString());
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      this.executorService.shutdown();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("proxy start failed ");
      ((StringBuilder)localObject2).append(PlayerUtils.getPrintableStackTrace(localIllegalStateException));
      PlayerUtils.log(6, "VideoProxy", ((StringBuilder)localObject2).toString());
    }
  }
  
  private void cancelPreloadRequestsSync(String paramString, VideoRequest paramVideoRequest)
  {
    Object localObject1 = getIdleVideoRequest(getPreloadVideoRequestByVideoKey(paramString));
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("VideoProxy/");
    ((StringBuilder)localObject2).append(paramVideoRequest.getSeqNum());
    paramVideoRequest = ((StringBuilder)localObject2).toString();
    if (((ArrayList)localObject1).size() > 0)
    {
      localObject2 = new CountDownLatch(((ArrayList)localObject1).size());
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("start auto cancel preload requests, request count ");
      ((StringBuilder)localObject3).append(((CountDownLatch)localObject2).getCount());
      PlayerUtils.log(5, paramVideoRequest, ((StringBuilder)localObject3).toString());
      localObject3 = new VideoProxy.2(this, (CountDownLatch)localObject2);
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((VideoRequest)((Iterator)localObject1).next()).cancel((VideoCancelListener)localObject3);
      }
      long l = 2000;
      try
      {
        ((CountDownLatch)localObject2).await(l, TimeUnit.MILLISECONDS);
        if (getPreloadVideoRequestByVideoKey(paramString).size() == 0)
        {
          PlayerUtils.log(5, paramVideoRequest, "auto cancel preload requests success");
          return;
        }
        paramString = new StringBuilder();
        paramString.append("auto cancel preload requests timeout, max wait time is ");
        paramString.append(2000);
        paramString.append(" seconds");
        PlayerUtils.log(5, paramVideoRequest, paramString.toString());
        return;
      }
      catch (InterruptedException paramString)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("auto cancel preload requests interrupted ");
        ((StringBuilder)localObject1).append(paramString.toString());
        PlayerUtils.log(5, paramVideoRequest, ((StringBuilder)localObject1).toString());
      }
    }
  }
  
  /* Error */
  private File generateLocalPlaylistFile(com.tencent.oskplayer.datasource.DataSource paramDataSource, com.tencent.oskplayer.datasource.DataSpec paramDataSpec, String paramString, VideoRequest paramVideoRequest)
  {
    // Byte code:
    //   0: new 258	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   7: astore 16
    //   9: aload 16
    //   11: ldc 8
    //   13: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: pop
    //   17: aload 16
    //   19: aload 4
    //   21: invokevirtual 427	com/tencent/oskplayer/proxy/VideoRequest:getSeqNum	()I
    //   24: invokevirtual 430	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   27: pop
    //   28: aload 16
    //   30: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: astore 17
    //   35: invokestatic 176	com/tencent/oskplayer/PlayerConfig:g	()Lcom/tencent/oskplayer/PlayerConfig;
    //   38: invokevirtual 481	com/tencent/oskplayer/PlayerConfig:getTempDir	()Ljava/lang/String;
    //   41: astore 18
    //   43: aload 18
    //   45: ifnonnull +15 -> 60
    //   48: bipush 6
    //   50: aload 17
    //   52: ldc_w 483
    //   55: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   58: aconst_null
    //   59: areturn
    //   60: new 297	java/io/File
    //   63: dup
    //   64: aload 18
    //   66: invokespecial 300	java/io/File:<init>	(Ljava/lang/String;)V
    //   69: astore 16
    //   71: new 258	java/lang/StringBuilder
    //   74: dup
    //   75: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   78: astore 19
    //   80: aload 19
    //   82: aload 18
    //   84: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: pop
    //   88: aload 19
    //   90: getstatic 486	java/io/File:separator	Ljava/lang/String;
    //   93: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: pop
    //   97: aload 19
    //   99: invokestatic 491	java/lang/System:currentTimeMillis	()J
    //   102: getstatic 146	com/tencent/oskplayer/proxy/VideoProxy:PLAY_LIST_ID	Ljava/util/concurrent/atomic/AtomicInteger;
    //   105: invokevirtual 494	java/util/concurrent/atomic/AtomicInteger:incrementAndGet	()I
    //   108: i2l
    //   109: ladd
    //   110: invokevirtual 268	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   113: pop
    //   114: aload 19
    //   116: ldc_w 496
    //   119: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: pop
    //   123: new 297	java/io/File
    //   126: dup
    //   127: aload 19
    //   129: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: invokespecial 300	java/io/File:<init>	(Ljava/lang/String;)V
    //   135: astore 19
    //   137: aload 16
    //   139: invokevirtual 499	java/io/File:exists	()Z
    //   142: ifne +9 -> 151
    //   145: aload 16
    //   147: invokevirtual 502	java/io/File:mkdirs	()Z
    //   150: pop
    //   151: new 258	java/lang/StringBuilder
    //   154: dup
    //   155: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   158: astore 16
    //   160: aload 16
    //   162: ldc_w 504
    //   165: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: pop
    //   169: aload 16
    //   171: aload 19
    //   173: invokevirtual 507	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   176: pop
    //   177: aload 16
    //   179: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   182: astore 16
    //   184: iconst_4
    //   185: aload 17
    //   187: aload 16
    //   189: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   192: aload 4
    //   194: invokevirtual 510	com/tencent/oskplayer/proxy/VideoRequest:getPrority	()I
    //   197: bipush 10
    //   199: if_icmpne +9 -> 208
    //   202: iconst_1
    //   203: istore 5
    //   205: goto +6 -> 211
    //   208: iconst_0
    //   209: istore 5
    //   211: aload 4
    //   213: invokevirtual 513	com/tencent/oskplayer/proxy/VideoRequest:getUuid	()Ljava/lang/String;
    //   216: astore 22
    //   218: aload 4
    //   220: invokevirtual 510	com/tencent/oskplayer/proxy/VideoRequest:getPrority	()I
    //   223: bipush 10
    //   225: if_icmpne +9 -> 234
    //   228: iconst_1
    //   229: istore 6
    //   231: goto +6 -> 237
    //   234: iconst_3
    //   235: istore 6
    //   237: new 258	java/lang/StringBuilder
    //   240: dup
    //   241: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   244: astore 16
    //   246: aload 16
    //   248: ldc_w 515
    //   251: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: pop
    //   255: aload 16
    //   257: iload 6
    //   259: invokevirtual 430	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   262: pop
    //   263: iconst_4
    //   264: aload 17
    //   266: aload 16
    //   268: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   271: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   274: aload 4
    //   276: aload 4
    //   278: invokevirtual 518	com/tencent/oskplayer/proxy/VideoRequest:getContentFormatFlag	()I
    //   281: iconst_5
    //   282: ior
    //   283: invokevirtual 521	com/tencent/oskplayer/proxy/VideoRequest:setContentFormatFlag	(I)V
    //   286: ldc_w 523
    //   289: bipush 34
    //   291: invokestatic 529	java/util/regex/Pattern:compile	(Ljava/lang/String;I)Ljava/util/regex/Pattern;
    //   294: astore 23
    //   296: aload_1
    //   297: aload_2
    //   298: invokeinterface 535 2 0
    //   303: pop2
    //   304: new 537	java/io/BufferedReader
    //   307: dup
    //   308: new 539	com/tencent/oskplayer/datasource/DataSourceReader
    //   311: dup
    //   312: aload_1
    //   313: ldc_w 541
    //   316: invokespecial 544	com/tencent/oskplayer/datasource/DataSourceReader:<init>	(Lcom/tencent/oskplayer/datasource/DataSource;Ljava/lang/String;)V
    //   319: invokespecial 547	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   322: astore 20
    //   324: new 549	java/io/FileOutputStream
    //   327: dup
    //   328: aload 19
    //   330: invokespecial 552	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   333: astore 16
    //   335: new 258	java/lang/StringBuilder
    //   338: dup
    //   339: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   342: astore 18
    //   344: iconst_4
    //   345: aload 17
    //   347: ldc_w 554
    //   350: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   353: aconst_null
    //   354: astore 21
    //   356: iconst_m1
    //   357: istore 9
    //   359: iconst_0
    //   360: istore 11
    //   362: iconst_m1
    //   363: istore 12
    //   365: iconst_1
    //   366: istore 10
    //   368: iload 5
    //   370: istore 8
    //   372: iload 6
    //   374: istore 7
    //   376: iload 12
    //   378: istore 5
    //   380: iload 9
    //   382: istore 6
    //   384: aload 17
    //   386: astore_1
    //   387: aload 19
    //   389: astore_2
    //   390: aload 20
    //   392: astore 17
    //   394: aload 21
    //   396: astore 19
    //   398: aload 4
    //   400: astore 24
    //   402: aload_3
    //   403: astore 21
    //   405: invokestatic 557	java/lang/Thread:interrupted	()Z
    //   408: istore 13
    //   410: iload 13
    //   412: iconst_1
    //   413: ixor
    //   414: istore 12
    //   416: iload 12
    //   418: ifeq +1098 -> 1516
    //   421: aload 4
    //   423: invokevirtual 560	com/tencent/oskplayer/proxy/VideoRequest:shouldCancel	()Z
    //   426: ifne +1090 -> 1516
    //   429: iload 6
    //   431: istore 9
    //   433: aload 17
    //   435: invokevirtual 563	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   438: astore 27
    //   440: aload 27
    //   442: ifnull +1022 -> 1464
    //   445: iconst_4
    //   446: aload_1
    //   447: aload 27
    //   449: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   452: aload 27
    //   454: ldc_w 565
    //   457: invokevirtual 571	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   460: istore 13
    //   462: iload 13
    //   464: ifeq +574 -> 1038
    //   467: aload 27
    //   469: invokevirtual 574	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   472: ldc_w 576
    //   475: invokevirtual 580	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   478: istore 13
    //   480: aload 19
    //   482: astore 20
    //   484: iload 13
    //   486: ifeq +97 -> 583
    //   489: aload 19
    //   491: astore 20
    //   493: aload_0
    //   494: getfield 168	com/tencent/oskplayer/proxy/VideoProxy:mPlayListInfo	Ljava/util/Map;
    //   497: aload 22
    //   499: invokeinterface 585 2 0
    //   504: ifne +79 -> 583
    //   507: new 432	java/util/ArrayList
    //   510: dup
    //   511: invokespecial 586	java/util/ArrayList:<init>	()V
    //   514: astore 20
    //   516: aload_0
    //   517: getfield 168	com/tencent/oskplayer/proxy/VideoProxy:mPlayListInfo	Ljava/util/Map;
    //   520: aload 22
    //   522: new 588	com/tencent/oskplayer/proxy/PlayListInfo
    //   525: dup
    //   526: invokespecial 589	com/tencent/oskplayer/proxy/PlayListInfo:<init>	()V
    //   529: invokeinterface 593 3 0
    //   534: pop
    //   535: goto +48 -> 583
    //   538: astore_3
    //   539: aload 17
    //   541: astore 4
    //   543: aload_2
    //   544: astore 17
    //   546: aload_1
    //   547: astore_2
    //   548: iconst_0
    //   549: istore 5
    //   551: aload_3
    //   552: astore_1
    //   553: aload 17
    //   555: astore_3
    //   556: goto +2620 -> 3176
    //   559: astore 18
    //   561: aload 17
    //   563: astore_3
    //   564: aload 18
    //   566: astore 17
    //   568: goto +2095 -> 2663
    //   571: astore 18
    //   573: aload 17
    //   575: astore_3
    //   576: aload 18
    //   578: astore 17
    //   580: goto +2343 -> 2923
    //   583: aload 27
    //   585: invokevirtual 574	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   588: ldc_w 595
    //   591: invokevirtual 571	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   594: istore 13
    //   596: iload 13
    //   598: ifeq +25 -> 623
    //   601: aload 24
    //   603: aload 4
    //   605: invokevirtual 518	com/tencent/oskplayer/proxy/VideoRequest:getContentFormatFlag	()I
    //   608: bipush 251
    //   610: iand
    //   611: invokevirtual 521	com/tencent/oskplayer/proxy/VideoRequest:setContentFormatFlag	(I)V
    //   614: iconst_0
    //   615: istore 6
    //   617: iconst_1
    //   618: istore 8
    //   620: goto +7 -> 627
    //   623: iload 10
    //   625: istore 6
    //   627: aload 27
    //   629: invokevirtual 574	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   632: ldc_w 597
    //   635: invokevirtual 571	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   638: istore 13
    //   640: iload 13
    //   642: ifeq +10 -> 652
    //   645: aload 27
    //   647: invokestatic 601	com/tencent/oskplayer/util/PlayerUtils:parseM3u8Number	(Ljava/lang/String;)I
    //   650: istore 5
    //   652: aload 27
    //   654: invokevirtual 574	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   657: ldc_w 603
    //   660: invokevirtual 571	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   663: istore 13
    //   665: iload 13
    //   667: ifeq +10 -> 677
    //   670: aload 27
    //   672: invokestatic 601	com/tencent/oskplayer/util/PlayerUtils:parseM3u8Number	(Ljava/lang/String;)I
    //   675: istore 9
    //   677: aload 27
    //   679: invokevirtual 574	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   682: ldc_w 605
    //   685: invokevirtual 571	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   688: istore 13
    //   690: iload 13
    //   692: ifeq +42 -> 734
    //   695: aload 27
    //   697: invokestatic 609	com/tencent/oskplayer/util/PlayerUtils:parseM3u8Option	(Ljava/lang/String;)Ljava/lang/String;
    //   700: invokevirtual 574	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   703: ldc_w 611
    //   706: invokevirtual 580	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   709: ifeq +25 -> 734
    //   712: aload 24
    //   714: aload 4
    //   716: invokevirtual 518	com/tencent/oskplayer/proxy/VideoRequest:getContentFormatFlag	()I
    //   719: bipush 251
    //   721: iand
    //   722: invokevirtual 521	com/tencent/oskplayer/proxy/VideoRequest:setContentFormatFlag	(I)V
    //   725: iconst_0
    //   726: istore 6
    //   728: iconst_1
    //   729: istore 8
    //   731: goto +3 -> 734
    //   734: aload 27
    //   736: invokevirtual 574	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   739: ldc_w 613
    //   742: invokevirtual 571	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   745: ifeq +269 -> 1014
    //   748: aload 23
    //   750: aload 27
    //   752: invokevirtual 617	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   755: astore 19
    //   757: aload 19
    //   759: invokevirtual 622	java/util/regex/Matcher:matches	()Z
    //   762: ifeq +228 -> 990
    //   765: aload 19
    //   767: invokevirtual 625	java/util/regex/Matcher:groupCount	()I
    //   770: ifle +220 -> 990
    //   773: aload 19
    //   775: iconst_1
    //   776: invokevirtual 627	java/util/regex/Matcher:start	(I)I
    //   779: istore 10
    //   781: aload 19
    //   783: iconst_1
    //   784: invokevirtual 630	java/util/regex/Matcher:end	(I)I
    //   787: istore 12
    //   789: aload 27
    //   791: iconst_0
    //   792: iload 10
    //   794: invokevirtual 634	java/lang/String:substring	(II)Ljava/lang/String;
    //   797: astore 24
    //   799: aload 27
    //   801: iload 10
    //   803: iload 12
    //   805: invokevirtual 634	java/lang/String:substring	(II)Ljava/lang/String;
    //   808: astore 19
    //   810: aload 27
    //   812: iload 12
    //   814: invokevirtual 637	java/lang/String:substring	(I)Ljava/lang/String;
    //   817: astore 25
    //   819: aload 21
    //   821: aload 19
    //   823: invokestatic 641	com/tencent/oskplayer/util/PlayerUtils:getAbsoluteUrl	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   826: astore 19
    //   828: aload 4
    //   830: invokevirtual 644	com/tencent/oskplayer/proxy/VideoRequest:getDataSourceType	()Ljava/lang/String;
    //   833: astore 21
    //   835: aload 4
    //   837: invokevirtual 648	com/tencent/oskplayer/proxy/VideoRequest:getExtraHeader	()Lcom/tencent/oskplayer/datasource/HttpHeader;
    //   840: astore 26
    //   842: aload_0
    //   843: aload 19
    //   845: iconst_0
    //   846: iconst_0
    //   847: aload 21
    //   849: ldc_w 650
    //   852: bipush 90
    //   854: aload 26
    //   856: invokevirtual 654	com/tencent/oskplayer/proxy/VideoProxy:getUrl	(Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;ILcom/tencent/oskplayer/datasource/HttpHeader;)Ljava/lang/String;
    //   859: astore 21
    //   861: aload 21
    //   863: astore 19
    //   865: aload 4
    //   867: invokevirtual 513	com/tencent/oskplayer/proxy/VideoRequest:getUuid	()Ljava/lang/String;
    //   870: ifnull +80 -> 950
    //   873: new 258	java/lang/StringBuilder
    //   876: dup
    //   877: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   880: astore 19
    //   882: aload 19
    //   884: aload 21
    //   886: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   889: pop
    //   890: aload 19
    //   892: ldc_w 656
    //   895: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   898: pop
    //   899: aload 19
    //   901: aload 4
    //   903: invokevirtual 513	com/tencent/oskplayer/proxy/VideoRequest:getUuid	()Ljava/lang/String;
    //   906: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   909: pop
    //   910: aload 19
    //   912: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   915: astore 19
    //   917: new 258	java/lang/StringBuilder
    //   920: dup
    //   921: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   924: astore 21
    //   926: aload 21
    //   928: aload 19
    //   930: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   933: pop
    //   934: aload 21
    //   936: ldc_w 658
    //   939: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   942: pop
    //   943: aload 21
    //   945: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   948: astore 19
    //   950: aload 18
    //   952: astore 21
    //   954: aload 21
    //   956: aload 24
    //   958: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   961: pop
    //   962: aload 21
    //   964: aload 19
    //   966: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   969: pop
    //   970: aload 21
    //   972: aload 25
    //   974: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   977: pop
    //   978: aload 21
    //   980: ldc_w 660
    //   983: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   986: pop
    //   987: goto +2369 -> 3356
    //   990: aload 18
    //   992: astore 19
    //   994: aload 19
    //   996: aload 27
    //   998: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1001: pop
    //   1002: aload 19
    //   1004: ldc_w 660
    //   1007: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1010: pop
    //   1011: goto +2345 -> 3356
    //   1014: aload 18
    //   1016: astore 19
    //   1018: aload 19
    //   1020: aload 27
    //   1022: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1025: pop
    //   1026: aload 19
    //   1028: ldc_w 660
    //   1031: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1034: pop
    //   1035: goto +2321 -> 3356
    //   1038: aload 27
    //   1040: ldc_w 662
    //   1043: invokevirtual 665	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1046: ifne +2350 -> 3396
    //   1049: aload 27
    //   1051: ldc_w 667
    //   1054: invokevirtual 665	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1057: ifeq +180 -> 1237
    //   1060: goto +3 -> 1063
    //   1063: aload 27
    //   1065: ldc_w 669
    //   1068: invokevirtual 571	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1071: ifne +166 -> 1237
    //   1074: aload 21
    //   1076: aload 27
    //   1078: invokestatic 641	com/tencent/oskplayer/util/PlayerUtils:getAbsoluteUrl	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1081: astore 21
    //   1083: aload 4
    //   1085: invokevirtual 644	com/tencent/oskplayer/proxy/VideoRequest:getDataSourceType	()Ljava/lang/String;
    //   1088: astore 20
    //   1090: aload 4
    //   1092: invokevirtual 648	com/tencent/oskplayer/proxy/VideoRequest:getExtraHeader	()Lcom/tencent/oskplayer/datasource/HttpHeader;
    //   1095: astore 26
    //   1097: ldc_w 667
    //   1100: astore 24
    //   1102: aload 18
    //   1104: astore 25
    //   1106: aload_0
    //   1107: aload 21
    //   1109: iconst_0
    //   1110: iconst_0
    //   1111: aload 20
    //   1113: ldc 76
    //   1115: bipush 90
    //   1117: aload 26
    //   1119: invokevirtual 654	com/tencent/oskplayer/proxy/VideoProxy:getUrl	(Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;ILcom/tencent/oskplayer/datasource/HttpHeader;)Ljava/lang/String;
    //   1122: astore 26
    //   1124: aload 26
    //   1126: astore 20
    //   1128: aload 4
    //   1130: invokevirtual 513	com/tencent/oskplayer/proxy/VideoRequest:getUuid	()Ljava/lang/String;
    //   1133: ifnull +80 -> 1213
    //   1136: new 258	java/lang/StringBuilder
    //   1139: dup
    //   1140: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   1143: astore 20
    //   1145: aload 20
    //   1147: aload 26
    //   1149: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1152: pop
    //   1153: aload 20
    //   1155: ldc_w 656
    //   1158: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1161: pop
    //   1162: aload 20
    //   1164: aload 4
    //   1166: invokevirtual 513	com/tencent/oskplayer/proxy/VideoRequest:getUuid	()Ljava/lang/String;
    //   1169: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1172: pop
    //   1173: aload 20
    //   1175: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1178: astore 20
    //   1180: new 258	java/lang/StringBuilder
    //   1183: dup
    //   1184: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   1187: astore 26
    //   1189: aload 26
    //   1191: aload 20
    //   1193: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1196: pop
    //   1197: aload 26
    //   1199: ldc_w 671
    //   1202: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1205: pop
    //   1206: aload 26
    //   1208: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1211: astore 20
    //   1213: aload 25
    //   1215: aload 20
    //   1217: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1220: pop
    //   1221: aload 25
    //   1223: ldc_w 660
    //   1226: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1229: pop
    //   1230: aload 24
    //   1232: astore 20
    //   1234: goto +2165 -> 3399
    //   1237: ldc_w 667
    //   1240: astore 20
    //   1242: aload 18
    //   1244: astore 21
    //   1246: aload 21
    //   1248: aload 27
    //   1250: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1253: pop
    //   1254: aload 21
    //   1256: ldc_w 660
    //   1259: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1262: pop
    //   1263: aconst_null
    //   1264: astore 21
    //   1266: goto +2133 -> 3399
    //   1269: aload_1
    //   1270: astore 20
    //   1272: aload 27
    //   1274: ldc_w 565
    //   1277: invokevirtual 571	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1280: ifne +150 -> 1430
    //   1283: aload 27
    //   1285: aload 25
    //   1287: invokevirtual 665	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1290: ifne +13 -> 1303
    //   1293: aload 27
    //   1295: aload 24
    //   1297: invokevirtual 665	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1300: ifeq +130 -> 1430
    //   1303: aload 18
    //   1305: ifnull +116 -> 1421
    //   1308: iload 11
    //   1310: iload 7
    //   1312: if_icmpge +106 -> 1418
    //   1315: aload 21
    //   1317: invokestatic 238	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1320: ifne +98 -> 1418
    //   1323: aload_0
    //   1324: aload 21
    //   1326: iconst_1
    //   1327: iconst_1
    //   1328: aload 4
    //   1330: invokevirtual 644	com/tencent/oskplayer/proxy/VideoRequest:getDataSourceType	()Ljava/lang/String;
    //   1333: ldc 76
    //   1335: bipush 10
    //   1337: aload 4
    //   1339: invokevirtual 648	com/tencent/oskplayer/proxy/VideoRequest:getExtraHeader	()Lcom/tencent/oskplayer/datasource/HttpHeader;
    //   1342: invokevirtual 654	com/tencent/oskplayer/proxy/VideoProxy:getUrl	(Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;ILcom/tencent/oskplayer/datasource/HttpHeader;)Ljava/lang/String;
    //   1345: astore 24
    //   1347: new 258	java/lang/StringBuilder
    //   1350: dup
    //   1351: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   1354: astore 25
    //   1356: aload 25
    //   1358: ldc_w 673
    //   1361: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1364: pop
    //   1365: aload 25
    //   1367: aload 24
    //   1369: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1372: pop
    //   1373: iconst_4
    //   1374: aload 20
    //   1376: aload 25
    //   1378: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1381: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   1384: new 675	com/tencent/oskplayer/proxy/VideoProxy$PreloadInfo
    //   1387: dup
    //   1388: invokespecial 676	com/tencent/oskplayer/proxy/VideoProxy$PreloadInfo:<init>	()V
    //   1391: astore 25
    //   1393: aload 25
    //   1395: aload 24
    //   1397: putfield 679	com/tencent/oskplayer/proxy/VideoProxy$PreloadInfo:localUrl	Ljava/lang/String;
    //   1400: aload 25
    //   1402: aload 21
    //   1404: putfield 682	com/tencent/oskplayer/proxy/VideoProxy$PreloadInfo:originalUrl	Ljava/lang/String;
    //   1407: aload 18
    //   1409: aload 25
    //   1411: invokevirtual 685	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1414: pop
    //   1415: goto +6 -> 1421
    //   1418: goto +3 -> 1421
    //   1421: iload 11
    //   1423: iconst_1
    //   1424: iadd
    //   1425: istore 11
    //   1427: goto +3 -> 1430
    //   1430: aload 19
    //   1432: astore 21
    //   1434: aload 20
    //   1436: astore_1
    //   1437: iload 9
    //   1439: istore 6
    //   1441: aload 18
    //   1443: astore 19
    //   1445: aload 21
    //   1447: astore 18
    //   1449: goto -1051 -> 398
    //   1452: astore_3
    //   1453: goto +15 -> 1468
    //   1456: astore_3
    //   1457: goto +32 -> 1489
    //   1460: astore_3
    //   1461: goto +42 -> 1503
    //   1464: goto +52 -> 1516
    //   1467: astore_3
    //   1468: aload 17
    //   1470: astore 4
    //   1472: aload_2
    //   1473: astore 17
    //   1475: iconst_0
    //   1476: istore 5
    //   1478: aload_1
    //   1479: astore_2
    //   1480: aload_3
    //   1481: astore_1
    //   1482: aload 17
    //   1484: astore_3
    //   1485: goto +1691 -> 3176
    //   1488: astore_3
    //   1489: aload 17
    //   1491: astore 18
    //   1493: aload_3
    //   1494: astore 17
    //   1496: aload 18
    //   1498: astore_3
    //   1499: goto +1164 -> 2663
    //   1502: astore_3
    //   1503: aload 17
    //   1505: astore 18
    //   1507: aload_3
    //   1508: astore 17
    //   1510: aload 18
    //   1512: astore_3
    //   1513: goto +1410 -> 2923
    //   1516: aload 19
    //   1518: astore 23
    //   1520: aload 16
    //   1522: astore 22
    //   1524: aload 17
    //   1526: astore 20
    //   1528: aload_2
    //   1529: astore 19
    //   1531: aload_1
    //   1532: astore 21
    //   1534: aload 4
    //   1536: invokevirtual 560	com/tencent/oskplayer/proxy/VideoRequest:shouldCancel	()Z
    //   1539: istore 13
    //   1541: iload 13
    //   1543: ifne +787 -> 2330
    //   1546: aload 23
    //   1548: ifnull +32 -> 1580
    //   1551: invokestatic 176	com/tencent/oskplayer/PlayerConfig:g	()Lcom/tencent/oskplayer/PlayerConfig;
    //   1554: invokevirtual 688	com/tencent/oskplayer/PlayerConfig:isEnableProxy	()Z
    //   1557: ifeq +23 -> 1580
    //   1560: aload 4
    //   1562: invokevirtual 560	com/tencent/oskplayer/proxy/VideoRequest:shouldCancel	()Z
    //   1565: ifne +15 -> 1580
    //   1568: aload_0
    //   1569: aload 23
    //   1571: ldc_w 690
    //   1574: invokespecial 694	com/tencent/oskplayer/proxy/VideoProxy:preloadMediasAsync	(Ljava/util/ArrayList;Ljava/lang/String;)V
    //   1577: goto +3 -> 1580
    //   1580: iload 10
    //   1582: ifeq +387 -> 1969
    //   1585: aload 4
    //   1587: invokevirtual 513	com/tencent/oskplayer/proxy/VideoRequest:getUuid	()Ljava/lang/String;
    //   1590: astore 23
    //   1592: aload_0
    //   1593: getfield 166	com/tencent/oskplayer/proxy/VideoProxy:mLivePlayListInfo	Ljava/util/Map;
    //   1596: aload 23
    //   1598: invokeinterface 585 2 0
    //   1603: ifne +22 -> 1625
    //   1606: aload_0
    //   1607: getfield 166	com/tencent/oskplayer/proxy/VideoProxy:mLivePlayListInfo	Ljava/util/Map;
    //   1610: aload 23
    //   1612: new 696	com/tencent/oskplayer/proxy/LivePlayListInfo
    //   1615: dup
    //   1616: invokespecial 697	com/tencent/oskplayer/proxy/LivePlayListInfo:<init>	()V
    //   1619: invokeinterface 593 3 0
    //   1624: pop
    //   1625: aload_0
    //   1626: getfield 166	com/tencent/oskplayer/proxy/VideoProxy:mLivePlayListInfo	Ljava/util/Map;
    //   1629: aload 23
    //   1631: invokeinterface 701 2 0
    //   1636: checkcast 696	com/tencent/oskplayer/proxy/LivePlayListInfo
    //   1639: astore 23
    //   1641: iload 5
    //   1643: iconst_m1
    //   1644: if_icmpeq +314 -> 1958
    //   1647: iload 6
    //   1649: iconst_m1
    //   1650: if_icmpeq +297 -> 1947
    //   1653: aload 23
    //   1655: getfield 704	com/tencent/oskplayer/proxy/LivePlayListInfo:mMaxMediaSequence	I
    //   1658: iconst_m1
    //   1659: if_icmpne +85 -> 1744
    //   1662: aload_0
    //   1663: getfield 170	com/tencent/oskplayer/proxy/VideoProxy:mErrorLivePlayListInfo	Ljava/util/Map;
    //   1666: aload_3
    //   1667: invokeinterface 701 2 0
    //   1672: ifnull +21 -> 1693
    //   1675: aload_0
    //   1676: getfield 170	com/tencent/oskplayer/proxy/VideoProxy:mErrorLivePlayListInfo	Ljava/util/Map;
    //   1679: aload_3
    //   1680: invokeinterface 701 2 0
    //   1685: checkcast 696	com/tencent/oskplayer/proxy/LivePlayListInfo
    //   1688: getfield 704	com/tencent/oskplayer/proxy/LivePlayListInfo:mMaxMediaSequence	I
    //   1691: istore 6
    //   1693: new 258	java/lang/StringBuilder
    //   1696: dup
    //   1697: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   1700: astore_3
    //   1701: aload_3
    //   1702: ldc_w 706
    //   1705: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1708: pop
    //   1709: aload_3
    //   1710: iload 5
    //   1712: invokevirtual 430	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1715: pop
    //   1716: iconst_3
    //   1717: aload 21
    //   1719: aload_3
    //   1720: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1723: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   1726: aload 23
    //   1728: iload 5
    //   1730: putfield 704	com/tencent/oskplayer/proxy/LivePlayListInfo:mMaxMediaSequence	I
    //   1733: aload 23
    //   1735: invokestatic 491	java/lang/System:currentTimeMillis	()J
    //   1738: putfield 710	com/tencent/oskplayer/proxy/LivePlayListInfo:mUpdateMediaSequenceTimestamp	J
    //   1741: goto +228 -> 1969
    //   1744: iload 5
    //   1746: aload 23
    //   1748: getfield 704	com/tencent/oskplayer/proxy/LivePlayListInfo:mMaxMediaSequence	I
    //   1751: if_icmplt +121 -> 1872
    //   1754: iload 5
    //   1756: aload 23
    //   1758: getfield 704	com/tencent/oskplayer/proxy/LivePlayListInfo:mMaxMediaSequence	I
    //   1761: if_icmpne +93 -> 1854
    //   1764: invokestatic 491	java/lang/System:currentTimeMillis	()J
    //   1767: aload 23
    //   1769: getfield 710	com/tencent/oskplayer/proxy/LivePlayListInfo:mUpdateMediaSequenceTimestamp	J
    //   1772: lsub
    //   1773: lstore 14
    //   1775: lload 14
    //   1777: iload 6
    //   1779: sipush 1000
    //   1782: imul
    //   1783: i2l
    //   1784: lcmp
    //   1785: ifgt +6 -> 1791
    //   1788: goto +181 -> 1969
    //   1791: aload_0
    //   1792: getfield 170	com/tencent/oskplayer/proxy/VideoProxy:mErrorLivePlayListInfo	Ljava/util/Map;
    //   1795: aload_3
    //   1796: aload 23
    //   1798: invokeinterface 593 3 0
    //   1803: pop
    //   1804: new 258	java/lang/StringBuilder
    //   1807: dup
    //   1808: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   1811: astore_3
    //   1812: aload_3
    //   1813: ldc_w 712
    //   1816: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1819: pop
    //   1820: aload_3
    //   1821: lload 14
    //   1823: invokevirtual 268	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1826: pop
    //   1827: aload_3
    //   1828: ldc_w 714
    //   1831: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1834: pop
    //   1835: aload_3
    //   1836: iload 6
    //   1838: invokevirtual 430	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1841: pop
    //   1842: new 476	com/tencent/oskplayer/proxy/LivePlayListException
    //   1845: dup
    //   1846: aload_3
    //   1847: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1850: invokespecial 715	com/tencent/oskplayer/proxy/LivePlayListException:<init>	(Ljava/lang/String;)V
    //   1853: athrow
    //   1854: aload 23
    //   1856: iload 5
    //   1858: putfield 704	com/tencent/oskplayer/proxy/LivePlayListInfo:mMaxMediaSequence	I
    //   1861: aload 23
    //   1863: invokestatic 491	java/lang/System:currentTimeMillis	()J
    //   1866: putfield 710	com/tencent/oskplayer/proxy/LivePlayListInfo:mUpdateMediaSequenceTimestamp	J
    //   1869: goto +100 -> 1969
    //   1872: new 258	java/lang/StringBuilder
    //   1875: dup
    //   1876: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   1879: astore 18
    //   1881: aload 18
    //   1883: ldc_w 717
    //   1886: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1889: pop
    //   1890: aload 18
    //   1892: aload 23
    //   1894: getfield 704	com/tencent/oskplayer/proxy/LivePlayListInfo:mMaxMediaSequence	I
    //   1897: invokevirtual 430	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1900: pop
    //   1901: aload 18
    //   1903: ldc_w 719
    //   1906: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1909: pop
    //   1910: aload 18
    //   1912: iload 5
    //   1914: invokevirtual 430	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1917: pop
    //   1918: aload 18
    //   1920: ldc_w 721
    //   1923: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1926: pop
    //   1927: aload 18
    //   1929: aload_3
    //   1930: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1933: pop
    //   1934: new 476	com/tencent/oskplayer/proxy/LivePlayListException
    //   1937: dup
    //   1938: aload 18
    //   1940: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1943: invokespecial 715	com/tencent/oskplayer/proxy/LivePlayListException:<init>	(Ljava/lang/String;)V
    //   1946: athrow
    //   1947: new 476	com/tencent/oskplayer/proxy/LivePlayListException
    //   1950: dup
    //   1951: ldc_w 723
    //   1954: invokespecial 715	com/tencent/oskplayer/proxy/LivePlayListException:<init>	(Ljava/lang/String;)V
    //   1957: athrow
    //   1958: new 476	com/tencent/oskplayer/proxy/LivePlayListException
    //   1961: dup
    //   1962: ldc_w 725
    //   1965: invokespecial 715	com/tencent/oskplayer/proxy/LivePlayListException:<init>	(Ljava/lang/String;)V
    //   1968: athrow
    //   1969: iconst_4
    //   1970: aload 21
    //   1972: ldc_w 727
    //   1975: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   1978: aload 18
    //   1980: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1983: astore_3
    //   1984: iload 8
    //   1986: ifeq +18 -> 2004
    //   1989: invokestatic 176	com/tencent/oskplayer/PlayerConfig:g	()Lcom/tencent/oskplayer/PlayerConfig;
    //   1992: invokevirtual 730	com/tencent/oskplayer/PlayerConfig:isEnableHLSCache	()Z
    //   1995: ifeq +9 -> 2004
    //   1998: ldc 58
    //   2000: astore_1
    //   2001: goto +6 -> 2007
    //   2004: ldc 61
    //   2006: astore_1
    //   2007: aload_3
    //   2008: ldc 67
    //   2010: aload_1
    //   2011: invokevirtual 733	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   2014: astore_1
    //   2015: iconst_4
    //   2016: aload 21
    //   2018: ldc_w 735
    //   2021: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2024: iconst_4
    //   2025: aload 21
    //   2027: aload_1
    //   2028: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2031: iconst_4
    //   2032: aload 21
    //   2034: ldc_w 737
    //   2037: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2040: aload_1
    //   2041: invokevirtual 741	java/lang/String:getBytes	()[B
    //   2044: astore_1
    //   2045: aload 22
    //   2047: aload_1
    //   2048: invokevirtual 747	java/io/OutputStream:write	([B)V
    //   2051: aload 20
    //   2053: invokevirtual 750	java/io/BufferedReader:close	()V
    //   2056: iconst_0
    //   2057: istore 5
    //   2059: goto +43 -> 2102
    //   2062: astore_1
    //   2063: new 258	java/lang/StringBuilder
    //   2066: dup
    //   2067: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   2070: astore_2
    //   2071: aload_2
    //   2072: ldc_w 752
    //   2075: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2078: pop
    //   2079: aload_2
    //   2080: aload_1
    //   2081: invokestatic 395	com/tencent/oskplayer/util/PlayerUtils:getPrintableStackTrace	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   2084: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2087: pop
    //   2088: bipush 6
    //   2090: aload 21
    //   2092: aload_2
    //   2093: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2096: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2099: iconst_1
    //   2100: istore 5
    //   2102: aload 22
    //   2104: invokevirtual 753	java/io/OutputStream:close	()V
    //   2107: goto +43 -> 2150
    //   2110: astore_1
    //   2111: new 258	java/lang/StringBuilder
    //   2114: dup
    //   2115: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   2118: astore_2
    //   2119: aload_2
    //   2120: ldc_w 755
    //   2123: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2126: pop
    //   2127: aload_2
    //   2128: aload_1
    //   2129: invokestatic 395	com/tencent/oskplayer/util/PlayerUtils:getPrintableStackTrace	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   2132: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2135: pop
    //   2136: bipush 6
    //   2138: aload 21
    //   2140: aload_2
    //   2141: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2144: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2147: iconst_1
    //   2148: istore 5
    //   2150: iload 12
    //   2152: ifne +76 -> 2228
    //   2155: aload 4
    //   2157: invokevirtual 560	com/tencent/oskplayer/proxy/VideoRequest:shouldCancel	()Z
    //   2160: ifeq +8 -> 2168
    //   2163: aload 4
    //   2165: invokevirtual 758	com/tencent/oskplayer/proxy/VideoRequest:enterCancelProceedState	()V
    //   2168: aload 19
    //   2170: invokevirtual 499	java/io/File:exists	()Z
    //   2173: ifeq +53 -> 2226
    //   2176: aload 19
    //   2178: invokevirtual 761	java/io/File:isFile	()Z
    //   2181: ifeq +45 -> 2226
    //   2184: aload 19
    //   2186: invokevirtual 764	java/io/File:delete	()Z
    //   2189: pop
    //   2190: new 258	java/lang/StringBuilder
    //   2193: dup
    //   2194: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   2197: astore_1
    //   2198: aload_1
    //   2199: ldc_w 766
    //   2202: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2205: pop
    //   2206: aload_1
    //   2207: aload 19
    //   2209: invokevirtual 767	java/io/File:toString	()Ljava/lang/String;
    //   2212: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2215: pop
    //   2216: iconst_4
    //   2217: aload 21
    //   2219: aload_1
    //   2220: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2223: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2226: aconst_null
    //   2227: areturn
    //   2228: iload 5
    //   2230: ifeq +63 -> 2293
    //   2233: aload 19
    //   2235: invokevirtual 499	java/io/File:exists	()Z
    //   2238: ifeq +53 -> 2291
    //   2241: aload 19
    //   2243: invokevirtual 761	java/io/File:isFile	()Z
    //   2246: ifeq +45 -> 2291
    //   2249: aload 19
    //   2251: invokevirtual 764	java/io/File:delete	()Z
    //   2254: pop
    //   2255: new 258	java/lang/StringBuilder
    //   2258: dup
    //   2259: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   2262: astore_1
    //   2263: aload_1
    //   2264: ldc_w 766
    //   2267: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2270: pop
    //   2271: aload_1
    //   2272: aload 19
    //   2274: invokevirtual 767	java/io/File:toString	()Ljava/lang/String;
    //   2277: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2280: pop
    //   2281: iconst_4
    //   2282: aload 21
    //   2284: aload_1
    //   2285: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2288: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2291: aconst_null
    //   2292: areturn
    //   2293: aload 19
    //   2295: areturn
    //   2296: astore_1
    //   2297: aload 21
    //   2299: astore_2
    //   2300: aload 19
    //   2302: astore_3
    //   2303: aload 20
    //   2305: astore 4
    //   2307: goto +193 -> 2500
    //   2310: astore_1
    //   2311: aload 19
    //   2313: astore_2
    //   2314: aload 20
    //   2316: astore_3
    //   2317: goto +208 -> 2525
    //   2320: astore_1
    //   2321: aload 19
    //   2323: astore_2
    //   2324: aload 20
    //   2326: astore_3
    //   2327: goto +226 -> 2553
    //   2330: new 476	com/tencent/oskplayer/proxy/LivePlayListException
    //   2333: dup
    //   2334: ldc_w 769
    //   2337: invokespecial 715	com/tencent/oskplayer/proxy/LivePlayListException:<init>	(Ljava/lang/String;)V
    //   2340: athrow
    //   2341: astore_1
    //   2342: aload 21
    //   2344: astore_2
    //   2345: aload 19
    //   2347: astore_3
    //   2348: aload 20
    //   2350: astore 4
    //   2352: goto +148 -> 2500
    //   2355: astore_1
    //   2356: aload 19
    //   2358: astore_2
    //   2359: aload 20
    //   2361: astore_3
    //   2362: goto +163 -> 2525
    //   2365: astore_1
    //   2366: aload 19
    //   2368: astore_2
    //   2369: aload 20
    //   2371: astore_3
    //   2372: goto +181 -> 2553
    //   2375: astore_1
    //   2376: aload 21
    //   2378: astore_2
    //   2379: aload 19
    //   2381: astore_3
    //   2382: aload 20
    //   2384: astore 4
    //   2386: aload 22
    //   2388: astore 16
    //   2390: goto +783 -> 3173
    //   2393: astore 17
    //   2395: aload 21
    //   2397: astore_1
    //   2398: aload 19
    //   2400: astore_2
    //   2401: aload 20
    //   2403: astore_3
    //   2404: aload 22
    //   2406: astore 16
    //   2408: goto +255 -> 2663
    //   2411: astore 17
    //   2413: aload 21
    //   2415: astore_1
    //   2416: aload 19
    //   2418: astore_2
    //   2419: aload 20
    //   2421: astore_3
    //   2422: aload 22
    //   2424: astore 16
    //   2426: goto +497 -> 2923
    //   2429: astore 18
    //   2431: aload 17
    //   2433: astore 4
    //   2435: aload_2
    //   2436: astore_3
    //   2437: aload_1
    //   2438: astore_2
    //   2439: aload 18
    //   2441: astore_1
    //   2442: aload 16
    //   2444: astore 22
    //   2446: goto +54 -> 2500
    //   2449: astore 18
    //   2451: aload 17
    //   2453: astore_3
    //   2454: aload_1
    //   2455: astore 21
    //   2457: aload 18
    //   2459: astore_1
    //   2460: aload 16
    //   2462: astore 22
    //   2464: goto +61 -> 2525
    //   2467: astore 18
    //   2469: aload 17
    //   2471: astore_3
    //   2472: aload_1
    //   2473: astore 21
    //   2475: aload 18
    //   2477: astore_1
    //   2478: aload 16
    //   2480: astore 22
    //   2482: goto +71 -> 2553
    //   2485: astore_1
    //   2486: aload 20
    //   2488: astore 4
    //   2490: aload 19
    //   2492: astore_3
    //   2493: aload 17
    //   2495: astore_2
    //   2496: aload 16
    //   2498: astore 22
    //   2500: iconst_0
    //   2501: istore 5
    //   2503: aload 22
    //   2505: astore 16
    //   2507: goto +669 -> 3176
    //   2510: astore_1
    //   2511: aload 20
    //   2513: astore_3
    //   2514: aload 19
    //   2516: astore_2
    //   2517: aload 17
    //   2519: astore 21
    //   2521: aload 16
    //   2523: astore 22
    //   2525: aload 22
    //   2527: astore 16
    //   2529: aload_1
    //   2530: astore 17
    //   2532: aload 21
    //   2534: astore_1
    //   2535: goto +128 -> 2663
    //   2538: astore_1
    //   2539: aload 20
    //   2541: astore_3
    //   2542: aload 19
    //   2544: astore_2
    //   2545: aload 17
    //   2547: astore 21
    //   2549: aload 16
    //   2551: astore 22
    //   2553: aload 22
    //   2555: astore 16
    //   2557: aload_1
    //   2558: astore 17
    //   2560: aload 21
    //   2562: astore_1
    //   2563: goto +360 -> 2923
    //   2566: astore_1
    //   2567: aload 20
    //   2569: astore 4
    //   2571: aload 19
    //   2573: astore_3
    //   2574: aload 17
    //   2576: astore_2
    //   2577: iconst_0
    //   2578: istore 5
    //   2580: aconst_null
    //   2581: astore 16
    //   2583: goto +593 -> 3176
    //   2586: astore 16
    //   2588: aload 20
    //   2590: astore_3
    //   2591: aload 19
    //   2593: astore_2
    //   2594: aload 17
    //   2596: astore_1
    //   2597: aload 16
    //   2599: astore 17
    //   2601: aconst_null
    //   2602: astore 16
    //   2604: goto +59 -> 2663
    //   2607: astore 16
    //   2609: aload 20
    //   2611: astore_3
    //   2612: aload 19
    //   2614: astore_2
    //   2615: aload 17
    //   2617: astore_1
    //   2618: aload 16
    //   2620: astore 17
    //   2622: aconst_null
    //   2623: astore 16
    //   2625: goto +298 -> 2923
    //   2628: astore_1
    //   2629: aload 19
    //   2631: astore_3
    //   2632: aload 17
    //   2634: astore_2
    //   2635: iconst_0
    //   2636: istore 5
    //   2638: aconst_null
    //   2639: astore 4
    //   2641: aload 4
    //   2643: astore 16
    //   2645: goto +531 -> 3176
    //   2648: astore_3
    //   2649: aload 19
    //   2651: astore_2
    //   2652: aload 17
    //   2654: astore_1
    //   2655: aload_3
    //   2656: astore 17
    //   2658: aconst_null
    //   2659: astore_3
    //   2660: aload_3
    //   2661: astore 16
    //   2663: aload_1
    //   2664: astore 18
    //   2666: aload_2
    //   2667: astore 19
    //   2669: aload_3
    //   2670: astore 20
    //   2672: aload 16
    //   2674: astore 21
    //   2676: aload 4
    //   2678: invokevirtual 560	com/tencent/oskplayer/proxy/VideoRequest:shouldCancel	()Z
    //   2681: ifeq +180 -> 2861
    //   2684: aload_1
    //   2685: astore 18
    //   2687: aload_2
    //   2688: astore 19
    //   2690: aload_3
    //   2691: astore 20
    //   2693: aload 16
    //   2695: astore 21
    //   2697: aload 4
    //   2699: invokevirtual 758	com/tencent/oskplayer/proxy/VideoRequest:enterCancelProceedState	()V
    //   2702: aload_3
    //   2703: ifnull +50 -> 2753
    //   2706: aload_3
    //   2707: invokevirtual 750	java/io/BufferedReader:close	()V
    //   2710: goto +43 -> 2753
    //   2713: astore_3
    //   2714: new 258	java/lang/StringBuilder
    //   2717: dup
    //   2718: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   2721: astore 4
    //   2723: aload 4
    //   2725: ldc_w 752
    //   2728: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2731: pop
    //   2732: aload 4
    //   2734: aload_3
    //   2735: invokestatic 395	com/tencent/oskplayer/util/PlayerUtils:getPrintableStackTrace	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   2738: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2741: pop
    //   2742: bipush 6
    //   2744: aload_1
    //   2745: aload 4
    //   2747: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2750: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2753: aload 16
    //   2755: ifnull +51 -> 2806
    //   2758: aload 16
    //   2760: invokevirtual 753	java/io/OutputStream:close	()V
    //   2763: goto +43 -> 2806
    //   2766: astore_3
    //   2767: new 258	java/lang/StringBuilder
    //   2770: dup
    //   2771: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   2774: astore 4
    //   2776: aload 4
    //   2778: ldc_w 755
    //   2781: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2784: pop
    //   2785: aload 4
    //   2787: aload_3
    //   2788: invokestatic 395	com/tencent/oskplayer/util/PlayerUtils:getPrintableStackTrace	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   2791: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2794: pop
    //   2795: bipush 6
    //   2797: aload_1
    //   2798: aload 4
    //   2800: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2803: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2806: aload_2
    //   2807: invokevirtual 499	java/io/File:exists	()Z
    //   2810: ifeq +49 -> 2859
    //   2813: aload_2
    //   2814: invokevirtual 761	java/io/File:isFile	()Z
    //   2817: ifeq +42 -> 2859
    //   2820: aload_2
    //   2821: invokevirtual 764	java/io/File:delete	()Z
    //   2824: pop
    //   2825: new 258	java/lang/StringBuilder
    //   2828: dup
    //   2829: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   2832: astore_3
    //   2833: aload_3
    //   2834: ldc_w 766
    //   2837: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2840: pop
    //   2841: aload_3
    //   2842: aload_2
    //   2843: invokevirtual 767	java/io/File:toString	()Ljava/lang/String;
    //   2846: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2849: pop
    //   2850: iconst_4
    //   2851: aload_1
    //   2852: aload_3
    //   2853: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2856: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2859: aconst_null
    //   2860: areturn
    //   2861: aload_1
    //   2862: astore 4
    //   2864: aload_2
    //   2865: astore 18
    //   2867: aload_3
    //   2868: astore 19
    //   2870: aload 16
    //   2872: astore 20
    //   2874: bipush 6
    //   2876: aload_1
    //   2877: aload 17
    //   2879: invokestatic 395	com/tencent/oskplayer/util/PlayerUtils:getPrintableStackTrace	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   2882: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2885: aload_1
    //   2886: astore 4
    //   2888: aload_2
    //   2889: astore 18
    //   2891: aload_3
    //   2892: astore 19
    //   2894: aload 16
    //   2896: astore 20
    //   2898: new 476	com/tencent/oskplayer/proxy/LivePlayListException
    //   2901: dup
    //   2902: aload 17
    //   2904: invokespecial 772	com/tencent/oskplayer/proxy/LivePlayListException:<init>	(Ljava/lang/Throwable;)V
    //   2907: athrow
    //   2908: astore_3
    //   2909: aload 19
    //   2911: astore_2
    //   2912: aload 17
    //   2914: astore_1
    //   2915: aload_3
    //   2916: astore 17
    //   2918: aconst_null
    //   2919: astore_3
    //   2920: aload_3
    //   2921: astore 16
    //   2923: aload_1
    //   2924: astore 18
    //   2926: aload_2
    //   2927: astore 19
    //   2929: aload_3
    //   2930: astore 20
    //   2932: aload 16
    //   2934: astore 21
    //   2936: aload 4
    //   2938: invokevirtual 560	com/tencent/oskplayer/proxy/VideoRequest:shouldCancel	()Z
    //   2941: ifeq +180 -> 3121
    //   2944: aload_1
    //   2945: astore 18
    //   2947: aload_2
    //   2948: astore 19
    //   2950: aload_3
    //   2951: astore 20
    //   2953: aload 16
    //   2955: astore 21
    //   2957: aload 4
    //   2959: invokevirtual 758	com/tencent/oskplayer/proxy/VideoRequest:enterCancelProceedState	()V
    //   2962: aload_3
    //   2963: ifnull +50 -> 3013
    //   2966: aload_3
    //   2967: invokevirtual 750	java/io/BufferedReader:close	()V
    //   2970: goto +43 -> 3013
    //   2973: astore_3
    //   2974: new 258	java/lang/StringBuilder
    //   2977: dup
    //   2978: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   2981: astore 4
    //   2983: aload 4
    //   2985: ldc_w 752
    //   2988: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2991: pop
    //   2992: aload 4
    //   2994: aload_3
    //   2995: invokestatic 395	com/tencent/oskplayer/util/PlayerUtils:getPrintableStackTrace	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   2998: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3001: pop
    //   3002: bipush 6
    //   3004: aload_1
    //   3005: aload 4
    //   3007: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3010: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   3013: aload 16
    //   3015: ifnull +51 -> 3066
    //   3018: aload 16
    //   3020: invokevirtual 753	java/io/OutputStream:close	()V
    //   3023: goto +43 -> 3066
    //   3026: astore_3
    //   3027: new 258	java/lang/StringBuilder
    //   3030: dup
    //   3031: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   3034: astore 4
    //   3036: aload 4
    //   3038: ldc_w 755
    //   3041: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3044: pop
    //   3045: aload 4
    //   3047: aload_3
    //   3048: invokestatic 395	com/tencent/oskplayer/util/PlayerUtils:getPrintableStackTrace	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   3051: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3054: pop
    //   3055: bipush 6
    //   3057: aload_1
    //   3058: aload 4
    //   3060: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3063: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   3066: aload_2
    //   3067: invokevirtual 499	java/io/File:exists	()Z
    //   3070: ifeq +49 -> 3119
    //   3073: aload_2
    //   3074: invokevirtual 761	java/io/File:isFile	()Z
    //   3077: ifeq +42 -> 3119
    //   3080: aload_2
    //   3081: invokevirtual 764	java/io/File:delete	()Z
    //   3084: pop
    //   3085: new 258	java/lang/StringBuilder
    //   3088: dup
    //   3089: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   3092: astore_3
    //   3093: aload_3
    //   3094: ldc_w 766
    //   3097: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3100: pop
    //   3101: aload_3
    //   3102: aload_2
    //   3103: invokevirtual 767	java/io/File:toString	()Ljava/lang/String;
    //   3106: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3109: pop
    //   3110: iconst_4
    //   3111: aload_1
    //   3112: aload_3
    //   3113: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3116: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   3119: aconst_null
    //   3120: areturn
    //   3121: aload_1
    //   3122: astore 4
    //   3124: aload_2
    //   3125: astore 18
    //   3127: aload_3
    //   3128: astore 19
    //   3130: aload 16
    //   3132: astore 20
    //   3134: aload 17
    //   3136: athrow
    //   3137: astore_1
    //   3138: iconst_1
    //   3139: istore 5
    //   3141: aload 4
    //   3143: astore_2
    //   3144: aload 18
    //   3146: astore_3
    //   3147: aload 19
    //   3149: astore 4
    //   3151: aload 20
    //   3153: astore 16
    //   3155: goto +21 -> 3176
    //   3158: astore_1
    //   3159: aload 21
    //   3161: astore 16
    //   3163: aload 20
    //   3165: astore 4
    //   3167: aload 19
    //   3169: astore_3
    //   3170: aload 18
    //   3172: astore_2
    //   3173: iconst_0
    //   3174: istore 5
    //   3176: aload 4
    //   3178: ifnull +53 -> 3231
    //   3181: aload 4
    //   3183: invokevirtual 750	java/io/BufferedReader:close	()V
    //   3186: goto +45 -> 3231
    //   3189: astore 4
    //   3191: new 258	java/lang/StringBuilder
    //   3194: dup
    //   3195: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   3198: astore 17
    //   3200: aload 17
    //   3202: ldc_w 752
    //   3205: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3208: pop
    //   3209: aload 17
    //   3211: aload 4
    //   3213: invokestatic 395	com/tencent/oskplayer/util/PlayerUtils:getPrintableStackTrace	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   3216: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3219: pop
    //   3220: bipush 6
    //   3222: aload_2
    //   3223: aload 17
    //   3225: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3228: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   3231: aload 16
    //   3233: ifnull +53 -> 3286
    //   3236: aload 16
    //   3238: invokevirtual 753	java/io/OutputStream:close	()V
    //   3241: goto +45 -> 3286
    //   3244: astore 4
    //   3246: new 258	java/lang/StringBuilder
    //   3249: dup
    //   3250: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   3253: astore 16
    //   3255: aload 16
    //   3257: ldc_w 755
    //   3260: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3263: pop
    //   3264: aload 16
    //   3266: aload 4
    //   3268: invokestatic 395	com/tencent/oskplayer/util/PlayerUtils:getPrintableStackTrace	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   3271: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3274: pop
    //   3275: bipush 6
    //   3277: aload_2
    //   3278: aload 16
    //   3280: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3283: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   3286: iload 5
    //   3288: ifeq +60 -> 3348
    //   3291: aload_3
    //   3292: invokevirtual 499	java/io/File:exists	()Z
    //   3295: ifeq +53 -> 3348
    //   3298: aload_3
    //   3299: invokevirtual 761	java/io/File:isFile	()Z
    //   3302: ifeq +46 -> 3348
    //   3305: aload_3
    //   3306: invokevirtual 764	java/io/File:delete	()Z
    //   3309: pop
    //   3310: new 258	java/lang/StringBuilder
    //   3313: dup
    //   3314: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   3317: astore 4
    //   3319: aload 4
    //   3321: ldc_w 766
    //   3324: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3327: pop
    //   3328: aload 4
    //   3330: aload_3
    //   3331: invokevirtual 767	java/io/File:toString	()Ljava/lang/String;
    //   3334: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3337: pop
    //   3338: iconst_4
    //   3339: aload_2
    //   3340: aload 4
    //   3342: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3345: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   3348: goto +5 -> 3353
    //   3351: aload_1
    //   3352: athrow
    //   3353: goto -2 -> 3351
    //   3356: aload 18
    //   3358: astore 19
    //   3360: aconst_null
    //   3361: astore 21
    //   3363: aload 20
    //   3365: astore 18
    //   3367: ldc_w 667
    //   3370: astore 24
    //   3372: ldc_w 662
    //   3375: astore 25
    //   3377: iload 6
    //   3379: istore 10
    //   3381: goto -2112 -> 1269
    //   3384: astore_3
    //   3385: goto -1917 -> 1468
    //   3388: astore_3
    //   3389: goto -1900 -> 1489
    //   3392: astore_3
    //   3393: goto -1890 -> 1503
    //   3396: goto -2333 -> 1063
    //   3399: ldc_w 662
    //   3402: astore 25
    //   3404: aload 18
    //   3406: astore 24
    //   3408: aload 19
    //   3410: astore 18
    //   3412: aload 24
    //   3414: astore 19
    //   3416: aload 20
    //   3418: astore 24
    //   3420: goto -2151 -> 1269
    //   3423: astore_3
    //   3424: goto -1956 -> 1468
    //   3427: astore_3
    //   3428: goto -1939 -> 1489
    //   3431: astore_3
    //   3432: goto -1929 -> 1503
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3435	0	this	VideoProxy
    //   0	3435	1	paramDataSource	com.tencent.oskplayer.datasource.DataSource
    //   0	3435	2	paramDataSpec	com.tencent.oskplayer.datasource.DataSpec
    //   0	3435	3	paramString	String
    //   0	3435	4	paramVideoRequest	VideoRequest
    //   203	3084	5	i	int
    //   229	3149	6	j	int
    //   374	939	7	k	int
    //   370	1615	8	m	int
    //   357	1081	9	n	int
    //   366	3014	10	i1	int
    //   360	1066	11	i2	int
    //   363	1788	12	i3	int
    //   408	1134	13	bool	boolean
    //   1773	49	14	l	long
    //   7	2575	16	localObject1	Object
    //   2586	12	16	localException1	Exception
    //   2602	1	16	localObject2	Object
    //   2607	12	16	localLivePlayListException1	LivePlayListException
    //   2623	656	16	localObject3	Object
    //   33	1492	17	localObject4	Object
    //   2393	1	17	localException2	Exception
    //   2411	107	17	localLivePlayListException2	LivePlayListException
    //   2530	694	17	localObject5	Object
    //   41	302	18	localObject6	Object
    //   559	6	18	localException3	Exception
    //   571	871	18	localLivePlayListException3	LivePlayListException
    //   1447	532	18	localObject7	Object
    //   2429	11	18	localObject8	Object
    //   2449	9	18	localException4	Exception
    //   2467	9	18	localLivePlayListException4	LivePlayListException
    //   2664	747	18	localObject9	Object
    //   78	3337	19	localObject10	Object
    //   322	3095	20	localObject11	Object
    //   354	3008	21	localObject12	Object
    //   216	2338	22	localObject13	Object
    //   294	1599	23	localObject14	Object
    //   400	3019	24	localObject15	Object
    //   817	2586	25	localObject16	Object
    //   840	367	26	localObject17	Object
    //   438	856	27	str	String
    // Exception table:
    //   from	to	target	type
    //   493	535	538	finally
    //   601	614	538	finally
    //   645	652	538	finally
    //   670	677	538	finally
    //   695	725	538	finally
    //   493	535	559	java/lang/Exception
    //   601	614	559	java/lang/Exception
    //   645	652	559	java/lang/Exception
    //   670	677	559	java/lang/Exception
    //   695	725	559	java/lang/Exception
    //   493	535	571	com/tencent/oskplayer/proxy/LivePlayListException
    //   601	614	571	com/tencent/oskplayer/proxy/LivePlayListException
    //   645	652	571	com/tencent/oskplayer/proxy/LivePlayListException
    //   670	677	571	com/tencent/oskplayer/proxy/LivePlayListException
    //   695	725	571	com/tencent/oskplayer/proxy/LivePlayListException
    //   445	462	1452	finally
    //   445	462	1456	java/lang/Exception
    //   445	462	1460	com/tencent/oskplayer/proxy/LivePlayListException
    //   421	429	1467	finally
    //   433	440	1467	finally
    //   421	429	1488	java/lang/Exception
    //   433	440	1488	java/lang/Exception
    //   421	429	1502	com/tencent/oskplayer/proxy/LivePlayListException
    //   433	440	1502	com/tencent/oskplayer/proxy/LivePlayListException
    //   2051	2056	2062	java/io/IOException
    //   2102	2107	2110	java/io/IOException
    //   2045	2051	2296	finally
    //   2045	2051	2310	java/lang/Exception
    //   2045	2051	2320	com/tencent/oskplayer/proxy/LivePlayListException
    //   2330	2341	2341	finally
    //   2330	2341	2355	java/lang/Exception
    //   2330	2341	2365	com/tencent/oskplayer/proxy/LivePlayListException
    //   1534	1541	2375	finally
    //   1969	1984	2375	finally
    //   2007	2045	2375	finally
    //   1534	1541	2393	java/lang/Exception
    //   1969	1984	2393	java/lang/Exception
    //   2007	2045	2393	java/lang/Exception
    //   1534	1541	2411	com/tencent/oskplayer/proxy/LivePlayListException
    //   1969	1984	2411	com/tencent/oskplayer/proxy/LivePlayListException
    //   2007	2045	2411	com/tencent/oskplayer/proxy/LivePlayListException
    //   405	410	2429	finally
    //   405	410	2449	java/lang/Exception
    //   405	410	2467	com/tencent/oskplayer/proxy/LivePlayListException
    //   335	353	2485	finally
    //   335	353	2510	java/lang/Exception
    //   335	353	2538	com/tencent/oskplayer/proxy/LivePlayListException
    //   324	335	2566	finally
    //   324	335	2586	java/lang/Exception
    //   324	335	2607	com/tencent/oskplayer/proxy/LivePlayListException
    //   296	304	2628	finally
    //   304	324	2628	finally
    //   296	304	2648	java/lang/Exception
    //   304	324	2648	java/lang/Exception
    //   2706	2710	2713	java/io/IOException
    //   2758	2763	2766	java/io/IOException
    //   296	304	2908	com/tencent/oskplayer/proxy/LivePlayListException
    //   304	324	2908	com/tencent/oskplayer/proxy/LivePlayListException
    //   2966	2970	2973	java/io/IOException
    //   3018	3023	3026	java/io/IOException
    //   2874	2885	3137	finally
    //   2898	2908	3137	finally
    //   3134	3137	3137	finally
    //   2676	2684	3158	finally
    //   2697	2702	3158	finally
    //   2936	2944	3158	finally
    //   2957	2962	3158	finally
    //   3181	3186	3189	java/io/IOException
    //   3236	3241	3244	java/io/IOException
    //   467	480	3384	finally
    //   583	596	3384	finally
    //   627	640	3384	finally
    //   652	665	3384	finally
    //   677	690	3384	finally
    //   734	842	3384	finally
    //   467	480	3388	java/lang/Exception
    //   583	596	3388	java/lang/Exception
    //   627	640	3388	java/lang/Exception
    //   652	665	3388	java/lang/Exception
    //   677	690	3388	java/lang/Exception
    //   734	842	3388	java/lang/Exception
    //   467	480	3392	com/tencent/oskplayer/proxy/LivePlayListException
    //   583	596	3392	com/tencent/oskplayer/proxy/LivePlayListException
    //   627	640	3392	com/tencent/oskplayer/proxy/LivePlayListException
    //   652	665	3392	com/tencent/oskplayer/proxy/LivePlayListException
    //   677	690	3392	com/tencent/oskplayer/proxy/LivePlayListException
    //   734	842	3392	com/tencent/oskplayer/proxy/LivePlayListException
    //   842	861	3423	finally
    //   865	950	3423	finally
    //   954	987	3423	finally
    //   994	1011	3423	finally
    //   1018	1035	3423	finally
    //   1038	1060	3423	finally
    //   1063	1097	3423	finally
    //   1106	1124	3423	finally
    //   1128	1213	3423	finally
    //   1213	1230	3423	finally
    //   1246	1263	3423	finally
    //   1272	1303	3423	finally
    //   1315	1415	3423	finally
    //   1551	1577	3423	finally
    //   1585	1625	3423	finally
    //   1625	1641	3423	finally
    //   1653	1693	3423	finally
    //   1693	1741	3423	finally
    //   1744	1775	3423	finally
    //   1791	1854	3423	finally
    //   1854	1869	3423	finally
    //   1872	1947	3423	finally
    //   1947	1958	3423	finally
    //   1958	1969	3423	finally
    //   1989	1998	3423	finally
    //   842	861	3427	java/lang/Exception
    //   865	950	3427	java/lang/Exception
    //   954	987	3427	java/lang/Exception
    //   994	1011	3427	java/lang/Exception
    //   1018	1035	3427	java/lang/Exception
    //   1038	1060	3427	java/lang/Exception
    //   1063	1097	3427	java/lang/Exception
    //   1106	1124	3427	java/lang/Exception
    //   1128	1213	3427	java/lang/Exception
    //   1213	1230	3427	java/lang/Exception
    //   1246	1263	3427	java/lang/Exception
    //   1272	1303	3427	java/lang/Exception
    //   1315	1415	3427	java/lang/Exception
    //   1551	1577	3427	java/lang/Exception
    //   1585	1625	3427	java/lang/Exception
    //   1625	1641	3427	java/lang/Exception
    //   1653	1693	3427	java/lang/Exception
    //   1693	1741	3427	java/lang/Exception
    //   1744	1775	3427	java/lang/Exception
    //   1791	1854	3427	java/lang/Exception
    //   1854	1869	3427	java/lang/Exception
    //   1872	1947	3427	java/lang/Exception
    //   1947	1958	3427	java/lang/Exception
    //   1958	1969	3427	java/lang/Exception
    //   1989	1998	3427	java/lang/Exception
    //   842	861	3431	com/tencent/oskplayer/proxy/LivePlayListException
    //   865	950	3431	com/tencent/oskplayer/proxy/LivePlayListException
    //   954	987	3431	com/tencent/oskplayer/proxy/LivePlayListException
    //   994	1011	3431	com/tencent/oskplayer/proxy/LivePlayListException
    //   1018	1035	3431	com/tencent/oskplayer/proxy/LivePlayListException
    //   1038	1060	3431	com/tencent/oskplayer/proxy/LivePlayListException
    //   1063	1097	3431	com/tencent/oskplayer/proxy/LivePlayListException
    //   1106	1124	3431	com/tencent/oskplayer/proxy/LivePlayListException
    //   1128	1213	3431	com/tencent/oskplayer/proxy/LivePlayListException
    //   1213	1230	3431	com/tencent/oskplayer/proxy/LivePlayListException
    //   1246	1263	3431	com/tencent/oskplayer/proxy/LivePlayListException
    //   1272	1303	3431	com/tencent/oskplayer/proxy/LivePlayListException
    //   1315	1415	3431	com/tencent/oskplayer/proxy/LivePlayListException
    //   1551	1577	3431	com/tencent/oskplayer/proxy/LivePlayListException
    //   1585	1625	3431	com/tencent/oskplayer/proxy/LivePlayListException
    //   1625	1641	3431	com/tencent/oskplayer/proxy/LivePlayListException
    //   1653	1693	3431	com/tencent/oskplayer/proxy/LivePlayListException
    //   1693	1741	3431	com/tencent/oskplayer/proxy/LivePlayListException
    //   1744	1775	3431	com/tencent/oskplayer/proxy/LivePlayListException
    //   1791	1854	3431	com/tencent/oskplayer/proxy/LivePlayListException
    //   1854	1869	3431	com/tencent/oskplayer/proxy/LivePlayListException
    //   1872	1947	3431	com/tencent/oskplayer/proxy/LivePlayListException
    //   1947	1958	3431	com/tencent/oskplayer/proxy/LivePlayListException
    //   1958	1969	3431	com/tencent/oskplayer/proxy/LivePlayListException
    //   1989	1998	3431	com/tencent/oskplayer/proxy/LivePlayListException
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
    if (TextUtils.isEmpty(paramString))
    {
      PlayerUtils.log(6, "VideoProxy", "getSourceUrl: httpUrl is empty");
      return paramString;
    }
    if (!paramString.contains("http://127.0.0.1")) {
      return paramString;
    }
    try
    {
      String str = Uri.parse(paramString).getQueryParameter("v");
      return str;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getSourceUrl: Exception=");
      localStringBuilder.append(localException);
      PlayerUtils.log(6, "VideoProxy", localStringBuilder.toString());
    }
    return paramString;
  }
  
  /* Error */
  private VideoProxy.DataSourceOpenResult openDataSource(com.tencent.oskplayer.datasource.DataSource paramDataSource, com.tencent.oskplayer.datasource.DataSpec paramDataSpec, String paramString1, String paramString2, VideoRequest paramVideoRequest, Socket paramSocket, String paramString3, long paramLong1, long paramLong2, long paramLong3)
  {
    // Byte code:
    //   0: new 826	com/tencent/oskplayer/proxy/VideoProxy$DataSourceOpenResult
    //   3: dup
    //   4: aload_0
    //   5: aconst_null
    //   6: invokespecial 829	com/tencent/oskplayer/proxy/VideoProxy$DataSourceOpenResult:<init>	(Lcom/tencent/oskplayer/proxy/VideoProxy;Lcom/tencent/oskplayer/proxy/VideoProxy$1;)V
    //   9: astore 15
    //   11: aload 15
    //   13: lload 8
    //   15: putfield 832	com/tencent/oskplayer/proxy/VideoProxy$DataSourceOpenResult:retCode	J
    //   18: new 258	java/lang/StringBuilder
    //   21: dup
    //   22: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   25: astore 16
    //   27: aload 16
    //   29: ldc_w 834
    //   32: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: pop
    //   36: aload 16
    //   38: aload_2
    //   39: invokevirtual 837	com/tencent/oskplayer/datasource/DataSpec:toString	()Ljava/lang/String;
    //   42: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: iconst_4
    //   47: aload 4
    //   49: aload 16
    //   51: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   57: aload_3
    //   58: invokestatic 840	com/tencent/oskplayer/util/PlayerUtils:isHLSStream	(Ljava/lang/String;)Z
    //   61: ifne +14 -> 75
    //   64: aload_1
    //   65: aload_2
    //   66: invokeinterface 535 2 0
    //   71: pop2
    //   72: aload 15
    //   74: areturn
    //   75: aload 15
    //   77: aload_0
    //   78: aload_1
    //   79: aload_2
    //   80: aload_3
    //   81: aload 5
    //   83: invokespecial 842	com/tencent/oskplayer/proxy/VideoProxy:generateLocalPlaylistFile	(Lcom/tencent/oskplayer/datasource/DataSource;Lcom/tencent/oskplayer/datasource/DataSpec;Ljava/lang/String;Lcom/tencent/oskplayer/proxy/VideoRequest;)Ljava/io/File;
    //   86: putfield 846	com/tencent/oskplayer/proxy/VideoProxy$DataSourceOpenResult:localPlayListFile	Ljava/io/File;
    //   89: aload 15
    //   91: getfield 846	com/tencent/oskplayer/proxy/VideoProxy$DataSourceOpenResult:localPlayListFile	Ljava/io/File;
    //   94: ifnull +110 -> 204
    //   97: new 258	java/lang/StringBuilder
    //   100: dup
    //   101: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   104: astore_1
    //   105: aload_1
    //   106: ldc_w 848
    //   109: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: pop
    //   113: aload_1
    //   114: aload 15
    //   116: getfield 846	com/tencent/oskplayer/proxy/VideoProxy$DataSourceOpenResult:localPlayListFile	Ljava/io/File;
    //   119: invokevirtual 767	java/io/File:toString	()Ljava/lang/String;
    //   122: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: pop
    //   126: iconst_4
    //   127: aload 4
    //   129: aload_1
    //   130: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   133: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   136: new 850	com/tencent/oskplayer/proxy/VideoProxy$3
    //   139: dup
    //   140: aload_0
    //   141: invokespecial 852	com/tencent/oskplayer/proxy/VideoProxy$3:<init>	(Lcom/tencent/oskplayer/proxy/VideoProxy;)V
    //   144: astore_1
    //   145: aload_1
    //   146: new 836	com/tencent/oskplayer/datasource/DataSpec
    //   149: dup
    //   150: aload 15
    //   152: getfield 846	com/tencent/oskplayer/proxy/VideoProxy$DataSourceOpenResult:localPlayListFile	Ljava/io/File;
    //   155: invokestatic 856	android/net/Uri:fromFile	(Ljava/io/File;)Landroid/net/Uri;
    //   158: aload_2
    //   159: getfield 859	com/tencent/oskplayer/datasource/DataSpec:absoluteStreamPosition	J
    //   162: aload_2
    //   163: getfield 862	com/tencent/oskplayer/datasource/DataSpec:position	J
    //   166: aload_2
    //   167: getfield 865	com/tencent/oskplayer/datasource/DataSpec:length	J
    //   170: aload_2
    //   171: getfield 868	com/tencent/oskplayer/datasource/DataSpec:key	Ljava/lang/String;
    //   174: aload_2
    //   175: getfield 871	com/tencent/oskplayer/datasource/DataSpec:flags	I
    //   178: aload_2
    //   179: getfield 873	com/tencent/oskplayer/datasource/DataSpec:uuid	Ljava/lang/String;
    //   182: aload_2
    //   183: getfield 876	com/tencent/oskplayer/datasource/DataSpec:priority	I
    //   186: invokespecial 879	com/tencent/oskplayer/datasource/DataSpec:<init>	(Landroid/net/Uri;JJJLjava/lang/String;ILjava/lang/String;I)V
    //   189: invokeinterface 535 2 0
    //   194: pop2
    //   195: aload 15
    //   197: aload_1
    //   198: putfield 883	com/tencent/oskplayer/proxy/VideoProxy$DataSourceOpenResult:dataSource	Lcom/tencent/oskplayer/datasource/DataSource;
    //   201: aload 15
    //   203: areturn
    //   204: aload 5
    //   206: invokevirtual 510	com/tencent/oskplayer/proxy/VideoRequest:getPrority	()I
    //   209: bipush 90
    //   211: if_icmpne +131 -> 342
    //   214: bipush 18
    //   216: i2l
    //   217: lload 10
    //   219: invokestatic 886	com/tencent/oskplayer/util/PlayerUtils:getDownloadRetCode	(JJ)J
    //   222: pop2
    //   223: aload_0
    //   224: getfield 212	com/tencent/oskplayer/proxy/VideoProxy:httpUrlErrorListenerMap	Ljava/util/Map;
    //   227: aload 7
    //   229: invokeinterface 701 2 0
    //   234: checkcast 888	com/tencent/oskplayer/proxy/VideoProxy$HttpErrorListener
    //   237: astore_1
    //   238: aload_0
    //   239: getfield 214	com/tencent/oskplayer/proxy/VideoProxy:uuidErrorListenerMap	Ljava/util/Map;
    //   242: aload 5
    //   244: invokevirtual 513	com/tencent/oskplayer/proxy/VideoRequest:getUuid	()Ljava/lang/String;
    //   247: invokeinterface 701 2 0
    //   252: checkcast 888	com/tencent/oskplayer/proxy/VideoProxy$HttpErrorListener
    //   255: astore_2
    //   256: aload_1
    //   257: ifnull +42 -> 299
    //   260: aload_1
    //   261: aload 5
    //   263: invokevirtual 513	com/tencent/oskplayer/proxy/VideoRequest:getUuid	()Ljava/lang/String;
    //   266: aload_3
    //   267: bipush 18
    //   269: aconst_null
    //   270: new 207	java/util/HashMap
    //   273: dup
    //   274: invokespecial 208	java/util/HashMap:<init>	()V
    //   277: invokestatic 491	java/lang/System:currentTimeMillis	()J
    //   280: lload 12
    //   282: lsub
    //   283: l2i
    //   284: aload 15
    //   286: getfield 832	com/tencent/oskplayer/proxy/VideoProxy$DataSourceOpenResult:retCode	J
    //   289: lload 10
    //   291: invokeinterface 892 11 0
    //   296: goto +3 -> 299
    //   299: aload_2
    //   300: ifnull +42 -> 342
    //   303: aload_2
    //   304: aload 5
    //   306: invokevirtual 513	com/tencent/oskplayer/proxy/VideoRequest:getUuid	()Ljava/lang/String;
    //   309: aload_3
    //   310: bipush 18
    //   312: aconst_null
    //   313: new 207	java/util/HashMap
    //   316: dup
    //   317: invokespecial 208	java/util/HashMap:<init>	()V
    //   320: invokestatic 491	java/lang/System:currentTimeMillis	()J
    //   323: lload 12
    //   325: lsub
    //   326: l2i
    //   327: aload 15
    //   329: getfield 832	com/tencent/oskplayer/proxy/VideoProxy$DataSourceOpenResult:retCode	J
    //   332: lload 10
    //   334: invokeinterface 892 11 0
    //   339: goto +3 -> 342
    //   342: iconst_4
    //   343: aload 4
    //   345: ldc_w 894
    //   348: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   351: aload 6
    //   353: invokevirtual 897	java/net/Socket:close	()V
    //   356: aload_0
    //   357: getfield 314	com/tencent/oskplayer/proxy/VideoProxy:videoRequestManager	Lcom/tencent/oskplayer/proxy/VideoRequestManager;
    //   360: aload 5
    //   362: invokevirtual 901	com/tencent/oskplayer/proxy/VideoRequestManager:removeRequest	(Lcom/tencent/oskplayer/proxy/VideoRequest;)V
    //   365: aload 5
    //   367: invokevirtual 904	com/tencent/oskplayer/proxy/VideoRequest:isCancelProcceed	()Z
    //   370: ifeq +52 -> 422
    //   373: aload 5
    //   375: sipush 256
    //   378: invokevirtual 907	com/tencent/oskplayer/proxy/VideoRequest:setStoppedReason	(I)V
    //   381: new 258	java/lang/StringBuilder
    //   384: dup
    //   385: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   388: astore_1
    //   389: aload_1
    //   390: aload 5
    //   392: invokevirtual 507	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   395: pop
    //   396: aload_1
    //   397: ldc_w 909
    //   400: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   403: pop
    //   404: iconst_4
    //   405: aload 4
    //   407: aload_1
    //   408: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   411: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   414: aload 5
    //   416: invokevirtual 912	com/tencent/oskplayer/proxy/VideoRequest:enterCancelSuccessState	()V
    //   419: goto +11 -> 430
    //   422: aload 5
    //   424: sipush 257
    //   427: invokevirtual 907	com/tencent/oskplayer/proxy/VideoRequest:setStoppedReason	(I)V
    //   430: aload 5
    //   432: iconst_1
    //   433: invokevirtual 916	com/tencent/oskplayer/proxy/VideoRequest:setIsStopped	(Z)V
    //   436: aload 15
    //   438: iconst_1
    //   439: putfield 919	com/tencent/oskplayer/proxy/VideoProxy$DataSourceOpenResult:isHandled	Z
    //   442: aload 15
    //   444: areturn
    //   445: astore_1
    //   446: new 258	java/lang/StringBuilder
    //   449: dup
    //   450: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   453: astore_2
    //   454: aload_2
    //   455: ldc 8
    //   457: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   460: pop
    //   461: aload_2
    //   462: aload 5
    //   464: invokevirtual 427	com/tencent/oskplayer/proxy/VideoRequest:getSeqNum	()I
    //   467: invokevirtual 430	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   470: pop
    //   471: aload_2
    //   472: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   475: astore_2
    //   476: new 258	java/lang/StringBuilder
    //   479: dup
    //   480: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   483: astore 16
    //   485: aload 16
    //   487: ldc_w 921
    //   490: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   493: pop
    //   494: aload 16
    //   496: aload_1
    //   497: invokevirtual 507	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   500: pop
    //   501: bipush 6
    //   503: aload_2
    //   504: aload 16
    //   506: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   509: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   512: aload_1
    //   513: invokevirtual 922	com/tencent/oskplayer/proxy/LivePlayListException:getCause	()Ljava/lang/Throwable;
    //   516: ifnull +39 -> 555
    //   519: aload_1
    //   520: invokevirtual 922	com/tencent/oskplayer/proxy/LivePlayListException:getCause	()Ljava/lang/Throwable;
    //   523: instanceof 924
    //   526: ifne +23 -> 549
    //   529: aload_1
    //   530: invokevirtual 922	com/tencent/oskplayer/proxy/LivePlayListException:getCause	()Ljava/lang/Throwable;
    //   533: instanceof 926
    //   536: ifeq +6 -> 542
    //   539: goto +10 -> 549
    //   542: bipush 17
    //   544: istore 14
    //   546: goto +13 -> 559
    //   549: iconst_0
    //   550: istore 14
    //   552: goto +7 -> 559
    //   555: bipush 16
    //   557: istore 14
    //   559: aload 5
    //   561: invokevirtual 510	com/tencent/oskplayer/proxy/VideoRequest:getPrority	()I
    //   564: bipush 90
    //   566: if_icmpne +140 -> 706
    //   569: iload 14
    //   571: ifeq +135 -> 706
    //   574: aload 15
    //   576: iload 14
    //   578: i2l
    //   579: lload 10
    //   581: invokestatic 886	com/tencent/oskplayer/util/PlayerUtils:getDownloadRetCode	(JJ)J
    //   584: putfield 832	com/tencent/oskplayer/proxy/VideoProxy$DataSourceOpenResult:retCode	J
    //   587: aload_0
    //   588: getfield 212	com/tencent/oskplayer/proxy/VideoProxy:httpUrlErrorListenerMap	Ljava/util/Map;
    //   591: aload 7
    //   593: invokeinterface 701 2 0
    //   598: checkcast 888	com/tencent/oskplayer/proxy/VideoProxy$HttpErrorListener
    //   601: astore_1
    //   602: aload_0
    //   603: getfield 214	com/tencent/oskplayer/proxy/VideoProxy:uuidErrorListenerMap	Ljava/util/Map;
    //   606: aload 5
    //   608: invokevirtual 513	com/tencent/oskplayer/proxy/VideoRequest:getUuid	()Ljava/lang/String;
    //   611: invokeinterface 701 2 0
    //   616: checkcast 888	com/tencent/oskplayer/proxy/VideoProxy$HttpErrorListener
    //   619: astore_2
    //   620: aload_1
    //   621: ifnull +42 -> 663
    //   624: aload_1
    //   625: aload 5
    //   627: invokevirtual 513	com/tencent/oskplayer/proxy/VideoRequest:getUuid	()Ljava/lang/String;
    //   630: aload_3
    //   631: iload 14
    //   633: aconst_null
    //   634: new 207	java/util/HashMap
    //   637: dup
    //   638: invokespecial 208	java/util/HashMap:<init>	()V
    //   641: invokestatic 491	java/lang/System:currentTimeMillis	()J
    //   644: lload 12
    //   646: lsub
    //   647: l2i
    //   648: aload 15
    //   650: getfield 832	com/tencent/oskplayer/proxy/VideoProxy$DataSourceOpenResult:retCode	J
    //   653: lload 10
    //   655: invokeinterface 892 11 0
    //   660: goto +3 -> 663
    //   663: aload_2
    //   664: ifnull +42 -> 706
    //   667: aload_2
    //   668: aload 5
    //   670: invokevirtual 513	com/tencent/oskplayer/proxy/VideoRequest:getUuid	()Ljava/lang/String;
    //   673: aload_3
    //   674: iload 14
    //   676: aconst_null
    //   677: new 207	java/util/HashMap
    //   680: dup
    //   681: invokespecial 208	java/util/HashMap:<init>	()V
    //   684: invokestatic 491	java/lang/System:currentTimeMillis	()J
    //   687: lload 12
    //   689: lsub
    //   690: l2i
    //   691: aload 15
    //   693: getfield 832	com/tencent/oskplayer/proxy/VideoProxy$DataSourceOpenResult:retCode	J
    //   696: lload 10
    //   698: invokeinterface 892 11 0
    //   703: goto +3 -> 706
    //   706: aload 6
    //   708: invokevirtual 897	java/net/Socket:close	()V
    //   711: aload_0
    //   712: getfield 314	com/tencent/oskplayer/proxy/VideoProxy:videoRequestManager	Lcom/tencent/oskplayer/proxy/VideoRequestManager;
    //   715: aload 5
    //   717: invokevirtual 901	com/tencent/oskplayer/proxy/VideoRequestManager:removeRequest	(Lcom/tencent/oskplayer/proxy/VideoRequest;)V
    //   720: aload 5
    //   722: invokevirtual 904	com/tencent/oskplayer/proxy/VideoRequest:isCancelProcceed	()Z
    //   725: ifeq +52 -> 777
    //   728: aload 5
    //   730: sipush 256
    //   733: invokevirtual 907	com/tencent/oskplayer/proxy/VideoRequest:setStoppedReason	(I)V
    //   736: new 258	java/lang/StringBuilder
    //   739: dup
    //   740: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   743: astore_1
    //   744: aload_1
    //   745: aload 5
    //   747: invokevirtual 507	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   750: pop
    //   751: aload_1
    //   752: ldc_w 909
    //   755: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   758: pop
    //   759: iconst_4
    //   760: aload 4
    //   762: aload_1
    //   763: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   766: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   769: aload 5
    //   771: invokevirtual 912	com/tencent/oskplayer/proxy/VideoRequest:enterCancelSuccessState	()V
    //   774: goto +11 -> 785
    //   777: aload 5
    //   779: sipush 257
    //   782: invokevirtual 907	com/tencent/oskplayer/proxy/VideoRequest:setStoppedReason	(I)V
    //   785: aload 5
    //   787: iconst_1
    //   788: invokevirtual 916	com/tencent/oskplayer/proxy/VideoRequest:setIsStopped	(Z)V
    //   791: aload 15
    //   793: iconst_1
    //   794: putfield 919	com/tencent/oskplayer/proxy/VideoProxy$DataSourceOpenResult:isHandled	Z
    //   797: aload 15
    //   799: areturn
    //   800: astore_1
    //   801: goto -445 -> 356
    //   804: astore_1
    //   805: goto -94 -> 711
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	808	0	this	VideoProxy
    //   0	808	1	paramDataSource	com.tencent.oskplayer.datasource.DataSource
    //   0	808	2	paramDataSpec	com.tencent.oskplayer.datasource.DataSpec
    //   0	808	3	paramString1	String
    //   0	808	4	paramString2	String
    //   0	808	5	paramVideoRequest	VideoRequest
    //   0	808	6	paramSocket	Socket
    //   0	808	7	paramString3	String
    //   0	808	8	paramLong1	long
    //   0	808	10	paramLong2	long
    //   0	808	12	paramLong3	long
    //   544	131	14	i	int
    //   9	789	15	localDataSourceOpenResult	VideoProxy.DataSourceOpenResult
    //   25	480	16	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   75	89	445	com/tencent/oskplayer/proxy/LivePlayListException
    //   351	356	800	java/io/IOException
    //   706	711	804	java/io/IOException
  }
  
  private void preloadMediasAsync(ArrayList<VideoProxy.PreloadInfo> paramArrayList, int paramInt, long paramLong, PreloadListener paramPreloadListener, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      paramString = "preloadMediasAsync";
    }
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      VideoProxy.PreloadInfo localPreloadInfo = (VideoProxy.PreloadInfo)paramArrayList.next();
      boolean bool2 = true;
      boolean bool1;
      StringBuilder localStringBuilder;
      if (paramLong == -1L)
      {
        bool1 = true ^ isCached(localPreloadInfo.originalUrl);
      }
      else
      {
        bool1 = bool2;
        if (paramLong > 0L)
        {
          long l = paramLong - this.cache.getCachedBytesFromStart(PlayerUtils.parseVideoKey(localPreloadInfo.originalUrl));
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("remainingBytes2Cache ");
          localStringBuilder.append(l);
          localStringBuilder.append(",url=");
          localStringBuilder.append(localPreloadInfo.originalUrl);
          PlayerUtils.log(3, paramString, localStringBuilder.toString());
          if (l > 0L) {
            bool1 = bool2;
          } else {
            bool1 = false;
          }
        }
      }
      if (bool1)
      {
        localArrayList.add(new VideoProxy.4(this, localPreloadInfo, paramLong, paramPreloadListener, paramString));
      }
      else
      {
        if (paramPreloadListener != null) {
          paramPreloadListener.onFinish(localPreloadInfo.originalUrl);
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("url ");
        localStringBuilder.append(localPreloadInfo.originalUrl);
        localStringBuilder.append(" already cached, cacheMaxBytes=");
        localStringBuilder.append(paramLong);
        PlayerUtils.log(4, paramString, localStringBuilder.toString());
      }
    }
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
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("VideoProxy/");
    ((StringBuilder)localObject1).append(paramVideoRequest.getSeqNum());
    String str1 = ((StringBuilder)localObject1).toString();
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(str1);
    ((StringBuilder)localObject1).append("/");
    Object localObject4 = ((StringBuilder)localObject1).toString();
    PlayerUtils.log(3, str1, "process socket");
    int i;
    try
    {
      localObject2 = paramSocket.getInputStream();
      if (localObject2 == null)
      {
        PlayerUtils.log(6, str1, "socket inputstream is null");
        return;
      }
      localObject5 = PlayerConfig.g().getOnConnectionChangeListener();
      if (localObject5 != null) {
        ((VideoProxy.OnConnectionChangeListener)localObject5).onConnectionChange(true, (InputStream)localObject2, null);
      }
      localObject6 = new HttpParser((InputStream)localObject2, (String)localObject4);
      str2 = ((HttpParser)localObject6).getRequestMethod();
      localObject3 = ((HttpParser)localObject6).getParam("v");
      str3 = ((HttpParser)localObject6).getParam("p");
      str4 = ((HttpParser)localObject6).getParam("uuid");
      str5 = ((HttpParser)localObject6).getParam("enableCache");
      str6 = ((HttpParser)localObject6).getParam("dataSourceType");
      str7 = ((HttpParser)localObject6).getParam("preferredContentType");
      localObject1 = ((HttpParser)localObject6).getParam("t");
      localObject7 = ((HttpParser)localObject6).getParam("eh");
      if (localObject3 == null)
      {
        PlayerUtils.log(6, str1, "invalid request detected, sourceUrl is null");
        return;
      }
      if (TextUtils.isEmpty((CharSequence)localObject7)) {
        break label1186;
      }
      boolean bool = TextUtils.isDigitsOnly((CharSequence)localObject7);
      if (!bool) {
        break label1186;
      }
    }
    catch (Exception paramSocket)
    {
      Object localObject2;
      Object localObject5;
      Object localObject6;
      String str2;
      Object localObject3;
      String str3;
      String str4;
      String str5;
      String str6;
      String str7;
      Object localObject7;
      label260:
      StringBuilder localStringBuilder;
      this.mProxyExceptionCount += 1;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("mProxyExceptionCount ");
      ((StringBuilder)localObject1).append(this.mProxyExceptionCount);
      PlayerUtils.log(5, str1, ((StringBuilder)localObject1).toString());
      localObject1 = PlayerUtils.getPrintableStackTrace(paramSocket);
      if (PlayerConfig.g().getVideoReporter() != null)
      {
        l1 = -99999L;
        if ((paramSocket instanceof ProxyException)) {
          l1 = -99999L + ((ProxyException)paramSocket).getErrCode();
        } else if ((paramSocket instanceof IllegalDataSpecException)) {
          l1 = -99799L;
        } else if ((paramSocket instanceof ArrayIndexOutOfBoundsException)) {
          l1 = -99699L;
        }
        l2 = PlayerUtils.getDownloadRetCode(4L, l1);
        l3 = PlayerUtils.getDownloadResponseCode(l2, l1);
        if (!UuidPlayIdMap.isUuidDeleted(paramVideoRequest.getUuid()))
        {
          localObject2 = new HashMap();
          ((HashMap)localObject2).put("responseCode", Long.valueOf(l3));
          ((HashMap)localObject2).put("subRetCode", Long.valueOf(l1));
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("(");
          ((StringBuilder)localObject3).append(l3);
          ((StringBuilder)localObject3).append(",");
          ((StringBuilder)localObject3).append(l1);
          ((StringBuilder)localObject3).append("),");
          ((StringBuilder)localObject3).append(paramSocket.toString());
          ((HashMap)localObject2).put("message", ((StringBuilder)localObject3).toString());
          PlayerConfig.g().getVideoReporter().downloadResult(paramVideoRequest.getUuid(), l2, (Map)localObject2);
        }
      }
      paramVideoRequest = new StringBuilder();
      paramVideoRequest.append("unexpected proxy err ");
      paramVideoRequest.append(paramSocket.getMessage());
      paramVideoRequest.append((String)localObject1);
      PlayerUtils.log(6, str1, paramVideoRequest.toString(), paramSocket);
      return;
    }
    try
    {
      i = Integer.parseInt((String)localObject7, 10);
    }
    catch (Exception localException)
    {
      break label260;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("invalid extraHeaderId ");
    localStringBuilder.append((String)localObject7);
    PlayerUtils.log(6, str1, localStringBuilder.toString());
    break label1186;
    if (i != -1)
    {
      localObject7 = getExtraHeaderById(i);
      if (localObject7 == null)
      {
        localObject7 = new StringBuilder();
        ((StringBuilder)localObject7).append("ehid=");
        ((StringBuilder)localObject7).append(i);
        ((StringBuilder)localObject7).append(" is invalid");
        PlayerUtils.log(6, str1, ((StringBuilder)localObject7).toString());
      }
      else
      {
        paramVideoRequest.setExtraHeader((HttpHeader)localObject7);
      }
    }
    localObject7 = ((HttpParser)localObject6).getRawHeaders();
    localObject6 = new StringBuilder();
    ((StringBuilder)localObject6).append("mediaplayer request header:");
    ((StringBuilder)localObject6).append((String)localObject7);
    PlayerUtils.log(4, str1, PlayerUtils.removeLineBreaks(((StringBuilder)localObject6).toString(), null));
    localObject6 = paramSocket.getOutputStream();
    if (localObject6 == null)
    {
      PlayerUtils.log(6, str1, "socket outputstream is null");
      return;
    }
    if (localObject5 != null) {
      ((VideoProxy.OnConnectionChangeListener)localObject5).onConnectionChange(true, null, (OutputStream)localObject6);
    }
    localObject5 = HttpParser.getRangeOffset((String)localObject7);
    paramVideoRequest.setRequestMethod(str2);
    paramVideoRequest.setSourceUrl((String)localObject3);
    paramVideoRequest.setRangeStart(localObject5[0]);
    paramVideoRequest.setRangeEnd(localObject5[1]);
    paramVideoRequest.setUuid(str4);
    if ((!TextUtils.isEmpty(str5)) && (str5.equals("1"))) {
      paramVideoRequest.setCacheEnabled(true);
    } else {
      paramVideoRequest.setCacheEnabled(false);
    }
    paramVideoRequest.setDataSourceType(str6);
    paramVideoRequest.setPreferredContentType(str7);
    paramVideoRequest.setLogTag((String)localObject4);
    if (TextUtils.isEmpty(str3)) {
      paramVideoRequest.setPrority(-1);
    } else if (str3.equals(String.valueOf(90))) {
      paramVideoRequest.setPrority(90);
    } else if (str3.equals(String.valueOf(10))) {
      paramVideoRequest.setPrority(10);
    } else {
      paramVideoRequest.setPrority(-1);
    }
    for (;;)
    {
      if (paramVideoRequest.getPrority() == -1)
      {
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("videoRequest ");
        ((StringBuilder)localObject4).append(paramVideoRequest);
        ((StringBuilder)localObject4).append(" priority is not specified");
        PlayerUtils.log(5, str1, ((StringBuilder)localObject4).toString());
      }
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("dump videoRequest=");
      ((StringBuilder)localObject4).append(paramVideoRequest);
      PlayerUtils.log(4, str1, ((StringBuilder)localObject4).toString());
      cancelPreloadRequestsSync(paramVideoRequest.getVideoKey(), paramVideoRequest);
      if ((this.isSecretEnable) && (PlayerConfig.g().isEnableProxySecret())) {
        if (localObject1 == null)
        {
          PlayerUtils.log(6, str1, "invalid request detected, token is null");
          return;
        }
      }
      try
      {
        localObject1 = SecretUtils.decode("des", SecretUtils.getRandomNum(), (String)localObject1);
        localObject4 = PlayerUtils.parseVideoKey((String)localObject3);
        if ((localObject1 != null) && (((String)localObject1).equals(localObject4))) {
          break label827;
        }
        PlayerUtils.log(6, str1, "invalid request detected, key is illegal");
        throw new ProxyException("token required", 100);
      }
      catch (Throwable paramSocket)
      {
        label805:
        label827:
        long l1;
        long l2;
        long l3;
        break label805;
      }
      PlayerUtils.log(5, str1, "decode token error");
      throw new ProxyException("parse token err", 101);
      this.videoRequestManager.addRequest((String)localObject3, paramVideoRequest);
      writeResponse(paramSocket, (String)localObject3, (OutputStream)localObject6, paramVideoRequest, (InputStream)localObject2);
      return;
      label1186:
      i = -1;
      break;
    }
  }
  
  /* Error */
  private void sendUrlRequestSync(String paramString1, long paramLong, PreloadListener paramPreloadListener, String paramString2)
  {
    // Byte code:
    //   0: new 1181	com/tencent/oskplayer/datasource/DefaultHttpDataSource
    //   3: dup
    //   4: ldc 55
    //   6: aconst_null
    //   7: aconst_null
    //   8: invokespecial 1184	com/tencent/oskplayer/datasource/DefaultHttpDataSource:<init>	(Ljava/lang/String;Lcom/tencent/oskplayer/util/Predicate;Lcom/tencent/oskplayer/util/Fixer;)V
    //   11: astore 18
    //   13: new 258	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   20: astore 15
    //   22: aload 15
    //   24: ldc_w 1186
    //   27: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: pop
    //   31: aload 15
    //   33: aload 5
    //   35: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: pop
    //   39: aload 15
    //   41: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   44: astore 17
    //   46: sipush 512
    //   49: newarray byte
    //   51: astore 16
    //   53: new 258	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   60: astore 5
    //   62: aload 5
    //   64: ldc_w 1188
    //   67: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: aload 5
    //   73: aload_1
    //   74: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: pop
    //   78: iconst_4
    //   79: aload 17
    //   81: aload 5
    //   83: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   86: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   89: lconst_0
    //   90: lstore 11
    //   92: ldc_w 1190
    //   95: astore 5
    //   97: aload 4
    //   99: ifnull +24 -> 123
    //   102: aload 4
    //   104: aload_1
    //   105: invokeinterface 1193 2 0
    //   110: goto +13 -> 123
    //   113: astore 15
    //   115: ldc_w 1190
    //   118: astore 5
    //   120: goto +495 -> 615
    //   123: aload 5
    //   125: astore 15
    //   127: aload 18
    //   129: new 836	com/tencent/oskplayer/datasource/DataSpec
    //   132: dup
    //   133: aload_1
    //   134: invokestatic 817	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   137: lconst_0
    //   138: lconst_0
    //   139: ldc2_w 929
    //   142: aconst_null
    //   143: iconst_0
    //   144: aconst_null
    //   145: invokespecial 1196	com/tencent/oskplayer/datasource/DataSpec:<init>	(Landroid/net/Uri;JJJLjava/lang/String;ILjava/lang/String;)V
    //   148: invokeinterface 535 2 0
    //   153: pop2
    //   154: aload 5
    //   156: astore 15
    //   158: aload 18
    //   160: invokeinterface 1199 1 0
    //   165: lstore 9
    //   167: lconst_0
    //   168: lstore 7
    //   170: aload 5
    //   172: astore 15
    //   174: aload 18
    //   176: aload 16
    //   178: iconst_0
    //   179: aload 16
    //   181: arraylength
    //   182: invokeinterface 1203 4 0
    //   187: istore 6
    //   189: iload 6
    //   191: i2l
    //   192: lstore 11
    //   194: lload 11
    //   196: ldc2_w 929
    //   199: lcmp
    //   200: ifeq +74 -> 274
    //   203: lload 7
    //   205: lload 11
    //   207: ladd
    //   208: lstore 7
    //   210: aload 4
    //   212: ifnull +32 -> 244
    //   215: aload 4
    //   217: aload_1
    //   218: lload 7
    //   220: lload_2
    //   221: lload 9
    //   223: invokeinterface 1207 8 0
    //   228: goto +16 -> 244
    //   231: astore 15
    //   233: goto +382 -> 615
    //   236: astore 15
    //   238: lload 7
    //   240: lstore_2
    //   241: goto +158 -> 399
    //   244: lload_2
    //   245: lconst_0
    //   246: lcmp
    //   247: ifle +24 -> 271
    //   250: lload_2
    //   251: ldc2_w 929
    //   254: lcmp
    //   255: ifeq +16 -> 271
    //   258: lload 7
    //   260: lload_2
    //   261: lcmp
    //   262: iflt +9 -> 271
    //   265: lload 7
    //   267: lstore_2
    //   268: goto +9 -> 277
    //   271: goto -101 -> 170
    //   274: lload 7
    //   276: lstore_2
    //   277: aload 5
    //   279: astore 15
    //   281: new 258	java/lang/StringBuilder
    //   284: dup
    //   285: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   288: astore 16
    //   290: aload 16
    //   292: ldc_w 1209
    //   295: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: pop
    //   299: aload 16
    //   301: lload_2
    //   302: invokevirtual 268	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   305: pop
    //   306: iconst_4
    //   307: aload 17
    //   309: aload 16
    //   311: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   314: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   317: aload 18
    //   319: invokeinterface 1210 1 0
    //   324: goto +41 -> 365
    //   327: astore 5
    //   329: new 258	java/lang/StringBuilder
    //   332: dup
    //   333: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   336: astore 16
    //   338: aload 16
    //   340: aload 15
    //   342: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: pop
    //   346: aload 16
    //   348: aload 5
    //   350: invokevirtual 507	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   353: pop
    //   354: iconst_4
    //   355: aload 17
    //   357: aload 16
    //   359: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   362: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   365: lload_2
    //   366: lstore 13
    //   368: lload 9
    //   370: lstore 11
    //   372: aload 4
    //   374: ifnull +187 -> 561
    //   377: lload 9
    //   379: lstore 7
    //   381: goto +165 -> 546
    //   384: astore 16
    //   386: aload 15
    //   388: astore 5
    //   390: aload 16
    //   392: astore 15
    //   394: goto +34 -> 428
    //   397: astore 15
    //   399: lload 9
    //   401: lstore 7
    //   403: goto +43 -> 446
    //   406: astore 15
    //   408: lload 7
    //   410: lstore_2
    //   411: lload 9
    //   413: lstore 7
    //   415: goto +31 -> 446
    //   418: astore 16
    //   420: aload 15
    //   422: astore 5
    //   424: aload 16
    //   426: astore 15
    //   428: goto +187 -> 615
    //   431: astore 15
    //   433: ldc_w 1190
    //   436: astore 5
    //   438: ldc2_w 929
    //   441: lstore 7
    //   443: lload 11
    //   445: lstore_2
    //   446: new 258	java/lang/StringBuilder
    //   449: dup
    //   450: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   453: astore 16
    //   455: aload 16
    //   457: ldc_w 1212
    //   460: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   463: pop
    //   464: aload 16
    //   466: aload 15
    //   468: invokevirtual 1176	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   471: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   474: pop
    //   475: iconst_4
    //   476: aload 17
    //   478: aload 16
    //   480: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   483: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   486: aload 18
    //   488: invokeinterface 1210 1 0
    //   493: goto +41 -> 534
    //   496: astore 15
    //   498: new 258	java/lang/StringBuilder
    //   501: dup
    //   502: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   505: astore 16
    //   507: aload 16
    //   509: aload 5
    //   511: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   514: pop
    //   515: aload 16
    //   517: aload 15
    //   519: invokevirtual 507	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   522: pop
    //   523: iconst_4
    //   524: aload 17
    //   526: aload 16
    //   528: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   531: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   534: lload_2
    //   535: lstore 13
    //   537: lload 7
    //   539: lstore 11
    //   541: aload 4
    //   543: ifnull +18 -> 561
    //   546: aload 4
    //   548: aload_1
    //   549: invokeinterface 955 2 0
    //   554: lload 7
    //   556: lstore 11
    //   558: lload_2
    //   559: lstore 13
    //   561: new 258	java/lang/StringBuilder
    //   564: dup
    //   565: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   568: astore_1
    //   569: aload_1
    //   570: ldc_w 1214
    //   573: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   576: pop
    //   577: aload_1
    //   578: lload 11
    //   580: invokevirtual 268	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   583: pop
    //   584: aload_1
    //   585: ldc_w 1216
    //   588: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   591: pop
    //   592: aload_1
    //   593: lload 13
    //   595: invokevirtual 268	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   598: pop
    //   599: iconst_4
    //   600: aload 17
    //   602: aload_1
    //   603: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   606: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   609: return
    //   610: astore 15
    //   612: goto -184 -> 428
    //   615: aload 18
    //   617: invokeinterface 1210 1 0
    //   622: goto +41 -> 663
    //   625: astore 16
    //   627: new 258	java/lang/StringBuilder
    //   630: dup
    //   631: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   634: astore 18
    //   636: aload 18
    //   638: aload 5
    //   640: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   643: pop
    //   644: aload 18
    //   646: aload 16
    //   648: invokevirtual 507	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   651: pop
    //   652: iconst_4
    //   653: aload 17
    //   655: aload 18
    //   657: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   660: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   663: aload 4
    //   665: ifnull +11 -> 676
    //   668: aload 4
    //   670: aload_1
    //   671: invokeinterface 955 2 0
    //   676: goto +6 -> 682
    //   679: aload 15
    //   681: athrow
    //   682: goto -3 -> 679
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	685	0	this	VideoProxy
    //   0	685	1	paramString1	String
    //   0	685	2	paramLong	long
    //   0	685	4	paramPreloadListener	PreloadListener
    //   0	685	5	paramString2	String
    //   187	3	6	i	int
    //   168	387	7	l1	long
    //   165	247	9	l2	long
    //   90	489	11	l3	long
    //   366	228	13	l4	long
    //   20	20	15	localStringBuilder1	StringBuilder
    //   113	1	15	localObject1	Object
    //   125	48	15	str1	String
    //   231	1	15	localObject2	Object
    //   236	1	15	localException1	Exception
    //   279	114	15	localObject3	Object
    //   397	1	15	localException2	Exception
    //   406	15	15	localException3	Exception
    //   426	1	15	localObject4	Object
    //   431	36	15	localException4	Exception
    //   496	22	15	localException5	Exception
    //   610	70	15	localObject5	Object
    //   51	307	16	localObject6	Object
    //   384	7	16	localObject7	Object
    //   418	7	16	localObject8	Object
    //   453	74	16	localStringBuilder2	StringBuilder
    //   625	22	16	localException6	Exception
    //   44	610	17	str2	String
    //   11	645	18	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   102	110	113	finally
    //   215	228	231	finally
    //   215	228	236	java/lang/Exception
    //   317	324	327	java/lang/Exception
    //   281	317	384	finally
    //   281	317	397	java/lang/Exception
    //   174	189	406	java/lang/Exception
    //   127	154	418	finally
    //   158	167	418	finally
    //   174	189	418	finally
    //   102	110	431	java/lang/Exception
    //   127	154	431	java/lang/Exception
    //   158	167	431	java/lang/Exception
    //   486	493	496	java/lang/Exception
    //   446	486	610	finally
    //   615	622	625	java/lang/Exception
  }
  
  /* Error */
  private void waitForRequest()
  {
    // Byte code:
    //   0: iconst_3
    //   1: ldc 49
    //   3: ldc_w 1222
    //   6: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   9: invokestatic 1226	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   12: invokevirtual 1229	java/lang/Thread:isInterrupted	()Z
    //   15: ifne +115 -> 130
    //   18: aload_0
    //   19: getfield 354	com/tencent/oskplayer/proxy/VideoProxy:serverSocket	Ljava/net/ServerSocket;
    //   22: invokevirtual 1233	java/net/ServerSocket:accept	()Ljava/net/Socket;
    //   25: astore_3
    //   26: new 361	java/util/concurrent/CountDownLatch
    //   29: dup
    //   30: iconst_1
    //   31: invokespecial 362	java/util/concurrent/CountDownLatch:<init>	(I)V
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
    //   59: getfield 314	com/tencent/oskplayer/proxy/VideoProxy:videoRequestManager	Lcom/tencent/oskplayer/proxy/VideoRequestManager;
    //   62: invokevirtual 1242	com/tencent/oskplayer/proxy/VideoRequestManager:toString	()Ljava/lang/String;
    //   65: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   68: iconst_4
    //   69: ldc 49
    //   71: aload_0
    //   72: getfield 337	com/tencent/oskplayer/proxy/VideoProxy:executorService	Ljava/util/concurrent/ExecutorService;
    //   75: invokevirtual 1243	java/lang/Object:toString	()Ljava/lang/String;
    //   78: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   81: aload_0
    //   82: getfield 337	com/tencent/oskplayer/proxy/VideoProxy:executorService	Ljava/util/concurrent/ExecutorService;
    //   85: aload_3
    //   86: invokeinterface 1247 2 0
    //   91: astore 4
    //   93: aload_0
    //   94: getfield 337	com/tencent/oskplayer/proxy/VideoProxy:executorService	Ljava/util/concurrent/ExecutorService;
    //   97: checkcast 316	com/tencent/oskplayer/util/ThreadUtils$FlexibleSizeExecutor
    //   100: invokevirtual 1250	com/tencent/oskplayer/util/ThreadUtils$FlexibleSizeExecutor:getPendingTaskCount	()I
    //   103: istore_1
    //   104: aload_0
    //   105: getfield 337	com/tencent/oskplayer/proxy/VideoProxy:executorService	Ljava/util/concurrent/ExecutorService;
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
    //   130: iconst_3
    //   131: ldc 49
    //   133: ldc_w 1264
    //   136: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   139: aload_0
    //   140: getfield 337	com/tencent/oskplayer/proxy/VideoProxy:executorService	Ljava/util/concurrent/ExecutorService;
    //   143: invokeinterface 1268 1 0
    //   148: pop
    //   149: iconst_3
    //   150: ldc 49
    //   152: ldc_w 1270
    //   155: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   158: return
    //   159: astore_2
    //   160: goto +145 -> 305
    //   163: astore_2
    //   164: new 258	java/lang/StringBuilder
    //   167: dup
    //   168: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   171: astore_3
    //   172: aload_3
    //   173: ldc_w 1272
    //   176: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: pop
    //   180: aload_3
    //   181: aload_2
    //   182: invokestatic 395	com/tencent/oskplayer/util/PlayerUtils:getPrintableStackTrace	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   185: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: pop
    //   189: bipush 6
    //   191: ldc 49
    //   193: aload_3
    //   194: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   197: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   200: goto -70 -> 130
    //   203: astore_2
    //   204: new 258	java/lang/StringBuilder
    //   207: dup
    //   208: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   211: astore_3
    //   212: aload_3
    //   213: ldc_w 1274
    //   216: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: pop
    //   220: aload_3
    //   221: aload_2
    //   222: invokestatic 395	com/tencent/oskplayer/util/PlayerUtils:getPrintableStackTrace	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   225: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: pop
    //   229: bipush 6
    //   231: ldc 49
    //   233: aload_3
    //   234: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   237: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   240: goto -110 -> 130
    //   243: astore_2
    //   244: aload_0
    //   245: getfield 354	com/tencent/oskplayer/proxy/VideoProxy:serverSocket	Ljava/net/ServerSocket;
    //   248: invokevirtual 1277	java/net/ServerSocket:isClosed	()Z
    //   251: ifeq +15 -> 266
    //   254: iconst_3
    //   255: ldc 49
    //   257: ldc_w 1279
    //   260: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   263: goto -133 -> 130
    //   266: new 258	java/lang/StringBuilder
    //   269: dup
    //   270: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   273: astore_3
    //   274: aload_3
    //   275: ldc_w 1274
    //   278: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: pop
    //   282: aload_3
    //   283: aload_2
    //   284: invokestatic 395	com/tencent/oskplayer/util/PlayerUtils:getPrintableStackTrace	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   287: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: pop
    //   291: bipush 6
    //   293: ldc 49
    //   295: aload_3
    //   296: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   299: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   302: goto -172 -> 130
    //   305: iconst_3
    //   306: ldc 49
    //   308: ldc_w 1264
    //   311: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   314: aload_0
    //   315: getfield 337	com/tencent/oskplayer/proxy/VideoProxy:executorService	Ljava/util/concurrent/ExecutorService;
    //   318: invokeinterface 1268 1 0
    //   323: pop
    //   324: iconst_3
    //   325: ldc 49
    //   327: ldc_w 1270
    //   330: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   333: goto +5 -> 338
    //   336: aload_2
    //   337: athrow
    //   338: goto -2 -> 336
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	341	0	this	VideoProxy
    //   103	11	1	i	int
    //   34	90	2	localCountDownLatch	CountDownLatch
    //   159	1	2	localObject1	Object
    //   163	19	2	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   203	19	2	localIOException	IOException
    //   243	94	2	localSocketException	java.net.SocketException
    //   25	271	3	localObject2	Object
    //   91	28	4	localFuture	Future
    // Exception table:
    //   from	to	target	type
    //   9	68	159	finally
    //   68	127	159	finally
    //   164	200	159	finally
    //   204	240	159	finally
    //   244	263	159	finally
    //   266	302	159	finally
    //   9	68	163	java/lang/OutOfMemoryError
    //   68	127	163	java/lang/OutOfMemoryError
    //   9	68	203	java/io/IOException
    //   68	127	203	java/io/IOException
    //   9	68	243	java/net/SocketException
    //   68	127	243	java/net/SocketException
  }
  
  /* Error */
  private void writeResponse(Socket paramSocket, String paramString, OutputStream paramOutputStream, VideoRequest paramVideoRequest, InputStream paramInputStream)
  {
    // Byte code:
    //   0: aload 4
    //   2: invokevirtual 1282	com/tencent/oskplayer/proxy/VideoRequest:getRangeEnd	()J
    //   5: lstore 12
    //   7: aload 4
    //   9: invokevirtual 1285	com/tencent/oskplayer/proxy/VideoRequest:getRangeStart	()J
    //   12: lstore 20
    //   14: aload 4
    //   16: invokevirtual 1079	com/tencent/oskplayer/proxy/VideoRequest:getVideoKey	()Ljava/lang/String;
    //   19: astore 45
    //   21: aload 4
    //   23: invokevirtual 644	com/tencent/oskplayer/proxy/VideoRequest:getDataSourceType	()Ljava/lang/String;
    //   26: astore 34
    //   28: invokestatic 176	com/tencent/oskplayer/PlayerConfig:g	()Lcom/tencent/oskplayer/PlayerConfig;
    //   31: invokevirtual 1289	com/tencent/oskplayer/PlayerConfig:getDataSourceBuilder	()Lcom/tencent/oskplayer/proxy/DataSourceBuilder;
    //   34: astore 33
    //   36: aload_0
    //   37: getfield 219	com/tencent/oskplayer/proxy/VideoProxy:httpRetryLogicMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   40: aload 45
    //   42: invokevirtual 1290	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   45: checkcast 1292	com/tencent/oskplayer/proxy/HttpRetryLogic
    //   48: astore 37
    //   50: new 258	java/lang/StringBuilder
    //   53: dup
    //   54: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   57: astore 35
    //   59: aload 35
    //   61: ldc 8
    //   63: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: pop
    //   67: aload 35
    //   69: aload 4
    //   71: invokevirtual 427	com/tencent/oskplayer/proxy/VideoRequest:getSeqNum	()I
    //   74: invokevirtual 430	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   77: pop
    //   78: aload 35
    //   80: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: astore 40
    //   85: new 258	java/lang/StringBuilder
    //   88: dup
    //   89: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   92: astore 35
    //   94: aload 35
    //   96: aload 40
    //   98: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: pop
    //   102: aload 35
    //   104: ldc 52
    //   106: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: pop
    //   110: aload 35
    //   112: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: astore 35
    //   117: ldc_w 766
    //   120: astore 36
    //   122: aload 33
    //   124: ifnonnull +175 -> 299
    //   127: aload_0
    //   128: getfield 1294	com/tencent/oskplayer/proxy/VideoProxy:tcDataSourceUtils	Lcom/tencent/oskplayer/proxy/ITcDataSourceUtils;
    //   131: ifnull +148 -> 279
    //   134: aload 34
    //   136: ldc 61
    //   138: invokestatic 1297	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   141: ifne +13 -> 154
    //   144: aload 34
    //   146: ldc 81
    //   148: invokestatic 1297	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   151: ifeq +128 -> 279
    //   154: aload_0
    //   155: getfield 1294	com/tencent/oskplayer/proxy/VideoProxy:tcDataSourceUtils	Lcom/tencent/oskplayer/proxy/ITcDataSourceUtils;
    //   158: invokeinterface 1302 1 0
    //   163: ifeq +116 -> 279
    //   166: aload_0
    //   167: getfield 1294	com/tencent/oskplayer/proxy/VideoProxy:tcDataSourceUtils	Lcom/tencent/oskplayer/proxy/ITcDataSourceUtils;
    //   170: aload_2
    //   171: invokeinterface 1305 2 0
    //   176: ifne +103 -> 279
    //   179: aload_0
    //   180: getfield 181	com/tencent/oskplayer/proxy/VideoProxy:isCacheProviderLocal	Z
    //   183: ifeq +47 -> 230
    //   186: aload_0
    //   187: getfield 1294	com/tencent/oskplayer/proxy/VideoProxy:tcDataSourceUtils	Lcom/tencent/oskplayer/proxy/ITcDataSourceUtils;
    //   190: aload_0
    //   191: getfield 240	com/tencent/oskplayer/proxy/VideoProxy:cache	Lcom/tencent/oskplayer/cache/Cache;
    //   194: aload 37
    //   196: aload 4
    //   198: invokeinterface 1308 4 0
    //   203: astore 33
    //   205: aload_0
    //   206: getfield 157	com/tencent/oskplayer/proxy/VideoProxy:isPauseTcStorageIO	Z
    //   209: ifne +18 -> 227
    //   212: aload_0
    //   213: getfield 1294	com/tencent/oskplayer/proxy/VideoProxy:tcDataSourceUtils	Lcom/tencent/oskplayer/proxy/ITcDataSourceUtils;
    //   216: invokeinterface 1311 1 0
    //   221: pop
    //   222: aload_0
    //   223: iconst_1
    //   224: putfield 157	com/tencent/oskplayer/proxy/VideoProxy:isPauseTcStorageIO	Z
    //   227: goto +72 -> 299
    //   230: aload_0
    //   231: getfield 1294	com/tencent/oskplayer/proxy/VideoProxy:tcDataSourceUtils	Lcom/tencent/oskplayer/proxy/ITcDataSourceUtils;
    //   234: aconst_null
    //   235: aload 37
    //   237: aload 4
    //   239: invokeinterface 1308 4 0
    //   244: astore 34
    //   246: aload 34
    //   248: astore 33
    //   250: aload_0
    //   251: getfield 157	com/tencent/oskplayer/proxy/VideoProxy:isPauseTcStorageIO	Z
    //   254: ifeq +45 -> 299
    //   257: aload_0
    //   258: getfield 1294	com/tencent/oskplayer/proxy/VideoProxy:tcDataSourceUtils	Lcom/tencent/oskplayer/proxy/ITcDataSourceUtils;
    //   261: invokeinterface 1314 1 0
    //   266: pop
    //   267: aload_0
    //   268: iconst_0
    //   269: putfield 157	com/tencent/oskplayer/proxy/VideoProxy:isPauseTcStorageIO	Z
    //   272: aload 34
    //   274: astore 33
    //   276: goto +23 -> 299
    //   279: new 1316	com/tencent/oskplayer/datasource/DefaultDataSourceBuilder
    //   282: dup
    //   283: aload_0
    //   284: getfield 240	com/tencent/oskplayer/proxy/VideoProxy:cache	Lcom/tencent/oskplayer/cache/Cache;
    //   287: aload 37
    //   289: aload 4
    //   291: invokespecial 1319	com/tencent/oskplayer/datasource/DefaultDataSourceBuilder:<init>	(Lcom/tencent/oskplayer/cache/Cache;Lcom/tencent/oskplayer/proxy/HttpRetryLogic;Lcom/tencent/oskplayer/proxy/VideoRequest;)V
    //   294: astore 33
    //   296: goto +3 -> 299
    //   299: aload 33
    //   301: ifnull +18 -> 319
    //   304: aload 33
    //   306: aload_2
    //   307: aload 35
    //   309: invokeinterface 1325 3 0
    //   314: astore 33
    //   316: goto +35 -> 351
    //   319: new 1181	com/tencent/oskplayer/datasource/DefaultHttpDataSource
    //   322: dup
    //   323: ldc 55
    //   325: new 1327	com/tencent/oskplayer/util/PassOnVideoType
    //   328: dup
    //   329: invokespecial 1328	com/tencent/oskplayer/util/PassOnVideoType:<init>	()V
    //   332: aload 4
    //   334: invokevirtual 1332	com/tencent/oskplayer/proxy/VideoRequest:getContentTypeFixer	()Lcom/tencent/oskplayer/util/Fixer;
    //   337: invokespecial 1184	com/tencent/oskplayer/datasource/DefaultHttpDataSource:<init>	(Ljava/lang/String;Lcom/tencent/oskplayer/util/Predicate;Lcom/tencent/oskplayer/util/Fixer;)V
    //   340: astore 33
    //   342: aload 33
    //   344: aload 35
    //   346: invokeinterface 1333 2 0
    //   351: aload 33
    //   353: ifnonnull +14 -> 367
    //   356: bipush 6
    //   358: aload 40
    //   360: ldc_w 1335
    //   363: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   366: return
    //   367: ldc_w 1336
    //   370: newarray byte
    //   372: astore 43
    //   374: getstatic 1342	com/tencent/oskplayer/proxy/FileType:UNKNOWN	Lcom/tencent/oskplayer/proxy/FileType;
    //   377: astore 41
    //   379: lload 12
    //   381: ldc2_w 929
    //   384: lcmp
    //   385: ifeq +24 -> 409
    //   388: lload 12
    //   390: ldc2_w 1343
    //   393: lcmp
    //   394: ifeq +15 -> 409
    //   397: lload 12
    //   399: lload 20
    //   401: lsub
    //   402: lconst_1
    //   403: ladd
    //   404: lstore 14
    //   406: goto +8 -> 414
    //   409: ldc2_w 929
    //   412: lstore 14
    //   414: aload_2
    //   415: invokestatic 817	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   418: astore 34
    //   420: lload 20
    //   422: ldc2_w 929
    //   425: lcmp
    //   426: ifne +9 -> 435
    //   429: lconst_0
    //   430: lstore 16
    //   432: goto +7 -> 439
    //   435: lload 20
    //   437: lstore 16
    //   439: lload 20
    //   441: ldc2_w 929
    //   444: lcmp
    //   445: ifne +9 -> 454
    //   448: lconst_0
    //   449: lstore 18
    //   451: goto +7 -> 458
    //   454: lload 20
    //   456: lstore 18
    //   458: new 836	com/tencent/oskplayer/datasource/DataSpec
    //   461: dup
    //   462: aload 34
    //   464: lload 16
    //   466: lload 18
    //   468: lload 14
    //   470: aload 45
    //   472: iconst_0
    //   473: aload 4
    //   475: invokevirtual 513	com/tencent/oskplayer/proxy/VideoRequest:getUuid	()Ljava/lang/String;
    //   478: aload 4
    //   480: invokevirtual 510	com/tencent/oskplayer/proxy/VideoRequest:getPrority	()I
    //   483: invokespecial 879	com/tencent/oskplayer/datasource/DataSpec:<init>	(Landroid/net/Uri;JJJLjava/lang/String;ILjava/lang/String;I)V
    //   486: astore 34
    //   488: new 1346	java/io/BufferedOutputStream
    //   491: dup
    //   492: aload_3
    //   493: invokespecial 1349	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   496: astore 46
    //   498: invokestatic 491	java/lang/System:currentTimeMillis	()J
    //   501: lstore 30
    //   503: new 258	java/lang/StringBuilder
    //   506: dup
    //   507: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   510: astore 35
    //   512: aload 35
    //   514: ldc_w 1351
    //   517: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   520: pop
    //   521: aload 35
    //   523: lload 20
    //   525: invokevirtual 268	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   528: pop
    //   529: aload 35
    //   531: ldc_w 1160
    //   534: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   537: pop
    //   538: aload 35
    //   540: lload 12
    //   542: invokevirtual 268	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   545: pop
    //   546: aload 35
    //   548: ldc_w 1353
    //   551: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   554: pop
    //   555: new 1355	com/tencent/oskplayer/util/VideoSpeedReport$ReportPoint
    //   558: dup
    //   559: ldc_w 1357
    //   562: iconst_0
    //   563: aload 35
    //   565: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   568: invokespecial 1360	com/tencent/oskplayer/util/VideoSpeedReport$ReportPoint:<init>	(Ljava/lang/String;ZLjava/lang/String;)V
    //   571: astore 49
    //   573: ldc_w 1362
    //   576: aload 49
    //   578: invokestatic 1368	com/tencent/oskplayer/util/VideoSpeedReport$ReportType:addToVideoReportType	(Ljava/lang/String;Lcom/tencent/oskplayer/util/VideoSpeedReport$ReportPoint;)V
    //   581: invokestatic 1373	com/tencent/oskplayer/util/VideoSpeedReport:g	()Lcom/tencent/oskplayer/util/VideoSpeedReport;
    //   584: aload 49
    //   586: invokevirtual 1376	com/tencent/oskplayer/util/VideoSpeedReport:start	(Lcom/tencent/oskplayer/util/VideoSpeedReport$ReportPoint;)V
    //   589: aload 46
    //   591: astore 52
    //   593: aload 34
    //   595: astore 42
    //   597: ldc_w 1378
    //   600: astore 47
    //   602: aload 45
    //   604: astore 51
    //   606: aload 33
    //   608: astore 39
    //   610: aload_0
    //   611: aload 33
    //   613: aload 34
    //   615: aload_2
    //   616: aload 40
    //   618: aload 4
    //   620: aload_1
    //   621: aload 45
    //   623: lconst_0
    //   624: ldc2_w 1124
    //   627: lload 30
    //   629: invokespecial 1380	com/tencent/oskplayer/proxy/VideoProxy:openDataSource	(Lcom/tencent/oskplayer/datasource/DataSource;Lcom/tencent/oskplayer/datasource/DataSpec;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/oskplayer/proxy/VideoRequest;Ljava/net/Socket;Ljava/lang/String;JJJ)Lcom/tencent/oskplayer/proxy/VideoProxy$DataSourceOpenResult;
    //   632: astore 48
    //   634: aload 48
    //   636: getfield 832	com/tencent/oskplayer/proxy/VideoProxy$DataSourceOpenResult:retCode	J
    //   639: lstore 16
    //   641: aload 48
    //   643: getfield 846	com/tencent/oskplayer/proxy/VideoProxy$DataSourceOpenResult:localPlayListFile	Ljava/io/File;
    //   646: astore 38
    //   648: aload 48
    //   650: getfield 919	com/tencent/oskplayer/proxy/VideoProxy$DataSourceOpenResult:isHandled	Z
    //   653: istore 32
    //   655: iload 32
    //   657: ifeq +213 -> 870
    //   660: new 258	java/lang/StringBuilder
    //   663: dup
    //   664: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   667: astore_2
    //   668: aload_2
    //   669: ldc_w 1382
    //   672: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   675: pop
    //   676: aload_2
    //   677: iconst_0
    //   678: invokevirtual 430	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   681: pop
    //   682: aload_2
    //   683: ldc_w 1384
    //   686: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   689: pop
    //   690: aload_2
    //   691: lload 20
    //   693: invokevirtual 268	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   696: pop
    //   697: aload_2
    //   698: ldc_w 1386
    //   701: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   704: pop
    //   705: aload_2
    //   706: lload 12
    //   708: invokevirtual 268	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   711: pop
    //   712: iconst_4
    //   713: aload 40
    //   715: aload_2
    //   716: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   719: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   722: aload 39
    //   724: invokeinterface 1210 1 0
    //   729: goto +12 -> 741
    //   732: iconst_5
    //   733: aload 40
    //   735: ldc_w 1388
    //   738: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   741: aload_1
    //   742: invokevirtual 897	java/net/Socket:close	()V
    //   745: aload 38
    //   747: ifnull +101 -> 848
    //   750: aload 38
    //   752: invokevirtual 761	java/io/File:isFile	()Z
    //   755: ifeq +93 -> 848
    //   758: aload 38
    //   760: invokevirtual 499	java/io/File:exists	()Z
    //   763: ifeq +85 -> 848
    //   766: aload 38
    //   768: invokevirtual 764	java/io/File:delete	()Z
    //   771: istore 32
    //   773: new 258	java/lang/StringBuilder
    //   776: dup
    //   777: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   780: astore_1
    //   781: aload_1
    //   782: aload 36
    //   784: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   787: pop
    //   788: aload_1
    //   789: aload 38
    //   791: invokevirtual 767	java/io/File:toString	()Ljava/lang/String;
    //   794: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   797: pop
    //   798: iconst_4
    //   799: aload 40
    //   801: aload_1
    //   802: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   805: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   808: iload 32
    //   810: ifne +38 -> 848
    //   813: new 258	java/lang/StringBuilder
    //   816: dup
    //   817: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   820: astore_1
    //   821: aload_1
    //   822: aload 47
    //   824: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   827: pop
    //   828: aload_1
    //   829: aload 38
    //   831: invokevirtual 767	java/io/File:toString	()Ljava/lang/String;
    //   834: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   837: pop
    //   838: iconst_5
    //   839: aload 40
    //   841: aload_1
    //   842: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   845: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   848: invokestatic 176	com/tencent/oskplayer/PlayerConfig:g	()Lcom/tencent/oskplayer/PlayerConfig;
    //   851: invokevirtual 979	com/tencent/oskplayer/PlayerConfig:getOnConnectionChangeListener	()Lcom/tencent/oskplayer/proxy/VideoProxy$OnConnectionChangeListener;
    //   854: astore_1
    //   855: aload_1
    //   856: ifnull +13 -> 869
    //   859: aload_1
    //   860: iconst_0
    //   861: aload 5
    //   863: aload_3
    //   864: invokeinterface 985 4 0
    //   869: return
    //   870: lload 20
    //   872: lstore 26
    //   874: lload 12
    //   876: lstore 14
    //   878: ldc_w 1382
    //   881: astore 34
    //   883: ldc_w 1384
    //   886: astore 35
    //   888: ldc_w 1386
    //   891: astore 37
    //   893: aload 40
    //   895: astore 44
    //   897: aload 48
    //   899: getfield 883	com/tencent/oskplayer/proxy/VideoProxy$DataSourceOpenResult:dataSource	Lcom/tencent/oskplayer/datasource/DataSource;
    //   902: astore 50
    //   904: aload 50
    //   906: ifnull +198 -> 1104
    //   909: aload 48
    //   911: getfield 883	com/tencent/oskplayer/proxy/VideoProxy$DataSourceOpenResult:dataSource	Lcom/tencent/oskplayer/datasource/DataSource;
    //   914: astore 39
    //   916: aload 39
    //   918: astore 33
    //   920: goto +326 -> 1246
    //   923: astore_2
    //   924: aload_2
    //   925: astore 40
    //   927: ldc_w 1388
    //   930: astore 42
    //   932: aload 38
    //   934: astore 39
    //   936: lload 14
    //   938: lstore 12
    //   940: aload 44
    //   942: astore 4
    //   944: aload 36
    //   946: astore 38
    //   948: aload 47
    //   950: astore_2
    //   951: iconst_0
    //   952: istore 6
    //   954: aload 5
    //   956: astore 41
    //   958: aload 42
    //   960: astore 5
    //   962: aload 34
    //   964: astore 36
    //   966: aload 37
    //   968: astore 34
    //   970: aload 41
    //   972: astore 37
    //   974: goto +2823 -> 3797
    //   977: astore 39
    //   979: aload 39
    //   981: astore 41
    //   983: aload 38
    //   985: astore 39
    //   987: lload 14
    //   989: lstore 12
    //   991: aload 36
    //   993: astore 38
    //   995: iconst_0
    //   996: istore 6
    //   998: iconst_1
    //   999: istore 7
    //   1001: aload 34
    //   1003: astore 36
    //   1005: aload 37
    //   1007: astore 34
    //   1009: aload 35
    //   1011: astore 37
    //   1013: aload 36
    //   1015: astore 35
    //   1017: aload 37
    //   1019: astore 36
    //   1021: aload 38
    //   1023: astore 37
    //   1025: aload 41
    //   1027: astore 38
    //   1029: lload 16
    //   1031: lstore 14
    //   1033: goto +2449 -> 3482
    //   1036: astore 39
    //   1038: aload 39
    //   1040: astore 43
    //   1042: lload 14
    //   1044: lstore 12
    //   1046: aload 33
    //   1048: astore 44
    //   1050: aload 36
    //   1052: astore 42
    //   1054: aload 41
    //   1056: astore 39
    //   1058: ldc2_w 929
    //   1061: lstore 14
    //   1063: iconst_0
    //   1064: istore 6
    //   1066: iconst_1
    //   1067: istore 7
    //   1069: aload 34
    //   1071: astore 41
    //   1073: aload 37
    //   1075: astore 36
    //   1077: aload 35
    //   1079: astore 37
    //   1081: aload 43
    //   1083: astore 33
    //   1085: aload 44
    //   1087: astore 34
    //   1089: aload 41
    //   1091: astore 35
    //   1093: aload 38
    //   1095: astore 41
    //   1097: aload 42
    //   1099: astore 38
    //   1101: goto +2825 -> 3926
    //   1104: aload 39
    //   1106: instanceof 1390
    //   1109: istore 32
    //   1111: iload 32
    //   1113: ifeq +133 -> 1246
    //   1116: aload 39
    //   1118: checkcast 1390	com/tencent/oskplayer/cache/CacheDataSource
    //   1121: invokevirtual 1394	com/tencent/oskplayer/cache/CacheDataSource:getUpstreamDataSource	()Lcom/tencent/oskplayer/datasource/DataSource;
    //   1124: astore 39
    //   1126: aload 39
    //   1128: instanceof 1396
    //   1131: ifeq +60 -> 1191
    //   1134: aload 39
    //   1136: checkcast 1396	com/tencent/oskplayer/datasource/HttpDataSource
    //   1139: invokeinterface 1399 1 0
    //   1144: astore 39
    //   1146: aload 39
    //   1148: ifnull +98 -> 1246
    //   1151: new 258	java/lang/StringBuilder
    //   1154: dup
    //   1155: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   1158: astore 48
    //   1160: aload 48
    //   1162: ldc_w 1401
    //   1165: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1168: pop
    //   1169: aload 48
    //   1171: aload 39
    //   1173: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1176: pop
    //   1177: iconst_4
    //   1178: aload 44
    //   1180: aload 48
    //   1182: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1185: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   1188: goto +58 -> 1246
    //   1191: new 258	java/lang/StringBuilder
    //   1194: dup
    //   1195: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   1198: astore 48
    //   1200: aload 48
    //   1202: ldc_w 1403
    //   1205: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1208: pop
    //   1209: aload 48
    //   1211: aload 39
    //   1213: invokevirtual 507	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1216: pop
    //   1217: bipush 6
    //   1219: aload 44
    //   1221: aload 48
    //   1223: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1226: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   1229: goto +17 -> 1246
    //   1232: astore_2
    //   1233: goto -309 -> 924
    //   1236: astore 39
    //   1238: goto -259 -> 979
    //   1241: astore 39
    //   1243: goto -205 -> 1038
    //   1246: aload 33
    //   1248: invokeinterface 1199 1 0
    //   1253: lstore 18
    //   1255: lload 16
    //   1257: lstore 22
    //   1259: aload 33
    //   1261: invokeinterface 1407 1 0
    //   1266: astore 39
    //   1268: aload 4
    //   1270: lload 18
    //   1272: aload 39
    //   1274: invokevirtual 1411	com/tencent/oskplayer/proxy/VideoRequest:updateInfo	(JLcom/tencent/oskplayer/proxy/FileType;)V
    //   1277: aload 39
    //   1279: invokevirtual 1412	com/tencent/oskplayer/proxy/FileType:toString	()Ljava/lang/String;
    //   1282: astore 48
    //   1284: aload_2
    //   1285: invokestatic 840	com/tencent/oskplayer/util/PlayerUtils:isHLSStream	(Ljava/lang/String;)Z
    //   1288: istore 32
    //   1290: iload 32
    //   1292: ifne +9 -> 1301
    //   1295: iconst_1
    //   1296: istore 32
    //   1298: goto +6 -> 1304
    //   1301: iconst_0
    //   1302: istore 32
    //   1304: aload 38
    //   1306: astore 41
    //   1308: lload 26
    //   1310: lload 14
    //   1312: lload 18
    //   1314: aload 48
    //   1316: iload 32
    //   1318: invokestatic 1416	com/tencent/oskplayer/util/HttpParser:newResponseHeader	(JJJLjava/lang/String;Z)Ljava/lang/String;
    //   1321: astore 50
    //   1323: aload 39
    //   1325: getstatic 1342	com/tencent/oskplayer/proxy/FileType:UNKNOWN	Lcom/tencent/oskplayer/proxy/FileType;
    //   1328: invokevirtual 1417	com/tencent/oskplayer/proxy/FileType:equals	(Ljava/lang/Object;)Z
    //   1331: istore 32
    //   1333: iload 32
    //   1335: ifeq +178 -> 1513
    //   1338: aload 39
    //   1340: astore 48
    //   1342: bipush 6
    //   1344: aload 44
    //   1346: ldc_w 1419
    //   1349: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   1352: goto +161 -> 1513
    //   1355: astore 43
    //   1357: goto +99 -> 1456
    //   1360: astore 40
    //   1362: lload 14
    //   1364: lstore 12
    //   1366: aload 36
    //   1368: astore 38
    //   1370: ldc_w 1388
    //   1373: astore 4
    //   1375: aload 47
    //   1377: astore_2
    //   1378: iconst_0
    //   1379: istore 6
    //   1381: aconst_null
    //   1382: astore 42
    //   1384: aload_3
    //   1385: astore 36
    //   1387: aload 5
    //   1389: astore 39
    //   1391: aload 44
    //   1393: astore_3
    //   1394: aload 34
    //   1396: astore 5
    //   1398: aload 37
    //   1400: astore 34
    //   1402: aload 39
    //   1404: astore 37
    //   1406: aload 42
    //   1408: astore 39
    //   1410: goto +5646 -> 7056
    //   1413: astore 38
    //   1415: aload 37
    //   1417: astore 39
    //   1419: lload 14
    //   1421: lstore 12
    //   1423: iconst_0
    //   1424: istore 6
    //   1426: iconst_1
    //   1427: istore 7
    //   1429: aload 36
    //   1431: astore 37
    //   1433: aload 35
    //   1435: astore 36
    //   1437: aload 34
    //   1439: astore 35
    //   1441: aload 39
    //   1443: astore 34
    //   1445: lload 22
    //   1447: lstore 14
    //   1449: aload 41
    //   1451: astore 39
    //   1453: goto +2029 -> 3482
    //   1456: aload 33
    //   1458: astore 42
    //   1460: aload 37
    //   1462: astore 39
    //   1464: aload 36
    //   1466: astore 38
    //   1468: iconst_0
    //   1469: istore 6
    //   1471: iconst_1
    //   1472: istore 7
    //   1474: aload 43
    //   1476: astore 33
    //   1478: aload 35
    //   1480: astore 37
    //   1482: aload 34
    //   1484: astore 35
    //   1486: lload 14
    //   1488: lstore 12
    //   1490: aload 42
    //   1492: astore 34
    //   1494: aload 39
    //   1496: astore 36
    //   1498: lload 18
    //   1500: lstore 14
    //   1502: aload 48
    //   1504: astore 39
    //   1506: lload 22
    //   1508: lstore 16
    //   1510: goto +2416 -> 3926
    //   1513: aload 39
    //   1515: astore 48
    //   1517: new 258	java/lang/StringBuilder
    //   1520: dup
    //   1521: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   1524: astore 53
    //   1526: aload 53
    //   1528: ldc_w 1421
    //   1531: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1534: pop
    //   1535: aload 53
    //   1537: lload 18
    //   1539: invokevirtual 268	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1542: pop
    //   1543: aload 53
    //   1545: ldc_w 1423
    //   1548: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1551: pop
    //   1552: lload 18
    //   1554: lstore 24
    //   1556: aload 53
    //   1558: aload 50
    //   1560: aconst_null
    //   1561: invokestatic 1027	com/tencent/oskplayer/util/PlayerUtils:removeLineBreaks	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1564: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1567: pop
    //   1568: iconst_4
    //   1569: aload 44
    //   1571: aload 53
    //   1573: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1576: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   1579: aload 50
    //   1581: ldc_w 541
    //   1584: invokevirtual 1426	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   1587: astore 50
    //   1589: aload 52
    //   1591: aload 50
    //   1593: invokevirtual 747	java/io/OutputStream:write	([B)V
    //   1596: aload 52
    //   1598: invokevirtual 1429	java/io/OutputStream:flush	()V
    //   1601: invokestatic 1373	com/tencent/oskplayer/util/VideoSpeedReport:g	()Lcom/tencent/oskplayer/util/VideoSpeedReport;
    //   1604: aload 49
    //   1606: invokevirtual 1431	com/tencent/oskplayer/util/VideoSpeedReport:end	(Lcom/tencent/oskplayer/util/VideoSpeedReport$ReportPoint;)V
    //   1609: invokestatic 491	java/lang/System:currentTimeMillis	()J
    //   1612: lstore 28
    //   1614: iconst_0
    //   1615: istore 6
    //   1617: iconst_1
    //   1618: istore 7
    //   1620: aload 43
    //   1622: astore 49
    //   1624: aload 42
    //   1626: astore 50
    //   1628: lload 28
    //   1630: lstore 16
    //   1632: lload 14
    //   1634: lstore 12
    //   1636: invokestatic 557	java/lang/Thread:interrupted	()Z
    //   1639: istore 32
    //   1641: iload 32
    //   1643: iconst_1
    //   1644: ixor
    //   1645: istore 7
    //   1647: iload 7
    //   1649: ifeq +5856 -> 7505
    //   1652: aload 4
    //   1654: invokevirtual 560	com/tencent/oskplayer/proxy/VideoRequest:shouldCancel	()Z
    //   1657: istore 32
    //   1659: iload 32
    //   1661: ifne +5844 -> 7505
    //   1664: lload 12
    //   1666: lstore 14
    //   1668: aload 33
    //   1670: aload 49
    //   1672: iconst_0
    //   1673: aload 49
    //   1675: arraylength
    //   1676: invokeinterface 1203 4 0
    //   1681: istore 11
    //   1683: iload 11
    //   1685: iconst_m1
    //   1686: if_icmpeq +5687 -> 7373
    //   1689: aload 4
    //   1691: invokevirtual 1434	com/tencent/oskplayer/proxy/VideoRequest:isHeadRequest	()Z
    //   1694: ifeq +6 -> 1700
    //   1697: goto +5676 -> 7373
    //   1700: invokestatic 491	java/lang/System:currentTimeMillis	()J
    //   1703: lstore 28
    //   1705: lload 28
    //   1707: lload 16
    //   1709: lsub
    //   1710: lstore 16
    //   1712: aload 37
    //   1714: astore 42
    //   1716: aload 36
    //   1718: astore 39
    //   1720: aload_0
    //   1721: getfield 183	com/tencent/oskplayer/proxy/VideoProxy:mRecvDataTreshold	I
    //   1724: istore 8
    //   1726: lload 16
    //   1728: iload 8
    //   1730: i2l
    //   1731: lcmp
    //   1732: ifle +5590 -> 7322
    //   1735: iload 6
    //   1737: istore 9
    //   1739: iload 6
    //   1741: istore 10
    //   1743: iload 6
    //   1745: istore 8
    //   1747: new 258	java/lang/StringBuilder
    //   1750: dup
    //   1751: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   1754: astore 43
    //   1756: iload 6
    //   1758: istore 9
    //   1760: iload 6
    //   1762: istore 10
    //   1764: iload 6
    //   1766: istore 8
    //   1768: aload 43
    //   1770: ldc_w 1436
    //   1773: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1776: pop
    //   1777: iload 6
    //   1779: istore 9
    //   1781: iload 6
    //   1783: istore 10
    //   1785: iload 6
    //   1787: istore 8
    //   1789: aload 43
    //   1791: lload 16
    //   1793: invokevirtual 268	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1796: pop
    //   1797: iload 6
    //   1799: istore 9
    //   1801: iload 6
    //   1803: istore 10
    //   1805: iload 6
    //   1807: istore 8
    //   1809: aload 43
    //   1811: ldc_w 1438
    //   1814: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1817: pop
    //   1818: iload 6
    //   1820: istore 9
    //   1822: iload 6
    //   1824: istore 10
    //   1826: iload 6
    //   1828: istore 8
    //   1830: iconst_5
    //   1831: aload 44
    //   1833: aload 43
    //   1835: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1838: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   1841: goto +3 -> 1844
    //   1844: iload 6
    //   1846: istore 9
    //   1848: iload 6
    //   1850: istore 10
    //   1852: iload 6
    //   1854: istore 8
    //   1856: invokestatic 491	java/lang/System:currentTimeMillis	()J
    //   1859: lstore 16
    //   1861: iload 6
    //   1863: ifne +5468 -> 7331
    //   1866: lload 26
    //   1868: lconst_0
    //   1869: lcmp
    //   1870: ifne +5461 -> 7331
    //   1873: iload 6
    //   1875: istore 9
    //   1877: iload 6
    //   1879: istore 10
    //   1881: iload 6
    //   1883: istore 8
    //   1885: aload 33
    //   1887: instanceof 1390
    //   1890: ifeq +28 -> 1918
    //   1893: iload 6
    //   1895: istore 9
    //   1897: iload 6
    //   1899: istore 10
    //   1901: iload 6
    //   1903: istore 8
    //   1905: aload 33
    //   1907: checkcast 1390	com/tencent/oskplayer/cache/CacheDataSource
    //   1910: invokevirtual 1394	com/tencent/oskplayer/cache/CacheDataSource:getUpstreamDataSource	()Lcom/tencent/oskplayer/datasource/DataSource;
    //   1913: astore 43
    //   1915: goto +30 -> 1945
    //   1918: iload 6
    //   1920: istore 9
    //   1922: iload 6
    //   1924: istore 10
    //   1926: iload 6
    //   1928: istore 8
    //   1930: aload 33
    //   1932: instanceof 1396
    //   1935: ifeq +5390 -> 7325
    //   1938: aload 33
    //   1940: astore 43
    //   1942: goto +3 -> 1945
    //   1945: aload 43
    //   1947: ifnull +5384 -> 7331
    //   1950: iload 6
    //   1952: istore 9
    //   1954: iload 6
    //   1956: istore 10
    //   1958: iload 6
    //   1960: istore 8
    //   1962: aload 43
    //   1964: instanceof 1396
    //   1967: ifeq +5364 -> 7331
    //   1970: iload 6
    //   1972: istore 9
    //   1974: iload 6
    //   1976: istore 10
    //   1978: iload 6
    //   1980: istore 8
    //   1982: aload 43
    //   1984: checkcast 1396	com/tencent/oskplayer/datasource/HttpDataSource
    //   1987: invokeinterface 1442 1 0
    //   1992: astore 43
    //   1994: aload 43
    //   1996: ifnull +55 -> 2051
    //   1999: iload 6
    //   2001: istore 9
    //   2003: iload 6
    //   2005: istore 10
    //   2007: iload 6
    //   2009: istore 8
    //   2011: aload 43
    //   2013: aload 49
    //   2015: invokeinterface 1448 2 0
    //   2020: ifeq +6 -> 2026
    //   2023: goto +5308 -> 7331
    //   2026: iload 6
    //   2028: istore 9
    //   2030: iload 6
    //   2032: istore 10
    //   2034: iload 6
    //   2036: istore 8
    //   2038: new 1450	com/tencent/oskplayer/datasource/HttpDataSource$InvalidContentException
    //   2041: dup
    //   2042: ldc_w 1452
    //   2045: aload 50
    //   2047: invokespecial 1455	com/tencent/oskplayer/datasource/HttpDataSource$InvalidContentException:<init>	(Ljava/lang/String;Lcom/tencent/oskplayer/datasource/DataSpec;)V
    //   2050: athrow
    //   2051: iload 6
    //   2053: istore 9
    //   2055: iload 6
    //   2057: istore 10
    //   2059: iload 6
    //   2061: istore 8
    //   2063: bipush 6
    //   2065: aload 44
    //   2067: ldc_w 1457
    //   2070: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2073: goto +3 -> 2076
    //   2076: iload 6
    //   2078: istore 9
    //   2080: iload 6
    //   2082: istore 10
    //   2084: iload 6
    //   2086: istore 8
    //   2088: aload 52
    //   2090: aload 49
    //   2092: iconst_0
    //   2093: iload 11
    //   2095: invokevirtual 1460	java/io/OutputStream:write	([BII)V
    //   2098: iload 6
    //   2100: iload 11
    //   2102: iadd
    //   2103: istore 6
    //   2105: iload 6
    //   2107: istore 9
    //   2109: iload 6
    //   2111: istore 10
    //   2113: iload 6
    //   2115: istore 8
    //   2117: aload 4
    //   2119: iload 11
    //   2121: invokevirtual 1463	com/tencent/oskplayer/proxy/VideoRequest:updateSentBytes	(I)V
    //   2124: iload 6
    //   2126: istore 9
    //   2128: iload 6
    //   2130: istore 10
    //   2132: iload 6
    //   2134: istore 8
    //   2136: aload 4
    //   2138: iload 6
    //   2140: invokevirtual 1466	com/tencent/oskplayer/proxy/VideoRequest:setDownloadedBytes	(I)V
    //   2143: lload 14
    //   2145: lstore 12
    //   2147: aload 42
    //   2149: astore 37
    //   2151: aload 39
    //   2153: astore 36
    //   2155: goto -519 -> 1636
    //   2158: aload 36
    //   2160: astore 38
    //   2162: aload 37
    //   2164: astore 39
    //   2166: aload 35
    //   2168: astore 42
    //   2170: aload 34
    //   2172: astore 43
    //   2174: lload 12
    //   2176: lstore 14
    //   2178: iload 7
    //   2180: ifne +226 -> 2406
    //   2183: iload 6
    //   2185: istore 9
    //   2187: iload 6
    //   2189: istore 10
    //   2191: iload 6
    //   2193: istore 8
    //   2195: aload 4
    //   2197: sipush 256
    //   2200: invokevirtual 907	com/tencent/oskplayer/proxy/VideoRequest:setStoppedReason	(I)V
    //   2203: iload 6
    //   2205: istore 9
    //   2207: iload 6
    //   2209: istore 10
    //   2211: iload 6
    //   2213: istore 8
    //   2215: new 258	java/lang/StringBuilder
    //   2218: dup
    //   2219: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   2222: astore 49
    //   2224: iload 6
    //   2226: istore 9
    //   2228: iload 6
    //   2230: istore 10
    //   2232: iload 6
    //   2234: istore 8
    //   2236: aload 49
    //   2238: aload 4
    //   2240: invokevirtual 507	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2243: pop
    //   2244: iload 6
    //   2246: istore 9
    //   2248: iload 6
    //   2250: istore 10
    //   2252: iload 6
    //   2254: istore 8
    //   2256: aload 49
    //   2258: ldc_w 909
    //   2261: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2264: pop
    //   2265: iload 6
    //   2267: istore 9
    //   2269: iload 6
    //   2271: istore 10
    //   2273: iload 6
    //   2275: istore 8
    //   2277: iconst_4
    //   2278: aload 44
    //   2280: aload 49
    //   2282: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2285: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2288: goto +118 -> 2406
    //   2291: astore 40
    //   2293: iload 9
    //   2295: istore 6
    //   2297: aload 36
    //   2299: astore 38
    //   2301: goto +5097 -> 7398
    //   2304: astore 38
    //   2306: iload 10
    //   2308: istore 6
    //   2310: aload 35
    //   2312: astore 39
    //   2314: aload 36
    //   2316: astore 42
    //   2318: aload 34
    //   2320: astore 35
    //   2322: aload 39
    //   2324: astore 36
    //   2326: aload 37
    //   2328: astore 34
    //   2330: aload 42
    //   2332: astore 37
    //   2334: lload 22
    //   2336: lstore 14
    //   2338: aload 41
    //   2340: astore 39
    //   2342: goto +1140 -> 3482
    //   2345: astore 47
    //   2347: aload 33
    //   2349: astore 39
    //   2351: lload 24
    //   2353: lstore 14
    //   2355: aload 34
    //   2357: astore 42
    //   2359: aload 35
    //   2361: astore 43
    //   2363: aload 37
    //   2365: astore 44
    //   2367: aload 36
    //   2369: astore 38
    //   2371: aload 47
    //   2373: astore 33
    //   2375: iload 8
    //   2377: istore 6
    //   2379: aload 39
    //   2381: astore 34
    //   2383: aload 42
    //   2385: astore 35
    //   2387: aload 43
    //   2389: astore 37
    //   2391: aload 44
    //   2393: astore 36
    //   2395: aload 48
    //   2397: astore 39
    //   2399: lload 22
    //   2401: lstore 16
    //   2403: goto +1523 -> 3926
    //   2406: aload 4
    //   2408: invokevirtual 560	com/tencent/oskplayer/proxy/VideoRequest:shouldCancel	()Z
    //   2411: istore 32
    //   2413: iload 32
    //   2415: ifeq +20 -> 2435
    //   2418: iload 6
    //   2420: istore 9
    //   2422: iload 6
    //   2424: istore 10
    //   2426: iload 6
    //   2428: istore 8
    //   2430: aload 4
    //   2432: invokevirtual 758	com/tencent/oskplayer/proxy/VideoRequest:enterCancelProceedState	()V
    //   2435: aload 52
    //   2437: invokevirtual 1429	java/io/OutputStream:flush	()V
    //   2440: aload 52
    //   2442: invokevirtual 753	java/io/OutputStream:close	()V
    //   2445: new 258	java/lang/StringBuilder
    //   2448: dup
    //   2449: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   2452: astore 34
    //   2454: aload 34
    //   2456: aload 43
    //   2458: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2461: pop
    //   2462: aload 34
    //   2464: iload 6
    //   2466: invokevirtual 430	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2469: pop
    //   2470: aload 34
    //   2472: aload 42
    //   2474: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2477: pop
    //   2478: aload 34
    //   2480: lload 26
    //   2482: invokevirtual 268	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2485: pop
    //   2486: aload 34
    //   2488: aload 39
    //   2490: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2493: pop
    //   2494: aload 34
    //   2496: lload 14
    //   2498: invokevirtual 268	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2501: pop
    //   2502: iconst_4
    //   2503: aload 44
    //   2505: aload 34
    //   2507: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2510: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2513: aload 33
    //   2515: invokeinterface 1210 1 0
    //   2520: goto +12 -> 2532
    //   2523: iconst_5
    //   2524: aload 44
    //   2526: ldc_w 1388
    //   2529: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2532: aload_1
    //   2533: invokevirtual 897	java/net/Socket:close	()V
    //   2536: aload 41
    //   2538: ifnull +101 -> 2639
    //   2541: aload 41
    //   2543: invokevirtual 761	java/io/File:isFile	()Z
    //   2546: ifeq +93 -> 2639
    //   2549: aload 41
    //   2551: invokevirtual 499	java/io/File:exists	()Z
    //   2554: ifeq +85 -> 2639
    //   2557: aload 41
    //   2559: invokevirtual 764	java/io/File:delete	()Z
    //   2562: istore 32
    //   2564: new 258	java/lang/StringBuilder
    //   2567: dup
    //   2568: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   2571: astore_1
    //   2572: aload_1
    //   2573: aload 38
    //   2575: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2578: pop
    //   2579: aload_1
    //   2580: aload 41
    //   2582: invokevirtual 767	java/io/File:toString	()Ljava/lang/String;
    //   2585: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2588: pop
    //   2589: iconst_4
    //   2590: aload 44
    //   2592: aload_1
    //   2593: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2596: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2599: iload 32
    //   2601: ifne +38 -> 2639
    //   2604: new 258	java/lang/StringBuilder
    //   2607: dup
    //   2608: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   2611: astore_1
    //   2612: aload_1
    //   2613: aload 47
    //   2615: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2618: pop
    //   2619: aload_1
    //   2620: aload 41
    //   2622: invokevirtual 767	java/io/File:toString	()Ljava/lang/String;
    //   2625: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2628: pop
    //   2629: iconst_5
    //   2630: aload 44
    //   2632: aload_1
    //   2633: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2636: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2639: invokestatic 176	com/tencent/oskplayer/PlayerConfig:g	()Lcom/tencent/oskplayer/PlayerConfig;
    //   2642: invokevirtual 979	com/tencent/oskplayer/PlayerConfig:getOnConnectionChangeListener	()Lcom/tencent/oskplayer/proxy/VideoProxy$OnConnectionChangeListener;
    //   2645: astore_1
    //   2646: aload_1
    //   2647: ifnull +13 -> 2660
    //   2650: aload_1
    //   2651: iconst_0
    //   2652: aload 5
    //   2654: aload_3
    //   2655: invokeinterface 985 4 0
    //   2660: aload_0
    //   2661: astore_1
    //   2662: lload 22
    //   2664: lstore 14
    //   2666: ldc2_w 1124
    //   2669: lstore 12
    //   2671: aconst_null
    //   2672: astore_3
    //   2673: goto +3206 -> 5879
    //   2676: astore 44
    //   2678: lload 14
    //   2680: lstore 12
    //   2682: aload 43
    //   2684: astore 35
    //   2686: aload 42
    //   2688: astore 36
    //   2690: aload 39
    //   2692: astore 34
    //   2694: aload 38
    //   2696: astore 37
    //   2698: aload 44
    //   2700: astore 38
    //   2702: lload 22
    //   2704: lstore 14
    //   2706: aload 41
    //   2708: astore 39
    //   2710: goto +772 -> 3482
    //   2713: astore_2
    //   2714: lload 14
    //   2716: lstore 12
    //   2718: aload 43
    //   2720: astore 35
    //   2722: aload 42
    //   2724: astore 36
    //   2726: aload 39
    //   2728: astore 34
    //   2730: aload_2
    //   2731: astore 42
    //   2733: goto +663 -> 3396
    //   2736: astore 44
    //   2738: lload 14
    //   2740: lstore 12
    //   2742: aload 43
    //   2744: astore 35
    //   2746: aload 42
    //   2748: astore 36
    //   2750: aload 39
    //   2752: astore 34
    //   2754: aload 38
    //   2756: astore 37
    //   2758: aload 44
    //   2760: astore 38
    //   2762: goto +95 -> 2857
    //   2765: astore 34
    //   2767: lload 14
    //   2769: lstore 12
    //   2771: aload 43
    //   2773: astore 35
    //   2775: aload 42
    //   2777: astore 37
    //   2779: aload 39
    //   2781: astore 36
    //   2783: lload 24
    //   2785: lstore 14
    //   2787: aload 33
    //   2789: astore 39
    //   2791: aload 34
    //   2793: astore 33
    //   2795: aload 39
    //   2797: astore 34
    //   2799: aload 48
    //   2801: astore 39
    //   2803: lload 22
    //   2805: lstore 16
    //   2807: goto +1119 -> 3926
    //   2810: astore 41
    //   2812: aload 36
    //   2814: astore 39
    //   2816: aload 34
    //   2818: astore 36
    //   2820: aload 37
    //   2822: astore 34
    //   2824: goto +279 -> 3103
    //   2827: astore 42
    //   2829: aload 37
    //   2831: astore 38
    //   2833: aload 34
    //   2835: astore 39
    //   2837: aload 36
    //   2839: astore 37
    //   2841: aload 38
    //   2843: astore 34
    //   2845: aload 35
    //   2847: astore 36
    //   2849: aload 39
    //   2851: astore 35
    //   2853: aload 42
    //   2855: astore 38
    //   2857: lload 22
    //   2859: lstore 14
    //   2861: aload 41
    //   2863: astore 39
    //   2865: goto +617 -> 3482
    //   2868: astore 39
    //   2870: aload 37
    //   2872: astore 38
    //   2874: aload 35
    //   2876: astore 37
    //   2878: aload 34
    //   2880: astore 35
    //   2882: aload 39
    //   2884: astore 34
    //   2886: lload 24
    //   2888: lstore 14
    //   2890: aload 33
    //   2892: astore 39
    //   2894: aload 36
    //   2896: astore 42
    //   2898: aload 34
    //   2900: astore 33
    //   2902: aload 39
    //   2904: astore 34
    //   2906: aload 38
    //   2908: astore 36
    //   2910: aload 48
    //   2912: astore 39
    //   2914: lload 22
    //   2916: lstore 16
    //   2918: aload 42
    //   2920: astore 38
    //   2922: goto +1004 -> 3926
    //   2925: astore 34
    //   2927: goto +5 -> 2932
    //   2930: astore 34
    //   2932: goto +20 -> 2952
    //   2935: astore 34
    //   2937: goto +15 -> 2952
    //   2940: astore 41
    //   2942: goto +138 -> 3080
    //   2945: astore 34
    //   2947: goto +91 -> 3038
    //   2950: astore 34
    //   2952: goto +24 -> 2976
    //   2955: astore_2
    //   2956: goto +74 -> 3030
    //   2959: astore 34
    //   2961: goto +40 -> 3001
    //   2964: astore 34
    //   2966: goto +10 -> 2976
    //   2969: astore 34
    //   2971: goto +30 -> 3001
    //   2974: astore 34
    //   2976: aload 39
    //   2978: astore 35
    //   2980: lload 18
    //   2982: lstore 14
    //   2984: aload 33
    //   2986: astore 36
    //   2988: aload 34
    //   2990: astore 33
    //   2992: aload 36
    //   2994: astore 34
    //   2996: goto +171 -> 3167
    //   2999: astore 34
    //   3001: goto +37 -> 3038
    //   3004: astore 34
    //   3006: lload 18
    //   3008: lstore 14
    //   3010: aload 33
    //   3012: astore 35
    //   3014: aload 34
    //   3016: astore 33
    //   3018: aload 35
    //   3020: astore 34
    //   3022: aload 41
    //   3024: astore 35
    //   3026: goto +141 -> 3167
    //   3029: astore_2
    //   3030: aload_2
    //   3031: astore 41
    //   3033: goto +47 -> 3080
    //   3036: astore 34
    //   3038: aload 34
    //   3040: astore 39
    //   3042: goto +173 -> 3215
    //   3045: astore 34
    //   3047: aload 33
    //   3049: astore 35
    //   3051: aload 34
    //   3053: astore 33
    //   3055: aload 35
    //   3057: astore 34
    //   3059: goto +99 -> 3158
    //   3062: astore_2
    //   3063: goto +14 -> 3077
    //   3066: astore 34
    //   3068: goto +73 -> 3141
    //   3071: astore 34
    //   3073: goto +73 -> 3146
    //   3076: astore_2
    //   3077: aload_2
    //   3078: astore 41
    //   3080: ldc_w 766
    //   3083: astore 39
    //   3085: ldc_w 1386
    //   3088: astore 34
    //   3090: ldc_w 1384
    //   3093: astore 35
    //   3095: ldc_w 1382
    //   3098: astore 36
    //   3100: iconst_0
    //   3101: istore 6
    //   3103: aload 38
    //   3105: astore 42
    //   3107: aload 5
    //   3109: astore 37
    //   3111: ldc_w 1388
    //   3114: astore 5
    //   3116: aload 40
    //   3118: astore 4
    //   3120: ldc_w 1378
    //   3123: astore_2
    //   3124: aload 39
    //   3126: astore 38
    //   3128: aload 42
    //   3130: astore 39
    //   3132: aload 41
    //   3134: astore 40
    //   3136: goto +661 -> 3797
    //   3139: astore 34
    //   3141: goto +70 -> 3211
    //   3144: astore 34
    //   3146: aload 34
    //   3148: astore 35
    //   3150: aload 33
    //   3152: astore 34
    //   3154: aload 35
    //   3156: astore 33
    //   3158: aload 41
    //   3160: astore 35
    //   3162: ldc2_w 929
    //   3165: lstore 14
    //   3167: aload 35
    //   3169: astore 39
    //   3171: goto +104 -> 3275
    //   3174: astore 42
    //   3176: aload 38
    //   3178: astore 41
    //   3180: aload 39
    //   3182: astore 33
    //   3184: aload 36
    //   3186: astore 38
    //   3188: ldc_w 1382
    //   3191: astore 35
    //   3193: ldc_w 1384
    //   3196: astore 36
    //   3198: ldc_w 1386
    //   3201: astore 34
    //   3203: iconst_0
    //   3204: istore 6
    //   3206: goto +190 -> 3396
    //   3209: astore 34
    //   3211: aload 34
    //   3213: astore 39
    //   3215: aload 38
    //   3217: astore 41
    //   3219: lload 16
    //   3221: lstore 14
    //   3223: ldc_w 766
    //   3226: astore 37
    //   3228: ldc_w 1386
    //   3231: astore 34
    //   3233: ldc_w 1384
    //   3236: astore 36
    //   3238: ldc_w 1382
    //   3241: astore 35
    //   3243: iconst_0
    //   3244: istore 6
    //   3246: iconst_1
    //   3247: istore 7
    //   3249: aload 39
    //   3251: astore 38
    //   3253: aload 41
    //   3255: astore 39
    //   3257: goto +225 -> 3482
    //   3260: astore 33
    //   3262: aload 39
    //   3264: astore 34
    //   3266: aload 41
    //   3268: astore 39
    //   3270: ldc2_w 929
    //   3273: lstore 14
    //   3275: ldc_w 766
    //   3278: astore 42
    //   3280: ldc_w 1386
    //   3283: astore 36
    //   3285: ldc_w 1384
    //   3288: astore 37
    //   3290: ldc_w 1382
    //   3293: astore 35
    //   3295: iconst_0
    //   3296: istore 6
    //   3298: iconst_1
    //   3299: istore 7
    //   3301: aload 38
    //   3303: astore 41
    //   3305: aload 42
    //   3307: astore 38
    //   3309: goto +617 -> 3926
    //   3312: astore 38
    //   3314: lload 16
    //   3316: lstore 14
    //   3318: aload 36
    //   3320: astore 37
    //   3322: ldc_w 1382
    //   3325: astore 35
    //   3327: ldc_w 1384
    //   3330: astore 36
    //   3332: ldc_w 1386
    //   3335: astore 34
    //   3337: aload 39
    //   3339: astore 33
    //   3341: iconst_0
    //   3342: istore 6
    //   3344: iconst_1
    //   3345: istore 7
    //   3347: aconst_null
    //   3348: astore 39
    //   3350: goto +132 -> 3482
    //   3353: astore 33
    //   3355: goto +526 -> 3881
    //   3358: astore 33
    //   3360: goto +518 -> 3878
    //   3363: astore 42
    //   3365: aload 39
    //   3367: astore 33
    //   3369: ldc_w 1382
    //   3372: astore 35
    //   3374: ldc_w 1384
    //   3377: astore_2
    //   3378: ldc_w 1386
    //   3381: astore 34
    //   3383: iconst_0
    //   3384: istore 6
    //   3386: aconst_null
    //   3387: astore 41
    //   3389: aload 36
    //   3391: astore 38
    //   3393: aload_2
    //   3394: astore 36
    //   3396: aload 5
    //   3398: astore 37
    //   3400: aload_3
    //   3401: astore 39
    //   3403: ldc_w 1388
    //   3406: astore 4
    //   3408: aload 40
    //   3410: astore_3
    //   3411: ldc_w 1378
    //   3414: astore_2
    //   3415: aconst_null
    //   3416: astore 40
    //   3418: aload 35
    //   3420: astore 5
    //   3422: aload 36
    //   3424: astore 35
    //   3426: aload 39
    //   3428: astore 36
    //   3430: aload 40
    //   3432: astore 39
    //   3434: aload 42
    //   3436: astore 40
    //   3438: goto +3618 -> 7056
    //   3441: astore 38
    //   3443: ldc_w 1382
    //   3446: astore 35
    //   3448: ldc_w 1384
    //   3451: astore 41
    //   3453: ldc_w 1386
    //   3456: astore 34
    //   3458: lconst_0
    //   3459: lstore 14
    //   3461: aload 39
    //   3463: astore 33
    //   3465: iconst_0
    //   3466: istore 6
    //   3468: iconst_1
    //   3469: istore 7
    //   3471: aconst_null
    //   3472: astore 39
    //   3474: aload 36
    //   3476: astore 37
    //   3478: aload 41
    //   3480: astore 36
    //   3482: aload 40
    //   3484: astore 41
    //   3486: new 258	java/lang/StringBuilder
    //   3489: dup
    //   3490: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   3493: astore 42
    //   3495: aload 42
    //   3497: ldc_w 1468
    //   3500: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3503: pop
    //   3504: aload 42
    //   3506: aload 38
    //   3508: invokestatic 395	com/tencent/oskplayer/util/PlayerUtils:getPrintableStackTrace	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   3511: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3514: pop
    //   3515: iconst_4
    //   3516: aload 41
    //   3518: aload 42
    //   3520: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3523: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   3526: aload 4
    //   3528: invokevirtual 560	com/tencent/oskplayer/proxy/VideoRequest:shouldCancel	()Z
    //   3531: ifeq +8 -> 3539
    //   3534: aload 4
    //   3536: invokevirtual 758	com/tencent/oskplayer/proxy/VideoRequest:enterCancelProceedState	()V
    //   3539: new 258	java/lang/StringBuilder
    //   3542: dup
    //   3543: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   3546: astore_1
    //   3547: aload_1
    //   3548: aload 35
    //   3550: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3553: pop
    //   3554: aload_1
    //   3555: iload 6
    //   3557: invokevirtual 430	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3560: pop
    //   3561: aload_1
    //   3562: aload 36
    //   3564: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3567: pop
    //   3568: aload_1
    //   3569: lload 20
    //   3571: invokevirtual 268	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3574: pop
    //   3575: aload_1
    //   3576: aload 34
    //   3578: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3581: pop
    //   3582: aload_1
    //   3583: lload 12
    //   3585: invokevirtual 268	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3588: pop
    //   3589: iconst_4
    //   3590: aload 41
    //   3592: aload_1
    //   3593: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3596: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   3599: aload 33
    //   3601: invokeinterface 1210 1 0
    //   3606: goto +12 -> 3618
    //   3609: iconst_5
    //   3610: aload 41
    //   3612: ldc_w 1388
    //   3615: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   3618: aload 39
    //   3620: ifnull +102 -> 3722
    //   3623: aload 39
    //   3625: invokevirtual 761	java/io/File:isFile	()Z
    //   3628: ifeq +94 -> 3722
    //   3631: aload 39
    //   3633: invokevirtual 499	java/io/File:exists	()Z
    //   3636: ifeq +86 -> 3722
    //   3639: aload 39
    //   3641: invokevirtual 764	java/io/File:delete	()Z
    //   3644: istore 32
    //   3646: new 258	java/lang/StringBuilder
    //   3649: dup
    //   3650: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   3653: astore_1
    //   3654: aload_1
    //   3655: aload 37
    //   3657: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3660: pop
    //   3661: aload_1
    //   3662: aload 39
    //   3664: invokevirtual 767	java/io/File:toString	()Ljava/lang/String;
    //   3667: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3670: pop
    //   3671: iconst_4
    //   3672: aload 41
    //   3674: aload_1
    //   3675: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3678: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   3681: iload 32
    //   3683: ifne +39 -> 3722
    //   3686: new 258	java/lang/StringBuilder
    //   3689: dup
    //   3690: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   3693: astore_1
    //   3694: aload_1
    //   3695: ldc_w 1378
    //   3698: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3701: pop
    //   3702: aload_1
    //   3703: aload 39
    //   3705: invokevirtual 767	java/io/File:toString	()Ljava/lang/String;
    //   3708: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3711: pop
    //   3712: iconst_5
    //   3713: aload 41
    //   3715: aload_1
    //   3716: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3719: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   3722: invokestatic 176	com/tencent/oskplayer/PlayerConfig:g	()Lcom/tencent/oskplayer/PlayerConfig;
    //   3725: invokevirtual 979	com/tencent/oskplayer/PlayerConfig:getOnConnectionChangeListener	()Lcom/tencent/oskplayer/proxy/VideoProxy$OnConnectionChangeListener;
    //   3728: astore_1
    //   3729: aload_1
    //   3730: ifnull +13 -> 3743
    //   3733: aload_1
    //   3734: iconst_0
    //   3735: aload 5
    //   3737: aload_3
    //   3738: invokeinterface 985 4 0
    //   3743: aload_0
    //   3744: astore_1
    //   3745: aload 38
    //   3747: astore_3
    //   3748: ldc2_w 1124
    //   3751: lstore 12
    //   3753: goto +2126 -> 5879
    //   3756: astore 40
    //   3758: ldc_w 1378
    //   3761: astore 42
    //   3763: aload 41
    //   3765: astore 4
    //   3767: ldc_w 1388
    //   3770: astore 41
    //   3772: aload 35
    //   3774: astore_2
    //   3775: aload 36
    //   3777: astore 35
    //   3779: aload 37
    //   3781: astore 38
    //   3783: aload 5
    //   3785: astore 37
    //   3787: aload_2
    //   3788: astore 36
    //   3790: aload 41
    //   3792: astore 5
    //   3794: aload 42
    //   3796: astore_2
    //   3797: aconst_null
    //   3798: astore 42
    //   3800: aload_3
    //   3801: astore 41
    //   3803: aload 4
    //   3805: astore_3
    //   3806: aload 5
    //   3808: astore 4
    //   3810: aload 36
    //   3812: astore 5
    //   3814: aload 41
    //   3816: astore 36
    //   3818: aload 39
    //   3820: astore 41
    //   3822: aload 42
    //   3824: astore 39
    //   3826: goto +3230 -> 7056
    //   3829: astore 40
    //   3831: aload 37
    //   3833: astore 38
    //   3835: aconst_null
    //   3836: astore 42
    //   3838: aload 5
    //   3840: astore 37
    //   3842: ldc_w 1388
    //   3845: astore 4
    //   3847: aload 35
    //   3849: astore 5
    //   3851: aload 36
    //   3853: astore 35
    //   3855: aload_3
    //   3856: astore 36
    //   3858: ldc_w 1378
    //   3861: astore_2
    //   3862: aload 41
    //   3864: astore_3
    //   3865: aload 39
    //   3867: astore 41
    //   3869: aload 42
    //   3871: astore 39
    //   3873: goto +3183 -> 7056
    //   3876: astore 33
    //   3878: lconst_0
    //   3879: lstore 16
    //   3881: ldc_w 1386
    //   3884: astore 42
    //   3886: ldc_w 1384
    //   3889: astore 37
    //   3891: ldc_w 1382
    //   3894: astore 35
    //   3896: aload 39
    //   3898: astore 34
    //   3900: aload 41
    //   3902: astore 39
    //   3904: ldc2_w 929
    //   3907: lstore 14
    //   3909: iconst_0
    //   3910: istore 6
    //   3912: iconst_1
    //   3913: istore 7
    //   3915: aconst_null
    //   3916: astore 41
    //   3918: aload 36
    //   3920: astore 38
    //   3922: aload 42
    //   3924: astore 36
    //   3926: aload 40
    //   3928: astore 42
    //   3930: lload 20
    //   3932: lstore 22
    //   3934: aload 33
    //   3936: instanceof 1470
    //   3939: istore 32
    //   3941: iload 32
    //   3943: ifeq +536 -> 4479
    //   3946: aload 33
    //   3948: checkcast 1470	com/tencent/oskplayer/datasource/HttpDataSource$InvalidResponseCodeException
    //   3951: astore 44
    //   3953: aload 4
    //   3955: invokevirtual 510	com/tencent/oskplayer/proxy/VideoRequest:getPrority	()I
    //   3958: bipush 90
    //   3960: if_icmpne +433 -> 4393
    //   3963: aload 44
    //   3965: getfield 1472	com/tencent/oskplayer/datasource/HttpDataSource$InvalidResponseCodeException:responseCode	I
    //   3968: istore 8
    //   3970: iload 8
    //   3972: sipush 416
    //   3975: if_icmpne +288 -> 4263
    //   3978: aload_0
    //   3979: getfield 314	com/tencent/oskplayer/proxy/VideoProxy:videoRequestManager	Lcom/tencent/oskplayer/proxy/VideoRequestManager;
    //   3982: astore 43
    //   3984: aload 43
    //   3986: aload 51
    //   3988: iconst_m1
    //   3989: invokevirtual 807	com/tencent/oskplayer/proxy/VideoRequestManager:getVideoRequestByVideoKey	(Ljava/lang/String;I)Ljava/util/ArrayList;
    //   3992: invokevirtual 447	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   3995: astore 43
    //   3997: aload 43
    //   3999: invokeinterface 452 1 0
    //   4004: ifeq +3507 -> 7511
    //   4007: aload 43
    //   4009: invokeinterface 456 1 0
    //   4014: checkcast 424	com/tencent/oskplayer/proxy/VideoRequest
    //   4017: astore 47
    //   4019: aload 47
    //   4021: aload 4
    //   4023: invokevirtual 1473	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   4026: ifne +3482 -> 7508
    //   4029: aload 47
    //   4031: invokevirtual 1474	com/tencent/oskplayer/proxy/VideoRequest:getTotalLength	()J
    //   4034: ldc2_w 929
    //   4037: lcmp
    //   4038: ifeq +3470 -> 7508
    //   4041: aload 47
    //   4043: invokevirtual 1474	com/tencent/oskplayer/proxy/VideoRequest:getTotalLength	()J
    //   4046: lstore 18
    //   4048: aload 47
    //   4050: invokevirtual 1475	com/tencent/oskplayer/proxy/VideoRequest:getFileType	()Lcom/tencent/oskplayer/proxy/FileType;
    //   4053: astore 39
    //   4055: goto +3 -> 4058
    //   4058: lload 18
    //   4060: ldc2_w 929
    //   4063: lcmp
    //   4064: ifeq +183 -> 4247
    //   4067: lload 18
    //   4069: lload 22
    //   4071: lcmp
    //   4072: ifne +175 -> 4247
    //   4075: lload 12
    //   4077: ldc2_w 1343
    //   4080: lcmp
    //   4081: ifne +166 -> 4247
    //   4084: aload 39
    //   4086: invokevirtual 1412	com/tencent/oskplayer/proxy/FileType:toString	()Ljava/lang/String;
    //   4089: astore 43
    //   4091: aload_2
    //   4092: invokestatic 840	com/tencent/oskplayer/util/PlayerUtils:isHLSStream	(Ljava/lang/String;)Z
    //   4095: ifne +3424 -> 7519
    //   4098: iconst_1
    //   4099: istore 32
    //   4101: goto +3 -> 4104
    //   4104: lload 22
    //   4106: lload 12
    //   4108: lload 18
    //   4110: aload 43
    //   4112: iload 32
    //   4114: invokestatic 1416	com/tencent/oskplayer/util/HttpParser:newResponseHeader	(JJJLjava/lang/String;Z)Ljava/lang/String;
    //   4117: astore 43
    //   4119: aload 39
    //   4121: getstatic 1342	com/tencent/oskplayer/proxy/FileType:UNKNOWN	Lcom/tencent/oskplayer/proxy/FileType;
    //   4124: invokevirtual 1417	com/tencent/oskplayer/proxy/FileType:equals	(Ljava/lang/Object;)Z
    //   4127: ifeq +13 -> 4140
    //   4130: bipush 6
    //   4132: aload 42
    //   4134: ldc_w 1419
    //   4137: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   4140: new 258	java/lang/StringBuilder
    //   4143: dup
    //   4144: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   4147: astore 47
    //   4149: aload 47
    //   4151: ldc_w 1421
    //   4154: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4157: pop
    //   4158: aload 47
    //   4160: lload 14
    //   4162: invokevirtual 268	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4165: pop
    //   4166: aload 47
    //   4168: ldc_w 1423
    //   4171: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4174: pop
    //   4175: aconst_null
    //   4176: astore 39
    //   4178: aload 47
    //   4180: aload 43
    //   4182: aconst_null
    //   4183: invokestatic 1027	com/tencent/oskplayer/util/PlayerUtils:removeLineBreaks	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   4186: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4189: pop
    //   4190: iconst_4
    //   4191: aload 42
    //   4193: aload 47
    //   4195: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4198: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   4201: aload 46
    //   4203: aload 43
    //   4205: ldc_w 541
    //   4208: invokevirtual 1426	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   4211: invokevirtual 747	java/io/OutputStream:write	([B)V
    //   4214: aload 46
    //   4216: invokevirtual 1429	java/io/OutputStream:flush	()V
    //   4219: aload 46
    //   4221: invokevirtual 753	java/io/OutputStream:close	()V
    //   4224: aload 39
    //   4226: astore 33
    //   4228: goto +35 -> 4263
    //   4231: astore 39
    //   4233: iconst_4
    //   4234: aload 42
    //   4236: ldc_w 1477
    //   4239: aload 39
    //   4241: invokestatic 1179	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   4244: goto +19 -> 4263
    //   4247: goto +16 -> 4263
    //   4250: astore 40
    //   4252: aload 33
    //   4254: astore 39
    //   4256: goto +362 -> 4618
    //   4259: astore_2
    //   4260: goto +150 -> 4410
    //   4263: aload 33
    //   4265: astore 39
    //   4267: aload 33
    //   4269: ifnull +128 -> 4397
    //   4272: aload 33
    //   4274: astore 39
    //   4276: new 258	java/lang/StringBuilder
    //   4279: dup
    //   4280: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   4283: astore 43
    //   4285: aload 33
    //   4287: astore 39
    //   4289: aload 43
    //   4291: ldc_w 1479
    //   4294: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4297: pop
    //   4298: aload 33
    //   4300: astore 39
    //   4302: aload 43
    //   4304: aload 4
    //   4306: invokevirtual 1481	com/tencent/oskplayer/proxy/VideoRequest:getSourceUrl	()Ljava/lang/String;
    //   4309: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4312: pop
    //   4313: aload 33
    //   4315: astore 39
    //   4317: aload 43
    //   4319: ldc_w 1483
    //   4322: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4325: pop
    //   4326: aload 33
    //   4328: astore 39
    //   4330: aload 43
    //   4332: aload 44
    //   4334: getfield 1486	com/tencent/oskplayer/datasource/HttpDataSource$InvalidResponseCodeException:headerFields	Ljava/util/Map;
    //   4337: invokestatic 1490	com/tencent/oskplayer/util/HttpParser:getHeaders	(Ljava/util/Map;)Ljava/lang/String;
    //   4340: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4343: pop
    //   4344: aload 33
    //   4346: astore 39
    //   4348: iconst_4
    //   4349: aload 42
    //   4351: aload 43
    //   4353: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4356: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   4359: aload 33
    //   4361: astore 39
    //   4363: aload 44
    //   4365: getfield 1486	com/tencent/oskplayer/datasource/HttpDataSource$InvalidResponseCodeException:headerFields	Ljava/util/Map;
    //   4368: invokestatic 1494	com/tencent/oskplayer/util/PlayerUtils:getSubErrorCode	(Ljava/util/Map;)J
    //   4371: lstore 14
    //   4373: aload 33
    //   4375: astore 39
    //   4377: aload 44
    //   4379: getfield 1472	com/tencent/oskplayer/datasource/HttpDataSource$InvalidResponseCodeException:responseCode	I
    //   4382: i2l
    //   4383: lload 14
    //   4385: invokestatic 886	com/tencent/oskplayer/util/PlayerUtils:getDownloadRetCode	(JJ)J
    //   4388: lstore 16
    //   4390: goto +16 -> 4406
    //   4393: aload 33
    //   4395: astore 39
    //   4397: ldc2_w 1124
    //   4400: lstore 14
    //   4402: aload 39
    //   4404: astore 33
    //   4406: goto +1183 -> 5589
    //   4409: astore_2
    //   4410: goto +4 -> 4414
    //   4413: astore_2
    //   4414: aload_2
    //   4415: astore 40
    //   4417: aload 33
    //   4419: astore 39
    //   4421: aload 35
    //   4423: astore 33
    //   4425: aload 34
    //   4427: astore 43
    //   4429: aload 5
    //   4431: astore 44
    //   4433: aload_3
    //   4434: astore 34
    //   4436: aload 42
    //   4438: astore_3
    //   4439: aload 37
    //   4441: astore 35
    //   4443: aload 36
    //   4445: astore 37
    //   4447: ldc_w 1388
    //   4450: astore 4
    //   4452: ldc_w 1378
    //   4455: astore_2
    //   4456: aload 33
    //   4458: astore 5
    //   4460: aload 34
    //   4462: astore 36
    //   4464: aload 37
    //   4466: astore 34
    //   4468: aload 44
    //   4470: astore 37
    //   4472: aload 43
    //   4474: astore 33
    //   4476: goto +2580 -> 7056
    //   4479: aconst_null
    //   4480: astore 43
    //   4482: aload_0
    //   4483: astore 44
    //   4485: aload 4
    //   4487: astore 39
    //   4489: aload 33
    //   4491: instanceof 1496
    //   4494: istore 32
    //   4496: iload 32
    //   4498: ifeq +127 -> 4625
    //   4501: aload 33
    //   4503: checkcast 1496	com/tencent/oskplayer/datasource/HttpDataSource$InvalidContentTypeException
    //   4506: astore 39
    //   4508: aload 4
    //   4510: invokevirtual 510	com/tencent/oskplayer/proxy/VideoRequest:getPrority	()I
    //   4513: bipush 90
    //   4515: if_icmpne +89 -> 4604
    //   4518: new 258	java/lang/StringBuilder
    //   4521: dup
    //   4522: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   4525: astore 43
    //   4527: aload 43
    //   4529: ldc_w 1479
    //   4532: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4535: pop
    //   4536: aload 43
    //   4538: aload 4
    //   4540: invokevirtual 1481	com/tencent/oskplayer/proxy/VideoRequest:getSourceUrl	()Ljava/lang/String;
    //   4543: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4546: pop
    //   4547: aload 43
    //   4549: ldc_w 1498
    //   4552: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4555: pop
    //   4556: aload 43
    //   4558: aload 39
    //   4560: getfield 1499	com/tencent/oskplayer/datasource/HttpDataSource$InvalidContentTypeException:headerFields	Ljava/util/Map;
    //   4563: invokestatic 1490	com/tencent/oskplayer/util/HttpParser:getHeaders	(Ljava/util/Map;)Ljava/lang/String;
    //   4566: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4569: pop
    //   4570: iconst_4
    //   4571: aload 42
    //   4573: aload 43
    //   4575: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4578: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   4581: aload 39
    //   4583: getfield 1499	com/tencent/oskplayer/datasource/HttpDataSource$InvalidContentTypeException:headerFields	Ljava/util/Map;
    //   4586: invokestatic 1494	com/tencent/oskplayer/util/PlayerUtils:getSubErrorCode	(Ljava/util/Map;)J
    //   4589: lstore 14
    //   4591: ldc2_w 1500
    //   4594: lload 14
    //   4596: invokestatic 886	com/tencent/oskplayer/util/PlayerUtils:getDownloadRetCode	(JJ)J
    //   4599: lstore 16
    //   4601: goto +8 -> 4609
    //   4604: ldc2_w 1124
    //   4607: lstore 14
    //   4609: goto +980 -> 5589
    //   4612: astore 40
    //   4614: aload 33
    //   4616: astore 39
    //   4618: aload 35
    //   4620: astore 33
    //   4622: goto -197 -> 4425
    //   4625: aload 33
    //   4627: instanceof 1450
    //   4630: istore 32
    //   4632: iload 32
    //   4634: ifeq +79 -> 4713
    //   4637: aload 4
    //   4639: invokevirtual 510	com/tencent/oskplayer/proxy/VideoRequest:getPrority	()I
    //   4642: bipush 90
    //   4644: if_icmpne +66 -> 4710
    //   4647: new 258	java/lang/StringBuilder
    //   4650: dup
    //   4651: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   4654: astore 39
    //   4656: aload 39
    //   4658: ldc_w 1479
    //   4661: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4664: pop
    //   4665: aload 39
    //   4667: aload 4
    //   4669: invokevirtual 1481	com/tencent/oskplayer/proxy/VideoRequest:getSourceUrl	()Ljava/lang/String;
    //   4672: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4675: pop
    //   4676: aload 39
    //   4678: ldc_w 1503
    //   4681: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4684: pop
    //   4685: iconst_4
    //   4686: aload 42
    //   4688: aload 39
    //   4690: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4693: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   4696: ldc2_w 1504
    //   4699: ldc2_w 1124
    //   4702: invokestatic 886	com/tencent/oskplayer/util/PlayerUtils:getDownloadRetCode	(JJ)J
    //   4705: lstore 16
    //   4707: goto +877 -> 5584
    //   4710: goto +874 -> 5584
    //   4713: ldc2_w 1124
    //   4716: lstore 14
    //   4718: aload 33
    //   4720: instanceof 1507
    //   4723: istore 32
    //   4725: iload 32
    //   4727: ifeq +76 -> 4803
    //   4730: aload 4
    //   4732: invokevirtual 510	com/tencent/oskplayer/proxy/VideoRequest:getPrority	()I
    //   4735: bipush 90
    //   4737: if_icmpne +847 -> 5584
    //   4740: new 258	java/lang/StringBuilder
    //   4743: dup
    //   4744: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   4747: astore 39
    //   4749: aload 39
    //   4751: ldc_w 1479
    //   4754: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4757: pop
    //   4758: aload 39
    //   4760: aload 4
    //   4762: invokevirtual 1481	com/tencent/oskplayer/proxy/VideoRequest:getSourceUrl	()Ljava/lang/String;
    //   4765: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4768: pop
    //   4769: aload 39
    //   4771: ldc_w 1509
    //   4774: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4777: pop
    //   4778: iconst_4
    //   4779: aload 42
    //   4781: aload 39
    //   4783: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4786: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   4789: ldc2_w 1510
    //   4792: ldc2_w 1124
    //   4795: invokestatic 886	com/tencent/oskplayer/util/PlayerUtils:getDownloadRetCode	(JJ)J
    //   4798: lstore 16
    //   4800: goto +784 -> 5584
    //   4803: aload 33
    //   4805: instanceof 924
    //   4808: istore 32
    //   4810: iload 32
    //   4812: ifeq +54 -> 4866
    //   4815: aload 39
    //   4817: sipush 256
    //   4820: invokevirtual 907	com/tencent/oskplayer/proxy/VideoRequest:setStoppedReason	(I)V
    //   4823: new 258	java/lang/StringBuilder
    //   4826: dup
    //   4827: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   4830: astore 43
    //   4832: aload 43
    //   4834: aload 39
    //   4836: invokevirtual 507	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4839: pop
    //   4840: aload 43
    //   4842: ldc_w 1513
    //   4845: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4848: pop
    //   4849: iconst_5
    //   4850: aload 42
    //   4852: aload 43
    //   4854: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4857: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   4860: iconst_0
    //   4861: istore 7
    //   4863: goto +726 -> 5589
    //   4866: aload 33
    //   4868: instanceof 926
    //   4871: istore 32
    //   4873: iload 32
    //   4875: ifeq +51 -> 4926
    //   4878: aload 39
    //   4880: sipush 256
    //   4883: invokevirtual 907	com/tencent/oskplayer/proxy/VideoRequest:setStoppedReason	(I)V
    //   4886: new 258	java/lang/StringBuilder
    //   4889: dup
    //   4890: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   4893: astore 43
    //   4895: aload 43
    //   4897: aload 39
    //   4899: invokevirtual 507	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4902: pop
    //   4903: aload 43
    //   4905: ldc_w 1515
    //   4908: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4911: pop
    //   4912: iconst_5
    //   4913: aload 42
    //   4915: aload 43
    //   4917: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4920: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   4923: goto -63 -> 4860
    //   4926: aload 33
    //   4928: instanceof 1517
    //   4931: istore 32
    //   4933: iload 32
    //   4935: ifeq +218 -> 5153
    //   4938: new 258	java/lang/StringBuilder
    //   4941: dup
    //   4942: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   4945: astore 44
    //   4947: aload 44
    //   4949: ldc_w 1479
    //   4952: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4955: pop
    //   4956: aload 44
    //   4958: aload 39
    //   4960: invokevirtual 507	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4963: pop
    //   4964: aload 44
    //   4966: ldc_w 1519
    //   4969: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4972: pop
    //   4973: aload 44
    //   4975: aload 33
    //   4977: invokestatic 395	com/tencent/oskplayer/util/PlayerUtils:getPrintableStackTrace	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   4980: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4983: pop
    //   4984: iconst_5
    //   4985: aload 42
    //   4987: aload 44
    //   4989: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4992: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   4995: aload 4
    //   4997: invokevirtual 510	com/tencent/oskplayer/proxy/VideoRequest:getPrority	()I
    //   5000: bipush 90
    //   5002: if_icmpne +582 -> 5584
    //   5005: aload 34
    //   5007: instanceof 1390
    //   5010: ifeq +50 -> 5060
    //   5013: aload 34
    //   5015: checkcast 1390	com/tencent/oskplayer/cache/CacheDataSource
    //   5018: invokevirtual 1394	com/tencent/oskplayer/cache/CacheDataSource:getUpstreamDataSource	()Lcom/tencent/oskplayer/datasource/DataSource;
    //   5021: astore 39
    //   5023: aload 39
    //   5025: instanceof 1181
    //   5028: ifeq +16 -> 5044
    //   5031: aload 39
    //   5033: checkcast 1181	com/tencent/oskplayer/datasource/DefaultHttpDataSource
    //   5036: invokevirtual 1523	com/tencent/oskplayer/datasource/DefaultHttpDataSource:getDataSpec	()Lcom/tencent/oskplayer/datasource/DataSpec;
    //   5039: astore 39
    //   5041: goto +41 -> 5082
    //   5044: iconst_4
    //   5045: aload 42
    //   5047: ldc_w 1525
    //   5050: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   5053: aload 43
    //   5055: astore 39
    //   5057: goto +25 -> 5082
    //   5060: aload 43
    //   5062: astore 39
    //   5064: aload 34
    //   5066: instanceof 1181
    //   5069: ifeq +13 -> 5082
    //   5072: aload 34
    //   5074: checkcast 1181	com/tencent/oskplayer/datasource/DefaultHttpDataSource
    //   5077: invokevirtual 1523	com/tencent/oskplayer/datasource/DefaultHttpDataSource:getDataSpec	()Lcom/tencent/oskplayer/datasource/DataSpec;
    //   5080: astore 39
    //   5082: aload 39
    //   5084: ifnull +2441 -> 7525
    //   5087: aload 39
    //   5089: getfield 1529	com/tencent/oskplayer/datasource/DataSpec:uri	Landroid/net/Uri;
    //   5092: astore 39
    //   5094: aload 39
    //   5096: ifnull +2429 -> 7525
    //   5099: aload 39
    //   5101: invokevirtual 1532	android/net/Uri:getHost	()Ljava/lang/String;
    //   5104: ifnull +2421 -> 7525
    //   5107: aload 39
    //   5109: invokevirtual 1532	android/net/Uri:getHost	()Ljava/lang/String;
    //   5112: ldc_w 1534
    //   5115: invokevirtual 580	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5118: ifeq +2407 -> 7525
    //   5121: iconst_1
    //   5122: istore 8
    //   5124: goto +2404 -> 7528
    //   5127: invokestatic 1537	com/tencent/oskplayer/util/PlayerUtils:isNetworkAvailable	()Z
    //   5130: ifeq +2410 -> 7540
    //   5133: iconst_5
    //   5134: istore 8
    //   5136: goto +3 -> 5139
    //   5139: iload 8
    //   5141: i2l
    //   5142: ldc2_w 1124
    //   5145: invokestatic 886	com/tencent/oskplayer/util/PlayerUtils:getDownloadRetCode	(JJ)J
    //   5148: lstore 16
    //   5150: goto +434 -> 5584
    //   5153: aload 33
    //   5155: instanceof 1539
    //   5158: istore 32
    //   5160: iload 32
    //   5162: ifeq +89 -> 5251
    //   5165: new 258	java/lang/StringBuilder
    //   5168: dup
    //   5169: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   5172: astore 43
    //   5174: aload 43
    //   5176: ldc_w 1479
    //   5179: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5182: pop
    //   5183: aload 43
    //   5185: aload 39
    //   5187: invokevirtual 507	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   5190: pop
    //   5191: aload 43
    //   5193: ldc_w 1541
    //   5196: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5199: pop
    //   5200: aload 43
    //   5202: aload 33
    //   5204: invokestatic 395	com/tencent/oskplayer/util/PlayerUtils:getPrintableStackTrace	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   5207: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5210: pop
    //   5211: iconst_5
    //   5212: aload 42
    //   5214: aload 43
    //   5216: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5219: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   5222: aload 4
    //   5224: invokevirtual 510	com/tencent/oskplayer/proxy/VideoRequest:getPrority	()I
    //   5227: bipush 90
    //   5229: if_icmpne +355 -> 5584
    //   5232: aload 44
    //   5234: aload 33
    //   5236: invokespecial 1543	com/tencent/oskplayer/proxy/VideoProxy:getFakeHttpStatus	(Ljava/lang/Throwable;)I
    //   5239: i2l
    //   5240: ldc2_w 1124
    //   5243: invokestatic 886	com/tencent/oskplayer/util/PlayerUtils:getDownloadRetCode	(JJ)J
    //   5246: lstore 16
    //   5248: goto +336 -> 5584
    //   5251: aload 34
    //   5253: instanceof 1545
    //   5256: istore 32
    //   5258: iload 32
    //   5260: ifeq +35 -> 5295
    //   5263: aload 33
    //   5265: instanceof 1547
    //   5268: ifeq +27 -> 5295
    //   5271: aload 4
    //   5273: invokevirtual 510	com/tencent/oskplayer/proxy/VideoRequest:getPrority	()I
    //   5276: bipush 90
    //   5278: if_icmpne +306 -> 5584
    //   5281: ldc2_w 1548
    //   5284: ldc2_w 1124
    //   5287: invokestatic 886	com/tencent/oskplayer/util/PlayerUtils:getDownloadRetCode	(JJ)J
    //   5290: lstore 16
    //   5292: goto +292 -> 5584
    //   5295: aload 33
    //   5297: instanceof 1551
    //   5300: istore 32
    //   5302: iload 32
    //   5304: ifeq +82 -> 5386
    //   5307: new 258	java/lang/StringBuilder
    //   5310: dup
    //   5311: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   5314: astore 43
    //   5316: aload 43
    //   5318: ldc_w 1479
    //   5321: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5324: pop
    //   5325: aload 43
    //   5327: aload 39
    //   5329: invokevirtual 507	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   5332: pop
    //   5333: aload 43
    //   5335: ldc_w 1553
    //   5338: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5341: pop
    //   5342: aload 43
    //   5344: aload 33
    //   5346: invokestatic 395	com/tencent/oskplayer/util/PlayerUtils:getPrintableStackTrace	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   5349: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5352: pop
    //   5353: iconst_5
    //   5354: aload 42
    //   5356: aload 43
    //   5358: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5361: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   5364: aload 4
    //   5366: invokevirtual 510	com/tencent/oskplayer/proxy/VideoRequest:getPrority	()I
    //   5369: bipush 90
    //   5371: if_icmpne +213 -> 5584
    //   5374: lconst_1
    //   5375: ldc2_w 1124
    //   5378: invokestatic 886	com/tencent/oskplayer/util/PlayerUtils:getDownloadRetCode	(JJ)J
    //   5381: lstore 16
    //   5383: goto +201 -> 5584
    //   5386: aload 33
    //   5388: instanceof 1555
    //   5391: istore 32
    //   5393: iload 32
    //   5395: ifeq +51 -> 5446
    //   5398: aload 39
    //   5400: sipush 256
    //   5403: invokevirtual 907	com/tencent/oskplayer/proxy/VideoRequest:setStoppedReason	(I)V
    //   5406: new 258	java/lang/StringBuilder
    //   5409: dup
    //   5410: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   5413: astore 43
    //   5415: aload 43
    //   5417: aload 39
    //   5419: invokevirtual 507	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   5422: pop
    //   5423: aload 43
    //   5425: ldc_w 909
    //   5428: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5431: pop
    //   5432: iconst_4
    //   5433: aload 42
    //   5435: aload 43
    //   5437: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5440: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   5443: goto -583 -> 4860
    //   5446: aload 44
    //   5448: getfield 1557	com/tencent/oskplayer/proxy/VideoProxy:isShutdown	Z
    //   5451: istore 32
    //   5453: iload 32
    //   5455: ifeq +15 -> 5470
    //   5458: iconst_5
    //   5459: aload 42
    //   5461: ldc_w 1559
    //   5464: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   5467: goto +117 -> 5584
    //   5470: aload 33
    //   5472: invokevirtual 1176	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   5475: ldc_w 1561
    //   5478: invokevirtual 1563	java/lang/String:matches	(Ljava/lang/String;)Z
    //   5481: istore 32
    //   5483: iload 32
    //   5485: ifeq +15 -> 5500
    //   5488: iconst_5
    //   5489: aload 42
    //   5491: ldc_w 1565
    //   5494: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   5497: goto +87 -> 5584
    //   5500: aload 33
    //   5502: invokevirtual 1163	java/lang/Exception:toString	()Ljava/lang/String;
    //   5505: ldc_w 1567
    //   5508: invokevirtual 665	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   5511: istore 32
    //   5513: iload 32
    //   5515: ifeq +15 -> 5530
    //   5518: iconst_5
    //   5519: aload 42
    //   5521: ldc_w 1569
    //   5524: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   5527: goto +57 -> 5584
    //   5530: new 258	java/lang/StringBuilder
    //   5533: dup
    //   5534: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   5537: astore 43
    //   5539: aload 43
    //   5541: aload 39
    //   5543: invokevirtual 507	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   5546: pop
    //   5547: aload 43
    //   5549: ldc_w 1571
    //   5552: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5555: pop
    //   5556: aload 43
    //   5558: aload 33
    //   5560: invokestatic 395	com/tencent/oskplayer/util/PlayerUtils:getPrintableStackTrace	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   5563: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5566: pop
    //   5567: iconst_5
    //   5568: aload 42
    //   5570: aload 43
    //   5572: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5575: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   5578: aload 4
    //   5580: invokevirtual 510	com/tencent/oskplayer/proxy/VideoRequest:getPrority	()I
    //   5583: pop
    //   5584: ldc2_w 1124
    //   5587: lstore 14
    //   5589: aload 37
    //   5591: astore 44
    //   5593: aload 35
    //   5595: astore 46
    //   5597: lload 12
    //   5599: lstore 18
    //   5601: iload 6
    //   5603: istore 8
    //   5605: aload_0
    //   5606: astore 43
    //   5608: aload 4
    //   5610: invokevirtual 560	com/tencent/oskplayer/proxy/VideoRequest:shouldCancel	()Z
    //   5613: istore 32
    //   5615: iload 32
    //   5617: ifeq +20 -> 5637
    //   5620: aload 33
    //   5622: astore 39
    //   5624: aload 4
    //   5626: invokevirtual 758	com/tencent/oskplayer/proxy/VideoRequest:enterCancelProceedState	()V
    //   5629: goto +8 -> 5637
    //   5632: astore 40
    //   5634: goto -1016 -> 4618
    //   5637: new 258	java/lang/StringBuilder
    //   5640: dup
    //   5641: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   5644: astore 35
    //   5646: aload 35
    //   5648: aload 46
    //   5650: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5653: pop
    //   5654: aload 35
    //   5656: iload 8
    //   5658: invokevirtual 430	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5661: pop
    //   5662: aload 35
    //   5664: aload 44
    //   5666: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5669: pop
    //   5670: aload 35
    //   5672: lload 22
    //   5674: invokevirtual 268	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5677: pop
    //   5678: aload 35
    //   5680: aload 36
    //   5682: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5685: pop
    //   5686: aload 35
    //   5688: lload 18
    //   5690: invokevirtual 268	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5693: pop
    //   5694: iconst_4
    //   5695: aload 42
    //   5697: aload 35
    //   5699: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5702: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   5705: aload 34
    //   5707: invokeinterface 1210 1 0
    //   5712: goto +12 -> 5724
    //   5715: iconst_5
    //   5716: aload 42
    //   5718: ldc_w 1388
    //   5721: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   5724: aload 33
    //   5726: ifnonnull +10 -> 5736
    //   5729: aload_1
    //   5730: invokevirtual 897	java/net/Socket:close	()V
    //   5733: goto +3 -> 5736
    //   5736: aload 41
    //   5738: ifnull +102 -> 5840
    //   5741: aload 41
    //   5743: invokevirtual 761	java/io/File:isFile	()Z
    //   5746: ifeq +94 -> 5840
    //   5749: aload 41
    //   5751: invokevirtual 499	java/io/File:exists	()Z
    //   5754: ifeq +86 -> 5840
    //   5757: aload 41
    //   5759: invokevirtual 764	java/io/File:delete	()Z
    //   5762: istore 32
    //   5764: new 258	java/lang/StringBuilder
    //   5767: dup
    //   5768: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   5771: astore_1
    //   5772: aload_1
    //   5773: aload 38
    //   5775: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5778: pop
    //   5779: aload_1
    //   5780: aload 41
    //   5782: invokevirtual 767	java/io/File:toString	()Ljava/lang/String;
    //   5785: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5788: pop
    //   5789: iconst_4
    //   5790: aload 42
    //   5792: aload_1
    //   5793: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5796: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   5799: iload 32
    //   5801: ifne +39 -> 5840
    //   5804: new 258	java/lang/StringBuilder
    //   5807: dup
    //   5808: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   5811: astore_1
    //   5812: aload_1
    //   5813: ldc_w 1378
    //   5816: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5819: pop
    //   5820: aload_1
    //   5821: aload 41
    //   5823: invokevirtual 767	java/io/File:toString	()Ljava/lang/String;
    //   5826: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5829: pop
    //   5830: iconst_5
    //   5831: aload 42
    //   5833: aload_1
    //   5834: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5837: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   5840: invokestatic 176	com/tencent/oskplayer/PlayerConfig:g	()Lcom/tencent/oskplayer/PlayerConfig;
    //   5843: invokevirtual 979	com/tencent/oskplayer/PlayerConfig:getOnConnectionChangeListener	()Lcom/tencent/oskplayer/proxy/VideoProxy$OnConnectionChangeListener;
    //   5846: astore_1
    //   5847: aload_1
    //   5848: ifnull +13 -> 5861
    //   5851: aload_1
    //   5852: iconst_0
    //   5853: aload 5
    //   5855: aload_3
    //   5856: invokeinterface 985 4 0
    //   5861: aload 33
    //   5863: astore_3
    //   5864: lload 14
    //   5866: lstore 12
    //   5868: lload 16
    //   5870: lstore 14
    //   5872: aload 43
    //   5874: astore_1
    //   5875: aload 34
    //   5877: astore 33
    //   5879: aload 4
    //   5881: astore 5
    //   5883: aload_1
    //   5884: getfield 314	com/tencent/oskplayer/proxy/VideoProxy:videoRequestManager	Lcom/tencent/oskplayer/proxy/VideoRequestManager;
    //   5887: aload 5
    //   5889: invokevirtual 901	com/tencent/oskplayer/proxy/VideoRequestManager:removeRequest	(Lcom/tencent/oskplayer/proxy/VideoRequest;)V
    //   5892: aload 4
    //   5894: invokevirtual 904	com/tencent/oskplayer/proxy/VideoRequest:isCancelProcceed	()Z
    //   5897: ifeq +11 -> 5908
    //   5900: aload 4
    //   5902: invokevirtual 912	com/tencent/oskplayer/proxy/VideoRequest:enterCancelSuccessState	()V
    //   5905: goto +15 -> 5920
    //   5908: iload 7
    //   5910: ifeq +10 -> 5920
    //   5913: aload 5
    //   5915: bipush 16
    //   5917: invokevirtual 907	com/tencent/oskplayer/proxy/VideoRequest:setStoppedReason	(I)V
    //   5920: aload 5
    //   5922: iconst_1
    //   5923: invokevirtual 916	com/tencent/oskplayer/proxy/VideoRequest:setIsStopped	(Z)V
    //   5926: aload 4
    //   5928: invokevirtual 513	com/tencent/oskplayer/proxy/VideoRequest:getUuid	()Ljava/lang/String;
    //   5931: astore 5
    //   5933: invokestatic 176	com/tencent/oskplayer/PlayerConfig:g	()Lcom/tencent/oskplayer/PlayerConfig;
    //   5936: invokevirtual 1123	com/tencent/oskplayer/PlayerConfig:getVideoReporter	()Lcom/tencent/oskplayer/report/IVideoReporter;
    //   5939: ifnull +112 -> 6051
    //   5942: lload 14
    //   5944: lload 12
    //   5946: invokestatic 1141	com/tencent/oskplayer/util/PlayerUtils:getDownloadResponseCode	(JJ)J
    //   5949: lstore 16
    //   5951: aload 5
    //   5953: invokestatic 1146	com/tencent/oskplayer/proxy/UuidPlayIdMap:isUuidDeleted	(Ljava/lang/String;)Z
    //   5956: ifne +95 -> 6051
    //   5959: new 207	java/util/HashMap
    //   5962: dup
    //   5963: invokespecial 208	java/util/HashMap:<init>	()V
    //   5966: astore 34
    //   5968: new 258	java/lang/StringBuilder
    //   5971: dup
    //   5972: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   5975: astore 35
    //   5977: aload 35
    //   5979: ldc_w 1158
    //   5982: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5985: pop
    //   5986: aload 35
    //   5988: lload 16
    //   5990: invokevirtual 268	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5993: pop
    //   5994: aload 35
    //   5996: ldc_w 1160
    //   5999: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6002: pop
    //   6003: aload 35
    //   6005: lload 12
    //   6007: invokevirtual 268	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6010: pop
    //   6011: aload 35
    //   6013: ldc_w 1573
    //   6016: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6019: pop
    //   6020: aload 34
    //   6022: ldc_w 1165
    //   6025: aload 35
    //   6027: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6030: invokevirtual 1154	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   6033: pop
    //   6034: invokestatic 176	com/tencent/oskplayer/PlayerConfig:g	()Lcom/tencent/oskplayer/PlayerConfig;
    //   6037: invokevirtual 1123	com/tencent/oskplayer/PlayerConfig:getVideoReporter	()Lcom/tencent/oskplayer/report/IVideoReporter;
    //   6040: aload 5
    //   6042: lload 14
    //   6044: aload 34
    //   6046: invokeinterface 1171 5 0
    //   6051: aload_1
    //   6052: getfield 212	com/tencent/oskplayer/proxy/VideoProxy:httpUrlErrorListenerMap	Ljava/util/Map;
    //   6055: aload 45
    //   6057: invokeinterface 701 2 0
    //   6062: checkcast 888	com/tencent/oskplayer/proxy/VideoProxy$HttpErrorListener
    //   6065: astore 35
    //   6067: aload_1
    //   6068: getfield 214	com/tencent/oskplayer/proxy/VideoProxy:uuidErrorListenerMap	Ljava/util/Map;
    //   6071: aload 4
    //   6073: invokevirtual 513	com/tencent/oskplayer/proxy/VideoRequest:getUuid	()Ljava/lang/String;
    //   6076: invokeinterface 701 2 0
    //   6081: checkcast 888	com/tencent/oskplayer/proxy/VideoProxy$HttpErrorListener
    //   6084: astore 5
    //   6086: new 207	java/util/HashMap
    //   6089: dup
    //   6090: invokespecial 208	java/util/HashMap:<init>	()V
    //   6093: astore 34
    //   6095: aload 34
    //   6097: ldc_w 1574
    //   6100: aload 4
    //   6102: invokevirtual 510	com/tencent/oskplayer/proxy/VideoRequest:getPrority	()I
    //   6105: invokestatic 1577	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   6108: invokevirtual 1154	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   6111: pop
    //   6112: aload_3
    //   6113: instanceof 1470
    //   6116: ifeq +92 -> 6208
    //   6119: aload_3
    //   6120: checkcast 1470	com/tencent/oskplayer/datasource/HttpDataSource$InvalidResponseCodeException
    //   6123: astore_1
    //   6124: aload 35
    //   6126: ifnull +40 -> 6166
    //   6129: aload 35
    //   6131: aload 4
    //   6133: invokevirtual 513	com/tencent/oskplayer/proxy/VideoRequest:getUuid	()Ljava/lang/String;
    //   6136: aload_2
    //   6137: aload_1
    //   6138: getfield 1472	com/tencent/oskplayer/datasource/HttpDataSource$InvalidResponseCodeException:responseCode	I
    //   6141: aload 34
    //   6143: aload_1
    //   6144: getfield 1486	com/tencent/oskplayer/datasource/HttpDataSource$InvalidResponseCodeException:headerFields	Ljava/util/Map;
    //   6147: invokestatic 491	java/lang/System:currentTimeMillis	()J
    //   6150: lload 30
    //   6152: lsub
    //   6153: l2i
    //   6154: lload 14
    //   6156: lload 12
    //   6158: invokeinterface 892 11 0
    //   6163: goto +3 -> 6166
    //   6166: aload 5
    //   6168: ifnull +747 -> 6915
    //   6171: aload 5
    //   6173: aload 4
    //   6175: invokevirtual 513	com/tencent/oskplayer/proxy/VideoRequest:getUuid	()Ljava/lang/String;
    //   6178: aload_2
    //   6179: aload_1
    //   6180: getfield 1472	com/tencent/oskplayer/datasource/HttpDataSource$InvalidResponseCodeException:responseCode	I
    //   6183: aload 34
    //   6185: aload_1
    //   6186: getfield 1486	com/tencent/oskplayer/datasource/HttpDataSource$InvalidResponseCodeException:headerFields	Ljava/util/Map;
    //   6189: invokestatic 491	java/lang/System:currentTimeMillis	()J
    //   6192: lload 30
    //   6194: lsub
    //   6195: l2i
    //   6196: lload 14
    //   6198: lload 12
    //   6200: invokeinterface 892 11 0
    //   6205: goto +710 -> 6915
    //   6208: aload_3
    //   6209: instanceof 1496
    //   6212: ifeq +83 -> 6295
    //   6215: aload_3
    //   6216: checkcast 1496	com/tencent/oskplayer/datasource/HttpDataSource$InvalidContentTypeException
    //   6219: astore_1
    //   6220: aload 35
    //   6222: ifnull +34 -> 6256
    //   6225: aload 35
    //   6227: aload 4
    //   6229: invokevirtual 513	com/tencent/oskplayer/proxy/VideoRequest:getUuid	()Ljava/lang/String;
    //   6232: aload_2
    //   6233: iconst_3
    //   6234: aload 34
    //   6236: aload_1
    //   6237: getfield 1499	com/tencent/oskplayer/datasource/HttpDataSource$InvalidContentTypeException:headerFields	Ljava/util/Map;
    //   6240: invokestatic 491	java/lang/System:currentTimeMillis	()J
    //   6243: lload 30
    //   6245: lsub
    //   6246: l2i
    //   6247: lload 14
    //   6249: lload 12
    //   6251: invokeinterface 892 11 0
    //   6256: aload 5
    //   6258: ifnull +657 -> 6915
    //   6261: aload 5
    //   6263: aload 4
    //   6265: invokevirtual 513	com/tencent/oskplayer/proxy/VideoRequest:getUuid	()Ljava/lang/String;
    //   6268: aload_2
    //   6269: iconst_3
    //   6270: aload 34
    //   6272: aload_1
    //   6273: getfield 1499	com/tencent/oskplayer/datasource/HttpDataSource$InvalidContentTypeException:headerFields	Ljava/util/Map;
    //   6276: invokestatic 491	java/lang/System:currentTimeMillis	()J
    //   6279: lload 30
    //   6281: lsub
    //   6282: l2i
    //   6283: lload 14
    //   6285: lload 12
    //   6287: invokeinterface 892 11 0
    //   6292: goto +623 -> 6915
    //   6295: aload_3
    //   6296: instanceof 1450
    //   6299: ifeq +99 -> 6398
    //   6302: aload_1
    //   6303: getfield 212	com/tencent/oskplayer/proxy/VideoProxy:httpUrlErrorListenerMap	Ljava/util/Map;
    //   6306: aload 45
    //   6308: invokeinterface 701 2 0
    //   6313: checkcast 888	com/tencent/oskplayer/proxy/VideoProxy$HttpErrorListener
    //   6316: astore_1
    //   6317: aload_1
    //   6318: ifnull +37 -> 6355
    //   6321: aload_1
    //   6322: aload 4
    //   6324: invokevirtual 513	com/tencent/oskplayer/proxy/VideoRequest:getUuid	()Ljava/lang/String;
    //   6327: aload_2
    //   6328: bipush 10
    //   6330: aload 34
    //   6332: new 207	java/util/HashMap
    //   6335: dup
    //   6336: invokespecial 208	java/util/HashMap:<init>	()V
    //   6339: invokestatic 491	java/lang/System:currentTimeMillis	()J
    //   6342: lload 30
    //   6344: lsub
    //   6345: l2i
    //   6346: lload 14
    //   6348: lload 12
    //   6350: invokeinterface 892 11 0
    //   6355: aload 5
    //   6357: ifnull +558 -> 6915
    //   6360: aload 5
    //   6362: aload 4
    //   6364: invokevirtual 513	com/tencent/oskplayer/proxy/VideoRequest:getUuid	()Ljava/lang/String;
    //   6367: aload_2
    //   6368: bipush 10
    //   6370: aload 34
    //   6372: new 207	java/util/HashMap
    //   6375: dup
    //   6376: invokespecial 208	java/util/HashMap:<init>	()V
    //   6379: invokestatic 491	java/lang/System:currentTimeMillis	()J
    //   6382: lload 30
    //   6384: lsub
    //   6385: l2i
    //   6386: lload 14
    //   6388: lload 12
    //   6390: invokeinterface 892 11 0
    //   6395: goto +520 -> 6915
    //   6398: aload_3
    //   6399: instanceof 1507
    //   6402: ifeq +86 -> 6488
    //   6405: aload 35
    //   6407: ifnull +38 -> 6445
    //   6410: aload 35
    //   6412: aload 4
    //   6414: invokevirtual 513	com/tencent/oskplayer/proxy/VideoRequest:getUuid	()Ljava/lang/String;
    //   6417: aload_2
    //   6418: bipush 12
    //   6420: aload 34
    //   6422: new 207	java/util/HashMap
    //   6425: dup
    //   6426: invokespecial 208	java/util/HashMap:<init>	()V
    //   6429: invokestatic 491	java/lang/System:currentTimeMillis	()J
    //   6432: lload 30
    //   6434: lsub
    //   6435: l2i
    //   6436: lload 14
    //   6438: lload 12
    //   6440: invokeinterface 892 11 0
    //   6445: aload 5
    //   6447: ifnull +468 -> 6915
    //   6450: aload 5
    //   6452: aload 4
    //   6454: invokevirtual 513	com/tencent/oskplayer/proxy/VideoRequest:getUuid	()Ljava/lang/String;
    //   6457: aload_2
    //   6458: bipush 12
    //   6460: aload 34
    //   6462: new 207	java/util/HashMap
    //   6465: dup
    //   6466: invokespecial 208	java/util/HashMap:<init>	()V
    //   6469: invokestatic 491	java/lang/System:currentTimeMillis	()J
    //   6472: lload 30
    //   6474: lsub
    //   6475: l2i
    //   6476: lload 14
    //   6478: lload 12
    //   6480: invokeinterface 892 11 0
    //   6485: goto +430 -> 6915
    //   6488: aload_3
    //   6489: instanceof 924
    //   6492: ifeq +6 -> 6498
    //   6495: goto +420 -> 6915
    //   6498: aload_3
    //   6499: instanceof 926
    //   6502: ifeq +6 -> 6508
    //   6505: goto +410 -> 6915
    //   6508: aload_3
    //   6509: instanceof 1517
    //   6512: ifeq +122 -> 6634
    //   6515: aload 35
    //   6517: ifnull +56 -> 6573
    //   6520: aload 4
    //   6522: invokevirtual 513	com/tencent/oskplayer/proxy/VideoRequest:getUuid	()Ljava/lang/String;
    //   6525: astore_1
    //   6526: invokestatic 1537	com/tencent/oskplayer/util/PlayerUtils:isNetworkAvailable	()Z
    //   6529: ifeq +9 -> 6538
    //   6532: iconst_5
    //   6533: istore 6
    //   6535: goto +7 -> 6542
    //   6538: bipush 9
    //   6540: istore 6
    //   6542: aload 35
    //   6544: aload_1
    //   6545: aload_2
    //   6546: iload 6
    //   6548: aload 34
    //   6550: new 207	java/util/HashMap
    //   6553: dup
    //   6554: invokespecial 208	java/util/HashMap:<init>	()V
    //   6557: invokestatic 491	java/lang/System:currentTimeMillis	()J
    //   6560: lload 30
    //   6562: lsub
    //   6563: l2i
    //   6564: lload 14
    //   6566: lload 12
    //   6568: invokeinterface 892 11 0
    //   6573: aload 5
    //   6575: ifnull +340 -> 6915
    //   6578: aload 4
    //   6580: invokevirtual 513	com/tencent/oskplayer/proxy/VideoRequest:getUuid	()Ljava/lang/String;
    //   6583: astore_1
    //   6584: invokestatic 1537	com/tencent/oskplayer/util/PlayerUtils:isNetworkAvailable	()Z
    //   6587: ifeq +9 -> 6596
    //   6590: iconst_5
    //   6591: istore 6
    //   6593: goto +7 -> 6600
    //   6596: bipush 9
    //   6598: istore 6
    //   6600: aload 5
    //   6602: aload_1
    //   6603: aload_2
    //   6604: iload 6
    //   6606: aload 34
    //   6608: new 207	java/util/HashMap
    //   6611: dup
    //   6612: invokespecial 208	java/util/HashMap:<init>	()V
    //   6615: invokestatic 491	java/lang/System:currentTimeMillis	()J
    //   6618: lload 30
    //   6620: lsub
    //   6621: l2i
    //   6622: lload 14
    //   6624: lload 12
    //   6626: invokeinterface 892 11 0
    //   6631: goto +284 -> 6915
    //   6634: aload_3
    //   6635: instanceof 1539
    //   6638: ifeq +92 -> 6730
    //   6641: aload 35
    //   6643: ifnull +41 -> 6684
    //   6646: aload 35
    //   6648: aload 4
    //   6650: invokevirtual 513	com/tencent/oskplayer/proxy/VideoRequest:getUuid	()Ljava/lang/String;
    //   6653: aload_2
    //   6654: aload_1
    //   6655: aload_3
    //   6656: invokespecial 1543	com/tencent/oskplayer/proxy/VideoProxy:getFakeHttpStatus	(Ljava/lang/Throwable;)I
    //   6659: aload 34
    //   6661: new 207	java/util/HashMap
    //   6664: dup
    //   6665: invokespecial 208	java/util/HashMap:<init>	()V
    //   6668: invokestatic 491	java/lang/System:currentTimeMillis	()J
    //   6671: lload 30
    //   6673: lsub
    //   6674: l2i
    //   6675: lload 14
    //   6677: lload 12
    //   6679: invokeinterface 892 11 0
    //   6684: aload 5
    //   6686: ifnull +229 -> 6915
    //   6689: aload 5
    //   6691: aload 4
    //   6693: invokevirtual 513	com/tencent/oskplayer/proxy/VideoRequest:getUuid	()Ljava/lang/String;
    //   6696: aload_2
    //   6697: aload_1
    //   6698: aload_3
    //   6699: invokespecial 1543	com/tencent/oskplayer/proxy/VideoProxy:getFakeHttpStatus	(Ljava/lang/Throwable;)I
    //   6702: aload 34
    //   6704: new 207	java/util/HashMap
    //   6707: dup
    //   6708: invokespecial 208	java/util/HashMap:<init>	()V
    //   6711: invokestatic 491	java/lang/System:currentTimeMillis	()J
    //   6714: lload 30
    //   6716: lsub
    //   6717: l2i
    //   6718: lload 14
    //   6720: lload 12
    //   6722: invokeinterface 892 11 0
    //   6727: goto +188 -> 6915
    //   6730: aload 33
    //   6732: instanceof 1545
    //   6735: ifeq +95 -> 6830
    //   6738: aload_3
    //   6739: instanceof 1547
    //   6742: ifeq +88 -> 6830
    //   6745: aload 34
    //   6747: ldc_w 1579
    //   6750: ldc_w 1581
    //   6753: invokevirtual 1154	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   6756: pop
    //   6757: aload 35
    //   6759: ifnull +33 -> 6792
    //   6762: aload 35
    //   6764: aload 4
    //   6766: invokevirtual 513	com/tencent/oskplayer/proxy/VideoRequest:getUuid	()Ljava/lang/String;
    //   6769: aload_2
    //   6770: sipush 1404
    //   6773: aload 34
    //   6775: aconst_null
    //   6776: invokestatic 491	java/lang/System:currentTimeMillis	()J
    //   6779: lload 30
    //   6781: lsub
    //   6782: l2i
    //   6783: lload 14
    //   6785: lload 12
    //   6787: invokeinterface 892 11 0
    //   6792: aload 5
    //   6794: ifnull +121 -> 6915
    //   6797: aload 5
    //   6799: aload 4
    //   6801: invokevirtual 513	com/tencent/oskplayer/proxy/VideoRequest:getUuid	()Ljava/lang/String;
    //   6804: aload_2
    //   6805: sipush 1404
    //   6808: aload 34
    //   6810: aconst_null
    //   6811: invokestatic 491	java/lang/System:currentTimeMillis	()J
    //   6814: lload 30
    //   6816: lsub
    //   6817: l2i
    //   6818: lload 14
    //   6820: lload 12
    //   6822: invokeinterface 892 11 0
    //   6827: goto +88 -> 6915
    //   6830: aload_3
    //   6831: instanceof 1551
    //   6834: ifeq +81 -> 6915
    //   6837: aload 35
    //   6839: ifnull +37 -> 6876
    //   6842: aload 35
    //   6844: aload 4
    //   6846: invokevirtual 513	com/tencent/oskplayer/proxy/VideoRequest:getUuid	()Ljava/lang/String;
    //   6849: aload_2
    //   6850: iconst_1
    //   6851: aload 34
    //   6853: new 207	java/util/HashMap
    //   6856: dup
    //   6857: invokespecial 208	java/util/HashMap:<init>	()V
    //   6860: invokestatic 491	java/lang/System:currentTimeMillis	()J
    //   6863: lload 30
    //   6865: lsub
    //   6866: l2i
    //   6867: lload 14
    //   6869: lload 12
    //   6871: invokeinterface 892 11 0
    //   6876: aload 5
    //   6878: ifnull +37 -> 6915
    //   6881: aload 5
    //   6883: aload 4
    //   6885: invokevirtual 513	com/tencent/oskplayer/proxy/VideoRequest:getUuid	()Ljava/lang/String;
    //   6888: aload_2
    //   6889: iconst_1
    //   6890: aload 34
    //   6892: new 207	java/util/HashMap
    //   6895: dup
    //   6896: invokespecial 208	java/util/HashMap:<init>	()V
    //   6899: invokestatic 491	java/lang/System:currentTimeMillis	()J
    //   6902: lload 30
    //   6904: lsub
    //   6905: l2i
    //   6906: lload 14
    //   6908: lload 12
    //   6910: invokeinterface 892 11 0
    //   6915: iconst_4
    //   6916: aload 40
    //   6918: ldc_w 1583
    //   6921: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   6924: return
    //   6925: astore 40
    //   6927: aload 5
    //   6929: astore 37
    //   6931: aload 42
    //   6933: astore 4
    //   6935: lload 18
    //   6937: lstore 12
    //   6939: aload 46
    //   6941: astore 5
    //   6943: aload 44
    //   6945: astore 35
    //   6947: aload 36
    //   6949: astore 42
    //   6951: ldc_w 1378
    //   6954: astore_2
    //   6955: aload_3
    //   6956: astore 36
    //   6958: aload 34
    //   6960: astore 43
    //   6962: aload 33
    //   6964: astore 39
    //   6966: iload 8
    //   6968: istore 6
    //   6970: ldc_w 1388
    //   6973: astore 33
    //   6975: aload 4
    //   6977: astore_3
    //   6978: aload 33
    //   6980: astore 4
    //   6982: aload 42
    //   6984: astore 34
    //   6986: aload 43
    //   6988: astore 33
    //   6990: goto +66 -> 7056
    //   6993: astore_2
    //   6994: goto +4 -> 6998
    //   6997: astore_2
    //   6998: aload 5
    //   7000: astore 43
    //   7002: aload 37
    //   7004: astore 4
    //   7006: aload 35
    //   7008: astore 5
    //   7010: ldc_w 1388
    //   7013: astore 45
    //   7015: ldc_w 1378
    //   7018: astore 44
    //   7020: aload 33
    //   7022: astore 39
    //   7024: aload 34
    //   7026: astore 33
    //   7028: aload_2
    //   7029: astore 40
    //   7031: aload 43
    //   7033: astore 37
    //   7035: aload 36
    //   7037: astore 34
    //   7039: aload_3
    //   7040: astore 36
    //   7042: aload 4
    //   7044: astore 35
    //   7046: aload 45
    //   7048: astore 4
    //   7050: aload 42
    //   7052: astore_3
    //   7053: aload 44
    //   7055: astore_2
    //   7056: new 258	java/lang/StringBuilder
    //   7059: dup
    //   7060: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   7063: astore 42
    //   7065: aload 42
    //   7067: aload 5
    //   7069: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7072: pop
    //   7073: aload 42
    //   7075: iload 6
    //   7077: invokevirtual 430	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7080: pop
    //   7081: aload 42
    //   7083: aload 35
    //   7085: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7088: pop
    //   7089: aload 42
    //   7091: lload 20
    //   7093: invokevirtual 268	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7096: pop
    //   7097: aload 42
    //   7099: aload 34
    //   7101: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7104: pop
    //   7105: aload 42
    //   7107: lload 12
    //   7109: invokevirtual 268	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7112: pop
    //   7113: iconst_4
    //   7114: aload_3
    //   7115: aload 42
    //   7117: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7120: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   7123: aload 33
    //   7125: invokeinterface 1210 1 0
    //   7130: goto +10 -> 7140
    //   7133: iconst_5
    //   7134: aload_3
    //   7135: aload 4
    //   7137: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   7140: aload 39
    //   7142: ifnonnull +10 -> 7152
    //   7145: aload_1
    //   7146: invokevirtual 897	java/net/Socket:close	()V
    //   7149: goto +3 -> 7152
    //   7152: aload 41
    //   7154: ifnull +98 -> 7252
    //   7157: aload 41
    //   7159: invokevirtual 761	java/io/File:isFile	()Z
    //   7162: ifeq +90 -> 7252
    //   7165: aload 41
    //   7167: invokevirtual 499	java/io/File:exists	()Z
    //   7170: ifeq +82 -> 7252
    //   7173: aload 41
    //   7175: invokevirtual 764	java/io/File:delete	()Z
    //   7178: istore 32
    //   7180: new 258	java/lang/StringBuilder
    //   7183: dup
    //   7184: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   7187: astore_1
    //   7188: aload_1
    //   7189: aload 38
    //   7191: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7194: pop
    //   7195: aload_1
    //   7196: aload 41
    //   7198: invokevirtual 767	java/io/File:toString	()Ljava/lang/String;
    //   7201: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7204: pop
    //   7205: iconst_4
    //   7206: aload_3
    //   7207: aload_1
    //   7208: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7211: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   7214: iload 32
    //   7216: ifne +36 -> 7252
    //   7219: new 258	java/lang/StringBuilder
    //   7222: dup
    //   7223: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   7226: astore_1
    //   7227: aload_1
    //   7228: aload_2
    //   7229: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7232: pop
    //   7233: aload_1
    //   7234: aload 41
    //   7236: invokevirtual 767	java/io/File:toString	()Ljava/lang/String;
    //   7239: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7242: pop
    //   7243: iconst_5
    //   7244: aload_3
    //   7245: aload_1
    //   7246: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7249: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   7252: invokestatic 176	com/tencent/oskplayer/PlayerConfig:g	()Lcom/tencent/oskplayer/PlayerConfig;
    //   7255: invokevirtual 979	com/tencent/oskplayer/PlayerConfig:getOnConnectionChangeListener	()Lcom/tencent/oskplayer/proxy/VideoProxy$OnConnectionChangeListener;
    //   7258: astore_1
    //   7259: aload_1
    //   7260: ifnull +14 -> 7274
    //   7263: aload_1
    //   7264: iconst_0
    //   7265: aload 37
    //   7267: aload 36
    //   7269: invokeinterface 985 4 0
    //   7274: goto +6 -> 7280
    //   7277: aload 40
    //   7279: athrow
    //   7280: goto -3 -> 7277
    //   7283: astore_2
    //   7284: goto -6552 -> 732
    //   7287: astore_1
    //   7288: goto -6543 -> 745
    //   7291: astore 34
    //   7293: goto -4770 -> 2523
    //   7296: astore_1
    //   7297: goto -4761 -> 2536
    //   7300: astore_1
    //   7301: goto -3692 -> 3609
    //   7304: astore 35
    //   7306: goto -1591 -> 5715
    //   7309: astore_1
    //   7310: goto -1574 -> 5736
    //   7313: astore 5
    //   7315: goto -182 -> 7133
    //   7318: astore_1
    //   7319: goto -167 -> 7152
    //   7322: goto -5478 -> 1844
    //   7325: aconst_null
    //   7326: astore 43
    //   7328: goto -5383 -> 1945
    //   7331: goto -5255 -> 2076
    //   7334: astore 40
    //   7336: lload 14
    //   7338: lstore 12
    //   7340: goto -5043 -> 2297
    //   7343: astore 38
    //   7345: lload 14
    //   7347: lstore 12
    //   7349: aload 39
    //   7351: astore 37
    //   7353: aload 35
    //   7355: astore 36
    //   7357: aload 42
    //   7359: astore 39
    //   7361: goto -5924 -> 1437
    //   7364: astore 38
    //   7366: lload 14
    //   7368: lstore 12
    //   7370: goto +84 -> 7454
    //   7373: goto -5215 -> 2158
    //   7376: astore_2
    //   7377: goto +14 -> 7391
    //   7380: astore 38
    //   7382: goto +59 -> 7441
    //   7385: astore 38
    //   7387: goto +67 -> 7454
    //   7390: astore_2
    //   7391: aload_2
    //   7392: astore 40
    //   7394: aload 36
    //   7396: astore 38
    //   7398: aconst_null
    //   7399: astore 42
    //   7401: aload 5
    //   7403: astore 39
    //   7405: aload_3
    //   7406: astore 36
    //   7408: ldc_w 1388
    //   7411: astore 4
    //   7413: ldc_w 1378
    //   7416: astore_2
    //   7417: aload 44
    //   7419: astore_3
    //   7420: aload 34
    //   7422: astore 5
    //   7424: aload 37
    //   7426: astore 34
    //   7428: aload 39
    //   7430: astore 37
    //   7432: aload 42
    //   7434: astore 39
    //   7436: goto -380 -> 7056
    //   7439: astore 38
    //   7441: aload 37
    //   7443: astore 39
    //   7445: aload 36
    //   7447: astore 37
    //   7449: goto -6016 -> 1433
    //   7452: astore 38
    //   7454: aload 36
    //   7456: astore 42
    //   7458: lload 18
    //   7460: lstore 14
    //   7462: aload 37
    //   7464: astore 36
    //   7466: aload 35
    //   7468: astore 37
    //   7470: aload 33
    //   7472: astore 35
    //   7474: aload 34
    //   7476: astore 39
    //   7478: aload 38
    //   7480: astore 33
    //   7482: aload 35
    //   7484: astore 34
    //   7486: aload 39
    //   7488: astore 35
    //   7490: aload 48
    //   7492: astore 39
    //   7494: lload 22
    //   7496: lstore 16
    //   7498: aload 42
    //   7500: astore 38
    //   7502: goto -3576 -> 3926
    //   7505: goto -5347 -> 2158
    //   7508: goto -3511 -> 3997
    //   7511: ldc2_w 929
    //   7514: lstore 18
    //   7516: goto -3458 -> 4058
    //   7519: iconst_0
    //   7520: istore 32
    //   7522: goto -3418 -> 4104
    //   7525: iconst_0
    //   7526: istore 8
    //   7528: iload 8
    //   7530: ifeq -2403 -> 5127
    //   7533: bipush 13
    //   7535: istore 8
    //   7537: goto -2398 -> 5139
    //   7540: bipush 9
    //   7542: istore 8
    //   7544: goto -2405 -> 5139
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	7547	0	this	VideoProxy
    //   0	7547	1	paramSocket	Socket
    //   0	7547	2	paramString	String
    //   0	7547	3	paramOutputStream	OutputStream
    //   0	7547	4	paramVideoRequest	VideoRequest
    //   0	7547	5	paramInputStream	InputStream
    //   952	6124	6	i	int
    //   999	4910	7	j	int
    //   1724	5819	8	k	int
    //   1737	684	9	m	int
    //   1741	684	10	n	int
    //   1681	439	11	i1	int
    //   5	7364	12	l1	long
    //   404	7057	14	l2	long
    //   430	7067	16	l3	long
    //   449	7066	18	l4	long
    //   12	7080	20	l5	long
    //   1257	6238	22	l6	long
    //   1554	1333	24	l7	long
    //   872	1609	26	l8	long
    //   1612	94	28	l9	long
    //   501	6402	30	l10	long
    //   653	6868	32	bool	boolean
    //   34	3149	33	localObject1	Object
    //   3260	1	33	localIOException1	IOException
    //   3339	1	33	localObject2	Object
    //   3353	1	33	localIOException2	IOException
    //   3358	1	33	localIOException3	IOException
    //   3367	233	33	localObject3	Object
    //   3876	71	33	localIOException4	IOException
    //   4226	3255	33	localObject4	Object
    //   26	2727	34	localObject5	Object
    //   2765	27	34	localIOException5	IOException
    //   2797	108	34	localObject6	Object
    //   2925	1	34	localIOException6	IOException
    //   2930	1	34	localIOException7	IOException
    //   2935	1	34	localIOException8	IOException
    //   2945	1	34	localException1	Exception
    //   2950	1	34	localIOException9	IOException
    //   2959	1	34	localException2	Exception
    //   2964	1	34	localIOException10	IOException
    //   2969	1	34	localException3	Exception
    //   2974	15	34	localIOException11	IOException
    //   2994	1	34	localObject7	Object
    //   2999	1	34	localException4	Exception
    //   3004	11	34	localIOException12	IOException
    //   3020	1	34	localObject8	Object
    //   3036	3	34	localException5	Exception
    //   3045	7	34	localIOException13	IOException
    //   3057	1	34	localObject9	Object
    //   3066	1	34	localException6	Exception
    //   3071	1	34	localIOException14	IOException
    //   3088	1	34	str1	String
    //   3139	1	34	localException7	Exception
    //   3144	3	34	localIOException15	IOException
    //   3152	50	34	localObject10	Object
    //   3209	3	34	localException8	Exception
    //   3231	3869	34	localObject11	Object
    //   7291	130	34	localIOException16	IOException
    //   7426	59	34	localObject12	Object
    //   57	7027	35	localObject13	Object
    //   7304	163	35	localIOException17	IOException
    //   7472	17	35	localObject14	Object
    //   120	7345	36	localObject15	Object
    //   48	7421	37	localObject16	Object
    //   646	723	38	localObject17	Object
    //   1413	1	38	localException9	Exception
    //   1466	834	38	localObject18	Object
    //   2304	1	38	localException10	Exception
    //   2369	939	38	localObject19	Object
    //   3312	1	38	localException11	Exception
    //   3391	1	38	localObject20	Object
    //   3441	305	38	localException12	Exception
    //   3781	3409	38	localObject21	Object
    //   7343	1	38	localException13	Exception
    //   7364	1	38	localIOException18	IOException
    //   7380	1	38	localException14	Exception
    //   7385	1	38	localIOException19	IOException
    //   7396	1	38	localObject22	Object
    //   7439	1	38	localException15	Exception
    //   7452	27	38	localIOException20	IOException
    //   7500	1	38	localObject23	Object
    //   608	327	39	localObject24	Object
    //   977	3	39	localException16	Exception
    //   985	1	39	localObject25	Object
    //   1036	3	39	localIOException21	IOException
    //   1056	156	39	localObject26	Object
    //   1236	1	39	localException17	Exception
    //   1241	1	39	localIOException22	IOException
    //   1266	1598	39	localObject27	Object
    //   2868	15	39	localIOException23	IOException
    //   2892	1333	39	localObject28	Object
    //   4231	9	39	localException18	Exception
    //   4254	3239	39	localObject29	Object
    //   83	843	40	str2	String
    //   1360	1	40	localObject30	Object
    //   2291	826	40	localObject31	Object
    //   3134	349	40	localObject32	Object
    //   3756	1	40	localObject33	Object
    //   3829	98	40	localObject34	Object
    //   4250	1	40	localObject35	Object
    //   4415	1	40	str3	String
    //   4612	1	40	localObject36	Object
    //   5632	1285	40	str4	String
    //   6925	1	40	localObject37	Object
    //   7029	249	40	str5	String
    //   7334	1	40	localObject38	Object
    //   7392	1	40	str6	String
    //   377	2330	41	localObject39	Object
    //   2810	52	41	localObject40	Object
    //   2940	83	41	localObject41	Object
    //   3031	4204	41	localObject42	Object
    //   595	2181	42	localObject43	Object
    //   2827	27	42	localException19	Exception
    //   2896	233	42	localObject44	Object
    //   3174	1	42	localObject45	Object
    //   3278	28	42	str7	String
    //   3363	72	42	localObject46	Object
    //   3493	4006	42	localObject47	Object
    //   372	710	43	localObject48	Object
    //   1355	266	43	localIOException24	IOException
    //   1754	5573	43	localObject49	Object
    //   895	1736	44	localObject50	Object
    //   2676	23	44	localException20	Exception
    //   2736	23	44	localException21	Exception
    //   3951	3467	44	localObject51	Object
    //   19	7028	45	str8	String
    //   496	6444	46	localObject52	Object
    //   600	776	47	str9	String
    //   2345	269	47	localIOException25	IOException
    //   4017	177	47	localObject53	Object
    //   632	6859	48	localObject54	Object
    //   571	1710	49	localObject55	Object
    //   902	1144	50	localObject56	Object
    //   604	3383	51	str10	String
    //   591	1850	52	localObject57	Object
    //   1524	48	53	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   909	916	923	finally
    //   1160	1188	923	finally
    //   1191	1229	923	finally
    //   909	916	977	java/lang/Exception
    //   1160	1188	977	java/lang/Exception
    //   1191	1229	977	java/lang/Exception
    //   909	916	1036	java/io/IOException
    //   1160	1188	1036	java/io/IOException
    //   1191	1229	1036	java/io/IOException
    //   1116	1146	1232	finally
    //   1151	1160	1232	finally
    //   1116	1146	1236	java/lang/Exception
    //   1151	1160	1236	java/lang/Exception
    //   1116	1146	1241	java/io/IOException
    //   1151	1160	1241	java/io/IOException
    //   1342	1352	1355	java/io/IOException
    //   1342	1352	1360	finally
    //   1342	1352	1413	java/lang/Exception
    //   1747	1756	2291	finally
    //   1768	1777	2291	finally
    //   1789	1797	2291	finally
    //   1809	1818	2291	finally
    //   1830	1841	2291	finally
    //   1856	1861	2291	finally
    //   1885	1893	2291	finally
    //   1905	1915	2291	finally
    //   1930	1938	2291	finally
    //   1962	1970	2291	finally
    //   1982	1994	2291	finally
    //   2011	2023	2291	finally
    //   2038	2051	2291	finally
    //   2063	2073	2291	finally
    //   2088	2098	2291	finally
    //   2117	2124	2291	finally
    //   2136	2143	2291	finally
    //   2195	2203	2291	finally
    //   2215	2224	2291	finally
    //   2236	2244	2291	finally
    //   2256	2265	2291	finally
    //   2277	2288	2291	finally
    //   2430	2435	2291	finally
    //   1747	1756	2304	java/lang/Exception
    //   1768	1777	2304	java/lang/Exception
    //   1789	1797	2304	java/lang/Exception
    //   1809	1818	2304	java/lang/Exception
    //   1830	1841	2304	java/lang/Exception
    //   1856	1861	2304	java/lang/Exception
    //   1885	1893	2304	java/lang/Exception
    //   1905	1915	2304	java/lang/Exception
    //   1930	1938	2304	java/lang/Exception
    //   1962	1970	2304	java/lang/Exception
    //   1982	1994	2304	java/lang/Exception
    //   2011	2023	2304	java/lang/Exception
    //   2038	2051	2304	java/lang/Exception
    //   2063	2073	2304	java/lang/Exception
    //   2088	2098	2304	java/lang/Exception
    //   2117	2124	2304	java/lang/Exception
    //   2136	2143	2304	java/lang/Exception
    //   2195	2203	2304	java/lang/Exception
    //   2215	2224	2304	java/lang/Exception
    //   2236	2244	2304	java/lang/Exception
    //   2256	2265	2304	java/lang/Exception
    //   2277	2288	2304	java/lang/Exception
    //   2430	2435	2304	java/lang/Exception
    //   1747	1756	2345	java/io/IOException
    //   1768	1777	2345	java/io/IOException
    //   1789	1797	2345	java/io/IOException
    //   1809	1818	2345	java/io/IOException
    //   1830	1841	2345	java/io/IOException
    //   1856	1861	2345	java/io/IOException
    //   1885	1893	2345	java/io/IOException
    //   1905	1915	2345	java/io/IOException
    //   1930	1938	2345	java/io/IOException
    //   1962	1970	2345	java/io/IOException
    //   1982	1994	2345	java/io/IOException
    //   2011	2023	2345	java/io/IOException
    //   2038	2051	2345	java/io/IOException
    //   2063	2073	2345	java/io/IOException
    //   2088	2098	2345	java/io/IOException
    //   2117	2124	2345	java/io/IOException
    //   2136	2143	2345	java/io/IOException
    //   2195	2203	2345	java/io/IOException
    //   2215	2224	2345	java/io/IOException
    //   2236	2244	2345	java/io/IOException
    //   2256	2265	2345	java/io/IOException
    //   2277	2288	2345	java/io/IOException
    //   2430	2435	2345	java/io/IOException
    //   2440	2445	2676	java/lang/Exception
    //   2406	2413	2713	finally
    //   2435	2440	2713	finally
    //   2440	2445	2713	finally
    //   2406	2413	2736	java/lang/Exception
    //   2435	2440	2736	java/lang/Exception
    //   2406	2413	2765	java/io/IOException
    //   2435	2440	2765	java/io/IOException
    //   2440	2445	2765	java/io/IOException
    //   1636	1641	2810	finally
    //   1636	1641	2827	java/lang/Exception
    //   1636	1641	2868	java/io/IOException
    //   1589	1614	2925	java/io/IOException
    //   1556	1589	2930	java/io/IOException
    //   1517	1552	2935	java/io/IOException
    //   1323	1333	2940	finally
    //   1517	1552	2940	finally
    //   1556	1589	2940	finally
    //   1589	1614	2940	finally
    //   1323	1333	2945	java/lang/Exception
    //   1517	1552	2945	java/lang/Exception
    //   1556	1589	2945	java/lang/Exception
    //   1589	1614	2945	java/lang/Exception
    //   1323	1333	2950	java/io/IOException
    //   1308	1323	2955	finally
    //   1308	1323	2959	java/lang/Exception
    //   1308	1323	2964	java/io/IOException
    //   1268	1290	2969	java/lang/Exception
    //   1268	1290	2974	java/io/IOException
    //   1259	1268	2999	java/lang/Exception
    //   1259	1268	3004	java/io/IOException
    //   1246	1255	3029	finally
    //   1259	1268	3029	finally
    //   1268	1290	3029	finally
    //   1246	1255	3036	java/lang/Exception
    //   1246	1255	3045	java/io/IOException
    //   1104	1111	3062	finally
    //   1104	1111	3066	java/lang/Exception
    //   1104	1111	3071	java/io/IOException
    //   897	904	3076	finally
    //   897	904	3139	java/lang/Exception
    //   897	904	3144	java/io/IOException
    //   648	655	3174	finally
    //   648	655	3209	java/lang/Exception
    //   648	655	3260	java/io/IOException
    //   641	648	3312	java/lang/Exception
    //   641	648	3353	java/io/IOException
    //   634	641	3358	java/io/IOException
    //   610	634	3363	finally
    //   634	641	3363	finally
    //   641	648	3363	finally
    //   610	634	3441	java/lang/Exception
    //   634	641	3441	java/lang/Exception
    //   3495	3539	3756	finally
    //   3486	3495	3829	finally
    //   610	634	3876	java/io/IOException
    //   4201	4224	4231	java/lang/Exception
    //   3984	3997	4250	finally
    //   3997	4055	4250	finally
    //   4084	4098	4250	finally
    //   4104	4119	4250	finally
    //   3978	3984	4259	finally
    //   3953	3970	4409	finally
    //   3946	3953	4413	finally
    //   4119	4140	4612	finally
    //   4140	4175	4612	finally
    //   4178	4201	4612	finally
    //   4201	4224	4612	finally
    //   4233	4244	4612	finally
    //   4501	4601	4612	finally
    //   4637	4707	4612	finally
    //   4730	4800	4612	finally
    //   4815	4860	4612	finally
    //   4878	4923	4612	finally
    //   4938	4995	4612	finally
    //   4995	5041	4612	finally
    //   5044	5053	4612	finally
    //   5064	5082	4612	finally
    //   5087	5094	4612	finally
    //   5099	5121	4612	finally
    //   5127	5133	4612	finally
    //   5139	5150	4612	finally
    //   5165	5222	4612	finally
    //   5222	5248	4612	finally
    //   5263	5271	4612	finally
    //   5271	5292	4612	finally
    //   5307	5364	4612	finally
    //   5364	5383	4612	finally
    //   5398	5443	4612	finally
    //   5458	5467	4612	finally
    //   5488	5497	4612	finally
    //   5518	5527	4612	finally
    //   4276	4285	5632	finally
    //   4289	4298	5632	finally
    //   4302	4313	5632	finally
    //   4317	4326	5632	finally
    //   4330	4344	5632	finally
    //   4348	4359	5632	finally
    //   4363	4373	5632	finally
    //   4377	4390	5632	finally
    //   5624	5629	5632	finally
    //   5608	5615	6925	finally
    //   4489	4496	6993	finally
    //   4625	4632	6993	finally
    //   4718	4725	6993	finally
    //   4803	4810	6993	finally
    //   4866	4873	6993	finally
    //   4926	4933	6993	finally
    //   5153	5160	6993	finally
    //   5251	5258	6993	finally
    //   5295	5302	6993	finally
    //   5386	5393	6993	finally
    //   5446	5453	6993	finally
    //   5470	5483	6993	finally
    //   5500	5513	6993	finally
    //   5530	5584	6993	finally
    //   3934	3941	6997	finally
    //   722	729	7283	java/io/IOException
    //   741	745	7287	java/io/IOException
    //   2513	2520	7291	java/io/IOException
    //   2532	2536	7296	java/io/IOException
    //   3599	3606	7300	java/io/IOException
    //   5705	5712	7304	java/io/IOException
    //   5729	5733	7309	java/io/IOException
    //   7123	7130	7313	java/io/IOException
    //   7145	7149	7318	java/io/IOException
    //   1720	1726	7334	finally
    //   1720	1726	7343	java/lang/Exception
    //   1720	1726	7364	java/io/IOException
    //   1668	1683	7376	finally
    //   1689	1697	7376	finally
    //   1700	1705	7376	finally
    //   1668	1683	7380	java/lang/Exception
    //   1689	1697	7380	java/lang/Exception
    //   1700	1705	7380	java/lang/Exception
    //   1668	1683	7385	java/io/IOException
    //   1689	1697	7385	java/io/IOException
    //   1700	1705	7385	java/io/IOException
    //   1652	1659	7390	finally
    //   1652	1659	7439	java/lang/Exception
    //   1652	1659	7452	java/io/IOException
  }
  
  public void addCacheReadListener(String paramString, VideoProxy.CacheReadListener paramCacheReadListener)
  {
    try
    {
      boolean bool = TextUtils.isEmpty(paramString);
      if (bool) {
        return;
      }
      paramString = PlayerUtils.parseVideoKey(paramString);
      this.cacheReadListenerMap.put(paramString, paramCacheReadListener);
      return;
    }
    finally {}
  }
  
  public void addHttpErrorListener(String paramString, VideoProxy.HttpErrorListener paramHttpErrorListener)
  {
    try
    {
      boolean bool = TextUtils.isEmpty(paramString);
      if (bool) {
        return;
      }
      paramString = PlayerUtils.parseVideoKey(paramString);
      this.httpUrlErrorListenerMap.put(paramString, paramHttpErrorListener);
      return;
    }
    finally {}
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
  
  public void addUuidErrorListener(String paramString, VideoProxy.HttpErrorListener paramHttpErrorListener)
  {
    try
    {
      boolean bool = TextUtils.isEmpty(paramString);
      if (bool) {
        return;
      }
      this.uuidErrorListenerMap.put(paramString, paramHttpErrorListener);
      return;
    }
    finally {}
  }
  
  @Deprecated
  public void cancelAllAsync()
  {
    PlayerUtils.log(4, "VideoProxy", "cancelAllAsync is not supported any more!");
  }
  
  public void cancelAllPreloadAsync(boolean paramBoolean)
  {
    Object localObject = this.tcDataSourceUtils;
    if (localObject != null) {
      ((ITcDataSourceUtils)localObject).stopAllPreload();
    }
    localObject = this.videoRequestManager;
    if (localObject != null) {
      ((VideoRequestManager)localObject).cancelAllPreloadRequestAsync(paramBoolean);
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
    Object localObject = this.tcDataSourceUtils;
    if (localObject != null) {
      ((ITcDataSourceUtils)localObject).cleanStorage();
    }
    localObject = this.cache;
    if (localObject != null) {
      ((Cache)localObject).removeAll();
    }
  }
  
  public void clearCacheByUrl(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ITcDataSourceUtils localITcDataSourceUtils = this.tcDataSourceUtils;
    if (localITcDataSourceUtils != null) {
      localITcDataSourceUtils.deleteFileOnDisk(paramString);
    }
    if (this.cache != null)
    {
      paramString = PlayerUtils.parseVideoKey(paramString);
      this.cache.removeByKey(paramString);
    }
  }
  
  /* Error */
  public String downloadVideoSync(String paramString, VideoDownloadListener paramVideoDownloadListener, boolean paramBoolean, HttpHeader paramHttpHeader)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 238	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +1559 -> 1563
    //   7: aload_1
    //   8: invokestatic 1632	android/webkit/URLUtil:isNetworkUrl	(Ljava/lang/String;)Z
    //   11: ifne +6 -> 17
    //   14: goto +1549 -> 1563
    //   17: aload_1
    //   18: invokestatic 840	com/tencent/oskplayer/util/PlayerUtils:isHLSStream	(Ljava/lang/String;)Z
    //   21: ifeq +18 -> 39
    //   24: aload_2
    //   25: ifnull +12 -> 37
    //   28: aload_2
    //   29: aload_1
    //   30: bipush 251
    //   32: invokeinterface 1637 3 0
    //   37: aconst_null
    //   38: areturn
    //   39: aload_1
    //   40: invokestatic 936	com/tencent/oskplayer/util/PlayerUtils:parseVideoKey	(Ljava/lang/String;)Ljava/lang/String;
    //   43: astore 10
    //   45: aload_0
    //   46: aload_1
    //   47: iconst_1
    //   48: iconst_1
    //   49: ldc 58
    //   51: ldc 73
    //   53: bipush 90
    //   55: aload 4
    //   57: invokevirtual 654	com/tencent/oskplayer/proxy/VideoProxy:getUrl	(Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;ILcom/tencent/oskplayer/datasource/HttpHeader;)Ljava/lang/String;
    //   60: astore 4
    //   62: aload_2
    //   63: ifnull +10 -> 73
    //   66: aload_2
    //   67: aload_1
    //   68: invokeinterface 1638 2 0
    //   73: new 1181	com/tencent/oskplayer/datasource/DefaultHttpDataSource
    //   76: dup
    //   77: ldc 55
    //   79: aconst_null
    //   80: aconst_null
    //   81: invokespecial 1184	com/tencent/oskplayer/datasource/DefaultHttpDataSource:<init>	(Ljava/lang/String;Lcom/tencent/oskplayer/util/Predicate;Lcom/tencent/oskplayer/util/Fixer;)V
    //   84: astore 16
    //   86: sipush 8192
    //   89: newarray byte
    //   91: astore 17
    //   93: new 836	com/tencent/oskplayer/datasource/DataSpec
    //   96: dup
    //   97: aload 4
    //   99: invokestatic 817	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   102: lconst_0
    //   103: lconst_0
    //   104: ldc2_w 929
    //   107: aload 10
    //   109: iconst_0
    //   110: aconst_null
    //   111: invokespecial 1196	com/tencent/oskplayer/datasource/DataSpec:<init>	(Landroid/net/Uri;JJJLjava/lang/String;ILjava/lang/String;)V
    //   114: astore 4
    //   116: aload_1
    //   117: aconst_null
    //   118: invokestatic 1644	com/tencent/oskplayer/cache/FileDataSink:getLocalFile	(Ljava/lang/String;Ljava/io/File;)Ljava/lang/String;
    //   121: astore 10
    //   123: aload 10
    //   125: invokestatic 238	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   128: istore 5
    //   130: iload 5
    //   132: ifne +126 -> 258
    //   135: iload_3
    //   136: ifne +122 -> 258
    //   139: aload_2
    //   140: ifnull +77 -> 217
    //   143: aload_2
    //   144: aload_1
    //   145: aload 10
    //   147: invokeinterface 1648 3 0
    //   152: goto +65 -> 217
    //   155: astore_1
    //   156: aconst_null
    //   157: astore 10
    //   159: aload 4
    //   161: astore_2
    //   162: goto +1348 -> 1510
    //   165: astore 13
    //   167: aconst_null
    //   168: astore 10
    //   170: goto +701 -> 871
    //   173: astore 13
    //   175: aconst_null
    //   176: astore 10
    //   178: goto +848 -> 1026
    //   181: astore 11
    //   183: aconst_null
    //   184: astore 10
    //   186: aload 4
    //   188: astore 13
    //   190: aload 11
    //   192: astore 4
    //   194: aload 13
    //   196: astore 11
    //   198: aload 4
    //   200: astore 13
    //   202: aload 11
    //   204: astore 4
    //   206: goto +975 -> 1181
    //   209: astore 13
    //   211: aconst_null
    //   212: astore 10
    //   214: goto +1122 -> 1336
    //   217: aload 16
    //   219: invokeinterface 1210 1 0
    //   224: goto +8 -> 232
    //   227: astore_1
    //   228: aload_1
    //   229: invokevirtual 1651	java/lang/Exception:printStackTrace	()V
    //   232: aload_0
    //   233: getfield 228	com/tencent/oskplayer/proxy/VideoProxy:videoDownloadHashSet	Ljava/util/Set;
    //   236: astore_1
    //   237: aload 4
    //   239: getfield 868	com/tencent/oskplayer/datasource/DataSpec:key	Ljava/lang/String;
    //   242: astore 4
    //   244: aload 10
    //   246: astore_2
    //   247: aload_1
    //   248: aload 4
    //   250: invokeinterface 1654 2 0
    //   255: pop
    //   256: aload_2
    //   257: areturn
    //   258: aload_0
    //   259: getfield 228	com/tencent/oskplayer/proxy/VideoProxy:videoDownloadHashSet	Ljava/util/Set;
    //   262: aload 4
    //   264: getfield 868	com/tencent/oskplayer/datasource/DataSpec:key	Ljava/lang/String;
    //   267: invokeinterface 1656 2 0
    //   272: istore_3
    //   273: iload_3
    //   274: ifeq +46 -> 320
    //   277: aload_2
    //   278: ifnull +10 -> 288
    //   281: aload_2
    //   282: aload_1
    //   283: invokeinterface 1659 2 0
    //   288: aload 16
    //   290: invokeinterface 1210 1 0
    //   295: goto +8 -> 303
    //   298: astore_1
    //   299: aload_1
    //   300: invokevirtual 1651	java/lang/Exception:printStackTrace	()V
    //   303: aload_0
    //   304: getfield 228	com/tencent/oskplayer/proxy/VideoProxy:videoDownloadHashSet	Ljava/util/Set;
    //   307: aload 4
    //   309: getfield 868	com/tencent/oskplayer/datasource/DataSpec:key	Ljava/lang/String;
    //   312: invokeinterface 1654 2 0
    //   317: pop
    //   318: aconst_null
    //   319: areturn
    //   320: aload_0
    //   321: getfield 228	com/tencent/oskplayer/proxy/VideoProxy:videoDownloadHashSet	Ljava/util/Set;
    //   324: aload 4
    //   326: getfield 868	com/tencent/oskplayer/datasource/DataSpec:key	Ljava/lang/String;
    //   329: invokeinterface 1660 2 0
    //   334: pop
    //   335: aload 16
    //   337: aload 4
    //   339: invokeinterface 535 2 0
    //   344: lstore 6
    //   346: new 1640	com/tencent/oskplayer/cache/FileDataSink
    //   349: dup
    //   350: aload_1
    //   351: aconst_null
    //   352: invokespecial 1663	com/tencent/oskplayer/cache/FileDataSink:<init>	(Ljava/lang/String;Ljava/io/File;)V
    //   355: astore 10
    //   357: aload 4
    //   359: astore 15
    //   361: aload 4
    //   363: astore 11
    //   365: aload 4
    //   367: astore 12
    //   369: aload 4
    //   371: astore 13
    //   373: aload 4
    //   375: astore 14
    //   377: aload 10
    //   379: ldc_w 1665
    //   382: invokevirtual 1666	com/tencent/oskplayer/cache/FileDataSink:setLogTag	(Ljava/lang/String;)V
    //   385: aload 4
    //   387: astore 15
    //   389: aload 4
    //   391: astore 11
    //   393: aload 4
    //   395: astore 12
    //   397: aload 4
    //   399: astore 13
    //   401: aload 4
    //   403: astore 14
    //   405: aload 10
    //   407: aload 4
    //   409: lload 6
    //   411: aload 16
    //   413: invokeinterface 1407 1 0
    //   418: invokevirtual 1669	com/tencent/oskplayer/cache/FileDataSink:open	(Lcom/tencent/oskplayer/datasource/DataSpec;JLcom/tencent/oskplayer/proxy/FileType;)Lcom/tencent/oskplayer/datasource/DataSink;
    //   421: pop
    //   422: iconst_1
    //   423: istore_3
    //   424: iload_3
    //   425: ifeq +172 -> 597
    //   428: aload 4
    //   430: astore 15
    //   432: aload 4
    //   434: astore 11
    //   436: aload 4
    //   438: astore 12
    //   440: aload 4
    //   442: astore 13
    //   444: aload 4
    //   446: astore 14
    //   448: aload 16
    //   450: aload 17
    //   452: iconst_0
    //   453: aload 17
    //   455: arraylength
    //   456: invokeinterface 1203 4 0
    //   461: i2l
    //   462: lstore 6
    //   464: lload 6
    //   466: ldc2_w 929
    //   469: lcmp
    //   470: ifeq +127 -> 597
    //   473: aload 4
    //   475: astore 15
    //   477: aload 4
    //   479: astore 11
    //   481: aload 4
    //   483: astore 12
    //   485: aload 4
    //   487: astore 13
    //   489: aload 4
    //   491: astore 14
    //   493: aload 10
    //   495: aload 17
    //   497: iconst_0
    //   498: lload 6
    //   500: l2i
    //   501: invokevirtual 1670	com/tencent/oskplayer/cache/FileDataSink:write	([BII)V
    //   504: aload 4
    //   506: astore 11
    //   508: aload_2
    //   509: ifnull +1068 -> 1577
    //   512: aload 4
    //   514: astore 15
    //   516: aload 4
    //   518: astore 11
    //   520: aload 4
    //   522: astore 12
    //   524: aload 4
    //   526: astore 13
    //   528: aload 4
    //   530: astore 14
    //   532: aload 10
    //   534: invokevirtual 1673	com/tencent/oskplayer/cache/FileDataSink:getBytesWritten	()J
    //   537: lstore 6
    //   539: aload 4
    //   541: astore 15
    //   543: aload 4
    //   545: astore 11
    //   547: aload 4
    //   549: astore 12
    //   551: aload 4
    //   553: astore 13
    //   555: aload 4
    //   557: astore 14
    //   559: aload 10
    //   561: invokevirtual 1676	com/tencent/oskplayer/cache/FileDataSink:getBytesTotal	()J
    //   564: lstore 8
    //   566: aload 4
    //   568: astore 13
    //   570: aload 13
    //   572: astore 11
    //   574: aload 10
    //   576: astore 12
    //   578: aload_2
    //   579: aload_1
    //   580: lload 6
    //   582: lload 8
    //   584: invokeinterface 1680 6 0
    //   589: istore_3
    //   590: aload 13
    //   592: astore 11
    //   594: goto +983 -> 1577
    //   597: aload 4
    //   599: astore 13
    //   601: aload 13
    //   603: astore 11
    //   605: aload 10
    //   607: astore 12
    //   609: aload 10
    //   611: invokevirtual 1681	com/tencent/oskplayer/cache/FileDataSink:close	()V
    //   614: iload_3
    //   615: ifeq +134 -> 749
    //   618: aload 13
    //   620: astore 11
    //   622: aload 10
    //   624: astore 12
    //   626: aload 10
    //   628: invokevirtual 1685	com/tencent/oskplayer/cache/FileDataSink:getFile	()Ljava/io/File;
    //   631: ifnull +94 -> 725
    //   634: aload_2
    //   635: ifnull +26 -> 661
    //   638: aload 13
    //   640: astore 11
    //   642: aload 10
    //   644: astore 12
    //   646: aload_2
    //   647: aload_1
    //   648: aload 10
    //   650: invokevirtual 1685	com/tencent/oskplayer/cache/FileDataSink:getFile	()Ljava/io/File;
    //   653: invokevirtual 1688	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   656: invokeinterface 1648 3 0
    //   661: aload 13
    //   663: astore 11
    //   665: aload 10
    //   667: astore 12
    //   669: aload 10
    //   671: invokevirtual 1685	com/tencent/oskplayer/cache/FileDataSink:getFile	()Ljava/io/File;
    //   674: invokevirtual 1688	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   677: astore 14
    //   679: aload 16
    //   681: invokeinterface 1210 1 0
    //   686: goto +8 -> 694
    //   689: astore_1
    //   690: aload_1
    //   691: invokevirtual 1651	java/lang/Exception:printStackTrace	()V
    //   694: aload 10
    //   696: invokevirtual 1681	com/tencent/oskplayer/cache/FileDataSink:close	()V
    //   699: goto +8 -> 707
    //   702: astore_1
    //   703: aload_1
    //   704: invokevirtual 1651	java/lang/Exception:printStackTrace	()V
    //   707: aload_0
    //   708: getfield 228	com/tencent/oskplayer/proxy/VideoProxy:videoDownloadHashSet	Ljava/util/Set;
    //   711: astore_1
    //   712: aload 13
    //   714: getfield 868	com/tencent/oskplayer/datasource/DataSpec:key	Ljava/lang/String;
    //   717: astore 4
    //   719: aload 14
    //   721: astore_2
    //   722: goto -475 -> 247
    //   725: aload_2
    //   726: ifnull +38 -> 764
    //   729: aload 13
    //   731: astore 11
    //   733: aload 10
    //   735: astore 12
    //   737: aload_2
    //   738: aload_1
    //   739: bipush 250
    //   741: invokeinterface 1637 3 0
    //   746: goto +18 -> 764
    //   749: aload 13
    //   751: astore 11
    //   753: aload 10
    //   755: astore 12
    //   757: aload_2
    //   758: aload_1
    //   759: invokeinterface 1659 2 0
    //   764: aload 16
    //   766: invokeinterface 1210 1 0
    //   771: goto +8 -> 779
    //   774: astore_1
    //   775: aload_1
    //   776: invokevirtual 1651	java/lang/Exception:printStackTrace	()V
    //   779: aload 10
    //   781: invokevirtual 1681	com/tencent/oskplayer/cache/FileDataSink:close	()V
    //   784: aload 13
    //   786: astore_1
    //   787: goto +699 -> 1486
    //   790: astore_2
    //   791: aload 13
    //   793: astore_1
    //   794: goto +688 -> 1482
    //   797: astore 13
    //   799: goto +72 -> 871
    //   802: astore 13
    //   804: goto +222 -> 1026
    //   807: astore 13
    //   809: goto +372 -> 1181
    //   812: astore 13
    //   814: goto +522 -> 1336
    //   817: astore_1
    //   818: aload 15
    //   820: astore_2
    //   821: goto +689 -> 1510
    //   824: astore 13
    //   826: aload 11
    //   828: astore 4
    //   830: goto -660 -> 170
    //   833: astore 13
    //   835: aload 12
    //   837: astore 4
    //   839: goto -661 -> 178
    //   842: astore 4
    //   844: goto -650 -> 194
    //   847: astore 13
    //   849: aload 14
    //   851: astore 4
    //   853: goto -639 -> 214
    //   856: astore_1
    //   857: aload 4
    //   859: astore_2
    //   860: aconst_null
    //   861: astore 10
    //   863: goto +647 -> 1510
    //   866: astore 13
    //   868: aconst_null
    //   869: astore 10
    //   871: aload 4
    //   873: astore 11
    //   875: aload 10
    //   877: astore 12
    //   879: invokestatic 1693	com/tencent/oskplayer/support/log/Logger:g	()Lcom/tencent/oskplayer/support/log/ILogger;
    //   882: astore 14
    //   884: aload 4
    //   886: astore 11
    //   888: aload 10
    //   890: astore 12
    //   892: new 258	java/lang/StringBuilder
    //   895: dup
    //   896: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   899: astore 15
    //   901: aload 4
    //   903: astore 11
    //   905: aload 10
    //   907: astore 12
    //   909: aload 15
    //   911: ldc_w 1695
    //   914: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   917: pop
    //   918: aload 4
    //   920: astore 11
    //   922: aload 10
    //   924: astore 12
    //   926: aload 15
    //   928: aload_1
    //   929: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   932: pop
    //   933: aload 4
    //   935: astore 11
    //   937: aload 10
    //   939: astore 12
    //   941: aload 14
    //   943: ldc_w 1697
    //   946: aload 15
    //   948: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   951: aload 13
    //   953: invokeinterface 1703 4 0
    //   958: pop
    //   959: aload_2
    //   960: ifnull +20 -> 980
    //   963: aload 4
    //   965: astore 11
    //   967: aload 10
    //   969: astore 12
    //   971: aload_2
    //   972: aload_1
    //   973: bipush 252
    //   975: invokeinterface 1637 3 0
    //   980: aload 16
    //   982: invokeinterface 1210 1 0
    //   987: goto +8 -> 995
    //   990: astore_1
    //   991: aload_1
    //   992: invokevirtual 1651	java/lang/Exception:printStackTrace	()V
    //   995: aload 4
    //   997: astore_1
    //   998: aload 10
    //   1000: ifnull +486 -> 1486
    //   1003: aload 10
    //   1005: invokevirtual 1681	com/tencent/oskplayer/cache/FileDataSink:close	()V
    //   1008: aload 4
    //   1010: astore_1
    //   1011: goto +475 -> 1486
    //   1014: astore_2
    //   1015: aload 4
    //   1017: astore_1
    //   1018: goto +464 -> 1482
    //   1021: astore 13
    //   1023: aconst_null
    //   1024: astore 10
    //   1026: aload 4
    //   1028: astore 11
    //   1030: aload 10
    //   1032: astore 12
    //   1034: invokestatic 1693	com/tencent/oskplayer/support/log/Logger:g	()Lcom/tencent/oskplayer/support/log/ILogger;
    //   1037: astore 14
    //   1039: aload 4
    //   1041: astore 11
    //   1043: aload 10
    //   1045: astore 12
    //   1047: new 258	java/lang/StringBuilder
    //   1050: dup
    //   1051: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   1054: astore 15
    //   1056: aload 4
    //   1058: astore 11
    //   1060: aload 10
    //   1062: astore 12
    //   1064: aload 15
    //   1066: ldc_w 1705
    //   1069: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1072: pop
    //   1073: aload 4
    //   1075: astore 11
    //   1077: aload 10
    //   1079: astore 12
    //   1081: aload 15
    //   1083: aload_1
    //   1084: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1087: pop
    //   1088: aload 4
    //   1090: astore 11
    //   1092: aload 10
    //   1094: astore 12
    //   1096: aload 14
    //   1098: ldc_w 1697
    //   1101: aload 15
    //   1103: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1106: aload 13
    //   1108: invokeinterface 1708 4 0
    //   1113: pop
    //   1114: aload_2
    //   1115: ifnull +20 -> 1135
    //   1118: aload 4
    //   1120: astore 11
    //   1122: aload 10
    //   1124: astore 12
    //   1126: aload_2
    //   1127: aload_1
    //   1128: bipush 253
    //   1130: invokeinterface 1637 3 0
    //   1135: aload 16
    //   1137: invokeinterface 1210 1 0
    //   1142: goto +8 -> 1150
    //   1145: astore_1
    //   1146: aload_1
    //   1147: invokevirtual 1651	java/lang/Exception:printStackTrace	()V
    //   1150: aload 4
    //   1152: astore_1
    //   1153: aload 10
    //   1155: ifnull +331 -> 1486
    //   1158: aload 10
    //   1160: invokevirtual 1681	com/tencent/oskplayer/cache/FileDataSink:close	()V
    //   1163: aload 4
    //   1165: astore_1
    //   1166: goto +320 -> 1486
    //   1169: astore_2
    //   1170: aload 4
    //   1172: astore_1
    //   1173: goto +309 -> 1482
    //   1176: astore 13
    //   1178: aconst_null
    //   1179: astore 10
    //   1181: aload 4
    //   1183: astore 11
    //   1185: aload 10
    //   1187: astore 12
    //   1189: invokestatic 1693	com/tencent/oskplayer/support/log/Logger:g	()Lcom/tencent/oskplayer/support/log/ILogger;
    //   1192: astore 14
    //   1194: aload 4
    //   1196: astore 11
    //   1198: aload 10
    //   1200: astore 12
    //   1202: new 258	java/lang/StringBuilder
    //   1205: dup
    //   1206: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   1209: astore 15
    //   1211: aload 4
    //   1213: astore 11
    //   1215: aload 10
    //   1217: astore 12
    //   1219: aload 15
    //   1221: ldc_w 1710
    //   1224: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1227: pop
    //   1228: aload 4
    //   1230: astore 11
    //   1232: aload 10
    //   1234: astore 12
    //   1236: aload 15
    //   1238: aload_1
    //   1239: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1242: pop
    //   1243: aload 4
    //   1245: astore 11
    //   1247: aload 10
    //   1249: astore 12
    //   1251: aload 14
    //   1253: ldc_w 1697
    //   1256: aload 15
    //   1258: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1261: aload 13
    //   1263: invokeinterface 1708 4 0
    //   1268: pop
    //   1269: aload_2
    //   1270: ifnull +20 -> 1290
    //   1273: aload 4
    //   1275: astore 11
    //   1277: aload 10
    //   1279: astore 12
    //   1281: aload_2
    //   1282: aload_1
    //   1283: bipush 254
    //   1285: invokeinterface 1637 3 0
    //   1290: aload 16
    //   1292: invokeinterface 1210 1 0
    //   1297: goto +8 -> 1305
    //   1300: astore_1
    //   1301: aload_1
    //   1302: invokevirtual 1651	java/lang/Exception:printStackTrace	()V
    //   1305: aload 4
    //   1307: astore_1
    //   1308: aload 10
    //   1310: ifnull +176 -> 1486
    //   1313: aload 10
    //   1315: invokevirtual 1681	com/tencent/oskplayer/cache/FileDataSink:close	()V
    //   1318: aload 4
    //   1320: astore_1
    //   1321: goto +165 -> 1486
    //   1324: astore_2
    //   1325: aload 4
    //   1327: astore_1
    //   1328: goto +154 -> 1482
    //   1331: astore 13
    //   1333: aconst_null
    //   1334: astore 10
    //   1336: aload 4
    //   1338: astore 11
    //   1340: aload 10
    //   1342: astore 12
    //   1344: invokestatic 1693	com/tencent/oskplayer/support/log/Logger:g	()Lcom/tencent/oskplayer/support/log/ILogger;
    //   1347: astore 14
    //   1349: aload 4
    //   1351: astore 11
    //   1353: aload 10
    //   1355: astore 12
    //   1357: new 258	java/lang/StringBuilder
    //   1360: dup
    //   1361: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   1364: astore 15
    //   1366: aload 4
    //   1368: astore 11
    //   1370: aload 10
    //   1372: astore 12
    //   1374: aload 15
    //   1376: ldc_w 1712
    //   1379: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1382: pop
    //   1383: aload 4
    //   1385: astore 11
    //   1387: aload 10
    //   1389: astore 12
    //   1391: aload 15
    //   1393: aload_1
    //   1394: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1397: pop
    //   1398: aload 4
    //   1400: astore 11
    //   1402: aload 10
    //   1404: astore 12
    //   1406: aload 14
    //   1408: ldc_w 1697
    //   1411: aload 15
    //   1413: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1416: aload 13
    //   1418: invokeinterface 1708 4 0
    //   1423: pop
    //   1424: aload_2
    //   1425: ifnull +19 -> 1444
    //   1428: aload 4
    //   1430: astore 11
    //   1432: aload 10
    //   1434: astore 12
    //   1436: aload_2
    //   1437: aload_1
    //   1438: iconst_m1
    //   1439: invokeinterface 1637 3 0
    //   1444: aload 16
    //   1446: invokeinterface 1210 1 0
    //   1451: goto +8 -> 1459
    //   1454: astore_1
    //   1455: aload_1
    //   1456: invokevirtual 1651	java/lang/Exception:printStackTrace	()V
    //   1459: aload 4
    //   1461: astore_1
    //   1462: aload 10
    //   1464: ifnull +22 -> 1486
    //   1467: aload 10
    //   1469: invokevirtual 1681	com/tencent/oskplayer/cache/FileDataSink:close	()V
    //   1472: aload 4
    //   1474: astore_1
    //   1475: goto +11 -> 1486
    //   1478: astore_2
    //   1479: aload 4
    //   1481: astore_1
    //   1482: aload_2
    //   1483: invokevirtual 1651	java/lang/Exception:printStackTrace	()V
    //   1486: aload_0
    //   1487: getfield 228	com/tencent/oskplayer/proxy/VideoProxy:videoDownloadHashSet	Ljava/util/Set;
    //   1490: aload_1
    //   1491: getfield 868	com/tencent/oskplayer/datasource/DataSpec:key	Ljava/lang/String;
    //   1494: invokeinterface 1654 2 0
    //   1499: pop
    //   1500: aconst_null
    //   1501: areturn
    //   1502: astore_1
    //   1503: aload 12
    //   1505: astore 10
    //   1507: aload 11
    //   1509: astore_2
    //   1510: aload 16
    //   1512: invokeinterface 1210 1 0
    //   1517: goto +10 -> 1527
    //   1520: astore 4
    //   1522: aload 4
    //   1524: invokevirtual 1651	java/lang/Exception:printStackTrace	()V
    //   1527: aload 10
    //   1529: ifnull +18 -> 1547
    //   1532: aload 10
    //   1534: invokevirtual 1681	com/tencent/oskplayer/cache/FileDataSink:close	()V
    //   1537: goto +10 -> 1547
    //   1540: astore 4
    //   1542: aload 4
    //   1544: invokevirtual 1651	java/lang/Exception:printStackTrace	()V
    //   1547: aload_0
    //   1548: getfield 228	com/tencent/oskplayer/proxy/VideoProxy:videoDownloadHashSet	Ljava/util/Set;
    //   1551: aload_2
    //   1552: getfield 868	com/tencent/oskplayer/datasource/DataSpec:key	Ljava/lang/String;
    //   1555: invokeinterface 1654 2 0
    //   1560: pop
    //   1561: aload_1
    //   1562: athrow
    //   1563: aload_2
    //   1564: ifnull +11 -> 1575
    //   1567: aload_2
    //   1568: aload_1
    //   1569: aload_1
    //   1570: invokeinterface 1648 3 0
    //   1575: aload_1
    //   1576: areturn
    //   1577: aload 11
    //   1579: astore 4
    //   1581: goto -1157 -> 424
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1584	0	this	VideoProxy
    //   0	1584	1	paramString	String
    //   0	1584	2	paramVideoDownloadListener	VideoDownloadListener
    //   0	1584	3	paramBoolean	boolean
    //   0	1584	4	paramHttpHeader	HttpHeader
    //   128	3	5	bool	boolean
    //   344	237	6	l1	long
    //   564	19	8	l2	long
    //   43	1490	10	localObject1	Object
    //   181	10	11	localCacheDataSinkException1	com.tencent.oskplayer.cache.CacheDataSink.CacheDataSinkException
    //   196	1382	11	localHttpHeader1	HttpHeader
    //   367	1137	12	localObject2	Object
    //   165	1	13	localException1	Exception
    //   173	1	13	localIOException1	IOException
    //   188	13	13	localHttpHeader2	HttpHeader
    //   209	1	13	localHttpDataSourceException1	com.tencent.oskplayer.datasource.HttpDataSource.HttpDataSourceException
    //   371	421	13	localHttpHeader3	HttpHeader
    //   797	1	13	localException2	Exception
    //   802	1	13	localIOException2	IOException
    //   807	1	13	localCacheDataSinkException2	com.tencent.oskplayer.cache.CacheDataSink.CacheDataSinkException
    //   812	1	13	localHttpDataSourceException2	com.tencent.oskplayer.datasource.HttpDataSource.HttpDataSourceException
    //   824	1	13	localException3	Exception
    //   833	1	13	localIOException3	IOException
    //   847	1	13	localHttpDataSourceException3	com.tencent.oskplayer.datasource.HttpDataSource.HttpDataSourceException
    //   866	86	13	localException4	Exception
    //   1021	86	13	localIOException4	IOException
    //   1176	86	13	localCacheDataSinkException3	com.tencent.oskplayer.cache.CacheDataSink.CacheDataSinkException
    //   1331	86	13	localHttpDataSourceException4	com.tencent.oskplayer.datasource.HttpDataSource.HttpDataSourceException
    //   375	1032	14	localObject3	Object
    //   359	1053	15	localObject4	Object
    //   84	1427	16	localDefaultHttpDataSource	com.tencent.oskplayer.datasource.DefaultHttpDataSource
    //   91	405	17	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   143	152	155	finally
    //   281	288	155	finally
    //   143	152	165	java/lang/Exception
    //   281	288	165	java/lang/Exception
    //   143	152	173	java/io/IOException
    //   281	288	173	java/io/IOException
    //   143	152	181	com/tencent/oskplayer/cache/CacheDataSink$CacheDataSinkException
    //   281	288	181	com/tencent/oskplayer/cache/CacheDataSink$CacheDataSinkException
    //   143	152	209	com/tencent/oskplayer/datasource/HttpDataSource$HttpDataSourceException
    //   281	288	209	com/tencent/oskplayer/datasource/HttpDataSource$HttpDataSourceException
    //   217	224	227	java/lang/Exception
    //   288	295	298	java/lang/Exception
    //   679	686	689	java/lang/Exception
    //   694	699	702	java/lang/Exception
    //   764	771	774	java/lang/Exception
    //   779	784	790	java/lang/Exception
    //   578	590	797	java/lang/Exception
    //   609	614	797	java/lang/Exception
    //   626	634	797	java/lang/Exception
    //   646	661	797	java/lang/Exception
    //   669	679	797	java/lang/Exception
    //   737	746	797	java/lang/Exception
    //   757	764	797	java/lang/Exception
    //   578	590	802	java/io/IOException
    //   609	614	802	java/io/IOException
    //   626	634	802	java/io/IOException
    //   646	661	802	java/io/IOException
    //   669	679	802	java/io/IOException
    //   737	746	802	java/io/IOException
    //   757	764	802	java/io/IOException
    //   578	590	807	com/tencent/oskplayer/cache/CacheDataSink$CacheDataSinkException
    //   609	614	807	com/tencent/oskplayer/cache/CacheDataSink$CacheDataSinkException
    //   626	634	807	com/tencent/oskplayer/cache/CacheDataSink$CacheDataSinkException
    //   646	661	807	com/tencent/oskplayer/cache/CacheDataSink$CacheDataSinkException
    //   669	679	807	com/tencent/oskplayer/cache/CacheDataSink$CacheDataSinkException
    //   737	746	807	com/tencent/oskplayer/cache/CacheDataSink$CacheDataSinkException
    //   757	764	807	com/tencent/oskplayer/cache/CacheDataSink$CacheDataSinkException
    //   578	590	812	com/tencent/oskplayer/datasource/HttpDataSource$HttpDataSourceException
    //   609	614	812	com/tencent/oskplayer/datasource/HttpDataSource$HttpDataSourceException
    //   626	634	812	com/tencent/oskplayer/datasource/HttpDataSource$HttpDataSourceException
    //   646	661	812	com/tencent/oskplayer/datasource/HttpDataSource$HttpDataSourceException
    //   669	679	812	com/tencent/oskplayer/datasource/HttpDataSource$HttpDataSourceException
    //   737	746	812	com/tencent/oskplayer/datasource/HttpDataSource$HttpDataSourceException
    //   757	764	812	com/tencent/oskplayer/datasource/HttpDataSource$HttpDataSourceException
    //   377	385	817	finally
    //   405	422	817	finally
    //   448	464	817	finally
    //   493	504	817	finally
    //   532	539	817	finally
    //   559	566	817	finally
    //   377	385	824	java/lang/Exception
    //   405	422	824	java/lang/Exception
    //   448	464	824	java/lang/Exception
    //   493	504	824	java/lang/Exception
    //   532	539	824	java/lang/Exception
    //   559	566	824	java/lang/Exception
    //   377	385	833	java/io/IOException
    //   405	422	833	java/io/IOException
    //   448	464	833	java/io/IOException
    //   493	504	833	java/io/IOException
    //   532	539	833	java/io/IOException
    //   559	566	833	java/io/IOException
    //   377	385	842	com/tencent/oskplayer/cache/CacheDataSink$CacheDataSinkException
    //   405	422	842	com/tencent/oskplayer/cache/CacheDataSink$CacheDataSinkException
    //   448	464	842	com/tencent/oskplayer/cache/CacheDataSink$CacheDataSinkException
    //   493	504	842	com/tencent/oskplayer/cache/CacheDataSink$CacheDataSinkException
    //   532	539	842	com/tencent/oskplayer/cache/CacheDataSink$CacheDataSinkException
    //   559	566	842	com/tencent/oskplayer/cache/CacheDataSink$CacheDataSinkException
    //   377	385	847	com/tencent/oskplayer/datasource/HttpDataSource$HttpDataSourceException
    //   405	422	847	com/tencent/oskplayer/datasource/HttpDataSource$HttpDataSourceException
    //   448	464	847	com/tencent/oskplayer/datasource/HttpDataSource$HttpDataSourceException
    //   493	504	847	com/tencent/oskplayer/datasource/HttpDataSource$HttpDataSourceException
    //   532	539	847	com/tencent/oskplayer/datasource/HttpDataSource$HttpDataSourceException
    //   559	566	847	com/tencent/oskplayer/datasource/HttpDataSource$HttpDataSourceException
    //   116	130	856	finally
    //   258	273	856	finally
    //   320	357	856	finally
    //   116	130	866	java/lang/Exception
    //   258	273	866	java/lang/Exception
    //   320	357	866	java/lang/Exception
    //   980	987	990	java/lang/Exception
    //   1003	1008	1014	java/lang/Exception
    //   116	130	1021	java/io/IOException
    //   258	273	1021	java/io/IOException
    //   320	357	1021	java/io/IOException
    //   1135	1142	1145	java/lang/Exception
    //   1158	1163	1169	java/lang/Exception
    //   116	130	1176	com/tencent/oskplayer/cache/CacheDataSink$CacheDataSinkException
    //   258	273	1176	com/tencent/oskplayer/cache/CacheDataSink$CacheDataSinkException
    //   320	357	1176	com/tencent/oskplayer/cache/CacheDataSink$CacheDataSinkException
    //   1290	1297	1300	java/lang/Exception
    //   1313	1318	1324	java/lang/Exception
    //   116	130	1331	com/tencent/oskplayer/datasource/HttpDataSource$HttpDataSourceException
    //   258	273	1331	com/tencent/oskplayer/datasource/HttpDataSource$HttpDataSourceException
    //   320	357	1331	com/tencent/oskplayer/datasource/HttpDataSource$HttpDataSourceException
    //   1444	1451	1454	java/lang/Exception
    //   1467	1472	1478	java/lang/Exception
    //   578	590	1502	finally
    //   609	614	1502	finally
    //   626	634	1502	finally
    //   646	661	1502	finally
    //   669	679	1502	finally
    //   737	746	1502	finally
    //   757	764	1502	finally
    //   879	884	1502	finally
    //   892	901	1502	finally
    //   909	918	1502	finally
    //   926	933	1502	finally
    //   941	959	1502	finally
    //   971	980	1502	finally
    //   1034	1039	1502	finally
    //   1047	1056	1502	finally
    //   1064	1073	1502	finally
    //   1081	1088	1502	finally
    //   1096	1114	1502	finally
    //   1126	1135	1502	finally
    //   1189	1194	1502	finally
    //   1202	1211	1502	finally
    //   1219	1228	1502	finally
    //   1236	1243	1502	finally
    //   1251	1269	1502	finally
    //   1281	1290	1502	finally
    //   1344	1349	1502	finally
    //   1357	1366	1502	finally
    //   1374	1383	1502	finally
    //   1391	1398	1502	finally
    //   1406	1424	1502	finally
    //   1436	1444	1502	finally
    //   1510	1517	1520	java/lang/Exception
    //   1532	1537	1540	java/lang/Exception
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
    if ((!TextUtils.isEmpty(paramString)) && (this.cache != null))
    {
      paramString = PlayerUtils.parseVideoKey(paramString);
      return this.cache.getCachedBytesFromEnd(paramString);
    }
    return 0L;
  }
  
  public long getCachedBytesFromStart(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.cache != null))
    {
      paramString = PlayerUtils.parseVideoKey(paramString);
      return this.cache.getCachedBytesFromStart(paramString);
    }
    return 0L;
  }
  
  public double getCachedSizeRate(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0.0D;
    }
    if ((this.cache != null) && (this.isCacheProviderLocal))
    {
      paramString = PlayerUtils.parseVideoKey(paramString);
      return this.cache.getCachedSizeRate(paramString);
    }
    return 0.0D;
  }
  
  public String getLocalServerPrefix()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("http://127.0.0.1:");
    localStringBuilder.append(this.serverPort);
    return localStringBuilder.toString();
  }
  
  public long getTotalLength(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return -1L;
    }
    if ((this.cache != null) && (this.isCacheProviderLocal))
    {
      paramString = PlayerUtils.parseVideoKey(paramString);
      return this.cache.getTotalLength(paramString);
    }
    return -1L;
  }
  
  public long getUnCachedSize(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return -1L;
    }
    if ((this.cache != null) && (this.isCacheProviderLocal))
    {
      paramString = PlayerUtils.parseVideoKey(paramString);
      return this.cache.getRemainUnCachedBytes(paramString);
    }
    return -1L;
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
    Object localObject = "";
    String str1;
    String str2;
    if ((PlayerConfig.g().isEnableProxy()) && (this.mProxyExceptionCount <= 3) && (!this.executorService.isShutdown()) && (!this.executorService.isTerminated()))
    {
      if ((!URLUtil.isHttpUrl(paramString1)) && (!URLUtil.isHttpsUrl(paramString1)))
      {
        str1 = PlayerUtils.wrapFileScheme(paramString1);
        if (PlayerUtils.isAssetsUri(str1)) {
          paramString1 = str1;
        }
        while (PlayerUtils.isRawResourceUri(str1))
        {
          paramBoolean2 = false;
          str1 = paramString1;
          break;
        }
        return str1;
      }
      str1 = paramString1;
      String str3;
      if (PlayerUtils.isHLSStream(str1))
      {
        paramString3 = "application/vnd.apple.mpegurl";
        str3 = "1";
        paramBoolean2 = false;
      }
      else
      {
        str3 = paramString2;
      }
      try
      {
        paramString1 = URLEncoder.encode(str1, "UTF-8");
      }
      catch (UnsupportedEncodingException paramString1)
      {
        paramString2 = new StringBuilder();
        paramString2.append("invalid url ");
        paramString2.append(PlayerUtils.getPrintableStackTrace(paramString1));
        PlayerUtils.log(6, "VideoProxy", paramString2.toString());
        paramString1 = "";
      }
      if (TextUtils.isEmpty(paramString1))
      {
        paramString2 = new StringBuilder();
        paramString2.append("url is empty ");
        paramString2.append(paramString1);
        PlayerUtils.log(6, "VideoProxy", paramString2.toString());
        return str1;
      }
      if (this.executorService.isShutdown()) {
        return str1;
      }
      if (paramBoolean1)
      {
        paramString2 = new StringBuilder();
        paramString2.append("u");
        paramString2.append(String.valueOf(VIDEO_UUID.getAndIncrement()));
        str2 = paramString2.toString();
      }
      else
      {
        str2 = null;
      }
      paramString2 = OskFile.getFileExtension(PlayerUtils.getUrlFileName(str1));
      if (TextUtils.isEmpty(paramString2))
      {
        paramString2 = (String)localObject;
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("media.");
        ((StringBuilder)localObject).append(paramString2);
        paramString2 = ((StringBuilder)localObject).toString();
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(getLocalServerPrefix());
      ((StringBuilder)localObject).append("/");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append("?");
      ((StringBuilder)localObject).append("v");
      ((StringBuilder)localObject).append("=");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append("&");
      ((StringBuilder)localObject).append("mType");
      ((StringBuilder)localObject).append("=");
      ((StringBuilder)localObject).append("qzone_video_player");
      paramString2 = ((StringBuilder)localObject).toString();
      paramString1 = paramString2;
      if (paramBoolean2)
      {
        paramString1 = new StringBuilder();
        paramString1.append(paramString2);
        paramString1.append("&enableCache=1");
        paramString1 = paramString1.toString();
      }
      if ((paramInt != 90) && (paramInt != 10))
      {
        paramString2 = paramString1;
        if (paramInt != -1) {}
      }
      else
      {
        paramString2 = new StringBuilder();
        paramString2.append(paramString1);
        paramString2.append("&p=");
        paramString2.append(paramInt);
        paramString2 = paramString2.toString();
      }
      if ((!TextUtils.equals(str3, "1")) && (!TextUtils.equals(str3, "0")))
      {
        paramString1 = paramString2;
        if (!TextUtils.equals(str3, "-1")) {}
      }
      else
      {
        paramString1 = new StringBuilder();
        paramString1.append(paramString2);
        paramString1.append("&dataSourceType=");
        paramString1.append(str3);
        paramString1 = paramString1.toString();
      }
      paramString2 = paramString1;
      if (TextUtils.isEmpty(paramString3)) {}
    }
    try
    {
      paramString2 = URLEncoder.encode(paramString3, "UTF-8");
      paramString3 = paramString2;
    }
    catch (UnsupportedEncodingException paramString2)
    {
      label660:
      break label660;
    }
    paramString2 = new StringBuilder();
    paramString2.append("unable to encode contentType ");
    paramString2.append(paramString3);
    PlayerUtils.log(6, "VideoProxy", paramString2.toString());
    paramString3 = null;
    paramString2 = paramString1;
    if (!TextUtils.isEmpty(paramString3))
    {
      paramString2 = new StringBuilder();
      paramString2.append(paramString1);
      paramString2.append("&preferredContentType=");
      paramString2.append(paramString3);
      paramString2 = paramString2.toString();
    }
    paramString1 = paramString2;
    if (str2 != null)
    {
      paramString1 = new StringBuilder();
      paramString1.append(paramString2);
      paramString1.append("&uuid=");
      paramString1.append(str2);
      paramString1 = paramString1.toString();
    }
    paramString2 = paramString1;
    paramString1 = paramString2;
    if (this.isSecretEnable)
    {
      paramString1 = paramString2;
      if (PlayerConfig.g().isEnableProxySecret()) {
        try
        {
          paramString1 = new StringBuilder();
          paramString1.append(paramString2);
          paramString1.append("&t=");
          paramString1.append(SecretUtils.encode("des", SecretUtils.getRandomNum(), PlayerUtils.parseVideoKey(str1)));
          paramString1 = paramString1.toString();
        }
        catch (Exception paramString1)
        {
          paramString3 = new StringBuilder();
          paramString3.append("encode failed = ");
          paramString3.append(PlayerUtils.getPrintableStackTrace(paramString1));
          PlayerUtils.log(6, "VideoProxy", paramString3.toString());
          this.isSecretEnable = false;
          paramString1 = paramString2;
        }
      }
    }
    paramString2 = paramString1;
    if (paramHttpHeader != null)
    {
      this.mExtraHeaderCollection.add(paramHttpHeader);
      if (this.mExtraHeaderCollection.size() > 100)
      {
        paramString2 = this.mExtraHeaderCollection;
        paramString2.remove(paramString2.iterator().next());
      }
      paramInt = paramHttpHeader.getId();
      paramString2 = new StringBuilder();
      paramString2.append(paramString1);
      paramString2.append("&eh=");
      paramString2.append(paramInt);
      paramString2 = paramString2.toString();
    }
    return paramString2;
    return PlayerUtils.wrapFileScheme(paramString1);
  }
  
  public List<String> getUrl(List<String> paramList)
  {
    return getUrl(paramList, null);
  }
  
  public List<String> getUrl(List<String> paramList, List<HttpHeader> paramList1)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("u");
    ((StringBuilder)localObject).append(String.valueOf(VIDEO_UUID.getAndIncrement()));
    String str1 = ((StringBuilder)localObject).toString();
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      Iterator localIterator = paramList.iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        localObject = (String)localIterator.next();
        String str2 = PlayerConfig.g().getDefaultDataSourceType();
        if (paramList1 != null) {
          paramList = (HttpHeader)paramList1.get(i);
        } else {
          paramList = null;
        }
        localObject = getUrl((String)localObject, false, true, str2, "video/mp4", 90, paramList);
        paramList = (List<String>)localObject;
        if (URLUtil.isHttpUrl((String)localObject))
        {
          paramList = (List<String>)localObject;
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            paramList = (List<String>)localObject;
            if (((String)localObject).startsWith("http://127.0.0.1"))
            {
              paramList = new StringBuilder();
              paramList.append((String)localObject);
              paramList.append("&uuid=");
              paramList.append(str1);
              paramList = paramList.toString();
            }
          }
        }
        localArrayList.add(paramList);
        i += 1;
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
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    ITcDataSourceUtils localITcDataSourceUtils = this.tcDataSourceUtils;
    if ((localITcDataSourceUtils != null) && (!this.isCacheProviderLocal)) {
      return localITcDataSourceUtils.isClipCompleteOnDisk(paramString, 1);
    }
    if ((this.cache != null) && (this.isCacheProviderLocal))
    {
      paramString = PlayerUtils.parseVideoKey(paramString);
      return this.cache.isCached(paramString);
    }
    return false;
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
      Object localObject = (String)paramList.next();
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (URLUtil.isNetworkUrl((String)localObject)))
      {
        VideoProxy.PreloadInfo localPreloadInfo = new VideoProxy.PreloadInfo();
        localPreloadInfo.originalUrl = ((String)localObject);
        localPreloadInfo.localUrl = getUrl((String)localObject, true, true, "-1", "video/mp4", 10, paramHttpHeader);
        localArrayList.add(localPreloadInfo);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("preload wz localUrl ");
        ((StringBuilder)localObject).append(localPreloadInfo.localUrl);
        PlayerUtils.log(4, "preloadMedia", ((StringBuilder)localObject).toString());
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
    //   4: ifne +3761 -> 3765
    //   7: aload_1
    //   8: invokestatic 1632	android/webkit/URLUtil:isNetworkUrl	(Ljava/lang/String;)Z
    //   11: ifne +6 -> 17
    //   14: goto +3751 -> 3765
    //   17: aload_0
    //   18: getfield 1294	com/tencent/oskplayer/proxy/VideoProxy:tcDataSourceUtils	Lcom/tencent/oskplayer/proxy/ITcDataSourceUtils;
    //   21: astore 22
    //   23: aload 22
    //   25: ifnull +27 -> 52
    //   28: aload_0
    //   29: getfield 181	com/tencent/oskplayer/proxy/VideoProxy:isCacheProviderLocal	Z
    //   32: ifne +20 -> 52
    //   35: aload 22
    //   37: aload_1
    //   38: lconst_0
    //   39: iconst_0
    //   40: iconst_1
    //   41: bipush 15
    //   43: ldc_w 1752
    //   46: invokeinterface 1865 8 0
    //   51: ireturn
    //   52: invokestatic 176	com/tencent/oskplayer/PlayerConfig:g	()Lcom/tencent/oskplayer/PlayerConfig;
    //   55: invokevirtual 688	com/tencent/oskplayer/PlayerConfig:isEnableProxy	()Z
    //   58: ifne +14 -> 72
    //   61: iconst_4
    //   62: ldc 49
    //   64: ldc_w 1867
    //   67: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   70: iconst_0
    //   71: ireturn
    //   72: aload_1
    //   73: invokestatic 936	com/tencent/oskplayer/util/PlayerUtils:parseVideoKey	(Ljava/lang/String;)Ljava/lang/String;
    //   76: astore 28
    //   78: aload_0
    //   79: aload_1
    //   80: iconst_1
    //   81: iconst_1
    //   82: ldc 81
    //   84: ldc 73
    //   86: bipush 10
    //   88: aload 9
    //   90: invokevirtual 654	com/tencent/oskplayer/proxy/VideoProxy:getUrl	(Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;ILcom/tencent/oskplayer/datasource/HttpHeader;)Ljava/lang/String;
    //   93: astore 9
    //   95: aload 9
    //   97: invokestatic 1870	com/tencent/oskplayer/util/PlayerUtils:getVideoUuidFromVideoUrl	(Ljava/lang/String;)Ljava/lang/String;
    //   100: astore 26
    //   102: aload 10
    //   104: ifnull +11 -> 115
    //   107: aload 10
    //   109: aload_1
    //   110: invokeinterface 1873 2 0
    //   115: iload 7
    //   117: ifeq +2308 -> 2425
    //   120: aload 9
    //   122: ifnull +2303 -> 2425
    //   125: new 1181	com/tencent/oskplayer/datasource/DefaultHttpDataSource
    //   128: dup
    //   129: ldc 55
    //   131: aconst_null
    //   132: aconst_null
    //   133: invokespecial 1184	com/tencent/oskplayer/datasource/DefaultHttpDataSource:<init>	(Ljava/lang/String;Lcom/tencent/oskplayer/util/Predicate;Lcom/tencent/oskplayer/util/Fixer;)V
    //   136: astore 27
    //   138: sipush 512
    //   141: newarray byte
    //   143: astore 24
    //   145: aload 27
    //   147: new 836	com/tencent/oskplayer/datasource/DataSpec
    //   150: dup
    //   151: aload 9
    //   153: invokestatic 817	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   156: lconst_0
    //   157: lconst_0
    //   158: ldc2_w 929
    //   161: aconst_null
    //   162: iconst_0
    //   163: aconst_null
    //   164: invokespecial 1196	com/tencent/oskplayer/datasource/DataSpec:<init>	(Landroid/net/Uri;JJJLjava/lang/String;ILjava/lang/String;)V
    //   167: invokeinterface 535 2 0
    //   172: pop2
    //   173: aload 27
    //   175: invokeinterface 1199 1 0
    //   180: lstore 14
    //   182: lload 4
    //   184: ldc2_w 1874
    //   187: lcmp
    //   188: ifle +403 -> 591
    //   191: ldc2_w 1876
    //   194: lload 14
    //   196: lmul
    //   197: lload 4
    //   199: ldiv
    //   200: l2i
    //   201: sipush 1000
    //   204: imul
    //   205: istore 11
    //   207: iload 6
    //   209: sipush 1000
    //   212: idiv
    //   213: iload 11
    //   215: imul
    //   216: bipush 8
    //   218: idiv
    //   219: istore 6
    //   221: lload 4
    //   223: ldc2_w 1878
    //   226: ldiv
    //   227: lstore 4
    //   229: aload 9
    //   231: astore 23
    //   233: lload 4
    //   235: ldc2_w 1880
    //   238: lmul
    //   239: lstore 18
    //   241: ldc_w 1883
    //   244: astore 22
    //   246: iload 6
    //   248: i2l
    //   249: lstore 20
    //   251: lload_2
    //   252: lstore 4
    //   254: lload_2
    //   255: lstore 12
    //   257: lload_2
    //   258: lstore 16
    //   260: lload_2
    //   261: lload 20
    //   263: lload 18
    //   265: ladd
    //   266: invokestatic 256	java/lang/Math:min	(JJ)J
    //   269: lstore_2
    //   270: lload_2
    //   271: lstore 4
    //   273: lload_2
    //   274: lstore 12
    //   276: lload_2
    //   277: lstore 16
    //   279: new 258	java/lang/StringBuilder
    //   282: dup
    //   283: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   286: astore 25
    //   288: lload_2
    //   289: lstore 4
    //   291: lload_2
    //   292: lstore 12
    //   294: lload_2
    //   295: lstore 16
    //   297: aload 25
    //   299: ldc_w 1885
    //   302: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: pop
    //   306: lload_2
    //   307: lstore 4
    //   309: lload_2
    //   310: lstore 12
    //   312: lload_2
    //   313: lstore 16
    //   315: aload 25
    //   317: iload 11
    //   319: invokevirtual 430	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   322: pop
    //   323: lload_2
    //   324: lstore 4
    //   326: lload_2
    //   327: lstore 12
    //   329: lload_2
    //   330: lstore 16
    //   332: aload 25
    //   334: ldc_w 945
    //   337: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: pop
    //   341: lload_2
    //   342: lstore 4
    //   344: lload_2
    //   345: lstore 12
    //   347: lload_2
    //   348: lstore 16
    //   350: aload 25
    //   352: aload_1
    //   353: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: pop
    //   357: lload_2
    //   358: lstore 4
    //   360: lload_2
    //   361: lstore 12
    //   363: lload_2
    //   364: lstore 16
    //   366: aload 25
    //   368: ldc_w 1887
    //   371: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   374: pop
    //   375: lload_2
    //   376: lstore 4
    //   378: lload_2
    //   379: lstore 12
    //   381: lload_2
    //   382: lstore 16
    //   384: aload 25
    //   386: lload 18
    //   388: invokevirtual 268	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   391: pop
    //   392: lload_2
    //   393: lstore 4
    //   395: lload_2
    //   396: lstore 12
    //   398: lload_2
    //   399: lstore 16
    //   401: aload 25
    //   403: ldc_w 1889
    //   406: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   409: pop
    //   410: lload_2
    //   411: lstore 4
    //   413: lload_2
    //   414: lstore 12
    //   416: lload_2
    //   417: lstore 16
    //   419: aload 25
    //   421: iload 6
    //   423: invokevirtual 430	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   426: pop
    //   427: lload_2
    //   428: lstore 4
    //   430: lload_2
    //   431: lstore 12
    //   433: lload_2
    //   434: lstore 16
    //   436: aload 25
    //   438: ldc_w 1891
    //   441: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   444: pop
    //   445: lload_2
    //   446: lstore 4
    //   448: lload_2
    //   449: lstore 12
    //   451: lload_2
    //   452: lstore 16
    //   454: aload 25
    //   456: lload_2
    //   457: invokevirtual 268	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   460: pop
    //   461: lload_2
    //   462: lstore 4
    //   464: lload_2
    //   465: lstore 12
    //   467: lload_2
    //   468: lstore 16
    //   470: aload 25
    //   472: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   475: astore 25
    //   477: iconst_4
    //   478: ldc 49
    //   480: aload 25
    //   482: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   485: goto +167 -> 652
    //   488: astore 9
    //   490: goto +18 -> 508
    //   493: astore 9
    //   495: goto +24 -> 519
    //   498: astore 9
    //   500: goto +42 -> 542
    //   503: astore 9
    //   505: lload 4
    //   507: lstore_2
    //   508: lconst_0
    //   509: lstore 4
    //   511: goto +1741 -> 2252
    //   514: astore 9
    //   516: lload 12
    //   518: lstore_2
    //   519: aload 23
    //   521: astore 24
    //   523: lconst_0
    //   524: lstore 4
    //   526: aload 9
    //   528: astore 23
    //   530: aload 24
    //   532: astore 9
    //   534: goto +429 -> 963
    //   537: astore 9
    //   539: lload 16
    //   541: lstore_2
    //   542: aload 23
    //   544: astore 24
    //   546: lconst_0
    //   547: lstore 4
    //   549: aload 9
    //   551: astore 23
    //   553: aload 24
    //   555: astore 9
    //   557: goto +935 -> 1492
    //   560: astore 9
    //   562: goto +375 -> 937
    //   565: astore 23
    //   567: ldc_w 1883
    //   570: astore 22
    //   572: lconst_0
    //   573: lstore 4
    //   575: goto +388 -> 963
    //   578: astore 23
    //   580: ldc_w 1883
    //   583: astore 22
    //   585: lconst_0
    //   586: lstore 4
    //   588: goto +904 -> 1492
    //   591: aload 9
    //   593: astore 22
    //   595: ldc_w 1883
    //   598: astore 22
    //   600: new 258	java/lang/StringBuilder
    //   603: dup
    //   604: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   607: astore 22
    //   609: aload 22
    //   611: ldc_w 1893
    //   614: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   617: pop
    //   618: aload 22
    //   620: aload_1
    //   621: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   624: pop
    //   625: aload 22
    //   627: ldc_w 1895
    //   630: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   633: pop
    //   634: aload 22
    //   636: lload_2
    //   637: invokevirtual 268	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   640: pop
    //   641: iconst_4
    //   642: ldc 49
    //   644: aload 22
    //   646: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   649: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   652: lconst_0
    //   653: lstore 4
    //   655: lload 4
    //   657: lload_2
    //   658: lcmp
    //   659: ifge +72 -> 731
    //   662: aload 27
    //   664: aload 24
    //   666: iconst_0
    //   667: aload 24
    //   669: arraylength
    //   670: invokeinterface 1203 4 0
    //   675: istore 6
    //   677: iload 6
    //   679: i2l
    //   680: lstore 12
    //   682: lload 12
    //   684: ldc2_w 929
    //   687: lcmp
    //   688: ifeq +43 -> 731
    //   691: lload 4
    //   693: lload 12
    //   695: ladd
    //   696: lstore 4
    //   698: goto -43 -> 655
    //   701: astore 9
    //   703: ldc_w 1883
    //   706: astore 22
    //   708: goto +1544 -> 2252
    //   711: astore 23
    //   713: ldc_w 1883
    //   716: astore 22
    //   718: goto +245 -> 963
    //   721: astore 23
    //   723: ldc_w 1883
    //   726: astore 22
    //   728: goto +764 -> 1492
    //   731: new 258	java/lang/StringBuilder
    //   734: dup
    //   735: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   738: astore 22
    //   740: aload 22
    //   742: ldc_w 1883
    //   745: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   748: pop
    //   749: aload 22
    //   751: lload 4
    //   753: invokevirtual 268	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   756: pop
    //   757: aload 22
    //   759: ldc_w 1897
    //   762: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   765: pop
    //   766: iconst_3
    //   767: ldc 49
    //   769: aload 22
    //   771: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   774: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   777: aload 27
    //   779: invokeinterface 1210 1 0
    //   784: iconst_4
    //   785: ldc 49
    //   787: ldc_w 1899
    //   790: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   793: new 258	java/lang/StringBuilder
    //   796: dup
    //   797: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   800: astore 22
    //   802: aload 22
    //   804: ldc_w 1901
    //   807: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   810: pop
    //   811: aload 22
    //   813: aload_1
    //   814: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   817: pop
    //   818: aload 22
    //   820: ldc_w 1895
    //   823: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   826: pop
    //   827: aload 22
    //   829: lload_2
    //   830: invokevirtual 268	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   833: pop
    //   834: iconst_4
    //   835: ldc 49
    //   837: aload 22
    //   839: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   842: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   845: goto +61 -> 906
    //   848: astore 22
    //   850: new 258	java/lang/StringBuilder
    //   853: dup
    //   854: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   857: astore 23
    //   859: aload 23
    //   861: ldc_w 1903
    //   864: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   867: pop
    //   868: aload 23
    //   870: aload 22
    //   872: invokevirtual 507	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   875: pop
    //   876: iconst_4
    //   877: ldc 49
    //   879: aload 23
    //   881: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   884: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   887: aload 10
    //   889: astore 22
    //   891: aload 22
    //   893: ifnull +13 -> 906
    //   896: aload 22
    //   898: aload_1
    //   899: bipush 151
    //   901: invokeinterface 1904 3 0
    //   906: lload_2
    //   907: lstore 12
    //   909: lload 14
    //   911: lstore 4
    //   913: aload 9
    //   915: astore 22
    //   917: goto +1520 -> 2437
    //   920: astore 9
    //   922: goto +15 -> 937
    //   925: astore 23
    //   927: goto -360 -> 567
    //   930: astore 23
    //   932: goto -352 -> 580
    //   935: astore 9
    //   937: ldc_w 1883
    //   940: astore 22
    //   942: lconst_0
    //   943: lstore 4
    //   945: goto +1307 -> 2252
    //   948: astore 23
    //   950: ldc_w 1883
    //   953: astore 22
    //   955: lconst_0
    //   956: lstore 4
    //   958: ldc2_w 929
    //   961: lstore 14
    //   963: aload 10
    //   965: astore 25
    //   967: aload 22
    //   969: astore 24
    //   971: lload_2
    //   972: lstore 12
    //   974: lload 4
    //   976: lstore 16
    //   978: new 258	java/lang/StringBuilder
    //   981: dup
    //   982: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   985: astore 29
    //   987: aload 22
    //   989: astore 24
    //   991: lload_2
    //   992: lstore 12
    //   994: lload 4
    //   996: lstore 16
    //   998: aload 29
    //   1000: ldc_w 1906
    //   1003: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1006: pop
    //   1007: aload 22
    //   1009: astore 24
    //   1011: lload_2
    //   1012: lstore 12
    //   1014: lload 4
    //   1016: lstore 16
    //   1018: aload 29
    //   1020: lload_2
    //   1021: invokevirtual 268	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1024: pop
    //   1025: aload 22
    //   1027: astore 24
    //   1029: lload_2
    //   1030: lstore 12
    //   1032: lload 4
    //   1034: lstore 16
    //   1036: aload 29
    //   1038: ldc_w 1908
    //   1041: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1044: pop
    //   1045: aload 22
    //   1047: astore 24
    //   1049: lload_2
    //   1050: lstore 12
    //   1052: lload 4
    //   1054: lstore 16
    //   1056: aload 29
    //   1058: aload_1
    //   1059: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1062: pop
    //   1063: aload 22
    //   1065: astore 24
    //   1067: lload_2
    //   1068: lstore 12
    //   1070: lload 4
    //   1072: lstore 16
    //   1074: aload 29
    //   1076: ldc_w 1910
    //   1079: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1082: pop
    //   1083: aload 22
    //   1085: astore 24
    //   1087: lload_2
    //   1088: lstore 12
    //   1090: lload 4
    //   1092: lstore 16
    //   1094: aload 29
    //   1096: aload 23
    //   1098: invokestatic 395	com/tencent/oskplayer/util/PlayerUtils:getPrintableStackTrace	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1101: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1104: pop
    //   1105: aload 22
    //   1107: astore 24
    //   1109: lload_2
    //   1110: lstore 12
    //   1112: lload 4
    //   1114: lstore 16
    //   1116: iconst_5
    //   1117: ldc 49
    //   1119: aload 29
    //   1121: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1124: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   1127: aload 22
    //   1129: astore 24
    //   1131: lload_2
    //   1132: lstore 12
    //   1134: lload 4
    //   1136: lstore 16
    //   1138: new 258	java/lang/StringBuilder
    //   1141: dup
    //   1142: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   1145: astore 23
    //   1147: aload 22
    //   1149: astore 24
    //   1151: lload_2
    //   1152: lstore 12
    //   1154: lload 4
    //   1156: lstore 16
    //   1158: aload 23
    //   1160: ldc_w 1893
    //   1163: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1166: pop
    //   1167: aload 22
    //   1169: astore 24
    //   1171: lload_2
    //   1172: lstore 12
    //   1174: lload 4
    //   1176: lstore 16
    //   1178: aload 23
    //   1180: aload_1
    //   1181: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1184: pop
    //   1185: aload 22
    //   1187: astore 24
    //   1189: lload_2
    //   1190: lstore 12
    //   1192: lload 4
    //   1194: lstore 16
    //   1196: aload 23
    //   1198: ldc_w 1895
    //   1201: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1204: pop
    //   1205: aload 22
    //   1207: astore 24
    //   1209: lload_2
    //   1210: lstore 12
    //   1212: lload 4
    //   1214: lstore 16
    //   1216: aload 23
    //   1218: lload_2
    //   1219: invokevirtual 268	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1222: pop
    //   1223: aload 22
    //   1225: astore 24
    //   1227: lload_2
    //   1228: lstore 12
    //   1230: lload 4
    //   1232: lstore 16
    //   1234: iconst_4
    //   1235: ldc 49
    //   1237: aload 23
    //   1239: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1242: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   1245: aload 25
    //   1247: ifnull +24 -> 1271
    //   1250: aload 22
    //   1252: astore 24
    //   1254: lload_2
    //   1255: lstore 12
    //   1257: lload 4
    //   1259: lstore 16
    //   1261: aload 25
    //   1263: aload_1
    //   1264: bipush 152
    //   1266: invokeinterface 1904 3 0
    //   1271: new 258	java/lang/StringBuilder
    //   1274: dup
    //   1275: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   1278: astore 23
    //   1280: aload 23
    //   1282: aload 22
    //   1284: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1287: pop
    //   1288: aload 23
    //   1290: lload 4
    //   1292: invokevirtual 268	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1295: pop
    //   1296: aload 23
    //   1298: ldc_w 1897
    //   1301: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1304: pop
    //   1305: iconst_3
    //   1306: ldc 49
    //   1308: aload 23
    //   1310: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1313: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   1316: aload 27
    //   1318: invokeinterface 1210 1 0
    //   1323: iconst_4
    //   1324: ldc 49
    //   1326: ldc_w 1899
    //   1329: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   1332: new 258	java/lang/StringBuilder
    //   1335: dup
    //   1336: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   1339: astore 22
    //   1341: aload 22
    //   1343: ldc_w 1901
    //   1346: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1349: pop
    //   1350: aload 22
    //   1352: aload_1
    //   1353: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1356: pop
    //   1357: aload 22
    //   1359: ldc_w 1895
    //   1362: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1365: pop
    //   1366: aload 22
    //   1368: lload_2
    //   1369: invokevirtual 268	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1372: pop
    //   1373: iconst_4
    //   1374: ldc 49
    //   1376: aload 22
    //   1378: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1381: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   1384: lload_2
    //   1385: lstore 12
    //   1387: lload 14
    //   1389: lstore 4
    //   1391: aload 9
    //   1393: astore 22
    //   1395: goto +1042 -> 2437
    //   1398: astore 22
    //   1400: new 258	java/lang/StringBuilder
    //   1403: dup
    //   1404: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   1407: astore 23
    //   1409: aload 23
    //   1411: ldc_w 1903
    //   1414: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1417: pop
    //   1418: aload 23
    //   1420: aload 22
    //   1422: invokevirtual 507	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1425: pop
    //   1426: iconst_4
    //   1427: ldc 49
    //   1429: aload 23
    //   1431: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1434: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   1437: lload_2
    //   1438: lstore 12
    //   1440: lload 14
    //   1442: lstore 4
    //   1444: aload 9
    //   1446: astore 22
    //   1448: aload 25
    //   1450: ifnull +987 -> 2437
    //   1453: lload 14
    //   1455: lstore 4
    //   1457: aload 10
    //   1459: aload_1
    //   1460: bipush 151
    //   1462: invokeinterface 1904 3 0
    //   1467: lload_2
    //   1468: lstore 12
    //   1470: aload 9
    //   1472: astore 22
    //   1474: goto +963 -> 2437
    //   1477: astore 23
    //   1479: ldc_w 1883
    //   1482: astore 22
    //   1484: lconst_0
    //   1485: lstore 4
    //   1487: ldc2_w 929
    //   1490: lstore 14
    //   1492: aload 10
    //   1494: astore 25
    //   1496: aload 22
    //   1498: astore 24
    //   1500: lload_2
    //   1501: lstore 12
    //   1503: lload 4
    //   1505: lstore 16
    //   1507: aload 23
    //   1509: invokevirtual 1911	com/tencent/oskplayer/datasource/HttpDataSource$HttpDataSourceException:getCause	()Ljava/lang/Throwable;
    //   1512: instanceof 1913
    //   1515: ifeq +349 -> 1864
    //   1518: aload 22
    //   1520: astore 24
    //   1522: lload_2
    //   1523: lstore 12
    //   1525: lload 4
    //   1527: lstore 16
    //   1529: aload 23
    //   1531: invokevirtual 1914	com/tencent/oskplayer/datasource/HttpDataSource$HttpDataSourceException:getMessage	()Ljava/lang/String;
    //   1534: ifnull +141 -> 1675
    //   1537: aload 22
    //   1539: astore 24
    //   1541: lload_2
    //   1542: lstore 12
    //   1544: lload 4
    //   1546: lstore 16
    //   1548: aload 23
    //   1550: invokevirtual 1914	com/tencent/oskplayer/datasource/HttpDataSource$HttpDataSourceException:getMessage	()Ljava/lang/String;
    //   1553: invokevirtual 790	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   1556: ldc_w 792
    //   1559: invokevirtual 665	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1562: ifeq +113 -> 1675
    //   1565: aload 22
    //   1567: astore 24
    //   1569: lload_2
    //   1570: lstore 12
    //   1572: lload 4
    //   1574: lstore 16
    //   1576: new 258	java/lang/StringBuilder
    //   1579: dup
    //   1580: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   1583: astore 23
    //   1585: aload 22
    //   1587: astore 24
    //   1589: lload_2
    //   1590: lstore 12
    //   1592: lload 4
    //   1594: lstore 16
    //   1596: aload 23
    //   1598: ldc_w 1916
    //   1601: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1604: pop
    //   1605: aload 22
    //   1607: astore 24
    //   1609: lload_2
    //   1610: lstore 12
    //   1612: lload 4
    //   1614: lstore 16
    //   1616: aload 23
    //   1618: lload 4
    //   1620: invokevirtual 268	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1623: pop
    //   1624: aload 22
    //   1626: astore 24
    //   1628: lload_2
    //   1629: lstore 12
    //   1631: lload 4
    //   1633: lstore 16
    //   1635: iconst_4
    //   1636: ldc 49
    //   1638: aload 23
    //   1640: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1643: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   1646: aload 25
    //   1648: ifnull +402 -> 2050
    //   1651: aload 22
    //   1653: astore 24
    //   1655: lload_2
    //   1656: lstore 12
    //   1658: lload 4
    //   1660: lstore 16
    //   1662: aload 25
    //   1664: aload_1
    //   1665: bipush 155
    //   1667: invokeinterface 1904 3 0
    //   1672: goto +378 -> 2050
    //   1675: aload 22
    //   1677: astore 24
    //   1679: lload_2
    //   1680: lstore 12
    //   1682: lload 4
    //   1684: lstore 16
    //   1686: new 258	java/lang/StringBuilder
    //   1689: dup
    //   1690: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   1693: astore 29
    //   1695: aload 22
    //   1697: astore 24
    //   1699: lload_2
    //   1700: lstore 12
    //   1702: lload 4
    //   1704: lstore 16
    //   1706: aload 29
    //   1708: ldc_w 1906
    //   1711: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1714: pop
    //   1715: aload 22
    //   1717: astore 24
    //   1719: lload_2
    //   1720: lstore 12
    //   1722: lload 4
    //   1724: lstore 16
    //   1726: aload 29
    //   1728: lload_2
    //   1729: invokevirtual 268	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1732: pop
    //   1733: aload 22
    //   1735: astore 24
    //   1737: lload_2
    //   1738: lstore 12
    //   1740: lload 4
    //   1742: lstore 16
    //   1744: aload 29
    //   1746: ldc_w 1908
    //   1749: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1752: pop
    //   1753: aload 22
    //   1755: astore 24
    //   1757: lload_2
    //   1758: lstore 12
    //   1760: lload 4
    //   1762: lstore 16
    //   1764: aload 29
    //   1766: aload_1
    //   1767: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1770: pop
    //   1771: aload 22
    //   1773: astore 24
    //   1775: lload_2
    //   1776: lstore 12
    //   1778: lload 4
    //   1780: lstore 16
    //   1782: aload 29
    //   1784: ldc_w 1918
    //   1787: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1790: pop
    //   1791: aload 22
    //   1793: astore 24
    //   1795: lload_2
    //   1796: lstore 12
    //   1798: lload 4
    //   1800: lstore 16
    //   1802: aload 29
    //   1804: aload 23
    //   1806: invokestatic 395	com/tencent/oskplayer/util/PlayerUtils:getPrintableStackTrace	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1809: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1812: pop
    //   1813: aload 22
    //   1815: astore 24
    //   1817: lload_2
    //   1818: lstore 12
    //   1820: lload 4
    //   1822: lstore 16
    //   1824: iconst_5
    //   1825: ldc 49
    //   1827: aload 29
    //   1829: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1832: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   1835: aload 25
    //   1837: ifnull +213 -> 2050
    //   1840: aload 22
    //   1842: astore 24
    //   1844: lload_2
    //   1845: lstore 12
    //   1847: lload 4
    //   1849: lstore 16
    //   1851: aload 25
    //   1853: aload_1
    //   1854: bipush 154
    //   1856: invokeinterface 1904 3 0
    //   1861: goto +189 -> 2050
    //   1864: aload 22
    //   1866: astore 24
    //   1868: lload_2
    //   1869: lstore 12
    //   1871: lload 4
    //   1873: lstore 16
    //   1875: new 258	java/lang/StringBuilder
    //   1878: dup
    //   1879: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   1882: astore 29
    //   1884: aload 22
    //   1886: astore 24
    //   1888: lload_2
    //   1889: lstore 12
    //   1891: lload 4
    //   1893: lstore 16
    //   1895: aload 29
    //   1897: ldc_w 1906
    //   1900: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1903: pop
    //   1904: aload 22
    //   1906: astore 24
    //   1908: lload_2
    //   1909: lstore 12
    //   1911: lload 4
    //   1913: lstore 16
    //   1915: aload 29
    //   1917: lload_2
    //   1918: invokevirtual 268	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1921: pop
    //   1922: aload 22
    //   1924: astore 24
    //   1926: lload_2
    //   1927: lstore 12
    //   1929: lload 4
    //   1931: lstore 16
    //   1933: aload 29
    //   1935: ldc_w 1908
    //   1938: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1941: pop
    //   1942: aload 22
    //   1944: astore 24
    //   1946: lload_2
    //   1947: lstore 12
    //   1949: lload 4
    //   1951: lstore 16
    //   1953: aload 29
    //   1955: aload_1
    //   1956: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1959: pop
    //   1960: aload 22
    //   1962: astore 24
    //   1964: lload_2
    //   1965: lstore 12
    //   1967: lload 4
    //   1969: lstore 16
    //   1971: aload 29
    //   1973: ldc_w 1920
    //   1976: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1979: pop
    //   1980: aload 22
    //   1982: astore 24
    //   1984: lload_2
    //   1985: lstore 12
    //   1987: lload 4
    //   1989: lstore 16
    //   1991: aload 29
    //   1993: aload 23
    //   1995: invokestatic 395	com/tencent/oskplayer/util/PlayerUtils:getPrintableStackTrace	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1998: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2001: pop
    //   2002: aload 22
    //   2004: astore 24
    //   2006: lload_2
    //   2007: lstore 12
    //   2009: lload 4
    //   2011: lstore 16
    //   2013: iconst_5
    //   2014: ldc 49
    //   2016: aload 29
    //   2018: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2021: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2024: aload 25
    //   2026: ifnull +24 -> 2050
    //   2029: aload 22
    //   2031: astore 24
    //   2033: lload_2
    //   2034: lstore 12
    //   2036: lload 4
    //   2038: lstore 16
    //   2040: aload 25
    //   2042: aload_1
    //   2043: bipush 153
    //   2045: invokeinterface 1904 3 0
    //   2050: new 258	java/lang/StringBuilder
    //   2053: dup
    //   2054: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   2057: astore 23
    //   2059: aload 23
    //   2061: aload 22
    //   2063: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2066: pop
    //   2067: aload 23
    //   2069: lload 4
    //   2071: invokevirtual 268	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2074: pop
    //   2075: aload 23
    //   2077: ldc_w 1897
    //   2080: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2083: pop
    //   2084: iconst_3
    //   2085: ldc 49
    //   2087: aload 23
    //   2089: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2092: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2095: aload 27
    //   2097: invokeinterface 1210 1 0
    //   2102: iconst_4
    //   2103: ldc 49
    //   2105: ldc_w 1899
    //   2108: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2111: new 258	java/lang/StringBuilder
    //   2114: dup
    //   2115: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   2118: astore 22
    //   2120: aload 22
    //   2122: ldc_w 1901
    //   2125: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2128: pop
    //   2129: aload 22
    //   2131: aload_1
    //   2132: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2135: pop
    //   2136: aload 22
    //   2138: ldc_w 1895
    //   2141: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2144: pop
    //   2145: aload 22
    //   2147: lload_2
    //   2148: invokevirtual 268	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2151: pop
    //   2152: iconst_4
    //   2153: ldc 49
    //   2155: aload 22
    //   2157: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2160: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2163: lload_2
    //   2164: lstore 12
    //   2166: lload 14
    //   2168: lstore 4
    //   2170: aload 9
    //   2172: astore 22
    //   2174: goto +263 -> 2437
    //   2177: astore 22
    //   2179: new 258	java/lang/StringBuilder
    //   2182: dup
    //   2183: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   2186: astore 23
    //   2188: aload 23
    //   2190: ldc_w 1903
    //   2193: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2196: pop
    //   2197: aload 23
    //   2199: aload 22
    //   2201: invokevirtual 507	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2204: pop
    //   2205: iconst_4
    //   2206: ldc 49
    //   2208: aload 23
    //   2210: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2213: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2216: lload_2
    //   2217: lstore 12
    //   2219: lload 14
    //   2221: lstore 4
    //   2223: aload 9
    //   2225: astore 22
    //   2227: aload 25
    //   2229: ifnull +208 -> 2437
    //   2232: lload 14
    //   2234: lstore 4
    //   2236: goto -779 -> 1457
    //   2239: astore 9
    //   2241: lload 16
    //   2243: lstore 4
    //   2245: lload 12
    //   2247: lstore_2
    //   2248: aload 24
    //   2250: astore 22
    //   2252: new 258	java/lang/StringBuilder
    //   2255: dup
    //   2256: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   2259: astore 23
    //   2261: aload 23
    //   2263: aload 22
    //   2265: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2268: pop
    //   2269: aload 23
    //   2271: lload 4
    //   2273: invokevirtual 268	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2276: pop
    //   2277: aload 23
    //   2279: ldc_w 1897
    //   2282: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2285: pop
    //   2286: iconst_3
    //   2287: ldc 49
    //   2289: aload 23
    //   2291: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2294: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2297: aload 27
    //   2299: invokeinterface 1210 1 0
    //   2304: iconst_4
    //   2305: ldc 49
    //   2307: ldc_w 1899
    //   2310: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2313: new 258	java/lang/StringBuilder
    //   2316: dup
    //   2317: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   2320: astore 22
    //   2322: aload 22
    //   2324: ldc_w 1901
    //   2327: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2330: pop
    //   2331: aload 22
    //   2333: aload_1
    //   2334: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2337: pop
    //   2338: aload 22
    //   2340: ldc_w 1895
    //   2343: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2346: pop
    //   2347: aload 22
    //   2349: lload_2
    //   2350: invokevirtual 268	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2353: pop
    //   2354: iconst_4
    //   2355: ldc 49
    //   2357: aload 22
    //   2359: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2362: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2365: goto +57 -> 2422
    //   2368: astore 22
    //   2370: new 258	java/lang/StringBuilder
    //   2373: dup
    //   2374: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   2377: astore 23
    //   2379: aload 23
    //   2381: ldc_w 1903
    //   2384: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2387: pop
    //   2388: aload 23
    //   2390: aload 22
    //   2392: invokevirtual 507	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2395: pop
    //   2396: iconst_4
    //   2397: ldc 49
    //   2399: aload 23
    //   2401: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2404: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2407: aload 10
    //   2409: ifnull +13 -> 2422
    //   2412: aload 10
    //   2414: aload_1
    //   2415: bipush 151
    //   2417: invokeinterface 1904 3 0
    //   2422: aload 9
    //   2424: athrow
    //   2425: ldc2_w 929
    //   2428: lstore 4
    //   2430: aload 9
    //   2432: astore 22
    //   2434: lload_2
    //   2435: lstore 12
    //   2437: iload 8
    //   2439: ifeq +1291 -> 3730
    //   2442: invokestatic 491	java/lang/System:currentTimeMillis	()J
    //   2445: lstore 14
    //   2447: aload 22
    //   2449: ifnull +1281 -> 3730
    //   2452: new 1181	com/tencent/oskplayer/datasource/DefaultHttpDataSource
    //   2455: dup
    //   2456: ldc 55
    //   2458: aconst_null
    //   2459: aconst_null
    //   2460: invokespecial 1184	com/tencent/oskplayer/datasource/DefaultHttpDataSource:<init>	(Ljava/lang/String;Lcom/tencent/oskplayer/util/Predicate;Lcom/tencent/oskplayer/util/Fixer;)V
    //   2463: astore 23
    //   2465: sipush 512
    //   2468: newarray byte
    //   2470: astore 9
    //   2472: lload 4
    //   2474: lstore_2
    //   2475: lload 4
    //   2477: ldc2_w 929
    //   2480: lcmp
    //   2481: ifne +64 -> 2545
    //   2484: aload 23
    //   2486: new 836	com/tencent/oskplayer/datasource/DataSpec
    //   2489: dup
    //   2490: aload 22
    //   2492: invokestatic 817	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   2495: lconst_0
    //   2496: lconst_0
    //   2497: ldc2_w 929
    //   2500: aconst_null
    //   2501: iconst_0
    //   2502: aconst_null
    //   2503: invokespecial 1196	com/tencent/oskplayer/datasource/DataSpec:<init>	(Landroid/net/Uri;JJJLjava/lang/String;ILjava/lang/String;)V
    //   2506: invokeinterface 535 2 0
    //   2511: pop2
    //   2512: aload 23
    //   2514: invokeinterface 1199 1 0
    //   2519: lstore_2
    //   2520: aload 23
    //   2522: invokeinterface 1210 1 0
    //   2527: goto +18 -> 2545
    //   2530: astore 9
    //   2532: goto +434 -> 2966
    //   2535: astore 9
    //   2537: goto +436 -> 2973
    //   2540: astore 9
    //   2542: goto +644 -> 3186
    //   2545: ldc_w 1918
    //   2548: astore 24
    //   2550: lload_2
    //   2551: l2f
    //   2552: ldc_w 1921
    //   2555: fmul
    //   2556: f2l
    //   2557: lstore 4
    //   2559: lload_2
    //   2560: lload 12
    //   2562: lsub
    //   2563: lstore_2
    //   2564: lload_2
    //   2565: lload 4
    //   2567: invokestatic 1924	java/lang/Math:max	(JJ)J
    //   2570: lstore 12
    //   2572: new 258	java/lang/StringBuilder
    //   2575: dup
    //   2576: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   2579: astore 24
    //   2581: aload 24
    //   2583: ldc_w 1926
    //   2586: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2589: pop
    //   2590: aload 24
    //   2592: lload 4
    //   2594: invokevirtual 268	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2597: pop
    //   2598: aload 24
    //   2600: ldc_w 945
    //   2603: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2606: pop
    //   2607: aload 24
    //   2609: aload_1
    //   2610: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2613: pop
    //   2614: aload 24
    //   2616: ldc_w 1928
    //   2619: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2622: pop
    //   2623: aload 24
    //   2625: lload_2
    //   2626: invokevirtual 268	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2629: pop
    //   2630: aload 24
    //   2632: ldc_w 1930
    //   2635: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2638: pop
    //   2639: aload 24
    //   2641: lload 12
    //   2643: invokevirtual 268	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2646: pop
    //   2647: iconst_4
    //   2648: ldc 49
    //   2650: aload 24
    //   2652: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2655: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2658: aload 23
    //   2660: new 836	com/tencent/oskplayer/datasource/DataSpec
    //   2663: dup
    //   2664: aload 22
    //   2666: invokestatic 817	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   2669: lload 12
    //   2671: lload 12
    //   2673: ldc2_w 929
    //   2676: aconst_null
    //   2677: iconst_0
    //   2678: aconst_null
    //   2679: invokespecial 1196	com/tencent/oskplayer/datasource/DataSpec:<init>	(Landroid/net/Uri;JJJLjava/lang/String;ILjava/lang/String;)V
    //   2682: invokeinterface 535 2 0
    //   2687: pop2
    //   2688: lconst_0
    //   2689: lstore_2
    //   2690: aload 23
    //   2692: aload 9
    //   2694: iconst_0
    //   2695: aload 9
    //   2697: arraylength
    //   2698: invokeinterface 1203 4 0
    //   2703: i2l
    //   2704: lstore 4
    //   2706: lload 4
    //   2708: ldc2_w 929
    //   2711: lcmp
    //   2712: ifeq +11 -> 2723
    //   2715: lload_2
    //   2716: lload 4
    //   2718: ladd
    //   2719: lstore_2
    //   2720: goto -30 -> 2690
    //   2723: invokestatic 491	java/lang/System:currentTimeMillis	()J
    //   2726: lstore 4
    //   2728: aload_0
    //   2729: astore 9
    //   2731: aload 9
    //   2733: getfield 164	com/tencent/oskplayer/proxy/VideoProxy:mCacheListenerMap	Ljava/util/Map;
    //   2736: aload 28
    //   2738: invokeinterface 585 2 0
    //   2743: ifeq +49 -> 2792
    //   2746: aload 9
    //   2748: getfield 164	com/tencent/oskplayer/proxy/VideoProxy:mCacheListenerMap	Ljava/util/Map;
    //   2751: aload 28
    //   2753: invokeinterface 701 2 0
    //   2758: checkcast 1932	com/tencent/oskplayer/cache/CacheListener
    //   2761: astore 22
    //   2763: aload 22
    //   2765: ifnull +27 -> 2792
    //   2768: aload 22
    //   2770: lload 4
    //   2772: lload 14
    //   2774: lsub
    //   2775: l2i
    //   2776: invokevirtual 1935	com/tencent/oskplayer/cache/CacheListener:setFileLastModified	(I)V
    //   2779: aload 9
    //   2781: getfield 164	com/tencent/oskplayer/proxy/VideoProxy:mCacheListenerMap	Ljava/util/Map;
    //   2784: aload 28
    //   2786: invokeinterface 1937 2 0
    //   2791: pop
    //   2792: new 258	java/lang/StringBuilder
    //   2795: dup
    //   2796: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   2799: astore 9
    //   2801: aload 9
    //   2803: ldc_w 1939
    //   2806: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2809: pop
    //   2810: aload 9
    //   2812: lload_2
    //   2813: invokevirtual 268	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2816: pop
    //   2817: aload 9
    //   2819: ldc_w 1897
    //   2822: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2825: pop
    //   2826: iconst_3
    //   2827: ldc 49
    //   2829: aload 9
    //   2831: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2834: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2837: aload 23
    //   2839: invokeinterface 1210 1 0
    //   2844: iconst_4
    //   2845: ldc 49
    //   2847: ldc_w 1941
    //   2850: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2853: goto +877 -> 3730
    //   2856: astore 9
    //   2858: new 258	java/lang/StringBuilder
    //   2861: dup
    //   2862: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   2865: astore 22
    //   2867: aload 22
    //   2869: ldc_w 1943
    //   2872: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2875: pop
    //   2876: aload 22
    //   2878: aload 9
    //   2880: invokevirtual 507	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2883: pop
    //   2884: iconst_4
    //   2885: ldc 49
    //   2887: aload 22
    //   2889: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2892: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2895: aload 10
    //   2897: ifnull +833 -> 3730
    //   2900: aload 10
    //   2902: aload_1
    //   2903: bipush 151
    //   2905: invokeinterface 1904 3 0
    //   2910: goto +820 -> 3730
    //   2913: astore 9
    //   2915: goto +15 -> 2930
    //   2918: astore 9
    //   2920: goto +15 -> 2935
    //   2923: astore 9
    //   2925: goto +18 -> 2943
    //   2928: astore 9
    //   2930: goto +679 -> 3609
    //   2933: astore 9
    //   2935: lload_2
    //   2936: lstore 4
    //   2938: goto +38 -> 2976
    //   2941: astore 9
    //   2943: lload_2
    //   2944: lstore 4
    //   2946: goto +243 -> 3189
    //   2949: astore 9
    //   2951: goto +15 -> 2966
    //   2954: astore 9
    //   2956: goto +17 -> 2973
    //   2959: astore 9
    //   2961: goto +225 -> 3186
    //   2964: astore 9
    //   2966: lconst_0
    //   2967: lstore_2
    //   2968: goto +641 -> 3609
    //   2971: astore 9
    //   2973: lconst_0
    //   2974: lstore 4
    //   2976: aload 10
    //   2978: astore 22
    //   2980: lload 4
    //   2982: lstore_2
    //   2983: new 258	java/lang/StringBuilder
    //   2986: dup
    //   2987: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   2990: astore 24
    //   2992: lload 4
    //   2994: lstore_2
    //   2995: aload 24
    //   2997: ldc_w 1945
    //   3000: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3003: pop
    //   3004: lload 4
    //   3006: lstore_2
    //   3007: aload 24
    //   3009: aload_1
    //   3010: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3013: pop
    //   3014: lload 4
    //   3016: lstore_2
    //   3017: aload 24
    //   3019: ldc_w 1918
    //   3022: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3025: pop
    //   3026: lload 4
    //   3028: lstore_2
    //   3029: aload 24
    //   3031: aload 9
    //   3033: invokestatic 395	com/tencent/oskplayer/util/PlayerUtils:getPrintableStackTrace	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   3036: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3039: pop
    //   3040: lload 4
    //   3042: lstore_2
    //   3043: iconst_5
    //   3044: ldc 49
    //   3046: aload 24
    //   3048: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3051: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   3054: aload 22
    //   3056: ifnull +16 -> 3072
    //   3059: lload 4
    //   3061: lstore_2
    //   3062: aload 22
    //   3064: aload_1
    //   3065: bipush 152
    //   3067: invokeinterface 1904 3 0
    //   3072: new 258	java/lang/StringBuilder
    //   3075: dup
    //   3076: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   3079: astore 9
    //   3081: aload 9
    //   3083: ldc_w 1939
    //   3086: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3089: pop
    //   3090: aload 9
    //   3092: lload 4
    //   3094: invokevirtual 268	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3097: pop
    //   3098: aload 9
    //   3100: ldc_w 1897
    //   3103: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3106: pop
    //   3107: iconst_3
    //   3108: ldc 49
    //   3110: aload 9
    //   3112: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3115: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   3118: aload 23
    //   3120: invokeinterface 1210 1 0
    //   3125: iconst_4
    //   3126: ldc 49
    //   3128: ldc_w 1941
    //   3131: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   3134: goto +596 -> 3730
    //   3137: astore 9
    //   3139: new 258	java/lang/StringBuilder
    //   3142: dup
    //   3143: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   3146: astore 23
    //   3148: aload 23
    //   3150: ldc_w 1943
    //   3153: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3156: pop
    //   3157: aload 23
    //   3159: aload 9
    //   3161: invokevirtual 507	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3164: pop
    //   3165: iconst_4
    //   3166: ldc 49
    //   3168: aload 23
    //   3170: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3173: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   3176: aload 22
    //   3178: ifnull +552 -> 3730
    //   3181: goto -281 -> 2900
    //   3184: astore 9
    //   3186: lconst_0
    //   3187: lstore 4
    //   3189: aload 10
    //   3191: astore 22
    //   3193: lload 4
    //   3195: lstore_2
    //   3196: aload 9
    //   3198: invokevirtual 1911	com/tencent/oskplayer/datasource/HttpDataSource$HttpDataSourceException:getCause	()Ljava/lang/Throwable;
    //   3201: instanceof 1913
    //   3204: ifeq +199 -> 3403
    //   3207: lload 4
    //   3209: lstore_2
    //   3210: aload 9
    //   3212: invokevirtual 1914	com/tencent/oskplayer/datasource/HttpDataSource$HttpDataSourceException:getMessage	()Ljava/lang/String;
    //   3215: ifnull +93 -> 3308
    //   3218: lload 4
    //   3220: lstore_2
    //   3221: aload 9
    //   3223: invokevirtual 1914	com/tencent/oskplayer/datasource/HttpDataSource$HttpDataSourceException:getMessage	()Ljava/lang/String;
    //   3226: invokevirtual 790	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   3229: ldc_w 792
    //   3232: invokevirtual 665	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3235: ifeq +73 -> 3308
    //   3238: lload 4
    //   3240: lstore_2
    //   3241: new 258	java/lang/StringBuilder
    //   3244: dup
    //   3245: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   3248: astore 9
    //   3250: lload 4
    //   3252: lstore_2
    //   3253: aload 9
    //   3255: ldc_w 1947
    //   3258: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3261: pop
    //   3262: lload 4
    //   3264: lstore_2
    //   3265: aload 9
    //   3267: lload 4
    //   3269: invokevirtual 268	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3272: pop
    //   3273: lload 4
    //   3275: lstore_2
    //   3276: iconst_4
    //   3277: ldc 49
    //   3279: aload 9
    //   3281: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3284: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   3287: aload 22
    //   3289: ifnull +206 -> 3495
    //   3292: lload 4
    //   3294: lstore_2
    //   3295: aload 22
    //   3297: aload_1
    //   3298: bipush 155
    //   3300: invokeinterface 1904 3 0
    //   3305: goto +190 -> 3495
    //   3308: lload 4
    //   3310: lstore_2
    //   3311: new 258	java/lang/StringBuilder
    //   3314: dup
    //   3315: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   3318: astore 24
    //   3320: lload 4
    //   3322: lstore_2
    //   3323: aload 24
    //   3325: ldc_w 1945
    //   3328: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3331: pop
    //   3332: lload 4
    //   3334: lstore_2
    //   3335: aload 24
    //   3337: aload_1
    //   3338: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3341: pop
    //   3342: lload 4
    //   3344: lstore_2
    //   3345: aload 24
    //   3347: ldc_w 1918
    //   3350: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3353: pop
    //   3354: lload 4
    //   3356: lstore_2
    //   3357: aload 24
    //   3359: aload 9
    //   3361: invokestatic 395	com/tencent/oskplayer/util/PlayerUtils:getPrintableStackTrace	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   3364: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3367: pop
    //   3368: lload 4
    //   3370: lstore_2
    //   3371: iconst_5
    //   3372: ldc 49
    //   3374: aload 24
    //   3376: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3379: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   3382: aload 22
    //   3384: ifnull +111 -> 3495
    //   3387: lload 4
    //   3389: lstore_2
    //   3390: aload 22
    //   3392: aload_1
    //   3393: bipush 154
    //   3395: invokeinterface 1904 3 0
    //   3400: goto +95 -> 3495
    //   3403: lload 4
    //   3405: lstore_2
    //   3406: new 258	java/lang/StringBuilder
    //   3409: dup
    //   3410: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   3413: astore 24
    //   3415: lload 4
    //   3417: lstore_2
    //   3418: aload 24
    //   3420: ldc_w 1945
    //   3423: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3426: pop
    //   3427: lload 4
    //   3429: lstore_2
    //   3430: aload 24
    //   3432: aload_1
    //   3433: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3436: pop
    //   3437: lload 4
    //   3439: lstore_2
    //   3440: aload 24
    //   3442: ldc_w 1918
    //   3445: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3448: pop
    //   3449: lload 4
    //   3451: lstore_2
    //   3452: aload 24
    //   3454: aload 9
    //   3456: invokestatic 395	com/tencent/oskplayer/util/PlayerUtils:getPrintableStackTrace	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   3459: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3462: pop
    //   3463: lload 4
    //   3465: lstore_2
    //   3466: iconst_5
    //   3467: ldc 49
    //   3469: aload 24
    //   3471: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3474: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   3477: aload 22
    //   3479: ifnull +16 -> 3495
    //   3482: lload 4
    //   3484: lstore_2
    //   3485: aload 22
    //   3487: aload_1
    //   3488: bipush 153
    //   3490: invokeinterface 1904 3 0
    //   3495: new 258	java/lang/StringBuilder
    //   3498: dup
    //   3499: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   3502: astore 9
    //   3504: aload 9
    //   3506: ldc_w 1939
    //   3509: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3512: pop
    //   3513: aload 9
    //   3515: lload 4
    //   3517: invokevirtual 268	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3520: pop
    //   3521: aload 9
    //   3523: ldc_w 1897
    //   3526: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3529: pop
    //   3530: iconst_3
    //   3531: ldc 49
    //   3533: aload 9
    //   3535: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3538: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   3541: aload 23
    //   3543: invokeinterface 1210 1 0
    //   3548: iconst_4
    //   3549: ldc 49
    //   3551: ldc_w 1941
    //   3554: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   3557: goto +173 -> 3730
    //   3560: astore 9
    //   3562: new 258	java/lang/StringBuilder
    //   3565: dup
    //   3566: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   3569: astore 23
    //   3571: aload 23
    //   3573: ldc_w 1943
    //   3576: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3579: pop
    //   3580: aload 23
    //   3582: aload 9
    //   3584: invokevirtual 507	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3587: pop
    //   3588: iconst_4
    //   3589: ldc 49
    //   3591: aload 23
    //   3593: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3596: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   3599: aload 22
    //   3601: ifnull +129 -> 3730
    //   3604: goto -704 -> 2900
    //   3607: astore 9
    //   3609: new 258	java/lang/StringBuilder
    //   3612: dup
    //   3613: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   3616: astore 22
    //   3618: aload 22
    //   3620: ldc_w 1939
    //   3623: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3626: pop
    //   3627: aload 22
    //   3629: lload_2
    //   3630: invokevirtual 268	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3633: pop
    //   3634: aload 22
    //   3636: ldc_w 1897
    //   3639: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3642: pop
    //   3643: iconst_3
    //   3644: ldc 49
    //   3646: aload 22
    //   3648: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3651: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   3654: aload 23
    //   3656: invokeinterface 1210 1 0
    //   3661: iconst_4
    //   3662: ldc 49
    //   3664: ldc_w 1941
    //   3667: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   3670: goto +57 -> 3727
    //   3673: astore 22
    //   3675: new 258	java/lang/StringBuilder
    //   3678: dup
    //   3679: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   3682: astore 23
    //   3684: aload 23
    //   3686: ldc_w 1943
    //   3689: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3692: pop
    //   3693: aload 23
    //   3695: aload 22
    //   3697: invokevirtual 507	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3700: pop
    //   3701: iconst_4
    //   3702: ldc 49
    //   3704: aload 23
    //   3706: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3709: invokestatic 277	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   3712: aload 10
    //   3714: ifnull +13 -> 3727
    //   3717: aload 10
    //   3719: aload_1
    //   3720: bipush 151
    //   3722: invokeinterface 1904 3 0
    //   3727: aload 9
    //   3729: athrow
    //   3730: aload_0
    //   3731: getfield 1294	com/tencent/oskplayer/proxy/VideoProxy:tcDataSourceUtils	Lcom/tencent/oskplayer/proxy/ITcDataSourceUtils;
    //   3734: astore 9
    //   3736: aload 9
    //   3738: ifnull +12 -> 3750
    //   3741: aload 9
    //   3743: aload 26
    //   3745: invokeinterface 1950 2 0
    //   3750: aload 10
    //   3752: ifnull +11 -> 3763
    //   3755: aload 10
    //   3757: aload_1
    //   3758: invokeinterface 1953 2 0
    //   3763: iconst_1
    //   3764: ireturn
    //   3765: iconst_0
    //   3766: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3767	0	this	VideoProxy
    //   0	3767	1	paramString	String
    //   0	3767	2	paramLong1	long
    //   0	3767	4	paramLong2	long
    //   0	3767	6	paramInt	int
    //   0	3767	7	paramBoolean1	boolean
    //   0	3767	8	paramBoolean2	boolean
    //   0	3767	9	paramHttpHeader	HttpHeader
    //   0	3767	10	paramDownloadListener	DownloadListener
    //   205	113	11	i	int
    //   255	2417	12	l1	long
    //   180	2593	14	l2	long
    //   258	1984	16	l3	long
    //   239	148	18	l4	long
    //   249	13	20	l5	long
    //   21	817	22	localObject1	Object
    //   848	23	22	localException1	Exception
    //   889	505	22	localObject2	Object
    //   1398	23	22	localException2	Exception
    //   1446	727	22	localObject3	Object
    //   2177	23	22	localException3	Exception
    //   2225	133	22	localObject4	Object
    //   2368	23	22	localException4	Exception
    //   2432	1215	22	localObject5	Object
    //   3673	23	22	localException5	Exception
    //   231	321	23	localHttpHeader	HttpHeader
    //   565	1	23	localIOException1	IOException
    //   578	1	23	localHttpDataSourceException1	com.tencent.oskplayer.datasource.HttpDataSource.HttpDataSourceException
    //   711	1	23	localIOException2	IOException
    //   721	1	23	localHttpDataSourceException2	com.tencent.oskplayer.datasource.HttpDataSource.HttpDataSourceException
    //   857	23	23	localStringBuilder1	StringBuilder
    //   925	1	23	localIOException3	IOException
    //   930	1	23	localHttpDataSourceException3	com.tencent.oskplayer.datasource.HttpDataSource.HttpDataSourceException
    //   948	149	23	localIOException4	IOException
    //   1145	285	23	localStringBuilder2	StringBuilder
    //   1477	72	23	localHttpDataSourceException4	com.tencent.oskplayer.datasource.HttpDataSource.HttpDataSourceException
    //   1583	2122	23	localObject6	Object
    //   143	3327	24	localObject7	Object
    //   286	1942	25	localObject8	Object
    //   100	3644	26	str1	String
    //   136	2162	27	localDefaultHttpDataSource	com.tencent.oskplayer.datasource.DefaultHttpDataSource
    //   76	2709	28	str2	String
    //   985	1032	29	localStringBuilder3	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   477	485	488	finally
    //   477	485	493	java/io/IOException
    //   477	485	498	com/tencent/oskplayer/datasource/HttpDataSource$HttpDataSourceException
    //   260	270	503	finally
    //   279	288	503	finally
    //   297	306	503	finally
    //   315	323	503	finally
    //   332	341	503	finally
    //   350	357	503	finally
    //   366	375	503	finally
    //   384	392	503	finally
    //   401	410	503	finally
    //   419	427	503	finally
    //   436	445	503	finally
    //   454	461	503	finally
    //   470	477	503	finally
    //   260	270	514	java/io/IOException
    //   279	288	514	java/io/IOException
    //   297	306	514	java/io/IOException
    //   315	323	514	java/io/IOException
    //   332	341	514	java/io/IOException
    //   350	357	514	java/io/IOException
    //   366	375	514	java/io/IOException
    //   384	392	514	java/io/IOException
    //   401	410	514	java/io/IOException
    //   419	427	514	java/io/IOException
    //   436	445	514	java/io/IOException
    //   454	461	514	java/io/IOException
    //   470	477	514	java/io/IOException
    //   260	270	537	com/tencent/oskplayer/datasource/HttpDataSource$HttpDataSourceException
    //   279	288	537	com/tencent/oskplayer/datasource/HttpDataSource$HttpDataSourceException
    //   297	306	537	com/tencent/oskplayer/datasource/HttpDataSource$HttpDataSourceException
    //   315	323	537	com/tencent/oskplayer/datasource/HttpDataSource$HttpDataSourceException
    //   332	341	537	com/tencent/oskplayer/datasource/HttpDataSource$HttpDataSourceException
    //   350	357	537	com/tencent/oskplayer/datasource/HttpDataSource$HttpDataSourceException
    //   366	375	537	com/tencent/oskplayer/datasource/HttpDataSource$HttpDataSourceException
    //   384	392	537	com/tencent/oskplayer/datasource/HttpDataSource$HttpDataSourceException
    //   401	410	537	com/tencent/oskplayer/datasource/HttpDataSource$HttpDataSourceException
    //   419	427	537	com/tencent/oskplayer/datasource/HttpDataSource$HttpDataSourceException
    //   436	445	537	com/tencent/oskplayer/datasource/HttpDataSource$HttpDataSourceException
    //   454	461	537	com/tencent/oskplayer/datasource/HttpDataSource$HttpDataSourceException
    //   470	477	537	com/tencent/oskplayer/datasource/HttpDataSource$HttpDataSourceException
    //   191	229	560	finally
    //   191	229	565	java/io/IOException
    //   191	229	578	com/tencent/oskplayer/datasource/HttpDataSource$HttpDataSourceException
    //   662	677	701	finally
    //   662	677	711	java/io/IOException
    //   662	677	721	com/tencent/oskplayer/datasource/HttpDataSource$HttpDataSourceException
    //   731	845	848	java/lang/Exception
    //   600	652	920	finally
    //   600	652	925	java/io/IOException
    //   600	652	930	com/tencent/oskplayer/datasource/HttpDataSource$HttpDataSourceException
    //   145	182	935	finally
    //   145	182	948	java/io/IOException
    //   1271	1384	1398	java/lang/Exception
    //   145	182	1477	com/tencent/oskplayer/datasource/HttpDataSource$HttpDataSourceException
    //   2050	2163	2177	java/lang/Exception
    //   978	987	2239	finally
    //   998	1007	2239	finally
    //   1018	1025	2239	finally
    //   1036	1045	2239	finally
    //   1056	1063	2239	finally
    //   1074	1083	2239	finally
    //   1094	1105	2239	finally
    //   1116	1127	2239	finally
    //   1138	1147	2239	finally
    //   1158	1167	2239	finally
    //   1178	1185	2239	finally
    //   1196	1205	2239	finally
    //   1216	1223	2239	finally
    //   1234	1245	2239	finally
    //   1261	1271	2239	finally
    //   1507	1518	2239	finally
    //   1529	1537	2239	finally
    //   1548	1565	2239	finally
    //   1576	1585	2239	finally
    //   1596	1605	2239	finally
    //   1616	1624	2239	finally
    //   1635	1646	2239	finally
    //   1662	1672	2239	finally
    //   1686	1695	2239	finally
    //   1706	1715	2239	finally
    //   1726	1733	2239	finally
    //   1744	1753	2239	finally
    //   1764	1771	2239	finally
    //   1782	1791	2239	finally
    //   1802	1813	2239	finally
    //   1824	1835	2239	finally
    //   1851	1861	2239	finally
    //   1875	1884	2239	finally
    //   1895	1904	2239	finally
    //   1915	1922	2239	finally
    //   1933	1942	2239	finally
    //   1953	1960	2239	finally
    //   1971	1980	2239	finally
    //   1991	2002	2239	finally
    //   2013	2024	2239	finally
    //   2040	2050	2239	finally
    //   2252	2365	2368	java/lang/Exception
    //   2484	2527	2530	finally
    //   2484	2527	2535	java/io/IOException
    //   2484	2527	2540	com/tencent/oskplayer/datasource/HttpDataSource$HttpDataSourceException
    //   2792	2853	2856	java/lang/Exception
    //   2731	2763	2913	finally
    //   2768	2792	2913	finally
    //   2731	2763	2918	java/io/IOException
    //   2768	2792	2918	java/io/IOException
    //   2731	2763	2923	com/tencent/oskplayer/datasource/HttpDataSource$HttpDataSourceException
    //   2768	2792	2923	com/tencent/oskplayer/datasource/HttpDataSource$HttpDataSourceException
    //   2690	2706	2928	finally
    //   2723	2728	2928	finally
    //   2690	2706	2933	java/io/IOException
    //   2723	2728	2933	java/io/IOException
    //   2690	2706	2941	com/tencent/oskplayer/datasource/HttpDataSource$HttpDataSourceException
    //   2723	2728	2941	com/tencent/oskplayer/datasource/HttpDataSource$HttpDataSourceException
    //   2581	2688	2949	finally
    //   2581	2688	2954	java/io/IOException
    //   2581	2688	2959	com/tencent/oskplayer/datasource/HttpDataSource$HttpDataSourceException
    //   2564	2581	2964	finally
    //   2564	2581	2971	java/io/IOException
    //   3072	3134	3137	java/lang/Exception
    //   2564	2581	3184	com/tencent/oskplayer/datasource/HttpDataSource$HttpDataSourceException
    //   3495	3557	3560	java/lang/Exception
    //   2983	2992	3607	finally
    //   2995	3004	3607	finally
    //   3007	3014	3607	finally
    //   3017	3026	3607	finally
    //   3029	3040	3607	finally
    //   3043	3054	3607	finally
    //   3062	3072	3607	finally
    //   3196	3207	3607	finally
    //   3210	3218	3607	finally
    //   3221	3238	3607	finally
    //   3241	3250	3607	finally
    //   3253	3262	3607	finally
    //   3265	3273	3607	finally
    //   3276	3287	3607	finally
    //   3295	3305	3607	finally
    //   3311	3320	3607	finally
    //   3323	3332	3607	finally
    //   3335	3342	3607	finally
    //   3345	3354	3607	finally
    //   3357	3368	3607	finally
    //   3371	3382	3607	finally
    //   3390	3400	3607	finally
    //   3406	3415	3607	finally
    //   3418	3427	3607	finally
    //   3430	3437	3607	finally
    //   3440	3449	3607	finally
    //   3452	3463	3607	finally
    //   3466	3477	3607	finally
    //   3485	3495	3607	finally
    //   3609	3670	3673	java/lang/Exception
  }
  
  /* Error */
  public int probeContentFlag(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: iconst_1
    //   3: iconst_1
    //   4: ldc 81
    //   6: ldc 73
    //   8: bipush 10
    //   10: aconst_null
    //   11: invokevirtual 654	com/tencent/oskplayer/proxy/VideoProxy:getUrl	(Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;ILcom/tencent/oskplayer/datasource/HttpHeader;)Ljava/lang/String;
    //   14: astore_2
    //   15: aload_2
    //   16: invokestatic 1870	com/tencent/oskplayer/util/PlayerUtils:getVideoUuidFromVideoUrl	(Ljava/lang/String;)Ljava/lang/String;
    //   19: astore_1
    //   20: new 1181	com/tencent/oskplayer/datasource/DefaultHttpDataSource
    //   23: dup
    //   24: ldc 55
    //   26: aconst_null
    //   27: aconst_null
    //   28: invokespecial 1184	com/tencent/oskplayer/datasource/DefaultHttpDataSource:<init>	(Ljava/lang/String;Lcom/tencent/oskplayer/util/Predicate;Lcom/tencent/oskplayer/util/Fixer;)V
    //   31: astore_3
    //   32: new 361	java/util/concurrent/CountDownLatch
    //   35: dup
    //   36: iconst_1
    //   37: invokespecial 362	java/util/concurrent/CountDownLatch:<init>	(I)V
    //   40: astore 4
    //   42: new 1956	com/tencent/oskplayer/proxy/VideoProxy$ProbeContentRequestListener
    //   45: dup
    //   46: aload_0
    //   47: aload_1
    //   48: aload 4
    //   50: invokespecial 1959	com/tencent/oskplayer/proxy/VideoProxy$ProbeContentRequestListener:<init>	(Lcom/tencent/oskplayer/proxy/VideoProxy;Ljava/lang/String;Ljava/util/concurrent/CountDownLatch;)V
    //   53: astore_1
    //   54: aload_0
    //   55: getfield 314	com/tencent/oskplayer/proxy/VideoProxy:videoRequestManager	Lcom/tencent/oskplayer/proxy/VideoRequestManager;
    //   58: aload_1
    //   59: invokevirtual 1963	com/tencent/oskplayer/proxy/VideoRequestManager:addRequestListener	(Lcom/tencent/oskplayer/proxy/VideoRequestManager$RequestListener;)V
    //   62: aload_3
    //   63: new 836	com/tencent/oskplayer/datasource/DataSpec
    //   66: dup
    //   67: aload_2
    //   68: invokestatic 817	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   71: lconst_0
    //   72: lconst_0
    //   73: ldc2_w 929
    //   76: aconst_null
    //   77: iconst_0
    //   78: aconst_null
    //   79: invokespecial 1196	com/tencent/oskplayer/datasource/DataSpec:<init>	(Landroid/net/Uri;JJJLjava/lang/String;ILjava/lang/String;)V
    //   82: ldc_w 1965
    //   85: invokevirtual 1968	com/tencent/oskplayer/datasource/DefaultHttpDataSource:open	(Lcom/tencent/oskplayer/datasource/DataSpec;Ljava/lang/String;)J
    //   88: pop2
    //   89: aload_3
    //   90: invokevirtual 1969	com/tencent/oskplayer/datasource/DefaultHttpDataSource:close	()V
    //   93: aload 4
    //   95: ldc2_w 1970
    //   98: getstatic 1974	java/util/concurrent/TimeUnit:SECONDS	Ljava/util/concurrent/TimeUnit;
    //   101: invokevirtual 463	java/util/concurrent/CountDownLatch:await	(JLjava/util/concurrent/TimeUnit;)Z
    //   104: pop
    //   105: goto +12 -> 117
    //   108: astore_2
    //   109: goto +24 -> 133
    //   112: astore_2
    //   113: aload_2
    //   114: invokevirtual 1651	java/lang/Exception:printStackTrace	()V
    //   117: aload_0
    //   118: getfield 314	com/tencent/oskplayer/proxy/VideoProxy:videoRequestManager	Lcom/tencent/oskplayer/proxy/VideoRequestManager;
    //   121: aload_1
    //   122: invokevirtual 1977	com/tencent/oskplayer/proxy/VideoRequestManager:removeRequestListener	(Lcom/tencent/oskplayer/proxy/VideoRequestManager$RequestListener;)V
    //   125: aload_1
    //   126: checkcast 1956	com/tencent/oskplayer/proxy/VideoProxy$ProbeContentRequestListener
    //   129: getfield 1980	com/tencent/oskplayer/proxy/VideoProxy$ProbeContentRequestListener:mFlags	I
    //   132: ireturn
    //   133: aload_0
    //   134: getfield 314	com/tencent/oskplayer/proxy/VideoProxy:videoRequestManager	Lcom/tencent/oskplayer/proxy/VideoRequestManager;
    //   137: aload_1
    //   138: invokevirtual 1977	com/tencent/oskplayer/proxy/VideoRequestManager:removeRequestListener	(Lcom/tencent/oskplayer/proxy/VideoRequestManager$RequestListener;)V
    //   141: aload_2
    //   142: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	143	0	this	VideoProxy
    //   0	143	1	paramString	String
    //   14	54	2	str	String
    //   108	1	2	localObject	Object
    //   112	30	2	localException	Exception
    //   31	59	3	localDefaultHttpDataSource	com.tencent.oskplayer.datasource.DefaultHttpDataSource
    //   40	54	4	localCountDownLatch	CountDownLatch
    // Exception table:
    //   from	to	target	type
    //   62	105	108	finally
    //   113	117	108	finally
    //   62	105	112	java/lang/Exception
  }
  
  public void removeCacheReadListener(String paramString)
  {
    try
    {
      boolean bool = TextUtils.isEmpty(paramString);
      if (bool) {
        return;
      }
      paramString = PlayerUtils.parseVideoKey(paramString);
      this.cacheReadListenerMap.remove(paramString);
      return;
    }
    finally {}
  }
  
  public void removeHttpErrorListener(String paramString)
  {
    try
    {
      boolean bool = TextUtils.isEmpty(paramString);
      if (bool) {
        return;
      }
      paramString = PlayerUtils.parseVideoKey(paramString);
      this.httpUrlErrorListenerMap.remove(paramString);
      return;
    }
    finally {}
  }
  
  public void removeHttpRetryLogic(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramString = PlayerUtils.parseVideoKey(paramString);
    this.httpRetryLogicMap.remove(paramString);
  }
  
  public void removeUuidErrorListener(String paramString)
  {
    try
    {
      boolean bool = TextUtils.isEmpty(paramString);
      if (bool) {
        return;
      }
      this.uuidErrorListenerMap.remove(paramString);
      return;
    }
    finally {}
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
    }
    catch (IOException localIOException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("error when close proxy server ");
      localStringBuilder.append(localIOException.toString());
      PlayerUtils.log(6, "VideoProxy", localStringBuilder.toString());
    }
    this.executorService.shutdownNow();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.oskplayer.proxy.VideoProxy
 * JD-Core Version:    0.7.0.1
 */