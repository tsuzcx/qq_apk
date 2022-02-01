package com.tencent.mobileqq.intervideo.impl;

import com.tencent.mobileqq.intervideo.DataLocalTmpPmUpdater;
import com.tencent.mobileqq.intervideo.IDataLocalTmpPmUpdaterFactory;
import com.tencent.shadow.dynamic.host.PluginManagerUpdater;

public class DataLocalTmpPmUpdaterFactoryImpl
  implements IDataLocalTmpPmUpdaterFactory
{
  public PluginManagerUpdater createDataLocalTmpPmUpdater(String paramString)
  {
    return new DataLocalTmpPmUpdater(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.impl.DataLocalTmpPmUpdaterFactoryImpl
 * JD-Core Version:    0.7.0.1
 */