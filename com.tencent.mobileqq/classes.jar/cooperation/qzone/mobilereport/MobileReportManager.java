package cooperation.qzone.mobilereport;

import NS_USER_ACTION_REPORT.ItemInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.musicpendant.Base64;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.utils.Tools;
import java.net.URLEncoder;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class MobileReportManager
{
  private static final String TAG = "MobileReport.Manager";
  public static final String sTraceKey = "h5costreport=1";
  private final ReportActionInfoTask mReportActionInfoTask = new ReportActionInfoTask();
  private final ReportLiveHeartTask mReportLiveHeartTask = new ReportLiveHeartTask();
  private final ReportLiveTask mReportLiveTask = new ReportLiveTask();
  private final ReportSchemaInfoTask mReportSchemaLiveTask = new ReportSchemaInfoTask();
  
  public static MobileReportManager getInstance()
  {
    return MobileReportManager.SingletonInstance.access$000();
  }
  
  public static String getNewDefaultReportInfo(String paramString1, String paramString2)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("appid", paramString1);
      localJSONObject.put("page_id", paramString2);
      paramString1 = new StringBuilder();
      paramString1.append("&trace_detail=base64-");
      paramString1.append(Base64.a(localJSONObject.toString()));
      paramString1 = paramString1.toString();
      return paramString1;
    }
    catch (Exception paramString1)
    {
      paramString2 = new StringBuilder();
      paramString2.append("json exception");
      paramString2.append(paramString1);
      QLog.e("MobileReport.Manager", 1, paramString2.toString());
    }
    return "&trace_detail=base64-";
  }
  
  public static String getNewDefaultReportInfo(String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return null;
    }
    JSONObject localJSONObject = new JSONObject();
    if (paramString1.contains("?")) {
      paramString1 = "&trace_detail=base64-";
    } else {
      paramString1 = "?trace_detail=base64-";
    }
    try
    {
      localJSONObject.put("appid", paramString2);
      localJSONObject.put("page_id", paramString3);
      paramString2 = new StringBuilder();
      paramString2.append(paramString1);
      paramString2.append(Base64.a(localJSONObject.toString()));
      paramString2 = paramString2.toString();
      return paramString2;
    }
    catch (Exception paramString2)
    {
      paramString3 = new StringBuilder();
      paramString3.append("json exception");
      paramString3.append(paramString2);
      QLog.e("MobileReport.Manager", 1, paramString3.toString());
    }
    return paramString1;
  }
  
  public static String getNewReportInfo(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if (paramAppInfo != null) {
      return String.format("&trace_detail=base64-%s", new Object[] { Base64.a(MobileReportManager.NewReportKey.build(paramAppInfo).buildTraceDetail()) });
    }
    return null;
  }
  
  public static String getNewReportInfo(String paramString, BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if ((paramAppInfo != null) && (!TextUtils.isEmpty(paramString)))
    {
      paramAppInfo = MobileReportManager.NewReportKey.build(paramAppInfo);
      if (paramString.contains("?")) {
        return String.format("&trace_detail=base64-%s", new Object[] { Base64.a(paramAppInfo.buildTraceDetail()) });
      }
      return String.format("?trace_detail=base64-%s", new Object[] { Base64.a(paramAppInfo.buildTraceDetail()) });
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
      paramString1 = new StringBuilder();
      paramString1.append("&trace_detail=");
      paramString1.append(Base64.a(localJSONObject.toString()));
      paramString1 = paramString1.toString();
      return paramString1;
    }
    catch (Exception paramString1)
    {
      paramString2 = new StringBuilder();
      paramString2.append("json exception ");
      paramString2.append(paramString1);
      QLog.e("MobileReport.Manager", 1, paramString2.toString());
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
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString3);
        localStringBuilder.append("trace_num=1&trace_id=");
        localStringBuilder.append(paramString1);
        localStringBuilder.append("_");
        localStringBuilder.append(str);
        localStringBuilder.append("_");
        localStringBuilder.append(System.currentTimeMillis());
        localStringBuilder.append("&trace_detail_adv_pos_id=");
        localStringBuilder.append(paramString2);
        localStringBuilder.append("&trace_detail_adv_id=");
        localStringBuilder.append(str);
        localStringBuilder.append("&trace_detail_pattern=");
        localStringBuilder.append((String)localObject);
        return localStringBuilder.toString();
      }
    }
    return "";
  }
  
  @Nullable
  public static String getStringReport2H5(@Nullable BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if (paramAppInfo != null)
    {
      paramAppInfo = ReportKey.build(paramAppInfo);
      return String.format("&traceId=%s&traceNum=%s&traceDetail=%s", new Object[] { paramAppInfo.traceId, String.valueOf(paramAppInfo.traceNum), URLEncoder.encode(paramAppInfo.buildTraceDetail()) });
    }
    return null;
  }
  
  public static String getStringWithQbossTrace(String paramString1, String paramString2)
  {
    String str2 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    String str1 = "?";
    if (paramString1.contains("?")) {
      str1 = "&";
    }
    localStringBuilder.append(getStringQboos2H5(str2, paramString2, str1));
    return localStringBuilder.toString();
  }
  
  public static String getStringWithRedAppinfo(String paramString, BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    Object localObject1 = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      localObject1 = "";
      if (paramAppInfo != null)
      {
        paramAppInfo = ReportKey.build(paramAppInfo);
        localObject2 = String.format("trace_id=%s&trace_num=%s&trace_detail=%s", new Object[] { paramAppInfo.traceId, String.valueOf(paramAppInfo.traceNum), URLEncoder.encode(paramAppInfo.buildTraceDetail()) });
        paramAppInfo = "?";
        localObject1 = localObject2;
        if (paramString.contains("?"))
        {
          paramAppInfo = "&";
          localObject1 = localObject2;
        }
      }
      else
      {
        paramAppInfo = "";
      }
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append(paramAppInfo);
      ((StringBuilder)localObject2).append((String)localObject1);
      localObject1 = ((StringBuilder)localObject2).toString();
    }
    return localObject1;
  }
  
  public void qqSetingMeReport(int paramInt1, int paramInt2, String paramString)
  {
    ReportKey localReportKey = new ReportKey("", 1, "", -1, "platform898", "5");
    Object localObject = new MobileReportManager.ItemInfoBuilder();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramInt1);
    paramString = ((MobileReportManager.ItemInfoBuilder)localObject).setItemId(localStringBuilder.toString()).setBusiInfo(paramString).setModuleId("1").setItemType("4").addActionInfo(new MobileReportManager.ActionInfoBuilder(System.currentTimeMillis(), paramInt2, 1L).build()).build();
    getInstance().reportActionLive("platform898", "5", paramString);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("report ");
      ((StringBuilder)localObject).append(localReportKey.toString());
      ((StringBuilder)localObject).append(" actionId = ");
      ((StringBuilder)localObject).append(paramString.toString());
      QLog.d("MobileReport.Manager", 2, ((StringBuilder)localObject).toString());
    }
    this.mReportActionInfoTask.reportByKey(localReportKey, paramString);
  }
  
  public void reportAction(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, long paramLong)
  {
    reportAction("", null, paramString1, paramString2, paramString3, paramInt1, paramInt2, paramLong);
  }
  
  public void reportAction(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, long paramLong)
  {
    reportAction(paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, paramInt2, paramLong, "");
  }
  
  public void reportAction(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, long paramLong, String paramString6)
  {
    paramString4 = new ReportKey("", 1, "", -1, paramString3, paramString4);
    MobileReportManager.ItemInfoBuilder localItemInfoBuilder = new MobileReportManager.ItemInfoBuilder();
    paramString3 = "";
    if (paramString1 == null) {
      paramString1 = "";
    }
    paramString5 = localItemInfoBuilder.setItemId(paramString1).setModuleId(paramString5).addActionInfo(new MobileReportManager.ActionInfoBuilder(paramLong, paramInt1, paramInt2).build()).setBusiInfo(paramString6).build();
    if (paramString2 == null) {
      paramString2 = paramString3;
    }
    paramString5.item_type = paramString2;
    if (QLog.isColorLevel())
    {
      if (102 == paramInt1) {
        paramString1 = "ITEM_CLICK";
      } else if (101 == paramInt1) {
        paramString1 = "ITEM_EXPORT";
      } else {
        paramString1 = "UNKONW";
      }
      paramString2 = new StringBuilder();
      paramString2.append("report ");
      paramString2.append(paramString4.toString());
      paramString2.append(" actionId = ");
      paramString2.append(paramString1);
      QLog.d("MobileReport.Manager", 2, paramString2.toString());
    }
    this.mReportActionInfoTask.reportByKey(paramString4, paramString5);
  }
  
  public void reportAction(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt1, int paramInt2)
  {
    paramString2 = new ReportKey("", 1, "", -1, paramString1, paramString2);
    MobileReportManager.ItemInfoBuilder localItemInfoBuilder = new MobileReportManager.ItemInfoBuilder();
    paramString1 = "";
    if (paramString5 == null) {
      paramString5 = "";
    }
    paramString3 = localItemInfoBuilder.setItemId(paramString5).setModuleId(paramString3).addActionInfo(new MobileReportManager.ActionInfoBuilder(System.currentTimeMillis(), paramInt1, paramInt2).build()).build();
    if (paramString6 == null) {
      paramString6 = "";
    }
    paramString3.item_type = paramString6;
    if (paramString4 == null) {
      paramString4 = paramString1;
    }
    paramString3.sub_module_id = paramString4;
    if (QLog.isColorLevel())
    {
      if (102 == paramInt1) {
        paramString1 = "ITEM_CLICK";
      } else if (101 == paramInt1) {
        paramString1 = "ITEM_EXPORT";
      } else {
        paramString1 = "UNKONW";
      }
      paramString4 = new StringBuilder();
      paramString4.append("report ");
      paramString4.append(paramString2.toString());
      paramString4.append(" actionId = ");
      paramString4.append(paramString1);
      QLog.d("MobileReport.Manager", 2, paramString4.toString());
    }
    this.mReportActionInfoTask.reportByKey(paramString2, paramString3);
  }
  
  public void reportActionLive(String paramString1, String paramString2, ItemInfo paramItemInfo)
  {
    paramString1 = new ReportKey("", 1, "", -1, paramString1, paramString2);
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("report ");
      paramString2.append(paramString1.toString());
      paramString2.append(" actionId = ");
      paramString2.append(paramItemInfo.toString());
      QLog.d("MobileReport.Manager", 2, paramString2.toString());
    }
    this.mReportLiveTask.reportByKey(paramString1, paramItemInfo);
  }
  
  public void reportActionLive(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, long paramLong, String paramString6)
  {
    paramString4 = new ReportKey("", 1, "", -1, paramString3, paramString4);
    MobileReportManager.ItemInfoBuilder localItemInfoBuilder = new MobileReportManager.ItemInfoBuilder();
    paramString3 = "";
    if (paramString1 == null) {
      paramString1 = "";
    }
    paramString1 = localItemInfoBuilder.setItemId(paramString1).setModuleId(paramString5);
    paramString5 = new StringBuilder();
    paramString5.append("{\"roomid\":\"");
    paramString5.append(paramString6);
    paramString5.append("\"}");
    paramString5 = paramString1.setBusiInfo(paramString5.toString()).addActionInfo(new MobileReportManager.ActionInfoBuilder(paramLong, paramInt1, paramInt2).build()).build();
    if (paramString2 == null) {
      paramString2 = paramString3;
    }
    paramString5.item_type = paramString2;
    if (QLog.isColorLevel())
    {
      if (102 == paramInt1) {
        paramString1 = "ITEM_CLICK";
      } else if (101 == paramInt1) {
        paramString1 = "ITEM_EXPORT";
      } else {
        paramString1 = "UNKONW";
      }
      paramString2 = new StringBuilder();
      paramString2.append("report ");
      paramString2.append(paramString4.toString());
      paramString2.append(" actionId = ");
      paramString2.append(paramString1);
      QLog.d("MobileReport.Manager", 2, paramString2.toString());
    }
    this.mReportLiveTask.reportByKey(paramString4, paramString5);
  }
  
  public void reportActionLiveHeart(String paramString1, String paramString2, ItemInfo paramItemInfo)
  {
    paramString1 = new ReportKey("", 1, "", -1, paramString1, paramString2);
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("report ");
      paramString2.append(paramString1.toString());
      paramString2.append(" actionId = ");
      paramString2.append(paramItemInfo.toString());
      QLog.d("MobileReport.Manager", 2, paramString2.toString());
    }
    this.mReportLiveHeartTask.reportByKey(paramString1, paramItemInfo);
  }
  
  public void reportActionOfNotice(String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, int paramInt2)
  {
    paramString2 = new ReportKey("", 1, "", -1, paramString1, paramString2);
    paramString3 = new MobileReportManager.ItemInfoBuilder().setItemId(paramString4).setItemType(paramString5).setModuleId(paramString3).addActionInfo(new MobileReportManager.ActionInfoBuilder(System.currentTimeMillis(), paramInt1, paramInt2).build()).build();
    if (QLog.isColorLevel())
    {
      if (102 == paramInt1) {
        paramString1 = "ITEM_CLICK";
      } else if (101 == paramInt1) {
        paramString1 = "ITEM_EXPORT";
      } else if (100 == paramInt1) {
        paramString1 = "PAGE_EXPORT";
      } else {
        paramString1 = "UNKONW";
      }
      paramString5 = new StringBuilder();
      paramString5.append("report of notice:    itemId=");
      paramString5.append(paramString4);
      paramString5.append(";");
      paramString5.append(paramString2.toString());
      paramString5.append(" actionId = ");
      paramString5.append(paramString1);
      QLog.d("MobileReport.Manager", 2, paramString5.toString());
    }
    this.mReportActionInfoTask.reportByKey(paramString2, paramString3);
  }
  
  public void reportH5DomainClick(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (paramString1.contains("h5costreport=1")))
    {
      ReportKey localReportKey = new ReportKey("", 0, "", 0, "JumpUrlReport", paramString1);
      Object localObject1 = new JSONObject();
      try
      {
        ((JSONObject)localObject1).put("jump_url", paramString2);
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(" report exception ");
        localStringBuilder.append(localException);
        QLog.e("MobileReport.Manager", 2, localStringBuilder.toString());
      }
      Object localObject2 = Tools.a(paramString1).getString("adId");
      localObject1 = new MobileReportManager.ItemInfoBuilder().setItemId(String.valueOf(localObject2)).setBusiInfo(((JSONObject)localObject1).toString()).addActionInfo(new MobileReportManager.ActionInfoBuilder(System.currentTimeMillis(), 152, 1L).build()).build();
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("report ");
        ((StringBuilder)localObject2).append(localReportKey.toString());
        ((StringBuilder)localObject2).append(" opType = ");
        ((StringBuilder)localObject2).append(152);
        ((StringBuilder)localObject2).append(" url = ");
        ((StringBuilder)localObject2).append(paramString1);
        ((StringBuilder)localObject2).append(" jumpUrl = ");
        ((StringBuilder)localObject2).append(paramString2);
        QLog.d("MobileReport.Manager", 2, ((StringBuilder)localObject2).toString());
      }
      this.mReportActionInfoTask.reportByKey(localReportKey, (ItemInfo)localObject1);
    }
  }
  
  public void reportH5Trace(String paramString1, int paramInt1, long paramLong, String paramString2, int paramInt2, String paramString3)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (paramString1.contains("h5costreport=1")))
    {
      ReportKey localReportKey = new ReportKey("", 0, "", 0, "H5CostReport", paramString1);
      Object localObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("coreType", paramInt2);
        ((JSONObject)localObject).put("coreVersion", paramString3);
        ((JSONObject)localObject).put("errorcode", paramString2);
      }
      catch (Exception paramString3)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(" report exception ");
        localStringBuilder.append(paramString3);
        QLog.e("MobileReport.Manager", 2, localStringBuilder.toString());
      }
      paramString3 = new MobileReportManager.ItemInfoBuilder().setItemId("").setBusiInfo(((JSONObject)localObject).toString()).addActionInfo(new MobileReportManager.ActionInfoBuilder(System.currentTimeMillis(), paramInt1, paramLong).build()).build();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("report ");
        ((StringBuilder)localObject).append(localReportKey.toString());
        ((StringBuilder)localObject).append(" opType = ");
        ((StringBuilder)localObject).append(paramInt1);
        ((StringBuilder)localObject).append(" url = ");
        ((StringBuilder)localObject).append(paramString1);
        ((StringBuilder)localObject).append(" timecost ");
        ((StringBuilder)localObject).append(paramLong);
        ((StringBuilder)localObject).append(" errorcode ");
        ((StringBuilder)localObject).append(paramString2);
        QLog.d("MobileReport.Manager", 2, ((StringBuilder)localObject).toString());
      }
      this.mReportActionInfoTask.reportByKey(localReportKey, paramString3);
      return;
    }
  }
  
  public void reportRedpoint(@Nullable BusinessInfoCheckUpdate.AppInfo paramAppInfo, int paramInt)
  {
    if (paramAppInfo == null) {
      return;
    }
    ReportKey localReportKey = ReportKey.build(paramAppInfo);
    ItemInfo localItemInfo = new MobileReportManager.ItemInfoBuilder().setItemId(localReportKey.adId).setBusiInfo(paramAppInfo.buffer.get()).addActionInfo(new MobileReportManager.ActionInfoBuilder(System.currentTimeMillis(), paramInt).build()).build();
    if (QLog.isColorLevel())
    {
      if (102 == paramInt) {
        paramAppInfo = "ITEM_CLICK";
      } else if (101 == paramInt) {
        paramAppInfo = "ITEM_EXPORT";
      } else {
        paramAppInfo = "UNKONW";
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("report ");
      localStringBuilder.append(localReportKey.toString());
      localStringBuilder.append(" actionId = ");
      localStringBuilder.append(paramAppInfo);
      QLog.d("MobileReport.Manager", 2, localStringBuilder.toString());
    }
    this.mReportActionInfoTask.reportByKey(localReportKey, localItemInfo);
  }
  
  public void reportSchemaInfo(String paramString1, String paramString2)
  {
    ReportKey localReportKey = new ReportKey(paramString1, paramString2);
    ItemInfo localItemInfo = new MobileReportManager.ItemInfoBuilder().build();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reportSchemaInfo ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" schemaUrl ");
      localStringBuilder.append(paramString2);
      QLog.e("MobileReport.Manager", 1, localStringBuilder.toString());
    }
    ThreadManager.getSubThreadHandler().post(new MobileReportManager.1(this, localReportKey, localItemInfo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.mobilereport.MobileReportManager
 * JD-Core Version:    0.7.0.1
 */