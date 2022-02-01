package com.tencent.ttpic.openapi.extrastickerutil;

import com.tencent.aekit.openrender.internal.IPluginFilter;

public class PluginFilterAgent
{
  private IPluginFilterFactory mPluginFilterFactory;
  
  public static PluginFilterAgent g()
  {
    return PluginFilterAgent.SINGLETON.instance;
  }
  
  public IPluginFilter createPlugFilter(String paramString1, String paramString2)
  {
    IPluginFilterFactory localIPluginFilterFactory = this.mPluginFilterFactory;
    if (localIPluginFilterFactory == null) {
      return null;
    }
    return localIPluginFilterFactory.createPluginFilter(paramString1, paramString2);
  }
  
  public void setPluginFilterFactory(IPluginFilterFactory paramIPluginFilterFactory)
  {
    this.mPluginFilterFactory = paramIPluginFilterFactory;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.openapi.extrastickerutil.PluginFilterAgent
 * JD-Core Version:    0.7.0.1
 */