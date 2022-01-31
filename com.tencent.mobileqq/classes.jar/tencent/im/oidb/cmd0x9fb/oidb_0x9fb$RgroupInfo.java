package tencent.im.oidb.cmd0x9fb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x9fb$RgroupInfo
  extends MessageMicro<RgroupInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_group_class_text = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_group_face_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_group_memo = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_group_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_recommend_reason = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<oidb_0x9fb.Label> rpt_group_label = PBField.initRepeatMessage(oidb_0x9fb.Label.class);
  public final PBUInt32Field uint32_group_bitmap = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_class = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_face = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_hot_degree = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_level = PBField.initUInt32(0);
  public final PBUInt32Field uint32_max_member_num = PBField.initUInt32(0);
  public final PBUInt32Field uint32_member_num = PBField.initUInt32(0);
  public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_owner_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40, 48, 56, 66, 74, 82, 88, 96, 104, 112, 120, 130 }, new String[] { "uint64_group_code", "uint64_owner_uin", "bytes_group_name", "bytes_group_memo", "uint32_member_num", "uint32_group_face", "uint32_group_class", "bytes_group_face_url", "rpt_group_label", "bytes_group_class_text", "uint32_max_member_num", "uint32_group_level", "uint32_group_bitmap", "uint32_group_hot_degree", "uint32_group_flag", "bytes_recommend_reason" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro3, null, localByteStringMicro4, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro5 }, RgroupInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0x9fb.oidb_0x9fb.RgroupInfo
 * JD-Core Version:    0.7.0.1
 */