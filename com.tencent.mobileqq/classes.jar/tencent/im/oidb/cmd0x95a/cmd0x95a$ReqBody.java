package tencent.im.oidb.cmd0x95a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class cmd0x95a$ReqBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 810, 818, 826 }, new String[] { "msg_update_ar_count_req", "msg_get_ar_count_list_req", "msg_get_ar_activity_list_req", "msg_get_ar_activity_detail_req", "msg_get_ar_activity_red_req", "msg_get_world_cup_info_req", "msg_set_world_cup_info_req", "msg_join_world_cup_req" }, new Object[] { null, null, null, null, null, null, null, null }, ReqBody.class);
  public cmd0x95a.GetArActivityDetailReq msg_get_ar_activity_detail_req = new cmd0x95a.GetArActivityDetailReq();
  public cmd0x95a.GetArActivityListReq msg_get_ar_activity_list_req = new cmd0x95a.GetArActivityListReq();
  public cmd0x95a.GetArActivityRedReq msg_get_ar_activity_red_req = new cmd0x95a.GetArActivityRedReq();
  public cmd0x95a.GetArCountListReq msg_get_ar_count_list_req = new cmd0x95a.GetArCountListReq();
  public cmd0x95a.GetWorldCupInfoReq msg_get_world_cup_info_req = new cmd0x95a.GetWorldCupInfoReq();
  public cmd0x95a.JoinWorldCupReq msg_join_world_cup_req = new cmd0x95a.JoinWorldCupReq();
  public cmd0x95a.SetWorldCupInfoReq msg_set_world_cup_info_req = new cmd0x95a.SetWorldCupInfoReq();
  public cmd0x95a.UpdateArCountReq msg_update_ar_count_req = new cmd0x95a.UpdateArCountReq();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x95a.cmd0x95a.ReqBody
 * JD-Core Version:    0.7.0.1
 */