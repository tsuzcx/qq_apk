package tencent.im.oidb.cmd0x8f9;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x8f9$ConcernUinInfo
  extends MessageMicro<ConcernUinInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint64_concern_uin", "uint32_confirm_time", "uint32_read_time" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, ConcernUinInfo.class);
  public final PBUInt32Field uint32_confirm_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_read_time = PBField.initUInt32(0);
  public final PBUInt64Field uint64_concern_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8f9.oidb_0x8f9.ConcernUinInfo
 * JD-Core Version:    0.7.0.1
 */