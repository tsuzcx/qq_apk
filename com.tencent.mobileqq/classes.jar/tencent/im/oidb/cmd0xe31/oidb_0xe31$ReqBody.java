package tencent.im.oidb.cmd0xe31;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class oidb_0xe31$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "user_settings_req", "topic_info_get_req", "topic_list_req_req" }, new Object[] { null, null, null }, ReqBody.class);
  public oidb_0xe31.TopicInfoGetReq topic_info_get_req = new oidb_0xe31.TopicInfoGetReq();
  public oidb_0xe31.TopicListReq topic_list_req_req = new oidb_0xe31.TopicListReq();
  public oidb_0xe31.GetUserSettingsReq user_settings_req = new oidb_0xe31.GetUserSettingsReq();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe31.oidb_0xe31.ReqBody
 * JD-Core Version:    0.7.0.1
 */