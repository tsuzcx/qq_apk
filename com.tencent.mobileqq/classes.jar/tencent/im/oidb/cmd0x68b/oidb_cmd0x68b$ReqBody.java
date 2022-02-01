package tencent.im.oidb.cmd0x68b;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.articlesummary.feeds_info.LocationInfo;

public final class oidb_cmd0x68b$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_nearby_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_sso_client_version = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_style_version = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField enum_refresh_type = PBField.initEnum(1);
  public final PBEnumField enum_req_feeds_style = PBField.initEnum(0);
  public feeds_info.LocationInfo location_info = new feeds_info.LocationInfo();
  public oidb_cmd0x68b.ReqGetFollowTabPara msg_get_follow_tab_feeds_para = new oidb_cmd0x68b.ReqGetFollowTabPara();
  public oidb_cmd0x68b.RefreshHistory msg_refresh_history = new oidb_cmd0x68b.RefreshHistory();
  public oidb_cmd0x68b.ReqChannelPara reqChannelPara = new oidb_cmd0x68b.ReqChannelPara();
  public oidb_cmd0x68b.ReqAdvertisePara req_advertise_para = new oidb_cmd0x68b.ReqAdvertisePara();
  public final PBRepeatField<Long> rpt_curr_topicid_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBUInt32Field uint32_network_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_dislike_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_sim_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_topic_list = PBField.initUInt32(0);
  public final PBUInt64Field uint64_client_swithes = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 90, 96, 104, 112, 120, 128, 138, 144, 154, 162, 170, 178, 184, 194, 1602 }, new String[] { "uint64_uin", "uint32_network_type", "reqChannelPara", "uint32_req_topic_list", "rpt_curr_topicid_list", "uint32_req_dislike_type", "enum_req_feeds_style", "uint64_client_swithes", "req_advertise_para", "enum_refresh_type", "msg_refresh_history", "msg_get_follow_tab_feeds_para", "location_info", "bytes_nearby_cookie", "uint32_req_sim_type", "bytes_sso_client_version", "bytes_style_version" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), null, Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), null, Integer.valueOf(1), null, null, null, localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2, localByteStringMicro3 }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.ReqBody
 * JD-Core Version:    0.7.0.1
 */