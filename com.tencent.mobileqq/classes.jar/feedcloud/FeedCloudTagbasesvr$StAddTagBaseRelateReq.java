package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class FeedCloudTagbasesvr$StAddTagBaseRelateReq
  extends MessageMicro<StAddTagBaseRelateReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "tagName", "tagRelateName", "relateType" }, new Object[] { "", "", Integer.valueOf(0) }, StAddTagBaseRelateReq.class);
  public final PBEnumField relateType = PBField.initEnum(0);
  public final PBStringField tagName = PBField.initString("");
  public final PBStringField tagRelateName = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     feedcloud.FeedCloudTagbasesvr.StAddTagBaseRelateReq
 * JD-Core Version:    0.7.0.1
 */