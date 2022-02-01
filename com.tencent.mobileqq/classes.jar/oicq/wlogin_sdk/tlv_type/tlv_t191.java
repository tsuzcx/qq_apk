package oicq.wlogin_sdk.tlv_type;

public class tlv_t191
  extends tlv_t
{
  public tlv_t191()
  {
    this._cmd = 401;
  }
  
  public byte[] get_tlv_191(int paramInt)
  {
    int i = (byte)paramInt;
    fill_head(this._cmd);
    fill_body(new byte[] { i }, 1);
    set_length();
    return get_buf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     oicq.wlogin_sdk.tlv_type.tlv_t191
 * JD-Core Version:    0.7.0.1
 */