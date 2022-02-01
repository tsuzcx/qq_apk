package qqcircle;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class QQCircleMsgPaelem$PubAcc_Trans
  extends MessageMicro<PubAcc_Trans>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField str_apn_info = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField str_long_msg_wording = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_apn_info_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_count_unread = PBField.initUInt32(0);
  public final PBUInt32Field uint32_ignore_pc_active = PBField.initUInt32(0);
  public final PBUInt32Field uint32_lock_display = PBField.initUInt32(0);
  public final PBUInt64Field uint64_bitmap = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 42, 48, 56 }, new String[] { "uint32_lock_display", "uint32_ignore_pc_active", "str_long_msg_wording", "uint64_bitmap", "str_apn_info", "uint32_apn_info_type", "uint32_count_unread" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, Long.valueOf(0L), localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0) }, PubAcc_Trans.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qqcircle.QQCircleMsgPaelem.PubAcc_Trans
 * JD-Core Version:    0.7.0.1
 */