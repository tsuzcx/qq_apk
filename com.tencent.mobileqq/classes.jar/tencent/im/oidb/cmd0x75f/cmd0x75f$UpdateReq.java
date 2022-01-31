package tencent.im.oidb.cmd0x75f;

import QTimedMessage.QTimedMessage.Message;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class cmd0x75f$UpdateReq
  extends MessageMicro<UpdateReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_message" }, new Object[] { null }, UpdateReq.class);
  public QTimedMessage.Message msg_message = new QTimedMessage.Message();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x75f.cmd0x75f.UpdateReq
 * JD-Core Version:    0.7.0.1
 */