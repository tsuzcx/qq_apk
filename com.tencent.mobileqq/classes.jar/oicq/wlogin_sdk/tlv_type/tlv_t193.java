package oicq.wlogin_sdk.tlv_type;

public class tlv_t193
  extends tlv_t
{
  public tlv_t193()
  {
    this._cmd = 403;
  }
  
  public byte[] get_tlv_193(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = paramArrayOfByte;
    if (paramArrayOfByte == null) {
      arrayOfByte = new byte[0];
    }
    fill_head(this._cmd);
    fill_body(arrayOfByte, arrayOfByte.length);
    set_length();
    return get_buf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.tlv_type.tlv_t193
 * JD-Core Version:    0.7.0.1
 */