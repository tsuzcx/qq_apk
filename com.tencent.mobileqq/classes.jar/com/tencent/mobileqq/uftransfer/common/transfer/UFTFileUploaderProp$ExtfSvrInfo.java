package com.tencent.mobileqq.uftransfer.common.transfer;

import com.tencent.mobileqq.uftransfer.api.UFTHost;
import java.util.List;

public class UFTFileUploaderProp$ExtfSvrInfo
{
  protected List<UFTHost> a;
  protected List<UFTHost> b;
  protected List<UFTHost> c;
  protected byte[] d;
  protected boolean e;
  protected String f;
  protected String g;
  
  public List<UFTHost> a()
  {
    return this.a;
  }
  
  public void a(List<UFTHost> paramList)
  {
    this.a = paramList;
  }
  
  public void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.d = paramArrayOfByte;
  }
  
  public List<UFTHost> b()
  {
    return this.b;
  }
  
  public void b(List<UFTHost> paramList)
  {
    this.b = paramList;
  }
  
  public List<UFTHost> c()
  {
    return this.c;
  }
  
  public void c(List<UFTHost> paramList)
  {
    this.c = paramList;
  }
  
  public byte[] d()
  {
    return this.d;
  }
  
  public boolean e()
  {
    return this.e;
  }
  
  public String f()
  {
    return this.f;
  }
  
  public boolean g()
  {
    List localList = this.a;
    if ((localList != null) && (localList.size() != 0)) {
      return true;
    }
    this.g = "bigDataChnHost is empty";
    return false;
  }
  
  public String h()
  {
    return this.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.common.transfer.UFTFileUploaderProp.ExtfSvrInfo
 * JD-Core Version:    0.7.0.1
 */