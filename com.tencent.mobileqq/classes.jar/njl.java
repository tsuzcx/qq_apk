import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;

class njl
  implements INetInfoHandler
{
  nji a;
  
  public njl(nji paramnji1, nji paramnji2)
  {
    this.a = paramnji2;
  }
  
  public void a()
  {
    this.a = null;
  }
  
  public void onNetMobile2None()
  {
    nji.c("onNetMobile2None");
    if (this.a != null) {
      nji.b(this.a);
    }
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    nji.c("onNetMobile2Wifi");
    if (this.a != null) {
      nji.b(this.a);
    }
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    nji.c("onNetNone2Mobile");
    if (this.a != null) {
      nji.b(this.a);
    }
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    nji.c("onNetNone2Wifi");
    if (this.a != null) {
      nji.b(this.a);
    }
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    nji.c("onNetWifi2Mobile");
    if (this.a != null) {
      nji.b(this.a);
    }
  }
  
  public void onNetWifi2None()
  {
    nji.c("onNetWifi2None");
    if (this.a != null) {
      nji.b(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     njl
 * JD-Core Version:    0.7.0.1
 */