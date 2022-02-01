package com.tencent.mobileqq.troop.honor.config;

public class TroopHonor
  implements Comparable<TroopHonor>
{
  public int a;
  public String b;
  public String c;
  public int d;
  
  public TroopHonor(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramInt2;
  }
  
  public int a(TroopHonor paramTroopHonor)
  {
    int i = this.d;
    int j = paramTroopHonor.d;
    if (i < j) {
      return -1;
    }
    if (i > j) {
      return 1;
    }
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TroopHonor{id=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", name='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", iconUrl='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", priority='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.honor.config.TroopHonor
 * JD-Core Version:    0.7.0.1
 */