package com.tencent.mobileqq.qassistant.command;

import com.tencent.mobileqq.qassistant.core.IBasePresenter;
import com.tencent.mobileqq.qassistant.data.CommandInfo;

public class ShowFriendViewCommand
  implements ICommand
{
  private IBasePresenter a;
  
  public ShowFriendViewCommand(IBasePresenter paramIBasePresenter)
  {
    this.a = paramIBasePresenter;
  }
  
  public void a(CommandInfo paramCommandInfo)
  {
    if (this.a != null) {
      this.a.i(paramCommandInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.command.ShowFriendViewCommand
 * JD-Core Version:    0.7.0.1
 */