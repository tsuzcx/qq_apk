package oicq.wlogin_sdk.tlv_type;

public class tlv_t188
  extends tlv_t
{
  int _t188_body_len = 0;
  
  public tlv_t188()
  {
    this._cmd = 392;
  }
  
  public byte[] get_tlv_188(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = paramArrayOfByte;
    if (paramArrayOfByte == null) {
      arrayOfByte = new byte[16];
    }
    this._t188_body_len = arrayOfByte.length;
    paramArrayOfByte = new byte[this._t188_body_len];
    System.arraycopy(arrayOfByte, 0, paramArrayOfByte, 0, arrayOfByte.length);
    fill_head(this._cmd);
    fill_body(paramArrayOfByte, this._t188_body_len);
    set_length();
    return get_buf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     oicq.wlogin_sdk.tlv_type.tlv_t188
 * JD-Core Version:    0.7.0.1
 */