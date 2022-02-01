package com.tencent.mobileqq.nearby.gameroom;

public class InviteUser
{
  public int a;
  public String a;
  public boolean a;
  public String b;
  
  public boolean equals(Object paramObject)
  {
    boolean bool3 = paramObject instanceof InviteUser;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      paramObject = (InviteUser)paramObject;
      bool1 = bool2;
      if (paramObject.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString))
      {
        bool1 = bool2;
        if (paramObject.jdField_a_of_type_Int == this.jdField_a_of_type_Int) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.InviteUser
 * JD-Core Version:    0.7.0.1
 */