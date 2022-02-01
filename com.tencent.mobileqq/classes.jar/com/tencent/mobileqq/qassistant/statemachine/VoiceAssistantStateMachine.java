package com.tencent.mobileqq.qassistant.statemachine;

import android.os.Message;
import com.tencent.mobileqq.qassistant.audio.AudioNewController;
import com.tencent.mobileqq.qassistant.audio.VoicePttInfo;
import com.tencent.mobileqq.qassistant.core.AssistantPanelManager;
import com.tencent.mobileqq.qassistant.core.AssistantUtils;
import com.tencent.mobileqq.qassistant.core.VoiceMainPresenter;
import com.tencent.mobileqq.qassistant.data.VoiceAssiatantRespInfo.ConfirmSendInfo;
import com.tencent.mobileqq.qassistant.listener.IPanelEventListener;
import com.tencent.mobileqq.qassistant.listener.IVoiceCommandListener;
import com.tencent.mobileqq.qassistant.listener.IVoiceMessageListener;
import com.tencent.mobileqq.qassistant.listener.IVoiceVadListener;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.qphone.base.util.QLog;

public class VoiceAssistantStateMachine
  extends StateMachine
{
  private AssistantPanelManager jdField_a_of_type_ComTencentMobileqqQassistantCoreAssistantPanelManager;
  private VoiceMainPresenter jdField_a_of_type_ComTencentMobileqqQassistantCoreVoiceMainPresenter;
  private IPanelEventListener jdField_a_of_type_ComTencentMobileqqQassistantListenerIPanelEventListener;
  private IVoiceCommandListener jdField_a_of_type_ComTencentMobileqqQassistantListenerIVoiceCommandListener;
  private IVoiceMessageListener jdField_a_of_type_ComTencentMobileqqQassistantListenerIVoiceMessageListener;
  private CommandRecognizeState jdField_a_of_type_ComTencentMobileqqQassistantStatemachineCommandRecognizeState;
  private InitState jdField_a_of_type_ComTencentMobileqqQassistantStatemachineInitState;
  private QuitState jdField_a_of_type_ComTencentMobileqqQassistantStatemachineQuitState;
  private QuitVoicePanelState jdField_a_of_type_ComTencentMobileqqQassistantStatemachineQuitVoicePanelState;
  private ShowVoicePanelState jdField_a_of_type_ComTencentMobileqqQassistantStatemachineShowVoicePanelState;
  private WakeListenerState jdField_a_of_type_ComTencentMobileqqQassistantStatemachineWakeListenerState;
  
  public VoiceAssistantStateMachine(String paramString, VoiceMainPresenter paramVoiceMainPresenter)
  {
    super(paramString);
    this.jdField_a_of_type_ComTencentMobileqqQassistantCoreVoiceMainPresenter = paramVoiceMainPresenter;
    k();
  }
  
  private void k()
  {
    this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineInitState = new InitState(this);
    this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineWakeListenerState = new WakeListenerState(this);
    this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineShowVoicePanelState = new ShowVoicePanelState(this);
    this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineCommandRecognizeState = new CommandRecognizeState(this);
    this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineQuitVoicePanelState = new QuitVoicePanelState(this);
    this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineQuitState = new QuitState(this);
    a(this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineInitState);
    a(this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineWakeListenerState);
    a(this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineShowVoicePanelState);
    a(this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineCommandRecognizeState);
    a(this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineQuitVoicePanelState);
    a(this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineQuitState);
    b(this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineInitState);
  }
  
  public VoicePttInfo a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineCommandRecognizeState != null) && (this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineCommandRecognizeState.a() != null)) {
      return this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineCommandRecognizeState.a().a();
    }
    return null;
  }
  
  public AssistantPanelManager a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqQassistantCoreAssistantPanelManager == null) {
      this.jdField_a_of_type_ComTencentMobileqqQassistantCoreAssistantPanelManager = new AssistantPanelManager();
    }
    return this.jdField_a_of_type_ComTencentMobileqqQassistantCoreAssistantPanelManager;
  }
  
  public VoiceMainPresenter a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqQassistantCoreVoiceMainPresenter;
  }
  
  public IPanelEventListener a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqQassistantListenerIPanelEventListener;
  }
  
  public IVoiceCommandListener a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqQassistantListenerIVoiceCommandListener;
  }
  
  public void a(VoiceAssiatantRespInfo.ConfirmSendInfo paramConfirmSendInfo)
  {
    b(4, paramConfirmSendInfo);
    if (this.jdField_a_of_type_ComTencentMobileqqQassistantListenerIVoiceCommandListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqQassistantListenerIVoiceCommandListener.e();
    }
  }
  
  public void a(IPanelEventListener paramIPanelEventListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqQassistantListenerIPanelEventListener = paramIPanelEventListener;
  }
  
  public void a(IVoiceCommandListener paramIVoiceCommandListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqQassistantListenerIVoiceCommandListener = paramIVoiceCommandListener;
  }
  
  public void a(IVoiceVadListener paramIVoiceVadListener)
  {
    if ((paramIVoiceVadListener != null) && (this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineCommandRecognizeState != null) && (this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineCommandRecognizeState.a() != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineCommandRecognizeState.a().a(paramIVoiceVadListener);
      this.jdField_a_of_type_ComTencentMobileqqQassistantListenerIVoiceMessageListener = this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineCommandRecognizeState.a();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqQassistantListenerIVoiceMessageListener = null;
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqQassistantCoreAssistantPanelManager != null) && (this.jdField_a_of_type_ComTencentMobileqqQassistantCoreAssistantPanelManager.a());
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {}
    try
    {
      QLog.d("VoiceAssistantStateMachine", 2, "doSendMessage what = " + paramInt + ", currentState = " + a());
      a(paramInt);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.d("VoiceAssistantStateMachine", 2, "doSendMessage exception = " + localException.getMessage());
      }
    }
  }
  
  public void b(int paramInt, Object paramObject)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqQassistantListenerIVoiceMessageListener != null) {}
    switch (paramInt)
    {
    default: 
      AssistantUtils.a("VoiceAssistantStateMachine", "onVoiceMessageCallBack status error = " + paramInt);
      return;
    case 1: 
      AudioUtil.b(2131230733, false);
      this.jdField_a_of_type_ComTencentMobileqqQassistantListenerIVoiceMessageListener.d();
      return;
    case 2: 
      this.jdField_a_of_type_ComTencentMobileqqQassistantListenerIVoiceMessageListener.e();
      AudioUtil.b(2131230732, false);
      return;
    case 3: 
      this.jdField_a_of_type_ComTencentMobileqqQassistantListenerIVoiceMessageListener.f();
      AudioUtil.b(2131230732, false);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqQassistantListenerIVoiceMessageListener.a(paramObject);
    AudioUtil.b(2131230732, false);
  }
  
  protected void b(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      super.b(paramMessage);
      return;
      c(5);
      a(paramMessage);
    }
  }
  
  public void c(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceAssistantStateMachine", 2, "transitionToState type = " + paramInt);
    }
    switch (paramInt)
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.d("VoiceAssistantStateMachine", 2, "transitionToState exception type = " + paramInt);
      }
      return;
    case 1: 
      a(this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineInitState);
      return;
    case 2: 
      a(this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineWakeListenerState);
      return;
    case 3: 
      a(this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineShowVoicePanelState);
      return;
    case 4: 
      a(this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineCommandRecognizeState);
      return;
    case 5: 
      a(this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineQuitVoicePanelState);
      return;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineQuitState);
  }
  
  public void e()
  {
    d();
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqQassistantCoreAssistantPanelManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqQassistantCoreAssistantPanelManager.a();
    }
  }
  
  public void g()
  {
    b(2, null);
    if (this.jdField_a_of_type_ComTencentMobileqqQassistantListenerIVoiceCommandListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqQassistantListenerIVoiceCommandListener.c();
    }
  }
  
  public void h()
  {
    b(1, null);
    if (this.jdField_a_of_type_ComTencentMobileqqQassistantListenerIVoiceCommandListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqQassistantListenerIVoiceCommandListener.d();
    }
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqQassistantListenerIVoiceCommandListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqQassistantListenerIVoiceCommandListener.g();
    }
  }
  
  public void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceAssistantStateMachine", 2, "doQuit");
    }
    c(6);
    a(null);
    a(null);
    a(null);
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.statemachine.VoiceAssistantStateMachine
 * JD-Core Version:    0.7.0.1
 */