package com.tencent.rmonitor.base.config.data;

import org.jetbrains.annotations.NotNull;

public class MemoryLeakPluginConfig
  extends RPluginConfig
{
  private boolean a = true;
  private int b = 100;
  private boolean c = false;
  private boolean d = true;
  
  public MemoryLeakPluginConfig(int paramInt1, int paramInt2, float paramFloat, int paramInt3)
  {
    super(paramInt1, paramInt2, paramFloat, paramInt3);
  }
  
  public MemoryLeakPluginConfig(RPluginConfig paramRPluginConfig)
  {
    super(paramRPluginConfig);
  }
  
  @NotNull
  public MemoryLeakPluginConfig a()
  {
    return new MemoryLeakPluginConfig(this);
  }
  
  public void a(RPluginConfig paramRPluginConfig)
  {
    super.a(paramRPluginConfig);
    if ((paramRPluginConfig instanceof MemoryLeakPluginConfig))
    {
      paramRPluginConfig = (MemoryLeakPluginConfig)paramRPluginConfig;
      this.a = paramRPluginConfig.a;
      this.b = paramRPluginConfig.b;
      this.c = paramRPluginConfig.c;
      this.d = paramRPluginConfig.d;
    }
  }
  
  public boolean c()
  {
    return this.a;
  }
  
  public int d()
  {
    return this.b;
  }
  
  public boolean e()
  {
    return this.c;
  }
  
  public boolean f()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.base.config.data.MemoryLeakPluginConfig
 * JD-Core Version:    0.7.0.1
 */