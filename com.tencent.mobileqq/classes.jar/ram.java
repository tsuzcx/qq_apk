import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
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
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentGridImage;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.FusionBiuInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayActivity;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr;
import com.tencent.biz.pubaccount.readinjoy.video.multivideo.MultiVideoFragment;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.12;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.13;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.14;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.15;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.21;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.25;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.27;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.28;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.33;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.4;
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
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.qphone.base.util.QLog;
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
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import tencent.im.oidb.articlesummary.articlesummary.ChannelInfo;
import tencent.im.oidb.articlesummary.articlesummary.PartnerAccountInfo;
import tencent.im.oidb.articlesummary.articlesummary.VideoDownloadBarInfo;
import tencent.im.oidb.articlesummary.articlesummary.WeishiUGInfo;
import tencent.im.oidb.gallery.galleryFeeds.GalleryFeedsInfo;

public abstract class ram
  extends xdq
  implements View.OnClickListener, View.OnLongClickListener, bftp, qun, qvf, qzx
{
  public static float a;
  public static int a;
  private static pjn jdField_a_of_type_Pjn;
  public static int b;
  public static int f;
  static final int g;
  static final int h;
  private static int j;
  private static int jdField_k_of_type_Int;
  public long a;
  private akgf jdField_a_of_type_Akgf = new rbh(this);
  public Activity a;
  protected Drawable a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private SparseArray<oxx> jdField_a_of_type_AndroidUtilSparseArray;
  protected LayoutInflater a;
  private AnimationSet jdField_a_of_type_AndroidViewAnimationAnimationSet;
  public bfos a;
  private bfst jdField_a_of_type_Bfst;
  private bfsz jdField_a_of_type_Bfsz;
  protected VideoPreDownloadMgr a;
  public ReadInJoyXListView a;
  private VafContext jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext = new pol();
  private ProteusParserWithHotReload.IHotReloadChangedObserver jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewParseProteusParserWithHotReload$IHotReloadChangedObserver = new rbi(this);
  public GdtHandler.Params a;
  public INetInfoHandler a;
  private Runnable jdField_a_of_type_JavaLangRunnable = new ReadInJoyBaseAdapter.21(this);
  public ArrayList<qao> a;
  public HashSet<String> a;
  protected List<Object> a;
  public Map<Long, qao> a;
  protected Set<Long> a;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new MqqHandler();
  private nlu jdField_a_of_type_Nlu;
  private oag jdField_a_of_type_Oag;
  public oyi a;
  protected qki a;
  private qkr jdField_a_of_type_Qkr;
  public qtr a;
  public qtv a;
  protected qum a;
  private quo jdField_a_of_type_Quo;
  private qvf jdField_a_of_type_Qvf;
  private raa jdField_a_of_type_Raa;
  protected rbo a;
  protected rbp a;
  protected rbq a;
  protected rbr a;
  private rbs jdField_a_of_type_Rbs;
  public rbw a;
  ric jdField_a_of_type_Ric = new ric();
  private rsj jdField_a_of_type_Rsj;
  sdq jdField_a_of_type_Sdq = new rbe(this);
  private sds jdField_a_of_type_Sds;
  public boolean a;
  public long b;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private AnimationSet jdField_b_of_type_AndroidViewAnimationAnimationSet;
  private bfos jdField_b_of_type_Bfos = new ray(this);
  private ArrayList<raa> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  public HashSet<String> b;
  public List<BaseArticleInfo> b;
  protected Set<Long> b;
  public boolean b;
  public int c;
  private long jdField_c_of_type_Long = -1L;
  private bfos jdField_c_of_type_Bfos = new raz(this);
  public boolean c;
  protected int d;
  private long d;
  protected boolean d;
  public int e;
  protected boolean e;
  protected boolean f;
  protected boolean g;
  public boolean h;
  int i;
  public boolean i;
  protected boolean j;
  private boolean jdField_k_of_type_Boolean;
  private int jdField_l_of_type_Int = -1;
  private boolean jdField_l_of_type_Boolean = true;
  private int jdField_m_of_type_Int;
  private boolean jdField_m_of_type_Boolean;
  private boolean n;
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
    jdField_a_of_type_Pjn = new pjn();
    jdField_g_of_type_Int = Color.parseColor("#999999");
    jdField_h_of_type_Int = Color.parseColor("#262626");
  }
  
  public ram(Activity paramActivity, LayoutInflater paramLayoutInflater, int paramInt, ListView paramListView, SparseArray<oxx> paramSparseArray)
  {
    this.jdField_c_of_type_Int = -1;
    this.jdField_e_of_type_Int = -1;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_e_of_type_Boolean = true;
    this.jdField_a_of_type_Long = -2147483648L;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_b_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_i_of_type_Int = -1;
    this.jdField_a_of_type_Bfos = new rax(this);
    this.jdField_a_of_type_Rbw = new rba(this);
    this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new rbb(this);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidViewLayoutInflater = paramLayoutInflater;
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.setContext(paramActivity);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.setCurActivity(paramActivity);
    this.jdField_e_of_type_Int = onh.d();
    olo.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, "default_feeds");
    jdField_a_of_type_Pjn.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView = ((ReadInJoyXListView)paramListView);
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    a(paramSparseArray);
    this.jdField_a_of_type_Quo = new quo(paramActivity);
    this.jdField_a_of_type_Sds = new sds(paramActivity, true);
    t();
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView instanceof ReadInJoyXListView)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setOnDrawCompleteListener(this.jdField_a_of_type_Rbw);
    }
    this.jdField_a_of_type_AndroidOsHandler = new ran(this, Looper.getMainLooper());
    q();
    p();
    ((ReadInJoyXListView)paramListView).a(this);
  }
  
  public static int a(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo == null) || (paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyBaseAdapter", 2, "ugc feeds info is null");
      }
      return 21;
    }
    switch (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda.jdField_a_of_type_Int)
    {
    case 1: 
    default: 
      return 21;
    case 2: 
    case 3: 
      if ((paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int == 9) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda.jdField_a_of_type_JavaUtilArrayList.size() > 1)) {
        return 36;
      }
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcl != null) {
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
    int i1 = 16;
    if (paramArticleInfo == null) {
      label7:
      return 0;
    }
    pjn localpjn = jdField_a_of_type_Pjn;
    if (pjn.a(paramArticleInfo)) {
      return jdField_a_of_type_Pjn.a(paramArticleInfo);
    }
    if (paramArticleInfo.mFeedType == 20)
    {
      i1 = 82;
      paramInt = i1;
      if (paramArticleInfo.mRecommendFollowInfos != null) {
        switch (paramArticleInfo.mRecommendFollowInfos.jdField_a_of_type_Int)
        {
        default: 
          paramInt = i1;
        }
      }
      for (;;)
      {
        return paramInt;
        paramInt = 82;
        continue;
        paramInt = 87;
        continue;
        paramInt = 88;
      }
    }
    if ((paramArticleInfo.mFeedType == 21) || (paramArticleInfo.mFeedType == 22)) {
      paramInt = onh.a(paramArticleInfo, false);
    }
    for (;;)
    {
      return paramInt;
      if (paramArticleInfo.mFeedType == 28)
      {
        paramInt = 93;
      }
      else if (paramArticleInfo.mFeedType == 24)
      {
        paramInt = onh.b(paramArticleInfo);
      }
      else if (paramArticleInfo.mFeedType == 34)
      {
        paramInt = 123;
      }
      else if ((paramArticleInfo.mGroupSubArticleList != null) && (paramArticleInfo.mFeedType != 29))
      {
        paramInt = 53;
      }
      else if (paramArticleInfo.mFeedType == 25)
      {
        paramInt = 89;
      }
      else if (paramArticleInfo.mFeedType == 15)
      {
        paramInt = 38;
      }
      else if ((paramArticleInfo.mFeedType == 3) || (paramArticleInfo.mFeedType == 13))
      {
        paramInt = 15;
      }
      else if (paramArticleInfo.mFeedType == 30)
      {
        paramInt = 107;
      }
      else
      {
        if ((paramArticleInfo.mFeedType != 1) || (paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mChannelID == 56L)) {
          break label1075;
        }
        paramInt = onp.a(paramArticleInfo);
        if ((paramInt == 21) || (paramInt == 22))
        {
          paramInt = onh.a(paramArticleInfo, true);
        }
        else if (paramInt == 11)
        {
          paramInt = 33;
        }
        else if (onh.g(paramArticleInfo))
        {
          switch (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int)
          {
          default: 
            paramInt = 12;
            break;
          case 1: 
            paramInt = 10;
            break;
          case 2: 
            paramInt = 27;
            break;
          case 9: 
            paramInt = 35;
            break;
          }
        }
        else
        {
          if (!onh.h(paramArticleInfo)) {
            break;
          }
          switch (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda.jdField_a_of_type_Int)
          {
          default: 
            paramInt = 24;
            break;
          case 1: 
            paramInt = 24;
            break;
          case 2: 
          case 3: 
            paramInt = 25;
            break;
          case 4: 
          case 5: 
            paramInt = 26;
          }
        }
      }
    }
    if (onh.d(paramArticleInfo)) {
      if ((paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcv == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcv.jdField_a_of_type_JavaUtilArrayList == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcv.jdField_a_of_type_JavaUtilArrayList.size() <= 0)) {
        break label2543;
      }
    }
    label1075:
    label2543:
    for (paramInt = ComponentContentGridImage.a(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcv.jdField_a_of_type_JavaUtilArrayList.size(), paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int);; paramInt = 0)
    {
      if (paramInt != 0) {
        switch (paramInt)
        {
        default: 
          paramInt = 0;
          break;
        case 1: 
          paramInt = 49;
          break;
        case 3: 
          paramInt = 62;
          break;
        case 9: 
          paramInt = 63;
          break;
        }
      }
      switch (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int)
      {
      default: 
        paramInt = 12;
        break;
      case 9: 
        paramInt = 63;
        break;
      case 3: 
        paramInt = 62;
        break;
      case 8: 
        paramInt = 49;
        break;
        if (paramInt == 25)
        {
          paramInt = 92;
          break;
        }
        if ((paramInt == 27) && (paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcz != null))
        {
          if (!TextUtils.isEmpty(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcz.jdField_c_of_type_JavaLangString))
          {
            paramInt = 94;
            break;
          }
          paramInt = 95;
          break;
        }
        if ((paramInt == 32) && (paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qck != null))
        {
          paramInt = 26;
          break;
        }
        if (!i(paramArticleInfo))
        {
          if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int == 0)
          {
            paramInt = 12;
            if (!paramArticleInfo.isPGCShortContent()) {
              break;
            }
            paramInt = 112;
            break;
          }
          if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int == 1)
          {
            paramInt = 10;
            if (!paramArticleInfo.isPGCShortContent()) {
              break;
            }
            paramInt = 113;
            break;
          }
          if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int == 5)
          {
            paramInt = 11;
            break;
          }
          if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int == 2)
          {
            paramInt = 27;
            if (!paramArticleInfo.isPGCShortContent()) {
              break;
            }
            paramInt = 113;
            break;
          }
          if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int == 6)
          {
            paramInt = 28;
            break;
          }
          if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int == 9)
          {
            paramInt = 35;
            if (!paramArticleInfo.isPGCShortContent()) {
              break;
            }
            paramInt = 114;
            break;
          }
          paramInt = 12;
          if (!paramArticleInfo.isPGCShortContent()) {
            break;
          }
          paramInt = 112;
          break;
        }
        if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda.jdField_a_of_type_Int == 1)
        {
          if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda.c.size() > 0)
          {
            paramInt = 108;
            break;
          }
          paramInt = 24;
          break;
        }
        if ((paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda.jdField_a_of_type_Int == 3) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda.jdField_a_of_type_Int == 2))
        {
          if ((paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int == 9) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda.jdField_a_of_type_JavaUtilArrayList.size() > 1))
          {
            paramInt = 37;
            break;
          }
          if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcl != null)
          {
            paramInt = 81;
            break;
          }
          paramInt = 25;
          break;
        }
        paramInt = 26;
        break;
        if (((paramArticleInfo.mFeedType == 11) || (paramArticleInfo.mFeedType == 14)) && (paramArticleInfo.mTopicRecommendFeedsInfo != null) && (paramArticleInfo.mTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList != null) && (paramArticleInfo.mTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList.size() > 0))
        {
          if (paramArticleInfo.mTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList.size() > 1)
          {
            paramInt = 30;
            break;
          }
          paramInt = 29;
          break;
        }
        if (a(paramArticleInfo))
        {
          paramInt = i1;
          if (paramArticleInfo.mSocialFeedInfo == null) {
            break;
          }
          paramInt = i1;
          switch (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int)
          {
          case 8: 
          default: 
            paramInt = i1;
            break;
          case 0: 
            paramInt = 20;
            if (!paramArticleInfo.isPGCShortContent()) {
              break;
            }
            paramInt = 109;
            break;
          case 5: 
            paramInt = 17;
            break;
          case 2: 
            paramInt = 18;
            if (!paramArticleInfo.isPGCShortContent()) {
              break;
            }
            paramInt = 110;
            break;
          case 6: 
            paramInt = 19;
            if (!paramArticleInfo.isPGCShortContent()) {
              break;
            }
            paramInt = 133;
            break;
          case 9: 
            paramInt = 34;
            if (!paramArticleInfo.isPGCShortContent()) {
              break;
            }
            paramInt = 111;
            break;
          case 3: 
            paramInt = i1;
            if (!paramArticleInfo.isPGCShortContent()) {
              break;
            }
            paramInt = 111;
            break;
          case 1: 
            paramInt = i1;
            if (!paramArticleInfo.isPGCShortContent()) {
              break;
            }
            paramInt = 132;
            break;
          case 19191924: 
            paramInt = i1;
            if (!paramArticleInfo.isPGCShortContent()) {
              break;
            }
            paramInt = 134;
            break;
          }
        }
        if ((paramArticleInfo.mFeedType == 32) && (paramArticleInfo.mSocialFeedInfo != null))
        {
          paramInt = 120;
          break;
        }
        if ((a(paramArticleInfo)) && (paramArticleInfo.mSocialFeedInfo != null))
        {
          paramInt = a(paramArticleInfo);
          break;
        }
        if ((onh.b(paramArticleInfo)) || (onh.c(paramArticleInfo)))
        {
          paramInt = 40;
          if (paramArticleInfo.mSocialFeedInfo == null) {
            break;
          }
        }
        switch (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int)
        {
        default: 
          paramInt = 40;
          break;
        case 2: 
          paramInt = 40;
          break;
        case 1: 
          paramInt = 41;
          break;
        case 9: 
          paramInt = 42;
          break;
          if ((onh.e(paramArticleInfo)) || (onh.f(paramArticleInfo)))
          {
            paramInt = b(paramArticleInfo);
            break;
          }
          if (h(paramArticleInfo))
          {
            paramInt = 31;
            if (paramArticleInfo.mSocialFeedInfo == null) {
              break;
            }
            switch (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int)
            {
            case 3: 
            case 4: 
            case 7: 
            case 8: 
            default: 
              paramInt = 86;
              if (!paramArticleInfo.isPGCShortContent()) {
                break;
              }
              paramInt = 109;
              break;
            case 2: 
              paramInt = 31;
              if (!paramArticleInfo.isPGCShortContent()) {
                break;
              }
              paramInt = 110;
              break;
            case 6: 
              paramInt = 32;
              break;
            case 1: 
              paramInt = 83;
              if (!paramArticleInfo.isPGCShortContent()) {
                break;
              }
              paramInt = 111;
              break;
            case 5: 
              paramInt = 84;
              break;
            case 9: 
              paramInt = 85;
              if (!paramArticleInfo.isPGCShortContent()) {
                break;
              }
              paramInt = 111;
              break;
            case 0: 
              paramInt = 86;
              if (!paramArticleInfo.isPGCShortContent()) {
                break;
              }
              paramInt = 109;
              break;
            }
          }
          if (paramArticleInfo.mFeedType == 23)
          {
            paramInt = i1;
            if (paramArticleInfo.mSocialFeedInfo == null) {
              break;
            }
            switch (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int)
            {
            default: 
              paramInt = i1;
              break;
            case 3: 
              paramInt = 64;
              break;
            case 9: 
              paramInt = 65;
              break;
            case 8: 
              paramInt = 48;
              break;
            }
          }
          if ((paramArticleInfo.mChannelID == 0L) && (paramArticleInfo.mSimpleVideoColumnInfo != null) && (onh.a(paramArticleInfo)))
          {
            paramInt = 128;
            break;
          }
          if ((paramArticleInfo.mChannelID == 0L) && (paramArticleInfo.mVideoColumnInfo != null) && (onh.a(paramArticleInfo)))
          {
            paramInt = 118;
            break;
          }
          if (paramArticleInfo.multiVideoColumnInfo != null)
          {
            if (paramArticleInfo.multiVideoColumnInfo.jdField_a_of_type_Boolean)
            {
              paramInt = 125;
              break;
            }
            paramInt = 124;
            break;
          }
          if (paramArticleInfo.mKdLiveInfo != null)
          {
            if (paramArticleInfo.mKdLiveInfo.jdField_a_of_type_Int == 4)
            {
              paramInt = 130;
              break;
            }
            paramInt = 129;
            break;
          }
          if (paramArticleInfo.isWeishiGridTwoItemFeed())
          {
            paramInt = 70;
            break;
          }
          if (paramArticleInfo.isTwoItemVideoFeed())
          {
            if ((paramArticleInfo.mFeedType == 33) && (paramArticleInfo.mChannelID != 56L) && (paramArticleInfo.mChannelID != 70L))
            {
              paramInt = 121;
              break;
            }
            paramInt = 46;
            break;
          }
          if ((onh.a(paramArticleInfo)) && (paramArticleInfo.mPictures != null) && (paramArticleInfo.mPictures.length >= 3) && (paramArticleInfo.mChannelID == 0L))
          {
            paramInt = 14;
            break;
          }
          if (onh.a(paramArticleInfo))
          {
            if (paramArticleInfo.mVideoType == 0)
            {
              if (onh.a())
              {
                if ((paramArticleInfo.mChannelID == 56L) || (paramInt == 3))
                {
                  paramInt = 4;
                  break;
                }
                if (AdvertisementInfo.isAdvertisementInfo(paramArticleInfo))
                {
                  if (((AdvertisementInfo)paramArticleInfo).isIMaxAndNewStyle)
                  {
                    paramInt = 115;
                    break;
                  }
                  paramInt = 66;
                  break;
                }
                if (qoi.b() == 0)
                {
                  paramInt = 126;
                  break;
                }
                paramInt = 6;
                break;
              }
              if (AdvertisementInfo.isAdvertisementInfo(paramArticleInfo))
              {
                if (((AdvertisementInfo)paramArticleInfo).isIMaxAndNewStyle)
                {
                  paramInt = 115;
                  break;
                }
                paramInt = 66;
                break;
              }
              if (qoi.b() == 0)
              {
                paramInt = 126;
                break;
              }
              paramInt = 6;
              break;
            }
            if (paramArticleInfo.mChannelID == 56L)
            {
              paramInt = 4;
              break;
            }
            paramInt = 5;
            break;
          }
          if (onh.b(paramArticleInfo))
          {
            if (paramArticleInfo.mGalleryFeedsInfo.enum_article_style.get() == 3)
            {
              paramInt = 103;
              break;
            }
            if (paramArticleInfo.mGalleryFeedsInfo.enum_article_style.get() == 2)
            {
              paramInt = 102;
              break;
            }
            paramInt = 101;
            break;
          }
          if (paramArticleInfo.mShowBigPicture)
          {
            if (paramArticleInfo.mIsGallery == 0)
            {
              if (paramArticleInfo.mTopicPicWHRatio != 0.0D)
              {
                paramInt = 9;
                break;
              }
              if (AdvertisementInfo.isAdvertisementInfo(paramArticleInfo))
              {
                paramInt = oar.b((AdvertisementInfo)paramArticleInfo);
                break;
              }
              paramInt = 2;
              break;
            }
            if (paramArticleInfo.articleStyle == 3)
            {
              paramInt = 47;
              break;
            }
            if (paramArticleInfo.articleStyle == 4)
            {
              paramInt = 60;
              break;
            }
            if (paramArticleInfo.articleStyle == 5)
            {
              paramInt = 61;
              break;
            }
            if (paramArticleInfo.articleStyle == 6)
            {
              paramInt = 96;
              break;
            }
            paramInt = 8;
            break;
          }
          if ((AdvertisementInfo.isAdvertisementInfo(paramArticleInfo)) && (oar.h((AdvertisementInfo)paramArticleInfo))) {
            return 116;
          }
          if ((AdvertisementInfo.isAdvertisementInfo(paramArticleInfo)) && (oar.i((AdvertisementInfo)paramArticleInfo))) {
            return 39;
          }
          if ((AdvertisementInfo.isAdvertisementInfo(paramArticleInfo)) && (oar.j((AdvertisementInfo)paramArticleInfo))) {
            return 117;
          }
          if (onh.i(paramArticleInfo))
          {
            if (onh.j(paramArticleInfo)) {
              return 91;
            }
            return 90;
          }
          if ((AdvertisementInfo.isAdvertisementInfo(paramArticleInfo)) && (oar.k((AdvertisementInfo)paramArticleInfo))) {
            return 127;
          }
          if ((paramArticleInfo.mPictures != null) && (paramArticleInfo.mPictures.length >= 3))
          {
            if (AdvertisementInfo.isAdvertisementInfo(paramArticleInfo))
            {
              paramInt = 105;
              break;
            }
            paramInt = 3;
            break;
          }
          if (TextUtils.isEmpty(paramArticleInfo.mFirstPagePicUrl)) {
            break label7;
          }
          if ((AdvertisementInfo.isAdvertisementInfo(paramArticleInfo)) && (oar.l((AdvertisementInfo)paramArticleInfo)))
          {
            paramInt = 122;
            break;
          }
          if (paramArticleInfo.mIsGallery == 0)
          {
            if (AdvertisementInfo.isAdvertisementInfo(paramArticleInfo))
            {
              if (nmc.a(paramArticleInfo))
              {
                paramInt = 106;
                break;
              }
              paramInt = 104;
              break;
            }
            paramInt = 1;
            break;
          }
          paramInt = 7;
          break;
        }
        break;
      }
    }
  }
  
  public static int a(ListView paramListView, qtv paramqtv)
  {
    if (paramqtv != null)
    {
      paramqtv = paramListView.getChildAt(paramqtv.jdField_a_of_type_Int + paramListView.getHeaderViewsCount() - paramListView.getFirstVisiblePosition());
      if (paramqtv != null) {
        return paramqtv.getBottom() - actj.a(175.0F, paramListView.getResources());
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
  
  private Bundle a(qtv paramqtv, BaseArticleInfo paramBaseArticleInfo)
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
    if (paramqtv.jdField_f_of_type_Int == 1)
    {
      localBundle1.putString("VIDEO_PUB_ACCOUNT_UIN", paramBaseArticleInfo.mSubscribeID);
      localBundle1.putString("VIDEO_PUB_ACCOUNT_NAME", paramBaseArticleInfo.mSubscribeName);
      if (paramqtv.jdField_f_of_type_Int != 6) {
        break label1270;
      }
      localBundle1.putString("VIDEO_H5_URL", ((qdc)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda.jdField_b_of_type_JavaUtilArrayList.get(0)).h);
      localBundle1.putString("VIDEO_CREATE_TIME", ong.a(((qdc)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda.jdField_b_of_type_JavaUtilArrayList.get(0)).jdField_e_of_type_Int, true));
      localBundle1.putString("VIDEO_TIME", String.valueOf(paramqtv.jdField_b_of_type_Int));
      if (paramBaseArticleInfo.mVideoJsonWidth == 0) {
        break label1301;
      }
      localBundle1.putString("VIDEO_WIDTH", String.valueOf(paramBaseArticleInfo.mVideoJsonWidth));
      if (paramBaseArticleInfo.mVideoJsonHeight == 0) {
        break label1344;
      }
      localBundle1.putString("VIDEO_HEIGHT", String.valueOf(paramBaseArticleInfo.mVideoJsonHeight));
      localBundle1.putString("VIDEO_VID", paramqtv.jdField_c_of_type_JavaLangString);
      localBundle1.putString("VIDEO_COVER", paramqtv.jdField_b_of_type_JavaLangString);
      localBundle1.putLong("VIDEO_XG_FILE_SIZE", paramBaseArticleInfo.mXGFileSize);
      localBundle1.putInt("VIDEO_STRATEGY_ID", paramBaseArticleInfo.mStrategyId);
      localBundle1.putLong("VIDEO_ALGORITHM_ID", paramBaseArticleInfo.mAlgorithmID);
      localBundle1.putString("VIDEO_SECOND_INDEX_INNER_ID", paramqtv.jdField_n_of_type_JavaLangString);
      if ((this.jdField_a_of_type_Oyi == null) || (this.jdField_a_of_type_Oyi.a() == null) || (this.jdField_a_of_type_Qtr == null) || (this.jdField_a_of_type_Oyi.a().jdField_c_of_type_Long != paramqtv.jdField_c_of_type_Long)) {
        break label1387;
      }
      localBundle1.putLong("VIDEO_PLAY_POSITION", this.jdField_a_of_type_Qtr.a());
      if (paramqtv.jdField_f_of_type_Int != 6) {
        break label1399;
      }
      localBundle1.putString("VIDEO_ARTICLE_ID", ((qdc)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda.jdField_b_of_type_JavaUtilArrayList.get(0)).jdField_g_of_type_JavaLangString);
      localBundle1.putLong("VIDEO_FEED_ID", paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcg.jdField_a_of_type_JavaLangLong.longValue());
      localBundle1.putInt("VIDEO_FEED_TYPE", paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcg.b.intValue());
      localBundle1.putString("VIDEO_TITLE", ((qdc)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda.jdField_b_of_type_JavaUtilArrayList.get(0)).jdField_e_of_type_JavaLangString);
      localBundle1.putBoolean("IS_FROM_READINJOY_VIDEO_CHANNEL", bhvy.a(this.jdField_d_of_type_Int));
      if (paramqtv.jdField_f_of_type_Int != 1) {
        break label1426;
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
        break label1432;
      }
      i1 = 0;
      label528:
      localBundle1.putInt("interactionType", i1);
      localBundle1.putString("VIDEO_THIRD_ICON", paramqtv.jdField_d_of_type_JavaLangString);
      localBundle1.putString("VIDEO_THIRD_NAME", paramqtv.jdField_e_of_type_JavaLangString);
      localBundle1.putString("VIDEO_THIRD_ACTION", paramqtv.jdField_f_of_type_JavaLangString);
      localBundle1.putString("VIDEO_THIRD_URL", paramqtv.jdField_g_of_type_JavaLangString);
      localBundle1.putLong("VIDEO_THRID_URL_EXPIRE_TIME", paramqtv.jdField_f_of_type_Long);
      localBundle1.putInt("VIDEO_ARTICLE_BUSITYPE", paramqtv.jdField_f_of_type_Int);
      localBundle2 = new Bundle();
      localBundle2.putString("VINFO", paramqtv.jdField_c_of_type_JavaLangString);
      localBundle2.putString("TINFO", paramqtv.jdField_c_of_type_JavaLangString);
      localBundle2.putInt("PREVIEW_VIDEO_TIME", paramqtv.jdField_b_of_type_Int);
      if (this.jdField_a_of_type_Qtr != null) {
        break label1437;
      }
      i1 = 0;
      label663:
      localBundle2.putInt("PREVIEW_START_POSI", qtx.a(i1, paramqtv.jdField_b_of_type_Int));
      localBundle2.putInt("PREVIEW_VIDEO_WIDTH", paramqtv.jdField_c_of_type_Int);
      localBundle2.putInt("PREVIEW_VIDEO_HEIGHT", paramqtv.jdField_d_of_type_Int);
      localBundle2.putInt("FULL_VIDEO_TIME", paramqtv.jdField_b_of_type_Int);
      localBundle2.putString("source_puin", paramBaseArticleInfo.mSubscribeID);
      if (paramqtv.jdField_f_of_type_Int != 1) {
        break label1449;
      }
      localBundle2.putString("ACCOUNT_UIN", paramBaseArticleInfo.mSubscribeID);
      localBundle2.putString("ACCOUNT_NAME", paramBaseArticleInfo.mSubscribeName);
      label759:
      if ((paramqtv.jdField_f_of_type_Int != 6) || (paramBaseArticleInfo.mSocialFeedInfo == null) || (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda == null) || (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda.jdField_b_of_type_JavaUtilArrayList == null) || (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda.jdField_b_of_type_JavaUtilArrayList.size() <= 0)) {
        break label1476;
      }
      localBundle2.putString("compatible_text", ((qdc)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda.jdField_b_of_type_JavaUtilArrayList.get(0)).jdField_e_of_type_JavaLangString + ": " + ((qdc)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda.jdField_b_of_type_JavaUtilArrayList.get(0)).h);
      localBundle2.putInt("req_type", 125);
    }
    for (;;)
    {
      localBundle2.putInt("TYPE", paramqtv.jdField_f_of_type_Int);
      localBundle2.putString("ARTICLE_ID", paramBaseArticleInfo.innerUniqueID);
      localBundle2.putInt("layout_item", 5);
      localBundle2.putBoolean("video_url_load", false);
      localBundle2.putString("image_url_remote", paramqtv.jdField_b_of_type_JavaLangString);
      localBundle2.putString("detail_url", paramBaseArticleInfo.mArticleContentUrl + "&sourcefrom=0");
      localBundle2.putString("video_url", paramqtv.jdField_c_of_type_JavaLangString);
      localBundle2.putString("title", paramBaseArticleInfo.mTitle);
      localBundle2.putString("req_create_time", ong.a(paramBaseArticleInfo.mTime));
      localBundle2.putString("brief_key", paramBaseArticleInfo.mTitle);
      localBundle1.putByteArray("STRUCT_MSG_BYTES", ((StructMsgForGeneralShare)axva.a(localBundle2)).getBytes());
      localBundle1.putString("VIDEO_SUBS_TEXT", paramBaseArticleInfo.mVideoArticleSubsText);
      localBundle1.putString("VIDEO_SUBS_COLOR", paramBaseArticleInfo.mVideoArticleSubsColor);
      localBundle1.putString("KEY_VIDEO_JSON_LIST", paramBaseArticleInfo.mJsonVideoList);
      return localBundle1;
      if (paramqtv.jdField_f_of_type_Int == 6)
      {
        if (a((ArticleInfo)paramBaseArticleInfo)) {
          localBundle1.putString("VIDEO_PUB_ACCOUNT_UIN", "" + paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qci.jdField_a_of_type_Long);
        }
        for (;;)
        {
          localBundle1.putString("VIDEO_PUB_ACCOUNT_NAME", paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda.jdField_b_of_type_JavaLangString);
          if (q((ArticleInfo)paramBaseArticleInfo)) {
            break;
          }
          localBundle1.putString("VIDEO_URL", ((qdc)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda.jdField_b_of_type_JavaUtilArrayList.get(0)).jdField_b_of_type_JavaLangString);
          break;
          localBundle1.putString("VIDEO_PUB_ACCOUNT_UIN", "" + paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda.jdField_a_of_type_Long);
        }
      }
      localBundle1.putString("VIDEO_PUB_ACCOUNT_UIN", paramBaseArticleInfo.thirdUin);
      localBundle1.putString("VIDEO_PUB_ACCOUNT_NAME", paramBaseArticleInfo.thirdUinName);
      break;
      label1270:
      localBundle1.putString("VIDEO_H5_URL", paramBaseArticleInfo.mArticleContentUrl);
      localBundle1.putString("VIDEO_CREATE_TIME", ong.a(paramBaseArticleInfo.mTime, true));
      break label111;
      label1301:
      if (paramqtv.jdField_f_of_type_Int != 6) {
        break label148;
      }
      localBundle1.putString("VIDEO_WIDTH", String.valueOf(((qdc)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda.jdField_b_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Int));
      break label148;
      label1344:
      if (paramqtv.jdField_f_of_type_Int != 6) {
        break label170;
      }
      localBundle1.putString("VIDEO_HEIGHT", String.valueOf(((qdc)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda.jdField_b_of_type_JavaUtilArrayList.get(0)).jdField_b_of_type_Int));
      break label170;
      label1387:
      localBundle1.putLong("VIDEO_PLAY_POSITION", 0L);
      break label303;
      label1399:
      localBundle1.putString("VIDEO_ARTICLE_ID", paramBaseArticleInfo.innerUniqueID);
      localBundle1.putString("VIDEO_TITLE", paramBaseArticleInfo.mTitle);
      break label410;
      label1426:
      bool = false;
      break label436;
      label1432:
      i1 = 1;
      break label528;
      label1437:
      i1 = (int)this.jdField_a_of_type_Qtr.a();
      break label663;
      label1449:
      localBundle2.putString("ACCOUNT_UIN", paramBaseArticleInfo.thirdUin);
      localBundle2.putString("ACCOUNT_NAME", paramBaseArticleInfo.thirdUinName);
      break label759;
      label1476:
      localBundle2.putInt("req_type", 140);
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
  
  private oyi a(AbsListView paramAbsListView)
  {
    Object localObject;
    if ((!a()) || (this.jdField_a_of_type_Qkr == null) || (paramAbsListView.getChildCount() <= 0))
    {
      localObject = null;
      return localObject;
    }
    int i1 = 0;
    label27:
    if (i1 < paramAbsListView.getChildCount())
    {
      View localView = paramAbsListView.getChildAt(i1);
      if ((localView.getTag() instanceof oyi))
      {
        localObject = (oyi)localView.getTag();
        if (!((oyi)localObject).a(localView)) {}
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
  
  private pbf a(ArticleInfo paramArticleInfo, int paramInt1, int paramInt2)
  {
    b(paramInt2);
    ArticleInfo localArticleInfo = null;
    if (paramInt2 < getCount() - 1) {
      localArticleInfo = (ArticleInfo)b(paramInt2 + 1);
    }
    return new pbf(this.jdField_a_of_type_AndroidAppActivity, paramArticleInfo, paramInt1, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, paramInt2, this.jdField_c_of_type_Boolean, getCount(), localArticleInfo, this);
  }
  
  public static qtv a(BaseArticleInfo paramBaseArticleInfo)
  {
    return a(paramBaseArticleInfo, false);
  }
  
  public static qtv a(BaseArticleInfo paramBaseArticleInfo, boolean paramBoolean)
  {
    qtv localqtv = new qtv();
    localqtv.jdField_c_of_type_JavaLangString = paramBaseArticleInfo.getVideoVid();
    localqtv.jdField_c_of_type_Long = paramBaseArticleInfo.mArticleID;
    localqtv.jdField_b_of_type_Int = paramBaseArticleInfo.getVideoDuration();
    localqtv.jdField_c_of_type_Int = paramBaseArticleInfo.getVideoWidth();
    localqtv.jdField_d_of_type_Int = paramBaseArticleInfo.getVideoHeight();
    localqtv.jdField_a_of_type_Long = paramBaseArticleInfo.mXGFileSize;
    localqtv.jdField_a_of_type_JavaLangString = paramBaseArticleInfo.mTitle;
    Object localObject;
    if (paramBaseArticleInfo.getVideoCoverUrlWithSmartCut(false) == null)
    {
      localObject = null;
      localqtv.jdField_b_of_type_JavaLangString = ((String)localObject);
      localqtv.jdField_k_of_type_JavaLangString = paramBaseArticleInfo.getSubscribeUin();
      localqtv.jdField_g_of_type_Int = paramBaseArticleInfo.mStrategyId;
      localqtv.jdField_g_of_type_Long = paramBaseArticleInfo.mAlgorithmID;
      localObject = new qbu();
      ((qbu)localObject).jdField_a_of_type_JavaLangLong = Long.valueOf(paramBaseArticleInfo.mArticleID);
      ((qbu)localObject).jdField_a_of_type_JavaLangString = paramBaseArticleInfo.innerUniqueID;
      ((qbu)localObject).jdField_b_of_type_JavaLangString = paramBaseArticleInfo.getVideoVid();
      ((qbu)localObject).jdField_a_of_type_Int = paramBaseArticleInfo.busiType;
      ((qbu)localObject).jdField_i_of_type_Int = paramBaseArticleInfo.getVideoWidth();
      ((qbu)localObject).jdField_j_of_type_Int = paramBaseArticleInfo.getVideoHeight();
      ((qbu)localObject).s = paramBaseArticleInfo.getVideoDuration();
      ((qbu)localObject).jdField_n_of_type_Int = 0;
      ((qbu)localObject).o = 0;
      ((qbu)localObject).p = 0;
      ((qbu)localObject).jdField_f_of_type_Boolean = false;
      ((qbu)localObject).jdField_g_of_type_Boolean = false;
      ((qbu)localObject).jdField_h_of_type_Boolean = false;
      ((qbu)localObject).jdField_g_of_type_JavaLangString = "";
      localqtv.jdField_a_of_type_Qbu = ((qbu)localObject);
      localqtv.jdField_d_of_type_JavaLangString = paramBaseArticleInfo.thirdIcon;
      localqtv.jdField_e_of_type_JavaLangString = paramBaseArticleInfo.thirdName;
      localqtv.jdField_f_of_type_JavaLangString = paramBaseArticleInfo.thirdAction;
      localqtv.jdField_f_of_type_Int = paramBaseArticleInfo.busiType;
      localqtv.jdField_j_of_type_JavaLangString = paramBaseArticleInfo.getInnerUniqueID();
      localqtv.jdField_b_of_type_Long = paramBaseArticleInfo.mChannelID;
      localqtv.jdField_g_of_type_JavaLangString = paramBaseArticleInfo.mThirdVideoURL;
      localqtv.jdField_f_of_type_Long = paramBaseArticleInfo.mThirdVideoURLExpireTime;
      localqtv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = paramBaseArticleInfo;
      if (!paramBoolean) {
        break label402;
      }
    }
    label402:
    for (int i1 = 3;; i1 = 0)
    {
      localqtv.jdField_m_of_type_Int = i1;
      if (c((ArticleInfo)paramBaseArticleInfo) == 4) {
        localqtv.jdField_c_of_type_Boolean = true;
      }
      if ((paramBaseArticleInfo.mChannelID == 56L) && (onh.s()))
      {
        i1 = baxn.a(BaseApplicationImpl.getApplication().getApplicationContext(), 8.0F);
        localqtv.o = i1;
        localqtv.p = i1;
        localqtv.q = i1;
        localqtv.r = i1;
      }
      return localqtv;
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
    if (!bbfj.h(this.jdField_a_of_type_AndroidAppActivity)) {
      return;
    }
    ArrayList localArrayList = new ArrayList(this.jdField_b_of_type_JavaUtilList);
    ThreadManager.post(new ReadInJoyBaseAdapter.4(this, this.jdField_d_of_type_Long, localArrayList, paramInt1, paramInt2, l1), 5, null, true);
  }
  
  private void a(SparseArray<oxx> paramSparseArray)
  {
    this.jdField_a_of_type_AndroidUtilSparseArray = paramSparseArray;
    int i1 = 0;
    while (i1 < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      ((oxx)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i1)).a(this);
      i1 += 1;
    }
  }
  
  private void a(View paramView1, View paramView2)
  {
    a(paramView1, true);
    a(paramView2, false);
  }
  
  private void a(View paramView, boolean paramBoolean)
  {
    paramView.getPaddingLeft();
    int i3 = paramView.getPaddingTop();
    paramView.getPaddingRight();
    int i4 = paramView.getPaddingBottom();
    int i1;
    int i2;
    if (onh.s())
    {
      i1 = baxn.a(a(), 8.0F);
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
      i1 = baxn.a(a(), 3.0F);
      break;
      label79:
      i2 = i1 / 2;
      i1 = e();
    }
  }
  
  private void a(View paramView, boolean paramBoolean1, boolean paramBoolean2)
  {
    BaseArticleInfo localBaseArticleInfo = b(((oyl)paramView.getTag()).jdField_a_of_type_Int);
    if (localBaseArticleInfo == null) {
      return;
    }
    if (this.jdField_a_of_type_Qtr.b()) {
      this.jdField_a_of_type_Qtr.a();
    }
    if (this.jdField_a_of_type_Qum != null) {
      this.jdField_a_of_type_Qum.a(1, localBaseArticleInfo, 0L, 0L);
    }
    paramView = new Intent(a(), ReadInJoyDeliverBiuActivity.class);
    paramView.putExtra("arg_article_info", (ArticleInfo)localBaseArticleInfo);
    paramView.putExtra("biu_src", 2);
    paramView.putExtra("arg_from_type", 7);
    paramView.putExtra("fast_biu_type", paramBoolean2);
    a().startActivityForResult(paramView, 2);
    a().overridePendingTransition(0, 0);
    long l2 = 0L;
    paramView = this.jdField_a_of_type_Qtr.a();
    long l1 = l2;
    if (paramView != null)
    {
      l1 = l2;
      if (paramView.jdField_c_of_type_JavaLangString.equals(localBaseArticleInfo.mVideoVid)) {
        l1 = this.jdField_a_of_type_Qtr.a();
      }
    }
    String str1 = new qzb(null, localBaseArticleInfo.mSubscribeID, localBaseArticleInfo.mVideoVid, localBaseArticleInfo.innerUniqueID).a(l1).c(localBaseArticleInfo.mVideoDuration * 1000).e(localBaseArticleInfo.mAlgorithmID).d(localBaseArticleInfo.mStrategyId).a(this.jdField_c_of_type_Int).g(paramBoolean1).h(paramBoolean2).a().a();
    String str2 = localBaseArticleInfo.mSubscribeID;
    if (!TextUtils.isEmpty(localBaseArticleInfo.innerUniqueID))
    {
      paramView = localBaseArticleInfo.innerUniqueID;
      nol.a(null, str2, "0X8007B89", "0X8007B89", 0, 0, "1", "", paramView, str1, false);
      l2 = a().getIntent().getLongExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", 0L);
      paramView = new qca();
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
      npu.a(localBaseArticleInfo, this.jdField_c_of_type_Int, 25, -1L, paramView);
      return;
      paramView = "0";
      break;
    }
  }
  
  public static void a(ArticleInfo paramArticleInfo, int paramInt)
  {
    String str = shu.b(paramInt);
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
    if ((a(paramArticleInfo)) || (i(paramArticleInfo)) || (j(paramArticleInfo)) || (k(paramArticleInfo)))
    {
      if ((paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda == null)) {
        break label273;
      }
      str1 = Long.toString(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda.jdField_a_of_type_Long);
      l1 = 0L;
    }
    for (;;)
    {
      label77:
      String str3 = onh.a(paramInt2, paramInt1, null, onh.a(paramArticleInfo), paramArticleInfo.innerUniqueID, onh.c(paramArticleInfo), paramArticleInfo);
      if (shu.a(paramArticleInfo.mChannelID)) {}
      for (String str2 = "0X8009363";; str2 = "0X8008899")
      {
        nol.a(null, "CliOper", "", str1, str2, str2, 0, 0, Long.toString(l2), Long.toString(l1), "" + paramArticleInfo.mStrategyId, str3, false);
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
    if ((a(paramArticleInfo)) || (i(paramArticleInfo)) || (j(paramArticleInfo)) || (k(paramArticleInfo)))
    {
      l1 = l2;
      str1 = str2;
      if (paramArticleInfo.mSocialFeedInfo == null) {
        break label376;
      }
      l1 = l2;
      str1 = str2;
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda == null) {
        break label376;
      }
      str2 = Long.toString(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda.jdField_a_of_type_Long);
      l1 = l2;
      str1 = str2;
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda.jdField_a_of_type_JavaUtilArrayList == null) {
        break label376;
      }
      paramInt = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda.jdField_a_of_type_JavaUtilArrayList.size();
      l1 = 0L;
      str1 = str2;
    }
    for (;;)
    {
      paramString = onh.a(paramInt, i2, paramString, onh.a(paramArticleInfo), paramArticleInfo.innerUniqueID, paramArticleInfo);
      str2 = onh.a(paramInt, i2, null, onh.a(paramArticleInfo), paramArticleInfo.innerUniqueID, onh.c(paramArticleInfo), paramArticleInfo);
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
        if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcv != null)
        {
          l1 = l2;
          str1 = str2;
          if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcv.jdField_a_of_type_JavaUtilArrayList != null)
          {
            paramInt = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcv.jdField_a_of_type_JavaUtilArrayList.size();
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
    Object localObject = onh.c(paramArticleInfo);
    if (paramArticleInfo.hasChannelInfo()) {
      int i1 = paramArticleInfo.mChannelInfoId;
    }
    if (TextUtils.isEmpty(paramArticleInfo.mArticleFriendLikeText)) {}
    try
    {
      localObject = onh.a(paramArticleInfo.mAlgorithmID, onh.a(paramArticleInfo), paramInt, bbfj.h(null), (String)localObject, paramArticleInfo.innerUniqueID, onh.e(paramArticleInfo), 0, onh.d(), paramArticleInfo);
      if ((paramMap != null) && (paramMap.entrySet() != null))
      {
        paramMap = paramMap.entrySet().iterator();
        while ((paramMap != null) && (paramMap.hasNext()))
        {
          Map.Entry localEntry = (Map.Entry)paramMap.next();
          ((JSONObject)localObject).put((String)localEntry.getKey(), localEntry.getValue().toString());
          continue;
          nol.a(null, onh.c(paramArticleInfo), paramString1, paramString2, 0, 0, a(paramArticleInfo.mFeedId), String.valueOf(paramArticleInfo.businessId), Integer.toString(paramArticleInfo.mStrategyId), paramMap, false);
        }
      }
    }
    catch (Exception paramMap)
    {
      actj.a("ReadInJoyBaseAdapter", "reportClickEvent", new IllegalArgumentException(paramMap));
      paramMap = null;
    }
    for (;;)
    {
      shy.a(paramArticleInfo, paramInt);
      return;
      paramMap = ((JSONObject)localObject).toString();
    }
  }
  
  private void a(BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    if ((paramBaseArticleInfo != null) && (paramBaseArticleInfo.feedsFirstExposurePos == -1)) {
      paramBaseArticleInfo.feedsFirstExposurePos = paramInt;
    }
  }
  
  private void a(BaseArticleInfo paramBaseArticleInfo, TextView paramTextView1, View paramView, TextView paramTextView2, KandianUrlImageView paramKandianUrlImageView)
  {
    int i1 = bhvy.d();
    boolean bool2 = bhvy.p();
    paramTextView1.setMaxLines(i1);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramTextView1.getLayoutParams();
    float f1;
    boolean bool1;
    if (bool2)
    {
      f1 = 5.0F;
      localLayoutParams.bottomMargin = actj.a(f1, this.jdField_a_of_type_AndroidAppActivity.getResources());
      if (bool2) {
        break label186;
      }
      bool1 = true;
      label60:
      localLayoutParams.alignWithParent = bool1;
      paramTextView1.setLayoutParams(localLayoutParams);
      if (paramView != null) {
        if (!bool2) {
          break label192;
        }
      }
    }
    label186:
    label192:
    for (i1 = 0;; i1 = 8)
    {
      paramView.setVisibility(i1);
      if (!paramBaseArticleInfo.hasFamilyCommentIcon()) {
        break label211;
      }
      try
      {
        paramTextView1 = new URL(paramBaseArticleInfo.familyCommentInfo.jdField_a_of_type_JavaLangString);
        if (paramBaseArticleInfo.familyCommentInfo.jdField_b_of_type_Int > 0) {
          a(paramKandianUrlImageView, paramTextView1, paramBaseArticleInfo.familyCommentInfo.jdField_a_of_type_Int, paramBaseArticleInfo.familyCommentInfo.jdField_b_of_type_Int);
        }
        paramKandianUrlImageView.setOnClickListener(new rao(this, paramBaseArticleInfo.familyCommentInfo.jdField_b_of_type_JavaLangString));
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
    label211:
    QLog.d("ReadInJoyBaseAdapter", 2, "innerConfigTwoItemVideoUI setCommentCountText");
    paramKandianUrlImageView.setVisibility(8);
    paramTextView2.setVisibility(0);
    qoi.a(paramTextView2, paramBaseArticleInfo.getCommentCount(), ajya.a(2131712932), "0");
  }
  
  private void a(KandianUrlImageView paramKandianUrlImageView, ImageView paramImageView, BaseArticleInfo paramBaseArticleInfo, boolean paramBoolean)
  {
    boolean bool;
    URL localURL;
    if ((paramBaseArticleInfo.isUseGif) && (bbfj.h(this.jdField_a_of_type_AndroidAppActivity)))
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
    omr.a(paramKandianUrlImageView, paramURL, this.jdField_a_of_type_AndroidAppActivity, paramBoolean);
  }
  
  private void a(ReadInJoyHeadImageView paramReadInJoyHeadImageView, BaseArticleInfo paramBaseArticleInfo)
  {
    Object localObject = null;
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = bbef.b();
    }
    if ((onh.w(paramBaseArticleInfo)) || ((paramBaseArticleInfo.busiType == 1) && (!AdvertisementInfo.isAdvertisementInfo(paramBaseArticleInfo))))
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
          paramBaseArticleInfo = new URL("http://post.mp.qq.com/kan/video/201197226-1955dc60def689ah-j0032zp3bhx.html?_wv=2281701505&sig=2556997e505f84ff05decf79e0d001af&time=1573267470&iid=MzczOTc1NDQ5OQ==&sourcefrom=0");
          break label329;
        }
        paramBaseArticleInfo = new URL(paramBaseArticleInfo.thirdIcon);
        break label329;
      }
      paramBaseArticleInfo = URLDrawable.getDrawable(paramBaseArticleInfo, localURLDrawableOptions);
      paramBaseArticleInfo.setDecodeHandler(bavw.a);
      paramReadInJoyHeadImageView.setImageDrawable(paramBaseArticleInfo);
      paramReadInJoyHeadImageView.setVisibility(0);
      return;
    }
  }
  
  private void a(ReadInJoyNickNameTextView paramReadInJoyNickNameTextView, BaseArticleInfo paramBaseArticleInfo, boolean paramBoolean)
  {
    if (onh.w(paramBaseArticleInfo))
    {
      paramReadInJoyNickNameTextView.setNickNameByUin(paramBaseArticleInfo.getSubscribeUin());
      return;
    }
    if (paramBoolean)
    {
      paramReadInJoyNickNameTextView.setText(oar.a(paramBaseArticleInfo));
      return;
    }
    paramReadInJoyNickNameTextView.setText(omr.a(paramBaseArticleInfo.getSubscribeName(), 18));
  }
  
  private void a(RoundAngleFrameLayout paramRoundAngleFrameLayout)
  {
    if (onh.s())
    {
      paramRoundAngleFrameLayout.setRaduis(28);
      return;
    }
    paramRoundAngleFrameLayout.setRaduis(0);
  }
  
  private void a(AbsListView paramAbsListView)
  {
    if (paramAbsListView.getFirstVisiblePosition() == 0)
    {
      this.jdField_m_of_type_Int = 0;
      return;
    }
    ThreadManager.post(new ReadInJoyBaseAdapter.25(this, paramAbsListView), 8, null, true);
  }
  
  private void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramString = omj.jdField_k_of_type_JavaLangString + bbco.encodeToString(String.valueOf(paramString).getBytes(), 2);
    onh.a(a(), paramString);
  }
  
  private void a(oyl paramoyl)
  {
    if (paramoyl == null) {
      return;
    }
    paramoyl.jdField_e_of_type_AndroidWidgetImageView.setOnClickListener(this);
    paramoyl.i.setOnClickListener(this);
    paramoyl.h.setOnClickListener(this);
    paramoyl.h.setTag(paramoyl);
    paramoyl.i.setTag(paramoyl);
    paramoyl.jdField_e_of_type_AndroidWidgetImageView.setTag(paramoyl);
  }
  
  public static void a(oyl paramoyl, BaseArticleInfo paramBaseArticleInfo)
  {
    qtv localqtv = a(paramBaseArticleInfo);
    localqtv.jdField_a_of_type_AndroidViewView = paramoyl.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
    localqtv.jdField_a_of_type_Int = paramoyl.jdField_a_of_type_Int;
    localqtv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = paramBaseArticleInfo;
    paramoyl.jdField_a_of_type_Qtv = localqtv;
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    oxx localoxx = a(0);
    if ((localoxx instanceof oye)) {
      return ((oye)localoxx).a(paramInt2, paramInt1);
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
  
  private boolean a(AbsListView paramAbsListView)
  {
    float f1 = paramAbsListView.getFlingVelocity();
    float f2 = (float)bbdh.j();
    return (f1 > 0.0F) && (f1 > f2 * 1.0F);
  }
  
  public static int b(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo == null) || (paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda == null))
    {
      QLog.d("ReadInJoyBaseAdapter", 1, "getTopicRecommendAndUpdateUGCType ugc feeds info is null. article info is: " + paramArticleInfo);
      return 54;
    }
    switch (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda.jdField_a_of_type_Int)
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
  
  private Bundle b(qtv paramqtv, BaseArticleInfo paramBaseArticleInfo)
  {
    Object localObject1 = null;
    Object localObject3;
    Object localObject2;
    if ((onh.n(paramBaseArticleInfo)) && (paramqtv != null))
    {
      localObject3 = paramBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject2 = (qbo)((Iterator)localObject3).next();
        if ((((qbo)localObject2).jdField_a_of_type_Qbr == null) || (!TextUtils.equals(paramqtv.jdField_c_of_type_JavaLangString, ((qbo)localObject2).jdField_a_of_type_Qbr.jdField_a_of_type_JavaLangString))) {
          break label989;
        }
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = (qbo)paramBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.get(0);
      }
      localObject1 = new Bundle();
      label392:
      boolean bool;
      if (((qbo)localObject2).jdField_a_of_type_Boolean)
      {
        ((Bundle)localObject1).putString("VIDEO_PUB_ACCOUNT_UIN", "" + paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qci.jdField_a_of_type_Long);
        ((Bundle)localObject1).putString("VIDEO_H5_URL", ((qbo)localObject2).jdField_a_of_type_Qbr.jdField_c_of_type_JavaLangString);
        ((Bundle)localObject1).putLong("VIDEO_FEED_ID", ((qbo)localObject2).jdField_c_of_type_Long);
        ((Bundle)localObject1).putInt("VIDEO_FEED_TYPE", ((qbo)localObject2).jdField_b_of_type_Int);
        if (((qbo)localObject2).jdField_a_of_type_Qbr != null) {}
        ((Bundle)localObject1).putString("VIDEO_TIME", String.valueOf(paramqtv.jdField_b_of_type_Int));
        ((Bundle)localObject1).putString("VIDEO_WIDTH", String.valueOf(paramqtv.jdField_c_of_type_Int));
        ((Bundle)localObject1).putString("VIDEO_HEIGHT", String.valueOf(paramqtv.jdField_d_of_type_Int));
        ((Bundle)localObject1).putString("VIDEO_VID", paramqtv.jdField_c_of_type_JavaLangString);
        ((Bundle)localObject1).putString("VIDEO_COVER", paramqtv.jdField_b_of_type_JavaLangString);
        ((Bundle)localObject1).putLong("VIDEO_XG_FILE_SIZE", paramBaseArticleInfo.mXGFileSize);
        ((Bundle)localObject1).putInt("VIDEO_STRATEGY_ID", paramqtv.jdField_g_of_type_Int);
        ((Bundle)localObject1).putLong("VIDEO_ALGORITHM_ID", paramqtv.jdField_g_of_type_Long);
        ((Bundle)localObject1).putString("VIDEO_SECOND_INDEX_INNER_ID", paramqtv.jdField_n_of_type_JavaLangString);
        if ((this.jdField_a_of_type_Oyi == null) || (this.jdField_a_of_type_Oyi.a() == null) || (this.jdField_a_of_type_Qtr == null) || (this.jdField_a_of_type_Oyi.a().jdField_c_of_type_Long != paramqtv.jdField_c_of_type_Long)) {
          break label959;
        }
        ((Bundle)localObject1).putLong("VIDEO_PLAY_POSITION", this.jdField_a_of_type_Qtr.a());
        ((Bundle)localObject1).putString("VIDEO_ARTICLE_ID", ((qbo)localObject2).jdField_g_of_type_JavaLangString);
        ((Bundle)localObject1).putString("VIDEO_TITLE", ((qbo)localObject2).jdField_a_of_type_JavaLangString);
        ((Bundle)localObject1).putBoolean("IS_FROM_READINJOY_VIDEO_CHANNEL", bhvy.a(this.jdField_d_of_type_Int));
        if (paramqtv.jdField_f_of_type_Int != 1) {
          break label971;
        }
        bool = true;
        label444:
        ((Bundle)localObject1).putBoolean("VIDEO_IS_FROM_PUBLIC_ACCOUNT", bool);
        ((Bundle)localObject1).putBoolean("isFromKandian", true);
        ((Bundle)localObject1).putLong("channelID", paramBaseArticleInfo.mChannelID);
        ((Bundle)localObject1).putLong("algorithmID", ((qbo)localObject2).jdField_b_of_type_Long);
        ((Bundle)localObject1).putString("innderId", ((qbo)localObject2).jdField_g_of_type_JavaLangString);
        ((Bundle)localObject1).putLong("strategyId", ((qbo)localObject2).jdField_a_of_type_Int);
        ((Bundle)localObject1).putString("VIDEO_THIRD_ICON", paramqtv.jdField_d_of_type_JavaLangString);
        ((Bundle)localObject1).putString("VIDEO_THIRD_NAME", paramqtv.jdField_e_of_type_JavaLangString);
        ((Bundle)localObject1).putString("VIDEO_THIRD_ACTION", paramqtv.jdField_f_of_type_JavaLangString);
        ((Bundle)localObject1).putString("VIDEO_THIRD_URL", paramqtv.jdField_g_of_type_JavaLangString);
        ((Bundle)localObject1).putLong("VIDEO_THRID_URL_EXPIRE_TIME", paramqtv.jdField_f_of_type_Long);
        ((Bundle)localObject1).putInt("VIDEO_ARTICLE_BUSITYPE", paramqtv.jdField_f_of_type_Int);
        localObject3 = new Bundle();
        ((Bundle)localObject3).putString("VINFO", paramqtv.jdField_c_of_type_JavaLangString);
        ((Bundle)localObject3).putString("TINFO", paramqtv.jdField_c_of_type_JavaLangString);
        ((Bundle)localObject3).putInt("PREVIEW_VIDEO_TIME", paramqtv.jdField_b_of_type_Int);
        if (this.jdField_a_of_type_Qtr != null) {
          break label977;
        }
      }
      label959:
      label971:
      label977:
      for (int i1 = 0;; i1 = (int)this.jdField_a_of_type_Qtr.a())
      {
        ((Bundle)localObject3).putInt("PREVIEW_START_POSI", qtx.a(i1, paramqtv.jdField_b_of_type_Int));
        ((Bundle)localObject3).putInt("PREVIEW_VIDEO_WIDTH", paramqtv.jdField_c_of_type_Int);
        ((Bundle)localObject3).putInt("PREVIEW_VIDEO_HEIGHT", paramqtv.jdField_d_of_type_Int);
        ((Bundle)localObject3).putInt("FULL_VIDEO_TIME", paramqtv.jdField_b_of_type_Int);
        ((Bundle)localObject3).putString("source_puin", ((qbo)localObject2).jdField_e_of_type_JavaLangString);
        ((Bundle)localObject3).putString("ACCOUNT_UIN", ((qbo)localObject2).jdField_e_of_type_JavaLangString);
        ((Bundle)localObject3).putString("ACCOUNT_NAME", ((qbo)localObject2).jdField_f_of_type_JavaLangString);
        ((Bundle)localObject3).putInt("TYPE", paramqtv.jdField_f_of_type_Int);
        ((Bundle)localObject3).putString("ARTICLE_ID", ((qbo)localObject2).jdField_g_of_type_JavaLangString);
        ((Bundle)localObject3).putInt("layout_item", 5);
        ((Bundle)localObject3).putBoolean("video_url_load", false);
        ((Bundle)localObject3).putString("image_url_remote", paramqtv.jdField_b_of_type_JavaLangString);
        ((Bundle)localObject3).putString("detail_url", ((qbo)localObject2).jdField_d_of_type_JavaLangString + "&sourcefrom=0");
        ((Bundle)localObject3).putString("video_url", paramqtv.jdField_c_of_type_JavaLangString);
        ((Bundle)localObject3).putString("title", ((qbo)localObject2).jdField_a_of_type_JavaLangString);
        ((Bundle)localObject3).putString("req_create_time", ong.a(paramBaseArticleInfo.mTime));
        ((Bundle)localObject3).putString("brief_key", ((qbo)localObject2).jdField_a_of_type_JavaLangString);
        ((Bundle)localObject3).putInt("req_type", 140);
        ((Bundle)localObject1).putByteArray("STRUCT_MSG_BYTES", ((StructMsgForGeneralShare)axva.a((Bundle)localObject3)).getBytes());
        ((Bundle)localObject1).putString("KEY_VIDEO_JSON_LIST", paramBaseArticleInfo.mJsonVideoList);
        return localObject1;
        ((Bundle)localObject1).putString("VIDEO_PUB_ACCOUNT_UIN", ((qbo)localObject2).jdField_e_of_type_JavaLangString);
        ((Bundle)localObject1).putString("VIDEO_PUB_ACCOUNT_NAME", ((qbo)localObject2).jdField_f_of_type_JavaLangString);
        ((Bundle)localObject1).putString("VIDEO_H5_URL", ((qbo)localObject2).jdField_d_of_type_JavaLangString);
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
      QQAppInterface localQQAppInterface = (QQAppInterface)onh.a();
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
      str1 = onh.c(paramArticleInfo);
      str2 = onh.a(paramArticleInfo.mAlgorithmID, onh.a(paramArticleInfo), paramInt, i1, i2, bbfj.h(null), str1, paramArticleInfo.mStrCircleId, paramArticleInfo.innerUniqueID, onh.e(paramArticleInfo), paramArticleInfo);
      if ((!a(paramArticleInfo)) && (!i(paramArticleInfo)) && (!j(paramArticleInfo)) && (!k(paramArticleInfo))) {
        break label243;
      }
      if ((paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda == null)) {
        break label252;
      }
      str1 = Long.toString(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda.jdField_a_of_type_Long);
    }
    for (;;)
    {
      String str3 = shu.b(paramInt);
      nol.a(null, "CliOper", "", str1, str3, str3, 0, 0, Long.toString(paramArticleInfo.mFeedId), Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), str2, false);
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
    oyi localoyi = a(paramAbsListView);
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 4, "playVideoInArea:" + localoyi);
    }
    qtv localqtv;
    if (localoyi != null)
    {
      paramAbsListView = localoyi.a();
      localqtv = this.jdField_a_of_type_Qtr.a();
      if (paramAbsListView == this.jdField_a_of_type_Qtr.jdField_a_of_type_Qtv) {
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
        } while ((localqtv != null) && (localqtv.jdField_c_of_type_Long == paramAbsListView.jdField_c_of_type_Long) && (localqtv.jdField_b_of_type_Long == this.jdField_c_of_type_Int) && (!this.jdField_a_of_type_Qtr.d()) && (!this.jdField_a_of_type_Qtr.e()));
        qvk.a().b();
        a(localoyi);
      } while (!QLog.isColorLevel());
      QLog.d("Q.readinjoy.video", 2, "checkPlayableArea vid: " + paramAbsListView.jdField_c_of_type_JavaLangString);
      return;
      m();
    } while (this.jdField_a_of_type_Qtr.a() == null);
    this.jdField_a_of_type_Qtr.a().a(paramAbsListView);
  }
  
  private static void b(qao paramqao)
  {
    int i1 = 0;
    if (onh.j(paramqao.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo)) {
      paramqao.jdField_b_of_type_Boolean = true;
    }
    while (paramqao.jdField_b_of_type_Boolean) {
      return;
    }
    paramqao.jdField_b_of_type_Boolean = true;
    ArrayList localArrayList = new ArrayList();
    ReportInfo localReportInfo = new ReportInfo();
    localReportInfo.mUin = onh.a();
    localReportInfo.mSource = 0;
    localReportInfo.mSourceArticleId = paramqao.jdField_a_of_type_JavaLangLong.longValue();
    if (paramqao.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null) {
      i1 = (int)paramqao.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mChannelID;
    }
    localReportInfo.mChannelId = i1;
    localReportInfo.mAlgorithmId = ((int)paramqao.jdField_a_of_type_Long);
    localReportInfo.mStrategyId = paramqao.jdField_b_of_type_Int;
    localReportInfo.mOperation = 7;
    localReportInfo.mServerContext = paramqao.jdField_a_of_type_ArrayOfByte;
    localReportInfo.mReadTimeLength = -1;
    localReportInfo.mInnerId = paramqao.jdField_e_of_type_JavaLangString;
    if ((paramqao.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null) && (paramqao.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoColumnInfo != null)) {
      localReportInfo.mColumnID = paramqao.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_Int;
    }
    if ((paramqao.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null) && (paramqao.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo != null) && (!onh.l(paramqao.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo)))
    {
      qbz localqbz = new qbz();
      localqbz.jdField_a_of_type_Long = paramqao.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Long;
      if (paramqao.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qci != null) {
        localqbz.jdField_b_of_type_Long = paramqao.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qci.jdField_a_of_type_Long;
      }
      localqbz.jdField_a_of_type_Int = paramqao.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_b_of_type_Int;
      localqbz.jdField_b_of_type_Int = paramqao.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_d_of_type_Int;
      Object localObject = paramqao.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_JavaUtilList;
      if ((localObject != null) && (!((List)localObject).isEmpty()))
      {
        localqbz.jdField_a_of_type_JavaUtilList = new ArrayList();
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          qci localqci = (qci)((Iterator)localObject).next();
          if (localqci != null) {
            localqbz.jdField_a_of_type_JavaUtilList.add(Long.valueOf(localqci.jdField_a_of_type_Long));
          }
        }
      }
      localReportInfo.mFeedsReportData = localqbz;
    }
    if ((paramqao.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null) && (oou.c((int)paramqao.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mChannelID)))
    {
      localReportInfo.mSearchTagName = paramqao.jdField_f_of_type_JavaLangString;
      olj.a(localReportInfo);
      return;
    }
    localArrayList.add(localReportInfo);
    QLog.d("ReadInJoyBaseAdapter", 2, "report0x64eExposureInfo: article " + localReportInfo.mSourceArticleId + " exposed!");
    osg.a().a(localArrayList);
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
    switch (paramArticleInfo.mResolvedFeedType)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static boolean b(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo.mFeedType == 1) && (paramBaseArticleInfo.mSocialFeedInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcg != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcg.b != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcg.b.longValue() == 11L);
  }
  
  public static int c(ArticleInfo paramArticleInfo)
  {
    return a(paramArticleInfo, 0);
  }
  
  private void c(List<BaseArticleInfo> paramList)
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
  
  private boolean c()
  {
    boolean bool2 = false;
    ArticleInfo localArticleInfo = a();
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Qtv == null)
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
    return (paramBaseArticleInfo.mFeedType == 11) && (paramBaseArticleInfo.mTopicRecommendFeedsInfo != null) && (paramBaseArticleInfo.mTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList != null);
  }
  
  private boolean d()
  {
    if (!bhvy.a(this.jdField_d_of_type_Int)) {}
    String str;
    do
    {
      do
      {
        do
        {
          return false;
        } while (!bbfj.g(this.jdField_a_of_type_AndroidAppActivity));
        str = onh.a(this.jdField_c_of_type_Long);
      } while (onh.jdField_d_of_type_JavaLangString.equals(str));
      if (onh.jdField_b_of_type_JavaLangString.equals(str)) {
        return true;
      }
    } while (!onh.jdField_c_of_type_JavaLangString.equals(str));
    return qkr.a(this.jdField_a_of_type_AndroidAppActivity);
  }
  
  public static boolean d(ArticleInfo paramArticleInfo)
  {
    if ((!f(paramArticleInfo)) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcg == null)) {
      return false;
    }
    switch (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcg.b.intValue())
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static boolean d(BaseArticleInfo paramBaseArticleInfo)
  {
    return ((paramBaseArticleInfo instanceof ArticleInfo)) && (q((ArticleInfo)paramBaseArticleInfo));
  }
  
  private int e()
  {
    if (onh.s()) {
      return baxn.a(a(), 14.0F);
    }
    return baxn.a(a(), 6.0F);
  }
  
  public static boolean e(ArticleInfo paramArticleInfo)
  {
    return (f(paramArticleInfo)) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcg != null);
  }
  
  public static boolean e(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo.mFeedType != 30) && ((paramBaseArticleInfo.mSocialFeedInfo == null) || (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda == null) || (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda.c.isEmpty()));
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
    return (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qdq == null) || (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qdq.jdField_a_of_type_JavaUtilArrayList == null) || (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qdq.jdField_a_of_type_JavaUtilArrayList.isEmpty());
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
  
  public static boolean h(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {}
    while (paramArticleInfo.mFeedType != 10) {
      return false;
    }
    return true;
  }
  
  public static boolean i(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo == null) || (paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcg == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcg.b == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda == null)) {
      return false;
    }
    switch (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcg.b.intValue())
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static boolean j(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {}
    while ((paramArticleInfo.mFeedType != 18) && (paramArticleInfo.mFeedType != 19)) {
      return false;
    }
    return true;
  }
  
  public static boolean k(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo == null) || (paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcg == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda == null)) {
      return false;
    }
    switch (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcg.b.intValue())
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static boolean l(ArticleInfo paramArticleInfo)
  {
    return (k(paramArticleInfo)) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda.jdField_a_of_type_Int == 1);
  }
  
  public static boolean m(ArticleInfo paramArticleInfo)
  {
    return (i(paramArticleInfo)) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda.jdField_a_of_type_Int == 1);
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
    return (paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda == null);
  }
  
  private void p()
  {
    if ((a() instanceof ReadInJoyChannelActivity))
    {
      this.jdField_g_of_type_Boolean = a().getIntent().getBooleanExtra("is_need_show_animation_translate", false);
      this.jdField_d_of_type_Boolean = a().getIntent().getBooleanExtra("is_need_show_animation_adapter", false);
    }
    this.jdField_a_of_type_AndroidViewAnimationAnimationSet = ((AnimationSet)AnimationUtils.loadAnimation(this.jdField_a_of_type_AndroidAppActivity, 2130772066));
    if (!qoi.b()) {
      this.jdField_a_of_type_AndroidViewAnimationAnimationSet.setDuration(400L);
    }
    if (this.jdField_c_of_type_Int == 56)
    {
      qkt.a().a(true);
      qkt.a().a(0);
    }
    AppNetConnInfo.registerConnectionChangeReceiver(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
  }
  
  public static boolean p(ArticleInfo paramArticleInfo)
  {
    return (paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda.jdField_a_of_type_JavaUtilArrayList.size() == 0);
  }
  
  private void q()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyBaseAdapter", 2, "cpu:" + bbdh.b() + " mem:" + bbdh.d() + " fre:" + bbdh.a());
    }
    int i1 = bbdh.b();
    long l1 = bbdh.d();
    if ((i1 >= 4) && (l1 >= 1610612736.0D))
    {
      jdField_j_of_type_Int = 6;
      return;
    }
    jdField_j_of_type_Int = 4;
  }
  
  public static boolean q(ArticleInfo paramArticleInfo)
  {
    return (paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda.jdField_b_of_type_JavaUtilArrayList.size() == 0);
  }
  
  private void r()
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
          a(localArticleInfo, new pbf(this.jdField_a_of_type_AndroidAppActivity, localArticleInfo, getItemViewType(i4), this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, i4, this.jdField_c_of_type_Boolean, getCount(), null, this), System.currentTimeMillis(), i4);
        }
      }
    }
  }
  
  private void s()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyBaseAdapter", 2, "prefetch data");
    }
    if (this.jdField_a_of_type_Rbs != null) {
      this.jdField_a_of_type_Rbs.a();
    }
  }
  
  private void t()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a(this.jdField_a_of_type_Bfos);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a(this.jdField_b_of_type_Bfos);
  }
  
  private void u()
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
  
  private void v()
  {
    if (!bbfj.h(this.jdField_a_of_type_AndroidAppActivity)) {}
    try
    {
      Object localObject = this.jdField_a_of_type_Qtr.a();
      long l1 = ((qtv)localObject).jdField_c_of_type_Long;
      localObject = b(((qtv)localObject).jdField_a_of_type_Int);
      if ((localObject != null) && (l1 != ((BaseArticleInfo)localObject).mArticleID))
      {
        this.jdField_a_of_type_Qtr.b(12);
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
  
  private void w()
  {
    if (this.jdField_a_of_type_Qtr != null) {
      this.jdField_a_of_type_Qtr.b();
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
    if (this.jdField_a_of_type_Qtr != null) {
      l1 = this.jdField_a_of_type_Qtr.a();
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
      this.jdField_b_of_type_AndroidViewAnimationAnimationSet = ((AnimationSet)AnimationUtils.loadAnimation(this.jdField_a_of_type_AndroidAppActivity, 2130772055));
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
  
  public baxy a()
  {
    return null;
  }
  
  public bfst a()
  {
    if (this.jdField_a_of_type_Bfst == null) {
      this.jdField_a_of_type_Bfst = new bfst(this.jdField_a_of_type_AndroidAppActivity);
    }
    return this.jdField_a_of_type_Bfst;
  }
  
  public bfsz a()
  {
    if (this.jdField_a_of_type_Bfsz == null) {
      this.jdField_a_of_type_Bfsz = new bfsz(this.jdField_a_of_type_AndroidAppActivity);
    }
    return this.jdField_a_of_type_Bfsz;
  }
  
  public ArticleInfo a()
  {
    long l1 = a().getIntent().getLongExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_SEQ", 0L);
    ArticleInfo localArticleInfo2 = osg.a().a(0, l1);
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
  
  public nlu a()
  {
    return this.jdField_a_of_type_Nlu;
  }
  
  public oag a()
  {
    return this.jdField_a_of_type_Oag;
  }
  
  public oxx a(int paramInt)
  {
    return (oxx)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
  }
  
  public oyl a(String paramString)
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
        return (oyl)paramString.getTag();
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
  
  public pjn a()
  {
    return jdField_a_of_type_Pjn;
  }
  
  public qki a()
  {
    return this.jdField_a_of_type_Qki;
  }
  
  public qtr a()
  {
    return this.jdField_a_of_type_Qtr;
  }
  
  public rbo a()
  {
    return this.jdField_a_of_type_Rbo;
  }
  
  public rbp a()
  {
    return this.jdField_a_of_type_Rbp;
  }
  
  public rbq a()
  {
    return this.jdField_a_of_type_Rbq;
  }
  
  public rbr a()
  {
    return this.jdField_a_of_type_Rbr;
  }
  
  public rsj a()
  {
    if (this.jdField_a_of_type_Rsj == null) {
      this.jdField_a_of_type_Rsj = new rsj(this.jdField_a_of_type_AndroidAppActivity, this);
    }
    return this.jdField_a_of_type_Rsj;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyBaseAdapter", 2, "clearData " + this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    }
    this.n = true;
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.b();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    this.jdField_a_of_type_Bfst = null;
    this.jdField_a_of_type_Bfsz = null;
    if (this.jdField_c_of_type_Int == 56) {
      qkt.a().a();
    }
    if (this.jdField_a_of_type_Quo != null) {
      this.jdField_a_of_type_Quo.a();
    }
    if (this.jdField_a_of_type_Sds != null) {
      this.jdField_a_of_type_Sds.a();
    }
    this.jdField_a_of_type_Sds = null;
    odk.b();
    if (this.jdField_a_of_type_Qki != null) {
      this.jdField_a_of_type_Qki.c();
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
          localObject1 = (qzz)((Container)localObject1).getTag(2131374808);
          if ((localObject1 == null) || (!((qzz)localObject1).a())) {}
        }
      }
    }
    for (;;)
    {
      paramInt1 = paramInt2;
      if (localObject1 != null)
      {
        ((qzz)localObject1).a();
        paramInt1 = paramInt2;
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
              localObject2 = (qzz)((Container)localObject2).getTag(2131374808);
              if ((localObject2 != null) && (localObject2 != localObject1)) {
                ((qzz)localObject2).b();
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
    if (this.jdField_a_of_type_Qtr == null) {}
    long l1;
    int i1;
    qtv localqtv;
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
        if ((!this.jdField_a_of_type_Qtr.d()) || (!this.jdField_a_of_type_Qtr.c())) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("Q.readinjoy.video", 2, "onActivityResult video is pause  && isPausedByMannul, just return");
      return;
      localqtv = this.jdField_a_of_type_Qtr.a();
      if (localqtv != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.readinjoy.video", 2, "onActivityResult getCurrentPlayVideoParam = null, just return");
    return;
    if (qnl.a().a())
    {
      this.jdField_a_of_type_Qtr.b(4);
      return;
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramIntent != null)
    {
      localObject1 = localObject2;
      if (paramIntent.getExtras() != null) {
        localObject1 = paramIntent.getExtras().getString("VIDEO_ARTICLE_ID");
      }
    }
    if (!TextUtils.equals(localqtv.jdField_j_of_type_JavaLangString, (CharSequence)localObject1))
    {
      paramIntent = b((String)localObject1);
      if (paramIntent == null)
      {
        l1 = localqtv.jdField_d_of_type_Long;
        paramInt = 0;
      }
    }
    for (;;)
    {
      label255:
      boolean bool;
      if ((i1 == 3) || (i1 == 0) || (i1 == 4))
      {
        bool = true;
        label272:
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video", 2, "onActivityResult shouldContinuePlay = " + bool + ", playState=" + qtx.a(i1) + ", startPosition=" + l1 + "，curPlayParam=" + localqtv);
        }
        if (!bool) {
          break label548;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video", 2, "onActivityResult continue play");
        }
        if (paramInt == 0) {
          break label460;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video", 2, "onActivityResult resume playResumeVideo:" + (String)localObject1);
        }
        a(paramIntent);
      }
      for (;;)
      {
        qvk.a().a(false, "readinoy video continuePlay", 1);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.readinjoy.video", 2, "volumeControl set mute shouldContinuePlay");
        return;
        if (paramIntent.jdField_a_of_type_Qtv != null) {
          paramIntent.jdField_a_of_type_Qtv.jdField_d_of_type_Long = l1;
        }
        paramInt = 1;
        break label255;
        bool = false;
        break label272;
        label460:
        if ((l1 >= 0L) && (localqtv != null))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.readinjoy.video", 2, "onActivityResult resume with position:" + l1);
          }
          this.jdField_a_of_type_Qtr.a((int)l1, localqtv);
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.readinjoy.video", 2, "onActivityResult resume");
          }
          this.jdField_a_of_type_Qtr.f(true);
        }
      }
      label548:
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "onActivityResult stop");
      }
      if (this.jdField_a_of_type_Oyi == null) {
        break;
      }
      long l2 = this.jdField_a_of_type_Qtr.a();
      this.jdField_a_of_type_Qtr.b(4);
      paramIntent = this.jdField_a_of_type_Oyi.a();
      if (l1 > 0L) {
        l2 = l1;
      }
      paramIntent.jdField_d_of_type_Long = l2;
      if (l1 > 0L) {
        this.jdField_a_of_type_Oyi.a().jdField_e_of_type_Int = -1;
      }
      this.jdField_a_of_type_Oyi = null;
      return;
      this.p = true;
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "onActivityResult for REFRESH_EVENT_CHECK_PLAYAREA");
      }
      v();
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
    a(paramInt, paramArrayList, paramArrayList1, paramObject, false);
  }
  
  public void a(int paramInt, ArrayList<BaseArticleInfo> paramArrayList, ArrayList<DislikeInfo> paramArrayList1, Object paramObject, boolean paramBoolean)
  {
    this.jdField_b_of_type_JavaUtilList.removeAll(paramArrayList);
    this.o = true;
    notifyDataSetChanged();
    BaseArticleInfo localBaseArticleInfo = null;
    if (paramArrayList.size() > 0) {
      localBaseArticleInfo = (BaseArticleInfo)paramArrayList.get(0);
    }
    int i1 = 2131699674;
    if (AdvertisementInfo.isAdvertisementInfo(localBaseArticleInfo)) {
      i1 = 2131699675;
    }
    if ((this.jdField_a_of_type_AndroidAppActivity instanceof BaseActivity)) {
      bcql.a(this.jdField_a_of_type_AndroidAppActivity, -1, this.jdField_a_of_type_AndroidAppActivity.getString(i1), 0).b(((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).getTitleBarHeight());
    }
    for (;;)
    {
      a(paramInt, paramArrayList, paramArrayList1);
      if (AdvertisementInfo.isAdvertisementInfo(localBaseArticleInfo))
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
        osg.a().a(this.jdField_a_of_type_AndroidAppActivity, (AdvertisementInfo)localBaseArticleInfo, l1, paramArrayList1, paramBoolean);
      }
      try
      {
        paramArrayList = new JSONObject();
        paramArrayList.put("time", System.currentTimeMillis() / 1000L);
        paramArrayList.put("channel_id", this.jdField_c_of_type_Int);
        if (paramArrayList1 != null)
        {
          paramInt = paramArrayList1.size();
          label213:
          paramArrayList.put("tag_num", paramInt);
          if (!(this.jdField_a_of_type_AndroidAppActivity instanceof BaseActivity)) {
            break label387;
          }
          paramArrayList.put("folder_status", onh.jdField_d_of_type_Int);
          paramArrayList.put("kandian_mode", onh.e());
          if (localBaseArticleInfo != null)
          {
            paramArrayList.put("feeds_type", "" + onh.a(localBaseArticleInfo));
            paramArrayList.put("rowkey", shu.a(localBaseArticleInfo));
          }
          paramArrayList = paramArrayList.toString();
          nol.a(null, "", "0X8007059", "0X8007059", 0, 0, "", "", onh.a(paramArrayList1), paramArrayList, false);
        }
        label387:
        while (!(this.jdField_a_of_type_AndroidAppActivity instanceof PluginBaseActivity))
        {
          return;
          if (!(this.jdField_a_of_type_AndroidAppActivity instanceof PluginBaseActivity)) {
            break;
          }
          bcql.a(this.jdField_a_of_type_AndroidAppActivity, -1, this.jdField_a_of_type_AndroidAppActivity.getString(i1), 0).b(((PluginBaseActivity)this.jdField_a_of_type_AndroidAppActivity).g());
          break;
          paramInt = 0;
          break label213;
        }
        paramArrayList.put("folder_status", 1);
        axqy.b(null, "CliOper", "", "", "0X8007060", "0X8007060", 0, 0, "", "", "", paramArrayList.toString());
        return;
      }
      catch (JSONException paramArrayList)
      {
        paramArrayList.printStackTrace();
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
  
  public void a(View paramView, int paramInt, ArticleInfo paramArticleInfo, ArrayList<DislikeInfo> paramArrayList)
  {
    if ((paramView != null) && (paramArticleInfo != null) && (paramArrayList != null))
    {
      Object localObject = paramView.getTag(2131368790);
      if ((localObject != null) && ((localObject instanceof Animation)))
      {
        localObject = (Animation)paramView.getTag(2131368790);
        ((Animation)localObject).setAnimationListener(new rbg(this, paramView, paramArticleInfo, paramInt, paramArrayList));
        paramView.startAnimation((Animation)localObject);
      }
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
          if (localObject != ((pau)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(i2).getTag(2131379213)).a()) {}
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
            localObject = new rbf(this, (BaseArticleInfo)localObject, i1);
            Animation localAnimation = (Animation)paramAdvertisementInfo.getTag(2131368790);
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
  
  public void a(ArticleInfo paramArticleInfo, View paramView, int paramInt)
  {
    if (this.jdField_a_of_type_Sds != null)
    {
      this.jdField_a_of_type_Sds.a(paramArticleInfo);
      this.jdField_a_of_type_Sds.a(paramView, paramInt);
      this.jdField_a_of_type_Sds.a(this);
    }
  }
  
  public void a(BaseArticleInfo paramBaseArticleInfo)
  {
    this.jdField_b_of_type_JavaUtilList.remove(paramBaseArticleInfo);
    notifyDataSetChanged();
    this.o = true;
  }
  
  public void a(BaseArticleInfo paramBaseArticleInfo, pau parampau, long paramLong, int paramInt)
  {
    if ((paramBaseArticleInfo == null) || (this.jdField_b_of_type_JavaUtilSet == null) || (((paramBaseArticleInfo instanceof ArticleInfo)) && (jdField_a_of_type_Pjn.b((ArticleInfo)paramBaseArticleInfo)))) {
      break label31;
    }
    label31:
    while ((onh.j(paramBaseArticleInfo)) && (!onh.l(paramBaseArticleInfo))) {
      return;
    }
    if ((paramBaseArticleInfo.hasOnlyTwoVideoFeeds()) && (paramBaseArticleInfo.mSubArtilceList.size() > 0) && (paramBaseArticleInfo.mFeedType != 121))
    {
      Iterator localIterator = paramBaseArticleInfo.mSubArtilceList.iterator();
      while (localIterator.hasNext()) {
        a((ArticleInfo)localIterator.next(), new pbf(this.jdField_a_of_type_AndroidAppActivity, (ArticleInfo)paramBaseArticleInfo, 46, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, paramInt, this.jdField_c_of_type_Boolean, getCount(), null, this), paramLong, paramInt);
      }
    }
    int i1;
    if ((onh.s(paramBaseArticleInfo)) && (paramBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_Boolean)) {
      if (!this.jdField_a_of_type_JavaUtilMap.containsKey(Long.valueOf(-paramBaseArticleInfo.mArticleID))) {
        i1 = 1;
      }
    }
    for (;;)
    {
      if (i1 != 0) {
        ThreadManager.post(new ReadInJoyBaseAdapter.12(this, paramBaseArticleInfo, parampau, paramInt, paramLong, paramBaseArticleInfo), 5, null, true);
      }
      if (!onh.q()) {
        break;
      }
      ThreadManager.executeOnSubThread(new ReadInJoyBaseAdapter.13(this, paramBaseArticleInfo));
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
    if (this.jdField_c_of_type_Int == 40677) {}
    do
    {
      do
      {
        return;
      } while (((this.jdField_a_of_type_Qtr != null) && (this.jdField_a_of_type_Qtr.h())) || (oat.a().a() == 1) || (this.jdField_a_of_type_Qtr == null) || (!this.jdField_a_of_type_Qkr.a()) || (this.jdField_a_of_type_Qkr.b()) || (paramAbsListView == null) || (paramAbsListView.getVisibility() != 0));
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1001);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1001, paramInt);
    } while (!QLog.isColorLevel());
    QLog.d("Q.readinjoy.video", 2, "checkPlayableArea delay: " + paramInt);
  }
  
  public void a(List<BaseArticleInfo> paramList)
  {
    oyc.a(this.jdField_a_of_type_AndroidUtilSparseArray, new rbc(this, "onSetData", paramList));
    StringBuilder localStringBuilder;
    if ((paramList != null) && (this.jdField_b_of_type_JavaUtilList.getClass().isInstance(paramList)) && (paramList.size() > 0))
    {
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
      c(paramList);
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
      qkt.a().a(this, this.jdField_b_of_type_JavaUtilList);
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
        if (ozg.a(l1)) {
          ozg.a().a(this.jdField_c_of_type_Int, l1);
        } else {
          osg.a().a(this.jdField_c_of_type_Int, localArticleInfo);
        }
      }
    }
    b(this.jdField_c_of_type_Int, paramInt);
  }
  
  public void a(Set<Long> paramSet, Map<Long, qao> paramMap)
  {
    this.jdField_b_of_type_JavaUtilSet = paramSet;
    this.jdField_a_of_type_JavaUtilMap = paramMap;
  }
  
  public void a(nlu paramnlu)
  {
    this.jdField_a_of_type_Nlu = paramnlu;
  }
  
  public void a(oag paramoag)
  {
    this.jdField_a_of_type_Oag = paramoag;
  }
  
  /* Error */
  public void a(oyg paramoyg, BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aload_2
    //   6: getfield 2673	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mSimpleVideoColumnInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo;
    //   9: ifnull +142 -> 151
    //   12: aload_2
    //   13: getfield 2673	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mSimpleVideoColumnInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo;
    //   16: astore 4
    //   18: aload 4
    //   20: getfield 2674	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:h	Ljava/lang/String;
    //   23: invokestatic 431	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   26: ifne +417 -> 443
    //   29: aload_1
    //   30: getfield 2678	oyg:jdField_f_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   33: aload 4
    //   35: getfield 2674	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:h	Ljava/lang/String;
    //   38: invokevirtual 2679	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   41: aload_1
    //   42: getfield 2678	oyg:jdField_f_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   45: iconst_0
    //   46: invokevirtual 1581	android/widget/TextView:setVisibility	(I)V
    //   49: aload 4
    //   51: getfield 2680	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   54: invokestatic 431	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   57: ifne +408 -> 465
    //   60: new 1202	java/net/URL
    //   63: dup
    //   64: aload 4
    //   66: getfield 2680	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   69: invokespecial 1562	java/net/URL:<init>	(Ljava/lang/String;)V
    //   72: astore 5
    //   74: aload_1
    //   75: getfield 2682	oyg:jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   78: aload 5
    //   80: invokevirtual 2685	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:a	(Ljava/net/URL;)Lcom/tencent/biz/pubaccount/readinjoy/view/imageloader/ZImageView;
    //   83: pop
    //   84: aload_1
    //   85: getfield 2682	oyg:jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   88: iconst_0
    //   89: invokevirtual 1580	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setVisibility	(I)V
    //   92: aload 4
    //   94: getfield 2686	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   97: invokestatic 431	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   100: ifne +395 -> 495
    //   103: aload_1
    //   104: getfield 2688	oyg:g	Landroid/widget/TextView;
    //   107: aload 4
    //   109: getfield 2686	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   112: invokevirtual 2679	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   115: aload_1
    //   116: getfield 2688	oyg:g	Landroid/widget/TextView;
    //   119: iconst_0
    //   120: invokevirtual 1581	android/widget/TextView:setVisibility	(I)V
    //   123: aload 4
    //   125: getfield 2690	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:i	Ljava/lang/String;
    //   128: invokestatic 431	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   131: ifne +20 -> 151
    //   134: aload 4
    //   136: getfield 2690	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:i	Ljava/lang/String;
    //   139: invokestatic 130	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   142: istore_3
    //   143: aload_1
    //   144: getfield 2688	oyg:g	Landroid/widget/TextView;
    //   147: iload_3
    //   148: invokevirtual 2693	android/widget/TextView:setTextColor	(I)V
    //   151: aload_2
    //   152: invokestatic 1806	ram:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lqtv;
    //   155: astore 4
    //   157: aload 4
    //   159: aload_1
    //   160: getfield 2694	oyg:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   163: putfield 1812	qtv:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   166: aload 4
    //   168: aload_1
    //   169: getfield 2695	oyg:jdField_a_of_type_Int	I
    //   172: putfield 567	qtv:jdField_a_of_type_Int	I
    //   175: aload 4
    //   177: aload_2
    //   178: putfield 1177	qtv:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   181: aload_1
    //   182: aload 4
    //   184: putfield 2696	oyg:jdField_a_of_type_Qtv	Lqtv;
    //   187: aload_1
    //   188: getfield 2698	oyg:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   191: aload_2
    //   192: getfield 874	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mTitle	Ljava/lang/String;
    //   195: invokevirtual 2679	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   198: aload_1
    //   199: getfield 2698	oyg:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   202: invokevirtual 2702	android/widget/TextView:getPaint	()Landroid/text/TextPaint;
    //   205: iconst_1
    //   206: invokevirtual 2707	android/text/TextPaint:setFakeBoldText	(Z)V
    //   209: aload_1
    //   210: getfield 2698	oyg:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   213: aload_0
    //   214: getfield 241	ram:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   217: invokevirtual 1538	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   220: ldc_w 2708
    //   223: invokevirtual 2713	android/content/res/Resources:getColor	(I)I
    //   226: invokevirtual 2693	android/widget/TextView:setTextColor	(I)V
    //   229: aload_1
    //   230: getfield 2715	oyg:jdField_b_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   233: bipush 8
    //   235: invokevirtual 1581	android/widget/TextView:setVisibility	(I)V
    //   238: aload_1
    //   239: getfield 2717	oyg:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   242: aload 4
    //   244: getfield 652	qtv:jdField_b_of_type_Int	I
    //   247: invokestatic 2718	omr:a	(I)Ljava/lang/String;
    //   250: invokevirtual 2679	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   253: aload_1
    //   254: getfield 2720	oyg:jdField_b_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   257: bipush 10
    //   259: bipush 10
    //   261: bipush 10
    //   263: bipush 10
    //   265: invokestatic 2725	vzl:a	(Landroid/view/View;IIII)V
    //   268: aload_1
    //   269: getfield 2720	oyg:jdField_b_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   272: aload_1
    //   273: invokevirtual 1803	android/widget/ImageView:setTag	(Ljava/lang/Object;)V
    //   276: aload_1
    //   277: getfield 2720	oyg:jdField_b_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   280: aload_0
    //   281: invokevirtual 1792	android/widget/ImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   284: aload_0
    //   285: getfield 241	ram:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   288: aload_1
    //   289: getfield 2694	oyg:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   292: aload_1
    //   293: getfield 2696	oyg:jdField_a_of_type_Qtv	Lqtv;
    //   296: invokestatic 2728	oye:a	(Landroid/content/Context;Landroid/widget/ImageView;Lqtv;)V
    //   299: aload_0
    //   300: aload_1
    //   301: getfield 2694	oyg:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   304: aload_2
    //   305: iconst_0
    //   306: invokevirtual 1110	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:getVideoCoverUrlWithSmartCut	(Z)Ljava/net/URL;
    //   309: iconst_0
    //   310: invokespecial 1636	ram:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;Ljava/net/URL;Z)V
    //   313: aload_1
    //   314: getfield 2694	oyg:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   317: aload_0
    //   318: invokevirtual 2732	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setOnLongClickListener	(Landroid/view/View$OnLongClickListener;)V
    //   321: aload_1
    //   322: getfield 2735	oyg:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup	Lcom/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup;
    //   325: fconst_1
    //   326: aload 4
    //   328: getfield 822	qtv:jdField_c_of_type_Int	I
    //   331: aload 4
    //   333: getfield 825	qtv:jdField_d_of_type_Int	I
    //   336: invokestatic 2738	omr:a	(II)F
    //   339: invokevirtual 2744	com/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup:setCustomSize	(FF)V
    //   342: aload_1
    //   343: getfield 2735	oyg:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup	Lcom/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup;
    //   346: aload_1
    //   347: invokevirtual 2745	com/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup:setTag	(Ljava/lang/Object;)V
    //   350: aload_0
    //   351: aload_0
    //   352: getfield 141	ram:jdField_c_of_type_Int	I
    //   355: aload_2
    //   356: getfield 1094	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mArticleID	J
    //   359: invokevirtual 2747	ram:b	(IJ)Z
    //   362: ifeq +23 -> 385
    //   365: aload_1
    //   366: getfield 2749	oyg:jdField_f_of_type_AndroidViewView	Landroid/view/View;
    //   369: aload_0
    //   370: getfield 241	ram:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   373: invokevirtual 1538	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   376: ldc_w 2750
    //   379: invokevirtual 2713	android/content/res/Resources:getColor	(I)I
    //   382: invokevirtual 2753	android/view/View:setBackgroundColor	(I)V
    //   385: aload_2
    //   386: getfield 680	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mXGFileSize	J
    //   389: lconst_0
    //   390: lcmp
    //   391: ifgt +116 -> 507
    //   394: aload_1
    //   395: getfield 2755	oyg:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   398: ldc_w 2756
    //   401: invokestatic 1593	ajya:a	(I)Ljava/lang/String;
    //   404: invokevirtual 2679	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   407: aload_0
    //   408: getfield 241	ram:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   411: invokestatic 1223	bbfj:h	(Landroid/content/Context;)Z
    //   414: ifeq +132 -> 546
    //   417: aload_1
    //   418: getfield 2758	oyg:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   421: iconst_0
    //   422: invokevirtual 1606	android/widget/ImageView:setVisibility	(I)V
    //   425: aload_1
    //   426: getfield 2755	oyg:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   429: bipush 8
    //   431: invokevirtual 1581	android/widget/TextView:setVisibility	(I)V
    //   434: aload_1
    //   435: getfield 2760	oyg:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   438: iconst_0
    //   439: invokevirtual 2753	android/view/View:setBackgroundColor	(I)V
    //   442: return
    //   443: aload_1
    //   444: getfield 2678	oyg:jdField_f_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   447: bipush 8
    //   449: invokevirtual 1581	android/widget/TextView:setVisibility	(I)V
    //   452: goto -403 -> 49
    //   455: astore 5
    //   457: aload 5
    //   459: invokevirtual 2761	java/lang/Exception:printStackTrace	()V
    //   462: goto -370 -> 92
    //   465: aload_1
    //   466: getfield 2682	oyg:jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   469: bipush 8
    //   471: invokevirtual 1580	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setVisibility	(I)V
    //   474: goto -382 -> 92
    //   477: astore 4
    //   479: aload_1
    //   480: getfield 2688	oyg:g	Landroid/widget/TextView;
    //   483: ldc_w 2763
    //   486: invokestatic 130	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   489: invokevirtual 2693	android/widget/TextView:setTextColor	(I)V
    //   492: goto -341 -> 151
    //   495: aload_1
    //   496: getfield 2688	oyg:g	Landroid/widget/TextView;
    //   499: bipush 8
    //   501: invokevirtual 1581	android/widget/TextView:setVisibility	(I)V
    //   504: goto -353 -> 151
    //   507: aload_1
    //   508: getfield 2755	oyg:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   511: new 837	java/lang/StringBuilder
    //   514: dup
    //   515: invokespecial 838	java/lang/StringBuilder:<init>	()V
    //   518: aload_2
    //   519: getfield 680	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mXGFileSize	J
    //   522: invokestatic 2764	qoi:b	(J)Ljava/lang/String;
    //   525: invokevirtual 842	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   528: ldc_w 2765
    //   531: invokestatic 1593	ajya:a	(I)Ljava/lang/String;
    //   534: invokevirtual 842	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   537: invokevirtual 848	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   540: invokevirtual 2679	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   543: goto -136 -> 407
    //   546: aload_1
    //   547: getfield 2758	oyg:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   550: bipush 8
    //   552: invokevirtual 1606	android/widget/ImageView:setVisibility	(I)V
    //   555: aload_0
    //   556: getfield 241	ram:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   559: invokevirtual 1538	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   562: ldc_w 2766
    //   565: invokevirtual 2769	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   568: astore 4
    //   570: aload_1
    //   571: getfield 2755	oyg:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   574: aload 4
    //   576: aconst_null
    //   577: aconst_null
    //   578: aconst_null
    //   579: invokevirtual 2773	android/widget/TextView:setCompoundDrawablesWithIntrinsicBounds	(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V
    //   582: aload_1
    //   583: getfield 2755	oyg:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   586: ldc_w 2103
    //   589: aload_0
    //   590: getfield 241	ram:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   593: invokevirtual 1538	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   596: invokestatic 594	actj:a	(FLandroid/content/res/Resources;)I
    //   599: invokevirtual 2776	android/widget/TextView:setCompoundDrawablePadding	(I)V
    //   602: aload_1
    //   603: getfield 2755	oyg:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   606: iconst_0
    //   607: invokevirtual 1581	android/widget/TextView:setVisibility	(I)V
    //   610: invokestatic 2779	bbwq:a	()I
    //   613: iconst_1
    //   614: if_icmpne +34 -> 648
    //   617: aload_1
    //   618: getfield 2755	oyg:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   621: ldc_w 2780
    //   624: invokestatic 1593	ajya:a	(I)Ljava/lang/String;
    //   627: invokevirtual 2679	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   630: aload_1
    //   631: getfield 2782	oyg:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   634: bipush 8
    //   636: invokevirtual 1581	android/widget/TextView:setVisibility	(I)V
    //   639: aload_1
    //   640: getfield 2760	oyg:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   643: iconst_0
    //   644: invokevirtual 2753	android/view/View:setBackgroundColor	(I)V
    //   647: return
    //   648: invokestatic 2784	bhvy:u	()Z
    //   651: ifeq +280 -> 931
    //   654: aload_0
    //   655: getfield 2785	ram:jdField_h_of_type_Boolean	Z
    //   658: ifne +273 -> 931
    //   661: aload_1
    //   662: getfield 2695	oyg:jdField_a_of_type_Int	I
    //   665: ifne +266 -> 931
    //   668: invokestatic 2787	bhvy:d	()Ljava/lang/String;
    //   671: astore 5
    //   673: invokestatic 2789	bhvy:e	()Ljava/lang/String;
    //   676: astore 6
    //   678: invokestatic 2791	bhvy:f	()Ljava/lang/String;
    //   681: astore 7
    //   683: aload 5
    //   685: invokestatic 431	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   688: ifne +209 -> 897
    //   691: invokestatic 2793	onh:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   694: astore 8
    //   696: ldc_w 918
    //   699: astore 4
    //   701: aload 8
    //   703: ifnull +10 -> 713
    //   706: aload 8
    //   708: invokevirtual 2796	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   711: astore 4
    //   713: new 1335	qzb
    //   716: dup
    //   717: aconst_null
    //   718: aconst_null
    //   719: aconst_null
    //   720: aconst_null
    //   721: invokespecial 1338	qzb:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   724: aload 4
    //   726: invokevirtual 2799	qzb:l	(Ljava/lang/String;)Lqzb;
    //   729: aload_2
    //   730: getfield 781	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:innerUniqueID	Ljava/lang/String;
    //   733: invokevirtual 2801	qzb:h	(Ljava/lang/String;)Lqzb;
    //   736: invokevirtual 1361	qzb:a	()Lqza;
    //   739: invokevirtual 1365	qza:a	()Ljava/lang/String;
    //   742: astore_2
    //   743: aload_1
    //   744: getfield 2782	oyg:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   747: iconst_0
    //   748: invokevirtual 1581	android/widget/TextView:setVisibility	(I)V
    //   751: aload_1
    //   752: getfield 2782	oyg:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   755: fconst_2
    //   756: aload_0
    //   757: getfield 241	ram:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   760: invokevirtual 1538	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   763: invokestatic 594	actj:a	(FLandroid/content/res/Resources;)I
    //   766: invokevirtual 2776	android/widget/TextView:setCompoundDrawablePadding	(I)V
    //   769: aload_0
    //   770: getfield 241	ram:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   773: invokevirtual 1538	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   776: ldc_w 2802
    //   779: invokevirtual 2769	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   782: astore 4
    //   784: aload 4
    //   786: iconst_0
    //   787: iconst_0
    //   788: ldc_w 2803
    //   791: aload_0
    //   792: getfield 241	ram:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   795: invokevirtual 1538	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   798: invokestatic 594	actj:a	(FLandroid/content/res/Resources;)I
    //   801: ldc_w 2803
    //   804: aload_0
    //   805: getfield 241	ram:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   808: invokevirtual 1538	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   811: invokestatic 594	actj:a	(FLandroid/content/res/Resources;)I
    //   814: invokevirtual 2808	android/graphics/drawable/Drawable:setBounds	(IIII)V
    //   817: aload_1
    //   818: getfield 2782	oyg:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   821: aconst_null
    //   822: aconst_null
    //   823: aload 4
    //   825: aconst_null
    //   826: invokevirtual 2811	android/widget/TextView:setCompoundDrawables	(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V
    //   829: aload_0
    //   830: getfield 241	ram:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   833: aload_1
    //   834: getfield 2782	oyg:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   837: aload 6
    //   839: aload 7
    //   841: aload 5
    //   843: new 2813	rbm
    //   846: dup
    //   847: aload_0
    //   848: aload_2
    //   849: invokespecial 2814	rbm:<init>	(Lram;Ljava/lang/String;)V
    //   852: invokestatic 2817	qoi:b	(Landroid/content/Context;Landroid/widget/TextView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/view/View$OnClickListener;)V
    //   855: aload_1
    //   856: getfield 2760	oyg:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   859: ldc_w 2818
    //   862: invokevirtual 2753	android/view/View:setBackgroundColor	(I)V
    //   865: aload_0
    //   866: iconst_1
    //   867: putfield 2785	ram:jdField_h_of_type_Boolean	Z
    //   870: aconst_null
    //   871: ldc_w 918
    //   874: ldc_w 2820
    //   877: ldc_w 2820
    //   880: iconst_0
    //   881: iconst_0
    //   882: ldc_w 918
    //   885: ldc_w 918
    //   888: ldc_w 918
    //   891: aload_2
    //   892: iconst_0
    //   893: invokestatic 1374	nol:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   896: return
    //   897: aload_1
    //   898: getfield 2782	oyg:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   901: bipush 8
    //   903: invokevirtual 1581	android/widget/TextView:setVisibility	(I)V
    //   906: aload_1
    //   907: getfield 2760	oyg:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   910: iconst_0
    //   911: invokevirtual 2753	android/view/View:setBackgroundColor	(I)V
    //   914: invokestatic 338	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   917: ifeq -913 -> 4
    //   920: ldc_w 1060
    //   923: iconst_2
    //   924: ldc_w 2822
    //   927: invokestatic 1065	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   930: return
    //   931: aload_1
    //   932: getfield 2782	oyg:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   935: bipush 8
    //   937: invokevirtual 1581	android/widget/TextView:setVisibility	(I)V
    //   940: aload_1
    //   941: getfield 2760	oyg:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   944: iconst_0
    //   945: invokevirtual 2753	android/view/View:setBackgroundColor	(I)V
    //   948: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	949	0	this	ram
    //   0	949	1	paramoyg	oyg
    //   0	949	2	paramBaseArticleInfo	BaseArticleInfo
    //   0	949	3	paramInt	int
    //   16	316	4	localObject1	Object
    //   477	1	4	localThrowable	Throwable
    //   568	256	4	localObject2	Object
    //   72	7	5	localURL	URL
    //   455	3	5	localException	Exception
    //   671	171	5	str1	String
    //   676	162	6	str2	String
    //   681	159	7	str3	String
    //   694	13	8	localQQAppInterface	QQAppInterface
    // Exception table:
    //   from	to	target	type
    //   60	92	455	java/lang/Exception
    //   134	151	477	java/lang/Throwable
  }
  
  /* Error */
  public void a(oyh paramoyh, BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aload_2
    //   6: getfield 2826	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mArticleSubscriptText	Ljava/lang/String;
    //   9: invokestatic 431	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   12: ifne +515 -> 527
    //   15: aload_1
    //   16: getfield 2829	oyh:i	Landroid/widget/TextView;
    //   19: aload_2
    //   20: getfield 2826	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mArticleSubscriptText	Ljava/lang/String;
    //   23: invokevirtual 2679	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   26: aload_2
    //   27: getfield 2832	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mArticleSubscriptColor	Ljava/lang/String;
    //   30: invokestatic 431	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   33: ifeq +485 -> 518
    //   36: ldc_w 2834
    //   39: astore 4
    //   41: aload 4
    //   43: invokestatic 130	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   46: istore_3
    //   47: aload_1
    //   48: getfield 2829	oyh:i	Landroid/widget/TextView;
    //   51: iload_3
    //   52: invokevirtual 2693	android/widget/TextView:setTextColor	(I)V
    //   55: aload_1
    //   56: getfield 2829	oyh:i	Landroid/widget/TextView;
    //   59: iconst_0
    //   60: invokevirtual 1581	android/widget/TextView:setVisibility	(I)V
    //   63: aload_1
    //   64: getfield 2835	oyh:g	Landroid/widget/TextView;
    //   67: aload_2
    //   68: getfield 630	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mSubscribeName	Ljava/lang/String;
    //   71: invokevirtual 2679	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   74: aload_2
    //   75: invokevirtual 1554	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:hasFamilyCommentIcon	()Z
    //   78: ifeq +476 -> 554
    //   81: new 1202	java/net/URL
    //   84: dup
    //   85: aload_2
    //   86: getfield 1558	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:familyCommentInfo	Lqax;
    //   89: getfield 1561	qax:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   92: invokespecial 1562	java/net/URL:<init>	(Ljava/lang/String;)V
    //   95: astore 4
    //   97: aload_2
    //   98: getfield 1558	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:familyCommentInfo	Lqax;
    //   101: getfield 1563	qax:jdField_b_of_type_Int	I
    //   104: ifle +27 -> 131
    //   107: aload_0
    //   108: aload_1
    //   109: getfield 2836	oyh:jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   112: aload 4
    //   114: aload_2
    //   115: getfield 1558	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:familyCommentInfo	Lqax;
    //   118: getfield 1564	qax:jdField_a_of_type_Int	I
    //   121: aload_2
    //   122: getfield 1558	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:familyCommentInfo	Lqax;
    //   125: getfield 1563	qax:jdField_b_of_type_Int	I
    //   128: invokespecial 1567	ram:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;Ljava/net/URL;II)V
    //   131: aload_1
    //   132: getfield 2836	oyh:jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   135: iconst_0
    //   136: invokevirtual 1580	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setVisibility	(I)V
    //   139: aload_1
    //   140: getfield 2837	oyh:h	Landroid/widget/TextView;
    //   143: bipush 8
    //   145: invokevirtual 1581	android/widget/TextView:setVisibility	(I)V
    //   148: aload_2
    //   149: getfield 2840	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:vIconUrl	Ljava/lang/String;
    //   152: invokestatic 431	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   155: ifne +475 -> 630
    //   158: new 1202	java/net/URL
    //   161: dup
    //   162: aload_2
    //   163: getfield 2840	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:vIconUrl	Ljava/lang/String;
    //   166: invokespecial 1562	java/net/URL:<init>	(Ljava/lang/String;)V
    //   169: astore 4
    //   171: aload_1
    //   172: getfield 2842	oyh:jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   175: aload 4
    //   177: invokevirtual 2685	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:a	(Ljava/net/URL;)Lcom/tencent/biz/pubaccount/readinjoy/view/imageloader/ZImageView;
    //   180: pop
    //   181: aload_1
    //   182: getfield 2842	oyh:jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   185: iconst_0
    //   186: invokevirtual 1580	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setVisibility	(I)V
    //   189: aload_1
    //   190: getfield 2843	oyh:jdField_b_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   193: bipush 10
    //   195: bipush 10
    //   197: bipush 10
    //   199: bipush 10
    //   201: invokestatic 2725	vzl:a	(Landroid/view/View;IIII)V
    //   204: aload_1
    //   205: getfield 2843	oyh:jdField_b_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   208: aload_1
    //   209: invokevirtual 1803	android/widget/ImageView:setTag	(Ljava/lang/Object;)V
    //   212: aload_1
    //   213: getfield 2843	oyh:jdField_b_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   216: aload_0
    //   217: invokevirtual 1792	android/widget/ImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   220: aload_2
    //   221: invokestatic 1806	ram:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lqtv;
    //   224: astore 4
    //   226: aload 4
    //   228: aload_1
    //   229: getfield 2844	oyh:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   232: putfield 1812	qtv:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   235: aload 4
    //   237: aload_1
    //   238: getfield 2845	oyh:jdField_a_of_type_Int	I
    //   241: putfield 567	qtv:jdField_a_of_type_Int	I
    //   244: aload 4
    //   246: aload_2
    //   247: putfield 1177	qtv:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   250: aload 4
    //   252: iconst_1
    //   253: putfield 2846	qtv:jdField_n_of_type_Int	I
    //   256: aload_1
    //   257: aload 4
    //   259: putfield 2847	oyh:jdField_a_of_type_Qtv	Lqtv;
    //   262: aload_1
    //   263: getfield 2848	oyh:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   266: bipush 8
    //   268: invokevirtual 1581	android/widget/TextView:setVisibility	(I)V
    //   271: aload_1
    //   272: getfield 2849	oyh:jdField_b_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   275: bipush 8
    //   277: invokevirtual 1581	android/widget/TextView:setVisibility	(I)V
    //   280: aload_1
    //   281: getfield 2851	oyh:jdField_c_of_type_AndroidViewView	Landroid/view/View;
    //   284: bipush 8
    //   286: invokevirtual 1551	android/view/View:setVisibility	(I)V
    //   289: aload_1
    //   290: getfield 2852	oyh:jdField_f_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   293: aload_2
    //   294: getfield 874	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mTitle	Ljava/lang/String;
    //   297: invokevirtual 2679	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   300: aload_1
    //   301: getfield 2852	oyh:jdField_f_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   304: astore 5
    //   306: invokestatic 2045	osg:a	()Losg;
    //   309: aload_2
    //   310: getfield 1094	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mArticleID	J
    //   313: invokevirtual 2853	osg:a	(J)Z
    //   316: ifeq +326 -> 642
    //   319: getstatic 132	ram:jdField_g_of_type_Int	I
    //   322: istore_3
    //   323: aload 5
    //   325: iload_3
    //   326: invokevirtual 2693	android/widget/TextView:setTextColor	(I)V
    //   329: aload_1
    //   330: getfield 2854	oyh:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   333: aload 4
    //   335: getfield 652	qtv:jdField_b_of_type_Int	I
    //   338: invokestatic 2718	omr:a	(I)Ljava/lang/String;
    //   341: invokevirtual 2679	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   344: aload_0
    //   345: getfield 241	ram:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   348: aload_1
    //   349: getfield 2844	oyh:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   352: aload_1
    //   353: getfield 2847	oyh:jdField_a_of_type_Qtv	Lqtv;
    //   356: invokestatic 2728	oye:a	(Landroid/content/Context;Landroid/widget/ImageView;Lqtv;)V
    //   359: aload_0
    //   360: aload_1
    //   361: getfield 2844	oyh:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   364: aload_2
    //   365: iconst_0
    //   366: invokevirtual 1110	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:getVideoCoverUrlWithSmartCut	(Z)Ljava/net/URL;
    //   369: iconst_0
    //   370: invokespecial 1636	ram:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;Ljava/net/URL;Z)V
    //   373: aload_1
    //   374: getfield 2844	oyh:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   377: aload_0
    //   378: invokevirtual 2732	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setOnLongClickListener	(Landroid/view/View$OnLongClickListener;)V
    //   381: aload_1
    //   382: getfield 2854	oyh:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   385: iconst_0
    //   386: invokevirtual 1581	android/widget/TextView:setVisibility	(I)V
    //   389: aload_1
    //   390: getfield 2854	oyh:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   393: invokevirtual 2857	android/widget/TextView:clearAnimation	()V
    //   396: aload_1
    //   397: getfield 2858	oyh:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup	Lcom/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup;
    //   400: fconst_1
    //   401: aload 4
    //   403: getfield 822	qtv:jdField_c_of_type_Int	I
    //   406: aload 4
    //   408: getfield 825	qtv:jdField_d_of_type_Int	I
    //   411: invokestatic 2738	omr:a	(II)F
    //   414: invokevirtual 2744	com/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup:setCustomSize	(FF)V
    //   417: aload_1
    //   418: getfield 2858	oyh:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup	Lcom/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup;
    //   421: aload_1
    //   422: invokevirtual 2745	com/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup:setTag	(Ljava/lang/Object;)V
    //   425: aload_0
    //   426: aload_0
    //   427: getfield 141	ram:jdField_c_of_type_Int	I
    //   430: aload_2
    //   431: getfield 1094	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mArticleID	J
    //   434: invokevirtual 2747	ram:b	(IJ)Z
    //   437: ifeq +23 -> 460
    //   440: aload_1
    //   441: getfield 2859	oyh:jdField_f_of_type_AndroidViewView	Landroid/view/View;
    //   444: aload_0
    //   445: getfield 241	ram:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   448: invokevirtual 1538	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   451: ldc_w 2750
    //   454: invokevirtual 2713	android/content/res/Resources:getColor	(I)I
    //   457: invokevirtual 2753	android/view/View:setBackgroundColor	(I)V
    //   460: aload_2
    //   461: getfield 680	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mXGFileSize	J
    //   464: lconst_0
    //   465: lcmp
    //   466: ifgt +183 -> 649
    //   469: aload_1
    //   470: getfield 2860	oyh:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   473: ldc_w 2756
    //   476: invokestatic 1593	ajya:a	(I)Ljava/lang/String;
    //   479: invokevirtual 2679	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   482: aload_0
    //   483: getfield 241	ram:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   486: invokestatic 1223	bbfj:h	(Landroid/content/Context;)Z
    //   489: ifeq +199 -> 688
    //   492: aload_1
    //   493: getfield 2861	oyh:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   496: iconst_0
    //   497: invokevirtual 1606	android/widget/ImageView:setVisibility	(I)V
    //   500: aload_1
    //   501: getfield 2860	oyh:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   504: bipush 8
    //   506: invokevirtual 1581	android/widget/TextView:setVisibility	(I)V
    //   509: aload_1
    //   510: getfield 2862	oyh:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   513: iconst_0
    //   514: invokevirtual 2753	android/view/View:setBackgroundColor	(I)V
    //   517: return
    //   518: aload_2
    //   519: getfield 2832	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mArticleSubscriptColor	Ljava/lang/String;
    //   522: astore 4
    //   524: goto -483 -> 41
    //   527: aload_1
    //   528: getfield 2829	oyh:i	Landroid/widget/TextView;
    //   531: bipush 8
    //   533: invokevirtual 1581	android/widget/TextView:setVisibility	(I)V
    //   536: goto -473 -> 63
    //   539: astore 4
    //   541: ldc_w 340
    //   544: iconst_2
    //   545: ldc_w 2864
    //   548: invokestatic 345	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   551: goto -403 -> 148
    //   554: aload_1
    //   555: getfield 2836	oyh:jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   558: bipush 8
    //   560: invokevirtual 1580	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setVisibility	(I)V
    //   563: aload_1
    //   564: getfield 2837	oyh:h	Landroid/widget/TextView;
    //   567: iconst_0
    //   568: invokevirtual 1581	android/widget/TextView:setVisibility	(I)V
    //   571: ldc_w 340
    //   574: iconst_2
    //   575: ldc_w 2866
    //   578: invokestatic 345	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   581: aload_1
    //   582: getfield 2837	oyh:h	Landroid/widget/TextView;
    //   585: new 837	java/lang/StringBuilder
    //   588: dup
    //   589: invokespecial 838	java/lang/StringBuilder:<init>	()V
    //   592: aload_2
    //   593: invokevirtual 1588	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:getCommentCount	()I
    //   596: invokestatic 2868	qoi:d	(I)Ljava/lang/String;
    //   599: invokevirtual 842	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   602: ldc_w 2869
    //   605: invokestatic 1593	ajya:a	(I)Ljava/lang/String;
    //   608: invokevirtual 842	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   611: invokevirtual 848	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   614: invokevirtual 2679	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   617: goto -469 -> 148
    //   620: astore 4
    //   622: aload 4
    //   624: invokevirtual 2761	java/lang/Exception:printStackTrace	()V
    //   627: goto -438 -> 189
    //   630: aload_1
    //   631: getfield 2842	oyh:jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   634: bipush 8
    //   636: invokevirtual 1580	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setVisibility	(I)V
    //   639: goto -450 -> 189
    //   642: getstatic 136	ram:jdField_h_of_type_Int	I
    //   645: istore_3
    //   646: goto -323 -> 323
    //   649: aload_1
    //   650: getfield 2860	oyh:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   653: new 837	java/lang/StringBuilder
    //   656: dup
    //   657: invokespecial 838	java/lang/StringBuilder:<init>	()V
    //   660: aload_2
    //   661: getfield 680	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mXGFileSize	J
    //   664: invokestatic 2764	qoi:b	(J)Ljava/lang/String;
    //   667: invokevirtual 842	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   670: ldc_w 2765
    //   673: invokestatic 1593	ajya:a	(I)Ljava/lang/String;
    //   676: invokevirtual 842	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   679: invokevirtual 848	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   682: invokevirtual 2679	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   685: goto -203 -> 482
    //   688: aload_1
    //   689: getfield 2861	oyh:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   692: bipush 8
    //   694: invokevirtual 1606	android/widget/ImageView:setVisibility	(I)V
    //   697: aload_0
    //   698: getfield 241	ram:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   701: invokevirtual 1538	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   704: ldc_w 2766
    //   707: invokevirtual 2769	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   710: astore 4
    //   712: aload_1
    //   713: getfield 2860	oyh:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   716: aload 4
    //   718: aconst_null
    //   719: aconst_null
    //   720: aconst_null
    //   721: invokevirtual 2773	android/widget/TextView:setCompoundDrawablesWithIntrinsicBounds	(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V
    //   724: aload_1
    //   725: getfield 2860	oyh:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   728: ldc_w 2103
    //   731: aload_0
    //   732: getfield 241	ram:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   735: invokevirtual 1538	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   738: invokestatic 594	actj:a	(FLandroid/content/res/Resources;)I
    //   741: invokevirtual 2776	android/widget/TextView:setCompoundDrawablePadding	(I)V
    //   744: aload_1
    //   745: getfield 2860	oyh:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   748: iconst_0
    //   749: invokevirtual 1581	android/widget/TextView:setVisibility	(I)V
    //   752: invokestatic 2779	bbwq:a	()I
    //   755: iconst_1
    //   756: if_icmpne +34 -> 790
    //   759: aload_1
    //   760: getfield 2860	oyh:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   763: ldc_w 2780
    //   766: invokestatic 1593	ajya:a	(I)Ljava/lang/String;
    //   769: invokevirtual 2679	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   772: aload_1
    //   773: getfield 2870	oyh:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   776: bipush 8
    //   778: invokevirtual 1581	android/widget/TextView:setVisibility	(I)V
    //   781: aload_1
    //   782: getfield 2862	oyh:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   785: iconst_0
    //   786: invokevirtual 2753	android/view/View:setBackgroundColor	(I)V
    //   789: return
    //   790: invokestatic 2784	bhvy:u	()Z
    //   793: ifeq +280 -> 1073
    //   796: aload_0
    //   797: getfield 2785	ram:jdField_h_of_type_Boolean	Z
    //   800: ifne +273 -> 1073
    //   803: aload_1
    //   804: getfield 2845	oyh:jdField_a_of_type_Int	I
    //   807: ifne +266 -> 1073
    //   810: invokestatic 2787	bhvy:d	()Ljava/lang/String;
    //   813: astore 5
    //   815: invokestatic 2789	bhvy:e	()Ljava/lang/String;
    //   818: astore 6
    //   820: invokestatic 2791	bhvy:f	()Ljava/lang/String;
    //   823: astore 7
    //   825: aload 5
    //   827: invokestatic 431	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   830: ifne +209 -> 1039
    //   833: invokestatic 2793	onh:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   836: astore 8
    //   838: ldc_w 918
    //   841: astore 4
    //   843: aload 8
    //   845: ifnull +10 -> 855
    //   848: aload 8
    //   850: invokevirtual 2796	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   853: astore 4
    //   855: new 1335	qzb
    //   858: dup
    //   859: aconst_null
    //   860: aconst_null
    //   861: aconst_null
    //   862: aconst_null
    //   863: invokespecial 1338	qzb:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   866: aload 4
    //   868: invokevirtual 2799	qzb:l	(Ljava/lang/String;)Lqzb;
    //   871: aload_2
    //   872: getfield 781	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:innerUniqueID	Ljava/lang/String;
    //   875: invokevirtual 2801	qzb:h	(Ljava/lang/String;)Lqzb;
    //   878: invokevirtual 1361	qzb:a	()Lqza;
    //   881: invokevirtual 1365	qza:a	()Ljava/lang/String;
    //   884: astore_2
    //   885: aload_1
    //   886: getfield 2870	oyh:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   889: iconst_0
    //   890: invokevirtual 1581	android/widget/TextView:setVisibility	(I)V
    //   893: aload_1
    //   894: getfield 2870	oyh:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   897: fconst_2
    //   898: aload_0
    //   899: getfield 241	ram:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   902: invokevirtual 1538	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   905: invokestatic 594	actj:a	(FLandroid/content/res/Resources;)I
    //   908: invokevirtual 2776	android/widget/TextView:setCompoundDrawablePadding	(I)V
    //   911: aload_0
    //   912: getfield 241	ram:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   915: invokevirtual 1538	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   918: ldc_w 2802
    //   921: invokevirtual 2769	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   924: astore 4
    //   926: aload 4
    //   928: iconst_0
    //   929: iconst_0
    //   930: ldc_w 2803
    //   933: aload_0
    //   934: getfield 241	ram:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   937: invokevirtual 1538	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   940: invokestatic 594	actj:a	(FLandroid/content/res/Resources;)I
    //   943: ldc_w 2803
    //   946: aload_0
    //   947: getfield 241	ram:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   950: invokevirtual 1538	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   953: invokestatic 594	actj:a	(FLandroid/content/res/Resources;)I
    //   956: invokevirtual 2808	android/graphics/drawable/Drawable:setBounds	(IIII)V
    //   959: aload_1
    //   960: getfield 2870	oyh:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   963: aconst_null
    //   964: aconst_null
    //   965: aload 4
    //   967: aconst_null
    //   968: invokevirtual 2811	android/widget/TextView:setCompoundDrawables	(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V
    //   971: aload_0
    //   972: getfield 241	ram:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   975: aload_1
    //   976: getfield 2870	oyh:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   979: aload 6
    //   981: aload 7
    //   983: aload 5
    //   985: new 2872	rbl
    //   988: dup
    //   989: aload_0
    //   990: aload_2
    //   991: invokespecial 2873	rbl:<init>	(Lram;Ljava/lang/String;)V
    //   994: invokestatic 2817	qoi:b	(Landroid/content/Context;Landroid/widget/TextView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/view/View$OnClickListener;)V
    //   997: aload_1
    //   998: getfield 2862	oyh:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   1001: ldc_w 2818
    //   1004: invokevirtual 2753	android/view/View:setBackgroundColor	(I)V
    //   1007: aload_0
    //   1008: iconst_1
    //   1009: putfield 2785	ram:jdField_h_of_type_Boolean	Z
    //   1012: aconst_null
    //   1013: ldc_w 918
    //   1016: ldc_w 2820
    //   1019: ldc_w 2820
    //   1022: iconst_0
    //   1023: iconst_0
    //   1024: ldc_w 918
    //   1027: ldc_w 918
    //   1030: ldc_w 918
    //   1033: aload_2
    //   1034: iconst_0
    //   1035: invokestatic 1374	nol:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   1038: return
    //   1039: aload_1
    //   1040: getfield 2870	oyh:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   1043: bipush 8
    //   1045: invokevirtual 1581	android/widget/TextView:setVisibility	(I)V
    //   1048: aload_1
    //   1049: getfield 2862	oyh:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   1052: iconst_0
    //   1053: invokevirtual 2753	android/view/View:setBackgroundColor	(I)V
    //   1056: invokestatic 338	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1059: ifeq -1055 -> 4
    //   1062: ldc_w 1060
    //   1065: iconst_2
    //   1066: ldc_w 2822
    //   1069: invokestatic 1065	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1072: return
    //   1073: aload_1
    //   1074: getfield 2870	oyh:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   1077: bipush 8
    //   1079: invokevirtual 1581	android/widget/TextView:setVisibility	(I)V
    //   1082: aload_1
    //   1083: getfield 2862	oyh:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   1086: iconst_0
    //   1087: invokevirtual 2753	android/view/View:setBackgroundColor	(I)V
    //   1090: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1091	0	this	ram
    //   0	1091	1	paramoyh	oyh
    //   0	1091	2	paramBaseArticleInfo	BaseArticleInfo
    //   0	1091	3	paramInt	int
    //   39	484	4	localObject1	Object
    //   539	1	4	localMalformedURLException	MalformedURLException
    //   620	3	4	localException	Exception
    //   710	256	4	localObject2	Object
    //   304	680	5	localObject3	Object
    //   818	162	6	str1	String
    //   823	159	7	str2	String
    //   836	13	8	localQQAppInterface	QQAppInterface
    // Exception table:
    //   from	to	target	type
    //   81	131	539	java/net/MalformedURLException
    //   131	148	539	java/net/MalformedURLException
    //   158	189	620	java/lang/Exception
  }
  
  public void a(oyi paramoyi)
  {
    this.jdField_a_of_type_Qtr.b(2);
    this.jdField_a_of_type_Oyi = paramoyi;
    this.jdField_a_of_type_Qtv = paramoyi.a();
    this.jdField_a_of_type_Qtr.a(this.jdField_a_of_type_Qtv);
  }
  
  /* Error */
  public void a(oyj paramoyj, BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aload_1
    //   6: getfield 2880	oyj:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   9: invokevirtual 2702	android/widget/TextView:getPaint	()Landroid/text/TextPaint;
    //   12: iconst_1
    //   13: invokevirtual 2707	android/text/TextPaint:setFakeBoldText	(Z)V
    //   16: aload_2
    //   17: getfield 1994	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mVideoColumnInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo;
    //   20: ifnull +390 -> 410
    //   23: aload_2
    //   24: getfield 1994	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mVideoColumnInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo;
    //   27: astore 5
    //   29: aload 5
    //   31: getfield 2881	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:jdField_d_of_type_Int	I
    //   34: iconst_1
    //   35: if_icmpne +690 -> 725
    //   38: aload_1
    //   39: getfield 2882	oyj:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   42: invokevirtual 1638	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   45: astore 4
    //   47: aload 4
    //   49: aload_0
    //   50: getfield 241	ram:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   53: ldc_w 2883
    //   56: invokestatic 1193	baxn:a	(Landroid/content/Context;F)I
    //   59: putfield 1655	android/view/ViewGroup$LayoutParams:height	I
    //   62: aload_1
    //   63: getfield 2882	oyj:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   66: aload 4
    //   68: invokevirtual 1668	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   71: aload 5
    //   73: getfield 2884	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   76: invokestatic 431	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   79: ifne +682 -> 761
    //   82: aload_0
    //   83: aload_1
    //   84: getfield 2882	oyj:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   87: new 1202	java/net/URL
    //   90: dup
    //   91: aload 5
    //   93: getfield 2884	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   96: invokespecial 1562	java/net/URL:<init>	(Ljava/lang/String;)V
    //   99: invokespecial 2886	ram:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;Ljava/net/URL;)V
    //   102: aload 5
    //   104: getfield 2887	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   107: invokestatic 431	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   110: ifne +694 -> 804
    //   113: aload 5
    //   115: getfield 2887	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   118: invokestatic 2890	omr:a	(Ljava/lang/String;)Landroid/graphics/drawable/Drawable;
    //   121: astore 4
    //   123: aload_1
    //   124: getfield 2893	oyj:jdField_a_of_type_AndroidViewViewGroup	Landroid/view/ViewGroup;
    //   127: aload 4
    //   129: invokevirtual 2898	android/view/ViewGroup:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   132: aload_0
    //   133: aload_1
    //   134: getfield 2899	oyj:jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   137: new 1202	java/net/URL
    //   140: dup
    //   141: aload 5
    //   143: getfield 2900	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   146: invokespecial 1562	java/net/URL:<init>	(Ljava/lang/String;)V
    //   149: invokespecial 2886	ram:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;Ljava/net/URL;)V
    //   152: aload_1
    //   153: getfield 2880	oyj:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   156: aload 5
    //   158: getfield 2686	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   161: invokevirtual 2679	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   164: new 837	java/lang/StringBuilder
    //   167: dup
    //   168: invokespecial 838	java/lang/StringBuilder:<init>	()V
    //   171: aload 5
    //   173: getfield 2901	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:jdField_a_of_type_Long	J
    //   176: iconst_1
    //   177: invokestatic 649	ong:a	(JZ)Ljava/lang/String;
    //   180: invokevirtual 842	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: ldc_w 2902
    //   186: invokestatic 1593	ajya:a	(I)Ljava/lang/String;
    //   189: invokevirtual 842	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: invokevirtual 848	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: astore 4
    //   197: new 837	java/lang/StringBuilder
    //   200: dup
    //   201: invokespecial 838	java/lang/StringBuilder:<init>	()V
    //   204: aload 5
    //   206: getfield 2903	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:jdField_b_of_type_Int	I
    //   209: invokestatic 2905	bhvy:b	(I)Ljava/lang/String;
    //   212: invokevirtual 842	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: ldc_w 2906
    //   218: invokestatic 1593	ajya:a	(I)Ljava/lang/String;
    //   221: invokevirtual 842	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: invokevirtual 848	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   227: astore 6
    //   229: new 837	java/lang/StringBuilder
    //   232: dup
    //   233: invokespecial 838	java/lang/StringBuilder:<init>	()V
    //   236: aload 5
    //   238: getfield 2907	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:jdField_c_of_type_Int	I
    //   241: invokevirtual 1211	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   244: ldc_w 2908
    //   247: invokestatic 1593	ajya:a	(I)Ljava/lang/String;
    //   250: invokevirtual 842	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: invokevirtual 848	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   256: astore 7
    //   258: new 837	java/lang/StringBuilder
    //   261: dup
    //   262: invokespecial 838	java/lang/StringBuilder:<init>	()V
    //   265: aload 4
    //   267: invokevirtual 842	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: ldc_w 2910
    //   273: invokevirtual 842	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: aload 6
    //   278: invokevirtual 842	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: ldc_w 2910
    //   284: invokevirtual 842	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: aload 7
    //   289: invokevirtual 842	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: invokevirtual 848	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   295: astore 4
    //   297: aload_1
    //   298: getfield 2911	oyj:jdField_b_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   301: aload 4
    //   303: invokevirtual 2679	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   306: aload 5
    //   308: getfield 2912	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:jdField_a_of_type_Boolean	Z
    //   311: ifeq +558 -> 869
    //   314: aload_1
    //   315: getfield 2913	oyj:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   318: bipush 8
    //   320: invokevirtual 1581	android/widget/TextView:setVisibility	(I)V
    //   323: aload_1
    //   324: getfield 2914	oyj:i	Landroid/widget/TextView;
    //   327: aload 5
    //   329: getfield 2915	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   332: invokevirtual 2679	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   335: aload_1
    //   336: getfield 2918	oyj:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KanDianUrlRoundCornerImageView;
    //   339: aload_0
    //   340: invokevirtual 1269	ram:a	()Landroid/app/Activity;
    //   343: fconst_2
    //   344: invokestatic 1193	baxn:a	(Landroid/content/Context;F)I
    //   347: invokevirtual 2923	com/tencent/biz/pubaccount/readinjoy/view/KanDianUrlRoundCornerImageView:setCorner	(I)V
    //   350: aload_0
    //   351: aload_1
    //   352: getfield 2918	oyj:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KanDianUrlRoundCornerImageView;
    //   355: new 1202	java/net/URL
    //   358: dup
    //   359: aload 5
    //   361: getfield 2924	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   364: invokespecial 1562	java/net/URL:<init>	(Ljava/lang/String;)V
    //   367: invokespecial 2886	ram:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;Ljava/net/URL;)V
    //   370: aload_1
    //   371: getfield 2927	oyj:jdField_a_of_type_AndroidWidgetRelativeLayout	Landroid/widget/RelativeLayout;
    //   374: aload_1
    //   375: invokevirtual 2930	android/widget/RelativeLayout:setTag	(Ljava/lang/Object;)V
    //   378: aload_1
    //   379: getfield 2913	oyj:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   382: aload_1
    //   383: invokevirtual 1802	android/widget/TextView:setTag	(Ljava/lang/Object;)V
    //   386: aload_1
    //   387: getfield 2932	oyj:jdField_b_of_type_AndroidViewViewGroup	Landroid/view/ViewGroup;
    //   390: aload_1
    //   391: invokevirtual 2933	android/view/ViewGroup:setTag	(Ljava/lang/Object;)V
    //   394: aload_1
    //   395: getfield 2918	oyj:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KanDianUrlRoundCornerImageView;
    //   398: aload_1
    //   399: invokevirtual 2934	com/tencent/biz/pubaccount/readinjoy/view/KanDianUrlRoundCornerImageView:setTag	(Ljava/lang/Object;)V
    //   402: aload_1
    //   403: getfield 2914	oyj:i	Landroid/widget/TextView;
    //   406: aload_1
    //   407: invokevirtual 1802	android/widget/TextView:setTag	(Ljava/lang/Object;)V
    //   410: aload_1
    //   411: getfield 2935	oyj:jdField_b_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   414: aload_1
    //   415: invokevirtual 1803	android/widget/ImageView:setTag	(Ljava/lang/Object;)V
    //   418: aload_1
    //   419: getfield 2935	oyj:jdField_b_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   422: aload_0
    //   423: invokevirtual 1792	android/widget/ImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   426: aload_2
    //   427: invokestatic 1806	ram:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lqtv;
    //   430: astore 4
    //   432: aload 4
    //   434: aload_1
    //   435: getfield 2936	oyj:jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   438: putfield 1812	qtv:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   441: aload 4
    //   443: aload_1
    //   444: getfield 2937	oyj:jdField_a_of_type_Int	I
    //   447: putfield 567	qtv:jdField_a_of_type_Int	I
    //   450: aload 4
    //   452: aload_2
    //   453: putfield 1177	qtv:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   456: aload_1
    //   457: aload 4
    //   459: putfield 2938	oyj:jdField_a_of_type_Qtv	Lqtv;
    //   462: aload_1
    //   463: getfield 2939	oyj:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   466: aload_2
    //   467: getfield 874	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mTitle	Ljava/lang/String;
    //   470: invokevirtual 2679	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   473: aload_1
    //   474: getfield 2939	oyj:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   477: invokevirtual 2702	android/widget/TextView:getPaint	()Landroid/text/TextPaint;
    //   480: iconst_1
    //   481: invokevirtual 2707	android/text/TextPaint:setFakeBoldText	(Z)V
    //   484: aload_1
    //   485: getfield 2939	oyj:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   488: aload_0
    //   489: getfield 241	ram:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   492: invokevirtual 1538	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   495: ldc_w 2708
    //   498: invokevirtual 2713	android/content/res/Resources:getColor	(I)I
    //   501: invokevirtual 2693	android/widget/TextView:setTextColor	(I)V
    //   504: aload_2
    //   505: getfield 2942	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mVideoPlayCount	I
    //   508: ifne +372 -> 880
    //   511: aload_1
    //   512: getfield 2943	oyj:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   515: bipush 8
    //   517: invokevirtual 1581	android/widget/TextView:setVisibility	(I)V
    //   520: aload_1
    //   521: getfield 2944	oyj:jdField_f_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   524: aload 4
    //   526: getfield 652	qtv:jdField_b_of_type_Int	I
    //   529: invokestatic 2718	omr:a	(I)Ljava/lang/String;
    //   532: invokevirtual 2679	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   535: aload_0
    //   536: getfield 241	ram:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   539: aload_1
    //   540: getfield 2936	oyj:jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   543: aload_1
    //   544: getfield 2938	oyj:jdField_a_of_type_Qtv	Lqtv;
    //   547: invokestatic 2728	oye:a	(Landroid/content/Context;Landroid/widget/ImageView;Lqtv;)V
    //   550: aload_0
    //   551: aload_1
    //   552: getfield 2936	oyj:jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   555: aload_2
    //   556: iconst_0
    //   557: invokevirtual 1110	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:getVideoCoverUrlWithSmartCut	(Z)Ljava/net/URL;
    //   560: iconst_0
    //   561: invokespecial 1636	ram:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;Ljava/net/URL;Z)V
    //   564: aload_1
    //   565: getfield 2936	oyj:jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   568: aload_0
    //   569: invokevirtual 2732	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setOnLongClickListener	(Landroid/view/View$OnLongClickListener;)V
    //   572: aload_1
    //   573: getfield 2936	oyj:jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   576: aload_1
    //   577: invokevirtual 2945	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setTag	(Ljava/lang/Object;)V
    //   580: aload_1
    //   581: getfield 2944	oyj:jdField_f_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   584: iconst_0
    //   585: invokevirtual 1581	android/widget/TextView:setVisibility	(I)V
    //   588: aload_1
    //   589: getfield 2944	oyj:jdField_f_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   592: invokevirtual 2857	android/widget/TextView:clearAnimation	()V
    //   595: aload_1
    //   596: getfield 2946	oyj:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup	Lcom/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup;
    //   599: fconst_1
    //   600: aload 4
    //   602: getfield 822	qtv:jdField_c_of_type_Int	I
    //   605: aload 4
    //   607: getfield 825	qtv:jdField_d_of_type_Int	I
    //   610: invokestatic 2738	omr:a	(II)F
    //   613: invokevirtual 2744	com/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup:setCustomSize	(FF)V
    //   616: aload_1
    //   617: getfield 2946	oyj:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup	Lcom/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup;
    //   620: aload_1
    //   621: invokevirtual 2745	com/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup:setTag	(Ljava/lang/Object;)V
    //   624: aload_0
    //   625: aload_0
    //   626: getfield 141	ram:jdField_c_of_type_Int	I
    //   629: aload_2
    //   630: getfield 1094	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mArticleID	J
    //   633: invokevirtual 2747	ram:b	(IJ)Z
    //   636: ifeq +23 -> 659
    //   639: aload_1
    //   640: getfield 2947	oyj:jdField_f_of_type_AndroidViewView	Landroid/view/View;
    //   643: aload_0
    //   644: getfield 241	ram:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   647: invokevirtual 1538	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   650: ldc_w 2750
    //   653: invokevirtual 2713	android/content/res/Resources:getColor	(I)I
    //   656: invokevirtual 2753	android/view/View:setBackgroundColor	(I)V
    //   659: aload_2
    //   660: getfield 680	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mXGFileSize	J
    //   663: lconst_0
    //   664: lcmp
    //   665: ifgt +262 -> 927
    //   668: aload_1
    //   669: getfield 2948	oyj:g	Landroid/widget/TextView;
    //   672: ldc_w 2949
    //   675: invokestatic 1593	ajya:a	(I)Ljava/lang/String;
    //   678: invokevirtual 2679	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   681: aload_0
    //   682: getfield 241	ram:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   685: invokestatic 1223	bbfj:h	(Landroid/content/Context;)Z
    //   688: ifeq +278 -> 966
    //   691: aload_1
    //   692: getfield 2950	oyj:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   695: iconst_0
    //   696: invokevirtual 1606	android/widget/ImageView:setVisibility	(I)V
    //   699: aload_1
    //   700: getfield 2948	oyj:g	Landroid/widget/TextView;
    //   703: bipush 8
    //   705: invokevirtual 1581	android/widget/TextView:setVisibility	(I)V
    //   708: aload_1
    //   709: getfield 2951	oyj:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   712: iconst_0
    //   713: invokevirtual 1551	android/view/View:setVisibility	(I)V
    //   716: aload_1
    //   717: getfield 2952	oyj:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   720: iconst_0
    //   721: invokevirtual 2753	android/view/View:setBackgroundColor	(I)V
    //   724: return
    //   725: aload_1
    //   726: getfield 2882	oyj:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   729: invokevirtual 1638	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   732: astore 4
    //   734: aload 4
    //   736: aload_0
    //   737: getfield 241	ram:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   740: ldc_w 2953
    //   743: invokestatic 1193	baxn:a	(Landroid/content/Context;F)I
    //   746: putfield 1655	android/view/ViewGroup$LayoutParams:height	I
    //   749: aload_1
    //   750: getfield 2882	oyj:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   753: aload 4
    //   755: invokevirtual 1668	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   758: goto -687 -> 71
    //   761: aload_1
    //   762: getfield 2882	oyj:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   765: new 606	android/graphics/drawable/ColorDrawable
    //   768: dup
    //   769: ldc_w 2954
    //   772: invokespecial 609	android/graphics/drawable/ColorDrawable:<init>	(I)V
    //   775: invokevirtual 2955	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   778: goto -676 -> 102
    //   781: astore 4
    //   783: invokestatic 338	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   786: ifeq -684 -> 102
    //   789: ldc_w 340
    //   792: iconst_2
    //   793: ldc_w 2957
    //   796: aload 4
    //   798: invokestatic 2960	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   801: goto -699 -> 102
    //   804: new 606	android/graphics/drawable/ColorDrawable
    //   807: dup
    //   808: ldc_w 2954
    //   811: invokespecial 609	android/graphics/drawable/ColorDrawable:<init>	(I)V
    //   814: astore 4
    //   816: goto -693 -> 123
    //   819: astore 4
    //   821: invokestatic 338	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   824: ifeq +15 -> 839
    //   827: ldc_w 340
    //   830: iconst_2
    //   831: ldc_w 2962
    //   834: aload 4
    //   836: invokestatic 2960	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   839: aload_1
    //   840: getfield 2893	oyj:jdField_a_of_type_AndroidViewViewGroup	Landroid/view/ViewGroup;
    //   843: new 606	android/graphics/drawable/ColorDrawable
    //   846: dup
    //   847: ldc_w 2954
    //   850: invokespecial 609	android/graphics/drawable/ColorDrawable:<init>	(I)V
    //   853: invokevirtual 2898	android/view/ViewGroup:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   856: goto -724 -> 132
    //   859: astore 4
    //   861: aload 4
    //   863: invokevirtual 2963	java/net/MalformedURLException:printStackTrace	()V
    //   866: goto -714 -> 152
    //   869: aload_1
    //   870: getfield 2913	oyj:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   873: iconst_0
    //   874: invokevirtual 1581	android/widget/TextView:setVisibility	(I)V
    //   877: goto -554 -> 323
    //   880: aload_1
    //   881: getfield 2943	oyj:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   884: iconst_0
    //   885: invokevirtual 1581	android/widget/TextView:setVisibility	(I)V
    //   888: aload_1
    //   889: getfield 2943	oyj:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   892: new 837	java/lang/StringBuilder
    //   895: dup
    //   896: invokespecial 838	java/lang/StringBuilder:<init>	()V
    //   899: aload_2
    //   900: getfield 2942	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mVideoPlayCount	I
    //   903: invokestatic 2965	qoi:c	(I)Ljava/lang/String;
    //   906: invokevirtual 842	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   909: ldc_w 2966
    //   912: invokestatic 1593	ajya:a	(I)Ljava/lang/String;
    //   915: invokevirtual 842	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   918: invokevirtual 848	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   921: invokevirtual 2679	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   924: goto -404 -> 520
    //   927: aload_1
    //   928: getfield 2948	oyj:g	Landroid/widget/TextView;
    //   931: new 837	java/lang/StringBuilder
    //   934: dup
    //   935: invokespecial 838	java/lang/StringBuilder:<init>	()V
    //   938: aload_2
    //   939: getfield 680	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mXGFileSize	J
    //   942: invokestatic 2764	qoi:b	(J)Ljava/lang/String;
    //   945: invokevirtual 842	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   948: ldc_w 2967
    //   951: invokestatic 1593	ajya:a	(I)Ljava/lang/String;
    //   954: invokevirtual 842	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   957: invokevirtual 848	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   960: invokevirtual 2679	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   963: goto -282 -> 681
    //   966: aload_1
    //   967: getfield 2950	oyj:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   970: bipush 8
    //   972: invokevirtual 1606	android/widget/ImageView:setVisibility	(I)V
    //   975: aload_0
    //   976: getfield 241	ram:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   979: invokevirtual 1538	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   982: ldc_w 2766
    //   985: invokevirtual 2769	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   988: astore 4
    //   990: aload_1
    //   991: getfield 2948	oyj:g	Landroid/widget/TextView;
    //   994: aload 4
    //   996: aconst_null
    //   997: aconst_null
    //   998: aconst_null
    //   999: invokevirtual 2773	android/widget/TextView:setCompoundDrawablesWithIntrinsicBounds	(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V
    //   1002: aload_1
    //   1003: getfield 2948	oyj:g	Landroid/widget/TextView;
    //   1006: ldc_w 2103
    //   1009: aload_0
    //   1010: getfield 241	ram:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   1013: invokevirtual 1538	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   1016: invokestatic 594	actj:a	(FLandroid/content/res/Resources;)I
    //   1019: invokevirtual 2776	android/widget/TextView:setCompoundDrawablePadding	(I)V
    //   1022: aload_1
    //   1023: getfield 2948	oyj:g	Landroid/widget/TextView;
    //   1026: iconst_0
    //   1027: invokevirtual 1581	android/widget/TextView:setVisibility	(I)V
    //   1030: invokestatic 2779	bbwq:a	()I
    //   1033: iconst_1
    //   1034: if_icmpne +42 -> 1076
    //   1037: aload_1
    //   1038: getfield 2948	oyj:g	Landroid/widget/TextView;
    //   1041: ldc_w 2968
    //   1044: invokestatic 1593	ajya:a	(I)Ljava/lang/String;
    //   1047: invokevirtual 2679	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   1050: aload_1
    //   1051: getfield 2969	oyj:h	Landroid/widget/TextView;
    //   1054: bipush 8
    //   1056: invokevirtual 1581	android/widget/TextView:setVisibility	(I)V
    //   1059: aload_1
    //   1060: getfield 2951	oyj:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   1063: iconst_0
    //   1064: invokevirtual 1551	android/view/View:setVisibility	(I)V
    //   1067: aload_1
    //   1068: getfield 2952	oyj:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   1071: iconst_0
    //   1072: invokevirtual 2753	android/view/View:setBackgroundColor	(I)V
    //   1075: return
    //   1076: invokestatic 2784	bhvy:u	()Z
    //   1079: ifeq +296 -> 1375
    //   1082: aload_0
    //   1083: getfield 2785	ram:jdField_h_of_type_Boolean	Z
    //   1086: ifne +289 -> 1375
    //   1089: aload_1
    //   1090: getfield 2937	oyj:jdField_a_of_type_Int	I
    //   1093: ifne +282 -> 1375
    //   1096: invokestatic 2787	bhvy:d	()Ljava/lang/String;
    //   1099: astore 5
    //   1101: invokestatic 2789	bhvy:e	()Ljava/lang/String;
    //   1104: astore 6
    //   1106: invokestatic 2791	bhvy:f	()Ljava/lang/String;
    //   1109: astore 7
    //   1111: aload 5
    //   1113: invokestatic 431	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1116: ifne +217 -> 1333
    //   1119: invokestatic 2793	onh:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1122: astore 8
    //   1124: ldc_w 918
    //   1127: astore 4
    //   1129: aload 8
    //   1131: ifnull +10 -> 1141
    //   1134: aload 8
    //   1136: invokevirtual 2796	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1139: astore 4
    //   1141: new 1335	qzb
    //   1144: dup
    //   1145: aconst_null
    //   1146: aconst_null
    //   1147: aconst_null
    //   1148: aconst_null
    //   1149: invokespecial 1338	qzb:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1152: aload 4
    //   1154: invokevirtual 2799	qzb:l	(Ljava/lang/String;)Lqzb;
    //   1157: aload_2
    //   1158: getfield 781	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:innerUniqueID	Ljava/lang/String;
    //   1161: invokevirtual 2801	qzb:h	(Ljava/lang/String;)Lqzb;
    //   1164: invokevirtual 1361	qzb:a	()Lqza;
    //   1167: invokevirtual 1365	qza:a	()Ljava/lang/String;
    //   1170: astore_2
    //   1171: aload_1
    //   1172: getfield 2969	oyj:h	Landroid/widget/TextView;
    //   1175: iconst_0
    //   1176: invokevirtual 1581	android/widget/TextView:setVisibility	(I)V
    //   1179: aload_1
    //   1180: getfield 2969	oyj:h	Landroid/widget/TextView;
    //   1183: fconst_2
    //   1184: aload_0
    //   1185: getfield 241	ram:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   1188: invokevirtual 1538	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   1191: invokestatic 594	actj:a	(FLandroid/content/res/Resources;)I
    //   1194: invokevirtual 2776	android/widget/TextView:setCompoundDrawablePadding	(I)V
    //   1197: aload_0
    //   1198: getfield 241	ram:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   1201: invokevirtual 1538	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   1204: ldc_w 2802
    //   1207: invokevirtual 2769	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   1210: astore 4
    //   1212: aload 4
    //   1214: iconst_0
    //   1215: iconst_0
    //   1216: ldc_w 2803
    //   1219: aload_0
    //   1220: getfield 241	ram:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   1223: invokevirtual 1538	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   1226: invokestatic 594	actj:a	(FLandroid/content/res/Resources;)I
    //   1229: ldc_w 2803
    //   1232: aload_0
    //   1233: getfield 241	ram:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   1236: invokevirtual 1538	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   1239: invokestatic 594	actj:a	(FLandroid/content/res/Resources;)I
    //   1242: invokevirtual 2808	android/graphics/drawable/Drawable:setBounds	(IIII)V
    //   1245: aload_1
    //   1246: getfield 2969	oyj:h	Landroid/widget/TextView;
    //   1249: aconst_null
    //   1250: aconst_null
    //   1251: aload 4
    //   1253: aconst_null
    //   1254: invokevirtual 2811	android/widget/TextView:setCompoundDrawables	(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V
    //   1257: aload_0
    //   1258: getfield 241	ram:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   1261: aload_1
    //   1262: getfield 2969	oyj:h	Landroid/widget/TextView;
    //   1265: aload 6
    //   1267: aload 7
    //   1269: aload 5
    //   1271: new 2971	rbn
    //   1274: dup
    //   1275: aload_0
    //   1276: aload_2
    //   1277: invokespecial 2972	rbn:<init>	(Lram;Ljava/lang/String;)V
    //   1280: invokestatic 2817	qoi:b	(Landroid/content/Context;Landroid/widget/TextView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/view/View$OnClickListener;)V
    //   1283: aload_1
    //   1284: getfield 2952	oyj:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   1287: ldc_w 2818
    //   1290: invokevirtual 2753	android/view/View:setBackgroundColor	(I)V
    //   1293: aload_1
    //   1294: getfield 2951	oyj:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   1297: iconst_0
    //   1298: invokevirtual 1551	android/view/View:setVisibility	(I)V
    //   1301: aload_0
    //   1302: iconst_1
    //   1303: putfield 2785	ram:jdField_h_of_type_Boolean	Z
    //   1306: aconst_null
    //   1307: ldc_w 918
    //   1310: ldc_w 2820
    //   1313: ldc_w 2820
    //   1316: iconst_0
    //   1317: iconst_0
    //   1318: ldc_w 918
    //   1321: ldc_w 918
    //   1324: ldc_w 918
    //   1327: aload_2
    //   1328: iconst_0
    //   1329: invokestatic 1374	nol:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   1332: return
    //   1333: aload_1
    //   1334: getfield 2969	oyj:h	Landroid/widget/TextView;
    //   1337: bipush 8
    //   1339: invokevirtual 1581	android/widget/TextView:setVisibility	(I)V
    //   1342: aload_1
    //   1343: getfield 2951	oyj:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   1346: iconst_0
    //   1347: invokevirtual 1551	android/view/View:setVisibility	(I)V
    //   1350: aload_1
    //   1351: getfield 2952	oyj:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   1354: iconst_0
    //   1355: invokevirtual 2753	android/view/View:setBackgroundColor	(I)V
    //   1358: invokestatic 338	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1361: ifeq -1357 -> 4
    //   1364: ldc_w 1060
    //   1367: iconst_2
    //   1368: ldc_w 2822
    //   1371: invokestatic 1065	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1374: return
    //   1375: aload_1
    //   1376: getfield 2969	oyj:h	Landroid/widget/TextView;
    //   1379: bipush 8
    //   1381: invokevirtual 1581	android/widget/TextView:setVisibility	(I)V
    //   1384: aload_1
    //   1385: getfield 2951	oyj:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   1388: iconst_0
    //   1389: invokevirtual 1551	android/view/View:setVisibility	(I)V
    //   1392: aload_1
    //   1393: getfield 2952	oyj:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   1396: iconst_0
    //   1397: invokevirtual 2753	android/view/View:setBackgroundColor	(I)V
    //   1400: return
    //   1401: astore 4
    //   1403: goto -1033 -> 370
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1406	0	this	ram
    //   0	1406	1	paramoyj	oyj
    //   0	1406	2	paramBaseArticleInfo	BaseArticleInfo
    //   0	1406	3	paramInt	int
    //   45	709	4	localObject1	Object
    //   781	16	4	localException1	Exception
    //   814	1	4	localColorDrawable	ColorDrawable
    //   819	16	4	localException2	Exception
    //   859	3	4	localMalformedURLException	MalformedURLException
    //   988	264	4	localObject2	Object
    //   1401	1	4	localException3	Exception
    //   27	1243	5	localObject3	Object
    //   227	1039	6	str1	String
    //   256	1012	7	str2	String
    //   1122	13	8	localQQAppInterface	QQAppInterface
    // Exception table:
    //   from	to	target	type
    //   71	102	781	java/lang/Exception
    //   761	778	781	java/lang/Exception
    //   102	123	819	java/lang/Exception
    //   123	132	819	java/lang/Exception
    //   804	816	819	java/lang/Exception
    //   132	152	859	java/net/MalformedURLException
    //   335	370	1401	java/lang/Exception
  }
  
  public void a(oyk paramoyk, BaseArticleInfo paramBaseArticleInfo)
  {
    long l2 = 0L;
    paramoyk.jdField_f_of_type_AndroidViewView.setOnClickListener(null);
    paramoyk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = paramBaseArticleInfo;
    paramoyk.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = ((BaseArticleInfo)paramBaseArticleInfo.mSubArtilceList.get(0));
    paramoyk.jdField_a_of_type_AndroidViewView.setBackgroundColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131167134));
    a(paramoyk.jdField_a_of_type_AndroidViewViewGroup, paramoyk.jdField_b_of_type_AndroidViewViewGroup);
    paramBaseArticleInfo = paramoyk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
    a(paramBaseArticleInfo, paramoyk.jdField_c_of_type_AndroidWidgetTextView, paramoyk.jdField_b_of_type_AndroidViewView, paramoyk.jdField_a_of_type_AndroidWidgetTextView, paramoyk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView);
    a(paramoyk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetRoundAngleFrameLayout);
    paramoyk.jdField_c_of_type_AndroidWidgetTextView.setText(paramBaseArticleInfo.mTitle);
    paramoyk.jdField_c_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
    paramoyk.jdField_d_of_type_AndroidWidgetTextView.setText(qoi.c(paramBaseArticleInfo.mVideoPlayCount));
    a(paramoyk.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, paramoyk.jdField_a_of_type_AndroidWidgetImageView, paramBaseArticleInfo, false);
    paramoyk.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setTag(paramoyk);
    paramoyk.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setOnClickListener(this);
    paramoyk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setTag(paramBaseArticleInfo);
    qoi.a(paramBaseArticleInfo.mVideoArticleSubsText, paramBaseArticleInfo.mVideoArticleSubsColor, paramoyk.jdField_e_of_type_AndroidWidgetTextView);
    if ((paramBaseArticleInfo.isAccountShown) && (this.jdField_c_of_type_Int == 0) && (paramBaseArticleInfo.mPartnerAccountInfo != null))
    {
      paramoyk.jdField_d_of_type_AndroidViewView.setVisibility(0);
      paramoyk.jdField_d_of_type_AndroidViewView.setTag(paramBaseArticleInfo);
      if (!paramBaseArticleInfo.mPartnerAccountInfo.uint64_uin.has()) {
        break label664;
      }
    }
    label664:
    for (long l1 = paramBaseArticleInfo.mPartnerAccountInfo.uint64_uin.get();; l1 = 0L)
    {
      paramoyk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setHeadImgByUin(l1);
      paramoyk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setTag(paramBaseArticleInfo);
      onh.a(paramoyk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView, 10, 10, 10, 10);
      paramBaseArticleInfo = onh.a(paramBaseArticleInfo.mPartnerAccountInfo.bytes_v_icon_url);
      if (!TextUtils.isEmpty(paramBaseArticleInfo)) {}
      try
      {
        paramBaseArticleInfo = new URL(paramBaseArticleInfo);
        paramoyk.jdField_d_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.a(paramBaseArticleInfo);
        label316:
        paramoyk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setNickNameByUin(l1);
        paramoyk.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
        paramoyk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setOnClickListener(this);
        for (;;)
        {
          paramBaseArticleInfo = paramoyk.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
          paramBaseArticleInfo.isTwoItem = true;
          a(paramBaseArticleInfo, paramoyk.jdField_f_of_type_AndroidWidgetTextView, paramoyk.jdField_c_of_type_AndroidViewView, paramoyk.jdField_b_of_type_AndroidWidgetTextView, paramoyk.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView);
          a(paramoyk.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetRoundAngleFrameLayout);
          paramoyk.jdField_f_of_type_AndroidWidgetTextView.setText(paramBaseArticleInfo.mTitle);
          paramoyk.jdField_f_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
          paramoyk.g.setText(qoi.c(paramBaseArticleInfo.mVideoPlayCount));
          a(paramoyk.jdField_e_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, paramoyk.jdField_b_of_type_AndroidWidgetImageView, paramBaseArticleInfo, false);
          paramoyk.jdField_e_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setTag(paramoyk);
          paramoyk.jdField_e_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setOnClickListener(this);
          paramoyk.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setTag(paramBaseArticleInfo);
          qoi.a(paramBaseArticleInfo.mVideoArticleSubsText, paramBaseArticleInfo.mVideoArticleSubsColor, paramoyk.h);
          if ((paramBaseArticleInfo.isAccountShown) && (this.jdField_c_of_type_Int == 0) && (paramBaseArticleInfo.mPartnerAccountInfo != null))
          {
            paramoyk.jdField_e_of_type_AndroidViewView.setVisibility(0);
            paramoyk.jdField_e_of_type_AndroidViewView.setTag(paramBaseArticleInfo);
            l1 = l2;
            if (paramBaseArticleInfo.mPartnerAccountInfo != null)
            {
              l1 = l2;
              if (paramBaseArticleInfo.mPartnerAccountInfo.uint64_uin.has()) {
                l1 = paramBaseArticleInfo.mPartnerAccountInfo.uint64_uin.get();
              }
            }
            paramoyk.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setHeadImgByUin(l1);
            paramoyk.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setTag(paramBaseArticleInfo);
            onh.a(paramoyk.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView, 10, 10, 10, 10);
            paramBaseArticleInfo = onh.a(paramBaseArticleInfo.mPartnerAccountInfo.bytes_v_icon_url);
            if (TextUtils.isEmpty(paramBaseArticleInfo)) {}
          }
          try
          {
            paramBaseArticleInfo = new URL(paramBaseArticleInfo);
            paramoyk.jdField_f_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.a(paramBaseArticleInfo);
            label609:
            paramoyk.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setNickNameByUin(l1);
            paramoyk.jdField_e_of_type_AndroidViewView.setOnClickListener(this);
            paramoyk.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setOnClickListener(this);
            return;
            paramoyk.jdField_d_of_type_AndroidViewView.setVisibility(8);
            continue;
            paramoyk.jdField_e_of_type_AndroidViewView.setVisibility(8);
            return;
          }
          catch (Exception paramBaseArticleInfo)
          {
            break label609;
          }
        }
      }
      catch (Exception paramBaseArticleInfo)
      {
        break label316;
      }
    }
  }
  
  /* Error */
  public void a(oyl paramoyl, BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aload_1
    //   6: aload_2
    //   7: invokestatic 3075	ram:a	(Loyl;Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)V
    //   10: aload_1
    //   11: getfield 1814	oyl:jdField_a_of_type_Qtv	Lqtv;
    //   14: astore 4
    //   16: aload_1
    //   17: getfield 3076	oyl:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   20: aload_2
    //   21: getfield 874	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mTitle	Ljava/lang/String;
    //   24: invokevirtual 2679	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   27: aload_1
    //   28: getfield 3076	oyl:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   31: invokevirtual 2702	android/widget/TextView:getPaint	()Landroid/text/TextPaint;
    //   34: iconst_1
    //   35: invokevirtual 2707	android/text/TextPaint:setFakeBoldText	(Z)V
    //   38: aload_1
    //   39: getfield 3076	oyl:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   42: aload_0
    //   43: getfield 241	ram:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   46: invokevirtual 1538	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   49: ldc_w 2708
    //   52: invokevirtual 2713	android/content/res/Resources:getColor	(I)I
    //   55: invokevirtual 2693	android/widget/TextView:setTextColor	(I)V
    //   58: invokestatic 3081	rlz:a	()Lrlz;
    //   61: invokevirtual 3082	rlz:b	()Z
    //   64: ifeq +75 -> 139
    //   67: aload_1
    //   68: getfield 3083	oyl:jdField_a_of_type_Boolean	Z
    //   71: ifne +20 -> 91
    //   74: aload_1
    //   75: getfield 3085	oyl:jdField_c_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   78: bipush 8
    //   80: invokevirtual 1606	android/widget/ImageView:setVisibility	(I)V
    //   83: aload_1
    //   84: getfield 3086	oyl:jdField_b_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   87: iconst_0
    //   88: invokevirtual 1606	android/widget/ImageView:setVisibility	(I)V
    //   91: aload_2
    //   92: getfield 3090	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:fusionBiuInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/FusionBiuInfo;
    //   95: ifnull +799 -> 894
    //   98: aload_1
    //   99: getfield 3086	oyl:jdField_b_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   102: astore 5
    //   104: aload_2
    //   105: getfield 3090	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:fusionBiuInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/FusionBiuInfo;
    //   108: getfield 3093	com/tencent/biz/pubaccount/readinjoy/struct/FusionBiuInfo:jdField_b_of_type_Boolean	Z
    //   111: ifeq +776 -> 887
    //   114: ldc_w 3094
    //   117: istore_3
    //   118: aload 5
    //   120: iload_3
    //   121: invokevirtual 3097	android/widget/ImageView:setImageResource	(I)V
    //   124: aload_1
    //   125: instanceof 3099
    //   128: ifne +11 -> 139
    //   131: aload_2
    //   132: getfield 3090	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:fusionBiuInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/FusionBiuInfo;
    //   135: iconst_1
    //   136: putfield 3100	com/tencent/biz/pubaccount/readinjoy/struct/FusionBiuInfo:jdField_c_of_type_Boolean	Z
    //   139: aload_2
    //   140: getfield 2942	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mVideoPlayCount	I
    //   143: ifne +764 -> 907
    //   146: aload_1
    //   147: getfield 3101	oyl:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   150: bipush 8
    //   152: invokevirtual 1581	android/widget/TextView:setVisibility	(I)V
    //   155: aload_1
    //   156: getfield 3102	oyl:jdField_b_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   159: aload 4
    //   161: getfield 652	qtv:jdField_b_of_type_Int	I
    //   164: invokestatic 2718	omr:a	(I)Ljava/lang/String;
    //   167: invokevirtual 2679	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   170: aload_0
    //   171: aload_1
    //   172: getfield 3103	oyl:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyNickNameTextView;
    //   175: aload_2
    //   176: aload_2
    //   177: invokestatic 501	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:isAdvertisementInfo	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Z
    //   180: invokespecial 3105	ram:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyNickNameTextView;Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;Z)V
    //   183: aload_0
    //   184: aload_1
    //   185: getfield 3106	oyl:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyHeadImageView;
    //   188: aload_2
    //   189: invokespecial 3108	ram:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyHeadImageView;Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)V
    //   192: aload_1
    //   193: getfield 3106	oyl:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyHeadImageView;
    //   196: aload_2
    //   197: invokevirtual 1755	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:getSubscribeName	()Ljava/lang/String;
    //   200: invokevirtual 3111	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyHeadImageView:setContentDescription	(Ljava/lang/CharSequence;)V
    //   203: aload_1
    //   204: getfield 3103	oyl:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyNickNameTextView;
    //   207: iconst_0
    //   208: invokevirtual 3112	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyNickNameTextView:setVisibility	(I)V
    //   211: aload_1
    //   212: getfield 3103	oyl:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyNickNameTextView;
    //   215: aload_2
    //   216: invokevirtual 1755	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:getSubscribeName	()Ljava/lang/String;
    //   219: invokevirtual 3113	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyNickNameTextView:setContentDescription	(Ljava/lang/CharSequence;)V
    //   222: aload_1
    //   223: getfield 3114	oyl:jdField_a_of_type_AndroidViewViewGroup	Landroid/view/ViewGroup;
    //   226: aload_2
    //   227: invokevirtual 2933	android/view/ViewGroup:setTag	(Ljava/lang/Object;)V
    //   230: aload_1
    //   231: getfield 3114	oyl:jdField_a_of_type_AndroidViewViewGroup	Landroid/view/ViewGroup;
    //   234: aload_0
    //   235: invokevirtual 3115	android/view/ViewGroup:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   238: aload_2
    //   239: getfield 2840	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:vIconUrl	Ljava/lang/String;
    //   242: invokestatic 431	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   245: ifne +719 -> 964
    //   248: new 1202	java/net/URL
    //   251: dup
    //   252: aload_2
    //   253: getfield 2840	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:vIconUrl	Ljava/lang/String;
    //   256: invokespecial 1562	java/net/URL:<init>	(Ljava/lang/String;)V
    //   259: astore 5
    //   261: aload_1
    //   262: getfield 3116	oyl:jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   265: aload 5
    //   267: invokevirtual 2685	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:a	(Ljava/net/URL;)Lcom/tencent/biz/pubaccount/readinjoy/view/imageloader/ZImageView;
    //   270: pop
    //   271: aload_1
    //   272: getfield 3116	oyl:jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   275: iconst_0
    //   276: invokevirtual 1580	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setVisibility	(I)V
    //   279: aload_2
    //   280: invokestatic 501	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:isAdvertisementInfo	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Z
    //   283: ifeq +847 -> 1130
    //   286: aload_2
    //   287: checkcast 498	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo
    //   290: astore 5
    //   292: aload_1
    //   293: getfield 1798	oyl:h	Landroid/widget/TextView;
    //   296: iconst_0
    //   297: invokevirtual 1581	android/widget/TextView:setVisibility	(I)V
    //   300: invokestatic 1183	onh:s	()Z
    //   303: ifeq +673 -> 976
    //   306: aload_1
    //   307: getfield 1798	oyl:h	Landroid/widget/TextView;
    //   310: aconst_null
    //   311: invokestatic 3121	oky:a	(Landroid/view/View;Landroid/graphics/drawable/Drawable;)V
    //   314: aload_1
    //   315: getfield 1798	oyl:h	Landroid/widget/TextView;
    //   318: ldc_w 3123
    //   321: invokestatic 130	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   324: invokevirtual 2693	android/widget/TextView:setTextColor	(I)V
    //   327: aload_1
    //   328: getfield 1795	oyl:i	Landroid/widget/TextView;
    //   331: ldc_w 3125
    //   334: invokestatic 130	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   337: invokevirtual 2693	android/widget/TextView:setTextColor	(I)V
    //   340: aload_2
    //   341: getfield 2826	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mArticleSubscriptText	Ljava/lang/String;
    //   344: invokestatic 431	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   347: ifne +652 -> 999
    //   350: aload_1
    //   351: getfield 1798	oyl:h	Landroid/widget/TextView;
    //   354: aload_2
    //   355: getfield 2826	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mArticleSubscriptText	Ljava/lang/String;
    //   358: invokevirtual 2679	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   361: aload_1
    //   362: getfield 3128	oyl:jdField_b_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   365: iconst_0
    //   366: invokevirtual 3131	android/widget/LinearLayout:setVisibility	(I)V
    //   369: aload_2
    //   370: invokestatic 1707	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:isAppAdvertisementInfo	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Z
    //   373: ifeq +688 -> 1061
    //   376: iconst_0
    //   377: istore_3
    //   378: new 977	org/json/JSONObject
    //   381: dup
    //   382: aload 5
    //   384: getfield 1710	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdExt	Ljava/lang/String;
    //   387: invokespecial 980	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   390: astore 6
    //   392: aload_0
    //   393: getfield 241	ram:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   396: aload 6
    //   398: ldc_w 3133
    //   401: invokevirtual 3136	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   404: invokestatic 3141	bbfr:a	(Landroid/content/Context;Ljava/lang/String;)Z
    //   407: ifeq +612 -> 1019
    //   410: aload_1
    //   411: getfield 1795	oyl:i	Landroid/widget/TextView;
    //   414: aload_0
    //   415: getfield 241	ram:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   418: ldc_w 3142
    //   421: invokevirtual 2441	android/app/Activity:getString	(I)Ljava/lang/String;
    //   424: invokevirtual 2679	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   427: iconst_1
    //   428: istore_3
    //   429: aload 5
    //   431: getfield 3145	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdBtnTxt	Ljava/lang/String;
    //   434: invokestatic 431	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   437: ifne +19 -> 456
    //   440: iload_3
    //   441: ifne +15 -> 456
    //   444: aload_1
    //   445: getfield 1795	oyl:i	Landroid/widget/TextView;
    //   448: aload 5
    //   450: getfield 3145	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdBtnTxt	Ljava/lang/String;
    //   453: invokevirtual 2679	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   456: new 977	org/json/JSONObject
    //   459: dup
    //   460: aload 5
    //   462: getfield 3148	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdExtInfo	Ljava/lang/String;
    //   465: invokespecial 980	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   468: astore 5
    //   470: aload 5
    //   472: ldc_w 3150
    //   475: invokevirtual 3136	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   478: invokestatic 431	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   481: ifne +18 -> 499
    //   484: aload_1
    //   485: getfield 1798	oyl:h	Landroid/widget/TextView;
    //   488: aload 5
    //   490: ldc_w 3150
    //   493: invokevirtual 3136	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   496: invokevirtual 2679	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   499: aload_0
    //   500: aload_1
    //   501: invokespecial 3152	ram:a	(Loyl;)V
    //   504: aload_1
    //   505: getfield 3155	oyl:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyVideoInfoViewGroup	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyVideoInfoViewGroup;
    //   508: bipush 8
    //   510: invokevirtual 3158	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyVideoInfoViewGroup:setVisibility	(I)V
    //   513: aload_1
    //   514: getfield 3160	oyl:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   517: bipush 8
    //   519: invokevirtual 3131	android/widget/LinearLayout:setVisibility	(I)V
    //   522: aload_0
    //   523: getfield 241	ram:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   526: aload_1
    //   527: getfield 1809	oyl:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   530: aload_1
    //   531: getfield 1814	oyl:jdField_a_of_type_Qtv	Lqtv;
    //   534: invokestatic 2728	oye:a	(Landroid/content/Context;Landroid/widget/ImageView;Lqtv;)V
    //   537: aload_0
    //   538: aload_1
    //   539: getfield 1809	oyl:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   542: aload_2
    //   543: iconst_0
    //   544: invokevirtual 1110	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:getVideoCoverUrlWithSmartCut	(Z)Ljava/net/URL;
    //   547: iconst_0
    //   548: invokespecial 1636	ram:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;Ljava/net/URL;Z)V
    //   551: aload_1
    //   552: getfield 1809	oyl:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   555: aload_0
    //   556: invokevirtual 1579	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   559: aload_1
    //   560: getfield 1809	oyl:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   563: aload_0
    //   564: invokevirtual 2732	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setOnLongClickListener	(Landroid/view/View$OnLongClickListener;)V
    //   567: aload_1
    //   568: getfield 1809	oyl:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   571: aload_1
    //   572: invokevirtual 2945	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setTag	(Ljava/lang/Object;)V
    //   575: aload_1
    //   576: getfield 3102	oyl:jdField_b_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   579: iconst_0
    //   580: invokevirtual 1581	android/widget/TextView:setVisibility	(I)V
    //   583: aload_1
    //   584: getfield 3102	oyl:jdField_b_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   587: invokevirtual 2857	android/widget/TextView:clearAnimation	()V
    //   590: aload_1
    //   591: getfield 3161	oyl:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup	Lcom/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup;
    //   594: fconst_1
    //   595: aload 4
    //   597: getfield 822	qtv:jdField_c_of_type_Int	I
    //   600: aload 4
    //   602: getfield 825	qtv:jdField_d_of_type_Int	I
    //   605: invokestatic 2738	omr:a	(II)F
    //   608: invokevirtual 2744	com/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup:setCustomSize	(FF)V
    //   611: aload_1
    //   612: getfield 3161	oyl:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup	Lcom/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup;
    //   615: aload_0
    //   616: invokevirtual 3162	com/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   619: aload_1
    //   620: getfield 3161	oyl:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup	Lcom/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup;
    //   623: aload_1
    //   624: invokevirtual 2745	com/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup:setTag	(Ljava/lang/Object;)V
    //   627: aload_0
    //   628: aload_0
    //   629: getfield 141	ram:jdField_c_of_type_Int	I
    //   632: aload_2
    //   633: getfield 1094	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mArticleID	J
    //   636: invokevirtual 2747	ram:b	(IJ)Z
    //   639: ifeq +23 -> 662
    //   642: aload_1
    //   643: getfield 3163	oyl:jdField_f_of_type_AndroidViewView	Landroid/view/View;
    //   646: aload_0
    //   647: getfield 241	ram:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   650: invokevirtual 1538	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   653: ldc_w 2750
    //   656: invokevirtual 2713	android/content/res/Resources:getColor	(I)I
    //   659: invokevirtual 2753	android/view/View:setBackgroundColor	(I)V
    //   662: aload_0
    //   663: invokevirtual 1269	ram:a	()Landroid/app/Activity;
    //   666: aload_1
    //   667: getfield 3164	oyl:jdField_b_of_type_AndroidViewViewGroup	Landroid/view/ViewGroup;
    //   670: aload_1
    //   671: getfield 3165	oyl:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetRoundAngleFrameLayout	Lcom/tencent/biz/pubaccount/readinjoy/view/widget/RoundAngleFrameLayout;
    //   674: invokestatic 3168	onp:a	(Landroid/content/Context;Landroid/view/View;Lcom/tencent/biz/pubaccount/readinjoy/view/widget/RoundAngleFrameLayout;)V
    //   677: invokestatic 1183	onh:s	()Z
    //   680: ifeq +567 -> 1247
    //   683: aload_1
    //   684: getfield 3169	oyl:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   687: aload_0
    //   688: invokevirtual 1269	ram:a	()Landroid/app/Activity;
    //   691: ldc_w 1537
    //   694: invokestatic 1193	baxn:a	(Landroid/content/Context;F)I
    //   697: invokevirtual 2776	android/widget/TextView:setCompoundDrawablePadding	(I)V
    //   700: aload_0
    //   701: invokevirtual 1269	ram:a	()Landroid/app/Activity;
    //   704: invokevirtual 1538	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   707: ldc_w 3170
    //   710: invokevirtual 2769	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   713: astore 4
    //   715: aload_0
    //   716: invokevirtual 1269	ram:a	()Landroid/app/Activity;
    //   719: ldc_w 3171
    //   722: invokestatic 1193	baxn:a	(Landroid/content/Context;F)I
    //   725: istore_3
    //   726: aload 4
    //   728: iconst_0
    //   729: iconst_0
    //   730: iload_3
    //   731: iload_3
    //   732: invokevirtual 2808	android/graphics/drawable/Drawable:setBounds	(IIII)V
    //   735: aload_1
    //   736: getfield 3169	oyl:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   739: aload 4
    //   741: aconst_null
    //   742: aconst_null
    //   743: aconst_null
    //   744: invokevirtual 2811	android/widget/TextView:setCompoundDrawables	(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V
    //   747: aload_1
    //   748: getfield 3165	oyl:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetRoundAngleFrameLayout	Lcom/tencent/biz/pubaccount/readinjoy/view/widget/RoundAngleFrameLayout;
    //   751: aload_0
    //   752: invokevirtual 3172	com/tencent/biz/pubaccount/readinjoy/view/widget/RoundAngleFrameLayout:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   755: aload_1
    //   756: getfield 3165	oyl:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetRoundAngleFrameLayout	Lcom/tencent/biz/pubaccount/readinjoy/view/widget/RoundAngleFrameLayout;
    //   759: aload_1
    //   760: invokevirtual 3173	com/tencent/biz/pubaccount/readinjoy/view/widget/RoundAngleFrameLayout:setTag	(Ljava/lang/Object;)V
    //   763: aload_1
    //   764: getfield 3169	oyl:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   767: aload_2
    //   768: invokevirtual 1588	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:getCommentCount	()I
    //   771: ldc_w 3174
    //   774: invokestatic 1593	ajya:a	(I)Ljava/lang/String;
    //   777: invokestatic 3177	qoi:a	(Landroid/widget/TextView;ILjava/lang/String;)V
    //   780: aload_1
    //   781: getfield 3169	oyl:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   784: aload_0
    //   785: invokevirtual 1796	android/widget/TextView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   788: aload_1
    //   789: getfield 3169	oyl:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   792: aload_1
    //   793: invokevirtual 1802	android/widget/TextView:setTag	(Ljava/lang/Object;)V
    //   796: aload_1
    //   797: getfield 3178	oyl:jdField_a_of_type_AndroidWidgetRelativeLayout	Landroid/widget/RelativeLayout;
    //   800: aload_0
    //   801: invokevirtual 3179	android/widget/RelativeLayout:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   804: aload_1
    //   805: getfield 3178	oyl:jdField_a_of_type_AndroidWidgetRelativeLayout	Landroid/widget/RelativeLayout;
    //   808: aload_1
    //   809: invokevirtual 2930	android/widget/RelativeLayout:setTag	(Ljava/lang/Object;)V
    //   812: aload_2
    //   813: getfield 680	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mXGFileSize	J
    //   816: lconst_0
    //   817: lcmp
    //   818: ifgt +474 -> 1292
    //   821: aload_1
    //   822: getfield 3180	oyl:jdField_f_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   825: ldc_w 3181
    //   828: invokestatic 1593	ajya:a	(I)Ljava/lang/String;
    //   831: invokevirtual 2679	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   834: aload_0
    //   835: getfield 241	ram:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   838: invokestatic 1223	bbfj:h	(Landroid/content/Context;)Z
    //   841: ifeq +490 -> 1331
    //   844: aload_1
    //   845: getfield 3183	oyl:jdField_d_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   848: iconst_0
    //   849: invokevirtual 1606	android/widget/ImageView:setVisibility	(I)V
    //   852: aload_1
    //   853: getfield 3180	oyl:jdField_f_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   856: bipush 8
    //   858: invokevirtual 1581	android/widget/TextView:setVisibility	(I)V
    //   861: aload_1
    //   862: getfield 3184	oyl:jdField_e_of_type_AndroidViewView	Landroid/view/View;
    //   865: iconst_0
    //   866: invokevirtual 1551	android/view/View:setVisibility	(I)V
    //   869: aload_1
    //   870: getfield 3185	oyl:jdField_d_of_type_AndroidViewView	Landroid/view/View;
    //   873: iconst_0
    //   874: invokevirtual 2753	android/view/View:setBackgroundColor	(I)V
    //   877: aload_1
    //   878: getfield 3186	oyl:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   881: bipush 8
    //   883: invokevirtual 1551	android/view/View:setVisibility	(I)V
    //   886: return
    //   887: ldc_w 3187
    //   890: istore_3
    //   891: goto -773 -> 118
    //   894: aload_1
    //   895: getfield 3086	oyl:jdField_b_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   898: ldc_w 3187
    //   901: invokevirtual 3097	android/widget/ImageView:setImageResource	(I)V
    //   904: goto -765 -> 139
    //   907: aload_1
    //   908: getfield 3101	oyl:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   911: iconst_0
    //   912: invokevirtual 1581	android/widget/TextView:setVisibility	(I)V
    //   915: aload_1
    //   916: getfield 3101	oyl:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   919: new 837	java/lang/StringBuilder
    //   922: dup
    //   923: invokespecial 838	java/lang/StringBuilder:<init>	()V
    //   926: aload_2
    //   927: getfield 2942	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mVideoPlayCount	I
    //   930: invokestatic 2965	qoi:c	(I)Ljava/lang/String;
    //   933: invokevirtual 842	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   936: ldc_w 3188
    //   939: invokestatic 1593	ajya:a	(I)Ljava/lang/String;
    //   942: invokevirtual 842	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   945: invokevirtual 848	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   948: invokevirtual 2679	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   951: goto -796 -> 155
    //   954: astore 5
    //   956: aload 5
    //   958: invokevirtual 2761	java/lang/Exception:printStackTrace	()V
    //   961: goto -682 -> 279
    //   964: aload_1
    //   965: getfield 3116	oyl:jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   968: bipush 8
    //   970: invokevirtual 1580	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setVisibility	(I)V
    //   973: goto -694 -> 279
    //   976: aload_1
    //   977: getfield 1798	oyl:h	Landroid/widget/TextView;
    //   980: ldc_w 3190
    //   983: invokestatic 130	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   986: aload_0
    //   987: getfield 241	ram:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   990: invokestatic 3193	oar:a	(ILandroid/content/Context;)Landroid/graphics/drawable/ShapeDrawable;
    //   993: invokestatic 3121	oky:a	(Landroid/view/View;Landroid/graphics/drawable/Drawable;)V
    //   996: goto -656 -> 340
    //   999: aload_1
    //   1000: getfield 1798	oyl:h	Landroid/widget/TextView;
    //   1003: aload_0
    //   1004: getfield 241	ram:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   1007: ldc_w 3194
    //   1010: invokevirtual 2441	android/app/Activity:getString	(I)Ljava/lang/String;
    //   1013: invokevirtual 2679	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   1016: goto -655 -> 361
    //   1019: aload_1
    //   1020: getfield 1795	oyl:i	Landroid/widget/TextView;
    //   1023: aload_0
    //   1024: getfield 241	ram:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   1027: ldc_w 3195
    //   1030: invokevirtual 2441	android/app/Activity:getString	(I)Ljava/lang/String;
    //   1033: invokevirtual 2679	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   1036: goto -607 -> 429
    //   1039: astore 6
    //   1041: aload_1
    //   1042: getfield 1795	oyl:i	Landroid/widget/TextView;
    //   1045: aload_0
    //   1046: getfield 241	ram:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   1049: ldc_w 3196
    //   1052: invokevirtual 2441	android/app/Activity:getString	(I)Ljava/lang/String;
    //   1055: invokevirtual 2679	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   1058: goto -629 -> 429
    //   1061: aload 5
    //   1063: getfield 3145	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdBtnTxt	Ljava/lang/String;
    //   1066: invokestatic 431	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1069: ifne +18 -> 1087
    //   1072: aload_1
    //   1073: getfield 1795	oyl:i	Landroid/widget/TextView;
    //   1076: aload 5
    //   1078: getfield 3145	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdBtnTxt	Ljava/lang/String;
    //   1081: invokevirtual 2679	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   1084: goto -628 -> 456
    //   1087: aload_1
    //   1088: getfield 1795	oyl:i	Landroid/widget/TextView;
    //   1091: aload_0
    //   1092: getfield 241	ram:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   1095: ldc_w 3196
    //   1098: invokevirtual 2441	android/app/Activity:getString	(I)Ljava/lang/String;
    //   1101: invokevirtual 2679	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   1104: goto -648 -> 456
    //   1107: astore 5
    //   1109: invokestatic 338	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1112: ifeq -613 -> 499
    //   1115: ldc_w 340
    //   1118: iconst_2
    //   1119: ldc_w 3198
    //   1122: aload 5
    //   1124: invokestatic 2960	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1127: goto -628 -> 499
    //   1130: aload_1
    //   1131: getfield 1798	oyl:h	Landroid/widget/TextView;
    //   1134: bipush 8
    //   1136: invokevirtual 1581	android/widget/TextView:setVisibility	(I)V
    //   1139: aload_1
    //   1140: getfield 3128	oyl:jdField_b_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   1143: bipush 8
    //   1145: invokevirtual 3131	android/widget/LinearLayout:setVisibility	(I)V
    //   1148: aload_1
    //   1149: getfield 3155	oyl:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyVideoInfoViewGroup	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyVideoInfoViewGroup;
    //   1152: iconst_0
    //   1153: invokevirtual 3158	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyVideoInfoViewGroup:setVisibility	(I)V
    //   1156: aload_1
    //   1157: getfield 3160	oyl:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   1160: iconst_0
    //   1161: invokevirtual 3131	android/widget/LinearLayout:setVisibility	(I)V
    //   1164: aload_1
    //   1165: getfield 3155	oyl:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyVideoInfoViewGroup	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyVideoInfoViewGroup;
    //   1168: aload_2
    //   1169: aload_0
    //   1170: aload_0
    //   1171: getfield 141	ram:jdField_c_of_type_Int	I
    //   1174: aload_0
    //   1175: getfield 274	ram:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   1178: invokevirtual 3202	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyVideoInfoViewGroup:setArticleInfo	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;Landroid/widget/BaseAdapter;ILjava/util/Set;)V
    //   1181: aload_1
    //   1182: getfield 3203	oyl:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   1185: aload_0
    //   1186: invokevirtual 1792	android/widget/ImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   1189: aload_1
    //   1190: getfield 3203	oyl:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   1193: aload_1
    //   1194: invokevirtual 1803	android/widget/ImageView:setTag	(Ljava/lang/Object;)V
    //   1197: aload_1
    //   1198: getfield 3085	oyl:jdField_c_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   1201: ifnull +19 -> 1220
    //   1204: aload_1
    //   1205: getfield 3085	oyl:jdField_c_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   1208: aload_0
    //   1209: invokevirtual 1792	android/widget/ImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   1212: aload_1
    //   1213: getfield 3085	oyl:jdField_c_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   1216: aload_1
    //   1217: invokevirtual 1803	android/widget/ImageView:setTag	(Ljava/lang/Object;)V
    //   1220: aload_1
    //   1221: getfield 3086	oyl:jdField_b_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   1224: aload_0
    //   1225: invokevirtual 1792	android/widget/ImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   1228: aload_1
    //   1229: getfield 3086	oyl:jdField_b_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   1232: aload_0
    //   1233: invokevirtual 3204	android/widget/ImageView:setOnLongClickListener	(Landroid/view/View$OnLongClickListener;)V
    //   1236: aload_1
    //   1237: getfield 3086	oyl:jdField_b_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   1240: aload_1
    //   1241: invokevirtual 1803	android/widget/ImageView:setTag	(Ljava/lang/Object;)V
    //   1244: goto -722 -> 522
    //   1247: aload_1
    //   1248: getfield 3169	oyl:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   1251: aload_0
    //   1252: invokevirtual 1269	ram:a	()Landroid/app/Activity;
    //   1255: fconst_0
    //   1256: invokestatic 1193	baxn:a	(Landroid/content/Context;F)I
    //   1259: invokevirtual 2776	android/widget/TextView:setCompoundDrawablePadding	(I)V
    //   1262: aload_0
    //   1263: invokevirtual 1269	ram:a	()Landroid/app/Activity;
    //   1266: invokevirtual 1538	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   1269: ldc_w 3205
    //   1272: invokevirtual 2769	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   1275: astore 4
    //   1277: aload_1
    //   1278: getfield 3169	oyl:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   1281: aload 4
    //   1283: aconst_null
    //   1284: aconst_null
    //   1285: aconst_null
    //   1286: invokevirtual 2773	android/widget/TextView:setCompoundDrawablesWithIntrinsicBounds	(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V
    //   1289: goto -542 -> 747
    //   1292: aload_1
    //   1293: getfield 3180	oyl:jdField_f_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   1296: new 837	java/lang/StringBuilder
    //   1299: dup
    //   1300: invokespecial 838	java/lang/StringBuilder:<init>	()V
    //   1303: aload_2
    //   1304: getfield 680	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mXGFileSize	J
    //   1307: invokestatic 2764	qoi:b	(J)Ljava/lang/String;
    //   1310: invokevirtual 842	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1313: ldc_w 3206
    //   1316: invokestatic 1593	ajya:a	(I)Ljava/lang/String;
    //   1319: invokevirtual 842	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1322: invokevirtual 848	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1325: invokevirtual 2679	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   1328: goto -494 -> 834
    //   1331: aload_1
    //   1332: getfield 3183	oyl:jdField_d_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   1335: bipush 8
    //   1337: invokevirtual 1606	android/widget/ImageView:setVisibility	(I)V
    //   1340: aload_0
    //   1341: getfield 241	ram:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   1344: invokevirtual 1538	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   1347: ldc_w 2766
    //   1350: invokevirtual 2769	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   1353: astore 4
    //   1355: aload_1
    //   1356: getfield 3180	oyl:jdField_f_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   1359: aload 4
    //   1361: aconst_null
    //   1362: aconst_null
    //   1363: aconst_null
    //   1364: invokevirtual 2773	android/widget/TextView:setCompoundDrawablesWithIntrinsicBounds	(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V
    //   1367: aload_1
    //   1368: getfield 3180	oyl:jdField_f_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   1371: ldc_w 2103
    //   1374: aload_0
    //   1375: getfield 241	ram:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   1378: invokevirtual 1538	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   1381: invokestatic 594	actj:a	(FLandroid/content/res/Resources;)I
    //   1384: invokevirtual 2776	android/widget/TextView:setCompoundDrawablePadding	(I)V
    //   1387: aload_1
    //   1388: getfield 3180	oyl:jdField_f_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   1391: iconst_0
    //   1392: invokevirtual 1581	android/widget/TextView:setVisibility	(I)V
    //   1395: invokestatic 2779	bbwq:a	()I
    //   1398: iconst_1
    //   1399: if_icmpne +44 -> 1443
    //   1402: aload_1
    //   1403: getfield 3180	oyl:jdField_f_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   1406: ldc_w 3207
    //   1409: invokestatic 1593	ajya:a	(I)Ljava/lang/String;
    //   1412: invokevirtual 2679	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   1415: aload_1
    //   1416: getfield 3208	oyl:g	Landroid/widget/TextView;
    //   1419: bipush 8
    //   1421: invokevirtual 1581	android/widget/TextView:setVisibility	(I)V
    //   1424: aload_1
    //   1425: getfield 3184	oyl:jdField_e_of_type_AndroidViewView	Landroid/view/View;
    //   1428: iconst_0
    //   1429: invokevirtual 1551	android/view/View:setVisibility	(I)V
    //   1432: aload_1
    //   1433: getfield 3185	oyl:jdField_d_of_type_AndroidViewView	Landroid/view/View;
    //   1436: iconst_0
    //   1437: invokevirtual 2753	android/view/View:setBackgroundColor	(I)V
    //   1440: goto -563 -> 877
    //   1443: invokestatic 2784	bhvy:u	()Z
    //   1446: ifeq +300 -> 1746
    //   1449: aload_0
    //   1450: getfield 2785	ram:jdField_h_of_type_Boolean	Z
    //   1453: ifne +293 -> 1746
    //   1456: aload_1
    //   1457: getfield 1280	oyl:jdField_a_of_type_Int	I
    //   1460: ifne +286 -> 1746
    //   1463: invokestatic 2787	bhvy:d	()Ljava/lang/String;
    //   1466: astore 5
    //   1468: invokestatic 2789	bhvy:e	()Ljava/lang/String;
    //   1471: astore 6
    //   1473: invokestatic 2791	bhvy:f	()Ljava/lang/String;
    //   1476: astore 7
    //   1478: aload 5
    //   1480: invokestatic 431	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1483: ifne +219 -> 1702
    //   1486: invokestatic 2793	onh:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1489: astore 8
    //   1491: ldc_w 918
    //   1494: astore 4
    //   1496: aload 8
    //   1498: ifnull +10 -> 1508
    //   1501: aload 8
    //   1503: invokevirtual 2796	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1506: astore 4
    //   1508: new 1335	qzb
    //   1511: dup
    //   1512: aconst_null
    //   1513: aconst_null
    //   1514: aconst_null
    //   1515: aconst_null
    //   1516: invokespecial 1338	qzb:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1519: aload 4
    //   1521: invokevirtual 2799	qzb:l	(Ljava/lang/String;)Lqzb;
    //   1524: aload_2
    //   1525: getfield 781	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:innerUniqueID	Ljava/lang/String;
    //   1528: invokevirtual 2801	qzb:h	(Ljava/lang/String;)Lqzb;
    //   1531: invokevirtual 1361	qzb:a	()Lqza;
    //   1534: invokevirtual 1365	qza:a	()Ljava/lang/String;
    //   1537: astore_2
    //   1538: aload_1
    //   1539: getfield 3208	oyl:g	Landroid/widget/TextView;
    //   1542: iconst_0
    //   1543: invokevirtual 1581	android/widget/TextView:setVisibility	(I)V
    //   1546: aload_1
    //   1547: getfield 3208	oyl:g	Landroid/widget/TextView;
    //   1550: fconst_2
    //   1551: aload_0
    //   1552: getfield 241	ram:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   1555: invokevirtual 1538	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   1558: invokestatic 594	actj:a	(FLandroid/content/res/Resources;)I
    //   1561: invokevirtual 2776	android/widget/TextView:setCompoundDrawablePadding	(I)V
    //   1564: aload_0
    //   1565: getfield 241	ram:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   1568: invokevirtual 1538	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   1571: ldc_w 2802
    //   1574: invokevirtual 2769	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   1577: astore 4
    //   1579: aload 4
    //   1581: iconst_0
    //   1582: iconst_0
    //   1583: ldc_w 2803
    //   1586: aload_0
    //   1587: getfield 241	ram:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   1590: invokevirtual 1538	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   1593: invokestatic 594	actj:a	(FLandroid/content/res/Resources;)I
    //   1596: ldc_w 2803
    //   1599: aload_0
    //   1600: getfield 241	ram:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   1603: invokevirtual 1538	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   1606: invokestatic 594	actj:a	(FLandroid/content/res/Resources;)I
    //   1609: invokevirtual 2808	android/graphics/drawable/Drawable:setBounds	(IIII)V
    //   1612: aload_1
    //   1613: getfield 3208	oyl:g	Landroid/widget/TextView;
    //   1616: aconst_null
    //   1617: aconst_null
    //   1618: aload 4
    //   1620: aconst_null
    //   1621: invokevirtual 2811	android/widget/TextView:setCompoundDrawables	(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V
    //   1624: aload_0
    //   1625: getfield 241	ram:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   1628: aload_1
    //   1629: getfield 3208	oyl:g	Landroid/widget/TextView;
    //   1632: aload 6
    //   1634: aload 7
    //   1636: aload 5
    //   1638: new 3210	rbk
    //   1641: dup
    //   1642: aload_0
    //   1643: aload_2
    //   1644: invokespecial 3211	rbk:<init>	(Lram;Ljava/lang/String;)V
    //   1647: invokestatic 2817	qoi:b	(Landroid/content/Context;Landroid/widget/TextView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/view/View$OnClickListener;)V
    //   1650: aload_1
    //   1651: getfield 3185	oyl:jdField_d_of_type_AndroidViewView	Landroid/view/View;
    //   1654: ldc_w 2818
    //   1657: invokevirtual 2753	android/view/View:setBackgroundColor	(I)V
    //   1660: aload_1
    //   1661: getfield 3184	oyl:jdField_e_of_type_AndroidViewView	Landroid/view/View;
    //   1664: iconst_0
    //   1665: invokevirtual 1551	android/view/View:setVisibility	(I)V
    //   1668: aload_0
    //   1669: iconst_1
    //   1670: putfield 2785	ram:jdField_h_of_type_Boolean	Z
    //   1673: aconst_null
    //   1674: ldc_w 918
    //   1677: ldc_w 2820
    //   1680: ldc_w 2820
    //   1683: iconst_0
    //   1684: iconst_0
    //   1685: ldc_w 918
    //   1688: ldc_w 918
    //   1691: ldc_w 918
    //   1694: aload_2
    //   1695: iconst_0
    //   1696: invokestatic 1374	nol:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   1699: goto -822 -> 877
    //   1702: aload_1
    //   1703: getfield 3208	oyl:g	Landroid/widget/TextView;
    //   1706: bipush 8
    //   1708: invokevirtual 1581	android/widget/TextView:setVisibility	(I)V
    //   1711: aload_1
    //   1712: getfield 3184	oyl:jdField_e_of_type_AndroidViewView	Landroid/view/View;
    //   1715: iconst_0
    //   1716: invokevirtual 1551	android/view/View:setVisibility	(I)V
    //   1719: aload_1
    //   1720: getfield 3185	oyl:jdField_d_of_type_AndroidViewView	Landroid/view/View;
    //   1723: iconst_0
    //   1724: invokevirtual 2753	android/view/View:setBackgroundColor	(I)V
    //   1727: invokestatic 338	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1730: ifeq -853 -> 877
    //   1733: ldc_w 1060
    //   1736: iconst_2
    //   1737: ldc_w 2822
    //   1740: invokestatic 1065	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1743: goto -866 -> 877
    //   1746: aload_1
    //   1747: getfield 3208	oyl:g	Landroid/widget/TextView;
    //   1750: bipush 8
    //   1752: invokevirtual 1581	android/widget/TextView:setVisibility	(I)V
    //   1755: aload_1
    //   1756: getfield 3184	oyl:jdField_e_of_type_AndroidViewView	Landroid/view/View;
    //   1759: iconst_0
    //   1760: invokevirtual 1551	android/view/View:setVisibility	(I)V
    //   1763: aload_1
    //   1764: getfield 3185	oyl:jdField_d_of_type_AndroidViewView	Landroid/view/View;
    //   1767: iconst_0
    //   1768: invokevirtual 2753	android/view/View:setBackgroundColor	(I)V
    //   1771: goto -894 -> 877
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1774	0	this	ram
    //   0	1774	1	paramoyl	oyl
    //   0	1774	2	paramBaseArticleInfo	BaseArticleInfo
    //   0	1774	3	paramInt	int
    //   14	1605	4	localObject1	Object
    //   102	387	5	localObject2	Object
    //   954	123	5	localException	Exception
    //   1107	16	5	localJSONException1	JSONException
    //   1466	171	5	str1	String
    //   390	7	6	localJSONObject	JSONObject
    //   1039	1	6	localJSONException2	JSONException
    //   1471	162	6	str2	String
    //   1476	159	7	str3	String
    //   1489	13	8	localQQAppInterface	QQAppInterface
    // Exception table:
    //   from	to	target	type
    //   248	279	954	java/lang/Exception
    //   378	427	1039	org/json/JSONException
    //   1019	1036	1039	org/json/JSONException
    //   456	499	1107	org/json/JSONException
  }
  
  public void a(oyr paramoyr, BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    paramoyr.jdField_f_of_type_AndroidViewView.setOnClickListener(null);
    paramoyr.jdField_f_of_type_AndroidViewView.setOnLongClickListener(this);
    paramoyr.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = paramBaseArticleInfo;
    paramoyr.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = ((BaseArticleInfo)paramBaseArticleInfo.mSubArtilceList.get(0));
    BaseArticleInfo localBaseArticleInfo = paramoyr.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
    paramoyr.jdField_a_of_type_AndroidWidgetTextView.setText(localBaseArticleInfo.mTitle);
    paramoyr.jdField_a_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
    paramoyr.jdField_b_of_type_AndroidWidgetTextView.setText(qoi.c(localBaseArticleInfo.mVideoPlayCount));
    paramBaseArticleInfo = this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130842578);
    paramInt = bbll.b(8.0F);
    paramBaseArticleInfo.setBounds(0, 0, paramInt, paramInt);
    paramoyr.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables(paramBaseArticleInfo, null, null, null);
    paramoyr.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(bbll.b(3.0F));
    qoi.a(paramoyr.jdField_c_of_type_AndroidWidgetTextView, localBaseArticleInfo.getCommentCount(), ajya.a(2131712744), "0");
    URL localURL = localBaseArticleInfo.getVideoCoverUrlWithSmartCut(true);
    a(paramoyr.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, localURL, false);
    paramoyr.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setTag(paramoyr);
    paramoyr.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setOnClickListener(this);
    paramoyr.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setOnLongClickListener(this);
    qoi.a(localBaseArticleInfo.mVideoArticleSubsText, localBaseArticleInfo.mVideoArticleSubsColor, paramoyr.jdField_d_of_type_AndroidWidgetTextView);
    localBaseArticleInfo = paramoyr.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
    paramoyr.jdField_e_of_type_AndroidWidgetTextView.setText(localBaseArticleInfo.mTitle);
    paramoyr.jdField_e_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
    paramoyr.jdField_f_of_type_AndroidWidgetTextView.setText(qoi.c(localBaseArticleInfo.mVideoPlayCount));
    paramoyr.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawables(paramBaseArticleInfo, null, null, null);
    paramoyr.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(bbll.b(3.0F));
    qoi.a(paramoyr.g, localBaseArticleInfo.getCommentCount(), ajya.a(2131712733), "0");
    paramBaseArticleInfo = localBaseArticleInfo.getVideoCoverUrlWithSmartCut(true);
    a(paramoyr.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, paramBaseArticleInfo, false);
    paramoyr.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setTag(paramoyr);
    paramoyr.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setOnClickListener(this);
    paramoyr.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setOnLongClickListener(this);
    qoi.a(localBaseArticleInfo.mVideoArticleSubsText, localBaseArticleInfo.mVideoArticleSubsColor, paramoyr.h);
  }
  
  public void a(qtr paramqtr, qkr paramqkr)
  {
    this.jdField_a_of_type_Qtr = paramqtr;
    this.jdField_a_of_type_Qkr = paramqkr;
    if (qkr.a(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext())) {
      this.jdField_a_of_type_Qkr.b(true);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyBaseAdapter", 2, "setVideoPlayManager " + this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler + " mVideoPlayManager " + this.jdField_a_of_type_Qtr + " mIsCleanData " + this.n);
      }
      if ((this.jdField_a_of_type_Qtr != null) && (!this.n))
      {
        b();
        this.jdField_a_of_type_Qtr.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr);
        this.jdField_a_of_type_Qtr.a(this.jdField_a_of_type_Qkr);
        if (bhvy.a(this.jdField_d_of_type_Int)) {
          this.jdField_a_of_type_Qtr.a(0);
        }
      }
      if ((oar.a(this.jdField_c_of_type_Int)) && (this.jdField_a_of_type_Qtr != null))
      {
        this.jdField_a_of_type_Qki = new qki(this.jdField_a_of_type_AndroidAppActivity, this, this.jdField_a_of_type_Qtr, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, this.jdField_c_of_type_Int);
        this.jdField_a_of_type_Qtr.a(this.jdField_a_of_type_Qki);
      }
      return;
      this.jdField_a_of_type_Qkr.b(false);
    }
  }
  
  public void a(qtv paramqtv)
  {
    if ((this.jdField_a_of_type_Bfst != null) && (this.jdField_a_of_type_Bfst.isShowing())) {
      this.jdField_a_of_type_Bfst.dismiss();
    }
    if ((this.jdField_a_of_type_Bfsz != null) && (this.jdField_a_of_type_Bfsz.isShowing())) {
      this.jdField_a_of_type_Bfsz.dismiss();
    }
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new ReadInJoyBaseAdapter.28(this, paramqtv), 1000L);
  }
  
  public void a(qtv paramqtv, int paramInt)
  {
    if (this.jdField_a_of_type_Oyi != null) {}
    for (;;)
    {
      return;
      oyl localoyl = a(paramqtv.jdField_j_of_type_JavaLangString);
      if (localoyl != null)
      {
        this.jdField_a_of_type_Oyi = localoyl;
        paramqtv.jdField_a_of_type_AndroidViewView = localoyl.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
      }
      while ((this.jdField_a_of_type_Qtr != null) && (this.jdField_a_of_type_Qtr.a() != null))
      {
        paramqtv = this.jdField_a_of_type_Qtr.a();
        if (QLog.isColorLevel()) {
          QLog.i("ReadInJoyBaseAdapter", 2, "notifyVideoPositionChanged:");
        }
        paramqtv.e();
        return;
        if (QLog.isColorLevel()) {
          QLog.e("ReadInJoyBaseAdapter", 2, "fixNowPlayHolder failed videoPlayParam:" + paramqtv + "    callSource:" + paramInt);
        }
      }
    }
  }
  
  public void a(qtv paramqtv, BaseArticleInfo paramBaseArticleInfo)
  {
    a(paramqtv, paramBaseArticleInfo, false);
  }
  
  public void a(qtv paramqtv, BaseArticleInfo paramBaseArticleInfo, boolean paramBoolean)
  {
    a(paramqtv, paramBaseArticleInfo, paramBoolean, true);
  }
  
  public void a(qtv paramqtv, BaseArticleInfo paramBaseArticleInfo, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "open full play activity, articleID : " + paramBaseArticleInfo.mArticleID + ", playPosition : " + paramqtv.jdField_d_of_type_Long + ",vid : " + paramqtv.jdField_c_of_type_JavaLangString + ", showComment : " + paramBoolean1);
    }
    if (this.jdField_a_of_type_Qtr != null) {
      this.jdField_a_of_type_Qtr.b();
    }
    this.jdField_j_of_type_Boolean = true;
    Bundle localBundle;
    if (onh.s(paramBaseArticleInfo)) {
      localBundle = b(paramqtv, paramBaseArticleInfo);
    }
    for (;;)
    {
      int i1;
      label137:
      Object localObject;
      label266:
      label275:
      Intent localIntent;
      if (this.jdField_a_of_type_Qtr != null)
      {
        if (this.jdField_a_of_type_Qtr.b() == paramBaseArticleInfo.mArticleID)
        {
          i1 = this.jdField_a_of_type_Qtr.a();
          localBundle.putInt("VIDEO_PLAY_STATUS", i1);
        }
      }
      else
      {
        if (paramqtv.jdField_f_of_type_Int == 2)
        {
          localObject = onu.a(paramqtv.jdField_c_of_type_JavaLangString);
          if (localObject != null)
          {
            localBundle.putString("VIDEO_THIRD_VID_URL", ((ooa)localObject).jdField_a_of_type_JavaLangString);
            localBundle.putLong("VIDEO_THIRD_VID_URL_TIME", ((ooa)localObject).jdField_a_of_type_Long);
          }
        }
        localBundle.putBoolean("VIDEO_LIST_SCROLL_EXIT", true);
        localBundle.putInt("REPORT_VIDEO_FEEDS_JUMP_FROM", 3);
        if (this.jdField_c_of_type_Int != 0) {
          break label760;
        }
        if (!onh.i(paramBaseArticleInfo)) {
          break label713;
        }
        localBundle.putInt("VIDEO_FROM_TYPE", 4);
        localBundle.putLong("VIDEO_FROM_POLYMERIC_TOPIC_ID", paramBaseArticleInfo.mPolymericInfo.jdField_f_of_type_Long);
        localBundle.putLong("VIDEO_FROM_POLYMERIC_PUIN", paramBaseArticleInfo.mPolymericInfo.jdField_b_of_type_Long);
        localBundle.putInt("PERFORMANCE_REPORT_VIDEO_FEEDS_JUMP_FROM", 3);
        localBundle.putInt("REPORT_VIDEO_FEEDS_CHANNEL_ID", this.jdField_c_of_type_Int);
        localBundle.putParcelable("VIDEO_COLUMN_INFO", paramBaseArticleInfo.mVideoColumnInfo);
        localBundle.putString("KEY_VIDEO_JSON_LIST", paramBaseArticleInfo.mJsonVideoList);
        localBundle.putParcelable("ARTICLE_FUSION_INFO", paramBaseArticleInfo.fusionBiuInfo);
        localObject = a();
        localIntent = new Intent((Context)localObject, VideoFeedsPlayActivity.class);
        localIntent.addFlags(536870912);
        if (BaseApplicationImpl.sProcessId != 1)
        {
          localBundle.putBoolean("param_needSmooth", qvk.a().d());
          qvk.a().f(true);
          localBundle.putBoolean("param_needAlertInXg", qkr.e());
        }
        localIntent.putExtras(localBundle);
        if ((paramqtv.jdField_f_of_type_Int == 6) && (!onh.s(paramBaseArticleInfo))) {
          localIntent.putExtra("VIDEO_ARTICLE_INFO_FOR_BIU", (ArticleInfo)paramBaseArticleInfo);
        }
        i1 = 9091;
        if (1 != paramBaseArticleInfo.mVideoType) {
          break label1082;
        }
        i1 = 1;
        label444:
        localIntent.putExtra("VIDEO_FEEDS_INNER_SESSION_ID", paramqtv.l);
        localIntent.putExtra("VIDEO_CHANNEL_SESSION_ID", paramqtv.jdField_m_of_type_JavaLangString);
        localIntent.putExtra("item_x", paramqtv.jdField_h_of_type_Int);
        localIntent.putExtra("item_y", paramqtv.jdField_i_of_type_Int);
        localIntent.putExtra("item_width", paramqtv.jdField_j_of_type_Int);
        localIntent.putExtra("item_height", paramqtv.jdField_k_of_type_Int);
        localIntent.putExtra("VIDEO_FEEDS_TYPE_FOR_REPORT", onh.a(paramBaseArticleInfo));
        localIntent.putExtra("VIDEO_SHOW_COMMENT", paramBoolean1);
      }
      try
      {
        paramBoolean1 = ope.a(localBundle.getInt("VIDEO_FROM_TYPE", -1), Integer.valueOf(localBundle.getString("VIDEO_WIDTH")).intValue(), Integer.valueOf(localBundle.getString("VIDEO_HEIGHT")).intValue(), Integer.valueOf(localBundle.getString("VIDEO_TIME")).intValue());
        if (paramBoolean1)
        {
          MultiVideoFragment.a(this.jdField_a_of_type_AndroidAppActivity, localIntent, i1);
          ((Activity)localObject).overridePendingTransition(2130772010, 0);
          qtd.a();
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr != null)
          {
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.e();
            this.jdField_k_of_type_Boolean = true;
          }
          if (bhvy.j()) {
            nol.a(null, "", "0X8008B68", "0X8008B68", 0, 0, "", "", "", npu.a(null, null, paramBaseArticleInfo.mVideoVid, paramBaseArticleInfo.innerUniqueID, a(), null), false);
          }
          return;
          localBundle = a(paramqtv, paramBaseArticleInfo);
          continue;
          i1 = 1;
          break label137;
          label713:
          if (onh.s(paramBaseArticleInfo))
          {
            localBundle.putInt("VIDEO_FROM_TYPE", 13);
            localBundle.putLong("VIDEO_FROM_POLYMERIC_PUIN", paramBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_Long);
            break label266;
          }
          localBundle.putInt("VIDEO_FROM_TYPE", 3);
          break label266;
          label760:
          if (this.jdField_c_of_type_Int == 56)
          {
            if (onh.i(paramBaseArticleInfo))
            {
              localBundle.putInt("VIDEO_FROM_TYPE", 5);
              localBundle.putLong("VIDEO_FROM_POLYMERIC_TOPIC_ID", paramBaseArticleInfo.mPolymericInfo.jdField_f_of_type_Long);
              localBundle.putLong("VIDEO_FROM_POLYMERIC_PUIN", paramBaseArticleInfo.mPolymericInfo.jdField_b_of_type_Long);
            }
            for (;;)
            {
              localBundle.putInt("PERFORMANCE_REPORT_VIDEO_FEEDS_JUMP_FROM", 4);
              break;
              if (onh.s(paramBaseArticleInfo))
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
            if (onh.s(paramBaseArticleInfo))
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
          if (oou.c(this.jdField_c_of_type_Int))
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
          label1082:
          if (0L != paramBaseArticleInfo.mChannelID) {
            break label444;
          }
          i1 = 1;
        }
      }
      catch (Exception paramqtv)
      {
        for (;;)
        {
          paramBoolean1 = false;
          continue;
          ((Activity)localObject).startActivityForResult(localIntent, i1);
          ((Activity)localObject).overridePendingTransition(2130772067, 2130772068);
        }
      }
    }
  }
  
  public void a(qtv paramqtv1, qtv paramqtv2)
  {
    if (paramqtv1 != paramqtv2)
    {
      if (((paramqtv1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo instanceof ArticleInfo)) && ((paramqtv2.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo instanceof ArticleInfo))) {
        osg.a().a(this.jdField_c_of_type_Int, (ArticleInfo)paramqtv1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, (ArticleInfo)paramqtv2.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.clearFocus();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.postDelayed(new ReadInJoyBaseAdapter.27(this, paramqtv1, paramqtv2), 100L);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Qvf != null) {
        this.jdField_a_of_type_Qvf.a(paramqtv1, paramqtv2);
      }
      return;
      if (this.jdField_a_of_type_Qtr.a() == 7) {
        a(paramqtv1);
      }
    }
  }
  
  public void a(qvf paramqvf)
  {
    this.jdField_a_of_type_Qvf = paramqvf;
  }
  
  public void a(raa paramraa)
  {
    this.jdField_a_of_type_Raa = paramraa;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setNoteCardLifeCycle(paramraa);
    }
  }
  
  public void a(rbo paramrbo)
  {
    this.jdField_a_of_type_Rbo = paramrbo;
  }
  
  public void a(rbp paramrbp)
  {
    this.jdField_a_of_type_Rbp = paramrbp;
  }
  
  public void a(rbq paramrbq)
  {
    this.jdField_a_of_type_Rbq = paramrbq;
  }
  
  public void a(rbr paramrbr)
  {
    this.jdField_a_of_type_Rbr = paramrbr;
  }
  
  public void a(rbs paramrbs)
  {
    this.jdField_a_of_type_Rbs = paramrbs;
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
    qtv localqtv = a(paramArticleInfo1);
    localqtv.jdField_n_of_type_JavaLangString = paramString;
    localqtv.l = npu.b();
    if ((this.jdField_a_of_type_Qtr != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Qtr.a()))) {
      localqtv.jdField_m_of_type_JavaLangString = this.jdField_a_of_type_Qtr.a();
    }
    paramString = new qzb(null, null, null, null);
    int i1;
    if (paramBoolean)
    {
      i1 = 0;
      nol.a(null, "", "0X8008D33", "0X8008D33", 0, 0, "", "", "", paramString.y(i1).b(localqtv.l).c(localqtv.jdField_m_of_type_JavaLangString).a(this.jdField_c_of_type_Int).l(paramArticleInfo1.mVideoAdsSource).k(paramArticleInfo1.mVideoAdsJumpType).a(paramArticleInfo1.videoReportInfo).a(paramArticleInfo1).P((int)this.jdField_c_of_type_Long).a().a(), false);
      if (!qoi.a(paramArticleInfo1, a())) {
        break label192;
      }
      b(localqtv, paramArticleInfo1);
    }
    label192:
    do
    {
      return;
      i1 = 1;
      break;
      if ((paramArticleInfo1.isAccountShown) && (this.jdField_c_of_type_Int == 0) && (!TextUtils.isEmpty(paramArticleInfo1.mArticleContentUrl)))
      {
        onh.e(a(), paramArticleInfo1.mArticleContentUrl);
        paramString = new qzb(null, null, paramArticleInfo1.mVideoVid, paramArticleInfo1.innerUniqueID);
        if (paramBoolean) {}
        for (i1 = 0;; i1 = 1)
        {
          nol.a(null, "", "0X8007625", "0X8007625", 0, 0, "", "", "", a(paramString.y(i1).b(localqtv.l).c(localqtv.jdField_m_of_type_JavaLangString).a(this.jdField_c_of_type_Int).l(paramArticleInfo1.mVideoAdsSource).k(paramArticleInfo1.mVideoAdsJumpType).a(paramArticleInfo1.videoReportInfo).a(paramArticleInfo1).P((int)this.jdField_c_of_type_Long).X(onh.a(paramArticleInfo1)).e(paramArticleInfo1).S(7).f(paramArticleInfo2).a().a(), paramMap), false);
          return;
        }
      }
      if (paramArticleInfo1.isVideoItemForAdJump())
      {
        paramArticleInfo2 = a();
        if (paramArticleInfo2 != null)
        {
          paramString = new Intent(paramArticleInfo2, QQBrowserActivity.class);
          paramString.putExtra("url", paramArticleInfo1.mVideoAdsJumpUrl);
          paramString.putExtra("big_brother_source_key", onh.f(a()));
          paramArticleInfo2.startActivity(paramString);
        }
        b(localqtv, paramArticleInfo1);
        return;
      }
      if ((this.jdField_c_of_type_Int != 0) && (this.jdField_c_of_type_Int != 56)) {
        break label692;
      }
      if (!qoi.a(this.jdField_a_of_type_AndroidAppActivity, paramArticleInfo1)) {
        break label589;
      }
      b(localqtv, paramArticleInfo1);
    } while ((this.jdField_c_of_type_Int != 56) || (paramArticleInfo1.mVideoDownloadBarInfo == null) || (paramArticleInfo1.mVideoDownloadBarInfo.weishiUGInfo == null) || (!onh.a(paramArticleInfo1.mVideoDownloadBarInfo.weishiUGInfo.bytes_report_base_url)) || (!onh.a(paramArticleInfo1.mVideoDownloadBarInfo.weishiUGInfo.bytes_click_schema_report_tail)));
    qoi.a(onh.a(paramArticleInfo1.mVideoDownloadBarInfo.weishiUGInfo.bytes_report_base_url) + onh.a(paramArticleInfo1.mVideoDownloadBarInfo.weishiUGInfo.bytes_click_schema_report_tail));
    return;
    label589:
    if ((this.jdField_c_of_type_Int == 56) && (paramArticleInfo1.mVideoDownloadBarInfo != null) && (paramArticleInfo1.mVideoDownloadBarInfo.weishiUGInfo != null) && (onh.a(paramArticleInfo1.mVideoDownloadBarInfo.weishiUGInfo.bytes_report_base_url)) && (onh.a(paramArticleInfo1.mVideoDownloadBarInfo.weishiUGInfo.bytes_click_report_tail))) {
      qoi.a(onh.a(paramArticleInfo1.mVideoDownloadBarInfo.weishiUGInfo.bytes_report_base_url) + onh.a(paramArticleInfo1.mVideoDownloadBarInfo.weishiUGInfo.bytes_click_report_tail));
    }
    label692:
    if (paramArticleInfo1.videoJumpChannelID > 0)
    {
      if (paramArticleInfo1.videoJumpChannelID == 56) {
        nuq.a(this.jdField_a_of_type_AndroidAppActivity, paramArticleInfo2, paramArticleInfo1, true);
      }
      for (;;)
      {
        b(localqtv, paramArticleInfo1);
        return;
        paramArticleInfo2 = new HashMap();
        paramArticleInfo2.put("param_key_insert_article_id", Long.valueOf(paramArticleInfo1.mArticleID));
        nuq.b(this.jdField_a_of_type_AndroidAppActivity, paramArticleInfo1.videoJumpChannelID, paramArticleInfo1.videoJumpChannelName, paramArticleInfo1.videoJumpChannelType, 5, paramArticleInfo2);
      }
    }
    if (bhvy.d(BaseApplicationImpl.getApplication().getRuntime()) == 1)
    {
      nuq.a(this.jdField_a_of_type_AndroidAppActivity, paramArticleInfo2, paramArticleInfo1, true);
      b(localqtv, paramArticleInfo1);
      return;
    }
    localqtv.jdField_a_of_type_JavaUtilMap = paramMap;
    a(localqtv, paramArticleInfo1);
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
      osg.a().a(56, 3, paramBaseArticleInfo.mArticleID, l1);
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
  
  public oyl b(String paramString)
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
          localObject1 = (oyl)paramString.getTag();
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
    for (int i1 = quk.jdField_b_of_type_Int;; i1 = quk.jdField_a_of_type_Int)
    {
      localVideoPreDownloadMgr.a = new quk(i1, quk.jdField_f_of_type_Int);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a(new rav(this));
      return;
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
  }
  
  public void b(BaseArticleInfo paramBaseArticleInfo)
  {
    if ((paramBaseArticleInfo.isAccountShown) && (this.jdField_c_of_type_Int == 0) && (!TextUtils.isEmpty(onh.a(paramBaseArticleInfo.mPartnerAccountInfo.bytes_head_jump_url)))) {
      onh.e(a(), onh.a(paramBaseArticleInfo.mPartnerAccountInfo.bytes_head_jump_url));
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
      } while ((!bbfj.g(this.jdField_a_of_type_AndroidAppActivity)) || (this.jdField_a_of_type_Qtr == null) || (paramAbsListView == null));
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
  
  public void b(qtv paramqtv, BaseArticleInfo paramBaseArticleInfo)
  {
    int i3 = a();
    String str1 = onh.c(paramBaseArticleInfo);
    int i1;
    int i2;
    label40:
    qzb localqzb;
    if (((ArticleInfo)paramBaseArticleInfo).hasChannelInfo())
    {
      i1 = paramBaseArticleInfo.mChannelInfoId;
      if (!TextUtils.isEmpty(paramBaseArticleInfo.mArticleFriendLikeText)) {
        break label529;
      }
      i2 = 0;
      nol.a(null, "CliOper", "", "", "0X80066FA", "0X80066FA", 0, 0, "", Long.toString(paramBaseArticleInfo.mArticleID), Integer.toString(paramBaseArticleInfo.mStrategyId), onh.b(paramBaseArticleInfo.mAlgorithmID, onh.a(paramBaseArticleInfo), this.jdField_c_of_type_Int, i1), false);
      nol.a("0X80066FA", "", "", Long.toString(paramBaseArticleInfo.mArticleID), Integer.toString(paramBaseArticleInfo.mStrategyId), onh.b(paramBaseArticleInfo.mAlgorithmID, onh.a(paramBaseArticleInfo), this.jdField_c_of_type_Int, i1));
      localqzb = new qzb(onh.a(paramBaseArticleInfo.mAlgorithmID, onh.a(paramBaseArticleInfo), i3, i1, i2, bbfj.h(this.jdField_a_of_type_AndroidAppActivity), str1, paramBaseArticleInfo.mStrCircleId, paramBaseArticleInfo.innerUniqueID, onh.e(paramBaseArticleInfo), 409409, (ArticleInfo)paramBaseArticleInfo));
      localqzb.a(this.jdField_a_of_type_Qum, paramBaseArticleInfo.mArticleID).a(this.jdField_a_of_type_Qum).h(npu.jdField_a_of_type_Int).i(409409).k(paramBaseArticleInfo.mVideoAdsJumpType).l(paramBaseArticleInfo.mVideoAdsSource).a(Boolean.valueOf(onh.w(paramBaseArticleInfo))).a(paramBaseArticleInfo.videoReportInfo);
      if (i3 != 0) {
        break label535;
      }
      paramqtv.l = npu.b();
      localqzb.b(paramqtv.l);
      if (paramBaseArticleInfo.mVideoColumnInfo != null) {
        localqzb.ab(paramBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_Int);
      }
      if (c((ArticleInfo)paramBaseArticleInfo) == 6) {
        localqzb.ad(qoi.b());
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Qtr != null) && (this.jdField_a_of_type_Qtr.a() == paramqtv))
      {
        long l1 = this.jdField_a_of_type_Qtr.a();
        if (l1 != 0L) {
          localqzb.f(l1);
        }
      }
      if (this.jdField_c_of_type_Int != 40677) {
        break label586;
      }
      localqzb.b(paramBaseArticleInfo.mVideoAdsJumpType).a(vzw.a(this.jdField_a_of_type_AndroidAppActivity));
      localqzb.j(2);
      nol.a(null, "CliOper", "", paramBaseArticleInfo.mSubscribeID, "0X8009293", "0X8009293", 0, 0, Long.toString(paramBaseArticleInfo.mFeedId), Long.toString(paramBaseArticleInfo.mArticleID), Integer.toString(paramBaseArticleInfo.mStrategyId), localqzb.a().a(), false);
      nol.a("0X8009293", paramBaseArticleInfo.mSubscribeID, Long.toString(paramBaseArticleInfo.mFeedId), Long.toString(paramBaseArticleInfo.mArticleID), Integer.toString(paramBaseArticleInfo.mStrategyId), onh.a(paramBaseArticleInfo.mAlgorithmID, onh.a(paramBaseArticleInfo), i3, i1, i2, bbfj.h(this.jdField_a_of_type_AndroidAppActivity), str1, paramBaseArticleInfo.mStrCircleId, paramBaseArticleInfo.innerUniqueID, onh.e(paramBaseArticleInfo), 409409, (ArticleInfo)paramBaseArticleInfo));
      return;
      i1 = 0;
      break;
      label529:
      i2 = 1;
      break label40;
      label535:
      if ((i3 == 56) && (this.jdField_a_of_type_Qtr != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Qtr.a())))
      {
        paramqtv.jdField_m_of_type_JavaLangString = this.jdField_a_of_type_Qtr.a();
        localqzb.c(paramqtv.jdField_m_of_type_JavaLangString);
      }
    }
    label586:
    localqzb.a(paramBaseArticleInfo).P((int)this.jdField_c_of_type_Long).c(paramBaseArticleInfo).a(paramBaseArticleInfo, true).d(paramBaseArticleInfo).f(paramBaseArticleInfo);
    if ((onh.l(paramBaseArticleInfo)) && (paramBaseArticleInfo.mPolymericInfo != null)) {
      localqzb.y(paramBaseArticleInfo.mPolymericInfo.jdField_f_of_type_Int + 1);
    }
    String str2 = shu.b(this.jdField_c_of_type_Int);
    nol.a(null, "CliOper", "", paramBaseArticleInfo.mSubscribeID, str2, str2, 0, 0, Long.toString(paramBaseArticleInfo.mFeedId), Long.toString(paramBaseArticleInfo.mArticleID), Integer.toString(paramBaseArticleInfo.mStrategyId), a(localqzb.a().a(), paramqtv.jdField_a_of_type_JavaUtilMap), false);
    nol.a(str2, paramBaseArticleInfo.mSubscribeID, Long.toString(paramBaseArticleInfo.mFeedId), Long.toString(paramBaseArticleInfo.mArticleID), Integer.toString(paramBaseArticleInfo.mStrategyId), onh.a(paramBaseArticleInfo.mAlgorithmID, onh.a(paramBaseArticleInfo), i3, i1, i2, bbfj.h(this.jdField_a_of_type_AndroidAppActivity), str1, paramBaseArticleInfo.mStrCircleId, paramBaseArticleInfo.innerUniqueID, onh.e(paramBaseArticleInfo), 409409, (ArticleInfo)paramBaseArticleInfo));
  }
  
  public void b(raa paramraa)
  {
    this.jdField_b_of_type_JavaUtilArrayList.add(paramraa);
  }
  
  public void b(boolean paramBoolean, BaseArticleInfo paramBaseArticleInfo)
  {
    qzb localqzb;
    if ((paramBaseArticleInfo.isAccountShown) && (this.jdField_c_of_type_Int == 0) && (!TextUtils.isEmpty(paramBaseArticleInfo.mArticleContentUrl)))
    {
      onh.e(a(), paramBaseArticleInfo.mArticleContentUrl);
      localqzb = new qzb(null, null, paramBaseArticleInfo.mVideoVid, paramBaseArticleInfo.innerUniqueID);
      if (!paramBoolean) {
        break label144;
      }
    }
    label144:
    for (int i1 = 0;; i1 = 1)
    {
      nol.a(null, "", "0X8007625", "0X8007625", 0, 0, "", "", "", localqzb.y(i1).a(this.jdField_c_of_type_Int).a(paramBaseArticleInfo.videoReportInfo).a(paramBaseArticleInfo).P((int)this.jdField_c_of_type_Long).X(onh.a(paramBaseArticleInfo)).e(paramBaseArticleInfo).S(6).f(paramBaseArticleInfo).a().a(), false);
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
  
  public void c(raa paramraa)
  {
    this.jdField_b_of_type_JavaUtilArrayList.remove(paramraa);
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
    if (this.jdField_a_of_type_Qtr != null) {
      this.jdField_a_of_type_Qtr.a(new rap(this));
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ReadInJoyBaseAdapter", 2, "mVideoPlayManager == null");
  }
  
  public void f()
  {
    if ((this.jdField_a_of_type_Qtr != null) && (this.jdField_a_of_type_Qtr.a() != null)) {}
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
          if ((!onh.a(((BaseArticleInfo)localObject).mArticleContentUrl, ((BaseArticleInfo)localObject).mChannelID, (ArticleInfo)localObject)) && (!onh.a((BaseArticleInfo)localObject)) && (!a(i3, ((BaseArticleInfo)localObject).mArticleID)))
          {
            localObject = ((BaseArticleInfo)localObject).mArticleContentUrl;
            if (xlr.a((String)localObject)) {
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
    bfwu.a("ReadInJoyBaseAdapter.getView");
    System.currentTimeMillis();
    a(b(paramInt), paramInt);
    BaseArticleInfo localBaseArticleInfo = b(paramInt);
    int i1 = getItemViewType(paramInt);
    pbf localpbf = a((ArticleInfo)localBaseArticleInfo, i1, paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyBaseAdapter", 2, "getView: " + localBaseArticleInfo + " type= " + i1);
    }
    paramViewGroup = (View)oyc.a(this.jdField_a_of_type_AndroidUtilSparseArray, new rbj(this, "onAdapterGetView", i1, localBaseArticleInfo, paramInt, paramView, paramViewGroup));
    if (paramViewGroup != null)
    {
      a(localBaseArticleInfo, localpbf, System.currentTimeMillis(), paramInt);
      paramView = super.a(paramViewGroup, paramInt);
      bfwu.a();
      return paramView;
    }
    if ((a() instanceof ReadInJoyChannelActivity)) {
      if ((this.jdField_d_of_type_Boolean) && (paramView != null) && (paramInt > 0) && (paramInt <= 2))
      {
        if ((paramInt != 1) || (!this.jdField_e_of_type_Boolean)) {
          break label284;
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
      return paramView;
      label284:
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
    return jdField_a_of_type_Pjn.a() + 135;
  }
  
  public void h()
  {
    if ((!bhvy.z(a())) || (!bhvy.A(a()))) {
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
        if (!onh.a((BaseArticleInfo)localObject)) {
          localArrayList.add((ArticleInfo)localObject);
        }
      }
      i1 += 1;
    }
    osg.a().a().a(localArrayList);
  }
  
  public void i()
  {
    this.jdField_f_of_type_Boolean = true;
    if ((this.jdField_a_of_type_Qtr != null) && ((c()) || (this.jdField_a_of_type_Qkr.a())) && (!this.jdField_a_of_type_Qkr.b()) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getVisibility() == 0))
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
    if (this.jdField_a_of_type_Qki != null) {
      this.jdField_a_of_type_Qki.a();
    }
    if (this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video_" + this.jdField_c_of_type_Int, 2, "ReadInJoyBaseAdapter doOnResume()");
      }
      if (bhvy.k()) {
        r();
      }
      this.p = true;
      this.jdField_a_of_type_Boolean = true;
      c();
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new ReadInJoyBaseAdapter.33(this), 1000L);
      if (Build.VERSION.SDK_INT < 21) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setFriction(jdField_a_of_type_Float);
      }
      this.jdField_a_of_type_Sdq.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, 4);
      this.jdField_i_of_type_Boolean = false;
      this.jdField_h_of_type_Boolean = false;
      int i1 = 0;
      while (i1 < this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildCount())
      {
        localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(i1);
        if (((localObject instanceof qzy)) && (!((qzy)localObject).a()))
        {
          ((qzy)localObject).setIsResume(true);
          ((qzy)localObject).a();
        }
        i1 += 1;
      }
      i1 = 0;
      while (i1 < this.jdField_b_of_type_JavaUtilArrayList.size())
      {
        ((raa)this.jdField_b_of_type_JavaUtilArrayList.get(i1)).a();
        i1 += 1;
      }
      if (this.jdField_a_of_type_Raa != null) {
        this.jdField_a_of_type_Raa.a();
      }
      Object localObject = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      if ((pcb.a() == 2) && (pcb.b(a(), (String)localObject) > 0))
      {
        localObject = (SensorManager)a().getSystemService("sensor");
        akgf localakgf = this.jdField_a_of_type_Akgf;
        Sensor localSensor = ((SensorManager)localObject).getDefaultSensor(1);
        i1 = i2;
        if (axsi.a().a()) {
          i1 = 2;
        }
        ((SensorManager)localObject).registerListener(localakgf, localSensor, i1);
      }
    } while (!ProteusParserWithHotReload.getInstance().isSupportHotReload());
    ProteusParserWithHotReload.getInstance().addHotReloadChangedObserver(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewParseProteusParserWithHotReload$IHotReloadChangedObserver);
  }
  
  public void k()
  {
    int i3 = 0;
    if (this.jdField_a_of_type_Qki != null) {
      this.jdField_a_of_type_Qki.b();
    }
    if (!this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video_" + this.jdField_c_of_type_Int, 2, "ReadInJoyBaseAdapter doOnPause()");
      }
      this.jdField_a_of_type_Boolean = false;
      if ((this.jdField_a_of_type_Bfst != null) && (this.jdField_a_of_type_Bfst.isShowing())) {
        this.jdField_a_of_type_Bfst.dismiss();
      }
      this.jdField_l_of_type_Int = bbfj.b(this.jdField_a_of_type_AndroidAppActivity);
      this.jdField_a_of_type_Sdq.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, 5);
      w();
      if ((!bhvy.o()) && (olo.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, "default_feeds")))
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
        if (((localView instanceof qzy)) && (((qzy)localView).a()))
        {
          ((qzy)localView).setIsResume(false);
          ((qzy)localView).b();
        }
        i1 += 1;
      }
      while (i2 < this.jdField_b_of_type_JavaUtilArrayList.size())
      {
        ((raa)this.jdField_b_of_type_JavaUtilArrayList.get(i2)).b();
        i2 += 1;
      }
      if (this.jdField_a_of_type_Raa != null) {
        this.jdField_a_of_type_Raa.b();
      }
      ((SensorManager)a().getSystemService("sensor")).unregisterListener(this.jdField_a_of_type_Akgf);
    } while (!ProteusParserWithHotReload.getInstance().isSupportHotReload());
    ProteusParserWithHotReload.getInstance().removeHotReloadChangedObserver(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewParseProteusParserWithHotReload$IHotReloadChangedObserver);
  }
  
  public void l()
  {
    if (this.jdField_a_of_type_Qvf != null) {
      this.jdField_a_of_type_Qvf.l();
    }
  }
  
  public void m()
  {
    this.jdField_a_of_type_Qtr.b(9);
  }
  
  public void n()
  {
    if ((this.jdField_a_of_type_Qtr != null) && (oar.a(this.jdField_c_of_type_Int))) {
      m();
    }
  }
  
  public void notifyDataSetChanged()
  {
    super.notifyDataSetChanged();
    oyc.a(this.jdField_a_of_type_AndroidUtilSparseArray, new rbd(this, "onNotifyDataSetChange"));
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "notifyDataSetChanged");
    }
    if (((this.jdField_a_of_type_Oyi != null) || (this.jdField_a_of_type_Qtv != null)) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr != null))
    {
      int i2 = -1;
      int i1 = i2;
      if (this.jdField_a_of_type_Oyi != null)
      {
        i1 = i2;
        if (this.jdField_a_of_type_Oyi.a() != null) {
          i1 = this.jdField_a_of_type_Oyi.a().jdField_a_of_type_Int;
        }
      }
      if (this.jdField_a_of_type_Qtv != null) {
        i1 = this.jdField_a_of_type_Qtv.jdField_a_of_type_Int;
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
    switch (paramView.getId())
    {
    }
    label446:
    label1603:
    label1761:
    label1773:
    do
    {
      Object localObject1;
      do
      {
        for (;;)
        {
          return;
          localObject1 = (oyl)paramView.getTag();
          localObject2 = b(((oyi)localObject1).a());
          if (!qoi.a((BaseArticleInfo)localObject2, a()))
          {
            if ((qoi.c()) && (!AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject2))) {}
            for (int i1 = 1;; i1 = 0)
            {
              if (((this.jdField_a_of_type_Qkr.a()) || (bhvy.a(a()) <= 0)) && (i1 == 0)) {
                break label446;
              }
              if (localObject2 == null) {
                break;
              }
              if (i1 != 0) {
                nol.a(null, "", "0X8008E28", "0X8008E28", 0, 0, "", "", "", new qzb(null, null, ((BaseArticleInfo)localObject2).mVideoVid, ((BaseArticleInfo)localObject2).innerUniqueID).a((int)((BaseArticleInfo)localObject2).mChannelID).P((int)this.jdField_c_of_type_Long).S(1).a().a(), false);
              }
              a(((oyi)localObject1).a(), (BaseArticleInfo)localObject2, false);
              return;
            }
            this.jdField_a_of_type_Qtr.a().c(paramView);
            osj.a().e(false);
            return;
            paramView = (articlesummary.ChannelInfo)paramView.getTag();
            if (paramView != null) {
              if ((paramView.bytes_channel_url.has()) && (paramView.bytes_channel_url.get() != null))
              {
                if (!TextUtils.isEmpty(paramView.bytes_channel_url.get().toStringUtf8())) {
                  onh.a(this.jdField_a_of_type_AndroidAppActivity, paramView.bytes_channel_url.get().toStringUtf8());
                }
              }
              else
              {
                nuq.b(this.jdField_a_of_type_AndroidAppActivity, paramView.uint32_channel_id.get(), onh.a(paramView), paramView.uint32_channel_type.get(), 6, null);
                return;
                paramView = (oyl)paramView.getTag();
                localObject1 = b(paramView.jdField_a_of_type_Int);
                if (localObject1 != null)
                {
                  if (!qoi.a((BaseArticleInfo)localObject1, a()))
                  {
                    if (AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject1))
                    {
                      shq.a(this.jdField_a_of_type_AndroidAppActivity, (ArticleInfo)localObject1, this, 56);
                      shq.a(this.jdField_a_of_type_AndroidAppActivity, (ArticleInfo)localObject1, this, 56, true, null);
                      return;
                    }
                    a(paramView.jdField_a_of_type_Qtv, (BaseArticleInfo)localObject1);
                  }
                  ThreadManager.executeOnSubThread(new ReadInJoyBaseAdapter.14(this, (BaseArticleInfo)localObject1));
                  return;
                  paramView = (oyl)paramView.getTag();
                  localObject1 = b(paramView.jdField_a_of_type_Int);
                  if (localObject1 != null)
                  {
                    a(paramView.jdField_a_of_type_Qtv, (BaseArticleInfo)localObject1, true);
                    ThreadManager.executeOnSubThread(new ReadInJoyBaseAdapter.15(this, (BaseArticleInfo)localObject1));
                    return;
                    localObject1 = paramView.getTag();
                    if ((localObject1 instanceof oym))
                    {
                      ((oym)localObject1).onClick(paramView);
                      return;
                    }
                    if (rlz.a().b())
                    {
                      if ((paramView.getTag() instanceof oyl))
                      {
                        paramView = (oyl)paramView.getTag();
                        localObject1 = b(paramView.jdField_a_of_type_Int);
                        localObject2 = ((BaseArticleInfo)localObject1).fusionBiuInfo;
                        if (localObject2 != null)
                        {
                          rlz.a().a(paramView.jdField_b_of_type_AndroidWidgetImageView, ((FusionBiuInfo)localObject2).jdField_b_of_type_Boolean);
                          if (!((FusionBiuInfo)localObject2).jdField_b_of_type_Boolean) {
                            rlz.a().a(a(), onh.a(), 1, 2, (ArticleInfo)localObject1, 3, ((BaseArticleInfo)localObject1).innerUniqueID);
                          }
                          for (;;)
                          {
                            rlz.a().b(((BaseArticleInfo)localObject1).innerUniqueID, 56, 2, 4);
                            return;
                            rlz.a().a(a(), ((FusionBiuInfo)localObject2).jdField_a_of_type_Long, onh.a(), ((BaseArticleInfo)localObject1).mFeedType, 3, ((BaseArticleInfo)localObject1).innerUniqueID);
                          }
                        }
                      }
                    }
                    else
                    {
                      if (odo.a() == 1) {}
                      for (bool = true;; bool = false)
                      {
                        a(paramView, false, bool);
                        return;
                      }
                      paramView = (oyl)paramView.getTag();
                      localObject1 = b(paramView.jdField_a_of_type_Int);
                      if (localObject1 == null)
                      {
                        if (QLog.isColorLevel()) {
                          QLog.d("ReadInJoyBaseAdapter", 2, "articleInfo == null, ERROR");
                        }
                      }
                      else
                      {
                        if ((this.jdField_a_of_type_Qtr != null) && (this.jdField_a_of_type_Qtr.b()))
                        {
                          this.jdField_a_of_type_Qtr.a();
                          this.jdField_b_of_type_Boolean = true;
                        }
                        this.jdField_a_of_type_Quo.a(paramView.jdField_f_of_type_AndroidViewView, paramView.jdField_a_of_type_Int);
                        this.jdField_a_of_type_Quo.a(this);
                        this.jdField_a_of_type_Quo.a((BaseArticleInfo)localObject1, a(paramView.jdField_a_of_type_Qtv, (BaseArticleInfo)localObject1), this.jdField_a_of_type_Qtr, new raq(this, (BaseArticleInfo)localObject1), this.jdField_c_of_type_Int);
                        return;
                        a();
                        a();
                        localObject2 = (oyp)paramView.getTag();
                        if (localObject2 != null)
                        {
                          localObject1 = (BaseArticleInfo)this.jdField_b_of_type_JavaUtilList.get(((oyp)localObject2).jdField_a_of_type_Int);
                          try
                          {
                            JSONObject localJSONObject = new JSONObject();
                            localJSONObject.put("time", System.currentTimeMillis() / 1000L);
                            localJSONObject.put("channel_id", this.jdField_c_of_type_Int);
                            if ((this.jdField_a_of_type_AndroidAppActivity instanceof BaseActivity))
                            {
                              localJSONObject.put("folder_status", onh.jdField_d_of_type_Int);
                              localJSONObject.put("kandian_mode", onh.e());
                              localJSONObject.put("feeds_type", "" + onh.a((BaseArticleInfo)localObject1));
                              localJSONObject.put("rowkey", shu.a((BaseArticleInfo)localObject1));
                              nol.a(null, "", "0X8007058", "0X8007058", 0, 0, "", "", "", localJSONObject.toString(), false);
                            }
                            while (localObject1 != null)
                            {
                              i1 = ((oyp)localObject2).jdField_a_of_type_Int;
                              localObject2 = new rar(this, i1, (oyp)localObject2, (BaseArticleInfo)localObject1);
                              if (!AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject1)) {
                                break label1445;
                              }
                              if ((this.jdField_a_of_type_Bfst != null) && (this.jdField_a_of_type_Bfst.isShowing())) {
                                this.jdField_a_of_type_Bfst.dismiss();
                              }
                              this.jdField_a_of_type_Bfsz.a(i1, this.jdField_c_of_type_Int, onh.a((BaseArticleInfo)localObject1), ((AdvertisementInfo)localObject1).mAdDislikeInfos);
                              this.jdField_a_of_type_Bfsz.a(paramView, (bfsx)localObject2);
                              this.jdField_a_of_type_Bfsz.a(new rat(this, (BaseArticleInfo)localObject1));
                              this.jdField_a_of_type_Bfsz.setOnDismissListener(new rau(this));
                              if ((this.jdField_a_of_type_Qtr == null) || (!this.jdField_a_of_type_Qtr.b())) {
                                break;
                              }
                              this.jdField_a_of_type_Qtr.a();
                              this.jdField_b_of_type_Boolean = true;
                              return;
                              if ((this.jdField_a_of_type_AndroidAppActivity instanceof PluginBaseActivity))
                              {
                                localJSONObject.put("folder_status", 1);
                                axqy.b(null, "CliOper", "", "", "0X800705F", "0X800705F", 0, 0, "", "", "", localJSONObject.toString());
                              }
                            }
                          }
                          catch (JSONException localJSONException)
                          {
                            for (;;)
                            {
                              localJSONException.printStackTrace();
                              continue;
                              if ((this.jdField_a_of_type_Bfsz != null) && (this.jdField_a_of_type_Bfsz.isShowing())) {
                                this.jdField_a_of_type_Bfsz.dismiss();
                              }
                              this.jdField_a_of_type_Bfst.a(i1, this.jdField_c_of_type_Int, onh.a((BaseArticleInfo)localObject1), ((BaseArticleInfo)localObject1).mDislikeInfos, ((BaseArticleInfo)localObject1).innerUniqueID);
                              this.jdField_a_of_type_Bfst.a(paramView, (bfsx)localObject2);
                              this.jdField_a_of_type_Bfst.setOnDismissListener(new raw(this));
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
        Object localObject2 = (BaseArticleInfo)paramView.getTag();
        localObject1 = null;
        Object localObject3;
        long l1;
        if ((!TextUtils.isEmpty(((BaseArticleInfo)localObject2).getSubscribeUin())) && (!"16888".equals(((BaseArticleInfo)localObject2).getSubscribeUin())))
        {
          paramView = ((BaseArticleInfo)localObject2).getSubscribeUin();
          if (paramView != null) {
            a(paramView);
          }
          localObject1 = ((BaseArticleInfo)localObject2).mVideoVid;
          localObject3 = String.valueOf(((BaseArticleInfo)localObject2).innerUniqueID);
          if (this.jdField_a_of_type_Qtr != null) {
            break label1761;
          }
          l1 = 0L;
          localObject3 = new qzb(null, paramView, (String)localObject1, (String)localObject3, l1, ((BaseArticleInfo)localObject2).mVideoDuration * 1000).a(this.jdField_c_of_type_Int).a().a();
          if (TextUtils.isEmpty(((BaseArticleInfo)localObject2).innerUniqueID)) {
            break label1773;
          }
        }
        for (localObject1 = String.valueOf(((BaseArticleInfo)localObject2).innerUniqueID);; localObject1 = "0")
        {
          nol.a(null, paramView, "0X8007410", "0X8007410", 0, 0, "2", "", (String)localObject1, (String)localObject3, false);
          shq.a(this.jdField_a_of_type_AndroidAppActivity, (ArticleInfo)localObject2, this, 56);
          shq.a(this.jdField_a_of_type_AndroidAppActivity, (ArticleInfo)localObject2, this, 56, true, null);
          return;
          paramView = (View)localObject1;
          if (TextUtils.isEmpty(((BaseArticleInfo)localObject2).thirdUin)) {
            break;
          }
          paramView = (View)localObject1;
          if ("16888".equals(((BaseArticleInfo)localObject2).thirdUin)) {
            break;
          }
          paramView = ((BaseArticleInfo)localObject2).thirdUin;
          break;
          l1 = this.jdField_a_of_type_Qtr.a();
          break label1603;
        }
        paramView = b(((oyl)paramView.getTag()).jdField_a_of_type_Int);
        shq.a(this.jdField_a_of_type_AndroidAppActivity, (ArticleInfo)paramView, this, 56);
        shq.a(this.jdField_a_of_type_AndroidAppActivity, (ArticleInfo)paramView, this, 56, true, null);
        return;
        Object localObject4;
        if (paramView.getId() == 2131369123)
        {
          localObject3 = (ArticleInfo)((oyk)paramView.getTag()).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
          localObject1 = ((oyk)paramView.getTag()).jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID;
          localObject2 = localObject3;
          localObject4 = localObject2;
          localObject2 = localObject1;
          if (paramView.getId() != 2131369123) {
            break label1961;
          }
        }
        for (bool = true;; bool = false)
        {
          a(bool, localObject4, (ArticleInfo)localObject3, (String)localObject2);
          return;
          localObject1 = (ArticleInfo)((oyk)paramView.getTag()).jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
          localObject2 = ((oyk)paramView.getTag()).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID;
          localObject3 = (ArticleInfo)((oyk)paramView.getTag()).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
          ((ArticleInfo)localObject1).isTwoItem = true;
          localObject4 = localObject1;
          break;
        }
        if (paramView.getId() == 2131367163) {
          localObject1 = ((oyr)paramView.getTag()).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
        }
        for (localObject2 = ((oyr)paramView.getTag()).jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID;; localObject2 = ((oyr)paramView.getTag()).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID)
        {
          localObject3 = a((BaseArticleInfo)localObject1);
          ((qtv)localObject3).jdField_n_of_type_JavaLangString = ((String)localObject2);
          ((qtv)localObject3).l = npu.b();
          if ((this.jdField_a_of_type_Qtr != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Qtr.a()))) {
            ((qtv)localObject3).jdField_m_of_type_JavaLangString = this.jdField_a_of_type_Qtr.a();
          }
          localObject2 = new int[2];
          paramView.getLocationOnScreen((int[])localObject2);
          ((qtv)localObject3).jdField_h_of_type_Int = localObject2[0];
          ((qtv)localObject3).jdField_i_of_type_Int = localObject2[1];
          ((qtv)localObject3).jdField_j_of_type_Int = paramView.getWidth();
          ((qtv)localObject3).jdField_k_of_type_Int = paramView.getHeight();
          if (!((BaseArticleInfo)localObject1).isVideoItemForCommonUrlJump()) {
            break;
          }
          onh.e(this.jdField_a_of_type_AndroidAppActivity, ((BaseArticleInfo)localObject1).mVideoAdsJumpUrl);
          b((qtv)localObject3, (BaseArticleInfo)localObject1);
          return;
          localObject1 = ((oyr)paramView.getTag()).jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
        }
        if (((BaseArticleInfo)localObject1).isVideoItemForWeishiJump())
        {
          if (vzw.a(this.jdField_a_of_type_AndroidAppActivity)) {
            sir.a(this.jdField_a_of_type_AndroidAppActivity, "video_type_videopublic");
          }
          for (;;)
          {
            b((qtv)localObject3, (BaseArticleInfo)localObject1);
            return;
            bcql.a(this.jdField_a_of_type_AndroidAppActivity, -1, 2131718445, 0).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131298865));
            sir.b(this.jdField_a_of_type_AndroidAppActivity, "video_type_videopublic");
          }
        }
        a((qtv)localObject3, (BaseArticleInfo)localObject1);
        return;
        localObject1 = (BaseArticleInfo)paramView.getTag();
      } while (localObject1 == null);
      if (paramView.getId() == 2131369123) {}
      for (boolean bool = true;; bool = false)
      {
        b(bool, (BaseArticleInfo)localObject1);
        return;
      }
      paramView = (BaseArticleInfo)paramView.getTag();
    } while (paramView == null);
    label1445:
    label1961:
    b(paramView);
  }
  
  public boolean onLongClick(View paramView)
  {
    boolean bool2 = false;
    boolean bool1 = true;
    switch (paramView.getId())
    {
    default: 
      bool1 = false;
    }
    do
    {
      return bool1;
    } while (rlz.a().b());
    bool1 = bool2;
    if (odo.b() == 1) {
      bool1 = true;
    }
    a(paramView, true, bool1);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ram
 * JD-Core Version:    0.7.0.1
 */