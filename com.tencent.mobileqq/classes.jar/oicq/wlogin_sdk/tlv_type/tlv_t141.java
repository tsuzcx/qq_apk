package oicq.wlogin_sdk.tlv_type;

import oicq.wlogin_sdk.tools.util;

public class tlv_t141
  extends tlv_t
{
  int _version = 1;
  
  public tlv_t141()
  {
    this._cmd = 321;
  }
  
  public byte[] get_tlv_141(byte[] paramArrayOfByte1, int paramInt, byte[] paramArrayOfByte2)
  {
    byte[] arrayOfByte = paramArrayOfByte1;
    if (paramArrayOfByte1 == null) {
      arrayOfByte = new byte[0];
    }
    paramArrayOfByte1 = paramArrayOfByte2;
    if (paramArrayOfByte2 == null) {
      paramArrayOfByte1 = new byte[0];
    }
    int i = arrayOfByte.length + 4 + 2 + 2 + paramArrayOfByte1.length;
    paramArrayOfByte2 = new byte[i];
    util.int16_to_buf(paramArrayOfByte2, 0, this._version);
    util.int16_to_buf(paramArrayOfByte2, 2, arrayOfByte.length);
    System.arraycopy(arrayOfByte, 0, paramArrayOfByte2, 4, arrayOfByte.length);
    int j = arrayOfByte.length + 4;
    util.int16_to_buf(paramArrayOfByte2, j, paramInt);
    paramInt = j + 2;
    util.int16_to_buf(paramArrayOfByte2, paramInt, paramArrayOfByte1.length);
    paramInt += 2;
    System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte2, paramInt, paramArrayOfByte1.length);
    paramInt = paramArrayOfByte1.length;
    fill_head(this._cmd);
    fill_body(paramArrayOfByte2, i);
    set_length();
    return get_buf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.tlv_type.tlv_t141
 * JD-Core Version:    0.7.0.1
 */