package tencent.im.oidb.cmd0x5d4;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x5d4$DelResult
  extends MessageMicro<DelResult>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uin", "res" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, DelResult.class);
  public final PBEnumField res = PBField.initEnum(0);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0x5d4.oidb_0x5d4.DelResult
 * JD-Core Version:    0.7.0.1
 */