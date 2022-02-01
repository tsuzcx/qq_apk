package tencent.im.oidb.oidb_0xfa3;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xfa3$TerminalInfo
  extends MessageMicro<TerminalInfo>
{
  public static final int ANDROID = 2;
  public static final int H5 = 4;
  public static final int IOS = 3;
  public static final int PC = 0;
  public static final int QQ_MINI_PROGRAM = 6;
  public static final int UNKNOWN = 1;
  public static final int WX_MINI_PROGRAM = 5;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 802 }, new String[] { "id", "type", "ip", "ext" }, new Object[] { "", Integer.valueOf(0), "", null }, TerminalInfo.class);
  public final PBRepeatMessageField<oidb_0xfa3.KVInfo> ext = PBField.initRepeatMessage(oidb_0xfa3.KVInfo.class);
  public final PBStringField id = PBField.initString("");
  public final PBStringField ip = PBField.initString("");
  public final PBUInt32Field type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xfa3.oidb_0xfa3.TerminalInfo
 * JD-Core Version:    0.7.0.1
 */