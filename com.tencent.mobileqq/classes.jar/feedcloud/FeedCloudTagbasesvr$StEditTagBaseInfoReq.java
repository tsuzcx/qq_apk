package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class FeedCloudTagbasesvr$StEditTagBaseInfoReq
  extends MessageMicro<StEditTagBaseInfoReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "editInfos", "delPreEdit" }, new Object[] { null, Boolean.valueOf(false) }, StEditTagBaseInfoReq.class);
  public final PBBoolField delPreEdit = PBField.initBool(false);
  public final PBRepeatMessageField<FeedCloudTagbasesvr.StEditTagInfo> editInfos = PBField.initRepeatMessage(FeedCloudTagbasesvr.StEditTagInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     feedcloud.FeedCloudTagbasesvr.StEditTagBaseInfoReq
 * JD-Core Version:    0.7.0.1
 */