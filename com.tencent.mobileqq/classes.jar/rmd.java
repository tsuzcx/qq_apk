import android.provider.Settings.System;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

public class rmd
  implements Runnable
{
  public rmd(BaseChatPie paramBaseChatPie, int paramInt) {}
  
  public void run()
  {
    try
    {
      Settings.System.putInt(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.getApp().getContentResolver(), "listview_oversroll", this.jdField_a_of_type_Int);
      return;
    }
    catch (SecurityException localSecurityException)
    {
      localSecurityException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rmd
 * JD-Core Version:    0.7.0.1
 */