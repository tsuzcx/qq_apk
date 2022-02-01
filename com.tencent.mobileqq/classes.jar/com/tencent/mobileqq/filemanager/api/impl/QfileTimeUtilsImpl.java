package com.tencent.mobileqq.filemanager.api.impl;

import com.tencent.mobileqq.filemanager.api.IQfileTimeUtils;
import com.tencent.mobileqq.filemanager.util.QQFileTimeUtils;

public class QfileTimeUtilsImpl
  implements IQfileTimeUtils
{
  public String formatNewRefreshTime(long paramLong)
  {
    return QQFileTimeUtils.b(paramLong);
  }
  
  public String getHistoryGroupByTime(long paramLong)
  {
    return QQFileTimeUtils.a(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.api.impl.QfileTimeUtilsImpl
 * JD-Core Version:    0.7.0.1
 */