package tencent.im.s2c.msgtype0x211.submsgtype0xb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class C2CType0x211_SubC2CType0xb$MsgBody$RejectNotify
  extends MessageMicro
{
  public static final int ENUM_REJECT_REASON_FIELD_NUMBER = 1;
  public static final int REJECT_BY_REASON_1 = 201;
  public static final int REJECT_BY_REASON_2 = 202;
  public static final int REJECT_BY_REASON_3 = 203;
  public static final int STR_MSG_FIELD_NUMBER = 2;
  public static final int STR_RING_FILENAME_FIELD_NUMBER = 3;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "enum_reject_reason", "str_msg", "str_ring_filename" }, new Object[] { Integer.valueOf(201), "", "" }, RejectNotify.class);
  public final PBEnumField enum_reject_reason = PBField.initEnum(201);
  public final PBStringField str_msg = PBField.initString("");
  public final PBStringField str_ring_filename = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x211.submsgtype0xb.C2CType0x211_SubC2CType0xb.MsgBody.RejectNotify
 * JD-Core Version:    0.7.0.1
 */