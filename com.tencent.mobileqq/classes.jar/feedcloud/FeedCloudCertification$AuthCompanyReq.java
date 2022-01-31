package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class FeedCloudCertification$AuthCompanyReq
  extends MessageMicro<AuthCompanyReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "staffInfo" }, new Object[] { null, null }, AuthCompanyReq.class);
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public FeedCloudCertibase.StaffInfo staffInfo = new FeedCloudCertibase.StaffInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     feedcloud.FeedCloudCertification.AuthCompanyReq
 * JD-Core Version:    0.7.0.1
 */