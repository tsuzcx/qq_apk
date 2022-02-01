package oicq.wlogin_sdk.tlv_type;

import oicq.wlogin_sdk.tools.cryptor;
import oicq.wlogin_sdk.tools.util;

public class tlv_t400
  extends tlv_t
{
  int _t400_body_len = 0;
  int _version = 1;
  
  public tlv_t400()
  {
    this._cmd = 1024;
  }
  
  public byte[] get_tlv_400(byte[] paramArrayOfByte1, long paramLong1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, long paramLong2, long paramLong3, byte[] paramArrayOfByte4)
  {
    byte[] arrayOfByte = paramArrayOfByte1;
    if (paramArrayOfByte1 == null) {
      arrayOfByte = new byte[16];
    }
    paramArrayOfByte1 = paramArrayOfByte2;
    if (paramArrayOfByte2 == null) {
      paramArrayOfByte1 = new byte[16];
    }
    paramArrayOfByte2 = paramArrayOfByte3;
    if (paramArrayOfByte3 == null) {
      paramArrayOfByte2 = new byte[16];
    }
    paramArrayOfByte3 = paramArrayOfByte4;
    if (paramArrayOfByte4 == null) {
      paramArrayOfByte3 = new byte[8];
    }
    this._t400_body_len = (paramArrayOfByte1.length + 10 + paramArrayOfByte2.length + 4 + 4 + 4 + paramArrayOfByte3.length);
    paramArrayOfByte4 = new byte[this._t400_body_len];
    util.int16_to_buf(paramArrayOfByte4, 0, this._version);
    util.int64_to_buf(paramArrayOfByte4, 2, paramLong1);
    System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte4, 10, paramArrayOfByte1.length);
    int i = 10 + paramArrayOfByte1.length;
    System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte4, i, paramArrayOfByte2.length);
    i += paramArrayOfByte2.length;
    util.int32_to_buf(paramArrayOfByte4, i, (int)paramLong2);
    i += 4;
    util.int32_to_buf(paramArrayOfByte4, i, (int)paramLong3);
    i += 4;
    util.int64_to_buf32(paramArrayOfByte4, i, util.get_server_cur_time());
    System.arraycopy(paramArrayOfByte3, 0, paramArrayOfByte4, i + 4, paramArrayOfByte3.length);
    i = paramArrayOfByte3.length;
    paramArrayOfByte1 = cryptor.encrypt(paramArrayOfByte4, 0, paramArrayOfByte4.length, arrayOfByte);
    this._t400_body_len = paramArrayOfByte1.length;
    fill_head(this._cmd);
    fill_body(paramArrayOfByte1, paramArrayOfByte1.length);
    set_length();
    return get_buf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     oicq.wlogin_sdk.tlv_type.tlv_t400
 * JD-Core Version:    0.7.0.1
 */