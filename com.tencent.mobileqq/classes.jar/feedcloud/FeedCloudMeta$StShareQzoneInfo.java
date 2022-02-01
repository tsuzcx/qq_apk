package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class FeedCloudMeta$StShareQzoneInfo
  extends MessageMicro<StShareQzoneInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "entrys" }, new Object[] { null }, StShareQzoneInfo.class);
  public final PBRepeatMessageField<FeedCloudCommon.Entry> entrys = PBField.initRepeatMessage(FeedCloudCommon.Entry.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     feedcloud.FeedCloudMeta.StShareQzoneInfo
 * JD-Core Version:    0.7.0.1
 */