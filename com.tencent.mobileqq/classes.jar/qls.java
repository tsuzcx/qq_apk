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

public class qls
  extends RecyclerView.Adapter<qmg>
  implements View.OnClickListener, View.OnLongClickListener, qod, qrk, qxb, qxc
{
  private int jdField_a_of_type_Int;
  public long a;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Context jdField_a_of_type_AndroidContentContext;
  private ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private Handler jdField_a_of_type_AndroidOsHandler = new qlu(this, Looper.getMainLooper());
  private LinearLayoutManager jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager;
  private RecyclerView.RecycledViewPool jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$RecycledViewPool = new RecyclerView.RecycledViewPool();
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private bfsr jdField_a_of_type_Bfsr;
  private bfuc jdField_a_of_type_Bfuc;
  private VideoInfo jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
  private ADVideoAppDownloadManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager;
  private VideoFeedsPlayManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager;
  private VideoFeedsRecyclerView jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView;
  private VideoPreDownloadMgr jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr;
  public GdtHandler.Params a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private INetInfoHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new qlt(this);
  private String jdField_a_of_type_JavaLangString;
  public HashMap<String, Integer> a;
  private List<VideoInfo> jdField_a_of_type_JavaUtilList;
  private Map<Integer, Bitmap> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  private nzy jdField_a_of_type_Nzy;
  private qji jdField_a_of_type_Qji;
  private qks jdField_a_of_type_Qks;
  private qku jdField_a_of_type_Qku;
  private qky jdField_a_of_type_Qky;
  private qmf jdField_a_of_type_Qmf;
  private qmi jdField_a_of_type_Qmi;
  qml jdField_a_of_type_Qml;
  private qms jdField_a_of_type_Qms;
  private qmx jdField_a_of_type_Qmx;
  private qny jdField_a_of_type_Qny;
  private qpr jdField_a_of_type_Qpr;
  private qpy jdField_a_of_type_Qpy;
  private qri jdField_a_of_type_Qri;
  private qrm jdField_a_of_type_Qrm;
  public qrq a;
  private qst jdField_a_of_type_Qst;
  private qsx jdField_a_of_type_Qsx;
  private qth jdField_a_of_type_Qth;
  private qze jdField_a_of_type_Qze;
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
  
  public qls(Context paramContext, Activity paramActivity, VideoFeedsRecyclerView paramVideoFeedsRecyclerView, LinearLayoutManager paramLinearLayoutManager, QQAppInterface paramQQAppInterface, String paramString1, String paramString2, boolean paramBoolean, int paramInt, qrm paramqrm)
  {
    this.jdField_a_of_type_Long = -2147483648L;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_Qrq = new qlv(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView = paramVideoFeedsRecyclerView;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.a(this.jdField_a_of_type_Qrq);
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager = paramLinearLayoutManager;
    this.jdField_c_of_type_AndroidGraphicsDrawableDrawable = bbdr.a(true);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130842517);
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130842552);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getMinimumWidth(), this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getMinimumHeight());
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getMinimumWidth(), this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getMinimumHeight());
    this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131165275));
    this.jdField_a_of_type_Qku = qku.a();
    this.jdField_a_of_type_Qky = new qky(paramActivity);
    this.jdField_a_of_type_Qpr = new qpr(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Bfsr = new bfsr(this.jdField_a_of_type_AndroidAppActivity);
    AppNetConnInfo.registerConnectionChangeReceiver(this.jdField_a_of_type_AndroidAppActivity.getApplication(), this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    this.jdField_d_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(1930498322);
    this.jdField_a_of_type_Qrm = paramqrm;
    setHasStableIds(true);
    registerAdapterDataObserver(new qme(this, null));
    this.r = axmt.b();
    this.jdField_a_of_type_Nzy = new nzy(paramActivity, this);
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
      return ajyc.a(2131716245);
    }
    if (paramInt == 2) {
      return ajyc.a(2131716242);
    }
    return null;
  }
  
  private String a(VideoInfo paramVideoInfo, int paramInt)
  {
    return oau.a(this.jdField_a_of_type_AndroidAppActivity, paramVideoInfo, paramInt);
  }
  
  @NonNull
  private String a(VideoInfo paramVideoInfo, Resources paramResources)
  {
    return oau.a(this.jdField_a_of_type_AndroidAppActivity, paramVideoInfo, paramResources);
  }
  
  private void a(RecyclerView paramRecyclerView, List<VideoInfo> paramList, int paramInt)
  {
    int i2 = paramRecyclerView.getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      RecyclerView.ViewHolder localViewHolder = paramRecyclerView.getChildViewHolder(paramRecyclerView.getChildAt(i1));
      if ((localViewHolder instanceof qms))
      {
        VideoInfo localVideoInfo = (VideoInfo)paramList.get(((qms)localViewHolder).jdField_b_of_type_Int);
        if ((localVideoInfo.e()) && (localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_a_of_type_Int == paramInt)) {
          ((qms)localViewHolder).jdField_a_of_type_Qjr.b(localVideoInfo);
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
    if (this.jdField_a_of_type_Nzy != null) {
      this.jdField_a_of_type_Nzy.a(paramView, paramInt, paramVideoInfo);
    }
  }
  
  private void a(VideoAdInfo paramVideoAdInfo)
  {
    paramVideoAdInfo = nmf.a(paramVideoAdInfo);
    if (paramVideoAdInfo != null) {
      sht.a(this.jdField_a_of_type_AndroidAppActivity, paramVideoAdInfo.mPopFormH5Url, paramVideoAdInfo.mAdRl, paramVideoAdInfo.mAdTraceId);
    }
  }
  
  private void a(VideoInfo paramVideoInfo, int paramInt)
  {
    if (paramVideoInfo == null) {
      return;
    }
    AdvertisementInfo localAdvertisementInfo = nmf.a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
    if (paramVideoInfo.a(this.jdField_a_of_type_AndroidAppActivity))
    {
      nmf.a(new nyg().a(this.jdField_a_of_type_AndroidContentContext).a(nmf.jdField_a_of_type_Int).b(nmf.P).a(localAdvertisementInfo).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).d(paramInt).a());
      return;
    }
    nmf.a(new nyg().a(this.jdField_a_of_type_AndroidContentContext).a(nmf.jdField_a_of_type_Int).b(nmf.N).a(localAdvertisementInfo).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).d(paramInt).a());
  }
  
  private void a(VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo, int paramInt)
  {
    if (paramAdvertisementInfo == null) {
      return;
    }
    sht.b(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, true, null);
    paramAdvertisementInfo = nmf.a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
    nmf.a(new nyg().a(this.jdField_a_of_type_AndroidContentContext).a(nmf.jdField_a_of_type_Int).b(nmf.Y).a(paramAdvertisementInfo).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).d(paramInt).a());
  }
  
  private void a(VideoInfo paramVideoInfo, qze paramqze)
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
        noo.b(null, (String)localObject2, "0X8009298", "0X8009298", 0, 0, "0", "", (String)localObject1, paramqze.a().a(), false);
        try
        {
          if ((paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.fusionBiuInfo.jdField_c_of_type_Boolean) && (!paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.fusionBiuInfo.jdField_d_of_type_Boolean))
          {
            rmc.a().a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, 0, 2, 2);
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
      if ((!TextUtils.isEmpty(paramVideoInfo.J)) && (qol.d()))
      {
        i1 = 1;
        label142:
        localObject1 = paramqze.T(i1);
        if (!paramVideoInfo.e()) {
          break label421;
        }
        i1 = 2;
        label158:
        localObject1 = ((qze)localObject1).Z(i1);
        if (!paramVideoInfo.e()) {
          break label426;
        }
        i1 = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_a_of_type_Int;
        label181:
        localObject1 = ((qze)localObject1).u(i1);
        if ((!paramVideoInfo.e()) || (TextUtils.isEmpty(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_g_of_type_JavaLangString)) || (TextUtils.isEmpty(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.f))) {
          break label431;
        }
        i1 = 1;
        label224:
        localObject2 = ((qze)localObject1).aa(i1);
        if ((!paramVideoInfo.e()) || (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo == null)) {
          break label436;
        }
        localObject1 = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.e;
        label261:
        localObject2 = ((qze)localObject2).o((String)localObject1);
        if ((!paramVideoInfo.e()) || (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.d == null)) {
          break label444;
        }
        localObject1 = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.d.e;
        label299:
        localObject1 = ((qze)localObject2).p((String)localObject1);
        if (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo == null) {
          break label452;
        }
        label315:
        localObject2 = ((qze)localObject1).k(bool);
        if ((paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo == null) || (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo == null)) {
          break label458;
        }
        localObject1 = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.e;
        label353:
        ((qze)localObject2).q((String)localObject1);
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
        noo.b(null, (String)localObject2, "0X8007801", "0X8007801", 0, 0, "0", "", (String)localObject1, paramqze.a().a(), false);
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
      localObject1 = new qze((String)localObject1, paramVideoInfo.jdField_j_of_type_JavaLangString, paramVideoInfo.jdField_a_of_type_JavaLangString, paramVideoInfo.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(), paramVideoInfo.a() * 1000);
      localObject2 = ((qze)localObject1).g(paramBoolean1).h(paramBoolean2);
      if (!this.s) {
        break label295;
      }
      i1 = 1;
      label95:
      ((qze)localObject2).c(i1);
      if (!this.jdField_a_of_type_Boolean)
      {
        ((qze)localObject1).e(paramVideoInfo.f).d(paramVideoInfo.jdField_r_of_type_Int).a(-1).a(paramVideoInfo.N).O(0);
        localObject2 = new qcd();
        ((qcd)localObject2).jdField_d_of_type_Int = ((int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a());
        ((qcd)localObject2).jdField_e_of_type_Int = (paramVideoInfo.a() * 1000);
        ((qcd)localObject2).jdField_b_of_type_Int = this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
        npx.b(paramVideoInfo, this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_CHANNEL_ID", -1), 25, -1, (qcd)localObject2, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_g_of_type_JavaLangString);
      }
      localObject1 = ((qze)localObject1).a().a();
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
      noo.a(null, (String)localObject2, "0X8009299", "0X8009299", 0, 0, "0", "0", paramVideoInfo, (String)localObject1, false);
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
      noo.a(null, (String)localObject2, "0X8007B89", "0X8007B89", 0, 0, "0", "0", paramVideoInfo, (String)localObject1, false);
      return;
    }
  }
  
  private void a(KandianUrlImageView paramKandianUrlImageView, VideoInfo paramVideoInfo)
  {
    if ((paramKandianUrlImageView == null) || (paramVideoInfo == null)) {
      return;
    }
    if ((!qol.d()) || (TextUtils.isEmpty(paramVideoInfo.J)))
    {
      paramKandianUrlImageView.setVisibility(8);
      return;
    }
    Object localObject;
    if (paramVideoInfo.J.endsWith("zip"))
    {
      localObject = oqe.a(paramVideoInfo.J);
      ((oqe)localObject).setRepeatCount(0);
      paramKandianUrlImageView.setImageDrawable((Drawable)localObject);
      if ((paramKandianUrlImageView.getVisibility() == 8) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.d()) && (this.jdField_a_of_type_Qmi.jdField_a_of_type_Qqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == paramVideoInfo)) {
        ((oqe)localObject).playAnimation();
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
      localLayoutParams.width = actn.a(91.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    }
    for (localLayoutParams.height = actn.a(28.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());; localLayoutParams.height = actn.a(24.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()))
    {
      paramKandianUrlImageView.setLayoutParams(localLayoutParams);
      return;
      localLayoutParams.width = actn.a(78.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
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
      qol.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramBoolean);
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
  
  private void a(qmd paramqmd)
  {
    int i1;
    Object localObject;
    if ((paramqmd != null) && (paramqmd.jdField_a_of_type_Qqo != null) && (paramqmd.jdField_a_of_type_Qqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (paramqmd.jdField_a_of_type_Qqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo != null))
    {
      i1 = oat.c(nmf.a(paramqmd.jdField_a_of_type_Qqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo));
      if (i1 != 1) {
        break label84;
      }
      paramqmd = paramqmd.jdField_d_of_type_AndroidViewView;
      localObject = (LinearLayout.LayoutParams)paramqmd.getLayoutParams();
      if (localObject != null)
      {
        ((LinearLayout.LayoutParams)localObject).weight = 2.0F;
        paramqmd.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
    label84:
    do
    {
      do
      {
        return;
      } while (i1 != 2);
      localObject = paramqmd.jdField_e_of_type_AndroidViewView;
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((View)localObject).getLayoutParams();
      if (localLayoutParams != null)
      {
        localLayoutParams.weight = 0.0F;
        ((View)localObject).setLayoutParams(localLayoutParams);
      }
      paramqmd = paramqmd.jdField_f_of_type_AndroidViewView;
      localObject = (LinearLayout.LayoutParams)paramqmd.getLayoutParams();
    } while (localObject == null);
    ((LinearLayout.LayoutParams)localObject).weight = 0.0F;
    paramqmd.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  private void a(qmd paramqmd, VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo, int paramInt, View[] paramArrayOfView1, View[] paramArrayOfView2)
  {
    int i1 = 8;
    int i2 = 0;
    if (paramVideoInfo.jdField_c_of_type_Boolean)
    {
      if ((!AdvertisementInfo.isAppAdvertisementInfo(paramAdvertisementInfo)) || (!oat.d(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo))) {
        break label318;
      }
      if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager.a(paramVideoInfo)) {
        break label130;
      }
      sht.b(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, true, null);
      if (paramInt == nmf.Y)
      {
        paramqmd = nmf.a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
        nmf.a(new nyg().a(this.jdField_a_of_type_AndroidContentContext).a(nmf.jdField_a_of_type_Int).b(nmf.Y).a(paramqmd).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).d(nmf.aL).a());
      }
    }
    else
    {
      return;
    }
    a(paramVideoInfo, nmf.at);
    return;
    label130:
    oau.a(paramAdvertisementInfo, 0, null);
    int i3 = paramArrayOfView1.length;
    i1 = 0;
    while (i1 < i3)
    {
      paramArrayOfView1[i1].setVisibility(0);
      i1 += 1;
    }
    paramqmd.jdField_a_of_type_Boolean = true;
    i3 = paramArrayOfView2.length;
    i1 = i2;
    while (i1 < i3)
    {
      paramArrayOfView2[i1].setVisibility(8);
      i1 += 1;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager.f();
    if (paramInt == nmf.Y)
    {
      nmf.a(new nyg().a(this.jdField_a_of_type_AndroidContentContext).a(nmf.jdField_a_of_type_Int).b(nmf.ak).a(paramAdvertisementInfo).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).d(nmf.aL).a());
      return;
    }
    nmf.a(new nyg().a(this.jdField_a_of_type_AndroidContentContext).a(nmf.jdField_a_of_type_Int).b(nmf.ak).a(paramAdvertisementInfo).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).a());
    return;
    label318:
    if (paramInt == nmf.Y)
    {
      paramInt = 38;
      paramqmd = nmf.a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
      nmf.a(new nyg().a(this.jdField_a_of_type_AndroidContentContext).a(nmf.jdField_a_of_type_Int).b(nmf.Y).a(paramqmd).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).d(nmf.aL).a());
    }
    for (;;)
    {
      if (paramAdvertisementInfo != null) {
        paramAdvertisementInfo.setClickPos(paramInt);
      }
      paramqmd = new nyc();
      paramqmd.jdField_c_of_type_Boolean = true;
      sht.b(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, true, paramqmd);
      return;
      paramInt = i1;
      if (this.i) {
        paramInt = 13;
      }
      a(paramVideoInfo, nmf.at);
    }
  }
  
  private void a(qmd paramqmd, boolean paramBoolean1, boolean paramBoolean2, View paramView1, View paramView2, TextView paramTextView1, Drawable paramDrawable1, Drawable paramDrawable2, View paramView3, TextView paramTextView2)
  {
    if (paramView1 != null) {
      paramView1.setVisibility(8);
    }
    if (paramBoolean2)
    {
      paramView2.setVisibility(0);
      paramView2.getParent().requestDisallowInterceptTouchEvent(true);
      paramView2.setOnClickListener(this);
      paramView2.setTag(paramqmd);
      Object localObject = null;
      paramView1 = localObject;
      if (paramTextView1 != null)
      {
        paramView1 = localObject;
        if (paramqmd.jdField_a_of_type_Qqo != null)
        {
          paramView1 = a(paramqmd.jdField_a_of_type_Qqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo, this.jdField_a_of_type_AndroidContentContext.getResources());
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
      if ((oat.a()) && (paramDrawable2 != null)) {
        paramView2.setBackgroundDrawable(paramDrawable2);
      }
    }
  }
  
  private void a(qmg paramqmg, VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo, int paramInt, View paramView, View... paramVarArgs)
  {
    int i1 = 0;
    if ((paramVideoInfo.jdField_c_of_type_Boolean) && (AdvertisementInfo.isAppAdvertisementInfo(paramAdvertisementInfo)) && (oat.d(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo)))
    {
      if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager.a(paramVideoInfo)) {
        break label118;
      }
      sht.b(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, true, null);
      if (paramInt == nmf.Y) {
        nmf.a(new nyg().a(this.jdField_a_of_type_AndroidContentContext).a(nmf.jdField_a_of_type_Int).b(nmf.Y).a(paramAdvertisementInfo).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).d(nmf.aL).a());
      }
    }
    else
    {
      return;
    }
    a(paramVideoInfo, nmf.at);
    return;
    label118:
    paramView.setVisibility(0);
    ((qmd)paramqmg).jdField_a_of_type_Boolean = true;
    paramInt = i1;
    while (paramInt < paramVarArgs.length)
    {
      paramVarArgs[paramInt].setVisibility(8);
      paramInt += 1;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager.f();
  }
  
  private void a(qmi paramqmi)
  {
    if ((this.jdField_a_of_type_Qmi != null) && (this.jdField_a_of_type_Qmi.jdField_a_of_type_Qqo != null) && (this.jdField_a_of_type_Qmi.jdField_a_of_type_Qqo.jdField_a_of_type_Qub != null))
    {
      int i1 = this.jdField_a_of_type_Qmi.jdField_a_of_type_Qqo.jdField_a_of_type_Qub.e();
      if ((i1 != 0) && (i1 != 1) && (i1 != 2) && (this.jdField_a_of_type_Qmi.jdField_c_of_type_Int == paramqmi.jdField_c_of_type_Int - 1) && (bbev.h(this.jdField_a_of_type_AndroidAppActivity)) && (bhvh.t(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.b(paramqmi.jdField_a_of_type_Qqo);
      }
    }
  }
  
  private void a(qmi paramqmi, VideoInfo paramVideoInfo)
  {
    qqo localqqo2 = paramqmi.jdField_a_of_type_Qqo;
    qqo localqqo1 = localqqo2;
    if (localqqo2 == null)
    {
      localqqo1 = new qqo();
      localqqo1.jdField_a_of_type_Qjv = paramqmi.jdField_a_of_type_Qtk;
      localqqo1.jdField_a_of_type_AndroidOsBundle.putInt("jump_from_scene", this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("PERFORMANCE_REPORT_VIDEO_FEEDS_JUMP_FROM", 0));
    }
    localqqo1.jdField_a_of_type_ComTencentBizPubaccountVideoInfo = paramVideoInfo;
    localqqo1.jdField_a_of_type_Int = paramVideoInfo.c(this.jdField_a_of_type_AndroidAppActivity);
    localqqo1.jdField_a_of_type_AndroidViewViewGroup = paramqmi.jdField_b_of_type_AndroidViewViewGroup;
    localqqo1.jdField_b_of_type_Int = paramqmi.jdField_c_of_type_Int;
    localqqo1.jdField_a_of_type_Boolean = false;
    localqqo1.jdField_a_of_type_AndroidOsBundle.putInt("video_feeds_index", paramqmi.jdField_c_of_type_Int);
    localqqo1.jdField_a_of_type_Long = 0L;
    localqqo1.jdField_b_of_type_Boolean = true;
    if (paramVideoInfo.jdField_c_of_type_Boolean)
    {
      if (!paramVideoInfo.a(this.jdField_a_of_type_AndroidAppActivity)) {
        break label170;
      }
      localqqo1.jdField_a_of_type_AndroidOsBundle.putInt("ad_origin", nmf.P);
    }
    for (;;)
    {
      paramqmi.jdField_a_of_type_Qtk.jdField_a_of_type_Boolean = true;
      paramqmi.jdField_a_of_type_Qqo = localqqo1;
      paramqmi.jdField_a_of_type_Qyy.a(this, paramqmi);
      return;
      label170:
      localqqo1.jdField_a_of_type_AndroidOsBundle.putInt("ad_origin", nmf.N);
    }
  }
  
  private void a(qmi paramqmi1, qmi paramqmi2)
  {
    VideoInfo localVideoInfo;
    qze localqze1;
    if ((paramqmi2 != null) && (paramqmi2.jdField_c_of_type_Int == paramqmi1.jdField_c_of_type_Int))
    {
      localVideoInfo = paramqmi1.jdField_a_of_type_Qqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
      localqze1 = new qze(paramqmi1.jdField_a_of_type_Qqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
      localqze1.h(localVideoInfo.jdField_g_of_type_JavaLangString).l(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).n(paramqmi1.jdField_b_of_type_Int).m(paramqmi1.jdField_c_of_type_Int);
      if (paramqmi1.jdField_b_of_type_Int != paramqmi2.jdField_b_of_type_Int + 1) {
        break label124;
      }
      noo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localVideoInfo.jdField_j_of_type_JavaLangString, "0X8009952", "0X8009952", 0, 0, "", "", "", localqze1.a().a(), false);
    }
    label124:
    while (paramqmi1.jdField_b_of_type_Int != paramqmi2.jdField_b_of_type_Int - 1) {
      return;
    }
    qze localqze2 = localqze1.p(0);
    if (paramqmi2.jdField_a_of_type_Qqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) {}
    for (paramqmi1 = paramqmi2.jdField_a_of_type_Qqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_g_of_type_JavaLangString;; paramqmi1 = "")
    {
      localqze2.h(paramqmi1);
      noo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localVideoInfo.jdField_j_of_type_JavaLangString, "0X8009953", "0X8009953", 0, 0, "", "", "", localqze1.a().a(), false);
      return;
    }
  }
  
  private void a(qmi paramqmi1, qmi paramqmi2, boolean paramBoolean)
  {
    Activity localActivity = this.jdField_a_of_type_AndroidAppActivity;
    VideoInfo localVideoInfo = paramqmi1.jdField_a_of_type_Qqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
    int i1 = paramqmi1.jdField_b_of_type_Int;
    int i2 = paramqmi1.jdField_c_of_type_Int;
    int i3 = paramqmi1.jdField_a_of_type_Int;
    ThreadManager.post(new VideoFeedsAdapter.4(this, localVideoInfo, localActivity, i2, paramqmi1.jdField_b_of_type_Boolean, i1, paramBoolean, i3, paramqmi1, paramqmi2), 1, null, true);
  }
  
  private void a(qml paramqml)
  {
    if (this.jdField_b_of_type_Int == 1)
    {
      paramqml.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      paramqml.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      paramqml.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramqml.jdField_a_of_type_AndroidWidgetTextView.setText(a(1));
    }
    do
    {
      return;
      if (this.jdField_b_of_type_Int == 2)
      {
        paramqml.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
        paramqml.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        paramqml.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        paramqml.jdField_a_of_type_AndroidWidgetTextView.setText(a(2));
        return;
      }
    } while (this.jdField_b_of_type_Int != 3);
    if (paramqml.jdField_a_of_type_Int == 6)
    {
      paramqml.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      paramqml.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      paramqml.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramqml.jdField_a_of_type_AndroidWidgetTextView.setText(a(1));
      return;
    }
    paramqml.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
    paramqml.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    paramqml.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  private void a(qms paramqms, VideoInfo paramVideoInfo)
  {
    if (paramqms.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView != null) {
      paramqms.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView.a();
    }
    if (paramqms.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView != null) {
      paramqms.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView.a();
    }
    if (paramqms.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView != null) {
      paramqms.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView.a();
    }
    if ((paramVideoInfo.jdField_g_of_type_Int == 1) || (paramVideoInfo.jdField_g_of_type_Int == 2))
    {
      if (paramVideoInfo.jdField_g_of_type_Int != 1) {
        break label486;
      }
      if (bbfd.a(BaseApplicationImpl.getContext(), paramVideoInfo.B)) {
        break label419;
      }
      if ((paramqms.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView != null) && (!TextUtils.isEmpty(paramVideoInfo.m)) && (!TextUtils.isEmpty(paramVideoInfo.n))) {
        paramqms.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView.setImageUrl(paramVideoInfo, paramVideoInfo.q, this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0), this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("key_source", 0), this.jdField_a_of_type_Boolean, this, paramVideoInfo.h, paramVideoInfo.jdField_g_of_type_Int, paramVideoInfo.m, paramVideoInfo.n, 28, paramVideoInfo.p, "VideoPlay_ContentMix", paramVideoInfo.jdField_c_of_type_JavaLangString, paramVideoInfo.C, paramVideoInfo.i, paramVideoInfo.jdField_j_of_type_Int);
      }
      if ((paramqms.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView != null) && (!TextUtils.isEmpty(paramVideoInfo.jdField_r_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramVideoInfo.s))) {
        paramqms.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView.setImageUrl(paramVideoInfo, paramVideoInfo.v, this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0), this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("key_source", 0), this.jdField_a_of_type_Boolean, this, paramVideoInfo.h, paramVideoInfo.jdField_g_of_type_Int, paramVideoInfo.jdField_r_of_type_JavaLangString, paramVideoInfo.s, 29, paramVideoInfo.jdField_u_of_type_JavaLangString, "VideoPlay_RedEnvelope", paramVideoInfo.jdField_c_of_type_JavaLangString, paramVideoInfo.C, paramVideoInfo.i, paramVideoInfo.jdField_j_of_type_Int);
      }
      if ((paramqms.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView != null) && (!TextUtils.isEmpty(paramVideoInfo.w)) && (!TextUtils.isEmpty(paramVideoInfo.x))) {
        paramqms.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView.setImageUrl(paramVideoInfo, paramVideoInfo.A, this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0), this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("key_source", 0), this.jdField_a_of_type_Boolean, this, paramVideoInfo.h, paramVideoInfo.jdField_g_of_type_Int, paramVideoInfo.w, paramVideoInfo.x, 30, paramVideoInfo.z, "VideoPlay_Shooting", paramVideoInfo.jdField_c_of_type_JavaLangString, paramVideoInfo.C, paramVideoInfo.i, paramVideoInfo.jdField_j_of_type_Int);
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
      if (!bbfd.a(BaseApplicationImpl.getContext(), paramVideoInfo.B)) {
        break;
      }
      if ((paramqms.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView != null) && (!TextUtils.isEmpty(paramVideoInfo.m)) && (!TextUtils.isEmpty(paramVideoInfo.o))) {
        paramqms.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView.setImageUrl(paramVideoInfo, paramVideoInfo.q, this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0), this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("key_source", 0), this.jdField_a_of_type_Boolean, this, paramVideoInfo.h, paramVideoInfo.jdField_g_of_type_Int, paramVideoInfo.m, paramVideoInfo.o, 28, paramVideoInfo.p, "VideoPlay_ContentMix", paramVideoInfo.jdField_c_of_type_JavaLangString, paramVideoInfo.C, paramVideoInfo.i, paramVideoInfo.jdField_j_of_type_Int);
      }
      if ((paramqms.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView != null) && (!TextUtils.isEmpty(paramVideoInfo.jdField_r_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramVideoInfo.t))) {
        paramqms.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView.setImageUrl(paramVideoInfo, paramVideoInfo.v, this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0), this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("key_source", 0), this.jdField_a_of_type_Boolean, this, paramVideoInfo.h, paramVideoInfo.jdField_g_of_type_Int, paramVideoInfo.jdField_r_of_type_JavaLangString, paramVideoInfo.t, 29, paramVideoInfo.jdField_u_of_type_JavaLangString, "VideoPlay_RedEnvelope", paramVideoInfo.jdField_c_of_type_JavaLangString, paramVideoInfo.C, paramVideoInfo.i, paramVideoInfo.jdField_j_of_type_Int);
      }
    } while ((paramqms.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView == null) || (TextUtils.isEmpty(paramVideoInfo.w)) || (TextUtils.isEmpty(paramVideoInfo.y)));
    paramqms.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView.setImageUrl(paramVideoInfo, paramVideoInfo.A, this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0), this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("key_source", 0), this.jdField_a_of_type_Boolean, this, paramVideoInfo.h, paramVideoInfo.jdField_g_of_type_Int, paramVideoInfo.w, paramVideoInfo.y, 30, paramVideoInfo.z, "VideoPlay_Shooting", paramVideoInfo.jdField_c_of_type_JavaLangString, paramVideoInfo.C, paramVideoInfo.i, paramVideoInfo.jdField_j_of_type_Int);
    return;
    if (paramVideoInfo.p.contains("?"))
    {
      VideoFeedsOptView.a(paramVideoInfo.p + "&acttype=109");
      return;
    }
    VideoFeedsOptView.a(paramVideoInfo.p + "?acttype=109");
  }
  
  private void a(qms paramqms, boolean paramBoolean, long paramLong, int paramInt)
  {
    if (paramBoolean)
    {
      if (this.jdField_b_of_type_Long != 0L) {
        ThreadManager.excute(new VideoFeedsAdapter.1(this, paramLong), 16, null, true);
      }
      if ((paramqms.jdField_a_of_type_Qqo != null) && (paramqms.jdField_a_of_type_Qqo.jdField_a_of_type_Qbx != null))
      {
        paramqms.jdField_a_of_type_Qqo.jdField_a_of_type_Qbx.n = paramLong;
        paramqms.jdField_a_of_type_Qqo.jdField_a_of_type_Qbx.jdField_r_of_type_Int = onk.a(paramInt, paramqms.jdField_c_of_type_Int, false);
      }
      if ((paramqms.jdField_a_of_type_Qqo != null) && (paramqms.jdField_a_of_type_Qqo.jdField_a_of_type_Qbw != null)) {
        paramqms.jdField_a_of_type_Qqo.jdField_a_of_type_Qbw.jdField_a_of_type_Boolean = true;
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
        if (!oat.a()) {
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
  
  private void a(boolean paramBoolean, qmd paramqmd)
  {
    if (!a(paramqmd)) {
      return;
    }
    TextView localTextView1 = paramqmd.jdField_d_of_type_AndroidWidgetTextView;
    View localView = paramqmd.jdField_a_of_type_AndroidViewView;
    TextView localTextView2 = paramqmd.jdField_e_of_type_AndroidWidgetTextView;
    if (localView != null) {}
    for (boolean bool = true;; bool = false)
    {
      GradientDrawable localGradientDrawable1 = new GradientDrawable();
      localGradientDrawable1.setColor(Color.parseColor("#FF12B7F6"));
      localGradientDrawable1.setCornerRadius(actn.a(4.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
      GradientDrawable localGradientDrawable2 = new GradientDrawable();
      if (oat.a())
      {
        localGradientDrawable1.setColor(Color.parseColor("#FF12B7F6"));
        localGradientDrawable1.setCornerRadius(actn.a(6.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
        localGradientDrawable2.setColor(Color.parseColor("#1AFFFFFF"));
        localGradientDrawable2.setCornerRadius(actn.a(6.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
      }
      a(paramqmd, paramBoolean, bool, localTextView1, localView, localTextView2, localGradientDrawable1, localGradientDrawable2, paramqmd.jdField_b_of_type_AndroidViewView, paramqmd.jdField_f_of_type_AndroidWidgetTextView);
      return;
    }
  }
  
  private void a(boolean paramBoolean, qms paramqms)
  {
    if (!qmd.class.isInstance(paramqms)) {
      return;
    }
    paramqms = (qmd)paramqms;
    int i1;
    if ((paramqms.jdField_a_of_type_Qqo != null) && (paramqms.jdField_a_of_type_Qqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (oat.c(paramqms.jdField_a_of_type_Qqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo)) && (!paramqms.jdField_a_of_type_Boolean))
    {
      a(paramBoolean, paramqms);
      if (paramqms.jdField_a_of_type_Qqo != null)
      {
        if (!c(paramqms.jdField_a_of_type_Qqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo)) {
          break label338;
        }
        i1 = 8;
        label85:
        if (!c(paramqms.jdField_a_of_type_Qqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo)) {
          break label343;
        }
      }
    }
    label338:
    label343:
    for (int i2 = 0;; i2 = 8)
    {
      paramqms.jdField_d_of_type_AndroidWidgetTextView.setVisibility(i1);
      paramqms.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(i2);
      if (oat.a()) {
        paramqms.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      if (paramqms.jdField_c_of_type_AndroidViewView != null)
      {
        paramqms.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
        paramqms.jdField_c_of_type_AndroidViewView.getParent().requestDisallowInterceptTouchEvent(true);
        paramqms.jdField_c_of_type_AndroidViewView.setTag(paramqms);
      }
      if (paramqms.r != null)
      {
        paramqms.r.setOnClickListener(this);
        paramqms.r.getParent().requestDisallowInterceptTouchEvent(true);
        paramqms.r.setTag(paramqms);
      }
      if ((paramqms.jdField_b_of_type_AndroidWidgetSeekBar != null) && (!paramqms.jdField_a_of_type_Boolean)) {
        paramqms.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(0);
      }
      if ((paramqms.jdField_c_of_type_AndroidViewView != null) && (!paramqms.jdField_a_of_type_Boolean)) {
        paramqms.jdField_c_of_type_AndroidViewView.setVisibility(8);
      }
      if ((paramqms.jdField_c_of_type_AndroidViewView != null) && (c(paramqms.jdField_a_of_type_Qqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo)))
      {
        paramqms.jdField_c_of_type_AndroidViewView.setVisibility(8);
        paramqms.jdField_a_of_type_AndroidViewView.setVisibility(8);
      }
      if ((paramqms.jdField_c_of_type_AndroidViewView != null) && (paramqms.jdField_c_of_type_AndroidViewView.getVisibility() == 0))
      {
        paramqms.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
        paramqms.jdField_a_of_type_AndroidViewView.setVisibility(8);
      }
      a(paramqms);
      return;
      b(paramBoolean, paramqms);
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
      if ((i3 >= 0) && ((paramList instanceof qms)) && (((qms)paramList).jdField_b_of_type_Int == i3))
      {
        ((qms)paramList).jdField_a_of_type_Qjr.b(paramVideoInfo);
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
      if ((localViewHolder instanceof qms))
      {
        VideoInfo localVideoInfo = (VideoInfo)paramList.get(((qms)localViewHolder).jdField_b_of_type_Int);
        if (paramString.equals(localVideoInfo.jdField_j_of_type_JavaLangString)) {
          ((qms)localViewHolder).jdField_a_of_type_Qjr.b(localVideoInfo);
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
      paramVideoAdInfo = nmf.a(paramVideoAdInfo);
    } while ((TextUtils.isEmpty(paramVideoAdInfo.mPopFormH5Url)) || (!oat.d(paramVideoAdInfo)));
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
  
  private boolean a(qmd paramqmd)
  {
    boolean bool3 = true;
    boolean bool1 = true;
    boolean bool2 = bool1;
    if (paramqmd != null)
    {
      bool2 = bool1;
      if (paramqmd.jdField_a_of_type_Qqo != null)
      {
        if (paramqmd.jdField_a_of_type_Qqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) {
          break label34;
        }
        bool2 = bool1;
      }
    }
    label34:
    do
    {
      return bool2;
      Object localObject = paramqmd.jdField_a_of_type_Qqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
      bool1 = bool3;
      if (((VideoInfo)localObject).jdField_c_of_type_Boolean)
      {
        localObject = nmf.a(((VideoInfo)localObject).jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
        bool1 = bool3;
        if (localObject != null)
        {
          bool1 = bool3;
          if (!((AdvertisementInfo)localObject).mShowAdButton)
          {
            if (paramqmd.jdField_d_of_type_AndroidWidgetTextView != null) {
              paramqmd.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
            }
            if (paramqmd.jdField_a_of_type_AndroidViewView != null) {
              paramqmd.jdField_a_of_type_AndroidViewView.setVisibility(8);
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
  
  private boolean a(qms paramqms)
  {
    boolean bool = true;
    paramqms.jdField_a_of_type_Qtk.jdField_a_of_type_Boolean = false;
    Bundle localBundle;
    int i2;
    int i1;
    if ((paramqms.jdField_c_of_type_Int == this.jdField_e_of_type_Int) && (this.jdField_a_of_type_AndroidContentContext != null) && (paramqms.jdField_a_of_type_Qqo != null) && (paramqms.jdField_a_of_type_Qqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null))
    {
      localBundle = this.jdField_a_of_type_AndroidAppActivity.getIntent().getExtras();
      i2 = localBundle.getInt("VIDEO_FROM_TYPE", 0);
      if (!bbev.b(this.jdField_a_of_type_AndroidContentContext))
      {
        i1 = 1;
        if (i2 != 27) {
          break label121;
        }
        paramqms = paramqms.jdField_a_of_type_Qtk;
        if ((i1 != 0) || (this.jdField_f_of_type_Boolean)) {
          break label115;
        }
        label102:
        paramqms.jdField_a_of_type_Boolean = bool;
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
        if ((!bbev.b(this.jdField_a_of_type_AndroidContentContext)) || (this.jdField_f_of_type_Boolean))
        {
          paramqms.jdField_a_of_type_Qtk.jdField_a_of_type_Boolean = false;
          return true;
        }
        i1 = localBundle.getInt("VIDEO_PLAY_STATUS", 0);
        if (((2 == i2) || (6 == i2) || (5 == i2)) && (3 == i1))
        {
          paramqms.jdField_a_of_type_Qtk.jdField_a_of_type_Boolean = false;
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
          paramqms.jdField_a_of_type_Qtk.jdField_a_of_type_Boolean = true;
          break;
        }
      }
    }
  }
  
  private void b(qmd paramqmd)
  {
    int i1;
    Object localObject;
    if ((paramqmd != null) && (paramqmd.jdField_a_of_type_Qqo != null) && (paramqmd.jdField_a_of_type_Qqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (paramqmd.jdField_a_of_type_Qqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo != null))
    {
      i1 = oat.c(nmf.a(paramqmd.jdField_a_of_type_Qqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo));
      if (i1 != 1) {
        break label88;
      }
      paramqmd = paramqmd.jdField_l_of_type_AndroidViewView;
      if (paramqmd != null)
      {
        localObject = (LinearLayout.LayoutParams)paramqmd.getLayoutParams();
        if (localObject != null)
        {
          ((LinearLayout.LayoutParams)localObject).weight = 2.0F;
          paramqmd.setLayoutParams((ViewGroup.LayoutParams)localObject);
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
        localObject = paramqmd.jdField_m_of_type_AndroidViewView;
        if (localObject != null)
        {
          LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((View)localObject).getLayoutParams();
          if (localLayoutParams != null)
          {
            localLayoutParams.weight = 0.0F;
            ((View)localObject).setLayoutParams(localLayoutParams);
          }
        }
        paramqmd = paramqmd.n;
      } while (paramqmd == null);
      localObject = (LinearLayout.LayoutParams)paramqmd.getLayoutParams();
    } while (localObject == null);
    ((LinearLayout.LayoutParams)localObject).weight = 0.0F;
    paramqmd.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  private void b(qmi paramqmi)
  {
    paramqmi = paramqmi.jdField_a_of_type_Qqo;
    if ((paramqmi != null) && ((paramqmi.jdField_a_of_type_Boolean) || ((paramqmi.jdField_a_of_type_Qub != null) && (paramqmi.jdField_a_of_type_Qub.e() != 0))))
    {
      paramqmi.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.c(paramqmi);
    }
  }
  
  private void b(boolean paramBoolean, qmd paramqmd)
  {
    if (oat.a()) {
      a(paramBoolean, paramqmd);
    }
    while (!a(paramqmd)) {
      return;
    }
    View localView = paramqmd.jdField_a_of_type_AndroidViewView;
    TextView localTextView = paramqmd.jdField_d_of_type_AndroidWidgetTextView;
    if ((localTextView != null) && (!paramqmd.jdField_a_of_type_Boolean)) {}
    for (boolean bool = true;; bool = false)
    {
      ColorDrawable localColorDrawable = new ColorDrawable();
      localColorDrawable.setColor(Color.parseColor("#FF12B7F6"));
      a(paramqmd, paramBoolean, bool, localView, localTextView, localTextView, localColorDrawable, null, paramqmd.jdField_b_of_type_AndroidViewView, paramqmd.jdField_f_of_type_AndroidWidgetTextView);
      return;
    }
  }
  
  private void c(qmd paramqmd)
  {
    if ((paramqmd == null) || (paramqmd.jdField_c_of_type_AndroidViewView == null) || (paramqmd.g == null) || (paramqmd.jdField_l_of_type_AndroidViewViewGroup == null) || (this.jdField_a_of_type_AndroidContentContext == null) || (this.jdField_a_of_type_AndroidContentContext.getResources() == null)) {
      return;
    }
    if ((paramqmd.jdField_c_of_type_AndroidViewView != null) && (c(paramqmd.jdField_a_of_type_Qqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo))) {
      paramqmd.jdField_c_of_type_AndroidViewView.setVisibility(8);
    }
    View localView = paramqmd.jdField_c_of_type_AndroidViewView;
    Object localObject = new GradientDrawable();
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
    TextView localTextView = paramqmd.g;
    RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)localTextView.getLayoutParams();
    if (paramqmd.jdField_l_of_type_AndroidViewViewGroup.getVisibility() == 0)
    {
      ((GradientDrawable)localObject).setCornerRadius(actn.a(6.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
      localLayoutParams.height = actn.a(31.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      localLayoutParams.topMargin = actn.a(8.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      localLayoutParams.bottomMargin = actn.a(10.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      localLayoutParams.leftMargin = actn.a(15.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      localLayoutParams.rightMargin = actn.a(15.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      if (localLayoutParams1 != null)
      {
        localLayoutParams1.addRule(13);
        localTextView.setLayoutParams(localLayoutParams1);
      }
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130842176);
    }
    for (;;)
    {
      localView.setLayoutParams(localLayoutParams);
      if ((paramqmd.jdField_a_of_type_AndroidWidgetProgressBar == null) || (localObject == null)) {
        break;
      }
      paramqmd.jdField_a_of_type_AndroidWidgetProgressBar.setProgressDrawable((Drawable)localObject);
      return;
      localLayoutParams.height = actn.a(42.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      localLayoutParams.topMargin = actn.a(15.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      localLayoutParams.bottomMargin = actn.a(0.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      localLayoutParams.leftMargin = actn.a(0.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      localLayoutParams.rightMargin = actn.a(0.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      ((GradientDrawable)localObject).setCornerRadius(actn.a(0.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130842174);
      if (localLayoutParams1 != null)
      {
        localLayoutParams1.addRule(15);
        localTextView.setLayoutParams(localLayoutParams1);
      }
    }
  }
  
  private static boolean c(VideoInfo paramVideoInfo)
  {
    return oau.a(paramVideoInfo);
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
      if (this.jdField_a_of_type_Qpy == null) {
        break label357;
      }
      i1 = this.jdField_a_of_type_Qpy.a();
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
    if (this.jdField_a_of_type_Qpr != null)
    {
      if (!this.jdField_a_of_type_Qpr.a()) {
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
        noo.a(null, str4, str1, str1, 0, 0, "0", "0", str3, npx.a(str2, paramVideoInfo.jdField_j_of_type_JavaLangString, paramVideoInfo.jdField_a_of_type_JavaLangString, paramVideoInfo.jdField_g_of_type_JavaLangString, localJSONObject), false);
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
    qol.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i1);
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
        localObject = new qze("", "", paramVideoInfo.jdField_a_of_type_JavaLangString, paramVideoInfo.jdField_g_of_type_JavaLangString).u(((VideoInfo.ChannelInfo)localObject).jdField_a_of_type_Int).v(qol.a((VideoInfo.ChannelInfo)localObject)).a(paramVideoInfo.N).a().a();
        if (this.jdField_a_of_type_Boolean) {
          noo.a(null, "", "0X8009330", "0X8009330", 0, 0, "3", "", "", (String)localObject, false);
        }
        for (;;)
        {
          i1 += 1;
          break;
          noo.a(null, "", "0X80092F8", "0X80092F8", 0, 0, "3", "", "", (String)localObject, false);
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
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a = new qun(qun.jdField_c_of_type_Int, qun.jdField_f_of_type_Int);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a(new qlx(this));
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
  
  public qmg a(ViewGroup paramViewGroup, int paramInt)
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
        paramViewGroup.jdField_a_of_type_Qjr = ((qjr)localObject2);
        paramViewGroup.jdField_a_of_type_Qtk = new qtk(paramViewGroup, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager, this.jdField_f_of_type_Boolean);
        return paramViewGroup;
      }
      break;
    case 2: 
      localObject1 = qrr.a(2131560064, true, new ViewGroup.LayoutParams(-1, -1));
      paramViewGroup = (qmr)((View)localObject1).getTag();
      if (paramViewGroup == null) {
        paramViewGroup = qmr.a((View)localObject1);
      }
      break;
    }
    for (;;)
    {
      localObject2 = new qmm(this, (qmr)paramViewGroup);
      localObject1 = null;
      break;
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560055, paramViewGroup, false);
      ((LayoutInflater)localObject1).inflate(2131560081, (ViewGroup)paramViewGroup.findViewById(2131364538), true);
      ((LayoutInflater)localObject1).inflate(2131560078, (ViewGroup)paramViewGroup.findViewById(2131364536), true);
      ((LayoutInflater)localObject1).inflate(2131560079, (ViewGroup)paramViewGroup.findViewById(2131364534), true);
      paramViewGroup = new qmd(paramViewGroup, paramInt);
      localObject2 = new qly(this, (qmd)paramViewGroup);
      localObject1 = null;
      break;
      localObject2 = qrr.a(2131560060, true, new ViewGroup.LayoutParams(-1, -1));
      localObject1 = (qml)((View)localObject2).getTag();
      paramViewGroup = (ViewGroup)localObject1;
      if (localObject1 == null) {
        paramViewGroup = new qml((View)localObject2, paramInt);
      }
      this.jdField_a_of_type_Qml = paramViewGroup;
      localObject2 = null;
      localObject1 = paramViewGroup;
      paramViewGroup = null;
      break;
      return localObject1;
    }
  }
  
  public qny a()
  {
    return this.jdField_a_of_type_Qny;
  }
  
  public qsx a()
  {
    return this.jdField_a_of_type_Qsx;
  }
  
  public void a()
  {
    int i1 = this.jdField_a_of_type_JavaUtilList.size();
    int i2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.c();
    RecyclerView.ViewHolder localViewHolder = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.findViewHolderForLayoutPosition(i1 + i2 - 1);
    if ((localViewHolder instanceof qml)) {
      a((qml)localViewHolder);
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
    if ((this.jdField_a_of_type_Qmx != null) && (this.jdField_a_of_type_Qmx.a()) && (this.jdField_a_of_type_Qmx.b()))
    {
      this.jdField_a_of_type_Qmx.h();
      break label34;
    }
    for (;;)
    {
      label34:
      return;
      if (!this.v) {
        continue;
      }
      paramView = (qmi)paramView.getTag();
      if (paramView != this.jdField_a_of_type_Qmi)
      {
        if (this.jdField_a_of_type_Qmi == null) {
          break;
        }
        if ((paramView != null) && (paramView.jdField_c_of_type_Int == this.jdField_a_of_type_Qmi.jdField_c_of_type_Int + 1) && (paramView.jdField_c_of_type_Int != getItemCount()))
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.a();
          return;
        }
        if ((paramView == null) || (paramView.jdField_c_of_type_Int != this.jdField_a_of_type_Qmi.jdField_c_of_type_Int - 1)) {
          break;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.b();
        return;
      }
      paramView.jdField_a_of_type_Qjr.c();
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
          noo.a(null, null, "0X80091AB", "0X80091AB", 0, 0, "", "", "", npx.a(null, null, paramView.jdField_a_of_type_Qqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, paramView.jdField_a_of_type_Qqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_g_of_type_JavaLangString, localJSONObject), false);
          return;
          if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager == null) || (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.d())) {
            continue;
          }
          localJSONObject = new JSONObject();
          try
          {
            localJSONObject.put("channel_id", 409409);
            label307:
            noo.a(null, null, "0X80091AB", "0X80091AB", 0, 0, "", "", "", npx.a(null, null, paramView.jdField_a_of_type_Qqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, paramView.jdField_a_of_type_Qqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_g_of_type_JavaLangString, localJSONObject), false);
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
    paramView = (qms)paramView.getTag();
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
        paramView.jdField_a_of_type_Qjr.a(1);
        this.t = false;
        return;
      } while (paramView.d.getVisibility() != 0);
      paramView.jdField_a_of_type_Qjr.a(2);
    } while (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.b());
    this.t = true;
  }
  
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    qms localqms = (qms)paramView.getTag();
    if (localqms != this.jdField_a_of_type_Qmi) {}
    while ((!this.v) || (localqms == null) || (localqms.jdField_a_of_type_Qqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == null) || (!(localqms instanceof qmi)) || (TextUtils.isEmpty(localqms.jdField_a_of_type_Qqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_g_of_type_JavaLangString))) {
      return;
    }
    Object localObject = localqms.jdField_a_of_type_Qqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
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
      if ((this.jdField_a_of_type_Qpr != null) && ((localqms instanceof qmr)))
      {
        int i2 = 0;
        i1 = i2;
        if (this.jdField_a_of_type_Qst != null)
        {
          i1 = i2;
          if (this.jdField_a_of_type_Qst.a()) {
            i1 = 1;
          }
        }
        if (i1 == 0) {
          this.jdField_a_of_type_Qpr.a((VideoInfo)localObject, (qmr)localqms);
        }
      }
      localqms.jdField_a_of_type_Qjr.a(paramInt1, paramInt2, bool);
      if (bool)
      {
        if (this.jdField_a_of_type_Qmf != null) {
          this.jdField_a_of_type_Qmf.a((VideoInfo)localObject, ((VideoInfo)localObject).jdField_l_of_type_Boolean);
        }
        e((VideoInfo)localObject);
      }
      if (this.jdField_a_of_type_Qri != null) {
        this.jdField_a_of_type_Qri.a(3, (VideoInfo)localObject, 0L);
      }
      localJSONObject = new JSONObject();
      if ((localqms.jdField_a_of_type_Qqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int != 0) || (localqms.jdField_a_of_type_Qqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null)) {
        break label580;
      }
      paramView = localqms.jdField_a_of_type_Qqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5();
    }
    try
    {
      label298:
      localJSONObject.put("channel_id", 409409);
      localJSONObject.put("rowkey", localqms.jdField_a_of_type_Qqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_g_of_type_JavaLangString);
      if (this.jdField_a_of_type_Qpy == null) {
        break label585;
      }
      paramInt1 = this.jdField_a_of_type_Qpy.a();
      label345:
      localJSONObject.put("style", paramInt1);
      localJSONObject.put("algorithm_id", ((VideoInfo)localObject).f);
      paramInt1 = 0;
      if (this.jdField_a_of_type_Qpr != null)
      {
        if (!this.jdField_a_of_type_Qpr.a()) {
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
      str2 = localqms.jdField_a_of_type_Qqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_j_of_type_JavaLangString;
      if (TextUtils.isEmpty(localqms.jdField_a_of_type_Qqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_g_of_type_JavaLangString)) {
        break label616;
      }
    }
    for (str1 = localqms.jdField_a_of_type_Qqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_g_of_type_JavaLangString;; str1 = "0")
    {
      noo.a(null, str2, (String)localObject, (String)localObject, 0, 0, "0", "0", str1, npx.a(paramView, localqms.jdField_a_of_type_Qqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_j_of_type_JavaLangString, localqms.jdField_a_of_type_Qqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, localqms.jdField_a_of_type_Qqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_g_of_type_JavaLangString, localJSONObject), false);
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
    if ((paramVideoInfo != null) && (this.jdField_a_of_type_Qze != null))
    {
      this.jdField_a_of_type_Qze.a(paramVideoInfo.N);
      a(paramVideoInfo, this.jdField_a_of_type_Qze);
      this.jdField_a_of_type_Qze = null;
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
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(new qlw(this));
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
      if ((paramList instanceof qms)) {
        ((qms)paramList).jdField_a_of_type_Qjr.a();
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
  
  public void a(qji paramqji)
  {
    this.jdField_a_of_type_Qji = paramqji;
  }
  
  public void a(qks paramqks)
  {
    this.jdField_a_of_type_Qks = paramqks;
  }
  
  public void a(qmf paramqmf)
  {
    this.jdField_a_of_type_Qmf = paramqmf;
  }
  
  public void a(qmg paramqmg, int paramInt)
  {
    paramqmg.jdField_b_of_type_Int = paramInt;
    paramqmg.jdField_c_of_type_Int = paramInt;
    paramqmg.jdField_b_of_type_Boolean = true;
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size()))
    {
      if (this.jdField_a_of_type_Qks != null)
      {
        VideoInfo localVideoInfo = this.jdField_a_of_type_Qks.b(paramInt);
        if (localVideoInfo != null) {
          this.jdField_a_of_type_JavaUtilList.set(paramInt, localVideoInfo);
        }
      }
      a(paramqmg, (VideoInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt));
      return;
    }
    a(paramqmg, null);
  }
  
  public void a(qmg paramqmg, VideoInfo paramVideoInfo)
  {
    int i1 = paramqmg.jdField_a_of_type_Int;
    if ((i1 == 3) || (i1 == 6))
    {
      a((qml)paramqmg);
      this.jdField_a_of_type_Qml = ((qml)paramqmg);
    }
    do
    {
      return;
      paramqmg = (qmi)paramqmg;
      b(paramqmg);
      a(paramqmg, paramVideoInfo);
      TraceCompat.beginSection("refreshMenuUI");
      paramqmg.jdField_a_of_type_Qjr.a(paramVideoInfo);
      TraceCompat.endSection();
      TraceCompat.beginSection("refreshContentUI");
      paramqmg.jdField_a_of_type_Qjr.a(paramVideoInfo, this.jdField_d_of_type_Boolean);
      TraceCompat.endSection();
      if ((this.h) && (paramqmg == this.jdField_a_of_type_Qmi)) {
        paramqmg.jdField_a_of_type_Qjr.e(this.h);
      }
    } while (!paramqmg.jdField_b_of_type_Boolean);
    a(paramqmg);
  }
  
  public void a(qms paramqms)
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
    if (this.jdField_a_of_type_Qmi != null)
    {
      i1 = this.jdField_a_of_type_Qmi.jdField_c_of_type_Int;
      this.jdField_a_of_type_Qmi = paramqms;
      if ((this.jdField_a_of_type_Qmi.jdField_c_of_type_Int == 0) && (this.jdField_a_of_type_Qmi.jdField_b_of_type_Int == 0))
      {
        paramqms.jdField_a_of_type_Qqo.jdField_a_of_type_Long = this.jdField_c_of_type_Long;
        this.jdField_c_of_type_Long = 0L;
      }
      if (!this.jdField_g_of_type_Boolean) {
        break label196;
      }
      bool = a(paramqms);
      this.jdField_g_of_type_Boolean = false;
      l1 = System.currentTimeMillis();
      l2 = this.jdField_b_of_type_Long;
      if (!bool) {
        break label201;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(this.jdField_a_of_type_Qmi.jdField_a_of_type_Qqo, false);
    }
    for (;;)
    {
      a(paramqms, bool, l1 - l2, i1);
      if ((paramqms.jdField_a_of_type_Qqo != null) && (paramqms.jdField_a_of_type_Qqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null)) {
        sgj.a(paramqms.jdField_a_of_type_Qqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_g_of_type_JavaLangString, paramqms.jdField_a_of_type_Qqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, 0, 0);
      }
      return;
      i1 = -1;
      break;
      label196:
      bool = true;
      break label101;
      label201:
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(paramqms.jdField_a_of_type_Qqo);
    }
  }
  
  public void a(qmx paramqmx)
  {
    this.jdField_a_of_type_Qmx = paramqmx;
  }
  
  public void a(qny paramqny)
  {
    this.jdField_a_of_type_Qny = paramqny;
  }
  
  public void a(qpy paramqpy)
  {
    this.jdField_a_of_type_Qpy = paramqpy;
  }
  
  public void a(qri paramqri)
  {
    this.jdField_a_of_type_Qri = paramqri;
  }
  
  public void a(qst paramqst)
  {
    this.jdField_a_of_type_Qst = paramqst;
  }
  
  public void a(qsx paramqsx)
  {
    this.jdField_a_of_type_Qsx = paramqsx;
  }
  
  public void a(qth paramqth)
  {
    this.jdField_a_of_type_Qth = paramqth;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public boolean a(VideoInfo paramVideoInfo)
  {
    return (this.jdField_a_of_type_Qmi == null) || (this.jdField_a_of_type_Qmi.jdField_a_of_type_Qqo == null) || (this.jdField_a_of_type_Qmi.jdField_a_of_type_Qqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == paramVideoInfo);
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
    paramString = omm.jdField_k_of_type_JavaLangString + bbca.encodeToString(String.valueOf(paramString).getBytes(), 2);
    onk.a(this.jdField_a_of_type_AndroidAppActivity, paramString);
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
      if (((localObject instanceof qms)) && (((qms)localObject).jdField_c_of_type_Int == this.jdField_a_of_type_Qmi.jdField_c_of_type_Int + 1))
      {
        localObject = ((qms)localObject).jdField_a_of_type_Qqo;
        if ((localObject != null) && ((((qqo)localObject).jdField_a_of_type_Boolean) || ((((qqo)localObject).jdField_a_of_type_Qub != null) && (((qqo)localObject).jdField_a_of_type_Qub.e() != 0))))
        {
          ((qqo)localObject).jdField_a_of_type_Boolean = false;
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.c((qqo)localObject);
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
      oaj.c(this.jdField_a_of_type_AndroidAppActivity);
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
      this.jdField_a_of_type_Qmi = null;
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
    sht.a(this);
    if ((this.jdField_a_of_type_Qmi != null) && (this.jdField_a_of_type_Qmi.jdField_a_of_type_Qjr != null) && ((this.jdField_a_of_type_Qmi.jdField_a_of_type_Qjr instanceof qly))) {
      ((qly)this.jdField_a_of_type_Qmi.jdField_a_of_type_Qjr).e();
    }
    ApngImage.playByTag(28);
    ApngImage.playByTag(29);
    ApngImage.playByTag(30);
    oaj.d();
    oau.a(this.jdField_a_of_type_Qji, this, (qms)this.jdField_a_of_type_Qmi);
  }
  
  public void e(boolean paramBoolean)
  {
    if ((!this.o) && (paramBoolean) && (this.p))
    {
      if ((this.jdField_a_of_type_Qmi instanceof qms)) {
        a((qms)this.jdField_a_of_type_Qmi);
      }
      this.p = false;
    }
    this.o = paramBoolean;
  }
  
  public void f()
  {
    if ((this.jdField_a_of_type_Qze != null) && (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null)) {
      a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo, this.jdField_a_of_type_Qze);
    }
    if (this.jdField_a_of_type_Qmf != null) {
      this.jdField_a_of_type_Qmf = null;
    }
    if (this.jdField_a_of_type_Qmi != null) {
      this.jdField_a_of_type_Qmi.jdField_b_of_type_ComTencentImageURLImageView = null;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidOsHandler = null;
    this.jdField_a_of_type_Bfuc = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    if (this.jdField_a_of_type_Nzy != null) {
      this.jdField_a_of_type_Nzy.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler != null) {
      AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    }
    if (this.jdField_a_of_type_Qky != null)
    {
      this.jdField_a_of_type_Qky.b();
      this.jdField_a_of_type_Qky = null;
    }
    if (this.jdField_a_of_type_Qpr != null)
    {
      this.jdField_a_of_type_Qpr.a();
      this.jdField_a_of_type_Qpr = null;
    }
    oaj.e();
  }
  
  public void f(boolean paramBoolean) {}
  
  public void g()
  {
    if ((this.jdField_a_of_type_Qmi == null) || (this.jdField_a_of_type_Qmi.jdField_a_of_type_Qqo == null) || (this.jdField_a_of_type_Qmi.jdField_a_of_type_Qqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == null) || (this.jdField_a_of_type_Qmi.jdField_a_of_type_Qqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_b_of_type_Long <= 0L)) {
      return;
    }
    String str = ajyc.a(2131716176);
    this.jdField_a_of_type_Qmi.jdField_a_of_type_Qyy.a(0, str, "点击重试");
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
    if ((this.jdField_a_of_type_Qml != null) && (this.jdField_a_of_type_Qml.itemView != null)) {
      return this.jdField_a_of_type_Qml.itemView.hashCode();
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
    Object localObject3 = (qmg)paramView.getTag();
    VideoInfo localVideoInfo;
    if ((localObject3 instanceof qms))
    {
      localVideoInfo = ((qms)localObject3).jdField_a_of_type_Qqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
      if ((this.jdField_a_of_type_Qmi != null) && (this.jdField_a_of_type_Qmi.jdField_a_of_type_Qqo != null) && (localVideoInfo == this.jdField_a_of_type_Qmi.jdField_a_of_type_Qqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo)) {}
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
          localObject1 = oay.a(localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
          this.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params = sht.a(this.jdField_a_of_type_AndroidAppActivity, (AdvertisementInfo)localObject1, null, 3, false, null);
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
          case 2131361822: 
            if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView == null) {
              break label62;
            }
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.a();
            return;
            l1 = -2147483648L;
            break label118;
          }
        }
        if (this.jdField_a_of_type_Qrm != null) {
          this.jdField_a_of_type_Qrm.b();
        }
        if (paramView.getId() != 2131365728) {
          break;
        }
        qyz.b(localVideoInfo.jdField_g_of_type_JavaLangString, 1);
        return;
        if ((this.jdField_a_of_type_Qmi.jdField_a_of_type_Qqo == null) || (localVideoInfo == null)) {
          break;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.a(false);
        qyz.a(this.jdField_a_of_type_AndroidAppActivity, qjo.a(localVideoInfo), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(localVideoInfo.jdField_g_of_type_JavaLangString), 1, 0);
        qyz.a(localVideoInfo.jdField_g_of_type_JavaLangString, 1, 0);
        return;
        if ((((qmg)localObject3).jdField_a_of_type_Int == 2) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a() == 5)) {
          qol.a(((qms)localObject3).d, 8, 200);
        }
        if (this.jdField_a_of_type_Qrm == null) {
          break;
        }
        this.jdField_a_of_type_Qrm.b();
        return;
        if (((this.jdField_a_of_type_Qmi instanceof qmr)) && (!((qmr)this.jdField_a_of_type_Qmi).jdField_a_of_type_Boolean) && (rmc.a().b()) && (localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null))
        {
          localObject1 = localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.fusionBiuInfo;
          if (localObject1 == null) {
            break;
          }
          rmc.a().a(((qms)localObject3).k, ((FusionBiuInfo)localObject1).jdField_b_of_type_Boolean);
          if (!((FusionBiuInfo)localObject1).jdField_b_of_type_Boolean) {
            rmc.a().a(paramView.getContext(), onk.a(), 1, 2, localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, 4, localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
          }
          for (;;)
          {
            rmc.a().b(localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, 0, 2, 2);
            return;
            rmc.a().a(paramView.getContext(), ((FusionBiuInfo)localObject1).jdField_a_of_type_Long, onk.a(), localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedType, 4, localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
          }
        }
        if (odr.a() == 1) {}
        for (boolean bool = true;; bool = false)
        {
          a(localVideoInfo, false, bool);
          if (this.jdField_a_of_type_Qri == null) {
            break;
          }
          this.jdField_a_of_type_Qri.a(2, localVideoInfo, 0L);
          return;
        }
        if ((this.jdField_a_of_type_Qmx != null) && (localVideoInfo.a(this.jdField_a_of_type_AndroidAppActivity))) {
          this.jdField_a_of_type_Qmx.h();
        }
        if (localVideoInfo.jdField_c_of_type_Boolean)
        {
          sht.b(this.jdField_a_of_type_AndroidAppActivity, (AdvertisementInfo)localObject1, null, 3, true, null);
          a(localVideoInfo, 0);
          return;
        }
        if (localVideoInfo.e())
        {
          qol.a(this.jdField_a_of_type_AndroidAppActivity, localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo);
          localObject1 = new qze(localVideoInfo).h(localVideoInfo.jdField_g_of_type_JavaLangString).u(localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_a_of_type_Int);
          if (localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo != null) {}
          for (paramView = localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.e;; paramView = "")
          {
            noo.b(null, "", "0X800A18C", "0X800A18C", 0, 0, "", "", "", ((qze)localObject1).o(paramView).S(1).a().a(), false);
            return;
          }
        }
        if ((localVideoInfo.O != null) && (!localVideoInfo.O.equals("")))
        {
          onk.a(this.jdField_a_of_type_AndroidAppActivity, localVideoInfo.O);
          return;
        }
        if (localVideoInfo.jdField_a_of_type_Int == 6)
        {
          if (!TextUtils.isEmpty(localVideoInfo.jdField_j_of_type_JavaLangString))
          {
            paramView = omm.jdField_g_of_type_JavaLangString + bbca.encodeToString(localVideoInfo.jdField_j_of_type_JavaLangString.getBytes(), 2);
            onk.a(this.jdField_a_of_type_AndroidAppActivity, paramView);
          }
          localObject1 = new qze((String)localObject2, localVideoInfo.jdField_j_of_type_JavaLangString, localVideoInfo.jdField_a_of_type_JavaLangString, localVideoInfo.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(), localVideoInfo.a() * 1000L).a(-1).O(0).a().a();
          localObject2 = localVideoInfo.jdField_j_of_type_JavaLangString;
          if (TextUtils.isEmpty(localVideoInfo.jdField_g_of_type_JavaLangString)) {
            break label1332;
          }
        }
        label1332:
        for (paramView = localVideoInfo.jdField_g_of_type_JavaLangString;; paramView = "0")
        {
          noo.a(null, (String)localObject2, "0X8007410", "0X8007410", 0, 0, "0", "", paramView, (String)localObject1, false);
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
          qol.a(this.jdField_a_of_type_AndroidAppActivity, localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_c_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo);
          localObject1 = new qze(localVideoInfo).h(localVideoInfo.jdField_g_of_type_JavaLangString).u(localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_a_of_type_Int);
          if (localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_c_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo != null) {}
          for (paramView = localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_c_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.e;; paramView = "")
          {
            noo.b(null, "", "0X800A18C", "0X800A18C", 0, 0, "", "", "", ((qze)localObject1).o(paramView).S(2).O(0).a().a(), false);
            return;
          }
        }
        if (localVideoInfo.jdField_k_of_type_Boolean) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "followPubAccount onClick() puin=" + localVideoInfo.jdField_j_of_type_JavaLangString + ", isFollowed=" + localVideoInfo.jdField_k_of_type_Boolean + ", pname=" + localVideoInfo.jdField_k_of_type_JavaLangString);
        }
        localObject1 = new qze(null, localVideoInfo.jdField_j_of_type_JavaLangString, localVideoInfo.jdField_a_of_type_JavaLangString, localVideoInfo.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(), localVideoInfo.a() * 1000L).a(localVideoInfo.N).O(0).a().a();
        if (this.jdField_a_of_type_Boolean)
        {
          localObject2 = localVideoInfo.jdField_j_of_type_JavaLangString;
          if (!TextUtils.isEmpty(localVideoInfo.jdField_g_of_type_JavaLangString)) {}
          for (paramView = localVideoInfo.jdField_g_of_type_JavaLangString;; paramView = "0")
          {
            noo.a(null, (String)localObject2, "0X800929B", "0X800929B", 0, 0, "", "", paramView, (String)localObject1, false);
            a(localVideoInfo.jdField_j_of_type_JavaLangString, localVideoInfo.jdField_b_of_type_Boolean);
            return;
          }
        }
        localObject2 = localVideoInfo.jdField_j_of_type_JavaLangString;
        if (!TextUtils.isEmpty(localVideoInfo.jdField_g_of_type_JavaLangString)) {}
        for (paramView = localVideoInfo.jdField_g_of_type_JavaLangString;; paramView = "0")
        {
          noo.a(null, (String)localObject2, "0X80078FD", "0X80078FD", 0, 0, "", "", paramView, (String)localObject1, false);
          break;
        }
        if ((!localVideoInfo.jdField_c_of_type_Boolean) || (!(this.jdField_a_of_type_Qmi instanceof qmd))) {
          break;
        }
        a(paramView, (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(), localVideoInfo);
        return;
        if (!localVideoInfo.jdField_c_of_type_Boolean) {
          break;
        }
        sht.b(this.jdField_a_of_type_AndroidAppActivity, (AdvertisementInfo)localObject1, null, 3, true, null);
        a(localVideoInfo, 0);
        return;
        if (!localVideoInfo.jdField_c_of_type_Boolean) {
          break;
        }
        oau.a((AdvertisementInfo)localObject1, 1000, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
        sht.b(this.jdField_a_of_type_AndroidAppActivity, (AdvertisementInfo)localObject1, null, 3, false, null);
        a(localVideoInfo, nmf.ay);
        return;
        if (!localVideoInfo.jdField_c_of_type_Boolean) {
          break;
        }
        oau.a((AdvertisementInfo)localObject1, 2, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
        sht.b(this.jdField_a_of_type_AndroidAppActivity, (AdvertisementInfo)localObject1, null, 3, false, null);
        a(localVideoInfo, nmf.aq);
        return;
        if (!localVideoInfo.jdField_c_of_type_Boolean) {
          break;
        }
        oau.a((AdvertisementInfo)localObject1, 3, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
        sht.b(this.jdField_a_of_type_AndroidAppActivity, (AdvertisementInfo)localObject1, null, 3, false, null);
        a(localVideoInfo, nmf.ar);
        return;
        if (!localVideoInfo.jdField_c_of_type_Boolean) {
          break;
        }
        if (this.n)
        {
          this.n = false;
          oau.a((AdvertisementInfo)localObject1, 1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
          sht.b(this.jdField_a_of_type_AndroidAppActivity, (AdvertisementInfo)localObject1, null, 3, false, null);
          a(localVideoInfo, nmf.ap);
          return;
        }
        oau.a((AdvertisementInfo)localObject1, 4, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
        sht.b(this.jdField_a_of_type_AndroidAppActivity, (AdvertisementInfo)localObject1, null, 3, false, null);
        a(localVideoInfo, nmf.as);
        return;
        if (!(localObject3 instanceof qmd)) {
          break;
        }
        if (a(localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo))
        {
          a(localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
          nmf.a(new nyg().a(this.jdField_a_of_type_AndroidContentContext).a(nmf.J).b(nmf.N).a((AdvertisementInfo)localObject1).a());
          return;
        }
        localObject2 = (qmd)localObject3;
        int i1 = 8;
        if (this.i) {
          i1 = 13;
        }
        oau.a((AdvertisementInfo)localObject1, i1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
        c((qmd)localObject2);
        paramView = new View[1];
        paramView[0] = ((qmd)localObject2).jdField_c_of_type_AndroidViewView;
        if (c(localVideoInfo)) {
          paramView = new View[0];
        }
        a((qmd)localObject2, localVideoInfo, (AdvertisementInfo)localObject1, -1, paramView, new View[] { ((qmd)localObject2).jdField_d_of_type_AndroidWidgetTextView, ((qmd)localObject2).jdField_a_of_type_AndroidViewView, ((qmd)localObject2).jdField_b_of_type_AndroidWidgetSeekBar });
        return;
        if (!(localObject3 instanceof qmd)) {
          break;
        }
        if (a(localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo))
        {
          a(localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
          nmf.a(new nyg().a(this.jdField_a_of_type_AndroidContentContext).a(nmf.J).b(nmf.N).a((AdvertisementInfo)localObject1).a());
        }
        while ((this.jdField_a_of_type_Qmi != null) && (this.jdField_a_of_type_Qmi.jdField_a_of_type_Qqo != null))
        {
          oau.a(this.jdField_a_of_type_Qmi.jdField_a_of_type_Qqo, true);
          return;
          localObject2 = (qmd)localObject3;
          paramView = new View[2];
          paramView[0] = ((qmd)localObject2).r;
          paramView[1] = ((qmd)localObject2).jdField_c_of_type_AndroidViewView;
          if (c(localVideoInfo))
          {
            paramView = new View[1];
            paramView[0] = ((qmd)localObject2).r;
          }
          localObject3 = ((qmd)localObject2).jdField_d_of_type_AndroidWidgetTextView;
          localObject4 = ((qmd)localObject2).jdField_a_of_type_AndroidViewView;
          TextView localTextView = ((qmd)localObject2).jdField_m_of_type_AndroidWidgetTextView;
          SeekBar localSeekBar = ((qmd)localObject2).jdField_b_of_type_AndroidWidgetSeekBar;
          a((qmd)localObject2, localVideoInfo, (AdvertisementInfo)localObject1, nmf.Y, paramView, new View[] { localObject3, localObject4, localTextView, localSeekBar });
        }
        if (!(localObject3 instanceof qmd)) {
          break;
        }
        paramView = (qmd)localObject3;
        a((qmg)localObject3, localVideoInfo, (AdvertisementInfo)localObject1, -1, paramView.jdField_c_of_type_AndroidViewView, new View[] { paramView.jdField_d_of_type_AndroidWidgetTextView, paramView.jdField_a_of_type_AndroidViewView, paramView.jdField_b_of_type_AndroidWidgetSeekBar });
        return;
        if (!(localObject3 instanceof qmd)) {
          break;
        }
        paramView = (qmd)localObject3;
        a((qmg)localObject3, localVideoInfo, (AdvertisementInfo)localObject1, nmf.Y, paramView.r, new View[] { paramView.jdField_m_of_type_AndroidWidgetTextView, paramView.jdField_b_of_type_AndroidWidgetSeekBar });
        return;
        a(paramView);
        return;
        this.jdField_a_of_type_Qmx.g();
        if (this.jdField_a_of_type_Boolean)
        {
          paramView = "0X800948A";
          localObject1 = (qms)localObject3;
          if (((qms)localObject1).jdField_a_of_type_Qqo == null) {
            break label2810;
          }
          localObject1 = ((qms)localObject1).jdField_a_of_type_Qqo.jdField_a_of_type_Qub;
          localObject2 = new qze(null, localVideoInfo.jdField_j_of_type_JavaLangString, localVideoInfo.jdField_a_of_type_JavaLangString, localVideoInfo.jdField_g_of_type_JavaLangString);
          if (localObject1 == null) {
            break label2822;
          }
          if (((qub)localObject1).e() != 7) {
            break label2816;
          }
          bool = true;
          label2641:
          l1 = ((qub)localObject1).a(bool);
          label2650:
          localObject2 = ((qze)localObject2).d(l1);
          if (localObject1 == null) {
            break label2830;
          }
          l1 = ((qub)localObject1).a();
          label2671:
          localObject2 = ((qze)localObject2).a(l1);
          if (localObject1 == null) {
            break label2838;
          }
          l1 = ((qub)localObject1).b();
          localObject2 = ((qze)localObject2).c(l1).a(409409).a(localVideoInfo.N).w(this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("VIDEO_FROM_TYPE", -1)).a().a();
          localObject3 = localVideoInfo.jdField_j_of_type_JavaLangString;
          if (TextUtils.isEmpty(localVideoInfo.jdField_g_of_type_JavaLangString)) {
            break label2846;
          }
        }
        for (localObject1 = localVideoInfo.jdField_g_of_type_JavaLangString;; localObject1 = "0")
        {
          noo.a(null, (String)localObject3, paramView, paramView, 0, 0, "", "", (String)localObject1, (String)localObject2, false);
          if (this.jdField_a_of_type_Qri == null) {
            break;
          }
          this.jdField_a_of_type_Qri.a(4, localVideoInfo, 0L);
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
        this.jdField_a_of_type_Qmx.e();
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
            noo.a(null, "", "0X8008E54", "0X8008E54", 0, 0, "", "", "", npx.a("", "", localVideoInfo.jdField_a_of_type_JavaLangString, localVideoInfo.jdField_g_of_type_JavaLangString, (JSONObject)localObject4), false);
            return;
          }
          if (!this.jdField_a_of_type_Boolean) {
            continue;
          }
          noo.a(null, "", "0X80092A1", "0X80092A1", 0, 0, "", "", "", npx.a("", "", localVideoInfo.jdField_a_of_type_JavaLangString, localVideoInfo.jdField_g_of_type_JavaLangString, (JSONObject)localObject4), false);
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
          if ((localObject3 instanceof qms)) {
            ((qms)localObject3).jdField_a_of_type_Qjr.d();
          }
          if ((this.jdField_a_of_type_Qpy != null) && (localVideoInfo.jdField_l_of_type_Boolean)) {
            this.jdField_a_of_type_Qpy.a((float)(bbct.i() / 2L), (float)(bbct.j() / 2L));
          }
          if (this.jdField_a_of_type_Qri != null) {
            this.jdField_a_of_type_Qri.a(3, localVideoInfo, 0L);
          }
          if (this.jdField_a_of_type_Qmf != null) {
            this.jdField_a_of_type_Qmf.a(localVideoInfo, localVideoInfo.jdField_l_of_type_Boolean);
          }
          if ((this.jdField_a_of_type_Qpr != null) && ((localObject3 instanceof qmr)))
          {
            int i2 = 0;
            i1 = i2;
            if (this.jdField_a_of_type_Qst != null)
            {
              i1 = i2;
              if (this.jdField_a_of_type_Qst.a()) {
                i1 = 1;
              }
            }
            if (i1 == 0) {
              this.jdField_a_of_type_Qpr.a(localVideoInfo, (qmr)localObject3);
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
        this.jdField_a_of_type_Qji.e();
        a(false, (qms)localObject3);
        a((qms)localObject3);
        a(localVideoInfo, nmf.ax);
        return;
        oau.a((AdvertisementInfo)localObject1, 15, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
        this.jdField_a_of_type_Qji.f();
        sht.b(this.jdField_a_of_type_AndroidAppActivity, (AdvertisementInfo)localObject1, null, 3, true, null);
        a(localVideoInfo, nmf.au);
        return;
        oau.a((AdvertisementInfo)localObject1, 16, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
        this.jdField_a_of_type_Qji.f();
        sht.b(this.jdField_a_of_type_AndroidAppActivity, (AdvertisementInfo)localObject1, null, 3, true, null);
        a(localVideoInfo, nmf.av);
        return;
        oau.a((AdvertisementInfo)localObject1, 17, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
        if (a(localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo))
        {
          a(localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
          nmf.a(new nyg().a(this.jdField_a_of_type_AndroidContentContext).a(nmf.J).b(nmf.N).a((AdvertisementInfo)localObject1).a());
          return;
        }
        this.jdField_a_of_type_Qji.f();
        if (localObject1 != null) {
          sht.b(this.jdField_a_of_type_AndroidAppActivity, (AdvertisementInfo)localObject1, null, 3, true, null);
        }
        a(localVideoInfo, nmf.aw);
        return;
        oau.a((AdvertisementInfo)localObject1, 4001, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
        a(localVideoInfo, (AdvertisementInfo)localObject1, 4001);
        return;
        oau.a((AdvertisementInfo)localObject1, 4002, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
        a(localVideoInfo, (AdvertisementInfo)localObject1, 4002);
        return;
        oau.a((AdvertisementInfo)localObject1, 4007, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
        a(localVideoInfo, (AdvertisementInfo)localObject1, 4007);
        return;
        oau.a((AdvertisementInfo)localObject1, 4000, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
        a(localVideoInfo, (AdvertisementInfo)localObject1, 4000);
        return;
        this.jdField_a_of_type_AndroidOsHandler.sendMessage(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(9, Boolean.valueOf(false)));
        this.j = true;
        if (!(this.jdField_a_of_type_Qmi instanceof qmd)) {
          break;
        }
        c((qmd)this.jdField_a_of_type_Qmi);
        return;
        oau.a((AdvertisementInfo)localObject1, 34, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
        a(localVideoInfo, (AdvertisementInfo)localObject1, nmf.aI);
        return;
        oau.a((AdvertisementInfo)localObject1, 35, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
        a(localVideoInfo, (AdvertisementInfo)localObject1, nmf.aH);
        return;
        oau.a((AdvertisementInfo)localObject1, 37, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
        a(localVideoInfo, (AdvertisementInfo)localObject1, nmf.aJ);
        return;
        oau.a((AdvertisementInfo)localObject1, 2003, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
        a(localVideoInfo, (AdvertisementInfo)localObject1, 2003);
        return;
        oau.a((AdvertisementInfo)localObject1, 2004, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
        a(localVideoInfo, (AdvertisementInfo)localObject1, 2004);
        return;
        oau.a((AdvertisementInfo)localObject1, 18, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
        a(localVideoInfo, (AdvertisementInfo)localObject1, nmf.aK);
        return;
        localVideoInfo = null;
      }
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    qmg localqmg = (qmg)paramView.getTag();
    VideoInfo localVideoInfo = null;
    if ((localqmg instanceof qms))
    {
      localVideoInfo = ((qms)localqmg).jdField_a_of_type_Qqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
      if ((this.jdField_a_of_type_Qmi != null) && (this.jdField_a_of_type_Qmi.jdField_a_of_type_Qqo != null) && (localVideoInfo == this.jdField_a_of_type_Qmi.jdField_a_of_type_Qqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo)) {}
    }
    while (localVideoInfo == null) {
      return false;
    }
    switch (paramView.getId())
    {
    default: 
      return false;
    }
    if (rmc.a().b()) {
      return true;
    }
    if (odr.b() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      a(localVideoInfo, true, bool);
      if (this.jdField_a_of_type_Qri == null) {
        break;
      }
      this.jdField_a_of_type_Qri.a(2, localVideoInfo, 0L);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qls
 * JD-Core Version:    0.7.0.1
 */