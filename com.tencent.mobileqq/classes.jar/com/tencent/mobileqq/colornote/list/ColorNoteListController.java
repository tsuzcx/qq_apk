package com.tencent.mobileqq.colornote.list;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemAnimator.ItemAnimatorFinishedListener;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewPropertyAnimator;
import android.view.ViewStub;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;
import com.tencent.mobileqq.colornote.api.IColorNoteDataService;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class ColorNoteListController
  implements RecyclerView.ItemAnimator.ItemAnimatorFinishedListener, View.OnClickListener, OnListHideListener
{
  private static int j = 2131168487;
  private static int k = 2131168464;
  private static int l = 2130839421;
  private static final List<IColorNoteListListener> r = new ArrayList();
  RecyclerView a;
  private Context b;
  private OnListHideListener c;
  private GestureDetector d;
  private ColorNoteListAdapter e;
  private View f;
  private ViewStub g;
  private View h;
  private BounceScrollView i;
  private ColorNoteListLayout m;
  private boolean n;
  private ImageView o;
  private boolean p = true;
  private boolean q = false;
  
  static
  {
    try
    {
      Iterator localIterator = ColorNoteListInjectUtil.a.iterator();
      while (localIterator.hasNext())
      {
        Class localClass = (Class)localIterator.next();
        r.add(localClass.newInstance());
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ColorNoteListController", 1, "[static] ", localException);
    }
  }
  
  public ColorNoteListController(Context paramContext, OnListHideListener paramOnListHideListener)
  {
    this.b = paramContext;
    this.c = paramOnListHideListener;
  }
  
  private void b(List<ColorNote> paramList)
  {
    Iterator localIterator = r.iterator();
    while (localIterator.hasNext()) {
      ((IColorNoteListListener)localIterator.next()).a(paramList);
    }
  }
  
  private void g()
  {
    j();
    this.f = LayoutInflater.from(this.b).inflate(2131624508, null);
    this.m = ((ColorNoteListLayout)this.f.findViewById(2131430965));
    this.o = ((ImageView)this.f.findViewById(2131430969));
    this.i = ((BounceScrollView)this.f.findViewById(2131429716));
    this.a = this.m.getRecyclerView();
    this.g = ((ViewStub)this.f.findViewById(2131430968));
    Object localObject = new LinearLayoutManager(this.b);
    ((LinearLayoutManager)localObject).setOrientation(1);
    this.a.setLayoutManager((RecyclerView.LayoutManager)localObject);
    this.m.setOnClickListener(this);
    this.a.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.o.setOnClickListener(new ColorNoteListController.1(this));
    this.d = new GestureDetector(new ColorNoteListController.2(this));
    localObject = new ColorNoteListController.3(this);
    this.f.setOnTouchListener((View.OnTouchListener)localObject);
    this.f.findViewById(2131429716).setOnTouchListener((View.OnTouchListener)localObject);
    this.f.setBackgroundResource(k);
    this.f.setPadding(0, ImmersiveUtils.getStatusBarHeight(this.b), 0, 0);
    this.m.setFocusableInTouchMode(true);
    this.m.setFocusable(true);
    this.m.requestFocus();
  }
  
  private void h()
  {
    this.q = false;
    Object localObject = this.h;
    if ((localObject != null) && (((View)localObject).getVisibility() == 0) && (this.h.hasFocus())) {
      return;
    }
    this.f.animate().alpha(0.0F).setDuration(200L).start();
    localObject = this.a.animate().setInterpolator(new AccelerateInterpolator(3.0F));
    int i1;
    if (this.n) {
      i1 = -this.a.getWidth();
    } else {
      i1 = this.a.getWidth();
    }
    ((ViewPropertyAnimator)localObject).translationX(i1).setDuration(180L).setListener(new ColorNoteListController.6(this)).start();
    i();
  }
  
  private void i()
  {
    Iterator localIterator = r.iterator();
    while (localIterator.hasNext()) {
      ((IColorNoteListListener)localIterator.next()).a();
    }
  }
  
  private void j()
  {
    if (QQTheme.isNowThemeIsNight())
    {
      j = 2131165586;
      k = 2131165564;
      l = 2130839422;
      return;
    }
    j = 2131168487;
    k = 2131168464;
    l = 2130839421;
  }
  
  public View a()
  {
    return this.f;
  }
  
  public void a(List<ColorNote> paramList)
  {
    this.e.a(paramList);
    b();
  }
  
  public void a(AppRuntime paramAppRuntime, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.q = true;
    this.n = paramBoolean;
    g();
    this.e = new ColorNoteListAdapter(r);
    this.e.a(this);
    this.e.a(paramBoolean);
    paramAppRuntime = ((IColorNoteDataService)paramAppRuntime.getRuntimeService(IColorNoteDataService.class, "all")).getVisiableColorNotes();
    this.e.a(paramAppRuntime);
    this.a.setAdapter(this.e);
    this.a.setVisibility(4);
    this.e.a(new ColorNoteListController.4(this));
    this.m.setAnchor(paramInt1, paramInt2);
    this.m.setHideListener(this);
    this.f.setAlpha(0.0F);
    this.f.animate().alpha(0.9F).setDuration(200L).setListener(new ColorNoteListController.5(this, paramBoolean)).start();
    if (!this.p) {
      this.o.setVisibility(8);
    } else {
      this.o.setVisibility(0);
    }
    b(paramAppRuntime);
  }
  
  public void a(boolean paramBoolean)
  {
    this.q = paramBoolean;
  }
  
  public void b()
  {
    this.e.notifyDataSetChanged();
  }
  
  public void c()
  {
    h();
  }
  
  public void d()
  {
    j();
    this.f.setBackgroundResource(j);
    this.o.setBackgroundResource(l);
  }
  
  public boolean e()
  {
    return this.q;
  }
  
  public void onAnimationsFinished()
  {
    if (this.e.getItemCount() == 0) {
      h();
    }
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if ((i1 == 2131430966) || (i1 == 2131430965) || (i1 == 2131430973))
    {
      h();
      ReportController.b(null, "dc00898", "", "", "0X800A6CE", "0X800A6CE", 0, 0, "", "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.list.ColorNoteListController
 * JD-Core Version:    0.7.0.1
 */