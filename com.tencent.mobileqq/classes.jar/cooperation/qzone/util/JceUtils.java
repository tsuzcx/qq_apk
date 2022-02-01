package cooperation.qzone.util;

import PUSH_COMM_STRUCT.BinaryPushInfo;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.zip.Inflater;

public class JceUtils
{
  public static <T extends JceStruct> T decodeWup(T paramT, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length == 0) {
        return null;
      }
      try
      {
        paramArrayOfByte = new JceInputStream(paramArrayOfByte);
        paramArrayOfByte.setServerEncoding("utf8");
        paramT.readFrom(paramArrayOfByte);
        return paramT;
      }
      catch (Exception paramT)
      {
        paramT.printStackTrace();
      }
    }
    return null;
  }
  
  public static <T extends JceStruct> T decodeWup(Class<T> paramClass, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    try
    {
      paramClass = (JceStruct)paramClass.newInstance();
      paramArrayOfByte = new JceInputStream(paramArrayOfByte);
      paramArrayOfByte.setServerEncoding("utf8");
      paramClass.readFrom(paramArrayOfByte);
      return paramClass;
    }
    catch (Exception paramClass)
    {
      paramClass.printStackTrace();
    }
    return null;
  }
  
  public static byte[] encodeWup(JceStruct paramJceStruct)
  {
    JceOutputStream localJceOutputStream = new JceOutputStream();
    localJceOutputStream.setServerEncoding("utf8");
    paramJceStruct.writeTo(localJceOutputStream);
    return localJceOutputStream.toByteArray();
  }
  
  public static byte[] encodeWup(ArrayList paramArrayList)
  {
    JceOutputStream localJceOutputStream = new JceOutputStream();
    localJceOutputStream.setServerEncoding("utf8");
    localJceOutputStream.write(paramArrayList, 0);
    return localJceOutputStream.toByteArray();
  }
  
  public static byte[] inflateByte(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      Object localObject2 = (BinaryPushInfo)decodeWup(BinaryPushInfo.class, paramArrayOfByte);
      if (((BinaryPushInfo)localObject2).compressType == 0L) {
        return ((BinaryPushInfo)localObject2).pushBuffer;
      }
      if (((BinaryPushInfo)localObject2).compressType == 2L) {
        try
        {
          Object localObject1 = new Inflater();
          ((Inflater)localObject1).setInput(((BinaryPushInfo)localObject2).pushBuffer, 0, ((BinaryPushInfo)localObject2).pushBuffer.length);
          localObject2 = new byte[4096];
          ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
          while (!((Inflater)localObject1).finished()) {
            localByteArrayOutputStream.write((byte[])localObject2, 0, ((Inflater)localObject1).inflate((byte[])localObject2));
          }
          ((Inflater)localObject1).end();
          localObject1 = localByteArrayOutputStream.toByteArray();
          return localObject1;
        }
        catch (Exception localException)
        {
          QZLog.e("JceUtils.inflateByte", "Push Buf decompresse error!", localException);
        }
      }
    }
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.util.JceUtils
 * JD-Core Version:    0.7.0.1
 */