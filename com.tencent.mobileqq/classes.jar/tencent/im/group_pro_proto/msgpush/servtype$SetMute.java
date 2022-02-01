package tencent.im.group_pro_proto.msgpush;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class servtype$SetMute
  extends MessageMicro<SetMute>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "action", "tinyID" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L) }, SetMute.class);
  public final PBUInt32Field action = PBField.initUInt32(0);
  public final PBUInt64Field tinyID = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.group_pro_proto.msgpush.servtype.SetMute
 * JD-Core Version:    0.7.0.1
 */