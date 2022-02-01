package oicq.wlogin_sdk.tlv_type;

import com.tencent.secprotocol.ByteData;

public class tlv_t544
  extends tlv_t
{
  public tlv_t544()
  {
    this._cmd = 1348;
  }
  
  private byte[] errInfo(byte paramByte)
  {
    byte[] arrayOfByte = new byte[4];
    arrayOfByte[2] = paramByte;
    return makeByte(arrayOfByte, arrayOfByte.length);
  }
  
  private byte[] makeByte(byte[] paramArrayOfByte, int paramInt)
  {
    fill_head(this._cmd);
    fill_body(paramArrayOfByte, paramInt);
    set_length();
    return get_buf();
  }
  
  public byte[] get_tlv_544(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    try
    {
      ByteData.getInstance().setDataEx(paramString1, paramString2);
      paramString1 = ByteData.getInstance().getSign(paramString1, paramString2, paramArrayOfByte);
      paramString1 = makeByte(paramString1, paramString1.length);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      paramString2 = errInfo((byte)1);
      paramString1.printStackTrace();
    }
    return paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     oicq.wlogin_sdk.tlv_type.tlv_t544
 * JD-Core Version:    0.7.0.1
 */