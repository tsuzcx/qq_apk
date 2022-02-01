package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class FeedCloudTagbasesvr$StCategoryTag
  extends MessageMicro<StCategoryTag>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatMessageField<FeedCloudTagbasesvr.StTagBaseInfo> infos = PBField.initRepeatMessage(FeedCloudTagbasesvr.StTagBaseInfo.class);
  public final PBInt32Field pageCurrent = PBField.initInt32(0);
  public final PBInt32Field pageSize = PBField.initInt32(0);
  public final PBInt32Field pageTotal = PBField.initInt32(0);
  public final PBStringField tagCategory = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40 }, new String[] { "tagCategory", "infos", "pageSize", "pageCurrent", "pageTotal" }, new Object[] { "", null, localInteger, localInteger, localInteger }, StCategoryTag.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     feedcloud.FeedCloudTagbasesvr.StCategoryTag
 * JD-Core Version:    0.7.0.1
 */