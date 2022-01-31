import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;

class nme
  implements INetInfoHandler
{
  nmb a;
  
  public nme(nmb paramnmb1, nmb paramnmb2)
  {
    this.a = paramnmb2;
  }
  
  public void a()
  {
    this.a = null;
  }
  
  public void onNetMobile2None()
  {
    nmb.c("onNetMobile2None");
    if (this.a != null) {
      nmb.b(this.a);
    }
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    nmb.c("onNetMobile2Wifi");
    if (this.a != null) {
      nmb.b(this.a);
    }
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    nmb.c("onNetNone2Mobile");
    if (this.a != null) {
      nmb.b(this.a);
    }
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    nmb.c("onNetNone2Wifi");
    if (this.a != null) {
      nmb.b(this.a);
    }
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    nmb.c("onNetWifi2Mobile");
    if (this.a != null) {
      nmb.b(this.a);
    }
  }
  
  public void onNetWifi2None()
  {
    nmb.c("onNetWifi2None");
    if (this.a != null) {
      nmb.b(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nme
 * JD-Core Version:    0.7.0.1
 */