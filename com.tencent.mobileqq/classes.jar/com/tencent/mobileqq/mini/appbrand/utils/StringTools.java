package com.tencent.mobileqq.mini.appbrand.utils;

public class StringTools
{
  public static String concat(Object... paramVarArgs)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramVarArgs[i];
      if (localObject != null) {
        localStringBuilder.append(localObject.toString());
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.utils.StringTools
 * JD-Core Version:    0.7.0.1
 */