package com.tencent.mobileqq.utils;

import ActionMsg.MsgBody;
import com.qq.taf.jce.HexUtil;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;

public class ActionMsgUtil
{
  public static MsgBody a(String paramString)
  {
    MsgBody localMsgBody = new MsgBody();
    try
    {
      JceInputStream localJceInputStream = new JceInputStream(HexUtil.hexStr2Bytes(paramString));
      localJceInputStream.setServerEncoding("utf-8");
      localMsgBody.readFrom(localJceInputStream);
      return localMsgBody;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("decode error msg = ");
      localStringBuilder.append(paramString);
      QLog.w("ActionMsgUtil", 2, localStringBuilder.toString());
      QLog.w("ActionMsgUtil", 2, localException.toString());
      localMsgBody.msg = "";
      localMsgBody.action = "";
      localMsgBody.shareAppID = 0L;
      localMsgBody.actMsgContentValue = "";
    }
    return localMsgBody;
  }
  
  public static ActionMsgUtil.AppShareCookie a(byte[] paramArrayOfByte)
  {
    ActionMsgUtil.AppShareCookie localAppShareCookie = new ActionMsgUtil.AppShareCookie();
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0)) {}
    for (;;)
    {
      try
      {
        paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte);
        localAppShareCookie.a = paramArrayOfByte.get();
        if (paramArrayOfByte.get() != 0) {
          break label203;
        }
        i = -3004;
        localAppShareCookie.b = i;
        if (paramArrayOfByte.hasRemaining())
        {
          i = paramArrayOfByte.get();
          byte[] arrayOfByte = new byte[paramArrayOfByte.getShort()];
          paramArrayOfByte.get(arrayOfByte);
          localAppShareCookie.c = i;
          localAppShareCookie.d = new String(arrayOfByte);
          if (QLog.isColorLevel())
          {
            paramArrayOfByte = new StringBuilder();
            paramArrayOfByte.append("decodeAppShareCookie succes appShareCookie.buissnessType =");
            paramArrayOfByte.append(localAppShareCookie.a);
            paramArrayOfByte.append("appShareCookie.action");
            paramArrayOfByte.append(localAppShareCookie.b);
            paramArrayOfByte.append("appShareCookie.actionType");
            paramArrayOfByte.append(localAppShareCookie.c);
            paramArrayOfByte.append("appShareCookie.actionValue");
            paramArrayOfByte.append(localAppShareCookie.d);
            QLog.d("ActionMsgUtil", 2, paramArrayOfByte.toString());
            return localAppShareCookie;
          }
        }
      }
      catch (Exception paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.e("ActionMsgUtil", 2, "decodeAppShareCookie", paramArrayOfByte);
        }
      }
      return localAppShareCookie;
      label203:
      int i = -3005;
    }
  }
  
  public static String a(String paramString1, String paramString2)
  {
    return a(paramString1, paramString2, 0L, null);
  }
  
  public static String a(String paramString1, String paramString2, long paramLong, String paramString3)
  {
    String str = paramString1;
    if (paramString1 == null)
    {
      QLog.w("ActionMsgUtil", 2, "encode msg is null");
      str = "";
    }
    paramString1 = paramString2;
    if (paramString2 == null)
    {
      QLog.w("ActionMsgUtil", 2, "encode action is null");
      paramString1 = "";
    }
    paramString2 = new MsgBody();
    paramString2.msg = str;
    paramString2.action = paramString1;
    paramString2.shareAppID = paramLong;
    paramString2.actMsgContentValue = paramString3;
    paramString1 = new JceOutputStream();
    paramString1.setServerEncoding("utf-8");
    paramString2.writeTo(paramString1);
    return HexUtil.bytes2HexStr(paramString1.toByteArray());
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == -3000) || (paramInt == -3004) || (paramInt == -3005);
  }
  
  public static boolean b(int paramInt)
  {
    return (paramInt == -2009) || (paramInt == -3012);
  }
  
  public static boolean c(int paramInt)
  {
    return paramInt == -2016;
  }
  
  public static boolean d(int paramInt)
  {
    return paramInt == -2007;
  }
  
  public static boolean e(int paramInt)
  {
    return paramInt == -2039;
  }
  
  public static boolean f(int paramInt)
  {
    return paramInt == -8018;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.ActionMsgUtil
 * JD-Core Version:    0.7.0.1
 */