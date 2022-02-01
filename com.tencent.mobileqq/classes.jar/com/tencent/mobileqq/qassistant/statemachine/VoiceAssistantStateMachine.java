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
  private InitState a;
  private WakeListenerState b;
  private ShowVoicePanelState c;
  private CommandRecognizeState d;
  private QuitVoicePanelState e;
  private QuitState f;
  private VoiceMainPresenter g;
  private IPanelEventListener h;
  private AssistantPanelManager i;
  private IVoiceCommandListener j;
  private volatile IVoiceMessageListener k;
  
  public VoiceAssistantStateMachine(String paramString, VoiceMainPresenter paramVoiceMainPresenter)
  {
    super(paramString);
    this.g = paramVoiceMainPresenter;
    r();
  }
  
  private void r()
  {
    this.a = new InitState(this);
    this.b = new WakeListenerState(this);
    this.c = new ShowVoicePanelState(this);
    this.d = new CommandRecognizeState(this);
    this.e = new QuitVoicePanelState(this);
    this.f = new QuitState(this);
    a(this.a);
    a(this.b);
    a(this.c);
    a(this.d);
    a(this.e);
    a(this.f);
    b(this.a);
  }
  
  public void a(ConfirmSendInfo paramConfirmSendInfo)
  {
    c(4, paramConfirmSendInfo);
    paramConfirmSendInfo = this.j;
    if (paramConfirmSendInfo != null) {
      paramConfirmSendInfo.e();
    }
  }
  
  public void a(IPanelEventListener paramIPanelEventListener)
  {
    this.h = paramIPanelEventListener;
  }
  
  public void a(IVoiceCommandListener paramIVoiceCommandListener)
  {
    this.j = paramIVoiceCommandListener;
  }
  
  public void a(IVoiceVadListener paramIVoiceVadListener)
  {
    if (paramIVoiceVadListener != null)
    {
      CommandRecognizeState localCommandRecognizeState = this.d;
      if ((localCommandRecognizeState != null) && (localCommandRecognizeState.a() != null))
      {
        this.d.a().a(paramIVoiceVadListener);
        this.k = this.d.a();
        return;
      }
    }
    this.k = null;
  }
  
  protected void b(Message paramMessage)
  {
    if (paramMessage.what == 4)
    {
      e(5);
      a(paramMessage);
    }
    super.b(paramMessage);
  }
  
  public void c(int paramInt, Object paramObject)
  {
    if (this.k != null)
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
            this.k.a(paramObject);
            AudioUtil.b(2131230804, false);
            return;
          }
          this.k.h();
          AudioUtil.b(2131230804, false);
          return;
        }
        this.k.g();
        AudioUtil.b(2131230804, false);
        return;
      }
      AudioUtil.b(2131230805, false);
      this.k.f();
    }
  }
  
  public void d(int paramInt)
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
    c(paramInt);
  }
  
  public void e(int paramInt)
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
      a(this.f);
      return;
    case 5: 
      a(this.e);
      return;
    case 4: 
      a(this.d);
      return;
    case 3: 
      a(this.c);
      return;
    case 2: 
      a(this.b);
      return;
    case 1: 
      a(this.a);
    }
  }
  
  public void f()
  {
    e();
  }
  
  public IVoiceCommandListener g()
  {
    return this.j;
  }
  
  public IPanelEventListener h()
  {
    return this.h;
  }
  
  public VoiceMainPresenter i()
  {
    return this.g;
  }
  
  public void j()
  {
    AssistantPanelManager localAssistantPanelManager = this.i;
    if (localAssistantPanelManager != null) {
      localAssistantPanelManager.a();
    }
  }
  
  public AssistantPanelManager k()
  {
    if (this.i == null) {
      this.i = new AssistantPanelManager();
    }
    return this.i;
  }
  
  public boolean l()
  {
    AssistantPanelManager localAssistantPanelManager = this.i;
    return (localAssistantPanelManager != null) && (localAssistantPanelManager.b());
  }
  
  public VoicePttInfo m()
  {
    CommandRecognizeState localCommandRecognizeState = this.d;
    if ((localCommandRecognizeState != null) && (localCommandRecognizeState.a() != null)) {
      return this.d.a().i();
    }
    return null;
  }
  
  public void n()
  {
    c(2, null);
    IVoiceCommandListener localIVoiceCommandListener = this.j;
    if (localIVoiceCommandListener != null) {
      localIVoiceCommandListener.c();
    }
  }
  
  public void o()
  {
    c(1, null);
    IVoiceCommandListener localIVoiceCommandListener = this.j;
    if (localIVoiceCommandListener != null) {
      localIVoiceCommandListener.d();
    }
  }
  
  public void p()
  {
    IVoiceCommandListener localIVoiceCommandListener = this.j;
    if (localIVoiceCommandListener != null) {
      localIVoiceCommandListener.g();
    }
  }
  
  public void q()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceAssistantStateMachine", 2, "doQuit");
    }
    e(6);
    a(null);
    a(null);
    a(null);
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.statemachine.VoiceAssistantStateMachine
 * JD-Core Version:    0.7.0.1
 */