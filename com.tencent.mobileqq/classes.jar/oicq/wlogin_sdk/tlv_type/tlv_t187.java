package oicq.wlogin_sdk.tlv_type;

public class tlv_t187
  extends tlv_t
{
  int _t187_body_len = 0;
  
  public tlv_t187()
  {
    this._cmd = 391;
  }
  
  public byte[] get_tlv_187(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = paramArrayOfByte;
    if (paramArrayOfByte == null) {
      arrayOfByte = new byte[16];
    }
    this._t187_body_len = arrayOfByte.length;
    paramArrayOfByte = new byte[this._t187_body_len];
    System.arraycopy(arrayOfByte, 0, paramArrayOfByte, 0, arrayOfByte.length);
    fill_head(this._cmd);
    fill_body(paramArrayOfByte, this._t187_body_len);
    set_length();
    return get_buf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.tlv_type.tlv_t187
 * JD-Core Version:    0.7.0.1
 */