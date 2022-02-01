package cooperation.qzone.mobilereport;

import NS_USER_ACTION_REPORT.ItemInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import awfl;
import blbz;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;
import java.net.URLEncoder;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class MobileReportManager
{
  private static final String TAG = "MobileReport.Manager";
  public static final String sTraceKey = "h5costreport=1";
  private final MobileReportManager.ReportLiveTask mReportLiveTask = new MobileReportManager.ReportLiveTask(null);
  private final MobileReportManager.ReportTask mReportTask = new MobileReportManager.ReportTask(null);
  
  public static MobileReportManager getInstance()
  {
    return MobileReportManager.SingletonInstance.access$200();
  }
  
  public static String getNewDefaultReportInfo(String paramString1, String paramString2)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("appid", paramString1);
      localJSONObject.put("page_id", paramString2);
      paramString1 = "&trace_detail=base64-" + awfl.a(localJSONObject.toString());
      return paramString1;
    }
    catch (Exception paramString1)
    {
      QLog.e("MobileReport.Manager", 1, "json exception" + paramString1);
    }
    return "&trace_detail=base64-";
  }
  
  public static String getNewReportInfo(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if (paramAppInfo != null) {
      return String.format("&trace_detail=base64-%s", new Object[] { awfl.a(MobileReportManager.NewReportKey.build(paramAppInfo).buildTraceDetail()) });
    }
    return null;
  }
  
  public static String getNewTraceDetail(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("appid", paramString1);
      localJSONObject.put("page_id", paramString2);
      localJSONObject.put("item_id", paramString3);
      localJSONObject.put("item_type", paramString4);
      paramString1 = "&trace_detail=" + awfl.a(localJSONObject.toString());
      return paramString1;
    }
    catch (Exception paramString1)
    {
      QLog.e("MobileReport.Manager", 1, "json exception " + paramString1);
    }
    return "&trace_detail=";
  }
  
  @NonNull
  public static String getStringQboos2H5(@Nullable String paramString1, @Nullable String paramString2, @NonNull String paramString3)
  {
    if (!TextUtils.isEmpty(paramString2))
    {
      Object localObject = paramString2.split("_");
      if (localObject.length > 2)
      {
        paramString2 = localObject[0];
        String str = localObject[1];
        localObject = localObject[2];
        return paramString3 + "trace_num=1&trace_id=" + paramString1 + "_" + str + "_" + System.currentTimeMillis() + "&trace_detail_adv_pos_id=" + paramString2 + "&trace_detail_adv_id=" + str + "&trace_detail_pattern=" + (String)localObject;
      }
    }
    return "";
  }
  
  @Nullable
  public static String getStringReport2H5(@Nullable BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if (paramAppInfo != null)
    {
      paramAppInfo = MobileReportManager.ReportKey.build(paramAppInfo);
      return String.format("&traceId=%s&traceNum=%s&traceDetail=%s", new Object[] { paramAppInfo.traceId, String.valueOf(paramAppInfo.traceNum), URLEncoder.encode(paramAppInfo.buildTraceDetail()) });
    }
    return null;
  }
  
  public static String getStringWithQbossTrace(String paramString1, String paramString2)
  {
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    StringBuilder localStringBuilder = new StringBuilder().append(paramString1);
    if (paramString1.contains("?")) {}
    for (paramString1 = "&";; paramString1 = "?") {
      return getStringQboos2H5(str, paramString2, paramString1);
    }
  }
  
  public static String getStringWithRedAppinfo(String paramString, BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    String str1 = paramString;
    String str2;
    if (!TextUtils.isEmpty(paramString))
    {
      str2 = "";
      str1 = "";
      if (paramAppInfo != null)
      {
        paramAppInfo = MobileReportManager.ReportKey.build(paramAppInfo);
        str2 = String.format("trace_id=%s&trace_num=%s&trace_detail=%s", new Object[] { paramAppInfo.traceId, String.valueOf(paramAppInfo.traceNum), URLEncoder.encode(paramAppInfo.buildTraceDetail()) });
        if (!paramString.contains("?")) {
          break label98;
        }
      }
    }
    label98:
    for (str1 = "&";; str1 = "?")
    {
      str1 = paramString + str1 + str2;
      return str1;
    }
  }
  
  public void qqSetingMeReport(int paramInt1, int paramInt2, String paramString)
  {
    paramString = new MobileReportManager.ItemInfoBuilder().setItemId("" + paramInt1).setBusiInfo(paramString).setModuleId("1").setItemType("4").addActionInfo(new MobileReportManager.ActionInfoBuilder(System.currentTimeMillis(), paramInt2, 1L).build()).build();
    getInstance().reportActionLive("platform898", "5", paramString);
  }
  
  public void reportAction(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, long paramLong)
  {
    reportAction("", null, paramString1, paramString2, paramString3, paramInt1, paramInt2, paramLong);
  }
  
  public void reportAction(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, long paramLong)
  {
    paramString4 = new MobileReportManager.ReportKey("", 1, "", -1, paramString3, paramString4);
    MobileReportManager.ItemInfoBuilder localItemInfoBuilder = new MobileReportManager.ItemInfoBuilder();
    paramString3 = paramString1;
    if (paramString1 == null) {
      paramString3 = "";
    }
    paramString3 = localItemInfoBuilder.setItemId(paramString3).setModuleId(paramString5).addActionInfo(new MobileReportManager.ActionInfoBuilder(paramLong, paramInt1, paramInt2).build()).build();
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    paramString3.item_type = paramString1;
    if (QLog.isColorLevel())
    {
      if (102 != paramInt1) {
        break label153;
      }
      paramString1 = "ITEM_CLICK";
    }
    for (;;)
    {
      QLog.d("MobileReport.Manager", 2, "report " + paramString4.toString() + " actionId = " + paramString1);
      this.mReportTask.reportByKey(paramString4, paramString3);
      return;
      label153:
      if (101 == paramInt1) {
        paramString1 = "ITEM_EXPORT";
      } else {
        paramString1 = "UNKONW";
      }
    }
  }
  
  public void reportAction(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt1, int paramInt2)
  {
    paramString2 = new MobileReportManager.ReportKey("", 1, "", -1, paramString1, paramString2);
    MobileReportManager.ItemInfoBuilder localItemInfoBuilder = new MobileReportManager.ItemInfoBuilder();
    paramString1 = paramString5;
    if (paramString5 == null) {
      paramString1 = "";
    }
    paramString3 = localItemInfoBuilder.setItemId(paramString1).setModuleId(paramString3).addActionInfo(new MobileReportManager.ActionInfoBuilder(System.currentTimeMillis(), paramInt1, paramInt2).build()).build();
    paramString1 = paramString6;
    if (paramString6 == null) {
      paramString1 = "";
    }
    paramString3.item_type = paramString1;
    paramString1 = paramString4;
    if (paramString4 == null) {
      paramString1 = "";
    }
    paramString3.sub_module_id = paramString1;
    if (QLog.isColorLevel())
    {
      if (102 != paramInt1) {
        break label169;
      }
      paramString1 = "ITEM_CLICK";
    }
    for (;;)
    {
      QLog.d("MobileReport.Manager", 2, "report " + paramString2.toString() + " actionId = " + paramString1);
      this.mReportTask.reportByKey(paramString2, paramString3);
      return;
      label169:
      if (101 == paramInt1) {
        paramString1 = "ITEM_EXPORT";
      } else {
        paramString1 = "UNKONW";
      }
    }
  }
  
  public void reportActionLive(String paramString1, String paramString2, ItemInfo paramItemInfo)
  {
    paramString1 = new MobileReportManager.ReportKey("", 1, "", -1, paramString1, paramString2);
    if (QLog.isColorLevel()) {
      QLog.d("MobileReport.Manager", 2, "report " + paramString1.toString() + " actionId = " + paramItemInfo.toString());
    }
    this.mReportLiveTask.reportByKey(paramString1, paramItemInfo);
  }
  
  public void reportActionLive(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, long paramLong, String paramString6)
  {
    paramString4 = new MobileReportManager.ReportKey("", 1, "", -1, paramString3, paramString4);
    MobileReportManager.ItemInfoBuilder localItemInfoBuilder = new MobileReportManager.ItemInfoBuilder();
    paramString3 = paramString1;
    if (paramString1 == null) {
      paramString3 = "";
    }
    paramString3 = localItemInfoBuilder.setItemId(paramString3).setModuleId(paramString5).setBusiInfo("{\"roomid\":\"" + paramString6 + "\"}").addActionInfo(new MobileReportManager.ActionInfoBuilder(paramLong, paramInt1, paramInt2).build()).build();
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    paramString3.item_type = paramString1;
    if (QLog.isColorLevel())
    {
      if (102 != paramInt1) {
        break label183;
      }
      paramString1 = "ITEM_CLICK";
    }
    for (;;)
    {
      QLog.d("MobileReport.Manager", 2, "report " + paramString4.toString() + " actionId = " + paramString1);
      this.mReportLiveTask.reportByKey(paramString4, paramString3);
      return;
      label183:
      if (101 == paramInt1) {
        paramString1 = "ITEM_EXPORT";
      } else {
        paramString1 = "UNKONW";
      }
    }
  }
  
  public void reportActionOfNotice(String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, int paramInt2)
  {
    paramString2 = new MobileReportManager.ReportKey("", 1, "", -1, paramString1, paramString2);
    paramString3 = new MobileReportManager.ItemInfoBuilder().setItemId(paramString4).setItemType(paramString5).setModuleId(paramString3).addActionInfo(new MobileReportManager.ActionInfoBuilder(System.currentTimeMillis(), paramInt1, paramInt2).build()).build();
    if (QLog.isColorLevel())
    {
      if (102 != paramInt1) {
        break label139;
      }
      paramString1 = "ITEM_CLICK";
    }
    for (;;)
    {
      QLog.d("MobileReport.Manager", 2, "report of notice:    itemId=" + paramString4 + ";" + paramString2.toString() + " actionId = " + paramString1);
      this.mReportTask.reportByKey(paramString2, paramString3);
      return;
      label139:
      if (101 == paramInt1) {
        paramString1 = "ITEM_EXPORT";
      } else if (100 == paramInt1) {
        paramString1 = "PAGE_EXPORT";
      } else {
        paramString1 = "UNKONW";
      }
    }
  }
  
  public void reportH5DomainClick(String paramString1, String paramString2)
  {
    MobileReportManager.ReportKey localReportKey;
    Object localObject;
    if ((!TextUtils.isEmpty(paramString1)) && (paramString1.contains("h5costreport=1")))
    {
      localReportKey = new MobileReportManager.ReportKey("", 0, "", 0, "JumpUrlReport", paramString1);
      localObject = new JSONObject();
    }
    try
    {
      ((JSONObject)localObject).put("jump_url", paramString2);
      String str = blbz.a(paramString1).getString("adId");
      localObject = new MobileReportManager.ItemInfoBuilder().setItemId(String.valueOf(str)).setBusiInfo(((JSONObject)localObject).toString()).addActionInfo(new MobileReportManager.ActionInfoBuilder(System.currentTimeMillis(), 152, 1L).build()).build();
      if (QLog.isColorLevel()) {
        QLog.d("MobileReport.Manager", 2, "report " + localReportKey.toString() + " opType = " + 152 + " url = " + paramString1 + " jumpUrl = " + paramString2);
      }
      this.mReportTask.reportByKey(localReportKey, (ItemInfo)localObject);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("MobileReport.Manager", 2, " report exception " + localException);
      }
    }
  }
  
  public void reportH5Trace(String paramString1, int paramInt1, long paramLong, String paramString2, int paramInt2, String paramString3)
  {
    MobileReportManager.ReportKey localReportKey;
    JSONObject localJSONObject;
    if ((!TextUtils.isEmpty(paramString1)) && (paramString1.contains("h5costreport=1")))
    {
      localReportKey = new MobileReportManager.ReportKey("", 0, "", 0, "H5CostReport", paramString1);
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("coreType", paramInt2);
      localJSONObject.put("coreVersion", paramString3);
      localJSONObject.put("errorcode", paramString2);
      paramString3 = new MobileReportManager.ItemInfoBuilder().setItemId("").setBusiInfo(localJSONObject.toString()).addActionInfo(new MobileReportManager.ActionInfoBuilder(System.currentTimeMillis(), paramInt1, paramLong).build()).build();
      if (QLog.isColorLevel()) {
        QLog.d("MobileReport.Manager", 2, "report " + localReportKey.toString() + " opType = " + paramInt1 + " url = " + paramString1 + " timecost " + paramLong + " errorcode " + paramString2);
      }
      this.mReportTask.reportByKey(localReportKey, paramString3);
      return;
    }
    catch (Exception paramString3)
    {
      for (;;)
      {
        QLog.e("MobileReport.Manager", 2, " report exception " + paramString3);
      }
    }
  }
  
  public void reportRedpoint(@Nullable BusinessInfoCheckUpdate.AppInfo paramAppInfo, int paramInt)
  {
    if (paramAppInfo == null) {
      return;
    }
    MobileReportManager.ReportKey localReportKey = MobileReportManager.ReportKey.build(paramAppInfo);
    ItemInfo localItemInfo = new MobileReportManager.ItemInfoBuilder().setItemId(localReportKey.adId).setBusiInfo(paramAppInfo.buffer.get()).addActionInfo(new MobileReportManager.ActionInfoBuilder(System.currentTimeMillis(), paramInt).build()).build();
    if (QLog.isColorLevel())
    {
      if (102 != paramInt) {
        break label122;
      }
      paramAppInfo = "ITEM_CLICK";
    }
    for (;;)
    {
      QLog.d("MobileReport.Manager", 2, "report " + localReportKey.toString() + " actionId = " + paramAppInfo);
      this.mReportTask.reportByKey(localReportKey, localItemInfo);
      return;
      label122:
      if (101 == paramInt) {
        paramAppInfo = "ITEM_EXPORT";
      } else {
        paramAppInfo = "UNKONW";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.mobilereport.MobileReportManager
 * JD-Core Version:    0.7.0.1
 */