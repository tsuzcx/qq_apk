package com.tencent.mobileqq.troop.util.api.impl;

import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.troop.util.api.ITroopMemberInfoUtilsApi;

public class TroopMemberInfoUtilsApiImpl
  implements ITroopMemberInfoUtilsApi
{
  public boolean isValidTroopMemberInfo(TroopMemberInfo paramTroopMemberInfo)
  {
    String str = paramTroopMemberInfo.alias;
    boolean bool2 = false;
    boolean bool1;
    if ((str == null) || (paramTroopMemberInfo.alias.length() <= 0))
    {
      bool1 = bool2;
      if (paramTroopMemberInfo.memberuin != null)
      {
        bool1 = bool2;
        if (paramTroopMemberInfo.memberuin.trim().length() > 0)
        {
          bool1 = bool2;
          if (paramTroopMemberInfo.memberuin.trim().equalsIgnoreCase(String.valueOf(0))) {}
        }
      }
    }
    else
    {
      bool1 = true;
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.util.api.impl.TroopMemberInfoUtilsApiImpl
 * JD-Core Version:    0.7.0.1
 */