package tencent.im.oidb.cmd0xf10;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xf10$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "group_code", "source" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, ReqBody.class);
  public final PBUInt64Field group_code = PBField.initUInt64(0L);
  public final PBUInt32Field source = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xf10.oidb_0xf10.ReqBody
 * JD-Core Version:    0.7.0.1
 */