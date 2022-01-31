package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xdea$DeleteBarrageReqBody
  extends MessageMicro<DeleteBarrageReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "uint64_group_code", "uint32_group_seq", "uint64_delete_uin", "uint64_send_uin", "uint32_barrage_flag" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0) }, DeleteBarrageReqBody.class);
  public final PBUInt32Field uint32_barrage_flag = PBField.initUInt32(0);
  public final PBUInt64Field uint32_group_seq = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_delete_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_send_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xdea.DeleteBarrageReqBody
 * JD-Core Version:    0.7.0.1
 */