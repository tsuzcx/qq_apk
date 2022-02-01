package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class FeedCloudTagsvr$GetTagFeedNumsReq
  extends MessageMicro<GetTagFeedNumsReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32 }, new String[] { "extInfo", "tag_name", "left_time", "right_time" }, new Object[] { null, "", Integer.valueOf(0), Integer.valueOf(0) }, GetTagFeedNumsReq.class);
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public final PBUInt32Field left_time = PBField.initUInt32(0);
  public final PBUInt32Field right_time = PBField.initUInt32(0);
  public final PBStringField tag_name = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     feedcloud.FeedCloudTagsvr.GetTagFeedNumsReq
 * JD-Core Version:    0.7.0.1
 */