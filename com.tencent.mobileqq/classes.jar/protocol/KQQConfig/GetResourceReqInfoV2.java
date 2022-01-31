package protocol.KQQConfig;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GetResourceReqInfoV2
  extends JceStruct
{
  public byte cDelFlag;
  public byte cPush;
  public byte cState;
  public byte cStatus;
  public int iPluginType = 64;
  public short sLanType;
  public short sResSubType;
  public String strPkgName = "";
  public long uiCurVer;
  public long uiResId;
  
  public GetResourceReqInfoV2() {}
  
  public GetResourceReqInfoV2(String paramString, long paramLong1, short paramShort1, short paramShort2, byte paramByte1, long paramLong2, byte paramByte2, byte paramByte3, int paramInt, byte paramByte4)
  {
    this.strPkgName = paramString;
    this.uiCurVer = paramLong1;
    this.sResSubType = paramShort1;
    this.sLanType = paramShort2;
    this.cState = paramByte1;
    this.uiResId = paramLong2;
    this.cStatus = paramByte2;
    this.cPush = paramByte3;
    this.iPluginType = paramInt;
    this.cDelFlag = paramByte4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.strPkgName = paramJceInputStream.readString(1, true);
    this.uiCurVer = paramJceInputStream.read(this.uiCurVer, 2, true);
    this.sResSubType = paramJceInputStream.read(this.sResSubType, 3, true);
    this.sLanType = paramJceInputStream.read(this.sLanType, 4, true);
    this.cState = paramJceInputStream.read(this.cState, 5, true);
    this.uiResId = paramJceInputStream.read(this.uiResId, 6, false);
    this.cStatus = paramJceInputStream.read(this.cStatus, 7, false);
    this.cPush = paramJceInputStream.read(this.cPush, 8, false);
    this.iPluginType = paramJceInputStream.read(this.iPluginType, 9, false);
    this.cDelFlag = paramJceInputStream.read(this.cDelFlag, 10, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.strPkgName, 1);
    paramJceOutputStream.write(this.uiCurVer, 2);
    paramJceOutputStream.write(this.sResSubType, 3);
    paramJceOutputStream.write(this.sLanType, 4);
    paramJceOutputStream.write(this.cState, 5);
    paramJceOutputStream.write(this.uiResId, 6);
    paramJceOutputStream.write(this.cStatus, 7);
    paramJceOutputStream.write(this.cPush, 8);
    paramJceOutputStream.write(this.iPluginType, 9);
    paramJceOutputStream.write(this.cDelFlag, 10);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     protocol.KQQConfig.GetResourceReqInfoV2
 * JD-Core Version:    0.7.0.1
 */