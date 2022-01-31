package tencent.im.oidb.cmd0x98d;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x98d$YListReq
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "group_code", "start", "limit" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, YListReq.class);
  public final PBUInt64Field group_code = PBField.initUInt64(0L);
  public final PBUInt32Field limit = PBField.initUInt32(0);
  public final PBUInt32Field start = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x98d.oidb_0x98d.YListReq
 * JD-Core Version:    0.7.0.1
 */