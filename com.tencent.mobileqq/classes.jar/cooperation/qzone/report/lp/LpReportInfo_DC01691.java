package cooperation.qzone.report.lp;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.report.lp.ILpReportUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public class LpReportInfo_DC01691
  implements LpReportInfo
{
  public static final int NET_TYPE_2G = 2;
  public static final int NET_TYPE_3G = 3;
  public static final int NET_TYPE_4G = 4;
  public static final int NET_TYPE_5G = 5;
  public static final int NET_TYPE_UNKNOWN = 0;
  public static final int NET_TYPE_WIFI = 1;
  private static String TAG = "LpReport.LpReportInfo_DC01691";
  public static String deviceId;
  public int actionType;
  public String appId = "0";
  public String domain_type = "2";
  public String extraInfo = "";
  public int feedsType;
  public String feedsid;
  public String info = "";
  public String latitude;
  public String longitude;
  public int networkType;
  public String referId = "";
  public int reserves;
  public String sourceFrom = "";
  public String sourceTo = "";
  public String sourceType = "";
  public int subactionType;
  public int tabletype = 11;
  public long time = 0L;
  public long toUin = 0L;
  
  public LpReportInfo_DC01691(int paramInt1, int paramInt2, int paramInt3, long paramLong, String paramString1, int paramInt4, String paramString2, String paramString3)
  {
    this.actionType = paramInt1;
    this.subactionType = paramInt2;
    this.reserves = paramInt3;
    this.toUin = paramLong;
    this.feedsid = paramString1;
    this.feedsType = paramInt4;
    this.latitude = paramString2;
    this.longitude = paramString3;
    this.networkType = ((ILpReportUtils)QRoute.api(ILpReportUtils.class)).getnetworkType();
    paramInt1 = this.networkType;
    if (paramInt1 == 1)
    {
      this.networkType = 1;
      return;
    }
    if (paramInt1 == 2)
    {
      this.networkType = 2;
      return;
    }
    if (paramInt1 == 3)
    {
      this.networkType = 3;
      return;
    }
    if (paramInt1 == 4)
    {
      this.networkType = 4;
      return;
    }
    if (paramInt1 == 5)
    {
      this.networkType = 5;
      return;
    }
    this.networkType = 9;
  }
  
  public String getSimpleInfo()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DC01691:");
    localStringBuilder.append(this.actionType);
    localStringBuilder.append(",");
    localStringBuilder.append(this.subactionType);
    localStringBuilder.append(",");
    localStringBuilder.append(this.reserves);
    return localStringBuilder.toString();
  }
  
  public Map<String, String> toMap()
  {
    localHashMap = new HashMap();
    localHashMap.put("qua", ((ILpReportUtils)QRoute.api(ILpReportUtils.class)).getQUA3());
    localHashMap.put("uin", ((ILpReportUtils)QRoute.api(ILpReportUtils.class)).getAccount());
    localHashMap.put("to_uin", String.valueOf(this.toUin));
    localHashMap.put("network_type", String.valueOf(this.networkType));
    localHashMap.put("tabletype", String.valueOf(this.tabletype));
    localHashMap.put("actiontype", String.valueOf(this.actionType));
    localHashMap.put("subactiontype", String.valueOf(this.subactionType));
    LpReportUtils.safePut(localHashMap, "domain_type", this.domain_type);
    localHashMap.put("reserves", String.valueOf(this.reserves));
    LpReportUtils.safePut(localHashMap, "source_type", this.sourceType);
    LpReportUtils.safePut(localHashMap, "source_from", this.sourceFrom);
    LpReportUtils.safePut(localHashMap, "source_to", this.sourceTo);
    LpReportUtils.safePut(localHashMap, "feedsid", this.feedsid);
    localHashMap.put("feeds_type", String.valueOf(this.feedsType));
    localHashMap.put("mobile_type", Build.MODEL);
    if (TextUtils.isEmpty(deviceId)) {
      deviceId = ((ILpReportUtils)QRoute.api(ILpReportUtils.class)).getIMEI();
    }
    if (!TextUtils.isEmpty(deviceId)) {
      localHashMap.put("imei", deviceId);
    }
    LpReportUtils.safePut(localHashMap, "uin_lbs_x", this.longitude);
    LpReportUtils.safePut(localHashMap, "uin_lbs_y", this.latitude);
    try
    {
      JSONObject localJSONObject;
      if (!TextUtils.isEmpty(this.extraInfo)) {
        localJSONObject = new JSONObject(this.extraInfo);
      } else {
        localJSONObject = new JSONObject();
      }
      if (localJSONObject.length() > 0)
      {
        Iterator localIterator = localJSONObject.keys();
        while (localIterator.hasNext())
        {
          String str1 = (String)localIterator.next();
          String str2 = localJSONObject.getString(str1);
          if (!TextUtils.isEmpty(str2)) {
            localHashMap.put(str1, str2);
          }
        }
      }
      return localHashMap;
    }
    catch (Exception localException)
    {
      QLog.e(TAG, 1, localException, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.report.lp.LpReportInfo_DC01691
 * JD-Core Version:    0.7.0.1
 */