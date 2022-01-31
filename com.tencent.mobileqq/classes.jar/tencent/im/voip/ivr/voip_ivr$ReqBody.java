package tencent.im.voip.ivr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class voip_ivr$ReqBody
  extends MessageMicro<ReqBody>
{
  public static final int DIAL_DEMO_BODY_FIELD_NUMBER = 2;
  public static final int HEAD_FIELD_NUMBER = 1;
  public static final int IVR_ACK_BODY_FIELD_NUMBER = 4;
  public static final int IVR_SUBMIT_BODY_FIELD_NUMBER = 3;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "head", "dial_demo_body", "ivr_submit_body", "ivr_ack_body" }, new Object[] { null, null, null, null }, ReqBody.class);
  public voip_ivr.DialDemoReqBody dial_demo_body = new voip_ivr.DialDemoReqBody();
  public voip_ivr.Head head = new voip_ivr.Head();
  public voip_ivr.IvrAckReqBody ivr_ack_body = new voip_ivr.IvrAckReqBody();
  public voip_ivr.IvrSubmitReqBody ivr_submit_body = new voip_ivr.IvrSubmitReqBody();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     tencent.im.voip.ivr.voip_ivr.ReqBody
 * JD-Core Version:    0.7.0.1
 */