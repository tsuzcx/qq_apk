package tencent.im.oidb.cmd0xdc8;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class oidb_cmd0xdc8$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40 }, new String[] { "str_rowkey", "str_first_comment_id", "str_sub_comment_id", "str_comment_id", "int32_flag" }, new Object[] { "", "", "", "", Integer.valueOf(0) }, ReqBody.class);
  public final PBInt32Field int32_flag = PBField.initInt32(0);
  public final PBStringField str_comment_id = PBField.initString("");
  public final PBStringField str_first_comment_id = PBField.initString("");
  public final PBStringField str_rowkey = PBField.initString("");
  public final PBStringField str_sub_comment_id = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xdc8.oidb_cmd0xdc8.ReqBody
 * JD-Core Version:    0.7.0.1
 */