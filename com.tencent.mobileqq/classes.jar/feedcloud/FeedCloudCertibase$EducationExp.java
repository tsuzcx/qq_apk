package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class FeedCloudCertibase$EducationExp
  extends MessageMicro<EducationExp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40, 48 }, new String[] { "schoolInfo", "collegeID", "collegeName", "degree", "enrollmentYear", "idx" }, new Object[] { null, "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, EducationExp.class);
  public final PBStringField collegeID = PBField.initString("");
  public final PBStringField collegeName = PBField.initString("");
  public final PBInt32Field degree = PBField.initInt32(0);
  public final PBUInt32Field enrollmentYear = PBField.initUInt32(0);
  public final PBUInt32Field idx = PBField.initUInt32(0);
  public FeedCloudCertibase.SchoolBaseInfo schoolInfo = new FeedCloudCertibase.SchoolBaseInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     feedcloud.FeedCloudCertibase.EducationExp
 * JD-Core Version:    0.7.0.1
 */