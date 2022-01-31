package cooperation.qzone.report.lp;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import cooperation.qzone.QUA;
import cooperation.qzone.util.QZLog;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;

public class LpReportInfo_dc02880
  implements LpReportInfo
{
  public static String TAG = "LpReport.LpReportInfo_dc02880";
  public int actiontype;
  public String item_type;
  public String qua;
  public int subactiontype;
  public long uin;
  public String url;
  
  public LpReportInfo_dc02880(int paramInt1, int paramInt2)
  {
    this.actiontype = paramInt1;
    this.subactiontype = paramInt2;
  }
  
  public LpReportInfo_dc02880(String paramString1, String paramString2)
  {
    this.url = paramString1;
    this.actiontype = 2;
    this.subactiontype = 2;
    this.item_type = paramString2;
  }
  
  public static void report(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      String str = Uri.parse(paramString).getQueryParameter("hydtgzh");
      if (!TextUtils.isEmpty(str))
      {
        report(paramString, str);
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
  
  public String getSimpleInfo()
  {
    return null;
  }
  
  public Map toMap()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("qua", QUA.a());
    if (this.uin == 0L) {}
    for (String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();; str = String.valueOf(this.uin))
    {
      localHashMap.put("uin", str);
      localHashMap.put("actiontype", String.valueOf(this.actiontype));
      localHashMap.put("subactiontype", String.valueOf(this.subactiontype));
      LpReportUtils.safePut(localHashMap, "item_type", this.item_type);
      if (!TextUtils.isEmpty(this.url)) {
        localHashMap.put("url", URLEncoder.encode(this.url));
      }
      return localHashMap;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.report.lp.LpReportInfo_dc02880
 * JD-Core Version:    0.7.0.1
 */