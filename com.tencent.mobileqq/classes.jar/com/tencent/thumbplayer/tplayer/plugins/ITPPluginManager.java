package com.tencent.thumbplayer.tplayer.plugins;

public abstract interface ITPPluginManager
  extends ITPPluginBase
{
  public abstract void addPlugin(ITPPluginBase paramITPPluginBase);
  
  public abstract void release();
  
  public abstract void removePlugin(ITPPluginBase paramITPPluginBase);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.thumbplayer.tplayer.plugins.ITPPluginManager
 * JD-Core Version:    0.7.0.1
 */