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
import com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInJoyPatchAdView;
import com.tencent.biz.pubaccount.readinjoy.biu.ReadInJoyDeliverBiuActivity;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianSubscribeManager;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.ProteusItemView;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentGridImage;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
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
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
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
import tencent.im.oidb.articlesummary.articlesummary.ChannelInfo;
import tencent.im.oidb.articlesummary.articlesummary.PartnerAccountInfo;
import tencent.im.oidb.articlesummary.articlesummary.VideoDownloadBarInfo;
import tencent.im.oidb.articlesummary.articlesummary.WeishiUGInfo;
import tencent.im.oidb.gallery.galleryFeeds.GalleryFeedsInfo;

public abstract class rqj
  extends ywy
  implements View.OnClickListener, View.OnLongClickListener, bhyt, rkc, rkw, rpu
{
  public static float a;
  public static int a;
  private static ppz jdField_a_of_type_Ppz;
  public static int b;
  public static int f;
  static final int g;
  static final int h;
  private static int j;
  private static int jdField_k_of_type_Int;
  public long a;
  private amck jdField_a_of_type_Amck = new rre(this);
  public Activity a;
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  protected Drawable a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private SparseArray<pdc> jdField_a_of_type_AndroidUtilSparseArray;
  protected LayoutInflater a;
  private AnimationSet jdField_a_of_type_AndroidViewAnimationAnimationSet;
  public bhtv a;
  private bhxx jdField_a_of_type_Bhxx;
  private bhyd jdField_a_of_type_Bhyd;
  protected VideoPreDownloadMgr a;
  public ReadInJoyXListView a;
  private VafContext jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext = new put();
  private ProteusParserWithHotReload.IHotReloadChangedObserver jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewParseProteusParserWithHotReload$IHotReloadChangedObserver = new rrf(this);
  public GdtHandler.Params a;
  public INetInfoHandler a;
  private Runnable jdField_a_of_type_JavaLangRunnable = new ReadInJoyBaseAdapter.21(this);
  public ArrayList<qkk> a;
  public HashSet<String> a;
  protected List<Object> a;
  public Map<Long, qkk> a;
  protected Set<Long> a;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new MqqHandler();
  private noq jdField_a_of_type_Noq;
  private odt jdField_a_of_type_Odt;
  public pdn a;
  protected qzp a;
  private qzy jdField_a_of_type_Qzy;
  public rjg a;
  public rjk a;
  protected rkb a;
  private rkd jdField_a_of_type_Rkd;
  private rkw jdField_a_of_type_Rkw;
  private rpx jdField_a_of_type_Rpx;
  protected rrl a;
  protected rrm a;
  protected rrn a;
  protected rro a;
  private rrp jdField_a_of_type_Rrp;
  public rrt a;
  rxw jdField_a_of_type_Rxw = new rxw();
  private siw jdField_a_of_type_Siw;
  svj jdField_a_of_type_Svj = new rrb(this);
  private svl jdField_a_of_type_Svl;
  public boolean a;
  public long b;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private AnimationSet jdField_b_of_type_AndroidViewAnimationAnimationSet;
  private bhtv jdField_b_of_type_Bhtv = new rqv(this);
  private ArrayList<rpx> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  public HashSet<String> b;
  public List<BaseArticleInfo> b;
  protected Set<Long> b;
  public boolean b;
  public int c;
  private long jdField_c_of_type_Long = -1L;
  private bhtv jdField_c_of_type_Bhtv = new rqw(this);
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
    jdField_a_of_type_Ppz = new ppz();
    jdField_g_of_type_Int = Color.parseColor("#999999");
    jdField_h_of_type_Int = Color.parseColor("#262626");
  }
  
  public rqj(Activity paramActivity, LayoutInflater paramLayoutInflater, int paramInt, ListView paramListView, SparseArray<pdc> paramSparseArray)
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
    this.jdField_a_of_type_Bhtv = new rqu(this);
    this.jdField_a_of_type_Rrt = new rqx(this);
    this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new rqy(this);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidViewLayoutInflater = paramLayoutInflater;
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.setContext(paramActivity);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.setCurActivity(paramActivity);
    this.jdField_e_of_type_Int = ors.d();
    opy.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, "default_feeds");
    jdField_a_of_type_Ppz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView = ((ReadInJoyXListView)paramListView);
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    a(paramSparseArray);
    this.jdField_a_of_type_Rkd = new rkd(paramActivity);
    this.jdField_a_of_type_Svl = new svl(paramActivity, true);
    t();
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView instanceof ReadInJoyXListView)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setOnDrawCompleteListener(this.jdField_a_of_type_Rrt);
    }
    this.jdField_a_of_type_AndroidOsHandler = new rqk(this, Looper.getMainLooper());
    q();
    p();
    ((ReadInJoyXListView)paramListView).a(this);
  }
  
  public static int a(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo == null) || (paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmw == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyBaseAdapter", 2, "ugc feeds info is null");
      }
      return 21;
    }
    switch (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmw.jdField_a_of_type_Int)
    {
    case 1: 
    default: 
      return 21;
    case 2: 
    case 3: 
      if ((paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int == 9) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmw.jdField_a_of_type_JavaUtilArrayList.size() > 1)) {
        return 36;
      }
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmh != null) {
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
    if (pvq.b(paramArticleInfo)) {
      return pvq.a(paramArticleInfo);
    }
    ppz localppz = jdField_a_of_type_Ppz;
    if (ppz.a(paramArticleInfo)) {
      return jdField_a_of_type_Ppz.a(paramArticleInfo);
    }
    if (paramArticleInfo.mFeedType == 20)
    {
      paramInt = 82;
      if (paramArticleInfo.mRecommendFollowInfos != null) {
        switch (paramArticleInfo.mRecommendFollowInfos.jdField_a_of_type_Int)
        {
        default: 
          paramInt = 82;
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
    if (paramArticleInfo.mFeedType == 36) {
      if (paramArticleInfo.isPGCShortContent()) {
        paramInt = 139;
      }
    }
    for (;;)
    {
      return paramInt;
      if (ors.A(paramArticleInfo))
      {
        paramInt = 138;
      }
      else
      {
        paramInt = 137;
        continue;
        if ((paramArticleInfo.mFeedType == 21) || (paramArticleInfo.mFeedType == 22))
        {
          paramInt = ors.a(paramArticleInfo, false);
        }
        else if (paramArticleInfo.mFeedType == 28)
        {
          paramInt = 93;
        }
        else if (paramArticleInfo.mFeedType == 24)
        {
          paramInt = ors.b(paramArticleInfo);
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
            break label1131;
          }
          paramInt = osa.a(paramArticleInfo);
          if ((paramInt == 21) || (paramInt == 22))
          {
            paramInt = ors.a(paramArticleInfo, true);
          }
          else if (paramInt == 11)
          {
            paramInt = 33;
          }
          else if (ors.g(paramArticleInfo))
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
            if (!ors.h(paramArticleInfo)) {
              break;
            }
            switch (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmw.jdField_a_of_type_Int)
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
    }
    if (ors.d(paramArticleInfo)) {
      if ((paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmr == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmr.jdField_a_of_type_JavaUtilArrayList == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmr.jdField_a_of_type_JavaUtilArrayList.size() <= 0)) {
        break label2626;
      }
    }
    label2626:
    for (paramInt = ComponentContentGridImage.a(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmr.jdField_a_of_type_JavaUtilArrayList.size(), paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int);; paramInt = 0)
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
        if ((paramInt == 27) && (paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmv != null))
        {
          if (!TextUtils.isEmpty(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmv.jdField_c_of_type_JavaLangString))
          {
            paramInt = 94;
            break;
          }
          paramInt = 95;
          break;
        }
        if ((paramInt == 32) && (paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmg != null))
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
        if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmw.jdField_a_of_type_Int == 1)
        {
          if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmw.c.size() > 0)
          {
            paramInt = 108;
            break;
          }
          paramInt = 24;
          break;
        }
        if ((paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmw.jdField_a_of_type_Int == 3) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmw.jdField_a_of_type_Int == 2))
        {
          if ((paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int == 9) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmw.jdField_a_of_type_JavaUtilArrayList.size() > 1))
          {
            paramInt = 37;
            break;
          }
          if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmh != null)
          {
            paramInt = 81;
            break;
          }
          paramInt = 25;
          break;
        }
        paramInt = 26;
        break;
        label1131:
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
        if ((b(paramArticleInfo)) && (paramArticleInfo.mSocialFeedInfo != null))
        {
          paramInt = a(paramArticleInfo);
          break;
        }
        if ((ors.b(paramArticleInfo)) || (ors.c(paramArticleInfo)))
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
          if ((ors.e(paramArticleInfo)) || (ors.f(paramArticleInfo)))
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
          if ((paramArticleInfo.mChannelID == 0L) && (paramArticleInfo.mSimpleVideoColumnInfo != null) && (ors.a(paramArticleInfo)))
          {
            paramInt = 128;
            break;
          }
          if ((paramArticleInfo.mChannelID == 0L) && (paramArticleInfo.mVideoColumnInfo != null) && (ors.a(paramArticleInfo)))
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
          if (paramArticleInfo.isWormhole()) {
            return 136;
          }
          if ((ors.a(paramArticleInfo)) && (paramArticleInfo.mPictures != null) && (paramArticleInfo.mPictures.length >= 3) && (paramArticleInfo.mChannelID == 0L))
          {
            paramInt = 14;
            break;
          }
          if (ors.a(paramArticleInfo))
          {
            if (paramArticleInfo.mVideoType == 0)
            {
              if (ors.a())
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
                if (rdm.b() == 0)
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
              if (rdm.b() == 0)
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
          if (ors.b(paramArticleInfo))
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
                paramInt = oee.b((AdvertisementInfo)paramArticleInfo);
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
          if ((AdvertisementInfo.isAdvertisementInfo(paramArticleInfo)) && (oee.h((AdvertisementInfo)paramArticleInfo))) {
            return 116;
          }
          if ((AdvertisementInfo.isAdvertisementInfo(paramArticleInfo)) && (oee.i((AdvertisementInfo)paramArticleInfo))) {
            return 39;
          }
          if ((AdvertisementInfo.isAdvertisementInfo(paramArticleInfo)) && (oee.j((AdvertisementInfo)paramArticleInfo))) {
            return 117;
          }
          if (ors.i(paramArticleInfo))
          {
            if (ors.j(paramArticleInfo)) {
              return 91;
            }
            return 90;
          }
          if ((AdvertisementInfo.isAdvertisementInfo(paramArticleInfo)) && (oee.k((AdvertisementInfo)paramArticleInfo))) {
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
          if ((AdvertisementInfo.isAdvertisementInfo(paramArticleInfo)) && (oee.l((AdvertisementInfo)paramArticleInfo)))
          {
            paramInt = 122;
            break;
          }
          if (paramArticleInfo.mFeedType == 37)
          {
            paramInt = 135;
            break;
          }
          if (paramArticleInfo.mIsGallery == 0)
          {
            if (AdvertisementInfo.isAdvertisementInfo(paramArticleInfo))
            {
              if (noy.a(paramArticleInfo))
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
  
  public static int a(ListView paramListView, rjk paramrjk)
  {
    if (paramrjk != null)
    {
      paramrjk = paramListView.getChildAt(paramrjk.jdField_a_of_type_Int + paramListView.getHeaderViewsCount() - paramListView.getFirstVisiblePosition());
      if (paramrjk != null) {
        return paramrjk.getBottom() - aepi.a(175.0F, paramListView.getResources());
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
  
  private Bundle a(rjk paramrjk, BaseArticleInfo paramBaseArticleInfo)
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
    if (paramrjk.jdField_f_of_type_Int == 1)
    {
      localBundle1.putString("VIDEO_PUB_ACCOUNT_UIN", paramBaseArticleInfo.mSubscribeID);
      localBundle1.putString("VIDEO_PUB_ACCOUNT_NAME", paramBaseArticleInfo.mSubscribeName);
      if (paramrjk.jdField_f_of_type_Int != 6) {
        break label1282;
      }
      localBundle1.putString("VIDEO_H5_URL", ((qmy)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmw.jdField_b_of_type_JavaUtilArrayList.get(0)).h);
      localBundle1.putString("VIDEO_CREATE_TIME", orr.a(((qmy)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmw.jdField_b_of_type_JavaUtilArrayList.get(0)).jdField_e_of_type_Int, true));
      localBundle1.putString("VIDEO_TIME", String.valueOf(paramrjk.jdField_b_of_type_Int));
      if (paramBaseArticleInfo.mVideoJsonWidth == 0) {
        break label1313;
      }
      localBundle1.putString("VIDEO_WIDTH", String.valueOf(paramBaseArticleInfo.mVideoJsonWidth));
      if (paramBaseArticleInfo.mVideoJsonHeight == 0) {
        break label1356;
      }
      localBundle1.putString("VIDEO_HEIGHT", String.valueOf(paramBaseArticleInfo.mVideoJsonHeight));
      localBundle1.putString("VIDEO_VID", paramrjk.jdField_c_of_type_JavaLangString);
      localBundle1.putString("VIDEO_COVER", paramrjk.jdField_b_of_type_JavaLangString);
      localBundle1.putLong("VIDEO_XG_FILE_SIZE", paramBaseArticleInfo.mXGFileSize);
      localBundle1.putInt("VIDEO_STRATEGY_ID", paramBaseArticleInfo.mStrategyId);
      localBundle1.putLong("VIDEO_ALGORITHM_ID", paramBaseArticleInfo.mAlgorithmID);
      localBundle1.putString("VIDEO_SECOND_INDEX_INNER_ID", paramrjk.jdField_n_of_type_JavaLangString);
      if ((this.jdField_a_of_type_Pdn == null) || (this.jdField_a_of_type_Pdn.a() == null) || (this.jdField_a_of_type_Rjg == null) || (this.jdField_a_of_type_Pdn.a().jdField_c_of_type_Long != paramrjk.jdField_c_of_type_Long)) {
        break label1399;
      }
      localBundle1.putLong("VIDEO_PLAY_POSITION", this.jdField_a_of_type_Rjg.a());
      if (paramrjk.jdField_f_of_type_Int != 6) {
        break label1411;
      }
      localBundle1.putString("VIDEO_ARTICLE_ID", ((qmy)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmw.jdField_b_of_type_JavaUtilArrayList.get(0)).jdField_g_of_type_JavaLangString);
      localBundle1.putLong("VIDEO_FEED_ID", paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmc.jdField_a_of_type_JavaLangLong.longValue());
      localBundle1.putInt("VIDEO_FEED_TYPE", paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmc.b.intValue());
      localBundle1.putString("VIDEO_TITLE", ((qmy)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmw.jdField_b_of_type_JavaUtilArrayList.get(0)).jdField_e_of_type_JavaLangString);
      localBundle1.putBoolean("IS_FROM_READINJOY_VIDEO_CHANNEL", bkbq.a(this.jdField_d_of_type_Int));
      if (paramrjk.jdField_f_of_type_Int != 1) {
        break label1438;
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
        break label1444;
      }
      i1 = 0;
      label528:
      localBundle1.putInt("interactionType", i1);
      localBundle1.putString("VIDEO_THIRD_ICON", paramrjk.jdField_d_of_type_JavaLangString);
      localBundle1.putString("VIDEO_THIRD_NAME", paramrjk.jdField_e_of_type_JavaLangString);
      localBundle1.putString("VIDEO_THIRD_ACTION", paramrjk.jdField_f_of_type_JavaLangString);
      localBundle1.putString("VIDEO_THIRD_URL", paramrjk.jdField_g_of_type_JavaLangString);
      localBundle1.putLong("VIDEO_THRID_URL_EXPIRE_TIME", paramrjk.jdField_f_of_type_Long);
      localBundle1.putInt("VIDEO_ARTICLE_BUSITYPE", paramrjk.jdField_f_of_type_Int);
      localBundle2 = new Bundle();
      localBundle2.putString("VINFO", paramrjk.jdField_c_of_type_JavaLangString);
      localBundle2.putString("TINFO", paramrjk.jdField_c_of_type_JavaLangString);
      localBundle2.putInt("PREVIEW_VIDEO_TIME", paramrjk.jdField_b_of_type_Int);
      if (this.jdField_a_of_type_Rjg != null) {
        break label1449;
      }
      i1 = 0;
      label663:
      localBundle2.putInt("PREVIEW_START_POSI", rjm.a(i1, paramrjk.jdField_b_of_type_Int));
      localBundle2.putInt("PREVIEW_VIDEO_WIDTH", paramrjk.jdField_c_of_type_Int);
      localBundle2.putInt("PREVIEW_VIDEO_HEIGHT", paramrjk.jdField_d_of_type_Int);
      localBundle2.putInt("FULL_VIDEO_TIME", paramrjk.jdField_b_of_type_Int);
      localBundle2.putString("source_puin", paramBaseArticleInfo.mSubscribeID);
      if (paramrjk.jdField_f_of_type_Int != 1) {
        break label1461;
      }
      localBundle2.putString("ACCOUNT_UIN", paramBaseArticleInfo.mSubscribeID);
      localBundle2.putString("ACCOUNT_NAME", paramBaseArticleInfo.mSubscribeName);
      label759:
      if ((paramrjk.jdField_f_of_type_Int != 6) || (paramBaseArticleInfo.mSocialFeedInfo == null) || (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmw == null) || (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmw.jdField_b_of_type_JavaUtilArrayList == null) || (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmw.jdField_b_of_type_JavaUtilArrayList.size() <= 0)) {
        break label1488;
      }
      localBundle2.putString("compatible_text", ((qmy)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmw.jdField_b_of_type_JavaUtilArrayList.get(0)).jdField_e_of_type_JavaLangString + ": " + ((qmy)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmw.jdField_b_of_type_JavaUtilArrayList.get(0)).h);
      localBundle2.putInt("req_type", 125);
    }
    for (;;)
    {
      localBundle2.putInt("TYPE", paramrjk.jdField_f_of_type_Int);
      localBundle2.putString("ARTICLE_ID", paramBaseArticleInfo.innerUniqueID);
      localBundle2.putInt("layout_item", 5);
      localBundle2.putBoolean("video_url_load", false);
      localBundle2.putString("image_url_remote", paramrjk.jdField_b_of_type_JavaLangString);
      localBundle2.putString("detail_url", paramBaseArticleInfo.mArticleContentUrl + "&sourcefrom=0");
      localBundle2.putString("video_url", paramrjk.jdField_c_of_type_JavaLangString);
      localBundle2.putString("title", paramBaseArticleInfo.mTitle);
      localBundle2.putString("req_create_time", orr.a(paramBaseArticleInfo.mTime));
      localBundle2.putString("brief_key", paramBaseArticleInfo.mTitle);
      localBundle1.putByteArray("STRUCT_MSG_BYTES", ((StructMsgForGeneralShare)azvd.a(localBundle2)).getBytes());
      localBundle1.putString("VIDEO_SUBS_TEXT", paramBaseArticleInfo.mVideoArticleSubsText);
      localBundle1.putString("VIDEO_SUBS_COLOR", paramBaseArticleInfo.mVideoArticleSubsColor);
      localBundle1.putString("KEY_VIDEO_JSON_LIST", paramBaseArticleInfo.mJsonVideoList);
      localBundle1.putInt("VIDEO_PLAY_COUNT", paramBaseArticleInfo.mVideoPlayCount);
      return localBundle1;
      if (paramrjk.jdField_f_of_type_Int == 6)
      {
        if (b((ArticleInfo)paramBaseArticleInfo)) {
          localBundle1.putString("VIDEO_PUB_ACCOUNT_UIN", "" + paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qme.jdField_a_of_type_Long);
        }
        for (;;)
        {
          localBundle1.putString("VIDEO_PUB_ACCOUNT_NAME", paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmw.jdField_b_of_type_JavaLangString);
          if (q((ArticleInfo)paramBaseArticleInfo)) {
            break;
          }
          localBundle1.putString("VIDEO_URL", ((qmy)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmw.jdField_b_of_type_JavaUtilArrayList.get(0)).jdField_b_of_type_JavaLangString);
          break;
          localBundle1.putString("VIDEO_PUB_ACCOUNT_UIN", "" + paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmw.jdField_a_of_type_Long);
        }
      }
      localBundle1.putString("VIDEO_PUB_ACCOUNT_UIN", paramBaseArticleInfo.thirdUin);
      localBundle1.putString("VIDEO_PUB_ACCOUNT_NAME", paramBaseArticleInfo.thirdUinName);
      break;
      label1282:
      localBundle1.putString("VIDEO_H5_URL", paramBaseArticleInfo.mArticleContentUrl);
      localBundle1.putString("VIDEO_CREATE_TIME", orr.a(paramBaseArticleInfo.mTime, true));
      break label111;
      label1313:
      if (paramrjk.jdField_f_of_type_Int != 6) {
        break label148;
      }
      localBundle1.putString("VIDEO_WIDTH", String.valueOf(((qmy)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmw.jdField_b_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Int));
      break label148;
      label1356:
      if (paramrjk.jdField_f_of_type_Int != 6) {
        break label170;
      }
      localBundle1.putString("VIDEO_HEIGHT", String.valueOf(((qmy)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmw.jdField_b_of_type_JavaUtilArrayList.get(0)).jdField_b_of_type_Int));
      break label170;
      label1399:
      localBundle1.putLong("VIDEO_PLAY_POSITION", 0L);
      break label303;
      label1411:
      localBundle1.putString("VIDEO_ARTICLE_ID", paramBaseArticleInfo.innerUniqueID);
      localBundle1.putString("VIDEO_TITLE", paramBaseArticleInfo.mTitle);
      break label410;
      label1438:
      bool = false;
      break label436;
      label1444:
      i1 = 1;
      break label528;
      label1449:
      i1 = (int)this.jdField_a_of_type_Rjg.a();
      break label663;
      label1461:
      localBundle2.putString("ACCOUNT_UIN", paramBaseArticleInfo.thirdUin);
      localBundle2.putString("ACCOUNT_NAME", paramBaseArticleInfo.thirdUinName);
      break label759;
      label1488:
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
  
  public static String a(ArticleInfo paramArticleInfo, int paramInt)
  {
    if (jdField_a_of_type_Ppz != null)
    {
      ppz localppz = jdField_a_of_type_Ppz;
      if (ppz.a(paramArticleInfo))
      {
        paramArticleInfo = jdField_a_of_type_Ppz.a(paramArticleInfo);
        QLog.d("ReadInJoyBaseAdapter", 2, "getProteusFamilyCardViewType | dynamic viewType : " + paramArticleInfo);
        return paramArticleInfo;
      }
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
  
  private pdn a(AbsListView paramAbsListView)
  {
    Object localObject;
    if ((!a()) || (this.jdField_a_of_type_Qzy == null) || (paramAbsListView.getChildCount() <= 0))
    {
      localObject = null;
      return localObject;
    }
    int i1 = 0;
    label27:
    if (i1 < paramAbsListView.getChildCount())
    {
      View localView = paramAbsListView.getChildAt(i1);
      if ((localView.getTag() instanceof pdn))
      {
        localObject = (pdn)localView.getTag();
        if (!((pdn)localObject).a(localView)) {}
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
  
  private pgq a(ArticleInfo paramArticleInfo, int paramInt1, int paramInt2)
  {
    b(paramInt2);
    ArticleInfo localArticleInfo = null;
    if (paramInt2 < getCount() - 1) {
      localArticleInfo = (ArticleInfo)b(paramInt2 + 1);
    }
    return new pgq(this.jdField_a_of_type_AndroidAppActivity, paramArticleInfo, paramInt1, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, paramInt2, this.jdField_c_of_type_Boolean, getCount(), localArticleInfo, this);
  }
  
  public static rjk a(BaseArticleInfo paramBaseArticleInfo)
  {
    return a(paramBaseArticleInfo, false);
  }
  
  public static rjk a(BaseArticleInfo paramBaseArticleInfo, boolean paramBoolean)
  {
    rjk localrjk = new rjk();
    localrjk.jdField_c_of_type_JavaLangString = paramBaseArticleInfo.getVideoVid();
    localrjk.jdField_c_of_type_Long = paramBaseArticleInfo.mArticleID;
    localrjk.jdField_b_of_type_Int = paramBaseArticleInfo.getVideoDuration();
    localrjk.jdField_c_of_type_Int = paramBaseArticleInfo.getVideoWidth();
    localrjk.jdField_d_of_type_Int = paramBaseArticleInfo.getVideoHeight();
    localrjk.jdField_a_of_type_Long = paramBaseArticleInfo.mXGFileSize;
    localrjk.jdField_a_of_type_JavaLangString = paramBaseArticleInfo.mTitle;
    Object localObject;
    if (paramBaseArticleInfo.getVideoCoverUrlWithSmartCut(false) == null)
    {
      localObject = null;
      localrjk.jdField_b_of_type_JavaLangString = ((String)localObject);
      localrjk.jdField_k_of_type_JavaLangString = paramBaseArticleInfo.getSubscribeUin();
      localrjk.jdField_g_of_type_Int = paramBaseArticleInfo.mStrategyId;
      localrjk.jdField_g_of_type_Long = paramBaseArticleInfo.mAlgorithmID;
      localObject = new qlq();
      ((qlq)localObject).jdField_a_of_type_JavaLangLong = Long.valueOf(paramBaseArticleInfo.mArticleID);
      ((qlq)localObject).jdField_a_of_type_JavaLangString = paramBaseArticleInfo.innerUniqueID;
      ((qlq)localObject).jdField_b_of_type_JavaLangString = paramBaseArticleInfo.getVideoVid();
      ((qlq)localObject).jdField_a_of_type_Int = paramBaseArticleInfo.busiType;
      ((qlq)localObject).jdField_i_of_type_Int = paramBaseArticleInfo.getVideoWidth();
      ((qlq)localObject).jdField_j_of_type_Int = paramBaseArticleInfo.getVideoHeight();
      ((qlq)localObject).s = paramBaseArticleInfo.getVideoDuration();
      ((qlq)localObject).jdField_n_of_type_Int = 0;
      ((qlq)localObject).o = 0;
      ((qlq)localObject).p = 0;
      ((qlq)localObject).jdField_f_of_type_Boolean = false;
      ((qlq)localObject).jdField_g_of_type_Boolean = false;
      ((qlq)localObject).jdField_h_of_type_Boolean = false;
      ((qlq)localObject).jdField_g_of_type_JavaLangString = "";
      localrjk.jdField_a_of_type_Qlq = ((qlq)localObject);
      localrjk.jdField_d_of_type_JavaLangString = paramBaseArticleInfo.thirdIcon;
      localrjk.jdField_e_of_type_JavaLangString = paramBaseArticleInfo.thirdName;
      localrjk.jdField_f_of_type_JavaLangString = paramBaseArticleInfo.thirdAction;
      localrjk.jdField_f_of_type_Int = paramBaseArticleInfo.busiType;
      localrjk.jdField_j_of_type_JavaLangString = paramBaseArticleInfo.getInnerUniqueID();
      localrjk.jdField_b_of_type_Long = paramBaseArticleInfo.mChannelID;
      localrjk.jdField_g_of_type_JavaLangString = paramBaseArticleInfo.mThirdVideoURL;
      localrjk.jdField_f_of_type_Long = paramBaseArticleInfo.mThirdVideoURLExpireTime;
      localrjk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = paramBaseArticleInfo;
      if (!paramBoolean) {
        break label402;
      }
    }
    label402:
    for (int i1 = 3;; i1 = 0)
    {
      localrjk.jdField_m_of_type_Int = i1;
      if (c((ArticleInfo)paramBaseArticleInfo) == 4) {
        localrjk.jdField_c_of_type_Boolean = true;
      }
      if ((paramBaseArticleInfo.mChannelID == 56L) && (ors.s()))
      {
        i1 = bdaq.a(BaseApplicationImpl.getApplication().getApplicationContext(), 8.0F);
        localrjk.o = i1;
        localrjk.p = i1;
        localrjk.q = i1;
        localrjk.r = i1;
      }
      return localrjk;
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
    if (!bdin.h(this.jdField_a_of_type_AndroidAppActivity)) {
      return;
    }
    ArrayList localArrayList = new ArrayList(this.jdField_b_of_type_JavaUtilList);
    ThreadManager.post(new ReadInJoyBaseAdapter.4(this, this.jdField_d_of_type_Long, localArrayList, paramInt1, paramInt2, l1), 5, null, true);
  }
  
  private void a(SparseArray<pdc> paramSparseArray)
  {
    this.jdField_a_of_type_AndroidUtilSparseArray = paramSparseArray;
    int i1 = 0;
    while (i1 < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      ((pdc)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i1)).a(this);
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
    if (ors.s())
    {
      i1 = bdaq.a(a(), 8.0F);
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
      i1 = bdaq.a(a(), 3.0F);
      break;
      label79:
      i2 = i1 / 2;
      i1 = e();
    }
  }
  
  private void a(View paramView, boolean paramBoolean1, boolean paramBoolean2)
  {
    BaseArticleInfo localBaseArticleInfo = b(((pdq)paramView.getTag()).jdField_a_of_type_Int);
    if (localBaseArticleInfo == null) {
      return;
    }
    if (this.jdField_a_of_type_Rjg.b()) {
      this.jdField_a_of_type_Rjg.a();
    }
    if (this.jdField_a_of_type_Rkb != null) {
      this.jdField_a_of_type_Rkb.a(1, localBaseArticleInfo, 0L, 0L);
    }
    paramView = new Intent(a(), ReadInJoyDeliverBiuActivity.class);
    paramView.putExtra("arg_article_info", (ArticleInfo)localBaseArticleInfo);
    paramView.putExtra("biu_src", 2);
    paramView.putExtra("arg_from_type", 7);
    paramView.putExtra("fast_biu_type", paramBoolean2);
    a().startActivityForResult(paramView, 2);
    a().overridePendingTransition(0, 0);
    long l2 = 0L;
    paramView = this.jdField_a_of_type_Rjg.a();
    long l1 = l2;
    if (paramView != null)
    {
      l1 = l2;
      if (paramView.jdField_c_of_type_JavaLangString.equals(localBaseArticleInfo.mVideoVid)) {
        l1 = this.jdField_a_of_type_Rjg.a();
      }
    }
    String str1 = new ron(null, localBaseArticleInfo.mSubscribeID, localBaseArticleInfo.mVideoVid, localBaseArticleInfo.innerUniqueID).a(l1).c(localBaseArticleInfo.mVideoDuration * 1000).e(localBaseArticleInfo.mAlgorithmID).c(localBaseArticleInfo.mStrategyId).a(this.jdField_c_of_type_Int).h(paramBoolean1).i(paramBoolean2).a().a();
    String str2 = localBaseArticleInfo.mSubscribeID;
    if (!TextUtils.isEmpty(localBaseArticleInfo.innerUniqueID))
    {
      paramView = localBaseArticleInfo.innerUniqueID;
      nrt.a(null, str2, "0X8007B89", "0X8007B89", 0, 0, "1", "", paramView, str1, false);
      l2 = a().getIntent().getLongExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", 0L);
      paramView = new qlw();
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
      ntd.a(localBaseArticleInfo, this.jdField_c_of_type_Int, 25, -1L, paramView);
      return;
      paramView = "0";
      break;
    }
  }
  
  public static void a(ArticleInfo paramArticleInfo, int paramInt)
  {
    String str = szp.b(paramInt);
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
    if ((b(paramArticleInfo)) || (i(paramArticleInfo)) || (j(paramArticleInfo)) || (k(paramArticleInfo)))
    {
      if ((paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmw == null)) {
        break label273;
      }
      str1 = Long.toString(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmw.jdField_a_of_type_Long);
      l1 = 0L;
    }
    for (;;)
    {
      label77:
      String str3 = ors.a(paramInt2, paramInt1, null, ors.a(paramArticleInfo), paramArticleInfo.innerUniqueID, ors.d(paramArticleInfo), paramArticleInfo);
      if (szp.a(paramArticleInfo.mChannelID)) {}
      for (String str2 = "0X8009363";; str2 = "0X8008899")
      {
        nrt.a(null, "CliOper", "", str1, str2, str2, 0, 0, Long.toString(l2), Long.toString(l1), "" + paramArticleInfo.mStrategyId, str3, false);
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
    if ((b(paramArticleInfo)) || (i(paramArticleInfo)) || (j(paramArticleInfo)) || (k(paramArticleInfo)))
    {
      l1 = l2;
      str1 = str2;
      if (paramArticleInfo.mSocialFeedInfo == null) {
        break label376;
      }
      l1 = l2;
      str1 = str2;
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmw == null) {
        break label376;
      }
      str2 = Long.toString(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmw.jdField_a_of_type_Long);
      l1 = l2;
      str1 = str2;
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmw.jdField_a_of_type_JavaUtilArrayList == null) {
        break label376;
      }
      paramInt = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmw.jdField_a_of_type_JavaUtilArrayList.size();
      l1 = 0L;
      str1 = str2;
    }
    for (;;)
    {
      paramString = ors.a(paramInt, i2, paramString, ors.a(paramArticleInfo), paramArticleInfo.innerUniqueID, paramArticleInfo);
      str2 = ors.a(paramInt, i2, null, ors.a(paramArticleInfo), paramArticleInfo.innerUniqueID, ors.d(paramArticleInfo), paramArticleInfo);
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
        if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmr != null)
        {
          l1 = l2;
          str1 = str2;
          if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmr.jdField_a_of_type_JavaUtilArrayList != null)
          {
            paramInt = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmr.jdField_a_of_type_JavaUtilArrayList.size();
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
    Object localObject = ors.d(paramArticleInfo);
    if (paramArticleInfo.hasChannelInfo()) {
      int i1 = paramArticleInfo.mChannelInfoId;
    }
    if (TextUtils.isEmpty(paramArticleInfo.mArticleFriendLikeText)) {}
    try
    {
      localObject = ors.a(paramArticleInfo.mAlgorithmID, ors.a(paramArticleInfo), paramInt, bdin.h(null), (String)localObject, paramArticleInfo.innerUniqueID, ors.f(paramArticleInfo), 0, ors.d(), paramArticleInfo);
      if ((paramMap != null) && (paramMap.entrySet() != null))
      {
        paramMap = paramMap.entrySet().iterator();
        while ((paramMap != null) && (paramMap.hasNext()))
        {
          Map.Entry localEntry = (Map.Entry)paramMap.next();
          ((JSONObject)localObject).put((String)localEntry.getKey(), localEntry.getValue().toString());
          continue;
          nrt.a(null, ors.d(paramArticleInfo), paramString1, paramString2, 0, 0, a(paramArticleInfo.mFeedId), String.valueOf(paramArticleInfo.businessId), Integer.toString(paramArticleInfo.mStrategyId), paramMap, false);
        }
      }
    }
    catch (Exception paramMap)
    {
      aepi.a("ReadInJoyBaseAdapter", "reportClickEvent", new IllegalArgumentException(paramMap));
      paramMap = null;
    }
    for (;;)
    {
      szt.a(paramArticleInfo, paramInt);
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
    int i1 = bkbq.d();
    boolean bool2 = bkbq.q();
    paramTextView1.setMaxLines(i1);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramTextView1.getLayoutParams();
    float f1;
    boolean bool1;
    if (bool2)
    {
      f1 = 5.0F;
      localLayoutParams.bottomMargin = aepi.a(f1, this.jdField_a_of_type_AndroidAppActivity.getResources());
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
        paramKandianUrlImageView.setOnClickListener(new rql(this, paramBaseArticleInfo.familyCommentInfo.jdField_b_of_type_JavaLangString));
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
    rdm.a(paramTextView2, paramBaseArticleInfo.getCommentCount(), alud.a(2131713316), "0");
  }
  
  private void a(KandianUrlImageView paramKandianUrlImageView, ImageView paramImageView, BaseArticleInfo paramBaseArticleInfo, boolean paramBoolean)
  {
    boolean bool;
    URL localURL;
    if ((paramBaseArticleInfo.isUseGif) && (bdin.h(this.jdField_a_of_type_AndroidAppActivity)))
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
    orc.a(paramKandianUrlImageView, paramURL, this.jdField_a_of_type_AndroidAppActivity, paramBoolean);
  }
  
  private void a(ReadInJoyHeadImageView paramReadInJoyHeadImageView, BaseArticleInfo paramBaseArticleInfo)
  {
    Object localObject = null;
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = bdhj.b();
    }
    if ((ors.w(paramBaseArticleInfo)) || ((paramBaseArticleInfo.busiType == 1) && (!AdvertisementInfo.isAdvertisementInfo(paramBaseArticleInfo))))
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
          paramBaseArticleInfo = new URL("http://pub.idqqimg.com/pc/misc/files/20191114/1014c7cfd33e4333b818ceecc0885938.png");
          break label329;
        }
        paramBaseArticleInfo = new URL(paramBaseArticleInfo.thirdIcon);
        break label329;
      }
      paramBaseArticleInfo = URLDrawable.getDrawable(paramBaseArticleInfo, localURLDrawableOptions);
      paramBaseArticleInfo.setDecodeHandler(bcyz.a);
      paramReadInJoyHeadImageView.setImageDrawable(paramBaseArticleInfo);
      paramReadInJoyHeadImageView.setVisibility(0);
      return;
    }
  }
  
  private void a(ReadInJoyNickNameTextView paramReadInJoyNickNameTextView, BaseArticleInfo paramBaseArticleInfo, boolean paramBoolean)
  {
    if (ors.w(paramBaseArticleInfo))
    {
      paramReadInJoyNickNameTextView.setNickNameByUin(paramBaseArticleInfo.getSubscribeUin());
      return;
    }
    if (paramBoolean)
    {
      paramReadInJoyNickNameTextView.setText(oee.a(paramBaseArticleInfo));
      return;
    }
    paramReadInJoyNickNameTextView.setText(orc.a(paramBaseArticleInfo.getSubscribeName(), 18));
  }
  
  private void a(RoundAngleFrameLayout paramRoundAngleFrameLayout)
  {
    if (ors.s())
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
    paramString = oqu.jdField_k_of_type_JavaLangString + bdfr.encodeToString(String.valueOf(paramString).getBytes(), 2);
    ors.a(a(), paramString);
  }
  
  private void a(pdq parampdq)
  {
    if (parampdq == null) {
      return;
    }
    parampdq.jdField_e_of_type_AndroidWidgetImageView.setOnClickListener(this);
    parampdq.i.setOnClickListener(this);
    parampdq.h.setOnClickListener(this);
    parampdq.h.setTag(parampdq);
    parampdq.i.setTag(parampdq);
    parampdq.jdField_e_of_type_AndroidWidgetImageView.setTag(parampdq);
  }
  
  public static void a(pdq parampdq, BaseArticleInfo paramBaseArticleInfo)
  {
    rjk localrjk = a(paramBaseArticleInfo);
    localrjk.jdField_a_of_type_AndroidViewView = parampdq.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
    localrjk.jdField_a_of_type_Int = parampdq.jdField_a_of_type_Int;
    localrjk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = paramBaseArticleInfo;
    parampdq.jdField_a_of_type_Rjk = localrjk;
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    pdc localpdc = a(0);
    if ((localpdc instanceof pdj)) {
      return ((pdj)localpdc).a(paramInt2, paramInt1);
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
    float f2 = (float)bdgk.j();
    return (f1 > 0.0F) && (f1 > f2 * 1.0F);
  }
  
  public static int b(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo == null) || (paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmw == null))
    {
      QLog.d("ReadInJoyBaseAdapter", 1, "getTopicRecommendAndUpdateUGCType ugc feeds info is null. article info is: " + paramArticleInfo);
      return 54;
    }
    switch (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmw.jdField_a_of_type_Int)
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
  
  private Bundle b(rjk paramrjk, BaseArticleInfo paramBaseArticleInfo)
  {
    Object localObject1 = null;
    Object localObject3;
    Object localObject2;
    if ((ors.n(paramBaseArticleInfo)) && (paramrjk != null))
    {
      localObject3 = paramBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject2 = (qlk)((Iterator)localObject3).next();
        if ((((qlk)localObject2).jdField_a_of_type_Qln == null) || (!TextUtils.equals(paramrjk.jdField_c_of_type_JavaLangString, ((qlk)localObject2).jdField_a_of_type_Qln.jdField_a_of_type_JavaLangString))) {
          break label989;
        }
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = (qlk)paramBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.get(0);
      }
      localObject1 = new Bundle();
      label392:
      boolean bool;
      if (((qlk)localObject2).jdField_a_of_type_Boolean)
      {
        ((Bundle)localObject1).putString("VIDEO_PUB_ACCOUNT_UIN", "" + paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qme.jdField_a_of_type_Long);
        ((Bundle)localObject1).putString("VIDEO_H5_URL", ((qlk)localObject2).jdField_a_of_type_Qln.jdField_c_of_type_JavaLangString);
        ((Bundle)localObject1).putLong("VIDEO_FEED_ID", ((qlk)localObject2).jdField_c_of_type_Long);
        ((Bundle)localObject1).putInt("VIDEO_FEED_TYPE", ((qlk)localObject2).jdField_b_of_type_Int);
        if (((qlk)localObject2).jdField_a_of_type_Qln != null) {}
        ((Bundle)localObject1).putString("VIDEO_TIME", String.valueOf(paramrjk.jdField_b_of_type_Int));
        ((Bundle)localObject1).putString("VIDEO_WIDTH", String.valueOf(paramrjk.jdField_c_of_type_Int));
        ((Bundle)localObject1).putString("VIDEO_HEIGHT", String.valueOf(paramrjk.jdField_d_of_type_Int));
        ((Bundle)localObject1).putString("VIDEO_VID", paramrjk.jdField_c_of_type_JavaLangString);
        ((Bundle)localObject1).putString("VIDEO_COVER", paramrjk.jdField_b_of_type_JavaLangString);
        ((Bundle)localObject1).putLong("VIDEO_XG_FILE_SIZE", paramBaseArticleInfo.mXGFileSize);
        ((Bundle)localObject1).putInt("VIDEO_STRATEGY_ID", paramrjk.jdField_g_of_type_Int);
        ((Bundle)localObject1).putLong("VIDEO_ALGORITHM_ID", paramrjk.jdField_g_of_type_Long);
        ((Bundle)localObject1).putString("VIDEO_SECOND_INDEX_INNER_ID", paramrjk.jdField_n_of_type_JavaLangString);
        if ((this.jdField_a_of_type_Pdn == null) || (this.jdField_a_of_type_Pdn.a() == null) || (this.jdField_a_of_type_Rjg == null) || (this.jdField_a_of_type_Pdn.a().jdField_c_of_type_Long != paramrjk.jdField_c_of_type_Long)) {
          break label959;
        }
        ((Bundle)localObject1).putLong("VIDEO_PLAY_POSITION", this.jdField_a_of_type_Rjg.a());
        ((Bundle)localObject1).putString("VIDEO_ARTICLE_ID", ((qlk)localObject2).jdField_g_of_type_JavaLangString);
        ((Bundle)localObject1).putString("VIDEO_TITLE", ((qlk)localObject2).jdField_a_of_type_JavaLangString);
        ((Bundle)localObject1).putBoolean("IS_FROM_READINJOY_VIDEO_CHANNEL", bkbq.a(this.jdField_d_of_type_Int));
        if (paramrjk.jdField_f_of_type_Int != 1) {
          break label971;
        }
        bool = true;
        label444:
        ((Bundle)localObject1).putBoolean("VIDEO_IS_FROM_PUBLIC_ACCOUNT", bool);
        ((Bundle)localObject1).putBoolean("isFromKandian", true);
        ((Bundle)localObject1).putLong("channelID", paramBaseArticleInfo.mChannelID);
        ((Bundle)localObject1).putLong("algorithmID", ((qlk)localObject2).jdField_b_of_type_Long);
        ((Bundle)localObject1).putString("innderId", ((qlk)localObject2).jdField_g_of_type_JavaLangString);
        ((Bundle)localObject1).putLong("strategyId", ((qlk)localObject2).jdField_a_of_type_Int);
        ((Bundle)localObject1).putString("VIDEO_THIRD_ICON", paramrjk.jdField_d_of_type_JavaLangString);
        ((Bundle)localObject1).putString("VIDEO_THIRD_NAME", paramrjk.jdField_e_of_type_JavaLangString);
        ((Bundle)localObject1).putString("VIDEO_THIRD_ACTION", paramrjk.jdField_f_of_type_JavaLangString);
        ((Bundle)localObject1).putString("VIDEO_THIRD_URL", paramrjk.jdField_g_of_type_JavaLangString);
        ((Bundle)localObject1).putLong("VIDEO_THRID_URL_EXPIRE_TIME", paramrjk.jdField_f_of_type_Long);
        ((Bundle)localObject1).putInt("VIDEO_ARTICLE_BUSITYPE", paramrjk.jdField_f_of_type_Int);
        localObject3 = new Bundle();
        ((Bundle)localObject3).putString("VINFO", paramrjk.jdField_c_of_type_JavaLangString);
        ((Bundle)localObject3).putString("TINFO", paramrjk.jdField_c_of_type_JavaLangString);
        ((Bundle)localObject3).putInt("PREVIEW_VIDEO_TIME", paramrjk.jdField_b_of_type_Int);
        if (this.jdField_a_of_type_Rjg != null) {
          break label977;
        }
      }
      label959:
      label971:
      label977:
      for (int i1 = 0;; i1 = (int)this.jdField_a_of_type_Rjg.a())
      {
        ((Bundle)localObject3).putInt("PREVIEW_START_POSI", rjm.a(i1, paramrjk.jdField_b_of_type_Int));
        ((Bundle)localObject3).putInt("PREVIEW_VIDEO_WIDTH", paramrjk.jdField_c_of_type_Int);
        ((Bundle)localObject3).putInt("PREVIEW_VIDEO_HEIGHT", paramrjk.jdField_d_of_type_Int);
        ((Bundle)localObject3).putInt("FULL_VIDEO_TIME", paramrjk.jdField_b_of_type_Int);
        ((Bundle)localObject3).putString("source_puin", ((qlk)localObject2).jdField_e_of_type_JavaLangString);
        ((Bundle)localObject3).putString("ACCOUNT_UIN", ((qlk)localObject2).jdField_e_of_type_JavaLangString);
        ((Bundle)localObject3).putString("ACCOUNT_NAME", ((qlk)localObject2).jdField_f_of_type_JavaLangString);
        ((Bundle)localObject3).putInt("TYPE", paramrjk.jdField_f_of_type_Int);
        ((Bundle)localObject3).putString("ARTICLE_ID", ((qlk)localObject2).jdField_g_of_type_JavaLangString);
        ((Bundle)localObject3).putInt("layout_item", 5);
        ((Bundle)localObject3).putBoolean("video_url_load", false);
        ((Bundle)localObject3).putString("image_url_remote", paramrjk.jdField_b_of_type_JavaLangString);
        ((Bundle)localObject3).putString("detail_url", ((qlk)localObject2).jdField_d_of_type_JavaLangString + "&sourcefrom=0");
        ((Bundle)localObject3).putString("video_url", paramrjk.jdField_c_of_type_JavaLangString);
        ((Bundle)localObject3).putString("title", ((qlk)localObject2).jdField_a_of_type_JavaLangString);
        ((Bundle)localObject3).putString("req_create_time", orr.a(paramBaseArticleInfo.mTime));
        ((Bundle)localObject3).putString("brief_key", ((qlk)localObject2).jdField_a_of_type_JavaLangString);
        ((Bundle)localObject3).putInt("req_type", 140);
        ((Bundle)localObject1).putByteArray("STRUCT_MSG_BYTES", ((StructMsgForGeneralShare)azvd.a((Bundle)localObject3)).getBytes());
        ((Bundle)localObject1).putString("KEY_VIDEO_JSON_LIST", paramBaseArticleInfo.mJsonVideoList);
        return localObject1;
        ((Bundle)localObject1).putString("VIDEO_PUB_ACCOUNT_UIN", ((qlk)localObject2).jdField_e_of_type_JavaLangString);
        ((Bundle)localObject1).putString("VIDEO_PUB_ACCOUNT_NAME", ((qlk)localObject2).jdField_f_of_type_JavaLangString);
        ((Bundle)localObject1).putString("VIDEO_H5_URL", ((qlk)localObject2).jdField_d_of_type_JavaLangString);
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
      QQAppInterface localQQAppInterface = (QQAppInterface)ors.a();
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
      str1 = ors.d(paramArticleInfo);
      str2 = ors.a(paramArticleInfo.mAlgorithmID, ors.a(paramArticleInfo), paramInt, i1, i2, bdin.h(null), str1, paramArticleInfo.mStrCircleId, paramArticleInfo.innerUniqueID, ors.f(paramArticleInfo), paramArticleInfo);
      if ((!b(paramArticleInfo)) && (!i(paramArticleInfo)) && (!j(paramArticleInfo)) && (!k(paramArticleInfo))) {
        break label243;
      }
      if ((paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmw == null)) {
        break label252;
      }
      str1 = Long.toString(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmw.jdField_a_of_type_Long);
    }
    for (;;)
    {
      String str3 = szp.b(paramInt);
      nrt.a(null, "CliOper", "", str1, str3, str3, 0, 0, Long.toString(paramArticleInfo.mFeedId), Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), str2, false);
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
    pdn localpdn = a(paramAbsListView);
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 4, "playVideoInArea:" + localpdn);
    }
    rjk localrjk;
    if (localpdn != null)
    {
      paramAbsListView = localpdn.a();
      localrjk = this.jdField_a_of_type_Rjg.a();
      if (paramAbsListView == this.jdField_a_of_type_Rjg.jdField_a_of_type_Rjk) {
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
        } while ((localrjk != null) && (localrjk.jdField_c_of_type_Long == paramAbsListView.jdField_c_of_type_Long) && (localrjk.jdField_b_of_type_Long == this.jdField_c_of_type_Int) && (!this.jdField_a_of_type_Rjg.d()) && (!this.jdField_a_of_type_Rjg.e()));
        rlb.a().b();
        a(localpdn);
      } while (!QLog.isColorLevel());
      QLog.d("Q.readinjoy.video", 2, "checkPlayableArea vid: " + paramAbsListView.jdField_c_of_type_JavaLangString);
      return;
      m();
    } while (this.jdField_a_of_type_Rjg.a() == null);
    this.jdField_a_of_type_Rjg.a().a(paramAbsListView);
  }
  
  private static void b(qkk paramqkk)
  {
    int i1 = 0;
    if (ors.j(paramqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo)) {
      paramqkk.jdField_b_of_type_Boolean = true;
    }
    while (paramqkk.jdField_b_of_type_Boolean) {
      return;
    }
    paramqkk.jdField_b_of_type_Boolean = true;
    ArrayList localArrayList = new ArrayList();
    ReportInfo localReportInfo = new ReportInfo();
    localReportInfo.mUin = ors.a();
    localReportInfo.mSource = 0;
    localReportInfo.mSourceArticleId = paramqkk.jdField_a_of_type_JavaLangLong.longValue();
    if (paramqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null) {
      i1 = (int)paramqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mChannelID;
    }
    localReportInfo.mChannelId = i1;
    localReportInfo.mAlgorithmId = ((int)paramqkk.jdField_a_of_type_Long);
    localReportInfo.mStrategyId = paramqkk.jdField_b_of_type_Int;
    localReportInfo.mOperation = 7;
    localReportInfo.mServerContext = paramqkk.jdField_a_of_type_ArrayOfByte;
    localReportInfo.mReadTimeLength = -1;
    localReportInfo.mInnerId = paramqkk.jdField_e_of_type_JavaLangString;
    if ((paramqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null) && (paramqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoColumnInfo != null)) {
      localReportInfo.mColumnID = paramqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_Int;
    }
    if ((paramqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null) && (paramqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo != null) && (!ors.l(paramqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo)))
    {
      qlv localqlv = new qlv();
      localqlv.jdField_a_of_type_Long = paramqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Long;
      if (paramqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qme != null) {
        localqlv.jdField_b_of_type_Long = paramqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qme.jdField_a_of_type_Long;
      }
      localqlv.jdField_a_of_type_Int = paramqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_b_of_type_Int;
      localqlv.jdField_b_of_type_Int = paramqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_d_of_type_Int;
      Object localObject = paramqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_JavaUtilList;
      if ((localObject != null) && (!((List)localObject).isEmpty()))
      {
        localqlv.jdField_a_of_type_JavaUtilList = new ArrayList();
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          qme localqme = (qme)((Iterator)localObject).next();
          if (localqme != null) {
            localqlv.jdField_a_of_type_JavaUtilList.add(Long.valueOf(localqme.jdField_a_of_type_Long));
          }
        }
      }
      localReportInfo.mFeedsReportData = localqlv;
    }
    if ((paramqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null) && (otf.c((int)paramqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mChannelID)))
    {
      localReportInfo.mSearchTagName = paramqkk.jdField_f_of_type_JavaLangString;
      opt.a(localReportInfo);
      return;
    }
    localArrayList.add(localReportInfo);
    QLog.d("ReadInJoyBaseAdapter", 2, "report0x64eExposureInfo: article " + localReportInfo.mSourceArticleId + " exposed!");
    owy.a().a(localArrayList);
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
    if (this.jdField_a_of_type_Rjk == null)
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
    return (paramBaseArticleInfo.mFeedType == 1) && (paramBaseArticleInfo.mSocialFeedInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmc != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmc.b != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmc.b.longValue() == 11L);
  }
  
  private boolean d()
  {
    if (!bkbq.a(this.jdField_d_of_type_Int)) {}
    String str;
    do
    {
      do
      {
        do
        {
          return false;
        } while (!bdin.g(this.jdField_a_of_type_AndroidAppActivity));
        str = ors.a(this.jdField_c_of_type_Long);
      } while (ors.jdField_d_of_type_JavaLangString.equals(str));
      if (ors.jdField_b_of_type_JavaLangString.equals(str)) {
        return true;
      }
    } while (!ors.jdField_c_of_type_JavaLangString.equals(str));
    return qzy.a(this.jdField_a_of_type_AndroidAppActivity);
  }
  
  public static boolean d(ArticleInfo paramArticleInfo)
  {
    if ((!f(paramArticleInfo)) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmc == null)) {
      return false;
    }
    switch (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmc.b.intValue())
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static boolean d(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo.mFeedType == 11) && (paramBaseArticleInfo.mTopicRecommendFeedsInfo != null) && (paramBaseArticleInfo.mTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList != null);
  }
  
  private int e()
  {
    if (ors.s()) {
      return bdaq.a(a(), 14.0F);
    }
    return bdaq.a(a(), 6.0F);
  }
  
  public static boolean e(ArticleInfo paramArticleInfo)
  {
    return (f(paramArticleInfo)) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmc != null);
  }
  
  public static boolean e(BaseArticleInfo paramBaseArticleInfo)
  {
    return ((paramBaseArticleInfo instanceof ArticleInfo)) && (q((ArticleInfo)paramBaseArticleInfo));
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
    return (paramBaseArticleInfo.mFeedType != 30) && ((paramBaseArticleInfo.mSocialFeedInfo == null) || (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmw == null) || (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmw.c.isEmpty()));
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
    return (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qnm == null) || (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qnm.jdField_a_of_type_JavaUtilArrayList == null) || (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qnm.jdField_a_of_type_JavaUtilArrayList.isEmpty());
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
    if ((paramArticleInfo == null) || (paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmc == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmc.b == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmw == null)) {
      return false;
    }
    switch (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmc.b.intValue())
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
    if ((paramArticleInfo == null) || (paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmc == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmw == null)) {
      return false;
    }
    switch (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmc.b.intValue())
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static boolean l(ArticleInfo paramArticleInfo)
  {
    return (k(paramArticleInfo)) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmw.jdField_a_of_type_Int == 1);
  }
  
  public static boolean m(ArticleInfo paramArticleInfo)
  {
    return (i(paramArticleInfo)) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmw.jdField_a_of_type_Int == 1);
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
    return (paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmw == null);
  }
  
  private void p()
  {
    if ((a() instanceof ReadInJoyChannelActivity))
    {
      this.jdField_g_of_type_Boolean = a().getIntent().getBooleanExtra("is_need_show_animation_translate", false);
      this.jdField_d_of_type_Boolean = a().getIntent().getBooleanExtra("is_need_show_animation_adapter", false);
    }
    this.jdField_a_of_type_AndroidViewAnimationAnimationSet = ((AnimationSet)AnimationUtils.loadAnimation(this.jdField_a_of_type_AndroidAppActivity, 2130772066));
    if (!rdm.b()) {
      this.jdField_a_of_type_AndroidViewAnimationAnimationSet.setDuration(400L);
    }
    if (this.jdField_c_of_type_Int == 56)
    {
      raa.a().a(true);
      raa.a().a(0);
    }
    AppNetConnInfo.registerConnectionChangeReceiver(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
  }
  
  public static boolean p(ArticleInfo paramArticleInfo)
  {
    return (paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmw == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmw.jdField_a_of_type_JavaUtilArrayList.size() == 0);
  }
  
  private void q()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyBaseAdapter", 2, "cpu:" + bdgk.b() + " mem:" + bdgk.d() + " fre:" + bdgk.a());
    }
    int i1 = bdgk.b();
    long l1 = bdgk.d();
    if ((i1 >= 4) && (l1 >= 1610612736.0D))
    {
      jdField_j_of_type_Int = 6;
      return;
    }
    jdField_j_of_type_Int = 4;
  }
  
  public static boolean q(ArticleInfo paramArticleInfo)
  {
    return (paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmw == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmw.jdField_b_of_type_JavaUtilArrayList.size() == 0);
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
          a(localArticleInfo, new pgq(this.jdField_a_of_type_AndroidAppActivity, localArticleInfo, getItemViewType(i4), this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, i4, this.jdField_c_of_type_Boolean, getCount(), null, this), System.currentTimeMillis(), i4);
        }
      }
    }
  }
  
  private void s()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyBaseAdapter", 2, "prefetch data");
    }
    if (this.jdField_a_of_type_Rrp != null) {
      this.jdField_a_of_type_Rrp.a();
    }
  }
  
  private void t()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a(this.jdField_a_of_type_Bhtv);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a(this.jdField_b_of_type_Bhtv);
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
    if (!bdin.h(this.jdField_a_of_type_AndroidAppActivity)) {}
    try
    {
      Object localObject = this.jdField_a_of_type_Rjg.a();
      long l1 = ((rjk)localObject).jdField_c_of_type_Long;
      localObject = b(((rjk)localObject).jdField_a_of_type_Int);
      if ((localObject != null) && (l1 != ((BaseArticleInfo)localObject).mArticleID))
      {
        this.jdField_a_of_type_Rjg.b(12);
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
    if (this.jdField_a_of_type_Rjg != null) {
      this.jdField_a_of_type_Rjg.b();
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
    if (this.jdField_a_of_type_Rjg != null) {
      l1 = this.jdField_a_of_type_Rjg.a();
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
  
  public bdbb a()
  {
    return null;
  }
  
  public bhxx a()
  {
    if (this.jdField_a_of_type_Bhxx == null) {
      this.jdField_a_of_type_Bhxx = new bhxx(this.jdField_a_of_type_AndroidAppActivity);
    }
    return this.jdField_a_of_type_Bhxx;
  }
  
  public bhyd a()
  {
    if (this.jdField_a_of_type_Bhyd == null) {
      this.jdField_a_of_type_Bhyd = new bhyd(this.jdField_a_of_type_AndroidAppActivity);
    }
    return this.jdField_a_of_type_Bhyd;
  }
  
  public ArticleInfo a()
  {
    long l1 = a().getIntent().getLongExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_SEQ", 0L);
    ArticleInfo localArticleInfo2 = owy.a().a(0, l1);
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
  
  public noq a()
  {
    return this.jdField_a_of_type_Noq;
  }
  
  public odt a()
  {
    return this.jdField_a_of_type_Odt;
  }
  
  public pdc a(int paramInt)
  {
    return (pdc)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
  }
  
  public pdq a(String paramString)
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
        return (pdq)paramString.getTag();
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
  
  public ppz a()
  {
    return jdField_a_of_type_Ppz;
  }
  
  public qzp a()
  {
    return this.jdField_a_of_type_Qzp;
  }
  
  public rjg a()
  {
    return this.jdField_a_of_type_Rjg;
  }
  
  public rrl a()
  {
    return this.jdField_a_of_type_Rrl;
  }
  
  public rrm a()
  {
    return this.jdField_a_of_type_Rrm;
  }
  
  public rrn a()
  {
    return this.jdField_a_of_type_Rrn;
  }
  
  public rro a()
  {
    return this.jdField_a_of_type_Rro;
  }
  
  public siw a()
  {
    if (this.jdField_a_of_type_Siw == null) {
      this.jdField_a_of_type_Siw = new siw(this.jdField_a_of_type_AndroidAppActivity, this);
    }
    return this.jdField_a_of_type_Siw;
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
    this.jdField_a_of_type_Bhxx = null;
    this.jdField_a_of_type_Bhyd = null;
    if (this.jdField_c_of_type_Int == 56) {
      raa.a().a();
    }
    if (this.jdField_a_of_type_Rkd != null) {
      this.jdField_a_of_type_Rkd.a();
    }
    if (this.jdField_a_of_type_Svl != null) {
      this.jdField_a_of_type_Svl.a();
    }
    this.jdField_a_of_type_Svl = null;
    ohf.b();
    if (this.jdField_a_of_type_Qzp != null) {
      this.jdField_a_of_type_Qzp.c();
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
          localObject1 = (rpw)((Container)localObject1).getTag(2131375322);
          if ((localObject1 == null) || (!((rpw)localObject1).a())) {}
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
          ((rpw)localObject1).a();
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
              localObject2 = (rpw)((Container)localObject2).getTag(2131375322);
              if ((localObject2 != null) && (localObject2 != localObject1)) {
                ((rpw)localObject2).b();
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
    if (this.jdField_a_of_type_Rjg == null) {}
    long l1;
    int i1;
    rjk localrjk;
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
        if ((!this.jdField_a_of_type_Rjg.d()) || (!this.jdField_a_of_type_Rjg.c())) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("Q.readinjoy.video", 2, "onActivityResult video is pause  && isPausedByMannul, just return");
      return;
      localrjk = this.jdField_a_of_type_Rjg.a();
      if (localrjk != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.readinjoy.video", 2, "onActivityResult getCurrentPlayVideoParam = null, just return");
    return;
    if (rcp.a().a())
    {
      this.jdField_a_of_type_Rjg.b(4);
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
    if (!TextUtils.equals(localrjk.jdField_j_of_type_JavaLangString, (CharSequence)localObject1))
    {
      paramIntent = b((String)localObject1);
      if (paramIntent == null)
      {
        l1 = localrjk.jdField_d_of_type_Long;
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
          QLog.d("Q.readinjoy.video", 2, "onActivityResult shouldContinuePlay = " + bool + ", playState=" + rjm.a(i1) + ", startPosition=" + l1 + "，curPlayParam=" + localrjk);
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
        rlb.a().a(false, "readinoy video continuePlay", 1);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.readinjoy.video", 2, "volumeControl set mute shouldContinuePlay");
        return;
        if (paramIntent.jdField_a_of_type_Rjk != null) {
          paramIntent.jdField_a_of_type_Rjk.jdField_d_of_type_Long = l1;
        }
        paramInt = 1;
        break label255;
        bool = false;
        break label272;
        label460:
        if ((l1 >= 0L) && (localrjk != null))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.readinjoy.video", 2, "onActivityResult resume with position:" + l1);
          }
          this.jdField_a_of_type_Rjg.a((int)l1, localrjk);
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.readinjoy.video", 2, "onActivityResult resume");
          }
          this.jdField_a_of_type_Rjg.f(true);
        }
      }
      label548:
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "onActivityResult stop");
      }
      if (this.jdField_a_of_type_Pdn == null) {
        break;
      }
      long l2 = this.jdField_a_of_type_Rjg.a();
      this.jdField_a_of_type_Rjg.b(4);
      paramIntent = this.jdField_a_of_type_Pdn.a();
      if (l1 > 0L) {
        l2 = l1;
      }
      paramIntent.jdField_d_of_type_Long = l2;
      if (l1 > 0L) {
        this.jdField_a_of_type_Pdn.a().jdField_e_of_type_Int = -1;
      }
      this.jdField_a_of_type_Pdn = null;
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
    int i1 = 2131700054;
    if (AdvertisementInfo.isAdvertisementInfo(localBaseArticleInfo)) {
      i1 = 2131700055;
    }
    if ((this.jdField_a_of_type_AndroidAppActivity instanceof BaseActivity)) {
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, -1, this.jdField_a_of_type_AndroidAppActivity.getString(i1), 0).b(((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).getTitleBarHeight());
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
        owy.a().a(this.jdField_a_of_type_AndroidAppActivity, (AdvertisementInfo)localBaseArticleInfo, l1, paramArrayList1, paramBoolean);
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
          paramArrayList.put("folder_status", ors.jdField_d_of_type_Int);
          paramArrayList.put("kandian_mode", ors.e());
          if (localBaseArticleInfo != null)
          {
            paramArrayList.put("feeds_type", "" + ors.a(localBaseArticleInfo));
            paramArrayList.put("rowkey", szp.a(localBaseArticleInfo));
          }
          paramArrayList = paramArrayList.toString();
          nrt.a(null, "", "0X8007059", "0X8007059", 0, 0, "", "", ors.a(paramArrayList1), paramArrayList, false);
        }
        label387:
        while (!(this.jdField_a_of_type_AndroidAppActivity instanceof PluginBaseActivity))
        {
          return;
          if (!(this.jdField_a_of_type_AndroidAppActivity instanceof PluginBaseActivity)) {
            break;
          }
          QQToast.a(this.jdField_a_of_type_AndroidAppActivity, -1, this.jdField_a_of_type_AndroidAppActivity.getString(i1), 0).b(((PluginBaseActivity)this.jdField_a_of_type_AndroidAppActivity).g());
          break;
          paramInt = 0;
          break label213;
        }
        paramArrayList.put("folder_status", 1);
        azqs.b(null, "CliOper", "", "", "0X8007060", "0X8007060", 0, 0, "", "", "", paramArrayList.toString());
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
      Object localObject = paramView.getTag(2131369027);
      if ((localObject != null) && ((localObject instanceof Animation)))
      {
        localObject = (Animation)paramView.getTag(2131369027);
        ((Animation)localObject).setAnimationListener(new rrd(this, paramView, paramArticleInfo, paramInt, paramArrayList));
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
          if (localObject != ((pgd)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(i2).getTag(2131379971)).a()) {}
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
            localObject = new rrc(this, (BaseArticleInfo)localObject, i1);
            Animation localAnimation = (Animation)paramAdvertisementInfo.getTag(2131369027);
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
    if (this.jdField_a_of_type_Svl != null)
    {
      this.jdField_a_of_type_Svl.a(paramArticleInfo);
      this.jdField_a_of_type_Svl.a(paramView, paramInt);
      this.jdField_a_of_type_Svl.a(this);
    }
  }
  
  public void a(BaseArticleInfo paramBaseArticleInfo)
  {
    this.jdField_b_of_type_JavaUtilList.remove(paramBaseArticleInfo);
    notifyDataSetChanged();
    this.o = true;
  }
  
  public void a(BaseArticleInfo paramBaseArticleInfo, pgd parampgd, long paramLong, int paramInt)
  {
    if ((paramBaseArticleInfo == null) || (this.jdField_b_of_type_JavaUtilSet == null) || (((paramBaseArticleInfo instanceof ArticleInfo)) && (jdField_a_of_type_Ppz.b((ArticleInfo)paramBaseArticleInfo)))) {
      break label31;
    }
    label31:
    while ((((paramBaseArticleInfo instanceof ArticleInfo)) && (pvq.a((ArticleInfo)paramBaseArticleInfo))) || ((ors.j(paramBaseArticleInfo)) && (!ors.l(paramBaseArticleInfo)))) {
      return;
    }
    if ((paramBaseArticleInfo.hasOnlyTwoVideoFeeds()) && (paramBaseArticleInfo.mSubArtilceList.size() > 0) && (paramBaseArticleInfo.mFeedType != 121))
    {
      Iterator localIterator = paramBaseArticleInfo.mSubArtilceList.iterator();
      while (localIterator.hasNext()) {
        a((ArticleInfo)localIterator.next(), new pgq(this.jdField_a_of_type_AndroidAppActivity, (ArticleInfo)paramBaseArticleInfo, 46, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, paramInt, this.jdField_c_of_type_Boolean, getCount(), null, this), paramLong, paramInt);
      }
    }
    int i1;
    if ((ors.s(paramBaseArticleInfo)) && (paramBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_Boolean)) {
      if (!this.jdField_a_of_type_JavaUtilMap.containsKey(Long.valueOf(-paramBaseArticleInfo.mArticleID))) {
        i1 = 1;
      }
    }
    for (;;)
    {
      if (i1 != 0) {
        ThreadManager.post(new ReadInJoyBaseAdapter.12(this, paramBaseArticleInfo, parampgd, paramInt, paramLong, paramBaseArticleInfo), 5, null, true);
      }
      if (!ors.q()) {
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
          } while (((this.jdField_a_of_type_Rjg != null) && (this.jdField_a_of_type_Rjg.h())) || (oek.a().a() == 1));
          if (localObject == null) {
            break;
          }
          localObject = ((pdn)localObject).a();
        } while ((localObject != null) && (((rjk)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null) && (((rjk)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.patchStatus.a.get() == 1));
      } while ((this.jdField_a_of_type_Rjg == null) || (!this.jdField_a_of_type_Qzy.a()) || (this.jdField_a_of_type_Qzy.b()) || (paramAbsListView == null) || (paramAbsListView.getVisibility() != 0));
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1001);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1001, paramInt);
    } while (!QLog.isColorLevel());
    QLog.d("Q.readinjoy.video", 2, "checkPlayableArea delay: " + paramInt);
  }
  
  public void a(List<BaseArticleInfo> paramList)
  {
    pdh.a(this.jdField_a_of_type_AndroidUtilSparseArray, new rqz(this, "onSetData", paramList));
    StringBuilder localStringBuilder;
    if ((paramList != null) && (this.jdField_b_of_type_JavaUtilList.getClass().isInstance(paramList)) && (paramList.size() > 0))
    {
      c(paramList);
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
      raa.a().a(this, this.jdField_b_of_type_JavaUtilList);
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
        if (peo.a(l1)) {
          peo.a().a(this.jdField_c_of_type_Int, l1);
        } else {
          owy.a().a(this.jdField_c_of_type_Int, localArticleInfo);
        }
      }
    }
    b(this.jdField_c_of_type_Int, paramInt);
  }
  
  public void a(Set<Long> paramSet, Map<Long, qkk> paramMap)
  {
    this.jdField_b_of_type_JavaUtilSet = paramSet;
    this.jdField_a_of_type_JavaUtilMap = paramMap;
  }
  
  public void a(noq paramnoq)
  {
    this.jdField_a_of_type_Noq = paramnoq;
  }
  
  public void a(odt paramodt)
  {
    this.jdField_a_of_type_Odt = paramodt;
  }
  
  /* Error */
  public void a(pdl parampdl, BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aload_2
    //   6: getfield 2713	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mSimpleVideoColumnInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo;
    //   9: ifnull +142 -> 151
    //   12: aload_2
    //   13: getfield 2713	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mSimpleVideoColumnInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo;
    //   16: astore 4
    //   18: aload 4
    //   20: getfield 2715	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:i	Ljava/lang/String;
    //   23: invokestatic 449	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   26: ifne +417 -> 443
    //   29: aload_1
    //   30: getfield 2719	pdl:jdField_f_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   33: aload 4
    //   35: getfield 2715	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:i	Ljava/lang/String;
    //   38: invokevirtual 2720	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   41: aload_1
    //   42: getfield 2719	pdl:jdField_f_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   45: iconst_0
    //   46: invokevirtual 1611	android/widget/TextView:setVisibility	(I)V
    //   49: aload 4
    //   51: getfield 2721	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   54: invokestatic 449	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   57: ifne +408 -> 465
    //   60: new 1233	java/net/URL
    //   63: dup
    //   64: aload 4
    //   66: getfield 2721	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   69: invokespecial 1592	java/net/URL:<init>	(Ljava/lang/String;)V
    //   72: astore 5
    //   74: aload_1
    //   75: getfield 2723	pdl:jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   78: aload 5
    //   80: invokevirtual 2726	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:a	(Ljava/net/URL;)Lcom/tencent/biz/pubaccount/readinjoy/view/imageloader/ZImageView;
    //   83: pop
    //   84: aload_1
    //   85: getfield 2723	pdl:jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   88: iconst_0
    //   89: invokevirtual 1610	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setVisibility	(I)V
    //   92: aload 4
    //   94: getfield 2727	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   97: invokestatic 449	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   100: ifne +395 -> 495
    //   103: aload_1
    //   104: getfield 2729	pdl:g	Landroid/widget/TextView;
    //   107: aload 4
    //   109: getfield 2727	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   112: invokevirtual 2720	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   115: aload_1
    //   116: getfield 2729	pdl:g	Landroid/widget/TextView;
    //   119: iconst_0
    //   120: invokevirtual 1611	android/widget/TextView:setVisibility	(I)V
    //   123: aload 4
    //   125: getfield 2730	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:jdField_j_of_type_JavaLangString	Ljava/lang/String;
    //   128: invokestatic 449	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   131: ifne +20 -> 151
    //   134: aload 4
    //   136: getfield 2730	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:jdField_j_of_type_JavaLangString	Ljava/lang/String;
    //   139: invokestatic 131	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   142: istore_3
    //   143: aload_1
    //   144: getfield 2729	pdl:g	Landroid/widget/TextView;
    //   147: iload_3
    //   148: invokevirtual 2733	android/widget/TextView:setTextColor	(I)V
    //   151: aload_2
    //   152: invokestatic 1835	rqj:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lrjk;
    //   155: astore 4
    //   157: aload 4
    //   159: aload_1
    //   160: getfield 2734	pdl:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   163: putfield 1841	rjk:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   166: aload 4
    //   168: aload_1
    //   169: getfield 2735	pdl:jdField_a_of_type_Int	I
    //   172: putfield 583	rjk:jdField_a_of_type_Int	I
    //   175: aload 4
    //   177: aload_2
    //   178: putfield 1208	rjk:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   181: aload_1
    //   182: aload 4
    //   184: putfield 2736	pdl:jdField_a_of_type_Rjk	Lrjk;
    //   187: aload_1
    //   188: getfield 2738	pdl:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   191: aload_2
    //   192: getfield 891	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mTitle	Ljava/lang/String;
    //   195: invokevirtual 2720	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   198: aload_1
    //   199: getfield 2738	pdl:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   202: invokevirtual 2742	android/widget/TextView:getPaint	()Landroid/text/TextPaint;
    //   205: iconst_1
    //   206: invokevirtual 2747	android/text/TextPaint:setFakeBoldText	(Z)V
    //   209: aload_1
    //   210: getfield 2738	pdl:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   213: aload_0
    //   214: getfield 247	rqj:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   217: invokevirtual 1568	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   220: ldc_w 2748
    //   223: invokevirtual 2753	android/content/res/Resources:getColor	(I)I
    //   226: invokevirtual 2733	android/widget/TextView:setTextColor	(I)V
    //   229: aload_1
    //   230: getfield 2755	pdl:jdField_b_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   233: bipush 8
    //   235: invokevirtual 1611	android/widget/TextView:setVisibility	(I)V
    //   238: aload_1
    //   239: getfield 2757	pdl:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   242: aload 4
    //   244: getfield 669	rjk:jdField_b_of_type_Int	I
    //   247: invokestatic 2758	orc:a	(I)Ljava/lang/String;
    //   250: invokevirtual 2720	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   253: aload_1
    //   254: getfield 2760	pdl:jdField_b_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   257: bipush 10
    //   259: bipush 10
    //   261: bipush 10
    //   263: bipush 10
    //   265: invokestatic 2765	xsm:a	(Landroid/view/View;IIII)V
    //   268: aload_1
    //   269: getfield 2760	pdl:jdField_b_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   272: aload_1
    //   273: invokevirtual 1832	android/widget/ImageView:setTag	(Ljava/lang/Object;)V
    //   276: aload_1
    //   277: getfield 2760	pdl:jdField_b_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   280: aload_0
    //   281: invokevirtual 1821	android/widget/ImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   284: aload_0
    //   285: getfield 247	rqj:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   288: aload_1
    //   289: getfield 2734	pdl:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   292: aload_1
    //   293: getfield 2736	pdl:jdField_a_of_type_Rjk	Lrjk;
    //   296: invokestatic 2768	pdj:a	(Landroid/content/Context;Landroid/widget/ImageView;Lrjk;)V
    //   299: aload_0
    //   300: aload_1
    //   301: getfield 2734	pdl:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   304: aload_2
    //   305: iconst_0
    //   306: invokevirtual 1141	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:getVideoCoverUrlWithSmartCut	(Z)Ljava/net/URL;
    //   309: iconst_0
    //   310: invokespecial 1666	rqj:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;Ljava/net/URL;Z)V
    //   313: aload_1
    //   314: getfield 2734	pdl:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   317: aload_0
    //   318: invokevirtual 2772	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setOnLongClickListener	(Landroid/view/View$OnLongClickListener;)V
    //   321: aload_1
    //   322: getfield 2775	pdl:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup	Lcom/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup;
    //   325: fconst_1
    //   326: aload 4
    //   328: getfield 839	rjk:jdField_c_of_type_Int	I
    //   331: aload 4
    //   333: getfield 842	rjk:jdField_d_of_type_Int	I
    //   336: invokestatic 2778	orc:a	(II)F
    //   339: invokevirtual 2784	com/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup:setCustomSize	(FF)V
    //   342: aload_1
    //   343: getfield 2775	pdl:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup	Lcom/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup;
    //   346: aload_1
    //   347: invokevirtual 2785	com/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup:setTag	(Ljava/lang/Object;)V
    //   350: aload_0
    //   351: aload_0
    //   352: getfield 142	rqj:jdField_c_of_type_Int	I
    //   355: aload_2
    //   356: getfield 1125	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mArticleID	J
    //   359: invokevirtual 2787	rqj:b	(IJ)Z
    //   362: ifeq +23 -> 385
    //   365: aload_1
    //   366: getfield 2789	pdl:jdField_f_of_type_AndroidViewView	Landroid/view/View;
    //   369: aload_0
    //   370: getfield 247	rqj:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   373: invokevirtual 1568	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   376: ldc_w 2790
    //   379: invokevirtual 2753	android/content/res/Resources:getColor	(I)I
    //   382: invokevirtual 2793	android/view/View:setBackgroundColor	(I)V
    //   385: aload_2
    //   386: getfield 697	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mXGFileSize	J
    //   389: lconst_0
    //   390: lcmp
    //   391: ifgt +116 -> 507
    //   394: aload_1
    //   395: getfield 2795	pdl:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   398: ldc_w 2796
    //   401: invokestatic 1623	alud:a	(I)Ljava/lang/String;
    //   404: invokevirtual 2720	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   407: aload_0
    //   408: getfield 247	rqj:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   411: invokestatic 1254	bdin:h	(Landroid/content/Context;)Z
    //   414: ifeq +132 -> 546
    //   417: aload_1
    //   418: getfield 2798	pdl:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   421: iconst_0
    //   422: invokevirtual 1636	android/widget/ImageView:setVisibility	(I)V
    //   425: aload_1
    //   426: getfield 2795	pdl:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   429: bipush 8
    //   431: invokevirtual 1611	android/widget/TextView:setVisibility	(I)V
    //   434: aload_1
    //   435: getfield 2800	pdl:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   438: iconst_0
    //   439: invokevirtual 2793	android/view/View:setBackgroundColor	(I)V
    //   442: return
    //   443: aload_1
    //   444: getfield 2719	pdl:jdField_f_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   447: bipush 8
    //   449: invokevirtual 1611	android/widget/TextView:setVisibility	(I)V
    //   452: goto -403 -> 49
    //   455: astore 5
    //   457: aload 5
    //   459: invokevirtual 2801	java/lang/Exception:printStackTrace	()V
    //   462: goto -370 -> 92
    //   465: aload_1
    //   466: getfield 2723	pdl:jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   469: bipush 8
    //   471: invokevirtual 1610	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setVisibility	(I)V
    //   474: goto -382 -> 92
    //   477: astore 4
    //   479: aload_1
    //   480: getfield 2729	pdl:g	Landroid/widget/TextView;
    //   483: ldc_w 2803
    //   486: invokestatic 131	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   489: invokevirtual 2733	android/widget/TextView:setTextColor	(I)V
    //   492: goto -341 -> 151
    //   495: aload_1
    //   496: getfield 2729	pdl:g	Landroid/widget/TextView;
    //   499: bipush 8
    //   501: invokevirtual 1611	android/widget/TextView:setVisibility	(I)V
    //   504: goto -353 -> 151
    //   507: aload_1
    //   508: getfield 2795	pdl:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   511: new 854	java/lang/StringBuilder
    //   514: dup
    //   515: invokespecial 855	java/lang/StringBuilder:<init>	()V
    //   518: aload_2
    //   519: getfield 697	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mXGFileSize	J
    //   522: invokestatic 2804	rdm:b	(J)Ljava/lang/String;
    //   525: invokevirtual 859	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   528: ldc_w 2805
    //   531: invokestatic 1623	alud:a	(I)Ljava/lang/String;
    //   534: invokevirtual 859	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   537: invokevirtual 865	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   540: invokevirtual 2720	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   543: goto -136 -> 407
    //   546: aload_1
    //   547: getfield 2798	pdl:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   550: bipush 8
    //   552: invokevirtual 1636	android/widget/ImageView:setVisibility	(I)V
    //   555: aload_0
    //   556: getfield 247	rqj:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   559: invokevirtual 1568	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   562: ldc_w 2806
    //   565: invokevirtual 2809	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   568: astore 4
    //   570: aload_1
    //   571: getfield 2795	pdl:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   574: aload 4
    //   576: aconst_null
    //   577: aconst_null
    //   578: aconst_null
    //   579: invokevirtual 2813	android/widget/TextView:setCompoundDrawablesWithIntrinsicBounds	(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V
    //   582: aload_1
    //   583: getfield 2795	pdl:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   586: ldc_w 2130
    //   589: aload_0
    //   590: getfield 247	rqj:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   593: invokevirtual 1568	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   596: invokestatic 610	aepi:a	(FLandroid/content/res/Resources;)I
    //   599: invokevirtual 2816	android/widget/TextView:setCompoundDrawablePadding	(I)V
    //   602: aload_1
    //   603: getfield 2795	pdl:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   606: iconst_0
    //   607: invokevirtual 1611	android/widget/TextView:setVisibility	(I)V
    //   610: invokestatic 2819	beaa:a	()I
    //   613: iconst_1
    //   614: if_icmpne +34 -> 648
    //   617: aload_1
    //   618: getfield 2795	pdl:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   621: ldc_w 2820
    //   624: invokestatic 1623	alud:a	(I)Ljava/lang/String;
    //   627: invokevirtual 2720	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   630: aload_1
    //   631: getfield 2822	pdl:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   634: bipush 8
    //   636: invokevirtual 1611	android/widget/TextView:setVisibility	(I)V
    //   639: aload_1
    //   640: getfield 2800	pdl:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   643: iconst_0
    //   644: invokevirtual 2793	android/view/View:setBackgroundColor	(I)V
    //   647: return
    //   648: invokestatic 2824	bkbq:v	()Z
    //   651: ifeq +280 -> 931
    //   654: aload_0
    //   655: getfield 2825	rqj:jdField_h_of_type_Boolean	Z
    //   658: ifne +273 -> 931
    //   661: aload_1
    //   662: getfield 2735	pdl:jdField_a_of_type_Int	I
    //   665: ifne +266 -> 931
    //   668: invokestatic 2827	bkbq:d	()Ljava/lang/String;
    //   671: astore 5
    //   673: invokestatic 2829	bkbq:e	()Ljava/lang/String;
    //   676: astore 6
    //   678: invokestatic 2831	bkbq:f	()Ljava/lang/String;
    //   681: astore 7
    //   683: aload 5
    //   685: invokestatic 449	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   688: ifne +209 -> 897
    //   691: invokestatic 2833	ors:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   694: astore 8
    //   696: ldc_w 940
    //   699: astore 4
    //   701: aload 8
    //   703: ifnull +10 -> 713
    //   706: aload 8
    //   708: invokevirtual 2836	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   711: astore 4
    //   713: new 1366	ron
    //   716: dup
    //   717: aconst_null
    //   718: aconst_null
    //   719: aconst_null
    //   720: aconst_null
    //   721: invokespecial 1369	ron:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   724: aload 4
    //   726: invokevirtual 2839	ron:l	(Ljava/lang/String;)Lron;
    //   729: aload_2
    //   730: getfield 798	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:innerUniqueID	Ljava/lang/String;
    //   733: invokevirtual 2841	ron:h	(Ljava/lang/String;)Lron;
    //   736: invokevirtual 1392	ron:a	()Lrom;
    //   739: invokevirtual 1396	rom:a	()Ljava/lang/String;
    //   742: astore_2
    //   743: aload_1
    //   744: getfield 2822	pdl:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   747: iconst_0
    //   748: invokevirtual 1611	android/widget/TextView:setVisibility	(I)V
    //   751: aload_1
    //   752: getfield 2822	pdl:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   755: fconst_2
    //   756: aload_0
    //   757: getfield 247	rqj:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   760: invokevirtual 1568	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   763: invokestatic 610	aepi:a	(FLandroid/content/res/Resources;)I
    //   766: invokevirtual 2816	android/widget/TextView:setCompoundDrawablePadding	(I)V
    //   769: aload_0
    //   770: getfield 247	rqj:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   773: invokevirtual 1568	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   776: ldc_w 2842
    //   779: invokevirtual 2809	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   782: astore 4
    //   784: aload 4
    //   786: iconst_0
    //   787: iconst_0
    //   788: ldc_w 2843
    //   791: aload_0
    //   792: getfield 247	rqj:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   795: invokevirtual 1568	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   798: invokestatic 610	aepi:a	(FLandroid/content/res/Resources;)I
    //   801: ldc_w 2843
    //   804: aload_0
    //   805: getfield 247	rqj:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   808: invokevirtual 1568	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   811: invokestatic 610	aepi:a	(FLandroid/content/res/Resources;)I
    //   814: invokevirtual 2848	android/graphics/drawable/Drawable:setBounds	(IIII)V
    //   817: aload_1
    //   818: getfield 2822	pdl:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   821: aconst_null
    //   822: aconst_null
    //   823: aload 4
    //   825: aconst_null
    //   826: invokevirtual 2851	android/widget/TextView:setCompoundDrawables	(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V
    //   829: aload_0
    //   830: getfield 247	rqj:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   833: aload_1
    //   834: getfield 2822	pdl:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   837: aload 6
    //   839: aload 7
    //   841: aload 5
    //   843: new 2853	rrj
    //   846: dup
    //   847: aload_0
    //   848: aload_2
    //   849: invokespecial 2854	rrj:<init>	(Lrqj;Ljava/lang/String;)V
    //   852: invokestatic 2857	rdm:b	(Landroid/content/Context;Landroid/widget/TextView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/view/View$OnClickListener;)V
    //   855: aload_1
    //   856: getfield 2800	pdl:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   859: ldc_w 2858
    //   862: invokevirtual 2793	android/view/View:setBackgroundColor	(I)V
    //   865: aload_0
    //   866: iconst_1
    //   867: putfield 2825	rqj:jdField_h_of_type_Boolean	Z
    //   870: aconst_null
    //   871: ldc_w 940
    //   874: ldc_w 2860
    //   877: ldc_w 2860
    //   880: iconst_0
    //   881: iconst_0
    //   882: ldc_w 940
    //   885: ldc_w 940
    //   888: ldc_w 940
    //   891: aload_2
    //   892: iconst_0
    //   893: invokestatic 1405	nrt:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   896: return
    //   897: aload_1
    //   898: getfield 2822	pdl:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   901: bipush 8
    //   903: invokevirtual 1611	android/widget/TextView:setVisibility	(I)V
    //   906: aload_1
    //   907: getfield 2800	pdl:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   910: iconst_0
    //   911: invokevirtual 2793	android/view/View:setBackgroundColor	(I)V
    //   914: invokestatic 344	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   917: ifeq -913 -> 4
    //   920: ldc_w 1091
    //   923: iconst_2
    //   924: ldc_w 2862
    //   927: invokestatic 1096	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   930: return
    //   931: aload_1
    //   932: getfield 2822	pdl:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   935: bipush 8
    //   937: invokevirtual 1611	android/widget/TextView:setVisibility	(I)V
    //   940: aload_1
    //   941: getfield 2800	pdl:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   944: iconst_0
    //   945: invokevirtual 2793	android/view/View:setBackgroundColor	(I)V
    //   948: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	949	0	this	rqj
    //   0	949	1	parampdl	pdl
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
  public void a(pdm parampdm, BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aload_2
    //   6: getfield 2866	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mArticleSubscriptText	Ljava/lang/String;
    //   9: invokestatic 449	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   12: ifne +515 -> 527
    //   15: aload_1
    //   16: getfield 2869	pdm:i	Landroid/widget/TextView;
    //   19: aload_2
    //   20: getfield 2866	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mArticleSubscriptText	Ljava/lang/String;
    //   23: invokevirtual 2720	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   26: aload_2
    //   27: getfield 2872	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mArticleSubscriptColor	Ljava/lang/String;
    //   30: invokestatic 449	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   33: ifeq +485 -> 518
    //   36: ldc_w 2874
    //   39: astore 4
    //   41: aload 4
    //   43: invokestatic 131	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   46: istore_3
    //   47: aload_1
    //   48: getfield 2869	pdm:i	Landroid/widget/TextView;
    //   51: iload_3
    //   52: invokevirtual 2733	android/widget/TextView:setTextColor	(I)V
    //   55: aload_1
    //   56: getfield 2869	pdm:i	Landroid/widget/TextView;
    //   59: iconst_0
    //   60: invokevirtual 1611	android/widget/TextView:setVisibility	(I)V
    //   63: aload_1
    //   64: getfield 2875	pdm:g	Landroid/widget/TextView;
    //   67: aload_2
    //   68: getfield 647	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mSubscribeName	Ljava/lang/String;
    //   71: invokevirtual 2720	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   74: aload_2
    //   75: invokevirtual 1584	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:hasFamilyCommentIcon	()Z
    //   78: ifeq +476 -> 554
    //   81: new 1233	java/net/URL
    //   84: dup
    //   85: aload_2
    //   86: getfield 1588	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:familyCommentInfo	Lqku;
    //   89: getfield 1591	qku:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   92: invokespecial 1592	java/net/URL:<init>	(Ljava/lang/String;)V
    //   95: astore 4
    //   97: aload_2
    //   98: getfield 1588	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:familyCommentInfo	Lqku;
    //   101: getfield 1593	qku:jdField_b_of_type_Int	I
    //   104: ifle +27 -> 131
    //   107: aload_0
    //   108: aload_1
    //   109: getfield 2876	pdm:jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   112: aload 4
    //   114: aload_2
    //   115: getfield 1588	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:familyCommentInfo	Lqku;
    //   118: getfield 1594	qku:jdField_a_of_type_Int	I
    //   121: aload_2
    //   122: getfield 1588	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:familyCommentInfo	Lqku;
    //   125: getfield 1593	qku:jdField_b_of_type_Int	I
    //   128: invokespecial 1597	rqj:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;Ljava/net/URL;II)V
    //   131: aload_1
    //   132: getfield 2876	pdm:jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   135: iconst_0
    //   136: invokevirtual 1610	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setVisibility	(I)V
    //   139: aload_1
    //   140: getfield 2877	pdm:h	Landroid/widget/TextView;
    //   143: bipush 8
    //   145: invokevirtual 1611	android/widget/TextView:setVisibility	(I)V
    //   148: aload_2
    //   149: getfield 2880	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:vIconUrl	Ljava/lang/String;
    //   152: invokestatic 449	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   155: ifne +475 -> 630
    //   158: new 1233	java/net/URL
    //   161: dup
    //   162: aload_2
    //   163: getfield 2880	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:vIconUrl	Ljava/lang/String;
    //   166: invokespecial 1592	java/net/URL:<init>	(Ljava/lang/String;)V
    //   169: astore 4
    //   171: aload_1
    //   172: getfield 2882	pdm:jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   175: aload 4
    //   177: invokevirtual 2726	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:a	(Ljava/net/URL;)Lcom/tencent/biz/pubaccount/readinjoy/view/imageloader/ZImageView;
    //   180: pop
    //   181: aload_1
    //   182: getfield 2882	pdm:jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   185: iconst_0
    //   186: invokevirtual 1610	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setVisibility	(I)V
    //   189: aload_1
    //   190: getfield 2883	pdm:jdField_b_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   193: bipush 10
    //   195: bipush 10
    //   197: bipush 10
    //   199: bipush 10
    //   201: invokestatic 2765	xsm:a	(Landroid/view/View;IIII)V
    //   204: aload_1
    //   205: getfield 2883	pdm:jdField_b_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   208: aload_1
    //   209: invokevirtual 1832	android/widget/ImageView:setTag	(Ljava/lang/Object;)V
    //   212: aload_1
    //   213: getfield 2883	pdm:jdField_b_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   216: aload_0
    //   217: invokevirtual 1821	android/widget/ImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   220: aload_2
    //   221: invokestatic 1835	rqj:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lrjk;
    //   224: astore 4
    //   226: aload 4
    //   228: aload_1
    //   229: getfield 2884	pdm:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   232: putfield 1841	rjk:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   235: aload 4
    //   237: aload_1
    //   238: getfield 2885	pdm:jdField_a_of_type_Int	I
    //   241: putfield 583	rjk:jdField_a_of_type_Int	I
    //   244: aload 4
    //   246: aload_2
    //   247: putfield 1208	rjk:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   250: aload 4
    //   252: iconst_1
    //   253: putfield 2886	rjk:jdField_n_of_type_Int	I
    //   256: aload_1
    //   257: aload 4
    //   259: putfield 2887	pdm:jdField_a_of_type_Rjk	Lrjk;
    //   262: aload_1
    //   263: getfield 2888	pdm:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   266: bipush 8
    //   268: invokevirtual 1611	android/widget/TextView:setVisibility	(I)V
    //   271: aload_1
    //   272: getfield 2889	pdm:jdField_b_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   275: bipush 8
    //   277: invokevirtual 1611	android/widget/TextView:setVisibility	(I)V
    //   280: aload_1
    //   281: getfield 2891	pdm:jdField_c_of_type_AndroidViewView	Landroid/view/View;
    //   284: bipush 8
    //   286: invokevirtual 1581	android/view/View:setVisibility	(I)V
    //   289: aload_1
    //   290: getfield 2892	pdm:jdField_f_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   293: aload_2
    //   294: getfield 891	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mTitle	Ljava/lang/String;
    //   297: invokevirtual 2720	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   300: aload_1
    //   301: getfield 2892	pdm:jdField_f_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   304: astore 5
    //   306: invokestatic 2074	owy:a	()Lowy;
    //   309: aload_2
    //   310: getfield 1125	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mArticleID	J
    //   313: invokevirtual 2893	owy:a	(J)Z
    //   316: ifeq +326 -> 642
    //   319: getstatic 133	rqj:jdField_g_of_type_Int	I
    //   322: istore_3
    //   323: aload 5
    //   325: iload_3
    //   326: invokevirtual 2733	android/widget/TextView:setTextColor	(I)V
    //   329: aload_1
    //   330: getfield 2894	pdm:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   333: aload 4
    //   335: getfield 669	rjk:jdField_b_of_type_Int	I
    //   338: invokestatic 2758	orc:a	(I)Ljava/lang/String;
    //   341: invokevirtual 2720	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   344: aload_0
    //   345: getfield 247	rqj:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   348: aload_1
    //   349: getfield 2884	pdm:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   352: aload_1
    //   353: getfield 2887	pdm:jdField_a_of_type_Rjk	Lrjk;
    //   356: invokestatic 2768	pdj:a	(Landroid/content/Context;Landroid/widget/ImageView;Lrjk;)V
    //   359: aload_0
    //   360: aload_1
    //   361: getfield 2884	pdm:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   364: aload_2
    //   365: iconst_0
    //   366: invokevirtual 1141	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:getVideoCoverUrlWithSmartCut	(Z)Ljava/net/URL;
    //   369: iconst_0
    //   370: invokespecial 1666	rqj:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;Ljava/net/URL;Z)V
    //   373: aload_1
    //   374: getfield 2884	pdm:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   377: aload_0
    //   378: invokevirtual 2772	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setOnLongClickListener	(Landroid/view/View$OnLongClickListener;)V
    //   381: aload_1
    //   382: getfield 2894	pdm:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   385: iconst_0
    //   386: invokevirtual 1611	android/widget/TextView:setVisibility	(I)V
    //   389: aload_1
    //   390: getfield 2894	pdm:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   393: invokevirtual 2897	android/widget/TextView:clearAnimation	()V
    //   396: aload_1
    //   397: getfield 2898	pdm:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup	Lcom/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup;
    //   400: fconst_1
    //   401: aload 4
    //   403: getfield 839	rjk:jdField_c_of_type_Int	I
    //   406: aload 4
    //   408: getfield 842	rjk:jdField_d_of_type_Int	I
    //   411: invokestatic 2778	orc:a	(II)F
    //   414: invokevirtual 2784	com/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup:setCustomSize	(FF)V
    //   417: aload_1
    //   418: getfield 2898	pdm:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup	Lcom/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup;
    //   421: aload_1
    //   422: invokevirtual 2785	com/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup:setTag	(Ljava/lang/Object;)V
    //   425: aload_0
    //   426: aload_0
    //   427: getfield 142	rqj:jdField_c_of_type_Int	I
    //   430: aload_2
    //   431: getfield 1125	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mArticleID	J
    //   434: invokevirtual 2787	rqj:b	(IJ)Z
    //   437: ifeq +23 -> 460
    //   440: aload_1
    //   441: getfield 2899	pdm:jdField_f_of_type_AndroidViewView	Landroid/view/View;
    //   444: aload_0
    //   445: getfield 247	rqj:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   448: invokevirtual 1568	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   451: ldc_w 2790
    //   454: invokevirtual 2753	android/content/res/Resources:getColor	(I)I
    //   457: invokevirtual 2793	android/view/View:setBackgroundColor	(I)V
    //   460: aload_2
    //   461: getfield 697	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mXGFileSize	J
    //   464: lconst_0
    //   465: lcmp
    //   466: ifgt +183 -> 649
    //   469: aload_1
    //   470: getfield 2900	pdm:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   473: ldc_w 2796
    //   476: invokestatic 1623	alud:a	(I)Ljava/lang/String;
    //   479: invokevirtual 2720	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   482: aload_0
    //   483: getfield 247	rqj:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   486: invokestatic 1254	bdin:h	(Landroid/content/Context;)Z
    //   489: ifeq +199 -> 688
    //   492: aload_1
    //   493: getfield 2901	pdm:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   496: iconst_0
    //   497: invokevirtual 1636	android/widget/ImageView:setVisibility	(I)V
    //   500: aload_1
    //   501: getfield 2900	pdm:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   504: bipush 8
    //   506: invokevirtual 1611	android/widget/TextView:setVisibility	(I)V
    //   509: aload_1
    //   510: getfield 2902	pdm:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   513: iconst_0
    //   514: invokevirtual 2793	android/view/View:setBackgroundColor	(I)V
    //   517: return
    //   518: aload_2
    //   519: getfield 2872	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mArticleSubscriptColor	Ljava/lang/String;
    //   522: astore 4
    //   524: goto -483 -> 41
    //   527: aload_1
    //   528: getfield 2869	pdm:i	Landroid/widget/TextView;
    //   531: bipush 8
    //   533: invokevirtual 1611	android/widget/TextView:setVisibility	(I)V
    //   536: goto -473 -> 63
    //   539: astore 4
    //   541: ldc_w 346
    //   544: iconst_2
    //   545: ldc_w 2904
    //   548: invokestatic 351	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   551: goto -403 -> 148
    //   554: aload_1
    //   555: getfield 2876	pdm:jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   558: bipush 8
    //   560: invokevirtual 1610	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setVisibility	(I)V
    //   563: aload_1
    //   564: getfield 2877	pdm:h	Landroid/widget/TextView;
    //   567: iconst_0
    //   568: invokevirtual 1611	android/widget/TextView:setVisibility	(I)V
    //   571: ldc_w 346
    //   574: iconst_2
    //   575: ldc_w 2906
    //   578: invokestatic 351	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   581: aload_1
    //   582: getfield 2877	pdm:h	Landroid/widget/TextView;
    //   585: new 854	java/lang/StringBuilder
    //   588: dup
    //   589: invokespecial 855	java/lang/StringBuilder:<init>	()V
    //   592: aload_2
    //   593: invokevirtual 1618	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:getCommentCount	()I
    //   596: invokestatic 2908	rdm:d	(I)Ljava/lang/String;
    //   599: invokevirtual 859	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   602: ldc_w 2909
    //   605: invokestatic 1623	alud:a	(I)Ljava/lang/String;
    //   608: invokevirtual 859	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   611: invokevirtual 865	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   614: invokevirtual 2720	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   617: goto -469 -> 148
    //   620: astore 4
    //   622: aload 4
    //   624: invokevirtual 2801	java/lang/Exception:printStackTrace	()V
    //   627: goto -438 -> 189
    //   630: aload_1
    //   631: getfield 2882	pdm:jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   634: bipush 8
    //   636: invokevirtual 1610	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setVisibility	(I)V
    //   639: goto -450 -> 189
    //   642: getstatic 137	rqj:jdField_h_of_type_Int	I
    //   645: istore_3
    //   646: goto -323 -> 323
    //   649: aload_1
    //   650: getfield 2900	pdm:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   653: new 854	java/lang/StringBuilder
    //   656: dup
    //   657: invokespecial 855	java/lang/StringBuilder:<init>	()V
    //   660: aload_2
    //   661: getfield 697	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mXGFileSize	J
    //   664: invokestatic 2804	rdm:b	(J)Ljava/lang/String;
    //   667: invokevirtual 859	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   670: ldc_w 2805
    //   673: invokestatic 1623	alud:a	(I)Ljava/lang/String;
    //   676: invokevirtual 859	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   679: invokevirtual 865	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   682: invokevirtual 2720	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   685: goto -203 -> 482
    //   688: aload_1
    //   689: getfield 2901	pdm:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   692: bipush 8
    //   694: invokevirtual 1636	android/widget/ImageView:setVisibility	(I)V
    //   697: aload_0
    //   698: getfield 247	rqj:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   701: invokevirtual 1568	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   704: ldc_w 2806
    //   707: invokevirtual 2809	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   710: astore 4
    //   712: aload_1
    //   713: getfield 2900	pdm:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   716: aload 4
    //   718: aconst_null
    //   719: aconst_null
    //   720: aconst_null
    //   721: invokevirtual 2813	android/widget/TextView:setCompoundDrawablesWithIntrinsicBounds	(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V
    //   724: aload_1
    //   725: getfield 2900	pdm:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   728: ldc_w 2130
    //   731: aload_0
    //   732: getfield 247	rqj:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   735: invokevirtual 1568	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   738: invokestatic 610	aepi:a	(FLandroid/content/res/Resources;)I
    //   741: invokevirtual 2816	android/widget/TextView:setCompoundDrawablePadding	(I)V
    //   744: aload_1
    //   745: getfield 2900	pdm:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   748: iconst_0
    //   749: invokevirtual 1611	android/widget/TextView:setVisibility	(I)V
    //   752: invokestatic 2819	beaa:a	()I
    //   755: iconst_1
    //   756: if_icmpne +34 -> 790
    //   759: aload_1
    //   760: getfield 2900	pdm:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   763: ldc_w 2820
    //   766: invokestatic 1623	alud:a	(I)Ljava/lang/String;
    //   769: invokevirtual 2720	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   772: aload_1
    //   773: getfield 2910	pdm:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   776: bipush 8
    //   778: invokevirtual 1611	android/widget/TextView:setVisibility	(I)V
    //   781: aload_1
    //   782: getfield 2902	pdm:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   785: iconst_0
    //   786: invokevirtual 2793	android/view/View:setBackgroundColor	(I)V
    //   789: return
    //   790: invokestatic 2824	bkbq:v	()Z
    //   793: ifeq +280 -> 1073
    //   796: aload_0
    //   797: getfield 2825	rqj:jdField_h_of_type_Boolean	Z
    //   800: ifne +273 -> 1073
    //   803: aload_1
    //   804: getfield 2885	pdm:jdField_a_of_type_Int	I
    //   807: ifne +266 -> 1073
    //   810: invokestatic 2827	bkbq:d	()Ljava/lang/String;
    //   813: astore 5
    //   815: invokestatic 2829	bkbq:e	()Ljava/lang/String;
    //   818: astore 6
    //   820: invokestatic 2831	bkbq:f	()Ljava/lang/String;
    //   823: astore 7
    //   825: aload 5
    //   827: invokestatic 449	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   830: ifne +209 -> 1039
    //   833: invokestatic 2833	ors:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   836: astore 8
    //   838: ldc_w 940
    //   841: astore 4
    //   843: aload 8
    //   845: ifnull +10 -> 855
    //   848: aload 8
    //   850: invokevirtual 2836	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   853: astore 4
    //   855: new 1366	ron
    //   858: dup
    //   859: aconst_null
    //   860: aconst_null
    //   861: aconst_null
    //   862: aconst_null
    //   863: invokespecial 1369	ron:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   866: aload 4
    //   868: invokevirtual 2839	ron:l	(Ljava/lang/String;)Lron;
    //   871: aload_2
    //   872: getfield 798	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:innerUniqueID	Ljava/lang/String;
    //   875: invokevirtual 2841	ron:h	(Ljava/lang/String;)Lron;
    //   878: invokevirtual 1392	ron:a	()Lrom;
    //   881: invokevirtual 1396	rom:a	()Ljava/lang/String;
    //   884: astore_2
    //   885: aload_1
    //   886: getfield 2910	pdm:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   889: iconst_0
    //   890: invokevirtual 1611	android/widget/TextView:setVisibility	(I)V
    //   893: aload_1
    //   894: getfield 2910	pdm:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   897: fconst_2
    //   898: aload_0
    //   899: getfield 247	rqj:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   902: invokevirtual 1568	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   905: invokestatic 610	aepi:a	(FLandroid/content/res/Resources;)I
    //   908: invokevirtual 2816	android/widget/TextView:setCompoundDrawablePadding	(I)V
    //   911: aload_0
    //   912: getfield 247	rqj:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   915: invokevirtual 1568	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   918: ldc_w 2842
    //   921: invokevirtual 2809	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   924: astore 4
    //   926: aload 4
    //   928: iconst_0
    //   929: iconst_0
    //   930: ldc_w 2843
    //   933: aload_0
    //   934: getfield 247	rqj:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   937: invokevirtual 1568	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   940: invokestatic 610	aepi:a	(FLandroid/content/res/Resources;)I
    //   943: ldc_w 2843
    //   946: aload_0
    //   947: getfield 247	rqj:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   950: invokevirtual 1568	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   953: invokestatic 610	aepi:a	(FLandroid/content/res/Resources;)I
    //   956: invokevirtual 2848	android/graphics/drawable/Drawable:setBounds	(IIII)V
    //   959: aload_1
    //   960: getfield 2910	pdm:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   963: aconst_null
    //   964: aconst_null
    //   965: aload 4
    //   967: aconst_null
    //   968: invokevirtual 2851	android/widget/TextView:setCompoundDrawables	(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V
    //   971: aload_0
    //   972: getfield 247	rqj:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   975: aload_1
    //   976: getfield 2910	pdm:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   979: aload 6
    //   981: aload 7
    //   983: aload 5
    //   985: new 2912	rri
    //   988: dup
    //   989: aload_0
    //   990: aload_2
    //   991: invokespecial 2913	rri:<init>	(Lrqj;Ljava/lang/String;)V
    //   994: invokestatic 2857	rdm:b	(Landroid/content/Context;Landroid/widget/TextView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/view/View$OnClickListener;)V
    //   997: aload_1
    //   998: getfield 2902	pdm:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   1001: ldc_w 2858
    //   1004: invokevirtual 2793	android/view/View:setBackgroundColor	(I)V
    //   1007: aload_0
    //   1008: iconst_1
    //   1009: putfield 2825	rqj:jdField_h_of_type_Boolean	Z
    //   1012: aconst_null
    //   1013: ldc_w 940
    //   1016: ldc_w 2860
    //   1019: ldc_w 2860
    //   1022: iconst_0
    //   1023: iconst_0
    //   1024: ldc_w 940
    //   1027: ldc_w 940
    //   1030: ldc_w 940
    //   1033: aload_2
    //   1034: iconst_0
    //   1035: invokestatic 1405	nrt:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   1038: return
    //   1039: aload_1
    //   1040: getfield 2910	pdm:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   1043: bipush 8
    //   1045: invokevirtual 1611	android/widget/TextView:setVisibility	(I)V
    //   1048: aload_1
    //   1049: getfield 2902	pdm:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   1052: iconst_0
    //   1053: invokevirtual 2793	android/view/View:setBackgroundColor	(I)V
    //   1056: invokestatic 344	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1059: ifeq -1055 -> 4
    //   1062: ldc_w 1091
    //   1065: iconst_2
    //   1066: ldc_w 2862
    //   1069: invokestatic 1096	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1072: return
    //   1073: aload_1
    //   1074: getfield 2910	pdm:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   1077: bipush 8
    //   1079: invokevirtual 1611	android/widget/TextView:setVisibility	(I)V
    //   1082: aload_1
    //   1083: getfield 2902	pdm:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   1086: iconst_0
    //   1087: invokevirtual 2793	android/view/View:setBackgroundColor	(I)V
    //   1090: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1091	0	this	rqj
    //   0	1091	1	parampdm	pdm
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
  
  public void a(pdn parampdn)
  {
    this.jdField_a_of_type_Rjg.b(2);
    this.jdField_a_of_type_Pdn = parampdn;
    this.jdField_a_of_type_Rjk = parampdn.a();
    this.jdField_a_of_type_Rjg.a(this.jdField_a_of_type_Rjk);
  }
  
  /* Error */
  public void a(pdo parampdo, BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aload_1
    //   6: getfield 2920	pdo:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   9: invokevirtual 2742	android/widget/TextView:getPaint	()Landroid/text/TextPaint;
    //   12: iconst_1
    //   13: invokevirtual 2747	android/text/TextPaint:setFakeBoldText	(Z)V
    //   16: aload_2
    //   17: getfield 2023	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mVideoColumnInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo;
    //   20: ifnull +390 -> 410
    //   23: aload_2
    //   24: getfield 2023	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mVideoColumnInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo;
    //   27: astore 5
    //   29: aload 5
    //   31: getfield 2921	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:jdField_d_of_type_Int	I
    //   34: iconst_1
    //   35: if_icmpne +690 -> 725
    //   38: aload_1
    //   39: getfield 2922	pdo:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   42: invokevirtual 1668	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   45: astore 4
    //   47: aload 4
    //   49: aload_0
    //   50: getfield 247	rqj:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   53: ldc_w 2923
    //   56: invokestatic 1224	bdaq:a	(Landroid/content/Context;F)I
    //   59: putfield 1685	android/view/ViewGroup$LayoutParams:height	I
    //   62: aload_1
    //   63: getfield 2922	pdo:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   66: aload 4
    //   68: invokevirtual 1698	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   71: aload 5
    //   73: getfield 2924	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   76: invokestatic 449	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   79: ifne +682 -> 761
    //   82: aload_0
    //   83: aload_1
    //   84: getfield 2922	pdo:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   87: new 1233	java/net/URL
    //   90: dup
    //   91: aload 5
    //   93: getfield 2924	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   96: invokespecial 1592	java/net/URL:<init>	(Ljava/lang/String;)V
    //   99: invokespecial 2926	rqj:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;Ljava/net/URL;)V
    //   102: aload 5
    //   104: getfield 2927	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   107: invokestatic 449	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   110: ifne +694 -> 804
    //   113: aload 5
    //   115: getfield 2927	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   118: invokestatic 2930	orc:a	(Ljava/lang/String;)Landroid/graphics/drawable/Drawable;
    //   121: astore 4
    //   123: aload_1
    //   124: getfield 2933	pdo:jdField_a_of_type_AndroidViewViewGroup	Landroid/view/ViewGroup;
    //   127: aload 4
    //   129: invokevirtual 2938	android/view/ViewGroup:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   132: aload_0
    //   133: aload_1
    //   134: getfield 2939	pdo:jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   137: new 1233	java/net/URL
    //   140: dup
    //   141: aload 5
    //   143: getfield 2940	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   146: invokespecial 1592	java/net/URL:<init>	(Ljava/lang/String;)V
    //   149: invokespecial 2926	rqj:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;Ljava/net/URL;)V
    //   152: aload_1
    //   153: getfield 2920	pdo:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   156: aload 5
    //   158: getfield 2727	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   161: invokevirtual 2720	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   164: new 854	java/lang/StringBuilder
    //   167: dup
    //   168: invokespecial 855	java/lang/StringBuilder:<init>	()V
    //   171: aload 5
    //   173: getfield 2941	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:jdField_a_of_type_Long	J
    //   176: iconst_1
    //   177: invokestatic 666	orr:a	(JZ)Ljava/lang/String;
    //   180: invokevirtual 859	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: ldc_w 2942
    //   186: invokestatic 1623	alud:a	(I)Ljava/lang/String;
    //   189: invokevirtual 859	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: invokevirtual 865	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: astore 4
    //   197: new 854	java/lang/StringBuilder
    //   200: dup
    //   201: invokespecial 855	java/lang/StringBuilder:<init>	()V
    //   204: aload 5
    //   206: getfield 2943	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:jdField_b_of_type_Int	I
    //   209: invokestatic 2945	bkbq:b	(I)Ljava/lang/String;
    //   212: invokevirtual 859	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: ldc_w 2946
    //   218: invokestatic 1623	alud:a	(I)Ljava/lang/String;
    //   221: invokevirtual 859	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: invokevirtual 865	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   227: astore 6
    //   229: new 854	java/lang/StringBuilder
    //   232: dup
    //   233: invokespecial 855	java/lang/StringBuilder:<init>	()V
    //   236: aload 5
    //   238: getfield 2947	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:jdField_c_of_type_Int	I
    //   241: invokevirtual 1242	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   244: ldc_w 2948
    //   247: invokestatic 1623	alud:a	(I)Ljava/lang/String;
    //   250: invokevirtual 859	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: invokevirtual 865	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   256: astore 7
    //   258: new 854	java/lang/StringBuilder
    //   261: dup
    //   262: invokespecial 855	java/lang/StringBuilder:<init>	()V
    //   265: aload 4
    //   267: invokevirtual 859	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: ldc_w 2950
    //   273: invokevirtual 859	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: aload 6
    //   278: invokevirtual 859	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: ldc_w 2950
    //   284: invokevirtual 859	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: aload 7
    //   289: invokevirtual 859	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: invokevirtual 865	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   295: astore 4
    //   297: aload_1
    //   298: getfield 2951	pdo:jdField_b_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   301: aload 4
    //   303: invokevirtual 2720	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   306: aload 5
    //   308: getfield 2952	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:jdField_a_of_type_Boolean	Z
    //   311: ifeq +558 -> 869
    //   314: aload_1
    //   315: getfield 2953	pdo:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   318: bipush 8
    //   320: invokevirtual 1611	android/widget/TextView:setVisibility	(I)V
    //   323: aload_1
    //   324: getfield 2954	pdo:i	Landroid/widget/TextView;
    //   327: aload 5
    //   329: getfield 2955	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   332: invokevirtual 2720	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   335: aload_1
    //   336: getfield 2958	pdo:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KanDianUrlRoundCornerImageView;
    //   339: aload_0
    //   340: invokevirtual 1300	rqj:a	()Landroid/app/Activity;
    //   343: fconst_2
    //   344: invokestatic 1224	bdaq:a	(Landroid/content/Context;F)I
    //   347: invokevirtual 2963	com/tencent/biz/pubaccount/readinjoy/view/KanDianUrlRoundCornerImageView:setCorner	(I)V
    //   350: aload_0
    //   351: aload_1
    //   352: getfield 2958	pdo:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KanDianUrlRoundCornerImageView;
    //   355: new 1233	java/net/URL
    //   358: dup
    //   359: aload 5
    //   361: getfield 2964	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:h	Ljava/lang/String;
    //   364: invokespecial 1592	java/net/URL:<init>	(Ljava/lang/String;)V
    //   367: invokespecial 2926	rqj:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;Ljava/net/URL;)V
    //   370: aload_1
    //   371: getfield 2967	pdo:jdField_a_of_type_AndroidWidgetRelativeLayout	Landroid/widget/RelativeLayout;
    //   374: aload_1
    //   375: invokevirtual 2970	android/widget/RelativeLayout:setTag	(Ljava/lang/Object;)V
    //   378: aload_1
    //   379: getfield 2953	pdo:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   382: aload_1
    //   383: invokevirtual 1831	android/widget/TextView:setTag	(Ljava/lang/Object;)V
    //   386: aload_1
    //   387: getfield 2972	pdo:jdField_b_of_type_AndroidViewViewGroup	Landroid/view/ViewGroup;
    //   390: aload_1
    //   391: invokevirtual 2973	android/view/ViewGroup:setTag	(Ljava/lang/Object;)V
    //   394: aload_1
    //   395: getfield 2958	pdo:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KanDianUrlRoundCornerImageView;
    //   398: aload_1
    //   399: invokevirtual 2974	com/tencent/biz/pubaccount/readinjoy/view/KanDianUrlRoundCornerImageView:setTag	(Ljava/lang/Object;)V
    //   402: aload_1
    //   403: getfield 2954	pdo:i	Landroid/widget/TextView;
    //   406: aload_1
    //   407: invokevirtual 1831	android/widget/TextView:setTag	(Ljava/lang/Object;)V
    //   410: aload_1
    //   411: getfield 2975	pdo:jdField_b_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   414: aload_1
    //   415: invokevirtual 1832	android/widget/ImageView:setTag	(Ljava/lang/Object;)V
    //   418: aload_1
    //   419: getfield 2975	pdo:jdField_b_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   422: aload_0
    //   423: invokevirtual 1821	android/widget/ImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   426: aload_2
    //   427: invokestatic 1835	rqj:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lrjk;
    //   430: astore 4
    //   432: aload 4
    //   434: aload_1
    //   435: getfield 2976	pdo:jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   438: putfield 1841	rjk:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   441: aload 4
    //   443: aload_1
    //   444: getfield 2977	pdo:jdField_a_of_type_Int	I
    //   447: putfield 583	rjk:jdField_a_of_type_Int	I
    //   450: aload 4
    //   452: aload_2
    //   453: putfield 1208	rjk:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   456: aload_1
    //   457: aload 4
    //   459: putfield 2978	pdo:jdField_a_of_type_Rjk	Lrjk;
    //   462: aload_1
    //   463: getfield 2979	pdo:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   466: aload_2
    //   467: getfield 891	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mTitle	Ljava/lang/String;
    //   470: invokevirtual 2720	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   473: aload_1
    //   474: getfield 2979	pdo:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   477: invokevirtual 2742	android/widget/TextView:getPaint	()Landroid/text/TextPaint;
    //   480: iconst_1
    //   481: invokevirtual 2747	android/text/TextPaint:setFakeBoldText	(Z)V
    //   484: aload_1
    //   485: getfield 2979	pdo:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   488: aload_0
    //   489: getfield 247	rqj:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   492: invokevirtual 1568	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   495: ldc_w 2748
    //   498: invokevirtual 2753	android/content/res/Resources:getColor	(I)I
    //   501: invokevirtual 2733	android/widget/TextView:setTextColor	(I)V
    //   504: aload_2
    //   505: getfield 938	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mVideoPlayCount	I
    //   508: ifne +372 -> 880
    //   511: aload_1
    //   512: getfield 2980	pdo:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   515: bipush 8
    //   517: invokevirtual 1611	android/widget/TextView:setVisibility	(I)V
    //   520: aload_1
    //   521: getfield 2981	pdo:jdField_f_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   524: aload 4
    //   526: getfield 669	rjk:jdField_b_of_type_Int	I
    //   529: invokestatic 2758	orc:a	(I)Ljava/lang/String;
    //   532: invokevirtual 2720	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   535: aload_0
    //   536: getfield 247	rqj:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   539: aload_1
    //   540: getfield 2976	pdo:jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   543: aload_1
    //   544: getfield 2978	pdo:jdField_a_of_type_Rjk	Lrjk;
    //   547: invokestatic 2768	pdj:a	(Landroid/content/Context;Landroid/widget/ImageView;Lrjk;)V
    //   550: aload_0
    //   551: aload_1
    //   552: getfield 2976	pdo:jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   555: aload_2
    //   556: iconst_0
    //   557: invokevirtual 1141	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:getVideoCoverUrlWithSmartCut	(Z)Ljava/net/URL;
    //   560: iconst_0
    //   561: invokespecial 1666	rqj:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;Ljava/net/URL;Z)V
    //   564: aload_1
    //   565: getfield 2976	pdo:jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   568: aload_0
    //   569: invokevirtual 2772	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setOnLongClickListener	(Landroid/view/View$OnLongClickListener;)V
    //   572: aload_1
    //   573: getfield 2976	pdo:jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   576: aload_1
    //   577: invokevirtual 2982	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setTag	(Ljava/lang/Object;)V
    //   580: aload_1
    //   581: getfield 2981	pdo:jdField_f_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   584: iconst_0
    //   585: invokevirtual 1611	android/widget/TextView:setVisibility	(I)V
    //   588: aload_1
    //   589: getfield 2981	pdo:jdField_f_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   592: invokevirtual 2897	android/widget/TextView:clearAnimation	()V
    //   595: aload_1
    //   596: getfield 2983	pdo:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup	Lcom/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup;
    //   599: fconst_1
    //   600: aload 4
    //   602: getfield 839	rjk:jdField_c_of_type_Int	I
    //   605: aload 4
    //   607: getfield 842	rjk:jdField_d_of_type_Int	I
    //   610: invokestatic 2778	orc:a	(II)F
    //   613: invokevirtual 2784	com/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup:setCustomSize	(FF)V
    //   616: aload_1
    //   617: getfield 2983	pdo:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup	Lcom/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup;
    //   620: aload_1
    //   621: invokevirtual 2785	com/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup:setTag	(Ljava/lang/Object;)V
    //   624: aload_0
    //   625: aload_0
    //   626: getfield 142	rqj:jdField_c_of_type_Int	I
    //   629: aload_2
    //   630: getfield 1125	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mArticleID	J
    //   633: invokevirtual 2787	rqj:b	(IJ)Z
    //   636: ifeq +23 -> 659
    //   639: aload_1
    //   640: getfield 2984	pdo:jdField_f_of_type_AndroidViewView	Landroid/view/View;
    //   643: aload_0
    //   644: getfield 247	rqj:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   647: invokevirtual 1568	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   650: ldc_w 2790
    //   653: invokevirtual 2753	android/content/res/Resources:getColor	(I)I
    //   656: invokevirtual 2793	android/view/View:setBackgroundColor	(I)V
    //   659: aload_2
    //   660: getfield 697	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mXGFileSize	J
    //   663: lconst_0
    //   664: lcmp
    //   665: ifgt +262 -> 927
    //   668: aload_1
    //   669: getfield 2985	pdo:g	Landroid/widget/TextView;
    //   672: ldc_w 2986
    //   675: invokestatic 1623	alud:a	(I)Ljava/lang/String;
    //   678: invokevirtual 2720	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   681: aload_0
    //   682: getfield 247	rqj:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   685: invokestatic 1254	bdin:h	(Landroid/content/Context;)Z
    //   688: ifeq +278 -> 966
    //   691: aload_1
    //   692: getfield 2987	pdo:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   695: iconst_0
    //   696: invokevirtual 1636	android/widget/ImageView:setVisibility	(I)V
    //   699: aload_1
    //   700: getfield 2985	pdo:g	Landroid/widget/TextView;
    //   703: bipush 8
    //   705: invokevirtual 1611	android/widget/TextView:setVisibility	(I)V
    //   708: aload_1
    //   709: getfield 2988	pdo:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   712: iconst_0
    //   713: invokevirtual 1581	android/view/View:setVisibility	(I)V
    //   716: aload_1
    //   717: getfield 2989	pdo:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   720: iconst_0
    //   721: invokevirtual 2793	android/view/View:setBackgroundColor	(I)V
    //   724: return
    //   725: aload_1
    //   726: getfield 2922	pdo:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   729: invokevirtual 1668	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   732: astore 4
    //   734: aload 4
    //   736: aload_0
    //   737: getfield 247	rqj:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   740: ldc_w 2990
    //   743: invokestatic 1224	bdaq:a	(Landroid/content/Context;F)I
    //   746: putfield 1685	android/view/ViewGroup$LayoutParams:height	I
    //   749: aload_1
    //   750: getfield 2922	pdo:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   753: aload 4
    //   755: invokevirtual 1698	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   758: goto -687 -> 71
    //   761: aload_1
    //   762: getfield 2922	pdo:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   765: new 623	android/graphics/drawable/ColorDrawable
    //   768: dup
    //   769: ldc_w 2991
    //   772: invokespecial 626	android/graphics/drawable/ColorDrawable:<init>	(I)V
    //   775: invokevirtual 2992	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   778: goto -676 -> 102
    //   781: astore 4
    //   783: invokestatic 344	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   786: ifeq -684 -> 102
    //   789: ldc_w 346
    //   792: iconst_2
    //   793: ldc_w 2994
    //   796: aload 4
    //   798: invokestatic 2997	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   801: goto -699 -> 102
    //   804: new 623	android/graphics/drawable/ColorDrawable
    //   807: dup
    //   808: ldc_w 2991
    //   811: invokespecial 626	android/graphics/drawable/ColorDrawable:<init>	(I)V
    //   814: astore 4
    //   816: goto -693 -> 123
    //   819: astore 4
    //   821: invokestatic 344	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   824: ifeq +15 -> 839
    //   827: ldc_w 346
    //   830: iconst_2
    //   831: ldc_w 2999
    //   834: aload 4
    //   836: invokestatic 2997	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   839: aload_1
    //   840: getfield 2933	pdo:jdField_a_of_type_AndroidViewViewGroup	Landroid/view/ViewGroup;
    //   843: new 623	android/graphics/drawable/ColorDrawable
    //   846: dup
    //   847: ldc_w 2991
    //   850: invokespecial 626	android/graphics/drawable/ColorDrawable:<init>	(I)V
    //   853: invokevirtual 2938	android/view/ViewGroup:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   856: goto -724 -> 132
    //   859: astore 4
    //   861: aload 4
    //   863: invokevirtual 3000	java/net/MalformedURLException:printStackTrace	()V
    //   866: goto -714 -> 152
    //   869: aload_1
    //   870: getfield 2953	pdo:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   873: iconst_0
    //   874: invokevirtual 1611	android/widget/TextView:setVisibility	(I)V
    //   877: goto -554 -> 323
    //   880: aload_1
    //   881: getfield 2980	pdo:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   884: iconst_0
    //   885: invokevirtual 1611	android/widget/TextView:setVisibility	(I)V
    //   888: aload_1
    //   889: getfield 2980	pdo:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   892: new 854	java/lang/StringBuilder
    //   895: dup
    //   896: invokespecial 855	java/lang/StringBuilder:<init>	()V
    //   899: aload_2
    //   900: getfield 938	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mVideoPlayCount	I
    //   903: invokestatic 3002	rdm:c	(I)Ljava/lang/String;
    //   906: invokevirtual 859	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   909: ldc_w 3003
    //   912: invokestatic 1623	alud:a	(I)Ljava/lang/String;
    //   915: invokevirtual 859	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   918: invokevirtual 865	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   921: invokevirtual 2720	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   924: goto -404 -> 520
    //   927: aload_1
    //   928: getfield 2985	pdo:g	Landroid/widget/TextView;
    //   931: new 854	java/lang/StringBuilder
    //   934: dup
    //   935: invokespecial 855	java/lang/StringBuilder:<init>	()V
    //   938: aload_2
    //   939: getfield 697	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mXGFileSize	J
    //   942: invokestatic 2804	rdm:b	(J)Ljava/lang/String;
    //   945: invokevirtual 859	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   948: ldc_w 3004
    //   951: invokestatic 1623	alud:a	(I)Ljava/lang/String;
    //   954: invokevirtual 859	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   957: invokevirtual 865	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   960: invokevirtual 2720	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   963: goto -282 -> 681
    //   966: aload_1
    //   967: getfield 2987	pdo:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   970: bipush 8
    //   972: invokevirtual 1636	android/widget/ImageView:setVisibility	(I)V
    //   975: aload_0
    //   976: getfield 247	rqj:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   979: invokevirtual 1568	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   982: ldc_w 2806
    //   985: invokevirtual 2809	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   988: astore 4
    //   990: aload_1
    //   991: getfield 2985	pdo:g	Landroid/widget/TextView;
    //   994: aload 4
    //   996: aconst_null
    //   997: aconst_null
    //   998: aconst_null
    //   999: invokevirtual 2813	android/widget/TextView:setCompoundDrawablesWithIntrinsicBounds	(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V
    //   1002: aload_1
    //   1003: getfield 2985	pdo:g	Landroid/widget/TextView;
    //   1006: ldc_w 2130
    //   1009: aload_0
    //   1010: getfield 247	rqj:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   1013: invokevirtual 1568	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   1016: invokestatic 610	aepi:a	(FLandroid/content/res/Resources;)I
    //   1019: invokevirtual 2816	android/widget/TextView:setCompoundDrawablePadding	(I)V
    //   1022: aload_1
    //   1023: getfield 2985	pdo:g	Landroid/widget/TextView;
    //   1026: iconst_0
    //   1027: invokevirtual 1611	android/widget/TextView:setVisibility	(I)V
    //   1030: invokestatic 2819	beaa:a	()I
    //   1033: iconst_1
    //   1034: if_icmpne +42 -> 1076
    //   1037: aload_1
    //   1038: getfield 2985	pdo:g	Landroid/widget/TextView;
    //   1041: ldc_w 3005
    //   1044: invokestatic 1623	alud:a	(I)Ljava/lang/String;
    //   1047: invokevirtual 2720	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   1050: aload_1
    //   1051: getfield 3006	pdo:h	Landroid/widget/TextView;
    //   1054: bipush 8
    //   1056: invokevirtual 1611	android/widget/TextView:setVisibility	(I)V
    //   1059: aload_1
    //   1060: getfield 2988	pdo:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   1063: iconst_0
    //   1064: invokevirtual 1581	android/view/View:setVisibility	(I)V
    //   1067: aload_1
    //   1068: getfield 2989	pdo:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   1071: iconst_0
    //   1072: invokevirtual 2793	android/view/View:setBackgroundColor	(I)V
    //   1075: return
    //   1076: invokestatic 2824	bkbq:v	()Z
    //   1079: ifeq +296 -> 1375
    //   1082: aload_0
    //   1083: getfield 2825	rqj:jdField_h_of_type_Boolean	Z
    //   1086: ifne +289 -> 1375
    //   1089: aload_1
    //   1090: getfield 2977	pdo:jdField_a_of_type_Int	I
    //   1093: ifne +282 -> 1375
    //   1096: invokestatic 2827	bkbq:d	()Ljava/lang/String;
    //   1099: astore 5
    //   1101: invokestatic 2829	bkbq:e	()Ljava/lang/String;
    //   1104: astore 6
    //   1106: invokestatic 2831	bkbq:f	()Ljava/lang/String;
    //   1109: astore 7
    //   1111: aload 5
    //   1113: invokestatic 449	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1116: ifne +217 -> 1333
    //   1119: invokestatic 2833	ors:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1122: astore 8
    //   1124: ldc_w 940
    //   1127: astore 4
    //   1129: aload 8
    //   1131: ifnull +10 -> 1141
    //   1134: aload 8
    //   1136: invokevirtual 2836	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1139: astore 4
    //   1141: new 1366	ron
    //   1144: dup
    //   1145: aconst_null
    //   1146: aconst_null
    //   1147: aconst_null
    //   1148: aconst_null
    //   1149: invokespecial 1369	ron:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1152: aload 4
    //   1154: invokevirtual 2839	ron:l	(Ljava/lang/String;)Lron;
    //   1157: aload_2
    //   1158: getfield 798	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:innerUniqueID	Ljava/lang/String;
    //   1161: invokevirtual 2841	ron:h	(Ljava/lang/String;)Lron;
    //   1164: invokevirtual 1392	ron:a	()Lrom;
    //   1167: invokevirtual 1396	rom:a	()Ljava/lang/String;
    //   1170: astore_2
    //   1171: aload_1
    //   1172: getfield 3006	pdo:h	Landroid/widget/TextView;
    //   1175: iconst_0
    //   1176: invokevirtual 1611	android/widget/TextView:setVisibility	(I)V
    //   1179: aload_1
    //   1180: getfield 3006	pdo:h	Landroid/widget/TextView;
    //   1183: fconst_2
    //   1184: aload_0
    //   1185: getfield 247	rqj:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   1188: invokevirtual 1568	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   1191: invokestatic 610	aepi:a	(FLandroid/content/res/Resources;)I
    //   1194: invokevirtual 2816	android/widget/TextView:setCompoundDrawablePadding	(I)V
    //   1197: aload_0
    //   1198: getfield 247	rqj:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   1201: invokevirtual 1568	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   1204: ldc_w 2842
    //   1207: invokevirtual 2809	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   1210: astore 4
    //   1212: aload 4
    //   1214: iconst_0
    //   1215: iconst_0
    //   1216: ldc_w 2843
    //   1219: aload_0
    //   1220: getfield 247	rqj:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   1223: invokevirtual 1568	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   1226: invokestatic 610	aepi:a	(FLandroid/content/res/Resources;)I
    //   1229: ldc_w 2843
    //   1232: aload_0
    //   1233: getfield 247	rqj:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   1236: invokevirtual 1568	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   1239: invokestatic 610	aepi:a	(FLandroid/content/res/Resources;)I
    //   1242: invokevirtual 2848	android/graphics/drawable/Drawable:setBounds	(IIII)V
    //   1245: aload_1
    //   1246: getfield 3006	pdo:h	Landroid/widget/TextView;
    //   1249: aconst_null
    //   1250: aconst_null
    //   1251: aload 4
    //   1253: aconst_null
    //   1254: invokevirtual 2851	android/widget/TextView:setCompoundDrawables	(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V
    //   1257: aload_0
    //   1258: getfield 247	rqj:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   1261: aload_1
    //   1262: getfield 3006	pdo:h	Landroid/widget/TextView;
    //   1265: aload 6
    //   1267: aload 7
    //   1269: aload 5
    //   1271: new 3008	rrk
    //   1274: dup
    //   1275: aload_0
    //   1276: aload_2
    //   1277: invokespecial 3009	rrk:<init>	(Lrqj;Ljava/lang/String;)V
    //   1280: invokestatic 2857	rdm:b	(Landroid/content/Context;Landroid/widget/TextView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/view/View$OnClickListener;)V
    //   1283: aload_1
    //   1284: getfield 2989	pdo:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   1287: ldc_w 2858
    //   1290: invokevirtual 2793	android/view/View:setBackgroundColor	(I)V
    //   1293: aload_1
    //   1294: getfield 2988	pdo:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   1297: iconst_0
    //   1298: invokevirtual 1581	android/view/View:setVisibility	(I)V
    //   1301: aload_0
    //   1302: iconst_1
    //   1303: putfield 2825	rqj:jdField_h_of_type_Boolean	Z
    //   1306: aconst_null
    //   1307: ldc_w 940
    //   1310: ldc_w 2860
    //   1313: ldc_w 2860
    //   1316: iconst_0
    //   1317: iconst_0
    //   1318: ldc_w 940
    //   1321: ldc_w 940
    //   1324: ldc_w 940
    //   1327: aload_2
    //   1328: iconst_0
    //   1329: invokestatic 1405	nrt:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   1332: return
    //   1333: aload_1
    //   1334: getfield 3006	pdo:h	Landroid/widget/TextView;
    //   1337: bipush 8
    //   1339: invokevirtual 1611	android/widget/TextView:setVisibility	(I)V
    //   1342: aload_1
    //   1343: getfield 2988	pdo:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   1346: iconst_0
    //   1347: invokevirtual 1581	android/view/View:setVisibility	(I)V
    //   1350: aload_1
    //   1351: getfield 2989	pdo:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   1354: iconst_0
    //   1355: invokevirtual 2793	android/view/View:setBackgroundColor	(I)V
    //   1358: invokestatic 344	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1361: ifeq -1357 -> 4
    //   1364: ldc_w 1091
    //   1367: iconst_2
    //   1368: ldc_w 2862
    //   1371: invokestatic 1096	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1374: return
    //   1375: aload_1
    //   1376: getfield 3006	pdo:h	Landroid/widget/TextView;
    //   1379: bipush 8
    //   1381: invokevirtual 1611	android/widget/TextView:setVisibility	(I)V
    //   1384: aload_1
    //   1385: getfield 2988	pdo:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   1388: iconst_0
    //   1389: invokevirtual 1581	android/view/View:setVisibility	(I)V
    //   1392: aload_1
    //   1393: getfield 2989	pdo:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   1396: iconst_0
    //   1397: invokevirtual 2793	android/view/View:setBackgroundColor	(I)V
    //   1400: return
    //   1401: astore 4
    //   1403: goto -1033 -> 370
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1406	0	this	rqj
    //   0	1406	1	parampdo	pdo
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
  
  public void a(pdp parampdp, BaseArticleInfo paramBaseArticleInfo)
  {
    long l2 = 0L;
    parampdp.jdField_f_of_type_AndroidViewView.setOnClickListener(null);
    parampdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = paramBaseArticleInfo;
    parampdp.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = ((BaseArticleInfo)paramBaseArticleInfo.mSubArtilceList.get(0));
    parampdp.jdField_a_of_type_AndroidViewView.setBackgroundColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131167194));
    a(parampdp.jdField_a_of_type_AndroidViewViewGroup, parampdp.jdField_b_of_type_AndroidViewViewGroup);
    paramBaseArticleInfo = parampdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
    a(paramBaseArticleInfo, parampdp.jdField_c_of_type_AndroidWidgetTextView, parampdp.jdField_b_of_type_AndroidViewView, parampdp.jdField_a_of_type_AndroidWidgetTextView, parampdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView);
    a(parampdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetRoundAngleFrameLayout);
    parampdp.jdField_c_of_type_AndroidWidgetTextView.setText(paramBaseArticleInfo.mTitle);
    parampdp.jdField_c_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
    parampdp.jdField_d_of_type_AndroidWidgetTextView.setText(rdm.c(paramBaseArticleInfo.mVideoPlayCount));
    a(parampdp.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, parampdp.jdField_a_of_type_AndroidWidgetImageView, paramBaseArticleInfo, false);
    parampdp.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setTag(parampdp);
    parampdp.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setOnClickListener(this);
    parampdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setTag(paramBaseArticleInfo);
    rdm.a(paramBaseArticleInfo.mVideoArticleSubsText, paramBaseArticleInfo.mVideoArticleSubsColor, parampdp.jdField_e_of_type_AndroidWidgetTextView);
    if ((paramBaseArticleInfo.isAccountShown) && (this.jdField_c_of_type_Int == 0) && (paramBaseArticleInfo.mPartnerAccountInfo != null))
    {
      parampdp.jdField_d_of_type_AndroidViewView.setVisibility(0);
      parampdp.jdField_d_of_type_AndroidViewView.setTag(paramBaseArticleInfo);
      if (!paramBaseArticleInfo.mPartnerAccountInfo.uint64_uin.has()) {
        break label664;
      }
    }
    label664:
    for (long l1 = paramBaseArticleInfo.mPartnerAccountInfo.uint64_uin.get();; l1 = 0L)
    {
      parampdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setHeadImgByUin(l1);
      parampdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setTag(paramBaseArticleInfo);
      ors.a(parampdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView, 10, 10, 10, 10);
      paramBaseArticleInfo = ors.a(paramBaseArticleInfo.mPartnerAccountInfo.bytes_v_icon_url);
      if (!TextUtils.isEmpty(paramBaseArticleInfo)) {}
      try
      {
        paramBaseArticleInfo = new URL(paramBaseArticleInfo);
        parampdp.jdField_d_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.a(paramBaseArticleInfo);
        label316:
        parampdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setNickNameByUin(l1);
        parampdp.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
        parampdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setOnClickListener(this);
        for (;;)
        {
          paramBaseArticleInfo = parampdp.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
          paramBaseArticleInfo.isTwoItem = true;
          a(paramBaseArticleInfo, parampdp.jdField_f_of_type_AndroidWidgetTextView, parampdp.jdField_c_of_type_AndroidViewView, parampdp.jdField_b_of_type_AndroidWidgetTextView, parampdp.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView);
          a(parampdp.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetRoundAngleFrameLayout);
          parampdp.jdField_f_of_type_AndroidWidgetTextView.setText(paramBaseArticleInfo.mTitle);
          parampdp.jdField_f_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
          parampdp.g.setText(rdm.c(paramBaseArticleInfo.mVideoPlayCount));
          a(parampdp.jdField_e_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, parampdp.jdField_b_of_type_AndroidWidgetImageView, paramBaseArticleInfo, false);
          parampdp.jdField_e_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setTag(parampdp);
          parampdp.jdField_e_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setOnClickListener(this);
          parampdp.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setTag(paramBaseArticleInfo);
          rdm.a(paramBaseArticleInfo.mVideoArticleSubsText, paramBaseArticleInfo.mVideoArticleSubsColor, parampdp.h);
          if ((paramBaseArticleInfo.isAccountShown) && (this.jdField_c_of_type_Int == 0) && (paramBaseArticleInfo.mPartnerAccountInfo != null))
          {
            parampdp.jdField_e_of_type_AndroidViewView.setVisibility(0);
            parampdp.jdField_e_of_type_AndroidViewView.setTag(paramBaseArticleInfo);
            l1 = l2;
            if (paramBaseArticleInfo.mPartnerAccountInfo != null)
            {
              l1 = l2;
              if (paramBaseArticleInfo.mPartnerAccountInfo.uint64_uin.has()) {
                l1 = paramBaseArticleInfo.mPartnerAccountInfo.uint64_uin.get();
              }
            }
            parampdp.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setHeadImgByUin(l1);
            parampdp.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setTag(paramBaseArticleInfo);
            ors.a(parampdp.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView, 10, 10, 10, 10);
            paramBaseArticleInfo = ors.a(paramBaseArticleInfo.mPartnerAccountInfo.bytes_v_icon_url);
            if (TextUtils.isEmpty(paramBaseArticleInfo)) {}
          }
          try
          {
            paramBaseArticleInfo = new URL(paramBaseArticleInfo);
            parampdp.jdField_f_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.a(paramBaseArticleInfo);
            label609:
            parampdp.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setNickNameByUin(l1);
            parampdp.jdField_e_of_type_AndroidViewView.setOnClickListener(this);
            parampdp.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setOnClickListener(this);
            return;
            parampdp.jdField_d_of_type_AndroidViewView.setVisibility(8);
            continue;
            parampdp.jdField_e_of_type_AndroidViewView.setVisibility(8);
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
  public void a(pdq parampdq, BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aload_1
    //   6: aload_2
    //   7: invokestatic 3112	rqj:a	(Lpdq;Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)V
    //   10: aload_1
    //   11: getfield 1843	pdq:jdField_a_of_type_Rjk	Lrjk;
    //   14: astore 4
    //   16: aload_1
    //   17: getfield 3113	pdq:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   20: aload_2
    //   21: getfield 891	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mTitle	Ljava/lang/String;
    //   24: invokevirtual 2720	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   27: aload_1
    //   28: getfield 3113	pdq:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   31: invokevirtual 2742	android/widget/TextView:getPaint	()Landroid/text/TextPaint;
    //   34: iconst_1
    //   35: invokevirtual 2747	android/text/TextPaint:setFakeBoldText	(Z)V
    //   38: aload_1
    //   39: getfield 3113	pdq:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   42: aload_0
    //   43: getfield 247	rqj:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   46: invokevirtual 1568	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   49: ldc_w 2748
    //   52: invokevirtual 2753	android/content/res/Resources:getColor	(I)I
    //   55: invokevirtual 2733	android/widget/TextView:setTextColor	(I)V
    //   58: aload_2
    //   59: getfield 938	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mVideoPlayCount	I
    //   62: ifne +744 -> 806
    //   65: aload_1
    //   66: getfield 3114	pdq:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   69: bipush 8
    //   71: invokevirtual 1611	android/widget/TextView:setVisibility	(I)V
    //   74: aload_1
    //   75: getfield 3115	pdq:jdField_b_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   78: aload 4
    //   80: getfield 669	rjk:jdField_b_of_type_Int	I
    //   83: invokestatic 2758	orc:a	(I)Ljava/lang/String;
    //   86: invokevirtual 2720	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   89: aload_0
    //   90: aload_1
    //   91: getfield 3116	pdq:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyNickNameTextView;
    //   94: aload_2
    //   95: aload_2
    //   96: invokestatic 518	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:isAdvertisementInfo	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Z
    //   99: invokespecial 3118	rqj:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyNickNameTextView;Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;Z)V
    //   102: aload_0
    //   103: aload_1
    //   104: getfield 3119	pdq:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyHeadImageView;
    //   107: aload_2
    //   108: invokespecial 3121	rqj:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyHeadImageView;Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)V
    //   111: aload_1
    //   112: getfield 3119	pdq:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyHeadImageView;
    //   115: aload_2
    //   116: invokevirtual 1784	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:getSubscribeName	()Ljava/lang/String;
    //   119: invokevirtual 3124	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyHeadImageView:setContentDescription	(Ljava/lang/CharSequence;)V
    //   122: aload_1
    //   123: getfield 3116	pdq:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyNickNameTextView;
    //   126: iconst_0
    //   127: invokevirtual 3125	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyNickNameTextView:setVisibility	(I)V
    //   130: aload_1
    //   131: getfield 3116	pdq:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyNickNameTextView;
    //   134: aload_2
    //   135: invokevirtual 1784	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:getSubscribeName	()Ljava/lang/String;
    //   138: invokevirtual 3126	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyNickNameTextView:setContentDescription	(Ljava/lang/CharSequence;)V
    //   141: aload_1
    //   142: getfield 3127	pdq:jdField_a_of_type_AndroidViewViewGroup	Landroid/view/ViewGroup;
    //   145: aload_2
    //   146: invokevirtual 2973	android/view/ViewGroup:setTag	(Ljava/lang/Object;)V
    //   149: aload_1
    //   150: getfield 3127	pdq:jdField_a_of_type_AndroidViewViewGroup	Landroid/view/ViewGroup;
    //   153: aload_0
    //   154: invokevirtual 3128	android/view/ViewGroup:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   157: aload_2
    //   158: getfield 2880	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:vIconUrl	Ljava/lang/String;
    //   161: invokestatic 449	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   164: ifne +699 -> 863
    //   167: new 1233	java/net/URL
    //   170: dup
    //   171: aload_2
    //   172: getfield 2880	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:vIconUrl	Ljava/lang/String;
    //   175: invokespecial 1592	java/net/URL:<init>	(Ljava/lang/String;)V
    //   178: astore 5
    //   180: aload_1
    //   181: getfield 3129	pdq:jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   184: aload 5
    //   186: invokevirtual 2726	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:a	(Ljava/net/URL;)Lcom/tencent/biz/pubaccount/readinjoy/view/imageloader/ZImageView;
    //   189: pop
    //   190: aload_1
    //   191: getfield 3129	pdq:jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   194: iconst_0
    //   195: invokevirtual 1610	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setVisibility	(I)V
    //   198: aload_2
    //   199: invokestatic 518	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:isAdvertisementInfo	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Z
    //   202: ifeq +827 -> 1029
    //   205: aload_2
    //   206: checkcast 515	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo
    //   209: astore 5
    //   211: aload_1
    //   212: getfield 1827	pdq:h	Landroid/widget/TextView;
    //   215: iconst_0
    //   216: invokevirtual 1611	android/widget/TextView:setVisibility	(I)V
    //   219: invokestatic 1214	ors:s	()Z
    //   222: ifeq +653 -> 875
    //   225: aload_1
    //   226: getfield 1827	pdq:h	Landroid/widget/TextView;
    //   229: aconst_null
    //   230: invokestatic 3134	opi:a	(Landroid/view/View;Landroid/graphics/drawable/Drawable;)V
    //   233: aload_1
    //   234: getfield 1827	pdq:h	Landroid/widget/TextView;
    //   237: ldc_w 3136
    //   240: invokestatic 131	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   243: invokevirtual 2733	android/widget/TextView:setTextColor	(I)V
    //   246: aload_1
    //   247: getfield 1824	pdq:i	Landroid/widget/TextView;
    //   250: ldc_w 3138
    //   253: invokestatic 131	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   256: invokevirtual 2733	android/widget/TextView:setTextColor	(I)V
    //   259: aload_2
    //   260: getfield 2866	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mArticleSubscriptText	Ljava/lang/String;
    //   263: invokestatic 449	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   266: ifne +632 -> 898
    //   269: aload_1
    //   270: getfield 1827	pdq:h	Landroid/widget/TextView;
    //   273: aload_2
    //   274: getfield 2866	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mArticleSubscriptText	Ljava/lang/String;
    //   277: invokevirtual 2720	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   280: aload_1
    //   281: getfield 3141	pdq:jdField_b_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   284: iconst_0
    //   285: invokevirtual 3144	android/widget/LinearLayout:setVisibility	(I)V
    //   288: aload_2
    //   289: invokestatic 1737	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:isAppAdvertisementInfo	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Z
    //   292: ifeq +668 -> 960
    //   295: iconst_0
    //   296: istore_3
    //   297: new 1009	org/json/JSONObject
    //   300: dup
    //   301: aload 5
    //   303: getfield 1740	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdExt	Ljava/lang/String;
    //   306: invokespecial 1012	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   309: astore 6
    //   311: aload_0
    //   312: getfield 247	rqj:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   315: aload 6
    //   317: ldc_w 3146
    //   320: invokevirtual 3149	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   323: invokestatic 3154	bdiv:a	(Landroid/content/Context;Ljava/lang/String;)Z
    //   326: ifeq +592 -> 918
    //   329: aload_1
    //   330: getfield 1824	pdq:i	Landroid/widget/TextView;
    //   333: aload_0
    //   334: getfield 247	rqj:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   337: ldc_w 3155
    //   340: invokevirtual 2469	android/app/Activity:getString	(I)Ljava/lang/String;
    //   343: invokevirtual 2720	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   346: iconst_1
    //   347: istore_3
    //   348: aload 5
    //   350: getfield 3158	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdBtnTxt	Ljava/lang/String;
    //   353: invokestatic 449	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   356: ifne +19 -> 375
    //   359: iload_3
    //   360: ifne +15 -> 375
    //   363: aload_1
    //   364: getfield 1824	pdq:i	Landroid/widget/TextView;
    //   367: aload 5
    //   369: getfield 3158	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdBtnTxt	Ljava/lang/String;
    //   372: invokevirtual 2720	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   375: new 1009	org/json/JSONObject
    //   378: dup
    //   379: aload 5
    //   381: getfield 3161	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdExtInfo	Ljava/lang/String;
    //   384: invokespecial 1012	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   387: astore 5
    //   389: aload 5
    //   391: ldc_w 3163
    //   394: invokevirtual 3149	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   397: invokestatic 449	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   400: ifne +18 -> 418
    //   403: aload_1
    //   404: getfield 1827	pdq:h	Landroid/widget/TextView;
    //   407: aload 5
    //   409: ldc_w 3163
    //   412: invokevirtual 3149	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   415: invokevirtual 2720	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   418: aload_0
    //   419: aload_1
    //   420: invokespecial 3165	rqj:a	(Lpdq;)V
    //   423: aload_1
    //   424: getfield 3168	pdq:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyVideoInfoViewGroup	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyVideoInfoViewGroup;
    //   427: bipush 8
    //   429: invokevirtual 3171	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyVideoInfoViewGroup:setVisibility	(I)V
    //   432: aload_1
    //   433: getfield 3173	pdq:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   436: bipush 8
    //   438: invokevirtual 3144	android/widget/LinearLayout:setVisibility	(I)V
    //   441: aload_0
    //   442: getfield 247	rqj:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   445: aload_1
    //   446: getfield 1838	pdq:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   449: aload_1
    //   450: getfield 1843	pdq:jdField_a_of_type_Rjk	Lrjk;
    //   453: invokestatic 2768	pdj:a	(Landroid/content/Context;Landroid/widget/ImageView;Lrjk;)V
    //   456: aload_0
    //   457: aload_1
    //   458: getfield 1838	pdq:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   461: aload_2
    //   462: iconst_0
    //   463: invokevirtual 1141	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:getVideoCoverUrlWithSmartCut	(Z)Ljava/net/URL;
    //   466: iconst_0
    //   467: invokespecial 1666	rqj:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;Ljava/net/URL;Z)V
    //   470: aload_1
    //   471: getfield 1838	pdq:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   474: aload_0
    //   475: invokevirtual 1609	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   478: aload_1
    //   479: getfield 1838	pdq:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   482: aload_0
    //   483: invokevirtual 2772	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setOnLongClickListener	(Landroid/view/View$OnLongClickListener;)V
    //   486: aload_1
    //   487: getfield 1838	pdq:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   490: aload_1
    //   491: invokevirtual 2982	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setTag	(Ljava/lang/Object;)V
    //   494: aload_1
    //   495: getfield 3115	pdq:jdField_b_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   498: iconst_0
    //   499: invokevirtual 1611	android/widget/TextView:setVisibility	(I)V
    //   502: aload_1
    //   503: getfield 3115	pdq:jdField_b_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   506: invokevirtual 2897	android/widget/TextView:clearAnimation	()V
    //   509: aload_1
    //   510: getfield 3174	pdq:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup	Lcom/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup;
    //   513: fconst_1
    //   514: aload 4
    //   516: getfield 839	rjk:jdField_c_of_type_Int	I
    //   519: aload 4
    //   521: getfield 842	rjk:jdField_d_of_type_Int	I
    //   524: invokestatic 2778	orc:a	(II)F
    //   527: invokevirtual 2784	com/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup:setCustomSize	(FF)V
    //   530: aload_1
    //   531: getfield 3174	pdq:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup	Lcom/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup;
    //   534: aload_0
    //   535: invokevirtual 3175	com/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   538: aload_1
    //   539: getfield 3174	pdq:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup	Lcom/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup;
    //   542: aload_1
    //   543: invokevirtual 2785	com/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup:setTag	(Ljava/lang/Object;)V
    //   546: aload_0
    //   547: aload_0
    //   548: getfield 142	rqj:jdField_c_of_type_Int	I
    //   551: aload_2
    //   552: getfield 1125	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mArticleID	J
    //   555: invokevirtual 2787	rqj:b	(IJ)Z
    //   558: ifeq +23 -> 581
    //   561: aload_1
    //   562: getfield 3176	pdq:jdField_f_of_type_AndroidViewView	Landroid/view/View;
    //   565: aload_0
    //   566: getfield 247	rqj:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   569: invokevirtual 1568	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   572: ldc_w 2790
    //   575: invokevirtual 2753	android/content/res/Resources:getColor	(I)I
    //   578: invokevirtual 2793	android/view/View:setBackgroundColor	(I)V
    //   581: aload_0
    //   582: invokevirtual 1300	rqj:a	()Landroid/app/Activity;
    //   585: aload_1
    //   586: getfield 3177	pdq:jdField_b_of_type_AndroidViewViewGroup	Landroid/view/ViewGroup;
    //   589: aload_1
    //   590: getfield 3178	pdq:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetRoundAngleFrameLayout	Lcom/tencent/biz/pubaccount/readinjoy/view/widget/RoundAngleFrameLayout;
    //   593: invokestatic 3181	osa:a	(Landroid/content/Context;Landroid/view/View;Lcom/tencent/biz/pubaccount/readinjoy/view/widget/RoundAngleFrameLayout;)V
    //   596: invokestatic 1214	ors:s	()Z
    //   599: ifeq +524 -> 1123
    //   602: aload_1
    //   603: getfield 3182	pdq:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   606: aload_0
    //   607: invokevirtual 1300	rqj:a	()Landroid/app/Activity;
    //   610: ldc_w 1567
    //   613: invokestatic 1224	bdaq:a	(Landroid/content/Context;F)I
    //   616: invokevirtual 2816	android/widget/TextView:setCompoundDrawablePadding	(I)V
    //   619: aload_0
    //   620: invokevirtual 1300	rqj:a	()Landroid/app/Activity;
    //   623: invokevirtual 1568	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   626: ldc_w 3183
    //   629: invokevirtual 2809	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   632: astore 4
    //   634: aload_0
    //   635: invokevirtual 1300	rqj:a	()Landroid/app/Activity;
    //   638: ldc_w 3184
    //   641: invokestatic 1224	bdaq:a	(Landroid/content/Context;F)I
    //   644: istore_3
    //   645: aload 4
    //   647: iconst_0
    //   648: iconst_0
    //   649: iload_3
    //   650: iload_3
    //   651: invokevirtual 2848	android/graphics/drawable/Drawable:setBounds	(IIII)V
    //   654: aload_1
    //   655: getfield 3182	pdq:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   658: aload 4
    //   660: aconst_null
    //   661: aconst_null
    //   662: aconst_null
    //   663: invokevirtual 2851	android/widget/TextView:setCompoundDrawables	(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V
    //   666: aload_1
    //   667: getfield 3178	pdq:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetRoundAngleFrameLayout	Lcom/tencent/biz/pubaccount/readinjoy/view/widget/RoundAngleFrameLayout;
    //   670: aload_0
    //   671: invokevirtual 3185	com/tencent/biz/pubaccount/readinjoy/view/widget/RoundAngleFrameLayout:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   674: aload_1
    //   675: getfield 3178	pdq:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetRoundAngleFrameLayout	Lcom/tencent/biz/pubaccount/readinjoy/view/widget/RoundAngleFrameLayout;
    //   678: aload_1
    //   679: invokevirtual 3186	com/tencent/biz/pubaccount/readinjoy/view/widget/RoundAngleFrameLayout:setTag	(Ljava/lang/Object;)V
    //   682: aload_1
    //   683: getfield 3182	pdq:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   686: aload_2
    //   687: invokevirtual 1618	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:getCommentCount	()I
    //   690: ldc_w 3187
    //   693: invokestatic 1623	alud:a	(I)Ljava/lang/String;
    //   696: invokestatic 3190	rdm:a	(Landroid/widget/TextView;ILjava/lang/String;)V
    //   699: aload_1
    //   700: getfield 3182	pdq:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   703: aload_0
    //   704: invokevirtual 1825	android/widget/TextView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   707: aload_1
    //   708: getfield 3182	pdq:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   711: aload_1
    //   712: invokevirtual 1831	android/widget/TextView:setTag	(Ljava/lang/Object;)V
    //   715: aload_1
    //   716: getfield 3191	pdq:jdField_a_of_type_AndroidWidgetRelativeLayout	Landroid/widget/RelativeLayout;
    //   719: aload_0
    //   720: invokevirtual 3192	android/widget/RelativeLayout:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   723: aload_1
    //   724: getfield 3191	pdq:jdField_a_of_type_AndroidWidgetRelativeLayout	Landroid/widget/RelativeLayout;
    //   727: aload_1
    //   728: invokevirtual 2970	android/widget/RelativeLayout:setTag	(Ljava/lang/Object;)V
    //   731: aload_2
    //   732: getfield 697	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mXGFileSize	J
    //   735: lconst_0
    //   736: lcmp
    //   737: ifgt +431 -> 1168
    //   740: aload_1
    //   741: getfield 3193	pdq:jdField_f_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   744: ldc_w 3194
    //   747: invokestatic 1623	alud:a	(I)Ljava/lang/String;
    //   750: invokevirtual 2720	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   753: aload_0
    //   754: getfield 247	rqj:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   757: invokestatic 1254	bdin:h	(Landroid/content/Context;)Z
    //   760: ifeq +447 -> 1207
    //   763: aload_1
    //   764: getfield 3196	pdq:jdField_d_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   767: iconst_0
    //   768: invokevirtual 1636	android/widget/ImageView:setVisibility	(I)V
    //   771: aload_1
    //   772: getfield 3193	pdq:jdField_f_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   775: bipush 8
    //   777: invokevirtual 1611	android/widget/TextView:setVisibility	(I)V
    //   780: aload_1
    //   781: getfield 3197	pdq:jdField_e_of_type_AndroidViewView	Landroid/view/View;
    //   784: iconst_0
    //   785: invokevirtual 1581	android/view/View:setVisibility	(I)V
    //   788: aload_1
    //   789: getfield 3198	pdq:jdField_d_of_type_AndroidViewView	Landroid/view/View;
    //   792: iconst_0
    //   793: invokevirtual 2793	android/view/View:setBackgroundColor	(I)V
    //   796: aload_1
    //   797: getfield 3199	pdq:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   800: bipush 8
    //   802: invokevirtual 1581	android/view/View:setVisibility	(I)V
    //   805: return
    //   806: aload_1
    //   807: getfield 3114	pdq:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   810: iconst_0
    //   811: invokevirtual 1611	android/widget/TextView:setVisibility	(I)V
    //   814: aload_1
    //   815: getfield 3114	pdq:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   818: new 854	java/lang/StringBuilder
    //   821: dup
    //   822: invokespecial 855	java/lang/StringBuilder:<init>	()V
    //   825: aload_2
    //   826: getfield 938	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mVideoPlayCount	I
    //   829: invokestatic 3002	rdm:c	(I)Ljava/lang/String;
    //   832: invokevirtual 859	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   835: ldc_w 3200
    //   838: invokestatic 1623	alud:a	(I)Ljava/lang/String;
    //   841: invokevirtual 859	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   844: invokevirtual 865	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   847: invokevirtual 2720	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   850: goto -776 -> 74
    //   853: astore 5
    //   855: aload 5
    //   857: invokevirtual 2801	java/lang/Exception:printStackTrace	()V
    //   860: goto -662 -> 198
    //   863: aload_1
    //   864: getfield 3129	pdq:jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   867: bipush 8
    //   869: invokevirtual 1610	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setVisibility	(I)V
    //   872: goto -674 -> 198
    //   875: aload_1
    //   876: getfield 1827	pdq:h	Landroid/widget/TextView;
    //   879: ldc_w 3202
    //   882: invokestatic 131	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   885: aload_0
    //   886: getfield 247	rqj:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   889: invokestatic 3205	oee:a	(ILandroid/content/Context;)Landroid/graphics/drawable/ShapeDrawable;
    //   892: invokestatic 3134	opi:a	(Landroid/view/View;Landroid/graphics/drawable/Drawable;)V
    //   895: goto -636 -> 259
    //   898: aload_1
    //   899: getfield 1827	pdq:h	Landroid/widget/TextView;
    //   902: aload_0
    //   903: getfield 247	rqj:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   906: ldc_w 3206
    //   909: invokevirtual 2469	android/app/Activity:getString	(I)Ljava/lang/String;
    //   912: invokevirtual 2720	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   915: goto -635 -> 280
    //   918: aload_1
    //   919: getfield 1824	pdq:i	Landroid/widget/TextView;
    //   922: aload_0
    //   923: getfield 247	rqj:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   926: ldc_w 3207
    //   929: invokevirtual 2469	android/app/Activity:getString	(I)Ljava/lang/String;
    //   932: invokevirtual 2720	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   935: goto -587 -> 348
    //   938: astore 6
    //   940: aload_1
    //   941: getfield 1824	pdq:i	Landroid/widget/TextView;
    //   944: aload_0
    //   945: getfield 247	rqj:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   948: ldc_w 3208
    //   951: invokevirtual 2469	android/app/Activity:getString	(I)Ljava/lang/String;
    //   954: invokevirtual 2720	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   957: goto -609 -> 348
    //   960: aload 5
    //   962: getfield 3158	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdBtnTxt	Ljava/lang/String;
    //   965: invokestatic 449	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   968: ifne +18 -> 986
    //   971: aload_1
    //   972: getfield 1824	pdq:i	Landroid/widget/TextView;
    //   975: aload 5
    //   977: getfield 3158	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdBtnTxt	Ljava/lang/String;
    //   980: invokevirtual 2720	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   983: goto -608 -> 375
    //   986: aload_1
    //   987: getfield 1824	pdq:i	Landroid/widget/TextView;
    //   990: aload_0
    //   991: getfield 247	rqj:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   994: ldc_w 3208
    //   997: invokevirtual 2469	android/app/Activity:getString	(I)Ljava/lang/String;
    //   1000: invokevirtual 2720	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   1003: goto -628 -> 375
    //   1006: astore 5
    //   1008: invokestatic 344	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1011: ifeq -593 -> 418
    //   1014: ldc_w 346
    //   1017: iconst_2
    //   1018: ldc_w 3210
    //   1021: aload 5
    //   1023: invokestatic 2997	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1026: goto -608 -> 418
    //   1029: aload_1
    //   1030: getfield 1827	pdq:h	Landroid/widget/TextView;
    //   1033: bipush 8
    //   1035: invokevirtual 1611	android/widget/TextView:setVisibility	(I)V
    //   1038: aload_1
    //   1039: getfield 3141	pdq:jdField_b_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   1042: bipush 8
    //   1044: invokevirtual 3144	android/widget/LinearLayout:setVisibility	(I)V
    //   1047: aload_1
    //   1048: getfield 3168	pdq:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyVideoInfoViewGroup	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyVideoInfoViewGroup;
    //   1051: iconst_0
    //   1052: invokevirtual 3171	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyVideoInfoViewGroup:setVisibility	(I)V
    //   1055: aload_1
    //   1056: getfield 3173	pdq:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   1059: iconst_0
    //   1060: invokevirtual 3144	android/widget/LinearLayout:setVisibility	(I)V
    //   1063: aload_1
    //   1064: getfield 3168	pdq:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyVideoInfoViewGroup	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyVideoInfoViewGroup;
    //   1067: aload_2
    //   1068: aload_0
    //   1069: aload_0
    //   1070: getfield 142	rqj:jdField_c_of_type_Int	I
    //   1073: aload_0
    //   1074: getfield 280	rqj:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   1077: invokevirtual 3214	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyVideoInfoViewGroup:setArticleInfo	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;Landroid/widget/BaseAdapter;ILjava/util/Set;)V
    //   1080: aload_1
    //   1081: getfield 3215	pdq:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   1084: aload_0
    //   1085: invokevirtual 1821	android/widget/ImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   1088: aload_1
    //   1089: getfield 3215	pdq:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   1092: aload_1
    //   1093: invokevirtual 1832	android/widget/ImageView:setTag	(Ljava/lang/Object;)V
    //   1096: aload_1
    //   1097: getfield 3216	pdq:jdField_b_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   1100: aload_0
    //   1101: invokevirtual 1821	android/widget/ImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   1104: aload_1
    //   1105: getfield 3216	pdq:jdField_b_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   1108: aload_0
    //   1109: invokevirtual 3217	android/widget/ImageView:setOnLongClickListener	(Landroid/view/View$OnLongClickListener;)V
    //   1112: aload_1
    //   1113: getfield 3216	pdq:jdField_b_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   1116: aload_1
    //   1117: invokevirtual 1832	android/widget/ImageView:setTag	(Ljava/lang/Object;)V
    //   1120: goto -679 -> 441
    //   1123: aload_1
    //   1124: getfield 3182	pdq:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   1127: aload_0
    //   1128: invokevirtual 1300	rqj:a	()Landroid/app/Activity;
    //   1131: fconst_0
    //   1132: invokestatic 1224	bdaq:a	(Landroid/content/Context;F)I
    //   1135: invokevirtual 2816	android/widget/TextView:setCompoundDrawablePadding	(I)V
    //   1138: aload_0
    //   1139: invokevirtual 1300	rqj:a	()Landroid/app/Activity;
    //   1142: invokevirtual 1568	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   1145: ldc_w 3218
    //   1148: invokevirtual 2809	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   1151: astore 4
    //   1153: aload_1
    //   1154: getfield 3182	pdq:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   1157: aload 4
    //   1159: aconst_null
    //   1160: aconst_null
    //   1161: aconst_null
    //   1162: invokevirtual 2813	android/widget/TextView:setCompoundDrawablesWithIntrinsicBounds	(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V
    //   1165: goto -499 -> 666
    //   1168: aload_1
    //   1169: getfield 3193	pdq:jdField_f_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   1172: new 854	java/lang/StringBuilder
    //   1175: dup
    //   1176: invokespecial 855	java/lang/StringBuilder:<init>	()V
    //   1179: aload_2
    //   1180: getfield 697	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mXGFileSize	J
    //   1183: invokestatic 2804	rdm:b	(J)Ljava/lang/String;
    //   1186: invokevirtual 859	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1189: ldc_w 3219
    //   1192: invokestatic 1623	alud:a	(I)Ljava/lang/String;
    //   1195: invokevirtual 859	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1198: invokevirtual 865	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1201: invokevirtual 2720	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   1204: goto -451 -> 753
    //   1207: aload_1
    //   1208: getfield 3196	pdq:jdField_d_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   1211: bipush 8
    //   1213: invokevirtual 1636	android/widget/ImageView:setVisibility	(I)V
    //   1216: aload_0
    //   1217: getfield 247	rqj:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   1220: invokevirtual 1568	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   1223: ldc_w 2806
    //   1226: invokevirtual 2809	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   1229: astore 4
    //   1231: aload_1
    //   1232: getfield 3193	pdq:jdField_f_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   1235: aload 4
    //   1237: aconst_null
    //   1238: aconst_null
    //   1239: aconst_null
    //   1240: invokevirtual 2813	android/widget/TextView:setCompoundDrawablesWithIntrinsicBounds	(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V
    //   1243: aload_1
    //   1244: getfield 3193	pdq:jdField_f_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   1247: ldc_w 2130
    //   1250: aload_0
    //   1251: getfield 247	rqj:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   1254: invokevirtual 1568	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   1257: invokestatic 610	aepi:a	(FLandroid/content/res/Resources;)I
    //   1260: invokevirtual 2816	android/widget/TextView:setCompoundDrawablePadding	(I)V
    //   1263: aload_1
    //   1264: getfield 3193	pdq:jdField_f_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   1267: iconst_0
    //   1268: invokevirtual 1611	android/widget/TextView:setVisibility	(I)V
    //   1271: invokestatic 2819	beaa:a	()I
    //   1274: iconst_1
    //   1275: if_icmpne +44 -> 1319
    //   1278: aload_1
    //   1279: getfield 3193	pdq:jdField_f_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   1282: ldc_w 3220
    //   1285: invokestatic 1623	alud:a	(I)Ljava/lang/String;
    //   1288: invokevirtual 2720	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   1291: aload_1
    //   1292: getfield 3221	pdq:g	Landroid/widget/TextView;
    //   1295: bipush 8
    //   1297: invokevirtual 1611	android/widget/TextView:setVisibility	(I)V
    //   1300: aload_1
    //   1301: getfield 3197	pdq:jdField_e_of_type_AndroidViewView	Landroid/view/View;
    //   1304: iconst_0
    //   1305: invokevirtual 1581	android/view/View:setVisibility	(I)V
    //   1308: aload_1
    //   1309: getfield 3198	pdq:jdField_d_of_type_AndroidViewView	Landroid/view/View;
    //   1312: iconst_0
    //   1313: invokevirtual 2793	android/view/View:setBackgroundColor	(I)V
    //   1316: goto -520 -> 796
    //   1319: invokestatic 2824	bkbq:v	()Z
    //   1322: ifeq +300 -> 1622
    //   1325: aload_0
    //   1326: getfield 2825	rqj:jdField_h_of_type_Boolean	Z
    //   1329: ifne +293 -> 1622
    //   1332: aload_1
    //   1333: getfield 1311	pdq:jdField_a_of_type_Int	I
    //   1336: ifne +286 -> 1622
    //   1339: invokestatic 2827	bkbq:d	()Ljava/lang/String;
    //   1342: astore 5
    //   1344: invokestatic 2829	bkbq:e	()Ljava/lang/String;
    //   1347: astore 6
    //   1349: invokestatic 2831	bkbq:f	()Ljava/lang/String;
    //   1352: astore 7
    //   1354: aload 5
    //   1356: invokestatic 449	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1359: ifne +219 -> 1578
    //   1362: invokestatic 2833	ors:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1365: astore 8
    //   1367: ldc_w 940
    //   1370: astore 4
    //   1372: aload 8
    //   1374: ifnull +10 -> 1384
    //   1377: aload 8
    //   1379: invokevirtual 2836	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1382: astore 4
    //   1384: new 1366	ron
    //   1387: dup
    //   1388: aconst_null
    //   1389: aconst_null
    //   1390: aconst_null
    //   1391: aconst_null
    //   1392: invokespecial 1369	ron:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1395: aload 4
    //   1397: invokevirtual 2839	ron:l	(Ljava/lang/String;)Lron;
    //   1400: aload_2
    //   1401: getfield 798	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:innerUniqueID	Ljava/lang/String;
    //   1404: invokevirtual 2841	ron:h	(Ljava/lang/String;)Lron;
    //   1407: invokevirtual 1392	ron:a	()Lrom;
    //   1410: invokevirtual 1396	rom:a	()Ljava/lang/String;
    //   1413: astore_2
    //   1414: aload_1
    //   1415: getfield 3221	pdq:g	Landroid/widget/TextView;
    //   1418: iconst_0
    //   1419: invokevirtual 1611	android/widget/TextView:setVisibility	(I)V
    //   1422: aload_1
    //   1423: getfield 3221	pdq:g	Landroid/widget/TextView;
    //   1426: fconst_2
    //   1427: aload_0
    //   1428: getfield 247	rqj:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   1431: invokevirtual 1568	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   1434: invokestatic 610	aepi:a	(FLandroid/content/res/Resources;)I
    //   1437: invokevirtual 2816	android/widget/TextView:setCompoundDrawablePadding	(I)V
    //   1440: aload_0
    //   1441: getfield 247	rqj:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   1444: invokevirtual 1568	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   1447: ldc_w 2842
    //   1450: invokevirtual 2809	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   1453: astore 4
    //   1455: aload 4
    //   1457: iconst_0
    //   1458: iconst_0
    //   1459: ldc_w 2843
    //   1462: aload_0
    //   1463: getfield 247	rqj:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   1466: invokevirtual 1568	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   1469: invokestatic 610	aepi:a	(FLandroid/content/res/Resources;)I
    //   1472: ldc_w 2843
    //   1475: aload_0
    //   1476: getfield 247	rqj:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   1479: invokevirtual 1568	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   1482: invokestatic 610	aepi:a	(FLandroid/content/res/Resources;)I
    //   1485: invokevirtual 2848	android/graphics/drawable/Drawable:setBounds	(IIII)V
    //   1488: aload_1
    //   1489: getfield 3221	pdq:g	Landroid/widget/TextView;
    //   1492: aconst_null
    //   1493: aconst_null
    //   1494: aload 4
    //   1496: aconst_null
    //   1497: invokevirtual 2851	android/widget/TextView:setCompoundDrawables	(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V
    //   1500: aload_0
    //   1501: getfield 247	rqj:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   1504: aload_1
    //   1505: getfield 3221	pdq:g	Landroid/widget/TextView;
    //   1508: aload 6
    //   1510: aload 7
    //   1512: aload 5
    //   1514: new 3223	rrh
    //   1517: dup
    //   1518: aload_0
    //   1519: aload_2
    //   1520: invokespecial 3224	rrh:<init>	(Lrqj;Ljava/lang/String;)V
    //   1523: invokestatic 2857	rdm:b	(Landroid/content/Context;Landroid/widget/TextView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/view/View$OnClickListener;)V
    //   1526: aload_1
    //   1527: getfield 3198	pdq:jdField_d_of_type_AndroidViewView	Landroid/view/View;
    //   1530: ldc_w 2858
    //   1533: invokevirtual 2793	android/view/View:setBackgroundColor	(I)V
    //   1536: aload_1
    //   1537: getfield 3197	pdq:jdField_e_of_type_AndroidViewView	Landroid/view/View;
    //   1540: iconst_0
    //   1541: invokevirtual 1581	android/view/View:setVisibility	(I)V
    //   1544: aload_0
    //   1545: iconst_1
    //   1546: putfield 2825	rqj:jdField_h_of_type_Boolean	Z
    //   1549: aconst_null
    //   1550: ldc_w 940
    //   1553: ldc_w 2860
    //   1556: ldc_w 2860
    //   1559: iconst_0
    //   1560: iconst_0
    //   1561: ldc_w 940
    //   1564: ldc_w 940
    //   1567: ldc_w 940
    //   1570: aload_2
    //   1571: iconst_0
    //   1572: invokestatic 1405	nrt:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   1575: goto -779 -> 796
    //   1578: aload_1
    //   1579: getfield 3221	pdq:g	Landroid/widget/TextView;
    //   1582: bipush 8
    //   1584: invokevirtual 1611	android/widget/TextView:setVisibility	(I)V
    //   1587: aload_1
    //   1588: getfield 3197	pdq:jdField_e_of_type_AndroidViewView	Landroid/view/View;
    //   1591: iconst_0
    //   1592: invokevirtual 1581	android/view/View:setVisibility	(I)V
    //   1595: aload_1
    //   1596: getfield 3198	pdq:jdField_d_of_type_AndroidViewView	Landroid/view/View;
    //   1599: iconst_0
    //   1600: invokevirtual 2793	android/view/View:setBackgroundColor	(I)V
    //   1603: invokestatic 344	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1606: ifeq -810 -> 796
    //   1609: ldc_w 1091
    //   1612: iconst_2
    //   1613: ldc_w 2862
    //   1616: invokestatic 1096	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1619: goto -823 -> 796
    //   1622: aload_1
    //   1623: getfield 3221	pdq:g	Landroid/widget/TextView;
    //   1626: bipush 8
    //   1628: invokevirtual 1611	android/widget/TextView:setVisibility	(I)V
    //   1631: aload_1
    //   1632: getfield 3197	pdq:jdField_e_of_type_AndroidViewView	Landroid/view/View;
    //   1635: iconst_0
    //   1636: invokevirtual 1581	android/view/View:setVisibility	(I)V
    //   1639: aload_1
    //   1640: getfield 3198	pdq:jdField_d_of_type_AndroidViewView	Landroid/view/View;
    //   1643: iconst_0
    //   1644: invokevirtual 2793	android/view/View:setBackgroundColor	(I)V
    //   1647: goto -851 -> 796
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1650	0	this	rqj
    //   0	1650	1	parampdq	pdq
    //   0	1650	2	paramBaseArticleInfo	BaseArticleInfo
    //   0	1650	3	paramInt	int
    //   14	1481	4	localObject1	Object
    //   178	230	5	localObject2	Object
    //   853	123	5	localException	Exception
    //   1006	16	5	localJSONException1	JSONException
    //   1342	171	5	str1	String
    //   309	7	6	localJSONObject	JSONObject
    //   938	1	6	localJSONException2	JSONException
    //   1347	162	6	str2	String
    //   1352	159	7	str3	String
    //   1365	13	8	localQQAppInterface	QQAppInterface
    // Exception table:
    //   from	to	target	type
    //   167	198	853	java/lang/Exception
    //   297	346	938	org/json/JSONException
    //   918	935	938	org/json/JSONException
    //   375	418	1006	org/json/JSONException
  }
  
  public void a(pdv parampdv, BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    parampdv.jdField_f_of_type_AndroidViewView.setOnClickListener(null);
    parampdv.jdField_f_of_type_AndroidViewView.setOnLongClickListener(this);
    parampdv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = paramBaseArticleInfo;
    parampdv.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = ((BaseArticleInfo)paramBaseArticleInfo.mSubArtilceList.get(0));
    BaseArticleInfo localBaseArticleInfo = parampdv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
    parampdv.jdField_a_of_type_AndroidWidgetTextView.setText(localBaseArticleInfo.mTitle);
    parampdv.jdField_a_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
    parampdv.jdField_b_of_type_AndroidWidgetTextView.setText(rdm.c(localBaseArticleInfo.mVideoPlayCount));
    paramBaseArticleInfo = this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130842771);
    paramInt = bdoo.b(8.0F);
    paramBaseArticleInfo.setBounds(0, 0, paramInt, paramInt);
    parampdv.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables(paramBaseArticleInfo, null, null, null);
    parampdv.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(bdoo.b(3.0F));
    rdm.a(parampdv.jdField_c_of_type_AndroidWidgetTextView, localBaseArticleInfo.getCommentCount(), alud.a(2131713128), "0");
    URL localURL = localBaseArticleInfo.getVideoCoverUrlWithSmartCut(true);
    a(parampdv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, localURL, false);
    parampdv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setTag(parampdv);
    parampdv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setOnClickListener(this);
    parampdv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setOnLongClickListener(this);
    rdm.a(localBaseArticleInfo.mVideoArticleSubsText, localBaseArticleInfo.mVideoArticleSubsColor, parampdv.jdField_d_of_type_AndroidWidgetTextView);
    localBaseArticleInfo = parampdv.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
    parampdv.jdField_e_of_type_AndroidWidgetTextView.setText(localBaseArticleInfo.mTitle);
    parampdv.jdField_e_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
    parampdv.jdField_f_of_type_AndroidWidgetTextView.setText(rdm.c(localBaseArticleInfo.mVideoPlayCount));
    parampdv.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawables(paramBaseArticleInfo, null, null, null);
    parampdv.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(bdoo.b(3.0F));
    rdm.a(parampdv.g, localBaseArticleInfo.getCommentCount(), alud.a(2131713117), "0");
    paramBaseArticleInfo = localBaseArticleInfo.getVideoCoverUrlWithSmartCut(true);
    a(parampdv.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, paramBaseArticleInfo, false);
    parampdv.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setTag(parampdv);
    parampdv.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setOnClickListener(this);
    parampdv.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setOnLongClickListener(this);
    rdm.a(localBaseArticleInfo.mVideoArticleSubsText, localBaseArticleInfo.mVideoArticleSubsColor, parampdv.h);
  }
  
  public void a(rjg paramrjg, qzy paramqzy)
  {
    this.jdField_a_of_type_Rjg = paramrjg;
    this.jdField_a_of_type_Qzy = paramqzy;
    if (qzy.a(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext())) {
      this.jdField_a_of_type_Qzy.b(true);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyBaseAdapter", 2, "setVideoPlayManager " + this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler + " mVideoPlayManager " + this.jdField_a_of_type_Rjg + " mIsCleanData " + this.n);
      }
      if ((this.jdField_a_of_type_Rjg != null) && (!this.n))
      {
        b();
        this.jdField_a_of_type_Rjg.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr);
        this.jdField_a_of_type_Rjg.a(this.jdField_a_of_type_Qzy);
        if (bkbq.a(this.jdField_d_of_type_Int)) {
          this.jdField_a_of_type_Rjg.a(0);
        }
      }
      if ((oee.a(this.jdField_c_of_type_Int)) && (this.jdField_a_of_type_Rjg != null))
      {
        this.jdField_a_of_type_Qzp = new qzp(this.jdField_a_of_type_AndroidAppActivity, this, this.jdField_a_of_type_Rjg, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, this.jdField_c_of_type_Int);
        this.jdField_a_of_type_Rjg.a(this.jdField_a_of_type_Qzp);
      }
      return;
      this.jdField_a_of_type_Qzy.b(false);
    }
  }
  
  public void a(rjk paramrjk)
  {
    if ((this.jdField_a_of_type_Bhxx != null) && (this.jdField_a_of_type_Bhxx.isShowing())) {
      this.jdField_a_of_type_Bhxx.dismiss();
    }
    if ((this.jdField_a_of_type_Bhyd != null) && (this.jdField_a_of_type_Bhyd.isShowing())) {
      this.jdField_a_of_type_Bhyd.dismiss();
    }
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new ReadInJoyBaseAdapter.28(this, paramrjk), 1000L);
  }
  
  public void a(rjk paramrjk, int paramInt)
  {
    if (this.jdField_a_of_type_Pdn != null) {}
    for (;;)
    {
      return;
      pdq localpdq = a(paramrjk.jdField_j_of_type_JavaLangString);
      if (localpdq != null)
      {
        this.jdField_a_of_type_Pdn = localpdq;
        paramrjk.jdField_a_of_type_AndroidViewView = localpdq.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
      }
      while ((this.jdField_a_of_type_Rjg != null) && (this.jdField_a_of_type_Rjg.a() != null))
      {
        paramrjk = this.jdField_a_of_type_Rjg.a();
        if (QLog.isColorLevel()) {
          QLog.i("ReadInJoyBaseAdapter", 2, "notifyVideoPositionChanged:");
        }
        paramrjk.g();
        return;
        if (QLog.isColorLevel()) {
          QLog.e("ReadInJoyBaseAdapter", 2, "fixNowPlayHolder failed videoPlayParam:" + paramrjk + "    callSource:" + paramInt);
        }
      }
    }
  }
  
  public void a(rjk paramrjk, BaseArticleInfo paramBaseArticleInfo)
  {
    a(paramrjk, paramBaseArticleInfo, false);
  }
  
  public void a(rjk paramrjk, BaseArticleInfo paramBaseArticleInfo, boolean paramBoolean)
  {
    a(paramrjk, paramBaseArticleInfo, paramBoolean, true);
  }
  
  public void a(rjk paramrjk, BaseArticleInfo paramBaseArticleInfo, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "open full play activity, articleID : " + paramBaseArticleInfo.mArticleID + ", playPosition : " + paramrjk.jdField_d_of_type_Long + ",vid : " + paramrjk.jdField_c_of_type_JavaLangString + ", showComment : " + paramBoolean1);
    }
    if (this.jdField_a_of_type_Rjg != null) {
      this.jdField_a_of_type_Rjg.b();
    }
    this.jdField_j_of_type_Boolean = true;
    Bundle localBundle;
    if (ors.s(paramBaseArticleInfo)) {
      localBundle = b(paramrjk, paramBaseArticleInfo);
    }
    for (;;)
    {
      int i1;
      label137:
      Object localObject;
      label266:
      label275:
      Intent localIntent;
      if (this.jdField_a_of_type_Rjg != null)
      {
        if (this.jdField_a_of_type_Rjg.b() == paramBaseArticleInfo.mArticleID)
        {
          i1 = this.jdField_a_of_type_Rjg.a();
          localBundle.putInt("VIDEO_PLAY_STATUS", i1);
        }
      }
      else
      {
        if (paramrjk.jdField_f_of_type_Int == 2)
        {
          localObject = osf.a(paramrjk.jdField_c_of_type_JavaLangString);
          if (localObject != null)
          {
            localBundle.putString("VIDEO_THIRD_VID_URL", ((osl)localObject).jdField_a_of_type_JavaLangString);
            localBundle.putLong("VIDEO_THIRD_VID_URL_TIME", ((osl)localObject).jdField_a_of_type_Long);
          }
        }
        localBundle.putBoolean("VIDEO_LIST_SCROLL_EXIT", true);
        localBundle.putInt("REPORT_VIDEO_FEEDS_JUMP_FROM", 3);
        if (this.jdField_c_of_type_Int != 0) {
          break label748;
        }
        if (!ors.i(paramBaseArticleInfo)) {
          break label701;
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
          localBundle.putBoolean("param_needSmooth", rlb.a().d());
          rlb.a().f(true);
          localBundle.putBoolean("param_needAlertInXg", qzy.e());
        }
        localIntent.putExtras(localBundle);
        if ((paramrjk.jdField_f_of_type_Int == 6) && (!ors.s(paramBaseArticleInfo))) {
          localIntent.putExtra("VIDEO_ARTICLE_INFO_FOR_BIU", (ArticleInfo)paramBaseArticleInfo);
        }
        i1 = 9091;
        if (1 != paramBaseArticleInfo.mVideoType) {
          break label1070;
        }
        i1 = 1;
        label432:
        localIntent.putExtra("VIDEO_FEEDS_INNER_SESSION_ID", paramrjk.l);
        localIntent.putExtra("VIDEO_CHANNEL_SESSION_ID", paramrjk.jdField_m_of_type_JavaLangString);
        localIntent.putExtra("item_x", paramrjk.jdField_h_of_type_Int);
        localIntent.putExtra("item_y", paramrjk.jdField_i_of_type_Int);
        localIntent.putExtra("item_width", paramrjk.jdField_j_of_type_Int);
        localIntent.putExtra("item_height", paramrjk.jdField_k_of_type_Int);
        localIntent.putExtra("VIDEO_FEEDS_TYPE_FOR_REPORT", ors.a(paramBaseArticleInfo));
        localIntent.putExtra("VIDEO_SHOW_COMMENT", paramBoolean1);
      }
      try
      {
        paramBoolean1 = otp.a(localBundle.getInt("VIDEO_FROM_TYPE", -1), Integer.valueOf(localBundle.getString("VIDEO_WIDTH")).intValue(), Integer.valueOf(localBundle.getString("VIDEO_HEIGHT")).intValue(), Integer.valueOf(localBundle.getString("VIDEO_TIME")).intValue());
        if (paramBoolean1)
        {
          MultiVideoFragment.a(this.jdField_a_of_type_AndroidAppActivity, localIntent, i1);
          ((Activity)localObject).overridePendingTransition(2130772010, 0);
          rip.a();
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr != null)
          {
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.e();
            this.jdField_k_of_type_Boolean = true;
          }
          if (bkbq.j()) {
            nrt.a(null, "", "0X8008B68", "0X8008B68", 0, 0, "", "", "", ntd.a(null, null, paramBaseArticleInfo.mVideoVid, paramBaseArticleInfo.innerUniqueID, a(), null), false);
          }
          return;
          localBundle = a(paramrjk, paramBaseArticleInfo);
          continue;
          i1 = 1;
          break label137;
          label701:
          if (ors.s(paramBaseArticleInfo))
          {
            localBundle.putInt("VIDEO_FROM_TYPE", 13);
            localBundle.putLong("VIDEO_FROM_POLYMERIC_PUIN", paramBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_Long);
            break label266;
          }
          localBundle.putInt("VIDEO_FROM_TYPE", 3);
          break label266;
          label748:
          if (this.jdField_c_of_type_Int == 56)
          {
            if (ors.i(paramBaseArticleInfo))
            {
              localBundle.putInt("VIDEO_FROM_TYPE", 5);
              localBundle.putLong("VIDEO_FROM_POLYMERIC_TOPIC_ID", paramBaseArticleInfo.mPolymericInfo.jdField_f_of_type_Long);
              localBundle.putLong("VIDEO_FROM_POLYMERIC_PUIN", paramBaseArticleInfo.mPolymericInfo.jdField_b_of_type_Long);
            }
            for (;;)
            {
              localBundle.putInt("PERFORMANCE_REPORT_VIDEO_FEEDS_JUMP_FROM", 4);
              break;
              if (ors.s(paramBaseArticleInfo))
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
            if (ors.s(paramBaseArticleInfo))
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
          if (otf.c(this.jdField_c_of_type_Int))
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
          label1070:
          if (0L != paramBaseArticleInfo.mChannelID) {
            break label432;
          }
          i1 = 1;
        }
      }
      catch (Exception paramrjk)
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
  
  public void a(rjk paramrjk1, rjk paramrjk2)
  {
    if (paramrjk1 != paramrjk2)
    {
      if (((paramrjk1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo instanceof ArticleInfo)) && ((paramrjk2.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo instanceof ArticleInfo))) {
        owy.a().a(this.jdField_c_of_type_Int, (ArticleInfo)paramrjk1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, (ArticleInfo)paramrjk2.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.clearFocus();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.postDelayed(new ReadInJoyBaseAdapter.27(this, paramrjk1, paramrjk2), 100L);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Rkw != null) {
        this.jdField_a_of_type_Rkw.a(paramrjk1, paramrjk2);
      }
      return;
      if (this.jdField_a_of_type_Rjg.a() == 7) {
        a(paramrjk1);
      }
    }
  }
  
  public void a(rkw paramrkw)
  {
    this.jdField_a_of_type_Rkw = paramrkw;
  }
  
  public void a(rpx paramrpx)
  {
    this.jdField_a_of_type_Rpx = paramrpx;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setNoteCardLifeCycle(paramrpx);
    }
  }
  
  public void a(rrl paramrrl)
  {
    this.jdField_a_of_type_Rrl = paramrrl;
  }
  
  public void a(rrm paramrrm)
  {
    this.jdField_a_of_type_Rrm = paramrrm;
  }
  
  public void a(rrn paramrrn)
  {
    this.jdField_a_of_type_Rrn = paramrrn;
  }
  
  public void a(rro paramrro)
  {
    this.jdField_a_of_type_Rro = paramrro;
  }
  
  public void a(rrp paramrrp)
  {
    this.jdField_a_of_type_Rrp = paramrrp;
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
    rjk localrjk = a(paramArticleInfo1);
    localrjk.jdField_n_of_type_JavaLangString = paramString;
    localrjk.l = ntd.b();
    if ((this.jdField_a_of_type_Rjg != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Rjg.a()))) {
      localrjk.jdField_m_of_type_JavaLangString = this.jdField_a_of_type_Rjg.a();
    }
    paramString = new ron(null, null, null, null);
    int i1;
    if (paramBoolean)
    {
      i1 = 0;
      nrt.a(null, "", "0X8008D33", "0X8008D33", 0, 0, "", "", "", paramString.x(i1).b(localrjk.l).c(localrjk.jdField_m_of_type_JavaLangString).a(this.jdField_c_of_type_Int).k(paramArticleInfo1.mVideoAdsSource).j(paramArticleInfo1.mVideoAdsJumpType).a(paramArticleInfo1.videoReportInfo).a(paramArticleInfo1).O((int)this.jdField_c_of_type_Long).a().a(), false);
      if (!rdm.a(paramArticleInfo1, a())) {
        break label192;
      }
      b(localrjk, paramArticleInfo1);
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
        ors.d(a(), paramArticleInfo1.mArticleContentUrl);
        paramString = new ron(null, null, paramArticleInfo1.mVideoVid, paramArticleInfo1.innerUniqueID);
        if (paramBoolean)
        {
          i1 = 0;
          paramArticleInfo2 = paramString.x(i1).b(localrjk.l).c(localrjk.jdField_m_of_type_JavaLangString).a(this.jdField_c_of_type_Int).k(paramArticleInfo1.mVideoAdsSource).j(paramArticleInfo1.mVideoAdsJumpType).a(paramArticleInfo1.videoReportInfo).a(paramArticleInfo1).O((int)this.jdField_c_of_type_Long).W(ors.a(paramArticleInfo1)).e(paramArticleInfo1).R(7).f(paramArticleInfo2);
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
          nrt.a(null, "", "0X8007625", "0X8007625", 0, 0, "", "", "", a(paramArticleInfo2.a().a(), paramMap), false);
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
          paramString.putExtra("big_brother_source_key", ors.f(a()));
          paramArticleInfo2.startActivity(paramString);
        }
        b(localrjk, paramArticleInfo1);
        return;
      }
      if ((this.jdField_c_of_type_Int != 0) && (this.jdField_c_of_type_Int != 56)) {
        break label801;
      }
      if (!rdm.a(this.jdField_a_of_type_AndroidAppActivity, paramArticleInfo1)) {
        break label698;
      }
      b(localrjk, paramArticleInfo1);
    } while ((this.jdField_c_of_type_Int != 56) || (paramArticleInfo1.mVideoDownloadBarInfo == null) || (paramArticleInfo1.mVideoDownloadBarInfo.weishiUGInfo == null) || (!ors.a(paramArticleInfo1.mVideoDownloadBarInfo.weishiUGInfo.bytes_report_base_url)) || (!ors.a(paramArticleInfo1.mVideoDownloadBarInfo.weishiUGInfo.bytes_click_schema_report_tail)));
    label414:
    rdm.a(ors.a(paramArticleInfo1.mVideoDownloadBarInfo.weishiUGInfo.bytes_report_base_url) + ors.a(paramArticleInfo1.mVideoDownloadBarInfo.weishiUGInfo.bytes_click_schema_report_tail));
    return;
    label698:
    if ((this.jdField_c_of_type_Int == 56) && (paramArticleInfo1.mVideoDownloadBarInfo != null) && (paramArticleInfo1.mVideoDownloadBarInfo.weishiUGInfo != null) && (ors.a(paramArticleInfo1.mVideoDownloadBarInfo.weishiUGInfo.bytes_report_base_url)) && (ors.a(paramArticleInfo1.mVideoDownloadBarInfo.weishiUGInfo.bytes_click_report_tail))) {
      rdm.a(ors.a(paramArticleInfo1.mVideoDownloadBarInfo.weishiUGInfo.bytes_report_base_url) + ors.a(paramArticleInfo1.mVideoDownloadBarInfo.weishiUGInfo.bytes_click_report_tail));
    }
    label801:
    if (paramArticleInfo1.videoJumpChannelID > 0)
    {
      if (paramArticleInfo1.videoJumpChannelID == 56) {
        nxu.a(this.jdField_a_of_type_AndroidAppActivity, paramArticleInfo2, paramArticleInfo1, true);
      }
      for (;;)
      {
        b(localrjk, paramArticleInfo1);
        return;
        paramArticleInfo2 = new HashMap();
        paramArticleInfo2.put("param_key_insert_article_id", Long.valueOf(paramArticleInfo1.mArticleID));
        nxu.b(this.jdField_a_of_type_AndroidAppActivity, paramArticleInfo1.videoJumpChannelID, paramArticleInfo1.videoJumpChannelName, paramArticleInfo1.videoJumpChannelType, 5, paramArticleInfo2);
      }
    }
    if (bkbq.d(BaseApplicationImpl.getApplication().getRuntime()) == 1)
    {
      nxu.a(this.jdField_a_of_type_AndroidAppActivity, paramArticleInfo2, paramArticleInfo1, true);
      b(localrjk, paramArticleInfo1);
      return;
    }
    localrjk.jdField_a_of_type_JavaUtilMap = paramMap;
    a(localrjk, paramArticleInfo1);
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
      owy.a().a(56, 3, paramBaseArticleInfo.mArticleID, l1);
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
  
  public pdq b(String paramString)
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
          localObject1 = (pdq)paramString.getTag();
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
    for (int i1 = rjz.jdField_b_of_type_Int;; i1 = rjz.jdField_a_of_type_Int)
    {
      localVideoPreDownloadMgr.a = new rjz(i1, rjz.jdField_f_of_type_Int);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a(new rqs(this));
      return;
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
  }
  
  public void b(BaseArticleInfo paramBaseArticleInfo)
  {
    if ((paramBaseArticleInfo.isAccountShown) && (this.jdField_c_of_type_Int == 0) && (!TextUtils.isEmpty(ors.a(paramBaseArticleInfo.mPartnerAccountInfo.bytes_head_jump_url)))) {
      ors.d(a(), ors.a(paramBaseArticleInfo.mPartnerAccountInfo.bytes_head_jump_url));
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
      } while ((!bdin.g(this.jdField_a_of_type_AndroidAppActivity)) || (this.jdField_a_of_type_Rjg == null) || (paramAbsListView == null));
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
  
  public void b(rjk paramrjk, BaseArticleInfo paramBaseArticleInfo)
  {
    int i3 = a();
    String str1 = ors.d(paramBaseArticleInfo);
    int i1;
    int i2;
    label40:
    ron localron;
    if (((ArticleInfo)paramBaseArticleInfo).hasChannelInfo())
    {
      i1 = paramBaseArticleInfo.mChannelInfoId;
      if (!TextUtils.isEmpty(paramBaseArticleInfo.mArticleFriendLikeText)) {
        break label529;
      }
      i2 = 0;
      nrt.a(null, "CliOper", "", "", "0X80066FA", "0X80066FA", 0, 0, "", Long.toString(paramBaseArticleInfo.mArticleID), Integer.toString(paramBaseArticleInfo.mStrategyId), ors.b(paramBaseArticleInfo.mAlgorithmID, ors.a(paramBaseArticleInfo), this.jdField_c_of_type_Int, i1), false);
      nrt.a("0X80066FA", "", "", Long.toString(paramBaseArticleInfo.mArticleID), Integer.toString(paramBaseArticleInfo.mStrategyId), ors.b(paramBaseArticleInfo.mAlgorithmID, ors.a(paramBaseArticleInfo), this.jdField_c_of_type_Int, i1));
      localron = new ron(ors.a(paramBaseArticleInfo.mAlgorithmID, ors.a(paramBaseArticleInfo), i3, i1, i2, bdin.h(this.jdField_a_of_type_AndroidAppActivity), str1, paramBaseArticleInfo.mStrCircleId, paramBaseArticleInfo.innerUniqueID, ors.f(paramBaseArticleInfo), 409409, (ArticleInfo)paramBaseArticleInfo));
      localron.a(this.jdField_a_of_type_Rkb, paramBaseArticleInfo.mArticleID).a(this.jdField_a_of_type_Rkb).g(ntd.jdField_a_of_type_Int).h(409409).j(paramBaseArticleInfo.mVideoAdsJumpType).k(paramBaseArticleInfo.mVideoAdsSource).a(Boolean.valueOf(ors.w(paramBaseArticleInfo))).a(paramBaseArticleInfo.videoReportInfo);
      if (i3 != 0) {
        break label535;
      }
      paramrjk.l = ntd.b();
      localron.b(paramrjk.l);
      if (paramBaseArticleInfo.mVideoColumnInfo != null) {
        localron.aa(paramBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_Int);
      }
      if (c((ArticleInfo)paramBaseArticleInfo) == 6) {
        localron.ac(rdm.b());
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Rjg != null) && (this.jdField_a_of_type_Rjg.a() == paramrjk))
      {
        long l1 = this.jdField_a_of_type_Rjg.a();
        if (l1 != 0L) {
          localron.f(l1);
        }
      }
      if (this.jdField_c_of_type_Int != 40677) {
        break label586;
      }
      localron.b(paramBaseArticleInfo.mVideoAdsJumpType).a(xsx.a(this.jdField_a_of_type_AndroidAppActivity));
      localron.i(2);
      nrt.a(null, "CliOper", "", paramBaseArticleInfo.mSubscribeID, "0X8009293", "0X8009293", 0, 0, Long.toString(paramBaseArticleInfo.mFeedId), Long.toString(paramBaseArticleInfo.mArticleID), Integer.toString(paramBaseArticleInfo.mStrategyId), localron.a().a(), false);
      nrt.a("0X8009293", paramBaseArticleInfo.mSubscribeID, Long.toString(paramBaseArticleInfo.mFeedId), Long.toString(paramBaseArticleInfo.mArticleID), Integer.toString(paramBaseArticleInfo.mStrategyId), ors.a(paramBaseArticleInfo.mAlgorithmID, ors.a(paramBaseArticleInfo), i3, i1, i2, bdin.h(this.jdField_a_of_type_AndroidAppActivity), str1, paramBaseArticleInfo.mStrCircleId, paramBaseArticleInfo.innerUniqueID, ors.f(paramBaseArticleInfo), 409409, (ArticleInfo)paramBaseArticleInfo));
      return;
      i1 = 0;
      break;
      label529:
      i2 = 1;
      break label40;
      label535:
      if ((i3 == 56) && (this.jdField_a_of_type_Rjg != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Rjg.a())))
      {
        paramrjk.jdField_m_of_type_JavaLangString = this.jdField_a_of_type_Rjg.a();
        localron.c(paramrjk.jdField_m_of_type_JavaLangString);
      }
    }
    label586:
    localron.a(paramBaseArticleInfo).O((int)this.jdField_c_of_type_Long).c(paramBaseArticleInfo).a(paramBaseArticleInfo, true).d(paramBaseArticleInfo).f(paramBaseArticleInfo);
    if ((ors.l(paramBaseArticleInfo)) && (paramBaseArticleInfo.mPolymericInfo != null)) {
      localron.x(paramBaseArticleInfo.mPolymericInfo.jdField_f_of_type_Int + 1);
    }
    String str2 = szp.b(this.jdField_c_of_type_Int);
    nrt.a(null, "CliOper", "", paramBaseArticleInfo.mSubscribeID, str2, str2, 0, 0, Long.toString(paramBaseArticleInfo.mFeedId), Long.toString(paramBaseArticleInfo.mArticleID), Integer.toString(paramBaseArticleInfo.mStrategyId), a(localron.a().a(), paramrjk.jdField_a_of_type_JavaUtilMap), false);
    nrt.a(str2, paramBaseArticleInfo.mSubscribeID, Long.toString(paramBaseArticleInfo.mFeedId), Long.toString(paramBaseArticleInfo.mArticleID), Integer.toString(paramBaseArticleInfo.mStrategyId), ors.a(paramBaseArticleInfo.mAlgorithmID, ors.a(paramBaseArticleInfo), i3, i1, i2, bdin.h(this.jdField_a_of_type_AndroidAppActivity), str1, paramBaseArticleInfo.mStrCircleId, paramBaseArticleInfo.innerUniqueID, ors.f(paramBaseArticleInfo), 409409, (ArticleInfo)paramBaseArticleInfo));
  }
  
  public void b(rpx paramrpx)
  {
    this.jdField_b_of_type_JavaUtilArrayList.add(paramrpx);
  }
  
  public void b(boolean paramBoolean, BaseArticleInfo paramBaseArticleInfo)
  {
    ron localron;
    if ((paramBaseArticleInfo.isAccountShown) && (this.jdField_c_of_type_Int == 0) && (!TextUtils.isEmpty(paramBaseArticleInfo.mArticleContentUrl)))
    {
      ors.d(a(), paramBaseArticleInfo.mArticleContentUrl);
      localron = new ron(null, null, paramBaseArticleInfo.mVideoVid, paramBaseArticleInfo.innerUniqueID);
      if (!paramBoolean) {
        break label144;
      }
    }
    label144:
    for (int i1 = 0;; i1 = 1)
    {
      nrt.a(null, "", "0X8007625", "0X8007625", 0, 0, "", "", "", localron.x(i1).a(this.jdField_c_of_type_Int).a(paramBaseArticleInfo.videoReportInfo).a(paramBaseArticleInfo).O((int)this.jdField_c_of_type_Long).W(ors.a(paramBaseArticleInfo)).e(paramBaseArticleInfo).R(6).f(paramBaseArticleInfo).a().a(), false);
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
  
  public void c(rpx paramrpx)
  {
    this.jdField_b_of_type_JavaUtilArrayList.remove(paramrpx);
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
    if (this.jdField_a_of_type_Rjg != null) {
      this.jdField_a_of_type_Rjg.a(new rqm(this));
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ReadInJoyBaseAdapter", 2, "mVideoPlayManager == null");
  }
  
  public void f()
  {
    if ((this.jdField_a_of_type_Rjg != null) && (this.jdField_a_of_type_Rjg.a() != null)) {}
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
          if ((!ors.a(((BaseArticleInfo)localObject).mArticleContentUrl, ((BaseArticleInfo)localObject).mChannelID, (ArticleInfo)localObject)) && (!ors.a((BaseArticleInfo)localObject)) && (!a(i3, ((BaseArticleInfo)localObject).mArticleID)))
          {
            localObject = ((BaseArticleInfo)localObject).mArticleContentUrl;
            if (zez.a((String)localObject)) {
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
    biby.a("ReadInJoyBaseAdapter.getView");
    System.currentTimeMillis();
    a(b(paramInt), paramInt);
    BaseArticleInfo localBaseArticleInfo = b(paramInt);
    int i1 = getItemViewType(paramInt);
    pgq localpgq = a((ArticleInfo)localBaseArticleInfo, i1, paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyBaseAdapter", 2, "getView: " + localBaseArticleInfo + " type= " + i1);
    }
    paramViewGroup = (View)pdh.a(this.jdField_a_of_type_AndroidUtilSparseArray, new rrg(this, "onAdapterGetView", i1, localBaseArticleInfo, paramInt, paramView, paramViewGroup));
    if (paramViewGroup != null)
    {
      a(localBaseArticleInfo, localpgq, System.currentTimeMillis(), paramInt);
      paramViewGroup = super.a(paramViewGroup, paramInt);
      TextHook.updateFont(paramView);
      biby.a();
      return paramViewGroup;
    }
    if ((a() instanceof ReadInJoyChannelActivity)) {
      if ((this.jdField_d_of_type_Boolean) && (paramView != null) && (paramInt > 0) && (paramInt <= 2))
      {
        if ((paramInt != 1) || (!this.jdField_e_of_type_Boolean)) {
          break label288;
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
      label288:
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
    return jdField_a_of_type_Ppz.a() + 140 + pvq.a();
  }
  
  public void h()
  {
    if ((!bkbq.A(a())) || (!bkbq.B(a()))) {
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
        if (!ors.a((BaseArticleInfo)localObject)) {
          localArrayList.add((ArticleInfo)localObject);
        }
      }
      i1 += 1;
    }
    owy.a().a().a(localArrayList);
  }
  
  public void i()
  {
    this.jdField_f_of_type_Boolean = true;
    if ((this.jdField_a_of_type_Rjg != null) && ((c()) || (this.jdField_a_of_type_Qzy.a())) && (!this.jdField_a_of_type_Qzy.b()) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getVisibility() == 0))
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
    if (this.jdField_a_of_type_Qzp != null) {
      this.jdField_a_of_type_Qzp.a();
    }
    if (this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video_" + this.jdField_c_of_type_Int, 2, "ReadInJoyBaseAdapter doOnResume()");
      }
      if (bkbq.k()) {
        r();
      }
      this.p = true;
      this.jdField_a_of_type_Boolean = true;
      c();
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new ReadInJoyBaseAdapter.33(this), 1000L);
      if (Build.VERSION.SDK_INT < 21) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setFriction(jdField_a_of_type_Float);
      }
      this.jdField_a_of_type_Svj.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, 4);
      this.jdField_i_of_type_Boolean = false;
      this.jdField_h_of_type_Boolean = false;
      int i1 = 0;
      while (i1 < this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildCount())
      {
        localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(i1);
        if (((localObject instanceof rpv)) && (!((rpv)localObject).a()))
        {
          ((rpv)localObject).setIsResume(true);
          ((rpv)localObject).a();
        }
        i1 += 1;
      }
      i1 = 0;
      while (i1 < this.jdField_b_of_type_JavaUtilArrayList.size())
      {
        ((rpx)this.jdField_b_of_type_JavaUtilArrayList.get(i1)).a();
        i1 += 1;
      }
      if (this.jdField_a_of_type_Rpx != null) {
        this.jdField_a_of_type_Rpx.a();
      }
      Object localObject = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      if ((pid.a() == 2) && (pid.b(a(), (String)localObject) > 0))
      {
        localObject = (SensorManager)a().getSystemService("sensor");
        amck localamck = this.jdField_a_of_type_Amck;
        Sensor localSensor = ((SensorManager)localObject).getDefaultSensor(1);
        i1 = i2;
        if (azsd.a().a()) {
          i1 = 2;
        }
        ((SensorManager)localObject).registerListener(localamck, localSensor, i1);
      }
    } while (!ProteusParserWithHotReload.getInstance().isSupportHotReload());
    ProteusParserWithHotReload.getInstance().addHotReloadChangedObserver(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewParseProteusParserWithHotReload$IHotReloadChangedObserver);
  }
  
  public void k()
  {
    int i3 = 0;
    if (this.jdField_a_of_type_Qzp != null) {
      this.jdField_a_of_type_Qzp.b();
    }
    if (!this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video_" + this.jdField_c_of_type_Int, 2, "ReadInJoyBaseAdapter doOnPause()");
      }
      this.jdField_a_of_type_Boolean = false;
      if ((this.jdField_a_of_type_Bhxx != null) && (this.jdField_a_of_type_Bhxx.isShowing())) {
        this.jdField_a_of_type_Bhxx.dismiss();
      }
      this.jdField_l_of_type_Int = bdin.b(this.jdField_a_of_type_AndroidAppActivity);
      this.jdField_a_of_type_Svj.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, 5);
      w();
      if ((!bkbq.p()) && (opy.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, "default_feeds")))
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
        if (((localView instanceof rpv)) && (((rpv)localView).a()))
        {
          ((rpv)localView).setIsResume(false);
          ((rpv)localView).b();
        }
        i1 += 1;
      }
      while (i2 < this.jdField_b_of_type_JavaUtilArrayList.size())
      {
        ((rpx)this.jdField_b_of_type_JavaUtilArrayList.get(i2)).b();
        i2 += 1;
      }
      if (this.jdField_a_of_type_Rpx != null) {
        this.jdField_a_of_type_Rpx.b();
      }
      ((SensorManager)a().getSystemService("sensor")).unregisterListener(this.jdField_a_of_type_Amck);
    } while (!ProteusParserWithHotReload.getInstance().isSupportHotReload());
    ProteusParserWithHotReload.getInstance().removeHotReloadChangedObserver(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewParseProteusParserWithHotReload$IHotReloadChangedObserver);
  }
  
  public void l()
  {
    if (this.jdField_a_of_type_Rkw != null) {
      this.jdField_a_of_type_Rkw.l();
    }
  }
  
  public void m()
  {
    this.jdField_a_of_type_Rjg.b(9);
  }
  
  public void n()
  {
    if ((this.jdField_a_of_type_Rjg != null) && (oee.a(this.jdField_c_of_type_Int))) {
      m();
    }
  }
  
  public void notifyDataSetChanged()
  {
    super.notifyDataSetChanged();
    pdh.a(this.jdField_a_of_type_AndroidUtilSparseArray, new rra(this, "onNotifyDataSetChange"));
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "notifyDataSetChanged");
    }
    if (((this.jdField_a_of_type_Pdn != null) || (this.jdField_a_of_type_Rjk != null)) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr != null))
    {
      int i2 = -1;
      int i1 = i2;
      if (this.jdField_a_of_type_Pdn != null)
      {
        i1 = i2;
        if (this.jdField_a_of_type_Pdn.a() != null) {
          i1 = this.jdField_a_of_type_Pdn.a().jdField_a_of_type_Int;
        }
      }
      if (this.jdField_a_of_type_Rjk != null) {
        i1 = this.jdField_a_of_type_Rjk.jdField_a_of_type_Int;
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
    label541:
    label1394:
    label1910:
    do
    {
      Object localObject1;
      do
      {
        for (;;)
        {
          return;
          localObject1 = (pdq)paramView.getTag();
          localObject2 = b(((pdn)localObject1).a());
          if ((this.jdField_a_of_type_Rjg.a() != null) && (this.jdField_a_of_type_Rjg.a().a() != null) && (this.jdField_a_of_type_Rjg.a().a().a()))
          {
            this.jdField_a_of_type_Rjg.a().a().a(5);
            return;
          }
          if (!rdm.a((BaseArticleInfo)localObject2, a()))
          {
            if (AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject2))
            {
              szl.a(this.jdField_a_of_type_AndroidAppActivity, (ArticleInfo)localObject2, this, 56);
              szl.a(this.jdField_a_of_type_AndroidAppActivity, (ArticleInfo)localObject2, this, 56, true, null);
              return;
            }
            if ((rdm.c()) && (!AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject2))) {}
            for (int i1 = 1;; i1 = 0)
            {
              if (((this.jdField_a_of_type_Qzy.a()) || (bkbq.a(a()) <= 0)) && (i1 == 0)) {
                break label541;
              }
              if (localObject2 == null) {
                break;
              }
              if (i1 != 0) {
                nrt.a(null, "", "0X8008E28", "0X8008E28", 0, 0, "", "", "", new ron(null, null, ((BaseArticleInfo)localObject2).mVideoVid, ((BaseArticleInfo)localObject2).innerUniqueID).a((int)((BaseArticleInfo)localObject2).mChannelID).O((int)this.jdField_c_of_type_Long).R(1).a().a(), false);
              }
              a(((pdn)localObject1).a(), (BaseArticleInfo)localObject2, false);
              return;
            }
            this.jdField_a_of_type_Rjg.a().c(paramView);
            oxb.a().d(false);
            return;
            paramView = (articlesummary.ChannelInfo)paramView.getTag();
            if (paramView != null) {
              if ((paramView.bytes_channel_url.has()) && (paramView.bytes_channel_url.get() != null))
              {
                if (!TextUtils.isEmpty(paramView.bytes_channel_url.get().toStringUtf8())) {
                  ors.a(this.jdField_a_of_type_AndroidAppActivity, paramView.bytes_channel_url.get().toStringUtf8());
                }
              }
              else
              {
                nxu.b(this.jdField_a_of_type_AndroidAppActivity, paramView.uint32_channel_id.get(), ors.a(paramView), paramView.uint32_channel_type.get(), 6, null);
                return;
                paramView = (pdq)paramView.getTag();
                localObject1 = b(paramView.jdField_a_of_type_Int);
                if (localObject1 != null)
                {
                  if (!rdm.a((BaseArticleInfo)localObject1, a()))
                  {
                    if (AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject1))
                    {
                      szl.a(this.jdField_a_of_type_AndroidAppActivity, (ArticleInfo)localObject1, this, 56);
                      szl.a(this.jdField_a_of_type_AndroidAppActivity, (ArticleInfo)localObject1, this, 56, true, null);
                      return;
                    }
                    a(paramView.jdField_a_of_type_Rjk, (BaseArticleInfo)localObject1);
                  }
                  ThreadManager.executeOnSubThread(new ReadInJoyBaseAdapter.14(this, (BaseArticleInfo)localObject1));
                  return;
                  paramView = (pdq)paramView.getTag();
                  localObject1 = b(paramView.jdField_a_of_type_Int);
                  if (localObject1 != null)
                  {
                    a(paramView.jdField_a_of_type_Rjk, (BaseArticleInfo)localObject1, true);
                    ThreadManager.executeOnSubThread(new ReadInJoyBaseAdapter.15(this, (BaseArticleInfo)localObject1));
                    return;
                    localObject1 = paramView.getTag();
                    if ((localObject1 instanceof pdr))
                    {
                      ((pdr)localObject1).onClick(paramView);
                      return;
                    }
                    if (ohq.a() == 1) {}
                    for (bool = true;; bool = false)
                    {
                      a(paramView, false, bool);
                      return;
                    }
                    paramView = (pdq)paramView.getTag();
                    localObject1 = b(paramView.jdField_a_of_type_Int);
                    if (localObject1 == null)
                    {
                      if (QLog.isColorLevel()) {
                        QLog.d("ReadInJoyBaseAdapter", 2, "articleInfo == null, ERROR");
                      }
                    }
                    else
                    {
                      if ((this.jdField_a_of_type_Rjg != null) && (this.jdField_a_of_type_Rjg.b()))
                      {
                        this.jdField_a_of_type_Rjg.a();
                        this.jdField_b_of_type_Boolean = true;
                      }
                      this.jdField_a_of_type_Rkd.a(paramView.jdField_f_of_type_AndroidViewView, paramView.jdField_a_of_type_Int);
                      this.jdField_a_of_type_Rkd.a(this);
                      this.jdField_a_of_type_Rkd.a((BaseArticleInfo)localObject1, a(paramView.jdField_a_of_type_Rjk, (BaseArticleInfo)localObject1), this.jdField_a_of_type_Rjg, new rqn(this, (BaseArticleInfo)localObject1), this.jdField_c_of_type_Int);
                      return;
                      a();
                      a();
                      localObject2 = (pdu)paramView.getTag();
                      if (localObject2 != null)
                      {
                        localObject1 = (BaseArticleInfo)this.jdField_b_of_type_JavaUtilList.get(((pdu)localObject2).jdField_a_of_type_Int);
                        try
                        {
                          JSONObject localJSONObject = new JSONObject();
                          localJSONObject.put("time", System.currentTimeMillis() / 1000L);
                          localJSONObject.put("channel_id", this.jdField_c_of_type_Int);
                          if ((this.jdField_a_of_type_AndroidAppActivity instanceof BaseActivity))
                          {
                            localJSONObject.put("folder_status", ors.jdField_d_of_type_Int);
                            localJSONObject.put("kandian_mode", ors.e());
                            localJSONObject.put("feeds_type", "" + ors.a((BaseArticleInfo)localObject1));
                            localJSONObject.put("rowkey", szp.a((BaseArticleInfo)localObject1));
                            nrt.a(null, "", "0X8007058", "0X8007058", 0, 0, "", "", "", localJSONObject.toString(), false);
                          }
                          while (localObject1 != null)
                          {
                            i1 = ((pdu)localObject2).jdField_a_of_type_Int;
                            localObject2 = new rqo(this, i1, (pdu)localObject2, (BaseArticleInfo)localObject1);
                            if (!AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject1)) {
                              break label1394;
                            }
                            if ((this.jdField_a_of_type_Bhxx != null) && (this.jdField_a_of_type_Bhxx.isShowing())) {
                              this.jdField_a_of_type_Bhxx.dismiss();
                            }
                            this.jdField_a_of_type_Bhyd.a(i1, this.jdField_c_of_type_Int, ors.a((BaseArticleInfo)localObject1), ((AdvertisementInfo)localObject1).mAdDislikeInfos);
                            this.jdField_a_of_type_Bhyd.a(paramView, (bhyb)localObject2);
                            this.jdField_a_of_type_Bhyd.a(new rqq(this, (BaseArticleInfo)localObject1));
                            this.jdField_a_of_type_Bhyd.setOnDismissListener(new rqr(this));
                            if ((this.jdField_a_of_type_Rjg == null) || (!this.jdField_a_of_type_Rjg.b())) {
                              break;
                            }
                            this.jdField_a_of_type_Rjg.a();
                            this.jdField_b_of_type_Boolean = true;
                            return;
                            if ((this.jdField_a_of_type_AndroidAppActivity instanceof PluginBaseActivity))
                            {
                              localJSONObject.put("folder_status", 1);
                              azqs.b(null, "CliOper", "", "", "0X800705F", "0X800705F", 0, 0, "", "", "", localJSONObject.toString());
                            }
                          }
                        }
                        catch (JSONException localJSONException)
                        {
                          for (;;)
                          {
                            localJSONException.printStackTrace();
                            continue;
                            if ((this.jdField_a_of_type_Bhyd != null) && (this.jdField_a_of_type_Bhyd.isShowing())) {
                              this.jdField_a_of_type_Bhyd.dismiss();
                            }
                            this.jdField_a_of_type_Bhxx.a(i1, this.jdField_c_of_type_Int, ors.a((BaseArticleInfo)localObject1), ((BaseArticleInfo)localObject1).mDislikeInfos, ((BaseArticleInfo)localObject1).innerUniqueID);
                            this.jdField_a_of_type_Bhxx.a(paramView, (bhyb)localObject2);
                            this.jdField_a_of_type_Bhxx.setOnDismissListener(new rqt(this));
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
          if (this.jdField_a_of_type_Rjg != null) {
            break label1710;
          }
          l1 = 0L;
          localObject3 = new ron(null, paramView, (String)localObject1, (String)localObject3, l1, ((BaseArticleInfo)localObject2).mVideoDuration * 1000).a(this.jdField_c_of_type_Int).a().a();
          if (TextUtils.isEmpty(((BaseArticleInfo)localObject2).innerUniqueID)) {
            break label1722;
          }
        }
        for (localObject1 = String.valueOf(((BaseArticleInfo)localObject2).innerUniqueID);; localObject1 = "0")
        {
          nrt.a(null, paramView, "0X8007410", "0X8007410", 0, 0, "2", "", (String)localObject1, (String)localObject3, false);
          szl.a(this.jdField_a_of_type_AndroidAppActivity, (ArticleInfo)localObject2, this, 56);
          szl.a(this.jdField_a_of_type_AndroidAppActivity, (ArticleInfo)localObject2, this, 56, true, null);
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
          l1 = this.jdField_a_of_type_Rjg.a();
          break label1552;
        }
        paramView = b(((pdq)paramView.getTag()).jdField_a_of_type_Int);
        szl.a(this.jdField_a_of_type_AndroidAppActivity, (ArticleInfo)paramView, this, 56);
        szl.a(this.jdField_a_of_type_AndroidAppActivity, (ArticleInfo)paramView, this, 56, true, null);
        return;
        Object localObject4;
        if (paramView.getId() == 2131369373)
        {
          localObject3 = (ArticleInfo)((pdp)paramView.getTag()).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
          localObject1 = ((pdp)paramView.getTag()).jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID;
          localObject2 = localObject3;
          localObject4 = localObject2;
          localObject2 = localObject1;
          if (paramView.getId() != 2131369373) {
            break label1910;
          }
        }
        for (bool = true;; bool = false)
        {
          a(bool, localObject4, (ArticleInfo)localObject3, (String)localObject2);
          return;
          localObject1 = (ArticleInfo)((pdp)paramView.getTag()).jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
          localObject2 = ((pdp)paramView.getTag()).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID;
          localObject3 = (ArticleInfo)((pdp)paramView.getTag()).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
          ((ArticleInfo)localObject1).isTwoItem = true;
          localObject4 = localObject1;
          break;
        }
        if (paramView.getId() == 2131367303) {
          localObject1 = ((pdv)paramView.getTag()).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
        }
        for (localObject2 = ((pdv)paramView.getTag()).jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID;; localObject2 = ((pdv)paramView.getTag()).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID)
        {
          localObject3 = a((BaseArticleInfo)localObject1);
          ((rjk)localObject3).jdField_n_of_type_JavaLangString = ((String)localObject2);
          ((rjk)localObject3).l = ntd.b();
          if ((this.jdField_a_of_type_Rjg != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Rjg.a()))) {
            ((rjk)localObject3).jdField_m_of_type_JavaLangString = this.jdField_a_of_type_Rjg.a();
          }
          localObject2 = new int[2];
          paramView.getLocationOnScreen((int[])localObject2);
          ((rjk)localObject3).jdField_h_of_type_Int = localObject2[0];
          ((rjk)localObject3).jdField_i_of_type_Int = localObject2[1];
          ((rjk)localObject3).jdField_j_of_type_Int = paramView.getWidth();
          ((rjk)localObject3).jdField_k_of_type_Int = paramView.getHeight();
          if (!((BaseArticleInfo)localObject1).isVideoItemForCommonUrlJump()) {
            break;
          }
          ors.d(this.jdField_a_of_type_AndroidAppActivity, ((BaseArticleInfo)localObject1).mVideoAdsJumpUrl);
          b((rjk)localObject3, (BaseArticleInfo)localObject1);
          return;
          localObject1 = ((pdv)paramView.getTag()).jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
        }
        if (((BaseArticleInfo)localObject1).isVideoItemForWeishiJump())
        {
          if (xsx.a(this.jdField_a_of_type_AndroidAppActivity)) {
            tam.a(this.jdField_a_of_type_AndroidAppActivity, "video_type_videopublic");
          }
          for (;;)
          {
            b((rjk)localObject3, (BaseArticleInfo)localObject1);
            return;
            QQToast.a(this.jdField_a_of_type_AndroidAppActivity, -1, 2131718879, 0).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131298914));
            tam.b(this.jdField_a_of_type_AndroidAppActivity, "video_type_videopublic");
          }
        }
        a((rjk)localObject3, (BaseArticleInfo)localObject1);
        return;
        localObject1 = (BaseArticleInfo)paramView.getTag();
      } while (localObject1 == null);
      if (paramView.getId() == 2131369373) {}
      for (boolean bool = true;; bool = false)
      {
        b(bool, (BaseArticleInfo)localObject1);
        return;
      }
      paramView = (BaseArticleInfo)paramView.getTag();
    } while (paramView == null);
    label1552:
    label1710:
    label1722:
    b(paramView);
  }
  
  public boolean onLongClick(View paramView)
  {
    boolean bool = false;
    switch (paramView.getId())
    {
    default: 
      return false;
    }
    if (ohq.b() == 1) {
      bool = true;
    }
    a(paramView, true, bool);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rqj
 * JD-Core Version:    0.7.0.1
 */