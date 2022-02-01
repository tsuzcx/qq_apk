import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;

public class srr
{
  private static srr a;
  
  private int a(String paramString)
  {
    return Math.round(((Float)bmhv.a(a(paramString), Float.valueOf(0.0F))).floatValue());
  }
  
  private String a(String paramString)
  {
    return paramString + "_watch_length";
  }
  
  public static srr a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new srr();
      }
      return a;
    }
    finally {}
  }
  
  private boolean a(String paramString)
  {
    return Aladdin.getConfig(298).getIntegerFromString(paramString, 0) == 1;
  }
  
  public int a()
  {
    return 1;
  }
  
  public int a(String paramString, int paramInt)
  {
    int k = a(paramString);
    int j = Aladdin.getConfig(298).getIntegerFromString("default_predownload_count", 4);
    int m = Aladdin.getConfig(298).getIntegerFromString("max_predownload_count", 4);
    if (QLog.isColorLevel()) {
      QLog.d("VideoPreloadStrategyConoller", 2, "getForwardPredownloadCount: enable:true, prediction=" + k + ", curPosition=" + paramInt + ", maxPreloadCount = " + m + ", defaultPreloadCount=" + j);
    }
    int i = j;
    if (k > paramInt)
    {
      i = j;
      if (a("watch_length_predict_enable")) {
        i = Math.min(k - paramInt, m);
      }
    }
    return i;
  }
  
  public void a(String paramString, int paramInt)
  {
    float f = ((Float)bmhv.a(a(paramString), Float.valueOf(0.0F))).floatValue();
    if (f > 0.0F) {}
    for (f = f * 0.5F + paramInt * 0.5F;; f = paramInt)
    {
      bmhv.a(paramString + "_watch_length", Float.valueOf(f));
      if (QLog.isColorLevel()) {
        QLog.d("VideoPreloadStrategyConoller", 2, "reoprt: currentPredition=" + f);
      }
      return;
    }
  }
  
  public boolean a(int paramInt)
  {
    long l1 = srh.a().a();
    float f = Aladdin.getConfig(298).getFloatFromString("bitrate_weight", 2.0F);
    int i = Aladdin.getConfig(298).getIntegerFromString("idle_bandwith_threshold", 1500);
    long l2 = ((float)l1 - paramInt / 8 * f);
    if (QLog.isColorLevel()) {
      QLog.d("VideoPreloadStrategyConoller", 2, "checkPreloadEnable: bandwidth=" + l1 + ", birate=" + paramInt + ", weight=" + f + ", idleBandwidth=" + l2 + ", idleThreshold=" + i + ", enable=" + a("idle_preload_limit_enable"));
    }
    if ((l1 <= 50L) || (paramInt <= 0) || (!a("idle_preload_limit_enable"))) {
      return NetworkUtil.isWifiConnected(BaseApplicationImpl.getContext());
    }
    return l2 > i;
  }
  
  public boolean a(spn paramspn)
  {
    int j = 0;
    int i = j;
    if (paramspn != null)
    {
      i = j;
      if (paramspn.b() > 0L) {
        i = paramspn.a;
      }
    }
    return a(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     srr
 * JD-Core Version:    0.7.0.1
 */