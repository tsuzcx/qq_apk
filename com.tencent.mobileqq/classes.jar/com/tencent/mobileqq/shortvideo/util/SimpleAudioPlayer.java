package com.tencent.mobileqq.shortvideo.util;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.sveffects.Logger;
import com.tencent.sveffects.SdkContext;
import java.io.File;

public class SimpleAudioPlayer
  implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener
{
  public static int INVALID_AUDIO_STREAM = -999;
  public static final String TAG = "SimpleAudioPlayer";
  private SimpleAudioPlayer.AmrPlayerThread mPlayThread;
  private MediaPlayer mPlayer;
  private int mSeekToTime = -1;
  private volatile int phoneAudioStream = INVALID_AUDIO_STREAM;
  private String sourcePath;
  
  /* Error */
  private boolean play(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_2
    //   3: istore_3
    //   4: iload_2
    //   5: ifge +5 -> 10
    //   8: iconst_0
    //   9: istore_3
    //   10: invokestatic 55	java/lang/System:currentTimeMillis	()J
    //   13: lstore 4
    //   15: aload_0
    //   16: aload_1
    //   17: putfield 38	com/tencent/mobileqq/shortvideo/util/SimpleAudioPlayer:sourcePath	Ljava/lang/String;
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 59	com/tencent/mobileqq/shortvideo/util/SimpleAudioPlayer:fileExistsAndNotEmpty	(Ljava/lang/String;)Z
    //   25: ifne +71 -> 96
    //   28: invokestatic 65	com/tencent/sveffects/SdkContext:getInstance	()Lcom/tencent/sveffects/SdkContext;
    //   31: invokevirtual 69	com/tencent/sveffects/SdkContext:getLogger	()Lcom/tencent/sveffects/Logger;
    //   34: invokeinterface 75 1 0
    //   39: ifeq +49 -> 88
    //   42: invokestatic 65	com/tencent/sveffects/SdkContext:getInstance	()Lcom/tencent/sveffects/SdkContext;
    //   45: invokevirtual 69	com/tencent/sveffects/SdkContext:getLogger	()Lcom/tencent/sveffects/Logger;
    //   48: astore 6
    //   50: new 77	java/lang/StringBuilder
    //   53: dup
    //   54: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   57: astore 7
    //   59: aload 7
    //   61: ldc 80
    //   63: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: pop
    //   67: aload 7
    //   69: aload_1
    //   70: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: pop
    //   74: aload 6
    //   76: ldc 15
    //   78: aload 7
    //   80: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: invokeinterface 92 3 0
    //   88: aload_0
    //   89: invokevirtual 95	com/tencent/mobileqq/shortvideo/util/SimpleAudioPlayer:stop	()V
    //   92: aload_0
    //   93: monitorexit
    //   94: iconst_0
    //   95: ireturn
    //   96: aload_0
    //   97: invokespecial 98	com/tencent/mobileqq/shortvideo/util/SimpleAudioPlayer:stopPlaying	()V
    //   100: aload_0
    //   101: new 100	com/tencent/qqlive/module/videoreport/dtreport/audio/playback/ReportMediaPlayer
    //   104: dup
    //   105: invokespecial 101	com/tencent/qqlive/module/videoreport/dtreport/audio/playback/ReportMediaPlayer:<init>	()V
    //   108: putfield 44	com/tencent/mobileqq/shortvideo/util/SimpleAudioPlayer:mPlayer	Landroid/media/MediaPlayer;
    //   111: aload_0
    //   112: getfield 44	com/tencent/mobileqq/shortvideo/util/SimpleAudioPlayer:mPlayer	Landroid/media/MediaPlayer;
    //   115: aload_1
    //   116: invokevirtual 107	android/media/MediaPlayer:setDataSource	(Ljava/lang/String;)V
    //   119: aload_0
    //   120: iload_3
    //   121: putfield 34	com/tencent/mobileqq/shortvideo/util/SimpleAudioPlayer:mSeekToTime	I
    //   124: aload_0
    //   125: getfield 44	com/tencent/mobileqq/shortvideo/util/SimpleAudioPlayer:mPlayer	Landroid/media/MediaPlayer;
    //   128: aload_0
    //   129: invokevirtual 111	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   132: aload_0
    //   133: getfield 44	com/tencent/mobileqq/shortvideo/util/SimpleAudioPlayer:mPlayer	Landroid/media/MediaPlayer;
    //   136: aload_0
    //   137: invokevirtual 115	android/media/MediaPlayer:setOnErrorListener	(Landroid/media/MediaPlayer$OnErrorListener;)V
    //   140: aload_0
    //   141: getfield 117	com/tencent/mobileqq/shortvideo/util/SimpleAudioPlayer:mPlayThread	Lcom/tencent/mobileqq/shortvideo/util/SimpleAudioPlayer$AmrPlayerThread;
    //   144: ifnonnull +23 -> 167
    //   147: aload_0
    //   148: new 119	com/tencent/mobileqq/shortvideo/util/SimpleAudioPlayer$AmrPlayerThread
    //   151: dup
    //   152: aload_0
    //   153: aconst_null
    //   154: invokespecial 122	com/tencent/mobileqq/shortvideo/util/SimpleAudioPlayer$AmrPlayerThread:<init>	(Lcom/tencent/mobileqq/shortvideo/util/SimpleAudioPlayer;Lcom/tencent/mobileqq/shortvideo/util/SimpleAudioPlayer$1;)V
    //   157: putfield 117	com/tencent/mobileqq/shortvideo/util/SimpleAudioPlayer:mPlayThread	Lcom/tencent/mobileqq/shortvideo/util/SimpleAudioPlayer$AmrPlayerThread;
    //   160: aload_0
    //   161: getfield 117	com/tencent/mobileqq/shortvideo/util/SimpleAudioPlayer:mPlayThread	Lcom/tencent/mobileqq/shortvideo/util/SimpleAudioPlayer$AmrPlayerThread;
    //   164: invokevirtual 125	com/tencent/mobileqq/shortvideo/util/SimpleAudioPlayer$AmrPlayerThread:start	()V
    //   167: invokestatic 65	com/tencent/sveffects/SdkContext:getInstance	()Lcom/tencent/sveffects/SdkContext;
    //   170: invokevirtual 69	com/tencent/sveffects/SdkContext:getLogger	()Lcom/tencent/sveffects/Logger;
    //   173: invokeinterface 75 1 0
    //   178: ifeq +52 -> 230
    //   181: invokestatic 65	com/tencent/sveffects/SdkContext:getInstance	()Lcom/tencent/sveffects/SdkContext;
    //   184: invokevirtual 69	com/tencent/sveffects/SdkContext:getLogger	()Lcom/tencent/sveffects/Logger;
    //   187: astore_1
    //   188: new 77	java/lang/StringBuilder
    //   191: dup
    //   192: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   195: astore 6
    //   197: aload 6
    //   199: ldc 127
    //   201: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: pop
    //   205: aload 6
    //   207: invokestatic 55	java/lang/System:currentTimeMillis	()J
    //   210: lload 4
    //   212: lsub
    //   213: invokevirtual 130	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   216: pop
    //   217: aload_1
    //   218: ldc 15
    //   220: aload 6
    //   222: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   225: invokeinterface 92 3 0
    //   230: aload_0
    //   231: monitorexit
    //   232: iconst_1
    //   233: ireturn
    //   234: astore_1
    //   235: invokestatic 65	com/tencent/sveffects/SdkContext:getInstance	()Lcom/tencent/sveffects/SdkContext;
    //   238: invokevirtual 69	com/tencent/sveffects/SdkContext:getLogger	()Lcom/tencent/sveffects/Logger;
    //   241: invokeinterface 75 1 0
    //   246: ifeq +19 -> 265
    //   249: invokestatic 65	com/tencent/sveffects/SdkContext:getInstance	()Lcom/tencent/sveffects/SdkContext;
    //   252: invokevirtual 69	com/tencent/sveffects/SdkContext:getLogger	()Lcom/tencent/sveffects/Logger;
    //   255: ldc 15
    //   257: ldc 132
    //   259: aload_1
    //   260: invokeinterface 136 4 0
    //   265: aload_0
    //   266: aload_0
    //   267: getfield 44	com/tencent/mobileqq/shortvideo/util/SimpleAudioPlayer:mPlayer	Landroid/media/MediaPlayer;
    //   270: iconst_0
    //   271: iconst_0
    //   272: invokevirtual 140	com/tencent/mobileqq/shortvideo/util/SimpleAudioPlayer:onError	(Landroid/media/MediaPlayer;II)Z
    //   275: pop
    //   276: aload_0
    //   277: monitorexit
    //   278: iconst_0
    //   279: ireturn
    //   280: astore_1
    //   281: aload_0
    //   282: monitorexit
    //   283: aload_1
    //   284: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	285	0	this	SimpleAudioPlayer
    //   0	285	1	paramString	String
    //   0	285	2	paramInt	int
    //   3	118	3	i	int
    //   13	198	4	l	long
    //   48	173	6	localObject	Object
    //   57	22	7	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   96	167	234	java/lang/Exception
    //   10	88	280	finally
    //   88	92	280	finally
    //   96	167	280	finally
    //   167	230	280	finally
    //   235	265	280	finally
    //   265	276	280	finally
  }
  
