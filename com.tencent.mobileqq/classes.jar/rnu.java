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
import com.tencent.biz.pubaccount.VideoInfo.LikeActionDownloadBar;
import com.tencent.biz.pubaccount.readinjoy.biu.ReadInJoyDeliverBiuActivity;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter.11;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter.12;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter.15;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter.2;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter.5;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter.8;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsUGView;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.ADVideoAppDownloadManager;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.tencent.mobileqq.richmedia.capture.util.LiuHaiUtils;
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

public class rnu
  extends RecyclerView.Adapter<roj>
  implements View.OnClickListener, View.OnLongClickListener, pql, rpj, rsi, rzd
{
  private static boolean jdField_a_of_type_Boolean;
  private int jdField_a_of_type_Int;
  public long a;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Context jdField_a_of_type_AndroidContentContext;
  private ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private Handler jdField_a_of_type_AndroidOsHandler = new rnz(this, Looper.getMainLooper());
  private LinearLayoutManager jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager;
  private RecyclerView.RecycledViewPool jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$RecycledViewPool = new RecyclerView.RecycledViewPool();
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private blnb jdField_a_of_type_Blnb;
  private blol jdField_a_of_type_Blol;
  private VideoInfo jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
  private VideoFeedsPlayManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager;
  private VideoFeedsRecyclerView jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView;
  private VideoPreDownloadMgr jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr;
  private ADVideoAppDownloadManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadManager;
  public GdtHandler.Params a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private INetInfoHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new rny(this);
  private String jdField_a_of_type_JavaLangString;
  public HashMap<String, Integer> a;
  private List<VideoInfo> jdField_a_of_type_JavaUtilList;
  private Map<Integer, Bitmap> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  private rmn jdField_a_of_type_Rmn;
  private rmr jdField_a_of_type_Rmr;
  private rmt jdField_a_of_type_Rmt;
  private roi jdField_a_of_type_Roi;
  private rol jdField_a_of_type_Rol;
  roo jdField_a_of_type_Roo;
  private rot jdField_a_of_type_Rot;
  private roy jdField_a_of_type_Roy;
  private rqy jdField_a_of_type_Rqy;
  private rsg jdField_a_of_type_Rsg;
  private rsk jdField_a_of_type_Rsk;
  public rsp a;
  private rul jdField_a_of_type_Rul;
  private rup jdField_a_of_type_Rup;
  private sbg jdField_a_of_type_Sbg;
  private tmk jdField_a_of_type_Tmk;
  private toa jdField_a_of_type_Toa;
  private tqy jdField_a_of_type_Tqy;
  private trb jdField_a_of_type_Trb;
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
  
  public rnu(Context paramContext, Activity paramActivity, VideoFeedsRecyclerView paramVideoFeedsRecyclerView, LinearLayoutManager paramLinearLayoutManager, QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt, rsk paramrsk)
  {
    this.jdField_a_of_type_Long = -2147483648L;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_Rsp = new roa(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView = paramVideoFeedsRecyclerView;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.a(this.jdField_a_of_type_Rsp);
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager = paramLinearLayoutManager;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = bhmq.a(true);
    this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131165343));
    this.jdField_a_of_type_Rmn = rmn.a();
    this.jdField_a_of_type_Rmr = new rmr(paramActivity);
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_c_of_type_JavaLangString = paramString3;
    jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Blnb = new blnb(this.jdField_a_of_type_AndroidAppActivity);
    AppNetConnInfo.registerConnectionChangeReceiver(this.jdField_a_of_type_AndroidAppActivity.getApplication(), this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(1930498322);
    this.jdField_a_of_type_Rsk = paramrsk;
    setHasStableIds(true);
    registerAdapterDataObserver(new roh(this, null));
    this.r = bdgb.b();
    this.jdField_a_of_type_Toa = new toa(paramActivity, this);
    this.s = bnrf.d();
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
      paramVideoInfo = tqm.a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
      this.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params = ubd.a(this.jdField_a_of_type_AndroidAppActivity, paramVideoInfo, null, 3, false, null);
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
      return anzj.a(2131715026);
    }
    if (paramInt == 2) {
      return anzj.a(2131715023);
    }
    return null;
  }
  
  private void a(View paramView, int paramInt, VideoInfo paramVideoInfo)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.d())) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.b();
    }
    if (this.jdField_a_of_type_Toa != null) {
      this.jdField_a_of_type_Toa.a(paramView, paramInt, paramVideoInfo);
    }
  }
  
  private void a(View paramView, VideoInfo paramVideoInfo)
  {
    if ((paramVideoInfo.jdField_c_of_type_Boolean) && ((this.jdField_a_of_type_Rol instanceof rog))) {
      a(paramView, (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(), paramVideoInfo);
    }
  }
  
  private void a(View paramView, roj paramroj, VideoInfo paramVideoInfo)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      b(paramView, paramVideoInfo);
      return;
      f(paramVideoInfo);
      return;
      a(paramroj);
      return;
    } while ((this.jdField_a_of_type_Rol == null) || (this.jdField_a_of_type_Rol.l == null));
    this.jdField_a_of_type_Rsk.e();
    b(this.jdField_a_of_type_Rol.jdField_a_of_type_Rrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo, "0X8009F42");
  }
  
  private void a(View paramView, roj paramroj, VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131367770: 
      do
      {
        return;
        this.jdField_a_of_type_AndroidOsHandler.sendMessage(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(9, Boolean.valueOf(false)));
        this.j = true;
      } while (!(this.jdField_a_of_type_Rol instanceof rog));
      c((rog)this.jdField_a_of_type_Rol);
      return;
    case 2131362065: 
    case 2131367776: 
      a(paramroj, paramVideoInfo, paramAdvertisementInfo, nzq.aV);
      return;
    case 2131367781: 
      c(paramVideoInfo, paramAdvertisementInfo);
      return;
    case 2131367790: 
      b(paramVideoInfo, paramAdvertisementInfo);
      return;
    case 2131367778: 
      a(paramVideoInfo, paramAdvertisementInfo);
      return;
    case 2131367767: 
      tqa.a(paramAdvertisementInfo, 37, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
      a(paramroj, paramVideoInfo, paramAdvertisementInfo, nzq.aT);
      return;
    case 2131367765: 
      tqa.a(paramAdvertisementInfo, 34, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
      a(paramroj, paramVideoInfo, paramAdvertisementInfo, nzq.aS);
      return;
    case 2131365738: 
    case 2131367766: 
      tqa.a(paramAdvertisementInfo, 35, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
      a(paramroj, paramVideoInfo, paramAdvertisementInfo, nzq.aR);
      return;
    case 2131365742: 
      tqa.a(paramAdvertisementInfo, 2003, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
      a(paramroj, paramVideoInfo, paramAdvertisementInfo, 2003);
      return;
    case 2131362066: 
      tqa.a(paramAdvertisementInfo, 18, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
      ubd.b(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, true, null);
      paramView = nzq.a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
      nzq.a(new tlx().a(this.jdField_a_of_type_AndroidContentContext).a(nzq.jdField_a_of_type_Int).b(nzq.aa).a(paramView).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).d(1000).a());
      return;
    }
    a(paramroj, paramVideoInfo, paramAdvertisementInfo, nzq.aU);
  }
  
  private void a(VideoAdInfo paramVideoAdInfo)
  {
    paramVideoAdInfo = nzq.a(paramVideoAdInfo);
    if (paramVideoAdInfo != null) {
      ubd.a(this.jdField_a_of_type_AndroidAppActivity, paramVideoAdInfo.mPopFormH5Url, paramVideoAdInfo.mAdRl, paramVideoAdInfo.mAdTraceId);
    }
  }
  
  private void a(VideoInfo paramVideoInfo, int paramInt)
  {
    if (paramVideoInfo == null) {
      return;
    }
    AdvertisementInfo localAdvertisementInfo = nzq.a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
    if (paramVideoInfo.a(this.jdField_a_of_type_AndroidAppActivity))
    {
      nzq.a(new tlx().a(this.jdField_a_of_type_AndroidContentContext).a(nzq.jdField_a_of_type_Int).b(nzq.R).a(localAdvertisementInfo).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).d(paramInt).a());
      return;
    }
    nzq.a(new tlx().a(this.jdField_a_of_type_AndroidContentContext).a(nzq.jdField_a_of_type_Int).b(nzq.P).a(localAdvertisementInfo).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).d(paramInt).a());
  }
  
  private void a(VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo)
  {
    tqa.a(paramAdvertisementInfo, 17, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
    if (a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo))
    {
      a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
      nzq.a(new tlx().a(this.jdField_a_of_type_AndroidContentContext).a(nzq.L).b(nzq.P).a(paramAdvertisementInfo).a());
      return;
    }
    this.jdField_a_of_type_Tqy.f();
    if (paramAdvertisementInfo != null) {
      ubd.b(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, true, null);
    }
    a(paramVideoInfo, nzq.aA);
  }
  
  private void a(VideoInfo paramVideoInfo, String paramString)
  {
    sbf localsbf = new sbg(paramVideoInfo).e(paramVideoInfo.f).i(paramVideoInfo.g).a("live_circle_from_page", Integer.valueOf(2)).a();
    String str = paramVideoInfo.j;
    if (!TextUtils.isEmpty(paramVideoInfo.g)) {}
    for (paramVideoInfo = paramVideoInfo.g;; paramVideoInfo = "0")
    {
      ocd.b(null, str, paramString, paramString, 0, 0, "0", "", paramVideoInfo, localsbf.a(), false);
      return;
    }
  }
  
  private void a(VideoInfo paramVideoInfo, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i2 = 2;
    int i3 = 1;
    Object localObject2 = new sbg(paramVideoInfo).a().a("scene_type", Integer.valueOf(3)).i(paramVideoInfo.g).e(paramVideoInfo.f).c(paramVideoInfo.jdField_p_of_type_Int);
    Object localObject1;
    label84:
    int i1;
    if (paramVideoInfo.jdField_b_of_type_Boolean)
    {
      localObject1 = paramVideoInfo.j;
      localObject2 = ((sbg)localObject2).a("ugcuin", localObject1);
      if (!paramBoolean1) {
        break label187;
      }
      localObject1 = "click_type";
      if (!paramBoolean2) {
        break label195;
      }
      i1 = 2;
      label92:
      localObject1 = ((sbg)localObject2).a((String)localObject1, Integer.valueOf(i1));
      if (!paramBoolean1) {
        break label207;
      }
      if (!paramBoolean2) {
        break label201;
      }
      i1 = i3;
      label119:
      ((sbg)localObject1).a("click_type", Integer.valueOf(i1));
      localObject2 = paramVideoInfo.j;
      if (TextUtils.isEmpty(paramVideoInfo.g)) {
        break label239;
      }
    }
    label187:
    label195:
    label201:
    label207:
    label239:
    for (paramVideoInfo = paramVideoInfo.g;; paramVideoInfo = "0")
    {
      ocd.b(null, (String)localObject2, paramString, paramString, 0, 0, "0", "", paramVideoInfo, ((sbg)localObject1).a().a(), false);
      return;
      localObject1 = null;
      break;
      localObject1 = "button_type";
      break label84;
      i1 = 1;
      break label92;
      i1 = 2;
      break label119;
      if (paramBoolean2) {}
      for (i1 = i2;; i1 = 1)
      {
        ((sbg)localObject1).a("button_type", Integer.valueOf(i1));
        break;
      }
    }
  }
  
  private void a(VideoInfo paramVideoInfo, roj paramroj)
  {
    boolean bool = true;
    if ((paramVideoInfo.jdField_c_of_type_Boolean) && ((paramroj instanceof rog)))
    {
      tph.a((rog)paramroj, "暂不支持biu");
      return;
    }
    if (omu.a() == 1) {}
    for (;;)
    {
      a(paramVideoInfo, false, bool);
      if (this.jdField_a_of_type_Rsg == null) {
        break;
      }
      this.jdField_a_of_type_Rsg.a(2, paramVideoInfo, 0L);
      return;
      bool = false;
    }
  }
  
  private void a(VideoInfo paramVideoInfo, sbg paramsbg)
  {
    if (paramsbg == null) {
      return;
    }
    String str2;
    if (jdField_a_of_type_Boolean)
    {
      str2 = paramVideoInfo.j;
      if (!TextUtils.isEmpty(paramVideoInfo.g)) {}
      for (str1 = paramVideoInfo.g;; str1 = "0")
      {
        ocd.b(null, str2, "0X8009298", "0X8009298", 0, 0, "0", "", str1, paramsbg.a().a(), false);
        b(paramVideoInfo, "0X800AD00");
        if ((paramVideoInfo.jdField_d_of_type_JavaUtilArrayList == null) || (paramVideoInfo.jdField_d_of_type_JavaUtilArrayList.size() <= 0)) {
          break;
        }
        rsq.a.a(paramVideoInfo);
        return;
      }
    }
    int i1;
    if ((!TextUtils.isEmpty(paramVideoInfo.u)) && (rpt.e()))
    {
      i1 = 1;
      label122:
      paramsbg.R(i1).a(paramVideoInfo).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo).b(this.s).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo);
      str2 = paramVideoInfo.j;
      if (TextUtils.isEmpty(paramVideoInfo.g)) {
        break label213;
      }
    }
    label213:
    for (String str1 = paramVideoInfo.g;; str1 = "0")
    {
      ocd.b(null, str2, "0X8007801", "0X8007801", 0, 0, "0", "", str1, paramsbg.a().a(), false);
      break;
      i1 = 0;
      break label122;
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
      localObject1 = new sbg((String)localObject1, paramVideoInfo.j, paramVideoInfo.jdField_a_of_type_JavaLangString, paramVideoInfo.g, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(), paramVideoInfo.a() * 1000);
      ((sbg)localObject1).g(paramBoolean1).h(paramBoolean2).b(this.s);
      if (!jdField_a_of_type_Boolean)
      {
        ((sbg)localObject1).e(paramVideoInfo.f).c(paramVideoInfo.jdField_p_of_type_Int).a(-1).a(paramVideoInfo.z).M(0);
        localObject2 = new qxb();
        ((qxb)localObject2).jdField_d_of_type_Int = ((int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a());
        ((qxb)localObject2).jdField_e_of_type_Int = (paramVideoInfo.a() * 1000);
        ((qxb)localObject2).jdField_b_of_type_Int = this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
        odr.b(paramVideoInfo, this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_CHANNEL_ID", -1), 25, -1, (qxb)localObject2, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g);
      }
      localObject1 = ((sbg)localObject1).a().a();
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
      ocd.a(null, (String)localObject2, "0X8009299", "0X8009299", 0, 0, "0", "0", paramVideoInfo, (String)localObject1, false);
      return;
      localObject1 = null;
      break;
    }
    label288:
    Object localObject2 = paramVideoInfo.j;
    if (!TextUtils.isEmpty(paramVideoInfo.g)) {}
    for (paramVideoInfo = paramVideoInfo.g;; paramVideoInfo = "0")
    {
      ocd.a(null, (String)localObject2, "0X8007B89", "0X8007B89", 0, 0, "0", "0", paramVideoInfo, (String)localObject1, false);
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
      rpt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramBoolean, paramString2, false);
      paramString2 = this.jdField_a_of_type_JavaUtilList.iterator();
      paramBoolean = false;
      while (paramString2.hasNext())
      {
        Object localObject = (VideoInfo)paramString2.next();
        boolean bool = paramBoolean | a((VideoInfo)localObject, paramString1);
        paramBoolean = bool;
        if (((VideoInfo)localObject).jdField_c_of_type_JavaUtilArrayList != null)
        {
          localObject = ((VideoInfo)localObject).jdField_c_of_type_JavaUtilArrayList.iterator();
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
  
  private void a(rog paramrog)
  {
    int i1;
    Object localObject;
    if ((paramrog != null) && (paramrog.jdField_a_of_type_Rrm != null) && (paramrog.jdField_a_of_type_Rrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (paramrog.jdField_a_of_type_Rrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo != null))
    {
      i1 = tpz.d(nzq.a(paramrog.jdField_a_of_type_Rrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo));
      if (i1 != 1) {
        break label84;
      }
      paramrog = paramrog.jdField_b_of_type_AndroidViewView;
      localObject = (LinearLayout.LayoutParams)paramrog.getLayoutParams();
      if (localObject != null)
      {
        ((LinearLayout.LayoutParams)localObject).weight = 2.0F;
        paramrog.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
    label84:
    do
    {
      do
      {
        return;
      } while (i1 != 2);
      localObject = paramrog.jdField_c_of_type_AndroidViewView;
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((View)localObject).getLayoutParams();
      if (localLayoutParams != null)
      {
        localLayoutParams.weight = 0.0F;
        ((View)localObject).setLayoutParams(localLayoutParams);
      }
      paramrog = paramrog.jdField_d_of_type_AndroidViewView;
      localObject = (LinearLayout.LayoutParams)paramrog.getLayoutParams();
    } while (localObject == null);
    ((LinearLayout.LayoutParams)localObject).weight = 0.0F;
    paramrog.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  private void a(rog paramrog, VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo, int paramInt, View[] paramArrayOfView1, View[] paramArrayOfView2)
  {
    int i1 = 8;
    int i2 = 0;
    if (paramVideoInfo.jdField_c_of_type_Boolean)
    {
      i3 = paramAdvertisementInfo.clickPos;
      if ((!AdvertisementInfo.isAppAdvertisementInfo(paramAdvertisementInfo)) || (!tpz.d(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo))) {
        break label328;
      }
      if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadManager.a(paramVideoInfo)) {
        break label134;
      }
      ubd.b(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, true, null);
      if (paramInt == nzq.aa)
      {
        paramrog = nzq.a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
        nzq.a(new tlx().a(this.jdField_a_of_type_AndroidContentContext).a(nzq.jdField_a_of_type_Int).b(nzq.aa).a(paramrog).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).d(i3).a());
      }
    }
    else
    {
      return;
    }
    a(paramVideoInfo, i3);
    return;
    label134:
    tqa.a(paramAdvertisementInfo, i3, null);
    int i3 = paramArrayOfView1.length;
    i1 = 0;
    while (i1 < i3)
    {
      paramArrayOfView1[i1].setVisibility(0);
      i1 += 1;
    }
    paramrog.jdField_a_of_type_Boolean = true;
    i3 = paramArrayOfView2.length;
    i1 = i2;
    while (i1 < i3)
    {
      paramArrayOfView2[i1].setVisibility(8);
      i1 += 1;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadManager.f();
    tph.a(paramrog);
    if (paramInt == nzq.aa)
    {
      nzq.a(new tlx().a(this.jdField_a_of_type_AndroidContentContext).a(nzq.jdField_a_of_type_Int).b(nzq.am).a(paramAdvertisementInfo).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).d(paramAdvertisementInfo.clickPos).a());
      return;
    }
    nzq.a(new tlx().a(this.jdField_a_of_type_AndroidContentContext).a(nzq.jdField_a_of_type_Int).b(nzq.am).a(paramAdvertisementInfo).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).a());
    return;
    label328:
    if (paramInt == nzq.aa)
    {
      paramInt = 38;
      paramrog = nzq.a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
      nzq.a(new tlx().a(this.jdField_a_of_type_AndroidContentContext).a(nzq.jdField_a_of_type_Int).b(nzq.aa).a(paramrog).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).d(paramAdvertisementInfo.clickPos).a());
    }
    for (;;)
    {
      if (paramAdvertisementInfo != null) {
        paramAdvertisementInfo.setClickPos(paramInt);
      }
      paramrog = new tlt();
      paramrog.jdField_c_of_type_Boolean = true;
      ubd.b(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, true, paramrog);
      return;
      paramInt = i1;
      if (this.i) {
        paramInt = 13;
      }
      a(paramVideoInfo, paramInt);
    }
  }
  
  private void a(roj paramroj)
  {
    if ((paramroj.jdField_a_of_type_Int == 2) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.b())) {
      rpt.a(((rot)paramroj).jdField_d_of_type_AndroidViewViewGroup, 8, 200);
    }
    if (this.jdField_a_of_type_Rsk != null) {
      this.jdField_a_of_type_Rsk.b();
    }
  }
  
  private void a(roj paramroj, VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo)
  {
    if ((paramroj instanceof rog))
    {
      rog localrog = (rog)paramroj;
      tph.c(localrog.jdField_b_of_type_AndroidWidgetSeekBar);
      a(paramroj, paramVideoInfo, paramAdvertisementInfo, -1, localrog.jdField_a_of_type_AndroidViewView, new View[] { localrog.jdField_c_of_type_AndroidWidgetRelativeLayout });
    }
  }
  
  private void a(roj paramroj, VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo, int paramInt)
  {
    if ((paramroj == null) || (paramVideoInfo == null) || (paramAdvertisementInfo == null)) {}
    do
    {
      return;
      if ((!AdvertisementInfo.isAppAdvertisementInfo(paramAdvertisementInfo)) || (!tpz.a(paramAdvertisementInfo))) {
        break;
      }
      paramAdvertisementInfo.setClickPos(paramInt);
    } while (!(paramroj instanceof rog));
    rog localrog = (rog)paramroj;
    if ((localrog.jdField_a_of_type_Boolean) && (tpz.a(paramAdvertisementInfo)) && (localrog.p.getVisibility() == 0))
    {
      d(paramroj, paramVideoInfo, paramAdvertisementInfo);
      return;
    }
    c(paramroj, paramVideoInfo, paramAdvertisementInfo);
    return;
    paramAdvertisementInfo.setClickPos(paramInt);
    ubd.b(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, true, null);
    paramroj = nzq.a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
    nzq.a(new tlx().a(this.jdField_a_of_type_AndroidContentContext).a(nzq.jdField_a_of_type_Int).b(nzq.aa).a(paramroj).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).d(paramInt).a());
  }
  
  private void a(roj paramroj, VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo, int paramInt, View paramView, View... paramVarArgs)
  {
    int i1;
    if (paramVideoInfo.jdField_c_of_type_Boolean)
    {
      i1 = paramAdvertisementInfo.clickPos;
      if ((AdvertisementInfo.isAppAdvertisementInfo(paramAdvertisementInfo)) && (tpz.d(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo)))
      {
        if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadManager.a(paramVideoInfo)) {
          break label119;
        }
        ubd.b(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, true, null);
        if (paramInt != nzq.aa) {
          break label111;
        }
        nzq.a(new tlx().a(this.jdField_a_of_type_AndroidContentContext).a(nzq.jdField_a_of_type_Int).b(nzq.aa).a(paramAdvertisementInfo).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).d(i1).a());
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
      ((rog)paramroj).jdField_a_of_type_Boolean = true;
      if (paramVarArgs != null)
      {
        paramInt = 0;
        while (paramInt < paramVarArgs.length)
        {
          paramVarArgs[paramInt].setVisibility(8);
          paramInt += 1;
        }
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadManager.f();
    } while (!(paramroj instanceof rog));
    ((rog)paramroj).jdField_a_of_type_Boolean = true;
    tph.a((rog)paramroj);
  }
  
  private void a(rol paramrol)
  {
    if ((this.jdField_a_of_type_Rol != null) && (this.jdField_a_of_type_Rol.jdField_a_of_type_Rrm != null) && (this.jdField_a_of_type_Rol.jdField_a_of_type_Rrm.jdField_a_of_type_Rwf != null))
    {
      rwf localrwf = this.jdField_a_of_type_Rol.jdField_a_of_type_Rrm.jdField_a_of_type_Rwf;
      if ((!localrwf.a()) && (!localrwf.b()) && (!localrwf.c()) && (this.jdField_a_of_type_Rol.jdField_c_of_type_Int == paramrol.jdField_c_of_type_Int - 1) && (bnrf.v(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (ryi.a().a(this.jdField_a_of_type_Rol.jdField_a_of_type_Rrm.jdField_a_of_type_Rwf))) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.b(paramrol.jdField_a_of_type_Rrm);
      }
    }
  }
  
  private void a(rol paramrol, VideoInfo paramVideoInfo)
  {
    rrm localrrm2 = paramrol.jdField_a_of_type_Rrm;
    rrm localrrm1 = localrrm2;
    if (localrrm2 == null)
    {
      localrrm1 = new rrm();
      localrrm1.jdField_a_of_type_Rlr = paramrol.jdField_a_of_type_Rvo;
      localrrm1.jdField_a_of_type_AndroidOsBundle.putInt("jump_from_scene", this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("PERFORMANCE_REPORT_VIDEO_FEEDS_JUMP_FROM", 0));
    }
    localrrm1.jdField_a_of_type_ComTencentBizPubaccountVideoInfo = paramVideoInfo;
    localrrm1.jdField_a_of_type_Int = paramVideoInfo.a(this.jdField_a_of_type_AndroidAppActivity, paramrol.jdField_d_of_type_Int);
    localrrm1.jdField_a_of_type_AndroidViewViewGroup = paramrol.jdField_b_of_type_AndroidViewViewGroup;
    localrrm1.jdField_b_of_type_Int = paramrol.jdField_c_of_type_Int;
    localrrm1.jdField_a_of_type_Boolean = false;
    localrrm1.jdField_a_of_type_AndroidOsBundle.putInt("video_feeds_index", paramrol.jdField_c_of_type_Int);
    localrrm1.jdField_a_of_type_Long = 0L;
    localrrm1.jdField_b_of_type_Boolean = true;
    if (paramVideoInfo.jdField_c_of_type_Boolean)
    {
      if (!paramVideoInfo.a(this.jdField_a_of_type_AndroidAppActivity)) {
        break label174;
      }
      localrrm1.jdField_a_of_type_AndroidOsBundle.putInt("ad_origin", nzq.R);
    }
    for (;;)
    {
      paramrol.jdField_a_of_type_Rvo.jdField_a_of_type_Boolean = true;
      paramrol.jdField_a_of_type_Rrm = localrrm1;
      paramrol.jdField_a_of_type_Sar.a(this, paramrol);
      return;
      label174:
      localrrm1.jdField_a_of_type_AndroidOsBundle.putInt("ad_origin", nzq.P);
    }
  }
  
  private void a(rol paramrol1, rol paramrol2, boolean paramBoolean)
  {
    paramrol2 = this.jdField_a_of_type_AndroidAppActivity;
    VideoInfo localVideoInfo = paramrol1.jdField_a_of_type_Rrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
    int i1 = paramrol1.jdField_b_of_type_Int;
    int i2 = paramrol1.jdField_c_of_type_Int;
    int i3 = paramrol1.jdField_a_of_type_Int;
    boolean bool1;
    if (((paramrol1 instanceof roq)) && (((roq)paramrol1).b.getVisibility() == 0))
    {
      bool1 = true;
      if ((!(paramrol1 instanceof rot)) || (((rot)paramrol1).jdField_a_of_type_Rlm == null) || (((rot)paramrol1).jdField_a_of_type_Rlm.a().getVisibility() != 0)) {
        break label128;
      }
    }
    label128:
    for (boolean bool2 = true;; bool2 = false)
    {
      ThreadManager.post(new VideoFeedsAdapter.5(this, localVideoInfo, paramrol2, i2, paramBoolean, i1, i3, bool1, bool2), 1, null, true);
      return;
      bool1 = false;
      break;
    }
  }
  
  private void a(roo paramroo)
  {
    if (this.jdField_b_of_type_Int == 1)
    {
      paramroo.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      paramroo.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      paramroo.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramroo.jdField_a_of_type_AndroidWidgetTextView.setText(a(1));
    }
    do
    {
      return;
      if (this.jdField_b_of_type_Int == 2)
      {
        paramroo.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
        paramroo.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        paramroo.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        paramroo.jdField_a_of_type_AndroidWidgetTextView.setText(a(2));
        return;
      }
    } while (this.jdField_b_of_type_Int != 3);
    if (paramroo.jdField_a_of_type_Int == 6)
    {
      paramroo.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      paramroo.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      paramroo.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramroo.jdField_a_of_type_AndroidWidgetTextView.setText(a(1));
      return;
    }
    paramroo.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
    paramroo.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    paramroo.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  private void a(rot paramrot, VideoInfo paramVideoInfo)
  {
    this.jdField_a_of_type_Tqy.e();
    a(false, paramrot);
    a(paramrot);
    a(paramVideoInfo, nzq.aB);
  }
  
  private void a(rot paramrot, VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo)
  {
    if ((paramVideoInfo.jdField_c_of_type_Boolean) && ((paramrot instanceof rog)))
    {
      tph.a((rog)paramrot, "作者设置暂不可评论");
      return;
    }
    paramAdvertisementInfo = new JSONObject();
    this.jdField_a_of_type_Roy.e();
    for (;;)
    {
      try
      {
        if (paramVideoInfo.z == null) {
          continue;
        }
        paramrot = paramVideoInfo.z;
        paramAdvertisementInfo.put("video_report_info", paramrot);
        paramAdvertisementInfo.put("video_type", 0);
        if (!this.s) {
          continue;
        }
        i1 = 1;
        paramAdvertisementInfo.put("interact_button_style", i1);
      }
      catch (JSONException paramrot)
      {
        int i1;
        paramrot.printStackTrace();
        continue;
        ocd.a(null, "", "0X8008E54", "0X8008E54", 0, 0, "", "", "", odr.a("", "", paramVideoInfo.jdField_a_of_type_JavaLangString, paramVideoInfo.g, paramAdvertisementInfo), false);
      }
      if (!jdField_a_of_type_Boolean) {
        continue;
      }
      ocd.a(null, "", "0X80092A1", "0X80092A1", 0, 0, "", "", "", odr.a("", "", paramVideoInfo.jdField_a_of_type_JavaLangString, paramVideoInfo.g, paramAdvertisementInfo), false);
      return;
      paramrot = "";
      continue;
      i1 = 0;
    }
  }
  
  private void a(rot paramrot, boolean paramBoolean, long paramLong, int paramInt)
  {
    if (paramBoolean)
    {
      if (this.jdField_b_of_type_Long != 0L) {
        ThreadManager.excute(new VideoFeedsAdapter.2(this, paramLong), 16, null, true);
      }
      if ((paramrot.jdField_a_of_type_Rrm != null) && (paramrot.jdField_a_of_type_Rrm.jdField_a_of_type_Qwv != null))
      {
        paramrot.jdField_a_of_type_Rrm.jdField_a_of_type_Qwv.o = paramLong;
        paramrot.jdField_a_of_type_Rrm.jdField_a_of_type_Qwv.s = ozs.a(paramInt, paramrot.jdField_c_of_type_Int, false);
      }
      if ((paramrot.jdField_a_of_type_Rrm != null) && (paramrot.jdField_a_of_type_Rrm.jdField_a_of_type_Qwu != null)) {
        paramrot.jdField_a_of_type_Rrm.jdField_a_of_type_Qwu.jdField_a_of_type_Boolean = true;
      }
    }
  }
  
  @RequiresApi(api=16)
  private void a(rrm paramrrm)
  {
    rpt.a(this.jdField_a_of_type_Rol.jdField_b_of_type_ComTencentImageURLImageView, 8, 0);
    this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView().getViewTreeObserver().addOnDrawListener(new rnv(this, paramrrm));
  }
  
  private void a(boolean paramBoolean, rot paramrot)
  {
    if (!(paramrot instanceof rog)) {
      return;
    }
    paramrot = (rog)paramrot;
    if (paramrot.jdField_a_of_type_AndroidViewView != null)
    {
      paramrot.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      paramrot.jdField_a_of_type_AndroidViewView.getParent().requestDisallowInterceptTouchEvent(true);
      paramrot.jdField_a_of_type_AndroidViewView.setTag(paramrot);
    }
    if (paramrot.p != null)
    {
      paramrot.p.setOnClickListener(this);
      paramrot.p.getParent().requestDisallowInterceptTouchEvent(true);
      paramrot.p.setTag(paramrot);
    }
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramrot.jdField_a_of_type_Rrm != null)
    {
      bool1 = bool2;
      if (paramrot.jdField_a_of_type_Rrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null)
      {
        bool1 = bool2;
        if (paramrot.jdField_a_of_type_Rrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo != null) {
          bool1 = tpz.d(paramrot.jdField_a_of_type_Rrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
        }
      }
    }
    if ((paramrot.jdField_a_of_type_Boolean) && (bool1))
    {
      tph.b(paramrot.jdField_c_of_type_AndroidWidgetRelativeLayout);
      tph.b(paramrot.e);
      if (!this.s) {
        tph.c(paramrot.jdField_b_of_type_AndroidWidgetSeekBar);
      }
      tph.a(paramrot.jdField_a_of_type_AndroidViewView);
      return;
    }
    tph.b(paramrot.jdField_a_of_type_AndroidViewView);
    if (paramrot.jdField_d_of_type_AndroidViewViewGroup.getVisibility() == 8) {
      tph.a(paramrot.jdField_b_of_type_AndroidWidgetSeekBar);
    }
    if ((paramrot.jdField_a_of_type_Rrm != null) && (paramrot.jdField_a_of_type_Rrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (paramrot.jdField_a_of_type_Rrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo != null))
    {
      if (!b(paramrot.jdField_a_of_type_Rrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo)) {
        break label277;
      }
      tph.b(paramrot.jdField_c_of_type_AndroidWidgetRelativeLayout);
      tph.a(paramrot.e);
    }
    for (;;)
    {
      a(paramrot);
      return;
      label277:
      if (a(paramrot))
      {
        tph.b(paramrot.e);
        tph.a(paramrot.jdField_c_of_type_AndroidWidgetRelativeLayout);
        tph.a(paramBoolean, paramrot);
      }
      else
      {
        tph.b(paramrot.e);
        tph.b(paramrot.jdField_c_of_type_AndroidWidgetRelativeLayout);
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
      if ((i3 >= 0) && ((paramList instanceof rot)) && (((rot)paramList).jdField_b_of_type_Int == i3))
      {
        ((rot)paramList).jdField_a_of_type_Rln.b(paramVideoInfo);
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
      if ((localViewHolder instanceof rot))
      {
        VideoInfo localVideoInfo = (VideoInfo)paramList.get(((rot)localViewHolder).jdField_b_of_type_Int);
        if (paramString.equals(localVideoInfo.j)) {
          ((rot)localViewHolder).jdField_a_of_type_Rln.b(localVideoInfo);
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
      paramVideoAdInfo = nzq.a(paramVideoAdInfo);
    } while ((TextUtils.isEmpty(paramVideoAdInfo.mPopFormH5Url)) || (!tpz.d(paramVideoAdInfo)));
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
        if (!paramVideoInfo.n) {
          bool1 = true;
        }
        paramVideoInfo.n = true;
      }
    }
    return bool1;
  }
  
  private boolean a(rog paramrog)
  {
    boolean bool3 = true;
    boolean bool1 = true;
    boolean bool2 = bool1;
    if (paramrog != null)
    {
      bool2 = bool1;
      if (paramrog.jdField_a_of_type_Rrm != null)
      {
        if (paramrog.jdField_a_of_type_Rrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) {
          break label34;
        }
        bool2 = bool1;
      }
    }
    label34:
    do
    {
      return bool2;
      paramrog = paramrog.jdField_a_of_type_Rrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
      bool1 = bool3;
      if (paramrog.jdField_c_of_type_Boolean)
      {
        paramrog = nzq.a(paramrog.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
        bool1 = bool3;
        if (paramrog != null)
        {
          bool1 = bool3;
          if (!paramrog.mShowAdButton) {
            bool1 = false;
          }
        }
      }
      bool2 = bool1;
    } while (!QLog.isColorLevel());
    QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "showButton = " + bool1);
    return bool1;
  }
  
  private boolean a(rot paramrot)
  {
    boolean bool4 = true;
    boolean bool2 = true;
    boolean bool3 = false;
    paramrot.jdField_a_of_type_Rvo.jdField_a_of_type_Boolean = false;
    boolean bool1 = bool2;
    Bundle localBundle;
    int i2;
    if (paramrot.jdField_c_of_type_Int == this.jdField_e_of_type_Int)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_AndroidContentContext != null)
      {
        bool1 = bool2;
        if (paramrot.jdField_a_of_type_Rrm != null)
        {
          bool1 = bool2;
          if (paramrot.jdField_a_of_type_Rrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null)
          {
            localBundle = this.jdField_a_of_type_AndroidAppActivity.getIntent().getExtras();
            i2 = localBundle.getInt("VIDEO_FROM_TYPE", 0);
            if (bhnv.b(this.jdField_a_of_type_AndroidContentContext)) {
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
        paramrot = paramrot.jdField_a_of_type_Rvo;
        bool1 = bool3;
        if (i1 == 0) {
          bool1 = true;
        }
        paramrot.jdField_a_of_type_Boolean = bool1;
        return true;
      }
      paramrot = paramrot.jdField_a_of_type_Rvo;
      if (i1 == 0) {}
      for (bool1 = bool4;; bool1 = false)
      {
        paramrot.jdField_a_of_type_Boolean = bool1;
        return false;
      }
    }
    if (i1 != 0)
    {
      paramrot.jdField_a_of_type_Rvo.jdField_a_of_type_Boolean = false;
      return true;
    }
    i1 = localBundle.getInt("VIDEO_PLAY_STATUS", 0);
    paramrot = paramrot.jdField_a_of_type_Rvo;
    if (((2 != i2) && (6 != i2) && (5 != i2)) || (3 != i1))
    {
      bool1 = true;
      label275:
      paramrot.jdField_a_of_type_Boolean = bool1;
      if ((33 != i2) && (1 != i2) && (12 != i2) && (11 != i2)) {
        break label322;
      }
    }
    label322:
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
    if (this.jdField_a_of_type_Rsk != null) {
      this.jdField_a_of_type_Rsk.b();
    }
    this.jdField_a_of_type_Rol.jdField_a_of_type_Sar.a();
    if (paramView.getId() == 2131366109) {
      sas.b(paramVideoInfo.g, 2);
    }
  }
  
  private void b(View paramView, roj paramroj, VideoInfo paramVideoInfo)
  {
    AdvertisementInfo localAdvertisementInfo = a(paramVideoInfo);
    switch (paramView.getId())
    {
    }
    do
    {
      do
      {
        return;
        a(paramVideoInfo, paramroj);
        return;
      } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView == null);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.b();
      return;
      e(paramVideoInfo);
      return;
      a(paramView);
      return;
      b((rot)paramroj, paramVideoInfo, localAdvertisementInfo);
      return;
      a((rot)paramroj, paramVideoInfo, localAdvertisementInfo);
      return;
      c(paramroj, paramVideoInfo);
      return;
      b(paramroj, paramVideoInfo);
      return;
      a((rot)paramroj, paramVideoInfo);
      return;
    } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView == null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.a();
  }
  
  private void b(VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo)
  {
    tqa.a(paramAdvertisementInfo, 16, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
    this.jdField_a_of_type_Tqy.f();
    ubd.b(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, true, null);
    a(paramVideoInfo, nzq.az);
  }
  
  private void b(VideoInfo paramVideoInfo, String paramString)
  {
    if ((this.jdField_a_of_type_Rol != null) && (this.jdField_a_of_type_Rol.l != null) && (this.jdField_a_of_type_Rol.l.getVisibility() == 0)) {
      ocd.a(null, "", paramString, paramString, 0, 0, "", "", "", new sbg(paramVideoInfo).a(this.jdField_a_of_type_Rsk.a()).b(this.s).c(paramVideoInfo.jdField_d_of_type_Int).M(0).a(paramVideoInfo.z).L(pbn.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_d_of_type_Int)).a().a(), false);
    }
  }
  
  private void b(rog paramrog)
  {
    int i1;
    Object localObject;
    if ((paramrog != null) && (paramrog.jdField_a_of_type_Rrm != null) && (paramrog.jdField_a_of_type_Rrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (paramrog.jdField_a_of_type_Rrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo != null))
    {
      i1 = tpz.d(nzq.a(paramrog.jdField_a_of_type_Rrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo));
      if (i1 != 1) {
        break label88;
      }
      paramrog = paramrog.j;
      if (paramrog != null)
      {
        localObject = (LinearLayout.LayoutParams)paramrog.getLayoutParams();
        if (localObject != null)
        {
          ((LinearLayout.LayoutParams)localObject).weight = 2.0F;
          paramrog.setLayoutParams((ViewGroup.LayoutParams)localObject);
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
        localObject = paramrog.jdField_k_of_type_AndroidViewView;
        if (localObject != null)
        {
          LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((View)localObject).getLayoutParams();
          if (localLayoutParams != null)
          {
            localLayoutParams.weight = 0.0F;
            ((View)localObject).setLayoutParams(localLayoutParams);
          }
        }
        paramrog = paramrog.l;
      } while (paramrog == null);
      localObject = (LinearLayout.LayoutParams)paramrog.getLayoutParams();
    } while (localObject == null);
    ((LinearLayout.LayoutParams)localObject).weight = 0.0F;
    paramrog.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  private void b(roj paramroj, VideoInfo paramVideoInfo)
  {
    if (((paramroj instanceof roq)) && (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo != null))
    {
      rpt.a(this.jdField_a_of_type_AndroidAppActivity, paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.a);
      paramroj = new sbg(paramVideoInfo).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo).i(paramVideoInfo.g).M(0).a();
      ocd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "", "0X800AC2C", "0X800AC2C", 0, 0, "", "", "", paramroj.a(), false);
    }
  }
  
  private void b(roj paramroj, VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo)
  {
    if ((paramroj instanceof rog))
    {
      if (a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo))
      {
        a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
        nzq.a(new tlx().a(this.jdField_a_of_type_AndroidContentContext).a(nzq.L).b(nzq.P).a(paramAdvertisementInfo).a());
      }
    }
    else {
      return;
    }
    rog localrog = (rog)paramroj;
    int i1 = 8;
    if (this.i) {
      i1 = 13;
    }
    tqa.a(paramAdvertisementInfo, i1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
    c(localrog);
    paramroj = new View[1];
    paramroj[0] = localrog.jdField_a_of_type_AndroidViewView;
    if (b(paramVideoInfo)) {
      paramroj = new View[0];
    }
    RelativeLayout localRelativeLayout = localrog.jdField_c_of_type_AndroidWidgetRelativeLayout;
    tph.c(localrog.jdField_b_of_type_AndroidWidgetSeekBar);
    a(localrog, paramVideoInfo, paramAdvertisementInfo, -1, paramroj, new View[] { localRelativeLayout });
  }
  
  private void b(rol paramrol)
  {
    paramrol = paramrol.jdField_a_of_type_Rrm;
    if ((paramrol != null) && ((paramrol.jdField_a_of_type_Boolean) || ((paramrol.jdField_a_of_type_Rwf != null) && (paramrol.jdField_a_of_type_Rwf.b() != 0))))
    {
      paramrol.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.c(paramrol);
    }
  }
  
  private void b(rot paramrot, VideoInfo paramVideoInfo)
  {
    if (bduy.a()) {}
    do
    {
      do
      {
        return;
        if (paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsUGView != null) {
          paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsUGView.a();
        }
        if (paramrot.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsUGView != null) {
          paramrot.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsUGView.a();
        }
      } while ((paramVideoInfo.jdField_a_of_type_Odl == null) && (paramVideoInfo.jdField_b_of_type_Odl == null));
      if ((paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsUGView != null) && (paramVideoInfo.jdField_a_of_type_Odl != null) && ((paramVideoInfo.jdField_a_of_type_Odl.jdField_c_of_type_Int == 1) || (paramVideoInfo.jdField_a_of_type_Odl.jdField_c_of_type_Int == 2))) {
        paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsUGView.setInfo(paramVideoInfo.jdField_a_of_type_Odl, paramVideoInfo.jdField_c_of_type_JavaLangString, "VideoPlay_ContentMix");
      }
    } while ((paramrot.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsUGView == null) || (paramVideoInfo.jdField_b_of_type_Odl == null) || ((paramVideoInfo.jdField_b_of_type_Odl.jdField_c_of_type_Int != 1) && (paramVideoInfo.jdField_b_of_type_Odl.jdField_c_of_type_Int != 2)));
    paramrot.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsUGView.setInfo(paramVideoInfo.jdField_b_of_type_Odl, paramVideoInfo.jdField_c_of_type_JavaLangString, "VideoPlay_Shooting");
  }
  
  private void b(rot paramrot, VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramVideoInfo.jdField_c_of_type_Boolean)
    {
      tqa.a(paramAdvertisementInfo, 1000, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
      ubd.b(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, false, null);
      a(paramVideoInfo, 1000);
      return;
    }
    this.jdField_a_of_type_Roy.g();
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
      if (paramrot.jdField_a_of_type_Rrm == null) {
        break label266;
      }
      paramrot = paramrot.jdField_a_of_type_Rrm.jdField_a_of_type_Rwf;
      localObject = new sbg(null, paramVideoInfo.j, paramVideoInfo.jdField_a_of_type_JavaLangString, paramVideoInfo.g);
      if (paramrot == null) {
        break label271;
      }
      l1 = paramrot.a(paramrot.h());
      localObject = ((sbg)localObject).d(l1);
      if (paramrot == null) {
        break label279;
      }
      l1 = paramrot.a();
      localObject = ((sbg)localObject).a(l1);
      if (paramrot == null) {
        break label287;
      }
      l1 = paramrot.b();
      label146:
      localObject = ((sbg)localObject).c(l1).a(409409).a(paramVideoInfo.z).u(this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("VIDEO_FROM_TYPE", -1)).a().a();
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
    for (paramrot = paramVideoInfo.g;; paramrot = "0")
    {
      ocd.a(null, str, paramAdvertisementInfo, paramAdvertisementInfo, 0, 0, "", "", paramrot, (String)localObject, false);
      if ((bnrf.j(ozs.a())) || (this.jdField_a_of_type_Rsg == null)) {
        break;
      }
      this.jdField_a_of_type_Rsg.a(4, paramVideoInfo, 0L);
      return;
      paramAdvertisementInfo = "0X8009485";
      break label57;
      paramrot = null;
      break label72;
      l1 = -1L;
      break label108;
      l1 = -1L;
      break label127;
      l1 = -1L;
      break label146;
    }
  }
  
  private static boolean b(VideoInfo paramVideoInfo)
  {
    return tqa.a(paramVideoInfo);
  }
  
  private void c(View paramView, roj paramroj, VideoInfo paramVideoInfo)
  {
    AdvertisementInfo localAdvertisementInfo = a(paramVideoInfo);
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      a(paramView, paramroj, paramVideoInfo, localAdvertisementInfo);
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
      b(paramroj, paramVideoInfo, localAdvertisementInfo);
      continue;
      tqa.a(localAdvertisementInfo, 13, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
      a(paramroj, paramVideoInfo, localAdvertisementInfo);
      continue;
      j(paramVideoInfo, localAdvertisementInfo);
      continue;
      tqa.a(localAdvertisementInfo, 2003, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
      a(paramroj, paramVideoInfo, localAdvertisementInfo, 2003);
      continue;
      tqa.a(localAdvertisementInfo, 2004, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
      a(paramroj, paramVideoInfo, localAdvertisementInfo, 2004);
      continue;
      tqa.a(localAdvertisementInfo, 4001, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
      a(paramroj, paramVideoInfo, localAdvertisementInfo, 4001);
      continue;
      tqa.a(localAdvertisementInfo, 4002, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
      a(paramroj, paramVideoInfo, localAdvertisementInfo, 4002);
      continue;
      tqa.a(localAdvertisementInfo, 4007, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
      a(paramroj, paramVideoInfo, localAdvertisementInfo, 4007);
      continue;
      tqa.a(localAdvertisementInfo, 4000, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
      a(paramroj, paramVideoInfo, localAdvertisementInfo, 4000);
    }
  }
  
  private void c(VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo)
  {
    tqa.a(paramAdvertisementInfo, 15, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
    this.jdField_a_of_type_Tqy.f();
    ubd.b(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, true, null);
    a(paramVideoInfo, nzq.ay);
  }
  
  private void c(rog paramrog) {}
  
  private void c(roj paramroj, VideoInfo paramVideoInfo)
  {
    int i1 = 0;
    boolean bool;
    if (!paramVideoInfo.o)
    {
      bool = true;
      paramVideoInfo.o = bool;
      if (!paramVideoInfo.o) {
        break label150;
      }
      i1 = paramVideoInfo.s + 1;
    }
    for (;;)
    {
      paramVideoInfo.s = i1;
      if ((paramroj instanceof rot)) {
        ((rot)paramroj).jdField_a_of_type_Rln.d();
      }
      if ((this.jdField_a_of_type_Rqy != null) && (paramVideoInfo.o)) {
        this.jdField_a_of_type_Rqy.a((float)(bhlo.i() / 2L), (float)(bhlo.j() / 2L));
      }
      if (this.jdField_a_of_type_Rsg != null) {
        this.jdField_a_of_type_Rsg.a(3, paramVideoInfo, 0L);
      }
      if ((this.jdField_a_of_type_Roi != null) && (!paramVideoInfo.jdField_c_of_type_Boolean)) {
        this.jdField_a_of_type_Roi.a(paramVideoInfo, paramVideoInfo.o);
      }
      g(paramVideoInfo);
      return;
      bool = false;
      break;
      label150:
      if (paramVideoInfo.s > 0) {
        i1 = paramVideoInfo.s - 1;
      }
    }
  }
  
  private void c(roj paramroj, VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo)
  {
    if ((paramroj instanceof rog))
    {
      if (!a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo)) {
        break label90;
      }
      a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
      nzq.a(new tlx().a(this.jdField_a_of_type_AndroidContentContext).a(nzq.L).b(nzq.P).a(paramAdvertisementInfo).a());
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Rol != null) && (this.jdField_a_of_type_Rol.jdField_a_of_type_Rrm != null)) {
        tqa.a(this.jdField_a_of_type_Rol.jdField_a_of_type_Rrm, true);
      }
      return;
      label90:
      rog localrog = (rog)paramroj;
      paramroj = new View[2];
      paramroj[0] = localrog.p;
      paramroj[1] = localrog.jdField_a_of_type_AndroidViewView;
      if (b(paramVideoInfo))
      {
        paramroj = new View[1];
        paramroj[0] = localrog.p;
      }
      RelativeLayout localRelativeLayout = localrog.jdField_c_of_type_AndroidWidgetRelativeLayout;
      TextView localTextView = localrog.jdField_k_of_type_AndroidWidgetTextView;
      tph.c(localrog.jdField_b_of_type_AndroidWidgetSeekBar);
      a(localrog, paramVideoInfo, paramAdvertisementInfo, nzq.aa, paramroj, new View[] { localRelativeLayout, localTextView });
    }
  }
  
  private void d(VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramVideoInfo.jdField_c_of_type_Boolean)
    {
      if (this.n)
      {
        this.n = false;
        tqa.a(paramAdvertisementInfo, 1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
        ubd.b(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, false, null);
        a(paramVideoInfo, nzq.at);
      }
    }
    else {
      return;
    }
    tqa.a(paramAdvertisementInfo, 4, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
    ubd.b(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, false, null);
    a(paramVideoInfo, nzq.aw);
  }
  
  private void d(roj paramroj, VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo)
  {
    if ((paramroj instanceof rog))
    {
      rog localrog = (rog)paramroj;
      tph.c(localrog.jdField_b_of_type_AndroidWidgetSeekBar);
      a(paramroj, paramVideoInfo, paramAdvertisementInfo, nzq.aa, localrog.p, new View[] { localrog.jdField_k_of_type_AndroidWidgetTextView });
    }
  }
  
  private void e(VideoInfo paramVideoInfo)
  {
    if (paramVideoInfo.n) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "followPubAccount onClick() puin=" + paramVideoInfo.j + ", isFollowed=" + paramVideoInfo.n + ", pname=" + paramVideoInfo.k);
    }
    String str2 = new sbg(null, paramVideoInfo.j, paramVideoInfo.jdField_a_of_type_JavaLangString, paramVideoInfo.g, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(), paramVideoInfo.a() * 1000L).a(paramVideoInfo.z).M(0).a().a();
    if (jdField_a_of_type_Boolean)
    {
      str3 = paramVideoInfo.j;
      if (!TextUtils.isEmpty(paramVideoInfo.g)) {}
      for (str1 = paramVideoInfo.g;; str1 = "0")
      {
        ocd.a(null, str3, "0X800929B", "0X800929B", 0, 0, "", "", str1, str2, false);
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
      ocd.a(null, str3, "0X80078FD", "0X80078FD", 0, 0, "", "", str1, str2, false);
      break;
    }
  }
  
  private void e(VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramVideoInfo.jdField_c_of_type_Boolean)
    {
      tqa.a(paramAdvertisementInfo, 3, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
      ubd.b(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, false, null);
      a(paramVideoInfo, nzq.av);
    }
  }
  
  private void f(VideoInfo paramVideoInfo)
  {
    if ((this.jdField_a_of_type_Rol.jdField_a_of_type_Rrm == null) || (paramVideoInfo == null)) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.a(false);
    } while (TextUtils.isEmpty(paramVideoInfo.g));
    sas.a(this.jdField_a_of_type_AndroidAppActivity, rll.a(paramVideoInfo), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(paramVideoInfo.g), 2, 0);
    sas.a(paramVideoInfo.g, 2, 0);
  }
  
  private void f(VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramVideoInfo.jdField_c_of_type_Boolean)
    {
      tqa.a(paramAdvertisementInfo, 2, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
      ubd.b(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, false, null);
      a(paramVideoInfo, nzq.au);
    }
  }
  
  private void g()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(2, null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.c(false);
  }
  
  private void g(VideoInfo paramVideoInfo)
  {
    int i2 = 1;
    if (paramVideoInfo == null) {
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("channel_id", 409409);
      if (!paramVideoInfo.o) {
        break label269;
      }
      i1 = 0;
      localJSONObject.put("type", i1);
      if (paramVideoInfo.z == null) {
        break label274;
      }
      str1 = paramVideoInfo.z;
      label60:
      localJSONObject.put("video_report_info", str1);
      if (!paramVideoInfo.o) {
        break label103;
      }
      if (this.jdField_a_of_type_Rqy == null) {
        break label322;
      }
      i1 = this.jdField_a_of_type_Rqy.a();
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
      ocd.a(null, str4, str1, str1, 0, 0, "0", "0", str3, odr.a(str2, paramVideoInfo.j, paramVideoInfo.jdField_a_of_type_JavaLangString, paramVideoInfo.g, localJSONObject), false);
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
  
  private void g(VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramVideoInfo.jdField_c_of_type_Boolean)
    {
      tqa.a(paramAdvertisementInfo, 2, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
      ubd.b(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, false, null);
      a(paramVideoInfo, nzq.au);
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
    this.jdField_a_of_type_AndroidOsHandler.post(new VideoFeedsAdapter.15(this, paramBoolean));
  }
  
  private void h()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr = new VideoPreDownloadMgr(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a = new rwp(rwp.jdField_c_of_type_Int, rwp.jdField_f_of_type_Int);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a(new rnx(this));
  }
  
  private void h(VideoInfo paramVideoInfo)
  {
    ThreadManager.excute(new VideoFeedsAdapter.8(this, paramVideoInfo), 16, null, true);
  }
  
  private void h(VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramVideoInfo.jdField_c_of_type_Boolean)
    {
      tqa.a(paramAdvertisementInfo, 1000, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
      ubd.b(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, false, null);
      a(paramVideoInfo, nzq.aC);
    }
  }
  
  private void i()
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
  
  private void i(VideoInfo paramVideoInfo)
  {
    if ((paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo != null) && (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_e_of_type_Int == 1)) {
      ocd.a(null, "", "0X800AC2B", "0X800AC2B", 0, 0, "3", "", "", new sbg(paramVideoInfo).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo).M(0).a().a(), false);
    }
  }
  
  private void i(VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramVideoInfo.jdField_c_of_type_Boolean)
    {
      ubd.b(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, true, null);
      a(paramVideoInfo, 0);
    }
  }
  
  private void j(VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo)
  {
    if ((paramVideoInfo.jdField_a_of_type_Int == 0) && (paramVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null)) {}
    for (String str = paramVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5();; str = null)
    {
      if ((this.jdField_a_of_type_Roy != null) && (paramVideoInfo.a(this.jdField_a_of_type_AndroidAppActivity))) {
        this.jdField_a_of_type_Roy.h();
      }
      if (!paramVideoInfo.jdField_c_of_type_Boolean) {
        break;
      }
      ubd.b(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, true, null);
      a(paramVideoInfo, 0);
      return;
    }
    if ((paramVideoInfo.A != null) && (!paramVideoInfo.A.equals("")))
    {
      ozs.a(this.jdField_a_of_type_AndroidAppActivity, paramVideoInfo.A);
      return;
    }
    paramAdvertisementInfo = ReadInJoyUserInfoModule.a(Long.parseLong(paramVideoInfo.j), null);
    if (((this.jdField_a_of_type_Rol instanceof roq)) && (((roq)this.jdField_a_of_type_Rol).b.getVisibility() == 0) && (paramAdvertisementInfo != null) && (!TextUtils.isEmpty(paramAdvertisementInfo.getLiveUrl())))
    {
      ozs.a(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo.getLiveUrl());
      a(paramVideoInfo, "0X800B17E");
      paramAdvertisementInfo = new sbg(str, paramVideoInfo.j, paramVideoInfo.jdField_a_of_type_JavaLangString, paramVideoInfo.g, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(), paramVideoInfo.a() * 1000L).a(-1).M(0).a().a();
      str = paramVideoInfo.j;
      if (TextUtils.isEmpty(paramVideoInfo.g)) {
        break label401;
      }
    }
    label401:
    for (paramVideoInfo = paramVideoInfo.g;; paramVideoInfo = "0")
    {
      ocd.a(null, str, "0X8007410", "0X8007410", 0, 0, "0", "", paramVideoInfo, paramAdvertisementInfo, false);
      return;
      if (paramVideoInfo.m)
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
        paramAdvertisementInfo = oyu.g + bhkv.encodeToString(paramVideoInfo.j.getBytes(), 2);
        ozs.a(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo);
        break;
      }
      if ((TextUtils.isEmpty(paramVideoInfo.j)) || (paramVideoInfo.j.equals("16888"))) {
        break;
      }
      a(paramVideoInfo.j, paramVideoInfo.g);
      break;
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
        } while (localVideoInfo.jdField_c_of_type_JavaUtilArrayList == null);
        localObject = localVideoInfo.jdField_c_of_type_JavaUtilArrayList.iterator();
      }
      localVideoInfo = (VideoInfo)((Iterator)localObject).next();
    } while (!paramString.equals(localVideoInfo.g));
    return localVideoInfo;
    label103:
    return null;
  }
  
  public roj a(ViewGroup paramViewGroup, int paramInt)
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
        paramViewGroup.jdField_a_of_type_Rln = ((rln)localObject3);
        paramViewGroup.jdField_a_of_type_Rvo = new rvo(paramViewGroup, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager, this.jdField_f_of_type_Boolean);
        return paramViewGroup;
      }
      break;
    case 2: 
      localObject1 = rsr.a(2131560321, true, new ViewGroup.LayoutParams(-1, -1));
      paramViewGroup = (roq)((View)localObject1).getTag();
      if (paramViewGroup == null) {
        paramViewGroup = new roq((View)localObject1);
      }
      break;
    }
    for (;;)
    {
      for (;;)
      {
        localObject3 = new rop(this, (roq)paramViewGroup);
        try
        {
          paramInt = LiuHaiUtils.b(this.jdField_a_of_type_AndroidAppActivity);
          if ((LiuHaiUtils.b()) && (paramInt > 0) && (((roq)paramViewGroup).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsUGView != null))
          {
            localObject1 = (View)((roq)paramViewGroup).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsUGView.getParent();
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
      View localView = rsr.a(2131560336, true, new ViewGroup.LayoutParams(-1, -1));
      paramViewGroup = (roq)localView.getTag();
      if (paramViewGroup == null) {
        paramViewGroup = new ros(localView);
      }
      for (;;)
      {
        for (;;)
        {
          localObject3 = new ror(this, (ros)paramViewGroup);
          try
          {
            paramInt = LiuHaiUtils.b(this.jdField_a_of_type_AndroidAppActivity);
            if ((LiuHaiUtils.b()) && (paramInt > 0) && (((roq)paramViewGroup).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsUGView != null))
            {
              localView = (View)((roq)paramViewGroup).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsUGView.getParent();
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
        paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560313, paramViewGroup, false);
        if (!this.s) {
          ((LayoutInflater)localObject2).inflate(2131560347, (ViewGroup)paramViewGroup.findViewById(2131364877), true);
        }
        ((LayoutInflater)localObject2).inflate(2131560342, (ViewGroup)paramViewGroup.findViewById(2131364875), true);
        ((LayoutInflater)localObject2).inflate(2131560344, (ViewGroup)paramViewGroup.findViewById(2131364873), true);
        paramViewGroup = new rog(paramViewGroup, paramInt);
        localObject3 = new rob(this, (rog)paramViewGroup);
        Object localObject2 = null;
        break;
        localObject3 = rsr.a(2131560317, true, new ViewGroup.LayoutParams(-1, -1));
        localObject2 = (roo)((View)localObject3).getTag();
        paramViewGroup = (ViewGroup)localObject2;
        if (localObject2 == null) {
          paramViewGroup = new roo((View)localObject3, paramInt);
        }
        this.jdField_a_of_type_Roo = paramViewGroup;
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
    if ((localViewHolder instanceof roo)) {
      a((roo)localViewHolder);
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
    if ((this.jdField_a_of_type_Roy != null) && (this.jdField_a_of_type_Roy.a()) && (this.jdField_a_of_type_Roy.b()))
    {
      this.jdField_a_of_type_Roy.h();
      break label34;
    }
    for (;;)
    {
      label34:
      return;
      if (!this.v) {
        continue;
      }
      paramView = (rol)paramView.getTag();
      if (paramView != this.jdField_a_of_type_Rol)
      {
        if (this.jdField_a_of_type_Rol == null) {
          break;
        }
        if ((paramView != null) && (paramView.jdField_c_of_type_Int == this.jdField_a_of_type_Rol.jdField_c_of_type_Int + 1) && (paramView.jdField_c_of_type_Int != getItemCount()))
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.a();
          return;
        }
        if ((paramView == null) || (paramView.jdField_c_of_type_Int != this.jdField_a_of_type_Rol.jdField_c_of_type_Int - 1)) {
          break;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.b();
        return;
      }
      paramView.jdField_a_of_type_Rln.c();
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
          ocd.a(null, null, "0X80091AB", "0X80091AB", 0, 0, "", "", "", odr.a(null, null, paramView.jdField_a_of_type_Rrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, paramView.jdField_a_of_type_Rrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g, localJSONObject), false);
          return;
          if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager == null) || (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.d())) {
            continue;
          }
          localJSONObject = new JSONObject();
          try
          {
            localJSONObject.put("channel_id", 409409);
            label307:
            ocd.a(null, null, "0X80091AB", "0X80091AB", 0, 0, "", "", "", odr.a(null, null, paramView.jdField_a_of_type_Rrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, paramView.jdField_a_of_type_Rrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g, localJSONObject), false);
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
    paramView = (rot)paramView.getTag();
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
        paramView.jdField_a_of_type_Rln.a(1);
        this.t = false;
        return;
      } while (paramView.jdField_d_of_type_AndroidViewViewGroup.getVisibility() != 0);
      paramView.jdField_a_of_type_Rln.a(2);
    } while (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.b());
    this.t = true;
  }
  
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    int i2 = 1;
    rot localrot = (rot)paramView.getTag();
    if (localrot != this.jdField_a_of_type_Rol) {}
    while ((!this.v) || (localrot == null) || (localrot.jdField_a_of_type_Rrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == null) || (!(localrot instanceof rol)) || (TextUtils.isEmpty(localrot.jdField_a_of_type_Rrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g))) {
      return;
    }
    Object localObject = localrot.jdField_a_of_type_Rrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
    boolean bool;
    int i1;
    label111:
    JSONObject localJSONObject;
    if (!((VideoInfo)localObject).o)
    {
      bool = true;
      ((VideoInfo)localObject).o = true;
      if (!bool) {
        break label477;
      }
      i1 = ((VideoInfo)localObject).s + 1;
      ((VideoInfo)localObject).s = i1;
      localrot.jdField_a_of_type_Rln.a(paramInt1, paramInt2, bool);
      if (bool)
      {
        if (this.jdField_a_of_type_Roi != null) {
          this.jdField_a_of_type_Roi.a((VideoInfo)localObject, ((VideoInfo)localObject).o);
        }
        g((VideoInfo)localObject);
      }
      if (this.jdField_a_of_type_Rsg != null) {
        this.jdField_a_of_type_Rsg.a(3, (VideoInfo)localObject, 0L);
      }
      localJSONObject = new JSONObject();
      if ((localrot.jdField_a_of_type_Rrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int != 0) || (localrot.jdField_a_of_type_Rrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null)) {
        break label487;
      }
      paramView = localrot.jdField_a_of_type_Rrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5();
    }
    try
    {
      label236:
      localJSONObject.put("channel_id", 409409);
      localJSONObject.put("rowkey", localrot.jdField_a_of_type_Rrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g);
      if (this.jdField_a_of_type_Rqy == null) {
        break label492;
      }
      paramInt1 = this.jdField_a_of_type_Rqy.a();
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
      str2 = localrot.jdField_a_of_type_Rrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.j;
      if (TextUtils.isEmpty(localrot.jdField_a_of_type_Rrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g)) {
        break label518;
      }
    }
    label518:
    for (str1 = localrot.jdField_a_of_type_Rrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g;; str1 = "0")
    {
      ocd.a(null, str2, (String)localObject, (String)localObject, 0, 0, "0", "0", str1, odr.a(paramView, localrot.jdField_a_of_type_Rrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.j, localrot.jdField_a_of_type_Rrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, localrot.jdField_a_of_type_Rrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g, localJSONObject), false);
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
    if ((paramVideoInfo != null) && (this.jdField_a_of_type_Sbg != null))
    {
      this.jdField_a_of_type_Sbg.a(paramVideoInfo.z);
      a(paramVideoInfo, this.jdField_a_of_type_Sbg);
      this.jdField_a_of_type_Sbg = null;
    }
  }
  
  public void a(VideoFeedsPlayManager paramVideoFeedsPlayManager)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager = paramVideoFeedsPlayManager;
    h();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(new rnw(this));
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
      if ((paramList instanceof rot)) {
        ((rot)paramList).jdField_a_of_type_Rln.a();
      }
      i1 += 1;
    }
  }
  
  public void a(ADVideoAppDownloadManager paramADVideoAppDownloadManager)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadManager = paramADVideoAppDownloadManager;
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
    paramString1 = oyu.k + bhkv.encodeToString(String.valueOf(paramString1).getBytes(), 2) + "&rowkey=" + paramString2;
    ozs.a(this.jdField_a_of_type_AndroidAppActivity, paramString1);
  }
  
  public void a(List<VideoInfo> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void a(rmt paramrmt)
  {
    this.jdField_a_of_type_Rmt = paramrmt;
  }
  
  public void a(roi paramroi)
  {
    this.jdField_a_of_type_Roi = paramroi;
  }
  
  public void a(roj paramroj, int paramInt)
  {
    paramroj.jdField_b_of_type_Int = paramInt;
    paramroj.jdField_c_of_type_Int = paramInt;
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size()))
    {
      if (this.jdField_a_of_type_Trb != null)
      {
        VideoInfo localVideoInfo = this.jdField_a_of_type_Trb.b(paramInt);
        if (localVideoInfo != null) {
          this.jdField_a_of_type_JavaUtilList.set(paramInt, localVideoInfo);
        }
      }
      a(paramroj, (VideoInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt));
    }
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramroj, paramInt, getItemId(paramInt));
      return;
      a(paramroj, null);
    }
  }
  
  public void a(roj paramroj, VideoInfo paramVideoInfo)
  {
    int i1 = paramroj.jdField_a_of_type_Int;
    if ((i1 == 3) || (i1 == 6))
    {
      a((roo)paramroj);
      this.jdField_a_of_type_Roo = ((roo)paramroj);
      return;
    }
    paramroj = (rol)paramroj;
    b(paramroj);
    a(paramroj, paramVideoInfo);
    rpe.a.a(paramroj);
    TraceCompat.beginSection("refreshMenuUI");
    paramroj.jdField_a_of_type_Rln.a(paramVideoInfo);
    TraceCompat.endSection();
    TraceCompat.beginSection("refreshContentUI");
    paramroj.jdField_a_of_type_Rln.a(paramVideoInfo, this.jdField_d_of_type_Boolean);
    if (!TextUtils.isEmpty(paramVideoInfo.j))
    {
      ReadInJoyUserInfo localReadInJoyUserInfo = ReadInJoyUserInfoModule.a(Long.parseLong(paramVideoInfo.j), null);
      if ((localReadInJoyUserInfo != null) && (localReadInJoyUserInfo.isReadlTimeRead())) {
        ReadInJoyUserInfoModule.a(Long.parseLong(paramVideoInfo.j), this, true);
      }
    }
    TraceCompat.endSection();
    if ((this.h) && (paramroj == this.jdField_a_of_type_Rol)) {
      paramroj.jdField_a_of_type_Rln.f(this.h);
    }
    a(paramroj);
  }
  
  public void a(ros paramros)
  {
    long l2 = -1L;
    Object localObject = paramros.jdField_a_of_type_Rrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
    if (paramros.jdField_a_of_type_Rrm != null)
    {
      paramros = paramros.jdField_a_of_type_Rrm.jdField_a_of_type_Rwf;
      localObject = new sbg((VideoInfo)localObject);
      if (paramros == null) {
        break label112;
      }
    }
    label112:
    for (long l1 = paramros.a();; l1 = -1L)
    {
      localObject = ((sbg)localObject).a(l1);
      l1 = l2;
      if (paramros != null) {
        l1 = paramros.b();
      }
      ocd.a(null, "", "0X800B28A", "0X800B28A", 0, 0, "3", "", "", ((sbg)localObject).c(l1).a().a(), false);
      return;
      paramros = null;
      break;
    }
  }
  
  public void a(rot paramrot)
  {
    boolean bool2 = true;
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsPlayManager.preplay", 2, "adapter playVideo (VideoItemHolder holder) ");
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(2, null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.d();
    int i1;
    label125:
    boolean bool1;
    label146:
    long l1;
    long l2;
    if (this.jdField_a_of_type_Rol != null)
    {
      i1 = this.jdField_a_of_type_Rol.jdField_c_of_type_Int;
      this.jdField_a_of_type_Rol = paramrot;
      if ((this.jdField_a_of_type_Rol.jdField_c_of_type_Int == 0) && (this.jdField_a_of_type_Rol.jdField_b_of_type_Int == 0))
      {
        paramrot.jdField_a_of_type_Rrm.jdField_a_of_type_Long = this.jdField_c_of_type_Long;
        this.jdField_c_of_type_Long = 0L;
      }
      if (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
        break label279;
      }
      paramrot.jdField_a_of_type_Rrm.jdField_a_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
      paramrot.jdField_a_of_type_Rrm.jdField_c_of_type_Boolean = true;
      this.jdField_d_of_type_JavaLangString = null;
      bool1 = bool2;
      if (this.jdField_g_of_type_Boolean)
      {
        if (!a(paramrot)) {
          break label298;
        }
        bool1 = bool2;
      }
      this.jdField_g_of_type_Boolean = false;
      l1 = System.currentTimeMillis();
      l2 = this.jdField_b_of_type_Long;
      paramrot.jdField_a_of_type_Rrm.jdField_a_of_type_AndroidOsBundle.putBoolean("is_auto_play", bool1);
      if (!bool1) {
        break label318;
      }
      if ((!bnrf.g(this.jdField_a_of_type_Int)) || (!this.jdField_a_of_type_Rol.jdField_a_of_type_Rrm.jdField_c_of_type_Boolean) || (Build.VERSION.SDK_INT < 16)) {
        break label303;
      }
      a(paramrot.jdField_a_of_type_Rrm);
    }
    for (;;)
    {
      a(paramrot, bool1, l1 - l2, i1);
      if ((paramrot.jdField_a_of_type_Rrm != null) && (paramrot.jdField_a_of_type_Rrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null)) {
        tzq.a(paramrot.jdField_a_of_type_Rrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g, paramrot.jdField_a_of_type_Rrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, 0, 0);
      }
      return;
      i1 = -1;
      break;
      label279:
      paramrot.jdField_a_of_type_Rrm.jdField_a_of_type_JavaLangString = null;
      paramrot.jdField_a_of_type_Rrm.jdField_c_of_type_Boolean = false;
      break label125;
      label298:
      bool1 = false;
      break label146;
      label303:
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(paramrot.jdField_a_of_type_Rrm, false);
      continue;
      label318:
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(paramrot.jdField_a_of_type_Rrm);
    }
  }
  
  public void a(roy paramroy)
  {
    this.jdField_a_of_type_Roy = paramroy;
  }
  
  public void a(rqy paramrqy)
  {
    this.jdField_a_of_type_Rqy = paramrqy;
  }
  
  public void a(rsg paramrsg)
  {
    this.jdField_a_of_type_Rsg = paramrsg;
  }
  
  public void a(rul paramrul)
  {
    this.jdField_a_of_type_Rul = paramrul;
  }
  
  public void a(rup paramrup)
  {
    this.jdField_a_of_type_Rup = paramrup;
  }
  
  public void a(tmk paramtmk)
  {
    this.jdField_a_of_type_Tmk = paramtmk;
  }
  
  public void a(tqy paramtqy)
  {
    this.jdField_a_of_type_Tqy = paramtqy;
  }
  
  public void a(trb paramtrb)
  {
    this.jdField_a_of_type_Trb = paramtrb;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
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
        } while (localVideoInfo.jdField_c_of_type_JavaUtilArrayList == null);
        localObject = localVideoInfo.jdField_c_of_type_JavaUtilArrayList.iterator();
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
      tpn.c(this.jdField_a_of_type_AndroidAppActivity);
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
      if (((localObject instanceof rot)) && (((rot)localObject).jdField_c_of_type_Int == this.jdField_a_of_type_Rol.jdField_c_of_type_Int + 1))
      {
        localObject = ((rot)localObject).jdField_a_of_type_Rrm;
        if ((localObject != null) && ((((rrm)localObject).jdField_a_of_type_Boolean) || ((((rrm)localObject).jdField_a_of_type_Rwf != null) && (!((rrm)localObject).jdField_a_of_type_Rwf.a()))))
        {
          ((rrm)localObject).jdField_a_of_type_Boolean = false;
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.c((rrm)localObject);
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
      g();
      this.jdField_a_of_type_JavaUtilList.remove(paramVideoInfo);
      this.jdField_a_of_type_Rol = null;
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
    ubd.a(this);
    if ((this.jdField_a_of_type_Rol != null) && (this.jdField_a_of_type_Rol.jdField_a_of_type_Rln != null) && ((this.jdField_a_of_type_Rol.jdField_a_of_type_Rln instanceof rob))) {
      ((rob)this.jdField_a_of_type_Rol.jdField_a_of_type_Rln).e();
    }
    ApngImage.playByTag(28);
    ApngImage.playByTag(29);
    ApngImage.playByTag(30);
    tpn.d();
    tqa.a(this.jdField_a_of_type_Tqy, this, (rot)this.jdField_a_of_type_Rol);
  }
  
  public void e(boolean paramBoolean)
  {
    if ((!this.o) && (paramBoolean) && (this.p))
    {
      if ((this.jdField_a_of_type_Rol instanceof rot)) {
        a((rot)this.jdField_a_of_type_Rol);
      }
      this.p = false;
    }
    this.o = paramBoolean;
  }
  
  public void f()
  {
    if ((this.jdField_a_of_type_Sbg != null) && (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null)) {
      ThreadManager.excute(new VideoFeedsAdapter.12(this), 16, null, true);
    }
    if (this.jdField_a_of_type_Roi != null) {
      this.jdField_a_of_type_Roi = null;
    }
    if (this.jdField_a_of_type_Rol != null) {
      this.jdField_a_of_type_Rol.jdField_b_of_type_ComTencentImageURLImageView = null;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidOsHandler = null;
    this.jdField_a_of_type_Blol = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    if (this.jdField_a_of_type_Toa != null) {
      this.jdField_a_of_type_Toa.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler != null) {
      AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    }
    if (this.jdField_a_of_type_Rmr != null)
    {
      this.jdField_a_of_type_Rmr.b();
      this.jdField_a_of_type_Rmr = null;
    }
    tpn.e();
    bjsz.a().b(VideoFeedsUGView.a);
    if (this.jdField_a_of_type_Rot != null)
    {
      a(this.jdField_a_of_type_Rot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsUGView, false);
      a(this.jdField_a_of_type_Rot.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsUGView, false);
    }
  }
  
  public void f(boolean paramBoolean) {}
  
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
    if ((this.jdField_a_of_type_Roo != null) && (this.jdField_a_of_type_Roo.itemView != null)) {
      return this.jdField_a_of_type_Roo.itemView.hashCode();
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
    roj localroj = (roj)paramView.getTag();
    Object localObject = null;
    if ((localroj instanceof rot))
    {
      VideoInfo localVideoInfo = ((rot)localroj).jdField_a_of_type_Rrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
      if ((this.jdField_a_of_type_Rol != null) && (this.jdField_a_of_type_Rol.jdField_a_of_type_Rrm != null))
      {
        localObject = localVideoInfo;
        if (localVideoInfo == this.jdField_a_of_type_Rol.jdField_a_of_type_Rrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo) {
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
        c(paramView, localroj, localObject);
        b(paramView, localroj, localObject);
        a(paramView, localroj, localObject);
      }
    }
  }
  
  public void onLoadUserInfoFailed(String paramString1, String paramString2) {}
  
  public void onLoadUserInfoSucceed(String paramString, ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    if (paramReadInJoyUserInfo != null) {
      rpt.a(new VideoFeedsAdapter.11(this, paramString));
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    roj localroj = (roj)paramView.getTag();
    VideoInfo localVideoInfo = null;
    if ((localroj instanceof rot))
    {
      localVideoInfo = ((rot)localroj).jdField_a_of_type_Rrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
      if ((this.jdField_a_of_type_Rol != null) && (this.jdField_a_of_type_Rol.jdField_a_of_type_Rrm != null) && (localVideoInfo == this.jdField_a_of_type_Rol.jdField_a_of_type_Rrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo)) {}
    }
    while (localVideoInfo == null) {
      return false;
    }
    switch (paramView.getId())
    {
    default: 
      return false;
    }
    if (omu.b() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      a(localVideoInfo, true, bool);
      if (this.jdField_a_of_type_Rsg != null) {
        this.jdField_a_of_type_Rsg.a(2, localVideoInfo, 0L);
      }
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rnu
 * JD-Core Version:    0.7.0.1
 */