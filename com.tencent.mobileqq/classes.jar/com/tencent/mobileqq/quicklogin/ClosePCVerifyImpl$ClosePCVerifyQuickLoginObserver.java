package com.tencent.mobileqq.quicklogin;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.quicklogin.business.QuickLoginObserver;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Map;

public class ClosePCVerifyImpl$ClosePCVerifyQuickLoginObserver
  extends QuickLoginObserver
{
  private long b;
  private WeakReference<Map<Long, QuickLoginObserver>> c;
  private WeakReference<BaseQQAppInterface> d;
  private WeakReference<ClosePCVerifyProxy> e;
  
  public ClosePCVerifyImpl$ClosePCVerifyQuickLoginObserver(long paramLong, WeakReference<Map<Long, QuickLoginObserver>> paramWeakReference, WeakReference<BaseQQAppInterface> paramWeakReference1, WeakReference<ClosePCVerifyProxy> paramWeakReference2)
  {
    this.b = paramLong;
    this.c = paramWeakReference;
    this.d = paramWeakReference1;
    this.e = paramWeakReference2;
  }
  
  private boolean a()
  {
    WeakReference localWeakReference = this.e;
    return (localWeakReference == null) || (localWeakReference.get() == null);
  }
  
  private boolean a(long paramLong)
  {
    return paramLong != this.b;
  }
  
  private boolean a(Map<Long, QuickLoginObserver> paramMap, BaseQQAppInterface paramBaseQQAppInterface)
  {
    QLog.d("QuickLoginObserver", 1, "wrapper.remove");
    paramMap = (QuickLoginObserver)paramMap.remove(Long.valueOf(this.b));
    if (paramMap == null)
    {
      QLog.e("QuickLoginObserver", 1, "onSetPCVerify fail: observer not exist");
      return true;
    }
    QLog.d("QuickLoginObserver", 1, "appInterface.removeObserver");
    paramBaseQQAppInterface.removeObserver(paramMap);
    return false;
  }
  
  private boolean b()
  {
    WeakReference localWeakReference = this.c;
    return (localWeakReference == null) || (this.d == null) || (localWeakReference.get() == null) || (this.d.get() == null);
  }
  
  public void a(boolean paramBoolean, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSetPCVerify isSuccess: ");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(" mark: ");
    localStringBuilder.append(paramLong);
    QLog.d("QuickLoginObserver", 1, localStringBuilder.toString());
    if (a(paramLong))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSetPCVerify fail: observer not match mark: ");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(" mPbMark: ");
      localStringBuilder.append(this.b);
      QLog.e("QuickLoginObserver", 1, localStringBuilder.toString());
      return;
    }
    if (b())
    {
      QLog.e("QuickLoginObserver", 1, "onSetPCVerify fail: sanity check fail");
      return;
    }
    if (a((Map)this.c.get(), (BaseQQAppInterface)this.d.get()))
    {
      QLog.e("QuickLoginObserver", 1, "cleanObserverAndCheckEmpty observer empty");
      return;
    }
    if (a())
    {
      QLog.e("QuickLoginObserver", 1, "onSetPCVerify fail: mProxy == null");
      return;
    }
    ((ClosePCVerifyProxy)this.e.get()).a(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.quicklogin.ClosePCVerifyImpl.ClosePCVerifyQuickLoginObserver
 * JD-Core Version:    0.7.0.1
 */