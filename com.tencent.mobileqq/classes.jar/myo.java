import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.avgame.floatwindow.CommonGameFloatWindowLayout;

class myo
  implements ValueAnimator.AnimatorUpdateListener
{
  myo(myl parammyl, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (!myl.b(this.jdField_a_of_type_Myl))
    {
      paramValueAnimator.cancel();
      myl.a(this.jdField_a_of_type_Myl, null);
      return;
    }
    float f1 = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    int i = (int)(this.jdField_a_of_type_Int + (this.b - this.jdField_a_of_type_Int) * f1 + 0.5F);
    float f2 = this.c;
    int j = (int)(f1 * (this.d - this.c) + f2 + 0.5F);
    myl.a(this.jdField_a_of_type_Myl).a(i, j);
    myl.a(this.jdField_a_of_type_Myl).d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     myo
 * JD-Core Version:    0.7.0.1
 */