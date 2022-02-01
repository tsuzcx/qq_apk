package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xd55$CheckAppSignRsp
  extends MessageMicro<CheckAppSignRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 88 }, new String[] { "ios_app_token", "ios_universal_link", "optimize_switch" }, new Object[] { "", "", Integer.valueOf(0) }, CheckAppSignRsp.class);
  public final PBStringField ios_app_token = PBField.initString("");
  public final PBStringField ios_universal_link = PBField.initString("");
  public final PBUInt32Field optimize_switch = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xd55.CheckAppSignRsp
 * JD-Core Version:    0.7.0.1
 */