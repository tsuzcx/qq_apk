import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;

class ofg
  implements INetInfoHandler
{
  ofd a;
  
  public ofg(ofd paramofd1, ofd paramofd2)
  {
    this.a = paramofd2;
  }
  
  public void a()
  {
    this.a = null;
  }
  
  public void onNetMobile2None()
  {
    ofd.c("onNetMobile2None");
    if (this.a != null) {
      ofd.b(this.a);
    }
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    ofd.c("onNetMobile2Wifi");
    if (this.a != null) {
      ofd.b(this.a);
    }
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    ofd.c("onNetNone2Mobile");
    if (this.a != null) {
      ofd.b(this.a);
    }
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    ofd.c("onNetNone2Wifi");
    if (this.a != null) {
      ofd.b(this.a);
    }
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    ofd.c("onNetWifi2Mobile");
    if (this.a != null) {
      ofd.b(this.a);
    }
  }
  
  public void onNetWifi2None()
  {
    ofd.c("onNetWifi2None");
    if (this.a != null) {
      ofd.b(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ofg
 * JD-Core Version:    0.7.0.1
 */