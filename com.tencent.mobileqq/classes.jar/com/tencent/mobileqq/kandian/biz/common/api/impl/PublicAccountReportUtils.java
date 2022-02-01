package com.tencent.mobileqq.kandian.biz.common.api.impl;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetail;
import com.tencent.biz.pubaccount.util.RIJBlackWhiteModeHelper;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.biz.qqstory.utils.NetworkUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.PrivacyPolicyHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.kandian.base.annotation.IgnoreDenyDependencyToSelf;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoReporter;
import com.tencent.mobileqq.kandian.biz.push.RIJKanDianFolderStatus;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.report.ReadInJoySessionManager;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import com.tencent.mobileqq.kandian.repo.common.RIJItemViewTypeUtils;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.RIJStudyModeUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.vip.CUKingCardUtils;
import com.tencent.open.business.base.MobileInfoUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

@IgnoreDenyDependencyToSelf
public class PublicAccountReportUtils
{
  private static final SimpleDateFormat a = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
  
  public static String a(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    try
    {
      paramString = URLEncoder.encode(str, "UTF-8");
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramString.printStackTrace();
    }
    return str;
  }
  
  public static void a(AppInterface paramAppInterface, String paramString, int paramInt)
  {
    int i = ((IPublicAccountDetail)QRoute.api(IPublicAccountDetail.class)).getReportAccountType(paramAppInterface, String.valueOf(paramString));
    if ((i != 2) && (((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getAccountType(paramAppInterface, paramString) != -7))
    {
      paramAppInterface = new StringBuilder();
      paramAppInterface.append("");
      paramAppInterface.append(paramInt);
      paramAppInterface = paramAppInterface.toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(i);
      a(null, paramString, "0X800827B", "0X800827B", 0, 0, paramAppInterface, localStringBuilder.toString(), "", "", false);
    }
  }
  
  public static void a(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    c(paramString3, paramString7);
    paramString7 = b(paramString3, paramString7);
    paramString4 = a(paramString4);
    paramString5 = a(paramString5);
    paramString6 = a(paramString6);
    paramString7 = a(paramString7);
    ReportController.b(paramAppInterface, "dc01160", "Pb_account_lifeservice", paramString1, paramString2.toUpperCase(), paramString3.toUpperCase(), paramInt1, paramInt2, paramString4, paramString5, paramString6, paramString7);
  }
  
  public static void a(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, String paramString5, String paramString6, String paramString7, boolean paramBoolean)
  {
    c(paramString3, paramString7);
    paramString7 = b(paramString3, paramString7);
    if (paramBoolean)
    {
      a(paramAppInterface, paramString1, paramString2, paramString3, paramInt1, paramInt2, paramString4, paramString5, paramString6, paramString7);
      return;
    }
    ReportController.b(paramAppInterface, "dc01160", "Pb_account_lifeservice", paramString1, paramString2.toUpperCase(), paramString3.toUpperCase(), paramInt1, paramInt2, paramString4, paramString5, paramString6, paramString7);
  }
  
  public static void a(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    c(paramString5, paramString9);
    paramString9 = b(paramString5, paramString9);
    paramString6 = a(paramString6);
    paramString7 = a(paramString7);
    paramString8 = a(paramString8);
    paramString9 = a(paramString9);
    ReportController.b(paramAppInterface, paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, paramInt2, paramString6, paramString7, paramString8, paramString9);
    ReportController.b(paramAppInterface, "dc01160", "Pb_account_lifeservice", paramString3, paramString4.toUpperCase(), paramString5.toUpperCase(), paramInt1, paramInt2, paramString6, paramString7, paramString8, paramString9);
  }
  
  public static void a(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, String paramString6, String paramString7, String paramString8, String paramString9, boolean paramBoolean)
  {
    c(paramString5, paramString9);
    paramString9 = b(paramString5, paramString9);
    if (paramBoolean)
    {
      a(paramAppInterface, paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, paramInt2, paramString6, paramString7, paramString8, paramString9);
      return;
    }
    ReportController.b(paramAppInterface, paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, paramInt2, paramString6, paramString7, paramString8, paramString9);
    ReportController.b(paramAppInterface, "dc01160", "Pb_account_lifeservice", paramString3, paramString4.toUpperCase(), paramString5.toUpperCase(), paramInt1, paramInt2, paramString6, paramString7, paramString8, paramString9);
  }
  
  public static void a(Entity paramEntity)
  {
    if (!(paramEntity instanceof AbsBaseArticleInfo)) {
      return;
    }
    AbsBaseArticleInfo localAbsBaseArticleInfo = (AbsBaseArticleInfo)paramEntity;
    Object localObject;
    try
    {
      paramEntity = new JSONObject();
      paramEntity.put("folder_status", RIJKanDianFolderStatus.reportFolderStatus);
      paramEntity.put("feeds_source", RIJFeedsType.k(localAbsBaseArticleInfo));
      paramEntity.put("rowkey", localAbsBaseArticleInfo.innerUniqueID);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(RIJFeedsType.g(localAbsBaseArticleInfo));
      paramEntity.put("feeds_type", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(RIJAppSetting.b());
      paramEntity.put("kandian_mode", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(RIJTransMergeKanDianReport.b());
      paramEntity.put("tab_source", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(localAbsBaseArticleInfo.businessId);
      paramEntity.put("topic_id", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(localAbsBaseArticleInfo.mAlgorithmID);
      paramEntity.put("algorithm_id", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(RIJFeedsType.j(localAbsBaseArticleInfo));
      paramEntity.put("mark_type", ((StringBuilder)localObject).toString());
      paramEntity.put("channel_id", localAbsBaseArticleInfo.mChannelID);
      paramEntity = paramEntity.toString();
    }
    catch (JSONException paramEntity)
    {
      paramEntity.printStackTrace();
      paramEntity = "";
    }
    if ((!RIJItemViewTypeUtils.m(localAbsBaseArticleInfo)) && (!RIJItemViewTypeUtils.l(localAbsBaseArticleInfo)) && (!RIJItemViewTypeUtils.n(localAbsBaseArticleInfo)) && (!RIJItemViewTypeUtils.p(localAbsBaseArticleInfo)))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(localAbsBaseArticleInfo.mArticleID);
      ((StringBuilder)localObject).append("");
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = "0";
    }
    String str1;
    if (ReadinjoyReportUtils.d(localAbsBaseArticleInfo.mChannelID)) {
      str1 = "0X8009362";
    } else {
      str1 = "0X8008201";
    }
    String str2 = RIJFeedsType.k(localAbsBaseArticleInfo);
    long l = localAbsBaseArticleInfo.mFeedId;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(localAbsBaseArticleInfo.mStrategyId);
    a(null, str2, str1, str1, 0, 0, String.valueOf(l), (String)localObject, localStringBuilder.toString(), paramEntity, false);
  }
  
  public static void a(String paramString1, int paramInt, String paramString2)
  {
    QQAppInterface localQQAppInterface;
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    } else {
      localQQAppInterface = null;
    }
    a(localQQAppInterface, "", paramString1, paramString1, paramInt, 0, "", "", "", paramString2, false);
  }
  
  public static void a(String paramString1, String paramString2)
  {
    a(paramString1, 0, paramString2);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("kandian_");
    ((StringBuilder)localObject1).append(paramString1);
    paramString1 = ((StringBuilder)localObject1).toString();
    localObject1 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    Object localObject2 = new HashMap();
    ((HashMap)localObject2).put("department", "publicaccount");
    ((HashMap)localObject2).put("fromuin", localObject1);
    ((HashMap)localObject2).put("touin", paramString2);
    ((HashMap)localObject2).put("d1", paramString3);
    ((HashMap)localObject2).put("d2", paramString4);
    ((HashMap)localObject2).put("d3", paramString5);
    ((HashMap)localObject2).put("d4", paramString6);
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String)localObject1, paramString1, true, 0L, 0L, (HashMap)localObject2, "");
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("kandianT");
      ((StringBuilder)localObject2).append(paramString1);
      ((StringBuilder)localObject2).append(", fromuin:");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(", touin:");
      ((StringBuilder)localObject2).append(paramString2);
      ((StringBuilder)localObject2).append(", d1:");
      ((StringBuilder)localObject2).append(paramString3);
      ((StringBuilder)localObject2).append(", d2:");
      ((StringBuilder)localObject2).append(paramString4);
      ((StringBuilder)localObject2).append(", d3:");
      ((StringBuilder)localObject2).append(paramString5);
      ((StringBuilder)localObject2).append(", d4:");
      ((StringBuilder)localObject2).append(paramString6);
      QLog.d("reportPAinfoToLighthouse", 2, new Object[] { "reportPAinfoToLighthouse-->", ((StringBuilder)localObject2).toString() });
    }
  }
  
  private static void a(String paramString, JSONObject paramJSONObject)
  {
    if (("0X8007625".equals(paramString)) || ("0X8007626".equals(paramString))) {
      try
      {
        paramJSONObject.put("scene_trace_id", ReadInJoySessionManager.a.a());
        paramJSONObject.put("scene_series_num", ReadInJoySessionManager.a.b());
        return;
      }
      catch (JSONException paramString)
      {
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("addSessionInfo error! msg=");
        paramJSONObject.append(paramString);
        QLog.e("PublicAccountReportUtils", 1, paramJSONObject.toString());
      }
    }
  }
  
  public static void a(List<MessageRecord> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() <= 0) {
        return;
      }
      long l = System.currentTimeMillis() / 1000L;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)paramList.next();
        if (localMessageRecord.istroop == 1008) {
          if ((!TextUtils.isEmpty(localMessageRecord.getExtInfoFromExtStr("public_account_send_flag"))) && (!TextUtils.isEmpty(localMessageRecord.getExtInfoFromExtStr("public_account_msg_id"))) && (!TextUtils.equals(localMessageRecord.frienduin, localMessageRecord.selfuin))) {
            ThreadManager.post(new PublicAccountReportUtils.3(localMessageRecord.frienduin, localMessageRecord.selfuin, localMessageRecord.getExtInfoFromExtStr("public_account_msg_id"), localMessageRecord.time, l, localMessageRecord.getExtInfoFromExtStr("public_account_send_flag")), 5, null, false);
          } else if (QLog.isColorLevel()) {
            QLog.d("PublicAccountReportUtils", 2, "reportPubAccMsg exception, public_account_send_flag null || public_account_msg_id null || ");
          }
        }
      }
    }
  }
  
  private static void a(JSONObject paramJSONObject)
  {
    for (;;)
    {
      try
      {
        paramJSONObject.put("version_standard", "8.8.17");
        paramJSONObject.put("version_detail", AppSetting.a(BaseApplicationImpl.getContext()));
        paramJSONObject.put("os_standard", "1");
        paramJSONObject.put("kandian_mode_new", VideoReporter.c());
        paramJSONObject.put("user_mode", RIJStudyModeUtils.d());
        if (RIJBlackWhiteModeHelper.a.a())
        {
          i = 1;
          paramJSONObject.put("is_black_white_mode", i);
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("addCommonInfo error! msg=");
        localStringBuilder.append(paramJSONObject);
        QLog.e("PublicAccountReportUtils", 1, localStringBuilder.toString());
        return;
      }
      int i = 0;
    }
  }
  
  private static boolean a()
  {
    Object localObject = BaseApplicationImpl.getApplication();
    if (localObject != null)
    {
      localObject = ((BaseApplicationImpl)localObject).getRuntime();
      if (localObject != null) {
        return ((AppRuntime)localObject).isLogin();
      }
    }
    return false;
  }
  
  protected static String b(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return paramString2;
    }
    try
    {
      localObject = new JSONObject(paramString2);
      a((JSONObject)localObject);
      b((JSONObject)localObject);
      d((JSONObject)localObject);
      c((JSONObject)localObject);
      a(paramString1, (JSONObject)localObject);
      paramString1 = ((JSONObject)localObject).toString();
      return paramString1;
    }
    catch (Exception paramString1)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("addExtraInfo error! msg=");
      ((StringBuilder)localObject).append(paramString1);
      QLog.e("PublicAccountReportUtils", 1, ((StringBuilder)localObject).toString());
    }
    return paramString2;
  }
  
  public static void b(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, String paramString5, String paramString6, String paramString7, boolean paramBoolean)
  {
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface))
    {
      c(paramAppInterface, paramString1, paramString2, paramString3, paramInt1, paramInt2, paramString4, paramString5, paramString6, paramString7, paramBoolean);
      return;
    }
    paramAppInterface = new Intent("READINJOY_VIDEO_DATA_REPORT_WITH_FANS_INFO");
    paramAppInterface.putExtra("VIDEO_REPORT_TOUIN", paramString1);
    paramAppInterface.putExtra("VIDEO_REPORT_SUBACTION", paramString2);
    paramAppInterface.putExtra("VIDEO_REPORT_ACTION_NAME", paramString3);
    paramAppInterface.putExtra("VIDEO_REPORT_FROM_TYPE", paramInt1);
    paramAppInterface.putExtra("VIDEO_REPORT_RESULT", paramInt2);
    paramAppInterface.putExtra("VIDEO_REPORT_R2", paramString4);
    paramAppInterface.putExtra("VIDEO_REPORT_R3", paramString5);
    paramAppInterface.putExtra("VIDEO_REPORT_R4", paramString6);
    paramAppInterface.putExtra("VIDEO_REPORT_R5", paramString7);
    paramAppInterface.putExtra("VIDEO_REPORT_SHOULD_ENCODE", paramBoolean);
    BaseApplicationImpl.getApplication().sendBroadcast(paramAppInterface);
  }
  
  private static void b(JSONObject paramJSONObject)
  {
    try
    {
      if (a())
      {
        if (!PrivacyPolicyHelper.d()) {
          return;
        }
        paramJSONObject.put("wifi_ssid", NetworkUtils.e(BaseApplicationImpl.getContext()));
        paramJSONObject.put("wifi_mac", MobileInfoUtil.getLocalMacAddress());
        return;
      }
      return;
    }
    catch (Exception paramJSONObject)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("addWifiInfo error! msg=");
      localStringBuilder.append(paramJSONObject);
      QLog.e("PublicAccountReportUtils", 1, localStringBuilder.toString());
    }
  }
  
  public static void c(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, String paramString5, String paramString6, String paramString7, boolean paramBoolean)
  {
    ThreadManager.post(new PublicAccountReportUtils.1(paramString7, paramString1, paramAppInterface, paramString2, paramString3, paramInt1, paramInt2, paramString4, paramString5, paramString6, paramBoolean), 5, null, true);
  }
  
  private static void c(String paramString1, String paramString2)
  {
    if ("0X8007625".equals(paramString1)) {
      ThreadManager.executeOnSubThread(new PublicAccountReportUtils.2(paramString2));
    }
  }
  
  private static void c(JSONObject paramJSONObject)
  {
    for (;;)
    {
      try
      {
        if (CUKingCardUtils.a() == 1)
        {
          localObject = "1";
          paramJSONObject.put("is_kind_card", localObject);
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("addKingCard error! msg=");
        ((StringBuilder)localObject).append(paramJSONObject);
        QLog.e("PublicAccountReportUtils", 1, ((StringBuilder)localObject).toString());
        return;
      }
      Object localObject = "0";
    }
  }
  
  private static void d(JSONObject paramJSONObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils
 * JD-Core Version:    0.7.0.1
 */