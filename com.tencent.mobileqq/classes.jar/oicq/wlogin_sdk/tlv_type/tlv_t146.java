package oicq.wlogin_sdk.tlv_type;

import oicq.wlogin_sdk.tools.util;

public class tlv_t146
  extends tlv_t
{
  public int _errorinfo_len = 0;
  public int _msg_len = 0;
  public int _title_len = 0;
  
  public tlv_t146()
  {
    this._cmd = 326;
  }
  
  public int get_code()
  {
    return util.buf_to_int16(this._buf, this._head_len + 2);
  }
  
  public byte[] get_errorinfo()
  {
    byte[] arrayOfByte = new byte[this._errorinfo_len];
    System.arraycopy(this._buf, this._head_len + 12 + this._title_len + this._msg_len, arrayOfByte, 0, this._errorinfo_len);
    return arrayOfByte;
  }
  
  public byte[] get_msg()
  {
    byte[] arrayOfByte = new byte[this._msg_len];
    System.arraycopy(this._buf, this._head_len + 8 + this._title_len, arrayOfByte, 0, this._msg_len);
    return arrayOfByte;
  }
  
  public byte[] get_title()
  {
    byte[] arrayOfByte = new byte[this._title_len];
    System.arraycopy(this._buf, this._head_len + 6, arrayOfByte, 0, this._title_len);
    return arrayOfByte;
  }
  
  public int get_type()
  {
    return util.buf_to_int16(this._buf, this._head_len + 8 + this._title_len + this._msg_len);
  }
  
  public int get_ver()
  {
    return util.buf_to_int16(this._buf, this._head_len);
  }
  
  public Boolean verify()
  {
    if (this._body_len < 12) {
      return Boolean.valueOf(false);
    }
    int i = util.buf_to_int16(this._buf, this._head_len + 4);
    if (this._body_len < i + 12) {
      return Boolean.valueOf(false);
    }
    this._title_len = i;
    i = util.buf_to_int16(this._buf, this._head_len + 6 + this._title_len);
    if (this._body_len < this._title_len + 12 + i) {
      return Boolean.valueOf(false);
    }
    this._msg_len = i;
    i = util.buf_to_int16(this._buf, this._head_len + 10 + this._title_len + this._msg_len);
    if (this._body_len < this._title_len + 12 + this._msg_len + i) {
      return Boolean.valueOf(false);
    }
    this._errorinfo_len = i;
    return Boolean.valueOf(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.tlv_type.tlv_t146
 * JD-Core Version:    0.7.0.1
 */