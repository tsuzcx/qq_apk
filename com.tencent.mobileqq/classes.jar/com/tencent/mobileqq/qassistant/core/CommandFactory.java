package com.tencent.mobileqq.qassistant.core;

import com.tencent.mobileqq.qassistant.api.IVoiceCommand;
import com.tencent.mobileqq.qassistant.command.BackCommand;
import com.tencent.mobileqq.qassistant.command.CancelSendCommand;
import com.tencent.mobileqq.qassistant.command.ChooseResultCommand;
import com.tencent.mobileqq.qassistant.command.FinishAssistantCommand;
import com.tencent.mobileqq.qassistant.command.JumpCommand;
import com.tencent.mobileqq.qassistant.command.ShowCancelRecordViewCommand;
import com.tencent.mobileqq.qassistant.command.ShowFriendViewCommand;
import com.tencent.mobileqq.qassistant.command.ShowOverSelectViewCommand;
import com.tencent.mobileqq.qassistant.command.ShowRecordViewCommand;
import com.tencent.mobileqq.qassistant.command.ShowResendViewCommand;
import com.tencent.mobileqq.qassistant.command.ShowSelectViewCommand;
import com.tencent.mobileqq.qassistant.command.SmartAnswerCommand;
import com.tencent.mobileqq.qassistant.command.SureSendCommand;
import com.tencent.mobileqq.qassistant.command.ViewCommandCommand;
import com.tencent.mobileqq.qassistant.command.VoiceInteractionCommand;
import com.tencent.qphone.base.util.QLog;

public class CommandFactory
{
  private IBasePresenter a;
  
  public CommandFactory(IBasePresenter paramIBasePresenter)
  {
    this.a = paramIBasePresenter;
  }
  
  public IVoiceCommand a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("createCommand exception commandType = ");
        localStringBuilder.append(paramInt);
        QLog.d("CommandFactory", 2, localStringBuilder.toString());
      }
      break;
    case 14: 
      return new SmartAnswerCommand(this.a);
    case 13: 
      return new BackCommand(this.a);
    case 12: 
      return new ShowOverSelectViewCommand(this.a);
    case 11: 
      return new ShowCancelRecordViewCommand(this.a);
    case 10: 
      return new ChooseResultCommand(this.a);
    case 9: 
      return new SureSendCommand(this.a);
    case 8: 
      return new CancelSendCommand(this.a);
    case 7: 
      return new ShowFriendViewCommand(this.a);
    case 6: 
      return new ShowResendViewCommand(this.a);
    case 5: 
      return new ShowRecordViewCommand(this.a);
    case 4: 
      return new ShowSelectViewCommand(this.a);
    case 3: 
      return new ViewCommandCommand(this.a);
    case 2: 
      return new VoiceInteractionCommand(this.a);
    case 1: 
      return new JumpCommand(this.a);
    case 0: 
      return new FinishAssistantCommand(this.a);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.core.CommandFactory
 * JD-Core Version:    0.7.0.1
 */