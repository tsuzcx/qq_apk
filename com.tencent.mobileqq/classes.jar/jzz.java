import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.ui.QavVideoRecordUICtrl;

public class jzz
  implements ValueAnimator.AnimatorUpdateListener
{
  public jzz(QavVideoRecordUICtrl paramQavVideoRecordUICtrl, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f1 = paramValueAnimator.getAnimatedFraction();
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    QavVideoRecordUICtrl.a(this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl).setMargins((int)((1.0F - f1) * this.jdField_a_of_type_Int), 0, 0, 0);
    QavVideoRecordUICtrl.a(this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl).setLayoutParams(QavVideoRecordUICtrl.a(this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl));
    QavVideoRecordUICtrl.b(this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl).setMargins(this.b - (int)(this.jdField_a_of_type_Int * f1), 0, 0, 0);
    QavVideoRecordUICtrl.a(this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl).setLayoutParams(QavVideoRecordUICtrl.b(this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl));
    float f2;
    if (i <= 220)
    {
      f2 = i / 220.0F;
      QavVideoRecordUICtrl.a(this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl).setAlpha(f2);
    }
    QavVideoRecordUICtrl.c(this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl).setMargins(this.c + (int)(this.d * f1), 0, 0, 0);
    QavVideoRecordUICtrl.b(this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl).setLayoutParams(QavVideoRecordUICtrl.c(this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl));
    if (i <= 160)
    {
      f2 = i / 100.0F;
      QavVideoRecordUICtrl.b(this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl).setAlpha(f2);
    }
    QavVideoRecordUICtrl.d(this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl).setMargins((int)((this.e + 0) * f1) + 0, 0, 0, 0);
    QavVideoRecordUICtrl.d(this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl).width = (this.f - (int)((this.f - this.g) * f1));
    QavVideoRecordUICtrl.c(this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl).setLayoutParams(QavVideoRecordUICtrl.d(this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl));
    QavVideoRecordUICtrl.d(this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl).setAlpha(1.0F - f1);
    QavVideoRecordUICtrl.b(this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl).requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jzz
 * JD-Core Version:    0.7.0.1
 */