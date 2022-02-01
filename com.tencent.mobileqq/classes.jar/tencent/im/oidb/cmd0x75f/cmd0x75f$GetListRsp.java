package tencent.im.oidb.cmd0x75f;

import QTimedMessage.QTimedMessage.Message;
import QTimedMessage.QTimedMessage.User;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x75f$GetListRsp
  extends MessageMicro<GetListRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34 }, new String[] { "msg_owner", "uint64_start_time", "uint64_end_time", "rpt_messages" }, new Object[] { null, Long.valueOf(0L), Long.valueOf(0L), null }, GetListRsp.class);
  public QTimedMessage.User msg_owner = new QTimedMessage.User();
  public final PBRepeatMessageField<QTimedMessage.Message> rpt_messages = PBField.initRepeatMessage(QTimedMessage.Message.class);
  public final PBUInt64Field uint64_end_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_start_time = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x75f.cmd0x75f.GetListRsp
 * JD-Core Version:    0.7.0.1
 */