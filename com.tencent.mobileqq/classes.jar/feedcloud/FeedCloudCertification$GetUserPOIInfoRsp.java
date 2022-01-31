package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class FeedCloudCertification$GetUserPOIInfoRsp
  extends MessageMicro<GetUserPOIInfoRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "schoolInfo" }, new Object[] { null, null }, GetUserPOIInfoRsp.class);
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public FeedCloudCertibase.SchoolBaseInfo schoolInfo = new FeedCloudCertibase.SchoolBaseInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     feedcloud.FeedCloudCertification.GetUserPOIInfoRsp
 * JD-Core Version:    0.7.0.1
 */