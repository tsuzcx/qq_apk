package com.tencent.tavkit.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListUtils
{
  public static <T> List<T> listWithObjects(T... paramVarArgs)
  {
    return new ArrayList(Arrays.asList(paramVarArgs));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tavkit.utils.ListUtils
 * JD-Core Version:    0.7.0.1
 */