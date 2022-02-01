import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.avgame.floatwindow.CommonGameFloatWindowLayout;

class mxe
  implements ValueAnimator.AnimatorUpdateListener
{
  mxe(mxb parammxb, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (!mxb.b(this.jdField_a_of_type_Mxb))
    {
      paramValueAnimator.cancel();
      mxb.a(this.jdField_a_of_type_Mxb, null);
      return;
    }
    float f1 = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    int i = (int)(this.jdField_a_of_type_Int + (this.b - this.jdField_a_of_type_Int) * f1 + 0.5F);
    float f2 = this.c;
    int j = (int)(f1 * (this.d - this.c) + f2 + 0.5F);
    mxb.a(this.jdField_a_of_type_Mxb).a(i, j);
    mxb.a(this.jdField_a_of_type_Mxb).d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mxe
 * JD-Core Version:    0.7.0.1
 */