package tencent.im.s2c.msgtype0x210.submsgtype0x97;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class submsgtype0x97$MsgBody
  extends MessageMicro<MsgBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "string_business_uin", "string_json_context" }, new Object[] { "", "" }, MsgBody.class);
  public final PBStringField string_business_uin = PBField.initString("");
  public final PBStringField string_json_context = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x97.submsgtype0x97.MsgBody
 * JD-Core Version:    0.7.0.1
 */