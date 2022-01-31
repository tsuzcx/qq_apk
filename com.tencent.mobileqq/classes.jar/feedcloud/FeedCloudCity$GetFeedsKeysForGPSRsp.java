package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

public final class FeedCloudCity$GetFeedsKeysForGPSRsp
  extends MessageMicro<GetFeedsKeysForGPSRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 42 }, new String[] { "extInfo", "hasMore", "attach", "feedsKeyList", "geo" }, new Object[] { null, Integer.valueOf(0), "", "", null }, GetFeedsKeysForGPSRsp.class);
  public final PBStringField attach = PBField.initString("");
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public final PBRepeatField<String> feedsKeyList = PBField.initRepeat(PBStringField.__repeatHelper__);
  public FeedCloudCity.GeoInfo geo = new FeedCloudCity.GeoInfo();
  public final PBInt32Field hasMore = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     feedcloud.FeedCloudCity.GetFeedsKeysForGPSRsp
 * JD-Core Version:    0.7.0.1
 */