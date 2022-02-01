import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.superplayer.api.SuperPlayerFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/superplayer/SuperPlayerFactory;", "Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/IPlayerFactory;", "()V", "createMediaPlayer", "Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/IPlayer;", "videoView", "Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/IVideoView;", "createPlayerVideoView", "context", "Landroid/content/Context;", "isUseTextureView", "", "createPreloader", "Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/IPlayerPreloader;", "obtainMediaPlayer", "token", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class shl
  implements sgz
{
  public static final shl a = new shl();
  
  @Nullable
  public sgx a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "token");
    paramString = SuperPlayerFactory.obtainMediaPlayer(paramString);
    if (paramString != null) {
      return (sgx)new shk(paramString);
    }
    return null;
  }
  
  @NotNull
  public sgx a(@Nullable shf paramshf)
  {
    if (azjl.a()) {
      return (sgx)new shk(SuperPlayerFactory.createMediaPlayer((Context)BaseApplicationImpl.getContext(), 104, null));
    }
    return (sgx)new shk(null);
  }
  
  @NotNull
  public sha a()
  {
    if (azjl.a()) {
      return (sha)new shm(SuperPlayerFactory.createPreDownloader((Context)BaseApplicationImpl.getContext(), 104));
    }
    return (sha)new shm(null);
  }
  
  @NotNull
  public shf a(@NotNull Context paramContext, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    if (azjl.a()) {
      return (shf)new sho(SuperPlayerFactory.createPlayerVideoView(paramContext));
    }
    return (shf)new sho(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     shl
 * JD-Core Version:    0.7.0.1
 */