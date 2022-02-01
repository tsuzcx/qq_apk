package com.tencent.mobileqq.transfile;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.utils.httputils.HttpCommunicator;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorFlowCount;
import mqq.manager.Manager;

public class NetEngineFactory
  implements Manager
{
  public static final int HTTP_COMMUNICATOR_ENGINE = 0;
  public INetEngine mOldHttpEngine;
  public INetEngine mPluginHttpEngine;
  
  public INetEngine getEngineInstance(AppInterface paramAppInterface, int paramInt)
  {
    if (paramInt == 0)
    {
      if (this.mOldHttpEngine == null) {}
      try
      {
        if (this.mOldHttpEngine == null) {
          this.mOldHttpEngine = new OldHttpEngine(paramAppInterface.getHttpCommunicatort(), false);
        }
        return this.mOldHttpEngine;
      }
      finally {}
    }
    return null;
  }
  
  public INetEngine getPluginHttpEngine(IHttpCommunicatorFlowCount paramIHttpCommunicatorFlowCount)
  {
    if (this.mPluginHttpEngine == null) {}
    try
    {
      paramIHttpCommunicatorFlowCount = new HttpCommunicator(paramIHttpCommunicatorFlowCount, 32);
      paramIHttpCommunicatorFlowCount.start();
      this.mPluginHttpEngine = new OldHttpEngine(paramIHttpCommunicatorFlowCount, true);
      return this.mPluginHttpEngine;
    }
    finally {}
  }
  
  public void onDestroy()
  {
    if (this.mOldHttpEngine != null) {
      ((OldHttpEngine)this.mOldHttpEngine).destroy();
    }
    if (this.mPluginHttpEngine != null) {
      ((OldHttpEngine)this.mPluginHttpEngine).destroy();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.NetEngineFactory
 * JD-Core Version:    0.7.0.1
 */