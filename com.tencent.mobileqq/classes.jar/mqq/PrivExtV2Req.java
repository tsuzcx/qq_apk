package MQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class PrivExtV2Req
  extends JceStruct
{
  static Map<String, String> cache_extendInfo = new HashMap();
  public int clientLangugeId = 0;
  public Map<String, String> extendInfo = null;
  public int iGetType = 0;
  public long iItemCfgVer = 0L;
  public int iPopupVer = 0;
  public int iToastVer = 0;
  public int iWkOrderState1 = 0;
  public int iWkOrderState2 = 0;
  public long lastVisitTime = 0L;
  public long pullPayRuleCfgTime = 0L;
  public String qua = "";
  public String sImsi1 = "";
  public String sImsi2 = "";
  public String sKey = "";
  public String sUin = "";
  public String trace_info = "";
  
  static
  {
    cache_extendInfo.put("", "");
  }
  
  public PrivExtV2Req() {}
  
  public PrivExtV2Req(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong1, long paramLong2, long paramLong3, int paramInt6, Map<String, String> paramMap, String paramString5, String paramString6)
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
    this.lastVisitTime = paramLong1;
    this.iItemCfgVer = paramLong2;
    this.pullPayRuleCfgTime = paramLong3;
    this.clientLangugeId = paramInt6;
    this.extendInfo = paramMap;
    this.qua = paramString5;
    this.trace_info = paramString6;
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
    this.lastVisitTime = paramJceInputStream.read(this.lastVisitTime, 9, false);
    this.iItemCfgVer = paramJceInputStream.read(this.iItemCfgVer, 10, false);
    this.pullPayRuleCfgTime = paramJceInputStream.read(this.pullPayRuleCfgTime, 11, false);
    this.clientLangugeId = paramJceInputStream.read(this.clientLangugeId, 12, false);
    this.extendInfo = ((Map)paramJceInputStream.read(cache_extendInfo, 13, false));
    this.qua = paramJceInputStream.readString(14, false);
    this.trace_info = paramJceInputStream.readString(15, false);
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
    paramJceOutputStream.write(this.lastVisitTime, 9);
    paramJceOutputStream.write(this.iItemCfgVer, 10);
    paramJceOutputStream.write(this.pullPayRuleCfgTime, 11);
    paramJceOutputStream.write(this.clientLangugeId, 12);
    if (this.extendInfo != null) {
      paramJceOutputStream.write(this.extendInfo, 13);
    }
    if (this.qua != null) {
      paramJceOutputStream.write(this.qua, 14);
    }
    if (this.trace_info != null) {
      paramJceOutputStream.write(this.trace_info, 15);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     MQQ.PrivExtV2Req
 * JD-Core Version:    0.7.0.1
 */