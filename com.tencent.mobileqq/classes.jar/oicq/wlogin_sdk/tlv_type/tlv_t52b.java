package oicq.wlogin_sdk.tlv_type;

import oicq.wlogin_sdk.tools.util;

public class tlv_t52b
  extends tlv_t
{
  private String _mobile;
  private int _zone;
  
  public tlv_t52b()
  {
    this._cmd = 1323;
  }
  
  public String get_mobile()
  {
    return this._mobile;
  }
  
  public int get_zone()
  {
    return this._zone;
  }
  
  public Boolean verify()
  {
    if (this._body_len < 8) {
      return Boolean.valueOf(false);
    }
    int i = this._head_len + 4;
    this._zone = util.buf_to_int16(this._buf, i);
    int j = this._body_len - 4 - 2 - 2;
    byte[] arrayOfByte = new byte[j];
    System.arraycopy(this._buf, i + 2 + 2, arrayOfByte, 0, j);
    this._mobile = new String(arrayOfByte);
    return Boolean.valueOf(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.tlv_type.tlv_t52b
 * JD-Core Version:    0.7.0.1
 */