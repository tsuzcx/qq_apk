package com.tencent.mobileqq.businessCard;

import android.os.Bundle;
import mqq.observer.BusinessObserver;

public class BusinessCardObserver
  implements BusinessObserver
{
  public void a(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, String paramString) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt) {}
  
  public void b(boolean paramBoolean, String paramString) {}
  
  public void b(boolean paramBoolean, String paramString, int paramInt) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4)
          {
            if (paramInt != 5) {
              return;
            }
            a(paramBoolean, paramBundle.getString("key_card_id"), paramBundle.getInt("key_get_detail_type"));
            return;
          }
          a(paramBoolean);
          return;
        }
        b(paramBoolean, paramBundle.getString("key_card_id"));
        return;
      }
      a(paramBoolean, paramBundle.getString("key_card_id"));
      return;
    }
    paramInt = paramBundle.getInt("resp_result", 0);
    b(paramBoolean, paramBundle.getString("key_card_id"), paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.businessCard.BusinessCardObserver
 * JD-Core Version:    0.7.0.1
 */