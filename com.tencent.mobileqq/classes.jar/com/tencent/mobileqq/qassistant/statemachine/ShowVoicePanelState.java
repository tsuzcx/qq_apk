package com.tencent.mobileqq.qassistant.statemachine;

import android.os.Message;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qassistant.api.IVoiceAssistantCore;
import com.tencent.mobileqq.qassistant.core.AssistantPanelManager;
import com.tencent.mobileqq.qassistant.core.AssistantUtils;
import com.tencent.mobileqq.qassistant.core.ViewCommandModelCheck;
import com.tencent.mobileqq.qassistant.core.VoiceMainPresenter;
import com.tencent.mobileqq.qassistant.listener.IPanelEventListener;
import com.tencent.mobileqq.qassistant.util.CommandUtils;
import com.tencent.mobileqq.qassistant.util.ReportUtils;
import com.tencent.mobileqq.qassistant.util.VoiceDataUtils;
import com.tencent.mobileqq.qassistant.wake.WakeManager;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingPermission;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;
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
    if (!WakeManager.a().b())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShowVoicePanelState", 2, "enterVoicePanel not allow");
      }
      return 3;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineVoiceAssistantStateMachine;
    if ((localObject != null) && (((VoiceAssistantStateMachine)localObject).a() != null))
    {
      IVoiceAssistantCore localIVoiceAssistantCore = AssistantUtils.a();
      if (localIVoiceAssistantCore == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShowVoicePanelState", 2, "enterVoicePanel voiceAssistant is null");
        }
        return 2;
      }
      int i = this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineVoiceAssistantStateMachine.a().a(this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineVoiceAssistantStateMachine.a().a());
      if (i == 1)
      {
        ((IQQFloatingPermission)QRoute.api(IQQFloatingPermission.class)).enterPermissionRequestDialogCustom(localIVoiceAssistantCore.getActivity(), 2131720318, 2131720317);
        return i;
      }
      if (i == 0)
      {
        if (localIVoiceAssistantCore.isSilent()) {
          QQToast.a(MobileQQ.sMobileQQ, 2131695325, 1).a();
        }
        localObject = VoiceDataUtils.a(1);
        if (!NetworkUtil.isNetworkAvailable(MobileQQ.sMobileQQ)) {
          localObject = MobileQQ.sMobileQQ.getString(2131695327);
        }
        localIVoiceAssistantCore.executeCommand(CommandUtils.a((String)localObject, true));
        localObject = this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineVoiceAssistantStateMachine;
        if ((localObject != null) && (((VoiceAssistantStateMachine)localObject).a() != null)) {
          this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineVoiceAssistantStateMachine.a().a();
        }
      }
      return i;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ShowVoicePanelState", 2, "enterVoicePanel mVoicePresenter is null");
    }
    return 2;
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
    int i = paramMessage.what;
    if (i != 2)
    {
      if (i != 3) {
        return super.a(paramMessage);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineVoiceAssistantStateMachine != null)
      {
        if (this.jdField_a_of_type_Int == 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineVoiceAssistantStateMachine.c(4);
          return true;
        }
        this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineVoiceAssistantStateMachine.c(1);
        this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineVoiceAssistantStateMachine.a(1);
      }
      return true;
    }
    ThreadManager.getUIHandler().post(new ShowVoicePanelState.1(this));
    return true;
  }
  
  public void b()
  {
    super.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.statemachine.ShowVoicePanelState
 * JD-Core Version:    0.7.0.1
 */