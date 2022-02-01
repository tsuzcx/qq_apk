package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class FeedCloudTagbasesvr$StEditTagInfo
  extends MessageMicro<StEditTagInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50 }, new String[] { "addTag", "delTag", "editTagName", "editTag", "addCategory", "sortTag" }, new Object[] { null, null, null, null, null, null }, StEditTagInfo.class);
  public FeedCloudTagbasesvr.StEditTagInfoAddCategory addCategory = new FeedCloudTagbasesvr.StEditTagInfoAddCategory();
  public FeedCloudTagbasesvr.StEditTagInfoAddTag addTag = new FeedCloudTagbasesvr.StEditTagInfoAddTag();
  public FeedCloudTagbasesvr.StEditTagInfoDelTag delTag = new FeedCloudTagbasesvr.StEditTagInfoDelTag();
  public FeedCloudTagbasesvr.StEditTagInfoEditTag editTag = new FeedCloudTagbasesvr.StEditTagInfoEditTag();
  public FeedCloudTagbasesvr.StEditTagInfoEditTagName editTagName = new FeedCloudTagbasesvr.StEditTagInfoEditTagName();
  public FeedCloudTagbasesvr.StEditTagInfoSortTag sortTag = new FeedCloudTagbasesvr.StEditTagInfoSortTag();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     feedcloud.FeedCloudTagbasesvr.StEditTagInfo
 * JD-Core Version:    0.7.0.1
 */