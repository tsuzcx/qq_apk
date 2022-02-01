package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class FeedCloudTagbasesvr$StDelParentIndexReq
  extends MessageMicro<StDelParentIndexReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32 }, new String[] { "tagParentName", "categoryIndex", "tagIndex", "fakeDel" }, new Object[] { "", Integer.valueOf(0), Integer.valueOf(0), Boolean.valueOf(false) }, StDelParentIndexReq.class);
  public final PBInt32Field categoryIndex = PBField.initInt32(0);
  public final PBBoolField fakeDel = PBField.initBool(false);
  public final PBInt32Field tagIndex = PBField.initInt32(0);
  public final PBStringField tagParentName = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     feedcloud.FeedCloudTagbasesvr.StDelParentIndexReq
 * JD-Core Version:    0.7.0.1
 */