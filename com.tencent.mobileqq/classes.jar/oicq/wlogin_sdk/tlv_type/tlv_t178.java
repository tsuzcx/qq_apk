package oicq.wlogin_sdk.tlv_type;

import oicq.wlogin_sdk.tools.util;

public class tlv_t178
  extends tlv_t
{
  public int _country_code_len = 0;
  public int _mobile_len = 0;
  
  public tlv_t178()
  {
    this._cmd = 376;
  }
  
  public int get_available_msg_cnt()
  {
    return util.buf_to_int16(this._buf, this._head_len + 2 + this._country_code_len + 2 + this._mobile_len + 4);
  }
  
  public byte[] get_country_code()
  {
    byte[] arrayOfByte = new byte[this._country_code_len];
    System.arraycopy(this._buf, this._head_len + 2, arrayOfByte, 0, this._country_code_len);
    return arrayOfByte;
  }
  
  public byte[] get_mobile()
  {
    byte[] arrayOfByte = new byte[this._mobile_len];
    System.arraycopy(this._buf, this._head_len + 2 + this._country_code_len + 2, arrayOfByte, 0, this._mobile_len);
    return arrayOfByte;
  }
  
  public int get_smscode_status()
  {
    return util.buf_to_int32(this._buf, this._head_len + 2 + this._country_code_len + 2 + this._mobile_len);
  }
  
  public int get_time_limit()
  {
    return util.buf_to_int16(this._buf, this._head_len + 2 + this._country_code_len + 2 + this._mobile_len + 4 + 2);
  }
  
  public Boolean verify()
  {
    int i = this._body_len;
    Boolean localBoolean = Boolean.valueOf(false);
    if (i < 12) {
      return localBoolean;
    }
    i = util.buf_to_int16(this._buf, this._head_len);
    if (this._body_len < i + 12) {
      return localBoolean;
    }
    this._country_code_len = i;
    i = util.buf_to_int16(this._buf, this._head_len + 2 + this._country_code_len);
    if (this._body_len < this._country_code_len + 12 + i) {
      return localBoolean;
    }
    this._mobile_len = i;
    return Boolean.valueOf(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     oicq.wlogin_sdk.tlv_type.tlv_t178
 * JD-Core Version:    0.7.0.1
 */