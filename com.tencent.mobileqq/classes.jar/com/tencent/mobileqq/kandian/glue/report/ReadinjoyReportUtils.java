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
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.biz.common.RIJTabFrameBase;
import com.tencent.mobileqq.kandian.biz.common.RIJTabFrameBase.Companion;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.daily.ReadInJoyDailyFragment;
import com.tencent.mobileqq.kandian.biz.feeds.entity.RedPntInfoForReport;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoReporter;
import com.tencent.mobileqq.kandian.biz.privatechat.api.impl.RIJPrivateChatServiceImpl;
import com.tencent.mobileqq.kandian.biz.privatechat.api.impl.RIJPrivateChatServiceImpl.Companion;
import com.tencent.mobileqq.kandian.biz.pts.listeners.OnSocialHeaderFollowClickListener;
import com.tencent.mobileqq.kandian.biz.push.RIJKanDianFolderStatus;
import com.tencent.mobileqq.kandian.biz.push.api.IKanDianMergeManager;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadinjoySPEventReport;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadinjoySPEventReport.ForeBackGround;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadinjoySPEventReport.UserOptInfo;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyUserInfoModule.RefreshUserInfoCallBack;
import com.tencent.mobileqq.kandian.glue.router.msgbox.api.impl.RIJMsgBoxUtils;
import com.tencent.mobileqq.kandian.repo.account.api.IUserOperationModule;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.DailyModeConfigHandler;
import com.tencent.mobileqq.kandian.repo.common.RIJItemViewTypeUtils;
import com.tencent.mobileqq.kandian.repo.common.RIJShowKanDianTabSp;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoyUserInfoModule;
import com.tencent.mobileqq.kandian.repo.db.struct.BaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FeedsInfoUser;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyUserInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UGCFeedsInfo;
import com.tencent.mobileqq.kandian.repo.reddot.KandianMsgBoxRedPntInfo;
import com.tencent.mobileqq.kandian.repo.report.ReportInfo;
import com.tencent.mobileqq.kandian.repo.report.UserOperationModule;
import com.tencent.mobileqq.kandian.repo.xtab.badge.RIJXTabBadgeStore;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
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
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.AttributeList;

public class ReadinjoyReportUtils
{
  public static int a = 1;
  public static int b = 2;
  public static int c = 1;
  public static int d = 2;
  public static int e = 10;
  public static int f = 11;
  public static int g = 12;
  public static long h = 0L;
  public static String i;
  public static Map<Long, Pair<Long, Long>> j;
  public static final Map<Long, Map<Long, ReadinjoyReportUtils.ExposureReportItem>> k;
  public static volatile int l = 0;
  private static boolean m = true;
  private static boolean n;
  private static int o;
  
  static
  {
    ReadinjoySPEventReport.ForeBackGround.a(new ReadinjoyReportUtils.1());
    h = 0L;
    i = "";
    j = new HashMap();
    k = new HashMap();
    n = true;
    o = 0;
  }
  
