package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class FeedCloudTagcategorysvr$StTagOneCategoryRsp
  extends MessageMicro<StTagOneCategoryRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "categoryInfo", "nextPage" }, new Object[] { null, Integer.valueOf(0) }, StTagOneCategoryRsp.class);
  public FeedCloudTagcategorysvr.StTagCategoryInfo categoryInfo = new FeedCloudTagcategorysvr.StTagCategoryInfo();
  public final PBInt32Field nextPage = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     feedcloud.FeedCloudTagcategorysvr.StTagOneCategoryRsp
 * JD-Core Version:    0.7.0.1
 */