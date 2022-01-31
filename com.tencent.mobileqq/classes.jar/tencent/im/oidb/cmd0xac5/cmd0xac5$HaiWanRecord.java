package tencent.im.oidb.cmd0xac5;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0xac5$HaiWanRecord
  extends MessageMicro<HaiWanRecord>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48 }, new String[] { "uint64_uin", "uint64_uid", "uint64_roomid", "uint32_timestamp", "uint32_haiwan_type", "uint64_root_roomid" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L) }, HaiWanRecord.class);
  public final PBUInt32Field uint32_haiwan_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_timestamp = PBField.initUInt32(0);
  public final PBUInt64Field uint64_roomid = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_root_roomid = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uid = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xac5.cmd0xac5.HaiWanRecord
 * JD-Core Version:    0.7.0.1
 */