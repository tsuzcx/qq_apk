package com.tencent.mobileqq.cmshow.brickengine.apollo;

import com.tencent.qphone.base.util.QLog;

class ApolloCmdChannel$3
  extends IApolloRunnableTask
{
  ApolloCmdChannel$3(ApolloCmdChannel paramApolloCmdChannel, IRenderRunner paramIRenderRunner, String paramString) {}
  
  public void run()
  {
    this.this$0.callbackEngineWrapper(this.a.isJsRuntime(), this.a.getLuaState(), 0, "sc.apolloGameWebMessage.local", this.b);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleWebEvent data:");
      localStringBuilder.append(this.b);
      QLog.d("[cmshow][scripted]cmgame_process.ApolloDataChannel", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloCmdChannel.3
 * JD-Core Version:    0.7.0.1
 */