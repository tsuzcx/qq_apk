package com.tencent.mobileqq.vas.qvip.fragment;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.apollo.game.api.ICmGameHelper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.applets.PublicAccountEventReport;
import com.tencent.mobileqq.ark.multiproc.ArkMultiProcUtil;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.gamecenter.view.ArkHeaderView;
import com.tencent.mobileqq.qqgamepub.view.QQGamePubViewpager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.utils.IArkPubicEventWrap;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.vas.config.business.qvip.QVipPubAccountConfig;
import com.tencent.mobileqq.vas.qvip.QQVipMsgInfo;
import com.tencent.mobileqq.vas.qvip.util.QQVipHelper;
import com.tencent.mobileqq.vas.qvip.view.IHeaderView;
import com.tencent.mobileqq.vas.qvip.view.QQVipHeadLayout;
import com.tencent.mobileqq.vas.qvip.view.QQVipIndicator;
import com.tencent.mobileqq.vas.qvip.view.QQVipIndicator.IPageListener;
import com.tencent.mobileqq.vas.qvip.view.QQVipPubNavBar;
import com.tencent.mobileqq.vas.qvip.view.QQVipWebview;
import com.tencent.mobileqq.vas.qvip.web.QQVipWebViewBuilder;
import com.tencent.mobileqq.webview.WebViewDirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import cooperation.qzone.mobilereport.MobileReportManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QQVipFeedWedFragment
  extends PublicBaseFragment
  implements View.OnClickListener, QQVipIndicator.IPageListener
{
  private int A = 0;
  public QQVipPubNavBar a;
  List<IHeaderView> b = new ArrayList();
  private View c;
  private TextView d;
  private QQVipHeadLayout e;
  private QQVipWebview f;
  private QQVipWebViewBuilder g;
  private QQGamePubViewpager h;
  private QQVipIndicator i;
  private QQVipFeedWedFragment.HeadPageAdapter j;
  private RelativeLayout k;
  private RelativeLayout l;
  private RelativeLayout m;
  private Button n;
  private Button o;
  private View p;
  private View q;
  private LinearLayout r;
  private long s;
  private long t;
  private long u;
  private long v;
  private long w;
  private List<String> x = new ArrayList();
  private ArrayList<QQVipMsgInfo> y;
  private int z = Color.parseColor("#FF74430E");
  
  static
  {
    ArkMultiProcUtil.a(true);
    ArkMultiProcUtil.a();
  }
  
  private void a(ViewGroup paramViewGroup, int paramInt, IHeaderView paramIHeaderView, QQVipMsgInfo paramQQVipMsgInfo, RelativeLayout paramRelativeLayout, RelativeLayout.LayoutParams paramLayoutParams)
  {
    TextView localTextView = null;
    RelativeLayout.LayoutParams localLayoutParams1;
    if (paramQQVipMsgInfo != null)
    {
      localTextView = new TextView(getBaseActivity());
      localTextView.setTextColor(-1);
      localTextView.setTextSize(1, 10.0F);
      localTextView.setBackgroundColor(Color.parseColor("#FFD69D5A"));
      localTextView.setText(TimeFormatterUtils.a(getBaseActivity(), 3, paramQQVipMsgInfo.mMsgTime * 1000L));
      localTextView.setPadding(12, 0, 12, 0);
      localTextView.setId(2131447353);
      RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)localTextView.getLayoutParams();
      localLayoutParams1 = localLayoutParams2;
      if (localLayoutParams2 == null) {
        localLayoutParams1 = new RelativeLayout.LayoutParams(-2, AIOUtils.b(14.0F, getResources()));
      }
      localTextView.setGravity(17);
      localLayoutParams1.topMargin = 25;
      localLayoutParams1.addRule(14);
      localLayoutParams1.addRule(10);
      localTextView.bringToFront();
    }
    else
    {
      localLayoutParams1 = null;
    }
    paramRelativeLayout.addView((View)paramIHeaderView, paramLayoutParams);
    if ((localTextView != null) && (localLayoutParams1 != null)) {
      paramRelativeLayout.addView(localTextView, localLayoutParams1);
    }
    paramViewGroup.addView(paramRelativeLayout, paramLayoutParams);
    if ((paramIHeaderView != null) && (paramQQVipMsgInfo != null)) {
      paramIHeaderView.a(paramQQVipMsgInfo, getBaseActivity(), paramInt);
    }
  }
  
  private void e()
  {
    this.e = ((QQVipHeadLayout)this.c.findViewById(2131442800));
    this.f = ((QQVipWebview)this.c.findViewById(2131442803));
    this.e.attachToRootView();
    this.f.attachHeaderView(this.e);
    f();
    i();
    j();
    k();
  }
  
  private void f()
  {
    this.k = ((RelativeLayout)this.c.findViewById(2131437976));
    this.k.setClickable(true);
    this.k.setOnClickListener(this);
    if (g())
    {
      h();
      return;
    }
    this.k.setVisibility(8);
  }
  
  private boolean g()
  {
    return this.c.getContext().getSharedPreferences("QQVipFeedWedFragment", 0).getBoolean(QQVipHelper.a().getCurrentAccountUin(), true);
  }
  
  private void h()
  {
    this.k.setVisibility(0);
    this.c.getContext().getSharedPreferences("QQVipFeedWedFragment", 0).edit().putBoolean(QQVipHelper.a().getCurrentAccountUin(), false).commit();
  }
  
  private void i()
  {
    this.h = ((QQGamePubViewpager)this.e.findViewById(2131433081));
    this.i = ((QQVipIndicator)this.e.findViewById(2131439795));
    this.l = ((RelativeLayout)this.e.findViewById(2131444942));
    this.m = ((RelativeLayout)this.e.findViewById(2131444943));
    this.n = ((Button)this.e.findViewById(2131430151));
    this.n.setClickable(true);
    this.n.setOnClickListener(this);
    this.o = ((Button)this.e.findViewById(2131430152));
    this.o.setClickable(true);
    this.o.setOnClickListener(this);
    this.r = ((LinearLayout)this.e.findViewById(2131434917));
    Object localObject = getResources().getDrawable(2130848721);
    ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getMinimumWidth(), ((Drawable)localObject).getMinimumHeight());
    localObject = this.y;
    if ((localObject != null) && (((ArrayList)localObject).size() >= 1))
    {
      localObject = this.y.iterator();
      while (((Iterator)localObject).hasNext())
      {
        QQVipMsgInfo localQQVipMsgInfo = (QQVipMsgInfo)((Iterator)localObject).next();
        if (!TextUtils.isEmpty(localQQVipMsgInfo.mArkAppName))
        {
          ((IArkPubicEventWrap)QRoute.api(IArkPubicEventWrap.class)).addNotify(localQQVipMsgInfo.mArkAppName);
          this.x.add(localQQVipMsgInfo.mArkAppName);
        }
      }
      ((IArkPubicEventWrap)QRoute.api(IArkPubicEventWrap.class)).registVolumnReceiver(this.x);
      this.r.setVisibility(0);
      this.j = new QQVipFeedWedFragment.HeadPageAdapter(this);
      this.h.setAdapter(this.j);
      this.h.setOffscreenPageLimit(1);
      this.i.setViewPager(this.h);
      this.i.setPageListener(this);
      this.i.a();
      this.p = this.e.findViewById(2131442799);
      localObject = URLDrawable.getDrawable("https://qzonestyle.gtimg.cn/qzone/qzact/act/external/welling-test/qqvip/backgroup_image@2x.png");
      this.p.setBackground((Drawable)localObject);
      this.m.setVisibility(8);
      this.l.setVisibility(0);
    }
    else
    {
      this.r.setVisibility(8);
      this.m.setVisibility(0);
      this.l.setVisibility(8);
      localObject = this.o.getCompoundDrawables();
      if (localObject.length > 2)
      {
        localObject = localObject[2];
        ((Drawable)localObject).mutate();
        if (localObject != null) {
          ((Drawable)localObject).setColorFilter(new LightingColorFilter(-16777216, -16777216));
        }
      }
    }
    MobileReportManager.getInstance().reportAction("QQVipAccount", "1", "1", "", "", "", 111, 1);
    MobileReportManager.getInstance().reportAction("QQVipAccount", "1", "1", "1", "", "1", 101, 1);
  }
  
  private void j()
  {
    if (this.f == null)
    {
      this.f = new QQVipWebview(this.c.getContext());
      this.f.attachHeaderView(this.e);
    }
    this.f.setAlpha(0.0F);
    this.g = new QQVipFeedWedFragment.1(this, this.c.getContext(), getBaseActivity(), QQVipHelper.a(), this.f);
    this.g.setTimeBeforeLoadUrl(System.currentTimeMillis());
    new WebViewDirector(this.g).a(null, ((ICmGameHelper)QRoute.api(ICmGameHelper.class)).getAppInterface(), null);
    this.f = ((QQVipWebview)this.g.getWebView());
    this.f.setWillNotCacheDrawing(false);
    this.f.setDrawingCacheEnabled(true);
    a();
  }
  
  private void k()
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, 400 });
    localValueAnimator.addUpdateListener(new QQVipFeedWedFragment.3(this));
    localValueAnimator.setDuration(300L);
    Object localObject1 = this.i.a(1);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    if (localObject1 != null)
    {
      Object localObject2 = this.j;
      if ((localObject2 != null) && (((QQVipFeedWedFragment.HeadPageAdapter)localObject2).getCount() > 2))
      {
        localObject2 = ObjectAnimator.ofFloat(localObject1, "scaleX", new float[] { 1.0F, 1.2F, 1.0F });
        ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(localObject1, "scaleY", new float[] { 1.0F, 1.2F, 1.0F });
        localAnimatorSet.play((Animator)localObject2).with(localObjectAnimator);
        localAnimatorSet.setDuration(1000L);
        localAnimatorSet.addListener(new QQVipFeedWedFragment.4(this, (RadioButton)localObject1));
      }
    }
    localValueAnimator.addListener(new QQVipFeedWedFragment.5(this));
    int i1 = QVipPubAccountConfig.d();
    localObject1 = this.j;
    if ((localObject1 != null) && (((QQVipFeedWedFragment.HeadPageAdapter)localObject1).getCount() > 2) && (i1 >= 0)) {
      this.h.postDelayed(new QQVipFeedWedFragment.6(this, localValueAnimator, localAnimatorSet), i1);
    }
  }
  
  private void l()
  {
    SpringAnimation localSpringAnimation = new SpringAnimation(this.h, SpringAnimation.SCROLL_X, 0.0F);
    localSpringAnimation.getSpring().setStiffness(50.0F);
    localSpringAnimation.getSpring().setDampingRatio(0.5F);
    localSpringAnimation.start();
  }
  
  public void a()
  {
    this.c.post(new QQVipFeedWedFragment.7(this));
  }
  
  public void a(int paramInt)
  {
    Object localObject = this.j;
    if ((localObject != null) && (paramInt == ((QQVipFeedWedFragment.HeadPageAdapter)localObject).getCount() - 1)) {
      QQVipHelper.a(getBaseActivity());
    }
    localObject = this.i;
    if (localObject != null) {
      ((QQVipIndicator)localObject).setCurrentIndex(paramInt);
    }
    this.A = paramInt;
    localObject = MobileReportManager.getInstance();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt + 1);
    localStringBuilder.append("");
    ((MobileReportManager)localObject).reportAction("QQVipAccount", "1", "1", localStringBuilder.toString(), "", "1", 101, 1);
    PublicAccountEventReport.a(103, null, paramInt, this.y);
  }
  
  public void a(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void a(View paramView)
  {
    this.a = ((QQVipPubNavBar)paramView.findViewById(2131444897));
    this.q = paramView.findViewById(2131437008);
    paramView = getResources().getDrawable(2130852270);
    paramView.setColorFilter(this.z, PorterDuff.Mode.SRC_ATOP);
    this.a.setRightImage(paramView);
    paramView = this.a.getLeftBackIcon().getBackground();
    if (paramView != null) {
      paramView.setColorFilter(this.z, PorterDuff.Mode.SRC_ATOP);
    }
    this.a.setBackgroundColor(0);
    this.d = this.a.getTitleTextView();
    this.d.setText(2131892961);
    this.d.setTextColor(this.z);
    String str = QVipPubAccountConfig.b();
    paramView = this.y;
    if ((paramView != null) && (paramView.size() > 0) && (this.y.get(0) != null) && (((QQVipMsgInfo)this.y.get(0)).mIsGameArk))
    {
      str = QVipPubAccountConfig.c();
      paramView = "game_icon";
    }
    else
    {
      paramView = "vip_icon";
    }
    this.a.a(str);
    MobileReportManager.getInstance().reportAction("QQVipAccount", "1", "4", "", paramView, "", 101, 1);
    paramView = URLDrawable.getDrawable("https://qzonestyle.gtimg.cn/qzone/qzact/act/external/welling-test/qqvip/navigationbar@2x.png");
    this.q.setBackground(paramView);
    this.a.setOnItemSelectListener(new QQVipFeedWedFragment.2(this));
  }
  
  public View b()
  {
    View localView = LayoutInflater.from(getBaseActivity()).inflate(2131624902, null, false);
    ((ImageView)localView.findViewById(2131432508)).setImageDrawable(URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/gameCenter/gameCenter_no_message@2x.png"));
    return localView;
  }
  
  public int c()
  {
    return this.A;
  }
  
  public QQVipMsgInfo d()
  {
    ArrayList localArrayList = this.y;
    if (localArrayList != null)
    {
      int i1 = localArrayList.size();
      int i2 = this.A;
      if (i1 > i2) {
        return (QQVipMsgInfo)this.y.get(i2);
      }
    }
    return null;
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131437976: 
      this.k.setVisibility(8);
      break;
    case 2131430151: 
    case 2131430152: 
      QQVipHelper.a(getBaseActivity());
      MobileReportManager.getInstance().reportAction("QQVipAccount", "1", "1", "5", "", "4", 102, 1);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.c = paramLayoutInflater.inflate(2131628325, paramViewGroup, false);
    this.y = ((ArrayList)getBaseActivity().getIntent().getSerializableExtra("qqvip_pubaccount_msg_list"));
    a(this.c);
    if (!SimpleUIUtil.e())
    {
      getBaseActivity().mSystemBarComp = null;
      getBaseActivity().setImmersiveStatus(0);
    }
    e();
    this.v = SystemClock.elapsedRealtime();
    MobileReportManager.getInstance().reportAction("QQVipAccount", "1", "", "", "", "", 100, 1);
    paramLayoutInflater = this.c;
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    int i1;
    if (this.b != null) {
      i1 = 0;
    }
    for (;;)
    {
      Object localObject2;
      try
      {
        if (i1 < this.b.size())
        {
          if (!(this.b.get(i1) instanceof ArkHeaderView)) {
            break label216;
          }
          ((ArkHeaderView)this.b.get(i1)).d();
          break label216;
        }
        this.b.clear();
      }
      catch (Throwable localThrowable)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("header destroy error=");
        ((StringBuilder)localObject2).append(localThrowable.toString());
        QLog.e("QQVipFeedWedFragment", 1, ((StringBuilder)localObject2).toString());
      }
      Object localObject1 = this.x;
      if (localObject1 != null)
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          ((IArkPubicEventWrap)QRoute.api(IArkPubicEventWrap.class)).removeNotify((String)localObject2);
        }
      }
      localObject1 = this.f;
      if (localObject1 != null)
      {
        ((QQVipWebview)localObject1).setDrawingCacheEnabled(false);
        this.f.destroy();
      }
      localObject1 = this.g;
      if (localObject1 != null) {
        ((QQVipWebViewBuilder)localObject1).a();
      }
      ((IArkPubicEventWrap)QRoute.api(IArkPubicEventWrap.class)).unRegistVolumnReceiver(new String[0]);
      return;
      label216:
      i1 += 1;
    }
  }
  
  public void onDestroyView()
  {
    if (this.x != null) {
      ((IArkPubicEventWrap)QRoute.api(IArkPubicEventWrap.class)).unRegistVolumnReceiver(this.x);
    }
    super.onDestroyView();
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.j != null)
    {
      QQGamePubViewpager localQQGamePubViewpager = this.h;
      if ((localQQGamePubViewpager != null) && (localQQGamePubViewpager.getCurrentItem() == this.j.getCount() - 1) && (this.j.getCount() >= 2)) {
        this.h.setCurrentItem(this.j.getCount() - 2);
      }
    }
  }
  
  public void onStop()
  {
    super.onStop();
    this.w = SystemClock.elapsedRealtime();
    MobileReportManager.getInstance().reportAction("QQVipAccount", "1", "", "", "", "", 102, (int)(this.w - this.v));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.qvip.fragment.QQVipFeedWedFragment
 * JD-Core Version:    0.7.0.1
 */