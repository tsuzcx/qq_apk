package cooperation.qzone.report.lp;

import android.text.TextUtils;
import bmsw;
import com.tencent.common.app.BaseApplicationImpl;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;

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
    if (this.uin <= 1000L)
    {
      str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      localHashMap.put("uin", str);
      LpReportUtils.safePut(localHashMap, "qua", bmsw.a());
      if (!TextUtils.isEmpty(this.client_time)) {
        break label202;
      }
      str = String.valueOf(System.currentTimeMillis());
      label65:
      localHashMap.put("client_time", str);
      LpReportUtils.safePut(localHashMap, "longitude", this.longitude);
      LpReportUtils.safePut(localHashMap, "latitude", this.latitude);
      localHashMap.put("event_id", String.valueOf(this.event_id));
      localHashMap.put("operation_id", String.valueOf(this.operation_id));
      LpReportUtils.safePut(localHashMap, "recommend_title", this.recommend_title);
      localHashMap.put("recommend_index", String.valueOf(this.recommend_index));
      localHashMap.put("recommend_id", String.valueOf(this.recommend_id));
      if (!TextUtils.isEmpty(this.version)) {
        break label210;
      }
    }
    label202:
    label210:
    for (String str = "8.4.5";; str = this.version)
    {
      LpReportUtils.safePut(localHashMap, "version", str);
      return localHashMap;
      str = String.valueOf(this.uin);
      break;
      str = this.client_time;
      break label65;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.report.lp.LpReport_AlbumInfo_dc02151
 * JD-Core Version:    0.7.0.1
 */