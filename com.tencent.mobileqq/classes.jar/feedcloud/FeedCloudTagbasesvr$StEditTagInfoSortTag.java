package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class FeedCloudTagbasesvr$StEditTagInfoSortTag
  extends MessageMicro<StEditTagInfoSortTag>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "tagCategory", "infos" }, new Object[] { "", null }, StEditTagInfoSortTag.class);
  public final PBRepeatMessageField<FeedCloudTagbasesvr.StTagBaseInfo> infos = PBField.initRepeatMessage(FeedCloudTagbasesvr.StTagBaseInfo.class);
  public final PBStringField tagCategory = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     feedcloud.FeedCloudTagbasesvr.StEditTagInfoSortTag
 * JD-Core Version:    0.7.0.1
 */