import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyChannelActivity;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.handlers.VideoHandler.1;
import com.tencent.biz.pubaccount.readinjoy.handlers.VideoHandler.11;
import com.tencent.biz.pubaccount.readinjoy.handlers.VideoHandler.2;
import com.tencent.biz.pubaccount.readinjoy.handlers.VideoHandler.5;
import com.tencent.biz.pubaccount.readinjoy.handlers.VideoHandler.6;
import com.tencent.biz.pubaccount.readinjoy.handlers.VideoHandler.7;
import com.tencent.biz.pubaccount.readinjoy.handlers.VideoHandler.8;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseListView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseListViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.os.MqqHandler;

public class psf
  extends prx
  implements Handler.Callback
{
  private static volatile boolean e;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private Handler jdField_a_of_type_AndroidOsHandler;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private AnimationSet jdField_a_of_type_AndroidViewAnimationAnimationSet;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  protected VideoPreDownloadMgr a;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private oau jdField_a_of_type_Oau;
  public psk a;
  private rsu jdField_a_of_type_Rsu;
  private rtp jdField_a_of_type_Rtp;
  protected sdc a;
  protected sdv a;
  private sig jdField_a_of_type_Sig;
  private skc jdField_a_of_type_Skc;
  protected boolean a;
  private int b;
  protected boolean b;
  protected boolean c;
  protected boolean d = true;
  private boolean f;
  private boolean g;
  private boolean h = true;
  
  private void A()
  {
    a().g();
  }
  
  private void B()
  {
    if (b() == 56) {
      pkm.a().a(56);
    }
  }
  
  private LinearLayout a()
  {
    if (pcl.c(b())) {
      return this.jdField_a_of_type_AndroidWidgetLinearLayout;
    }
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewViewStub.inflate());
    }
    return this.jdField_a_of_type_AndroidWidgetLinearLayout;
  }
  
  private BaseArticleInfo a(int paramInt)
  {
    return a().b(paramInt);
  }
  
  public static BaseArticleInfo a(psf parampsf, View paramView)
  {
    if ((parampsf == null) || (paramView == null) || (!(paramView.getTag() instanceof psk))) {
      return null;
    }
    paramView = (psk)paramView.getTag();
    if (paramView != null) {
      return parampsf.a(paramView.a());
    }
    return null;
  }
  
  public static psk a(View paramView)
  {
    if ((paramView == null) || (!(paramView.getTag() instanceof psk))) {
      return null;
    }
    return (psk)paramView.getTag();
  }
  
  private sdg a()
  {
    if (this.jdField_a_of_type_Sdc != null) {
      return this.jdField_a_of_type_Sdc.a();
    }
    return null;
  }
  
  private void a(int paramInt)
  {
    a().setLayerType(2, null);
    this.jdField_a_of_type_AndroidWidgetTextView.setLayerType(2, null);
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetTextView, View.ALPHA, new float[] { 0.0F, 1.0F });
    localObjectAnimator1.addListener(new psj(this));
    localObjectAnimator1.setDuration(400L);
    localObjectAnimator1.setInterpolator(new LinearInterpolator());
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(a(), View.TRANSLATION_Y, new float[] { 0.0F, -paramInt });
    localObjectAnimator2.addListener(new psg(this));
    localObjectAnimator2.setDuration(400L);
    this.jdField_a_of_type_ComTencentWidgetListView.setAlpha(0.0F);
    localObjectAnimator2.start();
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    localObjectAnimator1.start();
  }
  
  public static void a(Context paramContext, ImageView paramImageView, sdg paramsdg)
  {
    if (paramImageView == null) {
      return;
    }
    ViewGroup.LayoutParams localLayoutParams = paramImageView.getLayoutParams();
    localLayoutParams.width = ((int)pai.a(paramContext, paramsdg));
    paramImageView.setLayoutParams(localLayoutParams);
  }
  
  public static void a(View paramView)
  {
    if (paramView == null) {}
    View localView2;
    do
    {
      return;
      View localView1 = null;
      if ((paramView.getTag() instanceof skb)) {
        localView1 = ((skb)paramView.getTag()).g;
      }
      localView2 = localView1;
      if (localView1 == null)
      {
        localView2 = localView1;
        if ((paramView.getTag(2131375992) instanceof skb)) {
          localView2 = ((skb)paramView.getTag(2131375992)).g;
        }
      }
    } while (localView2 == null);
    EventCollector.getInstance().onViewClicked(localView2);
  }
  
  private void a(View paramView, int paramInt)
  {
    if ((a() instanceof ReadInJoyChannelActivity)) {
      if ((this.c) && (paramView != null) && (paramInt > 0) && (paramInt <= 2))
      {
        if ((paramInt != 1) || (!this.d)) {
          break label103;
        }
        this.d = false;
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
      return;
      label103:
      if (paramInt == 2)
      {
        if (this.c) {
          this.c = false;
        }
        paramView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimationSet);
      }
    }
  }
  
  private void a(AbsListView paramAbsListView)
  {
    psk localpsk = a(paramAbsListView);
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 4, "playVideoInArea:" + localpsk);
    }
    sdg localsdg;
    if (localpsk != null)
    {
      paramAbsListView = localpsk.a();
      localsdg = this.jdField_a_of_type_Sdc.a();
      if (paramAbsListView == this.jdField_a_of_type_Sdc.jdField_a_of_type_Sdg) {
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
        } while ((localsdg != null) && (localsdg.jdField_c_of_type_Long == paramAbsListView.jdField_c_of_type_Long) && (localsdg.b == b()) && (!this.jdField_a_of_type_Sdc.d()) && (!this.jdField_a_of_type_Sdc.e()));
        sek.a().b();
        a(localpsk);
      } while (!QLog.isColorLevel());
      QLog.d("Q.readinjoy.video", 2, "checkPlayableArea vid: " + paramAbsListView.jdField_c_of_type_JavaLangString);
      return;
      o();
    } while (this.jdField_a_of_type_Sdc.a() == null);
    this.jdField_a_of_type_Sdc.a().a(paramAbsListView);
    this.jdField_a_of_type_Sdc.a().h();
  }
  
  private void a(skb paramskb)
  {
    if ((paramskb == null) || (this.jdField_a_of_type_Skc == null)) {}
    while (!paramskb.a()) {
      return;
    }
    paramskb.a(this.jdField_a_of_type_Skc);
  }
  
  public static void b(View paramView)
  {
    if (paramView == null) {
      return;
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  private void b(sdg paramsdg1, sdg paramsdg2)
  {
    sdc localsdc = this.jdField_a_of_type_Sdc;
    if (paramsdg1 != paramsdg2)
    {
      if (((paramsdg1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo instanceof ArticleInfo)) && ((paramsdg2.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo instanceof ArticleInfo))) {
        pkm.a().a(b(), (ArticleInfo)paramsdg1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, (ArticleInfo)paramsdg2.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
      }
      this.jdField_a_of_type_ComTencentWidgetListView.clearFocus();
      this.jdField_a_of_type_ComTencentWidgetListView.postDelayed(new VideoHandler.5(this, paramsdg1, localsdc, paramsdg2), 100L);
    }
    while (localsdc.a() != 7) {
      return;
    }
    a(paramsdg1);
  }
  
  private boolean d()
  {
    if (!bkwm.a(c())) {}
    String str;
    do
    {
      do
      {
        do
        {
          return false;
        } while (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidContentContext));
        str = pay.a(this.jdField_a_of_type_Long);
      } while (pay.e.equals(str));
      if (pay.jdField_c_of_type_JavaLangString.equals(str)) {
        return true;
      }
    } while (!pay.d.equals(str));
    return rtp.a(this.jdField_a_of_type_AndroidContentContext);
  }
  
  private boolean e()
  {
    boolean bool2 = false;
    ArticleInfo localArticleInfo = a();
    boolean bool1 = bool2;
    if (a() == null)
    {
      bool1 = bool2;
      if (localArticleInfo != null)
      {
        bool1 = bool2;
        if (a(0) != null)
        {
          bool1 = bool2;
          if (localArticleInfo.mArticleID == a(0).mArticleID) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  private void t()
  {
    if (b() == 56)
    {
      rtr.a().a(true);
      rtr.a().a(0);
    }
    AppNetConnInfo.registerConnectionChangeReceiver(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Rsu);
    if ((a() instanceof ReadInJoyChannelActivity)) {
      this.c = a().getIntent().getBooleanExtra("is_need_show_animation_adapter", false);
    }
    if ((a() instanceof ReadInJoyChannelActivity)) {
      this.jdField_a_of_type_Boolean = a().getIntent().getBooleanExtra("is_need_show_animation_translate", false);
    }
    this.jdField_a_of_type_AndroidViewAnimationAnimationSet = ((AnimationSet)AnimationUtils.loadAnimation(this.jdField_a_of_type_AndroidContentContext, 2130772069));
    if (!rwv.c()) {
      this.jdField_a_of_type_AndroidViewAnimationAnimationSet.setDuration(400L);
    }
    this.jdField_a_of_type_Skc.a.add(this);
    ((ReadInJoyXListView)this.jdField_a_of_type_ComTencentWidgetListView).a(new rsz(this));
  }
  
  private void u()
  {
    if (!NetworkUtil.isWifiConnected(this.jdField_a_of_type_AndroidContentContext)) {}
    try
    {
      Object localObject = this.jdField_a_of_type_Sdc.a();
      long l = ((sdg)localObject).jdField_c_of_type_Long;
      localObject = a(((sdg)localObject).jdField_a_of_type_Int);
      if ((localObject != null) && (l != ((BaseArticleInfo)localObject).mArticleID))
      {
        this.jdField_a_of_type_Sdc.b(12);
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
  
  private void v()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a().findViewById(2131373647));
    if (pcl.c(b()))
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)a().findViewById(2131373646));
      return;
    }
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)a().findViewById(2131373645));
  }
  
  private void w()
  {
    this.jdField_a_of_type_Rtp = rtp.a();
    this.jdField_a_of_type_Rtp.a(this.jdField_a_of_type_Long);
    if (b() == 56)
    {
      ofe.jdField_a_of_type_Int = ofe.a(a().getIntent().getIntExtra("channel_from", -1));
      this.jdField_a_of_type_ComTencentWidgetListView.setContentBackground(new ColorDrawable(-1));
    }
    if (a().a().a() != null)
    {
      a().a(a().a().a(), this.jdField_a_of_type_Rtp);
      return;
    }
    l();
  }
  
  private void x()
  {
    boolean bool = a().getIntent().getBooleanExtra("is_need_show_animation_translate", false);
    ArticleInfo localArticleInfo = a().a();
    int i;
    if ((bool) && ((a() instanceof ReadInJoyChannelActivity)))
    {
      if (!this.h) {
        break label220;
      }
      i = pgb.a(localArticleInfo);
      if ((i != 6) && (i != 71)) {
        break label174;
      }
      this.jdField_b_of_type_Int = a().getIntent().getIntExtra("view_translation_animation_left", 0);
      this.jdField_a_of_type_Int = a().getIntent().getIntExtra("view_translation_animation_top", 0);
      ozy.a(a(), localArticleInfo, a(), (sls)a(), b(), this.jdField_b_of_type_Int, this.jdField_a_of_type_Int);
      a(this.jdField_a_of_type_Int);
    }
    for (;;)
    {
      this.jdField_a_of_type_Oau = new oau(a());
      a().a(this.jdField_a_of_type_Oau);
      ThreadManager.executeOnSubThread(new VideoHandler.8(this));
      return;
      label174:
      if (i == 28)
      {
        i = bkwm.e(pay.a());
        ozy.a(a(), localArticleInfo, a(), (sls)a(), b(), 0, i);
        a(i);
        continue;
        label220:
        i();
      }
    }
  }
  
  private void y()
  {
    ThreadManager.executeOnSubThread(new VideoHandler.11(this));
  }
  
  private void z()
  {
    boolean bool = a().a().a().getIntent().getBooleanExtra("READINJOY_VIDEO_FORCE_INSERT_FIRST_CREATED", false);
    if ((c()) && (!bool) && ((!bkwm.i()) || ((a().a().a() instanceof ReadInJoyNewFeedsActivity))))
    {
      s();
      A();
    }
    if (((!bkwm.i()) || ((a().a().a() instanceof ReadInJoyNewFeedsActivity))) && (b() == 56)) {
      ofe.jdField_a_of_type_Int = ofe.a(a().getIntent().getIntExtra("channel_from", -1));
    }
  }
  
  public int a()
  {
    return 0;
  }
  
  public long a()
  {
    long l = 0L;
    if (this.jdField_a_of_type_Sdc != null) {
      l = this.jdField_a_of_type_Sdc.a();
    }
    return l;
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = a(paramInt).intValue();
    Object localObject;
    soh localsoh;
    if ((paramView == null) || (!(paramView.getTag() instanceof skb)))
    {
      localObject = a(paramInt, paramView, paramViewGroup, i);
      paramView = ((skb)localObject).a(paramInt, paramViewGroup);
      ((skb)localObject).g = paramView;
      ((skb)localObject).jdField_a_of_type_Int = paramInt;
      paramView.setTag(localObject);
      paramView.setTag(2131369487, a());
      paramViewGroup = new pze(a(), a().a().a(), a(), a(), a().a(), a().a());
      paramView.setTag(2131380833, paramViewGroup);
      localsoh = new soh(paramView);
      paramView.setTag(2131380836, localsoh);
    }
    BaseArticleInfo localBaseArticleInfo;
    for (;;)
    {
      localBaseArticleInfo = a(paramInt);
      ((skb)localObject).a(a());
      if (localBaseArticleInfo != null) {
        break;
      }
      QLog.w("VideoHandler", 2, "article is null, return");
      return localsoh.a();
      localObject = (skb)paramView.getTag();
      ((skb)localObject).jdField_a_of_type_Int = paramInt;
      paramViewGroup = (pyq)paramView.getTag(2131380833);
      localsoh = (soh)paramView.getTag(2131380836);
    }
    long l;
    if (i == 46)
    {
      l = System.currentTimeMillis();
      a().a((sjx)localObject, localBaseArticleInfo);
      tpl.a("VideoHandler", String.valueOf(i), "getProteusNormalView.configTwoItemVideo", System.currentTimeMillis() - l);
    }
    for (;;)
    {
      localObject = null;
      if (paramInt < d() - 1) {
        localObject = (ArticleInfo)a(paramInt + 1);
      }
      localObject = new pwe(a(), (ArticleInfo)localBaseArticleInfo, i, b(), c(), paramInt, a(), d(), (ArticleInfo)localObject, a());
      paramView.setTag(2131380831, localObject);
      paramViewGroup.a(localsoh, (pvc)localObject, i);
      return localsoh.a();
      if (i == 4)
      {
        l = System.currentTimeMillis();
        a().a((sjy)localObject, localBaseArticleInfo, paramInt);
        tpl.a("VideoHandler", String.valueOf(i), "getProteusNormalView.configVideoItemUI", System.currentTimeMillis() - l);
        if ((a() != null) && (a().a() != null) && (AdvertisementInfo.isAdvertisementInfo(localBaseArticleInfo)))
        {
          localObject = (AdvertisementInfo)localBaseArticleInfo;
          a().a().a((AdvertisementInfo)localObject, a().a());
        }
      }
      else if (i == 70)
      {
        l = System.currentTimeMillis();
        a().a((skd)localObject, localBaseArticleInfo, paramInt);
        tpl.a("VideoHandler", String.valueOf(i), "getProteusNormalView.configWeishiGridTwoItemUI", System.currentTimeMillis() - l);
      }
      else if (i == 118)
      {
        a().a((sjw)localObject, localBaseArticleInfo, paramInt);
      }
      else if (i == 119)
      {
        a().a((sjy)localObject, localBaseArticleInfo, paramInt);
        localObject = (sjz)localObject;
        ((sjz)localObject).a(localBaseArticleInfo.mVideoColumnInfo);
        ((sjz)localObject).a(localBaseArticleInfo);
        ((sjz)localObject).f.setTag(localObject);
        ((sjz)localObject).l.setTag(localObject);
      }
      else if (i == 6)
      {
        a().a((sjv)localObject, localBaseArticleInfo, paramInt);
      }
      else if (i == 128)
      {
        a().a((sju)localObject, localBaseArticleInfo, paramInt);
      }
    }
  }
  
  public ArticleInfo a()
  {
    return a().a();
  }
  
  public VideoPreDownloadMgr a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr;
  }
  
  public Boolean a()
  {
    if ((a() != null) && (a().a() != null) && (a().a().a()))
    {
      a().a().j();
      return Boolean.valueOf(true);
    }
    return super.a();
  }
  
  public psk a()
  {
    return this.jdField_a_of_type_Psk;
  }
  
  public psk a(AbsListView paramAbsListView)
  {
    Object localObject;
    if ((!a().a()) || (this.jdField_a_of_type_Rtp == null) || (paramAbsListView.getChildCount() <= 0))
    {
      localObject = null;
      return localObject;
    }
    int i = 0;
    label30:
    if (i < paramAbsListView.getChildCount())
    {
      View localView = paramAbsListView.getChildAt(i);
      if ((localView.getTag() instanceof psk))
      {
        localObject = (psk)localView.getTag();
        if (!((psk)localObject).a(localView)) {}
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
      i += 1;
      break label30;
    }
  }
  
  public rtp a()
  {
    return this.jdField_a_of_type_Rtp;
  }
  
  public sdc a()
  {
    return this.jdField_a_of_type_Sdc;
  }
  
  public sdv a()
  {
    return this.jdField_a_of_type_Sdv;
  }
  
  public sig a()
  {
    return this.jdField_a_of_type_Sig;
  }
  
  public sjy a(String paramString)
  {
    int j = this.jdField_a_of_type_ComTencentWidgetListView.getFirstVisiblePosition();
    this.jdField_a_of_type_ComTencentWidgetListView.getLastVisiblePosition();
    int i = Math.max(this.jdField_a_of_type_ComTencentWidgetListView.getHeaderViewsCount(), j);
    int k;
    if (i < a().a().size() + this.jdField_a_of_type_ComTencentWidgetListView.getHeaderViewsCount())
    {
      k = i - this.jdField_a_of_type_ComTencentWidgetListView.getHeaderViewsCount();
      BaseArticleInfo localBaseArticleInfo = a(k);
      if ((4 == a(k).intValue()) && (localBaseArticleInfo != null) && (TextUtils.equals(localBaseArticleInfo.getInnerUniqueID(), paramString)))
      {
        int m = i - j;
        if ((m >= 0) && (m < this.jdField_a_of_type_ComTencentWidgetListView.getChildCount())) {
          paramString = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(i - j);
        }
      }
    }
    for (;;)
    {
      if (paramString != null)
      {
        return (sjy)paramString.getTag();
        if ((k >= 0) && (k < a().a().size())) {
          paramString = a(k, null, this.jdField_a_of_type_ComTencentWidgetListView);
        }
      }
      else
      {
        return null;
        i += 1;
        break;
        return null;
      }
      paramString = null;
    }
  }
  
  public skb a(int paramInt1, View paramView, ViewGroup paramViewGroup, int paramInt2)
  {
    paramView = a();
    switch (paramInt2)
    {
    default: 
      paramView = new sjy(paramView, this);
    }
    for (;;)
    {
      a(paramView);
      return paramView;
      paramView = new sjy(paramView, this);
      continue;
      paramView = new sjx(paramView, this);
      continue;
      paramView = new skd(paramView, this);
      continue;
      paramView = new sjw(paramView, this);
      continue;
      paramView = new sjz(paramView, this);
      continue;
      paramView = new sjv(paramView, this);
      continue;
      paramView = new sju(paramView, this);
    }
  }
  
  public void a(int paramInt, Intent paramIntent)
  {
    if (this.jdField_a_of_type_Sdc == null) {}
    long l1;
    int i;
    sdg localsdg;
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
        } while (b() == 0);
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video", 2, "onActivityResult for OPEN_FULLPLAY");
        }
        a().a().a(false);
        l1 = -1L;
        i = -1;
        if (paramIntent != null)
        {
          l1 = paramIntent.getLongExtra("VIDEO_PLAY_POSITION", -1L);
          i = paramIntent.getIntExtra("VIDEO_PLAY_STATUS", -1);
        }
        if ((!this.jdField_a_of_type_Sdc.d()) || (!this.jdField_a_of_type_Sdc.c())) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("Q.readinjoy.video", 2, "onActivityResult video is pause  && isPausedByMannul, just return");
      return;
      localsdg = this.jdField_a_of_type_Sdc.a();
      if (localsdg != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.readinjoy.video", 2, "onActivityResult getCurrentPlayVideoParam = null, just return");
    return;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramIntent != null)
    {
      localObject1 = localObject2;
      if (paramIntent.getExtras() != null) {
        localObject1 = paramIntent.getExtras().getString("VIDEO_ARTICLE_ID");
      }
    }
    if (!TextUtils.equals(localsdg.j, (CharSequence)localObject1))
    {
      paramIntent = b((String)localObject1);
      if (paramIntent == null)
      {
        l1 = localsdg.d;
        paramInt = 0;
      }
    }
    for (;;)
    {
      label239:
      boolean bool;
      if ((i == 3) || (i == 0) || (i == 4))
      {
        bool = true;
        label256:
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video", 2, "onActivityResult shouldContinuePlay = " + bool + ", playState=" + sdi.a(i) + ", startPosition=" + l1 + "，curPlayParam=" + localsdg);
        }
        if (!bool) {
          break label532;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video", 2, "onActivityResult continue play");
        }
        if (paramInt == 0) {
          break label444;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video", 2, "onActivityResult resume playResumeVideo:" + (String)localObject1);
        }
        a(paramIntent);
      }
      for (;;)
      {
        sek.a().a(false, "readinoy video continuePlay", 1);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.readinjoy.video", 2, "volumeControl set mute shouldContinuePlay");
        return;
        if (paramIntent.jdField_a_of_type_Sdg != null) {
          paramIntent.jdField_a_of_type_Sdg.d = l1;
        }
        paramInt = 1;
        break label239;
        bool = false;
        break label256;
        label444:
        if ((l1 >= 0L) && (localsdg != null))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.readinjoy.video", 2, "onActivityResult resume with position:" + l1);
          }
          this.jdField_a_of_type_Sdc.a((int)l1, localsdg);
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.readinjoy.video", 2, "onActivityResult resume");
          }
          this.jdField_a_of_type_Sdc.f(true);
        }
      }
      label532:
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "onActivityResult stop");
      }
      if (this.jdField_a_of_type_Psk == null) {
        break;
      }
      long l2 = this.jdField_a_of_type_Sdc.a();
      this.jdField_a_of_type_Sdc.b(4);
      paramIntent = this.jdField_a_of_type_Psk.a();
      if (l1 > 0L) {
        l2 = l1;
      }
      paramIntent.d = l2;
      if (l1 > 0L) {
        this.jdField_a_of_type_Psk.a().e = -1;
      }
      this.jdField_a_of_type_Psk = null;
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "onActivityResult for REFRESH_EVENT_CHECK_PLAYAREA");
      }
      u();
      b(this.jdField_a_of_type_ComTencentWidgetListView, 50);
      QLog.d("gifvideo.VideoHandler", 2, "check shortcontent play");
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
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (b() == 40677) {
      if ((paramInt == 0) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr != null)) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a(paramInt, paramBoolean);
      }
    }
    while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a(paramInt, paramBoolean);
  }
  
  public void a(View paramView1, View paramView2, BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    super.a(paramView1, paramView2, paramBaseArticleInfo, paramInt);
    a(paramView2, paramInt);
  }
  
  public void a(View paramView, ListView paramListView)
  {
    v();
    w();
    x();
    y();
  }
  
  public void a(View paramView, ListView paramListView, long paramLong)
  {
    this.jdField_a_of_type_Rsu = new rsu(this);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_Skc = new skc();
    this.f = bkwm.e();
    this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
    this.jdField_a_of_type_AndroidContentContext = a();
    this.jdField_a_of_type_Sig = new sig(a());
    t();
    this.jdField_a_of_type_Long = paramLong;
    this.h = rwv.c();
  }
  
  public void a(ReadInJoyBaseListView paramReadInJoyBaseListView)
  {
    super.e();
    if ((a().a()) && (this.jdField_a_of_type_Rtp != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "onDrawFinish checkplayable!");
      }
      if (this.jdField_a_of_type_Rtp.b()) {
        this.jdField_a_of_type_Skc.postDelayed(new VideoHandler.7(this), 1200L);
      }
    }
    else
    {
      return;
    }
    b(this.jdField_a_of_type_ComTencentWidgetListView, slt.jdField_b_of_type_Int);
  }
  
  public void a(psk parampsk)
  {
    this.jdField_a_of_type_Sdc.b(2);
    this.jdField_a_of_type_Psk = parampsk;
    a().a().a(this.jdField_a_of_type_Psk);
    this.jdField_a_of_type_Sdc.a(parampsk.a());
  }
  
  public void a(sdc paramsdc, rtp paramrtp)
  {
    this.jdField_a_of_type_Sdc = paramsdc;
    this.jdField_a_of_type_Rtp = paramrtp;
    if (rtp.a(BaseApplicationImpl.getContext())) {
      this.jdField_a_of_type_Rtp.b(true);
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Sdc != null) && (!a().e()))
      {
        l();
        this.jdField_a_of_type_Sdc.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr);
        this.jdField_a_of_type_Sdc.a(this.jdField_a_of_type_Rtp);
        if (bkwm.a(c())) {
          this.jdField_a_of_type_Sdc.a(0);
        }
      }
      return;
      this.jdField_a_of_type_Rtp.b(false);
    }
  }
  
  public void a(sdg paramsdg)
  {
    this.jdField_a_of_type_Skc.postDelayed(new VideoHandler.6(this, paramsdg), 1000L);
  }
  
  public void a(sdg paramsdg, int paramInt)
  {
    if (this.jdField_a_of_type_Psk != null) {}
    for (;;)
    {
      return;
      sjy localsjy = a(paramsdg.j);
      if (localsjy != null)
      {
        this.jdField_a_of_type_Psk = localsjy;
        paramsdg.jdField_a_of_type_AndroidViewView = localsjy.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
      }
      while ((this.jdField_a_of_type_Sdc != null) && (this.jdField_a_of_type_Sdc.a() != null))
      {
        paramsdg = this.jdField_a_of_type_Sdc.a();
        if (QLog.isColorLevel()) {
          QLog.i("VideoHandler", 2, "notifyVideoPositionChanged:");
        }
        paramsdg.g();
        return;
        if (QLog.isColorLevel()) {
          QLog.e("VideoHandler", 2, "fixNowPlayHolder failed videoPlayParam:" + paramsdg + "    callSource:" + paramInt);
        }
      }
    }
  }
  
  public void a(sdg paramsdg, BaseArticleInfo paramBaseArticleInfo)
  {
    phy.a(paramsdg, paramBaseArticleInfo, a());
  }
  
  public void a(sdg paramsdg1, sdg paramsdg2)
  {
    ReadInJoyBaseListViewGroup localReadInJoyBaseListViewGroup = a();
    if ((localReadInJoyBaseListViewGroup instanceof ReadInJoyListViewGroup)) {
      ((ReadInJoyListViewGroup)localReadInJoyBaseListViewGroup).a(paramsdg1, paramsdg2);
    }
    if (this.jdField_a_of_type_Long == 1002L)
    {
      int i = AIOUtils.dp2px(44.5F, a().getResources());
      int j = a().getResources().getDimensionPixelOffset(2131298772);
      a().setPadding(0, i + j, 0, 0);
    }
    b(paramsdg1, paramsdg2);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    s();
  }
  
  public boolean a(int paramInt)
  {
    return (paramInt == 4) || (paramInt == 46) || (paramInt == 70) || (paramInt == 118) || (paramInt == 119) || (paramInt == 6) || (paramInt == 128);
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    return (pay.a(a(paramInt1))) && (b() == 56) && (this.f) && (paramInt2 == 4);
  }
  
  public sjy b(String paramString)
  {
    Object localObject2 = null;
    int j = this.jdField_a_of_type_ComTencentWidgetListView.getFirstVisiblePosition();
    int k = this.jdField_a_of_type_ComTencentWidgetListView.getLastVisiblePosition();
    int i = Math.max(this.jdField_a_of_type_ComTencentWidgetListView.getHeaderViewsCount(), j);
    for (;;)
    {
      Object localObject1 = localObject2;
      if (i <= k)
      {
        int m = i - this.jdField_a_of_type_ComTencentWidgetListView.getHeaderViewsCount();
        localObject1 = a(m);
        if ((localObject1 == null) || (4 != a(m).intValue()) || (!TextUtils.equals(((BaseArticleInfo)localObject1).innerUniqueID, paramString))) {
          break label122;
        }
        paramString = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(i - j);
        localObject1 = localObject2;
        if (paramString != null) {
          localObject1 = (sjy)paramString.getTag();
        }
      }
      return localObject1;
      label122:
      i += 1;
    }
  }
  
  public void b()
  {
    super.b();
    this.g = true;
    m();
    z();
    B();
    ThreadManager.getUIHandler().postDelayed(new VideoHandler.1(this), 50L);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new VideoHandler.2(this), 1000L);
  }
  
  public void b(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a(paramInt, paramBoolean);
    }
  }
  
  public void b(AbsListView paramAbsListView, int paramInt)
  {
    Object localObject = a(paramAbsListView);
    if (b() == 40677) {}
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
          } while (((this.jdField_a_of_type_Sdc != null) && (this.jdField_a_of_type_Sdc.h())) || (tvi.a.a() == tuz.a.b()) || (tvi.a.a() == tuz.a.c()));
          if (localObject == null) {
            break;
          }
          localObject = ((psk)localObject).a();
        } while ((localObject != null) && (((sdg)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null) && (((sdg)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.patchStatus.a.get() == 1));
      } while ((this.jdField_a_of_type_Sdc == null) || (!this.jdField_a_of_type_Rtp.a()) || (this.jdField_a_of_type_Rtp.b()) || (paramAbsListView == null) || (paramAbsListView.getVisibility() != 0));
      this.jdField_a_of_type_Skc.removeMessages(1001);
      this.jdField_a_of_type_Skc.sendEmptyMessageDelayed(1001, paramInt);
    } while (!QLog.isColorLevel());
    QLog.d("Q.readinjoy.video", 2, "checkPlayableArea delay: " + paramInt);
  }
  
  public boolean b()
  {
    return this.g;
  }
  
  public void c()
  {
    super.c();
    this.g = false;
    p();
    a().d();
    prq.b(this.jdField_a_of_type_ComTencentWidgetListView);
  }
  
  public void c(AbsListView paramAbsListView, int paramInt)
  {
    if ((b() == 0) || (b() == 40677)) {}
    do
    {
      do
      {
        return;
      } while ((!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidContentContext)) || (this.jdField_a_of_type_Sdc == null) || (paramAbsListView == null));
      this.jdField_a_of_type_Skc.removeMessages(1001);
      this.jdField_a_of_type_Skc.sendEmptyMessageDelayed(1001, paramInt);
    } while (!QLog.isColorLevel());
    QLog.d("Q.readinjoy.video", 2, "force checkPlayableArea delay: " + paramInt);
  }
  
  public boolean c()
  {
    return a().a();
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Skc != null)
    {
      this.jdField_a_of_type_Skc.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_Skc.a.clear();
    }
    if (this.jdField_a_of_type_Oau != null) {
      this.jdField_a_of_type_Oau.a();
    }
  }
  
  public void e()
  {
    super.e();
    QQAppInterface localQQAppInterface = pay.a();
    if ((localQQAppInterface != null) && (!e))
    {
      e = true;
      ((aupc)localQQAppInterface.getManager(306)).a();
    }
  }
  
  public void f()
  {
    if (a() != null) {
      prq.a((ListView)a(), true);
    }
  }
  
  public void g()
  {
    super.g();
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "notifyDataSetChanged");
    }
    sdg localsdg;
    int i;
    if (this.jdField_a_of_type_Sdc != null)
    {
      localsdg = this.jdField_a_of_type_Sdc.a();
      if (((this.jdField_a_of_type_Psk != null) || (localsdg != null)) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr != null))
      {
        int j = -1;
        i = j;
        if (this.jdField_a_of_type_Psk != null)
        {
          i = j;
          if (this.jdField_a_of_type_Psk.a() != null) {
            i = this.jdField_a_of_type_Psk.a().jdField_a_of_type_Int;
          }
        }
        if (localsdg == null) {
          break label115;
        }
        i = localsdg.jdField_a_of_type_Int;
      }
    }
    label115:
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a(i, true);
      return;
      localsdg = null;
      break;
    }
  }
  
  public void h()
  {
    ReadInJoyBaseListViewGroup localReadInJoyBaseListViewGroup = a();
    if ((localReadInJoyBaseListViewGroup instanceof ReadInJoyListViewGroup)) {
      ((ReadInJoyListViewGroup)localReadInJoyBaseListViewGroup).p();
    }
    if (this.jdField_a_of_type_Long == 1002L) {
      a().setPadding(0, 0, 0, 0);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return false;
      this.jdField_a_of_type_ComTencentWidgetListView.getGlobalVisibleRect(this.jdField_a_of_type_AndroidGraphicsRect);
    } while (!twr.a(this.jdField_a_of_type_AndroidGraphicsRect));
    if (this.jdField_a_of_type_Boolean) {
      if (this.jdField_b_of_type_Boolean) {
        a(this.jdField_a_of_type_ComTencentWidgetListView);
      }
    }
    for (;;)
    {
      return true;
      if (QLog.isColorLevel())
      {
        QLog.w("VideoHandler", 2, "MSG_FOR_CHECK_PLAYAREA, 平移转场动画未做完，不触发自动播放");
        continue;
        a(this.jdField_a_of_type_ComTencentWidgetListView);
      }
    }
  }
  
  public void i()
  {
    this.jdField_b_of_type_Boolean = true;
    if ((this.jdField_a_of_type_Sdc != null) && ((e()) || (this.jdField_a_of_type_Rtp.a())) && (!this.jdField_a_of_type_Rtp.b()) && (this.jdField_a_of_type_ComTencentWidgetListView != null) && (this.jdField_a_of_type_ComTencentWidgetListView.getVisibility() == 0))
    {
      this.jdField_a_of_type_Skc.removeMessages(1001);
      this.jdField_a_of_type_Skc.sendEmptyMessage(1001);
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "checkPlayableArea after transAnim: ");
      }
    }
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_Rtp != null) {
      this.jdField_a_of_type_Rtp.a(false);
    }
  }
  
  public void k()
  {
    if (this.jdField_a_of_type_Sdc != null) {
      this.jdField_a_of_type_Sdc.a(new psh(this));
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("VideoHandler", 2, "mVideoPlayManager == null");
  }
  
  public void l()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr = new VideoPreDownloadMgr(BaseApplicationImpl.getContext());
    VideoPreDownloadMgr localVideoPreDownloadMgr = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr;
    if (b() == 56) {}
    for (int i = sdt.jdField_b_of_type_Int;; i = sdt.jdField_a_of_type_Int)
    {
      localVideoPreDownloadMgr.a = new sdt(i, sdt.f);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a(new psi(this));
      return;
    }
  }
  
  public void m()
  {
    if ((a().a().f()) && (this.jdField_a_of_type_ComTencentWidgetListView != null))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.b();
      int j = this.jdField_a_of_type_ComTencentWidgetListView.getFirstVisiblePosition();
      int i = j;
      if (j >= d()) {
        i = 0;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a(i);
      a().a().b(false);
    }
  }
  
  public void n()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr = null;
    }
  }
  
  public void o()
  {
    this.jdField_a_of_type_Sdc.b(9);
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Skc != null) {
      this.jdField_a_of_type_Skc.removeMessages(1001);
    }
  }
  
  public void p()
  {
    if (this.jdField_a_of_type_Sdc != null) {
      this.jdField_a_of_type_Sdc.b();
    }
  }
  
  public void q()
  {
    this.jdField_a_of_type_Skc.removeMessages(1001);
  }
  
  public void r()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoHandler", 2, "clearData " + this.jdField_a_of_type_Rsu);
    }
    if (this.jdField_a_of_type_Sig != null) {
      this.jdField_a_of_type_Sig.a();
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_Rsu);
  }
  
  public void s()
  {
    sdc localsdc = a().a().a();
    if ((localsdc != null) && (localsdc.a() != null)) {
      localsdc.b(11);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     psf
 * JD-Core Version:    0.7.0.1
 */