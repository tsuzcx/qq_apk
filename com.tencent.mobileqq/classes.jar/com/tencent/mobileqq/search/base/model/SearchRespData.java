package com.tencent.mobileqq.search.base.model;

import android.text.TextUtils;

public class SearchRespData
{
  public String a;
  public int b;
  
  public SearchRespData(String paramString, int paramInt)
  {
    this.a = paramString;
    this.b = paramInt;
  }
  
  public boolean a(String paramString)
  {
    if (!TextUtils.isEmpty(this.a)) {
      return this.a.equals(paramString);
    }
    return false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(20);
    localStringBuilder.append("keyword:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" status:");
    localStringBuilder.append(this.b);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.base.model.SearchRespData
 * JD-Core Version:    0.7.0.1
 */