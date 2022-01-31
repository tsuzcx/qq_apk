import android.app.Activity;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.video.ADVideoAppDownloadManager;

public class nzs
{
  public static void a(Activity paramActivity, int paramInt, VideoInfo paramVideoInfo)
  {
    if (paramVideoInfo == null) {
      return;
    }
    AdvertisementInfo localAdvertisementInfo = nmf.a(paramVideoInfo.a);
    if (paramVideoInfo.a(paramActivity))
    {
      nmf.a(new nyg().a(paramActivity).a(nmf.a).b(nmf.P).a(localAdvertisementInfo).a(paramVideoInfo.a).d(paramInt).a());
      return;
    }
    nmf.a(new nyg().a(paramActivity).a(nmf.a).b(nmf.N).a(localAdvertisementInfo).a(paramVideoInfo.a).d(paramInt).a());
  }
  
  public static void a(Activity paramActivity, int paramInt, VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo, ADVideoAppDownloadManager paramADVideoAppDownloadManager)
  {
    if (paramVideoInfo.c)
    {
      if (!paramADVideoAppDownloadManager.a(paramVideoInfo)) {
        break label33;
      }
      sht.b(paramActivity, paramAdvertisementInfo, null, 3, true, null);
    }
    for (;;)
    {
      a(paramActivity, paramInt, paramVideoInfo);
      return;
      label33:
      if (paramAdvertisementInfo != null) {
        paramAdvertisementInfo.setClickPos(paramInt);
      }
      paramADVideoAppDownloadManager = new nyc();
      paramADVideoAppDownloadManager.c = true;
      sht.b(paramActivity, paramAdvertisementInfo, null, 3, true, paramADVideoAppDownloadManager);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nzs
 * JD-Core Version:    0.7.0.1
 */