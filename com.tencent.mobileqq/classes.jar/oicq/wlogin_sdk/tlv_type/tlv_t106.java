package oicq.wlogin_sdk.tlv_type;

import oicq.wlogin_sdk.tools.MD5;
import oicq.wlogin_sdk.tools.cryptor;
import oicq.wlogin_sdk.tools.util;

public class tlv_t106
  extends tlv_t
{
  int _SSoVer = 17;
  int _TGTGTVer = 4;
  int _t106_body_len = 98;
  
  public tlv_t106()
  {
    this._cmd = 262;
  }
  
  public byte[] get_tlv_106(long paramLong1, long paramLong2, int paramInt1, long paramLong3, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt2, byte[] paramArrayOfByte3, long paramLong4, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5, int paramInt3, byte[] paramArrayOfByte6, int paramInt4)
  {
    if (paramArrayOfByte1 == null) {
      paramArrayOfByte1 = new byte[0];
    }
    if (paramArrayOfByte2 == null) {
      paramArrayOfByte2 = new byte[0];
    }
    if (paramArrayOfByte3 == null) {
      paramArrayOfByte3 = new byte[0];
    }
    if (paramArrayOfByte5 == null) {
      paramArrayOfByte5 = new byte[0];
    }
    if (paramArrayOfByte6 == null) {
      paramArrayOfByte6 = new byte[0];
    }
    if (paramArrayOfByte4 == null) {
      paramArrayOfByte4 = new byte[0];
    }
    this._t106_body_len += paramArrayOfByte4.length + 2;
    byte[] arrayOfByte = new byte[this._t106_body_len];
    util.int16_to_buf(arrayOfByte, 0, this._TGTGTVer);
    util.int32_to_buf(arrayOfByte, 2, util.get_rand_32());
    util.int32_to_buf(arrayOfByte, 6, this._SSoVer);
    util.int32_to_buf(arrayOfByte, 10, (int)paramLong1);
    util.int32_to_buf(arrayOfByte, 14, paramInt1);
    if (paramLong3 == 0L) {
      paramLong1 = paramLong4;
    } else {
      paramLong1 = paramLong3;
    }
    util.int64_to_buf(arrayOfByte, 18, paramLong1);
    System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 26, paramArrayOfByte1.length);
    paramInt1 = 26 + paramArrayOfByte1.length;
    System.arraycopy(paramArrayOfByte2, 0, arrayOfByte, paramInt1, paramArrayOfByte2.length);
    paramInt1 += paramArrayOfByte2.length;
    util.int8_to_buf(arrayOfByte, paramInt1, paramInt2);
    paramInt1 += 1;
    System.arraycopy(paramArrayOfByte3, 0, arrayOfByte, paramInt1, paramArrayOfByte3.length);
    paramInt1 += paramArrayOfByte3.length;
    System.arraycopy(paramArrayOfByte5, 0, arrayOfByte, paramInt1, paramArrayOfByte5.length);
    paramInt1 += paramArrayOfByte5.length;
    util.int32_to_buf(arrayOfByte, paramInt1, 0);
    paramInt1 += 4;
    util.int8_to_buf(arrayOfByte, paramInt1, paramInt3);
    paramInt2 = paramInt1 + 1;
    if (paramArrayOfByte6.length == 0)
    {
      paramArrayOfByte1 = new byte[16];
      util.int32_to_buf(paramArrayOfByte1, 0, util.get_rand_32());
      util.int32_to_buf(paramArrayOfByte1, 4, util.get_rand_32());
      util.int32_to_buf(paramArrayOfByte1, 8, util.get_rand_32());
      util.int32_to_buf(paramArrayOfByte1, 12, util.get_rand_32());
      paramInt1 = paramArrayOfByte1.length;
    }
    else
    {
      System.arraycopy(paramArrayOfByte6, 0, arrayOfByte, paramInt2, paramArrayOfByte6.length);
      paramInt1 = paramArrayOfByte6.length;
    }
    paramInt1 = paramInt2 + paramInt1;
    util.int64_to_buf32(arrayOfByte, paramInt1, paramLong2);
    paramInt1 += 4;
    util.int32_to_buf(arrayOfByte, paramInt1, paramInt4);
    paramInt1 += 4;
    util.int16_to_buf(arrayOfByte, paramInt1, paramArrayOfByte4.length);
    System.arraycopy(paramArrayOfByte4, 0, arrayOfByte, paramInt1 + 2, paramArrayOfByte4.length);
    paramArrayOfByte1 = new byte[24];
    System.arraycopy(paramArrayOfByte3, 0, paramArrayOfByte1, 0, paramArrayOfByte3.length);
    if (paramLong4 == 0L) {
      util.int64_to_buf(paramArrayOfByte1, 16, paramLong3);
    } else {
      util.int64_to_buf(paramArrayOfByte1, 16, paramLong4);
    }
    paramArrayOfByte1 = MD5.toMD5Byte(paramArrayOfByte1);
    paramArrayOfByte1 = cryptor.encrypt(arrayOfByte, 0, arrayOfByte.length, paramArrayOfByte1);
    this._t106_body_len = paramArrayOfByte1.length;
    fill_head(this._cmd);
    fill_body(paramArrayOfByte1, this._t106_body_len);
    set_length();
    return get_buf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     oicq.wlogin_sdk.tlv_type.tlv_t106
 * JD-Core Version:    0.7.0.1
 */