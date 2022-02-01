import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.superplayer.api.SuperPlayerFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/superplayer/SuperPlayerFactory;", "Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/IPlayerFactory;", "()V", "createMediaPlayer", "Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/IPlayer;", "videoView", "Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/IVideoView;", "createPlayerVideoView", "context", "Landroid/content/Context;", "isUseTextureView", "", "createPreloader", "Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/IPlayerPreloader;", "obtainMediaPlayer", "token", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class sah
  implements rzv
{
  public static final sah a = new sah();
  
  @Nullable
  public rzt a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "token");
    paramString = SuperPlayerFactory.obtainMediaPlayer(paramString);
    if (paramString != null) {
      return (rzt)new sag(paramString);
    }
    return null;
  }
  
  @NotNull
  public rzt a(@Nullable sab paramsab)
  {
    if (bapg.a()) {
      return (rzt)new sag(SuperPlayerFactory.createMediaPlayer((Context)BaseApplicationImpl.getContext(), 104, null));
    }
    return (rzt)new sag(null);
  }
  
  @NotNull
  public rzw a()
  {
    if (bapg.a()) {
      return (rzw)new sai(SuperPlayerFactory.createPreDownloader((Context)BaseApplicationImpl.getContext(), 104));
    }
    return (rzw)new sai(null);
  }
  
  @NotNull
  public sab a(@NotNull Context paramContext, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    if (bapg.a()) {
      return (sab)new sak(SuperPlayerFactory.createPlayerVideoView(paramContext));
    }
    return (sab)new sak(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sah
 * JD-Core Version:    0.7.0.1
 */