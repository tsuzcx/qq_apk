package com.tencent.mobileqq.intervideo.now.dynamic.impl;

import com.tencent.mobileqq.intervideo.now.dynamic.IPluginManagerInterfaceImpl;
import com.tencent.mobileqq.intervideo.now.dynamic.IPluginManagerInterfaceImplApi;
import com.tencent.mobileqq.intervideo.now.dynamic.PluginManagerInterfaceImpl;

public class PluginManagerInterfaceImplApiImpl
  implements IPluginManagerInterfaceImplApi
{
  public IPluginManagerInterfaceImpl getInstance()
  {
    return PluginManagerInterfaceImpl.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.dynamic.impl.PluginManagerInterfaceImplApiImpl
 * JD-Core Version:    0.7.0.1
 */