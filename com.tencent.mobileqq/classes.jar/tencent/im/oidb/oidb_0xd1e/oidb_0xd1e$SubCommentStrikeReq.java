package tencent.im.oidb.oidb_0xd1e;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xd1e$SubCommentStrikeReq
  extends MessageMicro<SubCommentStrikeReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 48, 56 }, new String[] { "article_id", "first_comment_id", "sub_comment_id", "author_id", "src", "op" }, new Object[] { "", "", "", Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, SubCommentStrikeReq.class);
  public final PBStringField article_id = PBField.initString("");
  public final PBUInt64Field author_id = PBField.initUInt64(0L);
  public final PBStringField first_comment_id = PBField.initString("");
  public final PBUInt32Field op = PBField.initUInt32(0);
  public final PBUInt32Field src = PBField.initUInt32(0);
  public final PBStringField sub_comment_id = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xd1e.oidb_0xd1e.SubCommentStrikeReq
 * JD-Core Version:    0.7.0.1
 */