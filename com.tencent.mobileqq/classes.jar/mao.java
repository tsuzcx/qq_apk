import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter.VideoItemHolder;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsGestureLayout;

public class mao
  extends AnimatorListenerAdapter
{
  public mao(VideoFeedsAdapter paramVideoFeedsAdapter, VideoFeedsAdapter.VideoItemHolder paramVideoItemHolder, ImageView paramImageView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter$VideoItemHolder.a.removeView(this.jdField_a_of_type_AndroidWidgetImageView);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    super.onAnimationStart(paramAnimator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mao
 * JD-Core Version:    0.7.0.1
 */