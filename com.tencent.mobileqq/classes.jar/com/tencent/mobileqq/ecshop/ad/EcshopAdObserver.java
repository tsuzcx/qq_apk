package com.tencent.mobileqq.ecshop.ad;

import com.tencent.mobileqq.app.BusinessObserver;

public class EcshopAdObserver
  implements BusinessObserver
{
  public void a(Object paramObject) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 1) {
      return;
    }
    a(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.ad.EcshopAdObserver
 * JD-Core Version:    0.7.0.1
 */