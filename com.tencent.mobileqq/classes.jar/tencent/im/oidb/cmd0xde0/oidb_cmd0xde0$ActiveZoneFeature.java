package tencent.im.oidb.cmd0xde0;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xde0$ActiveZoneFeature
  extends MessageMicro<ActiveZoneFeature>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "top", "bottom" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, ActiveZoneFeature.class);
  public final PBUInt32Field bottom = PBField.initUInt32(0);
  public final PBUInt32Field top = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xde0.oidb_cmd0xde0.ActiveZoneFeature
 * JD-Core Version:    0.7.0.1
 */