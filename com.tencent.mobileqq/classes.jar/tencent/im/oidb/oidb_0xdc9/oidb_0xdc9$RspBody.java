package tencent.im.oidb.oidb_0xdc9;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xdc9$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "honor_list", "cache_ts", "honor_info" }, new Object[] { null, Integer.valueOf(0), null }, RspBody.class);
  public final PBUInt32Field cache_ts = PBField.initUInt32(0);
  public final PBRepeatMessageField<oidb_0xdc9.HonorInfo> honor_info = PBField.initRepeatMessage(oidb_0xdc9.HonorInfo.class);
  public final PBRepeatMessageField<oidb_0xdc9.HonorList> honor_list = PBField.initRepeatMessage(oidb_0xdc9.HonorList.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xdc9.oidb_0xdc9.RspBody
 * JD-Core Version:    0.7.0.1
 */