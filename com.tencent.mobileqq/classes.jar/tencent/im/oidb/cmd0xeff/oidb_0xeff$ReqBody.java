package tencent.im.oidb.cmd0xeff;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xeff$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "cmd", "group_code", "word_id" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L) }, ReqBody.class);
  public final PBUInt32Field cmd = PBField.initUInt32(0);
  public final PBUInt64Field group_code = PBField.initUInt64(0L);
  public final PBUInt64Field word_id = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xeff.oidb_0xeff.ReqBody
 * JD-Core Version:    0.7.0.1
 */