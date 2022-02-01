package com.tencent.mobileqq.gallery.picocr;

import java.util.ArrayList;
import java.util.HashMap;

public class PicOcrRspResult
{
  public String a;
  public int b;
  public int c;
  public String d;
  public String e;
  public ArrayList<PicOcrResultBean> f = new ArrayList();
  public ArrayList<String> g = new ArrayList();
  public HashMap<String, String> h;
  public int i;
  public int j;
  public int k;
  public String l;
  public int m;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mMd5= ");
    localStringBuilder.append(this.a);
    localStringBuilder.append("\n");
    localStringBuilder.append("baseWidth= ");
    localStringBuilder.append(this.b);
    localStringBuilder.append("\n");
    localStringBuilder.append("baseHeight= ");
    localStringBuilder.append(this.c);
    localStringBuilder.append("\n");
    localStringBuilder.append("mLanguage= ");
    localStringBuilder.append(this.d);
    localStringBuilder.append("\n");
    localStringBuilder.append("url= ");
    localStringBuilder.append(this.e);
    localStringBuilder.append("\n");
    localStringBuilder.append("languageList= ");
    localStringBuilder.append(this.g.toString());
    localStringBuilder.append("\n");
    localStringBuilder.append("mSrcLangMap= ");
    localStringBuilder.append(this.h.toString());
    localStringBuilder.append("\n");
    localStringBuilder.append("fileSize= ");
    localStringBuilder.append(this.i);
    localStringBuilder.append("\n");
    localStringBuilder.append("reqHeight= ");
    localStringBuilder.append(this.k);
    localStringBuilder.append("\n");
    localStringBuilder.append("reqWidth= ");
    localStringBuilder.append(this.j);
    localStringBuilder.append("\n");
    localStringBuilder.append("afMd5= ");
    localStringBuilder.append(this.l);
    localStringBuilder.append("\n");
    localStringBuilder.append("rotateDe= ");
    localStringBuilder.append(this.m);
    localStringBuilder.append("\n");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gallery.picocr.PicOcrRspResult
 * JD-Core Version:    0.7.0.1
 */