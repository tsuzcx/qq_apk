package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class FeedCloudTagcategorysvr$StTagCategoryAllRsp
  extends MessageMicro<StTagCategoryAllRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "categoryList" }, new Object[] { null }, StTagCategoryAllRsp.class);
  public final PBRepeatMessageField<FeedCloudTagcategorysvr.StTagCategoryInfo> categoryList = PBField.initRepeatMessage(FeedCloudTagcategorysvr.StTagCategoryInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     feedcloud.FeedCloudTagcategorysvr.StTagCategoryAllRsp
 * JD-Core Version:    0.7.0.1
 */