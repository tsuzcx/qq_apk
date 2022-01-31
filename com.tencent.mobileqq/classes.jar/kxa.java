import com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementVideoPreloadManager;
import com.tencent.qqlive.mediaplayer.api.TVK_ICacheMgr.IPreloadCallback;
import java.io.File;
import org.json.JSONObject;

public class kxa
  implements TVK_ICacheMgr.IPreloadCallback
{
  private kxa(AdvertisementVideoPreloadManager paramAdvertisementVideoPreloadManager) {}
  
  public void onPreLoadFailed(String paramString1, int paramInt, String paramString2)
  {
    synchronized (AdvertisementVideoPreloadManager.a(this.a))
    {
      AdvertisementVideoPreloadManager.c("onPreLoadFailed vid:" + paramString1 + ", i:" + paramInt + ", callbackMsg:" + paramString2);
      AdvertisementVideoPreloadManager.a(this.a, AdvertisementVideoPreloadManager.a(this.a));
      return;
    }
  }
  
  public void onPreLoadSucess(String paramString1, String paramString2)
  {
    synchronized (AdvertisementVideoPreloadManager.a(this.a))
    {
      AdvertisementVideoPreloadManager.c("onPreLoadSucess vid:" + paramString1 + ", detail:" + paramString2);
      try
      {
        paramString2 = new JSONObject(paramString2);
        long l1 = paramString2.optLong("fileSize");
        long l2 = paramString2.optLong("offset");
        if ((l1 > 0L) && (l2 > 0L) && (l2 >= l1))
        {
          paramString2 = new File(AdvertisementVideoPreloadManager.b(paramString1));
          if (paramString2.exists()) {
            paramString2.renameTo(new File(AdvertisementVideoPreloadManager.a(paramString1)));
          }
          AdvertisementVideoPreloadManager.a(this.a, AdvertisementVideoPreloadManager.a(this.a));
        }
      }
      catch (Exception paramString1)
      {
        label136:
        break label136;
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kxa
 * JD-Core Version:    0.7.0.1
 */