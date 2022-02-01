import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;

class nyg
  implements INetInfoHandler
{
  nyd a;
  
  public nyg(nyd paramnyd1, nyd paramnyd2)
  {
    this.a = paramnyd2;
  }
  
  public void a()
  {
    this.a = null;
  }
  
  public void onNetMobile2None()
  {
    nyd.c("onNetMobile2None");
    if (this.a != null) {
      nyd.b(this.a);
    }
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    nyd.c("onNetMobile2Wifi");
    if (this.a != null) {
      nyd.b(this.a);
    }
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    nyd.c("onNetNone2Mobile");
    if (this.a != null) {
      nyd.b(this.a);
    }
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    nyd.c("onNetNone2Wifi");
    if (this.a != null) {
      nyd.b(this.a);
    }
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    nyd.c("onNetWifi2Mobile");
    if (this.a != null) {
      nyd.b(this.a);
    }
  }
  
  public void onNetWifi2None()
  {
    nyd.c("onNetWifi2None");
    if (this.a != null) {
      nyd.b(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nyg
 * JD-Core Version:    0.7.0.1
 */