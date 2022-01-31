package oicq.wlogin_sdk.tlv_type;

import oicq.wlogin_sdk.tools.util;

public final class tlv_t541
  extends tlv_t
{
  int _flags = 0;
  
  public tlv_t541()
  {
    this._cmd = 1345;
  }
  
  public int get_flags()
  {
    return this._flags;
  }
  
  public Boolean verify()
  {
    if (this._body_len >= 1)
    {
      byte[] arrayOfByte = new byte[this._body_len];
      System.arraycopy(this._buf, this._head_len, arrayOfByte, 0, this._body_len);
      this._flags = util.buf_to_int8(arrayOfByte, 0);
      return Boolean.valueOf(true);
    }
    return Boolean.valueOf(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.tlv_type.tlv_t541
 * JD-Core Version:    0.7.0.1
 */