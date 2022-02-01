package tencent.im.cs.cmd0x6ff;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class subcmd0x533$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 40, 48, 90, 106 }, new String[] { "string_session_id", "uint64_req_recog_type", "uint32_business_type", "string_clt_version", "msg_ocr_info" }, new Object[] { "", Long.valueOf(0L), Integer.valueOf(0), "", null }, ReqBody.class);
  public subcmd0x533.HttpAROcrInfo msg_ocr_info = new subcmd0x533.HttpAROcrInfo();
  public final PBStringField string_clt_version = PBField.initString("");
  public final PBStringField string_session_id = PBField.initString("");
  public final PBUInt32Field uint32_business_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_req_recog_type = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.cs.cmd0x6ff.subcmd0x533.ReqBody
 * JD-Core Version:    0.7.0.1
 */