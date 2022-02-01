package tencent.im.oidb.cmd0x857;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class TroopTips0x857$SingChangePushInfo
  extends MessageMicro<SingChangePushInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_gray_tips = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_action_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_join_nums = PBField.initUInt32(0);
  public final PBUInt64Field uint64_group_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_oper_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_seq = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 48 }, new String[] { "uint64_seq", "uint32_action_type", "uint64_group_id", "uint64_oper_uin", "bytes_gray_tips", "uint32_join_nums" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro, Integer.valueOf(0) }, SingChangePushInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x857.TroopTips0x857.SingChangePushInfo
 * JD-Core Version:    0.7.0.1
 */