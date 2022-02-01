package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

public final class FeedCloudTagbasesvr$StCommTagBaseInfoRsp
  extends MessageMicro<StCommTagBaseInfoRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "allCategorys" }, new Object[] { "" }, StCommTagBaseInfoRsp.class);
  public final PBRepeatField<String> allCategorys = PBField.initRepeat(PBStringField.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     feedcloud.FeedCloudTagbasesvr.StCommTagBaseInfoRsp
 * JD-Core Version:    0.7.0.1
 */