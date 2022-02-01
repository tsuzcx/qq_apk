package com.tencent.mobileqq.troop.quickat.ui;

import android.text.SpannableString;

public class AtTag
{
  public final int a;
  public final SpannableString b;
  
  public AtTag(int paramInt, SpannableString paramSpannableString)
  {
    this.a = paramInt;
    this.b = paramSpannableString;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (AtTag)paramObject;
      if (this.a != paramObject.a) {
        return false;
      }
      SpannableString localSpannableString = this.b;
      if (localSpannableString != null) {
        return localSpannableString.equals(paramObject.b);
      }
      return paramObject.b == null;
    }
    return false;
  }
  
  public int hashCode()
  {
    int j = this.a;
    SpannableString localSpannableString = this.b;
    int i;
    if (localSpannableString != null) {
      i = localSpannableString.hashCode();
    } else {
      i = 0;
    }
    return j * 31 + i;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("AtTag{");
    localStringBuilder.append("startIndex=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", atSpan=");
    localStringBuilder.append(this.b);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.quickat.ui.AtTag
 * JD-Core Version:    0.7.0.1
 */