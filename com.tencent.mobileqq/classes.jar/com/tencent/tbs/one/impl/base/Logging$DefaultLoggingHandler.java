package com.tencent.tbs.one.impl.base;

import android.util.Log;

class Logging$DefaultLoggingHandler
  implements Logging.LoggingHandler
{
  public void log(int paramInt, String paramString)
  {
    Log.println(paramInt, "TBSOne", paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.base.Logging.DefaultLoggingHandler
 * JD-Core Version:    0.7.0.1
 */