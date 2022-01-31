package tencent.im.oidb.cmd0x8f9;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x8f9$SetAllLiteMailReadedByEndTimeReq
  extends MessageMicro<SetAllLiteMailReadedByEndTimeReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint32_end_time" }, new Object[] { Integer.valueOf(0) }, SetAllLiteMailReadedByEndTimeReq.class);
  public final PBUInt32Field uint32_end_time = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8f9.oidb_0x8f9.SetAllLiteMailReadedByEndTimeReq
 * JD-Core Version:    0.7.0.1
 */