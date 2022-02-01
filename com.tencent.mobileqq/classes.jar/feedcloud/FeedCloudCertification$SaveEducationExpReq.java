package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class FeedCloudCertification$SaveEducationExpReq
  extends MessageMicro<SaveEducationExpReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "eduExp" }, new Object[] { null, null }, SaveEducationExpReq.class);
  public FeedCloudCertibase.EducationExp eduExp = new FeedCloudCertibase.EducationExp();
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     feedcloud.FeedCloudCertification.SaveEducationExpReq
 * JD-Core Version:    0.7.0.1
 */