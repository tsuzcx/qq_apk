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
public final class sjh
  implements TVK_IMediaPlayer.OnCaptureImageListener, TVK_IMediaPlayer.OnCompletionListener, TVK_IMediaPlayer.OnDownloadCallbackListener, TVK_IMediaPlayer.OnErrorListener, TVK_IMediaPlayer.OnInfoListener, TVK_IMediaPlayer.OnSeekCompleteListener, TVK_IMediaPlayer.OnVideoPreparedListener, sip
{
  public static final sji a;
  private float jdField_a_of_type_Float;
  private final TVK_IMediaPlayer jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
  private sio jdField_a_of_type_Sio;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  static
  {
    jdField_a_of_type_Sji = new sji(null);
  }
  
  public sjh(@Nullable TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = paramTVK_IMediaPlayer;
    this.jdField_a_of_type_Float = 1.0F;
  }
  
  public void OnDownloadCallback(@Nullable String paramString)
  {
    sio localsio = this.jdField_a_of_type_Sio;
    if (localsio != null) {
      localsio.a(paramString);
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
  public six a()
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
  
  public void a(@NotNull Context paramContext, @NotNull sja paramsja, long paramLong, @NotNull SuperPlayerOption paramSuperPlayerOption)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramsja, "videoInfo");
    Intrinsics.checkParameterIsNotNull(paramSuperPlayerOption, "playerOption");
    this.b = paramsja.c();
    this.jdField_a_of_type_Boolean = false;
    paramSuperPlayerOption = sjb.a(paramsja);
    TVK_PlayerVideoInfo localTVK_PlayerVideoInfo = sjb.a(paramsja);
    Object localObject = paramsja.a();
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
          ((TVK_IMediaPlayer)localObject).openMediaPlayerByUrl(paramContext.getApplicationContext(), paramsja.a(), paramLong, 0L, localTVK_PlayerVideoInfo, paramSuperPlayerOption, paramsja.c());
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
      paramsja = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    } while (paramsja == null);
    paramsja.openMediaPlayer(paramContext.getApplicationContext(), paramSuperPlayerOption, localTVK_PlayerVideoInfo, "", paramLong, 0L);
  }
  
  public void a(@Nullable sio paramsio)
  {
    this.jdField_a_of_type_Sio = paramsio;
    paramsio = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    if (paramsio != null) {
      paramsio.setOnVideoPreparedListener((TVK_IMediaPlayer.OnVideoPreparedListener)this);
    }
    paramsio = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    if (paramsio != null) {
      paramsio.setOnCompletionListener((TVK_IMediaPlayer.OnCompletionListener)this);
    }
    paramsio = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    if (paramsio != null) {
      paramsio.setOnErrorListener((TVK_IMediaPlayer.OnErrorListener)this);
    }
    paramsio = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    if (paramsio != null) {
      paramsio.setOnInfoListener((TVK_IMediaPlayer.OnInfoListener)this);
    }
    paramsio = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    if (paramsio != null) {
      paramsio.setOnCaptureImageListener((TVK_IMediaPlayer.OnCaptureImageListener)this);
    }
    paramsio = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    if (paramsio != null) {
      paramsio.setOnSeekCompleteListener((TVK_IMediaPlayer.OnSeekCompleteListener)this);
    }
    paramsio = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    if (paramsio != null) {
      paramsio.setOnDownloadCallback((TVK_IMediaPlayer.OnDownloadCallbackListener)this);
    }
  }
  
  public void a(@Nullable six paramsix)
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    if (localTVK_IMediaPlayer != null) {
      if (paramsix == null) {
        break label42;
      }
    }
    label42:
    for (paramsix = paramsix.a();; paramsix = null)
    {
      six localsix = paramsix;
      if (!(paramsix instanceof IVideoViewBase)) {
        localsix = null;
      }
      localTVK_IMediaPlayer.updatePlayerVideoView((IVideoViewBase)localsix);
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
    paramTVK_IMediaPlayer = this.jdField_a_of_type_Sio;
    if (paramTVK_IMediaPlayer != null) {
      paramTVK_IMediaPlayer.a((sip)this, paramInt1, paramInt2);
    }
  }
  
  public void onCaptureImageSucceed(@Nullable TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, @Nullable Bitmap paramBitmap)
  {
    paramTVK_IMediaPlayer = this.jdField_a_of_type_Sio;
    if (paramTVK_IMediaPlayer != null) {
      paramTVK_IMediaPlayer.a((sip)this, paramInt1, paramInt2, paramInt3, paramBitmap);
    }
  }
  
  public void onCompletion(@Nullable TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    paramTVK_IMediaPlayer = this.jdField_a_of_type_Sio;
    if (paramTVK_IMediaPlayer != null) {
      paramTVK_IMediaPlayer.b((sip)this);
    }
  }
  
  public boolean onError(@Nullable TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, @Nullable String paramString, @Nullable Object paramObject)
  {
    boolean bool2 = false;
    paramTVK_IMediaPlayer = this.jdField_a_of_type_Sio;
    boolean bool1 = bool2;
    if (paramTVK_IMediaPlayer != null)
    {
      bool1 = bool2;
      if (paramTVK_IMediaPlayer.a((sip)this, 0, paramInt1, paramInt2, paramString) == true) {
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
      paramTVK_IMediaPlayer = this.jdField_a_of_type_Sio;
      if ((paramTVK_IMediaPlayer == null) || (paramTVK_IMediaPlayer.a((sip)this, paramInt, paramObject) != true)) {
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
    paramTVK_IMediaPlayer = this.jdField_a_of_type_Sio;
    if (paramTVK_IMediaPlayer != null) {
      paramTVK_IMediaPlayer.c((sip)this);
    }
  }
  
  public void onVideoPrepared(@Nullable TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    sio localsio = this.jdField_a_of_type_Sio;
    if (localsio != null) {
      localsio.a((sip)this);
    }
    if ((!this.jdField_a_of_type_Boolean) && (this.b))
    {
      this.jdField_a_of_type_Boolean = true;
      onInfo(paramTVK_IMediaPlayer, 105, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sjh
 * JD-Core Version:    0.7.0.1
 */