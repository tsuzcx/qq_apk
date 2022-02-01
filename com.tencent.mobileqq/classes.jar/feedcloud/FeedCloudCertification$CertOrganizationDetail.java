package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class FeedCloudCertification$CertOrganizationDetail
  extends MessageMicro<CertOrganizationDetail>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34 }, new String[] { "id", "type", "schoolInfo", "companyInfo" }, new Object[] { "", Integer.valueOf(0), null, null }, CertOrganizationDetail.class);
  public FeedCloudCertibase.CompanyBaseInfo companyInfo = new FeedCloudCertibase.CompanyBaseInfo();
  public final PBStringField id = PBField.initString("");
  public FeedCloudCertibase.SchoolBaseInfo schoolInfo = new FeedCloudCertibase.SchoolBaseInfo();
  public final PBInt32Field type = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     feedcloud.FeedCloudCertification.CertOrganizationDetail
 * JD-Core Version:    0.7.0.1
 */