package qqwifi.MQQ;

import LBS.LBSInfo;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ContentRequest
  extends JceStruct
{
  static LBSInfo cache_lbsInfo;
  public long id;
  public LBSInfo lbsInfo;
  public String version = "";
  
  public ContentRequest() {}
  
  public ContentRequest(long paramLong, LBSInfo paramLBSInfo, String paramString)
  {
    this.id = paramLong;
    this.lbsInfo = paramLBSInfo;
    this.version = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.id = paramJceInputStream.read(this.id, 0, true);
    if (cache_lbsInfo == null) {
      cache_lbsInfo = new LBSInfo();
    }
    this.lbsInfo = ((LBSInfo)paramJceInputStream.read(cache_lbsInfo, 1, false));
    this.version = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.id, 0);
    if (this.lbsInfo != null) {
      paramJceOutputStream.write(this.lbsInfo, 1);
    }
    if (this.version != null) {
      paramJceOutputStream.write(this.version, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aad.jar
 * Qualified Name:     qqwifi.MQQ.ContentRequest
 * JD-Core Version:    0.7.0.1
 */