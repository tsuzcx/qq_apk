package oicq.wlogin_sdk.tlv_type;

import oicq.wlogin_sdk.tools.util;

public class tlv_t200
  extends tlv_t
{
  byte[] pf = new byte[0];
  byte[] pfkey = new byte[0];
  
  public tlv_t200()
  {
    this._cmd = 512;
  }
  
  public byte[] getPf()
  {
    return this.pf;
  }
  
  public byte[] getPfKey()
  {
    return this.pfkey;
  }
  
  public Boolean verify()
  {
    int i = this._body_len;
    Boolean localBoolean = Boolean.valueOf(false);
    if (i < 2) {
      return localBoolean;
    }
    int j = util.buf_to_int16(this._buf, this._head_len + 0);
    int k = this._body_len;
    i = 2 + j;
    if (k < i) {
      return localBoolean;
    }
    this.pf = new byte[j];
    System.arraycopy(this._buf, this._head_len + 2, this.pf, 0, j);
    k = this._body_len;
    j = i + 2;
    if (k < j) {
      return localBoolean;
    }
    i = util.buf_to_int16(this._buf, this._head_len + i);
    if (this._body_len < j + i) {
      return localBoolean;
    }
    this.pfkey = new byte[i];
    System.arraycopy(this._buf, this._head_len + j, this.pfkey, 0, i);
    return Boolean.valueOf(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     oicq.wlogin_sdk.tlv_type.tlv_t200
 * JD-Core Version:    0.7.0.1
 */