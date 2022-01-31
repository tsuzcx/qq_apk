package tencent.im.oidb.oidb_0xdc9;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xdc9$HonorList
  extends MessageMicro<HonorList>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "group_id", "id", "is_gray" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, HonorList.class);
  public final PBUInt64Field group_id = PBField.initUInt64(0L);
  public final PBRepeatField<Integer> id = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBUInt32Field is_gray = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xdc9.oidb_0xdc9.HonorList
 * JD-Core Version:    0.7.0.1
 */