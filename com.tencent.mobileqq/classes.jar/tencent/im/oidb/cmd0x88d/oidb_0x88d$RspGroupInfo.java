package tencent.im.oidb.cmd0x88d;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x88d$RspGroupInfo
  extends MessageMicro<RspGroupInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint64_group_code", "uint32_result", "stgroupinfo" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), null }, RspGroupInfo.class);
  public oidb_0x88d.GroupInfo stgroupinfo = new oidb_0x88d.GroupInfo();
  public final PBUInt32Field uint32_result = PBField.initUInt32(0);
  public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x88d.oidb_0x88d.RspGroupInfo
 * JD-Core Version:    0.7.0.1
 */