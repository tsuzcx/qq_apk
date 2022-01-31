import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.ark.ReadInJoyArkUtil;
import com.tencent.mobileqq.ark.ArkLocalAppMgr;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.qphone.base.util.QLog;

public final class lgg
  implements Runnable
{
  public lgg(ArkAppMessage paramArkAppMessage, int paramInt) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataArkAppMessage != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataArkAppMessage.appName)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataArkAppMessage.appMinVersion))) {
      if (ReadInJoyArkUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataArkAppMessage)) {
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyArkUtil", 2, "arkApp exists, no need to download again.");
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      ArkLocalAppMgr localArkLocalAppMgr;
      do
      {
        return;
        localArkLocalAppMgr = ReadInJoyArkUtil.a();
      } while (localArkLocalAppMgr == null);
      localArkLocalAppMgr.a(this.jdField_a_of_type_ComTencentMobileqqDataArkAppMessage.appName, this.jdField_a_of_type_ComTencentMobileqqDataArkAppMessage.appMinVersion, "", new lgh(this));
      return;
    }
    QLog.d("ReadInJoyArkUtil", 2, "ArkAppMessage is invalid, preDownloadArkApp do not begin.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lgg
 * JD-Core Version:    0.7.0.1
 */