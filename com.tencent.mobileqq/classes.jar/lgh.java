import com.tencent.biz.pubaccount.readinjoy.ark.ReadInJoyArkUtil;
import com.tencent.mobileqq.ark.ArkAppInfo.AppDesc;
import com.tencent.mobileqq.ark.ArkLocalAppMgr.AppPathInfo;
import com.tencent.mobileqq.ark.ArkLocalAppMgr.IGetAppPathByNameCallback;
import com.tencent.qphone.base.util.QLog;

class lgh
  implements ArkLocalAppMgr.IGetAppPathByNameCallback
{
  lgh(lgg paramlgg) {}
  
  public void a(int paramInt, String paramString, ArkLocalAppMgr.AppPathInfo paramAppPathInfo, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyArkUtil", 2, new Object[] { "retCode: ", Integer.valueOf(paramInt), ", msg: ", paramString });
    }
    if ((paramAppPathInfo != null) && (paramInt == 0))
    {
      paramString = paramAppPathInfo.jdField_a_of_type_ComTencentMobileqqArkArkAppInfo$AppDesc;
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyArkUtil", 2, new Object[] { "preDownloadArkApp succeed, appPath: ", paramAppPathInfo.jdField_a_of_type_JavaLangString, ", appName: ", paramString.jdField_a_of_type_JavaLangString, ", appVersion: ", paramString.b });
      }
      ReadInJoyArkUtil.a(new lgi(this, paramString), 5);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyArkUtil", 2, new Object[] { "preDownloadArkApp appPath is null or downloadFailed, retryTimes: ", Integer.valueOf(this.a.jdField_a_of_type_Int) });
    }
    ReadInJoyArkUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqDataArkAppMessage, this.a.jdField_a_of_type_Int + 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lgh
 * JD-Core Version:    0.7.0.1
 */