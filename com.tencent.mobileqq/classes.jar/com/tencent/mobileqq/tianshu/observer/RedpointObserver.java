package com.tencent.mobileqq.tianshu.observer;

import com.tencent.mobileqq.app.BusinessObserver;

public class RedpointObserver
  implements BusinessObserver
{
  public void a(boolean paramBoolean) {}
  
  public void b(boolean paramBoolean) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 3: 
      a(paramBoolean);
      return;
    }
    b(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.tianshu.observer.RedpointObserver
 * JD-Core Version:    0.7.0.1
 */