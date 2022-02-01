package tencent.im.oidb.oidb_0xefd;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xefd$FirstCommentDeleteReq
  extends MessageMicro<FirstCommentDeleteReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField article_id = PBField.initString("");
  public final PBUInt64Field author_id = PBField.initUInt64(0L);
  public final PBStringField business_info = PBField.initString("");
  public final PBStringField comment_id = PBField.initString("");
  public final PBInt32Field content_src = PBField.initInt32(0);
  public final PBUInt32Field shared_uin = PBField.initUInt32(0);
  public final PBUInt32Field src = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 48, 58 }, new String[] { "article_id", "comment_id", "author_id", "content_src", "src", "shared_uin", "business_info" }, new Object[] { "", "", Long.valueOf(0L), localInteger, localInteger, localInteger, "" }, FirstCommentDeleteReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xefd.oidb_0xefd.FirstCommentDeleteReq
 * JD-Core Version:    0.7.0.1
 */