package com.tencent.mobileqq.guild.mainframe.helper;

public class GuildAnimatorHelper$AnimatorInfo
{
  public int a = 0;
  public int b;
  public String c;
  public long d;
  
  public GuildAnimatorHelper$AnimatorInfo(int paramInt, String paramString)
  {
    this.b = paramInt;
    this.c = paramString;
    this.d = System.currentTimeMillis();
  }
  
  public boolean a()
  {
    return System.currentTimeMillis() - this.d > 1000L;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramObject != null)
    {
      if (!(paramObject instanceof AnimatorInfo)) {
        return false;
      }
      int i = this.b;
      paramObject = (AnimatorInfo)paramObject;
      bool1 = bool2;
      if (i == paramObject.b)
      {
        bool1 = bool2;
        if (this.c.equals(paramObject.c)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.helper.GuildAnimatorHelper.AnimatorInfo
 * JD-Core Version:    0.7.0.1
 */