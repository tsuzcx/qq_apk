package com.tencent.mobileqq.qcall;

import com.tencent.mobileqq.app.BusinessObserver;

public class QCallCardObserver
  implements BusinessObserver
{
  public void a(boolean paramBoolean, Object paramObject) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 1) {
      return;
    }
    a(paramBoolean, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.qcall.QCallCardObserver
 * JD-Core Version:    0.7.0.1
 */