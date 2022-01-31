package com.tencent.mobileqq.richmedia.capture.view;

import aepi;
import ajrw;
import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import axnu;
import axoc;
import axoi;
import axoy;
import axpl;
import axru;
import axse;
import axsh;
import axsi;
import azga;
import azjh;
import bdoo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.adapter.PtvTemplateViewPagerAdapter;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.GridView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class PtvTemplateProviderView
  extends ProviderView
  implements ViewPager.OnPageChangeListener, ViewTreeObserver.OnScrollChangedListener, axoi, axru, axsh, azga
{
  public int a;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  axoc jdField_a_of_type_Axoc;
  private axoy jdField_a_of_type_Axoy;
  PtvTemplateViewPagerAdapter jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAdapterPtvTemplateViewPagerAdapter;
  QQViewPager jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager;
  String jdField_a_of_type_JavaLangString = "";
  public List<axoy> a;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = 1;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private View c;
  boolean d = true;
  int jdField_e_of_type_Int = -1;
  private boolean jdField_e_of_type_Boolean = true;
  private int jdField_f_of_type_Int = -1;
  private boolean jdField_f_of_type_Boolean;
  
  public PtvTemplateProviderView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
  }
  
  private ArrayList<axsi> a()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_Axoc != null) {}
    for (int i = this.jdField_a_of_type_Axoc.a();; i = -1)
    {
      int j = 0;
      while (j < this.jdField_a_of_type_JavaUtilList.size())
      {
        axoy localaxoy = (axoy)this.jdField_a_of_type_JavaUtilList.get(j);
        if ((i != -1) && (i == localaxoy.jdField_a_of_type_Int))
        {
          this.jdField_b_of_type_Int = j;
          if (this.jdField_a_of_type_Axoc != null) {
            this.jdField_a_of_type_Axoc.a(5, 0, null);
          }
        }
        axsi localaxsi = new axsi();
        localaxsi.jdField_a_of_type_JavaLangString = localaxoy.jdField_a_of_type_JavaLangString;
        localaxsi.b = localaxoy.jdField_a_of_type_Boolean;
        if (this.jdField_a_of_type_Axoc != null) {
          localaxsi.jdField_a_of_type_Boolean = this.jdField_a_of_type_Axoc.a(2, localaxoy.jdField_a_of_type_Int, "");
        }
        localArrayList.add(localaxsi);
        j += 1;
      }
      return localArrayList;
    }
  }
  
  private void f()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(this.jdField_a_of_type_Axoc.b());
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAdapterPtvTemplateViewPagerAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAdapterPtvTemplateViewPagerAdapter.a(this.jdField_a_of_type_JavaUtilList);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewQQSlidingTabView != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewQQSlidingTabView.a(a());
    }
    g();
    int i = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewQQSlidingTabView.getScrollX();
    if (this.jdField_a_of_type_AndroidWidgetTextView == null) {
      e();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PtvTemplateProviderView", 2, "PtvTemplateProviderView reloadDataAndNotifyDataChanged size=" + this.jdField_a_of_type_JavaUtilList.size());
      }
      b();
      return;
      if (i != 0) {
        d();
      }
    }
  }
  
  private void g()
  {
    ThreadManager.getUIHandler().post(new PtvTemplateProviderView.1(this));
  }
  
  public String a()
  {
    return "PtvTemplateProviderView";
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PtvTemplateProviderView", 2, "PtvTemplateProviderView onCapturePtvTemplateRefresh");
    }
    if (Looper.getMainLooper().getThread() == Thread.currentThread())
    {
      f();
      return;
    }
    ThreadManager.getUIHandler().post(new PtvTemplateProviderView.2(this));
  }
  
  @TargetApi(9)
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setCurrentItem(paramInt);
    paramInt = ((axoy)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_Int;
    if (this.jdField_a_of_type_Axoc != null) {
      this.jdField_a_of_type_Axoc.a(2, paramInt, "");
    }
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    if (this.jdField_a_of_type_AndroidViewView == null) {
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2131561385, this, false);
    }
    axoc.a().a(this);
    axoc.a().a(this, 114);
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new axse(this, null);
    getContext().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, new IntentFilter("action_brocassreceiver_for_ptv"));
    a(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager = ((QQViewPager)findViewById(2131379906));
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAdapterPtvTemplateViewPagerAdapter = new PtvTemplateViewPagerAdapter(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_Axsd, this.d);
    this.jdField_a_of_type_Axoc = axoc.a();
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(this.jdField_a_of_type_Axoc.b());
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAdapterPtvTemplateViewPagerAdapter.a(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setOnPageChangeListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAdapterPtvTemplateViewPagerAdapter);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewQQSlidingTabView.a(a());
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewQQSlidingTabView.setTabCheckListener(this);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewQQSlidingTabView.getViewTreeObserver().addOnScrollChangedListener(this);
    g();
    if (this.jdField_a_of_type_JavaUtilList.size() > 1) {
      ajrw.b(1);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PtvTemplateProviderView", 2, "PtvTemplateProviderView onCreate size=" + this.jdField_a_of_type_JavaUtilList.size());
      }
      return;
      ajrw.b(0);
    }
  }
  
  public void a(Object paramObject, int paramInt, Object... paramVarArgs)
  {
    if ((paramInt != 114) || (paramVarArgs == null) || (paramVarArgs.length != 1)) {
      return;
    }
    d();
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null) {}
    for (Object localObject = BaseApplicationImpl.sApplication.getRuntime();; localObject = this.jdField_a_of_type_ComTencentCommonAppAppInterface)
    {
      localObject = getContext().getSharedPreferences(azjh.jdField_b_of_type_JavaLangString + ((AppRuntime)localObject).getAccount(), 4);
      if (!((SharedPreferences)localObject).getBoolean(paramInt1 + "&" + paramInt2, false)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PtvTemplateProviderView", 2, new Object[] { "VideoRedbag, checkTipsLayoutShown, already shown, id:", Integer.valueOf(paramInt1), " tipver:", Integer.valueOf(paramInt2) });
      }
      return true;
    }
    if (((SharedPreferences)localObject).contains(String.valueOf(paramInt1)))
    {
      if (((SharedPreferences)localObject).getInt(String.valueOf(paramInt1), 0) > paramInt2)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PtvTemplateProviderView", 2, new Object[] { "VideoRedbag, checkTipsLayoutShown, exist high version, id:", Integer.valueOf(paramInt1), " tipver:", Integer.valueOf(paramInt2) });
        }
        return true;
      }
      ((SharedPreferences)localObject).edit().remove(String.valueOf(paramInt1)).commit();
    }
    if (QLog.isColorLevel()) {
      QLog.d("PtvTemplateProviderView", 2, new Object[] { "VideoRedbag, checkTipsLayoutShown, not shown, id: ", Integer.valueOf(paramInt1), " tipver: ", Integer.valueOf(paramInt2) });
    }
    return false;
  }
  
  public void aJ_()
  {
    super.aJ_();
    this.jdField_e_of_type_Boolean = true;
    b();
  }
  
  public void b()
  {
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAdapterPtvTemplateViewPagerAdapter.a.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Integer)localIterator.next();
      localObject = (GridView)this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAdapterPtvTemplateViewPagerAdapter.a.get(localObject);
      if (localObject != null)
      {
        localObject = ((GridView)localObject).a();
        if ((localObject != null) && ((localObject instanceof axnu))) {
          ((axnu)localObject).notifyDataSetChanged();
        }
      }
    }
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0))
    {
      this.jdField_c_of_type_AndroidViewView = null;
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      if (this.jdField_b_of_type_AndroidWidgetImageView != null) {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      if (this.jdField_a_of_type_Axoy != null) {
        if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) {
          break label192;
        }
      }
    }
    label192:
    for (Object localObject = BaseApplicationImpl.sApplication.getRuntime();; localObject = this.jdField_a_of_type_ComTencentCommonAppAppInterface)
    {
      String str = this.jdField_a_of_type_Axoy.jdField_a_of_type_Int + "&" + this.jdField_a_of_type_Axoy.jdField_b_of_type_Int;
      localObject = getContext().getSharedPreferences(azjh.jdField_b_of_type_JavaLangString + ((AppRuntime)localObject).getAccount(), 4).edit();
      ((SharedPreferences.Editor)localObject).putBoolean(str, true);
      ((SharedPreferences.Editor)localObject).putInt(String.valueOf(this.jdField_a_of_type_Axoy.jdField_a_of_type_Int), this.jdField_a_of_type_Axoy.jdField_b_of_type_Int);
      ((SharedPreferences.Editor)localObject).commit();
      return;
    }
  }
  
  public void e()
  {
    int i;
    label134:
    int m;
    int i2;
    int k;
    int n;
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewQQSlidingTabView == null) {
        return;
      }
      if (this.jdField_f_of_type_Boolean) {
        break label134;
      }
      this.jdField_f_of_type_Boolean = true;
      localObject = axoc.a().b();
      i = 0;
    }
    catch (Exception localException)
    {
      Object localObject;
      int j;
      int i1;
      RelativeLayout.LayoutParams localLayoutParams;
      label939:
      label944:
      label957:
      label993:
      label1005:
      while (QLog.isColorLevel())
      {
        QLog.d("PtvTemplateProviderView", 2, new Object[] { "VideoRedbag, showTipsLayout ", localException.getMessage() });
        return;
        i += 1;
        continue;
        j = 0;
        continue;
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849172);
        continue;
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
        this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130849174);
        this.jdField_a_of_type_AndroidWidgetTextView.setPadding(n, k, n, k);
        continue;
        localLayoutParams.setMargins(k, 0, i, 0);
      }
    }
    if (i < ((ArrayList)localObject).size())
    {
      this.jdField_a_of_type_Axoy = ((axoy)((ArrayList)localObject).get(i));
      if ((this.jdField_a_of_type_Axoy.jdField_b_of_type_JavaLangString != null) && (!a(this.jdField_a_of_type_Axoy.jdField_a_of_type_Int, this.jdField_a_of_type_Axoy.jdField_b_of_type_Int))) {
        this.jdField_f_of_type_Int = i;
      }
    }
    else
    {
      if ((this.jdField_f_of_type_Int != -1) && (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewQQSlidingTabView.a().size() > this.jdField_f_of_type_Int)) {
        this.jdField_c_of_type_AndroidViewView = ((View)this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewQQSlidingTabView.a().get(this.jdField_f_of_type_Int));
      }
      if ((this.jdField_c_of_type_AndroidViewView == null) || (this.jdField_a_of_type_Axoy == null)) {
        break label1008;
      }
      i = this.jdField_c_of_type_AndroidViewView.getLeft();
      j = this.jdField_c_of_type_AndroidViewView.getRight();
      m = this.jdField_c_of_type_AndroidViewView.getWidth();
      if ((i == 0) && (j == 0)) {
        break label1008;
      }
      i2 = bdoo.a();
      i1 = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewQQSlidingTabView.getScrollX();
      j = m / 2 + i - i1;
      k = aepi.a(30.0F, getContext().getResources());
      if ((j <= 0) || (j + k >= i2)) {
        break label939;
      }
      j = 1;
      if ((this.jdField_a_of_type_AndroidWidgetTextView == null) && (j != 0) && (this.jdField_c_of_type_Int == 2))
      {
        if ((this.jdField_b_of_type_AndroidViewView == null) || (!(this.jdField_b_of_type_AndroidViewView instanceof RelativeLayout))) {
          break label1008;
        }
        localObject = getContext();
        this.jdField_a_of_type_AndroidWidgetImageView = new ImageView((Context)localObject);
        this.jdField_a_of_type_AndroidWidgetImageView.setId(2131376642);
        if (!this.jdField_a_of_type_Axoy.jdField_a_of_type_Boolean) {
          break label944;
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849173);
        localLayoutParams = new RelativeLayout.LayoutParams(aepi.a(20.0F, ((Context)localObject).getResources()), aepi.a(10.0F, ((Context)localObject).getResources()));
        localLayoutParams.addRule(2, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewQQSlidingTabView.getId());
        localLayoutParams.addRule(9);
        localLayoutParams.leftMargin = (m / 2 + i - aepi.a(20.0F, ((Context)localObject).getResources()) / 2);
        localLayoutParams.bottomMargin = 5;
        ((RelativeLayout)this.jdField_b_of_type_AndroidViewView).addView(this.jdField_a_of_type_AndroidWidgetImageView, localLayoutParams);
        this.jdField_a_of_type_AndroidWidgetTextView = new TextView((Context)localObject);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_Axoy.jdField_b_of_type_JavaLangString);
        k = aepi.a(5.0F, ((Context)localObject).getResources());
        n = aepi.a(5.0F, ((Context)localObject).getResources());
        if (!this.jdField_a_of_type_Axoy.jdField_a_of_type_Boolean) {
          break label957;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#FBD49D"));
        this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130849175);
        this.jdField_a_of_type_AndroidWidgetTextView.setPadding(aepi.a(30.0F, ((Context)localObject).getResources()), k, n, k);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 16.0F);
        this.jdField_a_of_type_AndroidWidgetTextView.setGravity(17);
        this.jdField_a_of_type_AndroidWidgetTextView.setSingleLine();
        this.jdField_a_of_type_AndroidWidgetTextView.measure(-2, -2);
        k = this.jdField_a_of_type_AndroidWidgetTextView.getMeasuredWidth();
        if (!this.jdField_a_of_type_Axoy.jdField_a_of_type_Boolean) {
          break label1005;
        }
        k += aepi.a(17.0F, ((Context)localObject).getResources());
        m = m / 2 + i - k / 2;
        n = i2 - m - k;
        i = 16;
        if ((n >= 16) || (k + 32 >= i2)) {
          break label1025;
        }
        if (n >= 16) {
          break label1019;
        }
        break label1009;
        localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.addRule(2, 2131376642);
        localLayoutParams.addRule(9);
        if (!this.jdField_a_of_type_Axoy.jdField_a_of_type_Boolean) {
          break label993;
        }
        localLayoutParams.setMargins(aepi.a(17.0F, ((Context)localObject).getResources()) + k, 0, i, 0);
        ((RelativeLayout)this.jdField_b_of_type_AndroidViewView).addView(this.jdField_a_of_type_AndroidWidgetTextView, localLayoutParams);
        if (this.jdField_a_of_type_Axoy.jdField_a_of_type_Boolean)
        {
          this.jdField_b_of_type_AndroidWidgetImageView = new ImageView((Context)localObject);
          this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130849176);
          localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
          localLayoutParams.addRule(2, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewQQSlidingTabView.getId());
          localLayoutParams.addRule(9);
          localLayoutParams.leftMargin = k;
          localLayoutParams.bottomMargin = aepi.a(3.0F, ((Context)localObject).getResources());
          ((RelativeLayout)this.jdField_b_of_type_AndroidViewView).addView(this.jdField_b_of_type_AndroidWidgetImageView, localLayoutParams);
        }
      }
      if ((this.jdField_a_of_type_AndroidWidgetTextView == null) || (j == 0)) {
        break label1008;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setTranslationX(-i1);
      this.jdField_a_of_type_AndroidWidgetImageView.setTranslationX(-i1);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      if (this.jdField_b_of_type_AndroidWidgetImageView == null) {
        break label1008;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setTranslationX(-i1);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    }
    label1008:
    return;
    for (;;)
    {
      label1009:
      k = i2 - i - k;
      break;
      label1019:
      i = n;
    }
    label1025:
    if (m < 16) {}
    for (;;)
    {
      m = i2 - i - k;
      k = i;
      i = m;
      break;
      i = m;
    }
  }
  
  public void onPageScrollStateChanged(int paramInt)
  {
    this.jdField_e_of_type_Boolean = false;
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewQQSlidingTabView.a(paramInt);
    this.jdField_a_of_type_Int = paramInt;
    if (!this.jdField_e_of_type_Boolean) {
      axpl.a(((axoy)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_Int + "");
    }
    d();
  }
  
  public void onScrollChanged()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewQQSlidingTabView.getScrollX();
    if (this.jdField_a_of_type_AndroidWidgetTextView == null) {
      e();
    }
    while (i == 0) {
      return;
    }
    d();
  }
  
  public void setNeedAdvertisement(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public void setTab(int paramInt)
  {
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilList.size()) {
      if (((axoy)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_Int != paramInt) {}
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager != null) && (i > 0)) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setCurrentItem(i);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewQQSlidingTabView != null) && (i > 0)) {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewQQSlidingTabView.a(i);
      }
      if (i == 0) {
        this.jdField_e_of_type_Int = paramInt;
      }
      return;
      i += 1;
      break;
      i = 0;
    }
  }
  
  public void setTab(String paramString)
  {
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilList.size()) {
      if (!((axoy)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangString.equals(paramString)) {}
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager != null) && (i > 0)) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setCurrentItem(i);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewQQSlidingTabView != null) && (i > 0)) {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewQQSlidingTabView.a(i);
      }
      if (i == 0) {
        this.jdField_a_of_type_JavaLangString = paramString;
      }
      return;
      i += 1;
      break;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.PtvTemplateProviderView
 * JD-Core Version:    0.7.0.1
 */