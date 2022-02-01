import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;

class nvb
  implements INetInfoHandler
{
  nuy a;
  
  public nvb(nuy paramnuy1, nuy paramnuy2)
  {
    this.a = paramnuy2;
  }
  
  public void a()
  {
    this.a = null;
  }
  
  public void onNetMobile2None()
  {
    nuy.c("onNetMobile2None");
    if (this.a != null) {
      nuy.b(this.a);
    }
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    nuy.c("onNetMobile2Wifi");
    if (this.a != null) {
      nuy.b(this.a);
    }
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    nuy.c("onNetNone2Mobile");
    if (this.a != null) {
      nuy.b(this.a);
    }
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    nuy.c("onNetNone2Wifi");
    if (this.a != null) {
      nuy.b(this.a);
    }
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    nuy.c("onNetWifi2Mobile");
    if (this.a != null) {
      nuy.b(this.a);
    }
  }
  
  public void onNetWifi2None()
  {
    nuy.c("onNetWifi2None");
    if (this.a != null) {
      nuy.b(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nvb
 * JD-Core Version:    0.7.0.1
 */