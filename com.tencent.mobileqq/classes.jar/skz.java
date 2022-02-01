import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayActivity;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecommendFragment;

public class skz
  extends uwu
{
  private skz(VideoFeedsRecommendFragment paramVideoFeedsRecommendFragment) {}
  
  protected void a(boolean paramBoolean, Bundle paramBundle)
  {
    VideoFeedsPlayActivity.a("onGetDianZanState isSuccess: " + paramBoolean);
    if ((!paramBoolean) || (paramBundle == null)) {}
    int i;
    do
    {
      String str;
      do
      {
        return;
        str = paramBundle.getString("VALUE_VIDEO_ARTICLE_ID");
        i = paramBundle.getInt("VALUE_VIDEO_FAVORITE_STATE");
      } while (str == null);
      paramBundle = VideoFeedsRecommendFragment.a(this.a).a(str);
    } while (paramBundle == null);
    if (i == 1) {
      paramBundle.r = true;
    }
    for (;;)
    {
      VideoFeedsRecommendFragment.a(this.a).a(paramBundle);
      return;
      if (i == 0) {
        paramBundle.r = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     skz
 * JD-Core Version:    0.7.0.1
 */