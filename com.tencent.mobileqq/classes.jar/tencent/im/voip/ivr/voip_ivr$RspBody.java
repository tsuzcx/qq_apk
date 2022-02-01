package tencent.im.voip.ivr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class voip_ivr$RspBody
  extends MessageMicro<RspBody>
{
  public static final int DIAL_DEMO_BODY_FIELD_NUMBER = 2;
  public static final int HEAD_FIELD_NUMBER = 1;
  public static final int IVR_ACK_BODY_FIELD_NUMBER = 4;
  public static final int IVR_SUBMIT_BODY_FIELD_NUMBER = 3;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "head", "dial_demo_body", "ivr_submit_body", "ivr_ack_body" }, new Object[] { null, null, null, null }, RspBody.class);
  public voip_ivr.DialDemoRspBody dial_demo_body = new voip_ivr.DialDemoRspBody();
  public voip_ivr.Head head = new voip_ivr.Head();
  public voip_ivr.IvrAckRspBody ivr_ack_body = new voip_ivr.IvrAckRspBody();
  public voip_ivr.IvrSubmitRspBody ivr_submit_body = new voip_ivr.IvrSubmitRspBody();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.voip.ivr.voip_ivr.RspBody
 * JD-Core Version:    0.7.0.1
 */