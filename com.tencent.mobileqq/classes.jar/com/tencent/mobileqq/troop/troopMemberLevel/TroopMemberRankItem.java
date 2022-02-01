package com.tencent.mobileqq.troop.troopmemberlevel;

public class TroopMemberRankItem
{
  public int a = 0;
  public int b = 0;
  public String c = "";
  public int[] d = null;
  public int[] e = null;
  public boolean f = false;
  public boolean g = false;
  public int h = -1;
  public int i = -1;
  public String j;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("rankId = ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(",realLevel = ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(",rankTitle = ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(",isShowLevel");
    localStringBuilder.append(this.f);
    localStringBuilder.append(",isShowRank = ");
    localStringBuilder.append(this.g);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopmemberlevel.TroopMemberRankItem
 * JD-Core Version:    0.7.0.1
 */