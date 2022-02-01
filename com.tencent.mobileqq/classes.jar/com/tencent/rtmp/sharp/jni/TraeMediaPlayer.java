package com.tencent.rtmp.sharp.jni;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import java.util.Timer;
import java.util.TimerTask;

public class TraeMediaPlayer
  implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener
{
  public static final int TRAE_MEDIAPLAER_DATASOURCE_FILEPATH = 2;
  public static final int TRAE_MEDIAPLAER_DATASOURCE_RSID = 0;
  public static final int TRAE_MEDIAPLAER_DATASOURCE_URI = 1;
  public static final int TRAE_MEDIAPLAER_STOP = 100;
  private Context _context;
  private int _durationMS = -1;
  private boolean _hasCall = false;
  private boolean _loop = false;
  int _loopCount = 0;
  private int _prevVolume = -1;
  boolean _ringMode = false;
  private int _streamType = 0;
  private Timer _watchTimer = null;
  private TimerTask _watchTimertask = null;
  private TraeMediaPlayer.OnCompletionListener mCallback;
  private MediaPlayer mMediaPlay = null;
  
  public TraeMediaPlayer(Context paramContext, TraeMediaPlayer.OnCompletionListener paramOnCompletionListener)
  {
    this._context = paramContext;
    this.mCallback = paramOnCompletionListener;
  }
  
