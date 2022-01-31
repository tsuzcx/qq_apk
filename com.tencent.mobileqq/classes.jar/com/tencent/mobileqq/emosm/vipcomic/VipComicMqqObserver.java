package com.tencent.mobileqq.emosm.vipcomic;

import com.tencent.mobileqq.app.BusinessObserver;

public class VipComicMqqObserver
  implements BusinessObserver
{
  public void a(Object paramObject) {}
  
  public void b(Object paramObject) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    case 3: 
    default: 
      return;
    case 2: 
      a(paramObject);
      return;
    }
    b(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.vipcomic.VipComicMqqObserver
 * JD-Core Version:    0.7.0.1
 */