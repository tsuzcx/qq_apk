package com.tencent.mobileqq.troop.filemanager.data;

import android.content.Context;

public class HanziPinyin
{
  String a;
  String b;
  int c;
  
  public HanziPinyin(Context paramContext, String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString2.length();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2;
    if (this.a != null)
    {
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(", hanzi = ");
      localStringBuilder2.append(this.a);
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    if (this.b != null)
    {
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(", pinyin = ");
      localStringBuilder2.append(this.b);
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    return localStringBuilder1.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.data.HanziPinyin
 * JD-Core Version:    0.7.0.1
 */