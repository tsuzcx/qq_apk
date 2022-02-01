package com.tencent.mobileqq.profilecard.base.framework.impl;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.util.SparseArray;
import azlv;
import azlw;
import azlz;
import azmb;
import azmc;
import azmd;
import azme;
import azmf;
import azmg;
import azmh;
import azmi;
import azmj;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.app.BaseActivity;
import org.jetbrains.annotations.NotNull;

public class ComponentCenter
  implements azlw
{
  private SparseArray<azlv> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private ComponentCenter.Lifecycle jdField_a_of_type_ComTencentMobileqqProfilecardBaseFrameworkImplComponentCenter$Lifecycle = ComponentCenter.Lifecycle.NONE;
  private boolean jdField_a_of_type_Boolean;
  
  private void a(azlv paramazlv, ComponentCenter.Lifecycle paramLifecycle1, ComponentCenter.Lifecycle paramLifecycle2)
  {
    int i = paramLifecycle2.compareTo(paramLifecycle1);
    if (i == 0) {
      return;
    }
    if (i > 0)
    {
      switch (azma.a[paramLifecycle1.ordinal()])
      {
      default: 
        QLog.w("ComponentCenter", 1, String.format("callComponentLifecycle not support lifecycle, from=%s", new Object[] { paramLifecycle1 }));
        return;
      case 1: 
        paramazlv.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, null);
        a(paramazlv, ComponentCenter.Lifecycle.CREATED, paramLifecycle2);
        return;
      case 2: 
        paramazlv.b();
        a(paramazlv, ComponentCenter.Lifecycle.STARTED, paramLifecycle2);
        return;
      case 3: 
        paramazlv.c();
        a(paramazlv, ComponentCenter.Lifecycle.RESUMED, paramLifecycle2);
        return;
      case 4: 
        paramazlv.d();
        a(paramazlv, ComponentCenter.Lifecycle.PAUSED, paramLifecycle2);
        return;
      case 5: 
        paramazlv.e();
        a(paramazlv, ComponentCenter.Lifecycle.STOPPED, paramLifecycle2);
        return;
      }
      paramazlv.f();
      a(paramazlv, ComponentCenter.Lifecycle.DESTROYED, paramLifecycle2);
      return;
    }
    QLog.e("ComponentCenter", 1, String.format("callComponentLifecycle not support sequence, form=%s to=%s", new Object[] { paramLifecycle1, paramLifecycle2 }));
  }
  
  private void a(azmj paramazmj)
  {
    if (paramazmj == null) {}
    for (;;)
    {
      return;
      SparseArray localSparseArray = this.jdField_a_of_type_AndroidUtilSparseArray.clone();
      int j = localSparseArray.size();
      int i = 0;
      while (i < j)
      {
        paramazmj.a((azlv)localSparseArray.valueAt(i));
        i += 1;
      }
    }
  }
  
  public azlv a(int paramInt)
  {
    return (azlv)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ComponentCenter", 0, String.format("onActivityResult requestCode=%s resultCode=%s data=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramIntent }));
    }
    a(new azmh(this, paramInt1, paramInt2, paramIntent));
  }
  
  public void a(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ComponentCenter", 0, String.format("onNewIntent intent=%s", new Object[] { paramIntent }));
    }
    a(new azmg(this, paramIntent));
  }
  
  public void a(azlv paramazlv)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ComponentCenter", 0, String.format("addComponent component=%s", new Object[] { paramazlv }));
    }
    if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
      throw new RuntimeException("This Method Must Call In Main Thread.");
    }
    if (paramazlv != null)
    {
      int i = paramazlv.a();
      if (this.jdField_a_of_type_AndroidUtilSparseArray.indexOfKey(i) < 0)
      {
        this.jdField_a_of_type_AndroidUtilSparseArray.put(i, paramazlv);
        a(paramazlv, ComponentCenter.Lifecycle.NONE, this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseFrameworkImplComponentCenter$Lifecycle);
      }
    }
    else
    {
      return;
    }
    QLog.e("ComponentCenter", 1, String.format("addComponent component exist. component=%s", new Object[] { paramazlv }));
  }
  
  public void a(BaseActivity paramBaseActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ComponentCenter", 0, String.format("init activity=%s", new Object[] { paramBaseActivity }));
    }
    if (paramBaseActivity != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
      this.jdField_a_of_type_AndroidUtilSparseArray.clear();
      return;
    }
    QLog.e("ComponentCenter", 1, "init params invalid.");
  }
  
  public void a(BaseActivity paramBaseActivity, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ComponentCenter", 0, String.format("onCreate activity=%s savedInstanceState=%s", new Object[] { paramBaseActivity, paramBundle }));
    }
    this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseFrameworkImplComponentCenter$Lifecycle = ComponentCenter.Lifecycle.CREATED;
    a(new azlz(this, paramBaseActivity, paramBundle));
  }
  
  public boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ComponentCenter", 0, "onBackPressed");
    }
    this.jdField_a_of_type_Boolean = false;
    a(new azmi(this));
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ComponentCenter", 0, "onStart");
    }
    this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseFrameworkImplComponentCenter$Lifecycle = ComponentCenter.Lifecycle.STARTED;
    a(new azmb(this));
  }
  
  public void b(azlv paramazlv)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ComponentCenter", 0, String.format("removeComponent component=%s", new Object[] { paramazlv }));
    }
    if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
      throw new RuntimeException("This Method Must Call In Main Thread.");
    }
    if (paramazlv != null)
    {
      int i = paramazlv.a();
      i = this.jdField_a_of_type_AndroidUtilSparseArray.indexOfKey(i);
      if (i >= 0)
      {
        this.jdField_a_of_type_AndroidUtilSparseArray.removeAt(i);
        a(paramazlv, this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseFrameworkImplComponentCenter$Lifecycle, ComponentCenter.Lifecycle.DESTROYED);
      }
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ComponentCenter", 0, "onResume");
    }
    this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseFrameworkImplComponentCenter$Lifecycle = ComponentCenter.Lifecycle.RESUMED;
    a(new azmc(this));
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ComponentCenter", 0, "onPause");
    }
    this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseFrameworkImplComponentCenter$Lifecycle = ComponentCenter.Lifecycle.PAUSED;
    a(new azmd(this));
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ComponentCenter", 0, "onStop");
    }
    this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseFrameworkImplComponentCenter$Lifecycle = ComponentCenter.Lifecycle.STOPPED;
    a(new azme(this));
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ComponentCenter", 0, "onDestroy");
    }
    this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseFrameworkImplComponentCenter$Lifecycle = ComponentCenter.Lifecycle.DESTROYED;
    a(new azmf(this));
  }
  
  @NotNull
  public String toString()
  {
    return String.format("ComponentCenter@%s", new Object[] { Integer.valueOf(hashCode()) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.framework.impl.ComponentCenter
 * JD-Core Version:    0.7.0.1
 */