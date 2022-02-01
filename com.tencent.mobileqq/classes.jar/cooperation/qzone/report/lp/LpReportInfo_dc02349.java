package cooperation.qzone.report.lp;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.report.lp.ILpReportUtils;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class LpReportInfo_dc02349
  implements LpReportInfo
{
  public int downloadType;
  public String downloadUrl;
  public String errMsg;
  public int isHttp2;
  public String qua;
  public int retCode;
  public long uin;
  
  public String getSimpleInfo()
  {
    return null;
  }
  
  public Map<String, String> toMap()
  {
    HashMap localHashMap = new HashMap();
    long l = this.uin;
    String str;
    if (l <= 1000L) {
      str = ((ILpReportUtils)QRoute.api(ILpReportUtils.class)).getAccount();
    } else {
      str = String.valueOf(l);
    }
    localHashMap.put("uin", str);
    LpReportUtils.safePut(localHashMap, "qua", ((ILpReportUtils)QRoute.api(ILpReportUtils.class)).getQUA3());
    localHashMap.put("downloadType", String.valueOf(this.downloadType));
    localHashMap.put("isHttp2", String.valueOf(this.isHttp2));
    localHashMap.put("retCode", String.valueOf(this.retCode));
    LpReportUtils.safePut(localHashMap, "downloadUrl", this.downloadUrl);
    LpReportUtils.safePut(localHashMap, "errMsg", this.errMsg);
    return localHashMap;
  }
  
  public String toString()
  {
    localStringBuilder = new StringBuilder();
    try
    {
      Field[] arrayOfField = getClass().getDeclaredFields();
      int i = 0;
      while (i < arrayOfField.length)
      {
        localStringBuilder.append(arrayOfField[i].getName());
        Object localObject = arrayOfField[i].get(this);
        if (localObject != null)
        {
          localStringBuilder.append(":");
          localStringBuilder.append(localObject);
          localStringBuilder.append("\n");
        }
        else
        {
          localStringBuilder.append(":null \n");
        }
        i += 1;
      }
      return localStringBuilder.toString();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.report.lp.LpReportInfo_dc02349
 * JD-Core Version:    0.7.0.1
 */