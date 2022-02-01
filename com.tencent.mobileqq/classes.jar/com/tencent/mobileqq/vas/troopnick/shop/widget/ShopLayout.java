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
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = 0L;
  private RecyclerView.OnScrollListener jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$OnScrollListener = new ShopLayout.2(this);
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private IRequestData jdField_a_of_type_ComTencentMobileqqVasTroopnickShopAdapterIRequestData;
  private ShopAdapter jdField_a_of_type_ComTencentMobileqqVasTroopnickShopWidgetShopAdapter;
  private ShopLayout.HideInputmethod jdField_a_of_type_ComTencentMobileqqVasTroopnickShopWidgetShopLayout$HideInputmethod;
  
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
    View.inflate(getContext(), 2131562058, this);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)findViewById(2131377908));
    GridLayoutManager localGridLayoutManager = new GridLayoutManager(getContext(), 3);
    localGridLayoutManager.setSpanSizeLookup(new ShopLayout.1(this));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(localGridLayoutManager);
    this.jdField_a_of_type_ComTencentMobileqqVasTroopnickShopWidgetShopAdapter = new ShopAdapter(getContext());
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqVasTroopnickShopWidgetShopAdapter);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setOnScrollListener(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$OnScrollListener);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setBackgroundColor(-1);
    findViewById(2131366202).setVisibility(8);
    findViewById(2131379649).setOnClickListener(this);
    findViewById(2131368536).setOnClickListener(this);
    a();
    ReportHelper.a(0, 0, 0, 100);
  }
  
  public ShopAdapter a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqVasTroopnickShopWidgetShopAdapter;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqVasTroopnickShopWidgetShopAdapter);
  }
  
  public void a(boolean paramBoolean)
  {
    IRequestData localIRequestData = this.jdField_a_of_type_ComTencentMobileqqVasTroopnickShopAdapterIRequestData;
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
    long l2 = this.jdField_a_of_type_Long;
    if (l2 == 0L)
    {
      this.jdField_a_of_type_Long = l1;
      return;
    }
    if (l1 - l2 > 2000L)
    {
      this.jdField_a_of_type_Long = l1;
      a(false);
    }
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if ((i == 2131368536) || (i == 2131379649)) {
      a(false);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void setAppId(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void setHideInputmethod(ShopLayout.HideInputmethod paramHideInputmethod)
  {
    this.jdField_a_of_type_ComTencentMobileqqVasTroopnickShopWidgetShopLayout$HideInputmethod = paramHideInputmethod;
  }
  
  public void setItemId(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqVasTroopnickShopWidgetShopAdapter.a(paramInt);
  }
  
  public void setRequest(IRequestData paramIRequestData)
  {
    this.jdField_a_of_type_ComTencentMobileqqVasTroopnickShopAdapterIRequestData = paramIRequestData;
    this.jdField_a_of_type_ComTencentMobileqqVasTroopnickShopAdapterIRequestData.b();
  }
  
  public void setShopCallback(ShopLayout.ShopSetting paramShopSetting)
  {
    this.jdField_a_of_type_ComTencentMobileqqVasTroopnickShopWidgetShopAdapter.a(paramShopSetting);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.troopnick.shop.widget.ShopLayout
 * JD-Core Version:    0.7.0.1
 */