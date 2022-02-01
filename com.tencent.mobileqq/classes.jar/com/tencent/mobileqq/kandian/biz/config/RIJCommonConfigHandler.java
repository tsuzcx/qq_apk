package com.tencent.mobileqq.kandian.biz.config;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.kandian.base.report.ReadInJoyDoingSomething;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.base.view.api.IKanDianOptUtils;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
import com.tencent.mobileqq.kandian.biz.push.api.IKanDianMergeManager;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianSubscribeManager;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.SPEventReportSwitch;
import com.tencent.mobileqq.kandian.repo.comment.constants.CommentInfoConstants;
import com.tencent.mobileqq.kandian.repo.common.RIJShowKanDianTabSp;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoyRefreshOptimizeUtil;
import com.tencent.mobileqq.kandian.repo.common.constant.ReadInJoyConstants;
import com.tencent.mobileqq.kandian.repo.fastweb.FastWebSPUtils;
import com.tencent.mobileqq.kandian.repo.feeds.FeedsSPUtils;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/config/RIJCommonConfigHandler;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "methodsMap", "", "Lkotlin/Function4;", "Lorg/w3c/dom/Document;", "Lorg/w3c/dom/Node;", "", "autoRefreshTimeDuration", "name", "value", "document", "node", "diaobaodeKandian", "enablePreoutputVideoFirstFrame", "invokeConfigProcessor", "invokeContainsKey", "", "kanDianManagerPlatformConfig", "configItme", "Lcom/tencent/mobileqq/config/QConfItem;", "registerNameToValueMap", "setKanDianReportTTSwitch", "sharpPicSupportSwitch", "udpateTabClickPushAlgoId", "updateAladdinConfigurationSwitch", "updateCameraCaptureMaxDuration", "updateCoinItemJumpUrl", "updateCoinItemWording", "updateDianDianConfigRightButtonAtSwitch", "updateExitAIOReportUinLimit", "updateExposureStrengthenSwitch", "updateForeGroundGapInSeconds", "updateFreeTimeRefreshPush", "updateGallerySubChannelHidden", "updateGallerySubChannelWaterFallHidden", "updateHotCommentLikeNumber", "updateHotCommentNumber", "updateIsPlayCommentButtonShow", "updateKDPreloadRedPntPushArticleSwitch", "updateKDTabType", "updateKW", "updateKanDianCommentLimitNumber", "updateKanDianConfigRightButtonAtSwitch", "updateKanDianDailyFastWebBottomShare", "updateKanDianDailyWrapperAlpha", "updateKanDianDailyWrapperDefaultText", "updateKanDianDailyWrapperDragText", "updateKanDianFeatureCompute", "updateKanDianPushSetTopMsg", "updateKandianConfigAdExposureThreshold", "updateKandianConfigBadgeSwitch", "updateKandianConfigBiuAtSwitch", "updateKandianConfigBiuFeedsName", "updateKandianConfigBiuFeedsSwitch", "updateKandianConfigBiuFeedsWebUrl", "updateKandianConfigBiuProfileAtSwitch", "updateKandianConfigBiuWordCount", "updateKandianConfigCommentAtSwitch", "updateKandianConfigCommentBiuSwitch", "updateKandianConfigCommentGifSwitch", "updateKandianConfigCommentWordCount", "updateKandianConfigCommentZhituSwitch", "updateKandianConfigFastWebCloseBiuCntSwtich", "updateKandianConfigNativeCommentBiuSwitch", "updateKandianConfigRedShowNum", "updateKandianConfigRedThreshold", "updateKandianConfigUGCGifSwitch", "updateKandianConfigUgcAtSwitch", "updateKandianDeleteOutArticleFeedsCnt", "updateKandianDeleteOutArticleInterval", "updateKandianIconMergeBiuMsgSwitch", "updateKandianIconMergeInteractiveMsgSwitch", "updateKandianIconMergeSubscriptionWhiteList", "updateKandianMyTabPage", "updateKandianNewChannelStyle", "updateKandianSwitch", "app", "Lcom/tencent/mobileqq/app/QQAppInterface;", "updateNativeEngineTimeoutConfig", "updateNativeWebPreoloadSwitch", "updateNativeWebSwitch", "updateOptimizeStrategy", "updatePlayTime", "updateProteusEnableSwitch", "updatePublishTopic", "updateReadInJoyFeedsGroupSetting", "updateReadInJoyIndividualPushSwitchSetting", "updateReadInJoyMessageAutoRefreshTimeDuration", "updateReadInJoyPushMsgSwitch", "updateReadInJoyShowArkAppSetting", "updateReadInJoySmartCropSetting", "updateReadInJoyTabAutoRefreshTimeDuration", "updateReadInJoyWeiShiJumpTarget", "updateReadInjoyToWxAtSwitch", "updateReadinjoyQAsquareAutoTimeval", "updateReadinjoySubscribeListPush", "updateReportManyApps", "updateReportUserAppsSwitch", "updateScreenSwitchInSeconds", "updateSelfFragmentFeedBackConf", "updateShouldShowWeiShiEntrance", "updateSocialFeedsWebJumpUrl", "updateTabClickCountLimit", "updateTabClickForbidReportTime", "updateTabClickGapInSeconds", "updateTitleNumberLine", "updateTopicCardJump", "updateTopicCardJumpUrl", "updateUserBehaviorNormalJumpUrl", "updateUserBehaviorNormalSwitch", "updateUserIdleReport", "updateVideoColor", "updateVideoExtractFrame", "updateVideoFFProbesize", "updateVideoFeedsAdConfigFromServer", "updateVideoFeedsDiscoverySwitch", "updateVideoFeedsInterruptedAsConfigFromServer", "updateVideoFeedsShortVideoMaxDrationLimit", "updateVideoFeedsShortVideoWidthHeightRatio", "updateVideoFeedsShuntBarConfigFromServer", "updateVideoIsDownloadAsyncIO", "updateVideoIsFFProbelistSwitch", "updateVideoSwitch", "updateWebCgiPreloadSwitch", "updateWeiShiWithChannelAndDiscoveryConfig", "updateWeishiDeleteOutArticleFeedsCnt", "updateWeishiDeleteOutArticleInterval", "updateWeishiRecommendDeleteOutArticleFeedsCounts", "updateWeishiRecommendDeleteOutArticleInterval", "uploadLBSSwitch", "videoFeedsPreloadSwitch", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJCommonConfigHandler
{
  @NotNull
  private final String jdField_a_of_type_JavaLangString = "RIJCommonConfigHandler";
  private final Map<String, Function4<String, String, Document, Node, Unit>> jdField_a_of_type_JavaUtilMap = (Map)new LinkedHashMap();
  
  public RIJCommonConfigHandler()
  {
    a();
  }
  
  private final void A(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    ReadInJoyHelper.z((AppRuntime)RIJQQAppInterfaceUtil.b(), paramString2);
  }
  
  private final void B(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    boolean bool = Intrinsics.areEqual("1", paramString2);
    ReadInJoyHelper.g((AppRuntime)RIJQQAppInterfaceUtil.b(), bool);
  }
  
  private final void C(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    boolean bool = Intrinsics.areEqual("1", paramString2);
    ReadInJoyHelper.t((AppRuntime)RIJQQAppInterfaceUtil.b(), bool);
  }
  
  private final void D(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    RIJSPUtils.a("sp_native_web_sharpp_pic_switch", Boolean.valueOf(Intrinsics.areEqual("1", paramString2)));
  }
  
  private final void E(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    paramString1 = Integer.valueOf(paramString2);
    RIJSPUtils.a("sp_key_kandian_subscribe_auto_refresh_config", paramString1);
    paramString2 = this.jdField_a_of_type_JavaLangString;
    paramDocument = new StringBuilder();
    paramDocument.append("update kandian subscribe auto refresh config : ");
    paramDocument.append(paramString1);
    QLog.d(paramString2, 2, paramDocument.toString());
  }
  
  private final void F(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    RIJSPUtils.a("sp_key_readinjoy_video_entrance_reddot_expire_time_list", paramString2);
  }
  
  private final void G(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    try
    {
      RIJSPUtils.a("sp_key_readinjoy_video_entrance_reddot_button_color", Integer.valueOf(Color.parseColor(paramString2)));
      return;
    }
    catch (IllegalArgumentException paramString1)
    {
      QLog.e(this.jdField_a_of_type_JavaLangString, 2, "handleReadInJoyCommonConfig: video_type_color", (Throwable)paramString1);
    }
  }
  
  private final void H(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    paramString1 = this.jdField_a_of_type_JavaLangString;
    paramDocument = new StringBuilder();
    paramDocument.append("video_switch: ");
    paramDocument.append(paramString2);
    QLog.d(paramString1, 2, paramDocument.toString());
    for (;;)
    {
      try
      {
        paramString1 = Integer.valueOf(paramString2);
        if ((paramString1 != null) && (paramString1.intValue() == 0))
        {
          bool = true;
          RIJSPUtils.a("sp_key_readinjoy_video_entrance_reddot_button_switch", Boolean.valueOf(bool));
          return;
        }
      }
      catch (NumberFormatException paramString1)
      {
        QLog.e(this.jdField_a_of_type_JavaLangString, 2, "handleReadInJoyCommonConfig: video_switch ", (Throwable)paramString1);
        return;
      }
      boolean bool = false;
    }
  }
  
  private final void I(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    if (QLog.isColorLevel())
    {
      paramString1 = this.jdField_a_of_type_JavaLangString;
      paramDocument = new StringBuilder();
      paramDocument.append("ReadInJoy_Red_Pnt_Push_Article_Preload_Switch: ");
      paramDocument.append(paramString2);
      QLog.d(paramString1, 2, paramDocument.toString());
    }
    ReadInJoyHelper.k((AppRuntime)RIJQQAppInterfaceUtil.b(), paramString2);
  }
  
  private final void J(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    if (QLog.isColorLevel())
    {
      paramString1 = this.jdField_a_of_type_JavaLangString;
      paramDocument = new StringBuilder();
      paramDocument.append("ReadInJoy_Fast_Web_Biu_Cnt_CLose_Switch: ");
      paramDocument.append(paramString2);
      QLog.d(paramString1, 2, paramDocument.toString());
    }
    FastWebSPUtils.a((AppRuntime)RIJQQAppInterfaceUtil.b(), paramString2);
  }
  
  private final void K(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    if (QLog.isColorLevel())
    {
      paramString1 = this.jdField_a_of_type_JavaLangString;
      paramDocument = new StringBuilder();
      paramDocument.append("multi_video_shunt_bar_config: ");
      paramDocument.append(paramString2);
      QLog.d(paramString1, 2, paramDocument.toString());
    }
    ReadInJoyHelper.E((AppRuntime)RIJQQAppInterfaceUtil.b(), paramString2);
  }
  
  private final void L(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    paramString1 = new StringBuilder();
    paramString1.append("is_jump_to_video_content: ");
    paramString1.append(paramString2);
    QLog.d("ReadinjoyCommonConfProcessor", 2, paramString1.toString());
    ReadInJoyHelper.J((AppRuntime)RIJQQAppInterfaceUtil.b(), paramString2);
  }
  
  private final void M(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    if (QLog.isColorLevel())
    {
      paramString1 = this.jdField_a_of_type_JavaLangString;
      paramDocument = new StringBuilder();
      paramDocument.append("should show weishi entrance : ");
      paramDocument.append(paramString2);
      QLog.d(paramString1, 2, paramDocument.toString());
    }
    paramString1 = (AppRuntime)RIJQQAppInterfaceUtil.b();
    paramString2 = Integer.valueOf(paramString2);
    Intrinsics.checkExpressionValueIsNotNull(paramString2, "Integer.valueOf(value)");
    ReadInJoyHelper.B(paramString1, paramString2.intValue());
  }
  
  private final void N(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    if (QLog.isColorLevel())
    {
      paramString1 = this.jdField_a_of_type_JavaLangString;
      paramDocument = new StringBuilder();
      paramDocument.append("ReadInJoy_Message_Auto_Refresh_Time_Duration :");
      paramDocument.append(paramString2);
      QLog.d(paramString1, 2, paramDocument.toString());
    }
    ReadInJoyHelper.I((AppRuntime)RIJQQAppInterfaceUtil.b(), paramString2);
  }
  
  private final void O(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    if (QLog.isColorLevel())
    {
      paramString1 = this.jdField_a_of_type_JavaLangString;
      paramDocument = new StringBuilder();
      paramDocument.append("ReadInJoy_Tab_Auto_Refresh_Time_Duration :");
      paramDocument.append(paramString2);
      QLog.d(paramString1, 2, paramDocument.toString());
    }
    ReadInJoyHelper.H((AppRuntime)RIJQQAppInterfaceUtil.b(), paramString2);
  }
  
  private final void P(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    if (QLog.isColorLevel())
    {
      paramString1 = this.jdField_a_of_type_JavaLangString;
      paramDocument = new StringBuilder();
      paramDocument.append("record_duration_count :");
      paramDocument.append(paramString2);
      QLog.d(paramString1, 2, paramDocument.toString());
    }
    paramString1 = (AppRuntime)RIJQQAppInterfaceUtil.b();
    paramString2 = Integer.valueOf(paramString2);
    Intrinsics.checkExpressionValueIsNotNull(paramString2, "Integer.valueOf(value)");
    ReadInJoyHelper.g(paramString1, paramString2.intValue());
  }
  
  private final void Q(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    if (QLog.isColorLevel())
    {
      paramString1 = this.jdField_a_of_type_JavaLangString;
      paramDocument = new StringBuilder();
      paramDocument.append("multi_video_interrupted_ad_config: ");
      paramDocument.append(paramString2);
      QLog.d(paramString1, 2, paramDocument.toString());
    }
    ReadInJoyHelper.C((AppRuntime)RIJQQAppInterfaceUtil.b(), paramString2);
  }
  
  private final void R(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    if (QLog.isColorLevel())
    {
      paramString1 = this.jdField_a_of_type_JavaLangString;
      paramDocument = new StringBuilder();
      paramDocument.append("multi_video_ad_config :");
      paramDocument.append(paramString2);
      QLog.d(paramString1, 2, paramDocument.toString());
    }
    ReadInJoyHelper.A((AppRuntime)RIJQQAppInterfaceUtil.b(), paramString2);
  }
  
  private final void S(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    if (QLog.isColorLevel())
    {
      paramString1 = this.jdField_a_of_type_JavaLangString;
      paramDocument = new StringBuilder();
      paramDocument.append("readinjoy_short_video_max_duration_limit :");
      paramDocument.append(paramString2);
      QLog.d(paramString1, 2, paramDocument.toString());
    }
    paramString1 = Integer.valueOf(paramString2);
    paramString2 = (AppRuntime)RIJQQAppInterfaceUtil.b();
    Intrinsics.checkExpressionValueIsNotNull(paramString1, "intValue");
    FeedsSPUtils.a(paramString2, paramString1.intValue());
  }
  
  private final void T(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    if (QLog.isColorLevel())
    {
      paramString1 = this.jdField_a_of_type_JavaLangString;
      paramDocument = new StringBuilder();
      paramDocument.append("readinjoy_short_video_width_height_ratio :");
      paramDocument.append(paramString2);
      QLog.d(paramString1, 2, paramDocument.toString());
    }
    paramString1 = Float.valueOf(paramString2);
    paramString2 = (AppRuntime)RIJQQAppInterfaceUtil.b();
    Intrinsics.checkExpressionValueIsNotNull(paramString1, "floatValue");
    FeedsSPUtils.a(paramString2, paramString1.floatValue());
  }
  
  private final void U(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    if (QLog.isColorLevel())
    {
      paramString1 = this.jdField_a_of_type_JavaLangString;
      paramDocument = new StringBuilder();
      paramDocument.append("native comment biu switch:");
      paramDocument.append(paramString2);
      QLog.d(paramString1, 2, paramDocument.toString());
    }
    ReadInJoyHelper.t((AppRuntime)RIJQQAppInterfaceUtil.b(), paramString2);
  }
  
  private final void V(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    if (QLog.isColorLevel())
    {
      paramString1 = this.jdField_a_of_type_JavaLangString;
      paramDocument = new StringBuilder();
      paramDocument.append("comment biu switch :");
      paramDocument.append(paramString2);
      QLog.d(paramString1, 2, paramDocument.toString());
    }
    ReadInJoyHelper.s((AppRuntime)RIJQQAppInterfaceUtil.b(), paramString2);
  }
  
  private final void W(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    if (QLog.isColorLevel())
    {
      paramString1 = this.jdField_a_of_type_JavaLangString;
      paramDocument = new StringBuilder();
      paramDocument.append("comment_zhitu_switch:");
      paramDocument.append(paramString2);
      QLog.d(paramString1, 2, paramDocument.toString());
    }
    ReadInJoyHelper.j((AppRuntime)RIJQQAppInterfaceUtil.b(), paramString2);
  }
  
  private final void X(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    if (QLog.isColorLevel())
    {
      paramString1 = this.jdField_a_of_type_JavaLangString;
      paramDocument = new StringBuilder();
      paramDocument.append("get proteus switch from config: ");
      paramDocument.append(paramString2);
      QLog.d(paramString1, 2, paramDocument.toString());
    }
    ReadInJoyHelper.c(Intrinsics.areEqual("1", paramString2));
  }
  
  private final void Y(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    if (QLog.isColorLevel())
    {
      paramString1 = this.jdField_a_of_type_JavaLangString;
      paramDocument = new StringBuilder();
      paramDocument.append("get wx share from readinjoy :");
      paramDocument.append(paramString2);
      QLog.d(paramString1, 2, paramDocument.toString());
    }
    ReadInJoyHelper.r((AppRuntime)RIJQQAppInterfaceUtil.b(), paramString2);
  }
  
  private final void Z(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    if (QLog.isColorLevel())
    {
      paramString1 = this.jdField_a_of_type_JavaLangString;
      paramDocument = new StringBuilder();
      paramDocument.append("readinjoy_QA_square_autoTimeval: ");
      paramDocument.append(paramString2);
      QLog.d(paramString1, 2, paramDocument.toString());
    }
    ReadInJoyHelper.q((AppRuntime)RIJQQAppInterfaceUtil.b(), paramString2);
  }
  
  private final void a()
  {
    Map localMap = this.jdField_a_of_type_JavaUtilMap;
    RIJCommonConfigHandler localRIJCommonConfigHandler = (RIJCommonConfigHandler)this;
    localMap.put("smartcrop_pic", new RIJCommonConfigHandler.registerNameToValueMap.1(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("feeds_group", new RIJCommonConfigHandler.registerNameToValueMap.2(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("remind_only_wifi", new RIJCommonConfigHandler.registerNameToValueMap.3(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("kandian_individual_time_push", new RIJCommonConfigHandler.registerNameToValueMap.4(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("push_switch", new RIJCommonConfigHandler.registerNameToValueMap.5(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("sticky_times", new RIJCommonConfigHandler.registerNameToValueMap.6(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("socializeWebUrl", new RIJCommonConfigHandler.registerNameToValueMap.7(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("free_time_refresh_push", new RIJCommonConfigHandler.registerNameToValueMap.8(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("kandian_my_tab_page", new RIJCommonConfigHandler.registerNameToValueMap.9(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("kandian_gallery_channel_bar_hidden", new RIJCommonConfigHandler.registerNameToValueMap.10(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("kandian_gallery_channel_waterfall_bar_hidden", new RIJCommonConfigHandler.registerNameToValueMap.11(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("tab_click_gap_in_seconds", new RIJCommonConfigHandler.registerNameToValueMap.12(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("tab_click_count_limit", new RIJCommonConfigHandler.registerNameToValueMap.13(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("tab_click_push_algo_id", new RIJCommonConfigHandler.registerNameToValueMap.14(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("tab_click_forbid_report_time_in_seconds", new RIJCommonConfigHandler.registerNameToValueMap.15(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("fore_ground_gap_in_seconds", new RIJCommonConfigHandler.registerNameToValueMap.16(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("screen_switch_in_seconds", new RIJCommonConfigHandler.registerNameToValueMap.17(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("user_idle_repor", new RIJCommonConfigHandler.registerNameToValueMap.18(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("kandian_report_tt", new RIJCommonConfigHandler.registerNameToValueMap.19(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("kandian_report_user_apps_switch", new RIJCommonConfigHandler.registerNameToValueMap.20(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("actKandianReportManyApps", new RIJCommonConfigHandler.registerNameToValueMap.21(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("kandian_optimize_strategy", new RIJCommonConfigHandler.registerNameToValueMap.22(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("maintab_reddot_times", new RIJCommonConfigHandler.registerNameToValueMap.23(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("maintab_reddot_feeds", new RIJCommonConfigHandler.registerNameToValueMap.24(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("feedsbackWebUrl", new RIJCommonConfigHandler.registerNameToValueMap.25(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("feedsbackSwitch", new RIJCommonConfigHandler.registerNameToValueMap.26(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("feedsbackName", new RIJCommonConfigHandler.registerNameToValueMap.27(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("biufeedsSwitch", new RIJCommonConfigHandler.registerNameToValueMap.28(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("biufeedsName", new RIJCommonConfigHandler.registerNameToValueMap.29(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("biufeedsWebUrl", new RIJCommonConfigHandler.registerNameToValueMap.30(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("badgeNumber", new RIJCommonConfigHandler.registerNameToValueMap.31(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("biu_word_count", new RIJCommonConfigHandler.registerNameToValueMap.32(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("new_channel_style", new RIJCommonConfigHandler.registerNameToValueMap.33(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("local_record_time", new RIJCommonConfigHandler.registerNameToValueMap.34(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("local_record_feeds", new RIJCommonConfigHandler.registerNameToValueMap.35(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("local_record_time_weishi", new RIJCommonConfigHandler.registerNameToValueMap.36(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("local_record_feeds_weishi", new RIJCommonConfigHandler.registerNameToValueMap.37(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("kandianWebPreLoadData", new RIJCommonConfigHandler.registerNameToValueMap.38(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("ExitAIO_Android_Uin", new RIJCommonConfigHandler.registerNameToValueMap.39(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("kandian_tab_type", new RIJCommonConfigHandler.registerNameToValueMap.40(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("DiaobaodeKandian", new RIJCommonConfigHandler.registerNameToValueMap.41(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("topic_card_jump", new RIJCommonConfigHandler.registerNameToValueMap.42(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("topic_card_jump_url", new RIJCommonConfigHandler.registerNameToValueMap.43(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("comment_word_count", new RIJCommonConfigHandler.registerNameToValueMap.44(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("KW", new RIJCommonConfigHandler.registerNameToValueMap.45(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("comment_gif_switch", new RIJCommonConfigHandler.registerNameToValueMap.46(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("ugc_gif_switch", new RIJCommonConfigHandler.registerNameToValueMap.47(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("biu_at_switch", new RIJCommonConfigHandler.registerNameToValueMap.48(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("UGC_at_switch", new RIJCommonConfigHandler.registerNameToValueMap.49(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("comment_at_switch", new RIJCommonConfigHandler.registerNameToValueMap.50(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("biu_profile_switch", new RIJCommonConfigHandler.registerNameToValueMap.51(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("IconMerge_BiuMsg", new RIJCommonConfigHandler.registerNameToValueMap.52(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("IconMerge_InteractiveMsg", new RIJCommonConfigHandler.registerNameToValueMap.53(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("IconMerge_SubscribeMsg", new RIJCommonConfigHandler.registerNameToValueMap.54(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("nw_support", new RIJCommonConfigHandler.registerNameToValueMap.55(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("nw_preload", new RIJCommonConfigHandler.registerNameToValueMap.56(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("arkapp_enable_switch", new RIJCommonConfigHandler.registerNameToValueMap.57(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("exposure_strengthen", new RIJCommonConfigHandler.registerNameToValueMap.58(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("native_timeout", new RIJCommonConfigHandler.registerNameToValueMap.59(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("diandian_publish_switch_new", new RIJCommonConfigHandler.registerNameToValueMap.60(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("kandian_publish_switch_new", new RIJCommonConfigHandler.registerNameToValueMap.61(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("readinjoy_QA_square_autoTimeval", new RIJCommonConfigHandler.registerNameToValueMap.62(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("WXShareFromKandian_Switch", new RIJCommonConfigHandler.registerNameToValueMap.63(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("proteus_enable", new RIJCommonConfigHandler.registerNameToValueMap.64(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("zhitu", new RIJCommonConfigHandler.registerNameToValueMap.65(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("comment_biu_switch", new RIJCommonConfigHandler.registerNameToValueMap.66(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("native_comment_biu", new RIJCommonConfigHandler.registerNameToValueMap.67(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("readinjoy_short_video_width_height_ratio", new RIJCommonConfigHandler.registerNameToValueMap.68(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("readinjoy_short_video_max_duration_limit", new RIJCommonConfigHandler.registerNameToValueMap.69(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("multi_video_ad_config", new RIJCommonConfigHandler.registerNameToValueMap.70(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("multi_video_interrupted_ad_config", new RIJCommonConfigHandler.registerNameToValueMap.71(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("record_duration_count", new RIJCommonConfigHandler.registerNameToValueMap.72(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("ReadInJoy_Tab_Auto_Refresh_Time_Duration", new RIJCommonConfigHandler.registerNameToValueMap.73(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("ReadInJoy_Message_Auto_Refresh_Time_Duration", new RIJCommonConfigHandler.registerNameToValueMap.74(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("is_show_weishi_entrance", new RIJCommonConfigHandler.registerNameToValueMap.75(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("is_jump_to_video_content", new RIJCommonConfigHandler.registerNameToValueMap.76(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("multi_video_ecommerce_entrance_config", new RIJCommonConfigHandler.registerNameToValueMap.77(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("ReadInJoy_Fast_Web_Biu_Cnt_CLose_Switch", new RIJCommonConfigHandler.registerNameToValueMap.78(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("ReadInJoy_Red_Pnt_Push_Article_Preload_Switch", new RIJCommonConfigHandler.registerNameToValueMap.79(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("video_switch", new RIJCommonConfigHandler.registerNameToValueMap.80(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("video_type_color", new RIJCommonConfigHandler.registerNameToValueMap.81(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("play_time", new RIJCommonConfigHandler.registerNameToValueMap.82(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("ReadInJoy_guanzhu_Auto_Refresh_Time_Duration", new RIJCommonConfigHandler.registerNameToValueMap.83(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("sharp_pic_support_switch", new RIJCommonConfigHandler.registerNameToValueMap.84(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("video_feeds_preload_switch", new RIJCommonConfigHandler.registerNameToValueMap.85(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("enable_preoutput_kandianvideo_first_frame", new RIJCommonConfigHandler.registerNameToValueMap.86(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("rij_discover_entrance_show", new RIJCommonConfigHandler.registerNameToValueMap.87(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("hot_comment_number", new RIJCommonConfigHandler.registerNameToValueMap.88(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("hot_comment_likes_number", new RIJCommonConfigHandler.registerNameToValueMap.89(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("weishi_with_channel_discovery_switch", new RIJCommonConfigHandler.registerNameToValueMap.90(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("ugc_upload_lbs_switch", new RIJCommonConfigHandler.registerNameToValueMap.91(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("local_record_time_weishi_recommend", new RIJCommonConfigHandler.registerNameToValueMap.92(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("local_record_feeds_counts_weishi_recommend", new RIJCommonConfigHandler.registerNameToValueMap.93(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("kandian_aladdin_configuration_switch", new RIJCommonConfigHandler.registerNameToValueMap.94(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("publish_topic", new RIJCommonConfigHandler.registerNameToValueMap.95(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("coin_item_jump_url", new RIJCommonConfigHandler.registerNameToValueMap.96(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("coin_item_wording", new RIJCommonConfigHandler.registerNameToValueMap.97(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("user_behavior_norm_switch", new RIJCommonConfigHandler.registerNameToValueMap.98(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("user_behavior_norm_jump_url", new RIJCommonConfigHandler.registerNameToValueMap.99(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("kandian_feature_compute", new RIJCommonConfigHandler.registerNameToValueMap.100(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("kdad_exposure_report_threshold", new RIJCommonConfigHandler.registerNameToValueMap.101(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("kandian_daily_fast_web_bottom_share", new RIJCommonConfigHandler.registerNameToValueMap.102(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("kandian_comment_limit_number", new RIJCommonConfigHandler.registerNameToValueMap.103(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("title_label_number_of_lines", new RIJCommonConfigHandler.registerNameToValueMap.104(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("is_play_comment_button_show", new RIJCommonConfigHandler.registerNameToValueMap.105(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("readinjoy_video_ff_probesize", new RIJCommonConfigHandler.registerNameToValueMap.106(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("readinjoy_video_is_ff_probelist_switch", new RIJCommonConfigHandler.registerNameToValueMap.107(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("readinjoy_video_is_download_async_io", new RIJCommonConfigHandler.registerNameToValueMap.108(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("kandian_daily_wrapper_alpha", new RIJCommonConfigHandler.registerNameToValueMap.109(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("kandian_daily_wrapper_default_text", new RIJCommonConfigHandler.registerNameToValueMap.110(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("kandian_daily_wrapper_drag_text", new RIJCommonConfigHandler.registerNameToValueMap.111(localRIJCommonConfigHandler));
    this.jdField_a_of_type_JavaUtilMap.put("video_extract_frame", new RIJCommonConfigHandler.registerNameToValueMap.112(localRIJCommonConfigHandler));
  }
  
  private final void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[all]updateKandianTabConfigSwitch value : ");
    ((StringBuilder)localObject).append(paramString);
    QLog.d("KandianConfigServlet", 1, ((StringBuilder)localObject).toString());
    long l1 = System.currentTimeMillis();
    localObject = (Boolean)RIJSPUtils.a("local_kd_tab_has_set", Boolean.valueOf(false));
    boolean bool3 = TextUtils.equals((CharSequence)"1", (CharSequence)paramString);
    RIJShowKanDianTabSp.a((AppRuntime)paramQQAppInterface, "remote_kd_tab_switch", Boolean.valueOf(bool3));
    boolean bool1;
    if ((localObject != null) && (!((Boolean)localObject).booleanValue()))
    {
      boolean bool2 = RIJShowKanDianTabSp.a(bool3);
      bool1 = bool2;
      if (bool2)
      {
        bool1 = bool2;
        if (!RIJAppSetting.d())
        {
          bool1 = bool2;
          if (!((IKanDianOptUtils)QRoute.api(IKanDianOptUtils.class)).isMainFrameInInit())
          {
            ReadInJoyHelper.e();
            ReadInJoyLogicEngineEventDispatcher.a().a(0, null);
            bool1 = bool2;
          }
        }
      }
    }
    else
    {
      QLog.d("KandianConfigServlet", 1, "[all]updateKandianTabConfigSwitch user has set switch, give up !");
      bool1 = false;
    }
    long l2 = System.currentTimeMillis();
    paramQQAppInterface = new StringBuilder();
    paramQQAppInterface.append("[all]updateKandianTabConfigSwitch tabSwitch = ");
    paramQQAppInterface.append(bool3);
    paramQQAppInterface.append(", write sp cost:");
    paramQQAppInterface.append(l2 - l1);
    paramQQAppInterface.append(", succ : ");
    paramQQAppInterface.append(bool1);
    QLog.d("KandianConfigServlet", 1, paramQQAppInterface.toString());
  }
  
  private final void a(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    Function4 localFunction4 = (Function4)this.jdField_a_of_type_JavaUtilMap.get(paramString1);
    if (localFunction4 != null) {
      paramString1 = (Unit)localFunction4.invoke(paramString1, paramString2, paramDocument, paramNode);
    }
  }
  
  private final boolean a(String paramString)
  {
    return this.jdField_a_of_type_JavaUtilMap.containsKey(paramString);
  }
  
  private final void aA(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    if (QLog.isColorLevel())
    {
      paramString1 = this.jdField_a_of_type_JavaLangString;
      paramDocument = new StringBuilder();
      paramDocument.append("local_record_feeds = ");
      paramDocument.append(paramString2);
      QLog.d(paramString1, 2, paramDocument.toString());
    }
    paramString1 = Integer.valueOf(paramString2);
    paramString2 = RIJQQAppInterfaceUtil.a();
    Intrinsics.checkExpressionValueIsNotNull(paramString1, "cnt");
    ReadInJoyHelper.x(paramString2, paramString1.intValue());
  }
  
  private final void aB(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    if (QLog.isColorLevel())
    {
      paramString1 = this.jdField_a_of_type_JavaLangString;
      paramDocument = new StringBuilder();
      paramDocument.append("local_record_time = ");
      paramDocument.append(paramString2);
      QLog.d(paramString1, 2, paramDocument.toString());
    }
    paramString1 = Long.valueOf(paramString2);
    paramString2 = RIJQQAppInterfaceUtil.a();
    Intrinsics.checkExpressionValueIsNotNull(paramString1, "time");
    ReadInJoyHelper.a(paramString2, paramString1.longValue());
  }
  
  private final void aC(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    if (QLog.isColorLevel())
    {
      paramString1 = this.jdField_a_of_type_JavaLangString;
      paramDocument = new StringBuilder();
      paramDocument.append("new_channel_style = ");
      paramDocument.append(paramString2);
      QLog.d(paramString1, 2, paramDocument.toString());
    }
    paramString1 = RIJQQAppInterfaceUtil.a();
    paramString2 = Integer.valueOf(paramString2);
    Intrinsics.checkExpressionValueIsNotNull(paramString2, "Integer.valueOf(value)");
    ReadInJoyHelper.k(paramString1, paramString2.intValue());
  }
  
  private final void aD(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    if (QLog.isColorLevel())
    {
      paramString1 = this.jdField_a_of_type_JavaLangString;
      paramDocument = new StringBuilder();
      paramDocument.append("biu_word_count = ");
      paramDocument.append(paramString2);
      QLog.d(paramString1, 2, paramDocument.toString());
    }
    ReadInJoyHelper.f(RIJQQAppInterfaceUtil.a(), paramString2);
  }
  
  private final void aE(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    if (QLog.isColorLevel())
    {
      paramString1 = this.jdField_a_of_type_JavaLangString;
      paramDocument = new StringBuilder();
      paramDocument.append("badgeNumber = ");
      paramDocument.append(paramString2);
      QLog.d(paramString1, 2, paramDocument.toString());
    }
    paramString1 = RIJQQAppInterfaceUtil.a();
    paramString2 = Integer.valueOf(paramString2);
    Intrinsics.checkExpressionValueIsNotNull(paramString2, "Integer.valueOf(value)");
    ReadInJoyHelper.w(paramString1, paramString2.intValue());
  }
  
  private final void aF(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    if (QLog.isColorLevel())
    {
      paramString1 = this.jdField_a_of_type_JavaLangString;
      paramDocument = new StringBuilder();
      paramDocument.append("biufeedsWebUrl = ");
      paramDocument.append(paramString2);
      QLog.d(paramString1, 2, paramDocument.toString());
    }
    ReadInJoyHelper.e(RIJQQAppInterfaceUtil.a(), paramString2);
  }
  
  private final void aG(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    if (QLog.isColorLevel())
    {
      paramString1 = this.jdField_a_of_type_JavaLangString;
      paramDocument = new StringBuilder();
      paramDocument.append("biufeedsName = ");
      paramDocument.append(paramString2);
      QLog.d(paramString1, 2, paramDocument.toString());
    }
    ReadInJoyHelper.d(RIJQQAppInterfaceUtil.a(), paramString2);
  }
  
  private final void aH(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    if (QLog.isColorLevel())
    {
      paramString1 = this.jdField_a_of_type_JavaLangString;
      paramDocument = new StringBuilder();
      paramDocument.append("biufeedsSwitch = ");
      paramDocument.append(paramString2);
      QLog.d(paramString1, 2, paramDocument.toString());
    }
    paramString1 = RIJQQAppInterfaceUtil.a();
    paramString2 = Integer.valueOf(paramString2);
    Intrinsics.checkExpressionValueIsNotNull(paramString2, "Integer.valueOf(value)");
    ReadInJoyHelper.j(paramString1, paramString2.intValue());
  }
  
  private final void aI(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    ReadInJoyHelper.b(RIJQQAppInterfaceUtil.a(), paramString1, paramString2);
    if (QLog.isColorLevel())
    {
      paramDocument = this.jdField_a_of_type_JavaLangString;
      paramNode = new StringBuilder();
      paramNode.append("name: ");
      paramNode.append(paramString1);
      paramNode.append("value: ");
      paramNode.append(TextUtils.equals((CharSequence)paramString2, (CharSequence)"1"));
      QLog.d(paramDocument, 2, paramNode.toString());
    }
  }
  
  private final void aJ(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    if (QLog.isColorLevel())
    {
      paramString1 = this.jdField_a_of_type_JavaLangString;
      paramDocument = new StringBuilder();
      paramDocument.append("maintab_reddot_feeds = ");
      paramDocument.append(paramString2);
      QLog.d(paramString1, 2, paramDocument.toString());
    }
    paramString1 = RIJQQAppInterfaceUtil.a();
    paramString2 = Integer.valueOf(paramString2);
    Intrinsics.checkExpressionValueIsNotNull(paramString2, "Integer.valueOf(value)");
    ReadInJoyHelper.i(paramString1, paramString2.intValue());
  }
  
  private final void aK(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    if (QLog.isColorLevel())
    {
      paramString1 = this.jdField_a_of_type_JavaLangString;
      paramDocument = new StringBuilder();
      paramDocument.append("maintab_reddot_times = ");
      paramDocument.append(paramString2);
      QLog.d(paramString1, 2, paramDocument.toString());
    }
    paramString1 = RIJQQAppInterfaceUtil.a();
    paramString2 = Integer.valueOf(paramString2);
    Intrinsics.checkExpressionValueIsNotNull(paramString2, "Integer.valueOf(value)");
    ReadInJoyHelper.h(paramString1, paramString2.intValue());
  }
  
  private final void aL(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    ReadInJoyRefreshOptimizeUtil.a(paramString2);
  }
  
  private final void aM(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    ReadInJoyDoingSomething.parseConfigToSP(paramNode);
  }
  
  private final void aN(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    boolean bool = TextUtils.equals((CharSequence)paramString2, (CharSequence)"1");
    if (QLog.isColorLevel())
    {
      paramString1 = this.jdField_a_of_type_JavaLangString;
      paramString2 = new StringBuilder();
      paramString2.append("kandian_report_user_apps_switch: ");
      paramString2.append(bool);
      QLog.d(paramString1, 2, paramString2.toString());
    }
    RIJSPUtils.a("kandian_report_user_apps_switch", Boolean.valueOf(bool));
  }
  
  private final void aO(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    if (QLog.isColorLevel())
    {
      paramString1 = this.jdField_a_of_type_JavaLangString;
      paramDocument = new StringBuilder();
      paramDocument.append("kandian_report_tt = ");
      paramDocument.append(TextUtils.equals((CharSequence)paramString2, (CharSequence)"1"));
      QLog.d(paramString1, 2, paramDocument.toString());
    }
    if (TextUtils.equals((CharSequence)paramString2, (CharSequence)"1"))
    {
      ReadInJoyHelper.s(RIJQQAppInterfaceUtil.a(), true);
      return;
    }
    ReadInJoyHelper.s(RIJQQAppInterfaceUtil.a(), false);
  }
  
  private final void aP(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    SPEventReportSwitch.g(RIJQQAppInterfaceUtil.a(), paramString2);
  }
  
  private final void aQ(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    SPEventReportSwitch.f(RIJQQAppInterfaceUtil.a(), paramString2);
  }
  
  private final void aR(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    SPEventReportSwitch.e(RIJQQAppInterfaceUtil.a(), paramString2);
  }
  
  private final void aS(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    SPEventReportSwitch.d(RIJQQAppInterfaceUtil.a(), paramString2);
  }
  
  private final void aT(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    SPEventReportSwitch.c(RIJQQAppInterfaceUtil.a(), paramString2);
  }
  
  private final void aU(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    SPEventReportSwitch.b(RIJQQAppInterfaceUtil.a(), paramString2);
  }
  
  private final void aV(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    SPEventReportSwitch.a(RIJQQAppInterfaceUtil.a(), paramString2);
  }
  
  private final void aW(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    ReadInJoyHelper.x(RIJQQAppInterfaceUtil.a(), paramString2);
  }
  
  private final void aX(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    if (paramNode != null) {
      paramString1 = paramNode.getFirstChild();
    }
    for (paramString1 = null; paramString1 != null; paramString1 = paramString1.getNextSibling()) {
      if (paramString1.getNodeType() == 1)
      {
        paramDocument = paramString1.getNodeName();
        paramString2 = paramString1.getFirstChild();
        if (paramString2 != null) {
          paramString2 = paramString2.getNodeValue();
        } else {
          paramString2 = null;
        }
        if (ReadInJoyHelper.a(paramDocument))
        {
          ReadInJoyHelper.a(RIJQQAppInterfaceUtil.a(), paramDocument, paramString2);
        }
        else
        {
          paramNode = this.jdField_a_of_type_JavaLangString;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("find unrecognized key:");
          localStringBuilder.append(paramDocument);
          localStringBuilder.append(" with value:");
          localStringBuilder.append(paramString2);
          QLog.d(paramNode, 1, localStringBuilder.toString());
        }
      }
    }
  }
  
  private final void aY(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    for (;;)
    {
      try
      {
        paramString2 = Integer.valueOf(paramString2);
        int j = 0;
        if (paramDocument == null) {
          break label255;
        }
        paramString1 = paramDocument.getElementsByTagName("effective_time");
        if (paramString1 == null) {
          break label255;
        }
        paramString1 = paramString1.item(0);
        if (paramString1 == null) {
          break label255;
        }
        paramString1 = paramString1.getFirstChild();
        if (paramString1 == null) {
          break label255;
        }
        paramString1 = paramString1.getNodeValue();
        paramString1 = Integer.valueOf(paramString1);
        int i = j;
        if (Intrinsics.compare(paramString2.intValue(), 0) >= 0)
        {
          i = j;
          if (Intrinsics.compare(paramString1.intValue(), 86400) < 0) {
            i = 1;
          }
        }
        if (i != 0)
        {
          paramDocument = RIJQQAppInterfaceUtil.b();
          if (paramDocument != null)
          {
            paramDocument = (IKanDianMergeManager)paramDocument.getRuntimeService(IKanDianMergeManager.class);
            if (paramDocument != null)
            {
              Intrinsics.checkExpressionValueIsNotNull(paramString2, "stickyTime");
              i = paramString2.intValue();
              Intrinsics.checkExpressionValueIsNotNull(paramString1, "effectiveTime");
              paramDocument.updateKanDianPushSetTopMsg(i, paramString1.intValue());
            }
          }
        }
        else
        {
          paramDocument = new StringBuilder();
          paramDocument.append("stickyTime or effectiveTime has error ! ");
          paramDocument.append(paramString2);
          paramDocument.append(',');
          paramDocument.append(paramString1);
          throw ((Throwable)new IllegalArgumentException(paramDocument.toString().toString()));
        }
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        paramString2 = this.jdField_a_of_type_JavaLangString;
        paramDocument = new StringBuilder();
        paramDocument.append("covert stickyTime and effectiveTime has error : ");
        paramDocument.append(paramString1);
        QLog.d(paramString2, 2, paramDocument.toString());
      }
      return;
      label255:
      paramString1 = null;
    }
  }
  
  private final void aZ(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    ReadInJoyHelper.w(RIJQQAppInterfaceUtil.a(), paramString2);
  }
  
  private final void aa(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    if (QLog.isColorLevel())
    {
      paramString1 = this.jdField_a_of_type_JavaLangString;
      paramDocument = new StringBuilder();
      paramDocument.append("kan dian right button new config: ");
      paramDocument.append(paramString2);
      QLog.d(paramString1, 2, paramDocument.toString());
    }
    ReadInJoyHelper.p((AppRuntime)RIJQQAppInterfaceUtil.b(), paramString2);
  }
  
  private final void ab(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    if (QLog.isColorLevel())
    {
      paramString1 = this.jdField_a_of_type_JavaLangString;
      paramDocument = new StringBuilder();
      paramDocument.append("dian dian right button new config: ");
      paramDocument.append(paramString2);
      QLog.d(paramString1, 2, paramDocument.toString());
    }
    ReadInJoyHelper.o((AppRuntime)RIJQQAppInterfaceUtil.b(), paramString2);
  }
  
  private final void ac(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    ReadInJoyHelper.G((AppRuntime)RIJQQAppInterfaceUtil.b(), paramString2);
    paramString1 = this.jdField_a_of_type_JavaLangString;
    paramDocument = new StringBuilder();
    paramDocument.append("update native engine timeout config : ");
    paramDocument.append(paramString2);
    QLog.d(paramString1, 2, paramDocument.toString());
  }
  
  private final void ad(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    ReadInJoyHelper.y((AppRuntime)RIJQQAppInterfaceUtil.b(), Intrinsics.areEqual("1", paramString2));
  }
  
  private final void ae(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, new Object[] { "arkapp_enable_switch, value: ", paramString2 });
    }
    ReadInJoyHelper.b((AppRuntime)RIJQQAppInterfaceUtil.b(), paramString2);
  }
  
  private final void af(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    ReadInJoyHelper.x((AppRuntime)RIJQQAppInterfaceUtil.b(), TextUtils.equals((CharSequence)paramString2, (CharSequence)"1"));
  }
  
  private final void ag(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    FeedsSPUtils.a((AppRuntime)RIJQQAppInterfaceUtil.b(), TextUtils.equals((CharSequence)paramString2, (CharSequence)"1"));
  }
  
  private final void ah(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    if (QLog.isColorLevel())
    {
      paramString1 = this.jdField_a_of_type_JavaLangString;
      paramDocument = new StringBuilder();
      paramDocument.append("IconMerge_InteractiveMsg = ");
      paramDocument.append(paramString2);
      QLog.d(paramString1, 2, paramDocument.toString());
    }
    ReadInJoyHelper.c(paramString2);
  }
  
  private final void ai(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    if (QLog.isColorLevel())
    {
      paramString1 = this.jdField_a_of_type_JavaLangString;
      paramDocument = new StringBuilder();
      paramDocument.append("IconMerge_InteractiveMsg = ");
      paramDocument.append(paramString2);
      QLog.d(paramString1, 2, paramDocument.toString());
    }
    ReadInJoyHelper.b(TextUtils.equals((CharSequence)paramString2, (CharSequence)"1"));
  }
  
  private final void aj(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("IconMerge_BiuMsg = ");
      paramString1.append(paramString2);
      QLog.d("ReadinjoyCommonConfProcessor", 2, paramString1.toString());
    }
    ReadInJoyHelper.a(TextUtils.equals((CharSequence)paramString2, (CharSequence)"1"));
  }
  
  private final void ak(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    if (QLog.isColorLevel())
    {
      paramString1 = this.jdField_a_of_type_JavaLangString;
      paramDocument = new StringBuilder();
      paramDocument.append("biu_profile_switch = ");
      paramDocument.append(paramString2);
      QLog.d(paramString1, 2, paramDocument.toString());
    }
    ReadInJoyHelper.n((AppRuntime)RIJQQAppInterfaceUtil.b(), paramString2);
  }
  
  private final void al(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    if (QLog.isColorLevel())
    {
      paramString1 = this.jdField_a_of_type_JavaLangString;
      paramDocument = new StringBuilder();
      paramDocument.append("comment_at_switch = ");
      paramDocument.append(paramString2);
      QLog.d(paramString1, 2, paramDocument.toString());
    }
    ReadInJoyHelper.u((AppRuntime)RIJQQAppInterfaceUtil.b(), paramString2);
  }
  
  private final void am(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    if (QLog.isColorLevel())
    {
      paramString1 = this.jdField_a_of_type_JavaLangString;
      paramDocument = new StringBuilder();
      paramDocument.append("UGC_at_switch = ");
      paramDocument.append(paramString2);
      QLog.d(paramString1, 2, paramDocument.toString());
    }
    ReadInJoyHelper.l((AppRuntime)RIJQQAppInterfaceUtil.b(), paramString2);
  }
  
  private final void an(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    if (QLog.isColorLevel())
    {
      paramString1 = this.jdField_a_of_type_JavaLangString;
      paramDocument = new StringBuilder();
      paramDocument.append("biu_at_switch = ");
      paramDocument.append(paramString2);
      QLog.d(paramString1, 2, paramDocument.toString());
    }
    ReadInJoyHelper.m((AppRuntime)RIJQQAppInterfaceUtil.b(), paramString2);
  }
  
  private final void ao(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    if (QLog.isColorLevel())
    {
      paramString1 = this.jdField_a_of_type_JavaLangString;
      paramDocument = new StringBuilder();
      paramDocument.append("ugc_gif_switch = ");
      paramDocument.append(paramString2);
      QLog.d(paramString1, 2, paramDocument.toString());
    }
    ReadInJoyHelper.i((AppRuntime)RIJQQAppInterfaceUtil.b(), paramString2);
  }
  
  private final void ap(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    if (QLog.isColorLevel())
    {
      paramString1 = this.jdField_a_of_type_JavaLangString;
      paramDocument = new StringBuilder();
      paramDocument.append("comment_gif_switch = ");
      paramDocument.append(paramString2);
      QLog.d(paramString1, 2, paramDocument.toString());
    }
    ReadInJoyHelper.h((AppRuntime)RIJQQAppInterfaceUtil.b(), paramString2);
  }
  
  private final void aq(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    paramDocument = (CharSequence)paramString2;
    if (!TextUtils.isEmpty(paramDocument))
    {
      paramString1 = new HashMap();
      if (paramString2 == null) {
        Intrinsics.throwNpe();
      }
      paramString2 = ((Collection)new Regex(",").split(paramDocument, 0)).toArray(new String[0]);
      if (paramString2 != null)
      {
        paramString2 = (String[])paramString2;
        int j = paramString2.length;
        int i = 0;
        while (i < j)
        {
          paramDocument = (CharSequence)paramString2[i];
          paramDocument = ((Collection)new Regex(":").split(paramDocument, 0)).toArray(new String[0]);
          if (paramDocument != null)
          {
            paramDocument = (String[])paramDocument;
            if (paramDocument.length == 2) {
              ((Map)paramString1).put(paramDocument[1], paramDocument[0]);
            }
            i += 1;
          }
          else
          {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
          }
        }
        RIJSPUtils.a("kandian_aio_sp_word", paramString1, true);
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }
  }
  
  private final void ar(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    if (QLog.isColorLevel())
    {
      paramString1 = this.jdField_a_of_type_JavaLangString;
      paramDocument = new StringBuilder();
      paramDocument.append("comment_word_count = ");
      paramDocument.append(paramString2);
      QLog.d(paramString1, 2, paramDocument.toString());
    }
    ReadInJoyHelper.g((AppRuntime)RIJQQAppInterfaceUtil.b(), paramString2);
  }
  
  private final void as(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    RIJShowKanDianTabSp.a((AppRuntime)RIJQQAppInterfaceUtil.b(), "kd_topic_recommend_card_jump_url", paramString2);
  }
  
  private final void at(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    RIJShowKanDianTabSp.a((AppRuntime)RIJQQAppInterfaceUtil.b(), "kd_topic_recommend_card_jump_switch", Boolean.valueOf(Intrinsics.areEqual(paramString2, "1")));
  }
  
  private final void au(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    ReadInJoyHelper.F((AppRuntime)RIJQQAppInterfaceUtil.b(), paramString2);
  }
  
  private final void av(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    RIJShowKanDianTabSp.a((AppRuntime)RIJQQAppInterfaceUtil.b(), "remote_kd_tab_type", paramString2);
    paramString1 = (Boolean)RIJSPUtils.a("local_kd_tab_has_set", Boolean.valueOf(false));
    if (!paramString1.booleanValue())
    {
      RIJShowKanDianTabSp.a((AppRuntime)RIJQQAppInterfaceUtil.b(), "local_kd_tab_type", paramString2);
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, new Object[] { "receiveKDTabTypeRemoteSP, userHasSetKDTab = ", paramString1, ", updateLocalTabSwitch tabType = ", paramString2 });
      return;
    }
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, new Object[] { "receiveKDTabTypeRemoteSP, userHasSetKDTab = ", paramString1, ", no need to updateTabType." });
  }
  
  private final void aw(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    if (paramString2 != null)
    {
      paramString1 = (CharSequence)paramString2;
      paramString1 = ((Collection)new Regex(":").split(paramString1, 0)).toArray(new String[0]);
      if (paramString1 != null)
      {
        paramString1 = (String[])paramString1;
        if (paramString1.length >= 2)
        {
          paramString2 = Integer.valueOf(paramString1[0]);
          Intrinsics.checkExpressionValueIsNotNull(paramString2, "Integer.valueOf(indexs[0])");
          int i = paramString2.intValue();
          paramString1 = Integer.valueOf(paramString1[1]);
          Intrinsics.checkExpressionValueIsNotNull(paramString1, "Integer.valueOf(indexs[1])");
          ReadInJoyHelper.b(i, paramString1.intValue());
        }
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
      }
    }
  }
  
  private final void ax(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    if (QLog.isColorLevel())
    {
      paramString1 = this.jdField_a_of_type_JavaLangString;
      paramDocument = new StringBuilder();
      paramDocument.append("kandianWebPreLoadData = ");
      paramDocument.append(paramString2);
      QLog.d(paramString1, 2, paramDocument.toString());
    }
    if (TextUtils.equals((CharSequence)paramString2, (CharSequence)"1"))
    {
      ReadInJoyHelper.w(RIJQQAppInterfaceUtil.a(), true);
      return;
    }
    ReadInJoyHelper.w(RIJQQAppInterfaceUtil.a(), false);
  }
  
  private final void ay(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    if (QLog.isColorLevel())
    {
      paramString1 = this.jdField_a_of_type_JavaLangString;
      paramDocument = new StringBuilder();
      paramDocument.append("local_record_feeds_weishi = ");
      paramDocument.append(paramString2);
      QLog.d(paramString1, 2, paramDocument.toString());
    }
    paramString1 = Integer.valueOf(paramString2);
    paramString2 = RIJQQAppInterfaceUtil.a();
    Intrinsics.checkExpressionValueIsNotNull(paramString1, "cnt");
    ReadInJoyHelper.y(paramString2, paramString1.intValue());
  }
  
  private final void az(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    if (QLog.isColorLevel())
    {
      paramString1 = this.jdField_a_of_type_JavaLangString;
      paramDocument = new StringBuilder();
      paramDocument.append("local_record_time_weishi = ");
      paramDocument.append(paramString2);
      QLog.d(paramString1, 2, paramDocument.toString());
    }
    paramString1 = Long.valueOf(paramString2);
    paramString2 = RIJQQAppInterfaceUtil.a();
    Intrinsics.checkExpressionValueIsNotNull(paramString1, "time");
    ReadInJoyHelper.b(paramString2, paramString1.longValue());
  }
  
  private final void b(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    if (QLog.isColorLevel())
    {
      paramString1 = this.jdField_a_of_type_JavaLangString;
      paramDocument = new StringBuilder();
      paramDocument.append("video_extract_frame = ");
      paramDocument.append(paramString2);
      QLog.d(paramString1, 2, paramDocument.toString());
    }
    RIJSPUtils.a("kandian_video_extract_frame", paramString2);
  }
  
  private final void ba(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    ReadInJoyHelper.c(RIJQQAppInterfaceUtil.a(), paramString2);
  }
  
  private final void bb(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("updateFreeTimeRefreshPush ");
      paramString1.append(TextUtils.equals((CharSequence)paramString2, (CharSequence)"1"));
      QLog.d("ReadinjoyCommonConfProcessor", 2, paramString1.toString());
    }
    ReadInJoyHelper.r(RIJQQAppInterfaceUtil.a(), TextUtils.equals((CharSequence)paramString2, (CharSequence)"1"));
  }
  
  private final void bc(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    ReadInJoyHelper.d(RIJQQAppInterfaceUtil.a(), TextUtils.equals((CharSequence)paramString2, (CharSequence)"1"));
  }
  
  private final void bd(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    ReadInJoyHelper.a(RIJQQAppInterfaceUtil.a(), TextUtils.equals((CharSequence)paramString2, (CharSequence)"1"));
  }
  
  private final void be(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    paramString1 = RIJQQAppInterfaceUtil.a();
    if (paramString1 != null)
    {
      ReadInJoyHelper.b((QQAppInterface)paramString1, paramString2);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
  }
  
  private final void bf(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    paramString1 = RIJQQAppInterfaceUtil.a();
    if (paramString1 != null)
    {
      ReadInJoyHelper.a((QQAppInterface)paramString1, paramString2);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
  }
  
  private final void bg(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    paramString1 = RIJQQAppInterfaceUtil.a();
    if (paramString1 != null)
    {
      ReadInJoyHelper.c((QQAppInterface)paramString1, paramString2);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
  }
  
  private final void c(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    RIJSPUtils.a("kandian_daily_wrapper_drag_text", paramString2);
  }
  
  private final void d(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    RIJSPUtils.a("kandian_daily_wrapper_default_text", paramString2);
  }
  
  private final void e(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    RIJSPUtils.a("kandian_daily_wrapper_alpha", paramString2);
  }
  
  private final void f(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    try
    {
      if (QLog.isColorLevel())
      {
        paramString1 = this.jdField_a_of_type_JavaLangString;
        paramDocument = new StringBuilder();
        paramDocument.append("readinjoy_video_is_download_async_io: ");
        paramDocument.append(paramString2);
        QLog.d(paramString1, 2, paramDocument.toString());
      }
      if (paramString2 == null) {
        Intrinsics.throwNpe();
      }
      RIJSPUtils.a("readinjoy_video_is_download_async_io", Integer.valueOf(Integer.parseInt(paramString2)));
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  private final void g(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    try
    {
      if (QLog.isColorLevel())
      {
        paramString1 = this.jdField_a_of_type_JavaLangString;
        paramDocument = new StringBuilder();
        paramDocument.append("readinjoy_video_is_ff_probelist_switch: ");
        paramDocument.append(paramString2);
        QLog.d(paramString1, 2, paramDocument.toString());
      }
      if (paramString2 == null) {
        Intrinsics.throwNpe();
      }
      RIJSPUtils.a("readinjoy_video_is_ff_probelist_switch", Integer.valueOf(Integer.parseInt(paramString2)));
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  private final void h(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    try
    {
      if (QLog.isColorLevel())
      {
        paramString1 = this.jdField_a_of_type_JavaLangString;
        paramDocument = new StringBuilder();
        paramDocument.append("readinjoy_video_ff_probesize: ");
        paramDocument.append(paramString2);
        QLog.d(paramString1, 2, paramDocument.toString());
      }
      if (paramString2 == null) {
        Intrinsics.throwNpe();
      }
      RIJSPUtils.a("readinjoy_video_ff_probesize", Long.valueOf(Long.parseLong(paramString2)));
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  private final void i(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    if (paramString2 == null) {}
    try
    {
      Intrinsics.throwNpe();
      ReadInJoyHelper.d(Integer.parseInt(paramString2));
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  private final void j(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    if (paramString2 == null) {}
    try
    {
      Intrinsics.throwNpe();
      ReadInJoyHelper.c(Integer.parseInt(paramString2));
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  private final void k(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    if (paramString2 == null) {}
    try
    {
      Intrinsics.throwNpe();
      ReadInJoyHelper.b(Integer.parseInt(paramString2));
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  private final void l(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    RIJSPUtils.a("kandian_daily_fast_web_bottom_share", paramString2);
  }
  
  private final void m(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("kdad_exposure_report_threshold = ");
      paramString1.append(paramString2);
      QLog.d("ReadinjoyCommonConfProcessor", 2, paramString1.toString());
    }
    if (paramString2 == null) {}
    try
    {
      Intrinsics.throwNpe();
      int k = Integer.parseInt(paramString2);
      int j = ReadInJoyConstants.c;
      int i = j;
      if (k == 1) {
        if (paramNode != null)
        {
          i = j;
          if (((Element)paramNode).hasAttribute("time"))
          {
            paramString1 = ((Element)paramNode).getAttribute("time");
            Intrinsics.checkExpressionValueIsNotNull(paramString1, "timeStr");
            k = Integer.parseInt(paramString1);
            i = j;
            if (k > 0) {
              i = k;
            }
          }
        }
        else
        {
          throw new TypeCastException("null cannot be cast to non-null type org.w3c.dom.Element");
        }
      }
      ReadInJoyHelper.C((AppRuntime)RIJQQAppInterfaceUtil.b(), i);
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  private final void n(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    if (paramString2 == null) {
      Intrinsics.throwNpe();
    }
    RIJSPUtils.a("kandianreport_ON", Integer.valueOf(Integer.parseInt(paramString2)));
  }
  
  private final void o(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    paramString1 = PreferenceManager.getDefaultSharedPreferences((Context)BaseApplicationImpl.getApplication()).edit();
    paramDocument = new StringBuilder();
    paramDocument.append("qq_readinjoy_user_protocol_92_jump_url_");
    paramNode = BaseApplicationImpl.getApplication();
    Intrinsics.checkExpressionValueIsNotNull(paramNode, "BaseApplicationImpl.getApplication()");
    paramNode = paramNode.getRuntime();
    Intrinsics.checkExpressionValueIsNotNull(paramNode, "BaseApplicationImpl.getApplication().runtime");
    paramDocument.append(paramNode.getAccount());
    paramString1.putString(paramDocument.toString(), paramString2).apply();
    if (QLog.isColorLevel())
    {
      paramString1 = this.jdField_a_of_type_JavaLangString;
      paramDocument = new StringBuilder();
      paramDocument.append("user_behavior_norm_jump_url: ");
      paramDocument.append(paramString2);
      QLog.d(paramString1, 2, paramDocument.toString());
    }
  }
  
  private final void p(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    paramString1 = PreferenceManager.getDefaultSharedPreferences((Context)BaseApplicationImpl.getApplication()).edit();
    paramDocument = new StringBuilder();
    paramDocument.append("qq_readinjoy_user_protocol_92_switch_");
    paramNode = BaseApplicationImpl.getApplication();
    Intrinsics.checkExpressionValueIsNotNull(paramNode, "BaseApplicationImpl.getApplication()");
    paramNode = paramNode.getRuntime();
    Intrinsics.checkExpressionValueIsNotNull(paramNode, "BaseApplicationImpl.getApplication().runtime");
    paramDocument.append(paramNode.getAccount());
    paramString1.putString(paramDocument.toString(), paramString2).apply();
    if (QLog.isColorLevel())
    {
      paramString1 = this.jdField_a_of_type_JavaLangString;
      paramDocument = new StringBuilder();
      paramDocument.append("user_behavior_norm_switch: ");
      paramDocument.append(paramString2);
      QLog.d(paramString1, 2, paramDocument.toString());
    }
  }
  
  private final void q(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    RIJSPUtils.a("readinjoy_coin_item_title", paramString2);
    if (QLog.isColorLevel())
    {
      paramString1 = this.jdField_a_of_type_JavaLangString;
      paramDocument = new StringBuilder();
      paramDocument.append("coin_item_wording: ");
      paramDocument.append(paramString2);
      QLog.d(paramString1, 2, paramDocument.toString());
    }
  }
  
  private final void r(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    RIJSPUtils.a("readinjoy_coin_item_jump_url", paramString2);
    if (QLog.isColorLevel())
    {
      paramString1 = this.jdField_a_of_type_JavaLangString;
      paramDocument = new StringBuilder();
      paramDocument.append("coin_item_jump_url: ");
      paramDocument.append(paramString2);
      QLog.d(paramString1, 2, paramDocument.toString());
    }
  }
  
  private final void s(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    try
    {
      paramString1 = Integer.valueOf(paramString2);
      bool = true;
      if ((paramString1 == null) || (paramString1.intValue() != 1)) {
        break label84;
      }
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        continue;
        label84:
        boolean bool = false;
      }
    }
    RIJSPUtils.a("sp_key_create_topic_switch", Boolean.valueOf(bool));
    if (QLog.isColorLevel())
    {
      paramString1 = this.jdField_a_of_type_JavaLangString;
      paramDocument = new StringBuilder();
      paramDocument.append("publish_topic: ");
      paramDocument.append(paramString2);
      QLog.d(paramString1, 2, paramDocument.toString());
    }
  }
  
  private final void t(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    if (QLog.isColorLevel())
    {
      paramString1 = this.jdField_a_of_type_JavaLangString;
      paramDocument = new StringBuilder();
      paramDocument.append("kandian_aladdin_configuration_switch: ");
      paramDocument.append(paramString2);
      QLog.d(paramString1, 2, paramDocument.toString());
    }
    RIJSPUtils.a("should_request_aladdin_config", Boolean.valueOf(TextUtils.equals((CharSequence)"1", (CharSequence)paramString2)));
  }
  
  private final void u(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    if (QLog.isColorLevel())
    {
      paramString1 = this.jdField_a_of_type_JavaLangString;
      paramDocument = new StringBuilder();
      paramDocument.append("local_record_feeds_counts_weishi_recommend: ");
      paramDocument.append(paramString2);
      QLog.d(paramString1, 2, paramDocument.toString());
    }
    ReadInJoyHelper.b(paramString2);
  }
  
  private final void v(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    if (QLog.isColorLevel())
    {
      paramString1 = this.jdField_a_of_type_JavaLangString;
      paramDocument = new StringBuilder();
      paramDocument.append("local_record_time_weishi_recommend: ");
      paramDocument.append(paramString2);
      QLog.d(paramString1, 2, paramDocument.toString());
    }
    ReadInJoyHelper.a(paramString2);
  }
  
  private final void w(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    if (paramString2 == null) {
      Intrinsics.throwNpe();
    }
    int i = Integer.parseInt(paramString2);
    RIJSPUtils.a(CommentInfoConstants.READINJOY_UGC_LBS, Integer.valueOf(i));
  }
  
  private final void x(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    if (QLog.isColorLevel())
    {
      paramString1 = this.jdField_a_of_type_JavaLangString;
      paramDocument = new StringBuilder();
      paramDocument.append("weishi_with_channel_discovery_switch: ");
      paramDocument.append(paramString2);
      QLog.d(paramString1, 2, paramDocument.toString());
    }
    ReadInJoyHelper.d(paramString2);
  }
  
  private final void y(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    if (paramString2 != null) {
      paramString1 = Integer.valueOf(Integer.parseInt(paramString2));
    } else {
      paramString1 = null;
    }
    RIJSPUtils.a(CommentInfoConstants.READINJOY_COMMENT_HOT_COMMENT_LIKE_FILTER, paramString1);
  }
  
  private final void z(String paramString1, String paramString2, Document paramDocument, Node paramNode)
  {
    if (paramString2 != null) {
      paramString1 = Integer.valueOf(Integer.parseInt(paramString2));
    } else {
      paramString1 = null;
    }
    RIJSPUtils.a(CommentInfoConstants.READINJOY_COMMENT_HOT_NUM, paramString1);
  }
  
  public final void a(@NotNull QConfItem paramQConfItem)
  {
    Intrinsics.checkParameterIsNotNull(paramQConfItem, "configItme");
    int j;
    int i;
    int k;
    int m;
    try
    {
      paramQConfItem = paramQConfItem.jdField_a_of_type_JavaLangString;
      Intrinsics.checkExpressionValueIsNotNull(paramQConfItem, "configItme.content");
      paramQConfItem = (CharSequence)paramQConfItem;
      j = paramQConfItem.length() - 1;
      i = 0;
      k = 0;
    }
    catch (Exception paramQConfItem)
    {
      label60:
      String str1;
      Object localObject1;
      Document localDocument;
      label216:
      Object localObject2;
      String str2;
      boolean bool;
      NodeList localNodeList;
      label875:
      label886:
      if (!QLog.isColorLevel()) {
        break label937;
      }
      QLog.d("ReadinjoyCommonConfProcessor", 2, "exception occurs", (Throwable)paramQConfItem);
    }
    if (paramQConfItem.charAt(m) <= ' ')
    {
      m = 1;
      break label963;
      str1 = paramQConfItem.subSequence(i, j + 1).toString();
      if (QLog.isColorLevel())
      {
        paramQConfItem = this.jdField_a_of_type_JavaLangString;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("receiveAllConfigs|type: 92,content: ");
        ((StringBuilder)localObject1).append(str1);
        QLog.d(paramQConfItem, 2, ((StringBuilder)localObject1).toString());
      }
      paramQConfItem = DocumentBuilderFactory.newInstance().newDocumentBuilder();
      localObject1 = Charset.forName("utf-8");
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "Charset.forName(charsetName)");
      if (str1 != null)
      {
        localObject1 = str1.getBytes((Charset)localObject1);
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "(this as java.lang.String).getBytes(charset)");
        localDocument = paramQConfItem.parse((InputStream)new ByteArrayInputStream((byte[])localObject1));
        paramQConfItem = localDocument.getElementsByTagName("configs").item(0);
        Intrinsics.checkExpressionValueIsNotNull(paramQConfItem, "sw");
        for (paramQConfItem = paramQConfItem.getFirstChild();; paramQConfItem = ((Node)localObject1).getNextSibling())
        {
          localObject1 = paramQConfItem;
          if (localObject1 == null) {
            break label937;
          }
          if (((Node)localObject1).getFirstChild() == null) {
            break label886;
          }
          paramQConfItem = ((Node)localObject1).getNodeName();
          localObject2 = ((Node)localObject1).getFirstChild();
          Intrinsics.checkExpressionValueIsNotNull(localObject2, "node.firstChild");
          str2 = ((Node)localObject2).getNodeValue();
          if (!TextUtils.isEmpty((CharSequence)str2)) {
            break;
          }
        }
        if (a(paramQConfItem))
        {
          a(paramQConfItem, str2, localDocument, (Node)localObject1);
        }
        else
        {
          bool = TextUtils.equals((CharSequence)paramQConfItem, (CharSequence)"kandian_tab_switch");
          if (bool)
          {
            paramQConfItem = RIJQQAppInterfaceUtil.b();
            Intrinsics.checkExpressionValueIsNotNull(paramQConfItem, "RIJQQAppInterfaceUtil.getApp()");
            Intrinsics.checkExpressionValueIsNotNull(str2, "value");
            a(paramQConfItem, str2);
          }
          else if (TextUtils.equals((CharSequence)paramQConfItem, (CharSequence)"kandiansettings"))
          {
            if (QLog.isColorLevel())
            {
              paramQConfItem = this.jdField_a_of_type_JavaLangString;
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("kandiansettings :");
              ((StringBuilder)localObject2).append(str1);
              QLog.d(paramQConfItem, 2, ((StringBuilder)localObject2).toString());
            }
            ReadInJoyHelper.B((AppRuntime)RIJQQAppInterfaceUtil.b(), str1);
          }
          else if (TextUtils.equals((CharSequence)paramQConfItem, (CharSequence)"readinjoy_small_video_pack_ui_style"))
          {
            ReadInJoyHelper.y((AppRuntime)RIJQQAppInterfaceUtil.b(), str1);
          }
          else if (TextUtils.equals((CharSequence)paramQConfItem, (CharSequence)"awake_time"))
          {
            localNodeList = localDocument.getElementsByTagName("awake_position");
            localObject2 = null;
            if (localNodeList == null) {
              break label1001;
            }
            paramQConfItem = localNodeList.item(0);
          }
        }
      }
    }
    for (;;)
    {
      for (;;)
      {
        if (paramQConfItem == null) {
          break label875;
        }
        paramQConfItem = localNodeList.item(0);
        Intrinsics.checkExpressionValueIsNotNull(paramQConfItem, "posNodeList.item(0)");
        if (paramQConfItem.getFirstChild() == null) {
          break label875;
        }
        localNodeList = localDocument.getElementsByTagName("awake_switch");
        paramQConfItem = (QConfItem)localObject2;
        if (localNodeList != null) {
          paramQConfItem = localNodeList.item(0);
        }
        if (paramQConfItem != null)
        {
          paramQConfItem = localNodeList.item(0);
          Intrinsics.checkExpressionValueIsNotNull(paramQConfItem, "switchNodeList.item(0)");
          if (paramQConfItem.getFirstChild() != null)
          {
            paramQConfItem = localDocument.getElementsByTagName("awake_position").item(0);
            Intrinsics.checkExpressionValueIsNotNull(paramQConfItem, "document.getElementsByTa…\"awake_position\").item(0)");
            paramQConfItem = paramQConfItem.getFirstChild();
            Intrinsics.checkExpressionValueIsNotNull(paramQConfItem, "document.getElementsByTa…tion\").item(0).firstChild");
            paramQConfItem = paramQConfItem.getNodeValue();
            localObject2 = localDocument.getElementsByTagName("awake_switch").item(0);
            Intrinsics.checkExpressionValueIsNotNull(localObject2, "document.getElementsByTa…e(\"awake_switch\").item(0)");
            localObject2 = ((Node)localObject2).getFirstChild();
            Intrinsics.checkExpressionValueIsNotNull(localObject2, "document.getElementsByTa…itch\").item(0).firstChild");
            localObject2 = ((Node)localObject2).getNodeValue();
            try
            {
              Intrinsics.checkExpressionValueIsNotNull(paramQConfItem, "posStr");
              i = Integer.parseInt(paramQConfItem);
              Intrinsics.checkExpressionValueIsNotNull(str2, "value");
              j = Integer.parseInt(str2);
              Intrinsics.checkExpressionValueIsNotNull(localObject2, "switchStr");
              k = Integer.parseInt((String)localObject2);
              if ((j >= 0) && (j <= 86400) && (i >= 0) && (k >= 0) && (k <= 1))
              {
                paramQConfItem = RIJQQAppInterfaceUtil.a();
                if (paramQConfItem != null)
                {
                  paramQConfItem = ((QQAppInterface)paramQConfItem).getManager(QQManagerFactory.KANDIAN_SUBSCRIBE_MANAGER);
                  if (paramQConfItem != null)
                  {
                    ((KandianSubscribeManager)paramQConfItem).a(j, i, k);
                    break label886;
                  }
                  throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianSubscribeManager");
                }
                throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
              }
              QLog.d("ReadinjoyCommonConfProcessor", 2, "sticky kandian subscribe config value is invalid");
              paramQConfItem = ((Node)localObject1).getNextSibling();
            }
            catch (NumberFormatException paramQConfItem)
            {
              paramQConfItem.printStackTrace();
              break label886;
            }
          }
        }
      }
      paramQConfItem = ((Node)localObject1).getNextSibling();
      break label216;
      paramQConfItem = ((Node)localObject1).getNextSibling();
      break label216;
      if (localObject1 == null) {
        Intrinsics.throwNpe();
      }
      paramQConfItem = ((Node)localObject1).getNextSibling();
      break label216;
      throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
      label937:
      return;
      for (;;)
      {
        if (i > j) {
          break label999;
        }
        if (k == 0)
        {
          m = i;
          break;
        }
        m = j;
        break;
        m = 0;
        label963:
        if (k == 0)
        {
          if (m == 0) {
            k = 1;
          } else {
            i += 1;
          }
        }
        else
        {
          if (m == 0) {
            break label60;
          }
          j -= 1;
        }
      }
      label999:
      break label60;
      label1001:
      paramQConfItem = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.config.RIJCommonConfigHandler
 * JD-Core Version:    0.7.0.1
 */