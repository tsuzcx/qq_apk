package tencent.im.s2c.msgtype0x210.submsgtype0x6f;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SubMsgType0x6f$AddQimFriendNotifyToQQ
  extends MessageMicro<AddQimFriendNotifyToQQ>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_longnick = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_smart_remark = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_src_wording = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_wording = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_gender = PBField.initUInt32(0);
  public final PBUInt32Field uint32_op_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_cares_count = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_fans_count = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_storys_total_num = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 48, 56, 64, 74, 82 }, new String[] { "uint32_op_type", "uint64_uin", "uint32_gender", "bytes_smart_remark", "bytes_longnick", "uint64_storys_total_num", "uint64_cares_count", "uint64_fans_count", "bytes_wording", "bytes_src_wording" }, new Object[] { localInteger, localLong, localInteger, localByteStringMicro1, localByteStringMicro2, localLong, localLong, localLong, localByteStringMicro3, localByteStringMicro4 }, AddQimFriendNotifyToQQ.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f.AddQimFriendNotifyToQQ
 * JD-Core Version:    0.7.0.1
 */