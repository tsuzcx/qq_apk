package com.tencent.mobileqq.uftransfer.task.upload;

import com.tencent.mobileqq.uftransfer.api.IUFTUploadCompleteInfo;

public class UFTUploadCompleteInfo
  implements IUFTUploadCompleteInfo
{
  private String a;
  private boolean b = false;
  private String c;
  private String d;
  private boolean e = false;
  private boolean f = false;
  private boolean g = false;
  private boolean h = false;
  private String i;
  private int j = 0;
  private int k = 0;
  
  public void a(int paramInt)
  {
    this.j = paramInt;
  }
  
  public void a(String paramString)
  {
    this.a = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public boolean a()
  {
    return this.b;
  }
  
  public String b()
  {
    return this.c;
  }
  
  public void b(int paramInt)
  {
    this.k = paramInt;
  }
  
  public void b(String paramString)
  {
    this.c = paramString;
  }
  
  public void b(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public String c()
  {
    return this.d;
  }
  
  public void c(String paramString)
  {
    this.d = paramString;
  }
  
  public int d()
  {
    return this.j;
  }
  
  public void d(String paramString)
  {
    this.i = paramString;
  }
  
  public int e()
  {
    return this.k;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.task.upload.UFTUploadCompleteInfo
 * JD-Core Version:    0.7.0.1
 */