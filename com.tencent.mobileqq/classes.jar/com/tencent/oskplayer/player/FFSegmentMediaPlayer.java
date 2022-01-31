package com.tencent.oskplayer.player;

import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.google.android.exoplayer2.SeekParameters;
import com.tencent.oskplayer.PlayerConfig;
import com.tencent.oskplayer.model.SegmentVideoInfo.SegmentInfo;
import com.tencent.oskplayer.model.SegmentVideoInfo.StreamInfo;
import com.tencent.oskplayer.proxy.VideoManager;
import com.tencent.oskplayer.util.PlayerUtils;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import tv.danmaku.ijk.media.player.AbstractMediaPlayer;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import tv.danmaku.ijk.media.player.MediaInfo;
import tv.danmaku.ijk.media.player.misc.ITrackInfo;

public class FFSegmentMediaPlayer
  extends AbstractMediaPlayer
  implements ISegmentMediaPlayer
{
  private static final String LOG_TAG = "FFSegmentMediaPlayer";
  private static final int STATE_ERROR = -1;
  private static final int STATE_IDLE = 0;
  private static final int STATE_PAUSED = 4;
  private static final int STATE_PLAYING = 3;
  private static final int STATE_PREPARED = 2;
  private static final int STATE_PREPARING = 1;
  private static Object sIsSupported = null;
  private boolean isLooping;
  private int mCurrentState = 0;
  private final FFSegmentMediaPlayer.AbstractMediaPlayerListenerHolder mInternalListenerAdapter;
  private IjkMediaPlayer mInternalMediaPlayer;
  private boolean mLoopingPlaySeek;
  private String mPath = null;
  private File mPlayListFile;
  private List<String> mProxyUrls;
  private SeekParameters mSeekParameters;
  private List<String> mSourceUrls;
  private int mTargetState = 0;
  private boolean preventBufferingEvent = false;
  
  public FFSegmentMediaPlayer()
  {
    if (!isSupported()) {
      throw new UnsupportedOperationException("FFSegmentMediaPlayer is not available to use");
    }
    this.mInternalListenerAdapter = new FFSegmentMediaPlayer.AbstractMediaPlayerListenerHolder(this, this);
    initPlayer();
  }
  
  private void attachInternalListeners()
  {
    this.mInternalMediaPlayer.setOnPreparedListener(this.mInternalListenerAdapter);
    this.mInternalMediaPlayer.setOnBufferingUpdateListener(this.mInternalListenerAdapter);
    this.mInternalMediaPlayer.setOnCompletionListener(this.mInternalListenerAdapter);
    this.mInternalMediaPlayer.setOnSeekCompleteListener(this.mInternalListenerAdapter);
    this.mInternalMediaPlayer.setOnVideoSizeChangedListener(this.mInternalListenerAdapter);
    this.mInternalMediaPlayer.setOnErrorListener(this.mInternalListenerAdapter);
    this.mInternalMediaPlayer.setOnInfoListener(this.mInternalListenerAdapter);
  }
  
  public static void disable()
  {
    try
    {
      sIsSupported = Boolean.valueOf(false);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  private String generatePlayListFile(SegmentVideoInfo.StreamInfo paramStreamInfo, List<String> paramList)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 187	com/tencent/oskplayer/model/SegmentVideoInfo$StreamInfo:segmentInfos	Ljava/util/ArrayList;
    //   4: invokevirtual 193	java/util/ArrayList:size	()I
    //   7: iconst_1
    //   8: if_icmpne +14 -> 22
    //   11: aload_2
    //   12: iconst_0
    //   13: invokeinterface 199 2 0
    //   18: checkcast 201	java/lang/String
    //   21: areturn
    //   22: aload_0
    //   23: getfield 203	com/tencent/oskplayer/player/FFSegmentMediaPlayer:mPlayListFile	Ljava/io/File;
    //   26: ifnonnull +302 -> 328
    //   29: invokestatic 209	com/tencent/oskplayer/PlayerConfig:g	()Lcom/tencent/oskplayer/PlayerConfig;
    //   32: invokevirtual 213	com/tencent/oskplayer/PlayerConfig:getTempDir	()Ljava/lang/String;
    //   35: astore 4
    //   37: aload 4
    //   39: ifnonnull +14 -> 53
    //   42: bipush 6
    //   44: ldc 10
    //   46: ldc 215
    //   48: invokestatic 221	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   51: aconst_null
    //   52: areturn
    //   53: new 223	java/io/File
    //   56: dup
    //   57: aload 4
    //   59: invokespecial 224	java/io/File:<init>	(Ljava/lang/String;)V
    //   62: astore 5
    //   64: aload_0
    //   65: new 223	java/io/File
    //   68: dup
    //   69: new 226	java/lang/StringBuilder
    //   72: dup
    //   73: invokespecial 227	java/lang/StringBuilder:<init>	()V
    //   76: aload 4
    //   78: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: getstatic 234	java/io/File:separator	Ljava/lang/String;
    //   84: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: invokestatic 240	java/lang/System:currentTimeMillis	()J
    //   90: invokevirtual 243	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   93: ldc 245
    //   95: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: invokevirtual 248	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: invokespecial 224	java/io/File:<init>	(Ljava/lang/String;)V
    //   104: putfield 203	com/tencent/oskplayer/player/FFSegmentMediaPlayer:mPlayListFile	Ljava/io/File;
    //   107: aload 5
    //   109: invokevirtual 251	java/io/File:exists	()Z
    //   112: ifne +9 -> 121
    //   115: aload 5
    //   117: invokevirtual 254	java/io/File:mkdirs	()Z
    //   120: pop
    //   121: iconst_4
    //   122: ldc 10
    //   124: new 226	java/lang/StringBuilder
    //   127: dup
    //   128: invokespecial 227	java/lang/StringBuilder:<init>	()V
    //   131: ldc_w 256
    //   134: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: aload_0
    //   138: getfield 203	com/tencent/oskplayer/player/FFSegmentMediaPlayer:mPlayListFile	Ljava/io/File;
    //   141: invokevirtual 259	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   144: invokevirtual 248	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: invokestatic 221	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   150: new 261	java/io/FileOutputStream
    //   153: dup
    //   154: aload_0
    //   155: getfield 203	com/tencent/oskplayer/player/FFSegmentMediaPlayer:mPlayListFile	Ljava/io/File;
    //   158: invokespecial 264	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   161: astore 5
    //   163: aload 5
    //   165: astore 4
    //   167: new 226	java/lang/StringBuilder
    //   170: dup
    //   171: invokespecial 227	java/lang/StringBuilder:<init>	()V
    //   174: astore 6
    //   176: aload 5
    //   178: astore 4
    //   180: aload 6
    //   182: ldc_w 266
    //   185: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: pop
    //   189: aload 5
    //   191: astore 4
    //   193: aload_1
    //   194: getfield 187	com/tencent/oskplayer/model/SegmentVideoInfo$StreamInfo:segmentInfos	Ljava/util/ArrayList;
    //   197: invokevirtual 270	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   200: astore_1
    //   201: iconst_0
    //   202: istore_3
    //   203: aload 5
    //   205: astore 4
    //   207: aload_1
    //   208: invokeinterface 275 1 0
    //   213: ifeq +88 -> 301
    //   216: aload 5
    //   218: astore 4
    //   220: aload_1
    //   221: invokeinterface 279 1 0
    //   226: checkcast 281	com/tencent/oskplayer/model/SegmentVideoInfo$SegmentInfo
    //   229: astore 7
    //   231: aload 5
    //   233: astore 4
    //   235: aload 6
    //   237: ldc_w 283
    //   240: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: aload_2
    //   244: iload_3
    //   245: invokeinterface 199 2 0
    //   250: checkcast 201	java/lang/String
    //   253: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: ldc_w 285
    //   259: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: pop
    //   263: aload 5
    //   265: astore 4
    //   267: aload 6
    //   269: ldc_w 287
    //   272: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: aload 7
    //   277: getfield 290	com/tencent/oskplayer/model/SegmentVideoInfo$SegmentInfo:duration	I
    //   280: sipush 1000
    //   283: idiv
    //   284: invokevirtual 293	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   287: ldc_w 285
    //   290: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: pop
    //   294: iload_3
    //   295: iconst_1
    //   296: iadd
    //   297: istore_3
    //   298: goto -95 -> 203
    //   301: aload 5
    //   303: astore 4
    //   305: aload 5
    //   307: aload 6
    //   309: invokevirtual 248	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   312: invokevirtual 297	java/lang/String:getBytes	()[B
    //   315: invokevirtual 303	java/io/OutputStream:write	([B)V
    //   318: aload 5
    //   320: ifnull +8 -> 328
    //   323: aload 5
    //   325: invokevirtual 306	java/io/OutputStream:close	()V
    //   328: aload_0
    //   329: getfield 203	com/tencent/oskplayer/player/FFSegmentMediaPlayer:mPlayListFile	Ljava/io/File;
    //   332: invokevirtual 309	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   335: areturn
    //   336: astore_1
    //   337: bipush 6
    //   339: ldc 10
    //   341: new 226	java/lang/StringBuilder
    //   344: dup
    //   345: invokespecial 227	java/lang/StringBuilder:<init>	()V
    //   348: ldc_w 311
    //   351: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   354: aload_1
    //   355: invokevirtual 314	java/io/IOException:getMessage	()Ljava/lang/String;
    //   358: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   361: invokevirtual 248	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   364: invokestatic 221	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   367: aconst_null
    //   368: areturn
    //   369: astore_2
    //   370: aconst_null
    //   371: astore_1
    //   372: bipush 6
    //   374: ldc 10
    //   376: new 226	java/lang/StringBuilder
    //   379: dup
    //   380: invokespecial 227	java/lang/StringBuilder:<init>	()V
    //   383: ldc_w 316
    //   386: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: aload_2
    //   390: invokevirtual 317	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   393: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   396: invokevirtual 248	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   399: invokestatic 221	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   402: aload_1
    //   403: ifnull +7 -> 410
    //   406: aload_1
    //   407: invokevirtual 306	java/io/OutputStream:close	()V
    //   410: aconst_null
    //   411: areturn
    //   412: astore_1
    //   413: bipush 6
    //   415: ldc 10
    //   417: new 226	java/lang/StringBuilder
    //   420: dup
    //   421: invokespecial 227	java/lang/StringBuilder:<init>	()V
    //   424: ldc_w 311
    //   427: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   430: aload_1
    //   431: invokevirtual 314	java/io/IOException:getMessage	()Ljava/lang/String;
    //   434: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   437: invokevirtual 248	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   440: invokestatic 221	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   443: aconst_null
    //   444: areturn
    //   445: astore_1
    //   446: aconst_null
    //   447: astore 5
    //   449: aload 5
    //   451: astore 4
    //   453: bipush 6
    //   455: ldc 10
    //   457: new 226	java/lang/StringBuilder
    //   460: dup
    //   461: invokespecial 227	java/lang/StringBuilder:<init>	()V
    //   464: ldc_w 319
    //   467: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   470: aload_1
    //   471: invokevirtual 314	java/io/IOException:getMessage	()Ljava/lang/String;
    //   474: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   477: invokevirtual 248	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   480: invokestatic 221	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   483: aload 5
    //   485: ifnull +8 -> 493
    //   488: aload 5
    //   490: invokevirtual 306	java/io/OutputStream:close	()V
    //   493: aconst_null
    //   494: areturn
    //   495: astore_1
    //   496: bipush 6
    //   498: ldc 10
    //   500: new 226	java/lang/StringBuilder
    //   503: dup
    //   504: invokespecial 227	java/lang/StringBuilder:<init>	()V
    //   507: ldc_w 311
    //   510: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   513: aload_1
    //   514: invokevirtual 314	java/io/IOException:getMessage	()Ljava/lang/String;
    //   517: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   520: invokevirtual 248	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   523: invokestatic 221	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   526: aconst_null
    //   527: areturn
    //   528: astore_1
    //   529: aconst_null
    //   530: astore 4
    //   532: aload 4
    //   534: ifnull +8 -> 542
    //   537: aload 4
    //   539: invokevirtual 306	java/io/OutputStream:close	()V
    //   542: aload_1
    //   543: athrow
    //   544: astore_1
    //   545: bipush 6
    //   547: ldc 10
    //   549: new 226	java/lang/StringBuilder
    //   552: dup
    //   553: invokespecial 227	java/lang/StringBuilder:<init>	()V
    //   556: ldc_w 311
    //   559: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   562: aload_1
    //   563: invokevirtual 314	java/io/IOException:getMessage	()Ljava/lang/String;
    //   566: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   569: invokevirtual 248	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   572: invokestatic 221	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   575: aconst_null
    //   576: areturn
    //   577: astore_1
    //   578: goto -46 -> 532
    //   581: astore_2
    //   582: aload_1
    //   583: astore 4
    //   585: aload_2
    //   586: astore_1
    //   587: goto -55 -> 532
    //   590: astore_1
    //   591: goto -142 -> 449
    //   594: astore_2
    //   595: aload 5
    //   597: astore_1
    //   598: goto -226 -> 372
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	601	0	this	FFSegmentMediaPlayer
    //   0	601	1	paramStreamInfo	SegmentVideoInfo.StreamInfo
    //   0	601	2	paramList	List<String>
    //   202	96	3	i	int
    //   35	549	4	localObject1	Object
    //   62	534	5	localObject2	Object
    //   174	134	6	localStringBuilder	java.lang.StringBuilder
    //   229	47	7	localSegmentInfo	SegmentVideoInfo.SegmentInfo
    // Exception table:
    //   from	to	target	type
    //   323	328	336	java/io/IOException
    //   150	163	369	java/io/FileNotFoundException
    //   406	410	412	java/io/IOException
    //   150	163	445	java/io/IOException
    //   488	493	495	java/io/IOException
    //   150	163	528	finally
    //   537	542	544	java/io/IOException
    //   167	176	577	finally
    //   180	189	577	finally
    //   193	201	577	finally
    //   207	216	577	finally
    //   220	231	577	finally
    //   235	263	577	finally
    //   267	294	577	finally
    //   305	318	577	finally
    //   453	483	577	finally
    //   372	402	581	finally
    //   167	176	590	java/io/IOException
    //   180	189	590	java/io/IOException
    //   193	201	590	java/io/IOException
    //   207	216	590	java/io/IOException
    //   220	231	590	java/io/IOException
    //   235	263	590	java/io/IOException
    //   267	294	590	java/io/IOException
    //   305	318	590	java/io/IOException
    //   167	176	594	java/io/FileNotFoundException
    //   180	189	594	java/io/FileNotFoundException
    //   193	201	594	java/io/FileNotFoundException
    //   207	216	594	java/io/FileNotFoundException
    //   220	231	594	java/io/FileNotFoundException
    //   235	263	594	java/io/FileNotFoundException
    //   267	294	594	java/io/FileNotFoundException
    //   305	318	594	java/io/FileNotFoundException
  }
  
  private void initPlayer()
  {
    this.mInternalMediaPlayer = new IjkMediaPlayer(PlayerConfig.g().getNativeLibLoader());
    this.mCurrentState = 0;
    this.mTargetState = 0;
    if (PlayerConfig.g().isEnableHevcHwDecode()) {
      this.mInternalMediaPlayer.setOption(4, "mediacodec-all-videos", 1L);
    }
    for (;;)
    {
      this.mInternalMediaPlayer.setOption(2, "skip_loop_filter", 0L);
      this.mInternalMediaPlayer.setOption(4, "http-detect-range-support", 0L);
      this.mInternalMediaPlayer.setOption(4, "start-on-prepared", 0L);
      this.mInternalMediaPlayer.setOption(4, "infbuf", 1L);
      this.mInternalMediaPlayer.setOption(4, "fast", 1L);
      this.mInternalMediaPlayer.setOption(4, "framedrop", 5L);
      this.mInternalMediaPlayer.setOption(4, "enable-accurate-seek", 1L);
      this.mInternalMediaPlayer.setOption(4, "max-fps", 30L);
      this.mInternalMediaPlayer.setOption(1, "analyzeduration", 1L);
      this.mInternalMediaPlayer.setOption(4, "opensles", 0L);
      this.mInternalMediaPlayer.setOption(1, "protocol_whitelist", "file,http,https,tcp,tls");
      this.mInternalMediaPlayer.setOption(1, "safe", 0L);
      this.mInternalMediaPlayer.setLooping(false);
      this.mInternalMediaPlayer.setSurface(null);
      this.mInternalMediaPlayer.setSeekParameters(this.mSeekParameters);
      attachInternalListeners();
      this.mPath = null;
      return;
      this.mInternalMediaPlayer.setOption(4, "mediacodec", 0L);
    }
  }
  
  private boolean isInPlaybackState()
  {
    return (this.mInternalMediaPlayer != null) && (this.mCurrentState != -1) && (this.mCurrentState != 0) && (this.mCurrentState != 1);
  }
  
  public static boolean isSupported()
  {
    boolean bool1 = false;
    boolean bool2;
    do
    {
      try
      {
        if (sIsSupported != null) {
          bool1 = ((Boolean)sIsSupported).booleanValue();
        }
        for (;;)
        {
          return bool1;
          if (Build.VERSION.SDK_INT > 14) {
            break;
          }
          PlayerUtils.log(4, "FFSegmentMediaPlayer", "AllowPlayerNativeLibLoad false below 4.0");
          sIsSupported = Boolean.valueOf(false);
        }
        bool2 = IjkMediaPlayer.isNativeLibReady(PlayerConfig.g().getNativeLibLoader());
      }
      finally {}
    } while (!bool2);
    for (;;)
    {
      for (;;)
      {
        try
        {
          localIjkMediaPlayer = new IjkMediaPlayer(PlayerConfig.g().getNativeLibLoader());
        }
        catch (Throwable localThrowable3)
        {
          Throwable localThrowable1;
          IjkMediaPlayer localIjkMediaPlayer = null;
          continue;
        }
        try
        {
          sIsSupported = Boolean.valueOf(true);
          if ((localIjkMediaPlayer != null) && (IjkMediaPlayer.sIsLibLoadSuccess)) {
            localIjkMediaPlayer.release();
          }
          if (!IjkMediaPlayer.sIsLibLoadSuccess) {
            sIsSupported = Boolean.valueOf(false);
          }
          bool1 = ((Boolean)sIsSupported).booleanValue();
        }
        catch (Throwable localThrowable2) {}
      }
      sIsSupported = Boolean.valueOf(false);
      PlayerUtils.log(4, "FFSegmentMediaPlayer", "error init hero player " + PlayerUtils.getPrintableStackTrace(localThrowable1));
    }
  }
  
  public int getAudioSessionId()
  {
    return this.mInternalMediaPlayer.getAudioSessionId();
  }
  
  public long getCurrentPosition()
  {
    if (isInPlaybackState())
    {
      long l = this.mInternalMediaPlayer.getCurrentPosition();
      PlayerUtils.log(2, "FFSegmentMediaPlayer", "getCurrentPosition=" + l);
      return l;
    }
    PlayerUtils.log(5, "FFSegmentMediaPlayer", "getCurrentPosition failed, state error");
    return 0L;
  }
  
  public String getCurrentProxySegmentUrl()
  {
    if (this.mProxyUrls != null) {
      return (String)this.mProxyUrls.get(0);
    }
    return null;
  }
  
  public String getCurrentSegmentUrl()
  {
    if (this.mSourceUrls != null) {
      return (String)this.mSourceUrls.get(0);
    }
    return null;
  }
  
  public String getDataSource()
  {
    return this.mInternalMediaPlayer.getDataSource();
  }
  
  public long getDuration()
  {
    if (isInPlaybackState())
    {
      long l = this.mInternalMediaPlayer.getDuration();
      PlayerUtils.log(2, "FFSegmentMediaPlayer", "getDuration=" + l);
      return l;
    }
    PlayerUtils.log(5, "FFSegmentMediaPlayer", "getDuration failed, state error");
    return 0L;
  }
  
  public IjkMediaPlayer getInternalMediaPlayer()
  {
    return this.mInternalMediaPlayer;
  }
  
  public MediaInfo getMediaInfo()
  {
    return this.mInternalMediaPlayer.getMediaInfo();
  }
  
  public int getSegmentCount()
  {
    return 1;
  }
  
  public ITrackInfo[] getTrackInfo()
  {
    return this.mInternalMediaPlayer.getTrackInfo();
  }
  
  public int getVideoHeight()
  {
    return this.mInternalMediaPlayer.getVideoHeight();
  }
  
  public int getVideoSarDen()
  {
    return this.mInternalMediaPlayer.getVideoSarDen();
  }
  
  public int getVideoSarNum()
  {
    return this.mInternalMediaPlayer.getVideoSarNum();
  }
  
  public int getVideoWidth()
  {
    return this.mInternalMediaPlayer.getVideoWidth();
  }
  
  public boolean isLooping()
  {
    return this.isLooping;
  }
  
  public boolean isPlayable()
  {
    return this.mInternalMediaPlayer.isPlayable();
  }
  
  public boolean isPlaying()
  {
    return (isInPlaybackState()) && (this.mInternalMediaPlayer.isPlaying());
  }
  
  public void notifyOnSeekComplete()
  {
    PlayerUtils.log(4, "FFSegmentMediaPlayer", "onSeekComplete");
    super.notifyOnSeekComplete();
  }
  
  public void pause()
  {
    PlayerUtils.log(4, "FFSegmentMediaPlayer", "pause");
    if (isInPlaybackState()) {
      if (this.mInternalMediaPlayer.isPlaying())
      {
        this.mInternalMediaPlayer.pause();
        this.mCurrentState = 4;
      }
    }
    for (;;)
    {
      this.mTargetState = 4;
      return;
      PlayerUtils.log(5, "FFSegmentMediaPlayer", "pause failed, state error");
      continue;
      PlayerUtils.log(5, "FFSegmentMediaPlayer", "pause failed, state error");
    }
  }
  
  public void prepareAsync()
  {
    PlayerUtils.log(4, "FFSegmentMediaPlayer", "prepareAsync");
    this.mInternalMediaPlayer.prepareAsync();
  }
  
  public void release()
  {
    if (this.mInternalMediaPlayer != null)
    {
      PlayerUtils.log(4, "FFSegmentMediaPlayer", "release");
      this.mInternalMediaPlayer.setSurface(null);
      this.mInternalMediaPlayer.release();
      this.mCurrentState = 0;
      this.mTargetState = 0;
      this.mInternalMediaPlayer = null;
    }
    if ((this.mPlayListFile != null) && (this.mPlayListFile.exists()) && (!this.mPlayListFile.delete())) {
      PlayerUtils.log(5, "FFSegmentMediaPlayer", "playlist file delete failed!");
    }
    this.mPlayListFile = null;
    this.mPath = null;
  }
  
  public void reset()
  {
    PlayerUtils.log(4, "FFSegmentMediaPlayer", "reset");
    if (this.mInternalMediaPlayer == null) {
      return;
    }
    this.mInternalMediaPlayer.reset();
  }
  
  public void seekTo(long paramLong)
  {
    PlayerUtils.log(4, "FFSegmentMediaPlayer", "seekTo " + paramLong);
    if (this.mCurrentState == 2) {
      this.mInternalMediaPlayer.start();
    }
    if (isInPlaybackState())
    {
      this.mInternalMediaPlayer.seekTo(paramLong);
      return;
    }
    PlayerUtils.log(5, "FFSegmentMediaPlayer", "seekTo failed, state error");
  }
  
  public void setAudioStreamType(int paramInt)
  {
    this.mInternalMediaPlayer.setAudioStreamType(paramInt);
  }
  
  public void setDataSource(Context paramContext, Uri paramUri)
  {
    this.mInternalMediaPlayer.setDataSource(paramContext, paramUri);
  }
  
  public void setDataSource(Context paramContext, Uri paramUri, Map<String, String> paramMap)
  {
    this.mInternalMediaPlayer.setDataSource(paramContext, paramUri, paramMap);
  }
  
  public void setDataSource(SegmentVideoInfo.StreamInfo paramStreamInfo)
  {
    if ((this.mInternalMediaPlayer == null) || (paramStreamInfo == null) || (paramStreamInfo.segmentInfos == null) || (paramStreamInfo.segmentInfos.get(0) == null)) {}
    do
    {
      return;
      Object localObject = paramStreamInfo.segmentInfos;
      this.mSourceUrls = new ArrayList();
      if (localObject != null)
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          SegmentVideoInfo.SegmentInfo localSegmentInfo = (SegmentVideoInfo.SegmentInfo)((Iterator)localObject).next();
          this.mSourceUrls.add(localSegmentInfo.url);
        }
      }
      this.mProxyUrls = VideoManager.getInstance().getUrl(this.mSourceUrls);
      paramStreamInfo = generatePlayListFile(paramStreamInfo, this.mProxyUrls);
    } while ((this.mPath != null) && (this.mPath.equals(paramStreamInfo)));
    this.mPath = paramStreamInfo;
    if (this.mInternalMediaPlayer.isPlaying())
    {
      this.mInternalMediaPlayer.stop();
      if (this.mInternalMediaPlayer != null)
      {
        this.mInternalMediaPlayer.release();
        this.mInternalMediaPlayer = null;
        this.mCurrentState = 0;
      }
      initPlayer();
    }
    if (paramStreamInfo != null) {
      try
      {
        this.mInternalMediaPlayer.setDataSource(paramStreamInfo);
        this.mCurrentState = 1;
        return;
      }
      catch (IOException localIOException)
      {
        PlayerUtils.log(6, "FFSegmentMediaPlayer", "IOException:Unable to open content: " + paramStreamInfo);
        this.mCurrentState = -1;
        this.mTargetState = -1;
        return;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        PlayerUtils.log(6, "FFSegmentMediaPlayer", "IllegalArgumentException:Unable to open content: " + paramStreamInfo);
        this.mCurrentState = -1;
        this.mTargetState = -1;
        return;
      }
    }
    throw new IOException("path is null");
  }
  
  public void setDataSource(SegmentVideoInfo.StreamInfo paramStreamInfo, int paramInt)
  {
    setDataSource(paramStreamInfo);
  }
  
  public void setDataSource(FileDescriptor paramFileDescriptor)
  {
    this.mInternalMediaPlayer.setDataSource(paramFileDescriptor);
  }
  
  public void setDataSource(String paramString)
  {
    setDataSource(new SegmentVideoInfo.StreamInfo(paramString, 0));
  }
  
  public void setDisplay(SurfaceHolder paramSurfaceHolder)
  {
    PlayerUtils.log(4, "FFSegmentMediaPlayer", "setSurfaceHolder");
    if (this.mInternalMediaPlayer == null) {
      return;
    }
    this.mInternalMediaPlayer.setDisplay(paramSurfaceHolder);
  }
  
  public void setKeepInBackground(boolean paramBoolean)
  {
    this.mInternalMediaPlayer.setKeepInBackground(paramBoolean);
  }
  
  public void setLogEnabled(boolean paramBoolean)
  {
    this.mInternalMediaPlayer.setLogEnabled(paramBoolean);
  }
  
  public void setLooping(boolean paramBoolean)
  {
    this.isLooping = paramBoolean;
    PlayerUtils.log(4, "FFSegmentMediaPlayer", "setLooping " + this.isLooping);
  }
  
  public void setNextMediaPlayer(IMediaPlayer paramIMediaPlayer)
  {
    this.mInternalMediaPlayer.setNextMediaPlayer(paramIMediaPlayer);
  }
  
  public void setScreenOnWhilePlaying(boolean paramBoolean)
  {
    this.mInternalMediaPlayer.setScreenOnWhilePlaying(paramBoolean);
  }
  
  public void setSeekParameters(SeekParameters paramSeekParameters)
  {
    this.mSeekParameters = paramSeekParameters;
  }
  
  public void setSurface(Surface paramSurface)
  {
    PlayerUtils.log(4, "FFSegmentMediaPlayer", "setSurface");
    if (this.mInternalMediaPlayer == null) {
      return;
    }
    this.mInternalMediaPlayer.setSurface(paramSurface);
  }
  
  public void setVolume(float paramFloat1, float paramFloat2)
  {
    PlayerUtils.log(4, "FFSegmentMediaPlayer", "setVolume leftVolume=" + paramFloat1 + " rightVolume" + paramFloat2);
    this.mInternalMediaPlayer.setVolume(paramFloat1, paramFloat2);
  }
  
  public void setWakeMode(Context paramContext, int paramInt)
  {
    if (paramContext != null) {
      this.mInternalMediaPlayer.setWakeMode(paramContext, paramInt);
    }
  }
  
  public void start()
  {
    PlayerUtils.log(4, "FFSegmentMediaPlayer", "start");
    if (isInPlaybackState())
    {
      this.mInternalMediaPlayer.start();
      this.mCurrentState = 3;
    }
    for (;;)
    {
      this.mTargetState = 3;
      return;
      PlayerUtils.log(5, "FFSegmentMediaPlayer", "start failed, state error");
    }
  }
  
  public void stop()
  {
    this.mInternalMediaPlayer.stop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.oskplayer.player.FFSegmentMediaPlayer
 * JD-Core Version:    0.7.0.1
 */