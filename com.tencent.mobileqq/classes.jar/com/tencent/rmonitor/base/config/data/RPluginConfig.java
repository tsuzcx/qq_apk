package com.tencent.rmonitor.base.config.data;

import org.jetbrains.annotations.NotNull;

public class RPluginConfig
  implements Cloneable
{
  public int f;
  public int g;
  public float h;
  public int i;
  
  public RPluginConfig(int paramInt1, int paramInt2, float paramFloat, int paramInt3)
  {
    this.f = paramInt1;
    this.g = paramInt2;
    this.h = paramFloat;
    this.i = paramInt3;
  }
  
  public RPluginConfig(RPluginConfig paramRPluginConfig)
  {
    a(paramRPluginConfig);
  }
  
  public void a(RPluginConfig paramRPluginConfig)
  {
    if (paramRPluginConfig == null) {
      return;
    }
    this.f = paramRPluginConfig.f;
    this.g = paramRPluginConfig.g;
    this.h = paramRPluginConfig.h;
    this.i = paramRPluginConfig.i;
  }
  
  @NotNull
  public RPluginConfig b()
  {
    return new RPluginConfig(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.base.config.data.RPluginConfig
 * JD-Core Version:    0.7.0.1
 */