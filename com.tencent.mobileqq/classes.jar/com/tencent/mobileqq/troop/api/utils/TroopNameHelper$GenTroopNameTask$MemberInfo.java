package com.tencent.mobileqq.troop.api.utils;

import android.support.annotation.NonNull;

class TroopNameHelper$GenTroopNameTask$MemberInfo
  implements Comparable<MemberInfo>
{
  String a;
  String b;
  String c;
  String d;
  boolean e;
  boolean f;
  String g;
  String h;
  
  TroopNameHelper$GenTroopNameTask$MemberInfo(TroopNameHelper.GenTroopNameTask paramGenTroopNameTask) {}
  
  public int a(@NonNull MemberInfo paramMemberInfo)
  {
    String str1 = this.h;
    if (str1 != null)
    {
      String str2 = paramMemberInfo.h;
      if (str2 != null) {
        return str1.compareTo(str2);
      }
    }
    if (this.h == null)
    {
      if (paramMemberInfo.h != null) {
        return 1;
      }
      return -1;
    }
    if (paramMemberInfo.h == null) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.utils.TroopNameHelper.GenTroopNameTask.MemberInfo
 * JD-Core Version:    0.7.0.1
 */