package tencent.im.voip.ivr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class voip_ivr$DialDemoReqBody
  extends MessageMicro<DialDemoReqBody>
{
  public static final int KEY_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "key" }, new Object[] { "" }, DialDemoReqBody.class);
  public final PBStringField key = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     tencent.im.voip.ivr.voip_ivr.DialDemoReqBody
 * JD-Core Version:    0.7.0.1
 */