package cooperation.qzone.report.lp;

import android.text.TextUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.report.lp.ILpReportUtils;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class LpReport_AlbumInfo_dc02151
  implements LpReportInfo
{
  public String client_time;
  public long event_id;
  public String latitude;
  public String longitude;
  public long operation_id;
  public String qua;
  public long recommend_id;
  public long recommend_index;
  public String recommend_title;
  public long uin;
  public String version;
  
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
    if (TextUtils.isEmpty(this.client_time)) {
      str = String.valueOf(System.currentTimeMillis());
    } else {
      str = this.client_time;
    }
    localHashMap.put("client_time", str);
    LpReportUtils.safePut(localHashMap, "longitude", this.longitude);
    LpReportUtils.safePut(localHashMap, "latitude", this.latitude);
    localHashMap.put("event_id", String.valueOf(this.event_id));
    localHashMap.put("operation_id", String.valueOf(this.operation_id));
    LpReportUtils.safePut(localHashMap, "recommend_title", this.recommend_title);
    localHashMap.put("recommend_index", String.valueOf(this.recommend_index));
    localHashMap.put("recommend_id", String.valueOf(this.recommend_id));
    if (TextUtils.isEmpty(this.version)) {
      str = "8.7.0";
    } else {
      str = this.version;
    }
    LpReportUtils.safePut(localHashMap, "version", str);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.report.lp.LpReport_AlbumInfo_dc02151
 * JD-Core Version:    0.7.0.1
 */