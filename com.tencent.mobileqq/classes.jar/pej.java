import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData;

class pej
  implements ValueAnimator.AnimatorUpdateListener
{
  String jdField_a_of_type_JavaLangString = peh.a(this.jdField_a_of_type_Peh).a.commentId;
  
  pej(peh parampeh, View paramView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if ((peh.a(this.jdField_a_of_type_Peh) == null) || (peh.a(this.jdField_a_of_type_Peh).a == null) || (this.jdField_a_of_type_JavaLangString == null))
    {
      peh.a(this.jdField_a_of_type_Peh, this.jdField_a_of_type_AndroidViewView);
      return;
    }
    if (!this.jdField_a_of_type_JavaLangString.equals(peh.a(this.jdField_a_of_type_Peh).a.commentId))
    {
      peh.a(this.jdField_a_of_type_Peh, this.jdField_a_of_type_AndroidViewView);
      return;
    }
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    peh.a(this.jdField_a_of_type_Peh).setAlpha(i);
    this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(peh.a(this.jdField_a_of_type_Peh));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pej
 * JD-Core Version:    0.7.0.1
 */