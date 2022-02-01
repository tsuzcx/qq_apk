import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.qphone.base.util.QLog;

class sae
  implements INetInfoHandler
{
  sae(sad paramsad) {}
  
  public void onNetMobile2None() {}
  
  public void onNetMobile2Wifi(String paramString) {}
  
  public void onNetNone2Mobile(String paramString)
  {
    QLog.i("RIJUGC.RIJUgcVideoPublishManager", 1, "onNetNone2Mobile");
    sad.a(this.a);
  }
  
  public void onNetNone2Wifi(String paramString) {}
  
  public void onNetWifi2Mobile(String paramString)
  {
    QLog.i("RIJUGC.RIJUgcVideoPublishManager", 1, "onNetWifi2Mobile");
    sad.a(this.a);
  }
  
  public void onNetWifi2None() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sae
 * JD-Core Version:    0.7.0.1
 */