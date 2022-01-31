package MQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class TrafficResultInfo
  extends JceStruct
{
  static PopupImgInfo cache_popInfo = new PopupImgInfo();
  static ToastImgInfo cache_toasInfo = new ToastImgInfo();
  public int iDrawerEnable;
  public int iGuideEnable;
  public int iImsiInterval;
  public int iWkOrderState1;
  public int iWkOrderState2;
  public PopupImgInfo popInfo;
  public String sDrawerText = "";
  public String sDrawerUrl = "";
  public String sGuideUrl = "";
  public ToastImgInfo toasInfo;
  
  public TrafficResultInfo() {}
  
  public TrafficResultInfo(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString1, String paramString2, String paramString3, int paramInt5, ToastImgInfo paramToastImgInfo, PopupImgInfo paramPopupImgInfo)
  {
    this.iWkOrderState1 = paramInt1;
    this.iWkOrderState2 = paramInt2;
    this.iDrawerEnable = paramInt3;
    this.iGuideEnable = paramInt4;
    this.sDrawerText = paramString1;
    this.sDrawerUrl = paramString2;
    this.sGuideUrl = paramString3;
    this.iImsiInterval = paramInt5;
    this.toasInfo = paramToastImgInfo;
    this.popInfo = paramPopupImgInfo;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iWkOrderState1 = paramJceInputStream.read(this.iWkOrderState1, 0, false);
    this.iWkOrderState2 = paramJceInputStream.read(this.iWkOrderState2, 1, false);
    this.iDrawerEnable = paramJceInputStream.read(this.iDrawerEnable, 2, false);
    this.iGuideEnable = paramJceInputStream.read(this.iGuideEnable, 3, false);
    this.sDrawerText = paramJceInputStream.readString(4, false);
    this.sDrawerUrl = paramJceInputStream.readString(5, false);
    this.sGuideUrl = paramJceInputStream.readString(6, false);
    this.iImsiInterval = paramJceInputStream.read(this.iImsiInterval, 7, false);
    this.toasInfo = ((ToastImgInfo)paramJceInputStream.read(cache_toasInfo, 8, false));
    this.popInfo = ((PopupImgInfo)paramJceInputStream.read(cache_popInfo, 9, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iWkOrderState1, 0);
    paramJceOutputStream.write(this.iWkOrderState2, 1);
    paramJceOutputStream.write(this.iDrawerEnable, 2);
    paramJceOutputStream.write(this.iGuideEnable, 3);
    if (this.sDrawerText != null) {
      paramJceOutputStream.write(this.sDrawerText, 4);
    }
    if (this.sDrawerUrl != null) {
      paramJceOutputStream.write(this.sDrawerUrl, 5);
    }
    if (this.sGuideUrl != null) {
      paramJceOutputStream.write(this.sGuideUrl, 6);
    }
    paramJceOutputStream.write(this.iImsiInterval, 7);
    if (this.toasInfo != null) {
      paramJceOutputStream.write(this.toasInfo, 8);
    }
    if (this.popInfo != null) {
      paramJceOutputStream.write(this.popInfo, 9);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\acom2.jar
 * Qualified Name:     MQQ.TrafficResultInfo
 * JD-Core Version:    0.7.0.1
 */