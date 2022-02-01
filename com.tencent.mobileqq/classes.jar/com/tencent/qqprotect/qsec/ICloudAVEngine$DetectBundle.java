package com.tencent.qqprotect.qsec;

import android.text.TextUtils;
import com.tencent.qqprotect.singleupdate.MD5FileUtil;

public class ICloudAVEngine$DetectBundle
{
  public int a;
  public int b;
  public int c;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  public byte[] i;
  
  public String a()
  {
    if (!TextUtils.isEmpty(this.e)) {
      return this.e;
    }
    if (TextUtils.isEmpty(this.d)) {
      return null;
    }
    return MD5FileUtil.a(this.d);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[ft:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(",st:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(",fs:");
    localStringBuilder.append(this.c);
    localStringBuilder.append(",fn:");
    localStringBuilder.append(this.d);
    localStringBuilder.append(",fm:");
    localStringBuilder.append(this.e);
    localStringBuilder.append(",a1:");
    localStringBuilder.append(this.f);
    localStringBuilder.append(",a2:");
    localStringBuilder.append(this.g);
    localStringBuilder.append(",a3:");
    localStringBuilder.append(this.h);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqprotect.qsec.ICloudAVEngine.DetectBundle
 * JD-Core Version:    0.7.0.1
 */