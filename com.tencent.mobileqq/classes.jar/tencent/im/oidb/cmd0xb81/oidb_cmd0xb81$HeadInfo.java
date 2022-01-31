package tencent.im.oidb.cmd0xb81;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xb81$HeadInfo
  extends MessageMicro<HeadInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 48, 82 }, new String[] { "uint32_face_type", "uint64_timestamp", "uint32_face_flag", "str_url", "uint32_sysid", "uint32_source", "str_big_url" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), "" }, HeadInfo.class);
  public final PBStringField str_big_url = PBField.initString("");
  public final PBStringField str_url = PBField.initString("");
  public final PBUInt32Field uint32_face_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_face_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_source = PBField.initUInt32(0);
  public final PBUInt32Field uint32_sysid = PBField.initUInt32(0);
  public final PBUInt64Field uint64_timestamp = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb81.oidb_cmd0xb81.HeadInfo
 * JD-Core Version:    0.7.0.1
 */