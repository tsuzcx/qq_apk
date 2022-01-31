import android.app.Activity;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.video.ADVideoAppDownloadManager;

public class nzp
{
  public static void a(Activity paramActivity, int paramInt, VideoInfo paramVideoInfo)
  {
    if (paramVideoInfo == null) {
      return;
    }
    AdvertisementInfo localAdvertisementInfo = nmc.a(paramVideoInfo.a);
    if (paramVideoInfo.a(paramActivity))
    {
      nmc.a(new nyd().a(paramActivity).a(nmc.a).b(nmc.P).a(localAdvertisementInfo).a(paramVideoInfo.a).d(paramInt).a());
      return;
    }
    nmc.a(new nyd().a(paramActivity).a(nmc.a).b(nmc.N).a(localAdvertisementInfo).a(paramVideoInfo.a).d(paramInt).a());
  }
  
  public static void a(Activity paramActivity, int paramInt, VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo, ADVideoAppDownloadManager paramADVideoAppDownloadManager)
  {
    if (paramVideoInfo.c)
    {
      if (!paramADVideoAppDownloadManager.a(paramVideoInfo)) {
        break label33;
      }
      shq.b(paramActivity, paramAdvertisementInfo, null, 3, true, null);
    }
    for (;;)
    {
      a(paramActivity, paramInt, paramVideoInfo);
      return;
      label33:
      if (paramAdvertisementInfo != null) {
        paramAdvertisementInfo.setClickPos(paramInt);
      }
      paramADVideoAppDownloadManager = new nxz();
      paramADVideoAppDownloadManager.c = true;
      shq.b(paramActivity, paramAdvertisementInfo, null, 3, true, paramADVideoAppDownloadManager);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nzp
 * JD-Core Version:    0.7.0.1
 */