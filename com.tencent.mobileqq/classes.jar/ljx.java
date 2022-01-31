import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentTopGestureLayout;

public class ljx
  implements ValueAnimator.AnimatorUpdateListener
{
  public ljx(ReadInJoyCommentTopGestureLayout paramReadInJoyCommentTopGestureLayout, ViewGroup.LayoutParams paramLayoutParams) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams.height = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    ReadInJoyCommentTopGestureLayout.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout).setLayoutParams(this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ljx
 * JD-Core Version:    0.7.0.1
 */