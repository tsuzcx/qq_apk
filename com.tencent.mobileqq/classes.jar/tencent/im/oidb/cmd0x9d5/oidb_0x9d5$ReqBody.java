package tencent.im.oidb.cmd0x9d5;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class oidb_0x9d5$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "str_feed_id", "str_comment_id" }, new Object[] { "", "" }, ReqBody.class);
  public final PBStringField str_comment_id = PBField.initString("");
  public final PBStringField str_feed_id = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x9d5.oidb_0x9d5.ReqBody
 * JD-Core Version:    0.7.0.1
 */