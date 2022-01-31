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
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.parse.ProteusParserWithHotReload;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.parse.ProteusParserWithHotReload.IHotReloadChangedObserver;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.biz.pubaccount.util.PreloadManager;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionPreloadManager;
import com.tencent.common.app.BaseApplicationImpl;
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

public abstract class qoe
  extends woq
  implements View.OnClickListener, View.OnLongClickListener, qil, qjd, qnr
{
  public static float a;
  public static int a;
  private static oxy jdField_a_of_type_Oxy;
  public static int b;
  public static int f;
  static final int g;
  static final int h;
  private static int j;
  private static int jdField_k_of_type_Int;
  public long a;
  private ajrw jdField_a_of_type_Ajrw = new qoz(this);
  public Activity a;
  protected Drawable a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private SparseArray<oml> jdField_a_of_type_AndroidUtilSparseArray;
  protected LayoutInflater a;
  private AnimationSet jdField_a_of_type_AndroidViewAnimationAnimationSet;
  public begh a;
  private beki jdField_a_of_type_Beki;
  private beko jdField_a_of_type_Beko;
  protected VideoPreDownloadMgr a;
  public ReadInJoyXListView a;
  private VafContext jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext = new pcw();
  private ProteusParserWithHotReload.IHotReloadChangedObserver jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewParseProteusParserWithHotReload$IHotReloadChangedObserver = new qpa(this);
  public INetInfoHandler a;
  private Runnable jdField_a_of_type_JavaLangRunnable = new ReadInJoyBaseAdapter.21(this);
  public ArrayList<pov> a;
  public HashSet<String> a;
  protected List<Object> a;
  public Map<Long, pov> a;
  protected Set<Long> a;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new MqqHandler();
  private naw jdField_a_of_type_Naw;
  private noy jdField_a_of_type_Noy;
  public omw a;
  protected pyl a;
  private pyu jdField_a_of_type_Pyu;
  public qhp a;
  public qht a;
  protected qik a;
  private qim jdField_a_of_type_Qim;
  private qjd jdField_a_of_type_Qjd;
  private qnt jdField_a_of_type_Qnt;
  protected qpg a;
  protected qph a;
  protected qpi a;
  protected qpj a;
  private qpk jdField_a_of_type_Qpk;
  public qpo a;
  qvt jdField_a_of_type_Qvt = new qvt();
  private rfw jdField_a_of_type_Rfw;
  rrb jdField_a_of_type_Rrb = new qow(this);
  private rrd jdField_a_of_type_Rrd;
  public yjs a;
  public boolean a;
  public long b;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private AnimationSet jdField_b_of_type_AndroidViewAnimationAnimationSet;
  private begh jdField_b_of_type_Begh = new qoq(this);
  public HashSet<String> b;
  public List<BaseArticleInfo> b;
  protected Set<Long> b;
  public boolean b;
  public int c;
  private long jdField_c_of_type_Long = -1L;
  private begh jdField_c_of_type_Begh = new qor(this);
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
    jdField_a_of_type_Oxy = new oxy();
    jdField_g_of_type_Int = Color.parseColor("#999999");
    jdField_h_of_type_Int = Color.parseColor("#262626");
  }
  
  public qoe(Activity paramActivity, LayoutInflater paramLayoutInflater, int paramInt, ListView paramListView, SparseArray<oml> paramSparseArray)
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
    this.jdField_a_of_type_Begh = new qop(this);
    this.jdField_a_of_type_Qpo = new qos(this);
    this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new qot(this);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidViewLayoutInflater = paramLayoutInflater;
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.setContext(paramActivity);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.setCurActivity(paramActivity);
    this.jdField_e_of_type_Int = obz.d();
    oag.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, "default_feeds");
    jdField_a_of_type_Oxy.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView = ((ReadInJoyXListView)paramListView);
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    a(paramSparseArray);
    this.jdField_a_of_type_Qim = new qim(paramActivity);
    this.jdField_a_of_type_Rrd = new rrd(paramActivity, true);
    t();
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView instanceof ReadInJoyXListView)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setOnDrawCompleteListener(this.jdField_a_of_type_Qpo);
    }
    this.jdField_a_of_type_AndroidOsHandler = new qof(this, Looper.getMainLooper());
    q();
    p();
  }
  
  public static int a(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo == null) || (paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pre == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyBaseAdapter", 2, "ugc feeds info is null");
      }
      return 21;
    }
    switch (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pre.jdField_a_of_type_Int)
    {
    case 1: 
    default: 
      return 21;
    case 2: 
    case 3: 
      if ((paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int == 9) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pre.jdField_a_of_type_JavaUtilArrayList.size() > 1)) {
        return 36;
      }
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqr != null) {
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
    oxy localoxy = jdField_a_of_type_Oxy;
    if (oxy.a(paramArticleInfo)) {
      return jdField_a_of_type_Oxy.a(paramArticleInfo);
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
      paramInt = obz.a(paramArticleInfo, false);
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
        paramInt = obz.b(paramArticleInfo);
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
        paramInt = och.a(paramArticleInfo);
        if ((paramInt == 21) || (paramInt == 22))
        {
          paramInt = obz.a(paramArticleInfo, true);
        }
        else if (paramInt == 11)
        {
          paramInt = 33;
        }
        else if (obz.g(paramArticleInfo))
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
          if (!obz.h(paramArticleInfo)) {
            break;
          }
          switch (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pre.jdField_a_of_type_Int)
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
    if (obz.d(paramArticleInfo)) {
      if ((paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqz == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqz.jdField_a_of_type_JavaUtilArrayList == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqz.jdField_a_of_type_JavaUtilArrayList.size() <= 0)) {
        break label2471;
      }
    }
    label2471:
    for (paramInt = ComponentContentGridImage.a(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqz.jdField_a_of_type_JavaUtilArrayList.size(), paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int);; paramInt = 0)
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
        if ((paramInt == 27) && (paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Prd != null))
        {
          if (!TextUtils.isEmpty(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Prd.jdField_c_of_type_JavaLangString))
          {
            paramInt = 94;
            break;
          }
          paramInt = 95;
          break;
        }
        if ((paramInt == 32) && (paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqq != null))
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
        if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pre.jdField_a_of_type_Int == 1)
        {
          if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pre.c.size() > 0)
          {
            paramInt = 108;
            break;
          }
          paramInt = 24;
          break;
        }
        if ((paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pre.jdField_a_of_type_Int == 3) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pre.jdField_a_of_type_Int == 2))
        {
          if ((paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int == 9) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pre.jdField_a_of_type_JavaUtilArrayList.size() > 1))
          {
            paramInt = 37;
            break;
          }
          if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqr != null)
          {
            paramInt = 81;
            break;
          }
          paramInt = 25;
          break;
        }
        paramInt = 26;
        break;
        label1075:
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
          case 1: 
          case 4: 
          case 7: 
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
        if ((obz.b(paramArticleInfo)) || (obz.c(paramArticleInfo)))
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
          if ((obz.e(paramArticleInfo)) || (obz.f(paramArticleInfo)))
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
          if ((paramArticleInfo.mChannelID == 0L) && (paramArticleInfo.mSimpleVideoColumnInfo != null) && (obz.a(paramArticleInfo)))
          {
            paramInt = 128;
            break;
          }
          if ((paramArticleInfo.mChannelID == 0L) && (paramArticleInfo.mVideoColumnInfo != null) && (obz.a(paramArticleInfo)))
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
          if ((obz.a(paramArticleInfo)) && (paramArticleInfo.mPictures != null) && (paramArticleInfo.mPictures.length >= 3) && (paramArticleInfo.mChannelID == 0L))
          {
            paramInt = 14;
            break;
          }
          if (obz.a(paramArticleInfo))
          {
            if (paramArticleInfo.mVideoType == 0)
            {
              if (obz.a())
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
                if (qcn.b() == 0)
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
              if (qcn.b() == 0)
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
          if (obz.b(paramArticleInfo))
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
                paramInt = npj.b((AdvertisementInfo)paramArticleInfo);
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
          if ((AdvertisementInfo.isAdvertisementInfo(paramArticleInfo)) && (npj.h((AdvertisementInfo)paramArticleInfo))) {
            return 116;
          }
          if ((AdvertisementInfo.isAdvertisementInfo(paramArticleInfo)) && (npj.i((AdvertisementInfo)paramArticleInfo))) {
            return 39;
          }
          if ((AdvertisementInfo.isAdvertisementInfo(paramArticleInfo)) && (npj.j((AdvertisementInfo)paramArticleInfo))) {
            return 117;
          }
          if (obz.i(paramArticleInfo))
          {
            if (obz.j(paramArticleInfo)) {
              return 91;
            }
            return 90;
          }
          if ((AdvertisementInfo.isAdvertisementInfo(paramArticleInfo)) && (npj.k((AdvertisementInfo)paramArticleInfo))) {
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
          if ((AdvertisementInfo.isAdvertisementInfo(paramArticleInfo)) && (npj.l((AdvertisementInfo)paramArticleInfo)))
          {
            paramInt = 122;
            break;
          }
          if (paramArticleInfo.mIsGallery == 0)
          {
            if (AdvertisementInfo.isAdvertisementInfo(paramArticleInfo))
            {
              if (nbe.a(paramArticleInfo))
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
  
  public static int a(ListView paramListView, qht paramqht)
  {
    if (paramqht != null)
    {
      paramqht = paramListView.getChildAt(paramqht.jdField_a_of_type_Int + paramListView.getHeaderViewsCount() - paramListView.getFirstVisiblePosition());
      if (paramqht != null) {
        return paramqht.getBottom() - aciy.a(175.0F, paramListView.getResources());
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
  
  private Bundle a(qht paramqht, BaseArticleInfo paramBaseArticleInfo)
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
    if (paramqht.jdField_f_of_type_Int == 1)
    {
      localBundle1.putString("VIDEO_PUB_ACCOUNT_UIN", paramBaseArticleInfo.mSubscribeID);
      localBundle1.putString("VIDEO_PUB_ACCOUNT_NAME", paramBaseArticleInfo.mSubscribeName);
      if (paramqht.jdField_f_of_type_Int != 6) {
        break label1270;
      }
      localBundle1.putString("VIDEO_H5_URL", ((prg)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pre.jdField_b_of_type_JavaUtilArrayList.get(0)).h);
      localBundle1.putString("VIDEO_CREATE_TIME", oby.a(((prg)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pre.jdField_b_of_type_JavaUtilArrayList.get(0)).jdField_e_of_type_Int, true));
      localBundle1.putString("VIDEO_TIME", String.valueOf(paramqht.jdField_b_of_type_Int));
      if (paramBaseArticleInfo.mVideoJsonWidth == 0) {
        break label1301;
      }
      localBundle1.putString("VIDEO_WIDTH", String.valueOf(paramBaseArticleInfo.mVideoJsonWidth));
      if (paramBaseArticleInfo.mVideoJsonHeight == 0) {
        break label1344;
      }
      localBundle1.putString("VIDEO_HEIGHT", String.valueOf(paramBaseArticleInfo.mVideoJsonHeight));
      localBundle1.putString("VIDEO_VID", paramqht.jdField_c_of_type_JavaLangString);
      localBundle1.putString("VIDEO_COVER", paramqht.jdField_b_of_type_JavaLangString);
      localBundle1.putLong("VIDEO_XG_FILE_SIZE", paramBaseArticleInfo.mXGFileSize);
      localBundle1.putInt("VIDEO_STRATEGY_ID", paramBaseArticleInfo.mStrategyId);
      localBundle1.putLong("VIDEO_ALGORITHM_ID", paramBaseArticleInfo.mAlgorithmID);
      localBundle1.putString("VIDEO_SECOND_INDEX_INNER_ID", paramqht.jdField_n_of_type_JavaLangString);
      if ((this.jdField_a_of_type_Omw == null) || (this.jdField_a_of_type_Omw.a() == null) || (this.jdField_a_of_type_Qhp == null) || (this.jdField_a_of_type_Omw.a().jdField_c_of_type_Long != paramqht.jdField_c_of_type_Long)) {
        break label1387;
      }
      localBundle1.putLong("VIDEO_PLAY_POSITION", this.jdField_a_of_type_Qhp.a());
      if (paramqht.jdField_f_of_type_Int != 6) {
        break label1399;
      }
      localBundle1.putString("VIDEO_ARTICLE_ID", ((prg)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pre.jdField_b_of_type_JavaUtilArrayList.get(0)).jdField_g_of_type_JavaLangString);
      localBundle1.putLong("VIDEO_FEED_ID", paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqm.jdField_a_of_type_JavaLangLong.longValue());
      localBundle1.putInt("VIDEO_FEED_TYPE", paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqm.b.intValue());
      localBundle1.putString("VIDEO_TITLE", ((prg)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pre.jdField_b_of_type_JavaUtilArrayList.get(0)).jdField_e_of_type_JavaLangString);
      localBundle1.putBoolean("IS_FROM_READINJOY_VIDEO_CHANNEL", bgmq.a(this.jdField_d_of_type_Int));
      if (paramqht.jdField_f_of_type_Int != 1) {
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
      localBundle1.putString("VIDEO_THIRD_ICON", paramqht.jdField_d_of_type_JavaLangString);
      localBundle1.putString("VIDEO_THIRD_NAME", paramqht.jdField_e_of_type_JavaLangString);
      localBundle1.putString("VIDEO_THIRD_ACTION", paramqht.jdField_f_of_type_JavaLangString);
      localBundle1.putString("VIDEO_THIRD_URL", paramqht.jdField_g_of_type_JavaLangString);
      localBundle1.putLong("VIDEO_THRID_URL_EXPIRE_TIME", paramqht.jdField_f_of_type_Long);
      localBundle1.putInt("VIDEO_ARTICLE_BUSITYPE", paramqht.jdField_f_of_type_Int);
      localBundle2 = new Bundle();
      localBundle2.putString("VINFO", paramqht.jdField_c_of_type_JavaLangString);
      localBundle2.putString("TINFO", paramqht.jdField_c_of_type_JavaLangString);
      localBundle2.putInt("PREVIEW_VIDEO_TIME", paramqht.jdField_b_of_type_Int);
      if (this.jdField_a_of_type_Qhp != null) {
        break label1437;
      }
      i1 = 0;
      label663:
      localBundle2.putInt("PREVIEW_START_POSI", qhv.a(i1, paramqht.jdField_b_of_type_Int));
      localBundle2.putInt("PREVIEW_VIDEO_WIDTH", paramqht.jdField_c_of_type_Int);
      localBundle2.putInt("PREVIEW_VIDEO_HEIGHT", paramqht.jdField_d_of_type_Int);
      localBundle2.putInt("FULL_VIDEO_TIME", paramqht.jdField_b_of_type_Int);
      localBundle2.putString("source_puin", paramBaseArticleInfo.mSubscribeID);
      if (paramqht.jdField_f_of_type_Int != 1) {
        break label1449;
      }
      localBundle2.putString("ACCOUNT_UIN", paramBaseArticleInfo.mSubscribeID);
      localBundle2.putString("ACCOUNT_NAME", paramBaseArticleInfo.mSubscribeName);
      label759:
      if ((paramqht.jdField_f_of_type_Int != 6) || (paramBaseArticleInfo.mSocialFeedInfo == null) || (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pre == null) || (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pre.jdField_b_of_type_JavaUtilArrayList == null) || (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pre.jdField_b_of_type_JavaUtilArrayList.size() <= 0)) {
        break label1476;
      }
      localBundle2.putString("compatible_text", ((prg)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pre.jdField_b_of_type_JavaUtilArrayList.get(0)).jdField_e_of_type_JavaLangString + ": " + ((prg)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pre.jdField_b_of_type_JavaUtilArrayList.get(0)).h);
      localBundle2.putInt("req_type", 125);
    }
    for (;;)
    {
      localBundle2.putInt("TYPE", paramqht.jdField_f_of_type_Int);
      localBundle2.putString("ARTICLE_ID", paramBaseArticleInfo.innerUniqueID);
      localBundle2.putInt("layout_item", 5);
      localBundle2.putBoolean("video_url_load", false);
      localBundle2.putString("image_url_remote", paramqht.jdField_b_of_type_JavaLangString);
      localBundle2.putString("detail_url", paramBaseArticleInfo.mArticleContentUrl + "&sourcefrom=0");
      localBundle2.putString("video_url", paramqht.jdField_c_of_type_JavaLangString);
      localBundle2.putString("title", paramBaseArticleInfo.mTitle);
      localBundle2.putString("req_create_time", oby.a(paramBaseArticleInfo.mTime));
      localBundle2.putString("brief_key", paramBaseArticleInfo.mTitle);
      localBundle1.putByteArray("STRUCT_MSG_BYTES", ((StructMsgForGeneralShare)awuw.a(localBundle2)).getBytes());
      localBundle1.putString("VIDEO_SUBS_TEXT", paramBaseArticleInfo.mVideoArticleSubsText);
      localBundle1.putString("VIDEO_SUBS_COLOR", paramBaseArticleInfo.mVideoArticleSubsColor);
      localBundle1.putString("KEY_VIDEO_JSON_LIST", paramBaseArticleInfo.mJsonVideoList);
      return localBundle1;
      if (paramqht.jdField_f_of_type_Int == 6)
      {
        if (a((ArticleInfo)paramBaseArticleInfo)) {
          localBundle1.putString("VIDEO_PUB_ACCOUNT_UIN", "" + paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqo.jdField_a_of_type_Long);
        }
        for (;;)
        {
          localBundle1.putString("VIDEO_PUB_ACCOUNT_NAME", paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pre.jdField_b_of_type_JavaLangString);
          if (q((ArticleInfo)paramBaseArticleInfo)) {
            break;
          }
          localBundle1.putString("VIDEO_URL", ((prg)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pre.jdField_b_of_type_JavaUtilArrayList.get(0)).jdField_b_of_type_JavaLangString);
          break;
          localBundle1.putString("VIDEO_PUB_ACCOUNT_UIN", "" + paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pre.jdField_a_of_type_Long);
        }
      }
      localBundle1.putString("VIDEO_PUB_ACCOUNT_UIN", paramBaseArticleInfo.thirdUin);
      localBundle1.putString("VIDEO_PUB_ACCOUNT_NAME", paramBaseArticleInfo.thirdUinName);
      break;
      label1270:
      localBundle1.putString("VIDEO_H5_URL", paramBaseArticleInfo.mArticleContentUrl);
      localBundle1.putString("VIDEO_CREATE_TIME", oby.a(paramBaseArticleInfo.mTime, true));
      break label111;
      label1301:
      if (paramqht.jdField_f_of_type_Int != 6) {
        break label148;
      }
      localBundle1.putString("VIDEO_WIDTH", String.valueOf(((prg)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pre.jdField_b_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Int));
      break label148;
      label1344:
      if (paramqht.jdField_f_of_type_Int != 6) {
        break label170;
      }
      localBundle1.putString("VIDEO_HEIGHT", String.valueOf(((prg)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pre.jdField_b_of_type_JavaUtilArrayList.get(0)).jdField_b_of_type_Int));
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
      i1 = (int)this.jdField_a_of_type_Qhp.a();
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
  
  private omw a(AbsListView paramAbsListView)
  {
    Object localObject;
    if ((!a()) || (this.jdField_a_of_type_Pyu == null) || (paramAbsListView.getChildCount() <= 0))
    {
      localObject = null;
      return localObject;
    }
    int i1 = 0;
    label27:
    if (i1 < paramAbsListView.getChildCount())
    {
      View localView = paramAbsListView.getChildAt(i1);
      if ((localView.getTag() instanceof omw))
      {
        localObject = (omw)localView.getTag();
        if (!((omw)localObject).a(localView)) {}
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
  
  private oqh a(ArticleInfo paramArticleInfo, int paramInt1, int paramInt2)
  {
    b(paramInt2);
    ArticleInfo localArticleInfo = null;
    if (paramInt2 < getCount() - 1) {
      localArticleInfo = (ArticleInfo)b(paramInt2 + 1);
    }
    return new oqh(this.jdField_a_of_type_AndroidAppActivity, paramArticleInfo, paramInt1, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, paramInt2, this.jdField_c_of_type_Boolean, getCount(), localArticleInfo, this);
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
  
  public static qht a(BaseArticleInfo paramBaseArticleInfo)
  {
    return a(paramBaseArticleInfo, false);
  }
  
  public static qht a(BaseArticleInfo paramBaseArticleInfo, boolean paramBoolean)
  {
    qht localqht = new qht();
    localqht.jdField_c_of_type_JavaLangString = paramBaseArticleInfo.getVideoVid();
    localqht.jdField_c_of_type_Long = paramBaseArticleInfo.mArticleID;
    localqht.jdField_b_of_type_Int = paramBaseArticleInfo.getVideoDuration();
    localqht.jdField_c_of_type_Int = paramBaseArticleInfo.getVideoWidth();
    localqht.jdField_d_of_type_Int = paramBaseArticleInfo.getVideoHeight();
    localqht.jdField_a_of_type_Long = paramBaseArticleInfo.mXGFileSize;
    localqht.jdField_a_of_type_JavaLangString = paramBaseArticleInfo.mTitle;
    Object localObject;
    if (paramBaseArticleInfo.getVideoCoverUrlWithSmartCut(false) == null)
    {
      localObject = null;
      localqht.jdField_b_of_type_JavaLangString = ((String)localObject);
      localqht.jdField_k_of_type_JavaLangString = paramBaseArticleInfo.getSubscribeUin();
      localqht.jdField_g_of_type_Int = paramBaseArticleInfo.mStrategyId;
      localqht.jdField_g_of_type_Long = paramBaseArticleInfo.mAlgorithmID;
      localObject = new pqb();
      ((pqb)localObject).jdField_a_of_type_JavaLangLong = Long.valueOf(paramBaseArticleInfo.mArticleID);
      ((pqb)localObject).jdField_a_of_type_JavaLangString = paramBaseArticleInfo.innerUniqueID;
      ((pqb)localObject).jdField_b_of_type_JavaLangString = paramBaseArticleInfo.getVideoVid();
      ((pqb)localObject).jdField_a_of_type_Int = paramBaseArticleInfo.busiType;
      ((pqb)localObject).jdField_i_of_type_Int = paramBaseArticleInfo.getVideoWidth();
      ((pqb)localObject).jdField_j_of_type_Int = paramBaseArticleInfo.getVideoHeight();
      ((pqb)localObject).s = paramBaseArticleInfo.getVideoDuration();
      ((pqb)localObject).jdField_n_of_type_Int = 0;
      ((pqb)localObject).o = 0;
      ((pqb)localObject).p = 0;
      ((pqb)localObject).jdField_f_of_type_Boolean = false;
      ((pqb)localObject).jdField_g_of_type_Boolean = false;
      ((pqb)localObject).jdField_h_of_type_Boolean = false;
      ((pqb)localObject).jdField_g_of_type_JavaLangString = "";
      localqht.jdField_a_of_type_Pqb = ((pqb)localObject);
      localqht.jdField_d_of_type_JavaLangString = paramBaseArticleInfo.thirdIcon;
      localqht.jdField_e_of_type_JavaLangString = paramBaseArticleInfo.thirdName;
      localqht.jdField_f_of_type_JavaLangString = paramBaseArticleInfo.thirdAction;
      localqht.jdField_f_of_type_Int = paramBaseArticleInfo.busiType;
      localqht.jdField_j_of_type_JavaLangString = paramBaseArticleInfo.getInnerUniqueID();
      localqht.jdField_b_of_type_Long = paramBaseArticleInfo.mChannelID;
      localqht.jdField_g_of_type_JavaLangString = paramBaseArticleInfo.mThirdVideoURL;
      localqht.jdField_f_of_type_Long = paramBaseArticleInfo.mThirdVideoURLExpireTime;
      localqht.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = paramBaseArticleInfo;
      if (!paramBoolean) {
        break label348;
      }
    }
    label348:
    for (int i1 = 3;; i1 = 0)
    {
      localqht.jdField_m_of_type_Int = i1;
      if (c((ArticleInfo)paramBaseArticleInfo) == 4) {
        localqht.jdField_c_of_type_Boolean = true;
      }
      return localqht;
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
    if (!badq.h(this.jdField_a_of_type_AndroidAppActivity)) {
      return;
    }
    ArrayList localArrayList = new ArrayList(this.jdField_b_of_type_JavaUtilList);
    ThreadManager.post(new ReadInJoyBaseAdapter.4(this, this.jdField_d_of_type_Long, localArrayList, paramInt1, paramInt2, l1), 5, null, true);
  }
  
  private void a(SparseArray<oml> paramSparseArray)
  {
    this.jdField_a_of_type_AndroidUtilSparseArray = paramSparseArray;
    int i1 = 0;
    while (i1 < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      ((oml)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i1)).a(this);
      i1 += 1;
    }
  }
  
  private void a(View paramView, boolean paramBoolean1, boolean paramBoolean2)
  {
    BaseArticleInfo localBaseArticleInfo = b(((omz)paramView.getTag()).jdField_a_of_type_Int);
    if (localBaseArticleInfo == null) {
      return;
    }
    if (this.jdField_a_of_type_Qhp.a()) {
      this.jdField_a_of_type_Qhp.a();
    }
    if (this.jdField_a_of_type_Qik != null) {
      this.jdField_a_of_type_Qik.a(1, localBaseArticleInfo, 0L, 0L);
    }
    paramView = new Intent(a(), ReadInJoyDeliverBiuActivity.class);
    paramView.putExtra("arg_article_info", (ArticleInfo)localBaseArticleInfo);
    paramView.putExtra("biu_src", 2);
    paramView.putExtra("arg_from_type", 7);
    paramView.putExtra("fast_biu_type", paramBoolean2);
    a().startActivityForResult(paramView, 2);
    a().overridePendingTransition(0, 0);
    long l2 = 0L;
    paramView = this.jdField_a_of_type_Qhp.a();
    long l1 = l2;
    if (paramView != null)
    {
      l1 = l2;
      if (paramView.jdField_c_of_type_JavaLangString.equals(localBaseArticleInfo.mVideoVid)) {
        l1 = this.jdField_a_of_type_Qhp.a();
      }
    }
    String str1 = new qmv(null, localBaseArticleInfo.mSubscribeID, localBaseArticleInfo.mVideoVid, localBaseArticleInfo.innerUniqueID).a(l1).c(localBaseArticleInfo.mVideoDuration * 1000).e(localBaseArticleInfo.mAlgorithmID).c(localBaseArticleInfo.mStrategyId).a(this.jdField_c_of_type_Int).g(paramBoolean1).h(paramBoolean2).a().a();
    String str2 = localBaseArticleInfo.mSubscribeID;
    if (!TextUtils.isEmpty(localBaseArticleInfo.innerUniqueID))
    {
      paramView = localBaseArticleInfo.innerUniqueID;
      ndn.a(null, str2, "0X8007B89", "0X8007B89", 0, 0, "1", "", paramView, str1, false);
      l2 = a().getIntent().getLongExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", 0L);
      paramView = new pqh();
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
      new.a(localBaseArticleInfo, this.jdField_c_of_type_Int, 25, -1L, paramView);
      return;
      paramView = "0";
      break;
    }
  }
  
  public static void a(ArticleInfo paramArticleInfo, int paramInt)
  {
    String str = rvf.b(paramInt);
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
      if ((paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pre == null)) {
        break label273;
      }
      str1 = Long.toString(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pre.jdField_a_of_type_Long);
      l1 = 0L;
    }
    for (;;)
    {
      label77:
      String str3 = obz.a(paramInt2, paramInt1, null, obz.a(paramArticleInfo), paramArticleInfo.innerUniqueID, obz.c(paramArticleInfo), paramArticleInfo);
      if (rvf.a(paramArticleInfo.mChannelID)) {}
      for (String str2 = "0X8009363";; str2 = "0X8008899")
      {
        ndn.a(null, "CliOper", "", str1, str2, str2, 0, 0, Long.toString(l2), Long.toString(l1), "" + paramArticleInfo.mStrategyId, str3, false);
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
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pre == null) {
        break label376;
      }
      str2 = Long.toString(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pre.jdField_a_of_type_Long);
      l1 = l2;
      str1 = str2;
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pre.jdField_a_of_type_JavaUtilArrayList == null) {
        break label376;
      }
      paramInt = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pre.jdField_a_of_type_JavaUtilArrayList.size();
      l1 = 0L;
      str1 = str2;
    }
    for (;;)
    {
      paramString = obz.a(paramInt, i2, paramString, obz.a(paramArticleInfo), paramArticleInfo.innerUniqueID, paramArticleInfo);
      str2 = obz.a(paramInt, i2, null, obz.a(paramArticleInfo), paramArticleInfo.innerUniqueID, obz.c(paramArticleInfo), paramArticleInfo);
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
        if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqz != null)
        {
          l1 = l2;
          str1 = str2;
          if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqz.jdField_a_of_type_JavaUtilArrayList != null)
          {
            paramInt = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqz.jdField_a_of_type_JavaUtilArrayList.size();
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
    Object localObject = obz.c(paramArticleInfo);
    if (paramArticleInfo.hasChannelInfo()) {
      int i1 = paramArticleInfo.mChannelInfoId;
    }
    if (TextUtils.isEmpty(paramArticleInfo.mArticleFriendLikeText)) {}
    try
    {
      localObject = obz.a(paramArticleInfo.mAlgorithmID, obz.a(paramArticleInfo), paramInt, badq.h(null), (String)localObject, paramArticleInfo.innerUniqueID, obz.e(paramArticleInfo), 0, obz.d(), paramArticleInfo);
      if ((paramMap != null) && (paramMap.entrySet() != null))
      {
        paramMap = paramMap.entrySet().iterator();
        while ((paramMap != null) && (paramMap.hasNext()))
        {
          Map.Entry localEntry = (Map.Entry)paramMap.next();
          ((JSONObject)localObject).put((String)localEntry.getKey(), localEntry.getValue().toString());
          continue;
          ndn.a(null, obz.c(paramArticleInfo), paramString1, paramString2, 0, 0, a(paramArticleInfo.mFeedId), String.valueOf(paramArticleInfo.businessId), Integer.toString(paramArticleInfo.mStrategyId), paramMap, false);
        }
      }
    }
    catch (Exception paramMap)
    {
      aciy.a("ReadInJoyBaseAdapter", "reportClickEvent", new IllegalArgumentException(paramMap));
      paramMap = null;
    }
    for (;;)
    {
      rvj.a(paramArticleInfo, paramInt);
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
    int i1 = bgmq.d();
    boolean bool2 = bgmq.q();
    paramTextView1.setMaxLines(i1);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramTextView1.getLayoutParams();
    float f1;
    boolean bool1;
    if (bool2)
    {
      f1 = 5.0F;
      localLayoutParams.bottomMargin = aciy.a(f1, this.jdField_a_of_type_AndroidAppActivity.getResources());
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
        paramKandianUrlImageView.setOnClickListener(new qog(this, paramBaseArticleInfo.familyCommentInfo.jdField_b_of_type_JavaLangString));
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
    qcn.a(paramTextView2, paramBaseArticleInfo.getCommentCount(), ajjy.a(2131647133), "0");
  }
  
  private void a(KandianUrlImageView paramKandianUrlImageView, ImageView paramImageView, BaseArticleInfo paramBaseArticleInfo, boolean paramBoolean)
  {
    boolean bool;
    URL localURL;
    if ((paramBaseArticleInfo.isUseGif) && (badq.h(this.jdField_a_of_type_AndroidAppActivity)))
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
    obj.a(paramKandianUrlImageView, paramURL, this.jdField_a_of_type_AndroidAppActivity, paramBoolean);
  }
  
  private void a(ReadInJoyHeadImageView paramReadInJoyHeadImageView, BaseArticleInfo paramBaseArticleInfo)
  {
    Object localObject = null;
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = bacm.b();
    }
    if ((obz.w(paramBaseArticleInfo)) || ((paramBaseArticleInfo.busiType == 1) && (!AdvertisementInfo.isAdvertisementInfo(paramBaseArticleInfo))))
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
      paramBaseArticleInfo.setDecodeHandler(azue.a);
      paramReadInJoyHeadImageView.setImageDrawable(paramBaseArticleInfo);
      paramReadInJoyHeadImageView.setVisibility(0);
      return;
    }
  }
  
  private void a(ReadInJoyNickNameTextView paramReadInJoyNickNameTextView, BaseArticleInfo paramBaseArticleInfo, boolean paramBoolean)
  {
    if (obz.w(paramBaseArticleInfo))
    {
      paramReadInJoyNickNameTextView.setNickNameByUin(paramBaseArticleInfo.getSubscribeUin());
      return;
    }
    if (paramBoolean)
    {
      paramReadInJoyNickNameTextView.setText(npj.a(paramBaseArticleInfo));
      return;
    }
    paramReadInJoyNickNameTextView.setText(obj.a(paramBaseArticleInfo.getSubscribeName(), 18));
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
    paramString = obb.jdField_k_of_type_JavaLangString + baaw.encodeToString(String.valueOf(paramString).getBytes(), 2);
    obz.a(a(), paramString);
  }
  
  private void a(omz paramomz)
  {
    if (paramomz == null) {
      return;
    }
    paramomz.jdField_e_of_type_AndroidWidgetImageView.setOnClickListener(this);
    paramomz.i.setOnClickListener(this);
    paramomz.h.setOnClickListener(this);
    paramomz.h.setTag(paramomz);
    paramomz.i.setTag(paramomz);
    paramomz.jdField_e_of_type_AndroidWidgetImageView.setTag(paramomz);
  }
  
  public static void a(omz paramomz, BaseArticleInfo paramBaseArticleInfo)
  {
    qht localqht = a(paramBaseArticleInfo);
    localqht.jdField_a_of_type_AndroidViewView = paramomz.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
    localqht.jdField_a_of_type_Int = paramomz.jdField_a_of_type_Int;
    localqht.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = paramBaseArticleInfo;
    paramomz.jdField_a_of_type_Qht = localqht;
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    oml localoml = a(0);
    if ((localoml instanceof oms)) {
      return ((oms)localoml).a(paramInt2, paramInt1);
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
    float f2 = (float)babp.j();
    return (f1 > 0.0F) && (f1 > f2 * 1.0F);
  }
  
  public static int b(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo == null) || (paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pre == null))
    {
      QLog.d("ReadInJoyBaseAdapter", 1, "getTopicRecommendAndUpdateUGCType ugc feeds info is null. article info is: " + paramArticleInfo);
      return 54;
    }
    switch (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pre.jdField_a_of_type_Int)
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
  
  private Bundle b(qht paramqht, BaseArticleInfo paramBaseArticleInfo)
  {
    Object localObject1 = null;
    Object localObject3;
    Object localObject2;
    if ((obz.n(paramBaseArticleInfo)) && (paramqht != null))
    {
      localObject3 = paramBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject2 = (ppv)((Iterator)localObject3).next();
        if ((((ppv)localObject2).jdField_a_of_type_Ppy == null) || (!TextUtils.equals(paramqht.jdField_c_of_type_JavaLangString, ((ppv)localObject2).jdField_a_of_type_Ppy.jdField_a_of_type_JavaLangString))) {
          break label989;
        }
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = (ppv)paramBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.get(0);
      }
      localObject1 = new Bundle();
      label392:
      boolean bool;
      if (((ppv)localObject2).jdField_a_of_type_Boolean)
      {
        ((Bundle)localObject1).putString("VIDEO_PUB_ACCOUNT_UIN", "" + paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqo.jdField_a_of_type_Long);
        ((Bundle)localObject1).putString("VIDEO_H5_URL", ((ppv)localObject2).jdField_a_of_type_Ppy.jdField_c_of_type_JavaLangString);
        ((Bundle)localObject1).putLong("VIDEO_FEED_ID", ((ppv)localObject2).jdField_c_of_type_Long);
        ((Bundle)localObject1).putInt("VIDEO_FEED_TYPE", ((ppv)localObject2).jdField_b_of_type_Int);
        if (((ppv)localObject2).jdField_a_of_type_Ppy != null) {}
        ((Bundle)localObject1).putString("VIDEO_TIME", String.valueOf(paramqht.jdField_b_of_type_Int));
        ((Bundle)localObject1).putString("VIDEO_WIDTH", String.valueOf(paramqht.jdField_c_of_type_Int));
        ((Bundle)localObject1).putString("VIDEO_HEIGHT", String.valueOf(paramqht.jdField_d_of_type_Int));
        ((Bundle)localObject1).putString("VIDEO_VID", paramqht.jdField_c_of_type_JavaLangString);
        ((Bundle)localObject1).putString("VIDEO_COVER", paramqht.jdField_b_of_type_JavaLangString);
        ((Bundle)localObject1).putLong("VIDEO_XG_FILE_SIZE", paramBaseArticleInfo.mXGFileSize);
        ((Bundle)localObject1).putInt("VIDEO_STRATEGY_ID", paramqht.jdField_g_of_type_Int);
        ((Bundle)localObject1).putLong("VIDEO_ALGORITHM_ID", paramqht.jdField_g_of_type_Long);
        ((Bundle)localObject1).putString("VIDEO_SECOND_INDEX_INNER_ID", paramqht.jdField_n_of_type_JavaLangString);
        if ((this.jdField_a_of_type_Omw == null) || (this.jdField_a_of_type_Omw.a() == null) || (this.jdField_a_of_type_Qhp == null) || (this.jdField_a_of_type_Omw.a().jdField_c_of_type_Long != paramqht.jdField_c_of_type_Long)) {
          break label959;
        }
        ((Bundle)localObject1).putLong("VIDEO_PLAY_POSITION", this.jdField_a_of_type_Qhp.a());
        ((Bundle)localObject1).putString("VIDEO_ARTICLE_ID", ((ppv)localObject2).jdField_g_of_type_JavaLangString);
        ((Bundle)localObject1).putString("VIDEO_TITLE", ((ppv)localObject2).jdField_a_of_type_JavaLangString);
        ((Bundle)localObject1).putBoolean("IS_FROM_READINJOY_VIDEO_CHANNEL", bgmq.a(this.jdField_d_of_type_Int));
        if (paramqht.jdField_f_of_type_Int != 1) {
          break label971;
        }
        bool = true;
        label444:
        ((Bundle)localObject1).putBoolean("VIDEO_IS_FROM_PUBLIC_ACCOUNT", bool);
        ((Bundle)localObject1).putBoolean("isFromKandian", true);
        ((Bundle)localObject1).putLong("channelID", paramBaseArticleInfo.mChannelID);
        ((Bundle)localObject1).putLong("algorithmID", ((ppv)localObject2).jdField_b_of_type_Long);
        ((Bundle)localObject1).putString("innderId", ((ppv)localObject2).jdField_g_of_type_JavaLangString);
        ((Bundle)localObject1).putLong("strategyId", ((ppv)localObject2).jdField_a_of_type_Int);
        ((Bundle)localObject1).putString("VIDEO_THIRD_ICON", paramqht.jdField_d_of_type_JavaLangString);
        ((Bundle)localObject1).putString("VIDEO_THIRD_NAME", paramqht.jdField_e_of_type_JavaLangString);
        ((Bundle)localObject1).putString("VIDEO_THIRD_ACTION", paramqht.jdField_f_of_type_JavaLangString);
        ((Bundle)localObject1).putString("VIDEO_THIRD_URL", paramqht.jdField_g_of_type_JavaLangString);
        ((Bundle)localObject1).putLong("VIDEO_THRID_URL_EXPIRE_TIME", paramqht.jdField_f_of_type_Long);
        ((Bundle)localObject1).putInt("VIDEO_ARTICLE_BUSITYPE", paramqht.jdField_f_of_type_Int);
        localObject3 = new Bundle();
        ((Bundle)localObject3).putString("VINFO", paramqht.jdField_c_of_type_JavaLangString);
        ((Bundle)localObject3).putString("TINFO", paramqht.jdField_c_of_type_JavaLangString);
        ((Bundle)localObject3).putInt("PREVIEW_VIDEO_TIME", paramqht.jdField_b_of_type_Int);
        if (this.jdField_a_of_type_Qhp != null) {
          break label977;
        }
      }
      label959:
      label971:
      label977:
      for (int i1 = 0;; i1 = (int)this.jdField_a_of_type_Qhp.a())
      {
        ((Bundle)localObject3).putInt("PREVIEW_START_POSI", qhv.a(i1, paramqht.jdField_b_of_type_Int));
        ((Bundle)localObject3).putInt("PREVIEW_VIDEO_WIDTH", paramqht.jdField_c_of_type_Int);
        ((Bundle)localObject3).putInt("PREVIEW_VIDEO_HEIGHT", paramqht.jdField_d_of_type_Int);
        ((Bundle)localObject3).putInt("FULL_VIDEO_TIME", paramqht.jdField_b_of_type_Int);
        ((Bundle)localObject3).putString("source_puin", ((ppv)localObject2).jdField_e_of_type_JavaLangString);
        ((Bundle)localObject3).putString("ACCOUNT_UIN", ((ppv)localObject2).jdField_e_of_type_JavaLangString);
        ((Bundle)localObject3).putString("ACCOUNT_NAME", ((ppv)localObject2).jdField_f_of_type_JavaLangString);
        ((Bundle)localObject3).putInt("TYPE", paramqht.jdField_f_of_type_Int);
        ((Bundle)localObject3).putString("ARTICLE_ID", ((ppv)localObject2).jdField_g_of_type_JavaLangString);
        ((Bundle)localObject3).putInt("layout_item", 5);
        ((Bundle)localObject3).putBoolean("video_url_load", false);
        ((Bundle)localObject3).putString("image_url_remote", paramqht.jdField_b_of_type_JavaLangString);
        ((Bundle)localObject3).putString("detail_url", ((ppv)localObject2).jdField_d_of_type_JavaLangString + "&sourcefrom=0");
        ((Bundle)localObject3).putString("video_url", paramqht.jdField_c_of_type_JavaLangString);
        ((Bundle)localObject3).putString("title", ((ppv)localObject2).jdField_a_of_type_JavaLangString);
        ((Bundle)localObject3).putString("req_create_time", oby.a(paramBaseArticleInfo.mTime));
        ((Bundle)localObject3).putString("brief_key", ((ppv)localObject2).jdField_a_of_type_JavaLangString);
        ((Bundle)localObject3).putInt("req_type", 140);
        ((Bundle)localObject1).putByteArray("STRUCT_MSG_BYTES", ((StructMsgForGeneralShare)awuw.a((Bundle)localObject3)).getBytes());
        ((Bundle)localObject1).putString("KEY_VIDEO_JSON_LIST", paramBaseArticleInfo.mJsonVideoList);
        return localObject1;
        ((Bundle)localObject1).putString("VIDEO_PUB_ACCOUNT_UIN", ((ppv)localObject2).jdField_e_of_type_JavaLangString);
        ((Bundle)localObject1).putString("VIDEO_PUB_ACCOUNT_NAME", ((ppv)localObject2).jdField_f_of_type_JavaLangString);
        ((Bundle)localObject1).putString("VIDEO_H5_URL", ((ppv)localObject2).jdField_d_of_type_JavaLangString);
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
      QQAppInterface localQQAppInterface = (QQAppInterface)obz.a();
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
      str1 = obz.c(paramArticleInfo);
      str2 = obz.a(paramArticleInfo.mAlgorithmID, obz.a(paramArticleInfo), paramInt, i1, i2, badq.h(null), str1, paramArticleInfo.mStrCircleId, paramArticleInfo.innerUniqueID, obz.e(paramArticleInfo), paramArticleInfo);
      if ((!a(paramArticleInfo)) && (!i(paramArticleInfo)) && (!j(paramArticleInfo)) && (!k(paramArticleInfo))) {
        break label243;
      }
      if ((paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pre == null)) {
        break label252;
      }
      str1 = Long.toString(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pre.jdField_a_of_type_Long);
    }
    for (;;)
    {
      String str3 = rvf.b(paramInt);
      ndn.a(null, "CliOper", "", str1, str3, str3, 0, 0, Long.toString(paramArticleInfo.mFeedId), Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), str2, false);
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
    omw localomw = a(paramAbsListView);
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 4, "playVideoInArea:" + localomw);
    }
    if (localomw != null)
    {
      paramAbsListView = localomw.a();
      qht localqht = this.jdField_a_of_type_Qhp.a();
      if ((localqht == null) || (localqht.jdField_c_of_type_Long != paramAbsListView.jdField_c_of_type_Long) || (localqht.jdField_b_of_type_Long != this.jdField_c_of_type_Int) || (this.jdField_a_of_type_Qhp.c()) || (this.jdField_a_of_type_Qhp.d()))
      {
        qji.a().b();
        a(localomw);
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video", 2, "checkPlayableArea vid: " + paramAbsListView.jdField_c_of_type_JavaLangString);
        }
      }
    }
    do
    {
      return;
      m();
    } while (this.jdField_a_of_type_Qhp.a() == null);
    this.jdField_a_of_type_Qhp.a().a(paramAbsListView);
  }
  
  private static void b(pov parampov)
  {
    int i1 = 0;
    if (obz.j(parampov.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo)) {
      parampov.jdField_b_of_type_Boolean = true;
    }
    while (parampov.jdField_b_of_type_Boolean) {
      return;
    }
    parampov.jdField_b_of_type_Boolean = true;
    ArrayList localArrayList = new ArrayList();
    ReportInfo localReportInfo = new ReportInfo();
    localReportInfo.mUin = obz.a();
    localReportInfo.mSource = 0;
    localReportInfo.mSourceArticleId = parampov.jdField_a_of_type_JavaLangLong.longValue();
    if (parampov.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null) {
      i1 = (int)parampov.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mChannelID;
    }
    localReportInfo.mChannelId = i1;
    localReportInfo.mAlgorithmId = ((int)parampov.jdField_a_of_type_Long);
    localReportInfo.mStrategyId = parampov.jdField_b_of_type_Int;
    localReportInfo.mOperation = 7;
    localReportInfo.mServerContext = parampov.jdField_a_of_type_ArrayOfByte;
    localReportInfo.mReadTimeLength = -1;
    localReportInfo.mInnerId = parampov.jdField_e_of_type_JavaLangString;
    if ((parampov.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null) && (parampov.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoColumnInfo != null)) {
      localReportInfo.mColumnID = parampov.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_Int;
    }
    if ((parampov.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null) && (parampov.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo != null) && (!obz.l(parampov.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo)))
    {
      pqg localpqg = new pqg();
      localpqg.jdField_a_of_type_Long = parampov.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Long;
      if (parampov.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqo != null) {
        localpqg.jdField_b_of_type_Long = parampov.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqo.jdField_a_of_type_Long;
      }
      localpqg.jdField_a_of_type_Int = parampov.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_b_of_type_Int;
      localpqg.jdField_b_of_type_Int = parampov.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_d_of_type_Int;
      Object localObject = parampov.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_JavaUtilList;
      if ((localObject != null) && (!((List)localObject).isEmpty()))
      {
        localpqg.jdField_a_of_type_JavaUtilList = new ArrayList();
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          pqo localpqo = (pqo)((Iterator)localObject).next();
          if (localpqo != null) {
            localpqg.jdField_a_of_type_JavaUtilList.add(Long.valueOf(localpqo.jdField_a_of_type_Long));
          }
        }
      }
      localReportInfo.mFeedsReportData = localpqg;
    }
    if ((parampov.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null) && (odm.c((int)parampov.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mChannelID)))
    {
      localReportInfo.mSearchTagName = parampov.jdField_f_of_type_JavaLangString;
      oab.a(localReportInfo);
      return;
    }
    localArrayList.add(localReportInfo);
    QLog.d("ReadInJoyBaseAdapter", 2, "report0x64eExposureInfo: article " + localReportInfo.mSourceArticleId + " exposed!");
    ogy.a().a(localArrayList);
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
    return (paramBaseArticleInfo.mFeedType == 1) && (paramBaseArticleInfo.mSocialFeedInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqm != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqm.b != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqm.b.longValue() == 11L);
  }
  
  public static int c(ArticleInfo paramArticleInfo)
  {
    return a(paramArticleInfo, 0);
  }
  
  private boolean c()
  {
    boolean bool2 = false;
    ArticleInfo localArticleInfo = a();
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Qht == null)
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
    if (!bgmq.a(this.jdField_d_of_type_Int)) {}
    String str;
    do
    {
      do
      {
        do
        {
          return false;
        } while (!badq.g(this.jdField_a_of_type_AndroidAppActivity));
        str = obz.a(this.jdField_c_of_type_Long);
      } while (obz.jdField_d_of_type_JavaLangString.equals(str));
      if (obz.jdField_b_of_type_JavaLangString.equals(str)) {
        return true;
      }
    } while (!obz.jdField_c_of_type_JavaLangString.equals(str));
    return pyu.a(this.jdField_a_of_type_AndroidAppActivity);
  }
  
  public static boolean d(ArticleInfo paramArticleInfo)
  {
    if ((!f(paramArticleInfo)) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqm == null)) {
      return false;
    }
    switch (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqm.b.intValue())
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
  
  public static boolean e(ArticleInfo paramArticleInfo)
  {
    return (f(paramArticleInfo)) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqm != null);
  }
  
  public static boolean e(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo.mFeedType != 30) && ((paramBaseArticleInfo.mSocialFeedInfo == null) || (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pre == null) || (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pre.c.isEmpty()));
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
    return (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Prv == null) || (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Prv.jdField_a_of_type_JavaUtilArrayList == null) || (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Prv.jdField_a_of_type_JavaUtilArrayList.isEmpty());
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
    if ((paramArticleInfo == null) || (paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqm == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqm.b == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pre == null)) {
      return false;
    }
    switch (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqm.b.intValue())
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
    if ((paramArticleInfo == null) || (paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqm == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pre == null)) {
      return false;
    }
    switch (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqm.b.intValue())
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static boolean l(ArticleInfo paramArticleInfo)
  {
    return (k(paramArticleInfo)) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pre.jdField_a_of_type_Int == 1);
  }
  
  public static boolean m(ArticleInfo paramArticleInfo)
  {
    return (i(paramArticleInfo)) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pre.jdField_a_of_type_Int == 1);
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
    return (paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pre == null);
  }
  
  private void p()
  {
    if ((a() instanceof ReadInJoyChannelActivity))
    {
      this.jdField_g_of_type_Boolean = a().getIntent().getBooleanExtra("is_need_show_animation_translate", false);
      this.jdField_d_of_type_Boolean = a().getIntent().getBooleanExtra("is_need_show_animation_adapter", false);
    }
    this.jdField_a_of_type_AndroidViewAnimationAnimationSet = ((AnimationSet)AnimationUtils.loadAnimation(this.jdField_a_of_type_AndroidAppActivity, 2130772066));
    if (!qcn.a()) {
      this.jdField_a_of_type_AndroidViewAnimationAnimationSet.setDuration(400L);
    }
    if (this.jdField_c_of_type_Int == 56)
    {
      pyw.a().a(true);
      pyw.a().a(0);
    }
    AppNetConnInfo.registerConnectionChangeReceiver(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
  }
  
  public static boolean p(ArticleInfo paramArticleInfo)
  {
    return (paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pre == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pre.jdField_a_of_type_JavaUtilArrayList.size() == 0);
  }
  
  private void q()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyBaseAdapter", 2, "cpu:" + babp.b() + " mem:" + babp.d() + " fre:" + babp.a());
    }
    int i1 = babp.b();
    long l1 = babp.d();
    if ((i1 >= 4) && (l1 >= 1610612736.0D))
    {
      jdField_j_of_type_Int = 6;
      return;
    }
    jdField_j_of_type_Int = 4;
  }
  
  public static boolean q(ArticleInfo paramArticleInfo)
  {
    return (paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pre == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pre.jdField_b_of_type_JavaUtilArrayList.size() == 0);
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
          a(localArticleInfo, new oqh(this.jdField_a_of_type_AndroidAppActivity, localArticleInfo, getItemViewType(i4), this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, i4, this.jdField_c_of_type_Boolean, getCount(), null, this), System.currentTimeMillis(), i4);
        }
      }
    }
  }
  
  private void s()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyBaseAdapter", 2, "prefetch data");
    }
    if (this.jdField_a_of_type_Qpk != null) {
      this.jdField_a_of_type_Qpk.a();
    }
  }
  
  private void t()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a(this.jdField_a_of_type_Begh);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a(this.jdField_b_of_type_Begh);
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
    if (!badq.h(this.jdField_a_of_type_AndroidAppActivity)) {}
    try
    {
      Object localObject = this.jdField_a_of_type_Qhp.a();
      long l1 = ((qht)localObject).jdField_c_of_type_Long;
      localObject = b(((qht)localObject).jdField_a_of_type_Int);
      if ((localObject != null) && (l1 != ((BaseArticleInfo)localObject).mArticleID))
      {
        this.jdField_a_of_type_Qhp.b(12);
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
    if (this.jdField_a_of_type_Qhp != null) {
      this.jdField_a_of_type_Qhp.b();
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
    if (this.jdField_a_of_type_Qhp != null) {
      l1 = this.jdField_a_of_type_Qhp.a();
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
  
  public azwg a()
  {
    return null;
  }
  
  public beki a()
  {
    if (this.jdField_a_of_type_Beki == null) {
      this.jdField_a_of_type_Beki = new beki(this.jdField_a_of_type_AndroidAppActivity);
    }
    return this.jdField_a_of_type_Beki;
  }
  
  public beko a()
  {
    if (this.jdField_a_of_type_Beko == null) {
      this.jdField_a_of_type_Beko = new beko(this.jdField_a_of_type_AndroidAppActivity);
    }
    return this.jdField_a_of_type_Beko;
  }
  
  public ArticleInfo a()
  {
    long l1 = a().getIntent().getLongExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_SEQ", 0L);
    ArticleInfo localArticleInfo2 = ogy.a().a(0, l1);
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
  
  public naw a()
  {
    return this.jdField_a_of_type_Naw;
  }
  
  public noy a()
  {
    return this.jdField_a_of_type_Noy;
  }
  
  public oml a(int paramInt)
  {
    return (oml)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
  }
  
  public omz a(String paramString)
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
        return (omz)paramString.getTag();
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
  
  public oxy a()
  {
    return jdField_a_of_type_Oxy;
  }
  
  public pyl a()
  {
    return this.jdField_a_of_type_Pyl;
  }
  
  public qhp a()
  {
    return this.jdField_a_of_type_Qhp;
  }
  
  public qpg a()
  {
    return this.jdField_a_of_type_Qpg;
  }
  
  public qph a()
  {
    return this.jdField_a_of_type_Qph;
  }
  
  public qpi a()
  {
    return this.jdField_a_of_type_Qpi;
  }
  
  public qpj a()
  {
    return this.jdField_a_of_type_Qpj;
  }
  
  public rfw a()
  {
    if (this.jdField_a_of_type_Rfw == null) {
      this.jdField_a_of_type_Rfw = new rfw(this.jdField_a_of_type_AndroidAppActivity, this);
    }
    return this.jdField_a_of_type_Rfw;
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
    this.jdField_a_of_type_Beki = null;
    this.jdField_a_of_type_Beko = null;
    if (this.jdField_c_of_type_Int == 56) {
      pyw.a().a();
    }
    if (this.jdField_a_of_type_Qim != null) {
      this.jdField_a_of_type_Qim.a();
    }
    if (this.jdField_a_of_type_Rrd != null) {
      this.jdField_a_of_type_Rrd.a();
    }
    this.jdField_a_of_type_Rrd = null;
    nsd.b();
    if (this.jdField_a_of_type_Pyl != null) {
      this.jdField_a_of_type_Pyl.c();
    }
  }
  
  public void a(int paramInt)
  {
    a(paramInt, true);
  }
  
  public void a(int paramInt, Intent paramIntent)
  {
    if (this.jdField_a_of_type_Qhp == null) {}
    long l1;
    int i1;
    qht localqht;
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
        if ((!this.jdField_a_of_type_Qhp.c()) || (!this.jdField_a_of_type_Qhp.b())) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("Q.readinjoy.video", 2, "onActivityResult video is pause  && isPausedByMannul, just return");
      return;
      localqht = this.jdField_a_of_type_Qhp.a();
      if (localqht != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.readinjoy.video", 2, "onActivityResult getCurrentPlayVideoParam = null, just return");
    return;
    if (qbq.a().a())
    {
      this.jdField_a_of_type_Qhp.b(4);
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
    if (!TextUtils.equals(localqht.jdField_j_of_type_JavaLangString, (CharSequence)localObject1))
    {
      paramIntent = b((String)localObject1);
      if (paramIntent == null)
      {
        l1 = localqht.jdField_d_of_type_Long;
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
          QLog.d("Q.readinjoy.video", 2, "onActivityResult shouldContinuePlay = " + bool + ", playState=" + qhv.a(i1) + ", startPosition=" + l1 + "，curPlayParam=" + localqht);
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
        qji.a().a(false, "readinoy video continuePlay", 1);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.readinjoy.video", 2, "volumeControl set mute shouldContinuePlay");
        return;
        if (paramIntent.jdField_a_of_type_Qht != null) {
          paramIntent.jdField_a_of_type_Qht.jdField_d_of_type_Long = l1;
        }
        paramInt = 1;
        break label255;
        bool = false;
        break label272;
        label460:
        if ((l1 >= 0L) && (localqht != null))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.readinjoy.video", 2, "onActivityResult resume with position:" + l1);
          }
          this.jdField_a_of_type_Qhp.a((int)l1, localqht);
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.readinjoy.video", 2, "onActivityResult resume");
          }
          this.jdField_a_of_type_Qhp.f(true);
        }
      }
      label548:
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "onActivityResult stop");
      }
      if (this.jdField_a_of_type_Omw == null) {
        break;
      }
      long l2 = this.jdField_a_of_type_Qhp.a();
      this.jdField_a_of_type_Qhp.b(4);
      paramIntent = this.jdField_a_of_type_Omw.a();
      if (l1 > 0L) {
        l2 = l1;
      }
      paramIntent.jdField_d_of_type_Long = l2;
      if (l1 > 0L) {
        this.jdField_a_of_type_Omw.a().jdField_e_of_type_Int = -1;
      }
      this.jdField_a_of_type_Omw = null;
      return;
      this.p = true;
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "onActivityResult for REFRESH_EVENT_CHECK_PLAYAREA");
      }
      v();
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, 50);
      QLog.d("gifvideo.ReadInJoyBaseAdapter", 2, "check shortcontent play");
      omf.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView);
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
    int i1 = 2131633875;
    if (AdvertisementInfo.isAdvertisementInfo(localBaseArticleInfo)) {
      i1 = 2131633876;
    }
    if ((this.jdField_a_of_type_AndroidAppActivity instanceof BaseActivity)) {
      bbmy.a(this.jdField_a_of_type_AndroidAppActivity, -1, this.jdField_a_of_type_AndroidAppActivity.getString(i1), 0).b(((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).getTitleBarHeight());
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
        ogy.a().a(this.jdField_a_of_type_AndroidAppActivity, (AdvertisementInfo)localBaseArticleInfo, l1, paramArrayList1, paramBoolean);
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
          paramArrayList.put("folder_status", obz.jdField_d_of_type_Int);
          paramArrayList.put("kandian_mode", obz.e());
          if (localBaseArticleInfo != null)
          {
            paramArrayList.put("feeds_type", "" + obz.a(localBaseArticleInfo));
            paramArrayList.put("rowkey", rvf.a(localBaseArticleInfo));
          }
          paramArrayList = paramArrayList.toString();
          ndn.a(null, "", "0X8007059", "0X8007059", 0, 0, "", "", obz.a(paramArrayList1), paramArrayList, false);
        }
        label387:
        while (!(this.jdField_a_of_type_AndroidAppActivity instanceof PluginBaseActivity))
        {
          return;
          if (!(this.jdField_a_of_type_AndroidAppActivity instanceof PluginBaseActivity)) {
            break;
          }
          bbmy.a(this.jdField_a_of_type_AndroidAppActivity, -1, this.jdField_a_of_type_AndroidAppActivity.getString(i1), 0).b(((PluginBaseActivity)this.jdField_a_of_type_AndroidAppActivity).g());
          break;
          paramInt = 0;
          break label213;
        }
        paramArrayList.put("folder_status", 1);
        awqx.b(null, "CliOper", "", "", "0X8007060", "0X8007060", 0, 0, "", "", "", paramArrayList.toString());
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
      Object localObject = paramView.getTag(2131303150);
      if ((localObject != null) && ((localObject instanceof Animation)))
      {
        localObject = (Animation)paramView.getTag(2131303150);
        ((Animation)localObject).setAnimationListener(new qoy(this, paramView, paramArticleInfo, paramInt, paramArrayList));
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
          if (localObject != ((opw)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(i2).getTag(2131313373)).a()) {}
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
            localObject = new qox(this, (BaseArticleInfo)localObject, i1);
            Animation localAnimation = (Animation)paramAdvertisementInfo.getTag(2131303150);
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
    if (this.jdField_a_of_type_Rrd != null)
    {
      this.jdField_a_of_type_Rrd.a(paramArticleInfo);
      this.jdField_a_of_type_Rrd.a(paramView, paramInt);
      this.jdField_a_of_type_Rrd.a(this);
    }
  }
  
  public void a(BaseArticleInfo paramBaseArticleInfo)
  {
    this.jdField_b_of_type_JavaUtilList.remove(paramBaseArticleInfo);
    notifyDataSetChanged();
    this.o = true;
  }
  
  public void a(BaseArticleInfo paramBaseArticleInfo, opw paramopw, long paramLong, int paramInt)
  {
    if ((paramBaseArticleInfo == null) || (this.jdField_b_of_type_JavaUtilSet == null) || (((paramBaseArticleInfo instanceof ArticleInfo)) && (jdField_a_of_type_Oxy.b((ArticleInfo)paramBaseArticleInfo)))) {
      break label31;
    }
    label31:
    while ((obz.j(paramBaseArticleInfo)) && (!obz.l(paramBaseArticleInfo))) {
      return;
    }
    if ((paramBaseArticleInfo.hasOnlyTwoVideoFeeds()) && (paramBaseArticleInfo.mSubArtilceList.size() > 0) && (paramBaseArticleInfo.mFeedType != 121))
    {
      Iterator localIterator = paramBaseArticleInfo.mSubArtilceList.iterator();
      while (localIterator.hasNext()) {
        a((ArticleInfo)localIterator.next(), new oqh(this.jdField_a_of_type_AndroidAppActivity, (ArticleInfo)paramBaseArticleInfo, 46, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, paramInt, this.jdField_c_of_type_Boolean, getCount(), null, this), paramLong, paramInt);
      }
    }
    int i1;
    if ((obz.s(paramBaseArticleInfo)) && (paramBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_Boolean)) {
      if (!this.jdField_a_of_type_JavaUtilMap.containsKey(Long.valueOf(-paramBaseArticleInfo.mArticleID))) {
        i1 = 1;
      }
    }
    for (;;)
    {
      if (i1 != 0) {
        ThreadManager.post(new ReadInJoyBaseAdapter.12(this, paramBaseArticleInfo, paramopw, paramInt, paramLong, paramBaseArticleInfo), 5, null, true);
      }
      if (!obz.r()) {
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
      } while (((this.jdField_a_of_type_Qhp != null) && (this.jdField_a_of_type_Qhp.g())) || (npl.a().a() == 1) || (this.jdField_a_of_type_Qhp == null) || (!this.jdField_a_of_type_Pyu.a()) || (this.jdField_a_of_type_Pyu.b()) || (paramAbsListView == null) || (paramAbsListView.getVisibility() != 0));
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1001);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1001, paramInt);
    } while (!QLog.isColorLevel());
    QLog.d("Q.readinjoy.video", 2, "checkPlayableArea delay: " + paramInt);
  }
  
  public void a(List<BaseArticleInfo> paramList)
  {
    omq.a(this.jdField_a_of_type_AndroidUtilSparseArray, new qou(this, "onSetData", paramList));
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
      this.jdField_b_of_type_JavaUtilList.clear();
      this.jdField_b_of_type_JavaUtilList.addAll(paramList);
      this.o = true;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("setData:");
      if (paramList != null) {
        break label227;
      }
    }
    label227:
    for (int i1 = 0;; i1 = paramList.size())
    {
      QLog.d("ReadInJoyBaseAdapter", 2, i1);
      this.jdField_d_of_type_Long = System.nanoTime();
      pyw.a().a(this, this.jdField_b_of_type_JavaUtilList);
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
        if (onu.a(l1)) {
          onu.a().a(this.jdField_c_of_type_Int, l1);
        } else {
          ogy.a().a(this.jdField_c_of_type_Int, localArticleInfo);
        }
      }
    }
    b(this.jdField_c_of_type_Int, paramInt);
  }
  
  public void a(Set<Long> paramSet, Map<Long, pov> paramMap)
  {
    this.jdField_b_of_type_JavaUtilSet = paramSet;
    this.jdField_a_of_type_JavaUtilMap = paramMap;
  }
  
  public void a(naw paramnaw)
  {
    this.jdField_a_of_type_Naw = paramnaw;
  }
  
  public void a(noy paramnoy)
  {
    this.jdField_a_of_type_Noy = paramnoy;
  }
  
  /* Error */
  public void a(omu paramomu, BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aload_2
    //   6: getfield 2598	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mSimpleVideoColumnInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo;
    //   9: ifnull +142 -> 151
    //   12: aload_2
    //   13: getfield 2598	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mSimpleVideoColumnInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo;
    //   16: astore 4
    //   18: aload 4
    //   20: getfield 2599	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:h	Ljava/lang/String;
    //   23: invokestatic 423	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   26: ifne +417 -> 443
    //   29: aload_1
    //   30: getfield 2603	omu:jdField_f_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   33: aload 4
    //   35: getfield 2599	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:h	Ljava/lang/String;
    //   38: invokevirtual 2604	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   41: aload_1
    //   42: getfield 2603	omu:jdField_f_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   45: iconst_0
    //   46: invokevirtual 1522	android/widget/TextView:setVisibility	(I)V
    //   49: aload 4
    //   51: getfield 2605	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   54: invokestatic 423	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   57: ifne +408 -> 465
    //   60: new 1134	java/net/URL
    //   63: dup
    //   64: aload 4
    //   66: getfield 2605	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   69: invokespecial 1503	java/net/URL:<init>	(Ljava/lang/String;)V
    //   72: astore 5
    //   74: aload_1
    //   75: getfield 2607	omu:jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   78: aload 5
    //   80: invokevirtual 2610	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:a	(Ljava/net/URL;)Lcom/tencent/biz/pubaccount/readinjoy/view/imageloader/ZImageView;
    //   83: pop
    //   84: aload_1
    //   85: getfield 2607	omu:jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   88: iconst_0
    //   89: invokevirtual 1521	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setVisibility	(I)V
    //   92: aload 4
    //   94: getfield 2611	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   97: invokestatic 423	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   100: ifne +395 -> 495
    //   103: aload_1
    //   104: getfield 2613	omu:g	Landroid/widget/TextView;
    //   107: aload 4
    //   109: getfield 2611	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   112: invokevirtual 2604	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   115: aload_1
    //   116: getfield 2613	omu:g	Landroid/widget/TextView;
    //   119: iconst_0
    //   120: invokevirtual 1522	android/widget/TextView:setVisibility	(I)V
    //   123: aload 4
    //   125: getfield 2615	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:i	Ljava/lang/String;
    //   128: invokestatic 423	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   131: ifne +20 -> 151
    //   134: aload 4
    //   136: getfield 2615	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:i	Ljava/lang/String;
    //   139: invokestatic 127	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   142: istore_3
    //   143: aload_1
    //   144: getfield 2613	omu:g	Landroid/widget/TextView;
    //   147: iload_3
    //   148: invokevirtual 2618	android/widget/TextView:setTextColor	(I)V
    //   151: aload_2
    //   152: invokestatic 1745	qoe:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lqht;
    //   155: astore 4
    //   157: aload 4
    //   159: aload_1
    //   160: getfield 2619	omu:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   163: putfield 1751	qht:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   166: aload 4
    //   168: aload_1
    //   169: getfield 2620	omu:jdField_a_of_type_Int	I
    //   172: putfield 559	qht:jdField_a_of_type_Int	I
    //   175: aload 4
    //   177: aload_2
    //   178: putfield 1128	qht:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   181: aload_1
    //   182: aload 4
    //   184: putfield 2621	omu:jdField_a_of_type_Qht	Lqht;
    //   187: aload_1
    //   188: getfield 2623	omu:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   191: aload_2
    //   192: getfield 867	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mTitle	Ljava/lang/String;
    //   195: invokevirtual 2604	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   198: aload_1
    //   199: getfield 2623	omu:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   202: invokevirtual 2627	android/widget/TextView:getPaint	()Landroid/text/TextPaint;
    //   205: iconst_1
    //   206: invokevirtual 2632	android/text/TextPaint:setFakeBoldText	(Z)V
    //   209: aload_1
    //   210: getfield 2623	omu:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   213: aload_0
    //   214: getfield 236	qoe:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   217: invokevirtual 1479	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   220: ldc_w 2633
    //   223: invokevirtual 2638	android/content/res/Resources:getColor	(I)I
    //   226: invokevirtual 2618	android/widget/TextView:setTextColor	(I)V
    //   229: aload_1
    //   230: getfield 2640	omu:jdField_b_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   233: bipush 8
    //   235: invokevirtual 1522	android/widget/TextView:setVisibility	(I)V
    //   238: aload_1
    //   239: getfield 2642	omu:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   242: aload 4
    //   244: getfield 645	qht:jdField_b_of_type_Int	I
    //   247: invokestatic 2643	obj:a	(I)Ljava/lang/String;
    //   250: invokevirtual 2604	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   253: aload_1
    //   254: getfield 2645	omu:jdField_b_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   257: bipush 10
    //   259: bipush 10
    //   261: bipush 10
    //   263: bipush 10
    //   265: invokestatic 2650	vms:a	(Landroid/view/View;IIII)V
    //   268: aload_1
    //   269: getfield 2645	omu:jdField_b_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   272: aload_1
    //   273: invokevirtual 1742	android/widget/ImageView:setTag	(Ljava/lang/Object;)V
    //   276: aload_1
    //   277: getfield 2645	omu:jdField_b_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   280: aload_0
    //   281: invokevirtual 1731	android/widget/ImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   284: aload_0
    //   285: getfield 236	qoe:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   288: aload_1
    //   289: getfield 2619	omu:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   292: aload_1
    //   293: getfield 2621	omu:jdField_a_of_type_Qht	Lqht;
    //   296: invokestatic 2653	oms:a	(Landroid/content/Context;Landroid/widget/ImageView;Lqht;)V
    //   299: aload_0
    //   300: aload_1
    //   301: getfield 2619	omu:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   304: aload_2
    //   305: iconst_0
    //   306: invokevirtual 1061	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:getVideoCoverUrlWithSmartCut	(Z)Ljava/net/URL;
    //   309: iconst_0
    //   310: invokespecial 1578	qoe:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;Ljava/net/URL;Z)V
    //   313: aload_1
    //   314: getfield 2619	omu:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   317: aload_0
    //   318: invokevirtual 2657	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setOnLongClickListener	(Landroid/view/View$OnLongClickListener;)V
    //   321: aload_1
    //   322: getfield 2660	omu:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup	Lcom/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup;
    //   325: fconst_1
    //   326: aload 4
    //   328: getfield 815	qht:jdField_c_of_type_Int	I
    //   331: aload 4
    //   333: getfield 818	qht:jdField_d_of_type_Int	I
    //   336: invokestatic 2663	obj:a	(II)F
    //   339: invokevirtual 2669	com/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup:setCustomSize	(FF)V
    //   342: aload_1
    //   343: getfield 2660	omu:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup	Lcom/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup;
    //   346: aload_1
    //   347: invokevirtual 2670	com/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup:setTag	(Ljava/lang/Object;)V
    //   350: aload_0
    //   351: aload_0
    //   352: getfield 138	qoe:jdField_c_of_type_Int	I
    //   355: aload_2
    //   356: getfield 1045	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mArticleID	J
    //   359: invokevirtual 2672	qoe:b	(IJ)Z
    //   362: ifeq +23 -> 385
    //   365: aload_1
    //   366: getfield 2674	omu:jdField_f_of_type_AndroidViewView	Landroid/view/View;
    //   369: aload_0
    //   370: getfield 236	qoe:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   373: invokevirtual 1479	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   376: ldc_w 2675
    //   379: invokevirtual 2638	android/content/res/Resources:getColor	(I)I
    //   382: invokevirtual 2678	android/view/View:setBackgroundColor	(I)V
    //   385: aload_2
    //   386: getfield 673	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mXGFileSize	J
    //   389: lconst_0
    //   390: lcmp
    //   391: ifgt +116 -> 507
    //   394: aload_1
    //   395: getfield 2680	omu:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   398: ldc_w 2681
    //   401: invokestatic 1535	ajjy:a	(I)Ljava/lang/String;
    //   404: invokevirtual 2604	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   407: aload_0
    //   408: getfield 236	qoe:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   411: invokestatic 1155	badq:h	(Landroid/content/Context;)Z
    //   414: ifeq +132 -> 546
    //   417: aload_1
    //   418: getfield 2683	omu:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   421: iconst_0
    //   422: invokevirtual 1548	android/widget/ImageView:setVisibility	(I)V
    //   425: aload_1
    //   426: getfield 2680	omu:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   429: bipush 8
    //   431: invokevirtual 1522	android/widget/TextView:setVisibility	(I)V
    //   434: aload_1
    //   435: getfield 2685	omu:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   438: iconst_0
    //   439: invokevirtual 2678	android/view/View:setBackgroundColor	(I)V
    //   442: return
    //   443: aload_1
    //   444: getfield 2603	omu:jdField_f_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   447: bipush 8
    //   449: invokevirtual 1522	android/widget/TextView:setVisibility	(I)V
    //   452: goto -403 -> 49
    //   455: astore 5
    //   457: aload 5
    //   459: invokevirtual 2686	java/lang/Exception:printStackTrace	()V
    //   462: goto -370 -> 92
    //   465: aload_1
    //   466: getfield 2607	omu:jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   469: bipush 8
    //   471: invokevirtual 1521	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setVisibility	(I)V
    //   474: goto -382 -> 92
    //   477: astore 4
    //   479: aload_1
    //   480: getfield 2613	omu:g	Landroid/widget/TextView;
    //   483: ldc_w 2688
    //   486: invokestatic 127	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   489: invokevirtual 2618	android/widget/TextView:setTextColor	(I)V
    //   492: goto -341 -> 151
    //   495: aload_1
    //   496: getfield 2613	omu:g	Landroid/widget/TextView;
    //   499: bipush 8
    //   501: invokevirtual 1522	android/widget/TextView:setVisibility	(I)V
    //   504: goto -353 -> 151
    //   507: aload_1
    //   508: getfield 2680	omu:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   511: new 830	java/lang/StringBuilder
    //   514: dup
    //   515: invokespecial 831	java/lang/StringBuilder:<init>	()V
    //   518: aload_2
    //   519: getfield 673	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mXGFileSize	J
    //   522: invokestatic 2689	qcn:b	(J)Ljava/lang/String;
    //   525: invokevirtual 835	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   528: ldc_w 2690
    //   531: invokestatic 1535	ajjy:a	(I)Ljava/lang/String;
    //   534: invokevirtual 835	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   537: invokevirtual 841	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   540: invokevirtual 2604	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   543: goto -136 -> 407
    //   546: aload_1
    //   547: getfield 2683	omu:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   550: bipush 8
    //   552: invokevirtual 1548	android/widget/ImageView:setVisibility	(I)V
    //   555: aload_0
    //   556: getfield 236	qoe:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   559: invokevirtual 1479	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   562: ldc_w 2691
    //   565: invokevirtual 2694	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   568: astore 4
    //   570: aload_1
    //   571: getfield 2680	omu:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   574: aload 4
    //   576: aconst_null
    //   577: aconst_null
    //   578: aconst_null
    //   579: invokevirtual 2698	android/widget/TextView:setCompoundDrawablesWithIntrinsicBounds	(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V
    //   582: aload_1
    //   583: getfield 2680	omu:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   586: ldc_w 2699
    //   589: aload_0
    //   590: getfield 236	qoe:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   593: invokevirtual 1479	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   596: invokestatic 586	aciy:a	(FLandroid/content/res/Resources;)I
    //   599: invokevirtual 2702	android/widget/TextView:setCompoundDrawablePadding	(I)V
    //   602: aload_1
    //   603: getfield 2680	omu:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   606: iconst_0
    //   607: invokevirtual 1522	android/widget/TextView:setVisibility	(I)V
    //   610: invokestatic 2705	bati:a	()I
    //   613: iconst_1
    //   614: if_icmpne +34 -> 648
    //   617: aload_1
    //   618: getfield 2680	omu:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   621: ldc_w 2706
    //   624: invokestatic 1535	ajjy:a	(I)Ljava/lang/String;
    //   627: invokevirtual 2604	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   630: aload_1
    //   631: getfield 2708	omu:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   634: bipush 8
    //   636: invokevirtual 1522	android/widget/TextView:setVisibility	(I)V
    //   639: aload_1
    //   640: getfield 2685	omu:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   643: iconst_0
    //   644: invokevirtual 2678	android/view/View:setBackgroundColor	(I)V
    //   647: return
    //   648: invokestatic 2710	bgmq:v	()Z
    //   651: ifeq +280 -> 931
    //   654: aload_0
    //   655: getfield 2711	qoe:jdField_h_of_type_Boolean	Z
    //   658: ifne +273 -> 931
    //   661: aload_1
    //   662: getfield 2620	omu:jdField_a_of_type_Int	I
    //   665: ifne +266 -> 931
    //   668: invokestatic 2713	bgmq:d	()Ljava/lang/String;
    //   671: astore 5
    //   673: invokestatic 2715	bgmq:e	()Ljava/lang/String;
    //   676: astore 6
    //   678: invokestatic 2717	bgmq:f	()Ljava/lang/String;
    //   681: astore 7
    //   683: aload 5
    //   685: invokestatic 423	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   688: ifne +209 -> 897
    //   691: invokestatic 2719	obz:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   694: astore 8
    //   696: ldc_w 911
    //   699: astore 4
    //   701: aload 8
    //   703: ifnull +10 -> 713
    //   706: aload 8
    //   708: invokevirtual 2722	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   711: astore 4
    //   713: new 1243	qmv
    //   716: dup
    //   717: aconst_null
    //   718: aconst_null
    //   719: aconst_null
    //   720: aconst_null
    //   721: invokespecial 1246	qmv:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   724: aload 4
    //   726: invokevirtual 2725	qmv:l	(Ljava/lang/String;)Lqmv;
    //   729: aload_2
    //   730: getfield 774	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:innerUniqueID	Ljava/lang/String;
    //   733: invokevirtual 2727	qmv:h	(Ljava/lang/String;)Lqmv;
    //   736: invokevirtual 1269	qmv:a	()Lqmu;
    //   739: invokevirtual 1273	qmu:a	()Ljava/lang/String;
    //   742: astore_2
    //   743: aload_1
    //   744: getfield 2708	omu:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   747: iconst_0
    //   748: invokevirtual 1522	android/widget/TextView:setVisibility	(I)V
    //   751: aload_1
    //   752: getfield 2708	omu:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   755: fconst_2
    //   756: aload_0
    //   757: getfield 236	qoe:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   760: invokevirtual 1479	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   763: invokestatic 586	aciy:a	(FLandroid/content/res/Resources;)I
    //   766: invokevirtual 2702	android/widget/TextView:setCompoundDrawablePadding	(I)V
    //   769: aload_0
    //   770: getfield 236	qoe:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   773: invokevirtual 1479	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   776: ldc_w 2728
    //   779: invokevirtual 2694	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   782: astore 4
    //   784: aload 4
    //   786: iconst_0
    //   787: iconst_0
    //   788: ldc_w 2729
    //   791: aload_0
    //   792: getfield 236	qoe:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   795: invokevirtual 1479	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   798: invokestatic 586	aciy:a	(FLandroid/content/res/Resources;)I
    //   801: ldc_w 2729
    //   804: aload_0
    //   805: getfield 236	qoe:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   808: invokevirtual 1479	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   811: invokestatic 586	aciy:a	(FLandroid/content/res/Resources;)I
    //   814: invokevirtual 2735	android/graphics/drawable/Drawable:setBounds	(IIII)V
    //   817: aload_1
    //   818: getfield 2708	omu:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   821: aconst_null
    //   822: aconst_null
    //   823: aload 4
    //   825: aconst_null
    //   826: invokevirtual 2738	android/widget/TextView:setCompoundDrawables	(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V
    //   829: aload_0
    //   830: getfield 236	qoe:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   833: aload_1
    //   834: getfield 2708	omu:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   837: aload 6
    //   839: aload 7
    //   841: aload 5
    //   843: new 2740	qpe
    //   846: dup
    //   847: aload_0
    //   848: aload_2
    //   849: invokespecial 2741	qpe:<init>	(Lqoe;Ljava/lang/String;)V
    //   852: invokestatic 2744	qcn:b	(Landroid/content/Context;Landroid/widget/TextView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/view/View$OnClickListener;)V
    //   855: aload_1
    //   856: getfield 2685	omu:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   859: ldc_w 2745
    //   862: invokevirtual 2678	android/view/View:setBackgroundColor	(I)V
    //   865: aload_0
    //   866: iconst_1
    //   867: putfield 2711	qoe:jdField_h_of_type_Boolean	Z
    //   870: aconst_null
    //   871: ldc_w 911
    //   874: ldc_w 2747
    //   877: ldc_w 2747
    //   880: iconst_0
    //   881: iconst_0
    //   882: ldc_w 911
    //   885: ldc_w 911
    //   888: ldc_w 911
    //   891: aload_2
    //   892: iconst_0
    //   893: invokestatic 1282	ndn:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   896: return
    //   897: aload_1
    //   898: getfield 2708	omu:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   901: bipush 8
    //   903: invokevirtual 1522	android/widget/TextView:setVisibility	(I)V
    //   906: aload_1
    //   907: getfield 2685	omu:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   910: iconst_0
    //   911: invokevirtual 2678	android/view/View:setBackgroundColor	(I)V
    //   914: invokestatic 330	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   917: ifeq -913 -> 4
    //   920: ldc_w 985
    //   923: iconst_2
    //   924: ldc_w 2749
    //   927: invokestatic 990	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   930: return
    //   931: aload_1
    //   932: getfield 2708	omu:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   935: bipush 8
    //   937: invokevirtual 1522	android/widget/TextView:setVisibility	(I)V
    //   940: aload_1
    //   941: getfield 2685	omu:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   944: iconst_0
    //   945: invokevirtual 2678	android/view/View:setBackgroundColor	(I)V
    //   948: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	949	0	this	qoe
    //   0	949	1	paramomu	omu
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
  public void a(omv paramomv, BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aload_2
    //   6: getfield 2753	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mArticleSubscriptText	Ljava/lang/String;
    //   9: invokestatic 423	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   12: ifne +515 -> 527
    //   15: aload_1
    //   16: getfield 2756	omv:i	Landroid/widget/TextView;
    //   19: aload_2
    //   20: getfield 2753	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mArticleSubscriptText	Ljava/lang/String;
    //   23: invokevirtual 2604	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   26: aload_2
    //   27: getfield 2759	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mArticleSubscriptColor	Ljava/lang/String;
    //   30: invokestatic 423	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   33: ifeq +485 -> 518
    //   36: ldc_w 2761
    //   39: astore 4
    //   41: aload 4
    //   43: invokestatic 127	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   46: istore_3
    //   47: aload_1
    //   48: getfield 2756	omv:i	Landroid/widget/TextView;
    //   51: iload_3
    //   52: invokevirtual 2618	android/widget/TextView:setTextColor	(I)V
    //   55: aload_1
    //   56: getfield 2756	omv:i	Landroid/widget/TextView;
    //   59: iconst_0
    //   60: invokevirtual 1522	android/widget/TextView:setVisibility	(I)V
    //   63: aload_1
    //   64: getfield 2762	omv:g	Landroid/widget/TextView;
    //   67: aload_2
    //   68: getfield 622	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mSubscribeName	Ljava/lang/String;
    //   71: invokevirtual 2604	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   74: aload_2
    //   75: invokevirtual 1495	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:hasFamilyCommentIcon	()Z
    //   78: ifeq +476 -> 554
    //   81: new 1134	java/net/URL
    //   84: dup
    //   85: aload_2
    //   86: getfield 1499	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:familyCommentInfo	Lppe;
    //   89: getfield 1502	ppe:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   92: invokespecial 1503	java/net/URL:<init>	(Ljava/lang/String;)V
    //   95: astore 4
    //   97: aload_2
    //   98: getfield 1499	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:familyCommentInfo	Lppe;
    //   101: getfield 1504	ppe:jdField_b_of_type_Int	I
    //   104: ifle +27 -> 131
    //   107: aload_0
    //   108: aload_1
    //   109: getfield 2763	omv:jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   112: aload 4
    //   114: aload_2
    //   115: getfield 1499	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:familyCommentInfo	Lppe;
    //   118: getfield 1505	ppe:jdField_a_of_type_Int	I
    //   121: aload_2
    //   122: getfield 1499	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:familyCommentInfo	Lppe;
    //   125: getfield 1504	ppe:jdField_b_of_type_Int	I
    //   128: invokespecial 1508	qoe:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;Ljava/net/URL;II)V
    //   131: aload_1
    //   132: getfield 2763	omv:jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   135: iconst_0
    //   136: invokevirtual 1521	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setVisibility	(I)V
    //   139: aload_1
    //   140: getfield 2764	omv:h	Landroid/widget/TextView;
    //   143: bipush 8
    //   145: invokevirtual 1522	android/widget/TextView:setVisibility	(I)V
    //   148: aload_2
    //   149: getfield 2767	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:vIconUrl	Ljava/lang/String;
    //   152: invokestatic 423	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   155: ifne +475 -> 630
    //   158: new 1134	java/net/URL
    //   161: dup
    //   162: aload_2
    //   163: getfield 2767	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:vIconUrl	Ljava/lang/String;
    //   166: invokespecial 1503	java/net/URL:<init>	(Ljava/lang/String;)V
    //   169: astore 4
    //   171: aload_1
    //   172: getfield 2769	omv:jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   175: aload 4
    //   177: invokevirtual 2610	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:a	(Ljava/net/URL;)Lcom/tencent/biz/pubaccount/readinjoy/view/imageloader/ZImageView;
    //   180: pop
    //   181: aload_1
    //   182: getfield 2769	omv:jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   185: iconst_0
    //   186: invokevirtual 1521	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setVisibility	(I)V
    //   189: aload_1
    //   190: getfield 2770	omv:jdField_b_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   193: bipush 10
    //   195: bipush 10
    //   197: bipush 10
    //   199: bipush 10
    //   201: invokestatic 2650	vms:a	(Landroid/view/View;IIII)V
    //   204: aload_1
    //   205: getfield 2770	omv:jdField_b_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   208: aload_1
    //   209: invokevirtual 1742	android/widget/ImageView:setTag	(Ljava/lang/Object;)V
    //   212: aload_1
    //   213: getfield 2770	omv:jdField_b_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   216: aload_0
    //   217: invokevirtual 1731	android/widget/ImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   220: aload_2
    //   221: invokestatic 1745	qoe:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lqht;
    //   224: astore 4
    //   226: aload 4
    //   228: aload_1
    //   229: getfield 2771	omv:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   232: putfield 1751	qht:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   235: aload 4
    //   237: aload_1
    //   238: getfield 2772	omv:jdField_a_of_type_Int	I
    //   241: putfield 559	qht:jdField_a_of_type_Int	I
    //   244: aload 4
    //   246: aload_2
    //   247: putfield 1128	qht:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   250: aload 4
    //   252: iconst_1
    //   253: putfield 2773	qht:jdField_n_of_type_Int	I
    //   256: aload_1
    //   257: aload 4
    //   259: putfield 2774	omv:jdField_a_of_type_Qht	Lqht;
    //   262: aload_1
    //   263: getfield 2775	omv:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   266: bipush 8
    //   268: invokevirtual 1522	android/widget/TextView:setVisibility	(I)V
    //   271: aload_1
    //   272: getfield 2776	omv:jdField_b_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   275: bipush 8
    //   277: invokevirtual 1522	android/widget/TextView:setVisibility	(I)V
    //   280: aload_1
    //   281: getfield 2778	omv:jdField_c_of_type_AndroidViewView	Landroid/view/View;
    //   284: bipush 8
    //   286: invokevirtual 1492	android/view/View:setVisibility	(I)V
    //   289: aload_1
    //   290: getfield 2779	omv:jdField_f_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   293: aload_2
    //   294: getfield 867	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mTitle	Ljava/lang/String;
    //   297: invokevirtual 2604	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   300: aload_1
    //   301: getfield 2779	omv:jdField_f_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   304: astore 5
    //   306: invokestatic 1981	ogy:a	()Logy;
    //   309: aload_2
    //   310: getfield 1045	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mArticleID	J
    //   313: invokevirtual 2780	ogy:a	(J)Z
    //   316: ifeq +326 -> 642
    //   319: getstatic 129	qoe:jdField_g_of_type_Int	I
    //   322: istore_3
    //   323: aload 5
    //   325: iload_3
    //   326: invokevirtual 2618	android/widget/TextView:setTextColor	(I)V
    //   329: aload_1
    //   330: getfield 2781	omv:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   333: aload 4
    //   335: getfield 645	qht:jdField_b_of_type_Int	I
    //   338: invokestatic 2643	obj:a	(I)Ljava/lang/String;
    //   341: invokevirtual 2604	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   344: aload_0
    //   345: getfield 236	qoe:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   348: aload_1
    //   349: getfield 2771	omv:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   352: aload_1
    //   353: getfield 2774	omv:jdField_a_of_type_Qht	Lqht;
    //   356: invokestatic 2653	oms:a	(Landroid/content/Context;Landroid/widget/ImageView;Lqht;)V
    //   359: aload_0
    //   360: aload_1
    //   361: getfield 2771	omv:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   364: aload_2
    //   365: iconst_0
    //   366: invokevirtual 1061	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:getVideoCoverUrlWithSmartCut	(Z)Ljava/net/URL;
    //   369: iconst_0
    //   370: invokespecial 1578	qoe:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;Ljava/net/URL;Z)V
    //   373: aload_1
    //   374: getfield 2771	omv:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   377: aload_0
    //   378: invokevirtual 2657	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setOnLongClickListener	(Landroid/view/View$OnLongClickListener;)V
    //   381: aload_1
    //   382: getfield 2781	omv:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   385: iconst_0
    //   386: invokevirtual 1522	android/widget/TextView:setVisibility	(I)V
    //   389: aload_1
    //   390: getfield 2781	omv:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   393: invokevirtual 2784	android/widget/TextView:clearAnimation	()V
    //   396: aload_1
    //   397: getfield 2785	omv:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup	Lcom/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup;
    //   400: fconst_1
    //   401: aload 4
    //   403: getfield 815	qht:jdField_c_of_type_Int	I
    //   406: aload 4
    //   408: getfield 818	qht:jdField_d_of_type_Int	I
    //   411: invokestatic 2663	obj:a	(II)F
    //   414: invokevirtual 2669	com/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup:setCustomSize	(FF)V
    //   417: aload_1
    //   418: getfield 2785	omv:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup	Lcom/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup;
    //   421: aload_1
    //   422: invokevirtual 2670	com/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup:setTag	(Ljava/lang/Object;)V
    //   425: aload_0
    //   426: aload_0
    //   427: getfield 138	qoe:jdField_c_of_type_Int	I
    //   430: aload_2
    //   431: getfield 1045	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mArticleID	J
    //   434: invokevirtual 2672	qoe:b	(IJ)Z
    //   437: ifeq +23 -> 460
    //   440: aload_1
    //   441: getfield 2786	omv:jdField_f_of_type_AndroidViewView	Landroid/view/View;
    //   444: aload_0
    //   445: getfield 236	qoe:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   448: invokevirtual 1479	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   451: ldc_w 2675
    //   454: invokevirtual 2638	android/content/res/Resources:getColor	(I)I
    //   457: invokevirtual 2678	android/view/View:setBackgroundColor	(I)V
    //   460: aload_2
    //   461: getfield 673	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mXGFileSize	J
    //   464: lconst_0
    //   465: lcmp
    //   466: ifgt +183 -> 649
    //   469: aload_1
    //   470: getfield 2787	omv:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   473: ldc_w 2681
    //   476: invokestatic 1535	ajjy:a	(I)Ljava/lang/String;
    //   479: invokevirtual 2604	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   482: aload_0
    //   483: getfield 236	qoe:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   486: invokestatic 1155	badq:h	(Landroid/content/Context;)Z
    //   489: ifeq +199 -> 688
    //   492: aload_1
    //   493: getfield 2788	omv:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   496: iconst_0
    //   497: invokevirtual 1548	android/widget/ImageView:setVisibility	(I)V
    //   500: aload_1
    //   501: getfield 2787	omv:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   504: bipush 8
    //   506: invokevirtual 1522	android/widget/TextView:setVisibility	(I)V
    //   509: aload_1
    //   510: getfield 2789	omv:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   513: iconst_0
    //   514: invokevirtual 2678	android/view/View:setBackgroundColor	(I)V
    //   517: return
    //   518: aload_2
    //   519: getfield 2759	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mArticleSubscriptColor	Ljava/lang/String;
    //   522: astore 4
    //   524: goto -483 -> 41
    //   527: aload_1
    //   528: getfield 2756	omv:i	Landroid/widget/TextView;
    //   531: bipush 8
    //   533: invokevirtual 1522	android/widget/TextView:setVisibility	(I)V
    //   536: goto -473 -> 63
    //   539: astore 4
    //   541: ldc_w 332
    //   544: iconst_2
    //   545: ldc_w 2791
    //   548: invokestatic 337	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   551: goto -403 -> 148
    //   554: aload_1
    //   555: getfield 2763	omv:jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   558: bipush 8
    //   560: invokevirtual 1521	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setVisibility	(I)V
    //   563: aload_1
    //   564: getfield 2764	omv:h	Landroid/widget/TextView;
    //   567: iconst_0
    //   568: invokevirtual 1522	android/widget/TextView:setVisibility	(I)V
    //   571: ldc_w 332
    //   574: iconst_2
    //   575: ldc_w 2793
    //   578: invokestatic 337	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   581: aload_1
    //   582: getfield 2764	omv:h	Landroid/widget/TextView;
    //   585: new 830	java/lang/StringBuilder
    //   588: dup
    //   589: invokespecial 831	java/lang/StringBuilder:<init>	()V
    //   592: aload_2
    //   593: invokevirtual 1530	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:getCommentCount	()I
    //   596: invokestatic 2795	qcn:d	(I)Ljava/lang/String;
    //   599: invokevirtual 835	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   602: ldc_w 2796
    //   605: invokestatic 1535	ajjy:a	(I)Ljava/lang/String;
    //   608: invokevirtual 835	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   611: invokevirtual 841	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   614: invokevirtual 2604	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   617: goto -469 -> 148
    //   620: astore 4
    //   622: aload 4
    //   624: invokevirtual 2686	java/lang/Exception:printStackTrace	()V
    //   627: goto -438 -> 189
    //   630: aload_1
    //   631: getfield 2769	omv:jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   634: bipush 8
    //   636: invokevirtual 1521	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setVisibility	(I)V
    //   639: goto -450 -> 189
    //   642: getstatic 133	qoe:jdField_h_of_type_Int	I
    //   645: istore_3
    //   646: goto -323 -> 323
    //   649: aload_1
    //   650: getfield 2787	omv:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   653: new 830	java/lang/StringBuilder
    //   656: dup
    //   657: invokespecial 831	java/lang/StringBuilder:<init>	()V
    //   660: aload_2
    //   661: getfield 673	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mXGFileSize	J
    //   664: invokestatic 2689	qcn:b	(J)Ljava/lang/String;
    //   667: invokevirtual 835	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   670: ldc_w 2690
    //   673: invokestatic 1535	ajjy:a	(I)Ljava/lang/String;
    //   676: invokevirtual 835	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   679: invokevirtual 841	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   682: invokevirtual 2604	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   685: goto -203 -> 482
    //   688: aload_1
    //   689: getfield 2788	omv:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   692: bipush 8
    //   694: invokevirtual 1548	android/widget/ImageView:setVisibility	(I)V
    //   697: aload_0
    //   698: getfield 236	qoe:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   701: invokevirtual 1479	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   704: ldc_w 2691
    //   707: invokevirtual 2694	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   710: astore 4
    //   712: aload_1
    //   713: getfield 2787	omv:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   716: aload 4
    //   718: aconst_null
    //   719: aconst_null
    //   720: aconst_null
    //   721: invokevirtual 2698	android/widget/TextView:setCompoundDrawablesWithIntrinsicBounds	(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V
    //   724: aload_1
    //   725: getfield 2787	omv:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   728: ldc_w 2699
    //   731: aload_0
    //   732: getfield 236	qoe:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   735: invokevirtual 1479	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   738: invokestatic 586	aciy:a	(FLandroid/content/res/Resources;)I
    //   741: invokevirtual 2702	android/widget/TextView:setCompoundDrawablePadding	(I)V
    //   744: aload_1
    //   745: getfield 2787	omv:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   748: iconst_0
    //   749: invokevirtual 1522	android/widget/TextView:setVisibility	(I)V
    //   752: invokestatic 2705	bati:a	()I
    //   755: iconst_1
    //   756: if_icmpne +34 -> 790
    //   759: aload_1
    //   760: getfield 2787	omv:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   763: ldc_w 2706
    //   766: invokestatic 1535	ajjy:a	(I)Ljava/lang/String;
    //   769: invokevirtual 2604	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   772: aload_1
    //   773: getfield 2797	omv:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   776: bipush 8
    //   778: invokevirtual 1522	android/widget/TextView:setVisibility	(I)V
    //   781: aload_1
    //   782: getfield 2789	omv:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   785: iconst_0
    //   786: invokevirtual 2678	android/view/View:setBackgroundColor	(I)V
    //   789: return
    //   790: invokestatic 2710	bgmq:v	()Z
    //   793: ifeq +280 -> 1073
    //   796: aload_0
    //   797: getfield 2711	qoe:jdField_h_of_type_Boolean	Z
    //   800: ifne +273 -> 1073
    //   803: aload_1
    //   804: getfield 2772	omv:jdField_a_of_type_Int	I
    //   807: ifne +266 -> 1073
    //   810: invokestatic 2713	bgmq:d	()Ljava/lang/String;
    //   813: astore 5
    //   815: invokestatic 2715	bgmq:e	()Ljava/lang/String;
    //   818: astore 6
    //   820: invokestatic 2717	bgmq:f	()Ljava/lang/String;
    //   823: astore 7
    //   825: aload 5
    //   827: invokestatic 423	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   830: ifne +209 -> 1039
    //   833: invokestatic 2719	obz:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   836: astore 8
    //   838: ldc_w 911
    //   841: astore 4
    //   843: aload 8
    //   845: ifnull +10 -> 855
    //   848: aload 8
    //   850: invokevirtual 2722	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   853: astore 4
    //   855: new 1243	qmv
    //   858: dup
    //   859: aconst_null
    //   860: aconst_null
    //   861: aconst_null
    //   862: aconst_null
    //   863: invokespecial 1246	qmv:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   866: aload 4
    //   868: invokevirtual 2725	qmv:l	(Ljava/lang/String;)Lqmv;
    //   871: aload_2
    //   872: getfield 774	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:innerUniqueID	Ljava/lang/String;
    //   875: invokevirtual 2727	qmv:h	(Ljava/lang/String;)Lqmv;
    //   878: invokevirtual 1269	qmv:a	()Lqmu;
    //   881: invokevirtual 1273	qmu:a	()Ljava/lang/String;
    //   884: astore_2
    //   885: aload_1
    //   886: getfield 2797	omv:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   889: iconst_0
    //   890: invokevirtual 1522	android/widget/TextView:setVisibility	(I)V
    //   893: aload_1
    //   894: getfield 2797	omv:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   897: fconst_2
    //   898: aload_0
    //   899: getfield 236	qoe:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   902: invokevirtual 1479	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   905: invokestatic 586	aciy:a	(FLandroid/content/res/Resources;)I
    //   908: invokevirtual 2702	android/widget/TextView:setCompoundDrawablePadding	(I)V
    //   911: aload_0
    //   912: getfield 236	qoe:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   915: invokevirtual 1479	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   918: ldc_w 2728
    //   921: invokevirtual 2694	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   924: astore 4
    //   926: aload 4
    //   928: iconst_0
    //   929: iconst_0
    //   930: ldc_w 2729
    //   933: aload_0
    //   934: getfield 236	qoe:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   937: invokevirtual 1479	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   940: invokestatic 586	aciy:a	(FLandroid/content/res/Resources;)I
    //   943: ldc_w 2729
    //   946: aload_0
    //   947: getfield 236	qoe:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   950: invokevirtual 1479	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   953: invokestatic 586	aciy:a	(FLandroid/content/res/Resources;)I
    //   956: invokevirtual 2735	android/graphics/drawable/Drawable:setBounds	(IIII)V
    //   959: aload_1
    //   960: getfield 2797	omv:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   963: aconst_null
    //   964: aconst_null
    //   965: aload 4
    //   967: aconst_null
    //   968: invokevirtual 2738	android/widget/TextView:setCompoundDrawables	(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V
    //   971: aload_0
    //   972: getfield 236	qoe:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   975: aload_1
    //   976: getfield 2797	omv:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   979: aload 6
    //   981: aload 7
    //   983: aload 5
    //   985: new 2799	qpd
    //   988: dup
    //   989: aload_0
    //   990: aload_2
    //   991: invokespecial 2800	qpd:<init>	(Lqoe;Ljava/lang/String;)V
    //   994: invokestatic 2744	qcn:b	(Landroid/content/Context;Landroid/widget/TextView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/view/View$OnClickListener;)V
    //   997: aload_1
    //   998: getfield 2789	omv:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   1001: ldc_w 2745
    //   1004: invokevirtual 2678	android/view/View:setBackgroundColor	(I)V
    //   1007: aload_0
    //   1008: iconst_1
    //   1009: putfield 2711	qoe:jdField_h_of_type_Boolean	Z
    //   1012: aconst_null
    //   1013: ldc_w 911
    //   1016: ldc_w 2747
    //   1019: ldc_w 2747
    //   1022: iconst_0
    //   1023: iconst_0
    //   1024: ldc_w 911
    //   1027: ldc_w 911
    //   1030: ldc_w 911
    //   1033: aload_2
    //   1034: iconst_0
    //   1035: invokestatic 1282	ndn:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   1038: return
    //   1039: aload_1
    //   1040: getfield 2797	omv:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   1043: bipush 8
    //   1045: invokevirtual 1522	android/widget/TextView:setVisibility	(I)V
    //   1048: aload_1
    //   1049: getfield 2789	omv:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   1052: iconst_0
    //   1053: invokevirtual 2678	android/view/View:setBackgroundColor	(I)V
    //   1056: invokestatic 330	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1059: ifeq -1055 -> 4
    //   1062: ldc_w 985
    //   1065: iconst_2
    //   1066: ldc_w 2749
    //   1069: invokestatic 990	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1072: return
    //   1073: aload_1
    //   1074: getfield 2797	omv:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   1077: bipush 8
    //   1079: invokevirtual 1522	android/widget/TextView:setVisibility	(I)V
    //   1082: aload_1
    //   1083: getfield 2789	omv:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   1086: iconst_0
    //   1087: invokevirtual 2678	android/view/View:setBackgroundColor	(I)V
    //   1090: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1091	0	this	qoe
    //   0	1091	1	paramomv	omv
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
  
  public void a(omw paramomw)
  {
    this.jdField_a_of_type_Qhp.b(2);
    this.jdField_a_of_type_Omw = paramomw;
    this.jdField_a_of_type_Qht = paramomw.a();
    this.jdField_a_of_type_Qhp.a(this.jdField_a_of_type_Qht);
  }
  
  /* Error */
  public void a(omx paramomx, BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aload_1
    //   6: getfield 2807	omx:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   9: invokevirtual 2627	android/widget/TextView:getPaint	()Landroid/text/TextPaint;
    //   12: iconst_1
    //   13: invokevirtual 2632	android/text/TextPaint:setFakeBoldText	(Z)V
    //   16: aload_2
    //   17: getfield 1930	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mVideoColumnInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo;
    //   20: ifnull +390 -> 410
    //   23: aload_2
    //   24: getfield 1930	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mVideoColumnInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo;
    //   27: astore 5
    //   29: aload 5
    //   31: getfield 2808	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:jdField_d_of_type_Int	I
    //   34: iconst_1
    //   35: if_icmpne +690 -> 725
    //   38: aload_1
    //   39: getfield 2809	omx:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   42: invokevirtual 1580	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   45: astore 4
    //   47: aload 4
    //   49: aload_0
    //   50: getfield 236	qoe:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   53: ldc_w 2810
    //   56: invokestatic 2815	azvv:a	(Landroid/content/Context;F)I
    //   59: putfield 1597	android/view/ViewGroup$LayoutParams:height	I
    //   62: aload_1
    //   63: getfield 2809	omx:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   66: aload 4
    //   68: invokevirtual 1610	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   71: aload 5
    //   73: getfield 2816	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   76: invokestatic 423	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   79: ifne +682 -> 761
    //   82: aload_0
    //   83: aload_1
    //   84: getfield 2809	omx:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   87: new 1134	java/net/URL
    //   90: dup
    //   91: aload 5
    //   93: getfield 2816	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   96: invokespecial 1503	java/net/URL:<init>	(Ljava/lang/String;)V
    //   99: invokespecial 2818	qoe:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;Ljava/net/URL;)V
    //   102: aload 5
    //   104: getfield 2819	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   107: invokestatic 423	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   110: ifne +694 -> 804
    //   113: aload 5
    //   115: getfield 2819	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   118: invokestatic 2822	obj:a	(Ljava/lang/String;)Landroid/graphics/drawable/Drawable;
    //   121: astore 4
    //   123: aload_1
    //   124: getfield 2825	omx:jdField_a_of_type_AndroidViewViewGroup	Landroid/view/ViewGroup;
    //   127: aload 4
    //   129: invokevirtual 2830	android/view/ViewGroup:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   132: aload_0
    //   133: aload_1
    //   134: getfield 2831	omx:jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   137: new 1134	java/net/URL
    //   140: dup
    //   141: aload 5
    //   143: getfield 2832	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   146: invokespecial 1503	java/net/URL:<init>	(Ljava/lang/String;)V
    //   149: invokespecial 2818	qoe:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;Ljava/net/URL;)V
    //   152: aload_1
    //   153: getfield 2807	omx:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   156: aload 5
    //   158: getfield 2611	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   161: invokevirtual 2604	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   164: new 830	java/lang/StringBuilder
    //   167: dup
    //   168: invokespecial 831	java/lang/StringBuilder:<init>	()V
    //   171: aload 5
    //   173: getfield 2833	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:jdField_a_of_type_Long	J
    //   176: iconst_1
    //   177: invokestatic 642	oby:a	(JZ)Ljava/lang/String;
    //   180: invokevirtual 835	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: ldc_w 2834
    //   186: invokestatic 1535	ajjy:a	(I)Ljava/lang/String;
    //   189: invokevirtual 835	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: invokevirtual 841	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: astore 4
    //   197: new 830	java/lang/StringBuilder
    //   200: dup
    //   201: invokespecial 831	java/lang/StringBuilder:<init>	()V
    //   204: aload 5
    //   206: getfield 2835	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:jdField_b_of_type_Int	I
    //   209: invokestatic 2837	bgmq:b	(I)Ljava/lang/String;
    //   212: invokevirtual 835	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: ldc_w 2838
    //   218: invokestatic 1535	ajjy:a	(I)Ljava/lang/String;
    //   221: invokevirtual 835	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: invokevirtual 841	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   227: astore 6
    //   229: new 830	java/lang/StringBuilder
    //   232: dup
    //   233: invokespecial 831	java/lang/StringBuilder:<init>	()V
    //   236: aload 5
    //   238: getfield 2839	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:jdField_c_of_type_Int	I
    //   241: invokevirtual 1143	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   244: ldc_w 2840
    //   247: invokestatic 1535	ajjy:a	(I)Ljava/lang/String;
    //   250: invokevirtual 835	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: invokevirtual 841	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   256: astore 7
    //   258: new 830	java/lang/StringBuilder
    //   261: dup
    //   262: invokespecial 831	java/lang/StringBuilder:<init>	()V
    //   265: aload 4
    //   267: invokevirtual 835	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: ldc_w 2842
    //   273: invokevirtual 835	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: aload 6
    //   278: invokevirtual 835	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: ldc_w 2842
    //   284: invokevirtual 835	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: aload 7
    //   289: invokevirtual 835	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: invokevirtual 841	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   295: astore 4
    //   297: aload_1
    //   298: getfield 2843	omx:jdField_b_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   301: aload 4
    //   303: invokevirtual 2604	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   306: aload 5
    //   308: getfield 2844	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:jdField_a_of_type_Boolean	Z
    //   311: ifeq +558 -> 869
    //   314: aload_1
    //   315: getfield 2845	omx:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   318: bipush 8
    //   320: invokevirtual 1522	android/widget/TextView:setVisibility	(I)V
    //   323: aload_1
    //   324: getfield 2846	omx:i	Landroid/widget/TextView;
    //   327: aload 5
    //   329: getfield 2847	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   332: invokevirtual 2604	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   335: aload_1
    //   336: getfield 2850	omx:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KanDianUrlRoundCornerImageView;
    //   339: aload_0
    //   340: invokevirtual 1201	qoe:a	()Landroid/app/Activity;
    //   343: fconst_2
    //   344: invokestatic 2815	azvv:a	(Landroid/content/Context;F)I
    //   347: invokevirtual 2855	com/tencent/biz/pubaccount/readinjoy/view/KanDianUrlRoundCornerImageView:setCorner	(I)V
    //   350: aload_0
    //   351: aload_1
    //   352: getfield 2850	omx:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KanDianUrlRoundCornerImageView;
    //   355: new 1134	java/net/URL
    //   358: dup
    //   359: aload 5
    //   361: getfield 2856	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   364: invokespecial 1503	java/net/URL:<init>	(Ljava/lang/String;)V
    //   367: invokespecial 2818	qoe:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;Ljava/net/URL;)V
    //   370: aload_1
    //   371: getfield 2859	omx:jdField_a_of_type_AndroidWidgetRelativeLayout	Landroid/widget/RelativeLayout;
    //   374: aload_1
    //   375: invokevirtual 2862	android/widget/RelativeLayout:setTag	(Ljava/lang/Object;)V
    //   378: aload_1
    //   379: getfield 2845	omx:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   382: aload_1
    //   383: invokevirtual 1741	android/widget/TextView:setTag	(Ljava/lang/Object;)V
    //   386: aload_1
    //   387: getfield 2864	omx:jdField_b_of_type_AndroidViewViewGroup	Landroid/view/ViewGroup;
    //   390: aload_1
    //   391: invokevirtual 2865	android/view/ViewGroup:setTag	(Ljava/lang/Object;)V
    //   394: aload_1
    //   395: getfield 2850	omx:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KanDianUrlRoundCornerImageView;
    //   398: aload_1
    //   399: invokevirtual 2866	com/tencent/biz/pubaccount/readinjoy/view/KanDianUrlRoundCornerImageView:setTag	(Ljava/lang/Object;)V
    //   402: aload_1
    //   403: getfield 2846	omx:i	Landroid/widget/TextView;
    //   406: aload_1
    //   407: invokevirtual 1741	android/widget/TextView:setTag	(Ljava/lang/Object;)V
    //   410: aload_1
    //   411: getfield 2867	omx:jdField_b_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   414: aload_1
    //   415: invokevirtual 1742	android/widget/ImageView:setTag	(Ljava/lang/Object;)V
    //   418: aload_1
    //   419: getfield 2867	omx:jdField_b_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   422: aload_0
    //   423: invokevirtual 1731	android/widget/ImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   426: aload_2
    //   427: invokestatic 1745	qoe:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lqht;
    //   430: astore 4
    //   432: aload 4
    //   434: aload_1
    //   435: getfield 2868	omx:jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   438: putfield 1751	qht:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   441: aload 4
    //   443: aload_1
    //   444: getfield 2869	omx:jdField_a_of_type_Int	I
    //   447: putfield 559	qht:jdField_a_of_type_Int	I
    //   450: aload 4
    //   452: aload_2
    //   453: putfield 1128	qht:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   456: aload_1
    //   457: aload 4
    //   459: putfield 2870	omx:jdField_a_of_type_Qht	Lqht;
    //   462: aload_1
    //   463: getfield 2871	omx:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   466: aload_2
    //   467: getfield 867	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mTitle	Ljava/lang/String;
    //   470: invokevirtual 2604	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   473: aload_1
    //   474: getfield 2871	omx:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   477: invokevirtual 2627	android/widget/TextView:getPaint	()Landroid/text/TextPaint;
    //   480: iconst_1
    //   481: invokevirtual 2632	android/text/TextPaint:setFakeBoldText	(Z)V
    //   484: aload_1
    //   485: getfield 2871	omx:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   488: aload_0
    //   489: getfield 236	qoe:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   492: invokevirtual 1479	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   495: ldc_w 2633
    //   498: invokevirtual 2638	android/content/res/Resources:getColor	(I)I
    //   501: invokevirtual 2618	android/widget/TextView:setTextColor	(I)V
    //   504: aload_2
    //   505: getfield 2874	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mVideoPlayCount	I
    //   508: ifne +372 -> 880
    //   511: aload_1
    //   512: getfield 2875	omx:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   515: bipush 8
    //   517: invokevirtual 1522	android/widget/TextView:setVisibility	(I)V
    //   520: aload_1
    //   521: getfield 2876	omx:jdField_f_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   524: aload 4
    //   526: getfield 645	qht:jdField_b_of_type_Int	I
    //   529: invokestatic 2643	obj:a	(I)Ljava/lang/String;
    //   532: invokevirtual 2604	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   535: aload_0
    //   536: getfield 236	qoe:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   539: aload_1
    //   540: getfield 2868	omx:jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   543: aload_1
    //   544: getfield 2870	omx:jdField_a_of_type_Qht	Lqht;
    //   547: invokestatic 2653	oms:a	(Landroid/content/Context;Landroid/widget/ImageView;Lqht;)V
    //   550: aload_0
    //   551: aload_1
    //   552: getfield 2868	omx:jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   555: aload_2
    //   556: iconst_0
    //   557: invokevirtual 1061	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:getVideoCoverUrlWithSmartCut	(Z)Ljava/net/URL;
    //   560: iconst_0
    //   561: invokespecial 1578	qoe:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;Ljava/net/URL;Z)V
    //   564: aload_1
    //   565: getfield 2868	omx:jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   568: aload_0
    //   569: invokevirtual 2657	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setOnLongClickListener	(Landroid/view/View$OnLongClickListener;)V
    //   572: aload_1
    //   573: getfield 2868	omx:jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   576: aload_1
    //   577: invokevirtual 2877	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setTag	(Ljava/lang/Object;)V
    //   580: aload_1
    //   581: getfield 2876	omx:jdField_f_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   584: iconst_0
    //   585: invokevirtual 1522	android/widget/TextView:setVisibility	(I)V
    //   588: aload_1
    //   589: getfield 2876	omx:jdField_f_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   592: invokevirtual 2784	android/widget/TextView:clearAnimation	()V
    //   595: aload_1
    //   596: getfield 2878	omx:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup	Lcom/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup;
    //   599: fconst_1
    //   600: aload 4
    //   602: getfield 815	qht:jdField_c_of_type_Int	I
    //   605: aload 4
    //   607: getfield 818	qht:jdField_d_of_type_Int	I
    //   610: invokestatic 2663	obj:a	(II)F
    //   613: invokevirtual 2669	com/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup:setCustomSize	(FF)V
    //   616: aload_1
    //   617: getfield 2878	omx:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup	Lcom/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup;
    //   620: aload_1
    //   621: invokevirtual 2670	com/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup:setTag	(Ljava/lang/Object;)V
    //   624: aload_0
    //   625: aload_0
    //   626: getfield 138	qoe:jdField_c_of_type_Int	I
    //   629: aload_2
    //   630: getfield 1045	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mArticleID	J
    //   633: invokevirtual 2672	qoe:b	(IJ)Z
    //   636: ifeq +23 -> 659
    //   639: aload_1
    //   640: getfield 2879	omx:jdField_f_of_type_AndroidViewView	Landroid/view/View;
    //   643: aload_0
    //   644: getfield 236	qoe:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   647: invokevirtual 1479	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   650: ldc_w 2675
    //   653: invokevirtual 2638	android/content/res/Resources:getColor	(I)I
    //   656: invokevirtual 2678	android/view/View:setBackgroundColor	(I)V
    //   659: aload_2
    //   660: getfield 673	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mXGFileSize	J
    //   663: lconst_0
    //   664: lcmp
    //   665: ifgt +262 -> 927
    //   668: aload_1
    //   669: getfield 2880	omx:g	Landroid/widget/TextView;
    //   672: ldc_w 2881
    //   675: invokestatic 1535	ajjy:a	(I)Ljava/lang/String;
    //   678: invokevirtual 2604	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   681: aload_0
    //   682: getfield 236	qoe:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   685: invokestatic 1155	badq:h	(Landroid/content/Context;)Z
    //   688: ifeq +278 -> 966
    //   691: aload_1
    //   692: getfield 2882	omx:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   695: iconst_0
    //   696: invokevirtual 1548	android/widget/ImageView:setVisibility	(I)V
    //   699: aload_1
    //   700: getfield 2880	omx:g	Landroid/widget/TextView;
    //   703: bipush 8
    //   705: invokevirtual 1522	android/widget/TextView:setVisibility	(I)V
    //   708: aload_1
    //   709: getfield 2883	omx:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   712: iconst_0
    //   713: invokevirtual 1492	android/view/View:setVisibility	(I)V
    //   716: aload_1
    //   717: getfield 2884	omx:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   720: iconst_0
    //   721: invokevirtual 2678	android/view/View:setBackgroundColor	(I)V
    //   724: return
    //   725: aload_1
    //   726: getfield 2809	omx:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   729: invokevirtual 1580	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   732: astore 4
    //   734: aload 4
    //   736: aload_0
    //   737: getfield 236	qoe:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   740: ldc_w 2885
    //   743: invokestatic 2815	azvv:a	(Landroid/content/Context;F)I
    //   746: putfield 1597	android/view/ViewGroup$LayoutParams:height	I
    //   749: aload_1
    //   750: getfield 2809	omx:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   753: aload 4
    //   755: invokevirtual 1610	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   758: goto -687 -> 71
    //   761: aload_1
    //   762: getfield 2809	omx:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   765: new 598	android/graphics/drawable/ColorDrawable
    //   768: dup
    //   769: ldc_w 2886
    //   772: invokespecial 601	android/graphics/drawable/ColorDrawable:<init>	(I)V
    //   775: invokevirtual 2887	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   778: goto -676 -> 102
    //   781: astore 4
    //   783: invokestatic 330	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   786: ifeq -684 -> 102
    //   789: ldc_w 332
    //   792: iconst_2
    //   793: ldc_w 2889
    //   796: aload 4
    //   798: invokestatic 2892	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   801: goto -699 -> 102
    //   804: new 598	android/graphics/drawable/ColorDrawable
    //   807: dup
    //   808: ldc_w 2886
    //   811: invokespecial 601	android/graphics/drawable/ColorDrawable:<init>	(I)V
    //   814: astore 4
    //   816: goto -693 -> 123
    //   819: astore 4
    //   821: invokestatic 330	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   824: ifeq +15 -> 839
    //   827: ldc_w 332
    //   830: iconst_2
    //   831: ldc_w 2894
    //   834: aload 4
    //   836: invokestatic 2892	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   839: aload_1
    //   840: getfield 2825	omx:jdField_a_of_type_AndroidViewViewGroup	Landroid/view/ViewGroup;
    //   843: new 598	android/graphics/drawable/ColorDrawable
    //   846: dup
    //   847: ldc_w 2886
    //   850: invokespecial 601	android/graphics/drawable/ColorDrawable:<init>	(I)V
    //   853: invokevirtual 2830	android/view/ViewGroup:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   856: goto -724 -> 132
    //   859: astore 4
    //   861: aload 4
    //   863: invokevirtual 2895	java/net/MalformedURLException:printStackTrace	()V
    //   866: goto -714 -> 152
    //   869: aload_1
    //   870: getfield 2845	omx:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   873: iconst_0
    //   874: invokevirtual 1522	android/widget/TextView:setVisibility	(I)V
    //   877: goto -554 -> 323
    //   880: aload_1
    //   881: getfield 2875	omx:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   884: iconst_0
    //   885: invokevirtual 1522	android/widget/TextView:setVisibility	(I)V
    //   888: aload_1
    //   889: getfield 2875	omx:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   892: new 830	java/lang/StringBuilder
    //   895: dup
    //   896: invokespecial 831	java/lang/StringBuilder:<init>	()V
    //   899: aload_2
    //   900: getfield 2874	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mVideoPlayCount	I
    //   903: invokestatic 2897	qcn:c	(I)Ljava/lang/String;
    //   906: invokevirtual 835	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   909: ldc_w 2898
    //   912: invokestatic 1535	ajjy:a	(I)Ljava/lang/String;
    //   915: invokevirtual 835	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   918: invokevirtual 841	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   921: invokevirtual 2604	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   924: goto -404 -> 520
    //   927: aload_1
    //   928: getfield 2880	omx:g	Landroid/widget/TextView;
    //   931: new 830	java/lang/StringBuilder
    //   934: dup
    //   935: invokespecial 831	java/lang/StringBuilder:<init>	()V
    //   938: aload_2
    //   939: getfield 673	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mXGFileSize	J
    //   942: invokestatic 2689	qcn:b	(J)Ljava/lang/String;
    //   945: invokevirtual 835	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   948: ldc_w 2899
    //   951: invokestatic 1535	ajjy:a	(I)Ljava/lang/String;
    //   954: invokevirtual 835	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   957: invokevirtual 841	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   960: invokevirtual 2604	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   963: goto -282 -> 681
    //   966: aload_1
    //   967: getfield 2882	omx:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   970: bipush 8
    //   972: invokevirtual 1548	android/widget/ImageView:setVisibility	(I)V
    //   975: aload_0
    //   976: getfield 236	qoe:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   979: invokevirtual 1479	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   982: ldc_w 2691
    //   985: invokevirtual 2694	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   988: astore 4
    //   990: aload_1
    //   991: getfield 2880	omx:g	Landroid/widget/TextView;
    //   994: aload 4
    //   996: aconst_null
    //   997: aconst_null
    //   998: aconst_null
    //   999: invokevirtual 2698	android/widget/TextView:setCompoundDrawablesWithIntrinsicBounds	(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V
    //   1002: aload_1
    //   1003: getfield 2880	omx:g	Landroid/widget/TextView;
    //   1006: ldc_w 2699
    //   1009: aload_0
    //   1010: getfield 236	qoe:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   1013: invokevirtual 1479	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   1016: invokestatic 586	aciy:a	(FLandroid/content/res/Resources;)I
    //   1019: invokevirtual 2702	android/widget/TextView:setCompoundDrawablePadding	(I)V
    //   1022: aload_1
    //   1023: getfield 2880	omx:g	Landroid/widget/TextView;
    //   1026: iconst_0
    //   1027: invokevirtual 1522	android/widget/TextView:setVisibility	(I)V
    //   1030: invokestatic 2705	bati:a	()I
    //   1033: iconst_1
    //   1034: if_icmpne +42 -> 1076
    //   1037: aload_1
    //   1038: getfield 2880	omx:g	Landroid/widget/TextView;
    //   1041: ldc_w 2900
    //   1044: invokestatic 1535	ajjy:a	(I)Ljava/lang/String;
    //   1047: invokevirtual 2604	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   1050: aload_1
    //   1051: getfield 2901	omx:h	Landroid/widget/TextView;
    //   1054: bipush 8
    //   1056: invokevirtual 1522	android/widget/TextView:setVisibility	(I)V
    //   1059: aload_1
    //   1060: getfield 2883	omx:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   1063: iconst_0
    //   1064: invokevirtual 1492	android/view/View:setVisibility	(I)V
    //   1067: aload_1
    //   1068: getfield 2884	omx:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   1071: iconst_0
    //   1072: invokevirtual 2678	android/view/View:setBackgroundColor	(I)V
    //   1075: return
    //   1076: invokestatic 2710	bgmq:v	()Z
    //   1079: ifeq +296 -> 1375
    //   1082: aload_0
    //   1083: getfield 2711	qoe:jdField_h_of_type_Boolean	Z
    //   1086: ifne +289 -> 1375
    //   1089: aload_1
    //   1090: getfield 2869	omx:jdField_a_of_type_Int	I
    //   1093: ifne +282 -> 1375
    //   1096: invokestatic 2713	bgmq:d	()Ljava/lang/String;
    //   1099: astore 5
    //   1101: invokestatic 2715	bgmq:e	()Ljava/lang/String;
    //   1104: astore 6
    //   1106: invokestatic 2717	bgmq:f	()Ljava/lang/String;
    //   1109: astore 7
    //   1111: aload 5
    //   1113: invokestatic 423	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1116: ifne +217 -> 1333
    //   1119: invokestatic 2719	obz:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1122: astore 8
    //   1124: ldc_w 911
    //   1127: astore 4
    //   1129: aload 8
    //   1131: ifnull +10 -> 1141
    //   1134: aload 8
    //   1136: invokevirtual 2722	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1139: astore 4
    //   1141: new 1243	qmv
    //   1144: dup
    //   1145: aconst_null
    //   1146: aconst_null
    //   1147: aconst_null
    //   1148: aconst_null
    //   1149: invokespecial 1246	qmv:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1152: aload 4
    //   1154: invokevirtual 2725	qmv:l	(Ljava/lang/String;)Lqmv;
    //   1157: aload_2
    //   1158: getfield 774	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:innerUniqueID	Ljava/lang/String;
    //   1161: invokevirtual 2727	qmv:h	(Ljava/lang/String;)Lqmv;
    //   1164: invokevirtual 1269	qmv:a	()Lqmu;
    //   1167: invokevirtual 1273	qmu:a	()Ljava/lang/String;
    //   1170: astore_2
    //   1171: aload_1
    //   1172: getfield 2901	omx:h	Landroid/widget/TextView;
    //   1175: iconst_0
    //   1176: invokevirtual 1522	android/widget/TextView:setVisibility	(I)V
    //   1179: aload_1
    //   1180: getfield 2901	omx:h	Landroid/widget/TextView;
    //   1183: fconst_2
    //   1184: aload_0
    //   1185: getfield 236	qoe:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   1188: invokevirtual 1479	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   1191: invokestatic 586	aciy:a	(FLandroid/content/res/Resources;)I
    //   1194: invokevirtual 2702	android/widget/TextView:setCompoundDrawablePadding	(I)V
    //   1197: aload_0
    //   1198: getfield 236	qoe:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   1201: invokevirtual 1479	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   1204: ldc_w 2728
    //   1207: invokevirtual 2694	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   1210: astore 4
    //   1212: aload 4
    //   1214: iconst_0
    //   1215: iconst_0
    //   1216: ldc_w 2729
    //   1219: aload_0
    //   1220: getfield 236	qoe:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   1223: invokevirtual 1479	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   1226: invokestatic 586	aciy:a	(FLandroid/content/res/Resources;)I
    //   1229: ldc_w 2729
    //   1232: aload_0
    //   1233: getfield 236	qoe:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   1236: invokevirtual 1479	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   1239: invokestatic 586	aciy:a	(FLandroid/content/res/Resources;)I
    //   1242: invokevirtual 2735	android/graphics/drawable/Drawable:setBounds	(IIII)V
    //   1245: aload_1
    //   1246: getfield 2901	omx:h	Landroid/widget/TextView;
    //   1249: aconst_null
    //   1250: aconst_null
    //   1251: aload 4
    //   1253: aconst_null
    //   1254: invokevirtual 2738	android/widget/TextView:setCompoundDrawables	(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V
    //   1257: aload_0
    //   1258: getfield 236	qoe:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   1261: aload_1
    //   1262: getfield 2901	omx:h	Landroid/widget/TextView;
    //   1265: aload 6
    //   1267: aload 7
    //   1269: aload 5
    //   1271: new 2903	qpf
    //   1274: dup
    //   1275: aload_0
    //   1276: aload_2
    //   1277: invokespecial 2904	qpf:<init>	(Lqoe;Ljava/lang/String;)V
    //   1280: invokestatic 2744	qcn:b	(Landroid/content/Context;Landroid/widget/TextView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/view/View$OnClickListener;)V
    //   1283: aload_1
    //   1284: getfield 2884	omx:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   1287: ldc_w 2745
    //   1290: invokevirtual 2678	android/view/View:setBackgroundColor	(I)V
    //   1293: aload_1
    //   1294: getfield 2883	omx:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   1297: iconst_0
    //   1298: invokevirtual 1492	android/view/View:setVisibility	(I)V
    //   1301: aload_0
    //   1302: iconst_1
    //   1303: putfield 2711	qoe:jdField_h_of_type_Boolean	Z
    //   1306: aconst_null
    //   1307: ldc_w 911
    //   1310: ldc_w 2747
    //   1313: ldc_w 2747
    //   1316: iconst_0
    //   1317: iconst_0
    //   1318: ldc_w 911
    //   1321: ldc_w 911
    //   1324: ldc_w 911
    //   1327: aload_2
    //   1328: iconst_0
    //   1329: invokestatic 1282	ndn:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   1332: return
    //   1333: aload_1
    //   1334: getfield 2901	omx:h	Landroid/widget/TextView;
    //   1337: bipush 8
    //   1339: invokevirtual 1522	android/widget/TextView:setVisibility	(I)V
    //   1342: aload_1
    //   1343: getfield 2883	omx:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   1346: iconst_0
    //   1347: invokevirtual 1492	android/view/View:setVisibility	(I)V
    //   1350: aload_1
    //   1351: getfield 2884	omx:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   1354: iconst_0
    //   1355: invokevirtual 2678	android/view/View:setBackgroundColor	(I)V
    //   1358: invokestatic 330	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1361: ifeq -1357 -> 4
    //   1364: ldc_w 985
    //   1367: iconst_2
    //   1368: ldc_w 2749
    //   1371: invokestatic 990	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1374: return
    //   1375: aload_1
    //   1376: getfield 2901	omx:h	Landroid/widget/TextView;
    //   1379: bipush 8
    //   1381: invokevirtual 1522	android/widget/TextView:setVisibility	(I)V
    //   1384: aload_1
    //   1385: getfield 2883	omx:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   1388: iconst_0
    //   1389: invokevirtual 1492	android/view/View:setVisibility	(I)V
    //   1392: aload_1
    //   1393: getfield 2884	omx:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   1396: iconst_0
    //   1397: invokevirtual 2678	android/view/View:setBackgroundColor	(I)V
    //   1400: return
    //   1401: astore 4
    //   1403: goto -1033 -> 370
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1406	0	this	qoe
    //   0	1406	1	paramomx	omx
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
  
  public void a(omy paramomy, BaseArticleInfo paramBaseArticleInfo)
  {
    long l2 = 0L;
    paramomy.jdField_f_of_type_AndroidViewView.setOnClickListener(null);
    paramomy.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = paramBaseArticleInfo;
    paramomy.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = ((BaseArticleInfo)paramBaseArticleInfo.mSubArtilceList.get(0));
    paramomy.jdField_a_of_type_AndroidViewView.setBackgroundColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131101537));
    paramBaseArticleInfo = paramomy.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
    a(paramBaseArticleInfo, paramomy.jdField_c_of_type_AndroidWidgetTextView, paramomy.jdField_b_of_type_AndroidViewView, paramomy.jdField_a_of_type_AndroidWidgetTextView, paramomy.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView);
    paramomy.jdField_c_of_type_AndroidWidgetTextView.setText(paramBaseArticleInfo.mTitle);
    paramomy.jdField_c_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
    paramomy.jdField_d_of_type_AndroidWidgetTextView.setText(qcn.c(paramBaseArticleInfo.mVideoPlayCount));
    a(paramomy.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, paramomy.jdField_a_of_type_AndroidWidgetImageView, paramBaseArticleInfo, false);
    paramomy.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setTag(paramomy);
    paramomy.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setOnClickListener(this);
    paramomy.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setTag(paramBaseArticleInfo);
    qcn.a(paramBaseArticleInfo.mVideoArticleSubsText, paramBaseArticleInfo.mVideoArticleSubsColor, paramomy.jdField_e_of_type_AndroidWidgetTextView);
    if ((paramBaseArticleInfo.isAccountShown) && (this.jdField_c_of_type_Int == 0) && (paramBaseArticleInfo.mPartnerAccountInfo != null))
    {
      paramomy.jdField_d_of_type_AndroidViewView.setVisibility(0);
      paramomy.jdField_d_of_type_AndroidViewView.setTag(paramBaseArticleInfo);
      if (!paramBaseArticleInfo.mPartnerAccountInfo.uint64_uin.has()) {
        break label636;
      }
    }
    label296:
    label581:
    label636:
    for (long l1 = paramBaseArticleInfo.mPartnerAccountInfo.uint64_uin.get();; l1 = 0L)
    {
      paramomy.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setHeadImgByUin(l1);
      paramomy.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setTag(paramBaseArticleInfo);
      obz.a(paramomy.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView, 10, 10, 10, 10);
      paramBaseArticleInfo = obz.a(paramBaseArticleInfo.mPartnerAccountInfo.bytes_v_icon_url);
      if (!TextUtils.isEmpty(paramBaseArticleInfo)) {}
      try
      {
        paramBaseArticleInfo = new URL(paramBaseArticleInfo);
        paramomy.jdField_d_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.a(paramBaseArticleInfo);
        paramomy.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setNickNameByUin(l1);
        paramomy.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
        paramomy.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setOnClickListener(this);
        for (;;)
        {
          paramBaseArticleInfo = paramomy.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
          paramBaseArticleInfo.isTwoItem = true;
          a(paramBaseArticleInfo, paramomy.jdField_f_of_type_AndroidWidgetTextView, paramomy.jdField_c_of_type_AndroidViewView, paramomy.jdField_b_of_type_AndroidWidgetTextView, paramomy.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView);
          paramomy.jdField_f_of_type_AndroidWidgetTextView.setText(paramBaseArticleInfo.mTitle);
          paramomy.jdField_f_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
          paramomy.g.setText(qcn.c(paramBaseArticleInfo.mVideoPlayCount));
          a(paramomy.jdField_e_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, paramomy.jdField_b_of_type_AndroidWidgetImageView, paramBaseArticleInfo, false);
          paramomy.jdField_e_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setTag(paramomy);
          paramomy.jdField_e_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setOnClickListener(this);
          paramomy.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setTag(paramBaseArticleInfo);
          qcn.a(paramBaseArticleInfo.mVideoArticleSubsText, paramBaseArticleInfo.mVideoArticleSubsColor, paramomy.h);
          if ((paramBaseArticleInfo.isAccountShown) && (this.jdField_c_of_type_Int == 0) && (paramBaseArticleInfo.mPartnerAccountInfo != null))
          {
            paramomy.jdField_e_of_type_AndroidViewView.setVisibility(0);
            paramomy.jdField_e_of_type_AndroidViewView.setTag(paramBaseArticleInfo);
            l1 = l2;
            if (paramBaseArticleInfo.mPartnerAccountInfo != null)
            {
              l1 = l2;
              if (paramBaseArticleInfo.mPartnerAccountInfo.uint64_uin.has()) {
                l1 = paramBaseArticleInfo.mPartnerAccountInfo.uint64_uin.get();
              }
            }
            paramomy.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setHeadImgByUin(l1);
            paramomy.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setTag(paramBaseArticleInfo);
            obz.a(paramomy.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView, 10, 10, 10, 10);
            paramBaseArticleInfo = obz.a(paramBaseArticleInfo.mPartnerAccountInfo.bytes_v_icon_url);
            if (TextUtils.isEmpty(paramBaseArticleInfo)) {}
          }
          try
          {
            paramBaseArticleInfo = new URL(paramBaseArticleInfo);
            paramomy.jdField_f_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.a(paramBaseArticleInfo);
            paramomy.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setNickNameByUin(l1);
            paramomy.jdField_e_of_type_AndroidViewView.setOnClickListener(this);
            paramomy.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setOnClickListener(this);
            return;
            paramomy.jdField_d_of_type_AndroidViewView.setVisibility(8);
            continue;
            paramomy.jdField_e_of_type_AndroidViewView.setVisibility(8);
            return;
          }
          catch (Exception paramBaseArticleInfo)
          {
            break label581;
          }
        }
      }
      catch (Exception paramBaseArticleInfo)
      {
        break label296;
      }
    }
  }
  
  /* Error */
  public void a(omz paramomz, BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aload_1
    //   6: aload_2
    //   7: invokestatic 2996	qoe:a	(Lomz;Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)V
    //   10: aload_1
    //   11: getfield 1753	omz:jdField_a_of_type_Qht	Lqht;
    //   14: astore 4
    //   16: aload_1
    //   17: getfield 2997	omz:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   20: aload_2
    //   21: getfield 867	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mTitle	Ljava/lang/String;
    //   24: invokevirtual 2604	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   27: aload_1
    //   28: getfield 2997	omz:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   31: invokevirtual 2627	android/widget/TextView:getPaint	()Landroid/text/TextPaint;
    //   34: iconst_1
    //   35: invokevirtual 2632	android/text/TextPaint:setFakeBoldText	(Z)V
    //   38: aload_1
    //   39: getfield 2997	omz:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   42: aload_0
    //   43: getfield 236	qoe:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   46: invokevirtual 1479	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   49: ldc_w 2633
    //   52: invokevirtual 2638	android/content/res/Resources:getColor	(I)I
    //   55: invokevirtual 2618	android/widget/TextView:setTextColor	(I)V
    //   58: invokestatic 3002	qzk:a	()Lqzk;
    //   61: invokevirtual 3003	qzk:b	()Z
    //   64: ifeq +75 -> 139
    //   67: aload_1
    //   68: getfield 3004	omz:jdField_a_of_type_Boolean	Z
    //   71: ifne +20 -> 91
    //   74: aload_1
    //   75: getfield 3006	omz:jdField_c_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   78: bipush 8
    //   80: invokevirtual 1548	android/widget/ImageView:setVisibility	(I)V
    //   83: aload_1
    //   84: getfield 3007	omz:jdField_b_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   87: iconst_0
    //   88: invokevirtual 1548	android/widget/ImageView:setVisibility	(I)V
    //   91: aload_2
    //   92: getfield 3011	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:fusionBiuInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/FusionBiuInfo;
    //   95: ifnull +694 -> 789
    //   98: aload_1
    //   99: getfield 3007	omz:jdField_b_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   102: astore 5
    //   104: aload_2
    //   105: getfield 3011	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:fusionBiuInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/FusionBiuInfo;
    //   108: getfield 3014	com/tencent/biz/pubaccount/readinjoy/struct/FusionBiuInfo:jdField_b_of_type_Boolean	Z
    //   111: ifeq +671 -> 782
    //   114: ldc_w 3015
    //   117: istore_3
    //   118: aload 5
    //   120: iload_3
    //   121: invokevirtual 3018	android/widget/ImageView:setImageResource	(I)V
    //   124: aload_1
    //   125: instanceof 3020
    //   128: ifne +11 -> 139
    //   131: aload_2
    //   132: getfield 3011	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:fusionBiuInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/FusionBiuInfo;
    //   135: iconst_1
    //   136: putfield 3021	com/tencent/biz/pubaccount/readinjoy/struct/FusionBiuInfo:jdField_c_of_type_Boolean	Z
    //   139: aload_2
    //   140: getfield 2874	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mVideoPlayCount	I
    //   143: ifne +659 -> 802
    //   146: aload_1
    //   147: getfield 3022	omz:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   150: bipush 8
    //   152: invokevirtual 1522	android/widget/TextView:setVisibility	(I)V
    //   155: aload_1
    //   156: getfield 3023	omz:jdField_b_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   159: aload 4
    //   161: getfield 645	qht:jdField_b_of_type_Int	I
    //   164: invokestatic 2643	obj:a	(I)Ljava/lang/String;
    //   167: invokevirtual 2604	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   170: aload_0
    //   171: aload_1
    //   172: getfield 3024	omz:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyNickNameTextView;
    //   175: aload_2
    //   176: aload_2
    //   177: invokestatic 493	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:isAdvertisementInfo	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Z
    //   180: invokespecial 3026	qoe:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyNickNameTextView;Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;Z)V
    //   183: aload_0
    //   184: aload_1
    //   185: getfield 3027	omz:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyHeadImageView;
    //   188: aload_2
    //   189: invokespecial 3029	qoe:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyHeadImageView;Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)V
    //   192: aload_1
    //   193: getfield 3027	omz:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyHeadImageView;
    //   196: aload_2
    //   197: invokevirtual 1700	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:getSubscribeName	()Ljava/lang/String;
    //   200: invokevirtual 3032	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyHeadImageView:setContentDescription	(Ljava/lang/CharSequence;)V
    //   203: aload_1
    //   204: getfield 3024	omz:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyNickNameTextView;
    //   207: iconst_0
    //   208: invokevirtual 3033	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyNickNameTextView:setVisibility	(I)V
    //   211: aload_1
    //   212: getfield 3024	omz:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyNickNameTextView;
    //   215: aload_2
    //   216: invokevirtual 1700	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:getSubscribeName	()Ljava/lang/String;
    //   219: invokevirtual 3034	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyNickNameTextView:setContentDescription	(Ljava/lang/CharSequence;)V
    //   222: aload_1
    //   223: getfield 3035	omz:jdField_a_of_type_AndroidViewViewGroup	Landroid/view/ViewGroup;
    //   226: aload_2
    //   227: invokevirtual 2865	android/view/ViewGroup:setTag	(Ljava/lang/Object;)V
    //   230: aload_1
    //   231: getfield 3035	omz:jdField_a_of_type_AndroidViewViewGroup	Landroid/view/ViewGroup;
    //   234: aload_0
    //   235: invokevirtual 3036	android/view/ViewGroup:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   238: aload_2
    //   239: getfield 2767	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:vIconUrl	Ljava/lang/String;
    //   242: invokestatic 423	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   245: ifne +614 -> 859
    //   248: new 1134	java/net/URL
    //   251: dup
    //   252: aload_2
    //   253: getfield 2767	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:vIconUrl	Ljava/lang/String;
    //   256: invokespecial 1503	java/net/URL:<init>	(Ljava/lang/String;)V
    //   259: astore 5
    //   261: aload_1
    //   262: getfield 3037	omz:jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   265: aload 5
    //   267: invokevirtual 2610	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:a	(Ljava/net/URL;)Lcom/tencent/biz/pubaccount/readinjoy/view/imageloader/ZImageView;
    //   270: pop
    //   271: aload_1
    //   272: getfield 3037	omz:jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   275: iconst_0
    //   276: invokevirtual 1521	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setVisibility	(I)V
    //   279: aload_2
    //   280: invokestatic 493	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:isAdvertisementInfo	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Z
    //   283: ifeq +719 -> 1002
    //   286: aload_2
    //   287: checkcast 490	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo
    //   290: astore 5
    //   292: aload_1
    //   293: getfield 1737	omz:h	Landroid/widget/TextView;
    //   296: iconst_0
    //   297: invokevirtual 1522	android/widget/TextView:setVisibility	(I)V
    //   300: aload_1
    //   301: getfield 1737	omz:h	Landroid/widget/TextView;
    //   304: ldc_w 3039
    //   307: invokestatic 127	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   310: aload_0
    //   311: getfield 236	qoe:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   314: invokestatic 3042	npj:a	(ILandroid/content/Context;)Landroid/graphics/drawable/ShapeDrawable;
    //   317: invokestatic 3047	nzq:a	(Landroid/view/View;Landroid/graphics/drawable/Drawable;)V
    //   320: aload_2
    //   321: getfield 2753	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mArticleSubscriptText	Ljava/lang/String;
    //   324: invokestatic 423	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   327: ifne +544 -> 871
    //   330: aload_1
    //   331: getfield 1737	omz:h	Landroid/widget/TextView;
    //   334: aload_2
    //   335: getfield 2753	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mArticleSubscriptText	Ljava/lang/String;
    //   338: invokevirtual 2604	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   341: aload_1
    //   342: getfield 3050	omz:jdField_b_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   345: iconst_0
    //   346: invokevirtual 3053	android/widget/LinearLayout:setVisibility	(I)V
    //   349: aload_2
    //   350: invokestatic 1649	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:isAppAdvertisementInfo	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Z
    //   353: ifeq +580 -> 933
    //   356: iconst_0
    //   357: istore_3
    //   358: new 1013	org/json/JSONObject
    //   361: dup
    //   362: aload 5
    //   364: getfield 1652	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdExt	Ljava/lang/String;
    //   367: invokespecial 1653	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   370: astore 6
    //   372: aload_0
    //   373: getfield 236	qoe:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   376: aload 6
    //   378: ldc_w 3055
    //   381: invokevirtual 3058	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   384: invokestatic 3063	bady:a	(Landroid/content/Context;Ljava/lang/String;)Z
    //   387: ifeq +504 -> 891
    //   390: aload_1
    //   391: getfield 1734	omz:i	Landroid/widget/TextView;
    //   394: aload_0
    //   395: getfield 236	qoe:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   398: ldc_w 3064
    //   401: invokevirtual 2357	android/app/Activity:getString	(I)Ljava/lang/String;
    //   404: invokevirtual 2604	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   407: iconst_1
    //   408: istore_3
    //   409: aload 5
    //   411: getfield 3067	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdBtnTxt	Ljava/lang/String;
    //   414: invokestatic 423	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   417: ifne +19 -> 436
    //   420: iload_3
    //   421: ifne +15 -> 436
    //   424: aload_1
    //   425: getfield 1734	omz:i	Landroid/widget/TextView;
    //   428: aload 5
    //   430: getfield 3067	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdBtnTxt	Ljava/lang/String;
    //   433: invokevirtual 2604	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   436: new 1013	org/json/JSONObject
    //   439: dup
    //   440: aload 5
    //   442: getfield 3070	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdExtInfo	Ljava/lang/String;
    //   445: invokespecial 1653	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   448: astore 5
    //   450: aload 5
    //   452: ldc_w 3072
    //   455: invokevirtual 3058	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   458: invokestatic 423	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   461: ifne +18 -> 479
    //   464: aload_1
    //   465: getfield 1737	omz:h	Landroid/widget/TextView;
    //   468: aload 5
    //   470: ldc_w 3072
    //   473: invokevirtual 3058	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   476: invokevirtual 2604	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   479: aload_0
    //   480: aload_1
    //   481: invokespecial 3074	qoe:a	(Lomz;)V
    //   484: aload_1
    //   485: getfield 3077	omz:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyVideoInfoViewGroup	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyVideoInfoViewGroup;
    //   488: bipush 8
    //   490: invokevirtual 3080	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyVideoInfoViewGroup:setVisibility	(I)V
    //   493: aload_1
    //   494: getfield 3082	omz:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   497: bipush 8
    //   499: invokevirtual 3053	android/widget/LinearLayout:setVisibility	(I)V
    //   502: aload_0
    //   503: getfield 236	qoe:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   506: aload_1
    //   507: getfield 1748	omz:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   510: aload_1
    //   511: getfield 1753	omz:jdField_a_of_type_Qht	Lqht;
    //   514: invokestatic 2653	oms:a	(Landroid/content/Context;Landroid/widget/ImageView;Lqht;)V
    //   517: aload_0
    //   518: aload_1
    //   519: getfield 1748	omz:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   522: aload_2
    //   523: iconst_0
    //   524: invokevirtual 1061	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:getVideoCoverUrlWithSmartCut	(Z)Ljava/net/URL;
    //   527: iconst_0
    //   528: invokespecial 1578	qoe:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;Ljava/net/URL;Z)V
    //   531: aload_1
    //   532: getfield 1748	omz:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   535: aload_0
    //   536: invokevirtual 1520	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   539: aload_1
    //   540: getfield 1748	omz:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   543: aload_0
    //   544: invokevirtual 2657	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setOnLongClickListener	(Landroid/view/View$OnLongClickListener;)V
    //   547: aload_1
    //   548: getfield 1748	omz:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   551: aload_1
    //   552: invokevirtual 2877	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setTag	(Ljava/lang/Object;)V
    //   555: aload_1
    //   556: getfield 3023	omz:jdField_b_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   559: iconst_0
    //   560: invokevirtual 1522	android/widget/TextView:setVisibility	(I)V
    //   563: aload_1
    //   564: getfield 3023	omz:jdField_b_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   567: invokevirtual 2784	android/widget/TextView:clearAnimation	()V
    //   570: aload_1
    //   571: getfield 3083	omz:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup	Lcom/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup;
    //   574: fconst_1
    //   575: aload 4
    //   577: getfield 815	qht:jdField_c_of_type_Int	I
    //   580: aload 4
    //   582: getfield 818	qht:jdField_d_of_type_Int	I
    //   585: invokestatic 2663	obj:a	(II)F
    //   588: invokevirtual 2669	com/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup:setCustomSize	(FF)V
    //   591: aload_1
    //   592: getfield 3083	omz:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup	Lcom/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup;
    //   595: aload_0
    //   596: invokevirtual 3084	com/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   599: aload_1
    //   600: getfield 3083	omz:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup	Lcom/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup;
    //   603: aload_1
    //   604: invokevirtual 2670	com/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup:setTag	(Ljava/lang/Object;)V
    //   607: aload_0
    //   608: aload_0
    //   609: getfield 138	qoe:jdField_c_of_type_Int	I
    //   612: aload_2
    //   613: getfield 1045	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mArticleID	J
    //   616: invokevirtual 2672	qoe:b	(IJ)Z
    //   619: ifeq +23 -> 642
    //   622: aload_1
    //   623: getfield 3085	omz:jdField_f_of_type_AndroidViewView	Landroid/view/View;
    //   626: aload_0
    //   627: getfield 236	qoe:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   630: invokevirtual 1479	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   633: ldc_w 2675
    //   636: invokevirtual 2638	android/content/res/Resources:getColor	(I)I
    //   639: invokevirtual 2678	android/view/View:setBackgroundColor	(I)V
    //   642: aload_1
    //   643: getfield 3088	omz:jdField_a_of_type_AndroidWidgetFrameLayout	Landroid/widget/FrameLayout;
    //   646: aload_0
    //   647: invokevirtual 3091	android/widget/FrameLayout:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   650: aload_1
    //   651: getfield 3088	omz:jdField_a_of_type_AndroidWidgetFrameLayout	Landroid/widget/FrameLayout;
    //   654: aload_1
    //   655: invokevirtual 3092	android/widget/FrameLayout:setTag	(Ljava/lang/Object;)V
    //   658: aload_1
    //   659: getfield 3093	omz:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   662: aload_2
    //   663: invokevirtual 1530	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:getCommentCount	()I
    //   666: ldc_w 3094
    //   669: invokestatic 1535	ajjy:a	(I)Ljava/lang/String;
    //   672: invokestatic 3097	qcn:a	(Landroid/widget/TextView;ILjava/lang/String;)V
    //   675: aload_1
    //   676: getfield 3093	omz:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   679: aload_0
    //   680: invokevirtual 1735	android/widget/TextView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   683: aload_1
    //   684: getfield 3093	omz:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   687: aload_1
    //   688: invokevirtual 1741	android/widget/TextView:setTag	(Ljava/lang/Object;)V
    //   691: aload_1
    //   692: getfield 3098	omz:jdField_a_of_type_AndroidWidgetRelativeLayout	Landroid/widget/RelativeLayout;
    //   695: aload_0
    //   696: invokevirtual 3099	android/widget/RelativeLayout:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   699: aload_1
    //   700: getfield 3098	omz:jdField_a_of_type_AndroidWidgetRelativeLayout	Landroid/widget/RelativeLayout;
    //   703: aload_1
    //   704: invokevirtual 2862	android/widget/RelativeLayout:setTag	(Ljava/lang/Object;)V
    //   707: aload_2
    //   708: getfield 673	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mXGFileSize	J
    //   711: lconst_0
    //   712: lcmp
    //   713: ifgt +406 -> 1119
    //   716: aload_1
    //   717: getfield 3100	omz:jdField_f_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   720: ldc_w 3101
    //   723: invokestatic 1535	ajjy:a	(I)Ljava/lang/String;
    //   726: invokevirtual 2604	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   729: aload_0
    //   730: getfield 236	qoe:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   733: invokestatic 1155	badq:h	(Landroid/content/Context;)Z
    //   736: ifeq +422 -> 1158
    //   739: aload_1
    //   740: getfield 3103	omz:jdField_d_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   743: iconst_0
    //   744: invokevirtual 1548	android/widget/ImageView:setVisibility	(I)V
    //   747: aload_1
    //   748: getfield 3100	omz:jdField_f_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   751: bipush 8
    //   753: invokevirtual 1522	android/widget/TextView:setVisibility	(I)V
    //   756: aload_1
    //   757: getfield 3104	omz:jdField_e_of_type_AndroidViewView	Landroid/view/View;
    //   760: iconst_0
    //   761: invokevirtual 1492	android/view/View:setVisibility	(I)V
    //   764: aload_1
    //   765: getfield 3105	omz:jdField_d_of_type_AndroidViewView	Landroid/view/View;
    //   768: iconst_0
    //   769: invokevirtual 2678	android/view/View:setBackgroundColor	(I)V
    //   772: aload_1
    //   773: getfield 3106	omz:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   776: bipush 8
    //   778: invokevirtual 1492	android/view/View:setVisibility	(I)V
    //   781: return
    //   782: ldc_w 3107
    //   785: istore_3
    //   786: goto -668 -> 118
    //   789: aload_1
    //   790: getfield 3007	omz:jdField_b_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   793: ldc_w 3107
    //   796: invokevirtual 3018	android/widget/ImageView:setImageResource	(I)V
    //   799: goto -660 -> 139
    //   802: aload_1
    //   803: getfield 3022	omz:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   806: iconst_0
    //   807: invokevirtual 1522	android/widget/TextView:setVisibility	(I)V
    //   810: aload_1
    //   811: getfield 3022	omz:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   814: new 830	java/lang/StringBuilder
    //   817: dup
    //   818: invokespecial 831	java/lang/StringBuilder:<init>	()V
    //   821: aload_2
    //   822: getfield 2874	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mVideoPlayCount	I
    //   825: invokestatic 2897	qcn:c	(I)Ljava/lang/String;
    //   828: invokevirtual 835	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   831: ldc_w 3108
    //   834: invokestatic 1535	ajjy:a	(I)Ljava/lang/String;
    //   837: invokevirtual 835	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   840: invokevirtual 841	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   843: invokevirtual 2604	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   846: goto -691 -> 155
    //   849: astore 5
    //   851: aload 5
    //   853: invokevirtual 2686	java/lang/Exception:printStackTrace	()V
    //   856: goto -577 -> 279
    //   859: aload_1
    //   860: getfield 3037	omz:jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   863: bipush 8
    //   865: invokevirtual 1521	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setVisibility	(I)V
    //   868: goto -589 -> 279
    //   871: aload_1
    //   872: getfield 1737	omz:h	Landroid/widget/TextView;
    //   875: aload_0
    //   876: getfield 236	qoe:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   879: ldc_w 3109
    //   882: invokevirtual 2357	android/app/Activity:getString	(I)Ljava/lang/String;
    //   885: invokevirtual 2604	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   888: goto -547 -> 341
    //   891: aload_1
    //   892: getfield 1734	omz:i	Landroid/widget/TextView;
    //   895: aload_0
    //   896: getfield 236	qoe:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   899: ldc_w 3110
    //   902: invokevirtual 2357	android/app/Activity:getString	(I)Ljava/lang/String;
    //   905: invokevirtual 2604	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   908: goto -499 -> 409
    //   911: astore 6
    //   913: aload_1
    //   914: getfield 1734	omz:i	Landroid/widget/TextView;
    //   917: aload_0
    //   918: getfield 236	qoe:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   921: ldc_w 3111
    //   924: invokevirtual 2357	android/app/Activity:getString	(I)Ljava/lang/String;
    //   927: invokevirtual 2604	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   930: goto -521 -> 409
    //   933: aload 5
    //   935: getfield 3067	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdBtnTxt	Ljava/lang/String;
    //   938: invokestatic 423	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   941: ifne +18 -> 959
    //   944: aload_1
    //   945: getfield 1734	omz:i	Landroid/widget/TextView;
    //   948: aload 5
    //   950: getfield 3067	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdBtnTxt	Ljava/lang/String;
    //   953: invokevirtual 2604	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   956: goto -520 -> 436
    //   959: aload_1
    //   960: getfield 1734	omz:i	Landroid/widget/TextView;
    //   963: aload_0
    //   964: getfield 236	qoe:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   967: ldc_w 3111
    //   970: invokevirtual 2357	android/app/Activity:getString	(I)Ljava/lang/String;
    //   973: invokevirtual 2604	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   976: goto -540 -> 436
    //   979: astore 5
    //   981: invokestatic 330	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   984: ifeq -505 -> 479
    //   987: ldc_w 332
    //   990: iconst_2
    //   991: ldc_w 3113
    //   994: aload 5
    //   996: invokestatic 2892	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   999: goto -520 -> 479
    //   1002: aload_1
    //   1003: getfield 1737	omz:h	Landroid/widget/TextView;
    //   1006: bipush 8
    //   1008: invokevirtual 1522	android/widget/TextView:setVisibility	(I)V
    //   1011: aload_1
    //   1012: getfield 3050	omz:jdField_b_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   1015: bipush 8
    //   1017: invokevirtual 3053	android/widget/LinearLayout:setVisibility	(I)V
    //   1020: aload_1
    //   1021: getfield 3077	omz:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyVideoInfoViewGroup	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyVideoInfoViewGroup;
    //   1024: iconst_0
    //   1025: invokevirtual 3080	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyVideoInfoViewGroup:setVisibility	(I)V
    //   1028: aload_1
    //   1029: getfield 3082	omz:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   1032: iconst_0
    //   1033: invokevirtual 3053	android/widget/LinearLayout:setVisibility	(I)V
    //   1036: aload_1
    //   1037: getfield 3077	omz:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyVideoInfoViewGroup	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyVideoInfoViewGroup;
    //   1040: aload_2
    //   1041: aload_0
    //   1042: aload_0
    //   1043: getfield 138	qoe:jdField_c_of_type_Int	I
    //   1046: aload_0
    //   1047: getfield 269	qoe:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   1050: invokevirtual 3117	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyVideoInfoViewGroup:setArticleInfo	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;Landroid/widget/BaseAdapter;ILjava/util/Set;)V
    //   1053: aload_1
    //   1054: getfield 3118	omz:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   1057: aload_0
    //   1058: invokevirtual 1731	android/widget/ImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   1061: aload_1
    //   1062: getfield 3118	omz:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   1065: aload_1
    //   1066: invokevirtual 1742	android/widget/ImageView:setTag	(Ljava/lang/Object;)V
    //   1069: aload_1
    //   1070: getfield 3006	omz:jdField_c_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   1073: ifnull +19 -> 1092
    //   1076: aload_1
    //   1077: getfield 3006	omz:jdField_c_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   1080: aload_0
    //   1081: invokevirtual 1731	android/widget/ImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   1084: aload_1
    //   1085: getfield 3006	omz:jdField_c_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   1088: aload_1
    //   1089: invokevirtual 1742	android/widget/ImageView:setTag	(Ljava/lang/Object;)V
    //   1092: aload_1
    //   1093: getfield 3007	omz:jdField_b_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   1096: aload_0
    //   1097: invokevirtual 1731	android/widget/ImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   1100: aload_1
    //   1101: getfield 3007	omz:jdField_b_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   1104: aload_0
    //   1105: invokevirtual 3119	android/widget/ImageView:setOnLongClickListener	(Landroid/view/View$OnLongClickListener;)V
    //   1108: aload_1
    //   1109: getfield 3007	omz:jdField_b_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   1112: aload_1
    //   1113: invokevirtual 1742	android/widget/ImageView:setTag	(Ljava/lang/Object;)V
    //   1116: goto -614 -> 502
    //   1119: aload_1
    //   1120: getfield 3100	omz:jdField_f_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   1123: new 830	java/lang/StringBuilder
    //   1126: dup
    //   1127: invokespecial 831	java/lang/StringBuilder:<init>	()V
    //   1130: aload_2
    //   1131: getfield 673	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mXGFileSize	J
    //   1134: invokestatic 2689	qcn:b	(J)Ljava/lang/String;
    //   1137: invokevirtual 835	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1140: ldc_w 3120
    //   1143: invokestatic 1535	ajjy:a	(I)Ljava/lang/String;
    //   1146: invokevirtual 835	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1149: invokevirtual 841	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1152: invokevirtual 2604	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   1155: goto -426 -> 729
    //   1158: aload_1
    //   1159: getfield 3103	omz:jdField_d_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   1162: bipush 8
    //   1164: invokevirtual 1548	android/widget/ImageView:setVisibility	(I)V
    //   1167: aload_0
    //   1168: getfield 236	qoe:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   1171: invokevirtual 1479	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   1174: ldc_w 2691
    //   1177: invokevirtual 2694	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   1180: astore 4
    //   1182: aload_1
    //   1183: getfield 3100	omz:jdField_f_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   1186: aload 4
    //   1188: aconst_null
    //   1189: aconst_null
    //   1190: aconst_null
    //   1191: invokevirtual 2698	android/widget/TextView:setCompoundDrawablesWithIntrinsicBounds	(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V
    //   1194: aload_1
    //   1195: getfield 3100	omz:jdField_f_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   1198: ldc_w 2699
    //   1201: aload_0
    //   1202: getfield 236	qoe:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   1205: invokevirtual 1479	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   1208: invokestatic 586	aciy:a	(FLandroid/content/res/Resources;)I
    //   1211: invokevirtual 2702	android/widget/TextView:setCompoundDrawablePadding	(I)V
    //   1214: aload_1
    //   1215: getfield 3100	omz:jdField_f_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   1218: iconst_0
    //   1219: invokevirtual 1522	android/widget/TextView:setVisibility	(I)V
    //   1222: invokestatic 2705	bati:a	()I
    //   1225: iconst_1
    //   1226: if_icmpne +44 -> 1270
    //   1229: aload_1
    //   1230: getfield 3100	omz:jdField_f_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   1233: ldc_w 3121
    //   1236: invokestatic 1535	ajjy:a	(I)Ljava/lang/String;
    //   1239: invokevirtual 2604	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   1242: aload_1
    //   1243: getfield 3122	omz:g	Landroid/widget/TextView;
    //   1246: bipush 8
    //   1248: invokevirtual 1522	android/widget/TextView:setVisibility	(I)V
    //   1251: aload_1
    //   1252: getfield 3104	omz:jdField_e_of_type_AndroidViewView	Landroid/view/View;
    //   1255: iconst_0
    //   1256: invokevirtual 1492	android/view/View:setVisibility	(I)V
    //   1259: aload_1
    //   1260: getfield 3105	omz:jdField_d_of_type_AndroidViewView	Landroid/view/View;
    //   1263: iconst_0
    //   1264: invokevirtual 2678	android/view/View:setBackgroundColor	(I)V
    //   1267: goto -495 -> 772
    //   1270: invokestatic 2710	bgmq:v	()Z
    //   1273: ifeq +300 -> 1573
    //   1276: aload_0
    //   1277: getfield 2711	qoe:jdField_h_of_type_Boolean	Z
    //   1280: ifne +293 -> 1573
    //   1283: aload_1
    //   1284: getfield 1186	omz:jdField_a_of_type_Int	I
    //   1287: ifne +286 -> 1573
    //   1290: invokestatic 2713	bgmq:d	()Ljava/lang/String;
    //   1293: astore 5
    //   1295: invokestatic 2715	bgmq:e	()Ljava/lang/String;
    //   1298: astore 6
    //   1300: invokestatic 2717	bgmq:f	()Ljava/lang/String;
    //   1303: astore 7
    //   1305: aload 5
    //   1307: invokestatic 423	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1310: ifne +219 -> 1529
    //   1313: invokestatic 2719	obz:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1316: astore 8
    //   1318: ldc_w 911
    //   1321: astore 4
    //   1323: aload 8
    //   1325: ifnull +10 -> 1335
    //   1328: aload 8
    //   1330: invokevirtual 2722	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1333: astore 4
    //   1335: new 1243	qmv
    //   1338: dup
    //   1339: aconst_null
    //   1340: aconst_null
    //   1341: aconst_null
    //   1342: aconst_null
    //   1343: invokespecial 1246	qmv:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1346: aload 4
    //   1348: invokevirtual 2725	qmv:l	(Ljava/lang/String;)Lqmv;
    //   1351: aload_2
    //   1352: getfield 774	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:innerUniqueID	Ljava/lang/String;
    //   1355: invokevirtual 2727	qmv:h	(Ljava/lang/String;)Lqmv;
    //   1358: invokevirtual 1269	qmv:a	()Lqmu;
    //   1361: invokevirtual 1273	qmu:a	()Ljava/lang/String;
    //   1364: astore_2
    //   1365: aload_1
    //   1366: getfield 3122	omz:g	Landroid/widget/TextView;
    //   1369: iconst_0
    //   1370: invokevirtual 1522	android/widget/TextView:setVisibility	(I)V
    //   1373: aload_1
    //   1374: getfield 3122	omz:g	Landroid/widget/TextView;
    //   1377: fconst_2
    //   1378: aload_0
    //   1379: getfield 236	qoe:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   1382: invokevirtual 1479	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   1385: invokestatic 586	aciy:a	(FLandroid/content/res/Resources;)I
    //   1388: invokevirtual 2702	android/widget/TextView:setCompoundDrawablePadding	(I)V
    //   1391: aload_0
    //   1392: getfield 236	qoe:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   1395: invokevirtual 1479	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   1398: ldc_w 2728
    //   1401: invokevirtual 2694	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   1404: astore 4
    //   1406: aload 4
    //   1408: iconst_0
    //   1409: iconst_0
    //   1410: ldc_w 2729
    //   1413: aload_0
    //   1414: getfield 236	qoe:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   1417: invokevirtual 1479	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   1420: invokestatic 586	aciy:a	(FLandroid/content/res/Resources;)I
    //   1423: ldc_w 2729
    //   1426: aload_0
    //   1427: getfield 236	qoe:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   1430: invokevirtual 1479	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   1433: invokestatic 586	aciy:a	(FLandroid/content/res/Resources;)I
    //   1436: invokevirtual 2735	android/graphics/drawable/Drawable:setBounds	(IIII)V
    //   1439: aload_1
    //   1440: getfield 3122	omz:g	Landroid/widget/TextView;
    //   1443: aconst_null
    //   1444: aconst_null
    //   1445: aload 4
    //   1447: aconst_null
    //   1448: invokevirtual 2738	android/widget/TextView:setCompoundDrawables	(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V
    //   1451: aload_0
    //   1452: getfield 236	qoe:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   1455: aload_1
    //   1456: getfield 3122	omz:g	Landroid/widget/TextView;
    //   1459: aload 6
    //   1461: aload 7
    //   1463: aload 5
    //   1465: new 3124	qpc
    //   1468: dup
    //   1469: aload_0
    //   1470: aload_2
    //   1471: invokespecial 3125	qpc:<init>	(Lqoe;Ljava/lang/String;)V
    //   1474: invokestatic 2744	qcn:b	(Landroid/content/Context;Landroid/widget/TextView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/view/View$OnClickListener;)V
    //   1477: aload_1
    //   1478: getfield 3105	omz:jdField_d_of_type_AndroidViewView	Landroid/view/View;
    //   1481: ldc_w 2745
    //   1484: invokevirtual 2678	android/view/View:setBackgroundColor	(I)V
    //   1487: aload_1
    //   1488: getfield 3104	omz:jdField_e_of_type_AndroidViewView	Landroid/view/View;
    //   1491: iconst_0
    //   1492: invokevirtual 1492	android/view/View:setVisibility	(I)V
    //   1495: aload_0
    //   1496: iconst_1
    //   1497: putfield 2711	qoe:jdField_h_of_type_Boolean	Z
    //   1500: aconst_null
    //   1501: ldc_w 911
    //   1504: ldc_w 2747
    //   1507: ldc_w 2747
    //   1510: iconst_0
    //   1511: iconst_0
    //   1512: ldc_w 911
    //   1515: ldc_w 911
    //   1518: ldc_w 911
    //   1521: aload_2
    //   1522: iconst_0
    //   1523: invokestatic 1282	ndn:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   1526: goto -754 -> 772
    //   1529: aload_1
    //   1530: getfield 3122	omz:g	Landroid/widget/TextView;
    //   1533: bipush 8
    //   1535: invokevirtual 1522	android/widget/TextView:setVisibility	(I)V
    //   1538: aload_1
    //   1539: getfield 3104	omz:jdField_e_of_type_AndroidViewView	Landroid/view/View;
    //   1542: iconst_0
    //   1543: invokevirtual 1492	android/view/View:setVisibility	(I)V
    //   1546: aload_1
    //   1547: getfield 3105	omz:jdField_d_of_type_AndroidViewView	Landroid/view/View;
    //   1550: iconst_0
    //   1551: invokevirtual 2678	android/view/View:setBackgroundColor	(I)V
    //   1554: invokestatic 330	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1557: ifeq -785 -> 772
    //   1560: ldc_w 985
    //   1563: iconst_2
    //   1564: ldc_w 2749
    //   1567: invokestatic 990	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1570: goto -798 -> 772
    //   1573: aload_1
    //   1574: getfield 3122	omz:g	Landroid/widget/TextView;
    //   1577: bipush 8
    //   1579: invokevirtual 1522	android/widget/TextView:setVisibility	(I)V
    //   1582: aload_1
    //   1583: getfield 3104	omz:jdField_e_of_type_AndroidViewView	Landroid/view/View;
    //   1586: iconst_0
    //   1587: invokevirtual 1492	android/view/View:setVisibility	(I)V
    //   1590: aload_1
    //   1591: getfield 3105	omz:jdField_d_of_type_AndroidViewView	Landroid/view/View;
    //   1594: iconst_0
    //   1595: invokevirtual 2678	android/view/View:setBackgroundColor	(I)V
    //   1598: goto -826 -> 772
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1601	0	this	qoe
    //   0	1601	1	paramomz	omz
    //   0	1601	2	paramBaseArticleInfo	BaseArticleInfo
    //   0	1601	3	paramInt	int
    //   14	1432	4	localObject1	Object
    //   102	367	5	localObject2	Object
    //   849	100	5	localException	Exception
    //   979	16	5	localJSONException1	JSONException
    //   1293	171	5	str1	String
    //   370	7	6	localJSONObject	JSONObject
    //   911	1	6	localJSONException2	JSONException
    //   1298	162	6	str2	String
    //   1303	159	7	str3	String
    //   1316	13	8	localQQAppInterface	QQAppInterface
    // Exception table:
    //   from	to	target	type
    //   248	279	849	java/lang/Exception
    //   358	407	911	org/json/JSONException
    //   891	908	911	org/json/JSONException
    //   436	479	979	org/json/JSONException
  }
  
  public void a(onf paramonf, BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    paramonf.jdField_f_of_type_AndroidViewView.setOnClickListener(null);
    paramonf.jdField_f_of_type_AndroidViewView.setOnLongClickListener(this);
    paramonf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = paramBaseArticleInfo;
    paramonf.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = ((BaseArticleInfo)paramBaseArticleInfo.mSubArtilceList.get(0));
    BaseArticleInfo localBaseArticleInfo = paramonf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
    paramonf.jdField_a_of_type_AndroidWidgetTextView.setText(localBaseArticleInfo.mTitle);
    paramonf.jdField_a_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
    paramonf.jdField_b_of_type_AndroidWidgetTextView.setText(qcn.c(localBaseArticleInfo.mVideoPlayCount));
    paramBaseArticleInfo = this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130842495);
    paramInt = bajq.b(8.0F);
    paramBaseArticleInfo.setBounds(0, 0, paramInt, paramInt);
    paramonf.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables(paramBaseArticleInfo, null, null, null);
    paramonf.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(bajq.b(3.0F));
    qcn.a(paramonf.jdField_c_of_type_AndroidWidgetTextView, localBaseArticleInfo.getCommentCount(), ajjy.a(2131646945), "0");
    URL localURL = localBaseArticleInfo.getVideoCoverUrlWithSmartCut(true);
    a(paramonf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, localURL, false);
    paramonf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setTag(paramonf);
    paramonf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setOnClickListener(this);
    paramonf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setOnLongClickListener(this);
    qcn.a(localBaseArticleInfo.mVideoArticleSubsText, localBaseArticleInfo.mVideoArticleSubsColor, paramonf.jdField_d_of_type_AndroidWidgetTextView);
    localBaseArticleInfo = paramonf.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
    paramonf.jdField_e_of_type_AndroidWidgetTextView.setText(localBaseArticleInfo.mTitle);
    paramonf.jdField_e_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
    paramonf.jdField_f_of_type_AndroidWidgetTextView.setText(qcn.c(localBaseArticleInfo.mVideoPlayCount));
    paramonf.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawables(paramBaseArticleInfo, null, null, null);
    paramonf.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(bajq.b(3.0F));
    qcn.a(paramonf.g, localBaseArticleInfo.getCommentCount(), ajjy.a(2131646934), "0");
    paramBaseArticleInfo = localBaseArticleInfo.getVideoCoverUrlWithSmartCut(true);
    a(paramonf.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, paramBaseArticleInfo, false);
    paramonf.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setTag(paramonf);
    paramonf.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setOnClickListener(this);
    paramonf.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setOnLongClickListener(this);
    qcn.a(localBaseArticleInfo.mVideoArticleSubsText, localBaseArticleInfo.mVideoArticleSubsColor, paramonf.h);
  }
  
  public void a(qhp paramqhp, pyu parampyu)
  {
    this.jdField_a_of_type_Qhp = paramqhp;
    this.jdField_a_of_type_Pyu = parampyu;
    if (pyu.a(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext())) {
      this.jdField_a_of_type_Pyu.b(true);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyBaseAdapter", 2, "setVideoPlayManager " + this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler + " mVideoPlayManager " + this.jdField_a_of_type_Qhp + " mIsCleanData " + this.n);
      }
      if ((this.jdField_a_of_type_Qhp != null) && (!this.n))
      {
        b();
        this.jdField_a_of_type_Qhp.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr);
        this.jdField_a_of_type_Qhp.a(this.jdField_a_of_type_Pyu);
        if (bgmq.a(this.jdField_d_of_type_Int)) {
          this.jdField_a_of_type_Qhp.a(0);
        }
      }
      if ((npj.a(this.jdField_c_of_type_Int)) && (this.jdField_a_of_type_Qhp != null))
      {
        this.jdField_a_of_type_Pyl = new pyl(this.jdField_a_of_type_AndroidAppActivity, this, this.jdField_a_of_type_Qhp, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, this.jdField_c_of_type_Int);
        this.jdField_a_of_type_Qhp.a(this.jdField_a_of_type_Pyl);
      }
      return;
      this.jdField_a_of_type_Pyu.b(false);
    }
  }
  
  public void a(qht paramqht)
  {
    if ((this.jdField_a_of_type_Beki != null) && (this.jdField_a_of_type_Beki.isShowing())) {
      this.jdField_a_of_type_Beki.dismiss();
    }
    if ((this.jdField_a_of_type_Beko != null) && (this.jdField_a_of_type_Beko.isShowing())) {
      this.jdField_a_of_type_Beko.dismiss();
    }
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new ReadInJoyBaseAdapter.28(this, paramqht), 1000L);
  }
  
  public void a(qht paramqht, int paramInt)
  {
    if (this.jdField_a_of_type_Omw != null) {}
    for (;;)
    {
      return;
      omz localomz = a(paramqht.jdField_j_of_type_JavaLangString);
      if (localomz != null)
      {
        this.jdField_a_of_type_Omw = localomz;
        paramqht.jdField_a_of_type_AndroidViewView = localomz.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
      }
      while ((this.jdField_a_of_type_Qhp != null) && (this.jdField_a_of_type_Qhp.a() != null))
      {
        paramqht = this.jdField_a_of_type_Qhp.a();
        if (QLog.isColorLevel()) {
          QLog.i("ReadInJoyBaseAdapter", 2, "notifyVideoPositionChanged:");
        }
        paramqht.e();
        return;
        if (QLog.isColorLevel()) {
          QLog.e("ReadInJoyBaseAdapter", 2, "fixNowPlayHolder failed videoPlayParam:" + paramqht + "    callSource:" + paramInt);
        }
      }
    }
  }
  
  public void a(qht paramqht, BaseArticleInfo paramBaseArticleInfo)
  {
    a(paramqht, paramBaseArticleInfo, false);
  }
  
  public void a(qht paramqht, BaseArticleInfo paramBaseArticleInfo, boolean paramBoolean)
  {
    a(paramqht, paramBaseArticleInfo, paramBoolean, true);
  }
  
  public void a(qht paramqht, BaseArticleInfo paramBaseArticleInfo, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "open full play activity, articleID : " + paramBaseArticleInfo.mArticleID + ", playPosition : " + paramqht.jdField_d_of_type_Long + ",vid : " + paramqht.jdField_c_of_type_JavaLangString + ", showComment : " + paramBoolean1);
    }
    if (this.jdField_a_of_type_Qhp != null) {
      this.jdField_a_of_type_Qhp.b();
    }
    this.jdField_j_of_type_Boolean = true;
    Bundle localBundle;
    if (obz.s(paramBaseArticleInfo)) {
      localBundle = b(paramqht, paramBaseArticleInfo);
    }
    for (;;)
    {
      int i1;
      label137:
      Object localObject;
      label266:
      label275:
      Intent localIntent;
      if (this.jdField_a_of_type_Qhp != null)
      {
        if (this.jdField_a_of_type_Qhp.b() == paramBaseArticleInfo.mArticleID)
        {
          i1 = this.jdField_a_of_type_Qhp.a();
          localBundle.putInt("VIDEO_PLAY_STATUS", i1);
        }
      }
      else
      {
        if (paramqht.jdField_f_of_type_Int == 2)
        {
          localObject = ocm.a(paramqht.jdField_c_of_type_JavaLangString);
          if (localObject != null)
          {
            localBundle.putString("VIDEO_THIRD_VID_URL", ((ocs)localObject).jdField_a_of_type_JavaLangString);
            localBundle.putLong("VIDEO_THIRD_VID_URL_TIME", ((ocs)localObject).jdField_a_of_type_Long);
          }
        }
        localBundle.putBoolean("VIDEO_LIST_SCROLL_EXIT", true);
        localBundle.putInt("REPORT_VIDEO_FEEDS_JUMP_FROM", 3);
        if (this.jdField_c_of_type_Int != 0) {
          break label760;
        }
        if (!obz.i(paramBaseArticleInfo)) {
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
          localBundle.putBoolean("param_needSmooth", qji.a().d());
          qji.a().f(true);
          localBundle.putBoolean("param_needAlertInXg", pyu.e());
        }
        localIntent.putExtras(localBundle);
        if ((paramqht.jdField_f_of_type_Int == 6) && (!obz.s(paramBaseArticleInfo))) {
          localIntent.putExtra("VIDEO_ARTICLE_INFO_FOR_BIU", (ArticleInfo)paramBaseArticleInfo);
        }
        i1 = 9091;
        if (1 != paramBaseArticleInfo.mVideoType) {
          break label1082;
        }
        i1 = 1;
        label444:
        localIntent.putExtra("VIDEO_FEEDS_INNER_SESSION_ID", paramqht.l);
        localIntent.putExtra("VIDEO_CHANNEL_SESSION_ID", paramqht.jdField_m_of_type_JavaLangString);
        localIntent.putExtra("item_x", paramqht.jdField_h_of_type_Int);
        localIntent.putExtra("item_y", paramqht.jdField_i_of_type_Int);
        localIntent.putExtra("item_width", paramqht.jdField_j_of_type_Int);
        localIntent.putExtra("item_height", paramqht.jdField_k_of_type_Int);
        localIntent.putExtra("VIDEO_FEEDS_TYPE_FOR_REPORT", obz.a(paramBaseArticleInfo));
        localIntent.putExtra("VIDEO_SHOW_COMMENT", paramBoolean1);
      }
      try
      {
        paramBoolean1 = odw.a(localBundle.getInt("VIDEO_FROM_TYPE", -1), Integer.valueOf(localBundle.getString("VIDEO_WIDTH")).intValue(), Integer.valueOf(localBundle.getString("VIDEO_HEIGHT")).intValue(), Integer.valueOf(localBundle.getString("VIDEO_TIME")).intValue());
        if (paramBoolean1)
        {
          MultiVideoFragment.a(this.jdField_a_of_type_AndroidAppActivity, localIntent, i1);
          ((Activity)localObject).overridePendingTransition(2130772010, 0);
          qhb.a();
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr != null)
          {
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.e();
            this.jdField_k_of_type_Boolean = true;
          }
          if (bgmq.j()) {
            ndn.a(null, "", "0X8008B68", "0X8008B68", 0, 0, "", "", "", new.a(null, null, paramBaseArticleInfo.mVideoVid, paramBaseArticleInfo.innerUniqueID, a(), null), false);
          }
          return;
          localBundle = a(paramqht, paramBaseArticleInfo);
          continue;
          i1 = 1;
          break label137;
          label713:
          if (obz.s(paramBaseArticleInfo))
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
            if (obz.i(paramBaseArticleInfo))
            {
              localBundle.putInt("VIDEO_FROM_TYPE", 5);
              localBundle.putLong("VIDEO_FROM_POLYMERIC_TOPIC_ID", paramBaseArticleInfo.mPolymericInfo.jdField_f_of_type_Long);
              localBundle.putLong("VIDEO_FROM_POLYMERIC_PUIN", paramBaseArticleInfo.mPolymericInfo.jdField_b_of_type_Long);
            }
            for (;;)
            {
              localBundle.putInt("PERFORMANCE_REPORT_VIDEO_FEEDS_JUMP_FROM", 4);
              break;
              if (obz.s(paramBaseArticleInfo))
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
            if (obz.s(paramBaseArticleInfo))
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
          if (odm.c(this.jdField_c_of_type_Int))
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
      catch (Exception paramqht)
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
  
  public void a(qht paramqht1, qht paramqht2)
  {
    if (paramqht1 != paramqht2)
    {
      if (((paramqht1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo instanceof ArticleInfo)) && ((paramqht2.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo instanceof ArticleInfo))) {
        ogy.a().a(this.jdField_c_of_type_Int, (ArticleInfo)paramqht1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, (ArticleInfo)paramqht2.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.clearFocus();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.postDelayed(new ReadInJoyBaseAdapter.27(this, paramqht1, paramqht2), 100L);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Qjd != null) {
        this.jdField_a_of_type_Qjd.a(paramqht1, paramqht2);
      }
      return;
      if (this.jdField_a_of_type_Qhp.a() == 7) {
        a(paramqht1);
      }
    }
  }
  
  public void a(qjd paramqjd)
  {
    this.jdField_a_of_type_Qjd = paramqjd;
  }
  
  public void a(qnt paramqnt)
  {
    this.jdField_a_of_type_Qnt = paramqnt;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setNoteCardLifeCycle(paramqnt);
    }
  }
  
  public void a(qpg paramqpg)
  {
    this.jdField_a_of_type_Qpg = paramqpg;
  }
  
  public void a(qph paramqph)
  {
    this.jdField_a_of_type_Qph = paramqph;
  }
  
  public void a(qpi paramqpi)
  {
    this.jdField_a_of_type_Qpi = paramqpi;
  }
  
  public void a(qpj paramqpj)
  {
    this.jdField_a_of_type_Qpj = paramqpj;
  }
  
  public void a(qpk paramqpk)
  {
    this.jdField_a_of_type_Qpk = paramqpk;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public void a(boolean paramBoolean, ArticleInfo paramArticleInfo1, ArticleInfo paramArticleInfo2, String paramString)
  {
    qht localqht = a(paramArticleInfo1);
    localqht.jdField_n_of_type_JavaLangString = paramString;
    localqht.l = new.b();
    if ((this.jdField_a_of_type_Qhp != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Qhp.a()))) {
      localqht.jdField_m_of_type_JavaLangString = this.jdField_a_of_type_Qhp.a();
    }
    paramString = new qmv(null, null, null, null);
    int i1;
    if (paramBoolean)
    {
      i1 = 0;
      ndn.a(null, "", "0X8008D33", "0X8008D33", 0, 0, "", "", "", paramString.x(i1).b(localqht.l).c(localqht.jdField_m_of_type_JavaLangString).a(this.jdField_c_of_type_Int).k(paramArticleInfo1.mVideoAdsSource).j(paramArticleInfo1.mVideoAdsJumpType).a(paramArticleInfo1.videoReportInfo).a(paramArticleInfo1).O((int)this.jdField_c_of_type_Long).a().a(), false);
      if (!qcn.a(paramArticleInfo1, a())) {
        break label192;
      }
      b(localqht, paramArticleInfo1);
    }
    label192:
    do
    {
      return;
      i1 = 1;
      break;
      if ((paramArticleInfo1.isAccountShown) && (this.jdField_c_of_type_Int == 0) && (!TextUtils.isEmpty(paramArticleInfo1.mArticleContentUrl)))
      {
        obz.e(a(), paramArticleInfo1.mArticleContentUrl);
        paramString = new qmv(null, null, paramArticleInfo1.mVideoVid, paramArticleInfo1.innerUniqueID);
        if (paramBoolean) {}
        for (i1 = 0;; i1 = 1)
        {
          ndn.a(null, "", "0X8007625", "0X8007625", 0, 0, "", "", "", paramString.x(i1).b(localqht.l).c(localqht.jdField_m_of_type_JavaLangString).a(this.jdField_c_of_type_Int).k(paramArticleInfo1.mVideoAdsSource).j(paramArticleInfo1.mVideoAdsJumpType).a(paramArticleInfo1.videoReportInfo).a(paramArticleInfo1).O((int)this.jdField_c_of_type_Long).W(obz.a(paramArticleInfo1)).e(paramArticleInfo1).R(7).f(paramArticleInfo2).a().a(), false);
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
          paramString.putExtra("big_brother_source_key", obz.f(a()));
          paramArticleInfo2.startActivity(paramString);
        }
        b(localqht, paramArticleInfo1);
        return;
      }
      if ((this.jdField_c_of_type_Int != 0) && (this.jdField_c_of_type_Int != 56)) {
        break label687;
      }
      if (!qcn.a(this.jdField_a_of_type_AndroidAppActivity, paramArticleInfo1)) {
        break label584;
      }
      b(localqht, paramArticleInfo1);
    } while ((this.jdField_c_of_type_Int != 56) || (paramArticleInfo1.mVideoDownloadBarInfo == null) || (paramArticleInfo1.mVideoDownloadBarInfo.weishiUGInfo == null) || (!obz.a(paramArticleInfo1.mVideoDownloadBarInfo.weishiUGInfo.bytes_report_base_url)) || (!obz.a(paramArticleInfo1.mVideoDownloadBarInfo.weishiUGInfo.bytes_click_schema_report_tail)));
    qcn.a(obz.a(paramArticleInfo1.mVideoDownloadBarInfo.weishiUGInfo.bytes_report_base_url) + obz.a(paramArticleInfo1.mVideoDownloadBarInfo.weishiUGInfo.bytes_click_schema_report_tail));
    return;
    label584:
    if ((this.jdField_c_of_type_Int == 56) && (paramArticleInfo1.mVideoDownloadBarInfo != null) && (paramArticleInfo1.mVideoDownloadBarInfo.weishiUGInfo != null) && (obz.a(paramArticleInfo1.mVideoDownloadBarInfo.weishiUGInfo.bytes_report_base_url)) && (obz.a(paramArticleInfo1.mVideoDownloadBarInfo.weishiUGInfo.bytes_click_report_tail))) {
      qcn.a(obz.a(paramArticleInfo1.mVideoDownloadBarInfo.weishiUGInfo.bytes_report_base_url) + obz.a(paramArticleInfo1.mVideoDownloadBarInfo.weishiUGInfo.bytes_click_report_tail));
    }
    label687:
    if (paramArticleInfo1.videoJumpChannelID > 0)
    {
      if (paramArticleInfo1.videoJumpChannelID == 56) {
        nji.a(this.jdField_a_of_type_AndroidAppActivity, paramArticleInfo2, paramArticleInfo1, true);
      }
      for (;;)
      {
        b(localqht, paramArticleInfo1);
        return;
        paramArticleInfo2 = new HashMap();
        paramArticleInfo2.put("param_key_insert_article_id", Long.valueOf(paramArticleInfo1.mArticleID));
        nji.b(this.jdField_a_of_type_AndroidAppActivity, paramArticleInfo1.videoJumpChannelID, paramArticleInfo1.videoJumpChannelName, paramArticleInfo1.videoJumpChannelType, 5, paramArticleInfo2);
      }
    }
    if (bgmq.d(BaseApplicationImpl.getApplication().getRuntime()) == 1)
    {
      nji.a(this.jdField_a_of_type_AndroidAppActivity, paramArticleInfo2, paramArticleInfo1, true);
      b(localqht, paramArticleInfo1);
      return;
    }
    a(localqht, paramArticleInfo1);
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
      ogy.a().a(56, 3, paramBaseArticleInfo.mArticleID, l1);
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
  
  public omz b(String paramString)
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
          localObject1 = (omz)paramString.getTag();
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
    for (int i1 = qii.jdField_b_of_type_Int;; i1 = qii.jdField_a_of_type_Int)
    {
      localVideoPreDownloadMgr.a = new qii(i1, qii.jdField_f_of_type_Int);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a(new qon(this));
      return;
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
  }
  
  public void b(BaseArticleInfo paramBaseArticleInfo)
  {
    if ((paramBaseArticleInfo.isAccountShown) && (this.jdField_c_of_type_Int == 0) && (!TextUtils.isEmpty(obz.a(paramBaseArticleInfo.mPartnerAccountInfo.bytes_head_jump_url)))) {
      obz.e(a(), obz.a(paramBaseArticleInfo.mPartnerAccountInfo.bytes_head_jump_url));
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
      } while ((!badq.g(this.jdField_a_of_type_AndroidAppActivity)) || (this.jdField_a_of_type_Qhp == null) || (paramAbsListView == null));
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
  
  public void b(qht paramqht, BaseArticleInfo paramBaseArticleInfo)
  {
    int i3 = a();
    String str = obz.c(paramBaseArticleInfo);
    int i1;
    int i2;
    label40:
    qmv localqmv;
    if (((ArticleInfo)paramBaseArticleInfo).hasChannelInfo())
    {
      i1 = paramBaseArticleInfo.mChannelInfoId;
      if (!TextUtils.isEmpty(paramBaseArticleInfo.mArticleFriendLikeText)) {
        break label529;
      }
      i2 = 0;
      ndn.a(null, "CliOper", "", "", "0X80066FA", "0X80066FA", 0, 0, "", Long.toString(paramBaseArticleInfo.mArticleID), Integer.toString(paramBaseArticleInfo.mStrategyId), obz.b(paramBaseArticleInfo.mAlgorithmID, obz.a(paramBaseArticleInfo), this.jdField_c_of_type_Int, i1), false);
      ndn.a("0X80066FA", "", "", Long.toString(paramBaseArticleInfo.mArticleID), Integer.toString(paramBaseArticleInfo.mStrategyId), obz.b(paramBaseArticleInfo.mAlgorithmID, obz.a(paramBaseArticleInfo), this.jdField_c_of_type_Int, i1));
      localqmv = new qmv(obz.a(paramBaseArticleInfo.mAlgorithmID, obz.a(paramBaseArticleInfo), i3, i1, i2, badq.h(this.jdField_a_of_type_AndroidAppActivity), str, paramBaseArticleInfo.mStrCircleId, paramBaseArticleInfo.innerUniqueID, obz.e(paramBaseArticleInfo), 409409, (ArticleInfo)paramBaseArticleInfo));
      localqmv.a(this.jdField_a_of_type_Qik, paramBaseArticleInfo.mArticleID).a(this.jdField_a_of_type_Qik).g(new.jdField_a_of_type_Int).h(409409).j(paramBaseArticleInfo.mVideoAdsJumpType).k(paramBaseArticleInfo.mVideoAdsSource).a(Boolean.valueOf(obz.w(paramBaseArticleInfo))).a(paramBaseArticleInfo.videoReportInfo);
      if (i3 != 0) {
        break label535;
      }
      paramqht.l = new.b();
      localqmv.b(paramqht.l);
      if (paramBaseArticleInfo.mVideoColumnInfo != null) {
        localqmv.aa(paramBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_Int);
      }
      if (c((ArticleInfo)paramBaseArticleInfo) == 6) {
        localqmv.ac(qcn.b());
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Qhp != null) && (this.jdField_a_of_type_Qhp.a() == paramqht))
      {
        long l1 = this.jdField_a_of_type_Qhp.a();
        if (l1 != 0L) {
          localqmv.f(l1);
        }
      }
      if (this.jdField_c_of_type_Int != 40677) {
        break label586;
      }
      localqmv.b(paramBaseArticleInfo.mVideoAdsJumpType).a(vnd.a(this.jdField_a_of_type_AndroidAppActivity));
      localqmv.i(2);
      ndn.a(null, "CliOper", "", paramBaseArticleInfo.mSubscribeID, "0X8009293", "0X8009293", 0, 0, Long.toString(paramBaseArticleInfo.mFeedId), Long.toString(paramBaseArticleInfo.mArticleID), Integer.toString(paramBaseArticleInfo.mStrategyId), localqmv.a().a(), false);
      ndn.a("0X8009293", paramBaseArticleInfo.mSubscribeID, Long.toString(paramBaseArticleInfo.mFeedId), Long.toString(paramBaseArticleInfo.mArticleID), Integer.toString(paramBaseArticleInfo.mStrategyId), obz.a(paramBaseArticleInfo.mAlgorithmID, obz.a(paramBaseArticleInfo), i3, i1, i2, badq.h(this.jdField_a_of_type_AndroidAppActivity), str, paramBaseArticleInfo.mStrCircleId, paramBaseArticleInfo.innerUniqueID, obz.e(paramBaseArticleInfo), 409409, (ArticleInfo)paramBaseArticleInfo));
      return;
      i1 = 0;
      break;
      label529:
      i2 = 1;
      break label40;
      label535:
      if ((i3 == 56) && (this.jdField_a_of_type_Qhp != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Qhp.a())))
      {
        paramqht.jdField_m_of_type_JavaLangString = this.jdField_a_of_type_Qhp.a();
        localqmv.c(paramqht.jdField_m_of_type_JavaLangString);
      }
    }
    label586:
    localqmv.a(paramBaseArticleInfo).O((int)this.jdField_c_of_type_Long).c(paramBaseArticleInfo).a(paramBaseArticleInfo, true).d(paramBaseArticleInfo).f(paramBaseArticleInfo);
    if ((obz.l(paramBaseArticleInfo)) && (paramBaseArticleInfo.mPolymericInfo != null)) {
      localqmv.x(paramBaseArticleInfo.mPolymericInfo.jdField_f_of_type_Int + 1);
    }
    paramqht = rvf.b(this.jdField_c_of_type_Int);
    ndn.a(null, "CliOper", "", paramBaseArticleInfo.mSubscribeID, paramqht, paramqht, 0, 0, Long.toString(paramBaseArticleInfo.mFeedId), Long.toString(paramBaseArticleInfo.mArticleID), Integer.toString(paramBaseArticleInfo.mStrategyId), localqmv.a().a(), false);
    ndn.a(paramqht, paramBaseArticleInfo.mSubscribeID, Long.toString(paramBaseArticleInfo.mFeedId), Long.toString(paramBaseArticleInfo.mArticleID), Integer.toString(paramBaseArticleInfo.mStrategyId), obz.a(paramBaseArticleInfo.mAlgorithmID, obz.a(paramBaseArticleInfo), i3, i1, i2, badq.h(this.jdField_a_of_type_AndroidAppActivity), str, paramBaseArticleInfo.mStrCircleId, paramBaseArticleInfo.innerUniqueID, obz.e(paramBaseArticleInfo), 409409, (ArticleInfo)paramBaseArticleInfo));
  }
  
  public void b(boolean paramBoolean, BaseArticleInfo paramBaseArticleInfo)
  {
    qmv localqmv;
    if ((paramBaseArticleInfo.isAccountShown) && (this.jdField_c_of_type_Int == 0) && (!TextUtils.isEmpty(paramBaseArticleInfo.mArticleContentUrl)))
    {
      obz.e(a(), paramBaseArticleInfo.mArticleContentUrl);
      localqmv = new qmv(null, null, paramBaseArticleInfo.mVideoVid, paramBaseArticleInfo.innerUniqueID);
      if (!paramBoolean) {
        break label144;
      }
    }
    label144:
    for (int i1 = 0;; i1 = 1)
    {
      ndn.a(null, "", "0X8007625", "0X8007625", 0, 0, "", "", "", localqmv.x(i1).a(this.jdField_c_of_type_Int).a(paramBaseArticleInfo.videoReportInfo).a(paramBaseArticleInfo).O((int)this.jdField_c_of_type_Long).W(obz.a(paramBaseArticleInfo)).e(paramBaseArticleInfo).R(6).f(paramBaseArticleInfo).a().a(), false);
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
    if (this.jdField_a_of_type_Qhp != null) {
      this.jdField_a_of_type_Qhp.a(new qoh(this));
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ReadInJoyBaseAdapter", 2, "mVideoPlayManager == null");
  }
  
  public void f()
  {
    if ((this.jdField_a_of_type_Qhp != null) && (this.jdField_a_of_type_Qhp.a() != null)) {}
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
          if ((!obz.a(((BaseArticleInfo)localObject).mArticleContentUrl, ((BaseArticleInfo)localObject).mChannelID, ((BaseArticleInfo)localObject).mFeedType, (ArticleInfo)localObject)) && (!obz.a((BaseArticleInfo)localObject)) && (!a(i3, ((BaseArticleInfo)localObject).mArticleID)))
          {
            localObject = ((BaseArticleInfo)localObject).mArticleContentUrl;
            if (xcu.a((String)localObject)) {
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
    beoj.a("ReadInJoyBaseAdapter.getView");
    System.currentTimeMillis();
    a(b(paramInt), paramInt);
    BaseArticleInfo localBaseArticleInfo = b(paramInt);
    int i1 = getItemViewType(paramInt);
    oqh localoqh = a((ArticleInfo)localBaseArticleInfo, i1, paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyBaseAdapter", 2, "getView: " + localBaseArticleInfo + " type= " + i1);
    }
    paramViewGroup = (View)omq.a(this.jdField_a_of_type_AndroidUtilSparseArray, new qpb(this, "onAdapterGetView", i1, localBaseArticleInfo, paramInt, paramView, paramViewGroup));
    if (paramViewGroup != null)
    {
      a(localBaseArticleInfo, localoqh, System.currentTimeMillis(), paramInt);
      paramView = super.a(paramViewGroup, paramInt);
      beoj.a();
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
    return jdField_a_of_type_Oxy.a() + 132;
  }
  
  public void h()
  {
    if ((!bgmq.y(a())) || (!bgmq.z(a()))) {
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
        if (!obz.a((BaseArticleInfo)localObject)) {
          localArrayList.add((ArticleInfo)localObject);
        }
      }
      i1 += 1;
    }
    ogy.a().a().a(localArrayList);
  }
  
  public void i()
  {
    this.jdField_f_of_type_Boolean = true;
    if ((this.jdField_a_of_type_Qhp != null) && ((c()) || (this.jdField_a_of_type_Pyu.a())) && (!this.jdField_a_of_type_Pyu.b()) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getVisibility() == 0))
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
    if (this.jdField_a_of_type_Pyl != null) {
      this.jdField_a_of_type_Pyl.a();
    }
    if (this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video_" + this.jdField_c_of_type_Int, 2, "ReadInJoyBaseAdapter doOnResume()");
      }
      if (bgmq.k()) {
        r();
      }
      this.p = true;
      this.jdField_a_of_type_Boolean = true;
      c();
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new ReadInJoyBaseAdapter.33(this), 1000L);
      if (Build.VERSION.SDK_INT < 21) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setFriction(jdField_a_of_type_Float);
      }
      this.jdField_a_of_type_Rrb.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, 4);
      this.jdField_i_of_type_Boolean = false;
      this.jdField_h_of_type_Boolean = false;
      int i1 = 0;
      while (i1 < this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildCount())
      {
        localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(i1);
        if (((localObject instanceof qns)) && (!((qns)localObject).a()))
        {
          ((qns)localObject).setIsResume(true);
          ((qns)localObject).a();
        }
        i1 += 1;
      }
      if (this.jdField_a_of_type_Qnt != null) {
        this.jdField_a_of_type_Qnt.a();
      }
      Object localObject = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      if ((orc.a() == 2) && (orc.b(a(), (String)localObject) > 0))
      {
        localObject = (SensorManager)a().getSystemService("sensor");
        ajrw localajrw = this.jdField_a_of_type_Ajrw;
        Sensor localSensor = ((SensorManager)localObject).getDefaultSensor(1);
        i1 = i2;
        if (awsh.a().a()) {
          i1 = 2;
        }
        ((SensorManager)localObject).registerListener(localajrw, localSensor, i1);
      }
    } while (!ProteusParserWithHotReload.getInstance().isSupportHotReload());
    ProteusParserWithHotReload.getInstance().addHotReloadChangedObserver(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewParseProteusParserWithHotReload$IHotReloadChangedObserver);
  }
  
  public void k()
  {
    if (this.jdField_a_of_type_Pyl != null) {
      this.jdField_a_of_type_Pyl.b();
    }
    if (!this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video_" + this.jdField_c_of_type_Int, 2, "ReadInJoyBaseAdapter doOnPause()");
      }
      this.jdField_a_of_type_Boolean = false;
      if ((this.jdField_a_of_type_Beki != null) && (this.jdField_a_of_type_Beki.isShowing())) {
        this.jdField_a_of_type_Beki.dismiss();
      }
      this.jdField_l_of_type_Int = badq.b(this.jdField_a_of_type_AndroidAppActivity);
      this.jdField_a_of_type_Rrb.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, 5);
      w();
      if ((!bgmq.p()) && (oag.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, "default_feeds")))
      {
        QLog.d("ReadInJoyBaseAdapter", 2, "hasRefresh notifyDataSetChanged");
        notifyDataSetChanged();
      }
      int i1 = 0;
      while (i1 < this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildCount())
      {
        View localView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(i1);
        if (((localView instanceof qns)) && (((qns)localView).a()))
        {
          ((qns)localView).setIsResume(false);
          ((qns)localView).b();
        }
        i1 += 1;
      }
      if (this.jdField_a_of_type_Qnt != null) {
        this.jdField_a_of_type_Qnt.b();
      }
      ((SensorManager)a().getSystemService("sensor")).unregisterListener(this.jdField_a_of_type_Ajrw);
    } while (!ProteusParserWithHotReload.getInstance().isSupportHotReload());
    ProteusParserWithHotReload.getInstance().removeHotReloadChangedObserver(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewParseProteusParserWithHotReload$IHotReloadChangedObserver);
  }
  
  public void l()
  {
    if (this.jdField_a_of_type_Qjd != null) {
      this.jdField_a_of_type_Qjd.l();
    }
  }
  
  public void m()
  {
    this.jdField_a_of_type_Qhp.b(9);
  }
  
  public void n()
  {
    if ((this.jdField_a_of_type_Qhp != null) && (npj.a(this.jdField_c_of_type_Int))) {
      m();
    }
  }
  
  public void notifyDataSetChanged()
  {
    super.notifyDataSetChanged();
    omq.a(this.jdField_a_of_type_AndroidUtilSparseArray, new qov(this, "onNotifyDataSetChange"));
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "notifyDataSetChanged");
    }
    if (((this.jdField_a_of_type_Omw != null) || (this.jdField_a_of_type_Qht != null)) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr != null))
    {
      int i2 = -1;
      int i1 = i2;
      if (this.jdField_a_of_type_Omw != null)
      {
        i1 = i2;
        if (this.jdField_a_of_type_Omw.a() != null) {
          i1 = this.jdField_a_of_type_Omw.a().jdField_a_of_type_Int;
        }
      }
      if (this.jdField_a_of_type_Qht != null) {
        i1 = this.jdField_a_of_type_Qht.jdField_a_of_type_Int;
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
    label1428:
    label1586:
    label1744:
    label1756:
    do
    {
      Object localObject1;
      do
      {
        for (;;)
        {
          return;
          localObject1 = (omz)paramView.getTag();
          localObject2 = b(((omw)localObject1).a());
          if (!qcn.a((BaseArticleInfo)localObject2, a()))
          {
            bool = qcn.b();
            if (((!this.jdField_a_of_type_Pyu.a()) && (bgmq.a(a()) > 0)) || (bool))
            {
              if (localObject2 != null)
              {
                if (bool) {
                  ndn.a(null, "", "0X8008E28", "0X8008E28", 0, 0, "", "", "", new qmv(null, null, ((BaseArticleInfo)localObject2).mVideoVid, ((BaseArticleInfo)localObject2).innerUniqueID).a((int)((BaseArticleInfo)localObject2).mChannelID).O((int)this.jdField_c_of_type_Long).R(1).a().a(), false);
                }
                a(((omw)localObject1).a(), (BaseArticleInfo)localObject2, false);
              }
            }
            else
            {
              this.jdField_a_of_type_Qhp.a().c(paramView);
              ohb.a().e(false);
              return;
              paramView = (articlesummary.ChannelInfo)paramView.getTag();
              if (paramView != null) {
                if ((paramView.bytes_channel_url.has()) && (paramView.bytes_channel_url.get() != null))
                {
                  if (!TextUtils.isEmpty(paramView.bytes_channel_url.get().toStringUtf8())) {
                    obz.a(this.jdField_a_of_type_AndroidAppActivity, paramView.bytes_channel_url.get().toStringUtf8());
                  }
                }
                else
                {
                  nji.b(this.jdField_a_of_type_AndroidAppActivity, paramView.uint32_channel_id.get(), obz.a(paramView), paramView.uint32_channel_type.get(), 6, null);
                  return;
                  paramView = (omz)paramView.getTag();
                  localObject1 = b(paramView.jdField_a_of_type_Int);
                  if (localObject1 != null)
                  {
                    if (!qcn.a((BaseArticleInfo)localObject1, a()))
                    {
                      if (AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject1))
                      {
                        rvb.a(this.jdField_a_of_type_AndroidAppActivity, (ArticleInfo)localObject1, this, 56);
                        rvb.a(this.jdField_a_of_type_AndroidAppActivity, (ArticleInfo)localObject1, this, 56, true, null);
                        return;
                      }
                      a(paramView.jdField_a_of_type_Qht, (BaseArticleInfo)localObject1);
                    }
                    ThreadManager.executeOnSubThread(new ReadInJoyBaseAdapter.14(this, (BaseArticleInfo)localObject1));
                    return;
                    paramView = (omz)paramView.getTag();
                    localObject1 = b(paramView.jdField_a_of_type_Int);
                    if (localObject1 != null)
                    {
                      a(paramView.jdField_a_of_type_Qht, (BaseArticleInfo)localObject1, true);
                      ThreadManager.executeOnSubThread(new ReadInJoyBaseAdapter.15(this, (BaseArticleInfo)localObject1));
                      return;
                      localObject1 = paramView.getTag();
                      if ((localObject1 instanceof ona))
                      {
                        ((ona)localObject1).onClick(paramView);
                        return;
                      }
                      if (qzk.a().b())
                      {
                        if ((paramView.getTag() instanceof omz))
                        {
                          paramView = (omz)paramView.getTag();
                          localObject1 = b(paramView.jdField_a_of_type_Int);
                          localObject2 = ((BaseArticleInfo)localObject1).fusionBiuInfo;
                          if (localObject2 != null)
                          {
                            qzk.a().a(paramView.jdField_b_of_type_AndroidWidgetImageView, ((FusionBiuInfo)localObject2).jdField_b_of_type_Boolean);
                            if (!((FusionBiuInfo)localObject2).jdField_b_of_type_Boolean) {
                              qzk.a().a(a(), obz.a(), 1, 2, (ArticleInfo)localObject1, 3, ((BaseArticleInfo)localObject1).innerUniqueID);
                            }
                            for (;;)
                            {
                              qzk.a().b(((BaseArticleInfo)localObject1).innerUniqueID, 56, 2, 4);
                              return;
                              qzk.a().a(a(), ((FusionBiuInfo)localObject2).jdField_a_of_type_Long, obz.a(), ((BaseArticleInfo)localObject1).mFeedType, 3, ((BaseArticleInfo)localObject1).innerUniqueID);
                            }
                          }
                        }
                      }
                      else
                      {
                        if (nsh.a() == 1) {}
                        for (bool = true;; bool = false)
                        {
                          a(paramView, false, bool);
                          return;
                        }
                        paramView = (omz)paramView.getTag();
                        localObject1 = b(paramView.jdField_a_of_type_Int);
                        if (localObject1 == null)
                        {
                          if (QLog.isColorLevel()) {
                            QLog.d("ReadInJoyBaseAdapter", 2, "articleInfo == null, ERROR");
                          }
                        }
                        else
                        {
                          if ((this.jdField_a_of_type_Qhp != null) && (this.jdField_a_of_type_Qhp.a()))
                          {
                            this.jdField_a_of_type_Qhp.a();
                            this.jdField_b_of_type_Boolean = true;
                          }
                          this.jdField_a_of_type_Qim.a(paramView.jdField_f_of_type_AndroidViewView, paramView.jdField_a_of_type_Int);
                          this.jdField_a_of_type_Qim.a(this);
                          this.jdField_a_of_type_Qim.a((BaseArticleInfo)localObject1, a(paramView.jdField_a_of_type_Qht, (BaseArticleInfo)localObject1), this.jdField_a_of_type_Qhp, new qoi(this, (BaseArticleInfo)localObject1), this.jdField_c_of_type_Int);
                          return;
                          a();
                          a();
                          localObject2 = (ond)paramView.getTag();
                          if (localObject2 != null)
                          {
                            localObject1 = (BaseArticleInfo)this.jdField_b_of_type_JavaUtilList.get(((ond)localObject2).jdField_a_of_type_Int);
                            try
                            {
                              JSONObject localJSONObject = new JSONObject();
                              localJSONObject.put("time", System.currentTimeMillis() / 1000L);
                              localJSONObject.put("channel_id", this.jdField_c_of_type_Int);
                              if ((this.jdField_a_of_type_AndroidAppActivity instanceof BaseActivity))
                              {
                                localJSONObject.put("folder_status", obz.jdField_d_of_type_Int);
                                localJSONObject.put("kandian_mode", obz.e());
                                localJSONObject.put("feeds_type", "" + obz.a((BaseArticleInfo)localObject1));
                                localJSONObject.put("rowkey", rvf.a((BaseArticleInfo)localObject1));
                                ndn.a(null, "", "0X8007058", "0X8007058", 0, 0, "", "", "", localJSONObject.toString(), false);
                              }
                              while (localObject1 != null)
                              {
                                i1 = ((ond)localObject2).jdField_a_of_type_Int;
                                localObject2 = new qoj(this, i1, (ond)localObject2, (BaseArticleInfo)localObject1);
                                if (!AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject1)) {
                                  break label1428;
                                }
                                if ((this.jdField_a_of_type_Beki != null) && (this.jdField_a_of_type_Beki.isShowing())) {
                                  this.jdField_a_of_type_Beki.dismiss();
                                }
                                this.jdField_a_of_type_Beko.a(i1, this.jdField_c_of_type_Int, obz.a((BaseArticleInfo)localObject1), ((AdvertisementInfo)localObject1).mAdDislikeInfos);
                                this.jdField_a_of_type_Beko.a(paramView, (bekm)localObject2);
                                this.jdField_a_of_type_Beko.a(new qol(this, (BaseArticleInfo)localObject1));
                                this.jdField_a_of_type_Beko.setOnDismissListener(new qom(this));
                                if ((this.jdField_a_of_type_Qhp == null) || (!this.jdField_a_of_type_Qhp.a())) {
                                  break;
                                }
                                this.jdField_a_of_type_Qhp.a();
                                this.jdField_b_of_type_Boolean = true;
                                return;
                                if ((this.jdField_a_of_type_AndroidAppActivity instanceof PluginBaseActivity))
                                {
                                  localJSONObject.put("folder_status", 1);
                                  awqx.b(null, "CliOper", "", "", "0X800705F", "0X800705F", 0, 0, "", "", "", localJSONObject.toString());
                                }
                              }
                            }
                            catch (JSONException localJSONException)
                            {
                              for (;;)
                              {
                                int i1;
                                localJSONException.printStackTrace();
                                continue;
                                if ((this.jdField_a_of_type_Beko != null) && (this.jdField_a_of_type_Beko.isShowing())) {
                                  this.jdField_a_of_type_Beko.dismiss();
                                }
                                this.jdField_a_of_type_Beki.a(i1, this.jdField_c_of_type_Int, obz.a((BaseArticleInfo)localObject1), ((BaseArticleInfo)localObject1).mDislikeInfos, ((BaseArticleInfo)localObject1).innerUniqueID);
                                this.jdField_a_of_type_Beki.a(paramView, (bekm)localObject2);
                                this.jdField_a_of_type_Beki.setOnDismissListener(new qoo(this));
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
          if (this.jdField_a_of_type_Qhp != null) {
            break label1744;
          }
          l1 = 0L;
          localObject3 = new qmv(null, paramView, (String)localObject1, (String)localObject3, l1, ((BaseArticleInfo)localObject2).mVideoDuration * 1000).a(this.jdField_c_of_type_Int).a().a();
          if (TextUtils.isEmpty(((BaseArticleInfo)localObject2).innerUniqueID)) {
            break label1756;
          }
        }
        for (localObject1 = String.valueOf(((BaseArticleInfo)localObject2).innerUniqueID);; localObject1 = "0")
        {
          ndn.a(null, paramView, "0X8007410", "0X8007410", 0, 0, "2", "", (String)localObject1, (String)localObject3, false);
          rvb.a(this.jdField_a_of_type_AndroidAppActivity, (ArticleInfo)localObject2, this, 56);
          rvb.a(this.jdField_a_of_type_AndroidAppActivity, (ArticleInfo)localObject2, this, 56, true, null);
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
          l1 = this.jdField_a_of_type_Qhp.a();
          break label1586;
        }
        paramView = b(((omz)paramView.getTag()).jdField_a_of_type_Int);
        rvb.a(this.jdField_a_of_type_AndroidAppActivity, (ArticleInfo)paramView, this, 56);
        rvb.a(this.jdField_a_of_type_AndroidAppActivity, (ArticleInfo)paramView, this, 56, true, null);
        return;
        Object localObject4;
        if (paramView.getId() == 2131303455)
        {
          localObject3 = (ArticleInfo)((omy)paramView.getTag()).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
          localObject1 = ((omy)paramView.getTag()).jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID;
          localObject2 = localObject3;
          localObject4 = localObject2;
          localObject2 = localObject1;
          if (paramView.getId() != 2131303455) {
            break label1944;
          }
        }
        for (bool = true;; bool = false)
        {
          a(bool, localObject4, (ArticleInfo)localObject3, (String)localObject2);
          return;
          localObject1 = (ArticleInfo)((omy)paramView.getTag()).jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
          localObject2 = ((omy)paramView.getTag()).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID;
          localObject3 = (ArticleInfo)((omy)paramView.getTag()).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
          ((ArticleInfo)localObject1).isTwoItem = true;
          localObject4 = localObject1;
          break;
        }
        if (paramView.getId() == 2131301552) {
          localObject1 = ((onf)paramView.getTag()).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
        }
        for (localObject2 = ((onf)paramView.getTag()).jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID;; localObject2 = ((onf)paramView.getTag()).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID)
        {
          localObject3 = a((BaseArticleInfo)localObject1);
          ((qht)localObject3).jdField_n_of_type_JavaLangString = ((String)localObject2);
          ((qht)localObject3).l = new.b();
          if ((this.jdField_a_of_type_Qhp != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Qhp.a()))) {
            ((qht)localObject3).jdField_m_of_type_JavaLangString = this.jdField_a_of_type_Qhp.a();
          }
          localObject2 = new int[2];
          paramView.getLocationOnScreen((int[])localObject2);
          ((qht)localObject3).jdField_h_of_type_Int = localObject2[0];
          ((qht)localObject3).jdField_i_of_type_Int = localObject2[1];
          ((qht)localObject3).jdField_j_of_type_Int = paramView.getWidth();
          ((qht)localObject3).jdField_k_of_type_Int = paramView.getHeight();
          if (!((BaseArticleInfo)localObject1).isVideoItemForCommonUrlJump()) {
            break;
          }
          obz.e(this.jdField_a_of_type_AndroidAppActivity, ((BaseArticleInfo)localObject1).mVideoAdsJumpUrl);
          b((qht)localObject3, (BaseArticleInfo)localObject1);
          return;
          localObject1 = ((onf)paramView.getTag()).jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
        }
        if (((BaseArticleInfo)localObject1).isVideoItemForWeishiJump())
        {
          if (vnd.a(this.jdField_a_of_type_AndroidAppActivity)) {
            rwb.a(this.jdField_a_of_type_AndroidAppActivity, "video_type_videopublic");
          }
          for (;;)
          {
            b((qht)localObject3, (BaseArticleInfo)localObject1);
            return;
            bbmy.a(this.jdField_a_of_type_AndroidAppActivity, -1, 2131652615, 0).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131167766));
            rwb.b(this.jdField_a_of_type_AndroidAppActivity, "video_type_videopublic");
          }
        }
        a((qht)localObject3, (BaseArticleInfo)localObject1);
        return;
        localObject1 = (BaseArticleInfo)paramView.getTag();
      } while (localObject1 == null);
      if (paramView.getId() == 2131303455) {}
      for (boolean bool = true;; bool = false)
      {
        b(bool, (BaseArticleInfo)localObject1);
        return;
      }
      paramView = (BaseArticleInfo)paramView.getTag();
    } while (paramView == null);
    label1944:
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
    } while (qzk.a().b());
    bool1 = bool2;
    if (nsh.b() == 1) {
      bool1 = true;
    }
    a(paramView, true, bool1);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qoe
 * JD-Core Version:    0.7.0.1
 */