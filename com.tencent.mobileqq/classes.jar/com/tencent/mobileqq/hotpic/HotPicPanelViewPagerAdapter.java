package com.tencent.mobileqq.hotpic;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.ViewPager;
import com.tencent.widget.OneViewPagerAdapter;
import java.util.List;

public class HotPicPanelViewPagerAdapter
  extends OneViewPagerAdapter
{
  Context jdField_a_of_type_AndroidContentContext;
  SparseArray<HotPicPageView> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  HotPicIndexAndIDMap jdField_a_of_type_ComTencentMobileqqHotpicHotPicIndexAndIDMap;
  HotPicMainPanel jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel;
  protected HotPicPageView.OnHotPicItemClickListener a;
  protected HotPicPanelViewPagerAdapter.OnHotPicPageSelectedListener a;
  
  public HotPicPanelViewPagerAdapter(HotPicMainPanel paramHotPicMainPanel, ViewPager paramViewPager)
  {
    super(paramViewPager);
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel = paramHotPicMainPanel;
    this.jdField_a_of_type_AndroidContentContext = paramHotPicMainPanel.jdField_a_of_type_AndroidContentContext;
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicIndexAndIDMap = paramHotPicMainPanel.jdField_a_of_type_ComTencentMobileqqHotpicHotPicIndexAndIDMap;
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPanelViewPagerAdapter$OnHotPicPageSelectedListener = paramHotPicMainPanel;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel = null;
  }
  
  public void a(int paramInt)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      HotPicPageView localHotPicPageView = (HotPicPageView)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i);
      if (localHotPicPageView.jdField_a_of_type_ComTencentMobileqqHotpicHotpicDownloadDispatcher == null) {
        return;
      }
      if (localHotPicPageView.b == paramInt)
      {
        localHotPicPageView.jdField_a_of_type_ComTencentMobileqqHotpicHotpicDownloadDispatcher.b(true);
        localHotPicPageView.o();
      }
      else
      {
        localHotPicPageView.jdField_a_of_type_ComTencentMobileqqHotpicHotpicDownloadDispatcher.b(false);
        localHotPicPageView.j();
      }
      i += 1;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Object localObject2 = HotPicManager.a(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    HotPicPageView localHotPicPageView = (HotPicPageView)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt1);
    if ((localHotPicPageView != null) && (localHotPicPageView.c))
    {
      localHotPicPageView.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$HotPicFooter.a(false);
      if (paramInt2 != 3)
      {
        if (paramInt2 != 5)
        {
          if (paramInt2 != 6)
          {
            if (paramInt2 != 7)
            {
              if (paramInt2 != 8) {
                return;
              }
              localHotPicPageView.k();
              return;
            }
            localHotPicPageView.k();
            this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel.h();
            return;
          }
          if (((HotPicManager)localObject2).c(paramInt1)) {
            paramInt1 = 2;
          } else {
            paramInt1 = 1;
          }
          localHotPicPageView.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$HotPicFooter.a(paramInt1);
          localHotPicPageView.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$HotPicFooter.a(false);
          localHotPicPageView.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$HotPicAdapter.notifyItemChanged(localHotPicPageView.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$HotPicAdapter.getItemCount());
        }
      }
      else {
        try
        {
          localHotPicPageView.jdField_a_of_type_AndroidSupportV7WidgetStaggeredGridLayoutManager.mClearSpanOnItemsChanged = false;
          paramInt2 = localHotPicPageView.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$HotPicAdapter.a.size();
          localObject2 = ((HotPicManager)localObject2).a(paramInt1);
          localHotPicPageView.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$HotPicAdapter.a((List)localObject2);
          int i = ((List)localObject2).size();
          paramInt1 = paramInt2;
          while (paramInt1 < i - paramInt2)
          {
            localHotPicPageView.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$HotPicAdapter.notifyItemInserted(paramInt1);
            paramInt1 += 1;
          }
          localHotPicPageView.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$HotPicAdapter.notifyItemRangeChanged(paramInt2, ((List)localObject2).size());
          localHotPicPageView.m();
          return;
        }
        finally {}
      }
    }
  }
  
  public void a(HotPicPageView.OnHotPicItemClickListener paramOnHotPicItemClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$OnHotPicItemClickListener = paramOnHotPicItemClickListener;
  }
  
  public void b(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_AndroidUtilSparseArray;
    if ((localObject != null) && (((SparseArray)localObject).size() > paramInt) && (paramInt >= 0))
    {
      localObject = (HotPicPageView)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(paramInt);
      if (localObject != null) {
        ((HotPicPageView)localObject).d();
      }
    }
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    super.destroyItem(paramViewGroup, paramInt, paramObject);
    ((HotPicPageView)paramObject).l();
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicIndexAndIDMap.a();
  }
  
  public View getView(int paramInt)
  {
    HotPicTagInfo localHotPicTagInfo = this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicIndexAndIDMap.b(paramInt);
    HotPicPageView localHotPicPageView = (HotPicPageView)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558552, null);
    localHotPicPageView.setOnHotPicItemClickListener(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$OnHotPicItemClickListener);
    if (localHotPicTagInfo != null)
    {
      localHotPicPageView.a(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel, localHotPicTagInfo);
      this.jdField_a_of_type_AndroidUtilSparseArray.put(localHotPicTagInfo.tagId, localHotPicPageView);
    }
    return localHotPicPageView;
  }
  
  public void initView(Object paramObject, int paramInt)
  {
    if ((paramObject != null) && ((paramObject instanceof HotPicPageView))) {
      ((HotPicPageView)paramObject).a();
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    super.onPageSelected(paramInt);
    HotPicPanelViewPagerAdapter.OnHotPicPageSelectedListener localOnHotPicPageSelectedListener = this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPanelViewPagerAdapter$OnHotPicPageSelectedListener;
    if (localOnHotPicPageSelectedListener != null) {
      localOnHotPicPageSelectedListener.a(paramInt);
    }
  }
  
  public void unInitView(Object paramObject, int paramInt)
  {
    if ((paramObject != null) && ((paramObject instanceof HotPicPageView))) {
      ((HotPicPageView)paramObject).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotPicPanelViewPagerAdapter
 * JD-Core Version:    0.7.0.1
 */