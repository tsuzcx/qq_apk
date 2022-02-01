package com.tencent.mobileqq.nearby.gameroom;

public class InviteUser
{
  public String a;
  public String b;
  public int c;
  public boolean d;
  
  public boolean equals(Object paramObject)
  {
    boolean bool3 = paramObject instanceof InviteUser;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      paramObject = (InviteUser)paramObject;
      bool1 = bool2;
      if (paramObject.a.equals(this.a))
      {
        bool1 = bool2;
        if (paramObject.c == this.c) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.InviteUser
 * JD-Core Version:    0.7.0.1
 */