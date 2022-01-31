package tencent.im.oidb.cmd0x95a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x95a$GetArActivityListReq
  extends MessageMicro<GetArActivityListReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 37 }, new String[] { "uint64_uin", "uint32_start_pos", "uint32_want_num", "fixed32_last_get_time" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, GetArActivityListReq.class);
  public final PBFixed32Field fixed32_last_get_time = PBField.initFixed32(0);
  public final PBUInt32Field uint32_start_pos = PBField.initUInt32(0);
  public final PBUInt32Field uint32_want_num = PBField.initUInt32(0);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0x95a.cmd0x95a.GetArActivityListReq
 * JD-Core Version:    0.7.0.1
 */