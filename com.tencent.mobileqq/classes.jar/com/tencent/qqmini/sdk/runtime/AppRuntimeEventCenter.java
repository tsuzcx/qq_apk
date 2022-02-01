package com.tencent.qqmini.sdk.runtime;

import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.Observable;

public class AppRuntimeEventCenter
  extends Observable
{
  public static final String TAG = "minisdk-start_AppStateManager";
  
  public void notifyChange(Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("notifyChange msg=");
    localStringBuilder.append(paramObject);
    QMLog.d("minisdk-start_AppStateManager", localStringBuilder.toString());
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
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.AppRuntimeEventCenter
 * JD-Core Version:    0.7.0.1
 */