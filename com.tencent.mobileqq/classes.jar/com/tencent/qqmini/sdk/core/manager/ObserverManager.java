package com.tencent.qqmini.sdk.core.manager;

import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.Observable;

public class ObserverManager
  extends Observable
{
  private static final String TAG = "MsgObserverManager";
  
  public void notifyChange(Object paramObject)
  {
    if (QMLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("notifyChange...msg=");
      localStringBuilder.append(paramObject);
      QMLog.d("MsgObserverManager", localStringBuilder.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.manager.ObserverManager
 * JD-Core Version:    0.7.0.1
 */