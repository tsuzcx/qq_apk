package dov.com.qq.im.capture.data;

import android.os.Bundle;
import mqq.observer.BusinessObserver;

public class CaptureComboObeserver
  implements BusinessObserver
{
  public void a() {}
  
  public void a(Bundle paramBundle) {}
  
  public void a(boolean paramBoolean, Bundle paramBundle) {}
  
  public void b() {}
  
  public void c() {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 967: 
      b();
      return;
    case 968: 
      a(paramBoolean, paramBundle);
      return;
    case 969: 
      c();
      return;
    case 970: 
      a(paramBundle);
      return;
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.data.CaptureComboObeserver
 * JD-Core Version:    0.7.0.1
 */