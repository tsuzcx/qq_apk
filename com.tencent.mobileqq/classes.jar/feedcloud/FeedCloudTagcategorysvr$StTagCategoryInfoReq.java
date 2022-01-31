package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

public final class FeedCloudTagcategorysvr$StTagCategoryInfoReq
  extends MessageMicro<StTagCategoryInfoReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "TagNames", "ReqType" }, new Object[] { "", Integer.valueOf(0) }, StTagCategoryInfoReq.class);
  public final PBEnumField ReqType = PBField.initEnum(0);
  public final PBRepeatField<String> TagNames = PBField.initRepeat(PBStringField.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     feedcloud.FeedCloudTagcategorysvr.StTagCategoryInfoReq
 * JD-Core Version:    0.7.0.1
 */