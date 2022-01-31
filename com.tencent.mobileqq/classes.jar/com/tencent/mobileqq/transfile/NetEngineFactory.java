package com.tencent.mobileqq.transfile;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.utils.httputils.HttpCommunicator;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorFlowCount;
import mqq.manager.Manager;

public class NetEngineFactory
  implements Manager
{
  public INetEngine a;
  public INetEngine b;
  
  public INetEngine a(AppInterface paramAppInterface, int paramInt)
  {
    if (paramInt == 0)
    {
      if (this.a == null) {}
      try
      {
        if (this.a == null) {
          this.a = new OldHttpEngine(paramAppInterface.getHttpCommunicatort(), false);
        }
        return this.a;
      }
      finally {}
    }
    return null;
  }
  
  public INetEngine a(IHttpCommunicatorFlowCount paramIHttpCommunicatorFlowCount)
  {
    if (this.b == null) {}
    try
    {
      paramIHttpCommunicatorFlowCount = new HttpCommunicator(paramIHttpCommunicatorFlowCount, 32);
      paramIHttpCommunicatorFlowCount.a();
      this.b = new OldHttpEngine(paramIHttpCommunicatorFlowCount, true);
      return this.b;
    }
    finally {}
  }
  
  public void onDestroy()
  {
    if (this.a != null) {
      ((OldHttpEngine)this.a).a();
    }
    if (this.b != null) {
      ((OldHttpEngine)this.b).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.NetEngineFactory
 * JD-Core Version:    0.7.0.1
 */