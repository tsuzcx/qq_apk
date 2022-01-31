import android.app.Activity;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import java.util.ArrayList;
import java.util.HashSet;

public class nzh
{
  public static HashSet<String> a = new HashSet();
  
  public static void a()
  {
    a.clear();
  }
  
  public static void a(int paramInt, qtr paramqtr)
  {
    if (paramqtr == null) {}
    qtv localqtv;
    AdvertisementInfo localAdvertisementInfo;
    do
    {
      do
      {
        return;
        localqtv = paramqtr.a();
        paramqtr = paramqtr.a();
      } while ((paramqtr == null) || (localqtv == null) || (!(localqtv.a instanceof AdvertisementInfo)));
      localAdvertisementInfo = (AdvertisementInfo)localqtv.a;
    } while (paramInt < localAdvertisementInfo.mC2SReportTriggerTime / 1000);
    a(paramqtr, localAdvertisementInfo, localqtv);
  }
  
  public static boolean a(Activity paramActivity, AdvertisementInfo paramAdvertisementInfo, qtv paramqtv)
  {
    if ((paramqtv == null) || (paramActivity == null) || (paramAdvertisementInfo == null)) {}
    while ((!(paramqtv.a instanceof AdvertisementInfo)) || (!paramqtv.b) || (a.contains(paramAdvertisementInfo.mAdTraceId)) || (paramAdvertisementInfo.mC2SVideoPlayUrl == null) || (paramAdvertisementInfo.mC2SVideoPlayUrl.size() <= 0)) {
      return false;
    }
    nmc.a(new nyd().a(paramActivity).a(nmc.E).b(nmc.L).a(paramAdvertisementInfo).a());
    a.add(paramAdvertisementInfo.mAdTraceId);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nzh
 * JD-Core Version:    0.7.0.1
 */