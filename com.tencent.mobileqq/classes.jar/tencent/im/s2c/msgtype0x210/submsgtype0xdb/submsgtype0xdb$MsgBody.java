package tencent.im.s2c.msgtype0x210.submsgtype0xdb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class submsgtype0xdb$MsgBody
  extends MessageMicro
{
  public static final int STRING_RSPBODY_FIELD_NUMBER = 2;
  public static final int UINT32_RSPTYPE_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_rsptype", "string_rspbody" }, new Object[] { Integer.valueOf(0), "" }, MsgBody.class);
  public final PBStringField string_rspbody = PBField.initString("");
  public final PBUInt32Field uint32_rsptype = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0xdb.submsgtype0xdb.MsgBody
 * JD-Core Version:    0.7.0.1
 */