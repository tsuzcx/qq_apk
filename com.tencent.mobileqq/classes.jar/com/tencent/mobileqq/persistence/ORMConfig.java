package com.tencent.mobileqq.persistence;

import com.tencent.qphone.base.util.QLog;

public class ORMConfig
{
  public static final boolean DEBUG = false;
  public static final boolean ENABLE_CURSOR2ENTITY = true;
  public static final boolean ENABLE_CURSOR_INDEX_FORCE_USE = false;
  public static final boolean ENABLE_WRITE_OPT = true;
  public static final String TAG = "FastORM";
  public static final boolean USE_FAST_ORM = true;
  
  public static void debug(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("FastORM", 4, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.ORMConfig
 * JD-Core Version:    0.7.0.1
 */