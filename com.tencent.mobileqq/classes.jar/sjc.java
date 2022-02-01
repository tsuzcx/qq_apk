import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.ISuperPlayer.OnCaptureImageListener;
import com.tencent.superplayer.api.ISuperPlayer.OnCompletionListener;
import com.tencent.superplayer.api.ISuperPlayer.OnErrorListener;
import com.tencent.superplayer.api.ISuperPlayer.OnInfoListener;
import com.tencent.superplayer.api.ISuperPlayer.OnSeekCompleteListener;
import com.tencent.superplayer.api.ISuperPlayer.OnVideoPreparedListener;
import com.tencent.superplayer.api.SuperPlayerOption;
import com.tencent.superplayer.view.ISPlayerVideoView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/superplayer/SuperPlayer;", "Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/IPlayer;", "Lcom/tencent/superplayer/api/ISuperPlayer$OnVideoPreparedListener;", "Lcom/tencent/superplayer/api/ISuperPlayer$OnCompletionListener;", "Lcom/tencent/superplayer/api/ISuperPlayer$OnErrorListener;", "Lcom/tencent/superplayer/api/ISuperPlayer$OnInfoListener;", "Lcom/tencent/superplayer/api/ISuperPlayer$OnCaptureImageListener;", "Lcom/tencent/superplayer/api/ISuperPlayer$OnSeekCompleteListener;", "videoPlayer", "Lcom/tencent/superplayer/api/ISuperPlayer;", "(Lcom/tencent/superplayer/api/ISuperPlayer;)V", "currentPositionMs", "", "getCurrentPositionMs", "()J", "currentVideoView", "Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/IVideoView;", "durationMs", "getDurationMs", "isBuffering", "", "()Z", "value", "isLoopBack", "setLoopBack", "(Z)V", "isPauseing", "isPlaying", "isPrepared", "isPrepareing", "listener", "Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/IEventListener;", "outputMute", "getOutputMute", "setOutputMute", "", "speedRatio", "getSpeedRatio", "()F", "setSpeedRatio", "(F)V", "videoHeight", "", "getVideoHeight", "()I", "videoWidth", "getVideoWidth", "getStreamDumpInfo", "", "getToken", "getVideoView", "onCaptureImageFailed", "", "p0", "id", "errorCode", "onCaptureImageSucceed", "width", "height", "bitmap", "Landroid/graphics/Bitmap;", "onCompletion", "onError", "tvkPlayer", "module", "errorType", "extraInfo", "onInfo", "what", "arg1", "arg2", "extra", "", "onSeekComplete", "onVideoPrepared", "openMediaPlayer", "context", "Landroid/content/Context;", "videoInfo", "Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/PlayerVideoInfo;", "startPositionMilsec", "playerOption", "Lcom/tencent/superplayer/api/SuperPlayerOption;", "pause", "pauseDownload", "prePlayViewShow", "release", "resumeDownload", "seekTo", "positionMilsec", "mode", "setEventListener", "setHttpBufferRange", "emergencyTime", "safePlayTime", "preloadDuration", "setLoopback", "isLoopback", "setXYaxis", "type", "start", "stop", "updatePlayerVideoView", "videoView", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class sjc
  implements ISuperPlayer.OnCaptureImageListener, ISuperPlayer.OnCompletionListener, ISuperPlayer.OnErrorListener, ISuperPlayer.OnInfoListener, ISuperPlayer.OnSeekCompleteListener, ISuperPlayer.OnVideoPreparedListener, sip
{
  private float jdField_a_of_type_Float;
  private final ISuperPlayer jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
  private sio jdField_a_of_type_Sio;
  private six jdField_a_of_type_Six;
  
  public sjc(@Nullable ISuperPlayer paramISuperPlayer)
  {
    this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer = paramISuperPlayer;
    this.jdField_a_of_type_Float = 1.0F;
  }
  
  public int a()
  {
    ISuperPlayer localISuperPlayer = this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
    if (localISuperPlayer != null) {
      return localISuperPlayer.getVideoWidth();
    }
    return 0;
  }
  
  public long a()
  {
    ISuperPlayer localISuperPlayer = this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
    if (localISuperPlayer != null) {
      return localISuperPlayer.getDurationMs();
    }
    return 0L;
  }
  
  @Nullable
  public String a()
  {
    ISuperPlayer localISuperPlayer = this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
    if (localISuperPlayer != null) {
      return localISuperPlayer.getStreamDumpInfo();
    }
    return null;
  }
  
  @Nullable
  public six a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
    if (localObject != null)
    {
      localObject = ((ISuperPlayer)localObject).getVideoView();
      if (localObject != null) {
        return (six)new sjg((ISPlayerVideoView)localObject);
      }
    }
    return null;
  }
  
  public void a()
  {
    ISuperPlayer localISuperPlayer = this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
    if (localISuperPlayer != null) {
      localISuperPlayer.start();
    }
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
    ISuperPlayer localISuperPlayer = this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
    if (localISuperPlayer != null) {
      localISuperPlayer.setPlaySpeedRatio(this.jdField_a_of_type_Float);
    }
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
      ISuperPlayer localISuperPlayer = this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
      if (localISuperPlayer != null) {
        localISuperPlayer.setXYaxis(i);
      }
      return;
      i = 1;
      continue;
      i = 2;
      continue;
      i = 3;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    int j = 1;
    int i = j;
    switch (paramInt2)
    {
    default: 
      i = j;
    }
    for (;;)
    {
      ISuperPlayer localISuperPlayer = this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
      if (localISuperPlayer != null) {
        localISuperPlayer.seekTo(paramInt1, i);
      }
      return;
      i = 3;
      continue;
      i = 2;
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    ISuperPlayer localISuperPlayer = this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
    if (localISuperPlayer != null) {
      localISuperPlayer.setBusinessDownloadStrategy(paramInt1, paramInt2, paramInt3, paramInt3);
    }
  }
  
  public void a(@NotNull Context paramContext, @NotNull sja paramsja, long paramLong, @NotNull SuperPlayerOption paramSuperPlayerOption)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramsja, "videoInfo");
    Intrinsics.checkParameterIsNotNull(paramSuperPlayerOption, "playerOption");
    ISuperPlayer localISuperPlayer = this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
    if (localISuperPlayer != null) {
      localISuperPlayer.openMediaPlayer(paramContext.getApplicationContext(), sjb.a(paramsja), paramLong, paramSuperPlayerOption);
    }
  }
  
  public void a(@Nullable sio paramsio)
  {
    this.jdField_a_of_type_Sio = paramsio;
    paramsio = this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
    if (paramsio != null) {
      paramsio.setOnVideoPreparedListener((ISuperPlayer.OnVideoPreparedListener)this);
    }
    paramsio = this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
    if (paramsio != null) {
      paramsio.setOnCompletionListener((ISuperPlayer.OnCompletionListener)this);
    }
    paramsio = this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
    if (paramsio != null) {
      paramsio.setOnErrorListener((ISuperPlayer.OnErrorListener)this);
    }
    paramsio = this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
    if (paramsio != null) {
      paramsio.setOnInfoListener((ISuperPlayer.OnInfoListener)this);
    }
    paramsio = this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
    if (paramsio != null) {
      paramsio.setOnCaptureImageListener((ISuperPlayer.OnCaptureImageListener)this);
    }
    paramsio = this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
    if (paramsio != null) {
      paramsio.setOnSeekCompleteListener((ISuperPlayer.OnSeekCompleteListener)this);
    }
  }
  
  public void a(@Nullable six paramsix)
  {
    this.jdField_a_of_type_Six = paramsix;
    ISuperPlayer localISuperPlayer = this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
    if (localISuperPlayer != null) {
      if (paramsix == null) {
        break label47;
      }
    }
    label47:
    for (paramsix = paramsix.a();; paramsix = null)
    {
      six localsix = paramsix;
      if (!(paramsix instanceof ISPlayerVideoView)) {
        localsix = null;
      }
      localISuperPlayer.updatePlayerVideoView((ISPlayerVideoView)localsix);
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    ISuperPlayer localISuperPlayer = this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
    if (localISuperPlayer != null) {
      localISuperPlayer.setOutputMute(paramBoolean);
    }
  }
  
  public boolean a()
  {
    ISuperPlayer localISuperPlayer = this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
    return (localISuperPlayer != null) && (localISuperPlayer.isOutputMute() == true);
  }
  
  public int b()
  {
    ISuperPlayer localISuperPlayer = this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
    if (localISuperPlayer != null) {
      return localISuperPlayer.getVideoHeight();
    }
    return 0;
  }
  
  public long b()
  {
    ISuperPlayer localISuperPlayer = this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
    if (localISuperPlayer != null) {
      return localISuperPlayer.getCurrentPositionMs();
    }
    return 0L;
  }
  
  @NotNull
  public String b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
    if (localObject != null)
    {
      localObject = ((ISuperPlayer)localObject).getToken();
      if (localObject != null) {
        return localObject;
      }
    }
    return "";
  }
  
  public void b()
  {
    ISuperPlayer localISuperPlayer = this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
    if (localISuperPlayer != null) {
      localISuperPlayer.pause();
    }
  }
  
  public void b(boolean paramBoolean)
  {
    ISuperPlayer localISuperPlayer = this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
    if (localISuperPlayer != null) {
      localISuperPlayer.setLoopback(paramBoolean);
    }
  }
  
  public boolean b()
  {
    ISuperPlayer localISuperPlayer = this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
    return (localISuperPlayer != null) && (localISuperPlayer.isPlaying() == true);
  }
  
  public void c()
  {
    Object localObject = this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
    if (localObject != null) {
      ((ISuperPlayer)localObject).reset();
    }
    localObject = this.jdField_a_of_type_Six;
    if (localObject != null)
    {
      ISuperPlayer localISuperPlayer = this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
      if (localISuperPlayer != null)
      {
        View localView = ((six)localObject).a();
        localObject = localView;
        if (!(localView instanceof ISPlayerVideoView)) {
          localObject = null;
        }
        localISuperPlayer.updatePlayerVideoView((ISPlayerVideoView)localObject);
      }
    }
  }
  
  public boolean c()
  {
    ISuperPlayer localISuperPlayer = this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
    return (localISuperPlayer != null) && (localISuperPlayer.isBuffering() == true);
  }
  
  public void d()
  {
    ISuperPlayer localISuperPlayer = this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
    if (localISuperPlayer != null) {
      localISuperPlayer.stop();
    }
    localISuperPlayer = this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
    if (localISuperPlayer != null) {
      localISuperPlayer.release();
    }
  }
  
  public boolean d()
  {
    boolean bool2 = true;
    Object localObject = this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
    if (localObject != null)
    {
      localObject = Integer.valueOf(((ISuperPlayer)localObject).getCurrentPlayerState());
      if (localObject != null) {
        break label42;
      }
      label25:
      if (localObject != null) {
        break label55;
      }
      label29:
      if (localObject != null) {
        break label68;
      }
    }
    label42:
    label55:
    label68:
    while (((Integer)localObject).intValue() != 2)
    {
      boolean bool1 = false;
      do
      {
        do
        {
          return bool1;
          localObject = null;
          break;
          bool1 = bool2;
        } while (((Integer)localObject).intValue() == 3);
        break label25;
        bool1 = bool2;
      } while (((Integer)localObject).intValue() == 1);
      break label29;
    }
    return true;
  }
  
  public void e()
  {
    ISuperPlayer localISuperPlayer = this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
    if (localISuperPlayer != null) {
      localISuperPlayer.pauseDownload();
    }
  }
  
  public boolean e()
  {
    ISuperPlayer localISuperPlayer = this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
    return (localISuperPlayer != null) && (localISuperPlayer.getCurrentPlayerState() == 4);
  }
  
  public void f()
  {
    ISuperPlayer localISuperPlayer = this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
    if (localISuperPlayer != null) {
      localISuperPlayer.resumeDownload();
    }
  }
  
  public boolean f()
  {
    ISuperPlayer localISuperPlayer = this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
    return (localISuperPlayer != null) && (localISuperPlayer.isPausing() == true);
  }
  
  public void g()
  {
    ISuperPlayer localISuperPlayer = this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
    if (localISuperPlayer != null) {
      localISuperPlayer.onPrePlayViewShow();
    }
  }
  
  public void onCaptureImageFailed(@Nullable ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2)
  {
    paramISuperPlayer = this.jdField_a_of_type_Sio;
    if (paramISuperPlayer != null) {
      paramISuperPlayer.a((sip)this, paramInt1, paramInt2);
    }
  }
  
  public void onCaptureImageSucceed(@Nullable ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2, int paramInt3, @Nullable Bitmap paramBitmap)
  {
    paramISuperPlayer = this.jdField_a_of_type_Sio;
    if (paramISuperPlayer != null) {
      paramISuperPlayer.a((sip)this, paramInt1, paramInt2, paramInt3, paramBitmap);
    }
  }
  
  public void onCompletion(@Nullable ISuperPlayer paramISuperPlayer)
  {
    paramISuperPlayer = this.jdField_a_of_type_Sio;
    if (paramISuperPlayer != null) {
      paramISuperPlayer.b((sip)this);
    }
  }
  
  public boolean onError(@Nullable ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2, int paramInt3, @Nullable String paramString)
  {
    paramISuperPlayer = this.jdField_a_of_type_Sio;
    return (paramISuperPlayer != null) && (paramISuperPlayer.a((sip)this, paramInt1, paramInt2, paramInt3, paramString) == true);
  }
  
  public boolean onInfo(@Nullable ISuperPlayer paramISuperPlayer, int paramInt, long paramLong1, long paramLong2, @Nullable Object paramObject)
  {
    int i;
    switch (paramInt)
    {
    case 106: 
    case 107: 
    case 109: 
    case 110: 
    case 111: 
    default: 
      i = paramInt;
      if (i != 209) {
        break;
      }
    }
    for (paramISuperPlayer = Long.valueOf(paramLong1);; paramISuperPlayer = paramObject)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SuperPlayer", 2, "onInfo: what=" + paramInt + ", arg1=" + paramLong1 + ", arg2=" + paramLong2 + ", extra=" + paramObject);
      }
      paramObject = this.jdField_a_of_type_Sio;
      if ((paramObject != null) && (paramObject.a((sip)this, i, paramISuperPlayer) == true))
      {
        return true;
        i = 112;
        break;
        i = 113;
        break;
        i = 105;
        break;
        i = 108;
        break;
      }
      return false;
    }
  }
  
  public void onSeekComplete(@Nullable ISuperPlayer paramISuperPlayer)
  {
    paramISuperPlayer = this.jdField_a_of_type_Sio;
    if (paramISuperPlayer != null) {
      paramISuperPlayer.c((sip)this);
    }
  }
  
  public void onVideoPrepared(@Nullable ISuperPlayer paramISuperPlayer)
  {
    paramISuperPlayer = this.jdField_a_of_type_Sio;
    if (paramISuperPlayer != null) {
      paramISuperPlayer.a((sip)this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sjc
 * JD-Core Version:    0.7.0.1
 */