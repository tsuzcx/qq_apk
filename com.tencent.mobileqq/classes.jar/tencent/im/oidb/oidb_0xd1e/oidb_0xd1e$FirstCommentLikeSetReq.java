package tencent.im.oidb.oidb_0xd1e;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xd1e$FirstCommentLikeSetReq
  extends MessageMicro<FirstCommentLikeSetReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField article_id = PBField.initString("");
  public final PBUInt64Field author_id = PBField.initUInt64(0L);
  public final PBStringField business_info = PBField.initString("");
  public final PBStringField comment_id = PBField.initString("");
  public final PBUInt32Field content_src = PBField.initUInt32(0);
  public final PBUInt32Field like = PBField.initUInt32(0);
  public final PBUInt32Field op_type = PBField.initUInt32(0);
  public final PBUInt32Field pin = PBField.initUInt32(0);
  public final PBUInt32Field src = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 48, 56, 64, 74 }, new String[] { "article_id", "comment_id", "author_id", "like", "op_type", "content_src", "pin", "src", "business_info" }, new Object[] { "", "", Long.valueOf(0L), localInteger, localInteger, localInteger, localInteger, localInteger, "" }, FirstCommentLikeSetReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xd1e.oidb_0xd1e.FirstCommentLikeSetReq
 * JD-Core Version:    0.7.0.1
 */