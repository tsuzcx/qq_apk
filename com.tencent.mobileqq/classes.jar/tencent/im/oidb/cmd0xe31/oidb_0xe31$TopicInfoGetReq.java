package tencent.im.oidb.cmd0xe31;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xe31$TopicInfoGetReq
  extends MessageMicro<TopicInfoGetReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "topic_ids", "is_need_topic_view" }, new Object[] { Integer.valueOf(0), Boolean.valueOf(false) }, TopicInfoGetReq.class);
  public final PBBoolField is_need_topic_view = PBField.initBool(false);
  public final PBRepeatField<Integer> topic_ids = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe31.oidb_0xe31.TopicInfoGetReq
 * JD-Core Version:    0.7.0.1
 */