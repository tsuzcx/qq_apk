package tencent.im.oidb.oidb_0xf15;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xf15$AddRequest
  extends MessageMicro<AddRequest>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "group_code", "question_id", "reply" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), "" }, AddRequest.class);
  public final PBUInt64Field group_code = PBField.initUInt64(0L);
  public final PBUInt64Field question_id = PBField.initUInt64(0L);
  public final PBStringField reply = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xf15.oidb_0xf15.AddRequest
 * JD-Core Version:    0.7.0.1
 */