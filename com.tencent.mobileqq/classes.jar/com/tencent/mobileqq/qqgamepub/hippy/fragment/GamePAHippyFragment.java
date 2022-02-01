package com.tencent.mobileqq.qqgamepub.hippy.fragment;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qqgamepub.data.GmpEnterInfoRsp;
import com.tencent.mobileqq.qqgamepub.data.QQGameMsgInfo;
import com.tencent.mobileqq.qqgamepub.hippy.view.GamePubAccountHeadView;
import com.tencent.mobileqq.qqgamepub.listener.IPageListener;
import com.tencent.mobileqq.qqgamepub.mvp.model.buisness.QQGameHippyModel;
import com.tencent.mobileqq.qqgamepub.mvp.presenter.buisness.QQGameHippyPresenter;
import com.tencent.mobileqq.qqgamepub.mvp.view.buisness.IQQGameHippyView;
import com.tencent.mobileqq.qqgamepub.utils.GamePubAccountHelper;
import com.tencent.mobileqq.qqgamepub.utils.GameVideoManager;
import com.tencent.mobileqq.qqgamepub.utils.QQGameUIHelper;
import com.tencent.mobileqq.qqgamepub.view.GameArkView;
import com.tencent.mobileqq.qqgamepub.view.IHeaderView;
import com.tencent.mobileqq.qqgamepub.view.NavBarQQGamePub;
import com.tencent.mobileqq.qqgamepub.view.QQGamePubViewpager;
import com.tencent.mobileqq.qqgamepub.web.QQGameReportLogic;
import com.tencent.mobileqq.qqgamepub.web.view.GameContentView;
import com.tencent.mobileqq.qqgamepub.web.view.GameContentView.UiRefresh;
import com.tencent.mobileqq.qqgamepub.web.view.QQGameIndicator2;
import com.tencent.mobileqq.qqgamepub.web.view.UnreadTipLayout;
import com.tencent.mtt.hippy.views.list.HippyListView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;

