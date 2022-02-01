package tencent.im.oidb.cmd0x857;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class TroopTips0x857$AIOGrayTipsInfo
  extends MessageMicro<AIOGrayTipsInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField opt_bytes_brief = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField opt_bytes_content = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field opt_uint32_remind = PBField.initUInt32(0);
  public final PBUInt32Field opt_uint32_show_lastest = PBField.initUInt32(0);
  public final PBUInt32Field uint32_reliao_admin_opt = PBField.initUInt32(0);
  public final PBUInt32Field uint32_robot_group_opt = PBField.initUInt32(0);
  public final PBUInt64Field uint64_receiver_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 40, 48, 56 }, new String[] { "opt_uint32_show_lastest", "opt_bytes_content", "opt_uint32_remind", "opt_bytes_brief", "uint64_receiver_uin", "uint32_reliao_admin_opt", "uint32_robot_group_opt" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2, Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, AIOGrayTipsInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0x857.TroopTips0x857.AIOGrayTipsInfo
 * JD-Core Version:    0.7.0.1
 */