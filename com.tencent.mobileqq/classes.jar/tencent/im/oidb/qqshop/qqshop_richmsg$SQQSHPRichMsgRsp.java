package tencent.im.oidb.qqshop;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class qqshop_richmsg$SQQSHPRichMsgRsp
  extends MessageMicro<SQQSHPRichMsgRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "rich_msgs", "ad_msgs" }, new Object[] { null, null }, SQQSHPRichMsgRsp.class);
  public final PBRepeatMessageField<qqshop_richmsg.SQQSHPFolderAdMsg> ad_msgs = PBField.initRepeatMessage(qqshop_richmsg.SQQSHPFolderAdMsg.class);
  public final PBRepeatMessageField<qqshop_richmsg.SQQSHPRichMsg> rich_msgs = PBField.initRepeatMessage(qqshop_richmsg.SQQSHPRichMsg.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.qqshop.qqshop_richmsg.SQQSHPRichMsgRsp
 * JD-Core Version:    0.7.0.1
 */