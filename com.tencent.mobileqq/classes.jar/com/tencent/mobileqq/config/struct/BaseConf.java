package com.tencent.mobileqq.config.struct;

import com.tencent.mobileqq.config.ConfigManager;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.ArrayList;

public abstract class BaseConf
{
  public short a = 0;
  public long b = 0L;
  public long c = -1L;
  public long d = -1L;
  public byte e = -1;
  protected ArrayList f = new ArrayList();
  private final int g = ConfigManager.a();
  private boolean h = false;
  
  public BaseConf(short paramShort, byte paramByte)
  {
    this.a = paramShort;
    this.e = paramByte;
  }
  
  public abstract void a();
  
  public abstract void a(DataInputStream paramDataInputStream);
  
  public abstract void a(DataOutputStream paramDataOutputStream);
  
  public void a(Object paramObject)
  {
    this.f.add(paramObject);
  }
  
  public void a(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.trim().equals("")) {
        return;
      }
      int i = 0;
      while (i < this.f.size())
      {
        PicAndAdConf.PicStruct localPicStruct = (PicAndAdConf.PicStruct)this.f.get(i);
        if ((localPicStruct.f != null) && (localPicStruct.f.contains(paramString))) {
          break label72;
        }
        i += 1;
      }
      i = -1;
      label72:
      if (i != -1) {
        this.f.remove(i);
      }
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public final int b()
  {
    return this.f.size();
  }
  
  public final boolean c()
  {
    long l = this.d;
    return (l > 0L) && (l <= System.currentTimeMillis());
  }
  
  public final boolean d()
  {
    return this.c > System.currentTimeMillis();
  }
  
  public void e()
  {
    this.f.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.struct.BaseConf
 * JD-Core Version:    0.7.0.1
 */