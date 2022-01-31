package msf.msgcomm;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class msg_comm$MutilTransHead
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "status", "msgId" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, MutilTransHead.class);
  public final PBUInt32Field msgId = PBField.initUInt32(0);
  public final PBUInt32Field status = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\acom2.jar
 * Qualified Name:     msf.msgcomm.msg_comm.MutilTransHead
 * JD-Core Version:    0.7.0.1
 */