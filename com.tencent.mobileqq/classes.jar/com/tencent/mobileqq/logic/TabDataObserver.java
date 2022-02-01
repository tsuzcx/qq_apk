package com.tencent.mobileqq.logic;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.qphone.base.util.QLog;

public abstract class TabDataObserver
  implements BusinessObserver
{
  private final String a = "TabDataObserver";
  
  public abstract void a(int paramInt, boolean paramBoolean, Object paramObject);
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TabDataObserver", 2, new Object[] { "onUpdate, type=", Integer.valueOf(paramInt), ", isSuccess=", Boolean.valueOf(paramBoolean) });
    }
    if (paramInt != 0) {
      return;
    }
    a(paramInt, paramBoolean, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.logic.TabDataObserver
 * JD-Core Version:    0.7.0.1
 */