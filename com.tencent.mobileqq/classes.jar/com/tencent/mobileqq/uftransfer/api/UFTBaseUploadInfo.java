package com.tencent.mobileqq.uftransfer.api;

public class UFTBaseUploadInfo
{
  private String a;
  private String b;
  private int c = 0;
  private boolean d = true;
  private boolean e = false;
  private Object f;
  
  public String a()
  {
    return this.a;
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void a(Object paramObject)
  {
    this.f = paramObject;
  }
  
  public void a(String paramString)
  {
    this.a = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public void b(String paramString)
  {
    this.b = paramString;
  }
  
  public void b(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public int c()
  {
    return this.c;
  }
  
  public boolean d()
  {
    return this.d;
  }
  
  public Object e()
  {
    return this.f;
  }
  
  public boolean f()
  {
    return this.e;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("UFTBaseUploadInfo{filePath='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", peerUin='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", peerType=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", needSendMsg=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", isMultiFwd=");
    localStringBuilder.append(this.e);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.api.UFTBaseUploadInfo
 * JD-Core Version:    0.7.0.1
 */