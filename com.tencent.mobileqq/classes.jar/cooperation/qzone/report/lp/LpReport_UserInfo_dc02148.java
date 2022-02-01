package cooperation.qzone.report.lp;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;

public class LpReport_UserInfo_dc02148
  implements LpReportInfo
{
  public static final String AGE = "age";
  public static final String CITY = "city";
  public static final String CONSTELLATION = "constellation";
  public static final String COUNTRY = "country";
  public static final String GENDER = "gender";
  public static final String PROVINCE = "province";
  public long age;
  public String city;
  public long city_code;
  public String client_ip;
  String client_time;
  public long constellation;
  public String country;
  public long country_code;
  public long gender;
  public String latitude;
  public String longitude;
  public String province;
  public long province_code;
  public long uin;
  
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
      if (!TextUtils.isEmpty(this.client_time)) {
        break label235;
      }
    }
    label235:
    for (String str = String.valueOf(System.currentTimeMillis());; str = this.client_time)
    {
      localHashMap.put("client_time", str);
      LpReportUtils.safePut(localHashMap, "client_ip", this.client_ip);
      localHashMap.put("age", String.valueOf(this.age));
      localHashMap.put("gender", String.valueOf(this.gender));
      localHashMap.put("constellation", String.valueOf(this.constellation));
      LpReportUtils.safePut(localHashMap, "latitude", this.latitude);
      LpReportUtils.safePut(localHashMap, "longitude", this.longitude);
      LpReportUtils.safePut(localHashMap, "country", this.country);
      localHashMap.put("country_code", String.valueOf(this.country_code));
      LpReportUtils.safePut(localHashMap, "province", this.province);
      localHashMap.put("province_code", String.valueOf(this.province_code));
      LpReportUtils.safePut(localHashMap, "city", this.city);
      localHashMap.put("city_code", String.valueOf(this.city_code));
      return localHashMap;
      str = String.valueOf(this.uin);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.report.lp.LpReport_UserInfo_dc02148
 * JD-Core Version:    0.7.0.1
 */