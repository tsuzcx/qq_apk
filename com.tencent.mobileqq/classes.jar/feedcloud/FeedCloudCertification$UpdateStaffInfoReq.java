package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class FeedCloudCertification$UpdateStaffInfoReq
  extends MessageMicro<UpdateStaffInfoReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "extInfo", "staffInfo", "certID" }, new Object[] { null, null, "" }, UpdateStaffInfoReq.class);
  public final PBStringField certID = PBField.initString("");
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public FeedCloudCertibase.StaffInfo staffInfo = new FeedCloudCertibase.StaffInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     feedcloud.FeedCloudCertification.UpdateStaffInfoReq
 * JD-Core Version:    0.7.0.1
 */