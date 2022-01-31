package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class FeedCloudTagcategorysvr$StTagCategoryAllReq
  extends MessageMicro<StTagCategoryAllReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "gpsInfo" }, new Object[] { null }, StTagCategoryAllReq.class);
  public FeedCloudMeta.StGPSV2 gpsInfo = new FeedCloudMeta.StGPSV2();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     feedcloud.FeedCloudTagcategorysvr.StTagCategoryAllReq
 * JD-Core Version:    0.7.0.1
 */