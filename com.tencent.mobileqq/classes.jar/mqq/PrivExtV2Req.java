package MQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class PrivExtV2Req
  extends JceStruct
{
  public int iGetType;
  public int iPopupVer;
  public int iToastVer;
  public int iWkOrderState1;
  public int iWkOrderState2;
  public String sImsi1 = "";
  public String sImsi2 = "";
  public String sKey = "";
  public String sUin = "";
  
  public PrivExtV2Req() {}
  
  public PrivExtV2Req(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.sUin = paramString1;
    this.sKey = paramString2;
    this.iGetType = paramInt1;
    this.sImsi1 = paramString3;
    this.sImsi2 = paramString4;
    this.iPopupVer = paramInt2;
    this.iToastVer = paramInt3;
    this.iWkOrderState1 = paramInt4;
    this.iWkOrderState2 = paramInt5;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.sUin = paramJceInputStream.readString(0, true);
    this.sKey = paramJceInputStream.readString(1, true);
    this.iGetType = paramJceInputStream.read(this.iGetType, 2, false);
    this.sImsi1 = paramJceInputStream.readString(3, false);
    this.sImsi2 = paramJceInputStream.readString(4, false);
    this.iPopupVer = paramJceInputStream.read(this.iPopupVer, 5, false);
    this.iToastVer = paramJceInputStream.read(this.iToastVer, 6, false);
    this.iWkOrderState1 = paramJceInputStream.read(this.iWkOrderState1, 7, false);
    this.iWkOrderState2 = paramJceInputStream.read(this.iWkOrderState2, 8, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.sUin, 0);
    paramJceOutputStream.write(this.sKey, 1);
    paramJceOutputStream.write(this.iGetType, 2);
    if (this.sImsi1 != null) {
      paramJceOutputStream.write(this.sImsi1, 3);
    }
    if (this.sImsi2 != null) {
      paramJceOutputStream.write(this.sImsi2, 4);
    }
    paramJceOutputStream.write(this.iPopupVer, 5);
    paramJceOutputStream.write(this.iToastVer, 6);
    paramJceOutputStream.write(this.iWkOrderState1, 7);
    paramJceOutputStream.write(this.iWkOrderState2, 8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     MQQ.PrivExtV2Req
 * JD-Core Version:    0.7.0.1
 */