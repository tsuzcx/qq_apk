package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class FeedCloudTagStorage$HotTagRank
  extends MessageMicro<HotTagRank>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "records" }, new Object[] { null }, HotTagRank.class);
  public final PBRepeatMessageField<FeedCloudTagStorage.HotTagRecord> records = PBField.initRepeatMessage(FeedCloudTagStorage.HotTagRecord.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     feedcloud.FeedCloudTagStorage.HotTagRank
 * JD-Core Version:    0.7.0.1
 */