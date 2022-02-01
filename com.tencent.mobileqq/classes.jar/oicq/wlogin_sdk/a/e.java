package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tlv_type.tlv_t544;
import oicq.wlogin_sdk.tools.util;

public class e
  extends c
{
  public e()
  {
    this.b = 7;
  }
  
  public byte[] a(int paramInt, byte[] paramArrayOfByte, long paramLong)
  {
    this.d = (paramArrayOfByte.length + 2 + 4);
    byte[] arrayOfByte1 = new byte[this.d];
    util.int8_to_buf(arrayOfByte1, 0, paramInt);
    util.int8_to_buf(arrayOfByte1, 1, paramArrayOfByte.length);
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte1, 2, paramArrayOfByte.length);
    util.int64_to_buf32(arrayOfByte1, 2 + paramArrayOfByte.length, paramLong);
    paramArrayOfByte = new tlv_t544().get_tlv_544("", "812_7", arrayOfByte1);
    byte[] arrayOfByte2 = new byte[arrayOfByte1.length + paramArrayOfByte.length];
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, arrayOfByte1.length);
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte2, arrayOfByte1.length, paramArrayOfByte.length);
    return a(arrayOfByte2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     oicq.wlogin_sdk.a.e
 * JD-Core Version:    0.7.0.1
 */