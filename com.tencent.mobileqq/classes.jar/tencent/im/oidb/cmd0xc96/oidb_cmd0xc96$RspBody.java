package tencent.im.oidb.cmd0xc96;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xc96$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field app_type = PBField.initUInt32(0);
  public final PBUInt64Field appid = PBField.initUInt64(0L);
  public oidb_cmd0xc96.FollowRsp follow_rsp = new oidb_cmd0xc96.FollowRsp();
  public oidb_cmd0xc96.GetFollowInfoRsp get_follow_info_rsp = new oidb_cmd0xc96.GetFollowInfoRsp();
  public oidb_cmd0xc96.MGetFollowInfoRsp mget_follow_info_rsp = new oidb_cmd0xc96.MGetFollowInfoRsp();
  public final PBUInt32Field next_req_duration = PBField.initUInt32(0);
  public oidb_cmd0xc96.UnfollowRsp unfollow_rsp = new oidb_cmd0xc96.UnfollowRsp();
  public final PBStringField wording = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 90, 98, 106, 114 }, new String[] { "wording", "next_req_duration", "appid", "app_type", "follow_rsp", "unfollow_rsp", "get_follow_info_rsp", "mget_follow_info_rsp" }, new Object[] { "", localInteger, Long.valueOf(0L), localInteger, null, null, null, null }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xc96.oidb_cmd0xc96.RspBody
 * JD-Core Version:    0.7.0.1
 */