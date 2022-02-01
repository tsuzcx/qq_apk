import android.content.Context;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/IPlayerFactory;", "", "createMediaPlayer", "Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/IPlayer;", "videoView", "Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/IVideoView;", "createPlayerVideoView", "context", "Landroid/content/Context;", "isUseTextureView", "", "createPreloader", "Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/IPlayerPreloader;", "obtainMediaPlayer", "token", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public abstract interface stp
{
  @Nullable
  public abstract stn a(@NotNull String paramString);
  
  @NotNull
  public abstract stn a(@Nullable stv paramstv);
  
  @NotNull
  public abstract stq a();
  
  @NotNull
  public abstract stv a(@NotNull Context paramContext, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     stp
 * JD-Core Version:    0.7.0.1
 */