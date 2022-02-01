package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class FeedCloudTagbasesvr$StFilterTagBaseInfoRsp
  extends MessageMicro<StFilterTagBaseInfoRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "filteredTags" }, new Object[] { null }, StFilterTagBaseInfoRsp.class);
  public final PBRepeatMessageField<FeedCloudTagbasesvr.StTagBaseInfo> filteredTags = PBField.initRepeatMessage(FeedCloudTagbasesvr.StTagBaseInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     feedcloud.FeedCloudTagbasesvr.StFilterTagBaseInfoRsp
 * JD-Core Version:    0.7.0.1
 */