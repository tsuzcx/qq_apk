package com.tencent.rmonitor.base.config.data;

import android.util.SparseArray;
import com.tencent.rmonitor.base.config.PluginCombination;
import com.tencent.rmonitor.base.config.PluginCombination.Companion;
import com.tencent.rmonitor.base.constants.PluginId;

public class RMonitorConfig
{
  public float a = 1.0F;
  public int b = 100;
  public int c = 100;
  public int d = 1;
  public int e = 2;
  public int f = PluginCombination.a.c();
  private final SparseArray<RPluginConfig> g = new SparseArray();
  
  public RMonitorConfig()
  {
    int[] arrayOfInt = PluginId.a;
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = arrayOfInt[i];
      this.g.put(k, DefaultRPluginConfigMng.a(k).b());
      i += 1;
    }
  }
  
  public RPluginConfig a(int paramInt)
  {
    return (RPluginConfig)this.g.get(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.base.config.data.RMonitorConfig
 * JD-Core Version:    0.7.0.1
 */