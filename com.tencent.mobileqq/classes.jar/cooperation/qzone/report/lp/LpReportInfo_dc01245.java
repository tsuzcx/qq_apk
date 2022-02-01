package cooperation.qzone.report.lp;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.report.lp.ILpReportUtils;
import java.util.HashMap;
import java.util.Map;

public class LpReportInfo_dc01245
  implements LpReportInfo
{
  public static final int EXPOSE_BAR = 12;
  public static final int EXPOSE_DETAIL = 4;
  public static final int EXPOSE_END = 5;
  public static final int EXPOSE_FRIENDFEED = 2;
  public static final int EXPOSE_MYSHUOSHUO = 13;
  public static final int EXPOSE_PUSH = 11;
  public static final int EXPOSE_USERHOME = 3;
  public int expose_src;
  public String qua;
  public int reserve1;
  public int reserve2;
  public int reserve3;
  public long uin;
  public int zhubo_type;
  public long zhubo_uin;
  
  public LpReportInfo_dc01245(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    this.zhubo_uin = paramLong1;
    this.uin = paramLong2;
    this.expose_src = paramInt1;
    this.zhubo_type = paramInt2;
  }
  
  public static void report(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    LpReportInfo_dc01245 localLpReportInfo_dc01245 = new LpReportInfo_dc01245(paramLong1, paramLong2, paramInt1, paramInt2);
    LpReportManager.getInstance().reportToDC01245(localLpReportInfo_dc01245, false, true);
  }
  
  public String getSimpleInfo()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("dc01245 expose_src：");
    localStringBuilder.append(this.expose_src);
    return localStringBuilder.toString();
  }
  
  public Map<String, String> toMap()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("zhubo_uin", String.valueOf(this.zhubo_uin));
    long l = this.uin;
    if (l != 0L) {
      localHashMap.put("uin", String.valueOf(l));
    } else {
      localHashMap.put("uin", ((ILpReportUtils)QRoute.api(ILpReportUtils.class)).getAccount());
    }
    localHashMap.put("expose_time", String.valueOf(System.currentTimeMillis()));
    localHashMap.put("expose_src", String.valueOf(this.expose_src));
    localHashMap.put("qua", ((ILpReportUtils)QRoute.api(ILpReportUtils.class)).getQUA3());
    localHashMap.put("zhubo_type", String.valueOf(this.zhubo_type));
    localHashMap.put("reserve1", String.valueOf(this.reserve1));
    localHashMap.put("reserve2", String.valueOf(this.reserve2));
    localHashMap.put("reserve3", String.valueOf(this.reserve3));
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.report.lp.LpReportInfo_dc01245
 * JD-Core Version:    0.7.0.1
 */