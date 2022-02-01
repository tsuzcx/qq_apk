package tencent.im.oidb.oidb_0xefd;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xefd$SubCommentDeleteReq
  extends MessageMicro<SubCommentDeleteReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40, 48, 56, 66 }, new String[] { "article_id", "first_comment_id", "sub_comment_id", "author_id", "content_src", "src", "shared_uin", "business_info" }, new Object[] { "", "", "", Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "" }, SubCommentDeleteReq.class);
  public final PBStringField article_id = PBField.initString("");
  public final PBUInt64Field author_id = PBField.initUInt64(0L);
  public final PBStringField business_info = PBField.initString("");
  public final PBUInt32Field content_src = PBField.initUInt32(0);
  public final PBStringField first_comment_id = PBField.initString("");
  public final PBUInt32Field shared_uin = PBField.initUInt32(0);
  public final PBUInt32Field src = PBField.initUInt32(0);
  public final PBStringField sub_comment_id = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xefd.oidb_0xefd.SubCommentDeleteReq
 * JD-Core Version:    0.7.0.1
 */