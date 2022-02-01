package tencent.im.oidb.olympic;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class OlympicTorchSvc$ReqGetBusinessTorch
  extends MessageMicro<ReqGetBusinessTorch>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public MqqLbs.LBSInfo msg_lbs_info = new MqqLbs.LBSInfo();
  public final PBRepeatField<Long> rpt_city_pic_id_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBUInt64Field uint64_torch_id = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "uint64_torch_id", "msg_lbs_info", "rpt_city_pic_id_list" }, new Object[] { localLong, null, localLong }, ReqGetBusinessTorch.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.olympic.OlympicTorchSvc.ReqGetBusinessTorch
 * JD-Core Version:    0.7.0.1
 */