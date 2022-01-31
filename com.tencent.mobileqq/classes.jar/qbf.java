import android.os.Bundle;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoInfo.EntranceDownloadInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsFirstVideoRecommendationManager.VideoFeedsFirstRecommendObserver.1;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.List;

public class qbf
  extends nev
{
  private qbf(qbe paramqbe) {}
  
  protected void a(boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBundle.getBoolean("is_from_first_recommend_video"))
    {
      VideoInfo.EntranceDownloadInfo localEntranceDownloadInfo = (VideoInfo.EntranceDownloadInfo)paramBundle.getParcelable("value_entrance_download_info");
      if (localEntranceDownloadInfo == null) {
        break label32;
      }
      qbe.a(this.a, localEntranceDownloadInfo);
    }
    for (;;)
    {
      return;
      label32:
      qbe.a(this.a, paramBundle.getString("VALUE_COOKIE"));
      if (paramBoolean)
      {
        paramBundle = paramBundle.getParcelableArrayList("VIDEO_RECOMMEND_LIST");
        if ((paramBundle != null) && (paramBundle.size() > 0))
        {
          paramBundle = (VideoInfo)paramBundle.get(0);
          qbe.a(this.a, paramBundle);
        }
      }
      while (paramBundle != null)
      {
        ThreadManager.post(new VideoFeedsFirstVideoRecommendationManager.VideoFeedsFirstRecommendObserver.1(this, paramBundle), 5, null, true);
        return;
        paramBundle = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qbf
 * JD-Core Version:    0.7.0.1
 */