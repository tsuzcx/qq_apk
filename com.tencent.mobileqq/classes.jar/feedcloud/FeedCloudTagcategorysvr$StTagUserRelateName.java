package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

public final class FeedCloudTagcategorysvr$StTagUserRelateName
  extends MessageMicro<StTagUserRelateName>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "type", "tagNames" }, new Object[] { Integer.valueOf(1), "" }, StTagUserRelateName.class);
  public final PBRepeatField<String> tagNames = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBEnumField type = PBField.initEnum(1);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     feedcloud.FeedCloudTagcategorysvr.StTagUserRelateName
 * JD-Core Version:    0.7.0.1
 */