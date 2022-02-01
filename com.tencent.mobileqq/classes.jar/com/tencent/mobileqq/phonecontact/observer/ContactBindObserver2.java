package com.tencent.mobileqq.phonecontact.observer;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.phonecontact.data.RecommendedListResp;

public class ContactBindObserver2
  implements BusinessObserver
{
  protected void a(RecommendedListResp paramRecommendedListResp) {}
  
  protected void a(boolean paramBoolean) {}
  
  protected void b(boolean paramBoolean) {}
  
  protected void c(boolean paramBoolean) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4) {
            return;
          }
          a(paramBoolean);
          return;
        }
        a((RecommendedListResp)paramObject);
        return;
      }
      c(paramBoolean);
      return;
    }
    b(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.phonecontact.observer.ContactBindObserver2
 * JD-Core Version:    0.7.0.1
 */