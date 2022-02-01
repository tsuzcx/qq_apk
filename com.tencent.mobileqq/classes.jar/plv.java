import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.mobileqq.mini.notify.MiniAppNotify.IMiniAppNotifyListener;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.List;

public class plv
  implements MiniAppNotify.IMiniAppNotifyListener
{
  public plv(KandianMergeManager paramKandianMergeManager) {}
  
  public void onNotify(String paramString1, int paramInt, String paramString2, String paramString3, long paramLong)
  {
    QLog.d("KandianMergeManager", 1, "appid: " + paramString1 + " scene: " + paramInt + " via: " + paramString2 + " event: " + paramString3 + " timestamp: " + paramLong);
    paramString1 = Arrays.asList(Aladdin.getConfig(329).getString("scene", "").split("\\|"));
    List localList = Arrays.asList(Aladdin.getConfig(329).getString("via", "").split("\\|"));
    QLog.d("KandianMergeManager", 1, "miniapp config: " + paramString1 + " " + localList);
    if ("onResume".equals(paramString3)) {
      if ((paramString1 != null) && (paramString1.contains(paramInt + "")) && (localList != null) && (localList.contains(paramString2)))
      {
        paramInt = pha.e();
        i = pha.d;
        KandianMergeManager.a(this.a).a(KandianMergeManager.a(this.a), NetConnInfoCenter.getServerTimeMillis(), paramInt, i);
      }
    }
    while ((!"onPause".equals(paramString3)) || (paramString1 == null) || (!paramString1.contains(paramInt + "")) || (localList == null) || (!localList.contains(paramString2)) || (KandianMergeManager.a(this.a).a() <= 0L))
    {
      int i;
      return;
    }
    KandianMergeManager.a(this.a).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     plv
 * JD-Core Version:    0.7.0.1
 */