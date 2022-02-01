package tencent.im.voip.ivr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class voip_ivr$IvrSubmitReqBody
  extends MessageMicro<IvrSubmitReqBody>
{
  public static final int DATA_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "data" }, new Object[] { "" }, IvrSubmitReqBody.class);
  public final PBStringField data = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.voip.ivr.voip_ivr.IvrSubmitReqBody
 * JD-Core Version:    0.7.0.1
 */