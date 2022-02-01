package tencent.im.oidb.cmd0xf8a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class oidb_cmd0xf8a$CommentInfo
  extends MessageMicro<CommentInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "first_comment_id", "sub_comment_id", "rowkey" }, new Object[] { "", "", "" }, CommentInfo.class);
  public final PBStringField first_comment_id = PBField.initString("");
  public final PBStringField rowkey = PBField.initString("");
  public final PBStringField sub_comment_id = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xf8a.oidb_cmd0xf8a.CommentInfo
 * JD-Core Version:    0.7.0.1
 */