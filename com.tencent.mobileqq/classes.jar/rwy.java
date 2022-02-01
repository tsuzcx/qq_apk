import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
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
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoInfo.ChannelInfo;
import com.tencent.biz.pubaccount.VideoInfo.LikeActionDownloadBar;
import com.tencent.biz.pubaccount.readinjoy.ad.video.ADVideoAppDownloadManager;
import com.tencent.biz.pubaccount.readinjoy.biu.ReadInJoyDeliverBiuActivity;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter.12;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter.13;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter.16;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter.2;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter.5;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter.9;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsUGView;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

public class rwy
  extends RecyclerView.Adapter<rxo>
  implements View.OnClickListener, View.OnLongClickListener, pyb, ryn, sbm, shz
{
  private static boolean jdField_a_of_type_Boolean;
  private int jdField_a_of_type_Int;
  public long a;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Context jdField_a_of_type_AndroidContentContext;
  private ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private Handler jdField_a_of_type_AndroidOsHandler = new rxd(this, Looper.getMainLooper());
  private LinearLayoutManager jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager;
  private RecyclerView.RecycledViewPool jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$RecycledViewPool = new RecyclerView.RecycledViewPool();
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private bkly jdField_a_of_type_Bkly;
  private bkni jdField_a_of_type_Bkni;
  private VideoInfo jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
  private ADVideoAppDownloadManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdVideoADVideoAppDownloadManager;
  private VideoFeedsPlayManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager;
  private VideoFeedsRecyclerView jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView;
  private VideoPreDownloadMgr jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr;
  public GdtHandler.Params a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private INetInfoHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new rxc(this);
  private String jdField_a_of_type_JavaLangString;
  public HashMap<String, Integer> a;
  private List<VideoInfo> jdField_a_of_type_JavaUtilList;
  private Map<Integer, Bitmap> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  private omz jdField_a_of_type_Omz;
  private oop jdField_a_of_type_Oop;
  private org jdField_a_of_type_Org;
  private orj jdField_a_of_type_Orj;
  private rvr jdField_a_of_type_Rvr;
  private rvv jdField_a_of_type_Rvv;
  private rvx jdField_a_of_type_Rvx;
  private rxn jdField_a_of_type_Rxn;
  private rxq jdField_a_of_type_Rxq;
  rxt jdField_a_of_type_Rxt;
  private rxy jdField_a_of_type_Rxy;
  private ryd jdField_a_of_type_Ryd;
  private sab jdField_a_of_type_Sab;
  private sbk jdField_a_of_type_Sbk;
  private sbo jdField_a_of_type_Sbo;
  public sbt a;
  private sdq jdField_a_of_type_Sdq;
  private sdu jdField_a_of_type_Sdu;
  private see jdField_a_of_type_See;
  private skc jdField_a_of_type_Skc;
  private int jdField_b_of_type_Int = 1;
  private long jdField_b_of_type_Long;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private String jdField_b_of_type_JavaLangString;
  private Set<String> jdField_b_of_type_JavaUtilSet = new HashSet();
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = 5;
  private long jdField_c_of_type_Long;
  private String jdField_c_of_type_JavaLangString;
  private Set<String> jdField_c_of_type_JavaUtilSet = new HashSet();
  private boolean jdField_c_of_type_Boolean = true;
  private int jdField_d_of_type_Int;
  private String jdField_d_of_type_JavaLangString;
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
  
  public rwy(Context paramContext, Activity paramActivity, VideoFeedsRecyclerView paramVideoFeedsRecyclerView, LinearLayoutManager paramLinearLayoutManager, QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt, sbo paramsbo)
  {
    this.jdField_a_of_type_Long = -2147483648L;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_Sbt = new rxe(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView = paramVideoFeedsRecyclerView;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.a(this.jdField_a_of_type_Sbt);
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager = paramLinearLayoutManager;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = bgmo.a(true);
    this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131165343));
    this.jdField_a_of_type_Rvr = rvr.a();
    this.jdField_a_of_type_Rvv = new rvv(paramActivity);
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_c_of_type_JavaLangString = paramString3;
    jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Bkly = new bkly(this.jdField_a_of_type_AndroidAppActivity);
    AppNetConnInfo.registerConnectionChangeReceiver(this.jdField_a_of_type_AndroidAppActivity.getApplication(), this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(1930498322);
    this.jdField_a_of_type_Sbo = paramsbo;
    setHasStableIds(true);
    registerAdapterDataObserver(new rxm(this, null));
    this.r = bcnj.b();
    this.jdField_a_of_type_Oop = new oop(paramActivity, this);
    this.s = bmqa.d();
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
  
  @Nullable
  private AdvertisementInfo a(VideoInfo paramVideoInfo)
  {
    if (paramVideoInfo.jdField_c_of_type_Boolean)
    {
      paramVideoInfo = oqu.a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
      this.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params = ubb.a(this.jdField_a_of_type_AndroidAppActivity, paramVideoInfo, null, 3, false, null);
      if (this.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params != null) {}
      for (long l1 = SystemClock.elapsedRealtime();; l1 = -2147483648L)
      {
        this.jdField_a_of_type_Long = l1;
        return paramVideoInfo;
      }
    }
    return null;
  }
  
  private String a(int paramInt)
  {
    if (paramInt == 1) {
      return anni.a(2131714917);
    }
    if (paramInt == 2) {
      return anni.a(2131714914);
    }
    return null;
  }
  
  private void a(View paramView, int paramInt, VideoInfo paramVideoInfo)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.d())) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.b();
    }
    if (this.jdField_a_of_type_Oop != null) {
      this.jdField_a_of_type_Oop.a(paramView, paramInt, paramVideoInfo);
    }
  }
  
  private void a(View paramView, VideoInfo paramVideoInfo)
  {
    if ((paramVideoInfo.jdField_c_of_type_Boolean) && ((this.jdField_a_of_type_Rxq instanceof rxl))) {
      a(paramView, (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(), paramVideoInfo);
    }
  }
  
  private void a(View paramView, rxo paramrxo, VideoInfo paramVideoInfo)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      b(paramView, paramVideoInfo);
      return;
      g(paramVideoInfo);
      return;
      a(paramrxo);
      return;
    } while ((this.jdField_a_of_type_Rxq == null) || (this.jdField_a_of_type_Rxq.l == null));
    this.jdField_a_of_type_Sbo.e();
    b(this.jdField_a_of_type_Rxq.jdField_a_of_type_Sar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo, "0X8009F42");
  }
  
  private void a(View paramView, rxo paramrxo, VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131367701: 
      do
      {
        return;
        this.jdField_a_of_type_AndroidOsHandler.sendMessage(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(9, Boolean.valueOf(false)));
        this.j = true;
      } while (!(this.jdField_a_of_type_Rxq instanceof rxl));
      c((rxl)this.jdField_a_of_type_Rxq);
      return;
    case 2131362060: 
    case 2131367707: 
      a(paramrxo, paramVideoInfo, paramAdvertisementInfo, nxw.aP);
      return;
    case 2131367712: 
      c(paramVideoInfo, paramAdvertisementInfo);
      return;
    case 2131367721: 
      b(paramVideoInfo, paramAdvertisementInfo);
      return;
    case 2131367709: 
      a(paramVideoInfo, paramAdvertisementInfo);
      return;
    case 2131367698: 
      oqj.a(paramAdvertisementInfo, 37, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
      a(paramrxo, paramVideoInfo, paramAdvertisementInfo, nxw.aN);
      return;
    case 2131367696: 
      oqj.a(paramAdvertisementInfo, 34, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
      a(paramrxo, paramVideoInfo, paramAdvertisementInfo, nxw.aM);
      return;
    case 2131365695: 
    case 2131367697: 
      oqj.a(paramAdvertisementInfo, 35, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
      a(paramrxo, paramVideoInfo, paramAdvertisementInfo, nxw.aL);
      return;
    case 2131365699: 
      oqj.a(paramAdvertisementInfo, 2003, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
      a(paramrxo, paramVideoInfo, paramAdvertisementInfo, 2003);
      return;
    case 2131362061: 
      oqj.a(paramAdvertisementInfo, 18, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
      ubb.b(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, true, null);
      paramView = nxw.a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
      nxw.a(new omp().a(this.jdField_a_of_type_AndroidContentContext).a(nxw.jdField_a_of_type_Int).b(nxw.aa).a(paramView).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).d(1000).a());
      return;
    }
    a(paramrxo, paramVideoInfo, paramAdvertisementInfo, nxw.aO);
  }
  
  private void a(VideoAdInfo paramVideoAdInfo)
  {
    paramVideoAdInfo = nxw.a(paramVideoAdInfo);
    if (paramVideoAdInfo != null) {
      ubb.a(this.jdField_a_of_type_AndroidAppActivity, paramVideoAdInfo.mPopFormH5Url, paramVideoAdInfo.mAdRl, paramVideoAdInfo.mAdTraceId);
    }
  }
  
  private void a(VideoInfo paramVideoInfo, int paramInt)
  {
    if (paramVideoInfo == null) {
      return;
    }
    AdvertisementInfo localAdvertisementInfo = nxw.a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
    if (paramVideoInfo.a(this.jdField_a_of_type_AndroidAppActivity))
    {
      nxw.a(new omp().a(this.jdField_a_of_type_AndroidContentContext).a(nxw.jdField_a_of_type_Int).b(nxw.R).a(localAdvertisementInfo).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).d(paramInt).a());
      return;
    }
    nxw.a(new omp().a(this.jdField_a_of_type_AndroidContentContext).a(nxw.jdField_a_of_type_Int).b(nxw.P).a(localAdvertisementInfo).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).d(paramInt).a());
  }
  
  private void a(VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo)
  {
    oqj.a(paramAdvertisementInfo, 17, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
    if (a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo))
    {
      a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
      nxw.a(new omp().a(this.jdField_a_of_type_AndroidContentContext).a(nxw.L).b(nxw.P).a(paramAdvertisementInfo).a());
      return;
    }
    this.jdField_a_of_type_Org.f();
    if (paramAdvertisementInfo != null) {
      ubb.b(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, true, null);
    }
    a(paramVideoInfo, nxw.aA);
  }
  
  private void a(VideoInfo paramVideoInfo, String paramString)
  {
    skb localskb = new skc(paramVideoInfo).e(paramVideoInfo.f).h(paramVideoInfo.g).a("live_circle_from_page", Integer.valueOf(2)).a();
    String str = paramVideoInfo.j;
    if (!TextUtils.isEmpty(paramVideoInfo.g)) {}
    for (paramVideoInfo = paramVideoInfo.g;; paramVideoInfo = "0")
    {
      oat.b(null, str, paramString, paramString, 0, 0, "0", "", paramVideoInfo, localskb.a(), false);
      return;
    }
  }
  
  private void a(VideoInfo paramVideoInfo, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject2 = new skc(paramVideoInfo).a().a("scene_type", Integer.valueOf(3)).h(paramVideoInfo.g).e(paramVideoInfo.f).c(paramVideoInfo.jdField_p_of_type_Int);
    Object localObject1;
    label78:
    int i1;
    if (paramVideoInfo.jdField_b_of_type_Boolean)
    {
      localObject1 = paramVideoInfo.j;
      localObject2 = ((skc)localObject2).a("ugcuin", localObject1);
      if (!paramBoolean1) {
        break label154;
      }
      localObject1 = "click_type";
      if (!paramBoolean2) {
        break label162;
      }
      i1 = 2;
      label86:
      localObject1 = ((skc)localObject2).a((String)localObject1, Integer.valueOf(i1)).a();
      localObject2 = paramVideoInfo.j;
      if (TextUtils.isEmpty(paramVideoInfo.g)) {
        break label168;
      }
    }
    label154:
    label162:
    label168:
    for (paramVideoInfo = paramVideoInfo.g;; paramVideoInfo = "0")
    {
      oat.b(null, (String)localObject2, paramString, paramString, 0, 0, "0", "", paramVideoInfo, ((skb)localObject1).a(), false);
      return;
      localObject1 = null;
      break;
      localObject1 = "button_type";
      break label78;
      i1 = 1;
      break label86;
    }
  }
  
  private void a(VideoInfo paramVideoInfo, rxo paramrxo)
  {
    boolean bool = true;
    if ((paramVideoInfo.jdField_c_of_type_Boolean) && ((paramrxo instanceof rxl)))
    {
      opr.a((rxl)paramrxo, "暂不支持biu");
      return;
    }
    if (ouh.a() == 1) {}
    for (;;)
    {
      a(paramVideoInfo, false, bool);
      if (this.jdField_a_of_type_Sbk == null) {
        break;
      }
      this.jdField_a_of_type_Sbk.a(2, paramVideoInfo, 0L);
      return;
      bool = false;
    }
  }
  
  private void a(VideoInfo paramVideoInfo, skc paramskc)
  {
    if (paramskc == null) {
      return;
    }
    String str2;
    if (jdField_a_of_type_Boolean)
    {
      str2 = paramVideoInfo.j;
      if (!TextUtils.isEmpty(paramVideoInfo.g)) {}
      for (str1 = paramVideoInfo.g;; str1 = "0")
      {
        oat.b(null, str2, "0X8009298", "0X8009298", 0, 0, "0", "", str1, paramskc.a().a(), false);
        b(paramVideoInfo, "0X800AD00");
        return;
      }
    }
    int i1;
    if ((!TextUtils.isEmpty(paramVideoInfo.u)) && (ryx.d()))
    {
      i1 = 1;
      label98:
      paramskc.S(i1).a(paramVideoInfo).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo).b(this.s).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo);
      str2 = paramVideoInfo.j;
      if (TextUtils.isEmpty(paramVideoInfo.g)) {
        break label189;
      }
    }
    label189:
    for (String str1 = paramVideoInfo.g;; str1 = "0")
    {
      oat.b(null, str2, "0X8007801", "0X8007801", 0, 0, "0", "", str1, paramskc.a().a(), false);
      break;
      i1 = 0;
      break label98;
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
      localIntent.putExtra("ARG_VIDEO_ARTICLE_ID", paramVideoInfo.g);
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
      localObject1 = new skc((String)localObject1, paramVideoInfo.j, paramVideoInfo.jdField_a_of_type_JavaLangString, paramVideoInfo.g, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(), paramVideoInfo.a() * 1000);
      ((skc)localObject1).h(paramBoolean1).i(paramBoolean2).b(this.s);
      if (!jdField_a_of_type_Boolean)
      {
        ((skc)localObject1).e(paramVideoInfo.f).c(paramVideoInfo.jdField_p_of_type_Int).a(-1).a(paramVideoInfo.B).N(0);
        localObject2 = new rgi();
        ((rgi)localObject2).jdField_d_of_type_Int = ((int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a());
        ((rgi)localObject2).jdField_e_of_type_Int = (paramVideoInfo.a() * 1000);
        ((rgi)localObject2).jdField_b_of_type_Int = this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
        och.b(paramVideoInfo, this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_CHANNEL_ID", -1), 25, -1, (rgi)localObject2, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g);
      }
      localObject1 = ((skc)localObject1).a().a();
      if (!jdField_a_of_type_Boolean) {
        break label288;
      }
      localObject2 = paramVideoInfo.j;
      if (TextUtils.isEmpty(paramVideoInfo.g)) {
        break label281;
      }
    }
    label281:
    for (paramVideoInfo = paramVideoInfo.g;; paramVideoInfo = "0")
    {
      oat.a(null, (String)localObject2, "0X8009299", "0X8009299", 0, 0, "0", "0", paramVideoInfo, (String)localObject1, false);
      return;
      localObject1 = null;
      break;
    }
    label288:
    Object localObject2 = paramVideoInfo.j;
    if (!TextUtils.isEmpty(paramVideoInfo.g)) {}
    for (paramVideoInfo = paramVideoInfo.g;; paramVideoInfo = "0")
    {
      oat.a(null, (String)localObject2, "0X8007B89", "0X8007B89", 0, 0, "0", "0", paramVideoInfo, (String)localObject1, false);
      return;
    }
  }
  
  private void a(VideoFeedsUGView paramVideoFeedsUGView, boolean paramBoolean)
  {
    if (paramVideoFeedsUGView != null) {
      paramVideoFeedsUGView.setActive(paramBoolean);
    }
  }
  
  private void a(String paramString1, boolean paramBoolean, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "followPubAccount() uin=" + paramString1);
    }
    if ((paramString1 == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
    do
    {
      return;
      ryx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramBoolean, paramString2, true);
      paramString2 = this.jdField_a_of_type_JavaUtilList.iterator();
      paramBoolean = false;
      while (paramString2.hasNext())
      {
        Object localObject = (VideoInfo)paramString2.next();
        boolean bool = paramBoolean | a((VideoInfo)localObject, paramString1);
        paramBoolean = bool;
        if (((VideoInfo)localObject).jdField_d_of_type_JavaUtilArrayList != null)
        {
          localObject = ((VideoInfo)localObject).jdField_d_of_type_JavaUtilArrayList.iterator();
          for (;;)
          {
            paramBoolean = bool;
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            bool = a((VideoInfo)((Iterator)localObject).next(), paramString1) | bool;
          }
        }
      }
      if (paramBoolean) {
        b(paramString1);
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "followPubAccount() isDataChanged=" + paramBoolean);
  }
  
  private void a(rxl paramrxl)
  {
    int i1;
    Object localObject;
    if ((paramrxl != null) && (paramrxl.jdField_a_of_type_Sar != null) && (paramrxl.jdField_a_of_type_Sar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (paramrxl.jdField_a_of_type_Sar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo != null))
    {
      i1 = oqi.d(nxw.a(paramrxl.jdField_a_of_type_Sar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo));
      if (i1 != 1) {
        break label84;
      }
      paramrxl = paramrxl.jdField_b_of_type_AndroidViewView;
      localObject = (LinearLayout.LayoutParams)paramrxl.getLayoutParams();
      if (localObject != null)
      {
        ((LinearLayout.LayoutParams)localObject).weight = 2.0F;
        paramrxl.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
    label84:
    do
    {
      do
      {
        return;
      } while (i1 != 2);
      localObject = paramrxl.jdField_c_of_type_AndroidViewView;
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((View)localObject).getLayoutParams();
      if (localLayoutParams != null)
      {
        localLayoutParams.weight = 0.0F;
        ((View)localObject).setLayoutParams(localLayoutParams);
      }
      paramrxl = paramrxl.jdField_d_of_type_AndroidViewView;
      localObject = (LinearLayout.LayoutParams)paramrxl.getLayoutParams();
    } while (localObject == null);
    ((LinearLayout.LayoutParams)localObject).weight = 0.0F;
    paramrxl.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  private void a(rxl paramrxl, VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo, int paramInt, View[] paramArrayOfView1, View[] paramArrayOfView2)
  {
    int i1 = 8;
    int i2 = 0;
    if (paramVideoInfo.jdField_c_of_type_Boolean)
    {
      i3 = paramAdvertisementInfo.clickPos;
      if ((!AdvertisementInfo.isAppAdvertisementInfo(paramAdvertisementInfo)) || (!oqi.d(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo))) {
        break label328;
      }
      if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdVideoADVideoAppDownloadManager.a(paramVideoInfo)) {
        break label134;
      }
      ubb.b(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, true, null);
      if (paramInt == nxw.aa)
      {
        paramrxl = nxw.a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
        nxw.a(new omp().a(this.jdField_a_of_type_AndroidContentContext).a(nxw.jdField_a_of_type_Int).b(nxw.aa).a(paramrxl).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).d(i3).a());
      }
    }
    else
    {
      return;
    }
    a(paramVideoInfo, i3);
    return;
    label134:
    oqj.a(paramAdvertisementInfo, i3, null);
    int i3 = paramArrayOfView1.length;
    i1 = 0;
    while (i1 < i3)
    {
      paramArrayOfView1[i1].setVisibility(0);
      i1 += 1;
    }
    paramrxl.jdField_a_of_type_Boolean = true;
    i3 = paramArrayOfView2.length;
    i1 = i2;
    while (i1 < i3)
    {
      paramArrayOfView2[i1].setVisibility(8);
      i1 += 1;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdVideoADVideoAppDownloadManager.f();
    opr.a(paramrxl);
    if (paramInt == nxw.aa)
    {
      nxw.a(new omp().a(this.jdField_a_of_type_AndroidContentContext).a(nxw.jdField_a_of_type_Int).b(nxw.am).a(paramAdvertisementInfo).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).d(paramAdvertisementInfo.clickPos).a());
      return;
    }
    nxw.a(new omp().a(this.jdField_a_of_type_AndroidContentContext).a(nxw.jdField_a_of_type_Int).b(nxw.am).a(paramAdvertisementInfo).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).a());
    return;
    label328:
    if (paramInt == nxw.aa)
    {
      paramInt = 38;
      paramrxl = nxw.a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
      nxw.a(new omp().a(this.jdField_a_of_type_AndroidContentContext).a(nxw.jdField_a_of_type_Int).b(nxw.aa).a(paramrxl).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).d(paramAdvertisementInfo.clickPos).a());
    }
    for (;;)
    {
      if (paramAdvertisementInfo != null) {
        paramAdvertisementInfo.setClickPos(paramInt);
      }
      paramrxl = new oml();
      paramrxl.jdField_c_of_type_Boolean = true;
      ubb.b(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, true, paramrxl);
      return;
      paramInt = i1;
      if (this.i) {
        paramInt = 13;
      }
      a(paramVideoInfo, paramInt);
    }
  }
  
  private void a(rxo paramrxo)
  {
    if ((paramrxo.jdField_a_of_type_Int == 2) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.b())) {
      ryx.a(((rxy)paramrxo).jdField_d_of_type_AndroidViewViewGroup, 8, 200);
    }
    if (this.jdField_a_of_type_Sbo != null) {
      this.jdField_a_of_type_Sbo.b();
    }
  }
  
  private void a(rxo paramrxo, VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo)
  {
    if ((paramrxo instanceof rxl))
    {
      rxl localrxl = (rxl)paramrxo;
      opr.c(localrxl.jdField_b_of_type_AndroidWidgetSeekBar);
      a(paramrxo, paramVideoInfo, paramAdvertisementInfo, -1, localrxl.jdField_a_of_type_AndroidViewView, new View[] { localrxl.jdField_c_of_type_AndroidWidgetRelativeLayout });
    }
  }
  
  private void a(rxo paramrxo, VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo, int paramInt)
  {
    if ((paramrxo == null) || (paramVideoInfo == null) || (paramAdvertisementInfo == null)) {}
    do
    {
      return;
      if ((!AdvertisementInfo.isAppAdvertisementInfo(paramAdvertisementInfo)) || (!oqi.a(paramAdvertisementInfo))) {
        break;
      }
      paramAdvertisementInfo.setClickPos(paramInt);
    } while (!(paramrxo instanceof rxl));
    rxl localrxl = (rxl)paramrxo;
    if ((localrxl.jdField_a_of_type_Boolean) && (oqi.a(paramAdvertisementInfo)) && (localrxl.p.getVisibility() == 0))
    {
      d(paramrxo, paramVideoInfo, paramAdvertisementInfo);
      return;
    }
    c(paramrxo, paramVideoInfo, paramAdvertisementInfo);
    return;
    paramAdvertisementInfo.setClickPos(paramInt);
    ubb.b(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, true, null);
    paramrxo = nxw.a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
    nxw.a(new omp().a(this.jdField_a_of_type_AndroidContentContext).a(nxw.jdField_a_of_type_Int).b(nxw.aa).a(paramrxo).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).d(paramInt).a());
  }
  
  private void a(rxo paramrxo, VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo, int paramInt, View paramView, View... paramVarArgs)
  {
    int i1;
    if (paramVideoInfo.jdField_c_of_type_Boolean)
    {
      i1 = paramAdvertisementInfo.clickPos;
      if ((AdvertisementInfo.isAppAdvertisementInfo(paramAdvertisementInfo)) && (oqi.d(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo)))
      {
        if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdVideoADVideoAppDownloadManager.a(paramVideoInfo)) {
          break label119;
        }
        ubb.b(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, true, null);
        if (paramInt != nxw.aa) {
          break label111;
        }
        nxw.a(new omp().a(this.jdField_a_of_type_AndroidContentContext).a(nxw.jdField_a_of_type_Int).b(nxw.aa).a(paramAdvertisementInfo).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).d(i1).a());
      }
    }
    label111:
    label119:
    do
    {
      return;
      a(paramVideoInfo, i1);
      return;
      paramView.setVisibility(0);
      ((rxl)paramrxo).jdField_a_of_type_Boolean = true;
      if (paramVarArgs != null)
      {
        paramInt = 0;
        while (paramInt < paramVarArgs.length)
        {
          paramVarArgs[paramInt].setVisibility(8);
          paramInt += 1;
        }
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdVideoADVideoAppDownloadManager.f();
    } while (!(paramrxo instanceof rxl));
    ((rxl)paramrxo).jdField_a_of_type_Boolean = true;
    opr.a((rxl)paramrxo);
  }
  
  private void a(rxq paramrxq)
  {
    if ((this.jdField_a_of_type_Rxq != null) && (this.jdField_a_of_type_Rxq.jdField_a_of_type_Sar != null) && (this.jdField_a_of_type_Rxq.jdField_a_of_type_Sar.jdField_a_of_type_Sfb != null))
    {
      sfb localsfb = this.jdField_a_of_type_Rxq.jdField_a_of_type_Sar.jdField_a_of_type_Sfb;
      if ((!localsfb.a()) && (!localsfb.b()) && (!localsfb.c()) && (this.jdField_a_of_type_Rxq.jdField_c_of_type_Int == paramrxq.jdField_c_of_type_Int - 1) && (bmqa.v(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (she.a().a(this.jdField_a_of_type_Rxq.jdField_a_of_type_Sar.jdField_a_of_type_Sfb))) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.b(paramrxq.jdField_a_of_type_Sar);
      }
    }
  }
  
  private void a(rxq paramrxq, VideoInfo paramVideoInfo)
  {
    sar localsar2 = paramrxq.jdField_a_of_type_Sar;
    sar localsar1 = localsar2;
    if (localsar2 == null)
    {
      localsar1 = new sar();
      localsar1.jdField_a_of_type_Ruv = paramrxq.jdField_a_of_type_Sek;
      localsar1.jdField_a_of_type_AndroidOsBundle.putInt("jump_from_scene", this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("PERFORMANCE_REPORT_VIDEO_FEEDS_JUMP_FROM", 0));
    }
    localsar1.jdField_a_of_type_ComTencentBizPubaccountVideoInfo = paramVideoInfo;
    localsar1.jdField_a_of_type_Int = paramVideoInfo.a(this.jdField_a_of_type_AndroidAppActivity, paramrxq.jdField_d_of_type_Int);
    localsar1.jdField_a_of_type_AndroidViewViewGroup = paramrxq.jdField_b_of_type_AndroidViewViewGroup;
    localsar1.jdField_b_of_type_Int = paramrxq.jdField_c_of_type_Int;
    localsar1.jdField_a_of_type_Boolean = false;
    localsar1.jdField_a_of_type_AndroidOsBundle.putInt("video_feeds_index", paramrxq.jdField_c_of_type_Int);
    localsar1.jdField_a_of_type_Long = 0L;
    localsar1.jdField_b_of_type_Boolean = true;
    if (paramVideoInfo.jdField_c_of_type_Boolean)
    {
      if (!paramVideoInfo.a(this.jdField_a_of_type_AndroidAppActivity)) {
        break label174;
      }
      localsar1.jdField_a_of_type_AndroidOsBundle.putInt("ad_origin", nxw.R);
    }
    for (;;)
    {
      paramrxq.jdField_a_of_type_Sek.jdField_a_of_type_Boolean = true;
      paramrxq.jdField_a_of_type_Sar = localsar1;
      paramrxq.jdField_a_of_type_Sjn.a(this, paramrxq);
      return;
      label174:
      localsar1.jdField_a_of_type_AndroidOsBundle.putInt("ad_origin", nxw.P);
    }
  }
  
  private void a(rxq paramrxq1, rxq paramrxq2, boolean paramBoolean)
  {
    paramrxq2 = this.jdField_a_of_type_AndroidAppActivity;
    VideoInfo localVideoInfo = paramrxq1.jdField_a_of_type_Sar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
    int i1 = paramrxq1.jdField_b_of_type_Int;
    int i2 = paramrxq1.jdField_c_of_type_Int;
    int i3 = paramrxq1.jdField_a_of_type_Int;
    boolean bool1;
    if (((paramrxq1 instanceof rxv)) && (((rxv)paramrxq1).b.getVisibility() == 0))
    {
      bool1 = true;
      if ((!(paramrxq1 instanceof rxy)) || (((rxy)paramrxq1).jdField_a_of_type_Ruq == null) || (((rxy)paramrxq1).jdField_a_of_type_Ruq.a().getVisibility() != 0)) {
        break label128;
      }
    }
    label128:
    for (boolean bool2 = true;; bool2 = false)
    {
      ThreadManager.post(new VideoFeedsAdapter.5(this, localVideoInfo, paramrxq2, i2, paramBoolean, i1, i3, bool1, bool2), 1, null, true);
      return;
      bool1 = false;
      break;
    }
  }
  
  private void a(rxt paramrxt)
  {
    if (this.jdField_b_of_type_Int == 1)
    {
      paramrxt.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      paramrxt.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      paramrxt.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramrxt.jdField_a_of_type_AndroidWidgetTextView.setText(a(1));
    }
    do
    {
      return;
      if (this.jdField_b_of_type_Int == 2)
      {
        paramrxt.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
        paramrxt.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        paramrxt.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        paramrxt.jdField_a_of_type_AndroidWidgetTextView.setText(a(2));
        return;
      }
    } while (this.jdField_b_of_type_Int != 3);
    if (paramrxt.jdField_a_of_type_Int == 6)
    {
      paramrxt.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      paramrxt.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      paramrxt.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramrxt.jdField_a_of_type_AndroidWidgetTextView.setText(a(1));
      return;
    }
    paramrxt.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
    paramrxt.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    paramrxt.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  private void a(rxy paramrxy, VideoInfo paramVideoInfo)
  {
    this.jdField_a_of_type_Org.e();
    a(false, paramrxy);
    a(paramrxy);
    a(paramVideoInfo, nxw.aB);
  }
  
  private void a(rxy paramrxy, VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo)
  {
    if ((paramVideoInfo.jdField_c_of_type_Boolean) && ((paramrxy instanceof rxl)))
    {
      opr.a((rxl)paramrxy, "作者设置暂不可评论");
      return;
    }
    paramAdvertisementInfo = new JSONObject();
    this.jdField_a_of_type_Ryd.e();
    for (;;)
    {
      try
      {
        if (paramVideoInfo.B == null) {
          continue;
        }
        paramrxy = paramVideoInfo.B;
        paramAdvertisementInfo.put("video_report_info", paramrxy);
        paramAdvertisementInfo.put("video_type", 0);
        if (!this.s) {
          continue;
        }
        i1 = 1;
        paramAdvertisementInfo.put("interact_button_style", i1);
      }
      catch (JSONException paramrxy)
      {
        int i1;
        paramrxy.printStackTrace();
        continue;
        oat.a(null, "", "0X8008E54", "0X8008E54", 0, 0, "", "", "", och.a("", "", paramVideoInfo.jdField_a_of_type_JavaLangString, paramVideoInfo.g, paramAdvertisementInfo), false);
      }
      if (!jdField_a_of_type_Boolean) {
        continue;
      }
      oat.a(null, "", "0X80092A1", "0X80092A1", 0, 0, "", "", "", och.a("", "", paramVideoInfo.jdField_a_of_type_JavaLangString, paramVideoInfo.g, paramAdvertisementInfo), false);
      return;
      paramrxy = "";
      continue;
      i1 = 0;
    }
  }
  
  private void a(rxy paramrxy, boolean paramBoolean, long paramLong, int paramInt)
  {
    if (paramBoolean)
    {
      if (this.jdField_b_of_type_Long != 0L) {
        ThreadManager.excute(new VideoFeedsAdapter.2(this, paramLong), 16, null, true);
      }
      if ((paramrxy.jdField_a_of_type_Sar != null) && (paramrxy.jdField_a_of_type_Sar.jdField_a_of_type_Rgc != null))
      {
        paramrxy.jdField_a_of_type_Sar.jdField_a_of_type_Rgc.o = paramLong;
        paramrxy.jdField_a_of_type_Sar.jdField_a_of_type_Rgc.s = pha.a(paramInt, paramrxy.jdField_c_of_type_Int, false);
      }
      if ((paramrxy.jdField_a_of_type_Sar != null) && (paramrxy.jdField_a_of_type_Sar.jdField_a_of_type_Rgb != null)) {
        paramrxy.jdField_a_of_type_Sar.jdField_a_of_type_Rgb.jdField_a_of_type_Boolean = true;
      }
    }
  }
  
  @RequiresApi(api=16)
  private void a(sar paramsar)
  {
    ryx.a(this.jdField_a_of_type_Rxq.jdField_b_of_type_ComTencentImageURLImageView, 8, 0);
    this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView().getViewTreeObserver().addOnDrawListener(new rwz(this, paramsar));
  }
  
  private void a(boolean paramBoolean, rxy paramrxy)
  {
    if (!(paramrxy instanceof rxl)) {
      return;
    }
    paramrxy = (rxl)paramrxy;
    if (paramrxy.jdField_a_of_type_AndroidViewView != null)
    {
      paramrxy.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      paramrxy.jdField_a_of_type_AndroidViewView.getParent().requestDisallowInterceptTouchEvent(true);
      paramrxy.jdField_a_of_type_AndroidViewView.setTag(paramrxy);
    }
    if (paramrxy.p != null)
    {
      paramrxy.p.setOnClickListener(this);
      paramrxy.p.getParent().requestDisallowInterceptTouchEvent(true);
      paramrxy.p.setTag(paramrxy);
    }
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramrxy.jdField_a_of_type_Sar != null)
    {
      bool1 = bool2;
      if (paramrxy.jdField_a_of_type_Sar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null)
      {
        bool1 = bool2;
        if (paramrxy.jdField_a_of_type_Sar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo != null) {
          bool1 = oqi.d(paramrxy.jdField_a_of_type_Sar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
        }
      }
    }
    if ((paramrxy.jdField_a_of_type_Boolean) && (bool1))
    {
      opr.b(paramrxy.jdField_c_of_type_AndroidWidgetRelativeLayout);
      opr.b(paramrxy.e);
      if (!this.s) {
        opr.c(paramrxy.jdField_b_of_type_AndroidWidgetSeekBar);
      }
      opr.a(paramrxy.jdField_a_of_type_AndroidViewView);
      return;
    }
    opr.b(paramrxy.jdField_a_of_type_AndroidViewView);
    if (paramrxy.jdField_d_of_type_AndroidViewViewGroup.getVisibility() == 8) {
      opr.a(paramrxy.jdField_b_of_type_AndroidWidgetSeekBar);
    }
    if ((paramrxy.jdField_a_of_type_Sar != null) && (paramrxy.jdField_a_of_type_Sar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (paramrxy.jdField_a_of_type_Sar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo != null))
    {
      if (!c(paramrxy.jdField_a_of_type_Sar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo)) {
        break label277;
      }
      opr.b(paramrxy.jdField_c_of_type_AndroidWidgetRelativeLayout);
      opr.a(paramrxy.e);
    }
    for (;;)
    {
      a(paramrxy);
      return;
      label277:
      if (a(paramrxy))
      {
        opr.b(paramrxy.e);
        opr.a(paramrxy.jdField_c_of_type_AndroidWidgetRelativeLayout);
        opr.a(paramBoolean, paramrxy);
      }
      else
      {
        opr.b(paramrxy.e);
        opr.b(paramrxy.jdField_c_of_type_AndroidWidgetRelativeLayout);
      }
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
      if ((i3 >= 0) && ((paramList instanceof rxy)) && (((rxy)paramList).jdField_b_of_type_Int == i3))
      {
        ((rxy)paramList).jdField_a_of_type_Rur.b(paramVideoInfo);
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
      if ((localViewHolder instanceof rxy))
      {
        VideoInfo localVideoInfo = (VideoInfo)paramList.get(((rxy)localViewHolder).jdField_b_of_type_Int);
        if (paramString.equals(localVideoInfo.j)) {
          ((rxy)localViewHolder).jdField_a_of_type_Rur.b(localVideoInfo);
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
      paramVideoAdInfo = nxw.a(paramVideoAdInfo);
    } while ((TextUtils.isEmpty(paramVideoAdInfo.mPopFormH5Url)) || (!oqi.d(paramVideoAdInfo)));
    return true;
  }
  
  private boolean a(VideoInfo paramVideoInfo, String paramString)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = bool3;
    if (paramVideoInfo.j != null)
    {
      bool1 = bool3;
      if (paramVideoInfo.j.equals(paramString))
      {
        bool1 = bool2;
        if (!paramVideoInfo.q) {
          bool1 = true;
        }
        paramVideoInfo.q = true;
      }
    }
    return bool1;
  }
  
  private boolean a(rxl paramrxl)
  {
    boolean bool3 = true;
    boolean bool1 = true;
    boolean bool2 = bool1;
    if (paramrxl != null)
    {
      bool2 = bool1;
      if (paramrxl.jdField_a_of_type_Sar != null)
      {
        if (paramrxl.jdField_a_of_type_Sar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) {
          break label34;
        }
        bool2 = bool1;
      }
    }
    label34:
    do
    {
      return bool2;
      paramrxl = paramrxl.jdField_a_of_type_Sar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
      bool1 = bool3;
      if (paramrxl.jdField_c_of_type_Boolean)
      {
        paramrxl = nxw.a(paramrxl.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
        bool1 = bool3;
        if (paramrxl != null)
        {
          bool1 = bool3;
          if (!paramrxl.mShowAdButton) {
            bool1 = false;
          }
        }
      }
      bool2 = bool1;
    } while (!QLog.isColorLevel());
    QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "showButton = " + bool1);
    return bool1;
  }
  
  private boolean a(rxy paramrxy)
  {
    boolean bool4 = true;
    boolean bool2 = true;
    boolean bool3 = false;
    paramrxy.jdField_a_of_type_Sek.jdField_a_of_type_Boolean = false;
    boolean bool1 = bool2;
    Bundle localBundle;
    int i2;
    if (paramrxy.jdField_c_of_type_Int == this.jdField_e_of_type_Int)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_AndroidContentContext != null)
      {
        bool1 = bool2;
        if (paramrxy.jdField_a_of_type_Sar != null)
        {
          bool1 = bool2;
          if (paramrxy.jdField_a_of_type_Sar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null)
          {
            localBundle = this.jdField_a_of_type_AndroidAppActivity.getIntent().getExtras();
            i2 = localBundle.getInt("VIDEO_FROM_TYPE", 0);
            if (bgnt.b(this.jdField_a_of_type_AndroidContentContext)) {
              break label138;
            }
            i1 = 1;
            if ((i1 == 0) && (!this.jdField_f_of_type_Boolean)) {
              break label143;
            }
          }
        }
      }
    }
    label138:
    label143:
    for (int i1 = 1;; i1 = 0)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d())) {
        break label148;
      }
      bool1 = false;
      return bool1;
      i1 = 0;
      break;
    }
    label148:
    if (i2 == 27)
    {
      if (Aladdin.getConfig(271).getIntegerFromString("auto_play", 1) == 1)
      {
        paramrxy = paramrxy.jdField_a_of_type_Sek;
        bool1 = bool3;
        if (i1 == 0) {
          bool1 = true;
        }
        paramrxy.jdField_a_of_type_Boolean = bool1;
        return true;
      }
      paramrxy = paramrxy.jdField_a_of_type_Sek;
      if (i1 == 0) {}
      for (bool1 = bool4;; bool1 = false)
      {
        paramrxy.jdField_a_of_type_Boolean = bool1;
        return false;
      }
    }
    if (i1 != 0)
    {
      paramrxy.jdField_a_of_type_Sek.jdField_a_of_type_Boolean = false;
      return true;
    }
    i1 = localBundle.getInt("VIDEO_PLAY_STATUS", 0);
    paramrxy = paramrxy.jdField_a_of_type_Sek;
    if (((2 != i2) && (6 != i2) && (5 != i2)) || (3 != i1))
    {
      bool1 = true;
      label275:
      paramrxy.jdField_a_of_type_Boolean = bool1;
      if ((i2 != 0) && (1 != i2) && (12 != i2) && (11 != i2)) {
        break label320;
      }
    }
    label320:
    for (i1 = 1;; i1 = 0)
    {
      bool1 = bool2;
      if (i1 == 0) {
        break;
      }
      return false;
      bool1 = false;
      break label275;
    }
  }
  
  private void b(View paramView, VideoInfo paramVideoInfo)
  {
    if (this.jdField_a_of_type_Sbo != null) {
      this.jdField_a_of_type_Sbo.b();
    }
    this.jdField_a_of_type_Rxq.jdField_a_of_type_Sjn.a();
    if (paramView.getId() == 2131366063) {
      sjo.b(paramVideoInfo.g, 2);
    }
  }
  
  private void b(View paramView, rxo paramrxo, VideoInfo paramVideoInfo)
  {
    AdvertisementInfo localAdvertisementInfo = a(paramVideoInfo);
    switch (paramView.getId())
    {
    default: 
    case 2131366969: 
    case 2131371937: 
    case 2131364551: 
    case 2131367264: 
    case 2131367879: 
    case 2131364826: 
    case 2131366991: 
    case 2131366992: 
    case 2131366976: 
    case 2131380650: 
    case 2131367723: 
    case 2131361855: 
      do
      {
        do
        {
          return;
          a(paramVideoInfo, paramrxo);
          return;
        } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView == null);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.b();
        return;
        f(paramVideoInfo);
        return;
        a(paramView);
        return;
        b((rxy)paramrxo, paramVideoInfo, localAdvertisementInfo);
        return;
        a((rxy)paramrxo, paramVideoInfo, localAdvertisementInfo);
        return;
        c(paramrxo, paramVideoInfo);
        return;
        b(paramrxo, paramVideoInfo);
        return;
        a((rxy)paramrxo, paramVideoInfo);
        return;
      } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView == null);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.a();
      return;
    }
    e(paramVideoInfo);
  }
  
  private void b(VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo)
  {
    oqj.a(paramAdvertisementInfo, 16, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
    this.jdField_a_of_type_Org.f();
    ubb.b(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, true, null);
    a(paramVideoInfo, nxw.az);
  }
  
  private void b(VideoInfo paramVideoInfo, String paramString)
  {
    if ((this.jdField_a_of_type_Rxq != null) && (this.jdField_a_of_type_Rxq.l != null) && (this.jdField_a_of_type_Rxq.l.getVisibility() == 0)) {
      oat.a(null, "", paramString, paramString, 0, 0, "", "", "", new skc(paramVideoInfo).a(this.jdField_a_of_type_Sbo.a()).b(this.s).c(paramVideoInfo.jdField_d_of_type_Int).N(0).a(paramVideoInfo.B).M(piv.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_d_of_type_Int)).a().a(), false);
    }
  }
  
  private void b(rxl paramrxl)
  {
    int i1;
    Object localObject;
    if ((paramrxl != null) && (paramrxl.jdField_a_of_type_Sar != null) && (paramrxl.jdField_a_of_type_Sar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (paramrxl.jdField_a_of_type_Sar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo != null))
    {
      i1 = oqi.d(nxw.a(paramrxl.jdField_a_of_type_Sar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo));
      if (i1 != 1) {
        break label88;
      }
      paramrxl = paramrxl.j;
      if (paramrxl != null)
      {
        localObject = (LinearLayout.LayoutParams)paramrxl.getLayoutParams();
        if (localObject != null)
        {
          ((LinearLayout.LayoutParams)localObject).weight = 2.0F;
          paramrxl.setLayoutParams((ViewGroup.LayoutParams)localObject);
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
        localObject = paramrxl.jdField_k_of_type_AndroidViewView;
        if (localObject != null)
        {
          LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((View)localObject).getLayoutParams();
          if (localLayoutParams != null)
          {
            localLayoutParams.weight = 0.0F;
            ((View)localObject).setLayoutParams(localLayoutParams);
          }
        }
        paramrxl = paramrxl.l;
      } while (paramrxl == null);
      localObject = (LinearLayout.LayoutParams)paramrxl.getLayoutParams();
    } while (localObject == null);
    ((LinearLayout.LayoutParams)localObject).weight = 0.0F;
    paramrxl.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  private void b(rxo paramrxo, VideoInfo paramVideoInfo)
  {
    if (((paramrxo instanceof rxv)) && (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo != null))
    {
      ryx.a(this.jdField_a_of_type_AndroidAppActivity, paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.a);
      paramrxo = new skc(paramVideoInfo).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo).h(paramVideoInfo.g).N(0).a();
      oat.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "", "0X800AC2C", "0X800AC2C", 0, 0, "", "", "", paramrxo.a(), false);
    }
  }
  
  private void b(rxo paramrxo, VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo)
  {
    if ((paramrxo instanceof rxl))
    {
      if (a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo))
      {
        a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
        nxw.a(new omp().a(this.jdField_a_of_type_AndroidContentContext).a(nxw.L).b(nxw.P).a(paramAdvertisementInfo).a());
      }
    }
    else {
      return;
    }
    rxl localrxl = (rxl)paramrxo;
    int i1 = 8;
    if (this.i) {
      i1 = 13;
    }
    oqj.a(paramAdvertisementInfo, i1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
    c(localrxl);
    paramrxo = new View[1];
    paramrxo[0] = localrxl.jdField_a_of_type_AndroidViewView;
    if (c(paramVideoInfo)) {
      paramrxo = new View[0];
    }
    RelativeLayout localRelativeLayout = localrxl.jdField_c_of_type_AndroidWidgetRelativeLayout;
    opr.c(localrxl.jdField_b_of_type_AndroidWidgetSeekBar);
    a(localrxl, paramVideoInfo, paramAdvertisementInfo, -1, paramrxo, new View[] { localRelativeLayout });
  }
  
  private void b(rxq paramrxq)
  {
    paramrxq = paramrxq.jdField_a_of_type_Sar;
    if ((paramrxq != null) && ((paramrxq.jdField_a_of_type_Boolean) || ((paramrxq.jdField_a_of_type_Sfb != null) && (paramrxq.jdField_a_of_type_Sfb.b() != 0))))
    {
      paramrxq.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.c(paramrxq);
    }
  }
  
  private void b(rxy paramrxy, VideoInfo paramVideoInfo)
  {
    if (bdch.a()) {}
    do
    {
      do
      {
        return;
        if (paramrxy.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsUGView != null) {
          paramrxy.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsUGView.a();
        }
        if (paramrxy.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsUGView != null) {
          paramrxy.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsUGView.a();
        }
      } while ((paramVideoInfo.jdField_a_of_type_Ocb == null) && (paramVideoInfo.jdField_b_of_type_Ocb == null));
      if ((paramrxy.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsUGView != null) && (paramVideoInfo.jdField_a_of_type_Ocb != null) && ((paramVideoInfo.jdField_a_of_type_Ocb.jdField_c_of_type_Int == 1) || (paramVideoInfo.jdField_a_of_type_Ocb.jdField_c_of_type_Int == 2))) {
        paramrxy.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsUGView.setInfo(paramVideoInfo.jdField_a_of_type_Ocb, paramVideoInfo.jdField_c_of_type_JavaLangString, "VideoPlay_ContentMix");
      }
    } while ((paramrxy.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsUGView == null) || (paramVideoInfo.jdField_b_of_type_Ocb == null) || ((paramVideoInfo.jdField_b_of_type_Ocb.jdField_c_of_type_Int != 1) && (paramVideoInfo.jdField_b_of_type_Ocb.jdField_c_of_type_Int != 2)));
    paramrxy.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsUGView.setInfo(paramVideoInfo.jdField_b_of_type_Ocb, paramVideoInfo.jdField_c_of_type_JavaLangString, "VideoPlay_Shooting");
  }
  
  private void b(rxy paramrxy, VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramVideoInfo.jdField_c_of_type_Boolean)
    {
      oqj.a(paramAdvertisementInfo, 1000, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
      ubb.b(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, false, null);
      a(paramVideoInfo, 1000);
      return;
    }
    this.jdField_a_of_type_Ryd.g();
    label57:
    label72:
    Object localObject;
    long l1;
    label108:
    label127:
    String str;
    if (jdField_a_of_type_Boolean)
    {
      paramAdvertisementInfo = "0X800948A";
      if (paramrxy.jdField_a_of_type_Sar == null) {
        break label266;
      }
      paramrxy = paramrxy.jdField_a_of_type_Sar.jdField_a_of_type_Sfb;
      localObject = new skc(null, paramVideoInfo.j, paramVideoInfo.jdField_a_of_type_JavaLangString, paramVideoInfo.g);
      if (paramrxy == null) {
        break label271;
      }
      l1 = paramrxy.a(paramrxy.h());
      localObject = ((skc)localObject).d(l1);
      if (paramrxy == null) {
        break label279;
      }
      l1 = paramrxy.a();
      localObject = ((skc)localObject).a(l1);
      if (paramrxy == null) {
        break label287;
      }
      l1 = paramrxy.b();
      label146:
      localObject = ((skc)localObject).c(l1).a(409409).a(paramVideoInfo.B).v(this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("VIDEO_FROM_TYPE", -1)).a().a();
      str = paramVideoInfo.j;
      if (TextUtils.isEmpty(paramVideoInfo.g)) {
        break label295;
      }
    }
    label266:
    label271:
    label279:
    label287:
    label295:
    for (paramrxy = paramVideoInfo.g;; paramrxy = "0")
    {
      oat.a(null, str, paramAdvertisementInfo, paramAdvertisementInfo, 0, 0, "", "", paramrxy, (String)localObject, false);
      if ((bmqa.j(pha.a())) || (this.jdField_a_of_type_Sbk == null)) {
        break;
      }
      this.jdField_a_of_type_Sbk.a(4, paramVideoInfo, 0L);
      return;
      paramAdvertisementInfo = "0X8009485";
      break label57;
      paramrxy = null;
      break label72;
      l1 = -1L;
      break label108;
      l1 = -1L;
      break label127;
      l1 = -1L;
      break label146;
    }
  }
  
  private void c(View paramView, rxo paramrxo, VideoInfo paramVideoInfo)
  {
    AdvertisementInfo localAdvertisementInfo = a(paramVideoInfo);
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      a(paramView, paramrxo, paramVideoInfo, localAdvertisementInfo);
      return;
      a(paramView, paramVideoInfo);
      continue;
      i(paramVideoInfo, localAdvertisementInfo);
      continue;
      h(paramVideoInfo, localAdvertisementInfo);
      continue;
      g(paramVideoInfo, localAdvertisementInfo);
      continue;
      f(paramVideoInfo, localAdvertisementInfo);
      continue;
      e(paramVideoInfo, localAdvertisementInfo);
      continue;
      d(paramVideoInfo, localAdvertisementInfo);
      continue;
      b(paramrxo, paramVideoInfo, localAdvertisementInfo);
      continue;
      oqj.a(localAdvertisementInfo, 13, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
      a(paramrxo, paramVideoInfo, localAdvertisementInfo);
      continue;
      j(paramVideoInfo, localAdvertisementInfo);
      continue;
      oqj.a(localAdvertisementInfo, 2003, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
      a(paramrxo, paramVideoInfo, localAdvertisementInfo, 2003);
      continue;
      oqj.a(localAdvertisementInfo, 2004, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
      a(paramrxo, paramVideoInfo, localAdvertisementInfo, 2004);
      continue;
      oqj.a(localAdvertisementInfo, 4001, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
      a(paramrxo, paramVideoInfo, localAdvertisementInfo, 4001);
      continue;
      oqj.a(localAdvertisementInfo, 4002, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
      a(paramrxo, paramVideoInfo, localAdvertisementInfo, 4002);
      continue;
      oqj.a(localAdvertisementInfo, 4007, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
      a(paramrxo, paramVideoInfo, localAdvertisementInfo, 4007);
      continue;
      oqj.a(localAdvertisementInfo, 4000, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
      a(paramrxo, paramVideoInfo, localAdvertisementInfo, 4000);
    }
  }
  
  private void c(VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo)
  {
    oqj.a(paramAdvertisementInfo, 15, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
    this.jdField_a_of_type_Org.f();
    ubb.b(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, true, null);
    a(paramVideoInfo, nxw.ay);
  }
  
  private void c(rxl paramrxl) {}
  
  private void c(rxo paramrxo, VideoInfo paramVideoInfo)
  {
    int i1 = 0;
    boolean bool;
    if (!paramVideoInfo.r)
    {
      bool = true;
      paramVideoInfo.r = bool;
      if (!paramVideoInfo.r) {
        break label150;
      }
      i1 = paramVideoInfo.s + 1;
    }
    for (;;)
    {
      paramVideoInfo.s = i1;
      if ((paramrxo instanceof rxy)) {
        ((rxy)paramrxo).jdField_a_of_type_Rur.d();
      }
      if ((this.jdField_a_of_type_Sab != null) && (paramVideoInfo.r)) {
        this.jdField_a_of_type_Sab.a((float)(bgln.i() / 2L), (float)(bgln.j() / 2L));
      }
      if (this.jdField_a_of_type_Sbk != null) {
        this.jdField_a_of_type_Sbk.a(3, paramVideoInfo, 0L);
      }
      if ((this.jdField_a_of_type_Rxn != null) && (!paramVideoInfo.jdField_c_of_type_Boolean)) {
        this.jdField_a_of_type_Rxn.a(paramVideoInfo, paramVideoInfo.r);
      }
      h(paramVideoInfo);
      return;
      bool = false;
      break;
      label150:
      if (paramVideoInfo.s > 0) {
        i1 = paramVideoInfo.s - 1;
      }
    }
  }
  
  private void c(rxo paramrxo, VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo)
  {
    if ((paramrxo instanceof rxl))
    {
      if (!a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo)) {
        break label90;
      }
      a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
      nxw.a(new omp().a(this.jdField_a_of_type_AndroidContentContext).a(nxw.L).b(nxw.P).a(paramAdvertisementInfo).a());
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Rxq != null) && (this.jdField_a_of_type_Rxq.jdField_a_of_type_Sar != null)) {
        oqj.a(this.jdField_a_of_type_Rxq.jdField_a_of_type_Sar, true);
      }
      return;
      label90:
      rxl localrxl = (rxl)paramrxo;
      paramrxo = new View[2];
      paramrxo[0] = localrxl.p;
      paramrxo[1] = localrxl.jdField_a_of_type_AndroidViewView;
      if (c(paramVideoInfo))
      {
        paramrxo = new View[1];
        paramrxo[0] = localrxl.p;
      }
      RelativeLayout localRelativeLayout = localrxl.jdField_c_of_type_AndroidWidgetRelativeLayout;
      TextView localTextView = localrxl.jdField_k_of_type_AndroidWidgetTextView;
      opr.c(localrxl.jdField_b_of_type_AndroidWidgetSeekBar);
      a(localrxl, paramVideoInfo, paramAdvertisementInfo, nxw.aa, paramrxo, new View[] { localRelativeLayout, localTextView });
    }
  }
  
  private static boolean c(VideoInfo paramVideoInfo)
  {
    return oqj.a(paramVideoInfo);
  }
  
  private void d(VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramVideoInfo.jdField_c_of_type_Boolean)
    {
      if (this.n)
      {
        this.n = false;
        oqj.a(paramAdvertisementInfo, 1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
        ubb.b(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, false, null);
        a(paramVideoInfo, nxw.at);
      }
    }
    else {
      return;
    }
    oqj.a(paramAdvertisementInfo, 4, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
    ubb.b(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, false, null);
    a(paramVideoInfo, nxw.aw);
  }
  
  private void d(rxo paramrxo, VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo)
  {
    if ((paramrxo instanceof rxl))
    {
      rxl localrxl = (rxl)paramrxo;
      opr.c(localrxl.jdField_b_of_type_AndroidWidgetSeekBar);
      a(paramrxo, paramVideoInfo, paramAdvertisementInfo, nxw.aa, localrxl.p, new View[] { localrxl.jdField_k_of_type_AndroidWidgetTextView });
    }
  }
  
  private void e(VideoInfo paramVideoInfo)
  {
    if (!TextUtils.isEmpty(paramVideoInfo.w))
    {
      RIJRedPacketManager.a().a(this.jdField_a_of_type_AndroidAppActivity, 4, paramVideoInfo.w, paramVideoInfo.g, new rxf(this), false, null);
      skb localskb = new skc(paramVideoInfo).b(paramVideoInfo).h(paramVideoInfo.g).n(1).a();
      oat.a(null, "", "0X800ABBA", "0X800ABBA", 0, 0, "", "", paramVideoInfo.g, localskb.a(), false);
    }
  }
  
  private void e(VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramVideoInfo.jdField_c_of_type_Boolean)
    {
      oqj.a(paramAdvertisementInfo, 3, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
      ubb.b(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, false, null);
      a(paramVideoInfo, nxw.av);
    }
  }
  
  private void f(VideoInfo paramVideoInfo)
  {
    if (paramVideoInfo.q) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "followPubAccount onClick() puin=" + paramVideoInfo.j + ", isFollowed=" + paramVideoInfo.q + ", pname=" + paramVideoInfo.k);
    }
    String str2 = new skc(null, paramVideoInfo.j, paramVideoInfo.jdField_a_of_type_JavaLangString, paramVideoInfo.g, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(), paramVideoInfo.a() * 1000L).a(paramVideoInfo.B).N(0).a().a();
    if (jdField_a_of_type_Boolean)
    {
      str3 = paramVideoInfo.j;
      if (!TextUtils.isEmpty(paramVideoInfo.g)) {}
      for (str1 = paramVideoInfo.g;; str1 = "0")
      {
        oat.a(null, str3, "0X800929B", "0X800929B", 0, 0, "", "", str1, str2, false);
        a(paramVideoInfo, "0X800B1A7", true, true);
        a(paramVideoInfo, "0X800B1A6", false, true);
        a(paramVideoInfo.j, paramVideoInfo.jdField_b_of_type_Boolean, paramVideoInfo.jdField_p_of_type_JavaLangString);
        return;
      }
    }
    String str3 = paramVideoInfo.j;
    if (!TextUtils.isEmpty(paramVideoInfo.g)) {}
    for (String str1 = paramVideoInfo.g;; str1 = "0")
    {
      oat.a(null, str3, "0X80078FD", "0X80078FD", 0, 0, "", "", str1, str2, false);
      break;
    }
  }
  
  private void f(VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramVideoInfo.jdField_c_of_type_Boolean)
    {
      oqj.a(paramAdvertisementInfo, 2, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
      ubb.b(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, false, null);
      a(paramVideoInfo, nxw.au);
    }
  }
  
  private void g(VideoInfo paramVideoInfo)
  {
    if ((this.jdField_a_of_type_Rxq.jdField_a_of_type_Sar == null) || (paramVideoInfo == null)) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.a(false);
    } while (TextUtils.isEmpty(paramVideoInfo.g));
    sjo.a(this.jdField_a_of_type_AndroidAppActivity, rup.a(paramVideoInfo), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(paramVideoInfo.g), 2, 0);
    sjo.a(paramVideoInfo.g, 2, 0);
  }
  
  private void g(VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramVideoInfo.jdField_c_of_type_Boolean)
    {
      oqj.a(paramAdvertisementInfo, 2, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
      ubb.b(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, false, null);
      a(paramVideoInfo, nxw.au);
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
    this.jdField_a_of_type_AndroidOsHandler.post(new VideoFeedsAdapter.16(this, paramBoolean));
  }
  
  private void h()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(2, null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.b(false);
  }
  
  private void h(VideoInfo paramVideoInfo)
  {
    int i2 = 1;
    if (paramVideoInfo == null) {
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("channel_id", 409409);
      if (!paramVideoInfo.r) {
        break label269;
      }
      i1 = 0;
      localJSONObject.put("type", i1);
      if (paramVideoInfo.B == null) {
        break label274;
      }
      str1 = paramVideoInfo.B;
      label60:
      localJSONObject.put("video_report_info", str1);
      if (!paramVideoInfo.r) {
        break label103;
      }
      if (this.jdField_a_of_type_Sab == null) {
        break label322;
      }
      i1 = this.jdField_a_of_type_Sab.a();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str1;
        label103:
        String str2;
        label132:
        label162:
        label183:
        label206:
        String str4;
        String str3;
        label269:
        label274:
        label290:
        label295:
        label303:
        label309:
        continue;
        int i1 = 0;
      }
    }
    localJSONObject.put("style", i1);
    localJSONObject.put("algorithm_id", paramVideoInfo.f);
    if (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LikeActionDownloadBar != null)
    {
      str1 = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LikeActionDownloadBar.jdField_c_of_type_JavaLangString;
      localJSONObject.put("common_data", str1);
      localJSONObject.put("video_type", 0);
      if (!this.s) {
        break label290;
      }
      i1 = i2;
      localJSONObject.put("interact_button_style", i1);
      if (!jdField_a_of_type_Boolean) {
        break label295;
      }
      str1 = "0X800929C";
      if ((paramVideoInfo.jdField_a_of_type_Int != 0) || (paramVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null)) {
        break label303;
      }
      str2 = paramVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5();
      str4 = paramVideoInfo.j;
      if (TextUtils.isEmpty(paramVideoInfo.g)) {
        break label309;
      }
    }
    for (str3 = paramVideoInfo.g;; str3 = "0")
    {
      oat.a(null, str4, str1, str1, 0, 0, "0", "0", str3, och.a(str2, paramVideoInfo.j, paramVideoInfo.jdField_a_of_type_JavaLangString, paramVideoInfo.g, localJSONObject), false);
      return;
      i1 = 1;
      break;
      str1 = "";
      break label60;
      str1 = "";
      break label132;
      i1 = 0;
      break label162;
      str1 = "0X80091A9";
      break label183;
      str2 = null;
      break label206;
    }
  }
  
  private void h(VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramVideoInfo.jdField_c_of_type_Boolean)
    {
      oqj.a(paramAdvertisementInfo, 1000, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
      ubb.b(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, false, null);
      a(paramVideoInfo, nxw.aC);
    }
  }
  
  private void i()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr = new VideoPreDownloadMgr(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a = new sfl(sfl.jdField_c_of_type_Int, sfl.jdField_f_of_type_Int);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a(new rxb(this));
  }
  
  private void i(VideoInfo paramVideoInfo)
  {
    ThreadManager.excute(new VideoFeedsAdapter.9(this, paramVideoInfo), 16, null, true);
  }
  
  private void i(VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramVideoInfo.jdField_c_of_type_Boolean)
    {
      ubb.b(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, true, null);
      a(paramVideoInfo, 0);
    }
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
  
  private void j(VideoInfo paramVideoInfo)
  {
    if ((paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo != null) && (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_e_of_type_Int == 1)) {
      oat.a(null, "", "0X800AC2B", "0X800AC2B", 0, 0, "3", "", "", new skc(paramVideoInfo).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo).N(0).a().a(), false);
    }
  }
  
  private void j(VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo)
  {
    if ((paramVideoInfo.jdField_a_of_type_Int == 0) && (paramVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null)) {}
    for (String str = paramVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5();; str = null)
    {
      if ((this.jdField_a_of_type_Ryd != null) && (paramVideoInfo.a(this.jdField_a_of_type_AndroidAppActivity))) {
        this.jdField_a_of_type_Ryd.h();
      }
      if (!paramVideoInfo.jdField_c_of_type_Boolean) {
        break;
      }
      ubb.b(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, true, null);
      a(paramVideoInfo, 0);
      return;
    }
    if ((paramVideoInfo.C != null) && (!paramVideoInfo.C.equals("")))
    {
      pha.a(this.jdField_a_of_type_AndroidAppActivity, paramVideoInfo.C);
      return;
    }
    paramAdvertisementInfo = ReadInJoyUserInfoModule.a(Long.parseLong(paramVideoInfo.j), null);
    if (((this.jdField_a_of_type_Rxq instanceof rxv)) && (((rxv)this.jdField_a_of_type_Rxq).b.getVisibility() == 0) && (paramAdvertisementInfo != null) && (!TextUtils.isEmpty(paramAdvertisementInfo.getLiveUrl())))
    {
      pha.a(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo.getLiveUrl());
      a(paramVideoInfo, "0X800B17E");
      paramAdvertisementInfo = new skc(str, paramVideoInfo.j, paramVideoInfo.jdField_a_of_type_JavaLangString, paramVideoInfo.g, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(), paramVideoInfo.a() * 1000L).a(-1).N(0).a().a();
      str = paramVideoInfo.j;
      if (TextUtils.isEmpty(paramVideoInfo.g)) {
        break label401;
      }
    }
    label401:
    for (paramVideoInfo = paramVideoInfo.g;; paramVideoInfo = "0")
    {
      oat.a(null, str, "0X8007410", "0X8007410", 0, 0, "0", "", paramVideoInfo, paramAdvertisementInfo, false);
      return;
      if (paramVideoInfo.jdField_p_of_type_Boolean)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "onClick: video unowned");
        break;
      }
      if (paramVideoInfo.jdField_a_of_type_Int == 6)
      {
        if (TextUtils.isEmpty(paramVideoInfo.j)) {
          break;
        }
        paramAdvertisementInfo = pgc.g + bgku.encodeToString(paramVideoInfo.j.getBytes(), 2);
        pha.a(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo);
        break;
      }
      if ((TextUtils.isEmpty(paramVideoInfo.j)) || (paramVideoInfo.j.equals("16888"))) {
        break;
      }
      a(paramVideoInfo.j, paramVideoInfo.g);
      break;
    }
  }
  
  private void k(VideoInfo paramVideoInfo)
  {
    if (paramVideoInfo.jdField_a_of_type_JavaUtilArrayList != null)
    {
      int i1 = 0;
      if (i1 < paramVideoInfo.jdField_a_of_type_JavaUtilArrayList.size())
      {
        Object localObject = (VideoInfo.ChannelInfo)paramVideoInfo.jdField_a_of_type_JavaUtilArrayList.get(i1);
        localObject = new skc("", "", paramVideoInfo.jdField_a_of_type_JavaLangString, paramVideoInfo.g).t(((VideoInfo.ChannelInfo)localObject).jdField_a_of_type_Int).u(ryx.a((VideoInfo.ChannelInfo)localObject)).a(paramVideoInfo.B).a().a();
        if (jdField_a_of_type_Boolean) {
          oat.a(null, "", "0X8009330", "0X8009330", 0, 0, "3", "", "", (String)localObject, false);
        }
        for (;;)
        {
          i1 += 1;
          break;
          oat.a(null, "", "0X80092F8", "0X80092F8", 0, 0, "3", "", "", (String)localObject, false);
        }
      }
    }
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
          if (paramString.equals(localVideoInfo.g)) {
            break;
          }
        } while (localVideoInfo.jdField_d_of_type_JavaUtilArrayList == null);
        localObject = localVideoInfo.jdField_d_of_type_JavaUtilArrayList.iterator();
      }
      localVideoInfo = (VideoInfo)((Iterator)localObject).next();
    } while (!paramString.equals(localVideoInfo.g));
    return localVideoInfo;
    label103:
    return null;
  }
  
  public rxo a(ViewGroup paramViewGroup, int paramInt)
  {
    Object localObject1 = LayoutInflater.from(paramViewGroup.getContext());
    Object localObject3;
    switch (paramInt)
    {
    case 3: 
    default: 
      localObject3 = null;
      paramViewGroup = null;
      localObject1 = null;
      if (paramViewGroup != null)
      {
        paramViewGroup.jdField_a_of_type_Rur = ((rur)localObject3);
        paramViewGroup.jdField_a_of_type_Sek = new sek(paramViewGroup, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager, this.jdField_f_of_type_Boolean);
        return paramViewGroup;
      }
      break;
    case 2: 
      localObject1 = sby.a(2131560310, true, new ViewGroup.LayoutParams(-1, -1));
      paramViewGroup = (rxv)((View)localObject1).getTag();
      if (paramViewGroup == null) {
        paramViewGroup = new rxv((View)localObject1);
      }
      break;
    }
    for (;;)
    {
      for (;;)
      {
        localObject3 = new rxu(this, (rxv)paramViewGroup);
        try
        {
          paramInt = bqcd.b(this.jdField_a_of_type_AndroidAppActivity);
          if ((bqcd.b()) && (paramInt > 0) && (((rxv)paramViewGroup).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsUGView != null))
          {
            localObject1 = (View)((rxv)paramViewGroup).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsUGView.getParent();
            ((View)localObject1).setPadding(((View)localObject1).getPaddingLeft(), paramInt + ((View)localObject1).getPaddingTop(), ((View)localObject1).getPaddingRight(), ((View)localObject1).getPaddingBottom());
          }
          localObject1 = null;
        }
        catch (Exception localException1)
        {
          localView = null;
        }
      }
      break;
      View localView = sby.a(2131560324, true, new ViewGroup.LayoutParams(-1, -1));
      paramViewGroup = (rxv)localView.getTag();
      if (paramViewGroup == null) {
        paramViewGroup = new rxx(localView);
      }
      for (;;)
      {
        for (;;)
        {
          localObject3 = new rxw(this, (rxx)paramViewGroup);
          try
          {
            paramInt = bqcd.b(this.jdField_a_of_type_AndroidAppActivity);
            if ((bqcd.b()) && (paramInt > 0) && (((rxv)paramViewGroup).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsUGView != null))
            {
              localView = (View)((rxv)paramViewGroup).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsUGView.getParent();
              localView.setPadding(localView.getPaddingLeft(), paramInt + localView.getPaddingTop(), localView.getPaddingRight(), localView.getPaddingBottom());
            }
            localView = null;
          }
          catch (Exception localException2)
          {
            localException2.printStackTrace();
            localObject2 = null;
          }
        }
        break;
        paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560301, paramViewGroup, false);
        if (!this.s) {
          ((LayoutInflater)localObject2).inflate(2131560335, (ViewGroup)paramViewGroup.findViewById(2131364830), true);
        }
        ((LayoutInflater)localObject2).inflate(2131560330, (ViewGroup)paramViewGroup.findViewById(2131364828), true);
        ((LayoutInflater)localObject2).inflate(2131560332, (ViewGroup)paramViewGroup.findViewById(2131364826), true);
        paramViewGroup = new rxl(paramViewGroup, paramInt);
        localObject3 = new rxg(this, (rxl)paramViewGroup);
        Object localObject2 = null;
        break;
        localObject3 = sby.a(2131560306, true, new ViewGroup.LayoutParams(-1, -1));
        localObject2 = (rxt)((View)localObject3).getTag();
        paramViewGroup = (ViewGroup)localObject2;
        if (localObject2 == null) {
          paramViewGroup = new rxt((View)localObject3, paramInt);
        }
        this.jdField_a_of_type_Rxt = paramViewGroup;
        localObject3 = null;
        localObject2 = paramViewGroup;
        paramViewGroup = null;
        break;
        return localObject2;
      }
    }
  }
  
  public void a()
  {
    int i1 = this.jdField_a_of_type_JavaUtilList.size();
    int i2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.c();
    RecyclerView.ViewHolder localViewHolder = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.findViewHolderForLayoutPosition(i1 + i2 - 1);
    if ((localViewHolder instanceof rxt)) {
      a((rxt)localViewHolder);
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
    if ((this.jdField_a_of_type_Ryd != null) && (this.jdField_a_of_type_Ryd.a()) && (this.jdField_a_of_type_Ryd.b()))
    {
      this.jdField_a_of_type_Ryd.h();
      break label34;
    }
    for (;;)
    {
      label34:
      return;
      if (!this.v) {
        continue;
      }
      paramView = (rxq)paramView.getTag();
      if (paramView != this.jdField_a_of_type_Rxq)
      {
        if (this.jdField_a_of_type_Rxq == null) {
          break;
        }
        if ((paramView != null) && (paramView.jdField_c_of_type_Int == this.jdField_a_of_type_Rxq.jdField_c_of_type_Int + 1) && (paramView.jdField_c_of_type_Int != getItemCount()))
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.a();
          return;
        }
        if ((paramView == null) || (paramView.jdField_c_of_type_Int != this.jdField_a_of_type_Rxq.jdField_c_of_type_Int - 1)) {
          break;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.b();
        return;
      }
      paramView.jdField_a_of_type_Rur.c();
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
          oat.a(null, null, "0X80091AB", "0X80091AB", 0, 0, "", "", "", och.a(null, null, paramView.jdField_a_of_type_Sar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, paramView.jdField_a_of_type_Sar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g, localJSONObject), false);
          return;
          if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager == null) || (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.d())) {
            continue;
          }
          localJSONObject = new JSONObject();
          try
          {
            localJSONObject.put("channel_id", 409409);
            label307:
            oat.a(null, null, "0X80091AB", "0X80091AB", 0, 0, "", "", "", och.a(null, null, paramView.jdField_a_of_type_Sar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, paramView.jdField_a_of_type_Sar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g, localJSONObject), false);
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
    paramView = (rxy)paramView.getTag();
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
        paramView.jdField_a_of_type_Rur.a(1);
        this.t = false;
        return;
      } while (paramView.jdField_d_of_type_AndroidViewViewGroup.getVisibility() != 0);
      paramView.jdField_a_of_type_Rur.a(2);
    } while (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.b());
    this.t = true;
  }
  
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    int i2 = 1;
    rxy localrxy = (rxy)paramView.getTag();
    if (localrxy != this.jdField_a_of_type_Rxq) {}
    while ((!this.v) || (localrxy == null) || (localrxy.jdField_a_of_type_Sar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == null) || (!(localrxy instanceof rxq)) || (TextUtils.isEmpty(localrxy.jdField_a_of_type_Sar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g))) {
      return;
    }
    Object localObject = localrxy.jdField_a_of_type_Sar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
    boolean bool;
    int i1;
    label111:
    JSONObject localJSONObject;
    if (!((VideoInfo)localObject).r)
    {
      bool = true;
      ((VideoInfo)localObject).r = true;
      if (!bool) {
        break label477;
      }
      i1 = ((VideoInfo)localObject).s + 1;
      ((VideoInfo)localObject).s = i1;
      localrxy.jdField_a_of_type_Rur.a(paramInt1, paramInt2, bool);
      if (bool)
      {
        if (this.jdField_a_of_type_Rxn != null) {
          this.jdField_a_of_type_Rxn.a((VideoInfo)localObject, ((VideoInfo)localObject).r);
        }
        h((VideoInfo)localObject);
      }
      if (this.jdField_a_of_type_Sbk != null) {
        this.jdField_a_of_type_Sbk.a(3, (VideoInfo)localObject, 0L);
      }
      localJSONObject = new JSONObject();
      if ((localrxy.jdField_a_of_type_Sar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int != 0) || (localrxy.jdField_a_of_type_Sar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null)) {
        break label487;
      }
      paramView = localrxy.jdField_a_of_type_Sar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5();
    }
    try
    {
      label236:
      localJSONObject.put("channel_id", 409409);
      localJSONObject.put("rowkey", localrxy.jdField_a_of_type_Sar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g);
      if (this.jdField_a_of_type_Sab == null) {
        break label492;
      }
      paramInt1 = this.jdField_a_of_type_Sab.a();
      label283:
      localJSONObject.put("style", paramInt1);
      localJSONObject.put("algorithm_id", ((VideoInfo)localObject).f);
      if (((VideoInfo)localObject).jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LikeActionDownloadBar == null) {
        break label497;
      }
      localObject = ((VideoInfo)localObject).jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LikeActionDownloadBar.jdField_c_of_type_JavaLangString;
      label325:
      localJSONObject.put("common_data", localObject);
      if (!this.s) {
        break label505;
      }
      paramInt1 = i2;
      label346:
      localJSONObject.put("interact_button_style", paramInt1);
    }
    catch (Exception localException)
    {
      label356:
      label367:
      String str2;
      String str1;
      break label356;
    }
    if (jdField_a_of_type_Boolean)
    {
      localObject = "0X80097F5";
      str2 = localrxy.jdField_a_of_type_Sar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.j;
      if (TextUtils.isEmpty(localrxy.jdField_a_of_type_Sar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g)) {
        break label518;
      }
    }
    label518:
    for (str1 = localrxy.jdField_a_of_type_Sar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g;; str1 = "0")
    {
      oat.a(null, str2, (String)localObject, (String)localObject, 0, 0, "0", "0", str1, och.a(paramView, localrxy.jdField_a_of_type_Sar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.j, localrxy.jdField_a_of_type_Sar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, localrxy.jdField_a_of_type_Sar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g, localJSONObject), false);
      return;
      bool = false;
      break;
      label477:
      i1 = ((VideoInfo)localObject).s;
      break label111;
      label487:
      paramView = null;
      break label236;
      label492:
      paramInt1 = 0;
      break label283;
      label497:
      localObject = "";
      break label325;
      label505:
      paramInt1 = 0;
      break label346;
      localObject = "0X80091AA";
      break label367;
    }
  }
  
  public void a(VideoInfo paramVideoInfo)
  {
    if ((paramVideoInfo != null) && (this.jdField_a_of_type_Skc != null))
    {
      this.jdField_a_of_type_Skc.a(paramVideoInfo.B);
      a(paramVideoInfo, this.jdField_a_of_type_Skc);
      this.jdField_a_of_type_Skc = null;
    }
  }
  
  public void a(ADVideoAppDownloadManager paramADVideoAppDownloadManager)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdVideoADVideoAppDownloadManager = paramADVideoAppDownloadManager;
  }
  
  public void a(VideoFeedsPlayManager paramVideoFeedsPlayManager)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager = paramVideoFeedsPlayManager;
    i();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(new rxa(this));
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
      if ((paramList instanceof rxy)) {
        ((rxy)paramList).jdField_a_of_type_Rur.a();
      }
      i1 += 1;
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_d_of_type_JavaLangString = paramString;
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (this.jdField_a_of_type_AndroidAppActivity == null)) {
      return;
    }
    paramString1 = pgc.k + bgku.encodeToString(String.valueOf(paramString1).getBytes(), 2) + "&rowkey=" + paramString2;
    pha.a(this.jdField_a_of_type_AndroidAppActivity, paramString1);
  }
  
  public void a(List<VideoInfo> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void a(omz paramomz)
  {
    this.jdField_a_of_type_Omz = paramomz;
  }
  
  public void a(org paramorg)
  {
    this.jdField_a_of_type_Org = paramorg;
  }
  
  public void a(orj paramorj)
  {
    this.jdField_a_of_type_Orj = paramorj;
  }
  
  public void a(rvx paramrvx)
  {
    this.jdField_a_of_type_Rvx = paramrvx;
  }
  
  public void a(rxn paramrxn)
  {
    this.jdField_a_of_type_Rxn = paramrxn;
  }
  
  public void a(rxo paramrxo, int paramInt)
  {
    paramrxo.jdField_b_of_type_Int = paramInt;
    paramrxo.jdField_c_of_type_Int = paramInt;
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size()))
    {
      if (this.jdField_a_of_type_Orj != null)
      {
        VideoInfo localVideoInfo = this.jdField_a_of_type_Orj.b(paramInt);
        if (localVideoInfo != null) {
          this.jdField_a_of_type_JavaUtilList.set(paramInt, localVideoInfo);
        }
      }
      a(paramrxo, (VideoInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt));
    }
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramrxo, paramInt, getItemId(paramInt));
      return;
      a(paramrxo, null);
    }
  }
  
  public void a(rxo paramrxo, VideoInfo paramVideoInfo)
  {
    int i1 = paramrxo.jdField_a_of_type_Int;
    if ((i1 == 3) || (i1 == 6))
    {
      a((rxt)paramrxo);
      this.jdField_a_of_type_Rxt = ((rxt)paramrxo);
      return;
    }
    paramrxo = (rxq)paramrxo;
    b(paramrxo);
    a(paramrxo, paramVideoInfo);
    TraceCompat.beginSection("refreshMenuUI");
    paramrxo.jdField_a_of_type_Rur.a(paramVideoInfo);
    TraceCompat.endSection();
    TraceCompat.beginSection("refreshContentUI");
    paramrxo.jdField_a_of_type_Rur.a(paramVideoInfo, this.jdField_d_of_type_Boolean);
    if (!TextUtils.isEmpty(paramVideoInfo.j))
    {
      ReadInJoyUserInfo localReadInJoyUserInfo = ReadInJoyUserInfoModule.a(Long.parseLong(paramVideoInfo.j), null);
      if ((localReadInJoyUserInfo != null) && (localReadInJoyUserInfo.isReadlTimeRead())) {
        ReadInJoyUserInfoModule.a(Long.parseLong(paramVideoInfo.j), this, true);
      }
    }
    TraceCompat.endSection();
    if ((this.h) && (paramrxo == this.jdField_a_of_type_Rxq)) {
      paramrxo.jdField_a_of_type_Rur.f(this.h);
    }
    a(paramrxo);
  }
  
  public void a(rxy paramrxy)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsPlayManager.preplay", 2, "adapter playVideo (VideoItemHolder holder) ");
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(2, null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.d();
    int i1;
    boolean bool;
    label116:
    long l1;
    label138:
    label155:
    long l2;
    if (this.jdField_a_of_type_Rxq != null)
    {
      i1 = this.jdField_a_of_type_Rxq.jdField_c_of_type_Int;
      this.jdField_a_of_type_Rxq = paramrxy;
      if ((this.jdField_a_of_type_Rxq.jdField_c_of_type_Int != 0) || (this.jdField_a_of_type_Rxq.jdField_b_of_type_Int != 0) || (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString))) {
        break label292;
      }
      paramrxy.jdField_a_of_type_Sar.jdField_a_of_type_Long = this.jdField_c_of_type_Long;
      this.jdField_c_of_type_Long = 0L;
      sar localsar = paramrxy.jdField_a_of_type_Sar;
      if (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
        break label287;
      }
      bool = true;
      localsar.jdField_c_of_type_Boolean = bool;
      paramrxy.jdField_a_of_type_Sar.jdField_a_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
      this.jdField_d_of_type_JavaLangString = null;
      if ((this.jdField_g_of_type_Boolean) && (!a(paramrxy))) {
        break label311;
      }
      bool = true;
      this.jdField_g_of_type_Boolean = false;
      l1 = System.currentTimeMillis();
      l2 = this.jdField_b_of_type_Long;
      paramrxy.jdField_a_of_type_Sar.jdField_a_of_type_AndroidOsBundle.putBoolean("is_auto_play", bool);
      if (!bool) {
        break label331;
      }
      if ((this.jdField_a_of_type_Int != 124) || (!this.jdField_a_of_type_Rxq.jdField_a_of_type_Sar.jdField_c_of_type_Boolean) || (Build.VERSION.SDK_INT < 16)) {
        break label316;
      }
      a(paramrxy.jdField_a_of_type_Sar);
    }
    for (;;)
    {
      a(paramrxy, bool, l1 - l2, i1);
      if ((paramrxy.jdField_a_of_type_Sar != null) && (paramrxy.jdField_a_of_type_Sar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null)) {
        tzo.a(paramrxy.jdField_a_of_type_Sar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g, paramrxy.jdField_a_of_type_Sar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, 0, 0);
      }
      return;
      i1 = -1;
      break;
      label287:
      bool = false;
      break label116;
      label292:
      paramrxy.jdField_a_of_type_Sar.jdField_a_of_type_JavaLangString = null;
      paramrxy.jdField_a_of_type_Sar.jdField_c_of_type_Boolean = false;
      break label138;
      label311:
      bool = false;
      break label155;
      label316:
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(paramrxy.jdField_a_of_type_Sar, false);
      continue;
      label331:
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(paramrxy.jdField_a_of_type_Sar);
    }
  }
  
  public void a(ryd paramryd)
  {
    this.jdField_a_of_type_Ryd = paramryd;
  }
  
  public void a(sab paramsab)
  {
    this.jdField_a_of_type_Sab = paramsab;
  }
  
  public void a(sbk paramsbk)
  {
    this.jdField_a_of_type_Sbk = paramsbk;
  }
  
  public void a(sdq paramsdq)
  {
    this.jdField_a_of_type_Sdq = paramsdq;
  }
  
  public void a(sdu paramsdu)
  {
    this.jdField_a_of_type_Sdu = paramsdu;
  }
  
  public void a(see paramsee)
  {
    this.jdField_a_of_type_See = paramsee;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public boolean a(VideoInfo paramVideoInfo)
  {
    return (this.jdField_a_of_type_Rxq == null) || (this.jdField_a_of_type_Rxq.jdField_a_of_type_Sar == null) || (this.jdField_a_of_type_Rxq.jdField_a_of_type_Sar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == paramVideoInfo);
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
        } while (localVideoInfo.jdField_d_of_type_JavaUtilArrayList == null);
        localObject = localVideoInfo.jdField_d_of_type_JavaUtilArrayList.iterator();
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
    this.jdField_c_of_type_Boolean = false;
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(2, null);
    }
    ApngImage.pauseByTag(28);
    ApngImage.pauseByTag(29);
    ApngImage.pauseByTag(30);
    if (paramInt == 1) {
      opx.c(this.jdField_a_of_type_AndroidAppActivity);
    }
  }
  
  public void b(View paramView) {}
  
  public void b(VideoInfo paramVideoInfo)
  {
    a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView, this.jdField_a_of_type_JavaUtilList, paramVideoInfo);
  }
  
  public void b(String paramString)
  {
    a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView, this.jdField_a_of_type_JavaUtilList, paramString);
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
      if (((localObject instanceof rxy)) && (((rxy)localObject).jdField_c_of_type_Int == this.jdField_a_of_type_Rxq.jdField_c_of_type_Int + 1))
      {
        localObject = ((rxy)localObject).jdField_a_of_type_Sar;
        if ((localObject != null) && ((((sar)localObject).jdField_a_of_type_Boolean) || ((((sar)localObject).jdField_a_of_type_Sfb != null) && (!((sar)localObject).jdField_a_of_type_Sfb.a()))))
        {
          ((sar)localObject).jdField_a_of_type_Boolean = false;
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.c((sar)localObject);
        }
      }
      i1 += 1;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.d();
    }
  }
  
  public void c(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
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
  
  public void d(VideoInfo paramVideoInfo)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.contains(paramVideoInfo)))
    {
      int i1 = this.jdField_a_of_type_JavaUtilList.indexOf(paramVideoInfo);
      h();
      this.jdField_a_of_type_JavaUtilList.remove(paramVideoInfo);
      this.jdField_a_of_type_Rxq = null;
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
    ubb.a(this);
    if ((this.jdField_a_of_type_Rxq != null) && (this.jdField_a_of_type_Rxq.jdField_a_of_type_Rur != null) && ((this.jdField_a_of_type_Rxq.jdField_a_of_type_Rur instanceof rxg))) {
      ((rxg)this.jdField_a_of_type_Rxq.jdField_a_of_type_Rur).e();
    }
    ApngImage.playByTag(28);
    ApngImage.playByTag(29);
    ApngImage.playByTag(30);
    opx.d();
    oqj.a(this.jdField_a_of_type_Org, this, (rxy)this.jdField_a_of_type_Rxq);
  }
  
  public void e(boolean paramBoolean)
  {
    if ((!this.o) && (paramBoolean) && (this.jdField_p_of_type_Boolean))
    {
      if ((this.jdField_a_of_type_Rxq instanceof rxy)) {
        a((rxy)this.jdField_a_of_type_Rxq);
      }
      this.jdField_p_of_type_Boolean = false;
    }
    this.o = paramBoolean;
  }
  
  public void f()
  {
    if ((this.jdField_a_of_type_Skc != null) && (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null)) {
      ThreadManager.excute(new VideoFeedsAdapter.13(this), 16, null, true);
    }
    if (this.jdField_a_of_type_Rxn != null) {
      this.jdField_a_of_type_Rxn = null;
    }
    if (this.jdField_a_of_type_Rxq != null) {
      this.jdField_a_of_type_Rxq.jdField_b_of_type_ComTencentImageURLImageView = null;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidOsHandler = null;
    this.jdField_a_of_type_Bkni = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    if (this.jdField_a_of_type_Oop != null) {
      this.jdField_a_of_type_Oop.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler != null) {
      AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    }
    if (this.jdField_a_of_type_Rvv != null)
    {
      this.jdField_a_of_type_Rvv.b();
      this.jdField_a_of_type_Rvv = null;
    }
    opx.e();
    bisa.a().b(VideoFeedsUGView.a);
    if (this.jdField_a_of_type_Rxy != null)
    {
      a(this.jdField_a_of_type_Rxy.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsUGView, false);
      a(this.jdField_a_of_type_Rxy.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsUGView, false);
    }
  }
  
  public void f(boolean paramBoolean) {}
  
  public void g()
  {
    if ((this.jdField_a_of_type_Rxq == null) || (this.jdField_a_of_type_Rxq.jdField_a_of_type_Sar == null) || (this.jdField_a_of_type_Rxq.jdField_a_of_type_Sar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == null) || (this.jdField_a_of_type_Rxq.jdField_a_of_type_Sar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_b_of_type_Long <= 0L)) {
      return;
    }
    String str = anni.a(2131714848);
    this.jdField_a_of_type_Rxq.jdField_a_of_type_Sjn.a(0, str, "点击重试");
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
    if ((this.jdField_a_of_type_Rxt != null) && (this.jdField_a_of_type_Rxt.itemView != null)) {
      return this.jdField_a_of_type_Rxt.itemView.hashCode();
    }
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size()))
    {
      VideoInfo localVideoInfo = (VideoInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if (localVideoInfo.jdField_c_of_type_Boolean)
      {
        if (localVideoInfo.i == 1) {
          return 7;
        }
      }
      else
      {
        if (this.s) {
          return 8;
        }
        return 2;
      }
    }
    return 6;
  }
  
  @TargetApi(11)
  public void onClick(View paramView)
  {
    rxo localrxo = (rxo)paramView.getTag();
    Object localObject = null;
    if ((localrxo instanceof rxy))
    {
      VideoInfo localVideoInfo = ((rxy)localrxo).jdField_a_of_type_Sar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
      if ((this.jdField_a_of_type_Rxq != null) && (this.jdField_a_of_type_Rxq.jdField_a_of_type_Sar != null))
      {
        localObject = localVideoInfo;
        if (localVideoInfo == this.jdField_a_of_type_Rxq.jdField_a_of_type_Sar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo) {
          break label72;
        }
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label72:
      if (localObject != null)
      {
        c(paramView, localrxo, localObject);
        b(paramView, localrxo, localObject);
        a(paramView, localrxo, localObject);
      }
    }
  }
  
  public void onLoadUserInfoFailed(String paramString1, String paramString2) {}
  
  public void onLoadUserInfoSucceed(String paramString, ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    if (paramReadInJoyUserInfo != null) {
      ryx.a(new VideoFeedsAdapter.12(this, paramString));
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    rxo localrxo = (rxo)paramView.getTag();
    VideoInfo localVideoInfo = null;
    if ((localrxo instanceof rxy))
    {
      localVideoInfo = ((rxy)localrxo).jdField_a_of_type_Sar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
      if ((this.jdField_a_of_type_Rxq != null) && (this.jdField_a_of_type_Rxq.jdField_a_of_type_Sar != null) && (localVideoInfo == this.jdField_a_of_type_Rxq.jdField_a_of_type_Sar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo)) {}
    }
    while (localVideoInfo == null) {
      return false;
    }
    switch (paramView.getId())
    {
    default: 
      return false;
    }
    if (ouh.b() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      a(localVideoInfo, true, bool);
      if (this.jdField_a_of_type_Sbk != null) {
        this.jdField_a_of_type_Sbk.a(2, localVideoInfo, 0L);
      }
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rwy
 * JD-Core Version:    0.7.0.1
 */