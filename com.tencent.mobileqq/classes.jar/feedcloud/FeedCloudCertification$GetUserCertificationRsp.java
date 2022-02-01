package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class FeedCloudCertification$GetUserCertificationRsp
  extends MessageMicro<GetUserCertificationRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "certList" }, new Object[] { null, null }, GetUserCertificationRsp.class);
  public final PBRepeatMessageField<FeedCloudCertification.CertificationDetail> certList = PBField.initRepeatMessage(FeedCloudCertification.CertificationDetail.class);
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     feedcloud.FeedCloudCertification.GetUserCertificationRsp
 * JD-Core Version:    0.7.0.1
 */