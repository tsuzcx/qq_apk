import android.content.Intent;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class mxi
{
  private ansi jdField_a_of_type_Ansi;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public mxi(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void a(boolean paramBoolean)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("tencent.video.q2v.avReceiveRealNameMsg");
    localIntent.putExtra("real_name_result", paramBoolean);
    localIntent.setPackage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getPackageName());
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().sendBroadcast(localIntent);
  }
  
  private boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("WTogetherRealNameMainProcessHelper", 2, "preCheckRealNameStatus");
    }
    if (this.jdField_a_of_type_Ansi != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("WTogetherRealNameMainProcessHelper", 2, "preCheckRealNameStatus remove observer");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ansi);
    }
    return ((ansg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CONFIG_HANDLER)).c();
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("WTogetherRealNameMainProcessHelper", 2, "startMonitorRealNameResult");
    }
    if (this.jdField_a_of_type_Ansi != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("WTogetherRealNameMainProcessHelper", 2, "monitorRealNameResult remove observer");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ansi);
      this.jdField_a_of_type_Ansi = null;
    }
    this.jdField_a_of_type_Ansi = new mxj(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ansi);
  }
  
  public boolean a(int paramInt)
  {
    boolean bool = false;
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      bool = a();
    }
    a();
    return bool;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Ansi != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ansi);
      this.jdField_a_of_type_Ansi = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mxi
 * JD-Core Version:    0.7.0.1
 */