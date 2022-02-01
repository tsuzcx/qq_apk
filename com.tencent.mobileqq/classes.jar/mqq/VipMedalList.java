package MQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class VipMedalList
  extends JceStruct
{
  static ArrayList<VipMedalInfo> cache_medalInfo = new ArrayList();
  public int bUpdate;
  public String jumpUrl = "";
  public String lvlJumpUrl = "";
  public ArrayList<VipMedalInfo> medalInfo;
  
  static
  {
    VipMedalInfo localVipMedalInfo = new VipMedalInfo();
    cache_medalInfo.add(localVipMedalInfo);
  }
  
  public VipMedalList() {}
  
  public VipMedalList(ArrayList<VipMedalInfo> paramArrayList, int paramInt, String paramString1, String paramString2)
  {
    this.medalInfo = paramArrayList;
    this.bUpdate = paramInt;
    this.jumpUrl = paramString1;
    this.lvlJumpUrl = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.medalInfo = ((ArrayList)paramJceInputStream.read(cache_medalInfo, 0, false));
    this.bUpdate = paramJceInputStream.read(this.bUpdate, 1, false);
    this.jumpUrl = paramJceInputStream.readString(2, false);
    this.lvlJumpUrl = paramJceInputStream.readString(3, false);
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     MQQ.VipMedalList
 * JD-Core Version:    0.7.0.1
 */