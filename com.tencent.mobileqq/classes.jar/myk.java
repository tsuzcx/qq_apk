import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;

class myk
  implements INetInfoHandler
{
  myh a;
  
  public myk(myh parammyh1, myh parammyh2)
  {
    this.a = parammyh2;
  }
  
  public void a()
  {
    this.a = null;
  }
  
  public void onNetMobile2None()
  {
    myh.c("onNetMobile2None");
    if (this.a != null) {
      myh.b(this.a);
    }
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    myh.c("onNetMobile2Wifi");
    if (this.a != null) {
      myh.b(this.a);
    }
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    myh.c("onNetNone2Mobile");
    if (this.a != null) {
      myh.b(this.a);
    }
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    myh.c("onNetNone2Wifi");
    if (this.a != null) {
      myh.b(this.a);
    }
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    myh.c("onNetWifi2Mobile");
    if (this.a != null) {
      myh.b(this.a);
    }
  }
  
  public void onNetWifi2None()
  {
    myh.c("onNetWifi2None");
    if (this.a != null) {
      myh.b(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     myk
 * JD-Core Version:    0.7.0.1
 */