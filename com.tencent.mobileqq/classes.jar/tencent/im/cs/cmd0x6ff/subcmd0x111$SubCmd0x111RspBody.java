package tencent.im.cs.cmd0x6ff;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class subcmd0x111$SubCmd0x111RspBody
  extends MessageMicro<SubCmd0x111RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_contentItem" }, new Object[] { null }, SubCmd0x111RspBody.class);
  public final PBRepeatMessageField<subcmd0x111.ContentItem> rpt_msg_contentItem = PBField.initRepeatMessage(subcmd0x111.ContentItem.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.cs.cmd0x6ff.subcmd0x111.SubCmd0x111RspBody
 * JD-Core Version:    0.7.0.1
 */