  public static int a()
  {
    int i1 = RIJAppSetting.b();
    if (i1 != 1)
    {
      if (i1 != 2)
      {
        if (i1 != 7) {
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
    if (j.containsKey(Long.valueOf(paramLong))) {
      return (Pair)j.get(Long.valueOf(paramLong));
    }
    return null;
  }
  
  public static String a(Context paramContext, int paramInt1, int paramInt2, String paramString1, int paramInt3, int paramInt4, String paramString2)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("network", GalleryReportedUtils.a(paramContext));
      localJSONObject.put("version", VideoReporter.a);
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
      localJSONObject.put("network", GalleryReportedUtils.a(paramContext));
      localJSONObject.put("channel_id", paramInt2);
      localJSONObject.put("version", VideoReporter.a);
      localJSONObject.put("os", "1");
      localJSONObject.put("vid", paramString2);
      localJSONObject.put("rowkey", paramString1);
      localJSONObject.put("algorithm_id", paramLong2);
      localJSONObject.put("feeds_type", paramInt1);
      localJSONObject.put("star_logo", "0");
      localJSONObject.put("is_ugc_as_pgc", paramInt3);
      localJSONObject.put("r_session_id", i);
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
        paramContext = new StringBuilder();
        paramContext.append("readinjoy_daily_article_first_exposure_");
        paramContext.append(paramLong1);
        paramLong1 = ((Long)RIJSPUtils.b(paramContext.toString(), Long.valueOf(0L))).longValue();
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
        break label244;
      }
      if ((paramAbsBaseArticleInfo.msgBoxBriefPreFixType == 2) && (TextUtils.isDigitsOnly(paramAbsBaseArticleInfo.msgBoxBriefPreFix)))
      {
        paramRefreshUserInfoCallBack = ReadInJoyUserInfoModule.a(Long.valueOf(paramAbsBaseArticleInfo.msgBoxBriefPreFix).longValue(), paramRefreshUserInfoCallBack);
        if (paramRefreshUserInfoCallBack == null)
        {
          paramRefreshUserInfoCallBack = new StringBuilder();
          paramRefreshUserInfoCallBack.append(ReadInJoyUserInfoModule.d());
          paramRefreshUserInfoCallBack.append(": ");
          paramRefreshUserInfoCallBack = paramRefreshUserInfoCallBack.toString();
          break label244;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramRefreshUserInfoCallBack.nick);
        localStringBuilder.append(": ");
        paramRefreshUserInfoCallBack = localStringBuilder.toString();
        break label244;
      }
    }
    paramRefreshUserInfoCallBack = null;
    label244:
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
    return EmotionCodecUtils.c(paramAbsBaseArticleInfo);
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
    Map localMap1 = k;
    long l1 = paramInt;
    try
    {
      Map localMap2 = b(l1);
      k.remove(Long.valueOf(l1));
      return localMap2;
    }
    finally {}
  }
  
