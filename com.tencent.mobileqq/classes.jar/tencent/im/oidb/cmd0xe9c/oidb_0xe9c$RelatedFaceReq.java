package tencent.im.oidb.cmd0xe9c;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xe9c$RelatedFaceReq
  extends MessageMicro<RelatedFaceReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_emoji_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_package_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField str_img_md5 = PBField.initString("");
  public final PBRepeatField<String> str_labels = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBStringField str_url = PBField.initString("");
  public final PBStringField str_uuid = PBField.initString("");
  public final PBUInt32Field uint32_face_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_height = PBField.initUInt32(0);
  public final PBUInt32Field uint32_width = PBField.initUInt32(0);
  public final PBUInt64Field uint64_file_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_msg_time = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 42, 48, 56, 66, 72, 120, 130, 136, 144 }, new String[] { "str_img_md5", "str_url", "str_labels", "uint32_face_type", "bytes_emoji_id", "uint32_width", "uint32_height", "bytes_package_id", "uint64_msg_time", "uint64_from_uin", "str_uuid", "uint64_group_code", "uint64_file_id" }, new Object[] { "", "", "", localInteger, localByteStringMicro1, localInteger, localInteger, localByteStringMicro2, localLong, localLong, "", localLong, localLong }, RelatedFaceReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe9c.oidb_0xe9c.RelatedFaceReq
 * JD-Core Version:    0.7.0.1
 */