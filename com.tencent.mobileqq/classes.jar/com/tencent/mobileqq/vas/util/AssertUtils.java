package com.tencent.mobileqq.vas.util;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.support.logging.SLog;

public class AssertUtils
{
  public static void a(String paramString, Object... paramVarArgs)
  {
    if (paramVarArgs.length != 0) {
      paramString = String.format(paramString, paramVarArgs);
    }
    SLog.e("Q.qqstory.AssertUtils", paramString);
  }
  
  public static void a(boolean paramBoolean, @NonNull String paramString)
  {
    if (paramBoolean) {
      return;
    }
    SLog.e("Q.qqstory.AssertUtils", paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.util.AssertUtils
 * JD-Core Version:    0.7.0.1
 */