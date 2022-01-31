import android.widget.TextView;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.smallscreen.PstnSmallScreenService;
import com.tencent.mobileqq.app.QQAppInterface;

public class jom
  implements Runnable
{
  public jom(PstnSmallScreenService paramPstnSmallScreenService) {}
  
  public void run()
  {
    if (this.a.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText(2131429559);
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().b = 2;
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e(true);
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jom
 * JD-Core Version:    0.7.0.1
 */