package com.tencent.qqmusic.mediaplayer;

import android.media.AudioTrack;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qqmusic.mediaplayer.audiofx.IAudioListener;
import com.tencent.qqmusic.mediaplayer.codec.BaseDecoder;
import com.tencent.qqmusic.mediaplayer.perf.PerformanceTracer;
import com.tencent.qqmusic.mediaplayer.perf.PrefInfoCollector;
import com.tencent.qqmusic.mediaplayer.seektable.NativeSeekTable;
import com.tencent.qqmusic.mediaplayer.seektable.SeekTable;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import com.tencent.qqmusic.mediaplayer.upstream.INativeDataSource;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.util.concurrent.atomic.AtomicInteger;

class CorePlayer
  implements BaseDecodeDataComponent.HandleDecodeDataCallback, Runnable
{
  private static final AtomicInteger PLAYER_ID_CREATOR = new AtomicInteger(0);
  private static final String TAG = "CorePlayer";
  @NonNull
  private final PlayerCallback mCallback;
  @Nullable
  private IDataSource mDataSource;
  @NonNull
  private final BaseDecoder mDecoder;
  @NonNull
  private final Handler mEventHandler;
  @NonNull
  private final QMThreadExecutor mExecutor;
  protected AudioInformation mInformation;
  volatile boolean mIsExit = false;
  @Nullable
  private INativeDataSource mNativeDataSource;
  private BaseDecodeDataComponent mPcmCompnent;
  private String mPlayPath = null;
  private int mPlayerID = PLAYER_ID_CREATOR.addAndGet(1);
  private int mPlayerMode = 0;
  @NonNull
  protected final PrefInfoCollector mPrefInfoCollector = PrefInfoCollector.getInstance();
  @Nullable
  private Float mSpeedToSet = null;
  @NonNull
  private final PlayerStateRunner mStateRunner = new PlayerStateRunner(Integer.valueOf(0));
  private String mThreadName = "Unnamed";
  @NonNull
  private final PerformanceTracer performanceTracer = new PerformanceTracer();
  
  CorePlayer(@Nullable IDataSource paramIDataSource, @Nullable INativeDataSource paramINativeDataSource, @NonNull PlayerCallback paramPlayerCallback, @NonNull Looper paramLooper, @NonNull BaseDecoder paramBaseDecoder, @NonNull QMThreadExecutor paramQMThreadExecutor)
  {
    if ((paramIDataSource != null) && (paramINativeDataSource != null)) {
      throw new IllegalArgumentException("you can't set IDataSource and INativeDataSource at the same time!");
    }
    if ((paramIDataSource == null) && (paramINativeDataSource == null)) {
      throw new IllegalArgumentException("at least on data source is required!");
    }
    this.mEventHandler = new Handler(paramLooper);
    this.mDecoder = paramBaseDecoder;
    this.mDataSource = paramIDataSource;
    this.mNativeDataSource = paramINativeDataSource;
    this.mCallback = paramPlayerCallback;
    this.mStateRunner.transfer(Integer.valueOf(1));
    this.mExecutor = paramQMThreadExecutor;
  }
  
  private String axiliary(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ID: ");
    localStringBuilder.append(this.mPlayerID);
    localStringBuilder.append(". ");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  private void callExceptionCallback(int paramInt1, int paramInt2)
  {
    callExceptionCallback(paramInt1, paramInt2, 0);
  }
  
  private void callExceptionCallback(int paramInt1, int paramInt2, int paramInt3)
  {
    this.mCallback.playerException(this, paramInt1, paramInt2, paramInt3);
  }
  
  private void decodeEndOrFailed(int paramInt1, int paramInt2)
  {
    Logger.d("CorePlayer", axiliary("decodeEndOrFailed"));
    for (;;)
    {
      try
      {
        if (this.mPcmCompnent == null)
        {
          Logger.e("CorePlayer", axiliary("mPcmCompnent null! Exiting"));
          return;
        }
        int i = paramInt1;
        if (this.mInformation != null)
        {
          Logger.i("CorePlayer", axiliary(String.format("current: %d, duration: %d, isExit: %b, decodeSucc: %b", new Object[] { Long.valueOf(this.mDecoder.getCurrentTime()), Long.valueOf(this.mInformation.getDuration()), Boolean.valueOf(this.mIsExit), Boolean.valueOf(this.mPcmCompnent.hasDecodeDataSuccess()) })));
          i = paramInt1 & this.mDecoder.getErrorCodeMask();
        }
        boolean bool = this.mIsExit;
        paramInt1 = 68;
        if ((!bool) && (this.mPcmCompnent.hasDecodeDataSuccess()))
        {
          if (getCurPositionByDecoder() < getDuration() - 5000L)
          {
            Logger.e("CorePlayer", axiliary("Decode failed! Exiting."));
            if ((!TextUtils.isEmpty(this.mPlayPath)) && (isPathExternalStorage(this.mPlayPath)))
            {
              callExceptionCallback(paramInt2, paramInt1, i);
              this.mStateRunner.transfer(Integer.valueOf(6));
            }
          }
          else
          {
            if (paramInt2 != 92) {
              break label322;
            }
            Logger.i("CorePlayer", axiliary("Decode ended! Exiting."));
            this.mStateRunner.transfer(Integer.valueOf(7));
          }
        }
        else
        {
          Logger.i("CorePlayer", axiliary("不留痕迹的退出 时机：解码时退出  step = 4"));
          exitNotCallback();
          this.mStateRunner.transfer(Integer.valueOf(9));
          if ((TextUtils.isEmpty(this.mPlayPath)) || (!isPathExternalStorage(this.mPlayPath))) {
            break label323;
          }
          callExceptionCallback(paramInt2, paramInt1, i);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        Logger.e("CorePlayer", localThrowable);
        return;
      }
      paramInt1 = 67;
      continue;
      label322:
      return;
      label323:
      paramInt1 = 67;
    }
  }
  
  private void exitNotCallback()
  {
    Logger.i("CorePlayer", axiliary("exitNotCallback"));
    this.mIsExit = true;
  }
  
  private boolean isPathExternalStorage(@NonNull String paramString)
  {
    return (!paramString.contains("emulated/0")) && (!paramString.contains("sdcard0"));
  }
  
  void addAudioListener(@NonNull IAudioListener paramIAudioListener)
  {
    BaseDecodeDataComponent localBaseDecodeDataComponent = this.mPcmCompnent;
    if (localBaseDecodeDataComponent != null) {
      localBaseDecodeDataComponent.addAudioListener(paramIAudioListener);
    }
  }
  
  void changePlayThreadPriorityImmediately()
  {
    Logger.d("CorePlayer", axiliary("changePlayThreadPriorityImmediately"));
    BaseDecodeDataComponent localBaseDecodeDataComponent = this.mPcmCompnent;
    if (localBaseDecodeDataComponent == null) {
      return;
    }
    localBaseDecodeDataComponent.changePlayThreadPriorityImmediately();
  }
  
  SeekTable createSeekTable()
  {
    BaseDecoder localBaseDecoder = this.mDecoder;
    if (localBaseDecoder != null) {
      return new NativeSeekTable(localBaseDecoder);
    }
    throw new IllegalStateException("please setDataSource before creating seek table!");
  }
  
  void flush()
  {
    BaseDecodeDataComponent localBaseDecodeDataComponent = this.mPcmCompnent;
    if (localBaseDecodeDataComponent != null) {
      localBaseDecodeDataComponent.flush();
    }
  }
  
  long getCurPosition()
  {
    BaseDecodeDataComponent localBaseDecodeDataComponent = this.mPcmCompnent;
    if (localBaseDecodeDataComponent == null) {
      return 0L;
    }
    return localBaseDecodeDataComponent.getCurPosition();
  }
  
  public long getCurPositionByDecoder()
  {
    try
    {
      long l = this.mDecoder.getCurrentTime();
      return l;
    }
    catch (Throwable localThrowable)
    {
      Logger.e("CorePlayer", "Strange Exception!", localThrowable);
    }
    catch (SoNotFindException localSoNotFindException)
    {
      Logger.e("CorePlayer", localSoNotFindException);
    }
    return 0L;
  }
  
  AudioInformation getCurrentAudioInformation()
  {
    return this.mInformation;
  }
  
  long getDuration()
  {
    AudioInformation localAudioInformation = this.mInformation;
    if (localAudioInformation != null) {
      try
      {
        long l = localAudioInformation.getDuration();
        return l;
      }
      catch (Throwable localThrowable)
      {
        Logger.e("CorePlayer", localThrowable);
      }
    }
    return 0L;
  }
  
  public long getMinPcmBufferSize()
  {
    return this.mDecoder.getMinBufferSize();
  }
  
  int getPlayerMode()
  {
    return this.mPlayerMode;
  }
  
  int getPlayerState()
  {
    BaseDecodeDataComponent localBaseDecodeDataComponent = this.mPcmCompnent;
    if (localBaseDecodeDataComponent == null) {
      return 0;
    }
    return localBaseDecodeDataComponent.getPlayerState();
  }
  
  int getSessionId()
  {
    BaseDecodeDataComponent localBaseDecodeDataComponent = this.mPcmCompnent;
    if (localBaseDecodeDataComponent != null) {
      return localBaseDecodeDataComponent.getSessionId();
    }
    return 0;
  }
  
  boolean hasDecodeData()
  {
    try
    {
      BaseDecodeDataComponent localBaseDecodeDataComponent = this.mPcmCompnent;
      if (localBaseDecodeDataComponent == null) {
        return false;
      }
      boolean bool = this.mPcmCompnent.hasDecodeData();
      return bool;
    }
    finally {}
  }
  
  boolean hasDecodeDataSuccess()
  {
    try
    {
      BaseDecodeDataComponent localBaseDecodeDataComponent = this.mPcmCompnent;
      if (localBaseDecodeDataComponent == null) {
        return false;
      }
      boolean bool = this.mPcmCompnent.hasDecodeDataSuccess();
      return bool;
    }
    finally {}
  }
  
  boolean isInit()
  {
    BaseDecodeDataComponent localBaseDecodeDataComponent = this.mPcmCompnent;
    if (localBaseDecodeDataComponent == null) {
      return false;
    }
    return localBaseDecodeDataComponent.isInit();
  }
  
  public void onAudioTrackChanged(AudioTrack paramAudioTrack)
  {
    this.mDecoder.setAudioTrack(paramAudioTrack);
  }
  
  public void onPullDecodeDataEndOrFailed(int paramInt1, int paramInt2)
  {
    decodeEndOrFailed(paramInt1, paramInt2);
  }
  
  void pause(boolean paramBoolean)
  {
    Logger.i("CorePlayer", axiliary("pause"));
    BaseDecodeDataComponent localBaseDecodeDataComponent = this.mPcmCompnent;
    if (localBaseDecodeDataComponent == null) {
      return;
    }
    localBaseDecodeDataComponent.pause(paramBoolean);
  }
  
  void play()
  {
    Logger.i("CorePlayer", axiliary("play"));
    BaseDecodeDataComponent localBaseDecodeDataComponent = this.mPcmCompnent;
    if (localBaseDecodeDataComponent == null) {
      return;
    }
    localBaseDecodeDataComponent.play();
  }
  
  public void prepare()
  {
    Logger.i("CorePlayer", axiliary("prepare"));
    this.mStateRunner.transfer(Integer.valueOf(3));
    this.mExecutor.execute(this, null);
  }
  
  public int pullDecodeData(int paramInt, byte[] paramArrayOfByte)
  {
    return this.mDecoder.decodeData(paramInt, paramArrayOfByte);
  }
  
  public void release()
  {
    Logger.i("CorePlayer", axiliary("release"));
    this.mEventHandler.removeCallbacksAndMessages(null);
    exitNotCallback();
    BaseDecodeDataComponent localBaseDecodeDataComponent = this.mPcmCompnent;
    if (localBaseDecodeDataComponent != null) {
      localBaseDecodeDataComponent.releaseNotify();
    }
    this.mStateRunner.transfer(Integer.valueOf(8));
  }
  
  void removeAudioListener(@NonNull IAudioListener paramIAudioListener)
  {
    BaseDecodeDataComponent localBaseDecodeDataComponent = this.mPcmCompnent;
    if (localBaseDecodeDataComponent != null) {
      localBaseDecodeDataComponent.removeAudioListener(paramIAudioListener);
    }
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: invokestatic 368	com/tencent/qqmusic/mediaplayer/util/CpuInfoUtil:startProcessInfoOutput	()V
    //   3: new 140	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   10: astore_3
    //   11: aload_3
    //   12: ldc_w 370
    //   15: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: pop
    //   19: aload_3
    //   20: invokestatic 376	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   23: invokevirtual 379	java/lang/Thread:getName	()Ljava/lang/String;
    //   26: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: ldc 14
    //   32: aload_0
    //   33: aload_3
    //   34: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: invokespecial 173	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   40: invokestatic 226	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   43: bipush 62
    //   45: istore_2
    //   46: aload_0
    //   47: getfield 129	com/tencent/qqmusic/mediaplayer/CorePlayer:mCallback	Lcom/tencent/qqmusic/mediaplayer/PlayerCallback;
    //   50: aload_0
    //   51: invokeinterface 383 2 0
    //   56: aload_0
    //   57: getfield 125	com/tencent/qqmusic/mediaplayer/CorePlayer:mDataSource	Lcom/tencent/qqmusic/mediaplayer/upstream/IDataSource;
    //   60: astore_3
    //   61: aload_3
    //   62: ifnull +62 -> 124
    //   65: aload_0
    //   66: getfield 123	com/tencent/qqmusic/mediaplayer/CorePlayer:mDecoder	Lcom/tencent/qqmusic/mediaplayer/codec/BaseDecoder;
    //   69: aload_0
    //   70: getfield 125	com/tencent/qqmusic/mediaplayer/CorePlayer:mDataSource	Lcom/tencent/qqmusic/mediaplayer/upstream/IDataSource;
    //   73: invokevirtual 387	com/tencent/qqmusic/mediaplayer/codec/BaseDecoder:init	(Lcom/tencent/qqmusic/mediaplayer/upstream/IDataSource;)I
    //   76: istore_1
    //   77: new 140	java/lang/StringBuilder
    //   80: dup
    //   81: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   84: astore_3
    //   85: aload_3
    //   86: ldc_w 389
    //   89: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: pop
    //   93: aload_3
    //   94: iload_1
    //   95: invokevirtual 150	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   98: pop
    //   99: ldc 14
    //   101: aload_0
    //   102: aload_3
    //   103: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   106: invokespecial 173	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   109: invokestatic 226	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   112: goto +85 -> 197
    //   115: astore 4
    //   117: ldc_w 391
    //   120: astore_3
    //   121: goto +1555 -> 1676
    //   124: aload_0
    //   125: getfield 127	com/tencent/qqmusic/mediaplayer/CorePlayer:mNativeDataSource	Lcom/tencent/qqmusic/mediaplayer/upstream/INativeDataSource;
    //   128: astore_3
    //   129: aload_3
    //   130: ifnull +53 -> 183
    //   133: aload_0
    //   134: getfield 123	com/tencent/qqmusic/mediaplayer/CorePlayer:mDecoder	Lcom/tencent/qqmusic/mediaplayer/codec/BaseDecoder;
    //   137: aload_0
    //   138: getfield 127	com/tencent/qqmusic/mediaplayer/CorePlayer:mNativeDataSource	Lcom/tencent/qqmusic/mediaplayer/upstream/INativeDataSource;
    //   141: invokevirtual 394	com/tencent/qqmusic/mediaplayer/codec/BaseDecoder:init	(Lcom/tencent/qqmusic/mediaplayer/upstream/INativeDataSource;)I
    //   144: istore_1
    //   145: new 140	java/lang/StringBuilder
    //   148: dup
    //   149: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   152: astore_3
    //   153: aload_3
    //   154: ldc_w 396
    //   157: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: pop
    //   161: aload_3
    //   162: iload_1
    //   163: invokevirtual 150	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   166: pop
    //   167: ldc 14
    //   169: aload_0
    //   170: aload_3
    //   171: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   174: invokespecial 173	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   177: invokestatic 226	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   180: goto +17 -> 197
    //   183: iconst_m1
    //   184: istore_1
    //   185: ldc 14
    //   187: aload_0
    //   188: ldc_w 398
    //   191: invokespecial 173	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   194: invokestatic 226	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   197: iload_1
    //   198: bipush 247
    //   200: if_icmpne +72 -> 272
    //   203: ldc 14
    //   205: aload_0
    //   206: ldc_w 400
    //   209: invokespecial 173	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   212: invokestatic 186	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   215: aload_0
    //   216: getfield 74	com/tencent/qqmusic/mediaplayer/CorePlayer:mStateRunner	Lcom/tencent/qqmusic/mediaplayer/PlayerStateRunner;
    //   219: bipush 9
    //   221: invokestatic 69	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   224: invokevirtual 133	com/tencent/qqmusic/mediaplayer/PlayerStateRunner:transfer	(Ljava/lang/Integer;)Ljava/lang/Integer;
    //   227: pop
    //   228: aload_0
    //   229: getfield 105	com/tencent/qqmusic/mediaplayer/CorePlayer:mPlayPath	Ljava/lang/String;
    //   232: invokestatic 244	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   235: ifne +25 -> 260
    //   238: aload_0
    //   239: aload_0
    //   240: getfield 105	com/tencent/qqmusic/mediaplayer/CorePlayer:mPlayPath	Ljava/lang/String;
    //   243: invokespecial 248	com/tencent/qqmusic/mediaplayer/CorePlayer:isPathExternalStorage	(Ljava/lang/String;)Z
    //   246: ifeq +14 -> 260
    //   249: aload_0
    //   250: bipush 91
    //   252: bipush 100
    //   254: invokespecial 402	com/tencent/qqmusic/mediaplayer/CorePlayer:callExceptionCallback	(II)V
    //   257: goto +334 -> 591
    //   260: aload_0
    //   261: bipush 91
    //   263: sipush 200
    //   266: invokespecial 402	com/tencent/qqmusic/mediaplayer/CorePlayer:callExceptionCallback	(II)V
    //   269: goto +322 -> 591
    //   272: iload_1
    //   273: ifeq +307 -> 580
    //   276: ldc 14
    //   278: aload_0
    //   279: ldc_w 404
    //   282: invokespecial 173	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   285: invokestatic 186	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   288: aload_0
    //   289: getfield 74	com/tencent/qqmusic/mediaplayer/CorePlayer:mStateRunner	Lcom/tencent/qqmusic/mediaplayer/PlayerStateRunner;
    //   292: bipush 9
    //   294: invokestatic 69	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   297: invokevirtual 133	com/tencent/qqmusic/mediaplayer/PlayerStateRunner:transfer	(Ljava/lang/Integer;)Ljava/lang/Integer;
    //   300: pop
    //   301: iload_1
    //   302: bipush 254
    //   304: if_icmpne +1643 -> 1947
    //   307: aload_0
    //   308: getfield 105	com/tencent/qqmusic/mediaplayer/CorePlayer:mPlayPath	Ljava/lang/String;
    //   311: invokestatic 244	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   314: ifne +1627 -> 1941
    //   317: aload_0
    //   318: aload_0
    //   319: getfield 105	com/tencent/qqmusic/mediaplayer/CorePlayer:mPlayPath	Ljava/lang/String;
    //   322: invokespecial 248	com/tencent/qqmusic/mediaplayer/CorePlayer:isPathExternalStorage	(Ljava/lang/String;)Z
    //   325: ifeq +1616 -> 1941
    //   328: bipush 56
    //   330: istore_1
    //   331: goto +3 -> 334
    //   334: aload_0
    //   335: bipush 91
    //   337: iload_1
    //   338: invokespecial 402	com/tencent/qqmusic/mediaplayer/CorePlayer:callExceptionCallback	(II)V
    //   341: aload_0
    //   342: getfield 181	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   345: ifnull +44 -> 389
    //   348: new 140	java/lang/StringBuilder
    //   351: dup
    //   352: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   355: astore_3
    //   356: aload_3
    //   357: ldc_w 406
    //   360: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   363: pop
    //   364: aload_3
    //   365: aload_0
    //   366: getfield 90	com/tencent/qqmusic/mediaplayer/CorePlayer:mIsExit	Z
    //   369: invokevirtual 409	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   372: pop
    //   373: ldc 14
    //   375: aload_0
    //   376: aload_3
    //   377: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   380: invokespecial 173	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   383: invokestatic 226	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   386: goto +15 -> 401
    //   389: ldc 14
    //   391: aload_0
    //   392: ldc_w 411
    //   395: invokespecial 173	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   398: invokestatic 186	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   401: invokestatic 414	com/tencent/qqmusic/mediaplayer/util/CpuInfoUtil:stopProcessInfoOutput	()V
    //   404: aload_0
    //   405: getfield 123	com/tencent/qqmusic/mediaplayer/CorePlayer:mDecoder	Lcom/tencent/qqmusic/mediaplayer/codec/BaseDecoder;
    //   408: invokevirtual 416	com/tencent/qqmusic/mediaplayer/codec/BaseDecoder:release	()I
    //   411: pop
    //   412: goto +47 -> 459
    //   415: astore_3
    //   416: new 140	java/lang/StringBuilder
    //   419: dup
    //   420: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   423: astore 4
    //   425: aload 4
    //   427: ldc_w 418
    //   430: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   433: pop
    //   434: aload 4
    //   436: aload_3
    //   437: invokevirtual 421	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   440: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   443: pop
    //   444: ldc 14
    //   446: aload_0
    //   447: aload 4
    //   449: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   452: invokespecial 173	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   455: aload_3
    //   456: invokestatic 299	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   459: aload_0
    //   460: getfield 125	com/tencent/qqmusic/mediaplayer/CorePlayer:mDataSource	Lcom/tencent/qqmusic/mediaplayer/upstream/IDataSource;
    //   463: astore_3
    //   464: aload_3
    //   465: ifnull +56 -> 521
    //   468: aload_3
    //   469: invokeinterface 426 1 0
    //   474: goto +47 -> 521
    //   477: astore_3
    //   478: new 140	java/lang/StringBuilder
    //   481: dup
    //   482: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   485: astore 4
    //   487: aload 4
    //   489: ldc_w 428
    //   492: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   495: pop
    //   496: aload 4
    //   498: aload_3
    //   499: invokevirtual 429	java/io/IOException:getMessage	()Ljava/lang/String;
    //   502: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   505: pop
    //   506: ldc 14
    //   508: aload_0
    //   509: aload 4
    //   511: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   514: invokespecial 173	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   517: aload_3
    //   518: invokestatic 299	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   521: aload_0
    //   522: getfield 181	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   525: astore_3
    //   526: aload_3
    //   527: ifnull +7 -> 534
    //   530: aload_3
    //   531: invokevirtual 431	com/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent:release	()V
    //   534: aload_0
    //   535: iconst_0
    //   536: putfield 88	com/tencent/qqmusic/mediaplayer/CorePlayer:mPlayerMode	I
    //   539: new 140	java/lang/StringBuilder
    //   542: dup
    //   543: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   546: astore_3
    //   547: aload_3
    //   548: ldc_w 391
    //   551: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   554: pop
    //   555: aload_3
    //   556: invokestatic 376	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   559: invokevirtual 379	java/lang/Thread:getName	()Ljava/lang/String;
    //   562: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   565: pop
    //   566: ldc 14
    //   568: aload_0
    //   569: aload_3
    //   570: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   573: invokespecial 173	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   576: invokestatic 226	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   579: return
    //   580: aload_0
    //   581: aload_0
    //   582: getfield 123	com/tencent/qqmusic/mediaplayer/CorePlayer:mDecoder	Lcom/tencent/qqmusic/mediaplayer/codec/BaseDecoder;
    //   585: invokevirtual 434	com/tencent/qqmusic/mediaplayer/codec/BaseDecoder:getAudioInformation	()Lcom/tencent/qqmusic/mediaplayer/AudioInformation;
    //   588: putfield 188	com/tencent/qqmusic/mediaplayer/CorePlayer:mInformation	Lcom/tencent/qqmusic/mediaplayer/AudioInformation;
    //   591: invokestatic 439	com/tencent/qqmusic/mediaplayer/PlayerConfigManager:getInstance	()Lcom/tencent/qqmusic/mediaplayer/PlayerConfigManager;
    //   594: aload_0
    //   595: invokevirtual 442	com/tencent/qqmusic/mediaplayer/PlayerConfigManager:setCommonPlayerRef	(Lcom/tencent/qqmusic/mediaplayer/CorePlayer;)V
    //   598: aload_0
    //   599: getfield 188	com/tencent/qqmusic/mediaplayer/CorePlayer:mInformation	Lcom/tencent/qqmusic/mediaplayer/AudioInformation;
    //   602: astore_3
    //   603: aload_3
    //   604: ifnull +189 -> 793
    //   607: aload_0
    //   608: getfield 90	com/tencent/qqmusic/mediaplayer/CorePlayer:mIsExit	Z
    //   611: ifne +182 -> 793
    //   614: aload_0
    //   615: getfield 181	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   618: ifnonnull +175 -> 793
    //   621: aload_0
    //   622: getfield 188	com/tencent/qqmusic/mediaplayer/CorePlayer:mInformation	Lcom/tencent/qqmusic/mediaplayer/AudioInformation;
    //   625: invokevirtual 206	com/tencent/qqmusic/mediaplayer/AudioInformation:getDuration	()J
    //   628: ldc2_w 443
    //   631: lcmp
    //   632: iflt +66 -> 698
    //   635: aload_0
    //   636: getfield 88	com/tencent/qqmusic/mediaplayer/CorePlayer:mPlayerMode	I
    //   639: iconst_1
    //   640: if_icmpne +6 -> 646
    //   643: goto +55 -> 698
    //   646: aload_0
    //   647: getfield 74	com/tencent/qqmusic/mediaplayer/CorePlayer:mStateRunner	Lcom/tencent/qqmusic/mediaplayer/PlayerStateRunner;
    //   650: astore_3
    //   651: aload_0
    //   652: getfield 188	com/tencent/qqmusic/mediaplayer/CorePlayer:mInformation	Lcom/tencent/qqmusic/mediaplayer/AudioInformation;
    //   655: astore 4
    //   657: aload_0
    //   658: getfield 129	com/tencent/qqmusic/mediaplayer/CorePlayer:mCallback	Lcom/tencent/qqmusic/mediaplayer/PlayerCallback;
    //   661: astore 5
    //   663: aload_0
    //   664: getfield 121	com/tencent/qqmusic/mediaplayer/CorePlayer:mEventHandler	Landroid/os/Handler;
    //   667: astore 6
    //   669: aload_0
    //   670: getfield 80	com/tencent/qqmusic/mediaplayer/CorePlayer:mPlayerID	I
    //   673: istore_1
    //   674: aload_0
    //   675: new 446	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent
    //   678: dup
    //   679: aload_0
    //   680: aload_3
    //   681: aload 4
    //   683: aload 5
    //   685: aload_0
    //   686: aload 6
    //   688: iload_1
    //   689: invokespecial 449	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:<init>	(Lcom/tencent/qqmusic/mediaplayer/CorePlayer;Lcom/tencent/qqmusic/mediaplayer/PlayerStateRunner;Lcom/tencent/qqmusic/mediaplayer/AudioInformation;Lcom/tencent/qqmusic/mediaplayer/PlayerCallback;Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent$HandleDecodeDataCallback;Landroid/os/Handler;I)V
    //   692: putfield 181	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   695: goto +49 -> 744
    //   698: aload_0
    //   699: getfield 88	com/tencent/qqmusic/mediaplayer/CorePlayer:mPlayerMode	I
    //   702: iconst_1
    //   703: if_icmpeq +8 -> 711
    //   706: aload_0
    //   707: iconst_1
    //   708: putfield 88	com/tencent/qqmusic/mediaplayer/CorePlayer:mPlayerMode	I
    //   711: aload_0
    //   712: new 451	com/tencent/qqmusic/mediaplayer/StaticDecodeDataComponent
    //   715: dup
    //   716: aload_0
    //   717: aload_0
    //   718: getfield 74	com/tencent/qqmusic/mediaplayer/CorePlayer:mStateRunner	Lcom/tencent/qqmusic/mediaplayer/PlayerStateRunner;
    //   721: aload_0
    //   722: getfield 188	com/tencent/qqmusic/mediaplayer/CorePlayer:mInformation	Lcom/tencent/qqmusic/mediaplayer/AudioInformation;
    //   725: aload_0
    //   726: getfield 129	com/tencent/qqmusic/mediaplayer/CorePlayer:mCallback	Lcom/tencent/qqmusic/mediaplayer/PlayerCallback;
    //   729: aload_0
    //   730: aload_0
    //   731: getfield 121	com/tencent/qqmusic/mediaplayer/CorePlayer:mEventHandler	Landroid/os/Handler;
    //   734: aload_0
    //   735: getfield 80	com/tencent/qqmusic/mediaplayer/CorePlayer:mPlayerID	I
    //   738: invokespecial 452	com/tencent/qqmusic/mediaplayer/StaticDecodeDataComponent:<init>	(Lcom/tencent/qqmusic/mediaplayer/CorePlayer;Lcom/tencent/qqmusic/mediaplayer/PlayerStateRunner;Lcom/tencent/qqmusic/mediaplayer/AudioInformation;Lcom/tencent/qqmusic/mediaplayer/PlayerCallback;Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent$HandleDecodeDataCallback;Landroid/os/Handler;I)V
    //   741: putfield 181	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   744: aload_0
    //   745: getfield 82	com/tencent/qqmusic/mediaplayer/CorePlayer:mSpeedToSet	Ljava/lang/Float;
    //   748: ifnull +45 -> 793
    //   751: aload_0
    //   752: getfield 181	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   755: aload_0
    //   756: getfield 82	com/tencent/qqmusic/mediaplayer/CorePlayer:mSpeedToSet	Ljava/lang/Float;
    //   759: invokevirtual 458	java/lang/Float:floatValue	()F
    //   762: invokevirtual 462	com/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent:setSpeed	(F)V
    //   765: aload_0
    //   766: aconst_null
    //   767: putfield 82	com/tencent/qqmusic/mediaplayer/CorePlayer:mSpeedToSet	Ljava/lang/Float;
    //   770: goto +23 -> 793
    //   773: astore_3
    //   774: ldc_w 391
    //   777: astore 5
    //   779: aload_3
    //   780: astore 4
    //   782: aload 5
    //   784: astore_3
    //   785: goto +891 -> 1676
    //   788: astore 4
    //   790: goto +251 -> 1041
    //   793: aload_0
    //   794: getfield 181	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   797: astore_3
    //   798: aload_3
    //   799: ifnull +17 -> 816
    //   802: aload_0
    //   803: getfield 181	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   806: invokevirtual 465	com/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent:handleDecodeData	()V
    //   809: goto +7 -> 816
    //   812: astore_3
    //   813: goto -39 -> 774
    //   816: aload_0
    //   817: getfield 181	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   820: ifnull +44 -> 864
    //   823: new 140	java/lang/StringBuilder
    //   826: dup
    //   827: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   830: astore_3
    //   831: aload_3
    //   832: ldc_w 406
    //   835: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   838: pop
    //   839: aload_3
    //   840: aload_0
    //   841: getfield 90	com/tencent/qqmusic/mediaplayer/CorePlayer:mIsExit	Z
    //   844: invokevirtual 409	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   847: pop
    //   848: ldc 14
    //   850: aload_0
    //   851: aload_3
    //   852: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   855: invokespecial 173	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   858: invokestatic 226	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   861: goto +15 -> 876
    //   864: ldc 14
    //   866: aload_0
    //   867: ldc_w 411
    //   870: invokespecial 173	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   873: invokestatic 186	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   876: invokestatic 414	com/tencent/qqmusic/mediaplayer/util/CpuInfoUtil:stopProcessInfoOutput	()V
    //   879: aload_0
    //   880: getfield 123	com/tencent/qqmusic/mediaplayer/CorePlayer:mDecoder	Lcom/tencent/qqmusic/mediaplayer/codec/BaseDecoder;
    //   883: invokevirtual 416	com/tencent/qqmusic/mediaplayer/codec/BaseDecoder:release	()I
    //   886: pop
    //   887: goto +47 -> 934
    //   890: astore_3
    //   891: new 140	java/lang/StringBuilder
    //   894: dup
    //   895: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   898: astore 4
    //   900: aload 4
    //   902: ldc_w 418
    //   905: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   908: pop
    //   909: aload 4
    //   911: aload_3
    //   912: invokevirtual 421	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   915: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   918: pop
    //   919: ldc 14
    //   921: aload_0
    //   922: aload 4
    //   924: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   927: invokespecial 173	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   930: aload_3
    //   931: invokestatic 299	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   934: aload_0
    //   935: getfield 125	com/tencent/qqmusic/mediaplayer/CorePlayer:mDataSource	Lcom/tencent/qqmusic/mediaplayer/upstream/IDataSource;
    //   938: astore_3
    //   939: aload_3
    //   940: ifnull +56 -> 996
    //   943: aload_3
    //   944: invokeinterface 426 1 0
    //   949: goto +47 -> 996
    //   952: astore_3
    //   953: new 140	java/lang/StringBuilder
    //   956: dup
    //   957: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   960: astore 4
    //   962: aload 4
    //   964: ldc_w 428
    //   967: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   970: pop
    //   971: aload 4
    //   973: aload_3
    //   974: invokevirtual 429	java/io/IOException:getMessage	()Ljava/lang/String;
    //   977: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   980: pop
    //   981: ldc 14
    //   983: aload_0
    //   984: aload 4
    //   986: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   989: invokespecial 173	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   992: aload_3
    //   993: invokestatic 299	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   996: aload_0
    //   997: getfield 181	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   1000: astore_3
    //   1001: aload_3
    //   1002: ifnull +7 -> 1009
    //   1005: aload_3
    //   1006: invokevirtual 431	com/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent:release	()V
    //   1009: aload_0
    //   1010: iconst_0
    //   1011: putfield 88	com/tencent/qqmusic/mediaplayer/CorePlayer:mPlayerMode	I
    //   1014: new 140	java/lang/StringBuilder
    //   1017: dup
    //   1018: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   1021: astore_3
    //   1022: ldc_w 391
    //   1025: astore 4
    //   1027: goto +617 -> 1644
    //   1030: astore 4
    //   1032: ldc_w 391
    //   1035: astore_3
    //   1036: goto +27 -> 1063
    //   1039: astore 4
    //   1041: ldc_w 391
    //   1044: astore_3
    //   1045: goto +360 -> 1405
    //   1048: astore 4
    //   1050: ldc_w 391
    //   1053: astore_3
    //   1054: goto +351 -> 1405
    //   1057: astore 4
    //   1059: ldc_w 391
    //   1062: astore_3
    //   1063: goto +613 -> 1676
    //   1066: astore 4
    //   1068: ldc_w 391
    //   1071: astore_3
    //   1072: aload_3
    //   1073: astore 5
    //   1075: aload 4
    //   1077: instanceof 294
    //   1080: ifeq +9 -> 1089
    //   1083: bipush 69
    //   1085: istore_1
    //   1086: goto +19 -> 1105
    //   1089: iload_2
    //   1090: istore_1
    //   1091: aload_3
    //   1092: astore 5
    //   1094: aload 4
    //   1096: instanceof 467
    //   1099: ifeq +6 -> 1105
    //   1102: bipush 60
    //   1104: istore_1
    //   1105: aload_3
    //   1106: astore 5
    //   1108: ldc 14
    //   1110: aload_0
    //   1111: ldc_w 469
    //   1114: invokespecial 173	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   1117: invokestatic 186	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1120: aload_3
    //   1121: astore 5
    //   1123: aload_0
    //   1124: getfield 74	com/tencent/qqmusic/mediaplayer/CorePlayer:mStateRunner	Lcom/tencent/qqmusic/mediaplayer/PlayerStateRunner;
    //   1127: bipush 9
    //   1129: invokestatic 69	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1132: invokevirtual 133	com/tencent/qqmusic/mediaplayer/PlayerStateRunner:transfer	(Ljava/lang/Integer;)Ljava/lang/Integer;
    //   1135: pop
    //   1136: aload_3
    //   1137: astore 5
    //   1139: aload_0
    //   1140: bipush 91
    //   1142: iload_1
    //   1143: invokespecial 402	com/tencent/qqmusic/mediaplayer/CorePlayer:callExceptionCallback	(II)V
    //   1146: aload_3
    //   1147: astore 5
    //   1149: ldc 14
    //   1151: ldc_w 471
    //   1154: aload 4
    //   1156: invokestatic 299	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1159: aload_0
    //   1160: getfield 181	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   1163: ifnull +48 -> 1211
    //   1166: new 140	java/lang/StringBuilder
    //   1169: dup
    //   1170: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   1173: astore 4
    //   1175: aload 4
    //   1177: ldc_w 406
    //   1180: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1183: pop
    //   1184: aload 4
    //   1186: aload_0
    //   1187: getfield 90	com/tencent/qqmusic/mediaplayer/CorePlayer:mIsExit	Z
    //   1190: invokevirtual 409	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1193: pop
    //   1194: ldc 14
    //   1196: aload_0
    //   1197: aload 4
    //   1199: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1202: invokespecial 173	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   1205: invokestatic 226	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1208: goto +15 -> 1223
    //   1211: ldc 14
    //   1213: aload_0
    //   1214: ldc_w 411
    //   1217: invokespecial 173	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   1220: invokestatic 186	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1223: invokestatic 414	com/tencent/qqmusic/mediaplayer/util/CpuInfoUtil:stopProcessInfoOutput	()V
    //   1226: aload_0
    //   1227: getfield 123	com/tencent/qqmusic/mediaplayer/CorePlayer:mDecoder	Lcom/tencent/qqmusic/mediaplayer/codec/BaseDecoder;
    //   1230: invokevirtual 416	com/tencent/qqmusic/mediaplayer/codec/BaseDecoder:release	()I
    //   1233: pop
    //   1234: goto +50 -> 1284
    //   1237: astore 4
    //   1239: new 140	java/lang/StringBuilder
    //   1242: dup
    //   1243: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   1246: astore 5
    //   1248: aload 5
    //   1250: ldc_w 418
    //   1253: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1256: pop
    //   1257: aload 5
    //   1259: aload 4
    //   1261: invokevirtual 421	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   1264: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1267: pop
    //   1268: ldc 14
    //   1270: aload_0
    //   1271: aload 5
    //   1273: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1276: invokespecial 173	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   1279: aload 4
    //   1281: invokestatic 299	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1284: aload_0
    //   1285: getfield 125	com/tencent/qqmusic/mediaplayer/CorePlayer:mDataSource	Lcom/tencent/qqmusic/mediaplayer/upstream/IDataSource;
    //   1288: astore 4
    //   1290: aload 4
    //   1292: ifnull +60 -> 1352
    //   1295: aload 4
    //   1297: invokeinterface 426 1 0
    //   1302: goto +50 -> 1352
    //   1305: astore 4
    //   1307: new 140	java/lang/StringBuilder
    //   1310: dup
    //   1311: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   1314: astore 5
    //   1316: aload 5
    //   1318: ldc_w 428
    //   1321: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1324: pop
    //   1325: aload 5
    //   1327: aload 4
    //   1329: invokevirtual 429	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1332: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1335: pop
    //   1336: ldc 14
    //   1338: aload_0
    //   1339: aload 5
    //   1341: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1344: invokespecial 173	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   1347: aload 4
    //   1349: invokestatic 299	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1352: aload_0
    //   1353: getfield 181	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   1356: astore 4
    //   1358: aload 4
    //   1360: ifnull +8 -> 1368
    //   1363: aload 4
    //   1365: invokevirtual 431	com/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent:release	()V
    //   1368: aload_0
    //   1369: iconst_0
    //   1370: putfield 88	com/tencent/qqmusic/mediaplayer/CorePlayer:mPlayerMode	I
    //   1373: new 140	java/lang/StringBuilder
    //   1376: dup
    //   1377: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   1380: astore 4
    //   1382: aload 4
    //   1384: aload_3
    //   1385: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1388: pop
    //   1389: aload 4
    //   1391: astore_3
    //   1392: goto -837 -> 555
    //   1395: astore 4
    //   1397: aload 5
    //   1399: astore_3
    //   1400: goto -337 -> 1063
    //   1403: astore 4
    //   1405: aload_3
    //   1406: astore 5
    //   1408: ldc 14
    //   1410: aload 4
    //   1412: invokestatic 258	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1415: aload_0
    //   1416: getfield 181	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   1419: ifnull +48 -> 1467
    //   1422: new 140	java/lang/StringBuilder
    //   1425: dup
    //   1426: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   1429: astore 4
    //   1431: aload 4
    //   1433: ldc_w 406
    //   1436: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1439: pop
    //   1440: aload 4
    //   1442: aload_0
    //   1443: getfield 90	com/tencent/qqmusic/mediaplayer/CorePlayer:mIsExit	Z
    //   1446: invokevirtual 409	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1449: pop
    //   1450: ldc 14
    //   1452: aload_0
    //   1453: aload 4
    //   1455: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1458: invokespecial 173	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   1461: invokestatic 226	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1464: goto +15 -> 1479
    //   1467: ldc 14
    //   1469: aload_0
    //   1470: ldc_w 411
    //   1473: invokespecial 173	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   1476: invokestatic 186	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1479: invokestatic 414	com/tencent/qqmusic/mediaplayer/util/CpuInfoUtil:stopProcessInfoOutput	()V
    //   1482: aload_0
    //   1483: getfield 123	com/tencent/qqmusic/mediaplayer/CorePlayer:mDecoder	Lcom/tencent/qqmusic/mediaplayer/codec/BaseDecoder;
    //   1486: invokevirtual 416	com/tencent/qqmusic/mediaplayer/codec/BaseDecoder:release	()I
    //   1489: pop
    //   1490: goto +50 -> 1540
    //   1493: astore 4
    //   1495: new 140	java/lang/StringBuilder
    //   1498: dup
    //   1499: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   1502: astore 5
    //   1504: aload 5
    //   1506: ldc_w 418
    //   1509: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1512: pop
    //   1513: aload 5
    //   1515: aload 4
    //   1517: invokevirtual 421	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   1520: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1523: pop
    //   1524: ldc 14
    //   1526: aload_0
    //   1527: aload 5
    //   1529: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1532: invokespecial 173	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   1535: aload 4
    //   1537: invokestatic 299	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1540: aload_0
    //   1541: getfield 125	com/tencent/qqmusic/mediaplayer/CorePlayer:mDataSource	Lcom/tencent/qqmusic/mediaplayer/upstream/IDataSource;
    //   1544: astore 4
    //   1546: aload 4
    //   1548: ifnull +60 -> 1608
    //   1551: aload 4
    //   1553: invokeinterface 426 1 0
    //   1558: goto +50 -> 1608
    //   1561: astore 4
    //   1563: new 140	java/lang/StringBuilder
    //   1566: dup
    //   1567: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   1570: astore 5
    //   1572: aload 5
    //   1574: ldc_w 428
    //   1577: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1580: pop
    //   1581: aload 5
    //   1583: aload 4
    //   1585: invokevirtual 429	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1588: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1591: pop
    //   1592: ldc 14
    //   1594: aload_0
    //   1595: aload 5
    //   1597: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1600: invokespecial 173	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   1603: aload 4
    //   1605: invokestatic 299	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1608: aload_0
    //   1609: getfield 181	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   1612: astore 4
    //   1614: aload 4
    //   1616: ifnull +8 -> 1624
    //   1619: aload 4
    //   1621: invokevirtual 431	com/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent:release	()V
    //   1624: aload_0
    //   1625: iconst_0
    //   1626: putfield 88	com/tencent/qqmusic/mediaplayer/CorePlayer:mPlayerMode	I
    //   1629: new 140	java/lang/StringBuilder
    //   1632: dup
    //   1633: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   1636: astore 5
    //   1638: aload_3
    //   1639: astore 4
    //   1641: aload 5
    //   1643: astore_3
    //   1644: aload_3
    //   1645: aload 4
    //   1647: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1650: pop
    //   1651: aload_3
    //   1652: invokestatic 376	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   1655: invokevirtual 379	java/lang/Thread:getName	()Ljava/lang/String;
    //   1658: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1661: pop
    //   1662: ldc 14
    //   1664: aload_0
    //   1665: aload_3
    //   1666: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1669: invokespecial 173	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   1672: invokestatic 226	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1675: return
    //   1676: aload_0
    //   1677: getfield 181	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   1680: ifnull +48 -> 1728
    //   1683: new 140	java/lang/StringBuilder
    //   1686: dup
    //   1687: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   1690: astore 5
    //   1692: aload 5
    //   1694: ldc_w 406
    //   1697: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1700: pop
    //   1701: aload 5
    //   1703: aload_0
    //   1704: getfield 90	com/tencent/qqmusic/mediaplayer/CorePlayer:mIsExit	Z
    //   1707: invokevirtual 409	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1710: pop
    //   1711: ldc 14
    //   1713: aload_0
    //   1714: aload 5
    //   1716: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1719: invokespecial 173	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   1722: invokestatic 226	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1725: goto +15 -> 1740
    //   1728: ldc 14
    //   1730: aload_0
    //   1731: ldc_w 411
    //   1734: invokespecial 173	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   1737: invokestatic 186	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1740: invokestatic 414	com/tencent/qqmusic/mediaplayer/util/CpuInfoUtil:stopProcessInfoOutput	()V
    //   1743: aload_0
    //   1744: getfield 123	com/tencent/qqmusic/mediaplayer/CorePlayer:mDecoder	Lcom/tencent/qqmusic/mediaplayer/codec/BaseDecoder;
    //   1747: invokevirtual 416	com/tencent/qqmusic/mediaplayer/codec/BaseDecoder:release	()I
    //   1750: pop
    //   1751: goto +50 -> 1801
    //   1754: astore 5
    //   1756: new 140	java/lang/StringBuilder
    //   1759: dup
    //   1760: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   1763: astore 6
    //   1765: aload 6
    //   1767: ldc_w 418
    //   1770: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1773: pop
    //   1774: aload 6
    //   1776: aload 5
    //   1778: invokevirtual 421	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   1781: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1784: pop
    //   1785: ldc 14
    //   1787: aload_0
    //   1788: aload 6
    //   1790: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1793: invokespecial 173	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   1796: aload 5
    //   1798: invokestatic 299	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1801: aload_0
    //   1802: getfield 125	com/tencent/qqmusic/mediaplayer/CorePlayer:mDataSource	Lcom/tencent/qqmusic/mediaplayer/upstream/IDataSource;
    //   1805: astore 5
    //   1807: aload 5
    //   1809: ifnull +60 -> 1869
    //   1812: aload 5
    //   1814: invokeinterface 426 1 0
    //   1819: goto +50 -> 1869
    //   1822: astore 5
    //   1824: new 140	java/lang/StringBuilder
    //   1827: dup
    //   1828: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   1831: astore 6
    //   1833: aload 6
    //   1835: ldc_w 428
    //   1838: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1841: pop
    //   1842: aload 6
    //   1844: aload 5
    //   1846: invokevirtual 429	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1849: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1852: pop
    //   1853: ldc 14
    //   1855: aload_0
    //   1856: aload 6
    //   1858: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1861: invokespecial 173	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   1864: aload 5
    //   1866: invokestatic 299	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1869: aload_0
    //   1870: getfield 181	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   1873: astore 5
    //   1875: aload 5
    //   1877: ifnull +8 -> 1885
    //   1880: aload 5
    //   1882: invokevirtual 431	com/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent:release	()V
    //   1885: aload_0
    //   1886: iconst_0
    //   1887: putfield 88	com/tencent/qqmusic/mediaplayer/CorePlayer:mPlayerMode	I
    //   1890: new 140	java/lang/StringBuilder
    //   1893: dup
    //   1894: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   1897: astore 5
    //   1899: aload 5
    //   1901: aload_3
    //   1902: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1905: pop
    //   1906: aload 5
    //   1908: invokestatic 376	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   1911: invokevirtual 379	java/lang/Thread:getName	()Ljava/lang/String;
    //   1914: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1917: pop
    //   1918: ldc 14
    //   1920: aload_0
    //   1921: aload 5
    //   1923: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1926: invokespecial 173	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   1929: invokestatic 226	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1932: goto +6 -> 1938
    //   1935: aload 4
    //   1937: athrow
    //   1938: goto -3 -> 1935
    //   1941: bipush 55
    //   1943: istore_1
    //   1944: goto -1610 -> 334
    //   1947: bipush 62
    //   1949: istore_1
    //   1950: goto -1616 -> 334
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1953	0	this	CorePlayer
    //   76	1874	1	i	int
    //   45	1045	2	j	int
    //   10	367	3	localObject1	Object
    //   415	41	3	localThrowable1	Throwable
    //   463	6	3	localIDataSource1	IDataSource
    //   477	41	3	localIOException1	java.io.IOException
    //   525	156	3	localObject2	Object
    //   773	7	3	localObject3	Object
    //   784	15	3	localObject4	Object
    //   812	1	3	localObject5	Object
    //   830	22	3	localStringBuilder1	StringBuilder
    //   890	41	3	localThrowable2	Throwable
    //   938	6	3	localIDataSource2	IDataSource
    //   952	41	3	localIOException2	java.io.IOException
    //   1000	902	3	localObject6	Object
    //   115	1	4	localObject7	Object
    //   423	358	4	localObject8	Object
    //   788	1	4	localThrowable3	Throwable
    //   898	128	4	localObject9	Object
    //   1030	1	4	localObject10	Object
    //   1039	1	4	localThrowable4	Throwable
    //   1048	1	4	localThrowable5	Throwable
    //   1057	1	4	localObject11	Object
    //   1066	89	4	localThrowable6	Throwable
    //   1173	25	4	localStringBuilder2	StringBuilder
    //   1237	43	4	localThrowable7	Throwable
    //   1288	8	4	localIDataSource3	IDataSource
    //   1305	43	4	localIOException3	java.io.IOException
    //   1356	34	4	localObject12	Object
    //   1395	1	4	localObject13	Object
    //   1403	8	4	localThrowable8	Throwable
    //   1429	25	4	localStringBuilder3	StringBuilder
    //   1493	43	4	localThrowable9	Throwable
    //   1544	8	4	localIDataSource4	IDataSource
    //   1561	43	4	localIOException4	java.io.IOException
    //   1612	324	4	localObject14	Object
    //   661	1054	5	localObject15	Object
    //   1754	43	5	localThrowable10	Throwable
    //   1805	8	5	localIDataSource5	IDataSource
    //   1822	43	5	localIOException5	java.io.IOException
    //   1873	49	5	localObject16	Object
    //   667	1190	6	localObject17	Object
    // Exception table:
    //   from	to	target	type
    //   65	112	115	finally
    //   133	180	115	finally
    //   203	257	115	finally
    //   260	269	115	finally
    //   276	301	115	finally
    //   307	328	115	finally
    //   334	341	115	finally
    //   404	412	415	java/lang/Throwable
    //   468	474	477	java/io/IOException
    //   607	643	773	finally
    //   646	674	773	finally
    //   607	643	788	java/lang/Throwable
    //   646	674	788	java/lang/Throwable
    //   674	695	812	finally
    //   698	711	812	finally
    //   711	744	812	finally
    //   744	770	812	finally
    //   802	809	812	finally
    //   879	887	890	java/lang/Throwable
    //   943	949	952	java/io/IOException
    //   793	798	1030	finally
    //   674	695	1039	java/lang/Throwable
    //   698	711	1039	java/lang/Throwable
    //   711	744	1039	java/lang/Throwable
    //   744	770	1039	java/lang/Throwable
    //   793	798	1039	java/lang/Throwable
    //   802	809	1039	java/lang/Throwable
    //   591	603	1048	java/lang/Throwable
    //   46	61	1057	finally
    //   124	129	1057	finally
    //   185	197	1057	finally
    //   580	591	1057	finally
    //   591	603	1057	finally
    //   46	61	1066	java/lang/Throwable
    //   65	112	1066	java/lang/Throwable
    //   124	129	1066	java/lang/Throwable
    //   133	180	1066	java/lang/Throwable
    //   185	197	1066	java/lang/Throwable
    //   203	257	1066	java/lang/Throwable
    //   260	269	1066	java/lang/Throwable
    //   276	301	1066	java/lang/Throwable
    //   307	328	1066	java/lang/Throwable
    //   334	341	1066	java/lang/Throwable
    //   580	591	1066	java/lang/Throwable
    //   1226	1234	1237	java/lang/Throwable
    //   1295	1302	1305	java/io/IOException
    //   1075	1083	1395	finally
    //   1094	1102	1395	finally
    //   1108	1120	1395	finally
    //   1123	1136	1395	finally
    //   1139	1146	1395	finally
    //   1149	1159	1395	finally
    //   1408	1415	1395	finally
    //   1075	1083	1403	java/lang/Throwable
    //   1094	1102	1403	java/lang/Throwable
    //   1108	1120	1403	java/lang/Throwable
    //   1123	1136	1403	java/lang/Throwable
    //   1139	1146	1403	java/lang/Throwable
    //   1149	1159	1403	java/lang/Throwable
    //   1482	1490	1493	java/lang/Throwable
    //   1551	1558	1561	java/io/IOException
    //   1743	1751	1754	java/lang/Throwable
    //   1812	1819	1822	java/io/IOException
  }
  
  public void seek(int paramInt)
  {
    BaseDecodeDataComponent localBaseDecodeDataComponent = this.mPcmCompnent;
    if (localBaseDecodeDataComponent != null) {
      localBaseDecodeDataComponent.seek(paramInt);
    }
  }
  
  public int seekTo(int paramInt)
  {
    return this.mDecoder.seekTo(paramInt);
  }
  
  void setAudioStreamType(int paramInt)
  {
    BaseDecodeDataComponent localBaseDecodeDataComponent = this.mPcmCompnent;
    if (localBaseDecodeDataComponent != null) {
      localBaseDecodeDataComponent.setAudioStreamType(paramInt);
    }
  }
  
  public void setLeastCommonMultiple(int paramInt)
  {
    BaseDecodeDataComponent localBaseDecodeDataComponent = this.mPcmCompnent;
    if (localBaseDecodeDataComponent != null) {
      localBaseDecodeDataComponent.setLeastCommonMultiple(paramInt);
    }
  }
  
  public void setPlayPath(String paramString)
  {
    this.mPlayPath = paramString;
  }
  
  void setPlayerMode(int paramInt)
  {
    this.mPlayerMode = paramInt;
  }
  
  void setSpeed(float paramFloat)
  {
    BaseDecodeDataComponent localBaseDecodeDataComponent = this.mPcmCompnent;
    if (localBaseDecodeDataComponent == null)
    {
      this.mSpeedToSet = Float.valueOf(paramFloat);
      return;
    }
    localBaseDecodeDataComponent.setSpeed(paramFloat);
  }
  
  void setThreadName(String paramString)
  {
    this.mThreadName = paramString;
  }
  
  void setVolume(float paramFloat1, float paramFloat2)
  {
    BaseDecodeDataComponent localBaseDecodeDataComponent = this.mPcmCompnent;
    if (localBaseDecodeDataComponent != null) {
      localBaseDecodeDataComponent.setVolume(paramFloat1, paramFloat2);
    }
  }
  
  void stop()
  {
    Logger.i("CorePlayer", axiliary("stop"));
    BaseDecodeDataComponent localBaseDecodeDataComponent = this.mPcmCompnent;
    if (localBaseDecodeDataComponent == null)
    {
      exitNotCallback();
      return;
    }
    localBaseDecodeDataComponent.stop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.CorePlayer
 * JD-Core Version:    0.7.0.1
 */