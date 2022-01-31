package com.tencent.upload.e;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public class b
{
  public static <T extends JceStruct> T a(T paramT, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
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
    return null;
  }
  
  public static <T extends JceStruct> T a(Class<T> paramClass, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return null;
    }
    try
    {
      paramClass = a((JceStruct)paramClass.newInstance(), paramArrayOfByte);
      return paramClass;
    }
    catch (Exception paramClass)
    {
      paramClass.printStackTrace();
    }
    return null;
  }
  
  public static byte[] a(JceStruct paramJceStruct)
  {
    JceOutputStream localJceOutputStream = new JceOutputStream();
    localJceOutputStream.setServerEncoding("utf8");
    paramJceStruct.writeTo(localJceOutputStream);
    return localJceOutputStream.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.upload.e.b
 * JD-Core Version:    0.7.0.1
 */