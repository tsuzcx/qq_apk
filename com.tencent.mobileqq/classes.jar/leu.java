import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.qphone.base.util.QLog;

public class leu
  implements INetInfoHandler
{
  private lev a;
  
  public leu(lev paramlev)
  {
    this.a = paramlev;
  }
  
  public static int a()
  {
    int j = 1;
    int i;
    if (AppNetConnInfo.isWifiConn()) {
      i = 1;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSFNetInfoMonitor", 2, "getApn: " + i + " mobileType:" + j);
      }
      return i;
      if (AppNetConnInfo.isMobileConn())
      {
        j = AppNetConnInfo.getMobileInfo();
        switch (j)
        {
        default: 
          i = 100;
          break;
        case 1: 
          i = 3;
          break;
        case 2: 
          i = 9;
          break;
        case 3: 
          i = 11;
          break;
        case 4: 
          i = 14;
          break;
        }
      }
      else
      {
        j = -1;
        i = 0;
      }
    }
  }
  
  public static int b()
  {
    int i = -1;
    if (AppNetConnInfo.isWifiConn()) {
      i = 1;
    }
    while (!AppNetConnInfo.isMobileConn()) {
      return i;
    }
    return AppNetConnInfo.getMobileInfo();
  }
  
  public void onNetMobile2None()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSFNetInfoMonitor", 2, "Net Change: onNetMobile2None");
    }
    if (this.a != null) {
      this.a.a(0);
    }
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSFNetInfoMonitor", 2, "Net Change: onNetMobile2Wifi");
    }
    if (this.a != null) {
      this.a.a(1);
    }
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSFNetInfoMonitor", 2, "Net Change: onNetNone2Mobile");
    }
    if (this.a != null) {
      this.a.a(2);
    }
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSFNetInfoMonitor", 2, "Net Change: onNetNone2Wifi");
    }
    if (this.a != null) {
      this.a.a(1);
    }
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSFNetInfoMonitor", 2, "Net Change: onNetWifi2Mobile");
    }
    if (this.a != null) {
      this.a.a(2);
    }
  }
  
  public void onNetWifi2None()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSFNetInfoMonitor", 2, "Net Change: onNetWifi2None");
    }
    if (this.a != null) {
      this.a.a(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     leu
 * JD-Core Version:    0.7.0.1
 */