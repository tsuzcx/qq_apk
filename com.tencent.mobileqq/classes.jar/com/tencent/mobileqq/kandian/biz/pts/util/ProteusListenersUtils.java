package com.tencent.mobileqq.kandian.biz.pts.util;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.StringCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdActionUtilService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.ad.api.IRIJVideoAdService;
import com.tencent.mobileqq.kandian.biz.comment.RIJMedalUtils;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.baseui.IReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.fastweb.util.FastWebPTSUtils;
import com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.RIJFeedsDynamicInsertController;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.framework.UserActionCollector;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsHelper;
import com.tencent.mobileqq.kandian.biz.pts.ReadInJoyModelImpl;
import com.tencent.mobileqq.kandian.biz.pts.component.FeedItemCellTypeProteus;
import com.tencent.mobileqq.kandian.biz.pts.data.Util;
import com.tencent.mobileqq.kandian.biz.pts.item.ProteusItemView;
import com.tencent.mobileqq.kandian.biz.pts.listeners.OnAccountCardClickListener;
import com.tencent.mobileqq.kandian.biz.pts.listeners.OnAdLiveExpandCardClickListener;
import com.tencent.mobileqq.kandian.biz.pts.listeners.OnAdLocationClickListener;
import com.tencent.mobileqq.kandian.biz.pts.listeners.OnAnswerCapsuleClickListener;
import com.tencent.mobileqq.kandian.biz.pts.listeners.OnArticleWrapperClickListener;
import com.tencent.mobileqq.kandian.biz.pts.listeners.OnBiuClickListener;
import com.tencent.mobileqq.kandian.biz.pts.listeners.OnCommentClickListener;
import com.tencent.mobileqq.kandian.biz.pts.listeners.OnFriendsBiuClickListener;
import com.tencent.mobileqq.kandian.biz.pts.listeners.OnGalleryCommentClickListener;
import com.tencent.mobileqq.kandian.biz.pts.listeners.OnJumpChannelListener;
import com.tencent.mobileqq.kandian.biz.pts.listeners.OnJumpWrapperClickListener;
import com.tencent.mobileqq.kandian.biz.pts.listeners.OnLikeClickListener;
import com.tencent.mobileqq.kandian.biz.pts.listeners.OnMoreBiuClickListener;
import com.tencent.mobileqq.kandian.biz.pts.listeners.OnPivacyClickListener;
import com.tencent.mobileqq.kandian.biz.pts.listeners.OnReadArticleClickListener;
import com.tencent.mobileqq.kandian.biz.pts.listeners.OnShareClickListener;
import com.tencent.mobileqq.kandian.biz.pts.listeners.OnSmallGameCardClickListener;
import com.tencent.mobileqq.kandian.biz.pts.listeners.OnSocialAvatarClickListener;
import com.tencent.mobileqq.kandian.biz.pts.listeners.OnSocialBiuCountClickListener;
import com.tencent.mobileqq.kandian.biz.pts.listeners.OnSocialHeaderClickListener;
import com.tencent.mobileqq.kandian.biz.pts.listeners.OnSocialHeaderFollowClickListener;
import com.tencent.mobileqq.kandian.biz.pts.listeners.OnSocialLikeCountClickListener;
import com.tencent.mobileqq.kandian.biz.pts.listeners.OnSuperTopicClickListener;
import com.tencent.mobileqq.kandian.biz.pts.listeners.OnTopicCapsuleClickListener;
import com.tencent.mobileqq.kandian.biz.pts.listeners.OnTopicDeliverClickListener;
import com.tencent.mobileqq.kandian.biz.pts.listeners.OnTopicRecommendHeaderClickListener;
import com.tencent.mobileqq.kandian.biz.pts.listeners.OnTopicRecommendHeaderFollowClickListener;
import com.tencent.mobileqq.kandian.biz.pts.listeners.OnUserCommentClickListener;
import com.tencent.mobileqq.kandian.biz.pts.listeners.OnUserCommentEditClickListener;
import com.tencent.mobileqq.kandian.biz.pts.listeners.OnWeChatVideoWatchLaterClickListener;
import com.tencent.mobileqq.kandian.biz.pts.view.impl.NativeAwesomeCommentView;
import com.tencent.mobileqq.kandian.biz.pts.view.impl.NativeSummaryView;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadinjoySPEventReport;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadinjoySPEventReport.UserOptInfo;
import com.tencent.mobileqq.kandian.glue.pts.util.ProteusSupportUtil;
import com.tencent.mobileqq.kandian.glue.report.KandianDailyReportUtils;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.report.dt.RIJDtParamBuilder;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.DailyModeConfigHandler;
import com.tencent.mobileqq.kandian.repo.common.FreeNetFlowInfoModule;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoySrtUtils;
import com.tencent.mobileqq.kandian.repo.db.struct.AwesomeCommentInfo;
import com.tencent.mobileqq.kandian.repo.db.struct.BaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.ActionType;
import com.tencent.mobileqq.kandian.repo.feeds.RIJBaseItemViewType;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsInsertAction;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.NewPolymericInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.kandian.repo.ugc.srtutils.UGRuleManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function9;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/pts/util/ProteusListenersUtils;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "methodsMap", "", "", "Lkotlin/Function9;", "Lcom/tencent/mobileqq/kandian/biz/pts/item/ProteusItemView;", "Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/VafContext;", "Lcom/tencent/mobileqq/app/face/IFaceDecoder;", "Lcom/tencent/mobileqq/kandian/biz/framework/ReadInJoyBaseAdapter;", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/api/IReadInJoyModel;", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/ViewBase;", "Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/container/Container;", "", "STR_ID_CMD_ACCOUNT_CARD_CLICK_FUN", "adapterViewType", "itemView", "vafContext", "faceDecoder", "adapter", "model", "articleInfo", "viewBase", "container", "STR_ID_CMD_AD_BUBBLE_CLICK_FUN", "STR_ID_CMD_AD_COLOR_ICON_CLICK_FUN", "STR_ID_CMD_AD_DOWNLOAD_AREA_CLICK_FUN", "STR_ID_CMD_AD_EDUCATION_TEACHER_ICON_CLICK_FUN", "STR_ID_CMD_AD_EDUCATION_TEACHER_NAME_CLICK_FUN", "STR_ID_CMD_AD_GAME1_CLICK_FUN", "STR_ID_CMD_AD_IMG_CLICK_FUN", "STR_ID_CMD_AD_LIVE_EXPAND_CLICK_FUN", "STR_ID_CMD_AD_NAME_CLICK_IN_RECOMMEND_FUN", "STR_ID_CMD_AD_NOTHING_CLICK_IN_RECOMMEND_FUN", "STR_ID_CMD_AD_OPERATION_PK_LEFT_FUN", "STR_ID_CMD_AD_TAGS_CLICK_FUN", "STR_ID_CMD_AD_TEXT_CLICK_FUN", "STR_ID_CMD_AD_TITLE_CLICK_IN_RECOMMEND_FUN", "STR_ID_CMD_ANSWER_CAPSULE_CLICK_FUN", "STR_ID_CMD_ARTICLE_WRAPPER_CLICK_FUN", "STR_ID_CMD_AWESOME_CLICK_FUN", "STR_ID_CMD_BIU_CLICK_FUN", "STR_ID_CMD_CMD_SOCIAL_BOTTOM_CLICK_FUN", "STR_ID_CMD_COMMENT_CLICK_FUN", "STR_ID_CMD_COMMUNITY_CLICK_FUN", "STR_ID_CMD_DISLIKE_CLICK_FUN", "STR_ID_CMD_FRIENDS_BIU_FUN", "STR_ID_CMD_GALLERY_COMMENT_CLICK_FUN", "STR_ID_CMD_HEAD_MEDAL_CLICK_FUN", "STR_ID_CMD_HOT_QUESTION_HEAD_CLICK_FUN", "STR_ID_CMD_JUMP_CLICK_FUN", "STR_ID_CMD_JUMP_WRAPPER_CLICK_FUN", "STR_ID_CMD_LARGET_VIDEO_ACTIVITY_WRAPPER_CLICK_FUN", "STR_ID_CMD_LARGE_IMG_CLICK_FUN", "STR_ID_CMD_LARGE_VIDEO_CLICK_FUN", "STR_ID_CMD_LIKE_CLICK_FUN", "STR_ID_CMD_LOCATION_CLICK_FUN", "STR_ID_CMD_NATIVE_DETAIL_AD_NEGATIVE_CLICK_FUN", "STR_ID_CMD_PACK_BOTTOM_CLICK_FUN", "STR_ID_CMD_PARTNER_HEADER_CLICK_FUN", "STR_ID_CMD_PRIVACY_LIST_CLICK_FUN", "STR_ID_CMD_READ_ARTICLE_CLICK_FUN", "STR_ID_CMD_RIGHT_DISLIKE_CLICK_FUN", "STR_ID_CMD_SHARE_CLICK_FUN", "STR_ID_CMD_SOCIAL_AVATAR_CLICK_FUN", "STR_ID_CMD_SOCIAL_DATA_BIU_CLICK_FUN", "STR_ID_CMD_SOCIAL_DATA_LIKE_CLICK_FUN", "STR_ID_CMD_SOCIAL_HEADER_FOLLOW_BUTTON_CLICK_FUN", "STR_ID_CMD_SUMMARY_CLICK_FUN", "STR_ID_CMD_SUPER_TOPIC_BUTTON_CLICK_FUN", "STR_ID_CMD_SUPER_TOPIC_CLICK_FUN", "STR_ID_CMD_TOPIC_CAPSULE_CLICK_FUN", "STR_ID_CMD_TOPIC_RECOMMEND_HEADER_CLICK_FUN", "STR_ID_CMD_TOPIC_RECOMMEND_HEADER_FOLLOW_CLICK_FUN", "STR_ID_CMD_UGC_AD_CLICK_FUN", "STR_ID_CMD_URL_CLICK_CARD_REPORT_FUN", "STR_ID_CMD_URL_CLICK_NO_CARD_REPORT_FUN", "STR_ID_CMD_USERS_COMMENT_EDIT_FUN", "STR_ID_CMD_USERS_COMMENT_FUN", "STR_ID_COMMENT_BIU_MORE_IMG_FUN", "STR_ID_FAMILY_ICON_CLICK_FUN", "STR_ID_STR_ID_CMD_WE_CHAT_SEE_LATER_CLICK_FUN", "doNothing", "getContext", "Landroid/content/Context;", "getModelChannelID", "invokeListener", "cmd", "viewType", "view", "context", "face", "ad", "iModel", "info", "base", "con", "registerListeners", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ProteusListenersUtils
{
  public static final ProteusListenersUtils a;
  @NotNull
  private static final String jdField_a_of_type_JavaLangString = "ProteusListenersUtils";
  private static final Map<Integer, Function9<Integer, ProteusItemView, VafContext, IFaceDecoder, ReadInJoyBaseAdapter, IReadInJoyModel, AbsBaseArticleInfo, ViewBase, Container, Unit>> jdField_a_of_type_JavaUtilMap;
  
  static
  {
    ProteusListenersUtils localProteusListenersUtils = new ProteusListenersUtils();
    jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusListenersUtils = localProteusListenersUtils;
    jdField_a_of_type_JavaLangString = "ProteusListenersUtils";
    jdField_a_of_type_JavaUtilMap = (Map)new LinkedHashMap();
    localProteusListenersUtils.a();
  }
  
  private final int a(IReadInJoyModel paramIReadInJoyModel)
  {
    if (paramIReadInJoyModel != null) {
      return paramIReadInJoyModel.c();
    }
    return 0;
  }
  
  private final void a()
  {
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1001), new ProteusListenersUtils.registerListeners.1(jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusListenersUtils));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1199), new ProteusListenersUtils.registerListeners.2(jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusListenersUtils));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1071), new ProteusListenersUtils.registerListeners.3(jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusListenersUtils));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1002), new ProteusListenersUtils.registerListeners.4(jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusListenersUtils));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1020), new ProteusListenersUtils.registerListeners.5(jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusListenersUtils));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1025), new ProteusListenersUtils.registerListeners.6(jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusListenersUtils));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1003), new ProteusListenersUtils.registerListeners.7(jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusListenersUtils));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1004), new ProteusListenersUtils.registerListeners.8(jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusListenersUtils));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1005), new ProteusListenersUtils.registerListeners.9(jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusListenersUtils));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1034), new ProteusListenersUtils.registerListeners.10(jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusListenersUtils));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1006), new ProteusListenersUtils.registerListeners.11(jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusListenersUtils));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1007), new ProteusListenersUtils.registerListeners.12(jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusListenersUtils));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1008), new ProteusListenersUtils.registerListeners.13(jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusListenersUtils));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1010), new ProteusListenersUtils.registerListeners.14(jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusListenersUtils));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1012), new ProteusListenersUtils.registerListeners.15(jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusListenersUtils));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1013), new ProteusListenersUtils.registerListeners.16(jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusListenersUtils));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1014), new ProteusListenersUtils.registerListeners.17(jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusListenersUtils));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1015), new ProteusListenersUtils.registerListeners.18(jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusListenersUtils));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1016), new ProteusListenersUtils.registerListeners.19(jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusListenersUtils));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1037), new ProteusListenersUtils.registerListeners.20(jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusListenersUtils));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1019), new ProteusListenersUtils.registerListeners.21(jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusListenersUtils));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1021), new ProteusListenersUtils.registerListeners.22(jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusListenersUtils));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1022), new ProteusListenersUtils.registerListeners.23(jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusListenersUtils));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1023), new ProteusListenersUtils.registerListeners.24(jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusListenersUtils));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1026), new ProteusListenersUtils.registerListeners.25(jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusListenersUtils));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1027), new ProteusListenersUtils.registerListeners.26(jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusListenersUtils));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1028), new ProteusListenersUtils.registerListeners.27(jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusListenersUtils));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1030), new ProteusListenersUtils.registerListeners.28(jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusListenersUtils));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1032), new ProteusListenersUtils.registerListeners.29(jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusListenersUtils));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1033), new ProteusListenersUtils.registerListeners.30(jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusListenersUtils));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1036), new ProteusListenersUtils.registerListeners.31(jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusListenersUtils));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1175), new ProteusListenersUtils.registerListeners.32(jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusListenersUtils));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1176), new ProteusListenersUtils.registerListeners.33(jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusListenersUtils));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1158), new ProteusListenersUtils.registerListeners.34(jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusListenersUtils));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1038), new ProteusListenersUtils.registerListeners.35(jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusListenersUtils));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1040), new ProteusListenersUtils.registerListeners.36(jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusListenersUtils));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1039), new ProteusListenersUtils.registerListeners.37(jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusListenersUtils));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1043), new ProteusListenersUtils.registerListeners.38(jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusListenersUtils));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1103), new ProteusListenersUtils.registerListeners.39(jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusListenersUtils));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1104), new ProteusListenersUtils.registerListeners.40(jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusListenersUtils));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1106), new ProteusListenersUtils.registerListeners.41(jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusListenersUtils));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1112), new ProteusListenersUtils.registerListeners.42(jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusListenersUtils));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1111), new ProteusListenersUtils.registerListeners.43(jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusListenersUtils));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1110), new ProteusListenersUtils.registerListeners.44(jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusListenersUtils));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1109), new ProteusListenersUtils.registerListeners.45(jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusListenersUtils));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1108), new ProteusListenersUtils.registerListeners.46(jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusListenersUtils));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1107), new ProteusListenersUtils.registerListeners.47(jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusListenersUtils));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1113), new ProteusListenersUtils.registerListeners.48(jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusListenersUtils));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1120), new ProteusListenersUtils.registerListeners.49(jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusListenersUtils));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1115), new ProteusListenersUtils.registerListeners.50(jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusListenersUtils));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1114), new ProteusListenersUtils.registerListeners.51(jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusListenersUtils));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1116), new ProteusListenersUtils.registerListeners.52(jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusListenersUtils));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1117), new ProteusListenersUtils.registerListeners.53(jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusListenersUtils));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1118), new ProteusListenersUtils.registerListeners.54(jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusListenersUtils));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1119), new ProteusListenersUtils.registerListeners.55(jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusListenersUtils));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1121), new ProteusListenersUtils.registerListeners.56(jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusListenersUtils));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1122), new ProteusListenersUtils.registerListeners.57(jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusListenersUtils));
    Map localMap = jdField_a_of_type_JavaUtilMap;
    Integer localInteger = Integer.valueOf(1044);
    localMap.put(localInteger, new ProteusListenersUtils.registerListeners.58(jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusListenersUtils));
    jdField_a_of_type_JavaUtilMap.put(localInteger, new ProteusListenersUtils.registerListeners.59(jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusListenersUtils));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1045), new ProteusListenersUtils.registerListeners.60(jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusListenersUtils));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1046), new ProteusListenersUtils.registerListeners.61(jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusListenersUtils));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1047), new ProteusListenersUtils.registerListeners.62(jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusListenersUtils));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1065), new ProteusListenersUtils.registerListeners.63(jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusListenersUtils));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1066), new ProteusListenersUtils.registerListeners.64(jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusListenersUtils));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1067), new ProteusListenersUtils.registerListeners.65(jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusListenersUtils));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1157), new ProteusListenersUtils.registerListeners.66(jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusListenersUtils));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1085), new ProteusListenersUtils.registerListeners.67(jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusListenersUtils));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1099), new ProteusListenersUtils.registerListeners.68(jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusListenersUtils));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1100), new ProteusListenersUtils.registerListeners.69(jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusListenersUtils));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1101), new ProteusListenersUtils.registerListeners.70(jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusListenersUtils));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1102), new ProteusListenersUtils.registerListeners.71(jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusListenersUtils));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1098), new ProteusListenersUtils.registerListeners.72(jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusListenersUtils));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1180), new ProteusListenersUtils.registerListeners.73(jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusListenersUtils));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1181), new ProteusListenersUtils.registerListeners.74(jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusListenersUtils));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1041), new ProteusListenersUtils.registerListeners.75(jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusListenersUtils));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1196), new ProteusListenersUtils.registerListeners.76(jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusListenersUtils));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1198), new ProteusListenersUtils.registerListeners.77(jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusListenersUtils));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1197), new ProteusListenersUtils.registerListeners.78(jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusListenersUtils));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1200), new ProteusListenersUtils.registerListeners.79(jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusListenersUtils));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1201), new ProteusListenersUtils.registerListeners.80(jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusListenersUtils));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1202), new ProteusListenersUtils.registerListeners.81(jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusListenersUtils));
  }
  
  public final void A(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    paramProteusItemView = ReadInJoyLogicEngine.a();
    Intrinsics.checkExpressionValueIsNotNull(paramProteusItemView, "ReadInJoyLogicEngine.getInstance()");
    paramProteusItemView = paramProteusItemView.a();
    if ((paramProteusItemView != null) && (paramAbsBaseArticleInfo != null) && (paramContainer != null))
    {
      paramAbsBaseArticleInfo.isShowFreeNetFlow = false;
      ReadInJoyUtils.a(a(paramVafContext), paramProteusItemView.a());
      RIJComponentConfigImage.a(false, paramContainer.getVirtualView(), null);
      PTSRijReport.a("0X8009661");
    }
  }
  
  public final void B(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    new OnJumpChannelListener(paramAbsBaseArticleInfo, a(paramVafContext), paramInt).onClick(paramViewBase);
  }
  
  public final void C(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    paramVafContext = a(paramVafContext);
    if (paramViewBase != null) {
      paramProteusItemView = paramViewBase.getEventAttachedData();
    } else {
      paramProteusItemView = null;
    }
    new OnTopicDeliverClickListener(paramAbsBaseArticleInfo, paramVafContext, paramInt, paramProteusItemView).onClick(paramViewBase);
  }
  
  public final void D(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer) {}
  
  public final void E(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    new OnShareClickListener(paramAbsBaseArticleInfo, a(paramVafContext)).onClick(paramViewBase);
  }
  
  public final void F(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    new OnPivacyClickListener(a(paramVafContext), paramAbsBaseArticleInfo).onClick(paramViewBase);
  }
  
  public final void G(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    if (((paramAbsBaseArticleInfo instanceof BaseArticleInfo)) && (paramAbsBaseArticleInfo.mProteusTemplateBean != null))
    {
      if (paramReadInJoyBaseAdapter == null) {
        return;
      }
      int i = paramReadInJoyBaseAdapter.a();
      paramIReadInJoyModel = null;
      if ((i == 0) || (DailyModeConfigHandler.c(paramReadInJoyBaseAdapter.a())))
      {
        localObject = ReadinjoySPEventReport.a().a;
        if (paramContainer != null) {
          paramIFaceDecoder = paramContainer.getRootView();
        } else {
          paramIFaceDecoder = null;
        }
        ((ReadinjoySPEventReport.UserOptInfo)localObject).a(paramIFaceDecoder, (AbsListView)paramReadInJoyBaseAdapter.a(), paramAbsBaseArticleInfo);
        localObject = UserActionCollector.a();
        if (paramContainer != null) {
          paramIFaceDecoder = paramContainer.getRootView();
        } else {
          paramIFaceDecoder = null;
        }
        ((UserActionCollector)localObject).a(paramIFaceDecoder, (AbsListView)paramReadInJoyBaseAdapter.a(), paramAbsBaseArticleInfo);
      }
      if (DailyModeConfigHandler.c(paramReadInJoyBaseAdapter.a()))
      {
        if (RIJFeedsType.a(paramAbsBaseArticleInfo)) {
          i = 4;
        } else {
          i = 2;
        }
        KandianDailyReportUtils.a(i);
        paramIFaceDecoder = jdField_a_of_type_JavaLangString;
        paramContainer = new StringBuilder();
        paramContainer.append("click daily card , update operationFlag : ");
        paramContainer.append(i);
        QLog.d(paramIFaceDecoder, 2, paramContainer.toString());
      }
      paramIFaceDecoder = paramAbsBaseArticleInfo.mProteusTemplateBean;
      Intrinsics.checkExpressionValueIsNotNull(paramIFaceDecoder, "articleInfo.mProteusTemplateBean");
      paramContainer = paramIFaceDecoder.getStyleName();
      Object localObject = ProteusSupportUtil.a(null, paramInt, paramAbsBaseArticleInfo);
      if (localObject != null)
      {
        if (paramViewBase != null) {
          paramIFaceDecoder = paramViewBase.getName();
        } else {
          paramIFaceDecoder = null;
        }
        ProteusSupportUtil.a(((TemplateBean)localObject).findViewById(paramIFaceDecoder));
      }
      if (paramProteusItemView != null) {
        EventCollector.getInstance().onViewClicked((View)paramProteusItemView);
      }
      boolean bool = false;
      if (!UGRuleManager.c(paramAbsBaseArticleInfo)) {
        bool = ReadInJoySrtUtils.a().a(paramAbsBaseArticleInfo, (TemplateBean)localObject, paramViewBase);
      }
      ProteusSupportUtil.a(paramAbsBaseArticleInfo, (TemplateBean)localObject, paramViewBase);
      ReadInJoyLogicEngine.a().a(paramAbsBaseArticleInfo.mArticleID, System.currentTimeMillis());
      paramAbsBaseArticleInfo.invalidateProteusTemplateBean();
      paramReadInJoyBaseAdapter.notifyDataSetChanged();
      ProteusSupportUtil.a(paramAbsBaseArticleInfo, paramViewBase, (TemplateBean)localObject);
      paramProteusItemView = ProteusSupportUtil.a(paramAbsBaseArticleInfo);
      paramIFaceDecoder = ReadInJoySrtUtils.a();
      Intrinsics.checkExpressionValueIsNotNull(paramIFaceDecoder, "ReadInJoySrtUtils.getInstance()");
      paramIFaceDecoder = paramIFaceDecoder.a();
      if (!TextUtils.isEmpty((CharSequence)paramProteusItemView))
      {
        if (UGRuleManager.a(paramProteusItemView)) {
          RIJJumpUtils.a(a(paramVafContext), paramAbsBaseArticleInfo, paramProteusItemView);
        } else {
          VideoFeedsHelper.a(a(paramVafContext), paramProteusItemView);
        }
        paramProteusItemView = jdField_a_of_type_JavaLangString;
        paramVafContext = new StringBuilder();
        paramVafContext.append("UGRuleManager articleInfo hit ug title");
        paramVafContext.append(paramAbsBaseArticleInfo.mTitle);
        QLog.d(paramProteusItemView, 1, paramVafContext.toString());
        return;
      }
      if ((!UGRuleManager.c(paramAbsBaseArticleInfo)) && (bool) && (!TextUtils.isEmpty((CharSequence)paramIFaceDecoder)))
      {
        RIJJumpUtils.a(a(paramVafContext), paramAbsBaseArticleInfo, paramIFaceDecoder);
        return;
      }
      if ((!UGRuleManager.c(paramAbsBaseArticleInfo)) && (!ReadInJoySrtUtils.a().a()) && (RIJTransMergeKanDianReport.a(a(paramVafContext), paramAbsBaseArticleInfo, paramContainer)))
      {
        RIJJumpUtils.a(a(paramVafContext), paramAbsBaseArticleInfo, RIJJumpUtils.b(paramAbsBaseArticleInfo.getInnerUniqueID()));
        return;
      }
      paramVafContext = a(paramVafContext);
      paramProteusItemView = paramIReadInJoyModel;
      if (paramViewBase != null) {
        paramProteusItemView = paramViewBase.getEventAttachedData();
      }
      RIJJumpUtils.a(paramVafContext, paramAbsBaseArticleInfo, paramProteusItemView);
      return;
    }
    QLog.d(jdField_a_of_type_JavaLangString, 1, "click exception, return ");
  }
  
  public final void H(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    if (((paramAbsBaseArticleInfo instanceof AdvertisementInfo)) && (paramIReadInJoyModel != null))
    {
      paramIFaceDecoder = (IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class);
      if (paramContainer != null) {
        paramProteusItemView = paramContainer.getVirtualView();
      } else {
        paramProteusItemView = null;
      }
      paramVafContext = a(paramVafContext);
      if (paramVafContext != null)
      {
        paramIFaceDecoder.processAdClickWithPos(paramProteusItemView, paramViewBase, (Activity)paramVafContext, (AbsBaseArticleInfo)paramAbsBaseArticleInfo, paramIReadInJoyModel.a(), a(paramIReadInJoyModel), 5);
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type android.app.Activity");
    }
  }
  
  public final void I(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    if (paramIReadInJoyModel != null)
    {
      paramIFaceDecoder = (IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class);
      if (paramContainer != null) {
        paramProteusItemView = paramContainer.getVirtualView();
      } else {
        paramProteusItemView = null;
      }
      paramVafContext = jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusListenersUtils.a(paramVafContext);
      if (paramVafContext != null)
      {
        paramIFaceDecoder.processAdClickWithPos(paramProteusItemView, paramViewBase, (Activity)paramVafContext, (AbsBaseArticleInfo)paramAbsBaseArticleInfo, paramIReadInJoyModel.a(), jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusListenersUtils.a(paramIReadInJoyModel), 5);
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type android.app.Activity");
    }
  }
  
  public final void J(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    if (paramIReadInJoyModel != null)
    {
      paramIFaceDecoder = (IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class);
      if (paramContainer != null) {
        paramProteusItemView = paramContainer.getVirtualView();
      } else {
        paramProteusItemView = null;
      }
      paramVafContext = jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusListenersUtils.a(paramVafContext);
      if (paramVafContext != null)
      {
        paramIFaceDecoder.processAdClickWithPos(paramProteusItemView, paramViewBase, (Activity)paramVafContext, (AbsBaseArticleInfo)paramAbsBaseArticleInfo, paramIReadInJoyModel.a(), jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusListenersUtils.a(paramIReadInJoyModel), 8);
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type android.app.Activity");
    }
  }
  
  public final void K(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    if (paramIReadInJoyModel != null)
    {
      paramIFaceDecoder = null;
      if (paramViewBase != null) {
        paramProteusItemView = paramViewBase.getClickEvnet();
      } else {
        paramProteusItemView = null;
      }
      paramInt = StringCommon.getStrIdFromString(paramProteusItemView);
      paramReadInJoyBaseAdapter = (IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class);
      paramProteusItemView = paramIFaceDecoder;
      if (paramContainer != null) {
        paramProteusItemView = paramContainer.getVirtualView();
      }
      paramVafContext = jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusListenersUtils.a(paramVafContext);
      if (paramVafContext != null)
      {
        paramReadInJoyBaseAdapter.processAdClickWithPos(paramProteusItemView, paramViewBase, (Activity)paramVafContext, (AbsBaseArticleInfo)paramAbsBaseArticleInfo, paramIReadInJoyModel.a(), jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusListenersUtils.a(paramIReadInJoyModel), ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getClickPos(paramInt));
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type android.app.Activity");
    }
  }
  
  public final void L(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    if (paramIReadInJoyModel != null)
    {
      if (paramViewBase != null) {
        paramProteusItemView = paramViewBase.getClickEvnet();
      } else {
        paramProteusItemView = null;
      }
      paramInt = StringCommon.getStrIdFromString(paramProteusItemView);
      new OnSmallGameCardClickListener(paramIReadInJoyModel, jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusListenersUtils.a(paramVafContext), paramInt, paramIReadInJoyModel.c(), paramIReadInJoyModel.g()).onClick(paramViewBase);
    }
  }
  
  public final void M(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    if (paramIReadInJoyModel != null)
    {
      if (paramViewBase != null) {
        paramProteusItemView = paramViewBase.getClickEvnet();
      } else {
        paramProteusItemView = null;
      }
      paramInt = StringCommon.getStrIdFromString(paramProteusItemView);
      new OnAdLiveExpandCardClickListener(paramIReadInJoyModel, jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusListenersUtils.a(paramVafContext), paramInt, paramIReadInJoyModel.g()).onClick(paramViewBase);
    }
  }
  
  public final void N(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    if (((paramAbsBaseArticleInfo instanceof AdvertisementInfo)) && (paramIReadInJoyModel != null))
    {
      paramProteusItemView = (IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class);
      paramIFaceDecoder = (AdvertisementInfo)paramAbsBaseArticleInfo;
      paramProteusItemView.recordAdVideoClick(paramIFaceDecoder);
      paramReadInJoyBaseAdapter = (IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class);
      if (paramContainer != null) {
        paramProteusItemView = paramContainer.getVirtualView();
      } else {
        paramProteusItemView = null;
      }
      paramVafContext = a(paramVafContext);
      if (paramVafContext != null)
      {
        paramReadInJoyBaseAdapter.processAdClickWithPos(paramProteusItemView, paramViewBase, (Activity)paramVafContext, (AbsBaseArticleInfo)paramIFaceDecoder, paramIReadInJoyModel.a(), a(paramIReadInJoyModel), 6);
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type android.app.Activity");
    }
  }
  
  public final void O(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    if ((((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).isUgcAd(paramAbsBaseArticleInfo)) && (paramIReadInJoyModel != null)) {
      ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).jumpToGdtAdPage(a(paramVafContext), (AdvertisementInfo)paramAbsBaseArticleInfo, paramIReadInJoyModel.a(), a(paramIReadInJoyModel), false);
    }
  }
  
  public final void P(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    new OnGalleryCommentClickListener(paramAbsBaseArticleInfo, a(paramVafContext)).onClick(paramViewBase);
  }
  
  public final void Q(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    if (paramAbsBaseArticleInfo != null) {
      RIJMedalUtils.a(a(paramVafContext), paramAbsBaseArticleInfo);
    }
  }
  
  public final void R(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer) {}
  
  public final void S(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    AwesomeCommentInfo.a(paramAbsBaseArticleInfo, "0X8009B77", RIJBaseItemViewType.a(paramAbsBaseArticleInfo, 0), NativeAwesomeCommentView.a());
    paramVafContext = a(paramVafContext);
    if (paramAbsBaseArticleInfo != null) {
      paramProteusItemView = paramAbsBaseArticleInfo.jumpUrl;
    } else {
      paramProteusItemView = null;
    }
    RIJJumpUtils.a(paramVafContext, paramAbsBaseArticleInfo, paramProteusItemView);
  }
  
  public final void T(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    if (paramAbsBaseArticleInfo != null)
    {
      paramIFaceDecoder = a(paramVafContext);
      paramVafContext = null;
      if (paramViewBase != null) {
        paramProteusItemView = paramViewBase.getEventAttachedData();
      } else {
        paramProteusItemView = null;
      }
      RIJJumpUtils.a(paramIFaceDecoder, paramAbsBaseArticleInfo, paramProteusItemView);
      paramIFaceDecoder = jdField_a_of_type_JavaLangString;
      paramReadInJoyBaseAdapter = new StringBuilder();
      paramReadInJoyBaseAdapter.append("familyJumpUrl ");
      paramProteusItemView = paramVafContext;
      if (paramViewBase != null) {
        paramProteusItemView = paramViewBase.getEventAttachedData();
      }
      paramReadInJoyBaseAdapter.append(paramProteusItemView);
      QLog.d(paramIFaceDecoder, 2, paramReadInJoyBaseAdapter.toString());
    }
  }
  
  public final void U(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    new OnAdLocationClickListener(paramAbsBaseArticleInfo, a(paramVafContext)).onClick(paramViewBase);
  }
  
  public final void V(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    if (paramIReadInJoyModel != null)
    {
      paramIFaceDecoder = (IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class);
      if (paramContainer != null) {
        paramProteusItemView = paramContainer.getVirtualView();
      } else {
        paramProteusItemView = null;
      }
      paramVafContext = jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusListenersUtils.a(paramVafContext);
      if (paramVafContext != null)
      {
        paramIFaceDecoder.processAdClickWithPos(paramProteusItemView, paramViewBase, (Activity)paramVafContext, (AbsBaseArticleInfo)paramAbsBaseArticleInfo, paramIReadInJoyModel.a(), jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusListenersUtils.a(paramIReadInJoyModel), 4);
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type android.app.Activity");
    }
  }
  
  public final void W(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    if (paramIReadInJoyModel != null)
    {
      paramIFaceDecoder = (IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class);
      if (paramContainer != null) {
        paramProteusItemView = paramContainer.getVirtualView();
      } else {
        paramProteusItemView = null;
      }
      paramVafContext = jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusListenersUtils.a(paramVafContext);
      if (paramVafContext != null)
      {
        paramIFaceDecoder.processAdClickWithPos(paramProteusItemView, paramViewBase, (Activity)paramVafContext, (AbsBaseArticleInfo)paramAbsBaseArticleInfo, paramIReadInJoyModel.a(), jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusListenersUtils.a(paramIReadInJoyModel), 1);
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type android.app.Activity");
    }
  }
  
  public final void X(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    if (paramIReadInJoyModel != null)
    {
      paramIFaceDecoder = (IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class);
      if (paramContainer != null) {
        paramProteusItemView = paramContainer.getVirtualView();
      } else {
        paramProteusItemView = null;
      }
      paramVafContext = jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusListenersUtils.a(paramVafContext);
      if (paramVafContext != null)
      {
        paramIFaceDecoder.processAdClickWithPos(paramProteusItemView, paramViewBase, (Activity)paramVafContext, (AbsBaseArticleInfo)paramAbsBaseArticleInfo, paramIReadInJoyModel.a(), jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusListenersUtils.a(paramIReadInJoyModel), 9);
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type android.app.Activity");
    }
  }
  
  public final void Y(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    if (paramIReadInJoyModel != null)
    {
      paramIFaceDecoder = (IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class);
      if (paramContainer != null) {
        paramProteusItemView = paramContainer.getVirtualView();
      } else {
        paramProteusItemView = null;
      }
      paramVafContext = jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusListenersUtils.a(paramVafContext);
      if (paramVafContext != null)
      {
        paramIFaceDecoder.processAdClickWithPos(paramProteusItemView, paramViewBase, (Activity)paramVafContext, (AbsBaseArticleInfo)paramAbsBaseArticleInfo, paramIReadInJoyModel.a(), jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusListenersUtils.a(paramIReadInJoyModel), 28);
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type android.app.Activity");
    }
  }
  
  public final void Z(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    if (paramIReadInJoyModel != null)
    {
      paramIFaceDecoder = (IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class);
      if (paramContainer != null) {
        paramProteusItemView = paramContainer.getVirtualView();
      } else {
        paramProteusItemView = null;
      }
      paramVafContext = jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusListenersUtils.a(paramVafContext);
      if (paramVafContext != null)
      {
        paramIFaceDecoder.processAdClickWithPos(paramProteusItemView, paramViewBase, (Activity)paramVafContext, (AbsBaseArticleInfo)paramAbsBaseArticleInfo, paramIReadInJoyModel.a(), jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusListenersUtils.a(paramIReadInJoyModel), 2);
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type android.app.Activity");
    }
  }
  
  @Nullable
  public final Context a(@Nullable VafContext paramVafContext)
  {
    Context localContext = (Context)null;
    if (paramVafContext != null) {
      localContext = paramVafContext.getContext();
    }
    paramVafContext = localContext;
    if (localContext == null) {
      paramVafContext = (Context)BaseApplication.getContext();
    }
    return paramVafContext;
  }
  
  public final void a(int paramInt1, int paramInt2, @NotNull ProteusItemView paramProteusItemView, @NotNull VafContext paramVafContext, @NotNull IFaceDecoder paramIFaceDecoder, @NotNull ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @NotNull IReadInJoyModel paramIReadInJoyModel, @NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo, @NotNull ViewBase paramViewBase, @NotNull Container paramContainer)
  {
    Intrinsics.checkParameterIsNotNull(paramProteusItemView, "view");
    Intrinsics.checkParameterIsNotNull(paramVafContext, "context");
    Intrinsics.checkParameterIsNotNull(paramIFaceDecoder, "face");
    Intrinsics.checkParameterIsNotNull(paramReadInJoyBaseAdapter, "ad");
    Intrinsics.checkParameterIsNotNull(paramIReadInJoyModel, "iModel");
    Intrinsics.checkParameterIsNotNull(paramAbsBaseArticleInfo, "info");
    Intrinsics.checkParameterIsNotNull(paramViewBase, "base");
    Intrinsics.checkParameterIsNotNull(paramContainer, "con");
    Function9 localFunction9 = (Function9)jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt1));
    if ((localFunction9 != null) && ((Unit)localFunction9.invoke(Integer.valueOf(paramInt2), paramProteusItemView, paramVafContext, paramIFaceDecoder, paramReadInJoyBaseAdapter, paramIReadInJoyModel, paramAbsBaseArticleInfo, paramViewBase, paramContainer) != null)) {
      return;
    }
    ag(paramInt2, paramProteusItemView, paramVafContext, paramIFaceDecoder, paramReadInJoyBaseAdapter, paramIReadInJoyModel, paramAbsBaseArticleInfo, paramViewBase, paramContainer);
    paramProteusItemView = Unit.INSTANCE;
  }
  
  public final void a(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    if ((paramContainer != null) && (paramReadInJoyBaseAdapter != null))
    {
      if (paramIReadInJoyModel == null) {
        return;
      }
      paramProteusItemView = a(paramVafContext);
      if ((paramProteusItemView != null) && (paramViewBase != null))
      {
        paramProteusItemView = new FeedItemCellTypeProteus(paramProteusItemView, paramIFaceDecoder, paramReadInJoyBaseAdapter);
        paramProteusItemView.a(paramIReadInJoyModel);
        paramProteusItemView.a((View)paramContainer);
        paramProteusItemView.a(paramViewBase.getNativeView());
      }
      if ((paramAbsBaseArticleInfo != null) && (!(paramAbsBaseArticleInfo instanceof AdvertisementInfo))) {
        VideoReport.reportEvent("clck", RIJDtParamBuilder.a(new RIJDtParamBuilder().f("feedback_button").e(paramAbsBaseArticleInfo.innerUniqueID).b((Number)Integer.valueOf(paramAbsBaseArticleInfo.dtReportContentType)).c("click_feedback"), null, 1, null).b("list").g(paramAbsBaseArticleInfo.dtReportBackendInfo).a("14").a((Number)Long.valueOf(paramAbsBaseArticleInfo.mChannelID)).a());
      }
    }
  }
  
  public final void aa(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    if (paramIReadInJoyModel != null)
    {
      paramIFaceDecoder = (IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class);
      if (paramContainer != null) {
        paramProteusItemView = paramContainer.getVirtualView();
      } else {
        paramProteusItemView = null;
      }
      paramVafContext = jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusListenersUtils.a(paramVafContext);
      if (paramVafContext != null)
      {
        paramIFaceDecoder.processAdClickWithPos(paramProteusItemView, paramViewBase, (Activity)paramVafContext, (AbsBaseArticleInfo)paramAbsBaseArticleInfo, paramIReadInJoyModel.a(), jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusListenersUtils.a(paramIReadInJoyModel), 3);
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type android.app.Activity");
    }
  }
  
  public final void ab(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    if (paramIReadInJoyModel != null)
    {
      paramIFaceDecoder = (IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class);
      if (paramContainer != null) {
        paramProteusItemView = paramContainer.getVirtualView();
      } else {
        paramProteusItemView = null;
      }
      paramVafContext = jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusListenersUtils.a(paramVafContext);
      if (paramVafContext != null)
      {
        paramIFaceDecoder.processAdClickWithPos(paramProteusItemView, paramViewBase, (Activity)paramVafContext, (AbsBaseArticleInfo)paramAbsBaseArticleInfo, paramIReadInJoyModel.a(), jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusListenersUtils.a(paramIReadInJoyModel), 29);
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type android.app.Activity");
    }
  }
  
  public final void ac(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    if (paramIReadInJoyModel != null)
    {
      paramIFaceDecoder = (IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class);
      if (paramContainer != null) {
        paramProteusItemView = paramContainer.getVirtualView();
      } else {
        paramProteusItemView = null;
      }
      paramVafContext = jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusListenersUtils.a(paramVafContext);
      if (paramVafContext != null)
      {
        paramIFaceDecoder.processAdClickWithPos(paramProteusItemView, paramViewBase, (Activity)paramVafContext, (AbsBaseArticleInfo)paramAbsBaseArticleInfo, paramIReadInJoyModel.a(), jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusListenersUtils.a(paramIReadInJoyModel), 3);
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type android.app.Activity");
    }
  }
  
  public final void ad(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    if (paramIReadInJoyModel != null)
    {
      paramIFaceDecoder = (IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class);
      if (paramContainer != null) {
        paramProteusItemView = paramContainer.getVirtualView();
      } else {
        paramProteusItemView = null;
      }
      paramVafContext = jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusListenersUtils.a(paramVafContext);
      if (paramVafContext != null)
      {
        paramIFaceDecoder.processAdClickWithPos(paramProteusItemView, paramViewBase, (Activity)paramVafContext, (AbsBaseArticleInfo)paramAbsBaseArticleInfo, paramIReadInJoyModel.a(), jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusListenersUtils.a(paramIReadInJoyModel), 1000);
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type android.app.Activity");
    }
  }
  
  public final void ae(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    if (((paramAbsBaseArticleInfo instanceof BaseArticleInfo)) && (paramAbsBaseArticleInfo.mProteusTemplateBean != null))
    {
      paramReadInJoyBaseAdapter = null;
      paramIReadInJoyModel = ProteusSupportUtil.a(null, paramInt, paramAbsBaseArticleInfo);
      if (paramIReadInJoyModel != null)
      {
        if (paramViewBase != null) {
          paramIFaceDecoder = paramViewBase.getName();
        } else {
          paramIFaceDecoder = null;
        }
        ProteusSupportUtil.a(paramIReadInJoyModel.findViewById(paramIFaceDecoder));
      }
      if (paramProteusItemView != null) {
        EventCollector.getInstance().onViewClicked((View)paramProteusItemView);
      }
      ProteusSupportUtil.a(paramAbsBaseArticleInfo, paramIReadInJoyModel, paramViewBase);
      OnSocialAvatarClickListener.a(paramAbsBaseArticleInfo, paramInt);
      paramVafContext = a(paramVafContext);
      paramProteusItemView = paramReadInJoyBaseAdapter;
      if (paramViewBase != null) {
        paramProteusItemView = paramViewBase.getEventAttachedData();
      }
      RIJJumpUtils.a(paramVafContext, paramProteusItemView);
      if (paramAbsBaseArticleInfo.mChannelID == 0L) {
        RIJFeedsDynamicInsertController.INSTANCE.requestInsertArticlesAndRecordAction(paramAbsBaseArticleInfo.innerUniqueID, new RIJFeedsInsertAction(ActionType.ACTION_ENTER, 0, 0, 0), 1);
      }
      return;
    }
    QLog.d(jdField_a_of_type_JavaLangString, 1, "STR_ID_CMD_PARTNER_HEADER_CLICK,click exception, return");
  }
  
  public final void af(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    if (paramIReadInJoyModel != null)
    {
      RIJJumpUtils.b(paramIReadInJoyModel.a().a(), paramIReadInJoyModel.a());
      RIJJumpUtils.a((Context)paramIReadInJoyModel.a().a(), paramIReadInJoyModel.a(), (ReadInJoyBaseAdapter)paramIReadInJoyModel.a(), paramIReadInJoyModel.c());
      QLog.d(jdField_a_of_type_JavaLangString, 1, "clickCommentBiuCardWrapper exception, model is null!");
    }
  }
  
  public final void ag(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    if ((paramContainer != null) && (paramReadInJoyBaseAdapter != null))
    {
      if (paramIReadInJoyModel == null) {
        return;
      }
      paramIFaceDecoder = null;
      paramReadInJoyBaseAdapter = null;
      if (paramViewBase != null) {
        paramProteusItemView = paramViewBase.getClickEvnet();
      } else {
        paramProteusItemView = null;
      }
      StringCommon.getStrIdFromString(paramProteusItemView);
      paramIReadInJoyModel = ProteusSupportUtil.a(null, paramInt, paramAbsBaseArticleInfo);
      if (paramIReadInJoyModel != null)
      {
        if (paramViewBase != null) {
          paramProteusItemView = paramViewBase.getName();
        } else {
          paramProteusItemView = null;
        }
        paramProteusItemView = paramIReadInJoyModel.findViewById(paramProteusItemView);
        ProteusSupportUtil.a(paramIReadInJoyModel, paramViewBase);
        ProteusSupportUtil.a(paramProteusItemView);
      }
      if (Util.e(paramAbsBaseArticleInfo))
      {
        paramProteusItemView = paramReadInJoyBaseAdapter;
        if (paramViewBase != null) {
          paramProteusItemView = paramViewBase.getParent();
        }
        ReadInJoyUtils.a(paramAbsBaseArticleInfo, false, FastWebPTSUtils.a(paramProteusItemView, "id_video_view"));
        return;
      }
      paramVafContext = a(paramVafContext);
      paramProteusItemView = paramIFaceDecoder;
      if (paramViewBase != null) {
        paramProteusItemView = paramViewBase.getEventAttachedData();
      }
      RIJJumpUtils.a(paramVafContext, paramAbsBaseArticleInfo, paramProteusItemView);
    }
  }
  
  public final void ah(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    new OnWeChatVideoWatchLaterClickListener(paramAbsBaseArticleInfo).onClick(paramViewBase);
  }
  
  public final void b(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    if ((paramContainer != null) && (paramReadInJoyBaseAdapter != null) && (paramIReadInJoyModel != null))
    {
      paramProteusItemView = a(paramVafContext);
      Object localObject = null;
      paramVafContext = (AbsBaseArticleInfo)null;
      if ((paramProteusItemView != null) && (paramViewBase != null))
      {
        paramIFaceDecoder = new FeedItemCellTypeProteus(paramProteusItemView, paramIFaceDecoder, paramReadInJoyBaseAdapter);
        paramProteusItemView = paramIReadInJoyModel.a();
        if (paramProteusItemView != null) {
          paramProteusItemView = paramProteusItemView.mSubArticleList;
        } else {
          paramProteusItemView = null;
        }
        if ((paramProteusItemView != null) && (paramProteusItemView.size() > 0))
        {
          paramProteusItemView = (AbsBaseArticleInfo)paramProteusItemView.get(0);
          paramIFaceDecoder.a(new ReadInJoyModelImpl((Context)paramReadInJoyBaseAdapter.a(), paramProteusItemView, paramIReadInJoyModel.d(), paramReadInJoyBaseAdapter.a(), paramReadInJoyBaseAdapter.b(), paramIReadInJoyModel.g(), paramReadInJoyBaseAdapter.a(), paramReadInJoyBaseAdapter.getCount(), paramIReadInJoyModel.b(), (IReadInJoyBaseAdapter)paramReadInJoyBaseAdapter));
          paramIFaceDecoder.a((ReadInJoyModelImpl)paramIReadInJoyModel);
          paramIFaceDecoder.a((View)paramContainer);
          paramIFaceDecoder.a(paramViewBase.getNativeView());
        }
        else
        {
          QLog.i(jdField_a_of_type_JavaLangString, 1, "[STR_ID_CMD_RIGHT_DISLIKE_CLICK_FUN], cmd_right_dislike_click failed, there is no sub article.");
        }
      }
      else
      {
        paramProteusItemView = paramVafContext;
      }
      if ((paramAbsBaseArticleInfo != null) && (!(paramAbsBaseArticleInfo instanceof AdvertisementInfo)))
      {
        paramIFaceDecoder = new RIJDtParamBuilder().f("feedback_button");
        if (paramProteusItemView != null) {
          paramVafContext = paramProteusItemView.innerUniqueID;
        } else {
          paramVafContext = null;
        }
        paramIFaceDecoder = paramIFaceDecoder.e(paramVafContext);
        if (paramProteusItemView != null) {
          paramVafContext = Integer.valueOf(paramProteusItemView.dtReportContentType);
        } else {
          paramVafContext = Integer.valueOf(0);
        }
        paramIFaceDecoder = RIJDtParamBuilder.a(paramIFaceDecoder.b((Number)paramVafContext).c("click_feedback"), null, 1, null).b("list");
        paramVafContext = localObject;
        if (paramProteusItemView != null) {
          paramVafContext = paramProteusItemView.dtReportBackendInfo;
        }
        VideoReport.reportEvent("clck", paramIFaceDecoder.g(paramVafContext).a("14").a((Number)Long.valueOf(paramAbsBaseArticleInfo.mChannelID)).a());
      }
      return;
    }
  }
  
  public final void c(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo(paramAbsBaseArticleInfo))
    {
      paramProteusItemView = a(paramVafContext);
      if (paramIReadInJoyModel != null)
      {
        paramVafContext = (IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class);
        if (paramAbsBaseArticleInfo != null)
        {
          paramVafContext.jumpToGdtAdPage(paramProteusItemView, (AdvertisementInfo)paramAbsBaseArticleInfo, paramIReadInJoyModel.a(), paramIReadInJoyModel.c(), false);
          return;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo");
      }
    }
  }
  
  public final void d(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    new OnLikeClickListener(paramAbsBaseArticleInfo, a(paramVafContext)).onClick(paramViewBase);
  }
  
  public final void e(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    if (paramContainer == null) {
      return;
    }
    new OnUserCommentClickListener(paramAbsBaseArticleInfo, a(paramVafContext), paramReadInJoyBaseAdapter).onClick(paramViewBase);
  }
  
  public final void f(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    new OnUserCommentEditClickListener(paramAbsBaseArticleInfo, paramVafContext).onClick(paramViewBase);
  }
  
  public final void g(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    new OnCommentClickListener(paramAbsBaseArticleInfo, paramVafContext).onClick(paramViewBase);
  }
  
  public final void h(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    new OnBiuClickListener(paramAbsBaseArticleInfo, a(paramVafContext)).onClick(paramViewBase);
  }
  
  public final void i(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    new OnTopicRecommendHeaderClickListener(paramAbsBaseArticleInfo, a(paramVafContext)).onClick(paramViewBase);
  }
  
  public final void j(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    if (paramAbsBaseArticleInfo != null) {
      paramProteusItemView = paramAbsBaseArticleInfo.mNewPolymericInfo;
    } else {
      paramProteusItemView = null;
    }
    if ((paramProteusItemView != null) && (paramContainer != null))
    {
      paramProteusItemView = paramAbsBaseArticleInfo.mNewPolymericInfo;
      if (paramProteusItemView != null) {
        paramProteusItemView = paramProteusItemView.d;
      } else {
        paramProteusItemView = null;
      }
      RIJJumpUtils.a(paramContainer.getContext(), paramProteusItemView, null);
    }
  }
  
  public final void k(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    new OnTopicRecommendHeaderFollowClickListener(paramAbsBaseArticleInfo, a(paramVafContext)).onClick(paramViewBase);
  }
  
  public final void l(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    if ((paramAbsBaseArticleInfo != null) && ((RIJFeedsType.j(paramAbsBaseArticleInfo)) || (RIJFeedsType.k(paramAbsBaseArticleInfo)))) {
      NativeSummaryView.a(paramAbsBaseArticleInfo, jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusListenersUtils.a(paramVafContext));
    }
  }
  
  public final void m(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    if (paramReadInJoyBaseAdapter == null) {
      return;
    }
    new OnArticleWrapperClickListener(paramAbsBaseArticleInfo, paramReadInJoyBaseAdapter).onClick(paramViewBase);
  }
  
  public final void n(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    new OnJumpWrapperClickListener(a(paramVafContext), paramAbsBaseArticleInfo).onClick(paramViewBase);
  }
  
  public final void o(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    new OnSocialHeaderFollowClickListener(paramAbsBaseArticleInfo, a(paramVafContext), paramInt).onClick(paramViewBase);
  }
  
  public final void p(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    new OnTopicCapsuleClickListener(paramAbsBaseArticleInfo, a(paramVafContext)).onClick(paramViewBase);
  }
  
  public final void q(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    new OnSuperTopicClickListener(paramAbsBaseArticleInfo, a(paramVafContext)).onClick(paramViewBase);
  }
  
  public final void r(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    if (paramReadInJoyBaseAdapter == null) {
      return;
    }
    new OnReadArticleClickListener(paramAbsBaseArticleInfo, a(paramVafContext), paramReadInJoyBaseAdapter).onClick(paramViewBase);
  }
  
  public final void s(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    new OnAnswerCapsuleClickListener(paramAbsBaseArticleInfo, a(paramVafContext)).onClick(paramViewBase);
  }
  
  public final void t(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    new OnSocialHeaderClickListener(paramAbsBaseArticleInfo, a(paramVafContext)).onClick(paramViewBase);
  }
  
  public final void u(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    if (paramReadInJoyBaseAdapter == null) {
      return;
    }
    new OnSocialLikeCountClickListener(paramAbsBaseArticleInfo, a(paramVafContext), paramReadInJoyBaseAdapter).onClick(paramViewBase);
  }
  
  public final void v(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    if (paramReadInJoyBaseAdapter == null) {
      return;
    }
    new OnSocialBiuCountClickListener(paramAbsBaseArticleInfo, a(paramVafContext), paramReadInJoyBaseAdapter).onClick(paramViewBase);
  }
  
  public final void w(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    new OnSocialAvatarClickListener(paramAbsBaseArticleInfo, a(paramVafContext), paramInt).onClick(paramViewBase);
  }
  
  public final void x(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    new OnMoreBiuClickListener(paramAbsBaseArticleInfo, a(paramVafContext)).onClick(paramViewBase);
  }
  
  public final void y(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    new OnFriendsBiuClickListener(paramAbsBaseArticleInfo, a(paramVafContext), paramInt).onClick(paramViewBase);
  }
  
  public final void z(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    new OnAccountCardClickListener(paramAbsBaseArticleInfo).onClick(paramViewBase);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.util.ProteusListenersUtils
 * JD-Core Version:    0.7.0.1
 */