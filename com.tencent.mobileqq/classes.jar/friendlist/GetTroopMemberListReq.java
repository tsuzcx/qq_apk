package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GetTroopMemberListReq
  extends JceStruct
{
  public long GetListAppointTime;
  public long GroupCode;
  public long GroupUin;
  public long NextUin;
  public long ReqType;
  public long Version;
  public byte cRichCardNameVer;
  public long uin;
  
  public GetTroopMemberListReq() {}
  
  public GetTroopMemberListReq(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, byte paramByte)
  {
    this.uin = paramLong1;
    this.GroupCode = paramLong2;
    this.NextUin = paramLong3;
    this.GroupUin = paramLong4;
    this.Version = paramLong5;
    this.ReqType = paramLong6;
    this.GetListAppointTime = paramLong7;
    this.cRichCardNameVer = paramByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, true);
    this.GroupCode = paramJceInputStream.read(this.GroupCode, 1, true);
    this.NextUin = paramJceInputStream.read(this.NextUin, 2, true);
    this.GroupUin = paramJceInputStream.read(this.GroupUin, 3, true);
    this.Version = paramJceInputStream.read(this.Version, 4, false);
    this.ReqType = paramJceInputStream.read(this.ReqType, 5, false);
    this.GetListAppointTime = paramJceInputStream.read(this.GetListAppointTime, 6, false);
    this.cRichCardNameVer = paramJceInputStream.read(this.cRichCardNameVer, 7, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.GroupCode, 1);
    paramJceOutputStream.write(this.NextUin, 2);
    paramJceOutputStream.write(this.GroupUin, 3);
    paramJceOutputStream.write(this.Version, 4);
    paramJceOutputStream.write(this.ReqType, 5);
    paramJceOutputStream.write(this.GetListAppointTime, 6);
    paramJceOutputStream.write(this.cRichCardNameVer, 7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     friendlist.GetTroopMemberListReq
 * JD-Core Version:    0.7.0.1
 */