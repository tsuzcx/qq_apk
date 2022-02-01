package com.tencent.mobileqq.qassistant.command;

import com.tencent.mobileqq.qassistant.api.IVoiceCommand;
import com.tencent.mobileqq.qassistant.core.IBasePresenter;
import com.tencent.mobileqq.qassistant.data.CommandInfo;

public class ShowCancelRecordViewCommand
  implements IVoiceCommand
{
  private IBasePresenter a;
  
  public ShowCancelRecordViewCommand(IBasePresenter paramIBasePresenter)
  {
    this.a = paramIBasePresenter;
  }
  
  public void a(CommandInfo paramCommandInfo)
  {
    IBasePresenter localIBasePresenter = this.a;
    if (localIBasePresenter != null) {
      localIBasePresenter.g(paramCommandInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.command.ShowCancelRecordViewCommand
 * JD-Core Version:    0.7.0.1
 */