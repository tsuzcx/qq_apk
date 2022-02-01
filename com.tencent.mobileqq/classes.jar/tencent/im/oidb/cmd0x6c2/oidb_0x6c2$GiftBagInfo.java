package tencent.im.oidb.cmd0x6c2;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x6c2$GiftBagInfo
  extends MessageMicro<GiftBagInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_ext = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_gift_bagid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_gift_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_gift_unit = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field int32_amount = PBField.initInt32(0);
  public final PBInt32Field int32_count = PBField.initInt32(0);
  public final PBInt32Field int32_end = PBField.initInt32(0);
  public final PBInt32Field int32_remain_amount = PBField.initInt32(0);
  public final PBInt32Field int32_remain_count = PBField.initInt32(0);
  public final PBInt32Field int32_winner = PBField.initInt32(0);
  public final PBRepeatMessageField<oidb_0x6c2.Player> msg_paly = PBField.initRepeatMessage(oidb_0x6c2.Player.class);
  public final PBUInt64Field uint64_done_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_end_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_gift_owner = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_group_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_start_time = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40, 50, 56, 64, 72, 80, 88, 96, 104, 114, 122, 80002 }, new String[] { "bytes_gift_bagid", "int32_count", "int32_amount", "uint64_start_time", "uint64_end_time", "msg_paly", "int32_end", "int32_remain_count", "int32_remain_amount", "int32_winner", "uint64_gift_owner", "uint64_group_id", "uint64_done_time", "bytes_gift_name", "bytes_gift_unit", "bytes_ext" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro2, localByteStringMicro3, localByteStringMicro4 }, GiftBagInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0x6c2.oidb_0x6c2.GiftBagInfo
 * JD-Core Version:    0.7.0.1
 */