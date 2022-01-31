package tencent.im.oidb.cmd0x68b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0x68b$ReqBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 90, 96, 104, 112, 120, 128, 138, 144, 154, 162 }, new String[] { "uint64_uin", "uint32_network_type", "reqChannelPara", "uint32_req_topic_list", "rpt_curr_topicid_list", "uint32_req_dislike_type", "enum_req_feeds_style", "uint64_client_swithes", "req_advertise_para", "enum_refresh_type", "msg_refresh_history", "msg_get_follow_tab_feeds_para" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), null, Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), null, Integer.valueOf(1), null, null }, ReqBody.class);
  public final PBEnumField enum_refresh_type = PBField.initEnum(1);
  public final PBEnumField enum_req_feeds_style = PBField.initEnum(0);
  public oidb_cmd0x68b.ReqGetFollowTabPara msg_get_follow_tab_feeds_para = new oidb_cmd0x68b.ReqGetFollowTabPara();
  public oidb_cmd0x68b.RefreshHistory msg_refresh_history = new oidb_cmd0x68b.RefreshHistory();
  public oidb_cmd0x68b.ReqChannelPara reqChannelPara = new oidb_cmd0x68b.ReqChannelPara();
  public oidb_cmd0x68b.ReqAdvertisePara req_advertise_para = new oidb_cmd0x68b.ReqAdvertisePara();
  public final PBRepeatField rpt_curr_topicid_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBUInt32Field uint32_network_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_dislike_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_topic_list = PBField.initUInt32(0);
  public final PBUInt64Field uint64_client_swithes = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.ReqBody
 * JD-Core Version:    0.7.0.1
 */