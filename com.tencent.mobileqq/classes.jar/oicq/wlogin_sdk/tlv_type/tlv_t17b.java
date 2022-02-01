package oicq.wlogin_sdk.tlv_type;

import oicq.wlogin_sdk.tools.util;

public class tlv_t17b
  extends tlv_t
{
  public tlv_t17b()
  {
    this._cmd = 379;
  }
  
  public int get_available_msg_cnt()
  {
    if (this._body_len < 4) {
      return 0;
    }
    return util.buf_to_int16(this._buf, this._head_len);
  }
  
  public int get_time_limit()
  {
    if (this._body_len < 4) {
      return 0;
    }
    return util.buf_to_int16(this._buf, this._head_len + 2);
  }
  
  public Boolean verify()
  {
    if (this._body_len < 4) {
      return Boolean.valueOf(false);
    }
    return Boolean.valueOf(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     oicq.wlogin_sdk.tlv_type.tlv_t17b
 * JD-Core Version:    0.7.0.1
 */