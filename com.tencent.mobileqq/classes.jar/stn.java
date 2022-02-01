import android.content.Context;
import com.tencent.superplayer.api.SuperPlayerOption;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/IPlayer;", "", "currentPositionMs", "", "getCurrentPositionMs", "()J", "durationMs", "getDurationMs", "isBuffering", "", "()Z", "isLoopBack", "setLoopBack", "(Z)V", "isPauseing", "isPlaying", "isPrepared", "isPrepareing", "outputMute", "getOutputMute", "setOutputMute", "speedRatio", "", "getSpeedRatio", "()F", "setSpeedRatio", "(F)V", "videoHeight", "", "getVideoHeight", "()I", "videoWidth", "getVideoWidth", "addExtReportData", "", "data", "", "", "getStreamDumpInfo", "getToken", "getVideoView", "Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/IVideoView;", "openMediaPlayer", "context", "Landroid/content/Context;", "videoInfo", "Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/PlayerVideoInfo;", "startPositionMilsec", "playerOption", "Lcom/tencent/superplayer/api/SuperPlayerOption;", "pause", "pauseDownload", "prePlayViewShow", "release", "resumeDownload", "seekTo", "positionMilsec", "mode", "setEventListener", "listener", "Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/IEventListener;", "setHttpBufferRange", "emergencyTime", "safePlayTime", "preloadDuration", "setLoopback", "isLoopback", "setXYaxis", "type", "start", "stop", "updatePlayerVideoView", "videoView", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public abstract interface stn
{
  public static final sto a = sto.a;
  
  public abstract int a();
  
  public abstract long a();
  
  @Nullable
  public abstract String a();
  
  @Nullable
  public abstract stv a();
  
  public abstract void a();
  
  public abstract void a(float paramFloat);
  
  public abstract void a(int paramInt);
  
  public abstract void a(int paramInt1, int paramInt2);
  
  public abstract void a(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void a(@NotNull Context paramContext, @NotNull sty paramsty, long paramLong, @NotNull SuperPlayerOption paramSuperPlayerOption);
  
  public abstract void a(@NotNull Map<String, String> paramMap);
  
  public abstract void a(@Nullable stm paramstm);
  
  public abstract void a(@Nullable stv paramstv);
  
  public abstract void a(boolean paramBoolean);
  
  public abstract boolean a();
  
  public abstract int b();
  
  public abstract long b();
  
  @NotNull
  public abstract String b();
  
  public abstract void b();
  
  public abstract void b(boolean paramBoolean);
  
  public abstract boolean b();
  
  public abstract void c();
  
  public abstract boolean c();
  
  public abstract void d();
  
  public abstract boolean d();
  
  public abstract void e();
  
  public abstract boolean e();
  
  public abstract void f();
  
  public abstract boolean f();
  
  public abstract void g();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     stn
 * JD-Core Version:    0.7.0.1
 */