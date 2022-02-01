package com.tencent.mobileqq.ocr.data;

import java.util.ArrayList;

public class ARCloudOcrResult$YoutuOcrResult
{
  public int a;
  public String b;
  public int c;
  public String d;
  public String e;
  public String f;
  public String g;
  public ArrayList<String> h;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ssoErrCode:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(",ssoErrMsg:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(",errCode:");
    localStringBuilder.append(this.c);
    localStringBuilder.append(",errMsg:");
    localStringBuilder.append(this.d);
    localStringBuilder.append(",session_id:");
    localStringBuilder.append(this.e);
    localStringBuilder.append(",content:");
    localStringBuilder.append(this.f);
    localStringBuilder.append(",language");
    localStringBuilder.append(this.g);
    localStringBuilder.append(",ocr_language_list");
    localStringBuilder.append(this.h);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.data.ARCloudOcrResult.YoutuOcrResult
 * JD-Core Version:    0.7.0.1
 */