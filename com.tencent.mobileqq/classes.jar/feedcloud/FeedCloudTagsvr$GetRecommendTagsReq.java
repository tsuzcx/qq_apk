package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class FeedCloudTagsvr$GetRecommendTagsReq
  extends MessageMicro<GetRecommendTagsReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34 }, new String[] { "extInfo", "secne", "num", "gps" }, new Object[] { null, Integer.valueOf(1), Integer.valueOf(0), null }, GetRecommendTagsReq.class);
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public FeedCloudMeta.StGPSV2 gps = new FeedCloudMeta.StGPSV2();
  public final PBInt32Field num = PBField.initInt32(0);
  public final PBEnumField secne = PBField.initEnum(1);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     feedcloud.FeedCloudTagsvr.GetRecommendTagsReq
 * JD-Core Version:    0.7.0.1
 */