package tencent.im.oidb.cmd0xef5;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xef5$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 42 }, new String[] { "first_comment_id", "sub_comment_id", "report_type", "rowkey", "report_reason" }, new Object[] { "", "", Integer.valueOf(0), "", "" }, ReqBody.class);
  public final PBStringField first_comment_id = PBField.initString("");
  public final PBStringField report_reason = PBField.initString("");
  public final PBUInt32Field report_type = PBField.initUInt32(0);
  public final PBStringField rowkey = PBField.initString("");
  public final PBStringField sub_comment_id = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xef5.oidb_cmd0xef5.ReqBody
 * JD-Core Version:    0.7.0.1
 */