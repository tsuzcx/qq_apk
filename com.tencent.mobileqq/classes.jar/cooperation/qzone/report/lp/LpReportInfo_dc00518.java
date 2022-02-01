package cooperation.qzone.report.lp;

import android.text.TextUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.report.lp.ILpReportUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public class LpReportInfo_dc00518
  implements LpReportInfo
{
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("dc00518:");
    localStringBuilder.append(this.actiontype);
    localStringBuilder.append(",");
    localStringBuilder.append(this.subactiontype);
    localStringBuilder.append(",");
    localStringBuilder.append(this.reserves);
    return localStringBuilder.toString();
  }
  
  public Map<String, String> toMap()
  {
    HashMap localHashMap = new HashMap();
    Object localObject1 = this.infos;
    Object localObject2;
    String str;
    if (localObject1 != null)
    {
      localObject1 = ((Map)localObject1).keySet().iterator();
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
      } else {
        localObject1 = new JSONObject();
      }
      if (((JSONObject)localObject1).length() > 0)
      {
        localObject2 = ((JSONObject)localObject1).keys();
        while (((Iterator)localObject2).hasNext())
        {
          str = (String)((Iterator)localObject2).next();
          localHashMap.put(str, ((JSONObject)localObject1).optString(str));
        }
      }
    }
    catch (Exception localException1)
    {
      label173:
      break label173;
    }
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
    if (localHashMap.containsKey("network_type")) {}
    try
    {
      i = Integer.parseInt((String)localHashMap.get("network_type"));
    }
    catch (Exception localException2)
    {
      int i;
      label316:
      break label316;
    }
    i = ((ILpReportUtils)QRoute.api(ILpReportUtils.class)).getNetworkType();
    break label347;
    i = ((ILpReportUtils)QRoute.api(ILpReportUtils.class)).getNetworkType();
    label347:
    localHashMap.put("network_type", String.valueOf(((ILpReportUtils)QRoute.api(ILpReportUtils.class)).convertNetworkTypeToFitInDc00518(i)));
    localHashMap.put("qua", ((ILpReportUtils)QRoute.api(ILpReportUtils.class)).getQUA3());
    localHashMap.put("device", "2");
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.report.lp.LpReportInfo_dc00518
 * JD-Core Version:    0.7.0.1
 */