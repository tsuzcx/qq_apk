package tencent.im.oidb.cmd0x75f;

import QTimedMessage.QTimedMessage.Message;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class cmd0x75f$AddRsp
  extends MessageMicro<AddRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_message" }, new Object[] { null }, AddRsp.class);
  public QTimedMessage.Message msg_message = new QTimedMessage.Message();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x75f.cmd0x75f.AddRsp
 * JD-Core Version:    0.7.0.1
 */