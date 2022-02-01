package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class FeedCloudCertification$VerifySchoolPOIInfoReq
  extends MessageMicro<VerifySchoolPOIInfoReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "extInfo", "gpsInfo", "schoolInfo" }, new Object[] { null, null, null }, VerifySchoolPOIInfoReq.class);
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public FeedCloudMeta.StGPSV2 gpsInfo = new FeedCloudMeta.StGPSV2();
  public FeedCloudCertibase.SchoolBaseInfo schoolInfo = new FeedCloudCertibase.SchoolBaseInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     feedcloud.FeedCloudCertification.VerifySchoolPOIInfoReq
 * JD-Core Version:    0.7.0.1
 */