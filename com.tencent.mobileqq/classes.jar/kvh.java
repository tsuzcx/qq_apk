import com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementVideoPreloadManager;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;

public class kvh
  implements INetInfoHandler
{
  AdvertisementVideoPreloadManager a;
  
  public kvh(AdvertisementVideoPreloadManager paramAdvertisementVideoPreloadManager1, AdvertisementVideoPreloadManager paramAdvertisementVideoPreloadManager2)
  {
    this.a = paramAdvertisementVideoPreloadManager2;
  }
  
  public void a()
  {
    this.a = null;
  }
  
  public void onNetMobile2None()
  {
    AdvertisementVideoPreloadManager.c("onNetMobile2None");
    if (this.a != null) {
      AdvertisementVideoPreloadManager.b(this.a);
    }
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    AdvertisementVideoPreloadManager.c("onNetMobile2Wifi");
    if (this.a != null) {
      AdvertisementVideoPreloadManager.b(this.a);
    }
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    AdvertisementVideoPreloadManager.c("onNetNone2Mobile");
    if (this.a != null) {
      AdvertisementVideoPreloadManager.b(this.a);
    }
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    AdvertisementVideoPreloadManager.c("onNetNone2Wifi");
    if (this.a != null) {
      AdvertisementVideoPreloadManager.b(this.a);
    }
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    AdvertisementVideoPreloadManager.c("onNetWifi2Mobile");
    if (this.a != null) {
      AdvertisementVideoPreloadManager.b(this.a);
    }
  }
  
  public void onNetWifi2None()
  {
    AdvertisementVideoPreloadManager.c("onNetWifi2None");
    if (this.a != null) {
      AdvertisementVideoPreloadManager.b(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kvh
 * JD-Core Version:    0.7.0.1
 */