import android.app.Activity;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import java.util.ArrayList;
import java.util.HashSet;

public class nnz
{
  public static HashSet<String> a = new HashSet();
  
  public static void a()
  {
    a.clear();
  }
  
  public static void a(int paramInt, qhp paramqhp)
  {
    if (paramqhp == null) {}
    qht localqht;
    AdvertisementInfo localAdvertisementInfo;
    do
    {
      do
      {
        return;
        localqht = paramqhp.a();
        paramqhp = paramqhp.a();
      } while ((paramqhp == null) || (localqht == null) || (!(localqht.a instanceof AdvertisementInfo)));
      localAdvertisementInfo = (AdvertisementInfo)localqht.a;
    } while (paramInt < localAdvertisementInfo.mC2SReportTriggerTime / 1000);
    a(paramqhp, localAdvertisementInfo, localqht);
  }
  
  public static boolean a(Activity paramActivity, AdvertisementInfo paramAdvertisementInfo, qht paramqht)
  {
    if ((paramqht == null) || (paramActivity == null) || (paramAdvertisementInfo == null)) {}
    while ((!(paramqht.a instanceof AdvertisementInfo)) || (!paramqht.b) || (a.contains(paramAdvertisementInfo.mAdTraceId)) || (paramAdvertisementInfo.mC2SVideoPlayUrl == null) || (paramAdvertisementInfo.mC2SVideoPlayUrl.size() <= 0)) {
      return false;
    }
    nbe.a(new nmv().a(paramActivity).a(nbe.E).b(nbe.L).a(paramAdvertisementInfo).a());
    a.add(paramAdvertisementInfo.mAdTraceId);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nnz
 * JD-Core Version:    0.7.0.1
 */