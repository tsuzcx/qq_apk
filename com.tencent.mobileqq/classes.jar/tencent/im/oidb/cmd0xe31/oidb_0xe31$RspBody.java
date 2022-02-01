package tencent.im.oidb.cmd0xe31;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class oidb_0xe31$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "user_settings_rsp", "topic_info_get_rsp", "topic_list_req_rsp" }, new Object[] { null, null, null }, RspBody.class);
  public oidb_0xe31.TopicInfoGetRsp topic_info_get_rsp = new oidb_0xe31.TopicInfoGetRsp();
  public oidb_0xe31.TopicListRsp topic_list_req_rsp = new oidb_0xe31.TopicListRsp();
  public oidb_0xe31.GetUserSettingsRsp user_settings_rsp = new oidb_0xe31.GetUserSettingsRsp();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe31.oidb_0xe31.RspBody
 * JD-Core Version:    0.7.0.1
 */