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
    int i = -1;
    if ((this.f != null) && (paramMemberInfo.f != null)) {
      i = this.f.compareTo(paramMemberInfo.f);
    }
    do
    {
      do
      {
        return i;
        if (this.f != null) {
          break;
        }
      } while (paramMemberInfo.f == null);
      return 1;
    } while (paramMemberInfo.f == null);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.utils.TroopNameHelper.GenTroopNameTask.MemberInfo
 * JD-Core Version:    0.7.0.1
 */