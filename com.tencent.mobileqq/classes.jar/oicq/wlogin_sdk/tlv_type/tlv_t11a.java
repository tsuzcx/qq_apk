package oicq.wlogin_sdk.tlv_type;

import oicq.wlogin_sdk.tools.util;

public class tlv_t11a
  extends tlv_t
{
  public int _nick_len = 0;
  
  public tlv_t11a()
  {
    this._cmd = 282;
  }
  
  public byte[] get_age()
  {
    byte[] arrayOfByte = new byte[1];
    System.arraycopy(this._buf, this._head_len + 2, arrayOfByte, 0, 1);
    return arrayOfByte;
  }
  
  public byte[] get_face()
  {
    byte[] arrayOfByte = new byte[2];
    System.arraycopy(this._buf, this._head_len, arrayOfByte, 0, 2);
    return arrayOfByte;
  }
  
  public byte[] get_gender()
  {
    byte[] arrayOfByte = new byte[1];
    System.arraycopy(this._buf, this._head_len + 2 + 1, arrayOfByte, 0, 1);
    return arrayOfByte;
  }
  
  public byte[] get_nick()
  {
    byte[] arrayOfByte = new byte[this._nick_len];
    System.arraycopy(this._buf, this._head_len + 2 + 1 + 1 + 1, arrayOfByte, 0, this._nick_len);
    return arrayOfByte;
  }
  
  public Boolean verify()
  {
    int i = this._body_len;
    Boolean localBoolean = Boolean.valueOf(false);
    if (i < 5) {
      return localBoolean;
    }
    i = util.buf_to_int8(this._buf, this._head_len + 2 + 1 + 1);
    if (this._body_len < i + 5) {
      return localBoolean;
    }
    this._nick_len = i;
    return Boolean.valueOf(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     oicq.wlogin_sdk.tlv_type.tlv_t11a
 * JD-Core Version:    0.7.0.1
 */