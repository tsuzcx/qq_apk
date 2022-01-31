package tencent.im.oidb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xc26$RgroupInfo
  extends MessageMicro<RgroupInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_algorithm = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_group_memo = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_group_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_join_group_auth = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field int32_uin_privilege = PBField.initInt32(0);
  public final PBRepeatMessageField<oidb_0xc26.RgoupLabel> rpt_group_label = PBField.initRepeatMessage(oidb_0xc26.RgoupLabel.class);
  public final PBEnumField source = PBField.initEnum(1);
  public oidb_0xc26.RgoupLabel tag_wording = new oidb_0xc26.RgoupLabel();
  public final PBUInt32Field uint32_activity = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_flag_ext = PBField.initUInt32(0);
  public final PBUInt32Field uint32_member_max_num = PBField.initUInt32(0);
  public final PBUInt32Field uint32_member_num = PBField.initUInt32(0);
  public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_owner_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40, 50, 56, 64, 72, 82, 90, 98, 104, 112, 120 }, new String[] { "uint64_group_code", "uint64_owner_uin", "bytes_group_name", "bytes_group_memo", "uint32_member_num", "rpt_group_label", "uint32_group_flag_ext", "uint32_group_flag", "source", "tag_wording", "bytes_algorithm", "bytes_join_group_auth", "uint32_activity", "uint32_member_max_num", "int32_uin_privilege" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), null, localByteStringMicro3, localByteStringMicro4, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, RgroupInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xc26.RgroupInfo
 * JD-Core Version:    0.7.0.1
 */