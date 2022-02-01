package com.tencent.mobileqq.data;

import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class AtTroopMemberInfoCallback
  implements AtTroopMemberInfo.Callback
{
  public long a(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = ((IGPSService)paramAppRuntime.getRuntimeService(IGPSService.class, "")).getSelfTinyId();
    try
    {
      long l = Long.parseLong(paramAppRuntime);
      return l;
    }
    catch (Exception paramAppRuntime)
    {
      QLog.e("AtTroopMemberInfoCallback", 1, new Object[] { "getSelfTid error, ", paramAppRuntime.getMessage() });
    }
    return 0L;
  }
  
  public short a(byte[] paramArrayOfByte, int paramInt)
  {
    return PkgTools.getShortData(paramArrayOfByte, paramInt);
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt, long paramLong)
  {
    PkgTools.dWord2Byte(paramArrayOfByte, paramInt, paramLong);
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt, short paramShort)
  {
    PkgTools.word2Byte(paramArrayOfByte, paramInt, paramShort);
  }
  
  public long b(byte[] paramArrayOfByte, int paramInt)
  {
    return PkgTools.getLongData(paramArrayOfByte, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.AtTroopMemberInfoCallback
 * JD-Core Version:    0.7.0.1
 */