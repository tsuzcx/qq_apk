package com.tencent.mobileqq.qshadow.interfaces;

public abstract interface IQShadowPluginManager
{
  public abstract boolean installPlugin();
  
  public abstract boolean isPluginInstalled();
  
  public abstract boolean isPluginRunning();
  
  public abstract boolean uninstallPlugin();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qshadow.interfaces.IQShadowPluginManager
 * JD-Core Version:    0.7.0.1
 */