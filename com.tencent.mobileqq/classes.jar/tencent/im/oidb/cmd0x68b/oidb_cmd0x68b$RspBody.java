package tencent.im.oidb.cmd0x68b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0x68b$RspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 90, 98, 104, 114, 122, 128, 138 }, new String[] { "uint64_uin", "rspChannelArticle", "rspTopicList", "rpt_obsolete_topicid_list", "rspRedBonusInfo", "msg_rsp_get_follow_tab_data", "uint64_client_swithes", "msg_rsp_trace" }, new Object[] { Long.valueOf(0L), null, null, Long.valueOf(0L), null, null, Long.valueOf(0L), null }, RspBody.class);
  public oidb_cmd0x68b.RspGetFollowTabData msg_rsp_get_follow_tab_data = new oidb_cmd0x68b.RspGetFollowTabData();
  public oidb_cmd0x68b.RspTrace msg_rsp_trace = new oidb_cmd0x68b.RspTrace();
  public final PBRepeatField rpt_obsolete_topicid_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public oidb_cmd0x68b.RspChannelArticle rspChannelArticle = new oidb_cmd0x68b.RspChannelArticle();
  public oidb_cmd0x68b.RspRedBonusInfo rspRedBonusInfo = new oidb_cmd0x68b.RspRedBonusInfo();
  public oidb_cmd0x68b.RspTopicList rspTopicList = new oidb_cmd0x68b.RspTopicList();
  public final PBUInt64Field uint64_client_swithes = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.RspBody
 * JD-Core Version:    0.7.0.1
 */