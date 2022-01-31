package com.tencent.thumbplayer.tplayer.plugins;

public abstract interface ITPPluginBase
{
  public abstract void onAttach();
  
  public abstract void onDetach();
  
  public abstract void onEvent(int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.thumbplayer.tplayer.plugins.ITPPluginBase
 * JD-Core Version:    0.7.0.1
 */