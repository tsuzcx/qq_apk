package com.tencent.mobileqq.weiyun.channel;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB.MsgHead;
import com.tencent.qphone.base.util.QLog;

final class PBSerialization
{
  private static String a = "PBSerialization-L";
  
  public static PBPackage a(byte[] paramArrayOfByte)
  {
    Object localObject = new PBCommonHead();
    if (paramArrayOfByte.length < PBCommonHead.d)
    {
      QLog.w(a, 1, "buffer length is short than 16!");
      return null;
    }
    ((PBCommonHead)localObject).a(paramArrayOfByte);
    if (paramArrayOfByte.length < ((PBCommonHead)localObject).a())
    {
      QLog.w(a, 1, "buffer length is short!");
      return null;
    }
    int i = ((PBCommonHead)localObject).a() - ((PBCommonHead)localObject).b() - PBCommonHead.d;
    int j = ((PBCommonHead)localObject).b();
    localObject = new byte[i];
    byte[] arrayOfByte = new byte[j];
    System.arraycopy(paramArrayOfByte, PBCommonHead.d, localObject, 0, i);
    System.arraycopy(paramArrayOfByte, PBCommonHead.d + i, arrayOfByte, 0, j);
    paramArrayOfByte = new WeiyunPB.MsgHead();
    try
    {
      paramArrayOfByte.mergeFrom((byte[])localObject);
      paramArrayOfByte = new PBPackage(paramArrayOfByte, arrayOfByte);
      return paramArrayOfByte;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      label130:
      break label130;
    }
    QLog.e(a, 1, "throw InvalidProtocolBufferException.");
    return null;
  }
  
  public static byte[] a(PBPackage paramPBPackage)
  {
    byte[] arrayOfByte1 = paramPBPackage.a().toByteArray();
    paramPBPackage = paramPBPackage.a();
    int i = PBCommonHead.d + arrayOfByte1.length + paramPBPackage.length;
    Object localObject = new PBCommonHead();
    ((PBCommonHead)localObject).b(paramPBPackage.length);
    ((PBCommonHead)localObject).a(i);
    localObject = ((PBCommonHead)localObject).a();
    byte[] arrayOfByte2 = new byte[i];
    System.arraycopy(localObject, 0, arrayOfByte2, 0, localObject.length);
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, localObject.length, arrayOfByte1.length);
    System.arraycopy(paramPBPackage, 0, arrayOfByte2, localObject.length + arrayOfByte1.length, paramPBPackage.length);
    return arrayOfByte2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.weiyun.channel.PBSerialization
 * JD-Core Version:    0.7.0.1
 */