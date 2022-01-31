package dov.com.qq.im.capture.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListAdapter;
import anpq;
import com.tencent.biz.qqstory.utils.WeishiGuideUtils;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.GridView;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.adapter.FilterProviderGridAdapter;
import dov.com.qq.im.capture.adapter.FilterProviderPagerAdapter;
import dov.com.qq.im.capture.data.CaptureComboManager;
import dov.com.qq.im.capture.data.CaptureComboManager.CaptureComboListener;
import dov.com.qq.im.capture.data.ComboSet;
import dov.com.qq.im.capture.data.FilterCategory;
import dov.com.qq.im.capture.data.FilterSet;
import dov.com.qq.im.capture.data.QIMFilterCategoryItem;
import dov.com.qq.im.capture.predownload.QIMPredownManager;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterTools;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterTools.ComboFilterData;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterTools.DataSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QIMFilterProviderView
  extends ProviderView
  implements ViewPager.OnPageChangeListener, AdapterView.OnItemClickListener, CaptureComboManager.CaptureComboListener, QIMSlidingTabView.IOnTabCheckListener
{
  public int a;
  QQViewPager a;
  public FilterProviderPagerAdapter a;
  public VideoFilterTools.DataSet a;
  public ArrayList a;
  
  public QIMFilterProviderView(Context paramContext)
  {
    super(paramContext);
  }
  
  private void c(Bundle paramBundle)
  {
    Bundle localBundle = null;
    if (paramBundle != null) {
      localBundle = paramBundle.getBundle(QIMFilterProviderView.class.getSimpleName());
    }
    if (localBundle != null)
    {
      if (VideoFilterTools.a().a[this.f] != null) {
        VideoFilterTools.a().a[this.f].jdField_b_of_type_Int = 1;
      }
      paramBundle = (QIMFilterCategoryItem)localBundle.getParcelable("selected_filter_item");
      if (paramBundle != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("FilterProviderView", 2, "restore " + paramBundle.jdField_a_of_type_JavaLangString);
        }
        paramBundle.jdField_b_of_type_Int = 1;
      }
    }
  }
  
  protected int a()
  {
    return 2130970125;
  }
  
  protected Bundle a()
  {
    Bundle localBundle = new Bundle();
    QIMFilterCategoryItem localQIMFilterCategoryItem1 = VideoFilterTools.a().b(this.f);
    if (localQIMFilterCategoryItem1 != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FilterProviderView", 2, "save " + localQIMFilterCategoryItem1.jdField_a_of_type_JavaLangString);
      }
      localBundle.putParcelable("selected_filter_item", localQIMFilterCategoryItem1);
      int i = b();
      if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) && (i >= 0) && (i < this.jdField_a_of_type_JavaUtilArrayList.size()))
      {
        FilterCategory localFilterCategory = (FilterCategory)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if (localFilterCategory != null)
        {
          Object localObject = localFilterCategory.jdField_a_of_type_JavaUtilList;
          if (localObject != null)
          {
            localObject = ((List)localObject).iterator();
            while (((Iterator)localObject).hasNext())
            {
              QIMFilterCategoryItem localQIMFilterCategoryItem2 = (QIMFilterCategoryItem)((Iterator)localObject).next();
              if ((localQIMFilterCategoryItem1.a() == localQIMFilterCategoryItem2.a()) && (localQIMFilterCategoryItem1.jdField_b_of_type_JavaLangString != null) && (localQIMFilterCategoryItem1.jdField_b_of_type_JavaLangString.equals(localQIMFilterCategoryItem2.jdField_b_of_type_JavaLangString))) {
                localBundle.putParcelable("ProviderView.select_item_category", localFilterCategory);
              }
            }
          }
        }
      }
    }
    return localBundle;
  }
  
  public FilterCategory a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      int i = b();
      if ((i > 0) && (i < this.jdField_a_of_type_JavaUtilArrayList.size())) {
        return (FilterCategory)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      }
    }
    return null;
  }
  
  public ArrayList a()
  {
    ArrayList localArrayList = new ArrayList();
    int j = VideoFilterTools.a().a();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      QIMSlidingTabView.TabIcon localTabIcon = new QIMSlidingTabView.TabIcon();
      localTabIcon.jdField_a_of_type_JavaLangString = ((FilterCategory)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_JavaLangString;
      localTabIcon.jdField_a_of_type_Boolean = VideoFilterTools.a().a(2, ((FilterCategory)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Int, "");
      localArrayList.add(localTabIcon);
      if ((j != -1) && (j == ((FilterCategory)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Int))
      {
        this.jdField_a_of_type_Int = i;
        VideoFilterTools.a().a(5, 0, null);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_DovComQqImCaptureViewProviderView$ProviderViewListener != null) {
      this.jdField_a_of_type_DovComQqImCaptureViewProviderView$ProviderViewListener.d(true);
    }
  }
  
  public void a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return;
    }
    if (paramInt != 0) {
      k();
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setCurrentItem(paramInt);
    VideoFilterTools.a().a(2, ((FilterCategory)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Int, "");
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FilterProviderView", 2, "category= " + paramInt + ",itemId=" + paramString);
    }
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilArrayList.size()) {
      if (((FilterCategory)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Int != paramInt) {}
    }
    for (;;)
    {
      a().a(i);
      Object localObject2 = (FilterCategory)this.jdField_a_of_type_JavaUtilArrayList.get(b());
      paramInt = 0;
      label97:
      Object localObject1;
      if (paramInt < ((FilterCategory)localObject2).jdField_a_of_type_JavaUtilList.size())
      {
        localObject1 = (QIMFilterCategoryItem)((FilterCategory)localObject2).jdField_a_of_type_JavaUtilList.get(paramInt);
        if (!((QIMFilterCategoryItem)localObject1).jdField_a_of_type_JavaLangString.equals(paramString)) {}
      }
      for (paramString = (String)localObject1;; paramString = null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("FilterProviderView", 2, "itemInfo= " + paramString + ",index=" + i + ",pos=" + paramInt);
        }
        if (paramString != null)
        {
          postDelayed(new anpq(this, paramInt), 200L);
          localObject1 = (CaptureComboManager)QIMManager.a(5);
          localObject2 = new Bundle();
          ((Bundle)localObject2).putInt("apply_source", 1);
          ((Bundle)localObject2).putInt("capture_scene", this.f);
          ((CaptureComboManager)localObject1).a(paramString, (Activity)getContext(), (Bundle)localObject2);
          d();
        }
        return;
        i += 1;
        break;
        paramInt += 1;
        break label97;
        paramInt = 0;
      }
      i = 0;
    }
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.setTabCheckListener(this);
    if (this.jdField_a_of_type_AndroidViewView == null) {}
    for (this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager = ((QQViewPager)LayoutInflater.from(getContext()).inflate(2130970125, this, false));; this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager = ((QQViewPager)this.jdField_a_of_type_AndroidViewView))
    {
      this.jdField_a_of_type_DovComQqImCaptureAdapterFilterProviderPagerAdapter = new FilterProviderPagerAdapter(this.jdField_a_of_type_AndroidContentContext, this.f);
      this.jdField_a_of_type_DovComQqImCaptureAdapterFilterProviderPagerAdapter.a(this);
      this.jdField_a_of_type_DovComQqImCaptureAdapterFilterProviderPagerAdapter.a(new ArrayList());
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setOnPageChangeListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setAdapter(this.jdField_a_of_type_DovComQqImCaptureAdapterFilterProviderPagerAdapter);
      a(this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager);
      paramBundle = (CaptureComboManager)QIMManager.a(5);
      paramBundle.b(this);
      paramBundle.a(this);
      if (QLog.isColorLevel()) {
        QLog.d("QCombo", 2, "FilterProviderView onCreate");
      }
      paramBundle = paramBundle.a;
      if (paramBundle != null) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("FilterProviderView", 2, "filterProviderView get data is null");
      }
      return;
    }
    setup(paramBundle.a(this.f));
  }
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return;
    }
    paramAdapterView = (QIMFilterCategoryItem)((FilterCategory)this.jdField_a_of_type_JavaUtilArrayList.get(b())).jdField_a_of_type_JavaUtilList.get(paramInt);
    if (paramAdapterView.d())
    {
      WeishiGuideUtils.a(this.jdField_a_of_type_AndroidContentContext, paramAdapterView);
      return;
    }
    getContext();
    VideoFilterTools.a().a(this.f);
    paramView = (CaptureComboManager)QIMManager.a(5);
    Bundle localBundle = new Bundle();
    localBundle.putInt("apply_source", 1);
    localBundle.putInt("capture_scene", this.f);
    paramView.a(paramAdapterView, (Activity)getContext(), localBundle);
    ((QIMPredownManager)QIMManager.a(14)).a(paramAdapterView.jdField_b_of_type_JavaLangString, 1);
    ((CaptureComboManager)QIMManager.a(5)).a(this.f, (Activity)this.jdField_a_of_type_AndroidContentContext);
    k();
  }
  
  public void a(ComboSet paramComboSet, boolean paramBoolean, int paramInt, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QCombo", 2, "fp onComboApply combo " + paramComboSet.a + " filter ");
    }
    d();
  }
  
  public void a(FilterSet paramFilterSet, boolean paramBoolean, int paramInt, Bundle paramBundle)
  {
    this.jdField_a_of_type_DovComQqImCaptureViewProviderView$ProviderViewListener.d(true);
    d();
  }
  
  public void a(VideoFilterTools.ComboFilterData paramComboFilterData)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onComboFilterDataUpdated data:");
      if (paramComboFilterData != null) {
        break label57;
      }
    }
    label57:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("FilterProviderView", 2, bool);
      if (paramComboFilterData != null) {
        setup(paramComboFilterData.a(this.f));
      }
      return;
    }
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager == null) {
      return 0;
    }
    return this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.getCurrentItem();
  }
  
  public void b()
  {
    super.b();
    if (this.jdField_a_of_type_DovComQqImCaptureViewProviderView$ProviderViewListener != null) {
      this.jdField_a_of_type_DovComQqImCaptureViewProviderView$ProviderViewListener.d(false);
    }
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    c(paramBundle);
  }
  
  public void c()
  {
    super.c();
    a(null, null, 0, 0L);
    VideoFilterTools.a().a(true);
    if (QIMManager.a().a(5)) {
      ((CaptureComboManager)QIMManager.a(5)).b(this);
    }
    if (QLog.isColorLevel()) {
      QLog.d("FilterProviderView", 2, "onDestroy");
    }
  }
  
  public void d()
  {
    if (!this.d) {}
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("QCombo", 2, "FilterProviderView updateSelectedState");
      }
      int j = this.jdField_a_of_type_DovComQqImCaptureAdapterFilterProviderPagerAdapter.a.size();
      int i = 0;
      while (i < j)
      {
        int k = this.jdField_a_of_type_DovComQqImCaptureAdapterFilterProviderPagerAdapter.a.keyAt(i);
        ListAdapter localListAdapter = ((GridView)this.jdField_a_of_type_DovComQqImCaptureAdapterFilterProviderPagerAdapter.a.get(k)).a();
        if ((localListAdapter instanceof FilterProviderGridAdapter)) {
          ((FilterProviderGridAdapter)localListAdapter).notifyDataSetChanged();
        }
        i += 1;
      }
    }
  }
  
  public void e()
  {
    super.e();
    CaptureComboManager localCaptureComboManager = (CaptureComboManager)QIMManager.a(5);
    localCaptureComboManager.b(this);
    localCaptureComboManager.a(this);
  }
  
  public void f()
  {
    super.f();
    ((CaptureComboManager)QIMManager.a(5)).b(this);
  }
  
  public void g()
  {
    super.g();
    VideoFilterTools.DataSet localDataSet = this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterTools$DataSet;
    CaptureComboManager localCaptureComboManager = (CaptureComboManager)QIMManager.a(5);
    Object localObject;
    if (localDataSet == null)
    {
      localObject = localCaptureComboManager.a;
      if (localObject != null) {
        localDataSet = ((VideoFilterTools.ComboFilterData)localObject).a(this.f);
      }
    }
    for (;;)
    {
      if ((localDataSet != null) && (localDataSet.jdField_b_of_type_DovComQqImCaptureDataQIMFilterCategoryItem != null))
      {
        localObject = (Activity)getContext();
        localCaptureComboManager.a(localDataSet.jdField_b_of_type_DovComQqImCaptureDataQIMFilterCategoryItem).a((Activity)localObject, this.f);
        VideoFilterTools.a().b(localDataSet.jdField_b_of_type_DovComQqImCaptureDataQIMFilterCategoryItem, (Activity)getContext(), this.f);
        d();
        a(null, null, 0, 0L);
      }
      return;
    }
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.a(paramInt);
  }
  
  public void setup(VideoFilterTools.DataSet paramDataSet)
  {
    if (this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView == null) {
      return;
    }
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterTools$DataSet = paramDataSet;
    this.jdField_a_of_type_JavaUtilArrayList = paramDataSet.jdField_b_of_type_JavaUtilArrayList;
    this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.c(a());
    this.jdField_a_of_type_DovComQqImCaptureAdapterFilterProviderPagerAdapter = new FilterProviderPagerAdapter(this.jdField_a_of_type_AndroidContentContext, this.f);
    this.jdField_a_of_type_DovComQqImCaptureAdapterFilterProviderPagerAdapter.a(this);
    this.jdField_a_of_type_DovComQqImCaptureAdapterFilterProviderPagerAdapter.a(this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setAdapter(this.jdField_a_of_type_DovComQqImCaptureAdapterFilterProviderPagerAdapter);
    this.jdField_a_of_type_DovComQqImCaptureAdapterFilterProviderPagerAdapter.notifyDataSetChanged();
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > this.jdField_a_of_type_Int)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setCurrentItem(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.a(this.jdField_a_of_type_Int);
    }
    this.jdField_a_of_type_DovComQqImCaptureAdapterFilterProviderPagerAdapter.notifyDataSetChanged();
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.view.QIMFilterProviderView
 * JD-Core Version:    0.7.0.1
 */