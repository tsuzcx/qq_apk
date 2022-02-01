package com.tencent.mobileqq.qassistant.core;

import com.tencent.mobileqq.qassistant.api.IVoiceCommand;
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
    if (paramCommandInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VoiceModel", 2, "executeCommand commandInformation is null");
      }
      return;
    }
    IVoiceCommand localIVoiceCommand = new CommandFactory(this.a).a(paramCommandInfo.a);
    if (localIVoiceCommand != null) {
      new CommandInvoker(localIVoiceCommand).a(paramCommandInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.core.VoiceModel
 * JD-Core Version:    0.7.0.1
 */