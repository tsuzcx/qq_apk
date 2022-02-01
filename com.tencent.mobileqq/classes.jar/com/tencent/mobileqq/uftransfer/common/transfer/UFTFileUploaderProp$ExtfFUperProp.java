package com.tencent.mobileqq.uftransfer.common.transfer;

import com.tencent.mobileqq.uftransfer.api.UFTTransferConfig.ExtfUploadCfg;

public class UFTFileUploaderProp$ExtfFUperProp
{
  protected long a;
  protected int b;
  protected long c;
  protected int d;
  protected int e;
  protected int f;
  protected long g;
  protected final UFTFileUploaderProp.ExtfFileInfo h = new UFTFileUploaderProp.ExtfFileInfo();
  protected final UFTFileUploaderProp.ExtfSvrInfo i = new UFTFileUploaderProp.ExtfSvrInfo();
  protected boolean j;
  protected UFTTransferConfig.ExtfUploadCfg k = new UFTTransferConfig.ExtfUploadCfg();
  protected String l;
  
  public long a()
  {
    return this.a;
  }
  
  public void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.a = paramLong;
  }
  
  public void a(UFTTransferConfig.ExtfUploadCfg paramExtfUploadCfg)
  {
    this.k = paramExtfUploadCfg;
  }
  
  public void a(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }
  
  public int b()
  {
    return this.b;
  }
  
  public void b(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void b(long paramLong)
  {
    this.c = paramLong;
  }
  
  public long c()
  {
    return this.c;
  }
  
  public void c(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void c(long paramLong)
  {
    this.g = paramLong;
  }
  
  public int d()
  {
    return this.f;
  }
  
  public void d(int paramInt)
  {
    this.e = paramInt;
  }
  
  public int e()
  {
    return this.d;
  }
  
  public int f()
  {
    return this.e;
  }
  
  public UFTFileUploaderProp.ExtfFileInfo g()
  {
    return this.h;
  }
  
  public UFTFileUploaderProp.ExtfSvrInfo h()
  {
    return this.i;
  }
  
  public long i()
  {
    return this.g;
  }
  
  public boolean j()
  {
    return this.j;
  }
  
  public UFTTransferConfig.ExtfUploadCfg k()
  {
    return this.k;
  }
  
  public boolean l()
  {
    if (this.d == 0)
    {
      this.l = "businissId is 0";
      return false;
    }
    if (this.e == 0)
    {
      this.l = "bigDataCmdId is 0";
      return false;
    }
    UFTFileUploaderProp.ExtfFileInfo localExtfFileInfo = this.h;
    if (localExtfFileInfo == null)
    {
      this.l = "fileInfo is null";
      return false;
    }
    if (this.i == null)
    {
      this.l = "svrInfo is null";
      return false;
    }
    if (!localExtfFileInfo.j())
    {
      this.l = this.h.k();
      return false;
    }
    if (!this.i.g())
    {
      this.l = this.i.h();
      return false;
    }
    return true;
  }
  
  public String m()
  {
    return this.l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.common.transfer.UFTFileUploaderProp.ExtfFUperProp
 * JD-Core Version:    0.7.0.1
 */