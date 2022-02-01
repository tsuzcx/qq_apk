package tencent.im.longconn.multimsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class MultiMsg$ExternMsg
  extends MessageMicro<ExternMsg>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint32_channel_type" }, new Object[] { Integer.valueOf(0) }, ExternMsg.class);
  public final PBUInt32Field uint32_channel_type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.longconn.multimsg.MultiMsg.ExternMsg
 * JD-Core Version:    0.7.0.1
 */