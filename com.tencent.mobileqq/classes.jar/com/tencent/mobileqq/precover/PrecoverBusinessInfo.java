package com.tencent.mobileqq.precover;

import android.text.TextUtils;

public class PrecoverBusinessInfo
{
  public String a;
  public String b;
  
  public boolean a()
  {
    return (!TextUtils.isEmpty(this.a)) && (!TextUtils.isEmpty(this.b));
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("PrecoverBusinessInfo:");
    localStringBuilder.append("businessId=").append(this.a);
    localStringBuilder.append(", name=").append(this.b);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.precover.PrecoverBusinessInfo
 * JD-Core Version:    0.7.0.1
 */