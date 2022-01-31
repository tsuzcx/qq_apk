package com.tencent.thumbplayer.tplayer.plugins;

public abstract interface ITPPluginManager
  extends ITPPluginBase
{
  public abstract ITPPluginManager addPlugin(ITPPluginBase paramITPPluginBase);
  
  public abstract void release();
  
  public abstract void removePlugin(ITPPluginBase paramITPPluginBase);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.tplayer.plugins.ITPPluginManager
 * JD-Core Version:    0.7.0.1
 */