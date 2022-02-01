package com.tencent.mobileqq.filemanager.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.wstt.SSCM.SSCM;

@QAPI(process={"all"})
public abstract interface IFileHttpUtils
  extends QRouteApi
{
  public abstract int getBlockSize(SSCM paramSSCM, long paramLong1, long paramLong2, long paramLong3);
  
  public abstract String hexToString(byte[] paramArrayOfByte);
  
  public abstract boolean isNeedRetryOtherUrl(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.api.IFileHttpUtils
 * JD-Core Version:    0.7.0.1
 */