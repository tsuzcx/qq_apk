import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecommendFragment;
import java.util.List;

public class rfy
  extends AnimatorListenerAdapter
{
  public rfy(VideoFeedsRecommendFragment paramVideoFeedsRecommendFragment, List paramList) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    paramAnimator = new Bundle();
    paramAnimator.putLong("ARGS_VIDEO_START_POSITION", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.a() + 300L);
    paramAnimator.putInt("VIDEO_FROM_TYPE", VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment));
    rcp.a().a(this.jdField_a_of_type_JavaUtilList, paramAnimator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rfy
 * JD-Core Version:    0.7.0.1
 */