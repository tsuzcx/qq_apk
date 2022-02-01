import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;

class nwv
  implements INetInfoHandler
{
  nws a;
  
  public nwv(nws paramnws1, nws paramnws2)
  {
    this.a = paramnws2;
  }
  
  public void a()
  {
    this.a = null;
  }
  
  public void onNetMobile2None()
  {
    nws.c("onNetMobile2None");
    if (this.a != null) {
      nws.b(this.a);
    }
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    nws.c("onNetMobile2Wifi");
    if (this.a != null) {
      nws.b(this.a);
    }
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    nws.c("onNetNone2Mobile");
    if (this.a != null) {
      nws.b(this.a);
    }
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    nws.c("onNetNone2Wifi");
    if (this.a != null) {
      nws.b(this.a);
    }
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    nws.c("onNetWifi2Mobile");
    if (this.a != null) {
      nws.b(this.a);
    }
  }
  
  public void onNetWifi2None()
  {
    nws.c("onNetWifi2None");
    if (this.a != null) {
      nws.b(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nwv
 * JD-Core Version:    0.7.0.1
 */