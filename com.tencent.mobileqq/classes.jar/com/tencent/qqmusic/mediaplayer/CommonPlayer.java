package com.tencent.qqmusic.mediaplayer;

import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qqmusic.mediaplayer.audiofx.IAudioListener;
import com.tencent.qqmusic.mediaplayer.audioplaylist.TrackInfo;
import com.tencent.qqmusic.mediaplayer.codec.BaseDecoder;
import com.tencent.qqmusic.mediaplayer.codec.MediaCodecDecoder;
import com.tencent.qqmusic.mediaplayer.codec.NativeDecoder;
import com.tencent.qqmusic.mediaplayer.downstream.FileDataSink;
import com.tencent.qqmusic.mediaplayer.network.DefaultMediaHTTPService;
import com.tencent.qqmusic.mediaplayer.network.IMediaHTTPService;
import com.tencent.qqmusic.mediaplayer.seektable.SeekTable;
import com.tencent.qqmusic.mediaplayer.upstream.CacheDataSource;
import com.tencent.qqmusic.mediaplayer.upstream.FileDataSource;
import com.tencent.qqmusic.mediaplayer.upstream.HttpDataSource;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSourceFactory;
import com.tencent.qqmusic.mediaplayer.upstream.INativeDataSource;
import com.tencent.qqmusic.mediaplayer.upstream.ListPlayerListenerCallback;
import com.tencent.qqmusic.mediaplayer.upstream.TracerDataSource;
import com.tencent.qqmusic.mediaplayer.upstream.TrackDataSource;
import com.tencent.qqmusic.mediaplayer.upstream.UriLoader;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.List;

