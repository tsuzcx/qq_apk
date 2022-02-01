package com.tencent.upload.utils;

import com.qq.jce.wup.UniPacket;
import java.util.regex.PatternSyntaxException;

public class ProtocolUtil
{
  public static final int[] fromProtocolSequence(String paramString)
  {
    int[] arrayOfInt = new int[2];
    int[] tmp5_4 = arrayOfInt;
    tmp5_4[0] = 0;
    int[] tmp9_5 = tmp5_4;
    tmp9_5[1] = 0;
    tmp9_5;
    if ((paramString != null) && (paramString.length() != 0)) {
      try
      {
        Object localObject1 = paramString.split("\\|");
        if ((localObject1 != null) && (localObject1.length == 2)) {
          try
          {
            arrayOfInt[0] = Integer.parseInt(localObject1[0]);
            arrayOfInt[1] = Integer.parseInt(localObject1[1]);
            return arrayOfInt;
          }
          catch (NumberFormatException paramString)
          {
            localObject1 = ProtocolUtil.class.getSimpleName();
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("toProtocolSequence ");
            ((StringBuilder)localObject2).append(paramString);
            UploadLog.w((String)localObject1, ((StringBuilder)localObject2).toString());
            return arrayOfInt;
          }
        }
        localObject1 = ProtocolUtil.class.getSimpleName();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("fromProtocolSequence:");
        ((StringBuilder)localObject2).append(paramString);
        ((StringBuilder)localObject2).append(" results == null || results.length != 2");
        ((StringBuilder)localObject2).append(paramString);
        UploadLog.w((String)localObject1, ((StringBuilder)localObject2).toString());
        return arrayOfInt;
      }
      catch (PatternSyntaxException localPatternSyntaxException)
      {
        Object localObject2 = ProtocolUtil.class.getSimpleName();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("fromProtocolSequence:");
        localStringBuilder.append(paramString);
        localStringBuilder.append(" ");
        localStringBuilder.append(localPatternSyntaxException);
        UploadLog.w((String)localObject2, localStringBuilder.toString());
        return arrayOfInt;
      }
    }
    UploadLog.w(ProtocolUtil.class.getSimpleName(), "fromProtocolSequence protocolSequence == null || len == 0");
    return arrayOfInt;
  }
  
  public static final byte[] pack(String paramString, Object paramObject)
  {
    if ((paramString != null) && (paramObject != null))
    {
      UniPacket localUniPacket = new UniPacket();
      localUniPacket.setEncodeName("UTF-8");
      localUniPacket.setRequestId(0);
      localUniPacket.setFuncName("FuncName");
      localUniPacket.setServantName("ServantName");
      localUniPacket.put(paramString, paramObject);
      paramString = localUniPacket.encode();
      localUniPacket.clearCacheData();
      return paramString;
    }
    return null;
  }
  
  public static final String toProtocolSequence(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("|");
    localStringBuilder.append(paramInt2);
    return localStringBuilder.toString();
  }
  
  public static final Object unpack(String paramString, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    UniPacket localUniPacket = new UniPacket();
    localUniPacket.setEncodeName("UTF-8");
    localUniPacket.decode(paramArrayOfByte);
    paramString = localUniPacket.get(paramString);
    localUniPacket.clearCacheData();
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.upload.utils.ProtocolUtil
 * JD-Core Version:    0.7.0.1
 */