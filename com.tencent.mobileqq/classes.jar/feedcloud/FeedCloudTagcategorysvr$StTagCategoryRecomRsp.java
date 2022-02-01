package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class FeedCloudTagcategorysvr$StTagCategoryRecomRsp
  extends MessageMicro<StTagCategoryRecomRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "tagList" }, new Object[] { null }, StTagCategoryRecomRsp.class);
  public final PBRepeatMessageField<FeedCloudMeta.StTagInfo> tagList = PBField.initRepeatMessage(FeedCloudMeta.StTagInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     feedcloud.FeedCloudTagcategorysvr.StTagCategoryRecomRsp
 * JD-Core Version:    0.7.0.1
 */