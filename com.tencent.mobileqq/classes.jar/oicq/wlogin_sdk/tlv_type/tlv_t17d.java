package oicq.wlogin_sdk.tlv_type;

import oicq.wlogin_sdk.tools.util;

public class tlv_t17d
  extends tlv_t
{
  public int _mb_guide_info_len = 0;
  public int _mb_guide_msg_len = 0;
  
  public tlv_t17d()
  {
    this._cmd = 381;
  }
  
  public byte[] get_mb_guide_info()
  {
    byte[] arrayOfByte = new byte[this._mb_guide_info_len];
    System.arraycopy(this._buf, this._head_len + 2 + 2 + this._mb_guide_msg_len + 2 + 2, arrayOfByte, 0, this._mb_guide_info_len);
    return arrayOfByte;
  }
  
  public int get_mb_guide_info_type()
  {
    return util.buf_to_int16(this._buf, this._head_len + 2 + 2 + this._mb_guide_msg_len);
  }
  
  public byte[] get_mb_guide_msg()
  {
    byte[] arrayOfByte = new byte[this._mb_guide_msg_len];
    System.arraycopy(this._buf, this._head_len + 2 + 2, arrayOfByte, 0, this._mb_guide_msg_len);
    return arrayOfByte;
  }
  
  public int get_mb_guide_type()
  {
    return util.buf_to_int16(this._buf, this._head_len);
  }
  
  public Boolean verify()
  {
    int i = this._body_len;
    Boolean localBoolean = Boolean.valueOf(false);
    if (i < 8) {
      return localBoolean;
    }
    i = util.buf_to_int16(this._buf, this._head_len + 2);
    if (this._body_len < i + 8) {
      return localBoolean;
    }
    this._mb_guide_msg_len = i;
    i = util.buf_to_int16(this._buf, this._head_len + 2 + 2 + this._mb_guide_msg_len + 2);
    if (this._body_len < this._mb_guide_msg_len + 8 + i) {
      return localBoolean;
    }
    this._mb_guide_info_len = i;
    return Boolean.valueOf(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     oicq.wlogin_sdk.tlv_type.tlv_t17d
 * JD-Core Version:    0.7.0.1
 */