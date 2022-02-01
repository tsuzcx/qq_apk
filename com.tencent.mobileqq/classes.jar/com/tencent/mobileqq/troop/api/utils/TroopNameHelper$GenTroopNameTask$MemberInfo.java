package com.tencent.mobileqq.troop.api.utils;

import android.support.annotation.NonNull;

class TroopNameHelper$GenTroopNameTask$MemberInfo
  implements Comparable<MemberInfo>
{
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean;
  String jdField_b_of_type_JavaLangString;
  boolean jdField_b_of_type_Boolean;
  String c;
  String d;
  String e;
  String f;
  
  TroopNameHelper$GenTroopNameTask$MemberInfo(TroopNameHelper.GenTroopNameTask paramGenTroopNameTask) {}
  
  public int a(@NonNull MemberInfo paramMemberInfo)
  {
    String str1 = this.f;
    if (str1 != null)
    {
      String str2 = paramMemberInfo.f;
      if (str2 != null) {
        return str1.compareTo(str2);
      }
    }
    if (this.f == null)
    {
      if (paramMemberInfo.f != null) {
        return 1;
      }
      return -1;
    }
    if (paramMemberInfo.f == null) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.utils.TroopNameHelper.GenTroopNameTask.MemberInfo
 * JD-Core Version:    0.7.0.1
 */