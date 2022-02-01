package com.tencent.mobileqq.profilecard.utils;

import com.tencent.mobileqq.profilecard.data.AllInOne;

public class ProfilePAUtils
{
  public static boolean isFromDiscussion(int paramInt)
  {
    return (paramInt == 45) || (paramInt == 46) || (paramInt == 47);
  }
  
  public static boolean isFromExtendFriend(AllInOne paramAllInOne)
  {
    boolean bool = false;
    if (paramAllInOne == null) {
      return false;
    }
    if (paramAllInOne.pa == 96) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean isFromTroopMemberCard(int paramInt)
  {
    return (paramInt == 20) || (paramInt == 21) || (paramInt == 22);
  }
  
  public static boolean isFromWholePeopleVote(AllInOne paramAllInOne)
  {
    boolean bool = false;
    if (paramAllInOne == null) {
      return false;
    }
    if (paramAllInOne.pa == 95) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean isNotShowPresent(AllInOne paramAllInOne)
  {
    return (paramAllInOne.pa == 20) || (paramAllInOne.pa == 21) || (paramAllInOne.pa == 22) || (paramAllInOne.pa == 23) || (paramAllInOne.pa == 24) || (paramAllInOne.pa == 120);
  }
  
  public static boolean isPaTypeCanAddAsFriend(AllInOne paramAllInOne)
  {
    if (paramAllInOne.pa == 0) {
      return false;
    }
    if (paramAllInOne.pa == 33) {
      return false;
    }
    if (paramAllInOne.pa != 28)
    {
      if (paramAllInOne.pa == 108) {
        return false;
      }
      if (isPaTypeFriend(paramAllInOne)) {
        return false;
      }
      return paramAllInOne.pa != 80;
    }
    return false;
  }
  
  public static boolean isPaTypeCanFreeCall(AllInOne paramAllInOne)
  {
    if (isPaTypeFriend(paramAllInOne)) {
      return true;
    }
    if (paramAllInOne.pa == 29) {
      return false;
    }
    if (paramAllInOne.pa != 21)
    {
      if (paramAllInOne.pa == 22) {
        return true;
      }
      if (paramAllInOne.pa != 46)
      {
        if (paramAllInOne.pa == 47) {
          return true;
        }
        if (paramAllInOne.pa == 31) {
          return paramAllInOne.sourceID != 3001;
        }
        if (paramAllInOne.pa != 34)
        {
          if (paramAllInOne.pa == 50) {
            return true;
          }
          if (paramAllInOne.pa != 71)
          {
            if (paramAllInOne.pa == 72) {
              return true;
            }
            return paramAllInOne.pa == 80;
          }
        }
      }
    }
    return true;
  }
  
  public static boolean isPaTypeCanTalk(AllInOne paramAllInOne)
  {
    if (isPaTypeFriend(paramAllInOne)) {
      return true;
    }
    if (isPaTypeTempTalk(paramAllInOne)) {
      return true;
    }
    if (paramAllInOne.pa == 29) {
      return false;
    }
    if (paramAllInOne.pa == 41) {
      return true;
    }
    if (paramAllInOne.pa != 21)
    {
      if (paramAllInOne.pa == 58) {
        return true;
      }
      if (paramAllInOne.pa == 3) {
        return paramAllInOne.chatAbility != 0;
      }
      if (paramAllInOne.pa == 31) {
        return paramAllInOne.sourceID != 3001;
      }
      if (paramAllInOne.pa != 34)
      {
        if (paramAllInOne.pa == 50) {
          return true;
        }
        if (paramAllInOne.pa == 46) {
          return true;
        }
        if (paramAllInOne.pa == 56) {
          return true;
        }
        if (paramAllInOne.pa == 71) {
          return true;
        }
        if (paramAllInOne.pa == 70) {
          return true;
        }
        if (paramAllInOne.pa == 95) {}
        return false;
      }
    }
    return true;
  }
  
  public static boolean isPaTypeFriend(AllInOne paramAllInOne)
  {
    if ((paramAllInOne.pa != 30) && (paramAllInOne.pa != 40) && (paramAllInOne.pa != 20) && (paramAllInOne.pa != 1) && (paramAllInOne.pa != 60) && (paramAllInOne.pa != 55) && (paramAllInOne.pa != 45)) {
      return paramAllInOne.pa == 0;
    }
    return true;
  }
  
  public static boolean isPaTypeHasUin(AllInOne paramAllInOne)
  {
    return !isPaTypeStrangerInContact(paramAllInOne);
  }
  
  public static boolean isPaTypeShowAccount(AllInOne paramAllInOne)
  {
    boolean bool1 = isPaTypeStrangerInContact(paramAllInOne);
    boolean bool2 = false;
    if (bool1) {
      return false;
    }
    bool1 = bool2;
    if (paramAllInOne.pa != 41)
    {
      bool1 = bool2;
      if (paramAllInOne.pa != 42)
      {
        if (paramAllInOne.pa == 86) {
          return false;
        }
        if (paramAllInOne.pa == 4) {
          return false;
        }
        if (paramAllInOne.pa == 52) {
          return false;
        }
        bool1 = bool2;
        if (paramAllInOne.pa != 56)
        {
          if (paramAllInOne.pa == 57) {
            return false;
          }
          bool1 = bool2;
          if (paramAllInOne.pa != 71)
          {
            if (paramAllInOne.pa == 72) {
              return false;
            }
            if (paramAllInOne.pa == 58) {
              return false;
            }
            if (paramAllInOne.pa == 80) {
              return false;
            }
            int i = paramAllInOne.pa;
            bool1 = true;
            if (i != 95) {}
          }
        }
      }
    }
    return bool1;
  }
  
  public static boolean isPaTypeStrangerInContact(AllInOne paramAllInOne)
  {
    return (paramAllInOne.pa == 33) || (paramAllInOne.pa == 32) || (paramAllInOne.pa == 31) || (paramAllInOne.pa == 34) || (paramAllInOne.pa == 50) || (paramAllInOne.pa == 51) || (paramAllInOne.pa == 53) || (paramAllInOne.pa == 29) || (paramAllInOne.pa == 36);
  }
  
  public static boolean isPaTypeTempTalk(AllInOne paramAllInOne)
  {
    return (paramAllInOne.pa == 22) || (paramAllInOne.pa == 42) || (paramAllInOne.pa == 2) || (paramAllInOne.pa == 34) || (paramAllInOne.pa == 47) || (paramAllInOne.pa == 57) || (paramAllInOne.pa == 72) || (paramAllInOne.pa == 27) || (paramAllInOne.pa == 74) || (paramAllInOne.pa == 86);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.utils.ProfilePAUtils
 * JD-Core Version:    0.7.0.1
 */