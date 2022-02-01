package com.tencent.mobileqq.kandian.glue.report;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.recent.data.RecentItemChatMsgData;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IRIJXTabFrameUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoySPEventReport;
import com.tencent.mobileqq.kandian.biz.daily.ReadInJoyDailyFragment;
import com.tencent.mobileqq.kandian.biz.daily.api.IKanDianDailyReportUtils;
import com.tencent.mobileqq.kandian.biz.feeds.entity.RedPntInfoForReport;
import com.tencent.mobileqq.kandian.biz.framework.api.IRIJAppSetting;
import com.tencent.mobileqq.kandian.biz.framework.api.IRIJFeedsType;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoReporter;
import com.tencent.mobileqq.kandian.biz.pts.listeners.OnSocialHeaderFollowClickListener;
import com.tencent.mobileqq.kandian.biz.push.RIJKanDianFolderStatus;
import com.tencent.mobileqq.kandian.biz.push.api.IKanDianMergeManager;
import com.tencent.mobileqq.kandian.biz.xtab.badge.RIJXTabBadgeStore;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadinjoySPEventReport;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadinjoySPEventReport.ForeBackGround;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadinjoySPEventReport.UserOptInfo;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyUserInfoModule;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyUserInfoModule.RefreshUserInfoCallBack;
import com.tencent.mobileqq.kandian.glue.report.api.IReadInJoyReportUtils;
import com.tencent.mobileqq.kandian.glue.router.msgbox.api.IRIJMsgBoxUtils;
import com.tencent.mobileqq.kandian.repo.account.api.IUserOperationModule;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.DailyModeConfigHandler;
import com.tencent.mobileqq.kandian.repo.common.RIJItemViewTypeUtils;
import com.tencent.mobileqq.kandian.repo.db.struct.BaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FeedsInfoUser;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyUserInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UGCFeedsInfo;
import com.tencent.mobileqq.kandian.repo.reddot.KandianMsgBoxRedPntInfo;
import com.tencent.mobileqq.kandian.repo.report.ReportInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.EmotionCodecUtils;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.AttributeList;

public class ReadinjoyReportUtils
{
  public static int a = 1;
  public static long a = 0L;
  public static String a;
  public static Map<Long, Pair<Long, Long>> a;
  private static boolean a = true;
  public static int b = 2;
  public static final Map<Long, Map<Long, ReadinjoyReportUtils.ExposureReportItem>> b;
  private static boolean b = false;
  public static int c = 1;
  public static int d = 2;
  public static int e = 10;
  public static int f = 11;
  public static int g = 12;
  public static volatile int h = 0;
  private static int i;
  
  static
  {
    ((IReadInJoySPEventReport)QRoute.api(IReadInJoySPEventReport.class)).addForeBackGroundCallback(new ReadinjoyReportUtils.1());
    jdField_a_of_type_Long = 0L;
    jdField_a_of_type_JavaLangString = "";
    jdField_a_of_type_JavaUtilMap = new HashMap();
    jdField_b_of_type_JavaUtilMap = new HashMap();
    jdField_b_of_type_Boolean = true;
    i = 0;
  }
  
  public static int a()
  {
    int j = ((IRIJAppSetting)QRoute.api(IRIJAppSetting.class)).getKanDianMode();
    if (j != 1)
    {
      if (j != 2)
      {
        if (j != 7) {
          return 1;
        }
        return 5;
      }
      return 3;
    }
    return 4;
  }
  
