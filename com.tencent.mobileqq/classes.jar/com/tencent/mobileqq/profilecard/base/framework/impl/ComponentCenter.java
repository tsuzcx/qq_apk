package com.tencent.mobileqq.profilecard.base.framework.impl;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.util.SparseArray;
import aysw;
import aysx;
import ayta;
import aytc;
import aytd;
import ayte;
import aytf;
import aytg;
import ayth;
import ayti;
import aytj;
import aytk;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.app.BaseActivity;
import org.jetbrains.annotations.NotNull;

public class ComponentCenter
  implements aysx
{
  private SparseArray<aysw> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private ComponentCenter.Lifecycle jdField_a_of_type_ComTencentMobileqqProfilecardBaseFrameworkImplComponentCenter$Lifecycle = ComponentCenter.Lifecycle.NONE;
  private boolean jdField_a_of_type_Boolean;
  
  private void a(aysw paramaysw, ComponentCenter.Lifecycle paramLifecycle1, ComponentCenter.Lifecycle paramLifecycle2)
  {
    int i = paramLifecycle2.compareTo(paramLifecycle1);
    if (i == 0) {
      return;
    }
    if (i > 0)
    {
      switch (aytb.a[paramLifecycle1.ordinal()])
      {
      default: 
        QLog.w("ComponentCenter", 1, String.format("callComponentLifecycle not support lifecycle, from=%s", new Object[] { paramLifecycle1 }));
        return;
      case 1: 
        paramaysw.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, null);
        a(paramaysw, ComponentCenter.Lifecycle.CREATED, paramLifecycle2);
        return;
      case 2: 
        paramaysw.b();
        a(paramaysw, ComponentCenter.Lifecycle.STARTED, paramLifecycle2);
        return;
      case 3: 
        paramaysw.c();
        a(paramaysw, ComponentCenter.Lifecycle.RESUMED, paramLifecycle2);
        return;
      case 4: 
        paramaysw.d();
        a(paramaysw, ComponentCenter.Lifecycle.PAUSED, paramLifecycle2);
        return;
      case 5: 
        paramaysw.e();
        a(paramaysw, ComponentCenter.Lifecycle.STOPPED, paramLifecycle2);
        return;
      }
      paramaysw.f();
      a(paramaysw, ComponentCenter.Lifecycle.DESTROYED, paramLifecycle2);
      return;
    }
    QLog.e("ComponentCenter", 1, String.format("callComponentLifecycle not support sequence, form=%s to=%s", new Object[] { paramLifecycle1, paramLifecycle2 }));
  }
  
  private void a(aytk paramaytk)
  {
    if (paramaytk == null) {}
    for (;;)
    {
      return;
      SparseArray localSparseArray = this.jdField_a_of_type_AndroidUtilSparseArray.clone();
      int j = localSparseArray.size();
      int i = 0;
      while (i < j)
      {
        paramaytk.a((aysw)localSparseArray.valueAt(i));
        i += 1;
      }
    }
  }
  
  public aysw a(int paramInt)
  {
    return (aysw)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ComponentCenter", 0, String.format("onActivityResult requestCode=%s resultCode=%s data=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramIntent }));
    }
    a(new ayti(this, paramInt1, paramInt2, paramIntent));
  }
  
  public void a(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ComponentCenter", 0, String.format("onNewIntent intent=%s", new Object[] { paramIntent }));
    }
    a(new ayth(this, paramIntent));
  }
  
  public void a(aysw paramaysw)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ComponentCenter", 0, String.format("addComponent component=%s", new Object[] { paramaysw }));
    }
    if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
      throw new RuntimeException("This Method Must Call In Main Thread.");
    }
    if (paramaysw != null)
    {
      int i = paramaysw.a();
      if (this.jdField_a_of_type_AndroidUtilSparseArray.indexOfKey(i) < 0)
      {
        this.jdField_a_of_type_AndroidUtilSparseArray.put(i, paramaysw);
        a(paramaysw, ComponentCenter.Lifecycle.NONE, this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseFrameworkImplComponentCenter$Lifecycle);
      }
    }
    else
    {
      return;
    }
    QLog.e("ComponentCenter", 1, String.format("addComponent component exist. component=%s", new Object[] { paramaysw }));
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
    a(new ayta(this, paramBaseActivity, paramBundle));
  }
  
  public boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ComponentCenter", 0, "onBackPressed");
    }
    this.jdField_a_of_type_Boolean = false;
    a(new aytj(this));
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ComponentCenter", 0, "onStart");
    }
    this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseFrameworkImplComponentCenter$Lifecycle = ComponentCenter.Lifecycle.STARTED;
    a(new aytc(this));
  }
  
  public void b(aysw paramaysw)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ComponentCenter", 0, String.format("removeComponent component=%s", new Object[] { paramaysw }));
    }
    if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
      throw new RuntimeException("This Method Must Call In Main Thread.");
    }
    if (paramaysw != null)
    {
      int i = paramaysw.a();
      i = this.jdField_a_of_type_AndroidUtilSparseArray.indexOfKey(i);
      if (i >= 0)
      {
        this.jdField_a_of_type_AndroidUtilSparseArray.removeAt(i);
        a(paramaysw, this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseFrameworkImplComponentCenter$Lifecycle, ComponentCenter.Lifecycle.DESTROYED);
      }
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ComponentCenter", 0, "onResume");
    }
    this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseFrameworkImplComponentCenter$Lifecycle = ComponentCenter.Lifecycle.RESUMED;
    a(new aytd(this));
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ComponentCenter", 0, "onPause");
    }
    this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseFrameworkImplComponentCenter$Lifecycle = ComponentCenter.Lifecycle.PAUSED;
    a(new ayte(this));
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ComponentCenter", 0, "onStop");
    }
    this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseFrameworkImplComponentCenter$Lifecycle = ComponentCenter.Lifecycle.STOPPED;
    a(new aytf(this));
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ComponentCenter", 0, "onDestroy");
    }
    this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseFrameworkImplComponentCenter$Lifecycle = ComponentCenter.Lifecycle.DESTROYED;
    a(new aytg(this));
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