import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.qphone.base.util.QLog;

public class ops
  implements INetInfoHandler
{
  public void onNetMobile2None() {}
  
  public void onNetMobile2Wifi(String paramString)
  {
    QLog.d("KBPreDownloadUtils", 2, "[onNetMobile2Wifi] ");
    AppNetConnInfo.unregisterNetInfoHandler(opq.a());
    opq.a();
  }
  
  public void onNetNone2Mobile(String paramString) {}
  
  public void onNetNone2Wifi(String paramString)
  {
    QLog.d("KBPreDownloadUtils", 2, "[onNetNone2Wifi] ");
    AppNetConnInfo.unregisterNetInfoHandler(opq.a());
    opq.a();
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    QLog.i("KBPreDownloadUtils", 1, "[onNetWifi2Mobile] pause download");
    bfok.a().a("101480433");
  }
  
  public void onNetWifi2None()
  {
    QLog.i("KBPreDownloadUtils", 1, "[onNetWifi2None] pause download");
    bfok.a().a("101480433");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ops
 * JD-Core Version:    0.7.0.1
 */