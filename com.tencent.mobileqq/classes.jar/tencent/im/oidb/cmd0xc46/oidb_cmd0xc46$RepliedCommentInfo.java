package tencent.im.oidb.cmd0xc46;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xc46$RepliedCommentInfo
  extends MessageMicro<RepliedCommentInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 42, 50 }, new String[] { "replied_comment_id", "replied_comment_content", "replied_comment_is_delete", "replied_user_id", "replied_user_nick_name", "replied_user_homepage" }, new Object[] { "", "", Integer.valueOf(0), "", "", "" }, RepliedCommentInfo.class);
  public final PBStringField replied_comment_content = PBField.initString("");
  public final PBStringField replied_comment_id = PBField.initString("");
  public final PBUInt32Field replied_comment_is_delete = PBField.initUInt32(0);
  public final PBStringField replied_user_homepage = PBField.initString("");
  public final PBStringField replied_user_id = PBField.initString("");
  public final PBStringField replied_user_nick_name = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xc46.oidb_cmd0xc46.RepliedCommentInfo
 * JD-Core Version:    0.7.0.1
 */