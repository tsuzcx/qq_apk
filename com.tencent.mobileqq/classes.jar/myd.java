import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.avgame.floatwindow.CommonGameFloatWindowLayout;

class myd
  implements ValueAnimator.AnimatorUpdateListener
{
  myd(mya parammya, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (!mya.b(this.jdField_a_of_type_Mya))
    {
      paramValueAnimator.cancel();
      mya.a(this.jdField_a_of_type_Mya, null);
      return;
    }
    float f1 = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    int i = (int)(this.jdField_a_of_type_Int + (this.b - this.jdField_a_of_type_Int) * f1 + 0.5F);
    float f2 = this.c;
    int j = (int)(f1 * (this.d - this.c) + f2 + 0.5F);
    mya.a(this.jdField_a_of_type_Mya).a(i, j);
    mya.a(this.jdField_a_of_type_Mya).d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     myd
 * JD-Core Version:    0.7.0.1
 */