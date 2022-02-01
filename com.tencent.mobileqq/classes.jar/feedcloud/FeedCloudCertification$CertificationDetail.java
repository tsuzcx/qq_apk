package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class FeedCloudCertification$CertificationDetail
  extends MessageMicro<CertificationDetail>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 50, 56 }, new String[] { "type", "status", "optime", "studentInfo", "staffInfo", "certID", "source" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), null, null, "", Integer.valueOf(0) }, CertificationDetail.class);
  public final PBStringField certID = PBField.initString("");
  public final PBInt64Field optime = PBField.initInt64(0L);
  public final PBInt32Field source = PBField.initInt32(0);
  public FeedCloudCertibase.StaffInfo staffInfo = new FeedCloudCertibase.StaffInfo();
  public final PBInt32Field status = PBField.initInt32(0);
  public FeedCloudCertibase.StudentInfo studentInfo = new FeedCloudCertibase.StudentInfo();
  public final PBInt32Field type = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     feedcloud.FeedCloudCertification.CertificationDetail
 * JD-Core Version:    0.7.0.1
 */