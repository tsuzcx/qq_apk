package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class FeedCloudTagcategorysvr$StTagOneCategoryReq
  extends MessageMicro<StTagOneCategoryReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "categoryName", "reqPage" }, new Object[] { "", Integer.valueOf(0) }, StTagOneCategoryReq.class);
  public final PBStringField categoryName = PBField.initString("");
  public final PBInt32Field reqPage = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     feedcloud.FeedCloudTagcategorysvr.StTagOneCategoryReq
 * JD-Core Version:    0.7.0.1
 */