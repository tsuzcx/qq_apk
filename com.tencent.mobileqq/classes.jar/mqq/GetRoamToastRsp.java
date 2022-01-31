package MQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GetRoamToastRsp
  extends JceStruct
{
  public String sToast = "";
  public String sToastKey = "";
  public String sUrl = "";
  
  public GetRoamToastRsp() {}
  
  public GetRoamToastRsp(String paramString1, String paramString2, String paramString3)
  {
    this.sToast = paramString1;
    this.sToastKey = paramString2;
    this.sUrl = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.sToast = paramJceInputStream.readString(0, false);
    this.sToastKey = paramJceInputStream.readString(1, false);
    this.sUrl = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.sToast != null) {
      paramJceOutputStream.write(this.sToast, 0);
    }
    if (this.sToastKey != null) {
      paramJceOutputStream.write(this.sToastKey, 1);
    }
    if (this.sUrl != null) {
      paramJceOutputStream.write(this.sUrl, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     MQQ.GetRoamToastRsp
 * JD-Core Version:    0.7.0.1
 */