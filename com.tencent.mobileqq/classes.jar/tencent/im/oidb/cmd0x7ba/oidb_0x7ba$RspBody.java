package tencent.im.oidb.cmd0x7ba;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x7ba$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatMessageField<oidb_0x7ba.PraiseInfo> rpt_info = PBField.initRepeatMessage(oidb_0x7ba.PraiseInfo.class);
  public final PBUInt32Field uint32_complete = PBField.initUInt32(0);
  public final PBUInt32Field uint32_next_index = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 82, 88, 96 }, new String[] { "rpt_info", "uint32_next_index", "uint32_complete" }, new Object[] { null, localInteger, localInteger }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x7ba.oidb_0x7ba.RspBody
 * JD-Core Version:    0.7.0.1
 */