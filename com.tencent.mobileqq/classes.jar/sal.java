import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.TMG.utils.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnCaptureImageListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnCompletionListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnDownloadCallbackListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnErrorListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnInfoListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnSeekCompleteListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnVideoPreparedListener;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase;
import com.tencent.superplayer.api.SuperPlayerOption;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/tvk/TVKPlayer;", "Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/IPlayer;", "Lcom/tencent/qqlive/mediaplayer/api/TVK_IMediaPlayer$OnVideoPreparedListener;", "Lcom/tencent/qqlive/mediaplayer/api/TVK_IMediaPlayer$OnCompletionListener;", "Lcom/tencent/qqlive/mediaplayer/api/TVK_IMediaPlayer$OnErrorListener;", "Lcom/tencent/qqlive/mediaplayer/api/TVK_IMediaPlayer$OnInfoListener;", "Lcom/tencent/qqlive/mediaplayer/api/TVK_IMediaPlayer$OnCaptureImageListener;", "Lcom/tencent/qqlive/mediaplayer/api/TVK_IMediaPlayer$OnSeekCompleteListener;", "Lcom/tencent/qqlive/mediaplayer/api/TVK_IMediaPlayer$OnDownloadCallbackListener;", "videoPlayer", "Lcom/tencent/qqlive/mediaplayer/api/TVK_IMediaPlayer;", "(Lcom/tencent/qqlive/mediaplayer/api/TVK_IMediaPlayer;)V", "currentPositionMs", "", "getCurrentPositionMs", "()J", "durationMs", "getDurationMs", "hasCallFirstFrameRendered", "", "isBuffering", "()Z", "isCoverFrame", "value", "isLoopBack", "setLoopBack", "(Z)V", "isLoopback", "isPauseing", "isPlaying", "isPrepared", "isPrepareing", "listener", "Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/IEventListener;", "outputMute", "getOutputMute", "setOutputMute", "speedRatio", "", "getSpeedRatio", "()F", "setSpeedRatio", "(F)V", "videoHeight", "", "getVideoHeight", "()I", "videoWidth", "getVideoWidth", "OnDownloadCallback", "", "info", "", "getStreamDumpInfo", "getToken", "getVideoView", "Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/IVideoView;", "onCaptureImageFailed", "p0", "id", "errorCode", "onCaptureImageSucceed", "width", "height", "bitmap", "Landroid/graphics/Bitmap;", "onCompletion", "onError", "tvkPlayer", "model", "what", "extra", "detailInfo", "Info", "", "onInfo", "onSeekComplete", "onVideoPrepared", "openMediaPlayer", "context", "Landroid/content/Context;", "videoInfo", "Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/PlayerVideoInfo;", "startPositionMilsec", "playerOption", "Lcom/tencent/superplayer/api/SuperPlayerOption;", "pause", "pauseDownload", "prePlayViewShow", "release", "resumeDownload", "seekTo", "positionMilsec", "mode", "setEventListener", "setHttpBufferRange", "emergencyTime", "safePlayTime", "preloadDuration", "setLoopback", "setXYaxis", "type", "start", "stop", "updatePlayerVideoView", "videoView", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class sal
  implements TVK_IMediaPlayer.OnCaptureImageListener, TVK_IMediaPlayer.OnCompletionListener, TVK_IMediaPlayer.OnDownloadCallbackListener, TVK_IMediaPlayer.OnErrorListener, TVK_IMediaPlayer.OnInfoListener, TVK_IMediaPlayer.OnSeekCompleteListener, TVK_IMediaPlayer.OnVideoPreparedListener, rzt
{
  public static final sam a;
  private float jdField_a_of_type_Float;
  private final TVK_IMediaPlayer jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
  private rzs jdField_a_of_type_Rzs;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  static
  {
    jdField_a_of_type_Sam = new sam(null);
  }
  
  public sal(@Nullable TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = paramTVK_IMediaPlayer;
    this.jdField_a_of_type_Float = 1.0F;
  }
  
  public void OnDownloadCallback(@Nullable String paramString)
  {
    rzs localrzs = this.jdField_a_of_type_Rzs;
    if (localrzs != null) {
      localrzs.a(paramString);
    }
  }
  
  public int a()
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    if (localTVK_IMediaPlayer != null) {
      return localTVK_IMediaPlayer.getVideoWidth();
    }
    return 0;
  }
  
  public long a()
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    if (localTVK_IMediaPlayer != null) {
      return localTVK_IMediaPlayer.getDuration();
    }
    return 0L;
  }
  
  @Nullable
  public String a()
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    if (localTVK_IMediaPlayer != null) {
      return localTVK_IMediaPlayer.getStreamDumpInfo();
    }
    return null;
  }
  
  @Nullable
  public sab a()
  {
    QLog.e("TVKPlayer", 0, "tvkPlayer don't support getVideoView.");
    return null;
  }
  
  public void a()
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    if (localTVK_IMediaPlayer != null) {
      localTVK_IMediaPlayer.start();
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      onInfo(this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer, 105, null);
    }
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public void a(int paramInt)
  {
    int j = 0;
    int i = j;
    switch (paramInt)
    {
    default: 
      i = j;
    }
    for (;;)
    {
      TVK_IMediaPlayer localTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
      if (localTVK_IMediaPlayer != null) {
        localTVK_IMediaPlayer.setXYaxis(i);
      }
      return;
      i = 1;
      continue;
      i = 2;
      continue;
      i = 6;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    if (localTVK_IMediaPlayer != null) {
      localTVK_IMediaPlayer.seekTo(paramInt1);
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    if (localTVK_IMediaPlayer != null) {
      localTVK_IMediaPlayer.setHttpBufferRange(paramInt2, paramInt1);
    }
  }
  
  public void a(@NotNull Context paramContext, @NotNull sae paramsae, long paramLong, @NotNull SuperPlayerOption paramSuperPlayerOption)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramsae, "videoInfo");
    Intrinsics.checkParameterIsNotNull(paramSuperPlayerOption, "playerOption");
    this.b = paramsae.c();
    this.jdField_a_of_type_Boolean = false;
    paramSuperPlayerOption = saf.a(paramsae);
    TVK_PlayerVideoInfo localTVK_PlayerVideoInfo = saf.a(paramsae);
    Object localObject = paramsae.a();
    int i;
    if (localObject != null) {
      if (localObject.length == 0)
      {
        i = 1;
        if (i != 0) {
          break label121;
        }
        i = 1;
        label72:
        if (i != 1) {
          break label127;
        }
        localObject = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
        if (localObject != null) {
          ((TVK_IMediaPlayer)localObject).openMediaPlayerByUrl(paramContext.getApplicationContext(), paramsae.a(), paramLong, 0L, localTVK_PlayerVideoInfo, paramSuperPlayerOption, paramsae.c());
        }
      }
    }
    label121:
    label127:
    do
    {
      return;
      i = 0;
      break;
      i = 0;
      break label72;
      paramsae = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    } while (paramsae == null);
    paramsae.openMediaPlayer(paramContext.getApplicationContext(), paramSuperPlayerOption, localTVK_PlayerVideoInfo, "", paramLong, 0L);
  }
  
  public void a(@Nullable rzs paramrzs)
  {
    this.jdField_a_of_type_Rzs = paramrzs;
    paramrzs = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    if (paramrzs != null) {
      paramrzs.setOnVideoPreparedListener((TVK_IMediaPlayer.OnVideoPreparedListener)this);
    }
    paramrzs = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    if (paramrzs != null) {
      paramrzs.setOnCompletionListener((TVK_IMediaPlayer.OnCompletionListener)this);
    }
    paramrzs = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    if (paramrzs != null) {
      paramrzs.setOnErrorListener((TVK_IMediaPlayer.OnErrorListener)this);
    }
    paramrzs = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    if (paramrzs != null) {
      paramrzs.setOnInfoListener((TVK_IMediaPlayer.OnInfoListener)this);
    }
    paramrzs = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    if (paramrzs != null) {
      paramrzs.setOnCaptureImageListener((TVK_IMediaPlayer.OnCaptureImageListener)this);
    }
    paramrzs = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    if (paramrzs != null) {
      paramrzs.setOnSeekCompleteListener((TVK_IMediaPlayer.OnSeekCompleteListener)this);
    }
    paramrzs = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    if (paramrzs != null) {
      paramrzs.setOnDownloadCallback((TVK_IMediaPlayer.OnDownloadCallbackListener)this);
    }
  }
  
  public void a(@Nullable sab paramsab)
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    if (localTVK_IMediaPlayer != null) {
      if (paramsab == null) {
        break label42;
      }
    }
    label42:
    for (paramsab = paramsab.a();; paramsab = null)
    {
      sab localsab = paramsab;
      if (!(paramsab instanceof IVideoViewBase)) {
        localsab = null;
      }
      localTVK_IMediaPlayer.updatePlayerVideoView((IVideoViewBase)localsab);
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    if (localTVK_IMediaPlayer != null) {
      localTVK_IMediaPlayer.setOutputMute(paramBoolean);
    }
  }
  
  public boolean a()
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    return (localTVK_IMediaPlayer != null) && (localTVK_IMediaPlayer.getOutputMute() == true);
  }
  
  public int b()
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    if (localTVK_IMediaPlayer != null) {
      return localTVK_IMediaPlayer.getVideoHeight();
    }
    return 0;
  }
  
  public long b()
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    if (localTVK_IMediaPlayer != null) {
      return localTVK_IMediaPlayer.getCurrentPostion();
    }
    return 0L;
  }
  
  @NotNull
  public String b()
  {
    QLog.e("TVKPlayer", 0, "tvkPlayer don't support getToken.");
    return "";
  }
  
  public void b()
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    if (localTVK_IMediaPlayer != null) {
      localTVK_IMediaPlayer.pause();
    }
  }
  
  public void b(boolean paramBoolean)
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    if (localTVK_IMediaPlayer != null) {
      localTVK_IMediaPlayer.setLoopback(paramBoolean);
    }
  }
  
  public boolean b()
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    return (localTVK_IMediaPlayer != null) && (localTVK_IMediaPlayer.isPlaying() == true);
  }
  
  public void c()
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    if (localTVK_IMediaPlayer != null) {
      localTVK_IMediaPlayer.stop();
    }
  }
  
  public boolean c()
  {
    return false;
  }
  
  public void d()
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    if (localTVK_IMediaPlayer != null) {
      localTVK_IMediaPlayer.release();
    }
  }
  
  public boolean d()
  {
    return false;
  }
  
  public void e()
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    if (localTVK_IMediaPlayer != null) {
      localTVK_IMediaPlayer.pauseDownload();
    }
  }
  
  public boolean e()
  {
    return false;
  }
  
  public void f()
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    if (localTVK_IMediaPlayer != null) {
      localTVK_IMediaPlayer.resumeDownload();
    }
  }
  
  public boolean f()
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    return (localTVK_IMediaPlayer != null) && (localTVK_IMediaPlayer.isPauseing() == true);
  }
  
  public void g() {}
  
  public void onCaptureImageFailed(@Nullable TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2)
  {
    paramTVK_IMediaPlayer = this.jdField_a_of_type_Rzs;
    if (paramTVK_IMediaPlayer != null) {
      paramTVK_IMediaPlayer.a((rzt)this, paramInt1, paramInt2);
    }
  }
  
  public void onCaptureImageSucceed(@Nullable TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, @Nullable Bitmap paramBitmap)
  {
    paramTVK_IMediaPlayer = this.jdField_a_of_type_Rzs;
    if (paramTVK_IMediaPlayer != null) {
      paramTVK_IMediaPlayer.a((rzt)this, paramInt1, paramInt2, paramInt3, paramBitmap);
    }
  }
  
  public void onCompletion(@Nullable TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    paramTVK_IMediaPlayer = this.jdField_a_of_type_Rzs;
    if (paramTVK_IMediaPlayer != null) {
      paramTVK_IMediaPlayer.b((rzt)this);
    }
  }
  
  public boolean onError(@Nullable TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, @Nullable String paramString, @Nullable Object paramObject)
  {
    boolean bool2 = false;
    paramTVK_IMediaPlayer = this.jdField_a_of_type_Rzs;
    boolean bool1 = bool2;
    if (paramTVK_IMediaPlayer != null)
    {
      bool1 = bool2;
      if (paramTVK_IMediaPlayer.a((rzt)this, 0, paramInt1, paramInt2, paramString) == true) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean onInfo(@Nullable TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt, @Nullable Object paramObject)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      paramTVK_IMediaPlayer = this.jdField_a_of_type_Rzs;
      if ((paramTVK_IMediaPlayer == null) || (paramTVK_IMediaPlayer.a((rzt)this, paramInt, paramObject) != true)) {
        break;
      }
      return true;
      paramInt = 112;
      continue;
      paramInt = 113;
    }
    return false;
  }
  
  public void onSeekComplete(@Nullable TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    paramTVK_IMediaPlayer = this.jdField_a_of_type_Rzs;
    if (paramTVK_IMediaPlayer != null) {
      paramTVK_IMediaPlayer.c((rzt)this);
    }
  }
  
  public void onVideoPrepared(@Nullable TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    rzs localrzs = this.jdField_a_of_type_Rzs;
    if (localrzs != null) {
      localrzs.a((rzt)this);
    }
    if ((!this.jdField_a_of_type_Boolean) && (this.b))
    {
      this.jdField_a_of_type_Boolean = true;
      onInfo(paramTVK_IMediaPlayer, 105, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sal
 * JD-Core Version:    0.7.0.1
 */