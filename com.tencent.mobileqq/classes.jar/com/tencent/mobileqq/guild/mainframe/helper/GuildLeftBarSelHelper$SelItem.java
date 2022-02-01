package com.tencent.mobileqq.guild.mainframe.helper;

public class GuildLeftBarSelHelper$SelItem
{
  public int a = -1;
  public String b;
  
  public GuildLeftBarSelHelper$SelItem(int paramInt, String paramString)
  {
    this.a = paramInt;
    this.b = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramObject != null)
    {
      bool1 = bool2;
      if ((paramObject instanceof SelItem))
      {
        String str1 = this.b;
        bool1 = bool2;
        if (str1 != null)
        {
          paramObject = (SelItem)paramObject;
          String str2 = paramObject.b;
          if (str2 == null) {
            return false;
          }
          bool1 = bool2;
          if (this.a == paramObject.a)
          {
            bool1 = bool2;
            if (str1.equals(str2)) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SelItem{selType=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", selKey='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.helper.GuildLeftBarSelHelper.SelItem
 * JD-Core Version:    0.7.0.1
 */