package tencent.im.oidb.cmd0xede;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xede$GroupInfo
  extends MessageMicro<GroupInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_join_group_auth = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<oidb_0xede.Label> rpt_group_label = PBField.initRepeatMessage(oidb_0xede.Label.class);
  public final PBBytesField string_group_finger_memo = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField string_group_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField string_group_rich_finger_memo = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_group_face = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_member_max_num = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_member_num = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_conf_group = PBField.initUInt32(0);
  public final PBUInt32Field uint32_role = PBField.initUInt32(0);
  public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
  public final PBUInt32Field uint32_status = PBField.initUInt32(0);
  public final PBUInt32Field uint32_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 48, 56, 64, 74, 82, 90, 98, 104, 112 }, new String[] { "uint64_group_code", "uint32_group_member_max_num", "uint32_group_member_num", "string_group_name", "uint32_status", "uint32_type", "uint32_role", "uint32_seq", "bytes_join_group_auth", "rpt_group_label", "string_group_finger_memo", "string_group_rich_finger_memo", "uint32_group_face", "uint32_is_conf_group" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2, null, localByteStringMicro3, localByteStringMicro4, Integer.valueOf(0), Integer.valueOf(0) }, GroupInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xede.oidb_0xede.GroupInfo
 * JD-Core Version:    0.7.0.1
 */