package oicq.wlogin_sdk.tlv_type;

import oicq.wlogin_sdk.tools.util;

public class tlv_t116
  extends tlv_t
{
  int _t116_body_len = 0;
  int _ver = 0;
  
  public tlv_t116()
  {
    this._cmd = 278;
  }
  
  public byte[] get_tlv_116(int paramInt1, int paramInt2, long[] paramArrayOfLong)
  {
    int i = 0;
    long[] arrayOfLong = paramArrayOfLong;
    if (paramArrayOfLong == null) {
      arrayOfLong = new long[0];
    }
    this._t116_body_len = (arrayOfLong.length * 4 + 10);
    paramArrayOfLong = new byte[this._t116_body_len];
    util.int8_to_buf(paramArrayOfLong, 0, this._ver);
    util.int32_to_buf(paramArrayOfLong, 1, paramInt1);
    util.int32_to_buf(paramArrayOfLong, 5, paramInt2);
    util.int8_to_buf(paramArrayOfLong, 9, arrayOfLong.length);
    paramInt2 = 10;
    paramInt1 = i;
    while (paramInt1 < arrayOfLong.length)
    {
      util.int32_to_buf(paramArrayOfLong, paramInt2, (int)arrayOfLong[paramInt1]);
      paramInt2 += 4;
      paramInt1 += 1;
    }
    fill_head(this._cmd);
    fill_body(paramArrayOfLong, this._t116_body_len);
    set_length();
    return get_buf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.tlv_type.tlv_t116
 * JD-Core Version:    0.7.0.1
 */