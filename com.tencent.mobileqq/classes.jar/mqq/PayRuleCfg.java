package MQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class PayRuleCfg
  extends JceStruct
{
  static ShowRule cache_rule = new ShowRule();
  public String advId = "";
  public String aid = "";
  public int clickHide;
  public int clubType;
  public int enable;
  public String iconJumpUrl = "";
  public String iconText = "";
  public String iconTextCol = "";
  public String iconUrl = "";
  public String iosAid = "";
  public int payHide;
  public ShowRule rule;
  public int update;
  public int userType;
  
  public PayRuleCfg() {}
  
  public PayRuleCfg(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, ShowRule paramShowRule, String paramString5, String paramString6, String paramString7, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.enable = paramInt1;
    this.aid = paramString1;
    this.iconText = paramString2;
    this.iconUrl = paramString3;
    this.iconJumpUrl = paramString4;
    this.rule = paramShowRule;
    this.advId = paramString5;
    this.iconTextCol = paramString6;
    this.iosAid = paramString7;
    this.update = paramInt2;
    this.userType = paramInt3;
    this.clubType = paramInt4;
    this.clickHide = paramInt5;
    this.payHide = paramInt6;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.enable = paramJceInputStream.read(this.enable, 0, false);
    this.aid = paramJceInputStream.readString(1, false);
    this.iconText = paramJceInputStream.readString(2, false);
    this.iconUrl = paramJceInputStream.readString(3, false);
    this.iconJumpUrl = paramJceInputStream.readString(4, false);
    this.rule = ((ShowRule)paramJceInputStream.read(cache_rule, 5, false));
    this.advId = paramJceInputStream.readString(6, false);
    this.iconTextCol = paramJceInputStream.readString(7, false);
    this.iosAid = paramJceInputStream.readString(8, false);
    this.update = paramJceInputStream.read(this.update, 9, false);
    this.userType = paramJceInputStream.read(this.userType, 10, false);
    this.clubType = paramJceInputStream.read(this.clubType, 11, false);
    this.clickHide = paramJceInputStream.read(this.clickHide, 12, false);
    this.payHide = paramJceInputStream.read(this.payHide, 13, false);
  }
  
  public String toString()
  {
    return "PayRuleCfg{enable=" + this.enable + ", aid='" + this.aid + '\'' + ", iconText='" + this.iconText + '\'' + ", iconUrl='" + this.iconUrl + '\'' + ", iconJumpUrl='" + this.iconJumpUrl + '\'' + ", rule=" + this.rule + ", advId='" + this.advId + '\'' + ", iconTextCol='" + this.iconTextCol + '\'' + ", iosAid='" + this.iosAid + '\'' + ", update=" + this.update + ", userType=" + this.userType + ", clubType=" + this.clubType + ", clickHide=" + this.clickHide + ", payHide=" + this.payHide + '}';
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.enable, 0);
    if (this.aid != null) {
      paramJceOutputStream.write(this.aid, 1);
    }
    if (this.iconText != null) {
      paramJceOutputStream.write(this.iconText, 2);
    }
    if (this.iconUrl != null) {
      paramJceOutputStream.write(this.iconUrl, 3);
    }
    if (this.iconJumpUrl != null) {
      paramJceOutputStream.write(this.iconJumpUrl, 4);
    }
    if (this.rule != null) {
      paramJceOutputStream.write(this.rule, 5);
    }
    if (this.advId != null) {
      paramJceOutputStream.write(this.advId, 6);
    }
    if (this.iconTextCol != null) {
      paramJceOutputStream.write(this.iconTextCol, 7);
    }
    if (this.iosAid != null) {
      paramJceOutputStream.write(this.iosAid, 8);
    }
    paramJceOutputStream.write(this.update, 9);
    paramJceOutputStream.write(this.userType, 10);
    paramJceOutputStream.write(this.clubType, 11);
    paramJceOutputStream.write(this.clickHide, 12);
    paramJceOutputStream.write(this.payHide, 13);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     MQQ.PayRuleCfg
 * JD-Core Version:    0.7.0.1
 */