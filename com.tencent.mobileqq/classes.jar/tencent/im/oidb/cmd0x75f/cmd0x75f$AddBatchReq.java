package tencent.im.oidb.cmd0x75f;

import QTimedMessage.QTimedMessage.Message;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class cmd0x75f$AddBatchReq
  extends MessageMicro<AddBatchReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_messages" }, new Object[] { null }, AddBatchReq.class);
  public final PBRepeatMessageField<QTimedMessage.Message> rpt_messages = PBField.initRepeatMessage(QTimedMessage.Message.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x75f.cmd0x75f.AddBatchReq
 * JD-Core Version:    0.7.0.1
 */