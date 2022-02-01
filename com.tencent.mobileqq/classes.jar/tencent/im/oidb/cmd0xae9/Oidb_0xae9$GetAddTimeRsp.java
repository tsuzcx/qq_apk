package tencent.im.oidb.cmd0xae9;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Oidb_0xae9$GetAddTimeRsp
  extends MessageMicro<GetAddTimeRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "timestamp" }, new Object[] { Long.valueOf(0L) }, GetAddTimeRsp.class);
  public final PBUInt64Field timestamp = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xae9.Oidb_0xae9.GetAddTimeRsp
 * JD-Core Version:    0.7.0.1
 */