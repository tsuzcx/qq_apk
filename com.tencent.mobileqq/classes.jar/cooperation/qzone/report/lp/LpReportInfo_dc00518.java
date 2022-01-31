package cooperation.qzone.report.lp;

import android.text.TextUtils;
import bjdm;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.module.common.NetworkState;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class LpReportInfo_dc00518
  implements LpReportInfo
{
  public static final int DC00518_NETWORK_TYPE_2G = 2;
  public static final int DC00518_NETWORK_TYPE_3G = 3;
  public static final int DC00518_NETWORK_TYPE_4G = 4;
  public static final int DC00518_NETWORK_TYPE_5G = 5;
  public static final int DC00518_NETWORK_TYPE_CABLE = 6;
  public static final int DC00518_NETWORK_TYPE_UNKNOWN = 9;
  public static final int DC00518_NETWORK_TYPE_WIFI = 1;
  public int actiontype;
  public String extraInfo;
  public Map<String, String> infos;
  public int network_type;
  public String qua;
  public int reserves;
  public int subactiontype;
  public long uin;
  
  public LpReportInfo_dc00518() {}
  
  public LpReportInfo_dc00518(int paramInt1, int paramInt2, int paramInt3)
  {
    this.actiontype = paramInt1;
    this.subactiontype = paramInt2;
    this.reserves = paramInt3;
  }
  
  public LpReportInfo_dc00518(int paramInt1, int paramInt2, int paramInt3, Map<String, String> paramMap)
  {
    this.actiontype = paramInt1;
    this.subactiontype = paramInt2;
    this.reserves = paramInt3;
    this.infos = paramMap;
  }
  
  public static int convertNetworkTypeToFitInDc00518(int paramInt)
  {
    switch (paramInt)
    {
    case 4: 
    case 5: 
    default: 
      return 9;
    case 1: 
      return 1;
    case 3: 
      return 2;
    case 2: 
      return 3;
    }
    return 4;
  }
  
  public static void report(int paramInt1, int paramInt2, int paramInt3)
  {
    LpReportInfo_dc00518 localLpReportInfo_dc00518 = new LpReportInfo_dc00518(paramInt1, paramInt2, paramInt3);
    LpReportManager.getInstance().reportToDC00518(localLpReportInfo_dc00518, false, true);
  }
  
  public static void report(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2)
  {
    LpReportInfo_dc00518 localLpReportInfo_dc00518 = new LpReportInfo_dc00518(paramInt1, paramInt2, paramInt3);
    LpReportManager.getInstance().reportToDC00518(localLpReportInfo_dc00518, paramBoolean1, paramBoolean2);
  }
  
  public String getSimpleInfo()
  {
    return "dc00518:" + this.actiontype + "," + this.subactiontype + "," + this.reserves;
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
          localHashMap.put("network_type", String.valueOf(convertNetworkTypeToFitInDc00518(i)));
          localHashMap.put("qua", bjdm.a());
          localHashMap.put("device", "2");
          return localHashMap;
          localJSONObject = new JSONObject();
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            i = NetworkState.g().getNetworkType();
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
        localHashMap.put("uin", BaseApplicationImpl.getApplication().getRuntime().getAccount());
      }
      if (!localHashMap.containsKey("network_type")) {}
    }
    for (;;)
    {
      JSONObject localJSONObject;
      int i = NetworkState.g().getNetworkType();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qzone.report.lp.LpReportInfo_dc00518
 * JD-Core Version:    0.7.0.1
 */