package com.tencent.mobileqq.qassistant.command;

import com.tencent.mobileqq.qassistant.api.IVoiceCommand;
import com.tencent.mobileqq.qassistant.core.IBasePresenter;
import com.tencent.mobileqq.qassistant.data.CommandInfo;

public class FinishAssistantCommand
  implements IVoiceCommand
{
  private IBasePresenter a;
  
  public FinishAssistantCommand(IBasePresenter paramIBasePresenter)
  {
    this.a = paramIBasePresenter;
  }
  
  public void a(CommandInfo paramCommandInfo)
  {
    IBasePresenter localIBasePresenter = this.a;
    if (localIBasePresenter != null) {
      localIBasePresenter.c(paramCommandInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.command.FinishAssistantCommand
 * JD-Core Version:    0.7.0.1
 */