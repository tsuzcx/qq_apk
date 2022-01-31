package tencent.im.oidb.cmd0x88d;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x88d$ReqGroupInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "uint64_group_code", "stgroupinfo", "uint32_last_get_group_name_time" }, new Object[] { Long.valueOf(0L), null, Integer.valueOf(0) }, ReqGroupInfo.class);
  public oidb_0x88d.GroupInfo stgroupinfo = new oidb_0x88d.GroupInfo();
  public final PBUInt32Field uint32_last_get_group_name_time = PBField.initUInt32(0);
  public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x88d.oidb_0x88d.ReqGroupInfo
 * JD-Core Version:    0.7.0.1
 */