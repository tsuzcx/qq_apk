package com.tencent.mobileqq.qassistant.statemachine;

import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

public class StateMachine
{
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private StateMachine.SmHandler jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine$SmHandler;
  private String jdField_a_of_type_JavaLangString;
  
  protected StateMachine(String paramString)
  {
    this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread(paramString);
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    a(paramString, this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
  }
  
  private void a(String paramString, Looper paramLooper)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine$SmHandler = new StateMachine.SmHandler(paramLooper, this, null);
  }
  
  public final Message a(int paramInt)
  {
    return Message.obtain(this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine$SmHandler, paramInt);
  }
  
  public final Message a(int paramInt, Object paramObject)
  {
    return Message.obtain(this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine$SmHandler, paramInt, paramObject);
  }
  
  protected final IState a()
  {
    StateMachine.SmHandler localSmHandler = this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine$SmHandler;
    if (localSmHandler == null) {
      return null;
    }
    return StateMachine.SmHandler.a(localSmHandler);
  }
  
  protected String a(int paramInt)
  {
    return null;
  }
  
  protected String a(Message paramMessage)
  {
    return "";
  }
  
  protected void a() {}
  
  public final void a(int paramInt)
  {
    StateMachine.SmHandler localSmHandler = this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine$SmHandler;
    if (localSmHandler == null) {
      return;
    }
    localSmHandler.sendMessage(a(paramInt));
  }
  
  public final void a(int paramInt, Object paramObject)
  {
    StateMachine.SmHandler localSmHandler = this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine$SmHandler;
    if (localSmHandler == null) {
      return;
    }
    localSmHandler.sendMessage(a(paramInt, paramObject));
  }
  
  protected final void a(Message paramMessage)
  {
    StateMachine.SmHandler.a(this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine$SmHandler, paramMessage);
  }
  
  protected final void a(IState paramIState)
  {
    StateMachine.SmHandler.a(this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine$SmHandler, paramIState);
  }
  
  protected final void a(State paramState)
  {
    StateMachine.SmHandler.a(this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine$SmHandler, paramState, null);
  }
  
  protected void a(String paramString)
  {
    Log.d(this.jdField_a_of_type_JavaLangString, paramString);
  }
  
  protected boolean a(Message paramMessage)
  {
    return true;
  }
  
  protected void b() {}
  
  protected void b(Message paramMessage)
  {
    if (StateMachine.SmHandler.a(this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine$SmHandler)) {
      b(" - unhandledMessage: msg.what=" + paramMessage.what);
    }
  }
  
  protected final void b(State paramState)
  {
    StateMachine.SmHandler.a(this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine$SmHandler, paramState);
  }
  
  protected void b(String paramString)
  {
    Log.e(this.jdField_a_of_type_JavaLangString, paramString);
  }
  
  protected final void c()
  {
    StateMachine.SmHandler localSmHandler = this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine$SmHandler;
    if (localSmHandler == null) {
      return;
    }
    StateMachine.SmHandler.a(localSmHandler);
  }
  
  protected void c(Message paramMessage) {}
  
  public void d()
  {
    StateMachine.SmHandler localSmHandler = this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine$SmHandler;
    if (localSmHandler == null) {
      return;
    }
    StateMachine.SmHandler.b(localSmHandler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.statemachine.StateMachine
 * JD-Core Version:    0.7.0.1
 */