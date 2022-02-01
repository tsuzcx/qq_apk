package MQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class PopupImgInfo
  extends JceStruct
{
  public int iOpen = 0;
  public int iPopupVer = 0;
  public int iRate = 0;
  public int iRateType = 0;
  public String sContinueText = "";
  public String sPopupImgUrl = "";
  public String sPopupText = "";
  public String sRedirectText = "";
  
  public PopupImgInfo() {}
  
  public PopupImgInfo(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt4)
  {
    this.iOpen = paramInt1;
    this.iRate = paramInt2;
    this.iPopupVer = paramInt3;
    this.sPopupText = paramString1;
    this.sRedirectText = paramString2;
    this.sContinueText = paramString3;
    this.sPopupImgUrl = paramString4;
    this.iRateType = paramInt4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iOpen = paramJceInputStream.read(this.iOpen, 0, false);
    this.iRate = paramJceInputStream.read(this.iRate, 1, false);
    this.iPopupVer = paramJceInputStream.read(this.iPopupVer, 2, false);
    this.sPopupText = paramJceInputStream.readString(3, false);
    this.sRedirectText = paramJceInputStream.readString(4, false);
    this.sContinueText = paramJceInputStream.readString(5, false);
    this.sPopupImgUrl = paramJceInputStream.readString(6, false);
    this.iRateType = paramJceInputStream.read(this.iRateType, 7, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iOpen, 0);
    paramJceOutputStream.write(this.iRate, 1);
    paramJceOutputStream.write(this.iPopupVer, 2);
    if (this.sPopupText != null) {
      paramJceOutputStream.write(this.sPopupText, 3);
    }
    if (this.sRedirectText != null) {
      paramJceOutputStream.write(this.sRedirectText, 4);
    }
    if (this.sContinueText != null) {
      paramJceOutputStream.write(this.sContinueText, 5);
    }
    if (this.sPopupImgUrl != null) {
      paramJceOutputStream.write(this.sPopupImgUrl, 6);
    }
    paramJceOutputStream.write(this.iRateType, 7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     MQQ.PopupImgInfo
 * JD-Core Version:    0.7.0.1
 */