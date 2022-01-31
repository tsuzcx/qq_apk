package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class LastLoginPageInfo
  extends JceStruct
{
  public long dwCurrentReqIndex;
  public long dwCurrentReqUin;
  public long dwTotalReqTimes;
  
  public LastLoginPageInfo() {}
  
  public LastLoginPageInfo(long paramLong1, long paramLong2, long paramLong3)
  {
    this.dwTotalReqTimes = paramLong1;
    this.dwCurrentReqIndex = paramLong2;
    this.dwCurrentReqUin = paramLong3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.dwTotalReqTimes = paramJceInputStream.read(this.dwTotalReqTimes, 0, true);
    this.dwCurrentReqIndex = paramJceInputStream.read(this.dwCurrentReqIndex, 1, true);
    this.dwCurrentReqUin = paramJceInputStream.read(this.dwCurrentReqUin, 2, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.dwTotalReqTimes, 0);
    paramJceOutputStream.write(this.dwCurrentReqIndex, 1);
    paramJceOutputStream.write(this.dwCurrentReqUin, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     friendlist.LastLoginPageInfo
 * JD-Core Version:    0.7.0.1
 */