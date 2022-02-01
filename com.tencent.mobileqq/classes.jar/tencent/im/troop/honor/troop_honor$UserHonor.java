package tencent.im.troop.honor;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class troop_honor$UserHonor
  extends MessageMicro<UserHonor>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatField<Integer> id = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBUInt32Field level = PBField.initUInt32(0);
  public final PBUInt32Field rich_flag = PBField.initUInt32(0);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "uin", "id", "level", "rich_flag" }, new Object[] { Long.valueOf(0L), localInteger, localInteger, localInteger }, UserHonor.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.troop.honor.troop_honor.UserHonor
 * JD-Core Version:    0.7.0.1
 */