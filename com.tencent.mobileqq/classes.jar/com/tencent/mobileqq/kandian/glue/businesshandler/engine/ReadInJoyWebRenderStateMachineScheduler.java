package com.tencent.mobileqq.kandian.glue.businesshandler.engine;

import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.util.WeakReferenceHandler;

public class ReadInJoyWebRenderStateMachineScheduler
  implements Handler.Callback
{
  private final Handler jdField_a_of_type_AndroidOsHandler;
  private final ReadInJoyWebRenderStateMachineScheduler.StateMachine jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineReadInJoyWebRenderStateMachineScheduler$StateMachine;
  private boolean jdField_a_of_type_Boolean = true;
  private boolean b = false;
  
  public ReadInJoyWebRenderStateMachineScheduler(ReadInJoyWebRenderStateMachineScheduler.StateMachine paramStateMachine)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineReadInJoyWebRenderStateMachineScheduler$StateMachine = paramStateMachine;
    this.jdField_a_of_type_AndroidOsHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
  }
  
  public void a(Bundle paramBundle)
  {
    this.b = false;
    while (!this.b)
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineReadInJoyWebRenderStateMachineScheduler$StateMachine.a(paramBundle);
      if (i != -1) {
        if ((i == 1) && (this.jdField_a_of_type_Boolean))
        {
          Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1);
          localMessage.setData(paramBundle);
          this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
        }
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1) {
      return false;
    }
    if (!this.b) {
      a(paramMessage.getData());
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyWebRenderStateMachineScheduler
 * JD-Core Version:    0.7.0.1
 */