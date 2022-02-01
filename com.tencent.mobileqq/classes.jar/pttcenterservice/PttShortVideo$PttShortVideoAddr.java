package pttcenterservice;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class PttShortVideo$PttShortVideoAddr
  extends MessageMicro<PttShortVideoAddr>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 82, 90, 170, 178 }, new String[] { "uint32_host_type", "rpt_str_host", "str_url_args", "rpt_str_host_ipv6", "rpt_str_domain" }, new Object[] { Integer.valueOf(0), "", "", "", "" }, PttShortVideoAddr.class);
  public final PBRepeatField<String> rpt_str_domain = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBRepeatField<String> rpt_str_host = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBRepeatField<String> rpt_str_host_ipv6 = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBStringField str_url_args = PBField.initString("");
  public final PBUInt32Field uint32_host_type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pttcenterservice.PttShortVideo.PttShortVideoAddr
 * JD-Core Version:    0.7.0.1
 */