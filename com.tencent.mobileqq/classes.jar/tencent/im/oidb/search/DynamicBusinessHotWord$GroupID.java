package tencent.im.oidb.search;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class DynamicBusinessHotWord$GroupID
  extends MessageMicro<GroupID>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "rpt_group_mask" }, new Object[] { Long.valueOf(0L) }, GroupID.class);
  public final PBRepeatField<Long> rpt_group_mask = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.search.DynamicBusinessHotWord.GroupID
 * JD-Core Version:    0.7.0.1
 */