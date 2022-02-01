package friendlist;

import PasserbySvc.ReqCheckIn;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GetSimpleOnlineFriendInfoReq
  extends JceStruct
{
  static ReqCheckIn cache_stReqCheckIn;
  public byte cSrcType = 0;
  public byte ifShowTermType = 0;
  public byte ifgetFriendVideoAbi = 0;
  public byte isReqCheckIn = 0;
  public ReqCheckIn stReqCheckIn = null;
  public long uin = 0L;
  public long version = 0L;
  
  public GetSimpleOnlineFriendInfoReq() {}
  
  public GetSimpleOnlineFriendInfoReq(long paramLong1, byte paramByte1, byte paramByte2, ReqCheckIn paramReqCheckIn, byte paramByte3, long paramLong2, byte paramByte4)
  {
    this.uin = paramLong1;
    this.ifgetFriendVideoAbi = paramByte1;
    this.isReqCheckIn = paramByte2;
    this.stReqCheckIn = paramReqCheckIn;
    this.ifShowTermType = paramByte3;
    this.version = paramLong2;
    this.cSrcType = paramByte4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, true);
    this.ifgetFriendVideoAbi = paramJceInputStream.read(this.ifgetFriendVideoAbi, 1, false);
    this.isReqCheckIn = paramJceInputStream.read(this.isReqCheckIn, 2, false);
    if (cache_stReqCheckIn == null) {
      cache_stReqCheckIn = new ReqCheckIn();
    }
    this.stReqCheckIn = ((ReqCheckIn)paramJceInputStream.read(cache_stReqCheckIn, 3, false));
    this.ifShowTermType = paramJceInputStream.read(this.ifShowTermType, 4, false);
    this.version = paramJceInputStream.read(this.version, 5, false);
    this.cSrcType = paramJceInputStream.read(this.cSrcType, 6, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.ifgetFriendVideoAbi, 1);
    paramJceOutputStream.write(this.isReqCheckIn, 2);
    if (this.stReqCheckIn != null) {
      paramJceOutputStream.write(this.stReqCheckIn, 3);
    }
    paramJceOutputStream.write(this.ifShowTermType, 4);
    paramJceOutputStream.write(this.version, 5);
    paramJceOutputStream.write(this.cSrcType, 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     friendlist.GetSimpleOnlineFriendInfoReq
 * JD-Core Version:    0.7.0.1
 */