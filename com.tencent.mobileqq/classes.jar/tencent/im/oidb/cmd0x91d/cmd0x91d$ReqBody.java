package tencent.im.oidb.cmd0x91d;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x91d$ReqBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_req_uin", "uint64_last_time" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, ReqBody.class);
  public final PBUInt64Field uint64_last_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_req_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x91d.cmd0x91d.ReqBody
 * JD-Core Version:    0.7.0.1
 */