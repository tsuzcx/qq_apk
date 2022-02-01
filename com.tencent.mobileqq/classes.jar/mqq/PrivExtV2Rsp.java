package MQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class PrivExtV2Rsp
  extends JceStruct
{
  static DataReturnFlag cache_data_flag = new DataReturnFlag();
  static ItemCfgList cache_itemCfgList;
  static VipMedalList cache_medalInfoList;
  static PayRuleCfg cache_payRule;
  static QqLiveMsg cache_qqLiveMsg;
  static TrafficResultInfo cache_trafficResult;
  static VipUserInfo cache_vipInfo = new VipUserInfo();
  public DataReturnFlag data_flag;
  public int iSyncFreq = -1;
  public int isAuditVersion;
  public int isQQLivePgc;
  public ItemCfgList itemCfgList;
  public VipMedalList medalInfoList;
  public PayRuleCfg payRule;
  public QqLiveMsg qqLiveMsg;
  public TrafficResultInfo trafficResult;
  public VipUserInfo vipInfo;
  
  static
  {
    cache_trafficResult = new TrafficResultInfo();
    cache_medalInfoList = new VipMedalList();
    cache_itemCfgList = new ItemCfgList();
    cache_payRule = new PayRuleCfg();
    cache_qqLiveMsg = new QqLiveMsg();
  }
  
  public PrivExtV2Rsp() {}
  
  public PrivExtV2Rsp(VipUserInfo paramVipUserInfo, TrafficResultInfo paramTrafficResultInfo, int paramInt1, VipMedalList paramVipMedalList, ItemCfgList paramItemCfgList, PayRuleCfg paramPayRuleCfg, int paramInt2, QqLiveMsg paramQqLiveMsg, int paramInt3, DataReturnFlag paramDataReturnFlag)
  {
    this.vipInfo = paramVipUserInfo;
    this.trafficResult = paramTrafficResultInfo;
    this.iSyncFreq = paramInt1;
    this.medalInfoList = paramVipMedalList;
    this.itemCfgList = paramItemCfgList;
    this.payRule = paramPayRuleCfg;
    this.isQQLivePgc = paramInt2;
    this.qqLiveMsg = paramQqLiveMsg;
    this.isAuditVersion = paramInt3;
    this.data_flag = paramDataReturnFlag;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.vipInfo = ((VipUserInfo)paramJceInputStream.read(cache_vipInfo, 0, true));
    this.trafficResult = ((TrafficResultInfo)paramJceInputStream.read(cache_trafficResult, 1, false));
    this.iSyncFreq = paramJceInputStream.read(this.iSyncFreq, 2, false);
    this.medalInfoList = ((VipMedalList)paramJceInputStream.read(cache_medalInfoList, 3, false));
    this.itemCfgList = ((ItemCfgList)paramJceInputStream.read(cache_itemCfgList, 4, false));
    this.payRule = ((PayRuleCfg)paramJceInputStream.read(cache_payRule, 5, false));
    this.isQQLivePgc = paramJceInputStream.read(this.isQQLivePgc, 6, false);
    this.qqLiveMsg = ((QqLiveMsg)paramJceInputStream.read(cache_qqLiveMsg, 7, false));
    this.isAuditVersion = paramJceInputStream.read(this.isAuditVersion, 8, false);
    this.data_flag = ((DataReturnFlag)paramJceInputStream.read(cache_data_flag, 9, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.vipInfo, 0);
    if (this.trafficResult != null) {
      paramJceOutputStream.write(this.trafficResult, 1);
    }
    paramJceOutputStream.write(this.iSyncFreq, 2);
    if (this.medalInfoList != null) {
      paramJceOutputStream.write(this.medalInfoList, 3);
    }
    if (this.itemCfgList != null) {
      paramJceOutputStream.write(this.itemCfgList, 4);
    }
    if (this.payRule != null) {
      paramJceOutputStream.write(this.payRule, 5);
    }
    paramJceOutputStream.write(this.isQQLivePgc, 6);
    if (this.qqLiveMsg != null) {
      paramJceOutputStream.write(this.qqLiveMsg, 7);
    }
    paramJceOutputStream.write(this.isAuditVersion, 8);
    if (this.data_flag != null) {
      paramJceOutputStream.write(this.data_flag, 9);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     MQQ.PrivExtV2Rsp
 * JD-Core Version:    0.7.0.1
 */