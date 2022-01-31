package tencent.im.troop.honor;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class troop_honor$GroupUserCardHonor
  extends MessageMicro<GroupUserCardHonor>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "id" }, new Object[] { Integer.valueOf(0) }, GroupUserCardHonor.class);
  public final PBRepeatField<Integer> id = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.troop.honor.troop_honor.GroupUserCardHonor
 * JD-Core Version:    0.7.0.1
 */