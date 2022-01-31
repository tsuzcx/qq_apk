package com.tencent.mobileqq.data;

import auko;
import aumc;

public class Ability
  extends auko
{
  public static final int ABILITY_PHOTO = 2;
  public static final int ABILITY_VIDEO = 1;
  public int flags;
  @aumc
  public String uin;
  
  public static boolean hasAbility(int paramInt1, int paramInt2)
  {
    return (paramInt1 & paramInt2) != 0;
  }
  
  public void addAbility(int paramInt)
  {
    this.flags |= paramInt;
  }
  
  public void removeAbility(int paramInt)
  {
    this.flags &= (paramInt ^ 0xFFFFFFFF);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.Ability
 * JD-Core Version:    0.7.0.1
 */