  public static int a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (((paramAbsBaseArticleInfo instanceof BaseArticleInfo)) && (!RIJItemViewTypeUtils.x(paramAbsBaseArticleInfo))) {
      return 1;
    }
    return 0;
  }
  
  public static RIJTransMergeKanDianReport.ReportR5Builder a(TemplateBean paramTemplateBean, String paramString)
  {
    if (paramTemplateBean == null) {
      return null;
    }
    RIJTransMergeKanDianReport.ReportR5Builder localReportR5Builder = new RIJTransMergeKanDianReport.ReportR5Builder();
    if (paramTemplateBean != null)
    {
      paramTemplateBean = paramTemplateBean.getDataAttribute(paramString);
      if ((paramTemplateBean != null) && (paramTemplateBean.entrySet() != null))
      {
        paramTemplateBean = paramTemplateBean.entrySet().iterator();
        while ((paramTemplateBean != null) && (paramTemplateBean.hasNext()))
        {
          paramString = (Map.Entry)paramTemplateBean.next();
          localReportR5Builder.addStringNotThrow((String)paramString.getKey(), paramString.getValue().toString());
        }
      }
    }
    return localReportR5Builder;
  }
  
  public static Pair<Long, Long> a(long paramLong)
  {
    if (jdField_a_of_type_JavaUtilMap.containsKey(Long.valueOf(paramLong))) {
      return (Pair)jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramLong));
    }
    return null;
  }
  
  public static String a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("version", VideoReporter.jdField_a_of_type_JavaLangString);
      localJSONObject.put("os", "1");
      localJSONObject.put("channel_id", ((IKanDianDailyReportUtils)QRoute.api(IKanDianDailyReportUtils.class)).getChannelId());
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return localJSONObject.toString();
  }
  
  private static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "Other";
    case 7: 
      return "4Tab";
    case 6: 
      return "Daily";
    case 5: 
      return "Lock";
    case 4: 
      return "MsgTab";
    case 3: 
      return "FromDTTab";
    }
    return "KDTAB";
  }
  
  public static String a(long paramLong)
  {
    if ((!DailyModeConfigHandler.a((int)paramLong)) && (!((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isDailyChildFeeds(paramLong)))
    {
      if (a(paramLong)) {
        return "0X8009356";
      }
      return "0X8009332";
    }
    return "0X8009CCB";
  }
  
  public static String a(Context paramContext, int paramInt1, int paramInt2, String paramString1, int paramInt3, int paramInt4, String paramString2)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("network", ((IReadInJoyReportUtils)QRoute.api(IReadInJoyReportUtils.class)).getNetWord(paramContext));
      localJSONObject.put("version", VideoReporter.jdField_a_of_type_JavaLangString);
      localJSONObject.put("os", "1");
      localJSONObject.put("ads_source", paramInt1);
      localJSONObject.put("card_pos ", paramInt2);
      localJSONObject.put("os", "1");
      localJSONObject.put("rowkey", paramString1);
      localJSONObject.put("feeds_type", paramInt3);
      localJSONObject.put("is_ugc_as_pgc", paramInt4);
      boolean bool = TextUtils.isEmpty(paramString2);
      if (bool) {
        localJSONObject.put("video_report_info", "");
      } else {
        localJSONObject.put("video_report_info", paramString2);
      }
      paramContext = localJSONObject.toString();
      return paramContext;
    }
    catch (Exception paramContext)
    {
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("getSmallVideoPolymericR5Str:");
        paramString1.append(paramContext.toString());
        QLog.d("ReadinjoyReportUtils", 2, paramString1.toString());
      }
    }
    return "";
  }
  
  public static String a(Context paramContext, long paramLong1, long paramLong2, int paramInt1, int paramInt2, String paramString1, String paramString2, int paramInt3, String paramString3)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("network", ((IReadInJoyReportUtils)QRoute.api(IReadInJoyReportUtils.class)).getNetWord(paramContext));
      localJSONObject.put("channel_id", paramInt2);
      localJSONObject.put("version", VideoReporter.jdField_a_of_type_JavaLangString);
      localJSONObject.put("os", "1");
      localJSONObject.put("vid", paramString2);
      localJSONObject.put("rowkey", paramString1);
      localJSONObject.put("algorithm_id", paramLong2);
      localJSONObject.put("feeds_type", paramInt1);
      localJSONObject.put("star_logo", "0");
      localJSONObject.put("is_ugc_as_pgc", paramInt3);
      localJSONObject.put("r_session_id", jdField_a_of_type_JavaLangString);
      paramContext = a(paramLong1);
      if (paramContext != null)
      {
        localJSONObject.put("r_session_position", paramContext.first);
        localJSONObject.put("r_session_ispush", paramContext.second);
      }
      boolean bool = TextUtils.isEmpty(paramString3);
      if (bool) {
        localJSONObject.put("video_report_info", "");
      } else {
        localJSONObject.put("video_report_info", paramString3);
      }
      if (DailyModeConfigHandler.c(paramInt2))
      {
        paramContext = (IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class);
        paramString1 = new StringBuilder();
        paramString1.append("readinjoy_daily_article_first_exposure_");
        paramString1.append(paramLong1);
        paramLong1 = ((Long)paramContext.getReadInJoySpValue(paramString1.toString(), Long.valueOf(0L))).longValue();
        if (paramLong1 != 0L)
        {
          paramContext = new StringBuilder();
          paramContext.append(paramLong1);
          paramContext.append("");
          localJSONObject.put("daily_article_first_timestamp", paramContext.toString());
        }
      }
      VideoReporter.a(localJSONObject);
      paramContext = localJSONObject.toString();
      return paramContext;
    }
    catch (Exception paramContext)
    {
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("getSmallVideoWrapperPolymericR5Str:");
        paramString1.append(paramContext.toString());
        QLog.d("ReadinjoyReportUtils", 2, paramString1.toString());
      }
    }
    return "";
  }
  
  public static String a(TemplateBean paramTemplateBean, String paramString1, String paramString2)
  {
    if (paramTemplateBean != null)
    {
      if (paramString2 == null) {
        return null;
      }
      paramTemplateBean = paramTemplateBean.getDataAttribute(paramString1);
      if (paramTemplateBean != null)
      {
        paramTemplateBean = paramTemplateBean.get(paramString2);
        if (paramTemplateBean != null) {
          return paramTemplateBean.toString();
        }
      }
    }
    return null;
  }
  
  public static String a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Object localObject = "";
    if (paramAbsBaseArticleInfo != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(paramAbsBaseArticleInfo.innerUniqueID);
      localObject = ((StringBuilder)localObject).toString();
    }
    return localObject;
  }
  
  public static String a(AbsBaseArticleInfo paramAbsBaseArticleInfo, IReadInJoyUserInfoModule.RefreshUserInfoCallBack paramRefreshUserInfoCallBack)
  {
    if (paramAbsBaseArticleInfo == null)
    {
      QLog.d("ReadinjoyReportUtils", 2, "create msg brief for fail, article info is null");
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("createStructingMsgBrief article : ");
    localStringBuilder.append(paramAbsBaseArticleInfo);
    localStringBuilder.append(", briefPrefix : ");
    localStringBuilder.append(paramAbsBaseArticleInfo.msgBoxBriefPreFix);
    localStringBuilder.append(", briefContent : ");
    localStringBuilder.append(paramAbsBaseArticleInfo.msgBoxBriefContent);
    QLog.d("ReadinjoyReportUtils", 2, localStringBuilder.toString());
    if ((!TextUtils.isEmpty(paramAbsBaseArticleInfo.msgBoxBriefPreFix)) && (paramAbsBaseArticleInfo.msgBoxBriefPreFixType > 0))
    {
      if (paramAbsBaseArticleInfo.msgBoxBriefPreFixType == 1)
      {
        paramRefreshUserInfoCallBack = new StringBuilder();
        paramRefreshUserInfoCallBack.append(paramAbsBaseArticleInfo.msgBoxBriefPreFix);
        paramRefreshUserInfoCallBack.append(": ");
        paramRefreshUserInfoCallBack = paramRefreshUserInfoCallBack.toString();
        break label282;
      }
      if ((paramAbsBaseArticleInfo.msgBoxBriefPreFixType == 2) && (TextUtils.isDigitsOnly(paramAbsBaseArticleInfo.msgBoxBriefPreFix)))
      {
        long l = Long.valueOf(paramAbsBaseArticleInfo.msgBoxBriefPreFix).longValue();
        paramRefreshUserInfoCallBack = ((IReadInJoyUserInfoModule)QRoute.api(IReadInJoyUserInfoModule.class)).getSingleKDUserInfo(l, paramRefreshUserInfoCallBack);
        if (paramRefreshUserInfoCallBack == null)
        {
          paramRefreshUserInfoCallBack = new StringBuilder();
          paramRefreshUserInfoCallBack.append(((IReadInJoyUserInfoModule)QRoute.api(IReadInJoyUserInfoModule.class)).getDefaultNickName());
          paramRefreshUserInfoCallBack.append(": ");
          paramRefreshUserInfoCallBack = paramRefreshUserInfoCallBack.toString();
          break label282;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramRefreshUserInfoCallBack.nick);
        localStringBuilder.append(": ");
        paramRefreshUserInfoCallBack = localStringBuilder.toString();
        break label282;
      }
    }
    paramRefreshUserInfoCallBack = null;
    label282:
    if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.msgBoxBriefContent)) {
      paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.msgBoxBriefContent;
    } else {
      paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.mTitle;
    }
    if (!TextUtils.isEmpty(paramRefreshUserInfoCallBack))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramRefreshUserInfoCallBack);
      localStringBuilder.append(paramAbsBaseArticleInfo);
      paramAbsBaseArticleInfo = localStringBuilder.toString();
    }
    return EmotionCodecUtils.b(paramAbsBaseArticleInfo);
  }
  
  public static String a(AbsBaseArticleInfo paramAbsBaseArticleInfo, String paramString, int paramInt)
  {
    Object localObject = paramString;
    if (paramAbsBaseArticleInfo != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("&last_rowkey=");
      ((StringBuilder)localObject).append(paramAbsBaseArticleInfo.innerUniqueID);
      ((StringBuilder)localObject).append("&last_scene_type=");
      ((StringBuilder)localObject).append(paramInt);
      localObject = ((StringBuilder)localObject).toString();
    }
    return localObject;
  }
  
  public static Map<Long, ReadinjoyReportUtils.ExposureReportItem> a(int paramInt)
  {
    Map localMap1 = jdField_b_of_type_JavaUtilMap;
    long l = paramInt;
    try
    {
      Map localMap2 = a(l);
      jdField_b_of_type_JavaUtilMap.remove(Long.valueOf(l));
      return localMap2;
    }
    finally {}
  }
  
  public static Map<Long, ReadinjoyReportUtils.ExposureReportItem> a(long paramLong)
  {
    synchronized (jdField_b_of_type_JavaUtilMap)
    {
      Map localMap1 = (Map)jdField_b_of_type_JavaUtilMap.get(Long.valueOf(paramLong));
      Object localObject1 = localMap1;
      if (localMap1 == null)
      {
        localObject1 = new HashMap();
        jdField_b_of_type_JavaUtilMap.put(Long.valueOf(paramLong), localObject1);
      }
      return localObject1;
    }
  }
  
  public static JSONObject a(AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt, boolean paramBoolean, String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramAbsBaseArticleInfo != null) {}
    for (;;)
    {
      try
      {
        localJSONObject.put("app_type", c());
        localJSONObject.put("channel_id", paramAbsBaseArticleInfo.mChannelID);
        localJSONObject.put("scene_type", paramInt);
        if (!paramBoolean) {
          break label236;
        }
        paramInt = 1;
        localJSONObject.put("is_intensify", paramInt);
        localJSONObject.put("feeds_type", ((IRIJFeedsType)QRoute.api(IRIJFeedsType.class)).checkArticleType(paramAbsBaseArticleInfo));
        localJSONObject.put("rowkey", paramAbsBaseArticleInfo.innerUniqueID);
        localJSONObject.put("puin", paramAbsBaseArticleInfo.getSubscribeUin());
        if ((paramAbsBaseArticleInfo.mSocialFeedInfo == null) || (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser == null)) {
          break label241;
        }
        l = paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser.jdField_a_of_type_Long;
        localJSONObject.put("ugcuin", l);
        localJSONObject.put("algorithm_id", paramAbsBaseArticleInfo.mAlgorithmID);
        localJSONObject.put("button_type", paramAbsBaseArticleInfo.showFollowButtonType);
        localJSONObject.put("last_rowkey", paramAbsBaseArticleInfo.mArticleID);
        localJSONObject.put("comment_id", paramString);
        localJSONObject.put("kandian_mode_new", VideoReporter.a());
        return localJSONObject;
      }
      catch (JSONException paramAbsBaseArticleInfo)
      {
        QLog.d("ReadinjoyReportUtils", 1, paramAbsBaseArticleInfo.getMessage());
      }
      return localJSONObject;
      label236:
      paramInt = 0;
      continue;
      label241:
      long l = 0L;
    }
  }
  
  public static JSONObject a(String paramString)
  {
    try
    {
      paramString = (JSONObject)new JSONTokener(paramString).nextValue();
      return paramString;
    }
    catch (JSONException|NullPointerException|Exception paramString) {}
    return null;
  }
  
  public static void a()
  {
    Object localObject = new ArrayList();
    oidb_cmd0x80a.AttributeList localAttributeList = new oidb_cmd0x80a.AttributeList();
    localAttributeList.att_id.set(1);
    localAttributeList.att_name.set("FolderStatus");
    PBStringField localPBStringField = localAttributeList.att_value;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(RIJKanDianFolderStatus.reportFolderStatus);
    localStringBuilder.append("");
    localPBStringField.set(localStringBuilder.toString());
    ((ArrayList)localObject).add(localAttributeList);
    a(10, (List)localObject);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportKandianDelete  , foldStatus :  ");
      ((StringBuilder)localObject).append(RIJKanDianFolderStatus.reportFolderStatus);
      QLog.d("ReadinjoyReportUtils", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public static void a(int paramInt)
  {
    i = paramInt | i;
    ReadinjoySPEventReport.e(3);
  }
  
  public static void a(int paramInt1, int paramInt2, long paramLong, HashMap<String, Object> paramHashMap)
  {
    Object localObject1 = RIJTransMergeKanDianReport.a();
    if (paramHashMap != null)
    {
      paramHashMap = paramHashMap.entrySet().iterator();
      while (paramHashMap.hasNext())
      {
        Object localObject2 = (Map.Entry)paramHashMap.next();
        String str = String.valueOf(((Map.Entry)localObject2).getKey());
        localObject2 = String.valueOf(((Map.Entry)localObject2).getValue());
        if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject2))) {
          ((RIJTransMergeKanDianReport.ReportR5Builder)localObject1).addStringNotThrow(str, (String)localObject2);
        }
      }
    }
    paramHashMap = ((RIJTransMergeKanDianReport.ReportR5Builder)localObject1).build();
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("reportQualityDataDimension id = ");
    ((StringBuilder)localObject1).append(paramInt2);
    ((StringBuilder)localObject1).append(" resultCode = ");
    ((StringBuilder)localObject1).append(paramInt1);
    ((StringBuilder)localObject1).append(" cost = ");
    ((StringBuilder)localObject1).append(paramLong);
    QLog.d("ReadinjoyReportUtils", 1, ((StringBuilder)localObject1).toString());
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("reportQualityDataDimension id = ");
      ((StringBuilder)localObject1).append(paramInt2);
      ((StringBuilder)localObject1).append(" r5String = ");
      ((StringBuilder)localObject1).append(paramHashMap);
      QLog.d("ReadinjoyReportUtils", 2, ((StringBuilder)localObject1).toString());
    }
    localObject1 = Aladdin.getConfig(466);
    int k = 0;
    int j = k;
    if (localObject1 != null)
    {
      j = k;
      if (((AladdinConfig)localObject1).getIntegerFromString("qualityReportSwitch", 0) == 1) {
        j = 1;
      }
    }
    if (j == 0)
    {
      QLog.i("ReadinjoyReportUtils", 1, "[reportQualityDataDimension] qualityReportSwitch canReport is false.");
      return;
    }
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800ACB9", "0X800ACB9", paramInt2, 0, String.valueOf(paramInt1), String.valueOf(paramLong), "", paramHashMap, false);
  }
  
  public static void a(int paramInt1, int paramInt2, Activity paramActivity, int paramInt3)
  {
    a(paramInt1, paramInt2, paramActivity, false, paramInt3);
  }
  
  public static void a(int paramInt1, int paramInt2, Activity paramActivity, boolean paramBoolean, int paramInt3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" type : ");
    localStringBuilder.append(paramInt1);
    QLog.d("ReadinjoyReportUtils", 2, localStringBuilder.toString());
    if (paramInt1 == 0) {
      return;
    }
    boolean bool1 = jdField_b_of_type_Boolean;
    boolean bool2 = true;
    if ((!bool1) && (3 == paramInt1))
    {
      a(true);
      return;
    }
    if (paramInt2 == 40677) {
      return;
    }
    bool1 = bool2;
    if (paramInt1 != 1)
    {
      if (paramInt1 != 3)
      {
        bool1 = bool2;
        if (paramInt1 == 6) {
          break label114;
        }
        if (paramInt1 != 1001)
        {
          bool1 = bool2;
          break label114;
        }
      }
      bool1 = paramBoolean;
    }
    label114:
    a(paramInt2, paramActivity, bool1, paramInt3);
  }
  
  private static void a(int paramInt1, Activity paramActivity, boolean paramBoolean, int paramInt2)
  {
    ThreadManager.executeOnSubThread(new ReadinjoyReportUtils.3(paramInt1, paramActivity, paramBoolean, paramInt2));
  }
  
  public static void a(int paramInt1, ToServiceMsg paramToServiceMsg, int paramInt2, HashMap<String, Object> paramHashMap)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("reportQuality id = ");
    localStringBuilder.append(paramInt2);
    QLog.d("ReadinjoyReportUtils", 1, localStringBuilder.toString());
    if (paramToServiceMsg == null)
    {
      QLog.e("ReadinjoyReportUtils", 1, "reportQuality req = null ");
      return;
    }
    long l = 0L;
    if (paramToServiceMsg.extraData != null) {
      l = System.currentTimeMillis() - paramToServiceMsg.extraData.getLong("sendtimekey");
    }
    a(paramInt1, paramInt2, l, paramHashMap);
  }
  
  public static void a(int paramInt, String paramString1, String paramString2, Resources paramResources)
  {
    if ((paramInt == 1008) && (AppConstants.KANDIAN_DAILY_UIN.equals(paramString1)))
    {
      if (Utils.a(paramString2, paramResources.getString(com.tencent.mobileqq.activity.recent.RecentItemBaseBuilder.a[3])))
      {
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, null, "0X8009884", "0X8009884", 0, 0, "", "", "", a(), false);
        return;
      }
      if (Utils.a(paramString2, paramResources.getString(com.tencent.mobileqq.activity.recent.RecentItemBaseBuilder.a[2]))) {
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, null, "0X8009885", "0X8009885", 0, 0, "", "", "", a(), false);
      }
    }
  }
  
  public static void a(int paramInt, String paramString, boolean paramBoolean)
  {
    if ((paramInt == 1008) && (AppConstants.KANDIAN_DAILY_UIN.equals(paramString)))
    {
      if (paramBoolean)
      {
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, null, "0X8009884", "0X8009884", 0, 0, "", "", "", a(), false);
        return;
      }
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, null, "0X8009885", "0X8009885", 0, 0, "", "", "", a(), false);
    }
  }
  
  public static void a(int paramInt, List<oidb_cmd0x80a.AttributeList> paramList)
  {
    ThreadManager.executeOnSubThread(new ReadinjoyReportUtils.6(paramList, paramInt));
  }
  
  public static void a(int paramInt1, boolean paramBoolean, long paramLong, int paramInt2, int paramInt3)
  {
    a(paramInt1, paramBoolean, paramLong, paramInt2, paramInt3, true);
  }
  
  public static void a(int paramInt1, boolean paramBoolean1, long paramLong, int paramInt2, int paramInt3, boolean paramBoolean2)
  {
    a(paramInt1, paramBoolean1, paramLong, paramInt2, paramInt3, paramBoolean2, -1);
  }
  
  public static void a(int paramInt1, boolean paramBoolean1, long paramLong, int paramInt2, int paramInt3, boolean paramBoolean2, int paramInt4)
  {
    ArrayList localArrayList = new ArrayList();
    ReadinjoySPEventReport.a().jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineReadinjoySPEventReport$UserOptInfo.a(paramBoolean1);
    int j = 5;
    Object localObject1;
    Object localObject2;
    Object localObject3;
    long l;
    if (paramBoolean1)
    {
      ReadinjoySPEventReport.n();
      ReadinjoySPEventReport.ForeBackGround.a(4);
      localObject1 = new oidb_cmd0x80a.AttributeList();
      ((oidb_cmd0x80a.AttributeList)localObject1).att_id.set(1);
      ((oidb_cmd0x80a.AttributeList)localObject1).att_name.set("EnterType");
      ((oidb_cmd0x80a.AttributeList)localObject1).att_value.set(a(paramInt1));
      localArrayList.add(localObject1);
      localObject2 = new oidb_cmd0x80a.AttributeList();
      ((oidb_cmd0x80a.AttributeList)localObject2).att_id.set(2);
      ((oidb_cmd0x80a.AttributeList)localObject2).att_name.set("FolderStatus");
      localObject3 = ((oidb_cmd0x80a.AttributeList)localObject2).att_value;
      if (paramInt1 == 0)
      {
        localObject1 = "1024";
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(RIJKanDianFolderStatus.reportFolderStatus);
        ((StringBuilder)localObject1).append("");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      ((PBStringField)localObject3).set((String)localObject1);
      localArrayList.add(localObject2);
      if (RIJKanDianFolderStatus.reportFolderStatus != 1)
      {
        localObject1 = new oidb_cmd0x80a.AttributeList();
        ((oidb_cmd0x80a.AttributeList)localObject1).att_id.set(3);
        ((oidb_cmd0x80a.AttributeList)localObject1).att_name.set("StrategyID");
        ((oidb_cmd0x80a.AttributeList)localObject1).att_value.set(RIJKanDianFolderStatus.RED_PNT_INFO_FOR_REPORT.b);
        localArrayList.add(localObject1);
        localObject1 = new oidb_cmd0x80a.AttributeList();
        ((oidb_cmd0x80a.AttributeList)localObject1).att_id.set(4);
        ((oidb_cmd0x80a.AttributeList)localObject1).att_name.set("AlgorithmID");
        ((oidb_cmd0x80a.AttributeList)localObject1).att_value.set(RIJKanDianFolderStatus.RED_PNT_INFO_FOR_REPORT.jdField_a_of_type_JavaLangString);
        localArrayList.add(localObject1);
        paramLong = NetConnInfoCenter.getServerTime();
        l = RIJKanDianFolderStatus.RED_PNT_INFO_FOR_REPORT.jdField_a_of_type_Long;
        localObject1 = new oidb_cmd0x80a.AttributeList();
        ((oidb_cmd0x80a.AttributeList)localObject1).att_id.set(5);
        ((oidb_cmd0x80a.AttributeList)localObject1).att_name.set("costtime");
        localObject2 = ((oidb_cmd0x80a.AttributeList)localObject1).att_value;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("");
        ((StringBuilder)localObject3).append(paramLong - l);
        ((PBStringField)localObject2).set(((StringBuilder)localObject3).toString());
        localArrayList.add(localObject1);
      }
      localObject1 = new oidb_cmd0x80a.AttributeList();
      ((oidb_cmd0x80a.AttributeList)localObject1).att_id.set(6);
      ((oidb_cmd0x80a.AttributeList)localObject1).att_name.set("durationBeforeEnter");
      if (ReadinjoySPEventReport.a().d() > 0L)
      {
        paramLong = System.currentTimeMillis();
        l = ReadinjoySPEventReport.a().d();
      }
      else
      {
        paramLong = System.currentTimeMillis();
        l = ReadinjoySPEventReport.jdField_a_of_type_Long;
      }
      localObject2 = ((oidb_cmd0x80a.AttributeList)localObject1).att_value;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(paramLong - l);
      ((StringBuilder)localObject3).append("");
      ((PBStringField)localObject2).set(((StringBuilder)localObject3).toString());
      localArrayList.add(localObject1);
      localObject2 = new oidb_cmd0x80a.AttributeList();
      ((oidb_cmd0x80a.AttributeList)localObject1).att_id.set(7);
      ((oidb_cmd0x80a.AttributeList)localObject1).att_name.set("channelID");
      if (paramInt1 == 7) {
        paramInt2 = RIJXTabBadgeStore.a.a();
      } else {
        paramInt2 = paramInt4;
      }
      paramInt3 = paramInt2;
      if (paramInt2 == -1) {
        paramInt3 = paramInt4;
      }
      localObject1 = ((oidb_cmd0x80a.AttributeList)localObject1).att_value;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(paramInt3);
      ((StringBuilder)localObject3).append("");
      ((PBStringField)localObject1).set(((StringBuilder)localObject3).toString());
      localArrayList.add(localObject2);
      paramInt2 = 4;
    }
    else
    {
      if (paramBoolean2) {
        ReadinjoySPEventReport.ForeBackGround.a();
      }
      localObject1 = new oidb_cmd0x80a.AttributeList();
      ((oidb_cmd0x80a.AttributeList)localObject1).att_id.set(1);
      ((oidb_cmd0x80a.AttributeList)localObject1).att_name.set("ExitType");
      ((oidb_cmd0x80a.AttributeList)localObject1).att_value.set(a(paramInt1));
      localArrayList.add(localObject1);
      localObject1 = new oidb_cmd0x80a.AttributeList();
      ((oidb_cmd0x80a.AttributeList)localObject1).att_id.set(2);
      ((oidb_cmd0x80a.AttributeList)localObject1).att_name.set("FolderStatus");
      ((oidb_cmd0x80a.AttributeList)localObject1).att_value.set(String.valueOf(paramInt2));
      localArrayList.add(localObject1);
      localObject1 = new oidb_cmd0x80a.AttributeList();
      ((oidb_cmd0x80a.AttributeList)localObject1).att_id.set(3);
      ((oidb_cmd0x80a.AttributeList)localObject1).att_name.set("Time");
      ((oidb_cmd0x80a.AttributeList)localObject1).att_value.set(String.valueOf(ReadinjoySPEventReport.a(paramLong)));
      localArrayList.add(localObject1);
      localObject1 = new oidb_cmd0x80a.AttributeList();
      ((oidb_cmd0x80a.AttributeList)localObject1).att_id.set(4);
      ((oidb_cmd0x80a.AttributeList)localObject1).att_name.set("OperationBitmap");
      localObject2 = ((oidb_cmd0x80a.AttributeList)localObject1).att_value;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(paramInt3);
      ((StringBuilder)localObject3).append("");
      ((PBStringField)localObject2).set(((StringBuilder)localObject3).toString());
      localArrayList.add(localObject1);
      if (RIJKanDianFolderStatus.RED_PNT_INFO_FOR_REPORT.jdField_a_of_type_Int != 1)
      {
        localObject1 = new oidb_cmd0x80a.AttributeList();
        ((oidb_cmd0x80a.AttributeList)localObject1).att_id.set(5);
        ((oidb_cmd0x80a.AttributeList)localObject1).att_name.set("StrategyID");
        ((oidb_cmd0x80a.AttributeList)localObject1).att_value.set(RIJKanDianFolderStatus.RED_PNT_INFO_FOR_REPORT.b);
        localArrayList.add(localObject1);
        localObject1 = new oidb_cmd0x80a.AttributeList();
        ((oidb_cmd0x80a.AttributeList)localObject1).att_id.set(6);
        ((oidb_cmd0x80a.AttributeList)localObject1).att_name.set("AlgorithmID");
        ((oidb_cmd0x80a.AttributeList)localObject1).att_value.set(RIJKanDianFolderStatus.RED_PNT_INFO_FOR_REPORT.jdField_a_of_type_JavaLangString);
        localArrayList.add(localObject1);
        paramLong = NetConnInfoCenter.getServerTime();
        l = RIJKanDianFolderStatus.RED_PNT_INFO_FOR_REPORT.jdField_a_of_type_Long;
        localObject1 = new oidb_cmd0x80a.AttributeList();
        ((oidb_cmd0x80a.AttributeList)localObject1).att_id.set(7);
        ((oidb_cmd0x80a.AttributeList)localObject1).att_name.set("costtime");
        localObject2 = ((oidb_cmd0x80a.AttributeList)localObject1).att_value;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("");
        ((StringBuilder)localObject3).append(paramLong - l);
        ((PBStringField)localObject2).set(((StringBuilder)localObject3).toString());
        localArrayList.add(localObject1);
      }
      localObject1 = ReadinjoySPEventReport.a().b;
      localObject2 = new oidb_cmd0x80a.AttributeList();
      ((oidb_cmd0x80a.AttributeList)localObject2).att_id.set(8);
      ((oidb_cmd0x80a.AttributeList)localObject2).att_name.set("staticDurationAfterEnter");
      if (((ReadinjoySPEventReport.UserOptInfo)localObject1).jdField_a_of_type_Long > 0L) {
        paramLong = ((ReadinjoySPEventReport.UserOptInfo)localObject1).jdField_a_of_type_Long - ((ReadinjoySPEventReport.UserOptInfo)localObject1).d;
      } else {
        paramLong = 0L;
      }
      localObject3 = ((oidb_cmd0x80a.AttributeList)localObject2).att_value;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramLong);
      localStringBuilder.append("");
      ((PBStringField)localObject3).set(localStringBuilder.toString());
      localArrayList.add(localObject2);
      localObject2 = new oidb_cmd0x80a.AttributeList();
      ((oidb_cmd0x80a.AttributeList)localObject2).att_id.set(9);
      ((oidb_cmd0x80a.AttributeList)localObject2).att_name.set("staticDurationBeforeExit");
      l = ((ReadinjoySPEventReport.UserOptInfo)localObject1).c;
      paramLong = 0L;
      if (l > 0L) {
        paramLong = ((ReadinjoySPEventReport.UserOptInfo)localObject1).e - ((ReadinjoySPEventReport.UserOptInfo)localObject1).c;
      }
      localObject3 = ((oidb_cmd0x80a.AttributeList)localObject2).att_value;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramLong);
      localStringBuilder.append("");
      ((PBStringField)localObject3).set(localStringBuilder.toString());
      localArrayList.add(localObject2);
      localObject2 = new oidb_cmd0x80a.AttributeList();
      ((oidb_cmd0x80a.AttributeList)localObject2).att_id.set(10);
      ((oidb_cmd0x80a.AttributeList)localObject2).att_name.set("articleInfoList");
      ((oidb_cmd0x80a.AttributeList)localObject2).att_value.set(((ReadinjoySPEventReport.UserOptInfo)localObject1).a());
      localArrayList.add(localObject2);
      localObject2 = new oidb_cmd0x80a.AttributeList();
      ((oidb_cmd0x80a.AttributeList)localObject2).att_id.set(11);
      ((oidb_cmd0x80a.AttributeList)localObject2).att_name.set("scrollInfoList");
      ((oidb_cmd0x80a.AttributeList)localObject2).att_value.set(((ReadinjoySPEventReport.UserOptInfo)localObject1).b());
      localArrayList.add(localObject2);
      localObject1 = new oidb_cmd0x80a.AttributeList();
      ((oidb_cmd0x80a.AttributeList)localObject1).att_id.set(12);
      ((oidb_cmd0x80a.AttributeList)localObject1).att_name.set("channelID");
      localObject2 = ((oidb_cmd0x80a.AttributeList)localObject1).att_value;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(paramInt4);
      ((StringBuilder)localObject3).append("");
      ((PBStringField)localObject2).set(((StringBuilder)localObject3).toString());
      localArrayList.add(localObject1);
      paramInt2 = j;
    }
    a(paramInt2, localArrayList);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("report kandian exit or enter ! from : ");
      ((StringBuilder)localObject1).append(paramInt1);
      QLog.d("ReadinjoyReportUtils", 2, ((StringBuilder)localObject1).toString());
    }
  }
  
  public static void a(TemplateBean paramTemplateBean, String paramString1, String paramString2)
  {
    if (paramTemplateBean != null)
    {
      if (paramString2 == null) {
        return;
      }
      RIJTransMergeKanDianReport.ReportR5Builder localReportR5Builder = a(paramTemplateBean, paramString1);
      paramTemplateBean = a(paramTemplateBean, paramString1, paramString2);
      if (paramTemplateBean == null) {
        return;
      }
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", paramTemplateBean, paramTemplateBean, 0, 0, "", "", "", localReportR5Builder.build(), false);
    }
  }
  
  private static void a(AppInterface paramAppInterface, long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    ArrayList localArrayList = new ArrayList();
    ReportInfo localReportInfo = new ReportInfo();
    localReportInfo.mUin = paramAppInterface.getLongAccountUin();
    localReportInfo.mSource = 0;
    localReportInfo.mSourceArticleId = paramLong;
    localReportInfo.mAlgorithmId = paramInt1;
    localReportInfo.mOperation = paramInt3;
    localReportInfo.mOpSource = 3;
    localReportInfo.mStrategyId = paramInt2;
    localArrayList.add(localReportInfo);
    ((IUserOperationModule)QRoute.api(IUserOperationModule.class)).request0x64eUserOperationReport(localArrayList);
  }
  
  public static void a(AppInterface paramAppInterface, MessageForStructing paramMessageForStructing, int paramInt)
  {
    if (paramMessageForStructing == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int k;
    int j;
    if (!TextUtils.isEmpty(paramMessageForStructing.structingMsg.mAlgorithmIds))
    {
      localObject = paramMessageForStructing.structingMsg.mAlgorithmIds.split("\\|");
      k = localObject.length;
      j = 0;
      while (j < k)
      {
        String str1 = localObject[j];
        try
        {
          localArrayList.add(Integer.valueOf(Integer.parseInt(str1)));
        }
        catch (Exception localException1)
        {
          localException1.printStackTrace();
        }
        j += 1;
      }
    }
    Object localObject = new ArrayList();
    if (!TextUtils.isEmpty(paramMessageForStructing.structingMsg.mStrategyIds))
    {
      String[] arrayOfString = paramMessageForStructing.structingMsg.mStrategyIds.split("\\|");
      k = arrayOfString.length;
      j = 0;
      while (j < k)
      {
        String str2 = arrayOfString[j];
        try
        {
          ((ArrayList)localObject).add(Integer.valueOf(Integer.parseInt(str2)));
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
        }
        j += 1;
      }
    }
    if (!TextUtils.isEmpty(paramMessageForStructing.structingMsg.mMsgActionData))
    {
      paramMessageForStructing = a(paramMessageForStructing.structingMsg.mMsgActionData);
      if (paramMessageForStructing != null) {
        try
        {
          l = Long.parseLong(paramMessageForStructing.getString("id"));
        }
        catch (Exception paramMessageForStructing)
        {
          paramMessageForStructing.printStackTrace();
        }
      }
    }
    long l = -1L;
    if ((l != -1L) && (localArrayList.size() > 0) && (((ArrayList)localObject).size() > 0)) {
      a(paramAppInterface, l, ((Integer)localArrayList.get(0)).intValue(), ((Integer)((ArrayList)localObject).get(0)).intValue(), paramInt);
    }
  }
  
  public static void a(RecentItemChatMsgData paramRecentItemChatMsgData)
  {
    if (!jdField_a_of_type_Boolean) {
      return;
    }
    if ((paramRecentItemChatMsgData != null) && (paramRecentItemChatMsgData.mUser != null) && (AppConstants.KANDIAN_SUBSCRIBE_UIN.equals(paramRecentItemChatMsgData.mUser.uin)))
    {
      jdField_a_of_type_Boolean = false;
      ThreadManager.executeOnSubThread(new ReadinjoyReportUtils.4(paramRecentItemChatMsgData));
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    RIJTransMergeKanDianReport.ReportR5Builder localReportR5Builder = new RIJTransMergeKanDianReport.ReportR5Builder();
    localReportR5Builder.addFolderStatus();
    localReportR5Builder.addKandianMode();
    paramQQAppInterface = ((IKanDianMergeManager)paramQQAppInterface.getRuntimeService(IKanDianMergeManager.class)).getUnreadMsgBoxRedPntInfo();
    int j;
    if (paramQQAppInterface != null)
    {
      j = paramQQAppInterface.mMsgCnt;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramQQAppInterface.mUin);
      localStringBuilder.append("");
      paramQQAppInterface = localStringBuilder.toString();
    }
    else
    {
      paramQQAppInterface = "";
      j = 0;
    }
    if (j > 0) {
      try
      {
        localReportR5Builder.addRedDotNum(j);
      }
      catch (JSONException localJSONException)
      {
        QLog.e("ReadinjoyReportUtils", 2, localJSONException, new Object[0]);
      }
    }
    localReportR5Builder.addStringNotThrow("message_reddot_style", ((IRIJMsgBoxUtils)QRoute.api(IRIJMsgBoxUtils.class)).getMsgBoxUIMode());
    String str;
    if (paramBoolean) {
      str = "0X8009A85";
    } else {
      str = "0X8009A84";
    }
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, paramQQAppInterface, str, str, 0, 0, "", "", "", localReportR5Builder.build(), false);
  }
  
  public static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo == null) {
      return;
    }
    String str;
    if ((!RIJItemViewTypeUtils.m(paramAbsBaseArticleInfo)) && (!RIJItemViewTypeUtils.l(paramAbsBaseArticleInfo)) && (!RIJItemViewTypeUtils.n(paramAbsBaseArticleInfo)) && (!RIJItemViewTypeUtils.p(paramAbsBaseArticleInfo))) {
      str = paramAbsBaseArticleInfo.mSubscribeID;
    } else if ((paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo != null)) {
      str = Long.toString(paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.jdField_a_of_type_Long);
    } else {
      str = "";
    }
    long l1 = paramAbsBaseArticleInfo.mFeedId;
    long l2 = paramAbsBaseArticleInfo.mArticleID;
    long l3 = paramAbsBaseArticleInfo.mStrategyId;
    int j = RIJItemViewTypeUtils.c(paramAbsBaseArticleInfo);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      RIJTransMergeKanDianReport.a(localJSONObject, paramAbsBaseArticleInfo);
      localJSONObject.put("touin", str);
      localJSONObject.put("entry_mode", String.valueOf(j));
    }
    catch (Exception paramAbsBaseArticleInfo)
    {
      paramAbsBaseArticleInfo.printStackTrace();
    }
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8009846", "0X8009846", 0, 0, String.valueOf(l1), String.valueOf(l2), String.valueOf(l3), localJSONObject.toString(), false);
  }
  
  public static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt, String paramString)
  {
    c(paramAbsBaseArticleInfo, paramInt, false, paramString);
  }
  
  public static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt, boolean paramBoolean, String paramString)
  {
    if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.bindShowFollowButton)) {
      b(paramAbsBaseArticleInfo, paramInt, paramBoolean, paramString);
    }
  }
  
  public static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, long paramLong)
  {
    ??? = (IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("readinjoy_daily_article_first_exposure_");
    ((StringBuilder)localObject2).append(paramAbsBaseArticleInfo.mArticleID);
    if (((Long)((IReadInJoyHelper)???).getReadInJoySpValue(((StringBuilder)localObject2).toString(), Long.valueOf(0L))).longValue() == 0L)
    {
      ??? = (IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("readinjoy_daily_article_first_exposure_");
      ((StringBuilder)localObject2).append(paramAbsBaseArticleInfo.mArticleID);
      ((IReadInJoyHelper)???).updateReadInJoySpValue(((StringBuilder)localObject2).toString(), Long.valueOf(System.currentTimeMillis() / 1000L));
    }
    synchronized (jdField_b_of_type_JavaUtilMap)
    {
      localObject2 = a(paramAbsBaseArticleInfo.mChannelID);
      ReadinjoyReportUtils.ExposureReportItem localExposureReportItem = (ReadinjoyReportUtils.ExposureReportItem)((Map)localObject2).get(Long.valueOf(paramAbsBaseArticleInfo.mArticleID));
      if (localExposureReportItem != null)
      {
        long l = paramLong;
        if (localExposureReportItem.jdField_a_of_type_Long > paramLong) {
          l = localExposureReportItem.jdField_a_of_type_Long;
        }
        localExposureReportItem.jdField_a_of_type_Long = l;
      }
      else
      {
        localExposureReportItem = new ReadinjoyReportUtils.ExposureReportItem(RIJTransMergeKanDianReport.a());
        localExposureReportItem.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = paramAbsBaseArticleInfo;
        localExposureReportItem.jdField_a_of_type_Long = paramLong;
        ((Map)localObject2).put(Long.valueOf(paramAbsBaseArticleInfo.mArticleID), localExposureReportItem);
      }
      return;
    }
  }
  
  public static void a(String paramString)
  {
    if (AppConstants.KANDIAN_SUBSCRIBE_UIN.equals(paramString))
    {
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, null, "0X800978D", "0X800978D", 0, 0, "", "", "", a(), false);
      ReadinjoySPEventReport.l();
      return;
    }
    if (AppConstants.KANDIAN_DAILY_UIN.equals(paramString))
    {
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, null, "0X8009886", "0X8009886", 0, 0, "", "", "", a(), false);
      ReadinjoySPEventReport.m();
    }
  }
  
  public static void a(String paramString, boolean paramBoolean, long paramLong)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static void a(List<AbsBaseArticleInfo> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      if (Aladdin.getConfig(183).getIntegerFromString("allow_report", 0) == 0)
      {
        QLog.d("ReadinjoyReportUtils", 1, "reportRefreshArticleInfoFor64e config not allow!");
        return;
      }
      Collections.sort(paramList, new ReadinjoyReportUtils.5());
      ArrayList localArrayList = new ArrayList();
      int j = 0;
      while (j < paramList.size())
      {
        Object localObject = (AbsBaseArticleInfo)paramList.get(j);
        ReportInfo localReportInfo = new ReportInfo();
        localReportInfo.mAlgorithmId = ((int)((AbsBaseArticleInfo)localObject).mAlgorithmID);
        localReportInfo.mStrategyId = ((AbsBaseArticleInfo)localObject).mStrategyId;
        localReportInfo.mSourceArticleId = ((AbsBaseArticleInfo)localObject).mArticleID;
        localReportInfo.mInnerId = ((AbsBaseArticleInfo)localObject).innerUniqueID;
        localReportInfo.mServerContext = ((AbsBaseArticleInfo)localObject).mServerContext;
        localReportInfo.mUin = ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getLongAccountUin();
        localReportInfo.mChannelId = 0;
        localReportInfo.replyUin = j;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(NetConnInfoCenter.getServerTime());
        ((StringBuilder)localObject).append("");
        localReportInfo.replyID = ((StringBuilder)localObject).toString();
        localReportInfo.mSource = 3;
        localReportInfo.mOperation = 57;
        localArrayList.add(localReportInfo);
        j += 1;
      }
      if (localArrayList.size() > 0) {
        ReadInJoyLogicEngine.a().a(localArrayList);
      }
    }
  }
  
  public static void a(List<AbsBaseArticleInfo> paramList, List<Long> paramList1, boolean paramBoolean)
  {
    if (paramList != null)
    {
      if (paramList1 == null) {
        return;
      }
      Collections.sort(paramList, new ReadinjoyReportUtils.2());
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        AbsBaseArticleInfo localAbsBaseArticleInfo = (AbsBaseArticleInfo)paramList.next();
        if (paramList1.contains(Long.valueOf(localAbsBaseArticleInfo.mRecommendSeq)))
        {
          Map localMap = jdField_a_of_type_JavaUtilMap;
          long l2 = localAbsBaseArticleInfo.mArticleID;
          long l3 = jdField_a_of_type_Long;
          long l1 = 1L;
          jdField_a_of_type_Long = l3 + 1L;
          if (!paramBoolean) {
            l1 = 0L;
          }
          localMap.put(Long.valueOf(l2), new Pair(Long.valueOf(l3), Long.valueOf(l1)));
        }
      }
    }
  }
  
  public static void a(AppRuntime paramAppRuntime)
  {
    long l1 = 0L;
    jdField_a_of_type_Long = 0L;
    jdField_a_of_type_JavaUtilMap.clear();
    if (paramAppRuntime != null) {
      l1 = paramAppRuntime.getLongAccountUin();
    }
    long l2 = System.currentTimeMillis();
    paramAppRuntime = new StringBuilder();
    paramAppRuntime.append(String.valueOf(l1));
    paramAppRuntime.append("_");
    paramAppRuntime.append(String.valueOf(l2));
    jdField_a_of_type_JavaLangString = paramAppRuntime.toString();
  }
  
  public static void a(boolean paramBoolean)
  {
    jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public static boolean a(long paramLong)
  {
    return (paramLong == 70L) || (paramLong == 41403L);
  }
  
  public static int b()
  {
    return i;
  }
  
  public static String b(long paramLong)
  {
    if ((!DailyModeConfigHandler.a((int)paramLong)) && (!((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isDailyChildFeeds(paramLong)))
    {
      if (a(paramLong)) {
        return "0X8009355";
      }
      return "0X8007625";
    }
    return "0X8009CC9";
  }
  
  public static void b()
  {
    i = 0;
  }
  
  public static void b(@NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt, boolean paramBoolean, String paramString)
  {
    paramAbsBaseArticleInfo = a(paramAbsBaseArticleInfo, paramInt, paramBoolean, paramString);
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, null, "0X800B1A6", "0X800B1A6", 0, 0, "", "", "", paramAbsBaseArticleInfo.toString(), false);
  }
  
  public static int c()
  {
    if (((IRIJXTabFrameUtils)QRoute.api(IRIJXTabFrameUtils.class)).isNowInKanDianTab()) {
      return jdField_a_of_type_Int;
    }
    if (ReadInJoyDailyFragment.a()) {
      return jdField_b_of_type_Int;
    }
    return c;
  }
  
  public static void c()
  {
    h = 1;
  }
  
  public static void c(AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt, boolean paramBoolean, String paramString)
  {
    if (paramAbsBaseArticleInfo != null) {
      paramString = a(paramAbsBaseArticleInfo, paramInt, paramBoolean, paramString);
    }
    for (;;)
    {
      try
      {
        if (!OnSocialHeaderFollowClickListener.a(paramAbsBaseArticleInfo)) {
          break label82;
        }
        paramInt = 2;
        paramString.put("click_type", paramInt);
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, null, "0X800B1A7", "0X800B1A7", 0, 0, "", "", "", paramString.toString(), false);
        return;
      }
      catch (JSONException paramAbsBaseArticleInfo)
      {
        QLog.d("ReadinjoyReportUtils", 1, paramAbsBaseArticleInfo.getMessage());
      }
      return;
      label82:
      paramInt = 1;
    }
  }
  
  public static void d()
  {
    h = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils
 * JD-Core Version:    0.7.0.1
 */