package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class FeedCloudCertification$UpdateStudentInfoReq
  extends MessageMicro<UpdateStudentInfoReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "studentInfo" }, new Object[] { null, null }, UpdateStudentInfoReq.class);
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public FeedCloudCertibase.StudentInfo studentInfo = new FeedCloudCertibase.StudentInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     feedcloud.FeedCloudCertification.UpdateStudentInfoReq
 * JD-Core Version:    0.7.0.1
 */