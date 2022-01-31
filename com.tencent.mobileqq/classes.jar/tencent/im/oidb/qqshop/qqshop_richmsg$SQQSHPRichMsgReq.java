package tencent.im.oidb.qqshop;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class qqshop_richmsg$SQQSHPRichMsgReq
  extends MessageMicro<SQQSHPRichMsgReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rich_msgs" }, new Object[] { null }, SQQSHPRichMsgReq.class);
  public final PBRepeatMessageField<qqshop_richmsg.SQQSHPRichMsg> rich_msgs = PBField.initRepeatMessage(qqshop_richmsg.SQQSHPRichMsg.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.qqshop.qqshop_richmsg.SQQSHPRichMsgReq
 * JD-Core Version:    0.7.0.1
 */