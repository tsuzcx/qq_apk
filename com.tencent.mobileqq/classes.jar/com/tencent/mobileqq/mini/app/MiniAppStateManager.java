package com.tencent.mobileqq.mini.app;

import com.tencent.qphone.base.util.QLog;
import java.util.Observable;

public class MiniAppStateManager
  extends Observable
{
  public static final int STATE_CONF_COMPLETE = 1;
  public static final int STATE_KILL = -1;
  public static final int STATE_NONE = 0;
  public static final int STATE_PRELOAD_COMPLETE = 2;
  public static final String TAG = "MiniAppStateManager";
  private static MiniAppStateManager instance;
  private static byte[] lock = new byte[0];
  
  public static MiniAppStateManager getInstance()
  {
    if (instance == null) {}
    synchronized (lock)
    {
      if (instance == null) {
        instance = new MiniAppStateManager();
      }
      return instance;
    }
  }
  
  public void notifyChange(Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppStateManager", 2, "notifyChange...msg=" + paramObject);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.app.MiniAppStateManager
 * JD-Core Version:    0.7.0.1
 */