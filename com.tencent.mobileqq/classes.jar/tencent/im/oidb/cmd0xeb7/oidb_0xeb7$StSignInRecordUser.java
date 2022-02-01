package tencent.im.oidb.cmd0xeb7;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

public final class oidb_0xeb7$StSignInRecordUser
  extends MessageMicro<StSignInRecordUser>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt64Field continueSignedDays = PBField.initInt64(0L);
  public final PBInt64Field earliestSignedTimeStamp = PBField.initInt64(0L);
  public final PBStringField groupName = PBField.initString("");
  public final PBRepeatField<String> historySignedDays = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBInt32Field totalSignedDays = PBField.initInt32(0);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 16, 24, 32, 42, 50 }, new String[] { "totalSignedDays", "earliestSignedTimeStamp", "continueSignedDays", "historySignedDays", "groupName" }, new Object[] { Integer.valueOf(0), localLong, localLong, "", "" }, StSignInRecordUser.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xeb7.oidb_0xeb7.StSignInRecordUser
 * JD-Core Version:    0.7.0.1
 */