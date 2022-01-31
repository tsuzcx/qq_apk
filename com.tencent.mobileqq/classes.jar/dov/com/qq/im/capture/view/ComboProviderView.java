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
import bhuw;
import blqr;
import blrx;
import blsa;
import blsd;
import blsj;
import blsn;
import blsq;
import blsx;
import blvi;
import blwl;
import blzx;
import bmau;
import bmaz;
import bmbm;
import bmbn;
import bnhb;
import bnhc;
import bnhd;
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
import xna;
import xsx;

public class ComboProviderView
  extends ProviderView
  implements Handler.Callback, ViewPager.OnPageChangeListener, bhuw, blsa, bmbm
{
  public int a;
  public Handler a;
  blsd jdField_a_of_type_Blsd = new blzx(this);
  public bnhd a;
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
        localObject = (blrx)blqr.a(5);
        if (((this.g == 2) || (this.g == 1)) && (bnhb.a().a[this.g] == null)) {
          bnhb.a().a[this.g] = ((blrx)localObject).a(paramBundle);
        }
        paramBundle = ((blrx)localObject).a;
        if (paramBundle != null) {
          this.jdField_a_of_type_Bnhd = paramBundle.a(this.g);
        }
      }
    }
  }
  
  protected int a()
  {
    return 2131560754;
  }
  
  protected Bundle a()
  {
    Bundle localBundle = new Bundle();
    QIMFilterCategoryItem localQIMFilterCategoryItem1 = bnhb.a().a(this.g);
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
  
  public ArrayList<bmbn> a()
  {
    ArrayList localArrayList = new ArrayList();
    int j = bnhb.a().b();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      bmbn localbmbn = new bmbn();
      localbmbn.jdField_a_of_type_JavaLangString = ((FilterCategory)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_JavaLangString;
      bnhb.a();
      localbmbn.jdField_a_of_type_Boolean = bnhb.a(2, ((FilterCategory)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Int, "");
      localArrayList.add(localbmbn);
      if ((j != -1) && (j == ((FilterCategory)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Int))
      {
        this.jdField_a_of_type_Int = i;
        bnhb.a().a(7, 0, null);
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
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.unRegistObserver(this.jdField_a_of_type_Blsd);
    }
    if (blqr.a().a(5)) {
      ((blrx)blqr.a(5)).b(this);
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
    bnhb.a().a(2, ((FilterCategory)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Int, "");
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
    label105:
    if (i < this.jdField_a_of_type_JavaUtilArrayList.size()) {
      if ((paramInt != -1) && (((FilterCategory)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Int == paramInt)) {
        paramInt = i;
      }
    }
    for (;;)
    {
      label144:
      a().a(paramInt);
      Object localObject = (FilterCategory)this.jdField_a_of_type_JavaUtilArrayList.get(b());
      i = 0;
      label171:
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
          xsx.a(this.jdField_a_of_type_AndroidContentContext, paramString1);
          return;
          if ((paramString1 != null) && (paramString1.equals(((FilterCategory)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_JavaLangString)))
          {
            paramInt = i;
            break label144;
          }
          i += 1;
          break label105;
          i += 1;
          break label171;
        }
        postDelayed(new ComboProviderView.2(this, i), 500L);
        paramString2 = (blrx)blqr.a(5);
        localObject = new Bundle();
        ((Bundle)localObject).putInt("apply_source", 1);
        ((Bundle)localObject).putInt("capture_scene", this.g);
        blsn localblsn = paramString2.a(paramString1);
        if ((localblsn.jdField_a_of_type_Int == 1) || (localblsn.jdField_a_of_type_Int == 2)) {
          bmaz.a(localblsn).a();
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
    for (this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager = ((QQViewPager)LayoutInflater.from(getContext()).inflate(2131560754, this, false));; this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager = ((QQViewPager)this.jdField_a_of_type_AndroidViewView))
    {
      this.jdField_a_of_type_DovComQqImCaptureAdapterComboProviderPagerAdapter = new ComboProviderPagerAdapter(this.jdField_a_of_type_AndroidContentContext, this.g);
      this.jdField_a_of_type_DovComQqImCaptureAdapterComboProviderPagerAdapter.a(this);
      this.jdField_a_of_type_DovComQqImCaptureAdapterComboProviderPagerAdapter.a(new ArrayList());
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setOnPageChangeListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setAdapter(this.jdField_a_of_type_DovComQqImCaptureAdapterComboProviderPagerAdapter);
      a(this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager);
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.registObserver(this.jdField_a_of_type_Blsd);
      paramBundle = (blrx)blqr.a(5);
      paramBundle.a(this);
      paramBundle.a().a(this.g);
      if (QLog.isColorLevel()) {
        QLog.d("QCombo", 2, "ComboProviderView onCreate");
      }
      paramBundle = paramBundle.a;
      if (paramBundle != null) {
        setup(paramBundle.a(this.g));
      }
      paramBundle = (blvi)blqr.a().c(4);
      paramBundle.i();
      paramBundle.a(true, (Activity)getContext());
      return;
    }
  }
  
  public void a(blsn paramblsn) {}
  
  public void a(blsn paramblsn, boolean paramBoolean, int paramInt, Bundle paramBundle)
  {
    g();
  }
  
  public void a(blsq paramblsq, boolean paramBoolean, int paramInt, Bundle paramBundle) {}
  
  public void a(blsx paramblsx, boolean paramBoolean, int paramInt, Bundle paramBundle) {}
  
  public void a(bnhc parambnhc)
  {
    setup(parambnhc.a(this.g));
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
    if (this.jdField_a_of_type_Bnhd != null)
    {
      blrx localblrx = (blrx)blqr.a(5);
      Activity localActivity = (Activity)getContext();
      bnhd localbnhd = localblrx.a.a(this.g);
      if (localbnhd.jdField_a_of_type_DovComQqImCaptureDataQIMFilterCategoryItem != null) {
        localblrx.a(localbnhd.jdField_a_of_type_DovComQqImCaptureDataQIMFilterCategoryItem).a(localActivity, this.g);
      }
      bnhb.a().a(localbnhd.jdField_a_of_type_DovComQqImCaptureDataQIMFilterCategoryItem, localActivity, this.g);
      g();
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
    QIMFilterCategoryItem localQIMFilterCategoryItem = ((blrx)blqr.a(5)).a().jdField_a_of_type_DovComQqImCaptureDataQIMFilterCategoryItem;
    if (localQIMFilterCategoryItem != null) {
      a(localQIMFilterCategoryItem);
    }
  }
  
  public void e()
  {
    super.e();
    blrx localblrx = (blrx)blqr.a(5);
    if (localblrx.a().c)
    {
      localblrx.a().c = false;
      ((QIMProviderContainerView)((Activity)getContext()).findViewById(2131372385)).b(0);
    }
    g();
  }
  
  public void f()
  {
    bnhb.a();
    bnhb.a(true);
    super.f();
    if (blqr.a().a(5)) {
      ((blrx)blqr.a(5)).a(this.g, (Activity)getContext());
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
      xsx.a(this.jdField_a_of_type_AndroidContentContext, paramAdapterView);
    }
    do
    {
      return;
      if ((paramLong > 0L) && (this.jdField_a_of_type_Bmau != null)) {
        this.jdField_a_of_type_Bmau.a(-1, paramAdapterView);
      }
      paramView = (blrx)blqr.a(5);
      ((blwl)blqr.a(14)).a(paramAdapterView.jdField_a_of_type_JavaLangString, 0);
      localObject = paramAdapterView.jdField_a_of_type_JavaLangString;
    } while (paramView.a().a((String)localObject, getContext()));
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("apply_source", 1);
    ((Bundle)localObject).putInt("capture_scene", this.g);
    blsn localblsn = paramView.a(paramAdapterView);
    if ((localblsn.jdField_a_of_type_Int == 1) || (localblsn.jdField_a_of_type_Int == 2)) {
      bmaz.a(localblsn).a();
    }
    paramView.a(paramAdapterView, (Activity)getContext(), (Bundle)localObject);
    if ((xna.a().b() == 22) && (paramAdapterView.f != null) && (paramAdapterView.f.isEmpty())) {
      LpReportInfo_pf00064.allReport(680, 6, 1);
    }
    if ((xna.a().b() == 22) && (paramAdapterView.f != null) && (!paramAdapterView.f.isEmpty())) {
      LpReportInfo_pf00064.allReport(680, 6, 2);
    }
    g();
    if (QLog.isColorLevel()) {
      QLog.i("QCombo", 2, "onItemClick combo " + i + "," + paramInt + ", combo " + localblsn);
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
  
  public void setup(bnhd parambnhd)
  {
    this.jdField_a_of_type_Bnhd = parambnhd;
    this.jdField_a_of_type_JavaUtilArrayList = parambnhd.jdField_a_of_type_JavaUtilArrayList;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.capture.view.ComboProviderView
 * JD-Core Version:    0.7.0.1
 */