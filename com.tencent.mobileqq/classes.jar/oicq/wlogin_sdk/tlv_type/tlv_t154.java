package oicq.wlogin_sdk.tlv_type;

import oicq.wlogin_sdk.tools.util;

public class tlv_t154
  extends tlv_t
{
  public tlv_t154()
  {
    this._cmd = 340;
  }
  
  public byte[] get_tlv_154(int paramInt)
  {
    byte[] arrayOfByte = new byte[4];
    util.int32_to_buf(arrayOfByte, 0, paramInt);
    fill_head(this._cmd);
    fill_body(arrayOfByte, arrayOfByte.length);
    set_length();
    return get_buf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     oicq.wlogin_sdk.tlv_type.tlv_t154
 * JD-Core Version:    0.7.0.1
 */