package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x6ce$ReadRedpointReq
  extends MessageMicro<ReadRedpointReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint32_taskid", "uint64_read_seq", "uint32_appid" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0) }, ReadRedpointReq.class);
  public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_taskid = PBField.initUInt32(0);
  public final PBUInt64Field uint64_read_seq = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x6ce.ReadRedpointReq
 * JD-Core Version:    0.7.0.1
 */