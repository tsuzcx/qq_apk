package oicq.wlogin_sdk.tlv_type;

public class tlv_t10a
  extends tlv_t
{
  public tlv_t10a()
  {
    this._cmd = 266;
  }
  
  public byte[] get_tlv_10a(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = paramArrayOfByte;
    if (paramArrayOfByte == null) {
      arrayOfByte = new byte[0];
    }
    paramArrayOfByte = new byte[arrayOfByte.length];
    System.arraycopy(arrayOfByte, 0, paramArrayOfByte, 0, arrayOfByte.length);
    fill_head(this._cmd);
    fill_body(paramArrayOfByte, paramArrayOfByte.length);
    set_length();
    return get_buf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.tlv_type.tlv_t10a
 * JD-Core Version:    0.7.0.1
 */