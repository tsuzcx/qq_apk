package tencent.im.troop.honor;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class troop_honor$HonorChangeGrayTipsReserved
  extends MessageMicro<HonorChangeGrayTipsReserved>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "user_honor" }, new Object[] { null }, HonorChangeGrayTipsReserved.class);
  public final PBRepeatMessageField<troop_honor.UserHonor> user_honor = PBField.initRepeatMessage(troop_honor.UserHonor.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.troop.honor.troop_honor.HonorChangeGrayTipsReserved
 * JD-Core Version:    0.7.0.1
 */