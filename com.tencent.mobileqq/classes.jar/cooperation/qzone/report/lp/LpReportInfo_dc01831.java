package cooperation.qzone.report.lp;

import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.report.lp.ILpReportUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public class LpReportInfo_dc01831
  implements LpReportInfo
{
  public static final int DC00321_NETWORK_TYPE_2G = 2;
  public static final int DC00321_NETWORK_TYPE_3G = 3;
  public static final int DC00321_NETWORK_TYPE_4G = 4;
  public static final int DC00321_NETWORK_TYPE_5G = 5;
  public static final int DC00321_NETWORK_TYPE_CABLE = 6;
  public static final int DC00321_NETWORK_TYPE_UNKNOWN = 9;
  public static final int DC00321_NETWORK_TYPE_WIFI = 1;
  public long actiontype;
  public long app_id;
  public long device;
  public String extraInfo;
  public String gateway_ip;
  public String imei;
  public Map<String, String> infos;
  public int network_type;
  public String os_version;
  public String qua;
  public long reserves;
  public long subactiontype;
  public long touin;
  public long uin;
  
  public LpReportInfo_dc01831() {}
  
  public LpReportInfo_dc01831(int paramInt1, int paramInt2, int paramInt3)
  {
    this.actiontype = paramInt1;
    this.subactiontype = paramInt2;
    this.reserves = paramInt3;
  }
  
  public LpReportInfo_dc01831(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    this.actiontype = paramInt1;
    this.subactiontype = paramInt2;
    this.reserves = paramInt3;
    this.touin = paramLong;
  }
  
  public LpReportInfo_dc01831(int paramInt1, int paramInt2, int paramInt3, Map<String, String> paramMap)
  {
    this.actiontype = paramInt1;
    this.subactiontype = paramInt2;
    this.reserves = paramInt3;
    this.infos = paramMap;
  }
  
  public static void report(int paramInt1, int paramInt2, int paramInt3)
  {
    LpReportInfo_dc01831 localLpReportInfo_dc01831 = new LpReportInfo_dc01831(paramInt1, paramInt2, paramInt3);
    LpReportManager.getInstance().reportToDC001831(localLpReportInfo_dc01831, false, true);
  }
  
  public static void report(int paramInt1, int paramInt2, int paramInt3, Map<String, String> paramMap)
  {
    paramMap = new LpReportInfo_dc01831(paramInt1, paramInt2, paramInt3, paramMap);
    LpReportManager.getInstance().reportToDC001831(paramMap, false, true);
  }
  
  public static void report(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2)
  {
    LpReportInfo_dc01831 localLpReportInfo_dc01831 = new LpReportInfo_dc01831(paramInt1, paramInt2, paramInt3);
    LpReportManager.getInstance().reportToDC001831(localLpReportInfo_dc01831, paramBoolean1, paramBoolean2);
  }
  
  public String getSimpleInfo()
  {
    return "dc01831:" + this.actiontype + "," + this.subactiontype + "," + this.reserves;
  }
  
  public Map<String, String> toMap()
  {
    HashMap localHashMap = new HashMap();
    Object localObject1;
    Object localObject2;
    String str;
    if (this.infos != null)
    {
      localObject1 = this.infos.keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        str = (String)this.infos.get(localObject2);
        if (!TextUtils.isEmpty(str)) {
          localHashMap.put(localObject2, str);
        }
      }
    }
    try
    {
      if (!TextUtils.isEmpty(this.extraInfo)) {
        localObject1 = new JSONObject(this.extraInfo);
      }
      for (;;)
      {
        if (((JSONObject)localObject1).length() > 0)
        {
          localObject2 = ((JSONObject)localObject1).keys();
          while (((Iterator)localObject2).hasNext())
          {
            str = (String)((Iterator)localObject2).next();
            localHashMap.put(str, ((JSONObject)localObject1).optString(str));
          }
        }
        try
        {
          i = Integer.parseInt((String)localHashMap.get("network_type"));
          localHashMap.put("network_type", String.valueOf(((ILpReportUtils)QRoute.api(ILpReportUtils.class)).convertNetworkTypeToFitInDc00518(i)));
          localHashMap.put("app_id", String.valueOf(AppSetting.a()));
          localHashMap.put("qua", ((ILpReportUtils)QRoute.api(ILpReportUtils.class)).getQUA3());
          localHashMap.put("device", "1");
          localHashMap.put("os_version", "android_" + Build.VERSION.RELEASE);
          localHashMap.put("imei", ((ILpReportUtils)QRoute.api(ILpReportUtils.class)).getIMEI());
          return localHashMap;
          localJSONObject = new JSONObject();
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            i = ((ILpReportUtils)QRoute.api(ILpReportUtils.class)).getNetworkType();
          }
        }
      }
    }
    catch (Exception localException1)
    {
      if (!localHashMap.containsKey("actiontype")) {
        localHashMap.put("actiontype", String.valueOf(this.actiontype));
      }
      if (!localHashMap.containsKey("subactiontype")) {
        localHashMap.put("subactiontype", String.valueOf(this.subactiontype));
      }
      if (!localHashMap.containsKey("reserves")) {
        localHashMap.put("reserves", String.valueOf(this.reserves));
      }
      if (!localHashMap.containsKey("uin")) {
        localHashMap.put("uin", ((ILpReportUtils)QRoute.api(ILpReportUtils.class)).getAccount());
      }
      if (!localHashMap.containsKey("touin")) {
        localHashMap.put("touin", String.valueOf(this.touin));
      }
      if (!localHashMap.containsKey("network_type")) {}
    }
    for (;;)
    {
      JSONObject localJSONObject;
      int i = ((ILpReportUtils)QRoute.api(ILpReportUtils.class)).getNetworkType();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.report.lp.LpReportInfo_dc01831
 * JD-Core Version:    0.7.0.1
 */