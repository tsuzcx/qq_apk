import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData;

class phj
  implements ValueAnimator.AnimatorUpdateListener
{
  String jdField_a_of_type_JavaLangString = phh.a(this.jdField_a_of_type_Phh).a.commentId;
  
  phj(phh paramphh, View paramView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if ((phh.a(this.jdField_a_of_type_Phh) == null) || (phh.a(this.jdField_a_of_type_Phh).a == null) || (this.jdField_a_of_type_JavaLangString == null))
    {
      phh.a(this.jdField_a_of_type_Phh, this.jdField_a_of_type_AndroidViewView);
      return;
    }
    if (!this.jdField_a_of_type_JavaLangString.equals(phh.a(this.jdField_a_of_type_Phh).a.commentId))
    {
      phh.a(this.jdField_a_of_type_Phh, this.jdField_a_of_type_AndroidViewView);
      return;
    }
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    phh.a(this.jdField_a_of_type_Phh).setAlpha(i);
    this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(phh.a(this.jdField_a_of_type_Phh));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     phj
 * JD-Core Version:    0.7.0.1
 */