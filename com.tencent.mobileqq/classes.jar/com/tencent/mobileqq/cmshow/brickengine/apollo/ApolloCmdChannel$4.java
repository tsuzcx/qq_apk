package com.tencent.mobileqq.cmshow.brickengine.apollo;

import com.tencent.mobileqq.apollo.render.IApolloRunnableTask;
import com.tencent.mobileqq.apollo.render.IRenderRunner;
import com.tencent.qphone.base.util.QLog;

class ApolloCmdChannel$4
  extends IApolloRunnableTask
{
  ApolloCmdChannel$4(ApolloCmdChannel paramApolloCmdChannel, IRenderRunner paramIRenderRunner, String paramString) {}
  
  public void run()
  {
    this.this$0.callbackEngineWrapper(this.jdField_a_of_type_ComTencentMobileqqApolloRenderIRenderRunner.isJsRuntime(), this.jdField_a_of_type_ComTencentMobileqqApolloRenderIRenderRunner.getLuaState(), 0, "sc.apolloGameWebMessage.local", this.jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleWebEvent data:");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      QLog.d("[cmshow][scripted]cmgame_process.ApolloDataChannel", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloCmdChannel.4
 * JD-Core Version:    0.7.0.1
 */