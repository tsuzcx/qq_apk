package dov.com.qq.im.capture.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListAdapter;
import bljm;
import bplq;
import bpmw;
import bpmz;
import bpnc;
import bpni;
import bpnm;
import bpnp;
import bpnw;
import bpqh;
import bprk;
import bpuw;
import bpvt;
import bpvy;
import bpwl;
import bpwm;
import bqzz;
import braa;
import brab;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.GridView;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import dov.com.qq.im.capture.adapter.ComboProviderGridAdapter;
import dov.com.qq.im.capture.adapter.ComboProviderPagerAdapter;
import dov.com.qq.im.capture.data.FilterCategory;
import dov.com.qq.im.capture.data.QIMFilterCategoryItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import zkg;
import zqd;

public class ComboProviderView
  extends ProviderView
  implements Handler.Callback, ViewPager.OnPageChangeListener, bljm, bpmz, bpwl
{
  public int a;
  public Handler a;
  bpnc jdField_a_of_type_Bpnc = new bpuw(this);
  public brab a;
  QQViewPager jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager;
  ComboProviderPagerAdapter jdField_a_of_type_DovComQqImCaptureAdapterComboProviderPagerAdapter;
  ArrayList<FilterCategory> jdField_a_of_type_JavaUtilArrayList;
  
  public ComboProviderView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  }
  
  private void c(Bundle paramBundle)
  {
    Object localObject = null;
    if (paramBundle != null) {
      localObject = paramBundle.getBundle(ComboProviderView.class.getSimpleName());
    }
    if (localObject != null)
    {
      paramBundle = (QIMFilterCategoryItem)((Bundle)localObject).getParcelable("select_filter_item");
      if (paramBundle != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ComboProviderView", 2, "restore " + paramBundle.jdField_a_of_type_JavaLangString);
        }
        localObject = (bpmw)bplq.a(5);
        if (((this.g == 2) || (this.g == 1)) && (bqzz.a().a[this.g] == null)) {
          bqzz.a().a[this.g] = ((bpmw)localObject).a(paramBundle);
        }
        paramBundle = ((bpmw)localObject).a;
        if (paramBundle != null) {
          this.jdField_a_of_type_Brab = paramBundle.a(this.g);
        }
      }
    }
  }
  
  protected int a()
  {
    return 2131560990;
  }
  
  protected Bundle a()
  {
    Bundle localBundle = new Bundle();
    QIMFilterCategoryItem localQIMFilterCategoryItem1 = bqzz.a().a(this.g);
    if (localQIMFilterCategoryItem1 != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ComboProviderView", 2, "save " + localQIMFilterCategoryItem1.jdField_a_of_type_JavaLangString);
      }
      localBundle.putParcelable("select_filter_item", localQIMFilterCategoryItem1);
      if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) && (b() >= 0) && (b() < this.jdField_a_of_type_JavaUtilArrayList.size()))
      {
        FilterCategory localFilterCategory = (FilterCategory)this.jdField_a_of_type_JavaUtilArrayList.get(b());
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
  
  public ArrayList<bpwm> a()
  {
    ArrayList localArrayList = new ArrayList();
    int j = bqzz.a().b();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      bpwm localbpwm = new bpwm();
      localbpwm.jdField_a_of_type_JavaLangString = ((FilterCategory)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_JavaLangString;
      bqzz.a();
      localbpwm.jdField_a_of_type_Boolean = bqzz.a(2, ((FilterCategory)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Int, "");
      localArrayList.add(localbpwm);
      if ((j != -1) && (j == ((FilterCategory)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Int))
      {
        this.jdField_a_of_type_Int = i;
        bqzz.a().a(7, 0, null);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.unRegistObserver(this.jdField_a_of_type_Bpnc);
    }
    if (bplq.a().a(5)) {
      ((bpmw)bplq.a(5)).b(this);
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ComboProviderView", 2, "category= " + paramInt + " categoryName= " + paramString1 + ",itemId=" + paramString2);
    }
    if (this.jdField_a_of_type_JavaUtilArrayList == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ComboProviderView", 2, "selectCategoryAndItem when mTagInfos null " + paramInt + " " + paramString2);
      }
      return;
    }
    int i = 0;
    label103:
    if (i < this.jdField_a_of_type_JavaUtilArrayList.size()) {
      if ((paramInt != -1) && (((FilterCategory)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Int == paramInt)) {
        paramInt = i;
      }
    }
    for (;;)
    {
      label142:
      a().a(paramInt);
      Object localObject = (FilterCategory)this.jdField_a_of_type_JavaUtilArrayList.get(b());
      i = 0;
      label169:
      if (i < ((FilterCategory)localObject).jdField_a_of_type_JavaUtilList.size())
      {
        paramString1 = (QIMFilterCategoryItem)((FilterCategory)localObject).jdField_a_of_type_JavaUtilList.get(i);
        if (!paramString1.jdField_a_of_type_JavaLangString.equals(paramString2)) {}
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ComboProviderView", 2, "itemInfo= " + paramString1 + ",index=" + paramInt + ",pos=" + i);
        }
        if (paramString1 == null) {
          break;
        }
        if (paramString1.f())
        {
          zqd.a(this.jdField_a_of_type_AndroidContentContext, paramString1);
          return;
          if ((paramString1 != null) && (paramString1.equals(((FilterCategory)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_JavaLangString)))
          {
            paramInt = i;
            break label142;
          }
          i += 1;
          break label103;
          i += 1;
          break label169;
        }
        postDelayed(new ComboProviderView.2(this, i), 500L);
        paramString2 = (bpmw)bplq.a(5);
        localObject = new Bundle();
        ((Bundle)localObject).putInt("apply_source", 1);
        ((Bundle)localObject).putInt("capture_scene", this.g);
        bpnm localbpnm = paramString2.a(paramString1);
        if ((localbpnm.jdField_a_of_type_Int == 1) || (localbpnm.jdField_a_of_type_Int == 2)) {
          bpvy.a(localbpnm).a();
        }
        paramString2.a(paramString1, (Activity)getContext(), (Bundle)localObject);
        g();
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("ComboProviderView", 2, "selectFilterItem state = " + paramString1);
        return;
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
    for (this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager = ((QQViewPager)LayoutInflater.from(getContext()).inflate(2131560990, this, false));; this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager = ((QQViewPager)this.jdField_a_of_type_AndroidViewView))
    {
      this.jdField_a_of_type_DovComQqImCaptureAdapterComboProviderPagerAdapter = new ComboProviderPagerAdapter(this.jdField_a_of_type_AndroidContentContext, this.g);
      this.jdField_a_of_type_DovComQqImCaptureAdapterComboProviderPagerAdapter.a(this);
      this.jdField_a_of_type_DovComQqImCaptureAdapterComboProviderPagerAdapter.a(new ArrayList());
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setOnPageChangeListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setAdapter(this.jdField_a_of_type_DovComQqImCaptureAdapterComboProviderPagerAdapter);
      a(this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager);
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.registObserver(this.jdField_a_of_type_Bpnc);
      paramBundle = (bpmw)bplq.a(5);
      paramBundle.a(this);
      paramBundle.a().a(this.g);
      if (QLog.isColorLevel()) {
        QLog.d("QCombo", 2, "ComboProviderView onCreate");
      }
      paramBundle = paramBundle.a;
      if (paramBundle != null) {
        setup(paramBundle.a(this.g));
      }
      paramBundle = (bpqh)bplq.a().c(4);
      paramBundle.e();
      paramBundle.a(true, (Activity)getContext());
      return;
    }
  }
  
  public void a(bpnm parambpnm) {}
  
  public void a(bpnm parambpnm, boolean paramBoolean, int paramInt, Bundle paramBundle)
  {
    g();
  }
  
  public void a(bpnp parambpnp, boolean paramBoolean, int paramInt, Bundle paramBundle) {}
  
  public void a(bpnw parambpnw, boolean paramBoolean, int paramInt, Bundle paramBundle) {}
  
  public void a(braa parambraa)
  {
    setup(parambraa.a(this.g));
  }
  
  public void a(QIMFilterCategoryItem paramQIMFilterCategoryItem)
  {
    int j = 0;
    int k = paramQIMFilterCategoryItem.jdField_a_of_type_Int;
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilArrayList.size()) {
      if (((FilterCategory)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Int != k) {}
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.getCurrentItem() != i) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setCurrentItem(i);
      }
      Iterator localIterator = ((FilterCategory)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_JavaUtilList.iterator();
      i = j;
      for (;;)
      {
        if ((!localIterator.hasNext()) || (((QIMFilterCategoryItem)localIterator.next()).jdField_a_of_type_JavaLangString.equals(paramQIMFilterCategoryItem.jdField_a_of_type_JavaLangString)))
        {
          paramQIMFilterCategoryItem = this.jdField_a_of_type_DovComQqImCaptureAdapterComboProviderPagerAdapter.a(this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.getCurrentItem());
          if (paramQIMFilterCategoryItem != null)
          {
            paramQIMFilterCategoryItem.setSelection(i);
            ((ComboProviderGridAdapter)paramQIMFilterCategoryItem.a()).a();
          }
          return;
          i += 1;
          break;
        }
        i += 1;
      }
      i = 0;
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
    if (this.jdField_a_of_type_Brab != null)
    {
      bpmw localbpmw = (bpmw)bplq.a(5);
      Activity localActivity = (Activity)getContext();
      brab localbrab = localbpmw.a.a(this.g);
      if (localbrab.jdField_a_of_type_DovComQqImCaptureDataQIMFilterCategoryItem != null) {
        localbpmw.a(localbrab.jdField_a_of_type_DovComQqImCaptureDataQIMFilterCategoryItem).a(localActivity, this.g);
      }
      bqzz.a().a(localbrab.jdField_a_of_type_DovComQqImCaptureDataQIMFilterCategoryItem, localActivity, this.g);
      g();
    }
  }
  
  public void b(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return;
    }
    if (paramInt != 0) {
      k();
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setCurrentItem(paramInt);
    bqzz.a().a(2, ((FilterCategory)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Int, "");
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    c(paramBundle);
  }
  
  public void c()
  {
    super.c();
    QIMFilterCategoryItem localQIMFilterCategoryItem = ((bpmw)bplq.a(5)).a().jdField_a_of_type_DovComQqImCaptureDataQIMFilterCategoryItem;
    if (localQIMFilterCategoryItem != null) {
      a(localQIMFilterCategoryItem);
    }
  }
  
  public void e()
  {
    super.e();
    bpmw localbpmw = (bpmw)bplq.a(5);
    if (localbpmw.a().c)
    {
      localbpmw.a().c = false;
      ((QIMProviderContainerView)((Activity)getContext()).findViewById(2131373091)).b(0);
    }
    g();
  }
  
  public void f()
  {
    bqzz.a();
    bqzz.a(true);
    super.f();
    if (bplq.a().a(5)) {
      ((bpmw)bplq.a(5)).a(this.g, (Activity)getContext());
    }
  }
  
  public void g()
  {
    if (!this.d) {}
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("QCombo", 2, "ComboProviderView updateComboState");
      }
      int j = this.jdField_a_of_type_DovComQqImCaptureAdapterComboProviderPagerAdapter.a.size();
      int i = 0;
      while (i < j)
      {
        int k = this.jdField_a_of_type_DovComQqImCaptureAdapterComboProviderPagerAdapter.a.keyAt(i);
        ListAdapter localListAdapter = ((GridView)this.jdField_a_of_type_DovComQqImCaptureAdapterComboProviderPagerAdapter.a.get(k)).a();
        if ((localListAdapter instanceof ComboProviderGridAdapter)) {
          ((ComboProviderGridAdapter)localListAdapter).notifyDataSetChanged();
        }
        i += 1;
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    int i = b();
    paramAdapterView = (QIMFilterCategoryItem)((FilterCategory)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_JavaUtilList.get(paramInt);
    if (paramAdapterView.f()) {
      zqd.a(this.jdField_a_of_type_AndroidContentContext, paramAdapterView);
    }
    do
    {
      return;
      if ((paramLong > 0L) && (this.jdField_a_of_type_Bpvt != null)) {
        this.jdField_a_of_type_Bpvt.a(-1, paramAdapterView);
      }
      paramView = (bpmw)bplq.a(5);
      ((bprk)bplq.a(14)).a(paramAdapterView.jdField_a_of_type_JavaLangString, 0);
      localObject = paramAdapterView.jdField_a_of_type_JavaLangString;
    } while (paramView.a().a((String)localObject, getContext()));
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("apply_source", 1);
    ((Bundle)localObject).putInt("capture_scene", this.g);
    bpnm localbpnm = paramView.a(paramAdapterView);
    if ((localbpnm.jdField_a_of_type_Int == 1) || (localbpnm.jdField_a_of_type_Int == 2)) {
      bpvy.a(localbpnm).a();
    }
    paramView.a(paramAdapterView, (Activity)getContext(), (Bundle)localObject);
    if ((zkg.a().b() == 22) && (paramAdapterView.f != null) && (paramAdapterView.f.isEmpty())) {
      LpReportInfo_pf00064.allReport(680, 6, 1);
    }
    if ((zkg.a().b() == 22) && (paramAdapterView.f != null) && (!paramAdapterView.f.isEmpty())) {
      LpReportInfo_pf00064.allReport(680, 6, 2);
    }
    g();
    if (QLog.isColorLevel()) {
      QLog.i("QCombo", 2, "onItemClick combo " + i + "," + paramInt + ", combo " + localbpnm);
    }
    if (QLog.isColorLevel()) {
      QLog.i("QCombo", 2, "onItemClick state = " + paramAdapterView);
    }
    k();
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.a(paramInt);
  }
  
  public void setup(brab parambrab)
  {
    this.jdField_a_of_type_Brab = parambrab;
    this.jdField_a_of_type_JavaUtilArrayList = parambrab.jdField_a_of_type_JavaUtilArrayList;
    this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.a(a());
    this.jdField_a_of_type_DovComQqImCaptureAdapterComboProviderPagerAdapter = new ComboProviderPagerAdapter(this.jdField_a_of_type_AndroidContentContext, this.g);
    this.jdField_a_of_type_DovComQqImCaptureAdapterComboProviderPagerAdapter.a(this);
    this.jdField_a_of_type_DovComQqImCaptureAdapterComboProviderPagerAdapter.a(this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setAdapter(this.jdField_a_of_type_DovComQqImCaptureAdapterComboProviderPagerAdapter);
    this.jdField_a_of_type_DovComQqImCaptureAdapterComboProviderPagerAdapter.notifyDataSetChanged();
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > this.jdField_a_of_type_Int)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setCurrentItem(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.a(this.jdField_a_of_type_Int);
    }
    g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.capture.view.ComboProviderView
 * JD-Core Version:    0.7.0.1
 */