import android.app.Activity;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import java.util.ArrayList;
import java.util.HashSet;

public class nzk
{
  public static HashSet<String> a = new HashSet();
  
  public static void a()
  {
    a.clear();
  }
  
  public static void a(int paramInt, qtu paramqtu)
  {
    if (paramqtu == null) {}
    qty localqty;
    AdvertisementInfo localAdvertisementInfo;
    do
    {
      do
      {
        return;
        localqty = paramqtu.a();
        paramqtu = paramqtu.a();
      } while ((paramqtu == null) || (localqty == null) || (!(localqty.a instanceof AdvertisementInfo)));
      localAdvertisementInfo = (AdvertisementInfo)localqty.a;
    } while (paramInt < localAdvertisementInfo.mC2SReportTriggerTime / 1000);
    a(paramqtu, localAdvertisementInfo, localqty);
  }
  
  public static boolean a(Activity paramActivity, AdvertisementInfo paramAdvertisementInfo, qty paramqty)
  {
    if ((paramqty == null) || (paramActivity == null) || (paramAdvertisementInfo == null)) {}
    while ((!(paramqty.a instanceof AdvertisementInfo)) || (!paramqty.b) || (a.contains(paramAdvertisementInfo.mAdTraceId)) || (paramAdvertisementInfo.mC2SVideoPlayUrl == null) || (paramAdvertisementInfo.mC2SVideoPlayUrl.size() <= 0)) {
      return false;
    }
    nmf.a(new nyg().a(paramActivity).a(nmf.E).b(nmf.L).a(paramAdvertisementInfo).a());
    a.add(paramAdvertisementInfo.mAdTraceId);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nzk
 * JD-Core Version:    0.7.0.1
 */