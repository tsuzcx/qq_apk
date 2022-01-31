package oicq.wlogin_sdk.tlv_type;

public class tlv_t192
  extends tlv_t
{
  byte[] _url = new byte[0];
  
  public tlv_t192()
  {
    this._cmd = 402;
  }
  
  public String getUrl()
  {
    return new String(this._url);
  }
  
  public Boolean verify()
  {
    this._url = new byte[this._body_len];
    System.arraycopy(this._buf, this._head_len, this._url, 0, this._body_len);
    return Boolean.valueOf(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.tlv_type.tlv_t192
 * JD-Core Version:    0.7.0.1
 */