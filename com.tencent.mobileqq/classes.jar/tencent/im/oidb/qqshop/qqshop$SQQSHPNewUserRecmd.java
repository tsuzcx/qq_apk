package tencent.im.oidb.qqshop;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class qqshop$SQQSHPNewUserRecmd
  extends MessageMicro<SQQSHPNewUserRecmd>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "recmdflag", "recmdurl" }, new Object[] { Integer.valueOf(0), "" }, SQQSHPNewUserRecmd.class);
  public final PBInt32Field recmdflag = PBField.initInt32(0);
  public final PBStringField recmdurl = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.qqshop.qqshop.SQQSHPNewUserRecmd
 * JD-Core Version:    0.7.0.1
 */