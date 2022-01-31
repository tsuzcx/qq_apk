package tencent.im.oidb.cmd0x6c3;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class oidb_0x6c3$GetExtraDataReq
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "int32_config_id", "int32_version_seq" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, GetExtraDataReq.class);
  public final PBInt32Field int32_config_id = PBField.initInt32(0);
  public final PBInt32Field int32_version_seq = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x6c3.oidb_0x6c3.GetExtraDataReq
 * JD-Core Version:    0.7.0.1
 */