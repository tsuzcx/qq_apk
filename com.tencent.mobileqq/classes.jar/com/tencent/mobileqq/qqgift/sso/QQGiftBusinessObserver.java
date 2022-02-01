package com.tencent.mobileqq.qqgift.sso;

import com.tencent.mobileqq.app.BusinessObserver;

public abstract class QQGiftBusinessObserver
  implements BusinessObserver
{
  public abstract void a(int paramInt, boolean paramBoolean, QQGiftRspData paramQQGiftRspData);
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    paramObject = (QQGiftRspData)paramObject;
    if (paramObject != null) {
      a(paramInt, paramBoolean, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.sso.QQGiftBusinessObserver
 * JD-Core Version:    0.7.0.1
 */