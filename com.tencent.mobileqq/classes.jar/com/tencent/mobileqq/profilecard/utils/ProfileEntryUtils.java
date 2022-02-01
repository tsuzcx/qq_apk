package com.tencent.mobileqq.profilecard.utils;

import com.tencent.mobileqq.profilecard.data.AllInOne;

public class ProfileEntryUtils
{
  public static int getIdentityFlag(AllInOne paramAllInOne)
  {
    if (paramAllInOne.pa == 0) {
      return 2;
    }
    if (ProfilePAUtils.isPaTypeFriend(paramAllInOne)) {
      return 0;
    }
    return 1;
  }
  
  public static int getProfileEntryType(int paramInt)
  {
    if (paramInt == 1) {
      return paramInt;
    }
    if ((paramInt >= 4) && (paramInt <= 21)) {
      return paramInt;
    }
    if ((paramInt >= 30) && (paramInt <= 37)) {
      return paramInt;
    }
    if (paramInt == 57) {
      return paramInt;
    }
    if (paramInt == 59) {
      return paramInt;
    }
    if ((paramInt >= 60) && (paramInt <= 61)) {
      return paramInt;
    }
    if ((paramInt >= 64) && (paramInt <= 68)) {
      return paramInt;
    }
    if (paramInt == 84) {
      return paramInt;
    }
    if ((paramInt >= 87) && (paramInt <= 88)) {
      return paramInt;
    }
    if (paramInt == 98) {
      return paramInt;
    }
    return 999;
  }
  
  public static boolean isFromDating(int paramInt)
  {
    switch (paramInt)
    {
    case 12: 
    case 14: 
    case 16: 
    default: 
      return false;
    }
    return true;
  }
  
  public static boolean isFromFreshNews(int paramInt)
  {
    return (paramInt == 32) || (paramInt == 34) || (paramInt == 35);
  }
  
  public static boolean isFromHotChat(int paramInt)
  {
    return (paramInt == 20) || (paramInt == 31) || (paramInt == 33);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.utils.ProfileEntryUtils
 * JD-Core Version:    0.7.0.1
 */