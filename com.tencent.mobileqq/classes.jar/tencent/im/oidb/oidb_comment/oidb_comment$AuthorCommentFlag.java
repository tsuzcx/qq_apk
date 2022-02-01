package tencent.im.oidb.oidb_comment;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;

public final class oidb_comment$AuthorCommentFlag
  extends MessageMicro<AuthorCommentFlag>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "already_comment", "update_time" }, new Object[] { Boolean.valueOf(false), Long.valueOf(0L) }, AuthorCommentFlag.class);
  public final PBBoolField already_comment = PBField.initBool(false);
  public final PBInt64Field update_time = PBField.initInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.oidb_comment.oidb_comment.AuthorCommentFlag
 * JD-Core Version:    0.7.0.1
 */