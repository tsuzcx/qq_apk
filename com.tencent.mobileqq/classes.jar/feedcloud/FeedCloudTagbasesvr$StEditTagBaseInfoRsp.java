package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class FeedCloudTagbasesvr$StEditTagBaseInfoRsp
  extends MessageMicro<StEditTagBaseInfoRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "editInfos" }, new Object[] { null }, StEditTagBaseInfoRsp.class);
  public final PBRepeatMessageField<FeedCloudTagbasesvr.StEditTagInfo> editInfos = PBField.initRepeatMessage(FeedCloudTagbasesvr.StEditTagInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     feedcloud.FeedCloudTagbasesvr.StEditTagBaseInfoRsp
 * JD-Core Version:    0.7.0.1
 */