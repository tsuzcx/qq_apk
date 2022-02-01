package com.tencent.mobileqq.relationx.icebreaking.bean;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MiniCard$QZoneInfo
{
  public String a = "";
  public String b = "";
  public List<String> c = new ArrayList();
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(1024);
    localStringBuilder.append("qzoneName");
    localStringBuilder.append("=");
    localStringBuilder.append(this.a);
    localStringBuilder.append("|");
    localStringBuilder.append("updateContent");
    localStringBuilder.append("=");
    localStringBuilder.append(this.b);
    localStringBuilder.append("|");
    localStringBuilder.append("imgUrls");
    localStringBuilder.append("=");
    localStringBuilder.append(Arrays.toString(this.c.toArray()));
    localStringBuilder.append("|");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.relationx.icebreaking.bean.MiniCard.QZoneInfo
 * JD-Core Version:    0.7.0.1
 */