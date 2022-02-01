package tencent.im.oidb.cmd0xf24;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xf24$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 40, 48, 56, 66, 74, 80, 90, 98, 106 }, new String[] { "rowkey", "article_id", "title", "cover_image_url", "read_count", "publish_time", "puin", "account_avatar_url", "account_name", "over_length", "json_article_content", "json_extend_info", "tags" }, new Object[] { "", Long.valueOf(0L), "", "", Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), "", "", Boolean.valueOf(false), "", "", "" }, RspBody.class);
  public final PBStringField account_avatar_url = PBField.initString("");
  public final PBStringField account_name = PBField.initString("");
  public final PBUInt64Field article_id = PBField.initUInt64(0L);
  public final PBStringField cover_image_url = PBField.initString("");
  public final PBStringField json_article_content = PBField.initString("");
  public final PBStringField json_extend_info = PBField.initString("");
  public final PBBoolField over_length = PBField.initBool(false);
  public final PBInt64Field publish_time = PBField.initInt64(0L);
  public final PBUInt64Field puin = PBField.initUInt64(0L);
  public final PBUInt64Field read_count = PBField.initUInt64(0L);
  public final PBStringField rowkey = PBField.initString("");
  public final PBStringField tags = PBField.initString("");
  public final PBStringField title = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xf24.oidb_cmd0xf24.RspBody
 * JD-Core Version:    0.7.0.1
 */