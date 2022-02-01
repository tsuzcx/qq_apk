package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class FeedCloudTagsyncsearch$StTagSyncSearchInfo
  extends MessageMicro<StTagSyncSearchInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "tagName", "tagOperate" }, new Object[] { "", Integer.valueOf(1) }, StTagSyncSearchInfo.class);
  public final PBStringField tagName = PBField.initString("");
  public final PBEnumField tagOperate = PBField.initEnum(1);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     feedcloud.FeedCloudTagsyncsearch.StTagSyncSearchInfo
 * JD-Core Version:    0.7.0.1
 */