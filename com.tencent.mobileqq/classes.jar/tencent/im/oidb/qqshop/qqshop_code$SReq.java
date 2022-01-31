package tencent.im.oidb.qqshop;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qqshop_code$SReq
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "version", "appid", "redirect_uri" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "" }, SReq.class);
  public final PBUInt32Field appid = PBField.initUInt32(0);
  public final PBStringField redirect_uri = PBField.initString("");
  public final PBUInt32Field version = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.qqshop.qqshop_code.SReq
 * JD-Core Version:    0.7.0.1
 */