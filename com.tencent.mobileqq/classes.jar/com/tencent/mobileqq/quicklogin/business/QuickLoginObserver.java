package com.tencent.mobileqq.quicklogin.business;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.qphone.base.util.QLog;

public class QuickLoginObserver
  implements BusinessObserver
{
  public final String a = "QuickLoginObserver";
  
  private void a(boolean paramBoolean, Object paramObject)
  {
    if (a(paramObject))
    {
      a(paramBoolean, ((Long)((Object[])(Object[])paramObject)[0]).longValue());
      return;
    }
    QLog.e("QuickLoginObserver", 2, "onUpdateSetPCVerify error");
  }
  
  private boolean a(Object paramObject)
  {
    return (paramObject != null) && ((paramObject instanceof Object[])) && (((Object[])paramObject).length == 1);
  }
  
  public void a(boolean paramBoolean, long paramLong) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 1) {
      return;
    }
    a(paramBoolean, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.quicklogin.business.QuickLoginObserver
 * JD-Core Version:    0.7.0.1
 */