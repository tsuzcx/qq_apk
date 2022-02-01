package com.tencent.mobileqq.kandian.biz.fastweb;

import android.annotation.TargetApi;
import android.content.ClipboardManager;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.PersistableBundle;
import android.support.v4.util.MQLruCache;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.Window;
import android.view.animation.DecelerateInterpolator;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.VisibleForTesting;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportConstants.VideoEndType;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_bar.CommonAdBar;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_bar.uidelegate.IUIDelegate;
import com.tencent.biz.pubaccount.util.SneakyCallback;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.miniaio.MiniMsgIPCServer;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUser;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUser.IMiniMsgActionCallback;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUserParam;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.colornote.api.IColorNoteController;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdDownloadService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdExposeFreshService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdLogService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdReqFreshService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.ad.api.IRIJFastWebAdService;
import com.tencent.mobileqq.kandian.ad.api.IRIJFastWebVideoPlayerManager;
import com.tencent.mobileqq.kandian.base.utils.KandianUGStatisticUtils;
import com.tencent.mobileqq.kandian.base.utils.RIJJsonUtils;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.base.utils.TimeSliceHelper;
import com.tencent.mobileqq.kandian.base.utils.TimeUtil;
import com.tencent.mobileqq.kandian.biz.biu.RIJBiuAndCommentMixDataManager;
import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentListAdapter;
import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentListFragment;
import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentReportManager;
import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentUtils;
import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentUtils.CommentListListener;
import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentUtils.CommentReportR5Builder;
import com.tencent.mobileqq.kandian.biz.comment.ReadInJoySecondCommentListFragment;
import com.tencent.mobileqq.kandian.biz.comment.data.ReadInJoyCommentDataManager;
import com.tencent.mobileqq.kandian.biz.comment.entity.AnchorData;
import com.tencent.mobileqq.kandian.biz.comment.entity.SimpleCommentData;
import com.tencent.mobileqq.kandian.biz.common.RIJSocialBottomUtils;
import com.tencent.mobileqq.kandian.biz.common.RIJSocialBottomUtils.Companion;
import com.tencent.mobileqq.kandian.biz.common.RIJXTabFrameUtils;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.daily.api.IKandianDailyManager;
import com.tencent.mobileqq.kandian.biz.debug.ReadInJoyDropFrameHelper;
import com.tencent.mobileqq.kandian.biz.debug.ReadInJoyDropFrameHelper.OnFeedsFluencyResultListener;
import com.tencent.mobileqq.kandian.biz.detail.ReadInJoyArticleDetailActivity;
import com.tencent.mobileqq.kandian.biz.fastweb.adapter.FastWebMergeAdapter;
import com.tencent.mobileqq.kandian.biz.fastweb.adapter.FastWebMergeAdapter.OnDataSetChangeListener;
import com.tencent.mobileqq.kandian.biz.fastweb.adapter.WebFastAdapter;
import com.tencent.mobileqq.kandian.biz.fastweb.data.AdData;
import com.tencent.mobileqq.kandian.biz.fastweb.entity.BaseItemViewHolder;
import com.tencent.mobileqq.kandian.biz.fastweb.event.FastWebAdapterShowHelper;
import com.tencent.mobileqq.kandian.biz.fastweb.event.ItemHeightHelper;
import com.tencent.mobileqq.kandian.biz.fastweb.event.ItemShowDispatcher;
import com.tencent.mobileqq.kandian.biz.fastweb.event.ItemShowDispatcher.AdPostionReportManager;
import com.tencent.mobileqq.kandian.biz.fastweb.util.FastWebActivityStackUtil;
import com.tencent.mobileqq.kandian.biz.fastweb.util.FastWebActivityStackUtil.SaveState;
import com.tencent.mobileqq.kandian.biz.fastweb.util.FastWebDislikeUtils;
import com.tencent.mobileqq.kandian.biz.fastweb.util.FastWebPTSDataConverter;
import com.tencent.mobileqq.kandian.biz.fastweb.util.FastWebPTSUtils;
import com.tencent.mobileqq.kandian.biz.fastweb.util.FastWebProteusReportUtils;
import com.tencent.mobileqq.kandian.biz.fastweb.util.FastWebRecommendUGInfo;
import com.tencent.mobileqq.kandian.biz.fastweb.util.FastWebShareUtils;
import com.tencent.mobileqq.kandian.biz.fastweb.util.HtmlChangeUtil;
import com.tencent.mobileqq.kandian.biz.fastweb.util.ItemDatasListUtils;
import com.tencent.mobileqq.kandian.biz.fastweb.util.RIJ3ClickUtils;
import com.tencent.mobileqq.kandian.biz.fastweb.util.ReportUtil;
import com.tencent.mobileqq.kandian.biz.fastweb.util.ScreenShotShareHelper;
import com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.RIJFeedsDynamicInsertConfig;
import com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.RIJFeedsDynamicInsertController;
import com.tencent.mobileqq.kandian.biz.follow.popup.RIJFollowRecommendPopupCommand;
import com.tencent.mobileqq.kandian.biz.framework.RIJWebSearchUtils;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyActivityHelper;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.hippy.interfaces.dispatcher.TKDHippyEventDispatcher;
import com.tencent.mobileqq.kandian.biz.hippy.tuwen.adapter.TKDTuWenHippyCommentAdapter;
import com.tencent.mobileqq.kandian.biz.hippy.tuwen.adapter.TKDTuWenHippyCommentAdapter.Builder;
import com.tencent.mobileqq.kandian.biz.hippy.tuwen.util.TKDTuWenCommentUtil;
import com.tencent.mobileqq.kandian.biz.hippy.tuwen.view.ReadInJoyCommentListView;
import com.tencent.mobileqq.kandian.biz.pts.ReadInjoyContext;
import com.tencent.mobileqq.kandian.biz.pts.view.impl.NativeAvatarView;
import com.tencent.mobileqq.kandian.biz.push.RIJKanDianFolderStatus;
import com.tencent.mobileqq.kandian.biz.reward.RIJRewardTaskArticleTimer;
import com.tencent.mobileqq.kandian.biz.reward.RIJRewardTaskConfig;
import com.tencent.mobileqq.kandian.biz.reward.RIJVideoRewardCoinManager;
import com.tencent.mobileqq.kandian.biz.reward.RIJVideoRewardCoinManager.Companion;
import com.tencent.mobileqq.kandian.biz.reward.RIJVideoRewardCoinManager.RIJRewardData;
import com.tencent.mobileqq.kandian.biz.share.ReadInJoyShareHelperV2;
import com.tencent.mobileqq.kandian.biz.share.ReadInJoyShareHelperV2.OnFontSizeChangeListener;
import com.tencent.mobileqq.kandian.biz.video.VideoAutoPlayController;
import com.tencent.mobileqq.kandian.glue.businesshandler.api.IKandianSubscribeManager;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicManager;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyUserInfoModule.RefreshUserInfoCallBack;
import com.tencent.mobileqq.kandian.glue.pts.RIJProteusDtFactory;
import com.tencent.mobileqq.kandian.glue.pts.StyleConfigHelper;
import com.tencent.mobileqq.kandian.glue.pts.util.ProteusSupportUtil;
import com.tencent.mobileqq.kandian.glue.report.RIJFrameworkReportManager;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import com.tencent.mobileqq.kandian.glue.report.dt.RIJDtParamBuilder;
import com.tencent.mobileqq.kandian.glue.report.dt.RIJProteusDtImpl;
import com.tencent.mobileqq.kandian.glue.viola.CommonSuspensionGestureLayout;
import com.tencent.mobileqq.kandian.repo.aladdin.RIJSocialBottomViewAladdinConfig;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.DailyModeConfigHandler;
import com.tencent.mobileqq.kandian.repo.common.RIJItemViewTypeUtils;
import com.tencent.mobileqq.kandian.repo.common.RIJLiveStatusModule;
import com.tencent.mobileqq.kandian.repo.common.RIJLiveStatusModule.LiveStatusCallback;
import com.tencent.mobileqq.kandian.repo.common.RIJShowKanDianTabSp;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoyUserInfoModule;
import com.tencent.mobileqq.kandian.repo.fastweb.FastWebArticleInfoUtils;
import com.tencent.mobileqq.kandian.repo.fastweb.FastWebModule;
import com.tencent.mobileqq.kandian.repo.fastweb.FastWebModule.FastWebContentGetCallback;
import com.tencent.mobileqq.kandian.repo.fastweb.constants.FastWebConstants;
import com.tencent.mobileqq.kandian.repo.fastweb.entity.AuthorData;
import com.tencent.mobileqq.kandian.repo.fastweb.entity.ProteusRecommendItemData;
import com.tencent.mobileqq.kandian.repo.fastweb.entity.TitleData;
import com.tencent.mobileqq.kandian.repo.feeds.ActionType;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsInsertAction;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.BaseData;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FastWebArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FeedsInfoUser;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopicRecommendFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopicRecommendFeedsInfo.TopicRecommendInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IBaseDataUtil;
import com.tencent.mobileqq.kandian.repo.follow.FollowListInfoModule;
import com.tencent.mobileqq.kandian.repo.follow.IFollowStatusObserver;
import com.tencent.mobileqq.kandian.repo.pts.entity.ProteusItemData;
import com.tencent.mobileqq.kandian.repo.report.FeedsReportData;
import com.tencent.mobileqq.kandian.repo.report.ReportInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.swipe.SwipeLayoutUtils;
import com.tencent.mobileqq.teamwork.TeamWorkConvertUtils;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.pts.utils.PTSDeviceUtil;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.page.IScrollReader;
import com.tencent.util.URLUtil;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.AbsListView.SavedState;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.EdgeEffect;
import com.tencent.widget.XListView.DrawFinishedListener;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class FastWebActivity
  extends BaseActivity
  implements View.OnClickListener, MiniMsgUser.IMiniMsgActionCallback, DecodeTaskCompletionListener, ReadInJoyCommentUtils.CommentListListener, ReadInJoyDropFrameHelper.OnFeedsFluencyResultListener, ReadInJoyShareHelperV2.OnFontSizeChangeListener, FastWebConstants
{
  public static boolean a = false;
  public static boolean b = false;
  public static boolean c = false;
  private boolean A;
  private boolean B;
  private boolean C;
  private boolean D;
  private boolean E;
  private float jdField_a_of_type_Float = DeviceInfoUtil.e() * 500 / 160.0F;
  private int jdField_a_of_type_Int = 1;
  protected long a;
  private MessageQueue.IdleHandler jdField_a_of_type_AndroidOsMessageQueue$IdleHandler;
  SparseArray<Float> jdField_a_of_type_AndroidUtilSparseArray;
  public View a;
  private DecelerateInterpolator jdField_a_of_type_AndroidViewAnimationDecelerateInterpolator = new DecelerateInterpolator(this.jdField_c_of_type_Float);
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private VafContext jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext;
  private CommonAdBar jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barCommonAdBar;
  private Share jdField_a_of_type_ComTencentBizWebviewpluginShare;
  public MiniMsgUser a;
  private IFaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
  private IColorNoteController jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController;
  private TimeSliceHelper jdField_a_of_type_ComTencentMobileqqKandianBaseUtilsTimeSliceHelper;
  private RIJBiuAndCommentMixDataManager jdField_a_of_type_ComTencentMobileqqKandianBizBiuRIJBiuAndCommentMixDataManager;
  private ReadInJoyCommentListAdapter jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListAdapter;
  private ReadInJoySecondCommentListFragment jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoySecondCommentListFragment;
  private AnchorData jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityAnchorData;
  private FastWebActivity.ArticleRichInfoCallback jdField_a_of_type_ComTencentMobileqqKandianBizFastwebFastWebActivity$ArticleRichInfoCallback;
  private FastWebActivity.RecommendAndAdCallback jdField_a_of_type_ComTencentMobileqqKandianBizFastwebFastWebActivity$RecommendAndAdCallback;
  private ReadInJoyFastWebBottomSocialViewNew jdField_a_of_type_ComTencentMobileqqKandianBizFastwebReadInJoyFastWebBottomSocialViewNew;
  FastWebMergeAdapter.OnDataSetChangeListener jdField_a_of_type_ComTencentMobileqqKandianBizFastwebAdapterFastWebMergeAdapter$OnDataSetChangeListener;
  private FastWebMergeAdapter jdField_a_of_type_ComTencentMobileqqKandianBizFastwebAdapterFastWebMergeAdapter;
  private WebFastAdapter jdField_a_of_type_ComTencentMobileqqKandianBizFastwebAdapterWebFastAdapter;
  private FastWebAdapterShowHelper jdField_a_of_type_ComTencentMobileqqKandianBizFastwebEventFastWebAdapterShowHelper;
  private ItemHeightHelper jdField_a_of_type_ComTencentMobileqqKandianBizFastwebEventItemHeightHelper;
  private ItemShowDispatcher jdField_a_of_type_ComTencentMobileqqKandianBizFastwebEventItemShowDispatcher = new ItemShowDispatcher();
  private FastWebActivityStackUtil.SaveState jdField_a_of_type_ComTencentMobileqqKandianBizFastwebUtilFastWebActivityStackUtil$SaveState;
  private FastWebActivityStackUtil jdField_a_of_type_ComTencentMobileqqKandianBizFastwebUtilFastWebActivityStackUtil = new FastWebActivityStackUtil(this);
  private FastWebShareUtils jdField_a_of_type_ComTencentMobileqqKandianBizFastwebUtilFastWebShareUtils = new FastWebShareUtils();
  private ScreenShotShareHelper jdField_a_of_type_ComTencentMobileqqKandianBizFastwebUtilScreenShotShareHelper;
  private TKDTuWenHippyCommentAdapter jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenAdapterTKDTuWenHippyCommentAdapter;
  private ReadInJoyCommentListView jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView;
  private NativeAvatarView jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewImplNativeAvatarView;
  private RIJRewardTaskArticleTimer jdField_a_of_type_ComTencentMobileqqKandianBizRewardRIJRewardTaskArticleTimer;
  private ReadInJoyShareHelperV2 jdField_a_of_type_ComTencentMobileqqKandianBizShareReadInJoyShareHelperV2;
  private IReadInJoyUserInfoModule.RefreshUserInfoCallBack jdField_a_of_type_ComTencentMobileqqKandianGlueMsfApiIReadInJoyUserInfoModule$RefreshUserInfoCallBack;
  private CommonSuspensionGestureLayout jdField_a_of_type_ComTencentMobileqqKandianGlueViolaCommonSuspensionGestureLayout;
  private RIJLiveStatusModule.LiveStatusCallback jdField_a_of_type_ComTencentMobileqqKandianRepoCommonRIJLiveStatusModule$LiveStatusCallback;
  private RIJLiveStatusModule jdField_a_of_type_ComTencentMobileqqKandianRepoCommonRIJLiveStatusModule;
  private FastWebModule.FastWebContentGetCallback jdField_a_of_type_ComTencentMobileqqKandianRepoFastwebFastWebModule$FastWebContentGetCallback;
  private AuthorData jdField_a_of_type_ComTencentMobileqqKandianRepoFastwebEntityAuthorData;
  private TitleData jdField_a_of_type_ComTencentMobileqqKandianRepoFastwebEntityTitleData;
  private ReadInJoyObserver jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver;
  public AbsBaseArticleInfo a;
  private FastWebArticleInfo jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo;
  IFollowStatusObserver jdField_a_of_type_ComTencentMobileqqKandianRepoFollowIFollowStatusObserver;
  public INetInfoHandler a;
  private IScrollReader jdField_a_of_type_ComTencentQqliveModuleVideoreportPageIScrollReader;
  AbsListView.OnScrollListener jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener;
  private BubblePopupWindow jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
  private XListView.DrawFinishedListener jdField_a_of_type_ComTencentWidgetXListView$DrawFinishedListener;
  Runnable jdField_a_of_type_JavaLangRunnable;
  protected String a;
  private HashMap<String, ArrayList<String>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List<BaseData> jdField_a_of_type_JavaUtilList;
  Set<BaseData> jdField_a_of_type_JavaUtilSet;
  private float jdField_b_of_type_Float = DeviceInfoUtil.e() * 1000 / 160.0F;
  private int jdField_b_of_type_Int = 0;
  protected long b;
  private MessageQueue.IdleHandler jdField_b_of_type_AndroidOsMessageQueue$IdleHandler;
  private SparseArray<View> jdField_b_of_type_AndroidUtilSparseArray = new SparseArray(1);
  public View b;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private ReadInJoyObserver jdField_b_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver;
  private String jdField_b_of_type_JavaLangString;
  private float jdField_c_of_type_Float = 1.5F;
  private int jdField_c_of_type_Int = -1;
  long jdField_c_of_type_Long;
  private View jdField_c_of_type_AndroidViewView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private String jdField_c_of_type_JavaLangString;
  private int jdField_d_of_type_Int;
  private long jdField_d_of_type_Long;
  private View jdField_d_of_type_AndroidViewView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private String jdField_d_of_type_JavaLangString;
  boolean jdField_d_of_type_Boolean = true;
  private int jdField_e_of_type_Int;
  private long jdField_e_of_type_Long;
  private View jdField_e_of_type_AndroidViewView;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  public boolean e;
  private int jdField_f_of_type_Int = 0;
  private long jdField_f_of_type_Long;
  public boolean f;
  private int jdField_g_of_type_Int = 0;
  private long jdField_g_of_type_Long;
  private boolean jdField_g_of_type_Boolean = true;
  private int jdField_h_of_type_Int = 0;
  private boolean jdField_h_of_type_Boolean = false;
  private int jdField_i_of_type_Int = 0;
  private boolean jdField_i_of_type_Boolean = false;
  private int jdField_j_of_type_Int;
  private boolean jdField_j_of_type_Boolean = false;
  private int jdField_k_of_type_Int;
  private boolean jdField_k_of_type_Boolean = false;
  private int jdField_l_of_type_Int;
  private boolean jdField_l_of_type_Boolean = false;
  private int jdField_m_of_type_Int;
  private boolean jdField_m_of_type_Boolean = false;
  private int jdField_n_of_type_Int;
  private boolean jdField_n_of_type_Boolean = false;
  private int jdField_o_of_type_Int;
  private boolean jdField_o_of_type_Boolean = false;
  private int jdField_p_of_type_Int;
  private boolean jdField_p_of_type_Boolean = false;
  private int jdField_q_of_type_Int;
  private boolean jdField_q_of_type_Boolean = false;
  private int jdField_r_of_type_Int;
  private boolean jdField_r_of_type_Boolean = false;
  private int jdField_s_of_type_Int;
  private boolean jdField_s_of_type_Boolean = false;
  private int jdField_t_of_type_Int;
  private boolean jdField_t_of_type_Boolean = false;
  private int jdField_u_of_type_Int;
  private boolean jdField_u_of_type_Boolean;
  private int jdField_v_of_type_Int;
  private boolean jdField_v_of_type_Boolean;
  private int jdField_w_of_type_Int;
  private boolean jdField_w_of_type_Boolean;
  private int jdField_x_of_type_Int;
  private boolean jdField_x_of_type_Boolean;
  private int jdField_y_of_type_Int;
  private boolean jdField_y_of_type_Boolean;
  private int jdField_z_of_type_Int;
  private boolean jdField_z_of_type_Boolean;
  
  public FastWebActivity()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(System.currentTimeMillis());
    localStringBuilder.append("");
    this.jdField_b_of_type_JavaLangString = localStringBuilder.toString();
    this.jdField_u_of_type_Boolean = false;
    this.jdField_e_of_type_Long = 0L;
    this.jdField_l_of_type_Int = 1000;
    this.jdField_m_of_type_Int = 2;
    this.jdField_n_of_type_Int = 0;
    this.jdField_o_of_type_Int = 0;
    this.jdField_p_of_type_Int = 0;
    this.jdField_q_of_type_Int = 0;
    this.jdField_r_of_type_Int = 0;
    this.jdField_s_of_type_Int = 0;
    this.jdField_t_of_type_Int = 0;
    this.jdField_v_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseUtilsTimeSliceHelper = new TimeSliceHelper();
    this.jdField_u_of_type_Int = 1;
    this.jdField_w_of_type_Boolean = false;
    this.jdField_x_of_type_Boolean = false;
    this.jdField_y_of_type_Boolean = false;
    this.jdField_g_of_type_Long = 0L;
    this.jdField_z_of_type_Boolean = true;
    this.A = false;
    this.B = false;
    this.C = true;
    this.D = true;
    this.jdField_w_of_type_Int = 0;
    this.jdField_x_of_type_Int = -1;
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.E = false;
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_y_of_type_Int = 0;
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_z_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizRewardRIJRewardTaskArticleTimer = new RIJRewardTaskArticleTimer();
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoCommonRIJLiveStatusModule$LiveStatusCallback = new FastWebActivity.9(this);
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueMsfApiIReadInJoyUserInfoModule$RefreshUserInfoCallBack = new FastWebActivity.10(this);
    this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = new FastWebActivity.23(this);
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver = new FastWebActivity.24(this);
    this.jdField_b_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver = new FastWebActivity.25(this);
    this.jdField_a_of_type_ComTencentWidgetXListView$DrawFinishedListener = new FastWebActivity.29(this);
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFastwebFastWebModule$FastWebContentGetCallback = new FastWebActivity.33(this);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebFastWebActivity$ArticleRichInfoCallback = new FastWebActivity.ArticleRichInfoCallback(this, null);
    this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new FastWebActivity.35(this);
    this.jdField_b_of_type_AndroidOsMessageQueue$IdleHandler = new FastWebActivity.36(this);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebAdapterFastWebMergeAdapter$OnDataSetChangeListener = new FastWebActivity.38(this);
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFollowIFollowStatusObserver = new FastWebActivity.40(this);
    this.jdField_a_of_type_JavaLangRunnable = new FastWebActivity.41(this);
  }
  
  private void A()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoCommonRIJLiveStatusModule == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianRepoCommonRIJLiveStatusModule = ReadInJoyLogicEngine.a().a();
      RIJLiveStatusModule localRIJLiveStatusModule = this.jdField_a_of_type_ComTencentMobileqqKandianRepoCommonRIJLiveStatusModule;
      if (localRIJLiveStatusModule != null) {
        localRIJLiveStatusModule.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoCommonRIJLiveStatusModule$LiveStatusCallback);
      }
    }
  }
  
  private void B()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo;
      if (localObject != null)
      {
        if (!TextUtils.isEmpty(((FastWebArticleInfo)localObject).o)) {
          this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mArticleID = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo.o);
        }
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo.jdField_c_of_type_JavaLangString)) {
          this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mTitle = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo.jdField_c_of_type_JavaLangString;
        }
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo.r)) {
          this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mFirstPagePicUrl = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo.r;
        }
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo.jdField_e_of_type_JavaLangString)) {
          this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSubscribeName = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo.jdField_e_of_type_JavaLangString;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo.jdField_e_of_type_Long != 0L) && (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSubscribeID)))
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("");
          localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo.jdField_e_of_type_Long);
          ((AbsBaseArticleInfo)localObject).mSubscribeID = localStringBuilder.toString();
        }
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo.s))
        {
          this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo.t = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mArticleContentUrl;
          this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mArticleContentUrl = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo.s;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("initArticleInfo, update url,url=");
          ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mArticleContentUrl);
          QLog.d("FastWebActivity", 1, ((StringBuilder)localObject).toString());
        }
        return;
      }
    }
    QLog.d("FastWebActivity", 1, "initArticleInfo error!");
  }
  
  private void C()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebAdapterFastWebMergeAdapter == null) {
      return;
    }
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebAdapterFastWebMergeAdapter.notifyDataSetChanged();
      return;
    }
    runOnUiThread(new FastWebActivity.11(this));
  }
  
  private void D()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityAnchorData = ((AnchorData)getIntent().getExtras().get("intent_key_anchor_data"));
    if (!a(1)) {
      a(1);
    }
  }
  
  private void E()
  {
    TKDTuWenHippyCommentAdapter localTKDTuWenHippyCommentAdapter = this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenAdapterTKDTuWenHippyCommentAdapter;
    if (localTKDTuWenHippyCommentAdapter != null) {
      localTKDTuWenHippyCommentAdapter.destroy();
    }
  }
  
  private void F()
  {
    Object localObject = new Bundle();
    boolean bool;
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenAdapterTKDTuWenHippyCommentAdapter != null) {
      bool = true;
    } else {
      bool = false;
    }
    ((Bundle)localObject).putBoolean("arg_main_comment_use_hippy", bool);
    ((Bundle)localObject).putBoolean("arg_comment_list_biu_btn", false);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoySecondCommentListFragment = new ReadInJoySecondCommentListFragment();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoySecondCommentListFragment.a(1);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoySecondCommentListFragment.a(this, (Bundle)localObject, new FastWebActivity.13(this));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoySecondCommentListFragment.a(new FastWebActivity.14(this));
    localObject = getSupportFragmentManager().beginTransaction();
    ((FragmentTransaction)localObject).add(2131377094, this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoySecondCommentListFragment);
    ((FragmentTransaction)localObject).hide(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoySecondCommentListFragment);
    ((FragmentTransaction)localObject).commitAllowingStateLoss();
  }
  
  private void G()
  {
    FastWebModule localFastWebModule = ReadInJoyLogicEngine.a().a();
    if (localFastWebModule == null)
    {
      if (!this.jdField_n_of_type_Boolean) {
        H();
      }
      QLog.d("FastWebActivity", 2, "fastWebModule == null");
      return;
    }
    localFastWebModule.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mArticleContentUrl, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.innerUniqueID), this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSubscribeID, 1, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFastwebFastWebModule$FastWebContentGetCallback);
  }
  
  private void H()
  {
    B();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("openWeb  mArticleInfo: ");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo);
    QLog.d("FastWebActivity", 1, localStringBuilder.toString());
    this.jdField_o_of_type_Boolean = true;
    ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_b_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
    ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
    getMainLooper();
    Looper.myQueue().addIdleHandler(new FastWebActivity.15(this));
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X8009C50", "0X8009C50", 0, 0, "", Long.toString(this.jdField_a_of_type_Long), Integer.toString(this.jdField_k_of_type_Int), "", false);
  }
  
  private void I()
  {
    if (this.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler != null)
    {
      getMainLooper();
      Looper.myQueue().removeIdleHandler(this.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler);
    }
    this.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler = new FastWebActivity.16(this);
    getMainLooper();
    Looper.myQueue().addIdleHandler(this.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler);
  }
  
  private void J()
  {
    View localView = findViewById(2131373730);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView.setEmptyView(localView);
    localView.setOnClickListener(null);
  }
  
  private void K()
  {
    ((ClipboardManager)getSystemService("clipboard")).setText(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mArticleContentUrl);
    QRUtils.a(2, 2131691296);
    String str;
    if (this.jdField_s_of_type_Boolean) {
      str = "0X8008994";
    } else {
      str = "0X800898D";
    }
    FastWebShareUtils.a(this, str, 9, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo);
    ReportUtil.a(this, getAppInterface(), this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, -1, 3, false);
  }
  
  private void L()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizShareReadInJoyShareHelperV2.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mArticleContentUrl);
    ReportUtil.a(this, getAppInterface(), this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, 6, -1, false);
  }
  
  private void M()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizShareReadInJoyShareHelperV2.b(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mArticleContentUrl);
    ReportUtil.a(this, getAppInterface(), this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, 7, -1, false);
  }
  
  private void N()
  {
    a(17, -1, false);
    ReportUtil.a(this, getAppInterface(), this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, 0, -1, false);
  }
  
  private void O()
  {
    ThreadManager.executeOnSubThread(new FastWebActivity.18(this));
    String str;
    if (this.jdField_s_of_type_Boolean) {
      str = "0X8008994";
    } else {
      str = "0X800898D";
    }
    FastWebShareUtils.a(this, str, 10, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo);
    ReportUtil.a(this, getAppInterface(), this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, -1, 5, false);
  }
  
  private void P()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizShareReadInJoyShareHelperV2.c();
    String str;
    if (this.jdField_s_of_type_Boolean) {
      str = "0X8008994";
    } else {
      str = "0X800898D";
    }
    FastWebShareUtils.a(this, str, 7, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo);
    ReportUtil.a(this, getAppInterface(), this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, -1, 0, false);
  }
  
  private void Q()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizShareReadInJoyShareHelperV2.a(this, true);
    ReportUtil.a(this, getAppInterface(), this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, -1, 1, false, false, RIJJsonUtils.a(null, "function_type", Integer.valueOf(7)));
  }
  
  private void R()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizShareReadInJoyShareHelperV2.d(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mArticleContentUrl);
    ReportUtil.a(this, getAppInterface(), this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, -1, 2, false);
  }
  
  private void S()
  {
    TeamWorkConvertUtils.a(1, 2);
    TeamWorkConvertUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mArticleContentUrl, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mTitle);
  }
  
  private void T()
  {
    IColorNoteController localIColorNoteController = this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController;
    if (localIColorNoteController != null) {
      if (localIColorNoteController.canAddColorNote())
      {
        QLog.d("FastWebActivity", 2, "mColorNoteController ：add colorNote");
        this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.insertColorNote();
        if (!this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebUtilFastWebActivityStackUtil.a()) {
          QQToast.a(BaseApplicationImpl.getContext(), 2, BaseApplicationImpl.getContext().getResources().getString(2131690892), 5000).a();
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.onCannotAdd();
      }
    }
  }
  
  private void U()
  {
    IColorNoteController localIColorNoteController = this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController;
    if ((localIColorNoteController != null) && (localIColorNoteController.isColorNoteExist()))
    {
      QQToast.a(BaseApplicationImpl.getContext(), 2, BaseApplicationImpl.getContext().getResources().getString(2131690896), 5000).a();
      this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.deleteColorNote();
      QLog.d("FastWebActivity", 2, "mColorNoteController ： delete colorNote");
    }
  }
  
  private void V()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewImplNativeAvatarView = ((NativeAvatarView)findViewById(2131363071));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363072));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131367060));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewImplNativeAvatarView.setOnClickListener(this);
    this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
  }
  
  private void W()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFastwebEntityAuthorData != null) {
      a(this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView.getFirstVisiblePosition(), this.jdField_a_of_type_ComTencentMobileqqKandianRepoFastwebEntityAuthorData);
    }
  }
  
  private void X()
  {
    Y();
    getMainLooper();
    Looper.myQueue().addIdleHandler(this.jdField_b_of_type_AndroidOsMessageQueue$IdleHandler);
  }
  
  private void Y()
  {
    getMainLooper();
    Looper.myQueue().removeIdleHandler(this.jdField_b_of_type_AndroidOsMessageQueue$IdleHandler);
  }
  
  private void Z()
  {
    if (b()) {
      return;
    }
    int i3 = this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView.getLastVisiblePosition();
    e(i3);
    int i2 = this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView.getFirstVisiblePosition();
    boolean bool1 = false;
    int i1 = 0;
    while (i2 <= i3)
    {
      i1 = a(i2);
      boolean bool2 = bool1;
      if (i2 < this.jdField_a_of_type_JavaUtilList.size())
      {
        bool2 = bool1;
        if (((BaseData)this.jdField_a_of_type_JavaUtilList.get(i2)).jdField_f_of_type_Boolean)
        {
          this.jdField_q_of_type_Boolean = true;
          if (this.jdField_b_of_type_Int == 0) {
            this.jdField_b_of_type_Int = a(this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView, this.jdField_w_of_type_Int);
          }
          bool2 = true;
        }
      }
      i2 += 1;
      bool1 = bool2;
    }
    e(bool1);
    int[] arrayOfInt = ReportUtil.jdField_a_of_type_ArrayOfInt;
    int i4 = arrayOfInt.length;
    i2 = 0;
    while (i2 < i4)
    {
      Integer localInteger = Integer.valueOf(arrayOfInt[i2]);
      if ((1 << localInteger.intValue() & i1) != 0) {
        i3 = 1;
      } else {
        i3 = 0;
      }
      if (i3 != 0) {
        TimeSliceHelper.b(ReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, localInteger.intValue()));
      } else {
        TimeSliceHelper.c(ReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, localInteger.intValue()));
      }
      i2 += 1;
    }
  }
  
  private float a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebEventItemHeightHelper == null)
    {
      QLog.e("Q.readinjoy.fast_web", 2, "getRatio itemsHeight == null ");
      return 0.0F;
    }
    if (this.jdField_g_of_type_Int <= 0) {
      Z();
    }
    int i1 = a();
    int i2 = b();
    if ((i1 < i2) && (i2 > 0)) {
      return i1 / i2;
    }
    return 1.0F;
  }
  
  private int a()
  {
    return a(this.jdField_g_of_type_Int, this.jdField_h_of_type_Int);
  }
  
  private int a(int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size())
    {
      float f1 = ((IBaseDataUtil)QRoute.api(IBaseDataUtil.class)).getSortWeight((BaseData)this.jdField_a_of_type_JavaUtilList.get(paramInt));
      float[] arrayOfFloat = ReportUtil.jdField_a_of_type_ArrayOfFloat;
      paramInt = 0;
      if (f1 <= arrayOfFloat[0]) {
        return 1;
      }
      if (f1 <= ReportUtil.jdField_a_of_type_ArrayOfFloat[1]) {
        return 2;
      }
      if (f1 <= ReportUtil.jdField_a_of_type_ArrayOfFloat[2]) {
        return 4;
      }
    }
    else
    {
      paramInt = 8;
    }
    return paramInt;
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    ItemHeightHelper localItemHeightHelper = this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebEventItemHeightHelper;
    int i1 = 0;
    if (localItemHeightHelper == null)
    {
      QLog.e("Q.readinjoy.fast_web", 2, "getRatio itemsHeight == null ");
      return 0;
    }
    int i2 = 0;
    while ((i1 < this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebEventItemHeightHelper.a()) && (i1 <= paramInt1))
    {
      i2 += this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebEventItemHeightHelper.a(i1);
      i1 += 1;
    }
    return i2 - paramInt2;
  }
  
  private int a(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0) {
      this.jdField_j_of_type_Int = a(paramAbsListView.getLastVisiblePosition(), this.jdField_i_of_type_Int);
    } else if (this.jdField_j_of_type_Int == 0) {
      this.jdField_j_of_type_Int = a(paramAbsListView.getLastVisiblePosition(), this.jdField_i_of_type_Int);
    }
    return this.jdField_j_of_type_Int;
  }
  
  private Bundle a(Bundle paramBundle)
  {
    Bundle localBundle1 = getIntent().getExtras();
    Bundle localBundle2 = localBundle1;
    if (localBundle1 == null)
    {
      if (paramBundle != null) {
        localBundle1 = paramBundle.getBundle("bundle_key_save_instancestate");
      }
      localBundle2 = localBundle1;
      if (localBundle1 != null)
      {
        StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(null, "actKandianFastWebdoOnCreateSucc", true, 0L, 0L, null, null);
        localBundle2 = localBundle1;
      }
    }
    return localBundle2;
  }
  
  private VafContext a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext == null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext = new ReadInjoyContext();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.setContext(this);
      ProteusSupportUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, "native_article");
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext;
  }
  
  private void a(int paramInt)
  {
    ah();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListAdapter = new ReadInJoyCommentListAdapter(this, this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView, paramInt);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityAnchorData;
    String str;
    if (localObject != null)
    {
      str = ((AnchorData)localObject).jdField_a_of_type_JavaLangString;
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityAnchorData.jdField_b_of_type_JavaLangString;
    }
    else
    {
      str = null;
      localObject = str;
    }
    if (!TextUtils.isEmpty(str))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" mainComment : ");
      localStringBuilder.append(str);
      localStringBuilder.append("  subComment : ");
      localStringBuilder.append((String)localObject);
      QLog.d("Q.readinjoy.fast_web", 1, localStringBuilder.toString());
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListAdapter.a(new FastWebActivity.12(this, str, (String)localObject));
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListAdapter.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityAnchorData, 1);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListAdapter.a(new FastWebActivity.CommentNumChangedlistener(this, null));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebAdapterFastWebMergeAdapter.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListAdapter);
    F();
  }
  
  private void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenAdapterTKDTuWenHippyCommentAdapter == null)
    {
      d(paramIntent);
      return;
    }
    Object localObject = (SimpleCommentData)paramIntent.getParcelableExtra("comment_create_data");
    int i3 = 0;
    int i1;
    if (localObject != null) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    int i2 = i1;
    if (i1 == 0)
    {
      i2 = paramIntent.getIntExtra("click_comment_edit_src", -1);
      i1 = i3;
      if (i2 == 2) {
        i1 = 1;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleCommentEditorResponse commentEditClickSrc=");
      ((StringBuilder)localObject).append(i2);
      QLog.d("FastWebActivity", 1, ((StringBuilder)localObject).toString());
      i2 = i1;
    }
    if (i2 != 0)
    {
      b(paramInt1, paramInt2, paramIntent);
      return;
    }
    d(paramIntent);
  }
  
  private void a(int paramInt, Intent paramIntent)
  {
    if ((paramInt == -1) && (paramIntent != null))
    {
      paramIntent = paramIntent.getParcelableExtra("key_ad_info");
      if (((paramIntent instanceof AdData)) && (this.jdField_a_of_type_JavaUtilList != null))
      {
        paramIntent = ((AdData)paramIntent).u;
        if (!TextUtils.isEmpty(paramIntent))
        {
          Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
          while (localIterator.hasNext())
          {
            BaseData localBaseData = (BaseData)localIterator.next();
            if (((localBaseData instanceof AdData)) && (paramIntent.equals(((AdData)localBaseData).u)))
            {
              a(localBaseData);
              QQToast.a(this, -1, getString(2131699886), 0).b(getTitleBarHeight());
            }
          }
        }
      }
    }
  }
  
  private void a(int paramInt, AuthorData paramAuthorData)
  {
    if (FastWebPTSUtils.a(paramInt, this.jdField_a_of_type_JavaUtilList)) {
      paramInt = 0;
    } else {
      paramInt = 4;
    }
    this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(paramInt);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewImplNativeAvatarView.setVisibility(paramInt);
    b(paramInt, paramAuthorData);
  }
  
  private void a(long paramLong)
  {
    try
    {
      QLog.d("FastWebActivity", 1, "start to fetch live status");
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(Long.valueOf(paramLong));
      if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoCommonRIJLiveStatusModule == null) {
        A();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoCommonRIJLiveStatusModule != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianRepoCommonRIJLiveStatusModule.a(localArrayList);
        return;
      }
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("fetchLiveStatus error:");
      localStringBuilder.append(localException);
      QLog.e("FastWebActivity", 1, localStringBuilder.toString());
    }
  }
  
  private void a(Bundle paramBundle)
  {
    Object localObject = getSupportFragmentManager();
    if ((paramBundle != null) && (localObject != null))
    {
      paramBundle = ((FragmentManager)localObject).getFragments();
      if ((paramBundle != null) && (paramBundle.size() > 0))
      {
        localObject = ((FragmentManager)localObject).beginTransaction();
        paramBundle = paramBundle.iterator();
        while (paramBundle.hasNext()) {
          ((FragmentTransaction)localObject).remove((Fragment)paramBundle.next());
        }
        ((FragmentTransaction)localObject).commit();
      }
    }
  }
  
  private void a(FastWebActivityStackUtil.SaveState paramSaveState)
  {
    aq();
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = paramSaveState.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebUtilFastWebActivityStackUtil$SaveState = paramSaveState;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebEventItemShowDispatcher = this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebUtilFastWebActivityStackUtil$SaveState.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebEventItemShowDispatcher;
    this.jdField_p_of_type_Boolean = paramSaveState.jdField_a_of_type_Boolean;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebEventFastWebAdapterShowHelper = paramSaveState.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebEventFastWebAdapterShowHelper;
    u();
  }
  
  private void a(AuthorData paramAuthorData)
  {
    if (paramAuthorData == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewImplNativeAvatarView.setUin(Long.parseLong(paramAuthorData.jdField_c_of_type_JavaLangString));
    this.jdField_e_of_type_AndroidWidgetTextView.setText(paramAuthorData.jdField_b_of_type_JavaLangString);
    d(paramAuthorData.jdField_a_of_type_Boolean);
  }
  
  private void a(AuthorData paramAuthorData, FastWebArticleInfo paramFastWebArticleInfo)
  {
    if (paramAuthorData != null)
    {
      if (paramFastWebArticleInfo == null) {
        return;
      }
      paramAuthorData.c(paramFastWebArticleInfo.q);
      paramAuthorData.a();
    }
  }
  
  private void a(TitleData paramTitleData, FastWebArticleInfo paramFastWebArticleInfo)
  {
    if (paramTitleData != null)
    {
      if (paramFastWebArticleInfo == null) {
        return;
      }
      paramTitleData.a();
      paramTitleData.c(paramFastWebArticleInfo.q);
    }
  }
  
  private void a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(" url: ");
    ((StringBuilder)localObject1).append(paramAbsBaseArticleInfo.mArticleContentUrl);
    QLog.d("FastWebActivity", 1, ((StringBuilder)localObject1).toString());
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaCommonSuspensionGestureLayout;
    if ((localObject1 != null) && (this.B)) {
      ((CommonSuspensionGestureLayout)localObject1).b();
    }
    int i2 = (int)paramAbsBaseArticleInfo.mChannelID;
    Bundle localBundle = new Bundle();
    localBundle.putString("leftViewText", null);
    Object localObject2 = paramAbsBaseArticleInfo.mArticleContentUrl;
    boolean bool = RIJItemViewTypeUtils.s(paramAbsBaseArticleInfo);
    int i1 = 0;
    localObject1 = localObject2;
    if (bool)
    {
      localObject1 = localObject2;
      if (!RIJItemViewTypeUtils.z(paramAbsBaseArticleInfo)) {
        localObject1 = ((TopicRecommendFeedsInfo.TopicRecommendInfo)paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityTopicRecommendFeedsInfo.a.get(0)).jdField_b_of_type_JavaLangString;
      }
    }
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      ao();
      QLog.d("FastWebActivity", 1, " url is null!");
      return;
    }
    localObject2 = localObject1;
    if (!(paramAbsBaseArticleInfo instanceof AdvertisementInfo))
    {
      if (((String)localObject1).contains("?"))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("&");
        localObject1 = ((StringBuilder)localObject2).toString();
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("?");
        localObject1 = ((StringBuilder)localObject2).toString();
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("from=0");
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    localObject1 = localObject2;
    if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAppAdvertisementInfo(paramAbsBaseArticleInfo))
    {
      localObject1 = localObject2;
      if (NetworkUtil.isWifiConnected(null))
      {
        if (((String)localObject2).contains("?"))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append((String)localObject2);
          ((StringBuilder)localObject1).append("&");
          localObject1 = ((StringBuilder)localObject1).toString();
        }
        else
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append((String)localObject2);
          ((StringBuilder)localObject1).append("?");
          localObject1 = ((StringBuilder)localObject1).toString();
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("acttype=42");
        localObject1 = ((StringBuilder)localObject2).toString();
      }
    }
    localObject2 = new Intent(this, ReadInJoyArticleDetailActivity.class);
    localBundle.putString("url", (String)localObject1);
    localBundle.putBoolean("hide_operation_bar", true);
    localBundle.putBoolean("from_native", true);
    localBundle.putString("from", String.valueOf(53));
    localBundle.putString("subscribename", paramAbsBaseArticleInfo.mSubscribeName);
    localBundle.putLong("articleid", paramAbsBaseArticleInfo.mArticleID);
    localBundle.putString("row_key", paramAbsBaseArticleInfo.innerUniqueID);
    localBundle.putInt("channelid", i2);
    localBundle.putInt("strategyid", paramAbsBaseArticleInfo.mStrategyId);
    localBundle.putLong("algorithmid", paramAbsBaseArticleInfo.mAlgorithmID);
    localBundle.putParcelable("fastwebinfo", this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo);
    localBundle.putParcelable("articleinfo", this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo);
    localBundle.putInt("articalChannelId", 9);
    paramAbsBaseArticleInfo = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo;
    if (paramAbsBaseArticleInfo != null) {
      i1 = paramAbsBaseArticleInfo.jdField_d_of_type_Int;
    }
    localBundle.putInt("article_source", i1);
    ((Intent)localObject2).putExtras(localBundle);
    startActivityForResult((Intent)localObject2, 10923);
  }
  
  private void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    int i1 = (int)paramAbsBaseArticleInfo.mChannelID;
    if (paramFastWebArticleInfo.a()) {
      localObject = "2";
    } else {
      localObject = "1";
    }
    Object localObject = RIJTransMergeKanDianReport.a(this, paramAbsBaseArticleInfo, i1, (String)localObject);
    for (;;)
    {
      try
      {
        ((JSONObject)localObject).put("comment", paramFastWebArticleInfo.jdField_b_of_type_Long);
        if (!this.jdField_w_of_type_Boolean) {
          break label124;
        }
        i1 = 1;
        ((JSONObject)localObject).put("click_src", i1);
        if ((this.B) && (this.jdField_x_of_type_Int != -1)) {
          ((JSONObject)localObject).put("source_extratype", this.jdField_x_of_type_Int);
        }
      }
      catch (JSONException paramFastWebArticleInfo)
      {
        paramFastWebArticleInfo.printStackTrace();
      }
      ReportUtil.a(paramAbsBaseArticleInfo, "0X8008989", ((JSONObject)localObject).toString());
      b();
      return;
      label124:
      i1 = 0;
    }
  }
  
  private void a(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    this.jdField_c_of_type_JavaLangString = paramActionSheetItem.uin;
    this.jdField_y_of_type_Int = paramActionSheetItem.uinType;
    this.jdField_d_of_type_JavaLangString = paramActionSheetItem.label;
  }
  
  private void a(AbsListView paramAbsListView, int paramInt, boolean paramBoolean)
  {
    this.jdField_c_of_type_Int = paramInt;
    if (((!this.jdField_k_of_type_Boolean) && (!paramBoolean)) || ((this.jdField_j_of_type_Boolean) && (!paramBoolean)) || (this.jdField_l_of_type_Boolean)) {
      return;
    }
    float f1 = paramAbsListView.getFlingVelocityY();
    if ((!paramBoolean) && ((f1 < this.jdField_a_of_type_Float) || (f1 > this.jdField_b_of_type_Float))) {
      return;
    }
    if ((this.jdField_c_of_type_Int <= paramInt) && (paramInt < paramAbsListView.getCount() - 1))
    {
      this.jdField_c_of_type_Int = paramInt;
      Object localObject1 = (ListAdapter)paramAbsListView.getAdapter();
      if (localObject1 == null) {
        return;
      }
      if (!paramBoolean) {
        paramInt += 1;
      }
      Object localObject2 = ((ListAdapter)localObject1).getItem(paramInt);
      if (!((IRIJFastWebAdService)QRoute.api(IRIJFastWebAdService.class)).isBottomAd(localObject2)) {
        return;
      }
      int i1 = ((ListAdapter)localObject1).getItemViewType(paramInt);
      localObject2 = (View)this.jdField_b_of_type_AndroidUtilSparseArray.get(i1);
      if (localObject2 == null)
      {
        localObject1 = ((ListAdapter)localObject1).getView(paramInt, null, paramAbsListView);
        this.jdField_b_of_type_AndroidUtilSparseArray.put(i1, localObject1);
      }
      else
      {
        localObject1 = ((ListAdapter)localObject1).getView(paramInt, (View)localObject2, paramAbsListView);
      }
      localObject2 = paramAbsListView.getChildAt(paramAbsListView.getLastVisiblePosition() - paramAbsListView.getFirstVisiblePosition());
      if ((localObject2 != null) && (localObject1 != null))
      {
        i1 = paramAbsListView.getRemainFlingDisY();
        int i2 = ((View)localObject2).getBottom() + paramAbsListView.getTop() - paramAbsListView.getBottom() - paramAbsListView.getPaddingBottom();
        ViewGroup.LayoutParams localLayoutParams = ((View)localObject1).getLayoutParams();
        if (localLayoutParams != null) {
          paramInt = localLayoutParams.width;
        } else {
          paramInt = -1;
        }
        ((View)localObject1).measure(ViewGroup.getChildMeasureSpec(paramAbsListView.getMeasuredWidthAndState(), paramAbsListView.getPaddingLeft() + paramAbsListView.getPaddingRight(), paramInt), 0);
        paramInt = ((View)localObject1).getMeasuredHeight();
        if ((paramBoolean) && (i2 < paramInt / 2))
        {
          this.jdField_l_of_type_Boolean = true;
          return;
        }
        if (((i1 > i2) && (i1 < paramInt / 2 + i2)) || ((paramBoolean) && (i2 > paramInt / 2)))
        {
          this.jdField_j_of_type_Boolean = true;
          localObject1 = new FastWebActivity.SmoothScrollTask(this, (View)localObject2, paramAbsListView, i1, paramInt, paramBoolean);
          if (Build.VERSION.SDK_INT >= 16)
          {
            paramAbsListView.postOnAnimation((Runnable)localObject1);
            return;
          }
          paramAbsListView.post((Runnable)localObject1);
        }
      }
      else
      {
        this.jdField_l_of_type_Boolean = true;
      }
    }
  }
  
  private void a(Object paramObject)
  {
    if (!(paramObject instanceof Boolean)) {
      return;
    }
    if (((Boolean)paramObject).booleanValue()) {
      return;
    }
    d(true);
    paramObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListAdapter;
    if (paramObject != null) {
      paramObject.notifyDataSetChanged();
    }
    paramObject = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFastwebEntityAuthorData;
    if (paramObject == null) {
      return;
    }
    paramObject.b(true);
  }
  
  private void a(List<BaseData> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      BaseData localBaseData = (BaseData)paramList.next();
      if (((IRIJFastWebAdService)QRoute.api(IRIJFastWebAdService.class)).instanceofProteusBannerVideoItemData(localBaseData)) {
        ((IRIJFastWebAdService)QRoute.api(IRIJFastWebAdService.class)).setBannerVideoDataShowingGuide(localBaseData, false);
      }
    }
  }
  
  private void a(boolean paramBoolean1, String paramString, List<BaseData> paramList1, List<BaseData> paramList2, int paramInt, boolean paramBoolean2)
  {
    ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("REPORT_LINK", "requestAdData onGetRecommendsResult");
    if (paramBoolean1)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo;
      if ((localObject != null) && (((FastWebArticleInfo)localObject).o.equals(paramString)))
      {
        paramString = new ArrayList();
        localObject = new ArrayList();
        Iterator localIterator = paramList2.iterator();
        while (localIterator.hasNext())
        {
          BaseData localBaseData = (BaseData)localIterator.next();
          if (localBaseData.jdField_f_of_type_Boolean) {
            paramString.add(localBaseData);
          }
          do
          {
            break;
            if (!((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).instanceOfRecommendAdData(localBaseData)) {
              break label200;
            }
            if (paramInt == 0) {
              ((List)localObject).add(localBaseData);
            }
          } while ((paramInt != 1) || (!paramBoolean2));
          ((IRIJFastWebAdService)QRoute.api(IRIJFastWebAdService.class)).addHotRecommend(paramList1, (List)localObject, localBaseData);
          ((IRIJFastWebAdService)QRoute.api(IRIJFastWebAdService.class)).resetRecommendAdData(localBaseData, paramInt);
          continue;
          label200:
          ((List)localObject).add(localBaseData);
        }
        ItemDatasListUtils.a(this.jdField_a_of_type_JavaUtilList, paramList1, paramString, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo, true, this.jdField_a_of_type_AndroidUtilSparseArray, this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebEventItemShowDispatcher, paramInt, paramBoolean2);
        ItemDatasListUtils.a(this.jdField_a_of_type_JavaUtilList, paramList1, (List)localObject, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo, false, this.jdField_a_of_type_AndroidUtilSparseArray, this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebEventItemShowDispatcher, paramInt, paramBoolean2);
        paramString = ReadInJoyLogicEngine.a().a();
        if (paramString != null) {
          paramString.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo.j, this.jdField_a_of_type_JavaUtilList);
        }
        ad();
        ItemDatasListUtils.a(this.jdField_a_of_type_JavaUtilList);
        C();
        ((IRIJFastWebAdService)QRoute.api(IRIJFastWebAdService.class)).setCommonBarData(this, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barCommonAdBar, paramList2);
        paramString = new StringBuilder();
        paramString.append("adback initCommentAreaAnchor mCommentAreaLastFirstVisItemPos = ");
        paramString.append(this.jdField_s_of_type_Int);
        QLog.d("FastWebActivity", 1, paramString.toString());
        d();
        if (paramInt == 0) {
          this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebEventItemShowDispatcher.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView, 0);
        }
      }
    }
  }
  
  private boolean a()
  {
    this.jdField_a_of_type_JavaUtilList = ReadInJoyLogicEngine.a().a().a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo.j);
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if (localObject == null)
    {
      TimeUtil.a("HtmlChangeUtil.parse");
      if (this.jdField_a_of_type_AndroidUtilSparseArray == null) {
        this.jdField_a_of_type_AndroidUtilSparseArray = FastWebPTSDataConverter.a();
      }
      this.jdField_a_of_type_JavaUtilList = HtmlChangeUtil.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo, this.jdField_a_of_type_AndroidUtilSparseArray);
      an();
      localObject = this.jdField_a_of_type_JavaUtilList;
      if ((localObject != null) && (!((List)localObject).isEmpty()))
      {
        this.jdField_a_of_type_JavaUtilList.add(0, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFastwebEntityTitleData);
        this.jdField_a_of_type_JavaUtilList.add(1, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFastwebEntityAuthorData);
        t();
        FastWebArticleInfoUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo, this.jdField_a_of_type_JavaUtilList);
        localObject = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          BaseData localBaseData = (BaseData)((Iterator)localObject).next();
          localBaseData.b = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
          localBaseData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo;
        }
        TimeUtil.a("HtmlChangeUtil.parse");
        return false;
      }
      throw new RuntimeException("parse data is empty!");
    }
    if ((((List)localObject).size() >= 2) && ((this.jdField_a_of_type_JavaUtilList.get(0) instanceof TitleData)) && ((this.jdField_a_of_type_JavaUtilList.get(1) instanceof AuthorData)))
    {
      this.jdField_a_of_type_JavaUtilList.set(0, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFastwebEntityTitleData);
      this.jdField_a_of_type_JavaUtilList.set(1, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFastwebEntityAuthorData);
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("  ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaUtilList.size());
      ((StringBuilder)localObject).append("  :  ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mArticleContentUrl);
      AIOUtils.a("Q.readinjoy.fast_web", ((StringBuilder)localObject).toString(), new IllegalArgumentException());
    }
    if ((this.jdField_l_of_type_Int != 1001) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebUtilFastWebActivityStackUtil$SaveState == null)) {
      ((IRIJFastWebAdService)QRoute.api(IRIJFastWebAdService.class)).removeInnerAd(this.jdField_a_of_type_JavaUtilList);
    }
    ((IRIJFastWebAdService)QRoute.api(IRIJFastWebAdService.class)).removeBottomAd(this.jdField_a_of_type_JavaUtilList);
    return true;
  }
  
  private boolean a(int paramInt)
  {
    if ((TKDTuWenCommentUtil.isCommentSwitchOn()) && (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo != null))
    {
      E();
      this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenAdapterTKDTuWenHippyCommentAdapter = new TKDTuWenHippyCommentAdapter.Builder(this).articleInfo(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo).anchorData(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityAnchorData).contentSrc(paramInt).listView(this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView).build();
      this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebAdapterFastWebMergeAdapter.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenAdapterTKDTuWenHippyCommentAdapter);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenAdapterTKDTuWenHippyCommentAdapter.setHippyCommentPageListener(new FastWebActivity.MyHippyCommentPageListener(this, paramInt));
      this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenAdapterTKDTuWenHippyCommentAdapter.setHippyScrollListener(new FastWebActivity.HippyScrollListener(this, null));
      this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenAdapterTKDTuWenHippyCommentAdapter.init();
      return true;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mArticleInfo is null? ");
    boolean bool;
    if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo == null) {
      bool = true;
    } else {
      bool = false;
    }
    localStringBuilder.append(bool);
    QLog.d("FastWebActivity", 1, localStringBuilder.toString());
    return false;
  }
  
  private boolean a(BaseAdapter paramBaseAdapter, int paramInt1, int paramInt2)
  {
    if (!(paramBaseAdapter instanceof ReadInJoyCommentListAdapter)) {
      return false;
    }
    return c(paramBaseAdapter, paramInt1, paramInt2);
  }
  
  private byte[] a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
    byte[] arrayOfByte = null;
    if (localObject == null) {
      return null;
    }
    localObject = arrayOfByte;
    try
    {
      Parcel localParcel = Parcel.obtain();
      localObject = arrayOfByte;
      this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.writeToParcel(localParcel, 0);
      localObject = arrayOfByte;
      localParcel.setDataPosition(0);
      localObject = arrayOfByte;
      arrayOfByte = localParcel.marshall();
      localObject = arrayOfByte;
      localParcel.recycle();
      return arrayOfByte;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      QLog.d("FastWebActivity", 2, "init color bytes error");
    }
    return localObject;
  }
  
  private void aa()
  {
    this.jdField_y_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.exitAnimation();
    QLog.d("FastWebActivity", 2, "mColorNoteController ：exitAnimation");
  }
  
  private void ab()
  {
    this.jdField_y_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaCommonSuspensionGestureLayout.a(0, 4);
    QLog.d("FastWebActivity", 2, "mFloating doClostAnimTopToBottom ");
  }
  
  private void ac()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView;
    if (localObject != null)
    {
      localObject = ((ReadInJoyCommentListView)localObject).onSaveInstanceState();
      if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo != null)
      {
        FastWebModule localFastWebModule = ((ReadInJoyLogicManager)this.app.getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER)).getReadInJoyLogicEngine().a();
        if (localFastWebModule != null)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mArticleID);
          localStringBuilder.append("");
          localFastWebModule.a(localStringBuilder.toString(), (Parcelable)localObject);
        }
      }
    }
  }
  
  private void ad()
  {
    ArrayList localArrayList = new ArrayList();
    int i1 = 0;
    while (i1 < this.jdField_a_of_type_JavaUtilList.size())
    {
      BaseData localBaseData = (BaseData)this.jdField_a_of_type_JavaUtilList.get(i1);
      if (localBaseData.jdField_u_of_type_Int != 6) {
        if (AdData.a(localBaseData))
        {
          localArrayList.add(new ItemShowDispatcher.AdPostionReportManager(i1, Long.valueOf(0L), localBaseData));
          this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebEventItemShowDispatcher.a(i1, new FastWebActivity.20(this, i1, localBaseData));
        }
        else if (ReportUtil.a(localBaseData))
        {
          this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebEventItemShowDispatcher.b(i1, new FastWebActivity.21(this, localBaseData));
        }
      }
      i1 += 1;
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebEventItemShowDispatcher.a(localArrayList);
  }
  
  private void ae()
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebEventItemShowDispatcher == null) {
        return;
      }
      int i1 = 0;
      while (i1 < this.jdField_a_of_type_JavaUtilList.size())
      {
        BaseData localBaseData = (BaseData)this.jdField_a_of_type_JavaUtilList.get(i1);
        if (b(localBaseData.jdField_u_of_type_Int)) {
          this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebEventItemShowDispatcher.b(i1, new FastWebActivity.22(this, localBaseData));
        }
        i1 += 1;
      }
    }
  }
  
  private void af()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebEventItemShowDispatcher;
    if (localObject1 != null)
    {
      if (this.jdField_a_of_type_JavaUtilList == null) {
        return;
      }
      if ((((ItemShowDispatcher)localObject1).a != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebEventItemShowDispatcher.a.size() > 0))
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebEventItemShowDispatcher.a.iterator();
        label237:
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject3 = (Integer)((Iterator)localObject1).next();
          int i1 = 0;
          for (;;)
          {
            if (i1 >= this.jdField_a_of_type_JavaUtilList.size()) {
              break label237;
            }
            if (((Integer)localObject3).intValue() == i1)
            {
              Object localObject2 = (BaseData)this.jdField_a_of_type_JavaUtilList.get(((Integer)localObject3).intValue());
              if (AdData.a((BaseData)localObject2))
              {
                ReportUtil.a(this.app, (AdData)localObject2);
                if (((BaseData)localObject2).b == null) {
                  break;
                }
                localObject3 = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("invalidADExposurePos report ");
                localStringBuilder.append(((BaseData)localObject2).b.mTitle);
                ((IRIJAdLogService)localObject3).d("REPORT_LINK", localStringBuilder.toString());
                break;
              }
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("invalidADExposurePos report invalid key");
              ((StringBuilder)localObject2).append(localObject3);
              QLog.d("FastWebActivity", 1, ((StringBuilder)localObject2).toString());
              break;
            }
            i1 += 1;
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebEventItemShowDispatcher.a.clear();
      }
    }
  }
  
  private void ag()
  {
    int i1 = b();
    ReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, a(), i1, this.jdField_p_of_type_Boolean, this.jdField_b_of_type_Long, this.jdField_x_of_type_Int);
    WebFastAdapter localWebFastAdapter = this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebAdapterWebFastAdapter;
    if (localWebFastAdapter != null) {
      localWebFastAdapter.e();
    }
  }
  
  private void ah()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListAdapter;
    if (localObject != null)
    {
      localObject = ((ReadInJoyCommentListAdapter)localObject).a();
      if (localObject != null) {
        ((ReadInJoyCommentReportManager)localObject).a(this.jdField_u_of_type_Int);
      }
    }
  }
  
  private void ai()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
    if (localObject != null)
    {
      TimeSliceHelper.c(((AbsBaseArticleInfo)localObject).innerUniqueID);
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListAdapter;
      if ((localObject != null) && (((ReadInJoyCommentListAdapter)localObject).a() != null))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListAdapter.a();
        ((ReadInJoyCommentReportManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseUtilsTimeSliceHelper.b(), this.jdField_u_of_type_Int);
        ((ReadInJoyCommentReportManager)localObject).a(0, this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView.getLastVisiblePosition() - this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebAdapterWebFastAdapter.getCount());
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenAdapterTKDTuWenHippyCommentAdapter;
      if (localObject != null) {
        ((TKDTuWenHippyCommentAdapter)localObject).sendCommentReadTime(this.jdField_a_of_type_ComTencentMobileqqKandianBaseUtilsTimeSliceHelper.b());
      }
    }
  }
  
  private void aj()
  {
    long l1 = TimeUtil.c("fast_web_show_light_house_1");
    if (l1 < 0L) {
      return;
    }
    boolean bool = this.jdField_n_of_type_Boolean;
    long l2 = TimeUtil.c("fast_web_show_light_house_2");
    long l3 = TimeUtil.c("fast_web_show_light_house_3");
    long l4 = TimeUtil.c("fast_web_show_light_house_draw_finish");
    long l5 = TimeUtil.c("fast_web_show_light_house_step4_2");
    long l6 = TimeUtil.c("fast_web_show_light_house_step4_1");
    HashMap localHashMap = new HashMap();
    localHashMap.put("which", "1");
    localHashMap.put("step1", String.valueOf(l2 - l1));
    localHashMap.put("step2", String.valueOf(l3 - l2));
    localHashMap.put("step3", String.valueOf(l4 - l3));
    localHashMap.put("step4", String.valueOf(l5 - l6));
    localHashMap.put("param_uin", RIJQQAppInterfaceUtil.a());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("reportSpentTime, params = ");
    localStringBuilder.append(localHashMap.toString());
    localStringBuilder.append("  all cost : ");
    l1 = l4 - l1;
    localStringBuilder.append(l1);
    QLog.d("Q.readinjoy.fast_web", 2, localStringBuilder.toString());
    StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(null, "actKandianFastWebCost", bool ^ true, l1, 0L, localHashMap, null);
  }
  
  private void ak()
  {
    this.jdField_n_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView.getFirstVisiblePosition();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView.getChildAt(0);
    int i1;
    if (localObject == null) {
      i1 = 0;
    } else {
      i1 = ((View)localObject).getTop();
    }
    this.jdField_o_of_type_Int = i1;
    this.jdField_p_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView.getLastVisiblePosition();
    boolean bool1 = c(this.jdField_n_of_type_Int);
    boolean bool2 = c(this.jdField_p_of_type_Int);
    if ((!bool1) && (!bool2))
    {
      this.jdField_q_of_type_Int = this.jdField_n_of_type_Int;
      this.jdField_r_of_type_Int = this.jdField_o_of_type_Int;
      this.jdField_v_of_type_Boolean = true;
      return;
    }
    if ((bool1) && (bool2))
    {
      this.jdField_s_of_type_Int = this.jdField_n_of_type_Int;
      this.jdField_t_of_type_Int = this.jdField_o_of_type_Int;
      this.jdField_v_of_type_Boolean = false;
      this.jdField_i_of_type_Boolean = true;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("upCmtHisPos mCommentAreaLastFirstVisItemPos = ");
      ((StringBuilder)localObject).append(this.jdField_s_of_type_Int);
      QLog.d("FastWebActivity", 1, ((StringBuilder)localObject).toString());
      return;
    }
    if ((!bool1) && (bool2))
    {
      this.jdField_v_of_type_Boolean = false;
      this.jdField_i_of_type_Boolean = true;
      this.jdField_q_of_type_Int = 0;
      this.jdField_r_of_type_Int = 0;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("2area show together initCommentAreaAnchor mCommentAreaLastFirstVisItemPos = ");
      ((StringBuilder)localObject).append(this.jdField_s_of_type_Int);
      QLog.d("FastWebActivity", 1, ((StringBuilder)localObject).toString());
      d();
    }
  }
  
  private void al()
  {
    try
    {
      FastWebPTSDataConverter.a(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo, this.jdField_a_of_type_AndroidUtilSparseArray);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebReadInJoyFastWebBottomSocialViewNew.setData(this, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo);
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateConfigInfo error ! msg=");
      localStringBuilder.append(localException);
      QLog.d("FastWebActivity", 1, localStringBuilder.toString());
    }
  }
  
  private void am()
  {
    if (!this.jdField_o_of_type_Boolean) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebUtilFastWebActivityStackUtil$SaveState == null) {
      finish();
    }
  }
  
  private void an()
  {
    FastWebPTSUtils.a(this.jdField_a_of_type_JavaUtilList);
  }
  
  private void ao()
  {
    Object localObject = findViewById(2131373730);
    if (localObject != null) {
      ((View)localObject).setVisibility(0);
    }
    localObject = (TextView)findViewById(2131376089);
    String str = getString(2131717984);
    if ((localObject != null) && (!TextUtils.isEmpty(str)))
    {
      ((TextView)localObject).setVisibility(0);
      ((TextView)localObject).setText(str);
    }
  }
  
  private void ap()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebUtilFastWebActivityStackUtil.a()) {
      return;
    }
    this.jdField_u_of_type_Boolean = true;
    doOnPause();
    doOnStop();
    ag();
    VideoReport.pageLogicDestroy(this);
    this.jdField_u_of_type_Boolean = false;
    FastWebActivityStackUtil.SaveState localSaveState = this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebUtilFastWebActivityStackUtil.a();
    if (localSaveState != null)
    {
      a(localSaveState);
      this.jdField_u_of_type_Boolean = true;
      doOnStart();
      doOnResume();
      i();
      this.jdField_u_of_type_Boolean = false;
    }
  }
  
  private void aq()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebUtilFastWebActivityStackUtil$SaveState = null;
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = null;
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo = null;
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFastwebEntityTitleData = null;
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFastwebEntityAuthorData = null;
    this.jdField_m_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebEventItemHeightHelper = null;
    this.jdField_n_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilList = null;
    this.jdField_o_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebEventItemShowDispatcher = null;
    this.jdField_r_of_type_Boolean = false;
    this.jdField_s_of_type_Boolean = false;
    this.jdField_t_of_type_Boolean = false;
    this.jdField_d_of_type_Long = 0L;
    this.jdField_g_of_type_Int = 0;
    this.jdField_h_of_type_Int = 0;
    this.jdField_p_of_type_Boolean = false;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(System.currentTimeMillis());
    ((StringBuilder)localObject).append("");
    this.jdField_b_of_type_JavaLangString = ((StringBuilder)localObject).toString();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView.setDrawFinishedListener(null);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView.removeScrollListener(this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener);
    localObject = ReadInJoyLogicEngine.a().a();
    if (localObject != null)
    {
      ((FastWebModule)localObject).a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebFastWebActivity$ArticleRichInfoCallback);
      ((FastWebModule)localObject).a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFastwebFastWebModule$FastWebContentGetCallback);
    }
    this.jdField_j_of_type_Int = 0;
  }
  
  private void ar()
  {
    if ((isFinishing()) || (this.jdField_u_of_type_Boolean))
    {
      QLog.d("FastWebActivity", 1, "fastwebActivity doOnStop | removeCommentDataManager");
      ReadInJoyCommentDataManager.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo);
    }
  }
  
  private void as()
  {
    int i1 = b();
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo != null) && (i1 != 0)) {
      RIJFeedsDynamicInsertController.INSTANCE.requestInsertArticlesAndRecordAction(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.innerUniqueID, new RIJFeedsInsertAction(ActionType.ACTION_ARTICLE_READ_PROGRESS, a() * 100 / i1, 0, (int)TimeSliceHelper.b(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.innerUniqueID) / 1000), 5);
    }
  }
  
  private void at()
  {
    RIJFeedsType.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.innerUniqueID);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("preGotoConversation mActivityStack size = ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebUtilFastWebActivityStackUtil.a());
      localStringBuilder.append("ismain = ");
      boolean bool;
      if (Looper.myLooper() == Looper.getMainLooper()) {
        bool = true;
      } else {
        bool = false;
      }
      localStringBuilder.append(bool);
      QLog.i("FastWebActivity", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebUtilFastWebActivityStackUtil.a(new FastWebActivity.32(this));
  }
  
  private void au()
  {
    C();
  }
  
  private void av()
  {
    Object localObject = getIntent();
    if (localObject == null) {
      return;
    }
    localObject = ((Intent)localObject).getExtras();
    if (localObject == null) {
      return;
    }
    this.B = ((Bundle)localObject).getBoolean("launch_from_floating_window", false);
    if (this.B)
    {
      this.C = ((Bundle)localObject).getBoolean("scroll_to_top", true);
      this.D = ((Bundle)localObject).getBoolean("up_animation", true);
      this.jdField_x_of_type_Int = ((Bundle)localObject).getInt("floating_window_scene", -1);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("mFloating initFloatingWindow,isFromFloatingLayer=");
    ((StringBuilder)localObject).append(this.B);
    ((StringBuilder)localObject).append("  isSuctionTop=");
    ((StringBuilder)localObject).append(this.C);
    QLog.d("FastWebActivity", 1, ((StringBuilder)localObject).toString());
  }
  
  private void aw()
  {
    int i1 = (int)(((com.tencent.mobileqq.kandian.base.utils.api.IRIJDisplayStyleManager)QRoute.api(com.tencent.mobileqq.kandian.base.utils.api.IRIJDisplayStyleManager.class)).getPhysicalDisplaySize(this)[0] / 16.0F * 9.0F);
    if (i1 > 0)
    {
      View localView = this.jdField_d_of_type_AndroidViewView;
      if ((localView != null) && ((localView.getLayoutParams() instanceof RelativeLayout.LayoutParams))) {
        ((RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidViewView.getLayoutParams()).topMargin = i1;
      }
    }
  }
  
  private void ax()
  {
    RIJBiuAndCommentMixDataManager localRIJBiuAndCommentMixDataManager = this.jdField_a_of_type_ComTencentMobileqqKandianBizBiuRIJBiuAndCommentMixDataManager;
    if (localRIJBiuAndCommentMixDataManager != null) {
      localRIJBiuAndCommentMixDataManager.a();
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizBiuRIJBiuAndCommentMixDataManager = new RIJBiuAndCommentMixDataManager();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizBiuRIJBiuAndCommentMixDataManager.a(new FastWebActivity.39(this));
  }
  
  private void ay()
  {
    Intent localIntent = getIntent();
    if (localIntent != null)
    {
      if (localIntent.getExtras() == null) {
        return;
      }
      switch (localIntent.getExtras().getInt("native_article_launch_from", 1000))
      {
      case 1001: 
      default: 
        return;
      case 1004: 
        this.jdField_m_of_type_Int = 32;
        return;
      case 1003: 
        this.jdField_m_of_type_Int = 64;
        return;
      case 1002: 
        this.jdField_m_of_type_Int = 16;
        return;
      }
      this.jdField_m_of_type_Int = c();
    }
  }
  
  private int b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebEventItemHeightHelper == null)
    {
      QLog.e("Q.readinjoy.fast_web", 2, "getRatio itemsHeight == null ");
      return -1;
    }
    int i1 = 0;
    int i3;
    for (int i2 = 0; i1 < this.jdField_a_of_type_JavaUtilList.size(); i2 = i3)
    {
      i3 = i2;
      if (FastWebPTSUtils.a((BaseData)this.jdField_a_of_type_JavaUtilList.get(i1))) {
        i3 = i2 + this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebEventItemHeightHelper.a(i1);
      }
      i1 += 1;
    }
    return i2;
  }
  
  private void b(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenAdapterTKDTuWenHippyCommentAdapter == null) {
      return;
    }
    ReadInJoySecondCommentListFragment localReadInJoySecondCommentListFragment = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoySecondCommentListFragment;
    if ((localReadInJoySecondCommentListFragment != null) && (localReadInJoySecondCommentListFragment.isVisible()) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoySecondCommentListFragment.a()))
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoySecondCommentListFragment.onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenAdapterTKDTuWenHippyCommentAdapter.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  private void b(int paramInt, Intent paramIntent)
  {
    if ((paramInt == -10069) && (paramIntent != null) && (paramIntent.getExtras() != null)) {
      ReadInJoyUtils.a(this, ((AbsBaseArticleInfo)paramIntent.getExtras().get("fast_web_article_info")).mArticleContentUrl);
    }
  }
  
  private void b(int paramInt, AuthorData paramAuthorData)
  {
    if (paramAuthorData != null) {
      d(paramAuthorData.jdField_a_of_type_Boolean);
    } else {
      paramInt = 4;
    }
    int i1 = this.jdField_b_of_type_AndroidWidgetImageView.getVisibility();
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(paramInt);
    if ((i1 != paramInt) && (paramInt == 0)) {
      ReadinjoyReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, ReadinjoyReportUtils.jdField_d_of_type_Int, true, "");
    }
  }
  
  private void b(long paramLong)
  {
    ThreadManager.getUIHandler().postDelayed(new FastWebActivity.31(this), paramLong);
  }
  
  private void b(Intent paramIntent)
  {
    int i1;
    if (paramIntent.getIntExtra("click_comment_edit_src", -1) == 2) {
      i1 = 1;
    } else {
      i1 = 2;
    }
    ReadInJoyCommentListFragment.a(paramIntent, this.jdField_a_of_type_ComTencentMobileqqKandianBizBiuRIJBiuAndCommentMixDataManager, 1, true, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListAdapter.b(), i1);
    QLog.d("FastWebActivity", 1, "back from biuAndComment");
  }
  
  private void b(Bundle paramBundle)
  {
    Bundle localBundle = getIntent().getExtras();
    if (localBundle != null)
    {
      QLog.d("FastWebActivity", 1, "onSaveInstanceState data != null");
      paramBundle.putBundle("bundle_key_save_instancestate", localBundle);
    }
  }
  
  private void b(BaseData paramBaseData)
  {
    if (paramBaseData == null) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilSet.contains(paramBaseData)) {
      return;
    }
    if (paramBaseData.jdField_w_of_type_Int != 1) {
      if (paramBaseData.jdField_w_of_type_Int == 2) {
        return;
      }
    }
    for (;;)
    {
      try
      {
        Object localObject2;
        if (paramBaseData.jdField_u_of_type_Int == 6)
        {
          ReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, paramBaseData);
          if ((paramBaseData instanceof ProteusRecommendItemData))
          {
            JSONObject localJSONObject1 = ((ProteusRecommendItemData)paramBaseData).c;
            if ((localJSONObject1 != null) && (localJSONObject1.opt("id_recommend_category_txt") != null) && (localJSONObject1.opt("kd_ug_download_url") != null) && (localJSONObject1.optString("kd_ug_rsp_info") != null))
            {
              localObject2 = "";
              localObject1 = localObject2;
              if (localJSONObject1.opt("card_info") != null)
              {
                JSONObject localJSONObject2 = localJSONObject1.getJSONObject("card_info");
                localObject1 = localObject2;
                if (localJSONObject2.opt("rowKey") != null) {
                  localObject1 = localJSONObject2.getString("rowKey");
                }
              }
              KandianUGStatisticUtils.a(KandianUGStatisticUtils.a(new FastWebRecommendUGInfo(localJSONObject1.optString("kd_ug_rsp_info")).jdField_a_of_type_JavaLangString, (String)localObject1, "2"));
            }
          }
        }
        else if (paramBaseData.jdField_u_of_type_Int == 26)
        {
          localObject1 = (ProteusItemData)paramBaseData;
          if (((ProteusItemData)localObject1).A == 2)
          {
            FastWebDislikeUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo, 2);
            FastWebDislikeUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, "0X80099DA");
            FastWebDislikeUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, "0X80100DB");
            FastWebDislikeUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, "0X8009A5A");
            localObject1 = RIJVideoRewardCoinManager.a;
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo.j;
            if (!this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo.jdField_e_of_type_Boolean) {
              break label431;
            }
            i1 = 3;
            ((RIJVideoRewardCoinManager.Companion)localObject1).a("0X800B2EA", new RIJVideoRewardCoinManager.RIJRewardData((String)localObject2, i1), 6);
          }
          else
          {
            FastWebProteusReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo, (ProteusItemData)localObject1);
          }
        }
        else
        {
          ReportUtil.a(paramBaseData);
          if (paramBaseData.b != null)
          {
            localObject1 = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("doExposure baseData=");
            ((StringBuilder)localObject2).append(paramBaseData.b.mTitle);
            ((IRIJAdLogService)localObject1).d("REPORT_LINK", ((StringBuilder)localObject2).toString());
          }
        }
        this.jdField_a_of_type_JavaUtilSet.add(paramBaseData);
        return;
      }
      catch (Exception paramBaseData)
      {
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("doExposure error! msg=");
        ((StringBuilder)localObject1).append(paramBaseData);
        QLog.d("FastWebActivity", 1, ((StringBuilder)localObject1).toString());
      }
      return;
      label431:
      int i1 = 1;
    }
  }
  
  private void b(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    AbsBaseArticleInfo localAbsBaseArticleInfo = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
    if (localAbsBaseArticleInfo != null) {
      QidianManager.a(this, 6, localAbsBaseArticleInfo.mTitle, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSummary, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mArticleContentUrl, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mFirstPagePicUrl, paramActionSheetItem.uin, paramActionSheetItem.uinType, false);
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.A) {
      return;
    }
    this.A = true;
    int i2 = this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebUtilFastWebActivityStackUtil.a();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("mColorNoteController ：finishOneByOne  size:");
    ((StringBuilder)localObject).append(i2);
    QLog.d("FastWebActivity", 2, ((StringBuilder)localObject).toString());
    int i1 = 0;
    while (i1 < i2)
    {
      finish();
      i1 += 1;
    }
    finish();
    if (this.B)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaCommonSuspensionGestureLayout;
      if ((localObject != null) && (paramBoolean)) {
        ((CommonSuspensionGestureLayout)localObject).d();
      }
    }
  }
  
  private boolean b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebEventItemHeightHelper != null)
    {
      WebFastAdapter localWebFastAdapter = this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebAdapterWebFastAdapter;
      if ((localWebFastAdapter == null) || (localWebFastAdapter.getCount() == this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebEventItemHeightHelper.a())) {
        return false;
      }
    }
    QLog.e("Q.readinjoy.fast_web", 2, "refreshMaxReadHeight itemsHeight == null ");
    return true;
  }
  
  private boolean b(int paramInt)
  {
    return (paramInt == 6) || (paramInt == 18) || (paramInt == 23) || (paramInt == 26);
  }
  
  private boolean b(BaseAdapter paramBaseAdapter, int paramInt1, int paramInt2)
  {
    if (!(paramBaseAdapter instanceof TKDTuWenHippyCommentAdapter)) {
      return false;
    }
    return c(paramBaseAdapter, paramInt1, paramInt2);
  }
  
  private int c()
  {
    long l1 = this.jdField_b_of_type_Long;
    if (l1 == 0L) {
      return 2;
    }
    if (l1 == 70L) {
      return 4;
    }
    return 8;
  }
  
  private void c(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebReadInJoyFastWebBottomSocialViewNew;
    if (localObject != null) {
      ((ReadInJoyFastWebBottomSocialViewNew)localObject).setFavoriteArticle(this, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo, paramInt);
    }
    if (this.jdField_s_of_type_Boolean) {
      localObject = "0X8008994";
    } else {
      localObject = "0X800898D";
    }
    FastWebShareUtils.a(this, (String)localObject, 8, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo);
    ReportUtil.a(this, getAppInterface(), this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, -1, 4, false);
  }
  
  private void c(Intent paramIntent)
  {
    paramIntent = paramIntent.getSerializableExtra("backToImageData");
    if ((paramIntent instanceof List))
    {
      paramIntent = (List)paramIntent;
      if (!paramIntent.isEmpty())
      {
        ThreadManager.getUIHandler().post(new FastWebActivity.27(this, paramIntent));
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("update comments info from commentlist activity ! size : ");
        localStringBuilder.append(paramIntent.size());
        QLog.d("FastWebActivity", 2, localStringBuilder.toString());
      }
    }
  }
  
  private void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebReadInJoyFastWebBottomSocialViewNew.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebReadInJoyFastWebBottomSocialViewNew.setData(this, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebReadInJoyFastWebBottomSocialViewNew.setVisibility(8);
  }
  
  private boolean c()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo == null) || (this.jdField_n_of_type_Boolean);
  }
  
  private boolean c(int paramInt)
  {
    if (!e()) {
      return false;
    }
    int i3 = this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebAdapterFastWebMergeAdapter.a().size();
    int i1 = 0;
    int i2 = 0;
    while (i1 < i3)
    {
      BaseAdapter localBaseAdapter = (BaseAdapter)this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebAdapterFastWebMergeAdapter.a().get(i1);
      if ((!a(localBaseAdapter, paramInt, i2)) && (!b(localBaseAdapter, paramInt, i2)))
      {
        i2 += localBaseAdapter.getCount();
        i1 += 1;
      }
      else
      {
        return true;
      }
    }
    return false;
  }
  
  private boolean c(BaseAdapter paramBaseAdapter, int paramInt1, int paramInt2)
  {
    int i1 = paramBaseAdapter.getCount();
    return (paramInt1 >= paramInt2) && (paramInt1 < i1 + paramInt2);
  }
  
  private void d(int paramInt)
  {
    FastWebModule localFastWebModule = ReadInJoyLogicEngine.a().a();
    String str = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mArticleContentUrl;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mArticleID);
    ((StringBuilder)localObject).append("");
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.innerUniqueID);
    localStringBuilder.append("");
    localFastWebModule.a(str, (String)localObject, localStringBuilder.toString(), this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSubscribeID, paramInt, this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebFastWebActivity$ArticleRichInfoCallback);
  }
  
  private void d(Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("arg_result_json");
    int i1 = -1;
    int i2 = paramIntent.getIntExtra("click_comment_edit_src", -1);
    paramIntent = ReadInJoyCommentDataManager.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo);
    if (paramIntent == null)
    {
      paramIntent = new StringBuilder();
      paramIntent.append("commentDataManage is null, src : ");
      paramIntent.append(i2);
      paramIntent.append(", hasInit : ");
      boolean bool;
      if (this.jdField_a_of_type_JavaUtilList != null) {
        bool = true;
      } else {
        bool = false;
      }
      paramIntent.append(bool);
      AIOUtils.a("FastWebActivity", paramIntent.toString(), new NullPointerException());
      return;
    }
    ReadInJoyCommentListAdapter localReadInJoyCommentListAdapter = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListAdapter;
    if (localReadInJoyCommentListAdapter != null) {
      i1 = localReadInJoyCommentListAdapter.b();
    }
    if (i2 != 2)
    {
      if (i2 != 3) {
        return;
      }
      paramIntent.c_(str, i1);
      return;
    }
    paramIntent.d(str, i1);
  }
  
  private void d(boolean paramBoolean)
  {
    Object localObject1 = this.jdField_b_of_type_AndroidWidgetImageView;
    int i1;
    if (paramBoolean) {
      i1 = 2130843001;
    } else {
      i1 = 2130843157;
    }
    ((ImageView)localObject1).setImageResource(i1);
    this.jdField_b_of_type_AndroidWidgetImageView.setTag(Boolean.valueOf(paramBoolean));
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
    if (localObject1 != null)
    {
      int i2 = 2;
      if (paramBoolean) {
        i1 = 2;
      } else {
        i1 = 1;
      }
      ((AbsBaseArticleInfo)localObject1).showFollowButtonType = i1;
      long l1 = 0L;
      try
      {
        long l2 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.getSubscribeUin());
        l1 = l2;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("mArticleInfo.getSubscribeUin() parse to long error");
        localStringBuilder.append(localNumberFormatException);
        QLog.d("FastWebActivity", 1, localStringBuilder.toString());
      }
      localObject2 = ReadInJoyLogicEngine.a().a();
      if (paramBoolean) {
        i1 = i2;
      } else {
        i1 = 1;
      }
      ((FollowListInfoModule)localObject2).a(l1, i1);
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenAdapterTKDTuWenHippyCommentAdapter;
    if ((localObject2 != null) && (paramBoolean)) {
      ((TKDTuWenHippyCommentAdapter)localObject2).updateFollowUI();
    }
  }
  
  private boolean d()
  {
    return (this.jdField_l_of_type_Int == 1001) && (!DailyModeConfigHandler.c(this.jdField_e_of_type_Int));
  }
  
  private boolean d(int paramInt)
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if ((localList != null) && (localList.size() > 0) && (paramInt > 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return FastWebPTSUtils.a((BaseData)this.jdField_a_of_type_JavaUtilList.get(paramInt));
    }
    return false;
  }
  
  private void e(int paramInt)
  {
    int i1;
    if (paramInt > this.jdField_g_of_type_Int) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebEventItemHeightHelper != null)
    {
      int i3 = this.jdField_g_of_type_Int;
      int i2 = paramInt;
      if (i3 > paramInt) {
        i2 = i3;
      }
      this.jdField_g_of_type_Int = i2;
      paramInt = this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView.getFirstVisiblePosition();
      paramInt = this.jdField_g_of_type_Int - paramInt;
      if ((paramInt < this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView.getChildCount()) && (this.jdField_g_of_type_Int < this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebEventItemHeightHelper.a()))
      {
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView.getChildAt(paramInt);
        paramInt = this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView.getHeight();
        i2 = ((View)localObject).getTop();
        this.jdField_i_of_type_Int = (this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebEventItemHeightHelper.a(this.jdField_g_of_type_Int) - (paramInt - i2));
        if (i1 != 0)
        {
          this.jdField_h_of_type_Int = this.jdField_i_of_type_Int;
        }
        else
        {
          paramInt = this.jdField_i_of_type_Int;
          i1 = this.jdField_h_of_type_Int;
          if (paramInt >= i1) {
            paramInt = i1;
          }
          this.jdField_h_of_type_Int = paramInt;
        }
        if (this.jdField_h_of_type_Int < 0) {
          this.jdField_h_of_type_Int = 0;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("  mMaxLastPosition  ");
        ((StringBuilder)localObject).append(this.jdField_g_of_type_Int);
        ((StringBuilder)localObject).append("  mMaxLastItemInvisibleHeight ");
        ((StringBuilder)localObject).append(this.jdField_h_of_type_Int);
        QLog.d("Q.readinjoy.fast_web", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  private void e(Intent paramIntent)
  {
    aq();
    paramIntent = paramIntent.getExtras();
    if (paramIntent == null)
    {
      QLog.e("Q.readinjoy.fast_web", 1, " refrashFromIntent data == null ");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = ((AbsBaseArticleInfo)paramIntent.get("fast_web_article_info"));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebEventItemShowDispatcher = new ItemShowDispatcher();
    this.jdField_g_of_type_Boolean = true;
    this.jdField_p_of_type_Boolean = paramIntent.getBoolean("fast_web_from_article_recommend", false);
    u();
  }
  
  private void e(boolean paramBoolean)
  {
    ((IRIJFastWebAdService)QRoute.api(IRIJFastWebAdService.class)).updateSoftAdBar(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barCommonAdBar, paramBoolean, a(this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView, this.jdField_w_of_type_Int), this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView.getHeight(), this.jdField_b_of_type_Int, this.jdField_q_of_type_Boolean);
  }
  
  private boolean e()
  {
    FastWebMergeAdapter localFastWebMergeAdapter = this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebAdapterFastWebMergeAdapter;
    boolean bool = false;
    if (localFastWebMergeAdapter == null) {
      return false;
    }
    if (localFastWebMergeAdapter.a().size() > 0) {
      bool = true;
    }
    return bool;
  }
  
  private void f(int paramInt)
  {
    int i1;
    if (this.jdField_f_of_type_Int == 72) {
      i1 = 13;
    } else {
      i1 = -1;
    }
    AppInterface localAppInterface = getAppInterface();
    AbsBaseArticleInfo localAbsBaseArticleInfo = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
    boolean bool;
    if (paramInt == -1) {
      bool = true;
    } else {
      bool = false;
    }
    ReportUtil.a(this, localAppInterface, localAbsBaseArticleInfo, 1, i1, false, bool, false);
  }
  
  private void f(boolean paramBoolean)
  {
    runOnUiThread(new FastWebActivity.34(this, paramBoolean));
  }
  
  private void g(int paramInt)
  {
    if (paramInt == -1)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo;
      if (localObject != null)
      {
        ((FastWebArticleInfo)localObject).jdField_c_of_type_Long += 1L;
        ThreadManager.getUIHandler().post(new FastWebActivity.26(this));
      }
    }
    Object localObject = getAppInterface();
    AbsBaseArticleInfo localAbsBaseArticleInfo = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
    boolean bool;
    if (paramInt == -1) {
      bool = true;
    } else {
      bool = false;
    }
    ReportUtil.a(this, (AppInterface)localObject, localAbsBaseArticleInfo, 0, -1, false, bool, false);
  }
  
  private void g(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo != null) && (!this.jdField_o_of_type_Boolean)) {
      I();
    }
  }
  
  private void h()
  {
    if (!this.jdField_u_of_type_Boolean)
    {
      ReadInJoyCommentListView localReadInJoyCommentListView = this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView;
      if ((localReadInJoyCommentListView != null) && (c(localReadInJoyCommentListView.getLastVisiblePosition()))) {
        this.jdField_a_of_type_ComTencentMobileqqKandianBaseUtilsTimeSliceHelper.a();
      }
    }
  }
  
  private void h(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaCommonSuspensionGestureLayout != null) && (this.B))
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebReadInJoyFastWebBottomSocialViewNew.setVisibility(paramInt);
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaCommonSuspensionGestureLayout.c();
    }
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo == null) {
      return;
    }
    try
    {
      VideoReport.setPageId(this, "1");
      String str;
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.innerUniqueID)) {
        str = "null";
      } else {
        str = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.innerUniqueID;
      }
      VideoReport.setPageContentId(this, str);
      VideoReport.setPageParams(this, new RIJDtParamBuilder().e(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.innerUniqueID).a(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mChannelID)).a("ref_channel", Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mChannelID)).b(Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.dtReportContentType)).a());
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      label115:
      break label115;
    }
    AIOUtils.a("Q.readinjoy.fast_web", "doPageDtReportConfig IllegalArgumentException. This is not a crash!!!", new IllegalArgumentException());
  }
  
  private void i(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("requestControllInfo delayTime: ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" rowKey: ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.innerUniqueID);
      QLog.d("FastWebActivity", 1, localStringBuilder.toString());
      ThreadManager.getUIHandler().postDelayed(this.jdField_a_of_type_JavaLangRunnable, paramInt);
    }
  }
  
  private void j()
  {
    if ((this.B) && (this.jdField_z_of_type_Boolean)) {
      ThreadManager.getUIHandler().postDelayed(new FastWebActivity.1(this), 500L);
    }
  }
  
  private void k()
  {
    if ((this.B) && (this.jdField_z_of_type_Boolean))
    {
      Intent localIntent = getIntent();
      Bundle localBundle = null;
      if (localIntent != null) {
        localBundle = localIntent.getExtras();
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaCommonSuspensionGestureLayout = new CommonSuspensionGestureLayout(this, localBundle);
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaCommonSuspensionGestureLayout.setIsAutoSuctionTop(this.C);
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaCommonSuspensionGestureLayout.setIsNeedPopAnim(this.D);
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaCommonSuspensionGestureLayout.setIsStatusImmersive(false);
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaCommonSuspensionGestureLayout.setContentScrollListener(new FastWebActivity.2(this));
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaCommonSuspensionGestureLayout.setViolaGestureListener(new FastWebActivity.3(this));
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaCommonSuspensionGestureLayout.a(this, 2131376638, 2131363764);
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaCommonSuspensionGestureLayout.setMaskBackGroundDrawable(getResources().getDrawable(2130841768));
      this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebReadInJoyFastWebBottomSocialViewNew.setBackgroundColor(-1);
    }
  }
  
  private void l()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo == null)
    {
      QLog.d("FastWebActivity", 2, "init color error mArticleInfo is null");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController = ((IColorNoteController)QRoute.api(IColorNoteController.class));
    this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.init(this, true, false, true, true, 0);
    this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.attachToActivity(this);
    this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.setServiceInfo(new FastWebActivity.4(this));
    if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mColorNoteController ： mOutterRowKey : ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.innerUniqueID);
      localStringBuilder.append("mTitle : ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mTitle);
      localStringBuilder.append("mSubscribeName : ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSubscribeName);
      localStringBuilder.append("mSubscribeName : ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSubscribeName);
      QLog.d("FastWebActivity", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.setOnColorNoteAnimFinishListener(new FastWebActivity.5(this));
    this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.setOnColorNoteCurdListener(new FastWebActivity.6(this));
    this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.setOnPageSwipeListener(new FastWebActivity.7(this));
    if (!this.jdField_z_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.disableSwipe();
    }
  }
  
  private void m()
  {
    jdField_b_of_type_Boolean = false;
    SneakyCallback.a(4);
  }
  
  private void n()
  {
    jdField_b_of_type_Boolean = false;
    jdField_c_of_type_Boolean = false;
    this.jdField_c_of_type_Long = 0L;
  }
  
  private void o()
  {
    try
    {
      this.jdField_a_of_type_AndroidViewView = findViewById(2131376732);
      if (ImmersiveUtils.isSupporImmersive() == 1)
      {
        this.jdField_a_of_type_AndroidViewView.setFitsSystemWindows(true);
        this.jdField_a_of_type_AndroidViewView.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
      }
      p();
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369249));
      findViewById(2131369202).setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebReadInJoyFastWebBottomSocialViewNew = ((ReadInJoyFastWebBottomSocialViewNew)findViewById(2131363764));
      this.jdField_b_of_type_AndroidViewView = findViewById(2131376638);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebReadInJoyFastWebBottomSocialViewNew.setProteusContext(a());
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView = ((ReadInJoyCommentListView)findViewById(2131381298));
      this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView.setEdgeEffectEnabled(true);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView.mEdgeGlowTop.setEdgeDrawable(getResources().getDrawable(2131167333));
      this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView.mEdgeGlowBottom.setEdgeDrawable(getResources().getDrawable(2131167333));
      this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView.setOverScrollTouchMode(1);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView.setOverScrollFlingMode(1);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView.setDescendantFocusability(262144);
      q();
      Object localObject = (QQAppInterface)ReadInJoyUtils.a();
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)((QQAppInterface)localObject).getRuntimeService(IQQAvatarService.class, "")).getInstance((AppInterface)localObject);
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(this);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379586));
      if (this.jdField_b_of_type_AndroidWidgetTextView.getPaint() != null) {
        this.jdField_b_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
      }
      this.jdField_e_of_type_AndroidViewView = findViewById(2131370707);
      this.jdField_e_of_type_AndroidViewView.setOnClickListener(this);
      V();
      r();
      s();
      localObject = findViewById(2131376561);
      ((View)localObject).setOnClickListener(this);
      a((View)localObject, "more_function_button", "more_function_button", "click_more_function");
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131366758));
      this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebFastWebActivity$RecommendAndAdCallback = new FastWebActivity.RecommendAndAdCallback(this);
      J();
      u();
      av();
      ay();
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      label380:
      break label380;
    }
    setResult(-10069, getIntent());
    finish();
  }
  
  private void p()
  {
    if (ThemeUtil.isInNightMode(ReadInJoyUtils.a()))
    {
      if (this.jdField_c_of_type_AndroidViewView == null)
      {
        ViewStub localViewStub = (ViewStub)findViewById(2131376106);
        if ((localViewStub instanceof ViewStub)) {
          this.jdField_c_of_type_AndroidViewView = localViewStub.inflate();
        }
      }
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
    }
  }
  
  private void q()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barCommonAdBar = ((CommonAdBar)findViewById(2131377697));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barCommonAdBar.bringToFront();
  }
  
  private void r()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131376777));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131371243));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371244));
    Drawable localDrawable = ImageUtil.a(this.jdField_a_of_type_AndroidWidgetImageView.getResources().getDrawable(2130841089), -16777216);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localDrawable);
    a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, "news_button", "news_button", "click_news");
  }
  
  private void s()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser = new MiniMsgUser(getActivity(), a());
    }
  }
  
  private void t()
  {
    if (Aladdin.getConfig(423).getIntegerFromString("native_article_show_read_count", 1) == 1)
    {
      ProteusItemData localProteusItemData = FastWebPTSDataConverter.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo, this.jdField_a_of_type_AndroidUtilSparseArray);
      if (localProteusItemData != null) {
        this.jdField_a_of_type_JavaUtilList.add(localProteusItemData);
      }
    }
  }
  
  private void u()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo == null)
    {
      G();
      return;
    }
    HashMap localHashMap = new HashMap();
    for (;;)
    {
      boolean bool;
      try
      {
        B();
        TimeUtil.b("fast_web_show_light_house_step4_1");
        this.jdField_a_of_type_ComTencentMobileqqKandianRepoFastwebEntityTitleData = FastWebArticleInfoUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo);
        a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFastwebEntityTitleData, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo);
        this.jdField_a_of_type_ComTencentMobileqqKandianRepoFastwebEntityAuthorData = FastWebArticleInfoUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo);
        a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFastwebEntityAuthorData, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo);
        bool = a();
        FastWebPTSDataConverter.a(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo);
        ItemDatasListUtils.a(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo);
        x();
        TimeUtil.b("fast_web_show_light_house_step4_2");
        this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebAdapterFastWebMergeAdapter = new FastWebMergeAdapter();
        this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebEventItemHeightHelper = new ItemHeightHelper(this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView, this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebAdapterFastWebMergeAdapter);
        this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebEventItemShowDispatcher.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebEventItemHeightHelper);
        this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebAdapterWebFastAdapter = new WebFastAdapter(this, this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder, a());
        this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebAdapterFastWebMergeAdapter.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebAdapterWebFastAdapter);
        if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo.c()) {
          D();
        }
        w();
        y();
        this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView.setDrawFinishedListener(this.jdField_a_of_type_ComTencentWidgetXListView$DrawFinishedListener);
        this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView.setOnScrollListener(this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener);
        this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebAdapterFastWebMergeAdapter);
        this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebAdapterFastWebMergeAdapter.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebAdapterFastWebMergeAdapter$OnDataSetChangeListener);
        this.jdField_d_of_type_AndroidViewView = findViewById(2131377094);
        aw();
        localObject3 = ReadInJoyLogicEngine.a().a();
        Object localObject1 = null;
        if (this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebUtilFastWebActivityStackUtil$SaveState != null)
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebUtilFastWebActivityStackUtil$SaveState.jdField_a_of_type_AndroidOsParcelable;
        }
        else if (localObject3 != null)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mArticleID);
          ((StringBuilder)localObject1).append("");
          localObject1 = ((FastWebModule)localObject3).a(((StringBuilder)localObject1).toString());
        }
        if (localObject1 != null)
        {
          localObject1 = (AbsListView.SavedState)localObject1;
          this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView.onRestoreInstanceState((Parcelable)localObject1);
          a(((AbsListView.SavedState)localObject1).position, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFastwebEntityAuthorData);
        }
        else
        {
          a(0, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFastwebEntityAuthorData);
        }
        a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFastwebEntityAuthorData);
        if ((this.jdField_l_of_type_Int == 1001) || (this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebUtilFastWebActivityStackUtil$SaveState != null)) {
          break label901;
        }
        a(this.jdField_a_of_type_JavaUtilList);
        if (localObject3 != null) {
          ((FastWebModule)localObject3).a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebFastWebActivity$ArticleRichInfoCallback, true);
        }
        if ((!bool) && (localObject3 != null)) {
          ((FastWebModule)localObject3).a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, this.jdField_a_of_type_JavaUtilList);
        }
        bool = true;
      }
      catch (Exception localException)
      {
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("has parse error, use webview open url! e=");
        ((StringBuilder)localObject3).append(localException);
        QLog.e("FastWebActivity", 1, ((StringBuilder)localObject3).toString());
        localHashMap.put("param_error", localException.toString());
        v();
        bool = false;
      }
      localHashMap.put("param_uin", RIJQQAppInterfaceUtil.a());
      localHashMap.put("param_url", this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mArticleContentUrl);
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mArticleID);
      ((StringBuilder)localObject2).append("");
      localHashMap.put("param_articleID", ((StringBuilder)localObject2).toString());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.innerUniqueID);
      ((StringBuilder)localObject2).append("");
      localHashMap.put("param_rowkey", ((StringBuilder)localObject2).toString());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mChannelID);
      ((StringBuilder)localObject2).append("");
      localHashMap.put("param_channelID", ((StringBuilder)localObject2).toString());
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actNativeWebParser", bool, 100L, 0L, localHashMap, "", true);
      if (!bool)
      {
        c(false);
        H();
      }
      else
      {
        c(true);
        FastWebArticleInfoUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo);
        ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_b_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
        ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
        if (this.jdField_d_of_type_Boolean)
        {
          this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebReadInJoyFastWebBottomSocialViewNew.b();
          this.jdField_d_of_type_Boolean = false;
        }
      }
      ReadInJoyDropFrameHelper.a().a(5555, this);
      ReadInJoyDropFrameHelper.a().a(6666, this);
      d();
      new StyleConfigHelper().a("native_article");
      ax();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("initData,isParseSuccess=");
      ((StringBuilder)localObject2).append(bool);
      QLog.d("FastWebActivity", 1, ((StringBuilder)localObject2).toString());
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo;
      if ((localObject2 != null) && (((FastWebArticleInfo)localObject2).jdField_e_of_type_Long != 0L))
      {
        ReadInJoyUserInfoModule.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo.jdField_e_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqKandianGlueMsfApiIReadInJoyUserInfoModule$RefreshUserInfoCallBack, true);
        a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo.jdField_e_of_type_Long);
      }
      return;
      label901:
      if (bool) {}
    }
  }
  
  private void v() {}
  
  private void w()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView.getFooterViewsCount() == 0) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView.initFooterView();
    }
  }
  
  private void x()
  {
    this.jdField_v_of_type_Int = 0;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      BaseData localBaseData = (BaseData)localIterator.next();
      if ((localBaseData != null) && ((localBaseData instanceof ProteusItemData)))
      {
        ProteusItemData localProteusItemData = (ProteusItemData)localBaseData;
        if ((localProteusItemData.A == 1) && ((localProteusItemData.jdField_z_of_type_Int == 1) || (localProteusItemData.jdField_z_of_type_Int == 2)) && (localBaseData.jdField_u_of_type_Int != 0)) {
          this.jdField_v_of_type_Int += 1;
        }
      }
    }
  }
  
  private void y()
  {
    this.jdField_a_of_type_ComTencentQqliveModuleVideoreportPageIScrollReader = new FastWebActivity.8(this);
    VideoReport.markAsPageBodyView(this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView, this.jdField_a_of_type_ComTencentQqliveModuleVideoreportPageIScrollReader);
    VideoReport.setPageBodyContentRange(this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView, 0, this.jdField_a_of_type_JavaUtilList.size());
  }
  
  private void z()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFastwebEntityAuthorData;
    if (localObject != null)
    {
      ((AuthorData)localObject).a("https://pub.idqqimg.com/pc/misc/files/20200611/2a67e74aa4ed4a71a8e877deac8e41cf.png");
      this.jdField_a_of_type_ComTencentMobileqqKandianRepoFastwebEntityAuthorData.b("https://pub.idqqimg.com/pc/misc/files/20200611/558a344321d34d25b847cf32ff9403f8.png");
      AbsBaseArticleInfo localAbsBaseArticleInfo = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
      if (localAbsBaseArticleInfo != null)
      {
        int i1 = (int)localAbsBaseArticleInfo.mChannelID;
        localObject = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo;
        if ((localObject != null) && (((FastWebArticleInfo)localObject).a())) {
          localObject = "2";
        } else {
          localObject = "1";
        }
        localObject = RIJTransMergeKanDianReport.a(this, localAbsBaseArticleInfo, i1, (String)localObject);
        try
        {
          ((JSONObject)localObject).put("live_circle_from_page", 1);
        }
        catch (JSONException localJSONException)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("live status error:");
          localStringBuilder.append(localJSONException.getMessage());
          QLog.e("FastWebActivity", 2, localStringBuilder.toString());
        }
        ReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, "0X800B17D", ((JSONObject)localObject).toString());
      }
    }
    C();
  }
  
  protected MiniMsgUserParam a()
  {
    MiniMsgUserParam localMiniMsgUserParam = new MiniMsgUserParam();
    localMiniMsgUserParam.businessName = 3;
    localMiniMsgUserParam.accessType = 1;
    localMiniMsgUserParam.filterMsgType = 1;
    localMiniMsgUserParam.actionCallback = this;
    RelativeLayout localRelativeLayout = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
    localMiniMsgUserParam.entryView = localRelativeLayout;
    localMiniMsgUserParam.unreadView = ((TextView)localRelativeLayout.findViewById(2131371244));
    localMiniMsgUserParam.filterMsgType = 1;
    return localMiniMsgUserParam;
  }
  
  public void a()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("arg_article_info", this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo);
    localIntent.putExtra("readinjoy_open_comment_from_image", true);
    PublicFragmentActivity.a(this, localIntent, ReadInJoyCommentListFragment.class, 1001);
  }
  
  public void a(int paramInt, float paramFloat)
  {
    float f1 = paramFloat;
    if (paramFloat > 5.0F) {
      f1 = 1.0F;
    }
    RIJSPUtils.a("readinjoy_font_size_ratio_sp", Float.valueOf(f1));
    TKDHippyEventDispatcher.changeFontScale(f1);
    ReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, "0X800B257", RIJJsonUtils.a(null, "font_size", Integer.valueOf(paramInt + 1)));
    C();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onFontSizeChange,index=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" ,textSizeRatio=");
    localStringBuilder.append(f1);
    QLog.d("FastWebActivity", 1, localStringBuilder.toString());
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    RIJSocialBottomUtils.a.a(paramInt1, paramInt2, paramBoolean, this, 2002, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo);
  }
  
  @VisibleForTesting
  void a(int paramInt, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    if (paramInt == 72) {
      a(paramActionSheetItem);
    }
    if (paramInt == 1)
    {
      K();
      return;
    }
    if (paramInt == 5)
    {
      L();
      return;
    }
    if (paramInt == 4)
    {
      M();
      return;
    }
    if (paramInt == 13)
    {
      N();
      return;
    }
    if (paramInt == 6)
    {
      c(4);
      return;
    }
    if (paramInt == 11)
    {
      O();
      return;
    }
    if (paramInt == 21)
    {
      P();
      return;
    }
    if (paramInt == 7)
    {
      Q();
      return;
    }
    if (paramInt == 26)
    {
      R();
      return;
    }
    if (paramInt == 68)
    {
      S();
      return;
    }
    if (paramInt == 70)
    {
      T();
      return;
    }
    if (paramInt == 82)
    {
      U();
      return;
    }
    if (paramInt == 19)
    {
      b(paramActionSheetItem);
      return;
    }
    d(paramInt);
  }
  
  public void a(Intent paramIntent)
  {
    this.jdField_u_of_type_Boolean = true;
    doOnPause();
    doOnStop();
    VideoReport.pageLogicDestroy(this);
    RIJ3ClickUtils.a.a();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebAdapterWebFastAdapter;
    if (localObject != null) {
      ((WebFastAdapter)localObject).d();
    }
    this.jdField_u_of_type_Boolean = false;
    localObject = new FastWebActivityStackUtil.SaveState();
    ((FastWebActivityStackUtil.SaveState)localObject).jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
    ((FastWebActivityStackUtil.SaveState)localObject).jdField_a_of_type_AndroidOsParcelable = this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView.onSaveInstanceState();
    ((FastWebActivityStackUtil.SaveState)localObject).jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    ((FastWebActivityStackUtil.SaveState)localObject).jdField_a_of_type_ComTencentMobileqqKandianBizFastwebEventItemShowDispatcher = this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebEventItemShowDispatcher;
    ((FastWebActivityStackUtil.SaveState)localObject).jdField_a_of_type_Boolean = this.jdField_p_of_type_Boolean;
    ((FastWebActivityStackUtil.SaveState)localObject).jdField_a_of_type_ComTencentMobileqqKandianBizFastwebEventFastWebAdapterShowHelper = this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebEventFastWebAdapterShowHelper;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebUtilFastWebActivityStackUtil.a((FastWebActivityStackUtil.SaveState)localObject);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(RIJQQAppInterfaceUtil.a());
    ((StringBuilder)localObject).append(System.currentTimeMillis());
    this.jdField_b_of_type_JavaLangString = ((StringBuilder)localObject).toString();
    e(paramIntent);
    this.jdField_u_of_type_Boolean = true;
    doOnStart();
    doOnResume();
    this.jdField_u_of_type_Boolean = false;
    i();
    ThreadManager.getUIHandler().post(new FastWebActivity.28(this));
  }
  
  public void a(View paramView, String paramString1, String paramString2, String paramString3)
  {
    RIJDtParamBuilder localRIJDtParamBuilder = new RIJDtParamBuilder();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo;
    if (localObject == null) {
      localObject = "";
    } else {
      localObject = ((FastWebArticleInfo)localObject).j;
    }
    paramString2 = localRIJDtParamBuilder.e((String)localObject).b(Integer.valueOf(5)).a("1").f(paramString2).c(paramString3).a();
    RIJProteusDtFactory.a().setDtElementIdWithParams(paramView, paramString1, paramString2.a());
  }
  
  public void a(BaseData paramBaseData)
  {
    runOnUiThread(new FastWebActivity.30(this, paramBaseData));
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    boolean bool;
    if (paramInt == 2) {
      bool = true;
    } else {
      bool = false;
    }
    this.jdField_k_of_type_Boolean = bool;
    if (paramInt == 0)
    {
      a(paramAbsListView, this.jdField_c_of_type_Int, true);
      return;
    }
    if (!this.jdField_k_of_type_Boolean)
    {
      this.jdField_j_of_type_Boolean = false;
      paramAbsListView.setInterpolator(null);
    }
  }
  
  public void a(BubblePopupWindow paramBubblePopupWindow)
  {
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = paramBubblePopupWindow;
  }
  
  public void a(String paramString)
  {
    TextView localTextView = this.jdField_c_of_type_AndroidWidgetTextView;
    if (localTextView == null) {
      return;
    }
    localTextView.setText(paramString);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
  }
  
  @TargetApi(23)
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      getWindow().getDecorView().setSystemUiVisibility(9216);
      return;
    }
    getWindow().getDecorView().setSystemUiVisibility(0);
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2)
  {
    a(paramBoolean, paramString1, paramString2, 2130772386, 2130772385);
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (paramBoolean)
    {
      if (this.jdField_z_of_type_Boolean)
      {
        IColorNoteController localIColorNoteController = this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController;
        if (localIColorNoteController != null) {
          localIColorNoteController.disableSwipe();
        }
      }
      this.jdField_e_of_type_AndroidViewView.setVisibility(0);
      new Bundle().putBoolean("arg_comment_list_biu_btn", false);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoySecondCommentListFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, paramString1, paramString2, 1);
      if (!isFinishing())
      {
        paramString1 = getSupportFragmentManager().beginTransaction();
        paramString1.setCustomAnimations(paramInt1, paramInt2);
        paramString1.show(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoySecondCommentListFragment);
        paramString1.commitAllowingStateLoss();
      }
      this.jdField_h_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseUtilsTimeSliceHelper.b();
      this.jdField_a_of_type_Int = 2;
      h(8);
      return;
    }
    if (this.jdField_z_of_type_Boolean)
    {
      paramString1 = this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController;
      if (paramString1 != null) {
        paramString1.enableSwipe();
      }
    }
    this.jdField_e_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseUtilsTimeSliceHelper.a();
    if (!isFinishing())
    {
      paramString1 = getSupportFragmentManager().beginTransaction();
      if (!(TextUtils.isEmpty(paramString2) ^ true)) {
        paramString1.setCustomAnimations(paramInt1, paramInt2);
      }
      paramString1.hide(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoySecondCommentListFragment);
      paramString1.commitAllowingStateLoss();
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoySecondCommentListFragment.d();
    this.jdField_h_of_type_Boolean = false;
    C();
    this.jdField_a_of_type_Int = 1;
    h(0);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public List<Integer>[] a(boolean paramBoolean)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if (localObject == null) {
      return null;
    }
    Map localMap = URLUtil.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mArticleContentUrl);
    int i1;
    if (localMap.containsKey("_wv")) {
      try
      {
        i1 = Integer.valueOf((String)localMap.get("_wv")).intValue();
      }
      catch (NumberFormatException localNumberFormatException2)
      {
        localNumberFormatException2.printStackTrace();
      }
    } else {
      i1 = 0;
    }
    int i2;
    if (localMap.containsKey("_wwv")) {
      try
      {
        i2 = Integer.valueOf((String)localMap.get("_wwv")).intValue();
      }
      catch (NumberFormatException localNumberFormatException1)
      {
        localNumberFormatException1.printStackTrace();
      }
    } else {
      i2 = 0;
    }
    ArrayList localArrayList1 = new ArrayList();
    localArrayList1.add(Integer.valueOf(13));
    long l1 = i1;
    if ((0x8 & l1) == 0L) {
      localArrayList1.add(Integer.valueOf(2));
    }
    if ((0x10 & l1) == 0L) {
      localArrayList1.add(Integer.valueOf(3));
    }
    if ((l1 & 0x4000) == 0L) {
      localArrayList1.add(Integer.valueOf(9));
    }
    if ((0x8000 & l1) == 0L) {
      localArrayList1.add(Integer.valueOf(10));
    }
    localArrayList1.add(Integer.valueOf(12));
    localArrayList1.add(Integer.valueOf(26));
    if ((0x100 & l1) == 0L) {
      localArrayList1.add(Integer.valueOf(4));
    }
    if ((!RIJSocialBottomViewAladdinConfig.d()) && (paramBoolean)) {
      return new List[] { localArrayList1, new ArrayList() };
    }
    ArrayList localArrayList2 = new ArrayList();
    if ((!TextUtils.isEmpty(((AppRuntime)localObject).getAccount())) && ((0x2000 & l1) == 0L)) {
      localArrayList2.add(Integer.valueOf(6));
    }
    localArrayList2.add(Integer.valueOf(21));
    localArrayList2.add(Integer.valueOf(7));
    if ((l1 & 0x20) == 0L) {
      localArrayList2.add(Integer.valueOf(1));
    }
    localArrayList2.add(Integer.valueOf(11));
    Collections.sort(localArrayList2);
    if (((i2 & 0x4000) == 0L) && (TeamWorkConvertUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mArticleContentUrl)))
    {
      i2 = localArrayList2.indexOf(Integer.valueOf(6));
      i1 = i2;
      if (i2 < 0) {
        i1 = localArrayList2.indexOf(Integer.valueOf(1));
      }
      if (i1 >= 0)
      {
        if (i1 < localArrayList2.size() - 1) {
          localArrayList2.add(i1 + 1, Integer.valueOf(68));
        } else {
          localArrayList2.add(Integer.valueOf(68));
        }
        TeamWorkConvertUtils.a(0, 2);
      }
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController;
    if ((localObject != null) && (((IColorNoteController)localObject).shouldDisplayColorNote()) && (this.jdField_z_of_type_Boolean)) {
      if (this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.isColorNoteExist())
      {
        localArrayList2.add(0, Integer.valueOf(82));
        QLog.d("FastWebActivity", 2, "mColorNoteController ： open sheet delete colorNote");
      }
      else
      {
        localArrayList2.add(0, Integer.valueOf(70));
        QLog.d("FastWebActivity", 2, "mColorNoteController ： open sheet add colorNote");
      }
    }
    return new List[] { localArrayList1, localArrayList2 };
  }
  
  protected void b()
  {
    ReportInfo localReportInfo = new ReportInfo();
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
    if (localObject2 != null)
    {
      Object localObject3 = ((AbsBaseArticleInfo)localObject2).mSocialFeedInfo;
      localObject1 = new FeedsReportData();
      localReportInfo.mUin = ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getLongAccountUin();
      localReportInfo.mSource = ((int)((AbsBaseArticleInfo)localObject2).mChannelID);
      localReportInfo.mSourceArticleId = ((AbsBaseArticleInfo)localObject2).mArticleID;
      localReportInfo.mChannelId = ((int)((AbsBaseArticleInfo)localObject2).mChannelID);
      localReportInfo.mAlgorithmId = ((int)((AbsBaseArticleInfo)localObject2).mAlgorithmID);
      localReportInfo.mStrategyId = ((AbsBaseArticleInfo)localObject2).mStrategyId;
      localReportInfo.mServerContext = ((AbsBaseArticleInfo)localObject2).mServerContext;
      localReportInfo.mInnerId = ((AbsBaseArticleInfo)localObject2).innerUniqueID;
      localReportInfo.mReadTimeLength = -1;
      if (localObject3 != null)
      {
        ((FeedsReportData)localObject1).jdField_a_of_type_Long = ((SocializeFeedsInfo)localObject3).jdField_a_of_type_Long;
        if (((SocializeFeedsInfo)localObject3).jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser != null) {
          ((FeedsReportData)localObject1).jdField_b_of_type_Long = ((SocializeFeedsInfo)localObject3).jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser.jdField_a_of_type_Long;
        }
        ((FeedsReportData)localObject1).jdField_a_of_type_Int = ((SocializeFeedsInfo)localObject3).jdField_b_of_type_Int;
        ((FeedsReportData)localObject1).jdField_b_of_type_Int = ((SocializeFeedsInfo)localObject3).jdField_d_of_type_Int;
        localObject2 = ((SocializeFeedsInfo)localObject3).jdField_a_of_type_JavaUtilList;
        if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
        {
          ((FeedsReportData)localObject1).jdField_a_of_type_JavaUtilList = new ArrayList();
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (FeedsInfoUser)((Iterator)localObject2).next();
            if (localObject3 != null) {
              ((FeedsReportData)localObject1).jdField_a_of_type_JavaUtilList.add(Long.valueOf(((FeedsInfoUser)localObject3).jdField_a_of_type_Long));
            }
          }
        }
      }
      localReportInfo.mOperation = 29;
      localReportInfo.mOpSource = 12;
      localReportInfo.mFeedsReportData = ((FeedsReportData)localObject1);
    }
    Object localObject1 = new ArrayList();
    ((List)localObject1).add(localReportInfo);
    ReadInJoyLogicEngine.a().a((List)localObject1);
  }
  
  public void b(int paramInt)
  {
    if (paramInt != 2)
    {
      if (paramInt != 4) {
        return;
      }
      ItemDatasListUtils.c(this.jdField_a_of_type_JavaUtilList);
      C();
      return;
    }
    ItemDatasListUtils.b(this.jdField_a_of_type_JavaUtilList);
    C();
  }
  
  public void c()
  {
    Object localObject = new ReadInJoyCommentUtils.CommentReportR5Builder(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, null).a(1);
    QLog.d("FastWebActivity", 1, "scrollToLastReadPos | begin");
    int i1;
    if (this.jdField_v_of_type_Boolean)
    {
      QLog.d("FastWebActivity", 1, "Scroll2CommentArea");
      i1 = this.jdField_s_of_type_Int;
      if (i1 == 0)
      {
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent((QQAppInterface)getAppInterface(), ReadInJoyCommentUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo), "0X8009C69", "0X8009C69", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mArticleID), String.valueOf(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mStrategyId), this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.innerUniqueID, "", false);
        QLog.d("FastWebActivity", 1, "mCommentAreaLastFirstVisItemPos == 0 return");
        return;
      }
      this.jdField_u_of_type_Int = 2;
      this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView.setSelectionFromTop(i1, this.jdField_t_of_type_Int);
      this.jdField_v_of_type_Boolean = false;
      this.jdField_i_of_type_Boolean = true;
      ((ReadInJoyCommentUtils.CommentReportR5Builder)localObject).b(1);
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseUtilsTimeSliceHelper.a();
      localObject = ((ReadInJoyCommentUtils.CommentReportR5Builder)localObject).a();
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent((QQAppInterface)getAppInterface(), ReadInJoyCommentUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo), "0X8009749", "0X8009749", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mArticleID), String.valueOf(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mStrategyId), this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.innerUniqueID, (String)localObject, false);
      i1 = this.jdField_s_of_type_Int;
    }
    else
    {
      QLog.d("FastWebActivity", 1, "Scroll2ArticleArea");
      this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView.setSelectionFromTop(this.jdField_q_of_type_Int, this.jdField_r_of_type_Int);
      i1 = this.jdField_q_of_type_Int;
      this.jdField_v_of_type_Boolean = true;
      ((ReadInJoyCommentUtils.CommentReportR5Builder)localObject).b(2);
      localObject = ((ReadInJoyCommentUtils.CommentReportR5Builder)localObject).a();
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent((QQAppInterface)getAppInterface(), ReadInJoyCommentUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo), "0X8009749", "0X8009749", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mArticleID), String.valueOf(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mStrategyId), this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.innerUniqueID, (String)localObject, false);
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseUtilsTimeSliceHelper.b();
    }
    QLog.d("FastWebActivity", 1, "scrollToLastReadPos | done");
    a(i1, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFastwebEntityAuthorData);
  }
  
  public void d()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebAdapterWebFastAdapter;
    int i1;
    if (localObject != null) {
      i1 = ((WebFastAdapter)localObject).getCount();
    } else {
      i1 = 0;
    }
    this.jdField_s_of_type_Int = i1;
    this.jdField_t_of_type_Int = 0;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("initCommentAreaAnchor mCommentAreaLastFirstVisItemPos = ");
    ((StringBuilder)localObject).append(this.jdField_s_of_type_Int);
    QLog.d("FastWebActivity", 1, ((StringBuilder)localObject).toString());
  }
  
  public void doOnBackPressed()
  {
    ((IRIJFastWebVideoPlayerManager)QRoute.api(IRIJFastWebVideoPlayerManager.class)).setVideoPauseType(ReportConstants.VideoEndType.EXIT_SCENE);
    ReadInJoyShareHelperV2 localReadInJoyShareHelperV2 = this.jdField_a_of_type_ComTencentMobileqqKandianBizShareReadInJoyShareHelperV2;
    if ((localReadInJoyShareHelperV2 != null) && (localReadInJoyShareHelperV2.a())) {
      return;
    }
    this.jdField_r_of_type_Boolean = true;
    if (!onBackEvent()) {
      finish();
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    VideoReport.addToDetectionWhitelist(this);
    PTSDeviceUtil.init(this);
    getWindow().setFlags(16777216, 16777216);
    Object localObject = a(paramBundle);
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("  ");
      ((StringBuilder)localObject).append(paramBundle);
      AIOUtils.a("Q.readinjoy.fast_web", ((StringBuilder)localObject).toString(), new IllegalArgumentException());
      finish();
      return true;
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = ((AbsBaseArticleInfo)((Bundle)localObject).get("fast_web_article_info"));
    this.jdField_d_of_type_Int = ((Bundle)localObject).getInt("fast_web_from_channel_id");
    this.jdField_w_of_type_Boolean = getIntent().getBooleanExtra("from_color_note", false);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("is from colorNote : ");
    localStringBuilder.append(this.jdField_w_of_type_Boolean);
    QLog.d("FastWebActivity", 1, localStringBuilder.toString());
    this.jdField_z_of_type_Boolean = SwipeLayoutUtils.a();
    if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo == null)
    {
      localObject = ((Bundle)localObject).getBundle("banner_webview_extra");
      if ((localObject != null) && (((Bundle)localObject).get("fast_web_article_info") != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = ((AbsBaseArticleInfo)((Bundle)localObject).get("fast_web_article_info"));
        this.jdField_e_of_type_Int = ((Bundle)localObject).getInt("fast_web_banner_from_channel_id");
        this.jdField_l_of_type_Int = 1001;
        this.jdField_p_of_type_Boolean = ((Bundle)localObject).getBoolean("fast_web_from_article_recommend", false);
      }
      else
      {
        setResult(-10069, getIntent());
        finish();
        return true;
      }
    }
    this.jdField_k_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mStrategyId;
    this.jdField_f_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mAlgorithmID;
    this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mArticleID;
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.innerUniqueID;
    this.jdField_b_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mChannelID;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(RIJQQAppInterfaceUtil.a());
    ((StringBuilder)localObject).append(System.currentTimeMillis());
    this.jdField_b_of_type_JavaLangString = ((StringBuilder)localObject).toString();
    i();
    a(paramBundle);
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X8009C4F", "0X8009C4F", 0, 0, "", Long.toString(this.jdField_a_of_type_Long), Integer.toString(this.jdField_k_of_type_Int), "", false);
    try
    {
      try
      {
        setContentView(2131560182);
        o();
      }
      catch (UnsupportedOperationException paramBundle)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[doOnCreate] UnsupportedOperationException e = ");
        ((StringBuilder)localObject).append(paramBundle);
        QLog.e("FastWebActivity", 1, ((StringBuilder)localObject).toString());
        AIOUtils.a("Q.readinjoy.fast_web", "setContentView UnsupportedOperationException. This is not a crash!!!", new IllegalArgumentException());
        finish();
      }
    }
    catch (OutOfMemoryError paramBundle)
    {
      label474:
      label495:
      break label474;
    }
    GlobalImageCache.a.evict(0);
    try
    {
      setContentView(2131560182);
      o();
    }
    catch (Throwable paramBundle)
    {
      break label495;
    }
    AIOUtils.a("Q.readinjoy.fast_web", "setContentView Throwable. This is not a crash!!!", new IllegalArgumentException());
    finish();
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebAdapterWebFastAdapter;
    if (paramBundle != null) {
      paramBundle.a();
    }
    k();
    l();
    ((IRIJFastWebVideoPlayerManager)QRoute.api(IRIJFastWebVideoPlayerManager.class)).onCreate();
    this.jdField_a_of_type_AndroidUtilSparseArray = FastWebPTSDataConverter.a();
    A();
    i(RIJFeedsDynamicInsertConfig.a.a(5));
    return true;
  }
  
  protected void doOnDestroy()
  {
    ai();
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_b_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebAdapterWebFastAdapter;
    if (localObject != null) {
      ((WebFastAdapter)localObject).d();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebAdapterFastWebMergeAdapter;
    if (localObject != null) {
      ((FastWebMergeAdapter)localObject).a();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListAdapter;
    if (localObject != null) {
      ((ReadInJoyCommentListAdapter)localObject).d();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoySecondCommentListFragment;
    if (localObject != null) {
      ((ReadInJoySecondCommentListFragment)localObject).onDestroy();
    }
    ag();
    super.doOnDestroy();
    localObject = this.jdField_a_of_type_ComTencentBizWebviewpluginShare;
    if (localObject != null) {
      ((Share)localObject).destroy();
    }
    this.jdField_a_of_type_ComTencentBizWebviewpluginShare = null;
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebEventItemShowDispatcher;
    if (localObject != null) {
      ((ItemShowDispatcher)localObject).a();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebUtilScreenShotShareHelper;
    if (localObject != null) {
      ((ScreenShotShareHelper)localObject).a();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizShareReadInJoyShareHelperV2;
    if (localObject != null) {
      ((ReadInJoyShareHelperV2)localObject).b();
    }
    ((IRIJFastWebAdService)QRoute.api(IRIJFastWebAdService.class)).cancelDisLikeAdPopWindow();
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
    if (localObject != null)
    {
      ((IFaceDecoder)localObject).setDecodeTaskCompletionListener(null);
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebReadInJoyFastWebBottomSocialViewNew;
    if (localObject != null) {
      ((ReadInJoyFastWebBottomSocialViewNew)localObject).a();
    }
    VideoAutoPlayController.getInstance().mConfirmCanPlayInXg = false;
    localObject = ReadInJoyLogicEngine.a().a();
    if (localObject != null) {
      ((FastWebModule)localObject).unInitialize();
    }
    if (this.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler != null)
    {
      getMainLooper();
      Looper.myQueue().removeIdleHandler(this.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler);
    }
    Y();
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser;
    if (localObject != null)
    {
      ((MiniMsgUser)localObject).onBackground();
      if (!this.jdField_f_of_type_Boolean) {
        MiniMsgIPCServer.a(this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser.getParam().businessName);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebUtilFastWebShareUtils.a();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebUtilFastWebShareUtils = null;
    ReadInJoyDropFrameHelper.a().b(5555, this);
    ReadInJoyDropFrameHelper.a().b(6666, this);
    localObject = this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController;
    if (localObject != null)
    {
      ((IColorNoteController)localObject).onDestroy();
      QLog.d("FastWebActivity", 2, "mColorNoteController.onDestroy");
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFastwebEntityAuthorData;
    if (localObject != null) {
      ReadInJoyUserInfoModule.a(((AuthorData)localObject).jdField_c_of_type_JavaLangString);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizBiuRIJBiuAndCommentMixDataManager;
    if (localObject != null) {
      ((RIJBiuAndCommentMixDataManager)localObject).a();
    }
    localObject = ReadInJoyLogicEngine.a().a();
    if (localObject != null) {
      ((FollowListInfoModule)localObject).b(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFollowIFollowStatusObserver);
    }
    ((IRIJAdExposeFreshService)QRoute.api(IRIJAdExposeFreshService.class)).exitScene("RIJAdRefreshSceneNativeArticle");
    ((IRIJAdReqFreshService)QRoute.api(IRIJAdReqFreshService.class)).exitScene("RIJAdRefreshSceneNativeArticle");
    ((IRIJFastWebVideoPlayerManager)QRoute.api(IRIJFastWebVideoPlayerManager.class)).onDestroy();
    ((IRIJAdDownloadService)QRoute.api(IRIJAdDownloadService.class)).clearDownloadCache();
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianRepoCommonRIJLiveStatusModule;
    if (localObject != null) {
      ((RIJLiveStatusModule)localObject).b(this.jdField_a_of_type_ComTencentMobileqqKandianRepoCommonRIJLiveStatusModule$LiveStatusCallback);
    }
    ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    RIJ3ClickUtils.a.a();
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    boolean bool;
    if (paramIntent != null) {
      bool = paramIntent.getBooleanExtra("PhotoConst.SEND_FLAG", false);
    } else {
      bool = false;
    }
    if ((paramIntent != null) && (!bool)) {
      a(paramIntent);
    }
    super.doOnNewIntent(paramIntent);
    if ((paramIntent != null) && (bool))
    {
      paramIntent.removeExtra("PhotoConst.SEND_FLAG");
      Object localObject = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        localObject = (String)((ArrayList)localObject).get(0);
        if (this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebUtilScreenShotShareHelper == null) {
          this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebUtilScreenShotShareHelper = new ScreenShotShareHelper(this);
        }
        this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebUtilScreenShotShareHelper.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mArticleContentUrl);
        this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebUtilScreenShotShareHelper.a((String)localObject, paramIntent.getStringExtra("image_path"), paramIntent.getIntExtra("EditPicType", 0));
      }
    }
  }
  
  protected void doOnPause()
  {
    if (!this.jdField_u_of_type_Boolean) {
      super.doOnPause();
    }
    Object localObject1;
    long l1;
    if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo != null)
    {
      if (this.jdField_o_of_type_Boolean) {
        return;
      }
      AbstractGifImage.pauseAll();
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseUtilsTimeSliceHelper.b();
      Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
      if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo.a()) {
        localObject1 = "2";
      } else {
        localObject1 = "1";
      }
      localObject1 = RIJTransMergeKanDianReport.a(this, (AbsBaseArticleInfo)localObject3, 0, (String)localObject1);
      try
      {
        float f1 = (float)(System.currentTimeMillis() - this.jdField_d_of_type_Long) / 1000.0F;
        float f2 = a();
        ((JSONObject)localObject1).put("read_time", f1);
        ((JSONObject)localObject1).put("read_ratio", f2);
        ((JSONObject)localObject1).put("session_id", this.jdField_b_of_type_JavaLangString);
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("");
        ((StringBuilder)localObject3).append(ReportUtil.a(this.jdField_p_of_type_Boolean, this.jdField_b_of_type_Long));
        ((JSONObject)localObject1).put("channel_id", ((StringBuilder)localObject3).toString());
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("  time ");
        ((StringBuilder)localObject3).append(f1);
        ((StringBuilder)localObject3).append("  ratio : ");
        ((StringBuilder)localObject3).append(f2);
        ((StringBuilder)localObject3).append(" session : ");
        ((StringBuilder)localObject3).append(this.jdField_b_of_type_JavaLangString);
        QLog.d("Q.readinjoy.fast_web", 2, ((StringBuilder)localObject3).toString());
      }
      catch (Exception localException)
      {
        QLog.e("Q.readinjoy.fast_web", 2, localException, new Object[] { "doOnPause" });
      }
      ReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, "0X800898E", ((JSONObject)localObject1).toString());
      l1 = System.currentTimeMillis() - this.jdField_e_of_type_Long;
      if (this.jdField_u_of_type_Boolean) {}
    }
    for (;;)
    {
      try
      {
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("folder_status", RIJKanDianFolderStatus.reportFolderStatus);
        ((JSONObject)localObject1).put("algorithm_id", this.jdField_f_of_type_Long);
        ((JSONObject)localObject1).put("feeds_friends_interaction", 0);
        ((JSONObject)localObject1).put("session_id", this.jdField_b_of_type_JavaLangString);
        ((JSONObject)localObject1).put("os", "1");
        ((JSONObject)localObject1).put("version", "8.7.0".replace(".", ""));
        ((JSONObject)localObject1).put("rowkey", this.jdField_a_of_type_JavaLangString);
        localObject4 = ((JSONObject)localObject1).toString();
        if (!ReadinjoyReportUtils.a(this.jdField_b_of_type_Long)) {
          break label842;
        }
        localObject1 = "0X8009359";
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", (String)localObject1, (String)localObject1, 0, 0, Long.toString(l1 / 1000L), Long.toString(this.jdField_a_of_type_Long), Integer.toString(this.jdField_k_of_type_Int), (String)localObject4, false);
      }
      catch (JSONException localJSONException)
      {
        QLog.e("Q.readinjoy.fast_web", 2, localJSONException, new Object[] { "0X80066FB!" });
      }
      Object localObject2 = new ArrayList();
      Object localObject4 = new ReportInfo();
      ((ReportInfo)localObject4).mUin = ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getLongAccountUin();
      ((ReportInfo)localObject4).mSource = 0;
      ((ReportInfo)localObject4).mSourceArticleId = this.jdField_a_of_type_Long;
      ((ReportInfo)localObject4).mChannelId = ((int)this.jdField_b_of_type_Long);
      ((ReportInfo)localObject4).mAlgorithmId = ((int)this.jdField_f_of_type_Long);
      ((ReportInfo)localObject4).mStrategyId = this.jdField_k_of_type_Int;
      ((ReportInfo)localObject4).mOperation = 9;
      ((ReportInfo)localObject4).mOpSource = 12;
      ((ReportInfo)localObject4).mReadTimeLength = ((int)(l1 / 1000L));
      ((ReportInfo)localObject4).mInnerId = this.jdField_a_of_type_JavaLangString;
      int i1 = b();
      ((ReportInfo)localObject4).mArticleLength = i1;
      ((ReportInfo)localObject4).mReadArticleLength = ((int)(i1 * a()));
      ((List)localObject2).add(localObject4);
      ThreadManager.getSubThreadHandler().post(new FastWebActivity.19(this, (List)localObject2));
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebAdapterWebFastAdapter;
      if (localObject2 != null) {
        ((WebFastAdapter)localObject2).c();
      }
      if (jdField_c_of_type_Boolean) {
        this.jdField_c_of_type_Long = System.currentTimeMillis();
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser;
      if ((localObject2 != null) && (!this.jdField_e_of_type_Boolean)) {
        ((MiniMsgUser)localObject2).onBackground();
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController;
      if (localObject2 != null)
      {
        ((IColorNoteController)localObject2).onPause();
        QLog.d("FastWebActivity", 2, "mColorNoteController.onPause");
      }
      ((IRIJFastWebVideoPlayerManager)QRoute.api(IRIJFastWebVideoPlayerManager.class)).onPause();
      if ((d()) || (RIJXTabFrameUtils.INSTANCE.isNowInKanDianTab()))
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizRewardRIJRewardTaskArticleTimer.resetStationaryTime();
        this.jdField_a_of_type_ComTencentMobileqqKandianBizRewardRIJRewardTaskArticleTimer.stopTiming();
      }
      localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barCommonAdBar;
      if (localObject2 != null)
      {
        localObject2 = ((CommonAdBar)localObject2).a();
        if (localObject2 != null) {
          ((IUIDelegate)localObject2).f();
        }
      }
      if (isFinishing()) {
        as();
      }
      return;
      label842:
      localObject2 = "0X80066FB";
    }
  }
  
  protected void doOnResume()
  {
    if (!this.jdField_u_of_type_Boolean) {
      super.doOnResume();
    }
    if (!this.jdField_u_of_type_Boolean) {
      this.jdField_e_of_type_Long = System.currentTimeMillis();
    }
    TimeUtil.b("fast_web_show_light_house_3");
    f();
    AbstractGifImage.resumeAll();
    this.jdField_d_of_type_Long = System.currentTimeMillis();
    C();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebAdapterWebFastAdapter;
    if (localObject != null) {
      ((WebFastAdapter)localObject).b();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
    if (localObject != null) {
      TimeSliceHelper.b(((AbsBaseArticleInfo)localObject).innerUniqueID);
    }
    h();
    if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo != null) {
      ReadInJoyLogicEngine.a().d(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.innerUniqueID);
    }
    AppNetConnInfo.registerConnectionChangeReceiver(this, this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    if (jdField_c_of_type_Boolean)
    {
      if (jdField_b_of_type_Boolean) {
        RIJFrameworkReportManager.a(4, this.jdField_c_of_type_Long);
      }
      n();
    }
    m();
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser;
    if (localObject != null)
    {
      this.jdField_e_of_type_Boolean = false;
      this.jdField_f_of_type_Boolean = false;
      ((MiniMsgUser)localObject).onForeground();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController;
    if (localObject != null)
    {
      ((IColorNoteController)localObject).onResume();
      QLog.d("FastWebActivity", 2, "mColorNoteController.onResume");
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFastwebEntityAuthorData;
    if (localObject != null) {
      ((AuthorData)localObject).a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFollowIFollowStatusObserver);
    }
    this.jdField_z_of_type_Int = 0;
    if ((d()) || (RIJRewardTaskArticleTimer.isNowInKanDianTab()))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
      if ((localObject != null) && (!TextUtils.isEmpty(((AbsBaseArticleInfo)localObject).innerUniqueID)))
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizRewardRIJRewardTaskArticleTimer.resetStationaryTime();
        this.jdField_a_of_type_ComTencentMobileqqKandianBizRewardRIJRewardTaskArticleTimer.startTiming(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.innerUniqueID, RIJRewardTaskConfig.c());
      }
    }
    localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barCommonAdBar;
    if (localObject != null)
    {
      localObject = ((CommonAdBar)localObject).a();
      if (localObject != null) {
        ((IUIDelegate)localObject).e();
      }
    }
    ((IRIJFastWebVideoPlayerManager)QRoute.api(IRIJFastWebVideoPlayerManager.class)).onResume();
    SimpleEventBus.getInstance().dispatchEvent(new RIJFollowRecommendPopupCommand(2, null));
  }
  
  protected void doOnStart()
  {
    if (!this.jdField_u_of_type_Boolean) {
      super.doOnStart();
    }
  }
  
  protected void doOnStop()
  {
    if (!this.jdField_u_of_type_Boolean) {
      super.doOnStop();
    }
    AbsBaseArticleInfo localAbsBaseArticleInfo = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
    if (localAbsBaseArticleInfo == null) {
      return;
    }
    TimeSliceHelper.c(localAbsBaseArticleInfo.innerUniqueID);
    if (!this.jdField_x_of_type_Boolean) {
      ar();
    }
    AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
  }
  
  protected void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if (paramBoolean) {
      j();
    }
  }
  
  public void e()
  {
    ItemDatasListUtils.b(this.jdField_a_of_type_JavaUtilList);
    C();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView.removeFooter();
  }
  
  public void f()
  {
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      super.getWindow().addFlags(67108864);
      ImmersiveUtils.clearCoverForStatus(getWindow(), this.isClearCoverLayer);
      if (this.mSystemBarComp == null) {
        this.mSystemBarComp = new SystemBarCompact(this, true, -1);
      }
      this.mSystemBarComp.init();
      if (ThemeUtil.isInNightMode(this.app))
      {
        if ((!SystemUtil.b()) && (!SystemUtil.d()))
        {
          this.mSystemBarComp.setStatusBarColor(-7829368);
          return;
        }
        this.mSystemBarComp.setStatusBarColor(-7829368);
        this.mSystemBarComp.setStatusBarDarkMode(true);
        return;
      }
      if ((Build.VERSION.SDK_INT >= 23) && (!SystemUtil.b()) && (!SystemUtil.d()))
      {
        a(true);
        this.mSystemBarComp.setStatusBarColor(-1);
        return;
      }
      if (!SystemUtil.d())
      {
        this.mSystemBarComp.setStatusBarColor(-2368549);
        return;
      }
      this.mSystemBarComp.setStatusBarColor(-1);
      this.mSystemBarComp.setStatusBarDarkMode(true);
    }
  }
  
  public void finish()
  {
    QLog.d("FastWebActivity", 2, "mFloating ：finish");
    if ((this.jdField_x_of_type_Boolean) && (!this.jdField_y_of_type_Boolean))
    {
      aa();
      return;
    }
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebUtilFastWebActivityStackUtil.a())
    {
      if (this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController == null) {
        f(this);
      }
      if ((this.B) && (this.jdField_z_of_type_Boolean) && (this.D))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaCommonSuspensionGestureLayout;
        if ((localObject != null) && (!((CommonSuspensionGestureLayout)localObject).a()) && (!this.jdField_y_of_type_Boolean))
        {
          ab();
          return;
        }
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController != null) && (!this.jdField_y_of_type_Boolean))
      {
        aa();
        return;
      }
      if (this.jdField_l_of_type_Int == 1001)
      {
        int i1 = this.jdField_e_of_type_Int;
        if (i1 == 70) {
          ((IKandianSubscribeManager)this.app.getRuntimeService(IKandianSubscribeManager.class)).lanuchKandianSubscribeActivity(this, 2);
        } else if (i1 == 0) {
          ((IReadInJoyActivityHelper)QRoute.api(IReadInJoyActivityHelper.class)).launchFeedsActivity(this, 11, 0);
        } else if (DailyModeConfigHandler.c(i1)) {
          ((IKandianDailyManager)QRoute.api(IKandianDailyManager.class)).launchKandianDaily(this);
        } else if (RIJShowKanDianTabSp.c()) {
          ((IReadInJoyActivityHelper)QRoute.api(IReadInJoyActivityHelper.class)).launchReadInJoyTab(this, 11);
        }
      }
      if (this.jdField_g_of_type_Long != 0L) {
        ReportUtil.a(NetConnInfoCenter.getServerTime() - this.jdField_g_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo, getApplicationContext());
      }
    }
    this.jdField_n_of_type_Boolean = true;
    af();
    aj();
    ac();
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_b_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
    IPublicAccountReportUtils localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
    if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo == null)
    {
      localObject = "";
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSubscribeID);
      ((StringBuilder)localObject).append("");
      localObject = ((StringBuilder)localObject).toString();
    }
    String str;
    if (this.jdField_r_of_type_Boolean) {
      str = "1";
    } else {
      str = "2";
    }
    localIPublicAccountReportUtils.publicAccountReportClickEventForMigrate(null, "CliOper", "", (String)localObject, "0X8008995", "0X8008995", 0, 0, str, null, null, null, false);
    ap();
    QLog.d("FastWebActivity", 2, "mFloating ：finish over");
  }
  
  public void g()
  {
    BubblePopupWindow localBubblePopupWindow = this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
    if ((localBubblePopupWindow != null) && (localBubblePopupWindow.isShowing())) {
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.dismiss();
    }
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 10922)
    {
      b(paramInt2, paramIntent);
      return;
    }
    if (paramInt1 == 10923)
    {
      am();
      return;
    }
    if ((paramInt1 == 117) && (paramIntent != null) && (paramInt2 == -1))
    {
      a(paramInt1, paramInt2, paramIntent);
      return;
    }
    if ((paramInt1 == 1001) && (paramIntent != null))
    {
      c(paramIntent);
      return;
    }
    if (paramInt1 == 2002)
    {
      g(paramInt2);
      return;
    }
    if (paramInt1 == 1)
    {
      f(paramInt2);
      return;
    }
    if (paramInt1 == 9999)
    {
      a(paramInt2, paramIntent);
      return;
    }
    if ((paramInt1 == 117) && (paramIntent != null) && (paramInt2 == 1699)) {
      b(paramIntent);
    }
  }
  
  protected boolean onBackEvent()
  {
    if (this.jdField_h_of_type_Boolean)
    {
      RIJTransMergeKanDianReport.a(1, 1, 5);
      a(false, null, null);
      g();
      return true;
    }
    return false;
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() != 2131369202) && (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo == null)) {
      return;
    }
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131376561: 
      a(true, false);
      return;
    case 2131370707: 
      paramView = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoySecondCommentListFragment;
      if (paramView != null) {
        RIJTransMergeKanDianReport.a(1, paramView.a(), 4);
      }
      a(false, null, null);
      return;
    case 2131369249: 
      if (!this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView.isStackFromBottom()) {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView.setStackFromBottom(true);
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView.setStackFromBottom(false);
      return;
    case 2131369202: 
      this.jdField_r_of_type_Boolean = true;
      ((IRIJFastWebVideoPlayerManager)QRoute.api(IRIJFastWebVideoPlayerManager.class)).setVideoPauseType(ReportConstants.VideoEndType.EXIT_SCENE);
      finish();
      return;
    case 2131367060: 
      a(paramView.getTag());
      return;
    }
    paramView = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
    if (paramView != null) {
      FastWebPTSUtils.a(this, paramView, paramView.getSubscribeUin(), this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo, 1);
    }
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView != null)
    {
      paramInt1 = 0;
      while (paramInt1 < this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView.getChildCount())
      {
        BaseItemViewHolder localBaseItemViewHolder = (BaseItemViewHolder)this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView.getChildAt(paramInt1).getTag();
        if (localBaseItemViewHolder != null) {
          localBaseItemViewHolder.a(paramString, paramBitmap);
        }
        paramInt1 += 1;
      }
    }
  }
  
  public void onFromMiniAIOToAIO() {}
  
  public void onGoToConversation()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FastWebActivity", 2, "onGoToConversation..");
    }
    this.jdField_f_of_type_Boolean = true;
    ThreadManager.getUIHandler().post(new FastWebActivity.37(this));
  }
  
  public void onOpenMiniAIOCallback()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FastWebActivity", 2, "onOpenMiniAIOCallback..");
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser;
    if ((localObject1 != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo != null)) {}
    for (;;)
    {
      try
      {
        this.jdField_e_of_type_Boolean = true;
        localObject1 = ((MiniMsgUser)localObject1).getParam();
        ((MiniMsgUserParam)localObject1).backConversationIntent = RIJWebSearchUtils.a(this, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, this.jdField_d_of_type_Int, this.jdField_p_of_type_Boolean);
        ((MiniMsgUserParam)localObject1).isNeedBackConversation = true;
        AbsBaseArticleInfo localAbsBaseArticleInfo1 = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
        AbsBaseArticleInfo localAbsBaseArticleInfo2 = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
        int i1 = (int)this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mChannelID;
        boolean bool = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo.a();
        localObject2 = "2";
        if (bool) {
          localObject1 = "2";
        } else {
          localObject1 = "1";
        }
        ReportUtil.a(localAbsBaseArticleInfo1, "0X800A09C", RIJTransMergeKanDianReport.a(this, localAbsBaseArticleInfo2, i1, (String)localObject1).toString());
        localAbsBaseArticleInfo1 = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
        localAbsBaseArticleInfo2 = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
        i1 = (int)this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mChannelID;
        if (!this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo.a()) {
          break label252;
        }
        localObject1 = localObject2;
        ReportUtil.a(localAbsBaseArticleInfo1, "0X800A09D", RIJTransMergeKanDianReport.a(this, localAbsBaseArticleInfo2, i1, (String)localObject1).toString());
        return;
      }
      catch (Exception localException)
      {
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("onOpenMiniAIOCallback Exception = ");
        ((StringBuilder)localObject2).append(localException);
        QLog.e("FastWebActivity", 2, ((StringBuilder)localObject2).toString());
        return;
      }
      QLog.e("FastWebActivity", 2, "onOpenMiniAIOCallback mMiniMsgUser == null || mArticleInfo == null || mFastWebInfo == null");
      return;
      label252:
      String str = "1";
    }
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    b(paramBundle);
    QLog.e("FastWebActivity", 2, "onSaveInstanceState(Bundle outState)");
    super.onSaveInstanceState(paramBundle);
  }
  
  public void onSaveInstanceState(Bundle paramBundle, PersistableBundle paramPersistableBundle)
  {
    b(paramBundle);
    QLog.e("FastWebActivity", 2, "onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState)");
    super.onSaveInstanceState(paramBundle, paramPersistableBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.FastWebActivity
 * JD-Core Version:    0.7.0.1
 */