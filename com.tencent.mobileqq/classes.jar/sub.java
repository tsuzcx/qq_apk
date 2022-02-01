import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.superplayer.api.SuperPlayerFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/superplayer/SuperPlayerFactory;", "Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/IPlayerFactory;", "()V", "createMediaPlayer", "Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/IPlayer;", "videoView", "Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/IVideoView;", "createPlayerVideoView", "context", "Landroid/content/Context;", "isUseTextureView", "", "createPreloader", "Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/IPlayerPreloader;", "obtainMediaPlayer", "token", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class sub
  implements stp
{
  public static final sub a = new sub();
  
  @Nullable
  public stn a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "token");
    paramString = SuperPlayerFactory.obtainMediaPlayer(paramString);
    if (paramString != null) {
      return (stn)new sua(paramString);
    }
    return null;
  }
  
  @NotNull
  public stn a(@Nullable stv paramstv)
  {
    if (bapt.a()) {
      return (stn)new sua(SuperPlayerFactory.createMediaPlayer((Context)BaseApplicationImpl.getContext(), 104, null));
    }
    return (stn)new sua(null);
  }
  
  @NotNull
  public stq a()
  {
    if (bapt.a()) {
      return (stq)new suc(SuperPlayerFactory.createPreDownloader((Context)BaseApplicationImpl.getContext(), 104));
    }
    return (stq)new suc(null);
  }
  
  @NotNull
  public stv a(@NotNull Context paramContext, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    if (bapt.a()) {
      return (stv)new sue(SuperPlayerFactory.createPlayerVideoView(paramContext));
    }
    return (stv)new sue(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sub
 * JD-Core Version:    0.7.0.1
 */