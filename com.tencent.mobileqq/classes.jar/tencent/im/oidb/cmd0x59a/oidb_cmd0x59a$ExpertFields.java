package tencent.im.oidb.cmd0x59a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0x59a$ExpertFields
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 168, 176 }, new String[] { "uint32_req_name", "uint32_req_face_url" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, ExpertFields.class);
  public final PBUInt32Field uint32_req_face_url = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_name = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x59a.oidb_cmd0x59a.ExpertFields
 * JD-Core Version:    0.7.0.1
 */