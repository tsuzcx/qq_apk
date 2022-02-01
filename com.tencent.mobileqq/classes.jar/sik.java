import android.os.Bundle;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoInfo.EntranceDownloadInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsFirstVideoRecommendationManager.VideoFeedsFirstRecommendObserver.1;
import com.tencent.mobileqq.app.ThreadManager;
import java.lang.ref.WeakReference;
import java.util.List;

public class sik
  extends omw
{
  private WeakReference<sij> a;
  
  public sik(sij paramsij)
  {
    this.a = new WeakReference(paramsij);
  }
  
  private void a(VideoInfo paramVideoInfo, sij paramsij)
  {
    if (paramsij == null) {}
    while (paramVideoInfo == null) {
      return;
    }
    ThreadManager.post(new VideoFeedsFirstVideoRecommendationManager.VideoFeedsFirstRecommendObserver.1(this, paramsij, paramVideoInfo), 5, null, true);
  }
  
  protected void a(boolean paramBoolean, Bundle paramBundle)
  {
    boolean bool = paramBundle.getBoolean("is_from_first_recommend_video");
    sij localsij = (sij)this.a.get();
    if (localsij == null) {}
    while (!bool) {
      return;
    }
    Object localObject1 = (VideoInfo.EntranceDownloadInfo)paramBundle.getParcelable("value_entrance_download_info");
    if (localObject1 != null)
    {
      sij.a(localsij, (VideoInfo.EntranceDownloadInfo)localObject1);
      return;
    }
    sij.a(localsij, paramBundle.getString("VALUE_COOKIE"));
    Object localObject2 = null;
    localObject1 = localObject2;
    if (paramBoolean)
    {
      paramBundle = paramBundle.getParcelableArrayList("VIDEO_RECOMMEND_LIST");
      localObject1 = localObject2;
      if (paramBundle != null)
      {
        localObject1 = localObject2;
        if (paramBundle.size() > 0)
        {
          localObject1 = (VideoInfo)paramBundle.get(0);
          sij.a(localsij, (VideoInfo)localObject1);
        }
      }
    }
    a((VideoInfo)localObject1, localsij);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sik
 * JD-Core Version:    0.7.0.1
 */