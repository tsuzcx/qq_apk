package oicq.wlogin_sdk.tlv_type;

import oicq.wlogin_sdk.tools.util;

public class tlv_t17c
  extends tlv_t
{
  int _t17c_body_len = 0;
  
  public tlv_t17c()
  {
    this._cmd = 380;
  }
  
  public byte[] get_tlv_17c(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = paramArrayOfByte;
    if (paramArrayOfByte == null) {
      arrayOfByte = new byte[0];
    }
    this._t17c_body_len = (arrayOfByte.length + 2);
    paramArrayOfByte = new byte[this._t17c_body_len];
    util.int16_to_buf(paramArrayOfByte, 0, arrayOfByte.length);
    System.arraycopy(arrayOfByte, 0, paramArrayOfByte, 2, arrayOfByte.length);
    int i = arrayOfByte.length;
    fill_head(this._cmd);
    fill_body(paramArrayOfByte, this._t17c_body_len);
    set_length();
    return get_buf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     oicq.wlogin_sdk.tlv_type.tlv_t17c
 * JD-Core Version:    0.7.0.1
 */