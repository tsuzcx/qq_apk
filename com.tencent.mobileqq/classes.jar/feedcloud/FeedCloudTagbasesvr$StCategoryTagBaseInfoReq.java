package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class FeedCloudTagbasesvr$StCategoryTagBaseInfoReq
  extends MessageMicro<StCategoryTagBaseInfoReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "filters", "search" }, new Object[] { null, "" }, StCategoryTagBaseInfoReq.class);
  public final PBRepeatMessageField<FeedCloudTagbasesvr.StCategoryFilter> filters = PBField.initRepeatMessage(FeedCloudTagbasesvr.StCategoryFilter.class);
  public final PBStringField search = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     feedcloud.FeedCloudTagbasesvr.StCategoryTagBaseInfoReq
 * JD-Core Version:    0.7.0.1
 */