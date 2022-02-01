package oicq.wlogin_sdk.tlv_type;

import oicq.wlogin_sdk.tools.util;

public class tlv_t124
  extends tlv_t
{
  int _t124_body_len = 0;
  
  public tlv_t124()
  {
    this._cmd = 292;
  }
  
  public byte[] get_tlv_124(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5)
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
    paramArrayOfByte3 = paramArrayOfByte4;
    if (paramArrayOfByte4 == null) {
      paramArrayOfByte3 = new byte[0];
    }
    paramArrayOfByte4 = paramArrayOfByte5;
    if (paramArrayOfByte5 == null) {
      paramArrayOfByte4 = new byte[0];
    }
    int n = limit_len(arrayOfByte, 16);
    int m = limit_len(paramArrayOfByte1, 16);
    int k = limit_len(paramArrayOfByte2, 16);
    int j = limit_len(paramArrayOfByte3, 32);
    int i = limit_len(paramArrayOfByte4, 16);
    this._t124_body_len = (n + 2 + 2 + m + 2 + 2 + k + 2 + j + 2 + i);
    paramArrayOfByte5 = new byte[this._t124_body_len];
    util.int16_to_buf(paramArrayOfByte5, 0, n);
    System.arraycopy(arrayOfByte, 0, paramArrayOfByte5, 2, n);
    n += 2;
    util.int16_to_buf(paramArrayOfByte5, n, m);
    n += 2;
    System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte5, n, m);
    m = n + m;
    util.int16_to_buf(paramArrayOfByte5, m, paramInt);
    paramInt = m + 2;
    util.int16_to_buf(paramArrayOfByte5, paramInt, k);
    paramInt += 2;
    System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte5, paramInt, k);
    paramInt += k;
    util.int16_to_buf(paramArrayOfByte5, paramInt, j);
    paramInt += 2;
    System.arraycopy(paramArrayOfByte3, 0, paramArrayOfByte5, paramInt, j);
    paramInt += j;
    util.int16_to_buf(paramArrayOfByte5, paramInt, i);
    System.arraycopy(paramArrayOfByte4, 0, paramArrayOfByte5, paramInt + 2, i);
    fill_head(this._cmd);
    fill_body(paramArrayOfByte5, this._t124_body_len);
    set_length();
    return get_buf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     oicq.wlogin_sdk.tlv_type.tlv_t124
 * JD-Core Version:    0.7.0.1
 */