public class CommonPlayer
  extends BaseMediaPlayer
{
  private static final int INIT_STATE_CHECK_TIME = 5000;
  private static final String TAG = "CommonPlayer";
  private int currentState;
  @Nullable
  private Looper eventLooper;
  @Nullable
  private CorePlayer mAudioPlayer = null;
  private int mBufferPercentage;
  private final ListPlayerListenerCallback mCallback = new ListPlayerListenerCallback();
  private long mDuration;
  @NonNull
  private final QMThreadExecutor mExecutor;
  private String mLocalPlayPath;
  private boolean mPreferMediaCodecDecode;
  @Nullable
  private Float mSpeedToSet;
  @Nullable
  private CommonPlayer.OpenedResources openedResources;
  
  public CommonPlayer()
  {
    this(null, null, false, new CommonPlayer.1());
  }
  
  public CommonPlayer(@Nullable PlayerListenerCallback paramPlayerListenerCallback)
  {
    this(paramPlayerListenerCallback, null, false, new CommonPlayer.2());
  }
  
  public CommonPlayer(@Nullable PlayerListenerCallback paramPlayerListenerCallback, @Nullable Looper paramLooper, boolean paramBoolean, @NonNull QMThreadExecutor paramQMThreadExecutor)
  {
    boolean bool2 = false;
    this.currentState = 0;
    this.mSpeedToSet = null;
    this.mPreferMediaCodecDecode = false;
    this.mLocalPlayPath = null;
    if (paramPlayerListenerCallback != null) {
      this.mCallback.add(paramPlayerListenerCallback);
    }
    this.eventLooper = paramLooper;
    boolean bool1 = bool2;
    if (Build.VERSION.SDK_INT >= 23)
    {
      bool1 = bool2;
      if (paramBoolean) {
        bool1 = true;
      }
    }
    this.mPreferMediaCodecDecode = bool1;
    this.mExecutor = paramQMThreadExecutor;
    reset();
  }
  
  private String auxiliary(String paramString)
  {
    CorePlayer localCorePlayer = this.mAudioPlayer;
    String str;
    if (this.mPreferMediaCodecDecode) {
      str = "[MediaCodec]";
    } else {
      str = "";
    }
    if (localCorePlayer == null) {
      return "null";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(localCorePlayer);
    localStringBuilder.append("]");
    localStringBuilder.append(str);
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  @NonNull
  private Looper insureEventLooper()
  {
    if (this.eventLooper == null)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("CommonPlayer_EventHandler_");
      ((StringBuilder)localObject).append(hashCode());
      localObject = new HandlerThread(((StringBuilder)localObject).toString());
      ((HandlerThread)localObject).start();
      this.eventLooper = ((HandlerThread)localObject).getLooper();
    }
    return this.eventLooper;
  }
  
  private void onError(int paramInt1, int paramInt2)
  {
    onError(paramInt1, paramInt2, 0);
  }
  
  private void onError(int paramInt1, int paramInt2, int paramInt3)
  {
    TransferStateTo(9);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onError prefer MediaCodec ");
    localStringBuilder.append(this.mPreferMediaCodecDecode);
    Logger.e("CommonPlayer", localStringBuilder.toString());
    this.mCallback.onError(this, paramInt1, paramInt2, paramInt3);
  }
  
  private void resetInternal()
  {
    Object localObject = this.openedResources;
    if (localObject != null) {
      ((CommonPlayer.OpenedResources)localObject).release();
    }
    localObject = this.mAudioPlayer;
    if (localObject != null)
    {
      ((CorePlayer)localObject).release();
      this.mAudioPlayer = null;
    }
    localObject = this.eventLooper;
    if ((localObject != null) && (localObject != Looper.getMainLooper()))
    {
      if (Build.VERSION.SDK_INT >= 18) {
        this.eventLooper.quitSafely();
      } else {
        this.eventLooper.quit();
      }
      this.eventLooper = null;
    }
    this.mDuration = 0L;
    this.mBufferPercentage = 0;
    this.mSpeedToSet = null;
  }
  
  private void setDataSourceInternal(@NonNull IDataSource paramIDataSource)
  {
    TransferStateTo(1);
    Object localObject;
    if (this.mPreferMediaCodecDecode) {
      localObject = new MediaCodecDecoder();
    } else {
      localObject = new NativeDecoder();
    }
    CommonPlayer.CorePlayerCallback localCorePlayerCallback = new CommonPlayer.CorePlayerCallback(this, null, paramIDataSource, null);
    this.mAudioPlayer = new CorePlayer(new TracerDataSource(paramIDataSource), null, localCorePlayerCallback, insureEventLooper(), (BaseDecoder)localObject, this.mExecutor);
    this.mAudioPlayer.setThreadName(paramIDataSource.toString());
    setSpeedToCorePlayerIfNeeded(this.mAudioPlayer);
  }
  
  private void setSpeedToCorePlayerIfNeeded(@NonNull CorePlayer paramCorePlayer)
  {
    Float localFloat = this.mSpeedToSet;
    if (localFloat != null)
    {
      paramCorePlayer.setSpeed(localFloat.floatValue());
      this.mSpeedToSet = null;
    }
  }
  
  protected void TransferStateTo(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.currentState);
    ((StringBuilder)localObject).append(" -> ");
    ((StringBuilder)localObject).append(paramInt);
    Logger.i("StateRunner", ((StringBuilder)localObject).toString());
    this.currentState = paramInt;
    localObject = this.mCallback;
    if (localObject != null) {
      ((ListPlayerListenerCallback)localObject).onStateChanged(this, paramInt);
    }
  }
  
  public void addAudioListener(@NonNull IAudioListener paramIAudioListener)
  {
    CorePlayer localCorePlayer = this.mAudioPlayer;
    if (localCorePlayer != null) {
      localCorePlayer.addAudioListener(paramIAudioListener);
    }
  }
  
  public void addPlayerListenerCallback(PlayerListenerCallback paramPlayerListenerCallback)
  {
    this.mCallback.add(paramPlayerListenerCallback);
  }
  
  public SeekTable createSeekTable()
  {
    CorePlayer localCorePlayer = this.mAudioPlayer;
    if (localCorePlayer != null) {
      return localCorePlayer.createSeekTable();
    }
    throw new IllegalStateException("not initialized!");
  }
  
  public void flush()
  {
    CorePlayer localCorePlayer = this.mAudioPlayer;
    if (localCorePlayer == null)
    {
      Logger.e("CommonPlayer", "[getCurrentFrame] mAudioPlayer is null!");
      return;
    }
    localCorePlayer.flush();
  }
  
  public int getBufferedPercentage()
  {
    return this.mBufferPercentage;
  }
  
  public AudioInformation getCurrentAudioInformation()
  {
    CorePlayer localCorePlayer = this.mAudioPlayer;
    if (localCorePlayer != null) {
      return localCorePlayer.getCurrentAudioInformation();
    }
    return null;
  }
  
  public long getCurrentPosition()
  {
    CorePlayer localCorePlayer = this.mAudioPlayer;
    if (localCorePlayer != null) {
      return localCorePlayer.getCurPosition();
    }
    Logger.e("CommonPlayer", "getCurrentPosition() mAudioPlayer is null!");
    return 0L;
  }
  
  public long getCurrentPositionFromFile()
  {
    return 0L;
  }
  
  public long getDecodePosition()
  {
    CorePlayer localCorePlayer = this.mAudioPlayer;
    if (localCorePlayer != null) {
      return localCorePlayer.getCurPositionByDecoder();
    }
    Logger.e("CommonPlayer", "getDecodePosition() ERROR : mAudioPlayer is null!");
    return 0L;
  }
  
  public int getDecoderType()
  {
    if (this.mPreferMediaCodecDecode) {
      return 2;
    }
    return 1;
  }
  
  public int getDuration()
  {
    CorePlayer localCorePlayer = this.mAudioPlayer;
    if (localCorePlayer != null)
    {
      this.mDuration = localCorePlayer.getDuration();
      return (int)this.mDuration;
    }
    Logger.e("CommonPlayer", "getDuration() mAudioPlayer is null!");
    long l = this.mDuration;
    if (l <= 0L) {
      l = 0L;
    }
    return (int)l;
  }
  
  int getPlayerMode()
  {
    CorePlayer localCorePlayer = this.mAudioPlayer;
    if (localCorePlayer != null) {
      return localCorePlayer.getPlayerMode();
    }
    return 0;
  }
  
  public int getPlayerState()
  {
    return this.currentState;
  }
  
  public int getSessionId()
  {
    CorePlayer localCorePlayer = this.mAudioPlayer;
    if (localCorePlayer != null) {
      return localCorePlayer.getSessionId();
    }
    return 0;
  }
  
  public boolean isPlaying()
  {
    CorePlayer localCorePlayer = this.mAudioPlayer;
    boolean bool = false;
    if (localCorePlayer != null)
    {
      if (localCorePlayer.getPlayerState() == 4) {
        bool = true;
      }
      return bool;
    }
    Logger.e("CommonPlayer", "isPlaying() mAudioPlayer is null!");
    return false;
  }
  
  public void pause()
  {
    TransferStateTo(5);
    Logger.i("CommonPlayer", auxiliary("[pause]"));
    CorePlayer localCorePlayer = this.mAudioPlayer;
    if (localCorePlayer != null) {
      localCorePlayer.pause(false);
    } else {
      Logger.e("CommonPlayer", "pause() mAudioPlayer is null!");
    }
    notifyPauseSong();
  }
  
  public void pauseRealTime()
  {
    TransferStateTo(5);
    Logger.i("CommonPlayer", auxiliary("[pauseRealTime]"));
    CorePlayer localCorePlayer = this.mAudioPlayer;
    if (localCorePlayer != null) {
      localCorePlayer.pause(true);
    } else {
      Logger.e("CommonPlayer", "pauseRealTime() mAudioPlayer is null!");
    }
    notifyPauseSong();
  }
  
  public void prepare()
  {
    TransferStateTo(3);
    Logger.i("CommonPlayer", auxiliary("[prepare]"));
    CorePlayer localCorePlayer = this.mAudioPlayer;
    if (localCorePlayer != null)
    {
      localCorePlayer.prepare();
      return;
    }
    Logger.e("CommonPlayer", "prepare() null mAudioPlayer!");
  }
  
  public void prepareAsync()
  {
    throw new UnSupportMethodException("Soft decode player cannot support prepareAsync");
  }
  
  public void release()
  {
    TransferStateTo(8);
    Logger.i("CommonPlayer", auxiliary("[release]"));
    resetInternal();
    this.mCallback.clear();
  }
  
  public void removeAudioListener(@NonNull IAudioListener paramIAudioListener)
  {
    CorePlayer localCorePlayer = this.mAudioPlayer;
    if (localCorePlayer != null) {
      localCorePlayer.removeAudioListener(paramIAudioListener);
    }
  }
  
  public void reset()
  {
    TransferStateTo(0);
    Logger.i("CommonPlayer", auxiliary("[reset]"));
    resetInternal();
  }
  
  public void seekTo(int paramInt)
  {
    CorePlayer localCorePlayer = this.mAudioPlayer;
    if (localCorePlayer != null)
    {
      localCorePlayer.seek(paramInt);
      return;
    }
    Logger.e("CommonPlayer", "seekTo() mAudioPlayer is null!");
  }
  
  public void setAudioStreamType(int paramInt)
  {
    CorePlayer localCorePlayer = this.mAudioPlayer;
    if (localCorePlayer != null) {
      localCorePlayer.setAudioStreamType(paramInt);
    }
  }
  
  public void setDataSource(Context paramContext, Uri paramUri)
  {
    paramContext = paramUri.getScheme();
    if (TextUtils.isEmpty(paramContext))
    {
      setDataSource(paramUri.toString());
      return;
    }
    if ((!paramContext.equalsIgnoreCase("http")) && (!paramContext.equalsIgnoreCase("https")))
    {
      if (!paramContext.equalsIgnoreCase("content")) {
        paramContext.equalsIgnoreCase("file");
      }
    }
    else {
      setDataSource(new DefaultMediaHTTPService(), paramUri);
    }
  }
  
  public void setDataSource(Context paramContext, UriLoader paramUriLoader)
  {
    setDataSource(new CommonPlayer.3(this, paramUriLoader));
  }
  
  public void setDataSource(TrackInfo paramTrackInfo)
  {
    TransferStateTo(1);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setDataSource, trackInfo.getUri: ");
    ((StringBuilder)localObject).append(paramTrackInfo.getUri());
    Logger.i("CommonPlayer", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setDataSource, trackInfo.range: ");
    ((StringBuilder)localObject).append(paramTrackInfo.getRange().toString());
    Logger.i("CommonPlayer", ((StringBuilder)localObject).toString());
    this.mBufferPercentage = 100;
    paramTrackInfo = new TrackDataSource(paramTrackInfo);
    localObject = this.mCallback.toCollection();
    this.mCallback.clear();
    this.mCallback.add(paramTrackInfo);
    this.mCallback.addAll((List)localObject);
    TransferStateTo(1);
    localObject = new TracerDataSource(paramTrackInfo);
    this.mAudioPlayer = new TrackCorePlayer((IDataSource)localObject, new CommonPlayer.CorePlayerCallback(this, null, (IDataSource)localObject, null), insureEventLooper(), this.mExecutor);
    paramTrackInfo.setTrackStateCallback((TrackCorePlayer)this.mAudioPlayer);
    this.mAudioPlayer.setThreadName(paramTrackInfo.toString());
    setSpeedToCorePlayerIfNeeded(this.mAudioPlayer);
  }
  
  public void setDataSource(IMediaHTTPService paramIMediaHTTPService, Uri paramUri)
  {
    try
    {
      File localFile = File.createTempFile("mediaHttpCommonPlayer", "tmp");
      localFile.delete();
      if (!localFile.createNewFile())
      {
        onError(90, 103, 0);
        return;
      }
      String str = localFile.getAbsolutePath();
      paramIMediaHTTPService = new CacheDataSource(new HttpDataSource(paramUri, null, paramIMediaHTTPService), new FileDataSource(str), new FileDataSink(str), insureEventLooper());
      this.openedResources = new CommonPlayer.OpenedResources(null);
      CommonPlayer.OpenedResources.access$602(this.openedResources, localFile);
      CommonPlayer.OpenedResources.access$702(this.openedResources, paramIMediaHTTPService);
      paramIMediaHTTPService.setListener(new CommonPlayer.BufferListener(this, null));
      setDataSourceInternal(paramIMediaHTTPService);
      return;
    }
    catch (IOException paramIMediaHTTPService)
    {
      label127:
      break label127;
    }
    onError(90, 103, 0);
  }
  
  public void setDataSource(IDataSourceFactory paramIDataSourceFactory)
  {
    if (paramIDataSourceFactory != null)
    {
      TransferStateTo(1);
      CommonPlayer.CorePlayerCallback localCorePlayerCallback = new CommonPlayer.CorePlayerCallback(this, paramIDataSourceFactory, null, null);
      if (this.mPreferMediaCodecDecode)
      {
        this.mAudioPlayer = new CorePlayer(paramIDataSourceFactory.createDataSource(), null, localCorePlayerCallback, insureEventLooper(), new MediaCodecDecoder(), this.mExecutor);
      }
      else
      {
        INativeDataSource localINativeDataSource = paramIDataSourceFactory.createNativeDataSource();
        if (localINativeDataSource != null) {
          this.mAudioPlayer = new CorePlayer(null, localINativeDataSource, localCorePlayerCallback, insureEventLooper(), new NativeDecoder(), this.mExecutor);
        } else {
          this.mAudioPlayer = new CorePlayer(paramIDataSourceFactory.createDataSource(), null, localCorePlayerCallback, insureEventLooper(), new NativeDecoder(), this.mExecutor);
        }
      }
      this.mAudioPlayer.setThreadName(paramIDataSourceFactory.toString());
      setSpeedToCorePlayerIfNeeded(this.mAudioPlayer);
      paramIDataSourceFactory = this.mLocalPlayPath;
      if (paramIDataSourceFactory != null) {
        this.mAudioPlayer.setPlayPath(paramIDataSourceFactory);
      }
      return;
    }
    throw new IllegalArgumentException("dataSourceFactory is null!");
  }
  
  public void setDataSource(FileDescriptor paramFileDescriptor)
  {
    throw new UnSupportMethodException("Soft decode player cannot support setDataSource by FileDescriptor");
  }
  
  public void setDataSource(String paramString)
  {
    if (paramString != null)
    {
      TransferStateTo(1);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setDataSource, path: ");
      localStringBuilder.append(paramString);
      Logger.i("CommonPlayer", localStringBuilder.toString());
      this.mBufferPercentage = 100;
      setDataSourceInternal(new FileDataSource(paramString));
      return;
    }
    Logger.e("CommonPlayer", "setDataSource() ERROR:the path is null!");
    throw new IllegalArgumentException("the path is null!");
  }
  
  public void setLeastCommonMultiple(int paramInt)
  {
    CorePlayer localCorePlayer = this.mAudioPlayer;
    if (localCorePlayer != null) {
      localCorePlayer.setLeastCommonMultiple(paramInt);
    }
  }
  
  public void setPlayLocalPath(String paramString)
  {
    this.mLocalPlayPath = paramString;
    paramString = this.mAudioPlayer;
    if (paramString != null) {
      paramString.setPlayPath(this.mLocalPlayPath);
    }
  }
  
  public void setPlayerListenerCallback(PlayerListenerCallback paramPlayerListenerCallback)
  {
    this.mCallback.clear();
    this.mCallback.add(paramPlayerListenerCallback);
  }
  
  void setPlayerMode(int paramInt)
  {
    CorePlayer localCorePlayer = this.mAudioPlayer;
    if (localCorePlayer != null) {
      localCorePlayer.setPlayerMode(paramInt);
    }
  }
  
  public void setSpeed(float paramFloat)
  {
    CorePlayer localCorePlayer = this.mAudioPlayer;
    if (localCorePlayer != null)
    {
      localCorePlayer.setSpeed(paramFloat);
      return;
    }
    this.mSpeedToSet = Float.valueOf(paramFloat);
  }
  
  public void setVolume(float paramFloat1, float paramFloat2)
  {
    CorePlayer localCorePlayer = this.mAudioPlayer;
    if (localCorePlayer != null) {
      localCorePlayer.setVolume(paramFloat1, paramFloat2);
    }
  }
  
  public void setWakeMode(Context paramContext, int paramInt)
  {
    throw new UnSupportMethodException("Soft decode player cannot support setWakeMode");
  }
  
  public void start()
  {
    TransferStateTo(4);
    Logger.i("CommonPlayer", auxiliary("[start]"));
    CorePlayer localCorePlayer = this.mAudioPlayer;
    if (localCorePlayer != null) {
      localCorePlayer.play();
    } else {
      Logger.e("CommonPlayer", "start() mAudioPlayer is null!");
    }
    notifyStartPlaySong();
  }
  
  public void stop()
  {
    try
    {
      TransferStateTo(6);
      Logger.i("CommonPlayer", auxiliary("[stop]"));
      if (this.mAudioPlayer != null)
      {
        this.mAudioPlayer.stop();
        return;
      }
      Logger.e("CommonPlayer", "stop() mAudioPlayer is null!");
      return;
    }
    catch (Exception localException)
    {
      Logger.e("CommonPlayer", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.CommonPlayer
 * JD-Core Version:    0.7.0.1
 */