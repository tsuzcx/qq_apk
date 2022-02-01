package qqwifi.MQQ;

import LBS.LBSInfo;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ContentRequest
  extends JceStruct
{
  static LBSInfo cache_lbsInfo;
  public long id = 0L;
  public LBSInfo lbsInfo = null;
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
    Object localObject = this.lbsInfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 1);
    }
    localObject = this.version;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqwifi.MQQ.ContentRequest
 * JD-Core Version:    0.7.0.1
 */