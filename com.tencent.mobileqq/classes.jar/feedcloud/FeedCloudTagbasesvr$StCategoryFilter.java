package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class FeedCloudTagbasesvr$StCategoryFilter
  extends MessageMicro<StCategoryFilter>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field pageCurrent = PBField.initInt32(0);
  public final PBInt32Field pageSize = PBField.initInt32(0);
  public final PBEnumField sort = PBField.initEnum(0);
  public final PBEnumField sortType = PBField.initEnum(0);
  public final PBStringField tagCategory = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40 }, new String[] { "tagCategory", "pageSize", "pageCurrent", "sort", "sortType" }, new Object[] { "", localInteger, localInteger, localInteger, localInteger }, StCategoryFilter.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     feedcloud.FeedCloudTagbasesvr.StCategoryFilter
 * JD-Core Version:    0.7.0.1
 */