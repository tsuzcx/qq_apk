package com.tencent.mobileqq.gamecenter.protocol;

import com.tencent.mobileqq.app.BusinessObserver;

public class GameCenterUnissoObserver
  implements BusinessObserver
{
  protected void a() {}
  
  protected void a(Object paramObject) {}
  
  protected void b() {}
  
  protected void b(Object paramObject) {}
  
  protected void c(Object paramObject) {}
  
  protected void d(Object paramObject) {}
  
  protected void e(Object paramObject) {}
  
  protected void f(Object paramObject) {}
  
  protected void g(Object paramObject) {}
  
  protected void h(Object paramObject) {}
  
  protected void i(Object paramObject) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 8272)
    {
      switch (paramInt)
      {
      default: 
        switch (paramInt)
        {
        default: 
          return;
        case 8265: 
          b();
          return;
        case 8264: 
          i(paramObject);
          return;
        case 8263: 
          g(paramObject);
          return;
        case 8262: 
          f(paramObject);
          return;
        }
        e(paramObject);
        return;
      case 8228: 
        d(paramObject);
        return;
      case 8227: 
        a(paramObject);
        return;
      case 8226: 
        c(paramObject);
        return;
      case 8225: 
        b(paramObject);
        return;
      }
      h(paramObject);
      return;
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.protocol.GameCenterUnissoObserver
 * JD-Core Version:    0.7.0.1
 */