package oicq.wlogin_sdk.devicelock;

public class g
  extends e
{
  public g()
  {
    this._type = 2;
  }
  
  public byte[] a(long paramLong1, long paramLong2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5, byte[] paramArrayOfByte6)
  {
    if ((paramArrayOfByte1 != null) && (paramArrayOfByte2 != null) && (paramArrayOfByte3 != null) && (paramArrayOfByte4 != null) && (paramArrayOfByte5 != null) && (paramArrayOfByte6 != null))
    {
      byte[] arrayOfByte = new byte[paramArrayOfByte1.length + 10 + 2 + paramArrayOfByte2.length + 2 + paramArrayOfByte3.length + 2 + paramArrayOfByte4.length + 2 + paramArrayOfByte5.length + 2 + paramArrayOfByte6.length];
      int i = this._head_len;
      fill_head();
      fill_body(arrayOfByte, arrayOfByte.length);
      i = put_int32((int)paramLong1, i);
      put_block(paramArrayOfByte6, put_block(paramArrayOfByte5, put_block(paramArrayOfByte4, put_block(paramArrayOfByte3, put_block(paramArrayOfByte2, put_block(paramArrayOfByte1, put_int32((int)paramLong2, i)))))));
      return get_buf();
    }
    return new byte[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     oicq.wlogin_sdk.devicelock.g
 * JD-Core Version:    0.7.0.1
 */