import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class spx
{
  public static int a;
  public static int b = 1;
  public static int c = 2;
  public static int d = 3;
  public static int e = 4;
  public static int f = 1;
  public int g;
  public int h;
  public int i;
  public int j;
  public int k;
  public int l;
  public int m;
  public int n;
  
  public spx(int paramInt1, int paramInt2)
  {
    this.m = paramInt1;
    this.n = paramInt2;
  }
  
  public HashMap<String, String> a()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_hitCount", String.valueOf(this.g));
    localHashMap.put("param_notHitCount", String.valueOf(this.h));
    localHashMap.put("param_triggerCount", String.valueOf(this.i));
    localHashMap.put("param_triggerHitCount", String.valueOf(this.j));
    localHashMap.put("param_distinctTriggerHitCount", String.valueOf(this.k));
    localHashMap.put("param_realTriggerHitCount", String.valueOf(this.l));
    localHashMap.put("param_sceneType", String.valueOf(this.m));
    localHashMap.put("param_strategy", String.valueOf(this.n));
    if (QLog.isColorLevel()) {
      QLog.i("wgs", 2, "VideoPreloadReportData getReportMap " + localHashMap.toString());
    }
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     spx
 * JD-Core Version:    0.7.0.1
 */