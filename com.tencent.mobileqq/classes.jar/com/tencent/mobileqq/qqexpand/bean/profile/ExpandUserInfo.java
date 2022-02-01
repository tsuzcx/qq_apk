package com.tencent.mobileqq.qqexpand.bean.profile;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class ExpandUserInfo
  extends Entity
{
  public static final int FROM_CAMPUS = 1;
  public static final int FROM_CHAT = 3;
  public static final int FROM_SIGNAL = 4;
  public static final int FROM_VOICE = 2;
  private static final int SUB_ID_OTHERS = 11;
  public int fromType;
  @unique
  public String uin;
  
  public static int fromTypeToSubID(int paramInt)
  {
    int i = 2;
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if ((paramInt == 3) || (paramInt != 4)) {
          return 8;
        }
        return 12;
      }
    }
    else {
      i = 10;
    }
    return i;
  }
  
  public static int getReportSubId(int paramInt)
  {
    if ((paramInt != 1) && (paramInt != 2) && (paramInt != 3) && (paramInt != 4)) {
      if (paramInt != 5)
      {
        if ((paramInt != 12) && (paramInt != 102) && (paramInt != 105) && (paramInt != 106))
        {
          switch (paramInt)
          {
          default: 
            return 11;
          case 303: 
            return 17;
          case 302: 
            return 18;
          }
          return 20;
        }
      }
      else {
        return 16;
      }
    }
    return 15;
  }
  
  public static int subIDToFromType(int paramInt)
  {
    int i = 2;
    if ((paramInt != 10) && (paramInt != 3))
    {
      if (paramInt != 1)
      {
        if (paramInt == 2) {
          return 2;
        }
        if ((paramInt != 11) && (paramInt != 12)) {
          return 3;
        }
        return 4;
      }
    }
    else {
      i = 1;
    }
    return i;
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("uin:");
    localStringBuilder.append(this.uin);
    localStringBuilder.append(",");
    localStringBuilder.append("fromType:");
    localStringBuilder.append(this.fromType);
    localStringBuilder.append(",");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.bean.profile.ExpandUserInfo
 * JD-Core Version:    0.7.0.1
 */