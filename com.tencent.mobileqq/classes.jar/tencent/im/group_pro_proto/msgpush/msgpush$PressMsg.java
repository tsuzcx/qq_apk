package tencent.im.group_pro_proto.msgpush;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import tencent.im.group_pro_proto.common.common.Msg;

public final class msgpush$PressMsg
  extends MessageMicro<PressMsg>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msgs" }, new Object[] { null }, PressMsg.class);
  public final PBRepeatMessageField<common.Msg> msgs = PBField.initRepeatMessage(common.Msg.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.group_pro_proto.msgpush.msgpush.PressMsg
 * JD-Core Version:    0.7.0.1
 */