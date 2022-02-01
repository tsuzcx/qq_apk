package tencent.im.group_pro_proto.msg_box;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class MsgBox$AddReq
  extends MessageMicro<AddReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "uin_events" }, new Object[] { null }, AddReq.class);
  public final PBRepeatMessageField<MsgBox.UinEvent> uin_events = PBField.initRepeatMessage(MsgBox.UinEvent.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.group_pro_proto.msg_box.MsgBox.AddReq
 * JD-Core Version:    0.7.0.1
 */