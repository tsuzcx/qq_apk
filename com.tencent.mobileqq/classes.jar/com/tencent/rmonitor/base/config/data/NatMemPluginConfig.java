package com.tencent.rmonitor.base.config.data;

import android.app.Application;
import com.tencent.rmonitor.base.meta.BaseInfo;
import java.io.File;
import java.util.List;

public class NatMemPluginConfig
  extends RPluginConfig
{
  private boolean a = false;
  private int b = 50;
  private int c = 100;
  private int d = 4096;
  private int e = 4096;
  private long j = 1073741824L;
  private long k = 4294967296L;
  private String l;
  private boolean m;
  private List<String> n;
  private List<String> o;
  private List<String> p;
  
  public NatMemPluginConfig(int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    super(paramInt1, paramInt2, paramFloat, paramInt3);
    Object localObject;
    if (BaseInfo.app != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(BaseInfo.app.getFilesDir().getPath());
      ((StringBuilder)localObject).append(File.separator);
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = "/storage/emulated/0/";
    }
    this.l = ((String)localObject);
    this.m = true;
    this.n = new NatMemPluginConfig.1(this);
    this.o = new NatMemPluginConfig.2(this);
    this.p = new NatMemPluginConfig.3(this);
    this.d = paramInt4;
    this.e = paramInt5;
    this.b = paramInt6;
    this.a = paramBoolean1;
    this.m = paramBoolean2;
    this.j = paramLong;
  }
  
  public NatMemPluginConfig(NatMemPluginConfig paramNatMemPluginConfig)
  {
    super(paramNatMemPluginConfig);
    Object localObject;
    if (BaseInfo.app != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(BaseInfo.app.getFilesDir().getPath());
      ((StringBuilder)localObject).append(File.separator);
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = "/storage/emulated/0/";
    }
    this.l = ((String)localObject);
    this.m = true;
    this.n = new NatMemPluginConfig.1(this);
    this.o = new NatMemPluginConfig.2(this);
    this.p = new NatMemPluginConfig.3(this);
    a(paramNatMemPluginConfig);
  }
  
  public NatMemPluginConfig a()
  {
    return new NatMemPluginConfig(this);
  }
  
  public void a(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.j = paramLong;
  }
  
  public void a(RPluginConfig paramRPluginConfig)
  {
    super.a(paramRPluginConfig);
    if ((paramRPluginConfig instanceof NatMemPluginConfig))
    {
      paramRPluginConfig = (NatMemPluginConfig)paramRPluginConfig;
      this.d = paramRPluginConfig.d;
      this.e = paramRPluginConfig.e;
      this.b = paramRPluginConfig.b;
      this.a = paramRPluginConfig.a;
      this.j = paramRPluginConfig.j;
      this.l = paramRPluginConfig.l;
      this.n = paramRPluginConfig.n;
      this.o = paramRPluginConfig.o;
      this.p = paramRPluginConfig.p;
      this.m = paramRPluginConfig.m;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public void b(int paramInt)
  {
    this.e = paramInt;
  }
  
  public int c()
  {
    return this.b;
  }
  
  public int d()
  {
    return this.c;
  }
  
  public int e()
  {
    return this.d;
  }
  
  public int f()
  {
    return this.e;
  }
  
  public List<String> g()
  {
    return this.n;
  }
  
  public List<String> h()
  {
    return this.o;
  }
  
  public List<String> i()
  {
    return this.p;
  }
  
  public boolean j()
  {
    return this.a;
  }
  
  public boolean k()
  {
    return this.m;
  }
  
  public long l()
  {
    return this.j;
  }
  
  public long m()
  {
    return this.k;
  }
  
  public String n()
  {
    return this.l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.base.config.data.NatMemPluginConfig
 * JD-Core Version:    0.7.0.1
 */