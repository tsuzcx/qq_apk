package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class FeedCloudTagbasesvr$StAddTagBaseInfoReq
  extends MessageMicro<StAddTagBaseInfoReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "tagParentName", "tagName" }, new Object[] { "", "" }, StAddTagBaseInfoReq.class);
  public final PBStringField tagName = PBField.initString("");
  public final PBStringField tagParentName = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     feedcloud.FeedCloudTagbasesvr.StAddTagBaseInfoReq
 * JD-Core Version:    0.7.0.1
 */