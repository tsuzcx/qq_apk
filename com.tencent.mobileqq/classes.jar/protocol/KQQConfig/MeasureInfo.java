package protocol.KQQConfig;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class MeasureInfo
  extends JceStruct
{
  public byte bDefault = 1;
  public byte bLinkType;
  public byte bProxy = 1;
  public int iPort;
  public String sIP = "";
  public String sImsi = "";
  
  public MeasureInfo() {}
  
  public MeasureInfo(String paramString1, int paramInt, byte paramByte1, String paramString2, byte paramByte2, byte paramByte3)
  {
    this.sIP = paramString1;
    this.iPort = paramInt;
    this.bLinkType = paramByte1;
    this.sImsi = paramString2;
    this.bProxy = paramByte2;
    this.bDefault = paramByte3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.sIP = paramJceInputStream.readString(1, true);
    this.iPort = paramJceInputStream.read(this.iPort, 2, true);
    this.bLinkType = paramJceInputStream.read(this.bLinkType, 3, true);
    this.sImsi = paramJceInputStream.readString(4, false);
    this.bProxy = paramJceInputStream.read(this.bProxy, 5, false);
    this.bDefault = paramJceInputStream.read(this.bDefault, 6, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.sIP, 1);
    paramJceOutputStream.write(this.iPort, 2);
    paramJceOutputStream.write(this.bLinkType, 3);
    if (this.sImsi != null) {
      paramJceOutputStream.write(this.sImsi, 4);
    }
    paramJceOutputStream.write(this.bProxy, 5);
    paramJceOutputStream.write(this.bDefault, 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     protocol.KQQConfig.MeasureInfo
 * JD-Core Version:    0.7.0.1
 */