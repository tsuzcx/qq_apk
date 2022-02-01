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
import bhtf;
import bhtm;
import bhtn;
import bhtt;
import bhtu;
import bhtv;
import bhtw;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ShopLayout
  extends FrameLayout
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private RecyclerView.OnScrollListener jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$OnScrollListener = new bhtu(this);
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private bhtf jdField_a_of_type_Bhtf;
  private bhtn jdField_a_of_type_Bhtn;
  private bhtv jdField_a_of_type_Bhtv;
  
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
    View.inflate(getContext(), 2131562083, this);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)findViewById(2131378076));
    GridLayoutManager localGridLayoutManager = new GridLayoutManager(getContext(), 3);
    localGridLayoutManager.setSpanSizeLookup(new bhtt(this));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(localGridLayoutManager);
    this.jdField_a_of_type_Bhtn = new bhtn(getContext());
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Bhtn);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setOnScrollListener(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$OnScrollListener);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setBackgroundColor(-1);
    findViewById(2131366142).setVisibility(8);
    findViewById(2131379899).setOnClickListener(this);
    findViewById(2131368577).setOnClickListener(this);
    a();
    bhtm.a(0, 0, 0, 100);
  }
  
  public bhtn a()
  {
    return this.jdField_a_of_type_Bhtn;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Bhtn);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Bhtf == null) {
      return;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_Bhtf.a();
      return;
    }
    this.jdField_a_of_type_Bhtf.b();
  }
  
  public void b()
  {
    long l = System.currentTimeMillis();
    if (this.jdField_a_of_type_Long == 0L) {
      this.jdField_a_of_type_Long = l;
    }
    while (l - this.jdField_a_of_type_Long <= 2000L) {
      return;
    }
    this.jdField_a_of_type_Long = l;
    a(false);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      a(false);
    }
  }
  
  public void setAppId(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void setHideInputmethod(bhtv parambhtv)
  {
    this.jdField_a_of_type_Bhtv = parambhtv;
  }
  
  public void setItemId(int paramInt)
  {
    this.jdField_a_of_type_Bhtn.a(paramInt);
  }
  
  public void setRequest(bhtf parambhtf)
  {
    this.jdField_a_of_type_Bhtf = parambhtf;
    this.jdField_a_of_type_Bhtf.b();
  }
  
  public void setShopCallback(bhtw parambhtw)
  {
    this.jdField_a_of_type_Bhtn.a(parambhtw);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.troopnick.shop.widget.ShopLayout
 * JD-Core Version:    0.7.0.1
 */