package com.tencent.mobileqq.data;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class ExtendFriendUserInfo
  extends Entity
{
  public static final int FROM_CAMPUS = 1;
  public static final int FROM_CHAT = 3;
  public static final int FROM_SIGNAL = 4;
  public static final int FROM_VOICE = 2;
  public int distance;
  public boolean enableQQCall;
  public int fromType;
  public String matchSource;
  public String miniProfileMsg;
  public boolean showDistanceHLight;
  public int tagID;
  public String tagName;
  @unique
  public String uin;
  
  public static int fromTypeToSubID(int paramInt)
  {
    switch (paramInt)
    {
    case 3: 
    default: 
      return 8;
    case 1: 
      return 10;
    case 2: 
      return 2;
    }
    return 12;
  }
  
  public static boolean isTagIdFromSignalBomb(int paramInt)
  {
    return paramInt == 0;
  }
  
  public static int subIDToFromType(int paramInt)
  {
    int i = 3;
    if ((paramInt == 10) || (paramInt == 3)) {
      i = 1;
    }
    do
    {
      return i;
      if ((paramInt == 1) || (paramInt == 2)) {
        return 2;
      }
    } while ((paramInt != 11) && (paramInt != 12));
    return 4;
  }
  
  public boolean isSignalBomb()
  {
    return isTagIdFromSignalBomb(this.tagID);
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("uin:").append(this.uin).append(",");
    localStringBuilder.append("tagID:").append(this.tagID).append(",");
    localStringBuilder.append("tagName:").append(this.tagName).append(",");
    localStringBuilder.append("distance:").append(this.distance).append(",");
    localStringBuilder.append("showDistanceHLight:").append(this.showDistanceHLight).append(",");
    localStringBuilder.append("enableQQCall:").append(this.enableQQCall).append(",");
    localStringBuilder.append("fromType:").append(this.fromType).append(",");
    localStringBuilder.append("matchSource:").append(this.matchSource).append(",");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.ExtendFriendUserInfo
 * JD-Core Version:    0.7.0.1
 */