package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class MacQQInfo
  extends JceStruct
{
  public String deviceName = "";
  public String guid = "";
  public String operatingSystem = "";
  
  public MacQQInfo() {}
  
  public MacQQInfo(String paramString1, String paramString2, String paramString3)
  {
    this.guid = paramString1;
    this.deviceName = paramString2;
    this.operatingSystem = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.guid = paramJceInputStream.readString(0, false);
    this.deviceName = paramJceInputStream.readString(1, false);
    this.operatingSystem = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.guid != null) {
      paramJceOutputStream.write(this.guid, 0);
    }
    if (this.deviceName != null) {
      paramJceOutputStream.write(this.deviceName, 1);
    }
    if (this.operatingSystem != null) {
      paramJceOutputStream.write(this.operatingSystem, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     friendlist.MacQQInfo
 * JD-Core Version:    0.7.0.1
 */