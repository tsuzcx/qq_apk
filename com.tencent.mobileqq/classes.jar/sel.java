import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyChannelActivity;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.biu.ReadInJoyDeliverBiuActivity;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianSubscribeManager;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.ProteusItemView;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayActivity;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.13;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.14;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.33;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.36;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.38;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.39;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.4;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.43;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyHeadImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNickNameTextView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.parse.ProteusParserWithHotReload;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.parse.ProteusParserWithHotReload.IHotReloadChangedObserver;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.biz.pubaccount.readinjoy.view.widget.RoundAngleFrameLayout;
import com.tencent.biz.pubaccount.util.PreloadManager;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionPreloadManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.theme.TextHook;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
import cooperation.plugin.PluginBaseActivity;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import tencent.im.oidb.articlesummary.articlesummary.PartnerAccountInfo;
import tencent.im.oidb.articlesummary.articlesummary.VideoDownloadBarInfo;
import tencent.im.oidb.articlesummary.articlesummary.WeishiUGInfo;

public abstract class sel
  extends aaye
  implements View.OnClickListener, View.OnLongClickListener, blni, rws, rxb
{
  public static float a;
  public static int a;
  static qai jdField_a_of_type_Qai = new qai();
  public static int b;
  public static int f;
  static final int jdField_g_of_type_Int = Color.parseColor("#999999");
  static final int jdField_h_of_type_Int = Color.parseColor("#262626");
  private static int jdField_j_of_type_Int;
  private static int jdField_k_of_type_Int;
  public long a;
  public Activity a;
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  protected Drawable a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private SparseArray<pmk> jdField_a_of_type_AndroidUtilSparseArray;
  protected LayoutInflater a;
  private AnimationSet jdField_a_of_type_AndroidViewAnimationAnimationSet;
  private aohg jdField_a_of_type_Aohg = new sft(this);
  public blih a;
  private blmm jdField_a_of_type_Blmm;
  private blms jdField_a_of_type_Blms;
  protected VideoPreDownloadMgr a;
  public ReadInJoyXListView a;
  private VafContext jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext = new qfg();
  private ProteusParserWithHotReload.IHotReloadChangedObserver jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewParseProteusParserWithHotReload$IHotReloadChangedObserver = new sfu(this);
  public GdtHandler.Params a;
  public INetInfoHandler a;
  private Runnable jdField_a_of_type_JavaLangRunnable = new ReadInJoyBaseAdapter.33(this);
  public ArrayList<qvp> a;
  private HashMap<Integer, sga> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  public HashSet<String> a;
  protected List<Object> a;
  protected Map<Long, qvp> a;
  protected Set<Long> a;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new MqqHandler();
  private nzj jdField_a_of_type_Nzj;
  public pmw a;
  protected rmg a;
  private rmn jdField_a_of_type_Rmn;
  public rvy a;
  public rwc a;
  protected rwr a;
  private rxb jdField_a_of_type_Rxb;
  private sbi jdField_a_of_type_Sbi;
  private sdz jdField_a_of_type_Sdz;
  private sga jdField_a_of_type_Sga = new seq(this);
  protected sgc a;
  protected sgd a;
  protected sge a;
  protected sgf a;
  private sgg jdField_a_of_type_Sgg;
  public sgm a;
  smw jdField_a_of_type_Smw = new smw();
  private syh jdField_a_of_type_Syh;
  private tpn jdField_a_of_type_Tpn;
  twz jdField_a_of_type_Twz = new sfq(this);
  public boolean a;
  public long b;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private AnimationSet jdField_b_of_type_AndroidViewAnimationAnimationSet;
  private blih jdField_b_of_type_Blih = new sfm(this);
  private ArrayList<sdz> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  public HashSet<String> b;
  public List<BaseArticleInfo> b;
  protected Set<Long> b;
  private sga jdField_b_of_type_Sga = new ser(this);
  public boolean b;
  public int c;
  private long jdField_c_of_type_Long = -1L;
  private blih jdField_c_of_type_Blih = new sfn(this);
  private sga jdField_c_of_type_Sga = new ses(this);
  public boolean c;
  protected int d;
  private long jdField_d_of_type_Long;
  private sga jdField_d_of_type_Sga = new set(this);
  protected boolean d;
  public int e;
  private sga e;
  protected boolean e;
  private sga f;
  protected boolean f;
  private sga jdField_g_of_type_Sga = new sex(this);
  protected boolean g;
  private sga jdField_h_of_type_Sga = new sey(this);
  public boolean h;
  int jdField_i_of_type_Int = -1;
  private sga jdField_i_of_type_Sga = new sfe(this);
  public boolean i;
  private sga jdField_j_of_type_Sga = new sfg(this);
  protected boolean j;
  private sga jdField_k_of_type_Sga = new sfh(this);
  private boolean jdField_k_of_type_Boolean;
  private int jdField_l_of_type_Int;
  private sga jdField_l_of_type_Sga = new sfj(this);
  private boolean jdField_l_of_type_Boolean = true;
  private sga jdField_m_of_type_Sga = new sfk(this);
  private boolean jdField_m_of_type_Boolean;
  private sga jdField_n_of_type_Sga = new sfl(this);
  private boolean jdField_n_of_type_Boolean;
  private boolean o;
  private boolean p;
  
  static
  {
    jdField_a_of_type_Int = 20;
    jdField_b_of_type_Int = 250;
    jdField_f_of_type_Int = 1000;
    jdField_j_of_type_Int = 10;
    jdField_k_of_type_Int = 10;
    jdField_a_of_type_Float = ViewConfiguration.getScrollFriction();
    if (Build.VERSION.SDK_INT < 21) {
      jdField_a_of_type_Float = 0.025F;
    }
  }
  
  public sel(Activity paramActivity, LayoutInflater paramLayoutInflater, int paramInt, ListView paramListView, SparseArray<pmk> paramSparseArray)
  {
    this.jdField_c_of_type_Int = -1;
    this.jdField_e_of_type_Int = -1;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_e_of_type_Boolean = true;
    this.jdField_a_of_type_Long = -2147483648L;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_e_of_type_Sga = new seu(this);
    this.jdField_f_of_type_Sga = new sew(this);
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_b_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_a_of_type_Blih = new sgi(this, null);
    this.jdField_a_of_type_Sgm = new sfo(this);
    this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new sgb(this, null);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidViewLayoutInflater = paramLayoutInflater;
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.setContext(paramActivity);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.setCurActivity(paramActivity);
    this.jdField_e_of_type_Int = ozs.d();
    oyj.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, "default_feeds");
    jdField_a_of_type_Qai.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView = ((ReadInJoyXListView)paramListView);
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    a(paramSparseArray);
    this.jdField_a_of_type_Sbi = new sbi(paramActivity);
    v();
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView instanceof ReadInJoyXListView)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setOnDrawCompleteListener(this.jdField_a_of_type_Sgm);
    }
    this.jdField_a_of_type_AndroidOsHandler = new sem(this, Looper.getMainLooper());
    r();
    q();
    t();
    ((ReadInJoyXListView)paramListView).a(this);
  }
  
  public static int a(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo == null) || (paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyl == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyBaseAdapter", 2, "ugc feeds info is null");
      }
      return 21;
    }
    switch (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyl.jdField_a_of_type_Int)
    {
    case 1: 
    default: 
      return 21;
    case 2: 
    case 3: 
      if ((paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int == 9) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyl.jdField_a_of_type_JavaUtilArrayList.size() > 1)) {
        return 36;
      }
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qxw != null) {
        return 80;
      }
      return 22;
    case 4: 
    case 5: 
      return 23;
    }
    if (paramArticleInfo.isWeishiGridTwoItemFeed()) {
      return 70;
    }
    if (paramArticleInfo.isTwoItemVideoFeed()) {
      return 46;
    }
    if (paramArticleInfo.mChannelID == 0L) {
      return 71;
    }
    if ((paramArticleInfo.mChannelID == 70L) || (paramArticleInfo.mChannelID == 41403L)) {
      return 23;
    }
    return 4;
  }
  
  public static int a(ArticleInfo paramArticleInfo, int paramInt)
  {
    return sgj.a.a(paramArticleInfo, paramInt);
  }
  
  public static int a(ListView paramListView, rwc paramrwc)
  {
    if (paramrwc != null)
    {
      paramrwc = paramListView.getChildAt(paramrwc.jdField_a_of_type_Int + paramListView.getHeaderViewsCount() - paramListView.getFirstVisiblePosition());
      if (paramrwc != null) {
        return paramrwc.getBottom() - agej.a(175.0F, paramListView.getResources());
      }
    }
    return 0;
  }
  
  private Drawable a()
  {
    if (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable == null) {
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(0);
    }
    return this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  private Bundle a(rwc paramrwc, BaseArticleInfo paramBaseArticleInfo)
  {
    Bundle localBundle1 = new Bundle();
    label111:
    boolean bool;
    label148:
    label170:
    label303:
    label436:
    int i1;
    label410:
    Bundle localBundle2;
    if (paramrwc.jdField_f_of_type_Int == 1)
    {
      localBundle1.putString("VIDEO_PUB_ACCOUNT_UIN", paramBaseArticleInfo.mSubscribeID);
      localBundle1.putString("VIDEO_PUB_ACCOUNT_NAME", paramBaseArticleInfo.mSubscribeName);
      if (paramrwc.jdField_f_of_type_Int != 6) {
        break label1267;
      }
      localBundle1.putString("VIDEO_H5_URL", ((qyn)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyl.jdField_b_of_type_JavaUtilArrayList.get(0)).h);
      localBundle1.putString("VIDEO_CREATE_TIME", ozr.a(((qyn)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyl.jdField_b_of_type_JavaUtilArrayList.get(0)).jdField_e_of_type_Int, true));
      localBundle1.putString("VIDEO_TIME", String.valueOf(paramrwc.jdField_b_of_type_Int));
      if (paramBaseArticleInfo.mVideoJsonWidth == 0) {
        break label1298;
      }
      localBundle1.putString("VIDEO_WIDTH", String.valueOf(paramBaseArticleInfo.mVideoJsonWidth));
      if (paramBaseArticleInfo.mVideoJsonHeight == 0) {
        break label1341;
      }
      localBundle1.putString("VIDEO_HEIGHT", String.valueOf(paramBaseArticleInfo.mVideoJsonHeight));
      localBundle1.putString("VIDEO_VID", paramrwc.jdField_c_of_type_JavaLangString);
      localBundle1.putString("VIDEO_COVER", paramrwc.jdField_b_of_type_JavaLangString);
      localBundle1.putLong("VIDEO_XG_FILE_SIZE", paramBaseArticleInfo.mXGFileSize);
      localBundle1.putInt("VIDEO_STRATEGY_ID", paramBaseArticleInfo.mStrategyId);
      localBundle1.putLong("VIDEO_ALGORITHM_ID", paramBaseArticleInfo.mAlgorithmID);
      localBundle1.putString("VIDEO_SECOND_INDEX_INNER_ID", paramrwc.jdField_n_of_type_JavaLangString);
      if ((this.jdField_a_of_type_Pmw == null) || (this.jdField_a_of_type_Pmw.a() == null) || (this.jdField_a_of_type_Rvy == null) || (this.jdField_a_of_type_Pmw.a().jdField_c_of_type_Long != paramrwc.jdField_c_of_type_Long)) {
        break label1384;
      }
      localBundle1.putLong("VIDEO_PLAY_POSITION", this.jdField_a_of_type_Rvy.a());
      if (paramrwc.jdField_f_of_type_Int != 6) {
        break label1396;
      }
      localBundle1.putString("VIDEO_ARTICLE_ID", ((qyn)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyl.jdField_b_of_type_JavaUtilArrayList.get(0)).jdField_g_of_type_JavaLangString);
      localBundle1.putLong("VIDEO_FEED_ID", paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qxr.jdField_a_of_type_JavaLangLong.longValue());
      localBundle1.putInt("VIDEO_FEED_TYPE", paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qxr.b.intValue());
      localBundle1.putString("VIDEO_TITLE", ((qyn)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyl.jdField_b_of_type_JavaUtilArrayList.get(0)).jdField_e_of_type_JavaLangString);
      localBundle1.putBoolean("IS_FROM_READINJOY_VIDEO_CHANNEL", bnrf.a(this.jdField_d_of_type_Int));
      if (paramrwc.jdField_f_of_type_Int != 1) {
        break label1423;
      }
      bool = true;
      localBundle1.putBoolean("VIDEO_IS_FROM_PUBLIC_ACCOUNT", bool);
      localBundle1.putString("VIDEO_RECOMMEND_REASON", paramBaseArticleInfo.mRecommentdReason);
      localBundle1.putBoolean("isFromKandian", true);
      localBundle1.putLong("channelID", paramBaseArticleInfo.mChannelID);
      localBundle1.putLong("algorithmID", paramBaseArticleInfo.mAlgorithmID);
      localBundle1.putString("innderId", paramBaseArticleInfo.innerUniqueID);
      localBundle1.putLong("strategyId", paramBaseArticleInfo.mStrategyId);
      if (!TextUtils.isEmpty(paramBaseArticleInfo.mArticleFriendLikeText)) {
        break label1429;
      }
      i1 = 0;
      label528:
      localBundle1.putInt("interactionType", i1);
      localBundle1.putString("VIDEO_THIRD_ICON", paramrwc.jdField_d_of_type_JavaLangString);
      localBundle1.putString("VIDEO_THIRD_NAME", paramrwc.jdField_e_of_type_JavaLangString);
      localBundle1.putString("VIDEO_THIRD_ACTION", paramrwc.jdField_f_of_type_JavaLangString);
      localBundle1.putString("VIDEO_THIRD_URL", paramrwc.jdField_g_of_type_JavaLangString);
      localBundle1.putLong("VIDEO_THRID_URL_EXPIRE_TIME", paramrwc.jdField_f_of_type_Long);
      localBundle1.putInt("VIDEO_ARTICLE_BUSITYPE", paramrwc.jdField_f_of_type_Int);
      localBundle2 = new Bundle();
      localBundle2.putString("VINFO", paramrwc.jdField_c_of_type_JavaLangString);
      localBundle2.putString("TINFO", paramrwc.jdField_c_of_type_JavaLangString);
      localBundle2.putInt("PREVIEW_VIDEO_TIME", paramrwc.jdField_b_of_type_Int);
      if (this.jdField_a_of_type_Rvy != null) {
        break label1434;
      }
      i1 = 0;
      label663:
      localBundle2.putInt("PREVIEW_START_POSI", rwe.a(i1, paramrwc.jdField_b_of_type_Int));
      localBundle2.putInt("PREVIEW_VIDEO_WIDTH", paramrwc.jdField_c_of_type_Int);
      localBundle2.putInt("PREVIEW_VIDEO_HEIGHT", paramrwc.jdField_d_of_type_Int);
      localBundle2.putInt("FULL_VIDEO_TIME", paramrwc.jdField_b_of_type_Int);
      localBundle2.putString("source_puin", paramBaseArticleInfo.mSubscribeID);
      if (paramrwc.jdField_f_of_type_Int != 1) {
        break label1446;
      }
      localBundle2.putString("ACCOUNT_UIN", paramBaseArticleInfo.mSubscribeID);
      localBundle2.putString("ACCOUNT_NAME", paramBaseArticleInfo.mSubscribeName);
      label759:
      if ((paramrwc.jdField_f_of_type_Int != 6) || (paramBaseArticleInfo.mSocialFeedInfo == null) || (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyl == null) || (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyl.jdField_b_of_type_JavaUtilArrayList == null) || (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyl.jdField_b_of_type_JavaUtilArrayList.size() <= 0)) {
        break label1473;
      }
      localBundle2.putString("compatible_text", ((qyn)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyl.jdField_b_of_type_JavaUtilArrayList.get(0)).jdField_e_of_type_JavaLangString + ": " + ((qyn)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyl.jdField_b_of_type_JavaUtilArrayList.get(0)).h);
      localBundle2.putInt("req_type", 125);
      label894:
      localBundle2.putInt("TYPE", paramrwc.jdField_f_of_type_Int);
      localBundle2.putString("ARTICLE_ID", paramBaseArticleInfo.innerUniqueID);
      localBundle2.putInt("layout_item", 5);
      localBundle2.putBoolean("video_url_load", false);
      localBundle2.putString("image_url_remote", paramrwc.jdField_b_of_type_JavaLangString);
      if (paramBaseArticleInfo.aioShareUrl == null) {
        break label1487;
      }
      localBundle2.putString("detail_url", paramBaseArticleInfo.aioShareUrl);
    }
    for (;;)
    {
      localBundle2.putString("video_url", paramrwc.jdField_c_of_type_JavaLangString);
      localBundle2.putString("title", paramBaseArticleInfo.mTitle);
      localBundle2.putString("req_create_time", ozr.a(paramBaseArticleInfo.mTime));
      localBundle2.putString("brief_key", paramBaseArticleInfo.mTitle);
      localBundle1.putByteArray("STRUCT_MSG_BYTES", ((StructMsgForGeneralShare)bdow.a(localBundle2)).getBytes());
      localBundle1.putString("VIDEO_SUBS_TEXT", paramBaseArticleInfo.mVideoArticleSubsText);
      localBundle1.putString("VIDEO_SUBS_COLOR", paramBaseArticleInfo.mVideoArticleSubsColor);
      localBundle1.putString("KEY_VIDEO_JSON_LIST", paramBaseArticleInfo.mJsonVideoList);
      localBundle1.putInt("VIDEO_PLAY_COUNT", paramBaseArticleInfo.mVideoPlayCount);
      return localBundle1;
      if (paramrwc.jdField_f_of_type_Int == 6)
      {
        if (g(paramBaseArticleInfo)) {
          localBundle1.putString("VIDEO_PUB_ACCOUNT_UIN", "" + paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qxt.jdField_a_of_type_Long);
        }
        for (;;)
        {
          localBundle1.putString("VIDEO_PUB_ACCOUNT_NAME", paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyl.jdField_b_of_type_JavaLangString);
          if (q((ArticleInfo)paramBaseArticleInfo)) {
            break;
          }
          localBundle1.putString("VIDEO_URL", ((qyn)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyl.jdField_b_of_type_JavaUtilArrayList.get(0)).jdField_b_of_type_JavaLangString);
          break;
          localBundle1.putString("VIDEO_PUB_ACCOUNT_UIN", "" + paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyl.jdField_a_of_type_Long);
        }
      }
      localBundle1.putString("VIDEO_PUB_ACCOUNT_UIN", paramBaseArticleInfo.thirdUin);
      localBundle1.putString("VIDEO_PUB_ACCOUNT_NAME", paramBaseArticleInfo.thirdUinName);
      break;
      label1267:
      localBundle1.putString("VIDEO_H5_URL", paramBaseArticleInfo.mArticleContentUrl);
      localBundle1.putString("VIDEO_CREATE_TIME", ozr.a(paramBaseArticleInfo.mTime, true));
      break label111;
      label1298:
      if (paramrwc.jdField_f_of_type_Int != 6) {
        break label148;
      }
      localBundle1.putString("VIDEO_WIDTH", String.valueOf(((qyn)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyl.jdField_b_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Int));
      break label148;
      label1341:
      if (paramrwc.jdField_f_of_type_Int != 6) {
        break label170;
      }
      localBundle1.putString("VIDEO_HEIGHT", String.valueOf(((qyn)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyl.jdField_b_of_type_JavaUtilArrayList.get(0)).jdField_b_of_type_Int));
      break label170;
      label1384:
      localBundle1.putLong("VIDEO_PLAY_POSITION", 0L);
      break label303;
      label1396:
      localBundle1.putString("VIDEO_ARTICLE_ID", paramBaseArticleInfo.innerUniqueID);
      localBundle1.putString("VIDEO_TITLE", paramBaseArticleInfo.mTitle);
      break label410;
      label1423:
      bool = false;
      break label436;
      label1429:
      i1 = 1;
      break label528;
      label1434:
      i1 = (int)this.jdField_a_of_type_Rvy.a();
      break label663;
      label1446:
      localBundle2.putString("ACCOUNT_UIN", paramBaseArticleInfo.thirdUin);
      localBundle2.putString("ACCOUNT_NAME", paramBaseArticleInfo.thirdUinName);
      break label759;
      label1473:
      localBundle2.putInt("req_type", 140);
      break label894;
      label1487:
      localBundle2.putString("detail_url", paramBaseArticleInfo.mArticleContentUrl + "&sourcefrom=0");
    }
  }
  
  public static QQAppInterface a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  public static String a(long paramLong)
  {
    long l1 = (paramLong >>> 1) / 5L;
    return Long.toString(l1) + (paramLong - 10L * l1);
  }
  
  public static String a(ArticleInfo paramArticleInfo, int paramInt)
  {
    if ((jdField_a_of_type_Qai != null) && (qai.a(paramArticleInfo)))
    {
      paramArticleInfo = jdField_a_of_type_Qai.a(paramArticleInfo);
      QLog.d("ReadInJoyBaseAdapter", 2, "getProteusFamilyCardViewType | dynamic viewType : " + paramArticleInfo);
      return paramArticleInfo;
    }
    paramArticleInfo = String.valueOf(a(paramArticleInfo, paramInt));
    QLog.d("ReadInJoyBaseAdapter", 2, "getProteusFamilyCardViewType | normal viewType : " + paramArticleInfo);
    return paramArticleInfo;
  }
  
  public static String a(String paramString, Map<String, Object> paramMap)
  {
    JSONObject localJSONObject;
    if ((paramMap != null) && (paramMap.size() > 0)) {
      try
      {
        localJSONObject = new JSONObject(paramString);
        paramMap = paramMap.entrySet().iterator();
        while (paramMap.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)paramMap.next();
          localJSONObject.put((String)localEntry.getKey(), localEntry.getValue());
          continue;
          return paramString;
        }
      }
      catch (Exception paramMap)
      {
        QLog.e("ReadInJoyBaseAdapter", 1, paramMap.getMessage());
      }
    }
    paramMap = localJSONObject.toString();
    return paramMap;
  }
  
  public static JSONArray a(String paramString1, String paramString2)
  {
    paramString1 = a(paramString1);
    if ((paramString1 == null) || (paramString1.length() <= 0)) {
      paramString1 = null;
    }
    do
    {
      return paramString1;
      paramString2 = paramString1.optJSONArray(paramString2);
      if (paramString2 == null) {
        break;
      }
      paramString1 = paramString2;
    } while (paramString2.length() > 0);
    return null;
  }
  
  public static JSONObject a(String paramString)
  {
    try
    {
      paramString = (JSONObject)new JSONTokener(paramString).nextValue();
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  private pmw a(AbsListView paramAbsListView)
  {
    Object localObject;
    if ((!a()) || (this.jdField_a_of_type_Rmn == null) || (paramAbsListView.getChildCount() <= 0))
    {
      localObject = null;
      return localObject;
    }
    int i1 = 0;
    label27:
    if (i1 < paramAbsListView.getChildCount())
    {
      View localView = paramAbsListView.getChildAt(i1);
      if ((localView.getTag() instanceof pmw))
      {
        localObject = (pmw)localView.getTag();
        if (!((pmw)localObject).a(localView)) {}
      }
    }
    for (paramAbsListView = (AbsListView)localObject;; paramAbsListView = null)
    {
      localObject = paramAbsListView;
      if (paramAbsListView != null) {
        break;
      }
      localObject = paramAbsListView;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.w("Q.readinjoy.video", 2, "checkPlayableArea(): no item can auto play...");
      return paramAbsListView;
      i1 += 1;
      break label27;
    }
  }
  
  private pqk a(ArticleInfo paramArticleInfo, int paramInt1, int paramInt2)
  {
    b(paramInt2);
    ArticleInfo localArticleInfo = null;
    if (paramInt2 < getCount() - 1) {
      localArticleInfo = (ArticleInfo)b(paramInt2 + 1);
    }
    return new pqk(this.jdField_a_of_type_AndroidAppActivity, paramArticleInfo, paramInt1, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, paramInt2, this.jdField_c_of_type_Boolean, getCount(), localArticleInfo, this);
  }
  
  public static rwc a(BaseArticleInfo paramBaseArticleInfo)
  {
    return a(paramBaseArticleInfo, false);
  }
  
  public static rwc a(BaseArticleInfo paramBaseArticleInfo, boolean paramBoolean)
  {
    rwc localrwc = new rwc();
    localrwc.jdField_c_of_type_JavaLangString = paramBaseArticleInfo.getVideoVid();
    localrwc.jdField_c_of_type_Long = paramBaseArticleInfo.mArticleID;
    localrwc.jdField_b_of_type_Int = paramBaseArticleInfo.getVideoDuration();
    localrwc.jdField_c_of_type_Int = paramBaseArticleInfo.getVideoWidth();
    localrwc.jdField_d_of_type_Int = paramBaseArticleInfo.getVideoHeight();
    localrwc.jdField_a_of_type_Long = paramBaseArticleInfo.mXGFileSize;
    localrwc.jdField_a_of_type_JavaLangString = paramBaseArticleInfo.mTitle;
    Object localObject;
    if (paramBaseArticleInfo.getVideoCoverUrlWithSmartCut(false) == null)
    {
      localObject = null;
      localrwc.jdField_b_of_type_JavaLangString = ((String)localObject);
      localrwc.jdField_k_of_type_JavaLangString = paramBaseArticleInfo.getSubscribeUin();
      localrwc.jdField_g_of_type_Int = paramBaseArticleInfo.mStrategyId;
      localrwc.jdField_g_of_type_Long = paramBaseArticleInfo.mAlgorithmID;
      localObject = new qwv();
      ((qwv)localObject).jdField_a_of_type_JavaLangLong = Long.valueOf(paramBaseArticleInfo.mArticleID);
      ((qwv)localObject).jdField_a_of_type_JavaLangString = paramBaseArticleInfo.innerUniqueID;
      ((qwv)localObject).jdField_b_of_type_JavaLangString = paramBaseArticleInfo.getVideoVid();
      ((qwv)localObject).jdField_a_of_type_Int = paramBaseArticleInfo.busiType;
      ((qwv)localObject).jdField_j_of_type_Int = paramBaseArticleInfo.getVideoWidth();
      ((qwv)localObject).jdField_k_of_type_Int = paramBaseArticleInfo.getVideoHeight();
      ((qwv)localObject).s = paramBaseArticleInfo.getVideoDuration();
      ((qwv)localObject).o = 0;
      ((qwv)localObject).p = 0;
      ((qwv)localObject).q = 0;
      ((qwv)localObject).jdField_f_of_type_Boolean = false;
      ((qwv)localObject).jdField_g_of_type_Boolean = false;
      ((qwv)localObject).jdField_h_of_type_Boolean = false;
      ((qwv)localObject).jdField_f_of_type_JavaLangString = "";
      localrwc.jdField_a_of_type_Qwv = ((qwv)localObject);
      localrwc.jdField_d_of_type_JavaLangString = paramBaseArticleInfo.thirdIcon;
      localrwc.jdField_e_of_type_JavaLangString = paramBaseArticleInfo.thirdName;
      localrwc.jdField_f_of_type_JavaLangString = paramBaseArticleInfo.thirdAction;
      localrwc.jdField_f_of_type_Int = paramBaseArticleInfo.busiType;
      localrwc.jdField_j_of_type_JavaLangString = paramBaseArticleInfo.getInnerUniqueID();
      localrwc.jdField_b_of_type_Long = paramBaseArticleInfo.mChannelID;
      localrwc.jdField_g_of_type_JavaLangString = paramBaseArticleInfo.mThirdVideoURL;
      localrwc.jdField_f_of_type_Long = paramBaseArticleInfo.mThirdVideoURLExpireTime;
      localrwc.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = paramBaseArticleInfo;
      if (!paramBoolean) {
        break label402;
      }
    }
    label402:
    for (int i1 = 3;; i1 = 0)
    {
      localrwc.jdField_m_of_type_Int = i1;
      if (c((ArticleInfo)paramBaseArticleInfo) == 4) {
        localrwc.jdField_c_of_type_Boolean = true;
      }
      if ((paramBaseArticleInfo.mChannelID == 56L) && (ozs.u()))
      {
        i1 = bhgr.a(BaseApplicationImpl.getApplication().getApplicationContext(), 8.0F);
        localrwc.o = i1;
        localrwc.p = i1;
        localrwc.q = i1;
        localrwc.r = i1;
      }
      return localrwc;
      localObject = paramBaseArticleInfo.getVideoCoverUrlWithSmartCut(false).getPath();
      break;
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyBaseAdapter", 2, "preloadImg start:" + paramInt1 + " count:" + paramInt2);
    }
    long l1 = System.currentTimeMillis();
    if (!bhnv.h(this.jdField_a_of_type_AndroidAppActivity)) {
      return;
    }
    ArrayList localArrayList = new ArrayList(this.jdField_b_of_type_JavaUtilList);
    ThreadManager.post(new ReadInJoyBaseAdapter.4(this, this.jdField_d_of_type_Long, localArrayList, paramInt1, paramInt2, l1), 5, null, true);
  }
  
  private void a(SparseArray<pmk> paramSparseArray)
  {
    this.jdField_a_of_type_AndroidUtilSparseArray = paramSparseArray;
    int i1 = 0;
    while (i1 < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      ((pmk)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i1)).a(this);
      i1 += 1;
    }
  }
  
  private void a(View paramView1, View paramView2)
  {
    a(paramView1, true);
    a(paramView2, false);
  }
  
  private void a(View paramView, pnd parampnd, BaseArticleInfo paramBaseArticleInfo)
  {
    int i1 = parampnd.jdField_a_of_type_Int;
    parampnd = new sez(this, i1, parampnd, paramBaseArticleInfo);
    if (AdvertisementInfo.isAdvertisementInfo(paramBaseArticleInfo))
    {
      if ((this.jdField_a_of_type_Blmm != null) && (this.jdField_a_of_type_Blmm.isShowing())) {
        this.jdField_a_of_type_Blmm.dismiss();
      }
      this.jdField_a_of_type_Blms.a(i1, this.jdField_c_of_type_Int, ozs.a(paramBaseArticleInfo), ((AdvertisementInfo)paramBaseArticleInfo).mAdDislikeInfos);
      this.jdField_a_of_type_Blms.a(paramView, parampnd);
      this.jdField_a_of_type_Blms.a(new sfb(this, paramBaseArticleInfo));
      this.jdField_a_of_type_Blms.setOnDismissListener(new sfc(this));
      return;
    }
    if ((this.jdField_a_of_type_Blms != null) && (this.jdField_a_of_type_Blms.isShowing())) {
      this.jdField_a_of_type_Blms.dismiss();
    }
    this.jdField_a_of_type_Blmm.a(i1, this.jdField_c_of_type_Int, ozs.a(paramBaseArticleInfo), paramBaseArticleInfo.mDislikeInfos, paramBaseArticleInfo.innerUniqueID);
    this.jdField_a_of_type_Blmm.a(paramView, parampnd);
    this.jdField_a_of_type_Blmm.setOnDismissListener(new sfd(this));
  }
  
  private void a(View paramView, boolean paramBoolean)
  {
    paramView.getPaddingLeft();
    int i3 = paramView.getPaddingTop();
    paramView.getPaddingRight();
    int i4 = paramView.getPaddingBottom();
    int i1;
    int i2;
    if (ozs.u())
    {
      i1 = bhgr.a(a(), 8.0F);
      if (!paramBoolean) {
        break label79;
      }
      i2 = e();
      i1 /= 2;
    }
    for (;;)
    {
      paramView.setPadding(i2, i3, i1, i4);
      return;
      i1 = bhgr.a(a(), 3.0F);
      break;
      label79:
      i2 = i1 / 2;
      i1 = e();
    }
  }
  
  private void a(View paramView, boolean paramBoolean1, boolean paramBoolean2)
  {
    BaseArticleInfo localBaseArticleInfo = b(((pmz)paramView.getTag()).jdField_a_of_type_Int);
    if (localBaseArticleInfo == null) {
      return;
    }
    if (this.jdField_a_of_type_Rvy.b()) {
      this.jdField_a_of_type_Rvy.a();
    }
    if (this.jdField_a_of_type_Rwr != null) {
      this.jdField_a_of_type_Rwr.a(1, localBaseArticleInfo, 0L, 0L);
    }
    paramView = new Intent(a(), ReadInJoyDeliverBiuActivity.class);
    paramView.putExtra("arg_article_info", (ArticleInfo)localBaseArticleInfo);
    paramView.putExtra("biu_src", 2);
    paramView.putExtra("arg_from_type", 7);
    paramView.putExtra("fast_biu_type", paramBoolean2);
    a().startActivityForResult(paramView, 2);
    a().overridePendingTransition(0, 0);
    long l2 = 0L;
    paramView = this.jdField_a_of_type_Rvy.a();
    long l1 = l2;
    if (paramView != null)
    {
      l1 = l2;
      if (paramView.jdField_c_of_type_JavaLangString.equals(localBaseArticleInfo.mVideoVid)) {
        l1 = this.jdField_a_of_type_Rvy.a();
      }
    }
    String str1 = new sbg(null, localBaseArticleInfo.mSubscribeID, localBaseArticleInfo.mVideoVid, localBaseArticleInfo.innerUniqueID).a(l1).c(localBaseArticleInfo.mVideoDuration * 1000).e(localBaseArticleInfo.mAlgorithmID).c(localBaseArticleInfo.mStrategyId).a(this.jdField_c_of_type_Int).g(paramBoolean1).h(paramBoolean2).a().a();
    String str2 = localBaseArticleInfo.mSubscribeID;
    if (!TextUtils.isEmpty(localBaseArticleInfo.innerUniqueID))
    {
      paramView = localBaseArticleInfo.innerUniqueID;
      ocd.a(null, str2, "0X8007B89", "0X8007B89", 0, 0, "1", "", paramView, str1, false);
      l2 = a().getIntent().getLongExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", 0L);
      paramView = new qxb();
      paramView.jdField_d_of_type_Int = ((int)l1);
      paramView.jdField_e_of_type_Int = (localBaseArticleInfo.mVideoDuration * 1000);
      if (l2 != 0L) {
        break label390;
      }
    }
    label390:
    for (int i1 = 1;; i1 = 2)
    {
      paramView.jdField_c_of_type_Int = i1;
      odr.a(localBaseArticleInfo, this.jdField_c_of_type_Int, 25, -1L, paramView);
      return;
      paramView = "0";
      break;
    }
  }
  
  public static void a(ArticleInfo paramArticleInfo, int paramInt)
  {
    String str = ubg.b(paramInt);
    a(paramArticleInfo, str, str, paramInt);
  }
  
  public static void a(ArticleInfo paramArticleInfo, int paramInt1, int paramInt2)
  {
    if (paramArticleInfo == null) {
      return;
    }
    long l2 = paramArticleInfo.mFeedId;
    paramInt1 += 1;
    String str1;
    long l1;
    if ((g(paramArticleInfo)) || (i(paramArticleInfo)) || (j(paramArticleInfo)) || (k(paramArticleInfo)))
    {
      if ((paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyl == null)) {
        break label273;
      }
      str1 = Long.toString(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyl.jdField_a_of_type_Long);
      l1 = 0L;
    }
    for (;;)
    {
      label77:
      String str3 = ozs.a(paramInt2, paramInt1, null, ozs.a(paramArticleInfo), paramArticleInfo.innerUniqueID, ozs.d(paramArticleInfo), paramArticleInfo);
      if (ubg.a(paramArticleInfo.mChannelID)) {}
      for (String str2 = "0X8009363";; str2 = "0X8008899")
      {
        ocd.a(null, "CliOper", "", str1, str2, str2, 0, 0, Long.toString(l2), Long.toString(l1), "" + paramArticleInfo.mStrategyId, str3, false);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ReadInJoyBaseAdapter", 2, new Object[] { "reportGridImageClickEvent report click data, toUin: ", str1, ", r2(feedsId): ", Long.valueOf(l2), ", r3(articleId): ", Long.valueOf(l1), " r4(imagePos): ", Integer.valueOf(paramInt1), ", r5: ", str3 });
        return;
        str1 = paramArticleInfo.mSubscribeID;
        l1 = paramArticleInfo.mArticleID;
        break label77;
      }
      label273:
      l1 = 0L;
      str1 = "";
    }
  }
  
  public static void a(ArticleInfo paramArticleInfo, String paramString, int paramInt, Bundle paramBundle)
  {
    if (paramArticleInfo == null) {
      return;
    }
    String str2 = "";
    long l2 = 0L;
    int i1 = 0;
    long l3 = paramArticleInfo.mFeedId;
    int i2 = paramInt + 1;
    long l1;
    String str1;
    if ((g(paramArticleInfo)) || (i(paramArticleInfo)) || (j(paramArticleInfo)) || (k(paramArticleInfo)))
    {
      l1 = l2;
      str1 = str2;
      if (paramArticleInfo.mSocialFeedInfo == null) {
        break label376;
      }
      l1 = l2;
      str1 = str2;
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyl == null) {
        break label376;
      }
      str2 = Long.toString(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyl.jdField_a_of_type_Long);
      l1 = l2;
      str1 = str2;
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyl.jdField_a_of_type_JavaUtilArrayList == null) {
        break label376;
      }
      paramInt = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyl.jdField_a_of_type_JavaUtilArrayList.size();
      l1 = 0L;
      str1 = str2;
    }
    for (;;)
    {
      paramString = ozs.a(paramInt, i2, paramString, ozs.a(paramArticleInfo), paramArticleInfo.innerUniqueID, paramArticleInfo);
      str2 = ozs.a(paramInt, i2, null, ozs.a(paramArticleInfo), paramArticleInfo.innerUniqueID, ozs.d(paramArticleInfo), paramArticleInfo);
      paramBundle.putString("to_uin", str1);
      paramBundle.putString("feeds_id", Long.toString(l3));
      paramBundle.putString("article_id", Long.toString(l1));
      paramBundle.putInt("position", i2);
      paramBundle.putString("read_article_r5", paramString);
      paramBundle.putString("scroll_image_r5", str2);
      paramBundle.putLong("channel_id", paramArticleInfo.mChannelID);
      paramBundle.putString("strategy_id", "" + paramArticleInfo.mStrategyId);
      return;
      str2 = paramArticleInfo.mSubscribeID;
      l2 = paramArticleInfo.mArticleID;
      l1 = l2;
      str1 = str2;
      if (paramArticleInfo.mSocialFeedInfo != null)
      {
        l1 = l2;
        str1 = str2;
        if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyg != null)
        {
          l1 = l2;
          str1 = str2;
          if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyg.jdField_a_of_type_JavaUtilArrayList != null)
          {
            paramInt = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyg.jdField_a_of_type_JavaUtilArrayList.size();
            l1 = l2;
            str1 = str2;
            continue;
          }
        }
      }
      label376:
      paramInt = i1;
    }
  }
  
  public static void a(ArticleInfo paramArticleInfo, String paramString1, String paramString2, int paramInt)
  {
    a(paramArticleInfo, paramString1, paramString2, paramInt, null);
  }
  
  public static void a(ArticleInfo paramArticleInfo, String paramString1, String paramString2, int paramInt, Map<String, Object> paramMap)
  {
    if ((paramArticleInfo == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    Object localObject = ozs.d(paramArticleInfo);
    if (paramArticleInfo.hasChannelInfo()) {
      int i1 = paramArticleInfo.mChannelInfoId;
    }
    if (TextUtils.isEmpty(paramArticleInfo.mArticleFriendLikeText)) {}
    try
    {
      localObject = ozs.a(paramArticleInfo.mAlgorithmID, ozs.a(paramArticleInfo), paramInt, bhnv.h(null), (String)localObject, paramArticleInfo.innerUniqueID, ozs.f(paramArticleInfo), 0, ozs.d(), paramArticleInfo);
      if ((paramMap != null) && (paramMap.entrySet() != null))
      {
        paramMap = paramMap.entrySet().iterator();
        while ((paramMap != null) && (paramMap.hasNext()))
        {
          Map.Entry localEntry = (Map.Entry)paramMap.next();
          ((JSONObject)localObject).put((String)localEntry.getKey(), localEntry.getValue().toString());
          continue;
          ocd.a(null, ozs.d(paramArticleInfo), paramString1, paramString2, 0, 0, a(paramArticleInfo.mFeedId), String.valueOf(paramArticleInfo.businessId), Integer.toString(paramArticleInfo.mStrategyId), paramMap, false);
        }
      }
    }
    catch (Exception paramMap)
    {
      agej.a("ReadInJoyBaseAdapter", "reportClickEvent", new IllegalArgumentException(paramMap));
      paramMap = null;
    }
    for (;;)
    {
      ubk.a(paramArticleInfo, paramInt);
      return;
      paramMap = ((JSONObject)localObject).toString();
    }
  }
  
  private void a(BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    if ((paramBaseArticleInfo != null) && (paramBaseArticleInfo.feedsFirstExposurePos == -1)) {
      paramBaseArticleInfo.feedsFirstExposurePos = paramInt;
    }
    ubg.a(paramBaseArticleInfo, ubg.jdField_e_of_type_Int);
  }
  
  private void a(BaseArticleInfo paramBaseArticleInfo, TextView paramTextView1, View paramView1, TextView paramTextView2, KandianUrlImageView paramKandianUrlImageView, View paramView2)
  {
    int i1 = bnrf.d();
    boolean bool2 = bnrf.p();
    paramTextView1.setMaxLines(i1);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramTextView1.getLayoutParams();
    float f1;
    boolean bool1;
    if (bool2)
    {
      f1 = 5.0F;
      localLayoutParams.bottomMargin = agej.a(f1, this.jdField_a_of_type_AndroidAppActivity.getResources());
      if (bool2) {
        break label188;
      }
      bool1 = true;
      label60:
      localLayoutParams.alignWithParent = bool1;
      paramTextView1.setLayoutParams(localLayoutParams);
      if (paramView1 != null) {
        if (!bool2) {
          break label194;
        }
      }
    }
    label188:
    label194:
    for (i1 = 0;; i1 = 8)
    {
      paramView1.setVisibility(i1);
      if (!paramBaseArticleInfo.hasFamilyCommentIcon()) {
        break label213;
      }
      try
      {
        paramTextView1 = new URL(paramBaseArticleInfo.familyCommentInfo.jdField_a_of_type_JavaLangString);
        if (paramBaseArticleInfo.familyCommentInfo.jdField_b_of_type_Int > 0) {
          a(paramKandianUrlImageView, paramTextView1, paramBaseArticleInfo.familyCommentInfo.jdField_a_of_type_Int, paramBaseArticleInfo.familyCommentInfo.jdField_b_of_type_Int);
        }
        paramKandianUrlImageView.setOnClickListener(new seo(this, paramBaseArticleInfo.familyCommentInfo.jdField_b_of_type_JavaLangString, paramView2));
        paramKandianUrlImageView.setVisibility(0);
        paramTextView2.setVisibility(8);
        return;
      }
      catch (MalformedURLException paramBaseArticleInfo)
      {
        QLog.d("ReadInJoyBaseAdapter", 2, "innerConfigTwoItemVideoUI exception");
        return;
      }
      f1 = 8.0F;
      break;
      bool1 = false;
      break label60;
    }
    label213:
    QLog.d("ReadInJoyBaseAdapter", 2, "innerConfigTwoItemVideoUI setCommentCountText");
    paramKandianUrlImageView.setVisibility(8);
    paramTextView2.setVisibility(0);
    rpt.a(paramTextView2, paramBaseArticleInfo.getCommentCount(), anzj.a(2131711804), "0");
  }
  
  private void a(KandianUrlImageView paramKandianUrlImageView, ImageView paramImageView, BaseArticleInfo paramBaseArticleInfo, boolean paramBoolean)
  {
    boolean bool;
    URL localURL;
    if ((paramBaseArticleInfo.isUseGif) && (bhnv.h(this.jdField_a_of_type_AndroidAppActivity)))
    {
      bool = true;
      paramBaseArticleInfo.isShowGif = bool;
      localURL = paramBaseArticleInfo.getVideoCoverUrlWithSmartCut(true);
      if (!paramBaseArticleInfo.isShowGif) {
        break label94;
      }
      paramImageView.setVisibility(0);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mPlayGifImage = true;
      localURLDrawableOptions.mLoadingDrawable = a();
      paramImageView.setImageDrawable(URLDrawable.getDrawable(paramBaseArticleInfo.gifCoverUrl, localURLDrawableOptions));
    }
    for (;;)
    {
      a(paramKandianUrlImageView, localURL, paramBoolean);
      return;
      bool = false;
      break;
      label94:
      paramImageView.setVisibility(8);
    }
  }
  
  private void a(KandianUrlImageView paramKandianUrlImageView, URL paramURL)
  {
    a(paramKandianUrlImageView, paramURL, false);
  }
  
  private void a(KandianUrlImageView paramKandianUrlImageView, URL paramURL, int paramInt1, int paramInt2)
  {
    if ((paramKandianUrlImageView == null) || (paramInt2 <= 0)) {
      return;
    }
    double d1 = paramInt1 / paramInt2;
    ViewGroup.LayoutParams localLayoutParams = paramKandianUrlImageView.getLayoutParams();
    QLog.d("ReadInJoyBaseAdapter", 2, "configImage | whRate " + d1 + ", origin width " + localLayoutParams.width + " ,origin height " + localLayoutParams.height);
    if (localLayoutParams != null)
    {
      localLayoutParams.height = Utils.dp2px(18.0D);
      localLayoutParams.width = ((int)(localLayoutParams.height * d1));
      QLog.d("ReadInJoyBaseAdapter", 2, "configImage | whRate " + d1 + ", width " + localLayoutParams.width + " , height " + localLayoutParams.height);
      paramKandianUrlImageView.setLayoutParams(localLayoutParams);
    }
    a(paramKandianUrlImageView, paramURL, false);
  }
  
  private void a(KandianUrlImageView paramKandianUrlImageView, URL paramURL, boolean paramBoolean)
  {
    ozc.a(paramKandianUrlImageView, paramURL, this.jdField_a_of_type_AndroidAppActivity, paramBoolean);
  }
  
  private void a(ReadInJoyHeadImageView paramReadInJoyHeadImageView, BaseArticleInfo paramBaseArticleInfo)
  {
    Object localObject = null;
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = bhmq.b();
    }
    if ((ozs.w(paramBaseArticleInfo)) || ((paramBaseArticleInfo.busiType == 1) && (!AdvertisementInfo.isAdvertisementInfo(paramBaseArticleInfo))))
    {
      paramReadInJoyHeadImageView.setHeadImgByUin(paramBaseArticleInfo.getSubscribeUin());
      return;
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = paramReadInJoyHeadImageView.getWidth();
    localURLDrawableOptions.mRequestHeight = paramReadInJoyHeadImageView.getHeight();
    localURLDrawableOptions.mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    localURLDrawableOptions.mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    label197:
    label329:
    for (;;)
    {
      AdvertisementInfo localAdvertisementInfo;
      boolean bool;
      try
      {
        if (!AdvertisementInfo.isAdvertisementInfo(paramBaseArticleInfo)) {
          break label265;
        }
        localAdvertisementInfo = (AdvertisementInfo)paramBaseArticleInfo;
        bool = AdvertisementInfo.isAppAdvertisementInfo(paramBaseArticleInfo);
        if (!bool) {
          break label235;
        }
      }
      catch (MalformedURLException paramReadInJoyHeadImageView) {}
      try
      {
        paramBaseArticleInfo = new JSONObject(localAdvertisementInfo.mAdExt).getString("applogo");
        bool = TextUtils.isEmpty(paramBaseArticleInfo);
        if (!bool) {
          break label197;
        }
        paramBaseArticleInfo = null;
      }
      catch (JSONException paramBaseArticleInfo)
      {
        paramBaseArticleInfo = localObject;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ReadInJoyBaseAdapter", 2, "cannot get avatar from app advertisement");
        paramBaseArticleInfo = localObject;
        continue;
      }
      if (paramBaseArticleInfo == null)
      {
        paramReadInJoyHeadImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        paramReadInJoyHeadImageView.setVisibility(0);
        return;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ReadInJoyBaseAdapter", 2, "configVideoItemUI() ERROR e = " + paramReadInJoyHeadImageView.getMessage());
        return;
        paramBaseArticleInfo = new URL(paramBaseArticleInfo);
        continue;
        label235:
        paramBaseArticleInfo = localObject;
        if (TextUtils.isEmpty(localAdvertisementInfo.mAdCorporateLogo)) {
          continue;
        }
        paramBaseArticleInfo = new URL(localAdvertisementInfo.mAdCorporateLogo);
        continue;
        if (TextUtils.isEmpty(paramBaseArticleInfo.thirdIcon))
        {
          paramBaseArticleInfo = new URL("https://pub.idqqimg.com/pc/misc/files/20191114/1014c7cfd33e4333b818ceecc0885938.png");
          break label329;
        }
        paramBaseArticleInfo = new URL(paramBaseArticleInfo.thirdIcon);
        break label329;
      }
      paramBaseArticleInfo = URLDrawable.getDrawable(paramBaseArticleInfo, localURLDrawableOptions);
      paramBaseArticleInfo.setDecodeHandler(bhez.a);
      paramReadInJoyHeadImageView.setImageDrawable(paramBaseArticleInfo);
      paramReadInJoyHeadImageView.setVisibility(0);
      return;
    }
  }
  
  private void a(ReadInJoyNickNameTextView paramReadInJoyNickNameTextView, BaseArticleInfo paramBaseArticleInfo, boolean paramBoolean)
  {
    if (ozs.w(paramBaseArticleInfo))
    {
      paramReadInJoyNickNameTextView.setNickNameByUin(paramBaseArticleInfo.getSubscribeUin());
      return;
    }
    if (paramBoolean)
    {
      paramReadInJoyNickNameTextView.setText(tqa.a(paramBaseArticleInfo));
      return;
    }
    paramReadInJoyNickNameTextView.setText(ozc.a(paramBaseArticleInfo.getSubscribeName(), 18));
  }
  
  private void a(RoundAngleFrameLayout paramRoundAngleFrameLayout)
  {
    if (ozs.u())
    {
      paramRoundAngleFrameLayout.setRadius(28);
      return;
    }
    paramRoundAngleFrameLayout.setRadius(0);
  }
  
  private void a(AbsListView paramAbsListView)
  {
    if (paramAbsListView.getFirstVisiblePosition() == 0)
    {
      this.jdField_l_of_type_Int = 0;
      return;
    }
    ThreadManager.post(new ReadInJoyBaseAdapter.36(this, paramAbsListView), 8, null, true);
  }
  
  private void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramString = oyu.jdField_k_of_type_JavaLangString + bhkv.encodeToString(String.valueOf(paramString).getBytes(), 2);
    ozs.a(a(), paramString);
  }
  
  private void a(List<sgh> paramList, int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    paramInt = getItemViewType(paramInt);
    if (paramInt == 4) {
      if (paramBaseArticleInfo.mVideoCoverUrl != null)
      {
        paramBaseArticleInfo = paramBaseArticleInfo.mVideoCoverUrl;
        paramList.add(sgh.a(paramBaseArticleInfo, ozc.f()));
      }
    }
    for (;;)
    {
      return;
      if (paramBaseArticleInfo.mSinglePicture != null)
      {
        paramBaseArticleInfo = paramBaseArticleInfo.mSinglePicture;
        break;
      }
      paramBaseArticleInfo = ozs.a(paramBaseArticleInfo.mFirstPagePicUrl);
      break;
      if ((paramInt == 70) || (paramInt == 46))
      {
        URL localURL;
        if (paramBaseArticleInfo.mVideoCoverUrl != null)
        {
          localURL = paramBaseArticleInfo.mVideoCoverUrl;
          paramList.add(sgh.a(localURL, ozc.g()));
          if ((paramBaseArticleInfo.mSubArtilceList == null) || (paramBaseArticleInfo.mSubArtilceList.size() <= 0)) {
            continue;
          }
          paramBaseArticleInfo = (ArticleInfo)paramBaseArticleInfo.mSubArtilceList.get(0);
          if (paramBaseArticleInfo.mVideoCoverUrl == null) {
            break label192;
          }
          paramBaseArticleInfo = paramBaseArticleInfo.mVideoCoverUrl;
        }
        for (;;)
        {
          paramList.add(sgh.a(paramBaseArticleInfo, ozc.g()));
          return;
          if (paramBaseArticleInfo.mSinglePicture != null)
          {
            localURL = paramBaseArticleInfo.mSinglePicture;
            break;
          }
          localURL = ozs.a(paramBaseArticleInfo.mFirstPagePicUrl);
          break;
          label192:
          if (paramBaseArticleInfo.mSinglePicture != null) {
            paramBaseArticleInfo = paramBaseArticleInfo.mSinglePicture;
          } else {
            paramBaseArticleInfo = ozs.a(paramBaseArticleInfo.mFirstPagePicUrl);
          }
        }
      }
      else if ((paramInt == 3) || (paramInt == 14) || (paramInt == 105))
      {
        if (paramBaseArticleInfo.mPictures != null)
        {
          paramBaseArticleInfo = paramBaseArticleInfo.mPictures;
          int i1 = paramBaseArticleInfo.length;
          paramInt = 0;
          while (paramInt < i1)
          {
            paramList.add(sgh.a(paramBaseArticleInfo[paramInt], ozc.a()));
            paramInt += 1;
          }
        }
      }
      else
      {
        if ((paramInt == 2) || (paramInt == 6) || (paramInt == 66) || (paramInt == 115))
        {
          paramList.add(sgh.a(paramBaseArticleInfo.mSinglePicture, ozc.e()));
          return;
        }
        if ((paramInt == 1) || (paramInt == 5) || (paramInt == 104) || (paramInt == 106))
        {
          paramList.add(sgh.a(paramBaseArticleInfo.mSinglePicture, ozc.a()));
          return;
        }
        if ((paramInt == 122) && (AdvertisementInfo.isAdvertisementInfo(paramBaseArticleInfo)) && (tqa.k((AdvertisementInfo)paramBaseArticleInfo)) && (((AdvertisementInfo)paramBaseArticleInfo).mAdImgList != null))
        {
          paramBaseArticleInfo = ((AdvertisementInfo)paramBaseArticleInfo).mAdImgList.iterator();
          while (paramBaseArticleInfo.hasNext()) {
            paramList.add(sgh.a(ozs.a((String)paramBaseArticleInfo.next()), ozc.e()));
          }
        }
      }
    }
  }
  
  private void a(pmz parampmz)
  {
    if (parampmz == null) {
      return;
    }
    parampmz.jdField_e_of_type_AndroidWidgetImageView.setOnClickListener(this);
    parampmz.i.setOnClickListener(this);
    parampmz.h.setOnClickListener(this);
    parampmz.h.setTag(parampmz);
    parampmz.i.setTag(parampmz);
    parampmz.jdField_e_of_type_AndroidWidgetImageView.setTag(parampmz);
  }
  
  public static void a(pmz parampmz, BaseArticleInfo paramBaseArticleInfo)
  {
    rwc localrwc = a(paramBaseArticleInfo);
    localrwc.jdField_a_of_type_AndroidViewView = parampmz.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
    localrwc.jdField_a_of_type_Int = parampmz.jdField_a_of_type_Int;
    localrwc.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = paramBaseArticleInfo;
    parampmz.jdField_a_of_type_Rwc = localrwc;
  }
  
  private void a(qvp paramqvp, BaseArticleInfo paramBaseArticleInfo)
  {
    if ((ozs.s(paramBaseArticleInfo)) && (paramBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(-paramBaseArticleInfo.mArticleID), paramqvp);
      return;
    }
    this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(paramBaseArticleInfo.mArticleID), paramqvp);
  }
  
  private void a(qvp paramqvp, BaseArticleInfo paramBaseArticleInfo, int paramInt, ppu paramppu)
  {
    if (((g(paramBaseArticleInfo)) || (i((ArticleInfo)paramBaseArticleInfo)) || (j((ArticleInfo)paramBaseArticleInfo)) || (k((ArticleInfo)paramBaseArticleInfo))) && (!o((ArticleInfo)paramBaseArticleInfo)))
    {
      paramqvp.jdField_d_of_type_JavaLangString = String.valueOf(paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyl.jdField_a_of_type_Long);
      paramqvp.jdField_a_of_type_JavaLangLong = Long.valueOf(paramBaseArticleInfo.businessId);
      if (paramqvp.jdField_e_of_type_Boolean)
      {
        if (!paramppu.b()) {
          break label340;
        }
        paramInt = 2;
      }
    }
    for (;;)
    {
      paramqvp.jdField_a_of_type_Int = paramInt;
      return;
      if ((ozs.i(paramBaseArticleInfo)) && (paramBaseArticleInfo.mPolymericInfo.jdField_a_of_type_Int == 6))
      {
        paramqvp.jdField_d_of_type_JavaLangString = (paramBaseArticleInfo.mPolymericInfo.jdField_b_of_type_Long + "");
        paramqvp.jdField_a_of_type_JavaLangLong = Long.valueOf(paramBaseArticleInfo.mArticleID);
        break;
      }
      if (ozs.l(paramBaseArticleInfo))
      {
        if (ozs.j(paramBaseArticleInfo)) {
          if (paramBaseArticleInfo.mGroupSubArticleList.size() >= 1)
          {
            if (!TextUtils.isEmpty(((BaseArticleInfo)paramBaseArticleInfo.mGroupSubArticleList.get(0)).mVideoVid)) {
              paramqvp.jdField_b_of_type_JavaLangString = ((BaseArticleInfo)paramBaseArticleInfo.mGroupSubArticleList.get(0)).mVideoVid;
            }
            paramqvp.jdField_e_of_type_JavaLangString = ((BaseArticleInfo)paramBaseArticleInfo.mGroupSubArticleList.get(0)).innerUniqueID;
          }
        }
        for (;;)
        {
          paramqvp.jdField_a_of_type_JavaLangLong = Long.valueOf(paramBaseArticleInfo.mArticleID);
          break;
          paramqvp.jdField_k_of_type_Int = paramInt;
          if (paramBaseArticleInfo.mPolymericInfo != null) {
            paramBaseArticleInfo.mPolymericInfo.jdField_a_of_type_Boolean = true;
          }
        }
      }
      if (ozs.s(paramBaseArticleInfo))
      {
        paramqvp.jdField_d_of_type_JavaLangString = paramBaseArticleInfo.mSubscribeID;
        paramqvp.jdField_a_of_type_JavaLangLong = Long.valueOf(paramBaseArticleInfo.mArticleID);
        break;
      }
      paramqvp.jdField_d_of_type_JavaLangString = paramBaseArticleInfo.mSubscribeID;
      paramqvp.jdField_a_of_type_JavaLangLong = Long.valueOf(paramBaseArticleInfo.mArticleID);
      break;
      label340:
      if (paramppu.d()) {
        paramInt = 1;
      } else {
        paramInt = 0;
      }
    }
  }
  
  private void a(qvp paramqvp, BaseArticleInfo paramBaseArticleInfo, ppu paramppu)
  {
    boolean bool2 = false;
    if ((paramBaseArticleInfo.mGroupId != -1L) || (paramBaseArticleInfo.isSubscriptFeed())) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      paramqvp.jdField_c_of_type_Boolean = bool1;
      paramqvp.jdField_d_of_type_Boolean = paramppu.a();
      if (!paramppu.b())
      {
        bool1 = bool2;
        if (!paramppu.d()) {}
      }
      else
      {
        bool1 = true;
      }
      paramqvp.jdField_e_of_type_Boolean = bool1;
      return;
    }
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    pmk localpmk = a(0);
    if ((localpmk instanceof pms)) {
      return ((pms)localpmk).a(paramInt2, paramInt1);
    }
    return false;
  }
  
  @Deprecated
  public static boolean a(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {
      return false;
    }
    switch (paramArticleInfo.mFeedType)
    {
    case 10: 
    case 11: 
    default: 
      return false;
    }
    return true;
  }
  
  public static boolean a(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo != null) && (paramBaseArticleInfo.mFeedType == 36);
  }
  
  private boolean a(AbsListView paramAbsListView)
  {
    float f1 = paramAbsListView.getFlingVelocity();
    float f2 = (float)bhlo.j();
    return (f1 > 0.0F) && (f1 > f2 * 1.0F);
  }
  
  public static int b(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo == null) || (paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyl == null))
    {
      QLog.d("ReadInJoyBaseAdapter", 1, "getTopicRecommendAndUpdateUGCType ugc feeds info is null. article info is: " + paramArticleInfo);
      return 54;
    }
    switch (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyl.jdField_a_of_type_Int)
    {
    case 1: 
    default: 
      return 54;
    case 2: 
    case 3: 
      return 55;
    }
    return 56;
  }
  
  private Bundle b(rwc paramrwc, BaseArticleInfo paramBaseArticleInfo)
  {
    Object localObject1 = null;
    Object localObject3;
    Object localObject2;
    if ((ozs.n(paramBaseArticleInfo)) && (paramrwc != null))
    {
      localObject3 = paramBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject2 = (qwp)((Iterator)localObject3).next();
        if ((((qwp)localObject2).jdField_a_of_type_Qws == null) || (!TextUtils.equals(paramrwc.jdField_c_of_type_JavaLangString, ((qwp)localObject2).jdField_a_of_type_Qws.jdField_a_of_type_JavaLangString))) {
          break label989;
        }
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = (qwp)paramBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.get(0);
      }
      localObject1 = new Bundle();
      label392:
      boolean bool;
      if (((qwp)localObject2).jdField_a_of_type_Boolean)
      {
        ((Bundle)localObject1).putString("VIDEO_PUB_ACCOUNT_UIN", "" + paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qxt.jdField_a_of_type_Long);
        ((Bundle)localObject1).putString("VIDEO_H5_URL", ((qwp)localObject2).jdField_a_of_type_Qws.jdField_c_of_type_JavaLangString);
        ((Bundle)localObject1).putLong("VIDEO_FEED_ID", ((qwp)localObject2).jdField_c_of_type_Long);
        ((Bundle)localObject1).putInt("VIDEO_FEED_TYPE", ((qwp)localObject2).jdField_b_of_type_Int);
        if (((qwp)localObject2).jdField_a_of_type_Qws != null) {}
        ((Bundle)localObject1).putString("VIDEO_TIME", String.valueOf(paramrwc.jdField_b_of_type_Int));
        ((Bundle)localObject1).putString("VIDEO_WIDTH", String.valueOf(paramrwc.jdField_c_of_type_Int));
        ((Bundle)localObject1).putString("VIDEO_HEIGHT", String.valueOf(paramrwc.jdField_d_of_type_Int));
        ((Bundle)localObject1).putString("VIDEO_VID", paramrwc.jdField_c_of_type_JavaLangString);
        ((Bundle)localObject1).putString("VIDEO_COVER", paramrwc.jdField_b_of_type_JavaLangString);
        ((Bundle)localObject1).putLong("VIDEO_XG_FILE_SIZE", paramBaseArticleInfo.mXGFileSize);
        ((Bundle)localObject1).putInt("VIDEO_STRATEGY_ID", paramrwc.jdField_g_of_type_Int);
        ((Bundle)localObject1).putLong("VIDEO_ALGORITHM_ID", paramrwc.jdField_g_of_type_Long);
        ((Bundle)localObject1).putString("VIDEO_SECOND_INDEX_INNER_ID", paramrwc.jdField_n_of_type_JavaLangString);
        if ((this.jdField_a_of_type_Pmw == null) || (this.jdField_a_of_type_Pmw.a() == null) || (this.jdField_a_of_type_Rvy == null) || (this.jdField_a_of_type_Pmw.a().jdField_c_of_type_Long != paramrwc.jdField_c_of_type_Long)) {
          break label959;
        }
        ((Bundle)localObject1).putLong("VIDEO_PLAY_POSITION", this.jdField_a_of_type_Rvy.a());
        ((Bundle)localObject1).putString("VIDEO_ARTICLE_ID", ((qwp)localObject2).jdField_g_of_type_JavaLangString);
        ((Bundle)localObject1).putString("VIDEO_TITLE", ((qwp)localObject2).jdField_a_of_type_JavaLangString);
        ((Bundle)localObject1).putBoolean("IS_FROM_READINJOY_VIDEO_CHANNEL", bnrf.a(this.jdField_d_of_type_Int));
        if (paramrwc.jdField_f_of_type_Int != 1) {
          break label971;
        }
        bool = true;
        label444:
        ((Bundle)localObject1).putBoolean("VIDEO_IS_FROM_PUBLIC_ACCOUNT", bool);
        ((Bundle)localObject1).putBoolean("isFromKandian", true);
        ((Bundle)localObject1).putLong("channelID", paramBaseArticleInfo.mChannelID);
        ((Bundle)localObject1).putLong("algorithmID", ((qwp)localObject2).jdField_b_of_type_Long);
        ((Bundle)localObject1).putString("innderId", ((qwp)localObject2).jdField_g_of_type_JavaLangString);
        ((Bundle)localObject1).putLong("strategyId", ((qwp)localObject2).jdField_a_of_type_Int);
        ((Bundle)localObject1).putString("VIDEO_THIRD_ICON", paramrwc.jdField_d_of_type_JavaLangString);
        ((Bundle)localObject1).putString("VIDEO_THIRD_NAME", paramrwc.jdField_e_of_type_JavaLangString);
        ((Bundle)localObject1).putString("VIDEO_THIRD_ACTION", paramrwc.jdField_f_of_type_JavaLangString);
        ((Bundle)localObject1).putString("VIDEO_THIRD_URL", paramrwc.jdField_g_of_type_JavaLangString);
        ((Bundle)localObject1).putLong("VIDEO_THRID_URL_EXPIRE_TIME", paramrwc.jdField_f_of_type_Long);
        ((Bundle)localObject1).putInt("VIDEO_ARTICLE_BUSITYPE", paramrwc.jdField_f_of_type_Int);
        localObject3 = new Bundle();
        ((Bundle)localObject3).putString("VINFO", paramrwc.jdField_c_of_type_JavaLangString);
        ((Bundle)localObject3).putString("TINFO", paramrwc.jdField_c_of_type_JavaLangString);
        ((Bundle)localObject3).putInt("PREVIEW_VIDEO_TIME", paramrwc.jdField_b_of_type_Int);
        if (this.jdField_a_of_type_Rvy != null) {
          break label977;
        }
      }
      label959:
      label971:
      label977:
      for (int i1 = 0;; i1 = (int)this.jdField_a_of_type_Rvy.a())
      {
        ((Bundle)localObject3).putInt("PREVIEW_START_POSI", rwe.a(i1, paramrwc.jdField_b_of_type_Int));
        ((Bundle)localObject3).putInt("PREVIEW_VIDEO_WIDTH", paramrwc.jdField_c_of_type_Int);
        ((Bundle)localObject3).putInt("PREVIEW_VIDEO_HEIGHT", paramrwc.jdField_d_of_type_Int);
        ((Bundle)localObject3).putInt("FULL_VIDEO_TIME", paramrwc.jdField_b_of_type_Int);
        ((Bundle)localObject3).putString("source_puin", ((qwp)localObject2).jdField_e_of_type_JavaLangString);
        ((Bundle)localObject3).putString("ACCOUNT_UIN", ((qwp)localObject2).jdField_e_of_type_JavaLangString);
        ((Bundle)localObject3).putString("ACCOUNT_NAME", ((qwp)localObject2).jdField_f_of_type_JavaLangString);
        ((Bundle)localObject3).putInt("TYPE", paramrwc.jdField_f_of_type_Int);
        ((Bundle)localObject3).putString("ARTICLE_ID", ((qwp)localObject2).jdField_g_of_type_JavaLangString);
        ((Bundle)localObject3).putInt("layout_item", 5);
        ((Bundle)localObject3).putBoolean("video_url_load", false);
        ((Bundle)localObject3).putString("image_url_remote", paramrwc.jdField_b_of_type_JavaLangString);
        ((Bundle)localObject3).putString("detail_url", ((qwp)localObject2).jdField_d_of_type_JavaLangString + "&sourcefrom=0");
        ((Bundle)localObject3).putString("video_url", paramrwc.jdField_c_of_type_JavaLangString);
        ((Bundle)localObject3).putString("title", ((qwp)localObject2).jdField_a_of_type_JavaLangString);
        ((Bundle)localObject3).putString("req_create_time", ozr.a(paramBaseArticleInfo.mTime));
        ((Bundle)localObject3).putString("brief_key", ((qwp)localObject2).jdField_a_of_type_JavaLangString);
        ((Bundle)localObject3).putInt("req_type", 140);
        ((Bundle)localObject1).putByteArray("STRUCT_MSG_BYTES", ((StructMsgForGeneralShare)bdow.a((Bundle)localObject3)).getBytes());
        ((Bundle)localObject1).putString("KEY_VIDEO_JSON_LIST", paramBaseArticleInfo.mJsonVideoList);
        return localObject1;
        ((Bundle)localObject1).putString("VIDEO_PUB_ACCOUNT_UIN", ((qwp)localObject2).jdField_e_of_type_JavaLangString);
        ((Bundle)localObject1).putString("VIDEO_PUB_ACCOUNT_NAME", ((qwp)localObject2).jdField_f_of_type_JavaLangString);
        ((Bundle)localObject1).putString("VIDEO_H5_URL", ((qwp)localObject2).jdField_d_of_type_JavaLangString);
        break;
        ((Bundle)localObject1).putLong("VIDEO_PLAY_POSITION", 0L);
        break label392;
        bool = false;
        break label444;
      }
      label989:
      break;
      localObject1 = null;
    }
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0)
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)ozs.a();
      if ((this.jdField_b_of_type_JavaUtilList.size() > 0) && (paramInt1 == 70))
      {
        BaseArticleInfo localBaseArticleInfo = (BaseArticleInfo)this.jdField_b_of_type_JavaUtilList.get(0);
        if (localBaseArticleInfo != null) {
          ((KandianSubscribeManager)localQQAppInterface.getManager(280)).a((ArticleInfo)localBaseArticleInfo, NetConnInfoCenter.getServerTime());
        }
      }
    }
  }
  
  public static void b(ArticleInfo paramArticleInfo, int paramInt)
  {
    if (paramArticleInfo == null) {
      return;
    }
    int i1;
    label17:
    int i2;
    label29:
    String str1;
    String str2;
    if (paramArticleInfo.hasChannelInfo())
    {
      i1 = paramArticleInfo.mChannelInfoId;
      if (!TextUtils.isEmpty(paramArticleInfo.mArticleFriendLikeText)) {
        break label238;
      }
      i2 = 0;
      str1 = ozs.d(paramArticleInfo);
      str2 = ozs.a(paramArticleInfo.mAlgorithmID, ozs.a(paramArticleInfo), paramInt, i1, i2, bhnv.h(null), str1, paramArticleInfo.mStrCircleId, paramArticleInfo.innerUniqueID, ozs.f(paramArticleInfo), paramArticleInfo);
      if ((!g(paramArticleInfo)) && (!i(paramArticleInfo)) && (!j(paramArticleInfo)) && (!k(paramArticleInfo))) {
        break label243;
      }
      if ((paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyl == null)) {
        break label252;
      }
      str1 = Long.toString(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyl.jdField_a_of_type_Long);
    }
    for (;;)
    {
      String str3 = ubg.b(paramInt);
      ocd.a(null, "CliOper", "", str1, str3, str3, 0, 0, Long.toString(paramArticleInfo.mFeedId), Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), str2, false);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ReadInJoyBaseAdapter", 2, new Object[] { "reportGridClickEvent channelId: ", Integer.valueOf(paramInt), ", toUin: ", str1, ", r5: ", str2 });
      return;
      i1 = 0;
      break label17;
      label238:
      i2 = 1;
      break label29;
      label243:
      str1 = paramArticleInfo.mSubscribeID;
      continue;
      label252:
      str1 = "";
    }
  }
  
  private void b(AbsListView paramAbsListView)
  {
    pmw localpmw = a(paramAbsListView);
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 4, "playVideoInArea:" + localpmw);
    }
    rwc localrwc;
    if (localpmw != null)
    {
      paramAbsListView = localpmw.a();
      localrwc = this.jdField_a_of_type_Rvy.a();
      if (paramAbsListView == this.jdField_a_of_type_Rvy.jdField_a_of_type_Rwc) {
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video", 2, "error state not play" + paramAbsListView.jdField_c_of_type_JavaLangString);
        }
      }
    }
    do
    {
      do
      {
        do
        {
          return;
        } while ((localrwc != null) && (localrwc.jdField_c_of_type_Long == paramAbsListView.jdField_c_of_type_Long) && (localrwc.jdField_b_of_type_Long == this.jdField_c_of_type_Int) && (!this.jdField_a_of_type_Rvy.d()) && (!this.jdField_a_of_type_Rvy.e()));
        rxg.a().b();
        a(localpmw);
      } while (!QLog.isColorLevel());
      QLog.d("Q.readinjoy.video", 2, "checkPlayableArea vid: " + paramAbsListView.jdField_c_of_type_JavaLangString);
      return;
      m();
    } while (this.jdField_a_of_type_Rvy.a() == null);
    this.jdField_a_of_type_Rvy.a().a(paramAbsListView);
    this.jdField_a_of_type_Rvy.a().h();
  }
  
  private void b(qvp paramqvp)
  {
    if (pbd.c(this.jdField_c_of_type_Int)) {}
    try
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramqvp);
      return;
    }
    catch (Exception paramqvp)
    {
      QLog.d("ReadInJoyBaseAdapter", 2, "mDailyReportDatas error!  msg=" + paramqvp);
    }
  }
  
  public static boolean b(int paramInt)
  {
    return (paramInt == 49) || (paramInt == 62) || (paramInt == 63);
  }
  
  public static boolean b(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {
      return false;
    }
    switch (c(paramArticleInfo))
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static boolean b(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo != null) && (paramBaseArticleInfo.isAccountShown);
  }
  
  public static int c(ArticleInfo paramArticleInfo)
  {
    return a(paramArticleInfo, 0);
  }
  
  private void c(BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo.mFeedType == 3)
    {
      ArrayList localArrayList = new ArrayList();
      ReportInfo localReportInfo = new ReportInfo();
      localReportInfo.mUin = ozs.a();
      localReportInfo.mSource = 0;
      localReportInfo.mSourceArticleId = paramBaseArticleInfo.mArticleID;
      localReportInfo.mChannelId = this.jdField_c_of_type_Int;
      localReportInfo.mAlgorithmId = ((int)paramBaseArticleInfo.mAlgorithmID);
      localReportInfo.mStrategyId = paramBaseArticleInfo.mStrategyId;
      localReportInfo.mOperation = 7;
      localReportInfo.mServerContext = paramBaseArticleInfo.mServerContext;
      localReportInfo.mReadTimeLength = -1;
      if (!TextUtils.isEmpty(paramBaseArticleInfo.innerUniqueID)) {
        localReportInfo.mInnerId = paramBaseArticleInfo.innerUniqueID;
      }
      localArrayList.add(localReportInfo);
      pfa.a().a(localArrayList);
    }
  }
  
  private void c(List<sgh> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      sgh localsgh = (sgh)paramList.next();
      if ((localsgh != null) && (localsgh.jdField_a_of_type_JavaNetURL != null))
      {
        if (TextUtils.equals("pubaccountimage", localsgh.jdField_a_of_type_JavaNetURL.getProtocol())) {
          localsgh.jdField_a_of_type_JavaNetURL = ozs.a(localsgh.jdField_a_of_type_JavaNetURL.getFile(), false);
        }
        suo localsuo = new suo();
        pnk.a.a(localsuo, localsgh.jdField_a_of_type_JavaNetURL.toString());
        localsuo.jdField_a_of_type_Int = ((Integer)localsgh.jdField_a_of_type_AndroidUtilPair.first).intValue();
        localsuo.jdField_b_of_type_Int = ((Integer)localsgh.jdField_a_of_type_AndroidUtilPair.second).intValue();
        localsuo.jdField_b_of_type_Boolean = true;
        sun.a().a(localsuo, null);
      }
    }
  }
  
  private static void c(qvp paramqvp)
  {
    int i1 = 0;
    if (ozs.j(paramqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo)) {
      paramqvp.jdField_b_of_type_Boolean = true;
    }
    while (paramqvp.jdField_b_of_type_Boolean) {
      return;
    }
    paramqvp.jdField_b_of_type_Boolean = true;
    ArrayList localArrayList = new ArrayList();
    ReportInfo localReportInfo = new ReportInfo();
    localReportInfo.mUin = ozs.a();
    localReportInfo.mSource = 0;
    localReportInfo.mSourceArticleId = paramqvp.jdField_a_of_type_JavaLangLong.longValue();
    if (paramqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null) {
      i1 = (int)paramqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mChannelID;
    }
    localReportInfo.mChannelId = i1;
    localReportInfo.mAlgorithmId = ((int)paramqvp.jdField_a_of_type_Long);
    localReportInfo.mStrategyId = paramqvp.jdField_b_of_type_Int;
    localReportInfo.mOperation = 7;
    localReportInfo.mServerContext = paramqvp.jdField_a_of_type_ArrayOfByte;
    localReportInfo.mReadTimeLength = -1;
    localReportInfo.mInnerId = paramqvp.jdField_e_of_type_JavaLangString;
    if ((paramqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null) && (paramqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoColumnInfo != null)) {
      localReportInfo.mColumnID = paramqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_Int;
    }
    if ((paramqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null) && (paramqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo != null) && (!ozs.l(paramqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo)))
    {
      qxa localqxa = new qxa();
      localqxa.jdField_a_of_type_Long = paramqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Long;
      if (paramqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qxt != null) {
        localqxa.jdField_b_of_type_Long = paramqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qxt.jdField_a_of_type_Long;
      }
      localqxa.jdField_a_of_type_Int = paramqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_b_of_type_Int;
      localqxa.jdField_b_of_type_Int = paramqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_d_of_type_Int;
      Object localObject = paramqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_JavaUtilList;
      if ((localObject != null) && (!((List)localObject).isEmpty()))
      {
        localqxa.jdField_a_of_type_JavaUtilList = new ArrayList();
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          qxt localqxt = (qxt)((Iterator)localObject).next();
          if (localqxt != null) {
            localqxa.jdField_a_of_type_JavaUtilList.add(Long.valueOf(localqxt.jdField_a_of_type_Long));
          }
        }
      }
      localReportInfo.mFeedsReportData = localqxa;
    }
    if ((paramqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null) && (pbd.c((int)paramqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mChannelID)))
    {
      localReportInfo.mSearchTagName = paramqvp.jdField_f_of_type_JavaLangString;
      oyc.a(localReportInfo);
      return;
    }
    localArrayList.add(localReportInfo);
    QLog.d("ReadInJoyBaseAdapter", 2, "report0x64eExposureInfo: article " + localReportInfo.mSourceArticleId + " exposed!");
    pfa.a().a(localArrayList);
  }
  
  private boolean c()
  {
    boolean bool2 = false;
    ArticleInfo localArticleInfo = a();
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Rwc == null)
    {
      bool1 = bool2;
      if (localArticleInfo != null)
      {
        bool1 = bool2;
        if (b(0) != null)
        {
          bool1 = bool2;
          if (localArticleInfo.mArticleID == b(0).mArticleID) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public static boolean c(int paramInt, long paramLong)
  {
    return (paramInt == 4) || (paramInt == 5) || (paramInt == 25) || (paramInt == 32) || ((paramInt == 1) && ((paramLong == 4L) || (paramLong == 5L) || (paramLong == 25L) || (paramLong == 32L)));
  }
  
  public static boolean c(ArticleInfo paramArticleInfo)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramArticleInfo != null)
    {
      bool1 = bool2;
      if (paramArticleInfo.mSocialFeedInfo != null)
      {
        bool1 = bool2;
        if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int == 9) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static boolean c(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo != null) && (paramBaseArticleInfo.mKdLiveInfo != null);
  }
  
  private void d(List<BaseArticleInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      QLog.d("ReadInJoyBaseAdapter", 1, "articleInfo list size =  " + paramList.size());
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        BaseArticleInfo localBaseArticleInfo = (BaseArticleInfo)localIterator.next();
        if (localBaseArticleInfo != null) {
          localArrayList.add(localBaseArticleInfo);
        } else {
          QLog.d("ReadInJoyBaseAdapter", 1, "has null items");
        }
      }
      paramList.clear();
      paramList.addAll(localArrayList);
    }
    QLog.d("ReadInJoyBaseAdapter", 1, "tempList size =  " + localArrayList.size());
  }
  
  private boolean d()
  {
    if (!bnrf.a(this.jdField_d_of_type_Int)) {}
    String str;
    do
    {
      do
      {
        do
        {
          return false;
        } while (!bhnv.g(this.jdField_a_of_type_AndroidAppActivity));
        str = ozs.a(this.jdField_c_of_type_Long);
      } while (ozs.jdField_e_of_type_JavaLangString.equals(str));
      if (ozs.jdField_c_of_type_JavaLangString.equals(str)) {
        return true;
      }
    } while (!ozs.jdField_d_of_type_JavaLangString.equals(str));
    return rmn.a(this.jdField_a_of_type_AndroidAppActivity);
  }
  
  public static boolean d(ArticleInfo paramArticleInfo)
  {
    if ((!f(paramArticleInfo)) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qxr == null)) {
      return false;
    }
    switch (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qxr.b.intValue())
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static boolean d(BaseArticleInfo paramBaseArticleInfo)
  {
    if (!(paramBaseArticleInfo instanceof ArticleInfo)) {
      return false;
    }
    if ((paramBaseArticleInfo.mChannelID != 70L) && ((i((ArticleInfo)paramBaseArticleInfo)) || (e((ArticleInfo)paramBaseArticleInfo)) || (b((ArticleInfo)paramBaseArticleInfo)) || (a(paramBaseArticleInfo)) || (b(paramBaseArticleInfo)) || (c(paramBaseArticleInfo)) || (puo.d(paramBaseArticleInfo)))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private int e()
  {
    if (ozs.u()) {
      return bhgr.a(a(), 14.0F);
    }
    return bhgr.a(a(), 6.0F);
  }
  
  public static boolean e(ArticleInfo paramArticleInfo)
  {
    return (f(paramArticleInfo)) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qxr != null);
  }
  
  public static boolean e(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qxt != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qxt.jdField_c_of_type_Int == 1);
  }
  
  public static boolean f(ArticleInfo paramArticleInfo)
  {
    boolean bool = true;
    if (paramArticleInfo == null) {
      return false;
    }
    if ((paramArticleInfo.mFeedType == 1) && (paramArticleInfo.mSocialFeedInfo != null)) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public static boolean f(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qxt != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qxt.jdField_c_of_type_Int == 0) && (b((ArticleInfo)paramBaseArticleInfo));
  }
  
  public static boolean g(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo == null) || (paramArticleInfo.mSocialFeedInfo == null)) {
      return false;
    }
    switch (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static boolean g(BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo == null) {
      return false;
    }
    switch (paramBaseArticleInfo.mFeedType)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static boolean h(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {}
    while (paramArticleInfo.mFeedType != 10) {
      return false;
    }
    return true;
  }
  
  public static boolean h(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo.mFeedType == 1) && (paramBaseArticleInfo.mSocialFeedInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qxr != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qxr.b != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qxr.b.longValue() == 11L);
  }
  
  public static boolean i(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo == null) || (paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qxr == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qxr.b == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyl == null)) {
      return false;
    }
    switch (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qxr.b.intValue())
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static boolean i(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo.mFeedType == 11) && (paramBaseArticleInfo.mTopicRecommendFeedsInfo != null) && (paramBaseArticleInfo.mTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList != null);
  }
  
  public static boolean j(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {}
    while ((paramArticleInfo.mFeedType != 18) && (paramArticleInfo.mFeedType != 19)) {
      return false;
    }
    return true;
  }
  
  public static boolean j(BaseArticleInfo paramBaseArticleInfo)
  {
    return ((paramBaseArticleInfo instanceof ArticleInfo)) && (q((ArticleInfo)paramBaseArticleInfo));
  }
  
  public static boolean k(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo == null) || (paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qxr == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyl == null)) {
      return false;
    }
    switch (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qxr.b.intValue())
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static boolean k(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo.mFeedType != 30) && ((paramBaseArticleInfo.mSocialFeedInfo == null) || (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyl == null) || (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyl.c.isEmpty()));
  }
  
  public static boolean l(ArticleInfo paramArticleInfo)
  {
    return (k(paramArticleInfo)) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyl.jdField_a_of_type_Int == 1);
  }
  
  public static boolean l(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qzb == null) || (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qzb.jdField_a_of_type_JavaUtilArrayList == null) || (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qzb.jdField_a_of_type_JavaUtilArrayList.isEmpty());
  }
  
  public static boolean m(ArticleInfo paramArticleInfo)
  {
    return (i(paramArticleInfo)) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyl.jdField_a_of_type_Int == 1);
  }
  
  public static boolean n(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {}
    while ((paramArticleInfo.mFeedType != 16) && (paramArticleInfo.mFeedType != 17)) {
      return false;
    }
    return true;
  }
  
  public static boolean o(ArticleInfo paramArticleInfo)
  {
    return (paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyl == null);
  }
  
  public static boolean p(ArticleInfo paramArticleInfo)
  {
    return (paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyl == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyl.jdField_a_of_type_JavaUtilArrayList.size() == 0);
  }
  
  private void q()
  {
    if ((a() instanceof ReadInJoyChannelActivity))
    {
      this.jdField_g_of_type_Boolean = a().getIntent().getBooleanExtra("is_need_show_animation_translate", false);
      this.jdField_d_of_type_Boolean = a().getIntent().getBooleanExtra("is_need_show_animation_adapter", false);
    }
    this.jdField_a_of_type_AndroidViewAnimationAnimationSet = ((AnimationSet)AnimationUtils.loadAnimation(this.jdField_a_of_type_AndroidAppActivity, 2130772067));
    if (!rpt.c()) {
      this.jdField_a_of_type_AndroidViewAnimationAnimationSet.setDuration(400L);
    }
    if (this.jdField_c_of_type_Int == 56)
    {
      rmp.a().a(true);
      rmp.a().a(0);
    }
    AppNetConnInfo.registerConnectionChangeReceiver(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
  }
  
  public static boolean q(ArticleInfo paramArticleInfo)
  {
    return (paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyl == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyl.jdField_b_of_type_JavaUtilArrayList.size() == 0);
  }
  
  private void r()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyBaseAdapter", 2, "cpu:" + bhlo.b() + " mem:" + bhlo.d() + " fre:" + bhlo.a());
    }
    int i1 = bhlo.b();
    long l1 = bhlo.d();
    if ((i1 >= 4) && (l1 >= 1610612736.0D))
    {
      jdField_j_of_type_Int = 6;
      return;
    }
    jdField_j_of_type_Int = 4;
  }
  
  private void s()
  {
    int i2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getFirstVisiblePosition();
    int i3 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getHeaderViewsCount();
    int i1 = 0;
    if (i1 < this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildCount())
    {
      int i4 = i2 - i3 + i1;
      if ((i4 >= getCount()) || (i4 < 0)) {}
      for (;;)
      {
        i1 += 1;
        break;
        ArticleInfo localArticleInfo = (ArticleInfo)getItem(i4);
        if (localArticleInfo != null) {
          a(localArticleInfo, new pqk(this.jdField_a_of_type_AndroidAppActivity, localArticleInfo, getItemViewType(i4), this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, i4, this.jdField_c_of_type_Boolean, getCount(), null, this), System.currentTimeMillis(), i4);
        }
      }
    }
  }
  
  private void t()
  {
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131368320), this.jdField_n_of_type_Sga);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131380872), this.jdField_n_of_type_Sga);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131366574), this.jdField_n_of_type_Sga);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131380948), this.jdField_n_of_type_Sga);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131376159), this.jdField_m_of_type_Sga);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131380865), this.jdField_l_of_type_Sga);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131373145), this.jdField_k_of_type_Sga);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131368444), this.jdField_j_of_type_Sga);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131369147), this.jdField_j_of_type_Sga);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131368445), this.jdField_i_of_type_Sga);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131362033), this.jdField_h_of_type_Sga);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131380413), this.jdField_h_of_type_Sga);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131376534), this.jdField_g_of_type_Sga);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131376154), this.jdField_f_of_type_Sga);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131368212), this.jdField_f_of_type_Sga);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131361876), this.jdField_f_of_type_Sga);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131369860), this.jdField_f_of_type_Sga);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131376682), this.jdField_f_of_type_Sga);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131362034), this.jdField_e_of_type_Sga);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131362112), this.jdField_e_of_type_Sga);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131369862), this.jdField_d_of_type_Sga);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131376684), this.jdField_d_of_type_Sga);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131367679), this.jdField_c_of_type_Sga);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131367681), this.jdField_c_of_type_Sga);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131369833), this.jdField_b_of_type_Sga);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131376651), this.jdField_b_of_type_Sga);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131369834), this.jdField_a_of_type_Sga);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131376652), this.jdField_a_of_type_Sga);
  }
  
  private void u()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyBaseAdapter", 2, "prefetch data");
    }
    if (this.jdField_a_of_type_Sgg != null) {
      this.jdField_a_of_type_Sgg.a();
    }
  }
  
  private void v()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a(this.jdField_a_of_type_Blih);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a(this.jdField_b_of_type_Blih);
  }
  
  private void w()
  {
    if (!PublicAccountImageCollectionPreloadManager.a().a()) {}
    for (;;)
    {
      return;
      PublicAccountImageCollectionPreloadManager.a().c();
      int i1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getFirstVisiblePosition();
      int i2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getLastVisiblePosition();
      a();
      while (i1 <= i2)
      {
        Object localObject = getItem(i1);
        if (localObject != null)
        {
          localObject = (BaseArticleInfo)localObject;
          if (localObject != null)
          {
            int i3 = a(i1);
            if ((i3 == 8) || (i3 == 7)) {
              PublicAccountImageCollectionPreloadManager.a().a(String.valueOf(((BaseArticleInfo)localObject).innerUniqueID));
            }
          }
        }
        i1 += 1;
      }
    }
  }
  
  private void x()
  {
    if (!bhnv.h(this.jdField_a_of_type_AndroidAppActivity)) {}
    try
    {
      Object localObject = this.jdField_a_of_type_Rvy.a();
      long l1 = ((rwc)localObject).jdField_c_of_type_Long;
      localObject = b(((rwc)localObject).jdField_a_of_type_Int);
      if ((localObject != null) && (l1 != ((BaseArticleInfo)localObject).mArticleID))
      {
        this.jdField_a_of_type_Rvy.b(12);
        if (QLog.isColorLevel()) {
          QLog.e("Q.readinjoy.video", 2, "fixVideoPlayErrorState stopVideo videoVid:" + ((BaseArticleInfo)localObject).getVideoVid());
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("Q.readinjoy.video", 2, "fixVideoPlayErrorState stopVideo throwable:" + localThrowable.getMessage());
    }
  }
  
  private void y()
  {
    if (this.jdField_a_of_type_Rvy != null) {
      this.jdField_a_of_type_Rvy.b();
    }
  }
  
  public int a()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public abstract int a(int paramInt);
  
  public long a()
  {
    long l1 = 0L;
    if (this.jdField_a_of_type_Rvy != null) {
      l1 = this.jdField_a_of_type_Rvy.a();
    }
    return l1;
  }
  
  public abstract Activity a();
  
  public Bitmap a(long paramLong)
  {
    return null;
  }
  
  public AnimationSet a()
  {
    if (this.jdField_b_of_type_AndroidViewAnimationAnimationSet == null) {
      this.jdField_b_of_type_AndroidViewAnimationAnimationSet = ((AnimationSet)AnimationUtils.loadAnimation(this.jdField_a_of_type_AndroidAppActivity, 2130772056));
    }
    AnimationSet localAnimationSet = new AnimationSet(true);
    List localList = this.jdField_b_of_type_AndroidViewAnimationAnimationSet.getAnimations();
    int i2 = localList.size();
    int i1 = 0;
    while (i1 < i2)
    {
      localAnimationSet.addAnimation((Animation)localList.get(i1));
      i1 += 1;
    }
    return localAnimationSet;
  }
  
  public aoof a()
  {
    return null;
  }
  
  public blmm a()
  {
    if (this.jdField_a_of_type_Blmm == null) {
      this.jdField_a_of_type_Blmm = new blmm(this.jdField_a_of_type_AndroidAppActivity);
    }
    return this.jdField_a_of_type_Blmm;
  }
  
  public blms a()
  {
    if (this.jdField_a_of_type_Blms == null) {
      this.jdField_a_of_type_Blms = new blms(this.jdField_a_of_type_AndroidAppActivity);
    }
    return this.jdField_a_of_type_Blms;
  }
  
  public ArticleInfo a()
  {
    long l1 = a().getIntent().getLongExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_SEQ", 0L);
    ArticleInfo localArticleInfo2 = pfa.a().a(0, l1);
    ArticleInfo localArticleInfo1 = localArticleInfo2;
    if (localArticleInfo2 == null) {
      localArticleInfo1 = (ArticleInfo)a().getIntent().getParcelableExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_INFO");
    }
    return localArticleInfo1;
  }
  
  public abstract BaseArticleInfo a(int paramInt);
  
  public abstract BaseArticleInfo a(int paramInt, long paramLong);
  
  public VafContext a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext;
  }
  
  public ListView a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView;
  }
  
  public List<BaseArticleInfo> a()
  {
    return this.jdField_b_of_type_JavaUtilList;
  }
  
  public nzj a()
  {
    return this.jdField_a_of_type_Nzj;
  }
  
  public pmk a(int paramInt)
  {
    return (pmk)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
  }
  
  public pmz a(String paramString)
  {
    int i2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getFirstVisiblePosition();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getLastVisiblePosition();
    int i1 = Math.max(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getHeaderViewsCount(), i2);
    int i3;
    if (i1 < a().size() + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getHeaderViewsCount())
    {
      i3 = i1 - this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getHeaderViewsCount();
      BaseArticleInfo localBaseArticleInfo = b(i3);
      if ((4 == getItemViewType(i3)) && (localBaseArticleInfo != null) && (TextUtils.equals(localBaseArticleInfo.getInnerUniqueID(), paramString)))
      {
        int i4 = i1 - i2;
        if ((i4 >= 0) && (i4 < this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildCount())) {
          paramString = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(i1 - i2);
        }
      }
    }
    for (;;)
    {
      if (paramString != null)
      {
        return (pmz)paramString.getTag();
        if ((i3 >= 0) && (i3 < a().size())) {
          paramString = getView(i3, null, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView);
        }
      }
      else
      {
        return null;
        i1 += 1;
        break;
        return null;
      }
      paramString = null;
    }
  }
  
  public qai a()
  {
    return jdField_a_of_type_Qai;
  }
  
  public rmg a()
  {
    return this.jdField_a_of_type_Rmg;
  }
  
  public rvy a()
  {
    return this.jdField_a_of_type_Rvy;
  }
  
  public sgc a()
  {
    return this.jdField_a_of_type_Sgc;
  }
  
  public sgd a()
  {
    return this.jdField_a_of_type_Sgd;
  }
  
  public sge a()
  {
    return this.jdField_a_of_type_Sge;
  }
  
  public sgf a()
  {
    return this.jdField_a_of_type_Sgf;
  }
  
  public syh a()
  {
    if (this.jdField_a_of_type_Syh == null) {
      this.jdField_a_of_type_Syh = new syh(this.jdField_a_of_type_AndroidAppActivity, this);
    }
    return this.jdField_a_of_type_Syh;
  }
  
  public tpn a()
  {
    return this.jdField_a_of_type_Tpn;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyBaseAdapter", 2, "clearData " + this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    }
    this.jdField_n_of_type_Boolean = true;
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.b();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    this.jdField_a_of_type_Blmm = null;
    this.jdField_a_of_type_Blms = null;
    if (this.jdField_c_of_type_Int == 56) {
      rmp.a().a();
    }
    if (this.jdField_a_of_type_Sbi != null) {
      this.jdField_a_of_type_Sbi.a();
    }
    omj.b();
    if (this.jdField_a_of_type_Rmg != null) {
      this.jdField_a_of_type_Rmg.d();
    }
  }
  
  public void a(int paramInt)
  {
    a(paramInt, true);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt2 = 0;
    paramInt1 = 0;
    Object localObject1;
    if (paramInt1 < this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildCount())
    {
      localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(paramInt1);
      if ((localObject1 instanceof ProteusItemView))
      {
        localObject1 = ((ProteusItemView)localObject1).a();
        if (localObject1 != null)
        {
          localObject1 = (sdy)((Container)localObject1).getTag(2131376186);
          if ((localObject1 == null) || (!((sdy)localObject1).a())) {}
        }
      }
    }
    for (;;)
    {
      paramInt1 = paramInt2;
      if (localObject1 != null)
      {
        paramInt1 = paramInt2;
        if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a())
        {
          ((sdy)localObject1).a();
          paramInt1 = paramInt2;
        }
      }
      for (;;)
      {
        if (paramInt1 < this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildCount())
        {
          Object localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(paramInt1);
          if ((localObject2 instanceof ProteusItemView))
          {
            localObject2 = ((ProteusItemView)localObject2).a();
            if (localObject2 != null)
            {
              localObject2 = (sdy)((Container)localObject2).getTag(2131376186);
              if ((localObject2 != null) && (localObject2 != localObject1)) {
                ((sdy)localObject2).b();
              }
            }
          }
          paramInt1 += 1;
          continue;
          paramInt1 += 1;
          break;
        }
      }
      return;
      localObject1 = null;
    }
  }
  
  public void a(int paramInt, Intent paramIntent)
  {
    if (this.jdField_a_of_type_Rvy == null) {}
    long l1;
    int i1;
    rwc localrwc;
    do
    {
      do
      {
        do
        {
          return;
          switch (paramInt)
          {
          default: 
            return;
          }
        } while (this.jdField_c_of_type_Int == 0);
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video", 2, "onActivityResult for OPEN_FULLPLAY");
        }
        this.p = true;
        this.jdField_j_of_type_Boolean = false;
        l1 = -1L;
        i1 = -1;
        if (paramIntent != null)
        {
          l1 = paramIntent.getLongExtra("VIDEO_PLAY_POSITION", -1L);
          i1 = paramIntent.getIntExtra("VIDEO_PLAY_STATUS", -1);
        }
        if ((!this.jdField_a_of_type_Rvy.d()) || (!this.jdField_a_of_type_Rvy.c())) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("Q.readinjoy.video", 2, "onActivityResult video is pause  && isPausedByMannul, just return");
      return;
      localrwc = this.jdField_a_of_type_Rvy.a();
      if (localrwc != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.readinjoy.video", 2, "onActivityResult getCurrentPlayVideoParam = null, just return");
    return;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramIntent != null)
    {
      localObject1 = localObject2;
      if (paramIntent.getExtras() != null) {
        localObject1 = paramIntent.getExtras().getString("VIDEO_ARTICLE_ID");
      }
    }
    if (!TextUtils.equals(localrwc.jdField_j_of_type_JavaLangString, (CharSequence)localObject1))
    {
      paramIntent = b((String)localObject1);
      if (paramIntent == null)
      {
        l1 = localrwc.jdField_d_of_type_Long;
        paramInt = 0;
      }
    }
    for (;;)
    {
      label237:
      boolean bool;
      if ((i1 == 3) || (i1 == 0) || (i1 == 4))
      {
        bool = true;
        label254:
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video", 2, "onActivityResult shouldContinuePlay = " + bool + ", playState=" + rwe.a(i1) + ", startPosition=" + l1 + "，curPlayParam=" + localrwc);
        }
        if (!bool) {
          break label530;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video", 2, "onActivityResult continue play");
        }
        if (paramInt == 0) {
          break label442;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video", 2, "onActivityResult resume playResumeVideo:" + (String)localObject1);
        }
        a(paramIntent);
      }
      for (;;)
      {
        rxg.a().a(false, "readinoy video continuePlay", 1);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.readinjoy.video", 2, "volumeControl set mute shouldContinuePlay");
        return;
        if (paramIntent.jdField_a_of_type_Rwc != null) {
          paramIntent.jdField_a_of_type_Rwc.jdField_d_of_type_Long = l1;
        }
        paramInt = 1;
        break label237;
        bool = false;
        break label254;
        label442:
        if ((l1 >= 0L) && (localrwc != null))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.readinjoy.video", 2, "onActivityResult resume with position:" + l1);
          }
          this.jdField_a_of_type_Rvy.a((int)l1, localrwc);
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.readinjoy.video", 2, "onActivityResult resume");
          }
          this.jdField_a_of_type_Rvy.f(true);
        }
      }
      label530:
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "onActivityResult stop");
      }
      if (this.jdField_a_of_type_Pmw == null) {
        break;
      }
      long l2 = this.jdField_a_of_type_Rvy.a();
      this.jdField_a_of_type_Rvy.b(4);
      paramIntent = this.jdField_a_of_type_Pmw.a();
      if (l1 > 0L) {
        l2 = l1;
      }
      paramIntent.jdField_d_of_type_Long = l2;
      if (l1 > 0L) {
        this.jdField_a_of_type_Pmw.a().jdField_e_of_type_Int = -1;
      }
      this.jdField_a_of_type_Pmw = null;
      return;
      this.p = true;
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "onActivityResult for REFRESH_EVENT_CHECK_PLAYAREA");
      }
      x();
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, 50);
      QLog.d("gifvideo.ReadInJoyBaseAdapter", 2, "check shortcontent play");
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.readinjoy.video", 2, "do nothing!");
      return;
      paramInt = 0;
      paramIntent = null;
    }
  }
  
  public abstract void a(int paramInt, BaseArticleInfo paramBaseArticleInfo, ArrayList<DislikeInfo> paramArrayList);
  
  public abstract void a(int paramInt, ArrayList<BaseArticleInfo> paramArrayList, ArrayList<DislikeInfo> paramArrayList1);
  
  public void a(int paramInt, ArrayList<BaseArticleInfo> paramArrayList, ArrayList<DislikeInfo> paramArrayList1, Object paramObject)
  {
    a(paramInt, paramArrayList, paramArrayList1, paramObject, false, true);
  }
  
  public void a(int paramInt, ArrayList<BaseArticleInfo> paramArrayList, ArrayList<DislikeInfo> paramArrayList1, Object paramObject, boolean paramBoolean)
  {
    a(paramInt, paramArrayList, paramArrayList1, paramObject, paramBoolean, true);
  }
  
  public void a(int paramInt, ArrayList<BaseArticleInfo> paramArrayList, ArrayList<DislikeInfo> paramArrayList1, Object paramObject, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      this.jdField_b_of_type_JavaUtilList.removeAll(paramArrayList);
      this.o = true;
      notifyDataSetChanged();
    }
    BaseArticleInfo localBaseArticleInfo = null;
    if (paramArrayList.size() > 0) {
      localBaseArticleInfo = (BaseArticleInfo)paramArrayList.get(0);
    }
    int i1 = 2131698587;
    if (AdvertisementInfo.isAdvertisementInfo(localBaseArticleInfo)) {
      i1 = 2131698588;
    }
    if ((this.jdField_a_of_type_AndroidAppActivity instanceof BaseActivity))
    {
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, -1, this.jdField_a_of_type_AndroidAppActivity.getString(i1), 0).b(((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).getTitleBarHeight());
      a(paramInt, paramArrayList, paramArrayList1);
      if ((AdvertisementInfo.isAdvertisementInfo(localBaseArticleInfo)) || (tqg.a(localBaseArticleInfo)))
      {
        long l2 = 0L;
        long l1 = l2;
        if (paramObject != null)
        {
          l1 = l2;
          if ((paramObject instanceof DislikeInfo)) {
            l1 = ((DislikeInfo)paramObject).jdField_a_of_type_Long;
          }
        }
        paramArrayList = null;
        if (!(localBaseArticleInfo instanceof AdvertisementInfo)) {
          break label412;
        }
        paramArrayList = (AdvertisementInfo)localBaseArticleInfo;
        label178:
        pfa.a().a(this.jdField_a_of_type_AndroidAppActivity, paramArrayList, l1, paramArrayList1, paramBoolean1);
      }
    }
    for (;;)
    {
      try
      {
        paramArrayList = new JSONObject();
        paramArrayList.put("time", System.currentTimeMillis() / 1000L);
        paramArrayList.put("channel_id", this.jdField_c_of_type_Int);
        if (paramArrayList1 == null) {
          continue;
        }
        paramInt = paramArrayList1.size();
        paramArrayList.put("tag_num", paramInt);
        if (!(this.jdField_a_of_type_AndroidAppActivity instanceof BaseActivity)) {
          continue;
        }
        paramArrayList.put("folder_status", ozs.jdField_d_of_type_Int);
        paramArrayList.put("kandian_mode", ozs.e());
        if (localBaseArticleInfo != null)
        {
          paramArrayList.put("feeds_type", "" + ozs.a(localBaseArticleInfo));
          paramArrayList.put("rowkey", ubg.a(localBaseArticleInfo));
        }
        paramArrayList = paramArrayList.toString();
        ocd.a(null, "", "0X8007059", "0X8007059", 0, 0, "", "", ozs.a(paramArrayList1), paramArrayList, false);
      }
      catch (JSONException paramArrayList)
      {
        label412:
        paramArrayList.printStackTrace();
        continue;
      }
      qgr.a(localBaseArticleInfo);
      return;
      if (!(this.jdField_a_of_type_AndroidAppActivity instanceof PluginBaseActivity)) {
        break;
      }
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, -1, this.jdField_a_of_type_AndroidAppActivity.getString(i1), 0).b(((PluginBaseActivity)this.jdField_a_of_type_AndroidAppActivity).g());
      break;
      if (!tqg.a(localBaseArticleInfo)) {
        break label178;
      }
      paramArrayList = localBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
      break label178;
      paramInt = 0;
      continue;
      if ((this.jdField_a_of_type_AndroidAppActivity instanceof PluginBaseActivity))
      {
        paramArrayList.put("folder_status", 1);
        bdll.b(null, "CliOper", "", "", "0X8007060", "0X8007060", 0, 0, "", "", "", paramArrayList.toString());
      }
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a(paramInt, paramBoolean);
    }
  }
  
  public void a(long paramLong)
  {
    this.jdField_c_of_type_Long = paramLong;
  }
  
  public void a(View paramView, int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramInt == 46) {}
    while ((paramBaseArticleInfo instanceof AdvertisementInfo)) {
      return;
    }
    VideoReport.setElementId(paramView, "card");
    pda localpda = new pda().a(this.jdField_c_of_type_Int);
    if ((paramBaseArticleInfo != null) && (!TextUtils.isEmpty(paramBaseArticleInfo.innerUniqueID))) {}
    for (String str = paramBaseArticleInfo.innerUniqueID;; str = "null")
    {
      VideoReport.setElementParams(paramView, localpda.a(str).a());
      VideoReport.setElementReuseIdentifier(paramView, paramBaseArticleInfo.innerUniqueID);
      return;
    }
  }
  
  public void a(AdvertisementInfo paramAdvertisementInfo)
  {
    int i2 = 0;
    if (paramAdvertisementInfo == null) {}
    label16:
    label86:
    label216:
    label225:
    for (;;)
    {
      return;
      n();
      int i3 = -1;
      int i1 = 0;
      Object localObject;
      if (i1 < this.jdField_b_of_type_JavaUtilList.size())
      {
        localObject = (BaseArticleInfo)this.jdField_b_of_type_JavaUtilList.get(i1);
        if (((localObject instanceof AdvertisementInfo)) && (paramAdvertisementInfo.mAdTraceId.equals(((AdvertisementInfo)localObject).mAdTraceId))) {
          localObject = (AdvertisementInfo)localObject;
        }
      }
      for (;;)
      {
        if ((i1 < 0) || (localObject == null)) {
          break label225;
        }
        if (i2 < this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildCount()) {
          if (localObject != ((ppu)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(i2).getTag(2131381109)).a()) {}
        }
        for (paramAdvertisementInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(i2);; paramAdvertisementInfo = null)
        {
          if (paramAdvertisementInfo == null) {
            break label216;
          }
          if ((paramAdvertisementInfo instanceof ProteusItemView)) {
            paramAdvertisementInfo = ((ProteusItemView)paramAdvertisementInfo).a();
          }
          for (;;)
          {
            localObject = new sfr(this, (BaseArticleInfo)localObject, i1);
            Animation localAnimation = (Animation)paramAdvertisementInfo.getTag(2131369503);
            if (localAnimation == null) {
              break;
            }
            localAnimation.setAnimationListener((Animation.AnimationListener)localObject);
            paramAdvertisementInfo.startAnimation(localAnimation);
            return;
            i1 += 1;
            break label16;
            i2 += 1;
            break label86;
          }
        }
        break;
        localObject = null;
        i1 = i3;
      }
    }
  }
  
  public void a(BaseArticleInfo paramBaseArticleInfo)
  {
    this.jdField_b_of_type_JavaUtilList.remove(paramBaseArticleInfo);
    notifyDataSetChanged();
    this.o = true;
  }
  
  public void a(BaseArticleInfo paramBaseArticleInfo, ppu paramppu, long paramLong, int paramInt)
  {
    if ((paramBaseArticleInfo == null) || (this.jdField_b_of_type_JavaUtilSet == null) || (((paramBaseArticleInfo instanceof ArticleInfo)) && (jdField_a_of_type_Qai.b((ArticleInfo)paramBaseArticleInfo)))) {
      break label31;
    }
    label31:
    while ((((paramBaseArticleInfo instanceof ArticleInfo)) && (qgg.a((ArticleInfo)paramBaseArticleInfo))) || ((ozs.j(paramBaseArticleInfo)) && (!ozs.l(paramBaseArticleInfo)))) {
      return;
    }
    if ((paramBaseArticleInfo.hasOnlyTwoVideoFeeds()) && (paramBaseArticleInfo.mSubArtilceList.size() > 0) && (paramBaseArticleInfo.mFeedType != 121))
    {
      Iterator localIterator = paramBaseArticleInfo.mSubArtilceList.iterator();
      while (localIterator.hasNext()) {
        a((ArticleInfo)localIterator.next(), new pqk(this.jdField_a_of_type_AndroidAppActivity, (ArticleInfo)paramBaseArticleInfo, 46, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, paramInt, this.jdField_c_of_type_Boolean, getCount(), null, this), paramLong, paramInt);
      }
    }
    int i1;
    if ((ozs.s(paramBaseArticleInfo)) && (paramBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_Boolean)) {
      if (!this.jdField_a_of_type_JavaUtilMap.containsKey(Long.valueOf(-paramBaseArticleInfo.mArticleID))) {
        i1 = 1;
      }
    }
    for (;;)
    {
      if (i1 != 0) {
        ThreadManager.post(new ReadInJoyBaseAdapter.13(this, paramBaseArticleInfo, paramppu, paramInt, paramLong, paramBaseArticleInfo), 5, null, true);
      }
      if (!ozs.s()) {
        break;
      }
      ThreadManager.executeOnSubThread(new ReadInJoyBaseAdapter.14(this, paramBaseArticleInfo));
      return;
      i1 = 0;
      continue;
      if (!this.jdField_a_of_type_JavaUtilMap.containsKey(Long.valueOf(paramBaseArticleInfo.mArticleID))) {
        i1 = 1;
      } else {
        i1 = 0;
      }
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    Object localObject = a(paramAbsListView);
    if (this.jdField_c_of_type_Int == 40677) {}
    label16:
    do
    {
      do
      {
        do
        {
          break label16;
          do
          {
            return;
          } while (((this.jdField_a_of_type_Rvy != null) && (this.jdField_a_of_type_Rvy.h())) || (tqi.a().a() == 1));
          if (localObject == null) {
            break;
          }
          localObject = ((pmw)localObject).a();
        } while ((localObject != null) && (((rwc)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null) && (((rwc)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.patchStatus.a.get() == 1));
      } while ((this.jdField_a_of_type_Rvy == null) || (!this.jdField_a_of_type_Rmn.a()) || (this.jdField_a_of_type_Rmn.b()) || (paramAbsListView == null) || (paramAbsListView.getVisibility() != 0));
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1001);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1001, paramInt);
    } while (!QLog.isColorLevel());
    QLog.d("Q.readinjoy.video", 2, "checkPlayableArea delay: " + paramInt);
  }
  
  public void a(List<BaseArticleInfo> paramList)
  {
    pmq.a(this.jdField_a_of_type_AndroidUtilSparseArray, new sfi(this, "onSetData", paramList));
    StringBuilder localStringBuilder;
    if ((paramList != null) && (this.jdField_b_of_type_JavaUtilList.getClass().isInstance(paramList)) && (paramList.size() > 0))
    {
      d(paramList);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder("setData ");
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext())
        {
          BaseArticleInfo localBaseArticleInfo = (BaseArticleInfo)localIterator.next();
          localStringBuilder.append("recommendSeq = " + localBaseArticleInfo.mRecommendSeq + ",\n ");
        }
        QLog.d("ReadInJoyBaseAdapter", 1, localStringBuilder.toString());
      }
      this.jdField_b_of_type_JavaUtilList.clear();
      this.jdField_b_of_type_JavaUtilList.addAll(paramList);
      this.o = true;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("setData:");
      if (paramList != null) {
        break label232;
      }
    }
    label232:
    for (int i1 = 0;; i1 = paramList.size())
    {
      QLog.d("ReadInJoyBaseAdapter", 2, i1);
      this.jdField_d_of_type_Long = System.nanoTime();
      rmp.a().a(this, this.jdField_b_of_type_JavaUtilList);
      return;
    }
  }
  
  public void a(List<ArticleInfo> paramList, int paramInt)
  {
    this.jdField_b_of_type_JavaUtilList.removeAll(paramList);
    this.o = true;
    notifyDataSetChanged();
    int i1 = 0;
    if (i1 < paramList.size())
    {
      ArticleInfo localArticleInfo = (ArticleInfo)paramList.get(i1);
      if (localArticleInfo == null) {}
      for (;;)
      {
        i1 += 1;
        break;
        long l1 = localArticleInfo.mRecommendSeq;
        if (poc.a(l1)) {
          poc.a().a(this.jdField_c_of_type_Int, l1);
        } else {
          pfa.a().a(this.jdField_c_of_type_Int, localArticleInfo);
        }
      }
    }
    b(this.jdField_c_of_type_Int, paramInt);
  }
  
  public void a(Set<Long> paramSet, Map<Long, qvp> paramMap)
  {
    this.jdField_b_of_type_JavaUtilSet = paramSet;
    this.jdField_a_of_type_JavaUtilMap = paramMap;
  }
  
  public void a(nzj paramnzj)
  {
    this.jdField_a_of_type_Nzj = paramnzj;
  }
  
  /* Error */
  public void a(pmu parampmu, BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aload_2
    //   6: getfield 2943	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mSimpleVideoColumnInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo;
    //   9: ifnull +142 -> 151
    //   12: aload_2
    //   13: getfield 2943	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mSimpleVideoColumnInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo;
    //   16: astore 4
    //   18: aload 4
    //   20: getfield 2945	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:i	Ljava/lang/String;
    //   23: invokestatic 688	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   26: ifne +418 -> 444
    //   29: aload_1
    //   30: getfield 2949	pmu:jdField_f_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   33: aload 4
    //   35: getfield 2945	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:i	Ljava/lang/String;
    //   38: invokevirtual 2950	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   41: aload_1
    //   42: getfield 2949	pmu:jdField_f_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   45: iconst_0
    //   46: invokevirtual 1589	android/widget/TextView:setVisibility	(I)V
    //   49: aload 4
    //   51: getfield 2951	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   54: invokestatic 688	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   57: ifne +409 -> 466
    //   60: new 1132	java/net/URL
    //   63: dup
    //   64: aload 4
    //   66: getfield 2951	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   69: invokespecial 1570	java/net/URL:<init>	(Ljava/lang/String;)V
    //   72: astore 5
    //   74: aload_1
    //   75: getfield 2953	pmu:jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   78: aload 5
    //   80: invokevirtual 2957	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setImage	(Ljava/net/URL;)Lcom/tencent/biz/pubaccount/readinjoy/view/imageloader/ZImageView;
    //   83: pop
    //   84: aload_1
    //   85: getfield 2953	pmu:jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   88: iconst_0
    //   89: invokevirtual 1588	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setVisibility	(I)V
    //   92: aload 4
    //   94: getfield 2958	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   97: invokestatic 688	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   100: ifne +396 -> 496
    //   103: aload_1
    //   104: getfield 2960	pmu:g	Landroid/widget/TextView;
    //   107: aload 4
    //   109: getfield 2958	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   112: invokevirtual 2950	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   115: aload_1
    //   116: getfield 2960	pmu:g	Landroid/widget/TextView;
    //   119: iconst_0
    //   120: invokevirtual 1589	android/widget/TextView:setVisibility	(I)V
    //   123: aload 4
    //   125: getfield 2961	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:jdField_j_of_type_JavaLangString	Ljava/lang/String;
    //   128: invokestatic 688	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   131: ifne +20 -> 151
    //   134: aload 4
    //   136: getfield 2961	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:jdField_j_of_type_JavaLangString	Ljava/lang/String;
    //   139: invokestatic 131	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   142: istore_3
    //   143: aload_1
    //   144: getfield 2960	pmu:g	Landroid/widget/TextView;
    //   147: iload_3
    //   148: invokevirtual 2964	android/widget/TextView:setTextColor	(I)V
    //   151: aload_2
    //   152: invokestatic 1874	sel:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lrwc;
    //   155: astore 4
    //   157: aload 4
    //   159: aload_1
    //   160: getfield 2965	pmu:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   163: putfield 1880	rwc:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   166: aload 4
    //   168: aload_1
    //   169: getfield 2966	pmu:jdField_a_of_type_Int	I
    //   172: putfield 459	rwc:jdField_a_of_type_Int	I
    //   175: aload 4
    //   177: aload_2
    //   178: putfield 1105	rwc:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   181: aload_1
    //   182: aload 4
    //   184: putfield 2967	pmu:jdField_a_of_type_Rwc	Lrwc;
    //   187: aload_1
    //   188: getfield 2969	pmu:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   191: aload_2
    //   192: getfield 776	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mTitle	Ljava/lang/String;
    //   195: invokevirtual 2950	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   198: aload_1
    //   199: getfield 2969	pmu:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   202: invokevirtual 2973	android/widget/TextView:getPaint	()Landroid/text/TextPaint;
    //   205: iconst_1
    //   206: invokevirtual 2978	android/text/TextPaint:setFakeBoldText	(Z)V
    //   209: aload_1
    //   210: getfield 2969	pmu:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   213: aload_0
    //   214: getfield 322	sel:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   217: invokevirtual 1546	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   220: ldc_w 2979
    //   223: invokevirtual 2984	android/content/res/Resources:getColor	(I)I
    //   226: invokevirtual 2964	android/widget/TextView:setTextColor	(I)V
    //   229: aload_1
    //   230: getfield 2986	pmu:jdField_b_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   233: bipush 8
    //   235: invokevirtual 1589	android/widget/TextView:setVisibility	(I)V
    //   238: aload_1
    //   239: getfield 2988	pmu:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   242: aload 4
    //   244: getfield 547	rwc:jdField_b_of_type_Int	I
    //   247: iconst_1
    //   248: invokestatic 2991	ozc:a	(IZ)Ljava/lang/String;
    //   251: invokevirtual 2950	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   254: aload_1
    //   255: getfield 2993	pmu:jdField_b_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   258: bipush 10
    //   260: bipush 10
    //   262: bipush 10
    //   264: bipush 10
    //   266: invokestatic 2998	zps:a	(Landroid/view/View;IIII)V
    //   269: aload_1
    //   270: getfield 2993	pmu:jdField_b_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   273: aload_1
    //   274: invokevirtual 1871	android/widget/ImageView:setTag	(Ljava/lang/Object;)V
    //   277: aload_1
    //   278: getfield 2993	pmu:jdField_b_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   281: aload_0
    //   282: invokevirtual 1860	android/widget/ImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   285: aload_0
    //   286: getfield 322	sel:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   289: aload_1
    //   290: getfield 2965	pmu:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   293: aload_1
    //   294: getfield 2967	pmu:jdField_a_of_type_Rwc	Lrwc;
    //   297: invokestatic 3001	pms:a	(Landroid/content/Context;Landroid/widget/ImageView;Lrwc;)V
    //   300: aload_0
    //   301: aload_1
    //   302: getfield 2965	pmu:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   305: aload_2
    //   306: iconst_0
    //   307: invokevirtual 1038	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:getVideoCoverUrlWithSmartCut	(Z)Ljava/net/URL;
    //   310: iconst_0
    //   311: invokespecial 1646	sel:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;Ljava/net/URL;Z)V
    //   314: aload_1
    //   315: getfield 2965	pmu:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   318: aload_0
    //   319: invokevirtual 3005	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setOnLongClickListener	(Landroid/view/View$OnLongClickListener;)V
    //   322: aload_1
    //   323: getfield 3008	pmu:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup	Lcom/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup;
    //   326: fconst_1
    //   327: aload 4
    //   329: getfield 726	rwc:jdField_c_of_type_Int	I
    //   332: aload 4
    //   334: getfield 729	rwc:jdField_d_of_type_Int	I
    //   337: invokestatic 3011	ozc:a	(II)F
    //   340: invokevirtual 3017	com/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup:setCustomSize	(FF)V
    //   343: aload_1
    //   344: getfield 3008	pmu:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup	Lcom/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup;
    //   347: aload_1
    //   348: invokevirtual 3018	com/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup:setTag	(Ljava/lang/Object;)V
    //   351: aload_0
    //   352: aload_0
    //   353: getfield 142	sel:jdField_c_of_type_Int	I
    //   356: aload_2
    //   357: getfield 1022	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mArticleID	J
    //   360: invokevirtual 3020	sel:b	(IJ)Z
    //   363: ifeq +23 -> 386
    //   366: aload_1
    //   367: getfield 3022	pmu:jdField_f_of_type_AndroidViewView	Landroid/view/View;
    //   370: aload_0
    //   371: getfield 322	sel:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   374: invokevirtual 1546	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   377: ldc_w 3023
    //   380: invokevirtual 2984	android/content/res/Resources:getColor	(I)I
    //   383: invokevirtual 3026	android/view/View:setBackgroundColor	(I)V
    //   386: aload_2
    //   387: getfield 576	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mXGFileSize	J
    //   390: lconst_0
    //   391: lcmp
    //   392: ifgt +116 -> 508
    //   395: aload_1
    //   396: getfield 3028	pmu:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   399: ldc_w 3029
    //   402: invokestatic 1601	anzj:a	(I)Ljava/lang/String;
    //   405: invokevirtual 2950	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   408: aload_0
    //   409: getfield 322	sel:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   412: invokestatic 1157	bhnv:h	(Landroid/content/Context;)Z
    //   415: ifeq +132 -> 547
    //   418: aload_1
    //   419: getfield 3031	pmu:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   422: iconst_0
    //   423: invokevirtual 1616	android/widget/ImageView:setVisibility	(I)V
    //   426: aload_1
    //   427: getfield 3028	pmu:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   430: bipush 8
    //   432: invokevirtual 1589	android/widget/TextView:setVisibility	(I)V
    //   435: aload_1
    //   436: getfield 3033	pmu:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   439: iconst_0
    //   440: invokevirtual 3026	android/view/View:setBackgroundColor	(I)V
    //   443: return
    //   444: aload_1
    //   445: getfield 2949	pmu:jdField_f_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   448: bipush 8
    //   450: invokevirtual 1589	android/widget/TextView:setVisibility	(I)V
    //   453: goto -404 -> 49
    //   456: astore 5
    //   458: aload 5
    //   460: invokevirtual 3034	java/lang/Exception:printStackTrace	()V
    //   463: goto -371 -> 92
    //   466: aload_1
    //   467: getfield 2953	pmu:jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   470: bipush 8
    //   472: invokevirtual 1588	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setVisibility	(I)V
    //   475: goto -383 -> 92
    //   478: astore 4
    //   480: aload_1
    //   481: getfield 2960	pmu:g	Landroid/widget/TextView;
    //   484: ldc_w 3036
    //   487: invokestatic 131	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   490: invokevirtual 2964	android/widget/TextView:setTextColor	(I)V
    //   493: goto -342 -> 151
    //   496: aload_1
    //   497: getfield 2960	pmu:g	Landroid/widget/TextView;
    //   500: bipush 8
    //   502: invokevirtual 1589	android/widget/TextView:setVisibility	(I)V
    //   505: goto -354 -> 151
    //   508: aload_1
    //   509: getfield 3028	pmu:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   512: new 741	java/lang/StringBuilder
    //   515: dup
    //   516: invokespecial 742	java/lang/StringBuilder:<init>	()V
    //   519: aload_2
    //   520: getfield 576	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mXGFileSize	J
    //   523: invokestatic 3037	rpt:b	(J)Ljava/lang/String;
    //   526: invokevirtual 746	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   529: ldc_w 3038
    //   532: invokestatic 1601	anzj:a	(I)Ljava/lang/String;
    //   535: invokevirtual 746	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   538: invokevirtual 752	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   541: invokevirtual 2950	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   544: goto -136 -> 408
    //   547: aload_1
    //   548: getfield 3031	pmu:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   551: bipush 8
    //   553: invokevirtual 1616	android/widget/ImageView:setVisibility	(I)V
    //   556: aload_0
    //   557: getfield 322	sel:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   560: invokevirtual 1546	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   563: ldc_w 3039
    //   566: invokevirtual 3042	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   569: astore 4
    //   571: aload_1
    //   572: getfield 3028	pmu:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   575: aload 4
    //   577: aconst_null
    //   578: aconst_null
    //   579: aconst_null
    //   580: invokevirtual 3046	android/widget/TextView:setCompoundDrawablesWithIntrinsicBounds	(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V
    //   583: aload_1
    //   584: getfield 3028	pmu:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   587: ldc_w 2317
    //   590: aload_0
    //   591: getfield 322	sel:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   594: invokevirtual 1546	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   597: invokestatic 486	agej:a	(FLandroid/content/res/Resources;)I
    //   600: invokevirtual 3049	android/widget/TextView:setCompoundDrawablePadding	(I)V
    //   603: aload_1
    //   604: getfield 3028	pmu:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   607: iconst_0
    //   608: invokevirtual 1589	android/widget/TextView:setVisibility	(I)V
    //   611: invokestatic 3052	bihq:a	()I
    //   614: iconst_1
    //   615: if_icmpne +34 -> 649
    //   618: aload_1
    //   619: getfield 3028	pmu:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   622: ldc_w 3053
    //   625: invokestatic 1601	anzj:a	(I)Ljava/lang/String;
    //   628: invokevirtual 2950	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   631: aload_1
    //   632: getfield 3055	pmu:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   635: bipush 8
    //   637: invokevirtual 1589	android/widget/TextView:setVisibility	(I)V
    //   640: aload_1
    //   641: getfield 3033	pmu:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   644: iconst_0
    //   645: invokevirtual 3026	android/view/View:setBackgroundColor	(I)V
    //   648: return
    //   649: invokestatic 3057	bnrf:v	()Z
    //   652: ifeq +281 -> 933
    //   655: aload_0
    //   656: getfield 3058	sel:jdField_h_of_type_Boolean	Z
    //   659: ifne +274 -> 933
    //   662: aload_1
    //   663: getfield 2966	pmu:jdField_a_of_type_Int	I
    //   666: ifne +267 -> 933
    //   669: invokestatic 3060	bnrf:e	()Ljava/lang/String;
    //   672: astore 5
    //   674: invokestatic 3062	bnrf:f	()Ljava/lang/String;
    //   677: astore 6
    //   679: invokestatic 3064	bnrf:g	()Ljava/lang/String;
    //   682: astore 7
    //   684: aload 5
    //   686: invokestatic 688	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   689: ifne +210 -> 899
    //   692: invokestatic 3066	ozs:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   695: astore 8
    //   697: ldc_w 828
    //   700: astore 4
    //   702: aload 8
    //   704: ifnull +10 -> 714
    //   707: aload 8
    //   709: invokevirtual 3069	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   712: astore 4
    //   714: new 1333	sbg
    //   717: dup
    //   718: aconst_null
    //   719: aconst_null
    //   720: aconst_null
    //   721: aconst_null
    //   722: invokespecial 1336	sbg:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   725: aload 4
    //   727: invokevirtual 3072	sbg:m	(Ljava/lang/String;)Lsbg;
    //   730: aload_2
    //   731: getfield 677	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:innerUniqueID	Ljava/lang/String;
    //   734: invokevirtual 3074	sbg:i	(Ljava/lang/String;)Lsbg;
    //   737: invokevirtual 1359	sbg:a	()Lsbf;
    //   740: invokevirtual 1363	sbf:a	()Ljava/lang/String;
    //   743: astore_2
    //   744: aload_1
    //   745: getfield 3055	pmu:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   748: iconst_0
    //   749: invokevirtual 1589	android/widget/TextView:setVisibility	(I)V
    //   752: aload_1
    //   753: getfield 3055	pmu:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   756: fconst_2
    //   757: aload_0
    //   758: getfield 322	sel:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   761: invokevirtual 1546	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   764: invokestatic 486	agej:a	(FLandroid/content/res/Resources;)I
    //   767: invokevirtual 3049	android/widget/TextView:setCompoundDrawablePadding	(I)V
    //   770: aload_0
    //   771: getfield 322	sel:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   774: invokevirtual 1546	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   777: ldc_w 3075
    //   780: invokevirtual 3042	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   783: astore 4
    //   785: aload 4
    //   787: iconst_0
    //   788: iconst_0
    //   789: ldc_w 3076
    //   792: aload_0
    //   793: getfield 322	sel:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   796: invokevirtual 1546	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   799: invokestatic 486	agej:a	(FLandroid/content/res/Resources;)I
    //   802: ldc_w 3076
    //   805: aload_0
    //   806: getfield 322	sel:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   809: invokevirtual 1546	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   812: invokestatic 486	agej:a	(FLandroid/content/res/Resources;)I
    //   815: invokevirtual 3081	android/graphics/drawable/Drawable:setBounds	(IIII)V
    //   818: aload_1
    //   819: getfield 3055	pmu:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   822: aconst_null
    //   823: aconst_null
    //   824: aload 4
    //   826: aconst_null
    //   827: invokevirtual 3084	android/widget/TextView:setCompoundDrawables	(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V
    //   830: aload_0
    //   831: getfield 322	sel:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   834: aload_1
    //   835: getfield 3055	pmu:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   838: aload 6
    //   840: aload 7
    //   842: aload 5
    //   844: new 3086	sfz
    //   847: dup
    //   848: aload_0
    //   849: aload_2
    //   850: aload_1
    //   851: invokespecial 3089	sfz:<init>	(Lsel;Ljava/lang/String;Lpmu;)V
    //   854: invokestatic 3092	rpt:b	(Landroid/content/Context;Landroid/widget/TextView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/view/View$OnClickListener;)V
    //   857: aload_1
    //   858: getfield 3033	pmu:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   861: ldc_w 3093
    //   864: invokevirtual 3026	android/view/View:setBackgroundColor	(I)V
    //   867: aload_0
    //   868: iconst_1
    //   869: putfield 3058	sel:jdField_h_of_type_Boolean	Z
    //   872: aconst_null
    //   873: ldc_w 828
    //   876: ldc_w 3095
    //   879: ldc_w 3095
    //   882: iconst_0
    //   883: iconst_0
    //   884: ldc_w 828
    //   887: ldc_w 828
    //   890: ldc_w 828
    //   893: aload_2
    //   894: iconst_0
    //   895: invokestatic 1372	ocd:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   898: return
    //   899: aload_1
    //   900: getfield 3055	pmu:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   903: bipush 8
    //   905: invokevirtual 1589	android/widget/TextView:setVisibility	(I)V
    //   908: aload_1
    //   909: getfield 3033	pmu:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   912: iconst_0
    //   913: invokevirtual 3026	android/view/View:setBackgroundColor	(I)V
    //   916: invokestatic 416	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   919: ifeq -915 -> 4
    //   922: ldc_w 988
    //   925: iconst_2
    //   926: ldc_w 3097
    //   929: invokestatic 993	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   932: return
    //   933: aload_1
    //   934: getfield 3055	pmu:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   937: bipush 8
    //   939: invokevirtual 1589	android/widget/TextView:setVisibility	(I)V
    //   942: aload_1
    //   943: getfield 3033	pmu:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   946: iconst_0
    //   947: invokevirtual 3026	android/view/View:setBackgroundColor	(I)V
    //   950: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	951	0	this	sel
    //   0	951	1	parampmu	pmu
    //   0	951	2	paramBaseArticleInfo	BaseArticleInfo
    //   0	951	3	paramInt	int
    //   16	317	4	localObject1	Object
    //   478	1	4	localThrowable	Throwable
    //   569	256	4	localObject2	Object
    //   72	7	5	localURL	URL
    //   456	3	5	localException	Exception
    //   672	171	5	str1	String
    //   677	162	6	str2	String
    //   682	159	7	str3	String
    //   695	13	8	localQQAppInterface	QQAppInterface
    // Exception table:
    //   from	to	target	type
    //   60	92	456	java/lang/Exception
    //   134	151	478	java/lang/Throwable
  }
  
  /* Error */
  public void a(pmv parampmv, BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aload_2
    //   6: getfield 3101	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mArticleSubscriptText	Ljava/lang/String;
    //   9: invokestatic 688	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   12: ifne +516 -> 528
    //   15: aload_1
    //   16: getfield 3104	pmv:i	Landroid/widget/TextView;
    //   19: aload_2
    //   20: getfield 3101	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mArticleSubscriptText	Ljava/lang/String;
    //   23: invokevirtual 2950	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   26: aload_2
    //   27: getfield 3107	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mArticleSubscriptColor	Ljava/lang/String;
    //   30: invokestatic 688	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   33: ifeq +486 -> 519
    //   36: ldc_w 3109
    //   39: astore 4
    //   41: aload 4
    //   43: invokestatic 131	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   46: istore_3
    //   47: aload_1
    //   48: getfield 3104	pmv:i	Landroid/widget/TextView;
    //   51: iload_3
    //   52: invokevirtual 2964	android/widget/TextView:setTextColor	(I)V
    //   55: aload_1
    //   56: getfield 3104	pmv:i	Landroid/widget/TextView;
    //   59: iconst_0
    //   60: invokevirtual 1589	android/widget/TextView:setVisibility	(I)V
    //   63: aload_1
    //   64: getfield 3110	pmv:g	Landroid/widget/TextView;
    //   67: aload_2
    //   68: getfield 524	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mSubscribeName	Ljava/lang/String;
    //   71: invokevirtual 2950	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   74: aload_2
    //   75: invokevirtual 1562	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:hasFamilyCommentIcon	()Z
    //   78: ifeq +477 -> 555
    //   81: new 1132	java/net/URL
    //   84: dup
    //   85: aload_2
    //   86: getfield 1566	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:familyCommentInfo	Lqvz;
    //   89: getfield 1569	qvz:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   92: invokespecial 1570	java/net/URL:<init>	(Ljava/lang/String;)V
    //   95: astore 4
    //   97: aload_2
    //   98: getfield 1566	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:familyCommentInfo	Lqvz;
    //   101: getfield 1571	qvz:jdField_b_of_type_Int	I
    //   104: ifle +27 -> 131
    //   107: aload_0
    //   108: aload_1
    //   109: getfield 3111	pmv:jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   112: aload 4
    //   114: aload_2
    //   115: getfield 1566	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:familyCommentInfo	Lqvz;
    //   118: getfield 1572	qvz:jdField_a_of_type_Int	I
    //   121: aload_2
    //   122: getfield 1566	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:familyCommentInfo	Lqvz;
    //   125: getfield 1571	qvz:jdField_b_of_type_Int	I
    //   128: invokespecial 1575	sel:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;Ljava/net/URL;II)V
    //   131: aload_1
    //   132: getfield 3111	pmv:jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   135: iconst_0
    //   136: invokevirtual 1588	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setVisibility	(I)V
    //   139: aload_1
    //   140: getfield 3112	pmv:h	Landroid/widget/TextView;
    //   143: bipush 8
    //   145: invokevirtual 1589	android/widget/TextView:setVisibility	(I)V
    //   148: aload_2
    //   149: getfield 3115	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:vIconUrl	Ljava/lang/String;
    //   152: invokestatic 688	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   155: ifne +476 -> 631
    //   158: new 1132	java/net/URL
    //   161: dup
    //   162: aload_2
    //   163: getfield 3115	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:vIconUrl	Ljava/lang/String;
    //   166: invokespecial 1570	java/net/URL:<init>	(Ljava/lang/String;)V
    //   169: astore 4
    //   171: aload_1
    //   172: getfield 3117	pmv:jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   175: aload 4
    //   177: invokevirtual 2957	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setImage	(Ljava/net/URL;)Lcom/tencent/biz/pubaccount/readinjoy/view/imageloader/ZImageView;
    //   180: pop
    //   181: aload_1
    //   182: getfield 3117	pmv:jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   185: iconst_0
    //   186: invokevirtual 1588	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setVisibility	(I)V
    //   189: aload_1
    //   190: getfield 3118	pmv:jdField_b_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   193: bipush 10
    //   195: bipush 10
    //   197: bipush 10
    //   199: bipush 10
    //   201: invokestatic 2998	zps:a	(Landroid/view/View;IIII)V
    //   204: aload_1
    //   205: getfield 3118	pmv:jdField_b_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   208: aload_1
    //   209: invokevirtual 1871	android/widget/ImageView:setTag	(Ljava/lang/Object;)V
    //   212: aload_1
    //   213: getfield 3118	pmv:jdField_b_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   216: aload_0
    //   217: invokevirtual 1860	android/widget/ImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   220: aload_2
    //   221: invokestatic 1874	sel:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lrwc;
    //   224: astore 4
    //   226: aload 4
    //   228: aload_1
    //   229: getfield 3119	pmv:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   232: putfield 1880	rwc:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   235: aload 4
    //   237: aload_1
    //   238: getfield 3120	pmv:jdField_a_of_type_Int	I
    //   241: putfield 459	rwc:jdField_a_of_type_Int	I
    //   244: aload 4
    //   246: aload_2
    //   247: putfield 1105	rwc:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   250: aload 4
    //   252: iconst_1
    //   253: putfield 3122	rwc:jdField_n_of_type_Int	I
    //   256: aload_1
    //   257: aload 4
    //   259: putfield 3123	pmv:jdField_a_of_type_Rwc	Lrwc;
    //   262: aload_1
    //   263: getfield 3124	pmv:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   266: bipush 8
    //   268: invokevirtual 1589	android/widget/TextView:setVisibility	(I)V
    //   271: aload_1
    //   272: getfield 3125	pmv:jdField_b_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   275: bipush 8
    //   277: invokevirtual 1589	android/widget/TextView:setVisibility	(I)V
    //   280: aload_1
    //   281: getfield 3127	pmv:jdField_c_of_type_AndroidViewView	Landroid/view/View;
    //   284: bipush 8
    //   286: invokevirtual 1559	android/view/View:setVisibility	(I)V
    //   289: aload_1
    //   290: getfield 3128	pmv:jdField_f_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   293: aload_2
    //   294: getfield 776	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mTitle	Ljava/lang/String;
    //   297: invokevirtual 2950	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   300: aload_1
    //   301: getfield 3128	pmv:jdField_f_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   304: astore 5
    //   306: invokestatic 2157	pfa:a	()Lpfa;
    //   309: aload_2
    //   310: getfield 1022	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mArticleID	J
    //   313: invokevirtual 3129	pfa:a	(J)Z
    //   316: ifeq +327 -> 643
    //   319: getstatic 133	sel:jdField_g_of_type_Int	I
    //   322: istore_3
    //   323: aload 5
    //   325: iload_3
    //   326: invokevirtual 2964	android/widget/TextView:setTextColor	(I)V
    //   329: aload_1
    //   330: getfield 3130	pmv:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   333: aload 4
    //   335: getfield 547	rwc:jdField_b_of_type_Int	I
    //   338: iconst_1
    //   339: invokestatic 2991	ozc:a	(IZ)Ljava/lang/String;
    //   342: invokevirtual 2950	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   345: aload_0
    //   346: getfield 322	sel:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   349: aload_1
    //   350: getfield 3119	pmv:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   353: aload_1
    //   354: getfield 3123	pmv:jdField_a_of_type_Rwc	Lrwc;
    //   357: invokestatic 3001	pms:a	(Landroid/content/Context;Landroid/widget/ImageView;Lrwc;)V
    //   360: aload_0
    //   361: aload_1
    //   362: getfield 3119	pmv:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   365: aload_2
    //   366: iconst_0
    //   367: invokevirtual 1038	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:getVideoCoverUrlWithSmartCut	(Z)Ljava/net/URL;
    //   370: iconst_0
    //   371: invokespecial 1646	sel:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;Ljava/net/URL;Z)V
    //   374: aload_1
    //   375: getfield 3119	pmv:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   378: aload_0
    //   379: invokevirtual 3005	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setOnLongClickListener	(Landroid/view/View$OnLongClickListener;)V
    //   382: aload_1
    //   383: getfield 3130	pmv:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   386: iconst_0
    //   387: invokevirtual 1589	android/widget/TextView:setVisibility	(I)V
    //   390: aload_1
    //   391: getfield 3130	pmv:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   394: invokevirtual 3133	android/widget/TextView:clearAnimation	()V
    //   397: aload_1
    //   398: getfield 3134	pmv:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup	Lcom/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup;
    //   401: fconst_1
    //   402: aload 4
    //   404: getfield 726	rwc:jdField_c_of_type_Int	I
    //   407: aload 4
    //   409: getfield 729	rwc:jdField_d_of_type_Int	I
    //   412: invokestatic 3011	ozc:a	(II)F
    //   415: invokevirtual 3017	com/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup:setCustomSize	(FF)V
    //   418: aload_1
    //   419: getfield 3134	pmv:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup	Lcom/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup;
    //   422: aload_1
    //   423: invokevirtual 3018	com/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup:setTag	(Ljava/lang/Object;)V
    //   426: aload_0
    //   427: aload_0
    //   428: getfield 142	sel:jdField_c_of_type_Int	I
    //   431: aload_2
    //   432: getfield 1022	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mArticleID	J
    //   435: invokevirtual 3020	sel:b	(IJ)Z
    //   438: ifeq +23 -> 461
    //   441: aload_1
    //   442: getfield 3135	pmv:jdField_f_of_type_AndroidViewView	Landroid/view/View;
    //   445: aload_0
    //   446: getfield 322	sel:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   449: invokevirtual 1546	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   452: ldc_w 3023
    //   455: invokevirtual 2984	android/content/res/Resources:getColor	(I)I
    //   458: invokevirtual 3026	android/view/View:setBackgroundColor	(I)V
    //   461: aload_2
    //   462: getfield 576	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mXGFileSize	J
    //   465: lconst_0
    //   466: lcmp
    //   467: ifgt +183 -> 650
    //   470: aload_1
    //   471: getfield 3136	pmv:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   474: ldc_w 3029
    //   477: invokestatic 1601	anzj:a	(I)Ljava/lang/String;
    //   480: invokevirtual 2950	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   483: aload_0
    //   484: getfield 322	sel:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   487: invokestatic 1157	bhnv:h	(Landroid/content/Context;)Z
    //   490: ifeq +199 -> 689
    //   493: aload_1
    //   494: getfield 3137	pmv:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   497: iconst_0
    //   498: invokevirtual 1616	android/widget/ImageView:setVisibility	(I)V
    //   501: aload_1
    //   502: getfield 3136	pmv:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   505: bipush 8
    //   507: invokevirtual 1589	android/widget/TextView:setVisibility	(I)V
    //   510: aload_1
    //   511: getfield 3138	pmv:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   514: iconst_0
    //   515: invokevirtual 3026	android/view/View:setBackgroundColor	(I)V
    //   518: return
    //   519: aload_2
    //   520: getfield 3107	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mArticleSubscriptColor	Ljava/lang/String;
    //   523: astore 4
    //   525: goto -484 -> 41
    //   528: aload_1
    //   529: getfield 3104	pmv:i	Landroid/widget/TextView;
    //   532: bipush 8
    //   534: invokevirtual 1589	android/widget/TextView:setVisibility	(I)V
    //   537: goto -474 -> 63
    //   540: astore 4
    //   542: ldc_w 418
    //   545: iconst_2
    //   546: ldc_w 3140
    //   549: invokestatic 423	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   552: goto -404 -> 148
    //   555: aload_1
    //   556: getfield 3111	pmv:jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   559: bipush 8
    //   561: invokevirtual 1588	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setVisibility	(I)V
    //   564: aload_1
    //   565: getfield 3112	pmv:h	Landroid/widget/TextView;
    //   568: iconst_0
    //   569: invokevirtual 1589	android/widget/TextView:setVisibility	(I)V
    //   572: ldc_w 418
    //   575: iconst_2
    //   576: ldc_w 3142
    //   579: invokestatic 423	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   582: aload_1
    //   583: getfield 3112	pmv:h	Landroid/widget/TextView;
    //   586: new 741	java/lang/StringBuilder
    //   589: dup
    //   590: invokespecial 742	java/lang/StringBuilder:<init>	()V
    //   593: aload_2
    //   594: invokevirtual 1596	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:getCommentCount	()I
    //   597: invokestatic 3144	rpt:d	(I)Ljava/lang/String;
    //   600: invokevirtual 746	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   603: ldc_w 3145
    //   606: invokestatic 1601	anzj:a	(I)Ljava/lang/String;
    //   609: invokevirtual 746	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   612: invokevirtual 752	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   615: invokevirtual 2950	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   618: goto -470 -> 148
    //   621: astore 4
    //   623: aload 4
    //   625: invokevirtual 3034	java/lang/Exception:printStackTrace	()V
    //   628: goto -439 -> 189
    //   631: aload_1
    //   632: getfield 3117	pmv:jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   635: bipush 8
    //   637: invokevirtual 1588	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setVisibility	(I)V
    //   640: goto -451 -> 189
    //   643: getstatic 137	sel:jdField_h_of_type_Int	I
    //   646: istore_3
    //   647: goto -324 -> 323
    //   650: aload_1
    //   651: getfield 3136	pmv:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   654: new 741	java/lang/StringBuilder
    //   657: dup
    //   658: invokespecial 742	java/lang/StringBuilder:<init>	()V
    //   661: aload_2
    //   662: getfield 576	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mXGFileSize	J
    //   665: invokestatic 3037	rpt:b	(J)Ljava/lang/String;
    //   668: invokevirtual 746	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   671: ldc_w 3038
    //   674: invokestatic 1601	anzj:a	(I)Ljava/lang/String;
    //   677: invokevirtual 746	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   680: invokevirtual 752	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   683: invokevirtual 2950	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   686: goto -203 -> 483
    //   689: aload_1
    //   690: getfield 3137	pmv:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   693: bipush 8
    //   695: invokevirtual 1616	android/widget/ImageView:setVisibility	(I)V
    //   698: aload_0
    //   699: getfield 322	sel:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   702: invokevirtual 1546	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   705: ldc_w 3039
    //   708: invokevirtual 3042	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   711: astore 4
    //   713: aload_1
    //   714: getfield 3136	pmv:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   717: aload 4
    //   719: aconst_null
    //   720: aconst_null
    //   721: aconst_null
    //   722: invokevirtual 3046	android/widget/TextView:setCompoundDrawablesWithIntrinsicBounds	(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V
    //   725: aload_1
    //   726: getfield 3136	pmv:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   729: ldc_w 2317
    //   732: aload_0
    //   733: getfield 322	sel:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   736: invokevirtual 1546	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   739: invokestatic 486	agej:a	(FLandroid/content/res/Resources;)I
    //   742: invokevirtual 3049	android/widget/TextView:setCompoundDrawablePadding	(I)V
    //   745: aload_1
    //   746: getfield 3136	pmv:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   749: iconst_0
    //   750: invokevirtual 1589	android/widget/TextView:setVisibility	(I)V
    //   753: invokestatic 3052	bihq:a	()I
    //   756: iconst_1
    //   757: if_icmpne +34 -> 791
    //   760: aload_1
    //   761: getfield 3136	pmv:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   764: ldc_w 3053
    //   767: invokestatic 1601	anzj:a	(I)Ljava/lang/String;
    //   770: invokevirtual 2950	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   773: aload_1
    //   774: getfield 3146	pmv:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   777: bipush 8
    //   779: invokevirtual 1589	android/widget/TextView:setVisibility	(I)V
    //   782: aload_1
    //   783: getfield 3138	pmv:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   786: iconst_0
    //   787: invokevirtual 3026	android/view/View:setBackgroundColor	(I)V
    //   790: return
    //   791: invokestatic 3057	bnrf:v	()Z
    //   794: ifeq +281 -> 1075
    //   797: aload_0
    //   798: getfield 3058	sel:jdField_h_of_type_Boolean	Z
    //   801: ifne +274 -> 1075
    //   804: aload_1
    //   805: getfield 3120	pmv:jdField_a_of_type_Int	I
    //   808: ifne +267 -> 1075
    //   811: invokestatic 3060	bnrf:e	()Ljava/lang/String;
    //   814: astore 5
    //   816: invokestatic 3062	bnrf:f	()Ljava/lang/String;
    //   819: astore 6
    //   821: invokestatic 3064	bnrf:g	()Ljava/lang/String;
    //   824: astore 7
    //   826: aload 5
    //   828: invokestatic 688	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   831: ifne +210 -> 1041
    //   834: invokestatic 3066	ozs:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   837: astore 8
    //   839: ldc_w 828
    //   842: astore 4
    //   844: aload 8
    //   846: ifnull +10 -> 856
    //   849: aload 8
    //   851: invokevirtual 3069	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   854: astore 4
    //   856: new 1333	sbg
    //   859: dup
    //   860: aconst_null
    //   861: aconst_null
    //   862: aconst_null
    //   863: aconst_null
    //   864: invokespecial 1336	sbg:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   867: aload 4
    //   869: invokevirtual 3072	sbg:m	(Ljava/lang/String;)Lsbg;
    //   872: aload_2
    //   873: getfield 677	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:innerUniqueID	Ljava/lang/String;
    //   876: invokevirtual 3074	sbg:i	(Ljava/lang/String;)Lsbg;
    //   879: invokevirtual 1359	sbg:a	()Lsbf;
    //   882: invokevirtual 1363	sbf:a	()Ljava/lang/String;
    //   885: astore_2
    //   886: aload_1
    //   887: getfield 3146	pmv:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   890: iconst_0
    //   891: invokevirtual 1589	android/widget/TextView:setVisibility	(I)V
    //   894: aload_1
    //   895: getfield 3146	pmv:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   898: fconst_2
    //   899: aload_0
    //   900: getfield 322	sel:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   903: invokevirtual 1546	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   906: invokestatic 486	agej:a	(FLandroid/content/res/Resources;)I
    //   909: invokevirtual 3049	android/widget/TextView:setCompoundDrawablePadding	(I)V
    //   912: aload_0
    //   913: getfield 322	sel:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   916: invokevirtual 1546	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   919: ldc_w 3075
    //   922: invokevirtual 3042	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   925: astore 4
    //   927: aload 4
    //   929: iconst_0
    //   930: iconst_0
    //   931: ldc_w 3076
    //   934: aload_0
    //   935: getfield 322	sel:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   938: invokevirtual 1546	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   941: invokestatic 486	agej:a	(FLandroid/content/res/Resources;)I
    //   944: ldc_w 3076
    //   947: aload_0
    //   948: getfield 322	sel:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   951: invokevirtual 1546	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   954: invokestatic 486	agej:a	(FLandroid/content/res/Resources;)I
    //   957: invokevirtual 3081	android/graphics/drawable/Drawable:setBounds	(IIII)V
    //   960: aload_1
    //   961: getfield 3146	pmv:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   964: aconst_null
    //   965: aconst_null
    //   966: aload 4
    //   968: aconst_null
    //   969: invokevirtual 3084	android/widget/TextView:setCompoundDrawables	(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V
    //   972: aload_0
    //   973: getfield 322	sel:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   976: aload_1
    //   977: getfield 3146	pmv:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   980: aload 6
    //   982: aload 7
    //   984: aload 5
    //   986: new 3148	sfy
    //   989: dup
    //   990: aload_0
    //   991: aload_2
    //   992: aload_1
    //   993: invokespecial 3151	sfy:<init>	(Lsel;Ljava/lang/String;Lpmv;)V
    //   996: invokestatic 3092	rpt:b	(Landroid/content/Context;Landroid/widget/TextView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/view/View$OnClickListener;)V
    //   999: aload_1
    //   1000: getfield 3138	pmv:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   1003: ldc_w 3093
    //   1006: invokevirtual 3026	android/view/View:setBackgroundColor	(I)V
    //   1009: aload_0
    //   1010: iconst_1
    //   1011: putfield 3058	sel:jdField_h_of_type_Boolean	Z
    //   1014: aconst_null
    //   1015: ldc_w 828
    //   1018: ldc_w 3095
    //   1021: ldc_w 3095
    //   1024: iconst_0
    //   1025: iconst_0
    //   1026: ldc_w 828
    //   1029: ldc_w 828
    //   1032: ldc_w 828
    //   1035: aload_2
    //   1036: iconst_0
    //   1037: invokestatic 1372	ocd:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   1040: return
    //   1041: aload_1
    //   1042: getfield 3146	pmv:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   1045: bipush 8
    //   1047: invokevirtual 1589	android/widget/TextView:setVisibility	(I)V
    //   1050: aload_1
    //   1051: getfield 3138	pmv:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   1054: iconst_0
    //   1055: invokevirtual 3026	android/view/View:setBackgroundColor	(I)V
    //   1058: invokestatic 416	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1061: ifeq -1057 -> 4
    //   1064: ldc_w 988
    //   1067: iconst_2
    //   1068: ldc_w 3097
    //   1071: invokestatic 993	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1074: return
    //   1075: aload_1
    //   1076: getfield 3146	pmv:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   1079: bipush 8
    //   1081: invokevirtual 1589	android/widget/TextView:setVisibility	(I)V
    //   1084: aload_1
    //   1085: getfield 3138	pmv:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   1088: iconst_0
    //   1089: invokevirtual 3026	android/view/View:setBackgroundColor	(I)V
    //   1092: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1093	0	this	sel
    //   0	1093	1	parampmv	pmv
    //   0	1093	2	paramBaseArticleInfo	BaseArticleInfo
    //   0	1093	3	paramInt	int
    //   39	485	4	localObject1	Object
    //   540	1	4	localMalformedURLException	MalformedURLException
    //   621	3	4	localException	Exception
    //   711	256	4	localObject2	Object
    //   304	681	5	localObject3	Object
    //   819	162	6	str1	String
    //   824	159	7	str2	String
    //   837	13	8	localQQAppInterface	QQAppInterface
    // Exception table:
    //   from	to	target	type
    //   81	131	540	java/net/MalformedURLException
    //   131	148	540	java/net/MalformedURLException
    //   158	189	621	java/lang/Exception
  }
  
  public void a(pmw parampmw)
  {
    this.jdField_a_of_type_Rvy.b(2);
    this.jdField_a_of_type_Pmw = parampmw;
    this.jdField_a_of_type_Rwc = parampmw.a();
    this.jdField_a_of_type_Rvy.a(this.jdField_a_of_type_Rwc);
  }
  
  /* Error */
  public void a(pmx parampmx, BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aload_1
    //   6: getfield 3158	pmx:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   9: invokevirtual 2973	android/widget/TextView:getPaint	()Landroid/text/TextPaint;
    //   12: iconst_1
    //   13: invokevirtual 2978	android/text/TextPaint:setFakeBoldText	(Z)V
    //   16: aload_2
    //   17: getfield 2220	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mVideoColumnInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo;
    //   20: ifnull +390 -> 410
    //   23: aload_2
    //   24: getfield 2220	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mVideoColumnInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo;
    //   27: astore 5
    //   29: aload 5
    //   31: getfield 3159	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:jdField_d_of_type_Int	I
    //   34: iconst_1
    //   35: if_icmpne +691 -> 726
    //   38: aload_1
    //   39: getfield 3160	pmx:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   42: invokevirtual 1648	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   45: astore 4
    //   47: aload 4
    //   49: aload_0
    //   50: getfield 322	sel:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   53: ldc_w 3161
    //   56: invokestatic 1125	bhgr:a	(Landroid/content/Context;F)I
    //   59: putfield 1665	android/view/ViewGroup$LayoutParams:height	I
    //   62: aload_1
    //   63: getfield 3160	pmx:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   66: aload 4
    //   68: invokevirtual 1678	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   71: aload 5
    //   73: getfield 3162	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   76: invokestatic 688	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   79: ifne +683 -> 762
    //   82: aload_0
    //   83: aload_1
    //   84: getfield 3160	pmx:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   87: new 1132	java/net/URL
    //   90: dup
    //   91: aload 5
    //   93: getfield 3162	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   96: invokespecial 1570	java/net/URL:<init>	(Ljava/lang/String;)V
    //   99: invokespecial 3164	sel:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;Ljava/net/URL;)V
    //   102: aload 5
    //   104: getfield 3165	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   107: invokestatic 688	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   110: ifne +695 -> 805
    //   113: aload 5
    //   115: getfield 3165	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   118: invokestatic 3168	ozc:a	(Ljava/lang/String;)Landroid/graphics/drawable/Drawable;
    //   121: astore 4
    //   123: aload_1
    //   124: getfield 3171	pmx:jdField_a_of_type_AndroidViewViewGroup	Landroid/view/ViewGroup;
    //   127: aload 4
    //   129: invokevirtual 3176	android/view/ViewGroup:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   132: aload_0
    //   133: aload_1
    //   134: getfield 3177	pmx:jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   137: new 1132	java/net/URL
    //   140: dup
    //   141: aload 5
    //   143: getfield 3178	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   146: invokespecial 1570	java/net/URL:<init>	(Ljava/lang/String;)V
    //   149: invokespecial 3164	sel:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;Ljava/net/URL;)V
    //   152: aload_1
    //   153: getfield 3158	pmx:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   156: aload 5
    //   158: getfield 2958	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   161: invokevirtual 2950	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   164: new 741	java/lang/StringBuilder
    //   167: dup
    //   168: invokespecial 742	java/lang/StringBuilder:<init>	()V
    //   171: aload 5
    //   173: getfield 3179	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:jdField_a_of_type_Long	J
    //   176: iconst_1
    //   177: invokestatic 544	ozr:a	(JZ)Ljava/lang/String;
    //   180: invokevirtual 746	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: ldc_w 3180
    //   186: invokestatic 1601	anzj:a	(I)Ljava/lang/String;
    //   189: invokevirtual 746	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: invokevirtual 752	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: astore 4
    //   197: new 741	java/lang/StringBuilder
    //   200: dup
    //   201: invokespecial 742	java/lang/StringBuilder:<init>	()V
    //   204: aload 5
    //   206: getfield 3181	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:jdField_b_of_type_Int	I
    //   209: invokestatic 3183	bnrf:b	(I)Ljava/lang/String;
    //   212: invokevirtual 746	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: ldc_w 3184
    //   218: invokestatic 1601	anzj:a	(I)Ljava/lang/String;
    //   221: invokevirtual 746	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: invokevirtual 752	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   227: astore 6
    //   229: new 741	java/lang/StringBuilder
    //   232: dup
    //   233: invokespecial 742	java/lang/StringBuilder:<init>	()V
    //   236: aload 5
    //   238: getfield 3185	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:jdField_c_of_type_Int	I
    //   241: invokevirtual 1145	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   244: ldc_w 3186
    //   247: invokestatic 1601	anzj:a	(I)Ljava/lang/String;
    //   250: invokevirtual 746	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: invokevirtual 752	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   256: astore 7
    //   258: new 741	java/lang/StringBuilder
    //   261: dup
    //   262: invokespecial 742	java/lang/StringBuilder:<init>	()V
    //   265: aload 4
    //   267: invokevirtual 746	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: ldc_w 3188
    //   273: invokevirtual 746	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: aload 6
    //   278: invokevirtual 746	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: ldc_w 3188
    //   284: invokevirtual 746	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: aload 7
    //   289: invokevirtual 746	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: invokevirtual 752	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   295: astore 4
    //   297: aload_1
    //   298: getfield 3189	pmx:jdField_b_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   301: aload 4
    //   303: invokevirtual 2950	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   306: aload 5
    //   308: getfield 3190	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:jdField_a_of_type_Boolean	Z
    //   311: ifeq +559 -> 870
    //   314: aload_1
    //   315: getfield 3191	pmx:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   318: bipush 8
    //   320: invokevirtual 1589	android/widget/TextView:setVisibility	(I)V
    //   323: aload_1
    //   324: getfield 3192	pmx:i	Landroid/widget/TextView;
    //   327: aload 5
    //   329: getfield 3193	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   332: invokevirtual 2950	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   335: aload_1
    //   336: getfield 3196	pmx:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KanDianUrlRoundCornerImageView;
    //   339: aload_0
    //   340: invokevirtual 1267	sel:a	()Landroid/app/Activity;
    //   343: fconst_2
    //   344: invokestatic 1125	bhgr:a	(Landroid/content/Context;F)I
    //   347: invokevirtual 3201	com/tencent/biz/pubaccount/readinjoy/view/KanDianUrlRoundCornerImageView:setCorner	(I)V
    //   350: aload_0
    //   351: aload_1
    //   352: getfield 3196	pmx:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KanDianUrlRoundCornerImageView;
    //   355: new 1132	java/net/URL
    //   358: dup
    //   359: aload 5
    //   361: getfield 3202	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:h	Ljava/lang/String;
    //   364: invokespecial 1570	java/net/URL:<init>	(Ljava/lang/String;)V
    //   367: invokespecial 3164	sel:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;Ljava/net/URL;)V
    //   370: aload_1
    //   371: getfield 3205	pmx:jdField_a_of_type_AndroidWidgetRelativeLayout	Landroid/widget/RelativeLayout;
    //   374: aload_1
    //   375: invokevirtual 3208	android/widget/RelativeLayout:setTag	(Ljava/lang/Object;)V
    //   378: aload_1
    //   379: getfield 3191	pmx:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   382: aload_1
    //   383: invokevirtual 1870	android/widget/TextView:setTag	(Ljava/lang/Object;)V
    //   386: aload_1
    //   387: getfield 3210	pmx:jdField_b_of_type_AndroidViewViewGroup	Landroid/view/ViewGroup;
    //   390: aload_1
    //   391: invokevirtual 3211	android/view/ViewGroup:setTag	(Ljava/lang/Object;)V
    //   394: aload_1
    //   395: getfield 3196	pmx:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KanDianUrlRoundCornerImageView;
    //   398: aload_1
    //   399: invokevirtual 3212	com/tencent/biz/pubaccount/readinjoy/view/KanDianUrlRoundCornerImageView:setTag	(Ljava/lang/Object;)V
    //   402: aload_1
    //   403: getfield 3192	pmx:i	Landroid/widget/TextView;
    //   406: aload_1
    //   407: invokevirtual 1870	android/widget/TextView:setTag	(Ljava/lang/Object;)V
    //   410: aload_1
    //   411: getfield 3213	pmx:jdField_b_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   414: aload_1
    //   415: invokevirtual 1871	android/widget/ImageView:setTag	(Ljava/lang/Object;)V
    //   418: aload_1
    //   419: getfield 3213	pmx:jdField_b_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   422: aload_0
    //   423: invokevirtual 1860	android/widget/ImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   426: aload_2
    //   427: invokestatic 1874	sel:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lrwc;
    //   430: astore 4
    //   432: aload 4
    //   434: aload_1
    //   435: getfield 3214	pmx:jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   438: putfield 1880	rwc:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   441: aload 4
    //   443: aload_1
    //   444: getfield 3215	pmx:jdField_a_of_type_Int	I
    //   447: putfield 459	rwc:jdField_a_of_type_Int	I
    //   450: aload 4
    //   452: aload_2
    //   453: putfield 1105	rwc:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   456: aload_1
    //   457: aload 4
    //   459: putfield 3216	pmx:jdField_a_of_type_Rwc	Lrwc;
    //   462: aload_1
    //   463: getfield 3217	pmx:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   466: aload_2
    //   467: getfield 776	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mTitle	Ljava/lang/String;
    //   470: invokevirtual 2950	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   473: aload_1
    //   474: getfield 3217	pmx:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   477: invokevirtual 2973	android/widget/TextView:getPaint	()Landroid/text/TextPaint;
    //   480: iconst_1
    //   481: invokevirtual 2978	android/text/TextPaint:setFakeBoldText	(Z)V
    //   484: aload_1
    //   485: getfield 3217	pmx:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   488: aload_0
    //   489: getfield 322	sel:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   492: invokevirtual 1546	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   495: ldc_w 2979
    //   498: invokevirtual 2984	android/content/res/Resources:getColor	(I)I
    //   501: invokevirtual 2964	android/widget/TextView:setTextColor	(I)V
    //   504: aload_2
    //   505: getfield 823	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mVideoPlayCount	I
    //   508: ifne +373 -> 881
    //   511: aload_1
    //   512: getfield 3218	pmx:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   515: bipush 8
    //   517: invokevirtual 1589	android/widget/TextView:setVisibility	(I)V
    //   520: aload_1
    //   521: getfield 3219	pmx:jdField_f_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   524: aload 4
    //   526: getfield 547	rwc:jdField_b_of_type_Int	I
    //   529: iconst_1
    //   530: invokestatic 2991	ozc:a	(IZ)Ljava/lang/String;
    //   533: invokevirtual 2950	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   536: aload_0
    //   537: getfield 322	sel:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   540: aload_1
    //   541: getfield 3214	pmx:jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   544: aload_1
    //   545: getfield 3216	pmx:jdField_a_of_type_Rwc	Lrwc;
    //   548: invokestatic 3001	pms:a	(Landroid/content/Context;Landroid/widget/ImageView;Lrwc;)V
    //   551: aload_0
    //   552: aload_1
    //   553: getfield 3214	pmx:jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   556: aload_2
    //   557: iconst_0
    //   558: invokevirtual 1038	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:getVideoCoverUrlWithSmartCut	(Z)Ljava/net/URL;
    //   561: iconst_0
    //   562: invokespecial 1646	sel:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;Ljava/net/URL;Z)V
    //   565: aload_1
    //   566: getfield 3214	pmx:jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   569: aload_0
    //   570: invokevirtual 3005	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setOnLongClickListener	(Landroid/view/View$OnLongClickListener;)V
    //   573: aload_1
    //   574: getfield 3214	pmx:jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   577: aload_1
    //   578: invokevirtual 3220	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setTag	(Ljava/lang/Object;)V
    //   581: aload_1
    //   582: getfield 3219	pmx:jdField_f_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   585: iconst_0
    //   586: invokevirtual 1589	android/widget/TextView:setVisibility	(I)V
    //   589: aload_1
    //   590: getfield 3219	pmx:jdField_f_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   593: invokevirtual 3133	android/widget/TextView:clearAnimation	()V
    //   596: aload_1
    //   597: getfield 3221	pmx:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup	Lcom/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup;
    //   600: fconst_1
    //   601: aload 4
    //   603: getfield 726	rwc:jdField_c_of_type_Int	I
    //   606: aload 4
    //   608: getfield 729	rwc:jdField_d_of_type_Int	I
    //   611: invokestatic 3011	ozc:a	(II)F
    //   614: invokevirtual 3017	com/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup:setCustomSize	(FF)V
    //   617: aload_1
    //   618: getfield 3221	pmx:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup	Lcom/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup;
    //   621: aload_1
    //   622: invokevirtual 3018	com/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup:setTag	(Ljava/lang/Object;)V
    //   625: aload_0
    //   626: aload_0
    //   627: getfield 142	sel:jdField_c_of_type_Int	I
    //   630: aload_2
    //   631: getfield 1022	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mArticleID	J
    //   634: invokevirtual 3020	sel:b	(IJ)Z
    //   637: ifeq +23 -> 660
    //   640: aload_1
    //   641: getfield 3222	pmx:jdField_f_of_type_AndroidViewView	Landroid/view/View;
    //   644: aload_0
    //   645: getfield 322	sel:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   648: invokevirtual 1546	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   651: ldc_w 3023
    //   654: invokevirtual 2984	android/content/res/Resources:getColor	(I)I
    //   657: invokevirtual 3026	android/view/View:setBackgroundColor	(I)V
    //   660: aload_2
    //   661: getfield 576	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mXGFileSize	J
    //   664: lconst_0
    //   665: lcmp
    //   666: ifgt +262 -> 928
    //   669: aload_1
    //   670: getfield 3223	pmx:g	Landroid/widget/TextView;
    //   673: ldc_w 3224
    //   676: invokestatic 1601	anzj:a	(I)Ljava/lang/String;
    //   679: invokevirtual 2950	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   682: aload_0
    //   683: getfield 322	sel:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   686: invokestatic 1157	bhnv:h	(Landroid/content/Context;)Z
    //   689: ifeq +278 -> 967
    //   692: aload_1
    //   693: getfield 3225	pmx:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   696: iconst_0
    //   697: invokevirtual 1616	android/widget/ImageView:setVisibility	(I)V
    //   700: aload_1
    //   701: getfield 3223	pmx:g	Landroid/widget/TextView;
    //   704: bipush 8
    //   706: invokevirtual 1589	android/widget/TextView:setVisibility	(I)V
    //   709: aload_1
    //   710: getfield 3226	pmx:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   713: iconst_0
    //   714: invokevirtual 1559	android/view/View:setVisibility	(I)V
    //   717: aload_1
    //   718: getfield 3227	pmx:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   721: iconst_0
    //   722: invokevirtual 3026	android/view/View:setBackgroundColor	(I)V
    //   725: return
    //   726: aload_1
    //   727: getfield 3160	pmx:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   730: invokevirtual 1648	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   733: astore 4
    //   735: aload 4
    //   737: aload_0
    //   738: getfield 322	sel:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   741: ldc_w 3228
    //   744: invokestatic 1125	bhgr:a	(Landroid/content/Context;F)I
    //   747: putfield 1665	android/view/ViewGroup$LayoutParams:height	I
    //   750: aload_1
    //   751: getfield 3160	pmx:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   754: aload 4
    //   756: invokevirtual 1678	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   759: goto -688 -> 71
    //   762: aload_1
    //   763: getfield 3160	pmx:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   766: new 499	android/graphics/drawable/ColorDrawable
    //   769: dup
    //   770: ldc_w 3229
    //   773: invokespecial 502	android/graphics/drawable/ColorDrawable:<init>	(I)V
    //   776: invokevirtual 3230	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   779: goto -677 -> 102
    //   782: astore 4
    //   784: invokestatic 416	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   787: ifeq -685 -> 102
    //   790: ldc_w 418
    //   793: iconst_2
    //   794: ldc_w 3232
    //   797: aload 4
    //   799: invokestatic 3235	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   802: goto -700 -> 102
    //   805: new 499	android/graphics/drawable/ColorDrawable
    //   808: dup
    //   809: ldc_w 3229
    //   812: invokespecial 502	android/graphics/drawable/ColorDrawable:<init>	(I)V
    //   815: astore 4
    //   817: goto -694 -> 123
    //   820: astore 4
    //   822: invokestatic 416	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   825: ifeq +15 -> 840
    //   828: ldc_w 418
    //   831: iconst_2
    //   832: ldc_w 3237
    //   835: aload 4
    //   837: invokestatic 3235	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   840: aload_1
    //   841: getfield 3171	pmx:jdField_a_of_type_AndroidViewViewGroup	Landroid/view/ViewGroup;
    //   844: new 499	android/graphics/drawable/ColorDrawable
    //   847: dup
    //   848: ldc_w 3229
    //   851: invokespecial 502	android/graphics/drawable/ColorDrawable:<init>	(I)V
    //   854: invokevirtual 3176	android/view/ViewGroup:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   857: goto -725 -> 132
    //   860: astore 4
    //   862: aload 4
    //   864: invokevirtual 3238	java/net/MalformedURLException:printStackTrace	()V
    //   867: goto -715 -> 152
    //   870: aload_1
    //   871: getfield 3191	pmx:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   874: iconst_0
    //   875: invokevirtual 1589	android/widget/TextView:setVisibility	(I)V
    //   878: goto -555 -> 323
    //   881: aload_1
    //   882: getfield 3218	pmx:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   885: iconst_0
    //   886: invokevirtual 1589	android/widget/TextView:setVisibility	(I)V
    //   889: aload_1
    //   890: getfield 3218	pmx:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   893: new 741	java/lang/StringBuilder
    //   896: dup
    //   897: invokespecial 742	java/lang/StringBuilder:<init>	()V
    //   900: aload_2
    //   901: getfield 823	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mVideoPlayCount	I
    //   904: invokestatic 3240	rpt:c	(I)Ljava/lang/String;
    //   907: invokevirtual 746	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   910: ldc_w 3241
    //   913: invokestatic 1601	anzj:a	(I)Ljava/lang/String;
    //   916: invokevirtual 746	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   919: invokevirtual 752	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   922: invokevirtual 2950	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   925: goto -405 -> 520
    //   928: aload_1
    //   929: getfield 3223	pmx:g	Landroid/widget/TextView;
    //   932: new 741	java/lang/StringBuilder
    //   935: dup
    //   936: invokespecial 742	java/lang/StringBuilder:<init>	()V
    //   939: aload_2
    //   940: getfield 576	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mXGFileSize	J
    //   943: invokestatic 3037	rpt:b	(J)Ljava/lang/String;
    //   946: invokevirtual 746	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   949: ldc_w 3242
    //   952: invokestatic 1601	anzj:a	(I)Ljava/lang/String;
    //   955: invokevirtual 746	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   958: invokevirtual 752	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   961: invokevirtual 2950	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   964: goto -282 -> 682
    //   967: aload_1
    //   968: getfield 3225	pmx:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   971: bipush 8
    //   973: invokevirtual 1616	android/widget/ImageView:setVisibility	(I)V
    //   976: aload_0
    //   977: getfield 322	sel:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   980: invokevirtual 1546	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   983: ldc_w 3039
    //   986: invokevirtual 3042	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   989: astore 4
    //   991: aload_1
    //   992: getfield 3223	pmx:g	Landroid/widget/TextView;
    //   995: aload 4
    //   997: aconst_null
    //   998: aconst_null
    //   999: aconst_null
    //   1000: invokevirtual 3046	android/widget/TextView:setCompoundDrawablesWithIntrinsicBounds	(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V
    //   1003: aload_1
    //   1004: getfield 3223	pmx:g	Landroid/widget/TextView;
    //   1007: ldc_w 2317
    //   1010: aload_0
    //   1011: getfield 322	sel:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   1014: invokevirtual 1546	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   1017: invokestatic 486	agej:a	(FLandroid/content/res/Resources;)I
    //   1020: invokevirtual 3049	android/widget/TextView:setCompoundDrawablePadding	(I)V
    //   1023: aload_1
    //   1024: getfield 3223	pmx:g	Landroid/widget/TextView;
    //   1027: iconst_0
    //   1028: invokevirtual 1589	android/widget/TextView:setVisibility	(I)V
    //   1031: invokestatic 3052	bihq:a	()I
    //   1034: iconst_1
    //   1035: if_icmpne +42 -> 1077
    //   1038: aload_1
    //   1039: getfield 3223	pmx:g	Landroid/widget/TextView;
    //   1042: ldc_w 3243
    //   1045: invokestatic 1601	anzj:a	(I)Ljava/lang/String;
    //   1048: invokevirtual 2950	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   1051: aload_1
    //   1052: getfield 3244	pmx:h	Landroid/widget/TextView;
    //   1055: bipush 8
    //   1057: invokevirtual 1589	android/widget/TextView:setVisibility	(I)V
    //   1060: aload_1
    //   1061: getfield 3226	pmx:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   1064: iconst_0
    //   1065: invokevirtual 1559	android/view/View:setVisibility	(I)V
    //   1068: aload_1
    //   1069: getfield 3227	pmx:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   1072: iconst_0
    //   1073: invokevirtual 3026	android/view/View:setBackgroundColor	(I)V
    //   1076: return
    //   1077: invokestatic 3057	bnrf:v	()Z
    //   1080: ifeq +296 -> 1376
    //   1083: aload_0
    //   1084: getfield 3058	sel:jdField_h_of_type_Boolean	Z
    //   1087: ifne +289 -> 1376
    //   1090: aload_1
    //   1091: getfield 3215	pmx:jdField_a_of_type_Int	I
    //   1094: ifne +282 -> 1376
    //   1097: invokestatic 3060	bnrf:e	()Ljava/lang/String;
    //   1100: astore 5
    //   1102: invokestatic 3062	bnrf:f	()Ljava/lang/String;
    //   1105: astore 6
    //   1107: invokestatic 3064	bnrf:g	()Ljava/lang/String;
    //   1110: astore 7
    //   1112: aload 5
    //   1114: invokestatic 688	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1117: ifne +217 -> 1334
    //   1120: invokestatic 3066	ozs:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1123: astore 8
    //   1125: ldc_w 828
    //   1128: astore 4
    //   1130: aload 8
    //   1132: ifnull +10 -> 1142
    //   1135: aload 8
    //   1137: invokevirtual 3069	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1140: astore 4
    //   1142: new 1333	sbg
    //   1145: dup
    //   1146: aconst_null
    //   1147: aconst_null
    //   1148: aconst_null
    //   1149: aconst_null
    //   1150: invokespecial 1336	sbg:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1153: aload 4
    //   1155: invokevirtual 3072	sbg:m	(Ljava/lang/String;)Lsbg;
    //   1158: aload_2
    //   1159: getfield 677	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:innerUniqueID	Ljava/lang/String;
    //   1162: invokevirtual 3074	sbg:i	(Ljava/lang/String;)Lsbg;
    //   1165: invokevirtual 1359	sbg:a	()Lsbf;
    //   1168: invokevirtual 1363	sbf:a	()Ljava/lang/String;
    //   1171: astore_2
    //   1172: aload_1
    //   1173: getfield 3244	pmx:h	Landroid/widget/TextView;
    //   1176: iconst_0
    //   1177: invokevirtual 1589	android/widget/TextView:setVisibility	(I)V
    //   1180: aload_1
    //   1181: getfield 3244	pmx:h	Landroid/widget/TextView;
    //   1184: fconst_2
    //   1185: aload_0
    //   1186: getfield 322	sel:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   1189: invokevirtual 1546	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   1192: invokestatic 486	agej:a	(FLandroid/content/res/Resources;)I
    //   1195: invokevirtual 3049	android/widget/TextView:setCompoundDrawablePadding	(I)V
    //   1198: aload_0
    //   1199: getfield 322	sel:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   1202: invokevirtual 1546	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   1205: ldc_w 3075
    //   1208: invokevirtual 3042	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   1211: astore 4
    //   1213: aload 4
    //   1215: iconst_0
    //   1216: iconst_0
    //   1217: ldc_w 3076
    //   1220: aload_0
    //   1221: getfield 322	sel:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   1224: invokevirtual 1546	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   1227: invokestatic 486	agej:a	(FLandroid/content/res/Resources;)I
    //   1230: ldc_w 3076
    //   1233: aload_0
    //   1234: getfield 322	sel:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   1237: invokevirtual 1546	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   1240: invokestatic 486	agej:a	(FLandroid/content/res/Resources;)I
    //   1243: invokevirtual 3081	android/graphics/drawable/Drawable:setBounds	(IIII)V
    //   1246: aload_1
    //   1247: getfield 3244	pmx:h	Landroid/widget/TextView;
    //   1250: aconst_null
    //   1251: aconst_null
    //   1252: aload 4
    //   1254: aconst_null
    //   1255: invokevirtual 3084	android/widget/TextView:setCompoundDrawables	(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V
    //   1258: aload_0
    //   1259: getfield 322	sel:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   1262: aload_1
    //   1263: getfield 3244	pmx:h	Landroid/widget/TextView;
    //   1266: aload 6
    //   1268: aload 7
    //   1270: aload 5
    //   1272: new 3246	sen
    //   1275: dup
    //   1276: aload_0
    //   1277: aload_2
    //   1278: invokespecial 3248	sen:<init>	(Lsel;Ljava/lang/String;)V
    //   1281: invokestatic 3092	rpt:b	(Landroid/content/Context;Landroid/widget/TextView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/view/View$OnClickListener;)V
    //   1284: aload_1
    //   1285: getfield 3227	pmx:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   1288: ldc_w 3093
    //   1291: invokevirtual 3026	android/view/View:setBackgroundColor	(I)V
    //   1294: aload_1
    //   1295: getfield 3226	pmx:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   1298: iconst_0
    //   1299: invokevirtual 1559	android/view/View:setVisibility	(I)V
    //   1302: aload_0
    //   1303: iconst_1
    //   1304: putfield 3058	sel:jdField_h_of_type_Boolean	Z
    //   1307: aconst_null
    //   1308: ldc_w 828
    //   1311: ldc_w 3095
    //   1314: ldc_w 3095
    //   1317: iconst_0
    //   1318: iconst_0
    //   1319: ldc_w 828
    //   1322: ldc_w 828
    //   1325: ldc_w 828
    //   1328: aload_2
    //   1329: iconst_0
    //   1330: invokestatic 1372	ocd:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   1333: return
    //   1334: aload_1
    //   1335: getfield 3244	pmx:h	Landroid/widget/TextView;
    //   1338: bipush 8
    //   1340: invokevirtual 1589	android/widget/TextView:setVisibility	(I)V
    //   1343: aload_1
    //   1344: getfield 3226	pmx:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   1347: iconst_0
    //   1348: invokevirtual 1559	android/view/View:setVisibility	(I)V
    //   1351: aload_1
    //   1352: getfield 3227	pmx:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   1355: iconst_0
    //   1356: invokevirtual 3026	android/view/View:setBackgroundColor	(I)V
    //   1359: invokestatic 416	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1362: ifeq -1358 -> 4
    //   1365: ldc_w 988
    //   1368: iconst_2
    //   1369: ldc_w 3097
    //   1372: invokestatic 993	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1375: return
    //   1376: aload_1
    //   1377: getfield 3244	pmx:h	Landroid/widget/TextView;
    //   1380: bipush 8
    //   1382: invokevirtual 1589	android/widget/TextView:setVisibility	(I)V
    //   1385: aload_1
    //   1386: getfield 3226	pmx:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   1389: iconst_0
    //   1390: invokevirtual 1559	android/view/View:setVisibility	(I)V
    //   1393: aload_1
    //   1394: getfield 3227	pmx:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   1397: iconst_0
    //   1398: invokevirtual 3026	android/view/View:setBackgroundColor	(I)V
    //   1401: return
    //   1402: astore 4
    //   1404: goto -1034 -> 370
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1407	0	this	sel
    //   0	1407	1	parampmx	pmx
    //   0	1407	2	paramBaseArticleInfo	BaseArticleInfo
    //   0	1407	3	paramInt	int
    //   45	710	4	localObject1	Object
    //   782	16	4	localException1	Exception
    //   815	1	4	localColorDrawable	ColorDrawable
    //   820	16	4	localException2	Exception
    //   860	3	4	localMalformedURLException	MalformedURLException
    //   989	264	4	localObject2	Object
    //   1402	1	4	localException3	Exception
    //   27	1244	5	localObject3	Object
    //   227	1040	6	str1	String
    //   256	1013	7	str2	String
    //   1123	13	8	localQQAppInterface	QQAppInterface
    // Exception table:
    //   from	to	target	type
    //   71	102	782	java/lang/Exception
    //   762	779	782	java/lang/Exception
    //   102	123	820	java/lang/Exception
    //   123	132	820	java/lang/Exception
    //   805	817	820	java/lang/Exception
    //   132	152	860	java/net/MalformedURLException
    //   335	370	1402	java/lang/Exception
  }
  
  public void a(pmy parampmy, BaseArticleInfo paramBaseArticleInfo)
  {
    parampmy.jdField_f_of_type_AndroidViewView.setOnClickListener(null);
    parampmy.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = paramBaseArticleInfo;
    parampmy.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = ((BaseArticleInfo)paramBaseArticleInfo.mSubArtilceList.get(0));
    parampmy.jdField_a_of_type_AndroidViewView.setBackgroundColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131167302));
    a(parampmy.jdField_a_of_type_AndroidViewViewGroup, parampmy.jdField_b_of_type_AndroidViewViewGroup);
    BaseArticleInfo localBaseArticleInfo = parampmy.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
    a(localBaseArticleInfo, parampmy.jdField_c_of_type_AndroidWidgetTextView, parampmy.jdField_b_of_type_AndroidViewView, parampmy.jdField_a_of_type_AndroidWidgetTextView, parampmy.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, parampmy.jdField_f_of_type_AndroidViewView);
    a(parampmy.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetRoundAngleFrameLayout);
    parampmy.jdField_c_of_type_AndroidWidgetTextView.setText(localBaseArticleInfo.mTitle);
    parampmy.jdField_c_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
    parampmy.jdField_d_of_type_AndroidWidgetTextView.setText(rpt.c(localBaseArticleInfo.mVideoPlayCount));
    a(parampmy.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, parampmy.jdField_a_of_type_AndroidWidgetImageView, localBaseArticleInfo, false);
    parampmy.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setTag(parampmy);
    parampmy.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setOnClickListener(this);
    VideoReport.setElementId(parampmy.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, "card");
    KandianUrlImageView localKandianUrlImageView = parampmy.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
    pda localpda = new pda().a(this.jdField_c_of_type_Int);
    if (TextUtils.isEmpty(localBaseArticleInfo.innerUniqueID)) {
      paramBaseArticleInfo = "null";
    }
    for (;;)
    {
      VideoReport.setElementParams(localKandianUrlImageView, localpda.a(paramBaseArticleInfo).a());
      VideoReport.setElementReuseIdentifier(parampmy.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, localBaseArticleInfo.innerUniqueID);
      parampmy.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setTag(localBaseArticleInfo);
      rpt.a(localBaseArticleInfo.mVideoArticleSubsText, localBaseArticleInfo.mVideoArticleSubsColor, parampmy.jdField_e_of_type_AndroidWidgetTextView);
      long l1;
      if ((localBaseArticleInfo.isAccountShown) && (this.jdField_c_of_type_Int == 0) && (localBaseArticleInfo.mPartnerAccountInfo != null))
      {
        parampmy.jdField_d_of_type_AndroidViewView.setVisibility(0);
        parampmy.jdField_d_of_type_AndroidViewView.setTag(localBaseArticleInfo);
        parampmy.jdField_d_of_type_AndroidViewView.setTag(2131376226, parampmy);
        l1 = 0L;
        if (localBaseArticleInfo.mPartnerAccountInfo.uint64_uin.has()) {
          l1 = localBaseArticleInfo.mPartnerAccountInfo.uint64_uin.get();
        }
        parampmy.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setHeadImgByUin(l1);
        parampmy.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setTag(localBaseArticleInfo);
        parampmy.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setTag(2131376226, parampmy);
        ozs.a(parampmy.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView, 10, 10, 10, 10);
        paramBaseArticleInfo = ozs.a(localBaseArticleInfo.mPartnerAccountInfo.bytes_v_icon_url);
        if (TextUtils.isEmpty(paramBaseArticleInfo)) {}
      }
      try
      {
        paramBaseArticleInfo = new URL(paramBaseArticleInfo);
        parampmy.jdField_d_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setImage(paramBaseArticleInfo);
        label430:
        parampmy.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setNickNameByUin(l1);
        parampmy.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
        parampmy.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setOnClickListener(this);
        label454:
        localBaseArticleInfo = parampmy.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
        localBaseArticleInfo.isTwoItem = true;
        a(localBaseArticleInfo, parampmy.jdField_f_of_type_AndroidWidgetTextView, parampmy.jdField_c_of_type_AndroidViewView, parampmy.jdField_b_of_type_AndroidWidgetTextView, parampmy.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, parampmy.jdField_f_of_type_AndroidViewView);
        a(parampmy.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetRoundAngleFrameLayout);
        parampmy.jdField_f_of_type_AndroidWidgetTextView.setText(localBaseArticleInfo.mTitle);
        parampmy.jdField_f_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
        parampmy.g.setText(rpt.c(localBaseArticleInfo.mVideoPlayCount));
        a(parampmy.jdField_e_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, parampmy.jdField_b_of_type_AndroidWidgetImageView, localBaseArticleInfo, false);
        parampmy.jdField_e_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setTag(parampmy);
        parampmy.jdField_e_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setOnClickListener(this);
        VideoReport.setElementId(parampmy.jdField_e_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, "card");
        localKandianUrlImageView = parampmy.jdField_e_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
        localpda = new pda().a(this.jdField_c_of_type_Int);
        if (TextUtils.isEmpty(localBaseArticleInfo.innerUniqueID))
        {
          paramBaseArticleInfo = "null";
          label617:
          VideoReport.setElementParams(localKandianUrlImageView, localpda.a(paramBaseArticleInfo).a());
          VideoReport.setElementReuseIdentifier(parampmy.jdField_e_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, localBaseArticleInfo.innerUniqueID);
          parampmy.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setTag(localBaseArticleInfo);
          rpt.a(localBaseArticleInfo.mVideoArticleSubsText, localBaseArticleInfo.mVideoArticleSubsColor, parampmy.h);
          if ((!localBaseArticleInfo.isAccountShown) || (this.jdField_c_of_type_Int != 0) || (localBaseArticleInfo.mPartnerAccountInfo == null)) {
            break label898;
          }
          parampmy.jdField_e_of_type_AndroidViewView.setVisibility(0);
          parampmy.jdField_e_of_type_AndroidViewView.setTag(localBaseArticleInfo);
          parampmy.jdField_e_of_type_AndroidViewView.setTag(2131376226, parampmy);
          long l2 = 0L;
          l1 = l2;
          if (localBaseArticleInfo.mPartnerAccountInfo != null)
          {
            l1 = l2;
            if (localBaseArticleInfo.mPartnerAccountInfo.uint64_uin.has()) {
              l1 = localBaseArticleInfo.mPartnerAccountInfo.uint64_uin.get();
            }
          }
          parampmy.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setHeadImgByUin(l1);
          parampmy.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setTag(localBaseArticleInfo);
          parampmy.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setTag(2131376226, parampmy);
          ozs.a(parampmy.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView, 10, 10, 10, 10);
          paramBaseArticleInfo = ozs.a(localBaseArticleInfo.mPartnerAccountInfo.bytes_v_icon_url);
          if (TextUtils.isEmpty(paramBaseArticleInfo)) {}
        }
        try
        {
          paramBaseArticleInfo = new URL(paramBaseArticleInfo);
          parampmy.jdField_f_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setImage(paramBaseArticleInfo);
          label843:
          parampmy.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setNickNameByUin(l1);
          parampmy.jdField_e_of_type_AndroidViewView.setOnClickListener(this);
          parampmy.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setOnClickListener(this);
          return;
          paramBaseArticleInfo = localBaseArticleInfo.innerUniqueID;
          continue;
          parampmy.jdField_d_of_type_AndroidViewView.setVisibility(8);
          break label454;
          paramBaseArticleInfo = localBaseArticleInfo.innerUniqueID;
          break label617;
          label898:
          parampmy.jdField_e_of_type_AndroidViewView.setVisibility(8);
          return;
        }
        catch (Exception paramBaseArticleInfo)
        {
          break label843;
        }
      }
      catch (Exception paramBaseArticleInfo)
      {
        break label430;
      }
    }
  }
  
  /* Error */
  public void a(pmz parampmz, BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aload_1
    //   6: aload_2
    //   7: invokestatic 3353	sel:a	(Lpmz;Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)V
    //   10: aload_1
    //   11: getfield 1882	pmz:jdField_a_of_type_Rwc	Lrwc;
    //   14: astore 4
    //   16: aload_1
    //   17: getfield 3354	pmz:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   20: aload_2
    //   21: getfield 776	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mTitle	Ljava/lang/String;
    //   24: invokevirtual 2950	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   27: aload_1
    //   28: getfield 3354	pmz:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   31: invokevirtual 2973	android/widget/TextView:getPaint	()Landroid/text/TextPaint;
    //   34: iconst_1
    //   35: invokevirtual 2978	android/text/TextPaint:setFakeBoldText	(Z)V
    //   38: aload_1
    //   39: getfield 3354	pmz:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   42: aload_0
    //   43: getfield 322	sel:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   46: invokevirtual 1546	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   49: ldc_w 2979
    //   52: invokevirtual 2984	android/content/res/Resources:getColor	(I)I
    //   55: invokevirtual 2964	android/widget/TextView:setTextColor	(I)V
    //   58: aload_2
    //   59: getfield 823	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mVideoPlayCount	I
    //   62: ifne +814 -> 876
    //   65: aload_1
    //   66: getfield 3355	pmz:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   69: bipush 8
    //   71: invokevirtual 1589	android/widget/TextView:setVisibility	(I)V
    //   74: aload_1
    //   75: getfield 3356	pmz:jdField_b_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   78: aload 4
    //   80: getfield 547	rwc:jdField_b_of_type_Int	I
    //   83: iconst_1
    //   84: invokestatic 2991	ozc:a	(IZ)Ljava/lang/String;
    //   87: invokevirtual 2950	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   90: aload_0
    //   91: aload_1
    //   92: getfield 3357	pmz:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyNickNameTextView;
    //   95: aload_2
    //   96: aload_2
    //   97: invokestatic 1202	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:isAdvertisementInfo	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Z
    //   100: invokespecial 3359	sel:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyNickNameTextView;Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;Z)V
    //   103: aload_0
    //   104: aload_1
    //   105: getfield 3360	pmz:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyHeadImageView;
    //   108: aload_2
    //   109: invokespecial 3362	sel:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyHeadImageView;Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)V
    //   112: aload_1
    //   113: getfield 3360	pmz:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyHeadImageView;
    //   116: aload_2
    //   117: invokevirtual 1766	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:getSubscribeName	()Ljava/lang/String;
    //   120: invokevirtual 3365	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyHeadImageView:setContentDescription	(Ljava/lang/CharSequence;)V
    //   123: aload_1
    //   124: getfield 3357	pmz:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyNickNameTextView;
    //   127: iconst_0
    //   128: invokevirtual 3366	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyNickNameTextView:setVisibility	(I)V
    //   131: aload_1
    //   132: getfield 3357	pmz:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyNickNameTextView;
    //   135: aload_2
    //   136: invokevirtual 1766	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:getSubscribeName	()Ljava/lang/String;
    //   139: invokevirtual 3367	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyNickNameTextView:setContentDescription	(Ljava/lang/CharSequence;)V
    //   142: aload_1
    //   143: getfield 3368	pmz:jdField_a_of_type_AndroidViewViewGroup	Landroid/view/ViewGroup;
    //   146: aload_2
    //   147: invokevirtual 3211	android/view/ViewGroup:setTag	(Ljava/lang/Object;)V
    //   150: aload_1
    //   151: getfield 3368	pmz:jdField_a_of_type_AndroidViewViewGroup	Landroid/view/ViewGroup;
    //   154: ldc_w 3289
    //   157: aload_1
    //   158: invokevirtual 3369	android/view/ViewGroup:setTag	(ILjava/lang/Object;)V
    //   161: aload_1
    //   162: getfield 3368	pmz:jdField_a_of_type_AndroidViewViewGroup	Landroid/view/ViewGroup;
    //   165: aload_0
    //   166: invokevirtual 3370	android/view/ViewGroup:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   169: aload_2
    //   170: getfield 3115	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:vIconUrl	Ljava/lang/String;
    //   173: invokestatic 688	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   176: ifne +757 -> 933
    //   179: new 1132	java/net/URL
    //   182: dup
    //   183: aload_2
    //   184: getfield 3115	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:vIconUrl	Ljava/lang/String;
    //   187: invokespecial 1570	java/net/URL:<init>	(Ljava/lang/String;)V
    //   190: astore 5
    //   192: aload_1
    //   193: getfield 3371	pmz:jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   196: aload 5
    //   198: invokevirtual 2957	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setImage	(Ljava/net/URL;)Lcom/tencent/biz/pubaccount/readinjoy/view/imageloader/ZImageView;
    //   201: pop
    //   202: aload_1
    //   203: getfield 3371	pmz:jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   206: iconst_0
    //   207: invokevirtual 1588	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setVisibility	(I)V
    //   210: aload_2
    //   211: invokestatic 1202	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:isAdvertisementInfo	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Z
    //   214: ifeq +885 -> 1099
    //   217: aload_2
    //   218: checkcast 1199	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo
    //   221: astore 5
    //   223: aload_1
    //   224: getfield 1866	pmz:h	Landroid/widget/TextView;
    //   227: iconst_0
    //   228: invokevirtual 1589	android/widget/TextView:setVisibility	(I)V
    //   231: invokestatic 1115	ozs:u	()Z
    //   234: ifeq +711 -> 945
    //   237: aload_1
    //   238: getfield 1866	pmz:h	Landroid/widget/TextView;
    //   241: aconst_null
    //   242: invokestatic 3376	oxr:a	(Landroid/view/View;Landroid/graphics/drawable/Drawable;)V
    //   245: aload_1
    //   246: getfield 1866	pmz:h	Landroid/widget/TextView;
    //   249: ldc_w 3378
    //   252: invokestatic 131	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   255: invokevirtual 2964	android/widget/TextView:setTextColor	(I)V
    //   258: aload_1
    //   259: getfield 1863	pmz:i	Landroid/widget/TextView;
    //   262: ldc_w 3380
    //   265: invokestatic 131	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   268: invokevirtual 2964	android/widget/TextView:setTextColor	(I)V
    //   271: aload_2
    //   272: getfield 3101	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mArticleSubscriptText	Ljava/lang/String;
    //   275: invokestatic 688	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   278: ifne +690 -> 968
    //   281: aload_1
    //   282: getfield 1866	pmz:h	Landroid/widget/TextView;
    //   285: aload_2
    //   286: getfield 3101	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mArticleSubscriptText	Ljava/lang/String;
    //   289: invokevirtual 2950	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   292: aload_1
    //   293: getfield 3383	pmz:jdField_b_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   296: iconst_0
    //   297: invokevirtual 3386	android/widget/LinearLayout:setVisibility	(I)V
    //   300: aload_2
    //   301: invokestatic 1717	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:isAppAdvertisementInfo	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Z
    //   304: ifeq +726 -> 1030
    //   307: iconst_0
    //   308: istore_3
    //   309: new 907	org/json/JSONObject
    //   312: dup
    //   313: aload 5
    //   315: getfield 1720	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdExt	Ljava/lang/String;
    //   318: invokespecial 910	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   321: astore 6
    //   323: aload_0
    //   324: getfield 322	sel:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   327: aload 6
    //   329: ldc_w 3388
    //   332: invokevirtual 3391	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   335: invokestatic 3396	bhny:a	(Landroid/content/Context;Ljava/lang/String;)Z
    //   338: ifeq +650 -> 988
    //   341: aload_1
    //   342: getfield 1863	pmz:i	Landroid/widget/TextView;
    //   345: aload_0
    //   346: getfield 322	sel:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   349: ldc_w 3397
    //   352: invokevirtual 2685	android/app/Activity:getString	(I)Ljava/lang/String;
    //   355: invokevirtual 2950	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   358: iconst_1
    //   359: istore_3
    //   360: aload 5
    //   362: getfield 3400	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdBtnTxt	Ljava/lang/String;
    //   365: invokestatic 688	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   368: ifne +19 -> 387
    //   371: iload_3
    //   372: ifne +15 -> 387
    //   375: aload_1
    //   376: getfield 1863	pmz:i	Landroid/widget/TextView;
    //   379: aload 5
    //   381: getfield 3400	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdBtnTxt	Ljava/lang/String;
    //   384: invokevirtual 2950	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   387: new 907	org/json/JSONObject
    //   390: dup
    //   391: aload 5
    //   393: getfield 3403	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdExtInfo	Ljava/lang/String;
    //   396: invokespecial 910	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   399: astore 5
    //   401: aload 5
    //   403: ldc_w 3405
    //   406: invokevirtual 3391	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   409: invokestatic 688	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   412: ifne +18 -> 430
    //   415: aload_1
    //   416: getfield 1866	pmz:h	Landroid/widget/TextView;
    //   419: aload 5
    //   421: ldc_w 3405
    //   424: invokevirtual 3391	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   427: invokevirtual 2950	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   430: aload_0
    //   431: aload_1
    //   432: invokespecial 3407	sel:a	(Lpmz;)V
    //   435: aload_1
    //   436: getfield 3410	pmz:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyVideoInfoViewGroup	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyVideoInfoViewGroup;
    //   439: bipush 8
    //   441: invokevirtual 3413	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyVideoInfoViewGroup:setVisibility	(I)V
    //   444: aload_1
    //   445: getfield 3415	pmz:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   448: bipush 8
    //   450: invokevirtual 3386	android/widget/LinearLayout:setVisibility	(I)V
    //   453: aload_0
    //   454: getfield 322	sel:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   457: aload_1
    //   458: getfield 1877	pmz:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   461: aload_1
    //   462: getfield 1882	pmz:jdField_a_of_type_Rwc	Lrwc;
    //   465: invokestatic 3001	pms:a	(Landroid/content/Context;Landroid/widget/ImageView;Lrwc;)V
    //   468: aload_0
    //   469: aload_1
    //   470: getfield 1877	pmz:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   473: aload_2
    //   474: iconst_0
    //   475: invokevirtual 1038	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:getVideoCoverUrlWithSmartCut	(Z)Ljava/net/URL;
    //   478: iconst_0
    //   479: invokespecial 1646	sel:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;Ljava/net/URL;Z)V
    //   482: aload_1
    //   483: getfield 1877	pmz:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   486: aload_0
    //   487: invokevirtual 1587	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   490: aload_1
    //   491: getfield 1877	pmz:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   494: aload_0
    //   495: invokevirtual 3005	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setOnLongClickListener	(Landroid/view/View$OnLongClickListener;)V
    //   498: aload_1
    //   499: getfield 1877	pmz:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   502: aload_1
    //   503: invokevirtual 3220	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setTag	(Ljava/lang/Object;)V
    //   506: aload_1
    //   507: getfield 3356	pmz:jdField_b_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   510: iconst_0
    //   511: invokevirtual 1589	android/widget/TextView:setVisibility	(I)V
    //   514: aload_1
    //   515: getfield 3356	pmz:jdField_b_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   518: invokevirtual 3133	android/widget/TextView:clearAnimation	()V
    //   521: aload_1
    //   522: getfield 3416	pmz:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup	Lcom/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup;
    //   525: fconst_1
    //   526: aload 4
    //   528: getfield 726	rwc:jdField_c_of_type_Int	I
    //   531: aload 4
    //   533: getfield 729	rwc:jdField_d_of_type_Int	I
    //   536: invokestatic 3011	ozc:a	(II)F
    //   539: invokevirtual 3017	com/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup:setCustomSize	(FF)V
    //   542: aload_1
    //   543: getfield 3416	pmz:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup	Lcom/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup;
    //   546: aload_0
    //   547: invokevirtual 3417	com/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   550: aload_1
    //   551: getfield 3416	pmz:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup	Lcom/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup;
    //   554: aload_1
    //   555: invokevirtual 3018	com/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup:setTag	(Ljava/lang/Object;)V
    //   558: aload_0
    //   559: aload_0
    //   560: getfield 142	sel:jdField_c_of_type_Int	I
    //   563: aload_2
    //   564: getfield 1022	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mArticleID	J
    //   567: invokevirtual 3020	sel:b	(IJ)Z
    //   570: ifeq +23 -> 593
    //   573: aload_1
    //   574: getfield 3418	pmz:jdField_f_of_type_AndroidViewView	Landroid/view/View;
    //   577: aload_0
    //   578: getfield 322	sel:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   581: invokevirtual 1546	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   584: ldc_w 3023
    //   587: invokevirtual 2984	android/content/res/Resources:getColor	(I)I
    //   590: invokevirtual 3026	android/view/View:setBackgroundColor	(I)V
    //   593: aload_0
    //   594: invokevirtual 1267	sel:a	()Landroid/app/Activity;
    //   597: aload_1
    //   598: getfield 3419	pmz:jdField_b_of_type_AndroidViewViewGroup	Landroid/view/ViewGroup;
    //   601: aload_1
    //   602: getfield 3420	pmz:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetRoundAngleFrameLayout	Lcom/tencent/biz/pubaccount/readinjoy/view/widget/RoundAngleFrameLayout;
    //   605: invokestatic 3425	pab:a	(Landroid/content/Context;Landroid/view/View;Lcom/tencent/biz/pubaccount/readinjoy/view/widget/RoundAngleFrameLayout;)V
    //   608: invokestatic 1115	ozs:u	()Z
    //   611: ifeq +582 -> 1193
    //   614: aload_1
    //   615: getfield 3426	pmz:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   618: aload_0
    //   619: invokevirtual 1267	sel:a	()Landroid/app/Activity;
    //   622: ldc_w 1545
    //   625: invokestatic 1125	bhgr:a	(Landroid/content/Context;F)I
    //   628: invokevirtual 3049	android/widget/TextView:setCompoundDrawablePadding	(I)V
    //   631: aload_0
    //   632: invokevirtual 1267	sel:a	()Landroid/app/Activity;
    //   635: invokevirtual 1546	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   638: ldc_w 3427
    //   641: invokevirtual 3042	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   644: astore 4
    //   646: aload_0
    //   647: invokevirtual 1267	sel:a	()Landroid/app/Activity;
    //   650: ldc_w 3428
    //   653: invokestatic 1125	bhgr:a	(Landroid/content/Context;F)I
    //   656: istore_3
    //   657: aload 4
    //   659: iconst_0
    //   660: iconst_0
    //   661: iload_3
    //   662: iload_3
    //   663: invokevirtual 3081	android/graphics/drawable/Drawable:setBounds	(IIII)V
    //   666: aload_1
    //   667: getfield 3426	pmz:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   670: aload 4
    //   672: aconst_null
    //   673: aconst_null
    //   674: aconst_null
    //   675: invokevirtual 3084	android/widget/TextView:setCompoundDrawables	(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V
    //   678: aload_1
    //   679: getfield 3420	pmz:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetRoundAngleFrameLayout	Lcom/tencent/biz/pubaccount/readinjoy/view/widget/RoundAngleFrameLayout;
    //   682: aload_0
    //   683: invokevirtual 3429	com/tencent/biz/pubaccount/readinjoy/view/widget/RoundAngleFrameLayout:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   686: aload_1
    //   687: getfield 3420	pmz:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetRoundAngleFrameLayout	Lcom/tencent/biz/pubaccount/readinjoy/view/widget/RoundAngleFrameLayout;
    //   690: aload_1
    //   691: invokevirtual 3430	com/tencent/biz/pubaccount/readinjoy/view/widget/RoundAngleFrameLayout:setTag	(Ljava/lang/Object;)V
    //   694: aload_1
    //   695: getfield 3426	pmz:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   698: aload_2
    //   699: invokevirtual 1596	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:getCommentCount	()I
    //   702: ldc_w 3431
    //   705: invokestatic 1601	anzj:a	(I)Ljava/lang/String;
    //   708: invokestatic 3434	rpt:a	(Landroid/widget/TextView;ILjava/lang/String;)V
    //   711: aload_1
    //   712: getfield 3426	pmz:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   715: aload_0
    //   716: invokevirtual 1864	android/widget/TextView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   719: aload_1
    //   720: getfield 3426	pmz:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   723: aload_1
    //   724: invokevirtual 1870	android/widget/TextView:setTag	(Ljava/lang/Object;)V
    //   727: aload_1
    //   728: getfield 3435	pmz:jdField_a_of_type_AndroidWidgetRelativeLayout	Landroid/widget/RelativeLayout;
    //   731: aload_0
    //   732: invokevirtual 3436	android/widget/RelativeLayout:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   735: aload_1
    //   736: getfield 3435	pmz:jdField_a_of_type_AndroidWidgetRelativeLayout	Landroid/widget/RelativeLayout;
    //   739: aload_1
    //   740: invokevirtual 3208	android/widget/RelativeLayout:setTag	(Ljava/lang/Object;)V
    //   743: aload_2
    //   744: getfield 576	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mXGFileSize	J
    //   747: lconst_0
    //   748: lcmp
    //   749: ifgt +489 -> 1238
    //   752: aload_1
    //   753: getfield 3437	pmz:jdField_f_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   756: ldc_w 3438
    //   759: invokestatic 1601	anzj:a	(I)Ljava/lang/String;
    //   762: invokevirtual 2950	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   765: aload_2
    //   766: invokestatic 1202	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:isAdvertisementInfo	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Z
    //   769: ifeq +54 -> 823
    //   772: aload_2
    //   773: checkcast 1199	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo
    //   776: getfield 3441	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdVideoFileSize	J
    //   779: lconst_0
    //   780: lcmp
    //   781: iflt +42 -> 823
    //   784: aload_1
    //   785: getfield 3437	pmz:jdField_f_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   788: new 741	java/lang/StringBuilder
    //   791: dup
    //   792: invokespecial 742	java/lang/StringBuilder:<init>	()V
    //   795: aload_2
    //   796: checkcast 1199	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo
    //   799: getfield 3441	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdVideoFileSize	J
    //   802: invokestatic 3037	rpt:b	(J)Ljava/lang/String;
    //   805: invokevirtual 746	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   808: ldc_w 3442
    //   811: invokestatic 1601	anzj:a	(I)Ljava/lang/String;
    //   814: invokevirtual 746	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   817: invokevirtual 752	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   820: invokevirtual 2950	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   823: aload_0
    //   824: getfield 322	sel:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   827: invokestatic 1157	bhnv:h	(Landroid/content/Context;)Z
    //   830: ifeq +447 -> 1277
    //   833: aload_1
    //   834: getfield 3444	pmz:jdField_d_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   837: iconst_0
    //   838: invokevirtual 1616	android/widget/ImageView:setVisibility	(I)V
    //   841: aload_1
    //   842: getfield 3437	pmz:jdField_f_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   845: bipush 8
    //   847: invokevirtual 1589	android/widget/TextView:setVisibility	(I)V
    //   850: aload_1
    //   851: getfield 3445	pmz:jdField_e_of_type_AndroidViewView	Landroid/view/View;
    //   854: iconst_0
    //   855: invokevirtual 1559	android/view/View:setVisibility	(I)V
    //   858: aload_1
    //   859: getfield 3446	pmz:jdField_d_of_type_AndroidViewView	Landroid/view/View;
    //   862: iconst_0
    //   863: invokevirtual 3026	android/view/View:setBackgroundColor	(I)V
    //   866: aload_1
    //   867: getfield 3447	pmz:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   870: bipush 8
    //   872: invokevirtual 1559	android/view/View:setVisibility	(I)V
    //   875: return
    //   876: aload_1
    //   877: getfield 3355	pmz:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   880: iconst_0
    //   881: invokevirtual 1589	android/widget/TextView:setVisibility	(I)V
    //   884: aload_1
    //   885: getfield 3355	pmz:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   888: new 741	java/lang/StringBuilder
    //   891: dup
    //   892: invokespecial 742	java/lang/StringBuilder:<init>	()V
    //   895: aload_2
    //   896: getfield 823	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mVideoPlayCount	I
    //   899: invokestatic 3240	rpt:c	(I)Ljava/lang/String;
    //   902: invokevirtual 746	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   905: ldc_w 3448
    //   908: invokestatic 1601	anzj:a	(I)Ljava/lang/String;
    //   911: invokevirtual 746	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   914: invokevirtual 752	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   917: invokevirtual 2950	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   920: goto -846 -> 74
    //   923: astore 5
    //   925: aload 5
    //   927: invokevirtual 3034	java/lang/Exception:printStackTrace	()V
    //   930: goto -720 -> 210
    //   933: aload_1
    //   934: getfield 3371	pmz:jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   937: bipush 8
    //   939: invokevirtual 1588	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setVisibility	(I)V
    //   942: goto -732 -> 210
    //   945: aload_1
    //   946: getfield 1866	pmz:h	Landroid/widget/TextView;
    //   949: ldc_w 3450
    //   952: invokestatic 131	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   955: aload_0
    //   956: getfield 322	sel:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   959: invokestatic 3453	tqa:a	(ILandroid/content/Context;)Landroid/graphics/drawable/ShapeDrawable;
    //   962: invokestatic 3376	oxr:a	(Landroid/view/View;Landroid/graphics/drawable/Drawable;)V
    //   965: goto -694 -> 271
    //   968: aload_1
    //   969: getfield 1866	pmz:h	Landroid/widget/TextView;
    //   972: aload_0
    //   973: getfield 322	sel:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   976: ldc_w 3454
    //   979: invokevirtual 2685	android/app/Activity:getString	(I)Ljava/lang/String;
    //   982: invokevirtual 2950	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   985: goto -693 -> 292
    //   988: aload_1
    //   989: getfield 1863	pmz:i	Landroid/widget/TextView;
    //   992: aload_0
    //   993: getfield 322	sel:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   996: ldc_w 3455
    //   999: invokevirtual 2685	android/app/Activity:getString	(I)Ljava/lang/String;
    //   1002: invokevirtual 2950	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   1005: goto -645 -> 360
    //   1008: astore 6
    //   1010: aload_1
    //   1011: getfield 1863	pmz:i	Landroid/widget/TextView;
    //   1014: aload_0
    //   1015: getfield 322	sel:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   1018: ldc_w 3456
    //   1021: invokevirtual 2685	android/app/Activity:getString	(I)Ljava/lang/String;
    //   1024: invokevirtual 2950	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   1027: goto -667 -> 360
    //   1030: aload 5
    //   1032: getfield 3400	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdBtnTxt	Ljava/lang/String;
    //   1035: invokestatic 688	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1038: ifne +18 -> 1056
    //   1041: aload_1
    //   1042: getfield 1863	pmz:i	Landroid/widget/TextView;
    //   1045: aload 5
    //   1047: getfield 3400	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdBtnTxt	Ljava/lang/String;
    //   1050: invokevirtual 2950	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   1053: goto -666 -> 387
    //   1056: aload_1
    //   1057: getfield 1863	pmz:i	Landroid/widget/TextView;
    //   1060: aload_0
    //   1061: getfield 322	sel:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   1064: ldc_w 3456
    //   1067: invokevirtual 2685	android/app/Activity:getString	(I)Ljava/lang/String;
    //   1070: invokevirtual 2950	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   1073: goto -686 -> 387
    //   1076: astore 5
    //   1078: invokestatic 416	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1081: ifeq -651 -> 430
    //   1084: ldc_w 418
    //   1087: iconst_2
    //   1088: ldc_w 3458
    //   1091: aload 5
    //   1093: invokestatic 3235	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1096: goto -666 -> 430
    //   1099: aload_1
    //   1100: getfield 1866	pmz:h	Landroid/widget/TextView;
    //   1103: bipush 8
    //   1105: invokevirtual 1589	android/widget/TextView:setVisibility	(I)V
    //   1108: aload_1
    //   1109: getfield 3383	pmz:jdField_b_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   1112: bipush 8
    //   1114: invokevirtual 3386	android/widget/LinearLayout:setVisibility	(I)V
    //   1117: aload_1
    //   1118: getfield 3410	pmz:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyVideoInfoViewGroup	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyVideoInfoViewGroup;
    //   1121: iconst_0
    //   1122: invokevirtual 3413	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyVideoInfoViewGroup:setVisibility	(I)V
    //   1125: aload_1
    //   1126: getfield 3415	pmz:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   1129: iconst_0
    //   1130: invokevirtual 3386	android/widget/LinearLayout:setVisibility	(I)V
    //   1133: aload_1
    //   1134: getfield 3410	pmz:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyVideoInfoViewGroup	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyVideoInfoViewGroup;
    //   1137: aload_2
    //   1138: aload_0
    //   1139: aload_0
    //   1140: getfield 142	sel:jdField_c_of_type_Int	I
    //   1143: aload_0
    //   1144: getfield 355	sel:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   1147: invokevirtual 3462	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyVideoInfoViewGroup:setArticleInfo	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;Landroid/widget/BaseAdapter;ILjava/util/Set;)V
    //   1150: aload_1
    //   1151: getfield 3463	pmz:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   1154: aload_0
    //   1155: invokevirtual 1860	android/widget/ImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   1158: aload_1
    //   1159: getfield 3463	pmz:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   1162: aload_1
    //   1163: invokevirtual 1871	android/widget/ImageView:setTag	(Ljava/lang/Object;)V
    //   1166: aload_1
    //   1167: getfield 3464	pmz:jdField_b_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   1170: aload_0
    //   1171: invokevirtual 1860	android/widget/ImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   1174: aload_1
    //   1175: getfield 3464	pmz:jdField_b_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   1178: aload_0
    //   1179: invokevirtual 3465	android/widget/ImageView:setOnLongClickListener	(Landroid/view/View$OnLongClickListener;)V
    //   1182: aload_1
    //   1183: getfield 3464	pmz:jdField_b_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   1186: aload_1
    //   1187: invokevirtual 1871	android/widget/ImageView:setTag	(Ljava/lang/Object;)V
    //   1190: goto -737 -> 453
    //   1193: aload_1
    //   1194: getfield 3426	pmz:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   1197: aload_0
    //   1198: invokevirtual 1267	sel:a	()Landroid/app/Activity;
    //   1201: fconst_0
    //   1202: invokestatic 1125	bhgr:a	(Landroid/content/Context;F)I
    //   1205: invokevirtual 3049	android/widget/TextView:setCompoundDrawablePadding	(I)V
    //   1208: aload_0
    //   1209: invokevirtual 1267	sel:a	()Landroid/app/Activity;
    //   1212: invokevirtual 1546	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   1215: ldc_w 3466
    //   1218: invokevirtual 3042	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   1221: astore 4
    //   1223: aload_1
    //   1224: getfield 3426	pmz:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   1227: aload 4
    //   1229: aconst_null
    //   1230: aconst_null
    //   1231: aconst_null
    //   1232: invokevirtual 3046	android/widget/TextView:setCompoundDrawablesWithIntrinsicBounds	(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V
    //   1235: goto -557 -> 678
    //   1238: aload_1
    //   1239: getfield 3437	pmz:jdField_f_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   1242: new 741	java/lang/StringBuilder
    //   1245: dup
    //   1246: invokespecial 742	java/lang/StringBuilder:<init>	()V
    //   1249: aload_2
    //   1250: getfield 576	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mXGFileSize	J
    //   1253: invokestatic 3037	rpt:b	(J)Ljava/lang/String;
    //   1256: invokevirtual 746	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1259: ldc_w 3442
    //   1262: invokestatic 1601	anzj:a	(I)Ljava/lang/String;
    //   1265: invokevirtual 746	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1268: invokevirtual 752	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1271: invokevirtual 2950	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   1274: goto -509 -> 765
    //   1277: aload_1
    //   1278: getfield 3444	pmz:jdField_d_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   1281: bipush 8
    //   1283: invokevirtual 1616	android/widget/ImageView:setVisibility	(I)V
    //   1286: aload_0
    //   1287: getfield 322	sel:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   1290: invokevirtual 1546	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   1293: ldc_w 3039
    //   1296: invokevirtual 3042	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   1299: astore 4
    //   1301: aload_1
    //   1302: getfield 3437	pmz:jdField_f_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   1305: aload 4
    //   1307: aconst_null
    //   1308: aconst_null
    //   1309: aconst_null
    //   1310: invokevirtual 3046	android/widget/TextView:setCompoundDrawablesWithIntrinsicBounds	(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V
    //   1313: aload_1
    //   1314: getfield 3437	pmz:jdField_f_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   1317: ldc_w 2317
    //   1320: aload_0
    //   1321: getfield 322	sel:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   1324: invokevirtual 1546	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   1327: invokestatic 486	agej:a	(FLandroid/content/res/Resources;)I
    //   1330: invokevirtual 3049	android/widget/TextView:setCompoundDrawablePadding	(I)V
    //   1333: aload_1
    //   1334: getfield 3437	pmz:jdField_f_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   1337: iconst_0
    //   1338: invokevirtual 1589	android/widget/TextView:setVisibility	(I)V
    //   1341: invokestatic 3052	bihq:a	()I
    //   1344: iconst_1
    //   1345: if_icmpne +44 -> 1389
    //   1348: aload_1
    //   1349: getfield 3437	pmz:jdField_f_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   1352: ldc_w 3467
    //   1355: invokestatic 1601	anzj:a	(I)Ljava/lang/String;
    //   1358: invokevirtual 2950	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   1361: aload_1
    //   1362: getfield 3468	pmz:g	Landroid/widget/TextView;
    //   1365: bipush 8
    //   1367: invokevirtual 1589	android/widget/TextView:setVisibility	(I)V
    //   1370: aload_1
    //   1371: getfield 3445	pmz:jdField_e_of_type_AndroidViewView	Landroid/view/View;
    //   1374: iconst_0
    //   1375: invokevirtual 1559	android/view/View:setVisibility	(I)V
    //   1378: aload_1
    //   1379: getfield 3446	pmz:jdField_d_of_type_AndroidViewView	Landroid/view/View;
    //   1382: iconst_0
    //   1383: invokevirtual 3026	android/view/View:setBackgroundColor	(I)V
    //   1386: goto -520 -> 866
    //   1389: invokestatic 3057	bnrf:v	()Z
    //   1392: ifeq +301 -> 1693
    //   1395: aload_0
    //   1396: getfield 3058	sel:jdField_h_of_type_Boolean	Z
    //   1399: ifne +294 -> 1693
    //   1402: aload_1
    //   1403: getfield 1278	pmz:jdField_a_of_type_Int	I
    //   1406: ifne +287 -> 1693
    //   1409: invokestatic 3060	bnrf:e	()Ljava/lang/String;
    //   1412: astore 5
    //   1414: invokestatic 3062	bnrf:f	()Ljava/lang/String;
    //   1417: astore 6
    //   1419: invokestatic 3064	bnrf:g	()Ljava/lang/String;
    //   1422: astore 7
    //   1424: aload 5
    //   1426: invokestatic 688	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1429: ifne +220 -> 1649
    //   1432: invokestatic 3066	ozs:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1435: astore 8
    //   1437: ldc_w 828
    //   1440: astore 4
    //   1442: aload 8
    //   1444: ifnull +10 -> 1454
    //   1447: aload 8
    //   1449: invokevirtual 3069	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1452: astore 4
    //   1454: new 1333	sbg
    //   1457: dup
    //   1458: aconst_null
    //   1459: aconst_null
    //   1460: aconst_null
    //   1461: aconst_null
    //   1462: invokespecial 1336	sbg:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1465: aload 4
    //   1467: invokevirtual 3072	sbg:m	(Ljava/lang/String;)Lsbg;
    //   1470: aload_2
    //   1471: getfield 677	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:innerUniqueID	Ljava/lang/String;
    //   1474: invokevirtual 3074	sbg:i	(Ljava/lang/String;)Lsbg;
    //   1477: invokevirtual 1359	sbg:a	()Lsbf;
    //   1480: invokevirtual 1363	sbf:a	()Ljava/lang/String;
    //   1483: astore_2
    //   1484: aload_1
    //   1485: getfield 3468	pmz:g	Landroid/widget/TextView;
    //   1488: iconst_0
    //   1489: invokevirtual 1589	android/widget/TextView:setVisibility	(I)V
    //   1492: aload_1
    //   1493: getfield 3468	pmz:g	Landroid/widget/TextView;
    //   1496: fconst_2
    //   1497: aload_0
    //   1498: getfield 322	sel:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   1501: invokevirtual 1546	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   1504: invokestatic 486	agej:a	(FLandroid/content/res/Resources;)I
    //   1507: invokevirtual 3049	android/widget/TextView:setCompoundDrawablePadding	(I)V
    //   1510: aload_0
    //   1511: getfield 322	sel:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   1514: invokevirtual 1546	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   1517: ldc_w 3075
    //   1520: invokevirtual 3042	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   1523: astore 4
    //   1525: aload 4
    //   1527: iconst_0
    //   1528: iconst_0
    //   1529: ldc_w 3076
    //   1532: aload_0
    //   1533: getfield 322	sel:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   1536: invokevirtual 1546	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   1539: invokestatic 486	agej:a	(FLandroid/content/res/Resources;)I
    //   1542: ldc_w 3076
    //   1545: aload_0
    //   1546: getfield 322	sel:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   1549: invokevirtual 1546	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   1552: invokestatic 486	agej:a	(FLandroid/content/res/Resources;)I
    //   1555: invokevirtual 3081	android/graphics/drawable/Drawable:setBounds	(IIII)V
    //   1558: aload_1
    //   1559: getfield 3468	pmz:g	Landroid/widget/TextView;
    //   1562: aconst_null
    //   1563: aconst_null
    //   1564: aload 4
    //   1566: aconst_null
    //   1567: invokevirtual 3084	android/widget/TextView:setCompoundDrawables	(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V
    //   1570: aload_0
    //   1571: getfield 322	sel:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   1574: aload_1
    //   1575: getfield 3468	pmz:g	Landroid/widget/TextView;
    //   1578: aload 6
    //   1580: aload 7
    //   1582: aload 5
    //   1584: new 3470	sfx
    //   1587: dup
    //   1588: aload_0
    //   1589: aload_2
    //   1590: aload_1
    //   1591: invokespecial 3473	sfx:<init>	(Lsel;Ljava/lang/String;Lpmz;)V
    //   1594: invokestatic 3092	rpt:b	(Landroid/content/Context;Landroid/widget/TextView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/view/View$OnClickListener;)V
    //   1597: aload_1
    //   1598: getfield 3446	pmz:jdField_d_of_type_AndroidViewView	Landroid/view/View;
    //   1601: ldc_w 3093
    //   1604: invokevirtual 3026	android/view/View:setBackgroundColor	(I)V
    //   1607: aload_1
    //   1608: getfield 3445	pmz:jdField_e_of_type_AndroidViewView	Landroid/view/View;
    //   1611: iconst_0
    //   1612: invokevirtual 1559	android/view/View:setVisibility	(I)V
    //   1615: aload_0
    //   1616: iconst_1
    //   1617: putfield 3058	sel:jdField_h_of_type_Boolean	Z
    //   1620: aconst_null
    //   1621: ldc_w 828
    //   1624: ldc_w 3095
    //   1627: ldc_w 3095
    //   1630: iconst_0
    //   1631: iconst_0
    //   1632: ldc_w 828
    //   1635: ldc_w 828
    //   1638: ldc_w 828
    //   1641: aload_2
    //   1642: iconst_0
    //   1643: invokestatic 1372	ocd:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   1646: goto -780 -> 866
    //   1649: aload_1
    //   1650: getfield 3468	pmz:g	Landroid/widget/TextView;
    //   1653: bipush 8
    //   1655: invokevirtual 1589	android/widget/TextView:setVisibility	(I)V
    //   1658: aload_1
    //   1659: getfield 3445	pmz:jdField_e_of_type_AndroidViewView	Landroid/view/View;
    //   1662: iconst_0
    //   1663: invokevirtual 1559	android/view/View:setVisibility	(I)V
    //   1666: aload_1
    //   1667: getfield 3446	pmz:jdField_d_of_type_AndroidViewView	Landroid/view/View;
    //   1670: iconst_0
    //   1671: invokevirtual 3026	android/view/View:setBackgroundColor	(I)V
    //   1674: invokestatic 416	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1677: ifeq -811 -> 866
    //   1680: ldc_w 988
    //   1683: iconst_2
    //   1684: ldc_w 3097
    //   1687: invokestatic 993	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1690: goto -824 -> 866
    //   1693: aload_1
    //   1694: getfield 3468	pmz:g	Landroid/widget/TextView;
    //   1697: bipush 8
    //   1699: invokevirtual 1589	android/widget/TextView:setVisibility	(I)V
    //   1702: aload_1
    //   1703: getfield 3445	pmz:jdField_e_of_type_AndroidViewView	Landroid/view/View;
    //   1706: iconst_0
    //   1707: invokevirtual 1559	android/view/View:setVisibility	(I)V
    //   1710: aload_1
    //   1711: getfield 3446	pmz:jdField_d_of_type_AndroidViewView	Landroid/view/View;
    //   1714: iconst_0
    //   1715: invokevirtual 3026	android/view/View:setBackgroundColor	(I)V
    //   1718: goto -852 -> 866
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1721	0	this	sel
    //   0	1721	1	parampmz	pmz
    //   0	1721	2	paramBaseArticleInfo	BaseArticleInfo
    //   0	1721	3	paramInt	int
    //   14	1551	4	localObject1	Object
    //   190	230	5	localObject2	Object
    //   923	123	5	localException	Exception
    //   1076	16	5	localJSONException1	JSONException
    //   1412	171	5	str1	String
    //   321	7	6	localJSONObject	JSONObject
    //   1008	1	6	localJSONException2	JSONException
    //   1417	162	6	str2	String
    //   1422	159	7	str3	String
    //   1435	13	8	localQQAppInterface	QQAppInterface
    // Exception table:
    //   from	to	target	type
    //   179	210	923	java/lang/Exception
    //   309	358	1008	org/json/JSONException
    //   988	1005	1008	org/json/JSONException
    //   387	430	1076	org/json/JSONException
  }
  
  public void a(pne parampne, BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    parampne.jdField_f_of_type_AndroidViewView.setOnClickListener(null);
    parampne.jdField_f_of_type_AndroidViewView.setOnLongClickListener(this);
    parampne.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = paramBaseArticleInfo;
    parampne.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = ((BaseArticleInfo)paramBaseArticleInfo.mSubArtilceList.get(0));
    BaseArticleInfo localBaseArticleInfo = parampne.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
    parampne.jdField_a_of_type_AndroidWidgetTextView.setText(localBaseArticleInfo.mTitle);
    parampne.jdField_a_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
    parampne.jdField_b_of_type_AndroidWidgetTextView.setText(rpt.c(localBaseArticleInfo.mVideoPlayCount));
    paramBaseArticleInfo = this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130843133);
    paramInt = bhtq.b(8.0F);
    paramBaseArticleInfo.setBounds(0, 0, paramInt, paramInt);
    parampne.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables(paramBaseArticleInfo, null, null, null);
    parampne.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(bhtq.b(3.0F));
    rpt.a(parampne.jdField_c_of_type_AndroidWidgetTextView, localBaseArticleInfo.getCommentCount(), anzj.a(2131711616), "0");
    URL localURL = localBaseArticleInfo.getVideoCoverUrlWithSmartCut(true);
    a(parampne.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, localURL, false);
    parampne.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setTag(parampne);
    parampne.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setOnClickListener(this);
    parampne.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setOnLongClickListener(this);
    rpt.a(localBaseArticleInfo.mVideoArticleSubsText, localBaseArticleInfo.mVideoArticleSubsColor, parampne.jdField_d_of_type_AndroidWidgetTextView);
    localBaseArticleInfo = parampne.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
    parampne.jdField_e_of_type_AndroidWidgetTextView.setText(localBaseArticleInfo.mTitle);
    parampne.jdField_e_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
    parampne.jdField_f_of_type_AndroidWidgetTextView.setText(rpt.c(localBaseArticleInfo.mVideoPlayCount));
    parampne.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawables(paramBaseArticleInfo, null, null, null);
    parampne.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(bhtq.b(3.0F));
    rpt.a(parampne.g, localBaseArticleInfo.getCommentCount(), anzj.a(2131711605), "0");
    paramBaseArticleInfo = localBaseArticleInfo.getVideoCoverUrlWithSmartCut(true);
    a(parampne.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, paramBaseArticleInfo, false);
    parampne.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setTag(parampne);
    parampne.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setOnClickListener(this);
    parampne.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setOnLongClickListener(this);
    rpt.a(localBaseArticleInfo.mVideoArticleSubsText, localBaseArticleInfo.mVideoArticleSubsColor, parampne.h);
  }
  
  public void a(rvy paramrvy, rmn paramrmn)
  {
    this.jdField_a_of_type_Rvy = paramrvy;
    this.jdField_a_of_type_Rmn = paramrmn;
    if (rmn.a(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext())) {
      this.jdField_a_of_type_Rmn.b(true);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyBaseAdapter", 2, "setVideoPlayManager " + this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler + " mVideoPlayManager " + this.jdField_a_of_type_Rvy + " mIsCleanData " + this.jdField_n_of_type_Boolean);
      }
      if ((this.jdField_a_of_type_Rvy != null) && (!this.jdField_n_of_type_Boolean))
      {
        b();
        this.jdField_a_of_type_Rvy.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr);
        this.jdField_a_of_type_Rvy.a(this.jdField_a_of_type_Rmn);
        if (bnrf.a(this.jdField_d_of_type_Int)) {
          this.jdField_a_of_type_Rvy.a(0);
        }
      }
      if ((tqa.a(this.jdField_c_of_type_Int)) && (this.jdField_a_of_type_Rvy != null))
      {
        this.jdField_a_of_type_Rmg = new rmg(this.jdField_a_of_type_AndroidAppActivity, this, this.jdField_a_of_type_Rvy, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, this.jdField_c_of_type_Int);
        this.jdField_a_of_type_Rvy.a(this.jdField_a_of_type_Rmg);
      }
      return;
      this.jdField_a_of_type_Rmn.b(false);
    }
  }
  
  public void a(rwc paramrwc)
  {
    if ((this.jdField_a_of_type_Blmm != null) && (this.jdField_a_of_type_Blmm.isShowing())) {
      this.jdField_a_of_type_Blmm.dismiss();
    }
    if ((this.jdField_a_of_type_Blms != null) && (this.jdField_a_of_type_Blms.isShowing())) {
      this.jdField_a_of_type_Blms.dismiss();
    }
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new ReadInJoyBaseAdapter.39(this, paramrwc), 1000L);
  }
  
  public void a(rwc paramrwc, int paramInt)
  {
    if (this.jdField_a_of_type_Pmw != null) {}
    for (;;)
    {
      return;
      pmz localpmz = a(paramrwc.jdField_j_of_type_JavaLangString);
      if (localpmz != null)
      {
        this.jdField_a_of_type_Pmw = localpmz;
        paramrwc.jdField_a_of_type_AndroidViewView = localpmz.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
      }
      while ((this.jdField_a_of_type_Rvy != null) && (this.jdField_a_of_type_Rvy.a() != null))
      {
        paramrwc = this.jdField_a_of_type_Rvy.a();
        if (QLog.isColorLevel()) {
          QLog.i("ReadInJoyBaseAdapter", 2, "notifyVideoPositionChanged:");
        }
        paramrwc.g();
        return;
        if (QLog.isColorLevel()) {
          QLog.e("ReadInJoyBaseAdapter", 2, "fixNowPlayHolder failed videoPlayParam:" + paramrwc + "    callSource:" + paramInt);
        }
      }
    }
  }
  
  public void a(rwc paramrwc, BaseArticleInfo paramBaseArticleInfo)
  {
    a(paramrwc, paramBaseArticleInfo, false);
  }
  
  public void a(rwc paramrwc, BaseArticleInfo paramBaseArticleInfo, boolean paramBoolean)
  {
    a(paramrwc, paramBaseArticleInfo, paramBoolean, true);
  }
  
  public void a(rwc paramrwc, BaseArticleInfo paramBaseArticleInfo, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "open full play activity, articleID : " + paramBaseArticleInfo.mArticleID + ", playPosition : " + paramrwc.jdField_d_of_type_Long + ",vid : " + paramrwc.jdField_c_of_type_JavaLangString + ", showComment : " + paramBoolean1);
    }
    if (this.jdField_a_of_type_Rvy != null) {
      this.jdField_a_of_type_Rvy.b();
    }
    this.jdField_j_of_type_Boolean = true;
    Bundle localBundle;
    if (ozs.s(paramBaseArticleInfo)) {
      localBundle = b(paramrwc, paramBaseArticleInfo);
    }
    for (;;)
    {
      int i1;
      label137:
      Object localObject;
      label266:
      label275:
      Intent localIntent;
      if (this.jdField_a_of_type_Rvy != null)
      {
        if (this.jdField_a_of_type_Rvy.b() == paramBaseArticleInfo.mArticleID)
        {
          i1 = this.jdField_a_of_type_Rvy.a();
          localBundle.putInt("VIDEO_PLAY_STATUS", i1);
        }
      }
      else
      {
        if (paramrwc.jdField_f_of_type_Int == 2)
        {
          localObject = scq.a(paramrwc.jdField_c_of_type_JavaLangString);
          if (localObject != null)
          {
            localBundle.putString("VIDEO_THIRD_VID_URL", ((scv)localObject).jdField_a_of_type_JavaLangString);
            localBundle.putLong("VIDEO_THIRD_VID_URL_TIME", ((scv)localObject).jdField_b_of_type_Long);
          }
        }
        localBundle.putBoolean("VIDEO_LIST_SCROLL_EXIT", true);
        localBundle.putInt("REPORT_VIDEO_FEEDS_JUMP_FROM", 3);
        if (this.jdField_c_of_type_Int != 0) {
          break label770;
        }
        if (!ozs.i(paramBaseArticleInfo)) {
          break label723;
        }
        localBundle.putInt("VIDEO_FROM_TYPE", 4);
        localBundle.putLong("VIDEO_FROM_POLYMERIC_TOPIC_ID", paramBaseArticleInfo.mPolymericInfo.jdField_f_of_type_Long);
        localBundle.putLong("VIDEO_FROM_POLYMERIC_PUIN", paramBaseArticleInfo.mPolymericInfo.jdField_b_of_type_Long);
        localBundle.putInt("PERFORMANCE_REPORT_VIDEO_FEEDS_JUMP_FROM", 3);
        localBundle.putInt("REPORT_VIDEO_FEEDS_CHANNEL_ID", this.jdField_c_of_type_Int);
        localBundle.putParcelable("VIDEO_COLUMN_INFO", paramBaseArticleInfo.mVideoColumnInfo);
        localBundle.putString("KEY_VIDEO_JSON_LIST", paramBaseArticleInfo.mJsonVideoList);
        localObject = a();
        localIntent = new Intent((Context)localObject, VideoFeedsPlayActivity.class);
        localIntent.addFlags(536870912);
        if (BaseApplicationImpl.sProcessId != 1)
        {
          localBundle.putBoolean("param_needSmooth", rxg.a().d());
          rxg.a().d(true);
          localBundle.putBoolean("param_needAlertInXg", rmn.d());
        }
        localIntent.putExtras(localBundle);
        if ((paramrwc.jdField_f_of_type_Int == 6) && (!ozs.s(paramBaseArticleInfo))) {
          localIntent.putExtra("VIDEO_ARTICLE_INFO_FOR_BIU", (ArticleInfo)paramBaseArticleInfo);
        }
        i1 = 9091;
        if (1 != paramBaseArticleInfo.mVideoType) {
          break label1092;
        }
        i1 = 1;
        label432:
        localIntent.putExtra("VIDEO_FEEDS_INNER_SESSION_ID", paramrwc.l);
        localIntent.putExtra("VIDEO_CHANNEL_SESSION_ID", paramrwc.jdField_m_of_type_JavaLangString);
        localIntent.putExtra("item_x", paramrwc.jdField_h_of_type_Int);
        localIntent.putExtra("item_y", paramrwc.jdField_i_of_type_Int);
        localIntent.putExtra("item_width", paramrwc.jdField_j_of_type_Int);
        localIntent.putExtra("item_height", paramrwc.jdField_k_of_type_Int);
        rpt.a(paramBaseArticleInfo, localIntent);
        localIntent.putExtra("VIDEO_FEEDS_TYPE_FOR_REPORT", ozs.a(paramBaseArticleInfo));
        localIntent.putExtra("VIDEO_SHOW_COMMENT", paramBoolean1);
        localIntent.putExtra("video_player_session_id", this.jdField_a_of_type_Rvy.a());
      }
      try
      {
        paramBoolean1 = pbn.a(localBundle.getInt("VIDEO_FROM_TYPE", -1), Integer.valueOf(localBundle.getString("VIDEO_WIDTH")).intValue(), Integer.valueOf(localBundle.getString("VIDEO_HEIGHT")).intValue(), Integer.valueOf(localBundle.getString("VIDEO_TIME")).intValue());
        if (paramBoolean1)
        {
          rze.a(this.jdField_a_of_type_AndroidAppActivity, localIntent, i1);
          ((Activity)localObject).overridePendingTransition(2130772011, 0);
          ruy.a();
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr != null)
          {
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.d();
            this.jdField_k_of_type_Boolean = true;
          }
          if (bnrf.i()) {
            ocd.a(null, "", "0X8008B68", "0X8008B68", 0, 0, "", "", "", odr.a(null, null, paramBaseArticleInfo.mVideoVid, paramBaseArticleInfo.innerUniqueID, a(), null), false);
          }
          return;
          localBundle = a(paramrwc, paramBaseArticleInfo);
          continue;
          i1 = 1;
          break label137;
          label723:
          if (ozs.s(paramBaseArticleInfo))
          {
            localBundle.putInt("VIDEO_FROM_TYPE", 13);
            localBundle.putLong("VIDEO_FROM_POLYMERIC_PUIN", paramBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_Long);
            break label266;
          }
          localBundle.putInt("VIDEO_FROM_TYPE", 3);
          break label266;
          label770:
          if (this.jdField_c_of_type_Int == 56)
          {
            if (ozs.i(paramBaseArticleInfo))
            {
              localBundle.putInt("VIDEO_FROM_TYPE", 5);
              localBundle.putLong("VIDEO_FROM_POLYMERIC_TOPIC_ID", paramBaseArticleInfo.mPolymericInfo.jdField_f_of_type_Long);
              localBundle.putLong("VIDEO_FROM_POLYMERIC_PUIN", paramBaseArticleInfo.mPolymericInfo.jdField_b_of_type_Long);
            }
            for (;;)
            {
              localBundle.putInt("PERFORMANCE_REPORT_VIDEO_FEEDS_JUMP_FROM", 4);
              break;
              if (ozs.s(paramBaseArticleInfo))
              {
                localBundle.putInt("VIDEO_FROM_TYPE", 5);
                localBundle.putLong("VIDEO_FROM_POLYMERIC_PUIN", paramBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_Long);
              }
              else if (this.jdField_c_of_type_Long == 1004L)
              {
                localBundle.putInt("VIDEO_FROM_TYPE", 25);
              }
              else
              {
                localBundle.putInt("VIDEO_FROM_TYPE", 2);
              }
            }
          }
          if (this.jdField_c_of_type_Int == 70)
          {
            if (ozs.s(paramBaseArticleInfo))
            {
              localBundle.putInt("VIDEO_FROM_TYPE", 14);
              localBundle.putLong("VIDEO_FROM_POLYMERIC_PUIN", paramBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_Long);
              break label275;
            }
            localBundle.putInt("VIDEO_FROM_TYPE", 8);
            localBundle.putInt("PERFORMANCE_REPORT_VIDEO_FEEDS_JUMP_FROM", 7);
            break label275;
          }
          if (this.jdField_c_of_type_Int == 40677)
          {
            localBundle.putInt("REPORT_VIDEO_FEEDS_JUMP_FROM", 6);
            localBundle.putInt("VIDEO_FROM_TYPE", 9);
            localBundle.putInt("key_source", 0);
            localBundle.putInt("PERFORMANCE_REPORT_VIDEO_FEEDS_JUMP_FROM", 8);
            break label275;
          }
          if (pbd.c(this.jdField_c_of_type_Int))
          {
            localBundle.putInt("VIDEO_FROM_TYPE", 24);
            break label275;
          }
          if (this.jdField_d_of_type_Int == 3) {
            localBundle.putInt("VIDEO_FROM_TYPE", 6);
          }
          for (;;)
          {
            localBundle.putInt("PERFORMANCE_REPORT_VIDEO_FEEDS_JUMP_FROM", 5);
            break;
            localBundle.putInt("VIDEO_FROM_TYPE", 7);
          }
          label1092:
          if (0L != paramBaseArticleInfo.mChannelID) {
            break label432;
          }
          i1 = 1;
        }
      }
      catch (Exception paramrwc)
      {
        for (;;)
        {
          paramBoolean1 = false;
          continue;
          ((Activity)localObject).startActivityForResult(localIntent, i1);
          ((Activity)localObject).overridePendingTransition(2130772068, 2130772069);
        }
      }
    }
  }
  
  public void a(rwc paramrwc1, rwc paramrwc2)
  {
    if (paramrwc1 != paramrwc2)
    {
      if (((paramrwc1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo instanceof ArticleInfo)) && ((paramrwc2.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo instanceof ArticleInfo))) {
        pfa.a().a(this.jdField_c_of_type_Int, (ArticleInfo)paramrwc1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, (ArticleInfo)paramrwc2.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.clearFocus();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.postDelayed(new ReadInJoyBaseAdapter.38(this, paramrwc1, paramrwc2), 100L);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Rxb != null) {
        this.jdField_a_of_type_Rxb.a(paramrwc1, paramrwc2);
      }
      return;
      if (this.jdField_a_of_type_Rvy.a() == 7) {
        a(paramrwc1);
      }
    }
  }
  
  public void a(rxb paramrxb)
  {
    this.jdField_a_of_type_Rxb = paramrxb;
  }
  
  public void a(sdz paramsdz)
  {
    this.jdField_a_of_type_Sdz = paramsdz;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setNoteCardLifeCycle(paramsdz);
    }
  }
  
  public void a(sgc paramsgc)
  {
    this.jdField_a_of_type_Sgc = paramsgc;
  }
  
  public void a(sgd paramsgd)
  {
    this.jdField_a_of_type_Sgd = paramsgd;
  }
  
  public void a(sge paramsge)
  {
    this.jdField_a_of_type_Sge = paramsge;
  }
  
  public void a(sgf paramsgf)
  {
    this.jdField_a_of_type_Sgf = paramsgf;
  }
  
  public void a(sgg paramsgg)
  {
    this.jdField_a_of_type_Sgg = paramsgg;
  }
  
  public void a(tpn paramtpn)
  {
    this.jdField_a_of_type_Tpn = paramtpn;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public void a(boolean paramBoolean, ArticleInfo paramArticleInfo1, ArticleInfo paramArticleInfo2, String paramString)
  {
    a(paramBoolean, paramArticleInfo1, paramArticleInfo2, paramString, null);
  }
  
  public void a(boolean paramBoolean, ArticleInfo paramArticleInfo1, ArticleInfo paramArticleInfo2, String paramString, Map<String, Object> paramMap)
  {
    rwc localrwc = a(paramArticleInfo1);
    localrwc.jdField_n_of_type_JavaLangString = paramString;
    localrwc.l = odr.b();
    if ((this.jdField_a_of_type_Rvy != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Rvy.b()))) {
      localrwc.jdField_m_of_type_JavaLangString = this.jdField_a_of_type_Rvy.b();
    }
    paramString = new sbg(null, null, null, null);
    int i1;
    if (paramBoolean)
    {
      i1 = 0;
      ocd.a(null, "", "0X8008D33", "0X8008D33", 0, 0, "", "", "", paramString.w(i1).b(localrwc.l).c(localrwc.jdField_m_of_type_JavaLangString).a(this.jdField_c_of_type_Int).k(paramArticleInfo1.mVideoAdsSource).j(paramArticleInfo1.mVideoAdsJumpType).a(paramArticleInfo1.videoReportInfo).a(paramArticleInfo1).N((int)this.jdField_c_of_type_Long).a().a(), false);
      if (!rpt.a(paramArticleInfo1, a())) {
        break label192;
      }
      b(localrwc, paramArticleInfo1);
    }
    label192:
    label467:
    label474:
    do
    {
      return;
      i1 = 1;
      break;
      if ((paramArticleInfo1.isAccountShown) && (this.jdField_c_of_type_Int == 0) && (!TextUtils.isEmpty(paramArticleInfo1.mArticleContentUrl)))
      {
        ozs.d(a(), paramArticleInfo1.mArticleContentUrl);
        paramString = new sbg(null, null, paramArticleInfo1.mVideoVid, paramArticleInfo1.innerUniqueID);
        if (paramBoolean)
        {
          i1 = 0;
          paramArticleInfo2 = paramString.w(i1).b(localrwc.l).c(localrwc.jdField_m_of_type_JavaLangString).a(this.jdField_c_of_type_Int).k(paramArticleInfo1.mVideoAdsSource).j(paramArticleInfo1.mVideoAdsJumpType).a(paramArticleInfo1.videoReportInfo).a(paramArticleInfo1).N((int)this.jdField_c_of_type_Long).V(ozs.a(paramArticleInfo1)).e(paramArticleInfo1).Q(7).f(paramArticleInfo2);
          if ((paramArticleInfo1.columnEntrances != null) && (paramArticleInfo1.columnEntrances.size() > 0))
          {
            paramArticleInfo1 = (VideoColumnInfo)paramArticleInfo1.columnEntrances.get(0);
            if (paramArticleInfo1.jdField_a_of_type_Int == 0) {
              break label474;
            }
            paramArticleInfo2.a("is_column", "1");
            paramArticleInfo2.a("column_id", String.valueOf(paramArticleInfo1.jdField_a_of_type_Int));
            if (!paramArticleInfo1.jdField_a_of_type_Boolean) {
              break label467;
            }
            paramArticleInfo1 = "1";
            paramArticleInfo2.a("subscribe_flag", paramArticleInfo1);
          }
        }
        for (;;)
        {
          ocd.a(null, "", "0X8007625", "0X8007625", 0, 0, "", "", "", a(paramArticleInfo2.a().a(), paramMap), false);
          return;
          i1 = 1;
          break;
          paramArticleInfo1 = "2";
          break label414;
          paramArticleInfo2.a("is_column", "0");
        }
      }
      if (paramArticleInfo1.isVideoItemForAdJump())
      {
        paramArticleInfo2 = a();
        if (paramArticleInfo2 != null)
        {
          paramString = new Intent(paramArticleInfo2, QQBrowserActivity.class);
          paramString.putExtra("url", paramArticleInfo1.mVideoAdsJumpUrl);
          paramString.putExtra("big_brother_source_key", ozs.f(a()));
          paramArticleInfo2.startActivity(paramString);
        }
        b(localrwc, paramArticleInfo1);
        return;
      }
      if ((this.jdField_c_of_type_Int != 0) && (this.jdField_c_of_type_Int != 56)) {
        break label801;
      }
      if (!rpt.a(this.jdField_a_of_type_AndroidAppActivity, paramArticleInfo1)) {
        break label698;
      }
      b(localrwc, paramArticleInfo1);
    } while ((this.jdField_c_of_type_Int != 56) || (paramArticleInfo1.mVideoDownloadBarInfo == null) || (paramArticleInfo1.mVideoDownloadBarInfo.weishiUGInfo == null) || (!ozs.a(paramArticleInfo1.mVideoDownloadBarInfo.weishiUGInfo.bytes_report_base_url)) || (!ozs.a(paramArticleInfo1.mVideoDownloadBarInfo.weishiUGInfo.bytes_click_schema_report_tail)));
    label414:
    rpt.a(ozs.a(paramArticleInfo1.mVideoDownloadBarInfo.weishiUGInfo.bytes_report_base_url) + ozs.a(paramArticleInfo1.mVideoDownloadBarInfo.weishiUGInfo.bytes_click_schema_report_tail));
    return;
    label698:
    if ((this.jdField_c_of_type_Int == 56) && (paramArticleInfo1.mVideoDownloadBarInfo != null) && (paramArticleInfo1.mVideoDownloadBarInfo.weishiUGInfo != null) && (ozs.a(paramArticleInfo1.mVideoDownloadBarInfo.weishiUGInfo.bytes_report_base_url)) && (ozs.a(paramArticleInfo1.mVideoDownloadBarInfo.weishiUGInfo.bytes_click_report_tail))) {
      rpt.a(ozs.a(paramArticleInfo1.mVideoDownloadBarInfo.weishiUGInfo.bytes_report_base_url) + ozs.a(paramArticleInfo1.mVideoDownloadBarInfo.weishiUGInfo.bytes_click_report_tail));
    }
    label801:
    if (paramArticleInfo1.videoJumpChannelID > 0)
    {
      if (paramArticleInfo1.videoJumpChannelID == 56) {
        oix.a(this.jdField_a_of_type_AndroidAppActivity, paramArticleInfo2, paramArticleInfo1, true);
      }
      for (;;)
      {
        b(localrwc, paramArticleInfo1);
        return;
        paramArticleInfo2 = new HashMap();
        paramArticleInfo2.put("param_key_insert_article_id", Long.valueOf(paramArticleInfo1.mArticleID));
        oix.b(this.jdField_a_of_type_AndroidAppActivity, paramArticleInfo1.videoJumpChannelID, paramArticleInfo1.videoJumpChannelName, paramArticleInfo1.videoJumpChannelType, 5, paramArticleInfo2);
      }
    }
    if (bnrf.d(BaseApplicationImpl.getApplication().getRuntime()) == 1)
    {
      oix.a(this.jdField_a_of_type_AndroidAppActivity, paramArticleInfo2, paramArticleInfo1, true);
      b(localrwc, paramArticleInfo1);
      return;
    }
    localrwc.jdField_a_of_type_JavaUtilMap = paramMap;
    a(localrwc, paramArticleInfo1);
  }
  
  public void a(boolean paramBoolean, BaseArticleInfo paramBaseArticleInfo)
  {
    if (!paramBoolean) {}
    while (this.jdField_c_of_type_Int != 56) {
      return;
    }
    long l2 = 0L;
    int i1 = 0;
    for (;;)
    {
      long l1 = l2;
      if (i1 < this.jdField_b_of_type_JavaUtilList.size())
      {
        if (paramBaseArticleInfo.mRecommendSeq != ((BaseArticleInfo)this.jdField_b_of_type_JavaUtilList.get(i1)).mRecommendSeq) {
          break label117;
        }
        i1 += 1;
        l1 = l2;
        if (i1 <= this.jdField_b_of_type_JavaUtilList.size() - 1) {
          l1 = ((BaseArticleInfo)this.jdField_b_of_type_JavaUtilList.get(i1)).mAlgorithmID;
        }
      }
      pfa.a().a(56, 3, paramBaseArticleInfo.mArticleID, l1);
      return;
      label117:
      i1 += 1;
    }
  }
  
  public abstract boolean a();
  
  public boolean a(int paramInt)
  {
    return paramInt == 46;
  }
  
  public abstract boolean a(int paramInt, long paramLong);
  
  public boolean a(BaseArticleInfo paramBaseArticleInfo1, BaseArticleInfo paramBaseArticleInfo2, boolean paramBoolean)
  {
    if ((a() != null) && (a().contains(paramBaseArticleInfo1)))
    {
      int i1 = a().indexOf(paramBaseArticleInfo1);
      if (paramBoolean) {
        a().remove(i1 + 1);
      }
      a().add(i1 + 1, paramBaseArticleInfo2);
      notifyDataSetChanged();
    }
    return false;
  }
  
  public int b()
  {
    return this.jdField_d_of_type_Int;
  }
  
  public BaseArticleInfo b(int paramInt)
  {
    if ((this.jdField_b_of_type_JavaUtilList.size() > 0) && (paramInt < this.jdField_b_of_type_JavaUtilList.size())) {
      return (BaseArticleInfo)this.jdField_b_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public String b(long paramLong)
  {
    return null;
  }
  
  public pmz b(String paramString)
  {
    Object localObject2 = null;
    int i2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getFirstVisiblePosition();
    int i3 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getLastVisiblePosition();
    int i1 = Math.max(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getHeaderViewsCount(), i2);
    for (;;)
    {
      Object localObject1 = localObject2;
      if (i1 <= i3)
      {
        int i4 = i1 - this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getHeaderViewsCount();
        localObject1 = b(i4);
        if ((localObject1 == null) || (4 != getItemViewType(i4)) || (!TextUtils.equals(((BaseArticleInfo)localObject1).innerUniqueID, paramString))) {
          break label119;
        }
        paramString = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(i1 - i2);
        localObject1 = localObject2;
        if (paramString != null) {
          localObject1 = (pmz)paramString.getTag();
        }
      }
      return localObject1;
      label119:
      i1 += 1;
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr = new VideoPreDownloadMgr(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext());
    VideoPreDownloadMgr localVideoPreDownloadMgr = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr;
    if (this.jdField_c_of_type_Int == 56) {}
    for (int i1 = rwp.jdField_b_of_type_Int;; i1 = rwp.jdField_a_of_type_Int)
    {
      localVideoPreDownloadMgr.a = new rwp(i1, rwp.jdField_f_of_type_Int);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a(new sev(this));
      return;
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
  }
  
  public void b(BaseArticleInfo paramBaseArticleInfo)
  {
    if ((paramBaseArticleInfo.isAccountShown) && (this.jdField_c_of_type_Int == 0) && (!TextUtils.isEmpty(ozs.a(paramBaseArticleInfo.mPartnerAccountInfo.bytes_head_jump_url)))) {
      ozs.d(a(), ozs.a(paramBaseArticleInfo.mPartnerAccountInfo.bytes_head_jump_url));
    }
  }
  
  public void b(AbsListView paramAbsListView, int paramInt)
  {
    if ((this.jdField_c_of_type_Int == 0) || (this.jdField_c_of_type_Int == 40677)) {}
    do
    {
      do
      {
        return;
      } while ((!bhnv.g(this.jdField_a_of_type_AndroidAppActivity)) || (this.jdField_a_of_type_Rvy == null) || (paramAbsListView == null));
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1001);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1001, paramInt);
    } while (!QLog.isColorLevel());
    QLog.d("Q.readinjoy.video", 2, "force checkPlayableArea delay: " + paramInt);
  }
  
  public void b(List<BaseArticleInfo> paramList)
  {
    if ((paramList != null) && (this.jdField_b_of_type_JavaUtilList.getClass().isInstance(paramList)) && (paramList.size() > 0)) {
      this.jdField_b_of_type_JavaUtilList.removeAll(paramList);
    }
  }
  
  public void b(rwc paramrwc, BaseArticleInfo paramBaseArticleInfo)
  {
    int i3 = a();
    String str1 = ozs.d(paramBaseArticleInfo);
    int i1;
    int i2;
    label40:
    sbg localsbg;
    if (((ArticleInfo)paramBaseArticleInfo).hasChannelInfo())
    {
      i1 = paramBaseArticleInfo.mChannelInfoId;
      if (!TextUtils.isEmpty(paramBaseArticleInfo.mArticleFriendLikeText)) {
        break label529;
      }
      i2 = 0;
      ocd.a(null, "CliOper", "", "", "0X80066FA", "0X80066FA", 0, 0, "", Long.toString(paramBaseArticleInfo.mArticleID), Integer.toString(paramBaseArticleInfo.mStrategyId), ozs.b(paramBaseArticleInfo.mAlgorithmID, ozs.a(paramBaseArticleInfo), this.jdField_c_of_type_Int, i1), false);
      ocd.a("0X80066FA", "", "", Long.toString(paramBaseArticleInfo.mArticleID), Integer.toString(paramBaseArticleInfo.mStrategyId), ozs.b(paramBaseArticleInfo.mAlgorithmID, ozs.a(paramBaseArticleInfo), this.jdField_c_of_type_Int, i1));
      localsbg = new sbg(ozs.a(paramBaseArticleInfo.mAlgorithmID, ozs.a(paramBaseArticleInfo), i3, i1, i2, bhnv.h(this.jdField_a_of_type_AndroidAppActivity), str1, paramBaseArticleInfo.mStrCircleId, paramBaseArticleInfo.innerUniqueID, ozs.f(paramBaseArticleInfo), 409409, (ArticleInfo)paramBaseArticleInfo));
      localsbg.a(this.jdField_a_of_type_Rwr, paramBaseArticleInfo.mArticleID).a(this.jdField_a_of_type_Rwr).g(odr.jdField_a_of_type_Int).h(409409).j(paramBaseArticleInfo.mVideoAdsJumpType).k(paramBaseArticleInfo.mVideoAdsSource).a(Boolean.valueOf(ozs.w(paramBaseArticleInfo))).a(paramBaseArticleInfo.videoReportInfo);
      if (i3 != 0) {
        break label535;
      }
      paramrwc.l = odr.b();
      localsbg.b(paramrwc.l);
      if (paramBaseArticleInfo.mVideoColumnInfo != null) {
        localsbg.X(paramBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_Int);
      }
      if (c((ArticleInfo)paramBaseArticleInfo) == 6) {
        localsbg.Z(rpt.f());
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Rvy != null) && (this.jdField_a_of_type_Rvy.a() == paramrwc))
      {
        long l1 = this.jdField_a_of_type_Rvy.a();
        if (l1 != 0L) {
          localsbg.f(l1);
        }
      }
      if (this.jdField_c_of_type_Int != 40677) {
        break label586;
      }
      localsbg.b(paramBaseArticleInfo.mVideoAdsJumpType).a(zqd.a(this.jdField_a_of_type_AndroidAppActivity));
      localsbg.i(2);
      ocd.a(null, "CliOper", "", paramBaseArticleInfo.mSubscribeID, "0X8009293", "0X8009293", 0, 0, Long.toString(paramBaseArticleInfo.mFeedId), Long.toString(paramBaseArticleInfo.mArticleID), Integer.toString(paramBaseArticleInfo.mStrategyId), localsbg.a().a(), false);
      ocd.a("0X8009293", paramBaseArticleInfo.mSubscribeID, Long.toString(paramBaseArticleInfo.mFeedId), Long.toString(paramBaseArticleInfo.mArticleID), Integer.toString(paramBaseArticleInfo.mStrategyId), ozs.a(paramBaseArticleInfo.mAlgorithmID, ozs.a(paramBaseArticleInfo), i3, i1, i2, bhnv.h(this.jdField_a_of_type_AndroidAppActivity), str1, paramBaseArticleInfo.mStrCircleId, paramBaseArticleInfo.innerUniqueID, ozs.f(paramBaseArticleInfo), 409409, (ArticleInfo)paramBaseArticleInfo));
      return;
      i1 = 0;
      break;
      label529:
      i2 = 1;
      break label40;
      label535:
      if ((i3 == 56) && (this.jdField_a_of_type_Rvy != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Rvy.b())))
      {
        paramrwc.jdField_m_of_type_JavaLangString = this.jdField_a_of_type_Rvy.b();
        localsbg.c(paramrwc.jdField_m_of_type_JavaLangString);
      }
    }
    label586:
    localsbg.a(paramBaseArticleInfo).N((int)this.jdField_c_of_type_Long).c(paramBaseArticleInfo).a(paramBaseArticleInfo, true).d(paramBaseArticleInfo).f(paramBaseArticleInfo);
    if ((ozs.l(paramBaseArticleInfo)) && (paramBaseArticleInfo.mPolymericInfo != null)) {
      localsbg.w(paramBaseArticleInfo.mPolymericInfo.jdField_f_of_type_Int + 1);
    }
    String str2 = ubg.b(this.jdField_c_of_type_Int);
    ocd.a(null, "CliOper", "", paramBaseArticleInfo.mSubscribeID, str2, str2, 0, 0, Long.toString(paramBaseArticleInfo.mFeedId), Long.toString(paramBaseArticleInfo.mArticleID), Integer.toString(paramBaseArticleInfo.mStrategyId), a(localsbg.a().a(), paramrwc.jdField_a_of_type_JavaUtilMap), false);
    ocd.a(str2, paramBaseArticleInfo.mSubscribeID, Long.toString(paramBaseArticleInfo.mFeedId), Long.toString(paramBaseArticleInfo.mArticleID), Integer.toString(paramBaseArticleInfo.mStrategyId), ozs.a(paramBaseArticleInfo.mAlgorithmID, ozs.a(paramBaseArticleInfo), i3, i1, i2, bhnv.h(this.jdField_a_of_type_AndroidAppActivity), str1, paramBaseArticleInfo.mStrCircleId, paramBaseArticleInfo.innerUniqueID, ozs.f(paramBaseArticleInfo), 409409, (ArticleInfo)paramBaseArticleInfo));
  }
  
  public void b(sdz paramsdz)
  {
    this.jdField_b_of_type_JavaUtilArrayList.add(paramsdz);
  }
  
  public void b(boolean paramBoolean, BaseArticleInfo paramBaseArticleInfo)
  {
    sbg localsbg;
    if ((paramBaseArticleInfo.isAccountShown) && (this.jdField_c_of_type_Int == 0) && (!TextUtils.isEmpty(paramBaseArticleInfo.mArticleContentUrl)))
    {
      ozs.d(a(), paramBaseArticleInfo.mArticleContentUrl);
      localsbg = new sbg(null, null, paramBaseArticleInfo.mVideoVid, paramBaseArticleInfo.innerUniqueID);
      if (!paramBoolean) {
        break label144;
      }
    }
    label144:
    for (int i1 = 0;; i1 = 1)
    {
      ocd.a(null, "", "0X8007625", "0X8007625", 0, 0, "", "", "", localsbg.w(i1).a(this.jdField_c_of_type_Int).a(paramBaseArticleInfo.videoReportInfo).a(paramBaseArticleInfo).N((int)this.jdField_c_of_type_Long).V(ozs.a(paramBaseArticleInfo)).e(paramBaseArticleInfo).Q(6).f(paramBaseArticleInfo).a().a(), false);
      return;
    }
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public abstract boolean b(int paramInt, long paramLong);
  
  public void c()
  {
    if ((this.jdField_k_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView != null))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.b();
      int i2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getFirstVisiblePosition();
      int i1 = i2;
      if (i2 >= getCount()) {
        i1 = 0;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a(i1);
      this.jdField_k_of_type_Boolean = false;
    }
  }
  
  public void c(sdz paramsdz)
  {
    this.jdField_b_of_type_JavaUtilArrayList.remove(paramsdz);
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr = null;
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Rvy != null) {
      this.jdField_a_of_type_Rvy.a(new sep(this));
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ReadInJoyBaseAdapter", 2, "mVideoPlayManager == null");
  }
  
  public void f()
  {
    if ((this.jdField_a_of_type_Rvy != null) && (this.jdField_a_of_type_Rvy.a() != null)) {}
  }
  
  public void g()
  {
    if (!PreloadManager.a().a()) {}
    for (;;)
    {
      return;
      PreloadManager.a().e();
      int i1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getFirstVisiblePosition();
      int i2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getLastVisiblePosition();
      int i3 = a();
      while (i1 <= i2)
      {
        Object localObject = getItem(i1);
        if ((localObject != null) && ((localObject instanceof BaseArticleInfo)))
        {
          localObject = (BaseArticleInfo)localObject;
          if ((!ozs.a(((BaseArticleInfo)localObject).mArticleContentUrl, ((BaseArticleInfo)localObject).mChannelID, (ArticleInfo)localObject)) && (!ozs.a((BaseArticleInfo)localObject)) && (!a(i3, ((BaseArticleInfo)localObject).mArticleID)))
          {
            localObject = ((BaseArticleInfo)localObject).mArticleContentUrl;
            if (abfv.a((String)localObject)) {
              PreloadManager.a().a((String)localObject);
            }
          }
        }
        i1 += 1;
      }
    }
  }
  
  public int getCount()
  {
    return this.jdField_b_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_b_of_type_JavaUtilList.size())) {
      return this.jdField_b_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    Object localObject = getItem(paramInt);
    if ((localObject instanceof BaseArticleInfo)) {
      return ((BaseArticleInfo)localObject).mArticleID;
    }
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    int i2 = a(paramInt);
    int i1 = i2;
    if (a(i2, paramInt)) {
      i1 = 119;
    }
    return i1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    blqm.a("ReadInJoyBaseAdapter.getView");
    System.currentTimeMillis();
    a(b(paramInt), paramInt);
    BaseArticleInfo localBaseArticleInfo = b(paramInt);
    int i1 = getItemViewType(paramInt);
    Object localObject = a((ArticleInfo)localBaseArticleInfo, i1, paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyBaseAdapter", 2, "getView: " + localBaseArticleInfo + " type= " + i1);
    }
    View localView = (View)pmq.a(this.jdField_a_of_type_AndroidUtilSparseArray, new sfv(this, "onAdapterGetView", i1, localBaseArticleInfo, paramInt, paramView, paramViewGroup));
    pmq.a(this.jdField_a_of_type_AndroidUtilSparseArray, new sfw(this, "onPostGetAdapterView", localView, paramView, localBaseArticleInfo, paramInt));
    if (localView != null)
    {
      a(localBaseArticleInfo, (ppu)localObject, System.currentTimeMillis(), paramInt);
      localObject = super.a(localView, paramInt);
      a((View)localObject, i1, localBaseArticleInfo);
      TextHook.updateFont(paramView);
      blqm.a();
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject;
    }
    if ((a() instanceof ReadInJoyChannelActivity)) {
      if ((this.jdField_d_of_type_Boolean) && (paramView != null) && (paramInt > 0) && (paramInt <= 2))
      {
        if ((paramInt != 1) || (!this.jdField_e_of_type_Boolean)) {
          break label345;
        }
        this.jdField_e_of_type_Boolean = false;
        paramView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimationSet);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.videoanimation", 2, "adapter animation start at item position" + paramInt);
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.videoanimation", 2, " judge adapter animation show or not：");
      }
      QLog.d("ReadInJoyBaseAdapter", 1, "get view has error, return then convert view， viewType : " + i1);
      localObject = paramView;
      break;
      label345:
      if (paramInt == 2)
      {
        if (this.jdField_d_of_type_Boolean) {
          this.jdField_d_of_type_Boolean = false;
        }
        paramView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimationSet);
      }
    }
  }
  
  public int getViewTypeCount()
  {
    return jdField_a_of_type_Qai.a() + 147 + qgg.a();
  }
  
  public void h()
  {
    if ((!bnrf.B(a())) || (!bnrf.C(a()))) {
      return;
    }
    int i1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getFirstVisiblePosition();
    int i2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getLastVisiblePosition();
    ArrayList localArrayList = new ArrayList();
    while (i1 <= i2)
    {
      Object localObject = getItem(i1);
      if (localObject != null)
      {
        localObject = (BaseArticleInfo)localObject;
        if (!ozs.a((BaseArticleInfo)localObject)) {
          localArrayList.add((ArticleInfo)localObject);
        }
      }
      i1 += 1;
    }
    pfa.a().a().a(localArrayList);
  }
  
  public void i()
  {
    this.jdField_f_of_type_Boolean = true;
    if ((this.jdField_a_of_type_Rvy != null) && ((c()) || (this.jdField_a_of_type_Rmn.a())) && (!this.jdField_a_of_type_Rmn.b()) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getVisibility() == 0))
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1001);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1001);
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "checkPlayableArea after transAnim: ");
      }
    }
  }
  
  public boolean isEmpty()
  {
    return this.jdField_b_of_type_JavaUtilList.isEmpty();
  }
  
  public void j()
  {
    int i2 = 0;
    if (this.jdField_a_of_type_Rmg != null) {
      this.jdField_a_of_type_Rmg.b();
    }
    if (this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video_" + this.jdField_c_of_type_Int, 2, "ReadInJoyBaseAdapter doOnResume()");
      }
      if (bnrf.j()) {
        s();
      }
      this.p = true;
      this.jdField_a_of_type_Boolean = true;
      c();
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new ReadInJoyBaseAdapter.43(this), 1000L);
      if (Build.VERSION.SDK_INT < 21) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setFriction(jdField_a_of_type_Float);
      }
      this.jdField_a_of_type_Twz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, 4);
      this.jdField_i_of_type_Boolean = false;
      this.jdField_h_of_type_Boolean = false;
      int i1 = 0;
      while (i1 < this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildCount())
      {
        localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(i1);
        if (((localObject instanceof sdx)) && (!((sdx)localObject).a()))
        {
          ((sdx)localObject).setIsResume(true);
          ((sdx)localObject).a();
        }
        i1 += 1;
      }
      i1 = 0;
      while (i1 < this.jdField_b_of_type_JavaUtilArrayList.size())
      {
        ((sdz)this.jdField_b_of_type_JavaUtilArrayList.get(i1)).a();
        i1 += 1;
      }
      if (this.jdField_a_of_type_Sdz != null) {
        this.jdField_a_of_type_Sdz.a();
      }
      Object localObject = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      if ((prz.a() == 2) && (prz.b(a(), (String)localObject) > 0))
      {
        localObject = (SensorManager)a().getSystemService("sensor");
        aohg localaohg = this.jdField_a_of_type_Aohg;
        Sensor localSensor = ((SensorManager)localObject).getDefaultSensor(1);
        i1 = i2;
        if (bdmy.a().a()) {
          i1 = 2;
        }
        ((SensorManager)localObject).registerListener(localaohg, localSensor, i1);
      }
    } while (!ProteusParserWithHotReload.getInstance().isSupportHotReload());
    ProteusParserWithHotReload.getInstance().addHotReloadChangedObserver(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewParseProteusParserWithHotReload$IHotReloadChangedObserver);
  }
  
  public void k()
  {
    int i3 = 0;
    if (this.jdField_a_of_type_Rmg != null) {
      this.jdField_a_of_type_Rmg.c();
    }
    if (!this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video_" + this.jdField_c_of_type_Int, 2, "ReadInJoyBaseAdapter doOnPause()");
      }
      this.jdField_a_of_type_Boolean = false;
      if ((this.jdField_a_of_type_Blmm != null) && (this.jdField_a_of_type_Blmm.isShowing())) {
        this.jdField_a_of_type_Blmm.dismiss();
      }
      this.jdField_a_of_type_Twz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, 5);
      y();
      if ((!bnrf.o()) && (oyj.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, "default_feeds")))
      {
        QLog.d("ReadInJoyBaseAdapter", 2, "hasRefresh notifyDataSetChanged");
        notifyDataSetChanged();
      }
      int i1 = 0;
      int i2;
      for (;;)
      {
        i2 = i3;
        if (i1 >= this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildCount()) {
          break;
        }
        View localView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(i1);
        if (((localView instanceof sdx)) && (((sdx)localView).a()))
        {
          ((sdx)localView).setIsResume(false);
          ((sdx)localView).b();
        }
        i1 += 1;
      }
      while (i2 < this.jdField_b_of_type_JavaUtilArrayList.size())
      {
        ((sdz)this.jdField_b_of_type_JavaUtilArrayList.get(i2)).b();
        i2 += 1;
      }
      if (this.jdField_a_of_type_Sdz != null) {
        this.jdField_a_of_type_Sdz.b();
      }
      ((SensorManager)a().getSystemService("sensor")).unregisterListener(this.jdField_a_of_type_Aohg);
    } while (!ProteusParserWithHotReload.getInstance().isSupportHotReload());
    ProteusParserWithHotReload.getInstance().removeHotReloadChangedObserver(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewParseProteusParserWithHotReload$IHotReloadChangedObserver);
  }
  
  public void l()
  {
    if (this.jdField_a_of_type_Rxb != null) {
      this.jdField_a_of_type_Rxb.l();
    }
  }
  
  public void m()
  {
    this.jdField_a_of_type_Rvy.b(9);
  }
  
  public void n()
  {
    if ((this.jdField_a_of_type_Rvy != null) && (tqa.a(this.jdField_c_of_type_Int))) {
      m();
    }
  }
  
  public void notifyDataSetChanged()
  {
    super.notifyDataSetChanged();
    pmq.a(this.jdField_a_of_type_AndroidUtilSparseArray, new sfp(this, "onNotifyDataSetChange"));
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "notifyDataSetChanged");
    }
    if (((this.jdField_a_of_type_Pmw != null) || (this.jdField_a_of_type_Rwc != null)) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr != null))
    {
      int i2 = -1;
      int i1 = i2;
      if (this.jdField_a_of_type_Pmw != null)
      {
        i1 = i2;
        if (this.jdField_a_of_type_Pmw.a() != null) {
          i1 = this.jdField_a_of_type_Pmw.a().jdField_a_of_type_Int;
        }
      }
      if (this.jdField_a_of_type_Rwc != null) {
        i1 = this.jdField_a_of_type_Rwc.jdField_a_of_type_Int;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a(i1, true);
    }
  }
  
  public void o()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.c(7);
    }
  }
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_AndroidAppActivity instanceof ReadInJoyFeedsActivity)) {
      ((ReadInJoyFeedsActivity)this.jdField_a_of_type_AndroidAppActivity).b(16);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1001);
    sga localsga = (sga)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramView.getId()));
    if (localsga != null) {
      localsga.onClick(paramView);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      QLog.e("ReadInJoyBaseAdapter", 1, "onClick, has no click handler for id(" + paramView.getId() + "}");
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    boolean bool = false;
    switch (paramView.getId())
    {
    default: 
      return false;
    }
    if (omu.b() == 1) {
      bool = true;
    }
    a(paramView, true, bool);
    return true;
  }
  
  public void p()
  {
    QLog.d("ReadInJoyBaseAdapter", 1, "invalidAllArticles");
    oyj.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, "default_feeds");
    if (this.jdField_b_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        BaseArticleInfo localBaseArticleInfo = (BaseArticleInfo)localIterator.next();
        if (localBaseArticleInfo != null) {
          localBaseArticleInfo.invalidateProteusTemplateBean();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sel
 * JD-Core Version:    0.7.0.1
 */