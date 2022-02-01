package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.transfile.api.impl.HttpEngineServiceImpl;
import mqq.manager.Manager;

public class NetEngineFactory
  implements Manager
{
  public static final int HTTP_COMMUNICATOR_ENGINE = 0;
  public static final String TAG = "Q.richmedia.NetEngineFactory";
  public HttpEngineServiceImpl mNetEngineImpl;
  public IHttpEngineService mPluginHttpEngine;
  
  public IHttpEngineService getPluginHttpEngine()
  {
    if (this.mPluginHttpEngine == null) {
      try
      {
        HttpCommunicator localHttpCommunicator = new HttpCommunicator(32);
        localHttpCommunicator.start();
        this.mPluginHttpEngine = new HttpEngineServiceImpl(localHttpCommunicator, true);
      }
      finally {}
    }
    return this.mPluginHttpEngine;
  }
  
  public void onDestroy()
  {
    Object localObject = this.mNetEngineImpl;
    if (localObject != null) {
      ((HttpEngineServiceImpl)localObject).destroy();
    }
    localObject = this.mPluginHttpEngine;
    if (localObject != null) {
      ((HttpEngineServiceImpl)localObject).destroy();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.NetEngineFactory
 * JD-Core Version:    0.7.0.1
 */