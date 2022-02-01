package com.tencent.mobileqq.qassistant.command;

import com.tencent.mobileqq.qassistant.core.IBasePresenter;
import com.tencent.mobileqq.qassistant.data.CommandInfo;

public class VoiceInteractionCommand
  implements ICommand
{
  private IBasePresenter a;
  
  public VoiceInteractionCommand(IBasePresenter paramIBasePresenter)
  {
    this.a = paramIBasePresenter;
  }
  
  public void a(CommandInfo paramCommandInfo)
  {
    if (this.a != null) {
      this.a.b(paramCommandInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.command.VoiceInteractionCommand
 * JD-Core Version:    0.7.0.1
 */