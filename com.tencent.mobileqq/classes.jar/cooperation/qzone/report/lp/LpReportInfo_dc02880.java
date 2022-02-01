package cooperation.qzone.report.lp;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.report.lp.ILpReportUtils;
import cooperation.qzone.util.QZLog;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class LpReportInfo_dc02880
  implements LpReportInfo
{
  public static String TAG = "LpReport.LpReportInfo_dc02880";
  public int actiontype;
  public String item_type;
  public String qua;
  public String reserves3;
  public String reserves6;
  public String reserves8;
  public int subactiontype;
  public long uin;
  public String url;
  
  public LpReportInfo_dc02880(int paramInt1, int paramInt2)
  {
    this.actiontype = paramInt1;
    this.subactiontype = paramInt2;
  }
  
  public LpReportInfo_dc02880(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    this.actiontype = paramInt1;
    this.subactiontype = paramInt2;
    this.url = paramString1;
    this.item_type = paramString2;
  }
  
  public LpReportInfo_dc02880(String paramString1, String paramString2)
  {
    this(2, 2, paramString1, paramString2);
  }
  
  public static void report(int paramInt1, int paramInt2, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramString1 = new LpReportInfo_dc02880(paramInt1, paramInt2, paramString1, paramString2);
    LpReportManager.getInstance().reportToDC02880(paramString1, paramBoolean1, paramBoolean2);
  }
  
  public static void report(int paramInt1, int paramInt2, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, String paramString3)
  {
    paramString1 = new LpReportInfo_dc02880(paramInt1, paramInt2, paramString1, paramString2);
    paramString1.reserves6 = paramString3;
    LpReportManager.getInstance().reportToDC02880(paramString1, paramBoolean1, paramBoolean2);
  }
  
  public static void report(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      Uri localUri = Uri.parse(paramString);
      String str = localUri.getQueryParameter("hydtgzh");
      if (!TextUtils.isEmpty(str))
      {
        report(paramString, str, localUri.getQueryParameter("reserves6"));
        QZoneLoginReportHelper.reportLoginFromMQQPublicAccount(str);
      }
      return;
    }
    catch (Exception paramString)
    {
      QZLog.e(TAG, "", paramString);
    }
  }
  
  public static void report(String paramString1, String paramString2)
  {
    paramString1 = new LpReportInfo_dc02880(paramString1, paramString2);
    LpReportManager.getInstance().reportToDC02880(paramString1, false, false);
  }
  
  public static void report(String paramString1, String paramString2, String paramString3)
  {
    paramString1 = new LpReportInfo_dc02880(paramString1, paramString2);
    paramString1.reserves6 = paramString3;
    LpReportManager.getInstance().reportToDC02880(paramString1, false, false);
  }
  
  public String getSimpleInfo()
  {
    return null;
  }
  
  public Map<String, String> toMap()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("qua", ((ILpReportUtils)QRoute.api(ILpReportUtils.class)).getQUA3());
    if (this.uin == 0L) {}
    for (String str = ((ILpReportUtils)QRoute.api(ILpReportUtils.class)).getAccount();; str = String.valueOf(this.uin))
    {
      localHashMap.put("uin", str);
      localHashMap.put("actiontype", String.valueOf(this.actiontype));
      localHashMap.put("subactiontype", String.valueOf(this.subactiontype));
      LpReportUtils.safePut(localHashMap, "item_type", this.item_type);
      LpReportUtils.safePut(localHashMap, "reserves3", this.reserves3);
      LpReportUtils.safePut(localHashMap, "reserves6", this.reserves6);
      LpReportUtils.safePut(localHashMap, "reserves8", this.reserves8);
      if (!TextUtils.isEmpty(this.url)) {
        localHashMap.put("url", URLEncoder.encode(this.url));
      }
      return localHashMap;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.report.lp.LpReportInfo_dc02880
 * JD-Core Version:    0.7.0.1
 */