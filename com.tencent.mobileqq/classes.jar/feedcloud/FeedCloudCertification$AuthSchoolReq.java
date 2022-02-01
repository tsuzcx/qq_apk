package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class FeedCloudCertification$AuthSchoolReq
  extends MessageMicro<AuthSchoolReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34 }, new String[] { "extInfo", "idx", "certiData", "gpsInfo" }, new Object[] { null, Integer.valueOf(0), null, null }, AuthSchoolReq.class);
  public FeedCloudCertibase.StudentCertification certiData = new FeedCloudCertibase.StudentCertification();
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public FeedCloudMeta.StGPSV2 gpsInfo = new FeedCloudMeta.StGPSV2();
  public final PBUInt32Field idx = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     feedcloud.FeedCloudCertification.AuthSchoolReq
 * JD-Core Version:    0.7.0.1
 */