package com.tencent.mobileqq.persistence;

import com.tencent.mobileqq.imcore.constants.AppSetting;
import com.tencent.qphone.base.util.QLog;

public class ORMConfig
{
  public static final boolean DEBUG = false;
  public static final boolean ENABLE_CURSOR2ENTITY = true;
  public static final boolean ENABLE_CURSOR_INDEX_FORCE_USE = false;
  public static final boolean ENABLE_WRITE_OPT;
  public static final String TAG = "FastORM";
  public static final boolean USE_FAST_ORM = true;
  
  static
  {
    if (!AppSetting.isDebugVersion) {}
    for (boolean bool = true;; bool = false)
    {
      ENABLE_WRITE_OPT = bool;
      return;
    }
  }
  
  public static void debug(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("FastORM", 4, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.ORMConfig
 * JD-Core Version:    0.7.0.1
 */