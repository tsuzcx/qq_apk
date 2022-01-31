package tencent.im.oidb.cmd0x886;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0x886$VideoPlayInfo
  extends MessageMicro<VideoPlayInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56 }, new String[] { "uint32_bt", "uint32_et", "uint32_bf", "uint32_ef", "uint32_pp", "uint32_pa", "uint32_pb" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, VideoPlayInfo.class);
  public final PBUInt32Field uint32_bf = PBField.initUInt32(0);
  public final PBUInt32Field uint32_bt = PBField.initUInt32(0);
  public final PBUInt32Field uint32_ef = PBField.initUInt32(0);
  public final PBUInt32Field uint32_et = PBField.initUInt32(0);
  public final PBUInt32Field uint32_pa = PBField.initUInt32(0);
  public final PBUInt32Field uint32_pb = PBField.initUInt32(0);
  public final PBUInt32Field uint32_pp = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0x886.oidb_cmd0x886.VideoPlayInfo
 * JD-Core Version:    0.7.0.1
 */