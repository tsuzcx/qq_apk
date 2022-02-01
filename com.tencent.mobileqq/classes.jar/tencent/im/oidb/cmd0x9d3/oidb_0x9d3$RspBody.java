package tencent.im.oidb.cmd0x9d3;

import appoint.define.appoint_define.FeedComment;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x9d3$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatMessageField<appoint_define.FeedComment> rpt_msg_comment = PBField.initRepeatMessage(appoint_define.FeedComment.class);
  public final PBStringField str_error_tips = PBField.initString("");
  public final PBUInt32Field uint32_fetch_new_over = PBField.initUInt32(0);
  public final PBUInt32Field uint32_fetch_old_over = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32 }, new String[] { "rpt_msg_comment", "str_error_tips", "uint32_fetch_old_over", "uint32_fetch_new_over" }, new Object[] { null, "", localInteger, localInteger }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x9d3.oidb_0x9d3.RspBody
 * JD-Core Version:    0.7.0.1
 */