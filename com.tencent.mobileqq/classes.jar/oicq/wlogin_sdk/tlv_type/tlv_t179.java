package oicq.wlogin_sdk.tlv_type;

import oicq.wlogin_sdk.tools.util;

public class tlv_t179
  extends tlv_t
{
  public int _verify_url_len = 0;
  
  public tlv_t179()
  {
    this._cmd = 377;
  }
  
  public byte[] get_verify_url()
  {
    byte[] arrayOfByte = new byte[this._verify_url_len];
    System.arraycopy(this._buf, this._head_len + 2, arrayOfByte, 0, this._verify_url_len);
    return arrayOfByte;
  }
  
  public Boolean verify()
  {
    if (this._body_len < 2) {
      return Boolean.valueOf(false);
    }
    int i = util.buf_to_int16(this._buf, this._head_len);
    if (this._body_len < i + 2) {
      return Boolean.valueOf(false);
    }
    this._verify_url_len = i;
    return Boolean.valueOf(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.tlv_type.tlv_t179
 * JD-Core Version:    0.7.0.1
 */