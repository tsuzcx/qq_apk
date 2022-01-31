package cooperation.qzone.report.lp;

import android.os.Build;
import android.text.TextUtils;
import bize;
import bizf;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.NetworkState;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class LpReportInfo_DC01691
  implements LpReportInfo
{
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
  public long time;
  public long toUin;
  
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
    this.networkType = NetworkState.getNetworkType();
    if (this.networkType == 1)
    {
      this.networkType = 1;
      return;
    }
    if (this.networkType == 2)
    {
      this.networkType = 2;
      return;
    }
    if (this.networkType == 3)
    {
      this.networkType = 3;
      return;
    }
    if (this.networkType == 4)
    {
      this.networkType = 4;
      return;
    }
    if (this.networkType == 5)
    {
      this.networkType = 5;
      return;
    }
    this.networkType = 9;
  }
  
  public String getSimpleInfo()
  {
    return "DC01691:" + this.actionType + "," + this.subactionType + "," + this.reserves;
  }
  
  public Map<String, String> toMap()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("qua", bizf.a());
    localHashMap.put("uin", BaseApplicationImpl.getApplication().getRuntime().getAccount());
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
      deviceId = bize.a().a();
    }
    if (!TextUtils.isEmpty(deviceId)) {
      localHashMap.put("imei", deviceId);
    }
    LpReportUtils.safePut(localHashMap, "uin_lbs_x", this.longitude);
    LpReportUtils.safePut(localHashMap, "uin_lbs_y", this.latitude);
    for (;;)
    {
      try
      {
        if (!TextUtils.isEmpty(this.extraInfo))
        {
          JSONObject localJSONObject1 = new JSONObject(this.extraInfo);
          if (localJSONObject1.length() > 0)
          {
            Iterator localIterator = localJSONObject1.keys();
            if (localIterator.hasNext())
            {
              String str1 = (String)localIterator.next();
              String str2 = localJSONObject1.getString(str1);
              if (TextUtils.isEmpty(str2)) {
                continue;
              }
              localHashMap.put(str1, str2);
              continue;
            }
          }
          return localHashMap;
        }
      }
      catch (Exception localException)
      {
        QLog.e(TAG, 1, localException, new Object[0]);
      }
      JSONObject localJSONObject2 = new JSONObject();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qzone.report.lp.LpReportInfo_DC01691
 * JD-Core Version:    0.7.0.1
 */