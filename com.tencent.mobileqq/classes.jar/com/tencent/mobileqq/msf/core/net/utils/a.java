package com.tencent.mobileqq.msf.core.net.utils;

import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.ad;
import com.tencent.mobileqq.msf.core.o;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.CodecWarpper;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class a
{
  public static final String a = "send_mode";
  public static final int b = 0;
  public static final int c = 1;
  public static final int d = 591;
  public static final int e = 595;
  public static final int f = 600;
  protected static final char[] g = "0123456789ABCDEF".toCharArray();
  private static final String h = "ByteMessageCodec";
  
  private static FromServiceMsg a(FromServiceMsg paramFromServiceMsg)
  {
    if ((paramFromServiceMsg.getFlag() & 0x1) != 0)
    {
      byte[] arrayOfByte1 = paramFromServiceMsg.getWupBuffer();
      if (arrayOfByte1.length > 4)
      {
        int i = (arrayOfByte1[0] & 0xFF) << 24 | 0x0 | (arrayOfByte1[1] & 0xFF) << 16 | (arrayOfByte1[2] & 0xFF) << 8 | arrayOfByte1[3] & 0xFF;
        try
        {
          byte[] arrayOfByte2 = new byte[i];
          System.arraycopy(arrayOfByte1, 4, arrayOfByte2, 0, i - 4);
          arrayOfByte1 = com.tencent.qphone.base.util.j.b(arrayOfByte2);
          arrayOfByte2 = new byte[arrayOfByte1.length + 4];
          arrayOfByte2[0] = ((byte)(arrayOfByte1.length + 4 >> 24 & 0xFF));
          arrayOfByte2[1] = ((byte)(arrayOfByte1.length + 4 >> 16 & 0xFF));
          arrayOfByte2[2] = ((byte)(arrayOfByte1.length + 4 >> 8 & 0xFF));
          arrayOfByte2[3] = ((byte)(arrayOfByte1.length + 4 & 0xFF));
          System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 4, arrayOfByte1.length);
          paramFromServiceMsg.putWupBuffer(arrayOfByte2);
          return paramFromServiceMsg;
        }
        catch (Throwable paramFromServiceMsg)
        {
          QLog.d("ByteMessageCodec", 1, "LightSender uncompress data failed", paramFromServiceMsg);
        }
      }
      return null;
    }
    return paramFromServiceMsg;
  }
  
  public static FromServiceMsg a(byte[] paramArrayOfByte, MsfCore paramMsfCore)
  {
    return b(paramArrayOfByte, paramMsfCore);
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    char[] arrayOfChar1 = new char[paramArrayOfByte.length * 2];
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      int j = paramArrayOfByte[i] & 0xFF;
      int k = i * 2;
      char[] arrayOfChar2 = g;
      arrayOfChar1[k] = arrayOfChar2[(j >>> 4)];
      arrayOfChar1[(k + 1)] = arrayOfChar2[(j & 0xF)];
      i += 1;
    }
    return new String(arrayOfChar1);
  }
  
  public static byte[] a(ToServiceMsg paramToServiceMsg, MsfCore paramMsfCore)
  {
    return b(paramToServiceMsg, paramMsfCore);
  }
  
  private static FromServiceMsg b(byte[] paramArrayOfByte, MsfCore paramMsfCore)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      paramArrayOfByte = paramMsfCore.sender.C.nativeParseData(paramArrayOfByte);
      if (paramArrayOfByte == null)
      {
        QLog.e("ByteMessageCodec", 1, "[byteToMessage] msg is null.");
        return null;
      }
      return a(paramArrayOfByte);
    }
    QLog.e("ByteMessageCodec", 1, "[byteToMessage] error: data is null.");
    return null;
  }
  
  private static byte[] b(ToServiceMsg paramToServiceMsg, MsfCore paramMsfCore)
  {
    if (paramToServiceMsg == null)
    {
      QLog.e("ByteMessageCodec", 1, "[messageToByte] error: msg is null.");
      return null;
    }
    try
    {
      String str = paramToServiceMsg.getServiceCmd();
      if (paramToServiceMsg.getWupBuffer() != null)
      {
        byte b1 = com.tencent.mobileqq.msf.core.net.j.b();
        byte b2 = (byte)NetConnInfoCenter.getActiveNetIpFamily(false);
        if (paramToServiceMsg.getAttributes().containsKey("send_mode")) {
          ((Integer)paramToServiceMsg.getAttributes().get("send_mode")).intValue();
        }
        try
        {
          byte[] arrayOfByte = ad.b(paramToServiceMsg, b2);
        }
        catch (Exception localException)
        {
          QLog.d("ByteMessageCodec", 1, "", localException);
          localObject = null;
        }
        if (591 == CodecWarpper.getSharedObjectVersion())
        {
          paramMsfCore = CodecWarpper.nativeEncodeRequest(paramToServiceMsg.getRequestSsoSeq(), o.d(), o.f(), o.g(), "", str, null, paramToServiceMsg.getAppId(), paramMsfCore.getMsfAppid(), paramToServiceMsg.getUin(), (byte)0, b1, paramToServiceMsg.getWupBuffer(), true);
          paramToServiceMsg = paramMsfCore;
        }
        else if ((595 != CodecWarpper.getSharedObjectVersion()) && (600 != CodecWarpper.getSharedObjectVersion()))
        {
          paramMsfCore = CodecWarpper.nativeEncodeRequest(paramToServiceMsg.getRequestSsoSeq(), o.d(), o.f(), o.g(), "", str, null, paramToServiceMsg.getAppId(), paramMsfCore.getMsfAppid(), paramToServiceMsg.getUin(), (byte)0, b1, b2, (byte[])localObject, null, paramToServiceMsg.getWupBuffer(), true);
          paramToServiceMsg = paramMsfCore;
        }
        else
        {
          paramMsfCore = CodecWarpper.nativeEncodeRequest(paramToServiceMsg.getRequestSsoSeq(), o.d(), o.f(), o.g(), "", str, null, paramToServiceMsg.getAppId(), paramMsfCore.getMsfAppid(), paramToServiceMsg.getUin(), (byte)0, b1, (byte[])localObject, null, paramToServiceMsg.getWupBuffer(), true);
          paramToServiceMsg = paramMsfCore;
        }
      }
      else
      {
        paramMsfCore = new byte[0];
        paramToServiceMsg = paramMsfCore;
      }
      return paramToServiceMsg;
    }
    catch (Throwable paramMsfCore)
    {
      paramMsfCore.printStackTrace();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[messageToByte] get packet fail ssoSeq: ");
      ((StringBuilder)localObject).append(paramToServiceMsg.getRequestSsoSeq());
      QLog.d("ByteMessageCodec", 1, ((StringBuilder)localObject).toString(), paramMsfCore);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.utils.a
 * JD-Core Version:    0.7.0.1
 */