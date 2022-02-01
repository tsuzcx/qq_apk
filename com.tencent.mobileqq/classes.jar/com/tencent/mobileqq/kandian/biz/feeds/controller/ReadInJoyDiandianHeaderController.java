package com.tencent.mobileqq.kandian.biz.feeds.controller;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import com.tencent.mobileqq.kandian.biz.channel.banner.RollViewPager;
import com.tencent.mobileqq.kandian.glue.businesshandler.DiandianTopConfigManager;
import com.tencent.mobileqq.kandian.repo.comment.entity.DiandianTopConfig;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.widget.MeasureGridView;
import com.tencent.mobileqq.widget.ViewPagerScroller;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public class ReadInJoyDiandianHeaderController
  extends HeaderViewController
{
  protected Context a;
  protected int b;
  public ColorDrawable c = new ColorDrawable(Color.parseColor("#e7e7e7"));
  protected View d;
  protected Handler e = new ReadInJoyDiandianHeaderController.1(this, Looper.getMainLooper());
  private View f;
  private View g;
  private RollViewPager h;
  private ReadInJoyDiandianHeaderController.ViewPagerAdapter i;
  private FrameLayout j;
  private SubscribedListHeaderController k;
  private List<DiandianTopConfig> l = new ArrayList();
  private List<MeasureGridView> m = new ArrayList();
  private View[] n;
  private boolean o = true;
  private boolean p = false;
  private ReadInJoyObserver q = new ReadInJoyDiandianHeaderController.2(this);
  
  public ReadInJoyDiandianHeaderController(Context paramContext)
  {
    this.a = paramContext;
    this.f = LayoutInflater.from(paramContext).inflate(2131626224, null);
    this.g = this.f.findViewById(2131447765);
    this.h = ((RollViewPager)this.f.findViewById(2131449829));
    this.i = new ReadInJoyDiandianHeaderController.ViewPagerAdapter(this);
    this.h.setAdapter(this.i);
    this.h.setOnPageChangeListener(new ReadInJoyDiandianHeaderController.RollerChangeListener(this));
    this.h.setOnTouchStateChangeListener(new ReadInJoyDiandianHeaderController.3(this));
    ViewPagerScroller localViewPagerScroller = new ViewPagerScroller(this.a, new LinearInterpolator());
    localViewPagerScroller.a(600);
    localViewPagerScroller.a(this.h);
    this.d = this.f.findViewById(2131434964);
    ReadInJoyLogicEngineEventDispatcher.a().a(this.q);
    this.j = ((FrameLayout)this.f.findViewById(2131446587));
    this.k = new SubscribedListHeaderController((Activity)paramContext, this.j);
  }
  
  private View a(int paramInt)
  {
    MeasureGridView localMeasureGridView = new MeasureGridView(this.a);
    localMeasureGridView.setSelector(new ColorDrawable(0));
    ReadInJoyDiandianHeaderController.HeaderListAdapter localHeaderListAdapter = new ReadInJoyDiandianHeaderController.HeaderListAdapter(this, this.l, paramInt);
    localMeasureGridView.setNumColumns(2);
    localMeasureGridView.setAdapter(localHeaderListAdapter);
    return localMeasureGridView;
  }
  
  private void h()
  {
    DiandianTopConfigManager.a().b();
  }
  
  protected void a() {}
  
  public void a(ListView paramListView)
  {
    paramListView.addHeaderView(this.f, 2);
    h();
  }
  
  public void b()
  {
    ReadInJoyLogicEngineEventDispatcher.a().b(this.q);
  }
  
  public void c()
  {
    super.c();
  }
  
  public void d()
  {
    super.d();
    g();
  }
  
  protected void f()
  {
    this.o = false;
    this.e.removeCallbacksAndMessages(null);
    Handler localHandler = this.e;
    localHandler.sendMessageDelayed(localHandler.obtainMessage(), 3000L);
  }
  
  protected void g()
  {
    this.o = true;
    this.e.removeCallbacksAndMessages(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.controller.ReadInJoyDiandianHeaderController
 * JD-Core Version:    0.7.0.1
 */