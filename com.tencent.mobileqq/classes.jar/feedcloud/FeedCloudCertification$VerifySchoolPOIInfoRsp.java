package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class FeedCloudCertification$VerifySchoolPOIInfoRsp
  extends MessageMicro<VerifySchoolPOIInfoRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "extInfo", "result" }, new Object[] { null, Integer.valueOf(0) }, VerifySchoolPOIInfoRsp.class);
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public final PBInt32Field result = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     feedcloud.FeedCloudCertification.VerifySchoolPOIInfoRsp
 * JD-Core Version:    0.7.0.1
 */