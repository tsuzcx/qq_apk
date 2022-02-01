package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class FeedCloudTagcategorysvr$StTagCategoryAllReq
  extends MessageMicro<StTagCategoryAllReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "gpsInfo", "reqType" }, new Object[] { null, Integer.valueOf(0) }, StTagCategoryAllReq.class);
  public FeedCloudMeta.StGPSV2 gpsInfo = new FeedCloudMeta.StGPSV2();
  public final PBInt32Field reqType = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     feedcloud.FeedCloudTagcategorysvr.StTagCategoryAllReq
 * JD-Core Version:    0.7.0.1
 */