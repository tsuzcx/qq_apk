package tencent.im.oidb.cmd0xf16;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xf16$GroupRemarkInfoRsp
  extends MessageMicro<GroupRemarkInfoRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint64_group_code", "uint64_group_uin", "int32_result" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0) }, GroupRemarkInfoRsp.class);
  public final PBInt32Field int32_result = PBField.initInt32(0);
  public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_group_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xf16.oidb_0xf16.GroupRemarkInfoRsp
 * JD-Core Version:    0.7.0.1
 */