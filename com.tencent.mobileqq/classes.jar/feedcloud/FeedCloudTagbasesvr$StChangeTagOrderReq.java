package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class FeedCloudTagbasesvr$StChangeTagOrderReq
  extends MessageMicro<StChangeTagOrderReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "tagParentName", "tagName", "orderChange" }, new Object[] { "", "", Integer.valueOf(0) }, StChangeTagOrderReq.class);
  public final PBInt32Field orderChange = PBField.initInt32(0);
  public final PBStringField tagName = PBField.initString("");
  public final PBStringField tagParentName = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     feedcloud.FeedCloudTagbasesvr.StChangeTagOrderReq
 * JD-Core Version:    0.7.0.1
 */