package oicq.wlogin_sdk.tlv_type;

import oicq.wlogin_sdk.tools.util;

public class tlv_t126
  extends tlv_t
{
  int _random_len = 0;
  
  public tlv_t126()
  {
    this._cmd = 294;
  }
  
  public byte[] get_random()
  {
    byte[] arrayOfByte = new byte[this._random_len];
    System.arraycopy(this._buf, this._head_len + 2 + 2, arrayOfByte, 0, arrayOfByte.length);
    return arrayOfByte;
  }
  
  public Boolean verify()
  {
    int i = this._body_len;
    Boolean localBoolean = Boolean.valueOf(false);
    if (i < 2) {
      return localBoolean;
    }
    if (this._body_len < 4) {
      return localBoolean;
    }
    this._random_len = util.buf_to_int16(this._buf, this._head_len + 2);
    if (this._random_len + 2 + 2 > this._body_len) {
      return localBoolean;
    }
    return Boolean.valueOf(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     oicq.wlogin_sdk.tlv_type.tlv_t126
 * JD-Core Version:    0.7.0.1
 */