import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.v4.os.TraceCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.RecycledViewPool;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoInfo.ChannelInfo;
import com.tencent.biz.pubaccount.VideoInfo.LikeActionDownloadBar;
import com.tencent.biz.pubaccount.VideoInfo.SoftAdDownloadBarInfo;
import com.tencent.biz.pubaccount.readinjoy.biu.ReadInJoyDeliverBiuActivity;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.FusionBiuInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.UrlJumpInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.video.ADVideoAppDownloadManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter.1;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter.11;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter.4;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsOptView;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class qlp
  extends RecyclerView.Adapter<qmd>
  implements View.OnClickListener, View.OnLongClickListener, qoa, qrh, qwy, qwz
{
  private int jdField_a_of_type_Int;
  public long a;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Context jdField_a_of_type_AndroidContentContext;
  private ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private Handler jdField_a_of_type_AndroidOsHandler = new qlr(this, Looper.getMainLooper());
  private LinearLayoutManager jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager;
  private RecyclerView.RecycledViewPool jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$RecycledViewPool = new RecyclerView.RecycledViewPool();
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private bfti jdField_a_of_type_Bfti;
  private bfut jdField_a_of_type_Bfut;
  private VideoInfo jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
  private ADVideoAppDownloadManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager;
  private VideoFeedsPlayManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager;
  private VideoFeedsRecyclerView jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView;
  private VideoPreDownloadMgr jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr;
  public GdtHandler.Params a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private INetInfoHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new qlq(this);
  private String jdField_a_of_type_JavaLangString;
  public HashMap<String, Integer> a;
  private List<VideoInfo> jdField_a_of_type_JavaUtilList;
  private Map<Integer, Bitmap> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  private nzv jdField_a_of_type_Nzv;
  private qjf jdField_a_of_type_Qjf;
  private qkp jdField_a_of_type_Qkp;
  private qkr jdField_a_of_type_Qkr;
  private qkv jdField_a_of_type_Qkv;
  private qmc jdField_a_of_type_Qmc;
  private qmf jdField_a_of_type_Qmf;
  qmi jdField_a_of_type_Qmi;
  private qmp jdField_a_of_type_Qmp;
  private qmu jdField_a_of_type_Qmu;
  private qnv jdField_a_of_type_Qnv;
  private qpo jdField_a_of_type_Qpo;
  private qpv jdField_a_of_type_Qpv;
  private qrf jdField_a_of_type_Qrf;
  private qrj jdField_a_of_type_Qrj;
  public qrn a;
  private qsq jdField_a_of_type_Qsq;
  private qsu jdField_a_of_type_Qsu;
  private qte jdField_a_of_type_Qte;
  private qzb jdField_a_of_type_Qzb;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = 1;
  private long jdField_b_of_type_Long;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private String jdField_b_of_type_JavaLangString;
  private Set<String> jdField_b_of_type_JavaUtilSet = new HashSet();
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = 5;
  private long jdField_c_of_type_Long;
  private Drawable jdField_c_of_type_AndroidGraphicsDrawableDrawable;
  private Set<String> jdField_c_of_type_JavaUtilSet = new HashSet();
  private boolean jdField_c_of_type_Boolean = true;
  private int jdField_d_of_type_Int;
  private Drawable jdField_d_of_type_AndroidGraphicsDrawableDrawable;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int;
  private boolean jdField_e_of_type_Boolean = true;
  private int jdField_f_of_type_Int;
  private boolean jdField_f_of_type_Boolean;
  private int jdField_g_of_type_Int;
  private boolean jdField_g_of_type_Boolean = true;
  private boolean h;
  private boolean i;
  private boolean j;
  private boolean k;
  private boolean l;
  private boolean m;
  private boolean n;
  private boolean o;
  private boolean p;
  private boolean q;
  private boolean r;
  private final boolean s;
  private boolean t;
  private boolean u;
  private boolean v = true;
  
  public qlp(Context paramContext, Activity paramActivity, VideoFeedsRecyclerView paramVideoFeedsRecyclerView, LinearLayoutManager paramLinearLayoutManager, QQAppInterface paramQQAppInterface, String paramString1, String paramString2, boolean paramBoolean, int paramInt, qrj paramqrj)
  {
    this.jdField_a_of_type_Long = -2147483648L;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_Qrn = new qls(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView = paramVideoFeedsRecyclerView;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.a(this.jdField_a_of_type_Qrn);
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager = paramLinearLayoutManager;
    this.jdField_c_of_type_AndroidGraphicsDrawableDrawable = bbef.a(true);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130842518);
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130842553);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getMinimumWidth(), this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getMinimumHeight());
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getMinimumWidth(), this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getMinimumHeight());
    this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131165275));
    this.jdField_a_of_type_Qkr = qkr.a();
    this.jdField_a_of_type_Qkv = new qkv(paramActivity);
    this.jdField_a_of_type_Qpo = new qpo(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Bfti = new bfti(this.jdField_a_of_type_AndroidAppActivity);
    AppNetConnInfo.registerConnectionChangeReceiver(this.jdField_a_of_type_AndroidAppActivity.getApplication(), this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    this.jdField_d_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(1930498322);
    this.jdField_a_of_type_Qrj = paramqrj;
    setHasStableIds(true);
    registerAdapterDataObserver(new qmb(this, null));
    this.r = axmv.b();
    this.jdField_a_of_type_Nzv = new nzv(paramActivity, this);
    if (Aladdin.getConfig(260).getIntegerFromString("interact_button_style", 0) == 1) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      this.s = paramBoolean;
      return;
    }
  }
  
  private Drawable a(int paramInt)
  {
    Bitmap localBitmap;
    if (!this.jdField_a_of_type_JavaUtilMap.containsKey(Integer.valueOf(paramInt)))
    {
      localBitmap = BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidContentContext.getResources(), paramInt);
      if (localBitmap == null) {
        return this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(paramInt);
      }
      this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), localBitmap);
    }
    for (;;)
    {
      return new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), localBitmap);
      localBitmap = (Bitmap)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
    }
  }
  
  private String a(int paramInt)
  {
    if (paramInt == 1) {
      return ajya.a(2131716256);
    }
    if (paramInt == 2) {
      return ajya.a(2131716253);
    }
    return null;
  }
  
  private String a(VideoInfo paramVideoInfo, int paramInt)
  {
    return oar.a(this.jdField_a_of_type_AndroidAppActivity, paramVideoInfo, paramInt);
  }
  
  @NonNull
  private String a(VideoInfo paramVideoInfo, Resources paramResources)
  {
    return oar.a(this.jdField_a_of_type_AndroidAppActivity, paramVideoInfo, paramResources);
  }
  
  private void a(RecyclerView paramRecyclerView, List<VideoInfo> paramList, int paramInt)
  {
    int i2 = paramRecyclerView.getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      RecyclerView.ViewHolder localViewHolder = paramRecyclerView.getChildViewHolder(paramRecyclerView.getChildAt(i1));
      if ((localViewHolder instanceof qmp))
      {
        VideoInfo localVideoInfo = (VideoInfo)paramList.get(((qmp)localViewHolder).jdField_b_of_type_Int);
        if ((localVideoInfo.e()) && (localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_a_of_type_Int == paramInt)) {
          ((qmp)localViewHolder).jdField_a_of_type_Qjo.b(localVideoInfo);
        }
      }
      i1 += 1;
    }
  }
  
  private void a(View paramView, int paramInt, VideoInfo paramVideoInfo)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.d())) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.b();
    }
    if (this.jdField_a_of_type_Nzv != null) {
      this.jdField_a_of_type_Nzv.a(paramView, paramInt, paramVideoInfo);
    }
  }
  
  private void a(VideoAdInfo paramVideoAdInfo)
  {
    paramVideoAdInfo = nmc.a(paramVideoAdInfo);
    if (paramVideoAdInfo != null) {
      shq.a(this.jdField_a_of_type_AndroidAppActivity, paramVideoAdInfo.mPopFormH5Url, paramVideoAdInfo.mAdRl, paramVideoAdInfo.mAdTraceId);
    }
  }
  
  private void a(VideoInfo paramVideoInfo, int paramInt)
  {
    if (paramVideoInfo == null) {
      return;
    }
    AdvertisementInfo localAdvertisementInfo = nmc.a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
    if (paramVideoInfo.a(this.jdField_a_of_type_AndroidAppActivity))
    {
      nmc.a(new nyd().a(this.jdField_a_of_type_AndroidContentContext).a(nmc.jdField_a_of_type_Int).b(nmc.P).a(localAdvertisementInfo).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).d(paramInt).a());
      return;
    }
    nmc.a(new nyd().a(this.jdField_a_of_type_AndroidContentContext).a(nmc.jdField_a_of_type_Int).b(nmc.N).a(localAdvertisementInfo).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).d(paramInt).a());
  }
  
  private void a(VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo, int paramInt)
  {
    if (paramAdvertisementInfo == null) {
      return;
    }
    shq.b(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, true, null);
    paramAdvertisementInfo = nmc.a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
    nmc.a(new nyd().a(this.jdField_a_of_type_AndroidContentContext).a(nmc.jdField_a_of_type_Int).b(nmc.Y).a(paramAdvertisementInfo).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).d(paramInt).a());
  }
  
  private void a(VideoInfo paramVideoInfo, qzb paramqzb)
  {
    boolean bool = true;
    Object localObject2;
    Object localObject1;
    if (this.jdField_a_of_type_Boolean)
    {
      localObject2 = paramVideoInfo.jdField_j_of_type_JavaLangString;
      if (!TextUtils.isEmpty(paramVideoInfo.jdField_g_of_type_JavaLangString)) {}
      for (localObject1 = paramVideoInfo.jdField_g_of_type_JavaLangString;; localObject1 = "0")
      {
        nol.b(null, (String)localObject2, "0X8009298", "0X8009298", 0, 0, "0", "", (String)localObject1, paramqzb.a().a(), false);
        try
        {
          if ((paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.fusionBiuInfo.jdField_c_of_type_Boolean) && (!paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.fusionBiuInfo.jdField_d_of_type_Boolean))
          {
            rlz.a().a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, 0, 2, 2);
            paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.fusionBiuInfo.jdField_d_of_type_Boolean = true;
          }
          return;
        }
        catch (NullPointerException paramVideoInfo)
        {
          int i1;
          paramVideoInfo.printStackTrace();
        }
      }
    }
    else
    {
      if ((!TextUtils.isEmpty(paramVideoInfo.J)) && (qoi.d()))
      {
        i1 = 1;
        label142:
        localObject1 = paramqzb.T(i1);
        if (!paramVideoInfo.e()) {
          break label421;
        }
        i1 = 2;
        label158:
        localObject1 = ((qzb)localObject1).Z(i1);
        if (!paramVideoInfo.e()) {
          break label426;
        }
        i1 = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_a_of_type_Int;
        label181:
        localObject1 = ((qzb)localObject1).u(i1);
        if ((!paramVideoInfo.e()) || (TextUtils.isEmpty(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_g_of_type_JavaLangString)) || (TextUtils.isEmpty(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.f))) {
          break label431;
        }
        i1 = 1;
        label224:
        localObject2 = ((qzb)localObject1).aa(i1);
        if ((!paramVideoInfo.e()) || (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo == null)) {
          break label436;
        }
        localObject1 = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.e;
        label261:
        localObject2 = ((qzb)localObject2).o((String)localObject1);
        if ((!paramVideoInfo.e()) || (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.d == null)) {
          break label444;
        }
        localObject1 = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.d.e;
        label299:
        localObject1 = ((qzb)localObject2).p((String)localObject1);
        if (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo == null) {
          break label452;
        }
        label315:
        localObject2 = ((qzb)localObject1).k(bool);
        if ((paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo == null) || (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo == null)) {
          break label458;
        }
        localObject1 = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.e;
        label353:
        ((qzb)localObject2).q((String)localObject1);
        localObject2 = paramVideoInfo.jdField_j_of_type_JavaLangString;
        if (TextUtils.isEmpty(paramVideoInfo.jdField_g_of_type_JavaLangString)) {
          break label466;
        }
      }
      label421:
      label426:
      label431:
      label436:
      label444:
      label452:
      label458:
      label466:
      for (localObject1 = paramVideoInfo.jdField_g_of_type_JavaLangString;; localObject1 = "0")
      {
        nol.b(null, (String)localObject2, "0X8007801", "0X8007801", 0, 0, "0", "", (String)localObject1, paramqzb.a().a(), false);
        break;
        i1 = 0;
        break label142;
        i1 = 1;
        break label158;
        i1 = 0;
        break label181;
        i1 = 0;
        break label224;
        localObject1 = "";
        break label261;
        localObject1 = "";
        break label299;
        bool = false;
        break label315;
        localObject1 = "";
        break label353;
      }
    }
  }
  
  private void a(VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    try
    {
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, ReadInJoyDeliverBiuActivity.class);
      if ((paramVideoInfo.jdField_a_of_type_Int == 6) && (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null)) {
        localIntent.putExtra("feedsType", paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedType);
      }
      localIntent.putExtra("ARG_VIDEO_ARTICLE_ID", paramVideoInfo.jdField_g_of_type_JavaLangString);
      localIntent.putExtra("biu_src", 2);
      localIntent.putExtra("arg_from_type", 8);
      localIntent.putExtra("arg_article_info", paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      localIntent.putExtra("fast_biu_type", paramBoolean);
      this.jdField_a_of_type_AndroidAppActivity.startActivityForResult(localIntent, 102);
      this.jdField_a_of_type_AndroidAppActivity.overridePendingTransition(0, 0);
      return;
    }
    catch (Exception paramVideoInfo)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "innerOpenReadInJoyBiuActivity error exception = " + paramVideoInfo.getMessage());
    }
  }
  
  private void a(VideoInfo paramVideoInfo, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramVideoInfo == null) {
      return;
    }
    a(paramVideoInfo, paramBoolean2);
    Object localObject1;
    int i1;
    if ((paramVideoInfo.jdField_a_of_type_Int == 0) && (paramVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null))
    {
      localObject1 = paramVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5();
      localObject1 = new qzb((String)localObject1, paramVideoInfo.jdField_j_of_type_JavaLangString, paramVideoInfo.jdField_a_of_type_JavaLangString, paramVideoInfo.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(), paramVideoInfo.a() * 1000);
      localObject2 = ((qzb)localObject1).g(paramBoolean1).h(paramBoolean2);
      if (!this.s) {
        break label295;
      }
      i1 = 1;
      label95:
      ((qzb)localObject2).c(i1);
      if (!this.jdField_a_of_type_Boolean)
      {
        ((qzb)localObject1).e(paramVideoInfo.f).d(paramVideoInfo.jdField_r_of_type_Int).a(-1).a(paramVideoInfo.N).O(0);
        localObject2 = new qca();
        ((qca)localObject2).jdField_d_of_type_Int = ((int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a());
        ((qca)localObject2).jdField_e_of_type_Int = (paramVideoInfo.a() * 1000);
        ((qca)localObject2).jdField_b_of_type_Int = this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
        npu.b(paramVideoInfo, this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_CHANNEL_ID", -1), 25, -1, (qca)localObject2, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_g_of_type_JavaLangString);
      }
      localObject1 = ((qzb)localObject1).a().a();
      if (!this.jdField_a_of_type_Boolean) {
        break label308;
      }
      localObject2 = paramVideoInfo.jdField_j_of_type_JavaLangString;
      if (TextUtils.isEmpty(paramVideoInfo.jdField_g_of_type_JavaLangString)) {
        break label301;
      }
    }
    label295:
    label301:
    for (paramVideoInfo = paramVideoInfo.jdField_g_of_type_JavaLangString;; paramVideoInfo = "0")
    {
      nol.a(null, (String)localObject2, "0X8009299", "0X8009299", 0, 0, "0", "0", paramVideoInfo, (String)localObject1, false);
      return;
      localObject1 = null;
      break;
      i1 = 0;
      break label95;
    }
    label308:
    Object localObject2 = paramVideoInfo.jdField_j_of_type_JavaLangString;
    if (!TextUtils.isEmpty(paramVideoInfo.jdField_g_of_type_JavaLangString)) {}
    for (paramVideoInfo = paramVideoInfo.jdField_g_of_type_JavaLangString;; paramVideoInfo = "0")
    {
      nol.a(null, (String)localObject2, "0X8007B89", "0X8007B89", 0, 0, "0", "0", paramVideoInfo, (String)localObject1, false);
      return;
    }
  }
  
  private void a(KandianUrlImageView paramKandianUrlImageView, VideoInfo paramVideoInfo)
  {
    if ((paramKandianUrlImageView == null) || (paramVideoInfo == null)) {
      return;
    }
    if ((!qoi.d()) || (TextUtils.isEmpty(paramVideoInfo.J)))
    {
      paramKandianUrlImageView.setVisibility(8);
      return;
    }
    Object localObject;
    if (paramVideoInfo.J.endsWith("zip"))
    {
      localObject = oqb.a(paramVideoInfo.J);
      ((oqb)localObject).setRepeatCount(0);
      paramKandianUrlImageView.setImageDrawable((Drawable)localObject);
      if ((paramKandianUrlImageView.getVisibility() == 8) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.d()) && (this.jdField_a_of_type_Qmf.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == paramVideoInfo)) {
        ((oqb)localObject).playAnimation();
      }
    }
    for (;;)
    {
      paramKandianUrlImageView.setVisibility(0);
      return;
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
      paramKandianUrlImageView.setImageDrawable(URLDrawable.getDrawable(paramVideoInfo.J, (URLDrawable.URLDrawableOptions)localObject));
    }
  }
  
  private void a(KandianUrlImageView paramKandianUrlImageView, VideoInfo paramVideoInfo, Boolean paramBoolean)
  {
    int[] arrayOfInt;
    if (paramKandianUrlImageView.getVisibility() == 0)
    {
      arrayOfInt = paramVideoInfo.a(this.jdField_a_of_type_AndroidAppActivity, paramBoolean.booleanValue());
      if ((arrayOfInt[0] >= 0) && (arrayOfInt[1] >= 0)) {}
    }
    else
    {
      return;
    }
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)paramKandianUrlImageView.getLayoutParams();
    localLayoutParams.topMargin = arrayOfInt[0];
    localLayoutParams.rightMargin = arrayOfInt[1];
    if ((paramBoolean.booleanValue()) || (paramVideoInfo.b(this.jdField_a_of_type_AndroidAppActivity))) {
      localLayoutParams.width = actj.a(91.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    }
    for (localLayoutParams.height = actj.a(28.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());; localLayoutParams.height = actj.a(24.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()))
    {
      paramKandianUrlImageView.setLayoutParams(localLayoutParams);
      return;
      localLayoutParams.width = actj.a(78.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    }
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "followPubAccount() uin=" + paramString);
    }
    if ((paramString == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
    do
    {
      return;
      qoi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramBoolean);
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      paramBoolean = false;
      while (localIterator.hasNext())
      {
        Object localObject = (VideoInfo)localIterator.next();
        boolean bool = paramBoolean | a((VideoInfo)localObject, paramString);
        paramBoolean = bool;
        if (((VideoInfo)localObject).d != null)
        {
          localObject = ((VideoInfo)localObject).d.iterator();
          for (;;)
          {
            paramBoolean = bool;
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            bool = a((VideoInfo)((Iterator)localObject).next(), paramString) | bool;
          }
        }
      }
      if (paramBoolean) {
        a(paramString);
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "followPubAccount() isDataChanged=" + paramBoolean);
  }
  
  private void a(qma paramqma)
  {
    int i1;
    Object localObject;
    if ((paramqma != null) && (paramqma.jdField_a_of_type_Qql != null) && (paramqma.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (paramqma.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo != null))
    {
      i1 = oaq.c(nmc.a(paramqma.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo));
      if (i1 != 1) {
        break label84;
      }
      paramqma = paramqma.jdField_d_of_type_AndroidViewView;
      localObject = (LinearLayout.LayoutParams)paramqma.getLayoutParams();
      if (localObject != null)
      {
        ((LinearLayout.LayoutParams)localObject).weight = 2.0F;
        paramqma.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
    label84:
    do
    {
      do
      {
        return;
      } while (i1 != 2);
      localObject = paramqma.jdField_e_of_type_AndroidViewView;
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((View)localObject).getLayoutParams();
      if (localLayoutParams != null)
      {
        localLayoutParams.weight = 0.0F;
        ((View)localObject).setLayoutParams(localLayoutParams);
      }
      paramqma = paramqma.jdField_f_of_type_AndroidViewView;
      localObject = (LinearLayout.LayoutParams)paramqma.getLayoutParams();
    } while (localObject == null);
    ((LinearLayout.LayoutParams)localObject).weight = 0.0F;
    paramqma.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  private void a(qma paramqma, VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo, int paramInt, View[] paramArrayOfView1, View[] paramArrayOfView2)
  {
    int i1 = 8;
    int i2 = 0;
    if (paramVideoInfo.jdField_c_of_type_Boolean)
    {
      if ((!AdvertisementInfo.isAppAdvertisementInfo(paramAdvertisementInfo)) || (!oaq.d(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo))) {
        break label318;
      }
      if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager.a(paramVideoInfo)) {
        break label130;
      }
      shq.b(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, true, null);
      if (paramInt == nmc.Y)
      {
        paramqma = nmc.a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
        nmc.a(new nyd().a(this.jdField_a_of_type_AndroidContentContext).a(nmc.jdField_a_of_type_Int).b(nmc.Y).a(paramqma).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).d(nmc.aL).a());
      }
    }
    else
    {
      return;
    }
    a(paramVideoInfo, nmc.at);
    return;
    label130:
    oar.a(paramAdvertisementInfo, 0, null);
    int i3 = paramArrayOfView1.length;
    i1 = 0;
    while (i1 < i3)
    {
      paramArrayOfView1[i1].setVisibility(0);
      i1 += 1;
    }
    paramqma.jdField_a_of_type_Boolean = true;
    i3 = paramArrayOfView2.length;
    i1 = i2;
    while (i1 < i3)
    {
      paramArrayOfView2[i1].setVisibility(8);
      i1 += 1;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager.f();
    if (paramInt == nmc.Y)
    {
      nmc.a(new nyd().a(this.jdField_a_of_type_AndroidContentContext).a(nmc.jdField_a_of_type_Int).b(nmc.ak).a(paramAdvertisementInfo).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).d(nmc.aL).a());
      return;
    }
    nmc.a(new nyd().a(this.jdField_a_of_type_AndroidContentContext).a(nmc.jdField_a_of_type_Int).b(nmc.ak).a(paramAdvertisementInfo).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).a());
    return;
    label318:
    if (paramInt == nmc.Y)
    {
      paramInt = 38;
      paramqma = nmc.a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
      nmc.a(new nyd().a(this.jdField_a_of_type_AndroidContentContext).a(nmc.jdField_a_of_type_Int).b(nmc.Y).a(paramqma).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).d(nmc.aL).a());
    }
    for (;;)
    {
      if (paramAdvertisementInfo != null) {
        paramAdvertisementInfo.setClickPos(paramInt);
      }
      paramqma = new nxz();
      paramqma.jdField_c_of_type_Boolean = true;
      shq.b(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, true, paramqma);
      return;
      paramInt = i1;
      if (this.i) {
        paramInt = 13;
      }
      a(paramVideoInfo, nmc.at);
    }
  }
  
  private void a(qma paramqma, boolean paramBoolean1, boolean paramBoolean2, View paramView1, View paramView2, TextView paramTextView1, Drawable paramDrawable1, Drawable paramDrawable2, View paramView3, TextView paramTextView2)
  {
    if (paramView1 != null) {
      paramView1.setVisibility(8);
    }
    if (paramBoolean2)
    {
      paramView2.setVisibility(0);
      paramView2.getParent().requestDisallowInterceptTouchEvent(true);
      paramView2.setOnClickListener(this);
      paramView2.setTag(paramqma);
      Object localObject = null;
      paramView1 = localObject;
      if (paramTextView1 != null)
      {
        paramView1 = localObject;
        if (paramqma.jdField_a_of_type_Qql != null)
        {
          paramView1 = a(paramqma.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo, this.jdField_a_of_type_AndroidContentContext.getResources());
          paramTextView1.setText(paramView1);
        }
      }
      if (!paramBoolean1) {
        break label123;
      }
      paramView2.setBackgroundDrawable(paramDrawable1);
    }
    for (this.i = true;; this.i = false)
    {
      a(paramBoolean1, paramView3, paramTextView2, paramView1);
      return;
      label123:
      if ((oaq.a()) && (paramDrawable2 != null)) {
        paramView2.setBackgroundDrawable(paramDrawable2);
      }
    }
  }
  
  private void a(qmd paramqmd, VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo, int paramInt, View paramView, View... paramVarArgs)
  {
    int i1 = 0;
    if ((paramVideoInfo.jdField_c_of_type_Boolean) && (AdvertisementInfo.isAppAdvertisementInfo(paramAdvertisementInfo)) && (oaq.d(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo)))
    {
      if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager.a(paramVideoInfo)) {
        break label118;
      }
      shq.b(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, true, null);
      if (paramInt == nmc.Y) {
        nmc.a(new nyd().a(this.jdField_a_of_type_AndroidContentContext).a(nmc.jdField_a_of_type_Int).b(nmc.Y).a(paramAdvertisementInfo).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).d(nmc.aL).a());
      }
    }
    else
    {
      return;
    }
    a(paramVideoInfo, nmc.at);
    return;
    label118:
    paramView.setVisibility(0);
    ((qma)paramqmd).jdField_a_of_type_Boolean = true;
    paramInt = i1;
    while (paramInt < paramVarArgs.length)
    {
      paramVarArgs[paramInt].setVisibility(8);
      paramInt += 1;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager.f();
  }
  
  private void a(qmf paramqmf)
  {
    if ((this.jdField_a_of_type_Qmf != null) && (this.jdField_a_of_type_Qmf.jdField_a_of_type_Qql != null) && (this.jdField_a_of_type_Qmf.jdField_a_of_type_Qql.jdField_a_of_type_Qty != null))
    {
      int i1 = this.jdField_a_of_type_Qmf.jdField_a_of_type_Qql.jdField_a_of_type_Qty.e();
      if ((i1 != 0) && (i1 != 1) && (i1 != 2) && (this.jdField_a_of_type_Qmf.jdField_c_of_type_Int == paramqmf.jdField_c_of_type_Int - 1) && (bbfj.h(this.jdField_a_of_type_AndroidAppActivity)) && (bhvy.t(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.b(paramqmf.jdField_a_of_type_Qql);
      }
    }
  }
  
  private void a(qmf paramqmf, VideoInfo paramVideoInfo)
  {
    qql localqql2 = paramqmf.jdField_a_of_type_Qql;
    qql localqql1 = localqql2;
    if (localqql2 == null)
    {
      localqql1 = new qql();
      localqql1.jdField_a_of_type_Qjs = paramqmf.jdField_a_of_type_Qth;
      localqql1.jdField_a_of_type_AndroidOsBundle.putInt("jump_from_scene", this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("PERFORMANCE_REPORT_VIDEO_FEEDS_JUMP_FROM", 0));
    }
    localqql1.jdField_a_of_type_ComTencentBizPubaccountVideoInfo = paramVideoInfo;
    localqql1.jdField_a_of_type_Int = paramVideoInfo.c(this.jdField_a_of_type_AndroidAppActivity);
    localqql1.jdField_a_of_type_AndroidViewViewGroup = paramqmf.jdField_b_of_type_AndroidViewViewGroup;
    localqql1.jdField_b_of_type_Int = paramqmf.jdField_c_of_type_Int;
    localqql1.jdField_a_of_type_Boolean = false;
    localqql1.jdField_a_of_type_AndroidOsBundle.putInt("video_feeds_index", paramqmf.jdField_c_of_type_Int);
    localqql1.jdField_a_of_type_Long = 0L;
    localqql1.jdField_b_of_type_Boolean = true;
    if (paramVideoInfo.jdField_c_of_type_Boolean)
    {
      if (!paramVideoInfo.a(this.jdField_a_of_type_AndroidAppActivity)) {
        break label170;
      }
      localqql1.jdField_a_of_type_AndroidOsBundle.putInt("ad_origin", nmc.P);
    }
    for (;;)
    {
      paramqmf.jdField_a_of_type_Qth.jdField_a_of_type_Boolean = true;
      paramqmf.jdField_a_of_type_Qql = localqql1;
      paramqmf.jdField_a_of_type_Qyv.a(this, paramqmf);
      return;
      label170:
      localqql1.jdField_a_of_type_AndroidOsBundle.putInt("ad_origin", nmc.N);
    }
  }
  
  private void a(qmf paramqmf1, qmf paramqmf2)
  {
    VideoInfo localVideoInfo;
    qzb localqzb1;
    if ((paramqmf2 != null) && (paramqmf2.jdField_c_of_type_Int == paramqmf1.jdField_c_of_type_Int))
    {
      localVideoInfo = paramqmf1.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
      localqzb1 = new qzb(paramqmf1.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
      localqzb1.h(localVideoInfo.jdField_g_of_type_JavaLangString).l(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).n(paramqmf1.jdField_b_of_type_Int).m(paramqmf1.jdField_c_of_type_Int);
      if (paramqmf1.jdField_b_of_type_Int != paramqmf2.jdField_b_of_type_Int + 1) {
        break label124;
      }
      nol.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localVideoInfo.jdField_j_of_type_JavaLangString, "0X8009952", "0X8009952", 0, 0, "", "", "", localqzb1.a().a(), false);
    }
    label124:
    while (paramqmf1.jdField_b_of_type_Int != paramqmf2.jdField_b_of_type_Int - 1) {
      return;
    }
    qzb localqzb2 = localqzb1.p(0);
    if (paramqmf2.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) {}
    for (paramqmf1 = paramqmf2.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_g_of_type_JavaLangString;; paramqmf1 = "")
    {
      localqzb2.h(paramqmf1);
      nol.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localVideoInfo.jdField_j_of_type_JavaLangString, "0X8009953", "0X8009953", 0, 0, "", "", "", localqzb1.a().a(), false);
      return;
    }
  }
  
  private void a(qmf paramqmf1, qmf paramqmf2, boolean paramBoolean)
  {
    Activity localActivity = this.jdField_a_of_type_AndroidAppActivity;
    VideoInfo localVideoInfo = paramqmf1.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
    int i1 = paramqmf1.jdField_b_of_type_Int;
    int i2 = paramqmf1.jdField_c_of_type_Int;
    int i3 = paramqmf1.jdField_a_of_type_Int;
    ThreadManager.post(new VideoFeedsAdapter.4(this, localVideoInfo, localActivity, i2, paramqmf1.jdField_b_of_type_Boolean, i1, paramBoolean, i3, paramqmf1, paramqmf2), 1, null, true);
  }
  
  private void a(qmi paramqmi)
  {
    if (this.jdField_b_of_type_Int == 1)
    {
      paramqmi.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      paramqmi.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      paramqmi.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramqmi.jdField_a_of_type_AndroidWidgetTextView.setText(a(1));
    }
    do
    {
      return;
      if (this.jdField_b_of_type_Int == 2)
      {
        paramqmi.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
        paramqmi.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        paramqmi.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        paramqmi.jdField_a_of_type_AndroidWidgetTextView.setText(a(2));
        return;
      }
    } while (this.jdField_b_of_type_Int != 3);
    if (paramqmi.jdField_a_of_type_Int == 6)
    {
      paramqmi.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      paramqmi.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      paramqmi.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramqmi.jdField_a_of_type_AndroidWidgetTextView.setText(a(1));
      return;
    }
    paramqmi.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
    paramqmi.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    paramqmi.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  private void a(qmp paramqmp, VideoInfo paramVideoInfo)
  {
    if (paramqmp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView != null) {
      paramqmp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView.a();
    }
    if (paramqmp.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView != null) {
      paramqmp.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView.a();
    }
    if (paramqmp.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView != null) {
      paramqmp.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView.a();
    }
    if ((paramVideoInfo.jdField_g_of_type_Int == 1) || (paramVideoInfo.jdField_g_of_type_Int == 2))
    {
      if (paramVideoInfo.jdField_g_of_type_Int != 1) {
        break label486;
      }
      if (bbfr.a(BaseApplicationImpl.getContext(), paramVideoInfo.B)) {
        break label419;
      }
      if ((paramqmp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView != null) && (!TextUtils.isEmpty(paramVideoInfo.m)) && (!TextUtils.isEmpty(paramVideoInfo.n))) {
        paramqmp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView.setImageUrl(paramVideoInfo, paramVideoInfo.q, this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0), this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("key_source", 0), this.jdField_a_of_type_Boolean, this, paramVideoInfo.h, paramVideoInfo.jdField_g_of_type_Int, paramVideoInfo.m, paramVideoInfo.n, 28, paramVideoInfo.p, "VideoPlay_ContentMix", paramVideoInfo.jdField_c_of_type_JavaLangString, paramVideoInfo.C, paramVideoInfo.i, paramVideoInfo.jdField_j_of_type_Int);
      }
      if ((paramqmp.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView != null) && (!TextUtils.isEmpty(paramVideoInfo.jdField_r_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramVideoInfo.s))) {
        paramqmp.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView.setImageUrl(paramVideoInfo, paramVideoInfo.v, this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0), this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("key_source", 0), this.jdField_a_of_type_Boolean, this, paramVideoInfo.h, paramVideoInfo.jdField_g_of_type_Int, paramVideoInfo.jdField_r_of_type_JavaLangString, paramVideoInfo.s, 29, paramVideoInfo.jdField_u_of_type_JavaLangString, "VideoPlay_RedEnvelope", paramVideoInfo.jdField_c_of_type_JavaLangString, paramVideoInfo.C, paramVideoInfo.i, paramVideoInfo.jdField_j_of_type_Int);
      }
      if ((paramqmp.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView != null) && (!TextUtils.isEmpty(paramVideoInfo.w)) && (!TextUtils.isEmpty(paramVideoInfo.x))) {
        paramqmp.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView.setImageUrl(paramVideoInfo, paramVideoInfo.A, this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0), this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("key_source", 0), this.jdField_a_of_type_Boolean, this, paramVideoInfo.h, paramVideoInfo.jdField_g_of_type_Int, paramVideoInfo.w, paramVideoInfo.x, 30, paramVideoInfo.z, "VideoPlay_Shooting", paramVideoInfo.jdField_c_of_type_JavaLangString, paramVideoInfo.C, paramVideoInfo.i, paramVideoInfo.jdField_j_of_type_Int);
      }
    }
    label419:
    label486:
    do
    {
      return;
      if (paramVideoInfo.p.contains("?"))
      {
        VideoFeedsOptView.a(paramVideoInfo.p + "&acttype=109");
        return;
      }
      VideoFeedsOptView.a(paramVideoInfo.p + "?acttype=109");
      return;
      if (!bbfr.a(BaseApplicationImpl.getContext(), paramVideoInfo.B)) {
        break;
      }
      if ((paramqmp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView != null) && (!TextUtils.isEmpty(paramVideoInfo.m)) && (!TextUtils.isEmpty(paramVideoInfo.o))) {
        paramqmp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView.setImageUrl(paramVideoInfo, paramVideoInfo.q, this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0), this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("key_source", 0), this.jdField_a_of_type_Boolean, this, paramVideoInfo.h, paramVideoInfo.jdField_g_of_type_Int, paramVideoInfo.m, paramVideoInfo.o, 28, paramVideoInfo.p, "VideoPlay_ContentMix", paramVideoInfo.jdField_c_of_type_JavaLangString, paramVideoInfo.C, paramVideoInfo.i, paramVideoInfo.jdField_j_of_type_Int);
      }
      if ((paramqmp.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView != null) && (!TextUtils.isEmpty(paramVideoInfo.jdField_r_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramVideoInfo.t))) {
        paramqmp.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView.setImageUrl(paramVideoInfo, paramVideoInfo.v, this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0), this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("key_source", 0), this.jdField_a_of_type_Boolean, this, paramVideoInfo.h, paramVideoInfo.jdField_g_of_type_Int, paramVideoInfo.jdField_r_of_type_JavaLangString, paramVideoInfo.t, 29, paramVideoInfo.jdField_u_of_type_JavaLangString, "VideoPlay_RedEnvelope", paramVideoInfo.jdField_c_of_type_JavaLangString, paramVideoInfo.C, paramVideoInfo.i, paramVideoInfo.jdField_j_of_type_Int);
      }
    } while ((paramqmp.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView == null) || (TextUtils.isEmpty(paramVideoInfo.w)) || (TextUtils.isEmpty(paramVideoInfo.y)));
    paramqmp.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView.setImageUrl(paramVideoInfo, paramVideoInfo.A, this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0), this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("key_source", 0), this.jdField_a_of_type_Boolean, this, paramVideoInfo.h, paramVideoInfo.jdField_g_of_type_Int, paramVideoInfo.w, paramVideoInfo.y, 30, paramVideoInfo.z, "VideoPlay_Shooting", paramVideoInfo.jdField_c_of_type_JavaLangString, paramVideoInfo.C, paramVideoInfo.i, paramVideoInfo.jdField_j_of_type_Int);
    return;
    if (paramVideoInfo.p.contains("?"))
    {
      VideoFeedsOptView.a(paramVideoInfo.p + "&acttype=109");
      return;
    }
    VideoFeedsOptView.a(paramVideoInfo.p + "?acttype=109");
  }
  
  private void a(qmp paramqmp, boolean paramBoolean, long paramLong, int paramInt)
  {
    if (paramBoolean)
    {
      if (this.jdField_b_of_type_Long != 0L) {
        ThreadManager.excute(new VideoFeedsAdapter.1(this, paramLong), 16, null, true);
      }
      if ((paramqmp.jdField_a_of_type_Qql != null) && (paramqmp.jdField_a_of_type_Qql.jdField_a_of_type_Qbu != null))
      {
        paramqmp.jdField_a_of_type_Qql.jdField_a_of_type_Qbu.n = paramLong;
        paramqmp.jdField_a_of_type_Qql.jdField_a_of_type_Qbu.jdField_r_of_type_Int = onh.a(paramInt, paramqmp.jdField_c_of_type_Int, false);
      }
      if ((paramqmp.jdField_a_of_type_Qql != null) && (paramqmp.jdField_a_of_type_Qql.jdField_a_of_type_Qbt != null)) {
        paramqmp.jdField_a_of_type_Qql.jdField_a_of_type_Qbt.jdField_a_of_type_Boolean = true;
      }
    }
  }
  
  private void a(boolean paramBoolean, View paramView, TextView paramTextView, String paramString)
  {
    if ((paramView == null) || (paramTextView == null)) {}
    do
    {
      do
      {
        return;
        if (!oaq.a()) {
          break;
        }
        paramView.setVisibility(8);
        paramTextView.setVisibility(0);
      } while (TextUtils.isEmpty(paramString));
      paramTextView.setText(paramString);
      return;
      if (!paramBoolean) {
        break;
      }
      paramView.setVisibility(8);
      paramTextView.setVisibility(0);
    } while (TextUtils.isEmpty(paramString));
    paramTextView.setText(paramString);
    return;
    paramView.setVisibility(0);
    paramTextView.setVisibility(8);
  }
  
  private void a(boolean paramBoolean, qma paramqma)
  {
    if (!a(paramqma)) {
      return;
    }
    TextView localTextView1 = paramqma.jdField_d_of_type_AndroidWidgetTextView;
    View localView = paramqma.jdField_a_of_type_AndroidViewView;
    TextView localTextView2 = paramqma.jdField_e_of_type_AndroidWidgetTextView;
    if (localView != null) {}
    for (boolean bool = true;; bool = false)
    {
      GradientDrawable localGradientDrawable1 = new GradientDrawable();
      localGradientDrawable1.setColor(Color.parseColor("#FF12B7F6"));
      localGradientDrawable1.setCornerRadius(actj.a(4.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
      GradientDrawable localGradientDrawable2 = new GradientDrawable();
      if (oaq.a())
      {
        localGradientDrawable1.setColor(Color.parseColor("#FF12B7F6"));
        localGradientDrawable1.setCornerRadius(actj.a(6.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
        localGradientDrawable2.setColor(Color.parseColor("#1AFFFFFF"));
        localGradientDrawable2.setCornerRadius(actj.a(6.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
      }
      a(paramqma, paramBoolean, bool, localTextView1, localView, localTextView2, localGradientDrawable1, localGradientDrawable2, paramqma.jdField_b_of_type_AndroidViewView, paramqma.jdField_f_of_type_AndroidWidgetTextView);
      return;
    }
  }
  
  private void a(boolean paramBoolean, qmp paramqmp)
  {
    if (!qma.class.isInstance(paramqmp)) {
      return;
    }
    paramqmp = (qma)paramqmp;
    int i1;
    if ((paramqmp.jdField_a_of_type_Qql != null) && (paramqmp.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (oaq.c(paramqmp.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo)) && (!paramqmp.jdField_a_of_type_Boolean))
    {
      a(paramBoolean, paramqmp);
      if (paramqmp.jdField_a_of_type_Qql != null)
      {
        if (!c(paramqmp.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo)) {
          break label338;
        }
        i1 = 8;
        label85:
        if (!c(paramqmp.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo)) {
          break label343;
        }
      }
    }
    label338:
    label343:
    for (int i2 = 0;; i2 = 8)
    {
      paramqmp.jdField_d_of_type_AndroidWidgetTextView.setVisibility(i1);
      paramqmp.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(i2);
      if (oaq.a()) {
        paramqmp.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      if (paramqmp.jdField_c_of_type_AndroidViewView != null)
      {
        paramqmp.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
        paramqmp.jdField_c_of_type_AndroidViewView.getParent().requestDisallowInterceptTouchEvent(true);
        paramqmp.jdField_c_of_type_AndroidViewView.setTag(paramqmp);
      }
      if (paramqmp.r != null)
      {
        paramqmp.r.setOnClickListener(this);
        paramqmp.r.getParent().requestDisallowInterceptTouchEvent(true);
        paramqmp.r.setTag(paramqmp);
      }
      if ((paramqmp.jdField_b_of_type_AndroidWidgetSeekBar != null) && (!paramqmp.jdField_a_of_type_Boolean)) {
        paramqmp.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(0);
      }
      if ((paramqmp.jdField_c_of_type_AndroidViewView != null) && (!paramqmp.jdField_a_of_type_Boolean)) {
        paramqmp.jdField_c_of_type_AndroidViewView.setVisibility(8);
      }
      if ((paramqmp.jdField_c_of_type_AndroidViewView != null) && (c(paramqmp.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo)))
      {
        paramqmp.jdField_c_of_type_AndroidViewView.setVisibility(8);
        paramqmp.jdField_a_of_type_AndroidViewView.setVisibility(8);
      }
      if ((paramqmp.jdField_c_of_type_AndroidViewView != null) && (paramqmp.jdField_c_of_type_AndroidViewView.getVisibility() == 0))
      {
        paramqmp.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
        paramqmp.jdField_a_of_type_AndroidViewView.setVisibility(8);
      }
      a(paramqmp);
      return;
      b(paramBoolean, paramqmp);
      break;
      i1 = 0;
      break label85;
    }
  }
  
  private boolean a(RecyclerView paramRecyclerView, List<VideoInfo> paramList, VideoInfo paramVideoInfo)
  {
    int i2 = paramRecyclerView.getChildCount();
    int i3 = paramList.indexOf(paramVideoInfo);
    int i1 = 0;
    while (i1 < i2)
    {
      paramList = paramRecyclerView.getChildViewHolder(paramRecyclerView.getChildAt(i1));
      if ((i3 >= 0) && ((paramList instanceof qmp)) && (((qmp)paramList).jdField_b_of_type_Int == i3))
      {
        ((qmp)paramList).jdField_a_of_type_Qjo.b(paramVideoInfo);
        return true;
      }
      i1 += 1;
    }
    return false;
  }
  
  private boolean a(RecyclerView paramRecyclerView, List<VideoInfo> paramList, String paramString)
  {
    int i2 = paramRecyclerView.getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      RecyclerView.ViewHolder localViewHolder = paramRecyclerView.getChildViewHolder(paramRecyclerView.getChildAt(i1));
      if ((localViewHolder instanceof qmp))
      {
        VideoInfo localVideoInfo = (VideoInfo)paramList.get(((qmp)localViewHolder).jdField_b_of_type_Int);
        if (paramString.equals(localVideoInfo.jdField_j_of_type_JavaLangString)) {
          ((qmp)localViewHolder).jdField_a_of_type_Qjo.b(localVideoInfo);
        }
      }
      i1 += 1;
    }
    return false;
  }
  
  public static boolean a(VideoAdInfo paramVideoAdInfo)
  {
    if (paramVideoAdInfo == null) {}
    do
    {
      return false;
      paramVideoAdInfo = nmc.a(paramVideoAdInfo);
    } while ((TextUtils.isEmpty(paramVideoAdInfo.mPopFormH5Url)) || (!oaq.d(paramVideoAdInfo)));
    return true;
  }
  
  private boolean a(VideoInfo paramVideoInfo, String paramString)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = bool3;
    if (paramVideoInfo.jdField_j_of_type_JavaLangString != null)
    {
      bool1 = bool3;
      if (paramVideoInfo.jdField_j_of_type_JavaLangString.equals(paramString))
      {
        bool1 = bool2;
        if (!paramVideoInfo.jdField_k_of_type_Boolean) {
          bool1 = true;
        }
        paramVideoInfo.jdField_k_of_type_Boolean = true;
      }
    }
    return bool1;
  }
  
  private boolean a(qma paramqma)
  {
    boolean bool3 = true;
    boolean bool1 = true;
    boolean bool2 = bool1;
    if (paramqma != null)
    {
      bool2 = bool1;
      if (paramqma.jdField_a_of_type_Qql != null)
      {
        if (paramqma.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) {
          break label34;
        }
        bool2 = bool1;
      }
    }
    label34:
    do
    {
      return bool2;
      Object localObject = paramqma.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
      bool1 = bool3;
      if (((VideoInfo)localObject).jdField_c_of_type_Boolean)
      {
        localObject = nmc.a(((VideoInfo)localObject).jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
        bool1 = bool3;
        if (localObject != null)
        {
          bool1 = bool3;
          if (!((AdvertisementInfo)localObject).mShowAdButton)
          {
            if (paramqma.jdField_d_of_type_AndroidWidgetTextView != null) {
              paramqma.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
            }
            if (paramqma.jdField_a_of_type_AndroidViewView != null) {
              paramqma.jdField_a_of_type_AndroidViewView.setVisibility(8);
            }
            bool1 = false;
          }
        }
      }
      bool2 = bool1;
    } while (!QLog.isColorLevel());
    QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "showButton = " + bool1);
    return bool1;
  }
  
  private boolean a(qmp paramqmp)
  {
    boolean bool = true;
    paramqmp.jdField_a_of_type_Qth.jdField_a_of_type_Boolean = false;
    Bundle localBundle;
    int i2;
    int i1;
    if ((paramqmp.jdField_c_of_type_Int == this.jdField_e_of_type_Int) && (this.jdField_a_of_type_AndroidContentContext != null) && (paramqmp.jdField_a_of_type_Qql != null) && (paramqmp.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null))
    {
      localBundle = this.jdField_a_of_type_AndroidAppActivity.getIntent().getExtras();
      i2 = localBundle.getInt("VIDEO_FROM_TYPE", 0);
      if (!bbfj.b(this.jdField_a_of_type_AndroidContentContext))
      {
        i1 = 1;
        if (i2 != 27) {
          break label121;
        }
        paramqmp = paramqmp.jdField_a_of_type_Qth;
        if ((i1 != 0) || (this.jdField_f_of_type_Boolean)) {
          break label115;
        }
        label102:
        paramqmp.jdField_a_of_type_Boolean = bool;
      }
    }
    label115:
    label244:
    label247:
    for (;;)
    {
      return false;
      i1 = 0;
      break;
      bool = false;
      break label102;
      label121:
      if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()))
      {
        if ((!bbfj.b(this.jdField_a_of_type_AndroidContentContext)) || (this.jdField_f_of_type_Boolean))
        {
          paramqmp.jdField_a_of_type_Qth.jdField_a_of_type_Boolean = false;
          return true;
        }
        i1 = localBundle.getInt("VIDEO_PLAY_STATUS", 0);
        if (((2 == i2) || (6 == i2) || (5 == i2)) && (3 == i1))
        {
          paramqmp.jdField_a_of_type_Qth.jdField_a_of_type_Boolean = false;
          if ((i2 != 0) && (1 != i2) && (12 != i2) && (11 != i2)) {
            break label244;
          }
        }
        for (i1 = 1;; i1 = 0)
        {
          if (i1 != 0) {
            break label247;
          }
          return true;
          paramqmp.jdField_a_of_type_Qth.jdField_a_of_type_Boolean = true;
          break;
        }
      }
    }
  }
  
  private void b(qma paramqma)
  {
    int i1;
    Object localObject;
    if ((paramqma != null) && (paramqma.jdField_a_of_type_Qql != null) && (paramqma.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (paramqma.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo != null))
    {
      i1 = oaq.c(nmc.a(paramqma.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo));
      if (i1 != 1) {
        break label88;
      }
      paramqma = paramqma.jdField_l_of_type_AndroidViewView;
      if (paramqma != null)
      {
        localObject = (LinearLayout.LayoutParams)paramqma.getLayoutParams();
        if (localObject != null)
        {
          ((LinearLayout.LayoutParams)localObject).weight = 2.0F;
          paramqma.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
      }
    }
    label88:
    do
    {
      do
      {
        do
        {
          return;
        } while (i1 != 2);
        localObject = paramqma.jdField_m_of_type_AndroidViewView;
        if (localObject != null)
        {
          LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((View)localObject).getLayoutParams();
          if (localLayoutParams != null)
          {
            localLayoutParams.weight = 0.0F;
            ((View)localObject).setLayoutParams(localLayoutParams);
          }
        }
        paramqma = paramqma.n;
      } while (paramqma == null);
      localObject = (LinearLayout.LayoutParams)paramqma.getLayoutParams();
    } while (localObject == null);
    ((LinearLayout.LayoutParams)localObject).weight = 0.0F;
    paramqma.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  private void b(qmf paramqmf)
  {
    paramqmf = paramqmf.jdField_a_of_type_Qql;
    if ((paramqmf != null) && ((paramqmf.jdField_a_of_type_Boolean) || ((paramqmf.jdField_a_of_type_Qty != null) && (paramqmf.jdField_a_of_type_Qty.e() != 0))))
    {
      paramqmf.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.c(paramqmf);
    }
  }
  
  private void b(boolean paramBoolean, qma paramqma)
  {
    if (oaq.a()) {
      a(paramBoolean, paramqma);
    }
    while (!a(paramqma)) {
      return;
    }
    View localView = paramqma.jdField_a_of_type_AndroidViewView;
    TextView localTextView = paramqma.jdField_d_of_type_AndroidWidgetTextView;
    if ((localTextView != null) && (!paramqma.jdField_a_of_type_Boolean)) {}
    for (boolean bool = true;; bool = false)
    {
      ColorDrawable localColorDrawable = new ColorDrawable();
      localColorDrawable.setColor(Color.parseColor("#FF12B7F6"));
      a(paramqma, paramBoolean, bool, localView, localTextView, localTextView, localColorDrawable, null, paramqma.jdField_b_of_type_AndroidViewView, paramqma.jdField_f_of_type_AndroidWidgetTextView);
      return;
    }
  }
  
  private void c(qma paramqma)
  {
    if ((paramqma == null) || (paramqma.jdField_c_of_type_AndroidViewView == null) || (paramqma.g == null) || (paramqma.jdField_l_of_type_AndroidViewViewGroup == null) || (this.jdField_a_of_type_AndroidContentContext == null) || (this.jdField_a_of_type_AndroidContentContext.getResources() == null)) {
      return;
    }
    if ((paramqma.jdField_c_of_type_AndroidViewView != null) && (c(paramqma.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo))) {
      paramqma.jdField_c_of_type_AndroidViewView.setVisibility(8);
    }
    View localView = paramqma.jdField_c_of_type_AndroidViewView;
    Object localObject = new GradientDrawable();
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
    TextView localTextView = paramqma.g;
    RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)localTextView.getLayoutParams();
    if (paramqma.jdField_l_of_type_AndroidViewViewGroup.getVisibility() == 0)
    {
      ((GradientDrawable)localObject).setCornerRadius(actj.a(6.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
      localLayoutParams.height = actj.a(31.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      localLayoutParams.topMargin = actj.a(8.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      localLayoutParams.bottomMargin = actj.a(10.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      localLayoutParams.leftMargin = actj.a(15.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      localLayoutParams.rightMargin = actj.a(15.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      if (localLayoutParams1 != null)
      {
        localLayoutParams1.addRule(13);
        localTextView.setLayoutParams(localLayoutParams1);
      }
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130842177);
    }
    for (;;)
    {
      localView.setLayoutParams(localLayoutParams);
      if ((paramqma.jdField_a_of_type_AndroidWidgetProgressBar == null) || (localObject == null)) {
        break;
      }
      paramqma.jdField_a_of_type_AndroidWidgetProgressBar.setProgressDrawable((Drawable)localObject);
      return;
      localLayoutParams.height = actj.a(42.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      localLayoutParams.topMargin = actj.a(15.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      localLayoutParams.bottomMargin = actj.a(0.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      localLayoutParams.leftMargin = actj.a(0.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      localLayoutParams.rightMargin = actj.a(0.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      ((GradientDrawable)localObject).setCornerRadius(actj.a(0.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130842175);
      if (localLayoutParams1 != null)
      {
        localLayoutParams1.addRule(15);
        localTextView.setLayoutParams(localLayoutParams1);
      }
    }
  }
  
  private static boolean c(VideoInfo paramVideoInfo)
  {
    return oar.a(paramVideoInfo);
  }
  
  private void e(VideoInfo paramVideoInfo)
  {
    int i2 = 1;
    if (paramVideoInfo == null) {
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("channel_id", 409409);
      if (!paramVideoInfo.jdField_l_of_type_Boolean) {
        break label299;
      }
      i1 = 0;
      localJSONObject.put("type", i1);
      if (paramVideoInfo.N == null) {
        break label304;
      }
      str1 = paramVideoInfo.N;
      label60:
      localJSONObject.put("video_report_info", str1);
      if (!paramVideoInfo.jdField_l_of_type_Boolean) {
        break label103;
      }
      if (this.jdField_a_of_type_Qpv == null) {
        break label357;
      }
      i1 = this.jdField_a_of_type_Qpv.a();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str1;
        label103:
        String str2;
        label161:
        label191:
        label213:
        label236:
        String str4;
        String str3;
        label299:
        label304:
        label320:
        label325:
        label333:
        label339:
        continue;
        int i1 = 0;
        continue;
        i1 = 0;
        continue;
        i1 = 0;
      }
    }
    localJSONObject.put("style", i1);
    localJSONObject.put("algorithm_id", paramVideoInfo.f);
    if (this.jdField_a_of_type_Qpo != null)
    {
      if (!this.jdField_a_of_type_Qpo.a()) {
        break label362;
      }
      i1 = 1;
      localJSONObject.put("is_display_download_bar", i1);
      if (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LikeActionDownloadBar != null)
      {
        str1 = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LikeActionDownloadBar.jdField_c_of_type_JavaLangString;
        localJSONObject.put("common_data", str1);
        localJSONObject.put("video_type", 0);
        if (!this.s) {
          break label320;
        }
        i1 = i2;
        localJSONObject.put("interact_button_style", i1);
        if (!this.jdField_a_of_type_Boolean) {
          break label325;
        }
        str1 = "0X800929C";
        if ((paramVideoInfo.jdField_a_of_type_Int != 0) || (paramVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null)) {
          break label333;
        }
        str2 = paramVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5();
        str4 = paramVideoInfo.jdField_j_of_type_JavaLangString;
        if (TextUtils.isEmpty(paramVideoInfo.jdField_g_of_type_JavaLangString)) {
          break label339;
        }
      }
      for (str3 = paramVideoInfo.jdField_g_of_type_JavaLangString;; str3 = "0")
      {
        nol.a(null, str4, str1, str1, 0, 0, "0", "0", str3, npu.a(str2, paramVideoInfo.jdField_j_of_type_JavaLangString, paramVideoInfo.jdField_a_of_type_JavaLangString, paramVideoInfo.jdField_g_of_type_JavaLangString, localJSONObject), false);
        return;
        i1 = 1;
        break;
        str1 = "";
        break label60;
        str1 = "";
        break label161;
        i1 = 0;
        break label191;
        str1 = "0X80091A9";
        break label213;
        str2 = null;
        break label236;
      }
    }
  }
  
  private void f(VideoInfo paramVideoInfo)
  {
    int i1 = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_a_of_type_Int;
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "innerSubscribeColume() columeid=" + i1);
    }
    qoi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i1);
    paramVideoInfo = this.jdField_a_of_type_JavaUtilList.iterator();
    while (paramVideoInfo.hasNext())
    {
      VideoInfo localVideoInfo = (VideoInfo)paramVideoInfo.next();
      if ((localVideoInfo.e()) && (localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_a_of_type_Int == i1))
      {
        localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_a_of_type_Boolean = true;
        VideoColumnInfo localVideoColumnInfo = localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo;
        localVideoColumnInfo.jdField_c_of_type_Int += 1;
        b(localVideoInfo);
      }
    }
    b(i1);
  }
  
  private void g(VideoInfo paramVideoInfo)
  {
    if (paramVideoInfo.jdField_a_of_type_JavaUtilArrayList != null)
    {
      int i1 = 0;
      if (i1 < paramVideoInfo.jdField_a_of_type_JavaUtilArrayList.size())
      {
        Object localObject = (VideoInfo.ChannelInfo)paramVideoInfo.jdField_a_of_type_JavaUtilArrayList.get(i1);
        localObject = new qzb("", "", paramVideoInfo.jdField_a_of_type_JavaLangString, paramVideoInfo.jdField_g_of_type_JavaLangString).u(((VideoInfo.ChannelInfo)localObject).jdField_a_of_type_Int).v(qoi.a((VideoInfo.ChannelInfo)localObject)).a(paramVideoInfo.N).a().a();
        if (this.jdField_a_of_type_Boolean) {
          nol.a(null, "", "0X8009330", "0X8009330", 0, 0, "3", "", "", (String)localObject, false);
        }
        for (;;)
        {
          i1 += 1;
          break;
          nol.a(null, "", "0X80092F8", "0X80092F8", 0, 0, "3", "", "", (String)localObject, false);
        }
      }
    }
  }
  
  private void g(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "handleConnetNetWorkChange");
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager == null) || (!this.jdField_c_of_type_Boolean)) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.f(paramBoolean);
    this.jdField_a_of_type_AndroidOsHandler.post(new VideoFeedsAdapter.11(this, paramBoolean));
  }
  
  private void h()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(2, null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.b(false);
  }
  
  private void i()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr = new VideoPreDownloadMgr(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a = new quk(quk.jdField_c_of_type_Int, quk.jdField_f_of_type_Int);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a(new qlu(this));
  }
  
  private void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "handleNotNetWorkChange mIsActivityOnResume = " + this.jdField_c_of_type_Boolean);
    }
    if (!this.jdField_c_of_type_Boolean) {}
    while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.f(false);
  }
  
  public VideoInfo a(String paramString)
  {
    Object localObject;
    if (TextUtils.isEmpty(paramString))
    {
      localObject = null;
      return localObject;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    VideoInfo localVideoInfo;
    do
    {
      while (!((Iterator)localObject).hasNext())
      {
        do
        {
          if (!localIterator.hasNext()) {
            break label103;
          }
          localVideoInfo = (VideoInfo)localIterator.next();
          localObject = localVideoInfo;
          if (paramString.equals(localVideoInfo.jdField_g_of_type_JavaLangString)) {
            break;
          }
        } while (localVideoInfo.d == null);
        localObject = localVideoInfo.d.iterator();
      }
      localVideoInfo = (VideoInfo)((Iterator)localObject).next();
    } while (!paramString.equals(localVideoInfo.jdField_g_of_type_JavaLangString));
    return localVideoInfo;
    label103:
    return null;
  }
  
  public qmd a(ViewGroup paramViewGroup, int paramInt)
  {
    Object localObject1 = LayoutInflater.from(paramViewGroup.getContext());
    Object localObject2;
    switch (paramInt)
    {
    case 3: 
    default: 
      localObject2 = null;
      paramViewGroup = null;
      localObject1 = null;
      if (paramViewGroup != null)
      {
        paramViewGroup.jdField_a_of_type_Qjo = ((qjo)localObject2);
        paramViewGroup.jdField_a_of_type_Qth = new qth(paramViewGroup, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager, this.jdField_f_of_type_Boolean);
        return paramViewGroup;
      }
      break;
    case 2: 
      localObject1 = qro.a(2131560064, true, new ViewGroup.LayoutParams(-1, -1));
      paramViewGroup = (qmo)((View)localObject1).getTag();
      if (paramViewGroup == null) {
        paramViewGroup = qmo.a((View)localObject1);
      }
      break;
    }
    for (;;)
    {
      localObject2 = new qmj(this, (qmo)paramViewGroup);
      localObject1 = null;
      break;
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560055, paramViewGroup, false);
      ((LayoutInflater)localObject1).inflate(2131560081, (ViewGroup)paramViewGroup.findViewById(2131364537), true);
      ((LayoutInflater)localObject1).inflate(2131560078, (ViewGroup)paramViewGroup.findViewById(2131364535), true);
      ((LayoutInflater)localObject1).inflate(2131560079, (ViewGroup)paramViewGroup.findViewById(2131364533), true);
      paramViewGroup = new qma(paramViewGroup, paramInt);
      localObject2 = new qlv(this, (qma)paramViewGroup);
      localObject1 = null;
      break;
      localObject2 = qro.a(2131560060, true, new ViewGroup.LayoutParams(-1, -1));
      localObject1 = (qmi)((View)localObject2).getTag();
      paramViewGroup = (ViewGroup)localObject1;
      if (localObject1 == null) {
        paramViewGroup = new qmi((View)localObject2, paramInt);
      }
      this.jdField_a_of_type_Qmi = paramViewGroup;
      localObject2 = null;
      localObject1 = paramViewGroup;
      paramViewGroup = null;
      break;
      return localObject1;
    }
  }
  
  public qnv a()
  {
    return this.jdField_a_of_type_Qnv;
  }
  
  public qsu a()
  {
    return this.jdField_a_of_type_Qsu;
  }
  
  public void a()
  {
    int i1 = this.jdField_a_of_type_JavaUtilList.size();
    int i2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.c();
    RecyclerView.ViewHolder localViewHolder = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.findViewHolderForLayoutPosition(i1 + i2 - 1);
    if ((localViewHolder instanceof qmi)) {
      a((qmi)localViewHolder);
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_e_of_type_Int = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_c_of_type_Int = paramInt1;
    this.jdField_d_of_type_Int = paramInt2;
  }
  
  public void a(long paramLong)
  {
    this.jdField_c_of_type_Long = paramLong;
  }
  
  public void a(View paramView)
  {
    if ((this.jdField_a_of_type_Qmu != null) && (this.jdField_a_of_type_Qmu.a()) && (this.jdField_a_of_type_Qmu.b()))
    {
      this.jdField_a_of_type_Qmu.h();
      break label34;
    }
    for (;;)
    {
      label34:
      return;
      if (!this.v) {
        continue;
      }
      paramView = (qmf)paramView.getTag();
      if (paramView != this.jdField_a_of_type_Qmf)
      {
        if (this.jdField_a_of_type_Qmf == null) {
          break;
        }
        if ((paramView != null) && (paramView.jdField_c_of_type_Int == this.jdField_a_of_type_Qmf.jdField_c_of_type_Int + 1) && (paramView.jdField_c_of_type_Int != getItemCount()))
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.a();
          return;
        }
        if ((paramView == null) || (paramView.jdField_c_of_type_Int != this.jdField_a_of_type_Qmf.jdField_c_of_type_Int - 1)) {
          break;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.b();
        return;
      }
      paramView.jdField_a_of_type_Qjo.c();
      JSONObject localJSONObject;
      switch (paramView.jdField_a_of_type_Int)
      {
      case 3: 
      case 4: 
      case 6: 
      default: 
      case 2: 
        if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager == null) || (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.d())) {
          continue;
        }
        localJSONObject = new JSONObject();
      case 5: 
      case 7: 
        try
        {
          localJSONObject.put("channel_id", 409409);
          label221:
          nol.a(null, null, "0X80091AB", "0X80091AB", 0, 0, "", "", "", npu.a(null, null, paramView.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, paramView.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_g_of_type_JavaLangString, localJSONObject), false);
          return;
          if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager == null) || (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.d())) {
            continue;
          }
          localJSONObject = new JSONObject();
          try
          {
            localJSONObject.put("channel_id", 409409);
            label307:
            nol.a(null, null, "0X80091AB", "0X80091AB", 0, 0, "", "", "", npu.a(null, null, paramView.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, paramView.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_g_of_type_JavaLangString, localJSONObject), false);
            return;
          }
          catch (JSONException localJSONException1)
          {
            break label307;
          }
        }
        catch (JSONException localJSONException2)
        {
          break label221;
        }
      }
    }
  }
  
  public void a(View paramView, int paramInt)
  {
    paramView = (qmp)paramView.getTag();
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (!this.t);
        paramView.jdField_a_of_type_Qjo.a(1);
        this.t = false;
        return;
      } while (paramView.d.getVisibility() != 0);
      paramView.jdField_a_of_type_Qjo.a(2);
    } while (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.b());
    this.t = true;
  }
  
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    qmp localqmp = (qmp)paramView.getTag();
    if (localqmp != this.jdField_a_of_type_Qmf) {}
    while ((!this.v) || (localqmp == null) || (localqmp.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == null) || (!(localqmp instanceof qmf)) || (TextUtils.isEmpty(localqmp.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_g_of_type_JavaLangString))) {
      return;
    }
    Object localObject = localqmp.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
    boolean bool;
    int i1;
    label108:
    JSONObject localJSONObject;
    if (!((VideoInfo)localObject).jdField_l_of_type_Boolean)
    {
      bool = true;
      ((VideoInfo)localObject).jdField_l_of_type_Boolean = true;
      if (!bool) {
        break label570;
      }
      i1 = ((VideoInfo)localObject).jdField_u_of_type_Int + 1;
      ((VideoInfo)localObject).jdField_u_of_type_Int = i1;
      if ((this.jdField_a_of_type_Qpo != null) && ((localqmp instanceof qmo)))
      {
        int i2 = 0;
        i1 = i2;
        if (this.jdField_a_of_type_Qsq != null)
        {
          i1 = i2;
          if (this.jdField_a_of_type_Qsq.a()) {
            i1 = 1;
          }
        }
        if (i1 == 0) {
          this.jdField_a_of_type_Qpo.a((VideoInfo)localObject, (qmo)localqmp);
        }
      }
      localqmp.jdField_a_of_type_Qjo.a(paramInt1, paramInt2, bool);
      if (bool)
      {
        if (this.jdField_a_of_type_Qmc != null) {
          this.jdField_a_of_type_Qmc.a((VideoInfo)localObject, ((VideoInfo)localObject).jdField_l_of_type_Boolean);
        }
        e((VideoInfo)localObject);
      }
      if (this.jdField_a_of_type_Qrf != null) {
        this.jdField_a_of_type_Qrf.a(3, (VideoInfo)localObject, 0L);
      }
      localJSONObject = new JSONObject();
      if ((localqmp.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int != 0) || (localqmp.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null)) {
        break label580;
      }
      paramView = localqmp.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5();
    }
    try
    {
      label298:
      localJSONObject.put("channel_id", 409409);
      localJSONObject.put("rowkey", localqmp.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_g_of_type_JavaLangString);
      if (this.jdField_a_of_type_Qpv == null) {
        break label585;
      }
      paramInt1 = this.jdField_a_of_type_Qpv.a();
      label345:
      localJSONObject.put("style", paramInt1);
      localJSONObject.put("algorithm_id", ((VideoInfo)localObject).f);
      paramInt1 = 0;
      if (this.jdField_a_of_type_Qpo != null)
      {
        if (!this.jdField_a_of_type_Qpo.a()) {
          break label590;
        }
        paramInt1 = 1;
      }
      label390:
      localJSONObject.put("is_display_download_bar", paramInt1);
      if (((VideoInfo)localObject).jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LikeActionDownloadBar == null) {
        break label595;
      }
      localObject = ((VideoInfo)localObject).jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LikeActionDownloadBar.jdField_c_of_type_JavaLangString;
      label418:
      localJSONObject.put("common_data", localObject);
      if (!this.s) {
        break label603;
      }
      paramInt1 = 1;
      label438:
      localJSONObject.put("interact_button_style", paramInt1);
    }
    catch (Exception localException)
    {
      label448:
      label460:
      String str2;
      String str1;
      label570:
      label580:
      label585:
      label590:
      label595:
      label603:
      label616:
      break label448;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      localObject = "0X80097F5";
      str2 = localqmp.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_j_of_type_JavaLangString;
      if (TextUtils.isEmpty(localqmp.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_g_of_type_JavaLangString)) {
        break label616;
      }
    }
    for (str1 = localqmp.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_g_of_type_JavaLangString;; str1 = "0")
    {
      nol.a(null, str2, (String)localObject, (String)localObject, 0, 0, "0", "0", str1, npu.a(paramView, localqmp.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_j_of_type_JavaLangString, localqmp.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, localqmp.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_g_of_type_JavaLangString, localJSONObject), false);
      return;
      bool = false;
      break;
      i1 = ((VideoInfo)localObject).jdField_u_of_type_Int;
      break label108;
      paramView = null;
      break label298;
      paramInt1 = 0;
      break label345;
      paramInt1 = 0;
      break label390;
      localObject = "";
      break label418;
      paramInt1 = 0;
      break label438;
      localObject = "0X80091AA";
      break label460;
    }
  }
  
  public void a(VideoInfo paramVideoInfo)
  {
    if ((paramVideoInfo != null) && (this.jdField_a_of_type_Qzb != null))
    {
      this.jdField_a_of_type_Qzb.a(paramVideoInfo.N);
      a(paramVideoInfo, this.jdField_a_of_type_Qzb);
      this.jdField_a_of_type_Qzb = null;
    }
  }
  
  public void a(ADVideoAppDownloadManager paramADVideoAppDownloadManager)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager = paramADVideoAppDownloadManager;
  }
  
  public void a(VideoFeedsPlayManager paramVideoFeedsPlayManager)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager = paramVideoFeedsPlayManager;
    i();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(new qlt(this));
  }
  
  public void a(VideoFeedsRecyclerView paramVideoFeedsRecyclerView, List<VideoInfo> paramList)
  {
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        ((VideoInfo)paramList.next()).a();
      }
    }
    int i2 = paramVideoFeedsRecyclerView.getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      paramList = paramVideoFeedsRecyclerView.getChildViewHolder(paramVideoFeedsRecyclerView.getChildAt(i1));
      if ((paramList instanceof qmp)) {
        ((qmp)paramList).jdField_a_of_type_Qjo.a();
      }
      i1 += 1;
    }
  }
  
  public void a(String paramString)
  {
    a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView, this.jdField_a_of_type_JavaUtilList, paramString);
  }
  
  public void a(List<VideoInfo> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void a(qjf paramqjf)
  {
    this.jdField_a_of_type_Qjf = paramqjf;
  }
  
  public void a(qkp paramqkp)
  {
    this.jdField_a_of_type_Qkp = paramqkp;
  }
  
  public void a(qmc paramqmc)
  {
    this.jdField_a_of_type_Qmc = paramqmc;
  }
  
  public void a(qmd paramqmd, int paramInt)
  {
    paramqmd.jdField_b_of_type_Int = paramInt;
    paramqmd.jdField_c_of_type_Int = paramInt;
    paramqmd.jdField_b_of_type_Boolean = true;
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size()))
    {
      if (this.jdField_a_of_type_Qkp != null)
      {
        VideoInfo localVideoInfo = this.jdField_a_of_type_Qkp.b(paramInt);
        if (localVideoInfo != null) {
          this.jdField_a_of_type_JavaUtilList.set(paramInt, localVideoInfo);
        }
      }
      a(paramqmd, (VideoInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt));
      return;
    }
    a(paramqmd, null);
  }
  
  public void a(qmd paramqmd, VideoInfo paramVideoInfo)
  {
    int i1 = paramqmd.jdField_a_of_type_Int;
    if ((i1 == 3) || (i1 == 6))
    {
      a((qmi)paramqmd);
      this.jdField_a_of_type_Qmi = ((qmi)paramqmd);
    }
    do
    {
      return;
      paramqmd = (qmf)paramqmd;
      b(paramqmd);
      a(paramqmd, paramVideoInfo);
      TraceCompat.beginSection("refreshMenuUI");
      paramqmd.jdField_a_of_type_Qjo.a(paramVideoInfo);
      TraceCompat.endSection();
      TraceCompat.beginSection("refreshContentUI");
      paramqmd.jdField_a_of_type_Qjo.a(paramVideoInfo, this.jdField_d_of_type_Boolean);
      TraceCompat.endSection();
      if ((this.h) && (paramqmd == this.jdField_a_of_type_Qmf)) {
        paramqmd.jdField_a_of_type_Qjo.e(this.h);
      }
    } while (!paramqmd.jdField_b_of_type_Boolean);
    a(paramqmd);
  }
  
  public void a(qmp paramqmp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsPlayManager.preplay", 2, "adapter playVideo (VideoItemHolder holder) ");
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(2, null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.d();
    int i1;
    boolean bool;
    label101:
    long l1;
    long l2;
    if (this.jdField_a_of_type_Qmf != null)
    {
      i1 = this.jdField_a_of_type_Qmf.jdField_c_of_type_Int;
      this.jdField_a_of_type_Qmf = paramqmp;
      if ((this.jdField_a_of_type_Qmf.jdField_c_of_type_Int == 0) && (this.jdField_a_of_type_Qmf.jdField_b_of_type_Int == 0))
      {
        paramqmp.jdField_a_of_type_Qql.jdField_a_of_type_Long = this.jdField_c_of_type_Long;
        this.jdField_c_of_type_Long = 0L;
      }
      if (!this.jdField_g_of_type_Boolean) {
        break label196;
      }
      bool = a(paramqmp);
      this.jdField_g_of_type_Boolean = false;
      l1 = System.currentTimeMillis();
      l2 = this.jdField_b_of_type_Long;
      if (!bool) {
        break label201;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(this.jdField_a_of_type_Qmf.jdField_a_of_type_Qql, false);
    }
    for (;;)
    {
      a(paramqmp, bool, l1 - l2, i1);
      if ((paramqmp.jdField_a_of_type_Qql != null) && (paramqmp.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null)) {
        sgg.a(paramqmp.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_g_of_type_JavaLangString, paramqmp.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, 0, 0);
      }
      return;
      i1 = -1;
      break;
      label196:
      bool = true;
      break label101;
      label201:
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(paramqmp.jdField_a_of_type_Qql);
    }
  }
  
  public void a(qmu paramqmu)
  {
    this.jdField_a_of_type_Qmu = paramqmu;
  }
  
  public void a(qnv paramqnv)
  {
    this.jdField_a_of_type_Qnv = paramqnv;
  }
  
  public void a(qpv paramqpv)
  {
    this.jdField_a_of_type_Qpv = paramqpv;
  }
  
  public void a(qrf paramqrf)
  {
    this.jdField_a_of_type_Qrf = paramqrf;
  }
  
  public void a(qsq paramqsq)
  {
    this.jdField_a_of_type_Qsq = paramqsq;
  }
  
  public void a(qsu paramqsu)
  {
    this.jdField_a_of_type_Qsu = paramqsu;
  }
  
  public void a(qte paramqte)
  {
    this.jdField_a_of_type_Qte = paramqte;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public boolean a(VideoInfo paramVideoInfo)
  {
    return (this.jdField_a_of_type_Qmf == null) || (this.jdField_a_of_type_Qmf.jdField_a_of_type_Qql == null) || (this.jdField_a_of_type_Qmf.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == paramVideoInfo);
  }
  
  public boolean a(String paramString)
  {
    return this.jdField_b_of_type_JavaUtilSet.contains(paramString);
  }
  
  public VideoInfo b(String paramString)
  {
    Object localObject;
    if (TextUtils.isEmpty(paramString))
    {
      localObject = null;
      return localObject;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    VideoInfo localVideoInfo;
    do
    {
      while (!((Iterator)localObject).hasNext())
      {
        do
        {
          if (!localIterator.hasNext()) {
            break label103;
          }
          localVideoInfo = (VideoInfo)localIterator.next();
          localObject = localVideoInfo;
          if (paramString.equals(localVideoInfo.jdField_a_of_type_JavaLangString)) {
            break;
          }
        } while (localVideoInfo.d == null);
        localObject = localVideoInfo.d.iterator();
      }
      localVideoInfo = (VideoInfo)((Iterator)localObject).next();
    } while (!paramString.equals(localVideoInfo.jdField_a_of_type_JavaLangString));
    return localVideoInfo;
    label103:
    return null;
  }
  
  public void b() {}
  
  public void b(int paramInt)
  {
    a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView, this.jdField_a_of_type_JavaUtilList, paramInt);
  }
  
  public void b(View paramView) {}
  
  public void b(VideoInfo paramVideoInfo)
  {
    a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView, this.jdField_a_of_type_JavaUtilList, paramVideoInfo);
  }
  
  public void b(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.jdField_a_of_type_AndroidAppActivity == null)) {
      return;
    }
    paramString = omj.jdField_k_of_type_JavaLangString + bbco.encodeToString(String.valueOf(paramString).getBytes(), 2);
    onh.a(this.jdField_a_of_type_AndroidAppActivity, paramString);
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_e_of_type_Boolean = paramBoolean;
  }
  
  public void c()
  {
    int i2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.getChildViewHolder(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.getChildAt(i1));
      if (((localObject instanceof qmp)) && (((qmp)localObject).jdField_c_of_type_Int == this.jdField_a_of_type_Qmf.jdField_c_of_type_Int + 1))
      {
        localObject = ((qmp)localObject).jdField_a_of_type_Qql;
        if ((localObject != null) && ((((qql)localObject).jdField_a_of_type_Boolean) || ((((qql)localObject).jdField_a_of_type_Qty != null) && (((qql)localObject).jdField_a_of_type_Qty.e() != 0))))
        {
          ((qql)localObject).jdField_a_of_type_Boolean = false;
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.c((qql)localObject);
        }
      }
      i1 += 1;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.e();
    }
  }
  
  public void c(int paramInt)
  {
    this.jdField_c_of_type_Boolean = false;
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(2, null);
    }
    ApngImage.pauseByTag(28);
    ApngImage.pauseByTag(29);
    ApngImage.pauseByTag(30);
    if (paramInt == 1) {
      oag.c(this.jdField_a_of_type_AndroidAppActivity);
    }
  }
  
  public void c(VideoInfo paramVideoInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo = paramVideoInfo;
  }
  
  public void c(boolean paramBoolean)
  {
    this.u = paramBoolean;
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_AndroidOsHandler != null) && (!this.q))
    {
      if (QLog.isColorLevel()) {
        QLog.d("NativeAdUtils", 2, "rePostMsgForAd");
      }
      this.q = true;
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(4, null);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(4, 1000L);
    }
  }
  
  public void d(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void d(VideoInfo paramVideoInfo)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.contains(paramVideoInfo)))
    {
      int i1 = this.jdField_a_of_type_JavaUtilList.indexOf(paramVideoInfo);
      h();
      this.jdField_a_of_type_JavaUtilList.remove(paramVideoInfo);
      this.jdField_a_of_type_Qmf = null;
      notifyItemRemoved(i1);
    }
  }
  
  public void d(boolean paramBoolean)
  {
    this.jdField_f_of_type_Boolean = paramBoolean;
  }
  
  public void e()
  {
    this.jdField_c_of_type_Boolean = true;
    shq.a(this);
    if ((this.jdField_a_of_type_Qmf != null) && (this.jdField_a_of_type_Qmf.jdField_a_of_type_Qjo != null) && ((this.jdField_a_of_type_Qmf.jdField_a_of_type_Qjo instanceof qlv))) {
      ((qlv)this.jdField_a_of_type_Qmf.jdField_a_of_type_Qjo).e();
    }
    ApngImage.playByTag(28);
    ApngImage.playByTag(29);
    ApngImage.playByTag(30);
    oag.d();
    oar.a(this.jdField_a_of_type_Qjf, this, (qmp)this.jdField_a_of_type_Qmf);
  }
  
  public void e(boolean paramBoolean)
  {
    if ((!this.o) && (paramBoolean) && (this.p))
    {
      if ((this.jdField_a_of_type_Qmf instanceof qmp)) {
        a((qmp)this.jdField_a_of_type_Qmf);
      }
      this.p = false;
    }
    this.o = paramBoolean;
  }
  
  public void f()
  {
    if ((this.jdField_a_of_type_Qzb != null) && (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null)) {
      a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo, this.jdField_a_of_type_Qzb);
    }
    if (this.jdField_a_of_type_Qmc != null) {
      this.jdField_a_of_type_Qmc = null;
    }
    if (this.jdField_a_of_type_Qmf != null) {
      this.jdField_a_of_type_Qmf.jdField_b_of_type_ComTencentImageURLImageView = null;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidOsHandler = null;
    this.jdField_a_of_type_Bfut = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    if (this.jdField_a_of_type_Nzv != null) {
      this.jdField_a_of_type_Nzv.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler != null) {
      AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    }
    if (this.jdField_a_of_type_Qkv != null)
    {
      this.jdField_a_of_type_Qkv.b();
      this.jdField_a_of_type_Qkv = null;
    }
    if (this.jdField_a_of_type_Qpo != null)
    {
      this.jdField_a_of_type_Qpo.a();
      this.jdField_a_of_type_Qpo = null;
    }
    oag.e();
  }
  
  public void f(boolean paramBoolean) {}
  
  public void g()
  {
    if ((this.jdField_a_of_type_Qmf == null) || (this.jdField_a_of_type_Qmf.jdField_a_of_type_Qql == null) || (this.jdField_a_of_type_Qmf.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == null) || (this.jdField_a_of_type_Qmf.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_b_of_type_Long <= 0L)) {
      return;
    }
    String str = ajya.a(2131716187);
    this.jdField_a_of_type_Qmf.jdField_a_of_type_Qyv.a(0, str, "点击重试");
  }
  
  public int getItemCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size() + 1;
  }
  
  public long getItemId(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return ((VideoInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt)).hashCode();
    }
    if ((this.jdField_a_of_type_Qmi != null) && (this.jdField_a_of_type_Qmi.itemView != null)) {
      return this.jdField_a_of_type_Qmi.itemView.hashCode();
    }
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size()))
    {
      VideoInfo localVideoInfo = (VideoInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if (!localVideoInfo.jdField_c_of_type_Boolean) {
        return 2;
      }
      if (localVideoInfo.jdField_l_of_type_Int == 1) {
        return 7;
      }
    }
    return 6;
  }
  
  @TargetApi(11)
  public void onClick(View paramView)
  {
    Object localObject3 = (qmd)paramView.getTag();
    VideoInfo localVideoInfo;
    if ((localObject3 instanceof qmp))
    {
      localVideoInfo = ((qmp)localObject3).jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
      if ((this.jdField_a_of_type_Qmf != null) && (this.jdField_a_of_type_Qmf.jdField_a_of_type_Qql != null) && (localVideoInfo == this.jdField_a_of_type_Qmf.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo)) {}
    }
    label549:
    label2598:
    label3759:
    for (;;)
    {
      label62:
      return;
      for (;;)
      {
        if (localVideoInfo == null) {
          break label3759;
        }
        Object localObject1 = null;
        long l1;
        if (localVideoInfo.jdField_c_of_type_Boolean)
        {
          localObject1 = oav.a(localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
          this.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params = shq.a(this.jdField_a_of_type_AndroidAppActivity, (AdvertisementInfo)localObject1, null, 3, false, null);
          if (this.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params != null)
          {
            l1 = SystemClock.elapsedRealtime();
            label118:
            this.jdField_a_of_type_Long = l1;
          }
        }
        else
        {
          if ((localVideoInfo.jdField_a_of_type_Int != 0) || (localVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null)) {
            break label549;
          }
        }
        Object localObject4;
        for (Object localObject2 = localVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5();; localObject2 = null)
        {
          localObject4 = new JSONObject();
          switch (paramView.getId())
          {
          default: 
            return;
          case 2131361821: 
            if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView == null) {
              break label62;
            }
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.a();
            return;
            l1 = -2147483648L;
            break label118;
          }
        }
        if (this.jdField_a_of_type_Qrj != null) {
          this.jdField_a_of_type_Qrj.b();
        }
        if (paramView.getId() != 2131365727) {
          break;
        }
        qyw.b(localVideoInfo.jdField_g_of_type_JavaLangString, 1);
        return;
        if ((this.jdField_a_of_type_Qmf.jdField_a_of_type_Qql == null) || (localVideoInfo == null)) {
          break;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.a(false);
        qyw.a(this.jdField_a_of_type_AndroidAppActivity, qjl.a(localVideoInfo), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(localVideoInfo.jdField_g_of_type_JavaLangString), 1, 0);
        qyw.a(localVideoInfo.jdField_g_of_type_JavaLangString, 1, 0);
        return;
        if ((((qmd)localObject3).jdField_a_of_type_Int == 2) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a() == 5)) {
          qoi.a(((qmp)localObject3).d, 8, 200);
        }
        if (this.jdField_a_of_type_Qrj == null) {
          break;
        }
        this.jdField_a_of_type_Qrj.b();
        return;
        if (((this.jdField_a_of_type_Qmf instanceof qmo)) && (!((qmo)this.jdField_a_of_type_Qmf).jdField_a_of_type_Boolean) && (rlz.a().b()) && (localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null))
        {
          localObject1 = localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.fusionBiuInfo;
          if (localObject1 == null) {
            break;
          }
          rlz.a().a(((qmp)localObject3).k, ((FusionBiuInfo)localObject1).jdField_b_of_type_Boolean);
          if (!((FusionBiuInfo)localObject1).jdField_b_of_type_Boolean) {
            rlz.a().a(paramView.getContext(), onh.a(), 1, 2, localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, 4, localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
          }
          for (;;)
          {
            rlz.a().b(localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, 0, 2, 2);
            return;
            rlz.a().a(paramView.getContext(), ((FusionBiuInfo)localObject1).jdField_a_of_type_Long, onh.a(), localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedType, 4, localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
          }
        }
        if (odo.a() == 1) {}
        for (boolean bool = true;; bool = false)
        {
          a(localVideoInfo, false, bool);
          if (this.jdField_a_of_type_Qrf == null) {
            break;
          }
          this.jdField_a_of_type_Qrf.a(2, localVideoInfo, 0L);
          return;
        }
        if ((this.jdField_a_of_type_Qmu != null) && (localVideoInfo.a(this.jdField_a_of_type_AndroidAppActivity))) {
          this.jdField_a_of_type_Qmu.h();
        }
        if (localVideoInfo.jdField_c_of_type_Boolean)
        {
          shq.b(this.jdField_a_of_type_AndroidAppActivity, (AdvertisementInfo)localObject1, null, 3, true, null);
          a(localVideoInfo, 0);
          return;
        }
        if (localVideoInfo.e())
        {
          qoi.a(this.jdField_a_of_type_AndroidAppActivity, localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo);
          localObject1 = new qzb(localVideoInfo).h(localVideoInfo.jdField_g_of_type_JavaLangString).u(localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_a_of_type_Int);
          if (localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo != null) {}
          for (paramView = localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.e;; paramView = "")
          {
            nol.b(null, "", "0X800A18C", "0X800A18C", 0, 0, "", "", "", ((qzb)localObject1).o(paramView).S(1).a().a(), false);
            return;
          }
        }
        if ((localVideoInfo.O != null) && (!localVideoInfo.O.equals("")))
        {
          onh.a(this.jdField_a_of_type_AndroidAppActivity, localVideoInfo.O);
          return;
        }
        if (localVideoInfo.jdField_a_of_type_Int == 6)
        {
          if (!TextUtils.isEmpty(localVideoInfo.jdField_j_of_type_JavaLangString))
          {
            paramView = omj.jdField_g_of_type_JavaLangString + bbco.encodeToString(localVideoInfo.jdField_j_of_type_JavaLangString.getBytes(), 2);
            onh.a(this.jdField_a_of_type_AndroidAppActivity, paramView);
          }
          localObject1 = new qzb((String)localObject2, localVideoInfo.jdField_j_of_type_JavaLangString, localVideoInfo.jdField_a_of_type_JavaLangString, localVideoInfo.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(), localVideoInfo.a() * 1000L).a(-1).O(0).a().a();
          localObject2 = localVideoInfo.jdField_j_of_type_JavaLangString;
          if (TextUtils.isEmpty(localVideoInfo.jdField_g_of_type_JavaLangString)) {
            break label1332;
          }
        }
        label1332:
        for (paramView = localVideoInfo.jdField_g_of_type_JavaLangString;; paramView = "0")
        {
          nol.a(null, (String)localObject2, "0X8007410", "0X8007410", 0, 0, "0", "", paramView, (String)localObject1, false);
          return;
          if ((TextUtils.isEmpty(localVideoInfo.jdField_j_of_type_JavaLangString)) || (localVideoInfo.jdField_j_of_type_JavaLangString.equals("16888"))) {
            break;
          }
          b(localVideoInfo.jdField_j_of_type_JavaLangString);
          break;
        }
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.b();
        return;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.b();
        return;
        if (localVideoInfo.e())
        {
          if (localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_a_of_type_Boolean) {
            break;
          }
          f(localVideoInfo);
          qoi.a(this.jdField_a_of_type_AndroidAppActivity, localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_c_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo);
          localObject1 = new qzb(localVideoInfo).h(localVideoInfo.jdField_g_of_type_JavaLangString).u(localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_a_of_type_Int);
          if (localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_c_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo != null) {}
          for (paramView = localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_c_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.e;; paramView = "")
          {
            nol.b(null, "", "0X800A18C", "0X800A18C", 0, 0, "", "", "", ((qzb)localObject1).o(paramView).S(2).O(0).a().a(), false);
            return;
          }
        }
        if (localVideoInfo.jdField_k_of_type_Boolean) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "followPubAccount onClick() puin=" + localVideoInfo.jdField_j_of_type_JavaLangString + ", isFollowed=" + localVideoInfo.jdField_k_of_type_Boolean + ", pname=" + localVideoInfo.jdField_k_of_type_JavaLangString);
        }
        localObject1 = new qzb(null, localVideoInfo.jdField_j_of_type_JavaLangString, localVideoInfo.jdField_a_of_type_JavaLangString, localVideoInfo.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(), localVideoInfo.a() * 1000L).a(localVideoInfo.N).O(0).a().a();
        if (this.jdField_a_of_type_Boolean)
        {
          localObject2 = localVideoInfo.jdField_j_of_type_JavaLangString;
          if (!TextUtils.isEmpty(localVideoInfo.jdField_g_of_type_JavaLangString)) {}
          for (paramView = localVideoInfo.jdField_g_of_type_JavaLangString;; paramView = "0")
          {
            nol.a(null, (String)localObject2, "0X800929B", "0X800929B", 0, 0, "", "", paramView, (String)localObject1, false);
            a(localVideoInfo.jdField_j_of_type_JavaLangString, localVideoInfo.jdField_b_of_type_Boolean);
            return;
          }
        }
        localObject2 = localVideoInfo.jdField_j_of_type_JavaLangString;
        if (!TextUtils.isEmpty(localVideoInfo.jdField_g_of_type_JavaLangString)) {}
        for (paramView = localVideoInfo.jdField_g_of_type_JavaLangString;; paramView = "0")
        {
          nol.a(null, (String)localObject2, "0X80078FD", "0X80078FD", 0, 0, "", "", paramView, (String)localObject1, false);
          break;
        }
        if ((!localVideoInfo.jdField_c_of_type_Boolean) || (!(this.jdField_a_of_type_Qmf instanceof qma))) {
          break;
        }
        a(paramView, (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(), localVideoInfo);
        return;
        if (!localVideoInfo.jdField_c_of_type_Boolean) {
          break;
        }
        shq.b(this.jdField_a_of_type_AndroidAppActivity, (AdvertisementInfo)localObject1, null, 3, true, null);
        a(localVideoInfo, 0);
        return;
        if (!localVideoInfo.jdField_c_of_type_Boolean) {
          break;
        }
        oar.a((AdvertisementInfo)localObject1, 1000, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
        shq.b(this.jdField_a_of_type_AndroidAppActivity, (AdvertisementInfo)localObject1, null, 3, false, null);
        a(localVideoInfo, nmc.ay);
        return;
        if (!localVideoInfo.jdField_c_of_type_Boolean) {
          break;
        }
        oar.a((AdvertisementInfo)localObject1, 2, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
        shq.b(this.jdField_a_of_type_AndroidAppActivity, (AdvertisementInfo)localObject1, null, 3, false, null);
        a(localVideoInfo, nmc.aq);
        return;
        if (!localVideoInfo.jdField_c_of_type_Boolean) {
          break;
        }
        oar.a((AdvertisementInfo)localObject1, 3, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
        shq.b(this.jdField_a_of_type_AndroidAppActivity, (AdvertisementInfo)localObject1, null, 3, false, null);
        a(localVideoInfo, nmc.ar);
        return;
        if (!localVideoInfo.jdField_c_of_type_Boolean) {
          break;
        }
        if (this.n)
        {
          this.n = false;
          oar.a((AdvertisementInfo)localObject1, 1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
          shq.b(this.jdField_a_of_type_AndroidAppActivity, (AdvertisementInfo)localObject1, null, 3, false, null);
          a(localVideoInfo, nmc.ap);
          return;
        }
        oar.a((AdvertisementInfo)localObject1, 4, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
        shq.b(this.jdField_a_of_type_AndroidAppActivity, (AdvertisementInfo)localObject1, null, 3, false, null);
        a(localVideoInfo, nmc.as);
        return;
        if (!(localObject3 instanceof qma)) {
          break;
        }
        if (a(localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo))
        {
          a(localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
          nmc.a(new nyd().a(this.jdField_a_of_type_AndroidContentContext).a(nmc.J).b(nmc.N).a((AdvertisementInfo)localObject1).a());
          return;
        }
        localObject2 = (qma)localObject3;
        int i1 = 8;
        if (this.i) {
          i1 = 13;
        }
        oar.a((AdvertisementInfo)localObject1, i1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
        c((qma)localObject2);
        paramView = new View[1];
        paramView[0] = ((qma)localObject2).jdField_c_of_type_AndroidViewView;
        if (c(localVideoInfo)) {
          paramView = new View[0];
        }
        a((qma)localObject2, localVideoInfo, (AdvertisementInfo)localObject1, -1, paramView, new View[] { ((qma)localObject2).jdField_d_of_type_AndroidWidgetTextView, ((qma)localObject2).jdField_a_of_type_AndroidViewView, ((qma)localObject2).jdField_b_of_type_AndroidWidgetSeekBar });
        return;
        if (!(localObject3 instanceof qma)) {
          break;
        }
        if (a(localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo))
        {
          a(localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
          nmc.a(new nyd().a(this.jdField_a_of_type_AndroidContentContext).a(nmc.J).b(nmc.N).a((AdvertisementInfo)localObject1).a());
        }
        while ((this.jdField_a_of_type_Qmf != null) && (this.jdField_a_of_type_Qmf.jdField_a_of_type_Qql != null))
        {
          oar.a(this.jdField_a_of_type_Qmf.jdField_a_of_type_Qql, true);
          return;
          localObject2 = (qma)localObject3;
          paramView = new View[2];
          paramView[0] = ((qma)localObject2).r;
          paramView[1] = ((qma)localObject2).jdField_c_of_type_AndroidViewView;
          if (c(localVideoInfo))
          {
            paramView = new View[1];
            paramView[0] = ((qma)localObject2).r;
          }
          localObject3 = ((qma)localObject2).jdField_d_of_type_AndroidWidgetTextView;
          localObject4 = ((qma)localObject2).jdField_a_of_type_AndroidViewView;
          TextView localTextView = ((qma)localObject2).jdField_m_of_type_AndroidWidgetTextView;
          SeekBar localSeekBar = ((qma)localObject2).jdField_b_of_type_AndroidWidgetSeekBar;
          a((qma)localObject2, localVideoInfo, (AdvertisementInfo)localObject1, nmc.Y, paramView, new View[] { localObject3, localObject4, localTextView, localSeekBar });
        }
        if (!(localObject3 instanceof qma)) {
          break;
        }
        paramView = (qma)localObject3;
        a((qmd)localObject3, localVideoInfo, (AdvertisementInfo)localObject1, -1, paramView.jdField_c_of_type_AndroidViewView, new View[] { paramView.jdField_d_of_type_AndroidWidgetTextView, paramView.jdField_a_of_type_AndroidViewView, paramView.jdField_b_of_type_AndroidWidgetSeekBar });
        return;
        if (!(localObject3 instanceof qma)) {
          break;
        }
        paramView = (qma)localObject3;
        a((qmd)localObject3, localVideoInfo, (AdvertisementInfo)localObject1, nmc.Y, paramView.r, new View[] { paramView.jdField_m_of_type_AndroidWidgetTextView, paramView.jdField_b_of_type_AndroidWidgetSeekBar });
        return;
        a(paramView);
        return;
        this.jdField_a_of_type_Qmu.g();
        if (this.jdField_a_of_type_Boolean)
        {
          paramView = "0X800948A";
          localObject1 = (qmp)localObject3;
          if (((qmp)localObject1).jdField_a_of_type_Qql == null) {
            break label2810;
          }
          localObject1 = ((qmp)localObject1).jdField_a_of_type_Qql.jdField_a_of_type_Qty;
          localObject2 = new qzb(null, localVideoInfo.jdField_j_of_type_JavaLangString, localVideoInfo.jdField_a_of_type_JavaLangString, localVideoInfo.jdField_g_of_type_JavaLangString);
          if (localObject1 == null) {
            break label2822;
          }
          if (((qty)localObject1).e() != 7) {
            break label2816;
          }
          bool = true;
          label2641:
          l1 = ((qty)localObject1).a(bool);
          label2650:
          localObject2 = ((qzb)localObject2).d(l1);
          if (localObject1 == null) {
            break label2830;
          }
          l1 = ((qty)localObject1).a();
          label2671:
          localObject2 = ((qzb)localObject2).a(l1);
          if (localObject1 == null) {
            break label2838;
          }
          l1 = ((qty)localObject1).b();
          localObject2 = ((qzb)localObject2).c(l1).a(409409).a(localVideoInfo.N).w(this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("VIDEO_FROM_TYPE", -1)).a().a();
          localObject3 = localVideoInfo.jdField_j_of_type_JavaLangString;
          if (TextUtils.isEmpty(localVideoInfo.jdField_g_of_type_JavaLangString)) {
            break label2846;
          }
        }
        for (localObject1 = localVideoInfo.jdField_g_of_type_JavaLangString;; localObject1 = "0")
        {
          nol.a(null, (String)localObject3, paramView, paramView, 0, 0, "", "", (String)localObject1, (String)localObject2, false);
          if (this.jdField_a_of_type_Qrf == null) {
            break;
          }
          this.jdField_a_of_type_Qrf.a(4, localVideoInfo, 0L);
          return;
          paramView = "0X8009485";
          break label2573;
          label2810:
          localObject1 = null;
          break label2598;
          bool = false;
          break label2641;
          l1 = -1L;
          break label2650;
          l1 = -1L;
          break label2671;
          l1 = -1L;
          break label2692;
        }
        this.jdField_a_of_type_Qmu.e();
        for (;;)
        {
          try
          {
            if (localVideoInfo.N == null) {
              continue;
            }
            paramView = localVideoInfo.N;
            ((JSONObject)localObject4).put("video_report_info", paramView);
            ((JSONObject)localObject4).put("video_type", 0);
          }
          catch (JSONException paramView)
          {
            paramView.printStackTrace();
            continue;
            nol.a(null, "", "0X8008E54", "0X8008E54", 0, 0, "", "", "", npu.a("", "", localVideoInfo.jdField_a_of_type_JavaLangString, localVideoInfo.jdField_g_of_type_JavaLangString, (JSONObject)localObject4), false);
            return;
          }
          if (!this.jdField_a_of_type_Boolean) {
            continue;
          }
          nol.a(null, "", "0X80092A1", "0X80092A1", 0, 0, "", "", "", npu.a("", "", localVideoInfo.jdField_a_of_type_JavaLangString, localVideoInfo.jdField_g_of_type_JavaLangString, (JSONObject)localObject4), false);
          return;
          paramView = "";
        }
        if (!localVideoInfo.jdField_l_of_type_Boolean)
        {
          bool = true;
          localVideoInfo.jdField_l_of_type_Boolean = bool;
          if (!localVideoInfo.jdField_l_of_type_Boolean) {
            break label3222;
          }
          i1 = localVideoInfo.jdField_u_of_type_Int + 1;
        }
        for (;;)
        {
          localVideoInfo.jdField_u_of_type_Int = i1;
          if ((localObject3 instanceof qmp)) {
            ((qmp)localObject3).jdField_a_of_type_Qjo.d();
          }
          if ((this.jdField_a_of_type_Qpv != null) && (localVideoInfo.jdField_l_of_type_Boolean)) {
            this.jdField_a_of_type_Qpv.a((float)(bbdh.i() / 2L), (float)(bbdh.j() / 2L));
          }
          if (this.jdField_a_of_type_Qrf != null) {
            this.jdField_a_of_type_Qrf.a(3, localVideoInfo, 0L);
          }
          if (this.jdField_a_of_type_Qmc != null) {
            this.jdField_a_of_type_Qmc.a(localVideoInfo, localVideoInfo.jdField_l_of_type_Boolean);
          }
          if ((this.jdField_a_of_type_Qpo != null) && ((localObject3 instanceof qmo)))
          {
            int i2 = 0;
            i1 = i2;
            if (this.jdField_a_of_type_Qsq != null)
            {
              i1 = i2;
              if (this.jdField_a_of_type_Qsq.a()) {
                i1 = 1;
              }
            }
            if (i1 == 0) {
              this.jdField_a_of_type_Qpo.a(localVideoInfo, (qmo)localObject3);
            }
          }
          e(localVideoInfo);
          return;
          bool = false;
          break;
          if (localVideoInfo.jdField_u_of_type_Int > 0) {
            i1 = localVideoInfo.jdField_u_of_type_Int - 1;
          } else {
            i1 = 0;
          }
        }
        this.jdField_a_of_type_Qjf.e();
        a(false, (qmp)localObject3);
        a((qmp)localObject3);
        a(localVideoInfo, nmc.ax);
        return;
        oar.a((AdvertisementInfo)localObject1, 15, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
        this.jdField_a_of_type_Qjf.f();
        shq.b(this.jdField_a_of_type_AndroidAppActivity, (AdvertisementInfo)localObject1, null, 3, true, null);
        a(localVideoInfo, nmc.au);
        return;
        oar.a((AdvertisementInfo)localObject1, 16, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
        this.jdField_a_of_type_Qjf.f();
        shq.b(this.jdField_a_of_type_AndroidAppActivity, (AdvertisementInfo)localObject1, null, 3, true, null);
        a(localVideoInfo, nmc.av);
        return;
        oar.a((AdvertisementInfo)localObject1, 17, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
        if (a(localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo))
        {
          a(localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
          nmc.a(new nyd().a(this.jdField_a_of_type_AndroidContentContext).a(nmc.J).b(nmc.N).a((AdvertisementInfo)localObject1).a());
          return;
        }
        this.jdField_a_of_type_Qjf.f();
        if (localObject1 != null) {
          shq.b(this.jdField_a_of_type_AndroidAppActivity, (AdvertisementInfo)localObject1, null, 3, true, null);
        }
        a(localVideoInfo, nmc.aw);
        return;
        oar.a((AdvertisementInfo)localObject1, 4001, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
        a(localVideoInfo, (AdvertisementInfo)localObject1, 4001);
        return;
        oar.a((AdvertisementInfo)localObject1, 4002, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
        a(localVideoInfo, (AdvertisementInfo)localObject1, 4002);
        return;
        oar.a((AdvertisementInfo)localObject1, 4007, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
        a(localVideoInfo, (AdvertisementInfo)localObject1, 4007);
        return;
        oar.a((AdvertisementInfo)localObject1, 4000, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
        a(localVideoInfo, (AdvertisementInfo)localObject1, 4000);
        return;
        this.jdField_a_of_type_AndroidOsHandler.sendMessage(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(9, Boolean.valueOf(false)));
        this.j = true;
        if (!(this.jdField_a_of_type_Qmf instanceof qma)) {
          break;
        }
        c((qma)this.jdField_a_of_type_Qmf);
        return;
        oar.a((AdvertisementInfo)localObject1, 34, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
        a(localVideoInfo, (AdvertisementInfo)localObject1, nmc.aI);
        return;
        oar.a((AdvertisementInfo)localObject1, 35, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
        a(localVideoInfo, (AdvertisementInfo)localObject1, nmc.aH);
        return;
        oar.a((AdvertisementInfo)localObject1, 37, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
        a(localVideoInfo, (AdvertisementInfo)localObject1, nmc.aJ);
        return;
        oar.a((AdvertisementInfo)localObject1, 2003, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
        a(localVideoInfo, (AdvertisementInfo)localObject1, 2003);
        return;
        oar.a((AdvertisementInfo)localObject1, 2004, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
        a(localVideoInfo, (AdvertisementInfo)localObject1, 2004);
        return;
        oar.a((AdvertisementInfo)localObject1, 18, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
        a(localVideoInfo, (AdvertisementInfo)localObject1, nmc.aK);
        return;
        localVideoInfo = null;
      }
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    qmd localqmd = (qmd)paramView.getTag();
    VideoInfo localVideoInfo = null;
    if ((localqmd instanceof qmp))
    {
      localVideoInfo = ((qmp)localqmd).jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
      if ((this.jdField_a_of_type_Qmf != null) && (this.jdField_a_of_type_Qmf.jdField_a_of_type_Qql != null) && (localVideoInfo == this.jdField_a_of_type_Qmf.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo)) {}
    }
    while (localVideoInfo == null) {
      return false;
    }
    switch (paramView.getId())
    {
    default: 
      return false;
    }
    if (rlz.a().b()) {
      return true;
    }
    if (odo.b() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      a(localVideoInfo, true, bool);
      if (this.jdField_a_of_type_Qrf == null) {
        break;
      }
      this.jdField_a_of_type_Qrf.a(2, localVideoInfo, 0L);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qlp
 * JD-Core Version:    0.7.0.1
 */