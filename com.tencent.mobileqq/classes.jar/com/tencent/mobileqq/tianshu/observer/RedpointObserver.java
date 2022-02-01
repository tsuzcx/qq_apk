package com.tencent.mobileqq.tianshu.observer;

import com.tencent.mobileqq.app.BusinessObserver;

public class RedpointObserver
  implements BusinessObserver
{
  public void a(boolean paramBoolean) {}
  
  public void b(boolean paramBoolean) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 3)
    {
      if (paramInt != 4) {
        return;
      }
      b(paramBoolean);
      return;
    }
    a(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.tianshu.observer.RedpointObserver
 * JD-Core Version:    0.7.0.1
 */