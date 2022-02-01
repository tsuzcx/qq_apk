package tencent.im.oidb.cmd0x935;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x935$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_class_param = PBField.initBytes(ByteStringMicro.EMPTY);
  public oidb_0x935.GPS msg_gps = new oidb_0x935.GPS();
  public final PBRepeatMessageField<oidb_0x935.NotifyInfo> msg_notify_info = PBField.initRepeatMessage(oidb_0x935.NotifyInfo.class);
  public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_memo_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_new = PBField.initUInt32(0);
  public final PBUInt32Field uint32_max_pos_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_pos = PBField.initUInt32(0);
  public final PBUInt64Field uint64_black_gc = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_join_gc = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40, 50, 56, 64, 74, 80 }, new String[] { "uint32_appid", "uint32_pos", "msg_gps", "uint64_join_gc", "uint32_max_pos_count", "bytes_class_param", "uint64_black_gc", "uint32_is_new", "msg_notify_info", "uint32_group_memo_type" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null, Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro, Long.valueOf(0L), Integer.valueOf(0), null, Integer.valueOf(0) }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x935.oidb_0x935.ReqBody
 * JD-Core Version:    0.7.0.1
 */