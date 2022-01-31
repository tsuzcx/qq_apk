import com.tencent.biz.pubaccount.NativeAd.module.AdModuleBase;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.qphone.base.util.QLog;

public class kxe
  implements INetInfoHandler
{
  public kxe(AdModuleBase paramAdModuleBase) {}
  
  public void onNetMobile2None()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdModuleBase", 2, "onNetMobile2None");
    }
    AdModuleBase.b(this.a);
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdModuleBase", 2, "onNetMobile2Wifi");
    }
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdModuleBase", 2, "onNetNone2Mobile");
    }
    AdModuleBase.b(this.a);
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdModuleBase", 2, "onNetNone2Wifi");
    }
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdModuleBase", 2, "onNetWifi2Mobile");
    }
    AdModuleBase.b(this.a);
  }
  
  public void onNetWifi2None()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdModuleBase", 2, "onNetWifi2None");
    }
    AdModuleBase.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kxe
 * JD-Core Version:    0.7.0.1
 */