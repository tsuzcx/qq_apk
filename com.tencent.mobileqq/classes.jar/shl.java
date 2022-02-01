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
import android.os.Message;
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
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.NativeAd.report.ExposeMode;
import com.tencent.biz.pubaccount.NativeAd.report.JumpMode;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ActionEntity;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportAction;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportConstants.VideoEndType;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoInfo.LikeActionDownloadBar;
import com.tencent.biz.pubaccount.VideoInfo.LocationInfo;
import com.tencent.biz.pubaccount.readinjoy.biu.ReadInJoyDeliverBiuActivity;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter.10;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter.13;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter.2;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsUGView;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.view.RIJDownloadView;
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
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

public class shl
  extends RecyclerView.Adapter<swj>
  implements View.OnClickListener, View.OnLongClickListener, qhl, sin, slp, ssm
{
  private static boolean i;
  public int a;
  public long a;
  public Activity a;
  private Context jdField_a_of_type_AndroidContentContext;
  public ColorDrawable a;
  public Drawable a;
  public Handler a;
  private LinearLayoutManager jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager;
  private RecyclerView.RecycledViewPool jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$RecycledViewPool = new RecyclerView.RecycledViewPool();
  public Animation a;
  public bldc a;
  public bleh a;
  private VideoInfo jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
  private VideoFeedsPlayManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager;
  public VideoFeedsRecyclerView a;
  private VideoPreDownloadMgr jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr;
  private ADVideoAppDownloadManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadManager;
  public GdtHandler.Params a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private INetInfoHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new sho(this);
  private String jdField_a_of_type_JavaLangString;
  private List<VideoInfo> jdField_a_of_type_JavaUtilList;
  private Map<Integer, Bitmap> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  private rkk jdField_a_of_type_Rkk;
  public sgi a;
  public sgk a;
  public shw a;
  public sib a;
  public skc a;
  private sln jdField_a_of_type_Sln;
  private slr jdField_a_of_type_Slr;
  public slx a;
  private sly jdField_a_of_type_Sly;
  private swm jdField_a_of_type_Swm;
  swp jdField_a_of_type_Swp;
  private swu jdField_a_of_type_Swu;
  public uif a;
  private uli jdField_a_of_type_Uli;
  private ulq jdField_a_of_type_Ulq;
  public boolean a;
  public int b;
  private long b;
  public Drawable b;
  public boolean b;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long;
  public boolean c;
  private int d = 1;
  public boolean d;
  private int e;
  public boolean e;
  public boolean f;
  public boolean g;
  public boolean h;
  private boolean j = true;
  private boolean k;
  private boolean l = true;
  private boolean m;
  private boolean n = true;
  private boolean o;
  private boolean p;
  private boolean q;
  private boolean r;
  private boolean s;
  private final boolean t;
  private boolean u;
  private boolean v = true;
  
  public shl(Context paramContext, Activity paramActivity, Bundle paramBundle, VideoFeedsRecyclerView paramVideoFeedsRecyclerView, LinearLayoutManager paramLinearLayoutManager, QQAppInterface paramQQAppInterface, boolean paramBoolean, int paramInt, slr paramslr)
  {
    this.jdField_a_of_type_Long = -2147483648L;
    this.jdField_a_of_type_AndroidOsHandler = new shp(this, Looper.getMainLooper());
    this.jdField_a_of_type_Slx = new shq(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView = paramVideoFeedsRecyclerView;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.a(this.jdField_a_of_type_Slx);
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager = paramLinearLayoutManager;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = bheg.a(true);
    this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131165357));
    this.jdField_a_of_type_Sgi = new sgi(paramActivity);
    i = paramBoolean;
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_a_of_type_Bldc = new bldc(this.jdField_a_of_type_AndroidAppActivity);
    AppNetConnInfo.registerConnectionChangeReceiver(this.jdField_a_of_type_AndroidAppActivity.getApplication(), this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(1930498322);
    this.jdField_a_of_type_Slr = paramslr;
    setHasStableIds(true);
    registerAdapterDataObserver(new shv(this, null));
    this.g = bdfk.b();
    this.jdField_a_of_type_Uif = new uif(paramActivity, this);
    this.t = bmhv.d();
    this.jdField_a_of_type_Sly = paramslr.a();
  }
  
  private VideoAdInfo a(swu paramswu)
  {
    if (paramswu == null) {}
    while ((paramswu.jdField_a_of_type_Skq == null) || (paramswu.jdField_a_of_type_Skq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == null)) {
      return null;
    }
    return paramswu.jdField_a_of_type_Skq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo;
  }
  
  @Nullable
  private AdvertisementInfo a(VideoInfo paramVideoInfo)
  {
    if (paramVideoInfo.jdField_c_of_type_Boolean)
    {
      paramVideoInfo = ulb.a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
      this.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params = uvp.a(this.jdField_a_of_type_AndroidAppActivity, paramVideoInfo, null, 3, false, null);
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
      return anvx.a(2131715608);
    }
    if (paramInt == 2) {
      return anvx.a(2131715605);
    }
    return null;
  }
  
  private void a(Message paramMessage)
  {
    Object localObject1;
    if ((this.jdField_a_of_type_Swm instanceof swi))
    {
      localswi = (swi)this.jdField_a_of_type_Swm;
      localObject1 = localswi.jdField_a_of_type_AndroidViewView;
      if (localObject1 != null) {
        break label30;
      }
    }
    label30:
    AdvertisementInfo localAdvertisementInfo;
    do
    {
      return;
      Object localObject2 = paramMessage.obj;
      paramMessage = localswi.jdField_a_of_type_Skq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo;
      localAdvertisementInfo = ois.a(paramMessage);
      if (localObject2 != null)
      {
        this.jdField_e_of_type_Boolean = true;
        if (localswi.h != null) {
          localswi.h.setVisibility(8);
        }
        if ((ukr.d(paramMessage)) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadManager != null)) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadManager.a();
        }
        six.a(localswi.l, 250, 8, Utils.dp2px(200.0D));
        six.a((View)localObject1, 250, 0, 250, ((View)localObject1).getMeasuredHeight());
        ois.a(new ufy().a(this.jdField_a_of_type_AndroidContentContext).a(ReportAction.CLOSE).a(1).b(21).a(JumpMode.UNKNOWN).a(localAdvertisementInfo).a(paramMessage).d(39).a());
        return;
      }
    } while (this.jdField_c_of_type_Boolean);
    swi localswi = (swi)this.jdField_a_of_type_Swm;
    six.a((View)localObject1, 250, 8, ((View)localObject1).getMeasuredHeight());
    if (!this.t) {
      ukc.b(localswi.jdField_b_of_type_AndroidWidgetSeekBar);
    }
    if (((swi)this.jdField_a_of_type_Swm).h != null)
    {
      a((swi)this.jdField_a_of_type_Swm);
      ((swi)this.jdField_a_of_type_Swm).h.setVisibility(0);
    }
    six.a(((swi)this.jdField_a_of_type_Swm).l, 250, 0, 250, Utils.dp2px(200.0D));
    if (ukr.d(paramMessage))
    {
      localObject1 = ((swi)this.jdField_a_of_type_Swm).jdField_b_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView;
      if (localObject1 != null) {
        ((RIJDownloadView)localObject1).a(true);
      }
    }
    ois.a(new ufy().a(this.jdField_a_of_type_AndroidContentContext).a(2).b(21).a(ActionEntity.VIDEO_NORMAL_AD_GUIDE_BIG).a(localAdvertisementInfo).a(paramMessage).a());
  }
  
  private void a(View paramView, int paramInt, VideoInfo paramVideoInfo)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.d())) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.b();
    }
    if (this.jdField_a_of_type_Uif != null) {
      this.jdField_a_of_type_Uif.a(paramView, paramInt, paramVideoInfo);
    }
  }
  
  private void a(View paramView, VideoInfo paramVideoInfo)
  {
    if ((paramVideoInfo.jdField_c_of_type_Boolean) && ((this.jdField_a_of_type_Swm instanceof swi))) {
      a(paramView, (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(), paramVideoInfo);
    }
  }
  
  private void a(View paramView, swj paramswj, VideoInfo paramVideoInfo)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      b(paramView, paramVideoInfo);
      return;
      h(paramVideoInfo);
      return;
      a(paramswj);
      return;
    } while ((this.jdField_a_of_type_Swm == null) || (this.jdField_a_of_type_Swm.j == null));
    this.jdField_a_of_type_Slr.e();
    this.jdField_a_of_type_Sly.c(this.jdField_a_of_type_Swm.jdField_a_of_type_Skq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo, "0X8009F42");
  }
  
  private void a(View paramView, swj paramswj, VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131367939: 
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(9, Boolean.valueOf(false)));
      this.jdField_b_of_type_Boolean = true;
      return;
    case 2131367949: 
      c(paramVideoInfo, paramAdvertisementInfo);
      return;
    case 2131367958: 
      b(paramVideoInfo, paramAdvertisementInfo);
      return;
    case 2131367946: 
      a(paramVideoInfo, paramAdvertisementInfo);
      return;
    case 2131367936: 
      uks.a(paramAdvertisementInfo, 37, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
      a(paramswj, paramVideoInfo, paramAdvertisementInfo, 37);
      return;
    case 2131367934: 
      uks.a(paramAdvertisementInfo, 34, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
      a(paramswj, paramVideoInfo, paramAdvertisementInfo, 34);
      return;
    case 2131365868: 
    case 2131367935: 
      uks.a(paramAdvertisementInfo, 35, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
      a(paramswj, paramVideoInfo, paramAdvertisementInfo, 35);
      return;
    case 2131365872: 
      uks.a(paramAdvertisementInfo, 2003, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
      a(paramswj, paramVideoInfo, paramAdvertisementInfo, 2003);
      return;
    case 2131362071: 
      uks.a(paramAdvertisementInfo, 18, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
      paramView = uvp.b(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, true, null);
      paramswj = ois.a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
      ois.a(new ufy().a(this.jdField_a_of_type_AndroidContentContext).a(1).b(21).a(paramView).a(paramswj).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).d(1000).a());
      return;
    }
    a(paramswj, paramVideoInfo, paramAdvertisementInfo, 18);
  }
  
  private void a(VideoAdInfo paramVideoAdInfo)
  {
    paramVideoAdInfo = ois.a(paramVideoAdInfo);
    if (paramVideoAdInfo != null) {
      uvp.a(this.jdField_a_of_type_AndroidAppActivity, paramVideoAdInfo.mPopFormH5Url, paramVideoAdInfo.mAdRl, paramVideoAdInfo.mAdTraceId);
    }
  }
  
  private void a(VideoInfo paramVideoInfo, int paramInt, JumpMode paramJumpMode)
  {
    if (paramVideoInfo == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(ReportConstants.VideoEndType.AD_AREA_CLICK);
    }
    AdvertisementInfo localAdvertisementInfo = ois.a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
    if (paramVideoInfo.a(this.jdField_a_of_type_AndroidAppActivity)) {}
    for (int i1 = 10;; i1 = 5)
    {
      ois.a(new ufy().a(this.jdField_a_of_type_AndroidContentContext).a(1).b(i1).a(paramJumpMode).a(localAdvertisementInfo).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).d(paramInt).a());
      return;
    }
  }
  
  private void a(VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo)
  {
    JumpMode localJumpMode = null;
    uks.a(paramAdvertisementInfo, 17, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
    if (a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo))
    {
      a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
      ois.a(new ufy().a(this.jdField_a_of_type_AndroidContentContext).a(42).b(5).a(JumpMode.ANDROID_ORDER).a(paramAdvertisementInfo).a());
      return;
    }
    this.jdField_a_of_type_Uli.f();
    if (paramAdvertisementInfo != null) {
      localJumpMode = uvp.b(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, true, null);
    }
    a(paramVideoInfo, 17, localJumpMode);
  }
  
  private void a(VideoInfo paramVideoInfo, swj paramswj, boolean paramBoolean)
  {
    if ((paramVideoInfo.jdField_c_of_type_Boolean) && ((paramswj instanceof swi)))
    {
      ukc.a((swi)paramswj, "暂不支持biu");
      return;
    }
    qgx.a().a(this.jdField_a_of_type_AndroidAppActivity, 2, new shs(this, paramVideoInfo, paramswj, paramBoolean));
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
      localObject1 = new suu((String)localObject1, paramVideoInfo.j, paramVideoInfo.jdField_a_of_type_JavaLangString, paramVideoInfo.g, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(), paramVideoInfo.a() * 1000);
      ((suu)localObject1).g(paramBoolean1).h(paramBoolean2).b(this.t);
      if (!i)
      {
        ((suu)localObject1).e(paramVideoInfo.f).c(paramVideoInfo.jdField_q_of_type_Int).a(-1).a(paramVideoInfo.w).M(0);
        localObject2 = new rqg();
        ((rqg)localObject2).d = ((int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a());
        ((rqg)localObject2).jdField_e_of_type_Int = (paramVideoInfo.a() * 1000);
        ((rqg)localObject2).jdField_b_of_type_Int = this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
        omx.b(paramVideoInfo, this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_CHANNEL_ID", -1), 25, -1, (rqg)localObject2, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g);
      }
      localObject1 = ((suu)localObject1).a().a();
      if (!i) {
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
      olh.a(null, (String)localObject2, "0X8009299", "0X8009299", 0, 0, "0", "0", paramVideoInfo, (String)localObject1, false);
      return;
      localObject1 = null;
      break;
    }
    label288:
    Object localObject2 = paramVideoInfo.j;
    if (!TextUtils.isEmpty(paramVideoInfo.g)) {}
    for (paramVideoInfo = paramVideoInfo.g;; paramVideoInfo = "0")
    {
      olh.a(null, (String)localObject2, "0X8007B89", "0X8007B89", 0, 0, "0", "0", paramVideoInfo, (String)localObject1, false);
      return;
    }
  }
  
  private void a(VideoFeedsUGView paramVideoFeedsUGView, boolean paramBoolean)
  {
    if (paramVideoFeedsUGView != null) {
      paramVideoFeedsUGView.setActive(paramBoolean);
    }
  }
  
  @RequiresApi(api=16)
  private void a(skq paramskq)
  {
    six.a(this.jdField_a_of_type_Swm.jdField_c_of_type_ComTencentImageURLImageView, 8, 0);
    this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView().getViewTreeObserver().addOnDrawListener(new shm(this, paramskq));
  }
  
  private void a(swi paramswi, VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo, int paramInt, View paramView, View... paramVarArgs)
  {
    if (paramVideoInfo.jdField_c_of_type_Boolean) {
      if (paramAdvertisementInfo == null) {
        break label196;
      }
    }
    label196:
    for (int i1 = paramAdvertisementInfo.clickPos;; i1 = 1000)
    {
      if ((AdvertisementInfo.isAppAdvertisementInfo(paramAdvertisementInfo)) && (ukr.d(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo)))
      {
        if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadManager.a(paramVideoInfo)) {
          break label124;
        }
        paramswi = uvp.b(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, true, null);
        if (paramInt == 21) {
          ois.a(new ufy().a(this.jdField_a_of_type_AndroidContentContext).a(1).b(21).a(paramswi).a(paramAdvertisementInfo).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).d(i1).a());
        }
      }
      else
      {
        return;
      }
      a(paramVideoInfo, i1, paramswi);
      return;
      label124:
      paramView.setVisibility(0);
      paramswi.jdField_a_of_type_Boolean = true;
      if (paramVarArgs != null)
      {
        paramInt = 0;
        while (paramInt < paramVarArgs.length)
        {
          paramVarArgs[paramInt].setVisibility(8);
          paramInt += 1;
        }
      }
      if (paramswi.jdField_b_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView != null) {
        paramswi.jdField_b_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView.a(i1);
      }
      paramswi.jdField_a_of_type_Boolean = true;
      ukc.a(paramswi);
      return;
    }
  }
  
  private void a(swi paramswi, VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo, int paramInt, View[] paramArrayOfView1, View[] paramArrayOfView2)
  {
    if (paramVideoInfo.jdField_c_of_type_Boolean) {
      if (paramAdvertisementInfo == null) {
        break label483;
      }
    }
    label483:
    for (int i1 = paramAdvertisementInfo.clickPos;; i1 = 1000)
    {
      if ((AdvertisementInfo.isAppAdvertisementInfo(paramAdvertisementInfo)) && (ukr.d(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo)))
      {
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadManager.a(paramVideoInfo))
        {
          paramswi = uvp.b(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, true, null);
          if (paramInt == 21)
          {
            paramAdvertisementInfo = ois.a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
            ois.a(new ufy().a(this.jdField_a_of_type_AndroidContentContext).a(1).b(21).a(paramswi).a(paramAdvertisementInfo).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).d(i1).a());
            return;
          }
          a(paramVideoInfo, i1, paramswi);
          return;
        }
        uks.a(paramAdvertisementInfo, i1, null);
        int i3 = paramArrayOfView1.length;
        int i2 = 0;
        while (i2 < i3)
        {
          paramArrayOfView1[i2].setVisibility(0);
          i2 += 1;
        }
        paramswi.jdField_a_of_type_Boolean = true;
        i3 = paramArrayOfView2.length;
        i2 = 0;
        while (i2 < i3)
        {
          paramArrayOfView2[i2].setVisibility(8);
          i2 += 1;
        }
        if (paramswi.jdField_b_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView != null) {
          paramswi.jdField_b_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView.a(i1);
        }
        if (paramInt == 21)
        {
          ois.a(new ufy().a(this.jdField_a_of_type_AndroidContentContext).a(1).b(34).a(paramAdvertisementInfo).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).d(i1).a());
          return;
        }
        ois.a(new ufy().a(this.jdField_a_of_type_AndroidContentContext).a(1).b(34).a(paramAdvertisementInfo).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).a());
        return;
      }
      if (paramInt == 21)
      {
        if (paramAdvertisementInfo != null) {
          paramAdvertisementInfo.setClickPos(38);
        }
        paramswi = new ufu();
        paramswi.jdField_c_of_type_Boolean = true;
        paramswi = uvp.b(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, true, paramswi);
        paramAdvertisementInfo = ois.a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
        ois.a(new ufy().a(this.jdField_a_of_type_AndroidContentContext).a(1).b(21).a(paramswi).a(paramAdvertisementInfo).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).d(i1).a());
        return;
      }
      if (this.p) {}
      for (paramInt = 13;; paramInt = 8)
      {
        if (paramAdvertisementInfo != null) {
          paramAdvertisementInfo.setClickPos(paramInt);
        }
        paramswi = new ufu();
        paramswi.jdField_c_of_type_Boolean = true;
        a(paramVideoInfo, paramInt, uvp.b(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, true, paramswi));
        return;
      }
    }
  }
  
  private void a(swj paramswj)
  {
    if ((paramswj.jdField_a_of_type_Int == 2) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.b())) {
      six.a(((swu)paramswj).d, 8, 200);
    }
    if (this.jdField_a_of_type_Slr != null) {
      this.jdField_a_of_type_Slr.b();
    }
  }
  
  private void a(swj paramswj, VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo)
  {
    if ((paramswj instanceof swi))
    {
      paramswj = (swi)paramswj;
      ukc.c(paramswj.jdField_b_of_type_AndroidWidgetSeekBar);
      a(paramswj, paramVideoInfo, paramAdvertisementInfo, -1, paramswj.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView, new View[0]);
    }
  }
  
  private void a(swm paramswm, VideoInfo paramVideoInfo)
  {
    skq localskq2 = paramswm.jdField_a_of_type_Skq;
    skq localskq1 = localskq2;
    if (localskq2 == null)
    {
      localskq1 = new skq();
      localskq1.jdField_a_of_type_Sfg = paramswm.jdField_a_of_type_Sow;
      localskq1.jdField_a_of_type_AndroidOsBundle.putInt("jump_from_scene", this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("PERFORMANCE_REPORT_VIDEO_FEEDS_JUMP_FROM", 0));
    }
    localskq1.jdField_a_of_type_ComTencentBizPubaccountVideoInfo = paramVideoInfo;
    localskq1.jdField_a_of_type_Int = paramVideoInfo.a(this.jdField_a_of_type_AndroidAppActivity, paramswm.d);
    localskq1.jdField_a_of_type_AndroidViewViewGroup = paramswm.jdField_b_of_type_AndroidViewViewGroup;
    localskq1.jdField_b_of_type_Int = paramswm.jdField_c_of_type_Int;
    localskq1.jdField_a_of_type_Boolean = false;
    localskq1.jdField_a_of_type_AndroidOsBundle.putInt("video_feeds_index", paramswm.jdField_c_of_type_Int);
    localskq1.jdField_a_of_type_Long = 0L;
    localskq1.jdField_b_of_type_Boolean = true;
    if (paramVideoInfo.jdField_c_of_type_Boolean)
    {
      if (!paramVideoInfo.a(this.jdField_a_of_type_AndroidAppActivity)) {
        break label173;
      }
      localskq1.jdField_a_of_type_AndroidOsBundle.putInt("ad_origin", 10);
    }
    for (;;)
    {
      paramswm.jdField_a_of_type_Sow.jdField_a_of_type_Boolean = true;
      paramswm.jdField_a_of_type_Skq = localskq1;
      paramswm.jdField_a_of_type_Suf.a(this, paramswm);
      return;
      label173:
      localskq1.jdField_a_of_type_AndroidOsBundle.putInt("ad_origin", 5);
    }
  }
  
  private void a(swm paramswm, boolean paramBoolean, long paramLong, int paramInt)
  {
    if (paramBoolean)
    {
      if (this.jdField_b_of_type_Long != 0L) {
        ThreadManager.excute(new VideoFeedsAdapter.2(this, paramLong), 16, null, true);
      }
      if ((paramswm.jdField_a_of_type_Skq != null) && (paramswm.jdField_a_of_type_Skq.jdField_a_of_type_Rqa != null))
      {
        paramswm.jdField_a_of_type_Skq.jdField_a_of_type_Rqa.o = paramLong;
        paramswm.jdField_a_of_type_Skq.jdField_a_of_type_Rqa.s = pkh.a(paramInt, paramswm.jdField_c_of_type_Int, false);
      }
      if ((paramswm.jdField_a_of_type_Skq != null) && (paramswm.jdField_a_of_type_Skq.jdField_a_of_type_Rpz != null)) {
        paramswm.jdField_a_of_type_Skq.jdField_a_of_type_Rpz.jdField_a_of_type_Boolean = true;
      }
    }
  }
  
  private void a(swp paramswp)
  {
    if (this.d == 1)
    {
      paramswp.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      paramswp.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      paramswp.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramswp.jdField_a_of_type_AndroidWidgetTextView.setText(a(1));
    }
    do
    {
      return;
      if (this.d == 2)
      {
        paramswp.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
        paramswp.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        paramswp.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        paramswp.jdField_a_of_type_AndroidWidgetTextView.setText(a(2));
        return;
      }
    } while (this.d != 3);
    if (paramswp.jdField_a_of_type_Int == 6)
    {
      paramswp.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      paramswp.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      paramswp.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramswp.jdField_a_of_type_AndroidWidgetTextView.setText(a(1));
      return;
    }
    paramswp.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
    paramswp.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    paramswp.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  private void a(swu paramswu, VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo)
  {
    if ((paramVideoInfo.jdField_c_of_type_Boolean) && ((paramswu instanceof swi)))
    {
      ukc.a((swi)paramswu, "作者设置暂不可评论");
      return;
    }
    c(paramswu, paramVideoInfo);
  }
  
  private void a(swu paramswu, AdvertisementInfo paramAdvertisementInfo, int paramInt, JSONObject paramJSONObject)
  {
    ois.a(new ufy().a(this.jdField_a_of_type_AndroidContentContext).a(2).b(paramInt).a(paramAdvertisementInfo).a(a(paramswu)).e(paramJSONObject).a(ExposeMode.LOOSE).b(true).a());
    ois.a(new ufy().a(this.jdField_a_of_type_AndroidContentContext).a(2).b(paramInt).a(paramAdvertisementInfo).a(a(paramswu)).e(paramJSONObject).a(ExposeMode.STRICT).a());
  }
  
  private boolean a(RecyclerView paramRecyclerView, List<VideoInfo> paramList, VideoInfo paramVideoInfo)
  {
    int i2 = paramRecyclerView.getChildCount();
    int i3 = paramList.indexOf(paramVideoInfo);
    int i1 = 0;
    while (i1 < i2)
    {
      paramList = paramRecyclerView.getChildViewHolder(paramRecyclerView.getChildAt(i1));
      if ((i3 >= 0) && ((paramList instanceof swu)) && (((swu)paramList).jdField_b_of_type_Int == i3))
      {
        ((swu)paramList).jdField_a_of_type_Sfc.b(paramVideoInfo);
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
      if ((localViewHolder instanceof swu))
      {
        VideoInfo localVideoInfo = (VideoInfo)paramList.get(((swu)localViewHolder).jdField_b_of_type_Int);
        if (paramString.equals(localVideoInfo.j)) {
          ((swu)localViewHolder).jdField_a_of_type_Sfc.b(localVideoInfo);
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
      paramVideoAdInfo = ois.a(paramVideoAdInfo);
    } while ((TextUtils.isEmpty(paramVideoAdInfo.mPopFormH5Url)) || (!ukr.d(paramVideoAdInfo)));
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
  
  private boolean a(swi paramswi)
  {
    boolean bool3 = true;
    boolean bool1 = true;
    boolean bool2 = bool1;
    if (paramswi != null)
    {
      bool2 = bool1;
      if (paramswi.jdField_a_of_type_Skq != null)
      {
        if (paramswi.jdField_a_of_type_Skq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) {
          break label34;
        }
        bool2 = bool1;
      }
    }
    label34:
    do
    {
      return bool2;
      paramswi = paramswi.jdField_a_of_type_Skq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
      bool1 = bool3;
      if (paramswi.jdField_c_of_type_Boolean)
      {
        paramswi = ois.a(paramswi.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
        bool1 = bool3;
        if (paramswi != null)
        {
          bool1 = bool3;
          if (!paramswi.mShowAdButton) {
            bool1 = false;
          }
        }
      }
      bool2 = bool1;
    } while (!QLog.isColorLevel());
    QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "showButton = " + bool1);
    return bool1;
  }
  
  private void b(View paramView, int paramInt1, int paramInt2)
  {
    int i2 = 1;
    swu localswu = (swu)paramView.getTag();
    if (localswu != this.jdField_a_of_type_Swm) {}
    while ((!this.v) || (localswu == null) || (localswu.jdField_a_of_type_Skq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == null) || (!(localswu instanceof swm)) || (TextUtils.isEmpty(localswu.jdField_a_of_type_Skq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g))) {
      return;
    }
    Object localObject = localswu.jdField_a_of_type_Skq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
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
      localswu.jdField_a_of_type_Sfc.a(paramInt1, paramInt2, bool);
      if (bool)
      {
        if (this.jdField_a_of_type_Shw != null) {
          this.jdField_a_of_type_Shw.a((VideoInfo)localObject, ((VideoInfo)localObject).r);
        }
        i((VideoInfo)localObject);
      }
      if (this.jdField_a_of_type_Sln != null) {
        this.jdField_a_of_type_Sln.a(3, (VideoInfo)localObject, 0L);
      }
      six.a(localswu.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout, (VideoInfo)localObject, "click_like", "double");
      VideoReport.reportEvent("clck", localswu.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout, null);
      localJSONObject = new JSONObject();
      if ((localswu.jdField_a_of_type_Skq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int != 0) || (localswu.jdField_a_of_type_Skq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null)) {
        break label515;
      }
      paramView = localswu.jdField_a_of_type_Skq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5();
    }
    try
    {
      label264:
      localJSONObject.put("channel_id", 409409);
      localJSONObject.put("rowkey", localswu.jdField_a_of_type_Skq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g);
      if (this.jdField_a_of_type_Skc == null) {
        break label520;
      }
      paramInt1 = this.jdField_a_of_type_Skc.a();
      label311:
      localJSONObject.put("style", paramInt1);
      localJSONObject.put("algorithm_id", ((VideoInfo)localObject).f);
      if (((VideoInfo)localObject).jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LikeActionDownloadBar == null) {
        break label525;
      }
      localObject = ((VideoInfo)localObject).jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LikeActionDownloadBar.jdField_c_of_type_JavaLangString;
      label353:
      localJSONObject.put("common_data", localObject);
      if (!this.t) {
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
    if (i)
    {
      localObject = "0X80097F5";
      str2 = localswu.jdField_a_of_type_Skq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.j;
      if (TextUtils.isEmpty(localswu.jdField_a_of_type_Skq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g)) {
        break label546;
      }
    }
    label515:
    label520:
    label525:
    label533:
    label546:
    for (str1 = localswu.jdField_a_of_type_Skq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g;; str1 = "0")
    {
      olh.a(null, str2, (String)localObject, (String)localObject, 0, 0, "0", "0", str1, omx.a(paramView, localswu.jdField_a_of_type_Skq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.j, localswu.jdField_a_of_type_Skq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, localswu.jdField_a_of_type_Skq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g, localJSONObject), false);
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
  
  private void b(View paramView, VideoInfo paramVideoInfo)
  {
    ImageView localImageView;
    if (this.jdField_a_of_type_Slr != null)
    {
      this.jdField_a_of_type_Slr.b();
      if ((this.jdField_a_of_type_Swm instanceof swu))
      {
        localImageView = this.jdField_a_of_type_Swm.g;
        if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.e()) {
          break label83;
        }
      }
    }
    label83:
    for (String str = "click_pause";; str = "click_play")
    {
      six.a(localImageView, paramVideoInfo, str);
      this.jdField_a_of_type_Swm.jdField_a_of_type_Suf.a();
      if (paramView.getId() == 2131366239) {
        sug.b(paramVideoInfo.g, 2);
      }
      return;
    }
  }
  
  private void b(View paramView, swj paramswj, VideoInfo paramVideoInfo)
  {
    AdvertisementInfo localAdvertisementInfo = a(paramVideoInfo);
    switch (paramView.getId())
    {
    default: 
    case 2131367152: 
    case 2131372208: 
    case 2131364711: 
    case 2131367466: 
    case 2131368118: 
    case 2131364988: 
    case 2131367178: 
    case 2131367179: 
    case 2131367160: 
    case 2131380903: 
    case 2131367960: 
    case 2131361857: 
      do
      {
        do
        {
          return;
          a(paramVideoInfo, paramswj, false);
          return;
        } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView == null);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.b();
        return;
        g(paramVideoInfo);
        return;
        a(paramView);
        return;
        b((swu)paramswj, paramVideoInfo, localAdvertisementInfo);
        return;
        a((swu)paramswj, paramVideoInfo, localAdvertisementInfo);
        return;
        qgx.a().a(this.jdField_a_of_type_AndroidAppActivity, 3, new shr(this, paramswj, paramVideoInfo));
        return;
        b(paramswj, paramVideoInfo);
        return;
        b((swu)paramswj, paramVideoInfo);
        return;
      } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView == null);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.a();
      return;
    case 2131367171: 
      e(paramVideoInfo);
      return;
    }
    f(paramVideoInfo);
  }
  
  private void b(VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo)
  {
    uks.a(paramAdvertisementInfo, 16, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
    this.jdField_a_of_type_Uli.f();
    a(paramVideoInfo, 16, uvp.b(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, true, null));
  }
  
  private void b(VideoInfo paramVideoInfo, swj paramswj, boolean paramBoolean)
  {
    boolean bool = true;
    if ((paramswj instanceof swu)) {
      six.a(((swu)paramswj).jdField_l_of_type_AndroidWidgetImageView, paramVideoInfo, "click_biu");
    }
    if (owc.a() == 1) {}
    for (;;)
    {
      a(paramVideoInfo, paramBoolean, bool);
      if (this.jdField_a_of_type_Sln != null) {
        this.jdField_a_of_type_Sln.a(2, paramVideoInfo, 0L);
      }
      return;
      bool = false;
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
  
  private void b(swi paramswi)
  {
    int i1;
    Object localObject;
    if ((paramswi != null) && (paramswi.jdField_a_of_type_Skq != null) && (paramswi.jdField_a_of_type_Skq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (paramswi.jdField_a_of_type_Skq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo != null))
    {
      i1 = ukr.d(ois.a(paramswi.jdField_a_of_type_Skq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo));
      if (i1 != 1) {
        break label84;
      }
      paramswi = paramswi.jdField_a_of_type_AndroidViewView;
      localObject = (LinearLayout.LayoutParams)paramswi.getLayoutParams();
      if (localObject != null)
      {
        ((LinearLayout.LayoutParams)localObject).weight = 2.0F;
        paramswi.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
    label84:
    do
    {
      do
      {
        return;
      } while (i1 != 2);
      localObject = paramswi.jdField_b_of_type_AndroidViewView;
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((View)localObject).getLayoutParams();
      if (localLayoutParams != null)
      {
        localLayoutParams.weight = 0.0F;
        ((View)localObject).setLayoutParams(localLayoutParams);
      }
      paramswi = paramswi.jdField_c_of_type_AndroidViewView;
      localObject = (LinearLayout.LayoutParams)paramswi.getLayoutParams();
    } while (localObject == null);
    ((LinearLayout.LayoutParams)localObject).weight = 0.0F;
    paramswi.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  private void b(swj paramswj, VideoInfo paramVideoInfo)
  {
    if (((paramswj instanceof swr)) && (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo != null))
    {
      six.a(this.jdField_a_of_type_AndroidAppActivity, paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.a);
      paramswj = new suu(paramVideoInfo).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo).i(paramVideoInfo.g).M(0).a();
      olh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "", "0X800AC2C", "0X800AC2C", 0, 0, "", "", "", paramswj.a(), false);
    }
  }
  
  private void b(swj paramswj, VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo)
  {
    if ((paramswj instanceof swi))
    {
      if (a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo))
      {
        a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
        ois.a(new ufy().a(this.jdField_a_of_type_AndroidContentContext).a(42).b(5).a(JumpMode.ANDROID_ORDER).a(paramAdvertisementInfo).a());
      }
    }
    else {
      return;
    }
    swi localswi = (swi)paramswj;
    int i1 = 8;
    if (this.p) {
      i1 = 13;
    }
    uks.a(paramAdvertisementInfo, i1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
    paramswj = new View[1];
    paramswj[0] = localswi.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView;
    if (b(paramVideoInfo)) {
      paramswj = new View[0];
    }
    ukc.c(localswi.jdField_b_of_type_AndroidWidgetSeekBar);
    a(localswi, paramVideoInfo, paramAdvertisementInfo, -1, paramswj, new View[0]);
  }
  
  private void b(swj paramswj, VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo, int paramInt)
  {
    if ((paramswj == null) || (paramVideoInfo == null) || (paramAdvertisementInfo == null)) {
      return;
    }
    paramAdvertisementInfo.setClickPos(paramInt);
    paramswj = uvp.b(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, true, null);
    paramAdvertisementInfo = ois.a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
    ois.a(new ufy().a(this.jdField_a_of_type_AndroidContentContext).a(1).b(21).a(paramswj).a(paramAdvertisementInfo).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).d(paramInt).a());
  }
  
  private void b(swm paramswm)
  {
    if ((this.jdField_a_of_type_Swm != null) && (this.jdField_a_of_type_Swm.jdField_a_of_type_Skq != null) && (this.jdField_a_of_type_Swm.jdField_a_of_type_Skq.jdField_a_of_type_Spn != null))
    {
      spn localspn = this.jdField_a_of_type_Swm.jdField_a_of_type_Skq.jdField_a_of_type_Spn;
      if ((!localspn.a()) && (!localspn.b()) && (!localspn.c()) && (this.jdField_a_of_type_Swm.jdField_c_of_type_Int == paramswm.jdField_c_of_type_Int - 1) && (bmhv.w(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (srr.a().a(this.jdField_a_of_type_Swm.jdField_a_of_type_Skq.jdField_a_of_type_Spn))) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.b(paramswm.jdField_a_of_type_Skq);
      }
    }
  }
  
  private void b(swu paramswu, VideoInfo paramVideoInfo)
  {
    this.jdField_a_of_type_Uli.e();
    a(false, paramswu);
    a(paramswu);
    a(paramVideoInfo, 21, JumpMode.UNKNOWN);
  }
  
  private void b(swu paramswu, VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramVideoInfo.jdField_c_of_type_Boolean)
    {
      uks.a(paramAdvertisementInfo, 1000, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
      a(paramVideoInfo, 1000, uvp.b(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, false, null));
      return;
    }
    d(paramswu, paramVideoInfo);
  }
  
  private static boolean b(VideoInfo paramVideoInfo)
  {
    return uks.a(paramVideoInfo);
  }
  
  private void c(View paramView, swj paramswj, VideoInfo paramVideoInfo)
  {
    AdvertisementInfo localAdvertisementInfo = a(paramVideoInfo);
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      a(paramView, paramswj, paramVideoInfo, localAdvertisementInfo);
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
      b(paramswj, paramVideoInfo, localAdvertisementInfo);
      continue;
      d(paramVideoInfo, localAdvertisementInfo);
      continue;
      uks.a(localAdvertisementInfo, 13, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
      a(paramswj, paramVideoInfo, localAdvertisementInfo);
      continue;
      k(paramVideoInfo, localAdvertisementInfo);
      continue;
      uks.a(localAdvertisementInfo, 2003, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
      a(paramswj, paramVideoInfo, localAdvertisementInfo, 2003);
      continue;
      uks.a(localAdvertisementInfo, 2004, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
      a(paramswj, paramVideoInfo, localAdvertisementInfo, 2004);
      continue;
      uks.a(localAdvertisementInfo, 4001, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
      b(paramswj, paramVideoInfo, localAdvertisementInfo, 4001);
      continue;
      uks.a(localAdvertisementInfo, 4002, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
      b(paramswj, paramVideoInfo, localAdvertisementInfo, 4002);
      continue;
      uks.a(localAdvertisementInfo, 4007, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
      b(paramswj, paramVideoInfo, localAdvertisementInfo, 4007);
      continue;
      uks.a(localAdvertisementInfo, 4000, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
      b(paramswj, paramVideoInfo, localAdvertisementInfo, 4000);
      continue;
      if ((AdvertisementInfo.isAppAdvertisementInfo(localAdvertisementInfo)) && (!b(paramVideoInfo)) && (ufc.a(localAdvertisementInfo)))
      {
        int i1 = 8;
        if (this.p) {
          i1 = 13;
        }
        ((swi)paramswj).jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView.a(i1);
        ((swi)paramswj).jdField_a_of_type_Boolean = true;
      }
      else
      {
        b(paramswj, paramVideoInfo, localAdvertisementInfo);
        continue;
        if ((AdvertisementInfo.isAppAdvertisementInfo(localAdvertisementInfo)) && (ufc.a(localAdvertisementInfo)))
        {
          ((swi)paramswj).jdField_b_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView.a(38);
          ((swi)paramswj).jdField_a_of_type_Boolean = true;
        }
        else
        {
          b(paramswj, paramVideoInfo, localAdvertisementInfo);
        }
      }
    }
  }
  
  private void c(VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo)
  {
    uks.a(paramAdvertisementInfo, 15, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
    this.jdField_a_of_type_Uli.f();
    a(paramVideoInfo, 15, uvp.b(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, true, null));
  }
  
  private void c(swj paramswj, VideoInfo paramVideoInfo)
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
      if ((paramswj instanceof swu))
      {
        ((swu)paramswj).jdField_a_of_type_Sfc.d();
        localImageView = ((swu)paramswj).m;
        if (!paramVideoInfo.r) {
          break label194;
        }
      }
    }
    label177:
    label194:
    for (paramswj = "click_like";; paramswj = "cancel_like")
    {
      six.a(localImageView, paramVideoInfo, paramswj);
      if ((this.jdField_a_of_type_Skc != null) && (paramVideoInfo.r)) {
        this.jdField_a_of_type_Skc.a((float)(DeviceInfoUtil.getPortraitWidth() / 2L), (float)(DeviceInfoUtil.getPortraitHeight() / 2L));
      }
      if (this.jdField_a_of_type_Sln != null) {
        this.jdField_a_of_type_Sln.a(3, paramVideoInfo, 0L);
      }
      if ((this.jdField_a_of_type_Shw != null) && (!paramVideoInfo.jdField_c_of_type_Boolean)) {
        this.jdField_a_of_type_Shw.a(paramVideoInfo, paramVideoInfo.r);
      }
      i(paramVideoInfo);
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
  
  private void c(swj paramswj, VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo)
  {
    if ((paramswj instanceof swi))
    {
      if (!a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo)) {
        break label93;
      }
      a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
      ois.a(new ufy().a(this.jdField_a_of_type_AndroidContentContext).a(42).b(5).a(JumpMode.ANDROID_ORDER).a(paramAdvertisementInfo).a());
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Swm != null) && (this.jdField_a_of_type_Swm.jdField_a_of_type_Skq != null)) {
        uks.a(this.jdField_a_of_type_Swm.jdField_a_of_type_Skq, true);
      }
      return;
      label93:
      swi localswi = (swi)paramswj;
      paramswj = new View[2];
      paramswj[0] = localswi.jdField_b_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView;
      paramswj[1] = localswi.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView;
      if (b(paramVideoInfo))
      {
        paramswj = new View[1];
        paramswj[0] = localswi.jdField_b_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView;
      }
      ukc.c(localswi.jdField_b_of_type_AndroidWidgetSeekBar);
      a(localswi, paramVideoInfo, paramAdvertisementInfo, 21, paramswj, new View[0]);
    }
  }
  
  private void c(swm paramswm)
  {
    paramswm = paramswm.jdField_a_of_type_Skq;
    if ((paramswm != null) && ((paramswm.jdField_a_of_type_Boolean) || ((paramswm.jdField_a_of_type_Spn != null) && (paramswm.jdField_a_of_type_Spn.b() != 0))))
    {
      paramswm.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.c(paramswm);
    }
  }
  
  private void c(swu paramswu, VideoInfo paramVideoInfo)
  {
    six.a(paramswu.jdField_l_of_type_AndroidViewViewGroup, paramVideoInfo, "click_comment");
    JSONObject localJSONObject = new JSONObject();
    this.jdField_a_of_type_Sib.e();
    for (;;)
    {
      try
      {
        if (paramVideoInfo.w == null) {
          continue;
        }
        paramswu = paramVideoInfo.w;
        localJSONObject.put("video_report_info", paramswu);
        localJSONObject.put("video_type", 0);
        if (!this.t) {
          continue;
        }
        i1 = 1;
        localJSONObject.put("interact_button_style", i1);
      }
      catch (JSONException paramswu)
      {
        int i1;
        paramswu.printStackTrace();
        continue;
        olh.a(null, "", "0X8008E54", "0X8008E54", 0, 0, "", "", "", omx.a("", "", paramVideoInfo.jdField_a_of_type_JavaLangString, paramVideoInfo.g, localJSONObject), false);
      }
      if (!i) {
        continue;
      }
      olh.a(null, "", "0X80092A1", "0X80092A1", 0, 0, "", "", "", omx.a("", "", paramVideoInfo.jdField_a_of_type_JavaLangString, paramVideoInfo.g, localJSONObject), false);
      return;
      paramswu = "";
      continue;
      i1 = 0;
    }
  }
  
  private void d(VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramVideoInfo.jdField_c_of_type_Boolean)
    {
      uks.a(paramAdvertisementInfo, 10, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
      a(paramVideoInfo, 10, uvp.b(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, false, null));
    }
  }
  
  private void d(swj paramswj, VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo)
  {
    if ((paramswj instanceof swi))
    {
      swi localswi = (swi)paramswj;
      ukc.c(localswi.jdField_b_of_type_AndroidWidgetSeekBar);
      a((swi)paramswj, paramVideoInfo, paramAdvertisementInfo, 21, localswi.jdField_b_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView, new View[0]);
    }
  }
  
  private void d(swu paramswu, VideoInfo paramVideoInfo)
  {
    long l2 = -1L;
    six.a(paramswu.p, paramVideoInfo, "click_write_comment");
    this.jdField_a_of_type_Sib.g();
    String str1;
    label49:
    long l1;
    if (i)
    {
      str1 = "0X800948A";
      if (paramswu.jdField_a_of_type_Skq == null) {
        break label226;
      }
      paramswu = paramswu.jdField_a_of_type_Skq.jdField_a_of_type_Spn;
      Object localObject = new suu(null, paramVideoInfo.j, paramVideoInfo.jdField_a_of_type_JavaLangString, paramVideoInfo.g);
      if (paramswu == null) {
        break label231;
      }
      l1 = paramswu.a(paramswu.h());
      label84:
      localObject = ((suu)localObject).d(l1);
      if (paramswu == null) {
        break label238;
      }
      l1 = paramswu.a();
      label101:
      localObject = ((suu)localObject).a(l1);
      l1 = l2;
      if (paramswu != null) {
        l1 = paramswu.b();
      }
      localObject = ((suu)localObject).c(l1).a(409409).a(paramVideoInfo.w).u(this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("VIDEO_FROM_TYPE", -1)).a().a();
      String str2 = paramVideoInfo.j;
      if (TextUtils.isEmpty(paramVideoInfo.g)) {
        break label245;
      }
      paramswu = paramVideoInfo.g;
      label186:
      olh.a(null, str2, str1, str1, 0, 0, "", "", paramswu, (String)localObject, false);
      if (!bmhv.k(pkh.a())) {
        break label252;
      }
    }
    label226:
    label231:
    label238:
    label245:
    label252:
    while (this.jdField_a_of_type_Sln == null)
    {
      return;
      str1 = "0X8009485";
      break;
      paramswu = null;
      break label49;
      l1 = -1L;
      break label84;
      l1 = -1L;
      break label101;
      paramswu = "0";
      break label186;
    }
    this.jdField_a_of_type_Sln.a(4, paramVideoInfo, 0L);
  }
  
  private void e(VideoInfo paramVideoInfo)
  {
    if (paramVideoInfo.o) {
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, "只能喂饼1次哦", 0).a();
    }
    for (;;)
    {
      this.jdField_a_of_type_Sly.a(paramVideoInfo, "0X800B2EB");
      return;
      this.jdField_a_of_type_Rkk.a(paramVideoInfo);
    }
  }
  
  private void e(VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramVideoInfo.jdField_c_of_type_Boolean)
    {
      if (this.f)
      {
        this.f = false;
        uks.a(paramAdvertisementInfo, 1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
        a(paramVideoInfo, 1, uvp.b(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, false, null));
      }
    }
    else {
      return;
    }
    uks.a(paramAdvertisementInfo, 4, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
    a(paramVideoInfo, 4, uvp.b(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, false, null));
  }
  
  private void f(VideoInfo paramVideoInfo)
  {
    String str2;
    String str1;
    if (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LocationInfo != null)
    {
      str2 = new suu("", paramVideoInfo.j, paramVideoInfo.jdField_a_of_type_JavaLangString, paramVideoInfo.g).i(paramVideoInfo.g).a().a();
      if (!paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LocationInfo.jdField_a_of_type_Boolean) {
        break label94;
      }
      str1 = "1";
      if (!paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LocationInfo.jdField_a_of_type_Boolean) {
        break label101;
      }
    }
    label94:
    label101:
    for (paramVideoInfo = "";; paramVideoInfo = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LocationInfo.jdField_a_of_type_JavaLangString)
    {
      olh.a(null, "", "0X800B4D0", "0X800B4D0", 0, 0, str1, paramVideoInfo, "", str2, false);
      return;
      str1 = "2";
      break;
    }
  }
  
  private void f(VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramVideoInfo.jdField_c_of_type_Boolean)
    {
      uks.a(paramAdvertisementInfo, 3, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
      a(paramVideoInfo, 3, uvp.b(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, false, null));
    }
  }
  
  private void g()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(2, null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(false, null);
  }
  
  private void g(VideoInfo paramVideoInfo)
  {
    if (paramVideoInfo.jdField_q_of_type_Boolean) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "followPubAccount onClick() puin=" + paramVideoInfo.j + ", isFollowed=" + paramVideoInfo.jdField_q_of_type_Boolean + ", pname=" + paramVideoInfo.k);
    }
    if ((this.jdField_a_of_type_Swm instanceof swu)) {
      six.a(((swu)this.jdField_a_of_type_Swm).jdField_a_of_type_Sfb, paramVideoInfo, "click_follow");
    }
    String str2 = new suu(null, paramVideoInfo.j, paramVideoInfo.jdField_a_of_type_JavaLangString, paramVideoInfo.g, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(), paramVideoInfo.a() * 1000L).a(paramVideoInfo.w).M(0).a().a();
    if (i)
    {
      str3 = paramVideoInfo.j;
      if (!TextUtils.isEmpty(paramVideoInfo.g)) {}
      for (str1 = paramVideoInfo.g;; str1 = "0")
      {
        olh.a(null, str3, "0X800929B", "0X800929B", 0, 0, "", "", str1, str2, false);
        this.jdField_a_of_type_Sly.a(paramVideoInfo, "0X800B1A7", true, true);
        this.jdField_a_of_type_Sly.a(paramVideoInfo, "0X800B1A6", false, true);
        a(paramVideoInfo.j, paramVideoInfo.jdField_b_of_type_Boolean, paramVideoInfo.p);
        return;
      }
    }
    String str3 = paramVideoInfo.j;
    if (!TextUtils.isEmpty(paramVideoInfo.g)) {}
    for (String str1 = paramVideoInfo.g;; str1 = "0")
    {
      olh.a(null, str3, "0X80078FD", "0X80078FD", 0, 0, "", "", str1, str2, false);
      break;
    }
  }
  
  private void g(VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramVideoInfo.jdField_c_of_type_Boolean)
    {
      uks.a(paramAdvertisementInfo, 2, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
      a(paramVideoInfo, 2, uvp.b(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, false, null));
    }
  }
  
  private void g(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "handleConnetNetWorkChange");
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager == null) || (!this.j)) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.e(paramBoolean);
    this.jdField_a_of_type_AndroidOsHandler.post(new VideoFeedsAdapter.13(this, paramBoolean));
  }
  
  private void h()
  {
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, 3000L);
    if (this.jdField_a_of_type_Swm == null) {}
    do
    {
      return;
      long l1 = this.jdField_a_of_type_Swm.jdField_a_of_type_Sow.a();
      long l2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.a();
      if (l2 > l1) {
        l1 = l2;
      }
      for (;;)
      {
        l1 = 3000L - (System.currentTimeMillis() - l1);
        if (l1 <= 0L) {
          break;
        }
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, l1);
        return;
      }
    } while ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager == null) || (this.jdField_a_of_type_Swm == null) || (this.jdField_a_of_type_Swm.jdField_a_of_type_Sfc == null));
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.d())
    {
      this.jdField_a_of_type_Swm.jdField_a_of_type_Sfc.g(false);
      return;
    }
    this.jdField_a_of_type_Swm.jdField_a_of_type_Sfc.b();
  }
  
  private void h(VideoInfo paramVideoInfo)
  {
    if ((this.jdField_a_of_type_Swm.jdField_a_of_type_Skq == null) || (paramVideoInfo == null)) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.a(false);
    } while (TextUtils.isEmpty(paramVideoInfo.g));
    sug.a(this.jdField_a_of_type_AndroidAppActivity, sfa.a(paramVideoInfo), this.jdField_a_of_type_Swm.jdField_a_of_type_Skq.jdField_a_of_type_Spn, 2, 0);
    sug.a(paramVideoInfo.g, 2, 0);
  }
  
  private void h(VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramVideoInfo.jdField_c_of_type_Boolean)
    {
      uks.a(paramAdvertisementInfo, 2, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
      a(paramVideoInfo, 2, uvp.b(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, false, null));
    }
  }
  
  private void i()
  {
    if (this.o)
    {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, 50L);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.a();
  }
  
  private void i(VideoInfo paramVideoInfo)
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
      if (paramVideoInfo.w == null) {
        break label274;
      }
      str1 = paramVideoInfo.w;
      label60:
      localJSONObject.put("video_report_info", str1);
      if (!paramVideoInfo.r) {
        break label103;
      }
      if (this.jdField_a_of_type_Skc == null) {
        break label322;
      }
      i1 = this.jdField_a_of_type_Skc.a();
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
      if (!this.t) {
        break label290;
      }
      i1 = i2;
      localJSONObject.put("interact_button_style", i1);
      if (!i) {
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
      olh.a(null, str4, str1, str1, 0, 0, "0", "0", str3, omx.a(str2, paramVideoInfo.j, paramVideoInfo.jdField_a_of_type_JavaLangString, paramVideoInfo.g, localJSONObject), false);
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
  
  private void i(VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramVideoInfo.jdField_c_of_type_Boolean)
    {
      uks.a(paramAdvertisementInfo, 1000, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
      a(paramVideoInfo, 1000, uvp.b(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, false, null));
    }
  }
  
  private void j()
  {
    int i2 = 0;
    this.s = false;
    swu localswu;
    Object localObject;
    int i1;
    JSONObject localJSONObject1;
    JSONObject localJSONObject2;
    ugg localugg;
    if ((this.jdField_a_of_type_Swm instanceof swu))
    {
      localswu = (swu)this.jdField_a_of_type_Swm;
      if ((localswu.jdField_a_of_type_Skq != null) && (localswu.jdField_a_of_type_Skq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (localswu.jdField_a_of_type_Skq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Boolean) && (localswu.jdField_a_of_type_Skq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo != null))
      {
        localObject = localswu.jdField_a_of_type_Skq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.h;
        if (!this.jdField_a_of_type_JavaUtilSet.contains(localObject))
        {
          this.jdField_a_of_type_JavaUtilSet.add(localObject);
          localObject = ois.a(localswu.jdField_a_of_type_Skq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
          i1 = 5;
          if (localswu.jdField_a_of_type_Skq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a(this.jdField_a_of_type_AndroidAppActivity)) {
            i1 = 10;
          }
          localJSONObject1 = new JSONObject();
          localJSONObject2 = new JSONObject();
          localugg = localswu.jdField_a_of_type_Skq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Ugg;
          if ((uls.jdField_a_of_type_Int != 1) || (localugg == null)) {
            break label331;
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        localJSONObject2.put("slot", localugg.jdField_a_of_type_Int);
        localJSONObject2.put("last_ad_distance", localugg.jdField_b_of_type_Int);
        localJSONObject2.put("last_ad_time", localugg.jdField_a_of_type_Long);
        localJSONObject2.put("stratege_time_b", localugg.jdField_c_of_type_Int);
        localJSONObject1.put("exposure_info_report", localJSONObject2.toString());
        ukq.a("Q.pubaccount.video.feeds.VideoFeedsAdapter", "exposure_info_report = " + localJSONObject2.toString());
        a(localswu, (AdvertisementInfo)localObject, i1, localJSONObject1);
        odz.a().a(Long.valueOf(localswu.jdField_a_of_type_Skq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.e));
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        continue;
      }
      try
      {
        label331:
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView != null) {
          i2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.c();
        }
        localJSONObject2.put("slot", this.jdField_a_of_type_Swm.getAdapterPosition() - i2);
        localJSONObject1.put("exposure_info_report", localJSONObject2.toString());
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  private void j(VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramVideoInfo.jdField_c_of_type_Boolean) {
      a(paramVideoInfo, 0, uvp.b(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, true, null));
    }
  }
  
  private void k()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.b();
  }
  
  private void k(VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo)
  {
    if ((this.jdField_a_of_type_Swm instanceof swu)) {
      six.a(((swu)this.jdField_a_of_type_Swm).i, paramVideoInfo, "click_puin");
    }
    if ((paramVideoInfo.jdField_a_of_type_Int == 0) && (paramVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null)) {}
    for (String str = paramVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5();; str = null)
    {
      if ((this.jdField_a_of_type_Sib != null) && (paramVideoInfo.a(this.jdField_a_of_type_AndroidAppActivity))) {
        this.jdField_a_of_type_Sib.h();
      }
      if (!paramVideoInfo.jdField_c_of_type_Boolean) {
        break;
      }
      a(paramVideoInfo, 0, uvp.b(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, true, null));
      return;
    }
    if ((paramVideoInfo.x != null) && (!paramVideoInfo.x.equals("")))
    {
      pkh.a(this.jdField_a_of_type_AndroidAppActivity, paramVideoInfo.x);
      return;
    }
    if (((this.jdField_a_of_type_Swm instanceof swr)) && (((swr)this.jdField_a_of_type_Swm).jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0) && (paramVideoInfo.jdField_a_of_type_Qgp != null) && (!TextUtils.isEmpty(paramVideoInfo.jdField_a_of_type_Qgp.d)))
    {
      pkh.a(this.jdField_a_of_type_AndroidAppActivity, paramVideoInfo.jdField_a_of_type_Qgp.d);
      this.jdField_a_of_type_Sly.b(paramVideoInfo, "0X800B17E");
      paramAdvertisementInfo = new suu(str, paramVideoInfo.j, paramVideoInfo.jdField_a_of_type_JavaLangString, paramVideoInfo.g, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(), paramVideoInfo.a() * 1000L).a(-1).M(0).a().a();
      str = paramVideoInfo.j;
      if (TextUtils.isEmpty(paramVideoInfo.g)) {
        break label390;
      }
    }
    label390:
    for (paramVideoInfo = paramVideoInfo.g;; paramVideoInfo = "0")
    {
      olh.a(null, str, "0X8007410", "0X8007410", 0, 0, "0", "", paramVideoInfo, paramAdvertisementInfo, false);
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
  
  private void l()
  {
    if (this.jdField_a_of_type_Swm == null) {}
    while ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager == null) || (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.d()) || (!(this.jdField_a_of_type_Swm instanceof swi)) || (uks.a((swi)this.jdField_a_of_type_Swm))) {
      return;
    }
    a(true, (swi)this.jdField_a_of_type_Swm);
  }
  
  private void m()
  {
    if (this.jdField_a_of_type_Swm == null) {}
    while ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager == null) || (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.d()) || (!(this.jdField_a_of_type_Swm instanceof swi)) || (uks.a((swi)this.jdField_a_of_type_Swm))) {
      return;
    }
    uke.a(true, (swi)this.jdField_a_of_type_Swm, this.t, this);
  }
  
  private void n()
  {
    if ((this.jdField_a_of_type_Swm instanceof swu)) {
      six.a(((swu)this.jdField_a_of_type_Swm).jdField_a_of_type_Sfb.a(), 8, 600);
    }
  }
  
  private void o()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr = new VideoPreDownloadMgr(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a = new spx(spx.jdField_c_of_type_Int, spx.f);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a(new shn(this));
  }
  
  private void p()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "handleNotNetWorkChange mIsActivityOnResume = " + this.j);
    }
    if (!this.j) {}
    while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.e(false);
  }
  
  public Drawable a(int paramInt)
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
  
  public swj a(ViewGroup paramViewGroup, int paramInt)
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
        paramViewGroup.jdField_a_of_type_Sfc = ((sfc)localObject3);
        paramViewGroup.jdField_a_of_type_Sow = new sow(paramViewGroup, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager, this.m);
        return paramViewGroup;
      }
      break;
    case 2: 
      localObject1 = sma.a(2131560377, true, new ViewGroup.LayoutParams(-1, -1));
      paramViewGroup = (swr)((View)localObject1).getTag();
      if (paramViewGroup == null) {
        paramViewGroup = new swr((View)localObject1);
      }
      break;
    }
    for (;;)
    {
      for (;;)
      {
        localObject3 = new swq((swr)paramViewGroup, this.jdField_a_of_type_Slr, this);
        try
        {
          paramInt = LiuHaiUtils.b(this.jdField_a_of_type_AndroidAppActivity);
          if ((LiuHaiUtils.b()) && (paramInt > 0) && (((swr)paramViewGroup).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsUGView != null))
          {
            localObject1 = (View)((swr)paramViewGroup).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsUGView.getParent();
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
      View localView = sma.a(2131560393, true, new ViewGroup.LayoutParams(-1, -1));
      paramViewGroup = (swr)localView.getTag();
      if (paramViewGroup == null) {
        paramViewGroup = new swt(localView);
      }
      for (;;)
      {
        for (;;)
        {
          localObject3 = new sws((swt)paramViewGroup, this.jdField_a_of_type_Slr, this);
          try
          {
            paramInt = LiuHaiUtils.b(this.jdField_a_of_type_AndroidAppActivity);
            if ((LiuHaiUtils.b()) && (paramInt > 0) && (((swr)paramViewGroup).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsUGView != null))
            {
              localView = (View)((swr)paramViewGroup).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsUGView.getParent();
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
        paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560367, paramViewGroup, false);
        if (!this.t) {
          ((LayoutInflater)localObject2).inflate(2131560404, (ViewGroup)paramViewGroup.findViewById(2131364992), true);
        }
        ((LayoutInflater)localObject2).inflate(2131560399, (ViewGroup)paramViewGroup.findViewById(2131364990), true);
        ((LayoutInflater)localObject2).inflate(2131560401, (ViewGroup)paramViewGroup.findViewById(2131364988), true);
        paramViewGroup = new swi(paramViewGroup, paramInt);
        localObject3 = new swd((swi)paramViewGroup, this.jdField_a_of_type_Slr, this);
        Object localObject2 = null;
        break;
        localObject3 = sma.a(2131560373, true, new ViewGroup.LayoutParams(-1, -1));
        localObject2 = (swp)((View)localObject3).getTag();
        paramViewGroup = (ViewGroup)localObject2;
        if (localObject2 == null) {
          paramViewGroup = new swp((View)localObject3, paramInt);
        }
        this.jdField_a_of_type_Swp = paramViewGroup;
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
    if ((localViewHolder instanceof swp)) {
      a((swp)localViewHolder);
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_e_of_type_Int = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.jdField_c_of_type_Long = paramLong;
  }
  
  public void a(View paramView)
  {
    if ((this.jdField_a_of_type_Sib != null) && (this.jdField_a_of_type_Sib.b()) && (this.jdField_a_of_type_Sib.c()))
    {
      this.jdField_a_of_type_Sib.h();
      break label34;
    }
    for (;;)
    {
      label34:
      return;
      if (!this.v) {
        continue;
      }
      paramView = (swm)paramView.getTag();
      if (paramView != this.jdField_a_of_type_Swm)
      {
        if (this.jdField_a_of_type_Swm == null) {
          break;
        }
        if ((paramView != null) && (paramView.jdField_c_of_type_Int == this.jdField_a_of_type_Swm.jdField_c_of_type_Int + 1) && (paramView.jdField_c_of_type_Int != getItemCount()))
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.a();
          return;
        }
        if ((paramView == null) || (paramView.jdField_c_of_type_Int != this.jdField_a_of_type_Swm.jdField_c_of_type_Int - 1)) {
          break;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.b();
        return;
      }
      paramView.jdField_a_of_type_Sfc.c();
      six.a(paramView.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout, paramView.jdField_a_of_type_Skq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo, "click_contentid");
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
          olh.a(null, null, "0X80091AB", "0X80091AB", 0, 0, "", "", "", omx.a(null, null, paramView.jdField_a_of_type_Skq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, paramView.jdField_a_of_type_Skq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g, localJSONObject), false);
          return;
          if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager == null) || (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.d())) {
            continue;
          }
          localJSONObject = new JSONObject();
          try
          {
            localJSONObject.put("channel_id", 409409);
            label335:
            olh.a(null, null, "0X80091AB", "0X80091AB", 0, 0, "", "", "", omx.a(null, null, paramView.jdField_a_of_type_Skq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, paramView.jdField_a_of_type_Skq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g, localJSONObject), false);
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
    paramView = (swu)paramView.getTag();
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
        } while (!this.u);
        paramView.jdField_a_of_type_Sfc.a(1);
        this.u = false;
        return;
      } while (paramView.d.getVisibility() != 0);
      paramView.jdField_a_of_type_Sfc.a(2);
    } while (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.b());
    this.u = true;
  }
  
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    qgx.a().a(this.jdField_a_of_type_AndroidAppActivity, 3, new sht(this, paramView, paramInt1, paramInt2));
  }
  
  public void a(VideoInfo paramVideoInfo)
  {
    a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView, this.jdField_a_of_type_JavaUtilList, paramVideoInfo);
  }
  
  public void a(VideoInfo paramVideoInfo, String paramString)
  {
    this.jdField_a_of_type_Sly.a(paramVideoInfo, paramString);
  }
  
  public void a(VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    if ((TextUtils.isEmpty(paramVideoInfo.j)) || (this.jdField_a_of_type_AndroidAppActivity == null)) {
      return;
    }
    paramVideoInfo = six.a(paramVideoInfo, paramBoolean, false);
    pkh.a(this.jdField_a_of_type_AndroidAppActivity, paramVideoInfo);
  }
  
  public void a(VideoFeedsPlayManager paramVideoFeedsPlayManager)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager = paramVideoFeedsPlayManager;
    o();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(new shu(this));
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
      if ((paramList instanceof swu)) {
        ((swu)paramList).jdField_a_of_type_Sfc.a();
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
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(String paramString1, boolean paramBoolean, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "followPubAccount() uin=" + paramString1);
    }
    if ((paramString1 == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
    do
    {
      return;
      six.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramBoolean, paramString2, false);
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
  
  public void a(List<VideoInfo> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void a(rkk paramrkk)
  {
    this.jdField_a_of_type_Rkk = paramrkk;
  }
  
  public void a(sgk paramsgk)
  {
    this.jdField_a_of_type_Sgk = paramsgk;
  }
  
  public void a(shw paramshw)
  {
    this.jdField_a_of_type_Shw = paramshw;
  }
  
  public void a(sib paramsib)
  {
    this.jdField_a_of_type_Sib = paramsib;
  }
  
  public void a(skc paramskc)
  {
    this.jdField_a_of_type_Skc = paramskc;
  }
  
  public void a(sln paramsln)
  {
    this.jdField_a_of_type_Sln = paramsln;
  }
  
  public void a(swi paramswi)
  {
    int i1;
    Object localObject;
    if ((paramswi != null) && (paramswi.jdField_a_of_type_Skq != null) && (paramswi.jdField_a_of_type_Skq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (paramswi.jdField_a_of_type_Skq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo != null))
    {
      i1 = ukr.d(ois.a(paramswi.jdField_a_of_type_Skq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo));
      if (i1 != 1) {
        break label88;
      }
      paramswi = paramswi.i;
      if (paramswi != null)
      {
        localObject = (LinearLayout.LayoutParams)paramswi.getLayoutParams();
        if (localObject != null)
        {
          ((LinearLayout.LayoutParams)localObject).weight = 2.0F;
          paramswi.setLayoutParams((ViewGroup.LayoutParams)localObject);
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
        localObject = paramswi.j;
        if (localObject != null)
        {
          LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((View)localObject).getLayoutParams();
          if (localLayoutParams != null)
          {
            localLayoutParams.weight = 0.0F;
            ((View)localObject).setLayoutParams(localLayoutParams);
          }
        }
        paramswi = paramswi.k;
      } while (paramswi == null);
      localObject = (LinearLayout.LayoutParams)paramswi.getLayoutParams();
    } while (localObject == null);
    ((LinearLayout.LayoutParams)localObject).weight = 0.0F;
    paramswi.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  public void a(swj paramswj, int paramInt)
  {
    paramswj.jdField_b_of_type_Int = paramInt;
    paramswj.jdField_c_of_type_Int = paramInt;
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size()))
    {
      if (this.jdField_a_of_type_Ulq != null)
      {
        VideoInfo localVideoInfo = this.jdField_a_of_type_Ulq.b(paramInt);
        if (localVideoInfo != null) {
          this.jdField_a_of_type_JavaUtilList.set(paramInt, localVideoInfo);
        }
      }
      a(paramswj, (VideoInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt));
    }
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramswj, paramInt, getItemId(paramInt));
      return;
      a(paramswj, null);
    }
  }
  
  public void a(swj paramswj, VideoInfo paramVideoInfo)
  {
    int i1 = paramswj.jdField_a_of_type_Int;
    if ((i1 == 3) || (i1 == 6))
    {
      a((swp)paramswj);
      this.jdField_a_of_type_Swp = ((swp)paramswj);
      return;
    }
    paramswj = (swm)paramswj;
    c(paramswj);
    a(paramswj, paramVideoInfo);
    sii.a.a(paramswj);
    TraceCompat.beginSection("refreshMenuUI");
    paramswj.jdField_a_of_type_Sfc.a_(paramVideoInfo);
    TraceCompat.endSection();
    TraceCompat.beginSection("refreshContentUI");
    paramswj.jdField_a_of_type_Sfc.a(paramVideoInfo, this.k);
    if (!TextUtils.isEmpty(paramVideoInfo.j))
    {
      ReadInJoyUserInfo localReadInJoyUserInfo = ReadInJoyUserInfoModule.a(Long.parseLong(paramVideoInfo.j), null);
      if ((localReadInJoyUserInfo != null) && (localReadInJoyUserInfo.isReadlTimeRead())) {
        ReadInJoyUserInfoModule.a(Long.parseLong(paramVideoInfo.j), this, true);
      }
    }
    TraceCompat.endSection();
    if ((this.o) && (paramswj == this.jdField_a_of_type_Swm)) {
      paramswj.jdField_a_of_type_Sfc.f(this.o);
    }
    b(paramswj);
    VideoReport.setElementId(paramswj.itemView, "card");
    VideoReport.setElementReuseIdentifier(paramswj.itemView, paramVideoInfo.g);
    VideoReport.setElementExposureMinRate(paramswj.itemView, 0.1D);
  }
  
  public void a(swj paramswj, VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo, int paramInt)
  {
    if ((paramswj == null) || (paramVideoInfo == null) || (paramAdvertisementInfo == null)) {}
    do
    {
      return;
      if ((!AdvertisementInfo.isAppAdvertisementInfo(paramAdvertisementInfo)) || (!ukr.a(paramAdvertisementInfo))) {
        break;
      }
      paramAdvertisementInfo.setClickPos(paramInt);
    } while (!(paramswj instanceof swi));
    swi localswi = (swi)paramswj;
    if ((localswi.jdField_a_of_type_Boolean) && (ukr.a(paramAdvertisementInfo)) && (localswi.jdField_b_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView.getVisibility() == 0))
    {
      d(paramswj, paramVideoInfo, paramAdvertisementInfo);
      return;
    }
    c(paramswj, paramVideoInfo, paramAdvertisementInfo);
    return;
    paramAdvertisementInfo.setClickPos(paramInt);
    paramswj = uvp.b(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, true, null);
    paramAdvertisementInfo = ois.a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
    ois.a(new ufy().a(this.jdField_a_of_type_AndroidContentContext).a(1).b(21).a(paramswj).a(paramAdvertisementInfo).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).d(paramInt).a());
  }
  
  public void a(swm paramswm)
  {
    boolean bool2 = true;
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsPlayManager.preplay", 2, "adapter playVideo (VideoItemHolder holder) ");
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(2, null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.b(ReportConstants.VideoEndType.SLIDE_LEAVE);
    int i1;
    label128:
    boolean bool1;
    label149:
    long l1;
    long l2;
    if (this.jdField_a_of_type_Swm != null)
    {
      i1 = this.jdField_a_of_type_Swm.jdField_c_of_type_Int;
      this.jdField_a_of_type_Swm = paramswm;
      if ((this.jdField_a_of_type_Swm.jdField_c_of_type_Int == 0) && (this.jdField_a_of_type_Swm.jdField_b_of_type_Int == 0))
      {
        paramswm.jdField_a_of_type_Skq.jdField_a_of_type_Long = this.jdField_c_of_type_Long;
        this.jdField_c_of_type_Long = 0L;
      }
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        break label275;
      }
      paramswm.jdField_a_of_type_Skq.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      paramswm.jdField_a_of_type_Skq.jdField_c_of_type_Boolean = true;
      this.jdField_a_of_type_JavaLangString = null;
      bool1 = bool2;
      if (this.n)
      {
        if (!a(paramswm)) {
          break label294;
        }
        bool1 = bool2;
      }
      this.n = false;
      l1 = System.currentTimeMillis();
      l2 = this.jdField_b_of_type_Long;
      paramswm.jdField_a_of_type_Skq.jdField_a_of_type_AndroidOsBundle.putBoolean("is_auto_play", bool1);
      if (!bool1) {
        break label314;
      }
      if ((!bmhv.g(this.jdField_c_of_type_Int)) || (!this.jdField_a_of_type_Swm.jdField_a_of_type_Skq.jdField_c_of_type_Boolean) || (Build.VERSION.SDK_INT < 16)) {
        break label299;
      }
      a(paramswm.jdField_a_of_type_Skq);
    }
    for (;;)
    {
      a(paramswm, bool1, l1 - l2, i1);
      if (paramswm.jdField_a_of_type_Skq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) {
        uuc.a(paramswm.jdField_a_of_type_Skq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g, paramswm.jdField_a_of_type_Skq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, 0, 0);
      }
      return;
      i1 = -1;
      break;
      label275:
      paramswm.jdField_a_of_type_Skq.jdField_a_of_type_JavaLangString = null;
      paramswm.jdField_a_of_type_Skq.jdField_c_of_type_Boolean = false;
      break label128;
      label294:
      bool1 = false;
      break label149;
      label299:
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(paramswm.jdField_a_of_type_Skq, false);
      continue;
      label314:
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(paramswm.jdField_a_of_type_Skq);
    }
  }
  
  public void a(swt paramswt)
  {
    long l2 = -1L;
    Object localObject;
    if (paramswt.jdField_a_of_type_Skq != null)
    {
      localObject = paramswt.jdField_a_of_type_Skq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
      if (paramswt.jdField_a_of_type_Skq == null) {
        break label120;
      }
      paramswt = paramswt.jdField_a_of_type_Skq.jdField_a_of_type_Spn;
      label36:
      localObject = new suu((VideoInfo)localObject);
      if (paramswt == null) {
        break label125;
      }
    }
    label120:
    label125:
    for (long l1 = paramswt.a();; l1 = -1L)
    {
      localObject = ((suu)localObject).a(l1);
      l1 = l2;
      if (paramswt != null) {
        l1 = paramswt.b();
      }
      olh.a(null, "", "0X800B28A", "0X800B28A", 0, 0, "3", "", "", ((suu)localObject).c(l1).a().a(), false);
      return;
      localObject = null;
      break;
      paramswt = null;
      break label36;
    }
  }
  
  public void a(swu paramswu, VideoInfo paramVideoInfo)
  {
    if (bdvn.a()) {}
    do
    {
      do
      {
        return;
        if (paramswu.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsUGView != null) {
          paramswu.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsUGView.a();
        }
        if (paramswu.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsUGView != null) {
          paramswu.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsUGView.a();
        }
      } while ((paramVideoInfo.jdField_a_of_type_Omr == null) && (paramVideoInfo.jdField_b_of_type_Omr == null));
      if ((paramswu.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsUGView != null) && (paramVideoInfo.jdField_a_of_type_Omr != null) && ((paramVideoInfo.jdField_a_of_type_Omr.jdField_c_of_type_Int == 1) || (paramVideoInfo.jdField_a_of_type_Omr.jdField_c_of_type_Int == 2))) {
        paramswu.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsUGView.setInfo(paramVideoInfo.jdField_a_of_type_Omr, paramVideoInfo.jdField_c_of_type_JavaLangString, "VideoPlay_ContentMix");
      }
    } while ((paramswu.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsUGView == null) || (paramVideoInfo.jdField_b_of_type_Omr == null) || ((paramVideoInfo.jdField_b_of_type_Omr.jdField_c_of_type_Int != 1) && (paramVideoInfo.jdField_b_of_type_Omr.jdField_c_of_type_Int != 2)));
    paramswu.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsUGView.setInfo(paramVideoInfo.jdField_b_of_type_Omr, paramVideoInfo.jdField_c_of_type_JavaLangString, "VideoPlay_Shooting");
  }
  
  public void a(uli paramuli)
  {
    this.jdField_a_of_type_Uli = paramuli;
  }
  
  public void a(ulq paramulq)
  {
    this.jdField_a_of_type_Ulq = paramulq;
  }
  
  public void a(boolean paramBoolean)
  {
    this.k = paramBoolean;
  }
  
  public void a(boolean paramBoolean, swu paramswu)
  {
    if (!(paramswu instanceof swi)) {
      return;
    }
    swi localswi = (swi)paramswu;
    if ((paramBoolean) && (localswi.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView != null)) {
      localswi.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView.c();
    }
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localswi.jdField_a_of_type_Skq != null)
    {
      bool1 = bool2;
      if (localswi.jdField_a_of_type_Skq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null)
      {
        bool1 = bool2;
        if (localswi.jdField_a_of_type_Skq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo != null) {
          bool1 = ukr.d(localswi.jdField_a_of_type_Skq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
        }
      }
    }
    if ((localswi.jdField_a_of_type_Boolean) && (bool1))
    {
      ukc.b(localswi.jdField_c_of_type_AndroidWidgetRelativeLayout);
      if (!this.t) {
        ukc.c(localswi.jdField_b_of_type_AndroidWidgetSeekBar);
      }
      if (b(localswi.jdField_a_of_type_Skq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo))
      {
        ukc.a(localswi.jdField_c_of_type_AndroidWidgetRelativeLayout);
        return;
      }
      ukc.a(localswi.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView);
      return;
    }
    if (localswi.d.getVisibility() == 8) {
      ukc.a(localswi.jdField_b_of_type_AndroidWidgetSeekBar);
    }
    if ((localswi.jdField_a_of_type_Skq != null) && (localswi.jdField_a_of_type_Skq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (localswi.jdField_a_of_type_Skq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo != null))
    {
      if (!b(localswi.jdField_a_of_type_Skq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo)) {
        break label252;
      }
      ukc.b(localswi.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView);
      ukc.a(localswi.jdField_c_of_type_AndroidWidgetRelativeLayout);
    }
    for (;;)
    {
      b(localswi);
      return;
      label252:
      if (a(localswi))
      {
        ukc.b(localswi.jdField_c_of_type_AndroidWidgetRelativeLayout);
        ukc.a(localswi.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView);
        if ((paramswu instanceof swi)) {
          ukc.a(this.jdField_a_of_type_AndroidAppActivity, (swi)paramswu);
        }
        ukc.a(paramBoolean, localswi);
      }
      else
      {
        ukc.b(localswi.jdField_c_of_type_AndroidWidgetRelativeLayout);
        ukc.b(localswi.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView);
      }
    }
  }
  
  public boolean a(String paramString)
  {
    return this.jdField_a_of_type_JavaUtilSet.contains(paramString);
  }
  
  public boolean a(swm paramswm)
  {
    boolean bool4 = true;
    boolean bool2 = true;
    boolean bool3 = false;
    paramswm.jdField_a_of_type_Sow.jdField_a_of_type_Boolean = false;
    boolean bool1 = bool2;
    Bundle localBundle;
    int i2;
    if (paramswm.jdField_c_of_type_Int == this.jdField_e_of_type_Int)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_AndroidContentContext != null)
      {
        bool1 = bool2;
        if (paramswm.jdField_a_of_type_Skq != null)
        {
          bool1 = bool2;
          if (paramswm.jdField_a_of_type_Skq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null)
          {
            localBundle = this.jdField_a_of_type_AndroidAppActivity.getIntent().getExtras();
            i2 = localBundle.getInt("VIDEO_FROM_TYPE", 0);
            if (NetworkUtil.isMobileNetWork(this.jdField_a_of_type_AndroidContentContext)) {
              break label138;
            }
            i1 = 1;
            if ((i1 == 0) && (!this.m)) {
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
        paramswm = paramswm.jdField_a_of_type_Sow;
        bool1 = bool3;
        if (i1 == 0) {
          bool1 = true;
        }
        paramswm.jdField_a_of_type_Boolean = bool1;
        return true;
      }
      paramswm = paramswm.jdField_a_of_type_Sow;
      if (i1 == 0) {}
      for (bool1 = bool4;; bool1 = false)
      {
        paramswm.jdField_a_of_type_Boolean = bool1;
        return false;
      }
    }
    if (i1 != 0)
    {
      paramswm.jdField_a_of_type_Sow.jdField_a_of_type_Boolean = false;
      return true;
    }
    i1 = localBundle.getInt("VIDEO_PLAY_STATUS", 0);
    paramswm = paramswm.jdField_a_of_type_Sow;
    if (((2 != i2) && (6 != i2) && (5 != i2)) || (3 != i1))
    {
      bool1 = true;
      label275:
      paramswm.jdField_a_of_type_Boolean = bool1;
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
    this.j = false;
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(2, null);
    }
    ApngImage.pauseByTag(28);
    ApngImage.pauseByTag(29);
    ApngImage.pauseByTag(30);
    if (paramInt == 1) {
      ukg.c(this.jdField_a_of_type_AndroidAppActivity);
    }
  }
  
  public void b(View paramView) {}
  
  public void b(VideoInfo paramVideoInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo = paramVideoInfo;
  }
  
  public void b(String paramString)
  {
    a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView, this.jdField_a_of_type_JavaUtilList, paramString);
  }
  
  public void b(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }
  
  public void c()
  {
    int i2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.getChildViewHolder(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.getChildAt(i1));
      if (((localObject instanceof swu)) && (((swu)localObject).jdField_c_of_type_Int == this.jdField_a_of_type_Swm.jdField_c_of_type_Int + 1))
      {
        localObject = ((swu)localObject).jdField_a_of_type_Skq;
        if ((localObject != null) && ((((skq)localObject).jdField_a_of_type_Boolean) || ((((skq)localObject).jdField_a_of_type_Spn != null) && (!((skq)localObject).jdField_a_of_type_Spn.a()))))
        {
          ((skq)localObject).jdField_a_of_type_Boolean = false;
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.c((skq)localObject);
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
    this.d = paramInt;
  }
  
  public void c(VideoInfo paramVideoInfo)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.contains(paramVideoInfo)))
    {
      int i1 = this.jdField_a_of_type_JavaUtilList.indexOf(paramVideoInfo);
      g();
      this.jdField_a_of_type_JavaUtilList.remove(paramVideoInfo);
      this.jdField_a_of_type_Swm = null;
      notifyItemRemoved(i1);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_AndroidOsHandler != null) && (!this.s))
    {
      if (QLog.isColorLevel()) {
        QLog.d("NativeAdUtils", 2, "rePostMsgForAd");
      }
      this.s = true;
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(4, null);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(4, 1000L);
    }
  }
  
  public void d(VideoInfo paramVideoInfo)
  {
    this.jdField_a_of_type_Sly.b(paramVideoInfo);
  }
  
  public void d(boolean paramBoolean)
  {
    this.m = paramBoolean;
  }
  
  public void e()
  {
    this.j = true;
    uvp.a(this);
    if ((this.jdField_a_of_type_Swm != null) && (this.jdField_a_of_type_Swm.jdField_a_of_type_Sfc != null) && ((this.jdField_a_of_type_Swm.jdField_a_of_type_Sfc instanceof swd))) {
      ((swd)this.jdField_a_of_type_Swm.jdField_a_of_type_Sfc).e();
    }
    ApngImage.playByTag(28);
    ApngImage.playByTag(29);
    ApngImage.playByTag(30);
    ukg.d();
    uks.a(this.jdField_a_of_type_Uli, this, (swu)this.jdField_a_of_type_Swm);
  }
  
  public void e(boolean paramBoolean)
  {
    if ((!this.jdField_q_of_type_Boolean) && (paramBoolean) && (this.r))
    {
      if ((this.jdField_a_of_type_Swm instanceof swu)) {
        a((swu)this.jdField_a_of_type_Swm);
      }
      this.r = false;
    }
    this.jdField_q_of_type_Boolean = paramBoolean;
  }
  
  public void f()
  {
    this.jdField_a_of_type_Sly.a();
    if (this.jdField_a_of_type_Shw != null) {
      this.jdField_a_of_type_Shw = null;
    }
    if (this.jdField_a_of_type_Swm != null) {
      this.jdField_a_of_type_Swm.jdField_c_of_type_ComTencentImageURLImageView = null;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidOsHandler = null;
    this.jdField_a_of_type_Bleh = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    if (this.jdField_a_of_type_Uif != null) {
      this.jdField_a_of_type_Uif.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler != null) {
      AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    }
    if (this.jdField_a_of_type_Sgi != null)
    {
      this.jdField_a_of_type_Sgi.b();
      this.jdField_a_of_type_Sgi = null;
    }
    ukg.e();
    bjjq.a().b(VideoFeedsUGView.a);
    if (this.jdField_a_of_type_Swu != null)
    {
      a(this.jdField_a_of_type_Swu.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsUGView, false);
      a(this.jdField_a_of_type_Swu.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsUGView, false);
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
    if ((this.jdField_a_of_type_Swp != null) && (this.jdField_a_of_type_Swp.itemView != null)) {
      return this.jdField_a_of_type_Swp.itemView.hashCode();
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
        if (this.t) {
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
    swj localswj = (swj)paramView.getTag();
    Object localObject = null;
    if ((localswj instanceof swu))
    {
      VideoInfo localVideoInfo = ((swu)localswj).jdField_a_of_type_Skq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
      if ((this.jdField_a_of_type_Swm != null) && (this.jdField_a_of_type_Swm.jdField_a_of_type_Skq != null))
      {
        localObject = localVideoInfo;
        if (localVideoInfo == this.jdField_a_of_type_Swm.jdField_a_of_type_Skq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo) {
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
        c(paramView, localswj, localObject);
        b(paramView, localswj, localObject);
        a(paramView, localswj, localObject);
      }
    }
  }
  
  public void onLoadUserInfoFailed(String paramString1, String paramString2) {}
  
  public void onLoadUserInfoSucceed(String paramString, ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    if (paramReadInJoyUserInfo != null) {
      six.a(new VideoFeedsAdapter.10(this, paramString));
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    swj localswj = (swj)paramView.getTag();
    Object localObject = null;
    if ((localswj instanceof swu))
    {
      VideoInfo localVideoInfo = ((swu)localswj).jdField_a_of_type_Skq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
      if ((this.jdField_a_of_type_Swm != null) && (this.jdField_a_of_type_Swm.jdField_a_of_type_Skq != null))
      {
        localObject = localVideoInfo;
        if (localVideoInfo == this.jdField_a_of_type_Swm.jdField_a_of_type_Skq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo) {}
      }
      else
      {
        return false;
      }
    }
    if (localObject == null) {
      return false;
    }
    switch (paramView.getId())
    {
    default: 
      return false;
    }
    a(localObject, localswj, true);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     shl
 * JD-Core Version:    0.7.0.1
 */