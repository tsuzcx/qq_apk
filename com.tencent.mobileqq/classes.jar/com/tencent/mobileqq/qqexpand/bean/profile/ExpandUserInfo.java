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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.bean.profile.ExpandUserInfo
 * JD-Core Version:    0.7.0.1
 */