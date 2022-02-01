package com.tencent.mobileqq.subaccount.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.SubAccountBindObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.subaccount.api.ISubAccountProtocService;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class SubAccountProtocServiceImpl
  implements ISubAccountProtocService
{
  private static final long DAY_MILLS_SEC = 86400000L;
  private static final String TAG = "Q.subaccount.SubAccountProtocManager";
  private static byte[] lock = new byte[0];
  private static byte[] lock1 = new byte[0];
  private static byte[] lock2 = new byte[0];
  private AppInterface app;
  private SubAccountBindObserver bindObserver = new SubAccountProtocServiceImpl.1(this);
  private boolean isBindOperator = false;
  private boolean isGetBindFinish;
  private boolean isInGetBindOperator = false;
  private boolean isUnBindOperator = false;
  private Runnable mDayRunnable = new SubAccountProtocServiceImpl.2(this);
  
  public void bindAccount(String paramString1, String paramString2, String paramString3)
  {
    if (this.app == null) {
      return;
    }
    synchronized (lock)
    {
      if (this.isBindOperator) {
        return;
      }
      this.isBindOperator = true;
      ((SubAccountBindHandler)this.app.getBusinessHandler(SubAccountBindHandler.class.getName())).a(paramString1, paramString2, paramString3);
      return;
    }
  }
  
  public void getBindAccount()
  {
    if (this.app == null) {
      return;
    }
    synchronized (lock2)
    {
      if (this.isInGetBindOperator) {
        return;
      }
      this.isInGetBindOperator = true;
      ((SubAccountBindHandler)this.app.getBusinessHandler(SubAccountBindHandler.class.getName())).a();
      return;
    }
  }
  
  public boolean getBindAccountFinish()
  {
    synchronized (lock2)
    {
      boolean bool = this.isGetBindFinish;
      return bool;
    }
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.app = ((AppInterface)paramAppRuntime);
    this.isBindOperator = false;
    this.isUnBindOperator = false;
    this.isInGetBindOperator = false;
    this.isGetBindFinish = false;
    this.app.addObserver(this.bindObserver);
    if (QLog.isColorLevel()) {
      QLog.d("Q.subaccount.SubAccountProtocManager", 2, "SubAccountProtocManager: manager init");
    }
  }
  
  public void onDestroy()
  {
    this.app.removeObserver(this.bindObserver);
    if (ThreadManager.getSubThreadHandler() != null) {
      ThreadManager.getSubThreadHandler().removeCallbacks(this.mDayRunnable);
    }
  }
  
  public void unBindAccount(String paramString)
  {
    if (this.app == null) {
      return;
    }
    synchronized (lock1)
    {
      if (this.isUnBindOperator) {
        return;
      }
      this.isUnBindOperator = true;
      ((SubAccountBindHandler)this.app.getBusinessHandler(SubAccountBindHandler.class.getName())).a(paramString);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.subaccount.api.impl.SubAccountProtocServiceImpl
 * JD-Core Version:    0.7.0.1
 */