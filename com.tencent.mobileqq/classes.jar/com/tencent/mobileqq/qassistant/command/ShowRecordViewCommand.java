package com.tencent.mobileqq.qassistant.command;

import com.tencent.mobileqq.qassistant.core.IBasePresenter;
import com.tencent.mobileqq.qassistant.data.CommandInfo;

public class ShowRecordViewCommand
  implements ICommand
{
  private IBasePresenter a;
  
  public ShowRecordViewCommand(IBasePresenter paramIBasePresenter)
  {
    this.a = paramIBasePresenter;
  }
  
  public void a(CommandInfo paramCommandInfo)
  {
    if (this.a != null) {
      this.a.f(paramCommandInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.command.ShowRecordViewCommand
 * JD-Core Version:    0.7.0.1
 */