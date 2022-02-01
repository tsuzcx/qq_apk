package tencent.im.cs.cmd0x6ff;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class subcmd0x533$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 74 }, new String[] { "string_session_id", "uint64_req_recog_type", "uint32_business_type", "msg_ocr_result" }, new Object[] { "", Long.valueOf(0L), Integer.valueOf(0), null }, RspBody.class);
  public subcmd0x533.HttpAROcrResult msg_ocr_result = new subcmd0x533.HttpAROcrResult();
  public final PBStringField string_session_id = PBField.initString("");
  public final PBUInt32Field uint32_business_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_req_recog_type = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.cs.cmd0x6ff.subcmd0x533.RspBody
 * JD-Core Version:    0.7.0.1
 */