package tencent.im.oidb.cmd0xe31;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import tencent.kandian.ugc.topic_info.TopicInfo;

public final class oidb_0xe31$TopicInfoGetRsp
  extends MessageMicro<TopicInfoGetRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "infos" }, new Object[] { null }, TopicInfoGetRsp.class);
  public final PBRepeatMessageField<topic_info.TopicInfo> infos = PBField.initRepeatMessage(topic_info.TopicInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe31.oidb_0xe31.TopicInfoGetRsp
 * JD-Core Version:    0.7.0.1
 */