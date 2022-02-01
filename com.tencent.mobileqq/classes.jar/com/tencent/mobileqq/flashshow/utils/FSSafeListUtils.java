package com.tencent.mobileqq.flashshow.utils;

import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class FSSafeListUtils
{
  public static <T> T a(List<T> paramList, int paramInt)
  {
    if (a(paramList))
    {
      QLog.d("FSSafeListUtils", 1, "[get] list should is empty.");
      return null;
    }
    if (paramInt < 0)
    {
      QLog.d("FSSafeListUtils", 1, "[get] list position < 0, handle fail.");
      return null;
    }
    if (paramInt >= paramList.size())
    {
      QLog.d("FSSafeListUtils", 1, "[get] position >= list.size(), handle fail.");
      return null;
    }
    return paramList.get(paramInt);
  }
  
  public static <T> boolean a(List<T> paramList)
  {
    return (paramList == null) || (paramList.isEmpty());
  }
  
  public static <T> int b(List<T> paramList)
  {
    if (paramList == null) {
      return 0;
    }
    return paramList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.utils.FSSafeListUtils
 * JD-Core Version:    0.7.0.1
 */