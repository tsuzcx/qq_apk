package tencent.im.oidb.cmd0x857;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class TroopTips0x857$GroupAsyncNotify
  extends MessageMicro<GroupAsyncNotify>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_msg_type", "uint64_msg_seq" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L) }, GroupAsyncNotify.class);
  public final PBUInt32Field uint32_msg_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_msg_seq = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x857.TroopTips0x857.GroupAsyncNotify
 * JD-Core Version:    0.7.0.1
 */