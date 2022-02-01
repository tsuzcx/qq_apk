import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData;

class oxb
  implements ValueAnimator.AnimatorUpdateListener
{
  String jdField_a_of_type_JavaLangString = owz.a(this.jdField_a_of_type_Owz).a.commentId;
  
  oxb(owz paramowz, View paramView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if ((owz.a(this.jdField_a_of_type_Owz) == null) || (owz.a(this.jdField_a_of_type_Owz).a == null) || (this.jdField_a_of_type_JavaLangString == null))
    {
      owz.a(this.jdField_a_of_type_Owz, this.jdField_a_of_type_AndroidViewView);
      return;
    }
    if (!this.jdField_a_of_type_JavaLangString.equals(owz.a(this.jdField_a_of_type_Owz).a.commentId))
    {
      owz.a(this.jdField_a_of_type_Owz, this.jdField_a_of_type_AndroidViewView);
      return;
    }
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    owz.a(this.jdField_a_of_type_Owz).setAlpha(i);
    this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(owz.a(this.jdField_a_of_type_Owz));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oxb
 * JD-Core Version:    0.7.0.1
 */