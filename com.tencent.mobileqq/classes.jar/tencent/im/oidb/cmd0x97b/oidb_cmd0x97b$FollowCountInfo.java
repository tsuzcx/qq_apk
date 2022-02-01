package tencent.im.oidb.cmd0x97b;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0x97b$FollowCountInfo
  extends MessageMicro<FollowCountInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_buluo_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<oidb_cmd0x97b.CountDetailInfo> rpt_fans_detail_info = PBField.initRepeatMessage(oidb_cmd0x97b.CountDetailInfo.class);
  public final PBUInt32Field uint32_buluo_fans_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_buluo_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_buluo_vip = PBField.initUInt32(0);
  public final PBUInt32Field uint32_my_fans_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_my_follow_count = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 48, 162 }, new String[] { "uint32_my_follow_count", "uint32_my_fans_count", "uint32_is_buluo_vip", "bytes_buluo_name", "uint32_buluo_id", "uint32_buluo_fans_count", "rpt_fans_detail_info" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), null }, FollowCountInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x97b.oidb_cmd0x97b.FollowCountInfo
 * JD-Core Version:    0.7.0.1
 */