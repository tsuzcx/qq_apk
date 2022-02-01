package tencent.kandian.ugc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class topic_info$TopicFeedsRecentInfo
  extends MessageMicro<TopicFeedsRecentInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field module_type = PBField.initUInt32(0);
  public topic_info.RowkeyInfo rowkey_info = new topic_info.RowkeyInfo();
  public final PBUInt32Field topic_id = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "topic_id", "rowkey_info", "module_type" }, new Object[] { localInteger, null, localInteger }, TopicFeedsRecentInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.kandian.ugc.topic_info.TopicFeedsRecentInfo
 * JD-Core Version:    0.7.0.1
 */