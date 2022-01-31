import android.os.Handler;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.smallscreen.SmallScreenVideoControlUI;
import com.tencent.av.utils.UITools;

public class jpi
  implements Runnable
{
  public jpi(SmallScreenVideoControlUI paramSmallScreenVideoControlUI) {}
  
  public void run()
  {
    if ((this.a.jdField_a_of_type_ComTencentAvVideoController != null) && (this.a.jdField_b_of_type_Boolean))
    {
      long l = this.a.jdField_a_of_type_ComTencentAvVideoController.a();
      if ((this.a.jdField_b_of_type_JavaLangString == null) || (l != 0L))
      {
        this.a.jdField_b_of_type_JavaLangString = UITools.a(l);
        if ((this.a.jdField_a_of_type_AndroidWidgetTextView != null) && (!this.a.c))
        {
          this.a.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(UITools.a(this.a.jdField_b_of_type_JavaLangString));
          this.a.jdField_a_of_type_AndroidWidgetTextView.setText(this.a.jdField_b_of_type_JavaLangString);
        }
      }
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this, 1000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jpi
 * JD-Core Version:    0.7.0.1
 */