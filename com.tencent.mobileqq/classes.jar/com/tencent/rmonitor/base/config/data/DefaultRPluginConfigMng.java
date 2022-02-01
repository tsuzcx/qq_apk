package com.tencent.rmonitor.base.config.data;

import android.util.SparseArray;

public class DefaultRPluginConfigMng
{
  private static final SparseArray<RPluginConfig> a = new SparseArray(12);
  
  public static RPluginConfig a(int paramInt)
  {
    if (a.size() == 0) {
      a();
    }
    return (RPluginConfig)a.get(paramInt);
  }
  
  private static void a()
  {
    a.put(101, new RPluginConfig(100, 30, 0.1F, 0));
    a.put(102, new RPluginConfig(200, 30, 0.1F, 0));
    a.put(105, new RPluginConfig(100, 10, 0.1F, 0));
    a.put(106, new RPluginConfig(100, 10, 0.1F, 0));
    a.put(107, new MemoryLeakPluginConfig(100, 10, 0.1F, 0));
    a.put(108, new RPluginConfig(85, 2, 0.1F, 0));
    a.put(109, new RPluginConfig(85, 3, 0.1F, 0));
    a.put(124, new RPluginConfig(100, 10, 1.0F, 0));
    a.put(131, new RPluginConfig(100, 1, 0.001F, 0));
    a.put(138, new RPluginConfig(100, 100, 0.01F, 0));
    a.put(146, new RPluginConfig(100, 1, 0.001F, 0));
    a.put(152, new RPluginConfig(150, 100, 0.1F, 0));
    a.put(151, new FdLeakPluginConfig(800, 3, 0.8F, 0));
    a.put(154, new NatMemPluginConfig(90, 5, 0.01F, 0, 4096, 4096, 100, false, true, 1073741824L));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.base.config.data.DefaultRPluginConfigMng
 * JD-Core Version:    0.7.0.1
 */