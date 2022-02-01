package com.tencent.tbs.one.impl;

import com.tencent.tbs.log.TBSLog;
import com.tencent.tbs.one.impl.base.Logging.LoggingHandler;

final class Factory$1
  implements Logging.LoggingHandler
{
  public void log(int paramInt, String paramString)
  {
    TBSLog.log(paramInt, "TBSOne", paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.Factory.1
 * JD-Core Version:    0.7.0.1
 */