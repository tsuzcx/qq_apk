import android.app.Activity;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import java.util.ArrayList;
import java.util.HashSet;

public class ocr
{
  public static HashSet<String> a = new HashSet();
  
  public static void a()
  {
    a.clear();
  }
  
  public static void a(int paramInt, rjg paramrjg)
  {
    if (paramrjg == null) {}
    rjk localrjk;
    AdvertisementInfo localAdvertisementInfo;
    do
    {
      do
      {
        return;
        localrjk = paramrjg.a();
        paramrjg = paramrjg.a();
      } while ((paramrjg == null) || (localrjk == null) || (!(localrjk.a instanceof AdvertisementInfo)));
      localAdvertisementInfo = (AdvertisementInfo)localrjk.a;
    } while (paramInt < localAdvertisementInfo.mC2SReportTriggerTime / 1000);
    a(paramrjg, localAdvertisementInfo, localrjk);
  }
  
  public static boolean a(Activity paramActivity, AdvertisementInfo paramAdvertisementInfo, rjk paramrjk)
  {
    if ((paramrjk == null) || (paramActivity == null) || (paramAdvertisementInfo == null)) {}
    while ((!(paramrjk.a instanceof AdvertisementInfo)) || (!paramrjk.b) || (a.contains(paramAdvertisementInfo.mAdTraceId)) || (paramAdvertisementInfo.mC2SVideoPlayUrl == null) || (paramAdvertisementInfo.mC2SVideoPlayUrl.size() <= 0)) {
      return false;
    }
    noy.a(new obk().a(paramActivity).a(noy.E).b(noy.L).a(paramAdvertisementInfo).a());
    a.add(paramAdvertisementInfo.mAdTraceId);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ocr
 * JD-Core Version:    0.7.0.1
 */