package tencent.im.oidb.cmd0xae9;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Oidb_0xae9$GetAddTimeReq
  extends MessageMicro<GetAddTimeReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "group_code" }, new Object[] { Long.valueOf(0L) }, GetAddTimeReq.class);
  public final PBUInt64Field group_code = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xae9.Oidb_0xae9.GetAddTimeReq
 * JD-Core Version:    0.7.0.1
 */