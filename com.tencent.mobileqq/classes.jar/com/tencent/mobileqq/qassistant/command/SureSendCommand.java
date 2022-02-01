package com.tencent.mobileqq.qassistant.command;

import com.tencent.mobileqq.qassistant.core.IBasePresenter;
import com.tencent.mobileqq.qassistant.data.CommandInfo;

public class SureSendCommand
  implements ICommand
{
  private IBasePresenter a;
  
  public SureSendCommand(IBasePresenter paramIBasePresenter)
  {
    this.a = paramIBasePresenter;
  }
  
  public void a(CommandInfo paramCommandInfo)
  {
    if (this.a != null) {
      this.a.k(paramCommandInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.command.SureSendCommand
 * JD-Core Version:    0.7.0.1
 */