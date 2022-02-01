package com.tencent.mobileqq.cmshow.engine.script.task;

public abstract class InitSpriteTask
  extends AbsScriptTask
{
  private String a;
  
  public InitSpriteTask a(String paramString)
  {
    this.a = paramString;
    return this;
  }
  
  public String b()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.engine.script.task.InitSpriteTask
 * JD-Core Version:    0.7.0.1
 */