  public static void a(int paramInt1, int paramInt2, long paramLong, HashMap<String, Object> paramHashMap)
  {
    Object localObject1 = RIJTransMergeKanDianReport.g();
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
    int i2 = 0;
    int i1 = i2;
    if (localObject1 != null)
    {
      i1 = i2;
      if (((AladdinConfig)localObject1).getIntegerFromString("qualityReportSwitch", 0) == 1) {
        i1 = 1;
      }
    }
    if (i1 == 0)
    {
      QLog.i("ReadinjoyReportUtils", 1, "[reportQualityDataDimension] qualityReportSwitch canReport is false.");
      return;
    }
    PublicAccountReportUtils.a(null, "", "0X800ACB9", "0X800ACB9", paramInt2, 0, String.valueOf(paramInt1), String.valueOf(paramLong), "", paramHashMap, false);
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
    boolean bool1 = n;
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
          break label113;
        }
        if (paramInt1 != 1001)
        {
          bool1 = bool2;
          break label113;
        }
      }
      bool1 = paramBoolean;
    }
    label113:
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
    long l1 = 0L;
    if (paramToServiceMsg.extraData != null) {
      l1 = System.currentTimeMillis() - paramToServiceMsg.extraData.getLong("sendtimekey");
    }
    a(paramInt1, paramInt2, l1, paramHashMap);
  }
  
  public static void a(int paramInt, String paramString1, String paramString2, Resources paramResources)
  {
    if ((paramInt == 1008) && (AppConstants.KANDIAN_DAILY_UIN.equals(paramString1)))
    {
      if (Utils.a(paramString2, paramResources.getString(com.tencent.mobileqq.activity.recent.RecentItemBaseBuilder.c[3])))
      {
        PublicAccountReportUtils.a(null, null, "0X8009884", "0X8009884", 0, 0, "", "", "", c(), false);
        return;
      }
      if (Utils.a(paramString2, paramResources.getString(com.tencent.mobileqq.activity.recent.RecentItemBaseBuilder.c[2]))) {
        PublicAccountReportUtils.a(null, null, "0X8009885", "0X8009885", 0, 0, "", "", "", c(), false);
      }
    }
  }
  
  public static void a(int paramInt, String paramString, boolean paramBoolean)
  {
    if ((paramInt == 1008) && (AppConstants.KANDIAN_DAILY_UIN.equals(paramString)))
    {
      if (paramBoolean)
      {
        PublicAccountReportUtils.a(null, null, "0X8009884", "0X8009884", 0, 0, "", "", "", c(), false);
        return;
      }
      PublicAccountReportUtils.a(null, null, "0X8009885", "0X8009885", 0, 0, "", "", "", c(), false);
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
    ReadinjoySPEventReport.a().f.a(paramBoolean1);
    int i1 = 5;
    Object localObject1;
    Object localObject2;
    Object localObject3;
    long l1;
    if (paramBoolean1)
    {
      ReadinjoySPEventReport.t();
      ReadinjoySPEventReport.ForeBackGround.a(4);
      localObject1 = new oidb_cmd0x80a.AttributeList();
      ((oidb_cmd0x80a.AttributeList)localObject1).att_id.set(1);
      ((oidb_cmd0x80a.AttributeList)localObject1).att_name.set("EnterType");
      ((oidb_cmd0x80a.AttributeList)localObject1).att_value.set(c(paramInt1));
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
        ((oidb_cmd0x80a.AttributeList)localObject1).att_value.set(RIJKanDianFolderStatus.RED_PNT_INFO_FOR_REPORT.c);
        localArrayList.add(localObject1);
        localObject1 = new oidb_cmd0x80a.AttributeList();
        ((oidb_cmd0x80a.AttributeList)localObject1).att_id.set(4);
        ((oidb_cmd0x80a.AttributeList)localObject1).att_name.set("AlgorithmID");
        ((oidb_cmd0x80a.AttributeList)localObject1).att_value.set(RIJKanDianFolderStatus.RED_PNT_INFO_FOR_REPORT.b);
        localArrayList.add(localObject1);
        paramLong = NetConnInfoCenter.getServerTime();
        l1 = RIJKanDianFolderStatus.RED_PNT_INFO_FOR_REPORT.f;
        localObject1 = new oidb_cmd0x80a.AttributeList();
        ((oidb_cmd0x80a.AttributeList)localObject1).att_id.set(5);
        ((oidb_cmd0x80a.AttributeList)localObject1).att_name.set("costtime");
        localObject2 = ((oidb_cmd0x80a.AttributeList)localObject1).att_value;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("");
        ((StringBuilder)localObject3).append(paramLong - l1);
        ((PBStringField)localObject2).set(((StringBuilder)localObject3).toString());
        localArrayList.add(localObject1);
      }
      localObject1 = new oidb_cmd0x80a.AttributeList();
      ((oidb_cmd0x80a.AttributeList)localObject1).att_id.set(6);
      ((oidb_cmd0x80a.AttributeList)localObject1).att_name.set("durationBeforeEnter");
      if (ReadinjoySPEventReport.a().u() > 0L)
      {
        paramLong = System.currentTimeMillis();
        l1 = ReadinjoySPEventReport.a().u();
      }
      else
      {
        paramLong = System.currentTimeMillis();
        l1 = ReadinjoySPEventReport.a;
      }
      localObject2 = ((oidb_cmd0x80a.AttributeList)localObject1).att_value;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(paramLong - l1);
      ((StringBuilder)localObject3).append("");
      ((PBStringField)localObject2).set(((StringBuilder)localObject3).toString());
      localArrayList.add(localObject1);
      localObject2 = new oidb_cmd0x80a.AttributeList();
      ((oidb_cmd0x80a.AttributeList)localObject1).att_id.set(7);
      ((oidb_cmd0x80a.AttributeList)localObject1).att_name.set("channelID");
      if (paramInt1 == 7) {
        paramInt2 = RIJXTabBadgeStore.a.c();
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
      ((oidb_cmd0x80a.AttributeList)localObject1).att_value.set(c(paramInt1));
      localArrayList.add(localObject1);
      localObject1 = new oidb_cmd0x80a.AttributeList();
      ((oidb_cmd0x80a.AttributeList)localObject1).att_id.set(2);
      ((oidb_cmd0x80a.AttributeList)localObject1).att_name.set("FolderStatus");
      ((oidb_cmd0x80a.AttributeList)localObject1).att_value.set(String.valueOf(paramInt2));
      localArrayList.add(localObject1);
      localObject1 = new oidb_cmd0x80a.AttributeList();
      ((oidb_cmd0x80a.AttributeList)localObject1).att_id.set(3);
      ((oidb_cmd0x80a.AttributeList)localObject1).att_name.set("Time");
      ((oidb_cmd0x80a.AttributeList)localObject1).att_value.set(String.valueOf(ReadinjoySPEventReport.b(paramLong)));
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
      if (RIJKanDianFolderStatus.RED_PNT_INFO_FOR_REPORT.a != 1)
      {
        localObject1 = new oidb_cmd0x80a.AttributeList();
        ((oidb_cmd0x80a.AttributeList)localObject1).att_id.set(5);
        ((oidb_cmd0x80a.AttributeList)localObject1).att_name.set("StrategyID");
        ((oidb_cmd0x80a.AttributeList)localObject1).att_value.set(RIJKanDianFolderStatus.RED_PNT_INFO_FOR_REPORT.c);
        localArrayList.add(localObject1);
        localObject1 = new oidb_cmd0x80a.AttributeList();
        ((oidb_cmd0x80a.AttributeList)localObject1).att_id.set(6);
        ((oidb_cmd0x80a.AttributeList)localObject1).att_name.set("AlgorithmID");
        ((oidb_cmd0x80a.AttributeList)localObject1).att_value.set(RIJKanDianFolderStatus.RED_PNT_INFO_FOR_REPORT.b);
        localArrayList.add(localObject1);
        paramLong = NetConnInfoCenter.getServerTime();
        l1 = RIJKanDianFolderStatus.RED_PNT_INFO_FOR_REPORT.f;
        localObject1 = new oidb_cmd0x80a.AttributeList();
        ((oidb_cmd0x80a.AttributeList)localObject1).att_id.set(7);
        ((oidb_cmd0x80a.AttributeList)localObject1).att_name.set("costtime");
        localObject2 = ((oidb_cmd0x80a.AttributeList)localObject1).att_value;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("");
        ((StringBuilder)localObject3).append(paramLong - l1);
        ((PBStringField)localObject2).set(((StringBuilder)localObject3).toString());
        localArrayList.add(localObject1);
      }
      localObject1 = ReadinjoySPEventReport.a().g;
      localObject2 = new oidb_cmd0x80a.AttributeList();
      ((oidb_cmd0x80a.AttributeList)localObject2).att_id.set(8);
      ((oidb_cmd0x80a.AttributeList)localObject2).att_name.set("staticDurationAfterEnter");
      if (((ReadinjoySPEventReport.UserOptInfo)localObject1).a > 0L) {
        paramLong = ((ReadinjoySPEventReport.UserOptInfo)localObject1).a - ((ReadinjoySPEventReport.UserOptInfo)localObject1).d;
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
      l1 = ((ReadinjoySPEventReport.UserOptInfo)localObject1).c;
      paramLong = 0L;
      if (l1 > 0L) {
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
      paramInt2 = i1;
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
      paramTemplateBean = b(paramTemplateBean, paramString1, paramString2);
      if (paramTemplateBean == null) {
        return;
      }
      PublicAccountReportUtils.a(null, "CliOper", "", "", paramTemplateBean, paramTemplateBean, 0, 0, "", "", "", localReportR5Builder.build(), false);
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
    UserOperationModule.getInstance().request0x64eUserOperationReport(localArrayList);
  }
  
  public static void a(AppInterface paramAppInterface, MessageForStructing paramMessageForStructing, int paramInt)
  {
    if (paramMessageForStructing == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int i2;
    int i1;
    if (!TextUtils.isEmpty(paramMessageForStructing.structingMsg.mAlgorithmIds))
    {
      localObject = paramMessageForStructing.structingMsg.mAlgorithmIds.split("\\|");
      i2 = localObject.length;
      i1 = 0;
      while (i1 < i2)
      {
        String str1 = localObject[i1];
        try
        {
          localArrayList.add(Integer.valueOf(Integer.parseInt(str1)));
        }
        catch (Exception localException1)
        {
          localException1.printStackTrace();
        }
        i1 += 1;
      }
    }
    Object localObject = new ArrayList();
    if (!TextUtils.isEmpty(paramMessageForStructing.structingMsg.mStrategyIds))
    {
      String[] arrayOfString = paramMessageForStructing.structingMsg.mStrategyIds.split("\\|");
      i2 = arrayOfString.length;
      i1 = 0;
      while (i1 < i2)
      {
        String str2 = arrayOfString[i1];
        try
        {
          ((ArrayList)localObject).add(Integer.valueOf(Integer.parseInt(str2)));
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
        }
        i1 += 1;
      }
    }
    if (!TextUtils.isEmpty(paramMessageForStructing.structingMsg.mMsgActionData))
    {
      paramMessageForStructing = b(paramMessageForStructing.structingMsg.mMsgActionData);
      if (paramMessageForStructing != null) {
        try
        {
          l1 = Long.parseLong(paramMessageForStructing.getString("id"));
        }
        catch (Exception paramMessageForStructing)
        {
          paramMessageForStructing.printStackTrace();
        }
      }
    }
    long l1 = -1L;
    if ((l1 != -1L) && (localArrayList.size() > 0) && (((ArrayList)localObject).size() > 0)) {
      a(paramAppInterface, l1, ((Integer)localArrayList.get(0)).intValue(), ((Integer)((ArrayList)localObject).get(0)).intValue(), paramInt);
    }
  }
  
  public static void a(RecentItemChatMsgData paramRecentItemChatMsgData)
  {
    if (!m) {
      return;
    }
    if ((paramRecentItemChatMsgData != null) && (paramRecentItemChatMsgData.mUser != null) && (AppConstants.KANDIAN_SUBSCRIBE_UIN.equals(paramRecentItemChatMsgData.mUser.uin)))
    {
      m = false;
      ThreadManager.executeOnSubThread(new ReadinjoyReportUtils.4(paramRecentItemChatMsgData));
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    RIJTransMergeKanDianReport.ReportR5Builder localReportR5Builder = new RIJTransMergeKanDianReport.ReportR5Builder();
    localReportR5Builder.addFolderStatus();
    localReportR5Builder.addKandianMode();
    paramQQAppInterface = ((IKanDianMergeManager)paramQQAppInterface.getRuntimeService(IKanDianMergeManager.class)).getUnreadMsgBoxRedPntInfo();
    int i1;
    if (paramQQAppInterface != null)
    {
      i1 = RIJPrivateChatServiceImpl.Companion.a().getTotalRedCount(paramQQAppInterface);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramQQAppInterface.mUin);
      localStringBuilder.append("");
      paramQQAppInterface = localStringBuilder.toString();
    }
    else
    {
      paramQQAppInterface = "";
      i1 = 0;
    }
    if (i1 > 0) {
      try
      {
        localReportR5Builder.addRedDotNum(i1);
      }
      catch (JSONException localJSONException)
      {
        QLog.e("ReadinjoyReportUtils", 2, localJSONException, new Object[0]);
      }
    }
    localReportR5Builder.addStringNotThrow("message_reddot_style", RIJMsgBoxUtils.b());
    String str;
    if (paramBoolean) {
      str = "0X8009A85";
    } else {
      str = "0X8009A84";
    }
    PublicAccountReportUtils.a(null, paramQQAppInterface, str, str, 0, 0, "", "", "", localReportR5Builder.build(), false);
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
  
  public static void a(@NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt, boolean paramBoolean, String paramString1, String paramString2)
  {
    PublicAccountReportUtils.a(null, null, "0X800B1A6", "0X800B1A6", 0, 0, "", "", "", b(paramAbsBaseArticleInfo, paramInt, paramBoolean, paramString1, paramString2).toString(), false);
  }
  
  public static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, long paramLong)
  {
    ??? = new StringBuilder();
    ((StringBuilder)???).append("readinjoy_daily_article_first_exposure_");
    ((StringBuilder)???).append(paramAbsBaseArticleInfo.mArticleID);
    if (((Long)RIJSPUtils.b(((StringBuilder)???).toString(), Long.valueOf(0L))).longValue() == 0L)
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("readinjoy_daily_article_first_exposure_");
      ((StringBuilder)???).append(paramAbsBaseArticleInfo.mArticleID);
      RIJSPUtils.a(((StringBuilder)???).toString(), Long.valueOf(System.currentTimeMillis() / 1000L));
    }
    synchronized (k)
    {
      Map localMap = b(paramAbsBaseArticleInfo.mChannelID);
      ReadinjoyReportUtils.ExposureReportItem localExposureReportItem = (ReadinjoyReportUtils.ExposureReportItem)localMap.get(Long.valueOf(paramAbsBaseArticleInfo.mArticleID));
      if (localExposureReportItem != null)
      {
        long l1 = paramLong;
        if (localExposureReportItem.b > paramLong) {
          l1 = localExposureReportItem.b;
        }
        localExposureReportItem.b = l1;
      }
      else
      {
        localExposureReportItem = new ReadinjoyReportUtils.ExposureReportItem(RIJTransMergeKanDianReport.b());
        localExposureReportItem.a = paramAbsBaseArticleInfo;
        localExposureReportItem.b = paramLong;
        localMap.put(Long.valueOf(paramAbsBaseArticleInfo.mArticleID), localExposureReportItem);
      }
      return;
    }
  }
  
  public static void a(String paramString)
  {
    if (AppConstants.KANDIAN_SUBSCRIBE_UIN.equals(paramString))
    {
      PublicAccountReportUtils.a(null, null, "0X800978D", "0X800978D", 0, 0, "", "", "", c(), false);
      ReadinjoySPEventReport.r();
      return;
    }
    if (AppConstants.KANDIAN_DAILY_UIN.equals(paramString))
    {
      PublicAccountReportUtils.a(null, null, "0X8009886", "0X8009886", 0, 0, "", "", "", c(), false);
      ReadinjoySPEventReport.s();
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
      int i1 = 0;
      while (i1 < paramList.size())
      {
        Object localObject = (AbsBaseArticleInfo)paramList.get(i1);
        ReportInfo localReportInfo = new ReportInfo();
        localReportInfo.mAlgorithmId = ((int)((AbsBaseArticleInfo)localObject).mAlgorithmID);
        localReportInfo.mStrategyId = ((AbsBaseArticleInfo)localObject).mStrategyId;
        localReportInfo.mSourceArticleId = ((AbsBaseArticleInfo)localObject).mArticleID;
        localReportInfo.mInnerId = ((AbsBaseArticleInfo)localObject).innerUniqueID;
        localReportInfo.mServerContext = ((AbsBaseArticleInfo)localObject).mServerContext;
        localReportInfo.mUin = RIJQQAppInterfaceUtil.c();
        localReportInfo.mChannelId = 0;
        localReportInfo.replyUin = i1;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(NetConnInfoCenter.getServerTime());
        ((StringBuilder)localObject).append("");
        localReportInfo.replyID = ((StringBuilder)localObject).toString();
        localReportInfo.mSource = 3;
        localReportInfo.mOperation = 57;
        localArrayList.add(localReportInfo);
        i1 += 1;
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
          Map localMap = j;
          long l2 = localAbsBaseArticleInfo.mArticleID;
          long l3 = h;
          long l1 = 1L;
          h = l3 + 1L;
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
    h = 0L;
    j.clear();
    if (paramAppRuntime != null) {
      l1 = paramAppRuntime.getLongAccountUin();
    }
    long l2 = System.currentTimeMillis();
    paramAppRuntime = new StringBuilder();
    paramAppRuntime.append(String.valueOf(l1));
    paramAppRuntime.append("_");
    paramAppRuntime.append(String.valueOf(l2));
    i = paramAppRuntime.toString();
  }
  
  public static void a(boolean paramBoolean)
  {
    n = paramBoolean;
  }
  
  public static String b(TemplateBean paramTemplateBean, String paramString1, String paramString2)
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
  
  public static Map<Long, ReadinjoyReportUtils.ExposureReportItem> b(long paramLong)
  {
    synchronized (k)
    {
      Map localMap1 = (Map)k.get(Long.valueOf(paramLong));
      Object localObject1 = localMap1;
      if (localMap1 == null)
      {
        localObject1 = new HashMap();
        k.put(Long.valueOf(paramLong), localObject1);
      }
      return localObject1;
    }
  }
  
  public static JSONObject b(AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt, boolean paramBoolean, String paramString1, @Nullable String paramString2)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramAbsBaseArticleInfo != null) {}
    for (;;)
    {
      String str;
      try
      {
        localJSONObject.put("app_type", h());
        localJSONObject.put("channel_id", paramAbsBaseArticleInfo.mChannelID);
        localJSONObject.put("scene_type", paramInt);
        if (!paramBoolean) {
          break label254;
        }
        paramInt = 1;
        localJSONObject.put("is_intensify", paramInt);
        localJSONObject.put("feeds_type", RIJFeedsType.g(paramAbsBaseArticleInfo));
        localJSONObject.put("rowkey", paramAbsBaseArticleInfo.innerUniqueID);
        str = paramAbsBaseArticleInfo.getSubscribeUin();
        SocializeFeedsInfo localSocializeFeedsInfo = paramAbsBaseArticleInfo.mSocialFeedInfo;
        long l2 = 0L;
        if ((localSocializeFeedsInfo == null) || (paramAbsBaseArticleInfo.mSocialFeedInfo.c == null)) {
          break label259;
        }
        l1 = paramAbsBaseArticleInfo.mSocialFeedInfo.c.a;
        if ((paramString2 == null) || (paramString2.length() <= 0)) {
          break label265;
        }
        l1 = l2;
        localJSONObject.put("puin", paramString2);
        localJSONObject.put("ugcuin", l1);
        localJSONObject.put("algorithm_id", paramAbsBaseArticleInfo.mAlgorithmID);
        localJSONObject.put("button_type", paramAbsBaseArticleInfo.showFollowButtonType);
        localJSONObject.put("last_rowkey", paramAbsBaseArticleInfo.mArticleID);
        localJSONObject.put("comment_id", paramString1);
        localJSONObject.put("kandian_mode_new", VideoReporter.c());
        return localJSONObject;
      }
      catch (JSONException paramAbsBaseArticleInfo)
      {
        QLog.d("ReadinjoyReportUtils", 1, paramAbsBaseArticleInfo.getMessage());
      }
      return localJSONObject;
      label254:
      paramInt = 0;
      continue;
      label259:
      long l1 = 0L;
      continue;
      label265:
      paramString2 = str;
    }
  }
  
  public static JSONObject b(String paramString)
  {
    try
    {
      paramString = (JSONObject)new JSONTokener(paramString).nextValue();
      return paramString;
    }
    catch (JSONException|NullPointerException|Exception paramString) {}
    return null;
  }
  
  public static void b()
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
  
  public static void b(int paramInt)
  {
    o = paramInt | o;
    ReadinjoySPEventReport.i(3);
  }
  
  public static void b(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo == null) {
      return;
    }
    String str;
    if ((!RIJItemViewTypeUtils.m(paramAbsBaseArticleInfo)) && (!RIJItemViewTypeUtils.l(paramAbsBaseArticleInfo)) && (!RIJItemViewTypeUtils.n(paramAbsBaseArticleInfo)) && (!RIJItemViewTypeUtils.p(paramAbsBaseArticleInfo))) {
      str = paramAbsBaseArticleInfo.mSubscribeID;
    } else if ((paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.s != null)) {
      str = Long.toString(paramAbsBaseArticleInfo.mSocialFeedInfo.s.e);
    } else {
      str = "";
    }
    long l1 = paramAbsBaseArticleInfo.mFeedId;
    long l2 = paramAbsBaseArticleInfo.mArticleID;
    long l3 = paramAbsBaseArticleInfo.mStrategyId;
    int i1 = RIJItemViewTypeUtils.D(paramAbsBaseArticleInfo);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      RIJTransMergeKanDianReport.a(localJSONObject, paramAbsBaseArticleInfo);
      localJSONObject.put("touin", str);
      localJSONObject.put("entry_mode", String.valueOf(i1));
    }
    catch (Exception paramAbsBaseArticleInfo)
    {
      paramAbsBaseArticleInfo.printStackTrace();
    }
    PublicAccountReportUtils.a(null, "", "0X8009846", "0X8009846", 0, 0, String.valueOf(l1), String.valueOf(l2), String.valueOf(l3), localJSONObject.toString(), false);
  }
  
  public static void b(@NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt, boolean paramBoolean, String paramString)
  {
    a(paramAbsBaseArticleInfo, paramInt, paramBoolean, paramString, null);
  }
  
  public static String c()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("version", VideoReporter.a);
      localJSONObject.put("os", "1");
      localJSONObject.put("channel_id", KandianDailyReportUtils.h());
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return localJSONObject.toString();
  }
  
  private static String c(int paramInt)
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
  
  public static String c(long paramLong)
  {
    if ((!DailyModeConfigHandler.a((int)paramLong)) && (!RIJShowKanDianTabSp.a(paramLong)))
    {
      if (d(paramLong)) {
        return "0X8009356";
      }
      return "0X8009332";
    }
    return "0X8009CCB";
  }
  
  public static String c(AbsBaseArticleInfo paramAbsBaseArticleInfo)
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
  
  public static void c(AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt, boolean paramBoolean, String paramString)
  {
    c(paramAbsBaseArticleInfo, paramInt, paramBoolean, paramString, null);
  }
  
  public static void c(AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt, boolean paramBoolean, String paramString1, @Nullable String paramString2)
  {
    if (paramAbsBaseArticleInfo != null) {
      paramString1 = b(paramAbsBaseArticleInfo, paramInt, paramBoolean, paramString1, paramString2);
    }
    for (;;)
    {
      try
      {
        if (!OnSocialHeaderFollowClickListener.a(paramAbsBaseArticleInfo)) {
          break label72;
        }
        paramInt = 2;
        paramString1.put("click_type", paramInt);
        PublicAccountReportUtils.a(null, null, "0X800B1A7", "0X800B1A7", 0, 0, "", "", "", paramString1.toString(), false);
        return;
      }
      catch (JSONException paramAbsBaseArticleInfo)
      {
        QLog.d("ReadinjoyReportUtils", 1, paramAbsBaseArticleInfo.getMessage());
      }
      return;
      label72:
      paramInt = 1;
    }
  }
  
  public static void d()
  {
    o = 0;
  }
  
  public static boolean d(long paramLong)
  {
    return (paramLong == 70L) || (paramLong == 41403L);
  }
  
  public static int e()
  {
    return o;
  }
  
  public static String e(long paramLong)
  {
    if ((!DailyModeConfigHandler.a((int)paramLong)) && (!RIJShowKanDianTabSp.a(paramLong)))
    {
      if (d(paramLong)) {
        return "0X8009355";
      }
      return "0X8007625";
    }
    return "0X8009CC9";
  }
  
  public static void f()
  {
    l = 1;
  }
  
  public static void g()
  {
    l = 0;
  }
  
  public static int h()
  {
    if (RIJTabFrameBase.d.a()) {
      return a;
    }
    if (ReadInJoyDailyFragment.a()) {
      return b;
    }
    return c;
  }
  
  public static int i()
  {
    return RIJKanDianFolderStatus.reportFolderStatus;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils
 * JD-Core Version:    0.7.0.1
 */