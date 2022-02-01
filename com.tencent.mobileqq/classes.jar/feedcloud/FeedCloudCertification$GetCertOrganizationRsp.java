package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class FeedCloudCertification$GetCertOrganizationRsp
  extends MessageMicro<GetCertOrganizationRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "orgnaizationList" }, new Object[] { null, null }, GetCertOrganizationRsp.class);
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public final PBRepeatMessageField<FeedCloudCertification.CertOrganizationDetail> orgnaizationList = PBField.initRepeatMessage(FeedCloudCertification.CertOrganizationDetail.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     feedcloud.FeedCloudCertification.GetCertOrganizationRsp
 * JD-Core Version:    0.7.0.1
 */