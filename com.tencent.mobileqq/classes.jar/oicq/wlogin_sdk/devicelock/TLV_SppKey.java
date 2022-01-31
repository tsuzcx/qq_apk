package oicq.wlogin_sdk.devicelock;

public class TLV_SppKey
  extends e
{
  public byte[] SppKey = new byte[0];
  
  public TLV_SppKey()
  {
    this._type = 11;
  }
  
  public void parse()
  {
    this.SppKey = get_data();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.devicelock.TLV_SppKey
 * JD-Core Version:    0.7.0.1
 */