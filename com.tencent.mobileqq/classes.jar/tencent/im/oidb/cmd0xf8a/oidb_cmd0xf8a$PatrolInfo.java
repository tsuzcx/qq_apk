package tencent.im.oidb.cmd0xf8a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xf8a$PatrolInfo
  extends MessageMicro<PatrolInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "patrol_uin", "patrol_source" }, new Object[] { "", Integer.valueOf(0) }, PatrolInfo.class);
  public final PBUInt32Field patrol_source = PBField.initUInt32(0);
  public final PBStringField patrol_uin = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xf8a.oidb_cmd0xf8a.PatrolInfo
 * JD-Core Version:    0.7.0.1
 */