package tencent.im.oidb.cmd0xece;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xece$App
  extends MessageMicro<App>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32 }, new String[] { "appid", "app_name", "url", "source" }, new Object[] { Long.valueOf(0L), "", "", Integer.valueOf(0) }, App.class);
  public final PBStringField app_name = PBField.initString("");
  public final PBUInt64Field appid = PBField.initUInt64(0L);
  public final PBUInt32Field source = PBField.initUInt32(0);
  public final PBStringField url = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0xece.oidb_0xece.App
 * JD-Core Version:    0.7.0.1
 */