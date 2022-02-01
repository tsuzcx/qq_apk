package tencent.im.oidb.cmd0xe3e;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xe3e$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_cache_time_seconds", "rpt_group_list" }, new Object[] { Integer.valueOf(0), null }, RspBody.class);
  public final PBRepeatMessageField<oidb_0xe3e.GroupList> rpt_group_list = PBField.initRepeatMessage(oidb_0xe3e.GroupList.class);
  public final PBUInt32Field uint32_cache_time_seconds = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe3e.oidb_0xe3e.RspBody
 * JD-Core Version:    0.7.0.1
 */