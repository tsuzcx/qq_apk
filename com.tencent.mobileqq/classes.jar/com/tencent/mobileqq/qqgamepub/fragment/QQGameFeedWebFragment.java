package com.tencent.mobileqq.qqgamepub.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.ark.multiproc.ArkMultiProcUtil;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qqgamepub.api.IQQGameConfigUtil;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHelper;
import com.tencent.mobileqq.qqgamepub.data.GamePubAccountConstant;
import com.tencent.mobileqq.qqgamepub.data.GmpEnterInfoRsp;
import com.tencent.mobileqq.qqgamepub.data.QQGameMsgInfo;
import com.tencent.mobileqq.qqgamepub.listener.IPageListener;
import com.tencent.mobileqq.qqgamepub.mvp.model.bean.QQGameWebFeedModel;
import com.tencent.mobileqq.qqgamepub.mvp.presenter.buisness.QQGameWebPresenter;
import com.tencent.mobileqq.qqgamepub.mvp.view.buisness.IQQGameWebFeedView;
import com.tencent.mobileqq.qqgamepub.utils.GamePubAccountHelper;
import com.tencent.mobileqq.qqgamepub.utils.UIUtils;
import com.tencent.mobileqq.qqgamepub.view.IHeaderView;
import com.tencent.mobileqq.qqgamepub.view.NavBarQQGamePub;
import com.tencent.mobileqq.qqgamepub.view.QQGamePubViewpager;
import com.tencent.mobileqq.qqgamepub.web.GameWebCostLogic;
import com.tencent.mobileqq.qqgamepub.web.QQGameReportLogic;
import com.tencent.mobileqq.qqgamepub.web.UnReadMsgLogic;
import com.tencent.mobileqq.qqgamepub.web.WebHeadPageAdapter;
import com.tencent.mobileqq.qqgamepub.web.delegate.GameContentViewDelegate;
import com.tencent.mobileqq.qqgamepub.web.delegate.QQGameWebViewDelegate;
import com.tencent.mobileqq.qqgamepub.web.delegate.QQGameWebViewDelegate.QQGameWebViewCallBack;
import com.tencent.mobileqq.qqgamepub.web.view.QQGameHeadLayout;
import com.tencent.mobileqq.qqgamepub.web.view.QQGameIndicator2;
import com.tencent.mobileqq.qqgamepub.web.view.QQGamePubWebView.HeadViewVisibleListener;
import com.tencent.mobileqq.qqgamepub.web.view.UnreadTipLayout;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.PathResult;
import com.tencent.mobileqq.qwallet.preload.IPreloadServiceProxy;
import com.tencent.mobileqq.qwallet.preload.PreloadStaticApi;
import com.tencent.mobileqq.qwallet.preload.ResourceInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.smtt.sdk.WebView;
import com.tencent.widget.immersive.ImmersiveUtils;
import eipc.EIPCResult;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class QQGameFeedWebFragment
  extends QPublicBaseFragment
  implements View.OnClickListener, IPageListener, IQQGameWebFeedView, QQGameWebViewDelegate.QQGameWebViewCallBack, QQGamePubWebView.HeadViewVisibleListener
{
  public QQGameWebPresenter a = h();
  public QQGameWebViewDelegate b;
  public GameContentViewDelegate c;
  public TextView d;
  public LinearLayout e;
  public ImageView f;
  public ImageView g;
  public NavBarQQGamePub h;
  private View i;
  private LinearLayout j;
  private RelativeLayout k;
  private QQGameIndicator2 l;
  private UnreadTipLayout m;
  private QQGamePubViewpager n;
  private GestureDetector o;
  private TextView p;
  private RelativeLayout q;
  private ImageView r;
  
  static
  {
    ArkMultiProcUtil.a(true);
    ArkMultiProcUtil.a();
    GamePubAccountHelper.e("1");
  }
  
  private void a(int paramInt, IPreloadService.PathResult paramPathResult, View paramView)
  {
    ThreadManagerV2.getUIHandlerV2().post(new QQGameFeedWebFragment.4(this, paramInt, paramPathResult, paramView));
  }
  
  private void a(IPreloadServiceProxy paramIPreloadServiceProxy)
  {
    paramIPreloadServiceProxy.getResPath("https://i.gtimg.cn/channel/imglib/202003/upload_0408e905d4fe21d5749b1902145804d9.png", new QQGameFeedWebFragment.2(this));
  }
  
  private void a(IPreloadServiceProxy paramIPreloadServiceProxy, View paramView)
  {
    paramIPreloadServiceProxy.getResPath("https://i.gtimg.cn/channel/imglib/202003/upload_0408e905d4fe21d5749b1902145804d9.png", new QQGameFeedWebFragment.3(this, paramView));
  }
  
  private void b(View paramView)
  {
    this.b = new QQGameWebViewDelegate(i(), paramView);
    this.b.a(this);
    this.c = new GameContentViewDelegate(i(), paramView);
  }
  
  private void c(View paramView)
  {
    this.k = ((RelativeLayout)paramView.findViewById(2131436980));
    this.n = ((QQGamePubViewpager)this.b.a().findViewById(2131433081));
    this.l = ((QQGameIndicator2)this.b.a().findViewById(2131439795));
    this.d = ((TextView)paramView.findViewById(2131448849));
    this.e = ((LinearLayout)paramView.findViewById(2131437016));
    this.g = ((ImageView)paramView.findViewById(2131435614));
    this.m = ((UnreadTipLayout)this.b.a().findViewById(2131436875));
    i().a(this.n, getContext());
    this.n.setOffscreenPageLimit(5);
    this.l.setViewPager(this.n);
    this.l.a();
    this.l.setPageListener(this);
    this.f = ((ImageView)paramView.findViewById(2131444971));
    this.f.setImageDrawable(GamePubAccountConstant.a(null, null, "https://i.gtimg.cn/channel/imglib/202004/upload_a0fdb03e7c5c42246be0bf79cce9958f.png", "https://i.gtimg.cn/channel/imglib/202004/upload_a0fdb03e7c5c42246be0bf79cce9958f.png"));
    this.f.setOnClickListener(this);
    this.f.setVisibility(8);
    paramView = (ImageView)paramView.findViewById(2131434896);
    paramView.setVisibility(0);
    paramView.setScaleType(ImageView.ScaleType.FIT_XY);
    paramView.setImageResource(2130847954);
    q();
  }
  
  private void d(View paramView)
  {
    Object localObject = new DisplayMetrics();
    l().getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
    int i1 = ((DisplayMetrics)localObject).heightPixels;
    this.j = ((LinearLayout)paramView.findViewById(2131437612));
    int i2 = UIUtils.a(418.0F, MobileQQ.getContext().getResources());
    localObject = this.j.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = UIUtils.a(i1 - i2, MobileQQ.getContext().getResources());
    this.j.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (IPreloadServiceProxy)MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IPreloadServiceProxy.class, "multi");
    if (TextUtils.isEmpty(PreloadStaticApi.b("https://i.gtimg.cn/channel/imglib/202003/upload_0408e905d4fe21d5749b1902145804d9.png", false, 0).filePath))
    {
      r();
      a((IPreloadServiceProxy)localObject);
      return;
    }
    a((IPreloadServiceProxy)localObject, paramView);
  }
  
  private void e(View paramView)
  {
    this.q = ((RelativeLayout)paramView.findViewById(2131439235));
    this.r = ((ImageView)paramView.findViewById(2131439234));
    this.q.setBackgroundColor(-1);
    this.r.setImageDrawable(URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/gameCenter/gameCenter_newMsg_normal@2x.png"));
    this.q.setOnClickListener(this);
  }
  
  private void n()
  {
    this.c.b();
  }
  
  private void o()
  {
    this.q.setVisibility(8);
    Object localObject = this.n;
    if (localObject != null) {
      ((QQGamePubViewpager)localObject).setCurrentItem(0);
    }
    localObject = (String)this.r.getTag();
    i().r().a((String)localObject);
  }
  
  private void p()
  {
    Object localObject3 = i().H();
    Object localObject1 = "";
    Object localObject2;
    if (localObject3 != null)
    {
      localObject2 = ((QQGameMsgInfo)localObject3).gameAppId;
      if (!TextUtils.isEmpty(((QQGameMsgInfo)localObject3).paMsgid)) {
        localObject1 = ((QQGameMsgInfo)localObject3).paMsgid;
      }
    }
    else
    {
      localObject3 = "";
      localObject2 = localObject1;
      localObject1 = localObject3;
    }
    i().r().b((String)localObject2, (String)localObject1);
    localObject1 = ((IQQGameConfigUtil)QRoute.api(IQQGameConfigUtil.class)).getGamePubUrl();
    ((IQQGameHelper)QRoute.api(IQQGameHelper.class)).enterGameCenter((String)localObject1);
  }
  
  private void q()
  {
    int i1 = i().q().d();
    if (i1 > 1)
    {
      this.f.setVisibility(8);
      this.m.setVisibility(0);
      this.m.setUnreadNum(i1 - 1);
      this.m.setOnClickListener(this);
      this.m.post(new QQGameFeedWebFragment.1(this));
      i().r().b();
    }
  }
  
  private void r()
  {
    this.j.removeAllViews();
    TextView localTextView = new TextView(l());
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.leftMargin = UIUtils.a(7.0F, MobileQQ.getContext().getResources());
    localTextView.setText(HardCodeUtil.a(2131892943));
    localTextView.setTextColor(2130706432);
    ImageView localImageView = new ImageView(l());
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = l().getResources().getDrawable(2130849062);
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = l().getResources().getDrawable(2130849062);
    localImageView.setImageDrawable(URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/gameCenter/gameCenter_refresh_small_gray@2x.png", (URLDrawable.URLDrawableOptions)localObject));
    localImageView.setVisibility(0);
    localObject = new RotateAnimation(0.0F, 359.0F, 1, 0.5F, 1, 0.5F);
    ((Animation)localObject).setRepeatCount(-1);
    ((Animation)localObject).setDuration(1000L);
    localImageView.startAnimation((Animation)localObject);
    localObject = new LinearLayout.LayoutParams(UIUtils.a(15.0F, MobileQQ.getContext().getResources()), UIUtils.a(15.0F, MobileQQ.getContext().getResources()));
    this.j.addView(localImageView, (ViewGroup.LayoutParams)localObject);
    this.j.addView(localTextView, localLayoutParams);
  }
  
  private void s()
  {
    this.b.d();
    this.c.a();
  }
  
  private boolean t()
  {
    return (l() != null) && (!l().isFinishing()) && (isAdded());
  }
  
  public void a()
  {
    NavBarQQGamePub localNavBarQQGamePub = this.h;
    if (localNavBarQQGamePub != null) {
      localNavBarQQGamePub.a();
    }
  }
  
  public void a(int paramInt)
  {
    i().a(paramInt, getQBaseActivity());
  }
  
  public void a(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    IHeaderView localIHeaderView = ((QQGameWebFeedModel)i().b()).h();
    if (paramInt1 < UIUtils.a(g(), MobileQQ.sMobileQQ.getResources()))
    {
      if (localIHeaderView != null) {
        localIHeaderView.a();
      }
    }
    else if (localIHeaderView != null) {
      localIHeaderView.b();
    }
  }
  
  public void a(View paramView)
  {
    this.h = ((NavBarQQGamePub)paramView.findViewById(2131444897));
    this.h.setGamePubType("1");
    this.c.a(this.h.getRightImg());
    paramView = new LinearLayout.LayoutParams(-1, (int)getResources().getDimension(2131299920));
    int i1 = ImmersiveUtils.getStatusBarHeight(MobileQQ.sMobileQQ.getApplicationContext());
    paramView.setMargins(0, i1, 0, 0);
    this.h.setLayoutParams(paramView);
    paramView = new StringBuilder();
    paramView.append("statusBarHeight = ");
    paramView.append(i1);
    QLog.d("QQGamePub_GameWebPage", 4, paramView.toString());
    paramView = (ImageView)this.h.findViewById(2131436666);
    this.h.setRightImage(getResources().getDrawable(2130850222), getResources().getDrawable(2130850058));
    paramView.setImageResource(2130853298);
    this.h.setBackgroundResource(2130847958);
    this.p = this.h.getTitleTextView();
    this.p.setText(2131892960);
    this.p.setTextColor(-1);
    this.h.setOnItemSelectListener(new QQGameFeedWebFragment.5(this));
    e();
  }
  
  public void a(GmpEnterInfoRsp paramGmpEnterInfoRsp, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("rec game enter isSucc:");
      localStringBuilder.append(paramBoolean);
      QLog.d("QQGamePub_GameWebPage", 1, localStringBuilder.toString());
    }
    if (!t()) {
      return;
    }
    if (paramBoolean)
    {
      if (this.h == null) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQGamePub_GameWebPage", 1, "show game enter icon");
      }
      this.h.setCurType(1);
      this.h.a(false);
      this.h.a(paramGmpEnterInfoRsp.icon, paramGmpEnterInfoRsp.content, paramGmpEnterInfoRsp.url);
      this.h.setmBubbleid(paramGmpEnterInfoRsp.bubbleId);
      GamePubAccountHelper.a(paramGmpEnterInfoRsp);
      i().r().a(paramGmpEnterInfoRsp.bubbleId, false);
      return;
    }
    ((IQQGameHelper)QRoute.api(IQQGameHelper.class)).showGameEnterCacheInfo(this.h, paramGmpEnterInfoRsp);
    i().r().a(paramGmpEnterInfoRsp.bubbleId, true);
  }
  
  public void a(WebView paramWebView, String paramString)
  {
    this.j.setVisibility(8);
    i().D();
  }
  
  public void a(WebView paramWebView, String paramString, Bitmap paramBitmap) {}
  
  public void a(EIPCResult paramEIPCResult)
  {
    j().e();
    if (!t())
    {
      QLog.e("QQGamePub_GameWebPage", 4, "QQGameFeedWebFragment Activity is null");
      return;
    }
    ((QQGameWebFeedModel)i().b()).a(paramEIPCResult);
    i().E();
    if (((QQGameWebFeedModel)i().b()).i() > 0)
    {
      ((QQGameWebFeedModel)i().b()).a(getQBaseActivity());
      this.n.setAdapter(i().k());
      this.l.a();
      int i1 = ((QQGameWebFeedModel)i().b()).f();
      c(i1);
      i().c(i1);
      i().F();
      return;
    }
    this.n.setAdapter(i().k());
    this.j.setVisibility(8);
  }
  
  public void a(String paramString)
  {
    RelativeLayout localRelativeLayout = this.q;
    if (localRelativeLayout != null) {
      localRelativeLayout.setTag(paramString);
    }
  }
  
  public void a(Map<String, Object> paramMap)
  {
    QQGameWebViewDelegate localQQGameWebViewDelegate = this.b;
    if (localQQGameWebViewDelegate != null) {
      localQQGameWebViewDelegate.a(paramMap);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (!paramBoolean)
    {
      this.m.setVisibility(8);
      this.e.setVisibility(8);
      this.l.setVisibility(0);
      i().q().b();
      return;
    }
    this.f.setVisibility(8);
    this.m.setVisibility(0);
    this.m.setUnreadNum(paramInt);
  }
  
  public void b()
  {
    RelativeLayout localRelativeLayout = this.q;
    if (localRelativeLayout != null) {
      localRelativeLayout.setVisibility(8);
    }
  }
  
  public void b(int paramInt)
  {
    UnReadMsgLogic localUnReadMsgLogic = i().q();
    if (localUnReadMsgLogic.f())
    {
      if (localUnReadMsgLogic.c(paramInt))
      {
        localUnReadMsgLogic.a(1);
        localUnReadMsgLogic.c();
        if (localUnReadMsgLogic.e())
        {
          a(true, localUnReadMsgLogic.d());
          return;
        }
        a(false, 0);
      }
    }
    else {
      a(false, 0);
    }
  }
  
  public void c()
  {
    if (this.n != null)
    {
      int i1 = i().q().d();
      int i2 = ((QQGameWebFeedModel)i().b()).i();
      if (i1 >= 3)
      {
        this.n.setCurrentItem(i().l());
        return;
      }
      int i3 = this.n.getCurrentItem();
      int i4 = i3 + 1;
      if (i4 < i2) {
        this.n.setCurrentItem(i4);
      } else if (i3 == i2 - 1) {
        this.n.setCurrentItem(i2);
      }
      if (i1 == 0)
      {
        this.l.setVisibility(0);
        this.m.setVisibility(4);
        this.l.b();
      }
    }
    i().r().a();
  }
  
  public void c(int paramInt)
  {
    Object localObject = i().k();
    if (i().k() != null)
    {
      ((WebHeadPageAdapter)localObject).a(i().A());
      this.l.a();
      if (paramInt > 0) {
        ((QQGameWebFeedModel)i().b()).c();
      }
      if (t())
      {
        localObject = this.n;
        if ((localObject != null) && (paramInt > 0)) {
          ((QQGamePubViewpager)localObject).setCurrentItem(paramInt);
        }
      }
    }
  }
  
  public void d()
  {
    this.b.a(getQBaseActivity(), j(), this);
  }
  
  public void d(int paramInt)
  {
    QQGamePubViewpager localQQGamePubViewpager = this.n;
    if (localQQGamePubViewpager != null) {
      localQQGamePubViewpager.setCurrentItem(paramInt);
    }
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public void e()
  {
    this.o = new GestureDetector(l(), new QQGameFeedWebFragment.6(this));
    this.p.setOnTouchListener(new QQGameFeedWebFragment.7(this));
  }
  
  public void f()
  {
    ThreadManagerV2.getUIHandlerV2().post(new QQGameFeedWebFragment.8(this));
  }
  
  public int g()
  {
    try
    {
      int i1 = this.c.c();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("gameContentHeight=");
        localStringBuilder1.append(i1);
        QLog.d("QQGamePub_GameWebPage", 1, localStringBuilder1.toString());
      }
      if (t())
      {
        float f1 = UIUtils.a(this.k.getMeasuredHeight() + i1, MobileQQ.getContext().getResources());
        return (int)f1;
      }
      return 417;
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("getWebPading faile:");
      localStringBuilder2.append(localThrowable.getMessage());
      QLog.d("QQGamePub_GameWebPage", 1, localStringBuilder2.toString());
    }
    return 417;
  }
  
  public QQGameWebPresenter h()
  {
    return new QQGameWebPresenter();
  }
  
  public QQGameWebPresenter i()
  {
    if (this.a == null) {
      this.a = h();
    }
    return this.a;
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public GameWebCostLogic j()
  {
    return i().p();
  }
  
  public int k()
  {
    QQGamePubViewpager localQQGamePubViewpager = this.n;
    if (localQQGamePubViewpager != null) {
      return localQQGamePubViewpager.getCurrentItem();
    }
    return -1;
  }
  
  public QBaseActivity l()
  {
    return getQBaseActivity();
  }
  
  public void onAttach(@NonNull Context paramContext)
  {
    super.onAttach(paramContext);
    this.a.a(this);
  }
  
  public boolean onBackEvent()
  {
    j().i();
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 == 2131439235) {
      p();
    } else if (i1 == 2131444971) {
      o();
    } else if (i1 == 2131436875) {
      c();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    GamePubAccountConstant.a = true;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    j().a();
    i().a(getQBaseActivity());
    i().r().a(i().q().d());
    this.i = paramLayoutInflater.inflate(2131624898, paramViewGroup, false);
    b(this.i);
    i().b(getQBaseActivity());
    i().t();
    c(this.i);
    i().u();
    n();
    i().B();
    i().s();
    j().f();
    d();
    e(this.i);
    a(this.i);
    d(this.i);
    i().w();
    paramLayoutInflater = this.i;
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    try
    {
      s();
      i().v();
      this.c.a();
      this.a.d();
      return;
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDestroy err:");
      localStringBuilder.append(localThrowable.getMessage());
      QLog.e("QQGamePub_GameWebPage", 4, localStringBuilder.toString());
    }
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    i().C();
  }
  
  public void onDetach()
  {
    super.onDetach();
  }
  
  public void onPause()
  {
    super.onPause();
    this.b.b();
    IHeaderView localIHeaderView = ((QQGameWebFeedModel)i().b()).h();
    if (localIHeaderView != null) {
      localIHeaderView.b();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    this.b.c();
    IHeaderView localIHeaderView = ((QQGameWebFeedModel)i().b()).h();
    if (localIHeaderView != null) {
      localIHeaderView.a();
    }
    try
    {
      int i1 = ((QQGameWebFeedModel)i().b()).i();
      if ((this.n != null) && (i1 > 0) && (this.n.getCurrentItem() == i1)) {
        this.n.setCurrentItem(i1 - 1);
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    this.c.d();
  }
  
  public void onStart()
  {
    super.onStart();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.fragment.QQGameFeedWebFragment
 * JD-Core Version:    0.7.0.1
 */