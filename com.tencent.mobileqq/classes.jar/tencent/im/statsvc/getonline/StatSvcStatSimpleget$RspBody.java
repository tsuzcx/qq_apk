package tencent.im.statsvc.getonline;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class StatSvcStatSimpleget$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34 }, new String[] { "uint32_error_code", "str_errmsg", "uint32_hello_interval", "str_clientip" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), "" }, RspBody.class);
  public final PBStringField str_clientip = PBField.initString("");
  public final PBStringField str_errmsg = PBField.initString("");
  public final PBUInt32Field uint32_error_code = PBField.initUInt32(0);
  public final PBUInt32Field uint32_hello_interval = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.statsvc.getonline.StatSvcStatSimpleget.RspBody
 * JD-Core Version:    0.7.0.1
 */