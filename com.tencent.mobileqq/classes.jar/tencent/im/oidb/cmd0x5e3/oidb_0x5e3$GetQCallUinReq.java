package tencent.im.oidb.cmd0x5e3;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x5e3$GetQCallUinReq
  extends MessageMicro<GetQCallUinReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 160, 168, 176, 240, 248, 256, 264, 272, 280, 288, 320, 328, 336, 344, 400, 424, 80000, 80008, 80016, 80024, 80032, 80040, 80048, 80056, 80064, 80072, 80080, 80088, 80096, 80104, 80112, 80120, 80128, 80136, 80144, 80152, 80160, 80168, 80176, 80184 }, new String[] { "rpt_uint64_uins", "uint32_req_nick", "uint32_req_gender", "uint32_req_birthday", "uint32_req_in_use_flag", "uint32_req_pre_recycle_flag", "uint32_req_recycle_flag", "uint32_req_frozing_flag", "uint32_req_search_fobid_flag", "uint32_req_login_fobid_flag", "uint32_req_close_friend_recommend_sound", "uint32_req_reg_time", "uint32_req_reg_ip", "uint32_req_recycle_time", "uint32_req_recycle_ip", "uint32_req_photo_ids", "uint32_req_next_photo_id", "uint32_req_remark", "uint32_req_netstatus", "uint32_req_qq", "uint32_req_gsm", "uint32_req_mask_gsm", "uint32_req_is_call_free", "uint32_req_qq_netstatus", "uint32_req_qq_is_call_free", "uint32_req_pstn", "uint32_req_is_ever_pstn", "uint32_req_vip_all_free_time", "uint32_req_vip_left_free_time", "uint32_req_normal_all_free_time", "uint32_req_normal_left_free_time", "uint32_req_used_free_time", "uint32_req_new_gsm", "uint32_req_qq_auto_remark", "uint32_req_profile_card_type", "uint32_req_if_pop_up", "uint32_req_addrlist_time", "uint32_req_identity", "uint32_req_contact_qq", "uint32_req_bind_qq_netstatus", "uint32_req_contact_qq_netstatus" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, GetQCallUinReq.class);
  public final PBRepeatField<Long> rpt_uint64_uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBUInt32Field uint32_req_addrlist_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_bind_qq_netstatus = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_birthday = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_close_friend_recommend_sound = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_contact_qq = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_contact_qq_netstatus = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_frozing_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_gender = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_gsm = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_identity = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_if_pop_up = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_in_use_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_is_call_free = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_is_ever_pstn = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_login_fobid_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_mask_gsm = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_netstatus = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_new_gsm = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_next_photo_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_nick = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_normal_all_free_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_normal_left_free_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_photo_ids = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_pre_recycle_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_profile_card_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_pstn = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_qq = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_qq_auto_remark = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_qq_is_call_free = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_qq_netstatus = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_recycle_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_recycle_ip = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_recycle_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_reg_ip = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_reg_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_remark = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_search_fobid_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_used_free_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_vip_all_free_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_vip_left_free_time = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x5e3.oidb_0x5e3.GetQCallUinReq
 * JD-Core Version:    0.7.0.1
 */