package tencent.im.oidb.cmd0xc96;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xc96$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field app_type = PBField.initUInt32(0);
  public final PBUInt64Field appid = PBField.initUInt64(0L);
  public final PBUInt32Field cmd_type = PBField.initUInt32(0);
  public oidb_cmd0xc96.FollowReq follow_req = new oidb_cmd0xc96.FollowReq();
  public oidb_cmd0xc96.GetFollowInfoReq get_follow_info_req = new oidb_cmd0xc96.GetFollowInfoReq();
  public oidb_cmd0xc96.MGetFollowInfoReq mget_follow_info_req = new oidb_cmd0xc96.MGetFollowInfoReq();
  public final PBUInt64Field puin = PBField.initUInt64(0L);
  public oidb_cmd0xc96.UnfollowReq unfollow_req = new oidb_cmd0xc96.UnfollowReq();
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 90, 98, 106, 114 }, new String[] { "appid", "app_type", "puin", "cmd_type", "follow_req", "unfollow_req", "get_follow_info_req", "mget_follow_info_req" }, new Object[] { localLong, localInteger, localLong, localInteger, null, null, null, null }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xc96.oidb_cmd0xc96.ReqBody
 * JD-Core Version:    0.7.0.1
 */