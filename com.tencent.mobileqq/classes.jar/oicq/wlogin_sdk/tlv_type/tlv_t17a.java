package oicq.wlogin_sdk.tlv_type;

import oicq.wlogin_sdk.tools.util;

public class tlv_t17a
  extends tlv_t
{
  public tlv_t17a()
  {
    this._cmd = 378;
  }
  
  public byte[] get_tlv_17a(long paramLong)
  {
    byte[] arrayOfByte = new byte[4];
    util.int64_to_buf32(arrayOfByte, 0, paramLong);
    fill_head(this._cmd);
    fill_body(arrayOfByte, 4);
    set_length();
    return get_buf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     oicq.wlogin_sdk.tlv_type.tlv_t17a
 * JD-Core Version:    0.7.0.1
 */