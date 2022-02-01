package com.tencent.mobileqq.studymode;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.observer.BusinessObserver;

public class KidModeObserver
  implements BusinessObserver
{
  static final HashMap<Integer, KidModeObserver.Handler> b = new HashMap();
  
  static
  {
    a();
  }
  
  static void a()
  {
    b.put(Integer.valueOf(3), new KidModeObserver.1());
    b.put(Integer.valueOf(4), new KidModeObserver.2());
    b.put(Integer.valueOf(1), new KidModeObserver.3());
    b.put(Integer.valueOf(2), new KidModeObserver.4());
    b.put(Integer.valueOf(5), new KidModeObserver.5());
    b.put(Integer.valueOf(7), new KidModeObserver.6());
    b.put(Integer.valueOf(8), new KidModeObserver.7());
    b.put(Integer.valueOf(9), new KidModeObserver.8());
    b.put(Integer.valueOf(10), new KidModeObserver.9());
    b.put(Integer.valueOf(11), new KidModeObserver.10());
  }
  
  public void a(KidModeObserver.ClearPasswordResult paramClearPasswordResult) {}
  
  public void a(KidModeObserver.QueryPasswordStateResult paramQueryPasswordStateResult) {}
  
  public void a(KidModeObserver.SetNewPasswordResult paramSetNewPasswordResult) {}
  
  public void a(KidModeObserver.VerifyPasswordResult paramVerifyPasswordResult) {}
  
  public void a(boolean paramBoolean, int paramInt) {}
  
  public void a(boolean paramBoolean, Bundle paramBundle) {}
  
  public void b(boolean paramBoolean, Bundle paramBundle) {}
  
  public void c(boolean paramBoolean, Bundle paramBundle) {}
  
  public void d(boolean paramBoolean, Bundle paramBundle) {}
  
  public void e(boolean paramBoolean, Bundle paramBundle) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    KidModeObserver.Handler localHandler = (KidModeObserver.Handler)b.get(Integer.valueOf(paramInt));
    if (localHandler != null)
    {
      localHandler.a(this, paramBoolean, paramBundle);
      return;
    }
    paramBundle = new StringBuilder();
    paramBundle.append("onReceive, unknown type ");
    paramBundle.append(paramInt);
    QLog.w("KidModeObserver", 1, paramBundle.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.KidModeObserver
 * JD-Core Version:    0.7.0.1
 */