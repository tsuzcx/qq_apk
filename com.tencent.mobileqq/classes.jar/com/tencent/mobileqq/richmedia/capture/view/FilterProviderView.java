package com.tencent.mobileqq.richmedia.capture.view;

import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.widget.ListAdapter;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.adapter.FilterProviderGridAdapter;
import com.tencent.mobileqq.richmedia.capture.adapter.FilterProviderPagerAdapter;
import com.tencent.mobileqq.richmedia.capture.data.CaptureVideoFilterManager;
import com.tencent.mobileqq.richmedia.capture.data.CaptureVideoFilterManager.CaptureVideoFilterRefreshListener;
import com.tencent.mobileqq.richmedia.capture.data.FilterCategory;
import com.tencent.mobileqq.richmedia.capture.data.FilterCategoryItem;
import com.tencent.mobileqq.richmedia.capture.util.CaptureReportUtil;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.GridView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class FilterProviderView
  extends ProviderView
  implements ViewPager.OnPageChangeListener, CaptureVideoFilterManager.CaptureVideoFilterRefreshListener, ISupportAdvertisement, QQSlidingTabView.IOnTabCheckListener, AdapterView.OnItemClickListener
{
  public int a;
  FilterProviderPagerAdapter jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAdapterFilterProviderPagerAdapter;
  QQViewPager jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager;
  String jdField_a_of_type_JavaLangString;
  List<FilterCategory> jdField_a_of_type_JavaUtilList;
  boolean jdField_a_of_type_Boolean;
  private boolean d;
  
  private void c()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(CaptureVideoFilterManager.a().a());
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewQQSlidingTabView != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewQQSlidingTabView.a(a());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAdapterFilterProviderPagerAdapter != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAdapterFilterProviderPagerAdapter.a(this.jdField_a_of_type_JavaUtilList);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAdapterFilterProviderPagerAdapter.notifyDataSetChanged();
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      setTab(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_JavaLangString = "";
    }
    if (QLog.isColorLevel()) {
      QLog.d("FilterProviderView", 2, "FilterProviderView refreshData size=" + this.jdField_a_of_type_JavaUtilList.size());
    }
  }
  
  public ArrayList<QQSlidingTabView.TabIcon> a()
  {
    CaptureVideoFilterManager localCaptureVideoFilterManager = CaptureVideoFilterManager.a();
    ArrayList localArrayList = new ArrayList();
    int j = localCaptureVideoFilterManager.a();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      QQSlidingTabView.TabIcon localTabIcon = new QQSlidingTabView.TabIcon();
      FilterCategory localFilterCategory = (FilterCategory)this.jdField_a_of_type_JavaUtilList.get(i);
      localTabIcon.jdField_a_of_type_JavaLangString = localFilterCategory.jdField_a_of_type_JavaLangString;
      localTabIcon.jdField_a_of_type_Boolean = localCaptureVideoFilterManager.a(2, ((FilterCategory)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_Int, "");
      localArrayList.add(localTabIcon);
      if ((j != -1) && (j == localFilterCategory.jdField_a_of_type_Int)) {
        localCaptureVideoFilterManager.a(5, 0, null);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public void a()
  {
    ThreadManager.getUIHandler().post(new FilterProviderView.1(this));
  }
  
  public void a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > this.jdField_a_of_type_JavaUtilList.size())) {
      return;
    }
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setCurrentItem(paramInt);
    }
    CaptureVideoFilterManager.a().a(2, ((FilterCategory)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_Int, "");
  }
  
  public void a(FilterCategoryItem paramFilterCategoryItem)
  {
    if ((paramFilterCategoryItem != null) && (paramFilterCategoryItem.jdField_a_of_type_Boolean))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderView$ProviderViewListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderView$ProviderViewListener.b(paramFilterCategoryItem);
      }
      return;
    }
    CaptureVideoFilterManager.a().a(paramFilterCategoryItem);
    if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderView$ProviderViewListener != null) && (paramFilterCategoryItem != null)) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderView$ProviderViewListener.a(paramFilterCategoryItem);
    }
    b();
  }
  
  public void b()
  {
    if (!this.c) {}
    for (;;)
    {
      return;
      int j = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAdapterFilterProviderPagerAdapter.a.size();
      int i = 0;
      while (i < j)
      {
        int k = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAdapterFilterProviderPagerAdapter.a.keyAt(i);
        ListAdapter localListAdapter = ((GridView)this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAdapterFilterProviderPagerAdapter.a.get(k)).getAdapter();
        if ((localListAdapter instanceof FilterProviderGridAdapter)) {
          ((FilterProviderGridAdapter)localListAdapter).notifyDataSetChanged();
        }
        i += 1;
      }
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramView = (FilterCategory)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int);
    paramAdapterView = new ArrayList();
    if (this.jdField_a_of_type_Boolean) {
      paramAdapterView.addAll(paramView.jdField_a_of_type_JavaUtilList);
    }
    while (paramAdapterView.size() <= paramInt)
    {
      return;
      paramView = paramView.jdField_a_of_type_JavaUtilList.iterator();
      while (paramView.hasNext())
      {
        FilterCategoryItem localFilterCategoryItem = (FilterCategoryItem)paramView.next();
        if (!localFilterCategoryItem.jdField_a_of_type_Boolean) {
          paramAdapterView.add(localFilterCategoryItem);
        }
      }
    }
    a((FilterCategoryItem)paramAdapterView.get(paramInt));
  }
  
  public void onPageScrollStateChanged(int paramInt)
  {
    this.d = false;
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewQQSlidingTabView != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewQQSlidingTabView.a(paramInt);
    }
    this.jdField_a_of_type_Int = paramInt;
    if (!this.d) {
      CaptureReportUtil.b(((FilterCategory)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_Int + "");
    }
  }
  
  public void setNeedAdvertisement(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setTab(int paramInt)
  {
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilList.size()) {
      if (((FilterCategory)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_Int != paramInt) {}
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setCurrentItem(i);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewQQSlidingTabView != null) {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewQQSlidingTabView.a(i);
      }
      return;
      i += 1;
      break;
      i = 0;
    }
  }
  
  public void setTab(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    int i = 0;
    label10:
    if (i < this.jdField_a_of_type_JavaUtilList.size()) {
      if (!((FilterCategory)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangString.equals(paramString)) {}
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setCurrentItem(i);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewQQSlidingTabView != null) {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewQQSlidingTabView.a(i);
      }
      if (i != 0) {
        break;
      }
      this.jdField_a_of_type_JavaLangString = paramString;
      return;
      i += 1;
      break label10;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.FilterProviderView
 * JD-Core Version:    0.7.0.1
 */