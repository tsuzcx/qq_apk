import android.content.res.Resources;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.ui.PSTNC2CActivity;
import com.tencent.av.utils.PSTNNotification;
import com.tencent.mobileqq.app.QQAppInterface;

public class jyw
  implements Runnable
{
  public jyw(PSTNC2CActivity paramPSTNC2CActivity) {}
  
  public void run()
  {
    this.a.c.setText(this.a.getResources().getString(2131429556));
    this.a.jdField_a_of_type_ComTencentAvUtilsPSTNNotification.a(1);
    this.a.a(this.a.b, false, 2130840119);
    this.a.b.setClickable(true);
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().b = 2;
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e(true);
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jyw
 * JD-Core Version:    0.7.0.1
 */