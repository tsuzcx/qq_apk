package tencent.im.oidb.cmd0xe0a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0xe0a$App
  extends MessageMicro<App>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 48 }, new String[] { "appid", "name", "icon", "url", "disabled", "default_disabled" }, new Object[] { Long.valueOf(0L), "", "", "", Integer.valueOf(0), Integer.valueOf(0) }, App.class);
  public final PBUInt64Field appid = PBField.initUInt64(0L);
  public final PBUInt32Field default_disabled = PBField.initUInt32(0);
  public final PBUInt32Field disabled = PBField.initUInt32(0);
  public final PBStringField icon = PBField.initString("");
  public final PBStringField name = PBField.initString("");
  public final PBStringField url = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe0a.cmd0xe0a.App
 * JD-Core Version:    0.7.0.1
 */