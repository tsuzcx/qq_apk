package com.tencent.mobileqq.ocr.req;

import com.tencent.mobileqq.utils.FileUtils;

public class OCRReqContext
{
  public String a;
  public int b;
  public String c;
  public String d;
  public long e;
  public String f;
  public String g;
  public boolean h;
  public int i;
  public int j;
  public long k;
  public String l;
  
  public void a(String paramString)
  {
    this.a = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public boolean a()
  {
    return (this.i > 0) && (this.j > 0) && (FileUtils.fileExistsAndNotEmpty(this.d));
  }
  
  public String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OCRReqContext{chatType=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", imagePath='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", compressPath='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", oriMd5='");
    localStringBuilder.append(this.f);
    localStringBuilder.append('\'');
    localStringBuilder.append(", comMd5='");
    localStringBuilder.append(this.g);
    localStringBuilder.append('\'');
    localStringBuilder.append(", hasCrop=");
    localStringBuilder.append(this.h);
    localStringBuilder.append('\'');
    localStringBuilder.append(", comWidth=");
    localStringBuilder.append(this.i);
    localStringBuilder.append('\'');
    localStringBuilder.append(", comHeiht=");
    localStringBuilder.append(this.j);
    localStringBuilder.append('\'');
    localStringBuilder.append(", serverUrl=");
    localStringBuilder.append(this.l);
    localStringBuilder.append('\'');
    localStringBuilder.append(", seqNumber=");
    localStringBuilder.append(this.k);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void b(String paramString)
  {
    this.c = paramString;
  }
  
  public void c()
  {
    this.d = "";
    this.c = "";
    this.l = "";
    this.a = "";
    this.f = "";
    this.g = "";
    this.h = false;
    this.k = 0L;
    this.e = 0L;
    this.i = 0;
    this.j = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.req.OCRReqContext
 * JD-Core Version:    0.7.0.1
 */