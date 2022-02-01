package com.tencent.qqmini.sdk.core.manager;

import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.Observable;

public class ObserverManager
  extends Observable
{
  private final String TAG = "MsgObserverManager";
  
  public void notifyChange(Object paramObject)
  {
    if (QMLog.isColorLevel()) {
      QMLog.d("MsgObserverManager", "notifyChange...msg=" + paramObject);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.manager.ObserverManager
 * JD-Core Version:    0.7.0.1
 */