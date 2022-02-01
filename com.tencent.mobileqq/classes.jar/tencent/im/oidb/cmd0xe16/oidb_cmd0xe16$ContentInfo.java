package tencent.im.oidb.cmd0xe16;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xe16$ContentInfo
  extends MessageMicro<ContentInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField str_article_id = PBField.initString("");
  public final PBStringField str_feeds_id = PBField.initString("");
  public final PBStringField str_rowkey = PBField.initString("");
  public final PBUInt32Field uint32_feeds_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_src = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 40 }, new String[] { "str_rowkey", "uint32_src", "str_article_id", "str_feeds_id", "uint32_feeds_type" }, new Object[] { "", localInteger, "", "", localInteger }, ContentInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe16.oidb_cmd0xe16.ContentInfo
 * JD-Core Version:    0.7.0.1
 */