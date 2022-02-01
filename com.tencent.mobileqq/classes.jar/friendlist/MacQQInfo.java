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
    String str = this.guid;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    str = this.deviceName;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    str = this.operatingSystem;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     friendlist.MacQQInfo
 * JD-Core Version:    0.7.0.1
 */