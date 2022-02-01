package oicq.wlogin_sdk.tlv_type;

public class tlv_t16e
  extends tlv_t
{
  int _t16e_body_len = 0;
  
  public tlv_t16e()
  {
    this._cmd = 366;
  }
  
  public byte[] get_tlv_16e(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = paramArrayOfByte;
    if (paramArrayOfByte == null) {
      arrayOfByte = new byte[0];
    }
    int j = arrayOfByte.length;
    int i = 64;
    if (j < 64) {
      i = arrayOfByte.length;
    }
    this._t16e_body_len = i;
    i = this._t16e_body_len;
    paramArrayOfByte = new byte[i];
    System.arraycopy(arrayOfByte, 0, paramArrayOfByte, 0, i);
    fill_head(this._cmd);
    fill_body(paramArrayOfByte, this._t16e_body_len);
    set_length();
    return get_buf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     oicq.wlogin_sdk.tlv_type.tlv_t16e
 * JD-Core Version:    0.7.0.1
 */