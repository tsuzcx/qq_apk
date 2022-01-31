import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;

class nji
  implements INetInfoHandler
{
  njf a;
  
  public nji(njf paramnjf1, njf paramnjf2)
  {
    this.a = paramnjf2;
  }
  
  public void a()
  {
    this.a = null;
  }
  
  public void onNetMobile2None()
  {
    njf.c("onNetMobile2None");
    if (this.a != null) {
      njf.b(this.a);
    }
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    njf.c("onNetMobile2Wifi");
    if (this.a != null) {
      njf.b(this.a);
    }
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    njf.c("onNetNone2Mobile");
    if (this.a != null) {
      njf.b(this.a);
    }
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    njf.c("onNetNone2Wifi");
    if (this.a != null) {
      njf.b(this.a);
    }
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    njf.c("onNetWifi2Mobile");
    if (this.a != null) {
      njf.b(this.a);
    }
  }
  
  public void onNetWifi2None()
  {
    njf.c("onNetWifi2None");
    if (this.a != null) {
      njf.b(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     nji
 * JD-Core Version:    0.7.0.1
 */