package com.tencent.qidian.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class mobileqq_qidian$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98, 106, 8066, 8074, 8082, 8090, 8098, 8146 }, new String[] { "uint32_sub_cmd", "msg_crm_common_head", "msg_wpa_assign_kfext_req", "msg_wpa_sigt_to_sigmsg_req", "msg_click_reply_cmd_action_req", "msg_get_user_detail_info_req", "msg_get_account_type_req", "msg_get_business_mobile_req", "msg_verify_wpa_uin_and_key_req", "msg_check_mpqq_refuse_flag_req", "msg_get_customer_transfer_info_req", "msg_not_recv_qd_group_msg_req", "msg_get_navigation_menu_config_req_body", "msg_req_corpuin_wpa_req", "msg_get_corpuin_detail_info_req_body", "msg_click_eman_req", "msg_close_session_req", "msg_qidian_wpa_addfriend_req", "msg_get_qidian_group_info_req" }, new Object[] { Integer.valueOf(0), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null }, ReqBody.class);
  public mobileqq_qidian.CheckMpqqRefuseFlagReq msg_check_mpqq_refuse_flag_req = new mobileqq_qidian.CheckMpqqRefuseFlagReq();
  public mobileqq_qidian.ClickEManReqBody msg_click_eman_req = new mobileqq_qidian.ClickEManReqBody();
  public mobileqq_qidian.ClickReplyCmdActionReqBody msg_click_reply_cmd_action_req = new mobileqq_qidian.ClickReplyCmdActionReqBody();
  public mobileqq_qidian.CloseSessionReqBody msg_close_session_req = new mobileqq_qidian.CloseSessionReqBody();
  public mobileqq_qidian.CRMMsgHead msg_crm_common_head = new mobileqq_qidian.CRMMsgHead();
  public mobileqq_qidian.GetAccountTypeReqBody msg_get_account_type_req = new mobileqq_qidian.GetAccountTypeReqBody();
  public mobileqq_qidian.GetBusinessMobileReq msg_get_business_mobile_req = new mobileqq_qidian.GetBusinessMobileReq();
  public mobileqq_qidian.GetCorpUinDetailInfoReqBody msg_get_corpuin_detail_info_req_body = new mobileqq_qidian.GetCorpUinDetailInfoReqBody();
  public mobileqq_qidian.GetCustomerTransferInfoReqBody msg_get_customer_transfer_info_req = new mobileqq_qidian.GetCustomerTransferInfoReqBody();
  public mobileqq_qidian.GetNavigationMenuConfigReqBody msg_get_navigation_menu_config_req_body = new mobileqq_qidian.GetNavigationMenuConfigReqBody();
  public mobileqq_qidian.GetQiDianGroupInfoReq msg_get_qidian_group_info_req = new mobileqq_qidian.GetQiDianGroupInfoReq();
  public mobileqq_qidian.GetUserDetailInfoReqBody msg_get_user_detail_info_req = new mobileqq_qidian.GetUserDetailInfoReqBody();
  public mobileqq_qidian.NotRecvQdGroupMsgReq msg_not_recv_qd_group_msg_req = new mobileqq_qidian.NotRecvQdGroupMsgReq();
  public mobileqq_qidian.QidianWpaAddFriendReqBody msg_qidian_wpa_addfriend_req = new mobileqq_qidian.QidianWpaAddFriendReqBody();
  public mobileqq_qidian.ReqCorpUinWpaReq msg_req_corpuin_wpa_req = new mobileqq_qidian.ReqCorpUinWpaReq();
  public mobileqq_qidian.VerifyWpaUinAndKeyReq msg_verify_wpa_uin_and_key_req = new mobileqq_qidian.VerifyWpaUinAndKeyReq();
  public mobileqq_qidian.WpaAssignKfextReqBody msg_wpa_assign_kfext_req = new mobileqq_qidian.WpaAssignKfextReqBody();
  public mobileqq_qidian.WpaSigtToSigMsgReqBody msg_wpa_sigt_to_sigmsg_req = new mobileqq_qidian.WpaSigtToSigMsgReqBody();
  public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qidian.proto.mobileqq_qidian.ReqBody
 * JD-Core Version:    0.7.0.1
 */