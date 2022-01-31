package tencent.im.c2s.imax;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class IMaxService$ExposureMsg
  extends MessageMicro<ExposureMsg>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "str_ad_id", "uint32_action_type", "uint64_uin" }, new Object[] { "", Integer.valueOf(0), Long.valueOf(0L) }, ExposureMsg.class);
  public final PBStringField str_ad_id = PBField.initString("");
  public final PBUInt32Field uint32_action_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     tencent.im.c2s.imax.IMaxService.ExposureMsg
 * JD-Core Version:    0.7.0.1
 */