package tencent.im.oidb.cmd0x6cf;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x6cf$PositionInfo
  extends MessageMicro<PositionInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "latitude", "longitude", "altitude" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L) }, PositionInfo.class);
  public final PBUInt64Field altitude = PBField.initUInt64(0L);
  public final PBUInt64Field latitude = PBField.initUInt64(0L);
  public final PBUInt64Field longitude = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x6cf.oidb_0x6cf.PositionInfo
 * JD-Core Version:    0.7.0.1
 */