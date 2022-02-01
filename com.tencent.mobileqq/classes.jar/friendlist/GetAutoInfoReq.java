package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GetAutoInfoReq
  extends JceStruct
{
  static int cache_sourceID;
  static int cache_sourceSubID;
  public byte cType = 1;
  public long dwFriendUin = 0L;
  public int sourceID = 3999;
  public int sourceSubID = 0;
  public long uin = 0L;
  
  public GetAutoInfoReq() {}
  
  public GetAutoInfoReq(long paramLong1, long paramLong2, byte paramByte, int paramInt1, int paramInt2)
  {
    this.uin = paramLong1;
    this.dwFriendUin = paramLong2;
    this.cType = paramByte;
    this.sourceID = paramInt1;
    this.sourceSubID = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, true);
    this.dwFriendUin = paramJceInputStream.read(this.dwFriendUin, 1, true);
    this.cType = paramJceInputStream.read(this.cType, 2, true);
    this.sourceID = paramJceInputStream.read(this.sourceID, 3, false);
    this.sourceSubID = paramJceInputStream.read(this.sourceSubID, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.dwFriendUin, 1);
    paramJceOutputStream.write(this.cType, 2);
    paramJceOutputStream.write(this.sourceID, 3);
    paramJceOutputStream.write(this.sourceSubID, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     friendlist.GetAutoInfoReq
 * JD-Core Version:    0.7.0.1
 */