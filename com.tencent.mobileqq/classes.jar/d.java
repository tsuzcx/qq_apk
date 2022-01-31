import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.etrump.mixlayout.ETFont;
import com.etrump.mixlayout.ETTextView;

class d
  implements ValueAnimator.AnimatorUpdateListener
{
  d(c paramc) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    if (i >= this.a.i[0])
    {
      this.a.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      this.a.e = 0;
      this.a.jdField_a_of_type_ComEtrumpMixlayoutETFont.mShouldDisplayAnimation = false;
      c.a(this.a).invalidate();
      if (c.a(this.a).jdField_a_of_type_Fs != null) {
        c.a(this.a).jdField_a_of_type_Fs.a(c.a(this.a).jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.a.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId);
      }
    }
    while (i <= this.a.e) {
      return;
    }
    this.a.e = i;
    c.a(this.a).invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     d
 * JD-Core Version:    0.7.0.1
 */