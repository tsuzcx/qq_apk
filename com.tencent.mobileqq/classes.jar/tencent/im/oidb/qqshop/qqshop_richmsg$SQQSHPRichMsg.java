package tencent.im.oidb.qqshop;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqshop_richmsg$SQQSHPRichMsg
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "puin", "msg_id", "sendtime", "img_url" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), "" }, SQQSHPRichMsg.class);
  public final PBRepeatField img_url = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBUInt64Field msg_id = PBField.initUInt64(0L);
  public final PBUInt64Field puin = PBField.initUInt64(0L);
  public final PBUInt64Field sendtime = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.qqshop.qqshop_richmsg.SQQSHPRichMsg
 * JD-Core Version:    0.7.0.1
 */