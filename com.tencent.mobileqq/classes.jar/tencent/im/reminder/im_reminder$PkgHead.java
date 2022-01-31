package tencent.im.reminder;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class im_reminder$PkgHead
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField auth_a2 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field auth_method = PBField.initUInt32(0);
  public final PBUInt32Field bussi_type = PBField.initUInt32(0);
  public final PBUInt32Field client_appid = PBField.initUInt32(0);
  public final PBStringField client_ip = PBField.initString("");
  public final PBUInt32Field client_port = PBField.initUInt32(0);
  public final PBStringField err = PBField.initString("");
  public final PBStringField password = PBField.initString("");
  public final PBUInt32Field result = PBField.initUInt32(0);
  public final PBUInt32Field seq = PBField.initUInt32(0);
  public final PBStringField sid = PBField.initString("");
  public final PBStringField skey = PBField.initString("");
  public final PBUInt64Field uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 40, 48, 56, 66, 74, 82, 90, 96, 104 }, new String[] { "seq", "password", "result", "err", "uin", "bussi_type", "auth_method", "sid", "client_ip", "skey", "auth_a2", "client_port", "client_appid" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), "", Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), "", "", "", localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0) }, PkgHead.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.reminder.im_reminder.PkgHead
 * JD-Core Version:    0.7.0.1
 */