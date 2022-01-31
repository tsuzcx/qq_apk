package tencent.im.oidb.qqshop;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqshop$SQQSHPRecmdAccount
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "puin", "nick", "headurl", "desc" }, new Object[] { Long.valueOf(0L), "", "", "" }, SQQSHPRecmdAccount.class);
  public final PBStringField desc = PBField.initString("");
  public final PBStringField headurl = PBField.initString("");
  public final PBStringField nick = PBField.initString("");
  public final PBUInt64Field puin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.qqshop.qqshop.SQQSHPRecmdAccount
 * JD-Core Version:    0.7.0.1
 */