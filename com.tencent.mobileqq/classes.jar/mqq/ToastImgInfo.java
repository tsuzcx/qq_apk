package MQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ToastImgInfo
  extends JceStruct
{
  public int iOpen = 0;
  public int iShowTime = 0;
  public int iToastVer = 0;
  public String sShortText = "";
  public String sText = "";
  
  public ToastImgInfo() {}
  
  public ToastImgInfo(int paramInt1, int paramInt2, String paramString1, int paramInt3, String paramString2)
  {
    this.iOpen = paramInt1;
    this.iToastVer = paramInt2;
    this.sText = paramString1;
    this.iShowTime = paramInt3;
    this.sShortText = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iOpen = paramJceInputStream.read(this.iOpen, 0, false);
    this.iToastVer = paramJceInputStream.read(this.iToastVer, 1, false);
    this.sText = paramJceInputStream.readString(2, false);
    this.iShowTime = paramJceInputStream.read(this.iShowTime, 3, false);
    this.sShortText = paramJceInputStream.readString(4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iOpen, 0);
    paramJceOutputStream.write(this.iToastVer, 1);
    if (this.sText != null) {
      paramJceOutputStream.write(this.sText, 2);
    }
    paramJceOutputStream.write(this.iShowTime, 3);
    if (this.sShortText != null) {
      paramJceOutputStream.write(this.sShortText, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     MQQ.ToastImgInfo
 * JD-Core Version:    0.7.0.1
 */