package tencent.im.oidb.cmd0xef0;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xef0$RspDetail
  extends MessageMicro<RspDetail>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint64_group_code", "int32_result", "msg_group_info_ext" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), null }, RspDetail.class);
  public final PBInt32Field int32_result = PBField.initInt32(0);
  public oidb_0xef0.GroupInfoExt msg_group_info_ext = new oidb_0xef0.GroupInfoExt();
  public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0xef0.oidb_0xef0.RspDetail
 * JD-Core Version:    0.7.0.1
 */