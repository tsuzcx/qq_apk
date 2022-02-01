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
  private static Object sIsSupported;
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
    if (isSupported())
    {
      this.mInternalListenerAdapter = new FFSegmentMediaPlayer.AbstractMediaPlayerListenerHolder(this, this);
      initPlayer();
      return;
    }
    throw new UnsupportedOperationException("FFSegmentMediaPlayer is not available to use");
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
    //   7: istore 4
    //   9: iconst_0
    //   10: istore_3
    //   11: iload 4
    //   13: iconst_1
    //   14: if_icmpne +14 -> 28
    //   17: aload_2
    //   18: iconst_0
    //   19: invokeinterface 199 2 0
    //   24: checkcast 201	java/lang/String
    //   27: areturn
    //   28: aload_0
    //   29: getfield 203	com/tencent/oskplayer/player/FFSegmentMediaPlayer:mPlayListFile	Ljava/io/File;
    //   32: ifnonnull +675 -> 707
    //   35: invokestatic 209	com/tencent/oskplayer/PlayerConfig:g	()Lcom/tencent/oskplayer/PlayerConfig;
    //   38: invokevirtual 213	com/tencent/oskplayer/PlayerConfig:getTempDir	()Ljava/lang/String;
    //   41: astore 5
    //   43: aload 5
    //   45: ifnonnull +14 -> 59
    //   48: bipush 6
    //   50: ldc 10
    //   52: ldc 215
    //   54: invokestatic 221	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   57: aconst_null
    //   58: areturn
    //   59: new 223	java/io/File
    //   62: dup
    //   63: aload 5
    //   65: invokespecial 224	java/io/File:<init>	(Ljava/lang/String;)V
    //   68: astore 6
    //   70: new 226	java/lang/StringBuilder
    //   73: dup
    //   74: invokespecial 227	java/lang/StringBuilder:<init>	()V
    //   77: astore 7
    //   79: aload 7
    //   81: aload 5
    //   83: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: pop
    //   87: aload 7
    //   89: getstatic 234	java/io/File:separator	Ljava/lang/String;
    //   92: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: pop
    //   96: aload 7
    //   98: invokestatic 240	java/lang/System:currentTimeMillis	()J
    //   101: invokevirtual 243	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   104: pop
    //   105: aload 7
    //   107: ldc 245
    //   109: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: pop
    //   113: aload_0
    //   114: new 223	java/io/File
    //   117: dup
    //   118: aload 7
    //   120: invokevirtual 248	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   123: invokespecial 224	java/io/File:<init>	(Ljava/lang/String;)V
    //   126: putfield 203	com/tencent/oskplayer/player/FFSegmentMediaPlayer:mPlayListFile	Ljava/io/File;
    //   129: aload 6
    //   131: invokevirtual 251	java/io/File:exists	()Z
    //   134: ifne +9 -> 143
    //   137: aload 6
    //   139: invokevirtual 254	java/io/File:mkdirs	()Z
    //   142: pop
    //   143: new 226	java/lang/StringBuilder
    //   146: dup
    //   147: invokespecial 227	java/lang/StringBuilder:<init>	()V
    //   150: astore 5
    //   152: aload 5
    //   154: ldc_w 256
    //   157: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: pop
    //   161: aload 5
    //   163: aload_0
    //   164: getfield 203	com/tencent/oskplayer/player/FFSegmentMediaPlayer:mPlayListFile	Ljava/io/File;
    //   167: invokevirtual 259	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   170: pop
    //   171: iconst_4
    //   172: ldc 10
    //   174: aload 5
    //   176: invokevirtual 248	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   179: invokestatic 221	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   182: new 261	java/io/FileOutputStream
    //   185: dup
    //   186: aload_0
    //   187: getfield 203	com/tencent/oskplayer/player/FFSegmentMediaPlayer:mPlayListFile	Ljava/io/File;
    //   190: invokespecial 264	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   193: astore 6
    //   195: aload 6
    //   197: astore 5
    //   199: new 226	java/lang/StringBuilder
    //   202: dup
    //   203: invokespecial 227	java/lang/StringBuilder:<init>	()V
    //   206: astore 7
    //   208: aload 6
    //   210: astore 5
    //   212: aload 7
    //   214: ldc_w 266
    //   217: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: pop
    //   221: aload 6
    //   223: astore 5
    //   225: aload_1
    //   226: getfield 187	com/tencent/oskplayer/model/SegmentVideoInfo$StreamInfo:segmentInfos	Ljava/util/ArrayList;
    //   229: invokevirtual 270	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   232: astore_1
    //   233: aload 6
    //   235: astore 5
    //   237: aload_1
    //   238: invokeinterface 275 1 0
    //   243: ifeq +116 -> 359
    //   246: aload 6
    //   248: astore 5
    //   250: aload_1
    //   251: invokeinterface 279 1 0
    //   256: checkcast 281	com/tencent/oskplayer/model/SegmentVideoInfo$SegmentInfo
    //   259: astore 8
    //   261: aload 6
    //   263: astore 5
    //   265: aload 7
    //   267: ldc_w 283
    //   270: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: pop
    //   274: aload 6
    //   276: astore 5
    //   278: aload 7
    //   280: aload_2
    //   281: iload_3
    //   282: invokeinterface 199 2 0
    //   287: checkcast 201	java/lang/String
    //   290: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: pop
    //   294: aload 6
    //   296: astore 5
    //   298: aload 7
    //   300: ldc_w 285
    //   303: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: pop
    //   307: aload 6
    //   309: astore 5
    //   311: aload 7
    //   313: ldc_w 287
    //   316: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: pop
    //   320: aload 6
    //   322: astore 5
    //   324: aload 7
    //   326: aload 8
    //   328: getfield 290	com/tencent/oskplayer/model/SegmentVideoInfo$SegmentInfo:duration	I
    //   331: sipush 1000
    //   334: idiv
    //   335: invokevirtual 293	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   338: pop
    //   339: aload 6
    //   341: astore 5
    //   343: aload 7
    //   345: ldc_w 285
    //   348: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: pop
    //   352: iload_3
    //   353: iconst_1
    //   354: iadd
    //   355: istore_3
    //   356: goto -123 -> 233
    //   359: aload 6
    //   361: astore 5
    //   363: aload 6
    //   365: aload 7
    //   367: invokevirtual 248	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   370: invokevirtual 297	java/lang/String:getBytes	()[B
    //   373: invokevirtual 303	java/io/OutputStream:write	([B)V
    //   376: aload 6
    //   378: invokevirtual 306	java/io/OutputStream:close	()V
    //   381: goto +326 -> 707
    //   384: astore_1
    //   385: new 226	java/lang/StringBuilder
    //   388: dup
    //   389: invokespecial 227	java/lang/StringBuilder:<init>	()V
    //   392: astore_2
    //   393: aload_2
    //   394: ldc_w 308
    //   397: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: pop
    //   401: aload_2
    //   402: aload_1
    //   403: invokevirtual 311	java/io/IOException:getMessage	()Ljava/lang/String;
    //   406: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   409: pop
    //   410: bipush 6
    //   412: ldc 10
    //   414: aload_2
    //   415: invokevirtual 248	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   418: invokestatic 221	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   421: aconst_null
    //   422: areturn
    //   423: astore_1
    //   424: goto +18 -> 442
    //   427: astore_1
    //   428: goto +121 -> 549
    //   431: astore_1
    //   432: aconst_null
    //   433: astore 5
    //   435: goto +218 -> 653
    //   438: astore_1
    //   439: aconst_null
    //   440: astore 6
    //   442: aload 6
    //   444: astore 5
    //   446: new 226	java/lang/StringBuilder
    //   449: dup
    //   450: invokespecial 227	java/lang/StringBuilder:<init>	()V
    //   453: astore_2
    //   454: aload 6
    //   456: astore 5
    //   458: aload_2
    //   459: ldc_w 313
    //   462: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   465: pop
    //   466: aload 6
    //   468: astore 5
    //   470: aload_2
    //   471: aload_1
    //   472: invokevirtual 311	java/io/IOException:getMessage	()Ljava/lang/String;
    //   475: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   478: pop
    //   479: aload 6
    //   481: astore 5
    //   483: bipush 6
    //   485: ldc 10
    //   487: aload_2
    //   488: invokevirtual 248	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   491: invokestatic 221	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   494: aload 6
    //   496: ifnull +47 -> 543
    //   499: aload 6
    //   501: invokevirtual 306	java/io/OutputStream:close	()V
    //   504: aconst_null
    //   505: areturn
    //   506: astore_1
    //   507: new 226	java/lang/StringBuilder
    //   510: dup
    //   511: invokespecial 227	java/lang/StringBuilder:<init>	()V
    //   514: astore_2
    //   515: aload_2
    //   516: ldc_w 308
    //   519: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   522: pop
    //   523: aload_2
    //   524: aload_1
    //   525: invokevirtual 311	java/io/IOException:getMessage	()Ljava/lang/String;
    //   528: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   531: pop
    //   532: bipush 6
    //   534: ldc 10
    //   536: aload_2
    //   537: invokevirtual 248	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   540: invokestatic 221	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   543: aconst_null
    //   544: areturn
    //   545: astore_1
    //   546: aconst_null
    //   547: astore 6
    //   549: aload 6
    //   551: astore 5
    //   553: new 226	java/lang/StringBuilder
    //   556: dup
    //   557: invokespecial 227	java/lang/StringBuilder:<init>	()V
    //   560: astore_2
    //   561: aload 6
    //   563: astore 5
    //   565: aload_2
    //   566: ldc_w 315
    //   569: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   572: pop
    //   573: aload 6
    //   575: astore 5
    //   577: aload_2
    //   578: aload_1
    //   579: invokevirtual 316	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   582: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   585: pop
    //   586: aload 6
    //   588: astore 5
    //   590: bipush 6
    //   592: ldc 10
    //   594: aload_2
    //   595: invokevirtual 248	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   598: invokestatic 221	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   601: aload 6
    //   603: ifnull +47 -> 650
    //   606: aload 6
    //   608: invokevirtual 306	java/io/OutputStream:close	()V
    //   611: aconst_null
    //   612: areturn
    //   613: astore_1
    //   614: new 226	java/lang/StringBuilder
    //   617: dup
    //   618: invokespecial 227	java/lang/StringBuilder:<init>	()V
    //   621: astore_2
    //   622: aload_2
    //   623: ldc_w 308
    //   626: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   629: pop
    //   630: aload_2
    //   631: aload_1
    //   632: invokevirtual 311	java/io/IOException:getMessage	()Ljava/lang/String;
    //   635: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   638: pop
    //   639: bipush 6
    //   641: ldc 10
    //   643: aload_2
    //   644: invokevirtual 248	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   647: invokestatic 221	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   650: aconst_null
    //   651: areturn
    //   652: astore_1
    //   653: aload 5
    //   655: ifnull +50 -> 705
    //   658: aload 5
    //   660: invokevirtual 306	java/io/OutputStream:close	()V
    //   663: goto +42 -> 705
    //   666: astore_1
    //   667: new 226	java/lang/StringBuilder
    //   670: dup
    //   671: invokespecial 227	java/lang/StringBuilder:<init>	()V
    //   674: astore_2
    //   675: aload_2
    //   676: ldc_w 308
    //   679: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   682: pop
    //   683: aload_2
    //   684: aload_1
    //   685: invokevirtual 311	java/io/IOException:getMessage	()Ljava/lang/String;
    //   688: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   691: pop
    //   692: bipush 6
    //   694: ldc 10
    //   696: aload_2
    //   697: invokevirtual 248	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   700: invokestatic 221	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   703: aconst_null
    //   704: areturn
    //   705: aload_1
    //   706: athrow
    //   707: aload_0
    //   708: getfield 203	com/tencent/oskplayer/player/FFSegmentMediaPlayer:mPlayListFile	Ljava/io/File;
    //   711: invokevirtual 319	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   714: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	715	0	this	FFSegmentMediaPlayer
    //   0	715	1	paramStreamInfo	SegmentVideoInfo.StreamInfo
    //   0	715	2	paramList	List<String>
    //   10	346	3	i	int
    //   7	8	4	j	int
    //   41	618	5	localObject1	Object
    //   68	539	6	localObject2	Object
    //   77	289	7	localStringBuilder	StringBuilder
    //   259	68	8	localSegmentInfo	SegmentVideoInfo.SegmentInfo
    // Exception table:
    //   from	to	target	type
    //   376	381	384	java/io/IOException
    //   199	208	423	java/io/IOException
    //   212	221	423	java/io/IOException
    //   225	233	423	java/io/IOException
    //   237	246	423	java/io/IOException
    //   250	261	423	java/io/IOException
    //   265	274	423	java/io/IOException
    //   278	294	423	java/io/IOException
    //   298	307	423	java/io/IOException
    //   311	320	423	java/io/IOException
    //   324	339	423	java/io/IOException
    //   343	352	423	java/io/IOException
    //   363	376	423	java/io/IOException
    //   199	208	427	java/io/FileNotFoundException
    //   212	221	427	java/io/FileNotFoundException
    //   225	233	427	java/io/FileNotFoundException
    //   237	246	427	java/io/FileNotFoundException
    //   250	261	427	java/io/FileNotFoundException
    //   265	274	427	java/io/FileNotFoundException
    //   278	294	427	java/io/FileNotFoundException
    //   298	307	427	java/io/FileNotFoundException
    //   311	320	427	java/io/FileNotFoundException
    //   324	339	427	java/io/FileNotFoundException
    //   343	352	427	java/io/FileNotFoundException
    //   363	376	427	java/io/FileNotFoundException
    //   182	195	431	finally
    //   182	195	438	java/io/IOException
    //   499	504	506	java/io/IOException
    //   182	195	545	java/io/FileNotFoundException
    //   606	611	613	java/io/IOException
    //   199	208	652	finally
    //   212	221	652	finally
    //   225	233	652	finally
    //   237	246	652	finally
    //   250	261	652	finally
    //   265	274	652	finally
    //   278	294	652	finally
    //   298	307	652	finally
    //   311	320	652	finally
    //   324	339	652	finally
    //   343	352	652	finally
    //   363	376	652	finally
    //   446	454	652	finally
    //   458	466	652	finally
    //   470	479	652	finally
    //   483	494	652	finally
    //   553	561	652	finally
    //   565	573	652	finally
    //   577	586	652	finally
    //   590	601	652	finally
    //   658	663	666	java/io/IOException
  }
  
  private void initPlayer()
  {
    this.mInternalMediaPlayer = new IjkMediaPlayer(PlayerConfig.g().getNativeLibLoader());
    this.mCurrentState = 0;
    this.mTargetState = 0;
    if (PlayerConfig.g().isEnableHevcHwDecode()) {
      this.mInternalMediaPlayer.setOption(4, "mediacodec-all-videos", 1L);
    } else {
      this.mInternalMediaPlayer.setOption(4, "mediacodec", 0L);
    }
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
  }
  
  private boolean isInPlaybackState()
  {
    if (this.mInternalMediaPlayer != null)
    {
      int i = this.mCurrentState;
      if ((i != -1) && (i != 0) && (i != 1)) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean isSupported()
  {
    try
    {
      if (sIsSupported != null)
      {
        bool = ((Boolean)sIsSupported).booleanValue();
        return bool;
      }
      if (Build.VERSION.SDK_INT <= 14)
      {
        PlayerUtils.log(4, "FFSegmentMediaPlayer", "AllowPlayerNativeLibLoad false below 4.0");
        sIsSupported = Boolean.valueOf(false);
        return false;
      }
      boolean bool = IjkMediaPlayer.isNativeLibReady(PlayerConfig.g().getNativeLibLoader());
      if (bool)
      {
        StringBuilder localStringBuilder = null;
        Object localObject1;
        try
        {
          localObject1 = new IjkMediaPlayer(PlayerConfig.g().getNativeLibLoader());
          try
          {
            sIsSupported = Boolean.valueOf(true);
          }
          catch (Throwable localThrowable1) {}
          sIsSupported = Boolean.valueOf(false);
        }
        catch (Throwable localThrowable2)
        {
          localObject1 = localStringBuilder;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("error init hero player ");
        localStringBuilder.append(PlayerUtils.getPrintableStackTrace(localThrowable2));
        PlayerUtils.log(4, "FFSegmentMediaPlayer", localStringBuilder.toString());
        if ((localObject1 != null) && (IjkMediaPlayer.sIsLibLoadSuccess)) {
          ((IjkMediaPlayer)localObject1).release();
        }
        if (!IjkMediaPlayer.sIsLibLoadSuccess) {
          sIsSupported = Boolean.valueOf(false);
        }
        bool = ((Boolean)sIsSupported).booleanValue();
        return bool;
      }
      return false;
    }
    finally {}
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getCurrentPosition=");
      localStringBuilder.append(l);
      PlayerUtils.log(2, "FFSegmentMediaPlayer", localStringBuilder.toString());
      return l;
    }
    PlayerUtils.log(5, "FFSegmentMediaPlayer", "getCurrentPosition failed, state error");
    return 0L;
  }
  
  public String getCurrentProxySegmentUrl()
  {
    List localList = this.mProxyUrls;
    if (localList != null) {
      return (String)localList.get(0);
    }
    return null;
  }
  
  public String getCurrentSegmentUrl()
  {
    List localList = this.mSourceUrls;
    if (localList != null) {
      return (String)localList.get(0);
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getDuration=");
      localStringBuilder.append(l);
      PlayerUtils.log(2, "FFSegmentMediaPlayer", localStringBuilder.toString());
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
  
  protected void notifyOnSeekComplete()
  {
    PlayerUtils.log(4, "FFSegmentMediaPlayer", "onSeekComplete");
    super.notifyOnSeekComplete();
  }
  
  public void pause()
  {
    PlayerUtils.log(4, "FFSegmentMediaPlayer", "pause");
    if (isInPlaybackState())
    {
      if (this.mInternalMediaPlayer.isPlaying())
      {
        this.mInternalMediaPlayer.pause();
        this.mCurrentState = 4;
      }
      else
      {
        PlayerUtils.log(5, "FFSegmentMediaPlayer", "pause failed, state error");
      }
    }
    else {
      PlayerUtils.log(5, "FFSegmentMediaPlayer", "pause failed, state error");
    }
    this.mTargetState = 4;
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
    File localFile = this.mPlayListFile;
    if ((localFile != null) && (localFile.exists()) && (!this.mPlayListFile.delete())) {
      PlayerUtils.log(5, "FFSegmentMediaPlayer", "playlist file delete failed!");
    }
    this.mPlayListFile = null;
    this.mPath = null;
  }
  
  public void reset()
  {
    PlayerUtils.log(4, "FFSegmentMediaPlayer", "reset");
    IjkMediaPlayer localIjkMediaPlayer = this.mInternalMediaPlayer;
    if (localIjkMediaPlayer == null) {
      return;
    }
    localIjkMediaPlayer.reset();
  }
  
  public void seekTo(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("seekTo ");
    localStringBuilder.append(paramLong);
    PlayerUtils.log(4, "FFSegmentMediaPlayer", localStringBuilder.toString());
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
    if ((this.mInternalMediaPlayer != null) && (paramStreamInfo != null) && (paramStreamInfo.segmentInfos != null))
    {
      if (paramStreamInfo.segmentInfos.get(0) == null) {
        return;
      }
      localObject = paramStreamInfo.segmentInfos;
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
      localObject = this.mPath;
      if ((localObject != null) && (((String)localObject).equals(paramStreamInfo))) {
        return;
      }
      this.mPath = paramStreamInfo;
      if (this.mInternalMediaPlayer.isPlaying())
      {
        this.mInternalMediaPlayer.stop();
        localObject = this.mInternalMediaPlayer;
        if (localObject != null)
        {
          ((IjkMediaPlayer)localObject).release();
          this.mInternalMediaPlayer = null;
          this.mCurrentState = 0;
        }
        initPlayer();
      }
      if (paramStreamInfo == null) {}
    }
    try
    {
      this.mInternalMediaPlayer.setDataSource(paramStreamInfo);
      this.mCurrentState = 1;
      return;
    }
    catch (IOException localIOException)
    {
      break label244;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      label200:
      break label200;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("IllegalArgumentException:Unable to open content: ");
    ((StringBuilder)localObject).append(paramStreamInfo);
    PlayerUtils.log(6, "FFSegmentMediaPlayer", ((StringBuilder)localObject).toString());
    this.mCurrentState = -1;
    this.mTargetState = -1;
    return;
    label244:
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("IOException:Unable to open content: ");
    ((StringBuilder)localObject).append(paramStreamInfo);
    PlayerUtils.log(6, "FFSegmentMediaPlayer", ((StringBuilder)localObject).toString());
    this.mCurrentState = -1;
    this.mTargetState = -1;
    return;
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
    IjkMediaPlayer localIjkMediaPlayer = this.mInternalMediaPlayer;
    if (localIjkMediaPlayer == null) {
      return;
    }
    localIjkMediaPlayer.setDisplay(paramSurfaceHolder);
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setLooping ");
    localStringBuilder.append(this.isLooping);
    PlayerUtils.log(4, "FFSegmentMediaPlayer", localStringBuilder.toString());
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
    IjkMediaPlayer localIjkMediaPlayer = this.mInternalMediaPlayer;
    if (localIjkMediaPlayer == null) {
      return;
    }
    localIjkMediaPlayer.setSurface(paramSurface);
  }
  
  public void setVolume(float paramFloat1, float paramFloat2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setVolume leftVolume=");
    localStringBuilder.append(paramFloat1);
    localStringBuilder.append(" rightVolume");
    localStringBuilder.append(paramFloat2);
    PlayerUtils.log(4, "FFSegmentMediaPlayer", localStringBuilder.toString());
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
    else
    {
      PlayerUtils.log(5, "FFSegmentMediaPlayer", "start failed, state error");
    }
    this.mTargetState = 3;
  }
  
  public void stop()
  {
    this.mInternalMediaPlayer.stop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.oskplayer.player.FFSegmentMediaPlayer
 * JD-Core Version:    0.7.0.1
 */