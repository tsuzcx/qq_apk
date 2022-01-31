package tencent.im.oidb.cmd0x75f;

import QTimedMessage.QTimedMessage.User;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x75f$GetListReq
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32 }, new String[] { "msg_owner", "uint64_end_time", "uint32_main_type", "rpt_uint32_sub_type" }, new Object[] { null, Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, GetListReq.class);
  public QTimedMessage.User msg_owner = new QTimedMessage.User();
  public final PBRepeatField rpt_uint32_sub_type = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBUInt32Field uint32_main_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_end_time = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x75f.cmd0x75f.GetListReq
 * JD-Core Version:    0.7.0.1
 */