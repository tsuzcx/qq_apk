package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class FeedCloudTagcategorysvr$StTagUserRelateReq
  extends MessageMicro<StTagUserRelateReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "uid", "nums", "gpsInfo" }, new Object[] { "", null, null }, StTagUserRelateReq.class);
  public FeedCloudMeta.StGPSV2 gpsInfo = new FeedCloudMeta.StGPSV2();
  public final PBRepeatMessageField<FeedCloudTagcategorysvr.StTagUserRelateNum> nums = PBField.initRepeatMessage(FeedCloudTagcategorysvr.StTagUserRelateNum.class);
  public final PBStringField uid = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     feedcloud.FeedCloudTagcategorysvr.StTagUserRelateReq
 * JD-Core Version:    0.7.0.1
 */