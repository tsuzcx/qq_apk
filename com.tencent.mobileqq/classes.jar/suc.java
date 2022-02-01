import com.tencent.superplayer.api.ISPlayerPreDownloader;
import com.tencent.superplayer.api.ISPlayerPreDownloader.Listener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/superplayer/SuperPlayerPreloader;", "Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/IPlayerPreloader;", "Lcom/tencent/superplayer/api/ISPlayerPreDownloader$Listener;", "preloader", "Lcom/tencent/superplayer/api/ISPlayerPreDownloader;", "(Lcom/tencent/superplayer/api/ISPlayerPreDownloader;)V", "listener", "Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/IPlayerPreloader$Listener;", "destory", "", "isVideoCached", "", "videoInfo", "Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/PlayerVideoInfo;", "onPrepareDownloadProgressUpdate", "p0", "p1", "p2", "p3", "", "p4", "onPrepareError", "onPrepareSuccess", "setPreDownloadListener", "startPreDownload", "videoDurationMs", "preloadDurationMs", "stopPreDownload", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class suc
  implements ISPlayerPreDownloader.Listener, stq
{
  private final ISPlayerPreDownloader jdField_a_of_type_ComTencentSuperplayerApiISPlayerPreDownloader;
  private sts jdField_a_of_type_Sts;
  
  public suc(@Nullable ISPlayerPreDownloader paramISPlayerPreDownloader)
  {
    this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerPreDownloader = paramISPlayerPreDownloader;
  }
  
  public int a(@NotNull sty paramsty)
  {
    Intrinsics.checkParameterIsNotNull(paramsty, "videoInfo");
    return 0;
  }
  
  public void a()
  {
    ISPlayerPreDownloader localISPlayerPreDownloader = this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerPreDownloader;
    if (localISPlayerPreDownloader != null) {
      localISPlayerPreDownloader.stopAllPreDownload();
    }
  }
  
  public void a(@Nullable sts paramsts)
  {
    this.jdField_a_of_type_Sts = paramsts;
    paramsts = this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerPreDownloader;
    if (paramsts != null) {
      paramsts.setOnPreDownloadListener((ISPlayerPreDownloader.Listener)this);
    }
  }
  
  public void a(@NotNull sty paramsty, long paramLong1, long paramLong2)
  {
    Intrinsics.checkParameterIsNotNull(paramsty, "videoInfo");
    ISPlayerPreDownloader localISPlayerPreDownloader = this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerPreDownloader;
    if (localISPlayerPreDownloader != null) {
      localISPlayerPreDownloader.startPreDownload(stz.a(paramsty), paramLong1, paramLong2);
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
    sts localsts = this.jdField_a_of_type_Sts;
    if (localsts != null) {
      localsts.a();
    }
  }
  
  public void onPrepareSuccess(int paramInt)
  {
    sts localsts = this.jdField_a_of_type_Sts;
    if (localsts != null) {
      localsts.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     suc
 * JD-Core Version:    0.7.0.1
 */