import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.ui.QavVideoRecordUICtrl;

public class kam
  implements ValueAnimator.AnimatorUpdateListener
{
  public kam(QavVideoRecordUICtrl paramQavVideoRecordUICtrl, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f1 = paramValueAnimator.getAnimatedFraction();
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    QavVideoRecordUICtrl.a(this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl).setMargins((int)(this.jdField_a_of_type_Int * f1), 0, 0, 0);
    QavVideoRecordUICtrl.a(this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl).setLayoutParams(QavVideoRecordUICtrl.a(this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl));
    if (i <= 180)
    {
      float f2 = i / 180.0F;
      QavVideoRecordUICtrl.a(this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl).setAlpha(1.0F - f2);
      QavVideoRecordUICtrl.b(this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl).setMargins(this.b + (int)(this.jdField_a_of_type_Int * f1), 0, 0, 0);
      QavVideoRecordUICtrl.a(this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl).setLayoutParams(QavVideoRecordUICtrl.b(this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl));
      QavVideoRecordUICtrl.c(this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl).setMargins(this.c - (int)(this.d * f1), 0, 0, 0);
      QavVideoRecordUICtrl.b(this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl).setLayoutParams(QavVideoRecordUICtrl.c(this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl));
      if (i >= 160)
      {
        f2 = (i - 160) / 100.0F;
        QavVideoRecordUICtrl.b(this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl).setAlpha(1.0F - f2);
      }
      QavVideoRecordUICtrl.d(this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl).setMargins(this.e - (int)((this.e + 0) * f1), 0, 0, 0);
      QavVideoRecordUICtrl.d(this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl).width = (this.f + (int)((this.g - this.f) * f1));
      QavVideoRecordUICtrl.c(this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl).setLayoutParams(QavVideoRecordUICtrl.d(this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl));
      QavVideoRecordUICtrl.d(this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl).setAlpha(f1);
      QavVideoRecordUICtrl.a(this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl).requestLayout();
      if ((QavVideoRecordUICtrl.a(this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl) != 90) && (QavVideoRecordUICtrl.a(this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl) != 270)) {
        break label413;
      }
      i = 1;
      label323:
      paramValueAnimator = QavVideoRecordUICtrl.e(this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl);
      if (i == 0) {
        break label419;
      }
    }
    label413:
    label419:
    for (i = QavVideoRecordUICtrl.a(this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl).getWidth();; i = -2)
    {
      paramValueAnimator.height = i;
      QavVideoRecordUICtrl.e(this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl).width = QavVideoRecordUICtrl.a(this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl).getWidth();
      QavVideoRecordUICtrl.b(this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl).requestLayout();
      return;
      if (QavVideoRecordUICtrl.a(this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl).getVisibility() != 0) {
        break;
      }
      QavVideoRecordUICtrl.a(this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl).setVisibility(8);
      break;
      i = 0;
      break label323;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kam
 * JD-Core Version:    0.7.0.1
 */