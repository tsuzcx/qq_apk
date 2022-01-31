package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.util;

public class i
  extends c
{
  public i()
  {
    this.b = 5;
  }
  
  public byte[] b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    paramArrayOfByte2 = a(paramArrayOfByte1, paramArrayOfByte2);
    this.d = (paramArrayOfByte1.length + 1 + 2 + paramArrayOfByte2.length);
    byte[] arrayOfByte = new byte[this.d];
    util.int8_to_buf(arrayOfByte, 0, paramArrayOfByte1.length);
    System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 1, paramArrayOfByte1.length);
    int i = paramArrayOfByte1.length + 1;
    util.int16_to_buf(arrayOfByte, i, paramArrayOfByte2.length);
    i += 2;
    System.arraycopy(paramArrayOfByte2, 0, arrayOfByte, i, paramArrayOfByte2.length);
    i = paramArrayOfByte2.length;
    return a(arrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.i
 * JD-Core Version:    0.7.0.1
 */