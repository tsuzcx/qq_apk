package com.tencent.mobileqq.mutualmark;

import android.support.annotation.NonNull;

public class MutualMarkGrayTipsHelper$GrayTipHighlightItemInfo
{
  public int a = 0;
  public String b;
  public int c;
  public String d;
  public int e;
  public int f;
  public String g;
  public String h;
  
  public boolean a()
  {
    String str = this.b;
    if (str != null) {
      return str.contains("icon");
    }
    return false;
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GrayTipHighlightItemInfo{");
    localStringBuilder.append("old_key:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", ");
    localStringBuilder.append("old_start:");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", ");
    localStringBuilder.append("id:");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", ");
    localStringBuilder.append("start:");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", ");
    localStringBuilder.append("end:");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", ");
    localStringBuilder.append("key:");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", ");
    localStringBuilder.append("url:");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", ");
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mutualmark.MutualMarkGrayTipsHelper.GrayTipHighlightItemInfo
 * JD-Core Version:    0.7.0.1
 */