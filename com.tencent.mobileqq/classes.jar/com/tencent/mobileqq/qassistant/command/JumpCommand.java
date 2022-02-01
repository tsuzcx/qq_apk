package com.tencent.mobileqq.qassistant.command;

import com.tencent.mobileqq.qassistant.api.IVoiceCommand;
import com.tencent.mobileqq.qassistant.core.IBasePresenter;
import com.tencent.mobileqq.qassistant.data.CommandInfo;

public class JumpCommand
  implements IVoiceCommand
{
  private IBasePresenter a;
  
  public JumpCommand(IBasePresenter paramIBasePresenter)
  {
    this.a = paramIBasePresenter;
  }
  
  public void a(CommandInfo paramCommandInfo)
  {
    IBasePresenter localIBasePresenter = this.a;
    if (localIBasePresenter != null) {
      localIBasePresenter.a(paramCommandInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.command.JumpCommand
 * JD-Core Version:    0.7.0.1
 */