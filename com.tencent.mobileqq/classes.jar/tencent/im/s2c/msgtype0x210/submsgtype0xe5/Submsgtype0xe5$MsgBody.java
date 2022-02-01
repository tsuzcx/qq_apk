package tencent.im.s2c.msgtype0x210.submsgtype0xe5;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class Submsgtype0xe5$MsgBody
  extends MessageMicro<MsgBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98 }, new String[] { "uint32_sub_cmd", "msg_crm_common_head", "msg_s2c_cc_agent_status_change_push", "msg_s2c_cc_config_change_push", "msg_s2c_cc_exception_occur_push", "msg_s2c_cc_talking_status_change_push", "msg_s2c_cc_agent_action_result_push", "msg_s2c_call_record_change_push", "msg_s2c_sms_event_push", "msg_s2c_agent_call_status_event_push", "msg_s2c_user_get_coupon_for_kfext_event_push", "msg_s2c_user_get_coupon_for_c_event_push" }, new Object[] { Integer.valueOf(0), null, null, null, null, null, null, null, null, null, null, null }, MsgBody.class);
  public Submsgtype0xe5.CrmS2CMsgHead msg_crm_common_head = new Submsgtype0xe5.CrmS2CMsgHead();
  public Submsgtype0xe5.MsgBody.S2CAgentCallStatusEventPush msg_s2c_agent_call_status_event_push = new Submsgtype0xe5.MsgBody.S2CAgentCallStatusEventPush();
  public Submsgtype0xe5.MsgBody.S2CCallRecordChangePush msg_s2c_call_record_change_push = new Submsgtype0xe5.MsgBody.S2CCallRecordChangePush();
  public Submsgtype0xe5.MsgBody.S2CCcAgentActionResultPush msg_s2c_cc_agent_action_result_push = new Submsgtype0xe5.MsgBody.S2CCcAgentActionResultPush();
  public Submsgtype0xe5.MsgBody.S2CCcAgentStatusChangePush msg_s2c_cc_agent_status_change_push = new Submsgtype0xe5.MsgBody.S2CCcAgentStatusChangePush();
  public Submsgtype0xe5.MsgBody.S2CCcConfigChangePush msg_s2c_cc_config_change_push = new Submsgtype0xe5.MsgBody.S2CCcConfigChangePush();
  public Submsgtype0xe5.MsgBody.S2CCcExceptionOccurPush msg_s2c_cc_exception_occur_push = new Submsgtype0xe5.MsgBody.S2CCcExceptionOccurPush();
  public Submsgtype0xe5.MsgBody.S2CCcTalkingStatusChangePush msg_s2c_cc_talking_status_change_push = new Submsgtype0xe5.MsgBody.S2CCcTalkingStatusChangePush();
  public Submsgtype0xe5.MsgBody.S2CSMSEventPush msg_s2c_sms_event_push = new Submsgtype0xe5.MsgBody.S2CSMSEventPush();
  public Submsgtype0xe5.MsgBody.S2CUserGetCouponForCEventPush msg_s2c_user_get_coupon_for_c_event_push = new Submsgtype0xe5.MsgBody.S2CUserGetCouponForCEventPush();
  public Submsgtype0xe5.MsgBody.S2CUserGetCouponForKFExtEventPush msg_s2c_user_get_coupon_for_kfext_event_push = new Submsgtype0xe5.MsgBody.S2CUserGetCouponForKFExtEventPush();
  public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0xe5.Submsgtype0xe5.MsgBody
 * JD-Core Version:    0.7.0.1
 */