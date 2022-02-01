package tencent.im.oidb.oidb_0xde8;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xde8$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "rpt_info", "uint32_is_over" }, new Object[] { null, Integer.valueOf(0) }, RspBody.class);
  public final PBRepeatMessageField<oidb_0xde8.NickInfo> rpt_info = PBField.initRepeatMessage(oidb_0xde8.NickInfo.class);
  public final PBUInt32Field uint32_is_over = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xde8.oidb_0xde8.RspBody
 * JD-Core Version:    0.7.0.1
 */