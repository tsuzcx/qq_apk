package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class oidb_0xb6f$Identity
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "apiName", "appid", "appType" }, new Object[] { "", Integer.valueOf(0), Integer.valueOf(0) }, Identity.class);
  public final PBStringField apiName = PBField.initString("");
  public final PBInt32Field appType = PBField.initInt32(0);
  public final PBInt32Field appid = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xb6f.Identity
 * JD-Core Version:    0.7.0.1
 */