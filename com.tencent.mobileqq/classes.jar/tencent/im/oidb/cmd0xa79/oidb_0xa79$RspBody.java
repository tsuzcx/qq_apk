package tencent.im.oidb.cmd0xa79;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xa79$RspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "uint32_real_state", "uint32_bind_num", "uint32_id_level", "enum_upload_cre" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, RspBody.class);
  public final PBEnumField enum_upload_cre = PBField.initEnum(0);
  public final PBUInt32Field uint32_bind_num = PBField.initUInt32(0);
  public final PBUInt32Field uint32_id_level = PBField.initUInt32(0);
  public final PBUInt32Field uint32_real_state = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0xa79.oidb_0xa79.RspBody
 * JD-Core Version:    0.7.0.1
 */