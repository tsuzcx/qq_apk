package cooperation.qzone.report.lp;

import com.tencent.common.app.BaseApplicationImpl;
import cooperation.qzone.QUA;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;

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
  
  public Map toMap()
  {
    HashMap localHashMap = new HashMap();
    if (this.uin <= 1000L) {}
    for (String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();; str = String.valueOf(this.uin))
    {
      localHashMap.put("uin", str);
      LpReportUtils.safePut(localHashMap, "qua", QUA.a());
      localHashMap.put("downloadType", String.valueOf(this.downloadType));
      localHashMap.put("isHttp2", String.valueOf(this.isHttp2));
      localHashMap.put("retCode", String.valueOf(this.retCode));
      LpReportUtils.safePut(localHashMap, "downloadUrl", this.downloadUrl);
      LpReportUtils.safePut(localHashMap, "errMsg", this.errMsg);
      return localHashMap;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    for (;;)
    {
      int i;
      try
      {
        Field[] arrayOfField = getClass().getDeclaredFields();
        i = 0;
        if (i < arrayOfField.length)
        {
          localStringBuilder.append(arrayOfField[i].getName());
          Object localObject = arrayOfField[i].get(this);
          if (localObject != null) {
            localStringBuilder.append(":").append(localObject).append("\n");
          } else {
            localStringBuilder.append(":null \n");
          }
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      return localStringBuilder.toString();
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.report.lp.LpReportInfo_dc02349
 * JD-Core Version:    0.7.0.1
 */