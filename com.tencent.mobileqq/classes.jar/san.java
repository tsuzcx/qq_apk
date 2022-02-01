import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_ICacheMgr;
import com.tencent.qqlive.mediaplayer.api.TVK_IProxyFactory;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import com.tencent.util.VersionUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/tvk/TVKPlayerFactory;", "Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/IPlayerFactory;", "()V", "createMediaPlayer", "Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/IPlayer;", "videoView", "Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/IVideoView;", "createPlayerVideoView", "context", "Landroid/content/Context;", "isUseTextureView", "", "createPreloader", "Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/IPlayerPreloader;", "obtainMediaPlayer", "token", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class san
  implements rzv
{
  public static final san a = new san();
  
  @Nullable
  public rzt a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "token");
    return null;
  }
  
  @NotNull
  public rzt a(@Nullable sab paramsab)
  {
    paramsab = null;
    TVK_IProxyFactory localTVK_IProxyFactory = TVK_SDKMgr.getProxyFactory();
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "VideoPlayerWrapper initPlayer success!");
    }
    if (localTVK_IProxyFactory != null) {
      paramsab = localTVK_IProxyFactory.createMediaPlayer((Context)BaseApplicationImpl.getContext(), null);
    }
    return (rzt)new sal(paramsab);
  }
  
  @NotNull
  public rzw a()
  {
    Object localObject = TVK_SDKMgr.getProxyFactory();
    if (localObject != null) {}
    for (localObject = ((TVK_IProxyFactory)localObject).getCacheMgr((Context)BaseApplicationImpl.getContext());; localObject = null) {
      return (rzw)new sap((TVK_ICacheMgr)localObject);
    }
  }
  
  @NotNull
  public sab a(@NotNull Context paramContext, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    TVK_IProxyFactory localTVK_IProxyFactory = TVK_SDKMgr.getProxyFactory();
    if (VersionUtils.isIceScreamSandwich()) {
      if (localTVK_IProxyFactory != null) {
        paramContext = localTVK_IProxyFactory.createVideoView_Scroll(paramContext);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "createPlayerVideoView: ");
      }
      return (sab)new saq(paramContext);
      paramContext = null;
      continue;
      if (localTVK_IProxyFactory != null) {
        paramContext = localTVK_IProxyFactory.createVideoView(paramContext);
      } else {
        paramContext = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     san
 * JD-Core Version:    0.7.0.1
 */