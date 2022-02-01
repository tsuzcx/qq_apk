package tencent.im.oidb.cmd0xb31;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xb31$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 792, 800 }, new String[] { "items", "fromuin", "touin" }, new Object[] { null, Long.valueOf(0L), Long.valueOf(0L) }, RspBody.class);
  public final PBUInt64Field fromuin = PBField.initUInt64(0L);
  public final PBRepeatMessageField<oidb_0xb31.SimilarItem> items = PBField.initRepeatMessage(oidb_0xb31.SimilarItem.class);
  public final PBUInt64Field touin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb31.oidb_0xb31.RspBody
 * JD-Core Version:    0.7.0.1
 */