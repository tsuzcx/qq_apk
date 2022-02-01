import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.qphone.base.util.QLog;

public class ozg
  implements INetInfoHandler
{
  public void onNetMobile2None() {}
  
  public void onNetMobile2Wifi(String paramString)
  {
    QLog.d("KBPreDownloadUtils", 2, "[onNetMobile2Wifi] ");
    AppNetConnInfo.unregisterNetInfoHandler(oze.a());
    oze.a();
  }
  
  public void onNetNone2Mobile(String paramString) {}
  
  public void onNetNone2Wifi(String paramString)
  {
    QLog.d("KBPreDownloadUtils", 2, "[onNetNone2Wifi] ");
    AppNetConnInfo.unregisterNetInfoHandler(oze.a());
    oze.a();
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    QLog.i("KBPreDownloadUtils", 1, "[onNetWifi2Mobile] pause download");
    biby.a().a("101480433");
  }
  
  public void onNetWifi2None()
  {
    QLog.i("KBPreDownloadUtils", 1, "[onNetWifi2None] pause download");
    biby.a().a("101480433");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ozg
 * JD-Core Version:    0.7.0.1
 */