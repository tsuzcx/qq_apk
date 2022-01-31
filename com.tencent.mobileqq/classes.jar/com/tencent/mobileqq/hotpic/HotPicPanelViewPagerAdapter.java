package com.tencent.mobileqq.hotpic;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import astv;
import asub;
import asun;
import asup;
import asuu;
import asuv;
import asvw;
import com.tencent.widget.OneViewPagerAdapter;
import java.util.List;

public class HotPicPanelViewPagerAdapter
  extends OneViewPagerAdapter
{
  Context jdField_a_of_type_AndroidContentContext;
  SparseArray<HotPicPageView> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  astv jdField_a_of_type_Astv;
  protected asuu a;
  protected asuv a;
  HotPicMainPanel jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel;
  
  public HotPicPanelViewPagerAdapter(HotPicMainPanel paramHotPicMainPanel, ViewPager paramViewPager)
  {
    super(paramViewPager);
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel = paramHotPicMainPanel;
    this.jdField_a_of_type_AndroidContentContext = paramHotPicMainPanel.jdField_a_of_type_AndroidContentContext;
    this.jdField_a_of_type_Astv = paramHotPicMainPanel.jdField_a_of_type_Astv;
    this.jdField_a_of_type_Asuv = paramHotPicMainPanel;
  }
  
  public View a(int paramInt)
  {
    HotPicTagInfo localHotPicTagInfo = this.jdField_a_of_type_Astv.b(paramInt);
    HotPicPageView localHotPicPageView = (HotPicPageView)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558586, null);
    localHotPicPageView.setOnHotPicItemClickListener(this.jdField_a_of_type_Asuu);
    if (localHotPicTagInfo != null)
    {
      localHotPicPageView.a(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel, localHotPicTagInfo);
      this.jdField_a_of_type_AndroidUtilSparseArray.put(localHotPicTagInfo.tagId, localHotPicPageView);
    }
    return localHotPicPageView;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel = null;
  }
  
  public void a(int paramInt)
  {
    int i = 0;
    HotPicPageView localHotPicPageView;
    if (i < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      localHotPicPageView = (HotPicPageView)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i);
      if (localHotPicPageView.jdField_a_of_type_Asvw != null) {}
    }
    else
    {
      return;
    }
    if (localHotPicPageView.b == paramInt)
    {
      localHotPicPageView.jdField_a_of_type_Asvw.b(true);
      localHotPicPageView.o();
    }
    for (;;)
    {
      i += 1;
      break;
      localHotPicPageView.jdField_a_of_type_Asvw.b(false);
      localHotPicPageView.j();
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Object localObject2 = asub.a(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    HotPicPageView localHotPicPageView = (HotPicPageView)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt1);
    if ((localHotPicPageView != null) && (localHotPicPageView.c)) {
      localHotPicPageView.jdField_a_of_type_Asup.a(false);
    }
    switch (paramInt2)
    {
    case 4: 
    case 5: 
    default: 
      return;
    case 7: 
      localHotPicPageView.k();
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel.h();
      return;
    case 3: 
      try
      {
        localHotPicPageView.jdField_a_of_type_AndroidSupportV7WidgetStaggeredGridLayoutManager.mClearSpanOnItemsChanged = false;
        paramInt2 = localHotPicPageView.jdField_a_of_type_Asun.a.size();
        localObject2 = ((asub)localObject2).a(paramInt1);
        localHotPicPageView.jdField_a_of_type_Asun.a((List)localObject2);
        int i = ((List)localObject2).size();
        paramInt1 = paramInt2;
        while (paramInt1 < i - paramInt2)
        {
          localHotPicPageView.jdField_a_of_type_Asun.notifyItemInserted(paramInt1);
          paramInt1 += 1;
        }
        localHotPicPageView.jdField_a_of_type_Asun.notifyItemRangeChanged(paramInt2, ((List)localObject2).size());
        localHotPicPageView.m();
        return;
      }
      finally {}
    case 6: 
      if (((asub)localObject2).c(paramInt1)) {}
      for (paramInt1 = 2;; paramInt1 = 1)
      {
        localObject1.jdField_a_of_type_Asup.a(paramInt1);
        localObject1.jdField_a_of_type_Asup.a(false);
        localObject1.jdField_a_of_type_Asun.notifyItemChanged(localObject1.jdField_a_of_type_Asun.getItemCount());
        return;
      }
    }
    localObject1.k();
  }
  
  public void a(asuu paramasuu)
  {
    this.jdField_a_of_type_Asuu = paramasuu;
  }
  
  public void a(Object paramObject, int paramInt)
  {
    if ((paramObject != null) && ((paramObject instanceof HotPicPageView))) {
      ((HotPicPageView)paramObject).a();
    }
  }
  
  public void b(int paramInt)
  {
    if ((this.jdField_a_of_type_AndroidUtilSparseArray != null) && (this.jdField_a_of_type_AndroidUtilSparseArray.size() > paramInt) && (paramInt >= 0))
    {
      HotPicPageView localHotPicPageView = (HotPicPageView)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(paramInt);
      if (localHotPicPageView != null) {
        localHotPicPageView.d();
      }
    }
  }
  
  public void b(Object paramObject, int paramInt)
  {
    if ((paramObject != null) && ((paramObject instanceof HotPicPageView))) {
      ((HotPicPageView)paramObject).b();
    }
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    super.destroyItem(paramViewGroup, paramInt, paramObject);
    ((HotPicPageView)paramObject).l();
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_Astv.a();
  }
  
  public void onPageSelected(int paramInt)
  {
    super.onPageSelected(paramInt);
    if (this.jdField_a_of_type_Asuv != null) {
      this.jdField_a_of_type_Asuv.a(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotPicPanelViewPagerAdapter
 * JD-Core Version:    0.7.0.1
 */