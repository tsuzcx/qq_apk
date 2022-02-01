package dov.com.qq.im.capture.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListAdapter;
import bivb;
import bogd;
import bohj;
import bohm;
import bohp;
import bohv;
import bohz;
import boic;
import boij;
import bojs;
import boki;
import bonu;
import boop;
import boov;
import boph;
import bopi;
import bpjt;
import bpju;
import bpjv;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.widget.bounce.BounceViewPager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.GridView;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import dov.com.qq.im.capture.adapter.ComboProviderGridAdapter;
import dov.com.qq.im.capture.adapter.ComboProviderPagerAdapter;
import dov.com.qq.im.capture.data.FilterCategory;
import dov.com.qq.im.capture.data.QIMFilterCategoryItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import yzz;
import zfn;

public class ComboProviderView
  extends ProviderView
  implements Handler.Callback, bivb, bohm, boph, AdapterView.OnItemClickListener
{
  public int a;
  public Handler a;
  bohp jdField_a_of_type_Bohp = new bonu(this);
  public bpjv a;
  BounceViewPager jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager;
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
        localObject = (bohj)bogd.a(5);
        if (((this.g == 2) || (this.g == 1)) && (bpjt.a().a[this.g] == null)) {
          bpjt.a().a[this.g] = ((bohj)localObject).a(paramBundle);
        }
        paramBundle = ((bohj)localObject).a;
        if (paramBundle != null) {
          this.jdField_a_of_type_Bpjv = paramBundle.a(this.g);
        }
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
    int j = bpjt.a().b();
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
        bpjt.a().a(7, 0, null);
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
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.unRegistObserver(this.jdField_a_of_type_Bohp);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.b(this);
    }
    if (bogd.a().a(5)) {
      ((bohj)bogd.a(5)).b(this);
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
    label100:
    if (i < this.jdField_a_of_type_JavaUtilArrayList.size()) {
      if ((paramInt != -1) && (((FilterCategory)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Int == paramInt)) {
        paramInt = i;
      }
    }
    for (;;)
    {
      label139:
      a().onTabChecked(paramInt);
      Object localObject = (FilterCategory)this.jdField_a_of_type_JavaUtilArrayList.get(b());
      i = 0;
      label166:
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
          zfn.a(this.jdField_a_of_type_AndroidContentContext, paramString1);
          return;
          if ((paramString1 != null) && (paramString1.equals(((FilterCategory)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_JavaLangString)))
          {
            paramInt = i;
            break label139;
          }
          i += 1;
          break label100;
          i += 1;
          break label166;
        }
        postDelayed(new ComboProviderView.2(this, i), 500L);
        paramString2 = (bohj)bogd.a(5);
        localObject = new Bundle();
        ((Bundle)localObject).putInt("apply_source", 1);
        ((Bundle)localObject).putInt("capture_scene", this.g);
        bohz localbohz = paramString2.a(paramString1);
        if ((localbohz.jdField_a_of_type_Int == 1) || (localbohz.jdField_a_of_type_Int == 2)) {
          boov.a(localbohz).a();
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
    for (this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager = ((BounceViewPager)LayoutInflater.from(getContext()).inflate(2131560921, this, false));; this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager = ((BounceViewPager)this.jdField_a_of_type_AndroidViewView))
    {
      this.jdField_a_of_type_DovComQqImCaptureAdapterComboProviderPagerAdapter = new ComboProviderPagerAdapter(this.jdField_a_of_type_AndroidContentContext, this.g);
      this.jdField_a_of_type_DovComQqImCaptureAdapterComboProviderPagerAdapter.a(this);
      this.jdField_a_of_type_DovComQqImCaptureAdapterComboProviderPagerAdapter.a(new ArrayList());
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.a(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.setAdapter(this.jdField_a_of_type_DovComQqImCaptureAdapterComboProviderPagerAdapter);
      a(this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager);
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.registObserver(this.jdField_a_of_type_Bohp);
      paramBundle = (bohj)bogd.a(5);
      paramBundle.a(this);
      paramBundle.a().a(this.g);
      if (QLog.isColorLevel()) {
        QLog.d("QCombo", 2, "ComboProviderView onCreate");
      }
      paramBundle = paramBundle.a;
      if (paramBundle != null) {
        setup(paramBundle.a(this.g));
      }
      paramBundle = (bojs)bogd.a().c(4);
      paramBundle.forceInit();
      paramBundle.a(true, (Activity)getContext());
      return;
    }
  }
  
  public void a(bohz parambohz) {}
  
  public void a(bohz parambohz, boolean paramBoolean, int paramInt, Bundle paramBundle)
  {
    g();
  }
  
  public void a(boic paramboic, boolean paramBoolean, int paramInt, Bundle paramBundle) {}
  
  public void a(boij paramboij, boolean paramBoolean, int paramInt, Bundle paramBundle) {}
  
  public void a(bpju parambpju)
  {
    setup(parambpju.a(this.g));
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
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.getCurrentItem() != i) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.setCurrentItem(i);
      }
      Iterator localIterator = ((FilterCategory)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_JavaUtilList.iterator();
      i = j;
      for (;;)
      {
        if ((!localIterator.hasNext()) || (((QIMFilterCategoryItem)localIterator.next()).jdField_a_of_type_JavaLangString.equals(paramQIMFilterCategoryItem.jdField_a_of_type_JavaLangString)))
        {
          paramQIMFilterCategoryItem = this.jdField_a_of_type_DovComQqImCaptureAdapterComboProviderPagerAdapter.a(this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.getCurrentItem());
          if (paramQIMFilterCategoryItem != null)
          {
            paramQIMFilterCategoryItem.setSelection(i);
            ((ComboProviderGridAdapter)paramQIMFilterCategoryItem.getAdapter()).a();
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
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager == null) {
      return 0;
    }
    return this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.getCurrentItem();
  }
  
  public void b()
  {
    super.b();
    if (this.jdField_a_of_type_Bpjv != null)
    {
      bohj localbohj = (bohj)bogd.a(5);
      Activity localActivity = (Activity)getContext();
      bpjv localbpjv = localbohj.a.a(this.g);
      if (localbpjv.jdField_a_of_type_DovComQqImCaptureDataQIMFilterCategoryItem != null) {
        localbohj.a(localbpjv.jdField_a_of_type_DovComQqImCaptureDataQIMFilterCategoryItem).a(localActivity, this.g);
      }
      bpjt.a().a(localbpjv.jdField_a_of_type_DovComQqImCaptureDataQIMFilterCategoryItem, localActivity, this.g);
      g();
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
    QIMFilterCategoryItem localQIMFilterCategoryItem = ((bohj)bogd.a(5)).a().jdField_a_of_type_DovComQqImCaptureDataQIMFilterCategoryItem;
    if (localQIMFilterCategoryItem != null) {
      a(localQIMFilterCategoryItem);
    }
  }
  
  public void e()
  {
    super.e();
    bohj localbohj = (bohj)bogd.a(5);
    if (localbohj.a().c)
    {
      localbohj.a().c = false;
      ((QIMProviderContainerView)((Activity)getContext()).findViewById(2131373270)).b(0);
    }
    g();
  }
  
  public void f()
  {
    bpjt.a();
    bpjt.a(true);
    super.f();
    if (bogd.a().a(5)) {
      ((bohj)bogd.a(5)).a(this.g, (Activity)getContext());
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
        ListAdapter localListAdapter = ((GridView)this.jdField_a_of_type_DovComQqImCaptureAdapterComboProviderPagerAdapter.a.get(k)).getAdapter();
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
      zfn.a(this.jdField_a_of_type_AndroidContentContext, paramAdapterView);
    }
    do
    {
      do
      {
        return;
        if ((paramLong > 0L) && (this.jdField_a_of_type_Boop != null)) {
          this.jdField_a_of_type_Boop.a(-1, paramAdapterView);
        }
        paramView = (bohj)bogd.a(5);
        ((boki)bogd.a(14)).a(paramAdapterView.jdField_a_of_type_JavaLangString, 0);
        localObject = paramAdapterView.jdField_a_of_type_JavaLangString;
      } while (paramView.a().a((String)localObject, getContext()));
      Object localObject = new Bundle();
      ((Bundle)localObject).putInt("apply_source", 1);
      ((Bundle)localObject).putInt("capture_scene", this.g);
      bohz localbohz = paramView.a(paramAdapterView);
      if ((localbohz.jdField_a_of_type_Int == 1) || (localbohz.jdField_a_of_type_Int == 2)) {
        boov.a(localbohz).a();
      }
      paramView.a(paramAdapterView, (Activity)getContext(), (Bundle)localObject);
      if ((yzz.a().b() == 22) && (paramAdapterView.f != null) && (paramAdapterView.f.isEmpty())) {
        LpReportInfo_pf00064.allReport(680, 6, 1);
      }
      if ((yzz.a().b() == 22) && (paramAdapterView.f != null) && (!paramAdapterView.f.isEmpty())) {
        LpReportInfo_pf00064.allReport(680, 6, 2);
      }
      g();
      if (QLog.isColorLevel()) {
        QLog.i("QCombo", 2, "onItemClick combo " + i + "," + paramInt + ", combo " + localbohz);
      }
    } while (!QLog.isColorLevel());
    QLog.i("QCombo", 2, "onItemClick state = " + paramAdapterView);
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
    this.jdField_a_of_type_Bpjv = parambpjv;
    this.jdField_a_of_type_JavaUtilArrayList = parambpjv.jdField_a_of_type_JavaUtilArrayList;
    this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.initTabItemsWithRedDot(a());
    this.jdField_a_of_type_DovComQqImCaptureAdapterComboProviderPagerAdapter = new ComboProviderPagerAdapter(this.jdField_a_of_type_AndroidContentContext, this.g);
    this.jdField_a_of_type_DovComQqImCaptureAdapterComboProviderPagerAdapter.a(this);
    this.jdField_a_of_type_DovComQqImCaptureAdapterComboProviderPagerAdapter.a(this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.setAdapter(this.jdField_a_of_type_DovComQqImCaptureAdapterComboProviderPagerAdapter);
    this.jdField_a_of_type_DovComQqImCaptureAdapterComboProviderPagerAdapter.notifyDataSetChanged();
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > this.jdField_a_of_type_Int)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.setCurrentItem(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.onTabChecked(this.jdField_a_of_type_Int);
    }
    g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.capture.view.ComboProviderView
 * JD-Core Version:    0.7.0.1
 */