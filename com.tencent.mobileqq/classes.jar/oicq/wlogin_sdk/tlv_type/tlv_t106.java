package oicq.wlogin_sdk.tlv_type;

import oicq.wlogin_sdk.tools.MD5;
import oicq.wlogin_sdk.tools.cryptor;
import oicq.wlogin_sdk.tools.util;

public class tlv_t106
  extends tlv_t
{
  int _SSoVer = 15;
  int _TGTGTVer = 4;
  int _t106_body_len = 98;
  
  public tlv_t106()
  {
    this._cmd = 262;
  }
  
  public byte[] get_tlv_106(long paramLong1, long paramLong2, int paramInt1, long paramLong3, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt2, byte[] paramArrayOfByte3, long paramLong4, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5, int paramInt3, byte[] paramArrayOfByte6, int paramInt4)
  {
    byte[] arrayOfByte = paramArrayOfByte1;
    if (paramArrayOfByte1 == null) {
      arrayOfByte = new byte[0];
    }
    paramArrayOfByte1 = paramArrayOfByte2;
    if (paramArrayOfByte2 == null) {
      paramArrayOfByte1 = new byte[0];
    }
    paramArrayOfByte2 = paramArrayOfByte3;
    if (paramArrayOfByte3 == null) {
      paramArrayOfByte2 = new byte[0];
    }
    paramArrayOfByte3 = paramArrayOfByte5;
    if (paramArrayOfByte5 == null) {
      paramArrayOfByte3 = new byte[0];
    }
    paramArrayOfByte5 = paramArrayOfByte6;
    if (paramArrayOfByte6 == null) {
      paramArrayOfByte5 = new byte[0];
    }
    paramArrayOfByte6 = paramArrayOfByte4;
    if (paramArrayOfByte4 == null) {
      paramArrayOfByte6 = new byte[0];
    }
    this._t106_body_len += paramArrayOfByte6.length + 2;
    paramArrayOfByte4 = new byte[this._t106_body_len];
    util.int16_to_buf(paramArrayOfByte4, 0, this._TGTGTVer);
    util.int32_to_buf(paramArrayOfByte4, 2, util.get_rand_32());
    util.int32_to_buf(paramArrayOfByte4, 6, this._SSoVer);
    util.int32_to_buf(paramArrayOfByte4, 10, (int)paramLong1);
    util.int32_to_buf(paramArrayOfByte4, 14, paramInt1);
    if (paramLong3 == 0L)
    {
      paramLong1 = paramLong4;
      util.int64_to_buf(paramArrayOfByte4, 18, paramLong1);
      System.arraycopy(arrayOfByte, 0, paramArrayOfByte4, 26, arrayOfByte.length);
      paramInt1 = arrayOfByte.length + 26;
      System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte4, paramInt1, paramArrayOfByte1.length);
      paramInt1 += paramArrayOfByte1.length;
      util.int8_to_buf(paramArrayOfByte4, paramInt1, paramInt2);
      paramInt1 += 1;
      System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte4, paramInt1, paramArrayOfByte2.length);
      paramInt1 += paramArrayOfByte2.length;
      System.arraycopy(paramArrayOfByte3, 0, paramArrayOfByte4, paramInt1, paramArrayOfByte3.length);
      paramInt1 += paramArrayOfByte3.length;
      util.int32_to_buf(paramArrayOfByte4, paramInt1, 0);
      paramInt1 += 4;
      util.int8_to_buf(paramArrayOfByte4, paramInt1, paramInt3);
      paramInt1 += 1;
      if (paramArrayOfByte5.length != 0) {
        break label506;
      }
      paramArrayOfByte1 = new byte[16];
      util.int32_to_buf(paramArrayOfByte1, 0, util.get_rand_32());
      util.int32_to_buf(paramArrayOfByte1, 4, util.get_rand_32());
      util.int32_to_buf(paramArrayOfByte1, 8, util.get_rand_32());
      util.int32_to_buf(paramArrayOfByte1, 12, util.get_rand_32());
      paramInt1 += paramArrayOfByte1.length;
      label358:
      util.int64_to_buf32(paramArrayOfByte4, paramInt1, paramLong2);
      paramInt1 += 4;
      util.int32_to_buf(paramArrayOfByte4, paramInt1, paramInt4);
      paramInt1 += 4;
      util.int16_to_buf(paramArrayOfByte4, paramInt1, paramArrayOfByte6.length);
      System.arraycopy(paramArrayOfByte6, 0, paramArrayOfByte4, paramInt1 + 2, paramArrayOfByte6.length);
      paramArrayOfByte1 = new byte[24];
      System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte1, 0, paramArrayOfByte2.length);
      if (paramLong4 != 0L) {
        break label530;
      }
      util.int64_to_buf(paramArrayOfByte1, 16, paramLong3);
    }
    for (;;)
    {
      paramArrayOfByte1 = MD5.toMD5Byte(paramArrayOfByte1);
      paramArrayOfByte1 = cryptor.encrypt(paramArrayOfByte4, 0, paramArrayOfByte4.length, paramArrayOfByte1);
      this._t106_body_len = paramArrayOfByte1.length;
      fill_head(this._cmd);
      fill_body(paramArrayOfByte1, this._t106_body_len);
      set_length();
      return get_buf();
      paramLong1 = paramLong3;
      break;
      label506:
      System.arraycopy(paramArrayOfByte5, 0, paramArrayOfByte4, paramInt1, paramArrayOfByte5.length);
      paramInt1 += paramArrayOfByte5.length;
      break label358;
      label530:
      util.int64_to_buf(paramArrayOfByte1, 16, paramLong4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.tlv_type.tlv_t106
 * JD-Core Version:    0.7.0.1
 */