package oicq.wlogin_sdk.tlv_type;

import oicq.wlogin_sdk.tools.util;

public class tlv_t125
  extends tlv_t
{
  int _openid_len = 0;
  int _openkey_len = 0;
  
  public tlv_t125()
  {
    this._cmd = 293;
  }
  
  public byte[] get_openid()
  {
    byte[] arrayOfByte = new byte[this._openid_len];
    System.arraycopy(this._buf, this._head_len + 2, arrayOfByte, 0, arrayOfByte.length);
    return arrayOfByte;
  }
  
  public byte[] get_openkey()
  {
    byte[] arrayOfByte = new byte[this._openkey_len];
    System.arraycopy(this._buf, this._head_len + 2 + this._openid_len + 2, arrayOfByte, 0, arrayOfByte.length);
    return arrayOfByte;
  }
  
  public Boolean verify()
  {
    if (this._body_len < 2) {
      return Boolean.valueOf(false);
    }
    this._openid_len = util.buf_to_int16(this._buf, this._head_len);
    if (this._body_len < this._openid_len + 2 + 2) {
      return Boolean.valueOf(false);
    }
    this._openkey_len = util.buf_to_int16(this._buf, this._head_len + 2 + this._openid_len);
    return Boolean.valueOf(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.tlv_type.tlv_t125
 * JD-Core Version:    0.7.0.1
 */