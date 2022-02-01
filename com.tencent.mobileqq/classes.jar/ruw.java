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
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
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

public class ruw
  extends RecyclerView.Adapter<rvl>
  implements View.OnClickListener, View.OnLongClickListener, pwf, rwl, rzm, sgh
{
  private static boolean jdField_a_of_type_Boolean;
  private int jdField_a_of_type_Int;
  public long a;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Context jdField_a_of_type_AndroidContentContext;
  private ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private Handler jdField_a_of_type_AndroidOsHandler = new rvb(this, Looper.getMainLooper());
  private LinearLayoutManager jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager;
  private RecyclerView.RecycledViewPool jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$RecycledViewPool = new RecyclerView.RecycledViewPool();
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private bjrq jdField_a_of_type_Bjrq;
  private bjsv jdField_a_of_type_Bjsv;
  private VideoInfo jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
  private VideoFeedsPlayManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager;
  private VideoFeedsRecyclerView jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView;
  private VideoPreDownloadMgr jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr;
  private ADVideoAppDownloadManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadManager;
  public GdtHandler.Params a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private INetInfoHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new rva(this);
  private String jdField_a_of_type_JavaLangString;
  public HashMap<String, Integer> a;
  private List<VideoInfo> jdField_a_of_type_JavaUtilList;
  private Map<Integer, Bitmap> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  private qye jdField_a_of_type_Qye;
  private rtp jdField_a_of_type_Rtp;
  private rtt jdField_a_of_type_Rtt;
  private rtv jdField_a_of_type_Rtv;
  private rvk jdField_a_of_type_Rvk;
  private rvn jdField_a_of_type_Rvn;
  rvq jdField_a_of_type_Rvq;
  private rvv jdField_a_of_type_Rvv;
  private rwa jdField_a_of_type_Rwa;
  private rya jdField_a_of_type_Rya;
  private rzk jdField_a_of_type_Rzk;
  private rzo jdField_a_of_type_Rzo;
  public rzt a;
  private sbp jdField_a_of_type_Sbp;
  private sbt jdField_a_of_type_Sbt;
  private sie jdField_a_of_type_Sie;
  private tsf jdField_a_of_type_Tsf;
  private tty jdField_a_of_type_Tty;
  private txm jdField_a_of_type_Txm;
  private txu jdField_a_of_type_Txu;
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
  
  public ruw(Context paramContext, Activity paramActivity, VideoFeedsRecyclerView paramVideoFeedsRecyclerView, LinearLayoutManager paramLinearLayoutManager, QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt, rzo paramrzo)
  {
    this.jdField_a_of_type_Long = -2147483648L;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_Rzt = new rvc(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView = paramVideoFeedsRecyclerView;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.a(this.jdField_a_of_type_Rzt);
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager = paramLinearLayoutManager;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = bfvo.a(true);
    this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131165351));
    this.jdField_a_of_type_Rtp = rtp.a();
    this.jdField_a_of_type_Rtt = new rtt(paramActivity);
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_c_of_type_JavaLangString = paramString3;
    jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Bjrq = new bjrq(this.jdField_a_of_type_AndroidAppActivity);
    AppNetConnInfo.registerConnectionChangeReceiver(this.jdField_a_of_type_AndroidAppActivity.getApplication(), this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(1930498322);
    this.jdField_a_of_type_Rzo = paramrzo;
    setHasStableIds(true);
    registerAdapterDataObserver(new rvj(this, null));
    this.r = bbyp.b();
    this.jdField_a_of_type_Tty = new tty(paramActivity, this);
    this.s = bkwm.d();
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
      paramVideoInfo = txa.a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
      this.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params = uhs.a(this.jdField_a_of_type_AndroidAppActivity, paramVideoInfo, null, 3, false, null);
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
      return amtj.a(2131715260);
    }
    if (paramInt == 2) {
      return amtj.a(2131715257);
    }
    return null;
  }
  
  private void a(View paramView, int paramInt, VideoInfo paramVideoInfo)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.d())) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.b();
    }
    if (this.jdField_a_of_type_Tty != null) {
      this.jdField_a_of_type_Tty.a(paramView, paramInt, paramVideoInfo);
    }
  }
  
  private void a(View paramView, VideoInfo paramVideoInfo)
  {
    if ((paramVideoInfo.jdField_c_of_type_Boolean) && ((this.jdField_a_of_type_Rvn instanceof rvi))) {
      a(paramView, (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(), paramVideoInfo);
    }
  }
  
  private void a(View paramView, rvl paramrvl, VideoInfo paramVideoInfo)
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
      a(paramrvl);
      return;
    } while ((this.jdField_a_of_type_Rvn == null) || (this.jdField_a_of_type_Rvn.l == null));
    this.jdField_a_of_type_Rzo.e();
    c(this.jdField_a_of_type_Rvn.jdField_a_of_type_Ryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo, "0X8009F42");
  }
  
  private void a(View paramView, rvl paramrvl, VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131367802: 
      do
      {
        return;
        this.jdField_a_of_type_AndroidOsHandler.sendMessage(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(9, Boolean.valueOf(false)));
        this.j = true;
      } while (!(this.jdField_a_of_type_Rvn instanceof rvi));
      c((rvi)this.jdField_a_of_type_Rvn);
      return;
    case 2131362064: 
    case 2131367808: 
      a(paramrvl, paramVideoInfo, paramAdvertisementInfo, obb.aW);
      return;
    case 2131367813: 
      c(paramVideoInfo, paramAdvertisementInfo);
      return;
    case 2131367822: 
      b(paramVideoInfo, paramAdvertisementInfo);
      return;
    case 2131367810: 
      a(paramVideoInfo, paramAdvertisementInfo);
      return;
    case 2131367799: 
      twr.a(paramAdvertisementInfo, 37, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
      a(paramrvl, paramVideoInfo, paramAdvertisementInfo, obb.aU);
      return;
    case 2131367797: 
      twr.a(paramAdvertisementInfo, 34, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
      a(paramrvl, paramVideoInfo, paramAdvertisementInfo, obb.aT);
      return;
    case 2131365770: 
    case 2131367798: 
      twr.a(paramAdvertisementInfo, 35, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
      a(paramrvl, paramVideoInfo, paramAdvertisementInfo, obb.aS);
      return;
    case 2131365774: 
      twr.a(paramAdvertisementInfo, 2003, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
      a(paramrvl, paramVideoInfo, paramAdvertisementInfo, 2003);
      return;
    case 2131362065: 
      twr.a(paramAdvertisementInfo, 18, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
      uhs.b(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, true, null);
      paramView = obb.a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
      obb.a(new trn().a(this.jdField_a_of_type_AndroidContentContext).a(obb.jdField_a_of_type_Int).b(obb.aa).a(paramView).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).d(1000).a());
      return;
    }
    a(paramrvl, paramVideoInfo, paramAdvertisementInfo, obb.aV);
  }
  
  private void a(VideoAdInfo paramVideoAdInfo)
  {
    paramVideoAdInfo = obb.a(paramVideoAdInfo);
    if (paramVideoAdInfo != null) {
      uhs.a(this.jdField_a_of_type_AndroidAppActivity, paramVideoAdInfo.mPopFormH5Url, paramVideoAdInfo.mAdRl, paramVideoAdInfo.mAdTraceId);
    }
  }
  
  private void a(VideoInfo paramVideoInfo, int paramInt)
  {
    if (paramVideoInfo == null) {
      return;
    }
    AdvertisementInfo localAdvertisementInfo = obb.a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
    if (paramVideoInfo.a(this.jdField_a_of_type_AndroidAppActivity))
    {
      obb.a(new trn().a(this.jdField_a_of_type_AndroidContentContext).a(obb.jdField_a_of_type_Int).b(obb.R).a(localAdvertisementInfo).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).d(paramInt).a());
      return;
    }
    obb.a(new trn().a(this.jdField_a_of_type_AndroidContentContext).a(obb.jdField_a_of_type_Int).b(obb.P).a(localAdvertisementInfo).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).d(paramInt).a());
  }
  
  private void a(VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo)
  {
    twr.a(paramAdvertisementInfo, 17, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
    if (a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo))
    {
      a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
      obb.a(new trn().a(this.jdField_a_of_type_AndroidContentContext).a(obb.L).b(obb.P).a(paramAdvertisementInfo).a());
      return;
    }
    this.jdField_a_of_type_Txm.f();
    if (paramAdvertisementInfo != null) {
      uhs.b(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, true, null);
    }
    a(paramVideoInfo, obb.aB);
  }
  
  private void a(VideoInfo paramVideoInfo, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i2 = 2;
    int i3 = 1;
    Object localObject2 = new sie(paramVideoInfo).a().a("scene_type", Integer.valueOf(3)).i(paramVideoInfo.g).e(paramVideoInfo.f).c(paramVideoInfo.jdField_q_of_type_Int);
    Object localObject1;
    label84:
    int i1;
    if (paramVideoInfo.jdField_b_of_type_Boolean)
    {
      localObject1 = paramVideoInfo.j;
      localObject2 = ((sie)localObject2).a("ugcuin", localObject1);
      if (!paramBoolean1) {
        break label187;
      }
      localObject1 = "click_type";
      if (!paramBoolean2) {
        break label195;
      }
      i1 = 2;
      label92:
      localObject1 = ((sie)localObject2).a((String)localObject1, Integer.valueOf(i1));
      if (!paramBoolean1) {
        break label207;
      }
      if (!paramBoolean2) {
        break label201;
      }
      i1 = i3;
      label119:
      ((sie)localObject1).a("click_type", Integer.valueOf(i1));
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
      odq.b(null, (String)localObject2, paramString, paramString, 0, 0, "0", "", paramVideoInfo, ((sie)localObject1).a().a(), false);
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
        ((sie)localObject1).a("button_type", Integer.valueOf(i1));
        break;
      }
    }
  }
  
  private void a(VideoInfo paramVideoInfo, rvl paramrvl)
  {
    boolean bool = true;
    if ((paramVideoInfo.jdField_c_of_type_Boolean) && ((paramrvl instanceof rvi)))
    {
      twb.a((rvi)paramrvl, "暂不支持biu");
      return;
    }
    if ((paramrvl instanceof rvv)) {
      rwv.a(((rvv)paramrvl).n, paramVideoInfo, "click_biu");
    }
    if (oof.a() == 1) {}
    for (;;)
    {
      a(paramVideoInfo, false, bool);
      if (this.jdField_a_of_type_Rzk == null) {
        break;
      }
      this.jdField_a_of_type_Rzk.a(2, paramVideoInfo, 0L);
      return;
      bool = false;
    }
  }
  
  private void a(VideoInfo paramVideoInfo, sie paramsie)
  {
    if (paramsie == null) {
      return;
    }
    String str2;
    if (jdField_a_of_type_Boolean)
    {
      str2 = paramVideoInfo.j;
      if (!TextUtils.isEmpty(paramVideoInfo.g)) {}
      for (str1 = paramVideoInfo.g;; str1 = "0")
      {
        odq.b(null, str2, "0X8009298", "0X8009298", 0, 0, "0", "", str1, paramsie.a().a(), false);
        c(paramVideoInfo, "0X800AD00");
        if ((paramVideoInfo.jdField_d_of_type_JavaUtilArrayList == null) || (paramVideoInfo.jdField_d_of_type_JavaUtilArrayList.size() <= 0)) {
          break;
        }
        rzu.a.a(paramVideoInfo);
        return;
      }
    }
    int i1;
    if ((!TextUtils.isEmpty(paramVideoInfo.u)) && (rwv.e()))
    {
      i1 = 1;
      label122:
      paramsie.R(i1).a(paramVideoInfo).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo).b(this.s).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo);
      str2 = paramVideoInfo.j;
      if (TextUtils.isEmpty(paramVideoInfo.g)) {
        break label213;
      }
    }
    label213:
    for (String str1 = paramVideoInfo.g;; str1 = "0")
    {
      odq.b(null, str2, "0X8007801", "0X8007801", 0, 0, "0", "", str1, paramsie.a().a(), false);
      break;
      i1 = 0;
      break label122;
    }
  }
  
  private void a(VideoInfo paramVideoInfo, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramVideoInfo == null) {
      return;
    }
    b(paramVideoInfo, paramBoolean2);
    Object localObject1;
    if ((paramVideoInfo.jdField_a_of_type_Int == 0) && (paramVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null))
    {
      localObject1 = paramVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5();
      localObject1 = new sie((String)localObject1, paramVideoInfo.j, paramVideoInfo.jdField_a_of_type_JavaLangString, paramVideoInfo.g, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(), paramVideoInfo.a() * 1000);
      ((sie)localObject1).g(paramBoolean1).h(paramBoolean2).b(this.s);
      if (!jdField_a_of_type_Boolean)
      {
        ((sie)localObject1).e(paramVideoInfo.f).c(paramVideoInfo.jdField_q_of_type_Int).a(-1).a(paramVideoInfo.y).M(0);
        localObject2 = new rdz();
        ((rdz)localObject2).jdField_d_of_type_Int = ((int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a());
        ((rdz)localObject2).jdField_e_of_type_Int = (paramVideoInfo.a() * 1000);
        ((rdz)localObject2).jdField_b_of_type_Int = this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
        ofe.b(paramVideoInfo, this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_CHANNEL_ID", -1), 25, -1, (rdz)localObject2, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g);
      }
      localObject1 = ((sie)localObject1).a().a();
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
      odq.a(null, (String)localObject2, "0X8009299", "0X8009299", 0, 0, "0", "0", paramVideoInfo, (String)localObject1, false);
      return;
      localObject1 = null;
      break;
    }
    label288:
    Object localObject2 = paramVideoInfo.j;
    if (!TextUtils.isEmpty(paramVideoInfo.g)) {}
    for (paramVideoInfo = paramVideoInfo.g;; paramVideoInfo = "0")
    {
      odq.a(null, (String)localObject2, "0X8007B89", "0X8007B89", 0, 0, "0", "0", paramVideoInfo, (String)localObject1, false);
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
      rwv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramBoolean, paramString2, false);
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
  
  private void a(rvi paramrvi)
  {
    int i1;
    Object localObject;
    if ((paramrvi != null) && (paramrvi.jdField_a_of_type_Ryo != null) && (paramrvi.jdField_a_of_type_Ryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (paramrvi.jdField_a_of_type_Ryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo != null))
    {
      i1 = twq.d(obb.a(paramrvi.jdField_a_of_type_Ryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo));
      if (i1 != 1) {
        break label84;
      }
      paramrvi = paramrvi.jdField_b_of_type_AndroidViewView;
      localObject = (LinearLayout.LayoutParams)paramrvi.getLayoutParams();
      if (localObject != null)
      {
        ((LinearLayout.LayoutParams)localObject).weight = 2.0F;
        paramrvi.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
    label84:
    do
    {
      do
      {
        return;
      } while (i1 != 2);
      localObject = paramrvi.jdField_c_of_type_AndroidViewView;
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((View)localObject).getLayoutParams();
      if (localLayoutParams != null)
      {
        localLayoutParams.weight = 0.0F;
        ((View)localObject).setLayoutParams(localLayoutParams);
      }
      paramrvi = paramrvi.jdField_d_of_type_AndroidViewView;
      localObject = (LinearLayout.LayoutParams)paramrvi.getLayoutParams();
    } while (localObject == null);
    ((LinearLayout.LayoutParams)localObject).weight = 0.0F;
    paramrvi.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  private void a(rvi paramrvi, VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo, int paramInt, View[] paramArrayOfView1, View[] paramArrayOfView2)
  {
    if (paramVideoInfo.jdField_c_of_type_Boolean) {
      if (paramAdvertisementInfo == null) {
        break label455;
      }
    }
    label455:
    for (int i1 = paramAdvertisementInfo.clickPos;; i1 = 1000)
    {
      if ((AdvertisementInfo.isAppAdvertisementInfo(paramAdvertisementInfo)) && (twq.d(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo)))
      {
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadManager.a(paramVideoInfo))
        {
          uhs.b(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, true, null);
          if (paramInt == obb.aa)
          {
            paramrvi = obb.a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
            obb.a(new trn().a(this.jdField_a_of_type_AndroidContentContext).a(obb.jdField_a_of_type_Int).b(obb.aa).a(paramrvi).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).d(i1).a());
            return;
          }
          a(paramVideoInfo, i1);
          return;
        }
        twr.a(paramAdvertisementInfo, i1, null);
        int i3 = paramArrayOfView1.length;
        int i2 = 0;
        while (i2 < i3)
        {
          paramArrayOfView1[i2].setVisibility(0);
          i2 += 1;
        }
        paramrvi.jdField_a_of_type_Boolean = true;
        i3 = paramArrayOfView2.length;
        i2 = 0;
        while (i2 < i3)
        {
          paramArrayOfView2[i2].setVisibility(8);
          i2 += 1;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadManager.f();
        twb.a(paramrvi);
        if (paramInt == obb.aa)
        {
          obb.a(new trn().a(this.jdField_a_of_type_AndroidContentContext).a(obb.jdField_a_of_type_Int).b(obb.am).a(paramAdvertisementInfo).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).d(i1).a());
          return;
        }
        obb.a(new trn().a(this.jdField_a_of_type_AndroidContentContext).a(obb.jdField_a_of_type_Int).b(obb.am).a(paramAdvertisementInfo).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).a());
        return;
      }
      if (paramInt == obb.aa)
      {
        paramInt = 38;
        paramrvi = obb.a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
        obb.a(new trn().a(this.jdField_a_of_type_AndroidContentContext).a(obb.jdField_a_of_type_Int).b(obb.aa).a(paramrvi).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).d(i1).a());
        if (paramAdvertisementInfo != null) {
          paramAdvertisementInfo.setClickPos(paramInt);
        }
        paramrvi = new trj();
        paramrvi.jdField_c_of_type_Boolean = true;
        uhs.b(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, true, paramrvi);
        return;
      }
      if (this.i) {}
      for (paramInt = 13;; paramInt = 8)
      {
        a(paramVideoInfo, paramInt);
        break;
      }
    }
  }
  
  private void a(rvl paramrvl)
  {
    if ((paramrvl.jdField_a_of_type_Int == 2) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.b())) {
      rwv.a(((rvv)paramrvl).jdField_d_of_type_AndroidViewViewGroup, 8, 200);
    }
    if (this.jdField_a_of_type_Rzo != null) {
      this.jdField_a_of_type_Rzo.b();
    }
  }
  
  private void a(rvl paramrvl, VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo)
  {
    if ((paramrvl instanceof rvi))
    {
      rvi localrvi = (rvi)paramrvl;
      twb.c(localrvi.jdField_b_of_type_AndroidWidgetSeekBar);
      a(paramrvl, paramVideoInfo, paramAdvertisementInfo, -1, localrvi.jdField_a_of_type_AndroidViewView, new View[] { localrvi.jdField_c_of_type_AndroidWidgetRelativeLayout });
    }
  }
  
  private void a(rvl paramrvl, VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo, int paramInt)
  {
    if ((paramrvl == null) || (paramVideoInfo == null) || (paramAdvertisementInfo == null)) {}
    do
    {
      return;
      if ((!AdvertisementInfo.isAppAdvertisementInfo(paramAdvertisementInfo)) || (!twq.a(paramAdvertisementInfo))) {
        break;
      }
      paramAdvertisementInfo.setClickPos(paramInt);
    } while (!(paramrvl instanceof rvi));
    rvi localrvi = (rvi)paramrvl;
    if ((localrvi.jdField_a_of_type_Boolean) && (twq.a(paramAdvertisementInfo)) && (localrvi.p.getVisibility() == 0))
    {
      d(paramrvl, paramVideoInfo, paramAdvertisementInfo);
      return;
    }
    c(paramrvl, paramVideoInfo, paramAdvertisementInfo);
    return;
    paramAdvertisementInfo.setClickPos(paramInt);
    uhs.b(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, true, null);
    paramrvl = obb.a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
    obb.a(new trn().a(this.jdField_a_of_type_AndroidContentContext).a(obb.jdField_a_of_type_Int).b(obb.aa).a(paramrvl).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).d(paramInt).a());
  }
  
  private void a(rvl paramrvl, VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo, int paramInt, View paramView, View... paramVarArgs)
  {
    if (paramVideoInfo.jdField_c_of_type_Boolean) {
      if (paramAdvertisementInfo == null) {
        break label202;
      }
    }
    label202:
    for (int i1 = paramAdvertisementInfo.clickPos;; i1 = 1000)
    {
      if ((AdvertisementInfo.isAppAdvertisementInfo(paramAdvertisementInfo)) && (twq.d(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo)))
      {
        if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadManager.a(paramVideoInfo)) {
          break label123;
        }
        uhs.b(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, true, null);
        if (paramInt != obb.aa) {
          break label115;
        }
        obb.a(new trn().a(this.jdField_a_of_type_AndroidContentContext).a(obb.jdField_a_of_type_Int).b(obb.aa).a(paramAdvertisementInfo).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).d(i1).a());
      }
      label115:
      label123:
      do
      {
        return;
        a(paramVideoInfo, i1);
        return;
        paramView.setVisibility(0);
        ((rvi)paramrvl).jdField_a_of_type_Boolean = true;
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
      } while (!(paramrvl instanceof rvi));
      ((rvi)paramrvl).jdField_a_of_type_Boolean = true;
      twb.a((rvi)paramrvl);
      return;
    }
  }
  
  private void a(rvn paramrvn)
  {
    if ((this.jdField_a_of_type_Rvn != null) && (this.jdField_a_of_type_Rvn.jdField_a_of_type_Ryo != null) && (this.jdField_a_of_type_Rvn.jdField_a_of_type_Ryo.jdField_a_of_type_Sdj != null))
    {
      sdj localsdj = this.jdField_a_of_type_Rvn.jdField_a_of_type_Ryo.jdField_a_of_type_Sdj;
      if ((!localsdj.a()) && (!localsdj.b()) && (!localsdj.c()) && (this.jdField_a_of_type_Rvn.jdField_c_of_type_Int == paramrvn.jdField_c_of_type_Int - 1) && (bkwm.w(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (sfm.a().a(this.jdField_a_of_type_Rvn.jdField_a_of_type_Ryo.jdField_a_of_type_Sdj))) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.b(paramrvn.jdField_a_of_type_Ryo);
      }
    }
  }
  
  private void a(rvn paramrvn, VideoInfo paramVideoInfo)
  {
    ryo localryo2 = paramrvn.jdField_a_of_type_Ryo;
    ryo localryo1 = localryo2;
    if (localryo2 == null)
    {
      localryo1 = new ryo();
      localryo1.jdField_a_of_type_Rsr = paramrvn.jdField_a_of_type_Scs;
      localryo1.jdField_a_of_type_AndroidOsBundle.putInt("jump_from_scene", this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("PERFORMANCE_REPORT_VIDEO_FEEDS_JUMP_FROM", 0));
    }
    localryo1.jdField_a_of_type_ComTencentBizPubaccountVideoInfo = paramVideoInfo;
    localryo1.jdField_a_of_type_Int = paramVideoInfo.a(this.jdField_a_of_type_AndroidAppActivity, paramrvn.jdField_d_of_type_Int);
    localryo1.jdField_a_of_type_AndroidViewViewGroup = paramrvn.jdField_b_of_type_AndroidViewViewGroup;
    localryo1.jdField_b_of_type_Int = paramrvn.jdField_c_of_type_Int;
    localryo1.jdField_a_of_type_Boolean = false;
    localryo1.jdField_a_of_type_AndroidOsBundle.putInt("video_feeds_index", paramrvn.jdField_c_of_type_Int);
    localryo1.jdField_a_of_type_Long = 0L;
    localryo1.jdField_b_of_type_Boolean = true;
    if (paramVideoInfo.jdField_c_of_type_Boolean)
    {
      if (!paramVideoInfo.a(this.jdField_a_of_type_AndroidAppActivity)) {
        break label174;
      }
      localryo1.jdField_a_of_type_AndroidOsBundle.putInt("ad_origin", obb.R);
    }
    for (;;)
    {
      paramrvn.jdField_a_of_type_Scs.jdField_a_of_type_Boolean = true;
      paramrvn.jdField_a_of_type_Ryo = localryo1;
      paramrvn.jdField_a_of_type_Shp.a(this, paramrvn);
      return;
      label174:
      localryo1.jdField_a_of_type_AndroidOsBundle.putInt("ad_origin", obb.P);
    }
  }
  
  private void a(rvn paramrvn1, rvn paramrvn2, boolean paramBoolean)
  {
    paramrvn2 = this.jdField_a_of_type_AndroidAppActivity;
    VideoInfo localVideoInfo = paramrvn1.jdField_a_of_type_Ryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
    int i1 = paramrvn1.jdField_b_of_type_Int;
    int i2 = paramrvn1.jdField_c_of_type_Int;
    int i3 = paramrvn1.jdField_a_of_type_Int;
    boolean bool1;
    if (((paramrvn1 instanceof rvs)) && (((rvs)paramrvn1).b.getVisibility() == 0))
    {
      bool1 = true;
      if ((!(paramrvn1 instanceof rvv)) || (((rvv)paramrvn1).jdField_a_of_type_Rsm == null) || (((rvv)paramrvn1).jdField_a_of_type_Rsm.a().getVisibility() != 0)) {
        break label128;
      }
    }
    label128:
    for (boolean bool2 = true;; bool2 = false)
    {
      ThreadManager.post(new VideoFeedsAdapter.5(this, localVideoInfo, paramrvn2, i2, paramBoolean, i1, i3, bool1, bool2), 1, null, true);
      return;
      bool1 = false;
      break;
    }
  }
  
  private void a(rvq paramrvq)
  {
    if (this.jdField_b_of_type_Int == 1)
    {
      paramrvq.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      paramrvq.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      paramrvq.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramrvq.jdField_a_of_type_AndroidWidgetTextView.setText(a(1));
    }
    do
    {
      return;
      if (this.jdField_b_of_type_Int == 2)
      {
        paramrvq.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
        paramrvq.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        paramrvq.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        paramrvq.jdField_a_of_type_AndroidWidgetTextView.setText(a(2));
        return;
      }
    } while (this.jdField_b_of_type_Int != 3);
    if (paramrvq.jdField_a_of_type_Int == 6)
    {
      paramrvq.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      paramrvq.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      paramrvq.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramrvq.jdField_a_of_type_AndroidWidgetTextView.setText(a(1));
      return;
    }
    paramrvq.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
    paramrvq.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    paramrvq.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  private void a(rvv paramrvv, VideoInfo paramVideoInfo)
  {
    this.jdField_a_of_type_Txm.e();
    a(false, paramrvv);
    a(paramrvv);
    a(paramVideoInfo, obb.aC);
  }
  
  private void a(rvv paramrvv, VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo)
  {
    if ((paramVideoInfo.jdField_c_of_type_Boolean) && ((paramrvv instanceof rvi)))
    {
      twb.a((rvi)paramrvv, "作者设置暂不可评论");
      return;
    }
    rwv.a(paramrvv.p, paramVideoInfo, "click_comment");
    paramAdvertisementInfo = new JSONObject();
    this.jdField_a_of_type_Rwa.e();
    for (;;)
    {
      try
      {
        if (paramVideoInfo.y == null) {
          continue;
        }
        paramrvv = paramVideoInfo.y;
        paramAdvertisementInfo.put("video_report_info", paramrvv);
        paramAdvertisementInfo.put("video_type", 0);
        if (!this.s) {
          continue;
        }
        i1 = 1;
        paramAdvertisementInfo.put("interact_button_style", i1);
      }
      catch (JSONException paramrvv)
      {
        int i1;
        paramrvv.printStackTrace();
        continue;
        odq.a(null, "", "0X8008E54", "0X8008E54", 0, 0, "", "", "", ofe.a("", "", paramVideoInfo.jdField_a_of_type_JavaLangString, paramVideoInfo.g, paramAdvertisementInfo), false);
      }
      if (!jdField_a_of_type_Boolean) {
        continue;
      }
      odq.a(null, "", "0X80092A1", "0X80092A1", 0, 0, "", "", "", ofe.a("", "", paramVideoInfo.jdField_a_of_type_JavaLangString, paramVideoInfo.g, paramAdvertisementInfo), false);
      return;
      paramrvv = "";
      continue;
      i1 = 0;
    }
  }
  
  private void a(rvv paramrvv, boolean paramBoolean, long paramLong, int paramInt)
  {
    if (paramBoolean)
    {
      if (this.jdField_b_of_type_Long != 0L) {
        ThreadManager.excute(new VideoFeedsAdapter.2(this, paramLong), 16, null, true);
      }
      if ((paramrvv.jdField_a_of_type_Ryo != null) && (paramrvv.jdField_a_of_type_Ryo.jdField_a_of_type_Rdt != null))
      {
        paramrvv.jdField_a_of_type_Ryo.jdField_a_of_type_Rdt.o = paramLong;
        paramrvv.jdField_a_of_type_Ryo.jdField_a_of_type_Rdt.s = pay.a(paramInt, paramrvv.jdField_c_of_type_Int, false);
      }
      if ((paramrvv.jdField_a_of_type_Ryo != null) && (paramrvv.jdField_a_of_type_Ryo.jdField_a_of_type_Rds != null)) {
        paramrvv.jdField_a_of_type_Ryo.jdField_a_of_type_Rds.jdField_a_of_type_Boolean = true;
      }
    }
  }
  
  @RequiresApi(api=16)
  private void a(ryo paramryo)
  {
    rwv.a(this.jdField_a_of_type_Rvn.jdField_c_of_type_ComTencentImageURLImageView, 8, 0);
    this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView().getViewTreeObserver().addOnDrawListener(new rux(this, paramryo));
  }
  
  private void a(boolean paramBoolean, rvv paramrvv)
  {
    if (!(paramrvv instanceof rvi)) {
      return;
    }
    rvi localrvi = (rvi)paramrvv;
    if (localrvi.jdField_a_of_type_AndroidViewView != null)
    {
      localrvi.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      localrvi.jdField_a_of_type_AndroidViewView.getParent().requestDisallowInterceptTouchEvent(true);
      localrvi.jdField_a_of_type_AndroidViewView.setTag(localrvi);
    }
    if (localrvi.p != null)
    {
      localrvi.p.setOnClickListener(this);
      localrvi.p.getParent().requestDisallowInterceptTouchEvent(true);
      localrvi.p.setTag(localrvi);
    }
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localrvi.jdField_a_of_type_Ryo != null)
    {
      bool1 = bool2;
      if (localrvi.jdField_a_of_type_Ryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null)
      {
        bool1 = bool2;
        if (localrvi.jdField_a_of_type_Ryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo != null) {
          bool1 = twq.d(localrvi.jdField_a_of_type_Ryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
        }
      }
    }
    if ((localrvi.jdField_a_of_type_Boolean) && (bool1))
    {
      twb.b(localrvi.jdField_c_of_type_AndroidWidgetRelativeLayout);
      twb.b(localrvi.e);
      if (!this.s) {
        twb.c(localrvi.jdField_b_of_type_AndroidWidgetSeekBar);
      }
      if (b(localrvi.jdField_a_of_type_Ryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo))
      {
        twb.a(localrvi.e);
        return;
      }
      twb.a(localrvi.jdField_a_of_type_AndroidViewView);
      return;
    }
    twb.b(localrvi.jdField_a_of_type_AndroidViewView);
    if (localrvi.jdField_d_of_type_AndroidViewViewGroup.getVisibility() == 8) {
      twb.a(localrvi.jdField_b_of_type_AndroidWidgetSeekBar);
    }
    if ((localrvi.jdField_a_of_type_Ryo != null) && (localrvi.jdField_a_of_type_Ryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (localrvi.jdField_a_of_type_Ryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo != null))
    {
      if (!b(localrvi.jdField_a_of_type_Ryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo)) {
        break label330;
      }
      twb.b(localrvi.jdField_c_of_type_AndroidWidgetRelativeLayout);
      twb.a(localrvi.e);
    }
    for (;;)
    {
      a(localrvi);
      return;
      label330:
      if (a(localrvi))
      {
        twb.b(localrvi.e);
        twb.a(localrvi.jdField_c_of_type_AndroidWidgetRelativeLayout);
        if ((paramrvv instanceof rvi)) {
          twb.a(this.jdField_a_of_type_AndroidAppActivity, (rvi)paramrvv);
        }
        twb.a(paramBoolean, localrvi);
      }
      else
      {
        twb.b(localrvi.e);
        twb.b(localrvi.jdField_c_of_type_AndroidWidgetRelativeLayout);
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
      if ((i3 >= 0) && ((paramList instanceof rvv)) && (((rvv)paramList).jdField_b_of_type_Int == i3))
      {
        ((rvv)paramList).jdField_a_of_type_Rsn.b(paramVideoInfo);
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
      if ((localViewHolder instanceof rvv))
      {
        VideoInfo localVideoInfo = (VideoInfo)paramList.get(((rvv)localViewHolder).jdField_b_of_type_Int);
        if (paramString.equals(localVideoInfo.j)) {
          ((rvv)localViewHolder).jdField_a_of_type_Rsn.b(localVideoInfo);
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
      paramVideoAdInfo = obb.a(paramVideoAdInfo);
    } while ((TextUtils.isEmpty(paramVideoAdInfo.mPopFormH5Url)) || (!twq.d(paramVideoAdInfo)));
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
        if (!paramVideoInfo.jdField_q_of_type_Boolean) {
          bool1 = true;
        }
        paramVideoInfo.jdField_q_of_type_Boolean = true;
      }
    }
    return bool1;
  }
  
  private boolean a(rvi paramrvi)
  {
    boolean bool3 = true;
    boolean bool1 = true;
    boolean bool2 = bool1;
    if (paramrvi != null)
    {
      bool2 = bool1;
      if (paramrvi.jdField_a_of_type_Ryo != null)
      {
        if (paramrvi.jdField_a_of_type_Ryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) {
          break label34;
        }
        bool2 = bool1;
      }
    }
    label34:
    do
    {
      return bool2;
      paramrvi = paramrvi.jdField_a_of_type_Ryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
      bool1 = bool3;
      if (paramrvi.jdField_c_of_type_Boolean)
      {
        paramrvi = obb.a(paramrvi.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
        bool1 = bool3;
        if (paramrvi != null)
        {
          bool1 = bool3;
          if (!paramrvi.mShowAdButton) {
            bool1 = false;
          }
        }
      }
      bool2 = bool1;
    } while (!QLog.isColorLevel());
    QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "showButton = " + bool1);
    return bool1;
  }
  
  private boolean a(rvv paramrvv)
  {
    boolean bool4 = true;
    boolean bool2 = true;
    boolean bool3 = false;
    paramrvv.jdField_a_of_type_Scs.jdField_a_of_type_Boolean = false;
    boolean bool1 = bool2;
    Bundle localBundle;
    int i2;
    if (paramrvv.jdField_c_of_type_Int == this.jdField_e_of_type_Int)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_AndroidContentContext != null)
      {
        bool1 = bool2;
        if (paramrvv.jdField_a_of_type_Ryo != null)
        {
          bool1 = bool2;
          if (paramrvv.jdField_a_of_type_Ryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null)
          {
            localBundle = this.jdField_a_of_type_AndroidAppActivity.getIntent().getExtras();
            i2 = localBundle.getInt("VIDEO_FROM_TYPE", 0);
            if (NetworkUtil.isMobileNetWork(this.jdField_a_of_type_AndroidContentContext)) {
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
      if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isVideoChatting())) {
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
        paramrvv = paramrvv.jdField_a_of_type_Scs;
        bool1 = bool3;
        if (i1 == 0) {
          bool1 = true;
        }
        paramrvv.jdField_a_of_type_Boolean = bool1;
        return true;
      }
      paramrvv = paramrvv.jdField_a_of_type_Scs;
      if (i1 == 0) {}
      for (bool1 = bool4;; bool1 = false)
      {
        paramrvv.jdField_a_of_type_Boolean = bool1;
        return false;
      }
    }
    if (i1 != 0)
    {
      paramrvv.jdField_a_of_type_Scs.jdField_a_of_type_Boolean = false;
      return true;
    }
    i1 = localBundle.getInt("VIDEO_PLAY_STATUS", 0);
    paramrvv = paramrvv.jdField_a_of_type_Scs;
    if (((2 != i2) && (6 != i2) && (5 != i2)) || (3 != i1))
    {
      bool1 = true;
      label275:
      paramrvv.jdField_a_of_type_Boolean = bool1;
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
    ImageView localImageView;
    if (this.jdField_a_of_type_Rzo != null)
    {
      this.jdField_a_of_type_Rzo.b();
      if ((this.jdField_a_of_type_Rvn instanceof rvv))
      {
        localImageView = this.jdField_a_of_type_Rvn.i;
        if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.e()) {
          break label83;
        }
      }
    }
    label83:
    for (String str = "click_pause";; str = "click_play")
    {
      rwv.a(localImageView, paramVideoInfo, str);
      this.jdField_a_of_type_Rvn.jdField_a_of_type_Shp.a();
      if (paramView.getId() == 2131366138) {
        shq.b(paramVideoInfo.g, 2);
      }
      return;
    }
  }
  
  private void b(View paramView, rvl paramrvl, VideoInfo paramVideoInfo)
  {
    AdvertisementInfo localAdvertisementInfo = a(paramVideoInfo);
    switch (paramView.getId())
    {
    default: 
    case 2131367034: 
    case 2131372016: 
    case 2131364627: 
    case 2131367342: 
    case 2131367982: 
    case 2131364900: 
    case 2131367059: 
    case 2131367060: 
    case 2131367041: 
    case 2131380559: 
    case 2131367824: 
    case 2131361855: 
      do
      {
        do
        {
          return;
          a(paramVideoInfo, paramrvl);
          return;
        } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView == null);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.b();
        return;
        f(paramVideoInfo);
        return;
        a(paramView);
        return;
        b((rvv)paramrvl, paramVideoInfo, localAdvertisementInfo);
        return;
        a((rvv)paramrvl, paramVideoInfo, localAdvertisementInfo);
        return;
        c(paramrvl, paramVideoInfo);
        return;
        b(paramrvl, paramVideoInfo);
        return;
        a((rvv)paramrvl, paramVideoInfo);
        return;
      } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView == null);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.a();
      return;
    }
    e(paramVideoInfo);
  }
  
  private void b(VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo)
  {
    twr.a(paramAdvertisementInfo, 16, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
    this.jdField_a_of_type_Txm.f();
    uhs.b(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, true, null);
    a(paramVideoInfo, obb.aA);
  }
  
  private void b(VideoInfo paramVideoInfo, String paramString)
  {
    sid localsid = new sie(paramVideoInfo).e(paramVideoInfo.f).i(paramVideoInfo.g).a("live_circle_from_page", Integer.valueOf(2)).a();
    String str = paramVideoInfo.j;
    if (!TextUtils.isEmpty(paramVideoInfo.g)) {}
    for (paramVideoInfo = paramVideoInfo.g;; paramVideoInfo = "0")
    {
      odq.b(null, str, paramString, paramString, 0, 0, "0", "", paramVideoInfo, localsid.a(), false);
      return;
    }
  }
  
  private void b(VideoInfo paramVideoInfo, boolean paramBoolean)
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
  
  private void b(rvi paramrvi)
  {
    int i1;
    Object localObject;
    if ((paramrvi != null) && (paramrvi.jdField_a_of_type_Ryo != null) && (paramrvi.jdField_a_of_type_Ryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (paramrvi.jdField_a_of_type_Ryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo != null))
    {
      i1 = twq.d(obb.a(paramrvi.jdField_a_of_type_Ryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo));
      if (i1 != 1) {
        break label88;
      }
      paramrvi = paramrvi.j;
      if (paramrvi != null)
      {
        localObject = (LinearLayout.LayoutParams)paramrvi.getLayoutParams();
        if (localObject != null)
        {
          ((LinearLayout.LayoutParams)localObject).weight = 2.0F;
          paramrvi.setLayoutParams((ViewGroup.LayoutParams)localObject);
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
        localObject = paramrvi.jdField_k_of_type_AndroidViewView;
        if (localObject != null)
        {
          LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((View)localObject).getLayoutParams();
          if (localLayoutParams != null)
          {
            localLayoutParams.weight = 0.0F;
            ((View)localObject).setLayoutParams(localLayoutParams);
          }
        }
        paramrvi = paramrvi.l;
      } while (paramrvi == null);
      localObject = (LinearLayout.LayoutParams)paramrvi.getLayoutParams();
    } while (localObject == null);
    ((LinearLayout.LayoutParams)localObject).weight = 0.0F;
    paramrvi.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  private void b(rvl paramrvl, VideoInfo paramVideoInfo)
  {
    if (((paramrvl instanceof rvs)) && (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo != null))
    {
      rwv.a(this.jdField_a_of_type_AndroidAppActivity, paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.a);
      paramrvl = new sie(paramVideoInfo).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo).i(paramVideoInfo.g).M(0).a();
      odq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "", "0X800AC2C", "0X800AC2C", 0, 0, "", "", "", paramrvl.a(), false);
    }
  }
  
  private void b(rvl paramrvl, VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo)
  {
    if ((paramrvl instanceof rvi))
    {
      if (a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo))
      {
        a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
        obb.a(new trn().a(this.jdField_a_of_type_AndroidContentContext).a(obb.L).b(obb.P).a(paramAdvertisementInfo).a());
      }
    }
    else {
      return;
    }
    rvi localrvi = (rvi)paramrvl;
    int i1 = 8;
    if (this.i) {
      i1 = 13;
    }
    twr.a(paramAdvertisementInfo, i1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
    c(localrvi);
    paramrvl = new View[1];
    paramrvl[0] = localrvi.jdField_a_of_type_AndroidViewView;
    if (b(paramVideoInfo)) {
      paramrvl = new View[0];
    }
    RelativeLayout localRelativeLayout = localrvi.jdField_c_of_type_AndroidWidgetRelativeLayout;
    twb.c(localrvi.jdField_b_of_type_AndroidWidgetSeekBar);
    a(localrvi, paramVideoInfo, paramAdvertisementInfo, -1, paramrvl, new View[] { localRelativeLayout });
  }
  
  private void b(rvl paramrvl, VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo, int paramInt)
  {
    if ((paramrvl == null) || (paramVideoInfo == null) || (paramAdvertisementInfo == null)) {
      return;
    }
    paramAdvertisementInfo.setClickPos(paramInt);
    uhs.b(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, true, null);
    paramrvl = obb.a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
    obb.a(new trn().a(this.jdField_a_of_type_AndroidContentContext).a(obb.jdField_a_of_type_Int).b(obb.aa).a(paramrvl).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).d(paramInt).a());
  }
  
  private void b(rvn paramrvn)
  {
    paramrvn = paramrvn.jdField_a_of_type_Ryo;
    if ((paramrvn != null) && ((paramrvn.jdField_a_of_type_Boolean) || ((paramrvn.jdField_a_of_type_Sdj != null) && (paramrvn.jdField_a_of_type_Sdj.b() != 0))))
    {
      paramrvn.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.c(paramrvn);
    }
  }
  
  private void b(rvv paramrvv, VideoInfo paramVideoInfo)
  {
    if (bcoo.a()) {}
    do
    {
      do
      {
        return;
        if (paramrvv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsUGView != null) {
          paramrvv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsUGView.a();
        }
        if (paramrvv.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsUGView != null) {
          paramrvv.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsUGView.a();
        }
      } while ((paramVideoInfo.jdField_a_of_type_Oey == null) && (paramVideoInfo.jdField_b_of_type_Oey == null));
      if ((paramrvv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsUGView != null) && (paramVideoInfo.jdField_a_of_type_Oey != null) && ((paramVideoInfo.jdField_a_of_type_Oey.jdField_c_of_type_Int == 1) || (paramVideoInfo.jdField_a_of_type_Oey.jdField_c_of_type_Int == 2))) {
        paramrvv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsUGView.setInfo(paramVideoInfo.jdField_a_of_type_Oey, paramVideoInfo.jdField_c_of_type_JavaLangString, "VideoPlay_ContentMix");
      }
    } while ((paramrvv.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsUGView == null) || (paramVideoInfo.jdField_b_of_type_Oey == null) || ((paramVideoInfo.jdField_b_of_type_Oey.jdField_c_of_type_Int != 1) && (paramVideoInfo.jdField_b_of_type_Oey.jdField_c_of_type_Int != 2)));
    paramrvv.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsUGView.setInfo(paramVideoInfo.jdField_b_of_type_Oey, paramVideoInfo.jdField_c_of_type_JavaLangString, "VideoPlay_Shooting");
  }
  
  private void b(rvv paramrvv, VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramVideoInfo.jdField_c_of_type_Boolean)
    {
      twr.a(paramAdvertisementInfo, 1000, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
      uhs.b(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, false, null);
      a(paramVideoInfo, 1000);
      return;
    }
    rwv.a(paramrvv.s, paramVideoInfo, "click_write_comment");
    this.jdField_a_of_type_Rwa.g();
    label68:
    label83:
    Object localObject;
    long l1;
    label119:
    String str;
    if (jdField_a_of_type_Boolean)
    {
      paramAdvertisementInfo = "0X800948A";
      if (paramrvv.jdField_a_of_type_Ryo == null) {
        break label277;
      }
      paramrvv = paramrvv.jdField_a_of_type_Ryo.jdField_a_of_type_Sdj;
      localObject = new sie(null, paramVideoInfo.j, paramVideoInfo.jdField_a_of_type_JavaLangString, paramVideoInfo.g);
      if (paramrvv == null) {
        break label282;
      }
      l1 = paramrvv.a(paramrvv.h());
      localObject = ((sie)localObject).d(l1);
      if (paramrvv == null) {
        break label290;
      }
      l1 = paramrvv.a();
      label138:
      localObject = ((sie)localObject).a(l1);
      if (paramrvv == null) {
        break label298;
      }
      l1 = paramrvv.b();
      label157:
      localObject = ((sie)localObject).c(l1).a(409409).a(paramVideoInfo.y).u(this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("VIDEO_FROM_TYPE", -1)).a().a();
      str = paramVideoInfo.j;
      if (TextUtils.isEmpty(paramVideoInfo.g)) {
        break label306;
      }
    }
    label277:
    label282:
    label290:
    label298:
    label306:
    for (paramrvv = paramVideoInfo.g;; paramrvv = "0")
    {
      odq.a(null, str, paramAdvertisementInfo, paramAdvertisementInfo, 0, 0, "", "", paramrvv, (String)localObject, false);
      if ((bkwm.k(pay.a())) || (this.jdField_a_of_type_Rzk == null)) {
        break;
      }
      this.jdField_a_of_type_Rzk.a(4, paramVideoInfo, 0L);
      return;
      paramAdvertisementInfo = "0X8009485";
      break label68;
      paramrvv = null;
      break label83;
      l1 = -1L;
      break label119;
      l1 = -1L;
      break label138;
      l1 = -1L;
      break label157;
    }
  }
  
  private static boolean b(VideoInfo paramVideoInfo)
  {
    return twr.a(paramVideoInfo);
  }
  
  private void c(View paramView, rvl paramrvl, VideoInfo paramVideoInfo)
  {
    AdvertisementInfo localAdvertisementInfo = a(paramVideoInfo);
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      a(paramView, paramrvl, paramVideoInfo, localAdvertisementInfo);
      return;
      a(paramView, paramVideoInfo);
      continue;
      j(paramVideoInfo, localAdvertisementInfo);
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
      b(paramrvl, paramVideoInfo, localAdvertisementInfo);
      continue;
      d(paramVideoInfo, localAdvertisementInfo);
      continue;
      twr.a(localAdvertisementInfo, 13, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
      a(paramrvl, paramVideoInfo, localAdvertisementInfo);
      continue;
      k(paramVideoInfo, localAdvertisementInfo);
      continue;
      twr.a(localAdvertisementInfo, 2003, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
      a(paramrvl, paramVideoInfo, localAdvertisementInfo, 2003);
      continue;
      twr.a(localAdvertisementInfo, 2004, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
      a(paramrvl, paramVideoInfo, localAdvertisementInfo, 2004);
      continue;
      twr.a(localAdvertisementInfo, 4001, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
      b(paramrvl, paramVideoInfo, localAdvertisementInfo, 4001);
      continue;
      twr.a(localAdvertisementInfo, 4002, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
      b(paramrvl, paramVideoInfo, localAdvertisementInfo, 4002);
      continue;
      twr.a(localAdvertisementInfo, 4007, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
      b(paramrvl, paramVideoInfo, localAdvertisementInfo, 4007);
      continue;
      twr.a(localAdvertisementInfo, 4000, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
      b(paramrvl, paramVideoInfo, localAdvertisementInfo, 4000);
    }
  }
  
  private void c(VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo)
  {
    twr.a(paramAdvertisementInfo, 15, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
    this.jdField_a_of_type_Txm.f();
    uhs.b(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, true, null);
    a(paramVideoInfo, obb.az);
  }
  
  private void c(VideoInfo paramVideoInfo, String paramString)
  {
    if ((this.jdField_a_of_type_Rvn != null) && (this.jdField_a_of_type_Rvn.l != null) && (this.jdField_a_of_type_Rvn.l.getVisibility() == 0))
    {
      rwv.a(this.jdField_a_of_type_Rvn.l, paramVideoInfo, "click_speed");
      odq.a(null, "", paramString, paramString, 0, 0, "", "", "", new sie(paramVideoInfo).a(this.jdField_a_of_type_Rzo.a()).b(this.s).c(paramVideoInfo.jdField_d_of_type_Int).M(0).a(paramVideoInfo.y).L(pcv.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_d_of_type_Int)).a().a(), false);
    }
  }
  
  private void c(rvi paramrvi) {}
  
  private void c(rvl paramrvl, VideoInfo paramVideoInfo)
  {
    int i1 = 0;
    boolean bool;
    label32:
    ImageView localImageView;
    if (!paramVideoInfo.r)
    {
      bool = true;
      paramVideoInfo.r = bool;
      if (!paramVideoInfo.r) {
        break label177;
      }
      i1 = paramVideoInfo.t + 1;
      paramVideoInfo.t = i1;
      if ((paramrvl instanceof rvv))
      {
        ((rvv)paramrvl).jdField_a_of_type_Rsn.d();
        localImageView = ((rvv)paramrvl).o;
        if (!paramVideoInfo.r) {
          break label194;
        }
      }
    }
    label177:
    label194:
    for (paramrvl = "click_like";; paramrvl = "cancel_like")
    {
      rwv.a(localImageView, paramVideoInfo, paramrvl);
      if ((this.jdField_a_of_type_Rya != null) && (paramVideoInfo.r)) {
        this.jdField_a_of_type_Rya.a((float)(DeviceInfoUtil.getPortraitWidth() / 2L), (float)(DeviceInfoUtil.getPortraitHeight() / 2L));
      }
      if (this.jdField_a_of_type_Rzk != null) {
        this.jdField_a_of_type_Rzk.a(3, paramVideoInfo, 0L);
      }
      if ((this.jdField_a_of_type_Rvk != null) && (!paramVideoInfo.jdField_c_of_type_Boolean)) {
        this.jdField_a_of_type_Rvk.a(paramVideoInfo, paramVideoInfo.r);
      }
      h(paramVideoInfo);
      return;
      bool = false;
      break;
      if (paramVideoInfo.t <= 0) {
        break label32;
      }
      i1 = paramVideoInfo.t - 1;
      break label32;
    }
  }
  
  private void c(rvl paramrvl, VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo)
  {
    if ((paramrvl instanceof rvi))
    {
      if (!a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo)) {
        break label90;
      }
      a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
      obb.a(new trn().a(this.jdField_a_of_type_AndroidContentContext).a(obb.L).b(obb.P).a(paramAdvertisementInfo).a());
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Rvn != null) && (this.jdField_a_of_type_Rvn.jdField_a_of_type_Ryo != null)) {
        twr.a(this.jdField_a_of_type_Rvn.jdField_a_of_type_Ryo, true);
      }
      return;
      label90:
      rvi localrvi = (rvi)paramrvl;
      paramrvl = new View[2];
      paramrvl[0] = localrvi.p;
      paramrvl[1] = localrvi.jdField_a_of_type_AndroidViewView;
      if (b(paramVideoInfo))
      {
        paramrvl = new View[1];
        paramrvl[0] = localrvi.p;
      }
      RelativeLayout localRelativeLayout = localrvi.jdField_c_of_type_AndroidWidgetRelativeLayout;
      TextView localTextView = localrvi.jdField_k_of_type_AndroidWidgetTextView;
      twb.c(localrvi.jdField_b_of_type_AndroidWidgetSeekBar);
      a(localrvi, paramVideoInfo, paramAdvertisementInfo, obb.aa, paramrvl, new View[] { localRelativeLayout, localTextView });
    }
  }
  
  private void d(VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramVideoInfo.jdField_c_of_type_Boolean)
    {
      twr.a(paramAdvertisementInfo, 10, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
      uhs.b(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, false, null);
      a(paramVideoInfo, obb.ay);
    }
  }
  
  private void d(rvl paramrvl, VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo)
  {
    if ((paramrvl instanceof rvi))
    {
      rvi localrvi = (rvi)paramrvl;
      twb.c(localrvi.jdField_b_of_type_AndroidWidgetSeekBar);
      a(paramrvl, paramVideoInfo, paramAdvertisementInfo, obb.aa, localrvi.p, new View[] { localrvi.jdField_k_of_type_AndroidWidgetTextView });
    }
  }
  
  private void e(VideoInfo paramVideoInfo)
  {
    if (paramVideoInfo.o) {
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, "只能喂饼1次哦", 0).a();
    }
    for (;;)
    {
      a(paramVideoInfo, "0X800B2EB");
      return;
      this.jdField_a_of_type_Qye.a(paramVideoInfo);
    }
  }
  
  private void e(VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramVideoInfo.jdField_c_of_type_Boolean)
    {
      if (this.n)
      {
        this.n = false;
        twr.a(paramAdvertisementInfo, 1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
        uhs.b(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, false, null);
        a(paramVideoInfo, obb.at);
      }
    }
    else {
      return;
    }
    twr.a(paramAdvertisementInfo, 4, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
    uhs.b(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, false, null);
    a(paramVideoInfo, obb.aw);
  }
  
  private void f(VideoInfo paramVideoInfo)
  {
    if (paramVideoInfo.jdField_q_of_type_Boolean) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "followPubAccount onClick() puin=" + paramVideoInfo.j + ", isFollowed=" + paramVideoInfo.jdField_q_of_type_Boolean + ", pname=" + paramVideoInfo.k);
    }
    if ((this.jdField_a_of_type_Rvn instanceof rvv)) {
      rwv.a(((rvv)this.jdField_a_of_type_Rvn).jdField_a_of_type_Rsm, paramVideoInfo, "click_follow");
    }
    String str2 = new sie(null, paramVideoInfo.j, paramVideoInfo.jdField_a_of_type_JavaLangString, paramVideoInfo.g, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(), paramVideoInfo.a() * 1000L).a(paramVideoInfo.y).M(0).a().a();
    if (jdField_a_of_type_Boolean)
    {
      str3 = paramVideoInfo.j;
      if (!TextUtils.isEmpty(paramVideoInfo.g)) {}
      for (str1 = paramVideoInfo.g;; str1 = "0")
      {
        odq.a(null, str3, "0X800929B", "0X800929B", 0, 0, "", "", str1, str2, false);
        a(paramVideoInfo, "0X800B1A7", true, true);
        a(paramVideoInfo, "0X800B1A6", false, true);
        a(paramVideoInfo.j, paramVideoInfo.jdField_b_of_type_Boolean, paramVideoInfo.p);
        return;
      }
    }
    String str3 = paramVideoInfo.j;
    if (!TextUtils.isEmpty(paramVideoInfo.g)) {}
    for (String str1 = paramVideoInfo.g;; str1 = "0")
    {
      odq.a(null, str3, "0X80078FD", "0X80078FD", 0, 0, "", "", str1, str2, false);
      break;
    }
  }
  
  private void f(VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramVideoInfo.jdField_c_of_type_Boolean)
    {
      twr.a(paramAdvertisementInfo, 3, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
      uhs.b(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, false, null);
      a(paramVideoInfo, obb.av);
    }
  }
  
  private void g()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(2, null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.c(false);
  }
  
  private void g(VideoInfo paramVideoInfo)
  {
    if ((this.jdField_a_of_type_Rvn.jdField_a_of_type_Ryo == null) || (paramVideoInfo == null)) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.a(false);
    } while (TextUtils.isEmpty(paramVideoInfo.g));
    shq.a(this.jdField_a_of_type_AndroidAppActivity, rsl.a(paramVideoInfo), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(paramVideoInfo.g), 2, 0);
    shq.a(paramVideoInfo.g, 2, 0);
  }
  
  private void g(VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramVideoInfo.jdField_c_of_type_Boolean)
    {
      twr.a(paramAdvertisementInfo, 2, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
      uhs.b(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, false, null);
      a(paramVideoInfo, obb.au);
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
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a = new sdt(sdt.jdField_c_of_type_Int, sdt.jdField_f_of_type_Int);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a(new ruz(this));
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
      if (paramVideoInfo.y == null) {
        break label274;
      }
      str1 = paramVideoInfo.y;
      label60:
      localJSONObject.put("video_report_info", str1);
      if (!paramVideoInfo.r) {
        break label103;
      }
      if (this.jdField_a_of_type_Rya == null) {
        break label322;
      }
      i1 = this.jdField_a_of_type_Rya.a();
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
      odq.a(null, str4, str1, str1, 0, 0, "0", "0", str3, ofe.a(str2, paramVideoInfo.j, paramVideoInfo.jdField_a_of_type_JavaLangString, paramVideoInfo.g, localJSONObject), false);
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
      twr.a(paramAdvertisementInfo, 2, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
      uhs.b(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, false, null);
      a(paramVideoInfo, obb.au);
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
    ThreadManager.excute(new VideoFeedsAdapter.8(this, paramVideoInfo), 16, null, true);
  }
  
  private void i(VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramVideoInfo.jdField_c_of_type_Boolean)
    {
      twr.a(paramAdvertisementInfo, 1000, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
      uhs.b(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, false, null);
      a(paramVideoInfo, obb.aD);
    }
  }
  
  private void j(VideoInfo paramVideoInfo)
  {
    if ((paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo != null) && (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_e_of_type_Int == 1)) {
      odq.a(null, "", "0X800AC2B", "0X800AC2B", 0, 0, "3", "", "", new sie(paramVideoInfo).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo).M(0).a().a(), false);
    }
  }
  
  private void j(VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramVideoInfo.jdField_c_of_type_Boolean)
    {
      uhs.b(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, true, null);
      a(paramVideoInfo, 0);
    }
  }
  
  private void k(VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo)
  {
    if ((this.jdField_a_of_type_Rvn instanceof rvv)) {
      rwv.a(((rvv)this.jdField_a_of_type_Rvn).m, paramVideoInfo, "click_puin");
    }
    if ((paramVideoInfo.jdField_a_of_type_Int == 0) && (paramVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null)) {}
    for (String str = paramVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5();; str = null)
    {
      if ((this.jdField_a_of_type_Rwa != null) && (paramVideoInfo.a(this.jdField_a_of_type_AndroidAppActivity))) {
        this.jdField_a_of_type_Rwa.h();
      }
      if (!paramVideoInfo.jdField_c_of_type_Boolean) {
        break;
      }
      uhs.b(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, true, null);
      a(paramVideoInfo, 0);
      return;
    }
    if ((paramVideoInfo.z != null) && (!paramVideoInfo.z.equals("")))
    {
      pay.a(this.jdField_a_of_type_AndroidAppActivity, paramVideoInfo.z);
      return;
    }
    if (((this.jdField_a_of_type_Rvn instanceof rvs)) && (((rvs)this.jdField_a_of_type_Rvn).b.getVisibility() == 0) && (paramVideoInfo.jdField_a_of_type_Pvp != null) && (!TextUtils.isEmpty(paramVideoInfo.jdField_a_of_type_Pvp.jdField_d_of_type_JavaLangString)))
    {
      pay.a(this.jdField_a_of_type_AndroidAppActivity, paramVideoInfo.jdField_a_of_type_Pvp.jdField_d_of_type_JavaLangString);
      b(paramVideoInfo, "0X800B17E");
      paramAdvertisementInfo = new sie(str, paramVideoInfo.j, paramVideoInfo.jdField_a_of_type_JavaLangString, paramVideoInfo.g, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(), paramVideoInfo.a() * 1000L).a(-1).M(0).a().a();
      str = paramVideoInfo.j;
      if (TextUtils.isEmpty(paramVideoInfo.g)) {
        break label386;
      }
    }
    label386:
    for (paramVideoInfo = paramVideoInfo.g;; paramVideoInfo = "0")
    {
      odq.a(null, str, "0X8007410", "0X8007410", 0, 0, "0", "", paramVideoInfo, paramAdvertisementInfo, false);
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
        a(paramVideoInfo, true);
        break;
      }
      if ((TextUtils.isEmpty(paramVideoInfo.j)) || (paramVideoInfo.j.equals("16888"))) {
        break;
      }
      a(paramVideoInfo, false);
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
  
  public rvl a(ViewGroup paramViewGroup, int paramInt)
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
        paramViewGroup.jdField_a_of_type_Rsn = ((rsn)localObject3);
        paramViewGroup.jdField_a_of_type_Scs = new scs(paramViewGroup, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager, this.jdField_f_of_type_Boolean);
        return paramViewGroup;
      }
      break;
    case 2: 
      localObject1 = rzv.a(2131560328, true, new ViewGroup.LayoutParams(-1, -1));
      paramViewGroup = (rvs)((View)localObject1).getTag();
      if (paramViewGroup == null) {
        paramViewGroup = new rvs((View)localObject1);
      }
      break;
    }
    for (;;)
    {
      for (;;)
      {
        localObject3 = new rvr(this, (rvs)paramViewGroup);
        try
        {
          paramInt = LiuHaiUtils.b(this.jdField_a_of_type_AndroidAppActivity);
          if ((LiuHaiUtils.b()) && (paramInt > 0) && (((rvs)paramViewGroup).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsUGView != null))
          {
            localObject1 = (View)((rvs)paramViewGroup).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsUGView.getParent();
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
      View localView = rzv.a(2131560343, true, new ViewGroup.LayoutParams(-1, -1));
      paramViewGroup = (rvs)localView.getTag();
      if (paramViewGroup == null) {
        paramViewGroup = new rvu(localView);
      }
      for (;;)
      {
        for (;;)
        {
          localObject3 = new rvt(this, (rvu)paramViewGroup);
          try
          {
            paramInt = LiuHaiUtils.b(this.jdField_a_of_type_AndroidAppActivity);
            if ((LiuHaiUtils.b()) && (paramInt > 0) && (((rvs)paramViewGroup).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsUGView != null))
            {
              localView = (View)((rvs)paramViewGroup).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsUGView.getParent();
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
        paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560320, paramViewGroup, false);
        if (!this.s) {
          ((LayoutInflater)localObject2).inflate(2131560354, (ViewGroup)paramViewGroup.findViewById(2131364904), true);
        }
        ((LayoutInflater)localObject2).inflate(2131560349, (ViewGroup)paramViewGroup.findViewById(2131364902), true);
        ((LayoutInflater)localObject2).inflate(2131560351, (ViewGroup)paramViewGroup.findViewById(2131364900), true);
        paramViewGroup = new rvi(paramViewGroup, paramInt);
        localObject3 = new rvd(this, (rvi)paramViewGroup);
        Object localObject2 = null;
        break;
        localObject3 = rzv.a(2131560324, true, new ViewGroup.LayoutParams(-1, -1));
        localObject2 = (rvq)((View)localObject3).getTag();
        paramViewGroup = (ViewGroup)localObject2;
        if (localObject2 == null) {
          paramViewGroup = new rvq((View)localObject3, paramInt);
        }
        this.jdField_a_of_type_Rvq = paramViewGroup;
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
    if ((localViewHolder instanceof rvq)) {
      a((rvq)localViewHolder);
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
    if ((this.jdField_a_of_type_Rwa != null) && (this.jdField_a_of_type_Rwa.a()) && (this.jdField_a_of_type_Rwa.b()))
    {
      this.jdField_a_of_type_Rwa.h();
      break label34;
    }
    for (;;)
    {
      label34:
      return;
      if (!this.v) {
        continue;
      }
      paramView = (rvn)paramView.getTag();
      if (paramView != this.jdField_a_of_type_Rvn)
      {
        if (this.jdField_a_of_type_Rvn == null) {
          break;
        }
        if ((paramView != null) && (paramView.jdField_c_of_type_Int == this.jdField_a_of_type_Rvn.jdField_c_of_type_Int + 1) && (paramView.jdField_c_of_type_Int != getItemCount()))
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.a();
          return;
        }
        if ((paramView == null) || (paramView.jdField_c_of_type_Int != this.jdField_a_of_type_Rvn.jdField_c_of_type_Int - 1)) {
          break;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.b();
        return;
      }
      paramView.jdField_a_of_type_Rsn.c();
      rwv.a(paramView.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout, paramView.jdField_a_of_type_Ryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo, "click_contentid");
      VideoReport.reportEvent("clck", paramView.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout, null);
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
          label249:
          odq.a(null, null, "0X80091AB", "0X80091AB", 0, 0, "", "", "", ofe.a(null, null, paramView.jdField_a_of_type_Ryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, paramView.jdField_a_of_type_Ryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g, localJSONObject), false);
          return;
          if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager == null) || (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.d())) {
            continue;
          }
          localJSONObject = new JSONObject();
          try
          {
            localJSONObject.put("channel_id", 409409);
            label335:
            odq.a(null, null, "0X80091AB", "0X80091AB", 0, 0, "", "", "", ofe.a(null, null, paramView.jdField_a_of_type_Ryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, paramView.jdField_a_of_type_Ryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g, localJSONObject), false);
            return;
          }
          catch (JSONException localJSONException1)
          {
            break label335;
          }
        }
        catch (JSONException localJSONException2)
        {
          break label249;
        }
      }
    }
  }
  
  public void a(View paramView, int paramInt)
  {
    paramView = (rvv)paramView.getTag();
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
        paramView.jdField_a_of_type_Rsn.a(1);
        this.t = false;
        return;
      } while (paramView.jdField_d_of_type_AndroidViewViewGroup.getVisibility() != 0);
      paramView.jdField_a_of_type_Rsn.a(2);
    } while (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.b());
    this.t = true;
  }
  
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    int i2 = 1;
    rvv localrvv = (rvv)paramView.getTag();
    if (localrvv != this.jdField_a_of_type_Rvn) {}
    while ((!this.v) || (localrvv == null) || (localrvv.jdField_a_of_type_Ryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == null) || (!(localrvv instanceof rvn)) || (TextUtils.isEmpty(localrvv.jdField_a_of_type_Ryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g))) {
      return;
    }
    Object localObject = localrvv.jdField_a_of_type_Ryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
    boolean bool;
    int i1;
    label111:
    JSONObject localJSONObject;
    if (!((VideoInfo)localObject).r)
    {
      bool = true;
      ((VideoInfo)localObject).r = true;
      if (!bool) {
        break label505;
      }
      i1 = ((VideoInfo)localObject).t + 1;
      ((VideoInfo)localObject).t = i1;
      localrvv.jdField_a_of_type_Rsn.a(paramInt1, paramInt2, bool);
      if (bool)
      {
        if (this.jdField_a_of_type_Rvk != null) {
          this.jdField_a_of_type_Rvk.a((VideoInfo)localObject, ((VideoInfo)localObject).r);
        }
        h((VideoInfo)localObject);
      }
      if (this.jdField_a_of_type_Rzk != null) {
        this.jdField_a_of_type_Rzk.a(3, (VideoInfo)localObject, 0L);
      }
      rwv.a(localrvv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout, (VideoInfo)localObject, "click_like", "double");
      VideoReport.reportEvent("clck", localrvv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout, null);
      localJSONObject = new JSONObject();
      if ((localrvv.jdField_a_of_type_Ryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int != 0) || (localrvv.jdField_a_of_type_Ryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null)) {
        break label515;
      }
      paramView = localrvv.jdField_a_of_type_Ryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5();
    }
    try
    {
      label264:
      localJSONObject.put("channel_id", 409409);
      localJSONObject.put("rowkey", localrvv.jdField_a_of_type_Ryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g);
      if (this.jdField_a_of_type_Rya == null) {
        break label520;
      }
      paramInt1 = this.jdField_a_of_type_Rya.a();
      label311:
      localJSONObject.put("style", paramInt1);
      localJSONObject.put("algorithm_id", ((VideoInfo)localObject).f);
      if (((VideoInfo)localObject).jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LikeActionDownloadBar == null) {
        break label525;
      }
      localObject = ((VideoInfo)localObject).jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LikeActionDownloadBar.jdField_c_of_type_JavaLangString;
      label353:
      localJSONObject.put("common_data", localObject);
      if (!this.s) {
        break label533;
      }
      paramInt1 = i2;
      label374:
      localJSONObject.put("interact_button_style", paramInt1);
    }
    catch (Exception localException)
    {
      label384:
      label395:
      String str2;
      String str1;
      break label384;
    }
    if (jdField_a_of_type_Boolean)
    {
      localObject = "0X80097F5";
      str2 = localrvv.jdField_a_of_type_Ryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.j;
      if (TextUtils.isEmpty(localrvv.jdField_a_of_type_Ryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g)) {
        break label546;
      }
    }
    label515:
    label520:
    label525:
    label533:
    label546:
    for (str1 = localrvv.jdField_a_of_type_Ryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g;; str1 = "0")
    {
      odq.a(null, str2, (String)localObject, (String)localObject, 0, 0, "0", "0", str1, ofe.a(paramView, localrvv.jdField_a_of_type_Ryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.j, localrvv.jdField_a_of_type_Ryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, localrvv.jdField_a_of_type_Ryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g, localJSONObject), false);
      return;
      bool = false;
      break;
      label505:
      i1 = ((VideoInfo)localObject).t;
      break label111;
      paramView = null;
      break label264;
      paramInt1 = 0;
      break label311;
      localObject = "";
      break label353;
      paramInt1 = 0;
      break label374;
      localObject = "0X80091AA";
      break label395;
    }
  }
  
  public void a(VideoInfo paramVideoInfo)
  {
    if ((paramVideoInfo != null) && (this.jdField_a_of_type_Sie != null))
    {
      this.jdField_a_of_type_Sie.a(paramVideoInfo.y);
      a(paramVideoInfo, this.jdField_a_of_type_Sie);
      this.jdField_a_of_type_Sie = null;
    }
  }
  
  public void a(VideoInfo paramVideoInfo, String paramString)
  {
    int i1 = 1;
    Object localObject = new sie(paramVideoInfo).a("video_mode", Integer.valueOf(1));
    if (paramVideoInfo.o) {
      i1 = 3;
    }
    localObject = ((sie)localObject).a("status", Integer.valueOf(i1)).a();
    odq.a(null, "", paramString, paramString, 0, 0, paramVideoInfo.g, "", "", ((sid)localObject).a(), false);
  }
  
  public void a(VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    if ((TextUtils.isEmpty(paramVideoInfo.j)) || (this.jdField_a_of_type_AndroidAppActivity == null)) {
      return;
    }
    paramVideoInfo = rwv.a(paramVideoInfo, paramBoolean, false);
    pay.a(this.jdField_a_of_type_AndroidAppActivity, paramVideoInfo);
  }
  
  public void a(VideoFeedsPlayManager paramVideoFeedsPlayManager)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager = paramVideoFeedsPlayManager;
    h();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(new ruy(this));
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
      if ((paramList instanceof rvv)) {
        ((rvv)paramList).jdField_a_of_type_Rsn.a();
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
  
  public void a(List<VideoInfo> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void a(qye paramqye)
  {
    this.jdField_a_of_type_Qye = paramqye;
  }
  
  public void a(rtv paramrtv)
  {
    this.jdField_a_of_type_Rtv = paramrtv;
  }
  
  public void a(rvk paramrvk)
  {
    this.jdField_a_of_type_Rvk = paramrvk;
  }
  
  public void a(rvl paramrvl, int paramInt)
  {
    paramrvl.jdField_b_of_type_Int = paramInt;
    paramrvl.jdField_c_of_type_Int = paramInt;
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size()))
    {
      if (this.jdField_a_of_type_Txu != null)
      {
        VideoInfo localVideoInfo = this.jdField_a_of_type_Txu.b(paramInt);
        if (localVideoInfo != null) {
          this.jdField_a_of_type_JavaUtilList.set(paramInt, localVideoInfo);
        }
      }
      a(paramrvl, (VideoInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt));
    }
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramrvl, paramInt, getItemId(paramInt));
      return;
      a(paramrvl, null);
    }
  }
  
  public void a(rvl paramrvl, VideoInfo paramVideoInfo)
  {
    int i1 = paramrvl.jdField_a_of_type_Int;
    if ((i1 == 3) || (i1 == 6))
    {
      a((rvq)paramrvl);
      this.jdField_a_of_type_Rvq = ((rvq)paramrvl);
      return;
    }
    paramrvl = (rvn)paramrvl;
    b(paramrvl);
    a(paramrvl, paramVideoInfo);
    rwg.a.a(paramrvl);
    TraceCompat.beginSection("refreshMenuUI");
    paramrvl.jdField_a_of_type_Rsn.a(paramVideoInfo);
    TraceCompat.endSection();
    TraceCompat.beginSection("refreshContentUI");
    paramrvl.jdField_a_of_type_Rsn.a(paramVideoInfo, this.jdField_d_of_type_Boolean);
    if (!TextUtils.isEmpty(paramVideoInfo.j))
    {
      ReadInJoyUserInfo localReadInJoyUserInfo = ReadInJoyUserInfoModule.a(Long.parseLong(paramVideoInfo.j), null);
      if ((localReadInJoyUserInfo != null) && (localReadInJoyUserInfo.isReadlTimeRead())) {
        ReadInJoyUserInfoModule.a(Long.parseLong(paramVideoInfo.j), this, true);
      }
    }
    TraceCompat.endSection();
    if ((this.h) && (paramrvl == this.jdField_a_of_type_Rvn)) {
      paramrvl.jdField_a_of_type_Rsn.f(this.h);
    }
    a(paramrvl);
    VideoReport.setElementId(paramrvl.itemView, "card");
    VideoReport.setElementReuseIdentifier(paramrvl.itemView, paramVideoInfo.g);
    VideoReport.setElementExposureMinRate(paramrvl.itemView, 0.1D);
  }
  
  public void a(rvu paramrvu)
  {
    long l2 = -1L;
    Object localObject;
    if (paramrvu.jdField_a_of_type_Ryo != null)
    {
      localObject = paramrvu.jdField_a_of_type_Ryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
      if (paramrvu.jdField_a_of_type_Ryo == null) {
        break label120;
      }
      paramrvu = paramrvu.jdField_a_of_type_Ryo.jdField_a_of_type_Sdj;
      label36:
      localObject = new sie((VideoInfo)localObject);
      if (paramrvu == null) {
        break label125;
      }
    }
    label120:
    label125:
    for (long l1 = paramrvu.a();; l1 = -1L)
    {
      localObject = ((sie)localObject).a(l1);
      l1 = l2;
      if (paramrvu != null) {
        l1 = paramrvu.b();
      }
      odq.a(null, "", "0X800B28A", "0X800B28A", 0, 0, "3", "", "", ((sie)localObject).c(l1).a().a(), false);
      return;
      localObject = null;
      break;
      paramrvu = null;
      break label36;
    }
  }
  
  public void a(rvv paramrvv)
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
    if (this.jdField_a_of_type_Rvn != null)
    {
      i1 = this.jdField_a_of_type_Rvn.jdField_c_of_type_Int;
      this.jdField_a_of_type_Rvn = paramrvv;
      if ((this.jdField_a_of_type_Rvn.jdField_c_of_type_Int == 0) && (this.jdField_a_of_type_Rvn.jdField_b_of_type_Int == 0))
      {
        paramrvv.jdField_a_of_type_Ryo.jdField_a_of_type_Long = this.jdField_c_of_type_Long;
        this.jdField_c_of_type_Long = 0L;
      }
      if (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
        break label279;
      }
      paramrvv.jdField_a_of_type_Ryo.jdField_a_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
      paramrvv.jdField_a_of_type_Ryo.jdField_c_of_type_Boolean = true;
      this.jdField_d_of_type_JavaLangString = null;
      bool1 = bool2;
      if (this.jdField_g_of_type_Boolean)
      {
        if (!a(paramrvv)) {
          break label298;
        }
        bool1 = bool2;
      }
      this.jdField_g_of_type_Boolean = false;
      l1 = System.currentTimeMillis();
      l2 = this.jdField_b_of_type_Long;
      paramrvv.jdField_a_of_type_Ryo.jdField_a_of_type_AndroidOsBundle.putBoolean("is_auto_play", bool1);
      if (!bool1) {
        break label318;
      }
      if ((!bkwm.g(this.jdField_a_of_type_Int)) || (!this.jdField_a_of_type_Rvn.jdField_a_of_type_Ryo.jdField_c_of_type_Boolean) || (Build.VERSION.SDK_INT < 16)) {
        break label303;
      }
      a(paramrvv.jdField_a_of_type_Ryo);
    }
    for (;;)
    {
      a(paramrvv, bool1, l1 - l2, i1);
      if ((paramrvv.jdField_a_of_type_Ryo != null) && (paramrvv.jdField_a_of_type_Ryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null)) {
        ugf.a(paramrvv.jdField_a_of_type_Ryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g, paramrvv.jdField_a_of_type_Ryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, 0, 0);
      }
      return;
      i1 = -1;
      break;
      label279:
      paramrvv.jdField_a_of_type_Ryo.jdField_a_of_type_JavaLangString = null;
      paramrvv.jdField_a_of_type_Ryo.jdField_c_of_type_Boolean = false;
      break label125;
      label298:
      bool1 = false;
      break label146;
      label303:
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(paramrvv.jdField_a_of_type_Ryo, false);
      continue;
      label318:
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(paramrvv.jdField_a_of_type_Ryo);
    }
  }
  
  public void a(rwa paramrwa)
  {
    this.jdField_a_of_type_Rwa = paramrwa;
  }
  
  public void a(rya paramrya)
  {
    this.jdField_a_of_type_Rya = paramrya;
  }
  
  public void a(rzk paramrzk)
  {
    this.jdField_a_of_type_Rzk = paramrzk;
  }
  
  public void a(sbp paramsbp)
  {
    this.jdField_a_of_type_Sbp = paramsbp;
  }
  
  public void a(sbt paramsbt)
  {
    this.jdField_a_of_type_Sbt = paramsbt;
  }
  
  public void a(tsf paramtsf)
  {
    this.jdField_a_of_type_Tsf = paramtsf;
  }
  
  public void a(txm paramtxm)
  {
    this.jdField_a_of_type_Txm = paramtxm;
  }
  
  public void a(txu paramtxu)
  {
    this.jdField_a_of_type_Txu = paramtxu;
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
      twf.c(this.jdField_a_of_type_AndroidAppActivity);
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
      if (((localObject instanceof rvv)) && (((rvv)localObject).jdField_c_of_type_Int == this.jdField_a_of_type_Rvn.jdField_c_of_type_Int + 1))
      {
        localObject = ((rvv)localObject).jdField_a_of_type_Ryo;
        if ((localObject != null) && ((((ryo)localObject).jdField_a_of_type_Boolean) || ((((ryo)localObject).jdField_a_of_type_Sdj != null) && (!((ryo)localObject).jdField_a_of_type_Sdj.a()))))
        {
          ((ryo)localObject).jdField_a_of_type_Boolean = false;
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.c((ryo)localObject);
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
    if ((this.jdField_a_of_type_AndroidOsHandler != null) && (!this.jdField_q_of_type_Boolean))
    {
      if (QLog.isColorLevel()) {
        QLog.d("NativeAdUtils", 2, "rePostMsgForAd");
      }
      this.jdField_q_of_type_Boolean = true;
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
      this.jdField_a_of_type_Rvn = null;
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
    uhs.a(this);
    if ((this.jdField_a_of_type_Rvn != null) && (this.jdField_a_of_type_Rvn.jdField_a_of_type_Rsn != null) && ((this.jdField_a_of_type_Rvn.jdField_a_of_type_Rsn instanceof rvd))) {
      ((rvd)this.jdField_a_of_type_Rvn.jdField_a_of_type_Rsn).e();
    }
    ApngImage.playByTag(28);
    ApngImage.playByTag(29);
    ApngImage.playByTag(30);
    twf.d();
    twr.a(this.jdField_a_of_type_Txm, this, (rvv)this.jdField_a_of_type_Rvn);
  }
  
  public void e(boolean paramBoolean)
  {
    if ((!this.o) && (paramBoolean) && (this.p))
    {
      if ((this.jdField_a_of_type_Rvn instanceof rvv)) {
        a((rvv)this.jdField_a_of_type_Rvn);
      }
      this.p = false;
    }
    this.o = paramBoolean;
  }
  
  public void f()
  {
    if ((this.jdField_a_of_type_Sie != null) && (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null)) {
      ThreadManager.excute(new VideoFeedsAdapter.12(this), 16, null, true);
    }
    if (this.jdField_a_of_type_Rvk != null) {
      this.jdField_a_of_type_Rvk = null;
    }
    if (this.jdField_a_of_type_Rvn != null) {
      this.jdField_a_of_type_Rvn.jdField_c_of_type_ComTencentImageURLImageView = null;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidOsHandler = null;
    this.jdField_a_of_type_Bjsv = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    if (this.jdField_a_of_type_Tty != null) {
      this.jdField_a_of_type_Tty.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler != null) {
      AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    }
    if (this.jdField_a_of_type_Rtt != null)
    {
      this.jdField_a_of_type_Rtt.b();
      this.jdField_a_of_type_Rtt = null;
    }
    twf.e();
    bhyo.a().b(VideoFeedsUGView.a);
    if (this.jdField_a_of_type_Rvv != null)
    {
      a(this.jdField_a_of_type_Rvv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsUGView, false);
      a(this.jdField_a_of_type_Rvv.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsUGView, false);
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
    if ((this.jdField_a_of_type_Rvq != null) && (this.jdField_a_of_type_Rvq.itemView != null)) {
      return this.jdField_a_of_type_Rvq.itemView.hashCode();
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
    rvl localrvl = (rvl)paramView.getTag();
    Object localObject = null;
    if ((localrvl instanceof rvv))
    {
      VideoInfo localVideoInfo = ((rvv)localrvl).jdField_a_of_type_Ryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
      if ((this.jdField_a_of_type_Rvn != null) && (this.jdField_a_of_type_Rvn.jdField_a_of_type_Ryo != null))
      {
        localObject = localVideoInfo;
        if (localVideoInfo == this.jdField_a_of_type_Rvn.jdField_a_of_type_Ryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo) {
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
        c(paramView, localrvl, localObject);
        b(paramView, localrvl, localObject);
        a(paramView, localrvl, localObject);
      }
    }
  }
  
  public void onLoadUserInfoFailed(String paramString1, String paramString2) {}
  
  public void onLoadUserInfoSucceed(String paramString, ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    if (paramReadInJoyUserInfo != null) {
      rwv.a(new VideoFeedsAdapter.11(this, paramString));
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    rvl localrvl = (rvl)paramView.getTag();
    VideoInfo localVideoInfo = null;
    if ((localrvl instanceof rvv))
    {
      localVideoInfo = ((rvv)localrvl).jdField_a_of_type_Ryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
      if ((this.jdField_a_of_type_Rvn != null) && (this.jdField_a_of_type_Rvn.jdField_a_of_type_Ryo != null) && (localVideoInfo == this.jdField_a_of_type_Rvn.jdField_a_of_type_Ryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo)) {}
    }
    while (localVideoInfo == null) {
      return false;
    }
    switch (paramView.getId())
    {
    default: 
      return false;
    }
    if (oof.b() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      a(localVideoInfo, true, bool);
      if (this.jdField_a_of_type_Rzk != null) {
        this.jdField_a_of_type_Rzk.a(2, localVideoInfo, 0L);
      }
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ruw
 * JD-Core Version:    0.7.0.1
 */