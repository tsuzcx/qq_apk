package tencent.mobileim.structmsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class structmsg$RspSystemMsgRead
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "head", "type", "checktype" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(1) }, RspSystemMsgRead.class);
  public final PBEnumField checktype = PBField.initEnum(1);
  public structmsg.RspHead head = new structmsg.RspHead();
  public final PBUInt32Field type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aad.jar
 * Qualified Name:     tencent.mobileim.structmsg.structmsg.RspSystemMsgRead
 * JD-Core Version:    0.7.0.1
 */