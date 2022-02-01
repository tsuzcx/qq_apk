package tencent.im.oidb.cmd0x9d4;

import appoint.define.appoint_define.FeedComment;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x9d4$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34 }, new String[] { "str_feed_id", "msg_comment", "uint32_max_fetch_count", "str_last_comment_id" }, new Object[] { "", null, Integer.valueOf(0), "" }, ReqBody.class);
  public appoint_define.FeedComment msg_comment = new appoint_define.FeedComment();
  public final PBStringField str_feed_id = PBField.initString("");
  public final PBStringField str_last_comment_id = PBField.initString("");
  public final PBUInt32Field uint32_max_fetch_count = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x9d4.oidb_0x9d4.ReqBody
 * JD-Core Version:    0.7.0.1
 */