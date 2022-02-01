package com.tencent.mobileqq.tinyid.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.tinyid.ITinyIDHandler;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class TinyIDHandlerImpl
  implements ITinyIDHandler
{
  private static final String TAG = "TinyIDHandlerImpl";
  private AppRuntime mApp;
  private TinyIDHandler mTinyIDHandler;
  
  private TinyIDHandler getTinyIDHandler()
  {
    AppRuntime localAppRuntime = this.mApp;
    if (!(localAppRuntime instanceof AppInterface))
    {
      QLog.e("TinyIDHandlerImpl", 1, "[onCreate] error, not run in AppInterface!");
      return null;
    }
    return (TinyIDHandler)((AppInterface)localAppRuntime).getBusinessHandler(TinyIDHandler.class.getName());
  }
  
  public String getClassName()
  {
    return null;
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.mApp = paramAppRuntime;
    this.mTinyIDHandler = getTinyIDHandler();
  }
  
  public void onDestroy() {}
  
  public void removeListener(String paramString, TinyIDHandler.Listener paramListener)
  {
    TinyIDHandler localTinyIDHandler = this.mTinyIDHandler;
    if (localTinyIDHandler != null) {
      localTinyIDHandler.a(paramString, paramListener);
    }
  }
  
  public void reqGetTinyID(TinyIDHandler.Listener paramListener)
  {
    TinyIDHandler localTinyIDHandler = this.mTinyIDHandler;
    if (localTinyIDHandler != null) {
      localTinyIDHandler.a(paramListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.tinyid.impl.TinyIDHandlerImpl
 * JD-Core Version:    0.7.0.1
 */