package tencent.im.oidb.cmd0xfa4;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xfa4$RedInfo
  extends MessageMicro<RedInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "time_stamp", "is_red" }, new Object[] { Long.valueOf(0L), Boolean.valueOf(false) }, RedInfo.class);
  public final PBBoolField is_red = PBField.initBool(false);
  public final PBUInt64Field time_stamp = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xfa4.oidb_cmd0xfa4.RedInfo
 * JD-Core Version:    0.7.0.1
 */