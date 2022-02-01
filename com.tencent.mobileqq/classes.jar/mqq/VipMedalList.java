package MQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class VipMedalList
  extends JceStruct
{
  static ArrayList<VipMedalInfo> cache_medalInfo = new ArrayList();
  public int bUpdate = 0;
  public String jumpUrl = "";
  public int lhLogoLv = -1;
  public int lhNumFlag = 0;
  public String lvlJumpUrl = "";
  public ArrayList<VipMedalInfo> medalInfo = null;
  
  static
  {
    VipMedalInfo localVipMedalInfo = new VipMedalInfo();
    cache_medalInfo.add(localVipMedalInfo);
  }
  
  public VipMedalList() {}
  
  public VipMedalList(ArrayList<VipMedalInfo> paramArrayList, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3)
  {
    this.medalInfo = paramArrayList;
    this.bUpdate = paramInt1;
    this.jumpUrl = paramString1;
    this.lvlJumpUrl = paramString2;
    this.lhNumFlag = paramInt2;
    this.lhLogoLv = paramInt3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.medalInfo = ((ArrayList)paramJceInputStream.read(cache_medalInfo, 0, false));
    this.bUpdate = paramJceInputStream.read(this.bUpdate, 1, false);
    this.jumpUrl = paramJceInputStream.readString(2, false);
    this.lvlJumpUrl = paramJceInputStream.readString(3, false);
    this.lhNumFlag = paramJceInputStream.read(this.lhNumFlag, 4, false);
    this.lhLogoLv = paramJceInputStream.read(this.lhLogoLv, 5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.medalInfo != null) {
      paramJceOutputStream.write(this.medalInfo, 0);
    }
    paramJceOutputStream.write(this.bUpdate, 1);
    if (this.jumpUrl != null) {
      paramJceOutputStream.write(this.jumpUrl, 2);
    }
    if (this.lvlJumpUrl != null) {
      paramJceOutputStream.write(this.lvlJumpUrl, 3);
    }
    paramJceOutputStream.write(this.lhNumFlag, 4);
    paramJceOutputStream.write(this.lhLogoLv, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     MQQ.VipMedalList
 * JD-Core Version:    0.7.0.1
 */