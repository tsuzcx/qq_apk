package com.tencent.mobileqq.cmshow.brickengine.apollo;

import com.tencent.qphone.base.util.QLog;

class ApolloRenderRunner$1
  extends IApolloRunnableTask
{
  ApolloRenderRunner$1(ApolloRenderRunner paramApolloRenderRunner, IRenderRunner paramIRenderRunner, long paramLong, ApolloCmdChannel paramApolloCmdChannel, int paramInt, String paramString1, String paramString2) {}
  
  public void run()
  {
    Object localObject = this.a;
    if ((localObject != null) && (this.b == ((IRenderRunner)localObject).getLuaState()))
    {
      this.c.callbackEngineWrapper(this.a.isJsRuntime(), this.b, this.d, this.e, this.f);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("apolloSurfaceView.queueEvent mNativeSSOReqMgr.callbackEngine cmd:");
        ((StringBuilder)localObject).append(this.e);
        QLog.d("apollochannel_JsRenderRunner", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloRenderRunner.1
 * JD-Core Version:    0.7.0.1
 */