package com.tencent.mobileqq.emosm.vipcomic;

import com.tencent.mobileqq.app.BusinessObserver;

public class VipComicMqqObserver
  implements BusinessObserver
{
  public void a(Object paramObject) {}
  
  public void b(Object paramObject) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 2)
    {
      if (paramInt != 4) {
        return;
      }
      b(paramObject);
      return;
    }
    a(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.vipcomic.VipComicMqqObserver
 * JD-Core Version:    0.7.0.1
 */