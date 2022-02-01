package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GetGroupListReq
  extends JceStruct
{
  public byte flush = 0;
  public byte getgroupCount = 0;
  public byte startIndex = 0;
  public long uin = 0L;
  
  public GetGroupListReq() {}
  
  public GetGroupListReq(long paramLong, byte paramByte1, byte paramByte2, byte paramByte3)
  {
    this.uin = paramLong;
    this.startIndex = paramByte1;
    this.getgroupCount = paramByte2;
    this.flush = paramByte3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, true);
    this.startIndex = paramJceInputStream.read(this.startIndex, 1, true);
    this.getgroupCount = paramJceInputStream.read(this.getgroupCount, 2, true);
    this.flush = paramJceInputStream.read(this.flush, 3, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.startIndex, 1);
    paramJceOutputStream.write(this.getgroupCount, 2);
    paramJceOutputStream.write(this.flush, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     friendlist.GetGroupListReq
 * JD-Core Version:    0.7.0.1
 */