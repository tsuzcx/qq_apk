package dov.com.qq.im.capture.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import android.view.LayoutInflater;
import anyl;
import anym;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.adapter.QIMPtvTemplateAdapter;
import dov.com.qq.im.capture.adapter.QIMPtvTemplateViewPagerAdapter;
import dov.com.qq.im.capture.data.TemplateGroupItem;
import dov.com.qq.im.capture.music.CaptureConfigUpdateObserver;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import dov.com.tencent.mobileqq.shortvideo.QIMPtvTemplateManager;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class QIMPtvTemplateProviderView
  extends ProviderView
  implements ViewPager.OnPageChangeListener, QIMSlidingTabView.IOnTabCheckListener
{
  int jdField_a_of_type_Int = 1;
  public QQViewPager a;
  public QIMPtvTemplateViewPagerAdapter a;
  public CaptureConfigUpdateObserver a;
  QIMPtvTemplateManager jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager;
  List jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
  private boolean jdField_a_of_type_Boolean;
  
  public QIMPtvTemplateProviderView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_DovComQqImCaptureMusicCaptureConfigUpdateObserver = new anyl(this);
  }
  
  private ArrayList a()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager != null) {}
    for (int i = this.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager.a();; i = -1)
    {
      int j = 0;
      while (j < this.jdField_a_of_type_JavaUtilList.size())
      {
        TemplateGroupItem localTemplateGroupItem = (TemplateGroupItem)this.jdField_a_of_type_JavaUtilList.get(j);
        if ((i != -1) && (i == localTemplateGroupItem.jdField_a_of_type_Int))
        {
          this.jdField_a_of_type_Int = j;
          this.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager.a(5, 0, null);
        }
        QIMSlidingTabView.TabIcon localTabIcon = new QIMSlidingTabView.TabIcon();
        localTabIcon.jdField_a_of_type_JavaLangString = localTemplateGroupItem.jdField_a_of_type_JavaLangString;
        if (this.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager != null) {
          localTabIcon.jdField_a_of_type_Boolean = this.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager.a(2, localTemplateGroupItem.jdField_a_of_type_Int, "");
        }
        localArrayList.add(localTabIcon);
        j += 1;
      }
      return localArrayList;
    }
  }
  
  protected int a()
  {
    return 2130970155;
  }
  
  protected Bundle a()
  {
    Bundle localBundle = new Bundle();
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager != null)
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.getCurrentItem();
      if ((this.jdField_a_of_type_JavaUtilList != null) && (i >= 0) && (i < this.jdField_a_of_type_JavaUtilList.size()))
      {
        TemplateGroupItem localTemplateGroupItem = (TemplateGroupItem)this.jdField_a_of_type_JavaUtilList.get(i);
        String str = localTemplateGroupItem.jdField_a_of_type_JavaLangString;
        if (!TextUtils.isEmpty(str))
        {
          if (QLog.isColorLevel()) {
            QLog.i("PtvTemplateProviderView", 2, "save " + localTemplateGroupItem.jdField_a_of_type_JavaLangString);
          }
          localBundle.putString("ProviderView.select_item_category", str);
        }
      }
    }
    return localBundle;
  }
  
  public String a()
  {
    return "PtvTemplateProviderView";
  }
  
  public void a()
  {
    super.a();
    if (QLog.isColorLevel()) {
      QLog.i("PtvTemplateProviderView", 2, "onProviderShow isAccountChange=" + this.jdField_a_of_type_Boolean + " isInit=" + d());
    }
    if ((d()) && (this.jdField_a_of_type_Boolean)) {
      d();
    }
    this.jdField_a_of_type_Boolean = false;
    a(false);
  }
  
  @TargetApi(9)
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setCurrentItem(paramInt);
    int i = ((TemplateGroupItem)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_Int;
    if (this.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager != null) {
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager.a(2, i, "");
    }
    if (paramInt != 1) {
      k();
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PtvTemplateProviderView", 2, "category= " + paramInt + ",itemId=" + paramString);
    }
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilList.size()) {
      if (((TemplateGroupItem)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_Int != paramInt) {}
    }
    for (;;)
    {
      a().a(i);
      TemplateGroupItem localTemplateGroupItem = (TemplateGroupItem)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.getCurrentItem());
      paramInt = 0;
      label106:
      PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo;
      if (paramInt < localTemplateGroupItem.jdField_a_of_type_JavaUtilList.size())
      {
        localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)localTemplateGroupItem.jdField_a_of_type_JavaUtilList.get(paramInt);
        if (!localPtvTemplateInfo.id.equals(paramString)) {}
      }
      for (paramString = localPtvTemplateInfo;; paramString = null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PtvTemplateProviderView", 2, "itemInfo= " + paramString + ",index=" + i + ",pos=" + paramInt);
        }
        if (paramString != null) {
          postDelayed(new anym(this, paramString), 200L);
        }
        return;
        i += 1;
        break;
        paramInt += 1;
        break label106;
        paramInt = 0;
      }
      i = 0;
    }
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    if (this.jdField_a_of_type_AndroidViewView == null) {
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2130970155, this, false);
    }
    a(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager = ((QQViewPager)findViewById(2131364522));
    this.jdField_a_of_type_DovComQqImCaptureAdapterQIMPtvTemplateViewPagerAdapter = new QIMPtvTemplateViewPagerAdapter(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_DovComQqImCaptureViewProviderView$ProviderViewListener, this.f);
    this.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager = ((QIMPtvTemplateManager)QIMManager.a(3));
    this.jdField_a_of_type_DovComQqImCaptureAdapterQIMPtvTemplateViewPagerAdapter.a(new ArrayList());
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setOnPageChangeListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setAdapter(this.jdField_a_of_type_DovComQqImCaptureAdapterQIMPtvTemplateViewPagerAdapter);
    this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.setTabCheckListener(this);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.registObserver(this.jdField_a_of_type_DovComQqImCaptureMusicCaptureConfigUpdateObserver);
    d();
  }
  
  public void a(boolean paramBoolean)
  {
    if (!this.d) {
      return;
    }
    this.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager = ((QIMPtvTemplateManager)QIMManager.a(3));
    this.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager.a(paramBoolean);
    int j = this.jdField_a_of_type_Int;
    int i;
    if ((!paramBoolean) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager != null) && (this.jdField_a_of_type_DovComQqImCaptureAdapterQIMPtvTemplateViewPagerAdapter != null))
    {
      i = this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.getCurrentItem();
      TemplateGroupItem localTemplateGroupItem1 = this.jdField_a_of_type_DovComQqImCaptureAdapterQIMPtvTemplateViewPagerAdapter.a(i);
      if (localTemplateGroupItem1 != null)
      {
        i = 0;
        label79:
        if (i < this.jdField_a_of_type_JavaUtilList.size())
        {
          TemplateGroupItem localTemplateGroupItem2 = (TemplateGroupItem)this.jdField_a_of_type_JavaUtilList.get(i);
          if ((localTemplateGroupItem2 == null) || (TextUtils.isEmpty(localTemplateGroupItem2.jdField_a_of_type_JavaLangString)) || (!localTemplateGroupItem2.jdField_a_of_type_JavaLangString.equals(localTemplateGroupItem1.jdField_a_of_type_JavaLangString))) {}
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComQqImCaptureAdapterQIMPtvTemplateViewPagerAdapter = new QIMPtvTemplateViewPagerAdapter(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_DovComQqImCaptureViewProviderView$ProviderViewListener, this.f);
      this.jdField_a_of_type_DovComQqImCaptureAdapterQIMPtvTemplateViewPagerAdapter.a(this.jdField_a_of_type_JavaUtilList);
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setAdapter(this.jdField_a_of_type_DovComQqImCaptureAdapterQIMPtvTemplateViewPagerAdapter);
      }
      if (this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView != null)
      {
        this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.c(a());
        this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.setTabCheckListener(this);
      }
      j = i;
      if (i >= this.jdField_a_of_type_JavaUtilList.size())
      {
        j = i;
        if (QLog.isColorLevel())
        {
          QLog.d("PtvTemplateProviderView", 2, "resetPos " + i + " not exist, mTabList size = " + this.jdField_a_of_type_JavaUtilList.size());
          j = 0;
        }
      }
      if ((this.jdField_a_of_type_JavaUtilList.size() <= 0) || (this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager == null) || (this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView == null)) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setCurrentItem(j);
      this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.a(j);
      return;
      i += 1;
      break label79;
      i = j;
    }
  }
  
  public void b()
  {
    super.b();
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.removeAllViews();
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_DovComQqImCaptureViewProviderView$ProviderViewListener != null) {
      this.jdField_a_of_type_DovComQqImCaptureViewProviderView$ProviderViewListener.a(null);
    }
    if (this.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager != null)
    {
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager.a("0", 0, "");
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager.a(null);
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager.a(111);
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager.a(113);
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager.a(112);
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager.a(null);
    }
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.unRegistObserver(this.jdField_a_of_type_DovComQqImCaptureMusicCaptureConfigUpdateObserver);
    }
    super.c();
  }
  
  public void d()
  {
    a(true);
  }
  
  public void e()
  {
    super.e();
    if (QLog.isColorLevel()) {
      QLog.d("PtvTemplateProviderView", 2, "random tab template onResume");
    }
    if ((this.jdField_a_of_type_DovComQqImCaptureAdapterQIMPtvTemplateViewPagerAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager != null) && (QIMPtvTemplateManager.a.compareAndSet(true, false))) {
      d();
    }
    if ((QIMPtvTemplateAdapter.jdField_b_of_type_Int == 0) && (QIMPtvTemplateAdapter.jdField_b_of_type_JavaLangString.equals("0"))) {}
    while ((TextUtils.isEmpty(QIMPtvTemplateAdapter.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_DovComQqImCaptureViewProviderView$ProviderViewListener == null)) {
      return;
    }
    this.jdField_a_of_type_DovComQqImCaptureViewProviderView$ProviderViewListener.a(QIMPtvTemplateAdapter.jdField_a_of_type_JavaLangString, false, false);
  }
  
  public void f()
  {
    super.f();
    if (this.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager != null)
    {
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager.f();
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager.b(true);
    }
  }
  
  public void g()
  {
    super.g();
    if (this.jdField_a_of_type_DovComQqImCaptureViewProviderView$ProviderViewListener != null)
    {
      this.jdField_a_of_type_DovComQqImCaptureViewProviderView$ProviderViewListener.a("", false, false);
      this.jdField_a_of_type_DovComQqImCaptureViewProviderView$ProviderViewListener.a(null);
    }
    if (this.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager != null) {
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager.a("0", 0, "");
    }
    if (QLog.isColorLevel()) {
      QLog.d("PtvTemplateProviderView", 2, "onClear");
    }
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.view.QIMPtvTemplateProviderView
 * JD-Core Version:    0.7.0.1
 */