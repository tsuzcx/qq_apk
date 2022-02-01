import android.app.Activity;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import java.util.ArrayList;
import java.util.HashSet;

public class ooj
{
  public static HashSet<String> a = new HashSet();
  
  public static void a()
  {
    a.clear();
  }
  
  public static void a(int paramInt, seu paramseu)
  {
    if (paramseu == null) {}
    sey localsey;
    AdvertisementInfo localAdvertisementInfo;
    do
    {
      do
      {
        return;
        localsey = paramseu.a();
        paramseu = paramseu.a();
      } while ((paramseu == null) || (localsey == null) || (!(localsey.a instanceof AdvertisementInfo)));
      localAdvertisementInfo = (AdvertisementInfo)localsey.a;
    } while (paramInt < localAdvertisementInfo.mC2SReportTriggerTime / 1000);
    a(paramseu, localAdvertisementInfo, localsey);
  }
  
  public static boolean a(Activity paramActivity, AdvertisementInfo paramAdvertisementInfo, sey paramsey)
  {
    if ((paramsey == null) || (paramActivity == null) || (paramAdvertisementInfo == null)) {}
    while ((!(paramsey.a instanceof AdvertisementInfo)) || (!paramsey.b) || (a.contains(paramAdvertisementInfo.mAdTraceId)) || (paramAdvertisementInfo.mC2SVideoPlayUrl == null) || (paramAdvertisementInfo.mC2SVideoPlayUrl.size() <= 0)) {
      return false;
    }
    nxw.a(new omp().a(paramActivity).a(nxw.F).b(nxw.N).a(paramAdvertisementInfo).a());
    a.add(paramAdvertisementInfo.mAdTraceId);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ooj
 * JD-Core Version:    0.7.0.1
 */