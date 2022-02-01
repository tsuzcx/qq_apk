import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentTopGestureLayout;

public class pbo
  implements ValueAnimator.AnimatorUpdateListener
{
  public pbo(ReadInJoyCommentTopGestureLayout paramReadInJoyCommentTopGestureLayout, ViewGroup.LayoutParams paramLayoutParams, View paramView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams.height = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pbo
 * JD-Core Version:    0.7.0.1
 */