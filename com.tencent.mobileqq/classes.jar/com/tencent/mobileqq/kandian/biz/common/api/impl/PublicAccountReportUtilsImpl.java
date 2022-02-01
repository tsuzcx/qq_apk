package com.tencent.mobileqq.kandian.biz.common.api.impl;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetail;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.biz.qqstory.utils.NetworkUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.PrivacyPolicyHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IRIJBlackWhiteModeHelper;
import com.tencent.mobileqq.kandian.biz.common.api.IRIJStudyModeUtils;
import com.tencent.mobileqq.kandian.biz.feeds.api.IRIJKanDianFolderStatus;
import com.tencent.mobileqq.kandian.biz.framework.api.IRIJAppSetting;
import com.tencent.mobileqq.kandian.biz.framework.api.IRIJFeedsType;
import com.tencent.mobileqq.kandian.biz.framework.api.IRIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoReporter;
import com.tencent.mobileqq.kandian.glue.report.api.IReadInJoyReportUtils;
import com.tencent.mobileqq.kandian.glue.report.api.IReadInJoySessionManager;
import com.tencent.mobileqq.kandian.repo.common.api.IRIJItemViewTypeUtils;
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

public class PublicAccountReportUtilsImpl
  implements IPublicAccountReportUtils
{
  private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
  public static final String TAG = "PublicAccountReportUtils";
  
  private static void addCommonInfo(JSONObject paramJSONObject)
  {
    for (;;)
    {
      try
      {
        paramJSONObject.put("version_standard", "8.7.0");
        paramJSONObject.put("version_detail", AppSetting.a(BaseApplicationImpl.getContext()));
        paramJSONObject.put("os_standard", "1");
        paramJSONObject.put("kandian_mode_new", ((IVideoReporter)QRoute.api(IVideoReporter.class)).getKandianModel4Report());
        paramJSONObject.put("user_mode", ((IRIJStudyModeUtils)QRoute.api(IRIJStudyModeUtils.class)).getUserMode());
        if (((IRIJBlackWhiteModeHelper)QRoute.api(IRIJBlackWhiteModeHelper.class)).getBlackWhiteConfig())
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
  
  private static void addDebugInfo(JSONObject paramJSONObject) {}
  
  protected static String addExtraInfo(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return paramString2;
    }
    try
    {
      localObject = new JSONObject(paramString2);
      addCommonInfo((JSONObject)localObject);
      addPrivacyPolicyInfo((JSONObject)localObject);
      addDebugInfo((JSONObject)localObject);
      addKingCard((JSONObject)localObject);
      addSessionInfo(paramString1, (JSONObject)localObject);
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
  
  private static void addKingCard(JSONObject paramJSONObject)
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
  
  private static void addMonitorForReport(String paramString1, String paramString2)
  {
    if ("0X8007625".equals(paramString1)) {
      ThreadManager.executeOnSubThread(new PublicAccountReportUtilsImpl.2(paramString2));
    }
  }
  
  private static void addPrivacyPolicyInfo(JSONObject paramJSONObject)
  {
    try
    {
      if (isLogin())
      {
        if (!PrivacyPolicyHelper.a()) {
          return;
        }
        paramJSONObject.put("wifi_ssid", NetworkUtils.c(BaseApplicationImpl.getContext()));
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
  
  private static void addSessionInfo(String paramString, JSONObject paramJSONObject)
  {
    if (("0X8007625".equals(paramString)) || ("0X8007626".equals(paramString))) {
      try
      {
        paramJSONObject.put("scene_trace_id", ((IReadInJoySessionManager)QRoute.api(IReadInJoySessionManager.class)).getSceneTraceID());
        paramJSONObject.put("scene_series_num", ((IReadInJoySessionManager)QRoute.api(IReadInJoySessionManager.class)).getSceneSeriesNum());
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
  
  private static boolean isLogin()
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
  
  private static String reportClickInfoString(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    StringBuilder localStringBuilder = new StringBuilder(64);
    if ((paramString1 != null) && (paramString1.length() > 0))
    {
      localStringBuilder.append(paramString1);
      localStringBuilder.append('|');
    }
    localStringBuilder.append(paramString2);
    localStringBuilder.append('|');
    localStringBuilder.append(paramString3);
    localStringBuilder.append('|');
    localStringBuilder.append(paramString4);
    localStringBuilder.append('|');
    localStringBuilder.append(paramString5);
    localStringBuilder.append('|');
    localStringBuilder.append(paramString6);
    localStringBuilder.append('|');
    return localStringBuilder.toString();
  }
  
  public String changeToUTF8(String paramString)
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
  
  public void doVideoDataReportWithFansInfoInR5(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, String paramString5, String paramString6, String paramString7, boolean paramBoolean)
  {
    ThreadManager.post(new PublicAccountReportUtilsImpl.1(this, paramString7, paramString1, paramAppInterface, paramString2, paramString3, paramInt1, paramInt2, paramString4, paramString5, paramString6, paramBoolean), 5, null, true);
  }
  
  public void publicAccountReportClickEvent(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    addMonitorForReport(paramString3, paramString7);
    paramString7 = addExtraInfo(paramString3, paramString7);
    paramString4 = changeToUTF8(paramString4);
    paramString5 = changeToUTF8(paramString5);
    paramString6 = changeToUTF8(paramString6);
    paramString7 = changeToUTF8(paramString7);
    ReportController.b(paramAppInterface, "dc01160", "Pb_account_lifeservice", paramString1, paramString2.toUpperCase(), paramString3.toUpperCase(), paramInt1, paramInt2, paramString4, paramString5, paramString6, paramString7);
  }
  
  public void publicAccountReportClickEvent(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, String paramString5, String paramString6, String paramString7, boolean paramBoolean)
  {
    addMonitorForReport(paramString3, paramString7);
    paramString7 = addExtraInfo(paramString3, paramString7);
    if (paramBoolean)
    {
      publicAccountReportClickEvent(paramAppInterface, paramString1, paramString2, paramString3, paramInt1, paramInt2, paramString4, paramString5, paramString6, paramString7);
      return;
    }
    ReportController.b(paramAppInterface, "dc01160", "Pb_account_lifeservice", paramString1, paramString2.toUpperCase(), paramString3.toUpperCase(), paramInt1, paramInt2, paramString4, paramString5, paramString6, paramString7);
  }
  
  public void publicAccountReportClickEventForMigrate(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    addMonitorForReport(paramString5, paramString9);
    paramString9 = addExtraInfo(paramString5, paramString9);
    paramString6 = changeToUTF8(paramString6);
    paramString7 = changeToUTF8(paramString7);
    paramString8 = changeToUTF8(paramString8);
    paramString9 = changeToUTF8(paramString9);
    ReportController.b(paramAppInterface, paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, paramInt2, paramString6, paramString7, paramString8, paramString9);
    ReportController.b(paramAppInterface, "dc01160", "Pb_account_lifeservice", paramString3, paramString4.toUpperCase(), paramString5.toUpperCase(), paramInt1, paramInt2, paramString6, paramString7, paramString8, paramString9);
  }
  
  public void publicAccountReportClickEventForMigrate(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, String paramString6, String paramString7, String paramString8, String paramString9, boolean paramBoolean)
  {
    addMonitorForReport(paramString5, paramString9);
    paramString9 = addExtraInfo(paramString5, paramString9);
    if (paramBoolean)
    {
      publicAccountReportClickEventForMigrate(paramAppInterface, paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, paramInt2, paramString6, paramString7, paramString8, paramString9);
      return;
    }
    ReportController.b(paramAppInterface, paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, paramInt2, paramString6, paramString7, paramString8, paramString9);
    ReportController.b(paramAppInterface, "dc01160", "Pb_account_lifeservice", paramString3, paramString4.toUpperCase(), paramString5.toUpperCase(), paramInt1, paramInt2, paramString6, paramString7, paramString8, paramString9);
  }
  
  public void publicAccountSimpleReportWithR5(String paramString1, int paramInt, String paramString2)
  {
    QQAppInterface localQQAppInterface;
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    } else {
      localQQAppInterface = null;
    }
    publicAccountReportClickEvent(localQQAppInterface, "", paramString1, paramString1, paramInt, 0, "", "", "", paramString2, false);
  }
  
  public void publicAccountSimpleReportWithR5(String paramString1, String paramString2)
  {
    publicAccountSimpleReportWithR5(paramString1, 0, paramString2);
  }
  
  public void reportFollowEvent(AppInterface paramAppInterface, String paramString, int paramInt)
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
      publicAccountReportClickEvent(null, paramString, "0X800827B", "0X800827B", 0, 0, paramAppInterface, localStringBuilder.toString(), "", "", false);
    }
  }
  
  public void reportLabelsClick(Entity paramEntity)
  {
    if (!(paramEntity instanceof AbsBaseArticleInfo)) {
      return;
    }
    AbsBaseArticleInfo localAbsBaseArticleInfo = (AbsBaseArticleInfo)paramEntity;
    Object localObject;
    try
    {
      paramEntity = new JSONObject();
      paramEntity.put("folder_status", ((IRIJKanDianFolderStatus)QRoute.api(IRIJKanDianFolderStatus.class)).getReportFolderStatus());
      paramEntity.put("feeds_source", ((IRIJFeedsType)QRoute.api(IRIJFeedsType.class)).getSpecialFeedsSource(localAbsBaseArticleInfo));
      paramEntity.put("rowkey", localAbsBaseArticleInfo.innerUniqueID);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(((IRIJFeedsType)QRoute.api(IRIJFeedsType.class)).checkArticleType(localAbsBaseArticleInfo));
      paramEntity.put("feeds_type", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(((IRIJAppSetting)QRoute.api(IRIJAppSetting.class)).getKanDianMode());
      paramEntity.put("kandian_mode", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(((IRIJTransMergeKanDianReport)QRoute.api(IRIJTransMergeKanDianReport.class)).getKandianTabSource());
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
      ((StringBuilder)localObject).append(((IRIJFeedsType)QRoute.api(IRIJFeedsType.class)).getMarkType(localAbsBaseArticleInfo));
      paramEntity.put("mark_type", ((StringBuilder)localObject).toString());
      paramEntity.put("channel_id", localAbsBaseArticleInfo.mChannelID);
      paramEntity = paramEntity.toString();
    }
    catch (JSONException paramEntity)
    {
      paramEntity.printStackTrace();
      paramEntity = "";
    }
    if ((!((IRIJItemViewTypeUtils)QRoute.api(IRIJItemViewTypeUtils.class)).isUGC(localAbsBaseArticleInfo)) && (!((IRIJItemViewTypeUtils)QRoute.api(IRIJItemViewTypeUtils.class)).isUGCSocial(localAbsBaseArticleInfo)) && (!((IRIJItemViewTypeUtils)QRoute.api(IRIJItemViewTypeUtils.class)).isUGCRecommendTopic(localAbsBaseArticleInfo)) && (!((IRIJItemViewTypeUtils)QRoute.api(IRIJItemViewTypeUtils.class)).isUGCRecommendTopicSocial(localAbsBaseArticleInfo)))
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
    if (((IReadInJoyReportUtils)QRoute.api(IReadInJoyReportUtils.class)).isKanDianSubscribe(localAbsBaseArticleInfo.mChannelID)) {
      str1 = "0X8009362";
    } else {
      str1 = "0X8008201";
    }
    String str2 = ((IRIJFeedsType)QRoute.api(IRIJFeedsType.class)).getSpecialFeedsSource(localAbsBaseArticleInfo);
    long l = localAbsBaseArticleInfo.mFeedId;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(localAbsBaseArticleInfo.mStrategyId);
    publicAccountReportClickEvent(null, str2, str1, str1, 0, 0, String.valueOf(l), (String)localObject, localStringBuilder.toString(), paramEntity, false);
  }
  
  public void reportPAinfoToLighthouse(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
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
  
  public void reportPubAccMsg(List<MessageRecord> paramList)
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
            ThreadManager.post(new PublicAccountReportUtilsImpl.3(this, localMessageRecord.frienduin, localMessageRecord.selfuin, localMessageRecord.getExtInfoFromExtStr("public_account_msg_id"), localMessageRecord.time, l, localMessageRecord.getExtInfoFromExtStr("public_account_send_flag")), 5, null, false);
          } else if (QLog.isColorLevel()) {
            QLog.d("PublicAccountReportUtils", 2, "reportPubAccMsg exception, public_account_send_flag null || public_account_msg_id null || ");
          }
        }
      }
    }
  }
  
  public void videoDataReportWithFansInfoInR5(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, String paramString5, String paramString6, String paramString7, boolean paramBoolean)
  {
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface))
    {
      doVideoDataReportWithFansInfoInR5(paramAppInterface, paramString1, paramString2, paramString3, paramInt1, paramInt2, paramString4, paramString5, paramString6, paramString7, paramBoolean);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtilsImpl
 * JD-Core Version:    0.7.0.1
 */