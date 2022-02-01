package com.tencent.tkd.comment.util;

import java.util.Arrays;

public class ObjectUtil
{
  public static boolean equals(Object paramObject1, Object paramObject2)
  {
    return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
  }
  
  public static int hash(Object... paramVarArgs)
  {
    return Arrays.hashCode(paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.comment.util.ObjectUtil
 * JD-Core Version:    0.7.0.1
 */