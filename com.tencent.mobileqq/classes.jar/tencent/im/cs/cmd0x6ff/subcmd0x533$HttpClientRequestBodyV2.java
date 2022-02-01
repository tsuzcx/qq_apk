package tencent.im.cs.cmd0x6ff;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class subcmd0x533$HttpClientRequestBodyV2
  extends MessageMicro<HttpClientRequestBodyV2>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 34, 80 }, new String[] { "msg_device", "rpt_string_sentences", "uint32_timeout_ms" }, new Object[] { null, "", Integer.valueOf(0) }, HttpClientRequestBodyV2.class);
  public subcmd0x533.HttpDeviceV2 msg_device = new subcmd0x533.HttpDeviceV2();
  public final PBRepeatField<String> rpt_string_sentences = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBUInt32Field uint32_timeout_ms = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.cs.cmd0x6ff.subcmd0x533.HttpClientRequestBodyV2
 * JD-Core Version:    0.7.0.1
 */