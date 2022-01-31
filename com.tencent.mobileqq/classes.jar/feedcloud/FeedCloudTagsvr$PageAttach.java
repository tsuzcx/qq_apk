package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class FeedCloudTagsvr$PageAttach
  extends MessageMicro<PageAttach>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "feedsKeyItemList" }, new Object[] { null }, PageAttach.class);
  public final PBRepeatMessageField<FeedCloudTagsvr.FeedsKeyItem> feedsKeyItemList = PBField.initRepeatMessage(FeedCloudTagsvr.FeedsKeyItem.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     feedcloud.FeedCloudTagsvr.PageAttach
 * JD-Core Version:    0.7.0.1
 */