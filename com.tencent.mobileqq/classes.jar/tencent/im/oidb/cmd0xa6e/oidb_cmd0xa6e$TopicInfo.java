package tencent.im.oidb.cmd0xa6e;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xa6e$TopicInfo
  extends MessageMicro<TopicInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field uint32_followed_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_pv = PBField.initUInt32(0);
  public final PBUInt32Field uint32_ugc_count = PBField.initUInt32(0);
  public final PBUInt64Field uint64_topic_id = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 80, 88, 96 }, new String[] { "uint64_topic_id", "uint32_pv", "uint32_followed_count", "uint32_ugc_count" }, new Object[] { Long.valueOf(0L), localInteger, localInteger, localInteger }, TopicInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xa6e.oidb_cmd0xa6e.TopicInfo
 * JD-Core Version:    0.7.0.1
 */