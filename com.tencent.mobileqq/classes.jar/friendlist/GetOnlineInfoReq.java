package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GetOnlineInfoReq
  extends JceStruct
{
  public boolean bReqCustomOnlineStatus;
  public long dwReqType;
  public long dwUin;
  public String strMobile = "";
  public long version;
  
  public GetOnlineInfoReq() {}
  
  public GetOnlineInfoReq(long paramLong1, long paramLong2, String paramString, long paramLong3, boolean paramBoolean)
  {
    this.dwReqType = paramLong1;
    this.dwUin = paramLong2;
    this.strMobile = paramString;
    this.version = paramLong3;
    this.bReqCustomOnlineStatus = paramBoolean;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.dwReqType = paramJceInputStream.read(this.dwReqType, 0, true);
    this.dwUin = paramJceInputStream.read(this.dwUin, 1, false);
    this.strMobile = paramJceInputStream.readString(2, false);
    this.version = paramJceInputStream.read(this.version, 3, false);
    this.bReqCustomOnlineStatus = paramJceInputStream.read(this.bReqCustomOnlineStatus, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.dwReqType, 0);
    paramJceOutputStream.write(this.dwUin, 1);
    if (this.strMobile != null) {
      paramJceOutputStream.write(this.strMobile, 2);
    }
    paramJceOutputStream.write(this.version, 3);
    paramJceOutputStream.write(this.bReqCustomOnlineStatus, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     friendlist.GetOnlineInfoReq
 * JD-Core Version:    0.7.0.1
 */