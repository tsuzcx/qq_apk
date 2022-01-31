package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class FeedCloudTagcategorysvr$StTagCategoryInfoRsp
  extends MessageMicro<StTagCategoryInfoRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "tagInfos" }, new Object[] { null }, StTagCategoryInfoRsp.class);
  public final PBRepeatMessageField<FeedCloudMeta.StTagInfo> tagInfos = PBField.initRepeatMessage(FeedCloudMeta.StTagInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     feedcloud.FeedCloudTagcategorysvr.StTagCategoryInfoRsp
 * JD-Core Version:    0.7.0.1
 */