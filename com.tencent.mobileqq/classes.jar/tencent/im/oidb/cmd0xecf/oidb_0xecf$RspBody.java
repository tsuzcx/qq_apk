package tencent.im.oidb.cmd0xecf;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xecf$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42 }, new String[] { "msg_quest", "strCommentCookie", "int32_comment_fetch_over", "uint64_comment_total", "str_head_nick" }, new Object[] { null, "", Integer.valueOf(0), Long.valueOf(0L), "" }, RspBody.class);
  public final PBInt32Field int32_comment_fetch_over = PBField.initInt32(0);
  public oidb_0xecf.Quest msg_quest = new oidb_0xecf.Quest();
  public final PBStringField strCommentCookie = PBField.initString("");
  public final PBStringField str_head_nick = PBField.initString("");
  public final PBUInt64Field uint64_comment_total = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xecf.oidb_0xecf.RspBody
 * JD-Core Version:    0.7.0.1
 */