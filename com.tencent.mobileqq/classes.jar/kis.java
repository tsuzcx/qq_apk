import android.text.TextUtils;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.TicketManager;

public class kis
  implements Runnable
{
  public kis(AuthorizeConfig paramAuthorizeConfig, TicketManager paramTicketManager, String paramString, String[] paramArrayOfString) {}
  
  public void run()
  {
    try
    {
      if (this.jdField_a_of_type_MqqManagerTicketManager != null) {
        if ((this.jdField_a_of_type_MqqManagerTicketManager.GetPskey(this.jdField_a_of_type_JavaLangString, 16L, this.jdField_a_of_type_ArrayOfJavaLangString, null) == null) || (TextUtils.isEmpty(this.jdField_a_of_type_MqqManagerTicketManager.getSkey(this.jdField_a_of_type_JavaLangString)))) {
          break label78;
        }
      }
      label78:
      for (boolean bool = true;; bool = false)
      {
        QLog.d("AuthorizeConfig", 1, "pre hits result : " + bool);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("AuthorizeConfig", 1, "preload k exception ");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kis
 * JD-Core Version:    0.7.0.1
 */