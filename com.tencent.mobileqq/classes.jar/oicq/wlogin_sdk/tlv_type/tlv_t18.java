package oicq.wlogin_sdk.tlv_type;

import oicq.wlogin_sdk.tools.util;

public class tlv_t18
  extends tlv_t
{
  int _ping_version = 1;
  int _sso_version = 1536;
  int _t18_body_len = 22;
  
  public tlv_t18()
  {
    this._cmd = 24;
  }
  
  public byte[] get_tlv_18(long paramLong1, int paramInt1, long paramLong2, int paramInt2)
  {
    byte[] arrayOfByte = new byte[this._t18_body_len];
    util.int16_to_buf(arrayOfByte, 0, this._ping_version);
    util.int32_to_buf(arrayOfByte, 2, this._sso_version);
    util.int32_to_buf(arrayOfByte, 6, (int)paramLong1);
    util.int32_to_buf(arrayOfByte, 10, paramInt1);
    util.int32_to_buf(arrayOfByte, 14, (int)paramLong2);
    util.int16_to_buf(arrayOfByte, 18, paramInt2);
    util.int16_to_buf(arrayOfByte, 20, 0);
    fill_head(this._cmd);
    fill_body(arrayOfByte, this._t18_body_len);
    set_length();
    return get_buf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     oicq.wlogin_sdk.tlv_type.tlv_t18
 * JD-Core Version:    0.7.0.1
 */