package tencent.im.oidb.oidb_0xd1e;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xd1e$AuthorCommentDeleteReq
  extends MessageMicro<AuthorCommentDeleteReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField article_id = PBField.initString("");
  public final PBStringField business_info = PBField.initString("");
  public final PBUInt32Field comment_type = PBField.initUInt32(0);
  public final PBUInt32Field content_src = PBField.initUInt32(0);
  public final PBStringField first_comment_id = PBField.initString("");
  public final PBUInt32Field src = PBField.initUInt32(0);
  public final PBStringField sub_comment_id = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40, 48, 58 }, new String[] { "article_id", "first_comment_id", "sub_comment_id", "comment_type", "content_src", "src", "business_info" }, new Object[] { "", "", "", localInteger, localInteger, localInteger, "" }, AuthorCommentDeleteReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xd1e.oidb_0xd1e.AuthorCommentDeleteReq
 * JD-Core Version:    0.7.0.1
 */