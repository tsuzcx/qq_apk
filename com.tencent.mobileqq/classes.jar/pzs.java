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
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.TextView;
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
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter.12;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter.4;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsOptView;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.common.app.BaseApplicationImpl;
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

public class pzs
  extends RecyclerView.Adapter<qae>
  implements View.OnClickListener, View.OnLongClickListener, qcf, qfm, qkw, qkx
{
  private int jdField_a_of_type_Int;
  public long a;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Context jdField_a_of_type_AndroidContentContext;
  private ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private Handler jdField_a_of_type_AndroidOsHandler = new pzv(this, Looper.getMainLooper());
  private LinearLayoutManager jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager;
  private RecyclerView.RecycledViewPool jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$RecycledViewPool = new RecyclerView.RecycledViewPool();
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private bekx jdField_a_of_type_Bekx;
  private bemi jdField_a_of_type_Bemi;
  private VideoInfo jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
  private ADVideoAppDownloadManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager;
  private VideoFeedsPlayManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager;
  private VideoFeedsRecyclerView jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView;
  private VideoPreDownloadMgr jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private INetInfoHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new pzu(this);
  private String jdField_a_of_type_JavaLangString;
  public HashMap<String, Integer> a;
  private List<VideoInfo> jdField_a_of_type_JavaUtilList;
  private Map<Integer, Bitmap> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  private non jdField_a_of_type_Non;
  private pxk jdField_a_of_type_Pxk;
  private pys jdField_a_of_type_Pys;
  private pyu jdField_a_of_type_Pyu;
  private pyy jdField_a_of_type_Pyy;
  private qad jdField_a_of_type_Qad;
  private qag jdField_a_of_type_Qag;
  qaj jdField_a_of_type_Qaj;
  private qaq jdField_a_of_type_Qaq;
  private qaz jdField_a_of_type_Qaz;
  private qca jdField_a_of_type_Qca;
  private qdt jdField_a_of_type_Qdt;
  private qea jdField_a_of_type_Qea;
  private qfk jdField_a_of_type_Qfk;
  private qfo jdField_a_of_type_Qfo;
  public qfs a;
  private qgv jdField_a_of_type_Qgv;
  private qgw jdField_a_of_type_Qgw;
  private qhc jdField_a_of_type_Qhc;
  private qmv jdField_a_of_type_Qmv;
  public yjs a;
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
  private boolean s;
  private boolean t = true;
  
  public pzs(Context paramContext, Activity paramActivity, VideoFeedsRecyclerView paramVideoFeedsRecyclerView, LinearLayoutManager paramLinearLayoutManager, QQAppInterface paramQQAppInterface, String paramString1, String paramString2, boolean paramBoolean, int paramInt, qfo paramqfo)
  {
    this.jdField_a_of_type_Long = -2147483648L;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_Qfs = new pzw(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView = paramVideoFeedsRecyclerView;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.a(this.jdField_a_of_type_Qfs);
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager = paramLinearLayoutManager;
    this.jdField_c_of_type_AndroidGraphicsDrawableDrawable = bacm.b();
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130842443);
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130842470);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getMinimumWidth(), this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getMinimumHeight());
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getMinimumWidth(), this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getMinimumHeight());
    this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131099738));
    this.jdField_a_of_type_Pyu = pyu.a();
    this.jdField_a_of_type_Pyy = new pyy(paramActivity);
    this.jdField_a_of_type_Qdt = new qdt(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Bekx = new bekx(this.jdField_a_of_type_AndroidAppActivity);
    AppNetConnInfo.registerConnectionChangeReceiver(this.jdField_a_of_type_AndroidAppActivity.getApplication(), this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    this.jdField_d_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(1930498322);
    this.jdField_a_of_type_Qfo = paramqfo;
    setHasStableIds(true);
    registerAdapterDataObserver(new qac(this, null));
    this.q = awnu.b();
    this.jdField_a_of_type_Non = new non(paramActivity, this);
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
      return ajjy.a(2131650454);
    }
    if (paramInt == 2) {
      return ajjy.a(2131650451);
    }
    return null;
  }
  
  @NonNull
  private String a(VideoInfo paramVideoInfo, Resources paramResources)
  {
    return npj.a(this.jdField_a_of_type_AndroidAppActivity, paramVideoInfo, paramResources);
  }
  
  private void a(RecyclerView paramRecyclerView, List<VideoInfo> paramList, int paramInt)
  {
    int i2 = paramRecyclerView.getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      RecyclerView.ViewHolder localViewHolder = paramRecyclerView.getChildViewHolder(paramRecyclerView.getChildAt(i1));
      if ((localViewHolder instanceof qaq))
      {
        VideoInfo localVideoInfo = (VideoInfo)paramList.get(((qaq)localViewHolder).jdField_b_of_type_Int);
        if ((localVideoInfo.e()) && (localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_a_of_type_Int == paramInt)) {
          ((qaq)localViewHolder).jdField_a_of_type_Pxs.b(localVideoInfo);
        }
      }
      i1 += 1;
    }
  }
  
  private void a(View paramView, int paramInt, VideoInfo paramVideoInfo)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.c())) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.b();
    }
    if (this.jdField_a_of_type_Non != null) {
      this.jdField_a_of_type_Non.a(paramView, paramInt, paramVideoInfo);
    }
  }
  
  private void a(VideoAdInfo paramVideoAdInfo)
  {
    paramVideoAdInfo = nbe.a(paramVideoAdInfo);
    if (paramVideoAdInfo != null) {
      rvb.a(this.jdField_a_of_type_AndroidAppActivity, paramVideoAdInfo.mPopFormH5Url, paramVideoAdInfo.mAdRl, paramVideoAdInfo.mAdTraceId);
    }
  }
  
  private void a(VideoInfo paramVideoInfo, int paramInt)
  {
    if (paramVideoInfo == null) {
      return;
    }
    AdvertisementInfo localAdvertisementInfo = nbe.a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
    if (paramVideoInfo.a(this.jdField_a_of_type_AndroidAppActivity))
    {
      nbe.a(new nmv().a(this.jdField_a_of_type_AndroidContentContext).a(nbe.jdField_a_of_type_Int).b(nbe.P).a(localAdvertisementInfo).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).d(paramInt).a());
      return;
    }
    nbe.a(new nmv().a(this.jdField_a_of_type_AndroidContentContext).a(nbe.jdField_a_of_type_Int).b(nbe.N).a(localAdvertisementInfo).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).d(paramInt).a());
  }
  
  private void a(VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo, int paramInt)
  {
    if (paramAdvertisementInfo == null) {
      return;
    }
    rvb.b(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, true, null);
    paramAdvertisementInfo = nbe.a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
    nbe.a(new nmv().a(this.jdField_a_of_type_AndroidContentContext).a(nbe.jdField_a_of_type_Int).b(nbe.Y).a(paramAdvertisementInfo).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).d(paramInt).a());
  }
  
  private void a(VideoInfo paramVideoInfo, qmv paramqmv)
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
        ndn.b(null, (String)localObject2, "0X8009298", "0X8009298", 0, 0, "0", "", (String)localObject1, paramqmv.a().a(), false);
        try
        {
          if ((paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.fusionBiuInfo.jdField_c_of_type_Boolean) && (!paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.fusionBiuInfo.jdField_d_of_type_Boolean))
          {
            qzk.a().a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, 0, 2, 2);
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
      if ((!TextUtils.isEmpty(paramVideoInfo.J)) && (qcn.c()))
      {
        i1 = 1;
        label142:
        localObject1 = paramqmv.S(i1);
        if (!paramVideoInfo.e()) {
          break label421;
        }
        i1 = 2;
        label158:
        localObject1 = ((qmv)localObject1).Y(i1);
        if (!paramVideoInfo.e()) {
          break label426;
        }
        i1 = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_a_of_type_Int;
        label181:
        localObject1 = ((qmv)localObject1).t(i1);
        if ((!paramVideoInfo.e()) || (TextUtils.isEmpty(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_g_of_type_JavaLangString)) || (TextUtils.isEmpty(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.f))) {
          break label431;
        }
        i1 = 1;
        label224:
        localObject2 = ((qmv)localObject1).Z(i1);
        if ((!paramVideoInfo.e()) || (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo == null)) {
          break label436;
        }
        localObject1 = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.e;
        label261:
        localObject2 = ((qmv)localObject2).o((String)localObject1);
        if ((!paramVideoInfo.e()) || (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.d == null)) {
          break label444;
        }
        localObject1 = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.d.e;
        label299:
        localObject1 = ((qmv)localObject2).p((String)localObject1);
        if (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo == null) {
          break label452;
        }
        label315:
        localObject2 = ((qmv)localObject1).k(bool);
        if ((paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo == null) || (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo == null)) {
          break label458;
        }
        localObject1 = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.e;
        label353:
        ((qmv)localObject2).q((String)localObject1);
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
        ndn.b(null, (String)localObject2, "0X8007801", "0X8007801", 0, 0, "0", "", (String)localObject1, paramqmv.a().a(), false);
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
    if ((paramVideoInfo.jdField_a_of_type_Int == 0) && (paramVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null))
    {
      localObject1 = paramVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5();
      localObject1 = new qmv((String)localObject1, paramVideoInfo.jdField_j_of_type_JavaLangString, paramVideoInfo.jdField_a_of_type_JavaLangString, paramVideoInfo.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(), paramVideoInfo.a() * 1000);
      ((qmv)localObject1).g(paramBoolean1).h(paramBoolean2);
      if (!this.jdField_a_of_type_Boolean)
      {
        ((qmv)localObject1).e(paramVideoInfo.f).c(paramVideoInfo.jdField_r_of_type_Int).a(-1).a(paramVideoInfo.N).N(0);
        localObject2 = new pqh();
        ((pqh)localObject2).jdField_d_of_type_Int = ((int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a());
        ((pqh)localObject2).jdField_e_of_type_Int = (paramVideoInfo.a() * 1000);
        ((pqh)localObject2).jdField_b_of_type_Int = this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
        new.b(paramVideoInfo, this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_CHANNEL_ID", -1), 25, -1, (pqh)localObject2, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_g_of_type_JavaLangString);
      }
      localObject1 = ((qmv)localObject1).a().a();
      if (!this.jdField_a_of_type_Boolean) {
        break label283;
      }
      localObject2 = paramVideoInfo.jdField_j_of_type_JavaLangString;
      if (TextUtils.isEmpty(paramVideoInfo.jdField_g_of_type_JavaLangString)) {
        break label276;
      }
    }
    label276:
    for (paramVideoInfo = paramVideoInfo.jdField_g_of_type_JavaLangString;; paramVideoInfo = "0")
    {
      ndn.a(null, (String)localObject2, "0X8009299", "0X8009299", 0, 0, "0", "0", paramVideoInfo, (String)localObject1, false);
      return;
      localObject1 = null;
      break;
    }
    label283:
    Object localObject2 = paramVideoInfo.jdField_j_of_type_JavaLangString;
    if (!TextUtils.isEmpty(paramVideoInfo.jdField_g_of_type_JavaLangString)) {}
    for (paramVideoInfo = paramVideoInfo.jdField_g_of_type_JavaLangString;; paramVideoInfo = "0")
    {
      ndn.a(null, (String)localObject2, "0X8007B89", "0X8007B89", 0, 0, "0", "0", paramVideoInfo, (String)localObject1, false);
      return;
    }
  }
  
  private void a(KandianUrlImageView paramKandianUrlImageView, VideoInfo paramVideoInfo)
  {
    if ((paramKandianUrlImageView == null) || (paramVideoInfo == null)) {
      return;
    }
    if ((!qcn.c()) || (TextUtils.isEmpty(paramVideoInfo.J)))
    {
      paramKandianUrlImageView.setVisibility(8);
      return;
    }
    Object localObject;
    if (paramVideoInfo.J.endsWith("zip"))
    {
      localObject = oet.a(paramVideoInfo.J);
      ((oet)localObject).setRepeatCount(0);
      paramKandianUrlImageView.setImageDrawable((Drawable)localObject);
      if ((paramKandianUrlImageView.getVisibility() == 8) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.c()) && (this.jdField_a_of_type_Qag.jdField_a_of_type_Qeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == paramVideoInfo)) {
        ((oet)localObject).playAnimation();
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
      localLayoutParams.width = aciy.a(91.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    }
    for (localLayoutParams.height = aciy.a(28.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());; localLayoutParams.height = aciy.a(24.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()))
    {
      paramKandianUrlImageView.setLayoutParams(localLayoutParams);
      return;
      localLayoutParams.width = aciy.a(78.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
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
      qcn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramBoolean);
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
  
  private void a(qab paramqab)
  {
    int i1;
    Object localObject;
    if ((paramqab != null) && (paramqab.jdField_a_of_type_Qeq != null) && (paramqab.jdField_a_of_type_Qeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (paramqab.jdField_a_of_type_Qeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo != null))
    {
      i1 = npi.c(nbe.a(paramqab.jdField_a_of_type_Qeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo));
      if (i1 != 1) {
        break label84;
      }
      paramqab = paramqab.jdField_d_of_type_AndroidViewView;
      localObject = (LinearLayout.LayoutParams)paramqab.getLayoutParams();
      if (localObject != null)
      {
        ((LinearLayout.LayoutParams)localObject).weight = 2.0F;
        paramqab.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
    label84:
    do
    {
      do
      {
        return;
      } while (i1 != 2);
      localObject = paramqab.jdField_e_of_type_AndroidViewView;
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((View)localObject).getLayoutParams();
      if (localLayoutParams != null)
      {
        localLayoutParams.weight = 0.0F;
        ((View)localObject).setLayoutParams(localLayoutParams);
      }
      paramqab = paramqab.jdField_f_of_type_AndroidViewView;
      localObject = (LinearLayout.LayoutParams)paramqab.getLayoutParams();
    } while (localObject == null);
    ((LinearLayout.LayoutParams)localObject).weight = 0.0F;
    paramqab.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  private void a(qab paramqab, VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo, int paramInt, View[] paramArrayOfView1, View[] paramArrayOfView2)
  {
    int i1 = 8;
    int i2 = 0;
    if (paramVideoInfo.jdField_c_of_type_Boolean)
    {
      if ((!AdvertisementInfo.isAppAdvertisementInfo(paramAdvertisementInfo)) || (!npi.d(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo))) {
        break label318;
      }
      if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager.a(paramVideoInfo)) {
        break label130;
      }
      rvb.b(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, true, null);
      if (paramInt == nbe.Y)
      {
        paramqab = nbe.a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
        nbe.a(new nmv().a(this.jdField_a_of_type_AndroidContentContext).a(nbe.jdField_a_of_type_Int).b(nbe.Y).a(paramqab).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).d(nbe.aK).a());
      }
    }
    else
    {
      return;
    }
    a(paramVideoInfo, nbe.as);
    return;
    label130:
    npj.a(paramAdvertisementInfo, 0, null);
    int i3 = paramArrayOfView1.length;
    i1 = 0;
    while (i1 < i3)
    {
      paramArrayOfView1[i1].setVisibility(0);
      i1 += 1;
    }
    paramqab.jdField_a_of_type_Boolean = true;
    i3 = paramArrayOfView2.length;
    i1 = i2;
    while (i1 < i3)
    {
      paramArrayOfView2[i1].setVisibility(8);
      i1 += 1;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager.f();
    if (paramInt == nbe.Y)
    {
      nbe.a(new nmv().a(this.jdField_a_of_type_AndroidContentContext).a(nbe.jdField_a_of_type_Int).b(nbe.ak).a(paramAdvertisementInfo).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).d(nbe.aK).a());
      return;
    }
    nbe.a(new nmv().a(this.jdField_a_of_type_AndroidContentContext).a(nbe.jdField_a_of_type_Int).b(nbe.ak).a(paramAdvertisementInfo).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).a());
    return;
    label318:
    if (paramInt == nbe.Y)
    {
      paramInt = 38;
      paramqab = nbe.a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
      nbe.a(new nmv().a(this.jdField_a_of_type_AndroidContentContext).a(nbe.jdField_a_of_type_Int).b(nbe.Y).a(paramqab).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).d(nbe.aK).a());
    }
    for (;;)
    {
      if (paramAdvertisementInfo != null) {
        paramAdvertisementInfo.setClickPos(paramInt);
      }
      paramqab = new nmr();
      paramqab.jdField_c_of_type_Boolean = true;
      rvb.b(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, true, paramqab);
      return;
      paramInt = i1;
      if (this.i) {
        paramInt = 13;
      }
      a(paramVideoInfo, nbe.as);
    }
  }
  
  private void a(qab paramqab, boolean paramBoolean1, boolean paramBoolean2, View paramView1, View paramView2, TextView paramTextView1, Drawable paramDrawable, View paramView3, TextView paramTextView2)
  {
    if (paramView1 != null) {
      paramView1.setVisibility(8);
    }
    if (paramBoolean2)
    {
      paramView2.setVisibility(0);
      paramView2.getParent().requestDisallowInterceptTouchEvent(true);
      paramView2.setOnClickListener(this);
      paramView2.setTag(paramqab);
      if ((paramTextView1 == null) || (paramqab.jdField_a_of_type_Qeq == null)) {
        break label123;
      }
      paramqab = a(paramqab.jdField_a_of_type_Qeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramTextView1.setText(paramqab);
    }
    for (;;)
    {
      if (paramBoolean1) {
        paramView2.setBackgroundDrawable(paramDrawable);
      }
      for (this.i = true;; this.i = false)
      {
        a(paramBoolean1, paramView3, paramTextView2, paramqab);
        return;
        paramView2.setBackgroundDrawable(null);
      }
      label123:
      paramqab = null;
    }
  }
  
  private void a(qae paramqae, VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo, int paramInt, View paramView, View... paramVarArgs)
  {
    int i1 = 0;
    if ((paramVideoInfo.jdField_c_of_type_Boolean) && (AdvertisementInfo.isAppAdvertisementInfo(paramAdvertisementInfo)) && (npi.d(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo)))
    {
      if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager.a(paramVideoInfo)) {
        break label118;
      }
      rvb.b(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, true, null);
      if (paramInt == nbe.Y) {
        nbe.a(new nmv().a(this.jdField_a_of_type_AndroidContentContext).a(nbe.jdField_a_of_type_Int).b(nbe.Y).a(paramAdvertisementInfo).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).d(nbe.aK).a());
      }
    }
    else
    {
      return;
    }
    a(paramVideoInfo, nbe.as);
    return;
    label118:
    paramView.setVisibility(0);
    ((qab)paramqae).jdField_a_of_type_Boolean = true;
    paramInt = i1;
    while (paramInt < paramVarArgs.length)
    {
      paramVarArgs[paramInt].setVisibility(8);
      paramInt += 1;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager.f();
  }
  
  private void a(qag paramqag)
  {
    if ((this.jdField_a_of_type_Qag != null) && (this.jdField_a_of_type_Qag.jdField_a_of_type_Qeq != null) && (this.jdField_a_of_type_Qag.jdField_a_of_type_Qeq.jdField_a_of_type_Qhw != null))
    {
      int i1 = this.jdField_a_of_type_Qag.jdField_a_of_type_Qeq.jdField_a_of_type_Qhw.e();
      if ((i1 != 0) && (i1 != 1) && (i1 != 2) && (this.jdField_a_of_type_Qag.jdField_c_of_type_Int == paramqag.jdField_c_of_type_Int - 1) && (badq.h(this.jdField_a_of_type_AndroidAppActivity)) && (bgmq.s(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.b(paramqag.jdField_a_of_type_Qeq);
      }
    }
  }
  
  private void a(qag paramqag, VideoInfo paramVideoInfo)
  {
    qeq localqeq2 = paramqag.jdField_a_of_type_Qeq;
    qeq localqeq1 = localqeq2;
    if (localqeq2 == null)
    {
      localqeq1 = new qeq();
      localqeq1.jdField_a_of_type_Pxw = paramqag.jdField_a_of_type_Qhf;
      localqeq1.jdField_a_of_type_AndroidOsBundle.putInt("jump_from_scene", this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("PERFORMANCE_REPORT_VIDEO_FEEDS_JUMP_FROM", 0));
    }
    localqeq1.jdField_a_of_type_ComTencentBizPubaccountVideoInfo = paramVideoInfo;
    localqeq1.jdField_a_of_type_Int = paramVideoInfo.c(this.jdField_a_of_type_AndroidAppActivity);
    localqeq1.jdField_a_of_type_AndroidViewViewGroup = paramqag.jdField_b_of_type_AndroidViewViewGroup;
    localqeq1.jdField_b_of_type_Int = paramqag.jdField_c_of_type_Int;
    localqeq1.jdField_a_of_type_Boolean = false;
    localqeq1.jdField_a_of_type_AndroidOsBundle.putInt("video_feeds_index", paramqag.jdField_c_of_type_Int);
    localqeq1.jdField_a_of_type_Long = 0L;
    localqeq1.jdField_b_of_type_Boolean = true;
    if (paramVideoInfo.jdField_c_of_type_Boolean)
    {
      if (!paramVideoInfo.a(this.jdField_a_of_type_AndroidAppActivity)) {
        break label161;
      }
      localqeq1.jdField_a_of_type_AndroidOsBundle.putInt("ad_origin", nbe.P);
    }
    for (;;)
    {
      paramqag.jdField_a_of_type_Qhf.jdField_a_of_type_Boolean = true;
      paramqag.jdField_a_of_type_Qeq = localqeq1;
      return;
      label161:
      localqeq1.jdField_a_of_type_AndroidOsBundle.putInt("ad_origin", nbe.N);
    }
  }
  
  private void a(qag paramqag1, qag paramqag2)
  {
    VideoInfo localVideoInfo;
    qmv localqmv1;
    if ((paramqag2 != null) && (paramqag2.jdField_c_of_type_Int == paramqag1.jdField_c_of_type_Int))
    {
      localVideoInfo = paramqag1.jdField_a_of_type_Qeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
      localqmv1 = new qmv(paramqag1.jdField_a_of_type_Qeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
      localqmv1.h(localVideoInfo.jdField_g_of_type_JavaLangString).l(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).m(paramqag1.jdField_b_of_type_Int).l(paramqag1.jdField_c_of_type_Int);
      if (paramqag1.jdField_b_of_type_Int != paramqag2.jdField_b_of_type_Int + 1) {
        break label124;
      }
      ndn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localVideoInfo.jdField_j_of_type_JavaLangString, "0X8009952", "0X8009952", 0, 0, "", "", "", localqmv1.a().a(), false);
    }
    label124:
    while (paramqag1.jdField_b_of_type_Int != paramqag2.jdField_b_of_type_Int - 1) {
      return;
    }
    qmv localqmv2 = localqmv1.o(0);
    if (paramqag2.jdField_a_of_type_Qeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) {}
    for (paramqag1 = paramqag2.jdField_a_of_type_Qeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_g_of_type_JavaLangString;; paramqag1 = "")
    {
      localqmv2.h(paramqag1);
      ndn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localVideoInfo.jdField_j_of_type_JavaLangString, "0X8009953", "0X8009953", 0, 0, "", "", "", localqmv1.a().a(), false);
      return;
    }
  }
  
  private void a(qag paramqag1, qag paramqag2, boolean paramBoolean)
  {
    Activity localActivity = this.jdField_a_of_type_AndroidAppActivity;
    VideoInfo localVideoInfo = paramqag1.jdField_a_of_type_Qeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
    int i1 = paramqag1.jdField_b_of_type_Int;
    int i2 = paramqag1.jdField_c_of_type_Int;
    int i3 = paramqag1.jdField_a_of_type_Int;
    ThreadManager.post(new VideoFeedsAdapter.4(this, localVideoInfo, localActivity, i2, paramqag1.jdField_b_of_type_Boolean, i1, paramBoolean, i3, paramqag1, paramqag2), 1, null, true);
  }
  
  private void a(qaj paramqaj)
  {
    if (this.jdField_b_of_type_Int == 1)
    {
      paramqaj.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      paramqaj.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      paramqaj.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramqaj.jdField_a_of_type_AndroidWidgetTextView.setText(a(1));
    }
    do
    {
      return;
      if (this.jdField_b_of_type_Int == 2)
      {
        paramqaj.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
        paramqaj.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        paramqaj.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        paramqaj.jdField_a_of_type_AndroidWidgetTextView.setText(a(2));
        return;
      }
    } while (this.jdField_b_of_type_Int != 3);
    if (paramqaj.jdField_a_of_type_Int == 6)
    {
      paramqaj.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      paramqaj.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      paramqaj.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramqaj.jdField_a_of_type_AndroidWidgetTextView.setText(a(1));
      return;
    }
    paramqaj.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
    paramqaj.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    paramqaj.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  private void a(qaq paramqaq, VideoInfo paramVideoInfo)
  {
    if (paramqaq.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView != null) {
      paramqaq.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView.a();
    }
    if (paramqaq.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView != null) {
      paramqaq.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView.a();
    }
    if (paramqaq.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView != null) {
      paramqaq.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView.a();
    }
    if ((paramVideoInfo.jdField_g_of_type_Int == 1) || (paramVideoInfo.jdField_g_of_type_Int == 2))
    {
      if (paramVideoInfo.jdField_g_of_type_Int != 1) {
        break label486;
      }
      if (bady.a(BaseApplicationImpl.getContext(), paramVideoInfo.B)) {
        break label419;
      }
      if ((paramqaq.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView != null) && (!TextUtils.isEmpty(paramVideoInfo.m)) && (!TextUtils.isEmpty(paramVideoInfo.n))) {
        paramqaq.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView.setImageUrl(paramVideoInfo, paramVideoInfo.q, this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0), this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("key_source", 0), this.jdField_a_of_type_Boolean, this, paramVideoInfo.h, paramVideoInfo.jdField_g_of_type_Int, paramVideoInfo.m, paramVideoInfo.n, 28, paramVideoInfo.p, "VideoPlay_ContentMix", paramVideoInfo.jdField_c_of_type_JavaLangString, paramVideoInfo.C, paramVideoInfo.i, paramVideoInfo.jdField_j_of_type_Int);
      }
      if ((paramqaq.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView != null) && (!TextUtils.isEmpty(paramVideoInfo.jdField_r_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramVideoInfo.s))) {
        paramqaq.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView.setImageUrl(paramVideoInfo, paramVideoInfo.v, this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0), this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("key_source", 0), this.jdField_a_of_type_Boolean, this, paramVideoInfo.h, paramVideoInfo.jdField_g_of_type_Int, paramVideoInfo.jdField_r_of_type_JavaLangString, paramVideoInfo.s, 29, paramVideoInfo.jdField_u_of_type_JavaLangString, "VideoPlay_RedEnvelope", paramVideoInfo.jdField_c_of_type_JavaLangString, paramVideoInfo.C, paramVideoInfo.i, paramVideoInfo.jdField_j_of_type_Int);
      }
      if ((paramqaq.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView != null) && (!TextUtils.isEmpty(paramVideoInfo.w)) && (!TextUtils.isEmpty(paramVideoInfo.x))) {
        paramqaq.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView.setImageUrl(paramVideoInfo, paramVideoInfo.A, this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0), this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("key_source", 0), this.jdField_a_of_type_Boolean, this, paramVideoInfo.h, paramVideoInfo.jdField_g_of_type_Int, paramVideoInfo.w, paramVideoInfo.x, 30, paramVideoInfo.z, "VideoPlay_Shooting", paramVideoInfo.jdField_c_of_type_JavaLangString, paramVideoInfo.C, paramVideoInfo.i, paramVideoInfo.jdField_j_of_type_Int);
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
      if (!bady.a(BaseApplicationImpl.getContext(), paramVideoInfo.B)) {
        break;
      }
      if ((paramqaq.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView != null) && (!TextUtils.isEmpty(paramVideoInfo.m)) && (!TextUtils.isEmpty(paramVideoInfo.o))) {
        paramqaq.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView.setImageUrl(paramVideoInfo, paramVideoInfo.q, this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0), this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("key_source", 0), this.jdField_a_of_type_Boolean, this, paramVideoInfo.h, paramVideoInfo.jdField_g_of_type_Int, paramVideoInfo.m, paramVideoInfo.o, 28, paramVideoInfo.p, "VideoPlay_ContentMix", paramVideoInfo.jdField_c_of_type_JavaLangString, paramVideoInfo.C, paramVideoInfo.i, paramVideoInfo.jdField_j_of_type_Int);
      }
      if ((paramqaq.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView != null) && (!TextUtils.isEmpty(paramVideoInfo.jdField_r_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramVideoInfo.t))) {
        paramqaq.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView.setImageUrl(paramVideoInfo, paramVideoInfo.v, this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0), this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("key_source", 0), this.jdField_a_of_type_Boolean, this, paramVideoInfo.h, paramVideoInfo.jdField_g_of_type_Int, paramVideoInfo.jdField_r_of_type_JavaLangString, paramVideoInfo.t, 29, paramVideoInfo.jdField_u_of_type_JavaLangString, "VideoPlay_RedEnvelope", paramVideoInfo.jdField_c_of_type_JavaLangString, paramVideoInfo.C, paramVideoInfo.i, paramVideoInfo.jdField_j_of_type_Int);
      }
    } while ((paramqaq.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView == null) || (TextUtils.isEmpty(paramVideoInfo.w)) || (TextUtils.isEmpty(paramVideoInfo.y)));
    paramqaq.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView.setImageUrl(paramVideoInfo, paramVideoInfo.A, this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0), this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("key_source", 0), this.jdField_a_of_type_Boolean, this, paramVideoInfo.h, paramVideoInfo.jdField_g_of_type_Int, paramVideoInfo.w, paramVideoInfo.y, 30, paramVideoInfo.z, "VideoPlay_Shooting", paramVideoInfo.jdField_c_of_type_JavaLangString, paramVideoInfo.C, paramVideoInfo.i, paramVideoInfo.jdField_j_of_type_Int);
    return;
    if (paramVideoInfo.p.contains("?"))
    {
      VideoFeedsOptView.a(paramVideoInfo.p + "&acttype=109");
      return;
    }
    VideoFeedsOptView.a(paramVideoInfo.p + "?acttype=109");
  }
  
  private void a(qaq paramqaq, boolean paramBoolean, long paramLong, int paramInt)
  {
    if (paramBoolean)
    {
      if (this.jdField_b_of_type_Long != 0L) {
        ThreadManager.excute(new VideoFeedsAdapter.1(this, paramLong), 16, null, true);
      }
      if ((paramqaq.jdField_a_of_type_Qeq != null) && (paramqaq.jdField_a_of_type_Qeq.jdField_a_of_type_Pqb != null))
      {
        paramqaq.jdField_a_of_type_Qeq.jdField_a_of_type_Pqb.n = paramLong;
        paramqaq.jdField_a_of_type_Qeq.jdField_a_of_type_Pqb.jdField_r_of_type_Int = obz.a(paramInt, paramqaq.jdField_c_of_type_Int, false);
      }
      if ((paramqaq.jdField_a_of_type_Qeq != null) && (paramqaq.jdField_a_of_type_Qeq.jdField_a_of_type_Pqa != null)) {
        paramqaq.jdField_a_of_type_Qeq.jdField_a_of_type_Pqa.jdField_a_of_type_Boolean = true;
      }
    }
  }
  
  private void a(boolean paramBoolean, View paramView, TextView paramTextView, String paramString)
  {
    if ((paramView == null) || (paramTextView == null)) {}
    do
    {
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
  
  private void a(boolean paramBoolean, qab paramqab)
  {
    if (!a(paramqab)) {
      return;
    }
    TextView localTextView1 = paramqab.jdField_d_of_type_AndroidWidgetTextView;
    View localView = paramqab.jdField_a_of_type_AndroidViewView;
    TextView localTextView2 = paramqab.jdField_e_of_type_AndroidWidgetTextView;
    if (localView != null) {}
    for (boolean bool = true;; bool = false)
    {
      GradientDrawable localGradientDrawable = new GradientDrawable();
      localGradientDrawable.setColor(Color.parseColor("#FF12B7F6"));
      localGradientDrawable.setCornerRadius(aciy.a(4.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
      a(paramqab, paramBoolean, bool, localTextView1, localView, localTextView2, localGradientDrawable, paramqab.jdField_b_of_type_AndroidViewView, paramqab.jdField_f_of_type_AndroidWidgetTextView);
      return;
    }
  }
  
  private void a(boolean paramBoolean, qaq paramqaq)
  {
    if (!qab.class.isInstance(paramqaq)) {
      return;
    }
    paramqaq = (qab)paramqaq;
    if ((paramqaq.jdField_a_of_type_Qeq != null) && (paramqaq.jdField_a_of_type_Qeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (npi.c(paramqaq.jdField_a_of_type_Qeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo)) && (!paramqaq.jdField_a_of_type_Boolean)) {
      a(paramBoolean, paramqaq);
    }
    for (;;)
    {
      if (paramqaq.c != null)
      {
        paramqaq.c.setOnClickListener(this);
        paramqaq.c.getParent().requestDisallowInterceptTouchEvent(true);
        paramqaq.c.setTag(paramqaq);
      }
      if (paramqaq.r != null)
      {
        paramqaq.r.setOnClickListener(this);
        paramqaq.r.getParent().requestDisallowInterceptTouchEvent(true);
        paramqaq.r.setTag(paramqaq);
      }
      if ((paramqaq.jdField_b_of_type_AndroidWidgetSeekBar != null) && (!paramqaq.jdField_a_of_type_Boolean)) {
        paramqaq.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(0);
      }
      if ((paramqaq.c != null) && (!paramqaq.jdField_a_of_type_Boolean)) {
        paramqaq.c.setVisibility(8);
      }
      a(paramqaq);
      return;
      b(paramBoolean, paramqaq);
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
      if ((i3 >= 0) && ((paramList instanceof qaq)) && (((qaq)paramList).jdField_b_of_type_Int == i3))
      {
        ((qaq)paramList).jdField_a_of_type_Pxs.b(paramVideoInfo);
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
      if ((localViewHolder instanceof qaq))
      {
        VideoInfo localVideoInfo = (VideoInfo)paramList.get(((qaq)localViewHolder).jdField_b_of_type_Int);
        if (paramString.equals(localVideoInfo.jdField_j_of_type_JavaLangString)) {
          ((qaq)localViewHolder).jdField_a_of_type_Pxs.b(localVideoInfo);
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
      paramVideoAdInfo = nbe.a(paramVideoAdInfo);
    } while ((TextUtils.isEmpty(paramVideoAdInfo.mPopFormH5Url)) || (!npi.d(paramVideoAdInfo)));
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
  
  private boolean a(qab paramqab)
  {
    boolean bool3 = true;
    boolean bool1 = true;
    boolean bool2 = bool1;
    if (paramqab != null)
    {
      bool2 = bool1;
      if (paramqab.jdField_a_of_type_Qeq != null)
      {
        if (paramqab.jdField_a_of_type_Qeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) {
          break label34;
        }
        bool2 = bool1;
      }
    }
    label34:
    do
    {
      return bool2;
      Object localObject = paramqab.jdField_a_of_type_Qeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
      bool1 = bool3;
      if (((VideoInfo)localObject).jdField_c_of_type_Boolean)
      {
        localObject = nbe.a(((VideoInfo)localObject).jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
        bool1 = bool3;
        if (localObject != null)
        {
          bool1 = bool3;
          if (!((AdvertisementInfo)localObject).mShowAdButton)
          {
            if (paramqab.jdField_d_of_type_AndroidWidgetTextView != null) {
              paramqab.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
            }
            if (paramqab.jdField_a_of_type_AndroidViewView != null) {
              paramqab.jdField_a_of_type_AndroidViewView.setVisibility(8);
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
  
  private boolean a(qaq paramqaq)
  {
    boolean bool = true;
    paramqaq.jdField_a_of_type_Qhf.jdField_a_of_type_Boolean = false;
    Bundle localBundle;
    int i2;
    int i1;
    if ((paramqaq.jdField_c_of_type_Int == this.jdField_e_of_type_Int) && (this.jdField_a_of_type_AndroidContentContext != null) && (paramqaq.jdField_a_of_type_Qeq != null) && (paramqaq.jdField_a_of_type_Qeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null))
    {
      localBundle = this.jdField_a_of_type_AndroidAppActivity.getIntent().getExtras();
      i2 = localBundle.getInt("VIDEO_FROM_TYPE", 0);
      if (!badq.b(this.jdField_a_of_type_AndroidContentContext))
      {
        i1 = 1;
        if (i2 != 27) {
          break label121;
        }
        paramqaq = paramqaq.jdField_a_of_type_Qhf;
        if ((i1 != 0) || (this.jdField_f_of_type_Boolean)) {
          break label115;
        }
        label102:
        paramqaq.jdField_a_of_type_Boolean = bool;
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
        if ((!badq.b(this.jdField_a_of_type_AndroidContentContext)) || (this.jdField_f_of_type_Boolean))
        {
          paramqaq.jdField_a_of_type_Qhf.jdField_a_of_type_Boolean = false;
          return true;
        }
        i1 = localBundle.getInt("VIDEO_PLAY_STATUS", 0);
        if (((2 == i2) || (6 == i2) || (5 == i2)) && (3 == i1))
        {
          paramqaq.jdField_a_of_type_Qhf.jdField_a_of_type_Boolean = false;
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
          paramqaq.jdField_a_of_type_Qhf.jdField_a_of_type_Boolean = true;
          break;
        }
      }
    }
  }
  
  private void b(qab paramqab)
  {
    int i1;
    Object localObject;
    if ((paramqab != null) && (paramqab.jdField_a_of_type_Qeq != null) && (paramqab.jdField_a_of_type_Qeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (paramqab.jdField_a_of_type_Qeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo != null))
    {
      i1 = npi.c(nbe.a(paramqab.jdField_a_of_type_Qeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo));
      if (i1 != 1) {
        break label88;
      }
      paramqab = paramqab.l;
      if (paramqab != null)
      {
        localObject = (LinearLayout.LayoutParams)paramqab.getLayoutParams();
        if (localObject != null)
        {
          ((LinearLayout.LayoutParams)localObject).weight = 2.0F;
          paramqab.setLayoutParams((ViewGroup.LayoutParams)localObject);
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
        localObject = paramqab.jdField_m_of_type_AndroidViewView;
        if (localObject != null)
        {
          LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((View)localObject).getLayoutParams();
          if (localLayoutParams != null)
          {
            localLayoutParams.weight = 0.0F;
            ((View)localObject).setLayoutParams(localLayoutParams);
          }
        }
        paramqab = paramqab.n;
      } while (paramqab == null);
      localObject = (LinearLayout.LayoutParams)paramqab.getLayoutParams();
    } while (localObject == null);
    ((LinearLayout.LayoutParams)localObject).weight = 0.0F;
    paramqab.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  private void b(qag paramqag)
  {
    paramqag = paramqag.jdField_a_of_type_Qeq;
    if ((paramqag != null) && ((paramqag.jdField_a_of_type_Boolean) || ((paramqag.jdField_a_of_type_Qhw != null) && (paramqag.jdField_a_of_type_Qhw.e() != 0))))
    {
      paramqag.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.c(paramqag);
    }
  }
  
  private void b(boolean paramBoolean, qab paramqab)
  {
    if (!a(paramqab)) {
      return;
    }
    View localView = paramqab.jdField_a_of_type_AndroidViewView;
    TextView localTextView = paramqab.jdField_d_of_type_AndroidWidgetTextView;
    if ((localTextView != null) && (!paramqab.jdField_a_of_type_Boolean)) {}
    for (boolean bool = true;; bool = false)
    {
      ColorDrawable localColorDrawable = new ColorDrawable();
      localColorDrawable.setColor(Color.parseColor("#FF12B7F6"));
      a(paramqab, paramBoolean, bool, localView, localTextView, localTextView, localColorDrawable, paramqab.jdField_b_of_type_AndroidViewView, paramqab.jdField_f_of_type_AndroidWidgetTextView);
      return;
    }
  }
  
  private void c(qab paramqab)
  {
    if ((paramqab == null) || (paramqab.c == null) || (paramqab.g == null) || (paramqab.o == null) || (this.jdField_a_of_type_AndroidContentContext == null) || (this.jdField_a_of_type_AndroidContentContext.getResources() == null)) {
      return;
    }
    View localView = paramqab.c;
    Object localObject = new GradientDrawable();
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
    TextView localTextView = paramqab.g;
    RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)localTextView.getLayoutParams();
    if (paramqab.o.getVisibility() == 0)
    {
      ((GradientDrawable)localObject).setCornerRadius(aciy.a(6.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
      localLayoutParams.height = aciy.a(31.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      localLayoutParams.topMargin = aciy.a(8.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      localLayoutParams.bottomMargin = aciy.a(10.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      localLayoutParams.leftMargin = aciy.a(15.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      localLayoutParams.rightMargin = aciy.a(15.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      if (localLayoutParams1 != null)
      {
        localLayoutParams1.addRule(13);
        localTextView.setLayoutParams(localLayoutParams1);
      }
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130842084);
    }
    for (;;)
    {
      localView.setLayoutParams(localLayoutParams);
      if ((paramqab.jdField_a_of_type_AndroidWidgetProgressBar == null) || (localObject == null)) {
        break;
      }
      paramqab.jdField_a_of_type_AndroidWidgetProgressBar.setProgressDrawable((Drawable)localObject);
      return;
      localLayoutParams.height = aciy.a(42.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      localLayoutParams.topMargin = aciy.a(15.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      localLayoutParams.bottomMargin = aciy.a(0.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      localLayoutParams.leftMargin = aciy.a(0.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      localLayoutParams.rightMargin = aciy.a(0.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      ((GradientDrawable)localObject).setCornerRadius(aciy.a(0.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130842082);
      if (localLayoutParams1 != null)
      {
        localLayoutParams1.addRule(15);
        localTextView.setLayoutParams(localLayoutParams1);
      }
    }
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
        break label280;
      }
      i1 = 0;
      localJSONObject.put("type", i1);
      if (paramVideoInfo.N == null) {
        break label285;
      }
      str1 = paramVideoInfo.N;
      label60:
      localJSONObject.put("video_report_info", str1);
      if (!paramVideoInfo.jdField_l_of_type_Boolean) {
        break label103;
      }
      if (this.jdField_a_of_type_Qea == null) {
        break label333;
      }
      i1 = this.jdField_a_of_type_Qea.a();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str1;
        label103:
        String str2;
        label161:
        label194:
        label217:
        String str4;
        String str3;
        label280:
        label285:
        label301:
        label309:
        label315:
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
    if (this.jdField_a_of_type_Qdt != null)
    {
      if (!this.jdField_a_of_type_Qdt.a()) {
        break label338;
      }
      i1 = i2;
      localJSONObject.put("is_display_download_bar", i1);
      if (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LikeActionDownloadBar != null)
      {
        str1 = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LikeActionDownloadBar.jdField_c_of_type_JavaLangString;
        localJSONObject.put("common_data", str1);
        localJSONObject.put("video_type", 0);
        if (!this.jdField_a_of_type_Boolean) {
          break label301;
        }
        str1 = "0X800929C";
        if ((paramVideoInfo.jdField_a_of_type_Int != 0) || (paramVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null)) {
          break label309;
        }
        str2 = paramVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5();
        str4 = paramVideoInfo.jdField_j_of_type_JavaLangString;
        if (TextUtils.isEmpty(paramVideoInfo.jdField_g_of_type_JavaLangString)) {
          break label315;
        }
      }
      for (str3 = paramVideoInfo.jdField_g_of_type_JavaLangString;; str3 = "0")
      {
        ndn.a(null, str4, str1, str1, 0, 0, "0", "0", str3, new.a(str2, paramVideoInfo.jdField_j_of_type_JavaLangString, paramVideoInfo.jdField_a_of_type_JavaLangString, paramVideoInfo.jdField_g_of_type_JavaLangString, localJSONObject), false);
        return;
        i1 = 1;
        break;
        str1 = "";
        break label60;
        str1 = "";
        break label161;
        str1 = "0X80091A9";
        break label194;
        str2 = null;
        break label217;
      }
    }
  }
  
  private void f(VideoInfo paramVideoInfo)
  {
    int i1 = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_a_of_type_Int;
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "innerSubscribeColume() columeid=" + i1);
    }
    qcn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i1);
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
        localObject = new qmv("", "", paramVideoInfo.jdField_a_of_type_JavaLangString, paramVideoInfo.jdField_g_of_type_JavaLangString).t(((VideoInfo.ChannelInfo)localObject).jdField_a_of_type_Int).u(qcn.a((VideoInfo.ChannelInfo)localObject)).a(paramVideoInfo.N).a().a();
        if (this.jdField_a_of_type_Boolean) {
          ndn.a(null, "", "0X8009330", "0X8009330", 0, 0, "3", "", "", (String)localObject, false);
        }
        for (;;)
        {
          i1 += 1;
          break;
          ndn.a(null, "", "0X80092F8", "0X80092F8", 0, 0, "3", "", "", (String)localObject, false);
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
    this.jdField_a_of_type_AndroidOsHandler.post(new VideoFeedsAdapter.12(this, paramBoolean));
  }
  
  private void h()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(2, null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.b(false);
  }
  
  private void i()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr = new VideoPreDownloadMgr(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a = new qii(qii.jdField_c_of_type_Int, qii.jdField_f_of_type_Int);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a(new pzt(this));
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
  
  public qae a(ViewGroup paramViewGroup, int paramInt)
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
    case 0: 
    case 1: 
    case 2: 
      while (paramViewGroup != null)
      {
        paramViewGroup.jdField_a_of_type_Pxs = ((pxs)localObject2);
        paramViewGroup.jdField_a_of_type_Qhf = new qhf(paramViewGroup, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager, this.jdField_f_of_type_Boolean);
        return paramViewGroup;
        paramViewGroup = new qan(((LayoutInflater)localObject1).inflate(2131494495, paramViewGroup, false), this.jdField_a_of_type_AndroidAppActivity);
        localObject2 = new qam(this, (qan)paramViewGroup);
        localObject1 = null;
        continue;
        paramViewGroup = new qal(((LayoutInflater)localObject1).inflate(2131494491, paramViewGroup, false), this.jdField_a_of_type_AndroidAppActivity);
        localObject2 = new qak(this, (qal)paramViewGroup);
        localObject1 = null;
        continue;
        localObject1 = qft.a(2131494497, true, new ViewGroup.LayoutParams(-1, -1));
        paramViewGroup = (qap)((View)localObject1).getTag();
        if (paramViewGroup != null) {
          break label403;
        }
        paramViewGroup = new qap((View)localObject1, this.jdField_a_of_type_AndroidAppActivity);
      }
    }
    label403:
    for (;;)
    {
      localObject2 = new qao(this, (qap)paramViewGroup);
      localObject1 = null;
      break;
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131494489, paramViewGroup, false);
      ((LayoutInflater)localObject1).inflate(2131494509, (ViewGroup)paramViewGroup.findViewById(2131298978), true);
      ((LayoutInflater)localObject1).inflate(2131494506, (ViewGroup)paramViewGroup.findViewById(2131298976), true);
      ((LayoutInflater)localObject1).inflate(2131494507, (ViewGroup)paramViewGroup.findViewById(2131298974), true);
      paramViewGroup = new qab(paramViewGroup, paramInt, this.jdField_a_of_type_AndroidAppActivity);
      localObject2 = new pzy(this, (qab)paramViewGroup);
      localObject1 = null;
      break;
      localObject2 = qft.a(2131494494, true, new ViewGroup.LayoutParams(-1, -1));
      localObject1 = (qaj)((View)localObject2).getTag();
      paramViewGroup = (ViewGroup)localObject1;
      if (localObject1 == null) {
        paramViewGroup = new qaj((View)localObject2, paramInt);
      }
      this.jdField_a_of_type_Qaj = paramViewGroup;
      localObject2 = null;
      localObject1 = paramViewGroup;
      paramViewGroup = null;
      break;
      return localObject1;
    }
  }
  
  public qca a()
  {
    return this.jdField_a_of_type_Qca;
  }
  
  public qgw a()
  {
    return this.jdField_a_of_type_Qgw;
  }
  
  public void a()
  {
    int i1 = this.jdField_a_of_type_JavaUtilList.size();
    int i2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.c();
    RecyclerView.ViewHolder localViewHolder = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.findViewHolderForLayoutPosition(i1 + i2 - 1);
    if ((localViewHolder instanceof qaj)) {
      a((qaj)localViewHolder);
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
    if ((this.jdField_a_of_type_Qaz != null) && (this.jdField_a_of_type_Qaz.a()) && (this.jdField_a_of_type_Qaz.b()))
    {
      this.jdField_a_of_type_Qaz.h();
      break label34;
    }
    for (;;)
    {
      label34:
      return;
      if (!this.t) {
        continue;
      }
      paramView = (qag)paramView.getTag();
      if (paramView != this.jdField_a_of_type_Qag)
      {
        if (this.jdField_a_of_type_Qag == null) {
          break;
        }
        if ((paramView != null) && (paramView.jdField_c_of_type_Int == this.jdField_a_of_type_Qag.jdField_c_of_type_Int + 1) && (paramView.jdField_c_of_type_Int != getItemCount()))
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.a();
          return;
        }
        if ((paramView == null) || (paramView.jdField_c_of_type_Int != this.jdField_a_of_type_Qag.jdField_c_of_type_Int - 1)) {
          break;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.b();
        return;
      }
      paramView.jdField_a_of_type_Pxs.c();
      JSONObject localJSONObject;
      switch (paramView.jdField_a_of_type_Int)
      {
      case 3: 
      case 4: 
      case 6: 
      default: 
      case 2: 
        if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager == null) || (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.c())) {
          continue;
        }
        localJSONObject = new JSONObject();
      case 5: 
      case 7: 
        try
        {
          localJSONObject.put("channel_id", 409409);
          label221:
          ndn.a(null, null, "0X80091AB", "0X80091AB", 0, 0, "", "", "", new.a(null, null, paramView.jdField_a_of_type_Qeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, paramView.jdField_a_of_type_Qeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_g_of_type_JavaLangString, localJSONObject), false);
          return;
          if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager == null) || (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.c())) {
            continue;
          }
          localJSONObject = new JSONObject();
          try
          {
            localJSONObject.put("channel_id", 409409);
            label307:
            ndn.a(null, null, "0X80091AB", "0X80091AB", 0, 0, "", "", "", new.a(null, null, paramView.jdField_a_of_type_Qeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, paramView.jdField_a_of_type_Qeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_g_of_type_JavaLangString, localJSONObject), false);
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
    paramView = (qaq)paramView.getTag();
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
        } while (!this.r);
        paramView.jdField_a_of_type_Pxs.a(1);
        this.r = false;
        return;
      } while (paramView.d.getVisibility() != 0);
      paramView.jdField_a_of_type_Pxs.a(2);
    } while (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.b());
    this.r = true;
  }
  
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    qaq localqaq = (qaq)paramView.getTag();
    if (localqaq != this.jdField_a_of_type_Qag) {}
    while ((!this.t) || (localqaq == null) || (localqaq.jdField_a_of_type_Qeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == null) || (!(localqaq instanceof qag)) || (TextUtils.isEmpty(localqaq.jdField_a_of_type_Qeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_g_of_type_JavaLangString))) {
      return;
    }
    Object localObject = localqaq.jdField_a_of_type_Qeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
    boolean bool;
    int i1;
    label108:
    JSONObject localJSONObject;
    if (!((VideoInfo)localObject).jdField_l_of_type_Boolean)
    {
      bool = true;
      ((VideoInfo)localObject).jdField_l_of_type_Boolean = true;
      if (!bool) {
        break label551;
      }
      i1 = ((VideoInfo)localObject).jdField_u_of_type_Int + 1;
      ((VideoInfo)localObject).jdField_u_of_type_Int = i1;
      if ((this.jdField_a_of_type_Qdt != null) && ((localqaq instanceof qap)))
      {
        int i2 = 0;
        i1 = i2;
        if (this.jdField_a_of_type_Qgv != null)
        {
          i1 = i2;
          if (this.jdField_a_of_type_Qgv.a()) {
            i1 = 1;
          }
        }
        if (i1 == 0) {
          this.jdField_a_of_type_Qdt.a((VideoInfo)localObject, (qap)localqaq);
        }
      }
      localqaq.jdField_a_of_type_Pxs.a(paramInt1, paramInt2, bool);
      if (bool)
      {
        if (this.jdField_a_of_type_Qad != null) {
          this.jdField_a_of_type_Qad.a((VideoInfo)localObject, ((VideoInfo)localObject).jdField_l_of_type_Boolean);
        }
        e((VideoInfo)localObject);
      }
      if (this.jdField_a_of_type_Qfk != null) {
        this.jdField_a_of_type_Qfk.a(3, (VideoInfo)localObject, 0L);
      }
      localJSONObject = new JSONObject();
      if ((localqaq.jdField_a_of_type_Qeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int != 0) || (localqaq.jdField_a_of_type_Qeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null)) {
        break label561;
      }
      paramView = localqaq.jdField_a_of_type_Qeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5();
    }
    try
    {
      label298:
      localJSONObject.put("channel_id", 409409);
      localJSONObject.put("rowkey", localqaq.jdField_a_of_type_Qeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_g_of_type_JavaLangString);
      if (this.jdField_a_of_type_Qea == null) {
        break label566;
      }
      paramInt1 = this.jdField_a_of_type_Qea.a();
      label345:
      localJSONObject.put("style", paramInt1);
      localJSONObject.put("algorithm_id", ((VideoInfo)localObject).f);
      paramInt1 = 0;
      if (this.jdField_a_of_type_Qdt != null)
      {
        if (!this.jdField_a_of_type_Qdt.a()) {
          break label571;
        }
        paramInt1 = 1;
      }
      label390:
      localJSONObject.put("is_display_download_bar", paramInt1);
      if (((VideoInfo)localObject).jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LikeActionDownloadBar == null) {
        break label576;
      }
      localObject = ((VideoInfo)localObject).jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LikeActionDownloadBar.jdField_c_of_type_JavaLangString;
      label418:
      localJSONObject.put("common_data", localObject);
    }
    catch (Exception localException)
    {
      label429:
      label441:
      String str2;
      String str1;
      label551:
      label561:
      label566:
      label571:
      label576:
      label592:
      break label429;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      localObject = "0X80097F5";
      str2 = localqaq.jdField_a_of_type_Qeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_j_of_type_JavaLangString;
      if (TextUtils.isEmpty(localqaq.jdField_a_of_type_Qeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_g_of_type_JavaLangString)) {
        break label592;
      }
    }
    for (str1 = localqaq.jdField_a_of_type_Qeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_g_of_type_JavaLangString;; str1 = "0")
    {
      ndn.a(null, str2, (String)localObject, (String)localObject, 0, 0, "0", "0", str1, new.a(paramView, localqaq.jdField_a_of_type_Qeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_j_of_type_JavaLangString, localqaq.jdField_a_of_type_Qeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, localqaq.jdField_a_of_type_Qeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_g_of_type_JavaLangString, localJSONObject), false);
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
      localObject = "0X80091AA";
      break label441;
    }
  }
  
  public void a(VideoInfo paramVideoInfo)
  {
    if ((paramVideoInfo != null) && (this.jdField_a_of_type_Qmv != null))
    {
      this.jdField_a_of_type_Qmv.a(paramVideoInfo.N);
      a(paramVideoInfo, this.jdField_a_of_type_Qmv);
      this.jdField_a_of_type_Qmv = null;
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
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(new pzx(this));
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
      if ((paramList instanceof qaq)) {
        ((qaq)paramList).jdField_a_of_type_Pxs.a();
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
  
  public void a(pxk parampxk)
  {
    this.jdField_a_of_type_Pxk = parampxk;
  }
  
  public void a(pys parampys)
  {
    this.jdField_a_of_type_Pys = parampys;
  }
  
  public void a(qad paramqad)
  {
    this.jdField_a_of_type_Qad = paramqad;
  }
  
  public void a(qae paramqae, int paramInt)
  {
    paramqae.jdField_b_of_type_Int = paramInt;
    paramqae.jdField_c_of_type_Int = paramInt;
    paramqae.jdField_b_of_type_Boolean = true;
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size()))
    {
      if (this.jdField_a_of_type_Pys != null)
      {
        VideoInfo localVideoInfo = this.jdField_a_of_type_Pys.b(paramInt);
        if (localVideoInfo != null) {
          this.jdField_a_of_type_JavaUtilList.set(paramInt, localVideoInfo);
        }
      }
      a(paramqae, (VideoInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt));
      return;
    }
    a(paramqae, null);
  }
  
  public void a(qae paramqae, VideoInfo paramVideoInfo)
  {
    int i1 = paramqae.jdField_a_of_type_Int;
    if ((i1 == 3) || (i1 == 6))
    {
      a((qaj)paramqae);
      this.jdField_a_of_type_Qaj = ((qaj)paramqae);
    }
    do
    {
      return;
      paramqae = (qag)paramqae;
      b(paramqae);
      a(paramqae, paramVideoInfo);
      TraceCompat.beginSection("refreshMenuUI");
      paramqae.jdField_a_of_type_Pxs.a(paramVideoInfo);
      TraceCompat.endSection();
      TraceCompat.beginSection("refreshContentUI");
      paramqae.jdField_a_of_type_Pxs.a(paramVideoInfo, this.jdField_d_of_type_Boolean);
      TraceCompat.endSection();
      if ((this.h) && (paramqae == this.jdField_a_of_type_Qag)) {
        paramqae.jdField_a_of_type_Pxs.e(this.h);
      }
    } while (!paramqae.jdField_b_of_type_Boolean);
    a(paramqae);
  }
  
  public void a(qaq paramqaq)
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
    if (this.jdField_a_of_type_Qag != null)
    {
      i1 = this.jdField_a_of_type_Qag.jdField_c_of_type_Int;
      this.jdField_a_of_type_Qag = paramqaq;
      if ((this.jdField_a_of_type_Qag.jdField_c_of_type_Int == 0) && (this.jdField_a_of_type_Qag.jdField_b_of_type_Int == 0))
      {
        paramqaq.jdField_a_of_type_Qeq.jdField_a_of_type_Long = this.jdField_c_of_type_Long;
        this.jdField_c_of_type_Long = 0L;
      }
      if (!this.jdField_g_of_type_Boolean) {
        break label196;
      }
      bool = a(paramqaq);
      this.jdField_g_of_type_Boolean = false;
      l1 = System.currentTimeMillis();
      l2 = this.jdField_b_of_type_Long;
      if (!bool) {
        break label201;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(this.jdField_a_of_type_Qag.jdField_a_of_type_Qeq, false);
    }
    for (;;)
    {
      a(paramqaq, bool, l1 - l2, i1);
      if ((paramqaq.jdField_a_of_type_Qeq != null) && (paramqaq.jdField_a_of_type_Qeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null)) {
        rtr.a(paramqaq.jdField_a_of_type_Qeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_g_of_type_JavaLangString, paramqaq.jdField_a_of_type_Qeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, 0, 0);
      }
      return;
      i1 = -1;
      break;
      label196:
      bool = true;
      break label101;
      label201:
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(paramqaq.jdField_a_of_type_Qeq);
    }
  }
  
  public void a(qaz paramqaz)
  {
    this.jdField_a_of_type_Qaz = paramqaz;
  }
  
  public void a(qca paramqca)
  {
    this.jdField_a_of_type_Qca = paramqca;
  }
  
  public void a(qea paramqea)
  {
    this.jdField_a_of_type_Qea = paramqea;
  }
  
  public void a(qfk paramqfk)
  {
    this.jdField_a_of_type_Qfk = paramqfk;
  }
  
  public void a(qgv paramqgv)
  {
    this.jdField_a_of_type_Qgv = paramqgv;
  }
  
  public void a(qgw paramqgw)
  {
    this.jdField_a_of_type_Qgw = paramqgw;
  }
  
  public void a(qhc paramqhc)
  {
    this.jdField_a_of_type_Qhc = paramqhc;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public boolean a(VideoInfo paramVideoInfo)
  {
    return (this.jdField_a_of_type_Qag == null) || (this.jdField_a_of_type_Qag.jdField_a_of_type_Qeq == null) || (this.jdField_a_of_type_Qag.jdField_a_of_type_Qeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == paramVideoInfo);
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
    paramString = obb.jdField_k_of_type_JavaLangString + baaw.encodeToString(String.valueOf(paramString).getBytes(), 2);
    obz.a(this.jdField_a_of_type_AndroidAppActivity, paramString);
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
      if (((localObject instanceof qaq)) && (((qaq)localObject).jdField_c_of_type_Int == this.jdField_a_of_type_Qag.jdField_c_of_type_Int + 1))
      {
        localObject = ((qaq)localObject).jdField_a_of_type_Qeq;
        if ((localObject != null) && ((((qeq)localObject).jdField_a_of_type_Boolean) || ((((qeq)localObject).jdField_a_of_type_Qhw != null) && (((qeq)localObject).jdField_a_of_type_Qhw.e() != 0))))
        {
          ((qeq)localObject).jdField_a_of_type_Boolean = false;
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.c((qeq)localObject);
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
      noy.c(this.jdField_a_of_type_AndroidAppActivity);
    }
  }
  
  public void c(VideoInfo paramVideoInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo = paramVideoInfo;
  }
  
  public void c(boolean paramBoolean)
  {
    this.s = paramBoolean;
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_AndroidOsHandler != null) && (!this.p))
    {
      if (QLog.isColorLevel()) {
        QLog.d("NativeAdUtils", 2, "rePostMsgForAd");
      }
      this.p = true;
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
      this.jdField_a_of_type_Qag = null;
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
    rvb.a(this);
    if ((this.jdField_a_of_type_Qag != null) && (this.jdField_a_of_type_Qag.jdField_a_of_type_Pxs != null) && ((this.jdField_a_of_type_Qag.jdField_a_of_type_Pxs instanceof pzy))) {
      ((pzy)this.jdField_a_of_type_Qag.jdField_a_of_type_Pxs).e();
    }
    ApngImage.playByTag(28);
    ApngImage.playByTag(29);
    ApngImage.playByTag(30);
    noy.d();
    npj.a(this.jdField_a_of_type_Pxk, this, (qaq)this.jdField_a_of_type_Qag);
  }
  
  public void e(boolean paramBoolean)
  {
    if ((!this.n) && (paramBoolean) && (this.o))
    {
      if ((this.jdField_a_of_type_Qag instanceof qaq)) {
        a((qaq)this.jdField_a_of_type_Qag);
      }
      this.o = false;
    }
    this.n = paramBoolean;
  }
  
  public void f()
  {
    if ((this.jdField_a_of_type_Qmv != null) && (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null)) {
      a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo, this.jdField_a_of_type_Qmv);
    }
    if (this.jdField_a_of_type_Qad != null) {
      this.jdField_a_of_type_Qad = null;
    }
    if (this.jdField_a_of_type_Qag != null) {
      this.jdField_a_of_type_Qag.jdField_b_of_type_ComTencentImageURLImageView = null;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidOsHandler = null;
    this.jdField_a_of_type_Bemi = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    if (this.jdField_a_of_type_Non != null) {
      this.jdField_a_of_type_Non.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler != null) {
      AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    }
    if (this.jdField_a_of_type_Pyy != null)
    {
      this.jdField_a_of_type_Pyy.b();
      this.jdField_a_of_type_Pyy = null;
    }
    if (this.jdField_a_of_type_Qdt != null)
    {
      this.jdField_a_of_type_Qdt.a();
      this.jdField_a_of_type_Qdt = null;
    }
    noy.e();
  }
  
  public void f(boolean paramBoolean) {}
  
  public void g()
  {
    if ((this.jdField_a_of_type_Qag == null) || (this.jdField_a_of_type_Qag.jdField_a_of_type_Qeq == null) || (this.jdField_a_of_type_Qag.jdField_a_of_type_Qeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == null) || (this.jdField_a_of_type_Qag.jdField_a_of_type_Qeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_b_of_type_Long <= 0L)) {
      return;
    }
    Object localObject = this.jdField_a_of_type_Qag.jdField_a_of_type_Qeq;
    localObject = ajjy.a(2131650385);
    this.jdField_a_of_type_Qag.r.setVisibility(0);
    this.jdField_a_of_type_Qag.r.setText((CharSequence)localObject);
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
    if ((this.jdField_a_of_type_Qaj != null) && (this.jdField_a_of_type_Qaj.itemView != null)) {
      return this.jdField_a_of_type_Qaj.itemView.hashCode();
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
    Object localObject3 = (qae)paramView.getTag();
    VideoInfo localVideoInfo;
    if ((localObject3 instanceof qaq))
    {
      localVideoInfo = ((qaq)localObject3).jdField_a_of_type_Qeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
      if ((this.jdField_a_of_type_Qag != null) && (this.jdField_a_of_type_Qag.jdField_a_of_type_Qeq != null) && (localVideoInfo == this.jdField_a_of_type_Qag.jdField_a_of_type_Qeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo)) {}
    }
    label1165:
    label2331:
    label2588:
    label2596:
    label2604:
    label3373:
    for (;;)
    {
      label62:
      return;
      for (;;)
      {
        if (localVideoInfo == null) {
          break label3373;
        }
        Object localObject1 = null;
        long l1;
        if (localVideoInfo.jdField_c_of_type_Boolean)
        {
          localObject1 = npn.a(localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
          this.jdField_a_of_type_Yjs = rvb.a(this.jdField_a_of_type_AndroidAppActivity, (AdvertisementInfo)localObject1, null, 3, false, null);
          if (this.jdField_a_of_type_Yjs != null)
          {
            l1 = SystemClock.elapsedRealtime();
            label118:
            this.jdField_a_of_type_Long = l1;
          }
        }
        else
        {
          if ((localVideoInfo.jdField_a_of_type_Int != 0) || (localVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null)) {
            break label485;
          }
        }
        label485:
        for (Object localObject2 = localVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5();; localObject2 = null)
        {
          localObject4 = new JSONObject();
          switch (paramView.getId())
          {
          default: 
            return;
          case 2131296286: 
            if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView == null) {
              break label62;
            }
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.a();
            return;
            l1 = -2147483648L;
            break label118;
          }
        }
        if (this.jdField_a_of_type_Qfo == null) {
          break;
        }
        this.jdField_a_of_type_Qfo.b();
        return;
        if ((((qae)localObject3).jdField_a_of_type_Int == 2) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a() == 5)) {
          qcn.a(((qaq)localObject3).d, 8, 200);
        }
        if (this.jdField_a_of_type_Qfo == null) {
          break;
        }
        this.jdField_a_of_type_Qfo.b();
        return;
        if ((qzk.a().b()) && (localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null))
        {
          localObject1 = localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.fusionBiuInfo;
          if (localObject1 == null) {
            break;
          }
          qzk.a().a(((qaq)localObject3).h, ((FusionBiuInfo)localObject1).jdField_b_of_type_Boolean);
          if (!((FusionBiuInfo)localObject1).jdField_b_of_type_Boolean) {
            qzk.a().a(paramView.getContext(), obz.a(), 1, 2, localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, 4, localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
          }
          for (;;)
          {
            qzk.a().b(localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, 0, 2, 2);
            return;
            qzk.a().a(paramView.getContext(), ((FusionBiuInfo)localObject1).jdField_a_of_type_Long, obz.a(), localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedType, 4, localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
          }
        }
        if (nsh.a() == 1) {}
        for (boolean bool = true;; bool = false)
        {
          a(localVideoInfo, false, bool);
          if (this.jdField_a_of_type_Qfk == null) {
            break;
          }
          this.jdField_a_of_type_Qfk.a(2, localVideoInfo, 0L);
          return;
        }
        if ((this.jdField_a_of_type_Qaz != null) && (localVideoInfo.a(this.jdField_a_of_type_AndroidAppActivity))) {
          this.jdField_a_of_type_Qaz.h();
        }
        if (localVideoInfo.jdField_c_of_type_Boolean)
        {
          rvb.b(this.jdField_a_of_type_AndroidAppActivity, (AdvertisementInfo)localObject1, null, 3, true, null);
          a(localVideoInfo, 0);
          return;
        }
        if (localVideoInfo.e())
        {
          qcn.a(this.jdField_a_of_type_AndroidAppActivity, localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo);
          localObject1 = new qmv(localVideoInfo).h(localVideoInfo.jdField_g_of_type_JavaLangString).t(localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_a_of_type_Int);
          if (localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo != null) {}
          for (paramView = localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.e;; paramView = "")
          {
            ndn.b(null, "", "0X800A18C", "0X800A18C", 0, 0, "", "", "", ((qmv)localObject1).o(paramView).R(1).a().a(), false);
            return;
          }
        }
        if ((localVideoInfo.O != null) && (!localVideoInfo.O.equals("")))
        {
          obz.a(this.jdField_a_of_type_AndroidAppActivity, localVideoInfo.O);
          return;
        }
        if (localVideoInfo.jdField_a_of_type_Int == 6)
        {
          if (!TextUtils.isEmpty(localVideoInfo.jdField_j_of_type_JavaLangString))
          {
            paramView = obb.jdField_g_of_type_JavaLangString + baaw.encodeToString(localVideoInfo.jdField_j_of_type_JavaLangString.getBytes(), 2);
            obz.a(this.jdField_a_of_type_AndroidAppActivity, paramView);
          }
          localObject1 = new qmv((String)localObject2, localVideoInfo.jdField_j_of_type_JavaLangString, localVideoInfo.jdField_a_of_type_JavaLangString, localVideoInfo.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(), localVideoInfo.a() * 1000L).a(-1).N(0).a().a();
          localObject2 = localVideoInfo.jdField_j_of_type_JavaLangString;
          if (TextUtils.isEmpty(localVideoInfo.jdField_g_of_type_JavaLangString)) {
            break label1165;
          }
        }
        for (paramView = localVideoInfo.jdField_g_of_type_JavaLangString;; paramView = "0")
        {
          ndn.a(null, (String)localObject2, "0X8007410", "0X8007410", 0, 0, "0", "", paramView, (String)localObject1, false);
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
          qcn.a(this.jdField_a_of_type_AndroidAppActivity, localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_c_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo);
          localObject1 = new qmv(localVideoInfo).h(localVideoInfo.jdField_g_of_type_JavaLangString).t(localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_a_of_type_Int);
          if (localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_c_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo != null) {}
          for (paramView = localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_c_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.e;; paramView = "")
          {
            ndn.b(null, "", "0X800A18C", "0X800A18C", 0, 0, "", "", "", ((qmv)localObject1).o(paramView).R(2).N(0).a().a(), false);
            return;
          }
        }
        if (localVideoInfo.jdField_k_of_type_Boolean) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "followPubAccount onClick() puin=" + localVideoInfo.jdField_j_of_type_JavaLangString + ", isFollowed=" + localVideoInfo.jdField_k_of_type_Boolean + ", pname=" + localVideoInfo.jdField_k_of_type_JavaLangString);
        }
        localObject1 = new qmv(null, localVideoInfo.jdField_j_of_type_JavaLangString, localVideoInfo.jdField_a_of_type_JavaLangString, localVideoInfo.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(), localVideoInfo.a() * 1000L).a(localVideoInfo.N).N(0).a().a();
        if (this.jdField_a_of_type_Boolean)
        {
          localObject2 = localVideoInfo.jdField_j_of_type_JavaLangString;
          if (!TextUtils.isEmpty(localVideoInfo.jdField_g_of_type_JavaLangString)) {}
          for (paramView = localVideoInfo.jdField_g_of_type_JavaLangString;; paramView = "0")
          {
            ndn.a(null, (String)localObject2, "0X800929B", "0X800929B", 0, 0, "", "", paramView, (String)localObject1, false);
            a(localVideoInfo.jdField_j_of_type_JavaLangString, localVideoInfo.jdField_b_of_type_Boolean);
            return;
          }
        }
        localObject2 = localVideoInfo.jdField_j_of_type_JavaLangString;
        if (!TextUtils.isEmpty(localVideoInfo.jdField_g_of_type_JavaLangString)) {}
        for (paramView = localVideoInfo.jdField_g_of_type_JavaLangString;; paramView = "0")
        {
          ndn.a(null, (String)localObject2, "0X80078FD", "0X80078FD", 0, 0, "", "", paramView, (String)localObject1, false);
          break;
        }
        if ((!localVideoInfo.jdField_c_of_type_Boolean) || (!(this.jdField_a_of_type_Qag instanceof qab))) {
          break;
        }
        a(paramView, (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(), localVideoInfo);
        return;
        if (!localVideoInfo.jdField_c_of_type_Boolean) {
          break;
        }
        rvb.b(this.jdField_a_of_type_AndroidAppActivity, (AdvertisementInfo)localObject1, null, 3, true, null);
        a(localVideoInfo, 0);
        return;
        if (!localVideoInfo.jdField_c_of_type_Boolean) {
          break;
        }
        npj.a((AdvertisementInfo)localObject1, 1000, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
        rvb.b(this.jdField_a_of_type_AndroidAppActivity, (AdvertisementInfo)localObject1, null, 3, false, null);
        a(localVideoInfo, nbe.ax);
        return;
        if (!localVideoInfo.jdField_c_of_type_Boolean) {
          break;
        }
        npj.a((AdvertisementInfo)localObject1, 2, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
        rvb.b(this.jdField_a_of_type_AndroidAppActivity, (AdvertisementInfo)localObject1, null, 3, false, null);
        a(localVideoInfo, nbe.ap);
        return;
        if (!localVideoInfo.jdField_c_of_type_Boolean) {
          break;
        }
        npj.a((AdvertisementInfo)localObject1, 3, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
        rvb.b(this.jdField_a_of_type_AndroidAppActivity, (AdvertisementInfo)localObject1, null, 3, false, null);
        a(localVideoInfo, nbe.aq);
        return;
        if (!localVideoInfo.jdField_c_of_type_Boolean) {
          break;
        }
        npj.a((AdvertisementInfo)localObject1, 4, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
        rvb.b(this.jdField_a_of_type_AndroidAppActivity, (AdvertisementInfo)localObject1, null, 3, false, null);
        a(localVideoInfo, nbe.ar);
        return;
        if (!(localObject3 instanceof qab)) {
          break;
        }
        if (a(localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo))
        {
          a(localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
          nbe.a(new nmv().a(this.jdField_a_of_type_AndroidContentContext).a(nbe.J).b(nbe.N).a((AdvertisementInfo)localObject1).a());
          return;
        }
        paramView = (qab)localObject3;
        int i1 = 8;
        if (this.i) {
          i1 = 13;
        }
        npj.a((AdvertisementInfo)localObject1, i1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
        c(paramView);
        localObject2 = paramView.c;
        localObject3 = paramView.jdField_d_of_type_AndroidWidgetTextView;
        Object localObject4 = paramView.jdField_a_of_type_AndroidViewView;
        Object localObject5 = paramView.jdField_b_of_type_AndroidWidgetSeekBar;
        a(paramView, localVideoInfo, (AdvertisementInfo)localObject1, -1, new View[] { localObject2 }, new View[] { localObject3, localObject4, localObject5 });
        return;
        if (!(localObject3 instanceof qab)) {
          break;
        }
        if (a(localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo))
        {
          a(localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
          nbe.a(new nmv().a(this.jdField_a_of_type_AndroidContentContext).a(nbe.J).b(nbe.N).a((AdvertisementInfo)localObject1).a());
        }
        while ((this.jdField_a_of_type_Qag != null) && (this.jdField_a_of_type_Qag.jdField_a_of_type_Qeq != null))
        {
          npj.a(this.jdField_a_of_type_Qag.jdField_a_of_type_Qeq, true);
          return;
          paramView = (qab)localObject3;
          localObject2 = paramView.r;
          localObject3 = paramView.c;
          localObject4 = paramView.jdField_d_of_type_AndroidWidgetTextView;
          localObject5 = paramView.jdField_a_of_type_AndroidViewView;
          TextView localTextView = paramView.jdField_m_of_type_AndroidWidgetTextView;
          SeekBar localSeekBar = paramView.jdField_b_of_type_AndroidWidgetSeekBar;
          a(paramView, localVideoInfo, (AdvertisementInfo)localObject1, nbe.Y, new View[] { localObject2, localObject3 }, new View[] { localObject4, localObject5, localTextView, localSeekBar });
        }
        if (!(localObject3 instanceof qab)) {
          break;
        }
        paramView = (qab)localObject3;
        a((qae)localObject3, localVideoInfo, (AdvertisementInfo)localObject1, -1, paramView.c, new View[] { paramView.jdField_d_of_type_AndroidWidgetTextView, paramView.jdField_a_of_type_AndroidViewView, paramView.jdField_b_of_type_AndroidWidgetSeekBar });
        return;
        if (!(localObject3 instanceof qab)) {
          break;
        }
        paramView = (qab)localObject3;
        a((qae)localObject3, localVideoInfo, (AdvertisementInfo)localObject1, nbe.Y, paramView.r, new View[] { paramView.jdField_m_of_type_AndroidWidgetTextView, paramView.jdField_b_of_type_AndroidWidgetSeekBar });
        return;
        a(paramView);
        return;
        this.jdField_a_of_type_Qaz.g();
        if (this.jdField_a_of_type_Boolean)
        {
          paramView = "0X800948A";
          localObject1 = (qaq)localObject3;
          if (((qaq)localObject1).jdField_a_of_type_Qeq == null) {
            break label2568;
          }
          localObject1 = ((qaq)localObject1).jdField_a_of_type_Qeq.jdField_a_of_type_Qhw;
          label2356:
          localObject2 = new qmv(null, localVideoInfo.jdField_j_of_type_JavaLangString, localVideoInfo.jdField_a_of_type_JavaLangString, localVideoInfo.jdField_g_of_type_JavaLangString);
          if (localObject1 == null) {
            break label2580;
          }
          if (((qhw)localObject1).e() != 7) {
            break label2574;
          }
          bool = true;
          label2399:
          l1 = ((qhw)localObject1).a(bool);
          label2408:
          localObject2 = ((qmv)localObject2).d(l1);
          if (localObject1 == null) {
            break label2588;
          }
          l1 = ((qhw)localObject1).a();
          label2429:
          localObject2 = ((qmv)localObject2).a(l1);
          if (localObject1 == null) {
            break label2596;
          }
          l1 = ((qhw)localObject1).b();
          localObject2 = ((qmv)localObject2).c(l1).a(409409).a(localVideoInfo.N).v(this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("VIDEO_FROM_TYPE", -1)).a().a();
          localObject3 = localVideoInfo.jdField_j_of_type_JavaLangString;
          if (TextUtils.isEmpty(localVideoInfo.jdField_g_of_type_JavaLangString)) {
            break label2604;
          }
        }
        for (localObject1 = localVideoInfo.jdField_g_of_type_JavaLangString;; localObject1 = "0")
        {
          ndn.a(null, (String)localObject3, paramView, paramView, 0, 0, "", "", (String)localObject1, (String)localObject2, false);
          if (this.jdField_a_of_type_Qfk == null) {
            break;
          }
          this.jdField_a_of_type_Qfk.a(4, localVideoInfo, 0L);
          return;
          paramView = "0X8009485";
          break label2331;
          localObject1 = null;
          break label2356;
          bool = false;
          break label2399;
          l1 = -1L;
          break label2408;
          l1 = -1L;
          break label2429;
          l1 = -1L;
          break label2450;
        }
        this.jdField_a_of_type_Qaz.e();
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
            ndn.a(null, "", "0X8008E54", "0X8008E54", 0, 0, "", "", "", new.a("", "", localVideoInfo.jdField_a_of_type_JavaLangString, localVideoInfo.jdField_g_of_type_JavaLangString, (JSONObject)localObject4), false);
            return;
          }
          if (!this.jdField_a_of_type_Boolean) {
            continue;
          }
          ndn.a(null, "", "0X80092A1", "0X80092A1", 0, 0, "", "", "", new.a("", "", localVideoInfo.jdField_a_of_type_JavaLangString, localVideoInfo.jdField_g_of_type_JavaLangString, (JSONObject)localObject4), false);
          return;
          paramView = "";
        }
        if (!localVideoInfo.jdField_l_of_type_Boolean)
        {
          bool = true;
          localVideoInfo.jdField_l_of_type_Boolean = bool;
          if (!localVideoInfo.jdField_l_of_type_Boolean) {
            break label2980;
          }
          i1 = localVideoInfo.jdField_u_of_type_Int + 1;
        }
        for (;;)
        {
          localVideoInfo.jdField_u_of_type_Int = i1;
          if ((localObject3 instanceof qaq)) {
            ((qaq)localObject3).jdField_a_of_type_Pxs.d();
          }
          if ((this.jdField_a_of_type_Qea != null) && (localVideoInfo.jdField_l_of_type_Boolean)) {
            this.jdField_a_of_type_Qea.a((float)(babp.i() / 2L), (float)(babp.j() / 2L));
          }
          if (this.jdField_a_of_type_Qfk != null) {
            this.jdField_a_of_type_Qfk.a(3, localVideoInfo, 0L);
          }
          if (this.jdField_a_of_type_Qad != null) {
            this.jdField_a_of_type_Qad.a(localVideoInfo, localVideoInfo.jdField_l_of_type_Boolean);
          }
          if ((this.jdField_a_of_type_Qdt != null) && ((localObject3 instanceof qap)))
          {
            int i2 = 0;
            i1 = i2;
            if (this.jdField_a_of_type_Qgv != null)
            {
              i1 = i2;
              if (this.jdField_a_of_type_Qgv.a()) {
                i1 = 1;
              }
            }
            if (i1 == 0) {
              this.jdField_a_of_type_Qdt.a(localVideoInfo, (qap)localObject3);
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
        this.jdField_a_of_type_Pxk.e();
        a(false, (qaq)localObject3);
        a((qaq)localObject3);
        a(localVideoInfo, nbe.aw);
        return;
        npj.a((AdvertisementInfo)localObject1, 15, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
        this.jdField_a_of_type_Pxk.f();
        rvb.b(this.jdField_a_of_type_AndroidAppActivity, (AdvertisementInfo)localObject1, null, 3, true, null);
        a(localVideoInfo, nbe.at);
        return;
        npj.a((AdvertisementInfo)localObject1, 16, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
        this.jdField_a_of_type_Pxk.f();
        rvb.b(this.jdField_a_of_type_AndroidAppActivity, (AdvertisementInfo)localObject1, null, 3, true, null);
        a(localVideoInfo, nbe.au);
        return;
        npj.a((AdvertisementInfo)localObject1, 17, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
        if (a(localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo))
        {
          a(localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
          nbe.a(new nmv().a(this.jdField_a_of_type_AndroidContentContext).a(nbe.J).b(nbe.N).a((AdvertisementInfo)localObject1).a());
          return;
        }
        this.jdField_a_of_type_Pxk.f();
        if (localObject1 != null) {
          rvb.b(this.jdField_a_of_type_AndroidAppActivity, (AdvertisementInfo)localObject1, null, 3, true, null);
        }
        a(localVideoInfo, nbe.av);
        return;
        this.jdField_a_of_type_AndroidOsHandler.sendMessage(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(9, Boolean.valueOf(false)));
        this.j = true;
        if (!(this.jdField_a_of_type_Qag instanceof qab)) {
          break;
        }
        c((qab)this.jdField_a_of_type_Qag);
        return;
        npj.a((AdvertisementInfo)localObject1, 34, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
        a(localVideoInfo, (AdvertisementInfo)localObject1, nbe.aH);
        return;
        npj.a((AdvertisementInfo)localObject1, 35, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
        a(localVideoInfo, (AdvertisementInfo)localObject1, nbe.aG);
        return;
        npj.a((AdvertisementInfo)localObject1, 37, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
        a(localVideoInfo, (AdvertisementInfo)localObject1, nbe.aI);
        return;
        npj.a((AdvertisementInfo)localObject1, 18, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
        a(localVideoInfo, (AdvertisementInfo)localObject1, nbe.aJ);
        return;
        localVideoInfo = null;
      }
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    qae localqae = (qae)paramView.getTag();
    VideoInfo localVideoInfo = null;
    if ((localqae instanceof qaq))
    {
      localVideoInfo = ((qaq)localqae).jdField_a_of_type_Qeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
      if ((this.jdField_a_of_type_Qag != null) && (this.jdField_a_of_type_Qag.jdField_a_of_type_Qeq != null) && (localVideoInfo == this.jdField_a_of_type_Qag.jdField_a_of_type_Qeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo)) {}
    }
    while (localVideoInfo == null) {
      return false;
    }
    switch (paramView.getId())
    {
    default: 
      return false;
    }
    if (qzk.a().b()) {
      return true;
    }
    if (nsh.b() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      a(localVideoInfo, true, bool);
      if (this.jdField_a_of_type_Qfk == null) {
        break;
      }
      this.jdField_a_of_type_Qfk.a(2, localVideoInfo, 0L);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pzs
 * JD-Core Version:    0.7.0.1
 */