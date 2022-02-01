package com.tencent.mobileqq.kandian.biz.fastweb.util;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcel;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportAction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.ViewBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdEntityConvertService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.ad.api.IRIJFastWebAdReportService;
import com.tencent.mobileqq.kandian.ad.api.IRIJFastWebAdService;
import com.tencent.mobileqq.kandian.base.utils.RIJJsonUtils;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.TimeSliceHelper;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyLauncher;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.fastweb.data.AdData;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.push.RIJKanDianFolderStatus;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.report.GalleryReportedUtils;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5.Builder;
import com.tencent.mobileqq.kandian.glue.viola.ViolaColorNote;
import com.tencent.mobileqq.kandian.repo.aladdin.RIJArticleInteractBarAladdinConfig;
import com.tencent.mobileqq.kandian.repo.aladdin.RIJKanDianFastWebMutualShowTypeAladdinConfig;
import com.tencent.mobileqq.kandian.repo.fastweb.entity.ProteusBookData;
import com.tencent.mobileqq.kandian.repo.fastweb.entity.ProteusRecommendItemData;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.BaseData;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FastWebArticleInfo;
import com.tencent.mobileqq.kandian.repo.pts.entity.ProteusItemData;
import com.tencent.mobileqq.kandian.repo.share.ShareReport;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import com.tencent.widget.AbsListView;
import cooperation.qzone.util.NetworkState;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ReportUtil
{
  private static Map<String, ReportUtil.ScrollReportData> jdField_a_of_type_JavaUtilMap = new HashMap();
  public static final float[] a;
  public static final int[] a;
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString;
  private static final String[] b;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 0, 1, 2, 3 };
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "article_", "interactive_", "recommend_", "comment_" };
    b = new String[] { "_area_body", "_area_interactive", "_area_recommend", "_area_comment" };
    jdField_a_of_type_ArrayOfFloat = new float[] { 4.0F, 4.1F, 8.0F, 2.147484E+009F };
  }
  
  public static int a(int paramInt1, int paramInt2)
  {
    int i = 0;
    if (paramInt1 == 0)
    {
      paramInt1 = i;
      if (paramInt2 == 1) {
        paramInt1 = 1;
      }
      return paramInt1;
    }
    if (paramInt1 == 70)
    {
      if (paramInt2 == 1) {
        return 2;
      }
      return 3;
    }
    return 0;
  }
  
  private static int a(long paramLong)
  {
    int i = (int)paramLong;
    if (i != 0)
    {
      if (i != 56)
      {
        if (i != 70) {
          return 8;
        }
        return 3;
      }
      return 2;
    }
    return 1;
  }
  
  public static long a(boolean paramBoolean, long paramLong)
  {
    if ((!paramBoolean) && (paramLong >= 0L)) {
      return paramLong;
    }
    return -1024L;
  }
  
  private static ReportUtil.ScrollReportData a(String paramString)
  {
    ReportUtil.ScrollReportData localScrollReportData2 = (ReportUtil.ScrollReportData)jdField_a_of_type_JavaUtilMap.get(paramString);
    ReportUtil.ScrollReportData localScrollReportData1 = localScrollReportData2;
    if (localScrollReportData2 == null)
    {
      localScrollReportData1 = new ReportUtil.ScrollReportData(TimeSliceHelper.a(paramString));
      jdField_a_of_type_JavaUtilMap.put(paramString, localScrollReportData1);
    }
    return localScrollReportData1;
  }
  
  public static RIJTransMergeKanDianReport.ReportR5Builder a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    RIJTransMergeKanDianReport.ReportR5Builder localReportR5Builder = new RIJTransMergeKanDianReport.ReportR5Builder();
    localReportR5Builder.addStringNotThrow("folder_status", RIJKanDianFolderStatus.reportFolderStatus);
    localReportR5Builder.addStringNotThrow("feeds_source", paramAbsBaseArticleInfo.mSubscribeID);
    localReportR5Builder.addStringNotThrow("feeds_type", paramAbsBaseArticleInfo.mFeedType);
    localReportR5Builder.addStringNotThrow("kandian_mode", RIJAppSetting.a());
    localReportR5Builder.addStringNotThrow("tab_source", RIJTransMergeKanDianReport.a());
    localReportR5Builder.addStringNotThrow("rowkey", paramAbsBaseArticleInfo.innerUniqueID);
    localReportR5Builder.addStringNotThrow("channel_id", paramAbsBaseArticleInfo.mChannelID);
    return localReportR5Builder;
  }
  
  public static RIJTransMergeKanDianReport.ReportR5Builder a(AbsBaseArticleInfo paramAbsBaseArticleInfo, boolean paramBoolean, long paramLong, int paramInt)
  {
    RIJTransMergeKanDianReport.ReportR5Builder localReportR5Builder = RIJTransMergeKanDianReport.a();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(paramAbsBaseArticleInfo.mAlgorithmID);
    localReportR5Builder.addStringNotThrow("algorithm_id", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(paramAbsBaseArticleInfo.mStrategyId);
    localReportR5Builder.addStringNotThrow("strategy_id", ((StringBuilder)localObject).toString());
    if (paramBoolean) {
      localObject = "2";
    } else {
      localObject = "1";
    }
    localReportR5Builder.addStringNotThrow("feeds_channel_entrance", (String)localObject);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(paramAbsBaseArticleInfo.mArticleID);
    localReportR5Builder.addStringNotThrow("mp_article_id", ((StringBuilder)localObject).toString());
    localReportR5Builder.addStringNotThrow("rowkey", paramAbsBaseArticleInfo.innerUniqueID);
    paramAbsBaseArticleInfo = new StringBuilder();
    paramAbsBaseArticleInfo.append("");
    paramAbsBaseArticleInfo.append(a(paramBoolean, paramLong));
    localReportR5Builder.addStringNotThrow("channel_id", paramAbsBaseArticleInfo.toString());
    if (paramInt != -1) {
      localReportR5Builder.addStringNotThrow("source_extratype", paramInt);
    }
    return localReportR5Builder;
  }
  
  private static VideoR5.Builder a(ColorNote paramColorNote)
  {
    paramColorNote = paramColorNote.getReserve();
    if (paramColorNote == null) {
      return new VideoR5.Builder("");
    }
    StringBuilder localStringBuilder = null;
    try
    {
      Parcel localParcel = Parcel.obtain();
      localParcel.unmarshall(paramColorNote, 0, paramColorNote.length);
      localParcel.setDataPosition(0);
      paramColorNote = new VideoInfo(localParcel);
      try
      {
        localParcel.recycle();
      }
      catch (Exception localException1) {}
      localStringBuilder = new StringBuilder();
    }
    catch (Exception localException2)
    {
      paramColorNote = localStringBuilder;
    }
    localStringBuilder.append("getColorNoteR5ForVideoFeeds: ");
    localStringBuilder.append(localException2.getMessage());
    QLog.e("ReportUtil", 1, localStringBuilder.toString());
    if (paramColorNote == null) {
      return new VideoR5.Builder("");
    }
    return new VideoR5.Builder(paramColorNote).j(paramColorNote.g).n(3).o(paramColorNote.u).O(3);
  }
  
  public static String a(ColorNote paramColorNote)
  {
    if (paramColorNote != null)
    {
      if (paramColorNote.getReserve() == null) {
        return "";
      }
      if (TextUtils.isEmpty(paramColorNote.mSubType)) {
        return "";
      }
      if (paramColorNote.mSubType.startsWith("viola:"))
      {
        paramColorNote = ViolaColorNote.b(paramColorNote);
        if (paramColorNote != null) {
          return paramColorNote.toString();
        }
      }
      else if (paramColorNote.mSubType.startsWith(ReadInJoyLauncher.a))
      {
        return a(paramColorNote).a().a();
      }
    }
    return "";
  }
  
  public static String a(AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < b.length))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramAbsBaseArticleInfo.innerUniqueID);
      localStringBuilder.append(b[paramInt]);
      return localStringBuilder.toString();
    }
    a(paramAbsBaseArticleInfo);
    return paramAbsBaseArticleInfo.innerUniqueID;
  }
  
  public static JSONObject a(TemplateBean paramTemplateBean, String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      paramTemplateBean = new JSONObject(String.valueOf(paramTemplateBean.findViewById(paramString).getDynamicValue("setProteusReportInfo:"))).getJSONObject("info");
      return paramTemplateBean;
    }
    catch (Exception paramTemplateBean) {}
    return localJSONObject;
  }
  
  public static JSONObject a(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        paramJSONObject = paramJSONObject.optJSONObject("card_info");
        localJSONObject.put("source", a(paramAbsBaseArticleInfo.mChannelID));
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("");
        ((StringBuilder)localObject).append(paramAbsBaseArticleInfo.mAlgorithmID);
        localJSONObject.put("algorithm_id", ((StringBuilder)localObject).toString());
        localJSONObject.put("rowkey", paramJSONObject.optString("rowKey"));
        localJSONObject.put("rec_articleid", paramJSONObject.optString("articleID"));
        localJSONObject.put("rec_puin", paramJSONObject.optString("subscribeID"));
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("");
        ((StringBuilder)localObject).append(paramAbsBaseArticleInfo.mArticleID);
        localJSONObject.put("mp_article_id", ((StringBuilder)localObject).toString());
        paramAbsBaseArticleInfo = new StringBuilder();
        paramAbsBaseArticleInfo.append("");
        paramAbsBaseArticleInfo.append(RIJAppSetting.a());
        localJSONObject.put("kandian_mode", paramAbsBaseArticleInfo.toString());
        if (NetworkState.isWifiConn())
        {
          i = 1;
          localJSONObject.put("network_type", i);
          localJSONObject.put("os", "1");
          localJSONObject.put("version", "8.7.0".replace(".", ""));
          localJSONObject.put("imei", ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getIMEIForReport());
          localJSONObject.put("imsi", ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getIMSIForReport());
          localJSONObject.put("rcmInfo", paramJSONObject.optString("rcmInfo"));
          localJSONObject.put("content_type", paramJSONObject.optString("type"));
          paramAbsBaseArticleInfo = new StringBuilder();
          paramAbsBaseArticleInfo.append(HttpUtil.getNetWorkType());
          paramAbsBaseArticleInfo.append("");
          localJSONObject.put("net_type", paramAbsBaseArticleInfo.toString());
          paramAbsBaseArticleInfo = paramJSONObject.optJSONObject("reportInfo").getJSONObject("info");
          if (paramAbsBaseArticleInfo != null)
          {
            paramJSONObject = paramAbsBaseArticleInfo.keys();
            if (paramJSONObject.hasNext())
            {
              localObject = (String)paramJSONObject.next();
              localJSONObject.put((String)localObject, paramAbsBaseArticleInfo.getString((String)localObject));
              continue;
            }
          }
          return localJSONObject;
        }
      }
      catch (Exception paramAbsBaseArticleInfo)
      {
        return localJSONObject;
      }
      int i = 2;
    }
  }
  
  public static void a(long paramLong, AbsBaseArticleInfo paramAbsBaseArticleInfo, FastWebArticleInfo paramFastWebArticleInfo, Context paramContext)
  {
    if (paramAbsBaseArticleInfo != null)
    {
      if (paramFastWebArticleInfo == null) {
        return;
      }
      ThreadManager.getSubThreadHandler().post(new ReportUtil.5(paramContext, paramAbsBaseArticleInfo, paramFastWebArticleInfo, paramLong));
    }
  }
  
  public static void a(Context paramContext, AppInterface paramAppInterface, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    a(paramContext, paramAppInterface, paramAbsBaseArticleInfo, paramInt1, paramInt2, paramBoolean, false);
  }
  
  public static void a(Context paramContext, AppInterface paramAppInterface, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramContext, paramAppInterface, paramAbsBaseArticleInfo, paramInt1, paramInt2, paramBoolean1, paramBoolean2, null);
  }
  
  public static void a(Context paramContext, AppInterface paramAppInterface, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, JSONObject paramJSONObject)
  {
    if (paramAbsBaseArticleInfo != null)
    {
      if (paramAppInterface == null) {
        return;
      }
      int i = a((int)paramAbsBaseArticleInfo.mChannelID, paramAbsBaseArticleInfo.mFeedType);
      paramContext = GalleryReportedUtils.a(paramContext, paramAppInterface.getCurrentAccountUin(), i, paramAbsBaseArticleInfo.mArticleID, paramAbsBaseArticleInfo.innerUniqueID, paramInt1, paramInt2, paramBoolean1, null);
      if (!paramBoolean2) {
        break label134;
      }
      paramInt1 = 1;
    }
    for (;;)
    {
      try
      {
        paramContext.put("is_redpack", paramInt1);
      }
      catch (JSONException paramAppInterface)
      {
        QLog.e("ReportUtil", 1, paramAppInterface.toString());
      }
      RIJJsonUtils.a(paramContext, paramJSONObject);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8009544", "0X8009544", 0, 0, "", String.valueOf(paramAbsBaseArticleInfo.mArticleID), String.valueOf(paramAbsBaseArticleInfo.mAlgorithmID), paramContext.toString(), false);
      return;
      label134:
      paramInt1 = 0;
    }
  }
  
  public static void a(Context paramContext, AppInterface paramAppInterface, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramAbsBaseArticleInfo != null)
    {
      if (paramAppInterface == null) {
        return;
      }
      int i = a((int)paramAbsBaseArticleInfo.mChannelID, paramAbsBaseArticleInfo.mFeedType);
      paramContext = GalleryReportedUtils.a(paramContext, paramAppInterface.getCurrentAccountUin(), i, paramAbsBaseArticleInfo.mArticleID, paramAbsBaseArticleInfo.innerUniqueID, paramInt1, paramInt2, paramBoolean1, Boolean.valueOf(paramBoolean2));
      if (!paramBoolean3) {
        break label151;
      }
      paramInt1 = 1;
    }
    for (;;)
    {
      try
      {
        paramContext.put("is_redpack", paramInt1);
      }
      catch (JSONException paramAppInterface)
      {
        QLog.e("ReportUtil", 1, paramAppInterface.toString());
      }
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800979D", "0X800979D", 0, 0, "", String.valueOf(paramAbsBaseArticleInfo.mArticleID), String.valueOf(paramAbsBaseArticleInfo.mAlgorithmID), paramContext.toString(), false);
      ShareReport.a.a(paramBoolean2);
      if (paramBoolean2) {
        ReadInJoyLogicEngine.a().o();
      }
      return;
      label151:
      paramInt1 = 0;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, AdData paramAdData)
  {
    if ((paramQQAppInterface != null) && (paramAdData != null))
    {
      if (((IRIJFastWebAdService)QRoute.api(IRIJFastWebAdService.class)).isInnerSoftAd(paramAdData)) {
        ((IRIJFastWebAdReportService)QRoute.api(IRIJFastWebAdReportService.class)).report(((IRIJAdEntityConvertService)QRoute.api(IRIJAdEntityConvertService.class)).convertAdData2AdsInfo(paramAdData), 18, 2, 3);
      } else {
        ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).reportNativeEngineInvalidAdExposure(paramQQAppInterface, paramAdData);
      }
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append(" doReportAdInvalidShow ");
      paramQQAppInterface.append(paramAdData.j);
      paramQQAppInterface.append("  : ");
      paramQQAppInterface.append(paramAdData.k);
      QLog.d("Q.readinjoy.fast_web", 2, paramQQAppInterface.toString());
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, AdData paramAdData, float paramFloat, long paramLong, boolean paramBoolean)
  {
    if (paramQQAppInterface != null)
    {
      if (paramAdData == null) {
        return;
      }
      if (((IRIJFastWebAdService)QRoute.api(IRIJFastWebAdService.class)).isInnerSoftAd(paramAdData)) {
        ((IRIJFastWebAdReportService)QRoute.api(IRIJFastWebAdReportService.class)).report(ReportAction.EXPOSE, Integer.valueOf(0), ((IRIJAdEntityConvertService)QRoute.api(IRIJAdEntityConvertService.class)).convertAdData2AdsInfo(paramAdData), 18, 2, 3, paramBoolean);
      } else {
        ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).reportNativeEngineAdExposureExtra(paramQQAppInterface, paramAdData, paramFloat, paramLong, paramBoolean);
      }
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append(" doReportAdShowExtra ");
      paramQQAppInterface.append(paramAdData.j);
      paramQQAppInterface.append("  : ");
      paramQQAppInterface.append(paramAdData.k);
      paramQQAppInterface.append(" exposureArea = ");
      paramQQAppInterface.append(paramFloat);
      paramQQAppInterface.append(" exposureTime = ");
      paramQQAppInterface.append(paramLong);
      QLog.d("Q.readinjoy.fast_web", 2, paramQQAppInterface.toString());
    }
  }
  
  public static void a(ColorNote paramColorNote)
  {
    if (paramColorNote == null) {
      return;
    }
    if (paramColorNote.getServiceType() != 16908290) {
      return;
    }
    if (paramColorNote.mSubType.startsWith(ReadInJoyLauncher.a))
    {
      d(paramColorNote);
      return;
    }
    if (paramColorNote.mSubType.startsWith("viola:"))
    {
      e(paramColorNote);
      return;
    }
    f(paramColorNote);
  }
  
  public static void a(VideoInfo paramVideoInfo)
  {
    if (paramVideoInfo == null) {
      return;
    }
    paramVideoInfo = new VideoR5.Builder(paramVideoInfo).j(paramVideoInfo.g).n(3).o(paramVideoInfo.u).a().a();
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, null, "0X800A731", "0X800A731", 0, 0, "", "", "", paramVideoInfo, false);
  }
  
  private static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("PAGE_AREA_KEY_POSTFIXES", Arrays.toString(b));
      localJSONObject.put("PAGE_AREA_INDICES", Arrays.toString(jdField_a_of_type_ArrayOfInt));
      if (paramAbsBaseArticleInfo != null)
      {
        localJSONObject.put("rowkey", paramAbsBaseArticleInfo.innerUniqueID);
        localJSONObject.put("title", paramAbsBaseArticleInfo.mTitle);
      }
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X800B554", "0X800B554", 0, 0, "", "", "", localJSONObject.toString(), false);
      return;
    }
    catch (Exception paramAbsBaseArticleInfo)
    {
      QLog.e("ReportUtil", 1, "monitorIndexError error, e = ", paramAbsBaseArticleInfo);
    }
  }
  
  public static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt1, int paramInt2, RIJTransMergeKanDianReport.ReportR5Builder paramReportR5Builder)
  {
    int i = BaseApplicationImpl.getApplication().getResources().getDisplayMetrics().widthPixels;
    float f = paramInt1;
    paramInt1 = Utils.px2dp(f);
    i = Utils.px2dp(i);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(paramInt1 * i);
    paramReportR5Builder.addStringNotThrow("read_area", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(Utils.px2dp(paramInt2));
    paramReportR5Builder.addStringNotThrow("article_page", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(Utils.px2dp(f));
    paramReportR5Builder.addStringNotThrow("read_page", ((StringBuilder)localObject).toString());
    localObject = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramAbsBaseArticleInfo.mArticleID);
    ((IPublicAccountReportUtils)localObject).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X8009782", "0X8009782", 0, 0, localStringBuilder.toString(), "", "", paramReportR5Builder.build(), false);
  }
  
  public static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt1, int paramInt2, boolean paramBoolean, long paramLong, int paramInt3)
  {
    if (paramAbsBaseArticleInfo == null) {
      return;
    }
    RIJTransMergeKanDianReport.ReportR5Builder localReportR5Builder = a(paramAbsBaseArticleInfo, paramBoolean, paramLong, paramInt3);
    a(paramAbsBaseArticleInfo, paramInt2, localReportR5Builder);
    a(paramAbsBaseArticleInfo, localReportR5Builder);
    a(paramAbsBaseArticleInfo, paramInt1, paramInt2, localReportR5Builder);
    b(paramAbsBaseArticleInfo, localReportR5Builder);
    c(paramAbsBaseArticleInfo, a(paramAbsBaseArticleInfo, paramBoolean, paramLong, paramInt3));
  }
  
  /* Error */
  public static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt, RIJTransMergeKanDianReport.ReportR5Builder paramReportR5Builder)
  {
    // Byte code:
    //   0: new 674	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 675	java/util/ArrayList:<init>	()V
    //   7: astore 14
    //   9: new 677	tencent/im/oidb/cmd0x80a/oidb_cmd0x80a$AttributeList
    //   12: dup
    //   13: invokespecial 678	tencent/im/oidb/cmd0x80a/oidb_cmd0x80a$AttributeList:<init>	()V
    //   16: astore 18
    //   18: aload 18
    //   20: getfield 682	tencent/im/oidb/cmd0x80a/oidb_cmd0x80a$AttributeList:att_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   23: iconst_1
    //   24: invokevirtual 687	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   27: aload 18
    //   29: getfield 691	tencent/im/oidb/cmd0x80a/oidb_cmd0x80a$AttributeList:att_name	Lcom/tencent/mobileqq/pb/PBStringField;
    //   32: ldc_w 693
    //   35: invokevirtual 697	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   38: aload_0
    //   39: iconst_0
    //   40: invokestatic 699	com/tencent/mobileqq/kandian/biz/fastweb/util/ReportUtil:a	(Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;I)Ljava/lang/String;
    //   43: invokestatic 701	com/tencent/mobileqq/kandian/base/utils/TimeSliceHelper:b	(Ljava/lang/String;)J
    //   46: lstore 7
    //   48: aload 18
    //   50: getfield 704	tencent/im/oidb/cmd0x80a/oidb_cmd0x80a$AttributeList:att_value	Lcom/tencent/mobileqq/pb/PBStringField;
    //   53: lload 7
    //   55: invokestatic 477	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   58: invokevirtual 697	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   61: aload 14
    //   63: aload 18
    //   65: invokeinterface 710 2 0
    //   70: pop
    //   71: new 677	tencent/im/oidb/cmd0x80a/oidb_cmd0x80a$AttributeList
    //   74: dup
    //   75: invokespecial 678	tencent/im/oidb/cmd0x80a/oidb_cmd0x80a$AttributeList:<init>	()V
    //   78: astore 17
    //   80: aload 17
    //   82: getfield 682	tencent/im/oidb/cmd0x80a/oidb_cmd0x80a$AttributeList:att_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   85: iconst_2
    //   86: invokevirtual 687	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   89: aload 17
    //   91: getfield 691	tencent/im/oidb/cmd0x80a/oidb_cmd0x80a$AttributeList:att_name	Lcom/tencent/mobileqq/pb/PBStringField;
    //   94: ldc_w 712
    //   97: invokevirtual 697	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   100: iload_1
    //   101: i2f
    //   102: invokestatic 645	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/utils/Utils:px2dp	(F)I
    //   105: istore_1
    //   106: aload 17
    //   108: getfield 704	tencent/im/oidb/cmd0x80a/oidb_cmd0x80a$AttributeList:att_value	Lcom/tencent/mobileqq/pb/PBStringField;
    //   111: iload_1
    //   112: invokestatic 715	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   115: invokevirtual 697	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   118: aload 14
    //   120: aload 17
    //   122: invokeinterface 710 2 0
    //   127: pop
    //   128: new 677	tencent/im/oidb/cmd0x80a/oidb_cmd0x80a$AttributeList
    //   131: dup
    //   132: invokespecial 678	tencent/im/oidb/cmd0x80a/oidb_cmd0x80a$AttributeList:<init>	()V
    //   135: astore 12
    //   137: aload 12
    //   139: getfield 682	tencent/im/oidb/cmd0x80a/oidb_cmd0x80a$AttributeList:att_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   142: iconst_3
    //   143: invokevirtual 687	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   146: aload 12
    //   148: getfield 691	tencent/im/oidb/cmd0x80a/oidb_cmd0x80a$AttributeList:att_name	Lcom/tencent/mobileqq/pb/PBStringField;
    //   151: ldc_w 717
    //   154: invokevirtual 697	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   157: aload_0
    //   158: getfield 127	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:innerUniqueID	Ljava/lang/String;
    //   161: invokestatic 719	com/tencent/mobileqq/kandian/biz/fastweb/util/ReportUtil:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/kandian/biz/fastweb/util/ReportUtil$ScrollReportData;
    //   164: astore 11
    //   166: aload 11
    //   168: getfield 722	com/tencent/mobileqq/kandian/biz/fastweb/util/ReportUtil$ScrollReportData:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   171: invokeinterface 724 1 0
    //   176: istore 9
    //   178: lconst_0
    //   179: lstore_3
    //   180: lload_3
    //   181: lstore 5
    //   183: iload 9
    //   185: ifne +50 -> 235
    //   188: aload 11
    //   190: getfield 722	com/tencent/mobileqq/kandian/biz/fastweb/util/ReportUtil$ScrollReportData:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   193: invokeinterface 727 1 0
    //   198: astore_0
    //   199: lload_3
    //   200: lstore 5
    //   202: aload_0
    //   203: invokeinterface 416 1 0
    //   208: ifeq +27 -> 235
    //   211: lload_3
    //   212: aload_0
    //   213: invokeinterface 420 1 0
    //   218: checkcast 729	com/tencent/util/Pair
    //   221: getfield 733	com/tencent/util/Pair:first	Ljava/lang/Object;
    //   224: checkcast 735	java/lang/Long
    //   227: invokevirtual 739	java/lang/Long:longValue	()J
    //   230: ladd
    //   231: lstore_3
    //   232: goto -33 -> 199
    //   235: aload 12
    //   237: getfield 704	tencent/im/oidb/cmd0x80a/oidb_cmd0x80a$AttributeList:att_value	Lcom/tencent/mobileqq/pb/PBStringField;
    //   240: lload 5
    //   242: invokestatic 477	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   245: invokevirtual 697	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   248: aload 14
    //   250: aload 12
    //   252: invokeinterface 710 2 0
    //   257: pop
    //   258: new 677	tencent/im/oidb/cmd0x80a/oidb_cmd0x80a$AttributeList
    //   261: dup
    //   262: invokespecial 678	tencent/im/oidb/cmd0x80a/oidb_cmd0x80a$AttributeList:<init>	()V
    //   265: astore 15
    //   267: aload 15
    //   269: getfield 682	tencent/im/oidb/cmd0x80a/oidb_cmd0x80a$AttributeList:att_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   272: iconst_4
    //   273: invokevirtual 687	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   276: aload 15
    //   278: getfield 691	tencent/im/oidb/cmd0x80a/oidb_cmd0x80a$AttributeList:att_name	Lcom/tencent/mobileqq/pb/PBStringField;
    //   281: astore 10
    //   283: ldc_w 741
    //   286: astore_0
    //   287: aload 10
    //   289: ldc_w 741
    //   292: invokevirtual 697	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   295: new 142	java/lang/StringBuilder
    //   298: dup
    //   299: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   302: astore 16
    //   304: aload_0
    //   305: astore 10
    //   307: aload 11
    //   309: getfield 722	com/tencent/mobileqq/kandian/biz/fastweb/util/ReportUtil$ScrollReportData:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   312: invokeinterface 724 1 0
    //   317: ifne +106 -> 423
    //   320: aload 11
    //   322: getfield 722	com/tencent/mobileqq/kandian/biz/fastweb/util/ReportUtil$ScrollReportData:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   325: invokeinterface 727 1 0
    //   330: astore 11
    //   332: aload_0
    //   333: astore 10
    //   335: aload 11
    //   337: invokeinterface 416 1 0
    //   342: ifeq +81 -> 423
    //   345: aload 11
    //   347: invokeinterface 420 1 0
    //   352: checkcast 729	com/tencent/util/Pair
    //   355: astore 10
    //   357: aload 10
    //   359: getfield 744	com/tencent/util/Pair:second	Ljava/lang/Object;
    //   362: checkcast 735	java/lang/Long
    //   365: invokevirtual 739	java/lang/Long:longValue	()J
    //   368: l2f
    //   369: invokestatic 645	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/utils/Utils:px2dp	(F)I
    //   372: i2l
    //   373: lstore_3
    //   374: aload 16
    //   376: aload 10
    //   378: getfield 733	com/tencent/util/Pair:first	Ljava/lang/Object;
    //   381: checkcast 735	java/lang/Long
    //   384: invokevirtual 739	java/lang/Long:longValue	()J
    //   387: ldc2_w 745
    //   390: ldiv
    //   391: invokevirtual 155	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   394: pop
    //   395: aload 16
    //   397: ldc_w 748
    //   400: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   403: pop
    //   404: aload 16
    //   406: lload_3
    //   407: invokevirtual 155	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   410: pop
    //   411: aload 16
    //   413: ldc_w 750
    //   416: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   419: pop
    //   420: goto -88 -> 332
    //   423: aload 15
    //   425: getfield 704	tencent/im/oidb/cmd0x80a/oidb_cmd0x80a$AttributeList:att_value	Lcom/tencent/mobileqq/pb/PBStringField;
    //   428: aload 16
    //   430: invokevirtual 161	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   433: invokevirtual 697	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   436: aload 14
    //   438: aload 15
    //   440: invokeinterface 710 2 0
    //   445: pop
    //   446: invokestatic 753	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   449: ifeq +194 -> 643
    //   452: aload 18
    //   454: getfield 704	tencent/im/oidb/cmd0x80a/oidb_cmd0x80a$AttributeList:att_value	Lcom/tencent/mobileqq/pb/PBStringField;
    //   457: invokevirtual 755	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   460: astore_0
    //   461: ldc_w 757
    //   464: astore 13
    //   466: aload_0
    //   467: ifnull +15 -> 482
    //   470: aload 18
    //   472: getfield 704	tencent/im/oidb/cmd0x80a/oidb_cmd0x80a$AttributeList:att_value	Lcom/tencent/mobileqq/pb/PBStringField;
    //   475: invokevirtual 755	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   478: astore_0
    //   479: goto +7 -> 486
    //   482: ldc_w 757
    //   485: astore_0
    //   486: aload 17
    //   488: getfield 704	tencent/im/oidb/cmd0x80a/oidb_cmd0x80a$AttributeList:att_value	Lcom/tencent/mobileqq/pb/PBStringField;
    //   491: invokevirtual 755	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   494: ifnull +16 -> 510
    //   497: aload 17
    //   499: getfield 704	tencent/im/oidb/cmd0x80a/oidb_cmd0x80a$AttributeList:att_value	Lcom/tencent/mobileqq/pb/PBStringField;
    //   502: invokevirtual 755	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   505: astore 11
    //   507: goto +8 -> 515
    //   510: ldc_w 757
    //   513: astore 11
    //   515: aload 12
    //   517: getfield 704	tencent/im/oidb/cmd0x80a/oidb_cmd0x80a$AttributeList:att_value	Lcom/tencent/mobileqq/pb/PBStringField;
    //   520: invokevirtual 755	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   523: ifnull +16 -> 539
    //   526: aload 12
    //   528: getfield 704	tencent/im/oidb/cmd0x80a/oidb_cmd0x80a$AttributeList:att_value	Lcom/tencent/mobileqq/pb/PBStringField;
    //   531: invokevirtual 755	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   534: astore 12
    //   536: goto +8 -> 544
    //   539: ldc_w 757
    //   542: astore 12
    //   544: aload 15
    //   546: getfield 704	tencent/im/oidb/cmd0x80a/oidb_cmd0x80a$AttributeList:att_value	Lcom/tencent/mobileqq/pb/PBStringField;
    //   549: invokevirtual 755	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   552: ifnull +13 -> 565
    //   555: aload 15
    //   557: getfield 704	tencent/im/oidb/cmd0x80a/oidb_cmd0x80a$AttributeList:att_value	Lcom/tencent/mobileqq/pb/PBStringField;
    //   560: invokevirtual 755	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   563: astore 13
    //   565: ldc_w 542
    //   568: iconst_2
    //   569: bipush 11
    //   571: anewarray 4	java/lang/Object
    //   574: dup
    //   575: iconst_0
    //   576: ldc_w 759
    //   579: aastore
    //   580: dup
    //   581: iconst_1
    //   582: aload_0
    //   583: aastore
    //   584: dup
    //   585: iconst_2
    //   586: ldc_w 761
    //   589: aastore
    //   590: dup
    //   591: iconst_3
    //   592: ldc_w 763
    //   595: aastore
    //   596: dup
    //   597: iconst_4
    //   598: aload 11
    //   600: aastore
    //   601: dup
    //   602: iconst_5
    //   603: ldc_w 765
    //   606: aastore
    //   607: dup
    //   608: bipush 6
    //   610: ldc_w 767
    //   613: aastore
    //   614: dup
    //   615: bipush 7
    //   617: aload 12
    //   619: aastore
    //   620: dup
    //   621: bipush 8
    //   623: ldc_w 761
    //   626: aastore
    //   627: dup
    //   628: bipush 9
    //   630: ldc_w 769
    //   633: aastore
    //   634: dup
    //   635: bipush 10
    //   637: aload 13
    //   639: aastore
    //   640: invokestatic 772	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   643: sipush 201
    //   646: aload 14
    //   648: invokestatic 777	com/tencent/mobileqq/kandian/glue/report/ReadinjoyReportUtils:a	(ILjava/util/List;)V
    //   651: aload_2
    //   652: ldc_w 693
    //   655: lload 7
    //   657: invokestatic 477	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   660: invokevirtual 780	com/tencent/mobileqq/kandian/glue/report/RIJTransMergeKanDianReport$ReportR5Builder:addString	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mobileqq/kandian/glue/report/RIJTransMergeKanDianReport$ReportR5Builder;
    //   663: pop
    //   664: aload_2
    //   665: ldc_w 712
    //   668: iload_1
    //   669: invokestatic 715	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   672: invokevirtual 780	com/tencent/mobileqq/kandian/glue/report/RIJTransMergeKanDianReport$ReportR5Builder:addString	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mobileqq/kandian/glue/report/RIJTransMergeKanDianReport$ReportR5Builder;
    //   675: pop
    //   676: aload_2
    //   677: ldc_w 717
    //   680: lload 5
    //   682: invokestatic 477	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   685: invokevirtual 780	com/tencent/mobileqq/kandian/glue/report/RIJTransMergeKanDianReport$ReportR5Builder:addString	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mobileqq/kandian/glue/report/RIJTransMergeKanDianReport$ReportR5Builder;
    //   688: pop
    //   689: aload_2
    //   690: aload 10
    //   692: aload 16
    //   694: invokevirtual 161	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   697: invokevirtual 780	com/tencent/mobileqq/kandian/glue/report/RIJTransMergeKanDianReport$ReportR5Builder:addString	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mobileqq/kandian/glue/report/RIJTransMergeKanDianReport$ReportR5Builder;
    //   700: pop
    //   701: goto +20 -> 721
    //   704: astore_0
    //   705: goto +5 -> 710
    //   708: astore 10
    //   710: ldc_w 542
    //   713: iconst_1
    //   714: ldc_w 782
    //   717: aload_0
    //   718: invokestatic 617	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   721: ldc_w 472
    //   724: invokestatic 384	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   727: checkcast 472	com/tencent/mobileqq/kandian/biz/common/api/IPublicAccountReportUtils
    //   730: aconst_null
    //   731: ldc 145
    //   733: ldc_w 784
    //   736: ldc_w 784
    //   739: iconst_0
    //   740: iconst_0
    //   741: ldc 145
    //   743: ldc 145
    //   745: ldc 145
    //   747: aload_2
    //   748: invokevirtual 656	com/tencent/mobileqq/kandian/glue/report/RIJTransMergeKanDianReport$ReportR5Builder:build	()Ljava/lang/String;
    //   751: iconst_0
    //   752: invokeinterface 481 12 0
    //   757: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	758	0	paramAbsBaseArticleInfo	AbsBaseArticleInfo
    //   0	758	1	paramInt	int
    //   0	758	2	paramReportR5Builder	RIJTransMergeKanDianReport.ReportR5Builder
    //   179	228	3	l1	long
    //   181	500	5	l2	long
    //   46	610	7	l3	long
    //   176	8	9	bool	boolean
    //   281	410	10	localObject1	Object
    //   164	435	11	localObject2	Object
    //   135	483	12	localObject3	Object
    //   464	174	13	str	String
    //   7	640	14	localArrayList	java.util.ArrayList
    //   265	291	15	localAttributeList1	tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.AttributeList
    //   302	391	16	localStringBuilder	StringBuilder
    //   78	420	17	localAttributeList2	tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.AttributeList
    //   16	455	18	localAttributeList3	tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.AttributeList
    // Exception table:
    //   from	to	target	type
    //   651	701	704	org/json/JSONException
  }
  
  public static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, long paramLong1, long paramLong2, RIJTransMergeKanDianReport.ReportR5Builder paramReportR5Builder)
  {
    if (paramAbsBaseArticleInfo == null) {
      return;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("");
    ((StringBuilder)localObject1).append(paramLong1 / 1000L);
    paramReportR5Builder.addStringNotThrow("read_duration", ((StringBuilder)localObject1).toString());
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("");
    ((StringBuilder)localObject1).append(paramLong2 / 1000L);
    paramReportR5Builder.addStringNotThrow("read_begin_timestamp", ((StringBuilder)localObject1).toString());
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("");
    ((StringBuilder)localObject1).append(NetConnInfoCenter.getServerTime());
    paramReportR5Builder.addStringNotThrow("read_end_timestamp", ((StringBuilder)localObject1).toString());
    localObject1 = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("");
    ((StringBuilder)localObject2).append(paramAbsBaseArticleInfo.mSubscribeID);
    localObject2 = ((StringBuilder)localObject2).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramAbsBaseArticleInfo.mArticleID);
    ((IPublicAccountReportUtils)localObject1).publicAccountReportClickEventForMigrate(null, "CliOper", "", (String)localObject2, "0X8009781", "0X8009781", 0, 0, localStringBuilder.toString(), "", "", paramReportR5Builder.build(), false);
  }
  
  public static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, RIJTransMergeKanDianReport.ReportR5Builder paramReportR5Builder)
  {
    if (paramAbsBaseArticleInfo != null)
    {
      a(paramAbsBaseArticleInfo, TimeSliceHelper.b(paramAbsBaseArticleInfo.innerUniqueID), TimeSliceHelper.a(paramAbsBaseArticleInfo.innerUniqueID), paramReportR5Builder);
      TimeSliceHelper.a(paramAbsBaseArticleInfo.innerUniqueID);
    }
  }
  
  public static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, BaseData paramBaseData)
  {
    if (paramBaseData.u != 6) {
      return;
    }
    try
    {
      paramBaseData = (ProteusRecommendItemData)paramBaseData;
      JSONObject localJSONObject1 = a(paramAbsBaseArticleInfo, paramBaseData.c);
      JSONObject localJSONObject2 = paramBaseData.c;
      Object localObject = localJSONObject2.optJSONObject("card_info").optJSONObject("reportInfo");
      String str = ((JSONObject)localObject).optString("location_exposure_T");
      localObject = ((JSONObject)localObject).getString("article_exposure_T");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(paramBaseData.a);
      localJSONObject1.put("rec_location", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(paramBaseData.jdField_b_of_type_Int);
      localJSONObject1.put("rec_total", localStringBuilder.toString());
      localJSONObject1.put("ad", "0");
      localJSONObject1.put("rec_type", localJSONObject2.optInt("recommend_type"));
      a(paramAbsBaseArticleInfo, str, localJSONObject1.toString());
      a(paramAbsBaseArticleInfo, (String)localObject, localJSONObject1.toString());
      return;
    }
    catch (Exception paramAbsBaseArticleInfo) {}
  }
  
  public static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, FastWebArticleInfo paramFastWebArticleInfo, Context paramContext)
  {
    if (paramAbsBaseArticleInfo != null)
    {
      if (paramFastWebArticleInfo == null) {
        return;
      }
      ThreadManager.getSubThreadHandler().post(new ReportUtil.4(paramContext, paramAbsBaseArticleInfo, paramFastWebArticleInfo));
    }
  }
  
  public static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, String paramString1, String paramString2)
  {
    IPublicAccountReportUtils localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
    String str = paramAbsBaseArticleInfo.mSubscribeID;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramAbsBaseArticleInfo.mArticleID);
    ((StringBuilder)localObject).append("");
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramAbsBaseArticleInfo.mAlgorithmID);
    localStringBuilder.append("");
    localIPublicAccountReportUtils.publicAccountReportClickEventForMigrate(null, "CliOper", "", str, paramString1, paramString1, 0, 0, (String)localObject, localStringBuilder.toString(), paramAbsBaseArticleInfo.innerUniqueID, paramString2, false);
  }
  
  public static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, String paramString, JSONObject paramJSONObject)
  {
    if ((paramAbsBaseArticleInfo != null) && (paramJSONObject != null))
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", paramString, paramString, 0, 0, String.valueOf(paramAbsBaseArticleInfo.mArticleID), String.valueOf(paramAbsBaseArticleInfo.mStrategyId), paramAbsBaseArticleInfo.innerUniqueID, paramJSONObject.toString(), false);
    }
  }
  
  public static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, List<BaseData> paramList)
  {
    if (paramList == null) {
      return;
    }
    paramList = paramList.iterator();
    int j = 0;
    int i = 0;
    while (paramList.hasNext())
    {
      Object localObject = (BaseData)paramList.next();
      if ((localObject instanceof ProteusItemData))
      {
        localObject = (ProteusItemData)localObject;
        if (((ProteusItemData)localObject).A == 1)
        {
          int k = ((ProteusItemData)localObject).z;
          if (k != 2)
          {
            if (k == 3) {
              i += 1;
            }
          }
          else {
            j += 1;
          }
        }
      }
    }
    paramList = new HashMap();
    paramList.put("rowkey", paramAbsBaseArticleInfo.innerUniqueID);
    paramList.put("url", paramAbsBaseArticleInfo.mArticleContentUrl);
    paramAbsBaseArticleInfo = new StringBuilder();
    paramAbsBaseArticleInfo.append("");
    paramAbsBaseArticleInfo.append(j);
    paramList.put("imgCount", paramAbsBaseArticleInfo.toString());
    paramAbsBaseArticleInfo = new StringBuilder();
    paramAbsBaseArticleInfo.append("");
    paramAbsBaseArticleInfo.append(i);
    paramList.put("videoCount", paramAbsBaseArticleInfo.toString());
    paramList.put("textCount", "-1");
    paramList.put("param_uin", RIJQQAppInterfaceUtil.a());
    StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(null, "actKandianFastWebItemCount", true, 0L, 0L, paramList, null);
  }
  
  public static void a(BaseData paramBaseData)
  {
    if (paramBaseData == null) {
      return;
    }
    if (paramBaseData.u == 18) {
      a(paramBaseData, "0X800974A");
    }
    if ((paramBaseData instanceof ProteusItemData))
    {
      paramBaseData = (ProteusItemData)paramBaseData;
      a(paramBaseData.c);
      b(paramBaseData.c);
    }
  }
  
  public static void a(BaseData paramBaseData, String paramString)
  {
    if ((paramBaseData != null) && (paramBaseData.a != null))
    {
      if (paramBaseData.jdField_b_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo == null) {
        return;
      }
      if ((paramBaseData instanceof ProteusBookData))
      {
        Object localObject2 = (ProteusBookData)paramBaseData;
        Object localObject1 = paramBaseData.a;
        paramBaseData = paramBaseData.jdField_b_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
        RIJTransMergeKanDianReport.ReportR5Builder localReportR5Builder = new RIJTransMergeKanDianReport.ReportR5Builder();
        localReportR5Builder.addStringNotThrow("card_source", ((ProteusBookData)localObject2).c);
        localReportR5Builder.addStringNotThrow("topic_id", ((ProteusBookData)localObject2).d);
        localReportR5Builder.addStringNotThrow("source_id", ((ProteusBookData)localObject2).e);
        localObject2 = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("");
        ((StringBuilder)localObject3).append(((FastWebArticleInfo)localObject1).e);
        localObject3 = ((StringBuilder)localObject3).toString();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(((FastWebArticleInfo)localObject1).o);
        localStringBuilder.append("");
        localObject1 = localStringBuilder.toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramBaseData.mAlgorithmID);
        localStringBuilder.append("");
        ((IPublicAccountReportUtils)localObject2).publicAccountReportClickEventForMigrate(null, "CliOper", "", (String)localObject3, paramString, paramString, 0, 0, (String)localObject1, localStringBuilder.toString(), paramBaseData.innerUniqueID, localReportR5Builder.build(), false);
      }
    }
  }
  
  public static void a(AbsListView paramAbsListView, int paramInt1, String paramString, int paramInt2, boolean paramBoolean)
  {
    if (paramString == null) {
      return;
    }
    paramAbsListView = a(paramString);
    if (paramInt1 == 0)
    {
      paramAbsListView.b(paramInt2, paramBoolean);
      return;
    }
    paramAbsListView.a(paramInt2, paramBoolean);
  }
  
  private static void a(String paramString)
  {
    jdField_a_of_type_JavaUtilMap.remove(paramString);
  }
  
  public static void a(String paramString, ProteusRecommendItemData paramProteusRecommendItemData, JSONObject paramJSONObject)
  {
    if (paramProteusRecommendItemData != null) {
      if (paramProteusRecommendItemData.jdField_b_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo == null) {
        return;
      }
    }
    try
    {
      JSONObject localJSONObject = paramProteusRecommendItemData.c;
      String str = localJSONObject.optJSONObject("card_info").optJSONObject("reportInfo").getString("click_T");
      if (TextUtils.isEmpty(str)) {
        return;
      }
      localJSONObject = a(paramProteusRecommendItemData.jdField_b_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, localJSONObject);
      b(localJSONObject, paramJSONObject);
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("");
      paramJSONObject.append(paramProteusRecommendItemData.a);
      localJSONObject.put("rec_location", paramJSONObject.toString());
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("");
      paramJSONObject.append(paramProteusRecommendItemData.jdField_b_of_type_Int);
      localJSONObject.put("rec_total", paramJSONObject.toString());
      localJSONObject.put("ad", "0");
      localJSONObject.put("click_area", paramString);
      localJSONObject.put("rec_type", paramProteusRecommendItemData.c.optInt("recommend_type"));
      a(paramProteusRecommendItemData.jdField_b_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, str, localJSONObject.toString());
      return;
    }
    catch (Exception paramString) {}
  }
  
  public static void a(String paramString, JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    if (paramJSONObject1 == null) {
      return;
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject1 = paramJSONObject1.optJSONObject("card_info");
        JSONObject localJSONObject2 = localJSONObject1.optJSONObject("reportInfo");
        Object localObject = localJSONObject2.getString("click_T");
        localJSONObject2 = new JSONObject(localJSONObject2.getString("info"));
        a(localJSONObject1, localJSONObject2);
        localJSONObject2.put("click_area", paramString);
        b(localJSONObject2, paramJSONObject2);
        if (RIJArticleInteractBarAladdinConfig.b())
        {
          i = 1;
          localJSONObject2.put("ad_relative_pos", i);
          paramString = new RIJTransMergeKanDianReport.ReportR5Builder(localJSONObject2);
          paramString.addKandianMode();
          paramString = paramString.build();
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", (String)localObject, (String)localObject, 0, 0, "", "", "", paramString, false);
          if ("0X800983F".equals(localObject))
          {
            if (!paramJSONObject1.has("kdschSessionId"))
            {
              paramString = new StringBuilder();
              paramString.append(((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getCurrentAccountUin());
              paramString.append(System.currentTimeMillis());
              paramJSONObject1.put("kdschSessionId", paramString.toString());
            }
            paramString = new ReportModelDC02528().module("all_search").action("clk_jingtan_list").obj1("2049").ver2("kandian").ver4(paramJSONObject2.getString("searchWord")).ver6(localJSONObject1.getString("articleRowKey"));
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("{\"scroe\":\"");
            ((StringBuilder)localObject).append(paramJSONObject2.getString("score"));
            ((StringBuilder)localObject).append("\",\"title\":\"");
            ((StringBuilder)localObject).append(localJSONObject1.getString("articleTitle"));
            ((StringBuilder)localObject).append("\",\"position\":\"");
            ((StringBuilder)localObject).append(paramJSONObject2.getString("position"));
            ((StringBuilder)localObject).append("\"}");
            UniteSearchReportController.a(null, paramString.ver7(((StringBuilder)localObject).toString()).session_id(paramJSONObject1.getString("kdschSessionId")));
          }
          return;
        }
      }
      catch (Exception paramString)
      {
        return;
      }
      int i = 0;
    }
  }
  
  public static void a(List<ColorNote> paramList)
  {
    if (paramList == null) {
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ColorNote localColorNote = (ColorNote)paramList.next();
      if (localColorNote.getServiceType() == 16908290) {
        a(localColorNote);
      }
    }
  }
  
  public static void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = paramJSONObject.optJSONObject("card_info");
        Object localObject2 = localJSONObject.optJSONObject("reportInfo");
        Object localObject1 = ((JSONObject)localObject2).getString("exposure_T");
        localObject2 = new JSONObject(((JSONObject)localObject2).getString("info"));
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          return;
        }
        a(localJSONObject, (JSONObject)localObject2);
        if (RIJArticleInteractBarAladdinConfig.b())
        {
          i = 1;
          ((JSONObject)localObject2).put("ad_relative_pos", i);
          Object localObject3 = new RIJTransMergeKanDianReport.ReportR5Builder((JSONObject)localObject2);
          ((RIJTransMergeKanDianReport.ReportR5Builder)localObject3).addKandianMode();
          localObject3 = ((RIJTransMergeKanDianReport.ReportR5Builder)localObject3).build();
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", (String)localObject1, (String)localObject1, 0, 0, "", "", "", (String)localObject3, false);
          if ("0X8009857".equals(localObject1))
          {
            localObject2 = ((JSONObject)localObject2).getJSONArray("searchWords");
            localObject1 = "";
            i = 0;
            if (i < ((JSONArray)localObject2).length())
            {
              localObject3 = ((JSONArray)localObject2).getJSONObject(i);
              boolean bool = TextUtils.isEmpty((CharSequence)localObject1);
              if (bool)
              {
                localStringBuilder = new StringBuilder();
                localStringBuilder.append((String)localObject1);
                localStringBuilder.append(((JSONObject)localObject3).getString("searchWord"));
                localObject1 = localStringBuilder.toString();
                break label456;
              }
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append((String)localObject1);
              localStringBuilder.append("::");
              localStringBuilder.append(((JSONObject)localObject3).getString("searchWord"));
              localObject1 = localStringBuilder.toString();
              break label456;
            }
            if (!paramJSONObject.has("kdschSessionId"))
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append(((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getCurrentAccountUin());
              ((StringBuilder)localObject2).append(System.currentTimeMillis());
              paramJSONObject.put("kdschSessionId", ((StringBuilder)localObject2).toString());
            }
            localObject1 = new ReportModelDC02528().module("all_search").action("exp_jingtan_list").obj1("2049").ver2("kandian").ver4((String)localObject1).ver6(localJSONObject.getString("articleRowKey"));
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("{\"title\":\"");
            ((StringBuilder)localObject2).append(localJSONObject.getString("articleTitle"));
            ((StringBuilder)localObject2).append("\"}");
            UniteSearchReportController.a(null, ((ReportModelDC02528)localObject1).ver7(((StringBuilder)localObject2).toString()).session_id(paramJSONObject.getString("kdschSessionId")));
          }
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        return;
      }
      int i = 0;
      continue;
      label456:
      i += 1;
    }
  }
  
  public static void a(JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    try
    {
      paramJSONObject2.put("articleRowKey", paramJSONObject1.optString("articleRowKey"));
      paramJSONObject2.put("channel_id", paramJSONObject1.get("channelID"));
      paramJSONObject2.put("articleTitle", paramJSONObject1.get("articleTitle"));
      return;
    }
    catch (Exception paramJSONObject1) {}
  }
  
  public static boolean a(BaseData paramBaseData)
  {
    return paramBaseData.u == 18;
  }
  
  public static void b(Context paramContext, AppInterface paramAppInterface, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramContext, paramAppInterface, paramAbsBaseArticleInfo, paramInt1, paramInt2, paramBoolean1, paramBoolean2, false);
  }
  
  public static void b(ColorNote paramColorNote)
  {
    paramColorNote = ViolaColorNote.b(paramColorNote);
    if (paramColorNote != null)
    {
      if (paramColorNote.length() == 0) {
        return;
      }
      paramColorNote = new VideoR5.Builder(paramColorNote.toString()).a().a();
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, null, "0X800A731", "0X800A731", 0, 0, "", "", "", paramColorNote, false);
    }
  }
  
  public static void b(AbsBaseArticleInfo paramAbsBaseArticleInfo, RIJTransMergeKanDianReport.ReportR5Builder paramReportR5Builder)
  {
    ReportUtil.ScrollReportData localScrollReportData = a(paramAbsBaseArticleInfo.innerUniqueID);
    if (localScrollReportData.a.isEmpty()) {
      return;
    }
    paramReportR5Builder.addOS();
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("");
    ((StringBuilder)localObject1).append(localScrollReportData.jdField_b_of_type_Long / 1000L);
    paramReportR5Builder.addStringNotThrow("read_begin_timestamp", ((StringBuilder)localObject1).toString());
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("");
    ((StringBuilder)localObject1).append(localScrollReportData.c / 1000L);
    paramReportR5Builder.addStringNotThrow("read_end_timestamp", ((StringBuilder)localObject1).toString());
    Iterator localIterator = localScrollReportData.a.iterator();
    long l = 0L;
    for (localObject1 = ""; localIterator.hasNext(); localObject1 = ((StringBuilder)localObject1).toString())
    {
      Pair localPair = (Pair)localIterator.next();
      localObject2 = localObject1;
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(",");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      l += Math.abs(((Long)localPair.first).longValue());
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append(localPair.first);
      ((StringBuilder)localObject1).append("_");
      ((StringBuilder)localObject1).append(localPair.second);
    }
    paramReportR5Builder.addStringNotThrow("read_speed_array", (String)localObject1);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("");
    ((StringBuilder)localObject1).append(l / localScrollReportData.a.size());
    paramReportR5Builder.addStringNotThrow("avg_speed", ((StringBuilder)localObject1).toString());
    localObject1 = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("");
    ((StringBuilder)localObject2).append(paramAbsBaseArticleInfo.mArticleID);
    ((IPublicAccountReportUtils)localObject1).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X8009783", "0X8009783", 0, 0, ((StringBuilder)localObject2).toString(), "", "", paramReportR5Builder.build(), false);
    a(paramAbsBaseArticleInfo.innerUniqueID);
  }
  
  public static void b(AbsBaseArticleInfo paramAbsBaseArticleInfo, String paramString1, String paramString2)
  {
    if (paramAbsBaseArticleInfo == null) {
      return;
    }
    for (;;)
    {
      try
      {
        RIJTransMergeKanDianReport.ReportR5Builder localReportR5Builder = a(paramAbsBaseArticleInfo);
        localReportR5Builder.addStringNotThrow("source_from", paramString2);
        if (!RIJArticleInteractBarAladdinConfig.a()) {
          break label113;
        }
        i = 1;
        localReportR5Builder.addStringNotThrow("artical_interact_area", i);
        localReportR5Builder.addStringNotThrow("artical_interact_type", RIJKanDianFastWebMutualShowTypeAladdinConfig.a());
        paramString2 = localReportR5Builder.build();
      }
      catch (Exception paramString2)
      {
        paramString2.printStackTrace();
        paramString2 = "";
      }
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, paramAbsBaseArticleInfo.mSubscribeID, paramString1, paramString1, 0, 0, String.valueOf(paramAbsBaseArticleInfo.mFeedId), String.valueOf(paramAbsBaseArticleInfo.mArticleID), "", paramString2, false);
      return;
      label113:
      int i = 0;
    }
  }
  
  public static void b(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    for (;;)
    {
      try
      {
        paramJSONObject = paramJSONObject.optJSONObject("card_info");
        JSONObject localJSONObject = new JSONObject(paramJSONObject.optJSONObject("reportInfo").getString("info"));
        a(paramJSONObject, localJSONObject);
        if (RIJArticleInteractBarAladdinConfig.b())
        {
          i = 1;
          localJSONObject.put("ad_relative_pos", i);
          paramJSONObject = new RIJTransMergeKanDianReport.ReportR5Builder(localJSONObject);
          paramJSONObject.addKandianMode();
          paramJSONObject = paramJSONObject.build();
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8009A7D", "0X8009A7D", 0, 0, "", "", "", paramJSONObject, false);
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        return;
      }
      int i = 0;
    }
  }
  
  public static void b(JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    if (paramJSONObject1 != null) {
      if (paramJSONObject2 == null) {
        return;
      }
    }
    try
    {
      Iterator localIterator = paramJSONObject2.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        paramJSONObject1.put(str, paramJSONObject2.getString(str));
      }
      return;
    }
    catch (Exception paramJSONObject1) {}
  }
  
  public static void c(ColorNote paramColorNote) {}
  
  private static void c(AbsBaseArticleInfo paramAbsBaseArticleInfo, RIJTransMergeKanDianReport.ReportR5Builder paramReportR5Builder)
  {
    try
    {
      paramReportR5Builder.addFolderStatus().addKandianMode();
      Object localObject1 = jdField_a_of_type_ArrayOfInt;
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        localObject2 = Integer.valueOf(localObject1[i]);
        localObject3 = a(paramAbsBaseArticleInfo, ((Integer)localObject2).intValue());
        long l = TimeSliceHelper.b((String)localObject3);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(jdField_a_of_type_ArrayOfJavaLangString[localObject2.intValue()]);
        localStringBuilder.append("_duration_millis");
        paramReportR5Builder.addStringNotThrow(localStringBuilder.toString(), l);
        TimeSliceHelper.a((String)localObject3);
        i += 1;
      }
      localObject1 = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("");
      ((StringBuilder)localObject2).append(paramAbsBaseArticleInfo.mSubscribeID);
      localObject2 = ((StringBuilder)localObject2).toString();
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("");
      ((StringBuilder)localObject3).append(paramAbsBaseArticleInfo.mArticleID);
      ((IPublicAccountReportUtils)localObject1).publicAccountReportClickEventForMigrate(null, "CliOper", "", (String)localObject2, "0X80099D2", "0X80099D2", 0, 0, "", ((StringBuilder)localObject3).toString(), "", paramReportR5Builder.build(), false);
      return;
    }
    catch (Exception paramAbsBaseArticleInfo)
    {
      QLog.e("ReportUtil", 1, "reportPageAreaExposure error, e = ", paramAbsBaseArticleInfo);
    }
  }
  
  private static void d(ColorNote paramColorNote)
  {
    byte[] arrayOfByte = paramColorNote.getReserve();
    if (arrayOfByte == null) {
      return;
    }
    long l = paramColorNote.mTime;
    ThreadManager.getSubThreadHandler().post(new ReportUtil.1(arrayOfByte, l));
  }
  
  private static void e(ColorNote paramColorNote)
  {
    if (paramColorNote != null)
    {
      if (paramColorNote.getReserve() == null) {
        return;
      }
      long l = paramColorNote.mTime;
      ThreadManager.getSubThreadHandler().post(new ReportUtil.2(paramColorNote, l));
    }
  }
  
  private static void f(ColorNote paramColorNote)
  {
    byte[] arrayOfByte = paramColorNote.getReserve();
    if (arrayOfByte == null) {
      return;
    }
    long l = paramColorNote.mTime;
    ThreadManager.getSubThreadHandler().post(new ReportUtil.3(arrayOfByte, l));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.util.ReportUtil
 * JD-Core Version:    0.7.0.1
 */