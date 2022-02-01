package com.tencent.mobileqq.qassistant.core;

import com.tencent.mobileqq.qassistant.command.ICommand;
import com.tencent.mobileqq.qassistant.data.CommandInfo;
import com.tencent.qphone.base.util.QLog;

public class VoiceModel
{
  private IBasePresenter a;
  
  public VoiceModel(IBasePresenter paramIBasePresenter)
  {
    this.a = paramIBasePresenter;
  }
  
  public void a(CommandInfo paramCommandInfo)
  {
    if (paramCommandInfo == null) {
      if (QLog.isColorLevel()) {
        QLog.d("VoiceModel", 2, "executeCommand commandInformation is null");
      }
    }
    ICommand localICommand;
    do
    {
      return;
      localICommand = new CommandFactory(this.a).a(paramCommandInfo.a);
    } while (localICommand == null);
    new CommandInvoker(localICommand).a(paramCommandInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.core.VoiceModel
 * JD-Core Version:    0.7.0.1
 */