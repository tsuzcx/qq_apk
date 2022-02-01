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
  private VoiceAssistantStateMachine a;
  private volatile int b = 2;
  
  public ShowVoicePanelState(VoiceAssistantStateMachine paramVoiceAssistantStateMachine)
  {
    this.a = paramVoiceAssistantStateMachine;
  }
  
  public int a()
  {
    if (!WakeManager.a().h())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShowVoicePanelState", 2, "enterVoicePanel not allow");
      }
      return 3;
    }
    Object localObject = this.a;
    if ((localObject != null) && (((VoiceAssistantStateMachine)localObject).i() != null))
    {
      IVoiceAssistantCore localIVoiceAssistantCore = AssistantUtils.a();
      if (localIVoiceAssistantCore == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShowVoicePanelState", 2, "enterVoicePanel voiceAssistant is null");
        }
        return 2;
      }
      int i = this.a.k().a(this.a.i().b());
      if (i == 1)
      {
        ((IQQFloatingPermission)QRoute.api(IQQFloatingPermission.class)).enterPermissionRequestDialogCustom(localIVoiceAssistantCore.getActivity(), 2131917953, 2131917952);
        return i;
      }
      if (i == 0)
      {
        if (localIVoiceAssistantCore.isSilent()) {
          QQToast.makeText(MobileQQ.sMobileQQ, 2131893060, 1).show();
        }
        localObject = VoiceDataUtils.a(1);
        if (!NetworkUtil.isNetworkAvailable(MobileQQ.sMobileQQ)) {
          localObject = MobileQQ.sMobileQQ.getString(2131893062);
        }
        localIVoiceAssistantCore.executeCommand(CommandUtils.a((String)localObject, true));
        localObject = this.a;
        if ((localObject != null) && (((VoiceAssistantStateMachine)localObject).h() != null)) {
          this.a.h().a();
        }
      }
      return i;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ShowVoicePanelState", 2, "enterVoicePanel mVoicePresenter is null");
    }
    return 2;
  }
  
  public boolean a(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 2)
    {
      if (i != 3) {
        return super.a(paramMessage);
      }
      if (this.a != null)
      {
        if (this.b == 0)
        {
          this.a.e(4);
          return true;
        }
        this.a.e(1);
        this.a.c(1);
      }
      return true;
    }
    ThreadManager.getUIHandler().post(new ShowVoicePanelState.1(this));
    return true;
  }
  
  public void b()
  {
    super.b();
    if (ViewCommandModelCheck.a())
    {
      ReportUtils.e(1);
      return;
    }
    ReportUtils.e(2);
  }
  
  public void c()
  {
    super.c();
  }
  
  public String d()
  {
    return ShowVoicePanelState.class.getSimpleName();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.statemachine.ShowVoicePanelState
 * JD-Core Version:    0.7.0.1
 */