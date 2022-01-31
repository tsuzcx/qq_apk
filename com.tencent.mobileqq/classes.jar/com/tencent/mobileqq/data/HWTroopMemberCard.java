package com.tencent.mobileqq.data;

import java.io.Serializable;

public class HWTroopMemberCard
  implements Serializable
{
  public static final long HW_GROUP_CLASS_EXT_ID = 32L;
  public static final int IDENTITY_PARENTS = 2;
  public static final int IDENTITY_STUDENT = 3;
  public static final int IDENTITY_TEACHER = 1;
  public static final int IDENTITY_UNKNOW = 0;
  private static final long serialVersionUID = 1L;
  public int identity = 0;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.data.HWTroopMemberCard
 * JD-Core Version:    0.7.0.1
 */