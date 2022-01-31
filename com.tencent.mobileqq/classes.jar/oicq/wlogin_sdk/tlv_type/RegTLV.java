package oicq.wlogin_sdk.tlv_type;

import oicq.wlogin_sdk.tools.util;

public class RegTLV
  extends tlv_t
{
  int _head_len = 4;
  
  public RegTLV(int paramInt)
  {
    super(paramInt);
  }
  
  public byte[] getBuf()
  {
    return get_buf();
  }
  
  public void setByte(byte paramByte)
  {
    byte[] arrayOfByte = new byte[1];
    arrayOfByte[0] = paramByte;
    setData(arrayOfByte, arrayOfByte.length);
  }
  
  public void setData(byte[] paramArrayOfByte, int paramInt)
  {
    if (this._head_len + paramInt > this._max)
    {
      this._max = (this._head_len + paramInt + 128);
      byte[] arrayOfByte = new byte[this._max];
      System.arraycopy(this._buf, 0, arrayOfByte, 0, this._head_len);
      this._buf = arrayOfByte;
    }
    this._pos = (this._head_len + paramInt);
    System.arraycopy(paramArrayOfByte, 0, this._buf, this._head_len, paramInt);
    this._body_len = paramInt;
    util.int16_to_buf(this._buf, 0, this._cmd);
    util.int16_to_buf(this._buf, 2, this._body_len);
  }
  
  public void setInt(int paramInt)
  {
    byte[] arrayOfByte = new byte[4];
    util.int32_to_buf(arrayOfByte, 0, paramInt);
    setData(arrayOfByte, arrayOfByte.length);
  }
  
  public void setLong(long paramLong)
  {
    byte[] arrayOfByte = new byte[8];
    util.int64_to_buf(arrayOfByte, 0, paramLong);
    setData(arrayOfByte, arrayOfByte.length);
  }
  
  public void setShort(int paramInt)
  {
    byte[] arrayOfByte = new byte[2];
    util.int16_to_buf(arrayOfByte, 0, paramInt);
    setData(arrayOfByte, arrayOfByte.length);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.tlv_type.RegTLV
 * JD-Core Version:    0.7.0.1
 */