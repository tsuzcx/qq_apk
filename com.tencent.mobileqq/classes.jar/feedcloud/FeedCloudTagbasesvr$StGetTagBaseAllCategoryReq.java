package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class FeedCloudTagbasesvr$StGetTagBaseAllCategoryReq
  extends MessageMicro<StGetTagBaseAllCategoryReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "tagName", "useCache" }, new Object[] { "", Boolean.valueOf(false) }, StGetTagBaseAllCategoryReq.class);
  public final PBStringField tagName = PBField.initString("");
  public final PBBoolField useCache = PBField.initBool(false);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     feedcloud.FeedCloudTagbasesvr.StGetTagBaseAllCategoryReq
 * JD-Core Version:    0.7.0.1
 */