package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x7cd$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatMessageField<cmd0x7cd.AppointBrife> rpt_msg_appoints_info = PBField.initRepeatMessage(cmd0x7cd.AppointBrife.class);
  public final PBUInt32Field uint32_next = PBField.initUInt32(0);
  public final PBUInt32Field uint32_over = PBField.initUInt32(0);
  public final PBUInt32Field uint32_stamp = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "uint32_stamp", "uint32_over", "uint32_next", "rpt_msg_appoints_info" }, new Object[] { localInteger, localInteger, localInteger, null }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x7cd.RspBody
 * JD-Core Version:    0.7.0.1
 */