  private void volumeDo()
  {
    if ((this.mMediaPlay != null) && (this._ringMode)) {
      if (this._streamType == 2) {
        return;
      }
    }
    for (;;)
    {
      int i;
      int n;
      try
      {
        localAudioManager = (AudioManager)this._context.getSystemService("audio");
        k = localAudioManager.getStreamVolume(this._streamType);
        i = localAudioManager.getStreamMaxVolume(this._streamType);
        j = localAudioManager.getStreamVolume(2);
        int m = localAudioManager.getStreamMaxVolume(2);
        double d1 = j;
        Double.isNaN(d1);
        double d2 = m;
        Double.isNaN(d2);
        d1 = d1 * 1.0D / d2;
        d2 = i;
        Double.isNaN(d2);
        n = (int)(d1 * d2);
        if (!QLog.isColorLevel()) {
          break label290;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("TraeMediaPlay volumeDo currV:");
        localStringBuilder.append(k);
        localStringBuilder.append(" maxV:");
        localStringBuilder.append(i);
        localStringBuilder.append(" currRV:");
        localStringBuilder.append(j);
        localStringBuilder.append(" maxRV:");
        localStringBuilder.append(m);
        localStringBuilder.append(" setV:");
        localStringBuilder.append(n);
        QLog.e("TRAE", 2, localStringBuilder.toString());
      }
      catch (Exception localException)
      {
        AudioManager localAudioManager;
        int k;
        if (!QLog.isColorLevel()) {
          break label289;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("set stream volume failed.");
        localStringBuilder.append(localException.getMessage());
        QLog.e("TRAE", 2, localStringBuilder.toString());
      }
      localAudioManager.setStreamVolume(this._streamType, i, 0);
      this._prevVolume = k;
      return;
      label289:
      return;
      label290:
      int j = n + 1;
      if (j < i) {
        i = j;
      }
    }
  }
  
  private void volumeUndo()
  {
    if ((this.mMediaPlay != null) && (this._ringMode) && (this._streamType != 2))
    {
      if (this._prevVolume == -1) {
        return;
      }
      try
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append("TraeMediaPlay volumeUndo _prevVolume:");
          localStringBuilder1.append(this._prevVolume);
          QLog.e("TRAE", 2, localStringBuilder1.toString());
        }
        ((AudioManager)this._context.getSystemService("audio")).setStreamVolume(this._streamType, this._prevVolume, 0);
        return;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("set stream volume failed.");
          localStringBuilder2.append(localException.getMessage());
          QLog.e("TRAE", 2, localStringBuilder2.toString());
        }
      }
    }
  }
  
  public int getDuration()
  {
    return this._durationMS;
  }
  
  public int getStreamType()
  {
    return this._streamType;
  }
  
  public boolean hasCall()
  {
    return this._hasCall;
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    paramMediaPlayer = new StringBuilder();
    paramMediaPlayer.append(" cb:");
    paramMediaPlayer.append(this.mCallback);
    paramMediaPlayer.append(" loopCount:");
    paramMediaPlayer.append(this._loopCount);
    paramMediaPlayer.append(" _loop:");
    paramMediaPlayer.append(this._loop);
    AudioDeviceInterface.LogTraceEntry(paramMediaPlayer.toString());
    if (this._loop)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TRAE", 2, "loop play,continue...");
      }
      return;
    }
    try
    {
      if (this._loopCount <= 0)
      {
        volumeUndo();
        if (this.mMediaPlay.isPlaying()) {
          this.mMediaPlay.stop();
        }
        this.mMediaPlay.reset();
        this.mMediaPlay.release();
        this.mMediaPlay = null;
        if (this.mCallback != null) {
          this.mCallback.onCompletion();
        }
      }
      else
      {
        this.mMediaPlay.start();
        this._loopCount -= 1;
      }
    }
    catch (Exception paramMediaPlayer)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("stop play failed.");
        localStringBuilder.append(paramMediaPlayer.getMessage());
        QLog.e("TRAE", 2, localStringBuilder.toString());
      }
    }
    AudioDeviceInterface.LogTraceExit();
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    paramMediaPlayer = new StringBuilder();
    paramMediaPlayer.append(" cb:");
    paramMediaPlayer.append(this.mCallback);
    paramMediaPlayer.append(" arg1:");
    paramMediaPlayer.append(paramInt1);
    paramMediaPlayer.append(" arg2:");
    paramMediaPlayer.append(paramInt2);
    AudioDeviceInterface.LogTraceEntry(paramMediaPlayer.toString());
    try
    {
      this.mMediaPlay.release();
    }
    catch (Exception paramMediaPlayer)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("release MediaPlayer failed.");
        localStringBuilder.append(paramMediaPlayer.getMessage());
        QLog.e("TRAE", 2, localStringBuilder.toString());
      }
    }
    this.mMediaPlay = null;
    paramMediaPlayer = this.mCallback;
    if (paramMediaPlayer != null) {
      paramMediaPlayer.onCompletion();
    }
    AudioDeviceInterface.LogTraceExit();
    return false;
  }
  
  /* Error */
  public boolean playRing(int paramInt1, int paramInt2, android.net.Uri paramUri, java.lang.String paramString, boolean paramBoolean1, int paramInt3, boolean paramBoolean2, boolean paramBoolean3, int paramInt4)
  {
    // Byte code:
    //   0: invokestatic 101	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   3: ifeq +196 -> 199
    //   6: new 103	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   13: astore 12
    //   15: aload 12
    //   17: ldc 220
    //   19: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: pop
    //   23: aload 12
    //   25: iload_1
    //   26: invokevirtual 113	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: aload 12
    //   32: ldc 222
    //   34: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: pop
    //   38: aload 12
    //   40: iload_2
    //   41: invokevirtual 113	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   44: pop
    //   45: aload 12
    //   47: ldc 224
    //   49: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: pop
    //   53: aload 12
    //   55: aload_3
    //   56: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   59: pop
    //   60: aload 12
    //   62: ldc 226
    //   64: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: pop
    //   68: aload 12
    //   70: aload 4
    //   72: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: pop
    //   76: aload 12
    //   78: ldc 228
    //   80: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: pop
    //   84: iload 5
    //   86: ifeq +10 -> 96
    //   89: ldc 230
    //   91: astore 11
    //   93: goto +7 -> 100
    //   96: ldc 232
    //   98: astore 11
    //   100: aload 12
    //   102: aload 11
    //   104: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: pop
    //   108: aload 12
    //   110: ldc 234
    //   112: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: pop
    //   116: aload 12
    //   118: iload 6
    //   120: invokevirtual 113	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   123: pop
    //   124: aload 12
    //   126: ldc 236
    //   128: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: pop
    //   132: iload 7
    //   134: ifeq +10 -> 144
    //   137: ldc 230
    //   139: astore 11
    //   141: goto +7 -> 148
    //   144: ldc 232
    //   146: astore 11
    //   148: aload 12
    //   150: aload 11
    //   152: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: pop
    //   156: aload 12
    //   158: ldc 238
    //   160: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: pop
    //   164: aload 12
    //   166: iload 8
    //   168: invokevirtual 161	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   171: pop
    //   172: aload 12
    //   174: ldc 240
    //   176: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: pop
    //   180: aload 12
    //   182: iload 9
    //   184: invokevirtual 113	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   187: pop
    //   188: ldc 123
    //   190: iconst_2
    //   191: aload 12
    //   193: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   196: invokestatic 131	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   199: iload 5
    //   201: ifne +96 -> 297
    //   204: iload 6
    //   206: ifgt +91 -> 297
    //   209: invokestatic 101	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   212: ifeq +83 -> 295
    //   215: new 103	java/lang/StringBuilder
    //   218: dup
    //   219: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   222: astore 4
    //   224: aload 4
    //   226: ldc 242
    //   228: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: pop
    //   232: aload 4
    //   234: iload_1
    //   235: invokevirtual 113	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   238: pop
    //   239: aload 4
    //   241: ldc 228
    //   243: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: pop
    //   247: iload 5
    //   249: ifeq +9 -> 258
    //   252: ldc 230
    //   254: astore_3
    //   255: goto +6 -> 261
    //   258: ldc 232
    //   260: astore_3
    //   261: aload 4
    //   263: aload_3
    //   264: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: pop
    //   268: aload 4
    //   270: ldc 234
    //   272: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: pop
    //   276: aload 4
    //   278: iload 6
    //   280: invokevirtual 113	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   283: pop
    //   284: ldc 123
    //   286: iconst_2
    //   287: aload 4
    //   289: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   292: invokestatic 131	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   295: iconst_0
    //   296: ireturn
    //   297: aload_0
    //   298: getfield 42	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   301: astore 11
    //   303: aload 11
    //   305: ifnull +107 -> 412
    //   308: aload_0
    //   309: getfield 42	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   312: invokevirtual 179	android/media/MediaPlayer:isPlaying	()Z
    //   315: istore 10
    //   317: iload 10
    //   319: ifeq +5 -> 324
    //   322: iconst_0
    //   323: ireturn
    //   324: aload_0
    //   325: getfield 42	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   328: invokevirtual 188	android/media/MediaPlayer:release	()V
    //   331: aload_0
    //   332: aconst_null
    //   333: putfield 42	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   336: goto +76 -> 412
    //   339: astore_3
    //   340: goto +65 -> 405
    //   343: astore 11
    //   345: invokestatic 101	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   348: ifeq +49 -> 397
    //   351: new 103	java/lang/StringBuilder
    //   354: dup
    //   355: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   358: astore 12
    //   360: aload 12
    //   362: ldc 208
    //   364: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: pop
    //   368: aload 12
    //   370: aload 11
    //   372: invokevirtual 140	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   375: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   378: pop
    //   379: ldc 123
    //   381: iconst_2
    //   382: aload 12
    //   384: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   387: invokestatic 131	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   390: goto +7 -> 397
    //   393: astore_3
    //   394: goto +11 -> 405
    //   397: aload_0
    //   398: aconst_null
    //   399: putfield 42	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   402: goto +10 -> 412
    //   405: aload_0
    //   406: aconst_null
    //   407: putfield 42	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   410: aload_3
    //   411: athrow
    //   412: aload_0
    //   413: getfield 56	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_watchTimer	Ljava/util/Timer;
    //   416: ifnull +20 -> 436
    //   419: aload_0
    //   420: getfield 56	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_watchTimer	Ljava/util/Timer;
    //   423: invokevirtual 247	java/util/Timer:cancel	()V
    //   426: aload_0
    //   427: aconst_null
    //   428: putfield 56	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_watchTimer	Ljava/util/Timer;
    //   431: aload_0
    //   432: aconst_null
    //   433: putfield 58	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_watchTimertask	Ljava/util/TimerTask;
    //   436: aload_0
    //   437: getfield 62	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_context	Landroid/content/Context;
    //   440: ldc 74
    //   442: invokevirtual 80	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   445: checkcast 82	android/media/AudioManager
    //   448: astore 11
    //   450: aload_0
    //   451: new 176	android/media/MediaPlayer
    //   454: dup
    //   455: invokespecial 248	android/media/MediaPlayer:<init>	()V
    //   458: putfield 42	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   461: aload_0
    //   462: getfield 42	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   465: ifnonnull +17 -> 482
    //   468: aload_0
    //   469: getfield 42	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   472: invokevirtual 188	android/media/MediaPlayer:release	()V
    //   475: aload_0
    //   476: aconst_null
    //   477: putfield 42	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   480: iconst_0
    //   481: ireturn
    //   482: aload_0
    //   483: getfield 42	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   486: aload_0
    //   487: invokevirtual 252	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   490: aload_0
    //   491: getfield 42	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   494: aload_0
    //   495: invokevirtual 256	android/media/MediaPlayer:setOnErrorListener	(Landroid/media/MediaPlayer$OnErrorListener;)V
    //   498: iload_1
    //   499: ifeq +174 -> 673
    //   502: iload_1
    //   503: iconst_1
    //   504: if_icmpeq +112 -> 616
    //   507: iload_1
    //   508: iconst_2
    //   509: if_icmpeq +56 -> 565
    //   512: invokestatic 101	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   515: ifeq +35 -> 550
    //   518: new 103	java/lang/StringBuilder
    //   521: dup
    //   522: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   525: astore_3
    //   526: aload_3
    //   527: ldc_w 258
    //   530: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   533: pop
    //   534: aload_3
    //   535: iload_1
    //   536: invokevirtual 113	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   539: pop
    //   540: ldc 123
    //   542: iconst_2
    //   543: aload_3
    //   544: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   547: invokestatic 131	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   550: aload_0
    //   551: getfield 42	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   554: invokevirtual 188	android/media/MediaPlayer:release	()V
    //   557: aload_0
    //   558: aconst_null
    //   559: putfield 42	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   562: goto +240 -> 802
    //   565: invokestatic 101	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   568: ifeq +36 -> 604
    //   571: new 103	java/lang/StringBuilder
    //   574: dup
    //   575: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   578: astore_3
    //   579: aload_3
    //   580: ldc_w 260
    //   583: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   586: pop
    //   587: aload_3
    //   588: aload 4
    //   590: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   593: pop
    //   594: ldc 123
    //   596: iconst_2
    //   597: aload_3
    //   598: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   601: invokestatic 131	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   604: aload_0
    //   605: getfield 42	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   608: aload 4
    //   610: invokevirtual 263	android/media/MediaPlayer:setDataSource	(Ljava/lang/String;)V
    //   613: goto +189 -> 802
    //   616: invokestatic 101	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   619: ifeq +39 -> 658
    //   622: new 103	java/lang/StringBuilder
    //   625: dup
    //   626: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   629: astore 4
    //   631: aload 4
    //   633: ldc_w 265
    //   636: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   639: pop
    //   640: aload 4
    //   642: aload_3
    //   643: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   646: pop
    //   647: ldc 123
    //   649: iconst_2
    //   650: aload 4
    //   652: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   655: invokestatic 131	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   658: aload_0
    //   659: getfield 42	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   662: aload_0
    //   663: getfield 62	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_context	Landroid/content/Context;
    //   666: aload_3
    //   667: invokevirtual 268	android/media/MediaPlayer:setDataSource	(Landroid/content/Context;Landroid/net/Uri;)V
    //   670: goto +132 -> 802
    //   673: invokestatic 101	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   676: ifeq +35 -> 711
    //   679: new 103	java/lang/StringBuilder
    //   682: dup
    //   683: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   686: astore_3
    //   687: aload_3
    //   688: ldc_w 270
    //   691: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   694: pop
    //   695: aload_3
    //   696: iload_2
    //   697: invokevirtual 113	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   700: pop
    //   701: ldc 123
    //   703: iconst_2
    //   704: aload_3
    //   705: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   708: invokestatic 131	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   711: aload_0
    //   712: getfield 62	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_context	Landroid/content/Context;
    //   715: invokevirtual 274	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   718: iload_2
    //   719: invokevirtual 280	android/content/res/Resources:openRawResourceFd	(I)Landroid/content/res/AssetFileDescriptor;
    //   722: astore_3
    //   723: aload_3
    //   724: ifnonnull +55 -> 779
    //   727: invokestatic 101	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   730: ifeq +35 -> 765
    //   733: new 103	java/lang/StringBuilder
    //   736: dup
    //   737: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   740: astore_3
    //   741: aload_3
    //   742: ldc_w 282
    //   745: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   748: pop
    //   749: aload_3
    //   750: iload_2
    //   751: invokevirtual 113	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   754: pop
    //   755: ldc 123
    //   757: iconst_2
    //   758: aload_3
    //   759: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   762: invokestatic 131	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   765: aload_0
    //   766: getfield 42	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   769: invokevirtual 188	android/media/MediaPlayer:release	()V
    //   772: aload_0
    //   773: aconst_null
    //   774: putfield 42	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   777: iconst_0
    //   778: ireturn
    //   779: aload_0
    //   780: getfield 42	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   783: aload_3
    //   784: invokevirtual 288	android/content/res/AssetFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   787: aload_3
    //   788: invokevirtual 292	android/content/res/AssetFileDescriptor:getStartOffset	()J
    //   791: aload_3
    //   792: invokevirtual 295	android/content/res/AssetFileDescriptor:getLength	()J
    //   795: invokevirtual 298	android/media/MediaPlayer:setDataSource	(Ljava/io/FileDescriptor;JJ)V
    //   798: aload_3
    //   799: invokevirtual 301	android/content/res/AssetFileDescriptor:close	()V
    //   802: aload_0
    //   803: getfield 42	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   806: ifnonnull +5 -> 811
    //   809: iconst_0
    //   810: ireturn
    //   811: aload_0
    //   812: iload 7
    //   814: putfield 54	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_ringMode	Z
    //   817: aload_0
    //   818: getfield 54	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_ringMode	Z
    //   821: ifeq +13 -> 834
    //   824: aload_0
    //   825: iconst_2
    //   826: putfield 44	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_streamType	I
    //   829: iconst_1
    //   830: istore_1
    //   831: goto +21 -> 852
    //   834: aload_0
    //   835: iconst_0
    //   836: putfield 44	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_streamType	I
    //   839: getstatic 306	android/os/Build$VERSION:SDK_INT	I
    //   842: bipush 11
    //   844: if_icmplt +611 -> 1455
    //   847: iconst_3
    //   848: istore_1
    //   849: goto +3 -> 852
    //   852: aload_0
    //   853: iload 8
    //   855: putfield 46	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_hasCall	Z
    //   858: aload_0
    //   859: getfield 46	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_hasCall	Z
    //   862: ifeq +9 -> 871
    //   865: aload_0
    //   866: iload 9
    //   868: putfield 44	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_streamType	I
    //   871: aload_0
    //   872: getfield 42	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   875: aload_0
    //   876: getfield 44	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_streamType	I
    //   879: invokevirtual 310	android/media/MediaPlayer:setAudioStreamType	(I)V
    //   882: aload_0
    //   883: getfield 42	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   886: invokevirtual 313	android/media/MediaPlayer:prepare	()V
    //   889: aload_0
    //   890: getfield 42	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   893: iload 5
    //   895: invokevirtual 317	android/media/MediaPlayer:setLooping	(Z)V
    //   898: aload_0
    //   899: getfield 42	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   902: invokevirtual 195	android/media/MediaPlayer:start	()V
    //   905: aload_0
    //   906: iload 5
    //   908: putfield 48	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_loop	Z
    //   911: aload_0
    //   912: getfield 48	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_loop	Z
    //   915: iconst_1
    //   916: if_icmpne +16 -> 932
    //   919: aload_0
    //   920: iconst_1
    //   921: putfield 52	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_loopCount	I
    //   924: aload_0
    //   925: iconst_m1
    //   926: putfield 50	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_durationMS	I
    //   929: goto +25 -> 954
    //   932: aload_0
    //   933: iload 6
    //   935: putfield 52	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_loopCount	I
    //   938: aload_0
    //   939: aload_0
    //   940: getfield 52	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_loopCount	I
    //   943: aload_0
    //   944: getfield 42	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   947: invokevirtual 319	android/media/MediaPlayer:getDuration	()I
    //   950: imul
    //   951: putfield 50	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_durationMS	I
    //   954: aload_0
    //   955: aload_0
    //   956: getfield 52	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_loopCount	I
    //   959: iconst_1
    //   960: isub
    //   961: putfield 52	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_loopCount	I
    //   964: aload_0
    //   965: getfield 46	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_hasCall	Z
    //   968: ifne +9 -> 977
    //   971: aload 11
    //   973: iload_1
    //   974: invokevirtual 322	android/media/AudioManager:setMode	(I)V
    //   977: aload_0
    //   978: getfield 50	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_durationMS	I
    //   981: ifle +46 -> 1027
    //   984: aload_0
    //   985: new 244	java/util/Timer
    //   988: dup
    //   989: invokespecial 323	java/util/Timer:<init>	()V
    //   992: putfield 56	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_watchTimer	Ljava/util/Timer;
    //   995: aload_0
    //   996: new 325	com/tencent/rtmp/sharp/jni/TraeMediaPlayer$1
    //   999: dup
    //   1000: aload_0
    //   1001: invokespecial 328	com/tencent/rtmp/sharp/jni/TraeMediaPlayer$1:<init>	(Lcom/tencent/rtmp/sharp/jni/TraeMediaPlayer;)V
    //   1004: putfield 58	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_watchTimertask	Ljava/util/TimerTask;
    //   1007: aload_0
    //   1008: getfield 56	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_watchTimer	Ljava/util/Timer;
    //   1011: aload_0
    //   1012: getfield 58	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_watchTimertask	Ljava/util/TimerTask;
    //   1015: aload_0
    //   1016: getfield 50	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_durationMS	I
    //   1019: sipush 1000
    //   1022: iadd
    //   1023: i2l
    //   1024: invokevirtual 332	java/util/Timer:schedule	(Ljava/util/TimerTask;J)V
    //   1027: invokestatic 101	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   1030: ifeq +55 -> 1085
    //   1033: new 103	java/lang/StringBuilder
    //   1036: dup
    //   1037: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   1040: astore_3
    //   1041: aload_3
    //   1042: ldc_w 334
    //   1045: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1048: pop
    //   1049: aload_3
    //   1050: aload_0
    //   1051: getfield 42	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   1054: invokevirtual 319	android/media/MediaPlayer:getDuration	()I
    //   1057: invokevirtual 113	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1060: pop
    //   1061: aload_3
    //   1062: ldc 228
    //   1064: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1067: pop
    //   1068: aload_3
    //   1069: iload 5
    //   1071: invokevirtual 161	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1074: pop
    //   1075: ldc 123
    //   1077: iconst_2
    //   1078: aload_3
    //   1079: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1082: invokestatic 131	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1085: iconst_1
    //   1086: ireturn
    //   1087: astore_3
    //   1088: goto +83 -> 1171
    //   1091: astore_3
    //   1092: goto +146 -> 1238
    //   1095: astore_3
    //   1096: goto +209 -> 1305
    //   1099: astore_3
    //   1100: goto +273 -> 1373
    //   1103: astore_3
    //   1104: invokestatic 101	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   1107: ifeq +330 -> 1437
    //   1110: new 103	java/lang/StringBuilder
    //   1113: dup
    //   1114: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   1117: astore 4
    //   1119: aload 4
    //   1121: ldc_w 336
    //   1124: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1127: pop
    //   1128: aload 4
    //   1130: aload_3
    //   1131: invokevirtual 339	java/lang/SecurityException:getLocalizedMessage	()Ljava/lang/String;
    //   1134: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1137: pop
    //   1138: aload 4
    //   1140: ldc_w 341
    //   1143: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1146: pop
    //   1147: aload 4
    //   1149: aload_3
    //   1150: invokevirtual 342	java/lang/SecurityException:getMessage	()Ljava/lang/String;
    //   1153: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1156: pop
    //   1157: ldc 123
    //   1159: iconst_2
    //   1160: aload 4
    //   1162: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1165: invokestatic 172	com/tencent/rtmp/sharp/jni/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1168: goto +269 -> 1437
    //   1171: invokestatic 101	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   1174: ifeq +263 -> 1437
    //   1177: new 103	java/lang/StringBuilder
    //   1180: dup
    //   1181: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   1184: astore 4
    //   1186: aload 4
    //   1188: ldc_w 344
    //   1191: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1194: pop
    //   1195: aload 4
    //   1197: aload_3
    //   1198: invokevirtual 345	java/lang/IllegalArgumentException:getLocalizedMessage	()Ljava/lang/String;
    //   1201: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1204: pop
    //   1205: aload 4
    //   1207: ldc_w 341
    //   1210: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1213: pop
    //   1214: aload 4
    //   1216: aload_3
    //   1217: invokevirtual 346	java/lang/IllegalArgumentException:getMessage	()Ljava/lang/String;
    //   1220: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1223: pop
    //   1224: ldc 123
    //   1226: iconst_2
    //   1227: aload 4
    //   1229: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1232: invokestatic 172	com/tencent/rtmp/sharp/jni/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1235: goto +202 -> 1437
    //   1238: invokestatic 101	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   1241: ifeq +196 -> 1437
    //   1244: new 103	java/lang/StringBuilder
    //   1247: dup
    //   1248: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   1251: astore 4
    //   1253: aload 4
    //   1255: ldc_w 348
    //   1258: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1261: pop
    //   1262: aload 4
    //   1264: aload_3
    //   1265: invokevirtual 349	java/io/IOException:getLocalizedMessage	()Ljava/lang/String;
    //   1268: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1271: pop
    //   1272: aload 4
    //   1274: ldc_w 341
    //   1277: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1280: pop
    //   1281: aload 4
    //   1283: aload_3
    //   1284: invokevirtual 350	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1287: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1290: pop
    //   1291: ldc 123
    //   1293: iconst_2
    //   1294: aload 4
    //   1296: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1299: invokestatic 172	com/tencent/rtmp/sharp/jni/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1302: goto +135 -> 1437
    //   1305: invokestatic 101	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   1308: ifeq +129 -> 1437
    //   1311: new 103	java/lang/StringBuilder
    //   1314: dup
    //   1315: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   1318: astore 4
    //   1320: aload 4
    //   1322: ldc_w 352
    //   1325: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1328: pop
    //   1329: aload 4
    //   1331: aload_3
    //   1332: invokevirtual 353	java/lang/IllegalStateException:getLocalizedMessage	()Ljava/lang/String;
    //   1335: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1338: pop
    //   1339: aload 4
    //   1341: ldc_w 341
    //   1344: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1347: pop
    //   1348: aload 4
    //   1350: aload_3
    //   1351: invokevirtual 354	java/lang/IllegalStateException:getMessage	()Ljava/lang/String;
    //   1354: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1357: pop
    //   1358: ldc 123
    //   1360: iconst_2
    //   1361: aload 4
    //   1363: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1366: invokestatic 172	com/tencent/rtmp/sharp/jni/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1369: goto +68 -> 1437
    //   1372: astore_3
    //   1373: invokestatic 101	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   1376: ifeq +61 -> 1437
    //   1379: new 103	java/lang/StringBuilder
    //   1382: dup
    //   1383: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   1386: astore 4
    //   1388: aload 4
    //   1390: ldc_w 356
    //   1393: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1396: pop
    //   1397: aload 4
    //   1399: aload_3
    //   1400: invokevirtual 357	java/lang/Exception:getLocalizedMessage	()Ljava/lang/String;
    //   1403: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1406: pop
    //   1407: aload 4
    //   1409: ldc_w 341
    //   1412: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1415: pop
    //   1416: aload 4
    //   1418: aload_3
    //   1419: invokevirtual 140	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1422: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1425: pop
    //   1426: ldc 123
    //   1428: iconst_2
    //   1429: aload 4
    //   1431: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1434: invokestatic 172	com/tencent/rtmp/sharp/jni/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1437: aload_0
    //   1438: getfield 42	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   1441: invokevirtual 188	android/media/MediaPlayer:release	()V
    //   1444: aload_0
    //   1445: aconst_null
    //   1446: putfield 42	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   1449: iconst_0
    //   1450: ireturn
    //   1451: astore_3
    //   1452: goto -8 -> 1444
    //   1455: iconst_0
    //   1456: istore_1
    //   1457: goto -605 -> 852
    //   1460: astore_3
    //   1461: goto -88 -> 1373
    //   1464: astore_3
    //   1465: goto -294 -> 1171
    //   1468: astore_3
    //   1469: goto -231 -> 1238
    //   1472: astore_3
    //   1473: goto -168 -> 1305
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1476	0	this	TraeMediaPlayer
    //   0	1476	1	paramInt1	int
    //   0	1476	2	paramInt2	int
    //   0	1476	3	paramUri	android.net.Uri
    //   0	1476	4	paramString	java.lang.String
    //   0	1476	5	paramBoolean1	boolean
    //   0	1476	6	paramInt3	int
    //   0	1476	7	paramBoolean2	boolean
    //   0	1476	8	paramBoolean3	boolean
    //   0	1476	9	paramInt4	int
    //   315	3	10	bool	boolean
    //   91	213	11	localObject	Object
    //   343	28	11	localException	Exception
    //   448	524	11	localAudioManager	AudioManager
    //   13	370	12	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   324	331	339	finally
    //   345	360	339	finally
    //   324	331	343	java/lang/Exception
    //   360	390	393	finally
    //   308	317	1087	java/lang/IllegalArgumentException
    //   331	336	1087	java/lang/IllegalArgumentException
    //   397	402	1087	java/lang/IllegalArgumentException
    //   405	412	1087	java/lang/IllegalArgumentException
    //   412	436	1087	java/lang/IllegalArgumentException
    //   436	480	1087	java/lang/IllegalArgumentException
    //   482	498	1087	java/lang/IllegalArgumentException
    //   512	550	1087	java/lang/IllegalArgumentException
    //   550	562	1087	java/lang/IllegalArgumentException
    //   565	604	1087	java/lang/IllegalArgumentException
    //   604	613	1087	java/lang/IllegalArgumentException
    //   616	658	1087	java/lang/IllegalArgumentException
    //   658	670	1087	java/lang/IllegalArgumentException
    //   673	711	1087	java/lang/IllegalArgumentException
    //   711	723	1087	java/lang/IllegalArgumentException
    //   727	765	1087	java/lang/IllegalArgumentException
    //   765	777	1087	java/lang/IllegalArgumentException
    //   779	802	1087	java/lang/IllegalArgumentException
    //   802	809	1087	java/lang/IllegalArgumentException
    //   811	829	1087	java/lang/IllegalArgumentException
    //   834	847	1087	java/lang/IllegalArgumentException
    //   852	871	1087	java/lang/IllegalArgumentException
    //   871	929	1087	java/lang/IllegalArgumentException
    //   932	954	1087	java/lang/IllegalArgumentException
    //   954	977	1087	java/lang/IllegalArgumentException
    //   977	1027	1087	java/lang/IllegalArgumentException
    //   1027	1085	1087	java/lang/IllegalArgumentException
    //   308	317	1091	java/io/IOException
    //   331	336	1091	java/io/IOException
    //   397	402	1091	java/io/IOException
    //   405	412	1091	java/io/IOException
    //   412	436	1091	java/io/IOException
    //   436	480	1091	java/io/IOException
    //   482	498	1091	java/io/IOException
    //   512	550	1091	java/io/IOException
    //   550	562	1091	java/io/IOException
    //   565	604	1091	java/io/IOException
    //   604	613	1091	java/io/IOException
    //   616	658	1091	java/io/IOException
    //   658	670	1091	java/io/IOException
    //   673	711	1091	java/io/IOException
    //   711	723	1091	java/io/IOException
    //   727	765	1091	java/io/IOException
    //   765	777	1091	java/io/IOException
    //   779	802	1091	java/io/IOException
    //   802	809	1091	java/io/IOException
    //   811	829	1091	java/io/IOException
    //   834	847	1091	java/io/IOException
    //   852	871	1091	java/io/IOException
    //   871	929	1091	java/io/IOException
    //   932	954	1091	java/io/IOException
    //   954	977	1091	java/io/IOException
    //   977	1027	1091	java/io/IOException
    //   1027	1085	1091	java/io/IOException
    //   308	317	1095	java/lang/IllegalStateException
    //   331	336	1095	java/lang/IllegalStateException
    //   397	402	1095	java/lang/IllegalStateException
    //   405	412	1095	java/lang/IllegalStateException
    //   412	436	1095	java/lang/IllegalStateException
    //   436	480	1095	java/lang/IllegalStateException
    //   482	498	1095	java/lang/IllegalStateException
    //   512	550	1095	java/lang/IllegalStateException
    //   550	562	1095	java/lang/IllegalStateException
    //   565	604	1095	java/lang/IllegalStateException
    //   604	613	1095	java/lang/IllegalStateException
    //   616	658	1095	java/lang/IllegalStateException
    //   658	670	1095	java/lang/IllegalStateException
    //   673	711	1095	java/lang/IllegalStateException
    //   711	723	1095	java/lang/IllegalStateException
    //   727	765	1095	java/lang/IllegalStateException
    //   765	777	1095	java/lang/IllegalStateException
    //   779	802	1095	java/lang/IllegalStateException
    //   802	809	1095	java/lang/IllegalStateException
    //   811	829	1095	java/lang/IllegalStateException
    //   834	847	1095	java/lang/IllegalStateException
    //   852	871	1095	java/lang/IllegalStateException
    //   871	929	1095	java/lang/IllegalStateException
    //   932	954	1095	java/lang/IllegalStateException
    //   954	977	1095	java/lang/IllegalStateException
    //   977	1027	1095	java/lang/IllegalStateException
    //   1027	1085	1095	java/lang/IllegalStateException
    //   297	303	1099	java/lang/Exception
    //   308	317	1099	java/lang/Exception
    //   331	336	1099	java/lang/Exception
    //   397	402	1099	java/lang/Exception
    //   405	412	1099	java/lang/Exception
    //   412	436	1099	java/lang/Exception
    //   436	480	1099	java/lang/Exception
    //   482	498	1099	java/lang/Exception
    //   512	550	1099	java/lang/Exception
    //   550	562	1099	java/lang/Exception
    //   565	604	1099	java/lang/Exception
    //   604	613	1099	java/lang/Exception
    //   616	658	1099	java/lang/Exception
    //   658	670	1099	java/lang/Exception
    //   673	711	1099	java/lang/Exception
    //   711	723	1099	java/lang/Exception
    //   727	765	1099	java/lang/Exception
    //   765	777	1099	java/lang/Exception
    //   779	802	1099	java/lang/Exception
    //   802	809	1099	java/lang/Exception
    //   811	829	1099	java/lang/Exception
    //   834	847	1099	java/lang/Exception
    //   852	871	1099	java/lang/Exception
    //   871	929	1099	java/lang/Exception
    //   932	954	1099	java/lang/Exception
    //   954	977	1099	java/lang/Exception
    //   977	1027	1099	java/lang/Exception
    //   1027	1085	1099	java/lang/Exception
    //   297	303	1103	java/lang/SecurityException
    //   308	317	1103	java/lang/SecurityException
    //   331	336	1103	java/lang/SecurityException
    //   397	402	1103	java/lang/SecurityException
    //   405	412	1103	java/lang/SecurityException
    //   412	436	1103	java/lang/SecurityException
    //   436	480	1103	java/lang/SecurityException
    //   482	498	1103	java/lang/SecurityException
    //   512	550	1103	java/lang/SecurityException
    //   550	562	1103	java/lang/SecurityException
    //   565	604	1103	java/lang/SecurityException
    //   604	613	1103	java/lang/SecurityException
    //   616	658	1103	java/lang/SecurityException
    //   658	670	1103	java/lang/SecurityException
    //   673	711	1103	java/lang/SecurityException
    //   711	723	1103	java/lang/SecurityException
    //   727	765	1103	java/lang/SecurityException
    //   765	777	1103	java/lang/SecurityException
    //   779	802	1103	java/lang/SecurityException
    //   802	809	1103	java/lang/SecurityException
    //   811	829	1103	java/lang/SecurityException
    //   834	847	1103	java/lang/SecurityException
    //   852	871	1103	java/lang/SecurityException
    //   871	929	1103	java/lang/SecurityException
    //   932	954	1103	java/lang/SecurityException
    //   954	977	1103	java/lang/SecurityException
    //   977	1027	1103	java/lang/SecurityException
    //   1027	1085	1103	java/lang/SecurityException
    //   1138	1168	1372	java/lang/Exception
    //   1171	1235	1372	java/lang/Exception
    //   1238	1302	1372	java/lang/Exception
    //   1305	1369	1372	java/lang/Exception
    //   1437	1444	1451	java/lang/Exception
    //   1104	1138	1460	java/lang/Exception
    //   297	303	1464	java/lang/IllegalArgumentException
    //   297	303	1468	java/io/IOException
    //   297	303	1472	java/lang/IllegalStateException
  }
  
  public void stopRing()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TRAE", 2, "TraeMediaPlay stopRing ");
    }
    MediaPlayer localMediaPlayer = this.mMediaPlay;
    if (localMediaPlayer == null) {
      return;
    }
    if (localMediaPlayer.isPlaying()) {
      this.mMediaPlay.stop();
    }
    this.mMediaPlay.reset();
    try
    {
      if (this._watchTimer != null)
      {
        this._watchTimer.cancel();
        this._watchTimer = null;
        this._watchTimertask = null;
      }
      this.mMediaPlay.release();
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("release MediaPlayer failed.");
        localStringBuilder.append(localException.getMessage());
        QLog.e("TRAE", 2, localStringBuilder.toString());
      }
    }
    this.mMediaPlay = null;
    this._durationMS = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.rtmp.sharp.jni.TraeMediaPlayer
 * JD-Core Version:    0.7.0.1
 */