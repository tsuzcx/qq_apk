package tencent.kandian.ugc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class topic_info$TopicFeedsRecentInfo
  extends MessageMicro<TopicFeedsRecentInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "topic_id", "rowkey_info", "module_type" }, new Object[] { Integer.valueOf(0), null, Integer.valueOf(0) }, TopicFeedsRecentInfo.class);
  public final PBUInt32Field module_type = PBField.initUInt32(0);
  public topic_info.RowkeyInfo rowkey_info = new topic_info.RowkeyInfo();
  public final PBUInt32Field topic_id = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.kandian.ugc.topic_info.TopicFeedsRecentInfo
 * JD-Core Version:    0.7.0.1
 */