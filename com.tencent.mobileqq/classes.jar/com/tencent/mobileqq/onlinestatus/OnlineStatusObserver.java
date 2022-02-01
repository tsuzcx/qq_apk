package com.tencent.mobileqq.onlinestatus;

import android.os.Bundle;
import com.tencent.mobileqq.app.BusinessObserver;

public class OnlineStatusObserver
  implements BusinessObserver
{
  public void a(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, Bundle paramBundle) {}
  
  public void b(boolean paramBoolean) {}
  
  public void b(boolean paramBoolean, Bundle paramBundle) {}
  
  public void c(boolean paramBoolean, Bundle paramBundle) {}
  
  public void d(boolean paramBoolean, Bundle paramBundle) {}
  
  public void e(boolean paramBoolean, Bundle paramBundle) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 7: 
      b(paramBoolean, (Bundle)paramObject);
      return;
    case 6: 
      b(paramBoolean);
      return;
    case 5: 
      a(paramBoolean);
      return;
    case 4: 
      e(paramBoolean, (Bundle)paramObject);
      return;
    case 3: 
      d(paramBoolean, (Bundle)paramObject);
      return;
    case 2: 
      c(paramBoolean, (Bundle)paramObject);
      return;
    }
    a(paramBoolean, (Bundle)paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.OnlineStatusObserver
 * JD-Core Version:    0.7.0.1
 */