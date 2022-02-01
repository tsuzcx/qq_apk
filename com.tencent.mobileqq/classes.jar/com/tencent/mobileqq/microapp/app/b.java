package com.tencent.mobileqq.microapp.app;

import com.tencent.qphone.base.util.QLog;
import java.util.Observable;

public final class b
  extends Observable
{
  private static b a;
  private static byte[] b = new byte[0];
  
  public static b a()
  {
    if (a == null) {
      synchronized (b)
      {
        if (a == null) {
          a = new b();
        }
      }
    }
    return a;
  }
  
  public void a(Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("notifyChange...msg=");
      localStringBuilder.append(paramObject);
      QLog.d("MiniAppStateManager", 2, localStringBuilder.toString());
    }
    setChanged();
    if (paramObject != null)
    {
      notifyObservers(paramObject);
      return;
    }
    notifyObservers();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.app.b
 * JD-Core Version:    0.7.0.1
 */