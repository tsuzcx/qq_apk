package com.tencent.mobileqq.qassistant.core;

import com.tencent.mobileqq.qassistant.api.IVoiceCommand;
import com.tencent.mobileqq.qassistant.data.CommandInfo;

public class CommandInvoker
{
  private IVoiceCommand a;
  
  public CommandInvoker(IVoiceCommand paramIVoiceCommand)
  {
    this.a = paramIVoiceCommand;
  }
  
  public void a(CommandInfo paramCommandInfo)
  {
    IVoiceCommand localIVoiceCommand = this.a;
    if (localIVoiceCommand != null) {
      localIVoiceCommand.a(paramCommandInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.core.CommandInvoker
 * JD-Core Version:    0.7.0.1
 */