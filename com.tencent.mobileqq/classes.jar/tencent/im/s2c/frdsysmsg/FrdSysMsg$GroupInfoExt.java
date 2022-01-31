package tencent.im.s2c.frdsysmsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class FrdSysMsg$GroupInfoExt
  extends MessageMicro<GroupInfoExt>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint32_notify_type", "uint64_group_code", "uint32_from_groupadmlist" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0) }, GroupInfoExt.class);
  public final PBUInt32Field uint32_from_groupadmlist = PBField.initUInt32(0);
  public final PBUInt32Field uint32_notify_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.s2c.frdsysmsg.FrdSysMsg.GroupInfoExt
 * JD-Core Version:    0.7.0.1
 */