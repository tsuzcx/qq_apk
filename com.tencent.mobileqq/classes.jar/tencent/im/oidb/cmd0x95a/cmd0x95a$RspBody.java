package tencent.im.oidb.cmd0x95a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class cmd0x95a$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 810, 818, 826 }, new String[] { "msg_update_ar_count_rsp", "msg_get_ar_count_list_rsp", "msg_get_ar_activity_list_rsp", "msg_get_ar_activity_detail_rsp", "msg_get_ar_activity_red_rsp", "msg_get_world_cup_info_rsp", "msg_set_world_cup_info_rsp", "msg_join_world_cup_rsp" }, new Object[] { null, null, null, null, null, null, null, null }, RspBody.class);
  public cmd0x95a.GetArActivityDetailRsp msg_get_ar_activity_detail_rsp = new cmd0x95a.GetArActivityDetailRsp();
  public cmd0x95a.GetArActivityListRsp msg_get_ar_activity_list_rsp = new cmd0x95a.GetArActivityListRsp();
  public cmd0x95a.GetArActivityRedRsp msg_get_ar_activity_red_rsp = new cmd0x95a.GetArActivityRedRsp();
  public cmd0x95a.GetArCountListRsp msg_get_ar_count_list_rsp = new cmd0x95a.GetArCountListRsp();
  public cmd0x95a.GetWorldCupInfoRsp msg_get_world_cup_info_rsp = new cmd0x95a.GetWorldCupInfoRsp();
  public cmd0x95a.JoinWorldCupRsp msg_join_world_cup_rsp = new cmd0x95a.JoinWorldCupRsp();
  public cmd0x95a.SetWorldCupInfoRsp msg_set_world_cup_info_rsp = new cmd0x95a.SetWorldCupInfoRsp();
  public cmd0x95a.UpdateArCountRsp msg_update_ar_count_rsp = new cmd0x95a.UpdateArCountRsp();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x95a.cmd0x95a.RspBody
 * JD-Core Version:    0.7.0.1
 */