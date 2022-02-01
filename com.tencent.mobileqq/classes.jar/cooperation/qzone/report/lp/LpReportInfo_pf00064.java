package cooperation.qzone.report.lp;

import android.text.TextUtils;
import blrt;
import blru;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.NetworkState;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;

public class LpReportInfo_pf00064
  implements LpReportInfo
{
  private static String TAG = "LpReport.LpReportInfo_pf00064";
  public int actionType;
  public String appId = "0";
  public String domain_type = "2";
  public String extraInfo = "";
  public String info = "";
  public boolean isTemp;
  private Map<String, String> mapReportInfo;
  public int mergenum;
  public int networkType = NetworkState.getNetworkType();
  public String pushstatkey = "";
  public String readSource = "0";
  public String referId = "";
  public int reserves;
  public String reserves10 = "";
  public String reserves2 = "";
  public String reserves3 = "";
  public String reserves4 = "";
  public String reserves5 = "";
  public String reserves6 = "";
  public String reserves7 = "";
  public String reserves8 = "";
  public String reserves9 = "";
  public ArrayList<String> reservesArray = new ArrayList();
  public ArrayList<String> reservesExt;
  public String sourceFrom = "";
  public String sourceTo = "";
  public String sourceType = "";
  public int subactionType;
  public int tabletype;
  public long time = System.currentTimeMillis();
  public long toUin;
  private boolean useMapMode;
  
  public LpReportInfo_pf00064() {}
  
  public LpReportInfo_pf00064(int paramInt1, int paramInt2, int paramInt3)
  {
    this();
    this.actionType = paramInt1;
    this.subactionType = paramInt2;
    this.reserves = paramInt3;
  }
  
  public LpReportInfo_pf00064(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    this();
    this.actionType = paramInt1;
    this.subactionType = paramInt2;
    this.reserves = paramInt3;
    this.toUin = paramLong;
  }
  
  public LpReportInfo_pf00064(int paramInt1, int paramInt2, long paramLong)
  {
    this();
    this.actionType = paramInt1;
    this.subactionType = paramInt2;
    this.toUin = paramLong;
  }
  
  public LpReportInfo_pf00064(long paramLong, int paramInt, String paramString, Map<String, String> paramMap)
  {
    this();
    this.toUin = paramLong;
    this.appId = paramString;
    this.tabletype = paramInt;
    this.useMapMode = true;
    if (paramMap != null)
    {
      this.mapReportInfo = new HashMap();
      this.mapReportInfo.putAll(paramMap);
    }
  }
  
  public LpReportInfo_pf00064(long paramLong, String paramString, Map<String, String> paramMap)
  {
    this();
    this.toUin = paramLong;
    this.appId = paramString;
    this.useMapMode = true;
    if (paramMap != null)
    {
      this.mapReportInfo = new HashMap();
      this.mapReportInfo.putAll(paramMap);
    }
  }
  
  public LpReportInfo_pf00064(String paramString1, String paramString2)
  {
    this();
    this.actionType = Integer.parseInt(paramString1);
    this.subactionType = Integer.parseInt(paramString2);
  }
  
  public LpReportInfo_pf00064(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    this();
    this.actionType = Integer.parseInt(paramString1);
    this.subactionType = Integer.parseInt(paramString2);
    this.reserves = paramInt;
    this.reserves2 = paramString3;
    this.reserves3 = paramString4;
  }
  
  public LpReportInfo_pf00064(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this();
    this.actionType = Integer.parseInt(paramString1);
    this.subactionType = Integer.parseInt(paramString2);
    this.reserves = Integer.parseInt(paramString3);
    this.reserves5 = paramString4;
  }
  
  public static void allReport(int paramInt1, int paramInt2)
  {
    LpReportInfo_pf00064 localLpReportInfo_pf00064 = new LpReportInfo_pf00064();
    localLpReportInfo_pf00064.actionType = paramInt1;
    localLpReportInfo_pf00064.subactionType = paramInt2;
    LpReportManager.getInstance().reportToPF00064(localLpReportInfo_pf00064, false, false);
  }
  
  public static void allReport(int paramInt1, int paramInt2, int paramInt3)
  {
    allReport(paramInt1, paramInt2, paramInt3, null);
  }
  
  public static void allReport(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    LpReportInfo_pf00064 localLpReportInfo_pf00064 = new LpReportInfo_pf00064();
    localLpReportInfo_pf00064.actionType = paramInt1;
    localLpReportInfo_pf00064.subactionType = paramInt2;
    localLpReportInfo_pf00064.reserves = paramInt3;
    localLpReportInfo_pf00064.toUin = paramLong;
    LpReportManager.getInstance().reportToPF00064(localLpReportInfo_pf00064, false, false);
  }
  
  public static void allReport(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    allReport(paramInt1, paramInt2, paramInt3, paramString, null);
  }
  
  public static void allReport(int paramInt1, int paramInt2, int paramInt3, String paramString, long paramLong)
  {
    LpReportInfo_pf00064 localLpReportInfo_pf00064 = new LpReportInfo_pf00064();
    localLpReportInfo_pf00064.actionType = paramInt1;
    localLpReportInfo_pf00064.subactionType = paramInt2;
    localLpReportInfo_pf00064.reserves = paramInt3;
    localLpReportInfo_pf00064.reserves2 = paramString;
    localLpReportInfo_pf00064.toUin = paramLong;
    LpReportManager.getInstance().reportToPF00064(localLpReportInfo_pf00064, false, false);
  }
  
  public static void allReport(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2)
  {
    allReport(paramInt1, paramInt2, paramInt3, paramString1, paramString2, null);
  }
  
  public static void allReport(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, long paramLong)
  {
    LpReportInfo_pf00064 localLpReportInfo_pf00064 = new LpReportInfo_pf00064();
    localLpReportInfo_pf00064.actionType = paramInt1;
    localLpReportInfo_pf00064.subactionType = paramInt2;
    localLpReportInfo_pf00064.reserves = paramInt3;
    localLpReportInfo_pf00064.reserves2 = paramString1;
    localLpReportInfo_pf00064.reserves6 = paramString2;
    localLpReportInfo_pf00064.toUin = paramLong;
    LpReportManager.getInstance().reportToPF00064(localLpReportInfo_pf00064, false, false);
  }
  
  public static void allReport(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3)
  {
    allReport(paramInt1, paramInt2, paramInt3, paramString1, paramString2, paramString3, 0L);
  }
  
  public static void allReport(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3, long paramLong)
  {
    allReport(paramInt1, paramInt2, paramInt3, paramString1, paramString2, paramString3, null, null, paramLong);
  }
  
  public static void allReport(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    allReport(paramInt1, paramInt2, paramInt3, paramString1, paramString2, paramString3, paramString4, null, 0L);
  }
  
  public static void allReport(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong)
  {
    LpReportInfo_pf00064 localLpReportInfo_pf00064 = new LpReportInfo_pf00064();
    localLpReportInfo_pf00064.actionType = paramInt1;
    if ((paramInt1 == 309) && ("com.tencent.mobileqq".equals(MobileQQ.processName))) {
      localLpReportInfo_pf00064.reserves9 = "1";
    }
    localLpReportInfo_pf00064.subactionType = paramInt2;
    localLpReportInfo_pf00064.reserves = paramInt3;
    if (!TextUtils.isEmpty(paramString1)) {
      localLpReportInfo_pf00064.reserves2 = paramString1;
    }
    if (!TextUtils.isEmpty(paramString2)) {
      localLpReportInfo_pf00064.reserves3 = paramString2;
    }
    if (!TextUtils.isEmpty(paramString3)) {
      localLpReportInfo_pf00064.reserves4 = paramString3;
    }
    if (!TextUtils.isEmpty(paramString4)) {
      localLpReportInfo_pf00064.reserves5 = paramString4;
    }
    if (!TextUtils.isEmpty(paramString5)) {
      localLpReportInfo_pf00064.reserves7 = paramString5;
    }
    localLpReportInfo_pf00064.toUin = paramLong;
    LpReportManager.getInstance().reportToPF00064(localLpReportInfo_pf00064, false, false);
  }
  
  public static void allReport(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    LpReportInfo_pf00064 localLpReportInfo_pf00064 = new LpReportInfo_pf00064();
    localLpReportInfo_pf00064.actionType = paramInt1;
    localLpReportInfo_pf00064.subactionType = paramInt2;
    localLpReportInfo_pf00064.reserves = paramInt3;
    LpReportManager.getInstance().reportToPF00064(localLpReportInfo_pf00064, false, paramBoolean);
  }
  
  public static void allReport(int paramInt1, int paramInt2, String paramString)
  {
    LpReportInfo_pf00064 localLpReportInfo_pf00064 = new LpReportInfo_pf00064();
    localLpReportInfo_pf00064.actionType = paramInt1;
    localLpReportInfo_pf00064.subactionType = paramInt2;
    localLpReportInfo_pf00064.reserves4 = paramString;
    LpReportManager.getInstance().reportToPF00064(localLpReportInfo_pf00064, true, false);
  }
  
  public static void report(int paramInt1, int paramInt2)
  {
    LpReportInfo_pf00064 localLpReportInfo_pf00064 = new LpReportInfo_pf00064();
    localLpReportInfo_pf00064.actionType = paramInt1;
    localLpReportInfo_pf00064.subactionType = paramInt2;
    LpReportManager.getInstance().reportToPF00064(localLpReportInfo_pf00064, true, false);
  }
  
  public static void report(int paramInt1, int paramInt2, int paramInt3)
  {
    LpReportInfo_pf00064 localLpReportInfo_pf00064 = new LpReportInfo_pf00064();
    localLpReportInfo_pf00064.actionType = paramInt1;
    localLpReportInfo_pf00064.subactionType = paramInt2;
    localLpReportInfo_pf00064.reserves = paramInt3;
    LpReportManager.getInstance().reportToPF00064(localLpReportInfo_pf00064, true, false);
  }
  
  public static void report(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    LpReportInfo_pf00064 localLpReportInfo_pf00064 = new LpReportInfo_pf00064();
    localLpReportInfo_pf00064.actionType = paramInt1;
    localLpReportInfo_pf00064.subactionType = paramInt2;
    localLpReportInfo_pf00064.reserves = paramInt3;
    localLpReportInfo_pf00064.reserves2 = paramString;
    LpReportManager.getInstance().reportToPF00064(localLpReportInfo_pf00064, true, false);
  }
  
  public static void report(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2)
  {
    LpReportInfo_pf00064 localLpReportInfo_pf00064 = new LpReportInfo_pf00064();
    localLpReportInfo_pf00064.actionType = paramInt1;
    localLpReportInfo_pf00064.subactionType = paramInt2;
    localLpReportInfo_pf00064.reserves = paramInt3;
    localLpReportInfo_pf00064.reserves2 = paramString1;
    localLpReportInfo_pf00064.reserves3 = paramString2;
    LpReportManager.getInstance().reportToPF00064(localLpReportInfo_pf00064, true, false);
  }
  
  public static void report(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3)
  {
    LpReportInfo_pf00064 localLpReportInfo_pf00064 = new LpReportInfo_pf00064();
    localLpReportInfo_pf00064.actionType = paramInt1;
    localLpReportInfo_pf00064.subactionType = paramInt2;
    localLpReportInfo_pf00064.reserves = paramInt3;
    localLpReportInfo_pf00064.reserves4 = paramString1;
    localLpReportInfo_pf00064.reserves6 = paramString2;
    localLpReportInfo_pf00064.reserves7 = paramString3;
    LpReportManager.getInstance().reportToPF00064(localLpReportInfo_pf00064, false, false);
  }
  
  public static void report(int paramInt, String paramString)
  {
    LpReportInfo_pf00064 localLpReportInfo_pf00064 = new LpReportInfo_pf00064();
    localLpReportInfo_pf00064.actionType = paramInt;
    localLpReportInfo_pf00064.reserves10 = paramString;
    LpReportManager.getInstance().reportToPF00064(localLpReportInfo_pf00064, false, false);
  }
  
  public String getSimpleInfo()
  {
    return "pf00064:" + this.actionType + "," + this.subactionType + "," + this.reserves;
  }
  
  public void reportImediately()
  {
    LpReportManager.getInstance().reportToPF00064(this, false, true);
  }
  
  public Map<String, String> toMap()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("qua", blru.a());
    localHashMap.put("device_info", blrt.a().c());
    if ((BaseApplicationImpl.getApplication() != null) && (BaseApplicationImpl.getApplication().getRuntime() != null)) {
      localHashMap.put("uin", BaseApplicationImpl.getApplication().getRuntime().getAccount());
    }
    Object localObject1;
    Object localObject2;
    for (;;)
    {
      localHashMap.put("touin", String.valueOf(this.toUin));
      localHashMap.put("network_type", String.valueOf(this.networkType));
      localHashMap.put("tabletype", String.valueOf(this.tabletype));
      if (!this.useMapMode) {
        break;
      }
      if ((this.mapReportInfo == null) || (this.mapReportInfo.isEmpty())) {
        break label628;
      }
      localObject1 = this.mapReportInfo.entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        LpReportUtils.safePut(localHashMap, (String)((Map.Entry)localObject2).getKey(), (String)((Map.Entry)localObject2).getValue());
      }
      localHashMap.put("uin", "0");
      QLog.e(TAG, 1, "uin=0 actiontype=" + this.actionType + " subactiontype=" + this.subactionType);
    }
    if (!localHashMap.containsKey("refer")) {
      localHashMap.put("refer", this.referId);
    }
    localHashMap.put("actiontype", String.valueOf(this.actionType));
    localHashMap.put("subactiontype", String.valueOf(this.subactionType));
    localHashMap.put("tabletype", String.valueOf(this.tabletype));
    LpReportUtils.safePut(localHashMap, "domain_type", this.domain_type);
    localHashMap.put("reserves", String.valueOf(this.reserves));
    LpReportUtils.safePut(localHashMap, "source_type", this.sourceType);
    LpReportUtils.safePut(localHashMap, "source_from", this.sourceFrom);
    LpReportUtils.safePut(localHashMap, "source_to", this.sourceTo);
    LpReportUtils.safePut(localHashMap, "reserves2", this.reserves2);
    LpReportUtils.safePut(localHashMap, "reserves3", this.reserves3);
    LpReportUtils.safePut(localHashMap, "reserves4", this.reserves4);
    LpReportUtils.safePut(localHashMap, "reserves5", this.reserves5);
    LpReportUtils.safePut(localHashMap, "reserves6", this.reserves6);
    LpReportUtils.safePut(localHashMap, "reserves7", this.reserves7);
    LpReportUtils.safePut(localHashMap, "reserves8", this.reserves8);
    LpReportUtils.safePut(localHashMap, "reserves9", this.reserves9);
    LpReportUtils.safePut(localHashMap, "reserves10", this.reserves10);
    localHashMap.put("mergenum", String.valueOf(this.mergenum));
    if (this.reservesExt != null)
    {
      int j = this.reservesExt.size();
      int i = 0;
      while (i < j)
      {
        localObject1 = (String)this.reservesExt.get(i);
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          localHashMap.put("reserves" + (i + 2), localObject1);
        }
        i += 1;
      }
    }
    label628:
    LpReportUtils.safePut(localHashMap, "read_source", this.readSource);
    localHashMap.put("time", String.valueOf(this.time));
    LpReportUtils.safePut(localHashMap, "info", this.info);
    LpReportUtils.safePut(localHashMap, "pushstatkey", this.pushstatkey);
    for (;;)
    {
      try
      {
        if (!TextUtils.isEmpty(this.extraInfo))
        {
          localObject1 = new JSONObject(this.extraInfo);
          if (((JSONObject)localObject1).length() > 0)
          {
            localObject2 = ((JSONObject)localObject1).keys();
            if (((Iterator)localObject2).hasNext())
            {
              String str1 = (String)((Iterator)localObject2).next();
              String str2 = ((JSONObject)localObject1).getString(str1);
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
      catch (Throwable localThrowable)
      {
        QLog.e(TAG, 1, localThrowable, new Object[0]);
      }
      JSONObject localJSONObject = new JSONObject();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.report.lp.LpReportInfo_pf00064
 * JD-Core Version:    0.7.0.1
 */