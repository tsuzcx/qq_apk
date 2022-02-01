package com.tencent.mobileqq.search.model;

import android.text.TextUtils;

public class RelativeWord
{
  public String a;
  public String b;
  
  public RelativeWord(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
  }
  
  public boolean a()
  {
    return !TextUtils.isEmpty(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.RelativeWord
 * JD-Core Version:    0.7.0.1
 */