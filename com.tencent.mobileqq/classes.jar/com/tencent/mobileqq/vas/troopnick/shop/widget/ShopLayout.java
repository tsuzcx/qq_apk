package com.tencent.mobileqq.vas.troopnick.shop.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.tencent.mobileqq.vas.troopnick.shop.adapter.IRequestData;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ShopLayout
  extends FrameLayout
  implements View.OnClickListener
{
  private RecyclerView a;
  private ShopAdapter b;
  private int c;
  private IRequestData d;
  private ShopLayout.HideInputmethod e;
  private long f = 0L;
  private RecyclerView.OnScrollListener g = new ShopLayout.2(this);
  
  public ShopLayout(@NonNull Context paramContext)
  {
    super(paramContext);
    c();
  }
  
  public ShopLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    c();
  }
  
  public ShopLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    c();
  }
  
  private void c()
  {
    View.inflate(getContext(), 2131628484, this);
    this.a = ((RecyclerView)findViewById(2131446391));
    GridLayoutManager localGridLayoutManager = new GridLayoutManager(getContext(), 3);
    localGridLayoutManager.setSpanSizeLookup(new ShopLayout.1(this));
    this.a.setLayoutManager(localGridLayoutManager);
    this.b = new ShopAdapter(getContext());
    this.a.setAdapter(this.b);
    this.a.setOnScrollListener(this.g);
    this.a.setBackgroundColor(-1);
    findViewById(2131432490).setVisibility(8);
    findViewById(2131448421).setOnClickListener(this);
    findViewById(2131435441).setOnClickListener(this);
    a();
    ReportHelper.a(0, 0, 0, 100);
  }
  
  public void a()
  {
    this.a.setAdapter(this.b);
  }
  
  public void a(boolean paramBoolean)
  {
    IRequestData localIRequestData = this.d;
    if (localIRequestData == null) {
      return;
    }
    if (paramBoolean)
    {
      localIRequestData.a();
      return;
    }
    localIRequestData.b();
  }
  
  public void b()
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.f;
    if (l2 == 0L)
    {
      this.f = l1;
      return;
    }
    if (l1 - l2 > 2000L)
    {
      this.f = l1;
      a(false);
    }
  }
  
  public ShopAdapter getAdapter()
  {
    return this.b;
  }
  
  public int getAppId()
  {
    return this.c;
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if ((i == 2131435441) || (i == 2131448421)) {
      a(false);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void setAppId(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void setHideInputmethod(ShopLayout.HideInputmethod paramHideInputmethod)
  {
    this.e = paramHideInputmethod;
  }
  
  public void setItemId(int paramInt)
  {
    this.b.a(paramInt);
  }
  
  public void setRequest(IRequestData paramIRequestData)
  {
    this.d = paramIRequestData;
    this.d.b();
  }
  
  public void setShopCallback(ShopLayout.ShopSetting paramShopSetting)
  {
    this.b.a(paramShopSetting);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.troopnick.shop.widget.ShopLayout
 * JD-Core Version:    0.7.0.1
 */