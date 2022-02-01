package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class FeedCloudCertification$GetUserCertificationReq
  extends MessageMicro<GetUserCertificationReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32, 40 }, new String[] { "extInfo", "certFlag", "hostUin", "statusFlag", "needDetail" }, new Object[] { null, Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0) }, GetUserCertificationReq.class);
  public final PBInt32Field certFlag = PBField.initInt32(0);
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public final PBStringField hostUin = PBField.initString("");
  public final PBInt32Field needDetail = PBField.initInt32(0);
  public final PBInt32Field statusFlag = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     feedcloud.FeedCloudCertification.GetUserCertificationReq
 * JD-Core Version:    0.7.0.1
 */