package tencent.im.oidb.cmd0xe16;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xe16$KeyInfo
  extends MessageMicro<KeyInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34 }, new String[] { "str_comment_id", "uint64_feeds_id", "uint32_feeds_type", "str_sub_comment_id" }, new Object[] { "", Long.valueOf(0L), Integer.valueOf(0), "" }, KeyInfo.class);
  public final PBStringField str_comment_id = PBField.initString("");
  public final PBStringField str_sub_comment_id = PBField.initString("");
  public final PBUInt32Field uint32_feeds_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_feeds_id = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe16.oidb_cmd0xe16.KeyInfo
 * JD-Core Version:    0.7.0.1
 */