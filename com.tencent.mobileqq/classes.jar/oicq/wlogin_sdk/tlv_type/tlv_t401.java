package oicq.wlogin_sdk.tlv_type;

public class tlv_t401
  extends tlv_t
{
  public tlv_t401()
  {
    this._cmd = 1025;
  }
  
  public byte[] get_tlv_401(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = paramArrayOfByte;
    if (paramArrayOfByte == null) {
      arrayOfByte = new byte[16];
    }
    paramArrayOfByte = new byte[arrayOfByte.length];
    System.arraycopy(arrayOfByte, 0, paramArrayOfByte, 0, arrayOfByte.length);
    int i = arrayOfByte.length;
    fill_head(this._cmd);
    fill_body(paramArrayOfByte, paramArrayOfByte.length);
    set_length();
    return get_buf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     oicq.wlogin_sdk.tlv_type.tlv_t401
 * JD-Core Version:    0.7.0.1
 */