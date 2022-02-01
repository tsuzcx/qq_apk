package com.tencent.mobileqq.filemanager.api.impl;

import com.tencent.mobileqq.filemanager.api.IFileHttpUtils;
import com.tencent.mobileqq.filemanager.discoperation.QQFileHttpUtils;
import com.tencent.wstt.SSCM.SSCM;

public class FileHttpUtilsImpl
  implements IFileHttpUtils
{
  public int getBlockSize(SSCM paramSSCM, long paramLong1, long paramLong2, long paramLong3)
  {
    return QQFileHttpUtils.a(paramSSCM, paramLong1, paramLong2, paramLong3);
  }
  
  public String hexToString(byte[] paramArrayOfByte)
  {
    return QQFileHttpUtils.a(paramArrayOfByte);
  }
  
  public boolean isNeedRetryOtherUrl(int paramInt)
  {
    return QQFileHttpUtils.a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.api.impl.FileHttpUtilsImpl
 * JD-Core Version:    0.7.0.1
 */