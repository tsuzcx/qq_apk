package com.tencent.mobileqq.data;

import com.tencent.mobileqq.utils.httputils.PkgTools;

public class AtTroopMemberInfoCallback
  implements AtTroopMemberInfo.Callback
{
  public long a(byte[] paramArrayOfByte, int paramInt)
  {
    return PkgTools.getLongData(paramArrayOfByte, paramInt);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.AtTroopMemberInfoCallback
 * JD-Core Version:    0.7.0.1
 */