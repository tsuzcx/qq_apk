package com.tencent.smtt.export.external.interfaces;

public abstract interface ConsoleMessage
{
  public abstract int lineNumber();
  
  public abstract String message();
  
  public abstract ConsoleMessage.MessageLevel messageLevel();
  
  public abstract String sourceId();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.smtt.export.external.interfaces.ConsoleMessage
 * JD-Core Version:    0.7.0.1
 */