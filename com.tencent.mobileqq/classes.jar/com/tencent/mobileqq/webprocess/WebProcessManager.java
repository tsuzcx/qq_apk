package com.tencent.mobileqq.webprocess;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BabyQObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.manager.Manager;

@Deprecated
public class WebProcessManager
  implements Manager
{
  private final BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new WebProcessManager.1(this);
  private final BabyQObserver jdField_a_of_type_ComTencentMobileqqAppBabyQObserver = new WebProcessManager.2(this);
  protected QQAppInterface a;
  private boolean jdField_a_of_type_Boolean = false;
  
  public WebProcessManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    a();
  }
  
  @Deprecated
  private void a()
  {
    if (!this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Boolean = true;
    }
    try
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.tencent.mobileqq.babyq.add");
      BaseApplicationImpl.getContext().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppBabyQObserver);
      return;
    }
    catch (Exception localException) {}
  }
  
  @Deprecated
  private void b()
  {
    if (this.jdField_a_of_type_Boolean) {}
    try
    {
      this.jdField_a_of_type_Boolean = false;
      BaseApplicationImpl.getContext().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppBabyQObserver);
      return;
    }
    catch (Exception localException) {}
  }
  
  public void onDestroy()
  {
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.webprocess.WebProcessManager
 * JD-Core Version:    0.7.0.1
 */