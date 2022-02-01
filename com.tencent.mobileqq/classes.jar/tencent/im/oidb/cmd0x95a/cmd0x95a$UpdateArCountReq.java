package tencent.im.oidb.cmd0x95a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x95a$UpdateArCountReq
  extends MessageMicro<UpdateArCountReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "uint64_uin", "uint32_update_type", "uint32_count_type", "uint32_count_value" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, UpdateArCountReq.class);
  public final PBUInt32Field uint32_count_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_count_value = PBField.initUInt32(0);
  public final PBUInt32Field uint32_update_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0x95a.cmd0x95a.UpdateArCountReq
 * JD-Core Version:    0.7.0.1
 */