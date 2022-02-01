package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SetGroupResp
  extends JceStruct
{
  static byte[] cache_vecBody;
  public String ErrorString = "";
  public byte reqtype = 0;
  public byte result = 0;
  public byte[] vecBody = null;
  
  public SetGroupResp() {}
  
  public SetGroupResp(byte paramByte1, byte paramByte2, byte[] paramArrayOfByte, String paramString)
  {
    this.reqtype = paramByte1;
    this.result = paramByte2;
    this.vecBody = paramArrayOfByte;
    this.ErrorString = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.reqtype = paramJceInputStream.read(this.reqtype, 0, true);
    this.result = paramJceInputStream.read(this.result, 1, true);
    if (cache_vecBody == null)
    {
      cache_vecBody = (byte[])new byte[1];
      ((byte[])cache_vecBody)[0] = 0;
    }
    this.vecBody = ((byte[])paramJceInputStream.read(cache_vecBody, 2, true));
    this.ErrorString = paramJceInputStream.readString(3, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.reqtype, 0);
    paramJceOutputStream.write(this.result, 1);
    paramJceOutputStream.write(this.vecBody, 2);
    paramJceOutputStream.write(this.ErrorString, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     friendlist.SetGroupResp
 * JD-Core Version:    0.7.0.1
 */