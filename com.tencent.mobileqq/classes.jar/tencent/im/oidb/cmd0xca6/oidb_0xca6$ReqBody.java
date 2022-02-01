package tencent.im.oidb.cmd0xca6;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xca6$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field adcode = PBField.initUInt32(0);
  public final PBStringField area = PBField.initString("");
  public final PBUInt32Field area_id = PBField.initUInt32(0);
  public final PBStringField city = PBField.initString("");
  public final PBStringField date = PBField.initString("");
  public final PBRepeatField<Integer> type = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBUInt32Field use_history = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 40, 48, 56 }, new String[] { "city", "area", "type", "date", "adcode", "area_id", "use_history" }, new Object[] { "", "", localInteger, "", localInteger, localInteger, localInteger }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xca6.oidb_0xca6.ReqBody
 * JD-Core Version:    0.7.0.1
 */