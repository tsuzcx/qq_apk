package com.tencent.mobileqq.troop.data;

import android.support.annotation.NonNull;

class TroopCreateLogic$NameForCompare
  implements Comparable<NameForCompare>
{
  public String a;
  public String b;
  
  TroopCreateLogic$NameForCompare(TroopCreateLogic paramTroopCreateLogic) {}
  
  public int a(@NonNull NameForCompare paramNameForCompare)
  {
    return this.b.compareTo(paramNameForCompare.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopCreateLogic.NameForCompare
 * JD-Core Version:    0.7.0.1
 */