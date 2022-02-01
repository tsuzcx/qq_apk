package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class FeedCloudTagcategorysvr$StTagCategoryInfo
  extends MessageMicro<StTagCategoryInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "categoryName", "tagList", "nextPage" }, new Object[] { "", null, Integer.valueOf(0) }, StTagCategoryInfo.class);
  public final PBStringField categoryName = PBField.initString("");
  public final PBInt32Field nextPage = PBField.initInt32(0);
  public final PBRepeatMessageField<FeedCloudMeta.StTagInfo> tagList = PBField.initRepeatMessage(FeedCloudMeta.StTagInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     feedcloud.FeedCloudTagcategorysvr.StTagCategoryInfo
 * JD-Core Version:    0.7.0.1
 */