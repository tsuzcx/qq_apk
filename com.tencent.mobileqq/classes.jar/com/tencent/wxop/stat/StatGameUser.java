package com.tencent.wxop.stat;

public class StatGameUser
  implements Cloneable
{
  private String a = "";
  private String b = "";
  private String c = "";
  
  public StatGameUser() {}
  
  public StatGameUser(String paramString1, String paramString2, String paramString3)
  {
    this.b = paramString1;
    this.a = paramString2;
    this.c = paramString3;
  }
  
  public StatGameUser clone()
  {
    try
    {
      StatGameUser localStatGameUser = (StatGameUser)super.clone();
      return localStatGameUser;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException) {}
    return null;
  }
  
  public String getAccount()
  {
    return this.b;
  }
  
  public String getLevel()
  {
    return this.c;
  }
  
  public String getWorldName()
  {
    return this.a;
  }
  
  public void setAccount(String paramString)
  {
    this.b = paramString;
  }
  
  public void setLevel(String paramString)
  {
    this.c = paramString;
  }
  
  public void setWorldName(String paramString)
  {
    this.a = paramString;
  }
  
  public String toString()
  {
    return "StatGameUser [worldName=" + this.a + ", account=" + this.b + ", level=" + this.c + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.wxop.stat.StatGameUser
 * JD-Core Version:    0.7.0.1
 */