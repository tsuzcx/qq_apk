package tencent.im.group_pro_proto.msgpush;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class servtype$SwitchVoiceChannel
  extends MessageMicro<SwitchVoiceChannel>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "member_id", "enter_detail", "leave_detail" }, new Object[] { Long.valueOf(0L), null, null }, SwitchVoiceChannel.class);
  public servtype.SwitchDetail enter_detail = new servtype.SwitchDetail();
  public servtype.SwitchDetail leave_detail = new servtype.SwitchDetail();
  public final PBUInt64Field member_id = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.group_pro_proto.msgpush.servtype.SwitchVoiceChannel
 * JD-Core Version:    0.7.0.1
 */