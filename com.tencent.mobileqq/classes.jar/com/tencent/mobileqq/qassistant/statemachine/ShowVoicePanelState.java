package com.tencent.mobileqq.qassistant.statemachine;

import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qassistant.core.AssistantPanelManager;
import com.tencent.mobileqq.qassistant.core.AssistantUtils;
import com.tencent.mobileqq.qassistant.core.ViewCommandModelCheck;
import com.tencent.mobileqq.qassistant.core.VoiceAssistantManager;
import com.tencent.mobileqq.qassistant.core.VoiceMainPresenter;
import com.tencent.mobileqq.qassistant.data.VoiceDataUtils;
import com.tencent.mobileqq.qassistant.listener.IPanelEventListener;
import com.tencent.mobileqq.qassistant.util.CommandUtils;
import com.tencent.mobileqq.qassistant.util.ReportUtils;
import com.tencent.mobileqq.qassistant.wake.WakeManager;
import com.tencent.mobileqq.qqfloatingwindow.impl.FloatingScreenPermission;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class ShowVoicePanelState
  extends State
{
  private volatile int jdField_a_of_type_Int = 2;
  private VoiceAssistantStateMachine jdField_a_of_type_ComTencentMobileqqQassistantStatemachineVoiceAssistantStateMachine;
  
  public ShowVoicePanelState(VoiceAssistantStateMachine paramVoiceAssistantStateMachine)
  {
    this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineVoiceAssistantStateMachine = paramVoiceAssistantStateMachine;
  }
  
  public int a()
  {
    int i = 2;
    if (!WakeManager.a().b())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShowVoicePanelState", 2, "enterVoicePanel not allow");
      }
      i = 3;
    }
    VoiceAssistantManager localVoiceAssistantManager;
    do
    {
      do
      {
        return i;
        if ((this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineVoiceAssistantStateMachine != null) && (this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineVoiceAssistantStateMachine.a() != null)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ShowVoicePanelState", 2, "enterVoicePanel mVoicePresenter is null");
      return 2;
      localVoiceAssistantManager = AssistantUtils.a();
      if (localVoiceAssistantManager != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ShowVoicePanelState", 2, "enterVoicePanel voiceAssistant is null");
    return 2;
    i = this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineVoiceAssistantStateMachine.a().a(this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineVoiceAssistantStateMachine.a().a());
    if (i == 1)
    {
      FloatingScreenPermission.enterPermissionRequestDialogCustom(localVoiceAssistantManager.a(), 2131720603, 2131720602);
      return i;
    }
    if (i == 0)
    {
      if (localVoiceAssistantManager.b()) {
        QQToast.a(BaseApplicationImpl.getContext(), 2131695316, 1).a();
      }
      String str = VoiceDataUtils.a(1);
      if (!NetworkUtil.g(BaseApplicationImpl.getApplication())) {
        str = BaseApplicationImpl.getApplication().getString(2131695318);
      }
      localVoiceAssistantManager.a(CommandUtils.a(str, true));
      if ((this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineVoiceAssistantStateMachine != null) && (this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineVoiceAssistantStateMachine.a() != null)) {
        this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineVoiceAssistantStateMachine.a().a();
      }
    }
    return i;
  }
  
  public String a()
  {
    return ShowVoicePanelState.class.getSimpleName();
  }
  
  public void a()
  {
    super.a();
    if (ViewCommandModelCheck.a())
    {
      ReportUtils.e(1);
      return;
    }
    ReportUtils.e(2);
  }
  
  public boolean a(Message paramMessage)
  {
    boolean bool = true;
    switch (paramMessage.what)
    {
    default: 
      bool = super.a(paramMessage);
    }
    do
    {
      return bool;
      ThreadManager.getUIHandler().post(new ShowVoicePanelState.1(this));
      return true;
    } while (this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineVoiceAssistantStateMachine == null);
    if (this.jdField_a_of_type_Int == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineVoiceAssistantStateMachine.c(4);
      return true;
    }
    this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineVoiceAssistantStateMachine.c(1);
    this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineVoiceAssistantStateMachine.a(1);
    return true;
  }
  
  public void b()
  {
    super.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.statemachine.ShowVoicePanelState
 * JD-Core Version:    0.7.0.1
 */