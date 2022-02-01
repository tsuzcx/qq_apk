import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.av.ui.QavPanel;

public class mia
  implements ValueAnimator.AnimatorUpdateListener
{
  public mia(QavPanel paramQavPanel, int[] paramArrayOfInt) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    if ((i >= 0) && (i <= this.jdField_a_of_type_ArrayOfInt[0]))
    {
      j = this.jdField_a_of_type_ArrayOfInt[0];
      i = (int)(i * 255 * 1.0F / j);
      QavPanel.a(this.jdField_a_of_type_ComTencentAvUiQavPanel).setAlpha(i);
      QavPanel.a(this.jdField_a_of_type_ComTencentAvUiQavPanel).a(true);
    }
    do
    {
      return;
      if ((i > this.jdField_a_of_type_ArrayOfInt[0]) && (i <= this.jdField_a_of_type_ArrayOfInt[1]))
      {
        QavPanel.a(this.jdField_a_of_type_ComTencentAvUiQavPanel).a(true);
        QavPanel.a(this.jdField_a_of_type_ComTencentAvUiQavPanel).setAlpha(255);
        return;
      }
    } while ((i <= this.jdField_a_of_type_ArrayOfInt[1]) || (i > this.jdField_a_of_type_ArrayOfInt[2]));
    int j = this.jdField_a_of_type_ArrayOfInt[2];
    int k = this.jdField_a_of_type_ArrayOfInt[1];
    i = (int)((this.jdField_a_of_type_ArrayOfInt[2] - i) * 255 * 1.0F / (j - k));
    QavPanel.a(this.jdField_a_of_type_ComTencentAvUiQavPanel).setAlpha(i);
    QavPanel.a(this.jdField_a_of_type_ComTencentAvUiQavPanel).a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mia
 * JD-Core Version:    0.7.0.1
 */