public class GamePAHippyFragment
  extends GamePAHippyBaseFragment<QQGameHippyPresenter>
  implements View.OnClickListener, IPageListener, IQQGameHippyView<QQGameHippyPresenter>, GameContentView.UiRefresh
{
  public LinearLayout b;
  public ImageView c;
  public TextView d;
  private View e;
  private ViewGroup f;
  private NavBarQQGamePub g;
  private View h;
  private TextView i;
  private GestureDetector j;
  private QQGameIndicator2 k;
  private QQGamePubViewpager l;
  private IHeaderView m;
  private UnreadTipLayout n;
  private GameContentView o;
  private LinearLayout p;
  private RelativeLayout q;
  private GamePubAccountHeadView r;
  private boolean s = false;
  
  private View a(LayoutInflater paramLayoutInflater)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131624907, null, false);
    a(paramLayoutInflater);
    QQGameUIHelper.a(paramLayoutInflater, this.p, getQBaseActivity());
    p();
    return paramLayoutInflater;
  }
  
  private void a(View paramView)
  {
    this.f = ((ViewGroup)paramView.findViewById(2131435055));
    this.g = ((NavBarQQGamePub)paramView.findViewById(2131444897));
    this.q = ((RelativeLayout)paramView.findViewById(2131436932));
    this.p = ((LinearLayout)paramView.findViewById(2131437612));
    this.r = ((GamePubAccountHeadView)paramView.findViewById(2131436952));
  }
  
  private List<View> b(View paramView)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      int i1 = 0;
      while (i1 < paramView.getChildCount())
      {
        View localView = paramView.getChildAt(i1);
        localArrayList.add(localView);
        localArrayList.addAll(b(localView));
        i1 += 1;
      }
    }
    return localArrayList;
  }
  
  private void j()
  {
    this.l = ((QQGamePubViewpager)this.e.findViewById(2131449898));
    this.k = ((QQGameIndicator2)this.e.findViewById(2131439795));
    this.n = ((UnreadTipLayout)this.e.findViewById(2131436875));
    this.b = ((LinearLayout)this.e.findViewById(2131437016));
    this.d = ((TextView)this.e.findViewById(2131448849));
    this.c = ((ImageView)this.e.findViewById(2131444971));
    this.o = ((GameContentView)this.e.findViewById(2131436926));
    GameVideoManager.a().a(2);
  }
  
  @SuppressLint({"SetTextI18n"})
  private void k()
  {
    int i1 = ((QQGameHippyModel)((QQGameHippyPresenter)this.a).b()).b();
    if (i1 > 1)
    {
      ((QQGameHippyModel)((QQGameHippyPresenter)this.a).b()).b(1);
      i1 -= 1;
      ((QQGameHippyModel)((QQGameHippyPresenter)this.a).b()).c(i1);
      ((QQGameHippyModel)((QQGameHippyPresenter)this.a).b()).a(i1);
      this.c.setVisibility(8);
      this.n.setVisibility(0);
      this.n.setUnreadNum(i1);
      this.n.setOnClickListener(this);
      this.n.post(new GamePAHippyFragment.1(this));
      ((QQGameHippyPresenter)this.a).w().b();
    }
  }
  
  private QQGameMsgInfo l()
  {
    if (this.l != null) {
      return ((QQGameHippyPresenter)this.a).c(this.l.getCurrentItem());
    }
    return null;
  }
  
  private void n()
  {
    ((QQGameHippyPresenter)this.a).a(getQBaseActivity(), this);
    this.l.setAdapter(((QQGameHippyPresenter)this.a).z());
    this.l.setOffscreenPageLimit(5);
    this.k.setViewPager(this.l);
    this.k.a();
    this.k.setPageListener(this);
    int i1 = ((QQGameHippyPresenter)this.a).y();
    this.l.setCurrentItem(i1);
    ((QQGameHippyPresenter)this.a).d(i1);
  }
  
  private void o()
  {
    ImageView localImageView = (ImageView)this.g.findViewById(2131436666);
    this.g.setRightImage(getResources().getDrawable(2130850222), getResources().getDrawable(2130850058));
    localImageView.setImageResource(2130853298);
  }
  
  private void p()
  {
    this.g.setGamePubType(((QQGameHippyPresenter)this.a).t());
    this.g.setBackgroundResource(2130847958);
    this.h = this.g.getRightImg();
    try
    {
      Object localObject = new LinearLayout.LayoutParams(-1, (int)getResources().getDimension(2131299920));
      int i1 = ImmersiveUtils.getStatusBarHeight(MobileQQ.sMobileQQ);
      ((LinearLayout.LayoutParams)localObject).setMargins(0, i1, 0, 0);
      this.g.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("statusBarHeight = ");
      ((StringBuilder)localObject).append(i1);
      QLog.d("QQGamePub_GamePubAccountHippyFragment", 4, ((StringBuilder)localObject).toString());
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("set statusBarHeight failed:");
      localStringBuilder.append(localThrowable.getMessage());
      QLog.e("QQGamePub_GamePubAccountHippyFragment", 4, localStringBuilder.toString());
    }
    this.g.setOnItemSelectListener(new GamePAHippyFragment.2(this));
    NavBarQQGamePub localNavBarQQGamePub = this.g;
    if (localNavBarQQGamePub != null) {
      localNavBarQQGamePub.a();
    }
    o();
    f();
  }
  
  private void q()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("isSetHeadScrollWithHippy=");
    ((StringBuilder)localObject1).append(this.s);
    QLog.d("QQGamePub_GamePubAccountHippyFragment", 1, ((StringBuilder)localObject1).toString());
    localObject1 = this.f;
    if (localObject1 == null) {
      return;
    }
    Object localObject2 = b((View)localObject1).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject1 = (View)((Iterator)localObject2).next();
      if ((localObject1 instanceof HippyListView))
      {
        this.s = true;
        QLog.d("QQGamePub_GamePubAccountHippyFragment", 1, "set Head Scrol lWith Hippy");
        this.q.bringToFront();
        localObject2 = (HippyListView)localObject1;
        ((HippyListView)localObject2).setMomentumScrollBeginEventEnable(false);
        ((HippyListView)localObject2).addOnListScrollListener(new GamePAHippyFragment.6(this, (View)localObject1));
      }
    }
  }
  
  private void r()
  {
    if (((QQGameHippyPresenter)this.a).B())
    {
      RelativeLayout localRelativeLayout = this.q;
      if (localRelativeLayout != null) {
        localRelativeLayout.post(new GamePAHippyFragment.12(this));
      }
    }
  }
  
  public void a(int paramInt)
  {
    ((QQGameHippyPresenter)this.a).f(paramInt);
  }
  
  public void a(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void a(int paramInt, IHeaderView paramIHeaderView)
  {
    if (paramInt == this.l.getCurrentItem())
    {
      this.m = paramIHeaderView;
      if ((paramIHeaderView instanceof GameArkView))
      {
        paramIHeaderView = (GameArkView)paramIHeaderView;
        paramIHeaderView.setPrePause(false);
        GameVideoManager.a().a(paramIHeaderView);
        return;
      }
      GameVideoManager.a().a(null);
    }
  }
  
  public void a(long paramLong)
  {
    ((QQGameHippyPresenter)this.a).a(3);
    h();
    ((QQGameHippyModel)((QQGameHippyPresenter)this.a).b()).a("onHippyFirstScreen");
    QLog.d("QQGamePub_GamePubAccountHippyFragment", 1, "--->on HippyFirstScreen");
    ((QQGameHippyModel)((QQGameHippyPresenter)this.a).b()).c(paramLong);
    if (!this.s) {
      ThreadManagerV2.getUIHandlerV2().post(new GamePAHippyFragment.15(this));
    }
  }
  
  public void a(GmpEnterInfoRsp paramGmpEnterInfoRsp, boolean paramBoolean)
  {
    if ((paramGmpEnterInfoRsp != null) && (paramGmpEnterInfoRsp.retCode == 0) && (paramGmpEnterInfoRsp.state == 1) && (paramBoolean))
    {
      ThreadManagerV2.getUIHandlerV2().post(new GamePAHippyFragment.8(this, paramGmpEnterInfoRsp));
      return;
    }
    paramGmpEnterInfoRsp = GamePubAccountHelper.f();
    ((QQGameHippyPresenter)this.a).w().a(paramGmpEnterInfoRsp.bubbleId, true);
    ThreadManagerV2.getUIHandlerV2().post(new GamePAHippyFragment.9(this, paramGmpEnterInfoRsp));
    if (QLog.isColorLevel()) {
      QLog.d("QQGamePub_GamePubAccountHippyFragment", 1, "rec game enter is null");
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (!paramBoolean)
    {
      this.n.setVisibility(8);
      this.b.setVisibility(8);
      this.k.setVisibility(0);
      ((QQGameHippyModel)((QQGameHippyPresenter)this.a).b()).a(0);
      ((QQGameHippyModel)((QQGameHippyPresenter)this.a).b()).c(0);
      ((QQGameHippyModel)((QQGameHippyPresenter)this.a).b()).b(0);
      return;
    }
    this.c.setVisibility(8);
    this.n.setVisibility(0);
    this.n.setUnreadNum(paramInt);
  }
  
  public void b(int paramInt)
  {
    ThreadManagerV2.getUIHandlerV2().post(new GamePAHippyFragment.10(this, paramInt));
  }
  
  public void b(long paramLong)
  {
    super.b(paramLong);
    ((QQGameHippyPresenter)this.a).a(4);
    ((QQGameHippyModel)((QQGameHippyPresenter)this.a).b()).a("onHippShow");
    QLog.d("QQGamePub_GamePubAccountHippyFragment", 1, "--->on hippy show");
    ((QQGameHippyModel)((QQGameHippyPresenter)this.a).b()).d(paramLong);
    if (!this.s) {
      ThreadManagerV2.getUIHandlerV2().post(new GamePAHippyFragment.13(this));
    }
    h();
    ThreadManagerV2.executeOnSubThread(new GamePAHippyFragment.14(this));
  }
  
  public void c(int paramInt)
  {
    Object localObject = ((QQGameHippyPresenter)this.a).C();
    int i1 = 0;
    while (i1 < ((List)localObject).size())
    {
      if (i1 == paramInt)
      {
        this.m = ((IHeaderView)((List)localObject).get(i1));
        if ((this.m instanceof GameArkView))
        {
          GameVideoManager.a().a((GameArkView)this.m);
          ((GameArkView)this.m).f();
        }
        else
        {
          GameVideoManager.a().a(null);
        }
      }
      else
      {
        IHeaderView localIHeaderView = (IHeaderView)((List)localObject).get(i1);
        if (localIHeaderView != null) {
          localIHeaderView.b();
        }
      }
      i1 += 1;
    }
    localObject = this.m;
    if (localObject != null) {
      ((IHeaderView)localObject).a();
    }
  }
  
  public void c(long paramLong)
  {
    QQGameUIHelper.a(paramLong, this.o, this.h);
  }
  
  public void d(int paramInt)
  {
    if (((QQGameHippyModel)((QQGameHippyPresenter)this.a).b()).b() > 0)
    {
      int i2 = ((QQGameHippyModel)((QQGameHippyPresenter)this.a).b()).c();
      int i1 = ((QQGameHippyModel)((QQGameHippyPresenter)this.a).b()).d();
      if ((paramInt >= i2) && (i2 <= i1) && (paramInt <= i1))
      {
        QQGameHippyModel localQQGameHippyModel = (QQGameHippyModel)((QQGameHippyPresenter)this.a).b();
        paramInt = i2 + 1;
        localQQGameHippyModel.b(paramInt);
        paramInt = i1 - paramInt + 1;
        ((QQGameHippyModel)((QQGameHippyPresenter)this.a).b()).a(paramInt);
        if ((paramInt > 0) && (paramInt <= 3))
        {
          a(true, paramInt);
          return;
        }
        a(false, 0);
      }
    }
    else
    {
      a(false, 0);
    }
  }
  
  public void e()
  {
    GameContentView localGameContentView = this.o;
    if (localGameContentView != null)
    {
      localGameContentView.setUiRefresh(this);
      this.o.a();
    }
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public void f()
  {
    this.i = this.g.getTitleTextView();
    this.i.setText(2131892960);
    this.i.setTextColor(-1);
    this.j = new GestureDetector(getQBaseActivity(), new GamePAHippyFragment.3(this));
    this.i.setOnTouchListener(new GamePAHippyFragment.4(this));
  }
  
  public ViewPager g()
  {
    return this.l;
  }
  
  public void h()
  {
    ThreadManagerV2.getUIHandlerV2().post(new GamePAHippyFragment.11(this));
  }
  
  public QQGameHippyPresenter i()
  {
    return new QQGameHippyPresenter();
  }
  
  public void onClick(View paramView)
  {
    int i1;
    int i2;
    int i3;
    if (paramView.getId() == 2131436875)
    {
      if (this.l != null)
      {
        i1 = ((QQGameHippyPresenter)this.a).D();
        if (((QQGameHippyModel)((QQGameHippyPresenter)this.a).b()).b() >= 3)
        {
          this.l.setCurrentItem(((QQGameHippyPresenter)this.a).E());
          break label361;
        }
        i2 = this.l.getCurrentItem();
        i3 = i2 + 1;
        if (i3 < i1) {
          this.l.setCurrentItem(i3);
        } else if (i2 == i1 - 1) {
          this.l.setCurrentItem(i1);
        }
        if (((QQGameHippyModel)((QQGameHippyPresenter)this.a).b()).b() == 0)
        {
          this.k.setVisibility(0);
          this.n.setVisibility(4);
          this.k.b();
        }
      }
      ((QQGameHippyPresenter)this.a).w().a();
    }
    else if (paramView.getId() == 2131437016)
    {
      Object localObject3 = l();
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
      ((QQGameHippyPresenter)this.a).w().c((String)localObject2, (String)localObject1);
      if (this.l != null)
      {
        i1 = ((QQGameHippyPresenter)this.a).D();
        if (((QQGameHippyModel)((QQGameHippyPresenter)this.a).b()).b() >= 3)
        {
          this.l.setCurrentItem(((QQGameHippyPresenter)this.a).E());
        }
        else
        {
          i2 = this.l.getCurrentItem();
          i3 = i2 + 1;
          if (i3 < i1) {
            this.l.setCurrentItem(i3);
          } else if (i2 == i1 - 1) {
            this.l.setCurrentItem(i1);
          }
        }
      }
    }
    label361:
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.e = a(paramLayoutInflater);
    ((QQGameHippyModel)((QQGameHippyPresenter)this.a).b()).a("initView");
    j();
    ((QQGameHippyModel)((QQGameHippyPresenter)this.a).b()).a("initHeadView");
    loadHippy(this.f);
    ((QQGameHippyPresenter)this.a).a(2);
    ((QQGameHippyModel)((QQGameHippyPresenter)this.a).b()).a("loadHippy");
    e();
    ((QQGameHippyModel)((QQGameHippyPresenter)this.a).b()).a("initGameContentView");
    n();
    ((QQGameHippyModel)((QQGameHippyPresenter)this.a).b()).a("initViewPager");
    k();
    ((QQGameHippyModel)((QQGameHippyPresenter)this.a).b()).a("initTipLayout");
    ((QQGameHippyModel)((QQGameHippyPresenter)this.a).b()).a("initViewEnd");
    paramLayoutInflater = this.e;
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    try
    {
      if (this.o != null)
      {
        this.o.b();
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QQGamePub_GamePubAccountHippyFragment", 1, localThrowable.getMessage());
    }
  }
  
  protected void onLoadHippyError(int paramInt, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onLoadHippyError statusCode:");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" msg:");
    ((StringBuilder)localObject).append(paramString);
    QLog.d("QQGamePub_GamePubAccountHippyFragment", 1, ((StringBuilder)localObject).toString());
    super.onLoadHippyError(paramInt, paramString);
    ((QQGameHippyPresenter)this.a).a(6);
    ((QQGameHippyModel)((QQGameHippyPresenter)this.a).b()).a(false);
    ((QQGameHippyModel)((QQGameHippyPresenter)this.a).b()).b(-1L);
    ((QQGameHippyModel)((QQGameHippyPresenter)this.a).b()).a("onLoadHippyEnd");
    localObject = this.q;
    if (localObject != null)
    {
      LinearLayout localLinearLayout = this.p;
      if (localLinearLayout != null) {
        ((RelativeLayout)localObject).removeView(localLinearLayout);
      }
    }
    ThreadManagerV2.executeOnSubThread(new GamePAHippyFragment.7(this, paramInt, paramString));
  }
  
  protected void onLoadHippySuccess()
  {
    super.onLoadHippySuccess();
    ((QQGameHippyPresenter)this.a).a(5);
    ((QQGameHippyModel)((QQGameHippyPresenter)this.a).b()).a("onLoadHippyEnd");
    ((QQGameHippyModel)((QQGameHippyPresenter)this.a).b()).a(true);
    RelativeLayout localRelativeLayout = this.q;
    if (localRelativeLayout != null)
    {
      LinearLayout localLinearLayout = this.p;
      if (localLinearLayout != null) {
        localRelativeLayout.removeView(localLinearLayout);
      }
    }
    if (!this.s) {
      ThreadManagerV2.getUIHandlerV2().postDelayed(new GamePAHippyFragment.5(this), 500L);
    }
  }
  
  public void onPause()
  {
    super.onPause();
    try
    {
      if ((this.m instanceof GameArkView))
      {
        this.m.b();
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QQGamePub_GamePubAccountHippyFragment", 1, localThrowable.getMessage());
    }
  }
  
  public void onResume()
  {
    super.onResume();
    IHeaderView localIHeaderView = this.m;
    if (localIHeaderView != null) {
      localIHeaderView.a();
    }
    try
    {
      this.l.setCurrentItem(((QQGameHippyPresenter)this.a).b(this.l.getCurrentItem()));
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QQGamePub_GamePubAccountHippyFragment", 1, localThrowable.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.hippy.fragment.GamePAHippyFragment
 * JD-Core Version:    0.7.0.1
 */