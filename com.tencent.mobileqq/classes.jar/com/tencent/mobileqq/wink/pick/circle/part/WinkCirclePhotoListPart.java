package com.tencent.mobileqq.wink.pick.circle.part;

import android.app.Activity;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.wink.pick.album.data.WinkAlbumLogicData;
import com.tencent.mobileqq.wink.pick.circle.WinkCirclePhotoListLogic;
import com.tencent.mobileqq.wink.pick.circle.WinkCircleSinglePhotoListFragment;
import com.tencent.mobileqq.wink.pick.circle.event.WinkCircleSelectChangeEvent;
import com.tencent.mobileqq.wink.pick.circle.model.PickAlbumViewModel;
import com.tencent.mobileqq.wink.pick.circle.part.base.WinkCircleBasePart;
import com.tencent.mobileqq.wink.pick.circle.view.NoScrollViewPager;
import com.tencent.mobileqq.wink.view.scrollingheader.ScrollingHeaderLayout.ScrollingViewBehavior;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WinkCirclePhotoListPart
  extends WinkCircleBasePart
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, SimpleEventReceiver
{
  public static final int[] a = { 1, 3, 2 };
  public static int b = 4;
  private NoScrollViewPager c;
  private RadioGroup f;
  private RadioButton g;
  private RadioButton h;
  private RadioButton i;
  private ImageView j;
  private RelativeLayout k;
  private PickAlbumViewModel l;
  private ArrayList<WinkCircleSinglePhotoListFragment> m;
  
  public WinkCirclePhotoListPart(WinkCirclePhotoListLogic paramWinkCirclePhotoListLogic)
  {
    super(paramWinkCirclePhotoListLogic);
    this.d.a(this);
  }
  
  private int a(int paramInt)
  {
    int n = 0;
    int i1 = 0;
    for (;;)
    {
      int[] arrayOfInt = a;
      if (n >= arrayOfInt.length) {
        break;
      }
      if (arrayOfInt[n] == paramInt) {
        i1 = n;
      }
      n += 1;
    }
    return i1;
  }
  
  private void b(int paramInt)
  {
    int n = 0;
    while (n < this.m.size())
    {
      if (n == paramInt) {
        ((WinkCircleSinglePhotoListFragment)this.m.get(n)).b(paramInt);
      } else {
        ((WinkCircleSinglePhotoListFragment)this.m.get(n)).b();
      }
      n += 1;
    }
  }
  
  private void b(View paramView)
  {
    this.f = ((RadioGroup)paramView.findViewById(2131444765));
    this.g = ((RadioButton)paramView.findViewById(2131444181));
    this.h = ((RadioButton)paramView.findViewById(2131444187));
    this.i = ((RadioButton)paramView.findViewById(2131444193));
    this.g.setTypeface(Typeface.DEFAULT_BOLD);
    this.g.setOnCheckedChangeListener(this);
    this.h.setOnCheckedChangeListener(this);
    this.i.setOnCheckedChangeListener(this);
    this.f.setOnCheckedChangeListener(new WinkCirclePhotoListPart.1(this));
    if (this.d != null)
    {
      paramView = this.f;
      int n;
      if (this.d.n.isHideSelectTab) {
        n = 8;
      } else {
        n = 0;
      }
      paramView.setVisibility(n);
    }
  }
  
  private void d(View paramView)
  {
    this.c = ((NoScrollViewPager)paramView.findViewById(2131439013));
    this.c.setOffscreenPageLimit(2);
    if ((this.c.getLayoutParams() instanceof CoordinatorLayout.LayoutParams)) {
      ((CoordinatorLayout.LayoutParams)this.c.getLayoutParams()).setBehavior(new ScrollingHeaderLayout.ScrollingViewBehavior());
    }
    paramView = new WinkCirclePhotoListPart.PhotoPagerAdapter(this, j());
    this.c.setAdapter(paramView);
    this.c.addOnPageChangeListener(new WinkCirclePhotoListPart.2(this));
    if (this.d != null)
    {
      int n = a(this.d.n.defaultSelectTab);
      this.c.setCurrentItem(n, false);
    }
  }
  
  private void e(View paramView)
  {
    if (TextUtils.isEmpty(WinkCirclePhotoListLogic.a(c().getIntent()))) {
      return;
    }
    this.l.a().observe(j(), new WinkCirclePhotoListPart.3(this, paramView));
    this.j = ((ImageView)paramView.findViewById(2131439012));
    this.j.setOnClickListener(this);
  }
  
  private void f()
  {
    this.l = ((PickAlbumViewModel)new ViewModelProvider(j().getActivity()).get(PickAlbumViewModel.class));
    this.m = new ArrayList();
    int[] arrayOfInt = a;
    int i1 = arrayOfInt.length;
    int n = 0;
    while (n < i1)
    {
      int i2 = arrayOfInt[n];
      this.m.add(new WinkCircleSinglePhotoListFragment().a(this.d).a(i2));
      n += 1;
    }
  }
  
  public String a()
  {
    return "WinkCirclePhotoListPart";
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    f();
    b(paramView);
    d(paramView);
    e(paramView);
  }
  
  public void a(List<LocalMediaInfo> paramList)
  {
    Iterator localIterator = this.m.iterator();
    while (localIterator.hasNext()) {
      ((WinkCircleSinglePhotoListFragment)localIterator.next()).a(paramList);
    }
  }
  
  public void d()
  {
    Iterator localIterator = this.m.iterator();
    while (localIterator.hasNext()) {
      ((WinkCircleSinglePhotoListFragment)localIterator.next()).c();
    }
  }
  
  public void e()
  {
    Iterator localIterator = this.m.iterator();
    while (localIterator.hasNext())
    {
      WinkCircleSinglePhotoListFragment localWinkCircleSinglePhotoListFragment = (WinkCircleSinglePhotoListFragment)localIterator.next();
      if (localWinkCircleSinglePhotoListFragment != null) {
        localWinkCircleSinglePhotoListFragment.d();
      }
    }
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(WinkCircleSelectChangeEvent.class);
    return localArrayList;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    Typeface localTypeface;
    if (paramBoolean) {
      localTypeface = Typeface.DEFAULT_BOLD;
    } else {
      localTypeface = Typeface.DEFAULT;
    }
    paramCompoundButton.setTypeface(localTypeface);
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131439012) {
      this.k.setVisibility(8);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof WinkCircleSelectChangeEvent)) {
      d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.pick.circle.part.WinkCirclePhotoListPart
 * JD-Core Version:    0.7.0.1
 */