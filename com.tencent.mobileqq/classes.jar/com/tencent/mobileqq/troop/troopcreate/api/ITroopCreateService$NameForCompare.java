package com.tencent.mobileqq.troop.troopcreate.api;

import android.support.annotation.NonNull;

public class ITroopCreateService$NameForCompare
  implements Comparable<NameForCompare>
{
  public String a;
  public String b;
  
  public int a(@NonNull NameForCompare paramNameForCompare)
  {
    return this.b.compareTo(paramNameForCompare.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcreate.api.ITroopCreateService.NameForCompare
 * JD-Core Version:    0.7.0.1
 */