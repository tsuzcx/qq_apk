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
import com.tencent.mobileqq.kandian.base.utils.RIJLogUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.base.utils.TimeSliceHelper;
import com.tencent.mobileqq.kandian.base.utils.TimeUtil;
import com.tencent.mobileqq.kandian.biz.ad.RIJCommentAdUtils;
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
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.daily.api.impl.KandianDailyManagerSingleton;
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
import com.tencent.mobileqq.kandian.biz.framework.api.impl.ReadInJoyActivityHelper;
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
import com.tencent.mobileqq.kandian.biz.xtab.api.impl.RIJXTabFrameUtils;
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
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.impl.BaseDataUtil;
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
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
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
  private boolean A = true;
  private ReadInJoyFastWebBottomSocialViewNew B;
  private CommonAdBar C;
  private TextView D;
  private FastWebMergeAdapter E;
  private ReadInJoyCommentListAdapter F;
  private WebFastAdapter G;
  private ReadInJoySecondCommentListFragment H;
  private boolean I = false;
  private boolean J = false;
  private FastWebShareUtils K = new FastWebShareUtils();
  private FastWebActivityStackUtil L = new FastWebActivityStackUtil(this);
  private ReadInJoyShareHelperV2 M;
  private ScreenShotShareHelper N;
  private int O = 1;
  private BubblePopupWindow P;
  private int Q = 0;
  private int R = -1;
  private boolean S = false;
  private boolean T = false;
  private boolean U = false;
  private SparseArray<View> V = new SparseArray(1);
  private float W = DeviceInfoUtil.J() * 500 / 160.0F;
  private float X = DeviceInfoUtil.J() * 1000 / 160.0F;
  private float Y = 1.5F;
  private DecelerateInterpolator Z = new DecelerateInterpolator(this.Y);
  private int aA = 0;
  private int aB;
  private String aC;
  private boolean aD;
  private long aE;
  private int aF;
  private long aG;
  private int aH;
  private int aI;
  private Share aJ;
  private int aK;
  private int aL;
  private int aM;
  private int aN;
  private int aO;
  private int aP;
  private int aQ;
  private boolean aR;
  private AnchorData aS;
  private TimeSliceHelper aT;
  private int aU;
  private MessageQueue.IdleHandler aV;
  private FastWebActivity.RecommendAndAdCallback aW;
  private RelativeLayout aX;
  private ImageView aY;
  private TextView aZ;
  private IScrollReader aa;
  private FastWebActivityStackUtil.SaveState ab;
  private int ac;
  private int ad;
  private FastWebArticleInfo ae;
  private TitleData af;
  private AuthorData ag;
  private boolean ah = false;
  private boolean ai = false;
  private CopyOnWriteArrayList<BaseData> aj = new CopyOnWriteArrayList();
  private boolean ak = false;
  private ItemShowDispatcher al = new ItemShowDispatcher();
  private HashMap<String, ArrayList<String>> am = new HashMap();
  private IFaceDecoder an;
  private boolean ao = false;
  private FastWebAdapterShowHelper ap;
  private ItemHeightHelper aq;
  private boolean ar = false;
  private AtomicBoolean as = new AtomicBoolean(false);
  private boolean at = false;
  private boolean au = false;
  private boolean av = false;
  private int aw = 0;
  private long ax;
  private int ay = 0;
  private int az = 0;
  private TKDTuWenHippyCommentAdapter bA;
  private VafContext bB;
  private boolean bC;
  private RIJLiveStatusModule.LiveStatusCallback bD;
  private IReadInJoyUserInfoModule.RefreshUserInfoCallBack bE;
  private ReadInJoyObserver bF;
  private ReadInJoyObserver bG;
  private XListView.DrawFinishedListener bH;
  private FastWebModule.FastWebContentGetCallback bI;
  private FastWebActivity.ArticleRichInfoCallback bJ;
  private MessageQueue.IdleHandler bK;
  private int ba;
  private IColorNoteController bb;
  private boolean bc;
  private boolean bd;
  private boolean be;
  private long bf;
  private boolean bg;
  private boolean bh;
  private CommonSuspensionGestureLayout bi;
  private boolean bj;
  private boolean bk;
  private boolean bl;
  private int bm;
  private int bn;
  private View bo;
  private RIJBiuAndCommentMixDataManager bp;
  private boolean bq;
  private String br;
  private int bs;
  private String bt;
  private int bu;
  private RIJRewardTaskArticleTimer bv;
  private NativeAvatarView bw;
  private TextView bx;
  private ImageView by;
  private RIJLiveStatusModule bz;
  public View d;
  public View e;
  boolean f = true;
  public AbsBaseArticleInfo g;
  protected long h;
  protected String i;
  protected long j;
  public MiniMsgUser k;
  public boolean l;
  public boolean m;
  SparseArray<Float> n;
  Set<BaseData> o;
  long p;
  AbsListView.OnScrollListener q;
  public INetInfoHandler r;
  FastWebMergeAdapter.OnDataSetChangeListener s;
  IFollowStatusObserver t;
  Runnable u;
  private ReadInJoyCommentListView v;
  private TextView w;
  private View x;
  private View y;
  private TextView z;
  
  public FastWebActivity()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(System.currentTimeMillis());
    localStringBuilder.append("");
    this.aC = localStringBuilder.toString();
    this.aD = false;
    this.aE = 0L;
    this.aH = 1000;
    this.aI = 2;
    this.aK = 0;
    this.aL = 0;
    this.aM = 0;
    this.aN = 0;
    this.aO = 0;
    this.aP = 0;
    this.aQ = 0;
    this.aR = true;
    this.aT = new TimeSliceHelper();
    this.aU = 1;
    this.bc = false;
    this.bd = false;
    this.be = false;
    this.bf = 0L;
    this.bg = true;
    this.bh = false;
    this.bj = false;
    this.bk = true;
    this.bl = true;
    this.bm = 0;
    this.bn = -1;
    this.o = new HashSet();
    this.bq = false;
    this.br = "";
    this.bs = 0;
    this.bt = "";
    this.bu = 0;
    this.bv = new RIJRewardTaskArticleTimer();
    this.bD = new FastWebActivity.9(this);
    this.bE = new FastWebActivity.10(this);
    this.q = new FastWebActivity.23(this);
    this.bF = new FastWebActivity.24(this);
    this.bG = new FastWebActivity.25(this);
    this.bH = new FastWebActivity.29(this);
    this.bI = new FastWebActivity.33(this);
    this.bJ = new FastWebActivity.ArticleRichInfoCallback(this, null);
    this.r = new FastWebActivity.35(this);
    this.bK = new FastWebActivity.36(this);
    this.s = new FastWebActivity.38(this);
    this.t = new FastWebActivity.40(this);
    this.u = new FastWebActivity.41(this);
  }
  
  private void A()
  {
    this.ba = 0;
    Iterator localIterator = this.aj.iterator();
    while (localIterator.hasNext())
    {
      BaseData localBaseData = (BaseData)localIterator.next();
      if ((localBaseData != null) && ((localBaseData instanceof ProteusItemData)))
      {
        ProteusItemData localProteusItemData = (ProteusItemData)localBaseData;
        if ((localProteusItemData.bf == 1) && ((localProteusItemData.be == 1) || (localProteusItemData.be == 2)) && (localBaseData.aP != 0)) {
          this.ba += 1;
        }
      }
    }
  }
  
  private void B()
  {
    this.aa = new FastWebActivity.8(this);
    VideoReport.markAsPageBodyView(this.v, this.aa);
    VideoReport.setPageBodyContentRange(this.v, 0, this.aj.size());
  }
  
  private void C()
  {
    Object localObject = this.ag;
    if (localObject != null)
    {
      ((AuthorData)localObject).a("https://pub.idqqimg.com/pc/misc/files/20200611/2a67e74aa4ed4a71a8e877deac8e41cf.png");
      this.ag.b("https://pub.idqqimg.com/pc/misc/files/20200611/558a344321d34d25b847cf32ff9403f8.png");
      AbsBaseArticleInfo localAbsBaseArticleInfo = this.g;
      if (localAbsBaseArticleInfo != null)
      {
        int i1 = (int)localAbsBaseArticleInfo.mChannelID;
        localObject = this.ae;
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
        ReportUtil.a(this.g, "0X800B17D", ((JSONObject)localObject).toString());
      }
    }
    F();
  }
  
  private void D()
  {
    if (this.bz == null)
    {
      this.bz = ReadInJoyLogicEngine.a().s();
      RIJLiveStatusModule localRIJLiveStatusModule = this.bz;
      if (localRIJLiveStatusModule != null) {
        localRIJLiveStatusModule.a(this.bD);
      }
    }
  }
  
  private void E()
  {
    if (this.g != null)
    {
      Object localObject = this.ae;
      if (localObject != null)
      {
        if (!TextUtils.isEmpty(((FastWebArticleInfo)localObject).x)) {
          this.g.mArticleID = Long.parseLong(this.ae.x);
        }
        if (!TextUtils.isEmpty(this.ae.j)) {
          this.g.mTitle = this.ae.j;
        }
        if (!TextUtils.isEmpty(this.ae.E)) {
          this.g.mFirstPagePicUrl = this.ae.E;
        }
        if (!TextUtils.isEmpty(this.ae.l)) {
          this.g.mSubscribeName = this.ae.l;
        }
        if ((this.ae.y != 0L) && (TextUtils.isEmpty(this.g.mSubscribeID))) {
          this.g.mSubscribeID = String.valueOf(this.ae.y);
        }
        if (!TextUtils.isEmpty(this.ae.G))
        {
          this.ae.L = this.g.mArticleContentUrl;
          this.g.mArticleContentUrl = this.ae.G;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("initArticleInfo, update url,url=");
          ((StringBuilder)localObject).append(this.g.mArticleContentUrl);
          QLog.d("FastWebActivity", 1, ((StringBuilder)localObject).toString());
        }
        return;
      }
    }
    QLog.d("FastWebActivity", 1, "initArticleInfo error!");
  }
  
  private void F()
  {
    if (this.E == null) {
      return;
    }
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      this.E.notifyDataSetChanged();
      return;
    }
    runOnUiThread(new FastWebActivity.11(this));
  }
  
  private void G()
  {
    this.aS = ((AnchorData)getIntent().getExtras().get("intent_key_anchor_data"));
    if (!a(1)) {
      b(1);
    }
  }
  
  private void H()
  {
    TKDTuWenHippyCommentAdapter localTKDTuWenHippyCommentAdapter = this.bA;
    if (localTKDTuWenHippyCommentAdapter != null) {
      localTKDTuWenHippyCommentAdapter.destroy();
    }
  }
  
  private boolean I()
  {
    int i1 = this.aH;
    boolean bool = true;
    if ((i1 != 1001) && (this.ab == null)) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 == 0)
    {
      if (!this.bC) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  private void J()
  {
    Object localObject = new Bundle();
    boolean bool;
    if (this.bA != null) {
      bool = true;
    } else {
      bool = false;
    }
    ((Bundle)localObject).putBoolean("arg_main_comment_use_hippy", bool);
    ((Bundle)localObject).putBoolean("arg_comment_list_biu_btn", false);
    this.H = new ReadInJoySecondCommentListFragment();
    this.H.a(1);
    this.H.a(this, (Bundle)localObject, new FastWebActivity.13(this));
    this.H.a(new FastWebActivity.14(this));
    localObject = getSupportFragmentManager().beginTransaction();
    ((FragmentTransaction)localObject).add(2131445466, this.H);
    ((FragmentTransaction)localObject).hide(this.H);
    ((FragmentTransaction)localObject).commitAllowingStateLoss();
  }
  
  private void K()
  {
    FastWebModule localFastWebModule = ReadInJoyLogicEngine.a().d();
    if (localFastWebModule == null)
    {
      if (!this.ai) {
        L();
      }
      QLog.d("FastWebActivity", 2, "fastWebModule == null");
      return;
    }
    localFastWebModule.a(this.g.mArticleContentUrl, String.valueOf(this.g.innerUniqueID), this.g.mSubscribeID, 1, this.bI);
  }
  
  private void L()
  {
    E();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("openWeb  mArticleInfo: ");
    localStringBuilder.append(this.g);
    QLog.d("FastWebActivity", 1, localStringBuilder.toString());
    this.ak = true;
    ReadInJoyLogicEngineEventDispatcher.a().a(this.bG);
    ReadInJoyLogicEngineEventDispatcher.a().a(this.bF);
    getMainLooper();
    Looper.myQueue().addIdleHandler(new FastWebActivity.15(this));
    PublicAccountReportUtils.a(null, "CliOper", "", "", "0X8009C50", "0X8009C50", 0, 0, "", Long.toString(this.h), Integer.toString(this.aF), "", false);
  }
  
  private void M()
  {
    if (this.aV != null)
    {
      getMainLooper();
      Looper.myQueue().removeIdleHandler(this.aV);
    }
    this.aV = new FastWebActivity.16(this);
    getMainLooper();
    Looper.myQueue().addIdleHandler(this.aV);
  }
  
  private void N()
  {
    View localView = findViewById(2131441404);
    this.v.setEmptyView(localView);
    localView.setOnClickListener(null);
  }
  
  private void O()
  {
    ((ClipboardManager)getSystemService("clipboard")).setText(this.g.mArticleContentUrl);
    QRUtils.a(2, 2131888247);
    String str;
    if (this.au) {
      str = "0X8008994";
    } else {
      str = "0X800898D";
    }
    FastWebShareUtils.a(this, str, 9, this.g);
    ReportUtil.a(this, getAppInterface(), this.g, -1, 3, false);
  }
  
  private void P()
  {
    this.M.a(this.g.mArticleContentUrl);
    ReportUtil.a(this, getAppInterface(), this.g, 6, -1, false);
  }
  
  private void Q()
  {
    this.M.b(this.g.mArticleContentUrl);
    ReportUtil.a(this, getAppInterface(), this.g, 7, -1, false);
  }
  
  private void R()
  {
    a(17, -1, false);
    ReportUtil.a(this, getAppInterface(), this.g, 0, -1, false);
  }
  
  private void S()
  {
    ThreadManager.executeOnSubThread(new FastWebActivity.18(this));
    String str;
    if (this.au) {
      str = "0X8008994";
    } else {
      str = "0X800898D";
    }
    FastWebShareUtils.a(this, str, 10, this.g);
    ReportUtil.a(this, getAppInterface(), this.g, -1, 5, false);
  }
  
  private void T()
  {
    this.M.e();
    String str;
    if (this.au) {
      str = "0X8008994";
    } else {
      str = "0X800898D";
    }
    FastWebShareUtils.a(this, str, 7, this.g);
    ReportUtil.a(this, getAppInterface(), this.g, -1, 0, false);
  }
  
  private void U()
  {
    this.M.a(this, true);
    ReportUtil.a(this, getAppInterface(), this.g, -1, 1, false, false, RIJJsonUtils.a(null, "function_type", Integer.valueOf(7)));
  }
  
  private void V()
  {
    this.M.d(this.g.mArticleContentUrl);
    ReportUtil.a(this, getAppInterface(), this.g, -1, 2, false);
  }
  
  private void W()
  {
    TeamWorkConvertUtils.a(1, 2);
    TeamWorkConvertUtils.a(this.g.mArticleContentUrl, this.g.mTitle);
  }
  
  private void X()
  {
    IColorNoteController localIColorNoteController = this.bb;
    if (localIColorNoteController != null) {
      if (localIColorNoteController.canAddColorNote())
      {
        QLog.d("FastWebActivity", 2, "mColorNoteController ：add colorNote");
        this.bb.insertColorNote();
        if (!this.L.b()) {
          QQToast.makeText(BaseApplicationImpl.getContext(), 2, BaseApplicationImpl.getContext().getResources().getString(2131887831), 5000).show();
        }
      }
      else
      {
        this.bb.onCannotAdd();
      }
    }
  }
  
  private void Y()
  {
    IColorNoteController localIColorNoteController = this.bb;
    if ((localIColorNoteController != null) && (localIColorNoteController.isColorNoteExist()))
    {
      QQToast.makeText(BaseApplicationImpl.getContext(), 2, BaseApplicationImpl.getContext().getResources().getString(2131887835), 5000).show();
      this.bb.deleteColorNote();
      QLog.d("FastWebActivity", 2, "mColorNoteController ： delete colorNote");
    }
  }
  
  private void Z()
  {
    this.bw = ((NativeAvatarView)findViewById(2131428906));
    this.bx = ((TextView)findViewById(2131428907));
    this.by = ((ImageView)findViewById(2131433513));
    this.bw.setOnClickListener(this);
    this.bx.setOnClickListener(this);
    this.by.setOnClickListener(this);
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    ItemHeightHelper localItemHeightHelper = this.aq;
    int i1 = 0;
    if (localItemHeightHelper == null)
    {
      QLog.e("Q.readinjoy.fast_web", 2, "getRatio itemsHeight == null ");
      return 0;
    }
    int i2 = 0;
    while ((i1 < this.aq.a()) && (i1 <= paramInt1))
    {
      i2 += this.aq.a(i1);
      i1 += 1;
    }
    return i2 - paramInt2;
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
  
  private void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.bA == null)
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
      if (((paramIntent instanceof AdData)) && (this.aj != null))
      {
        paramIntent = ((AdData)paramIntent).D;
        if (!TextUtils.isEmpty(paramIntent))
        {
          Iterator localIterator = this.aj.iterator();
          while (localIterator.hasNext())
          {
            BaseData localBaseData = (BaseData)localIterator.next();
            if (((localBaseData instanceof AdData)) && (paramIntent.equals(((AdData)localBaseData).D)))
            {
              a(localBaseData);
              QQToast.makeText(this, -1, getString(2131897939), 0).show(getTitleBarHeight());
            }
          }
        }
      }
    }
  }
  
  private void a(int paramInt, AuthorData paramAuthorData)
  {
    if (FastWebPTSUtils.a(paramInt, this.aj)) {
      paramInt = 0;
    } else {
      paramInt = 4;
    }
    this.bx.setVisibility(paramInt);
    this.bw.setVisibility(paramInt);
    b(paramInt, paramAuthorData);
  }
  
  private void a(long paramLong)
  {
    try
    {
      QLog.d("FastWebActivity", 1, "start to fetch live status");
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(Long.valueOf(paramLong));
      if (this.bz == null) {
        D();
      }
      if (this.bz != null)
      {
        this.bz.a(localArrayList);
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
  
  private void a(FastWebActivityStackUtil.SaveState paramSaveState)
  {
    aB();
    this.g = paramSaveState.a;
    this.ab = paramSaveState;
    this.al = this.ab.d;
    this.ao = paramSaveState.e;
    this.ap = paramSaveState.f;
    paramSaveState = this.as;
    if (paramSaveState != null) {
      paramSaveState.set(false);
    }
    x();
  }
  
  private void a(AuthorData paramAuthorData)
  {
    if (paramAuthorData == null) {
      return;
    }
    this.bw.setUin(Long.parseLong(paramAuthorData.c));
    this.bx.setText(paramAuthorData.b);
    e(paramAuthorData.j);
  }
  
  private void a(AuthorData paramAuthorData, FastWebArticleInfo paramFastWebArticleInfo)
  {
    if (paramAuthorData != null)
    {
      if (paramFastWebArticleInfo == null) {
        return;
      }
      paramAuthorData.c(paramFastWebArticleInfo.D);
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
      paramTitleData.c(paramFastWebArticleInfo.D);
    }
  }
  
  private void a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(" url: ");
    ((StringBuilder)localObject1).append(paramAbsBaseArticleInfo.mArticleContentUrl);
    QLog.d("FastWebActivity", 1, ((StringBuilder)localObject1).toString());
    localObject1 = this.bi;
    if ((localObject1 != null) && (this.bj)) {
      ((CommonSuspensionGestureLayout)localObject1).c();
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
        localObject1 = ((TopicRecommendFeedsInfo.TopicRecommendInfo)paramAbsBaseArticleInfo.mSocialFeedInfo.v.g.get(0)).c;
      }
    }
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      az();
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
    localBundle.putParcelable("fastwebinfo", this.ae);
    localBundle.putParcelable("articleinfo", this.g);
    localBundle.putInt("articalChannelId", 9);
    paramAbsBaseArticleInfo = this.ae;
    if (paramAbsBaseArticleInfo != null) {
      i1 = paramAbsBaseArticleInfo.H;
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
        ((JSONObject)localObject).put("comment", paramFastWebArticleInfo.d);
        if (!this.bc) {
          break label124;
        }
        i1 = 1;
        ((JSONObject)localObject).put("click_src", i1);
        if ((this.bj) && (this.bn != -1)) {
          ((JSONObject)localObject).put("source_extratype", this.bn);
        }
      }
      catch (JSONException paramFastWebArticleInfo)
      {
        paramFastWebArticleInfo.printStackTrace();
      }
      ReportUtil.a(paramAbsBaseArticleInfo, "0X8008989", ((JSONObject)localObject).toString());
      c();
      return;
      label124:
      i1 = 0;
    }
  }
  
  private void a(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    this.br = paramActionSheetItem.uin;
    this.bs = paramActionSheetItem.uinType;
    this.bt = paramActionSheetItem.label;
  }
  
  private void a(AbsListView paramAbsListView, int paramInt, boolean paramBoolean)
  {
    if (!((IRIJFastWebAdService)QRoute.api(IRIJFastWebAdService.class)).isAutomaticGlide()) {
      return;
    }
    this.R = paramInt;
    if (((!this.T) && (!paramBoolean)) || ((this.S) && (!paramBoolean)) || (this.U)) {
      return;
    }
    float f1 = paramAbsListView.getFlingVelocityY();
    if ((!paramBoolean) && ((f1 < this.W) || (f1 > this.X))) {
      return;
    }
    if ((this.R <= paramInt) && (paramInt < paramAbsListView.getCount() - 1))
    {
      this.R = paramInt;
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
      localObject2 = (View)this.V.get(i1);
      if (localObject2 == null)
      {
        localObject1 = ((ListAdapter)localObject1).getView(paramInt, null, paramAbsListView);
        this.V.put(i1, localObject1);
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
          this.U = true;
          return;
        }
        if (((i1 > i2) && (i1 < paramInt / 2 + i2)) || ((paramBoolean) && (i2 > paramInt / 2)))
        {
          this.S = true;
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
        this.U = true;
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
    e(true);
    paramObject = this.F;
    if (paramObject != null) {
      paramObject.notifyDataSetChanged();
    }
    paramObject = this.ag;
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
    if (this.as.compareAndSet(false, true))
    {
      ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("REPORT_LINK", "requestAdData onGetRecommendsResult removeInnerAd");
      ((IRIJFastWebAdService)QRoute.api(IRIJFastWebAdService.class)).removeInnerAd(this.aj);
    }
    if (paramBoolean1)
    {
      Object localObject = this.ae;
      if ((localObject != null) && (((FastWebArticleInfo)localObject).x.equals(paramString)))
      {
        paramString = new ArrayList();
        localObject = new ArrayList();
        Iterator localIterator = paramList2.iterator();
        while (localIterator.hasNext())
        {
          BaseData localBaseData = (BaseData)localIterator.next();
          if (localBaseData.aS) {
            paramString.add(localBaseData);
          }
          do
          {
            break;
            if (!((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).instanceOfRecommendAdData(localBaseData)) {
              break label250;
            }
            if (paramInt == 0) {
              ((List)localObject).add(localBaseData);
            }
          } while ((paramInt != 1) || (!paramBoolean2));
          ((IRIJFastWebAdService)QRoute.api(IRIJFastWebAdService.class)).addHotRecommend(paramList1, (List)localObject, localBaseData);
          ((IRIJFastWebAdService)QRoute.api(IRIJFastWebAdService.class)).resetRecommendAdData(localBaseData, paramInt);
          continue;
          label250:
          ((List)localObject).add(localBaseData);
        }
        ItemDatasListUtils.a(this.aj, paramList1, paramString, this.g, this.ae, true, this.n, this.al, paramInt, paramBoolean2);
        ItemDatasListUtils.a(this.aj, paramList1, (List)localObject, this.g, this.ae, false, this.n, this.al, paramInt, paramBoolean2);
        paramString = ReadInJoyLogicEngine.a().d();
        if (paramString != null) {
          paramString.a(this.ae.q, this.aj);
        }
        an();
        ItemDatasListUtils.a(this.aj);
        F();
        ((IRIJFastWebAdService)QRoute.api(IRIJFastWebAdService.class)).setCommonBarData(this, this.C, paramList2);
        paramString = new StringBuilder();
        paramString.append("adback initCommentAreaAnchor mCommentAreaLastFirstVisItemPos = ");
        paramString.append(this.aP);
        QLog.d("FastWebActivity", 1, paramString.toString());
        e();
        if (paramInt == 0) {
          this.al.a(this.v, 0);
        }
      }
    }
  }
  
  private boolean a(int paramInt)
  {
    if ((TKDTuWenCommentUtil.isCommentSwitchOn()) && (this.g != null))
    {
      H();
      this.bA = new TKDTuWenHippyCommentAdapter.Builder(this).articleInfo(this.g).anchorData(this.aS).contentSrc(paramInt).listView(this.v).build();
      this.E.a(this.bA);
      this.bA.setHippyCommentPageListener(new FastWebActivity.MyHippyCommentPageListener(this, paramInt));
      this.bA.setHippyScrollListener(new FastWebActivity.HippyScrollListener(this, null));
      this.bA.init();
      return true;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mArticleInfo is null? ");
    boolean bool;
    if (this.g == null) {
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
  
  private void aA()
  {
    if (this.L.b()) {
      return;
    }
    this.aD = true;
    doOnPause();
    doOnStop();
    aq();
    VideoReport.pageLogicDestroy(this);
    this.aD = false;
    FastWebActivityStackUtil.SaveState localSaveState = this.L.a();
    if (localSaveState != null)
    {
      a(localSaveState);
      this.aD = true;
      doOnStart();
      doOnResume();
      j();
      this.aD = false;
    }
  }
  
  private void aB()
  {
    this.ab = null;
    this.g = null;
    this.ae = null;
    this.af = null;
    this.ag = null;
    this.ah = false;
    this.aq = null;
    this.ai = false;
    this.aj.clear();
    this.ak = false;
    this.al = null;
    this.at = false;
    this.au = false;
    this.av = false;
    this.ax = 0L;
    this.ay = 0;
    this.az = 0;
    this.ao = false;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(System.currentTimeMillis());
    ((StringBuilder)localObject).append("");
    this.aC = ((StringBuilder)localObject).toString();
    this.v.setDrawFinishedListener(null);
    this.v.removeScrollListener(this.q);
    localObject = ReadInJoyLogicEngine.a().d();
    if (localObject != null)
    {
      ((FastWebModule)localObject).a(this.bJ);
      ((FastWebModule)localObject).a(this.bI);
    }
    this.aB = 0;
  }
  
  private void aC()
  {
    if ((isFinishing()) || (this.aD))
    {
      QLog.d("FastWebActivity", 1, "fastwebActivity doOnStop | removeCommentDataManager");
      ReadInJoyCommentDataManager.b(this.g);
    }
  }
  
  private void aD()
  {
    int i1 = ae();
    if ((this.g != null) && (i1 != 0)) {
      RIJFeedsDynamicInsertController.INSTANCE.requestInsertArticlesAndRecordAction(this.g.innerUniqueID, new RIJFeedsInsertAction(ActionType.ACTION_ARTICLE_READ_PROGRESS, ad() * 100 / i1, 0, (int)TimeSliceHelper.f(this.g.innerUniqueID) / 1000), 5);
    }
  }
  
  private void aE()
  {
    RIJFeedsType.a(this.g.innerUniqueID);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("preGotoConversation mActivityStack size = ");
      localStringBuilder.append(this.L.b());
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
    this.L.a(new FastWebActivity.32(this));
  }
  
  private void aF()
  {
    F();
  }
  
  private void aG()
  {
    Object localObject = getIntent();
    if (localObject == null) {
      return;
    }
    localObject = ((Intent)localObject).getExtras();
    if (localObject == null) {
      return;
    }
    this.bj = ((Bundle)localObject).getBoolean("launch_from_floating_window", false);
    if (this.bj)
    {
      this.bk = ((Bundle)localObject).getBoolean("scroll_to_top", true);
      this.bl = ((Bundle)localObject).getBoolean("up_animation", true);
      this.bn = ((Bundle)localObject).getInt("floating_window_scene", -1);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("mFloating initFloatingWindow,isFromFloatingLayer=");
    ((StringBuilder)localObject).append(this.bj);
    ((StringBuilder)localObject).append("  isSuctionTop=");
    ((StringBuilder)localObject).append(this.bk);
    QLog.d("FastWebActivity", 1, ((StringBuilder)localObject).toString());
  }
  
  private void aH()
  {
    int i1 = (int)(com.tencent.mobileqq.kandian.base.utils.RIJDisplayStyleManager.INSTANCE.getPhysicalDisplaySize(this)[0] / 16.0F * 9.0F);
    if (i1 > 0)
    {
      View localView = this.y;
      if ((localView != null) && ((localView.getLayoutParams() instanceof RelativeLayout.LayoutParams))) {
        ((RelativeLayout.LayoutParams)this.y.getLayoutParams()).topMargin = i1;
      }
    }
  }
  
  private void aI()
  {
    RIJBiuAndCommentMixDataManager localRIJBiuAndCommentMixDataManager = this.bp;
    if (localRIJBiuAndCommentMixDataManager != null) {
      localRIJBiuAndCommentMixDataManager.a();
    }
    this.bp = new RIJBiuAndCommentMixDataManager();
    this.bp.a(new FastWebActivity.39(this));
  }
  
  private void aJ()
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
        this.aI = 32;
        return;
      case 1003: 
        this.aI = 64;
        return;
      case 1002: 
        this.aI = 16;
        return;
      }
      this.aI = aK();
    }
  }
  
  private int aK()
  {
    long l1 = this.j;
    if (l1 == 0L) {
      return 2;
    }
    if (l1 == 70L) {
      return 4;
    }
    return 8;
  }
  
  private VafContext aL()
  {
    VafContext localVafContext = this.bB;
    if (localVafContext == null)
    {
      this.bB = new ReadInjoyContext();
      this.bB.setContext(this);
      ProteusSupportUtil.a(this.bB, "native_article");
    }
    else
    {
      localVafContext.setContext(this);
    }
    return this.bB;
  }
  
  private void aa()
  {
    if (this.ag != null) {
      a(this.v.getFirstVisiblePosition(), this.ag);
    }
  }
  
  private void ab()
  {
    ac();
    getMainLooper();
    Looper.myQueue().addIdleHandler(this.bK);
  }
  
  private void ac()
  {
    getMainLooper();
    Looper.myQueue().removeIdleHandler(this.bK);
  }
  
  private int ad()
  {
    return a(this.ay, this.az);
  }
  
  private int ae()
  {
    if (this.aq == null)
    {
      QLog.e("Q.readinjoy.fast_web", 2, "getRatio itemsHeight == null ");
      return -1;
    }
    int i1 = 0;
    int i3;
    for (int i2 = 0; i1 < this.aj.size(); i2 = i3)
    {
      i3 = i2;
      if (FastWebPTSUtils.a((BaseData)this.aj.get(i1))) {
        i3 = i2 + this.aq.a(i1);
      }
      i1 += 1;
    }
    return i2;
  }
  
  private float af()
  {
    if (this.aq == null)
    {
      QLog.e("Q.readinjoy.fast_web", 2, "getRatio itemsHeight == null ");
      return 0.0F;
    }
    if (this.ay <= 0) {
      ah();
    }
    int i1 = ad();
    int i2 = ae();
    if ((i1 < i2) && (i2 > 0)) {
      return i1 / i2;
    }
    return 1.0F;
  }
  
  private boolean ag()
  {
    if (this.aq != null)
    {
      WebFastAdapter localWebFastAdapter = this.G;
      if ((localWebFastAdapter == null) || (localWebFastAdapter.getCount() == this.aq.a())) {
        return false;
      }
    }
    QLog.e("Q.readinjoy.fast_web", 2, "refreshMaxReadHeight itemsHeight == null ");
    return true;
  }
  
  private void ah()
  {
    if (ag()) {
      return;
    }
    int i3 = this.v.getLastVisiblePosition();
    f(i3);
    int i2 = this.v.getFirstVisiblePosition();
    boolean bool1 = false;
    int i1 = 0;
    while (i2 <= i3)
    {
      i1 = g(i2);
      boolean bool2 = bool1;
      if (i2 < this.aj.size())
      {
        bool2 = bool1;
        if (((BaseData)this.aj.get(i2)).aS)
        {
          this.ar = true;
          if (this.Q == 0) {
            this.Q = b(this.v, this.bm);
          }
          bool2 = true;
        }
      }
      i2 += 1;
      bool1 = bool2;
    }
    f(bool1);
    int[] arrayOfInt = ReportUtil.a;
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
        TimeSliceHelper.c(ReportUtil.a(this.g, localInteger.intValue()));
      } else {
        TimeSliceHelper.d(ReportUtil.a(this.g, localInteger.intValue()));
      }
      i2 += 1;
    }
  }
  
  private void ai()
  {
    this.be = true;
    this.bb.exitAnimation();
    QLog.d("FastWebActivity", 2, "mColorNoteController ：exitAnimation");
  }
  
  private void aj()
  {
    this.be = true;
    this.bi.a(0, 4);
    QLog.d("FastWebActivity", 2, "mFloating doClostAnimTopToBottom ");
  }
  
  private void ak()
  {
    Object localObject = this.v;
    if (localObject != null)
    {
      localObject = ((ReadInJoyCommentListView)localObject).onSaveInstanceState();
      if (this.g != null)
      {
        FastWebModule localFastWebModule = ((ReadInJoyLogicManager)this.app.getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER)).getReadInJoyLogicEngine().d();
        if (localFastWebModule != null)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(this.g.mArticleID);
          localStringBuilder.append("");
          localFastWebModule.a(localStringBuilder.toString(), (Parcelable)localObject);
        }
      }
    }
  }
  
  private boolean al()
  {
    return (this.ae == null) || (this.ai);
  }
  
  private boolean am()
  {
    return (this.aH == 1001) && (!DailyModeConfigHandler.c(this.ad));
  }
  
  private void an()
  {
    ArrayList localArrayList = new ArrayList();
    int i1 = 0;
    while (i1 < this.aj.size())
    {
      BaseData localBaseData = (BaseData)this.aj.get(i1);
      if (localBaseData.aP != 6) {
        if (AdData.a(localBaseData))
        {
          localArrayList.add(new ItemShowDispatcher.AdPostionReportManager(i1, Long.valueOf(0L), localBaseData));
          this.al.a(i1, new FastWebActivity.20(this, i1, localBaseData));
        }
        else if (ReportUtil.a(localBaseData))
        {
          this.al.b(i1, new FastWebActivity.21(this, localBaseData));
        }
      }
      i1 += 1;
    }
    this.al.a(localArrayList);
  }
  
  private void ao()
  {
    if (this.aj != null)
    {
      if (this.al == null) {
        return;
      }
      int i1 = 0;
      while (i1 < this.aj.size())
      {
        BaseData localBaseData = (BaseData)this.aj.get(i1);
        if (h(localBaseData.aP)) {
          this.al.b(i1, new FastWebActivity.22(this, localBaseData));
        }
        i1 += 1;
      }
    }
  }
  
  private void ap()
  {
    Object localObject1 = this.al;
    if (localObject1 != null)
    {
      if (this.aj == null) {
        return;
      }
      if ((((ItemShowDispatcher)localObject1).a != null) && (this.al.a.size() > 0))
      {
        localObject1 = this.al.a.iterator();
        label233:
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject3 = (Integer)((Iterator)localObject1).next();
          int i1 = 0;
          for (;;)
          {
            if (i1 >= this.aj.size()) {
              break label233;
            }
            if (((Integer)localObject3).intValue() == i1)
            {
              Object localObject2 = (BaseData)this.aj.get(((Integer)localObject3).intValue());
              if (AdData.a((BaseData)localObject2))
              {
                ReportUtil.a(this.app, (AdData)localObject2);
                if (((BaseData)localObject2).aQ == null) {
                  break;
                }
                localObject3 = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("invalidADExposurePos report ");
                localStringBuilder.append(((BaseData)localObject2).aQ.mTitle);
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
        this.al.a.clear();
      }
    }
  }
  
  private void aq()
  {
    int i1 = ae();
    ReportUtil.a(this.g, ad(), i1, this.ao, this.j, this.bn);
    WebFastAdapter localWebFastAdapter = this.G;
    if (localWebFastAdapter != null) {
      localWebFastAdapter.e();
    }
  }
  
  private void ar()
  {
    Object localObject = this.F;
    if (localObject != null)
    {
      localObject = ((ReadInJoyCommentListAdapter)localObject).q();
      if (localObject != null) {
        ((ReadInJoyCommentReportManager)localObject).a(this.aU);
      }
    }
  }
  
  private void as()
  {
    Object localObject = this.g;
    if (localObject != null)
    {
      TimeSliceHelper.d(((AbsBaseArticleInfo)localObject).innerUniqueID);
      localObject = this.F;
      if ((localObject != null) && (((ReadInJoyCommentListAdapter)localObject).q() != null))
      {
        localObject = this.F.q();
        ((ReadInJoyCommentReportManager)localObject).a(this.aT.e(), this.aU);
        ((ReadInJoyCommentReportManager)localObject).a(0, this.v.getLastVisiblePosition() - this.G.getCount());
      }
      localObject = this.bA;
      if (localObject != null) {
        ((TKDTuWenHippyCommentAdapter)localObject).sendCommentReadTime(this.aT.e());
      }
    }
  }
  
  private void at()
  {
    long l1 = TimeUtil.c("fast_web_show_light_house_1");
    if (l1 < 0L) {
      return;
    }
    boolean bool = this.ai;
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
    localHashMap.put("param_uin", RIJQQAppInterfaceUtil.d());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("reportSpentTime, params = ");
    localStringBuilder.append(localHashMap.toString());
    localStringBuilder.append("  all cost : ");
    l1 = l4 - l1;
    localStringBuilder.append(l1);
    QLog.d("Q.readinjoy.fast_web", 2, localStringBuilder.toString());
    StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(null, "actKandianFastWebCost", bool ^ true, l1, 0L, localHashMap, null);
  }
  
  private void au()
  {
    this.aK = this.v.getFirstVisiblePosition();
    Object localObject = this.v.getChildAt(0);
    int i1;
    if (localObject == null) {
      i1 = 0;
    } else {
      i1 = ((View)localObject).getTop();
    }
    this.aL = i1;
    this.aM = this.v.getLastVisiblePosition();
    boolean bool1 = i(this.aK);
    boolean bool2 = i(this.aM);
    if ((!bool1) && (!bool2))
    {
      this.aN = this.aK;
      this.aO = this.aL;
      this.aR = true;
      return;
    }
    if ((bool1) && (bool2))
    {
      this.aP = this.aK;
      this.aQ = this.aL;
      this.aR = false;
      this.J = true;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("upCmtHisPos mCommentAreaLastFirstVisItemPos = ");
      ((StringBuilder)localObject).append(this.aP);
      QLog.d("FastWebActivity", 1, ((StringBuilder)localObject).toString());
      return;
    }
    if ((!bool1) && (bool2))
    {
      this.aR = false;
      this.J = true;
      this.aN = 0;
      this.aO = 0;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("2area show together initCommentAreaAnchor mCommentAreaLastFirstVisItemPos = ");
      ((StringBuilder)localObject).append(this.aP);
      QLog.d("FastWebActivity", 1, ((StringBuilder)localObject).toString());
      e();
    }
  }
  
  private boolean av()
  {
    FastWebMergeAdapter localFastWebMergeAdapter = this.E;
    boolean bool = false;
    if (localFastWebMergeAdapter == null) {
      return false;
    }
    if (localFastWebMergeAdapter.a().size() > 0) {
      bool = true;
    }
    return bool;
  }
  
  private void aw()
  {
    try
    {
      FastWebPTSDataConverter.a(this.aj, this.g, this.ae, this.n);
      this.B.setData(this, this.ae, this.g);
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
  
  private void ax()
  {
    if (!this.ak) {
      return;
    }
    if (this.ab == null) {
      finish();
    }
  }
  
  private void ay()
  {
    FastWebPTSUtils.a(this.aj);
  }
  
  private void az()
  {
    Object localObject = findViewById(2131441404);
    if (localObject != null) {
      ((View)localObject).setVisibility(0);
    }
    localObject = (TextView)findViewById(2131444292);
    String str = getString(2131915464);
    if ((localObject != null) && (!TextUtils.isEmpty(str)))
    {
      ((TextView)localObject).setVisibility(0);
      ((TextView)localObject).setText(str);
    }
  }
  
  private int b(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0) {
      this.aB = a(paramAbsListView.getLastVisiblePosition(), this.aA);
    } else if (this.aB == 0) {
      this.aB = a(paramAbsListView.getLastVisiblePosition(), this.aA);
    }
    return this.aB;
  }
  
  private void b(int paramInt)
  {
    ar();
    this.F = new ReadInJoyCommentListAdapter(this, this.v, paramInt);
    Object localObject = this.aS;
    String str;
    if (localObject != null)
    {
      str = ((AnchorData)localObject).a;
      localObject = this.aS.b;
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
      this.F.a(new FastWebActivity.12(this, str, (String)localObject));
    }
    if (!RIJCommentAdUtils.a())
    {
      this.F.a(this.g, this.aS, 1);
    }
    else
    {
      this.g.mAdScene = 1;
      if (!I()) {
        this.F.a(this.g, this.aS, 1);
      }
    }
    this.F.a(new FastWebActivity.CommentNumChangedlistener(this, null));
    this.E.a(this.F);
    J();
  }
  
  private void b(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.bA == null) {
      return;
    }
    ReadInJoySecondCommentListFragment localReadInJoySecondCommentListFragment = this.H;
    if ((localReadInJoySecondCommentListFragment != null) && (localReadInJoySecondCommentListFragment.isVisible()) && (this.H.b()))
    {
      this.H.onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
    }
    this.bA.onActivityResult(paramInt1, paramInt2, paramIntent);
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
      e(paramAuthorData.j);
    } else {
      paramInt = 4;
    }
    int i1 = this.by.getVisibility();
    this.by.setVisibility(paramInt);
    if ((i1 != paramInt) && (paramInt == 0)) {
      ReadinjoyReportUtils.a(this.g, ReadinjoyReportUtils.d, true, "");
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
    ReadInJoyCommentListFragment.a(paramIntent, this.bp, 1, true, this.g, this.F.o(), i1);
    QLog.d("FastWebActivity", 1, "back from biuAndComment");
  }
  
  private void b(Bundle paramBundle)
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
  
  private void b(BaseData paramBaseData)
  {
    if (paramBaseData == null) {
      return;
    }
    if (this.o.contains(paramBaseData)) {
      return;
    }
    if (paramBaseData.aW != 1) {
      if (paramBaseData.aW == 2) {
        return;
      }
    }
    for (;;)
    {
      try
      {
        Object localObject2;
        if (paramBaseData.aP == 6)
        {
          ReportUtil.a(this.g, paramBaseData);
          if ((paramBaseData instanceof ProteusRecommendItemData))
          {
            JSONObject localJSONObject1 = ((ProteusRecommendItemData)paramBaseData).bb;
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
              KandianUGStatisticUtils.a(KandianUGStatisticUtils.a(new FastWebRecommendUGInfo(localJSONObject1.optString("kd_ug_rsp_info")).c, (String)localObject1, "2"));
            }
          }
        }
        else if (paramBaseData.aP == 26)
        {
          localObject1 = (ProteusItemData)paramBaseData;
          if (((ProteusItemData)localObject1).bf == 2)
          {
            FastWebDislikeUtils.a(this.g, this.ae, 2);
            FastWebDislikeUtils.a(this.g, "0X80099DA");
            FastWebDislikeUtils.a(this.g, "0X80100DB");
            FastWebDislikeUtils.a(this.g, "0X8009A5A");
            localObject1 = RIJVideoRewardCoinManager.a;
            localObject2 = this.ae.q;
            if (!this.ae.N) {
              break label432;
            }
            i1 = 3;
            ((RIJVideoRewardCoinManager.Companion)localObject1).a("0X800B2EA", new RIJVideoRewardCoinManager.RIJRewardData((String)localObject2, i1), 6);
          }
          else
          {
            FastWebProteusReportUtils.a(this.g, this.ae, (ProteusItemData)localObject1);
          }
        }
        else
        {
          ReportUtil.b(paramBaseData);
          if (paramBaseData.aQ != null)
          {
            localObject1 = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("doExposure baseData=");
            ((StringBuilder)localObject2).append(paramBaseData.aQ.mTitle);
            ((IRIJAdLogService)localObject1).d("REPORT_LINK", ((StringBuilder)localObject2).toString());
          }
        }
        this.o.add(paramBaseData);
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
      label432:
      int i1 = 1;
    }
  }
  
  private void b(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    AbsBaseArticleInfo localAbsBaseArticleInfo = this.g;
    if (localAbsBaseArticleInfo != null) {
      QidianManager.a(this, 6, localAbsBaseArticleInfo.mTitle, this.g.mSummary, this.g.mArticleContentUrl, this.g.mFirstPagePicUrl, paramActionSheetItem.uin, paramActionSheetItem.uinType, false);
    }
  }
  
  private boolean b(BaseAdapter paramBaseAdapter, int paramInt1, int paramInt2)
  {
    if (!(paramBaseAdapter instanceof TKDTuWenHippyCommentAdapter)) {
      return false;
    }
    return c(paramBaseAdapter, paramInt1, paramInt2);
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
  
  private void c(Bundle paramBundle)
  {
    Bundle localBundle = getIntent().getExtras();
    if (localBundle != null)
    {
      QLog.d("FastWebActivity", 1, "onSaveInstanceState data != null");
      paramBundle.putBundle("bundle_key_save_instancestate", localBundle);
    }
  }
  
  private void c(boolean paramBoolean)
  {
    if (this.bh) {
      return;
    }
    this.bh = true;
    int i2 = this.L.c();
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
    if (this.bj)
    {
      localObject = this.bi;
      if ((localObject != null) && (paramBoolean)) {
        ((CommonSuspensionGestureLayout)localObject).f();
      }
    }
  }
  
  private boolean c(BaseAdapter paramBaseAdapter, int paramInt1, int paramInt2)
  {
    int i1 = paramBaseAdapter.getCount();
    return (paramInt1 >= paramInt2) && (paramInt1 < i1 + paramInt2);
  }
  
  private void d(int paramInt)
  {
    Object localObject = this.B;
    if (localObject != null) {
      ((ReadInJoyFastWebBottomSocialViewNew)localObject).setFavoriteArticle(this, this.g, this.ae, paramInt);
    }
    if (this.au) {
      localObject = "0X8008994";
    } else {
      localObject = "0X800898D";
    }
    FastWebShareUtils.a(this, (String)localObject, 8, this.g);
    ReportUtil.a(this, getAppInterface(), this.g, -1, 4, false);
  }
  
  private void d(Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("arg_result_json");
    int i1 = -1;
    int i2 = paramIntent.getIntExtra("click_comment_edit_src", -1);
    paramIntent = ReadInJoyCommentDataManager.a(this.g);
    if (paramIntent == null)
    {
      paramIntent = new StringBuilder();
      paramIntent.append("commentDataManage is null, src : ");
      paramIntent.append(i2);
      paramIntent.append(", hasInit : ");
      boolean bool;
      if (this.aj != null) {
        bool = true;
      } else {
        bool = false;
      }
      paramIntent.append(bool);
      AIOUtils.a("FastWebActivity", paramIntent.toString(), new NullPointerException());
      return;
    }
    ReadInJoyCommentListAdapter localReadInJoyCommentListAdapter = this.F;
    if (localReadInJoyCommentListAdapter != null) {
      i1 = localReadInJoyCommentListAdapter.o();
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
    if (paramBoolean)
    {
      this.B.setVisibility(0);
      this.B.setData(this, this.ae, this.g);
      return;
    }
    this.B.setVisibility(8);
  }
  
  private void e(int paramInt)
  {
    FastWebModule localFastWebModule = ReadInJoyLogicEngine.a().d();
    String str = this.g.mArticleContentUrl;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.g.mArticleID);
    ((StringBuilder)localObject).append("");
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.g.innerUniqueID);
    localStringBuilder.append("");
    localFastWebModule.a(str, (String)localObject, localStringBuilder.toString(), this.g.mSubscribeID, paramInt, this.bJ);
  }
  
  private void e(Intent paramIntent)
  {
    aB();
    paramIntent = paramIntent.getExtras();
    if (paramIntent == null)
    {
      QLog.e("Q.readinjoy.fast_web", 1, " refrashFromIntent data == null ");
      return;
    }
    this.g = ((AbsBaseArticleInfo)paramIntent.get("fast_web_article_info"));
    this.al = new ItemShowDispatcher();
    this.A = true;
    this.ao = paramIntent.getBoolean("fast_web_from_article_recommend", false);
    paramIntent = this.as;
    if (paramIntent != null) {
      paramIntent.set(false);
    }
    x();
  }
  
  private void e(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void f(int paramInt)
  {
    int i1;
    if (paramInt > this.ay) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (this.aq != null)
    {
      int i3 = this.ay;
      int i2 = paramInt;
      if (i3 > paramInt) {
        i2 = i3;
      }
      this.ay = i2;
      paramInt = this.v.getFirstVisiblePosition();
      paramInt = this.ay - paramInt;
      if ((paramInt < this.v.getChildCount()) && (this.ay < this.aq.a()))
      {
        Object localObject = this.v.getChildAt(paramInt);
        paramInt = this.v.getHeight();
        i2 = ((View)localObject).getTop();
        this.aA = (this.aq.a(this.ay) - (paramInt - i2));
        if (i1 != 0)
        {
          this.az = this.aA;
        }
        else
        {
          paramInt = this.aA;
          i1 = this.az;
          if (paramInt >= i1) {
            paramInt = i1;
          }
          this.az = paramInt;
        }
        if (this.az < 0) {
          this.az = 0;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("  mMaxLastPosition  ");
        ((StringBuilder)localObject).append(this.ay);
        ((StringBuilder)localObject).append("  mMaxLastItemInvisibleHeight ");
        ((StringBuilder)localObject).append(this.az);
        QLog.d("Q.readinjoy.fast_web", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  private void f(boolean paramBoolean)
  {
    ((IRIJFastWebAdService)QRoute.api(IRIJFastWebAdService.class)).updateSoftAdBar(this.C, paramBoolean, b(this.v, this.bm), this.v.getHeight(), this.Q, this.ar);
  }
  
  private int g(int paramInt)
  {
    if (paramInt < this.aj.size())
    {
      float f1 = BaseDataUtil.INSTANCE.getSortWeight((BaseData)this.aj.get(paramInt));
      float[] arrayOfFloat = ReportUtil.b;
      paramInt = 0;
      if (f1 <= arrayOfFloat[0]) {
        return 1;
      }
      if (f1 <= ReportUtil.b[1]) {
        return 2;
      }
      if (f1 <= ReportUtil.b[2]) {
        return 4;
      }
    }
    else
    {
      paramInt = 8;
    }
    return paramInt;
  }
  
  private void g(boolean paramBoolean)
  {
    runOnUiThread(new FastWebActivity.34(this, paramBoolean));
  }
  
  private void h(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.ae != null) && (!this.ak)) {
      M();
    }
  }
  
  private boolean h(int paramInt)
  {
    return (paramInt == 6) || (paramInt == 18) || (paramInt == 23) || (paramInt == 26);
  }
  
  private void i()
  {
    if (!this.aD)
    {
      ReadInJoyCommentListView localReadInJoyCommentListView = this.v;
      if ((localReadInJoyCommentListView != null) && (i(localReadInJoyCommentListView.getLastVisiblePosition()))) {
        this.aT.b();
      }
    }
  }
  
  private boolean i(int paramInt)
  {
    if (!av()) {
      return false;
    }
    int i3 = this.E.a().size();
    int i1 = 0;
    int i2 = 0;
    while (i1 < i3)
    {
      BaseAdapter localBaseAdapter = (BaseAdapter)this.E.a().get(i1);
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
  
  private void j()
  {
    if (this.g == null) {
      return;
    }
    try
    {
      VideoReport.setPageId(this, "1");
      String str;
      if (TextUtils.isEmpty(this.g.innerUniqueID)) {
        str = "null";
      } else {
        str = this.g.innerUniqueID;
      }
      VideoReport.setPageContentId(this, str);
      VideoReport.setPageParams(this, new RIJDtParamBuilder().e(this.g.innerUniqueID).a(Long.valueOf(this.g.mChannelID)).a("ref_channel", Long.valueOf(this.g.mChannelID)).b(Integer.valueOf(this.g.dtReportContentType)).b());
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      label115:
      break label115;
    }
    AIOUtils.a("Q.readinjoy.fast_web", "doPageDtReportConfig IllegalArgumentException. This is not a crash!!!", new IllegalArgumentException());
  }
  
  private boolean j(int paramInt)
  {
    CopyOnWriteArrayList localCopyOnWriteArrayList = this.aj;
    if ((localCopyOnWriteArrayList != null) && (localCopyOnWriteArrayList.size() > 0) && (paramInt > 0) && (paramInt < this.aj.size())) {
      return FastWebPTSUtils.a((BaseData)this.aj.get(paramInt));
    }
    return false;
  }
  
  private void k()
  {
    if ((this.bj) && (this.bg)) {
      ThreadManager.getUIHandler().postDelayed(new FastWebActivity.1(this), 500L);
    }
  }
  
  private void k(int paramInt)
  {
    int i1;
    if (this.aw == 72) {
      i1 = 13;
    } else {
      i1 = -1;
    }
    AppInterface localAppInterface = getAppInterface();
    AbsBaseArticleInfo localAbsBaseArticleInfo = this.g;
    boolean bool;
    if (paramInt == -1) {
      bool = true;
    } else {
      bool = false;
    }
    ReportUtil.a(this, localAppInterface, localAbsBaseArticleInfo, 1, i1, false, bool, false);
  }
  
  private void l()
  {
    if ((this.bj) && (this.bg))
    {
      Intent localIntent = getIntent();
      Bundle localBundle = null;
      if (localIntent != null) {
        localBundle = localIntent.getExtras();
      }
      this.bi = new CommonSuspensionGestureLayout(this, localBundle);
      this.bi.setIsAutoSuctionTop(this.bk);
      this.bi.setIsNeedPopAnim(this.bl);
      this.bi.setIsStatusImmersive(false);
      this.bi.setContentScrollListener(new FastWebActivity.2(this));
      this.bi.setViolaGestureListener(new FastWebActivity.3(this));
      this.bi.a(this, 2131444899, 2131429695);
      this.bi.setMaskBackGroundDrawable(getResources().getDrawable(2130842685));
      this.B.setBackgroundColor(-1);
    }
  }
  
  private void l(int paramInt)
  {
    if (paramInt == -1)
    {
      localObject = this.ae;
      if (localObject != null)
      {
        ((FastWebArticleInfo)localObject).e += 1L;
        ThreadManager.getUIHandler().post(new FastWebActivity.26(this));
      }
    }
    Object localObject = getAppInterface();
    AbsBaseArticleInfo localAbsBaseArticleInfo = this.g;
    boolean bool;
    if (paramInt == -1) {
      bool = true;
    } else {
      bool = false;
    }
    ReportUtil.a(this, (AppInterface)localObject, localAbsBaseArticleInfo, 0, -1, false, bool, false);
  }
  
  private void m()
  {
    if (this.g == null)
    {
      QLog.d("FastWebActivity", 2, "init color error mArticleInfo is null");
      return;
    }
    this.bb = ((IColorNoteController)QRoute.api(IColorNoteController.class));
    this.bb.init(this, true, false, true, true, 0);
    this.bb.attachToActivity(this);
    this.bb.setServiceInfo(new FastWebActivity.4(this));
    if (this.g != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mColorNoteController ： mOutterRowKey : ");
      localStringBuilder.append(this.g.innerUniqueID);
      localStringBuilder.append("mTitle : ");
      localStringBuilder.append(this.g.mTitle);
      localStringBuilder.append("mSubscribeName : ");
      localStringBuilder.append(this.g.mSubscribeName);
      localStringBuilder.append("mSubscribeName : ");
      localStringBuilder.append(this.g.mSubscribeName);
      QLog.d("FastWebActivity", 2, localStringBuilder.toString());
    }
    this.bb.setOnColorNoteAnimFinishListener(new FastWebActivity.5(this));
    this.bb.setOnColorNoteCurdListener(new FastWebActivity.6(this));
    this.bb.setOnPageSwipeListener(new FastWebActivity.7(this));
    if (!this.bg) {
      this.bb.disableSwipe();
    }
  }
  
  private void m(int paramInt)
  {
    if ((this.bi != null) && (this.bj))
    {
      this.B.setVisibility(paramInt);
      this.bi.e();
    }
  }
  
  private void n(int paramInt)
  {
    if (this.g != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("requestControllInfo delayTime: ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" rowKey: ");
      localStringBuilder.append(this.g.innerUniqueID);
      QLog.d("FastWebActivity", 1, localStringBuilder.toString());
      ThreadManager.getUIHandler().postDelayed(this.u, paramInt);
    }
  }
  
  private byte[] n()
  {
    Object localObject = this.g;
    byte[] arrayOfByte = null;
    if (localObject == null) {
      return null;
    }
    localObject = arrayOfByte;
    try
    {
      Parcel localParcel = Parcel.obtain();
      localObject = arrayOfByte;
      this.g.writeToParcel(localParcel, 0);
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
  
  private void o()
  {
    b = false;
    SneakyCallback.a(4);
  }
  
  private void p()
  {
    b = false;
    c = false;
    this.p = 0L;
  }
  
  private void q()
  {
    try
    {
      this.d = findViewById(2131445015);
      if (ImmersiveUtils.isSupporImmersive() == 1)
      {
        this.d.setFitsSystemWindows(true);
        this.d.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
      }
      r();
      this.w = ((TextView)findViewById(2131436227));
      findViewById(2131436180).setOnClickListener(this);
      this.B = ((ReadInJoyFastWebBottomSocialViewNew)findViewById(2131429695));
      this.e = findViewById(2131444899);
      this.B.setProteusContext(aL());
      this.w.setOnClickListener(this);
      this.v = ((ReadInJoyCommentListView)findViewById(2131450350));
      this.v.setEdgeEffectEnabled(true);
      this.v.mEdgeGlowTop.setEdgeDrawable(getResources().getDrawable(2131168376));
      this.v.mEdgeGlowBottom.setEdgeDrawable(getResources().getDrawable(2131168376));
      this.v.setOverScrollTouchMode(1);
      this.v.setOverScrollFlingMode(1);
      this.v.setDescendantFocusability(262144);
      s();
      Object localObject = (QQAppInterface)ReadInJoyUtils.b();
      this.an = ((IQQAvatarService)((QQAppInterface)localObject).getRuntimeService(IQQAvatarService.class, "")).getInstance((AppInterface)localObject);
      this.an.setDecodeTaskCompletionListener(this);
      this.z = ((TextView)findViewById(2131448343));
      if (this.z.getPaint() != null) {
        this.z.getPaint().setFakeBoldText(true);
      }
      this.bo = findViewById(2131437984);
      this.bo.setOnClickListener(this);
      Z();
      t();
      u();
      localObject = findViewById(2131444812);
      ((View)localObject).setOnClickListener(this);
      a((View)localObject, "more_function_button", "more_function_button", "click_more_function");
      this.D = ((TextView)findViewById(2131433080));
      this.aW = new FastWebActivity.RecommendAndAdCallback(this);
      N();
      x();
      aG();
      aJ();
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      label381:
      break label381;
    }
    setResult(-10069, getIntent());
    finish();
  }
  
  private void r()
  {
    if (ThemeUtil.isInNightMode(ReadInJoyUtils.b()))
    {
      if (this.x == null)
      {
        ViewStub localViewStub = (ViewStub)findViewById(2131444309);
        if ((localViewStub instanceof ViewStub)) {
          this.x = localViewStub.inflate();
        }
      }
      this.x.setVisibility(0);
    }
  }
  
  private void s()
  {
    this.C = ((CommonAdBar)findViewById(2131446153));
    this.C.bringToFront();
  }
  
  private void t()
  {
    this.aX = ((RelativeLayout)findViewById(2131445072));
    this.aY = ((ImageView)findViewById(2131438587));
    this.aZ = ((TextView)findViewById(2131438588));
    Drawable localDrawable = ImageUtil.a(this.aY.getResources().getDrawable(2130841880), -16777216);
    this.aY.setImageDrawable(localDrawable);
    a(this.aX, "news_button", "news_button", "click_news");
  }
  
  private void u()
  {
    if (this.k == null) {
      this.k = new MiniMsgUser(getActivity(), a());
    }
  }
  
  private boolean v()
  {
    Object localObject = ReadInJoyLogicEngine.a().d().c(this.ae.q);
    if (localObject != null) {
      this.aj.addAll((Collection)localObject);
    }
    localObject = this.aj;
    if ((localObject != null) && (!((CopyOnWriteArrayList)localObject).isEmpty()))
    {
      if ((this.aj.size() >= 2) && ((this.aj.get(0) instanceof TitleData)) && ((this.aj.get(1) instanceof AuthorData)))
      {
        this.aj.set(0, this.af);
        this.aj.set(1, this.ag);
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("  ");
        ((StringBuilder)localObject).append(this.aj.size());
        ((StringBuilder)localObject).append("  :  ");
        ((StringBuilder)localObject).append(this.g.mArticleContentUrl);
        AIOUtils.a("Q.readinjoy.fast_web", ((StringBuilder)localObject).toString(), new IllegalArgumentException());
      }
      if ((this.aH != 1001) && (this.ab == null) && (this.as.compareAndSet(false, true)))
      {
        ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("REPORT_LINK", "requestAdData onGetRecommendsResult updateDatasAndCheckCache");
        ((IRIJFastWebAdService)QRoute.api(IRIJFastWebAdService.class)).removeInnerAd(this.aj);
      }
      ((IRIJFastWebAdService)QRoute.api(IRIJFastWebAdService.class)).removeBottomAd(this.aj);
      return true;
    }
    TimeUtil.a("HtmlChangeUtil.parse");
    if (this.n == null) {
      this.n = FastWebPTSDataConverter.b();
    }
    localObject = HtmlChangeUtil.a(this.g, this.ae, this.n);
    if (localObject != null) {
      this.aj.addAll((Collection)localObject);
    }
    ay();
    localObject = this.aj;
    if ((localObject != null) && (!((CopyOnWriteArrayList)localObject).isEmpty()))
    {
      this.aj.add(0, this.af);
      this.aj.add(1, this.ag);
      w();
      FastWebArticleInfoUtils.a(this.ae, this.aj);
      localObject = this.aj.iterator();
      while (((Iterator)localObject).hasNext())
      {
        BaseData localBaseData = (BaseData)((Iterator)localObject).next();
        localBaseData.aQ = this.g;
        localBaseData.aR = this.ae;
      }
      TimeUtil.a("HtmlChangeUtil.parse");
      return false;
    }
    localObject = new RuntimeException("parse data is empty!");
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  private void w()
  {
    if (Aladdin.getConfig(423).getIntegerFromString("native_article_show_read_count", 1) == 1)
    {
      ProteusItemData localProteusItemData = FastWebPTSDataConverter.a(this.g, this.ae, this.n);
      if (localProteusItemData != null) {
        this.aj.add(localProteusItemData);
      }
    }
  }
  
  private void x()
  {
    if (this.g == null) {
      return;
    }
    if (this.ae == null)
    {
      K();
      return;
    }
    HashMap localHashMap = new HashMap();
    boolean bool;
    try
    {
      E();
      TimeUtil.b("fast_web_show_light_house_step4_1");
      this.af = FastWebArticleInfoUtils.a(this.ae, this.g);
      a(this.af, this.ae);
      this.ag = FastWebArticleInfoUtils.b(this.ae, this.g);
      a(this.ag, this.ae);
      this.bC = v();
      FastWebPTSDataConverter.a(this.aj, this.ae);
      ItemDatasListUtils.a(this.aj, this.g, this.ae);
      A();
      TimeUtil.b("fast_web_show_light_house_step4_2");
      this.E = new FastWebMergeAdapter();
      this.aq = new ItemHeightHelper(this.v, this.aj, this.E);
      this.al.a(this.aq);
      this.G = new WebFastAdapter(this, this.aj, this.an, aL());
      this.E.a(this.G);
      if (this.ae.c()) {
        G();
      }
      z();
      B();
      this.v.setDrawFinishedListener(this.bH);
      this.v.setOnScrollListener(this.q);
      this.v.setAdapter(this.E);
      this.E.a(this.s);
      this.y = findViewById(2131445466);
      aH();
      localObject3 = ReadInJoyLogicEngine.a().d();
      Object localObject1 = null;
      if (this.ab != null)
      {
        localObject1 = this.ab.b;
      }
      else if (localObject3 != null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(this.g.mArticleID);
        ((StringBuilder)localObject1).append("");
        localObject1 = ((FastWebModule)localObject3).a(((StringBuilder)localObject1).toString());
      }
      if (localObject1 != null)
      {
        localObject1 = (AbsListView.SavedState)localObject1;
        this.v.onRestoreInstanceState((Parcelable)localObject1);
        a(((AbsListView.SavedState)localObject1).position, this.ag);
      }
      else
      {
        a(0, this.ag);
      }
      a(this.ag);
      if (((this.aH != 1001) && (this.ab == null)) || (!this.bC))
      {
        a(this.aj);
        if (localObject3 != null) {
          ((FastWebModule)localObject3).a(this.g, this.bJ, true);
        }
      }
      if ((!this.bC) && (localObject3 != null)) {
        ((FastWebModule)localObject3).a(this.g, this.aj);
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
      y();
      bool = false;
    }
    localHashMap.put("param_uin", RIJQQAppInterfaceUtil.d());
    localHashMap.put("param_url", this.g.mArticleContentUrl);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.g.mArticleID);
    ((StringBuilder)localObject2).append("");
    localHashMap.put("param_articleID", ((StringBuilder)localObject2).toString());
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.g.innerUniqueID);
    ((StringBuilder)localObject2).append("");
    localHashMap.put("param_rowkey", ((StringBuilder)localObject2).toString());
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.g.mChannelID);
    ((StringBuilder)localObject2).append("");
    localHashMap.put("param_channelID", ((StringBuilder)localObject2).toString());
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actNativeWebParser", bool, 100L, 0L, localHashMap, "", true);
    if (!bool)
    {
      d(false);
      L();
    }
    else
    {
      d(true);
      FastWebArticleInfoUtils.c(this.ae, this.g);
      ReadInJoyLogicEngineEventDispatcher.a().a(this.bG);
      ReadInJoyLogicEngineEventDispatcher.a().a(this.bF);
      if (this.f)
      {
        this.B.b();
        this.f = false;
      }
    }
    ReadInJoyDropFrameHelper.d().a(5555, this);
    ReadInJoyDropFrameHelper.d().a(6666, this);
    e();
    new StyleConfigHelper().a("native_article");
    aI();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("initData,isParseSuccess=");
    ((StringBuilder)localObject2).append(bool);
    QLog.d("FastWebActivity", 1, ((StringBuilder)localObject2).toString());
    localObject2 = this.ae;
    if ((localObject2 != null) && (((FastWebArticleInfo)localObject2).y != 0L))
    {
      ReadInJoyUserInfoModule.a(this.ae.y, this.bE, true);
      a(this.ae.y);
    }
  }
  
  private void y() {}
  
  private void z()
  {
    if (this.v.getFooterViewsCount() == 0) {
      this.v.initFooterView();
    }
  }
  
  protected MiniMsgUserParam a()
  {
    MiniMsgUserParam localMiniMsgUserParam = new MiniMsgUserParam();
    localMiniMsgUserParam.businessName = 3;
    localMiniMsgUserParam.accessType = 1;
    localMiniMsgUserParam.filterMsgType = 1;
    localMiniMsgUserParam.actionCallback = this;
    RelativeLayout localRelativeLayout = this.aX;
    localMiniMsgUserParam.entryView = localRelativeLayout;
    localMiniMsgUserParam.unreadView = ((TextView)localRelativeLayout.findViewById(2131438588));
    localMiniMsgUserParam.filterMsgType = 1;
    return localMiniMsgUserParam;
  }
  
  public void a(int paramInt, float paramFloat)
  {
    float f1 = paramFloat;
    if (paramFloat > 5.0F) {
      f1 = 1.0F;
    }
    RIJSPUtils.a("readinjoy_font_size_ratio_sp", Float.valueOf(f1));
    TKDHippyEventDispatcher.changeFontScale(f1);
    ReportUtil.a(this.g, "0X800B257", RIJJsonUtils.a(null, "font_size", Integer.valueOf(paramInt + 1)));
    F();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onFontSizeChange,index=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" ,textSizeRatio=");
    localStringBuilder.append(f1);
    QLog.d("FastWebActivity", 1, localStringBuilder.toString());
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    RIJSocialBottomUtils.a.a(paramInt1, paramInt2, paramBoolean, this, 2002, this.g, this.ae);
  }
  
  @VisibleForTesting
  void a(int paramInt, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    if (paramInt == 72) {
      a(paramActionSheetItem);
    }
    if (paramInt == 1)
    {
      O();
      return;
    }
    if (paramInt == 5)
    {
      P();
      return;
    }
    if (paramInt == 4)
    {
      Q();
      return;
    }
    if (paramInt == 13)
    {
      R();
      return;
    }
    if (paramInt == 6)
    {
      d(4);
      return;
    }
    if (paramInt == 11)
    {
      S();
      return;
    }
    if (paramInt == 21)
    {
      T();
      return;
    }
    if (paramInt == 7)
    {
      U();
      return;
    }
    if (paramInt == 26)
    {
      V();
      return;
    }
    if (paramInt == 68)
    {
      W();
      return;
    }
    if (paramInt == 70)
    {
      X();
      return;
    }
    if (paramInt == 82)
    {
      Y();
      return;
    }
    if (paramInt == 19)
    {
      b(paramActionSheetItem);
      return;
    }
    e(paramInt);
  }
  
  public void a(Intent paramIntent)
  {
    this.aD = true;
    doOnPause();
    doOnStop();
    VideoReport.pageLogicDestroy(this);
    RIJ3ClickUtils.a.a();
    Object localObject = this.G;
    if (localObject != null) {
      ((WebFastAdapter)localObject).d();
    }
    this.aD = false;
    localObject = new FastWebActivityStackUtil.SaveState();
    ((FastWebActivityStackUtil.SaveState)localObject).a = this.g;
    ((FastWebActivityStackUtil.SaveState)localObject).b = this.v.onSaveInstanceState();
    ((FastWebActivityStackUtil.SaveState)localObject).c = this.aC;
    ((FastWebActivityStackUtil.SaveState)localObject).d = this.al;
    ((FastWebActivityStackUtil.SaveState)localObject).e = this.ao;
    ((FastWebActivityStackUtil.SaveState)localObject).f = this.ap;
    this.L.a((FastWebActivityStackUtil.SaveState)localObject);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(RIJQQAppInterfaceUtil.d());
    ((StringBuilder)localObject).append(System.currentTimeMillis());
    this.aC = ((StringBuilder)localObject).toString();
    e(paramIntent);
    this.aD = true;
    doOnStart();
    doOnResume();
    this.aD = false;
    j();
    ThreadManager.getUIHandler().post(new FastWebActivity.28(this));
  }
  
  public void a(View paramView, String paramString1, String paramString2, String paramString3)
  {
    RIJDtParamBuilder localRIJDtParamBuilder = new RIJDtParamBuilder();
    Object localObject = this.ae;
    if (localObject == null) {
      localObject = "";
    } else {
      localObject = ((FastWebArticleInfo)localObject).q;
    }
    paramString2 = localRIJDtParamBuilder.e((String)localObject).b(Integer.valueOf(5)).a("1").f(paramString2).c(paramString3).a();
    RIJProteusDtFactory.a().setDtElementIdWithParams(paramView, paramString1, paramString2.c());
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
    this.T = bool;
    if (paramInt == 0)
    {
      a(paramAbsListView, this.R, true);
      return;
    }
    if (!this.T)
    {
      this.S = false;
      paramAbsListView.setInterpolator(null);
    }
  }
  
  public void a(BubblePopupWindow paramBubblePopupWindow)
  {
    this.P = paramBubblePopupWindow;
  }
  
  public void a(String paramString)
  {
    TextView localTextView = this.D;
    if (localTextView == null) {
      return;
    }
    localTextView.setText(paramString);
    this.D.setVisibility(0);
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2)
  {
    a(paramBoolean, paramString1, paramString2, 2130772482, 2130772481);
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (paramBoolean)
    {
      if (this.bg)
      {
        IColorNoteController localIColorNoteController = this.bb;
        if (localIColorNoteController != null) {
          localIColorNoteController.disableSwipe();
        }
      }
      this.bo.setVisibility(0);
      new Bundle().putBoolean("arg_comment_list_biu_btn", false);
      this.H.a(this.g, paramString1, paramString2, 1);
      if (!isFinishing())
      {
        paramString1 = getSupportFragmentManager().beginTransaction();
        paramString1.setCustomAnimations(paramInt1, paramInt2);
        paramString1.show(this.H);
        paramString1.commitAllowingStateLoss();
      }
      this.I = true;
      this.aT.c();
      this.O = 2;
      m(8);
      return;
    }
    if (this.bg)
    {
      paramString1 = this.bb;
      if (paramString1 != null) {
        paramString1.enableSwipe();
      }
    }
    this.bo.setVisibility(8);
    this.aT.b();
    if (!isFinishing())
    {
      paramString1 = getSupportFragmentManager().beginTransaction();
      if (!(TextUtils.isEmpty(paramString2) ^ true)) {
        paramString1.setCustomAnimations(paramInt1, paramInt2);
      }
      paramString1.hide(this.H);
      paramString1.commitAllowingStateLoss();
    }
    this.H.h();
    this.I = false;
    F();
    this.O = 1;
    m(0);
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
    Map localMap = URLUtil.a(this.g.mArticleContentUrl);
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
    if (((i2 & 0x4000) == 0L) && (TeamWorkConvertUtils.a(this.g.mArticleContentUrl)))
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
    localObject = this.bb;
    if ((localObject != null) && (((IColorNoteController)localObject).shouldDisplayColorNote()) && (this.bg)) {
      if (this.bb.isColorNoteExist())
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
  
  public void b()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("arg_article_info", this.g);
    localIntent.putExtra("readinjoy_open_comment_from_image", true);
    PublicFragmentActivity.a(this, localIntent, ReadInJoyCommentListFragment.class, 1001);
  }
  
  @TargetApi(23)
  public void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      getWindow().getDecorView().setSystemUiVisibility(9216);
      return;
    }
    getWindow().getDecorView().setSystemUiVisibility(0);
  }
  
  protected void c()
  {
    ReportInfo localReportInfo = new ReportInfo();
    Object localObject2 = this.g;
    if (localObject2 != null)
    {
      Object localObject3 = ((AbsBaseArticleInfo)localObject2).mSocialFeedInfo;
      localObject1 = new FeedsReportData();
      localReportInfo.mUin = RIJQQAppInterfaceUtil.c();
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
        ((FeedsReportData)localObject1).a = ((SocializeFeedsInfo)localObject3).a;
        if (((SocializeFeedsInfo)localObject3).c != null) {
          ((FeedsReportData)localObject1).b = ((SocializeFeedsInfo)localObject3).c.a;
        }
        ((FeedsReportData)localObject1).d = ((SocializeFeedsInfo)localObject3).h;
        ((FeedsReportData)localObject1).e = ((SocializeFeedsInfo)localObject3).j;
        localObject2 = ((SocializeFeedsInfo)localObject3).d;
        if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
        {
          ((FeedsReportData)localObject1).c = new ArrayList();
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (FeedsInfoUser)((Iterator)localObject2).next();
            if (localObject3 != null) {
              ((FeedsReportData)localObject1).c.add(Long.valueOf(((FeedsInfoUser)localObject3).a));
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
  
  public void c(int paramInt)
  {
    if (paramInt != 2)
    {
      if (paramInt != 4) {
        return;
      }
      ItemDatasListUtils.c(this.aj);
      F();
      return;
    }
    ItemDatasListUtils.b(this.aj);
    F();
  }
  
  public void d()
  {
    Object localObject = new ReadInJoyCommentUtils.CommentReportR5Builder(this.g, null).a(1);
    QLog.d("FastWebActivity", 1, "scrollToLastReadPos | begin");
    int i1;
    if (this.aR)
    {
      QLog.d("FastWebActivity", 1, "Scroll2CommentArea");
      i1 = this.aP;
      if (i1 == 0)
      {
        PublicAccountReportUtils.a((QQAppInterface)getAppInterface(), ReadInJoyCommentUtils.a(this.g), "0X8009C69", "0X8009C69", 0, 0, String.valueOf(this.g.mArticleID), String.valueOf(this.g.mStrategyId), this.g.innerUniqueID, "", false);
        QLog.d("FastWebActivity", 1, "mCommentAreaLastFirstVisItemPos == 0 return");
        return;
      }
      this.aU = 2;
      this.v.setSelectionFromTop(i1, this.aQ);
      this.aR = false;
      this.J = true;
      ((ReadInJoyCommentUtils.CommentReportR5Builder)localObject).b(1);
      this.aT.b();
      localObject = ((ReadInJoyCommentUtils.CommentReportR5Builder)localObject).a();
      PublicAccountReportUtils.a((QQAppInterface)getAppInterface(), ReadInJoyCommentUtils.a(this.g), "0X8009749", "0X8009749", 0, 0, String.valueOf(this.g.mArticleID), String.valueOf(this.g.mStrategyId), this.g.innerUniqueID, (String)localObject, false);
      i1 = this.aP;
    }
    else
    {
      QLog.d("FastWebActivity", 1, "Scroll2ArticleArea");
      this.v.setSelectionFromTop(this.aN, this.aO);
      i1 = this.aN;
      this.aR = true;
      ((ReadInJoyCommentUtils.CommentReportR5Builder)localObject).b(2);
      localObject = ((ReadInJoyCommentUtils.CommentReportR5Builder)localObject).a();
      PublicAccountReportUtils.a((QQAppInterface)getAppInterface(), ReadInJoyCommentUtils.a(this.g), "0X8009749", "0X8009749", 0, 0, String.valueOf(this.g.mArticleID), String.valueOf(this.g.mStrategyId), this.g.innerUniqueID, (String)localObject, false);
      this.aT.c();
    }
    QLog.d("FastWebActivity", 1, "scrollToLastReadPos | done");
    a(i1, this.ag);
  }
  
  public void doOnBackPressed()
  {
    ((IRIJFastWebVideoPlayerManager)QRoute.api(IRIJFastWebVideoPlayerManager.class)).setVideoPauseType(ReportConstants.VideoEndType.EXIT_SCENE);
    ReadInJoyShareHelperV2 localReadInJoyShareHelperV2 = this.M;
    if ((localReadInJoyShareHelperV2 != null) && (localReadInJoyShareHelperV2.d())) {
      return;
    }
    this.at = true;
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
    this.g = ((AbsBaseArticleInfo)((Bundle)localObject).get("fast_web_article_info"));
    this.ac = ((Bundle)localObject).getInt("fast_web_from_channel_id");
    this.bc = getIntent().getBooleanExtra("from_color_note", false);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("is from colorNote : ");
    localStringBuilder.append(this.bc);
    QLog.d("FastWebActivity", 1, localStringBuilder.toString());
    this.bg = SwipeLayoutUtils.a();
    if (this.g == null)
    {
      localObject = ((Bundle)localObject).getBundle("banner_webview_extra");
      if ((localObject != null) && (((Bundle)localObject).get("fast_web_article_info") != null))
      {
        this.g = ((AbsBaseArticleInfo)((Bundle)localObject).get("fast_web_article_info"));
        this.ad = ((Bundle)localObject).getInt("fast_web_banner_from_channel_id");
        this.aH = 1001;
        this.ao = ((Bundle)localObject).getBoolean("fast_web_from_article_recommend", false);
      }
      else
      {
        setResult(-10069, getIntent());
        finish();
        return true;
      }
    }
    this.aF = this.g.mStrategyId;
    this.aG = this.g.mAlgorithmID;
    this.h = this.g.mArticleID;
    this.i = this.g.innerUniqueID;
    this.j = this.g.mChannelID;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(RIJQQAppInterfaceUtil.d());
    ((StringBuilder)localObject).append(System.currentTimeMillis());
    this.aC = ((StringBuilder)localObject).toString();
    j();
    b(paramBundle);
    PublicAccountReportUtils.a(null, "CliOper", "", "", "0X8009C4F", "0X8009C4F", 0, 0, "", Long.toString(this.h), Integer.toString(this.aF), "", false);
    try
    {
      try
      {
        setContentView(2131626229);
        q();
      }
      catch (IllegalArgumentException paramBundle) {}catch (UnsupportedOperationException paramBundle) {}
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[doOnCreate] UnsupportedOperationException | IllegalArgumentException e = ");
      ((StringBuilder)localObject).append(paramBundle);
      QLog.e("FastWebActivity", 1, ((StringBuilder)localObject).toString());
      AIOUtils.a("Q.readinjoy.fast_web", "setContentView UnsupportedOperationException. This is not a crash!!!", new IllegalArgumentException());
      finish();
    }
    catch (OutOfMemoryError paramBundle)
    {
      label471:
      label492:
      break label471;
    }
    GlobalImageCache.a.evict(0);
    try
    {
      setContentView(2131626229);
      q();
    }
    catch (Throwable paramBundle)
    {
      break label492;
    }
    AIOUtils.a("Q.readinjoy.fast_web", "setContentView Throwable. This is not a crash!!!", new IllegalArgumentException());
    finish();
    paramBundle = this.G;
    if (paramBundle != null) {
      paramBundle.a();
    }
    l();
    m();
    ((IRIJFastWebVideoPlayerManager)QRoute.api(IRIJFastWebVideoPlayerManager.class)).onCreate();
    this.n = FastWebPTSDataConverter.b();
    D();
    n(RIJFeedsDynamicInsertConfig.a.a(5));
    return true;
  }
  
  protected void doOnDestroy()
  {
    as();
    ReadInJoyLogicEngineEventDispatcher.a().b(this.bG);
    ReadInJoyLogicEngineEventDispatcher.a().b(this.bF);
    Object localObject = this.G;
    if (localObject != null) {
      ((WebFastAdapter)localObject).d();
    }
    localObject = this.E;
    if (localObject != null) {
      ((FastWebMergeAdapter)localObject).b();
    }
    localObject = this.F;
    if (localObject != null) {
      ((ReadInJoyCommentListAdapter)localObject).e();
    }
    localObject = this.H;
    if (localObject != null) {
      ((ReadInJoySecondCommentListFragment)localObject).onDestroy();
    }
    aq();
    super.doOnDestroy();
    localObject = this.aJ;
    if (localObject != null) {
      ((Share)localObject).destroy();
    }
    this.aJ = null;
    localObject = this.al;
    if (localObject != null) {
      ((ItemShowDispatcher)localObject).a();
    }
    localObject = this.N;
    if (localObject != null) {
      ((ScreenShotShareHelper)localObject).a();
    }
    localObject = this.M;
    if (localObject != null) {
      ((ReadInJoyShareHelperV2)localObject).c();
    }
    ((IRIJFastWebAdService)QRoute.api(IRIJFastWebAdService.class)).cancelDisLikeAdPopWindow();
    localObject = this.an;
    if (localObject != null)
    {
      ((IFaceDecoder)localObject).setDecodeTaskCompletionListener(null);
      this.an = null;
    }
    localObject = this.B;
    if (localObject != null) {
      ((ReadInJoyFastWebBottomSocialViewNew)localObject).a();
    }
    VideoAutoPlayController.getInstance().mConfirmCanPlayInXg = false;
    localObject = ReadInJoyLogicEngine.a().d();
    if (localObject != null) {
      ((FastWebModule)localObject).unInitialize();
    }
    if (this.aV != null)
    {
      getMainLooper();
      Looper.myQueue().removeIdleHandler(this.aV);
    }
    ac();
    localObject = this.k;
    if (localObject != null)
    {
      ((MiniMsgUser)localObject).onBackground();
      if (!this.m) {
        MiniMsgIPCServer.a(this.k.getParam().businessName);
      }
    }
    this.K.b();
    this.K = null;
    ReadInJoyDropFrameHelper.d().b(5555, this);
    ReadInJoyDropFrameHelper.d().b(6666, this);
    localObject = this.bb;
    if (localObject != null)
    {
      ((IColorNoteController)localObject).onDestroy();
      QLog.d("FastWebActivity", 2, "mColorNoteController.onDestroy");
    }
    localObject = this.ag;
    if (localObject != null) {
      ReadInJoyUserInfoModule.a(((AuthorData)localObject).c);
    }
    localObject = this.bp;
    if (localObject != null) {
      ((RIJBiuAndCommentMixDataManager)localObject).a();
    }
    localObject = ReadInJoyLogicEngine.a().W();
    if (localObject != null) {
      ((FollowListInfoModule)localObject).b(this.t);
    }
    ((IRIJAdExposeFreshService)QRoute.api(IRIJAdExposeFreshService.class)).exitScene("RIJAdRefreshSceneNativeArticle");
    ((IRIJAdReqFreshService)QRoute.api(IRIJAdReqFreshService.class)).exitScene("RIJAdRefreshSceneNativeArticle");
    ((IRIJFastWebVideoPlayerManager)QRoute.api(IRIJFastWebVideoPlayerManager.class)).onDestroy();
    ((IRIJAdDownloadService)QRoute.api(IRIJAdDownloadService.class)).clearDownloadCache();
    localObject = this.bz;
    if (localObject != null) {
      ((RIJLiveStatusModule)localObject).b(this.bD);
    }
    ThreadManager.getUIHandler().removeCallbacks(this.u);
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
        if (this.N == null) {
          this.N = new ScreenShotShareHelper(this);
        }
        this.N.a(this.g.mArticleContentUrl);
        this.N.a((String)localObject, paramIntent.getStringExtra("image_path"), paramIntent.getIntExtra("EditPicType", 0));
      }
    }
  }
  
  protected void doOnPause()
  {
    if (!this.aD) {
      super.doOnPause();
    }
    Object localObject1;
    long l1;
    if (this.ae != null)
    {
      if (this.ak) {
        return;
      }
      AbstractGifImage.pauseAll();
      this.aT.c();
      Object localObject3 = this.g;
      if (this.ae.a()) {
        localObject1 = "2";
      } else {
        localObject1 = "1";
      }
      localObject1 = RIJTransMergeKanDianReport.a(this, (AbsBaseArticleInfo)localObject3, 0, (String)localObject1);
      try
      {
        float f1 = (float)(System.currentTimeMillis() - this.ax) / 1000.0F;
        float f2 = af();
        ((JSONObject)localObject1).put("read_time", f1);
        ((JSONObject)localObject1).put("read_ratio", f2);
        ((JSONObject)localObject1).put("session_id", this.aC);
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("");
        ((StringBuilder)localObject3).append(ReportUtil.a(this.ao, this.j));
        ((JSONObject)localObject1).put("channel_id", ((StringBuilder)localObject3).toString());
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("  time ");
        ((StringBuilder)localObject3).append(f1);
        ((StringBuilder)localObject3).append("  ratio : ");
        ((StringBuilder)localObject3).append(f2);
        ((StringBuilder)localObject3).append(" session : ");
        ((StringBuilder)localObject3).append(RIJLogUtil.a.a(this.aC));
        QLog.d("Q.readinjoy.fast_web", 2, ((StringBuilder)localObject3).toString());
      }
      catch (Exception localException)
      {
        QLog.e("Q.readinjoy.fast_web", 2, localException, new Object[] { "doOnPause" });
      }
      ReportUtil.a(this.g, "0X800898E", ((JSONObject)localObject1).toString());
      l1 = System.currentTimeMillis() - this.aE;
      if (this.aD) {}
    }
    for (;;)
    {
      try
      {
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("folder_status", RIJKanDianFolderStatus.reportFolderStatus);
        ((JSONObject)localObject1).put("algorithm_id", this.aG);
        ((JSONObject)localObject1).put("feeds_friends_interaction", 0);
        ((JSONObject)localObject1).put("session_id", this.aC);
        ((JSONObject)localObject1).put("os", "1");
        ((JSONObject)localObject1).put("version", "8.8.17".replace(".", ""));
        ((JSONObject)localObject1).put("rowkey", this.i);
        localObject4 = ((JSONObject)localObject1).toString();
        if (!ReadinjoyReportUtils.d(this.j)) {
          break label853;
        }
        localObject1 = "0X8009359";
        PublicAccountReportUtils.a(null, "CliOper", "", "", (String)localObject1, (String)localObject1, 0, 0, Long.toString(l1 / 1000L), Long.toString(this.h), Integer.toString(this.aF), (String)localObject4, false);
      }
      catch (JSONException localJSONException)
      {
        QLog.e("Q.readinjoy.fast_web", 2, localJSONException, new Object[] { "0X80066FB!" });
      }
      Object localObject2 = new ArrayList();
      Object localObject4 = new ReportInfo();
      ((ReportInfo)localObject4).mUin = RIJQQAppInterfaceUtil.c();
      ((ReportInfo)localObject4).mSource = 0;
      ((ReportInfo)localObject4).mSourceArticleId = this.h;
      ((ReportInfo)localObject4).mChannelId = ((int)this.j);
      ((ReportInfo)localObject4).mAlgorithmId = ((int)this.aG);
      ((ReportInfo)localObject4).mStrategyId = this.aF;
      ((ReportInfo)localObject4).mOperation = 9;
      ((ReportInfo)localObject4).mOpSource = 12;
      ((ReportInfo)localObject4).mReadTimeLength = ((int)(l1 / 1000L));
      ((ReportInfo)localObject4).mInnerId = this.i;
      int i1 = ae();
      ((ReportInfo)localObject4).mArticleLength = i1;
      ((ReportInfo)localObject4).mReadArticleLength = ((int)(i1 * af()));
      ((List)localObject2).add(localObject4);
      ThreadManager.getSubThreadHandler().post(new FastWebActivity.19(this, (List)localObject2));
      boolean bool = i(this.v.getLastVisiblePosition());
      localObject2 = this.G;
      if ((localObject2 != null) && (!bool)) {
        ((WebFastAdapter)localObject2).c();
      }
      if (c) {
        this.p = System.currentTimeMillis();
      }
      localObject2 = this.k;
      if ((localObject2 != null) && (!this.l)) {
        ((MiniMsgUser)localObject2).onBackground();
      }
      localObject2 = this.bb;
      if (localObject2 != null)
      {
        ((IColorNoteController)localObject2).onPause();
        QLog.d("FastWebActivity", 2, "mColorNoteController.onPause");
      }
      if (!bool) {
        ((IRIJFastWebVideoPlayerManager)QRoute.api(IRIJFastWebVideoPlayerManager.class)).onPause();
      }
      if ((am()) || (RIJXTabFrameUtils.INSTANCE.isNowInKanDianTab()))
      {
        this.bv.resetStationaryTime();
        this.bv.stopTiming();
      }
      localObject2 = this.C;
      if (localObject2 != null)
      {
        localObject2 = ((CommonAdBar)localObject2).getUIDelegate();
        if (localObject2 != null) {
          ((IUIDelegate)localObject2).h();
        }
      }
      if (isFinishing()) {
        aD();
      }
      return;
      label853:
      localObject2 = "0X80066FB";
    }
  }
  
  protected void doOnResume()
  {
    if (!this.aD) {
      super.doOnResume();
    }
    if (!this.aD) {
      this.aE = System.currentTimeMillis();
    }
    TimeUtil.b("fast_web_show_light_house_3");
    g();
    AbstractGifImage.resumeAll();
    this.ax = System.currentTimeMillis();
    F();
    Object localObject = this.G;
    if (localObject != null) {
      ((WebFastAdapter)localObject).b();
    }
    localObject = this.g;
    if (localObject != null) {
      TimeSliceHelper.c(((AbsBaseArticleInfo)localObject).innerUniqueID);
    }
    i();
    if (this.g != null) {
      ReadInJoyLogicEngine.a().d(this.g.innerUniqueID);
    }
    AppNetConnInfo.registerConnectionChangeReceiver(this, this.r);
    if (c)
    {
      if (b) {
        RIJFrameworkReportManager.a(4, this.p);
      }
      p();
    }
    o();
    localObject = this.k;
    if (localObject != null)
    {
      this.l = false;
      this.m = false;
      ((MiniMsgUser)localObject).onForeground();
    }
    localObject = this.bb;
    if (localObject != null)
    {
      ((IColorNoteController)localObject).onResume();
      QLog.d("FastWebActivity", 2, "mColorNoteController.onResume");
    }
    localObject = this.ag;
    if (localObject != null) {
      ((AuthorData)localObject).a(this.t);
    }
    this.bu = 0;
    if ((am()) || (RIJRewardTaskArticleTimer.isNowInKanDianTab()))
    {
      localObject = this.g;
      if ((localObject != null) && (!TextUtils.isEmpty(((AbsBaseArticleInfo)localObject).innerUniqueID)))
      {
        this.bv.resetStationaryTime();
        this.bv.startTiming(this.g.innerUniqueID, RIJRewardTaskConfig.d());
      }
    }
    localObject = this.C;
    if (localObject != null)
    {
      localObject = ((CommonAdBar)localObject).getUIDelegate();
      if (localObject != null) {
        ((IUIDelegate)localObject).g();
      }
    }
    ((IRIJFastWebVideoPlayerManager)QRoute.api(IRIJFastWebVideoPlayerManager.class)).onResume();
    SimpleEventBus.getInstance().dispatchEvent(new RIJFollowRecommendPopupCommand(2, null));
  }
  
  protected void doOnStart()
  {
    if (!this.aD) {
      super.doOnStart();
    }
  }
  
  protected void doOnStop()
  {
    if (!this.aD) {
      super.doOnStop();
    }
    AbsBaseArticleInfo localAbsBaseArticleInfo = this.g;
    if (localAbsBaseArticleInfo == null) {
      return;
    }
    TimeSliceHelper.d(localAbsBaseArticleInfo.innerUniqueID);
    if (!this.bd) {
      aC();
    }
    AppNetConnInfo.unregisterNetInfoHandler(this.r);
  }
  
  protected void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if (paramBoolean) {
      k();
    }
  }
  
  public void e()
  {
    Object localObject = this.G;
    int i1;
    if (localObject != null) {
      i1 = ((WebFastAdapter)localObject).getCount();
    } else {
      i1 = 0;
    }
    this.aP = i1;
    this.aQ = 0;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("initCommentAreaAnchor mCommentAreaLastFirstVisItemPos = ");
    ((StringBuilder)localObject).append(this.aP);
    QLog.d("FastWebActivity", 1, ((StringBuilder)localObject).toString());
  }
  
  public void f()
  {
    ItemDatasListUtils.b(this.aj);
    F();
    this.v.removeFooter();
  }
  
  public void finish()
  {
    QLog.d("FastWebActivity", 2, "mFloating ：finish");
    if ((this.bd) && (!this.be))
    {
      ai();
      return;
    }
    Object localObject;
    if (this.L.b())
    {
      if (this.bb == null) {
        u(this);
      }
      if ((this.bj) && (this.bg) && (this.bl))
      {
        localObject = this.bi;
        if ((localObject != null) && (!((CommonSuspensionGestureLayout)localObject).b()) && (!this.be))
        {
          aj();
          return;
        }
      }
      if ((this.bb != null) && (!this.be))
      {
        ai();
        return;
      }
      if (this.aH == 1001)
      {
        int i1 = this.ad;
        if (i1 == 70) {
          ((IKandianSubscribeManager)this.app.getRuntimeService(IKandianSubscribeManager.class)).lanuchKandianSubscribeActivity(this, 2);
        } else if (i1 == 0) {
          ReadInJoyActivityHelper.INSTANCE.launchFeedsActivity(this, 11, 0);
        } else if (DailyModeConfigHandler.c(i1)) {
          KandianDailyManagerSingleton.INSTANCE.launchKandianDaily(this);
        } else if (RIJShowKanDianTabSp.c()) {
          ReadInJoyActivityHelper.INSTANCE.launchReadInJoyTab(this, 11);
        }
      }
      if (this.bf != 0L) {
        ReportUtil.a(NetConnInfoCenter.getServerTime() - this.bf, this.g, this.ae, getApplicationContext());
      }
    }
    this.ai = true;
    ap();
    at();
    ak();
    ReadInJoyLogicEngineEventDispatcher.a().b(this.bG);
    ReadInJoyLogicEngineEventDispatcher.a().b(this.bF);
    if (this.g == null)
    {
      localObject = "";
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.g.mSubscribeID);
      ((StringBuilder)localObject).append("");
      localObject = ((StringBuilder)localObject).toString();
    }
    String str;
    if (this.at) {
      str = "1";
    } else {
      str = "2";
    }
    PublicAccountReportUtils.a(null, "CliOper", "", (String)localObject, "0X8008995", "0X8008995", 0, 0, str, null, null, null, false);
    aA();
    QLog.d("FastWebActivity", 2, "mFloating ：finish over");
  }
  
  public void g()
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
        if ((!SystemUtil.d()) && (!SystemUtil.g()))
        {
          this.mSystemBarComp.setStatusBarColor(-7829368);
          return;
        }
        this.mSystemBarComp.setStatusBarColor(-7829368);
        this.mSystemBarComp.setStatusBarDarkMode(true);
        return;
      }
      if ((Build.VERSION.SDK_INT >= 23) && (!SystemUtil.d()) && (!SystemUtil.g()))
      {
        b(true);
        this.mSystemBarComp.setStatusBarColor(-1);
        return;
      }
      if (!SystemUtil.g())
      {
        this.mSystemBarComp.setStatusBarColor(-2368549);
        return;
      }
      this.mSystemBarComp.setStatusBarColor(-1);
      this.mSystemBarComp.setStatusBarDarkMode(true);
    }
  }
  
  public void h()
  {
    BubblePopupWindow localBubblePopupWindow = this.P;
    if ((localBubblePopupWindow != null) && (localBubblePopupWindow.isShowing())) {
      this.P.dismiss();
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
      ax();
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
      l(paramInt2);
      return;
    }
    if (paramInt1 == 1)
    {
      k(paramInt2);
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
    if (this.I)
    {
      RIJTransMergeKanDianReport.a(1, 1, 5);
      a(false, null, null);
      h();
      return true;
    }
    return false;
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() != 2131436180) && (this.ae == null)) {
      return;
    }
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131444812: 
      a(true, false);
      return;
    case 2131437984: 
      paramView = this.H;
      if (paramView != null) {
        RIJTransMergeKanDianReport.a(1, paramView.a(), 4);
      }
      a(false, null, null);
      return;
    case 2131436227: 
      if (!this.v.isStackFromBottom()) {
        this.v.setStackFromBottom(true);
      }
      this.v.setStackFromBottom(false);
      return;
    case 2131436180: 
      this.at = true;
      ((IRIJFastWebVideoPlayerManager)QRoute.api(IRIJFastWebVideoPlayerManager.class)).setVideoPauseType(ReportConstants.VideoEndType.EXIT_SCENE);
      finish();
      return;
    case 2131433513: 
      a(paramView.getTag());
      return;
    }
    paramView = this.g;
    if (paramView != null) {
      FastWebPTSUtils.a(this, paramView, paramView.getSubscribeUin(), this.ae, 1);
    }
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (this.v != null)
    {
      paramInt1 = 0;
      while (paramInt1 < this.v.getChildCount())
      {
        BaseItemViewHolder localBaseItemViewHolder = (BaseItemViewHolder)this.v.getChildAt(paramInt1).getTag();
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
    this.m = true;
    ThreadManager.getUIHandler().post(new FastWebActivity.37(this));
  }
  
  public void onOpenMiniAIOCallback()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FastWebActivity", 2, "onOpenMiniAIOCallback..");
    }
    Object localObject1 = this.k;
    if ((localObject1 != null) && (this.g != null) && (this.ae != null)) {}
    for (;;)
    {
      try
      {
        this.l = true;
        localObject1 = ((MiniMsgUser)localObject1).getParam();
        ((MiniMsgUserParam)localObject1).backConversationIntent = RIJWebSearchUtils.a(this, this.g, this.ac, this.ao);
        ((MiniMsgUserParam)localObject1).isNeedBackConversation = true;
        AbsBaseArticleInfo localAbsBaseArticleInfo1 = this.g;
        AbsBaseArticleInfo localAbsBaseArticleInfo2 = this.g;
        int i1 = (int)this.g.mChannelID;
        boolean bool = this.ae.a();
        localObject2 = "2";
        if (bool) {
          localObject1 = "2";
        } else {
          localObject1 = "1";
        }
        ReportUtil.a(localAbsBaseArticleInfo1, "0X800A09C", RIJTransMergeKanDianReport.a(this, localAbsBaseArticleInfo2, i1, (String)localObject1).toString());
        localAbsBaseArticleInfo1 = this.g;
        localAbsBaseArticleInfo2 = this.g;
        i1 = (int)this.g.mChannelID;
        if (!this.ae.a()) {
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
    c(paramBundle);
    QLog.e("FastWebActivity", 2, "onSaveInstanceState(Bundle outState)");
    super.onSaveInstanceState(paramBundle);
  }
  
  public void onSaveInstanceState(Bundle paramBundle, PersistableBundle paramPersistableBundle)
  {
    c(paramBundle);
    QLog.e("FastWebActivity", 2, "onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState)");
    super.onSaveInstanceState(paramBundle, paramPersistableBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.FastWebActivity
 * JD-Core Version:    0.7.0.1
 */