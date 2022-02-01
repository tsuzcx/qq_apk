package com.tencent.rfw.barrage.core;

import android.os.Handler.Callback;
import android.os.Message;
import java.lang.ref.WeakReference;

class RFWBarrageManager$BarrageHandlerCallback
  implements Handler.Callback
{
  private WeakReference<RFWBarrageManager> a;
  
  private RFWBarrageManager$BarrageHandlerCallback(RFWBarrageManager paramRFWBarrageManager)
  {
    this.a = new WeakReference(paramRFWBarrageManager);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    RFWBarrageManager localRFWBarrageManager = (RFWBarrageManager)this.a.get();
    if (localRFWBarrageManager == null) {
      return false;
    }
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 11: 
      RFWBarrageManager.g(localRFWBarrageManager);
      return false;
    case 10: 
      RFWBarrageManager.f(localRFWBarrageManager);
      return false;
    case 9: 
      RFWBarrageManager.e(localRFWBarrageManager);
      return false;
    case 8: 
      localRFWBarrageManager.p();
      return false;
    case 7: 
      RFWBarrageManager.d(localRFWBarrageManager);
      return false;
    case 6: 
      RFWBarrageManager.c(localRFWBarrageManager);
      return false;
    case 5: 
      localRFWBarrageManager.a(paramMessage);
      return false;
    case 4: 
      localRFWBarrageManager.o();
      return false;
    case 3: 
      RFWBarrageManager.b(localRFWBarrageManager);
      return false;
    case 2: 
      RFWBarrageManager.a(localRFWBarrageManager);
      return false;
    }
    RFWBarrageManager.a(localRFWBarrageManager, paramMessage);
    RFWBarrageManager.a(localRFWBarrageManager);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rfw.barrage.core.RFWBarrageManager.BarrageHandlerCallback
 * JD-Core Version:    0.7.0.1
 */