package com.tencent.mobileqq.qassistant.core;

import com.tencent.mobileqq.qassistant.command.ICommand;
import com.tencent.mobileqq.qassistant.data.CommandInfo;

public class CommandInvoker
{
  private ICommand a;
  
  public CommandInvoker(ICommand paramICommand)
  {
    this.a = paramICommand;
  }
  
  public void a(CommandInfo paramCommandInfo)
  {
    if (this.a != null) {
      this.a.a(paramCommandInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.core.CommandInvoker
 * JD-Core Version:    0.7.0.1
 */