  private void stopPlaying()
  {
    MediaPlayer localMediaPlayer = this.mPlayer;
    if (localMediaPlayer != null)
    {
      if (localMediaPlayer.isPlaying())
      {
        this.mPlayer.stop();
        this.mPlayThread = null;
      }
      this.mPlayer.reset();
      this.mPlayer.release();
      this.mPlayer = null;
    }
  }
  
  public boolean fileExistsAndNotEmpty(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    paramString = new File(paramString);
    return (paramString.exists()) && (paramString.length() > 0L);
  }
  
  public boolean isPlaying()
  {
    try
    {
      MediaPlayer localMediaPlayer = this.mPlayer;
      boolean bool2 = false;
      if (localMediaPlayer == null) {
        return false;
      }
      boolean bool1;
      try
      {
        bool1 = this.mPlayer.isPlaying();
      }
      catch (IllegalStateException localIllegalStateException)
      {
        bool1 = bool2;
        if (SdkContext.getInstance().getLogger().isEnable())
        {
          SdkContext.getInstance().getLogger().e("SimpleAudioPlayer", "isPlaying on error, ", localIllegalStateException);
          bool1 = bool2;
        }
      }
      return bool1;
    }
    finally {}
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    this.mPlayThread = null;
    stop();
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    this.mPlayThread = null;
    stop();
    paramMediaPlayer = SdkContext.getInstance().getLogger();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("playSimpleAudio ");
    localStringBuilder.append(this.sourcePath);
    localStringBuilder.append("onError: ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(",");
    localStringBuilder.append(paramInt2);
    paramMediaPlayer.e("SimpleAudioPlayer", localStringBuilder.toString());
    return true;
  }
  
  public boolean play(String paramString)
  {
    return play(paramString, 0);
  }
  
  public boolean seekPlay(String paramString, int paramInt)
  {
    return play(paramString, paramInt);
  }
  
  public void setAudioStream(int paramInt)
  {
    this.phoneAudioStream = paramInt;
  }
  
  public void stop()
  {
    try
    {
      if (this.mPlayer != null)
      {
        if (this.mPlayer.isPlaying())
        {
          this.mPlayer.stop();
          this.mPlayThread = null;
        }
        this.mPlayer.reset();
        this.mPlayer.release();
        this.sourcePath = null;
        this.mPlayer = null;
        this.phoneAudioStream = INVALID_AUDIO_STREAM;
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.util.SimpleAudioPlayer
 * JD-Core Version:    0.7.0.1
 */