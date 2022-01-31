package tencent.im.oidb.oidb_0xcf3;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import tencent.intimate_relation.intimate_relation.IntimateInfo;

public final class oidb_0xcf3$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "intimate_list" }, new Object[] { null }, RspBody.class);
  public final PBRepeatMessageField<intimate_relation.IntimateInfo> intimate_list = PBField.initRepeatMessage(intimate_relation.IntimateInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xcf3.oidb_0xcf3.RspBody
 * JD-Core Version:    0.7.0.1
 */