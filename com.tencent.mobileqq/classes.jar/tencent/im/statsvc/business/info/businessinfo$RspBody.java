package tencent.im.statsvc.business.info;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class businessinfo$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "uint32_error_code", "string_error_msg", "uint32_interval" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0) }, RspBody.class);
  public final PBStringField string_error_msg = PBField.initString("");
  public final PBUInt32Field uint32_error_code = PBField.initUInt32(0);
  public final PBUInt32Field uint32_interval = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.statsvc.business.info.businessinfo.RspBody
 * JD-Core Version:    0.7.0.1
 */