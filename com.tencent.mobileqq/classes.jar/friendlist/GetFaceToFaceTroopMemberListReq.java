package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GetFaceToFaceTroopMemberListReq
  extends JceStruct
{
  public long dwReqType = 0L;
  public long dwUin = 0L;
  public String strMobile = "";
  
  public GetFaceToFaceTroopMemberListReq() {}
  
  public GetFaceToFaceTroopMemberListReq(long paramLong1, long paramLong2, String paramString)
  {
    this.dwReqType = paramLong1;
    this.dwUin = paramLong2;
    this.strMobile = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.dwReqType = paramJceInputStream.read(this.dwReqType, 0, true);
    this.dwUin = paramJceInputStream.read(this.dwUin, 1, false);
    this.strMobile = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.dwReqType, 0);
    paramJceOutputStream.write(this.dwUin, 1);
    String str = this.strMobile;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     friendlist.GetFaceToFaceTroopMemberListReq
 * JD-Core Version:    0.7.0.1
 */