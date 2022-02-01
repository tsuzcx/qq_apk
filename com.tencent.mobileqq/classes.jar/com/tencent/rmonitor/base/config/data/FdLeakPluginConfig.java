package com.tencent.rmonitor.base.config.data;

public class FdLeakPluginConfig
  extends RPluginConfig
{
  public int a = 1;
  public int b = 9;
  public float c = 0.2F;
  public float d = 1.0F;
  public int e = 2;
  
  public FdLeakPluginConfig(int paramInt1, int paramInt2, float paramFloat, int paramInt3)
  {
    super(paramInt1, paramInt2, paramFloat, paramInt3);
  }
  
  public FdLeakPluginConfig(RPluginConfig paramRPluginConfig)
  {
    super(paramRPluginConfig);
  }
  
  public FdLeakPluginConfig a()
  {
    return new FdLeakPluginConfig(this);
  }
  
  public void a(RPluginConfig paramRPluginConfig)
  {
    super.a(paramRPluginConfig);
    if ((paramRPluginConfig instanceof FdLeakPluginConfig))
    {
      paramRPluginConfig = (FdLeakPluginConfig)paramRPluginConfig;
      this.a = paramRPluginConfig.a;
      this.b = paramRPluginConfig.b;
      this.c = paramRPluginConfig.c;
      this.d = paramRPluginConfig.d;
      this.e = paramRPluginConfig.e;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FdLeakPluginConfig{threshold=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", maxReportNum=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", eventSampleRatio=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", stackDepth=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", fdMonitorSwitch=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", hprofStripSwitch=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", reportEventSampleRatio=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", detailEventSampleRatio=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", dumpReportMaxNum=");
    localStringBuilder.append(this.e);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.base.config.data.FdLeakPluginConfig
 * JD-Core Version:    0.7.0.1
 */