package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class FeedCloudCertibase$SchoolBaseInfo
  extends MessageMicro<SchoolBaseInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 42 }, new String[] { "id", "name", "category", "logo", "emailSuffix" }, new Object[] { "", "", Integer.valueOf(0), "", "" }, SchoolBaseInfo.class);
  public final PBInt32Field category = PBField.initInt32(0);
  public final PBStringField emailSuffix = PBField.initString("");
  public final PBStringField id = PBField.initString("");
  public final PBStringField logo = PBField.initString("");
  public final PBStringField name = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     feedcloud.FeedCloudCertibase.SchoolBaseInfo
 * JD-Core Version:    0.7.0.1
 */