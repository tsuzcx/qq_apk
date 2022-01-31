package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GetLastLoginInfoReq
  extends JceStruct
{
  static LastLoginPageInfo cache_stPageInfo;
  public LastLoginPageInfo stPageInfo;
  public long uin;
  
  public GetLastLoginInfoReq() {}
  
  public GetLastLoginInfoReq(long paramLong, LastLoginPageInfo paramLastLoginPageInfo)
  {
    this.uin = paramLong;
    this.stPageInfo = paramLastLoginPageInfo;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, true);
    if (cache_stPageInfo == null) {
      cache_stPageInfo = new LastLoginPageInfo();
    }
    this.stPageInfo = ((LastLoginPageInfo)paramJceInputStream.read(cache_stPageInfo, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    if (this.stPageInfo != null) {
      paramJceOutputStream.write(this.stPageInfo, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     friendlist.GetLastLoginInfoReq
 * JD-Core Version:    0.7.0.1
 */