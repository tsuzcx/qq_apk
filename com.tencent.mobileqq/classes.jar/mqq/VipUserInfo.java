package MQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class VipUserInfo
  extends JceStruct
{
  static ArrayList<Long> cache_vSendList = new ArrayList();
  public int bUpdate = 0;
  public int iCanUseRed = -1;
  public int iCheckFreq = -1;
  public int iGrowthSpeed = -1;
  public int iGrowthValue = -1;
  public int iOpenSVip = -1;
  public int iOpenVip = -1;
  public int iRedDisable = -1;
  public int iRedPackId = -1;
  public int iSendDisable = -1;
  public int iUpdateFreq = -1;
  public long iUpdateTime = -1L;
  public int iVipLevel = -1;
  public int iVipType = -1;
  public String sGrayTail = "";
  public String sRedPackRemard = "";
  public String sUri = "";
  public ArrayList<Long> vSendList = null;
  
  static
  {
    cache_vSendList.add(Long.valueOf(0L));
  }
  
  public VipUserInfo() {}
  
  public VipUserInfo(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong, int paramInt7, String paramString1, int paramInt8, int paramInt9, int paramInt10, int paramInt11, String paramString2, ArrayList<Long> paramArrayList, int paramInt12, String paramString3, int paramInt13)
  {
    this.iOpenVip = paramInt1;
    this.iOpenSVip = paramInt2;
    this.iVipLevel = paramInt3;
    this.iVipType = paramInt4;
    this.iGrowthValue = paramInt5;
    this.iGrowthSpeed = paramInt6;
    this.iUpdateTime = paramLong;
    this.iUpdateFreq = paramInt7;
    this.sUri = paramString1;
    this.iCanUseRed = paramInt8;
    this.iRedDisable = paramInt9;
    this.iSendDisable = paramInt10;
    this.iCheckFreq = paramInt11;
    this.sGrayTail = paramString2;
    this.vSendList = paramArrayList;
    this.iRedPackId = paramInt12;
    this.sRedPackRemard = paramString3;
    this.bUpdate = paramInt13;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iOpenVip = paramJceInputStream.read(this.iOpenVip, 1, true);
    this.iOpenSVip = paramJceInputStream.read(this.iOpenSVip, 2, true);
    this.iVipLevel = paramJceInputStream.read(this.iVipLevel, 3, true);
    this.iVipType = paramJceInputStream.read(this.iVipType, 4, true);
    this.iGrowthValue = paramJceInputStream.read(this.iGrowthValue, 5, true);
    this.iGrowthSpeed = paramJceInputStream.read(this.iGrowthSpeed, 6, true);
    this.iUpdateTime = paramJceInputStream.read(this.iUpdateTime, 7, false);
    this.iUpdateFreq = paramJceInputStream.read(this.iUpdateFreq, 8, false);
    this.sUri = paramJceInputStream.readString(9, false);
    this.iCanUseRed = paramJceInputStream.read(this.iCanUseRed, 10, false);
    this.iRedDisable = paramJceInputStream.read(this.iRedDisable, 11, false);
    this.iSendDisable = paramJceInputStream.read(this.iSendDisable, 12, false);
    this.iCheckFreq = paramJceInputStream.read(this.iCheckFreq, 13, false);
    this.sGrayTail = paramJceInputStream.readString(14, false);
    this.vSendList = ((ArrayList)paramJceInputStream.read(cache_vSendList, 15, false));
    this.iRedPackId = paramJceInputStream.read(this.iRedPackId, 16, false);
    this.sRedPackRemard = paramJceInputStream.readString(17, false);
    this.bUpdate = paramJceInputStream.read(this.bUpdate, 18, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iOpenVip, 1);
    paramJceOutputStream.write(this.iOpenSVip, 2);
    paramJceOutputStream.write(this.iVipLevel, 3);
    paramJceOutputStream.write(this.iVipType, 4);
    paramJceOutputStream.write(this.iGrowthValue, 5);
    paramJceOutputStream.write(this.iGrowthSpeed, 6);
    paramJceOutputStream.write(this.iUpdateTime, 7);
    paramJceOutputStream.write(this.iUpdateFreq, 8);
    if (this.sUri != null) {
      paramJceOutputStream.write(this.sUri, 9);
    }
    paramJceOutputStream.write(this.iCanUseRed, 10);
    paramJceOutputStream.write(this.iRedDisable, 11);
    paramJceOutputStream.write(this.iSendDisable, 12);
    paramJceOutputStream.write(this.iCheckFreq, 13);
    if (this.sGrayTail != null) {
      paramJceOutputStream.write(this.sGrayTail, 14);
    }
    if (this.vSendList != null) {
      paramJceOutputStream.write(this.vSendList, 15);
    }
    paramJceOutputStream.write(this.iRedPackId, 16);
    if (this.sRedPackRemard != null) {
      paramJceOutputStream.write(this.sRedPackRemard, 17);
    }
    paramJceOutputStream.write(this.bUpdate, 18);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     MQQ.VipUserInfo
 * JD-Core Version:    0.7.0.1
 */