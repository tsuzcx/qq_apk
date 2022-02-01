package dov.com.qq.im.capture.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListAdapter;
import bivb;
import bmvb;
import bogd;
import bogj;
import bohj;
import bohm;
import bohn;
import bohz;
import boic;
import boij;
import boje;
import boki;
import boop;
import boph;
import bopi;
import bpjt;
import bpju;
import bpjv;
import com.tencent.mobileqq.widget.bounce.BounceViewPager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.GridView;
import dov.com.qq.im.capture.adapter.FilterProviderPagerAdapter;
import dov.com.qq.im.capture.data.FilterCategory;
import dov.com.qq.im.capture.data.QIMFilterCategoryItem;
import java.util.ArrayList;
import java.util.List;
import zfn;

public class QIMFilterProviderView
  extends ProviderView
  implements bivb, bohm, boph, AdapterView.OnItemClickListener
{
  public int a;
  public bpjv a;
  BounceViewPager jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager;
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
      if (bpjt.a().a[this.g] != null) {
        bpjt.a().a[this.g].c = 1;
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
    return 2131560921;
  }
  
  public ArrayList<bopi> a()
  {
    ArrayList localArrayList = new ArrayList();
    int j = bpjt.a().a();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      bopi localbopi = new bopi();
      localbopi.jdField_a_of_type_JavaLangString = ((FilterCategory)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_JavaLangString;
      bpjt.a();
      localbopi.jdField_a_of_type_Boolean = bpjt.a(2, ((FilterCategory)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Int, "");
      localArrayList.add(localbopi);
      if ((j != -1) && (j == ((FilterCategory)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Int))
      {
        this.jdField_a_of_type_Int = i;
        bpjt.a().a(5, 0, null);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.b(this);
    }
    bpjt.a();
    bpjt.a(true);
    if (bogd.a().a(5))
    {
      bohj localbohj = (bohj)bogd.a(5);
      localbohj.jdField_a_of_type_ArrayOfBohn[this.g].a();
      localbohj.b(this);
    }
    if (QLog.isColorLevel()) {
      QLog.d("FilterProviderView", 2, "onDestroy");
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.onTabChecked(paramInt);
  }
  
  public void a(int paramInt1, float paramFloat, int paramInt2) {}
  
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
      a().onTabChecked(paramInt);
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
          paramString2 = (bohj)bogd.a(5);
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
    for (this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager = ((BounceViewPager)LayoutInflater.from(getContext()).inflate(2131560921, this, false));; this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager = ((BounceViewPager)this.jdField_a_of_type_AndroidViewView))
    {
      this.jdField_a_of_type_DovComQqImCaptureAdapterFilterProviderPagerAdapter = new FilterProviderPagerAdapter(this.jdField_a_of_type_AndroidContentContext, this.g);
      this.jdField_a_of_type_DovComQqImCaptureAdapterFilterProviderPagerAdapter.a(this);
      this.jdField_a_of_type_DovComQqImCaptureAdapterFilterProviderPagerAdapter.a(new ArrayList());
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.a(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.setAdapter(this.jdField_a_of_type_DovComQqImCaptureAdapterFilterProviderPagerAdapter);
      a(this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager);
      paramBundle = (bohj)bogd.a(5);
      paramBundle.a(this);
      if (QLog.isColorLevel()) {
        QLog.d("QCombo", 2, "FilterProviderView onCreate");
      }
      paramBundle = paramBundle.jdField_a_of_type_Bpju;
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
  
  public void a(bohz parambohz) {}
  
  public void a(bohz parambohz, boolean paramBoolean, int paramInt, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QCombo", 2, "fp onComboApply combo " + parambohz.a + " filter ");
    }
    g();
  }
  
  public void a(boic paramboic, boolean paramBoolean, int paramInt, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Boop != null) {
      this.jdField_a_of_type_Boop.b(true);
    }
    g();
    if (paramBoolean)
    {
      paramboic = (boje)bogd.a().c(8);
      if (this.g != 0) {
        break label58;
      }
    }
    label58:
    for (paramInt = bmvb.b;; paramInt = bmvb.c)
    {
      paramboic.c(paramInt);
      paramboic.d();
      return;
    }
  }
  
  public void a(boij paramboij, boolean paramBoolean, int paramInt, Bundle paramBundle) {}
  
  public void a(bpju parambpju)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onComboFilterDataUpdated data:");
      if (parambpju != null) {
        break label57;
      }
    }
    label57:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("FilterProviderView", 2, bool);
      if (parambpju != null) {
        setup(parambpju.a(this.g));
      }
      return;
    }
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager == null) {
      return 0;
    }
    return this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.getCurrentItem();
  }
  
  public void b()
  {
    super.b();
    bpjv localbpjv = this.jdField_a_of_type_Bpjv;
    bohj localbohj = (bohj)bogd.a(5);
    Object localObject;
    if (localbpjv == null)
    {
      localObject = localbohj.jdField_a_of_type_Bpju;
      if (localObject != null) {
        localbpjv = ((bpju)localObject).a(this.g);
      }
    }
    for (;;)
    {
      if ((localbpjv != null) && (localbpjv.jdField_b_of_type_DovComQqImCaptureDataQIMFilterCategoryItem != null))
      {
        localObject = (Activity)getContext();
        localbohj.a(localbpjv.jdField_b_of_type_DovComQqImCaptureDataQIMFilterCategoryItem).a((Activity)localObject, this.g);
        bpjt.a().b(localbpjv.jdField_b_of_type_DovComQqImCaptureDataQIMFilterCategoryItem, (Activity)getContext(), this.g);
        bpjt.a().a(localbpjv.jdField_b_of_type_DovComQqImCaptureDataQIMFilterCategoryItem, this.g);
        g();
        onItemClick(null, null, 0, 0L);
      }
      return;
    }
  }
  
  public void b(int paramInt) {}
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    c(paramBundle);
  }
  
  public void c()
  {
    super.c();
    if (this.jdField_a_of_type_Boop != null)
    {
      this.jdField_a_of_type_Boop.b(true);
      this.jdField_a_of_type_Boop.c();
    }
    g();
  }
  
  public void d()
  {
    super.d();
    if (this.jdField_a_of_type_Boop != null) {
      this.jdField_a_of_type_Boop.b(false);
    }
  }
  
  public void e()
  {
    super.e();
    ((bohj)bogd.a(5)).a(this);
  }
  
  public void f()
  {
    super.f();
    ((bohj)bogd.a(5)).b(this);
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
        ListAdapter localListAdapter = ((GridView)this.jdField_a_of_type_DovComQqImCaptureAdapterFilterProviderPagerAdapter.a.get(k)).getAdapter();
        if ((localListAdapter instanceof bogj)) {
          ((bogj)localListAdapter).notifyDataSetChanged();
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
        zfn.a(this.jdField_a_of_type_AndroidContentContext, paramAdapterView);
        do
        {
          return;
        } while (this.jdField_a_of_type_JavaUtilArrayList == null);
        paramAdapterView = (QIMFilterCategoryItem)((FilterCategory)this.jdField_a_of_type_JavaUtilArrayList.get(b())).jdField_a_of_type_JavaUtilList.get(paramInt);
      } while (paramAdapterView == null);
    }
    if ((paramLong > 0L) && (this.jdField_a_of_type_Boop != null)) {
      this.jdField_a_of_type_Boop.a(-1, paramAdapterView);
    }
    paramView = (bohj)bogd.a(5);
    Bundle localBundle = new Bundle();
    localBundle.putInt("apply_source", 1);
    localBundle.putInt("capture_scene", this.g);
    paramView.a(paramAdapterView, (Activity)getContext(), localBundle);
    ((boki)bogd.a(14)).a(paramAdapterView.b, 1);
    ((bohj)bogd.a(5)).a(this.g, (Activity)this.jdField_a_of_type_AndroidContentContext);
  }
  
  public void onTabChecked(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.setCurrentItem(paramInt);
    bpjt.a().a(2, ((FilterCategory)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Int, "");
  }
  
  public void setup(bpjv parambpjv)
  {
    if (this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView == null) {
      return;
    }
    this.jdField_a_of_type_Bpjv = parambpjv;
    this.jdField_a_of_type_JavaUtilArrayList = parambpjv.jdField_b_of_type_JavaUtilArrayList;
    this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.initTabItemsWithRedDot(a());
    this.jdField_a_of_type_DovComQqImCaptureAdapterFilterProviderPagerAdapter = new FilterProviderPagerAdapter(this.jdField_a_of_type_AndroidContentContext, this.g);
    this.jdField_a_of_type_DovComQqImCaptureAdapterFilterProviderPagerAdapter.a(this);
    this.jdField_a_of_type_DovComQqImCaptureAdapterFilterProviderPagerAdapter.a(this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.setAdapter(this.jdField_a_of_type_DovComQqImCaptureAdapterFilterProviderPagerAdapter);
    this.jdField_a_of_type_DovComQqImCaptureAdapterFilterProviderPagerAdapter.notifyDataSetChanged();
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > this.jdField_a_of_type_Int)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.setCurrentItem(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.onTabChecked(this.jdField_a_of_type_Int);
    }
    this.jdField_a_of_type_DovComQqImCaptureAdapterFilterProviderPagerAdapter.notifyDataSetChanged();
    g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.capture.view.QIMFilterProviderView
 * JD-Core Version:    0.7.0.1
 */