package tencent.im.oidb.cmd0xb86;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xb86$HeadInfo
  extends MessageMicro<HeadInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 104 }, new String[] { "uint32_face_flag", "str_url", "uint64_timestamp" }, new Object[] { Integer.valueOf(0), "", Long.valueOf(0L) }, HeadInfo.class);
  public final PBStringField str_url = PBField.initString("");
  public final PBUInt32Field uint32_face_flag = PBField.initUInt32(0);
  public final PBUInt64Field uint64_timestamp = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb86.oidb_cmd0xb86.HeadInfo
 * JD-Core Version:    0.7.0.1
 */