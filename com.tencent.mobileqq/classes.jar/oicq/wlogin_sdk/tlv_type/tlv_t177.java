package oicq.wlogin_sdk.tlv_type;

import oicq.wlogin_sdk.tools.util;

public class tlv_t177
  extends tlv_t
{
  int _t177_body_len = 0;
  
  public tlv_t177()
  {
    this._cmd = 375;
  }
  
  public byte[] get_tlv_177(long paramLong, String paramString)
  {
    byte[] arrayOfByte = new byte[0];
    if (paramString != null) {
      arrayOfByte = paramString.getBytes();
    }
    this._t177_body_len = (arrayOfByte.length + 7);
    paramString = new byte[this._t177_body_len];
    util.int8_to_buf(paramString, 0, 1);
    util.int64_to_buf32(paramString, 1, paramLong);
    util.int16_to_buf(paramString, 5, arrayOfByte.length);
    System.arraycopy(arrayOfByte, 0, paramString, 7, arrayOfByte.length);
    int i = arrayOfByte.length;
    fill_head(this._cmd);
    fill_body(paramString, this._t177_body_len);
    set_length();
    return get_buf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     oicq.wlogin_sdk.tlv_type.tlv_t177
 * JD-Core Version:    0.7.0.1
 */