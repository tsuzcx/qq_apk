package com.tencent.mobileqq.troop.widget;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import baqs;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.manager.Manager;

public class UsingTimeReportManager
  extends BroadcastReceiver
  implements Manager
{
  private IntentFilter jdField_a_of_type_AndroidContentIntentFilter;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private List<baqs> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public UsingTimeReportManager(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_AndroidContentIntentFilter = new IntentFilter();
    this.jdField_a_of_type_AndroidContentIntentFilter.addAction("android.intent.action.SCREEN_OFF");
    this.jdField_a_of_type_AndroidContentIntentFilter.addAction("mqq.intent.action.QQ_BACKGROUND");
    this.jdField_a_of_type_AndroidContentIntentFilter.addAction("mqq.intent.action.QQ_FOREGROUND");
    this.jdField_a_of_type_AndroidContentIntentFilter.addAction("mqq.intent.action.ACCOUNT_KICKED");
    try
    {
      paramAppInterface = paramAppInterface.getApp();
      if (paramAppInterface != null) {
        paramAppInterface.registerReceiver(this, this.jdField_a_of_type_AndroidContentIntentFilter);
      }
      return;
    }
    catch (Exception paramAppInterface)
    {
      QLog.e("UsingTimeReportManager", 1, "init," + paramAppInterface.toString(), paramAppInterface);
    }
  }
  
  private void b()
  {
    try
    {
      Object localObject1 = new ArrayList();
      ((List)localObject1).addAll(this.jdField_a_of_type_JavaUtilList);
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((baqs)((Iterator)localObject1).next()).c();
      }
    }
    finally {}
  }
  
  private void c()
  {
    try
    {
      Object localObject1 = new ArrayList();
      ((List)localObject1).addAll(this.jdField_a_of_type_JavaUtilList);
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((baqs)((Iterator)localObject1).next()).d();
      }
    }
    finally {}
  }
  
  public void a()
  {
    try
    {
      Object localObject1 = new ArrayList();
      ((List)localObject1).addAll(this.jdField_a_of_type_JavaUtilList);
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((baqs)((Iterator)localObject1).next()).e();
      }
    }
    finally {}
  }
  
  public void a(baqs parambaqs)
  {
    try
    {
      if (!this.jdField_a_of_type_JavaUtilList.contains(parambaqs)) {
        this.jdField_a_of_type_JavaUtilList.add(parambaqs);
      }
      return;
    }
    finally
    {
      parambaqs = finally;
      throw parambaqs;
    }
  }
  
  public void b(baqs parambaqs)
  {
    try
    {
      if (this.jdField_a_of_type_JavaUtilList.contains(parambaqs)) {
        this.jdField_a_of_type_JavaUtilList.remove(parambaqs);
      }
      return;
    }
    finally
    {
      parambaqs = finally;
      throw parambaqs;
    }
  }
  
  public void onDestroy()
  {
    try
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      try
      {
        BaseApplication localBaseApplication = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp();
        if (localBaseApplication != null) {
          localBaseApplication.unregisterReceiver(this);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("UsingTimeReportManager", 1, "unInit" + localException.toString(), localException);
        }
      }
      return;
    }
    finally {}
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ("android.intent.action.SCREEN_OFF".equals(paramContext)) {
      b();
    }
    do
    {
      return;
      if ("android.intent.action.SCREEN_ON".equals(paramContext))
      {
        c();
        return;
      }
      if ("mqq.intent.action.QQ_BACKGROUND".equals(paramContext))
      {
        b();
        return;
      }
      if ("mqq.intent.action.QQ_FOREGROUND".equals(paramContext))
      {
        c();
        return;
      }
    } while (!"mqq.intent.action.ACCOUNT_KICKED".equals(paramContext));
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.UsingTimeReportManager
 * JD-Core Version:    0.7.0.1
 */