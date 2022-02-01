package tencent.im.oidb.cmd0xe33;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.kandian.ugc.topic_info.TopicInfo;

public final class oidb_0xe33$TopicInfoSetReq
  extends MessageMicro<TopicInfoSetReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "info", "operate_type" }, new Object[] { null, Integer.valueOf(0) }, TopicInfoSetReq.class);
  public topic_info.TopicInfo info = new topic_info.TopicInfo();
  public final PBUInt32Field operate_type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe33.oidb_0xe33.TopicInfoSetReq
 * JD-Core Version:    0.7.0.1
 */