import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Point;
import android.view.WindowManager.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsFloatWindowDragLayout;

public class qbm
  implements ValueAnimator.AnimatorUpdateListener
{
  public qbm(VideoFeedsFloatWindowDragLayout paramVideoFeedsFloatWindowDragLayout, int paramInt1, int paramInt2) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    WindowManager.LayoutParams localLayoutParams = (WindowManager.LayoutParams)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsFloatWindowDragLayout.getLayoutParams();
    int i = this.jdField_a_of_type_Int;
    localLayoutParams.x = (((Point)paramValueAnimator.getAnimatedValue()).x + i);
    i = this.b;
    localLayoutParams.y = (((Point)paramValueAnimator.getAnimatedValue()).y + i);
    if (VideoFeedsFloatWindowDragLayout.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsFloatWindowDragLayout) != null) {
      VideoFeedsFloatWindowDragLayout.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsFloatWindowDragLayout).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qbm
 * JD-Core Version:    0.7.0.1
 */