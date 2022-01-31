package MQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class PrivExtV2Rsp
  extends JceStruct
{
  static TrafficResultInfo cache_trafficResult = new TrafficResultInfo();
  static VipUserInfo cache_vipInfo = new VipUserInfo();
  public TrafficResultInfo trafficResult;
  public VipUserInfo vipInfo;
  
  public PrivExtV2Rsp() {}
  
  public PrivExtV2Rsp(VipUserInfo paramVipUserInfo, TrafficResultInfo paramTrafficResultInfo)
  {
    this.vipInfo = paramVipUserInfo;
    this.trafficResult = paramTrafficResultInfo;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.vipInfo = ((VipUserInfo)paramJceInputStream.read(cache_vipInfo, 0, true));
    this.trafficResult = ((TrafficResultInfo)paramJceInputStream.read(cache_trafficResult, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.vipInfo, 0);
    if (this.trafficResult != null) {
      paramJceOutputStream.write(this.trafficResult, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\acom2.jar
 * Qualified Name:     MQQ.PrivExtV2Rsp
 * JD-Core Version:    0.7.0.1
 */