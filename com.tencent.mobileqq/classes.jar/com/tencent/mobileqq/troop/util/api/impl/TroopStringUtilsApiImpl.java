package com.tencent.mobileqq.troop.util.api.impl;

import com.tencent.mobileqq.troop.util.api.ITroopStringUtilsApi;

public class TroopStringUtilsApiImpl
  implements ITroopStringUtilsApi
{
  public String cutByteByUtf8(byte[] paramArrayOfByte, int paramInt)
  {
    String str = null;
    if (paramArrayOfByte == null) {
      return null;
    }
    int k = paramInt - 1;
    int i = k;
    int j = 0;
    while ((i >= 0) && (paramArrayOfByte[i] < 0))
    {
      j += 1;
      i -= 1;
    }
    i = j % 3;
    if (i == 0) {
      return new String(paramArrayOfByte, 0, paramInt, "utf-8");
    }
    if (i == 1) {
      return new String(paramArrayOfByte, 0, k, "utf-8");
    }
    if (i == 2) {
      str = new String(paramArrayOfByte, 0, paramInt - 2, "utf-8");
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.util.api.impl.TroopStringUtilsApiImpl
 * JD-Core Version:    0.7.0.1
 */