package tencent.im.oidb.inner.cmdGroupAdGetAdInfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class GetTroopAioTopAD$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatMessageField<GetTroopAioTopAD.AdInfo> rpt_ad_info = PBField.initRepeatMessage(GetTroopAioTopAD.AdInfo.class);
  public final PBUInt32Field uint32_res = PBField.initUInt32(0);
  public final PBUInt32Field uint32_time_interval = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint32_res", "uint32_time_interval", "rpt_ad_info" }, new Object[] { localInteger, localInteger, null }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.inner.cmdGroupAdGetAdInfo.GetTroopAioTopAD.RspBody
 * JD-Core Version:    0.7.0.1
 */