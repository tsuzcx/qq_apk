package com.tencent.mobileqq.cmshow.brickengine.apollo;

import com.tencent.mobileqq.apollo.render.IApolloRunnableTask;
import com.tencent.mobileqq.apollo.render.IRenderRunner;
import com.tencent.qphone.base.util.QLog;

class ApolloRenderRunner$1
  extends IApolloRunnableTask
{
  ApolloRenderRunner$1(ApolloRenderRunner paramApolloRenderRunner, IRenderRunner paramIRenderRunner, long paramLong, ApolloCmdChannel paramApolloCmdChannel, int paramInt, String paramString1, String paramString2) {}
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqApolloRenderIRenderRunner;
    if ((localObject != null) && (this.jdField_a_of_type_Long == ((IRenderRunner)localObject).getLuaState()))
    {
      this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloCmdChannel.callbackEngineWrapper(this.jdField_a_of_type_ComTencentMobileqqApolloRenderIRenderRunner.isJsRuntime(), this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.b);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("apolloSurfaceView.queueEvent mNativeSSOReqMgr.callbackEngine cmd:");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
        QLog.d("apollochannel_JsRenderRunner", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloRenderRunner.1
 * JD-Core Version:    0.7.0.1
 */