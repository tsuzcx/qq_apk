package oicq.wlogin_sdk.tlv_type;

import oicq.wlogin_sdk.tools.util;

public class tlv_t167
  extends tlv_t
{
  public int _url_len = 0;
  
  public tlv_t167()
  {
    this._cmd = 359;
  }
  
  public byte[] get_img_format()
  {
    byte[] arrayOfByte = new byte[1];
    System.arraycopy(this._buf, this._head_len + 1, arrayOfByte, 0, 1);
    return arrayOfByte;
  }
  
  public byte[] get_img_type()
  {
    byte[] arrayOfByte = new byte[1];
    System.arraycopy(this._buf, this._head_len, arrayOfByte, 0, 1);
    return arrayOfByte;
  }
  
  public byte[] get_img_url()
  {
    byte[] arrayOfByte = new byte[this._url_len];
    System.arraycopy(this._buf, this._head_len + 1 + 1 + 2, arrayOfByte, 0, this._url_len);
    return arrayOfByte;
  }
  
  public Boolean verify()
  {
    int i = this._body_len;
    Boolean localBoolean = Boolean.valueOf(false);
    if (i < 4) {
      return localBoolean;
    }
    i = util.buf_to_int16(this._buf, this._head_len + 1 + 1);
    if (this._body_len < i + 4) {
      return localBoolean;
    }
    this._url_len = i;
    return Boolean.valueOf(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     oicq.wlogin_sdk.tlv_type.tlv_t167
 * JD-Core Version:    0.7.0.1
 */