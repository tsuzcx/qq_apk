package tencent.im.s2c.msgtype0x210.submsgtype0x48;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

public final class RecommendDeviceLock
  extends MessageMicro<RecommendDeviceLock>
{
  public static final int CANCANCEL_FIELD_NUMBER = 1;
  public static final int STR_SECOND_TITLE_FIELD_NUMBER = 4;
  public static final int STR_THIRD_TITLE_FIELD_NUMBER = 5;
  public static final int STR_TITLE_FIELD_NUMBER = 3;
  public static final int STR_WORDING_LIST_FIELD_NUMBER = 6;
  public static final int WORDING_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50 }, new String[] { "canCancel", "wording", "str_title", "str_second_title", "str_third_title", "str_wording_list" }, new Object[] { Boolean.valueOf(false), "", "", "", "", "" }, RecommendDeviceLock.class);
  public final PBBoolField canCancel = PBField.initBool(false);
  public final PBStringField str_second_title = PBField.initString("");
  public final PBStringField str_third_title = PBField.initString("");
  public final PBStringField str_title = PBField.initString("");
  public final PBRepeatField<String> str_wording_list = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBStringField wording = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x48.RecommendDeviceLock
 * JD-Core Version:    0.7.0.1
 */