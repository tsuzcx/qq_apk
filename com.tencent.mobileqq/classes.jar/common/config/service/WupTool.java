package common.config.service;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public class WupTool
{
  public static <T extends JceStruct> T a(Class<T> paramClass, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0)) {
      try
      {
        paramClass = (JceStruct)paramClass.newInstance();
        paramClass.readFrom(new JceInputStream(paramArrayOfByte));
        return paramClass;
      }
      catch (InstantiationException paramClass)
      {
        paramClass.printStackTrace();
      }
      catch (IllegalAccessException paramClass)
      {
        paramClass.printStackTrace();
      }
    }
    return null;
  }
  
  public static byte[] a(JceStruct paramJceStruct)
  {
    if (paramJceStruct == null) {
      return null;
    }
    JceOutputStream localJceOutputStream = new JceOutputStream();
    localJceOutputStream.setServerEncoding("utf-8");
    paramJceStruct.writeTo(localJceOutputStream);
    return localJceOutputStream.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     common.config.service.WupTool
 * JD-Core Version:    0.7.0.1
 */