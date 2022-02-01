package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class FeedCloudTagbasesvr$StDelParentIndexRsp
  extends MessageMicro<StDelParentIndexRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "delCategoryInfo", "delTagInfo" }, new Object[] { null, null }, StDelParentIndexRsp.class);
  public FeedCloudTagbasesvr.StTagBaseInfo delCategoryInfo = new FeedCloudTagbasesvr.StTagBaseInfo();
  public FeedCloudTagbasesvr.StTagBaseInfo delTagInfo = new FeedCloudTagbasesvr.StTagBaseInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     feedcloud.FeedCloudTagbasesvr.StDelParentIndexRsp
 * JD-Core Version:    0.7.0.1
 */