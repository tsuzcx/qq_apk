import android.app.Activity;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.video.ADVideoAppDownloadManager;

public class ocz
{
  public static void a(Activity paramActivity, int paramInt, VideoInfo paramVideoInfo)
  {
    if (paramVideoInfo == null) {
      return;
    }
    AdvertisementInfo localAdvertisementInfo = noy.a(paramVideoInfo.a);
    if (paramVideoInfo.a(paramActivity))
    {
      noy.a(new obk().a(paramActivity).a(noy.a).b(noy.P).a(localAdvertisementInfo).a(paramVideoInfo.a).d(paramInt).a());
      return;
    }
    noy.a(new obk().a(paramActivity).a(noy.a).b(noy.N).a(localAdvertisementInfo).a(paramVideoInfo.a).d(paramInt).a());
  }
  
  public static void a(Activity paramActivity, int paramInt, VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo, ADVideoAppDownloadManager paramADVideoAppDownloadManager)
  {
    if (paramVideoInfo.c)
    {
      if (!paramADVideoAppDownloadManager.a(paramVideoInfo)) {
        break label33;
      }
      szl.b(paramActivity, paramAdvertisementInfo, null, 3, true, null);
    }
    for (;;)
    {
      a(paramActivity, paramInt, paramVideoInfo);
      return;
      label33:
      if (paramAdvertisementInfo != null) {
        paramAdvertisementInfo.setClickPos(paramInt);
      }
      paramADVideoAppDownloadManager = new obg();
      paramADVideoAppDownloadManager.c = true;
      szl.b(paramActivity, paramAdvertisementInfo, null, 3, true, paramADVideoAppDownloadManager);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ocz
 * JD-Core Version:    0.7.0.1
 */