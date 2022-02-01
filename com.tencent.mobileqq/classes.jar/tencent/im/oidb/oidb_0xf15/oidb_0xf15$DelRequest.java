package tencent.im.oidb.oidb_0xf15;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xf15$DelRequest
  extends MessageMicro<DelRequest>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "group_code", "question_id", "answer_id" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0) }, DelRequest.class);
  public final PBUInt32Field answer_id = PBField.initUInt32(0);
  public final PBUInt64Field group_code = PBField.initUInt64(0L);
  public final PBUInt64Field question_id = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xf15.oidb_0xf15.DelRequest
 * JD-Core Version:    0.7.0.1
 */