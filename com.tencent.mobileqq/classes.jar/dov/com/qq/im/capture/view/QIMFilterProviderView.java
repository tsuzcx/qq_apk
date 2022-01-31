package dov.com.qq.im.capture.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListAdapter;
import behi;
import bhey;
import bhfm;
import bhfs;
import bhgs;
import bhgv;
import bhgw;
import bhhh;
import bhhk;
import bhhr;
import bhiu;
import bhlf;
import bhpp;
import bhqh;
import bhqi;
import bjac;
import bjad;
import bjae;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.GridView;
import dov.com.qq.im.capture.adapter.FilterProviderPagerAdapter;
import dov.com.qq.im.capture.data.FilterCategory;
import dov.com.qq.im.capture.data.QIMFilterCategoryItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import vnd;

public class QIMFilterProviderView
  extends ProviderView
  implements ViewPager.OnPageChangeListener, behi, bhgv, bhqh
{
  public int a;
  public bjae a;
  QQViewPager jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager;
  FilterProviderPagerAdapter jdField_a_of_type_DovComQqImCaptureAdapterFilterProviderPagerAdapter;
  public ArrayList<FilterCategory> a;
  
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
      if (bjac.a().a[this.g] != null) {
        bjac.a().a[this.g].c = 1;
      }
      paramBundle = (QIMFilterCategoryItem)localBundle.getParcelable("selected_filter_item");
      if (paramBundle != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("FilterProviderView", 2, "restore " + paramBundle.jdField_a_of_type_JavaLangString);
        }
        paramBundle.c = 1;
      }
    }
  }
  
  protected int a()
  {
    return 2131494987;
  }
  
  protected Bundle a()
  {
    Bundle localBundle = new Bundle();
    QIMFilterCategoryItem localQIMFilterCategoryItem1 = bjac.a().b(this.g);
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
              if ((localQIMFilterCategoryItem1.a() == localQIMFilterCategoryItem2.a()) && (localQIMFilterCategoryItem1.b != null) && (localQIMFilterCategoryItem1.b.equals(localQIMFilterCategoryItem2.b))) {
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
  
  public ArrayList<bhqi> a()
  {
    ArrayList localArrayList = new ArrayList();
    int j = bjac.a().a();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      bhqi localbhqi = new bhqi();
      localbhqi.jdField_a_of_type_JavaLangString = ((FilterCategory)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_JavaLangString;
      bjac.a();
      localbhqi.jdField_a_of_type_Boolean = bjac.a(2, ((FilterCategory)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Int, "");
      localArrayList.add(localbhqi);
      if ((j != -1) && (j == ((FilterCategory)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Int))
      {
        this.jdField_a_of_type_Int = i;
        bjac.a().a(5, 0, null);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public void a()
  {
    super.a();
    bjac.a();
    bjac.a(true);
    if (bhfm.a().a(5))
    {
      bhgs localbhgs = (bhgs)bhfm.a(5);
      localbhgs.jdField_a_of_type_ArrayOfBhgw[this.g].a();
      localbhgs.b(this);
    }
    if (QLog.isColorLevel()) {
      QLog.d("FilterProviderView", 2, "onDestroy");
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
    bjac.a().a(2, ((FilterCategory)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Int, "");
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FilterProviderView", 2, "category= " + paramInt + " categoryName= " + paramString1 + ",itemId=" + paramString2);
    }
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilArrayList.size()) {
      if ((paramInt != -1) && (((FilterCategory)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Int == paramInt)) {
        paramInt = i;
      }
    }
    for (;;)
    {
      label91:
      a().a(paramInt);
      Object localObject = (FilterCategory)this.jdField_a_of_type_JavaUtilArrayList.get(b());
      i = 0;
      label118:
      if (i < ((FilterCategory)localObject).jdField_a_of_type_JavaUtilList.size())
      {
        paramString1 = (QIMFilterCategoryItem)((FilterCategory)localObject).jdField_a_of_type_JavaUtilList.get(i);
        if (!paramString1.jdField_a_of_type_JavaLangString.equals(paramString2)) {}
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("FilterProviderView", 2, "itemInfo= " + paramString1 + ",index=" + paramInt + ",pos=" + i);
        }
        if (paramString1 != null)
        {
          postDelayed(new QIMFilterProviderView.1(this, i), 200L);
          paramString2 = (bhgs)bhfm.a(5);
          localObject = new Bundle();
          ((Bundle)localObject).putInt("apply_source", 1);
          ((Bundle)localObject).putInt("capture_scene", this.g);
          paramString2.a(paramString1, (Activity)getContext(), (Bundle)localObject);
          g();
        }
        return;
        if ((paramString1 != null) && (paramString1.equals(((FilterCategory)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_JavaLangString)))
        {
          paramInt = i;
          break label91;
        }
        i += 1;
        break;
        i += 1;
        break label118;
        i = 0;
        paramString1 = null;
      }
      paramInt = 0;
    }
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.setTabCheckListener(this);
    if (this.jdField_a_of_type_AndroidViewView == null) {}
    for (this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager = ((QQViewPager)LayoutInflater.from(getContext()).inflate(2131494987, this, false));; this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager = ((QQViewPager)this.jdField_a_of_type_AndroidViewView))
    {
      this.jdField_a_of_type_DovComQqImCaptureAdapterFilterProviderPagerAdapter = new FilterProviderPagerAdapter(this.jdField_a_of_type_AndroidContentContext, this.g);
      this.jdField_a_of_type_DovComQqImCaptureAdapterFilterProviderPagerAdapter.a(this);
      this.jdField_a_of_type_DovComQqImCaptureAdapterFilterProviderPagerAdapter.a(new ArrayList());
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setOnPageChangeListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setAdapter(this.jdField_a_of_type_DovComQqImCaptureAdapterFilterProviderPagerAdapter);
      a(this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager);
      paramBundle = (bhgs)bhfm.a(5);
      paramBundle.a(this);
      if (QLog.isColorLevel()) {
        QLog.d("QCombo", 2, "FilterProviderView onCreate");
      }
      paramBundle = paramBundle.jdField_a_of_type_Bjad;
      if (paramBundle != null) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("FilterProviderView", 2, "filterProviderView get data is null");
      }
      return;
    }
    setup(paramBundle.a(this.g));
  }
  
  public void a(bhhh parambhhh) {}
  
  public void a(bhhh parambhhh, boolean paramBoolean, int paramInt, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QCombo", 2, "fp onComboApply combo " + parambhhh.a + " filter ");
    }
    g();
  }
  
  public void a(bhhk parambhhk, boolean paramBoolean, int paramInt, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Bhpp != null) {
      this.jdField_a_of_type_Bhpp.b(true);
    }
    g();
    if (paramBoolean)
    {
      parambhhk = (bhiu)bhfm.a().c(8);
      if (this.g != 0) {
        break label58;
      }
    }
    label58:
    for (paramInt = bhey.b;; paramInt = bhey.c)
    {
      parambhhk.d(paramInt);
      parambhhk.f();
      return;
    }
  }
  
  public void a(bhhr parambhhr, boolean paramBoolean, int paramInt, Bundle paramBundle) {}
  
  public void a(bjad parambjad)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onComboFilterDataUpdated data:");
      if (parambjad != null) {
        break label57;
      }
    }
    label57:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("FilterProviderView", 2, bool);
      if (parambjad != null) {
        setup(parambjad.a(this.g));
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
    bjae localbjae = this.jdField_a_of_type_Bjae;
    bhgs localbhgs = (bhgs)bhfm.a(5);
    Object localObject;
    if (localbjae == null)
    {
      localObject = localbhgs.jdField_a_of_type_Bjad;
      if (localObject != null) {
        localbjae = ((bjad)localObject).a(this.g);
      }
    }
    for (;;)
    {
      if ((localbjae != null) && (localbjae.jdField_b_of_type_DovComQqImCaptureDataQIMFilterCategoryItem != null))
      {
        localObject = (Activity)getContext();
        localbhgs.a(localbjae.jdField_b_of_type_DovComQqImCaptureDataQIMFilterCategoryItem).a((Activity)localObject, this.g);
        bjac.a().b(localbjae.jdField_b_of_type_DovComQqImCaptureDataQIMFilterCategoryItem, (Activity)getContext(), this.g);
        bjac.a().a(localbjae.jdField_b_of_type_DovComQqImCaptureDataQIMFilterCategoryItem, this.g);
        g();
        onItemClick(null, null, 0, 0L);
      }
      return;
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
    if (this.jdField_a_of_type_Bhpp != null)
    {
      this.jdField_a_of_type_Bhpp.b(true);
      this.jdField_a_of_type_Bhpp.i();
    }
    g();
  }
  
  public void d()
  {
    super.d();
    if (this.jdField_a_of_type_Bhpp != null) {
      this.jdField_a_of_type_Bhpp.b(false);
    }
  }
  
  public void e()
  {
    super.e();
    ((bhgs)bhfm.a(5)).a(this);
  }
  
  public void f()
  {
    super.f();
    ((bhgs)bhfm.a(5)).b(this);
  }
  
  public void g()
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
        if ((localListAdapter instanceof bhfs)) {
          ((bhfs)localListAdapter).notifyDataSetChanged();
        }
        i += 1;
      }
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = null;
    if (paramView != null) {
      paramAdapterView = paramView.getTag();
    }
    if ((paramAdapterView != null) && ((paramAdapterView instanceof QIMFilterCategoryItem))) {
      paramAdapterView = (QIMFilterCategoryItem)paramAdapterView;
    }
    while (paramAdapterView.f()) {
      do
      {
        vnd.a(this.jdField_a_of_type_AndroidContentContext, paramAdapterView);
        do
        {
          return;
        } while (this.jdField_a_of_type_JavaUtilArrayList == null);
        paramAdapterView = (QIMFilterCategoryItem)((FilterCategory)this.jdField_a_of_type_JavaUtilArrayList.get(b())).jdField_a_of_type_JavaUtilList.get(paramInt);
      } while (paramAdapterView == null);
    }
    if ((paramLong > 0L) && (this.jdField_a_of_type_Bhpp != null)) {
      this.jdField_a_of_type_Bhpp.a(-1, paramAdapterView);
    }
    paramView = (bhgs)bhfm.a(5);
    Bundle localBundle = new Bundle();
    localBundle.putInt("apply_source", 1);
    localBundle.putInt("capture_scene", this.g);
    paramView.a(paramAdapterView, (Activity)getContext(), localBundle);
    ((bhlf)bhfm.a(14)).a(paramAdapterView.b, 1);
    ((bhgs)bhfm.a(5)).a(this.g, (Activity)this.jdField_a_of_type_AndroidContentContext);
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.a(paramInt);
  }
  
  public void setup(bjae parambjae)
  {
    if (this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView == null) {
      return;
    }
    this.jdField_a_of_type_Bjae = parambjae;
    this.jdField_a_of_type_JavaUtilArrayList = parambjae.jdField_b_of_type_JavaUtilArrayList;
    this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.a(a());
    this.jdField_a_of_type_DovComQqImCaptureAdapterFilterProviderPagerAdapter = new FilterProviderPagerAdapter(this.jdField_a_of_type_AndroidContentContext, this.g);
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
    g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.view.QIMFilterProviderView
 * JD-Core Version:    0.7.0.1
 */