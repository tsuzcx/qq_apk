import com.tencent.superplayer.api.ISPlayerPreDownloader;
import com.tencent.superplayer.api.ISPlayerPreDownloader.Listener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/superplayer/SuperPlayerPreloader;", "Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/IPlayerPreloader;", "Lcom/tencent/superplayer/api/ISPlayerPreDownloader$Listener;", "preloader", "Lcom/tencent/superplayer/api/ISPlayerPreDownloader;", "(Lcom/tencent/superplayer/api/ISPlayerPreDownloader;)V", "listener", "Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/IPlayerPreloader$Listener;", "destory", "", "isVideoCached", "", "videoInfo", "Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/PlayerVideoInfo;", "onPrepareDownloadProgressUpdate", "p0", "p1", "p2", "p3", "", "p4", "onPrepareError", "onPrepareSuccess", "setPreDownloadListener", "startPreDownload", "videoDurationMs", "preloadDurationMs", "stopPreDownload", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class sai
  implements ISPlayerPreDownloader.Listener, rzw
{
  private final ISPlayerPreDownloader jdField_a_of_type_ComTencentSuperplayerApiISPlayerPreDownloader;
  private rzy jdField_a_of_type_Rzy;
  
  public sai(@Nullable ISPlayerPreDownloader paramISPlayerPreDownloader)
  {
    this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerPreDownloader = paramISPlayerPreDownloader;
  }
  
  public int a(@NotNull sae paramsae)
  {
    Intrinsics.checkParameterIsNotNull(paramsae, "videoInfo");
    return 0;
  }
  
  public void a()
  {
    ISPlayerPreDownloader localISPlayerPreDownloader = this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerPreDownloader;
    if (localISPlayerPreDownloader != null) {
      localISPlayerPreDownloader.stopAllPreDownload();
    }
  }
  
  public void a(@Nullable rzy paramrzy)
  {
    this.jdField_a_of_type_Rzy = paramrzy;
    paramrzy = this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerPreDownloader;
    if (paramrzy != null) {
      paramrzy.setOnPreDownloadListener((ISPlayerPreDownloader.Listener)this);
    }
  }
  
  public void a(@NotNull sae paramsae, long paramLong1, long paramLong2)
  {
    Intrinsics.checkParameterIsNotNull(paramsae, "videoInfo");
    ISPlayerPreDownloader localISPlayerPreDownloader = this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerPreDownloader;
    if (localISPlayerPreDownloader != null) {
      localISPlayerPreDownloader.startPreDownload(saf.a(paramsae), paramLong1, paramLong2);
    }
  }
  
  public void b()
  {
    ISPlayerPreDownloader localISPlayerPreDownloader = this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerPreDownloader;
    if (localISPlayerPreDownloader != null) {
      localISPlayerPreDownloader.destory();
    }
  }
  
  public void onPrepareDownloadProgressUpdate(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2) {}
  
  public void onPrepareError(int paramInt)
  {
    rzy localrzy = this.jdField_a_of_type_Rzy;
    if (localrzy != null) {
      localrzy.a();
    }
  }
  
  public void onPrepareSuccess(int paramInt)
  {
    rzy localrzy = this.jdField_a_of_type_Rzy;
    if (localrzy != null) {
      localrzy.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sai
 * JD-Core Version:    0.7.0.1
 */