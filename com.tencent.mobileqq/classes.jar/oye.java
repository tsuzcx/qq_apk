import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData;

class oye
  implements ValueAnimator.AnimatorUpdateListener
{
  String jdField_a_of_type_JavaLangString = oyc.a(this.jdField_a_of_type_Oyc).a.commentId;
  
  oye(oyc paramoyc, View paramView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if ((oyc.a(this.jdField_a_of_type_Oyc) == null) || (oyc.a(this.jdField_a_of_type_Oyc).a == null) || (this.jdField_a_of_type_JavaLangString == null))
    {
      oyc.a(this.jdField_a_of_type_Oyc, this.jdField_a_of_type_AndroidViewView);
      return;
    }
    if (!this.jdField_a_of_type_JavaLangString.equals(oyc.a(this.jdField_a_of_type_Oyc).a.commentId))
    {
      oyc.a(this.jdField_a_of_type_Oyc, this.jdField_a_of_type_AndroidViewView);
      return;
    }
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    oyc.a(this.jdField_a_of_type_Oyc).setAlpha(i);
    this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(oyc.a(this.jdField_a_of_type_Oyc));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oye
 * JD-Core Version:    0.7.0.1
 */