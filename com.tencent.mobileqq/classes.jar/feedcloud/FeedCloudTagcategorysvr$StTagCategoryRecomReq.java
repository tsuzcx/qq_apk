package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class FeedCloudTagcategorysvr$StTagCategoryRecomReq
  extends MessageMicro<StTagCategoryRecomReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "gpsInfo", "picRecomMap", "reqType" }, new Object[] { null, null, Integer.valueOf(0) }, StTagCategoryRecomReq.class);
  public FeedCloudMeta.StGPSV2 gpsInfo = new FeedCloudMeta.StGPSV2();
  public final PBRepeatMessageField<FeedCloudTagcategorysvr.PicRecomEntry> picRecomMap = PBField.initRepeatMessage(FeedCloudTagcategorysvr.PicRecomEntry.class);
  public final PBInt32Field reqType = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     feedcloud.FeedCloudTagcategorysvr.StTagCategoryRecomReq
 * JD-Core Version:    0.7.0.1
 */