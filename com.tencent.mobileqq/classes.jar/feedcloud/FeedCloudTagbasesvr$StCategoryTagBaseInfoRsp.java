package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class FeedCloudTagbasesvr$StCategoryTagBaseInfoRsp
  extends MessageMicro<StCategoryTagBaseInfoRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "infos" }, new Object[] { null }, StCategoryTagBaseInfoRsp.class);
  public final PBRepeatMessageField<FeedCloudTagbasesvr.StCategoryTag> infos = PBField.initRepeatMessage(FeedCloudTagbasesvr.StCategoryTag.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     feedcloud.FeedCloudTagbasesvr.StCategoryTagBaseInfoRsp
 * JD-Core Version:    0.7.0.1
 */