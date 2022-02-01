package com.tencent.mobileqq.easysync2;

import android.support.annotation.Nullable;
import com.tencent.mobileqq.easysync2.utils.Utils;

public class AText
{
  public String a;
  public String b;
  
  public AText(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof AText)) {
      return false;
    }
    paramObject = (AText)paramObject;
    return (Utils.a(this.a, paramObject.a)) && (Utils.a(this.b, paramObject.b));
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AText{text='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", attribs='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.easysync2.AText
 * JD-Core Version:    0.7.0.1
 */