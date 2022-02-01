package com.tencent.mobileqq.profilecard.base.framework.impl;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.util.SparseArray;
import baeh;
import baei;
import bael;
import baen;
import baeo;
import baep;
import baeq;
import baer;
import baes;
import baet;
import baeu;
import baev;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.app.BaseActivity;
import org.jetbrains.annotations.NotNull;

public class ComponentCenter
  implements baei
{
  private SparseArray<baeh> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private ComponentCenter.Lifecycle jdField_a_of_type_ComTencentMobileqqProfilecardBaseFrameworkImplComponentCenter$Lifecycle = ComponentCenter.Lifecycle.NONE;
  private boolean jdField_a_of_type_Boolean;
  
  private void a(baeh parambaeh, ComponentCenter.Lifecycle paramLifecycle1, ComponentCenter.Lifecycle paramLifecycle2)
  {
    int i = paramLifecycle2.compareTo(paramLifecycle1);
    if (i == 0) {
      return;
    }
    if (i > 0)
    {
      switch (baem.a[paramLifecycle1.ordinal()])
      {
      default: 
        QLog.w("ComponentCenter", 1, String.format("callComponentLifecycle not support lifecycle, from=%s", new Object[] { paramLifecycle1 }));
        return;
      case 1: 
        parambaeh.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, null);
        a(parambaeh, ComponentCenter.Lifecycle.CREATED, paramLifecycle2);
        return;
      case 2: 
        parambaeh.b();
        a(parambaeh, ComponentCenter.Lifecycle.STARTED, paramLifecycle2);
        return;
      case 3: 
        parambaeh.c();
        a(parambaeh, ComponentCenter.Lifecycle.RESUMED, paramLifecycle2);
        return;
      case 4: 
        parambaeh.d();
        a(parambaeh, ComponentCenter.Lifecycle.PAUSED, paramLifecycle2);
        return;
      case 5: 
        parambaeh.e();
        a(parambaeh, ComponentCenter.Lifecycle.STOPPED, paramLifecycle2);
        return;
      }
      parambaeh.f();
      a(parambaeh, ComponentCenter.Lifecycle.DESTROYED, paramLifecycle2);
      return;
    }
    QLog.e("ComponentCenter", 1, String.format("callComponentLifecycle not support sequence, form=%s to=%s", new Object[] { paramLifecycle1, paramLifecycle2 }));
  }
  
  private void a(baev parambaev)
  {
    if (parambaev == null) {}
    for (;;)
    {
      return;
      SparseArray localSparseArray = this.jdField_a_of_type_AndroidUtilSparseArray.clone();
      int j = localSparseArray.size();
      int i = 0;
      while (i < j)
      {
        parambaev.a((baeh)localSparseArray.valueAt(i));
        i += 1;
      }
    }
  }
  
  public baeh a(int paramInt)
  {
    return (baeh)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ComponentCenter", 0, String.format("onActivityResult requestCode=%s resultCode=%s data=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramIntent }));
    }
    a(new baet(this, paramInt1, paramInt2, paramIntent));
  }
  
  public void a(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ComponentCenter", 0, String.format("onNewIntent intent=%s", new Object[] { paramIntent }));
    }
    a(new baes(this, paramIntent));
  }
  
  public void a(baeh parambaeh)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ComponentCenter", 0, String.format("addComponent component=%s", new Object[] { parambaeh }));
    }
    if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
      throw new RuntimeException("This Method Must Call In Main Thread.");
    }
    if (parambaeh != null)
    {
      int i = parambaeh.a();
      if (this.jdField_a_of_type_AndroidUtilSparseArray.indexOfKey(i) < 0)
      {
        this.jdField_a_of_type_AndroidUtilSparseArray.put(i, parambaeh);
        a(parambaeh, ComponentCenter.Lifecycle.NONE, this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseFrameworkImplComponentCenter$Lifecycle);
      }
    }
    else
    {
      return;
    }
    QLog.e("ComponentCenter", 1, String.format("addComponent component exist. component=%s", new Object[] { parambaeh }));
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
    a(new bael(this, paramBaseActivity, paramBundle));
  }
  
  public boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ComponentCenter", 0, "onBackPressed");
    }
    this.jdField_a_of_type_Boolean = false;
    a(new baeu(this));
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ComponentCenter", 0, "onStart");
    }
    this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseFrameworkImplComponentCenter$Lifecycle = ComponentCenter.Lifecycle.STARTED;
    a(new baen(this));
  }
  
  public void b(baeh parambaeh)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ComponentCenter", 0, String.format("removeComponent component=%s", new Object[] { parambaeh }));
    }
    if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
      throw new RuntimeException("This Method Must Call In Main Thread.");
    }
    if (parambaeh != null)
    {
      int i = parambaeh.a();
      i = this.jdField_a_of_type_AndroidUtilSparseArray.indexOfKey(i);
      if (i >= 0)
      {
        this.jdField_a_of_type_AndroidUtilSparseArray.removeAt(i);
        a(parambaeh, this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseFrameworkImplComponentCenter$Lifecycle, ComponentCenter.Lifecycle.DESTROYED);
      }
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ComponentCenter", 0, "onResume");
    }
    this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseFrameworkImplComponentCenter$Lifecycle = ComponentCenter.Lifecycle.RESUMED;
    a(new baeo(this));
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ComponentCenter", 0, "onPause");
    }
    this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseFrameworkImplComponentCenter$Lifecycle = ComponentCenter.Lifecycle.PAUSED;
    a(new baep(this));
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ComponentCenter", 0, "onStop");
    }
    this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseFrameworkImplComponentCenter$Lifecycle = ComponentCenter.Lifecycle.STOPPED;
    a(new baeq(this));
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ComponentCenter", 0, "onDestroy");
    }
    this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseFrameworkImplComponentCenter$Lifecycle = ComponentCenter.Lifecycle.DESTROYED;
    a(new baer(this));
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