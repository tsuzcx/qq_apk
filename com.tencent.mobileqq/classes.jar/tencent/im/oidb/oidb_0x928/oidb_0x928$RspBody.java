package tencent.im.oidb.oidb_0x928;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x928$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "group_id", "notice_info_list" }, new Object[] { Long.valueOf(0L), null }, RspBody.class);
  public final PBUInt64Field group_id = PBField.initUInt64(0L);
  public final PBRepeatMessageField<oidb_0x928.NoticeInfo> notice_info_list = PBField.initRepeatMessage(oidb_0x928.NoticeInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.oidb_0x928.oidb_0x928.RspBody
 * JD-Core Version:    0.7.0.1
 */