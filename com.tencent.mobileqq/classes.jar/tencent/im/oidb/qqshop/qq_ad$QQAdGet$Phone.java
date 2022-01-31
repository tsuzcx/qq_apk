package tencent.im.oidb.qqshop;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qq_ad$QQAdGet$Phone
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 42, 48 }, new String[] { "muid", "conn", "carrier", "os_ver", "qq_ver", "os_type" }, new Object[] { "", Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(0) }, Phone.class);
  public final PBUInt32Field carrier = PBField.initUInt32(0);
  public final PBUInt32Field conn = PBField.initUInt32(0);
  public final PBStringField muid = PBField.initString("");
  public final PBUInt32Field os_type = PBField.initUInt32(0);
  public final PBStringField os_ver = PBField.initString("");
  public final PBStringField qq_ver = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.qqshop.qq_ad.QQAdGet.Phone
 * JD-Core Version:    0.7.0.1
 */