package com.tencent.mobileqq.guild.message;

public class PullGuildMsgCachekey
{
  private String a;
  private int b;
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (PullGuildMsgCachekey)paramObject;
      String str1 = paramObject.a;
      if (str1 != null)
      {
        String str2 = this.a;
        if (str2 == null) {
          return false;
        }
        return (str1.equals(str2)) && (paramObject.b == this.b);
      }
    }
    return false;
  }
  
  public int hashCode()
  {
    String str = this.a;
    int i;
    if (str != null) {
      i = str.hashCode();
    } else {
      i = 0;
    }
    return (527 + i) * 31 + this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.PullGuildMsgCachekey
 * JD-Core Version:    0.7.0.1
 */