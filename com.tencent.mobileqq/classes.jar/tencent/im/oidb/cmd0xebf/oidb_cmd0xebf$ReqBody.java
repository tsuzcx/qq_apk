package tencent.im.oidb.cmd0xebf;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xebf$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "business_type", "request_params_json", "extend_info_json" }, new Object[] { Integer.valueOf(0), "", "" }, ReqBody.class);
  public final PBUInt32Field business_type = PBField.initUInt32(0);
  public final PBStringField extend_info_json = PBField.initString("");
  public final PBStringField request_params_json = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xebf.oidb_cmd0xebf.ReqBody
 * JD-Core Version:    0.7.0.1
 */