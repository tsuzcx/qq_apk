package com.tencent.mobileqq.qassistant.statemachine;

import android.os.Message;
import com.tencent.mobileqq.qassistant.audio.AudioNewController;
import com.tencent.mobileqq.qassistant.core.AssistantPanelManager;
import com.tencent.mobileqq.qassistant.core.AssistantUtils;
import com.tencent.mobileqq.qassistant.core.VoiceMainPresenter;
import com.tencent.mobileqq.qassistant.data.ConfirmSendInfo;
import com.tencent.mobileqq.qassistant.data.VoicePttInfo;
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
  private volatile IVoiceMessageListener jdField_a_of_type_ComTencentMobileqqQassistantListenerIVoiceMessageListener;
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
  
  public VoicePttInfo a()
  {
    CommandRecognizeState localCommandRecognizeState = this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineCommandRecognizeState;
    if ((localCommandRecognizeState != null) && (localCommandRecognizeState.a() != null)) {
      return this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineCommandRecognizeState.a().a();
    }
    return null;
  }
  
  public IPanelEventListener a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqQassistantListenerIPanelEventListener;
  }
  
  public IVoiceCommandListener a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqQassistantListenerIVoiceCommandListener;
  }
  
  public void a(ConfirmSendInfo paramConfirmSendInfo)
  {
    b(4, paramConfirmSendInfo);
    paramConfirmSendInfo = this.jdField_a_of_type_ComTencentMobileqqQassistantListenerIVoiceCommandListener;
    if (paramConfirmSendInfo != null) {
      paramConfirmSendInfo.e();
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
    if (paramIVoiceVadListener != null)
    {
      CommandRecognizeState localCommandRecognizeState = this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineCommandRecognizeState;
      if ((localCommandRecognizeState != null) && (localCommandRecognizeState.a() != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineCommandRecognizeState.a().a(paramIVoiceVadListener);
        this.jdField_a_of_type_ComTencentMobileqqQassistantListenerIVoiceMessageListener = this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineCommandRecognizeState.a();
        return;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqQassistantListenerIVoiceMessageListener = null;
  }
  
  public boolean a()
  {
    AssistantPanelManager localAssistantPanelManager = this.jdField_a_of_type_ComTencentMobileqqQassistantCoreAssistantPanelManager;
    return (localAssistantPanelManager != null) && (localAssistantPanelManager.a());
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      try
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("doSendMessage what = ");
        localStringBuilder1.append(paramInt);
        localStringBuilder1.append(", currentState = ");
        localStringBuilder1.append(a());
        QLog.d("VoiceAssistantStateMachine", 2, localStringBuilder1.toString());
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("doSendMessage exception = ");
        localStringBuilder2.append(localException.getMessage());
        QLog.d("VoiceAssistantStateMachine", 2, localStringBuilder2.toString());
      }
    }
    a(paramInt);
  }
  
  public void b(int paramInt, Object paramObject)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqQassistantListenerIVoiceMessageListener != null)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4)
            {
              paramObject = new StringBuilder();
              paramObject.append("onVoiceMessageCallBack status error = ");
              paramObject.append(paramInt);
              AssistantUtils.a("VoiceAssistantStateMachine", paramObject.toString());
              return;
            }
            this.jdField_a_of_type_ComTencentMobileqqQassistantListenerIVoiceMessageListener.a(paramObject);
            AudioUtil.b(2131230736, false);
            return;
          }
          this.jdField_a_of_type_ComTencentMobileqqQassistantListenerIVoiceMessageListener.f();
          AudioUtil.b(2131230736, false);
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqQassistantListenerIVoiceMessageListener.e();
        AudioUtil.b(2131230736, false);
        return;
      }
      AudioUtil.b(2131230737, false);
      this.jdField_a_of_type_ComTencentMobileqqQassistantListenerIVoiceMessageListener.d();
    }
  }
  
  protected void b(Message paramMessage)
  {
    if (paramMessage.what == 4)
    {
      c(5);
      a(paramMessage);
    }
    super.b(paramMessage);
  }
  
  public void c(int paramInt)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("transitionToState type = ");
      localStringBuilder.append(paramInt);
      QLog.d("VoiceAssistantStateMachine", 2, localStringBuilder.toString());
    }
    switch (paramInt)
    {
    default: 
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("transitionToState exception type = ");
        localStringBuilder.append(paramInt);
        QLog.d("VoiceAssistantStateMachine", 2, localStringBuilder.toString());
        return;
      }
      break;
    case 6: 
      a(this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineQuitState);
      return;
    case 5: 
      a(this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineQuitVoicePanelState);
      return;
    case 4: 
      a(this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineCommandRecognizeState);
      return;
    case 3: 
      a(this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineShowVoicePanelState);
      return;
    case 2: 
      a(this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineWakeListenerState);
      return;
    case 1: 
      a(this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineInitState);
    }
  }
  
  public void e()
  {
    d();
  }
  
  public void f()
  {
    AssistantPanelManager localAssistantPanelManager = this.jdField_a_of_type_ComTencentMobileqqQassistantCoreAssistantPanelManager;
    if (localAssistantPanelManager != null) {
      localAssistantPanelManager.a();
    }
  }
  
  public void g()
  {
    b(2, null);
    IVoiceCommandListener localIVoiceCommandListener = this.jdField_a_of_type_ComTencentMobileqqQassistantListenerIVoiceCommandListener;
    if (localIVoiceCommandListener != null) {
      localIVoiceCommandListener.c();
    }
  }
  
  public void h()
  {
    b(1, null);
    IVoiceCommandListener localIVoiceCommandListener = this.jdField_a_of_type_ComTencentMobileqqQassistantListenerIVoiceCommandListener;
    if (localIVoiceCommandListener != null) {
      localIVoiceCommandListener.d();
    }
  }
  
  public void i()
  {
    IVoiceCommandListener localIVoiceCommandListener = this.jdField_a_of_type_ComTencentMobileqqQassistantListenerIVoiceCommandListener;
    if (localIVoiceCommandListener != null) {
      localIVoiceCommandListener.g();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.statemachine.VoiceAssistantStateMachine
 * JD-Core Version:    0.7.0.1
 */