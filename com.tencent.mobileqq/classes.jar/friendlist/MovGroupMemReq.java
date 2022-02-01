package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class MovGroupMemReq
  extends JceStruct
{
  static byte[] cache_vecBody;
  public byte reqtype = 0;
  public long uin = 0L;
  public byte[] vecBody = null;
  
  public MovGroupMemReq() {}
  
  public MovGroupMemReq(long paramLong, byte paramByte, byte[] paramArrayOfByte)
  {
    this.uin = paramLong;
    this.reqtype = paramByte;
    this.vecBody = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, true);
    this.reqtype = paramJceInputStream.read(this.reqtype, 1, true);
    if (cache_vecBody == null)
    {
      cache_vecBody = (byte[])new byte[1];
      ((byte[])cache_vecBody)[0] = 0;
    }
    this.vecBody = ((byte[])paramJceInputStream.read(cache_vecBody, 2, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.reqtype, 1);
    paramJceOutputStream.write(this.vecBody, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     friendlist.MovGroupMemReq
 * JD-Core Version:    0.7.0.1
 */